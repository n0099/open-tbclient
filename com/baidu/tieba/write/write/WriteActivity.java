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
    private static int jtG = 0;
    private EditorTools ciD;
    private String ckf;
    private LocationModel ckg;
    private NewWriteModel ckh;
    private VoiceManager eYE;
    private LinearLayout hrf;
    private PlayVoiceBntNew hrg;
    private ImageView hri;
    private boolean isPrivacy;
    private int ivZ;
    private TextView iww;
    private com.baidu.tieba.write.h iwx;
    private ImageView iwy;
    private View iwz;
    private com.baidu.tieba.write.b.c jqz;
    private TextView jsA;
    private TextView jsB;
    private TextView jsC;
    List<v> jsD;
    v jsE;
    private int jsF;
    private String jsG;
    private int jsH;
    private PostCategoryView jsI;
    private HotTopicBussinessData jsL;
    private TextView jsM;
    private com.baidu.tieba.write.editor.b jsO;
    private e jsR;
    private com.baidu.tieba.view.b jsY;
    private LinearLayout jss;
    private LinearLayout jst;
    private View jsv;
    private Toast jsx;
    private AdditionData jsy;
    private RelativeLayout jsz;
    private View jtK;
    private View jtL;
    private TextView jtM;
    private com.baidu.tieba.c.d jtO;
    private View jth;
    private g jto;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String jsp = "";
    private boolean jsq = false;
    private WriteData mData = null;
    private boolean jtd = false;
    private boolean jsr = false;
    private boolean jte = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText iwr = null;
    private HeadImageView jtf = null;
    private View iws = null;
    private LinearLayout iwu = null;
    private EditText iwv = null;
    private FeedBackModel jsu = null;
    private FeedBackTopListView jtg = null;
    private ArrayList<WritePrefixItemLayout> jsw = new ArrayList<>();
    private String gPk = null;
    private final KeyEvent eHp = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View bWc = null;
    private TextView jti = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a jtj = null;
    private final Handler mHandler = new Handler();
    private boolean jtk = false;
    private String jtl = null;
    private RelativeLayout mParent = null;
    private String ckl = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int ckm = 0;
    private int jtm = 0;
    private WriteImagesInfo jtn = new WriteImagesInfo();
    private View mRootView = null;
    private GridView jtp = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a jtq = null;
    private ScrollView jsJ = null;
    private EditText jtr = null;
    private View jts = null;
    private View jtt = null;
    private View jtu = null;
    private EditText jtv = null;
    private TextView jtw = null;
    private TextView jtx = null;
    private TextWatcher jty = null;
    private TextWatcher jtz = null;
    private boolean jsK = false;
    private boolean jtA = false;
    private com.baidu.tbadk.core.view.b csN = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private File jtB = null;
    private TbImageView jtC = null;
    private View jtD = null;
    private Dialog jtE = null;
    private LinearLayout jtF = null;
    private boolean jtH = false;
    private long jtI = -1000;
    private boolean jtJ = false;
    private String fxi = "2";
    private int jmD = 0;
    private String mTopicId = "";
    private SpannableStringBuilder jsN = new SpannableStringBuilder();
    private boolean jtN = false;
    private boolean jsP = false;
    private final b jsQ = new b();
    private final HttpMessageListener jtP = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.gPk)) {
                    WriteActivity.this.gPk = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.rj(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.gPk)) {
                    WriteActivity.this.gPk = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.gPk);
                    WriteActivity.this.rj(true);
                }
            }
        }
    };
    private TbFaceManager.a jsS = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan pf(String str) {
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
    private final AntiHelper.a eZQ = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLn));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLn));
        }
    };
    private final NewWriteModel.d ckv = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.bcK();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.jsQ.aE(null);
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
                    WriteActivity.this.jsQ.aE(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.jsQ.Ei(postWriteCallBackData.getErrorString());
                    WriteActivity.this.jsQ.b(WriteActivity.this.iwr, WriteActivity.this.iwv);
                } else if ((xVar == null || writeData == null || xVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (xVar != null && writeData != null && xVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.agB());
                    if (com.baidu.tbadk.u.a.pU(xVar.agA())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, xVar.agA());
                        if (WriteActivity.this.jte) {
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
    private final LocationModel.a ckt = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.40
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void amG() {
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
            if (aVar != null && !StringUtils.isNull(aVar.ceS())) {
                WriteActivity.this.b(2, true, aVar.ceS());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener iIh = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.WriteActivity.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.ckg.qb(false);
                    WriteActivity.this.ckg.ea(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.ckg.qb(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener jsT = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener jsU = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.43
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.ciD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cqt = WriteActivity.this.cqt();
            if (cqt >= 0 && cqt < WriteActivity.this.iwv.getText().length()) {
                WriteActivity.this.iwv.setSelection(cqt);
            }
        }
    };
    private boolean jsV = true;
    private final View.OnFocusChangeListener iwp = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.iwr || view == WriteActivity.this.bWc || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.jsV = true;
                    WriteActivity.this.cqu();
                    l.c(WriteActivity.this.getActivity(), WriteActivity.this.iwr);
                    if (WriteActivity.this.ciD != null) {
                        WriteActivity.this.ciD.akm();
                    }
                } else if (view == WriteActivity.this.iwr) {
                    WriteActivity.this.iww.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.iwv && z) {
                WriteActivity.this.jsV = false;
                WriteActivity.this.cqu();
                l.c(WriteActivity.this.getActivity(), WriteActivity.this.iwv);
                if (WriteActivity.this.ciD != null) {
                    WriteActivity.this.ciD.akm();
                }
            }
            WriteActivity.this.cqA();
        }
    };
    private TextWatcher jsW = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String jta = "";
        private String jtb;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jtb = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jtb != null ? this.jtb.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cbp();
            WriteActivity.this.cqB();
            EditText cqM = WriteActivity.this.cqM();
            if (editable != null && cqM != null && cqM.getText() != null) {
                if (this.jta == null || !this.jta.equals(editable.toString())) {
                    if (WriteActivity.this.jsQ != null) {
                        this.jta = cqM.getText().toString();
                        WriteActivity.this.jsQ.o(cqM);
                        return;
                    }
                    return;
                }
                cqM.setSelection(cqM.getSelectionEnd());
            }
        }
    };
    private TextWatcher jsX = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String jtb;
        private String jtc = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jtb = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jtb != null ? this.jtb.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cbp();
            EditText cqL = WriteActivity.this.cqL();
            if (editable != null && cqL != null && cqL.getText() != null) {
                if (this.jtc == null || !this.jtc.equals(editable.toString())) {
                    if (WriteActivity.this.jsQ != null) {
                        this.jtc = cqL.getText().toString();
                        WriteActivity.this.jsQ.o(cqL);
                        return;
                    }
                    return;
                }
                cqL.setSelection(cqL.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0388a hxO = new a.InterfaceC0388a() { // from class: com.baidu.tieba.write.write.WriteActivity.31
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0388a
        public void onRefresh() {
            WriteActivity.this.gPk = null;
            WriteActivity.this.rj(false);
            WriteActivity.this.ciD.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void amr() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void ams() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            amu();
        } else if (this.ckg.ceZ()) {
            amr();
        } else {
            this.ckg.qb(false);
            b(1, true, null);
            this.ckg.ceX();
        }
    }

    private void amu() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.gC(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kY()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.ckg.aNy();
                } else {
                    WriteActivity.this.ckt.amG();
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
        aVar.aaW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cqt() {
        int selectionEnd = cqL().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cqL().getText().getSpans(0, cqL().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cqL().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cqL().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqu() {
        if (this.ciD != null) {
            this.ciD.setBarLauncherEnabled(!this.jsV);
            this.ciD.setBarLauncherEnabled(true, 26);
            this.ciD.setBarLauncherEnabled(true, 2);
            Q(9, this.jsV ? false : true);
        }
    }

    private void Q(int i, boolean z) {
        com.baidu.tbadk.editortools.g js;
        if (this.ciD != null && (js = this.ciD.js(i)) != null) {
            if (z) {
                js.qT();
            } else {
                js.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.jsK) {
            this.iwr.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.jtu.setVisibility(8);
            } else {
                this.jtu.setVisibility(0);
            }
            a(this.jtx, this.jtr);
            a(this.jtw, this.jtv);
            cbp();
        }
        if (this.jtd) {
            this.jsV = true;
            cqu();
            if (this.ciD != null) {
                this.ciD.akm();
            }
            this.iwr.requestFocus();
            ShowSoftKeyPadDelay(this.iwr);
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
            crj();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                cqU();
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
            Bv(this.jmD);
        }
        initUI();
        cqZ();
        this.ckg = new LocationModel(this);
        this.ckg.a(this.ckt);
        registerListener(this.iIh);
        registerListener(this.jsT);
        initEditor();
        crl();
        if (this.jsK) {
            this.jtq.setEditorTools(this.ciD);
        } else {
            this.iwv.requestFocus();
        }
        bXs();
        cqU();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.ciD = new EditorTools(getActivity());
        this.ciD.setBarMaxLauCount(5);
        this.ciD.setMoreButtonAtEnd(true);
        this.ciD.setBarLauncherType(1);
        this.ciD.eH(true);
        this.ciD.eI(true);
        this.ciD.setMoreLauncherIcon(d.f.write_more);
        this.ciD.setBackgroundColorId(d.C0277d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                cqX();
                break;
            default:
                cqv();
                break;
        }
        this.ciD.alQ();
        if (this.jss != null) {
            this.jss.addView(this.ciD);
        }
        cqw();
        this.ciD.qT();
        com.baidu.tbadk.editortools.g js = this.ciD.js(6);
        if (js != null && !TextUtils.isEmpty(this.ckl)) {
            ((View) js).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.ckl);
                }
            });
        }
        if (!this.jsK) {
            this.ciD.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.ciD.akm();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.ciD.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.ciD.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        cqy();
    }

    private void cqV() {
        this.jts = this.mRootView.findViewById(d.g.photo_live_scroll);
        this.jtu = this.jts.findViewById(d.g.live_post_title_container);
        this.jtr = (EditText) this.jts.findViewById(d.g.live_post_content);
        this.jtp = (GridView) this.jts.findViewById(d.g.photoLiveGridView);
        this.jtv = (EditText) this.jts.findViewById(d.g.live_post_title);
        this.jtw = (TextView) this.jts.findViewById(d.g.titleOverPlusNumber);
        this.jtx = (TextView) this.jts.findViewById(d.g.contentOverPlusNumber);
        this.jtt = this.jts.findViewById(d.g.live_interval_view);
        this.jtw.setText(String.valueOf(20));
        this.jtx.setText(String.valueOf(233));
        this.jts.setVisibility(0);
        this.jtw.setVisibility(0);
        this.jtx.setVisibility(0);
        this.jtv.setHint(d.j.tips_title_limit_new);
        this.jtv.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.jtA = true;
                    WriteActivity.this.jsV = true;
                    WriteActivity.this.cqu();
                    if (WriteActivity.this.ciD != null) {
                        WriteActivity.this.ciD.akm();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.jtr.setHint(d.j.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.jtr.setHint(d.j.live_write_input_content_update);
        }
        this.jtr.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.jtA = false;
                    WriteActivity.this.jsV = false;
                    WriteActivity.this.cqu();
                    if (WriteActivity.this.ciD != null) {
                        WriteActivity.this.ciD.akm();
                    }
                }
            }
        });
        this.jtr.requestFocus();
        this.jtr.addTextChangedListener(Cn());
        this.jtv.requestFocus();
        this.jtv.addTextChangedListener(Cn());
        this.jtv.setOnClickListener(this.jsU);
        this.jtr.setOnClickListener(this.jsU);
        this.jtq = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.jtp);
        this.jtq.Bp(6);
        this.jtp.setAdapter((ListAdapter) this.jtq);
        View findViewById = this.jts.findViewById(d.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void cqe() {
                WriteActivity.this.crh();
            }
        });
        cqW();
    }

    private void cqW() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.jtv.setText(this.mData.getTitle());
                this.jtv.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.jsK) {
            crf();
        }
        if (this.ciD.alS()) {
            this.ciD.akm();
        }
        Bv(0);
    }

    private void Bv(int i) {
        if (this.writeImagesInfo != null && this.mData != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.fxi);
            albumActivityConfig.setProfessionZone(this.mData.getProZone());
            sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void cqX() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.ciD.ab(arrayList);
        com.baidu.tbadk.editortools.k jv = this.ciD.jv(5);
        if (jv != null) {
            jv.cjn = 2;
            jv.cjl = d.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.cjl = d.f.write_at;
        this.ciD.b(aVar);
        this.ciD.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void cqv() {
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        com.baidu.tbadk.editortools.k kVar3;
        com.baidu.tbadk.editortools.k kVar4;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.k kVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.cjl = d.f.write_picture;
        this.ciD.b(dVar);
        Boolean crd = crd();
        if (!this.jtd && crd != null && crd.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.cfA() && p.b(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), com.baidu.tbadk.editortools.k.class)) != null && (kVar5 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar5.cjn = 3;
            kVar5.cjl = d.f.write_recorder;
            this.ciD.b(kVar5);
        }
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        aVar.cjl = d.f.icon_post_topic_selector;
        this.ciD.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001343, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask2 != null && (kVar4 = (com.baidu.tbadk.editortools.k) runTask2.getData()) != null) {
            kVar4.cjn = 5;
            kVar4.cjl = d.f.write_privilege;
            this.ciD.b(kVar4);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask3 != null && (kVar3 = (com.baidu.tbadk.editortools.k) runTask3.getData()) != null) {
            kVar3.cjn = 6;
            kVar3.cjl = this.jtd ? d.f.write_location : d.f.icon_post_more_location;
            this.ciD.b(kVar3);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 7);
        aVar2.cjl = d.f.icon_post_more_at;
        this.ciD.b(aVar2);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask4 != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
            kVar2.cjp = true;
            kVar2.cjn = 9;
            kVar2.cjl = 0;
            this.ciD.b(kVar2);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask5 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask5.getData()) != null) {
            kVar.cjp = true;
            kVar.cjn = 10;
            kVar.cjl = 0;
            this.ciD.b(kVar);
        }
        if (this.jsy == null) {
            if (this.jsO == null) {
                this.jsO = new com.baidu.tieba.write.editor.b(getActivity(), this.fxi);
                this.jsO.bw(this.mData.getForumId(), this.privateThread);
            }
            this.ciD.b(this.jsO);
        }
        this.ciD.ab(arrayList);
        com.baidu.tbadk.editortools.k jv = this.ciD.jv(5);
        if (jv != null) {
            jv.cjn = 1;
            jv.cjl = d.f.write_emotion;
        }
    }

    private void cqx() {
        if (this.jsR != null) {
            this.jsR.hideTip();
        }
    }

    private void cqy() {
        if (this.jsR == null) {
            this.jsR = new e(getPageContext());
        }
        this.jsR.c(this.ciD);
    }

    private void cqw() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.cqK()) {
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
                            if (pVar.agq() == EmotionGroupType.BIG_EMOTION || pVar.agq() == EmotionGroupType.USER_COLLECT) {
                                if (WriteActivity.this.mCurrentPermissionJudgePolicy == null) {
                                    WriteActivity.this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                                }
                                WriteActivity.this.mCurrentPermissionJudgePolicy.adN();
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
                                    WriteActivity.this.cbp();
                                }
                            } else if (WriteActivity.this.cqK()) {
                                WriteActivity.this.showToast(d.j.over_limit_tip);
                            } else {
                                WriteActivity.this.e(pVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.cqN();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bKI();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.crj();
                        WriteActivity.this.cbp();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.Bw(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new am("c12612").T("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.jsy == null) {
                            WriteActivity.this.amv();
                            return;
                        }
                        switch (WriteActivity.this.ckm) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.cR(pageActivity)) {
                                    WriteActivity.this.ams();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.amr();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.ckg != null) {
                            WriteActivity.this.ckg.qb(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.gPk = null;
                        } else {
                            WriteActivity.this.gPk = (String) aVar.data;
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
                            WriteActivity.this.ciD.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.ciD.alS()) {
                                        WriteActivity.this.ciD.akm();
                                        WriteActivity.this.ciD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.ciD.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.ciD.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.ciD.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.ciD.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.cbp();
                        if (WriteActivity.this.iwv != null) {
                            WriteActivity.this.iwv.requestFocus();
                        }
                        WriteActivity.this.ciD.akm();
                        WriteActivity.this.ciD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iwv);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new am("c12612").T("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.ciD.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.jsq = true;
                        WriteActivity.this.rh(true);
                        if (!WriteActivity.this.cqM().isFocused() || WriteActivity.this.jst.getVisibility() != 0) {
                            WriteActivity.this.jsp = "from_content";
                        } else {
                            WriteActivity.this.jsp = "from_title";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.jst.setVisibility(0);
                        WriteActivity.this.jst.requestFocus();
                        WriteActivity.this.cbp();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.jst.hasFocus()) {
                            WriteActivity.this.iwv.requestFocus();
                            WriteActivity.this.iwv.setSelection(WriteActivity.this.iwv.getText().toString().length());
                        }
                        WriteActivity.this.jst.setVisibility(8);
                        WriteActivity.this.cbp();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.ciD.setActionListener(16, bVar);
        this.ciD.setActionListener(14, bVar);
        this.ciD.setActionListener(24, bVar);
        this.ciD.setActionListener(3, bVar);
        this.ciD.setActionListener(10, bVar);
        this.ciD.setActionListener(11, bVar);
        this.ciD.setActionListener(12, bVar);
        this.ciD.setActionListener(13, bVar);
        this.ciD.setActionListener(15, bVar);
        this.ciD.setActionListener(18, bVar);
        this.ciD.setActionListener(20, bVar);
        this.ciD.setActionListener(25, bVar);
        this.ciD.setActionListener(27, bVar);
        this.ciD.setActionListener(29, bVar);
        this.ciD.setActionListener(43, bVar);
        this.ciD.setActionListener(45, bVar);
        this.ciD.setActionListener(53, bVar);
        this.ciD.setActionListener(48, bVar);
        this.ciD.setActionListener(46, bVar);
        this.ciD.setActionListener(49, bVar);
        this.ciD.setActionListener(47, bVar);
        this.ciD.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bw(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amv() {
        if (this.ckg.aNu()) {
            if (this.ckg.ceZ()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.ceV().getLocationData().ceS());
                return;
            }
            b(1, true, null);
            this.ckg.ceX();
            return;
        }
        b(0, true, null);
    }

    protected void cbh() {
        if (this.ckh != null) {
            this.ckh.cancelLoadData();
        }
        if (this.jsu != null) {
            this.jsu.cancelLoadData();
        }
        if (this.ckg != null) {
            this.ckg.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cqx();
        TiebaPrepareImageService.StopService();
        cbh();
        crc();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.jto != null) {
            this.jto.destroy();
        }
        if (this.jtO != null) {
            this.jtO.aSp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqz() {
        if (this.mData != null && this.mData.getType() == 2 && this.jtk) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(cqM().getText().toString());
            this.mData.setContent(cqL().getText().toString());
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
            if (this.iwx != null && this.iwx.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.iwx, getPageContext().getPageActivity());
                return true;
            } else if (this.ciD.alS()) {
                this.ciD.akm();
                return true;
            } else {
                cbh();
                cqz();
                return true;
            }
        }
        if (i == 67 && (text = cqL().getText()) != null) {
            int selectionStart = cqL().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cqL().onKeyDown(67, this.eHp);
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
        getLayoutMode().onModeChanged(this.jtF);
        if (this.jtC != null && i == 1) {
            this.jtC.setBorderColor(al.getColor(d.C0277d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.d(this.mPost, d.C0277d.cp_link_tip_a, 1);
        cqu();
        al.l(this.jts, d.C0277d.cp_bg_line_d);
        al.l(this.iws, d.C0277d.cp_bg_line_c);
        al.l(this.jtt, d.C0277d.cp_bg_line_c);
        al.l(cqM(), d.C0277d.cp_bg_line_d);
        al.c(this.hri, d.f.icon_edit_close_n);
        if (TextUtils.isEmpty(this.gPk)) {
            al.l(cqL(), d.C0277d.cp_bg_line_d);
        }
        cbp();
        this.ciD.onChangeSkinType(i);
        if (this.jsI != null) {
            this.jsI.aeH();
        }
        al.j(this.mName, d.C0277d.cp_cont_b);
        cqA();
        cqB();
        if (this.jsQ != null) {
            this.jsQ.c(cqM(), cqL());
        }
        this.jqz.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqA() {
        if (this.iwr.hasFocus()) {
            this.iwr.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        } else {
            this.iwr.setHintTextColor(al.getColor(d.C0277d.cp_cont_d));
        }
        if (this.iwv.hasFocus()) {
            this.iwv.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        } else {
            this.iwv.setHintTextColor(al.getColor(d.C0277d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqB() {
        if (this.iwr != null && this.iwr.getText() != null && this.iwr.getText().toString() != null && this.iwr.getPaint() != null) {
            if (this.iwr.getText().toString().length() == 0) {
                this.iwr.getPaint().setFakeBoldText(false);
            } else if (this.iwr.getText().toString().length() > 0) {
                this.iwr.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.csN = new com.baidu.tbadk.core.view.b(getPageContext());
        this.jsK = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.bWc = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        al.j(this.mName, d.C0277d.cp_cont_b);
        this.jti = (TextView) findViewById(d.g.btn_image_problem);
        cqD();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.iwp);
        this.jsJ = (ScrollView) findViewById(d.g.write_scrollview);
        this.jsJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.iwv != null) {
                        l.b(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.iwv);
                    }
                    if (WriteActivity.this.ciD != null) {
                        WriteActivity.this.ciD.akm();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jtg = (FeedBackTopListView) findViewById(d.g.feedback_top_list);
        this.jth = findViewById(d.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.jss = (LinearLayout) findViewById(d.g.tool_view);
        this.jss.setContentDescription("..");
        this.jst = (LinearLayout) findViewById(d.g.title_view);
        this.iws = findViewById(d.g.interval_view);
        this.jtK = findViewById(d.g.hot_topic_fourm_view);
        this.jtL = findViewById(d.g.hot_topic_divider);
        this.jsM = (TextView) findViewById(d.g.hot_topic_title_edt);
        this.jtM = (TextView) findViewById(d.g.change_one_tv);
        cbo();
        if (this.jsK) {
            this.jsJ.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            cqV();
        } else {
            this.jto = new g(getPageContext(), this.mRootView);
            g gVar = this.jto;
            if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                z = false;
            }
            gVar.rc(z);
        }
        cbq();
        if (this.jtd || this.jsr) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().bLY) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.iwu = (LinearLayout) findViewById(d.g.post_content_container);
        this.iwu.setDrawingCacheEnabled(false);
        this.iwu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.ciD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.iwv.requestFocus();
            }
        });
        this.hrf = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.hrg = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.hri = (ImageView) findViewById(d.g.iv_delete_voice);
        this.hri.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bKI();
            }
        });
        this.bWc.setOnFocusChangeListener(this.iwp);
        this.bWc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cbh();
                WriteActivity.this.cqz();
            }
        });
        this.jti.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        cqG();
        l(crd());
        cqI();
        cqC();
        cra();
        crb();
        cqu();
        cqH();
        cbn();
        cqO();
        if (this.mData.getType() == 4 && this.iwz != null && this.jsv != null) {
            this.iwz.setVisibility(8);
            this.jsv.setVisibility(8);
        }
        cbp();
        cqY();
        cpK();
    }

    private void cpK() {
        this.jqz = new com.baidu.tieba.write.b.c(getPageContext().getPageActivity(), this.mName, this.mData.getProZone(), isUseStyleImmersiveSticky() ? StatusBarUtil.getStatusBarOffsetPx(getPageContext().getPageActivity()) : 0);
        this.jqz.a(new c.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // com.baidu.tieba.write.b.c.a
            public void Bk(int i) {
                WriteActivity.this.mData.setProZone(i);
            }
        });
        this.jqz.aWD();
    }

    private void cqC() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.jtd || this.jsr) {
                        if (this.jte) {
                            this.mName.setText(d.j.feedback_vcode);
                        } else {
                            this.mName.setText(d.j.feedback);
                        }
                    } else if (this.fxi != null && this.fxi.equals("1")) {
                        this.mName.setText(d.j.post_to_home_page);
                    } else if (this.fxi != null && this.fxi.equals("2")) {
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
                    this.iwr.setVisibility(0);
                    this.iwv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(d.j.send_reply);
                    this.iwv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.iwr.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(d.j.publish_photo_live);
                    this.iwv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(d.j.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.jtt.setVisibility(8);
                    return;
                case 7:
                    this.iwr.setVisibility(0);
                    this.iwv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    this.mName.setText(d.j.post_drift_bottle);
                    return;
            }
        }
    }

    private void cqD() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
    }

    private void cqE() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.jtd && !this.jsr && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String f = ap.f(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(f) && cqM() != null) {
                cqM().setText(f);
                cqM().setSelection(f.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.hrf.setVisibility(0);
            this.hrg.setVoiceModel(voiceModel);
            this.hrg.cfz();
            cbp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKI() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.bo(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.hrf.setVisibility(8);
        this.hrg.bol();
        this.hrg.setVoiceModel(null);
        com.baidu.tbadk.editortools.k jv = this.ciD.jv(6);
        if (jv != null && jv.cix != null) {
            jv.cix.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cbp();
    }

    private void cqF() {
        this.jsD = null;
        this.jsF = -1;
        this.jsH = -1;
        com.baidu.tieba.frs.x ql = w.beh().ql(1);
        if (ql != null) {
            this.jsD = ql.fcr;
            this.jsF = getIntent().getIntExtra("category_id", -1);
            if (this.jsD != null && !this.jsD.isEmpty() && this.jsF >= 0) {
                this.jsE = new v();
                this.jsE.fcn = 0;
                this.jsE.name = getPageContext().getResources().getString(d.j.category_auto);
                this.jsH = this.jsE.fcn;
                this.jsG = this.jsE.name;
                for (v vVar : this.jsD) {
                    if (vVar.fcn == this.jsF) {
                        this.jsH = vVar.fcn;
                        this.jsG = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cqG() {
        if (this.jsD != null && !this.jsD.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.jsI = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.jsI.setText(this.jsG);
            this.jsI.setCategoryContainerData(this.jsD, this.jsE, this.jsH);
            this.jsI.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ar arVar) {
                    if (arVar != null) {
                        WriteActivity.this.jsI.setText(arVar.name);
                        WriteActivity.this.mData.setCategoryTo(arVar.fcn);
                        WriteActivity.this.jsH = arVar.fcn;
                        WriteActivity.this.jsI.cqh();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.jsI.cqg();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cqM());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cqL());
                }
            });
        }
    }

    private void cqY() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.jsY = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.jsY.setTitle(d.j.no_disturb_start_time);
        this.jsY.setButton(-1, getPageContext().getString(d.j.alert_yes_button), this.jsY);
        this.jsY.setButton(-2, getPageContext().getString(d.j.cancel), this.jsY);
        return this.jsY;
    }

    private void cqH() {
        this.jsz = (RelativeLayout) findViewById(d.g.addition_container);
        this.jsA = (TextView) findViewById(d.g.addition_create_time);
        this.jsB = (TextView) findViewById(d.g.addition_last_time);
        this.jsC = (TextView) findViewById(d.g.addition_last_content);
        if (this.jsy != null) {
            this.jsz.setVisibility(0);
            this.jsA.setText(getPageContext().getString(d.j.write_addition_create) + ap.ao(this.jsy.getCreateTime() * 1000));
            if (this.jsy.getAlreadyCount() == 0) {
                this.jsB.setVisibility(8);
            } else {
                this.jsB.setText(getPageContext().getString(d.j.write_addition_last) + ap.ao(this.jsy.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.jsy.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.jsC.setText(lastAdditionContent);
            } else {
                this.jsC.setVisibility(8);
            }
            cqL().setHint(String.format(getPageContext().getString(d.j.write_addition_hint), Integer.valueOf(this.jsy.getAlreadyCount()), Integer.valueOf(this.jsy.getTotalCount())));
            this.mName.setText(d.j.write_addition_title);
            return;
        }
        this.jsz.setVisibility(8);
    }

    private void cbn() {
        this.iwz = findViewById(d.g.post_prefix_layout);
        if (this.jtO == null) {
            this.jtO = new com.baidu.tieba.c.d(getPageContext(), this.iwz);
            this.jtO.oG(d.f.bg_tip_blue_up_left);
            this.jtO.oF(16);
            this.jtO.id(true);
            this.jtO.aa(true);
            this.jtO.oJ(l.h(getActivity(), d.e.ds32));
        }
        this.iww = (TextView) findViewById(d.g.post_prefix);
        this.jsv = findViewById(d.g.prefix_divider);
        this.iwy = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.iwz.setVisibility(0);
            this.jtO.s(getString(d.j.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.ivZ = 0;
            this.iwz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c13013").bJ(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).k("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.iww.setVisibility(0);
                    WriteActivity.this.iwz.setSelected(true);
                    al.c(WriteActivity.this.iwy, d.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.iwx, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.ciD.akm();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iwr);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iwv);
                }
            });
            this.iww.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c13013").bJ(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).k("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.iww.setSelected(true);
                    al.c(WriteActivity.this.iwy, d.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.iwx, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.ciD.akm();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cqM());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cqL());
                }
            });
            this.iwx = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.iwx.a(this);
            this.iwx.setMaxHeight(l.h(getActivity(), d.e.ds510));
            this.iwx.setOutsideTouchable(true);
            this.iwx.setFocusable(true);
            this.iwx.setOnDismissListener(this);
            this.iwx.setBackgroundDrawable(al.getDrawable(d.C0277d.cp_bg_line_d));
            int color = al.getColor(d.C0277d.cp_cont_b);
            al.getColor(d.C0277d.cp_cont_c);
            al.k(this.iww, d.C0277d.cp_bg_line_d);
            al.c(this.iwy, d.f.icon_arrow_gray_down);
            this.iww.setTextColor(color);
            this.jsw.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.jsw.add(writePrefixItemLayout);
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
                this.iwx.addView(writePrefixItemLayout);
            }
            this.iwx.setCurrentIndex(0);
            this.iww.setText(prefixs.get(0));
            Bu(0);
            return;
        }
        this.iwz.setVisibility(8);
    }

    private void cqZ() {
        if (this.jtd && this.mData != null) {
            this.jtg.setVisibility(0);
            this.jth.setVisibility(0);
            this.jsu = new FeedBackModel(getPageContext());
            this.jsu.ED(this.mData.getForumName());
            this.jsu.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.24
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.jtg.setVisibility(8);
                        WriteActivity.this.jth.setVisibility(8);
                        WriteActivity.this.showToast(d.j.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.jtg.setVisibility(8);
                        WriteActivity.this.jth.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.jtg.a(feedBackModel.cqj(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void cqI() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.kY()) {
                    WriteActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (WriteActivity.this.jsQ.a(WriteActivity.this.iwr, WriteActivity.this.iwv)) {
                        WriteActivity.this.showToast(WriteActivity.this.jsQ.coa());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cqM());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cqL());
                    WriteActivity.this.ciD.akm();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.jtd) {
                            WriteActivity.this.cqR();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            am amVar = new am("c12102");
                            amVar.T("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(amVar);
                            WriteActivity.this.cqS();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.cqR();
                    }
                    TiebaStatic.log(new am("c12262").bJ("obj_locate", WriteActivity.this.fxi));
                }
            }
        });
    }

    protected void cra() {
        this.jtj = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.jtj.lz(getPageContext().getString(d.j.is_save_draft)).dq(false).a(getPageContext().getString(d.j.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.cqM().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.cqL().getText().toString());
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
        this.jtj.b(getPageContext());
    }

    protected void cbo() {
        this.jtf = (HeadImageView) findViewById(d.g.user_head_portrait);
        this.jtf.setIsRound(true);
        this.jtf.setDrawBorder(false);
        this.jtf.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String mt = o.mt(currentPortrait);
            this.jtf.setUrl(mt);
            this.jtf.startLoad(mt, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.jtf.setVisibility(0);
        }
        this.iwr = (EditText) findViewById(d.g.post_title);
        this.iwr.setOnClickListener(this.jsU);
        this.iwr.setOnFocusChangeListener(this.iwp);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.iwr.setText(this.mData.getTitle());
                this.iwr.setSelection(this.mData.getTitle().length());
            } else if (this.jte) {
                this.iwr.setText(getResources().getString(d.j.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.iwr.addTextChangedListener(this.jsW);
        if (!this.mData.getHaveDraft()) {
            cqE();
            this.jtJ = true;
        }
        if (this.mData.isUserFeedback()) {
            this.iwr.setHint(getResources().getString(d.j.feedback_title_hint));
        } else {
            this.iwr.setHint(getResources().getString(d.j.post_title_hint));
        }
    }

    private TextWatcher Cn() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            private int jtS;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.cbp();
                if (WriteActivity.this.jsK) {
                    this.jtS = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.jtS);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.jsK || !WriteActivity.this.jtA) {
                    if (WriteActivity.this.jsK) {
                        if (this.mEditText != WriteActivity.this.jtr || this.mTextView != WriteActivity.this.jtx) {
                            this.mEditText = WriteActivity.this.jtr;
                            this.mTextView = WriteActivity.this.jtx;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.jtv || this.mTextView != WriteActivity.this.jtw) {
                    this.mEditText = WriteActivity.this.jtv;
                    this.mTextView = WriteActivity.this.jtw;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.jsK && this.jtA) {
            if (this.jty != null) {
                this.jtv.removeTextChangedListener(this.jty);
            }
            this.jty = textWatcher;
        } else if (this.jsK) {
            if (this.jtz != null) {
                this.jtr.removeTextChangedListener(this.jtz);
            }
            this.jtz = textWatcher;
        }
        return textWatcher;
    }

    private long p(EditText editText) {
        if (editText == this.jtr) {
            return 233L;
        }
        if (editText != this.jtv) {
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

    protected void cbq() {
        this.iwv = (EditText) findViewById(d.g.post_content);
        this.iwv.setDrawingCacheEnabled(false);
        this.iwv.setOnClickListener(this.jsU);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString ax = TbFaceManager.anl().ax(getPageContext().getPageActivity(), this.mData.getContent());
            this.iwv.setText(ax);
            this.iwv.setSelection(ax.length());
        } else if (this.mData.getType() == 2) {
            if (this.jtk) {
                if (this.jtl != null && this.jtl.length() > 0) {
                    this.iwv.setText(getPageContext().getPageActivity().getString(d.j.reply_sub_floor, new Object[]{this.jtl}));
                    this.iwv.setSelection(this.iwv.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.j.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.iwv.setText(format);
                this.iwv.setSelection(format.length());
            }
        }
        this.iwv.setOnFocusChangeListener(this.iwp);
        this.iwv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.ciD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.iwv.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iwv.addTextChangedListener(this.jsX);
        if (this.mData.getType() == 0) {
            this.jtN = true;
        } else {
            rj(true);
            this.jtN = false;
        }
        if (this.mData.isUserFeedback()) {
            this.iwv.setHint(d.j.write_input_content);
        } else {
            this.iwv.setHint(d.j.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void rj(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.jsK) {
            cqL().setPadding(0, 0, 0, 0);
            cqL().setBackgroundDrawable(null);
            al.l(cqL(), d.C0277d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.gPk) && this.jsy == null) {
                com.baidu.adp.lib.f.c.jB().a(this.gPk, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.30
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
                            WriteActivity.this.cqL().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.cqL(), true, WriteActivity.this.hxO);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqK() {
        int i = UIMsg.m_AppUI.MSG_APP_GPS;
        if (this.jsy != null) {
            i = 1000;
        }
        return cqL().getText() != null && cqL().getText().length() >= i;
    }

    private void oN(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.jsp)) {
                this.jsp = "";
                cqL().requestFocus();
                if (cqL().getText() != null && cqL().getText().length() + str.length() > 5000) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = cqL().getSelectionStart();
                    editable = cqL().getText();
                }
            } else if ("from_title".equals(this.jsp)) {
                this.jsp = "";
                cqM().requestFocus();
                if (cqM().getText() != null && cqM().getText().length() + str.length() > 31) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = cqM().getSelectionStart();
                    editable = cqM().getText();
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
        if (((ImageSpan[]) cqL().getText().getSpans(0, cqL().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.jsx == null) {
                this.jsx = Toast.makeText(getPageContext().getPageActivity(), d.j.too_many_face, 0);
            }
            this.jsx.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType agq = pVar.agq();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.jB().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.32
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass32) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.cqL().getSelectionStart(), aVar, agq);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cqL() != null && cqL().getText() != null) {
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
                int selectionStart = cqL().getSelectionStart() - 1;
                if (cqL().getText().length() > 1 && selectionStart >= 0 && cqL().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cqL().getText().insert(cqL().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cqL().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cqL().getText().insert(cqL().getSelectionStart(), spannableString2);
            }
            Editable text = cqL().getText();
            if (text != null) {
                this.jsN.clear();
                this.jsN.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jsN);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cqL().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cqL().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cqL().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cqL() {
        return this.jsK ? this.jtr : this.iwv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cqM() {
        return this.jsK ? this.jtv : this.iwr;
    }

    protected void cqN() {
        Editable text;
        if (cqL() != null && (text = cqL().getText()) != null) {
            int selectionStart = cqL().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cqL().onKeyDown(67, this.eHp);
            }
            cqL().onKeyDown(67, this.eHp);
            int selectionStart2 = cqL().getSelectionStart();
            if (text != null) {
                this.jsN.clear();
                this.jsN.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jsN);
                cqL().setSelection(selectionStart2);
            }
        }
    }

    private void l(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.j.feedback_bar_name).equals(str)) {
            this.jtd = true;
        }
    }

    private void crb() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void crc() {
        try {
            if (this.jtj != null) {
                this.jtj.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.csN.e(null);
        this.csN.hF(d.j.sending);
        this.csN.dJ(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.csN.dJ(false);
    }

    private Boolean crd() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.ckl = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void cbp() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (cqM() != null) {
                str = cqM().getText().toString();
            }
            if (cqL() != null) {
                str2 = cqL().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.ivZ == com.baidu.tbadk.core.util.v.S(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.jst.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            ri(true);
                            return;
                        }
                    } else if (this.jst.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        ri(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.jst.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    ri(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.jsK) {
                    ri(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    ri(true);
                }
            }
            if (this.mData.getType() == 4) {
                ri(s(this.jtr) && r(this.jtv));
            } else if (this.mData.getType() == 5) {
                ri(s(this.jtr));
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
        this.ckh = new NewWriteModel(this);
        this.ckh.b(this.ckv);
        registerListener(this.jtP);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.cbh();
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
            this.jtd = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.jte = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.jtk = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.jtl = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.ckf = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.jsy = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.jsy != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.jtm = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.mData.setTopicId(this.mTopicId);
            this.fxi = bundle.getString("KEY_CALL_FROM");
            this.jmD = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
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
            this.jtd = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.jte = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.jtk = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.jtl = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.jsy = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.jsy != null);
            this.mData.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.jtm = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.mData.setTopicId(this.mTopicId);
            this.fxi = intent.getStringExtra("KEY_CALL_FROM");
            this.jmD = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.jtd);
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
        this.gPk = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.jsr = true;
        }
        cqF();
        try {
            this.jtB = crk();
        } catch (Throwable th) {
            this.jtB = null;
        }
    }

    private void cqO() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.iwr.setText(com.baidu.tbadk.plugins.b.pw(com.baidu.tbadk.plugins.b.px(hotTopicBussinessData.mTopicName)));
            this.iwr.setMovementMethod(com.baidu.tieba.view.c.cmY());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString pw = com.baidu.tbadk.plugins.b.pw(com.baidu.tbadk.plugins.b.px(hotTopicBussinessData.mTopicName));
            if (pw != null) {
                this.iwr.setText(pw);
            }
            this.jsM.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t.a
    public void a(WriteData writeData) {
        String str;
        String px;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (com.baidu.adp.lib.util.k.isEmpty(cqM().getText().toString()) || this.jtJ || ((this.jtd || this.jsr) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
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
                            px = this.mData.getTitle();
                        } else {
                            px = com.baidu.tbadk.plugins.b.px(str);
                        }
                        SpannableString pw = com.baidu.tbadk.plugins.b.pw(px);
                        if (pw != null) {
                            cqM().setText(pw);
                            cqM().setSelection(pw.length() > px.length() ? px.length() : pw.length());
                        }
                    } else {
                        SpannableString pw2 = com.baidu.tbadk.plugins.b.pw(this.mData.getTitle());
                        if (pw2 != null) {
                            cqM().setText(pw2);
                            cqM().setSelection(this.mData.getTitle().length() > pw2.length() ? pw2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    cqE();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.ciD.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.k.isEmpty(cqL().getText().toString()) || this.jtd || this.jsr) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.anl().a(getPageContext().getPageActivity(), this.mData.getContent(), this.jsS);
                    cqL().setText(a2);
                    cqL().setSelection(a2.length());
                    if (this.jsK) {
                        a(this.jtx, this.jtr);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    crj();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        cqU();
                    }
                    rk(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    cre();
                }
                cbp();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.jsD != null) {
                    this.jsH = this.jsE.fcn;
                    this.jsG = this.jsE.name;
                    int i = 0;
                    while (true) {
                        if (i == this.jsD.size()) {
                            break;
                        }
                        v vVar = this.jsD.get(i);
                        if (categoryTo != vVar.fcn) {
                            i++;
                        } else {
                            this.jsH = categoryTo;
                            this.jsG = vVar.name;
                            this.mData.setCategoryTo(this.jsH);
                            break;
                        }
                    }
                    if (this.jsI != null) {
                        this.jsI.setText(this.jsG);
                        this.jsI.setCategoryContainerData(this.jsD, this.jsE, this.jsH);
                    }
                }
                this.ciD.akm();
                return;
            }
            return;
        }
        cre();
        cqE();
    }

    private void cre() {
        if ((!this.jsK || this.jtq != null) && this.jtp != null) {
            this.jtq.c(this.writeImagesInfo);
            crh();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.jtk);
        if (this.jtd) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.ckf);
        if (this.jsy != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.jsy));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.jtm);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.fxi);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.jmD);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cqL().getEditableText().toString();
        if (obj != null) {
            cqL().setText(TbFaceManager.anl().a(getPageContext().getPageActivity(), obj, this.jsS));
            cqL().setSelection(cqL().getText().length());
        }
    }

    private String cqP() {
        return (cqL() == null || cqL().getText() == null) ? "" : cqL().getText().toString();
    }

    private String cqQ() {
        if (this.mData == null || cqM() == null || cqM().getVisibility() != 0 || cqM().getText() == null) {
            return "";
        }
        String obj = cqM().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.S(this.mPrefixData.getPrefixs()) > 0 && this.ivZ != com.baidu.tbadk.core.util.v.S(this.mPrefixData.getPrefixs()) - 1 && this.mData.getType() != 4 && this.iww != null && this.iww.getText() != null) {
            this.mData.setPostPrefix(this.iww.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void EE(String str) {
        if (this.mData != null && this.jst != null) {
            if (this.jst.getVisibility() == 0) {
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
    public void cqR() {
        cbh();
        this.mData.setContent(cqP());
        EE(cqQ());
        if (this.jtd || this.jsr) {
            String string = getResources().getString(d.j.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                EE(string + this.mData.getTitle());
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
        if (this.jsF >= 0) {
            this.mData.setCategoryFrom(this.jsF);
        }
        if (this.jsH >= 0) {
            this.mData.setCategoryTo(this.jsH);
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
        this.mData.setHasLocationData(this.ckg != null && this.ckg.aNu());
        if (this.writeImagesInfo != null) {
            this.ckh.qd(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.v.T(this.mList) && this.jsL != null && this.jsL.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.jsL.mForumId));
            this.mData.setForumName(this.jsL.mForumName);
        }
        this.ckh.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.ckh.getWriteData().setVoice(this.mVoiceModel.getId());
                this.ckh.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.ckh.getWriteData().setVoice(null);
                this.ckh.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.ckh.getWriteData().setVoice(null);
            this.ckh.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.ckh.cfB()) {
            showToast(d.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.kY()) {
            showToast(d.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
            this.ckh.startPostWrite();
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
            if (this.jsy != null) {
                i2 = this.jsy.getTotalCount();
                i = this.jsy.getAlreadyCount() + 1;
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
                if (this.iwr == getCurrentFocus()) {
                    cqL().clearFocus();
                    this.iwr.requestFocus();
                    if (this.ciD != null) {
                        this.ciD.akm();
                    }
                    ShowSoftKeyPadDelay(this.iwr);
                } else {
                    cqL().requestFocus();
                    if (this.ciD != null) {
                        this.ciD.akm();
                    }
                    ShowSoftKeyPadDelay(this.iwv);
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
                            cqL().getText().insert(cqL().getSelectionStart(), sb.toString());
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
                                cri();
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
                        if (this.jtN) {
                            rj(true);
                            this.jtN = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.jsK) {
                        P(intent);
                        cbp();
                        return;
                    }
                    aA(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.ciD.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.ciD.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.ciD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    cbp();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.jsq) {
                                sb2.append(com.baidu.tbadk.plugins.b.csl);
                                this.jsq = false;
                            }
                            sb2.append(stringExtra);
                            oN(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.T(this.mList) && !com.baidu.tbadk.core.util.v.T(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.jsL = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.jsL);
                }
            }
        } else if (i2 == 0) {
            if (this.ciD != null && !this.ciD.alS()) {
                this.iwv.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.ciD.akm();
            }
            switch (i) {
                case 12001:
                    amy();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    crg();
                    if (this.jtN) {
                        rj(true);
                        this.jtN = false;
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (this.iwr == getCurrentFocus()) {
                        cqL().clearFocus();
                        this.iwr.requestFocus();
                        if (this.ciD != null) {
                            this.ciD.akm();
                        }
                        ShowSoftKeyPadDelay(this.iwr);
                        return;
                    }
                    cqL().requestFocus();
                    if (this.ciD != null) {
                        this.ciD.akm();
                    }
                    ShowSoftKeyPadDelay(this.iwv);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.jsQ.Ei(postWriteCallBackData.getErrorString());
                        this.jsQ.aE(postWriteCallBackData.getSensitiveWords());
                        this.jsQ.b(this.iwr, this.iwv);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                default:
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.ckf = String.valueOf(System.currentTimeMillis());
                    ak.a(getPageContext(), this.ckf);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    crg();
                    return;
                case 25004:
                    if ("from_title".equals(this.jsp)) {
                        cqM().requestFocus();
                        return;
                    } else if ("from_content".equals(this.jsp)) {
                        cqL().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqS() {
        if ("1".equals(this.fxi)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.fxi)) {
            this.mData.setCanNoForum(false);
        }
        cqT();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.fxi);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cqR();
    }

    private void cqT() {
        if (this.ciD != null) {
            this.ciD.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void crf() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void crg() {
        if (this.jsK) {
            this.jtq.c(this.writeImagesInfo);
            crh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crh() {
        this.jtq.notifyDataSetChanged();
        this.jtp.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.jtq.notifyDataSetChanged();
                WriteActivity.this.jtp.invalidateViews();
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
        cbp();
    }

    private void az(Intent intent) {
        if (this.jsK) {
            aA(intent);
            crg();
        } else {
            aD(intent);
        }
        cbp();
    }

    private void aA(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            crg();
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

    private void cri() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void aC(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.jtn.parseJson(stringExtra);
            this.jtn.updateQuality();
            if (this.jtn.getChosedFiles() != null && this.jtn.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.jtn.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.jtn.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cqM());
        HidenSoftKeyPad(this.mInputManager, cqL());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void aD(Intent intent) {
        c(intent, true);
    }

    private void O(Intent intent) {
        this.ckf = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.ckf;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.aO(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.aQ(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a(TbConfig.LOCAL_CAMERA_DIR, this.ckf, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            crj();
            cqU();
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
                crj();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    cqU();
                }
            }
            rk(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crj() {
        if (this.ciD.jv(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void amy() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.ckf));
                return null;
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rk(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.jto != null) {
            this.jto.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.eYE == null) {
            this.eYE = VoiceManager.instance();
        }
        return this.eYE;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bcK() {
        this.eYE = getVoiceManager();
        this.eYE.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.aD(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.eZQ) != null) {
                    TiebaStatic.log(new am("c12534").T("obj_locate", at.a.bLn));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.jsy == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                A(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.ckm = i;
        if (this.ciD != null) {
            this.ciD.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void cqU() {
        if (!this.jsK) {
            if (this.ciD != null) {
                this.ciD.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.ciD.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.jto != null) {
                this.jto.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eP(boolean z) {
        if (this.ciD != null) {
            this.ciD.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Bu(int i) {
        if (i < this.jsw.size()) {
            for (int i2 = 0; i2 < this.jsw.size(); i2++) {
                this.jsw.get(i2).qY(false);
            }
            this.jsw.get(i).qY(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void yV(int i) {
        if (i == com.baidu.tbadk.core.util.v.S(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new am("c13014").T("obj_type", 1));
        } else {
            TiebaStatic.log(new am("c13014").T("obj_type", 2));
        }
        this.ivZ = i;
        this.iwx.setCurrentIndex(i);
        Bu(i);
        this.iww.setText(this.mPrefixData.getPrefixs().get(i));
        cbp();
        com.baidu.adp.lib.g.g.a(this.iwx, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.iwz.setSelected(false);
        al.c(this.iwy, d.f.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.iwv);
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
            ams();
        } else if (i == 1) {
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (ab.cS(getApplicationContext())) {
                ak.a(getPageContext(), this.ckf);
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
        this.jsP = z;
        if (this.jtH && System.currentTimeMillis() - this.jtI < 800) {
            l.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.jtH = false;
        }
        if (this.jsO != null && !z) {
            this.jsO.aWN();
        }
        if (this.jsR != null && !z) {
            cqx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EF(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.jtE != null) {
            EG(str);
            this.jtE.dismiss();
        }
    }

    private void eE(Context context) {
        jtG = l.aQ(context);
    }

    private void EG(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.j.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.jtH = true;
        crj();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            cqU();
        }
        rk(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [4293=4] */
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

    private File crk() {
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

    private void crl() {
        if (this.jtB != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            eE(getActivity());
            this.jtD = getPageContext().getPageActivity().getLayoutInflater().inflate(d.h.rec_dialog, (ViewGroup) null);
            this.jtD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.jtB != null) {
                        WriteActivity.this.EF(WriteActivity.this.jtB.getAbsolutePath());
                    }
                }
            });
            this.jtC = (TbImageView) this.jtD.findViewById(d.g.rec_img_view);
            this.jtF = (LinearLayout) this.jtD.findViewById(d.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.jtB.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.jtB.getAbsolutePath());
                Bitmap f = f(this.jtB.getAbsolutePath(), getResources().getDimensionPixelSize(d.e.ds160));
                if (f != null) {
                    this.jtC.setImageBitmap(f);
                    this.jtC.setDrawBorder(true);
                    this.jtC.setBorderWidth(2);
                    this.jtC.setBorderColor(al.getColor(d.C0277d.common_color_10264));
                    this.jtE = new Dialog(getActivity(), d.k.bubble_dialog);
                    this.jtE.setCanceledOnTouchOutside(true);
                    this.jtE.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.jtH) {
                                l.b(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.jtI = System.currentTimeMillis();
                            }
                        }
                    });
                    this.jtE.setContentView(this.jtD);
                    this.jtE.show();
                    Window window = this.jtE.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.e.ds28);
                    attributes.y = (jtG / 18) + getResources().getDimensionPixelSize(d.e.ds12);
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
        if (this.jsP && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.jsq = false;
            this.jsp = "";
            if ("from_content".equals(str)) {
                this.jsp = "from_content";
            } else if ("from_title".equals(str)) {
                this.jsp = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.pv(String.valueOf(charSequence.charAt(i)))) {
                rh(false);
            }
        }
    }

    public void bXs() {
        if (this.jtd || !com.baidu.tbadk.core.util.v.T(this.mList) || !StringUtils.isNull(this.mData.getTitle())) {
            this.jst.setVisibility(0);
            this.jst.requestFocus();
            this.ciD.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.jst.setVisibility(8);
    }
}
