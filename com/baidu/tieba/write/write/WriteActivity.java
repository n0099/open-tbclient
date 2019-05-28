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
import com.baidu.tbadk.util.n;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.StatusBarUtil;
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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0041a, VoiceManager.c, t.a, h.a {
    private static int jMJ = 0;
    private EditorTools cqK;
    private String csn;
    private LocationModel cso;
    private NewWriteModel csp;
    private String fnb;
    private String fnc;
    private String fnd;
    private VoiceManager foP;
    private LinearLayout hIM;
    private PlayVoiceBntNew hIN;
    private ImageView hIP;
    private int iOO;
    private TextView iPl;
    private com.baidu.tieba.write.h iPm;
    private ImageView iPn;
    private View iPo;
    private boolean isPrivacy;
    private com.baidu.tieba.write.b.c jJC;
    private Toast jLA;
    private AdditionData jLB;
    private RelativeLayout jLC;
    private TextView jLD;
    private TextView jLE;
    private TextView jLF;
    List<v> jLG;
    v jLH;
    private int jLI;
    private String jLJ;
    private int jLK;
    private PostCategoryView jLL;
    private HotTopicBussinessData jLO;
    private TextView jLP;
    private com.baidu.tieba.write.editor.b jLR;
    private e jLU;
    private LinearLayout jLv;
    private LinearLayout jLw;
    private View jLy;
    private View jMN;
    private View jMO;
    private TextView jMP;
    private com.baidu.tieba.c.d jMR;
    private com.baidu.tieba.view.b jMb;
    private View jMk;
    private g jMr;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String jLs = "";
    private boolean jLt = false;
    private WriteData mData = null;
    private boolean jMg = false;
    private boolean jLu = false;
    private boolean jMh = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText iPg = null;
    private HeadImageView jMi = null;
    private View iPh = null;
    private LinearLayout iPj = null;
    private EditText iPk = null;
    private FeedBackModel jLx = null;
    private FeedBackTopListView jMj = null;
    private ArrayList<WritePrefixItemLayout> jLz = new ArrayList<>();
    private String hgE = null;
    private final KeyEvent eXz = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View cdX = null;
    private TextView jMl = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a jMm = null;
    private final Handler mHandler = new Handler();
    private boolean jMn = false;
    private String jMo = null;
    private RelativeLayout mParent = null;
    private String cst = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int csu = 0;
    private int jMp = 0;
    private WriteImagesInfo jMq = new WriteImagesInfo();
    private View mRootView = null;
    private GridView jMs = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a jMt = null;
    private ScrollView jLM = null;
    private EditText jMu = null;
    private View jMv = null;
    private View jMw = null;
    private View jMx = null;
    private EditText jMy = null;
    private TextView jMz = null;
    private TextView jMA = null;
    private TextWatcher jMB = null;
    private TextWatcher jMC = null;
    private boolean jLN = false;
    private boolean jMD = false;
    private com.baidu.tbadk.core.view.b cAW = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private File jME = null;
    private TbImageView jMF = null;
    private View jMG = null;
    private Dialog jMH = null;
    private LinearLayout jMI = null;
    private boolean jMK = false;
    private long jML = -1000;
    private boolean jMM = false;
    private String fOb = "2";
    private int jFG = 0;
    private String mTopicId = "";
    private SpannableStringBuilder jLQ = new SpannableStringBuilder();
    private boolean jMQ = false;
    private boolean jLS = false;
    private final b jLT = new b();
    private final HttpMessageListener jMS = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.hgE)) {
                    WriteActivity.this.hgE = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.rY(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.hgE)) {
                    WriteActivity.this.hgE = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.hgE);
                    WriteActivity.this.rY(true);
                }
            }
        }
    };
    private TbFaceManager.a jLV = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan qn(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.ns());
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
    private final AntiHelper.a fqe = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").P("obj_locate", at.a.bSZ));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").P("obj_locate", at.a.bSZ));
        }
    };
    private final NewWriteModel.d csD = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.bkh();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.jLT.aI(null);
                if (z) {
                    WriteActivity.this.fl(z);
                    if (WriteActivity.this.d(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
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
                        if (!com.baidu.tbadk.core.util.v.aa(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                            TiebaStatic.log(new am("c11731").bT(VideoPlayActivityConfig.OBJ_ID, WriteActivity.this.mTopicId));
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
                    WriteActivity.this.jLT.aI(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.jLT.FE(postWriteCallBackData.getErrorString());
                    WriteActivity.this.jLT.b(WriteActivity.this.iPg, WriteActivity.this.iPk);
                } else if ((xVar == null || writeData == null || xVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (xVar != null && writeData != null && xVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.alA());
                    if (com.baidu.tbadk.v.a.rd(xVar.alz())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, xVar.alz());
                        if (WriteActivity.this.jMh) {
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
    private final LocationModel.a csB = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void arJ() {
            WriteActivity.this.showToast(R.string.no_network_guide);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void onFail(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(R.string.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.cmZ())) {
                WriteActivity.this.b(2, true, aVar.cmZ());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener jbc = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.cso.qQ(false);
                    WriteActivity.this.cso.eo(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.cso.qQ(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener jLW = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener jLX = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cyA = WriteActivity.this.cyA();
            if (cyA >= 0 && cyA < WriteActivity.this.iPk.getText().length()) {
                WriteActivity.this.iPk.setSelection(cyA);
            }
        }
    };
    private boolean jLY = true;
    private final View.OnFocusChangeListener iPe = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.iPg || view == WriteActivity.this.cdX || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.jLY = true;
                    WriteActivity.this.cyB();
                    l.c(WriteActivity.this.getActivity(), WriteActivity.this.iPg);
                    if (WriteActivity.this.cqK != null) {
                        WriteActivity.this.cqK.app();
                    }
                } else if (view == WriteActivity.this.iPg) {
                    WriteActivity.this.iPl.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.iPk && z) {
                WriteActivity.this.jLY = false;
                WriteActivity.this.cyB();
                l.c(WriteActivity.this.getActivity(), WriteActivity.this.iPk);
                if (WriteActivity.this.cqK != null) {
                    WriteActivity.this.cqK.app();
                }
            }
            WriteActivity.this.cyH();
        }
    };
    private TextWatcher jLZ = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String jMd = "";
        private String jMe;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jMe = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jMe != null ? this.jMe.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cjw();
            WriteActivity.this.cyI();
            EditText cyT = WriteActivity.this.cyT();
            if (editable != null && cyT != null && cyT.getText() != null) {
                if (this.jMd == null || !this.jMd.equals(editable.toString())) {
                    if (WriteActivity.this.jLT != null) {
                        this.jMd = cyT.getText().toString();
                        WriteActivity.this.jLT.o(cyT);
                        return;
                    }
                    return;
                }
                cyT.setSelection(cyT.getSelectionEnd());
            }
        }
    };
    private TextWatcher jMa = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String jMe;
        private String jMf = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jMe = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jMe != null ? this.jMe.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cjw();
            EditText cyS = WriteActivity.this.cyS();
            if (editable != null && cyS != null && cyS.getText() != null) {
                if (this.jMf == null || !this.jMf.equals(editable.toString())) {
                    if (WriteActivity.this.jLT != null) {
                        this.jMf = cyS.getText().toString();
                        WriteActivity.this.jLT.o(cyS);
                        return;
                    }
                    return;
                }
                cyS.setSelection(cyS.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0407a hPA = new a.InterfaceC0407a() { // from class: com.baidu.tieba.write.write.WriteActivity.31
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0407a
        public void onRefresh() {
            WriteActivity.this.hgE = null;
            WriteActivity.this.rY(false);
            WriteActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void aru() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void arv() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            arx();
        } else if (this.cso.cnf()) {
            aru();
        } else {
            this.cso.qQ(false);
            b(1, true, null);
            this.cso.cnd();
        }
    }

    public void czc() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
            if (this.jLR != null) {
                this.jLR.cxE();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            arx();
        } else if (this.cso != null) {
            this.cso.qQ(false);
            b(1, true, null);
            this.cso.cnd();
        }
    }

    private void arx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ho(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.jS()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.cso.aTL();
                } else {
                    WriteActivity.this.csB.arJ();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.45
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.afG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cyA() {
        int selectionEnd = cyS().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cyS().getText().getSpans(0, cyS().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cyS().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cyS().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyB() {
        if (this.cqK != null) {
            this.cqK.setBarLauncherEnabled(!this.jLY);
            this.cqK.setBarLauncherEnabled(true, 26);
            this.cqK.setBarLauncherEnabled(true, 2);
            V(9, this.jLY ? false : true);
        }
    }

    private void V(int i, boolean z) {
        com.baidu.tbadk.editortools.g kg;
        if (this.cqK != null && (kg = this.cqK.kg(i)) != null) {
            if (z) {
                kg.pO();
            } else {
                kg.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.jLN) {
            this.iPg.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.jMx.setVisibility(8);
            } else {
                this.jMx.setVisibility(0);
            }
            a(this.jMA, this.jMu);
            a(this.jMz, this.jMy);
            cjw();
        }
        if (this.jMg) {
            this.jLY = true;
            cyB();
            if (this.cqK != null) {
                this.cqK.app();
            }
            this.iPg.requestFocus();
            ShowSoftKeyPadDelay(this.iPg);
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
            czr();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                czb();
            }
            rZ(true);
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
            CE(this.jFG);
        }
        initUI();
        czh();
        this.cso = new LocationModel(this);
        this.cso.a(this.csB);
        registerListener(this.jbc);
        registerListener(this.jLW);
        initEditor();
        czu();
        if (this.jLN) {
            this.jMt.setEditorTools(this.cqK);
        } else {
            this.iPk.requestFocus();
        }
        cfy();
        czb();
        czs();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.cqK = new EditorTools(getActivity());
        this.cqK.setBarMaxLauCount(5);
        this.cqK.setMoreButtonAtEnd(true);
        this.cqK.setBarLauncherType(1);
        this.cqK.fd(true);
        this.cqK.fe(true);
        this.cqK.setMoreLauncherIcon(R.drawable.write_more);
        this.cqK.setBackgroundColorId(R.color.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                czf();
                break;
            default:
                cyC();
                break;
        }
        this.cqK.aqT();
        if (this.jLv != null) {
            this.jLv.addView(this.cqK);
        }
        cyD();
        this.cqK.pO();
        com.baidu.tbadk.editortools.g kg = this.cqK.kg(6);
        if (kg != null && !TextUtils.isEmpty(this.cst)) {
            ((View) kg).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.cst);
                }
            });
        }
        if (!this.jLN) {
            this.cqK.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.cqK.app();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("xiaoying_has_click", false)) {
            this.cqK.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("hot_topic_has_click", false)) {
            this.cqK.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        cyF();
    }

    private void czd() {
        this.jMv = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.jMx = this.jMv.findViewById(R.id.live_post_title_container);
        this.jMu = (EditText) this.jMv.findViewById(R.id.live_post_content);
        this.jMs = (GridView) this.jMv.findViewById(R.id.photoLiveGridView);
        this.jMy = (EditText) this.jMv.findViewById(R.id.live_post_title);
        this.jMz = (TextView) this.jMv.findViewById(R.id.titleOverPlusNumber);
        this.jMA = (TextView) this.jMv.findViewById(R.id.contentOverPlusNumber);
        this.jMw = this.jMv.findViewById(R.id.live_interval_view);
        this.jMz.setText(String.valueOf(20));
        this.jMA.setText(String.valueOf(233));
        this.jMv.setVisibility(0);
        this.jMz.setVisibility(0);
        this.jMA.setVisibility(0);
        this.jMy.setHint(R.string.tips_title_limit_new);
        this.jMy.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.jMD = true;
                    WriteActivity.this.jLY = true;
                    WriteActivity.this.cyB();
                    if (WriteActivity.this.cqK != null) {
                        WriteActivity.this.cqK.app();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.jMu.setHint(R.string.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.jMu.setHint(R.string.live_write_input_content_update);
        }
        this.jMu.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.jMD = false;
                    WriteActivity.this.jLY = false;
                    WriteActivity.this.cyB();
                    if (WriteActivity.this.cqK != null) {
                        WriteActivity.this.cqK.app();
                    }
                }
            }
        });
        this.jMu.requestFocus();
        this.jMu.addTextChangedListener(Dp());
        this.jMy.requestFocus();
        this.jMy.addTextChangedListener(Dp());
        this.jMy.setOnClickListener(this.jLX);
        this.jMu.setOnClickListener(this.jLX);
        this.jMt = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.jMs);
        this.jMt.Cy(6);
        this.jMs.setAdapter((ListAdapter) this.jMt);
        View findViewById = this.jMv.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void cyl() {
                WriteActivity.this.czp();
            }
        });
        cze();
    }

    private void cze() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.jMy.setText(this.mData.getTitle());
                this.jMy.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.jLN) {
            czn();
        }
        if (this.cqK.aqV()) {
            this.cqK.app();
        }
        CE(0);
    }

    private void CE(int i) {
        if (this.writeImagesInfo != null && this.mData != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.fOb);
            albumActivityConfig.setProfessionZone(this.mData.getProZone());
            sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void czf() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.cqK.ai(arrayList);
        com.baidu.tbadk.editortools.k kj = this.cqK.kj(5);
        if (kj != null) {
            kj.crv = 2;
            kj.crt = R.drawable.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.crt = R.drawable.write_at;
        this.cqK.b(aVar);
        this.cqK.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void cyC() {
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        com.baidu.tbadk.editortools.k kVar3;
        com.baidu.tbadk.editortools.k kVar4;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.k kVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.crt = R.drawable.write_picture;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            this.cqK.b(dVar);
        }
        Boolean czl = czl();
        if (!this.jMg && czl != null && czl.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.cnG() && p.b(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), com.baidu.tbadk.editortools.k.class)) != null && (kVar5 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar5.crv = 3;
            kVar5.crt = R.drawable.write_recorder;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.cqK.b(kVar5);
            }
        }
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        aVar.crt = R.drawable.icon_post_topic_selector;
        this.cqK.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001343, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask2 != null && (kVar4 = (com.baidu.tbadk.editortools.k) runTask2.getData()) != null) {
            kVar4.crv = 5;
            kVar4.crt = R.drawable.write_privilege;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.cqK.b(kVar4);
            }
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask3 != null && (kVar3 = (com.baidu.tbadk.editortools.k) runTask3.getData()) != null) {
            kVar3.crv = 6;
            kVar3.crt = this.jMg ? R.drawable.write_location : R.drawable.icon_post_more_location;
            this.cqK.b(kVar3);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 7);
        aVar2.crt = R.drawable.icon_post_more_at;
        this.cqK.b(aVar2);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask4 != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
            kVar2.crx = true;
            kVar2.crv = 9;
            kVar2.crt = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.cqK.b(kVar2);
            }
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask5 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask5.getData()) != null) {
            kVar.crx = true;
            kVar.crv = 10;
            kVar.crt = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.cqK.b(kVar);
            }
        }
        if (this.jLB == null) {
            if (this.jLR == null) {
                this.jLR = new com.baidu.tieba.write.editor.b(getActivity(), this.fOb);
                this.jLR.bs(this.mData.getForumId(), this.privateThread);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.jLR.cxA();
                this.jLR.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                czc();
            }
            this.cqK.b(this.jLR);
        }
        this.cqK.ai(arrayList);
        com.baidu.tbadk.editortools.k kj = this.cqK.kj(5);
        if (kj != null) {
            kj.crv = 1;
            kj.crt = R.drawable.write_emotion;
        }
    }

    private void cyE() {
        if (this.jLU != null) {
            this.jLU.hideTip();
        }
    }

    private void cyF() {
        if (this.jLU == null) {
            this.jLU = new e(getPageContext());
        }
        this.jLU.c(this.cqK);
    }

    private void cyD() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.cyR()) {
                            WriteActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new am("c12612").P("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p)) {
                            com.baidu.tbadk.coreExtra.data.p pVar = (com.baidu.tbadk.coreExtra.data.p) aVar.data;
                            if (pVar.alp() == EmotionGroupType.BIG_EMOTION || pVar.alp() == EmotionGroupType.USER_COLLECT) {
                                if (WriteActivity.this.mCurrentPermissionJudgePolicy == null) {
                                    WriteActivity.this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                                }
                                WriteActivity.this.mCurrentPermissionJudgePolicy.aiM();
                                WriteActivity.this.mCurrentPermissionJudgePolicy.e(WriteActivity.this, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!WriteActivity.this.mCurrentPermissionJudgePolicy.aa(WriteActivity.this)) {
                                    if (WriteActivity.this.writeImagesInfo.size() >= WriteActivity.this.writeImagesInfo.getMaxImagesAllowed()) {
                                        WriteActivity.this.showToast(String.format(WriteActivity.this.getString(R.string.max_choose_image_count), Integer.valueOf(WriteActivity.this.writeImagesInfo.getMaxImagesAllowed())));
                                        return;
                                    }
                                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                                    imageFileInfo.setImageType(1);
                                    imageFileInfo.setFilePath(pVar.getName());
                                    imageFileInfo.width = pVar.getWidth();
                                    imageFileInfo.height = pVar.getHeight();
                                    WriteActivity.this.writeImagesInfo.addChooseFile(imageFileInfo);
                                    WriteActivity.this.writeImagesInfo.updateQuality();
                                    WriteActivity.this.rZ(true);
                                    WriteActivity.this.cjw();
                                }
                            } else if (WriteActivity.this.cyR()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(pVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.cyU();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bSC();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.czr();
                        WriteActivity.this.cjw();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.CF(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new am("c12612").P("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.jLB == null) {
                            WriteActivity.this.ary();
                            return;
                        }
                        switch (WriteActivity.this.csu) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.cw(pageActivity)) {
                                    WriteActivity.this.arv();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.aru();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.cso != null) {
                            WriteActivity.this.cso.qQ(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.hgE = null;
                        } else {
                            WriteActivity.this.hgE = (String) aVar.data;
                        }
                        WriteActivity.this.rY(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("xiaoying_has_click", true);
                        am amVar = new am("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        amVar.bT("fid", str);
                        TiebaStatic.log(amVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.cqK.aqV()) {
                                        WriteActivity.this.cqK.app();
                                        WriteActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(WriteActivity.this.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(R.string.plugin_video_not_active), WriteActivity.this.getResources().getString(R.string.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(R.string.plugin_video_install_tips), WriteActivity.this.getResources().getString(R.string.plugin_go_install));
                            return;
                        }
                        WriteActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.cjw();
                        if (WriteActivity.this.iPk != null) {
                            WriteActivity.this.iPk.requestFocus();
                        }
                        WriteActivity.this.cqK.app();
                        WriteActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iPk);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new am("c12612").P("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.jLt = true;
                        WriteActivity.this.rW(true);
                        if (!WriteActivity.this.cyT().isFocused() || WriteActivity.this.jLw.getVisibility() != 0) {
                            WriteActivity.this.jLs = "from_content";
                        } else {
                            WriteActivity.this.jLs = "from_title";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.jLw.setVisibility(0);
                        WriteActivity.this.jLw.requestFocus();
                        WriteActivity.this.cjw();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.jLw.hasFocus()) {
                            WriteActivity.this.iPk.requestFocus();
                            WriteActivity.this.iPk.setSelection(WriteActivity.this.iPk.getText().toString().length());
                        }
                        WriteActivity.this.jLw.setVisibility(8);
                        WriteActivity.this.cjw();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.cqK.setActionListener(16, bVar);
        this.cqK.setActionListener(14, bVar);
        this.cqK.setActionListener(24, bVar);
        this.cqK.setActionListener(3, bVar);
        this.cqK.setActionListener(10, bVar);
        this.cqK.setActionListener(11, bVar);
        this.cqK.setActionListener(12, bVar);
        this.cqK.setActionListener(13, bVar);
        this.cqK.setActionListener(15, bVar);
        this.cqK.setActionListener(18, bVar);
        this.cqK.setActionListener(20, bVar);
        this.cqK.setActionListener(25, bVar);
        this.cqK.setActionListener(27, bVar);
        this.cqK.setActionListener(29, bVar);
        this.cqK.setActionListener(43, bVar);
        this.cqK.setActionListener(45, bVar);
        this.cqK.setActionListener(53, bVar);
        this.cqK.setActionListener(48, bVar);
        this.cqK.setActionListener(46, bVar);
        this.cqK.setActionListener(49, bVar);
        this.cqK.setActionListener(47, bVar);
        this.cqK.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CF(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ary() {
        if (this.cso.aTH()) {
            if (this.cso.cnf()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.cnb().getLocationData().cmZ());
                return;
            }
            b(1, true, null);
            this.cso.cnd();
            return;
        }
        b(0, true, null);
    }

    protected void cjo() {
        if (this.csp != null) {
            this.csp.cancelLoadData();
        }
        if (this.jLx != null) {
            this.jLx.cancelLoadData();
        }
        if (this.cso != null) {
            this.cso.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cyE();
        TiebaPrepareImageService.StopService();
        cjo();
        czk();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.jMr != null) {
            this.jMr.destroy();
        }
        if (this.jMR != null) {
            this.jMR.aZA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyG() {
        if (this.mData != null && this.mData.getType() == 2 && this.jMn) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.mData.setTitle(cyT().getText().toString());
            this.mData.setContent(cyS().getText().toString());
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
            if (this.iPm != null && this.iPm.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.iPm, getPageContext().getPageActivity());
                return true;
            } else if (this.cqK.aqV()) {
                this.cqK.app();
                return true;
            } else {
                cjo();
                cyG();
                return true;
            }
        }
        if (i == 67 && (text = cyS().getText()) != null) {
            int selectionStart = cyS().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cyS().onKeyDown(67, this.eXz);
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
        getLayoutMode().onModeChanged(this.jMI);
        if (this.jMF != null && i == 1) {
            this.jMF.setBorderColor(al.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.f(this.mPost, R.color.cp_link_tip_a, 1);
        cyB();
        al.l(this.jMv, R.color.cp_bg_line_d);
        al.l(this.iPh, R.color.cp_bg_line_c);
        al.l(this.jMw, R.color.cp_bg_line_c);
        al.l(cyT(), R.color.cp_bg_line_d);
        al.c(this.hIP, (int) R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.hgE)) {
            al.l(cyS(), R.color.cp_bg_line_d);
        }
        cjw();
        this.cqK.onChangeSkinType(i);
        if (this.jLL != null) {
            this.jLL.ajG();
        }
        al.j(this.mName, R.color.cp_cont_b);
        cyH();
        cyI();
        if (this.jLT != null) {
            this.jLT.c(cyT(), cyS());
        }
        this.jJC.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyH() {
        if (this.iPg.hasFocus()) {
            this.iPg.setHintTextColor(al.getColor(R.color.cp_cont_e));
        } else {
            this.iPg.setHintTextColor(al.getColor(R.color.cp_cont_d));
        }
        if (this.iPk.hasFocus()) {
            this.iPk.setHintTextColor(al.getColor(R.color.cp_cont_e));
        } else {
            this.iPk.setHintTextColor(al.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyI() {
        if (this.iPg != null && this.iPg.getText() != null && this.iPg.getText().toString() != null && this.iPg.getPaint() != null) {
            if (this.iPg.getText().toString().length() == 0) {
                this.iPg.getPaint().setFakeBoldText(false);
            } else if (this.iPg.getText().toString().length() > 0) {
                this.iPg.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.cAW = new com.baidu.tbadk.core.view.b(getPageContext());
        this.jLN = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.cdX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_topbar_close, R.drawable.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        al.j(this.mName, R.color.cp_cont_b);
        this.jMl = (TextView) findViewById(R.id.btn_image_problem);
        cyK();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.g(getPageContext().getPageActivity(), R.dimen.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.iPe);
        this.jLM = (ScrollView) findViewById(R.id.write_scrollview);
        this.jLM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.iPk != null) {
                        l.b(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.iPk);
                    }
                    if (WriteActivity.this.cqK != null) {
                        WriteActivity.this.cqK.app();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jMj = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.jMk = findViewById(R.id.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(R.id.parent);
        this.jLv = (LinearLayout) findViewById(R.id.tool_view);
        this.jLv.setContentDescription("..");
        this.jLw = (LinearLayout) findViewById(R.id.title_view);
        this.iPh = findViewById(R.id.interval_view);
        this.jMN = findViewById(R.id.hot_topic_fourm_view);
        this.jMO = findViewById(R.id.hot_topic_divider);
        this.jLP = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.jMP = (TextView) findViewById(R.id.change_one_tv);
        cjv();
        if (this.jLN) {
            this.jLM.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            czd();
        } else {
            this.jMr = new g(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.jMr.rR(false);
            } else {
                g gVar = this.jMr;
                if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                    z = false;
                }
                gVar.rR(z);
            }
        }
        cjx();
        if (this.jMg || this.jLu) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().bTJ) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.iPj = (LinearLayout) findViewById(R.id.post_content_container);
        this.iPj.setDrawingCacheEnabled(false);
        this.iPj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.iPk.requestFocus();
            }
        });
        this.hIM = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.hIN = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.hIP = (ImageView) findViewById(R.id.iv_delete_voice);
        this.hIP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bSC();
            }
        });
        this.cdX.setOnFocusChangeListener(this.iPe);
        this.cdX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cjo();
                WriteActivity.this.cyG();
            }
        });
        this.jMl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        cyN();
        l(czl());
        cyP();
        cyJ();
        czi();
        czj();
        cyB();
        cyO();
        cju();
        cyV();
        if (this.mData.getType() == 4 && this.iPo != null && this.jLy != null) {
            this.iPo.setVisibility(8);
            this.jLy.setVisibility(8);
        }
        cjw();
        czg();
        cxS();
    }

    private void cxS() {
        this.jJC = new com.baidu.tieba.write.b.c(getPageContext().getPageActivity(), this.mName, this.mData.getProZone(), isUseStyleImmersiveSticky() ? StatusBarUtil.getStatusBarOffsetPx(getPageContext().getPageActivity()) : 0);
        this.jJC.a(new c.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // com.baidu.tieba.write.b.c.a
            public void Ct(int i) {
                WriteActivity.this.mData.setProZone(i);
            }
        });
        this.jJC.bdR();
    }

    private void cyJ() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.jMg || this.jLu) {
                        if (this.jMh) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.fOb != null && this.fOb.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                    } else if (this.fOb != null && this.fOb.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.mData.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.mData.getForumName() + getResources().getString(R.string.bar));
                        this.iPg.setVisibility(8);
                        String str3 = this.fnd + " " + this.fnb;
                        if (!StringUtils.isNull(str3)) {
                            this.iPk.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.iPg.setVisibility(0);
                    this.iPk.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.iPk.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.iPg.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.iPk.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.jMw.setVisibility(8);
                    return;
                case 7:
                    this.iPg.setVisibility(0);
                    this.iPk.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void cyK() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void cyL() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.jMg && !this.jLu && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String i = ap.i(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(i) && cyT() != null) {
                cyT().setText(i);
                cyT().setSelection(i.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.hIM.setVisibility(0);
            this.hIN.setVoiceModel(voiceModel);
            this.hIN.cnF();
            cjw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSC() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.aY(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.hIM.setVisibility(8);
        this.hIN.bvR();
        this.hIN.setVoiceModel(null);
        com.baidu.tbadk.editortools.k kj = this.cqK.kj(6);
        if (kj != null && kj.cqE != null) {
            kj.cqE.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cjw();
    }

    private void cyM() {
        this.jLG = null;
        this.jLI = -1;
        this.jLK = -1;
        com.baidu.tieba.frs.x rs = w.blC().rs(1);
        if (rs != null) {
            this.jLG = rs.fsG;
            this.jLI = getIntent().getIntExtra("category_id", -1);
            if (this.jLG != null && !this.jLG.isEmpty() && this.jLI >= 0) {
                this.jLH = new v();
                this.jLH.fsC = 0;
                this.jLH.name = getPageContext().getResources().getString(R.string.category_auto);
                this.jLK = this.jLH.fsC;
                this.jLJ = this.jLH.name;
                for (v vVar : this.jLG) {
                    if (vVar.fsC == this.jLI) {
                        this.jLK = vVar.fsC;
                        this.jLJ = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cyN() {
        if (this.jLG != null && !this.jLG.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.jLL = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.jLL.setText(this.jLJ);
            this.jLL.setCategoryContainerData(this.jLG, this.jLH, this.jLK);
            this.jLL.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ar arVar) {
                    if (arVar != null) {
                        WriteActivity.this.jLL.setText(arVar.name);
                        WriteActivity.this.mData.setCategoryTo(arVar.fsC);
                        WriteActivity.this.jLK = arVar.fsC;
                        WriteActivity.this.jLL.cyo();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.jLL.cyn();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cyT());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cyS());
                }
            });
        }
    }

    private void czg() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.jMb = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.jMb.setTitle(R.string.no_disturb_start_time);
        this.jMb.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.jMb);
        this.jMb.setButton(-2, getPageContext().getString(R.string.cancel), this.jMb);
        return this.jMb;
    }

    private void cyO() {
        this.jLC = (RelativeLayout) findViewById(R.id.addition_container);
        this.jLD = (TextView) findViewById(R.id.addition_create_time);
        this.jLE = (TextView) findViewById(R.id.addition_last_time);
        this.jLF = (TextView) findViewById(R.id.addition_last_content);
        if (this.jLB != null) {
            this.jLC.setVisibility(0);
            this.jLD.setText(getPageContext().getString(R.string.write_addition_create) + ap.aC(this.jLB.getCreateTime() * 1000));
            if (this.jLB.getAlreadyCount() == 0) {
                this.jLE.setVisibility(8);
            } else {
                this.jLE.setText(getPageContext().getString(R.string.write_addition_last) + ap.aC(this.jLB.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.jLB.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.jLF.setText(lastAdditionContent);
            } else {
                this.jLF.setVisibility(8);
            }
            cyS().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.jLB.getAlreadyCount()), Integer.valueOf(this.jLB.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.jLC.setVisibility(8);
    }

    private void cju() {
        this.iPo = findViewById(R.id.post_prefix_layout);
        if (this.jMR == null) {
            this.jMR = new com.baidu.tieba.c.d(getPageContext(), this.iPo);
            this.jMR.pK(R.drawable.bg_tip_blue_up_left);
            this.jMR.pJ(16);
            this.jMR.iI(true);
            this.jMR.S(true);
            this.jMR.pN(l.g(getActivity(), R.dimen.ds32));
        }
        this.iPl = (TextView) findViewById(R.id.post_prefix);
        this.jLy = findViewById(R.id.prefix_divider);
        this.iPn = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.iPo.setVisibility(0);
            this.jMR.u(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iOO = 0;
            this.iPo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c13013").bT("fid", WriteActivity.this.mData.getForumId()).l("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.iPl.setVisibility(0);
                    WriteActivity.this.iPo.setSelected(true);
                    al.c(WriteActivity.this.iPn, (int) R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.iPm, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.cqK.app();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iPg);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iPk);
                }
            });
            this.iPl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c13013").bT("fid", WriteActivity.this.mData.getForumId()).l("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.iPl.setSelected(true);
                    al.c(WriteActivity.this.iPn, (int) R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.iPm, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.cqK.app();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cyT());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cyS());
                }
            });
            this.iPm = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.iPm.a(this);
            this.iPm.setMaxHeight(l.g(getActivity(), R.dimen.ds510));
            this.iPm.setOutsideTouchable(true);
            this.iPm.setFocusable(true);
            this.iPm.setOnDismissListener(this);
            this.iPm.setBackgroundDrawable(al.getDrawable(R.color.cp_bg_line_d));
            int color = al.getColor(R.color.cp_cont_b);
            al.getColor(R.color.cp_cont_c);
            al.k(this.iPl, R.color.cp_bg_line_d);
            al.c(this.iPn, (int) R.drawable.icon_arrow_gray_down);
            this.iPl.setTextColor(color);
            this.jLz.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.jLz.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.rM(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.rM(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.iPm.addView(writePrefixItemLayout);
            }
            this.iPm.setCurrentIndex(0);
            this.iPl.setText(prefixs.get(0));
            CD(0);
            return;
        }
        this.iPo.setVisibility(8);
    }

    private void czh() {
        if (this.jMg && this.mData != null) {
            this.jMj.setVisibility(0);
            this.jMk.setVisibility(0);
            this.jLx = new FeedBackModel(getPageContext());
            this.jLx.FZ(this.mData.getForumName());
            this.jLx.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.24
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.jMj.setVisibility(8);
                        WriteActivity.this.jMk.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.jMj.setVisibility(8);
                        WriteActivity.this.jMk.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.jMj.a(feedBackModel.cyq(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void cyP() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.jS()) {
                    WriteActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (WriteActivity.this.jLT.a(WriteActivity.this.iPg, WriteActivity.this.iPk)) {
                        WriteActivity.this.showToast(WriteActivity.this.jLT.cwi());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cyT());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cyS());
                    WriteActivity.this.cqK.app();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.jMg) {
                            WriteActivity.this.cyY();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            am amVar = new am("c12102");
                            amVar.P("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(amVar);
                            WriteActivity.this.cyZ();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.cyY();
                    }
                    TiebaStatic.log(new am("c12262").bT("obj_locate", WriteActivity.this.fOb));
                }
            }
        });
    }

    protected void czi() {
        this.jMm = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.jMm.mE(getPageContext().getString(R.string.is_save_draft)).dM(false).a(getPageContext().getString(R.string.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.cyT().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.cyS().getText().toString());
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    t.c(WriteActivity.this.mData.getForumId(), WriteActivity.this.mData);
                } else if (type == 1) {
                    t.d(WriteActivity.this.mData.getThreadId(), WriteActivity.this.mData);
                }
                WriteActivity.this.showToast(R.string.draft_save_success);
                WriteActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.27.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WriteActivity.this.finish();
                    }
                }, 1000L);
            }
        }).b(getPageContext().getString(R.string.not_save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
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
        this.jMm.b(getPageContext());
    }

    protected void cjv() {
        this.jMi = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.jMi.setIsRound(true);
        this.jMi.setDrawBorder(false);
        this.jMi.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String nB = o.nB(currentPortrait);
            this.jMi.setUrl(nB);
            this.jMi.startLoad(nB, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.jMi.setVisibility(0);
        }
        this.iPg = (EditText) findViewById(R.id.post_title);
        this.iPg.setOnClickListener(this.jLX);
        this.iPg.setOnFocusChangeListener(this.iPe);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.iPg.setText(this.mData.getTitle());
                this.iPg.setSelection(this.mData.getTitle().length());
            } else if (this.jMh) {
                this.iPg.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.iPg.addTextChangedListener(this.jLZ);
        if (!this.mData.getHaveDraft()) {
            cyL();
            this.jMM = true;
        }
        if (this.mData.isUserFeedback()) {
            this.iPg.setHint(getResources().getString(R.string.feedback_title_hint));
        } else {
            this.iPg.setHint(getResources().getString(R.string.post_title_hint));
        }
    }

    private TextWatcher Dp() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            private int jMV;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.cjw();
                if (WriteActivity.this.jLN) {
                    this.jMV = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.jMV);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.jLN || !WriteActivity.this.jMD) {
                    if (WriteActivity.this.jLN) {
                        if (this.mEditText != WriteActivity.this.jMu || this.mTextView != WriteActivity.this.jMA) {
                            this.mEditText = WriteActivity.this.jMu;
                            this.mTextView = WriteActivity.this.jMA;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.jMy || this.mTextView != WriteActivity.this.jMz) {
                    this.mEditText = WriteActivity.this.jMy;
                    this.mTextView = WriteActivity.this.jMz;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.jLN && this.jMD) {
            if (this.jMB != null) {
                this.jMy.removeTextChangedListener(this.jMB);
            }
            this.jMB = textWatcher;
        } else if (this.jLN) {
            if (this.jMC != null) {
                this.jMu.removeTextChangedListener(this.jMC);
            }
            this.jMC = textWatcher;
        }
        return textWatcher;
    }

    private long p(EditText editText) {
        if (editText == this.jMu) {
            return 233L;
        }
        if (editText != this.jMy) {
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
                    textView.setTextColor(al.getColor(R.color.common_color_10159));
                } else {
                    textView.setTextColor(al.getColor(R.color.cp_cont_d));
                }
            } else if (q < 0) {
                if (q < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(al.getColor(R.color.common_color_10159));
            } else {
                textView.setTextColor(al.getColor(R.color.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long q(EditText editText) {
        return com.baidu.tieba.write.c.a.l(editText.getText().toString().trim());
    }

    protected void cjx() {
        this.iPk = (EditText) findViewById(R.id.post_content);
        this.iPk.setDrawingCacheEnabled(false);
        this.iPk.setOnClickListener(this.jLX);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString al = TbFaceManager.aso().al(getPageContext().getPageActivity(), this.mData.getContent());
            this.iPk.setText(al);
            this.iPk.setSelection(al.length());
        } else if (this.mData.getType() == 2) {
            if (this.jMn) {
                if (this.jMo != null && this.jMo.length() > 0) {
                    this.iPk.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.jMo}));
                    this.iPk.setSelection(this.iPk.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.iPk.setText(format);
                this.iPk.setSelection(format.length());
            }
        }
        this.iPk.setOnFocusChangeListener(this.iPe);
        this.iPk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.cqK.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.iPk.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iPk.addTextChangedListener(this.jMa);
        if (this.mData.getType() == 0) {
            this.jMQ = true;
        } else {
            rY(true);
            this.jMQ = false;
        }
        if (this.mData.isUserFeedback()) {
            this.iPk.setHint(R.string.write_input_content);
        } else {
            this.iPk.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void rY(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.jLN) {
            cyS().setPadding(0, 0, 0, 0);
            cyS().setBackgroundDrawable(null);
            al.l(cyS(), R.color.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.hgE) && this.jLB == null) {
                com.baidu.adp.lib.f.c.iv().a(this.hgE, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.30
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass30) aVar, str, i);
                        if (aVar != null && aVar.ns() != null && aVar.nw() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.ns(), aVar.ns().getNinePatchChunk(), aVar.nw(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.cyS().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.cyS(), true, WriteActivity.this.hPA);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyR() {
        int i = UIMsg.m_AppUI.MSG_APP_GPS;
        if (this.jLB != null) {
            i = 1000;
        }
        return cyS().getText() != null && cyS().getText().length() >= i;
    }

    private void pV(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.jLs)) {
                this.jLs = "";
                cyS().requestFocus();
                if (cyS().getText() != null && cyS().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cyS().getSelectionStart();
                    editable = cyS().getText();
                }
            } else if ("from_title".equals(this.jLs)) {
                this.jLs = "";
                cyT().requestFocus();
                if (cyT().getText() != null && cyT().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cyT().getSelectionStart();
                    editable = cyT().getText();
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
    public void rW(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void e(com.baidu.tbadk.coreExtra.data.p pVar) {
        if (((ImageSpan[]) cyS().getText().getSpans(0, cyS().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.jLA == null) {
                this.jLA = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            this.jLA.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType alp = pVar.alp();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.iv().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.32
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass32) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.cyS().getSelectionStart(), aVar, alp);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cyS() != null && cyS().getText() != null) {
            Bitmap ns = aVar.ns();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(ns);
            int width = ns.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, ns.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.g(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = cyS().getSelectionStart() - 1;
                if (cyS().getText().length() > 1 && selectionStart >= 0 && cyS().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cyS().getText().insert(cyS().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cyS().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cyS().getText().insert(cyS().getSelectionStart(), spannableString2);
            }
            Editable text = cyS().getText();
            if (text != null) {
                this.jLQ.clear();
                this.jLQ.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jLQ);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cyS().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cyS().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cyS().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cyS() {
        return this.jLN ? this.jMu : this.iPk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cyT() {
        return this.jLN ? this.jMy : this.iPg;
    }

    protected void cyU() {
        Editable text;
        if (cyS() != null && (text = cyS().getText()) != null) {
            int selectionStart = cyS().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cyS().onKeyDown(67, this.eXz);
            }
            cyS().onKeyDown(67, this.eXz);
            int selectionStart2 = cyS().getSelectionStart();
            if (text != null) {
                this.jLQ.clear();
                this.jLQ.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jLQ);
                cyS().setSelection(selectionStart2);
            }
        }
    }

    private void l(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.jMg = true;
        }
    }

    private void czj() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void czk() {
        try {
            if (this.jMm != null) {
                this.jMm.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.cAW.e(null);
        this.cAW.it(R.string.sending);
        this.cAW.ef(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.cAW.ef(false);
    }

    private Boolean czl() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.cst = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void cjw() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (cyT() != null) {
                str = cyT().getText().toString();
            }
            if (cyS() != null) {
                str2 = cyS().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.iOO == com.baidu.tbadk.core.util.v.Z(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.jLw.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            rX(true);
                            return;
                        }
                    } else if (this.jLw.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        rX(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.jLw.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    rX(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.jLN) {
                    rX(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    rX(true);
                }
            }
            if (this.mData.getType() == 4) {
                rX(s(this.jMu) && r(this.jMy));
            } else if (this.mData.getType() == 5) {
                rX(s(this.jMu));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                rX(true);
            } else if (this.mData.getVideoInfo() != null) {
                rX(true);
            } else {
                rX(false);
            }
        }
    }

    public void rX(boolean z) {
        if (z) {
            al.e(this.mPost, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        al.f(this.mPost, R.color.cp_cont_d, 1);
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
        this.csp = new NewWriteModel(this);
        this.csp.b(this.csD);
        registerListener(this.jMS);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.cjo();
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
            this.jMg = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.jMh = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.jMn = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.jMo = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.csn = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.jLB = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.jLB != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.jMp = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.mData.setTopicId(this.mTopicId);
            this.fOb = bundle.getString("KEY_CALL_FROM");
            this.jFG = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
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
            this.jMg = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.jMh = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.jMn = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.jMo = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.jLB = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.jLB != null);
            this.mData.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.jMp = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.fnc = intent.getStringExtra("more_forum_img");
            this.fnd = intent.getStringExtra("more_forum_title");
            this.fnb = intent.getStringExtra("more_forum_url");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.mData.setTopicId(this.mTopicId);
            this.fOb = intent.getStringExtra("KEY_CALL_FROM");
            this.jFG = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.jMg);
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
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.hgE = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.jLu = true;
        }
        cyM();
        try {
            this.jME = czt();
        } catch (Throwable th) {
            this.jME = null;
        }
    }

    private void cyV() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.iPg.setText(com.baidu.tbadk.plugins.b.qF(com.baidu.tbadk.plugins.b.qG(hotTopicBussinessData.mTopicName)));
            this.iPg.setMovementMethod(com.baidu.tieba.view.c.cvd());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString qF = com.baidu.tbadk.plugins.b.qF(com.baidu.tbadk.plugins.b.qG(hotTopicBussinessData.mTopicName));
            if (qF != null) {
                this.iPg.setText(qF);
            }
            this.jLP.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t.a
    public void a(WriteData writeData) {
        String str;
        String qG;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            if (writeData != null) {
                if (this.mData != null) {
                    this.mData.setHaveDraft(true);
                    if (com.baidu.adp.lib.util.k.isEmpty(cyT().getText().toString()) || this.jMM || ((this.jMg || this.jLu) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                        if (com.baidu.adp.lib.util.k.isEmpty(this.mData.getTitle())) {
                            this.mData.setTitle(writeData.getTitle());
                        }
                        if (!com.baidu.tbadk.core.util.v.aa(this.mList)) {
                            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0);
                            if (hotTopicBussinessData == null) {
                                str = null;
                            } else {
                                str = hotTopicBussinessData.mTopicName;
                            }
                            if (StringUtils.isNull(str)) {
                                qG = this.mData.getTitle();
                            } else {
                                qG = com.baidu.tbadk.plugins.b.qG(str);
                            }
                            SpannableString qF = com.baidu.tbadk.plugins.b.qF(qG);
                            if (qF != null) {
                                cyT().setText(qF);
                                cyT().setSelection(qF.length() > qG.length() ? qG.length() : qF.length());
                            }
                        } else {
                            SpannableString qF2 = com.baidu.tbadk.plugins.b.qF(this.mData.getTitle());
                            if (qF2 != null) {
                                cyT().setText(qF2);
                                cyT().setSelection(this.mData.getTitle().length() > qF2.length() ? qF2.length() : this.mData.getTitle().length());
                            }
                        }
                    }
                    if (this.mData != null && !this.mData.getHaveDraft()) {
                        cyL();
                    }
                    if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.copy(writeData.getVideoInfo());
                        this.mData.setVideoInfo(videoInfo);
                        this.cqK.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                    }
                    if ((com.baidu.adp.lib.util.k.isEmpty(cyS().getText().toString()) || this.jMg || this.jLu) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                        this.mData.setContent(writeData.getContent());
                        SpannableString a2 = TbFaceManager.aso().a(getPageContext().getPageActivity(), this.mData.getContent(), this.jLV);
                        cyS().setText(a2);
                        cyS().setSelection(a2.length());
                        if (this.jLN) {
                            a(this.jMA, this.jMu);
                        }
                    }
                    if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                        this.writeImagesInfo = writeData.getWriteImagesInfo();
                        this.mData.setWriteImagesInfo(this.writeImagesInfo);
                        czr();
                        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                            czb();
                        }
                        rZ(false);
                    }
                    if (writeData.getType() == 4 || writeData.getType() == 5) {
                        czm();
                    }
                    cjw();
                    int categoryTo = writeData.getCategoryTo();
                    if (categoryTo >= 0 && this.jLG != null) {
                        this.jLK = this.jLH.fsC;
                        this.jLJ = this.jLH.name;
                        int i = 0;
                        while (true) {
                            if (i == this.jLG.size()) {
                                break;
                            }
                            v vVar = this.jLG.get(i);
                            if (categoryTo != vVar.fsC) {
                                i++;
                            } else {
                                this.jLK = categoryTo;
                                this.jLJ = vVar.name;
                                this.mData.setCategoryTo(this.jLK);
                                break;
                            }
                        }
                        if (this.jLL != null) {
                            this.jLL.setText(this.jLJ);
                            this.jLL.setCategoryContainerData(this.jLG, this.jLH, this.jLK);
                        }
                    }
                    this.cqK.app();
                    return;
                }
                return;
            }
            czm();
            cyL();
        }
    }

    private void czm() {
        if ((!this.jLN || this.jMt != null) && this.jMs != null) {
            this.jMt.c(this.writeImagesInfo);
            czp();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.jMn);
        if (this.jMg) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.csn);
        if (this.jLB != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.jLB));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.jMp);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.fOb);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.jFG);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cyS().getEditableText().toString();
        if (obj != null) {
            cyS().setText(TbFaceManager.aso().a(getPageContext().getPageActivity(), obj, this.jLV));
            cyS().setSelection(cyS().getText().length());
        }
    }

    private String cyW() {
        return (cyS() == null || cyS().getText() == null) ? "" : cyS().getText().toString();
    }

    private String cyX() {
        if (this.mData == null || cyT() == null || cyT().getVisibility() != 0 || cyT().getText() == null) {
            return "";
        }
        String obj = cyT().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.Z(this.mPrefixData.getPrefixs()) > 0 && this.iOO != com.baidu.tbadk.core.util.v.Z(this.mPrefixData.getPrefixs()) - 1 && this.mData.getType() != 4 && this.iPl != null && this.iPl.getText() != null) {
            this.mData.setPostPrefix(this.iPl.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void Ga(String str) {
        if (this.mData != null && this.jLw != null) {
            if (this.jLw.getVisibility() == 0) {
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
    public void cyY() {
        cjo();
        this.mData.setContent(cyW());
        Ga(cyX());
        if (this.jMg || this.jLu) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                Ga(string + this.mData.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.mData.getContent()) || !this.mData.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.j.jS()) {
                    sb.append(com.baidu.adp.lib.util.j.jZ());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.jLI >= 0) {
            this.mData.setCategoryFrom(this.jLI);
        }
        if (this.jLK >= 0) {
            this.mData.setCategoryTo(this.jLK);
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
        this.mData.setHasLocationData(this.cso != null && this.cso.aTH());
        if (this.writeImagesInfo != null) {
            this.csp.qS(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.mList) && this.jLO != null && this.jLO.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.jLO.mForumId));
            this.mData.setForumName(this.jLO.mForumName);
        }
        this.csp.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.csp.getWriteData().setVoice(this.mVoiceModel.getId());
                this.csp.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.csp.getWriteData().setVoice(null);
                this.csp.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.csp.getWriteData().setVoice(null);
            this.csp.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.csp.cnH()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.jS()) {
            showToast(R.string.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.mDialogCancelListener);
            this.csp.startPostWrite();
        }
    }

    private void z(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.jLB != null) {
                i2 = this.jLB.getTotalCount();
                i = this.jLB.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(R.string.write_addition_left_count), Integer.valueOf(i2 - i)));
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
                if (this.iPg == getCurrentFocus()) {
                    cyS().clearFocus();
                    this.iPg.requestFocus();
                    if (this.cqK != null) {
                        this.cqK.app();
                    }
                    ShowSoftKeyPadDelay(this.iPg);
                } else {
                    cyS().requestFocus();
                    if (this.cqK != null) {
                        this.cqK.app();
                    }
                    ShowSoftKeyPadDelay(this.iPk);
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
                            cyS().getText().insert(cyS().getSelectionStart(), sb.toString());
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
                                czq();
                            } else {
                                aE(intent);
                            }
                        } else if (intExtra == 1) {
                            aF(intent);
                        } else {
                            aC(intent);
                            com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.jMQ) {
                            rY(true);
                            this.jMQ = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.jLN) {
                        P(intent);
                        cjw();
                        return;
                    }
                    aD(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.cqK.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.cqK.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.cqK.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    cjw();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.jLt) {
                                sb2.append(com.baidu.tbadk.plugins.b.cAq);
                                this.jLt = false;
                            }
                            sb2.append(stringExtra);
                            pV(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.aa(this.mList) && !com.baidu.tbadk.core.util.v.aa(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.jLO = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.jLO);
                }
            }
        } else if (i2 == 0) {
            if (this.cqK != null && !this.cqK.aqV()) {
                this.iPk.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.cqK.app();
            }
            switch (i) {
                case 12001:
                    arB();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    czo();
                    if (this.jMQ) {
                        rY(true);
                        this.jMQ = false;
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (this.iPg == getCurrentFocus()) {
                        cyS().clearFocus();
                        this.iPg.requestFocus();
                        if (this.cqK != null) {
                            this.cqK.app();
                        }
                        ShowSoftKeyPadDelay(this.iPg);
                        return;
                    }
                    cyS().requestFocus();
                    if (this.cqK != null) {
                        this.cqK.app();
                    }
                    ShowSoftKeyPadDelay(this.iPk);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.jLT.FE(postWriteCallBackData.getErrorString());
                        this.jLT.aI(postWriteCallBackData.getSensitiveWords());
                        this.jLT.b(this.iPg, this.iPk);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                default:
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.csn = String.valueOf(System.currentTimeMillis());
                    ak.a(getPageContext(), this.csn);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    czo();
                    return;
                case 25004:
                    if ("from_title".equals(this.jLs)) {
                        cyT().requestFocus();
                        return;
                    } else if ("from_content".equals(this.jLs)) {
                        cyS().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyZ() {
        if ("1".equals(this.fOb)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.fOb)) {
            this.mData.setCanNoForum(false);
        }
        cza();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.fOb);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cyY();
    }

    private void cza() {
        if (this.cqK != null) {
            this.cqK.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void czn() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void czo() {
        if (this.jLN) {
            this.jMt.c(this.writeImagesInfo);
            czp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czp() {
        this.jMt.notifyDataSetChanged();
        this.jMs.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.jMt.notifyDataSetChanged();
                WriteActivity.this.jMs.invalidateViews();
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
        cjw();
    }

    private void aC(Intent intent) {
        if (this.jLN) {
            aD(intent);
            czo();
        } else {
            aG(intent);
        }
        cjw();
    }

    private void aD(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            czo();
            rZ(true);
        }
    }

    private void aE(Intent intent) {
        if (this.writeImagesInfo != null) {
            O(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, size)));
            }
        }
    }

    private void czq() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void aF(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.jMq.parseJson(stringExtra);
            this.jMq.updateQuality();
            if (this.jMq.getChosedFiles() != null && this.jMq.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.jMq.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.jMq.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cyT());
        HidenSoftKeyPad(this.mInputManager, cyS());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void aG(Intent intent) {
        c(intent, true);
    }

    private void O(Intent intent) {
        this.csn = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.csn;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.af(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.ah(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a(TbConfig.LOCAL_CAMERA_DIR, this.csn, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            czr();
            czb();
        }
        rZ(true);
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
                czr();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    czb();
                }
            }
            rZ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czr() {
        if (this.cqK.kj(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void arB() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.csn));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void czs() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.fnc)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mCurrentPermissionJudgePolicy.aiM();
            this.mCurrentPermissionJudgePolicy.e(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.aa(this)) {
                n nVar = new n(this, this.fnc, new n.a() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                    @Override // com.baidu.tbadk.util.n.a
                    public void onError(int i, String str) {
                    }

                    @Override // com.baidu.tbadk.util.n.a
                    public void onSuccess(String str) {
                        if (new File(str).exists() && WriteActivity.this.writeImagesInfo != null) {
                            WriteActivity.this.writeImagesInfo.clear();
                            ImageFileInfo imageFileInfo = new ImageFileInfo();
                            imageFileInfo.setFilePath(str);
                            imageFileInfo.isFromMoreForum = true;
                            WriteActivity.this.writeImagesInfo.addChooseFile(imageFileInfo);
                            WriteActivity.this.writeImagesInfo.setMaxImagesAllowed(1);
                            WriteActivity.this.rZ(true);
                        }
                    }
                });
                nVar.setFrom(1);
                nVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rZ(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.jMr != null) {
            this.jMr.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.foP == null) {
            this.foP = VoiceManager.instance();
        }
        return this.foP;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bkh() {
        this.foP = getVoiceManager();
        this.foP.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.fqe) != null) {
                    TiebaStatic.log(new am("c12534").P("obj_locate", at.a.bSZ));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.jLB == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                z(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.csu = i;
        if (this.cqK != null) {
            this.cqK.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void czb() {
        if (!this.jLN) {
            if (this.cqK != null) {
                this.cqK.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.cqK.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.jMr != null) {
                this.jMr.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fl(boolean z) {
        if (this.cqK != null) {
            this.cqK.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void CD(int i) {
        if (i < this.jLz.size()) {
            for (int i2 = 0; i2 < this.jLz.size(); i2++) {
                this.jLz.get(i2).rN(false);
            }
            this.jLz.get(i).rN(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void Ad(int i) {
        if (i == com.baidu.tbadk.core.util.v.Z(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new am("c13014").P("obj_type", 1));
        } else {
            TiebaStatic.log(new am("c13014").P("obj_type", 2));
        }
        this.iOO = i;
        this.iPm.setCurrentIndex(i);
        CD(i);
        this.iPl.setText(this.mPrefixData.getPrefixs().get(i));
        cjw();
        com.baidu.adp.lib.g.g.a(this.iPm, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.iPo.setSelected(false);
        al.c(this.iPn, (int) R.drawable.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.iPk);
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
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
            arv();
        } else if (i == 1) {
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (ab.cx(getApplicationContext())) {
                ak.a(getPageContext(), this.csn);
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.jLS = z;
        if (this.jMK && System.currentTimeMillis() - this.jML < 800) {
            l.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.jMK = false;
        }
        if (this.jLR != null && !z) {
            this.jLR.bed();
        }
        if (this.jLU != null && !z) {
            cyE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gb(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.jMH != null) {
            Gc(str);
            this.jMH.dismiss();
        }
    }

    private void eu(Context context) {
        jMJ = l.ah(context);
    }

    private void Gc(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.jMK = true;
        czr();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            czb();
        }
        rZ(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [4417=4] */
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

    private File czt() {
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

    private void czu() {
        if (this.jME != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            eu(getActivity());
            this.jMG = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.jMG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.jME != null) {
                        WriteActivity.this.Gb(WriteActivity.this.jME.getAbsolutePath());
                    }
                }
            });
            this.jMF = (TbImageView) this.jMG.findViewById(R.id.rec_img_view);
            this.jMI = (LinearLayout) this.jMG.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.agM().getString("write_rec_pic_path", "").equalsIgnoreCase(this.jME.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.agM().putString("write_rec_pic_path", this.jME.getAbsolutePath());
                Bitmap f = f(this.jME.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (f != null) {
                    this.jMF.setImageBitmap(f);
                    this.jMF.setDrawBorder(true);
                    this.jMF.setBorderWidth(2);
                    this.jMF.setBorderColor(al.getColor(R.color.common_color_10264));
                    this.jMH = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.jMH.setCanceledOnTouchOutside(true);
                    this.jMH.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.jMK) {
                                l.b(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.jML = System.currentTimeMillis();
                            }
                        }
                    });
                    this.jMH.setContentView(this.jMG);
                    this.jMH.show();
                    Window window = this.jMH.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (jMJ / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
                    attributes.width = getResources().getDimensionPixelSize(R.dimen.ds168);
                    attributes.height = getResources().getDimensionPixelSize(R.dimen.ds278);
                    window.setAttributes(attributes);
                }
            }
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.jLS && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.jLt = false;
            this.jLs = "";
            if ("from_content".equals(str)) {
                this.jLs = "from_content";
            } else if ("from_title".equals(str)) {
                this.jLs = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.qE(String.valueOf(charSequence.charAt(i)))) {
                rW(false);
            }
        }
    }

    public void cfy() {
        if (this.jMg || !com.baidu.tbadk.core.util.v.aa(this.mList) || !StringUtils.isNull(this.mData.getTitle())) {
            this.jLw.setVisibility(0);
            this.jLw.requestFocus();
            this.cqK.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.jLw.setVisibility(8);
    }
}
