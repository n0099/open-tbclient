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
import com.baidu.tbadk.coreExtra.data.p;
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
import com.baidu.tieba.frs.w;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0041a, VoiceManager.c, v.a, h.a {
    private static int jUR = 0;
    private EditorTools csg;
    private String ctI;
    private LocationModel ctJ;
    private NewWriteModel ctK;
    private String fsA;
    private String fsB;
    private String fsz;
    private VoiceManager fun;
    private LinearLayout hPV;
    private PlayVoiceBntNew hPW;
    private ImageView hPY;
    private TextView iWK;
    private com.baidu.tieba.write.h iWL;
    private ImageView iWM;
    private View iWN;
    private int iWn;
    private boolean isPrivacy;
    private com.baidu.tieba.write.b.c jRM;
    private LinearLayout jTD;
    private LinearLayout jTE;
    private View jTG;
    private Toast jTI;
    private AdditionData jTJ;
    private RelativeLayout jTK;
    private TextView jTL;
    private TextView jTM;
    private TextView jTN;
    List<com.baidu.tieba.frs.v> jTO;
    com.baidu.tieba.frs.v jTP;
    private int jTQ;
    private String jTR;
    private int jTS;
    private PostCategoryView jTT;
    private HotTopicBussinessData jTW;
    private TextView jTX;
    private com.baidu.tieba.write.editor.b jTZ;
    private View jUV;
    private View jUW;
    private TextView jUX;
    private com.baidu.tieba.c.d jUZ;
    private e jUc;
    private com.baidu.tieba.view.b jUj;
    private View jUs;
    private g jUz;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String jTA = "";
    private boolean jTB = false;
    private WriteData mData = null;
    private boolean jUo = false;
    private boolean jTC = false;
    private boolean jUp = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText iWF = null;
    private HeadImageView jUq = null;
    private View iWG = null;
    private LinearLayout iWI = null;
    private EditText iWJ = null;
    private FeedBackModel jTF = null;
    private FeedBackTopListView jUr = null;
    private ArrayList<WritePrefixItemLayout> jTH = new ArrayList<>();
    private String hnK = null;
    private final KeyEvent fda = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View cfi = null;
    private TextView jUt = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a jUu = null;
    private final Handler mHandler = new Handler();
    private boolean jUv = false;
    private String jUw = null;
    private RelativeLayout mParent = null;
    private String ctO = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int ctP = 0;
    private int jUx = 0;
    private WriteImagesInfo jUy = new WriteImagesInfo();
    private View mRootView = null;
    private GridView jUA = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a jUB = null;
    private ScrollView jTU = null;
    private EditText jUC = null;
    private View jUD = null;
    private View jUE = null;
    private View jUF = null;
    private EditText jUG = null;
    private TextView jUH = null;
    private TextView jUI = null;
    private TextWatcher jUJ = null;
    private TextWatcher jUK = null;
    private boolean jTV = false;
    private boolean jUL = false;
    private com.baidu.tbadk.core.view.b cCv = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private File jUM = null;
    private TbImageView jUN = null;
    private View jUO = null;
    private Dialog jUP = null;
    private LinearLayout jUQ = null;
    private boolean jUS = false;
    private long jUT = -1000;
    private boolean jUU = false;
    private String fTQ = "2";
    private int jNT = 0;
    private String mTopicId = "";
    private SpannableStringBuilder jTY = new SpannableStringBuilder();
    private boolean jUY = false;
    private boolean jUa = false;
    private final b jUb = new b();
    private final HttpMessageListener jVa = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.hnK)) {
                    WriteActivity.this.hnK = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.sp(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.hnK)) {
                    WriteActivity.this.hnK = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.hnK);
                    WriteActivity.this.sp(true);
                }
            }
        }
    };
    private TbFaceManager.a jUd = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
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
    private final AntiHelper.a fvB = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").P("obj_locate", au.a.bUh));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").P("obj_locate", au.a.bUh));
        }
    };
    private final NewWriteModel.d ctY = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.bmt();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.jUb.aI(null);
                if (z) {
                    WriteActivity.this.fp(z);
                    if (WriteActivity.this.d(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    if (WriteActivity.this.mData.getType() != 0 && WriteActivity.this.mData.getType() != 9) {
                        if (WriteActivity.this.mData.getType() != 7) {
                            if (WriteActivity.this.mData.getType() == 1) {
                                v.d(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.mData.getType() == 5) {
                                v.d(WriteActivity.this.mData.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            v.c("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            v.c(WriteActivity.this.mData.getForumId(), (WriteData) null);
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
                    WriteActivity.this.jUb.aI(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.jUb.GB(postWriteCallBackData.getErrorString());
                    WriteActivity.this.jUb.b(WriteActivity.this.iWF, WriteActivity.this.iWJ);
                } else if ((xVar == null || writeData == null || xVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (xVar != null && writeData != null && xVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.amH());
                    if (com.baidu.tbadk.v.a.ru(xVar.amG())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, xVar.amG());
                        if (WriteActivity.this.jUp) {
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
    private final LocationModel.a ctW = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void asR() {
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
            if (aVar != null && !StringUtils.isNull(aVar.cqp())) {
                WriteActivity.this.b(2, true, aVar.cqp());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener jiF = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.ctJ.rh(false);
                    WriteActivity.this.ctJ.ep(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.ctJ.rh(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener jUe = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener jUf = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.csg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cBS = WriteActivity.this.cBS();
            if (cBS >= 0 && cBS < WriteActivity.this.iWJ.getText().length()) {
                WriteActivity.this.iWJ.setSelection(cBS);
            }
        }
    };
    private boolean jUg = true;
    private final View.OnFocusChangeListener iWD = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.iWF || view == WriteActivity.this.cfi || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.jUg = true;
                    WriteActivity.this.cBT();
                    l.c(WriteActivity.this.getActivity(), WriteActivity.this.iWF);
                    if (WriteActivity.this.csg != null) {
                        WriteActivity.this.csg.aqw();
                    }
                } else if (view == WriteActivity.this.iWF) {
                    WriteActivity.this.iWK.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.iWJ && z) {
                WriteActivity.this.jUg = false;
                WriteActivity.this.cBT();
                l.c(WriteActivity.this.getActivity(), WriteActivity.this.iWJ);
                if (WriteActivity.this.csg != null) {
                    WriteActivity.this.csg.aqw();
                }
            }
            WriteActivity.this.cBZ();
        }
    };
    private TextWatcher jUh = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String jUl = "";
        private String jUm;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jUm = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jUm != null ? this.jUm.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cmG();
            WriteActivity.this.cCa();
            EditText cCl = WriteActivity.this.cCl();
            if (editable != null && cCl != null && cCl.getText() != null) {
                if (this.jUl == null || !this.jUl.equals(editable.toString())) {
                    if (WriteActivity.this.jUb != null) {
                        this.jUl = cCl.getText().toString();
                        WriteActivity.this.jUb.o(cCl);
                        return;
                    }
                    return;
                }
                cCl.setSelection(cCl.getSelectionEnd());
            }
        }
    };
    private TextWatcher jUi = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String jUm;
        private String jUn = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jUm = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jUm != null ? this.jUm.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cmG();
            EditText cCk = WriteActivity.this.cCk();
            if (editable != null && cCk != null && cCk.getText() != null) {
                if (this.jUn == null || !this.jUn.equals(editable.toString())) {
                    if (WriteActivity.this.jUb != null) {
                        this.jUn = cCk.getText().toString();
                        WriteActivity.this.jUb.o(cCk);
                        return;
                    }
                    return;
                }
                cCk.setSelection(cCk.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0412a hWK = new a.InterfaceC0412a() { // from class: com.baidu.tieba.write.write.WriteActivity.31
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0412a
        public void onRefresh() {
            WriteActivity.this.hnK = null;
            WriteActivity.this.sp(false);
            WriteActivity.this.csg.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void asC() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void asD() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            asF();
        } else if (this.ctJ.cqv()) {
            asC();
        } else {
            this.ctJ.rh(false);
            b(1, true, null);
            this.ctJ.cqt();
        }
    }

    public void cCu() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
            if (this.jTZ != null) {
                this.jTZ.cAX();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            asF();
        } else if (this.ctJ != null) {
            this.ctJ.rh(false);
            b(1, true, null);
            this.ctJ.cqt();
        }
    }

    private void asF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.hu(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kc()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.ctJ.aVG();
                } else {
                    WriteActivity.this.ctW.asR();
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
        aVar.agK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cBS() {
        int selectionEnd = cCk().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cCk().getText().getSpans(0, cCk().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cCk().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cCk().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBT() {
        if (this.csg != null) {
            this.csg.setBarLauncherEnabled(!this.jUg);
            this.csg.setBarLauncherEnabled(true, 26);
            this.csg.setBarLauncherEnabled(true, 2);
            X(9, this.jUg ? false : true);
        }
    }

    private void X(int i, boolean z) {
        com.baidu.tbadk.editortools.g kn;
        if (this.csg != null && (kn = this.csg.kn(i)) != null) {
            if (z) {
                kn.qk();
            } else {
                kn.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.jTV) {
            this.iWF.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.jUF.setVisibility(8);
            } else {
                this.jUF.setVisibility(0);
            }
            a(this.jUI, this.jUC);
            a(this.jUH, this.jUG);
            cmG();
        }
        if (this.jUo) {
            this.jUg = true;
            cBT();
            if (this.csg != null) {
                this.csg.aqw();
            }
            this.iWF.requestFocus();
            ShowSoftKeyPadDelay(this.iWF);
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
            cCJ();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                cCt();
            }
            sq(true);
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
            Dn(this.jNT);
        }
        initUI();
        cCz();
        this.ctJ = new LocationModel(this);
        this.ctJ.a(this.ctW);
        registerListener(this.jiF);
        registerListener(this.jUe);
        initEditor();
        cCM();
        if (this.jTV) {
            this.jUB.setEditorTools(this.csg);
        } else {
            this.iWJ.requestFocus();
        }
        ciI();
        cCt();
        cCK();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.csg = new EditorTools(getActivity());
        this.csg.setBarMaxLauCount(5);
        this.csg.setMoreButtonAtEnd(true);
        this.csg.setBarLauncherType(1);
        this.csg.fh(true);
        this.csg.fi(true);
        this.csg.setMoreLauncherIcon(R.drawable.write_more);
        this.csg.setBackgroundColorId(R.color.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                cCx();
                break;
            default:
                cBU();
                break;
        }
        this.csg.asb();
        if (this.jTD != null) {
            this.jTD.addView(this.csg);
        }
        cBV();
        this.csg.qk();
        com.baidu.tbadk.editortools.g kn = this.csg.kn(6);
        if (kn != null && !TextUtils.isEmpty(this.ctO)) {
            ((View) kn).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.ctO);
                }
            });
        }
        if (!this.jTV) {
            this.csg.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.csg.aqw();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("xiaoying_has_click", false)) {
            this.csg.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("hot_topic_has_click", false)) {
            this.csg.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        cBX();
    }

    private void cCv() {
        this.jUD = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.jUF = this.jUD.findViewById(R.id.live_post_title_container);
        this.jUC = (EditText) this.jUD.findViewById(R.id.live_post_content);
        this.jUA = (GridView) this.jUD.findViewById(R.id.photoLiveGridView);
        this.jUG = (EditText) this.jUD.findViewById(R.id.live_post_title);
        this.jUH = (TextView) this.jUD.findViewById(R.id.titleOverPlusNumber);
        this.jUI = (TextView) this.jUD.findViewById(R.id.contentOverPlusNumber);
        this.jUE = this.jUD.findViewById(R.id.live_interval_view);
        this.jUH.setText(String.valueOf(20));
        this.jUI.setText(String.valueOf(233));
        this.jUD.setVisibility(0);
        this.jUH.setVisibility(0);
        this.jUI.setVisibility(0);
        this.jUG.setHint(R.string.tips_title_limit_new);
        this.jUG.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.jUL = true;
                    WriteActivity.this.jUg = true;
                    WriteActivity.this.cBT();
                    if (WriteActivity.this.csg != null) {
                        WriteActivity.this.csg.aqw();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.jUC.setHint(R.string.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.jUC.setHint(R.string.live_write_input_content_update);
        }
        this.jUC.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.jUL = false;
                    WriteActivity.this.jUg = false;
                    WriteActivity.this.cBT();
                    if (WriteActivity.this.csg != null) {
                        WriteActivity.this.csg.aqw();
                    }
                }
            }
        });
        this.jUC.requestFocus();
        this.jUC.addTextChangedListener(DY());
        this.jUG.requestFocus();
        this.jUG.addTextChangedListener(DY());
        this.jUG.setOnClickListener(this.jUf);
        this.jUC.setOnClickListener(this.jUf);
        this.jUB = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.jUA);
        this.jUB.Dh(6);
        this.jUA.setAdapter((ListAdapter) this.jUB);
        View findViewById = this.jUD.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void cBD() {
                WriteActivity.this.cCH();
            }
        });
        cCw();
    }

    private void cCw() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.jUG.setText(this.mData.getTitle());
                this.jUG.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.jTV) {
            cCF();
        }
        if (this.csg.asd()) {
            this.csg.aqw();
        }
        Dn(0);
    }

    private void Dn(int i) {
        if (this.writeImagesInfo != null && this.mData != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(12002);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.fTQ);
            albumActivityConfig.setProfessionZone(this.mData.getProZone());
            sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void cCx() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.csg.ai(arrayList);
        com.baidu.tbadk.editortools.k kq = this.csg.kq(5);
        if (kq != null) {
            kq.csQ = 2;
            kq.csO = R.drawable.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.csO = R.drawable.write_at;
        this.csg.b(aVar);
        this.csg.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void cBU() {
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        com.baidu.tbadk.editortools.k kVar3;
        com.baidu.tbadk.editortools.k kVar4;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.k kVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.csO = R.drawable.write_picture;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            this.csg.b(dVar);
        }
        Boolean cCD = cCD();
        if (!this.jUo && cCD != null && cCD.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.cqW() && r.b(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), com.baidu.tbadk.editortools.k.class)) != null && (kVar5 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar5.csQ = 3;
            kVar5.csO = R.drawable.write_recorder;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.csg.b(kVar5);
            }
        }
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        aVar.csO = R.drawable.icon_post_topic_selector;
        this.csg.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001343, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask2 != null && (kVar4 = (com.baidu.tbadk.editortools.k) runTask2.getData()) != null) {
            kVar4.csQ = 5;
            kVar4.csO = R.drawable.write_privilege;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.csg.b(kVar4);
            }
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask3 != null && (kVar3 = (com.baidu.tbadk.editortools.k) runTask3.getData()) != null) {
            kVar3.csQ = 6;
            kVar3.csO = this.jUo ? R.drawable.write_location : R.drawable.icon_post_more_location;
            this.csg.b(kVar3);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 7);
        aVar2.csO = R.drawable.icon_post_more_at;
        this.csg.b(aVar2);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask4 != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
            kVar2.csS = true;
            kVar2.csQ = 9;
            kVar2.csO = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.csg.b(kVar2);
            }
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask5 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask5.getData()) != null) {
            kVar.csS = true;
            kVar.csQ = 10;
            kVar.csO = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.csg.b(kVar);
            }
        }
        if (this.jTJ == null) {
            if (this.jTZ == null) {
                this.jTZ = new com.baidu.tieba.write.editor.b(getActivity(), this.fTQ);
                this.jTZ.bt(this.mData.getForumId(), this.privateThread);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.jTZ.cAT();
                this.jTZ.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                cCu();
            }
            this.csg.b(this.jTZ);
        }
        this.csg.ai(arrayList);
        com.baidu.tbadk.editortools.k kq = this.csg.kq(5);
        if (kq != null) {
            kq.csQ = 1;
            kq.csO = R.drawable.write_emotion;
        }
    }

    private void cBW() {
        if (this.jUc != null) {
            this.jUc.hideTip();
        }
    }

    private void cBX() {
        if (this.jUc == null) {
            this.jUc = new e(getPageContext());
        }
        this.jUc.c(this.csg);
    }

    private void cBV() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.cCj()) {
                            WriteActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12004, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new an("c12612").P("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (aVar.data != null && (aVar.data instanceof p)) {
                            p pVar = (p) aVar.data;
                            if (pVar.amw() == EmotionGroupType.BIG_EMOTION || pVar.amw() == EmotionGroupType.USER_COLLECT) {
                                if (WriteActivity.this.mCurrentPermissionJudgePolicy == null) {
                                    WriteActivity.this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                                }
                                WriteActivity.this.mCurrentPermissionJudgePolicy.ajS();
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
                                    WriteActivity.this.sq(true);
                                    WriteActivity.this.cmG();
                                }
                            } else if (WriteActivity.this.cCj()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(pVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.cCm();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bVF();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.cCJ();
                        WriteActivity.this.cmG();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.Do(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new an("c12612").P("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.jTJ == null) {
                            WriteActivity.this.asG();
                            return;
                        }
                        switch (WriteActivity.this.ctP) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.cx(pageActivity)) {
                                    WriteActivity.this.asD();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.asC();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.ctJ != null) {
                            WriteActivity.this.ctJ.rh(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.hnK = null;
                        } else {
                            WriteActivity.this.hnK = (String) aVar.data;
                        }
                        WriteActivity.this.sp(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("xiaoying_has_click", true);
                        an anVar = new an("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.bT("fid", str);
                        TiebaStatic.log(anVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.csg.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.csg.asd()) {
                                        WriteActivity.this.csg.aqw();
                                        WriteActivity.this.csg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.csg.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.csg.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.csg.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.csg.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.cmG();
                        if (WriteActivity.this.iWJ != null) {
                            WriteActivity.this.iWJ.requestFocus();
                        }
                        WriteActivity.this.csg.aqw();
                        WriteActivity.this.csg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iWJ);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new an("c12612").P("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.csg.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.jTB = true;
                        WriteActivity.this.sn(true);
                        if (!WriteActivity.this.cCl().isFocused() || WriteActivity.this.jTE.getVisibility() != 0) {
                            WriteActivity.this.jTA = "from_content";
                        } else {
                            WriteActivity.this.jTA = "from_title";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.jTE.setVisibility(0);
                        WriteActivity.this.jTE.requestFocus();
                        WriteActivity.this.cmG();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.jTE.hasFocus()) {
                            WriteActivity.this.iWJ.requestFocus();
                            WriteActivity.this.iWJ.setSelection(WriteActivity.this.iWJ.getText().toString().length());
                        }
                        WriteActivity.this.jTE.setVisibility(8);
                        WriteActivity.this.cmG();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.csg.setActionListener(16, bVar);
        this.csg.setActionListener(14, bVar);
        this.csg.setActionListener(24, bVar);
        this.csg.setActionListener(3, bVar);
        this.csg.setActionListener(10, bVar);
        this.csg.setActionListener(11, bVar);
        this.csg.setActionListener(12, bVar);
        this.csg.setActionListener(13, bVar);
        this.csg.setActionListener(15, bVar);
        this.csg.setActionListener(18, bVar);
        this.csg.setActionListener(20, bVar);
        this.csg.setActionListener(25, bVar);
        this.csg.setActionListener(27, bVar);
        this.csg.setActionListener(29, bVar);
        this.csg.setActionListener(43, bVar);
        this.csg.setActionListener(45, bVar);
        this.csg.setActionListener(53, bVar);
        this.csg.setActionListener(48, bVar);
        this.csg.setActionListener(46, bVar);
        this.csg.setActionListener(49, bVar);
        this.csg.setActionListener(47, bVar);
        this.csg.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Do(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asG() {
        if (this.ctJ.aVC()) {
            if (this.ctJ.cqv()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.cqr().getLocationData().cqp());
                return;
            }
            b(1, true, null);
            this.ctJ.cqt();
            return;
        }
        b(0, true, null);
    }

    protected void cmy() {
        if (this.ctK != null) {
            this.ctK.cancelLoadData();
        }
        if (this.jTF != null) {
            this.jTF.cancelLoadData();
        }
        if (this.ctJ != null) {
            this.ctJ.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cBW();
        TiebaPrepareImageService.StopService();
        cmy();
        cCC();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.jUz != null) {
            this.jUz.destroy();
        }
        if (this.jUZ != null) {
            this.jUZ.bbB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBY() {
        if (this.mData != null && this.mData.getType() == 2 && this.jUv) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.mData.setTitle(cCl().getText().toString());
            this.mData.setContent(cCk().getText().toString());
            int type = this.mData.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    v.c(this.mData.getForumId(), this.mData);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    v.c("24591571", this.mData);
                }
            } else if (type == 1) {
                v.d(this.mData.getThreadId(), this.mData);
            } else if (type == 4) {
                v.c(this.mData.getForumId() + "photolive", this.mData);
            } else if (type == 5) {
                v.d(this.mData.getThreadId() + "updatephotolive", this.mData);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.iWL != null && this.iWL.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.iWL, getPageContext().getPageActivity());
                return true;
            } else if (this.csg.asd()) {
                this.csg.aqw();
                return true;
            } else {
                cmy();
                cBY();
                return true;
            }
        }
        if (i == 67 && (text = cCk().getText()) != null) {
            int selectionStart = cCk().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cCk().onKeyDown(67, this.fda);
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
        getLayoutMode().onModeChanged(this.jUQ);
        if (this.jUN != null && i == 1) {
            this.jUN.setBorderColor(am.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.f(this.mPost, R.color.cp_link_tip_a, 1);
        cBT();
        am.l(this.jUD, R.color.cp_bg_line_d);
        am.l(this.iWG, R.color.cp_bg_line_c);
        am.l(this.jUE, R.color.cp_bg_line_c);
        am.l(cCl(), R.color.cp_bg_line_d);
        am.c(this.hPY, (int) R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.hnK)) {
            am.l(cCk(), R.color.cp_bg_line_d);
        }
        cmG();
        this.csg.onChangeSkinType(i);
        if (this.jTT != null) {
            this.jTT.akN();
        }
        am.j(this.mName, R.color.cp_cont_b);
        cBZ();
        cCa();
        if (this.jUb != null) {
            this.jUb.c(cCl(), cCk());
        }
        this.jRM.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBZ() {
        if (this.iWF.hasFocus()) {
            this.iWF.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.iWF.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.iWJ.hasFocus()) {
            this.iWJ.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.iWJ.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCa() {
        if (this.iWF != null && this.iWF.getText() != null && this.iWF.getText().toString() != null && this.iWF.getPaint() != null) {
            if (this.iWF.getText().toString().length() == 0) {
                this.iWF.getPaint().setFakeBoldText(false);
            } else if (this.iWF.getText().toString().length() > 0) {
                this.iWF.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.cCv = new com.baidu.tbadk.core.view.b(getPageContext());
        this.jTV = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.cfi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(R.drawable.icon_topbar_close, R.drawable.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.j(this.mName, R.color.cp_cont_b);
        this.jUt = (TextView) findViewById(R.id.btn_image_problem);
        cCc();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.g(getPageContext().getPageActivity(), R.dimen.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.iWD);
        this.jTU = (ScrollView) findViewById(R.id.write_scrollview);
        this.jTU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.iWJ != null) {
                        l.b(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.iWJ);
                    }
                    if (WriteActivity.this.csg != null) {
                        WriteActivity.this.csg.aqw();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jUr = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.jUs = findViewById(R.id.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(R.id.parent);
        this.jTD = (LinearLayout) findViewById(R.id.tool_view);
        this.jTD.setContentDescription("..");
        this.jTE = (LinearLayout) findViewById(R.id.title_view);
        this.iWG = findViewById(R.id.interval_view);
        this.jUV = findViewById(R.id.hot_topic_fourm_view);
        this.jUW = findViewById(R.id.hot_topic_divider);
        this.jTX = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.jUX = (TextView) findViewById(R.id.change_one_tv);
        cmF();
        if (this.jTV) {
            this.jTU.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            cCv();
        } else {
            this.jUz = new g(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.jUz.si(false);
            } else {
                g gVar = this.jUz;
                if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                    z = false;
                }
                gVar.si(z);
            }
        }
        cmH();
        if (this.jUo || this.jTC) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().bUR) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.iWI = (LinearLayout) findViewById(R.id.post_content_container);
        this.iWI.setDrawingCacheEnabled(false);
        this.iWI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.csg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.iWJ.requestFocus();
            }
        });
        this.hPV = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.hPW = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.hPY = (ImageView) findViewById(R.id.iv_delete_voice);
        this.hPY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bVF();
            }
        });
        this.cfi.setOnFocusChangeListener(this.iWD);
        this.cfi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cmy();
                WriteActivity.this.cBY();
            }
        });
        this.jUt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        cCf();
        l(cCD());
        cCh();
        cCb();
        cCA();
        cCB();
        cBT();
        cCg();
        cmE();
        cCn();
        if (this.mData.getType() == 4 && this.iWN != null && this.jTG != null) {
            this.iWN.setVisibility(8);
            this.jTG.setVisibility(8);
        }
        cmG();
        cCy();
        cBk();
    }

    private void cBk() {
        this.jRM = new com.baidu.tieba.write.b.c(getPageContext().getPageActivity(), this.mName, this.mData.getProZone(), isUseStyleImmersiveSticky() ? StatusBarUtil.getStatusBarOffsetPx(getPageContext().getPageActivity()) : 0);
        this.jRM.a(new c.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // com.baidu.tieba.write.b.c.a
            public void Dc(int i) {
                WriteActivity.this.mData.setProZone(i);
            }
        });
        this.jRM.bfV();
    }

    private void cCb() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.jUo || this.jTC) {
                        if (this.jUp) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.fTQ != null && this.fTQ.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                    } else if (this.fTQ != null && this.fTQ.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.mData.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.mData.getForumName() + getResources().getString(R.string.bar));
                        this.iWF.setVisibility(8);
                        String str3 = this.fsB + " " + this.fsz;
                        if (!StringUtils.isNull(str3)) {
                            this.iWJ.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.iWF.setVisibility(0);
                    this.iWJ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.iWJ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.iWF.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.iWJ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.jUE.setVisibility(8);
                    return;
                case 7:
                    this.iWF.setVisibility(0);
                    this.iWJ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void cCc() {
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

    private void cCd() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.jUo && !this.jTC && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String i = aq.i(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(i) && cCl() != null) {
                cCl().setText(i);
                cCl().setSelection(i.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.hPV.setVisibility(0);
            this.hPW.setVoiceModel(voiceModel);
            this.hPW.cqV();
            cmG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVF() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.aZ(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.hPV.setVisibility(8);
        this.hPW.bwz();
        this.hPW.setVoiceModel(null);
        com.baidu.tbadk.editortools.k kq = this.csg.kq(6);
        if (kq != null && kq.csa != null) {
            kq.csa.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cmG();
    }

    private void cCe() {
        this.jTO = null;
        this.jTQ = -1;
        this.jTS = -1;
        com.baidu.tieba.frs.x rM = w.bnN().rM(1);
        if (rM != null) {
            this.jTO = rM.fyb;
            this.jTQ = getIntent().getIntExtra("category_id", -1);
            if (this.jTO != null && !this.jTO.isEmpty() && this.jTQ >= 0) {
                this.jTP = new com.baidu.tieba.frs.v();
                this.jTP.fxX = 0;
                this.jTP.name = getPageContext().getResources().getString(R.string.category_auto);
                this.jTS = this.jTP.fxX;
                this.jTR = this.jTP.name;
                for (com.baidu.tieba.frs.v vVar : this.jTO) {
                    if (vVar.fxX == this.jTQ) {
                        this.jTS = vVar.fxX;
                        this.jTR = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cCf() {
        if (this.jTO != null && !this.jTO.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.jTT = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.jTT.setText(this.jTR);
            this.jTT.setCategoryContainerData(this.jTO, this.jTP, this.jTS);
            this.jTT.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ar arVar) {
                    if (arVar != null) {
                        WriteActivity.this.jTT.setText(arVar.name);
                        WriteActivity.this.mData.setCategoryTo(arVar.fxX);
                        WriteActivity.this.jTS = arVar.fxX;
                        WriteActivity.this.jTT.cBG();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.jTT.cBF();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cCl());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cCk());
                }
            });
        }
    }

    private void cCy() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.jUj = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.jUj.setTitle(R.string.no_disturb_start_time);
        this.jUj.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.jUj);
        this.jUj.setButton(-2, getPageContext().getString(R.string.cancel), this.jUj);
        return this.jUj;
    }

    private void cCg() {
        this.jTK = (RelativeLayout) findViewById(R.id.addition_container);
        this.jTL = (TextView) findViewById(R.id.addition_create_time);
        this.jTM = (TextView) findViewById(R.id.addition_last_time);
        this.jTN = (TextView) findViewById(R.id.addition_last_content);
        if (this.jTJ != null) {
            this.jTK.setVisibility(0);
            this.jTL.setText(getPageContext().getString(R.string.write_addition_create) + aq.aD(this.jTJ.getCreateTime() * 1000));
            if (this.jTJ.getAlreadyCount() == 0) {
                this.jTM.setVisibility(8);
            } else {
                this.jTM.setText(getPageContext().getString(R.string.write_addition_last) + aq.aD(this.jTJ.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.jTJ.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.jTN.setText(lastAdditionContent);
            } else {
                this.jTN.setVisibility(8);
            }
            cCk().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.jTJ.getAlreadyCount()), Integer.valueOf(this.jTJ.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.jTK.setVisibility(8);
    }

    private void cmE() {
        this.iWN = findViewById(R.id.post_prefix_layout);
        if (this.jUZ == null) {
            this.jUZ = new com.baidu.tieba.c.d(getPageContext(), this.iWN);
            this.jUZ.qc(R.drawable.bg_tip_blue_up_left);
            this.jUZ.qb(16);
            this.jUZ.iR(true);
            this.jUZ.S(true);
            this.jUZ.qf(l.g(getActivity(), R.dimen.ds32));
        }
        this.iWK = (TextView) findViewById(R.id.post_prefix);
        this.jTG = findViewById(R.id.prefix_divider);
        this.iWM = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.iWN.setVisibility(0);
            this.jUZ.u(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iWn = 0;
            this.iWN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").bT("fid", WriteActivity.this.mData.getForumId()).l("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.iWK.setVisibility(0);
                    WriteActivity.this.iWN.setSelected(true);
                    am.c(WriteActivity.this.iWM, (int) R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.iWL, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.csg.aqw();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iWF);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iWJ);
                }
            });
            this.iWK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").bT("fid", WriteActivity.this.mData.getForumId()).l("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.iWK.setSelected(true);
                    am.c(WriteActivity.this.iWM, (int) R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.iWL, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.csg.aqw();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cCl());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cCk());
                }
            });
            this.iWL = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.iWL.a(this);
            this.iWL.setMaxHeight(l.g(getActivity(), R.dimen.ds510));
            this.iWL.setOutsideTouchable(true);
            this.iWL.setFocusable(true);
            this.iWL.setOnDismissListener(this);
            this.iWL.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            am.getColor(R.color.cp_cont_c);
            am.k(this.iWK, R.color.cp_bg_line_d);
            am.c(this.iWM, (int) R.drawable.icon_arrow_gray_down);
            this.iWK.setTextColor(color);
            this.jTH.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.jTH.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.sd(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.sd(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.iWL.addView(writePrefixItemLayout);
            }
            this.iWL.setCurrentIndex(0);
            this.iWK.setText(prefixs.get(0));
            Dm(0);
            return;
        }
        this.iWN.setVisibility(8);
    }

    private void cCz() {
        if (this.jUo && this.mData != null) {
            this.jUr.setVisibility(0);
            this.jUs.setVisibility(0);
            this.jTF = new FeedBackModel(getPageContext());
            this.jTF.GW(this.mData.getForumName());
            this.jTF.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.24
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.jUr.setVisibility(8);
                        WriteActivity.this.jUs.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.jUr.setVisibility(8);
                        WriteActivity.this.jUs.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.jUr.a(feedBackModel.cBI(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void cCh() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.kc()) {
                    WriteActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (WriteActivity.this.jUb.a(WriteActivity.this.iWF, WriteActivity.this.iWJ)) {
                        WriteActivity.this.showToast(WriteActivity.this.jUb.czD());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cCl());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cCk());
                    WriteActivity.this.csg.aqw();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.jUo) {
                            WriteActivity.this.cCq();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            an anVar = new an("c12102");
                            anVar.P("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(anVar);
                            WriteActivity.this.cCr();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.cCq();
                    }
                    TiebaStatic.log(new an("c12262").bT("obj_locate", WriteActivity.this.fTQ));
                }
            }
        });
    }

    protected void cCA() {
        this.jUu = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.jUu.mO(getPageContext().getString(R.string.is_save_draft)).dQ(false).a(getPageContext().getString(R.string.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.cCl().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.cCk().getText().toString());
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    v.c(WriteActivity.this.mData.getForumId(), WriteActivity.this.mData);
                } else if (type == 1) {
                    v.d(WriteActivity.this.mData.getThreadId(), WriteActivity.this.mData);
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
                    v.c(WriteActivity.this.mData.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    v.d(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.jUu.b(getPageContext());
    }

    protected void cmF() {
        this.jUq = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.jUq.setIsRound(true);
        this.jUq.setDrawBorder(false);
        this.jUq.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String nM = o.nM(currentPortrait);
            this.jUq.setUrl(nM);
            this.jUq.startLoad(nM, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.jUq.setVisibility(0);
        }
        this.iWF = (EditText) findViewById(R.id.post_title);
        this.iWF.setOnClickListener(this.jUf);
        this.iWF.setOnFocusChangeListener(this.iWD);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.iWF.setText(this.mData.getTitle());
                this.iWF.setSelection(this.mData.getTitle().length());
            } else if (this.jUp) {
                this.iWF.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.iWF.addTextChangedListener(this.jUh);
        if (!this.mData.getHaveDraft()) {
            cCd();
            this.jUU = true;
        }
        if (this.mData.isUserFeedback()) {
            this.iWF.setHint(getResources().getString(R.string.feedback_title_hint));
        } else {
            this.iWF.setHint(getResources().getString(R.string.post_title_hint));
        }
    }

    private TextWatcher DY() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            private int jVd;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.cmG();
                if (WriteActivity.this.jTV) {
                    this.jVd = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.jVd);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.jTV || !WriteActivity.this.jUL) {
                    if (WriteActivity.this.jTV) {
                        if (this.mEditText != WriteActivity.this.jUC || this.mTextView != WriteActivity.this.jUI) {
                            this.mEditText = WriteActivity.this.jUC;
                            this.mTextView = WriteActivity.this.jUI;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.jUG || this.mTextView != WriteActivity.this.jUH) {
                    this.mEditText = WriteActivity.this.jUG;
                    this.mTextView = WriteActivity.this.jUH;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.jTV && this.jUL) {
            if (this.jUJ != null) {
                this.jUG.removeTextChangedListener(this.jUJ);
            }
            this.jUJ = textWatcher;
        } else if (this.jTV) {
            if (this.jUK != null) {
                this.jUC.removeTextChangedListener(this.jUK);
            }
            this.jUK = textWatcher;
        }
        return textWatcher;
    }

    private long p(EditText editText) {
        if (editText == this.jUC) {
            return 233L;
        }
        if (editText != this.jUG) {
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

    protected void cmH() {
        this.iWJ = (EditText) findViewById(R.id.post_content);
        this.iWJ.setDrawingCacheEnabled(false);
        this.iWJ.setOnClickListener(this.jUf);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString ak = TbFaceManager.atx().ak(getPageContext().getPageActivity(), this.mData.getContent());
            this.iWJ.setText(ak);
            this.iWJ.setSelection(ak.length());
        } else if (this.mData.getType() == 2) {
            if (this.jUv) {
                if (this.jUw != null && this.jUw.length() > 0) {
                    this.iWJ.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.jUw}));
                    this.iWJ.setSelection(this.iWJ.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.iWJ.setText(format);
                this.iWJ.setSelection(format.length());
            }
        }
        this.iWJ.setOnFocusChangeListener(this.iWD);
        this.iWJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.csg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.iWJ.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iWJ.addTextChangedListener(this.jUi);
        if (this.mData.getType() == 0) {
            this.jUY = true;
        } else {
            sp(true);
            this.jUY = false;
        }
        if (this.mData.isUserFeedback()) {
            this.iWJ.setHint(R.string.write_input_content);
        } else {
            this.iWJ.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void sp(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.jTV) {
            cCk().setPadding(0, 0, 0, 0);
            cCk().setBackgroundDrawable(null);
            am.l(cCk(), R.color.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.hnK) && this.jTJ == null) {
                com.baidu.adp.lib.f.c.iE().a(this.hnK, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.30
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
                            WriteActivity.this.cCk().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.cCk(), true, WriteActivity.this.hWK);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cCj() {
        int i = UIMsg.m_AppUI.MSG_APP_GPS;
        if (this.jTJ != null) {
            i = 1000;
        }
        return cCk().getText() != null && cCk().getText().length() >= i;
    }

    private void ql(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.jTA)) {
                this.jTA = "";
                cCk().requestFocus();
                if (cCk().getText() != null && cCk().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cCk().getSelectionStart();
                    editable = cCk().getText();
                }
            } else if ("from_title".equals(this.jTA)) {
                this.jTA = "";
                cCl().requestFocus();
                if (cCl().getText() != null && cCl().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cCl().getSelectionStart();
                    editable = cCl().getText();
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
    public void sn(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void e(p pVar) {
        if (((ImageSpan[]) cCk().getText().getSpans(0, cCk().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.jTI == null) {
                this.jTI = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            this.jTI.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType amw = pVar.amw();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.iE().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.32
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass32) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.cCk().getSelectionStart(), aVar, amw);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cCk() != null && cCk().getText() != null) {
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
                int selectionStart = cCk().getSelectionStart() - 1;
                if (cCk().getText().length() > 1 && selectionStart >= 0 && cCk().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cCk().getText().insert(cCk().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cCk().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cCk().getText().insert(cCk().getSelectionStart(), spannableString2);
            }
            Editable text = cCk().getText();
            if (text != null) {
                this.jTY.clear();
                this.jTY.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jTY);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cCk().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cCk().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cCk().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cCk() {
        return this.jTV ? this.jUC : this.iWJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cCl() {
        return this.jTV ? this.jUG : this.iWF;
    }

    protected void cCm() {
        Editable text;
        if (cCk() != null && (text = cCk().getText()) != null) {
            int selectionStart = cCk().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cCk().onKeyDown(67, this.fda);
            }
            cCk().onKeyDown(67, this.fda);
            int selectionStart2 = cCk().getSelectionStart();
            if (text != null) {
                this.jTY.clear();
                this.jTY.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jTY);
                cCk().setSelection(selectionStart2);
            }
        }
    }

    private void l(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.jUo = true;
        }
    }

    private void cCB() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void cCC() {
        try {
            if (this.jUu != null) {
                this.jUu.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.cCv.e(null);
        this.cCv.iz(R.string.sending);
        this.cCv.ej(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.cCv.ej(false);
    }

    private Boolean cCD() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.ctO = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void cmG() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (cCl() != null) {
                str = cCl().getText().toString();
            }
            if (cCk() != null) {
                str2 = cCk().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.iWn == com.baidu.tbadk.core.util.v.Z(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.jTE.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            so(true);
                            return;
                        }
                    } else if (this.jTE.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        so(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.jTE.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    so(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.jTV) {
                    so(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    so(true);
                }
            }
            if (this.mData.getType() == 4) {
                so(s(this.jUC) && r(this.jUG));
            } else if (this.mData.getType() == 5) {
                so(s(this.jUC));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                so(true);
            } else if (this.mData.getVideoInfo() != null) {
                so(true);
            } else {
                so(false);
            }
        }
    }

    public void so(boolean z) {
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
        this.ctK = new NewWriteModel(this);
        this.ctK.b(this.ctY);
        registerListener(this.jVa);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.cmy();
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
            this.jUo = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.jUp = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.jUv = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.jUw = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.ctI = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.jTJ = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.jTJ != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.jUx = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.mData.setTopicId(this.mTopicId);
            this.fTQ = bundle.getString("KEY_CALL_FROM");
            this.jNT = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
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
            this.jUo = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.jUp = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.jUv = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.jUw = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.jTJ = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.jTJ != null);
            this.mData.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.jUx = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.fsA = intent.getStringExtra("more_forum_img");
            this.fsB = intent.getStringExtra("more_forum_title");
            this.fsz = intent.getStringExtra("more_forum_url");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.mData.setTopicId(this.mTopicId);
            this.fTQ = intent.getStringExtra("KEY_CALL_FROM");
            this.jNT = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.jUo);
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
                v.c(this.mData.getForumId(), this);
            }
        } else if (this.mData.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                v.c("24591571", this);
            }
        } else if (this.mData.getType() == 1) {
            v.a(this.mData.getThreadId(), this);
        } else if (this.mData.getType() == 4) {
            v.c(this.mData.getForumId() + "photolive", this);
        } else if (this.mData.getType() == 5) {
            v.a(this.mData.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.hnK = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.jTC = true;
        }
        cCe();
        try {
            this.jUM = cCL();
        } catch (Throwable th) {
            this.jUM = null;
        }
    }

    private void cCn() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.iWF.setText(com.baidu.tbadk.plugins.b.qW(com.baidu.tbadk.plugins.b.qX(hotTopicBussinessData.mTopicName)));
            this.iWF.setMovementMethod(com.baidu.tieba.view.c.cyn());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString qW = com.baidu.tbadk.plugins.b.qW(com.baidu.tbadk.plugins.b.qX(hotTopicBussinessData.mTopicName));
            if (qW != null) {
                this.iWF.setText(qW);
            }
            this.jTX.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.v.a
    public void a(WriteData writeData) {
        String str;
        String qX;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            if (writeData != null) {
                if (this.mData != null) {
                    this.mData.setHaveDraft(true);
                    if (com.baidu.adp.lib.util.k.isEmpty(cCl().getText().toString()) || this.jUU || ((this.jUo || this.jTC) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
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
                                cCl().setText(qW);
                                cCl().setSelection(qW.length() > qX.length() ? qX.length() : qW.length());
                            }
                        } else {
                            SpannableString qW2 = com.baidu.tbadk.plugins.b.qW(this.mData.getTitle());
                            if (qW2 != null) {
                                cCl().setText(qW2);
                                cCl().setSelection(this.mData.getTitle().length() > qW2.length() ? qW2.length() : this.mData.getTitle().length());
                            }
                        }
                    }
                    if (this.mData != null && !this.mData.getHaveDraft()) {
                        cCd();
                    }
                    if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.copy(writeData.getVideoInfo());
                        this.mData.setVideoInfo(videoInfo);
                        this.csg.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                    }
                    if ((com.baidu.adp.lib.util.k.isEmpty(cCk().getText().toString()) || this.jUo || this.jTC) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                        this.mData.setContent(writeData.getContent());
                        SpannableString a2 = TbFaceManager.atx().a(getPageContext().getPageActivity(), this.mData.getContent(), this.jUd);
                        cCk().setText(a2);
                        cCk().setSelection(a2.length());
                        if (this.jTV) {
                            a(this.jUI, this.jUC);
                        }
                    }
                    if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                        this.writeImagesInfo = writeData.getWriteImagesInfo();
                        this.mData.setWriteImagesInfo(this.writeImagesInfo);
                        cCJ();
                        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                            cCt();
                        }
                        sq(false);
                    }
                    if (writeData.getType() == 4 || writeData.getType() == 5) {
                        cCE();
                    }
                    cmG();
                    int categoryTo = writeData.getCategoryTo();
                    if (categoryTo >= 0 && this.jTO != null) {
                        this.jTS = this.jTP.fxX;
                        this.jTR = this.jTP.name;
                        int i = 0;
                        while (true) {
                            if (i == this.jTO.size()) {
                                break;
                            }
                            com.baidu.tieba.frs.v vVar = this.jTO.get(i);
                            if (categoryTo != vVar.fxX) {
                                i++;
                            } else {
                                this.jTS = categoryTo;
                                this.jTR = vVar.name;
                                this.mData.setCategoryTo(this.jTS);
                                break;
                            }
                        }
                        if (this.jTT != null) {
                            this.jTT.setText(this.jTR);
                            this.jTT.setCategoryContainerData(this.jTO, this.jTP, this.jTS);
                        }
                    }
                    this.csg.aqw();
                    return;
                }
                return;
            }
            cCE();
            cCd();
        }
    }

    private void cCE() {
        if ((!this.jTV || this.jUB != null) && this.jUA != null) {
            this.jUB.c(this.writeImagesInfo);
            cCH();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.jUv);
        if (this.jUo) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.ctI);
        if (this.jTJ != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.jTJ));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.jUx);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.fTQ);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.jNT);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cCk().getEditableText().toString();
        if (obj != null) {
            cCk().setText(TbFaceManager.atx().a(getPageContext().getPageActivity(), obj, this.jUd));
            cCk().setSelection(cCk().getText().length());
        }
    }

    private String cCo() {
        return (cCk() == null || cCk().getText() == null) ? "" : cCk().getText().toString();
    }

    private String cCp() {
        if (this.mData == null || cCl() == null || cCl().getVisibility() != 0 || cCl().getText() == null) {
            return "";
        }
        String obj = cCl().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.Z(this.mPrefixData.getPrefixs()) > 0 && this.iWn != com.baidu.tbadk.core.util.v.Z(this.mPrefixData.getPrefixs()) - 1 && this.mData.getType() != 4 && this.iWK != null && this.iWK.getText() != null) {
            this.mData.setPostPrefix(this.iWK.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void GX(String str) {
        if (this.mData != null && this.jTE != null) {
            if (this.jTE.getVisibility() == 0) {
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
    public void cCq() {
        cmy();
        this.mData.setContent(cCo());
        GX(cCp());
        if (this.jUo || this.jTC) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                GX(string + this.mData.getTitle());
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
        if (this.jTQ >= 0) {
            this.mData.setCategoryFrom(this.jTQ);
        }
        if (this.jTS >= 0) {
            this.mData.setCategoryTo(this.jTS);
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
        this.mData.setHasLocationData(this.ctJ != null && this.ctJ.aVC());
        if (this.writeImagesInfo != null) {
            this.ctK.rj(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.mList) && this.jTW != null && this.jTW.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.jTW.mForumId));
            this.mData.setForumName(this.jTW.mForumName);
        }
        this.ctK.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.ctK.getWriteData().setVoice(this.mVoiceModel.getId());
                this.ctK.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.ctK.getWriteData().setVoice(null);
                this.ctK.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.ctK.getWriteData().setVoice(null);
            this.ctK.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.ctK.cqX()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.kc()) {
            showToast(R.string.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.mDialogCancelListener);
            this.ctK.startPostWrite();
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
            if (this.jTJ != null) {
                i2 = this.jTJ.getTotalCount();
                i = this.jTJ.getAlreadyCount() + 1;
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
                if (this.iWF == getCurrentFocus()) {
                    cCk().clearFocus();
                    this.iWF.requestFocus();
                    if (this.csg != null) {
                        this.csg.aqw();
                    }
                    ShowSoftKeyPadDelay(this.iWF);
                } else {
                    cCk().requestFocus();
                    if (this.csg != null) {
                        this.csg.aqw();
                    }
                    ShowSoftKeyPadDelay(this.iWJ);
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
                            cCk().getText().insert(cCk().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.mData.getType() == 0 || this.mData.getType() == 9) {
                    v.c(this.mData.getForumId(), (WriteData) null);
                    if (postWriteCallBackData2 != null) {
                    }
                } else if (this.mData.getType() == 1) {
                    v.d(this.mData.getThreadId(), (WriteData) null);
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
                                cCI();
                            } else {
                                aG(intent);
                            }
                        } else if (intExtra == 1) {
                            aH(intent);
                        } else {
                            aE(intent);
                            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.jUY) {
                            sp(true);
                            this.jUY = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.jTV) {
                        R(intent);
                        cmG();
                        return;
                    }
                    aF(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.csg.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.csg.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.csg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    cmG();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.jTB) {
                                sb2.append(com.baidu.tbadk.plugins.b.cBP);
                                this.jTB = false;
                            }
                            sb2.append(stringExtra);
                            ql(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.aa(this.mList) && !com.baidu.tbadk.core.util.v.aa(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.jTW = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.jTW);
                }
            }
        } else if (i2 == 0) {
            if (this.csg != null && !this.csg.asd()) {
                this.iWJ.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.csg.aqw();
            }
            switch (i) {
                case SapiGIDEvent.TIME_FREQ /* 12001 */:
                    asJ();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    cCG();
                    if (this.jUY) {
                        sp(true);
                        this.jUY = false;
                        return;
                    }
                    return;
                case 12004:
                    if (this.iWF == getCurrentFocus()) {
                        cCk().clearFocus();
                        this.iWF.requestFocus();
                        if (this.csg != null) {
                            this.csg.aqw();
                        }
                        ShowSoftKeyPadDelay(this.iWF);
                        return;
                    }
                    cCk().requestFocus();
                    if (this.csg != null) {
                        this.csg.aqw();
                    }
                    ShowSoftKeyPadDelay(this.iWJ);
                    return;
                case 12006:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.jUb.GB(postWriteCallBackData.getErrorString());
                        this.jUb.aI(postWriteCallBackData.getSensitiveWords());
                        this.jUb.b(this.iWF, this.iWJ);
                        return;
                    }
                    return;
                case 12009:
                default:
                    return;
                case 12010:
                    this.ctI = String.valueOf(System.currentTimeMillis());
                    al.a(getPageContext(), this.ctI);
                    return;
                case 12012:
                    cCG();
                    return;
                case 25004:
                    if ("from_title".equals(this.jTA)) {
                        cCl().requestFocus();
                        return;
                    } else if ("from_content".equals(this.jTA)) {
                        cCk().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCr() {
        if ("1".equals(this.fTQ)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.fTQ)) {
            this.mData.setCanNoForum(false);
        }
        cCs();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.fTQ);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cCq();
    }

    private void cCs() {
        if (this.csg != null) {
            this.csg.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void cCF() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void cCG() {
        if (this.jTV) {
            this.jUB.c(this.writeImagesInfo);
            cCH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCH() {
        this.jUB.notifyDataSetChanged();
        this.jUA.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.jUB.notifyDataSetChanged();
                WriteActivity.this.jUA.invalidateViews();
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
        cmG();
    }

    private void aE(Intent intent) {
        if (this.jTV) {
            aF(intent);
            cCG();
        } else {
            aI(intent);
        }
        cmG();
    }

    private void aF(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            cCG();
            sq(true);
        }
    }

    private void aG(Intent intent) {
        if (this.writeImagesInfo != null) {
            Q(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
            }
        }
    }

    private void cCI() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) SapiGIDEvent.TIME_FREQ, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void aH(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.jUy.parseJson(stringExtra);
            this.jUy.updateQuality();
            if (this.jUy.getChosedFiles() != null && this.jUy.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.jUy.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.jUy.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cCl());
        HidenSoftKeyPad(this.mInputManager, cCk());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void aI(Intent intent) {
        c(intent, true);
    }

    private void Q(Intent intent) {
        this.ctI = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.ctI;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.af(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.ah(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a(TbConfig.LOCAL_CAMERA_DIR, this.ctI, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            cCJ();
            cCt();
        }
        sq(true);
    }

    private void R(Intent intent) {
        c(intent, false);
    }

    private void c(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                cCJ();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    cCt();
                }
            }
            sq(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCJ() {
        if (this.csg.kq(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void asJ() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.ctI));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void cCK() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.fsA)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mCurrentPermissionJudgePolicy.ajS();
            this.mCurrentPermissionJudgePolicy.e(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.ad(this)) {
                n nVar = new n(this, this.fsA, new n.a() { // from class: com.baidu.tieba.write.write.WriteActivity.38
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
                            WriteActivity.this.sq(true);
                        }
                    }
                });
                nVar.setFrom(1);
                nVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sq(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.jUz != null) {
            this.jUz.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.fun == null) {
            this.fun = VoiceManager.instance();
        }
        return this.fun;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bmt() {
        this.fun = getVoiceManager();
        this.fun.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.fvB) != null) {
                    TiebaStatic.log(new an("c12534").P("obj_locate", au.a.bUh));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.jTJ == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                A(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.ctP = i;
        if (this.csg != null) {
            this.csg.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void cCt() {
        if (!this.jTV) {
            if (this.csg != null) {
                this.csg.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.csg.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.jUz != null) {
                this.jUz.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp(boolean z) {
        if (this.csg != null) {
            this.csg.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Dm(int i) {
        if (i < this.jTH.size()) {
            for (int i2 = 0; i2 < this.jTH.size(); i2++) {
                this.jTH.get(i2).se(false);
            }
            this.jTH.get(i).se(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void AL(int i) {
        if (i == com.baidu.tbadk.core.util.v.Z(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new an("c13014").P("obj_type", 1));
        } else {
            TiebaStatic.log(new an("c13014").P("obj_type", 2));
        }
        this.iWn = i;
        this.iWL.setCurrentIndex(i);
        Dm(i);
        this.iWK.setText(this.mPrefixData.getPrefixs().get(i));
        cmG();
        com.baidu.adp.lib.g.g.a(this.iWL, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.iWN.setSelected(false);
        am.c(this.iWM, (int) R.drawable.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.iWJ);
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
            asD();
        } else if (i == 1) {
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (ab.cy(getApplicationContext())) {
                al.a(getPageContext(), this.ctI);
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
        this.jUa = z;
        if (this.jUS && System.currentTimeMillis() - this.jUT < 800) {
            l.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.jUS = false;
        }
        if (this.jTZ != null && !z) {
            this.jTZ.bgj();
        }
        if (this.jUc != null && !z) {
            cBW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GY(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.jUP != null) {
            GZ(str);
            this.jUP.dismiss();
        }
    }

    private void ew(Context context) {
        jUR = l.ah(context);
    }

    private void GZ(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.jUS = true;
        cCJ();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            cCt();
        }
        sq(true);
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

    private File cCL() {
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

    private void cCM() {
        if (this.jUM != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            ew(getActivity());
            this.jUO = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.jUO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.jUM != null) {
                        WriteActivity.this.GY(WriteActivity.this.jUM.getAbsolutePath());
                    }
                }
            });
            this.jUN = (TbImageView) this.jUO.findViewById(R.id.rec_img_view);
            this.jUQ = (LinearLayout) this.jUO.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.ahQ().getString("write_rec_pic_path", "").equalsIgnoreCase(this.jUM.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.ahQ().putString("write_rec_pic_path", this.jUM.getAbsolutePath());
                Bitmap f = f(this.jUM.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (f != null) {
                    this.jUN.setImageBitmap(f);
                    this.jUN.setDrawBorder(true);
                    this.jUN.setBorderWidth(2);
                    this.jUN.setBorderColor(am.getColor(R.color.common_color_10264));
                    this.jUP = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.jUP.setCanceledOnTouchOutside(true);
                    this.jUP.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.jUS) {
                                l.b(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.jUT = System.currentTimeMillis();
                            }
                        }
                    });
                    this.jUP.setContentView(this.jUO);
                    this.jUP.show();
                    Window window = this.jUP.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (jUR / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.jUa && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.jTB = false;
            this.jTA = "";
            if ("from_content".equals(str)) {
                this.jTA = "from_content";
            } else if ("from_title".equals(str)) {
                this.jTA = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.qV(String.valueOf(charSequence.charAt(i)))) {
                sn(false);
            }
        }
    }

    public void ciI() {
        if (this.jUo || !com.baidu.tbadk.core.util.v.aa(this.mList) || !StringUtils.isNull(this.mData.getTitle())) {
            this.jTE.setVisibility(0);
            this.jTE.requestFocus();
            this.csg.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.jTE.setVisibility(8);
    }
}
