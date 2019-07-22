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
import com.baidu.sapi2.utils.SapiGIDEvent;
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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
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
    private static int jTL = 0;
    private EditorTools crZ;
    private String ctB;
    private LocationModel ctC;
    private NewWriteModel ctD;
    private String fsa;
    private String fsb;
    private String fsc;
    private VoiceManager ftO;
    private LinearLayout hPa;
    private PlayVoiceBntNew hPb;
    private ImageView hPd;
    private TextView iVG;
    private com.baidu.tieba.write.h iVH;
    private ImageView iVI;
    private View iVJ;
    private int iVj;
    private boolean isPrivacy;
    private com.baidu.tieba.write.b.c jQG;
    private View jSA;
    private Toast jSC;
    private AdditionData jSD;
    private RelativeLayout jSE;
    private TextView jSF;
    private TextView jSG;
    private TextView jSH;
    List<v> jSI;
    v jSJ;
    private int jSK;
    private String jSL;
    private int jSM;
    private PostCategoryView jSN;
    private HotTopicBussinessData jSQ;
    private TextView jSR;
    private com.baidu.tieba.write.editor.b jST;
    private e jSW;
    private LinearLayout jSx;
    private LinearLayout jSy;
    private View jTP;
    private View jTQ;
    private TextView jTR;
    private com.baidu.tieba.c.d jTT;
    private com.baidu.tieba.view.b jTd;
    private View jTm;
    private g jTt;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String jSu = "";
    private boolean jSv = false;
    private WriteData mData = null;
    private boolean jTi = false;
    private boolean jSw = false;
    private boolean jTj = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText iVB = null;
    private HeadImageView jTk = null;
    private View iVC = null;
    private LinearLayout iVE = null;
    private EditText iVF = null;
    private FeedBackModel jSz = null;
    private FeedBackTopListView jTl = null;
    private ArrayList<WritePrefixItemLayout> jSB = new ArrayList<>();
    private String hmS = null;
    private final KeyEvent fcA = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View cfb = null;
    private TextView jTn = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a jTo = null;
    private final Handler mHandler = new Handler();
    private boolean jTp = false;
    private String jTq = null;
    private RelativeLayout mParent = null;
    private String ctH = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int ctI = 0;
    private int jTr = 0;
    private WriteImagesInfo jTs = new WriteImagesInfo();
    private View mRootView = null;
    private GridView jTu = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a jTv = null;
    private ScrollView jSO = null;
    private EditText jTw = null;
    private View jTx = null;
    private View jTy = null;
    private View jTz = null;
    private EditText jTA = null;
    private TextView jTB = null;
    private TextView jTC = null;
    private TextWatcher jTD = null;
    private TextWatcher jTE = null;
    private boolean jSP = false;
    private boolean jTF = false;
    private com.baidu.tbadk.core.view.b cCo = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private File jTG = null;
    private TbImageView jTH = null;
    private View jTI = null;
    private Dialog jTJ = null;
    private LinearLayout jTK = null;
    private boolean jTM = false;
    private long jTN = -1000;
    private boolean jTO = false;
    private String fTa = "2";
    private int jMM = 0;
    private String mTopicId = "";
    private SpannableStringBuilder jSS = new SpannableStringBuilder();
    private boolean jTS = false;
    private boolean jSU = false;
    private final b jSV = new b();
    private final HttpMessageListener jTU = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.hmS)) {
                    WriteActivity.this.hmS = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.so(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.hmS)) {
                    WriteActivity.this.hmS = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.hmS);
                    WriteActivity.this.so(true);
                }
            }
        }
    };
    private TbFaceManager.a jSX = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan qD(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.nK());
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
    private final AntiHelper.a fvc = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").P("obj_locate", au.a.bUb));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").P("obj_locate", au.a.bUb));
        }
    };
    private final NewWriteModel.d ctR = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.bmj();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.jSV.aI(null);
                if (z) {
                    WriteActivity.this.fp(z);
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
                            TiebaStatic.log(new an("c11731").bT(VideoPlayActivityConfig.OBJ_ID, WriteActivity.this.mTopicId));
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
                    WriteActivity.this.jSV.aI(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.jSV.GA(postWriteCallBackData.getErrorString());
                    WriteActivity.this.jSV.b(WriteActivity.this.iVB, WriteActivity.this.iVF);
                } else if ((xVar == null || writeData == null || xVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (xVar != null && writeData != null && xVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.amF());
                    if (com.baidu.tbadk.v.a.ru(xVar.amE())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, xVar.amE());
                        if (WriteActivity.this.jTj) {
                            newVcodeActivityConfig.setHideFeedBackButton();
                        }
                        WriteActivity.this.sendMessage(new CustomMessage(2002001, newVcodeActivityConfig));
                        return;
                    }
                    WriteActivity.this.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), writeData, 12006)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    WriteActivity.this.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(WriteActivity.this.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a ctP = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void asP() {
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
            if (aVar != null && !StringUtils.isNull(aVar.cpT())) {
                WriteActivity.this.b(2, true, aVar.cpT());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener jhx = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.ctC.rg(false);
                    WriteActivity.this.ctC.ep(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.ctC.rg(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener jSY = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener jSZ = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.crZ.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cBx = WriteActivity.this.cBx();
            if (cBx >= 0 && cBx < WriteActivity.this.iVF.getText().length()) {
                WriteActivity.this.iVF.setSelection(cBx);
            }
        }
    };
    private boolean jTa = true;
    private final View.OnFocusChangeListener iVz = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.iVB || view == WriteActivity.this.cfb || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.jTa = true;
                    WriteActivity.this.cBy();
                    l.c(WriteActivity.this.getActivity(), WriteActivity.this.iVB);
                    if (WriteActivity.this.crZ != null) {
                        WriteActivity.this.crZ.aqu();
                    }
                } else if (view == WriteActivity.this.iVB) {
                    WriteActivity.this.iVG.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.iVF && z) {
                WriteActivity.this.jTa = false;
                WriteActivity.this.cBy();
                l.c(WriteActivity.this.getActivity(), WriteActivity.this.iVF);
                if (WriteActivity.this.crZ != null) {
                    WriteActivity.this.crZ.aqu();
                }
            }
            WriteActivity.this.cBE();
        }
    };
    private TextWatcher jTb = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String jTf = "";
        private String jTg;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jTg = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jTg != null ? this.jTg.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cmo();
            WriteActivity.this.cBF();
            EditText cBQ = WriteActivity.this.cBQ();
            if (editable != null && cBQ != null && cBQ.getText() != null) {
                if (this.jTf == null || !this.jTf.equals(editable.toString())) {
                    if (WriteActivity.this.jSV != null) {
                        this.jTf = cBQ.getText().toString();
                        WriteActivity.this.jSV.o(cBQ);
                        return;
                    }
                    return;
                }
                cBQ.setSelection(cBQ.getSelectionEnd());
            }
        }
    };
    private TextWatcher jTc = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String jTg;
        private String jTh = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jTg = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jTg != null ? this.jTg.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cmo();
            EditText cBP = WriteActivity.this.cBP();
            if (editable != null && cBP != null && cBP.getText() != null) {
                if (this.jTh == null || !this.jTh.equals(editable.toString())) {
                    if (WriteActivity.this.jSV != null) {
                        this.jTh = cBP.getText().toString();
                        WriteActivity.this.jSV.o(cBP);
                        return;
                    }
                    return;
                }
                cBP.setSelection(cBP.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0406a hVO = new a.InterfaceC0406a() { // from class: com.baidu.tieba.write.write.WriteActivity.31
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0406a
        public void onRefresh() {
            WriteActivity.this.hmS = null;
            WriteActivity.this.so(false);
            WriteActivity.this.crZ.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void asA() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void asB() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            asD();
        } else if (this.ctC.cpZ()) {
            asA();
        } else {
            this.ctC.rg(false);
            b(1, true, null);
            this.ctC.cpX();
        }
    }

    public void cBZ() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
            if (this.jST != null) {
                this.jST.cAC();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            asD();
        } else if (this.ctC != null) {
            this.ctC.rg(false);
            b(1, true, null);
            this.ctC.cpX();
        }
    }

    private void asD() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.hu(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kc()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.ctC.aVE();
                } else {
                    WriteActivity.this.ctP.asP();
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
        aVar.agI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cBx() {
        int selectionEnd = cBP().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cBP().getText().getSpans(0, cBP().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cBP().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cBP().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBy() {
        if (this.crZ != null) {
            this.crZ.setBarLauncherEnabled(!this.jTa);
            this.crZ.setBarLauncherEnabled(true, 26);
            this.crZ.setBarLauncherEnabled(true, 2);
            X(9, this.jTa ? false : true);
        }
    }

    private void X(int i, boolean z) {
        com.baidu.tbadk.editortools.g km;
        if (this.crZ != null && (km = this.crZ.km(i)) != null) {
            if (z) {
                km.qk();
            } else {
                km.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.jSP) {
            this.iVB.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.jTz.setVisibility(8);
            } else {
                this.jTz.setVisibility(0);
            }
            a(this.jTC, this.jTw);
            a(this.jTB, this.jTA);
            cmo();
        }
        if (this.jTi) {
            this.jTa = true;
            cBy();
            if (this.crZ != null) {
                this.crZ.aqu();
            }
            this.iVB.requestFocus();
            ShowSoftKeyPadDelay(this.iVB);
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
            cCo();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                cBY();
            }
            sp(true);
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
            Dl(this.jMM);
        }
        initUI();
        cCe();
        this.ctC = new LocationModel(this);
        this.ctC.a(this.ctP);
        registerListener(this.jhx);
        registerListener(this.jSY);
        initEditor();
        cCr();
        if (this.jSP) {
            this.jTv.setEditorTools(this.crZ);
        } else {
            this.iVF.requestFocus();
        }
        ciq();
        cBY();
        cCp();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.crZ = new EditorTools(getActivity());
        this.crZ.setBarMaxLauCount(5);
        this.crZ.setMoreButtonAtEnd(true);
        this.crZ.setBarLauncherType(1);
        this.crZ.fh(true);
        this.crZ.fi(true);
        this.crZ.setMoreLauncherIcon(R.drawable.write_more);
        this.crZ.setBackgroundColorId(R.color.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                cCc();
                break;
            default:
                cBz();
                break;
        }
        this.crZ.arZ();
        if (this.jSx != null) {
            this.jSx.addView(this.crZ);
        }
        cBA();
        this.crZ.qk();
        com.baidu.tbadk.editortools.g km = this.crZ.km(6);
        if (km != null && !TextUtils.isEmpty(this.ctH)) {
            ((View) km).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.ctH);
                }
            });
        }
        if (!this.jSP) {
            this.crZ.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.crZ.aqu();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("xiaoying_has_click", false)) {
            this.crZ.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("hot_topic_has_click", false)) {
            this.crZ.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        cBC();
    }

    private void cCa() {
        this.jTx = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.jTz = this.jTx.findViewById(R.id.live_post_title_container);
        this.jTw = (EditText) this.jTx.findViewById(R.id.live_post_content);
        this.jTu = (GridView) this.jTx.findViewById(R.id.photoLiveGridView);
        this.jTA = (EditText) this.jTx.findViewById(R.id.live_post_title);
        this.jTB = (TextView) this.jTx.findViewById(R.id.titleOverPlusNumber);
        this.jTC = (TextView) this.jTx.findViewById(R.id.contentOverPlusNumber);
        this.jTy = this.jTx.findViewById(R.id.live_interval_view);
        this.jTB.setText(String.valueOf(20));
        this.jTC.setText(String.valueOf(233));
        this.jTx.setVisibility(0);
        this.jTB.setVisibility(0);
        this.jTC.setVisibility(0);
        this.jTA.setHint(R.string.tips_title_limit_new);
        this.jTA.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.jTF = true;
                    WriteActivity.this.jTa = true;
                    WriteActivity.this.cBy();
                    if (WriteActivity.this.crZ != null) {
                        WriteActivity.this.crZ.aqu();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.jTw.setHint(R.string.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.jTw.setHint(R.string.live_write_input_content_update);
        }
        this.jTw.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.jTF = false;
                    WriteActivity.this.jTa = false;
                    WriteActivity.this.cBy();
                    if (WriteActivity.this.crZ != null) {
                        WriteActivity.this.crZ.aqu();
                    }
                }
            }
        });
        this.jTw.requestFocus();
        this.jTw.addTextChangedListener(DY());
        this.jTA.requestFocus();
        this.jTA.addTextChangedListener(DY());
        this.jTA.setOnClickListener(this.jSZ);
        this.jTw.setOnClickListener(this.jSZ);
        this.jTv = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.jTu);
        this.jTv.Df(6);
        this.jTu.setAdapter((ListAdapter) this.jTv);
        View findViewById = this.jTx.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void cBi() {
                WriteActivity.this.cCm();
            }
        });
        cCb();
    }

    private void cCb() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.jTA.setText(this.mData.getTitle());
                this.jTA.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.jSP) {
            cCk();
        }
        if (this.crZ.asb()) {
            this.crZ.aqu();
        }
        Dl(0);
    }

    private void Dl(int i) {
        if (this.writeImagesInfo != null && this.mData != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(12002);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.fTa);
            albumActivityConfig.setProfessionZone(this.mData.getProZone());
            sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void cCc() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.crZ.ai(arrayList);
        com.baidu.tbadk.editortools.k kp = this.crZ.kp(5);
        if (kp != null) {
            kp.csJ = 2;
            kp.csH = R.drawable.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.csH = R.drawable.write_at;
        this.crZ.b(aVar);
        this.crZ.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void cBz() {
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        com.baidu.tbadk.editortools.k kVar3;
        com.baidu.tbadk.editortools.k kVar4;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.k kVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.csH = R.drawable.write_picture;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            this.crZ.b(dVar);
        }
        Boolean cCi = cCi();
        if (!this.jTi && cCi != null && cCi.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.cqA() && p.b(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), com.baidu.tbadk.editortools.k.class)) != null && (kVar5 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar5.csJ = 3;
            kVar5.csH = R.drawable.write_recorder;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.crZ.b(kVar5);
            }
        }
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        aVar.csH = R.drawable.icon_post_topic_selector;
        this.crZ.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001343, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask2 != null && (kVar4 = (com.baidu.tbadk.editortools.k) runTask2.getData()) != null) {
            kVar4.csJ = 5;
            kVar4.csH = R.drawable.write_privilege;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.crZ.b(kVar4);
            }
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask3 != null && (kVar3 = (com.baidu.tbadk.editortools.k) runTask3.getData()) != null) {
            kVar3.csJ = 6;
            kVar3.csH = this.jTi ? R.drawable.write_location : R.drawable.icon_post_more_location;
            this.crZ.b(kVar3);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 7);
        aVar2.csH = R.drawable.icon_post_more_at;
        this.crZ.b(aVar2);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask4 != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
            kVar2.csL = true;
            kVar2.csJ = 9;
            kVar2.csH = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.crZ.b(kVar2);
            }
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask5 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask5.getData()) != null) {
            kVar.csL = true;
            kVar.csJ = 10;
            kVar.csH = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.crZ.b(kVar);
            }
        }
        if (this.jSD == null) {
            if (this.jST == null) {
                this.jST = new com.baidu.tieba.write.editor.b(getActivity(), this.fTa);
                this.jST.bt(this.mData.getForumId(), this.privateThread);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.jST.cAy();
                this.jST.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                cBZ();
            }
            this.crZ.b(this.jST);
        }
        this.crZ.ai(arrayList);
        com.baidu.tbadk.editortools.k kp = this.crZ.kp(5);
        if (kp != null) {
            kp.csJ = 1;
            kp.csH = R.drawable.write_emotion;
        }
    }

    private void cBB() {
        if (this.jSW != null) {
            this.jSW.hideTip();
        }
    }

    private void cBC() {
        if (this.jSW == null) {
            this.jSW = new e(getPageContext());
        }
        this.jSW.c(this.crZ);
    }

    private void cBA() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.cBO()) {
                            WriteActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12004, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new an("c12612").P("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p)) {
                            com.baidu.tbadk.coreExtra.data.p pVar = (com.baidu.tbadk.coreExtra.data.p) aVar.data;
                            if (pVar.amu() == EmotionGroupType.BIG_EMOTION || pVar.amu() == EmotionGroupType.USER_COLLECT) {
                                if (WriteActivity.this.mCurrentPermissionJudgePolicy == null) {
                                    WriteActivity.this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                                }
                                WriteActivity.this.mCurrentPermissionJudgePolicy.ajQ();
                                WriteActivity.this.mCurrentPermissionJudgePolicy.e(WriteActivity.this, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!WriteActivity.this.mCurrentPermissionJudgePolicy.ad(WriteActivity.this)) {
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
                                    WriteActivity.this.sp(true);
                                    WriteActivity.this.cmo();
                                }
                            } else if (WriteActivity.this.cBO()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(pVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.cBR();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bVp();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.cCo();
                        WriteActivity.this.cmo();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.Dm(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new an("c12612").P("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.jSD == null) {
                            WriteActivity.this.asE();
                            return;
                        }
                        switch (WriteActivity.this.ctI) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.cx(pageActivity)) {
                                    WriteActivity.this.asB();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.asA();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.ctC != null) {
                            WriteActivity.this.ctC.rg(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.hmS = null;
                        } else {
                            WriteActivity.this.hmS = (String) aVar.data;
                        }
                        WriteActivity.this.so(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("xiaoying_has_click", true);
                        an anVar = new an("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.bT("fid", str);
                        TiebaStatic.log(anVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.crZ.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.crZ.asb()) {
                                        WriteActivity.this.crZ.aqu();
                                        WriteActivity.this.crZ.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.crZ.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.crZ.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.crZ.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.crZ.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.cmo();
                        if (WriteActivity.this.iVF != null) {
                            WriteActivity.this.iVF.requestFocus();
                        }
                        WriteActivity.this.crZ.aqu();
                        WriteActivity.this.crZ.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iVF);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new an("c12612").P("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.crZ.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.jSv = true;
                        WriteActivity.this.sm(true);
                        if (!WriteActivity.this.cBQ().isFocused() || WriteActivity.this.jSy.getVisibility() != 0) {
                            WriteActivity.this.jSu = "from_content";
                        } else {
                            WriteActivity.this.jSu = "from_title";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.jSy.setVisibility(0);
                        WriteActivity.this.jSy.requestFocus();
                        WriteActivity.this.cmo();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.jSy.hasFocus()) {
                            WriteActivity.this.iVF.requestFocus();
                            WriteActivity.this.iVF.setSelection(WriteActivity.this.iVF.getText().toString().length());
                        }
                        WriteActivity.this.jSy.setVisibility(8);
                        WriteActivity.this.cmo();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.crZ.setActionListener(16, bVar);
        this.crZ.setActionListener(14, bVar);
        this.crZ.setActionListener(24, bVar);
        this.crZ.setActionListener(3, bVar);
        this.crZ.setActionListener(10, bVar);
        this.crZ.setActionListener(11, bVar);
        this.crZ.setActionListener(12, bVar);
        this.crZ.setActionListener(13, bVar);
        this.crZ.setActionListener(15, bVar);
        this.crZ.setActionListener(18, bVar);
        this.crZ.setActionListener(20, bVar);
        this.crZ.setActionListener(25, bVar);
        this.crZ.setActionListener(27, bVar);
        this.crZ.setActionListener(29, bVar);
        this.crZ.setActionListener(43, bVar);
        this.crZ.setActionListener(45, bVar);
        this.crZ.setActionListener(53, bVar);
        this.crZ.setActionListener(48, bVar);
        this.crZ.setActionListener(46, bVar);
        this.crZ.setActionListener(49, bVar);
        this.crZ.setActionListener(47, bVar);
        this.crZ.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dm(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asE() {
        if (this.ctC.aVA()) {
            if (this.ctC.cpZ()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.cpV().getLocationData().cpT());
                return;
            }
            b(1, true, null);
            this.ctC.cpX();
            return;
        }
        b(0, true, null);
    }

    protected void cmg() {
        if (this.ctD != null) {
            this.ctD.cancelLoadData();
        }
        if (this.jSz != null) {
            this.jSz.cancelLoadData();
        }
        if (this.ctC != null) {
            this.ctC.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cBB();
        TiebaPrepareImageService.StopService();
        cmg();
        cCh();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.jTt != null) {
            this.jTt.destroy();
        }
        if (this.jTT != null) {
            this.jTT.bbz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBD() {
        if (this.mData != null && this.mData.getType() == 2 && this.jTp) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.mData.setTitle(cBQ().getText().toString());
            this.mData.setContent(cBP().getText().toString());
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
            if (this.iVH != null && this.iVH.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.iVH, getPageContext().getPageActivity());
                return true;
            } else if (this.crZ.asb()) {
                this.crZ.aqu();
                return true;
            } else {
                cmg();
                cBD();
                return true;
            }
        }
        if (i == 67 && (text = cBP().getText()) != null) {
            int selectionStart = cBP().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cBP().onKeyDown(67, this.fcA);
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
        getLayoutMode().onModeChanged(this.jTK);
        if (this.jTH != null && i == 1) {
            this.jTH.setBorderColor(am.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.f(this.mPost, R.color.cp_link_tip_a, 1);
        cBy();
        am.l(this.jTx, R.color.cp_bg_line_d);
        am.l(this.iVC, R.color.cp_bg_line_c);
        am.l(this.jTy, R.color.cp_bg_line_c);
        am.l(cBQ(), R.color.cp_bg_line_d);
        am.c(this.hPd, (int) R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.hmS)) {
            am.l(cBP(), R.color.cp_bg_line_d);
        }
        cmo();
        this.crZ.onChangeSkinType(i);
        if (this.jSN != null) {
            this.jSN.akL();
        }
        am.j(this.mName, R.color.cp_cont_b);
        cBE();
        cBF();
        if (this.jSV != null) {
            this.jSV.c(cBQ(), cBP());
        }
        this.jQG.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBE() {
        if (this.iVB.hasFocus()) {
            this.iVB.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.iVB.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.iVF.hasFocus()) {
            this.iVF.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.iVF.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBF() {
        if (this.iVB != null && this.iVB.getText() != null && this.iVB.getText().toString() != null && this.iVB.getPaint() != null) {
            if (this.iVB.getText().toString().length() == 0) {
                this.iVB.getPaint().setFakeBoldText(false);
            } else if (this.iVB.getText().toString().length() > 0) {
                this.iVB.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.cCo = new com.baidu.tbadk.core.view.b(getPageContext());
        this.jSP = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.cfb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_topbar_close, R.drawable.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.j(this.mName, R.color.cp_cont_b);
        this.jTn = (TextView) findViewById(R.id.btn_image_problem);
        cBH();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.g(getPageContext().getPageActivity(), R.dimen.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.iVz);
        this.jSO = (ScrollView) findViewById(R.id.write_scrollview);
        this.jSO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.iVF != null) {
                        l.b(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.iVF);
                    }
                    if (WriteActivity.this.crZ != null) {
                        WriteActivity.this.crZ.aqu();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jTl = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.jTm = findViewById(R.id.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(R.id.parent);
        this.jSx = (LinearLayout) findViewById(R.id.tool_view);
        this.jSx.setContentDescription("..");
        this.jSy = (LinearLayout) findViewById(R.id.title_view);
        this.iVC = findViewById(R.id.interval_view);
        this.jTP = findViewById(R.id.hot_topic_fourm_view);
        this.jTQ = findViewById(R.id.hot_topic_divider);
        this.jSR = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.jTR = (TextView) findViewById(R.id.change_one_tv);
        cmn();
        if (this.jSP) {
            this.jSO.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            cCa();
        } else {
            this.jTt = new g(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.jTt.sh(false);
            } else {
                g gVar = this.jTt;
                if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                    z = false;
                }
                gVar.sh(z);
            }
        }
        cmp();
        if (this.jTi || this.jSw) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().bUL) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.iVE = (LinearLayout) findViewById(R.id.post_content_container);
        this.iVE.setDrawingCacheEnabled(false);
        this.iVE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.crZ.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.iVF.requestFocus();
            }
        });
        this.hPa = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.hPb = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.hPd = (ImageView) findViewById(R.id.iv_delete_voice);
        this.hPd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bVp();
            }
        });
        this.cfb.setOnFocusChangeListener(this.iVz);
        this.cfb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cmg();
                WriteActivity.this.cBD();
            }
        });
        this.jTn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        cBK();
        l(cCi());
        cBM();
        cBG();
        cCf();
        cCg();
        cBy();
        cBL();
        cmm();
        cBS();
        if (this.mData.getType() == 4 && this.iVJ != null && this.jSA != null) {
            this.iVJ.setVisibility(8);
            this.jSA.setVisibility(8);
        }
        cmo();
        cCd();
        cAP();
    }

    private void cAP() {
        this.jQG = new com.baidu.tieba.write.b.c(getPageContext().getPageActivity(), this.mName, this.mData.getProZone(), isUseStyleImmersiveSticky() ? StatusBarUtil.getStatusBarOffsetPx(getPageContext().getPageActivity()) : 0);
        this.jQG.a(new c.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // com.baidu.tieba.write.b.c.a
            public void Da(int i) {
                WriteActivity.this.mData.setProZone(i);
            }
        });
        this.jQG.bfT();
    }

    private void cBG() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.jTi || this.jSw) {
                        if (this.jTj) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.fTa != null && this.fTa.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                    } else if (this.fTa != null && this.fTa.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.mData.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.mData.getForumName() + getResources().getString(R.string.bar));
                        this.iVB.setVisibility(8);
                        String str3 = this.fsc + " " + this.fsa;
                        if (!StringUtils.isNull(str3)) {
                            this.iVF.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.iVB.setVisibility(0);
                    this.iVF.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.iVF.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.iVB.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.iVF.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.jTy.setVisibility(8);
                    return;
                case 7:
                    this.iVB.setVisibility(0);
                    this.iVF.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void cBH() {
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

    private void cBI() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.jTi && !this.jSw && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String i = aq.i(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(i) && cBQ() != null) {
                cBQ().setText(i);
                cBQ().setSelection(i.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.hPa.setVisibility(0);
            this.hPb.setVoiceModel(voiceModel);
            this.hPb.cqz();
            cmo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVp() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.aZ(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.hPa.setVisibility(8);
        this.hPb.bwl();
        this.hPb.setVoiceModel(null);
        com.baidu.tbadk.editortools.k kp = this.crZ.kp(6);
        if (kp != null && kp.crT != null) {
            kp.crT.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cmo();
    }

    private void cBJ() {
        this.jSI = null;
        this.jSK = -1;
        this.jSM = -1;
        com.baidu.tieba.frs.x rK = w.bnD().rK(1);
        if (rK != null) {
            this.jSI = rK.fxC;
            this.jSK = getIntent().getIntExtra("category_id", -1);
            if (this.jSI != null && !this.jSI.isEmpty() && this.jSK >= 0) {
                this.jSJ = new v();
                this.jSJ.fxy = 0;
                this.jSJ.name = getPageContext().getResources().getString(R.string.category_auto);
                this.jSM = this.jSJ.fxy;
                this.jSL = this.jSJ.name;
                for (v vVar : this.jSI) {
                    if (vVar.fxy == this.jSK) {
                        this.jSM = vVar.fxy;
                        this.jSL = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cBK() {
        if (this.jSI != null && !this.jSI.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.jSN = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.jSN.setText(this.jSL);
            this.jSN.setCategoryContainerData(this.jSI, this.jSJ, this.jSM);
            this.jSN.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ar arVar) {
                    if (arVar != null) {
                        WriteActivity.this.jSN.setText(arVar.name);
                        WriteActivity.this.mData.setCategoryTo(arVar.fxy);
                        WriteActivity.this.jSM = arVar.fxy;
                        WriteActivity.this.jSN.cBl();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.jSN.cBk();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cBQ());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cBP());
                }
            });
        }
    }

    private void cCd() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.jTd = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.jTd.setTitle(R.string.no_disturb_start_time);
        this.jTd.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.jTd);
        this.jTd.setButton(-2, getPageContext().getString(R.string.cancel), this.jTd);
        return this.jTd;
    }

    private void cBL() {
        this.jSE = (RelativeLayout) findViewById(R.id.addition_container);
        this.jSF = (TextView) findViewById(R.id.addition_create_time);
        this.jSG = (TextView) findViewById(R.id.addition_last_time);
        this.jSH = (TextView) findViewById(R.id.addition_last_content);
        if (this.jSD != null) {
            this.jSE.setVisibility(0);
            this.jSF.setText(getPageContext().getString(R.string.write_addition_create) + aq.aD(this.jSD.getCreateTime() * 1000));
            if (this.jSD.getAlreadyCount() == 0) {
                this.jSG.setVisibility(8);
            } else {
                this.jSG.setText(getPageContext().getString(R.string.write_addition_last) + aq.aD(this.jSD.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.jSD.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.jSH.setText(lastAdditionContent);
            } else {
                this.jSH.setVisibility(8);
            }
            cBP().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.jSD.getAlreadyCount()), Integer.valueOf(this.jSD.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.jSE.setVisibility(8);
    }

    private void cmm() {
        this.iVJ = findViewById(R.id.post_prefix_layout);
        if (this.jTT == null) {
            this.jTT = new com.baidu.tieba.c.d(getPageContext(), this.iVJ);
            this.jTT.qb(R.drawable.bg_tip_blue_up_left);
            this.jTT.qa(16);
            this.jTT.iR(true);
            this.jTT.S(true);
            this.jTT.qe(l.g(getActivity(), R.dimen.ds32));
        }
        this.iVG = (TextView) findViewById(R.id.post_prefix);
        this.jSA = findViewById(R.id.prefix_divider);
        this.iVI = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.iVJ.setVisibility(0);
            this.jTT.u(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iVj = 0;
            this.iVJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").bT("fid", WriteActivity.this.mData.getForumId()).l("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.iVG.setVisibility(0);
                    WriteActivity.this.iVJ.setSelected(true);
                    am.c(WriteActivity.this.iVI, (int) R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.iVH, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.crZ.aqu();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iVB);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iVF);
                }
            });
            this.iVG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").bT("fid", WriteActivity.this.mData.getForumId()).l("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.iVG.setSelected(true);
                    am.c(WriteActivity.this.iVI, (int) R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.iVH, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.crZ.aqu();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cBQ());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cBP());
                }
            });
            this.iVH = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.iVH.a(this);
            this.iVH.setMaxHeight(l.g(getActivity(), R.dimen.ds510));
            this.iVH.setOutsideTouchable(true);
            this.iVH.setFocusable(true);
            this.iVH.setOnDismissListener(this);
            this.iVH.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            am.getColor(R.color.cp_cont_c);
            am.k(this.iVG, R.color.cp_bg_line_d);
            am.c(this.iVI, (int) R.drawable.icon_arrow_gray_down);
            this.iVG.setTextColor(color);
            this.jSB.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.jSB.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.sc(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.sc(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.iVH.addView(writePrefixItemLayout);
            }
            this.iVH.setCurrentIndex(0);
            this.iVG.setText(prefixs.get(0));
            Dk(0);
            return;
        }
        this.iVJ.setVisibility(8);
    }

    private void cCe() {
        if (this.jTi && this.mData != null) {
            this.jTl.setVisibility(0);
            this.jTm.setVisibility(0);
            this.jSz = new FeedBackModel(getPageContext());
            this.jSz.GV(this.mData.getForumName());
            this.jSz.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.24
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.jTl.setVisibility(8);
                        WriteActivity.this.jTm.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.jTl.setVisibility(8);
                        WriteActivity.this.jTm.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.jTl.a(feedBackModel.cBn(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void cBM() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.kc()) {
                    WriteActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (WriteActivity.this.jSV.a(WriteActivity.this.iVB, WriteActivity.this.iVF)) {
                        WriteActivity.this.showToast(WriteActivity.this.jSV.czi());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cBQ());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cBP());
                    WriteActivity.this.crZ.aqu();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.jTi) {
                            WriteActivity.this.cBV();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            an anVar = new an("c12102");
                            anVar.P("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(anVar);
                            WriteActivity.this.cBW();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.cBV();
                    }
                    TiebaStatic.log(new an("c12262").bT("obj_locate", WriteActivity.this.fTa));
                }
            }
        });
    }

    protected void cCf() {
        this.jTo = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.jTo.mO(getPageContext().getString(R.string.is_save_draft)).dQ(false).a(getPageContext().getString(R.string.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.cBQ().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.cBP().getText().toString());
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
        this.jTo.b(getPageContext());
    }

    protected void cmn() {
        this.jTk = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.jTk.setIsRound(true);
        this.jTk.setDrawBorder(false);
        this.jTk.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String nM = o.nM(currentPortrait);
            this.jTk.setUrl(nM);
            this.jTk.startLoad(nM, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.jTk.setVisibility(0);
        }
        this.iVB = (EditText) findViewById(R.id.post_title);
        this.iVB.setOnClickListener(this.jSZ);
        this.iVB.setOnFocusChangeListener(this.iVz);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.iVB.setText(this.mData.getTitle());
                this.iVB.setSelection(this.mData.getTitle().length());
            } else if (this.jTj) {
                this.iVB.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.iVB.addTextChangedListener(this.jTb);
        if (!this.mData.getHaveDraft()) {
            cBI();
            this.jTO = true;
        }
        if (this.mData.isUserFeedback()) {
            this.iVB.setHint(getResources().getString(R.string.feedback_title_hint));
        } else {
            this.iVB.setHint(getResources().getString(R.string.post_title_hint));
        }
    }

    private TextWatcher DY() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            private int jTX;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.cmo();
                if (WriteActivity.this.jSP) {
                    this.jTX = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.jTX);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.jSP || !WriteActivity.this.jTF) {
                    if (WriteActivity.this.jSP) {
                        if (this.mEditText != WriteActivity.this.jTw || this.mTextView != WriteActivity.this.jTC) {
                            this.mEditText = WriteActivity.this.jTw;
                            this.mTextView = WriteActivity.this.jTC;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.jTA || this.mTextView != WriteActivity.this.jTB) {
                    this.mEditText = WriteActivity.this.jTA;
                    this.mTextView = WriteActivity.this.jTB;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.jSP && this.jTF) {
            if (this.jTD != null) {
                this.jTA.removeTextChangedListener(this.jTD);
            }
            this.jTD = textWatcher;
        } else if (this.jSP) {
            if (this.jTE != null) {
                this.jTw.removeTextChangedListener(this.jTE);
            }
            this.jTE = textWatcher;
        }
        return textWatcher;
    }

    private long p(EditText editText) {
        if (editText == this.jTw) {
            return 233L;
        }
        if (editText != this.jTA) {
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
                    textView.setTextColor(am.getColor(R.color.common_color_10159));
                } else {
                    textView.setTextColor(am.getColor(R.color.cp_cont_d));
                }
            } else if (q < 0) {
                if (q < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(am.getColor(R.color.common_color_10159));
            } else {
                textView.setTextColor(am.getColor(R.color.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long q(EditText editText) {
        return com.baidu.tieba.write.c.a.m(editText.getText().toString().trim());
    }

    protected void cmp() {
        this.iVF = (EditText) findViewById(R.id.post_content);
        this.iVF.setDrawingCacheEnabled(false);
        this.iVF.setOnClickListener(this.jSZ);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString ak = TbFaceManager.atv().ak(getPageContext().getPageActivity(), this.mData.getContent());
            this.iVF.setText(ak);
            this.iVF.setSelection(ak.length());
        } else if (this.mData.getType() == 2) {
            if (this.jTp) {
                if (this.jTq != null && this.jTq.length() > 0) {
                    this.iVF.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.jTq}));
                    this.iVF.setSelection(this.iVF.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.iVF.setText(format);
                this.iVF.setSelection(format.length());
            }
        }
        this.iVF.setOnFocusChangeListener(this.iVz);
        this.iVF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.crZ.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.iVF.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iVF.addTextChangedListener(this.jTc);
        if (this.mData.getType() == 0) {
            this.jTS = true;
        } else {
            so(true);
            this.jTS = false;
        }
        if (this.mData.isUserFeedback()) {
            this.iVF.setHint(R.string.write_input_content);
        } else {
            this.iVF.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void so(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.jSP) {
            cBP().setPadding(0, 0, 0, 0);
            cBP().setBackgroundDrawable(null);
            am.l(cBP(), R.color.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.hmS) && this.jSD == null) {
                com.baidu.adp.lib.f.c.iE().a(this.hmS, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.30
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass30) aVar, str, i);
                        if (aVar != null && aVar.nK() != null && aVar.nO() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.nK(), aVar.nK().getNinePatchChunk(), aVar.nO(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.cBP().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.cBP(), true, WriteActivity.this.hVO);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cBO() {
        int i = UIMsg.m_AppUI.MSG_APP_GPS;
        if (this.jSD != null) {
            i = 1000;
        }
        return cBP().getText() != null && cBP().getText().length() >= i;
    }

    private void ql(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.jSu)) {
                this.jSu = "";
                cBP().requestFocus();
                if (cBP().getText() != null && cBP().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cBP().getSelectionStart();
                    editable = cBP().getText();
                }
            } else if ("from_title".equals(this.jSu)) {
                this.jSu = "";
                cBQ().requestFocus();
                if (cBQ().getText() != null && cBQ().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cBQ().getSelectionStart();
                    editable = cBQ().getText();
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
    public void sm(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void e(com.baidu.tbadk.coreExtra.data.p pVar) {
        if (((ImageSpan[]) cBP().getText().getSpans(0, cBP().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.jSC == null) {
                this.jSC = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            this.jSC.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType amu = pVar.amu();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.iE().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.32
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass32) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.cBP().getSelectionStart(), aVar, amu);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cBP() != null && cBP().getText() != null) {
            Bitmap nK = aVar.nK();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(nK);
            int width = nK.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, nK.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.g(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = cBP().getSelectionStart() - 1;
                if (cBP().getText().length() > 1 && selectionStart >= 0 && cBP().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cBP().getText().insert(cBP().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cBP().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cBP().getText().insert(cBP().getSelectionStart(), spannableString2);
            }
            Editable text = cBP().getText();
            if (text != null) {
                this.jSS.clear();
                this.jSS.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jSS);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cBP().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cBP().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cBP().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cBP() {
        return this.jSP ? this.jTw : this.iVF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cBQ() {
        return this.jSP ? this.jTA : this.iVB;
    }

    protected void cBR() {
        Editable text;
        if (cBP() != null && (text = cBP().getText()) != null) {
            int selectionStart = cBP().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cBP().onKeyDown(67, this.fcA);
            }
            cBP().onKeyDown(67, this.fcA);
            int selectionStart2 = cBP().getSelectionStart();
            if (text != null) {
                this.jSS.clear();
                this.jSS.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jSS);
                cBP().setSelection(selectionStart2);
            }
        }
    }

    private void l(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.jTi = true;
        }
    }

    private void cCg() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void cCh() {
        try {
            if (this.jTo != null) {
                this.jTo.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.cCo.e(null);
        this.cCo.iz(R.string.sending);
        this.cCo.ej(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.cCo.ej(false);
    }

    private Boolean cCi() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.ctH = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void cmo() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (cBQ() != null) {
                str = cBQ().getText().toString();
            }
            if (cBP() != null) {
                str2 = cBP().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.iVj == com.baidu.tbadk.core.util.v.Z(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.jSy.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            sn(true);
                            return;
                        }
                    } else if (this.jSy.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        sn(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.jSy.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    sn(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.jSP) {
                    sn(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    sn(true);
                }
            }
            if (this.mData.getType() == 4) {
                sn(s(this.jTw) && r(this.jTA));
            } else if (this.mData.getType() == 5) {
                sn(s(this.jTw));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                sn(true);
            } else if (this.mData.getVideoInfo() != null) {
                sn(true);
            } else {
                sn(false);
            }
        }
    }

    public void sn(boolean z) {
        if (z) {
            am.e(this.mPost, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        am.f(this.mPost, R.color.cp_cont_d, 1);
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
        this.ctD = new NewWriteModel(this);
        this.ctD.b(this.ctR);
        registerListener(this.jTU);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.cmg();
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
            this.jTi = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.jTj = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.jTp = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.jTq = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.ctB = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.jSD = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.jSD != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.jTr = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.mData.setTopicId(this.mTopicId);
            this.fTa = bundle.getString("KEY_CALL_FROM");
            this.jMM = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
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
            this.jTi = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.jTj = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.jTp = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.jTq = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.jSD = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.jSD != null);
            this.mData.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.jTr = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.fsb = intent.getStringExtra("more_forum_img");
            this.fsc = intent.getStringExtra("more_forum_title");
            this.fsa = intent.getStringExtra("more_forum_url");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.mData.setTopicId(this.mTopicId);
            this.fTa = intent.getStringExtra("KEY_CALL_FROM");
            this.jMM = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.jTi);
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
        this.hmS = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.jSw = true;
        }
        cBJ();
        try {
            this.jTG = cCq();
        } catch (Throwable th) {
            this.jTG = null;
        }
    }

    private void cBS() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.iVB.setText(com.baidu.tbadk.plugins.b.qW(com.baidu.tbadk.plugins.b.qX(hotTopicBussinessData.mTopicName)));
            this.iVB.setMovementMethod(com.baidu.tieba.view.c.cxR());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString qW = com.baidu.tbadk.plugins.b.qW(com.baidu.tbadk.plugins.b.qX(hotTopicBussinessData.mTopicName));
            if (qW != null) {
                this.iVB.setText(qW);
            }
            this.jSR.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t.a
    public void a(WriteData writeData) {
        String str;
        String qX;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            if (writeData != null) {
                if (this.mData != null) {
                    this.mData.setHaveDraft(true);
                    if (com.baidu.adp.lib.util.k.isEmpty(cBQ().getText().toString()) || this.jTO || ((this.jTi || this.jSw) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
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
                                qX = this.mData.getTitle();
                            } else {
                                qX = com.baidu.tbadk.plugins.b.qX(str);
                            }
                            SpannableString qW = com.baidu.tbadk.plugins.b.qW(qX);
                            if (qW != null) {
                                cBQ().setText(qW);
                                cBQ().setSelection(qW.length() > qX.length() ? qX.length() : qW.length());
                            }
                        } else {
                            SpannableString qW2 = com.baidu.tbadk.plugins.b.qW(this.mData.getTitle());
                            if (qW2 != null) {
                                cBQ().setText(qW2);
                                cBQ().setSelection(this.mData.getTitle().length() > qW2.length() ? qW2.length() : this.mData.getTitle().length());
                            }
                        }
                    }
                    if (this.mData != null && !this.mData.getHaveDraft()) {
                        cBI();
                    }
                    if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.copy(writeData.getVideoInfo());
                        this.mData.setVideoInfo(videoInfo);
                        this.crZ.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                    }
                    if ((com.baidu.adp.lib.util.k.isEmpty(cBP().getText().toString()) || this.jTi || this.jSw) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                        this.mData.setContent(writeData.getContent());
                        SpannableString a2 = TbFaceManager.atv().a(getPageContext().getPageActivity(), this.mData.getContent(), this.jSX);
                        cBP().setText(a2);
                        cBP().setSelection(a2.length());
                        if (this.jSP) {
                            a(this.jTC, this.jTw);
                        }
                    }
                    if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                        this.writeImagesInfo = writeData.getWriteImagesInfo();
                        this.mData.setWriteImagesInfo(this.writeImagesInfo);
                        cCo();
                        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                            cBY();
                        }
                        sp(false);
                    }
                    if (writeData.getType() == 4 || writeData.getType() == 5) {
                        cCj();
                    }
                    cmo();
                    int categoryTo = writeData.getCategoryTo();
                    if (categoryTo >= 0 && this.jSI != null) {
                        this.jSM = this.jSJ.fxy;
                        this.jSL = this.jSJ.name;
                        int i = 0;
                        while (true) {
                            if (i == this.jSI.size()) {
                                break;
                            }
                            v vVar = this.jSI.get(i);
                            if (categoryTo != vVar.fxy) {
                                i++;
                            } else {
                                this.jSM = categoryTo;
                                this.jSL = vVar.name;
                                this.mData.setCategoryTo(this.jSM);
                                break;
                            }
                        }
                        if (this.jSN != null) {
                            this.jSN.setText(this.jSL);
                            this.jSN.setCategoryContainerData(this.jSI, this.jSJ, this.jSM);
                        }
                    }
                    this.crZ.aqu();
                    return;
                }
                return;
            }
            cCj();
            cBI();
        }
    }

    private void cCj() {
        if ((!this.jSP || this.jTv != null) && this.jTu != null) {
            this.jTv.c(this.writeImagesInfo);
            cCm();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.jTp);
        if (this.jTi) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.ctB);
        if (this.jSD != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.jSD));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.jTr);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.fTa);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.jMM);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cBP().getEditableText().toString();
        if (obj != null) {
            cBP().setText(TbFaceManager.atv().a(getPageContext().getPageActivity(), obj, this.jSX));
            cBP().setSelection(cBP().getText().length());
        }
    }

    private String cBT() {
        return (cBP() == null || cBP().getText() == null) ? "" : cBP().getText().toString();
    }

    private String cBU() {
        if (this.mData == null || cBQ() == null || cBQ().getVisibility() != 0 || cBQ().getText() == null) {
            return "";
        }
        String obj = cBQ().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.Z(this.mPrefixData.getPrefixs()) > 0 && this.iVj != com.baidu.tbadk.core.util.v.Z(this.mPrefixData.getPrefixs()) - 1 && this.mData.getType() != 4 && this.iVG != null && this.iVG.getText() != null) {
            this.mData.setPostPrefix(this.iVG.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void GW(String str) {
        if (this.mData != null && this.jSy != null) {
            if (this.jSy.getVisibility() == 0) {
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
    public void cBV() {
        cmg();
        this.mData.setContent(cBT());
        GW(cBU());
        if (this.jTi || this.jSw) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                GW(string + this.mData.getTitle());
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
                if (com.baidu.adp.lib.util.j.kc()) {
                    sb.append(com.baidu.adp.lib.util.j.kj());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.jSK >= 0) {
            this.mData.setCategoryFrom(this.jSK);
        }
        if (this.jSM >= 0) {
            this.mData.setCategoryTo(this.jSM);
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
        this.mData.setHasLocationData(this.ctC != null && this.ctC.aVA());
        if (this.writeImagesInfo != null) {
            this.ctD.ri(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.mList) && this.jSQ != null && this.jSQ.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.jSQ.mForumId));
            this.mData.setForumName(this.jSQ.mForumName);
        }
        this.ctD.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.ctD.getWriteData().setVoice(this.mVoiceModel.getId());
                this.ctD.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.ctD.getWriteData().setVoice(null);
                this.ctD.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.ctD.getWriteData().setVoice(null);
            this.ctD.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.ctD.cqB()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.kc()) {
            showToast(R.string.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.mDialogCancelListener);
            this.ctD.startPostWrite();
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
            if (this.jSD != null) {
                i2 = this.jSD.getTotalCount();
                i = this.jSD.getAlreadyCount() + 1;
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
                if (this.iVB == getCurrentFocus()) {
                    cBP().clearFocus();
                    this.iVB.requestFocus();
                    if (this.crZ != null) {
                        this.crZ.aqu();
                    }
                    ShowSoftKeyPadDelay(this.iVB);
                } else {
                    cBP().requestFocus();
                    if (this.crZ != null) {
                        this.crZ.aqu();
                    }
                    ShowSoftKeyPadDelay(this.iVF);
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
                            cBP().getText().insert(cBP().getSelectionStart(), sb.toString());
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
                                cCn();
                            } else {
                                aE(intent);
                            }
                        } else if (intExtra == 1) {
                            aF(intent);
                        } else {
                            aC(intent);
                            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.jTS) {
                            so(true);
                            this.jTS = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.jSP) {
                        P(intent);
                        cmo();
                        return;
                    }
                    aD(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.crZ.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.crZ.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.crZ.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    cmo();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.jSv) {
                                sb2.append(com.baidu.tbadk.plugins.b.cBI);
                                this.jSv = false;
                            }
                            sb2.append(stringExtra);
                            ql(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.aa(this.mList) && !com.baidu.tbadk.core.util.v.aa(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.jSQ = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.jSQ);
                }
            }
        } else if (i2 == 0) {
            if (this.crZ != null && !this.crZ.asb()) {
                this.iVF.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.crZ.aqu();
            }
            switch (i) {
                case SapiGIDEvent.TIME_FREQ /* 12001 */:
                    asH();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    cCl();
                    if (this.jTS) {
                        so(true);
                        this.jTS = false;
                        return;
                    }
                    return;
                case 12004:
                    if (this.iVB == getCurrentFocus()) {
                        cBP().clearFocus();
                        this.iVB.requestFocus();
                        if (this.crZ != null) {
                            this.crZ.aqu();
                        }
                        ShowSoftKeyPadDelay(this.iVB);
                        return;
                    }
                    cBP().requestFocus();
                    if (this.crZ != null) {
                        this.crZ.aqu();
                    }
                    ShowSoftKeyPadDelay(this.iVF);
                    return;
                case 12006:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.jSV.GA(postWriteCallBackData.getErrorString());
                        this.jSV.aI(postWriteCallBackData.getSensitiveWords());
                        this.jSV.b(this.iVB, this.iVF);
                        return;
                    }
                    return;
                case 12009:
                default:
                    return;
                case 12010:
                    this.ctB = String.valueOf(System.currentTimeMillis());
                    al.a(getPageContext(), this.ctB);
                    return;
                case 12012:
                    cCl();
                    return;
                case 25004:
                    if ("from_title".equals(this.jSu)) {
                        cBQ().requestFocus();
                        return;
                    } else if ("from_content".equals(this.jSu)) {
                        cBP().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBW() {
        if ("1".equals(this.fTa)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.fTa)) {
            this.mData.setCanNoForum(false);
        }
        cBX();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.fTa);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cBV();
    }

    private void cBX() {
        if (this.crZ != null) {
            this.crZ.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void cCk() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void cCl() {
        if (this.jSP) {
            this.jTv.c(this.writeImagesInfo);
            cCm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCm() {
        this.jTv.notifyDataSetChanged();
        this.jTu.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.jTv.notifyDataSetChanged();
                WriteActivity.this.jTu.invalidateViews();
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
        cmo();
    }

    private void aC(Intent intent) {
        if (this.jSP) {
            aD(intent);
            cCl();
        } else {
            aG(intent);
        }
        cmo();
    }

    private void aD(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            cCl();
            sp(true);
        }
    }

    private void aE(Intent intent) {
        if (this.writeImagesInfo != null) {
            O(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
            }
        }
    }

    private void cCn() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) SapiGIDEvent.TIME_FREQ, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void aF(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.jTs.parseJson(stringExtra);
            this.jTs.updateQuality();
            if (this.jTs.getChosedFiles() != null && this.jTs.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.jTs.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.jTs.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cBQ());
        HidenSoftKeyPad(this.mInputManager, cBP());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void aG(Intent intent) {
        c(intent, true);
    }

    private void O(Intent intent) {
        this.ctB = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.ctB;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.af(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.ah(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a(TbConfig.LOCAL_CAMERA_DIR, this.ctB, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            cCo();
            cBY();
        }
        sp(true);
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
                cCo();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    cBY();
                }
            }
            sp(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCo() {
        if (this.crZ.kp(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void asH() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.ctB));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void cCp() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.fsb)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mCurrentPermissionJudgePolicy.ajQ();
            this.mCurrentPermissionJudgePolicy.e(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.ad(this)) {
                n nVar = new n(this, this.fsb, new n.a() { // from class: com.baidu.tieba.write.write.WriteActivity.38
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
                            WriteActivity.this.sp(true);
                        }
                    }
                });
                nVar.setFrom(1);
                nVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sp(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.jTt != null) {
            this.jTt.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.ftO == null) {
            this.ftO = VoiceManager.instance();
        }
        return this.ftO;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bmj() {
        this.ftO = getVoiceManager();
        this.ftO.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.fvc) != null) {
                    TiebaStatic.log(new an("c12534").P("obj_locate", au.a.bUb));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.jSD == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                A(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.ctI = i;
        if (this.crZ != null) {
            this.crZ.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void cBY() {
        if (!this.jSP) {
            if (this.crZ != null) {
                this.crZ.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.crZ.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.jTt != null) {
                this.jTt.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp(boolean z) {
        if (this.crZ != null) {
            this.crZ.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Dk(int i) {
        if (i < this.jSB.size()) {
            for (int i2 = 0; i2 < this.jSB.size(); i2++) {
                this.jSB.get(i2).sd(false);
            }
            this.jSB.get(i).sd(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void AJ(int i) {
        if (i == com.baidu.tbadk.core.util.v.Z(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new an("c13014").P("obj_type", 1));
        } else {
            TiebaStatic.log(new an("c13014").P("obj_type", 2));
        }
        this.iVj = i;
        this.iVH.setCurrentIndex(i);
        Dk(i);
        this.iVG.setText(this.mPrefixData.getPrefixs().get(i));
        cmo();
        com.baidu.adp.lib.g.g.a(this.iVH, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.iVJ.setSelected(false);
        am.c(this.iVI, (int) R.drawable.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.iVF);
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
            asB();
        } else if (i == 1) {
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (ab.cy(getApplicationContext())) {
                al.a(getPageContext(), this.ctB);
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
        this.jSU = z;
        if (this.jTM && System.currentTimeMillis() - this.jTN < 800) {
            l.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.jTM = false;
        }
        if (this.jST != null && !z) {
            this.jST.bgg();
        }
        if (this.jSW != null && !z) {
            cBB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GX(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.jTJ != null) {
            GY(str);
            this.jTJ.dismiss();
        }
    }

    private void ev(Context context) {
        jTL = l.ah(context);
    }

    private void GY(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.jTM = true;
        cCo();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            cBY();
        }
        sp(true);
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

    private File cCq() {
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

    private void cCr() {
        if (this.jTG != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            ev(getActivity());
            this.jTI = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.jTI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.jTG != null) {
                        WriteActivity.this.GX(WriteActivity.this.jTG.getAbsolutePath());
                    }
                }
            });
            this.jTH = (TbImageView) this.jTI.findViewById(R.id.rec_img_view);
            this.jTK = (LinearLayout) this.jTI.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.ahO().getString("write_rec_pic_path", "").equalsIgnoreCase(this.jTG.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.ahO().putString("write_rec_pic_path", this.jTG.getAbsolutePath());
                Bitmap f = f(this.jTG.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (f != null) {
                    this.jTH.setImageBitmap(f);
                    this.jTH.setDrawBorder(true);
                    this.jTH.setBorderWidth(2);
                    this.jTH.setBorderColor(am.getColor(R.color.common_color_10264));
                    this.jTJ = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.jTJ.setCanceledOnTouchOutside(true);
                    this.jTJ.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.jTM) {
                                l.b(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.jTN = System.currentTimeMillis();
                            }
                        }
                    });
                    this.jTJ.setContentView(this.jTI);
                    this.jTJ.show();
                    Window window = this.jTJ.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (jTL / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.jSU && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.jSv = false;
            this.jSu = "";
            if ("from_content".equals(str)) {
                this.jSu = "from_content";
            } else if ("from_title".equals(str)) {
                this.jSu = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.qV(String.valueOf(charSequence.charAt(i)))) {
                sm(false);
            }
        }
    }

    public void ciq() {
        if (this.jTi || !com.baidu.tbadk.core.util.v.aa(this.mList) || !StringUtils.isNull(this.mData.getTitle())) {
            this.jSy.setVisibility(0);
            this.jSy.requestFocus();
            this.crZ.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.jSy.setVisibility(8);
    }
}
