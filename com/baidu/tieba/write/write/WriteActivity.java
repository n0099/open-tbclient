package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.util.ArrayMap;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.e.a.a;
import com.baidu.mapapi.UIMsg;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.ImageProblemActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.p;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.b.c;
import com.baidu.tieba.write.h;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0042a, VoiceManager.c, t.a, h.a {
    private static int jtP = 0;
    private EditorTools ciA;
    private String ckc;
    private LocationModel ckd;
    private NewWriteModel cke;
    private VoiceManager eYR;
    private LinearLayout hrr;
    private PlayVoiceBntNew hrs;
    private ImageView hru;
    private boolean isPrivacy;
    private TextView iwL;
    private com.baidu.tieba.write.h iwM;
    private ImageView iwN;
    private View iwO;
    private int iwo;
    private com.baidu.tieba.write.b.c jqJ;
    private LinearLayout jsB;
    private LinearLayout jsC;
    private View jsE;
    private Toast jsG;
    private AdditionData jsH;
    private RelativeLayout jsI;
    private TextView jsJ;
    private TextView jsK;
    private TextView jsL;
    List<v> jsM;
    v jsN;
    private int jsO;
    private String jsP;
    private int jsQ;
    private PostCategoryView jsR;
    private HotTopicBussinessData jsU;
    private TextView jsV;
    private com.baidu.tieba.write.editor.b jsX;
    private View jtT;
    private View jtU;
    private TextView jtV;
    private com.baidu.tieba.c.d jtX;
    private e jta;
    private com.baidu.tieba.view.b jth;
    private View jtq;
    private g jtx;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String jsy = "";
    private boolean jsz = false;
    private WriteData mData = null;
    private boolean jtm = false;
    private boolean jsA = false;
    private boolean jtn = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText iwG = null;
    private HeadImageView jto = null;
    private View iwH = null;
    private LinearLayout iwJ = null;
    private EditText iwK = null;
    private FeedBackModel jsD = null;
    private FeedBackTopListView jtp = null;
    private ArrayList<WritePrefixItemLayout> jsF = new ArrayList<>();
    private String gPw = null;
    private final KeyEvent eHC = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View bVZ = null;
    private TextView jtr = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a jts = null;
    private final Handler mHandler = new Handler();
    private boolean jtt = false;
    private String jtu = null;
    private RelativeLayout mParent = null;
    private String cki = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int ckj = 0;
    private int jtv = 0;
    private WriteImagesInfo jtw = new WriteImagesInfo();
    private View mRootView = null;
    private GridView jty = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a jtz = null;
    private ScrollView jsS = null;
    private EditText jtA = null;
    private View jtB = null;
    private View jtC = null;
    private View jtD = null;
    private EditText jtE = null;
    private TextView jtF = null;
    private TextView jtG = null;
    private TextWatcher jtH = null;
    private TextWatcher jtI = null;
    private boolean jsT = false;
    private boolean jtJ = false;
    private com.baidu.tbadk.core.view.b csK = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private File jtK = null;
    private TbImageView jtL = null;
    private View jtM = null;
    private Dialog jtN = null;
    private LinearLayout jtO = null;
    private boolean jtQ = false;
    private long jtR = -1000;
    private boolean jtS = false;
    private String fxu = "2";
    private int jmO = 0;
    private String mTopicId = "";
    private SpannableStringBuilder jsW = new SpannableStringBuilder();
    private boolean jtW = false;
    private boolean jsY = false;
    private final b jsZ = new b();
    private final HttpMessageListener jtY = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.gPw)) {
                    WriteActivity.this.gPw = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.rj(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.gPw)) {
                    WriteActivity.this.gPw = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.gPw);
                    WriteActivity.this.rj(true);
                }
            }
        }
    };
    private TbFaceManager.a jtb = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan pe(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.oy());
            int width = aVar.getWidth();
            if (str.startsWith("#(meme,")) {
                bitmapDrawable.setBounds(0, 0, width, aVar.getHeight());
            } else {
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            return new com.baidu.tbadk.core.view.g(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a fad = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLk));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLk));
        }
    };
    private final NewWriteModel.d cks = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.bcM();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.jsZ.aE(null);
                if (z) {
                    WriteActivity.this.eP(z);
                    if (WriteActivity.this.d(writeData)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    if (WriteActivity.this.mData.getType() != 0 && WriteActivity.this.mData.getType() != 9) {
                        if (WriteActivity.this.mData.getType() != 7) {
                            if (WriteActivity.this.mData.getType() == 1) {
                                t.d(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.mData.getType() == 5) {
                                t.d(WriteActivity.this.mData.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            t.c("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            t.c(WriteActivity.this.mData.getForumId(), (WriteData) null);
                        }
                        if (!com.baidu.tbadk.core.util.v.T(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                            TiebaStatic.log(new am("c11731").bJ(VideoPlayActivityConfig.OBJ_ID, WriteActivity.this.mTopicId));
                        }
                    }
                    WriteActivity.this.k(postWriteCallBackData);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    WriteActivity.this.setResult(-1, intent);
                    WriteActivity.this.finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    WriteActivity.this.showToast(postWriteCallBackData.getErrorString());
                    WriteActivity.this.jsZ.aE(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.jsZ.Ej(postWriteCallBackData.getErrorString());
                    WriteActivity.this.jsZ.b(WriteActivity.this.iwG, WriteActivity.this.iwK);
                } else if ((xVar == null || writeData == null || xVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (xVar != null && writeData != null && xVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.agE());
                    if (com.baidu.tbadk.u.a.pT(xVar.agD())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, xVar.agD());
                        if (WriteActivity.this.jtn) {
                            newVcodeActivityConfig.setHideFeedBackButton();
                        }
                        WriteActivity.this.sendMessage(new CustomMessage(2002001, newVcodeActivityConfig));
                        return;
                    }
                    WriteActivity.this.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    WriteActivity.this.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(WriteActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a ckq = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.40
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void amJ() {
            WriteActivity.this.showToast(d.j.no_network_guide);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void onFail(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(d.j.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.ceW())) {
                WriteActivity.this.b(2, true, aVar.ceW());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener iIv = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.WriteActivity.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.ckd.qb(false);
                    WriteActivity.this.ckd.dZ(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.ckd.qb(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener jtc = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener jtd = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.43
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cqv = WriteActivity.this.cqv();
            if (cqv >= 0 && cqv < WriteActivity.this.iwK.getText().length()) {
                WriteActivity.this.iwK.setSelection(cqv);
            }
        }
    };
    private boolean jte = true;
    private final View.OnFocusChangeListener iwE = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.iwG || view == WriteActivity.this.bVZ || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.jte = true;
                    WriteActivity.this.cqw();
                    l.c(WriteActivity.this.getActivity(), WriteActivity.this.iwG);
                    if (WriteActivity.this.ciA != null) {
                        WriteActivity.this.ciA.akp();
                    }
                } else if (view == WriteActivity.this.iwG) {
                    WriteActivity.this.iwL.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.iwK && z) {
                WriteActivity.this.jte = false;
                WriteActivity.this.cqw();
                l.c(WriteActivity.this.getActivity(), WriteActivity.this.iwK);
                if (WriteActivity.this.ciA != null) {
                    WriteActivity.this.ciA.akp();
                }
            }
            WriteActivity.this.cqC();
        }
    };
    private TextWatcher jtf = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String jtj = "";
        private String jtk;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jtk = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jtk != null ? this.jtk.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cbt();
            WriteActivity.this.cqD();
            EditText cqO = WriteActivity.this.cqO();
            if (editable != null && cqO != null && cqO.getText() != null) {
                if (this.jtj == null || !this.jtj.equals(editable.toString())) {
                    if (WriteActivity.this.jsZ != null) {
                        this.jtj = cqO.getText().toString();
                        WriteActivity.this.jsZ.o(cqO);
                        return;
                    }
                    return;
                }
                cqO.setSelection(cqO.getSelectionEnd());
            }
        }
    };
    private TextWatcher jtg = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String jtk;
        private String jtl = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jtk = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jtk != null ? this.jtk.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cbt();
            EditText cqN = WriteActivity.this.cqN();
            if (editable != null && cqN != null && cqN.getText() != null) {
                if (this.jtl == null || !this.jtl.equals(editable.toString())) {
                    if (WriteActivity.this.jsZ != null) {
                        this.jtl = cqN.getText().toString();
                        WriteActivity.this.jsZ.o(cqN);
                        return;
                    }
                    return;
                }
                cqN.setSelection(cqN.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0388a hyb = new a.InterfaceC0388a() { // from class: com.baidu.tieba.write.write.WriteActivity.31
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0388a
        public void onRefresh() {
            WriteActivity.this.gPw = null;
            WriteActivity.this.rj(false);
            WriteActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.mFrom)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amu() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void amv() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            amx();
        } else if (this.ckd.cfd()) {
            amu();
        } else {
            this.ckd.qb(false);
            b(1, true, null);
            this.ckd.cfb();
        }
    }

    private void amx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.gD(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kY()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.ckd.aNJ();
                } else {
                    WriteActivity.this.ckq.amJ();
                }
                aVar2.dismiss();
            }
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.44
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.aaZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cqv() {
        int selectionEnd = cqN().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cqN().getText().getSpans(0, cqN().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cqN().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cqN().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqw() {
        if (this.ciA != null) {
            this.ciA.setBarLauncherEnabled(!this.jte);
            this.ciA.setBarLauncherEnabled(true, 26);
            this.ciA.setBarLauncherEnabled(true, 2);
            Q(9, this.jte ? false : true);
        }
    }

    private void Q(int i, boolean z) {
        com.baidu.tbadk.editortools.g jt;
        if (this.ciA != null && (jt = this.ciA.jt(i)) != null) {
            if (z) {
                jt.qT();
            } else {
                jt.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.jsT) {
            this.iwG.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.jtD.setVisibility(8);
            } else {
                this.jtD.setVisibility(0);
            }
            a(this.jtG, this.jtA);
            a(this.jtF, this.jtE);
            cbt();
        }
        if (this.jtm) {
            this.jte = true;
            cqw();
            if (this.ciA != null) {
                this.ciA.akp();
            }
            this.iwG.requestFocus();
            ShowSoftKeyPadDelay(this.iwG);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        String stringExtra;
        super.onNewIntent(intent);
        if (intent != null && (stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING")) != null && this.writeImagesInfo != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            crl();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                cqW();
            }
            rk(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        if (this.mData.getType() == 0) {
            Bz(this.jmO);
        }
        initUI();
        crb();
        this.ckd = new LocationModel(this);
        this.ckd.a(this.ckq);
        registerListener(this.iIv);
        registerListener(this.jtc);
        initEditor();
        crn();
        if (this.jsT) {
            this.jtz.setEditorTools(this.ciA);
        } else {
            this.iwK.requestFocus();
        }
        bXw();
        cqW();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.ciA = new EditorTools(getActivity());
        this.ciA.setBarMaxLauCount(5);
        this.ciA.setMoreButtonAtEnd(true);
        this.ciA.setBarLauncherType(1);
        this.ciA.eH(true);
        this.ciA.eI(true);
        this.ciA.setMoreLauncherIcon(d.f.write_more);
        this.ciA.setBackgroundColorId(d.C0277d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                cqZ();
                break;
            default:
                cqx();
                break;
        }
        this.ciA.alT();
        if (this.jsB != null) {
            this.jsB.addView(this.ciA);
        }
        cqy();
        this.ciA.qT();
        com.baidu.tbadk.editortools.g jt = this.ciA.jt(6);
        if (jt != null && !TextUtils.isEmpty(this.cki)) {
            ((View) jt).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.cki);
                }
            });
        }
        if (!this.jsT) {
            this.ciA.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.ciA.akp();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.ciA.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.ciA.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        cqA();
    }

    private void cqX() {
        this.jtB = this.mRootView.findViewById(d.g.photo_live_scroll);
        this.jtD = this.jtB.findViewById(d.g.live_post_title_container);
        this.jtA = (EditText) this.jtB.findViewById(d.g.live_post_content);
        this.jty = (GridView) this.jtB.findViewById(d.g.photoLiveGridView);
        this.jtE = (EditText) this.jtB.findViewById(d.g.live_post_title);
        this.jtF = (TextView) this.jtB.findViewById(d.g.titleOverPlusNumber);
        this.jtG = (TextView) this.jtB.findViewById(d.g.contentOverPlusNumber);
        this.jtC = this.jtB.findViewById(d.g.live_interval_view);
        this.jtF.setText(String.valueOf(20));
        this.jtG.setText(String.valueOf(233));
        this.jtB.setVisibility(0);
        this.jtF.setVisibility(0);
        this.jtG.setVisibility(0);
        this.jtE.setHint(d.j.tips_title_limit_new);
        this.jtE.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.jtJ = true;
                    WriteActivity.this.jte = true;
                    WriteActivity.this.cqw();
                    if (WriteActivity.this.ciA != null) {
                        WriteActivity.this.ciA.akp();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.jtA.setHint(d.j.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.jtA.setHint(d.j.live_write_input_content_update);
        }
        this.jtA.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.jtJ = false;
                    WriteActivity.this.jte = false;
                    WriteActivity.this.cqw();
                    if (WriteActivity.this.ciA != null) {
                        WriteActivity.this.ciA.akp();
                    }
                }
            }
        });
        this.jtA.requestFocus();
        this.jtA.addTextChangedListener(Cp());
        this.jtE.requestFocus();
        this.jtE.addTextChangedListener(Cp());
        this.jtE.setOnClickListener(this.jtd);
        this.jtA.setOnClickListener(this.jtd);
        this.jtz = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.jty);
        this.jtz.Bt(6);
        this.jty.setAdapter((ListAdapter) this.jtz);
        View findViewById = this.jtB.findViewById(d.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void cqg() {
                WriteActivity.this.crj();
            }
        });
        cqY();
    }

    private void cqY() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.jtE.setText(this.mData.getTitle());
                this.jtE.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.jsT) {
            crh();
        }
        if (this.ciA.alV()) {
            this.ciA.akp();
        }
        Bz(0);
    }

    private void Bz(int i) {
        if (this.writeImagesInfo != null && this.mData != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.fxu);
            sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void cqZ() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.ciA.ab(arrayList);
        com.baidu.tbadk.editortools.k jw = this.ciA.jw(5);
        if (jw != null) {
            jw.cjk = 2;
            jw.cji = d.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.cji = d.f.write_at;
        this.ciA.b(aVar);
        this.ciA.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void cqx() {
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        com.baidu.tbadk.editortools.k kVar3;
        com.baidu.tbadk.editortools.k kVar4;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.k kVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.cji = d.f.write_picture;
        this.ciA.b(dVar);
        Boolean crf = crf();
        if (!this.jtm && crf != null && crf.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.cfE() && p.b(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), com.baidu.tbadk.editortools.k.class)) != null && (kVar5 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar5.cjk = 3;
            kVar5.cji = d.f.write_recorder;
            this.ciA.b(kVar5);
        }
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        aVar.cji = d.f.icon_post_topic_selector;
        this.ciA.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001343, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask2 != null && (kVar4 = (com.baidu.tbadk.editortools.k) runTask2.getData()) != null) {
            kVar4.cjk = 5;
            kVar4.cji = d.f.write_privilege;
            this.ciA.b(kVar4);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask3 != null && (kVar3 = (com.baidu.tbadk.editortools.k) runTask3.getData()) != null) {
            kVar3.cjk = 6;
            kVar3.cji = this.jtm ? d.f.write_location : d.f.icon_post_more_location;
            this.ciA.b(kVar3);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 7);
        aVar2.cji = d.f.icon_post_more_at;
        this.ciA.b(aVar2);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask4 != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
            kVar2.cjm = true;
            kVar2.cjk = 9;
            kVar2.cji = 0;
            this.ciA.b(kVar2);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask5 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask5.getData()) != null) {
            kVar.cjm = true;
            kVar.cjk = 10;
            kVar.cji = 0;
            this.ciA.b(kVar);
        }
        if (this.jsH == null) {
            if (this.jsX == null) {
                this.jsX = new com.baidu.tieba.write.editor.b(getActivity(), this.fxu);
                this.jsX.bw(this.mData.getForumId(), this.privateThread);
            }
            this.ciA.b(this.jsX);
        }
        this.ciA.ab(arrayList);
        com.baidu.tbadk.editortools.k jw = this.ciA.jw(5);
        if (jw != null) {
            jw.cjk = 1;
            jw.cji = d.f.write_emotion;
        }
    }

    private void cqz() {
        if (this.jta != null) {
            this.jta.hideTip();
        }
    }

    private void cqA() {
        if (this.jta == null) {
            this.jta = new e(getPageContext());
        }
        this.jta.c(this.ciA);
    }

    private void cqy() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.cqM()) {
                            WriteActivity.this.showToast(d.j.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new am("c12612").T("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p)) {
                            com.baidu.tbadk.coreExtra.data.p pVar = (com.baidu.tbadk.coreExtra.data.p) aVar.data;
                            if (pVar.agt() == EmotionGroupType.BIG_EMOTION || pVar.agt() == EmotionGroupType.USER_COLLECT) {
                                if (WriteActivity.this.mCurrentPermissionJudgePolicy == null) {
                                    WriteActivity.this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                                }
                                WriteActivity.this.mCurrentPermissionJudgePolicy.adQ();
                                WriteActivity.this.mCurrentPermissionJudgePolicy.e(WriteActivity.this, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!WriteActivity.this.mCurrentPermissionJudgePolicy.Y(WriteActivity.this)) {
                                    if (WriteActivity.this.writeImagesInfo.size() >= WriteActivity.this.writeImagesInfo.getMaxImagesAllowed()) {
                                        WriteActivity.this.showToast(String.format(WriteActivity.this.getString(d.j.max_choose_image_count), Integer.valueOf(WriteActivity.this.writeImagesInfo.getMaxImagesAllowed())));
                                        return;
                                    }
                                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                                    imageFileInfo.setImageType(1);
                                    imageFileInfo.setFilePath(pVar.getName());
                                    imageFileInfo.width = pVar.getWidth();
                                    imageFileInfo.height = pVar.getHeight();
                                    WriteActivity.this.writeImagesInfo.addChooseFile(imageFileInfo);
                                    WriteActivity.this.writeImagesInfo.updateQuality();
                                    WriteActivity.this.rk(true);
                                    WriteActivity.this.cbt();
                                }
                            } else if (WriteActivity.this.cqM()) {
                                WriteActivity.this.showToast(d.j.over_limit_tip);
                            } else {
                                WriteActivity.this.e(pVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.cqP();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bKL();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.crl();
                        WriteActivity.this.cbt();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.BA(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new am("c12612").T("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.jsH == null) {
                            WriteActivity.this.amy();
                            return;
                        }
                        switch (WriteActivity.this.ckj) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.cR(pageActivity)) {
                                    WriteActivity.this.amv();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.amu();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.ckd != null) {
                            WriteActivity.this.ckd.qb(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.gPw = null;
                        } else {
                            WriteActivity.this.gPw = (String) aVar.data;
                        }
                        WriteActivity.this.rj(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        am amVar = new am("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        amVar.bJ(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(amVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.ciA.alV()) {
                                        WriteActivity.this.ciA.akp();
                                        WriteActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(WriteActivity.this.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(d.j.plugin_video_not_active), WriteActivity.this.getResources().getString(d.j.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(d.j.plugin_video_install_tips), WriteActivity.this.getResources().getString(d.j.plugin_go_install));
                            return;
                        }
                        WriteActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.cbt();
                        if (WriteActivity.this.iwK != null) {
                            WriteActivity.this.iwK.requestFocus();
                        }
                        WriteActivity.this.ciA.akp();
                        WriteActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iwK);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new am("c12612").T("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.jsz = true;
                        WriteActivity.this.rh(true);
                        if (!WriteActivity.this.cqO().isFocused() || WriteActivity.this.jsC.getVisibility() != 0) {
                            WriteActivity.this.jsy = "from_content";
                        } else {
                            WriteActivity.this.jsy = "from_title";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.jsC.setVisibility(0);
                        WriteActivity.this.jsC.requestFocus();
                        WriteActivity.this.cbt();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.jsC.hasFocus()) {
                            WriteActivity.this.iwK.requestFocus();
                            WriteActivity.this.iwK.setSelection(WriteActivity.this.iwK.getText().toString().length());
                        }
                        WriteActivity.this.jsC.setVisibility(8);
                        WriteActivity.this.cbt();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.ciA.setActionListener(16, bVar);
        this.ciA.setActionListener(14, bVar);
        this.ciA.setActionListener(24, bVar);
        this.ciA.setActionListener(3, bVar);
        this.ciA.setActionListener(10, bVar);
        this.ciA.setActionListener(11, bVar);
        this.ciA.setActionListener(12, bVar);
        this.ciA.setActionListener(13, bVar);
        this.ciA.setActionListener(15, bVar);
        this.ciA.setActionListener(18, bVar);
        this.ciA.setActionListener(20, bVar);
        this.ciA.setActionListener(25, bVar);
        this.ciA.setActionListener(27, bVar);
        this.ciA.setActionListener(29, bVar);
        this.ciA.setActionListener(43, bVar);
        this.ciA.setActionListener(45, bVar);
        this.ciA.setActionListener(53, bVar);
        this.ciA.setActionListener(48, bVar);
        this.ciA.setActionListener(46, bVar);
        this.ciA.setActionListener(49, bVar);
        this.ciA.setActionListener(47, bVar);
        this.ciA.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BA(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amy() {
        if (this.ckd.aNF()) {
            if (this.ckd.cfd()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.ceZ().getLocationData().ceW());
                return;
            }
            b(1, true, null);
            this.ckd.cfb();
            return;
        }
        b(0, true, null);
    }

    protected void cbl() {
        if (this.cke != null) {
            this.cke.cancelLoadData();
        }
        if (this.jsD != null) {
            this.jsD.cancelLoadData();
        }
        if (this.ckd != null) {
            this.ckd.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cqz();
        TiebaPrepareImageService.StopService();
        cbl();
        cre();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.jtx != null) {
            this.jtx.destroy();
        }
        if (this.jtX != null) {
            this.jtX.aSr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqB() {
        if (this.mData != null && this.mData.getType() == 2 && this.jtt) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(cqO().getText().toString());
            this.mData.setContent(cqN().getText().toString());
            int type = this.mData.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    t.c(this.mData.getForumId(), this.mData);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    t.c("24591571", this.mData);
                }
            } else if (type == 1) {
                t.d(this.mData.getThreadId(), this.mData);
            } else if (type == 4) {
                t.c(this.mData.getForumId() + "photolive", this.mData);
            } else if (type == 5) {
                t.d(this.mData.getThreadId() + "updatephotolive", this.mData);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.iwM != null && this.iwM.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.iwM, getPageContext().getPageActivity());
                return true;
            } else if (this.ciA.alV()) {
                this.ciA.akp();
                return true;
            } else {
                cbl();
                cqB();
                return true;
            }
        }
        if (i == 67 && (text = cqN().getText()) != null) {
            int selectionStart = cqN().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cqN().onKeyDown(67, this.eHC);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mParent);
        getLayoutMode().onModeChanged(this.jtO);
        if (this.jtL != null && i == 1) {
            this.jtL.setBorderColor(al.getColor(d.C0277d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.d(this.mPost, d.C0277d.cp_link_tip_a, 1);
        cqw();
        al.l(this.jtB, d.C0277d.cp_bg_line_d);
        al.l(this.iwH, d.C0277d.cp_bg_line_c);
        al.l(this.jtC, d.C0277d.cp_bg_line_c);
        al.l(cqO(), d.C0277d.cp_bg_line_d);
        al.c(this.hru, d.f.icon_edit_close_n);
        if (TextUtils.isEmpty(this.gPw)) {
            al.l(cqN(), d.C0277d.cp_bg_line_d);
        }
        cbt();
        this.ciA.onChangeSkinType(i);
        if (this.jsR != null) {
            this.jsR.aeK();
        }
        al.j(this.mName, d.C0277d.cp_cont_b);
        cqC();
        cqD();
        if (this.jsZ != null) {
            this.jsZ.c(cqO(), cqN());
        }
        this.jqJ.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqC() {
        if (this.iwG.hasFocus()) {
            this.iwG.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        } else {
            this.iwG.setHintTextColor(al.getColor(d.C0277d.cp_cont_d));
        }
        if (this.iwK.hasFocus()) {
            this.iwK.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        } else {
            this.iwK.setHintTextColor(al.getColor(d.C0277d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqD() {
        if (this.iwG != null && this.iwG.getText() != null && this.iwG.getText().toString() != null && this.iwG.getPaint() != null) {
            if (this.iwG.getText().toString().length() == 0) {
                this.iwG.getPaint().setFakeBoldText(false);
            } else if (this.iwG.getText().toString().length() > 0) {
                this.iwG.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.csK = new com.baidu.tbadk.core.view.b(getPageContext());
        this.jsT = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.bVZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        al.j(this.mName, d.C0277d.cp_cont_b);
        this.jtr = (TextView) findViewById(d.g.btn_image_problem);
        cqF();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.iwE);
        this.jsS = (ScrollView) findViewById(d.g.write_scrollview);
        this.jsS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.iwK != null) {
                        l.b(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.iwK);
                    }
                    if (WriteActivity.this.ciA != null) {
                        WriteActivity.this.ciA.akp();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jtp = (FeedBackTopListView) findViewById(d.g.feedback_top_list);
        this.jtq = findViewById(d.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.jsB = (LinearLayout) findViewById(d.g.tool_view);
        this.jsB.setContentDescription("..");
        this.jsC = (LinearLayout) findViewById(d.g.title_view);
        this.iwH = findViewById(d.g.interval_view);
        this.jtT = findViewById(d.g.hot_topic_fourm_view);
        this.jtU = findViewById(d.g.hot_topic_divider);
        this.jsV = (TextView) findViewById(d.g.hot_topic_title_edt);
        this.jtV = (TextView) findViewById(d.g.change_one_tv);
        cbs();
        if (this.jsT) {
            this.jsS.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            cqX();
        } else {
            this.jtx = new g(getPageContext(), this.mRootView);
            g gVar = this.jtx;
            if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                z = false;
            }
            gVar.rc(z);
        }
        cbu();
        if (this.jtm || this.jsA) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().bLV) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.iwJ = (LinearLayout) findViewById(d.g.post_content_container);
        this.iwJ.setDrawingCacheEnabled(false);
        this.iwJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.iwK.requestFocus();
            }
        });
        this.hrr = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.hrs = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.hru = (ImageView) findViewById(d.g.iv_delete_voice);
        this.hru.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bKL();
            }
        });
        this.bVZ.setOnFocusChangeListener(this.iwE);
        this.bVZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cbl();
                WriteActivity.this.cqB();
            }
        });
        this.jtr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        cqI();
        l(crf());
        cqK();
        cqE();
        crc();
        crd();
        cqw();
        cqJ();
        cbr();
        cqQ();
        if (this.mData.getType() == 4 && this.iwO != null && this.jsE != null) {
            this.iwO.setVisibility(8);
            this.jsE.setVisibility(8);
        }
        cbt();
        cra();
        cpM();
    }

    private void cpM() {
        this.jqJ = new com.baidu.tieba.write.b.c(getPageContext().getPageActivity(), this.mName, this.mData.getProZone(), isUseStyleImmersiveSticky() ? StatusBarUtil.getStatusBarOffsetPx(getPageContext().getPageActivity()) : 0);
        this.jqJ.a(new c.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // com.baidu.tieba.write.b.c.a
            public void Bo(int i) {
                WriteActivity.this.mData.setProZone(i);
            }
        });
        this.jqJ.aWF();
    }

    private void cqE() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.jtm || this.jsA) {
                        if (this.jtn) {
                            this.mName.setText(d.j.feedback_vcode);
                        } else {
                            this.mName.setText(d.j.feedback);
                        }
                    } else if (this.fxu != null && this.fxu.equals("1")) {
                        this.mName.setText(d.j.post_to_home_page);
                    } else if (this.fxu != null && this.fxu.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(d.j.post_to) + this.mData.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(d.j.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(d.j.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.iwG.setVisibility(0);
                    this.iwK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(d.j.send_reply);
                    this.iwK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.iwG.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(d.j.publish_photo_live);
                    this.iwK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(d.j.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.jtC.setVisibility(8);
                    return;
                case 7:
                    this.iwG.setVisibility(0);
                    this.iwK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    this.mName.setText(d.j.post_drift_bottle);
                    return;
            }
        }
    }

    private void cqF() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
    }

    private void cqG() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.jtm && !this.jsA && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String f = ap.f(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(f) && cqO() != null) {
                cqO().setText(f);
                cqO().setSelection(f.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.hrr.setVisibility(0);
            this.hrs.setVoiceModel(voiceModel);
            this.hrs.cfD();
            cbt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKL() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.bo(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.hrr.setVisibility(8);
        this.hrs.boo();
        this.hrs.setVoiceModel(null);
        com.baidu.tbadk.editortools.k jw = this.ciA.jw(6);
        if (jw != null && jw.ciu != null) {
            jw.ciu.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cbt();
    }

    private void cqH() {
        this.jsM = null;
        this.jsO = -1;
        this.jsQ = -1;
        com.baidu.tieba.frs.x qp = w.bej().qp(1);
        if (qp != null) {
            this.jsM = qp.fcE;
            this.jsO = getIntent().getIntExtra("category_id", -1);
            if (this.jsM != null && !this.jsM.isEmpty() && this.jsO >= 0) {
                this.jsN = new v();
                this.jsN.fcA = 0;
                this.jsN.name = getPageContext().getResources().getString(d.j.category_auto);
                this.jsQ = this.jsN.fcA;
                this.jsP = this.jsN.name;
                for (v vVar : this.jsM) {
                    if (vVar.fcA == this.jsO) {
                        this.jsQ = vVar.fcA;
                        this.jsP = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cqI() {
        if (this.jsM != null && !this.jsM.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.jsR = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.jsR.setText(this.jsP);
            this.jsR.setCategoryContainerData(this.jsM, this.jsN, this.jsQ);
            this.jsR.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ar arVar) {
                    if (arVar != null) {
                        WriteActivity.this.jsR.setText(arVar.name);
                        WriteActivity.this.mData.setCategoryTo(arVar.fcA);
                        WriteActivity.this.jsQ = arVar.fcA;
                        WriteActivity.this.jsR.cqj();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.jsR.cqi();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cqO());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cqN());
                }
            });
        }
    }

    private void cra() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.jth = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.jth.setTitle(d.j.no_disturb_start_time);
        this.jth.setButton(-1, getPageContext().getString(d.j.alert_yes_button), this.jth);
        this.jth.setButton(-2, getPageContext().getString(d.j.cancel), this.jth);
        return this.jth;
    }

    private void cqJ() {
        this.jsI = (RelativeLayout) findViewById(d.g.addition_container);
        this.jsJ = (TextView) findViewById(d.g.addition_create_time);
        this.jsK = (TextView) findViewById(d.g.addition_last_time);
        this.jsL = (TextView) findViewById(d.g.addition_last_content);
        if (this.jsH != null) {
            this.jsI.setVisibility(0);
            this.jsJ.setText(getPageContext().getString(d.j.write_addition_create) + ap.ao(this.jsH.getCreateTime() * 1000));
            if (this.jsH.getAlreadyCount() == 0) {
                this.jsK.setVisibility(8);
            } else {
                this.jsK.setText(getPageContext().getString(d.j.write_addition_last) + ap.ao(this.jsH.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.jsH.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.jsL.setText(lastAdditionContent);
            } else {
                this.jsL.setVisibility(8);
            }
            cqN().setHint(String.format(getPageContext().getString(d.j.write_addition_hint), Integer.valueOf(this.jsH.getAlreadyCount()), Integer.valueOf(this.jsH.getTotalCount())));
            this.mName.setText(d.j.write_addition_title);
            return;
        }
        this.jsI.setVisibility(8);
    }

    private void cbr() {
        this.iwO = findViewById(d.g.post_prefix_layout);
        if (this.jtX == null) {
            this.jtX = new com.baidu.tieba.c.d(getPageContext(), this.iwO);
            this.jtX.oK(d.f.bg_tip_blue_up_left);
            this.jtX.oJ(16);
            this.jtX.id(true);
            this.jtX.aa(true);
            this.jtX.oN(l.h(getActivity(), d.e.ds32));
        }
        this.iwL = (TextView) findViewById(d.g.post_prefix);
        this.jsE = findViewById(d.g.prefix_divider);
        this.iwN = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.iwO.setVisibility(0);
            this.jtX.s(getString(d.j.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iwo = 0;
            this.iwO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c13013").bJ(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).k("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.iwL.setVisibility(0);
                    WriteActivity.this.iwO.setSelected(true);
                    al.c(WriteActivity.this.iwN, d.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.iwM, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.ciA.akp();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iwG);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iwK);
                }
            });
            this.iwL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c13013").bJ(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).k("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.iwL.setSelected(true);
                    al.c(WriteActivity.this.iwN, d.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.iwM, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.ciA.akp();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cqO());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cqN());
                }
            });
            this.iwM = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.iwM.a(this);
            this.iwM.setMaxHeight(l.h(getActivity(), d.e.ds510));
            this.iwM.setOutsideTouchable(true);
            this.iwM.setFocusable(true);
            this.iwM.setOnDismissListener(this);
            this.iwM.setBackgroundDrawable(al.getDrawable(d.C0277d.cp_bg_line_d));
            int color = al.getColor(d.C0277d.cp_cont_b);
            al.getColor(d.C0277d.cp_cont_c);
            al.k(this.iwL, d.C0277d.cp_bg_line_d);
            al.c(this.iwN, d.f.icon_arrow_gray_down);
            this.iwL.setTextColor(color);
            this.jsF.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.jsF.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.qX(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.qX(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.iwM.addView(writePrefixItemLayout);
            }
            this.iwM.setCurrentIndex(0);
            this.iwL.setText(prefixs.get(0));
            By(0);
            return;
        }
        this.iwO.setVisibility(8);
    }

    private void crb() {
        if (this.jtm && this.mData != null) {
            this.jtp.setVisibility(0);
            this.jtq.setVisibility(0);
            this.jsD = new FeedBackModel(getPageContext());
            this.jsD.EE(this.mData.getForumName());
            this.jsD.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.24
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.jtp.setVisibility(8);
                        WriteActivity.this.jtq.setVisibility(8);
                        WriteActivity.this.showToast(d.j.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.jtp.setVisibility(8);
                        WriteActivity.this.jtq.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.jtp.a(feedBackModel.cql(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void cqK() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.kY()) {
                    WriteActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (WriteActivity.this.jsZ.a(WriteActivity.this.iwG, WriteActivity.this.iwK)) {
                        WriteActivity.this.showToast(WriteActivity.this.jsZ.coc());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cqO());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cqN());
                    WriteActivity.this.ciA.akp();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.jtm) {
                            WriteActivity.this.cqT();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            am amVar = new am("c12102");
                            amVar.T("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(amVar);
                            WriteActivity.this.cqU();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.cqT();
                    }
                    TiebaStatic.log(new am("c12262").bJ("obj_locate", WriteActivity.this.fxu));
                }
            }
        });
    }

    protected void crc() {
        this.jts = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.jts.ly(getPageContext().getString(d.j.is_save_draft)).dq(false).a(getPageContext().getString(d.j.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.cqO().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.cqN().getText().toString());
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    t.c(WriteActivity.this.mData.getForumId(), WriteActivity.this.mData);
                } else if (type == 1) {
                    t.d(WriteActivity.this.mData.getThreadId(), WriteActivity.this.mData);
                }
                WriteActivity.this.showToast(d.j.draft_save_success);
                WriteActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.27.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WriteActivity.this.finish();
                    }
                }, 1000L);
            }
        }).b(getPageContext().getString(d.j.not_save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    t.c(WriteActivity.this.mData.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    t.d(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.jts.b(getPageContext());
    }

    protected void cbs() {
        this.jto = (HeadImageView) findViewById(d.g.user_head_portrait);
        this.jto.setIsRound(true);
        this.jto.setDrawBorder(false);
        this.jto.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String ms = o.ms(currentPortrait);
            this.jto.setUrl(ms);
            this.jto.startLoad(ms, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.jto.setVisibility(0);
        }
        this.iwG = (EditText) findViewById(d.g.post_title);
        this.iwG.setOnClickListener(this.jtd);
        this.iwG.setOnFocusChangeListener(this.iwE);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.iwG.setText(this.mData.getTitle());
                this.iwG.setSelection(this.mData.getTitle().length());
            } else if (this.jtn) {
                this.iwG.setText(getResources().getString(d.j.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.iwG.addTextChangedListener(this.jtf);
        if (!this.mData.getHaveDraft()) {
            cqG();
            this.jtS = true;
        }
        if (this.mData.isUserFeedback()) {
            this.iwG.setHint(getResources().getString(d.j.feedback_title_hint));
        } else {
            this.iwG.setHint(getResources().getString(d.j.post_title_hint));
        }
    }

    private TextWatcher Cp() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            private int jub;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.cbt();
                if (WriteActivity.this.jsT) {
                    this.jub = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.jub);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.jsT || !WriteActivity.this.jtJ) {
                    if (WriteActivity.this.jsT) {
                        if (this.mEditText != WriteActivity.this.jtA || this.mTextView != WriteActivity.this.jtG) {
                            this.mEditText = WriteActivity.this.jtA;
                            this.mTextView = WriteActivity.this.jtG;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.jtE || this.mTextView != WriteActivity.this.jtF) {
                    this.mEditText = WriteActivity.this.jtE;
                    this.mTextView = WriteActivity.this.jtF;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.jsT && this.jtJ) {
            if (this.jtH != null) {
                this.jtE.removeTextChangedListener(this.jtH);
            }
            this.jtH = textWatcher;
        } else if (this.jsT) {
            if (this.jtI != null) {
                this.jtA.removeTextChangedListener(this.jtI);
            }
            this.jtI = textWatcher;
        }
        return textWatcher;
    }

    private long p(EditText editText) {
        if (editText == this.jtA) {
            return 233L;
        }
        if (editText != this.jtE) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long p = p(editText);
            long q = p - q(editText);
            String valueOf = String.valueOf(q);
            if (p == 20) {
                if (q < 0) {
                    if (q < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(al.getColor(d.C0277d.common_color_10159));
                } else {
                    textView.setTextColor(al.getColor(d.C0277d.cp_cont_d));
                }
            } else if (q < 0) {
                if (q < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(al.getColor(d.C0277d.common_color_10159));
            } else {
                textView.setTextColor(al.getColor(d.C0277d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long q(EditText editText) {
        return com.baidu.tieba.write.c.a.l(editText.getText().toString().trim());
    }

    protected void cbu() {
        this.iwK = (EditText) findViewById(d.g.post_content);
        this.iwK.setDrawingCacheEnabled(false);
        this.iwK.setOnClickListener(this.jtd);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString ax = TbFaceManager.ano().ax(getPageContext().getPageActivity(), this.mData.getContent());
            this.iwK.setText(ax);
            this.iwK.setSelection(ax.length());
        } else if (this.mData.getType() == 2) {
            if (this.jtt) {
                if (this.jtu != null && this.jtu.length() > 0) {
                    this.iwK.setText(getPageContext().getPageActivity().getString(d.j.reply_sub_floor, new Object[]{this.jtu}));
                    this.iwK.setSelection(this.iwK.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.j.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.iwK.setText(format);
                this.iwK.setSelection(format.length());
            }
        }
        this.iwK.setOnFocusChangeListener(this.iwE);
        this.iwK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.iwK.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iwK.addTextChangedListener(this.jtg);
        if (this.mData.getType() == 0) {
            this.jtW = true;
        } else {
            rj(true);
            this.jtW = false;
        }
        if (this.mData.isUserFeedback()) {
            this.iwK.setHint(d.j.write_input_content);
        } else {
            this.iwK.setHint(d.j.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void rj(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.jsT) {
            cqN().setPadding(0, 0, 0, 0);
            cqN().setBackgroundDrawable(null);
            al.l(cqN(), d.C0277d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.gPw) && this.jsH == null) {
                com.baidu.adp.lib.f.c.jB().a(this.gPw, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.30
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass30) aVar, str, i);
                        if (aVar != null && aVar.oy() != null && aVar.oC() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.oy(), aVar.oy().getNinePatchChunk(), aVar.oC(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.cqN().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.cqN(), true, WriteActivity.this.hyb);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqM() {
        int i = UIMsg.m_AppUI.MSG_APP_GPS;
        if (this.jsH != null) {
            i = 1000;
        }
        return cqN().getText() != null && cqN().getText().length() >= i;
    }

    private void oM(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.jsy)) {
                this.jsy = "";
                cqN().requestFocus();
                if (cqN().getText() != null && cqN().getText().length() + str.length() > 5000) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = cqN().getSelectionStart();
                    editable = cqN().getText();
                }
            } else if ("from_title".equals(this.jsy)) {
                this.jsy = "";
                cqO().requestFocus();
                if (cqO().getText() != null && cqO().getText().length() + str.length() > 31) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = cqO().getSelectionStart();
                    editable = cqO().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rh(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.d(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void e(com.baidu.tbadk.coreExtra.data.p pVar) {
        if (((ImageSpan[]) cqN().getText().getSpans(0, cqN().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.jsG == null) {
                this.jsG = Toast.makeText(getPageContext().getPageActivity(), d.j.too_many_face, 0);
            }
            this.jsG.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType agt = pVar.agt();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.jB().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.32
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass32) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.cqN().getSelectionStart(), aVar, agt);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cqN() != null && cqN().getText() != null) {
            Bitmap oy = aVar.oy();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(oy);
            int width = oy.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, oy.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.g(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = cqN().getSelectionStart() - 1;
                if (cqN().getText().length() > 1 && selectionStart >= 0 && cqN().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cqN().getText().insert(cqN().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cqN().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cqN().getText().insert(cqN().getSelectionStart(), spannableString2);
            }
            Editable text = cqN().getText();
            if (text != null) {
                this.jsW.clear();
                this.jsW.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jsW);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cqN().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cqN().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cqN().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cqN() {
        return this.jsT ? this.jtA : this.iwK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cqO() {
        return this.jsT ? this.jtE : this.iwG;
    }

    protected void cqP() {
        Editable text;
        if (cqN() != null && (text = cqN().getText()) != null) {
            int selectionStart = cqN().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cqN().onKeyDown(67, this.eHC);
            }
            cqN().onKeyDown(67, this.eHC);
            int selectionStart2 = cqN().getSelectionStart();
            if (text != null) {
                this.jsW.clear();
                this.jsW.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jsW);
                cqN().setSelection(selectionStart2);
            }
        }
    }

    private void l(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.j.feedback_bar_name).equals(str)) {
            this.jtm = true;
        }
    }

    private void crd() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void cre() {
        try {
            if (this.jts != null) {
                this.jts.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.csK.e(null);
        this.csK.hG(d.j.sending);
        this.csK.dJ(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.csK.dJ(false);
    }

    private Boolean crf() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.cki = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void cbt() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (cqO() != null) {
                str = cqO().getText().toString();
            }
            if (cqN() != null) {
                str2 = cqN().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.iwo == com.baidu.tbadk.core.util.v.S(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.jsC.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            ri(true);
                            return;
                        }
                    } else if (this.jsC.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        ri(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.jsC.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    ri(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.jsT) {
                    ri(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    ri(true);
                }
            }
            if (this.mData.getType() == 4) {
                ri(s(this.jtA) && r(this.jtE));
            } else if (this.mData.getType() == 5) {
                ri(s(this.jtA));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                ri(true);
            } else if (this.mData.getVideoInfo() != null) {
                ri(true);
            } else {
                ri(false);
            }
        }
    }

    public void ri(boolean z) {
        if (z) {
            al.c(this.mPost, d.C0277d.cp_link_tip_a, d.C0277d.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        al.d(this.mPost, d.C0277d.cp_cont_d, 1);
        this.mPost.setEnabled(false);
    }

    private boolean r(EditText editText) {
        long q = q(editText);
        return q <= 20 && q > 0;
    }

    private boolean s(EditText editText) {
        long q = q(editText);
        if (q > 233) {
            return false;
        }
        return q > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        String stringExtra;
        this.cke = new NewWriteModel(this);
        this.cke.b(this.cks);
        registerListener(this.jtY);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.cbl();
            }
        };
        this.mData = new WriteData();
        if (bundle != null) {
            this.mData.setType(bundle.getInt("type", 0));
            this.mData.setForumId(bundle.getString("forum_id"));
            this.mData.setForumName(bundle.getString("forum_name"));
            this.mData.setFirstDir(bundle.getString(IntentConfig.FORUM_FIRST_DIR));
            this.mData.setSecondDir(bundle.getString(IntentConfig.FORUM_SECOND_DIR));
            this.mData.setThreadId(bundle.getString("thread_id"));
            this.mData.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(bundle.getInt("floor_num", 0));
            this.jtm = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.jtn = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.jtt = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.jtu = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.ckc = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.jsH = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.jsH != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.jtv = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.mData.setTopicId(this.mTopicId);
            this.fxu = bundle.getString("KEY_CALL_FROM");
            this.jmO = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            stringExtra = string;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setFirstDir(intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR));
            this.mData.setSecondDir(intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.jtm = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.jtn = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.jtt = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.jtu = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.jsH = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.jsH != null);
            this.mData.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.jtv = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.mData.setTopicId(this.mTopicId);
            this.fxu = intent.getStringExtra("KEY_CALL_FROM");
            this.jmO = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
            stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
        }
        if (this.mData.getType() == 9) {
            this.mData.setEntranceType(1);
        } else if (this.mData.getType() == 10) {
            this.mData.setEntranceType(2);
            this.mData.setType(9);
        } else if (this.mData.getType() == 0) {
            this.mData.setEntranceType(3);
        }
        this.mData.setIsUserFeedback(this.jtm);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (stringExtra != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.mData.getType() == 4 ? 6 : 9);
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mData.getType() == 0 || this.mData.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                t.c(this.mData.getForumId(), this);
            }
        } else if (this.mData.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                t.c("24591571", this);
            }
        } else if (this.mData.getType() == 1) {
            t.a(this.mData.getThreadId(), this);
        } else if (this.mData.getType() == 4) {
            t.c(this.mData.getForumId() + "photolive", this);
        } else if (this.mData.getType() == 5) {
            t.a(this.mData.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(d.j.write_no_prefix));
        }
        this.gPw = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.jsA = true;
        }
        cqH();
        try {
            this.jtK = crm();
        } catch (Throwable th) {
            this.jtK = null;
        }
    }

    private void cqQ() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.iwG.setText(com.baidu.tbadk.plugins.b.pv(com.baidu.tbadk.plugins.b.pw(hotTopicBussinessData.mTopicName)));
            this.iwG.setMovementMethod(com.baidu.tieba.view.c.cna());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString pv = com.baidu.tbadk.plugins.b.pv(com.baidu.tbadk.plugins.b.pw(hotTopicBussinessData.mTopicName));
            if (pv != null) {
                this.iwG.setText(pv);
            }
            this.jsV.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t.a
    public void a(WriteData writeData) {
        String str;
        String pw;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (com.baidu.adp.lib.util.k.isEmpty(cqO().getText().toString()) || this.jtS || ((this.jtm || this.jsA) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                    if (com.baidu.adp.lib.util.k.isEmpty(this.mData.getTitle())) {
                        this.mData.setTitle(writeData.getTitle());
                    }
                    if (!com.baidu.tbadk.core.util.v.T(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0);
                        if (hotTopicBussinessData == null) {
                            str = null;
                        } else {
                            str = hotTopicBussinessData.mTopicName;
                        }
                        if (StringUtils.isNull(str)) {
                            pw = this.mData.getTitle();
                        } else {
                            pw = com.baidu.tbadk.plugins.b.pw(str);
                        }
                        SpannableString pv = com.baidu.tbadk.plugins.b.pv(pw);
                        if (pv != null) {
                            cqO().setText(pv);
                            cqO().setSelection(pv.length() > pw.length() ? pw.length() : pv.length());
                        }
                    } else {
                        SpannableString pv2 = com.baidu.tbadk.plugins.b.pv(this.mData.getTitle());
                        if (pv2 != null) {
                            cqO().setText(pv2);
                            cqO().setSelection(this.mData.getTitle().length() > pv2.length() ? pv2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    cqG();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.ciA.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.k.isEmpty(cqN().getText().toString()) || this.jtm || this.jsA) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.ano().a(getPageContext().getPageActivity(), this.mData.getContent(), this.jtb);
                    cqN().setText(a2);
                    cqN().setSelection(a2.length());
                    if (this.jsT) {
                        a(this.jtG, this.jtA);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    crl();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        cqW();
                    }
                    rk(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    crg();
                }
                cbt();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.jsM != null) {
                    this.jsQ = this.jsN.fcA;
                    this.jsP = this.jsN.name;
                    int i = 0;
                    while (true) {
                        if (i == this.jsM.size()) {
                            break;
                        }
                        v vVar = this.jsM.get(i);
                        if (categoryTo != vVar.fcA) {
                            i++;
                        } else {
                            this.jsQ = categoryTo;
                            this.jsP = vVar.name;
                            this.mData.setCategoryTo(this.jsQ);
                            break;
                        }
                    }
                    if (this.jsR != null) {
                        this.jsR.setText(this.jsP);
                        this.jsR.setCategoryContainerData(this.jsM, this.jsN, this.jsQ);
                    }
                }
                this.ciA.akp();
                return;
            }
            return;
        }
        crg();
        cqG();
    }

    private void crg() {
        if ((!this.jsT || this.jtz != null) && this.jty != null) {
            this.jtz.c(this.writeImagesInfo);
            crj();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.mData.getType());
        bundle.putString("forum_id", this.mData.getForumId());
        bundle.putString("forum_name", this.mData.getForumName());
        bundle.putString(IntentConfig.FORUM_FIRST_DIR, this.mData.getFirstDir());
        bundle.putString(IntentConfig.FORUM_SECOND_DIR, this.mData.getSecondDir());
        bundle.putString("thread_id", this.mData.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.mData.getFloor());
        bundle.putInt("floor_num", this.mData.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.jtt);
        if (this.jtm) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.ckc);
        if (this.jsH != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.jsH));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.jtv);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.fxu);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.jmO);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cqN().getEditableText().toString();
        if (obj != null) {
            cqN().setText(TbFaceManager.ano().a(getPageContext().getPageActivity(), obj, this.jtb));
            cqN().setSelection(cqN().getText().length());
        }
    }

    private String cqR() {
        return (cqN() == null || cqN().getText() == null) ? "" : cqN().getText().toString();
    }

    private String cqS() {
        if (this.mData == null || cqO() == null || cqO().getVisibility() != 0 || cqO().getText() == null) {
            return "";
        }
        String obj = cqO().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.S(this.mPrefixData.getPrefixs()) > 0 && this.iwo != com.baidu.tbadk.core.util.v.S(this.mPrefixData.getPrefixs()) - 1 && this.mData.getType() != 4 && this.iwL != null && this.iwL.getText() != null) {
            this.mData.setPostPrefix(this.iwL.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void EF(String str) {
        if (this.mData != null && this.jsC != null) {
            if (this.jsC.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.mData.setIsNoTitle(true);
                    this.mData.setTitle("");
                    return;
                }
                this.mData.setIsNoTitle(false);
                this.mData.setTitle(str);
                return;
            }
            this.mData.setIsNoTitle(true);
            this.mData.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqT() {
        cbl();
        this.mData.setContent(cqR());
        EF(cqS());
        if (this.jtm || this.jsA) {
            String string = getResources().getString(d.j.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                EF(string + this.mData.getTitle());
            }
            String str = getResources().getString(d.j.app_name) + getResources().getString(d.j.tieba_client);
            if (TextUtils.isEmpty(this.mData.getContent()) || !this.mData.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.j.kY()) {
                    sb.append(com.baidu.adp.lib.util.j.lf());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(Config.TRACE_TODAY_VISIT_SPLIT);
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.jsO >= 0) {
            this.mData.setCategoryFrom(this.jsO);
        }
        if (this.jsQ >= 0) {
            this.mData.setCategoryTo(this.jsQ);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            Iterator<ImageFileInfo> it = this.writeImagesInfo.getChosedFiles().iterator();
            int i = 0;
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.isFromCamera()) {
                    i++;
                }
                i = i;
            }
            this.mData.setTakePhotoNum(i);
        }
        this.mData.setHasLocationData(this.ckd != null && this.ckd.aNF());
        if (this.writeImagesInfo != null) {
            this.cke.qd(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.v.T(this.mList) && this.jsU != null && this.jsU.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.jsU.mForumId));
            this.mData.setForumName(this.jsU.mForumName);
        }
        this.cke.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.cke.getWriteData().setVoice(this.mVoiceModel.getId());
                this.cke.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.cke.getWriteData().setVoice(null);
                this.cke.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.cke.getWriteData().setVoice(null);
            this.cke.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.cke.cfF()) {
            showToast(d.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.kY()) {
            showToast(d.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
            this.cke.startPostWrite();
        }
    }

    private void A(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.jsH != null) {
                i2 = this.jsH.getTotalCount();
                i = this.jsH.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(d.j.write_addition_left_count), Integer.valueOf(i2 - i)));
            }
        }
        l.showToast(getPageContext().getPageActivity(), sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    public void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                if (this.iwG == getCurrentFocus()) {
                    cqN().clearFocus();
                    this.iwG.requestFocus();
                    if (this.ciA != null) {
                        this.ciA.akp();
                    }
                    ShowSoftKeyPadDelay(this.iwG);
                } else {
                    cqN().requestFocus();
                    if (this.ciA != null) {
                        this.ciA.akp();
                    }
                    ShowSoftKeyPadDelay(this.iwK);
                }
                ArrayList<String> stringArrayListExtra = intent != null ? intent.getStringArrayListExtra("name_show") : null;
                if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < stringArrayListExtra.size()) {
                            sb.append("@");
                            sb.append(stringArrayListExtra.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            cqN().getText().insert(cqN().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.mData.getType() == 0 || this.mData.getType() == 9) {
                    t.c(this.mData.getForumId(), (WriteData) null);
                    if (postWriteCallBackData2 != null) {
                    }
                } else if (this.mData.getType() == 1) {
                    t.d(this.mData.getThreadId(), (WriteData) null);
                }
                k(postWriteCallBackData2);
                setResult(-1, intent);
                finish();
            } else if (i != 12010 && i != 12009) {
                if (i == 12002) {
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.FINISH_SELF, false)) {
                            finish();
                            return;
                        }
                        int intExtra = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            if (intExtra == 1) {
                                crk();
                            } else {
                                aB(intent);
                            }
                        } else if (intExtra == 1) {
                            aC(intent);
                        } else {
                            az(intent);
                            com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.jtW) {
                            rj(true);
                            this.jtW = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.jsT) {
                        P(intent);
                        cbt();
                        return;
                    }
                    aA(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.ciA.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.ciA.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.ciA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    cbt();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.jsz) {
                                sb2.append(com.baidu.tbadk.plugins.b.csi);
                                this.jsz = false;
                            }
                            sb2.append(stringExtra);
                            oM(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.T(this.mList) && !com.baidu.tbadk.core.util.v.T(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.jsU = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.jsU);
                }
            }
        } else if (i2 == 0) {
            if (this.ciA != null && !this.ciA.alV()) {
                this.iwK.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.ciA.akp();
            }
            switch (i) {
                case 12001:
                    amB();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    cri();
                    if (this.jtW) {
                        rj(true);
                        this.jtW = false;
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (this.iwG == getCurrentFocus()) {
                        cqN().clearFocus();
                        this.iwG.requestFocus();
                        if (this.ciA != null) {
                            this.ciA.akp();
                        }
                        ShowSoftKeyPadDelay(this.iwG);
                        return;
                    }
                    cqN().requestFocus();
                    if (this.ciA != null) {
                        this.ciA.akp();
                    }
                    ShowSoftKeyPadDelay(this.iwK);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.jsZ.Ej(postWriteCallBackData.getErrorString());
                        this.jsZ.aE(postWriteCallBackData.getSensitiveWords());
                        this.jsZ.b(this.iwG, this.iwK);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                default:
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.ckc = String.valueOf(System.currentTimeMillis());
                    ak.a(getPageContext(), this.ckc);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    cri();
                    return;
                case 25004:
                    if ("from_title".equals(this.jsy)) {
                        cqO().requestFocus();
                        return;
                    } else if ("from_content".equals(this.jsy)) {
                        cqN().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqU() {
        if ("1".equals(this.fxu)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.fxu)) {
            this.mData.setCanNoForum(false);
        }
        cqV();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.fxu);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cqT();
    }

    private void cqV() {
        if (this.ciA != null) {
            this.ciA.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void crh() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void cri() {
        if (this.jsT) {
            this.jtz.c(this.writeImagesInfo);
            crj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crj() {
        this.jtz.notifyDataSetChanged();
        this.jty.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.jtz.notifyDataSetChanged();
                WriteActivity.this.jty.invalidateViews();
            }
        }, 550L);
    }

    public void u(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        cbt();
    }

    private void az(Intent intent) {
        if (this.jsT) {
            aA(intent);
            cri();
        } else {
            aD(intent);
        }
        cbt();
    }

    private void aA(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            cri();
            rk(true);
        }
    }

    private void aB(Intent intent) {
        if (this.writeImagesInfo != null) {
            O(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, size)));
            }
        }
    }

    private void crk() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void aC(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.jtw.parseJson(stringExtra);
            this.jtw.updateQuality();
            if (this.jtw.getChosedFiles() != null && this.jtw.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.jtw.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.jtw.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cqO());
        HidenSoftKeyPad(this.mInputManager, cqN());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void aD(Intent intent) {
        c(intent, true);
    }

    private void O(Intent intent) {
        this.ckc = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.ckc;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.aO(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.aQ(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a(TbConfig.LOCAL_CAMERA_DIR, this.ckc, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            crl();
            cqW();
        }
        rk(true);
    }

    private void P(Intent intent) {
        c(intent, false);
    }

    private void c(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                crl();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    cqW();
                }
            }
            rk(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crl() {
        if (this.ciA.jw(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void amB() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.ckc));
                return null;
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rk(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.jtx != null) {
            this.jtx.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.eYR == null) {
            this.eYR = VoiceManager.instance();
        }
        return this.eYR;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bcM() {
        this.eYR = getVoiceManager();
        this.eYR.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.aB(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.fad) != null) {
                    TiebaStatic.log(new am("c12534").T("obj_locate", at.a.bLk));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.jsH == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                A(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.ckj = i;
        if (this.ciA != null) {
            this.ciA.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void cqW() {
        if (!this.jsT) {
            if (this.ciA != null) {
                this.ciA.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.ciA.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.jtx != null) {
                this.jtx.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eP(boolean z) {
        if (this.ciA != null) {
            this.ciA.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void By(int i) {
        if (i < this.jsF.size()) {
            for (int i2 = 0; i2 < this.jsF.size(); i2++) {
                this.jsF.get(i2).qY(false);
            }
            this.jsF.get(i).qY(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void yZ(int i) {
        if (i == com.baidu.tbadk.core.util.v.S(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new am("c13014").T("obj_type", 1));
        } else {
            TiebaStatic.log(new am("c13014").T("obj_type", 2));
        }
        this.iwo = i;
        this.iwM.setCurrentIndex(i);
        By(i);
        this.iwL.setText(this.mPrefixData.getPrefixs().get(i));
        cbt();
        com.baidu.adp.lib.g.g.a(this.iwM, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.iwO.setSelected(false);
        al.c(this.iwN, d.f.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.iwK);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes3.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            l.b(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.mData != null) {
            if (this.mData.getType() == 4) {
                return "a015";
            }
            if (this.mData.getType() == 5) {
                return "a016";
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            amv();
        } else if (i == 1) {
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (ab.cS(getApplicationContext())) {
                ak.a(getPageContext(), this.ckc);
            } else {
                showToast(d.j.system_permission_prompt_camera);
            }
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.j.sdcard_permission_denied_advert_for_camera);
            }
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.jsY = z;
        if (this.jtQ && System.currentTimeMillis() - this.jtR < 800) {
            l.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.jtQ = false;
        }
        if (this.jsX != null && !z) {
            this.jsX.aWP();
        }
        if (this.jta != null && !z) {
            cqz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EG(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.jtN != null) {
            EH(str);
            this.jtN.dismiss();
        }
    }

    private void eE(Context context) {
        jtP = l.aQ(context);
    }

    private void EH(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.j.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.jtQ = true;
        crl();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            cqW();
        }
        rk(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [4292=4] */
    private static Bitmap f(String str, float f) {
        Bitmap bitmap;
        Throwable th;
        Bitmap bitmap2 = null;
        int i = (int) f;
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && i > 0) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                int i2 = options.outWidth;
                int i3 = options.outHeight;
                bitmap = BitmapHelper.resizeBitmapAbsolute(str, (Math.max(i2, i3) * i) / Math.min(i2, i3));
            } catch (Exception e) {
                bitmap = null;
            } catch (Throwable th2) {
                bitmap = null;
                th = th2;
            }
            try {
                bitmap2 = BitmapHelper.getResizedBitmap(bitmap, i);
                if (bitmap != null && bitmap != bitmap2 && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                System.gc();
            } catch (Exception e2) {
                if (bitmap != null && bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                System.gc();
                return bitmap2;
            } catch (Throwable th3) {
                th = th3;
                if (bitmap != null && bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                System.gc();
                throw th;
            }
        }
        return bitmap2;
    }

    private File crm() {
        Cursor query = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_data", "bucket_display_name", "datetaken", "mime_type"}, null, null, "datetaken DESC");
        if (query == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String name = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getName();
        String name2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getName();
        try {
            query.moveToFirst();
            while (!query.isAfterLast()) {
                String string = query.getString(query.getColumnIndex("_data"));
                File file = new File(string);
                if ((currentTimeMillis - file.lastModified()) / 60000 > 1) {
                    break;
                }
                String upperCase = string.toUpperCase();
                if (upperCase.contains("DCIM/CAMERA") || upperCase.contains("DCIM/100ANDRO") || upperCase.contains("DCIM/100MEDIA") || upperCase.contains("SCREENSHOTS") || upperCase.contains(name.toUpperCase()) || upperCase.contains(name2.toUpperCase())) {
                    return file;
                }
                query.moveToNext();
            }
            return null;
        } finally {
            query.close();
        }
    }

    private void crn() {
        if (this.jtK != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            eE(getActivity());
            this.jtM = getPageContext().getPageActivity().getLayoutInflater().inflate(d.h.rec_dialog, (ViewGroup) null);
            this.jtM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.jtK != null) {
                        WriteActivity.this.EG(WriteActivity.this.jtK.getAbsolutePath());
                    }
                }
            });
            this.jtL = (TbImageView) this.jtM.findViewById(d.g.rec_img_view);
            this.jtO = (LinearLayout) this.jtM.findViewById(d.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.jtK.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.jtK.getAbsolutePath());
                Bitmap f = f(this.jtK.getAbsolutePath(), getResources().getDimensionPixelSize(d.e.ds160));
                if (f != null) {
                    this.jtL.setImageBitmap(f);
                    this.jtL.setDrawBorder(true);
                    this.jtL.setBorderWidth(2);
                    this.jtL.setBorderColor(al.getColor(d.C0277d.common_color_10264));
                    this.jtN = new Dialog(getActivity(), d.k.bubble_dialog);
                    this.jtN.setCanceledOnTouchOutside(true);
                    this.jtN.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.jtQ) {
                                l.b(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.jtR = System.currentTimeMillis();
                            }
                        }
                    });
                    this.jtN.setContentView(this.jtM);
                    this.jtN.show();
                    Window window = this.jtN.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.e.ds28);
                    attributes.y = (jtP / 18) + getResources().getDimensionPixelSize(d.e.ds12);
                    attributes.width = getResources().getDimensionPixelSize(d.e.ds168);
                    attributes.height = getResources().getDimensionPixelSize(d.e.ds278);
                    window.setAttributes(attributes);
                }
            }
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.jsY && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.jsz = false;
            this.jsy = "";
            if ("from_content".equals(str)) {
                this.jsy = "from_content";
            } else if ("from_title".equals(str)) {
                this.jsy = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.pu(String.valueOf(charSequence.charAt(i)))) {
                rh(false);
            }
        }
    }

    public void bXw() {
        if (this.jtm || !com.baidu.tbadk.core.util.v.T(this.mList) || !StringUtils.isNull(this.mData.getTitle())) {
            this.jsC.setVisibility(0);
            this.jsC.requestFocus();
            this.ciA.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.jsC.setVisibility(8);
    }
}
