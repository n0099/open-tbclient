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
    private static int jMM = 0;
    private EditorTools cqL;
    private String cso;
    private LocationModel csp;
    private NewWriteModel csq;
    private String fnb;
    private String fnc;
    private String fnd;
    private VoiceManager foP;
    private LinearLayout hIN;
    private PlayVoiceBntNew hIO;
    private ImageView hIQ;
    private int iOS;
    private TextView iPp;
    private com.baidu.tieba.write.h iPq;
    private ImageView iPr;
    private View iPs;
    private boolean isPrivacy;
    private com.baidu.tieba.write.b.c jJF;
    private View jLB;
    private Toast jLD;
    private AdditionData jLE;
    private RelativeLayout jLF;
    private TextView jLG;
    private TextView jLH;
    private TextView jLI;
    List<v> jLJ;
    v jLK;
    private int jLL;
    private String jLM;
    private int jLN;
    private PostCategoryView jLO;
    private HotTopicBussinessData jLR;
    private TextView jLS;
    private com.baidu.tieba.write.editor.b jLU;
    private e jLX;
    private LinearLayout jLy;
    private LinearLayout jLz;
    private View jMQ;
    private View jMR;
    private TextView jMS;
    private com.baidu.tieba.c.d jMU;
    private com.baidu.tieba.view.b jMe;
    private View jMn;
    private g jMu;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String jLv = "";
    private boolean jLw = false;
    private WriteData mData = null;
    private boolean jMj = false;
    private boolean jLx = false;
    private boolean jMk = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText iPk = null;
    private HeadImageView jMl = null;
    private View iPl = null;
    private LinearLayout iPn = null;
    private EditText iPo = null;
    private FeedBackModel jLA = null;
    private FeedBackTopListView jMm = null;
    private ArrayList<WritePrefixItemLayout> jLC = new ArrayList<>();
    private String hgF = null;
    private final KeyEvent eXz = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View cdY = null;
    private TextView jMo = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a jMp = null;
    private final Handler mHandler = new Handler();
    private boolean jMq = false;
    private String jMr = null;
    private RelativeLayout mParent = null;
    private String csu = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int csv = 0;
    private int jMs = 0;
    private WriteImagesInfo jMt = new WriteImagesInfo();
    private View mRootView = null;
    private GridView jMv = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a jMw = null;
    private ScrollView jLP = null;
    private EditText jMx = null;
    private View jMy = null;
    private View jMz = null;
    private View jMA = null;
    private EditText jMB = null;
    private TextView jMC = null;
    private TextView jMD = null;
    private TextWatcher jME = null;
    private TextWatcher jMF = null;
    private boolean jLQ = false;
    private boolean jMG = false;
    private com.baidu.tbadk.core.view.b cAX = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private File jMH = null;
    private TbImageView jMI = null;
    private View jMJ = null;
    private Dialog jMK = null;
    private LinearLayout jML = null;
    private boolean jMN = false;
    private long jMO = -1000;
    private boolean jMP = false;
    private String fOd = "2";
    private int jFJ = 0;
    private String mTopicId = "";
    private SpannableStringBuilder jLT = new SpannableStringBuilder();
    private boolean jMT = false;
    private boolean jLV = false;
    private final b jLW = new b();
    private final HttpMessageListener jMV = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.hgF)) {
                    WriteActivity.this.hgF = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.rZ(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.hgF)) {
                    WriteActivity.this.hgF = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.hgF);
                    WriteActivity.this.rZ(true);
                }
            }
        }
    };
    private TbFaceManager.a jLY = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan qm(String str) {
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
            TiebaStatic.log(new am("c12536").P("obj_locate", at.a.bTa));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").P("obj_locate", at.a.bTa));
        }
    };
    private final NewWriteModel.d csE = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.bkh();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.jLW.aI(null);
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
                    WriteActivity.this.jLW.aI(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.jLW.FG(postWriteCallBackData.getErrorString());
                    WriteActivity.this.jLW.b(WriteActivity.this.iPk, WriteActivity.this.iPo);
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
                    if (com.baidu.tbadk.v.a.rc(xVar.alz())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, xVar.alz());
                        if (WriteActivity.this.jMk) {
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
    private final LocationModel.a csC = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
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
            if (aVar != null && !StringUtils.isNull(aVar.cna())) {
                WriteActivity.this.b(2, true, aVar.cna());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener jbg = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.csp.qR(false);
                    WriteActivity.this.csp.eo(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.csp.qR(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener jLZ = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener jMa = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.cqL.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cyz = WriteActivity.this.cyz();
            if (cyz >= 0 && cyz < WriteActivity.this.iPo.getText().length()) {
                WriteActivity.this.iPo.setSelection(cyz);
            }
        }
    };
    private boolean jMb = true;
    private final View.OnFocusChangeListener iPi = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.iPk || view == WriteActivity.this.cdY || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.jMb = true;
                    WriteActivity.this.cyA();
                    l.c(WriteActivity.this.getActivity(), WriteActivity.this.iPk);
                    if (WriteActivity.this.cqL != null) {
                        WriteActivity.this.cqL.app();
                    }
                } else if (view == WriteActivity.this.iPk) {
                    WriteActivity.this.iPp.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.iPo && z) {
                WriteActivity.this.jMb = false;
                WriteActivity.this.cyA();
                l.c(WriteActivity.this.getActivity(), WriteActivity.this.iPo);
                if (WriteActivity.this.cqL != null) {
                    WriteActivity.this.cqL.app();
                }
            }
            WriteActivity.this.cyG();
        }
    };
    private TextWatcher jMc = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String jMg = "";
        private String jMh;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jMh = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jMh != null ? this.jMh.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cjx();
            WriteActivity.this.cyH();
            EditText cyS = WriteActivity.this.cyS();
            if (editable != null && cyS != null && cyS.getText() != null) {
                if (this.jMg == null || !this.jMg.equals(editable.toString())) {
                    if (WriteActivity.this.jLW != null) {
                        this.jMg = cyS.getText().toString();
                        WriteActivity.this.jLW.o(cyS);
                        return;
                    }
                    return;
                }
                cyS.setSelection(cyS.getSelectionEnd());
            }
        }
    };
    private TextWatcher jMd = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String jMh;
        private String jMi = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jMh = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jMh != null ? this.jMh.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cjx();
            EditText cyR = WriteActivity.this.cyR();
            if (editable != null && cyR != null && cyR.getText() != null) {
                if (this.jMi == null || !this.jMi.equals(editable.toString())) {
                    if (WriteActivity.this.jLW != null) {
                        this.jMi = cyR.getText().toString();
                        WriteActivity.this.jLW.o(cyR);
                        return;
                    }
                    return;
                }
                cyR.setSelection(cyR.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0407a hPB = new a.InterfaceC0407a() { // from class: com.baidu.tieba.write.write.WriteActivity.31
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0407a
        public void onRefresh() {
            WriteActivity.this.hgF = null;
            WriteActivity.this.rZ(false);
            WriteActivity.this.cqL.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
        } else if (this.csp.cng()) {
            aru();
        } else {
            this.csp.qR(false);
            b(1, true, null);
            this.csp.cne();
        }
    }

    public void czb() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
            if (this.jLU != null) {
                this.jLU.cxD();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            arx();
        } else if (this.csp != null) {
            this.csp.qR(false);
            b(1, true, null);
            this.csp.cne();
        }
    }

    private void arx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ho(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.jS()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.csp.aTL();
                } else {
                    WriteActivity.this.csC.arJ();
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
    public int cyz() {
        int selectionEnd = cyR().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cyR().getText().getSpans(0, cyR().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cyR().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cyR().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyA() {
        if (this.cqL != null) {
            this.cqL.setBarLauncherEnabled(!this.jMb);
            this.cqL.setBarLauncherEnabled(true, 26);
            this.cqL.setBarLauncherEnabled(true, 2);
            V(9, this.jMb ? false : true);
        }
    }

    private void V(int i, boolean z) {
        com.baidu.tbadk.editortools.g kg;
        if (this.cqL != null && (kg = this.cqL.kg(i)) != null) {
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
        if (this.jLQ) {
            this.iPk.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.jMA.setVisibility(8);
            } else {
                this.jMA.setVisibility(0);
            }
            a(this.jMD, this.jMx);
            a(this.jMC, this.jMB);
            cjx();
        }
        if (this.jMj) {
            this.jMb = true;
            cyA();
            if (this.cqL != null) {
                this.cqL.app();
            }
            this.iPk.requestFocus();
            ShowSoftKeyPadDelay(this.iPk);
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
            czq();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                cza();
            }
            sa(true);
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
            CE(this.jFJ);
        }
        initUI();
        czg();
        this.csp = new LocationModel(this);
        this.csp.a(this.csC);
        registerListener(this.jbg);
        registerListener(this.jLZ);
        initEditor();
        czt();
        if (this.jLQ) {
            this.jMw.setEditorTools(this.cqL);
        } else {
            this.iPo.requestFocus();
        }
        cfz();
        cza();
        czr();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.cqL = new EditorTools(getActivity());
        this.cqL.setBarMaxLauCount(5);
        this.cqL.setMoreButtonAtEnd(true);
        this.cqL.setBarLauncherType(1);
        this.cqL.fd(true);
        this.cqL.fe(true);
        this.cqL.setMoreLauncherIcon(R.drawable.write_more);
        this.cqL.setBackgroundColorId(R.color.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                cze();
                break;
            default:
                cyB();
                break;
        }
        this.cqL.aqT();
        if (this.jLy != null) {
            this.jLy.addView(this.cqL);
        }
        cyC();
        this.cqL.pO();
        com.baidu.tbadk.editortools.g kg = this.cqL.kg(6);
        if (kg != null && !TextUtils.isEmpty(this.csu)) {
            ((View) kg).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.csu);
                }
            });
        }
        if (!this.jLQ) {
            this.cqL.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.cqL.app();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("xiaoying_has_click", false)) {
            this.cqL.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("hot_topic_has_click", false)) {
            this.cqL.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        cyE();
    }

    private void czc() {
        this.jMy = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.jMA = this.jMy.findViewById(R.id.live_post_title_container);
        this.jMx = (EditText) this.jMy.findViewById(R.id.live_post_content);
        this.jMv = (GridView) this.jMy.findViewById(R.id.photoLiveGridView);
        this.jMB = (EditText) this.jMy.findViewById(R.id.live_post_title);
        this.jMC = (TextView) this.jMy.findViewById(R.id.titleOverPlusNumber);
        this.jMD = (TextView) this.jMy.findViewById(R.id.contentOverPlusNumber);
        this.jMz = this.jMy.findViewById(R.id.live_interval_view);
        this.jMC.setText(String.valueOf(20));
        this.jMD.setText(String.valueOf(233));
        this.jMy.setVisibility(0);
        this.jMC.setVisibility(0);
        this.jMD.setVisibility(0);
        this.jMB.setHint(R.string.tips_title_limit_new);
        this.jMB.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.jMG = true;
                    WriteActivity.this.jMb = true;
                    WriteActivity.this.cyA();
                    if (WriteActivity.this.cqL != null) {
                        WriteActivity.this.cqL.app();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.jMx.setHint(R.string.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.jMx.setHint(R.string.live_write_input_content_update);
        }
        this.jMx.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.jMG = false;
                    WriteActivity.this.jMb = false;
                    WriteActivity.this.cyA();
                    if (WriteActivity.this.cqL != null) {
                        WriteActivity.this.cqL.app();
                    }
                }
            }
        });
        this.jMx.requestFocus();
        this.jMx.addTextChangedListener(Dp());
        this.jMB.requestFocus();
        this.jMB.addTextChangedListener(Dp());
        this.jMB.setOnClickListener(this.jMa);
        this.jMx.setOnClickListener(this.jMa);
        this.jMw = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.jMv);
        this.jMw.Cy(6);
        this.jMv.setAdapter((ListAdapter) this.jMw);
        View findViewById = this.jMy.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void cyk() {
                WriteActivity.this.czo();
            }
        });
        czd();
    }

    private void czd() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.jMB.setText(this.mData.getTitle());
                this.jMB.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.jLQ) {
            czm();
        }
        if (this.cqL.aqV()) {
            this.cqL.app();
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
            albumActivityConfig.setCallFrom(this.fOd);
            albumActivityConfig.setProfessionZone(this.mData.getProZone());
            sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void cze() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.cqL.ai(arrayList);
        com.baidu.tbadk.editortools.k kj = this.cqL.kj(5);
        if (kj != null) {
            kj.crw = 2;
            kj.cru = R.drawable.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.cru = R.drawable.write_at;
        this.cqL.b(aVar);
        this.cqL.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void cyB() {
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        com.baidu.tbadk.editortools.k kVar3;
        com.baidu.tbadk.editortools.k kVar4;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.k kVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.cru = R.drawable.write_picture;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            this.cqL.b(dVar);
        }
        Boolean czk = czk();
        if (!this.jMj && czk != null && czk.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.cnH() && p.b(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), com.baidu.tbadk.editortools.k.class)) != null && (kVar5 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar5.crw = 3;
            kVar5.cru = R.drawable.write_recorder;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.cqL.b(kVar5);
            }
        }
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        aVar.cru = R.drawable.icon_post_topic_selector;
        this.cqL.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001343, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask2 != null && (kVar4 = (com.baidu.tbadk.editortools.k) runTask2.getData()) != null) {
            kVar4.crw = 5;
            kVar4.cru = R.drawable.write_privilege;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.cqL.b(kVar4);
            }
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask3 != null && (kVar3 = (com.baidu.tbadk.editortools.k) runTask3.getData()) != null) {
            kVar3.crw = 6;
            kVar3.cru = this.jMj ? R.drawable.write_location : R.drawable.icon_post_more_location;
            this.cqL.b(kVar3);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 7);
        aVar2.cru = R.drawable.icon_post_more_at;
        this.cqL.b(aVar2);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask4 != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
            kVar2.cry = true;
            kVar2.crw = 9;
            kVar2.cru = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.cqL.b(kVar2);
            }
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask5 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask5.getData()) != null) {
            kVar.cry = true;
            kVar.crw = 10;
            kVar.cru = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.cqL.b(kVar);
            }
        }
        if (this.jLE == null) {
            if (this.jLU == null) {
                this.jLU = new com.baidu.tieba.write.editor.b(getActivity(), this.fOd);
                this.jLU.bs(this.mData.getForumId(), this.privateThread);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.jLU.cxz();
                this.jLU.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                czb();
            }
            this.cqL.b(this.jLU);
        }
        this.cqL.ai(arrayList);
        com.baidu.tbadk.editortools.k kj = this.cqL.kj(5);
        if (kj != null) {
            kj.crw = 1;
            kj.cru = R.drawable.write_emotion;
        }
    }

    private void cyD() {
        if (this.jLX != null) {
            this.jLX.hideTip();
        }
    }

    private void cyE() {
        if (this.jLX == null) {
            this.jLX = new e(getPageContext());
        }
        this.jLX.c(this.cqL);
    }

    private void cyC() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.cyQ()) {
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
                                    WriteActivity.this.sa(true);
                                    WriteActivity.this.cjx();
                                }
                            } else if (WriteActivity.this.cyQ()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(pVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.cyT();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bSD();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.czq();
                        WriteActivity.this.cjx();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.CF(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new am("c12612").P("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.jLE == null) {
                            WriteActivity.this.ary();
                            return;
                        }
                        switch (WriteActivity.this.csv) {
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
                        if (WriteActivity.this.csp != null) {
                            WriteActivity.this.csp.qR(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.hgF = null;
                        } else {
                            WriteActivity.this.hgF = (String) aVar.data;
                        }
                        WriteActivity.this.rZ(false);
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
                            WriteActivity.this.cqL.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.cqL.aqV()) {
                                        WriteActivity.this.cqL.app();
                                        WriteActivity.this.cqL.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.cqL.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.cqL.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.cqL.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.cqL.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.cjx();
                        if (WriteActivity.this.iPo != null) {
                            WriteActivity.this.iPo.requestFocus();
                        }
                        WriteActivity.this.cqL.app();
                        WriteActivity.this.cqL.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iPo);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new am("c12612").P("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.cqL.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.jLw = true;
                        WriteActivity.this.rX(true);
                        if (!WriteActivity.this.cyS().isFocused() || WriteActivity.this.jLz.getVisibility() != 0) {
                            WriteActivity.this.jLv = "from_content";
                        } else {
                            WriteActivity.this.jLv = "from_title";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.jLz.setVisibility(0);
                        WriteActivity.this.jLz.requestFocus();
                        WriteActivity.this.cjx();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.jLz.hasFocus()) {
                            WriteActivity.this.iPo.requestFocus();
                            WriteActivity.this.iPo.setSelection(WriteActivity.this.iPo.getText().toString().length());
                        }
                        WriteActivity.this.jLz.setVisibility(8);
                        WriteActivity.this.cjx();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.cqL.setActionListener(16, bVar);
        this.cqL.setActionListener(14, bVar);
        this.cqL.setActionListener(24, bVar);
        this.cqL.setActionListener(3, bVar);
        this.cqL.setActionListener(10, bVar);
        this.cqL.setActionListener(11, bVar);
        this.cqL.setActionListener(12, bVar);
        this.cqL.setActionListener(13, bVar);
        this.cqL.setActionListener(15, bVar);
        this.cqL.setActionListener(18, bVar);
        this.cqL.setActionListener(20, bVar);
        this.cqL.setActionListener(25, bVar);
        this.cqL.setActionListener(27, bVar);
        this.cqL.setActionListener(29, bVar);
        this.cqL.setActionListener(43, bVar);
        this.cqL.setActionListener(45, bVar);
        this.cqL.setActionListener(53, bVar);
        this.cqL.setActionListener(48, bVar);
        this.cqL.setActionListener(46, bVar);
        this.cqL.setActionListener(49, bVar);
        this.cqL.setActionListener(47, bVar);
        this.cqL.setActionListener(55, bVar);
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
        if (this.csp.aTH()) {
            if (this.csp.cng()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.cnc().getLocationData().cna());
                return;
            }
            b(1, true, null);
            this.csp.cne();
            return;
        }
        b(0, true, null);
    }

    protected void cjp() {
        if (this.csq != null) {
            this.csq.cancelLoadData();
        }
        if (this.jLA != null) {
            this.jLA.cancelLoadData();
        }
        if (this.csp != null) {
            this.csp.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cyD();
        TiebaPrepareImageService.StopService();
        cjp();
        czj();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.jMu != null) {
            this.jMu.destroy();
        }
        if (this.jMU != null) {
            this.jMU.aZA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyF() {
        if (this.mData != null && this.mData.getType() == 2 && this.jMq) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.mData.setTitle(cyS().getText().toString());
            this.mData.setContent(cyR().getText().toString());
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
            if (this.iPq != null && this.iPq.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.iPq, getPageContext().getPageActivity());
                return true;
            } else if (this.cqL.aqV()) {
                this.cqL.app();
                return true;
            } else {
                cjp();
                cyF();
                return true;
            }
        }
        if (i == 67 && (text = cyR().getText()) != null) {
            int selectionStart = cyR().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cyR().onKeyDown(67, this.eXz);
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
        getLayoutMode().onModeChanged(this.jML);
        if (this.jMI != null && i == 1) {
            this.jMI.setBorderColor(al.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.f(this.mPost, R.color.cp_link_tip_a, 1);
        cyA();
        al.l(this.jMy, R.color.cp_bg_line_d);
        al.l(this.iPl, R.color.cp_bg_line_c);
        al.l(this.jMz, R.color.cp_bg_line_c);
        al.l(cyS(), R.color.cp_bg_line_d);
        al.c(this.hIQ, (int) R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.hgF)) {
            al.l(cyR(), R.color.cp_bg_line_d);
        }
        cjx();
        this.cqL.onChangeSkinType(i);
        if (this.jLO != null) {
            this.jLO.ajG();
        }
        al.j(this.mName, R.color.cp_cont_b);
        cyG();
        cyH();
        if (this.jLW != null) {
            this.jLW.c(cyS(), cyR());
        }
        this.jJF.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyG() {
        if (this.iPk.hasFocus()) {
            this.iPk.setHintTextColor(al.getColor(R.color.cp_cont_e));
        } else {
            this.iPk.setHintTextColor(al.getColor(R.color.cp_cont_d));
        }
        if (this.iPo.hasFocus()) {
            this.iPo.setHintTextColor(al.getColor(R.color.cp_cont_e));
        } else {
            this.iPo.setHintTextColor(al.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyH() {
        if (this.iPk != null && this.iPk.getText() != null && this.iPk.getText().toString() != null && this.iPk.getPaint() != null) {
            if (this.iPk.getText().toString().length() == 0) {
                this.iPk.getPaint().setFakeBoldText(false);
            } else if (this.iPk.getText().toString().length() > 0) {
                this.iPk.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.cAX = new com.baidu.tbadk.core.view.b(getPageContext());
        this.jLQ = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.cdY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_topbar_close, R.drawable.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        al.j(this.mName, R.color.cp_cont_b);
        this.jMo = (TextView) findViewById(R.id.btn_image_problem);
        cyJ();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.g(getPageContext().getPageActivity(), R.dimen.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.iPi);
        this.jLP = (ScrollView) findViewById(R.id.write_scrollview);
        this.jLP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.iPo != null) {
                        l.b(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.iPo);
                    }
                    if (WriteActivity.this.cqL != null) {
                        WriteActivity.this.cqL.app();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jMm = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.jMn = findViewById(R.id.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(R.id.parent);
        this.jLy = (LinearLayout) findViewById(R.id.tool_view);
        this.jLy.setContentDescription("..");
        this.jLz = (LinearLayout) findViewById(R.id.title_view);
        this.iPl = findViewById(R.id.interval_view);
        this.jMQ = findViewById(R.id.hot_topic_fourm_view);
        this.jMR = findViewById(R.id.hot_topic_divider);
        this.jLS = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.jMS = (TextView) findViewById(R.id.change_one_tv);
        cjw();
        if (this.jLQ) {
            this.jLP.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            czc();
        } else {
            this.jMu = new g(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.jMu.rS(false);
            } else {
                g gVar = this.jMu;
                if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                    z = false;
                }
                gVar.rS(z);
            }
        }
        cjy();
        if (this.jMj || this.jLx) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().bTK) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.iPn = (LinearLayout) findViewById(R.id.post_content_container);
        this.iPn.setDrawingCacheEnabled(false);
        this.iPn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.cqL.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.iPo.requestFocus();
            }
        });
        this.hIN = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.hIO = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.hIQ = (ImageView) findViewById(R.id.iv_delete_voice);
        this.hIQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bSD();
            }
        });
        this.cdY.setOnFocusChangeListener(this.iPi);
        this.cdY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cjp();
                WriteActivity.this.cyF();
            }
        });
        this.jMo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        cyM();
        l(czk());
        cyO();
        cyI();
        czh();
        czi();
        cyA();
        cyN();
        cjv();
        cyU();
        if (this.mData.getType() == 4 && this.iPs != null && this.jLB != null) {
            this.iPs.setVisibility(8);
            this.jLB.setVisibility(8);
        }
        cjx();
        czf();
        cxR();
    }

    private void cxR() {
        this.jJF = new com.baidu.tieba.write.b.c(getPageContext().getPageActivity(), this.mName, this.mData.getProZone(), isUseStyleImmersiveSticky() ? StatusBarUtil.getStatusBarOffsetPx(getPageContext().getPageActivity()) : 0);
        this.jJF.a(new c.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // com.baidu.tieba.write.b.c.a
            public void Ct(int i) {
                WriteActivity.this.mData.setProZone(i);
            }
        });
        this.jJF.bdR();
    }

    private void cyI() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.jMj || this.jLx) {
                        if (this.jMk) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.fOd != null && this.fOd.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                    } else if (this.fOd != null && this.fOd.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.mData.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.mData.getForumName() + getResources().getString(R.string.bar));
                        this.iPk.setVisibility(8);
                        String str3 = this.fnd + " " + this.fnb;
                        if (!StringUtils.isNull(str3)) {
                            this.iPo.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.iPk.setVisibility(0);
                    this.iPo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.iPo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.iPk.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.iPo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.jMz.setVisibility(8);
                    return;
                case 7:
                    this.iPk.setVisibility(0);
                    this.iPo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void cyJ() {
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

    private void cyK() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.jMj && !this.jLx && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String i = ap.i(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(i) && cyS() != null) {
                cyS().setText(i);
                cyS().setSelection(i.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.hIN.setVisibility(0);
            this.hIO.setVoiceModel(voiceModel);
            this.hIO.cnG();
            cjx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSD() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.aY(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.hIN.setVisibility(8);
        this.hIO.bvS();
        this.hIO.setVoiceModel(null);
        com.baidu.tbadk.editortools.k kj = this.cqL.kj(6);
        if (kj != null && kj.cqF != null) {
            kj.cqF.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cjx();
    }

    private void cyL() {
        this.jLJ = null;
        this.jLL = -1;
        this.jLN = -1;
        com.baidu.tieba.frs.x rs = w.blC().rs(1);
        if (rs != null) {
            this.jLJ = rs.fsG;
            this.jLL = getIntent().getIntExtra("category_id", -1);
            if (this.jLJ != null && !this.jLJ.isEmpty() && this.jLL >= 0) {
                this.jLK = new v();
                this.jLK.fsC = 0;
                this.jLK.name = getPageContext().getResources().getString(R.string.category_auto);
                this.jLN = this.jLK.fsC;
                this.jLM = this.jLK.name;
                for (v vVar : this.jLJ) {
                    if (vVar.fsC == this.jLL) {
                        this.jLN = vVar.fsC;
                        this.jLM = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cyM() {
        if (this.jLJ != null && !this.jLJ.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.jLO = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.jLO.setText(this.jLM);
            this.jLO.setCategoryContainerData(this.jLJ, this.jLK, this.jLN);
            this.jLO.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ar arVar) {
                    if (arVar != null) {
                        WriteActivity.this.jLO.setText(arVar.name);
                        WriteActivity.this.mData.setCategoryTo(arVar.fsC);
                        WriteActivity.this.jLN = arVar.fsC;
                        WriteActivity.this.jLO.cyn();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.jLO.cym();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cyS());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cyR());
                }
            });
        }
    }

    private void czf() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.jMe = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.jMe.setTitle(R.string.no_disturb_start_time);
        this.jMe.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.jMe);
        this.jMe.setButton(-2, getPageContext().getString(R.string.cancel), this.jMe);
        return this.jMe;
    }

    private void cyN() {
        this.jLF = (RelativeLayout) findViewById(R.id.addition_container);
        this.jLG = (TextView) findViewById(R.id.addition_create_time);
        this.jLH = (TextView) findViewById(R.id.addition_last_time);
        this.jLI = (TextView) findViewById(R.id.addition_last_content);
        if (this.jLE != null) {
            this.jLF.setVisibility(0);
            this.jLG.setText(getPageContext().getString(R.string.write_addition_create) + ap.aC(this.jLE.getCreateTime() * 1000));
            if (this.jLE.getAlreadyCount() == 0) {
                this.jLH.setVisibility(8);
            } else {
                this.jLH.setText(getPageContext().getString(R.string.write_addition_last) + ap.aC(this.jLE.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.jLE.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.jLI.setText(lastAdditionContent);
            } else {
                this.jLI.setVisibility(8);
            }
            cyR().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.jLE.getAlreadyCount()), Integer.valueOf(this.jLE.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.jLF.setVisibility(8);
    }

    private void cjv() {
        this.iPs = findViewById(R.id.post_prefix_layout);
        if (this.jMU == null) {
            this.jMU = new com.baidu.tieba.c.d(getPageContext(), this.iPs);
            this.jMU.pK(R.drawable.bg_tip_blue_up_left);
            this.jMU.pJ(16);
            this.jMU.iI(true);
            this.jMU.S(true);
            this.jMU.pN(l.g(getActivity(), R.dimen.ds32));
        }
        this.iPp = (TextView) findViewById(R.id.post_prefix);
        this.jLB = findViewById(R.id.prefix_divider);
        this.iPr = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.iPs.setVisibility(0);
            this.jMU.u(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iOS = 0;
            this.iPs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c13013").bT("fid", WriteActivity.this.mData.getForumId()).l("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.iPp.setVisibility(0);
                    WriteActivity.this.iPs.setSelected(true);
                    al.c(WriteActivity.this.iPr, (int) R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.iPq, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.cqL.app();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iPk);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iPo);
                }
            });
            this.iPp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new am("c13013").bT("fid", WriteActivity.this.mData.getForumId()).l("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.iPp.setSelected(true);
                    al.c(WriteActivity.this.iPr, (int) R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.iPq, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.cqL.app();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cyS());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cyR());
                }
            });
            this.iPq = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.iPq.a(this);
            this.iPq.setMaxHeight(l.g(getActivity(), R.dimen.ds510));
            this.iPq.setOutsideTouchable(true);
            this.iPq.setFocusable(true);
            this.iPq.setOnDismissListener(this);
            this.iPq.setBackgroundDrawable(al.getDrawable(R.color.cp_bg_line_d));
            int color = al.getColor(R.color.cp_cont_b);
            al.getColor(R.color.cp_cont_c);
            al.k(this.iPp, R.color.cp_bg_line_d);
            al.c(this.iPr, (int) R.drawable.icon_arrow_gray_down);
            this.iPp.setTextColor(color);
            this.jLC.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.jLC.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.rN(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.rN(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.iPq.addView(writePrefixItemLayout);
            }
            this.iPq.setCurrentIndex(0);
            this.iPp.setText(prefixs.get(0));
            CD(0);
            return;
        }
        this.iPs.setVisibility(8);
    }

    private void czg() {
        if (this.jMj && this.mData != null) {
            this.jMm.setVisibility(0);
            this.jMn.setVisibility(0);
            this.jLA = new FeedBackModel(getPageContext());
            this.jLA.Gb(this.mData.getForumName());
            this.jLA.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.24
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.jMm.setVisibility(8);
                        WriteActivity.this.jMn.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.jMm.setVisibility(8);
                        WriteActivity.this.jMn.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.jMm.a(feedBackModel.cyp(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void cyO() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.jS()) {
                    WriteActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (WriteActivity.this.jLW.a(WriteActivity.this.iPk, WriteActivity.this.iPo)) {
                        WriteActivity.this.showToast(WriteActivity.this.jLW.cwh());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cyS());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cyR());
                    WriteActivity.this.cqL.app();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.jMj) {
                            WriteActivity.this.cyX();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            am amVar = new am("c12102");
                            amVar.P("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(amVar);
                            WriteActivity.this.cyY();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.cyX();
                    }
                    TiebaStatic.log(new am("c12262").bT("obj_locate", WriteActivity.this.fOd));
                }
            }
        });
    }

    protected void czh() {
        this.jMp = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.jMp.mD(getPageContext().getString(R.string.is_save_draft)).dM(false).a(getPageContext().getString(R.string.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.cyS().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.cyR().getText().toString());
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
        this.jMp.b(getPageContext());
    }

    protected void cjw() {
        this.jMl = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.jMl.setIsRound(true);
        this.jMl.setDrawBorder(false);
        this.jMl.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String nA = o.nA(currentPortrait);
            this.jMl.setUrl(nA);
            this.jMl.startLoad(nA, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.jMl.setVisibility(0);
        }
        this.iPk = (EditText) findViewById(R.id.post_title);
        this.iPk.setOnClickListener(this.jMa);
        this.iPk.setOnFocusChangeListener(this.iPi);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.iPk.setText(this.mData.getTitle());
                this.iPk.setSelection(this.mData.getTitle().length());
            } else if (this.jMk) {
                this.iPk.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.iPk.addTextChangedListener(this.jMc);
        if (!this.mData.getHaveDraft()) {
            cyK();
            this.jMP = true;
        }
        if (this.mData.isUserFeedback()) {
            this.iPk.setHint(getResources().getString(R.string.feedback_title_hint));
        } else {
            this.iPk.setHint(getResources().getString(R.string.post_title_hint));
        }
    }

    private TextWatcher Dp() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            private int jMY;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.cjx();
                if (WriteActivity.this.jLQ) {
                    this.jMY = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.jMY);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.jLQ || !WriteActivity.this.jMG) {
                    if (WriteActivity.this.jLQ) {
                        if (this.mEditText != WriteActivity.this.jMx || this.mTextView != WriteActivity.this.jMD) {
                            this.mEditText = WriteActivity.this.jMx;
                            this.mTextView = WriteActivity.this.jMD;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.jMB || this.mTextView != WriteActivity.this.jMC) {
                    this.mEditText = WriteActivity.this.jMB;
                    this.mTextView = WriteActivity.this.jMC;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.jLQ && this.jMG) {
            if (this.jME != null) {
                this.jMB.removeTextChangedListener(this.jME);
            }
            this.jME = textWatcher;
        } else if (this.jLQ) {
            if (this.jMF != null) {
                this.jMx.removeTextChangedListener(this.jMF);
            }
            this.jMF = textWatcher;
        }
        return textWatcher;
    }

    private long p(EditText editText) {
        if (editText == this.jMx) {
            return 233L;
        }
        if (editText != this.jMB) {
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

    protected void cjy() {
        this.iPo = (EditText) findViewById(R.id.post_content);
        this.iPo.setDrawingCacheEnabled(false);
        this.iPo.setOnClickListener(this.jMa);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString al = TbFaceManager.aso().al(getPageContext().getPageActivity(), this.mData.getContent());
            this.iPo.setText(al);
            this.iPo.setSelection(al.length());
        } else if (this.mData.getType() == 2) {
            if (this.jMq) {
                if (this.jMr != null && this.jMr.length() > 0) {
                    this.iPo.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.jMr}));
                    this.iPo.setSelection(this.iPo.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.iPo.setText(format);
                this.iPo.setSelection(format.length());
            }
        }
        this.iPo.setOnFocusChangeListener(this.iPi);
        this.iPo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.cqL.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.iPo.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iPo.addTextChangedListener(this.jMd);
        if (this.mData.getType() == 0) {
            this.jMT = true;
        } else {
            rZ(true);
            this.jMT = false;
        }
        if (this.mData.isUserFeedback()) {
            this.iPo.setHint(R.string.write_input_content);
        } else {
            this.iPo.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void rZ(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.jLQ) {
            cyR().setPadding(0, 0, 0, 0);
            cyR().setBackgroundDrawable(null);
            al.l(cyR(), R.color.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.hgF) && this.jLE == null) {
                com.baidu.adp.lib.f.c.iv().a(this.hgF, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.30
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
                            WriteActivity.this.cyR().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.cyR(), true, WriteActivity.this.hPB);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyQ() {
        int i = UIMsg.m_AppUI.MSG_APP_GPS;
        if (this.jLE != null) {
            i = 1000;
        }
        return cyR().getText() != null && cyR().getText().length() >= i;
    }

    private void pU(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.jLv)) {
                this.jLv = "";
                cyR().requestFocus();
                if (cyR().getText() != null && cyR().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cyR().getSelectionStart();
                    editable = cyR().getText();
                }
            } else if ("from_title".equals(this.jLv)) {
                this.jLv = "";
                cyS().requestFocus();
                if (cyS().getText() != null && cyS().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cyS().getSelectionStart();
                    editable = cyS().getText();
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
    public void rX(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void e(com.baidu.tbadk.coreExtra.data.p pVar) {
        if (((ImageSpan[]) cyR().getText().getSpans(0, cyR().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.jLD == null) {
                this.jLD = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            this.jLD.show();
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
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.cyR().getSelectionStart(), aVar, alp);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cyR() != null && cyR().getText() != null) {
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
                int selectionStart = cyR().getSelectionStart() - 1;
                if (cyR().getText().length() > 1 && selectionStart >= 0 && cyR().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cyR().getText().insert(cyR().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cyR().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cyR().getText().insert(cyR().getSelectionStart(), spannableString2);
            }
            Editable text = cyR().getText();
            if (text != null) {
                this.jLT.clear();
                this.jLT.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jLT);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cyR().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cyR().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cyR().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cyR() {
        return this.jLQ ? this.jMx : this.iPo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cyS() {
        return this.jLQ ? this.jMB : this.iPk;
    }

    protected void cyT() {
        Editable text;
        if (cyR() != null && (text = cyR().getText()) != null) {
            int selectionStart = cyR().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cyR().onKeyDown(67, this.eXz);
            }
            cyR().onKeyDown(67, this.eXz);
            int selectionStart2 = cyR().getSelectionStart();
            if (text != null) {
                this.jLT.clear();
                this.jLT.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jLT);
                cyR().setSelection(selectionStart2);
            }
        }
    }

    private void l(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.jMj = true;
        }
    }

    private void czi() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void czj() {
        try {
            if (this.jMp != null) {
                this.jMp.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.cAX.e(null);
        this.cAX.it(R.string.sending);
        this.cAX.ef(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.cAX.ef(false);
    }

    private Boolean czk() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.csu = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void cjx() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (cyS() != null) {
                str = cyS().getText().toString();
            }
            if (cyR() != null) {
                str2 = cyR().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.iOS == com.baidu.tbadk.core.util.v.Z(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.jLz.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            rY(true);
                            return;
                        }
                    } else if (this.jLz.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        rY(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.jLz.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    rY(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.jLQ) {
                    rY(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    rY(true);
                }
            }
            if (this.mData.getType() == 4) {
                rY(s(this.jMx) && r(this.jMB));
            } else if (this.mData.getType() == 5) {
                rY(s(this.jMx));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                rY(true);
            } else if (this.mData.getVideoInfo() != null) {
                rY(true);
            } else {
                rY(false);
            }
        }
    }

    public void rY(boolean z) {
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
        this.csq = new NewWriteModel(this);
        this.csq.b(this.csE);
        registerListener(this.jMV);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.cjp();
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
            this.jMj = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.jMk = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.jMq = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.jMr = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.cso = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.jLE = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.jLE != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.jMs = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.mData.setTopicId(this.mTopicId);
            this.fOd = bundle.getString("KEY_CALL_FROM");
            this.jFJ = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
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
            this.jMj = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.jMk = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.jMq = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.jMr = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.jLE = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.jLE != null);
            this.mData.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.jMs = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.fnc = intent.getStringExtra("more_forum_img");
            this.fnd = intent.getStringExtra("more_forum_title");
            this.fnb = intent.getStringExtra("more_forum_url");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.mData.setTopicId(this.mTopicId);
            this.fOd = intent.getStringExtra("KEY_CALL_FROM");
            this.jFJ = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.jMj);
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
        this.hgF = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.jLx = true;
        }
        cyL();
        try {
            this.jMH = czs();
        } catch (Throwable th) {
            this.jMH = null;
        }
    }

    private void cyU() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.iPk.setText(com.baidu.tbadk.plugins.b.qE(com.baidu.tbadk.plugins.b.qF(hotTopicBussinessData.mTopicName)));
            this.iPk.setMovementMethod(com.baidu.tieba.view.c.cvc());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString qE = com.baidu.tbadk.plugins.b.qE(com.baidu.tbadk.plugins.b.qF(hotTopicBussinessData.mTopicName));
            if (qE != null) {
                this.iPk.setText(qE);
            }
            this.jLS.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t.a
    public void a(WriteData writeData) {
        String str;
        String qF;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            if (writeData != null) {
                if (this.mData != null) {
                    this.mData.setHaveDraft(true);
                    if (com.baidu.adp.lib.util.k.isEmpty(cyS().getText().toString()) || this.jMP || ((this.jMj || this.jLx) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
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
                                qF = this.mData.getTitle();
                            } else {
                                qF = com.baidu.tbadk.plugins.b.qF(str);
                            }
                            SpannableString qE = com.baidu.tbadk.plugins.b.qE(qF);
                            if (qE != null) {
                                cyS().setText(qE);
                                cyS().setSelection(qE.length() > qF.length() ? qF.length() : qE.length());
                            }
                        } else {
                            SpannableString qE2 = com.baidu.tbadk.plugins.b.qE(this.mData.getTitle());
                            if (qE2 != null) {
                                cyS().setText(qE2);
                                cyS().setSelection(this.mData.getTitle().length() > qE2.length() ? qE2.length() : this.mData.getTitle().length());
                            }
                        }
                    }
                    if (this.mData != null && !this.mData.getHaveDraft()) {
                        cyK();
                    }
                    if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.copy(writeData.getVideoInfo());
                        this.mData.setVideoInfo(videoInfo);
                        this.cqL.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                    }
                    if ((com.baidu.adp.lib.util.k.isEmpty(cyR().getText().toString()) || this.jMj || this.jLx) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                        this.mData.setContent(writeData.getContent());
                        SpannableString a2 = TbFaceManager.aso().a(getPageContext().getPageActivity(), this.mData.getContent(), this.jLY);
                        cyR().setText(a2);
                        cyR().setSelection(a2.length());
                        if (this.jLQ) {
                            a(this.jMD, this.jMx);
                        }
                    }
                    if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                        this.writeImagesInfo = writeData.getWriteImagesInfo();
                        this.mData.setWriteImagesInfo(this.writeImagesInfo);
                        czq();
                        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                            cza();
                        }
                        sa(false);
                    }
                    if (writeData.getType() == 4 || writeData.getType() == 5) {
                        czl();
                    }
                    cjx();
                    int categoryTo = writeData.getCategoryTo();
                    if (categoryTo >= 0 && this.jLJ != null) {
                        this.jLN = this.jLK.fsC;
                        this.jLM = this.jLK.name;
                        int i = 0;
                        while (true) {
                            if (i == this.jLJ.size()) {
                                break;
                            }
                            v vVar = this.jLJ.get(i);
                            if (categoryTo != vVar.fsC) {
                                i++;
                            } else {
                                this.jLN = categoryTo;
                                this.jLM = vVar.name;
                                this.mData.setCategoryTo(this.jLN);
                                break;
                            }
                        }
                        if (this.jLO != null) {
                            this.jLO.setText(this.jLM);
                            this.jLO.setCategoryContainerData(this.jLJ, this.jLK, this.jLN);
                        }
                    }
                    this.cqL.app();
                    return;
                }
                return;
            }
            czl();
            cyK();
        }
    }

    private void czl() {
        if ((!this.jLQ || this.jMw != null) && this.jMv != null) {
            this.jMw.c(this.writeImagesInfo);
            czo();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.jMq);
        if (this.jMj) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.cso);
        if (this.jLE != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.jLE));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.jMs);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.fOd);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.jFJ);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cyR().getEditableText().toString();
        if (obj != null) {
            cyR().setText(TbFaceManager.aso().a(getPageContext().getPageActivity(), obj, this.jLY));
            cyR().setSelection(cyR().getText().length());
        }
    }

    private String cyV() {
        return (cyR() == null || cyR().getText() == null) ? "" : cyR().getText().toString();
    }

    private String cyW() {
        if (this.mData == null || cyS() == null || cyS().getVisibility() != 0 || cyS().getText() == null) {
            return "";
        }
        String obj = cyS().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.Z(this.mPrefixData.getPrefixs()) > 0 && this.iOS != com.baidu.tbadk.core.util.v.Z(this.mPrefixData.getPrefixs()) - 1 && this.mData.getType() != 4 && this.iPp != null && this.iPp.getText() != null) {
            this.mData.setPostPrefix(this.iPp.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void Gc(String str) {
        if (this.mData != null && this.jLz != null) {
            if (this.jLz.getVisibility() == 0) {
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
    public void cyX() {
        cjp();
        this.mData.setContent(cyV());
        Gc(cyW());
        if (this.jMj || this.jLx) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                Gc(string + this.mData.getTitle());
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
        if (this.jLL >= 0) {
            this.mData.setCategoryFrom(this.jLL);
        }
        if (this.jLN >= 0) {
            this.mData.setCategoryTo(this.jLN);
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
        this.mData.setHasLocationData(this.csp != null && this.csp.aTH());
        if (this.writeImagesInfo != null) {
            this.csq.qT(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.mList) && this.jLR != null && this.jLR.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.jLR.mForumId));
            this.mData.setForumName(this.jLR.mForumName);
        }
        this.csq.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.csq.getWriteData().setVoice(this.mVoiceModel.getId());
                this.csq.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.csq.getWriteData().setVoice(null);
                this.csq.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.csq.getWriteData().setVoice(null);
            this.csq.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.csq.cnI()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.jS()) {
            showToast(R.string.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.mDialogCancelListener);
            this.csq.startPostWrite();
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
            if (this.jLE != null) {
                i2 = this.jLE.getTotalCount();
                i = this.jLE.getAlreadyCount() + 1;
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
                if (this.iPk == getCurrentFocus()) {
                    cyR().clearFocus();
                    this.iPk.requestFocus();
                    if (this.cqL != null) {
                        this.cqL.app();
                    }
                    ShowSoftKeyPadDelay(this.iPk);
                } else {
                    cyR().requestFocus();
                    if (this.cqL != null) {
                        this.cqL.app();
                    }
                    ShowSoftKeyPadDelay(this.iPo);
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
                            cyR().getText().insert(cyR().getSelectionStart(), sb.toString());
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
                                czp();
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
                        if (this.jMT) {
                            rZ(true);
                            this.jMT = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.jLQ) {
                        P(intent);
                        cjx();
                        return;
                    }
                    aD(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.cqL.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.cqL.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.cqL.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    cjx();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.jLw) {
                                sb2.append(com.baidu.tbadk.plugins.b.cAr);
                                this.jLw = false;
                            }
                            sb2.append(stringExtra);
                            pU(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.aa(this.mList) && !com.baidu.tbadk.core.util.v.aa(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.jLR = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.jLR);
                }
            }
        } else if (i2 == 0) {
            if (this.cqL != null && !this.cqL.aqV()) {
                this.iPo.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.cqL.app();
            }
            switch (i) {
                case 12001:
                    arB();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    czn();
                    if (this.jMT) {
                        rZ(true);
                        this.jMT = false;
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (this.iPk == getCurrentFocus()) {
                        cyR().clearFocus();
                        this.iPk.requestFocus();
                        if (this.cqL != null) {
                            this.cqL.app();
                        }
                        ShowSoftKeyPadDelay(this.iPk);
                        return;
                    }
                    cyR().requestFocus();
                    if (this.cqL != null) {
                        this.cqL.app();
                    }
                    ShowSoftKeyPadDelay(this.iPo);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.jLW.FG(postWriteCallBackData.getErrorString());
                        this.jLW.aI(postWriteCallBackData.getSensitiveWords());
                        this.jLW.b(this.iPk, this.iPo);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                default:
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.cso = String.valueOf(System.currentTimeMillis());
                    ak.a(getPageContext(), this.cso);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    czn();
                    return;
                case 25004:
                    if ("from_title".equals(this.jLv)) {
                        cyS().requestFocus();
                        return;
                    } else if ("from_content".equals(this.jLv)) {
                        cyR().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyY() {
        if ("1".equals(this.fOd)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.fOd)) {
            this.mData.setCanNoForum(false);
        }
        cyZ();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.fOd);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cyX();
    }

    private void cyZ() {
        if (this.cqL != null) {
            this.cqL.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void czm() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void czn() {
        if (this.jLQ) {
            this.jMw.c(this.writeImagesInfo);
            czo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czo() {
        this.jMw.notifyDataSetChanged();
        this.jMv.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.jMw.notifyDataSetChanged();
                WriteActivity.this.jMv.invalidateViews();
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
        cjx();
    }

    private void aC(Intent intent) {
        if (this.jLQ) {
            aD(intent);
            czn();
        } else {
            aG(intent);
        }
        cjx();
    }

    private void aD(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            czn();
            sa(true);
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

    private void czp() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void aF(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.jMt.parseJson(stringExtra);
            this.jMt.updateQuality();
            if (this.jMt.getChosedFiles() != null && this.jMt.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.jMt.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.jMt.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cyS());
        HidenSoftKeyPad(this.mInputManager, cyR());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void aG(Intent intent) {
        c(intent, true);
    }

    private void O(Intent intent) {
        this.cso = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.cso;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.af(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.ah(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a(TbConfig.LOCAL_CAMERA_DIR, this.cso, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            czq();
            cza();
        }
        sa(true);
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
                czq();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    cza();
                }
            }
            sa(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czq() {
        if (this.cqL.kj(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void arB() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.cso));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void czr() {
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
                            WriteActivity.this.sa(true);
                        }
                    }
                });
                nVar.setFrom(1);
                nVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sa(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.jMu != null) {
            this.jMu.a(this.writeImagesInfo, this.mFrom, forumId);
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
                    TiebaStatic.log(new am("c12534").P("obj_locate", at.a.bTa));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.jLE == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                z(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.csv = i;
        if (this.cqL != null) {
            this.cqL.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void cza() {
        if (!this.jLQ) {
            if (this.cqL != null) {
                this.cqL.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.cqL.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.jMu != null) {
                this.jMu.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fl(boolean z) {
        if (this.cqL != null) {
            this.cqL.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void CD(int i) {
        if (i < this.jLC.size()) {
            for (int i2 = 0; i2 < this.jLC.size(); i2++) {
                this.jLC.get(i2).rO(false);
            }
            this.jLC.get(i).rO(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void Ad(int i) {
        if (i == com.baidu.tbadk.core.util.v.Z(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new am("c13014").P("obj_type", 1));
        } else {
            TiebaStatic.log(new am("c13014").P("obj_type", 2));
        }
        this.iOS = i;
        this.iPq.setCurrentIndex(i);
        CD(i);
        this.iPp.setText(this.mPrefixData.getPrefixs().get(i));
        cjx();
        com.baidu.adp.lib.g.g.a(this.iPq, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.iPs.setSelected(false);
        al.c(this.iPr, (int) R.drawable.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.iPo);
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
                ak.a(getPageContext(), this.cso);
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
        this.jLV = z;
        if (this.jMN && System.currentTimeMillis() - this.jMO < 800) {
            l.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.jMN = false;
        }
        if (this.jLU != null && !z) {
            this.jLU.bed();
        }
        if (this.jLX != null && !z) {
            cyD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gd(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.jMK != null) {
            Ge(str);
            this.jMK.dismiss();
        }
    }

    private void eu(Context context) {
        jMM = l.ah(context);
    }

    private void Ge(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.jMN = true;
        czq();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            cza();
        }
        sa(true);
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

    private File czs() {
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

    private void czt() {
        if (this.jMH != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            eu(getActivity());
            this.jMJ = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.jMJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.jMH != null) {
                        WriteActivity.this.Gd(WriteActivity.this.jMH.getAbsolutePath());
                    }
                }
            });
            this.jMI = (TbImageView) this.jMJ.findViewById(R.id.rec_img_view);
            this.jML = (LinearLayout) this.jMJ.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.agM().getString("write_rec_pic_path", "").equalsIgnoreCase(this.jMH.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.agM().putString("write_rec_pic_path", this.jMH.getAbsolutePath());
                Bitmap f = f(this.jMH.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (f != null) {
                    this.jMI.setImageBitmap(f);
                    this.jMI.setDrawBorder(true);
                    this.jMI.setBorderWidth(2);
                    this.jMI.setBorderColor(al.getColor(R.color.common_color_10264));
                    this.jMK = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.jMK.setCanceledOnTouchOutside(true);
                    this.jMK.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.jMN) {
                                l.b(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.jMO = System.currentTimeMillis();
                            }
                        }
                    });
                    this.jMK.setContentView(this.jMJ);
                    this.jMK.show();
                    Window window = this.jMK.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (jMM / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.jLV && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.jLw = false;
            this.jLv = "";
            if ("from_content".equals(str)) {
                this.jLv = "from_content";
            } else if ("from_title".equals(str)) {
                this.jLv = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.qD(String.valueOf(charSequence.charAt(i)))) {
                rX(false);
            }
        }
    }

    public void cfz() {
        if (this.jMj || !com.baidu.tbadk.core.util.v.aa(this.mList) || !StringUtils.isNull(this.mData.getTitle())) {
            this.jLz.setVisibility(0);
            this.jLz.requestFocus();
            this.cqL.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.jLz.setVisibility(8);
    }
}
