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
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.k.a.a;
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
import com.baidu.tbadk.coreExtra.data.z;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.switchs.RepostToDynamicDefaultSwitch;
import com.baidu.tbadk.util.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.frs.y;
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
/* loaded from: classes11.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0072a, VoiceManager.c, v.a, h.a {
    private static int kSK = 0;
    private EditorTools dsz;
    private String dud;
    private LocationModel due;
    private NewWriteModel duf;
    private String gkq;
    private String gkr;
    private String gks;
    private VoiceManager gmi;
    private LinearLayout iHR;
    private PlayVoiceBntNew iHS;
    private ImageView iHU;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private int jVE;
    private TextView jWb;
    private com.baidu.tieba.write.h jWc;
    private ImageView jWd;
    private View jWe;
    private com.baidu.tieba.write.b.c kPE;
    private View kRB;
    private Toast kRD;
    private AdditionData kRE;
    private RelativeLayout kRF;
    private TextView kRG;
    private TextView kRH;
    private TextView kRI;
    List<w> kRJ;
    w kRK;
    private int kRL;
    private String kRM;
    private int kRN;
    private PostCategoryView kRO;
    private HotTopicBussinessData kRR;
    private TextView kRS;
    private com.baidu.tieba.write.editor.b kRU;
    private e kRW;
    private LinearLayout kRy;
    private LinearLayout kRz;
    private View kSO;
    private View kSP;
    private TextView kSQ;
    private com.baidu.tieba.c.d kSS;
    private com.baidu.tieba.view.b kSd;
    private View kSm;
    private g kSt;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String kRu = "";
    private boolean kRv = false;
    private WriteData jVD = null;
    private boolean kSi = false;
    private boolean kRx = false;
    private boolean kSj = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText jVV = null;
    private HeadImageView kSk = null;
    private View jVW = null;
    private LinearLayout jVY = null;
    private EditText jVZ = null;
    private FeedBackModel kRA = null;
    private FeedBackTopListView kSl = null;
    private ArrayList<WritePrefixItemLayout> kRC = new ArrayList<>();
    private String ifl = null;
    private final KeyEvent fYt = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView kSn = null;
    private TextView jWa = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener gdj = null;
    private com.baidu.tbadk.core.dialog.a kSo = null;
    private final Handler mHandler = new Handler();
    private boolean kSp = false;
    private String kSq = null;
    private RelativeLayout hpY = null;
    private String duj = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int duk = 0;
    private int kSr = 0;
    private WriteImagesInfo kSs = new WriteImagesInfo();
    private View mRootView = null;
    private GridView kSu = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a kSv = null;
    private ScrollView kRP = null;
    private EditText kSw = null;
    private View kSx = null;
    private View kSy = null;
    private View kSz = null;
    private EditText kSA = null;
    private TextView kSB = null;
    private TextView kSC = null;
    private TextWatcher kSD = null;
    private TextWatcher kSE = null;
    private boolean kRQ = false;
    private boolean kSF = false;
    private com.baidu.tbadk.core.view.a dBR = null;
    private String mFrom = "write";
    private File kSG = null;
    private TbImageView kSH = null;
    private View mBubbleView = null;
    private Dialog kSI = null;
    private LinearLayout kSJ = null;
    private boolean kSL = false;
    private long kSM = -1000;
    private boolean kSN = false;
    private String gLX = "2";
    private int axG = 0;
    private String mTopicId = "";
    private SpannableStringBuilder kRT = new SpannableStringBuilder();
    private boolean kSR = false;
    private boolean aqT = false;
    private final b kRV = new b();
    private final HttpMessageListener kST = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.ifl)) {
                    WriteActivity.this.ifl = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.tQ(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.ifl)) {
                    WriteActivity.this.ifl = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.ifl);
                    WriteActivity.this.tQ(true);
                }
            }
        }
    };
    private TbFaceManager.a kRX = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan ve(String str) {
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
            return new com.baidu.tbadk.core.view.f(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a gnp = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).Z("obj_locate", at.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).Z("obj_locate", at.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d dut = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, z zVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.bCF();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.jVD != null) {
                WriteActivity.this.kRV.aV(null);
                if (z) {
                    WriteActivity.this.gC(z);
                    if (WriteActivity.this.e(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    if (WriteActivity.this.jVD.getType() != 0 && WriteActivity.this.jVD.getType() != 9) {
                        if (WriteActivity.this.jVD.getType() != 7) {
                            if (WriteActivity.this.jVD.getType() == 1) {
                                v.d(WriteActivity.this.jVD.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.jVD.getType() == 5) {
                                v.d(WriteActivity.this.jVD.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            v.c("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            v.c(WriteActivity.this.jVD.getForumId(), (WriteData) null);
                        }
                        if (!com.baidu.tbadk.core.util.v.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                            TiebaStatic.log(new an("c11731").cp("obj_id", WriteActivity.this.mTopicId));
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
                    WriteActivity.this.kRV.aV(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.kRV.Kx(postWriteCallBackData.getErrorString());
                    WriteActivity.this.kRV.b(WriteActivity.this.jVV, WriteActivity.this.jVZ);
                } else if ((zVar == null || writeData == null || zVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (zVar != null && writeData != null && zVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(zVar.getVcode_md5());
                    writeData.setVcodeUrl(zVar.getVcode_pic_url());
                    writeData.setVcodeExtra(zVar.aHl());
                    if (com.baidu.tbadk.s.a.vG(zVar.aHk())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, zVar.aHk());
                        if (WriteActivity.this.kSj) {
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
    private final LocationModel.a dur = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void aMM() {
            WriteActivity.this.showToast(R.string.no_network_guide);
            WriteActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void onFail(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(R.string.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.cKc())) {
                WriteActivity.this.a(2, true, aVar.cKc());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener khN = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.due.sM(false);
                    WriteActivity.this.due.ex(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.due.sM(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener kRY = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener kRZ = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.dsz.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cUr = WriteActivity.this.cUr();
            if (cUr >= 0 && cUr < WriteActivity.this.jVZ.getText().length()) {
                WriteActivity.this.jVZ.setSelection(cUr);
            }
        }
    };
    private boolean kSa = true;
    private final View.OnFocusChangeListener eSe = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.jVV || view == WriteActivity.this.mBack || view == WriteActivity.this.jWa) {
                if (z) {
                    WriteActivity.this.kSa = true;
                    WriteActivity.this.cUs();
                    l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.jVV);
                    if (WriteActivity.this.dsz != null) {
                        WriteActivity.this.dsz.aKs();
                    }
                } else if (view == WriteActivity.this.jVV) {
                    WriteActivity.this.jWb.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.jVZ && z) {
                WriteActivity.this.kSa = false;
                WriteActivity.this.cUs();
                l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.jVZ);
                if (WriteActivity.this.dsz != null) {
                    WriteActivity.this.dsz.aKs();
                }
            }
            WriteActivity.this.cUx();
        }
    };
    private TextWatcher kSb = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String kSf = "";
        private String kSg;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kSg = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.kSg != null ? this.kSg.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cGt();
            WriteActivity.this.cUy();
            EditText cUJ = WriteActivity.this.cUJ();
            if (editable != null && cUJ != null && cUJ.getText() != null) {
                if (this.kSf == null || !this.kSf.equals(editable.toString())) {
                    if (WriteActivity.this.kRV != null) {
                        this.kSf = cUJ.getText().toString();
                        WriteActivity.this.kRV.b(cUJ, true);
                        return;
                    }
                    return;
                }
                cUJ.setSelection(cUJ.getSelectionEnd());
            }
        }
    };
    private TextWatcher kSc = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String kSg;
        private String kSh = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kSg = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.kSg != null ? this.kSg.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cGt();
            EditText cUI = WriteActivity.this.cUI();
            if (editable != null && cUI != null && cUI.getText() != null) {
                if (this.kSh == null || !this.kSh.equals(editable.toString())) {
                    if (WriteActivity.this.kRV != null) {
                        this.kSh = cUI.getText().toString();
                        WriteActivity.this.kRV.b(cUI, false);
                        return;
                    }
                    return;
                }
                cUI.setSelection(cUI.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0602a iNY = new a.InterfaceC0602a() { // from class: com.baidu.tieba.write.write.WriteActivity.31
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0602a
        public void onRefresh() {
            WriteActivity.this.ifl = null;
            WriteActivity.this.tQ(false);
            WriteActivity.this.dsz.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void aMw() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void aMx() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aMz();
        } else if (this.due.cKj()) {
            aMw();
        } else {
            this.due.sM(false);
            a(1, true, (String) null);
            this.due.cKh();
        }
    }

    public void cUT() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
            if (this.kRU != null) {
                this.kRU.cTy();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aMz();
        } else if (this.due != null) {
            this.due.sM(false);
            a(1, true, (String) null);
            this.due.cKh();
        }
    }

    private void aMz() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.jF(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.due.cKl();
                } else {
                    WriteActivity.this.dur.aMM();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.45
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.aCp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cUr() {
        int selectionEnd = cUI().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cUI().getText().getSpans(0, cUI().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cUI().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cUI().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUs() {
        if (this.dsz != null) {
            this.dsz.setBarLauncherEnabled(!this.kSa);
            this.dsz.setBarLauncherEnabled(true, 26);
            this.dsz.setBarLauncherEnabled(true, 2);
            this.dsz.setBarLauncherEnabled(true, 30);
            W(9, this.kSa ? false : true);
        }
    }

    private void W(int i, boolean z) {
        com.baidu.tbadk.editortools.g lU;
        if (this.dsz != null && (lU = this.dsz.lU(i)) != null) {
            if (z) {
                lU.display();
            } else {
                lU.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.kRQ) {
            this.jVV.setVisibility(8);
            if (this.jVD.getType() == 5) {
                this.kSz.setVisibility(8);
            } else {
                this.kSz.setVisibility(0);
            }
            a(this.kSC, this.kSw);
            a(this.kSB, this.kSA);
            cGt();
        }
        if (this.kSi) {
            this.kSa = true;
            cUs();
            if (this.dsz != null) {
                this.dsz.aKs();
            }
            this.jVV.requestFocus();
            ShowSoftKeyPadDelay(this.jVV);
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
            cVj();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                cUR();
            }
            tR(true);
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
        if (this.jVD.getType() == 0) {
            Eo(this.axG);
        }
        initUI();
        cUY();
        this.due = new LocationModel(getPageContext());
        this.due.a(this.dur);
        registerListener(this.khN);
        registerListener(this.kRY);
        ceg();
        cVm();
        if (this.kRQ) {
            this.kSv.setEditorTools(this.dsz);
        } else {
            this.jVZ.requestFocus();
        }
        cBH();
        cUR();
        cVk();
    }

    @SuppressLint({"ResourceAsColor"})
    private void ceg() {
        this.dsz = new EditorTools(getActivity());
        this.dsz.setBarMaxLauCount(5);
        this.dsz.setMoreButtonAtEnd(true);
        this.dsz.setBarBackgroundColorId(R.color.cp_bg_line_h);
        this.dsz.setBarLauncherType(1);
        this.dsz.gu(true);
        this.dsz.gv(true);
        switch (this.jVD.getType()) {
            case 4:
            case 5:
                cUW();
                break;
            default:
                cUt();
                break;
        }
        this.dsz.build();
        if (this.kRy != null) {
            this.kRy.addView(this.dsz);
        }
        bYm();
        this.dsz.display();
        com.baidu.tbadk.editortools.g lU = this.dsz.lU(6);
        if (lU != null && !TextUtils.isEmpty(this.duj)) {
            ((View) lU).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.duj);
                }
            });
        }
        if (!this.kRQ) {
            this.dsz.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.dsz.aKs();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.dsz.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.dsz.b(new com.baidu.tbadk.editortools.a(2, 26, HanziToPinyin.Token.SEPARATOR));
        }
        cUv();
    }

    private void cUU() {
        this.kSx = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.kSz = this.kSx.findViewById(R.id.live_post_title_container);
        this.kSw = (EditText) this.kSx.findViewById(R.id.live_post_content);
        this.kSu = (GridView) this.kSx.findViewById(R.id.photoLiveGridView);
        this.kSA = (EditText) this.kSx.findViewById(R.id.live_post_title);
        this.kSB = (TextView) this.kSx.findViewById(R.id.titleOverPlusNumber);
        this.kSC = (TextView) this.kSx.findViewById(R.id.contentOverPlusNumber);
        this.kSy = this.kSx.findViewById(R.id.live_interval_view);
        this.kSB.setText(String.valueOf(20));
        this.kSC.setText(String.valueOf(233));
        this.kSx.setVisibility(0);
        this.kSB.setVisibility(0);
        this.kSC.setVisibility(0);
        this.kSA.setHint(R.string.tips_title_limit_new);
        this.kSA.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.kSF = true;
                    WriteActivity.this.kSa = true;
                    WriteActivity.this.cUs();
                    if (WriteActivity.this.dsz != null) {
                        WriteActivity.this.dsz.aKs();
                    }
                }
            }
        });
        if (this.jVD.getType() == 4) {
            this.kSw.setHint(R.string.live_write_input_content_new);
        } else if (this.jVD.getType() == 5) {
            this.kSw.setHint(R.string.live_write_input_content_update);
        }
        this.kSw.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.kSF = false;
                    WriteActivity.this.kSa = false;
                    WriteActivity.this.cUs();
                    if (WriteActivity.this.dsz != null) {
                        WriteActivity.this.dsz.aKs();
                    }
                }
            }
        });
        this.kSw.requestFocus();
        this.kSw.addTextChangedListener(Rw());
        this.kSA.requestFocus();
        this.kSA.addTextChangedListener(Rw());
        this.kSA.setOnClickListener(this.kRZ);
        this.kSw.setOnClickListener(this.kRZ);
        this.kSv = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.kSu);
        this.kSv.Ei(6);
        this.kSu.setAdapter((ListAdapter) this.kSv);
        View findViewById = this.kSx.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void cUd() {
                WriteActivity.this.cVh();
            }
        });
        cUV();
    }

    private void cUV() {
        if (this.jVD.getType() == 0) {
            if (this.jVD.getTitle() != null) {
                this.kSA.setText(this.jVD.getTitle());
                this.kSA.setSelection(this.jVD.getTitle().length());
                return;
            }
            return;
        }
        if (this.jVD.getType() == 1 || this.jVD.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.kRQ) {
            cVf();
        }
        if (this.dsz.aLX()) {
            this.dsz.aKs();
        }
        Eo(0);
    }

    private void Eo(int i) {
        if (this.writeImagesInfo != null && this.jVD != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.jVD.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.jVD.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.gLX);
            albumActivityConfig.setProfessionZone(this.jVD.getProZone());
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void cUW() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.dsz.aI(arrayList);
        com.baidu.tbadk.editortools.l lX = this.dsz.lX(5);
        if (lX != null) {
            lX.dtj = 2;
        }
        this.dsz.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.dsz.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void cUt() {
        com.baidu.tbadk.editortools.l lVar;
        com.baidu.tbadk.editortools.l lVar2;
        com.baidu.tbadk.editortools.l lVar3;
        com.baidu.tbadk.editortools.l lVar4;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.l lVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            this.dsz.b(dVar);
        }
        Boolean cVc = cVc();
        if (!this.kSi && cVc != null && cVc.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.cKJ() && r.d(this.jVD.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar5 = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar5.dtj = 3;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dsz.b(lVar5);
            }
        }
        this.dsz.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 4));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask2 != null && (lVar4 = (com.baidu.tbadk.editortools.l) runTask2.getData()) != null) {
            lVar4.dtj = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dsz.b(lVar4);
            }
        }
        this.dsz.b(new com.baidu.tbadk.editortools.k(getActivity(), 6));
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask3 != null && (lVar3 = (com.baidu.tbadk.editortools.l) runTask3.getData()) != null) {
            lVar3.dtj = 7;
            this.dsz.b(lVar3);
        }
        this.dsz.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 8));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask4 != null && (lVar2 = (com.baidu.tbadk.editortools.l) runTask4.getData()) != null) {
            lVar2.dtl = true;
            lVar2.dtj = 9;
            lVar2.dtf = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dsz.b(lVar2);
            }
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask5 != null && (lVar = (com.baidu.tbadk.editortools.l) runTask5.getData()) != null) {
            lVar.dtl = true;
            lVar.dtj = 10;
            lVar.dtf = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dsz.b(lVar);
            }
        }
        if (this.kRE == null) {
            if (this.kRU == null) {
                this.kRU = new com.baidu.tieba.write.editor.b(getActivity(), this.gLX);
                this.kRU.bA(this.jVD.getForumId(), this.privateThread);
                this.kRU.tK(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.kRU.cTu();
                this.kRU.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                cUT();
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.mList)) {
                this.kRU.cTu();
            }
            this.dsz.b(this.kRU);
        }
        this.dsz.aI(arrayList);
        com.baidu.tbadk.editortools.l lX = this.dsz.lX(5);
        if (lX != null) {
            lX.dtj = 1;
        }
    }

    private void cUu() {
        if (this.kRW != null) {
            this.kRW.hideTip();
        }
    }

    private void cUv() {
        if (this.kRW == null) {
            this.kRW = new e(getPageContext());
        }
        this.kRW.c(this.dsz);
    }

    private void bYm() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.cUH()) {
                            WriteActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new an("c12612").Z("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (aVar.data != null && (aVar.data instanceof p)) {
                            p pVar = (p) aVar.data;
                            if (pVar.aHc() == EmotionGroupType.BIG_EMOTION || pVar.aHc() == EmotionGroupType.USER_COLLECT) {
                                if (WriteActivity.this.mCurrentPermissionJudgePolicy == null) {
                                    WriteActivity.this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
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
                                    WriteActivity.this.tR(true);
                                    WriteActivity.this.cGt();
                                }
                            } else if (WriteActivity.this.cUH()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(pVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.cUK();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.clU();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.cVj();
                        WriteActivity.this.cGt();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.Ep(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new an("c12612").Z("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.kRE == null) {
                            WriteActivity.this.aMA();
                            return;
                        }
                        switch (WriteActivity.this.duk) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.aMx();
                                    return;
                                } else {
                                    ab.reuqestLocation(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.aMw();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.due != null) {
                            WriteActivity.this.due.sM(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.ifl = null;
                        } else {
                            WriteActivity.this.ifl = (String) aVar.data;
                        }
                        WriteActivity.this.tQ(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        an anVar = new an("c10645");
                        if (WriteActivity.this.jVD != null) {
                            str = WriteActivity.this.jVD.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.cp("fid", str);
                        TiebaStatic.log(anVar);
                        if (WriteActivity.this.jVD == null || (videoInfo = WriteActivity.this.jVD.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.dsz.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.dsz.aLX()) {
                                        WriteActivity.this.dsz.aKs();
                                        WriteActivity.this.dsz.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.dsz.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                        WriteActivity.this.dsz.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.dsz.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.dsz.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.jVD.setVideoInfo(null);
                        WriteActivity.this.cGt();
                        if (WriteActivity.this.jVZ != null) {
                            WriteActivity.this.jVZ.requestFocus();
                        }
                        WriteActivity.this.dsz.aKs();
                        WriteActivity.this.dsz.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.jVZ);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new an("c12612").Z("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.dsz.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.kRv = true;
                        WriteActivity.this.tO(true);
                        if (!WriteActivity.this.cUJ().isFocused() || WriteActivity.this.kRz.getVisibility() != 0) {
                            WriteActivity.this.kRu = "from_content";
                        } else {
                            WriteActivity.this.kRu = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        if (WriteActivity.this.kRz.getVisibility() == 0) {
                            if (WriteActivity.this.kRz.hasFocus()) {
                                WriteActivity.this.jVZ.requestFocus();
                                WriteActivity.this.jVZ.setSelection(WriteActivity.this.jVZ.getText().toString().length());
                            }
                            WriteActivity.this.kRz.setVisibility(8);
                            WriteActivity.this.dsz.lU(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.kRz.setVisibility(0);
                            WriteActivity.this.kRz.requestFocus();
                            WriteActivity.this.dsz.lU(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.cGt();
                    } else if (aVar.code == 55) {
                        if (aVar.data != null && (aVar.data instanceof Boolean)) {
                            WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                        }
                    } else if (aVar.code == 58 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isToDynamic = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.dsz.setActionListener(16, bVar);
        this.dsz.setActionListener(14, bVar);
        this.dsz.setActionListener(24, bVar);
        this.dsz.setActionListener(3, bVar);
        this.dsz.setActionListener(10, bVar);
        this.dsz.setActionListener(11, bVar);
        this.dsz.setActionListener(12, bVar);
        this.dsz.setActionListener(13, bVar);
        this.dsz.setActionListener(15, bVar);
        this.dsz.setActionListener(18, bVar);
        this.dsz.setActionListener(20, bVar);
        this.dsz.setActionListener(25, bVar);
        this.dsz.setActionListener(27, bVar);
        this.dsz.setActionListener(29, bVar);
        this.dsz.setActionListener(43, bVar);
        this.dsz.setActionListener(56, bVar);
        this.dsz.setActionListener(48, bVar);
        this.dsz.setActionListener(46, bVar);
        this.dsz.setActionListener(49, bVar);
        this.dsz.setActionListener(47, bVar);
        this.dsz.setActionListener(55, bVar);
        this.dsz.setActionListener(58, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ep(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMA() {
        if (this.due.bpD()) {
            if (this.due.cKj()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.cKe().getLocationData().cKc());
                return;
            }
            a(1, true, (String) null);
            this.due.cKh();
            return;
        }
        a(0, true, (String) null);
    }

    protected void cGk() {
        if (this.duf != null) {
            this.duf.cancelLoadData();
        }
        if (this.kRA != null) {
            this.kRA.cancelLoadData();
        }
        if (this.due != null) {
            this.due.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cUu();
        TiebaPrepareImageService.StopService();
        cGk();
        cVb();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.kSt != null) {
            this.kSt.destroy();
        }
        if (this.kSS != null) {
            this.kSS.xg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUw() {
        if (this.jVD != null && this.jVD.getType() == 2 && this.kSp) {
            finish();
        } else if (this.jVD == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.jVD.setTitle(cUJ().getText().toString());
            this.jVD.setContent(cUI().getText().toString());
            int type = this.jVD.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    v.c(this.jVD.getForumId(), this.jVD);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    v.c("24591571", this.jVD);
                }
            } else if (type == 1) {
                v.d(this.jVD.getThreadId(), this.jVD);
            } else if (type == 4) {
                v.c(this.jVD.getForumId() + "photolive", this.jVD);
            } else if (type == 5) {
                v.d(this.jVD.getThreadId() + "updatephotolive", this.jVD);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.jWc != null && this.jWc.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.jWc, getPageContext().getPageActivity());
                return true;
            } else if (this.dsz.aLX()) {
                this.dsz.aKs();
                return true;
            } else {
                cGk();
                cUw();
                return true;
            }
        }
        if (i == 67 && (text = cUI().getText()) != null) {
            int selectionStart = cUI().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cUI().onKeyDown(67, this.fYt);
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
        getLayoutMode().onModeChanged(this.hpY);
        getLayoutMode().onModeChanged(this.kSJ);
        am.setBackgroundColor(this.hpY, R.color.cp_bg_line_e);
        if (this.kSH != null && (i == 1 || i == 4)) {
            this.kSH.setBorderColor(am.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.jWa, R.color.cp_link_tip_a, 1);
        cUs();
        am.setBackgroundColor(this.jVW, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.kSy, R.color.cp_bg_line_c);
        am.setBackgroundColor(cUJ(), R.color.cp_bg_line_e);
        am.setImageResource(this.iHU, R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.ifl)) {
            am.setBackgroundColor(cUI(), R.color.cp_bg_line_e);
        }
        cGt();
        this.dsz.onChangeSkinType(i);
        if (this.kRO != null) {
            this.kRO.aFw();
        }
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.kSt.kTo.notifyDataSetChanged();
        cUx();
        cUy();
        tQ(false);
        if (this.kRV != null) {
            this.kRV.c(cUJ(), cUI());
        }
        this.kPE.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUx() {
        if (this.jVV.hasFocus()) {
            this.jVV.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.jVV.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.jVZ.hasFocus()) {
            this.jVZ.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.jVZ.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUy() {
        if (this.jVV != null && this.jVV.getText() != null && this.jVV.getText().toString() != null && this.jVV.getPaint() != null) {
            if (this.jVV.getText().toString().length() == 0) {
                this.jVV.getPaint().setFakeBoldText(false);
            } else if (this.jVV.getText().toString().length() > 0) {
                this.jVV.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.dBR = new com.baidu.tbadk.core.view.a(getPageContext());
        this.kRQ = this.jVD.getType() == 4 || 5 == this.jVD.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aEp().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.kSn = (TextView) findViewById(R.id.btn_image_problem);
        cUA();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jWa.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.jWa.setLayoutParams(layoutParams);
        this.jWa.setOnFocusChangeListener(this.eSe);
        this.kRP = (ScrollView) findViewById(R.id.write_scrollview);
        this.kRP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.jVZ != null) {
                        l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.jVZ);
                    }
                    if (WriteActivity.this.dsz != null) {
                        WriteActivity.this.dsz.aKs();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.kSl = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.kSm = findViewById(R.id.feedback_divider);
        this.hpY = (RelativeLayout) findViewById(R.id.parent);
        this.kRy = (LinearLayout) findViewById(R.id.tool_view);
        this.kRy.setContentDescription(IStringUtil.TOP_PATH);
        this.kRz = (LinearLayout) findViewById(R.id.title_view);
        this.jVW = findViewById(R.id.interval_view);
        this.kSO = findViewById(R.id.hot_topic_fourm_view);
        this.kSP = findViewById(R.id.hot_topic_divider);
        this.kRS = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.kSQ = (TextView) findViewById(R.id.change_one_tv);
        cGs();
        if (this.kRQ) {
            this.kRP.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            cUU();
        } else {
            this.kSt = new g(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.kSt.tI(false);
            } else {
                g gVar = this.kSt;
                if (this.jVD.getType() != 0 && this.jVD.getType() != 9) {
                    z = false;
                }
                gVar.tI(z);
            }
        }
        cGu();
        if (this.kSi || this.kRx) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().cWK) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.jVY = (LinearLayout) findViewById(R.id.post_content_container);
        this.jVY.setDrawingCacheEnabled(false);
        this.jVY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.dsz.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.jVZ.requestFocus();
            }
        });
        this.iHR = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.iHS = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.iHU = (ImageView) findViewById(R.id.iv_delete_voice);
        this.iHU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.clU();
            }
        });
        this.mBack.setOnFocusChangeListener(this.eSe);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cGk();
                WriteActivity.this.cUw();
            }
        });
        this.kSn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        cUD();
        o(cVc());
        cUF();
        cUz();
        cUZ();
        cVa();
        cUs();
        cUE();
        cGr();
        cUL();
        if (this.jVD.getType() == 4 && this.jWe != null && this.kRB != null) {
            this.jWe.setVisibility(8);
            this.kRB.setVisibility(8);
        }
        cGt();
        cUX();
        cTM();
    }

    private void cTM() {
        this.kPE = new com.baidu.tieba.write.b.c(getPageContext().getPageActivity(), this.mName, this.jVD.getProZone(), isUseStyleImmersiveSticky() ? StatusBarUtil.getStatusBarOffsetPx(getPageContext().getPageActivity()) : 0);
        this.kPE.a(new c.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // com.baidu.tieba.write.b.c.a
            public void Ed(int i) {
                WriteActivity.this.jVD.setProZone(i);
            }
        });
        this.kPE.bwO();
    }

    private void cUz() {
        String str;
        String str2;
        if (this.jVD != null) {
            switch (this.jVD.getType()) {
                case 0:
                case 9:
                    if (this.kSi || this.kRx) {
                        if (this.kSj) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.gLX != null && this.gLX.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                    } else if (this.gLX != null && this.gLX.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.jVD.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.jVD.getForumName() + getResources().getString(R.string.bar));
                        this.jVV.setVisibility(8);
                        String str3 = this.gks + HanziToPinyin.Token.SEPARATOR + this.gkq;
                        if (!StringUtils.isNull(str3)) {
                            this.jVZ.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.jVV.setVisibility(0);
                    this.jVZ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.jVZ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.jVV.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.jVZ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.jVD.getFloorNum() + 1)));
                    this.kSy.setVisibility(8);
                    return;
                case 7:
                    this.jVV.setVisibility(0);
                    this.jVZ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void cUA() {
        if (this.jVD.getType() == 7) {
            this.jWa = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.jWa = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void cUB() {
        if (this.jVD != null && this.jVD.getType() == 0 && this.jVD.getType() == 9 && !this.kSi && !this.kRx && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = aq.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && cUJ() != null) {
                cUJ().setText(cutStringWithSuffix);
                cUJ().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.iHR.setVisibility(0);
            this.iHS.setVoiceModel(voiceModel);
            this.iHS.cKI();
            cGt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clU() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.iHR.setVisibility(8);
        this.iHS.bML();
        this.iHS.setVoiceModel(null);
        com.baidu.tbadk.editortools.l lX = this.dsz.lX(6);
        if (lX != null && lX.dss != null) {
            lX.dss.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cGt();
    }

    private void cUC() {
        this.kRJ = null;
        this.kRL = -1;
        this.kRN = -1;
        y sS = x.bDY().sS(1);
        if (sS != null) {
            this.kRJ = sS.gpS;
            this.kRL = getIntent().getIntExtra("category_id", -1);
            if (this.kRJ != null && !this.kRJ.isEmpty() && this.kRL >= 0) {
                this.kRK = new w();
                this.kRK.gpO = 0;
                this.kRK.name = getPageContext().getResources().getString(R.string.category_auto);
                this.kRN = this.kRK.gpO;
                this.kRM = this.kRK.name;
                for (w wVar : this.kRJ) {
                    if (wVar.gpO == this.kRL) {
                        this.kRN = wVar.gpO;
                        this.kRM = wVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cUD() {
        if (this.kRJ != null && !this.kRJ.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.kRO = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.kRO.setText(this.kRM);
            this.kRO.setCategoryContainerData(this.kRJ, this.kRK, this.kRN);
            this.kRO.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, as asVar) {
                    if (asVar != null) {
                        WriteActivity.this.kRO.setText(asVar.name);
                        WriteActivity.this.jVD.setCategoryTo(asVar.gpO);
                        WriteActivity.this.kRN = asVar.gpO;
                        WriteActivity.this.kRO.cUf();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.kRO.cUe();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cUJ());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cUI());
                }
            });
        }
    }

    private void cUX() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.kSd = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.kSd.setTitle(R.string.no_disturb_start_time);
        this.kSd.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.kSd);
        this.kSd.setButton(-2, getPageContext().getString(R.string.cancel), this.kSd);
        return this.kSd;
    }

    private void cUE() {
        this.kRF = (RelativeLayout) findViewById(R.id.addition_container);
        this.kRG = (TextView) findViewById(R.id.addition_create_time);
        this.kRH = (TextView) findViewById(R.id.addition_last_time);
        this.kRI = (TextView) findViewById(R.id.addition_last_content);
        if (this.kRE != null) {
            this.kRF.setVisibility(0);
            this.kRG.setText(getPageContext().getString(R.string.write_addition_create) + aq.getFormatTime(this.kRE.getCreateTime() * 1000));
            if (this.kRE.getAlreadyCount() == 0) {
                this.kRH.setVisibility(8);
            } else {
                this.kRH.setText(getPageContext().getString(R.string.write_addition_last) + aq.getFormatTime(this.kRE.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.kRE.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.kRI.setText(lastAdditionContent);
            } else {
                this.kRI.setVisibility(8);
            }
            cUI().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.kRE.getAlreadyCount()), Integer.valueOf(this.kRE.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.kRF.setVisibility(8);
    }

    private void cGr() {
        this.jWe = findViewById(R.id.post_prefix_layout);
        if (this.kSS == null) {
            this.kSS = new com.baidu.tieba.c.d(getPageContext(), this.jWe);
            this.kSS.bU(R.drawable.bg_tip_blue_up_left);
            this.kSS.bT(16);
            this.kSS.ku(true);
            this.kSS.setUseDirectOffset(true);
            this.kSS.rs(l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.jWb = (TextView) findViewById(R.id.post_prefix);
        this.kRB = findViewById(R.id.prefix_divider);
        this.jWd = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.jWe.setVisibility(0);
            this.kSS.c(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.jVE = 0;
            this.jWe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").cp("fid", WriteActivity.this.jVD.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.jWb.setVisibility(0);
                    WriteActivity.this.jWe.setSelected(true);
                    am.setImageResource(WriteActivity.this.jWd, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.jWc, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.dsz.aKs();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.jVV);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.jVZ);
                }
            });
            this.jWb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").cp("fid", WriteActivity.this.jVD.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.jWb.setSelected(true);
                    am.setImageResource(WriteActivity.this.jWd, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.jWc, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.dsz.aKs();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cUJ());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cUI());
                }
            });
            this.jWc = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.jWc.a(this);
            this.jWc.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.jWc.setOutsideTouchable(true);
            this.jWc.setFocusable(true);
            this.jWc.setOnDismissListener(this);
            this.jWc.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            am.getColor(R.color.cp_cont_c);
            am.setBackgroundResource(this.jWb, R.color.cp_bg_line_d);
            am.setImageResource(this.jWd, R.drawable.icon_arrow_gray_down);
            this.jWb.setTextColor(color);
            this.kRC.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.kRC.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.tF(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.tF(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.jWc.addView(writePrefixItemLayout);
            }
            this.jWc.setCurrentIndex(0);
            this.jWb.setText(prefixs.get(0));
            En(0);
            return;
        }
        this.jWe.setVisibility(8);
    }

    private void cUY() {
        if (this.kSi && this.jVD != null) {
            this.kSl.setVisibility(0);
            this.kSm.setVisibility(0);
            this.kRA = new FeedBackModel(getPageContext());
            this.kRA.KP(this.jVD.getForumName());
            this.kRA.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.24
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.kSl.setVisibility(8);
                        WriteActivity.this.kSm.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.kSl.setVisibility(8);
                        WriteActivity.this.kSm.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.kSl.a(feedBackModel.cUh(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void cUF() {
        this.jWa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (WriteActivity.this.kRV.a(WriteActivity.this.jVV, WriteActivity.this.jVZ)) {
                        WriteActivity.this.showToast(WriteActivity.this.kRV.cSO());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cUJ());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cUI());
                    WriteActivity.this.dsz.aKs();
                    if (WriteActivity.this.jVD.getType() != 7) {
                        if (WriteActivity.this.kSi) {
                            WriteActivity.this.cUO();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            an anVar = new an("c12102");
                            anVar.Z("obj_type", StringUtils.isNull(WriteActivity.this.jVD.getForumName()) ? 1 : 2);
                            TiebaStatic.log(anVar);
                            WriteActivity.this.cUP();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.cUO();
                    }
                    TiebaStatic.log(new an("c12262").cp("obj_locate", WriteActivity.this.gLX));
                }
            }
        });
    }

    protected void cUZ() {
        this.kSo = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.kSo.sC(getPageContext().getString(R.string.is_save_draft)).fz(false).a(getPageContext().getString(R.string.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.jVD.setTitle(WriteActivity.this.cUJ().getText().toString());
                WriteActivity.this.jVD.setContent(WriteActivity.this.cUI().getText().toString());
                int type = WriteActivity.this.jVD.getType();
                if (type == 0 || type == 9) {
                    v.c(WriteActivity.this.jVD.getForumId(), WriteActivity.this.jVD);
                } else if (type == 1) {
                    v.d(WriteActivity.this.jVD.getThreadId(), WriteActivity.this.jVD);
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
                int type = WriteActivity.this.jVD.getType();
                if (type == 0 || type == 9) {
                    v.c(WriteActivity.this.jVD.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    v.d(WriteActivity.this.jVD.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.kSo.b(getPageContext());
    }

    protected void cGs() {
        this.kSk = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.kSk.setIsRound(true);
        this.kSk.setDrawBorder(false);
        this.kSk.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String sX = o.sX(currentPortrait);
            this.kSk.setUrl(sX);
            this.kSk.startLoad(sX, 12, false);
        }
        if (this.jVD.isUserFeedback()) {
            this.kSk.setVisibility(0);
        }
        this.jVV = (EditText) findViewById(R.id.post_title);
        this.jVV.setOnClickListener(this.kRZ);
        this.jVV.setOnFocusChangeListener(this.eSe);
        if (this.jVD.getType() == 0 || this.jVD.getType() == 9 || this.jVD.getType() == 7) {
            if (this.jVD.getTitle() != null) {
                this.jVV.setText(this.jVD.getTitle());
                this.jVV.setSelection(this.jVD.getTitle().length());
            } else if (this.kSj) {
                this.jVV.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.jVD.getType() == 1 || this.jVD.getType() != 2) {
        }
        this.jVV.addTextChangedListener(this.kSb);
        if (!this.jVD.getHaveDraft()) {
            cUB();
            this.kSN = true;
        }
        if (this.jVD.isUserFeedback()) {
            this.jVV.setHint(getResources().getString(R.string.feedback_title_hint));
        } else {
            this.jVV.setHint(getResources().getString(R.string.post_title_hint));
        }
    }

    private TextWatcher Rw() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            private int kSW;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.cGt();
                if (WriteActivity.this.kRQ) {
                    this.kSW = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.kSW);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.kRQ || !WriteActivity.this.kSF) {
                    if (WriteActivity.this.kRQ) {
                        if (this.mEditText != WriteActivity.this.kSw || this.mTextView != WriteActivity.this.kSC) {
                            this.mEditText = WriteActivity.this.kSw;
                            this.mTextView = WriteActivity.this.kSC;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.kSA || this.mTextView != WriteActivity.this.kSB) {
                    this.mEditText = WriteActivity.this.kSA;
                    this.mTextView = WriteActivity.this.kSB;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.kRQ && this.kSF) {
            if (this.kSD != null) {
                this.kSA.removeTextChangedListener(this.kSD);
            }
            this.kSD = textWatcher;
        } else if (this.kRQ) {
            if (this.kSE != null) {
                this.kSw.removeTextChangedListener(this.kSE);
            }
            this.kSE = textWatcher;
        }
        return textWatcher;
    }

    private long j(EditText editText) {
        if (editText == this.kSw) {
            return 233L;
        }
        if (editText != this.kSA) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long j = j(editText);
            long k = j - k(editText);
            String valueOf = String.valueOf(k);
            if (j == 20) {
                if (k < 0) {
                    if (k < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(am.getColor(R.color.common_color_10159));
                } else {
                    textView.setTextColor(am.getColor(R.color.cp_cont_d));
                }
            } else if (k < 0) {
                if (k < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(am.getColor(R.color.common_color_10159));
            } else {
                textView.setTextColor(am.getColor(R.color.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long k(EditText editText) {
        return com.baidu.tieba.write.c.a.o(editText.getText().toString().trim());
    }

    protected void cGu() {
        this.jVZ = (EditText) findViewById(R.id.post_content);
        this.jVZ.setDrawingCacheEnabled(false);
        this.jVZ.setOnClickListener(this.kRZ);
        if (this.jVD.getContent() != null && this.jVD.getContent().length() > 0) {
            SpannableString aB = TbFaceManager.aNr().aB(getPageContext().getPageActivity(), this.jVD.getContent());
            this.jVZ.setText(aB);
            this.jVZ.setSelection(aB.length());
        } else if (this.jVD.getType() == 2) {
            if (this.kSp) {
                if (this.kSq != null && this.kSq.length() > 0) {
                    this.jVZ.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.kSq}));
                    this.jVZ.setSelection(this.jVZ.getText().length());
                }
            } else if (this.jVD.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.jVD.getFloorNum()));
                this.jVZ.setText(format);
                this.jVZ.setSelection(format.length());
            }
        }
        this.jVZ.setOnFocusChangeListener(this.eSe);
        this.jVZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.dsz.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.jVZ.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.jVZ.addTextChangedListener(this.kSc);
        if (this.jVD.getType() == 0) {
            this.kSR = true;
        } else {
            tQ(true);
            this.kSR = false;
        }
        if (this.jVD.isUserFeedback()) {
            this.jVZ.setHint(R.string.write_input_content);
        } else {
            this.jVZ.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void tQ(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.kRQ) {
            cUI().setPadding(0, 0, 0, 0);
            cUI().setBackgroundDrawable(null);
            am.setBackgroundColor(cUI(), R.color.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.ifl) && this.kRE == null) {
                com.baidu.adp.lib.e.c.gr().a(this.ifl, 19, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.30
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass30) aVar, str, i);
                        if (aVar != null && aVar.getRawBitmap() != null && aVar.getPadding() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.cUI().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.cUI(), true, WriteActivity.this.iNY);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cUH() {
        int i = 5000;
        if (this.kRE != null) {
            i = 1000;
        }
        return cUI().getText() != null && cUI().getText().length() >= i;
    }

    private void uQ(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.kRu)) {
                this.kRu = "";
                cUI().requestFocus();
                if (cUI().getText() != null && cUI().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cUI().getSelectionStart();
                    editable = cUI().getText();
                }
            } else if ("from_title".equals(this.kRu)) {
                this.kRu = "";
                cUJ().requestFocus();
                if (cUJ().getText() != null && cUJ().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cUJ().getSelectionStart();
                    editable = cUJ().getText();
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
    public void tO(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.jVD != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.jVD.getForumId(), 0L), this.jVD.getFirstDir(), this.jVD.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(p pVar) {
        if (((ImageSpan[]) cUI().getText().getSpans(0, cUI().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.kRD == null) {
                this.kRD = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            this.kRD.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType aHc = pVar.aHc();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.e.c.gr().a(name, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.32
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass32) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.cUI().getSelectionStart(), aVar, aHc);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cUI() != null && cUI().getText() != null) {
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
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.f(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = cUI().getSelectionStart() - 1;
                if (cUI().getText().length() > 1 && selectionStart >= 0 && cUI().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cUI().getText().insert(cUI().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cUI().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cUI().getText().insert(cUI().getSelectionStart(), spannableString2);
            }
            Editable text = cUI().getText();
            if (text != null) {
                this.kRT.clear();
                this.kRT.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.kRT);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cUI().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cUI().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cUI().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cUI() {
        return this.kRQ ? this.kSw : this.jVZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cUJ() {
        return this.kRQ ? this.kSA : this.jVV;
    }

    protected void cUK() {
        Editable text;
        if (cUI() != null && (text = cUI().getText()) != null) {
            int selectionStart = cUI().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cUI().onKeyDown(67, this.fYt);
            }
            cUI().onKeyDown(67, this.fYt);
            int selectionStart2 = cUI().getSelectionStart();
            if (text != null) {
                this.kRT.clear();
                this.kRT.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.kRT);
                cUI().setSelection(selectionStart2);
            }
        }
    }

    private void o(Boolean bool) {
        String str = null;
        if (this.jVD != null) {
            str = this.jVD.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.kSi = true;
        }
    }

    private void cVa() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void cVb() {
        try {
            if (this.kSo != null) {
                this.kSo.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.dBR.setCancelListener(null);
        this.dBR.setTipString(R.string.sending);
        this.dBR.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.dBR.setDialogVisiable(false);
    }

    private Boolean cVc() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.duj = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void cGt() {
        if (this.jVD != null) {
            String str = "";
            String str2 = "";
            if (cUJ() != null) {
                str = cUJ().getText().toString();
            }
            if (cUI() != null) {
                str2 = cUI().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.jVD.getType() == 0 || this.jVD.getType() == 9 || this.jVD.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.jVE == com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.jVD.setIsNoTitle(true);
                        } else if (this.kRz.getVisibility() == 0) {
                            this.jVD.setIsNoTitle(false);
                            tP(true);
                            return;
                        }
                    } else if (this.kRz.getVisibility() == 0) {
                        this.jVD.setIsNoTitle(false);
                        tP(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.jVD.setIsNoTitle(true);
                } else if (this.kRz.getVisibility() == 0) {
                    this.jVD.setIsNoTitle(false);
                    tP(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.kRQ) {
                    tP(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    tP(true);
                }
            }
            if (this.jVD.getType() == 4) {
                tP(m(this.kSw) && l(this.kSA));
            } else if (this.jVD.getType() == 5) {
                tP(m(this.kSw));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                tP(true);
            } else if (this.jVD.getVideoInfo() != null) {
                tP(true);
            } else {
                tP(false);
            }
        }
    }

    public void tP(boolean z) {
        if (z) {
            am.setNavbarTitleColor(this.jWa, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.jWa.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.jWa, R.color.cp_cont_d, 1);
        this.jWa.setEnabled(false);
    }

    private boolean l(EditText editText) {
        long k = k(editText);
        return k <= 20 && k > 0;
    }

    private boolean m(EditText editText) {
        long k = k(editText);
        if (k > 233) {
            return false;
        }
        return k > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        String stringExtra;
        this.duf = new NewWriteModel(this);
        this.duf.b(this.dut);
        registerListener(this.kST);
        this.gdj = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.cGk();
            }
        };
        this.jVD = new WriteData();
        if (bundle != null) {
            this.jVD.setType(bundle.getInt("type", 0));
            this.jVD.setForumId(bundle.getString("forum_id"));
            this.jVD.setForumName(bundle.getString("forum_name"));
            this.jVD.setFirstDir(bundle.getString("forum_first_dir"));
            this.jVD.setSecondDir(bundle.getString("forum_second_dir"));
            this.jVD.setThreadId(bundle.getString("thread_id"));
            this.jVD.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.jVD.setFloorNum(bundle.getInt("floor_num", 0));
            this.kSi = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.kSj = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.kSp = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.kSq = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.dud = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.kRE = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.jVD.setIsAddition(this.kRE != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.kSr = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.jVD.setTitle(bundle.getString("write_title"));
            this.jVD.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.jVD.setTopicId(this.mTopicId);
            this.gLX = bundle.getString("KEY_CALL_FROM");
            this.axG = bundle.getInt("album_thread");
            stringExtra = string;
        } else {
            Intent intent = getIntent();
            this.jVD.setType(intent.getIntExtra("type", 0));
            this.jVD.setForumId(intent.getStringExtra("forum_id"));
            this.jVD.setForumName(intent.getStringExtra("forum_name"));
            this.jVD.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.jVD.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.jVD.setThreadId(intent.getStringExtra("thread_id"));
            this.jVD.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.jVD.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.kSi = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.kSj = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.kSp = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.kSq = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.kRE = (AdditionData) intent.getSerializableExtra("addition_data");
            this.jVD.setIsAddition(this.kRE != null);
            this.jVD.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.kSr = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.gkr = intent.getStringExtra("more_forum_img");
            this.gks = intent.getStringExtra("more_forum_title");
            this.gkq = intent.getStringExtra("more_forum_url");
            this.jVD.setTitle(intent.getStringExtra("write_title"));
            this.jVD.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.jVD.setTopicId(this.mTopicId);
            this.gLX = intent.getStringExtra("KEY_CALL_FROM");
            this.axG = intent.getIntExtra("album_thread", 0);
            stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
        }
        if (this.jVD.getType() == 9) {
            this.jVD.setEntranceType(1);
        } else if (this.jVD.getType() == 10) {
            this.jVD.setEntranceType(2);
            this.jVD.setType(9);
        } else if (this.jVD.getType() == 0) {
            this.jVD.setEntranceType(3);
        }
        this.jVD.setIsUserFeedback(this.kSi);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (stringExtra != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.jVD.getType() == 4 ? 6 : 9);
        this.jVD.setWriteImagesInfo(this.writeImagesInfo);
        if (this.jVD.getType() == 0 || this.jVD.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                v.c(this.jVD.getForumId(), this);
            }
        } else if (this.jVD.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                v.c("24591571", this);
            }
        } else if (this.jVD.getType() == 1) {
            v.a(this.jVD.getThreadId(), this);
        } else if (this.jVD.getType() == 4) {
            v.c(this.jVD.getForumId() + "photolive", this);
        } else if (this.jVD.getType() == 5) {
            v.a(this.jVD.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.ifl = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.jVD != null && this.jVD.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.jVD.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.kRx = true;
        }
        cUC();
        try {
            this.kSG = cVl();
        } catch (Throwable th) {
            this.kSG = null;
        }
    }

    private void cUL() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.jVV.setText(com.baidu.tbadk.plugins.b.vo(com.baidu.tbadk.plugins.b.vp(hotTopicBussinessData.mTopicName)));
            this.jVV.setMovementMethod(com.baidu.tieba.view.c.cRV());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString vo = com.baidu.tbadk.plugins.b.vo(com.baidu.tbadk.plugins.b.vp(hotTopicBussinessData.mTopicName));
            if (vo != null) {
                this.jVV.setText(vo);
            }
            this.kRS.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.v.a
    public void a(WriteData writeData) {
        String str;
        String vp;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            if (writeData != null) {
                if (this.jVD != null) {
                    this.jVD.setHaveDraft(true);
                    if (com.baidu.adp.lib.util.k.isEmpty(cUJ().getText().toString()) || this.kSN || ((this.kSi || this.kRx) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                        if (com.baidu.adp.lib.util.k.isEmpty(this.jVD.getTitle())) {
                            this.jVD.setTitle(writeData.getTitle());
                        }
                        if (!com.baidu.tbadk.core.util.v.isEmpty(this.mList)) {
                            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.getItem(this.mList, 0);
                            if (hotTopicBussinessData == null) {
                                str = null;
                            } else {
                                str = hotTopicBussinessData.mTopicName;
                            }
                            if (StringUtils.isNull(str)) {
                                vp = this.jVD.getTitle();
                            } else {
                                vp = com.baidu.tbadk.plugins.b.vp(str);
                            }
                            SpannableString vo = com.baidu.tbadk.plugins.b.vo(vp);
                            if (vo != null) {
                                cUJ().setText(vo);
                                cUJ().setSelection(vo.length() > vp.length() ? vp.length() : vo.length());
                            }
                        } else {
                            SpannableString vo2 = com.baidu.tbadk.plugins.b.vo(this.jVD.getTitle());
                            if (vo2 != null) {
                                cUJ().setText(vo2);
                                cUJ().setSelection(this.jVD.getTitle().length() > vo2.length() ? vo2.length() : this.jVD.getTitle().length());
                            }
                        }
                    }
                    if (this.jVD != null && !this.jVD.getHaveDraft()) {
                        cUB();
                    }
                    if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.copy(writeData.getVideoInfo());
                        this.jVD.setVideoInfo(videoInfo);
                        this.dsz.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                    }
                    if ((com.baidu.adp.lib.util.k.isEmpty(cUI().getText().toString()) || this.kSi || this.kRx) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                        this.jVD.setContent(writeData.getContent());
                        SpannableString a2 = TbFaceManager.aNr().a(getPageContext().getPageActivity(), this.jVD.getContent(), this.kRX);
                        cUI().setText(a2);
                        cUI().setSelection(a2.length());
                        if (this.kRQ) {
                            a(this.kSC, this.kSw);
                        }
                    }
                    if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                        this.writeImagesInfo = writeData.getWriteImagesInfo();
                        this.jVD.setWriteImagesInfo(this.writeImagesInfo);
                        cVj();
                        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                            cUR();
                        }
                        tR(false);
                    }
                    if (writeData.getType() == 4 || writeData.getType() == 5) {
                        cVd();
                    }
                    cGt();
                    int categoryTo = writeData.getCategoryTo();
                    if (categoryTo >= 0 && this.kRJ != null) {
                        this.kRN = this.kRK.gpO;
                        this.kRM = this.kRK.name;
                        int i = 0;
                        while (true) {
                            if (i == this.kRJ.size()) {
                                break;
                            }
                            w wVar = this.kRJ.get(i);
                            if (categoryTo != wVar.gpO) {
                                i++;
                            } else {
                                this.kRN = categoryTo;
                                this.kRM = wVar.name;
                                this.jVD.setCategoryTo(this.kRN);
                                break;
                            }
                        }
                        if (this.kRO != null) {
                            this.kRO.setText(this.kRM);
                            this.kRO.setCategoryContainerData(this.kRJ, this.kRK, this.kRN);
                        }
                    }
                    this.dsz.aKs();
                    return;
                }
                return;
            }
            cVd();
            cUB();
        }
    }

    private void cVd() {
        if ((!this.kRQ || this.kSv != null) && this.kSu != null) {
            this.kSv.b(this.writeImagesInfo);
            cVh();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.jVD.getType());
        bundle.putString("forum_id", this.jVD.getForumId());
        bundle.putString("forum_name", this.jVD.getForumName());
        bundle.putString("forum_first_dir", this.jVD.getFirstDir());
        bundle.putString("forum_second_dir", this.jVD.getSecondDir());
        bundle.putString("thread_id", this.jVD.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.jVD.getFloor());
        bundle.putInt("floor_num", this.jVD.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.kSp);
        if (this.kSi) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.dud);
        if (this.kRE != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.kRE));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.kSr);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.gLX);
        bundle.putInt("album_thread", this.axG);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cUI().getEditableText().toString();
        if (obj != null) {
            cUI().setText(TbFaceManager.aNr().a(getPageContext().getPageActivity(), obj, this.kRX));
            cUI().setSelection(cUI().getText().length());
        }
    }

    private String cUM() {
        return (cUI() == null || cUI().getText() == null) ? "" : cUI().getText().toString();
    }

    private String cUN() {
        if (this.jVD == null || cUJ() == null || cUJ().getVisibility() != 0 || cUJ().getText() == null) {
            return "";
        }
        String obj = cUJ().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) > 0 && this.jVE != com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) - 1 && this.jVD.getType() != 4 && this.jWb != null && this.jWb.getText() != null) {
            this.jVD.setPostPrefix(this.jWb.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.jVD.getTitle();
        }
        return obj;
    }

    private void KQ(String str) {
        if (this.jVD != null && this.kRz != null) {
            if (this.kRz.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.jVD.setIsNoTitle(true);
                    this.jVD.setTitle("");
                    return;
                }
                this.jVD.setIsNoTitle(false);
                this.jVD.setTitle(str);
                return;
            }
            this.jVD.setIsNoTitle(true);
            this.jVD.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUO() {
        cGk();
        this.jVD.setContent(cUM());
        KQ(cUN());
        if (this.kSi || this.kRx) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.jVD.getTitle()) || !this.jVD.getTitle().startsWith(string)) {
                KQ(string + this.jVD.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.jVD.getContent()) || !this.jVD.getContent().startsWith(str)) {
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
                    sb.append(RomUtils.UNKNOWN);
                }
                sb.append(":");
                sb.append(this.jVD.getContent());
                this.jVD.setContent(sb.toString());
            }
        }
        if (this.kRL >= 0) {
            this.jVD.setCategoryFrom(this.kRL);
        }
        if (this.kRN >= 0) {
            this.jVD.setCategoryTo(this.kRN);
        }
        this.jVD.setWriteImagesInfo(this.writeImagesInfo);
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
            this.jVD.setTakePhotoNum(i);
        }
        this.jVD.setHasLocationData(this.due != null && this.due.bpD());
        if (this.writeImagesInfo != null) {
            this.duf.sO(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.mList) && this.kRR != null && this.kRR.mIsGlobalBlock == 0) {
            this.jVD.setForumId(String.valueOf(this.kRR.mForumId));
            this.jVD.setForumName(this.kRR.mForumName);
        }
        this.duf.d(this.jVD);
        this.jVD.setContent(this.jVD.getContent().replaceAll("\u0000\n", ""));
        this.jVD.setContent(this.jVD.getContent().replaceAll("\u0000", ""));
        this.jVD.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.duf.cGm().setVoice(this.mVoiceModel.getId());
                this.duf.cGm().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.duf.cGm().setVoice(null);
                this.duf.cGm().setVoiceDuringTime(-1);
            }
        } else {
            this.duf.cGm().setVoice(null);
            this.duf.cGm().setVoiceDuringTime(-1);
        }
        if (!this.duf.cKN()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.gdj);
            this.duf.cKK();
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
            if (this.kRE != null) {
                i2 = this.kRE.getTotalCount();
                i = this.kRE.getAlreadyCount() + 1;
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
                if (this.jVV == getCurrentFocus()) {
                    cUI().clearFocus();
                    this.jVV.requestFocus();
                    if (this.dsz != null) {
                        this.dsz.aKs();
                    }
                    ShowSoftKeyPadDelay(this.jVV);
                } else {
                    cUI().requestFocus();
                    if (this.dsz != null) {
                        this.dsz.aKs();
                    }
                    ShowSoftKeyPadDelay(this.jVZ);
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
                            cUI().getText().insert(cUI().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.jVD.getType() == 0 || this.jVD.getType() == 9) {
                    v.c(this.jVD.getForumId(), (WriteData) null);
                    if (postWriteCallBackData2 != null) {
                    }
                } else if (this.jVD.getType() == 1) {
                    v.d(this.jVD.getThreadId(), (WriteData) null);
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
                                cVi();
                            } else {
                                aD(intent);
                            }
                        } else if (intExtra == 1) {
                            aE(intent);
                        } else {
                            aB(intent);
                            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.kSR) {
                            tQ(true);
                            this.kSR = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.kRQ) {
                        U(intent);
                        cGt();
                        return;
                    }
                    aC(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.jVD.setVideoInfo(videoInfo);
                        this.dsz.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                        this.dsz.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.dsz.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    cGt();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.kRv) {
                                sb2.append(com.baidu.tbadk.plugins.b.dBx);
                                this.kRv = false;
                            }
                            sb2.append(stringExtra);
                            uQ(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.isEmpty(this.mList) && !com.baidu.tbadk.core.util.v.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                    this.kRR = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                    a(this.kRR);
                }
            }
        } else if (i2 == 0) {
            if (this.dsz != null && !this.dsz.aLX()) {
                this.jVZ.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.dsz.aKs();
            }
            switch (i) {
                case 12001:
                    aMD();
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    cVg();
                    if (this.kSR) {
                        tQ(true);
                        this.kSR = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.jVV == getCurrentFocus()) {
                        cUI().clearFocus();
                        this.jVV.requestFocus();
                        if (this.dsz != null) {
                            this.dsz.aKs();
                        }
                        ShowSoftKeyPadDelay(this.jVV);
                        return;
                    }
                    cUI().requestFocus();
                    if (this.dsz != null) {
                        this.dsz.aKs();
                    }
                    ShowSoftKeyPadDelay(this.jVZ);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.kRV.Kx(postWriteCallBackData.getErrorString());
                        this.kRV.aV(postWriteCallBackData.getSensitiveWords());
                        this.kRV.b(this.jVV, this.jVZ);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.dud = String.valueOf(System.currentTimeMillis());
                    al.a(getPageContext(), this.dud);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    cVg();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.kRu)) {
                        cUJ().requestFocus();
                        return;
                    } else if ("from_content".equals(this.kRu)) {
                        cUI().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUP() {
        if ("1".equals(this.gLX)) {
            this.jVD.setCanNoForum(true);
            this.jVD.setTransmitForumData("[]");
        } else if ("2".equals(this.gLX)) {
            this.jVD.setCanNoForum(false);
        }
        cUQ();
        this.jVD.setPrivacy(this.isPrivacy);
        cVe();
        this.jVD.setToDynamic(this.isToDynamic);
        this.jVD.setCallFrom(this.gLX);
        if (this.jVD.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cUO();
    }

    private void cUQ() {
        if (this.dsz != null) {
            this.dsz.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void cVe() {
        if (this.dsz != null) {
            this.dsz.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void cVf() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void cVg() {
        if (this.kRQ) {
            this.kSv.b(this.writeImagesInfo);
            cVh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVh() {
        this.kSv.notifyDataSetChanged();
        this.kSu.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.kSv.notifyDataSetChanged();
                WriteActivity.this.kSu.invalidateViews();
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
        cGt();
    }

    private void aB(Intent intent) {
        if (this.kRQ) {
            aC(intent);
            cVg();
        } else {
            aF(intent);
        }
        cGt();
    }

    private void aC(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            cVg();
            tR(true);
        }
    }

    private void aD(Intent intent) {
        if (this.writeImagesInfo != null) {
            T(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, size)));
            }
        }
    }

    private void cVi() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void aE(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.kSs.parseJson(stringExtra);
            this.kSs.updateQuality();
            if (this.kSs.getChosedFiles() != null && this.kSs.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.kSs.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.kSs.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cUJ());
        HidenSoftKeyPad(this.mInputManager, cUI());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void aF(Intent intent) {
        c(intent, true);
    }

    private void T(Intent intent) {
        this.dud = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.dud;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.getEquipmentWidth(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.dud, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            cVj();
            cUR();
        }
        tR(true);
    }

    private void U(Intent intent) {
        c(intent, false);
    }

    private void c(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                cVj();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    cUR();
                }
            }
            tR(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVj() {
        if (this.dsz.lX(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void aMD() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.dud));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void cVk() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.gkr)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                com.baidu.tbadk.util.o oVar = new com.baidu.tbadk.util.o(this, this.gkr, new o.a() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                    @Override // com.baidu.tbadk.util.o.a
                    public void onError(int i, String str) {
                    }

                    @Override // com.baidu.tbadk.util.o.a
                    public void onSuccess(String str) {
                        if (new File(str).exists() && WriteActivity.this.writeImagesInfo != null) {
                            WriteActivity.this.writeImagesInfo.clear();
                            ImageFileInfo imageFileInfo = new ImageFileInfo();
                            imageFileInfo.setFilePath(str);
                            imageFileInfo.isFromMoreForum = true;
                            WriteActivity.this.writeImagesInfo.addChooseFile(imageFileInfo);
                            WriteActivity.this.writeImagesInfo.setMaxImagesAllowed(1);
                            WriteActivity.this.tR(true);
                        }
                    }
                });
                oVar.setFrom(1);
                oVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tR(boolean z) {
        String forumId = this.jVD == null ? "" : this.jVD.getForumId();
        if (this.kSt != null) {
            this.kSt.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.gmi == null) {
            this.gmi = VoiceManager.instance();
        }
        return this.gmi;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bCF() {
        this.gmi = getVoiceManager();
        this.gmi.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bc(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.gnp) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).Z("obj_locate", at.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.jVD.getType() != 7) {
                if (this.kRE == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                B(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.duk = i;
        if (this.dsz != null) {
            this.dsz.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void cUR() {
        if (!this.kRQ) {
            if (this.dsz != null) {
                this.dsz.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.dsz.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.jVD == null ? "" : this.jVD.getForumId();
            if (this.kSt != null) {
                this.kSt.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gC(boolean z) {
        if (this.dsz != null) {
            this.dsz.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void En(int i) {
        if (i < this.kRC.size()) {
            for (int i2 = 0; i2 < this.kRC.size(); i2++) {
                this.kRC.get(i2).tG(false);
            }
            this.kRC.get(i).tG(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void BW(int i) {
        if (i == com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new an("c13014").Z("obj_type", 1));
        } else {
            TiebaStatic.log(new an("c13014").Z("obj_type", 2));
        }
        this.jVE = i;
        this.jWc.setCurrentIndex(i);
        En(i);
        this.jWb.setText(this.mPrefixData.getPrefixs().get(i));
        cGt();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.jWc, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.jWe.setSelected(false);
        am.setImageResource(this.jWd, R.drawable.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.jVZ);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes11.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.jVD != null) {
            if (this.jVD.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.jVD.getType() == 5) {
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
            aMx();
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = ab.transformPermissionResult(strArr, iArr);
            if (ab.checkCamera(getApplicationContext())) {
                al.a(getPageContext(), this.dud);
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
        this.aqT = z;
        if (this.kSL && System.currentTimeMillis() - this.kSM < 800) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.kSL = false;
        }
        if (this.kRU != null && !z) {
            this.kRU.bxc();
        }
        if (this.kRW != null && !z) {
            cUu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KR(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.kSI != null) {
            KS(str);
            this.kSI.dismiss();
        }
    }

    private void fJ(Context context) {
        kSK = l.getEquipmentHeight(context);
    }

    private void KS(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.kSL = true;
        cVj();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            cUR();
        }
        tR(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [4447=4] */
    private static Bitmap g(String str, float f) {
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

    private File cVl() {
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

    private void cVm() {
        if (this.kSG != null && this.jVD.getType() == 0 && this.jVD.getType() == 9) {
            fJ(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.kSG != null) {
                        WriteActivity.this.KR(WriteActivity.this.kSG.getAbsolutePath());
                    }
                }
            });
            this.kSH = (TbImageView) this.mBubbleView.findViewById(R.id.rec_img_view);
            this.kSJ = (LinearLayout) this.mBubbleView.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.aDr().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.kSG.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.aDr().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.kSG.getAbsolutePath());
                Bitmap g = g(this.kSG.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (g != null) {
                    this.kSH.setImageBitmap(g);
                    this.kSH.setDrawBorder(true);
                    this.kSH.setBorderWidth(2);
                    this.kSH.setBorderColor(am.getColor(R.color.common_color_10264));
                    this.kSI = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.kSI.setCanceledOnTouchOutside(true);
                    this.kSI.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.kSL) {
                                l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.kSM = System.currentTimeMillis();
                            }
                        }
                    });
                    this.kSI.setContentView(this.mBubbleView);
                    this.kSI.show();
                    Window window = this.kSI.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (kSK / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.aqT && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.kRv = false;
            this.kRu = "";
            if ("from_content".equals(str)) {
                this.kRu = "from_content";
            } else if ("from_title".equals(str)) {
                this.kRu = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.vn(String.valueOf(charSequence.charAt(i)))) {
                tO(false);
            }
        }
    }

    public void cBH() {
        if (this.kSi || !com.baidu.tbadk.core.util.v.isEmpty(this.mList) || !StringUtils.isNull(this.jVD.getTitle())) {
            this.kRz.setVisibility(0);
            this.kRz.requestFocus();
            return;
        }
        this.kRz.setVisibility(8);
    }
}
