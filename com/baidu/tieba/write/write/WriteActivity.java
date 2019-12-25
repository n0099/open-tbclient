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
import com.baidu.tbadk.coreExtra.data.y;
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
/* loaded from: classes10.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0072a, VoiceManager.c, v.a, h.a {
    private static int kPj = 0;
    private EditorTools dsn;
    private String dtS;
    private LocationModel dtT;
    private NewWriteModel dtU;
    private String ghg;
    private String ghh;
    private String ghi;
    private VoiceManager giZ;
    private LinearLayout iEn;
    private PlayVoiceBntNew iEo;
    private ImageView iEq;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private com.baidu.tieba.write.h jSA;
    private ImageView jSB;
    private View jSC;
    private int jSb;
    private TextView jSz;
    private com.baidu.tieba.write.b.c kMd;
    private LinearLayout kNX;
    private LinearLayout kNY;
    private com.baidu.tieba.view.b kOC;
    private View kOL;
    private g kOS;
    private View kOa;
    private Toast kOc;
    private AdditionData kOd;
    private RelativeLayout kOe;
    private TextView kOf;
    private TextView kOg;
    private TextView kOh;
    List<w> kOi;
    w kOj;
    private int kOk;
    private String kOl;
    private int kOm;
    private PostCategoryView kOn;
    private HotTopicBussinessData kOq;
    private TextView kOr;
    private com.baidu.tieba.write.editor.b kOt;
    private e kOv;
    private View kPn;
    private View kPo;
    private TextView kPp;
    private com.baidu.tieba.c.d kPr;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String kNT = "";
    private boolean kNU = false;
    private WriteData jSa = null;
    private boolean kOH = false;
    private boolean kNW = false;
    private boolean kOI = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText jSt = null;
    private HeadImageView kOJ = null;
    private View jSu = null;
    private LinearLayout jSw = null;
    private EditText jSx = null;
    private FeedBackModel kNZ = null;
    private FeedBackTopListView kOK = null;
    private ArrayList<WritePrefixItemLayout> kOb = new ArrayList<>();
    private String ibD = null;
    private final KeyEvent fVk = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView kOM = null;
    private TextView jSy = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener fZZ = null;
    private com.baidu.tbadk.core.dialog.a kON = null;
    private final Handler mHandler = new Handler();
    private boolean kOO = false;
    private String kOP = null;
    private RelativeLayout hmv = null;
    private String dtY = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int dtZ = 0;
    private int kOQ = 0;
    private WriteImagesInfo kOR = new WriteImagesInfo();
    private View mRootView = null;
    private GridView kOT = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a kOU = null;
    private ScrollView kOo = null;
    private EditText kOV = null;
    private View kOW = null;
    private View kOX = null;
    private View kOY = null;
    private EditText kOZ = null;
    private TextView kPa = null;
    private TextView kPb = null;
    private TextWatcher kPc = null;
    private TextWatcher kPd = null;
    private boolean kOp = false;
    private boolean kPe = false;
    private com.baidu.tbadk.core.view.a dBH = null;
    private String mFrom = "write";
    private File kPf = null;
    private TbImageView kPg = null;
    private View mBubbleView = null;
    private Dialog kPh = null;
    private LinearLayout kPi = null;
    private boolean kPk = false;
    private long kPl = -1000;
    private boolean kPm = false;
    private String gIK = "2";
    private int awX = 0;
    private String mTopicId = "";
    private SpannableStringBuilder kOs = new SpannableStringBuilder();
    private boolean kPq = false;
    private boolean aqh = false;
    private final b kOu = new b();
    private final HttpMessageListener kPs = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.ibD)) {
                    WriteActivity.this.ibD = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.tE(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.ibD)) {
                    WriteActivity.this.ibD = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.ibD);
                    WriteActivity.this.tE(true);
                }
            }
        }
    };
    private TbFaceManager.a kOw = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan uZ(String str) {
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
    private final AntiHelper.a gkg = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).Z("obj_locate", at.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).Z("obj_locate", at.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d dui = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.bBD();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.jSa != null) {
                WriteActivity.this.kOu.aV(null);
                if (z) {
                    WriteActivity.this.gx(z);
                    if (WriteActivity.this.e(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    if (WriteActivity.this.jSa.getType() != 0 && WriteActivity.this.jSa.getType() != 9) {
                        if (WriteActivity.this.jSa.getType() != 7) {
                            if (WriteActivity.this.jSa.getType() == 1) {
                                v.d(WriteActivity.this.jSa.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.jSa.getType() == 5) {
                                v.d(WriteActivity.this.jSa.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            v.c("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            v.c(WriteActivity.this.jSa.getForumId(), (WriteData) null);
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
                    WriteActivity.this.kOu.aV(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.kOu.Kn(postWriteCallBackData.getErrorString());
                    WriteActivity.this.kOu.b(WriteActivity.this.jSt, WriteActivity.this.jSx);
                } else if ((yVar == null || writeData == null || yVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (yVar != null && writeData != null && yVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(yVar.getVcode_md5());
                    writeData.setVcodeUrl(yVar.getVcode_pic_url());
                    writeData.setVcodeExtra(yVar.aGR());
                    if (com.baidu.tbadk.s.a.vB(yVar.aGQ())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, yVar.aGQ());
                        if (WriteActivity.this.kOI) {
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
    private final LocationModel.a dug = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void aMt() {
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
            if (aVar != null && !StringUtils.isNull(aVar.cIY())) {
                WriteActivity.this.b(2, true, aVar.cIY());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener kek = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.dtT.sA(false);
                    WriteActivity.this.dtT.ev(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.dtT.sA(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener kOx = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener kOy = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.dsn.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cTo = WriteActivity.this.cTo();
            if (cTo >= 0 && cTo < WriteActivity.this.jSx.getText().length()) {
                WriteActivity.this.jSx.setSelection(cTo);
            }
        }
    };
    private boolean kOz = true;
    private final View.OnFocusChangeListener jSr = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.jSt || view == WriteActivity.this.mBack || view == WriteActivity.this.jSy) {
                if (z) {
                    WriteActivity.this.kOz = true;
                    WriteActivity.this.cTp();
                    l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.jSt);
                    if (WriteActivity.this.dsn != null) {
                        WriteActivity.this.dsn.aJZ();
                    }
                } else if (view == WriteActivity.this.jSt) {
                    WriteActivity.this.jSz.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.jSx && z) {
                WriteActivity.this.kOz = false;
                WriteActivity.this.cTp();
                l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.jSx);
                if (WriteActivity.this.dsn != null) {
                    WriteActivity.this.dsn.aJZ();
                }
            }
            WriteActivity.this.cTu();
        }
    };
    private TextWatcher kOA = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String kOE = "";
        private String kOF;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kOF = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.kOF != null ? this.kOF.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cFp();
            WriteActivity.this.cTv();
            EditText cTG = WriteActivity.this.cTG();
            if (editable != null && cTG != null && cTG.getText() != null) {
                if (this.kOE == null || !this.kOE.equals(editable.toString())) {
                    if (WriteActivity.this.kOu != null) {
                        this.kOE = cTG.getText().toString();
                        WriteActivity.this.kOu.b(cTG, true);
                        return;
                    }
                    return;
                }
                cTG.setSelection(cTG.getSelectionEnd());
            }
        }
    };
    private TextWatcher kOB = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String kOF;
        private String kOG = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kOF = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.kOF != null ? this.kOF.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cFp();
            EditText cTF = WriteActivity.this.cTF();
            if (editable != null && cTF != null && cTF.getText() != null) {
                if (this.kOG == null || !this.kOG.equals(editable.toString())) {
                    if (WriteActivity.this.kOu != null) {
                        this.kOG = cTF.getText().toString();
                        WriteActivity.this.kOu.b(cTF, false);
                        return;
                    }
                    return;
                }
                cTF.setSelection(cTF.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0597a iKu = new a.InterfaceC0597a() { // from class: com.baidu.tieba.write.write.WriteActivity.31
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0597a
        public void onRefresh() {
            WriteActivity.this.ibD = null;
            WriteActivity.this.tE(false);
            WriteActivity.this.dsn.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void aMd() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void aMe() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aMg();
        } else if (this.dtT.cJf()) {
            aMd();
        } else {
            this.dtT.sA(false);
            b(1, true, null);
            this.dtT.cJd();
        }
    }

    public void cTQ() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
            if (this.kOt != null) {
                this.kOt.cSv();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aMg();
        } else if (this.dtT != null) {
            this.dtT.sA(false);
            b(1, true, null);
            this.dtT.cJd();
        }
    }

    private void aMg() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.jF(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.dtT.cJh();
                } else {
                    WriteActivity.this.dug.aMt();
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
        aVar.aBW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cTo() {
        int selectionEnd = cTF().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cTF().getText().getSpans(0, cTF().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cTF().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cTF().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTp() {
        if (this.dsn != null) {
            this.dsn.setBarLauncherEnabled(!this.kOz);
            this.dsn.setBarLauncherEnabled(true, 26);
            this.dsn.setBarLauncherEnabled(true, 2);
            this.dsn.setBarLauncherEnabled(true, 30);
            W(9, this.kOz ? false : true);
        }
    }

    private void W(int i, boolean z) {
        com.baidu.tbadk.editortools.g lU;
        if (this.dsn != null && (lU = this.dsn.lU(i)) != null) {
            if (z) {
                lU.lw();
            } else {
                lU.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.kOp) {
            this.jSt.setVisibility(8);
            if (this.jSa.getType() == 5) {
                this.kOY.setVisibility(8);
            } else {
                this.kOY.setVisibility(0);
            }
            a(this.kPb, this.kOV);
            a(this.kPa, this.kOZ);
            cFp();
        }
        if (this.kOH) {
            this.kOz = true;
            cTp();
            if (this.dsn != null) {
                this.dsn.aJZ();
            }
            this.jSt.requestFocus();
            ShowSoftKeyPadDelay(this.jSt);
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
            cUg();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                cTO();
            }
            tF(true);
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
        if (this.jSa.getType() == 0) {
            Ej(this.awX);
        }
        initUI();
        cTV();
        this.dtT = new LocationModel(getPageContext());
        this.dtT.a(this.dug);
        registerListener(this.kek);
        registerListener(this.kOx);
        ccX();
        cUj();
        if (this.kOp) {
            this.kOU.setEditorTools(this.dsn);
        } else {
            this.jSx.requestFocus();
        }
        cAB();
        cTO();
        cUh();
    }

    @SuppressLint({"ResourceAsColor"})
    private void ccX() {
        this.dsn = new EditorTools(getActivity());
        this.dsn.setBarMaxLauCount(5);
        this.dsn.setMoreButtonAtEnd(true);
        this.dsn.setBarBackgroundColorId(R.color.cp_bg_line_h);
        this.dsn.setBarLauncherType(1);
        this.dsn.gp(true);
        this.dsn.gq(true);
        switch (this.jSa.getType()) {
            case 4:
            case 5:
                cTT();
                break;
            default:
                cTq();
                break;
        }
        this.dsn.build();
        if (this.kNX != null) {
            this.kNX.addView(this.dsn);
        }
        bXd();
        this.dsn.lw();
        com.baidu.tbadk.editortools.g lU = this.dsn.lU(6);
        if (lU != null && !TextUtils.isEmpty(this.dtY)) {
            ((View) lU).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.dtY);
                }
            });
        }
        if (!this.kOp) {
            this.dsn.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.dsn.aJZ();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.dsn.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.dsn.b(new com.baidu.tbadk.editortools.a(2, 26, HanziToPinyin.Token.SEPARATOR));
        }
        cTs();
    }

    private void cTR() {
        this.kOW = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.kOY = this.kOW.findViewById(R.id.live_post_title_container);
        this.kOV = (EditText) this.kOW.findViewById(R.id.live_post_content);
        this.kOT = (GridView) this.kOW.findViewById(R.id.photoLiveGridView);
        this.kOZ = (EditText) this.kOW.findViewById(R.id.live_post_title);
        this.kPa = (TextView) this.kOW.findViewById(R.id.titleOverPlusNumber);
        this.kPb = (TextView) this.kOW.findViewById(R.id.contentOverPlusNumber);
        this.kOX = this.kOW.findViewById(R.id.live_interval_view);
        this.kPa.setText(String.valueOf(20));
        this.kPb.setText(String.valueOf(233));
        this.kOW.setVisibility(0);
        this.kPa.setVisibility(0);
        this.kPb.setVisibility(0);
        this.kOZ.setHint(R.string.tips_title_limit_new);
        this.kOZ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.kPe = true;
                    WriteActivity.this.kOz = true;
                    WriteActivity.this.cTp();
                    if (WriteActivity.this.dsn != null) {
                        WriteActivity.this.dsn.aJZ();
                    }
                }
            }
        });
        if (this.jSa.getType() == 4) {
            this.kOV.setHint(R.string.live_write_input_content_new);
        } else if (this.jSa.getType() == 5) {
            this.kOV.setHint(R.string.live_write_input_content_update);
        }
        this.kOV.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.kPe = false;
                    WriteActivity.this.kOz = false;
                    WriteActivity.this.cTp();
                    if (WriteActivity.this.dsn != null) {
                        WriteActivity.this.dsn.aJZ();
                    }
                }
            }
        });
        this.kOV.requestFocus();
        this.kOV.addTextChangedListener(Ra());
        this.kOZ.requestFocus();
        this.kOZ.addTextChangedListener(Ra());
        this.kOZ.setOnClickListener(this.kOy);
        this.kOV.setOnClickListener(this.kOy);
        this.kOU = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.kOT);
        this.kOU.Ed(6);
        this.kOT.setAdapter((ListAdapter) this.kOU);
        View findViewById = this.kOW.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void cTa() {
                WriteActivity.this.cUe();
            }
        });
        cTS();
    }

    private void cTS() {
        if (this.jSa.getType() == 0) {
            if (this.jSa.getTitle() != null) {
                this.kOZ.setText(this.jSa.getTitle());
                this.kOZ.setSelection(this.jSa.getTitle().length());
                return;
            }
            return;
        }
        if (this.jSa.getType() == 1 || this.jSa.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.kOp) {
            cUc();
        }
        if (this.dsn.aLE()) {
            this.dsn.aJZ();
        }
        Ej(0);
    }

    private void Ej(int i) {
        if (this.writeImagesInfo != null && this.jSa != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.jSa.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.jSa.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.gIK);
            albumActivityConfig.setProfessionZone(this.jSa.getProZone());
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void cTT() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.dsn.aJ(arrayList);
        com.baidu.tbadk.editortools.l lX = this.dsn.lX(5);
        if (lX != null) {
            lX.dsY = 2;
        }
        this.dsn.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.dsn.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void cTq() {
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
            this.dsn.b(dVar);
        }
        Boolean cTZ = cTZ();
        if (!this.kOH && cTZ != null && cTZ.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.cJF() && r.d(this.jSa.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar5 = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar5.dsY = 3;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dsn.b(lVar5);
            }
        }
        this.dsn.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 4));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask2 != null && (lVar4 = (com.baidu.tbadk.editortools.l) runTask2.getData()) != null) {
            lVar4.dsY = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dsn.b(lVar4);
            }
        }
        this.dsn.b(new com.baidu.tbadk.editortools.k(getActivity(), 6));
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask3 != null && (lVar3 = (com.baidu.tbadk.editortools.l) runTask3.getData()) != null) {
            lVar3.dsY = 7;
            this.dsn.b(lVar3);
        }
        this.dsn.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 8));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask4 != null && (lVar2 = (com.baidu.tbadk.editortools.l) runTask4.getData()) != null) {
            lVar2.dta = true;
            lVar2.dsY = 9;
            lVar2.dsU = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dsn.b(lVar2);
            }
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask5 != null && (lVar = (com.baidu.tbadk.editortools.l) runTask5.getData()) != null) {
            lVar.dta = true;
            lVar.dsY = 10;
            lVar.dsU = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dsn.b(lVar);
            }
        }
        if (this.kOd == null) {
            if (this.kOt == null) {
                this.kOt = new com.baidu.tieba.write.editor.b(getActivity(), this.gIK);
                this.kOt.bz(this.jSa.getForumId(), this.privateThread);
                this.kOt.ty(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.kOt.cSr();
                this.kOt.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                cTQ();
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.mList)) {
                this.kOt.cSr();
            }
            this.dsn.b(this.kOt);
        }
        this.dsn.aJ(arrayList);
        com.baidu.tbadk.editortools.l lX = this.dsn.lX(5);
        if (lX != null) {
            lX.dsY = 1;
        }
    }

    private void cTr() {
        if (this.kOv != null) {
            this.kOv.hideTip();
        }
    }

    private void cTs() {
        if (this.kOv == null) {
            this.kOv = new e(getPageContext());
        }
        this.kOv.c(this.dsn);
    }

    private void bXd() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.cTE()) {
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
                            if (pVar.aGJ() == EmotionGroupType.BIG_EMOTION || pVar.aGJ() == EmotionGroupType.USER_COLLECT) {
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
                                    WriteActivity.this.tF(true);
                                    WriteActivity.this.cFp();
                                }
                            } else if (WriteActivity.this.cTE()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(pVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.cTH();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.ckM();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.cUg();
                        WriteActivity.this.cFp();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.Ek(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new an("c12612").Z("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.kOd == null) {
                            WriteActivity.this.aMh();
                            return;
                        }
                        switch (WriteActivity.this.dtZ) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.aMe();
                                    return;
                                } else {
                                    ab.reuqestLocation(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.aMd();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.dtT != null) {
                            WriteActivity.this.dtT.sA(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.ibD = null;
                        } else {
                            WriteActivity.this.ibD = (String) aVar.data;
                        }
                        WriteActivity.this.tE(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        an anVar = new an("c10645");
                        if (WriteActivity.this.jSa != null) {
                            str = WriteActivity.this.jSa.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.cp("fid", str);
                        TiebaStatic.log(anVar);
                        if (WriteActivity.this.jSa == null || (videoInfo = WriteActivity.this.jSa.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.dsn.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.dsn.aLE()) {
                                        WriteActivity.this.dsn.aJZ();
                                        WriteActivity.this.dsn.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.dsn.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                        WriteActivity.this.dsn.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.dsn.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.dsn.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.jSa.setVideoInfo(null);
                        WriteActivity.this.cFp();
                        if (WriteActivity.this.jSx != null) {
                            WriteActivity.this.jSx.requestFocus();
                        }
                        WriteActivity.this.dsn.aJZ();
                        WriteActivity.this.dsn.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.jSx);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new an("c12612").Z("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.dsn.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.kNU = true;
                        WriteActivity.this.tC(true);
                        if (!WriteActivity.this.cTG().isFocused() || WriteActivity.this.kNY.getVisibility() != 0) {
                            WriteActivity.this.kNT = "from_content";
                        } else {
                            WriteActivity.this.kNT = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        if (WriteActivity.this.kNY.getVisibility() == 0) {
                            if (WriteActivity.this.kNY.hasFocus()) {
                                WriteActivity.this.jSx.requestFocus();
                                WriteActivity.this.jSx.setSelection(WriteActivity.this.jSx.getText().toString().length());
                            }
                            WriteActivity.this.kNY.setVisibility(8);
                            WriteActivity.this.dsn.lU(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.kNY.setVisibility(0);
                            WriteActivity.this.kNY.requestFocus();
                            WriteActivity.this.dsn.lU(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.cFp();
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
        this.dsn.setActionListener(16, bVar);
        this.dsn.setActionListener(14, bVar);
        this.dsn.setActionListener(24, bVar);
        this.dsn.setActionListener(3, bVar);
        this.dsn.setActionListener(10, bVar);
        this.dsn.setActionListener(11, bVar);
        this.dsn.setActionListener(12, bVar);
        this.dsn.setActionListener(13, bVar);
        this.dsn.setActionListener(15, bVar);
        this.dsn.setActionListener(18, bVar);
        this.dsn.setActionListener(20, bVar);
        this.dsn.setActionListener(25, bVar);
        this.dsn.setActionListener(27, bVar);
        this.dsn.setActionListener(29, bVar);
        this.dsn.setActionListener(43, bVar);
        this.dsn.setActionListener(56, bVar);
        this.dsn.setActionListener(48, bVar);
        this.dsn.setActionListener(46, bVar);
        this.dsn.setActionListener(49, bVar);
        this.dsn.setActionListener(47, bVar);
        this.dsn.setActionListener(55, bVar);
        this.dsn.setActionListener(58, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ek(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMh() {
        if (this.dtT.boD()) {
            if (this.dtT.cJf()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.cJa().getLocationData().cIY());
                return;
            }
            b(1, true, null);
            this.dtT.cJd();
            return;
        }
        b(0, true, null);
    }

    protected void cFg() {
        if (this.dtU != null) {
            this.dtU.cancelLoadData();
        }
        if (this.kNZ != null) {
            this.kNZ.cancelLoadData();
        }
        if (this.dtT != null) {
            this.dtT.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cTr();
        TiebaPrepareImageService.StopService();
        cFg();
        cTY();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.kOS != null) {
            this.kOS.destroy();
        }
        if (this.kPr != null) {
            this.kPr.wP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTt() {
        if (this.jSa != null && this.jSa.getType() == 2 && this.kOO) {
            finish();
        } else if (this.jSa == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.jSa.setTitle(cTG().getText().toString());
            this.jSa.setContent(cTF().getText().toString());
            int type = this.jSa.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    v.c(this.jSa.getForumId(), this.jSa);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    v.c("24591571", this.jSa);
                }
            } else if (type == 1) {
                v.d(this.jSa.getThreadId(), this.jSa);
            } else if (type == 4) {
                v.c(this.jSa.getForumId() + "photolive", this.jSa);
            } else if (type == 5) {
                v.d(this.jSa.getThreadId() + "updatephotolive", this.jSa);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.jSA != null && this.jSA.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.jSA, getPageContext().getPageActivity());
                return true;
            } else if (this.dsn.aLE()) {
                this.dsn.aJZ();
                return true;
            } else {
                cFg();
                cTt();
                return true;
            }
        }
        if (i == 67 && (text = cTF().getText()) != null) {
            int selectionStart = cTF().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cTF().onKeyDown(67, this.fVk);
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
        getLayoutMode().onModeChanged(this.hmv);
        getLayoutMode().onModeChanged(this.kPi);
        am.setBackgroundColor(this.hmv, R.color.cp_bg_line_e);
        if (this.kPg != null && (i == 1 || i == 4)) {
            this.kPg.setBorderColor(am.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.jSy, R.color.cp_link_tip_a, 1);
        cTp();
        am.setBackgroundColor(this.jSu, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.kOX, R.color.cp_bg_line_c);
        am.setBackgroundColor(cTG(), R.color.cp_bg_line_e);
        am.setImageResource(this.iEq, R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.ibD)) {
            am.setBackgroundColor(cTF(), R.color.cp_bg_line_e);
        }
        cFp();
        this.dsn.onChangeSkinType(i);
        if (this.kOn != null) {
            this.kOn.aFd();
        }
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.kOS.kPN.notifyDataSetChanged();
        cTu();
        cTv();
        tE(false);
        if (this.kOu != null) {
            this.kOu.c(cTG(), cTF());
        }
        this.kMd.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTu() {
        if (this.jSt.hasFocus()) {
            this.jSt.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.jSt.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.jSx.hasFocus()) {
            this.jSx.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.jSx.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTv() {
        if (this.jSt != null && this.jSt.getText() != null && this.jSt.getText().toString() != null && this.jSt.getPaint() != null) {
            if (this.jSt.getText().toString().length() == 0) {
                this.jSt.getPaint().setFakeBoldText(false);
            } else if (this.jSt.getText().toString().length() > 0) {
                this.jSt.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.dBH = new com.baidu.tbadk.core.view.a(getPageContext());
        this.kOp = this.jSa.getType() == 4 || 5 == this.jSa.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aDW().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.kOM = (TextView) findViewById(R.id.btn_image_problem);
        cTx();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jSy.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.jSy.setLayoutParams(layoutParams);
        this.jSy.setOnFocusChangeListener(this.jSr);
        this.kOo = (ScrollView) findViewById(R.id.write_scrollview);
        this.kOo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.jSx != null) {
                        l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.jSx);
                    }
                    if (WriteActivity.this.dsn != null) {
                        WriteActivity.this.dsn.aJZ();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.kOK = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.kOL = findViewById(R.id.feedback_divider);
        this.hmv = (RelativeLayout) findViewById(R.id.parent);
        this.kNX = (LinearLayout) findViewById(R.id.tool_view);
        this.kNX.setContentDescription(IStringUtil.TOP_PATH);
        this.kNY = (LinearLayout) findViewById(R.id.title_view);
        this.jSu = findViewById(R.id.interval_view);
        this.kPn = findViewById(R.id.hot_topic_fourm_view);
        this.kPo = findViewById(R.id.hot_topic_divider);
        this.kOr = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.kPp = (TextView) findViewById(R.id.change_one_tv);
        cFo();
        if (this.kOp) {
            this.kOo.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            cTR();
        } else {
            this.kOS = new g(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.kOS.tw(false);
            } else {
                g gVar = this.kOS;
                if (this.jSa.getType() != 0 && this.jSa.getType() != 9) {
                    z = false;
                }
                gVar.tw(z);
            }
        }
        cFq();
        if (this.kOH || this.kNW) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().cWA) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.jSw = (LinearLayout) findViewById(R.id.post_content_container);
        this.jSw.setDrawingCacheEnabled(false);
        this.jSw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.dsn.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.jSx.requestFocus();
            }
        });
        this.iEn = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.iEo = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.iEq = (ImageView) findViewById(R.id.iv_delete_voice);
        this.iEq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.ckM();
            }
        });
        this.mBack.setOnFocusChangeListener(this.jSr);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cFg();
                WriteActivity.this.cTt();
            }
        });
        this.kOM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        cTA();
        o(cTZ());
        cTC();
        cTw();
        cTW();
        cTX();
        cTp();
        cTB();
        cFn();
        cTI();
        if (this.jSa.getType() == 4 && this.jSC != null && this.kOa != null) {
            this.jSC.setVisibility(8);
            this.kOa.setVisibility(8);
        }
        cFp();
        cTU();
        cSJ();
    }

    private void cSJ() {
        this.kMd = new com.baidu.tieba.write.b.c(getPageContext().getPageActivity(), this.mName, this.jSa.getProZone(), isUseStyleImmersiveSticky() ? StatusBarUtil.getStatusBarOffsetPx(getPageContext().getPageActivity()) : 0);
        this.kMd.a(new c.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // com.baidu.tieba.write.b.c.a
            public void DY(int i) {
                WriteActivity.this.jSa.setProZone(i);
            }
        });
        this.kMd.bvM();
    }

    private void cTw() {
        String str;
        String str2;
        if (this.jSa != null) {
            switch (this.jSa.getType()) {
                case 0:
                case 9:
                    if (this.kOH || this.kNW) {
                        if (this.kOI) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.gIK != null && this.gIK.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                    } else if (this.gIK != null && this.gIK.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.jSa.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.jSa.getForumName() + getResources().getString(R.string.bar));
                        this.jSt.setVisibility(8);
                        String str3 = this.ghi + HanziToPinyin.Token.SEPARATOR + this.ghg;
                        if (!StringUtils.isNull(str3)) {
                            this.jSx.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.jSt.setVisibility(0);
                    this.jSx.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.jSx.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.jSt.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.jSx.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.jSa.getFloorNum() + 1)));
                    this.kOX.setVisibility(8);
                    return;
                case 7:
                    this.jSt.setVisibility(0);
                    this.jSx.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void cTx() {
        if (this.jSa.getType() == 7) {
            this.jSy = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.jSy = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void cTy() {
        if (this.jSa != null && this.jSa.getType() == 0 && this.jSa.getType() == 9 && !this.kOH && !this.kNW && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = aq.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && cTG() != null) {
                cTG().setText(cutStringWithSuffix);
                cTG().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.iEn.setVisibility(0);
            this.iEo.setVoiceModel(voiceModel);
            this.iEo.cJE();
            cFp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckM() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.iEn.setVisibility(8);
        this.iEo.bLD();
        this.iEo.setVoiceModel(null);
        com.baidu.tbadk.editortools.l lX = this.dsn.lX(6);
        if (lX != null && lX.dsh != null) {
            lX.dsh.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cFp();
    }

    private void cTz() {
        this.kOi = null;
        this.kOk = -1;
        this.kOm = -1;
        com.baidu.tieba.frs.y sN = x.bCW().sN(1);
        if (sN != null) {
            this.kOi = sN.gmJ;
            this.kOk = getIntent().getIntExtra("category_id", -1);
            if (this.kOi != null && !this.kOi.isEmpty() && this.kOk >= 0) {
                this.kOj = new w();
                this.kOj.gmF = 0;
                this.kOj.name = getPageContext().getResources().getString(R.string.category_auto);
                this.kOm = this.kOj.gmF;
                this.kOl = this.kOj.name;
                for (w wVar : this.kOi) {
                    if (wVar.gmF == this.kOk) {
                        this.kOm = wVar.gmF;
                        this.kOl = wVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cTA() {
        if (this.kOi != null && !this.kOi.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.kOn = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.kOn.setText(this.kOl);
            this.kOn.setCategoryContainerData(this.kOi, this.kOj, this.kOm);
            this.kOn.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, as asVar) {
                    if (asVar != null) {
                        WriteActivity.this.kOn.setText(asVar.name);
                        WriteActivity.this.jSa.setCategoryTo(asVar.gmF);
                        WriteActivity.this.kOm = asVar.gmF;
                        WriteActivity.this.kOn.cTc();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.kOn.cTb();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cTG());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cTF());
                }
            });
        }
    }

    private void cTU() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.kOC = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.kOC.setTitle(R.string.no_disturb_start_time);
        this.kOC.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.kOC);
        this.kOC.setButton(-2, getPageContext().getString(R.string.cancel), this.kOC);
        return this.kOC;
    }

    private void cTB() {
        this.kOe = (RelativeLayout) findViewById(R.id.addition_container);
        this.kOf = (TextView) findViewById(R.id.addition_create_time);
        this.kOg = (TextView) findViewById(R.id.addition_last_time);
        this.kOh = (TextView) findViewById(R.id.addition_last_content);
        if (this.kOd != null) {
            this.kOe.setVisibility(0);
            this.kOf.setText(getPageContext().getString(R.string.write_addition_create) + aq.getFormatTime(this.kOd.getCreateTime() * 1000));
            if (this.kOd.getAlreadyCount() == 0) {
                this.kOg.setVisibility(8);
            } else {
                this.kOg.setText(getPageContext().getString(R.string.write_addition_last) + aq.getFormatTime(this.kOd.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.kOd.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.kOh.setText(lastAdditionContent);
            } else {
                this.kOh.setVisibility(8);
            }
            cTF().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.kOd.getAlreadyCount()), Integer.valueOf(this.kOd.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.kOe.setVisibility(8);
    }

    private void cFn() {
        this.jSC = findViewById(R.id.post_prefix_layout);
        if (this.kPr == null) {
            this.kPr = new com.baidu.tieba.c.d(getPageContext(), this.jSC);
            this.kPr.bT(R.drawable.bg_tip_blue_up_left);
            this.kPr.bS(16);
            this.kPr.kj(true);
            this.kPr.setUseDirectOffset(true);
            this.kPr.rn(l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.jSz = (TextView) findViewById(R.id.post_prefix);
        this.kOa = findViewById(R.id.prefix_divider);
        this.jSB = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.jSC.setVisibility(0);
            this.kPr.c(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.jSb = 0;
            this.jSC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").cp("fid", WriteActivity.this.jSa.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.jSz.setVisibility(0);
                    WriteActivity.this.jSC.setSelected(true);
                    am.setImageResource(WriteActivity.this.jSB, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.jSA, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.dsn.aJZ();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.jSt);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.jSx);
                }
            });
            this.jSz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").cp("fid", WriteActivity.this.jSa.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.jSz.setSelected(true);
                    am.setImageResource(WriteActivity.this.jSB, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.jSA, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.dsn.aJZ();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cTG());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cTF());
                }
            });
            this.jSA = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.jSA.a(this);
            this.jSA.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.jSA.setOutsideTouchable(true);
            this.jSA.setFocusable(true);
            this.jSA.setOnDismissListener(this);
            this.jSA.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            am.getColor(R.color.cp_cont_c);
            am.setBackgroundResource(this.jSz, R.color.cp_bg_line_d);
            am.setImageResource(this.jSB, R.drawable.icon_arrow_gray_down);
            this.jSz.setTextColor(color);
            this.kOb.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.kOb.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.tt(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.tt(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.jSA.addView(writePrefixItemLayout);
            }
            this.jSA.setCurrentIndex(0);
            this.jSz.setText(prefixs.get(0));
            Ei(0);
            return;
        }
        this.jSC.setVisibility(8);
    }

    private void cTV() {
        if (this.kOH && this.jSa != null) {
            this.kOK.setVisibility(0);
            this.kOL.setVisibility(0);
            this.kNZ = new FeedBackModel(getPageContext());
            this.kNZ.KF(this.jSa.getForumName());
            this.kNZ.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.24
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.kOK.setVisibility(8);
                        WriteActivity.this.kOL.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.kOK.setVisibility(8);
                        WriteActivity.this.kOL.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.kOK.a(feedBackModel.cTe(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void cTC() {
        this.jSy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (WriteActivity.this.kOu.a(WriteActivity.this.jSt, WriteActivity.this.jSx)) {
                        WriteActivity.this.showToast(WriteActivity.this.kOu.cRL());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cTG());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cTF());
                    WriteActivity.this.dsn.aJZ();
                    if (WriteActivity.this.jSa.getType() != 7) {
                        if (WriteActivity.this.kOH) {
                            WriteActivity.this.cTL();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            an anVar = new an("c12102");
                            anVar.Z("obj_type", StringUtils.isNull(WriteActivity.this.jSa.getForumName()) ? 1 : 2);
                            TiebaStatic.log(anVar);
                            WriteActivity.this.cTM();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.cTL();
                    }
                    TiebaStatic.log(new an("c12262").cp("obj_locate", WriteActivity.this.gIK));
                }
            }
        });
    }

    protected void cTW() {
        this.kON = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.kON.sz(getPageContext().getString(R.string.is_save_draft)).fu(false).a(getPageContext().getString(R.string.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.jSa.setTitle(WriteActivity.this.cTG().getText().toString());
                WriteActivity.this.jSa.setContent(WriteActivity.this.cTF().getText().toString());
                int type = WriteActivity.this.jSa.getType();
                if (type == 0 || type == 9) {
                    v.c(WriteActivity.this.jSa.getForumId(), WriteActivity.this.jSa);
                } else if (type == 1) {
                    v.d(WriteActivity.this.jSa.getThreadId(), WriteActivity.this.jSa);
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
                int type = WriteActivity.this.jSa.getType();
                if (type == 0 || type == 9) {
                    v.c(WriteActivity.this.jSa.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    v.d(WriteActivity.this.jSa.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.kON.b(getPageContext());
    }

    protected void cFo() {
        this.kOJ = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.kOJ.setIsRound(true);
        this.kOJ.setDrawBorder(false);
        this.kOJ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String sU = o.sU(currentPortrait);
            this.kOJ.setUrl(sU);
            this.kOJ.startLoad(sU, 12, false);
        }
        if (this.jSa.isUserFeedback()) {
            this.kOJ.setVisibility(0);
        }
        this.jSt = (EditText) findViewById(R.id.post_title);
        this.jSt.setOnClickListener(this.kOy);
        this.jSt.setOnFocusChangeListener(this.jSr);
        if (this.jSa.getType() == 0 || this.jSa.getType() == 9 || this.jSa.getType() == 7) {
            if (this.jSa.getTitle() != null) {
                this.jSt.setText(this.jSa.getTitle());
                this.jSt.setSelection(this.jSa.getTitle().length());
            } else if (this.kOI) {
                this.jSt.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.jSa.getType() == 1 || this.jSa.getType() != 2) {
        }
        this.jSt.addTextChangedListener(this.kOA);
        if (!this.jSa.getHaveDraft()) {
            cTy();
            this.kPm = true;
        }
        if (this.jSa.isUserFeedback()) {
            this.jSt.setHint(getResources().getString(R.string.feedback_title_hint));
        } else {
            this.jSt.setHint(getResources().getString(R.string.post_title_hint));
        }
    }

    private TextWatcher Ra() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            private int kPv;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.cFp();
                if (WriteActivity.this.kOp) {
                    this.kPv = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.kPv);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.kOp || !WriteActivity.this.kPe) {
                    if (WriteActivity.this.kOp) {
                        if (this.mEditText != WriteActivity.this.kOV || this.mTextView != WriteActivity.this.kPb) {
                            this.mEditText = WriteActivity.this.kOV;
                            this.mTextView = WriteActivity.this.kPb;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.kOZ || this.mTextView != WriteActivity.this.kPa) {
                    this.mEditText = WriteActivity.this.kOZ;
                    this.mTextView = WriteActivity.this.kPa;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.kOp && this.kPe) {
            if (this.kPc != null) {
                this.kOZ.removeTextChangedListener(this.kPc);
            }
            this.kPc = textWatcher;
        } else if (this.kOp) {
            if (this.kPd != null) {
                this.kOV.removeTextChangedListener(this.kPd);
            }
            this.kPd = textWatcher;
        }
        return textWatcher;
    }

    private long j(EditText editText) {
        if (editText == this.kOV) {
            return 233L;
        }
        if (editText != this.kOZ) {
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

    protected void cFq() {
        this.jSx = (EditText) findViewById(R.id.post_content);
        this.jSx.setDrawingCacheEnabled(false);
        this.jSx.setOnClickListener(this.kOy);
        if (this.jSa.getContent() != null && this.jSa.getContent().length() > 0) {
            SpannableString aA = TbFaceManager.aMY().aA(getPageContext().getPageActivity(), this.jSa.getContent());
            this.jSx.setText(aA);
            this.jSx.setSelection(aA.length());
        } else if (this.jSa.getType() == 2) {
            if (this.kOO) {
                if (this.kOP != null && this.kOP.length() > 0) {
                    this.jSx.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.kOP}));
                    this.jSx.setSelection(this.jSx.getText().length());
                }
            } else if (this.jSa.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.jSa.getFloorNum()));
                this.jSx.setText(format);
                this.jSx.setSelection(format.length());
            }
        }
        this.jSx.setOnFocusChangeListener(this.jSr);
        this.jSx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.dsn.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.jSx.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.jSx.addTextChangedListener(this.kOB);
        if (this.jSa.getType() == 0) {
            this.kPq = true;
        } else {
            tE(true);
            this.kPq = false;
        }
        if (this.jSa.isUserFeedback()) {
            this.jSx.setHint(R.string.write_input_content);
        } else {
            this.jSx.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void tE(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.kOp) {
            cTF().setPadding(0, 0, 0, 0);
            cTF().setBackgroundDrawable(null);
            am.setBackgroundColor(cTF(), R.color.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.ibD) && this.kOd == null) {
                com.baidu.adp.lib.e.c.gs().a(this.ibD, 19, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.30
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
                            WriteActivity.this.cTF().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.cTF(), true, WriteActivity.this.iKu);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cTE() {
        int i = 5000;
        if (this.kOd != null) {
            i = 1000;
        }
        return cTF().getText() != null && cTF().getText().length() >= i;
    }

    private void uL(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.kNT)) {
                this.kNT = "";
                cTF().requestFocus();
                if (cTF().getText() != null && cTF().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cTF().getSelectionStart();
                    editable = cTF().getText();
                }
            } else if ("from_title".equals(this.kNT)) {
                this.kNT = "";
                cTG().requestFocus();
                if (cTG().getText() != null && cTG().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cTG().getSelectionStart();
                    editable = cTG().getText();
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
    public void tC(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.jSa != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.jSa.getForumId(), 0L), this.jSa.getFirstDir(), this.jSa.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(p pVar) {
        if (((ImageSpan[]) cTF().getText().getSpans(0, cTF().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.kOc == null) {
                this.kOc = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            this.kOc.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType aGJ = pVar.aGJ();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.e.c.gs().a(name, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.32
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass32) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.cTF().getSelectionStart(), aVar, aGJ);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cTF() != null && cTF().getText() != null) {
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
                int selectionStart = cTF().getSelectionStart() - 1;
                if (cTF().getText().length() > 1 && selectionStart >= 0 && cTF().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cTF().getText().insert(cTF().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cTF().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cTF().getText().insert(cTF().getSelectionStart(), spannableString2);
            }
            Editable text = cTF().getText();
            if (text != null) {
                this.kOs.clear();
                this.kOs.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.kOs);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cTF().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cTF().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cTF().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cTF() {
        return this.kOp ? this.kOV : this.jSx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cTG() {
        return this.kOp ? this.kOZ : this.jSt;
    }

    protected void cTH() {
        Editable text;
        if (cTF() != null && (text = cTF().getText()) != null) {
            int selectionStart = cTF().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cTF().onKeyDown(67, this.fVk);
            }
            cTF().onKeyDown(67, this.fVk);
            int selectionStart2 = cTF().getSelectionStart();
            if (text != null) {
                this.kOs.clear();
                this.kOs.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.kOs);
                cTF().setSelection(selectionStart2);
            }
        }
    }

    private void o(Boolean bool) {
        String str = null;
        if (this.jSa != null) {
            str = this.jSa.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.kOH = true;
        }
    }

    private void cTX() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void cTY() {
        try {
            if (this.kON != null) {
                this.kON.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.dBH.setCancelListener(null);
        this.dBH.setTipString(R.string.sending);
        this.dBH.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.dBH.setDialogVisiable(false);
    }

    private Boolean cTZ() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.dtY = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void cFp() {
        if (this.jSa != null) {
            String str = "";
            String str2 = "";
            if (cTG() != null) {
                str = cTG().getText().toString();
            }
            if (cTF() != null) {
                str2 = cTF().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.jSa.getType() == 0 || this.jSa.getType() == 9 || this.jSa.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.jSb == com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.jSa.setIsNoTitle(true);
                        } else if (this.kNY.getVisibility() == 0) {
                            this.jSa.setIsNoTitle(false);
                            tD(true);
                            return;
                        }
                    } else if (this.kNY.getVisibility() == 0) {
                        this.jSa.setIsNoTitle(false);
                        tD(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.jSa.setIsNoTitle(true);
                } else if (this.kNY.getVisibility() == 0) {
                    this.jSa.setIsNoTitle(false);
                    tD(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.kOp) {
                    tD(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    tD(true);
                }
            }
            if (this.jSa.getType() == 4) {
                tD(m(this.kOV) && l(this.kOZ));
            } else if (this.jSa.getType() == 5) {
                tD(m(this.kOV));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                tD(true);
            } else if (this.jSa.getVideoInfo() != null) {
                tD(true);
            } else {
                tD(false);
            }
        }
    }

    public void tD(boolean z) {
        if (z) {
            am.setNavbarTitleColor(this.jSy, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.jSy.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.jSy, R.color.cp_cont_d, 1);
        this.jSy.setEnabled(false);
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
        this.dtU = new NewWriteModel(this);
        this.dtU.b(this.dui);
        registerListener(this.kPs);
        this.fZZ = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.cFg();
            }
        };
        this.jSa = new WriteData();
        if (bundle != null) {
            this.jSa.setType(bundle.getInt("type", 0));
            this.jSa.setForumId(bundle.getString("forum_id"));
            this.jSa.setForumName(bundle.getString("forum_name"));
            this.jSa.setFirstDir(bundle.getString("forum_first_dir"));
            this.jSa.setSecondDir(bundle.getString("forum_second_dir"));
            this.jSa.setThreadId(bundle.getString("thread_id"));
            this.jSa.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.jSa.setFloorNum(bundle.getInt("floor_num", 0));
            this.kOH = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.kOI = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.kOO = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.kOP = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.dtS = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.kOd = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.jSa.setIsAddition(this.kOd != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.kOQ = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.jSa.setTitle(bundle.getString("write_title"));
            this.jSa.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.jSa.setTopicId(this.mTopicId);
            this.gIK = bundle.getString("KEY_CALL_FROM");
            this.awX = bundle.getInt("album_thread");
            stringExtra = string;
        } else {
            Intent intent = getIntent();
            this.jSa.setType(intent.getIntExtra("type", 0));
            this.jSa.setForumId(intent.getStringExtra("forum_id"));
            this.jSa.setForumName(intent.getStringExtra("forum_name"));
            this.jSa.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.jSa.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.jSa.setThreadId(intent.getStringExtra("thread_id"));
            this.jSa.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.jSa.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.kOH = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.kOI = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.kOO = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.kOP = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.kOd = (AdditionData) intent.getSerializableExtra("addition_data");
            this.jSa.setIsAddition(this.kOd != null);
            this.jSa.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.kOQ = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.ghh = intent.getStringExtra("more_forum_img");
            this.ghi = intent.getStringExtra("more_forum_title");
            this.ghg = intent.getStringExtra("more_forum_url");
            this.jSa.setTitle(intent.getStringExtra("write_title"));
            this.jSa.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.jSa.setTopicId(this.mTopicId);
            this.gIK = intent.getStringExtra("KEY_CALL_FROM");
            this.awX = intent.getIntExtra("album_thread", 0);
            stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
        }
        if (this.jSa.getType() == 9) {
            this.jSa.setEntranceType(1);
        } else if (this.jSa.getType() == 10) {
            this.jSa.setEntranceType(2);
            this.jSa.setType(9);
        } else if (this.jSa.getType() == 0) {
            this.jSa.setEntranceType(3);
        }
        this.jSa.setIsUserFeedback(this.kOH);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (stringExtra != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.jSa.getType() == 4 ? 6 : 9);
        this.jSa.setWriteImagesInfo(this.writeImagesInfo);
        if (this.jSa.getType() == 0 || this.jSa.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                v.c(this.jSa.getForumId(), this);
            }
        } else if (this.jSa.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                v.c("24591571", this);
            }
        } else if (this.jSa.getType() == 1) {
            v.a(this.jSa.getThreadId(), this);
        } else if (this.jSa.getType() == 4) {
            v.c(this.jSa.getForumId() + "photolive", this);
        } else if (this.jSa.getType() == 5) {
            v.a(this.jSa.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.ibD = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.jSa != null && this.jSa.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.jSa.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.kNW = true;
        }
        cTz();
        try {
            this.kPf = cUi();
        } catch (Throwable th) {
            this.kPf = null;
        }
    }

    private void cTI() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.jSt.setText(com.baidu.tbadk.plugins.b.vj(com.baidu.tbadk.plugins.b.vk(hotTopicBussinessData.mTopicName)));
            this.jSt.setMovementMethod(com.baidu.tieba.view.c.cQS());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString vj = com.baidu.tbadk.plugins.b.vj(com.baidu.tbadk.plugins.b.vk(hotTopicBussinessData.mTopicName));
            if (vj != null) {
                this.jSt.setText(vj);
            }
            this.kOr.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.v.a
    public void a(WriteData writeData) {
        String str;
        String vk;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            if (writeData != null) {
                if (this.jSa != null) {
                    this.jSa.setHaveDraft(true);
                    if (com.baidu.adp.lib.util.k.isEmpty(cTG().getText().toString()) || this.kPm || ((this.kOH || this.kNW) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                        if (com.baidu.adp.lib.util.k.isEmpty(this.jSa.getTitle())) {
                            this.jSa.setTitle(writeData.getTitle());
                        }
                        if (!com.baidu.tbadk.core.util.v.isEmpty(this.mList)) {
                            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.getItem(this.mList, 0);
                            if (hotTopicBussinessData == null) {
                                str = null;
                            } else {
                                str = hotTopicBussinessData.mTopicName;
                            }
                            if (StringUtils.isNull(str)) {
                                vk = this.jSa.getTitle();
                            } else {
                                vk = com.baidu.tbadk.plugins.b.vk(str);
                            }
                            SpannableString vj = com.baidu.tbadk.plugins.b.vj(vk);
                            if (vj != null) {
                                cTG().setText(vj);
                                cTG().setSelection(vj.length() > vk.length() ? vk.length() : vj.length());
                            }
                        } else {
                            SpannableString vj2 = com.baidu.tbadk.plugins.b.vj(this.jSa.getTitle());
                            if (vj2 != null) {
                                cTG().setText(vj2);
                                cTG().setSelection(this.jSa.getTitle().length() > vj2.length() ? vj2.length() : this.jSa.getTitle().length());
                            }
                        }
                    }
                    if (this.jSa != null && !this.jSa.getHaveDraft()) {
                        cTy();
                    }
                    if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.copy(writeData.getVideoInfo());
                        this.jSa.setVideoInfo(videoInfo);
                        this.dsn.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                    }
                    if ((com.baidu.adp.lib.util.k.isEmpty(cTF().getText().toString()) || this.kOH || this.kNW) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                        this.jSa.setContent(writeData.getContent());
                        SpannableString a2 = TbFaceManager.aMY().a(getPageContext().getPageActivity(), this.jSa.getContent(), this.kOw);
                        cTF().setText(a2);
                        cTF().setSelection(a2.length());
                        if (this.kOp) {
                            a(this.kPb, this.kOV);
                        }
                    }
                    if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                        this.writeImagesInfo = writeData.getWriteImagesInfo();
                        this.jSa.setWriteImagesInfo(this.writeImagesInfo);
                        cUg();
                        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                            cTO();
                        }
                        tF(false);
                    }
                    if (writeData.getType() == 4 || writeData.getType() == 5) {
                        cUa();
                    }
                    cFp();
                    int categoryTo = writeData.getCategoryTo();
                    if (categoryTo >= 0 && this.kOi != null) {
                        this.kOm = this.kOj.gmF;
                        this.kOl = this.kOj.name;
                        int i = 0;
                        while (true) {
                            if (i == this.kOi.size()) {
                                break;
                            }
                            w wVar = this.kOi.get(i);
                            if (categoryTo != wVar.gmF) {
                                i++;
                            } else {
                                this.kOm = categoryTo;
                                this.kOl = wVar.name;
                                this.jSa.setCategoryTo(this.kOm);
                                break;
                            }
                        }
                        if (this.kOn != null) {
                            this.kOn.setText(this.kOl);
                            this.kOn.setCategoryContainerData(this.kOi, this.kOj, this.kOm);
                        }
                    }
                    this.dsn.aJZ();
                    return;
                }
                return;
            }
            cUa();
            cTy();
        }
    }

    private void cUa() {
        if ((!this.kOp || this.kOU != null) && this.kOT != null) {
            this.kOU.b(this.writeImagesInfo);
            cUe();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.jSa.getType());
        bundle.putString("forum_id", this.jSa.getForumId());
        bundle.putString("forum_name", this.jSa.getForumName());
        bundle.putString("forum_first_dir", this.jSa.getFirstDir());
        bundle.putString("forum_second_dir", this.jSa.getSecondDir());
        bundle.putString("thread_id", this.jSa.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.jSa.getFloor());
        bundle.putInt("floor_num", this.jSa.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.kOO);
        if (this.kOH) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.dtS);
        if (this.kOd != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.kOd));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.kOQ);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.gIK);
        bundle.putInt("album_thread", this.awX);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cTF().getEditableText().toString();
        if (obj != null) {
            cTF().setText(TbFaceManager.aMY().a(getPageContext().getPageActivity(), obj, this.kOw));
            cTF().setSelection(cTF().getText().length());
        }
    }

    private String cTJ() {
        return (cTF() == null || cTF().getText() == null) ? "" : cTF().getText().toString();
    }

    private String cTK() {
        if (this.jSa == null || cTG() == null || cTG().getVisibility() != 0 || cTG().getText() == null) {
            return "";
        }
        String obj = cTG().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) > 0 && this.jSb != com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) - 1 && this.jSa.getType() != 4 && this.jSz != null && this.jSz.getText() != null) {
            this.jSa.setPostPrefix(this.jSz.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.jSa.getTitle();
        }
        return obj;
    }

    private void KG(String str) {
        if (this.jSa != null && this.kNY != null) {
            if (this.kNY.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.jSa.setIsNoTitle(true);
                    this.jSa.setTitle("");
                    return;
                }
                this.jSa.setIsNoTitle(false);
                this.jSa.setTitle(str);
                return;
            }
            this.jSa.setIsNoTitle(true);
            this.jSa.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTL() {
        cFg();
        this.jSa.setContent(cTJ());
        KG(cTK());
        if (this.kOH || this.kNW) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.jSa.getTitle()) || !this.jSa.getTitle().startsWith(string)) {
                KG(string + this.jSa.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.jSa.getContent()) || !this.jSa.getContent().startsWith(str)) {
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
                sb.append(this.jSa.getContent());
                this.jSa.setContent(sb.toString());
            }
        }
        if (this.kOk >= 0) {
            this.jSa.setCategoryFrom(this.kOk);
        }
        if (this.kOm >= 0) {
            this.jSa.setCategoryTo(this.kOm);
        }
        this.jSa.setWriteImagesInfo(this.writeImagesInfo);
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
            this.jSa.setTakePhotoNum(i);
        }
        this.jSa.setHasLocationData(this.dtT != null && this.dtT.boD());
        if (this.writeImagesInfo != null) {
            this.dtU.sC(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.mList) && this.kOq != null && this.kOq.mIsGlobalBlock == 0) {
            this.jSa.setForumId(String.valueOf(this.kOq.mForumId));
            this.jSa.setForumName(this.kOq.mForumName);
        }
        this.dtU.d(this.jSa);
        this.jSa.setContent(this.jSa.getContent().replaceAll("\u0000\n", ""));
        this.jSa.setContent(this.jSa.getContent().replaceAll("\u0000", ""));
        this.jSa.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.dtU.cFi().setVoice(this.mVoiceModel.getId());
                this.dtU.cFi().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.dtU.cFi().setVoice(null);
                this.dtU.cFi().setVoiceDuringTime(-1);
            }
        } else {
            this.dtU.cFi().setVoice(null);
            this.dtU.cFi().setVoiceDuringTime(-1);
        }
        if (!this.dtU.cJJ()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.fZZ);
            this.dtU.cJG();
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
            if (this.kOd != null) {
                i2 = this.kOd.getTotalCount();
                i = this.kOd.getAlreadyCount() + 1;
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
                if (this.jSt == getCurrentFocus()) {
                    cTF().clearFocus();
                    this.jSt.requestFocus();
                    if (this.dsn != null) {
                        this.dsn.aJZ();
                    }
                    ShowSoftKeyPadDelay(this.jSt);
                } else {
                    cTF().requestFocus();
                    if (this.dsn != null) {
                        this.dsn.aJZ();
                    }
                    ShowSoftKeyPadDelay(this.jSx);
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
                            cTF().getText().insert(cTF().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.jSa.getType() == 0 || this.jSa.getType() == 9) {
                    v.c(this.jSa.getForumId(), (WriteData) null);
                    if (postWriteCallBackData2 != null) {
                    }
                } else if (this.jSa.getType() == 1) {
                    v.d(this.jSa.getThreadId(), (WriteData) null);
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
                                cUf();
                            } else {
                                aD(intent);
                            }
                        } else if (intExtra == 1) {
                            aE(intent);
                        } else {
                            aB(intent);
                            com.baidu.adp.lib.f.e.gy().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.kPq) {
                            tE(true);
                            this.kPq = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.kOp) {
                        U(intent);
                        cFp();
                        return;
                    }
                    aC(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.jSa.setVideoInfo(videoInfo);
                        this.dsn.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                        this.dsn.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.dsn.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    cFp();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.kNU) {
                                sb2.append(com.baidu.tbadk.plugins.b.dBn);
                                this.kNU = false;
                            }
                            sb2.append(stringExtra);
                            uL(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.isEmpty(this.mList) && !com.baidu.tbadk.core.util.v.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                    this.kOq = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                    a(this.kOq);
                }
            }
        } else if (i2 == 0) {
            if (this.dsn != null && !this.dsn.aLE()) {
                this.jSx.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.dsn.aJZ();
            }
            switch (i) {
                case 12001:
                    aMk();
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    cUd();
                    if (this.kPq) {
                        tE(true);
                        this.kPq = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.jSt == getCurrentFocus()) {
                        cTF().clearFocus();
                        this.jSt.requestFocus();
                        if (this.dsn != null) {
                            this.dsn.aJZ();
                        }
                        ShowSoftKeyPadDelay(this.jSt);
                        return;
                    }
                    cTF().requestFocus();
                    if (this.dsn != null) {
                        this.dsn.aJZ();
                    }
                    ShowSoftKeyPadDelay(this.jSx);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.kOu.Kn(postWriteCallBackData.getErrorString());
                        this.kOu.aV(postWriteCallBackData.getSensitiveWords());
                        this.kOu.b(this.jSt, this.jSx);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.dtS = String.valueOf(System.currentTimeMillis());
                    al.a(getPageContext(), this.dtS);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    cUd();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.kNT)) {
                        cTG().requestFocus();
                        return;
                    } else if ("from_content".equals(this.kNT)) {
                        cTF().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTM() {
        if ("1".equals(this.gIK)) {
            this.jSa.setCanNoForum(true);
            this.jSa.setTransmitForumData("[]");
        } else if ("2".equals(this.gIK)) {
            this.jSa.setCanNoForum(false);
        }
        cTN();
        this.jSa.setPrivacy(this.isPrivacy);
        cUb();
        this.jSa.setToDynamic(this.isToDynamic);
        this.jSa.setCallFrom(this.gIK);
        if (this.jSa.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cTL();
    }

    private void cTN() {
        if (this.dsn != null) {
            this.dsn.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void cUb() {
        if (this.dsn != null) {
            this.dsn.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void cUc() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void cUd() {
        if (this.kOp) {
            this.kOU.b(this.writeImagesInfo);
            cUe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUe() {
        this.kOU.notifyDataSetChanged();
        this.kOT.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.kOU.notifyDataSetChanged();
                WriteActivity.this.kOT.invalidateViews();
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
        cFp();
    }

    private void aB(Intent intent) {
        if (this.kOp) {
            aC(intent);
            cUd();
        } else {
            aF(intent);
        }
        cFp();
    }

    private void aC(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            cUd();
            tF(true);
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

    private void cUf() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void aE(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.kOR.parseJson(stringExtra);
            this.kOR.updateQuality();
            if (this.kOR.getChosedFiles() != null && this.kOR.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.kOR.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.kOR.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cTG());
        HidenSoftKeyPad(this.mInputManager, cTF());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void aF(Intent intent) {
        c(intent, true);
    }

    private void T(Intent intent) {
        this.dtS = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.dtS;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.getEquipmentWidth(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.dtS, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            cUg();
            cTO();
        }
        tF(true);
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
                cUg();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    cTO();
                }
            }
            tF(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUg() {
        if (this.dsn.lX(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void aMk() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.dtS));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void cUh() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.ghh)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                com.baidu.tbadk.util.o oVar = new com.baidu.tbadk.util.o(this, this.ghh, new o.a() { // from class: com.baidu.tieba.write.write.WriteActivity.38
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
                            WriteActivity.this.tF(true);
                        }
                    }
                });
                oVar.setFrom(1);
                oVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tF(boolean z) {
        String forumId = this.jSa == null ? "" : this.jSa.getForumId();
        if (this.kOS != null) {
            this.kOS.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.giZ == null) {
            this.giZ = VoiceManager.instance();
        }
        return this.giZ;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bBD() {
        this.giZ = getVoiceManager();
        this.giZ.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.aW(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.gkg) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).Z("obj_locate", at.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.jSa.getType() != 7) {
                if (this.kOd == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                B(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.dtZ = i;
        if (this.dsn != null) {
            this.dsn.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void cTO() {
        if (!this.kOp) {
            if (this.dsn != null) {
                this.dsn.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.dsn.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.jSa == null ? "" : this.jSa.getForumId();
            if (this.kOS != null) {
                this.kOS.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gx(boolean z) {
        if (this.dsn != null) {
            this.dsn.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Ei(int i) {
        if (i < this.kOb.size()) {
            for (int i2 = 0; i2 < this.kOb.size(); i2++) {
                this.kOb.get(i2).tu(false);
            }
            this.kOb.get(i).tu(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void BR(int i) {
        if (i == com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new an("c13014").Z("obj_type", 1));
        } else {
            TiebaStatic.log(new an("c13014").Z("obj_type", 2));
        }
        this.jSb = i;
        this.jSA.setCurrentIndex(i);
        Ei(i);
        this.jSz.setText(this.mPrefixData.getPrefixs().get(i));
        cFp();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.jSA, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.jSC.setSelected(false);
        am.setImageResource(this.jSB, R.drawable.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.jSx);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes10.dex */
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
        if (this.jSa != null) {
            if (this.jSa.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.jSa.getType() == 5) {
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
            aMe();
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = ab.transformPermissionResult(strArr, iArr);
            if (ab.checkCamera(getApplicationContext())) {
                al.a(getPageContext(), this.dtS);
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
        this.aqh = z;
        if (this.kPk && System.currentTimeMillis() - this.kPl < 800) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.kPk = false;
        }
        if (this.kOt != null && !z) {
            this.kOt.bwa();
        }
        if (this.kOv != null && !z) {
            cTr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KH(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.kPh != null) {
            KI(str);
            this.kPh.dismiss();
        }
    }

    private void fI(Context context) {
        kPj = l.getEquipmentHeight(context);
    }

    private void KI(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.kPk = true;
        cUg();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            cTO();
        }
        tF(true);
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

    private File cUi() {
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

    private void cUj() {
        if (this.kPf != null && this.jSa.getType() == 0 && this.jSa.getType() == 9) {
            fI(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.kPf != null) {
                        WriteActivity.this.KH(WriteActivity.this.kPf.getAbsolutePath());
                    }
                }
            });
            this.kPg = (TbImageView) this.mBubbleView.findViewById(R.id.rec_img_view);
            this.kPi = (LinearLayout) this.mBubbleView.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.aCY().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.kPf.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.aCY().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.kPf.getAbsolutePath());
                Bitmap g = g(this.kPf.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (g != null) {
                    this.kPg.setImageBitmap(g);
                    this.kPg.setDrawBorder(true);
                    this.kPg.setBorderWidth(2);
                    this.kPg.setBorderColor(am.getColor(R.color.common_color_10264));
                    this.kPh = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.kPh.setCanceledOnTouchOutside(true);
                    this.kPh.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.kPk) {
                                l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.kPl = System.currentTimeMillis();
                            }
                        }
                    });
                    this.kPh.setContentView(this.mBubbleView);
                    this.kPh.show();
                    Window window = this.kPh.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (kPj / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.aqh && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.kNU = false;
            this.kNT = "";
            if ("from_content".equals(str)) {
                this.kNT = "from_content";
            } else if ("from_title".equals(str)) {
                this.kNT = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.vi(String.valueOf(charSequence.charAt(i)))) {
                tC(false);
            }
        }
    }

    public void cAB() {
        if (this.kOH || !com.baidu.tbadk.core.util.v.isEmpty(this.mList) || !StringUtils.isNull(this.jSa.getTitle())) {
            this.kNY.setVisibility(0);
            this.kNY.requestFocus();
            return;
        }
        this.kNY.setVisibility(8);
    }
}
