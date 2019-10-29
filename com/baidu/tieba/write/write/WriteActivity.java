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
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.e.a.a;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
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
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.frs.x;
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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0055a, VoiceManager.c, v.a, h.a {
    private static int jVm = 0;
    private EditorTools cFk;
    private String cGO;
    private LocationModel cGP;
    private NewWriteModel cGQ;
    private String ftA;
    private String ftB;
    private String ftz;
    private VoiceManager fvn;
    private ImageView hQA;
    private LinearLayout hQx;
    private PlayVoiceBntNew hQy;
    private TextView iYX;
    private com.baidu.tieba.write.h iYY;
    private ImageView iYZ;
    private int iYz;
    private View iZa;
    private boolean isPrivacy;
    private com.baidu.tieba.write.b.c jSi;
    private LinearLayout jTZ;
    private com.baidu.tieba.view.b jUE;
    private View jUN;
    private g jUU;
    private LinearLayout jUa;
    private View jUc;
    private Toast jUe;
    private AdditionData jUf;
    private RelativeLayout jUg;
    private TextView jUh;
    private TextView jUi;
    private TextView jUj;
    List<com.baidu.tieba.frs.v> jUk;
    com.baidu.tieba.frs.v jUl;
    private int jUm;
    private String jUn;
    private int jUo;
    private PostCategoryView jUp;
    private HotTopicBussinessData jUs;
    private TextView jUt;
    private com.baidu.tieba.write.editor.b jUv;
    private e jUx;
    private View jVq;
    private View jVr;
    private TextView jVs;
    private com.baidu.tieba.c.d jVu;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String jTW = "";
    private boolean jTX = false;
    private WriteData iYy = null;
    private boolean jUJ = false;
    private boolean jTY = false;
    private boolean jUK = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText iYR = null;
    private HeadImageView jUL = null;
    private View iYS = null;
    private LinearLayout iYU = null;
    private EditText iYV = null;
    private FeedBackModel jUb = null;
    private FeedBackTopListView jUM = null;
    private ArrayList<WritePrefixItemLayout> jUd = new ArrayList<>();
    private String hot = null;
    private final KeyEvent fhx = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView jUO = null;
    private TextView iYW = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener fms = null;
    private com.baidu.tbadk.core.dialog.a jUP = null;
    private final Handler mHandler = new Handler();
    private boolean jUQ = false;
    private String jUR = null;
    private RelativeLayout gze = null;
    private String cGV = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int cGW = 0;
    private int jUS = 0;
    private WriteImagesInfo jUT = new WriteImagesInfo();
    private View mRootView = null;
    private GridView jUV = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a jUW = null;
    private ScrollView jUq = null;
    private EditText jUX = null;
    private View jUY = null;
    private View jUZ = null;
    private View jVa = null;
    private EditText jVb = null;
    private TextView jVc = null;
    private TextView jVd = null;
    private TextWatcher jVe = null;
    private TextWatcher jVf = null;
    private boolean jUr = false;
    private boolean jVg = false;
    private com.baidu.tbadk.core.view.b cOA = null;
    private String mFrom = "write";
    private File jVh = null;
    private TbImageView jVi = null;
    private View jVj = null;
    private Dialog jVk = null;
    private LinearLayout jVl = null;
    private boolean jVn = false;
    private long jVo = -1000;
    private boolean jVp = false;
    private String fVb = "2";
    private int apy = 0;
    private String mTopicId = "";
    private SpannableStringBuilder jUu = new SpannableStringBuilder();
    private boolean jVt = false;
    private boolean aiA = false;
    private final b jUw = new b();
    private final HttpMessageListener jVv = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.hot)) {
                    WriteActivity.this.hot = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.rX(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.hot)) {
                    WriteActivity.this.hot = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.hot);
                    WriteActivity.this.rX(true);
                }
            }
        }
    };
    private TbFaceManager.a jUy = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan pW(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.getRawBitmap());
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
    private final AntiHelper.a fwB = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).O("obj_locate", at.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).O("obj_locate", at.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d cHf = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.bkk();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.iYy != null) {
                WriteActivity.this.jUw.aM(null);
                if (z) {
                    WriteActivity.this.fm(z);
                    if (WriteActivity.this.e(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    if (WriteActivity.this.iYy.getType() != 0 && WriteActivity.this.iYy.getType() != 9) {
                        if (WriteActivity.this.iYy.getType() != 7) {
                            if (WriteActivity.this.iYy.getType() == 1) {
                                v.d(WriteActivity.this.iYy.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.iYy.getType() == 5) {
                                v.d(WriteActivity.this.iYy.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            v.c("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            v.c(WriteActivity.this.iYy.getForumId(), (WriteData) null);
                        }
                        if (!com.baidu.tbadk.core.util.v.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                            TiebaStatic.log(new an("c11731").bS("obj_id", WriteActivity.this.mTopicId));
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
                    WriteActivity.this.jUw.aM(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.jUw.Fv(postWriteCallBackData.getErrorString());
                    WriteActivity.this.jUw.b(WriteActivity.this.iYR, WriteActivity.this.iYV);
                } else if ((yVar == null || writeData == null || yVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (yVar != null && writeData != null && yVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(yVar.getVcode_md5());
                    writeData.setVcodeUrl(yVar.getVcode_pic_url());
                    writeData.setVcodeExtra(yVar.apu());
                    if (com.baidu.tbadk.v.a.qv(yVar.apt())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, yVar.apt());
                        if (WriteActivity.this.jUK) {
                            newVcodeActivityConfig.setHideFeedBackButton();
                        }
                        WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newVcodeActivityConfig));
                        return;
                    }
                    WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a cHd = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void auP() {
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
            if (aVar != null && !StringUtils.isNull(aVar.coU())) {
                WriteActivity.this.b(2, true, aVar.coU());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener jkQ = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.cGP.qT(false);
                    WriteActivity.this.cGP.ec(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.cGP.qT(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener jUz = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener jUA = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.cFk.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int czq = WriteActivity.this.czq();
            if (czq >= 0 && czq < WriteActivity.this.iYV.getText().length()) {
                WriteActivity.this.iYV.setSelection(czq);
            }
        }
    };
    private boolean jUB = true;
    private final View.OnFocusChangeListener iYP = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.iYR || view == WriteActivity.this.mBack || view == WriteActivity.this.iYW) {
                if (z) {
                    WriteActivity.this.jUB = true;
                    WriteActivity.this.czr();
                    l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.iYR);
                    if (WriteActivity.this.cFk != null) {
                        WriteActivity.this.cFk.asC();
                    }
                } else if (view == WriteActivity.this.iYR) {
                    WriteActivity.this.iYX.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.iYV && z) {
                WriteActivity.this.jUB = false;
                WriteActivity.this.czr();
                l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.iYV);
                if (WriteActivity.this.cFk != null) {
                    WriteActivity.this.cFk.asC();
                }
            }
            WriteActivity.this.czx();
        }
    };
    private TextWatcher jUC = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String jUG = "";
        private String jUH;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jUH = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jUH != null ? this.jUH.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.clj();
            WriteActivity.this.czy();
            EditText czJ = WriteActivity.this.czJ();
            if (editable != null && czJ != null && czJ.getText() != null) {
                if (this.jUG == null || !this.jUG.equals(editable.toString())) {
                    if (WriteActivity.this.jUw != null) {
                        this.jUG = czJ.getText().toString();
                        WriteActivity.this.jUw.m(czJ);
                        return;
                    }
                    return;
                }
                czJ.setSelection(czJ.getSelectionEnd());
            }
        }
    };
    private TextWatcher jUD = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String jUH;
        private String jUI = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jUH = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jUH != null ? this.jUH.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.clj();
            EditText czI = WriteActivity.this.czI();
            if (editable != null && czI != null && czI.getText() != null) {
                if (this.jUI == null || !this.jUI.equals(editable.toString())) {
                    if (WriteActivity.this.jUw != null) {
                        this.jUI = czI.getText().toString();
                        WriteActivity.this.jUw.m(czI);
                        return;
                    }
                    return;
                }
                czI.setSelection(czI.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0518a hXq = new a.InterfaceC0518a() { // from class: com.baidu.tieba.write.write.WriteActivity.31
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0518a
        public void onRefresh() {
            WriteActivity.this.hot = null;
            WriteActivity.this.rX(false);
            WriteActivity.this.cFk.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.mFrom)) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUCCES_IN_MISSON);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auA() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void auB() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            auD();
        } else if (this.cGP.cpb()) {
            auA();
        } else {
            this.cGP.qT(false);
            b(1, true, null);
            this.cGP.coZ();
        }
    }

    public void czS() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
            if (this.jUv != null) {
                this.jUv.cyv();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            auD();
        } else if (this.cGP != null) {
            this.cGP.qT(false);
            b(1, true, null);
            this.cGP.coZ();
        }
    }

    private void auD() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.hU(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.cGP.cpd();
                } else {
                    WriteActivity.this.cHd.auP();
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
        aVar.akO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int czq() {
        int selectionEnd = czI().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) czI().getText().getSpans(0, czI().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = czI().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = czI().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czr() {
        if (this.cFk != null) {
            this.cFk.setBarLauncherEnabled(!this.jUB);
            this.cFk.setBarLauncherEnabled(true, 26);
            this.cFk.setBarLauncherEnabled(true, 2);
            V(9, this.jUB ? false : true);
        }
    }

    private void V(int i, boolean z) {
        com.baidu.tbadk.editortools.g jI;
        if (this.cFk != null && (jI = this.cFk.jI(i)) != null) {
            if (z) {
                jI.le();
            } else {
                jI.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.jUr) {
            this.iYR.setVisibility(8);
            if (this.iYy.getType() == 5) {
                this.jVa.setVisibility(8);
            } else {
                this.jVa.setVisibility(0);
            }
            a(this.jVd, this.jUX);
            a(this.jVc, this.jVb);
            clj();
        }
        if (this.jUJ) {
            this.jUB = true;
            czr();
            if (this.cFk != null) {
                this.cFk.asC();
            }
            this.iYR.requestFocus();
            ShowSoftKeyPadDelay(this.iYR);
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
            cAh();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                czR();
            }
            rY(true);
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
        if (this.iYy.getType() == 0) {
            BN(this.apy);
        }
        initUI();
        czX();
        this.cGP = new LocationModel(this);
        this.cGP.a(this.cHd);
        registerListener(this.jkQ);
        registerListener(this.jUz);
        bLM();
        cAk();
        if (this.jUr) {
            this.jUW.setEditorTools(this.cFk);
        } else {
            this.iYV.requestFocus();
        }
        cgA();
        czR();
        cAi();
    }

    @SuppressLint({"ResourceAsColor"})
    private void bLM() {
        this.cFk = new EditorTools(getActivity());
        this.cFk.setBarMaxLauCount(5);
        this.cFk.setMoreButtonAtEnd(true);
        this.cFk.setBarBackgroundColorId(R.color.cp_bg_line_h);
        this.cFk.setBarLauncherType(1);
        this.cFk.fe(true);
        this.cFk.ff(true);
        switch (this.iYy.getType()) {
            case 4:
            case 5:
                czV();
                break;
            default:
                czs();
                break;
        }
        this.cFk.build();
        if (this.jTZ != null) {
            this.jTZ.addView(this.cFk);
        }
        czt();
        this.cFk.le();
        com.baidu.tbadk.editortools.g jI = this.cFk.jI(6);
        if (jI != null && !TextUtils.isEmpty(this.cGV)) {
            ((View) jI).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.cGV);
                }
            });
        }
        if (!this.jUr) {
            this.cFk.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.cFk.asC();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.cFk.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.cFk.b(new com.baidu.tbadk.editortools.a(2, 26, HanziToPinyin.Token.SEPARATOR));
        }
        czv();
    }

    private void czT() {
        this.jUY = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.jVa = this.jUY.findViewById(R.id.live_post_title_container);
        this.jUX = (EditText) this.jUY.findViewById(R.id.live_post_content);
        this.jUV = (GridView) this.jUY.findViewById(R.id.photoLiveGridView);
        this.jVb = (EditText) this.jUY.findViewById(R.id.live_post_title);
        this.jVc = (TextView) this.jUY.findViewById(R.id.titleOverPlusNumber);
        this.jVd = (TextView) this.jUY.findViewById(R.id.contentOverPlusNumber);
        this.jUZ = this.jUY.findViewById(R.id.live_interval_view);
        this.jVc.setText(String.valueOf(20));
        this.jVd.setText(String.valueOf(233));
        this.jUY.setVisibility(0);
        this.jVc.setVisibility(0);
        this.jVd.setVisibility(0);
        this.jVb.setHint(R.string.tips_title_limit_new);
        this.jVb.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.jVg = true;
                    WriteActivity.this.jUB = true;
                    WriteActivity.this.czr();
                    if (WriteActivity.this.cFk != null) {
                        WriteActivity.this.cFk.asC();
                    }
                }
            }
        });
        if (this.iYy.getType() == 4) {
            this.jUX.setHint(R.string.live_write_input_content_new);
        } else if (this.iYy.getType() == 5) {
            this.jUX.setHint(R.string.live_write_input_content_update);
        }
        this.jUX.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.jVg = false;
                    WriteActivity.this.jUB = false;
                    WriteActivity.this.czr();
                    if (WriteActivity.this.cFk != null) {
                        WriteActivity.this.cFk.asC();
                    }
                }
            }
        });
        this.jUX.requestFocus();
        this.jUX.addTextChangedListener(IW());
        this.jVb.requestFocus();
        this.jVb.addTextChangedListener(IW());
        this.jVb.setOnClickListener(this.jUA);
        this.jUX.setOnClickListener(this.jUA);
        this.jUW = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.jUV);
        this.jUW.BH(6);
        this.jUV.setAdapter((ListAdapter) this.jUW);
        View findViewById = this.jUY.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void czc() {
                WriteActivity.this.cAf();
            }
        });
        czU();
    }

    private void czU() {
        if (this.iYy.getType() == 0) {
            if (this.iYy.getTitle() != null) {
                this.jVb.setText(this.iYy.getTitle());
                this.jVb.setSelection(this.iYy.getTitle().length());
                return;
            }
            return;
        }
        if (this.iYy.getType() == 1 || this.iYy.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.jUr) {
            cAd();
        }
        if (this.cFk.aub()) {
            this.cFk.asC();
        }
        BN(0);
    }

    private void BN(int i) {
        if (this.writeImagesInfo != null && this.iYy != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.iYy.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.iYy.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.fVb);
            albumActivityConfig.setProfessionZone(this.iYy.getProZone());
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void czV() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.cFk.aC(arrayList);
        com.baidu.tbadk.editortools.k jL = this.cFk.jL(5);
        if (jL != null) {
            jL.cFV = 2;
        }
        this.cFk.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.cFk.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void czs() {
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        com.baidu.tbadk.editortools.k kVar3;
        com.baidu.tbadk.editortools.k kVar4;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.k kVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            this.cFk.b(dVar);
        }
        Boolean cAb = cAb();
        if (!this.jUJ && cAb != null && cAb.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.cpD() && r.b(this.iYy.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.k.class)) != null && (kVar5 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar5.cFV = 3;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.cFk.b(kVar5);
            }
        }
        this.cFk.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 4));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask2 != null && (kVar4 = (com.baidu.tbadk.editortools.k) runTask2.getData()) != null) {
            kVar4.cFV = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.cFk.b(kVar4);
            }
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask3 != null && (kVar3 = (com.baidu.tbadk.editortools.k) runTask3.getData()) != null) {
            kVar3.cFV = 6;
            kVar3.cFR = this.jUJ ? R.drawable.write_location : R.drawable.icon_post_more_location;
            this.cFk.b(kVar3);
        }
        this.cFk.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 7));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask4 != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
            kVar2.cFX = true;
            kVar2.cFV = 9;
            kVar2.cFR = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.cFk.b(kVar2);
            }
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask5 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask5.getData()) != null) {
            kVar.cFX = true;
            kVar.cFV = 10;
            kVar.cFR = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.cFk.b(kVar);
            }
        }
        if (this.jUf == null) {
            if (this.jUv == null) {
                this.jUv = new com.baidu.tieba.write.editor.b(getActivity(), this.fVb);
                this.jUv.bq(this.iYy.getForumId(), this.privateThread);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.jUv.cyr();
                this.jUv.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                czS();
            }
            this.cFk.b(this.jUv);
        }
        this.cFk.aC(arrayList);
        com.baidu.tbadk.editortools.k jL = this.cFk.jL(5);
        if (jL != null) {
            jL.cFV = 1;
        }
    }

    private void czu() {
        if (this.jUx != null) {
            this.jUx.hideTip();
        }
    }

    private void czv() {
        if (this.jUx == null) {
            this.jUx = new e(getPageContext());
        }
        this.jUx.c(this.cFk);
    }

    private void czt() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.czH()) {
                            WriteActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new an("c12612").O("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (aVar.data != null && (aVar.data instanceof p)) {
                            p pVar = (p) aVar.data;
                            if (pVar.apm() == EmotionGroupType.BIG_EMOTION || pVar.apm() == EmotionGroupType.USER_COLLECT) {
                                if (WriteActivity.this.mCurrentPermissionJudgePolicy == null) {
                                    WriteActivity.this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.c.a();
                                }
                                WriteActivity.this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
                                WriteActivity.this.mCurrentPermissionJudgePolicy.appendRequestPermission(WriteActivity.this, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!WriteActivity.this.mCurrentPermissionJudgePolicy.startRequestPermission(WriteActivity.this)) {
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
                                    WriteActivity.this.rY(true);
                                    WriteActivity.this.clj();
                                }
                            } else if (WriteActivity.this.czH()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(pVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.czK();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bTu();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.cAh();
                        WriteActivity.this.clj();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.BO(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new an("c12612").O("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.jUf == null) {
                            WriteActivity.this.auE();
                            return;
                        }
                        switch (WriteActivity.this.cGW) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.auB();
                                    return;
                                } else {
                                    ab.reuqestLocation(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.auA();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.cGP != null) {
                            WriteActivity.this.cGP.qT(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.hot = null;
                        } else {
                            WriteActivity.this.hot = (String) aVar.data;
                        }
                        WriteActivity.this.rX(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        an anVar = new an("c10645");
                        if (WriteActivity.this.iYy != null) {
                            str = WriteActivity.this.iYy.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.bS("fid", str);
                        TiebaStatic.log(anVar);
                        if (WriteActivity.this.iYy == null || (videoInfo = WriteActivity.this.iYy.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.cFk.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.cFk.aub()) {
                                        WriteActivity.this.cFk.asC();
                                        WriteActivity.this.cFk.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.cFk.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                        WriteActivity.this.cFk.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.cFk.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.cFk.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.iYy.setVideoInfo(null);
                        WriteActivity.this.clj();
                        if (WriteActivity.this.iYV != null) {
                            WriteActivity.this.iYV.requestFocus();
                        }
                        WriteActivity.this.cFk.asC();
                        WriteActivity.this.cFk.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iYV);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new an("c12612").O("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.cFk.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.jTX = true;
                        WriteActivity.this.rV(true);
                        if (!WriteActivity.this.czJ().isFocused() || WriteActivity.this.jUa.getVisibility() != 0) {
                            WriteActivity.this.jTW = "from_content";
                        } else {
                            WriteActivity.this.jTW = "from_title";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.jUa.setVisibility(0);
                        WriteActivity.this.jUa.requestFocus();
                        WriteActivity.this.clj();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.jUa.hasFocus()) {
                            WriteActivity.this.iYV.requestFocus();
                            WriteActivity.this.iYV.setSelection(WriteActivity.this.iYV.getText().toString().length());
                        }
                        WriteActivity.this.jUa.setVisibility(8);
                        WriteActivity.this.clj();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.cFk.setActionListener(16, bVar);
        this.cFk.setActionListener(14, bVar);
        this.cFk.setActionListener(24, bVar);
        this.cFk.setActionListener(3, bVar);
        this.cFk.setActionListener(10, bVar);
        this.cFk.setActionListener(11, bVar);
        this.cFk.setActionListener(12, bVar);
        this.cFk.setActionListener(13, bVar);
        this.cFk.setActionListener(15, bVar);
        this.cFk.setActionListener(18, bVar);
        this.cFk.setActionListener(20, bVar);
        this.cFk.setActionListener(25, bVar);
        this.cFk.setActionListener(27, bVar);
        this.cFk.setActionListener(29, bVar);
        this.cFk.setActionListener(43, bVar);
        this.cFk.setActionListener(45, bVar);
        this.cFk.setActionListener(53, bVar);
        this.cFk.setActionListener(48, bVar);
        this.cFk.setActionListener(46, bVar);
        this.cFk.setActionListener(49, bVar);
        this.cFk.setActionListener(47, bVar);
        this.cFk.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BO(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auE() {
        if (this.cGP.aWR()) {
            if (this.cGP.cpb()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.coW().getLocationData().coU());
                return;
            }
            b(1, true, null);
            this.cGP.coZ();
            return;
        }
        b(0, true, null);
    }

    protected void cla() {
        if (this.cGQ != null) {
            this.cGQ.cancelLoadData();
        }
        if (this.jUb != null) {
            this.jUb.cancelLoadData();
        }
        if (this.cGP != null) {
            this.cGP.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        czu();
        TiebaPrepareImageService.StopService();
        cla();
        cAa();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.jUU != null) {
            this.jUU.destroy();
        }
        if (this.jVu != null) {
            this.jVu.uP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czw() {
        if (this.iYy != null && this.iYy.getType() == 2 && this.jUQ) {
            finish();
        } else if (this.iYy == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.iYy.setTitle(czJ().getText().toString());
            this.iYy.setContent(czI().getText().toString());
            int type = this.iYy.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    v.c(this.iYy.getForumId(), this.iYy);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    v.c("24591571", this.iYy);
                }
            } else if (type == 1) {
                v.d(this.iYy.getThreadId(), this.iYy);
            } else if (type == 4) {
                v.c(this.iYy.getForumId() + "photolive", this.iYy);
            } else if (type == 5) {
                v.d(this.iYy.getThreadId() + "updatephotolive", this.iYy);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.iYY != null && this.iYY.isShowing()) {
                com.baidu.adp.lib.g.g.dismissPopupWindow(this.iYY, getPageContext().getPageActivity());
                return true;
            } else if (this.cFk.aub()) {
                this.cFk.asC();
                return true;
            } else {
                cla();
                czw();
                return true;
            }
        }
        if (i == 67 && (text = czI().getText()) != null) {
            int selectionStart = czI().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                czI().onKeyDown(67, this.fhx);
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
        getLayoutMode().onModeChanged(this.gze);
        getLayoutMode().onModeChanged(this.jVl);
        am.setBackgroundColor(this.gze, R.color.cp_bg_line_e);
        if (this.jVi != null && (i == 1 || i == 4)) {
            this.jVi.setBorderColor(am.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.iYW, R.color.cp_link_tip_a, 1);
        czr();
        am.setBackgroundColor(this.iYS, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.jUZ, R.color.cp_bg_line_c);
        am.setBackgroundColor(czJ(), R.color.cp_bg_line_e);
        am.setImageResource(this.hQA, R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.hot)) {
            am.setBackgroundColor(czI(), R.color.cp_bg_line_e);
        }
        clj();
        this.cFk.onChangeSkinType(i);
        if (this.jUp != null) {
            this.jUp.anO();
        }
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.jUU.jVR.notifyDataSetChanged();
        czx();
        czy();
        rX(false);
        if (this.jUw != null) {
            this.jUw.c(czJ(), czI());
        }
        this.jSi.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czx() {
        if (this.iYR.hasFocus()) {
            this.iYR.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.iYR.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.iYV.hasFocus()) {
            this.iYV.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.iYV.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czy() {
        if (this.iYR != null && this.iYR.getText() != null && this.iYR.getText().toString() != null && this.iYR.getPaint() != null) {
            if (this.iYR.getText().toString().length() == 0) {
                this.iYR.getPaint().setFakeBoldText(false);
            } else if (this.iYR.getText().toString().length() > 0) {
                this.iYR.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.cOA = new com.baidu.tbadk.core.view.b(getPageContext());
        this.jUr = this.iYy.getType() == 4 || 5 == this.iYy.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.amN().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.jUO = (TextView) findViewById(R.id.btn_image_problem);
        czA();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iYW.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.iYW.setLayoutParams(layoutParams);
        this.iYW.setOnFocusChangeListener(this.iYP);
        this.jUq = (ScrollView) findViewById(R.id.write_scrollview);
        this.jUq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.iYV != null) {
                        l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.iYV);
                    }
                    if (WriteActivity.this.cFk != null) {
                        WriteActivity.this.cFk.asC();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jUM = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.jUN = findViewById(R.id.feedback_divider);
        this.gze = (RelativeLayout) findViewById(R.id.parent);
        this.jTZ = (LinearLayout) findViewById(R.id.tool_view);
        this.jTZ.setContentDescription("..");
        this.jUa = (LinearLayout) findViewById(R.id.title_view);
        this.iYS = findViewById(R.id.interval_view);
        this.jVq = findViewById(R.id.hot_topic_fourm_view);
        this.jVr = findViewById(R.id.hot_topic_divider);
        this.jUt = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.jVs = (TextView) findViewById(R.id.change_one_tv);
        cli();
        if (this.jUr) {
            this.jUq.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            czT();
        } else {
            this.jUU = new g(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.jUU.rQ(false);
            } else {
                g gVar = this.jUU;
                if (this.iYy.getType() != 0 && this.iYy.getType() != 9) {
                    z = false;
                }
                gVar.rQ(z);
            }
        }
        clk();
        if (this.jUJ || this.jTY) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().ckG) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.iYU = (LinearLayout) findViewById(R.id.post_content_container);
        this.iYU.setDrawingCacheEnabled(false);
        this.iYU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.cFk.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.iYV.requestFocus();
            }
        });
        this.hQx = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.hQy = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.hQA = (ImageView) findViewById(R.id.iv_delete_voice);
        this.hQA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bTu();
            }
        });
        this.mBack.setOnFocusChangeListener(this.iYP);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cla();
                WriteActivity.this.czw();
            }
        });
        this.jUO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        czD();
        k(cAb());
        czF();
        czz();
        czY();
        czZ();
        czr();
        czE();
        clh();
        czL();
        if (this.iYy.getType() == 4 && this.iZa != null && this.jUc != null) {
            this.iZa.setVisibility(8);
            this.jUc.setVisibility(8);
        }
        clj();
        czW();
        cyJ();
    }

    private void cyJ() {
        this.jSi = new com.baidu.tieba.write.b.c(getPageContext().getPageActivity(), this.mName, this.iYy.getProZone(), isUseStyleImmersiveSticky() ? StatusBarUtil.getStatusBarOffsetPx(getPageContext().getPageActivity()) : 0);
        this.jSi.a(new c.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // com.baidu.tieba.write.b.c.a
            public void BC(int i) {
                WriteActivity.this.iYy.setProZone(i);
            }
        });
        this.jSi.bet();
    }

    private void czz() {
        String str;
        String str2;
        if (this.iYy != null) {
            switch (this.iYy.getType()) {
                case 0:
                case 9:
                    if (this.jUJ || this.jTY) {
                        if (this.jUK) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.fVb != null && this.fVb.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                    } else if (this.fVb != null && this.fVb.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.iYy.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.iYy.getForumName() + getResources().getString(R.string.bar));
                        this.iYR.setVisibility(8);
                        String str3 = this.ftB + HanziToPinyin.Token.SEPARATOR + this.ftz;
                        if (!StringUtils.isNull(str3)) {
                            this.iYV.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.iYR.setVisibility(0);
                    this.iYV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.iYV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.iYR.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.iYV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.iYy.getFloorNum() + 1)));
                    this.jUZ.setVisibility(8);
                    return;
                case 7:
                    this.iYR.setVisibility(0);
                    this.iYV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void czA() {
        if (this.iYy.getType() == 7) {
            this.iYW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.iYW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void czB() {
        if (this.iYy != null && this.iYy.getType() == 0 && this.iYy.getType() == 9 && !this.jUJ && !this.jTY && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = aq.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && czJ() != null) {
                czJ().setText(cutStringWithSuffix);
                czJ().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.hQx.setVisibility(0);
            this.hQy.setVoiceModel(voiceModel);
            this.hQy.cpC();
            clj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTu() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.hQx.setVisibility(8);
        this.hQy.bur();
        this.hQy.setVoiceModel(null);
        com.baidu.tbadk.editortools.k jL = this.cFk.jL(6);
        if (jL != null && jL.cFe != null) {
            jL.cFe.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        clj();
    }

    private void czC() {
        this.jUk = null;
        this.jUm = -1;
        this.jUo = -1;
        x qI = w.blC().qI(1);
        if (qI != null) {
            this.jUk = qI.fzd;
            this.jUm = getIntent().getIntExtra("category_id", -1);
            if (this.jUk != null && !this.jUk.isEmpty() && this.jUm >= 0) {
                this.jUl = new com.baidu.tieba.frs.v();
                this.jUl.fyZ = 0;
                this.jUl.name = getPageContext().getResources().getString(R.string.category_auto);
                this.jUo = this.jUl.fyZ;
                this.jUn = this.jUl.name;
                for (com.baidu.tieba.frs.v vVar : this.jUk) {
                    if (vVar.fyZ == this.jUm) {
                        this.jUo = vVar.fyZ;
                        this.jUn = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void czD() {
        if (this.jUk != null && !this.jUk.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.jUp = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.jUp.setText(this.jUn);
            this.jUp.setCategoryContainerData(this.jUk, this.jUl, this.jUo);
            this.jUp.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ar arVar) {
                    if (arVar != null) {
                        WriteActivity.this.jUp.setText(arVar.name);
                        WriteActivity.this.iYy.setCategoryTo(arVar.fyZ);
                        WriteActivity.this.jUo = arVar.fyZ;
                        WriteActivity.this.jUp.cze();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.jUp.czd();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.czJ());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.czI());
                }
            });
        }
    }

    private void czW() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.jUE = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.jUE.setTitle(R.string.no_disturb_start_time);
        this.jUE.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.jUE);
        this.jUE.setButton(-2, getPageContext().getString(R.string.cancel), this.jUE);
        return this.jUE;
    }

    private void czE() {
        this.jUg = (RelativeLayout) findViewById(R.id.addition_container);
        this.jUh = (TextView) findViewById(R.id.addition_create_time);
        this.jUi = (TextView) findViewById(R.id.addition_last_time);
        this.jUj = (TextView) findViewById(R.id.addition_last_content);
        if (this.jUf != null) {
            this.jUg.setVisibility(0);
            this.jUh.setText(getPageContext().getString(R.string.write_addition_create) + aq.getFormatTime(this.jUf.getCreateTime() * 1000));
            if (this.jUf.getAlreadyCount() == 0) {
                this.jUi.setVisibility(8);
            } else {
                this.jUi.setText(getPageContext().getString(R.string.write_addition_last) + aq.getFormatTime(this.jUf.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.jUf.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.jUj.setText(lastAdditionContent);
            } else {
                this.jUj.setVisibility(8);
            }
            czI().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.jUf.getAlreadyCount()), Integer.valueOf(this.jUf.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.jUg.setVisibility(8);
    }

    private void clh() {
        this.iZa = findViewById(R.id.post_prefix_layout);
        if (this.jVu == null) {
            this.jVu = new com.baidu.tieba.c.d(getPageContext(), this.iZa);
            this.jVu.bB(R.drawable.bg_tip_blue_up_left);
            this.jVu.bA(16);
            this.jVu.iX(true);
            this.jVu.setUseDirectOffset(true);
            this.jVu.ph(l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.iYX = (TextView) findViewById(R.id.post_prefix);
        this.jUc = findViewById(R.id.prefix_divider);
        this.iYZ = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.iZa.setVisibility(0);
            this.jVu.c(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iYz = 0;
            this.iZa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").bS("fid", WriteActivity.this.iYy.getForumId()).p("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.iYX.setVisibility(0);
                    WriteActivity.this.iZa.setSelected(true);
                    am.setImageResource(WriteActivity.this.iYZ, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.iYY, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.cFk.asC();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iYR);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.iYV);
                }
            });
            this.iYX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").bS("fid", WriteActivity.this.iYy.getForumId()).p("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.iYX.setSelected(true);
                    am.setImageResource(WriteActivity.this.iYZ, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.iYY, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.cFk.asC();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.czJ());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.czI());
                }
            });
            this.iYY = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.iYY.a(this);
            this.iYY.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.iYY.setOutsideTouchable(true);
            this.iYY.setFocusable(true);
            this.iYY.setOnDismissListener(this);
            this.iYY.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            am.getColor(R.color.cp_cont_c);
            am.setBackgroundResource(this.iYX, R.color.cp_bg_line_d);
            am.setImageResource(this.iYZ, R.drawable.icon_arrow_gray_down);
            this.iYX.setTextColor(color);
            this.jUd.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.jUd.add(writePrefixItemLayout);
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
                this.iYY.addView(writePrefixItemLayout);
            }
            this.iYY.setCurrentIndex(0);
            this.iYX.setText(prefixs.get(0));
            BM(0);
            return;
        }
        this.iZa.setVisibility(8);
    }

    private void czX() {
        if (this.jUJ && this.iYy != null) {
            this.jUM.setVisibility(0);
            this.jUN.setVisibility(0);
            this.jUb = new FeedBackModel(getPageContext());
            this.jUb.FN(this.iYy.getForumName());
            this.jUb.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.24
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.jUM.setVisibility(8);
                        WriteActivity.this.jUN.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.jUM.setVisibility(8);
                        WriteActivity.this.jUN.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.jUM.a(feedBackModel.czg(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void czF() {
        this.iYW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (WriteActivity.this.jUw.a(WriteActivity.this.iYR, WriteActivity.this.iYV)) {
                        WriteActivity.this.showToast(WriteActivity.this.jUw.cxC());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.czJ());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.czI());
                    WriteActivity.this.cFk.asC();
                    if (WriteActivity.this.iYy.getType() != 7) {
                        if (WriteActivity.this.jUJ) {
                            WriteActivity.this.czO();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            an anVar = new an("c12102");
                            anVar.O("obj_type", StringUtils.isNull(WriteActivity.this.iYy.getForumName()) ? 1 : 2);
                            TiebaStatic.log(anVar);
                            WriteActivity.this.czP();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.czO();
                    }
                    TiebaStatic.log(new an("c12262").bS("obj_locate", WriteActivity.this.fVb));
                }
            }
        });
    }

    protected void czY() {
        this.jUP = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.jUP.nn(getPageContext().getString(R.string.is_save_draft)).eg(false).a(getPageContext().getString(R.string.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.iYy.setTitle(WriteActivity.this.czJ().getText().toString());
                WriteActivity.this.iYy.setContent(WriteActivity.this.czI().getText().toString());
                int type = WriteActivity.this.iYy.getType();
                if (type == 0 || type == 9) {
                    v.c(WriteActivity.this.iYy.getForumId(), WriteActivity.this.iYy);
                } else if (type == 1) {
                    v.d(WriteActivity.this.iYy.getThreadId(), WriteActivity.this.iYy);
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
                int type = WriteActivity.this.iYy.getType();
                if (type == 0 || type == 9) {
                    v.c(WriteActivity.this.iYy.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    v.d(WriteActivity.this.iYy.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.jUP.b(getPageContext());
    }

    protected void cli() {
        this.jUL = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.jUL.setIsRound(true);
        this.jUL.setDrawBorder(false);
        this.jUL.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String nK = o.nK(currentPortrait);
            this.jUL.setUrl(nK);
            this.jUL.startLoad(nK, 12, false);
        }
        if (this.iYy.isUserFeedback()) {
            this.jUL.setVisibility(0);
        }
        this.iYR = (EditText) findViewById(R.id.post_title);
        this.iYR.setOnClickListener(this.jUA);
        this.iYR.setOnFocusChangeListener(this.iYP);
        if (this.iYy.getType() == 0 || this.iYy.getType() == 9 || this.iYy.getType() == 7) {
            if (this.iYy.getTitle() != null) {
                this.iYR.setText(this.iYy.getTitle());
                this.iYR.setSelection(this.iYy.getTitle().length());
            } else if (this.jUK) {
                this.iYR.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.iYy.getType() == 1 || this.iYy.getType() != 2) {
        }
        this.iYR.addTextChangedListener(this.jUC);
        if (!this.iYy.getHaveDraft()) {
            czB();
            this.jVp = true;
        }
        if (this.iYy.isUserFeedback()) {
            this.iYR.setHint(getResources().getString(R.string.feedback_title_hint));
        } else {
            this.iYR.setHint(getResources().getString(R.string.post_title_hint));
        }
    }

    private TextWatcher IW() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            private int jVy;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.clj();
                if (WriteActivity.this.jUr) {
                    this.jVy = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.jVy);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.jUr || !WriteActivity.this.jVg) {
                    if (WriteActivity.this.jUr) {
                        if (this.mEditText != WriteActivity.this.jUX || this.mTextView != WriteActivity.this.jVd) {
                            this.mEditText = WriteActivity.this.jUX;
                            this.mTextView = WriteActivity.this.jVd;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.jVb || this.mTextView != WriteActivity.this.jVc) {
                    this.mEditText = WriteActivity.this.jVb;
                    this.mTextView = WriteActivity.this.jVc;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.jUr && this.jVg) {
            if (this.jVe != null) {
                this.jVb.removeTextChangedListener(this.jVe);
            }
            this.jVe = textWatcher;
        } else if (this.jUr) {
            if (this.jVf != null) {
                this.jUX.removeTextChangedListener(this.jVf);
            }
            this.jVf = textWatcher;
        }
        return textWatcher;
    }

    private long n(EditText editText) {
        if (editText == this.jUX) {
            return 233L;
        }
        if (editText != this.jVb) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long n = n(editText);
            long o = n - o(editText);
            String valueOf = String.valueOf(o);
            if (n == 20) {
                if (o < 0) {
                    if (o < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(am.getColor(R.color.common_color_10159));
                } else {
                    textView.setTextColor(am.getColor(R.color.cp_cont_d));
                }
            } else if (o < 0) {
                if (o < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(am.getColor(R.color.common_color_10159));
            } else {
                textView.setTextColor(am.getColor(R.color.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long o(EditText editText) {
        return com.baidu.tieba.write.c.a.l(editText.getText().toString().trim());
    }

    protected void clk() {
        this.iYV = (EditText) findViewById(R.id.post_content);
        this.iYV.setDrawingCacheEnabled(false);
        this.iYV.setOnClickListener(this.jUA);
        if (this.iYy.getContent() != null && this.iYy.getContent().length() > 0) {
            SpannableString ah = TbFaceManager.avt().ah(getPageContext().getPageActivity(), this.iYy.getContent());
            this.iYV.setText(ah);
            this.iYV.setSelection(ah.length());
        } else if (this.iYy.getType() == 2) {
            if (this.jUQ) {
                if (this.jUR != null && this.jUR.length() > 0) {
                    this.iYV.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.jUR}));
                    this.iYV.setSelection(this.iYV.getText().length());
                }
            } else if (this.iYy.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.iYy.getFloorNum()));
                this.iYV.setText(format);
                this.iYV.setSelection(format.length());
            }
        }
        this.iYV.setOnFocusChangeListener(this.iYP);
        this.iYV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.cFk.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.iYV.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iYV.addTextChangedListener(this.jUD);
        if (this.iYy.getType() == 0) {
            this.jVt = true;
        } else {
            rX(true);
            this.jVt = false;
        }
        if (this.iYy.isUserFeedback()) {
            this.iYV.setHint(R.string.write_input_content);
        } else {
            this.iYV.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void rX(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.jUr) {
            czI().setPadding(0, 0, 0, 0);
            czI().setBackgroundDrawable(null);
            am.setBackgroundColor(czI(), R.color.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.hot) && this.jUf == null) {
                com.baidu.adp.lib.f.c.fT().a(this.hot, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.30
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass30) aVar, str, i);
                        if (aVar != null && aVar.getRawBitmap() != null && aVar.getPadding() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.czI().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.czI(), true, WriteActivity.this.hXq);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean czH() {
        int i = 5000;
        if (this.jUf != null) {
            i = 1000;
        }
        return czI().getText() != null && czI().getText().length() >= i;
    }

    private void pF(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.jTW)) {
                this.jTW = "";
                czI().requestFocus();
                if (czI().getText() != null && czI().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = czI().getSelectionStart();
                    editable = czI().getText();
                }
            } else if ("from_title".equals(this.jTW)) {
                this.jTW = "";
                czJ().requestFocus();
                if (czJ().getText() != null && czJ().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = czJ().getSelectionStart();
                    editable = czJ().getText();
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
    public void rV(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.iYy != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.toLong(this.iYy.getForumId(), 0L), this.iYy.getFirstDir(), this.iYy.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(p pVar) {
        if (((ImageSpan[]) czI().getText().getSpans(0, czI().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.jUe == null) {
                this.jUe = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            this.jUe.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType apm = pVar.apm();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.fT().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.32
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass32) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.czI().getSelectionStart(), aVar, apm);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && czI() != null && czI().getText() != null) {
            Bitmap rawBitmap = aVar.getRawBitmap();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(rawBitmap);
            int width = rawBitmap.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, rawBitmap.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.g(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = czI().getSelectionStart() - 1;
                if (czI().getText().length() > 1 && selectionStart >= 0 && czI().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    czI().getText().insert(czI().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            czI().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                czI().getText().insert(czI().getSelectionStart(), spannableString2);
            }
            Editable text = czI().getText();
            if (text != null) {
                this.jUu.clear();
                this.jUu.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jUu);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && czI().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    czI().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                czI().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText czI() {
        return this.jUr ? this.jUX : this.iYV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText czJ() {
        return this.jUr ? this.jVb : this.iYR;
    }

    protected void czK() {
        Editable text;
        if (czI() != null && (text = czI().getText()) != null) {
            int selectionStart = czI().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                czI().onKeyDown(67, this.fhx);
            }
            czI().onKeyDown(67, this.fhx);
            int selectionStart2 = czI().getSelectionStart();
            if (text != null) {
                this.jUu.clear();
                this.jUu.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jUu);
                czI().setSelection(selectionStart2);
            }
        }
    }

    private void k(Boolean bool) {
        String str = null;
        if (this.iYy != null) {
            str = this.iYy.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.jUJ = true;
        }
    }

    private void czZ() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void cAa() {
        try {
            if (this.jUP != null) {
                this.jUP.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.cOA.setCancelListener(null);
        this.cOA.setTipString(R.string.sending);
        this.cOA.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.cOA.setDialogVisiable(false);
    }

    private Boolean cAb() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.cGV = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void clj() {
        if (this.iYy != null) {
            String str = "";
            String str2 = "";
            if (czJ() != null) {
                str = czJ().getText().toString();
            }
            if (czI() != null) {
                str2 = czI().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.iYy.getType() == 0 || this.iYy.getType() == 9 || this.iYy.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.iYz == com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.iYy.setIsNoTitle(true);
                        } else if (this.jUa.getVisibility() == 0) {
                            this.iYy.setIsNoTitle(false);
                            rW(true);
                            return;
                        }
                    } else if (this.jUa.getVisibility() == 0) {
                        this.iYy.setIsNoTitle(false);
                        rW(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.iYy.setIsNoTitle(true);
                } else if (this.jUa.getVisibility() == 0) {
                    this.iYy.setIsNoTitle(false);
                    rW(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.jUr) {
                    rW(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    rW(true);
                }
            }
            if (this.iYy.getType() == 4) {
                rW(q(this.jUX) && p(this.jVb));
            } else if (this.iYy.getType() == 5) {
                rW(q(this.jUX));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                rW(true);
            } else if (this.iYy.getVideoInfo() != null) {
                rW(true);
            } else {
                rW(false);
            }
        }
    }

    public void rW(boolean z) {
        if (z) {
            am.setNavbarTitleColor(this.iYW, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.iYW.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.iYW, R.color.cp_cont_d, 1);
        this.iYW.setEnabled(false);
    }

    private boolean p(EditText editText) {
        long o = o(editText);
        return o <= 20 && o > 0;
    }

    private boolean q(EditText editText) {
        long o = o(editText);
        if (o > 233) {
            return false;
        }
        return o > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        String stringExtra;
        this.cGQ = new NewWriteModel(this);
        this.cGQ.b(this.cHf);
        registerListener(this.jVv);
        this.fms = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.cla();
            }
        };
        this.iYy = new WriteData();
        if (bundle != null) {
            this.iYy.setType(bundle.getInt("type", 0));
            this.iYy.setForumId(bundle.getString("forum_id"));
            this.iYy.setForumName(bundle.getString("forum_name"));
            this.iYy.setFirstDir(bundle.getString("forum_first_dir"));
            this.iYy.setSecondDir(bundle.getString("forum_second_dir"));
            this.iYy.setThreadId(bundle.getString("thread_id"));
            this.iYy.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.iYy.setFloorNum(bundle.getInt("floor_num", 0));
            this.jUJ = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.jUK = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.jUQ = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.jUR = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.cGO = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.jUf = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.iYy.setIsAddition(this.jUf != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.jUS = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.iYy.setTitle(bundle.getString("write_title"));
            this.iYy.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.iYy.setTopicId(this.mTopicId);
            this.fVb = bundle.getString("KEY_CALL_FROM");
            this.apy = bundle.getInt("album_thread");
            stringExtra = string;
        } else {
            Intent intent = getIntent();
            this.iYy.setType(intent.getIntExtra("type", 0));
            this.iYy.setForumId(intent.getStringExtra("forum_id"));
            this.iYy.setForumName(intent.getStringExtra("forum_name"));
            this.iYy.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.iYy.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.iYy.setThreadId(intent.getStringExtra("thread_id"));
            this.iYy.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.iYy.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.jUJ = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.jUK = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.jUQ = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.jUR = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.jUf = (AdditionData) intent.getSerializableExtra("addition_data");
            this.iYy.setIsAddition(this.jUf != null);
            this.iYy.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.jUS = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.ftA = intent.getStringExtra("more_forum_img");
            this.ftB = intent.getStringExtra("more_forum_title");
            this.ftz = intent.getStringExtra("more_forum_url");
            this.iYy.setTitle(intent.getStringExtra("write_title"));
            this.iYy.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.iYy.setTopicId(this.mTopicId);
            this.fVb = intent.getStringExtra("KEY_CALL_FROM");
            this.apy = intent.getIntExtra("album_thread", 0);
            stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
        }
        if (this.iYy.getType() == 9) {
            this.iYy.setEntranceType(1);
        } else if (this.iYy.getType() == 10) {
            this.iYy.setEntranceType(2);
            this.iYy.setType(9);
        } else if (this.iYy.getType() == 0) {
            this.iYy.setEntranceType(3);
        }
        this.iYy.setIsUserFeedback(this.jUJ);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (stringExtra != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.iYy.getType() == 4 ? 6 : 9);
        this.iYy.setWriteImagesInfo(this.writeImagesInfo);
        if (this.iYy.getType() == 0 || this.iYy.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                v.c(this.iYy.getForumId(), this);
            }
        } else if (this.iYy.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                v.c("24591571", this);
            }
        } else if (this.iYy.getType() == 1) {
            v.a(this.iYy.getThreadId(), this);
        } else if (this.iYy.getType() == 4) {
            v.c(this.iYy.getForumId() + "photolive", this);
        } else if (this.iYy.getType() == 5) {
            v.a(this.iYy.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.hot = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.iYy != null && this.iYy.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.iYy.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.jTY = true;
        }
        czC();
        try {
            this.jVh = cAj();
        } catch (Throwable th) {
            this.jVh = null;
        }
    }

    private void czL() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.iYR.setText(com.baidu.tbadk.plugins.b.qf(com.baidu.tbadk.plugins.b.qg(hotTopicBussinessData.mTopicName)));
            this.iYR.setMovementMethod(com.baidu.tieba.view.c.cwP());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString qf = com.baidu.tbadk.plugins.b.qf(com.baidu.tbadk.plugins.b.qg(hotTopicBussinessData.mTopicName));
            if (qf != null) {
                this.iYR.setText(qf);
            }
            this.jUt.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.v.a
    public void a(WriteData writeData) {
        String str;
        String qg;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            if (writeData != null) {
                if (this.iYy != null) {
                    this.iYy.setHaveDraft(true);
                    if (com.baidu.adp.lib.util.k.isEmpty(czJ().getText().toString()) || this.jVp || ((this.jUJ || this.jTY) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                        if (com.baidu.adp.lib.util.k.isEmpty(this.iYy.getTitle())) {
                            this.iYy.setTitle(writeData.getTitle());
                        }
                        if (!com.baidu.tbadk.core.util.v.isEmpty(this.mList)) {
                            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.getItem(this.mList, 0);
                            if (hotTopicBussinessData == null) {
                                str = null;
                            } else {
                                str = hotTopicBussinessData.mTopicName;
                            }
                            if (StringUtils.isNull(str)) {
                                qg = this.iYy.getTitle();
                            } else {
                                qg = com.baidu.tbadk.plugins.b.qg(str);
                            }
                            SpannableString qf = com.baidu.tbadk.plugins.b.qf(qg);
                            if (qf != null) {
                                czJ().setText(qf);
                                czJ().setSelection(qf.length() > qg.length() ? qg.length() : qf.length());
                            }
                        } else {
                            SpannableString qf2 = com.baidu.tbadk.plugins.b.qf(this.iYy.getTitle());
                            if (qf2 != null) {
                                czJ().setText(qf2);
                                czJ().setSelection(this.iYy.getTitle().length() > qf2.length() ? qf2.length() : this.iYy.getTitle().length());
                            }
                        }
                    }
                    if (this.iYy != null && !this.iYy.getHaveDraft()) {
                        czB();
                    }
                    if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.copy(writeData.getVideoInfo());
                        this.iYy.setVideoInfo(videoInfo);
                        this.cFk.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                    }
                    if ((com.baidu.adp.lib.util.k.isEmpty(czI().getText().toString()) || this.jUJ || this.jTY) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                        this.iYy.setContent(writeData.getContent());
                        SpannableString a2 = TbFaceManager.avt().a(getPageContext().getPageActivity(), this.iYy.getContent(), this.jUy);
                        czI().setText(a2);
                        czI().setSelection(a2.length());
                        if (this.jUr) {
                            a(this.jVd, this.jUX);
                        }
                    }
                    if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                        this.writeImagesInfo = writeData.getWriteImagesInfo();
                        this.iYy.setWriteImagesInfo(this.writeImagesInfo);
                        cAh();
                        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                            czR();
                        }
                        rY(false);
                    }
                    if (writeData.getType() == 4 || writeData.getType() == 5) {
                        cAc();
                    }
                    clj();
                    int categoryTo = writeData.getCategoryTo();
                    if (categoryTo >= 0 && this.jUk != null) {
                        this.jUo = this.jUl.fyZ;
                        this.jUn = this.jUl.name;
                        int i = 0;
                        while (true) {
                            if (i == this.jUk.size()) {
                                break;
                            }
                            com.baidu.tieba.frs.v vVar = this.jUk.get(i);
                            if (categoryTo != vVar.fyZ) {
                                i++;
                            } else {
                                this.jUo = categoryTo;
                                this.jUn = vVar.name;
                                this.iYy.setCategoryTo(this.jUo);
                                break;
                            }
                        }
                        if (this.jUp != null) {
                            this.jUp.setText(this.jUn);
                            this.jUp.setCategoryContainerData(this.jUk, this.jUl, this.jUo);
                        }
                    }
                    this.cFk.asC();
                    return;
                }
                return;
            }
            cAc();
            czB();
        }
    }

    private void cAc() {
        if ((!this.jUr || this.jUW != null) && this.jUV != null) {
            this.jUW.b(this.writeImagesInfo);
            cAf();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.iYy.getType());
        bundle.putString("forum_id", this.iYy.getForumId());
        bundle.putString("forum_name", this.iYy.getForumName());
        bundle.putString("forum_first_dir", this.iYy.getFirstDir());
        bundle.putString("forum_second_dir", this.iYy.getSecondDir());
        bundle.putString("thread_id", this.iYy.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.iYy.getFloor());
        bundle.putInt("floor_num", this.iYy.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.jUQ);
        if (this.jUJ) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.cGO);
        if (this.jUf != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.jUf));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.jUS);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.fVb);
        bundle.putInt("album_thread", this.apy);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = czI().getEditableText().toString();
        if (obj != null) {
            czI().setText(TbFaceManager.avt().a(getPageContext().getPageActivity(), obj, this.jUy));
            czI().setSelection(czI().getText().length());
        }
    }

    private String czM() {
        return (czI() == null || czI().getText() == null) ? "" : czI().getText().toString();
    }

    private String czN() {
        if (this.iYy == null || czJ() == null || czJ().getVisibility() != 0 || czJ().getText() == null) {
            return "";
        }
        String obj = czJ().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) > 0 && this.iYz != com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) - 1 && this.iYy.getType() != 4 && this.iYX != null && this.iYX.getText() != null) {
            this.iYy.setPostPrefix(this.iYX.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.iYy.getTitle();
        }
        return obj;
    }

    private void FO(String str) {
        if (this.iYy != null && this.jUa != null) {
            if (this.jUa.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.iYy.setIsNoTitle(true);
                    this.iYy.setTitle("");
                    return;
                }
                this.iYy.setIsNoTitle(false);
                this.iYy.setTitle(str);
                return;
            }
            this.iYy.setIsNoTitle(true);
            this.iYy.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czO() {
        cla();
        this.iYy.setContent(czM());
        FO(czN());
        if (this.jUJ || this.jTY) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.iYy.getTitle()) || !this.iYy.getTitle().startsWith(string)) {
                FO(string + this.iYy.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.iYy.getContent()) || !this.iYy.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    sb.append(com.baidu.adp.lib.util.j.netTypeNameInUpperCase());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.iYy.getContent());
                this.iYy.setContent(sb.toString());
            }
        }
        if (this.jUm >= 0) {
            this.iYy.setCategoryFrom(this.jUm);
        }
        if (this.jUo >= 0) {
            this.iYy.setCategoryTo(this.jUo);
        }
        this.iYy.setWriteImagesInfo(this.writeImagesInfo);
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
            this.iYy.setTakePhotoNum(i);
        }
        this.iYy.setHasLocationData(this.cGP != null && this.cGP.aWR());
        if (this.writeImagesInfo != null) {
            this.cGQ.qV(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.mList) && this.jUs != null && this.jUs.mIsGlobalBlock == 0) {
            this.iYy.setForumId(String.valueOf(this.jUs.mForumId));
            this.iYy.setForumName(this.jUs.mForumName);
        }
        this.cGQ.d(this.iYy);
        this.iYy.setContent(this.iYy.getContent().replaceAll("\u0000\n", ""));
        this.iYy.setContent(this.iYy.getContent().replaceAll("\u0000", ""));
        this.iYy.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.cGQ.clc().setVoice(this.mVoiceModel.getId());
                this.cGQ.clc().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.cGQ.clc().setVoice(null);
                this.cGQ.clc().setVoiceDuringTime(-1);
            }
        } else {
            this.cGQ.clc().setVoice(null);
            this.cGQ.clc().setVoiceDuringTime(-1);
        }
        if (!this.cGQ.cpH()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.fms);
            this.cGQ.cpE();
        }
    }

    private void B(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.jUf != null) {
                i2 = this.jUf.getTotalCount();
                i = this.jUf.getAlreadyCount() + 1;
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
                if (this.iYR == getCurrentFocus()) {
                    czI().clearFocus();
                    this.iYR.requestFocus();
                    if (this.cFk != null) {
                        this.cFk.asC();
                    }
                    ShowSoftKeyPadDelay(this.iYR);
                } else {
                    czI().requestFocus();
                    if (this.cFk != null) {
                        this.cFk.asC();
                    }
                    ShowSoftKeyPadDelay(this.iYV);
                }
                ArrayList<String> stringArrayListExtra = intent != null ? intent.getStringArrayListExtra("name_show") : null;
                if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < stringArrayListExtra.size()) {
                            sb.append("@");
                            sb.append(stringArrayListExtra.get(i4));
                            sb.append(HanziToPinyin.Token.SEPARATOR);
                            i3 = i4 + 1;
                        } else {
                            czI().getText().insert(czI().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.iYy.getType() == 0 || this.iYy.getType() == 9) {
                    v.c(this.iYy.getForumId(), (WriteData) null);
                    if (postWriteCallBackData2 != null) {
                    }
                } else if (this.iYy.getType() == 1) {
                    v.d(this.iYy.getThreadId(), (WriteData) null);
                }
                k(postWriteCallBackData2);
                setResult(-1, intent);
                finish();
            } else if (i != 12010 && i != 12009) {
                if (i == 12002) {
                    if (intent != null) {
                        if (intent.getBooleanExtra("finish_self", false)) {
                            finish();
                            return;
                        }
                        int intExtra = intent.getIntExtra("camera_request_from", 0);
                        if (intent.getBooleanExtra("camera_result", false)) {
                            if (intExtra == 1) {
                                cAg();
                            } else {
                                aK(intent);
                            }
                        } else if (intExtra == 1) {
                            aL(intent);
                        } else {
                            aI(intent);
                            com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.jVt) {
                            rX(true);
                            this.jVt = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.jUr) {
                        X(intent);
                        clj();
                        return;
                    }
                    aJ(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.iYy.setVideoInfo(videoInfo);
                        this.cFk.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                        this.cFk.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.cFk.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    clj();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.jTX) {
                                sb2.append(com.baidu.tbadk.plugins.b.cNU);
                                this.jTX = false;
                            }
                            sb2.append(stringExtra);
                            pF(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.isEmpty(this.mList) && !com.baidu.tbadk.core.util.v.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                    this.jUs = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                    a(this.jUs);
                }
            }
        } else if (i2 == 0) {
            if (this.cFk != null && !this.cFk.aub()) {
                this.iYV.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.cFk.asC();
            }
            switch (i) {
                case 12001:
                    auH();
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    cAe();
                    if (this.jVt) {
                        rX(true);
                        this.jVt = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.iYR == getCurrentFocus()) {
                        czI().clearFocus();
                        this.iYR.requestFocus();
                        if (this.cFk != null) {
                            this.cFk.asC();
                        }
                        ShowSoftKeyPadDelay(this.iYR);
                        return;
                    }
                    czI().requestFocus();
                    if (this.cFk != null) {
                        this.cFk.asC();
                    }
                    ShowSoftKeyPadDelay(this.iYV);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.jUw.Fv(postWriteCallBackData.getErrorString());
                        this.jUw.aM(postWriteCallBackData.getSensitiveWords());
                        this.jUw.b(this.iYR, this.iYV);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.cGO = String.valueOf(System.currentTimeMillis());
                    al.a(getPageContext(), this.cGO);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    cAe();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.jTW)) {
                        czJ().requestFocus();
                        return;
                    } else if ("from_content".equals(this.jTW)) {
                        czI().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czP() {
        if ("1".equals(this.fVb)) {
            this.iYy.setCanNoForum(true);
            this.iYy.setTransmitForumData("[]");
        } else if ("2".equals(this.fVb)) {
            this.iYy.setCanNoForum(false);
        }
        czQ();
        this.iYy.setPrivacy(this.isPrivacy);
        this.iYy.setCallFrom(this.fVb);
        if (this.iYy.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        czO();
    }

    private void czQ() {
        if (this.cFk != null) {
            this.cFk.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void cAd() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void cAe() {
        if (this.jUr) {
            this.jUW.b(this.writeImagesInfo);
            cAf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAf() {
        this.jUW.notifyDataSetChanged();
        this.jUV.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.jUW.notifyDataSetChanged();
                WriteActivity.this.jUV.invalidateViews();
            }
        }, 550L);
    }

    public void q(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        clj();
    }

    private void aI(Intent intent) {
        if (this.jUr) {
            aJ(intent);
            cAe();
        } else {
            aM(intent);
        }
        clj();
    }

    private void aJ(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            cAe();
            rY(true);
        }
    }

    private void aK(Intent intent) {
        if (this.writeImagesInfo != null) {
            W(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, size)));
            }
        }
    }

    private void cAg() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void aL(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.jUT.parseJson(stringExtra);
            this.jUT.updateQuality();
            if (this.jUT.getChosedFiles() != null && this.jUT.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.jUT.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.jUT.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, czJ());
        HidenSoftKeyPad(this.mInputManager, czI());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void aM(Intent intent) {
        c(intent, true);
    }

    private void W(Intent intent) {
        this.cGO = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.cGO;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.getEquipmentWidth(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.cGO, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            cAh();
            czR();
        }
        rY(true);
    }

    private void X(Intent intent) {
        c(intent, false);
    }

    private void c(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                cAh();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    czR();
                }
            }
            rY(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAh() {
        if (this.cFk.jL(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void auH() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.cGO));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void cAi() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.ftA)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.c.a();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                com.baidu.tbadk.util.m mVar = new com.baidu.tbadk.util.m(this, this.ftA, new m.a() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                    @Override // com.baidu.tbadk.util.m.a
                    public void onError(int i, String str) {
                    }

                    @Override // com.baidu.tbadk.util.m.a
                    public void onSuccess(String str) {
                        if (new File(str).exists() && WriteActivity.this.writeImagesInfo != null) {
                            WriteActivity.this.writeImagesInfo.clear();
                            ImageFileInfo imageFileInfo = new ImageFileInfo();
                            imageFileInfo.setFilePath(str);
                            imageFileInfo.isFromMoreForum = true;
                            WriteActivity.this.writeImagesInfo.addChooseFile(imageFileInfo);
                            WriteActivity.this.writeImagesInfo.setMaxImagesAllowed(1);
                            WriteActivity.this.rY(true);
                        }
                    }
                });
                mVar.setFrom(1);
                mVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rY(boolean z) {
        String forumId = this.iYy == null ? "" : this.iYy.getForumId();
        if (this.jUU != null) {
            this.jUU.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.fvn == null) {
            this.fvn = VoiceManager.instance();
        }
        return this.fvn;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bkk() {
        this.fvn = getVoiceManager();
        this.fvn.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.aH(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.fwB) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).O("obj_locate", at.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.iYy.getType() != 7) {
                if (this.jUf == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                B(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.cGW = i;
        if (this.cFk != null) {
            this.cFk.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void czR() {
        if (!this.jUr) {
            if (this.cFk != null) {
                this.cFk.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.cFk.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.iYy == null ? "" : this.iYy.getForumId();
            if (this.jUU != null) {
                this.jUU.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(boolean z) {
        if (this.cFk != null) {
            this.cFk.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void BM(int i) {
        if (i < this.jUd.size()) {
            for (int i2 = 0; i2 < this.jUd.size(); i2++) {
                this.jUd.get(i2).rO(false);
            }
            this.jUd.get(i).rO(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void zw(int i) {
        if (i == com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new an("c13014").O("obj_type", 1));
        } else {
            TiebaStatic.log(new an("c13014").O("obj_type", 2));
        }
        this.iYz = i;
        this.iYY.setCurrentIndex(i);
        BM(i);
        this.iYX.setText(this.mPrefixData.getPrefixs().get(i));
        clj();
        com.baidu.adp.lib.g.g.dismissPopupWindow(this.iYY, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.iZa.setSelected(false);
        am.setImageResource(this.iYZ, R.drawable.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.iYV);
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
            l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        if (this.iYy != null) {
            if (this.iYy.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.iYy.getType() == 5) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_UPDATE;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            auB();
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = ab.transformPermissionResult(strArr, iArr);
            if (ab.checkCamera(getApplicationContext())) {
                al.a(getPageContext(), this.cGO);
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.aiA = z;
        if (this.jVn && System.currentTimeMillis() - this.jVo < 800) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.jVn = false;
        }
        if (this.jUv != null && !z) {
            this.jUv.beI();
        }
        if (this.jUx != null && !z) {
            czu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.jVk != null) {
            FQ(str);
            this.jVk.dismiss();
        }
    }

    private void em(Context context) {
        jVm = l.getEquipmentHeight(context);
    }

    private void FQ(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.jVn = true;
        cAh();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            czR();
        }
        rY(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [4412=4] */
    private static Bitmap e(String str, float f) {
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

    private File cAj() {
        Cursor query = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{IMConstants.MSG_ROW_ID, "_data", "bucket_display_name", "datetaken", "mime_type"}, null, null, "datetaken DESC");
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

    private void cAk() {
        if (this.jVh != null && this.iYy.getType() == 0 && this.iYy.getType() == 9) {
            em(getActivity());
            this.jVj = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.jVj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.jVh != null) {
                        WriteActivity.this.FP(WriteActivity.this.jVh.getAbsolutePath());
                    }
                }
            });
            this.jVi = (TbImageView) this.jVj.findViewById(R.id.rec_img_view);
            this.jVl = (LinearLayout) this.jVj.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.alR().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.jVh.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.alR().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.jVh.getAbsolutePath());
                Bitmap e = e(this.jVh.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (e != null) {
                    this.jVi.setImageBitmap(e);
                    this.jVi.setDrawBorder(true);
                    this.jVi.setBorderWidth(2);
                    this.jVi.setBorderColor(am.getColor(R.color.common_color_10264));
                    this.jVk = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.jVk.setCanceledOnTouchOutside(true);
                    this.jVk.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.jVn) {
                                l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.jVo = System.currentTimeMillis();
                            }
                        }
                    });
                    this.jVk.setContentView(this.jVj);
                    this.jVk.show();
                    Window window = this.jVk.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (jVm / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.aiA && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.jTX = false;
            this.jTW = "";
            if ("from_content".equals(str)) {
                this.jTW = "from_content";
            } else if ("from_title".equals(str)) {
                this.jTW = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.qe(String.valueOf(charSequence.charAt(i)))) {
                rV(false);
            }
        }
    }

    public void cgA() {
        if (this.jUJ || !com.baidu.tbadk.core.util.v.isEmpty(this.mList) || !StringUtils.isNull(this.iYy.getTitle())) {
            this.jUa.setVisibility(0);
            this.jUa.requestFocus();
            this.cFk.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.jUa.setVisibility(8);
    }
}
