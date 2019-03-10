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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0040a, VoiceManager.c, t.a, h.a {
    private static int jtX = 0;
    private EditorTools ciA;
    private String ckc;
    private LocationModel ckd;
    private NewWriteModel cke;
    private VoiceManager eYS;
    private ImageView hrB;
    private LinearLayout hry;
    private PlayVoiceBntNew hrz;
    private boolean isPrivacy;
    private TextView iwS;
    private com.baidu.tieba.write.h iwT;
    private ImageView iwU;
    private View iwV;
    private int iwv;
    private com.baidu.tieba.write.b.c jqR;
    private LinearLayout jsJ;
    private LinearLayout jsK;
    private View jsM;
    private Toast jsO;
    private AdditionData jsP;
    private RelativeLayout jsQ;
    private TextView jsR;
    private TextView jsS;
    private TextView jsT;
    List<v> jsU;
    v jsV;
    private int jsW;
    private String jsX;
    private int jsY;
    private PostCategoryView jsZ;
    private g jtF;
    private HotTopicBussinessData jtc;
    private TextView jtd;
    private com.baidu.tieba.write.editor.b jtf;
    private e jti;
    private com.baidu.tieba.view.b jtp;
    private View jty;
    private View jub;
    private View juc;
    private TextView jud;
    private com.baidu.tieba.c.d juf;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String jsG = "";
    private boolean jsH = false;
    private WriteData mData = null;
    private boolean jtu = false;
    private boolean jsI = false;
    private boolean jtv = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText iwN = null;
    private HeadImageView jtw = null;
    private View iwO = null;
    private LinearLayout iwQ = null;
    private EditText iwR = null;
    private FeedBackModel jsL = null;
    private FeedBackTopListView jtx = null;
    private ArrayList<WritePrefixItemLayout> jsN = new ArrayList<>();
    private String gPx = null;
    private final KeyEvent eHG = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View bVY = null;
    private TextView jtz = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a jtA = null;
    private final Handler mHandler = new Handler();
    private boolean jtB = false;
    private String jtC = null;
    private RelativeLayout mParent = null;
    private String cki = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int ckj = 0;
    private int jtD = 0;
    private WriteImagesInfo jtE = new WriteImagesInfo();
    private View mRootView = null;
    private GridView jtG = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a jtH = null;
    private ScrollView jta = null;
    private EditText jtI = null;
    private View jtJ = null;
    private View jtK = null;
    private View jtL = null;
    private EditText jtM = null;
    private TextView jtN = null;
    private TextView jtO = null;
    private TextWatcher jtP = null;
    private TextWatcher jtQ = null;
    private boolean jtb = false;
    private boolean jtR = false;
    private com.baidu.tbadk.core.view.b csN = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private File jtS = null;
    private TbImageView jtT = null;
    private View jtU = null;
    private Dialog jtV = null;
    private LinearLayout jtW = null;
    private boolean jtY = false;
    private long jtZ = -1000;
    private boolean jua = false;
    private String fxv = "2";
    private int jmW = 0;
    private String mTopicId = "";
    private SpannableStringBuilder jte = new SpannableStringBuilder();
    private boolean jue = false;
    private boolean jtg = false;
    private final b jth = new b();
    private final HttpMessageListener jug = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.gPx)) {
                    WriteActivity.this.gPx = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.rj(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.gPx)) {
                    WriteActivity.this.gPx = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.gPx);
                    WriteActivity.this.rj(true);
                }
            }
        }
    };
    private TbFaceManager.a jtj = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
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
    private final AntiHelper.a fae = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLj));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLj));
        }
    };
    private final NewWriteModel.d cks = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.bcN();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.jth.aE(null);
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
                    WriteActivity.this.jth.aE(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.jth.El(postWriteCallBackData.getErrorString());
                    WriteActivity.this.jth.b(WriteActivity.this.iwN, WriteActivity.this.iwR);
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
                    if (com.baidu.tbadk.u.a.pV(xVar.agD())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, xVar.agD());
                        if (WriteActivity.this.jtv) {
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
        public void amK() {
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
            if (aVar != null && !StringUtils.isNull(aVar.ceU())) {
                WriteActivity.this.b(2, true, aVar.ceU());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener iID = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.WriteActivity.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.ckd.qb(false);
                    WriteActivity.this.ckd.ea(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.ckd.qb(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener jtk = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener jtl = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.43
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cqs = WriteActivity.this.cqs();
            if (cqs >= 0 && cqs < WriteActivity.this.iwR.getText().length()) {
                WriteActivity.this.iwR.setSelection(cqs);
            }
        }
    };
    private boolean jtm = true;
    private final View.OnFocusChangeListener iwL = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.iwN || view == WriteActivity.this.bVY || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.jtm = true;
                    WriteActivity.this.cqt();
                    l.c(WriteActivity.this.getActivity(), WriteActivity.this.iwN);
                    if (WriteActivity.this.ciA != null) {
                        WriteActivity.this.ciA.akq();
                    }
                } else if (view == WriteActivity.this.iwN) {
                    WriteActivity.this.iwS.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.iwR && z) {
                WriteActivity.this.jtm = false;
                WriteActivity.this.cqt();
                l.c(WriteActivity.this.getActivity(), WriteActivity.this.iwR);
                if (WriteActivity.this.ciA != null) {
                    WriteActivity.this.ciA.akq();
                }
            }
            WriteActivity.this.cqz();
        }
    };
    private TextWatcher jtn = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String jtr = "";
        private String jts;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jts = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jts != null ? this.jts.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cbr();
            WriteActivity.this.cqA();
            EditText cqL = WriteActivity.this.cqL();
            if (editable != null && cqL != null && cqL.getText() != null) {
                if (this.jtr == null || !this.jtr.equals(editable.toString())) {
                    if (WriteActivity.this.jth != null) {
                        this.jtr = cqL.getText().toString();
                        WriteActivity.this.jth.o(cqL);
                        return;
                    }
                    return;
                }
                cqL.setSelection(cqL.getSelectionEnd());
            }
        }
    };
    private TextWatcher jto = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String jts;
        private String jtt = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jts = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jts != null ? this.jts.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cbr();
            EditText cqK = WriteActivity.this.cqK();
            if (editable != null && cqK != null && cqK.getText() != null) {
                if (this.jtt == null || !this.jtt.equals(editable.toString())) {
                    if (WriteActivity.this.jth != null) {
                        this.jtt = cqK.getText().toString();
                        WriteActivity.this.jth.o(cqK);
                        return;
                    }
                    return;
                }
                cqK.setSelection(cqK.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0307a hyh = new a.InterfaceC0307a() { // from class: com.baidu.tieba.write.write.WriteActivity.31
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0307a
        public void onRefresh() {
            WriteActivity.this.gPx = null;
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
    public void amv() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void amw() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            amy();
        } else if (this.ckd.cfb()) {
            amv();
        } else {
            this.ckd.qb(false);
            b(1, true, null);
            this.ckd.ceZ();
        }
    }

    private void amy() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.gD(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kY()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.ckd.aNK();
                } else {
                    WriteActivity.this.ckq.amK();
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
    public int cqs() {
        int selectionEnd = cqK().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cqK().getText().getSpans(0, cqK().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cqK().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cqK().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqt() {
        if (this.ciA != null) {
            this.ciA.setBarLauncherEnabled(!this.jtm);
            this.ciA.setBarLauncherEnabled(true, 26);
            this.ciA.setBarLauncherEnabled(true, 2);
            Q(9, this.jtm ? false : true);
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
        if (this.jtb) {
            this.iwN.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.jtL.setVisibility(8);
            } else {
                this.jtL.setVisibility(0);
            }
            a(this.jtO, this.jtI);
            a(this.jtN, this.jtM);
            cbr();
        }
        if (this.jtu) {
            this.jtm = true;
            cqt();
            if (this.ciA != null) {
                this.ciA.akq();
            }
            this.iwN.requestFocus();
            ShowSoftKeyPadDelay(this.iwN);
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
            cri();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                cqT();
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
            Bz(this.jmW);
        }
        initUI();
        cqY();
        this.ckd = new LocationModel(this);
        this.ckd.a(this.ckq);
        registerListener(this.iID);
        registerListener(this.jtk);
        initEditor();
        crk();
        if (this.jtb) {
            this.jtH.setEditorTools(this.ciA);
        } else {
            this.iwR.requestFocus();
        }
        bXu();
        cqT();
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
        this.ciA.setBackgroundColorId(d.C0236d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                cqW();
                break;
            default:
                cqu();
                break;
        }
        this.ciA.alU();
        if (this.jsJ != null) {
            this.jsJ.addView(this.ciA);
        }
        cqv();
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
        if (!this.jtb) {
            this.ciA.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.ciA.akq();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.ciA.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.ciA.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        cqx();
    }

    private void cqU() {
        this.jtJ = this.mRootView.findViewById(d.g.photo_live_scroll);
        this.jtL = this.jtJ.findViewById(d.g.live_post_title_container);
        this.jtI = (EditText) this.jtJ.findViewById(d.g.live_post_content);
        this.jtG = (GridView) this.jtJ.findViewById(d.g.photoLiveGridView);
        this.jtM = (EditText) this.jtJ.findViewById(d.g.live_post_title);
        this.jtN = (TextView) this.jtJ.findViewById(d.g.titleOverPlusNumber);
        this.jtO = (TextView) this.jtJ.findViewById(d.g.contentOverPlusNumber);
        this.jtK = this.jtJ.findViewById(d.g.live_interval_view);
        this.jtN.setText(String.valueOf(20));
        this.jtO.setText(String.valueOf(233));
        this.jtJ.setVisibility(0);
        this.jtN.setVisibility(0);
        this.jtO.setVisibility(0);
        this.jtM.setHint(d.j.tips_title_limit_new);
        this.jtM.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.jtR = true;
                    WriteActivity.this.jtm = true;
                    WriteActivity.this.cqt();
                    if (WriteActivity.this.ciA != null) {
                        WriteActivity.this.ciA.akq();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.jtI.setHint(d.j.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.jtI.setHint(d.j.live_write_input_content_update);
        }
        this.jtI.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.jtR = false;
                    WriteActivity.this.jtm = false;
                    WriteActivity.this.cqt();
                    if (WriteActivity.this.ciA != null) {
                        WriteActivity.this.ciA.akq();
                    }
                }
            }
        });
        this.jtI.requestFocus();
        this.jtI.addTextChangedListener(Cp());
        this.jtM.requestFocus();
        this.jtM.addTextChangedListener(Cp());
        this.jtM.setOnClickListener(this.jtl);
        this.jtI.setOnClickListener(this.jtl);
        this.jtH = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.jtG);
        this.jtH.Bt(6);
        this.jtG.setAdapter((ListAdapter) this.jtH);
        View findViewById = this.jtJ.findViewById(d.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void cqd() {
                WriteActivity.this.crg();
            }
        });
        cqV();
    }

    private void cqV() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.jtM.setText(this.mData.getTitle());
                this.jtM.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.jtb) {
            cre();
        }
        if (this.ciA.alW()) {
            this.ciA.akq();
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
            albumActivityConfig.setCallFrom(this.fxv);
            sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void cqW() {
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

    private void cqu() {
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
        Boolean crc = crc();
        if (!this.jtu && crc != null && crc.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.cfC() && p.b(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), com.baidu.tbadk.editortools.k.class)) != null && (kVar5 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
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
            kVar3.cji = this.jtu ? d.f.write_location : d.f.icon_post_more_location;
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
        if (this.jsP == null) {
            if (this.jtf == null) {
                this.jtf = new com.baidu.tieba.write.editor.b(getActivity(), this.fxv);
                this.jtf.bw(this.mData.getForumId(), this.privateThread);
            }
            this.ciA.b(this.jtf);
        }
        this.ciA.ab(arrayList);
        com.baidu.tbadk.editortools.k jw = this.ciA.jw(5);
        if (jw != null) {
            jw.cjk = 1;
            jw.cji = d.f.write_emotion;
        }
    }

    private void cqw() {
        if (this.jti != null) {
            this.jti.hideTip();
        }
    }

    private void cqx() {
        if (this.jti == null) {
            this.jti = new e(getPageContext());
        }
        this.jti.c(this.ciA);
    }

    private void cqv() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.cqJ()) {
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
                                    WriteActivity.this.cbr();
                                }
                            } else if (WriteActivity.this.cqJ()) {
                                WriteActivity.this.showToast(d.j.over_limit_tip);
                            } else {
                                WriteActivity.this.e(pVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.cqM();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bKM();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.cri();
                        WriteActivity.this.cbr();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.BA(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new am("c12612").T("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.jsP == null) {
                            WriteActivity.this.amz();
                            return;
                        }
                        switch (WriteActivity.this.ckj) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.cR(pageActivity)) {
                                    WriteActivity.this.amw();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.amv();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.ckd != null) {
                            WriteActivity.this.ckd.qb(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.gPx = null;
                        } else {
                            WriteActivity.this.gPx = (String) aVar.data;
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
                                    if (WriteActivity.this.ciA.alW()) {
                                        WriteActivity.this.ciA.akq();
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
                        WriteActivity.this.cbr();
                        if (WriteActivity.this.iwR != null) {
                            WriteActivity.this.iwR.requestFocus();
                        }
                        WriteActivity.this.ciA.akq();
                        WriteActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iwR);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new am("c12612").T("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.jsH = true;
                        WriteActivity.this.rh(true);
                        if (!WriteActivity.this.cqL().isFocused() || WriteActivity.this.jsK.getVisibility() != 0) {
                            WriteActivity.this.jsG = "from_content";
                        } else {
                            WriteActivity.this.jsG = "from_title";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.jsK.setVisibility(0);
                        WriteActivity.this.jsK.requestFocus();
                        WriteActivity.this.cbr();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.jsK.hasFocus()) {
                            WriteActivity.this.iwR.requestFocus();
                            WriteActivity.this.iwR.setSelection(WriteActivity.this.iwR.getText().toString().length());
                        }
                        WriteActivity.this.jsK.setVisibility(8);
                        WriteActivity.this.cbr();
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
    public void amz() {
        if (this.ckd.aNG()) {
            if (this.ckd.cfb()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.ceX().getLocationData().ceU());
                return;
            }
            b(1, true, null);
            this.ckd.ceZ();
            return;
        }
        b(0, true, null);
    }

    protected void cbj() {
        if (this.cke != null) {
            this.cke.cancelLoadData();
        }
        if (this.jsL != null) {
            this.jsL.cancelLoadData();
        }
        if (this.ckd != null) {
            this.ckd.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cqw();
        TiebaPrepareImageService.StopService();
        cbj();
        crb();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.jtF != null) {
            this.jtF.destroy();
        }
        if (this.juf != null) {
            this.juf.aSs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqy() {
        if (this.mData != null && this.mData.getType() == 2 && this.jtB) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(cqL().getText().toString());
            this.mData.setContent(cqK().getText().toString());
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
            if (this.iwT != null && this.iwT.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.iwT, getPageContext().getPageActivity());
                return true;
            } else if (this.ciA.alW()) {
                this.ciA.akq();
                return true;
            } else {
                cbj();
                cqy();
                return true;
            }
        }
        if (i == 67 && (text = cqK().getText()) != null) {
            int selectionStart = cqK().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cqK().onKeyDown(67, this.eHG);
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
        getLayoutMode().onModeChanged(this.jtW);
        if (this.jtT != null && i == 1) {
            this.jtT.setBorderColor(al.getColor(d.C0236d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.d(this.mPost, d.C0236d.cp_link_tip_a, 1);
        cqt();
        al.l(this.jtJ, d.C0236d.cp_bg_line_d);
        al.l(this.iwO, d.C0236d.cp_bg_line_c);
        al.l(this.jtK, d.C0236d.cp_bg_line_c);
        al.l(cqL(), d.C0236d.cp_bg_line_d);
        al.c(this.hrB, d.f.icon_edit_close_n);
        if (TextUtils.isEmpty(this.gPx)) {
            al.l(cqK(), d.C0236d.cp_bg_line_d);
        }
        cbr();
        this.ciA.onChangeSkinType(i);
        if (this.jsZ != null) {
            this.jsZ.aeK();
        }
        al.j(this.mName, d.C0236d.cp_cont_b);
        cqz();
        cqA();
        if (this.jth != null) {
            this.jth.c(cqL(), cqK());
        }
        this.jqR.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqz() {
        if (this.iwN.hasFocus()) {
            this.iwN.setHintTextColor(al.getColor(d.C0236d.cp_cont_e));
        } else {
            this.iwN.setHintTextColor(al.getColor(d.C0236d.cp_cont_d));
        }
        if (this.iwR.hasFocus()) {
            this.iwR.setHintTextColor(al.getColor(d.C0236d.cp_cont_e));
        } else {
            this.iwR.setHintTextColor(al.getColor(d.C0236d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqA() {
        if (this.iwN != null && this.iwN.getText() != null && this.iwN.getText().toString() != null && this.iwN.getPaint() != null) {
            if (this.iwN.getText().toString().length() == 0) {
                this.iwN.getPaint().setFakeBoldText(false);
            } else if (this.iwN.getText().toString().length() > 0) {
                this.iwN.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.csN = new com.baidu.tbadk.core.view.b(getPageContext());
        this.jtb = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.bVY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        al.j(this.mName, d.C0236d.cp_cont_b);
        this.jtz = (TextView) findViewById(d.g.btn_image_problem);
        cqC();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.iwL);
        this.jta = (ScrollView) findViewById(d.g.write_scrollview);
        this.jta.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.iwR != null) {
                        l.b(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.iwR);
                    }
                    if (WriteActivity.this.ciA != null) {
                        WriteActivity.this.ciA.akq();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jtx = (FeedBackTopListView) findViewById(d.g.feedback_top_list);
        this.jty = findViewById(d.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.jsJ = (LinearLayout) findViewById(d.g.tool_view);
        this.jsJ.setContentDescription("..");
        this.jsK = (LinearLayout) findViewById(d.g.title_view);
        this.iwO = findViewById(d.g.interval_view);
        this.jub = findViewById(d.g.hot_topic_fourm_view);
        this.juc = findViewById(d.g.hot_topic_divider);
        this.jtd = (TextView) findViewById(d.g.hot_topic_title_edt);
        this.jud = (TextView) findViewById(d.g.change_one_tv);
        cbq();
        if (this.jtb) {
            this.jta.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            cqU();
        } else {
            this.jtF = new g(getPageContext(), this.mRootView);
            g gVar = this.jtF;
            if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                z = false;
            }
            gVar.rc(z);
        }
        cbs();
        if (this.jtu || this.jsI) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().bLU) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.iwQ = (LinearLayout) findViewById(d.g.post_content_container);
        this.iwQ.setDrawingCacheEnabled(false);
        this.iwQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.iwR.requestFocus();
            }
        });
        this.hry = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.hrz = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.hrB = (ImageView) findViewById(d.g.iv_delete_voice);
        this.hrB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bKM();
            }
        });
        this.bVY.setOnFocusChangeListener(this.iwL);
        this.bVY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cbj();
                WriteActivity.this.cqy();
            }
        });
        this.jtz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        cqF();
        l(crc());
        cqH();
        cqB();
        cqZ();
        cra();
        cqt();
        cqG();
        cbp();
        cqN();
        if (this.mData.getType() == 4 && this.iwV != null && this.jsM != null) {
            this.iwV.setVisibility(8);
            this.jsM.setVisibility(8);
        }
        cbr();
        cqX();
        cpJ();
    }

    private void cpJ() {
        this.jqR = new com.baidu.tieba.write.b.c(getPageContext().getPageActivity(), this.mName, this.mData.getProZone(), isUseStyleImmersiveSticky() ? StatusBarUtil.getStatusBarOffsetPx(getPageContext().getPageActivity()) : 0);
        this.jqR.a(new c.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // com.baidu.tieba.write.b.c.a
            public void Bo(int i) {
                WriteActivity.this.mData.setProZone(i);
            }
        });
        this.jqR.aWG();
    }

    private void cqB() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.jtu || this.jsI) {
                        if (this.jtv) {
                            this.mName.setText(d.j.feedback_vcode);
                        } else {
                            this.mName.setText(d.j.feedback);
                        }
                    } else if (this.fxv != null && this.fxv.equals("1")) {
                        this.mName.setText(d.j.post_to_home_page);
                    } else if (this.fxv != null && this.fxv.equals("2")) {
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
                    this.iwN.setVisibility(0);
                    this.iwR.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(d.j.send_reply);
                    this.iwR.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.iwN.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(d.j.publish_photo_live);
                    this.iwR.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(d.j.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.jtK.setVisibility(8);
                    return;
                case 7:
                    this.iwN.setVisibility(0);
                    this.iwR.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(d.j.post_drift_bottle);
                    return;
            }
        }
    }

    private void cqC() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
    }

    private void cqD() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.jtu && !this.jsI && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String f = ap.f(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(f) && cqL() != null) {
                cqL().setText(f);
                cqL().setSelection(f.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.hry.setVisibility(0);
            this.hrz.setVoiceModel(voiceModel);
            this.hrz.cfB();
            cbr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKM() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.bo(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.hry.setVisibility(8);
        this.hrz.bop();
        this.hrz.setVoiceModel(null);
        com.baidu.tbadk.editortools.k jw = this.ciA.jw(6);
        if (jw != null && jw.ciu != null) {
            jw.ciu.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cbr();
    }

    private void cqE() {
        this.jsU = null;
        this.jsW = -1;
        this.jsY = -1;
        com.baidu.tieba.frs.x qp = w.bek().qp(1);
        if (qp != null) {
            this.jsU = qp.fcF;
            this.jsW = getIntent().getIntExtra("category_id", -1);
            if (this.jsU != null && !this.jsU.isEmpty() && this.jsW >= 0) {
                this.jsV = new v();
                this.jsV.fcB = 0;
                this.jsV.name = getPageContext().getResources().getString(d.j.category_auto);
                this.jsY = this.jsV.fcB;
                this.jsX = this.jsV.name;
                for (v vVar : this.jsU) {
                    if (vVar.fcB == this.jsW) {
                        this.jsY = vVar.fcB;
                        this.jsX = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cqF() {
        if (this.jsU != null && !this.jsU.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.jsZ = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.jsZ.setText(this.jsX);
            this.jsZ.setCategoryContainerData(this.jsU, this.jsV, this.jsY);
            this.jsZ.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ar arVar) {
                    if (arVar != null) {
                        WriteActivity.this.jsZ.setText(arVar.name);
                        WriteActivity.this.mData.setCategoryTo(arVar.fcB);
                        WriteActivity.this.jsY = arVar.fcB;
                        WriteActivity.this.jsZ.cqg();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.jsZ.cqf();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cqL());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cqK());
                }
            });
        }
    }

    private void cqX() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.jtp = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.jtp.setTitle(d.j.no_disturb_start_time);
        this.jtp.setButton(-1, getPageContext().getString(d.j.alert_yes_button), this.jtp);
        this.jtp.setButton(-2, getPageContext().getString(d.j.cancel), this.jtp);
        return this.jtp;
    }

    private void cqG() {
        this.jsQ = (RelativeLayout) findViewById(d.g.addition_container);
        this.jsR = (TextView) findViewById(d.g.addition_create_time);
        this.jsS = (TextView) findViewById(d.g.addition_last_time);
        this.jsT = (TextView) findViewById(d.g.addition_last_content);
        if (this.jsP != null) {
            this.jsQ.setVisibility(0);
            this.jsR.setText(getPageContext().getString(d.j.write_addition_create) + ap.ao(this.jsP.getCreateTime() * 1000));
            if (this.jsP.getAlreadyCount() == 0) {
                this.jsS.setVisibility(8);
            } else {
                this.jsS.setText(getPageContext().getString(d.j.write_addition_last) + ap.ao(this.jsP.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.jsP.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.jsT.setText(lastAdditionContent);
            } else {
                this.jsT.setVisibility(8);
            }
            cqK().setHint(String.format(getPageContext().getString(d.j.write_addition_hint), Integer.valueOf(this.jsP.getAlreadyCount()), Integer.valueOf(this.jsP.getTotalCount())));
            this.mName.setText(d.j.write_addition_title);
            return;
        }
        this.jsQ.setVisibility(8);
    }

    private void cbp() {
        this.iwV = findViewById(d.g.post_prefix_layout);
        if (this.juf == null) {
            this.juf = new com.baidu.tieba.c.d(getPageContext(), this.iwV);
            this.juf.oK(d.f.bg_tip_blue_up_left);
            this.juf.oJ(16);
            this.juf.id(true);
            this.juf.aa(true);
            this.juf.oN(l.h(getActivity(), d.e.ds32));
        }
        this.iwS = (TextView) findViewById(d.g.post_prefix);
        this.jsM = findViewById(d.g.prefix_divider);
        this.iwU = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.iwV.setVisibility(0);
            this.juf.s(getString(d.j.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iwv = 0;
            this.iwV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c13013").bJ(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).k("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.iwS.setVisibility(0);
                    WriteActivity.this.iwV.setSelected(true);
                    al.c(WriteActivity.this.iwU, d.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.iwT, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.ciA.akq();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iwN);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iwR);
                }
            });
            this.iwS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c13013").bJ(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).k("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.iwS.setSelected(true);
                    al.c(WriteActivity.this.iwU, d.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.iwT, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.ciA.akq();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cqL());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cqK());
                }
            });
            this.iwT = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.iwT.a(this);
            this.iwT.setMaxHeight(l.h(getActivity(), d.e.ds510));
            this.iwT.setOutsideTouchable(true);
            this.iwT.setFocusable(true);
            this.iwT.setOnDismissListener(this);
            this.iwT.setBackgroundDrawable(al.getDrawable(d.C0236d.cp_bg_line_d));
            int color = al.getColor(d.C0236d.cp_cont_b);
            al.getColor(d.C0236d.cp_cont_c);
            al.k(this.iwS, d.C0236d.cp_bg_line_d);
            al.c(this.iwU, d.f.icon_arrow_gray_down);
            this.iwS.setTextColor(color);
            this.jsN.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.jsN.add(writePrefixItemLayout);
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
                this.iwT.addView(writePrefixItemLayout);
            }
            this.iwT.setCurrentIndex(0);
            this.iwS.setText(prefixs.get(0));
            By(0);
            return;
        }
        this.iwV.setVisibility(8);
    }

    private void cqY() {
        if (this.jtu && this.mData != null) {
            this.jtx.setVisibility(0);
            this.jty.setVisibility(0);
            this.jsL = new FeedBackModel(getPageContext());
            this.jsL.EG(this.mData.getForumName());
            this.jsL.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.24
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.jtx.setVisibility(8);
                        WriteActivity.this.jty.setVisibility(8);
                        WriteActivity.this.showToast(d.j.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.jtx.setVisibility(8);
                        WriteActivity.this.jty.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.jtx.a(feedBackModel.cqi(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void cqH() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.kY()) {
                    WriteActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (WriteActivity.this.jth.a(WriteActivity.this.iwN, WriteActivity.this.iwR)) {
                        WriteActivity.this.showToast(WriteActivity.this.jth.cnZ());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cqL());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cqK());
                    WriteActivity.this.ciA.akq();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.jtu) {
                            WriteActivity.this.cqQ();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            am amVar = new am("c12102");
                            amVar.T("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(amVar);
                            WriteActivity.this.cqR();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.cqQ();
                    }
                    TiebaStatic.log(new am("c12262").bJ("obj_locate", WriteActivity.this.fxv));
                }
            }
        });
    }

    protected void cqZ() {
        this.jtA = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.jtA.ly(getPageContext().getString(d.j.is_save_draft)).dq(false).a(getPageContext().getString(d.j.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.cqL().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.cqK().getText().toString());
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
        this.jtA.b(getPageContext());
    }

    protected void cbq() {
        this.jtw = (HeadImageView) findViewById(d.g.user_head_portrait);
        this.jtw.setIsRound(true);
        this.jtw.setDrawBorder(false);
        this.jtw.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String ms = o.ms(currentPortrait);
            this.jtw.setUrl(ms);
            this.jtw.startLoad(ms, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.jtw.setVisibility(0);
        }
        this.iwN = (EditText) findViewById(d.g.post_title);
        this.iwN.setOnClickListener(this.jtl);
        this.iwN.setOnFocusChangeListener(this.iwL);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.iwN.setText(this.mData.getTitle());
                this.iwN.setSelection(this.mData.getTitle().length());
            } else if (this.jtv) {
                this.iwN.setText(getResources().getString(d.j.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.iwN.addTextChangedListener(this.jtn);
        if (!this.mData.getHaveDraft()) {
            cqD();
            this.jua = true;
        }
        if (this.mData.isUserFeedback()) {
            this.iwN.setHint(getResources().getString(d.j.feedback_title_hint));
        } else {
            this.iwN.setHint(getResources().getString(d.j.post_title_hint));
        }
    }

    private TextWatcher Cp() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            private int juj;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.cbr();
                if (WriteActivity.this.jtb) {
                    this.juj = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.juj);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.jtb || !WriteActivity.this.jtR) {
                    if (WriteActivity.this.jtb) {
                        if (this.mEditText != WriteActivity.this.jtI || this.mTextView != WriteActivity.this.jtO) {
                            this.mEditText = WriteActivity.this.jtI;
                            this.mTextView = WriteActivity.this.jtO;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.jtM || this.mTextView != WriteActivity.this.jtN) {
                    this.mEditText = WriteActivity.this.jtM;
                    this.mTextView = WriteActivity.this.jtN;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.jtb && this.jtR) {
            if (this.jtP != null) {
                this.jtM.removeTextChangedListener(this.jtP);
            }
            this.jtP = textWatcher;
        } else if (this.jtb) {
            if (this.jtQ != null) {
                this.jtI.removeTextChangedListener(this.jtQ);
            }
            this.jtQ = textWatcher;
        }
        return textWatcher;
    }

    private long p(EditText editText) {
        if (editText == this.jtI) {
            return 233L;
        }
        if (editText != this.jtM) {
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
                    textView.setTextColor(al.getColor(d.C0236d.common_color_10159));
                } else {
                    textView.setTextColor(al.getColor(d.C0236d.cp_cont_d));
                }
            } else if (q < 0) {
                if (q < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(al.getColor(d.C0236d.common_color_10159));
            } else {
                textView.setTextColor(al.getColor(d.C0236d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long q(EditText editText) {
        return com.baidu.tieba.write.c.a.l(editText.getText().toString().trim());
    }

    protected void cbs() {
        this.iwR = (EditText) findViewById(d.g.post_content);
        this.iwR.setDrawingCacheEnabled(false);
        this.iwR.setOnClickListener(this.jtl);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString ax = TbFaceManager.anp().ax(getPageContext().getPageActivity(), this.mData.getContent());
            this.iwR.setText(ax);
            this.iwR.setSelection(ax.length());
        } else if (this.mData.getType() == 2) {
            if (this.jtB) {
                if (this.jtC != null && this.jtC.length() > 0) {
                    this.iwR.setText(getPageContext().getPageActivity().getString(d.j.reply_sub_floor, new Object[]{this.jtC}));
                    this.iwR.setSelection(this.iwR.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.j.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.iwR.setText(format);
                this.iwR.setSelection(format.length());
            }
        }
        this.iwR.setOnFocusChangeListener(this.iwL);
        this.iwR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.iwR.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iwR.addTextChangedListener(this.jto);
        if (this.mData.getType() == 0) {
            this.jue = true;
        } else {
            rj(true);
            this.jue = false;
        }
        if (this.mData.isUserFeedback()) {
            this.iwR.setHint(d.j.write_input_content);
        } else {
            this.iwR.setHint(d.j.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void rj(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.jtb) {
            cqK().setPadding(0, 0, 0, 0);
            cqK().setBackgroundDrawable(null);
            al.l(cqK(), d.C0236d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.gPx) && this.jsP == null) {
                com.baidu.adp.lib.f.c.jB().a(this.gPx, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.30
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
                            WriteActivity.this.cqK().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.cqK(), true, WriteActivity.this.hyh);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqJ() {
        int i = 5000;
        if (this.jsP != null) {
            i = 1000;
        }
        return cqK().getText() != null && cqK().getText().length() >= i;
    }

    private void oM(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.jsG)) {
                this.jsG = "";
                cqK().requestFocus();
                if (cqK().getText() != null && cqK().getText().length() + str.length() > 5000) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = cqK().getSelectionStart();
                    editable = cqK().getText();
                }
            } else if ("from_title".equals(this.jsG)) {
                this.jsG = "";
                cqL().requestFocus();
                if (cqL().getText() != null && cqL().getText().length() + str.length() > 31) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = cqL().getSelectionStart();
                    editable = cqL().getText();
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
        if (((ImageSpan[]) cqK().getText().getSpans(0, cqK().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.jsO == null) {
                this.jsO = Toast.makeText(getPageContext().getPageActivity(), d.j.too_many_face, 0);
            }
            this.jsO.show();
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
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.cqK().getSelectionStart(), aVar, agt);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cqK() != null && cqK().getText() != null) {
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
                int selectionStart = cqK().getSelectionStart() - 1;
                if (cqK().getText().length() > 1 && selectionStart >= 0 && cqK().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cqK().getText().insert(cqK().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cqK().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cqK().getText().insert(cqK().getSelectionStart(), spannableString2);
            }
            Editable text = cqK().getText();
            if (text != null) {
                this.jte.clear();
                this.jte.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jte);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cqK().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cqK().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cqK().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cqK() {
        return this.jtb ? this.jtI : this.iwR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cqL() {
        return this.jtb ? this.jtM : this.iwN;
    }

    protected void cqM() {
        Editable text;
        if (cqK() != null && (text = cqK().getText()) != null) {
            int selectionStart = cqK().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cqK().onKeyDown(67, this.eHG);
            }
            cqK().onKeyDown(67, this.eHG);
            int selectionStart2 = cqK().getSelectionStart();
            if (text != null) {
                this.jte.clear();
                this.jte.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jte);
                cqK().setSelection(selectionStart2);
            }
        }
    }

    private void l(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.j.feedback_bar_name).equals(str)) {
            this.jtu = true;
        }
    }

    private void cra() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void crb() {
        try {
            if (this.jtA != null) {
                this.jtA.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.csN.e(null);
        this.csN.hG(d.j.sending);
        this.csN.dJ(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.csN.dJ(false);
    }

    private Boolean crc() {
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

    public void cbr() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (cqL() != null) {
                str = cqL().getText().toString();
            }
            if (cqK() != null) {
                str2 = cqK().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.iwv == com.baidu.tbadk.core.util.v.S(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.jsK.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            ri(true);
                            return;
                        }
                    } else if (this.jsK.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        ri(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.jsK.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    ri(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.jtb) {
                    ri(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    ri(true);
                }
            }
            if (this.mData.getType() == 4) {
                ri(s(this.jtI) && r(this.jtM));
            } else if (this.mData.getType() == 5) {
                ri(s(this.jtI));
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
            al.c(this.mPost, d.C0236d.cp_link_tip_a, d.C0236d.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        al.d(this.mPost, d.C0236d.cp_cont_d, 1);
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
        registerListener(this.jug);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.cbj();
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
            this.jtu = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.jtv = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.jtB = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.jtC = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.ckc = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.jsP = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.jsP != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.jtD = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.mData.setTopicId(this.mTopicId);
            this.fxv = bundle.getString("KEY_CALL_FROM");
            this.jmW = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
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
            this.jtu = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.jtv = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.jtB = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.jtC = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.jsP = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.jsP != null);
            this.mData.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.jtD = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.mData.setTopicId(this.mTopicId);
            this.fxv = intent.getStringExtra("KEY_CALL_FROM");
            this.jmW = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.jtu);
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
        this.gPx = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.jsI = true;
        }
        cqE();
        try {
            this.jtS = crj();
        } catch (Throwable th) {
            this.jtS = null;
        }
    }

    private void cqN() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.iwN.setText(com.baidu.tbadk.plugins.b.pv(com.baidu.tbadk.plugins.b.pw(hotTopicBussinessData.mTopicName)));
            this.iwN.setMovementMethod(com.baidu.tieba.view.c.cmX());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString pv = com.baidu.tbadk.plugins.b.pv(com.baidu.tbadk.plugins.b.pw(hotTopicBussinessData.mTopicName));
            if (pv != null) {
                this.iwN.setText(pv);
            }
            this.jtd.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t.a
    public void a(WriteData writeData) {
        String str;
        String pw;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (com.baidu.adp.lib.util.k.isEmpty(cqL().getText().toString()) || this.jua || ((this.jtu || this.jsI) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
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
                            cqL().setText(pv);
                            cqL().setSelection(pv.length() > pw.length() ? pw.length() : pv.length());
                        }
                    } else {
                        SpannableString pv2 = com.baidu.tbadk.plugins.b.pv(this.mData.getTitle());
                        if (pv2 != null) {
                            cqL().setText(pv2);
                            cqL().setSelection(this.mData.getTitle().length() > pv2.length() ? pv2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    cqD();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.ciA.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.k.isEmpty(cqK().getText().toString()) || this.jtu || this.jsI) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.anp().a(getPageContext().getPageActivity(), this.mData.getContent(), this.jtj);
                    cqK().setText(a2);
                    cqK().setSelection(a2.length());
                    if (this.jtb) {
                        a(this.jtO, this.jtI);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    cri();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        cqT();
                    }
                    rk(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    crd();
                }
                cbr();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.jsU != null) {
                    this.jsY = this.jsV.fcB;
                    this.jsX = this.jsV.name;
                    int i = 0;
                    while (true) {
                        if (i == this.jsU.size()) {
                            break;
                        }
                        v vVar = this.jsU.get(i);
                        if (categoryTo != vVar.fcB) {
                            i++;
                        } else {
                            this.jsY = categoryTo;
                            this.jsX = vVar.name;
                            this.mData.setCategoryTo(this.jsY);
                            break;
                        }
                    }
                    if (this.jsZ != null) {
                        this.jsZ.setText(this.jsX);
                        this.jsZ.setCategoryContainerData(this.jsU, this.jsV, this.jsY);
                    }
                }
                this.ciA.akq();
                return;
            }
            return;
        }
        crd();
        cqD();
    }

    private void crd() {
        if ((!this.jtb || this.jtH != null) && this.jtG != null) {
            this.jtH.c(this.writeImagesInfo);
            crg();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.jtB);
        if (this.jtu) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.ckc);
        if (this.jsP != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.jsP));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.jtD);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.fxv);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.jmW);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cqK().getEditableText().toString();
        if (obj != null) {
            cqK().setText(TbFaceManager.anp().a(getPageContext().getPageActivity(), obj, this.jtj));
            cqK().setSelection(cqK().getText().length());
        }
    }

    private String cqO() {
        return (cqK() == null || cqK().getText() == null) ? "" : cqK().getText().toString();
    }

    private String cqP() {
        if (this.mData == null || cqL() == null || cqL().getVisibility() != 0 || cqL().getText() == null) {
            return "";
        }
        String obj = cqL().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.S(this.mPrefixData.getPrefixs()) > 0 && this.iwv != com.baidu.tbadk.core.util.v.S(this.mPrefixData.getPrefixs()) - 1 && this.mData.getType() != 4 && this.iwS != null && this.iwS.getText() != null) {
            this.mData.setPostPrefix(this.iwS.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void EH(String str) {
        if (this.mData != null && this.jsK != null) {
            if (this.jsK.getVisibility() == 0) {
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
    public void cqQ() {
        cbj();
        this.mData.setContent(cqO());
        EH(cqP());
        if (this.jtu || this.jsI) {
            String string = getResources().getString(d.j.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                EH(string + this.mData.getTitle());
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
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.jsW >= 0) {
            this.mData.setCategoryFrom(this.jsW);
        }
        if (this.jsY >= 0) {
            this.mData.setCategoryTo(this.jsY);
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
        this.mData.setHasLocationData(this.ckd != null && this.ckd.aNG());
        if (this.writeImagesInfo != null) {
            this.cke.qd(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.v.T(this.mList) && this.jtc != null && this.jtc.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.jtc.mForumId));
            this.mData.setForumName(this.jtc.mForumName);
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
        if (!this.cke.cfD()) {
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
            if (this.jsP != null) {
                i2 = this.jsP.getTotalCount();
                i = this.jsP.getAlreadyCount() + 1;
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
                if (this.iwN == getCurrentFocus()) {
                    cqK().clearFocus();
                    this.iwN.requestFocus();
                    if (this.ciA != null) {
                        this.ciA.akq();
                    }
                    ShowSoftKeyPadDelay(this.iwN);
                } else {
                    cqK().requestFocus();
                    if (this.ciA != null) {
                        this.ciA.akq();
                    }
                    ShowSoftKeyPadDelay(this.iwR);
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
                            cqK().getText().insert(cqK().getSelectionStart(), sb.toString());
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
                                crh();
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
                        if (this.jue) {
                            rj(true);
                            this.jue = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.jtb) {
                        P(intent);
                        cbr();
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
                    cbr();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.jsH) {
                                sb2.append(com.baidu.tbadk.plugins.b.csk);
                                this.jsH = false;
                            }
                            sb2.append(stringExtra);
                            oM(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.T(this.mList) && !com.baidu.tbadk.core.util.v.T(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.jtc = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.jtc);
                }
            }
        } else if (i2 == 0) {
            if (this.ciA != null && !this.ciA.alW()) {
                this.iwR.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.ciA.akq();
            }
            switch (i) {
                case 12001:
                    amC();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    crf();
                    if (this.jue) {
                        rj(true);
                        this.jue = false;
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (this.iwN == getCurrentFocus()) {
                        cqK().clearFocus();
                        this.iwN.requestFocus();
                        if (this.ciA != null) {
                            this.ciA.akq();
                        }
                        ShowSoftKeyPadDelay(this.iwN);
                        return;
                    }
                    cqK().requestFocus();
                    if (this.ciA != null) {
                        this.ciA.akq();
                    }
                    ShowSoftKeyPadDelay(this.iwR);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.jth.El(postWriteCallBackData.getErrorString());
                        this.jth.aE(postWriteCallBackData.getSensitiveWords());
                        this.jth.b(this.iwN, this.iwR);
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
                    crf();
                    return;
                case 25004:
                    if ("from_title".equals(this.jsG)) {
                        cqL().requestFocus();
                        return;
                    } else if ("from_content".equals(this.jsG)) {
                        cqK().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqR() {
        if ("1".equals(this.fxv)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.fxv)) {
            this.mData.setCanNoForum(false);
        }
        cqS();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.fxv);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cqQ();
    }

    private void cqS() {
        if (this.ciA != null) {
            this.ciA.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void cre() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void crf() {
        if (this.jtb) {
            this.jtH.c(this.writeImagesInfo);
            crg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crg() {
        this.jtH.notifyDataSetChanged();
        this.jtG.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.jtH.notifyDataSetChanged();
                WriteActivity.this.jtG.invalidateViews();
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
        cbr();
    }

    private void az(Intent intent) {
        if (this.jtb) {
            aA(intent);
            crf();
        } else {
            aD(intent);
        }
        cbr();
    }

    private void aA(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            crf();
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

    private void crh() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void aC(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.jtE.parseJson(stringExtra);
            this.jtE.updateQuality();
            if (this.jtE.getChosedFiles() != null && this.jtE.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.jtE.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.jtE.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cqL());
        HidenSoftKeyPad(this.mInputManager, cqK());
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
            cri();
            cqT();
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
                cri();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    cqT();
                }
            }
            rk(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cri() {
        if (this.ciA.jw(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void amC() {
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
        if (this.jtF != null) {
            this.jtF.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.eYS == null) {
            this.eYS = VoiceManager.instance();
        }
        return this.eYS;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bcN() {
        this.eYS = getVoiceManager();
        this.eYS.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.aB(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.fae) != null) {
                    TiebaStatic.log(new am("c12534").T("obj_locate", at.a.bLj));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.jsP == null) {
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

    private void cqT() {
        if (!this.jtb) {
            if (this.ciA != null) {
                this.ciA.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.ciA.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.jtF != null) {
                this.jtF.a(this.writeImagesInfo, this.mFrom, forumId);
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
        if (i < this.jsN.size()) {
            for (int i2 = 0; i2 < this.jsN.size(); i2++) {
                this.jsN.get(i2).qY(false);
            }
            this.jsN.get(i).qY(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void yZ(int i) {
        if (i == com.baidu.tbadk.core.util.v.S(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new am("c13014").T("obj_type", 1));
        } else {
            TiebaStatic.log(new am("c13014").T("obj_type", 2));
        }
        this.iwv = i;
        this.iwT.setCurrentIndex(i);
        By(i);
        this.iwS.setText(this.mPrefixData.getPrefixs().get(i));
        cbr();
        com.baidu.adp.lib.g.g.a(this.iwT, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.iwV.setSelected(false);
        al.c(this.iwU, d.f.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.iwR);
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
            amw();
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
        this.jtg = z;
        if (this.jtY && System.currentTimeMillis() - this.jtZ < 800) {
            l.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.jtY = false;
        }
        if (this.jtf != null && !z) {
            this.jtf.aWQ();
        }
        if (this.jti != null && !z) {
            cqw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EI(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.jtV != null) {
            EJ(str);
            this.jtV.dismiss();
        }
    }

    private void eF(Context context) {
        jtX = l.aQ(context);
    }

    private void EJ(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.j.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.jtY = true;
        cri();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            cqT();
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

    private File crj() {
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

    private void crk() {
        if (this.jtS != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            eF(getActivity());
            this.jtU = getPageContext().getPageActivity().getLayoutInflater().inflate(d.h.rec_dialog, (ViewGroup) null);
            this.jtU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.jtS != null) {
                        WriteActivity.this.EI(WriteActivity.this.jtS.getAbsolutePath());
                    }
                }
            });
            this.jtT = (TbImageView) this.jtU.findViewById(d.g.rec_img_view);
            this.jtW = (LinearLayout) this.jtU.findViewById(d.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.jtS.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.jtS.getAbsolutePath());
                Bitmap f = f(this.jtS.getAbsolutePath(), getResources().getDimensionPixelSize(d.e.ds160));
                if (f != null) {
                    this.jtT.setImageBitmap(f);
                    this.jtT.setDrawBorder(true);
                    this.jtT.setBorderWidth(2);
                    this.jtT.setBorderColor(al.getColor(d.C0236d.common_color_10264));
                    this.jtV = new Dialog(getActivity(), d.k.bubble_dialog);
                    this.jtV.setCanceledOnTouchOutside(true);
                    this.jtV.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.jtY) {
                                l.b(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.jtZ = System.currentTimeMillis();
                            }
                        }
                    });
                    this.jtV.setContentView(this.jtU);
                    this.jtV.show();
                    Window window = this.jtV.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.e.ds28);
                    attributes.y = (jtX / 18) + getResources().getDimensionPixelSize(d.e.ds12);
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
        if (this.jtg && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.jsH = false;
            this.jsG = "";
            if ("from_content".equals(str)) {
                this.jsG = "from_content";
            } else if ("from_title".equals(str)) {
                this.jsG = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.pu(String.valueOf(charSequence.charAt(i)))) {
                rh(false);
            }
        }
    }

    public void bXu() {
        if (this.jtu || !com.baidu.tbadk.core.util.v.T(this.mList) || !StringUtils.isNull(this.mData.getTitle())) {
            this.jsK.setVisibility(0);
            this.jsK.requestFocus();
            this.ciA.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.jsK.setVisibility(8);
    }
}
