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
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.coreExtra.data.q;
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
/* loaded from: classes13.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0078a, VoiceManager.c, v.a, h.a {
    private static int kTJ = 0;
    private EditorTools dwT;
    private String dyx;
    private LocationModel dyy;
    private NewWriteModel dyz;
    private String gmG;
    private String gmH;
    private String gmI;
    private VoiceManager goy;
    private LinearLayout iJF;
    private PlayVoiceBntNew iJG;
    private ImageView iJI;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private int jWX;
    private TextView jXu;
    private com.baidu.tieba.write.h jXv;
    private ImageView jXw;
    private View jXx;
    private com.baidu.tieba.write.b.c kQD;
    private View kSA;
    private Toast kSC;
    private AdditionData kSD;
    private RelativeLayout kSE;
    private TextView kSF;
    private TextView kSG;
    private TextView kSH;
    List<w> kSI;
    w kSJ;
    private int kSK;
    private String kSL;
    private int kSM;
    private PostCategoryView kSN;
    private HotTopicBussinessData kSQ;
    private TextView kSR;
    private com.baidu.tieba.write.editor.b kST;
    private e kSV;
    private LinearLayout kSx;
    private LinearLayout kSy;
    private View kTN;
    private View kTO;
    private TextView kTP;
    private com.baidu.tieba.c.d kTR;
    private com.baidu.tieba.view.b kTc;
    private View kTl;
    private g kTs;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String kSt = "";
    private boolean kSu = false;
    private WriteData jWW = null;
    private boolean kTh = false;
    private boolean kSw = false;
    private boolean kTi = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText jXo = null;
    private HeadImageView kTj = null;
    private View jXp = null;
    private LinearLayout jXr = null;
    private EditText jXs = null;
    private FeedBackModel kSz = null;
    private FeedBackTopListView kTk = null;
    private ArrayList<WritePrefixItemLayout> kSB = new ArrayList<>();
    private String ihy = null;
    private final KeyEvent gaI = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView kTm = null;
    private TextView jXt = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener gfz = null;
    private com.baidu.tbadk.core.dialog.a kTn = null;
    private final Handler mHandler = new Handler();
    private boolean kTo = false;
    private String kTp = null;
    private RelativeLayout hsl = null;
    private String dyD = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int dyE = 0;
    private int kTq = 0;
    private WriteImagesInfo kTr = new WriteImagesInfo();
    private View mRootView = null;
    private GridView kTt = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a kTu = null;
    private ScrollView kSO = null;
    private EditText kTv = null;
    private View kTw = null;
    private View kTx = null;
    private View kTy = null;
    private EditText kTz = null;
    private TextView kTA = null;
    private TextView kTB = null;
    private TextWatcher kTC = null;
    private TextWatcher kTD = null;
    private boolean kSP = false;
    private boolean kTE = false;
    private com.baidu.tbadk.core.view.a dGg = null;
    private String mFrom = "write";
    private File kTF = null;
    private TbImageView kTG = null;
    private View mBubbleView = null;
    private Dialog kTH = null;
    private LinearLayout kTI = null;
    private boolean kTK = false;
    private long kTL = -1000;
    private boolean kTM = false;
    private String gOk = "2";
    private int aBY = 0;
    private String mTopicId = "";
    private SpannableStringBuilder kSS = new SpannableStringBuilder();
    private boolean kTQ = false;
    private boolean auE = false;
    private final b kSU = new b();
    private final HttpMessageListener kTS = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.ihy)) {
                    WriteActivity.this.ihy = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.tU(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.ihy)) {
                    WriteActivity.this.ihy = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.ihy);
                    WriteActivity.this.tU(true);
                }
            }
        }
    };
    private TbFaceManager.a kSW = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan vw(String str) {
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
    private final AntiHelper.a gpF = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d dyN = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.bEl();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.jWW != null) {
                WriteActivity.this.kSU.aU(null);
                if (z) {
                    WriteActivity.this.gJ(z);
                    if (WriteActivity.this.e(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    if (WriteActivity.this.jWW.getType() != 0 && WriteActivity.this.jWW.getType() != 9) {
                        if (WriteActivity.this.jWW.getType() != 7) {
                            if (WriteActivity.this.jWW.getType() == 1) {
                                v.d(WriteActivity.this.jWW.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.jWW.getType() == 5) {
                                v.d(WriteActivity.this.jWW.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            v.c("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            v.c(WriteActivity.this.jWW.getForumId(), (WriteData) null);
                        }
                        if (!com.baidu.tbadk.core.util.v.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                            TiebaStatic.log(new an("c11731").cy("obj_id", WriteActivity.this.mTopicId));
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
                    WriteActivity.this.kSU.aU(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.kSU.KL(postWriteCallBackData.getErrorString());
                    WriteActivity.this.kSU.b(WriteActivity.this.jXo, WriteActivity.this.jXs);
                } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aJH());
                    if (com.baidu.tbadk.s.a.wb(aaVar.aJG())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJG());
                        if (WriteActivity.this.kTi) {
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
    private final LocationModel.a dyL = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void aPl() {
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
            if (aVar != null && !StringUtils.isNull(aVar.cLF())) {
                WriteActivity.this.a(2, true, aVar.cLF());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener kji = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.dyy.sQ(false);
                    WriteActivity.this.dyy.eG(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.dyy.sQ(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener kSX = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener kSY = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.dwT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cVK = WriteActivity.this.cVK();
            if (cVK >= 0 && cVK < WriteActivity.this.jXs.getText().length()) {
                WriteActivity.this.jXs.setSelection(cVK);
            }
        }
    };
    private boolean kSZ = true;
    private final View.OnFocusChangeListener eWj = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.jXo || view == WriteActivity.this.mBack || view == WriteActivity.this.jXt) {
                if (z) {
                    WriteActivity.this.kSZ = true;
                    WriteActivity.this.cVL();
                    l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.jXo);
                    if (WriteActivity.this.dwT != null) {
                        WriteActivity.this.dwT.aMR();
                    }
                } else if (view == WriteActivity.this.jXo) {
                    WriteActivity.this.jXu.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.jXs && z) {
                WriteActivity.this.kSZ = false;
                WriteActivity.this.cVL();
                l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.jXs);
                if (WriteActivity.this.dwT != null) {
                    WriteActivity.this.dwT.aMR();
                }
            }
            WriteActivity.this.cVQ();
        }
    };
    private TextWatcher kTa = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String kTe = "";
        private String kTf;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kTf = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.kTf != null ? this.kTf.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cIc();
            WriteActivity.this.cVR();
            EditText cWc = WriteActivity.this.cWc();
            if (editable != null && cWc != null && cWc.getText() != null) {
                if (this.kTe == null || !this.kTe.equals(editable.toString())) {
                    if (WriteActivity.this.kSU != null) {
                        this.kTe = cWc.getText().toString();
                        WriteActivity.this.kSU.b(cWc, true);
                        return;
                    }
                    return;
                }
                cWc.setSelection(cWc.getSelectionEnd());
            }
        }
    };
    private TextWatcher kTb = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String kTf;
        private String kTg = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kTf = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.kTf != null ? this.kTf.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cIc();
            EditText cWb = WriteActivity.this.cWb();
            if (editable != null && cWb != null && cWb.getText() != null) {
                if (this.kTg == null || !this.kTg.equals(editable.toString())) {
                    if (WriteActivity.this.kSU != null) {
                        this.kTg = cWb.getText().toString();
                        WriteActivity.this.kSU.b(cWb, false);
                        return;
                    }
                    return;
                }
                cWb.setSelection(cWb.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0610a iPH = new a.InterfaceC0610a() { // from class: com.baidu.tieba.write.write.WriteActivity.31
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0610a
        public void onRefresh() {
            WriteActivity.this.ihy = null;
            WriteActivity.this.tU(false);
            WriteActivity.this.dwT.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void aOV() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void aOW() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aOY();
        } else if (this.dyy.cLM()) {
            aOV();
        } else {
            this.dyy.sQ(false);
            a(1, true, (String) null);
            this.dyy.cLK();
        }
    }

    public void cWm() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
            if (this.kST != null) {
                this.kST.cUR();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aOY();
        } else if (this.dyy != null) {
            this.dyy.sQ(false);
            a(1, true, (String) null);
            this.dyy.cLK();
        }
    }

    private void aOY() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.jW(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.dyy.cLO();
                } else {
                    WriteActivity.this.dyL.aPl();
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
        aVar.aEC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cVK() {
        int selectionEnd = cWb().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cWb().getText().getSpans(0, cWb().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cWb().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cWb().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVL() {
        if (this.dwT != null) {
            this.dwT.setBarLauncherEnabled(!this.kSZ);
            this.dwT.setBarLauncherEnabled(true, 26);
            this.dwT.setBarLauncherEnabled(true, 2);
            this.dwT.setBarLauncherEnabled(true, 30);
            V(9, this.kSZ ? false : true);
        }
    }

    private void V(int i, boolean z) {
        com.baidu.tbadk.editortools.g mm;
        if (this.dwT != null && (mm = this.dwT.mm(i)) != null) {
            if (z) {
                mm.display();
            } else {
                mm.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.kSP) {
            this.jXo.setVisibility(8);
            if (this.jWW.getType() == 5) {
                this.kTy.setVisibility(8);
            } else {
                this.kTy.setVisibility(0);
            }
            a(this.kTB, this.kTv);
            a(this.kTA, this.kTz);
            cIc();
        }
        if (this.kTh) {
            this.kSZ = true;
            cVL();
            if (this.dwT != null) {
                this.dwT.aMR();
            }
            this.jXo.requestFocus();
            ShowSoftKeyPadDelay(this.jXo);
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
            cWC();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                cWk();
            }
            tV(true);
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
        if (this.jWW.getType() == 0) {
            Et(this.aBY);
        }
        initUI();
        cWr();
        this.dyy = new LocationModel(getPageContext());
        this.dyy.a(this.dyL);
        registerListener(this.kji);
        registerListener(this.kSX);
        cfN();
        cWF();
        if (this.kSP) {
            this.kTu.setEditorTools(this.dwT);
        } else {
            this.jXs.requestFocus();
        }
        cDi();
        cWk();
        cWD();
    }

    @SuppressLint({"ResourceAsColor"})
    private void cfN() {
        this.dwT = new EditorTools(getActivity());
        this.dwT.setBarMaxLauCount(5);
        this.dwT.setMoreButtonAtEnd(true);
        this.dwT.setBarBackgroundColorId(R.color.cp_bg_line_h);
        this.dwT.setBarLauncherType(1);
        this.dwT.gB(true);
        this.dwT.gC(true);
        switch (this.jWW.getType()) {
            case 4:
            case 5:
                cWp();
                break;
            default:
                cVM();
                break;
        }
        this.dwT.build();
        if (this.kSx != null) {
            this.kSx.addView(this.dwT);
        }
        bZQ();
        this.dwT.display();
        com.baidu.tbadk.editortools.g mm = this.dwT.mm(6);
        if (mm != null && !TextUtils.isEmpty(this.dyD)) {
            ((View) mm).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.dyD);
                }
            });
        }
        if (!this.kSP) {
            this.dwT.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.dwT.aMR();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.dwT.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.dwT.b(new com.baidu.tbadk.editortools.a(2, 26, HanziToPinyin.Token.SEPARATOR));
        }
        cVO();
    }

    private void cWn() {
        this.kTw = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.kTy = this.kTw.findViewById(R.id.live_post_title_container);
        this.kTv = (EditText) this.kTw.findViewById(R.id.live_post_content);
        this.kTt = (GridView) this.kTw.findViewById(R.id.photoLiveGridView);
        this.kTz = (EditText) this.kTw.findViewById(R.id.live_post_title);
        this.kTA = (TextView) this.kTw.findViewById(R.id.titleOverPlusNumber);
        this.kTB = (TextView) this.kTw.findViewById(R.id.contentOverPlusNumber);
        this.kTx = this.kTw.findViewById(R.id.live_interval_view);
        this.kTA.setText(String.valueOf(20));
        this.kTB.setText(String.valueOf(233));
        this.kTw.setVisibility(0);
        this.kTA.setVisibility(0);
        this.kTB.setVisibility(0);
        this.kTz.setHint(R.string.tips_title_limit_new);
        this.kTz.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.kTE = true;
                    WriteActivity.this.kSZ = true;
                    WriteActivity.this.cVL();
                    if (WriteActivity.this.dwT != null) {
                        WriteActivity.this.dwT.aMR();
                    }
                }
            }
        });
        if (this.jWW.getType() == 4) {
            this.kTv.setHint(R.string.live_write_input_content_new);
        } else if (this.jWW.getType() == 5) {
            this.kTv.setHint(R.string.live_write_input_content_update);
        }
        this.kTv.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.kTE = false;
                    WriteActivity.this.kSZ = false;
                    WriteActivity.this.cVL();
                    if (WriteActivity.this.dwT != null) {
                        WriteActivity.this.dwT.aMR();
                    }
                }
            }
        });
        this.kTv.requestFocus();
        this.kTv.addTextChangedListener(TM());
        this.kTz.requestFocus();
        this.kTz.addTextChangedListener(TM());
        this.kTz.setOnClickListener(this.kSY);
        this.kTv.setOnClickListener(this.kSY);
        this.kTu = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.kTt);
        this.kTu.En(6);
        this.kTt.setAdapter((ListAdapter) this.kTu);
        View findViewById = this.kTw.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void cVw() {
                WriteActivity.this.cWA();
            }
        });
        cWo();
    }

    private void cWo() {
        if (this.jWW.getType() == 0) {
            if (this.jWW.getTitle() != null) {
                this.kTz.setText(this.jWW.getTitle());
                this.kTz.setSelection(this.jWW.getTitle().length());
                return;
            }
            return;
        }
        if (this.jWW.getType() == 1 || this.jWW.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.kSP) {
            cWy();
        }
        if (this.dwT.aOw()) {
            this.dwT.aMR();
        }
        Et(0);
    }

    private void Et(int i) {
        if (this.writeImagesInfo != null && this.jWW != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.jWW.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.jWW.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.gOk);
            albumActivityConfig.setProfessionZone(this.jWW.getProZone());
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void cWp() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.dwT.aI(arrayList);
        com.baidu.tbadk.editortools.l mp = this.dwT.mp(5);
        if (mp != null) {
            mp.dxD = 2;
        }
        this.dwT.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.dwT.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void cVM() {
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
            this.dwT.b(dVar);
        }
        Boolean cWv = cWv();
        if (!this.kTh && cWv != null && cWv.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.cMj() && r.d(this.jWW.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar5 = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar5.dxD = 3;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dwT.b(lVar5);
            }
        }
        this.dwT.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 4));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask2 != null && (lVar4 = (com.baidu.tbadk.editortools.l) runTask2.getData()) != null) {
            lVar4.dxD = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dwT.b(lVar4);
            }
        }
        this.dwT.b(new com.baidu.tbadk.editortools.k(getActivity(), 6));
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask3 != null && (lVar3 = (com.baidu.tbadk.editortools.l) runTask3.getData()) != null) {
            lVar3.dxD = 7;
            this.dwT.b(lVar3);
        }
        this.dwT.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 8));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask4 != null && (lVar2 = (com.baidu.tbadk.editortools.l) runTask4.getData()) != null) {
            lVar2.dxF = true;
            lVar2.dxD = 9;
            lVar2.dxz = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dwT.b(lVar2);
            }
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask5 != null && (lVar = (com.baidu.tbadk.editortools.l) runTask5.getData()) != null) {
            lVar.dxF = true;
            lVar.dxD = 10;
            lVar.dxz = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dwT.b(lVar);
            }
        }
        if (this.kSD == null) {
            if (this.kST == null) {
                this.kST = new com.baidu.tieba.write.editor.b(getActivity(), this.gOk);
                this.kST.bz(this.jWW.getForumId(), this.privateThread);
                this.kST.tO(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.kST.cUN();
                this.kST.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                cWm();
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.mList)) {
                this.kST.cUN();
            }
            this.dwT.b(this.kST);
        }
        this.dwT.aI(arrayList);
        com.baidu.tbadk.editortools.l mp = this.dwT.mp(5);
        if (mp != null) {
            mp.dxD = 1;
        }
    }

    private void cVN() {
        if (this.kSV != null) {
            this.kSV.hideTip();
        }
    }

    private void cVO() {
        if (this.kSV == null) {
            this.kSV = new e(getPageContext());
        }
        this.kSV.c(this.dwT);
    }

    private void bZQ() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.cWa()) {
                            WriteActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new an("c12612").X("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (aVar.data != null && (aVar.data instanceof q)) {
                            q qVar = (q) aVar.data;
                            if (qVar.aJx() == EmotionGroupType.BIG_EMOTION || qVar.aJx() == EmotionGroupType.USER_COLLECT) {
                                if (WriteActivity.this.mCurrentPermissionJudgePolicy == null) {
                                    WriteActivity.this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
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
                                    imageFileInfo.setFilePath(qVar.getName());
                                    imageFileInfo.width = qVar.getWidth();
                                    imageFileInfo.height = qVar.getHeight();
                                    WriteActivity.this.writeImagesInfo.addChooseFile(imageFileInfo);
                                    WriteActivity.this.writeImagesInfo.updateQuality();
                                    WriteActivity.this.tV(true);
                                    WriteActivity.this.cIc();
                                }
                            } else if (WriteActivity.this.cWa()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(qVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.cWd();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.cnr();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.cWC();
                        WriteActivity.this.cIc();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.Eu(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new an("c12612").X("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.kSD == null) {
                            WriteActivity.this.aOZ();
                            return;
                        }
                        switch (WriteActivity.this.dyE) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.aOW();
                                    return;
                                } else {
                                    ab.e(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.aOV();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.dyy != null) {
                            WriteActivity.this.dyy.sQ(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.ihy = null;
                        } else {
                            WriteActivity.this.ihy = (String) aVar.data;
                        }
                        WriteActivity.this.tU(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        an anVar = new an("c10645");
                        if (WriteActivity.this.jWW != null) {
                            str = WriteActivity.this.jWW.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.cy("fid", str);
                        TiebaStatic.log(anVar);
                        if (WriteActivity.this.jWW == null || (videoInfo = WriteActivity.this.jWW.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.dwT.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.dwT.aOw()) {
                                        WriteActivity.this.dwT.aMR();
                                        WriteActivity.this.dwT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.dwT.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                        WriteActivity.this.dwT.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.dwT.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.dwT.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.jWW.setVideoInfo(null);
                        WriteActivity.this.cIc();
                        if (WriteActivity.this.jXs != null) {
                            WriteActivity.this.jXs.requestFocus();
                        }
                        WriteActivity.this.dwT.aMR();
                        WriteActivity.this.dwT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.jXs);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new an("c12612").X("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.dwT.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.kSu = true;
                        WriteActivity.this.tS(true);
                        if (!WriteActivity.this.cWc().isFocused() || WriteActivity.this.kSy.getVisibility() != 0) {
                            WriteActivity.this.kSt = "from_content";
                        } else {
                            WriteActivity.this.kSt = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        if (WriteActivity.this.kSy.getVisibility() == 0) {
                            if (WriteActivity.this.kSy.hasFocus()) {
                                WriteActivity.this.jXs.requestFocus();
                                WriteActivity.this.jXs.setSelection(WriteActivity.this.jXs.getText().toString().length());
                            }
                            WriteActivity.this.kSy.setVisibility(8);
                            WriteActivity.this.dwT.mm(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.kSy.setVisibility(0);
                            WriteActivity.this.kSy.requestFocus();
                            WriteActivity.this.dwT.mm(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.cIc();
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
        this.dwT.setActionListener(16, bVar);
        this.dwT.setActionListener(14, bVar);
        this.dwT.setActionListener(24, bVar);
        this.dwT.setActionListener(3, bVar);
        this.dwT.setActionListener(10, bVar);
        this.dwT.setActionListener(11, bVar);
        this.dwT.setActionListener(12, bVar);
        this.dwT.setActionListener(13, bVar);
        this.dwT.setActionListener(15, bVar);
        this.dwT.setActionListener(18, bVar);
        this.dwT.setActionListener(20, bVar);
        this.dwT.setActionListener(25, bVar);
        this.dwT.setActionListener(27, bVar);
        this.dwT.setActionListener(29, bVar);
        this.dwT.setActionListener(43, bVar);
        this.dwT.setActionListener(56, bVar);
        this.dwT.setActionListener(48, bVar);
        this.dwT.setActionListener(46, bVar);
        this.dwT.setActionListener(49, bVar);
        this.dwT.setActionListener(47, bVar);
        this.dwT.setActionListener(55, bVar);
        this.dwT.setActionListener(58, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eu(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOZ() {
        if (this.dyy.brm()) {
            if (this.dyy.cLM()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.cLH().getLocationData().cLF());
                return;
            }
            a(1, true, (String) null);
            this.dyy.cLK();
            return;
        }
        a(0, true, (String) null);
    }

    protected void cHT() {
        if (this.dyz != null) {
            this.dyz.cancelLoadData();
        }
        if (this.kSz != null) {
            this.kSz.cancelLoadData();
        }
        if (this.dyy != null) {
            this.dyy.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cVN();
        TiebaPrepareImageService.StopService();
        cHT();
        cWu();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.kTs != null) {
            this.kTs.destroy();
        }
        if (this.kTR != null) {
            this.kTR.zz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVP() {
        if (this.jWW != null && this.jWW.getType() == 2 && this.kTo) {
            finish();
        } else if (this.jWW == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.jWW.setTitle(cWc().getText().toString());
            this.jWW.setContent(cWb().getText().toString());
            int type = this.jWW.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    v.c(this.jWW.getForumId(), this.jWW);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    v.c("24591571", this.jWW);
                }
            } else if (type == 1) {
                v.d(this.jWW.getThreadId(), this.jWW);
            } else if (type == 4) {
                v.c(this.jWW.getForumId() + "photolive", this.jWW);
            } else if (type == 5) {
                v.d(this.jWW.getThreadId() + "updatephotolive", this.jWW);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.jXv != null && this.jXv.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.jXv, getPageContext().getPageActivity());
                return true;
            } else if (this.dwT.aOw()) {
                this.dwT.aMR();
                return true;
            } else {
                cHT();
                cVP();
                return true;
            }
        }
        if (i == 67 && (text = cWb().getText()) != null) {
            int selectionStart = cWb().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cWb().onKeyDown(67, this.gaI);
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
        getLayoutMode().onModeChanged(this.hsl);
        getLayoutMode().onModeChanged(this.kTI);
        am.setBackgroundColor(this.hsl, R.color.cp_bg_line_e);
        if (this.kTG != null && (i == 1 || i == 4)) {
            this.kTG.setBorderColor(am.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.jXt, R.color.cp_link_tip_a, 1);
        cVL();
        am.setBackgroundColor(this.jXp, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.kTx, R.color.cp_bg_line_c);
        am.setBackgroundColor(cWc(), R.color.cp_bg_line_e);
        am.setImageResource(this.iJI, R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.ihy)) {
            am.setBackgroundColor(cWb(), R.color.cp_bg_line_e);
        }
        cIc();
        this.dwT.onChangeSkinType(i);
        if (this.kSN != null) {
            this.kSN.aHO();
        }
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.kTs.kUn.notifyDataSetChanged();
        cVQ();
        cVR();
        tU(false);
        if (this.kSU != null) {
            this.kSU.c(cWc(), cWb());
        }
        this.kQD.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVQ() {
        if (this.jXo.hasFocus()) {
            this.jXo.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.jXo.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.jXs.hasFocus()) {
            this.jXs.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.jXs.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVR() {
        if (this.jXo != null && this.jXo.getText() != null && this.jXo.getText().toString() != null && this.jXo.getPaint() != null) {
            if (this.jXo.getText().toString().length() == 0) {
                this.jXo.getPaint().setFakeBoldText(false);
            } else if (this.jXo.getText().toString().length() > 0) {
                this.jXo.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.dGg = new com.baidu.tbadk.core.view.a(getPageContext());
        this.kSP = this.jWW.getType() == 4 || 5 == this.jWW.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aGC().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.kTm = (TextView) findViewById(R.id.btn_image_problem);
        cVT();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jXt.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.jXt.setLayoutParams(layoutParams);
        this.jXt.setOnFocusChangeListener(this.eWj);
        this.kSO = (ScrollView) findViewById(R.id.write_scrollview);
        this.kSO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.jXs != null) {
                        l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.jXs);
                    }
                    if (WriteActivity.this.dwT != null) {
                        WriteActivity.this.dwT.aMR();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.kTk = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.kTl = findViewById(R.id.feedback_divider);
        this.hsl = (RelativeLayout) findViewById(R.id.parent);
        this.kSx = (LinearLayout) findViewById(R.id.tool_view);
        this.kSx.setContentDescription(IStringUtil.TOP_PATH);
        this.kSy = (LinearLayout) findViewById(R.id.title_view);
        this.jXp = findViewById(R.id.interval_view);
        this.kTN = findViewById(R.id.hot_topic_fourm_view);
        this.kTO = findViewById(R.id.hot_topic_divider);
        this.kSR = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.kTP = (TextView) findViewById(R.id.change_one_tv);
        cIb();
        if (this.kSP) {
            this.kSO.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            cWn();
        } else {
            this.kTs = new g(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.kTs.tM(false);
            } else {
                g gVar = this.kTs;
                if (this.jWW.getType() != 0 && this.jWW.getType() != 9) {
                    z = false;
                }
                gVar.tM(z);
            }
        }
        cId();
        if (this.kTh || this.kSw) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().daP) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.jXr = (LinearLayout) findViewById(R.id.post_content_container);
        this.jXr.setDrawingCacheEnabled(false);
        this.jXr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.dwT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.jXs.requestFocus();
            }
        });
        this.iJF = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.iJG = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.iJI = (ImageView) findViewById(R.id.iv_delete_voice);
        this.iJI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cnr();
            }
        });
        this.mBack.setOnFocusChangeListener(this.eWj);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cHT();
                WriteActivity.this.cVP();
            }
        });
        this.kTm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        cVW();
        o(cWv());
        cVY();
        cVS();
        cWs();
        cWt();
        cVL();
        cVX();
        cIa();
        cWe();
        if (this.jWW.getType() == 4 && this.jXx != null && this.kSA != null) {
            this.jXx.setVisibility(8);
            this.kSA.setVisibility(8);
        }
        cIc();
        cWq();
        cVf();
    }

    private void cVf() {
        this.kQD = new com.baidu.tieba.write.b.c(getPageContext().getPageActivity(), this.mName, this.jWW.getProZone(), isUseStyleImmersiveSticky() ? StatusBarUtil.getStatusBarOffsetPx(getPageContext().getPageActivity()) : 0);
        this.kQD.a(new c.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // com.baidu.tieba.write.b.c.a
            public void Ei(int i) {
                WriteActivity.this.jWW.setProZone(i);
            }
        });
        this.kQD.byw();
    }

    private void cVS() {
        String str;
        String str2;
        if (this.jWW != null) {
            switch (this.jWW.getType()) {
                case 0:
                case 9:
                    if (this.kTh || this.kSw) {
                        if (this.kTi) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.gOk != null && this.gOk.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                    } else if (this.gOk != null && this.gOk.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.jWW.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.jWW.getForumName() + getResources().getString(R.string.bar));
                        this.jXo.setVisibility(8);
                        String str3 = this.gmI + HanziToPinyin.Token.SEPARATOR + this.gmG;
                        if (!StringUtils.isNull(str3)) {
                            this.jXs.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.jXo.setVisibility(0);
                    this.jXs.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.jXs.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.jXo.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.jXs.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.jWW.getFloorNum() + 1)));
                    this.kTx.setVisibility(8);
                    return;
                case 7:
                    this.jXo.setVisibility(0);
                    this.jXs.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void cVT() {
        if (this.jWW.getType() == 7) {
            this.jXt = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.jXt = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void cVU() {
        if (this.jWW != null && this.jWW.getType() == 0 && this.jWW.getType() == 9 && !this.kTh && !this.kSw && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = aq.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && cWc() != null) {
                cWc().setText(cutStringWithSuffix);
                cWc().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.iJF.setVisibility(0);
            this.iJG.setVoiceModel(voiceModel);
            this.iJG.cMi();
            cIc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnr() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.iJF.setVisibility(8);
        this.iJG.bOq();
        this.iJG.setVoiceModel(null);
        com.baidu.tbadk.editortools.l mp = this.dwT.mp(6);
        if (mp != null && mp.dwN != null) {
            mp.dwN.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cIc();
    }

    private void cVV() {
        this.kSI = null;
        this.kSK = -1;
        this.kSM = -1;
        y sY = x.bFE().sY(1);
        if (sY != null) {
            this.kSI = sY.gsi;
            this.kSK = getIntent().getIntExtra("category_id", -1);
            if (this.kSI != null && !this.kSI.isEmpty() && this.kSK >= 0) {
                this.kSJ = new w();
                this.kSJ.gse = 0;
                this.kSJ.name = getPageContext().getResources().getString(R.string.category_auto);
                this.kSM = this.kSJ.gse;
                this.kSL = this.kSJ.name;
                for (w wVar : this.kSI) {
                    if (wVar.gse == this.kSK) {
                        this.kSM = wVar.gse;
                        this.kSL = wVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cVW() {
        if (this.kSI != null && !this.kSI.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.kSN = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.kSN.setText(this.kSL);
            this.kSN.setCategoryContainerData(this.kSI, this.kSJ, this.kSM);
            this.kSN.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, as asVar) {
                    if (asVar != null) {
                        WriteActivity.this.kSN.setText(asVar.name);
                        WriteActivity.this.jWW.setCategoryTo(asVar.gse);
                        WriteActivity.this.kSM = asVar.gse;
                        WriteActivity.this.kSN.cVy();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.kSN.cVx();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cWc());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cWb());
                }
            });
        }
    }

    private void cWq() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.kTc = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.kTc.setTitle(R.string.no_disturb_start_time);
        this.kTc.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.kTc);
        this.kTc.setButton(-2, getPageContext().getString(R.string.cancel), this.kTc);
        return this.kTc;
    }

    private void cVX() {
        this.kSE = (RelativeLayout) findViewById(R.id.addition_container);
        this.kSF = (TextView) findViewById(R.id.addition_create_time);
        this.kSG = (TextView) findViewById(R.id.addition_last_time);
        this.kSH = (TextView) findViewById(R.id.addition_last_content);
        if (this.kSD != null) {
            this.kSE.setVisibility(0);
            this.kSF.setText(getPageContext().getString(R.string.write_addition_create) + aq.getFormatTime(this.kSD.getCreateTime() * 1000));
            if (this.kSD.getAlreadyCount() == 0) {
                this.kSG.setVisibility(8);
            } else {
                this.kSG.setText(getPageContext().getString(R.string.write_addition_last) + aq.getFormatTime(this.kSD.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.kSD.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.kSH.setText(lastAdditionContent);
            } else {
                this.kSH.setVisibility(8);
            }
            cWb().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.kSD.getAlreadyCount()), Integer.valueOf(this.kSD.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.kSE.setVisibility(8);
    }

    private void cIa() {
        this.jXx = findViewById(R.id.post_prefix_layout);
        if (this.kTR == null) {
            this.kTR = new com.baidu.tieba.c.d(getPageContext(), this.jXx);
            this.kTR.ck(R.drawable.bg_tip_blue_up_left);
            this.kTR.cj(16);
            this.kTR.kw(true);
            this.kTR.setUseDirectOffset(true);
            this.kTR.rz(l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.jXu = (TextView) findViewById(R.id.post_prefix);
        this.kSA = findViewById(R.id.prefix_divider);
        this.jXw = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.jXx.setVisibility(0);
            this.kTR.d(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.jWX = 0;
            this.jXx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").cy("fid", WriteActivity.this.jWW.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.jXu.setVisibility(0);
                    WriteActivity.this.jXx.setSelected(true);
                    am.setImageResource(WriteActivity.this.jXw, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.jXv, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.dwT.aMR();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.jXo);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.jXs);
                }
            });
            this.jXu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").cy("fid", WriteActivity.this.jWW.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.jXu.setSelected(true);
                    am.setImageResource(WriteActivity.this.jXw, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.jXv, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.dwT.aMR();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cWc());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cWb());
                }
            });
            this.jXv = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.jXv.a(this);
            this.jXv.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.jXv.setOutsideTouchable(true);
            this.jXv.setFocusable(true);
            this.jXv.setOnDismissListener(this);
            this.jXv.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            am.getColor(R.color.cp_cont_c);
            am.setBackgroundResource(this.jXu, R.color.cp_bg_line_d);
            am.setImageResource(this.jXw, R.drawable.icon_arrow_gray_down);
            this.jXu.setTextColor(color);
            this.kSB.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.kSB.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.tJ(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.tJ(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.jXv.addView(writePrefixItemLayout);
            }
            this.jXv.setCurrentIndex(0);
            this.jXu.setText(prefixs.get(0));
            Es(0);
            return;
        }
        this.jXx.setVisibility(8);
    }

    private void cWr() {
        if (this.kTh && this.jWW != null) {
            this.kTk.setVisibility(0);
            this.kTl.setVisibility(0);
            this.kSz = new FeedBackModel(getPageContext());
            this.kSz.Ld(this.jWW.getForumName());
            this.kSz.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.24
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.kTk.setVisibility(8);
                        WriteActivity.this.kTl.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.kTk.setVisibility(8);
                        WriteActivity.this.kTl.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.kTk.a(feedBackModel.cVA(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void cVY() {
        this.jXt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (WriteActivity.this.kSU.a(WriteActivity.this.jXo, WriteActivity.this.jXs)) {
                        WriteActivity.this.showToast(WriteActivity.this.kSU.cUh());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cWc());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cWb());
                    WriteActivity.this.dwT.aMR();
                    if (WriteActivity.this.jWW.getType() != 7) {
                        if (WriteActivity.this.kTh) {
                            WriteActivity.this.cWh();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            an anVar = new an("c12102");
                            anVar.X("obj_type", StringUtils.isNull(WriteActivity.this.jWW.getForumName()) ? 1 : 2);
                            TiebaStatic.log(anVar);
                            WriteActivity.this.cWi();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.cWh();
                    }
                    TiebaStatic.log(new an("c12262").cy("obj_locate", WriteActivity.this.gOk));
                }
            }
        });
    }

    protected void cWs() {
        this.kTn = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.kTn.sS(getPageContext().getString(R.string.is_save_draft)).fG(false).a(getPageContext().getString(R.string.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.jWW.setTitle(WriteActivity.this.cWc().getText().toString());
                WriteActivity.this.jWW.setContent(WriteActivity.this.cWb().getText().toString());
                int type = WriteActivity.this.jWW.getType();
                if (type == 0 || type == 9) {
                    v.c(WriteActivity.this.jWW.getForumId(), WriteActivity.this.jWW);
                } else if (type == 1) {
                    v.d(WriteActivity.this.jWW.getThreadId(), WriteActivity.this.jWW);
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
                int type = WriteActivity.this.jWW.getType();
                if (type == 0 || type == 9) {
                    v.c(WriteActivity.this.jWW.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    v.d(WriteActivity.this.jWW.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.kTn.b(getPageContext());
    }

    protected void cIb() {
        this.kTj = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.kTj.setIsRound(true);
        this.kTj.setDrawBorder(false);
        this.kTj.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String tn = o.tn(currentPortrait);
            this.kTj.setUrl(tn);
            this.kTj.startLoad(tn, 12, false);
        }
        if (this.jWW.isUserFeedback()) {
            this.kTj.setVisibility(0);
        }
        this.jXo = (EditText) findViewById(R.id.post_title);
        this.jXo.setOnClickListener(this.kSY);
        this.jXo.setOnFocusChangeListener(this.eWj);
        if (this.jWW.getType() == 0 || this.jWW.getType() == 9 || this.jWW.getType() == 7) {
            if (this.jWW.getTitle() != null) {
                this.jXo.setText(this.jWW.getTitle());
                this.jXo.setSelection(this.jWW.getTitle().length());
            } else if (this.kTi) {
                this.jXo.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.jWW.getType() == 1 || this.jWW.getType() != 2) {
        }
        this.jXo.addTextChangedListener(this.kTa);
        if (!this.jWW.getHaveDraft()) {
            cVU();
            this.kTM = true;
        }
        if (this.jWW.isUserFeedback()) {
            this.jXo.setHint(getResources().getString(R.string.feedback_title_hint));
        } else {
            this.jXo.setHint(getResources().getString(R.string.post_title_hint));
        }
    }

    private TextWatcher TM() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            private int kTV;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.cIc();
                if (WriteActivity.this.kSP) {
                    this.kTV = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.kTV);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.kSP || !WriteActivity.this.kTE) {
                    if (WriteActivity.this.kSP) {
                        if (this.mEditText != WriteActivity.this.kTv || this.mTextView != WriteActivity.this.kTB) {
                            this.mEditText = WriteActivity.this.kTv;
                            this.mTextView = WriteActivity.this.kTB;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.kTz || this.mTextView != WriteActivity.this.kTA) {
                    this.mEditText = WriteActivity.this.kTz;
                    this.mTextView = WriteActivity.this.kTA;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.kSP && this.kTE) {
            if (this.kTC != null) {
                this.kTz.removeTextChangedListener(this.kTC);
            }
            this.kTC = textWatcher;
        } else if (this.kSP) {
            if (this.kTD != null) {
                this.kTv.removeTextChangedListener(this.kTD);
            }
            this.kTD = textWatcher;
        }
        return textWatcher;
    }

    private long j(EditText editText) {
        if (editText == this.kTv) {
            return 233L;
        }
        if (editText != this.kTz) {
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

    protected void cId() {
        this.jXs = (EditText) findViewById(R.id.post_content);
        this.jXs.setDrawingCacheEnabled(false);
        this.jXs.setOnClickListener(this.kSY);
        if (this.jWW.getContent() != null && this.jWW.getContent().length() > 0) {
            SpannableString aB = TbFaceManager.aPQ().aB(getPageContext().getPageActivity(), this.jWW.getContent());
            this.jXs.setText(aB);
            this.jXs.setSelection(aB.length());
        } else if (this.jWW.getType() == 2) {
            if (this.kTo) {
                if (this.kTp != null && this.kTp.length() > 0) {
                    this.jXs.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.kTp}));
                    this.jXs.setSelection(this.jXs.getText().length());
                }
            } else if (this.jWW.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.jWW.getFloorNum()));
                this.jXs.setText(format);
                this.jXs.setSelection(format.length());
            }
        }
        this.jXs.setOnFocusChangeListener(this.eWj);
        this.jXs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.dwT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.jXs.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.jXs.addTextChangedListener(this.kTb);
        if (this.jWW.getType() == 0) {
            this.kTQ = true;
        } else {
            tU(true);
            this.kTQ = false;
        }
        if (this.jWW.isUserFeedback()) {
            this.jXs.setHint(R.string.write_input_content);
        } else {
            this.jXs.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void tU(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.kSP) {
            cWb().setPadding(0, 0, 0, 0);
            cWb().setBackgroundDrawable(null);
            am.setBackgroundColor(cWb(), R.color.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.ihy) && this.kSD == null) {
                com.baidu.adp.lib.e.c.gr().a(this.ihy, 19, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.30
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
                            WriteActivity.this.cWb().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.cWb(), true, WriteActivity.this.iPH);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cWa() {
        int i = 5000;
        if (this.kSD != null) {
            i = 1000;
        }
        return cWb().getText() != null && cWb().getText().length() >= i;
    }

    private void vi(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.kSt)) {
                this.kSt = "";
                cWb().requestFocus();
                if (cWb().getText() != null && cWb().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cWb().getSelectionStart();
                    editable = cWb().getText();
                }
            } else if ("from_title".equals(this.kSt)) {
                this.kSt = "";
                cWc().requestFocus();
                if (cWc().getText() != null && cWc().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cWc().getSelectionStart();
                    editable = cWc().getText();
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
    public void tS(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.jWW != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.jWW.getForumId(), 0L), this.jWW.getFirstDir(), this.jWW.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(q qVar) {
        if (((ImageSpan[]) cWb().getText().getSpans(0, cWb().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.kSC == null) {
                this.kSC = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            this.kSC.show();
            return;
        }
        String name = qVar.getName();
        final EmotionGroupType aJx = qVar.aJx();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.e.c.gr().a(name, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.32
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass32) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.cWb().getSelectionStart(), aVar, aJx);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cWb() != null && cWb().getText() != null) {
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
                int selectionStart = cWb().getSelectionStart() - 1;
                if (cWb().getText().length() > 1 && selectionStart >= 0 && cWb().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cWb().getText().insert(cWb().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cWb().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cWb().getText().insert(cWb().getSelectionStart(), spannableString2);
            }
            Editable text = cWb().getText();
            if (text != null) {
                this.kSS.clear();
                this.kSS.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.kSS);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cWb().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cWb().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cWb().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cWb() {
        return this.kSP ? this.kTv : this.jXs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cWc() {
        return this.kSP ? this.kTz : this.jXo;
    }

    protected void cWd() {
        Editable text;
        if (cWb() != null && (text = cWb().getText()) != null) {
            int selectionStart = cWb().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cWb().onKeyDown(67, this.gaI);
            }
            cWb().onKeyDown(67, this.gaI);
            int selectionStart2 = cWb().getSelectionStart();
            if (text != null) {
                this.kSS.clear();
                this.kSS.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.kSS);
                cWb().setSelection(selectionStart2);
            }
        }
    }

    private void o(Boolean bool) {
        String str = null;
        if (this.jWW != null) {
            str = this.jWW.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.kTh = true;
        }
    }

    private void cWt() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void cWu() {
        try {
            if (this.kTn != null) {
                this.kTn.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.dGg.setCancelListener(null);
        this.dGg.setTipString(R.string.sending);
        this.dGg.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.dGg.setDialogVisiable(false);
    }

    private Boolean cWv() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.dyD = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void cIc() {
        if (this.jWW != null) {
            String str = "";
            String str2 = "";
            if (cWc() != null) {
                str = cWc().getText().toString();
            }
            if (cWb() != null) {
                str2 = cWb().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.jWW.getType() == 0 || this.jWW.getType() == 9 || this.jWW.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.jWX == com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.jWW.setIsNoTitle(true);
                        } else if (this.kSy.getVisibility() == 0) {
                            this.jWW.setIsNoTitle(false);
                            tT(true);
                            return;
                        }
                    } else if (this.kSy.getVisibility() == 0) {
                        this.jWW.setIsNoTitle(false);
                        tT(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.jWW.setIsNoTitle(true);
                } else if (this.kSy.getVisibility() == 0) {
                    this.jWW.setIsNoTitle(false);
                    tT(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.kSP) {
                    tT(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    tT(true);
                }
            }
            if (this.jWW.getType() == 4) {
                tT(m(this.kTv) && l(this.kTz));
            } else if (this.jWW.getType() == 5) {
                tT(m(this.kTv));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                tT(true);
            } else if (this.jWW.getVideoInfo() != null) {
                tT(true);
            } else {
                tT(false);
            }
        }
    }

    public void tT(boolean z) {
        if (z) {
            am.setNavbarTitleColor(this.jXt, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.jXt.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.jXt, R.color.cp_cont_d, 1);
        this.jXt.setEnabled(false);
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
        this.dyz = new NewWriteModel(this);
        this.dyz.b(this.dyN);
        registerListener(this.kTS);
        this.gfz = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.cHT();
            }
        };
        this.jWW = new WriteData();
        if (bundle != null) {
            this.jWW.setType(bundle.getInt("type", 0));
            this.jWW.setForumId(bundle.getString("forum_id"));
            this.jWW.setForumName(bundle.getString("forum_name"));
            this.jWW.setFirstDir(bundle.getString("forum_first_dir"));
            this.jWW.setSecondDir(bundle.getString("forum_second_dir"));
            this.jWW.setThreadId(bundle.getString("thread_id"));
            this.jWW.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.jWW.setFloorNum(bundle.getInt("floor_num", 0));
            this.kTh = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.kTi = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.kTo = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.kTp = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.dyx = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.kSD = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.jWW.setIsAddition(this.kSD != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.kTq = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.jWW.setTitle(bundle.getString("write_title"));
            this.jWW.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.jWW.setTopicId(this.mTopicId);
            this.gOk = bundle.getString("KEY_CALL_FROM");
            this.aBY = bundle.getInt("album_thread");
            stringExtra = string;
        } else {
            Intent intent = getIntent();
            this.jWW.setType(intent.getIntExtra("type", 0));
            this.jWW.setForumId(intent.getStringExtra("forum_id"));
            this.jWW.setForumName(intent.getStringExtra("forum_name"));
            this.jWW.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.jWW.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.jWW.setThreadId(intent.getStringExtra("thread_id"));
            this.jWW.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.jWW.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.kTh = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.kTi = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.kTo = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.kTp = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.kSD = (AdditionData) intent.getSerializableExtra("addition_data");
            this.jWW.setIsAddition(this.kSD != null);
            this.jWW.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.kTq = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.gmH = intent.getStringExtra("more_forum_img");
            this.gmI = intent.getStringExtra("more_forum_title");
            this.gmG = intent.getStringExtra("more_forum_url");
            this.jWW.setTitle(intent.getStringExtra("write_title"));
            this.jWW.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.jWW.setTopicId(this.mTopicId);
            this.gOk = intent.getStringExtra("KEY_CALL_FROM");
            this.aBY = intent.getIntExtra("album_thread", 0);
            stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
        }
        if (this.jWW.getType() == 9) {
            this.jWW.setEntranceType(1);
        } else if (this.jWW.getType() == 10) {
            this.jWW.setEntranceType(2);
            this.jWW.setType(9);
        } else if (this.jWW.getType() == 0) {
            this.jWW.setEntranceType(3);
        }
        this.jWW.setIsUserFeedback(this.kTh);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (stringExtra != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.jWW.getType() == 4 ? 6 : 9);
        this.jWW.setWriteImagesInfo(this.writeImagesInfo);
        if (this.jWW.getType() == 0 || this.jWW.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                v.c(this.jWW.getForumId(), this);
            }
        } else if (this.jWW.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                v.c("24591571", this);
            }
        } else if (this.jWW.getType() == 1) {
            v.a(this.jWW.getThreadId(), this);
        } else if (this.jWW.getType() == 4) {
            v.c(this.jWW.getForumId() + "photolive", this);
        } else if (this.jWW.getType() == 5) {
            v.a(this.jWW.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.ihy = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.jWW != null && this.jWW.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.jWW.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.kSw = true;
        }
        cVV();
        try {
            this.kTF = cWE();
        } catch (Throwable th) {
            this.kTF = null;
        }
    }

    private void cWe() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.jXo.setText(com.baidu.tbadk.plugins.b.vJ(com.baidu.tbadk.plugins.b.vK(hotTopicBussinessData.mTopicName)));
            this.jXo.setMovementMethod(com.baidu.tieba.view.c.cTv());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString vJ = com.baidu.tbadk.plugins.b.vJ(com.baidu.tbadk.plugins.b.vK(hotTopicBussinessData.mTopicName));
            if (vJ != null) {
                this.jXo.setText(vJ);
            }
            this.kSR.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.v.a
    public void a(WriteData writeData) {
        String str;
        String vK;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            if (writeData != null) {
                if (this.jWW != null) {
                    this.jWW.setHaveDraft(true);
                    if (com.baidu.adp.lib.util.k.isEmpty(cWc().getText().toString()) || this.kTM || ((this.kTh || this.kSw) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                        if (com.baidu.adp.lib.util.k.isEmpty(this.jWW.getTitle())) {
                            this.jWW.setTitle(writeData.getTitle());
                        }
                        if (!com.baidu.tbadk.core.util.v.isEmpty(this.mList)) {
                            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.getItem(this.mList, 0);
                            if (hotTopicBussinessData == null) {
                                str = null;
                            } else {
                                str = hotTopicBussinessData.mTopicName;
                            }
                            if (StringUtils.isNull(str)) {
                                vK = this.jWW.getTitle();
                            } else {
                                vK = com.baidu.tbadk.plugins.b.vK(str);
                            }
                            SpannableString vJ = com.baidu.tbadk.plugins.b.vJ(vK);
                            if (vJ != null) {
                                cWc().setText(vJ);
                                cWc().setSelection(vJ.length() > vK.length() ? vK.length() : vJ.length());
                            }
                        } else {
                            SpannableString vJ2 = com.baidu.tbadk.plugins.b.vJ(this.jWW.getTitle());
                            if (vJ2 != null) {
                                cWc().setText(vJ2);
                                cWc().setSelection(this.jWW.getTitle().length() > vJ2.length() ? vJ2.length() : this.jWW.getTitle().length());
                            }
                        }
                    }
                    if (this.jWW != null && !this.jWW.getHaveDraft()) {
                        cVU();
                    }
                    if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.copy(writeData.getVideoInfo());
                        this.jWW.setVideoInfo(videoInfo);
                        this.dwT.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                    }
                    if ((com.baidu.adp.lib.util.k.isEmpty(cWb().getText().toString()) || this.kTh || this.kSw) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                        this.jWW.setContent(writeData.getContent());
                        SpannableString a2 = TbFaceManager.aPQ().a(getPageContext().getPageActivity(), this.jWW.getContent(), this.kSW);
                        cWb().setText(a2);
                        cWb().setSelection(a2.length());
                        if (this.kSP) {
                            a(this.kTB, this.kTv);
                        }
                    }
                    if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                        this.writeImagesInfo = writeData.getWriteImagesInfo();
                        this.jWW.setWriteImagesInfo(this.writeImagesInfo);
                        cWC();
                        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                            cWk();
                        }
                        tV(false);
                    }
                    if (writeData.getType() == 4 || writeData.getType() == 5) {
                        cWw();
                    }
                    cIc();
                    int categoryTo = writeData.getCategoryTo();
                    if (categoryTo >= 0 && this.kSI != null) {
                        this.kSM = this.kSJ.gse;
                        this.kSL = this.kSJ.name;
                        int i = 0;
                        while (true) {
                            if (i == this.kSI.size()) {
                                break;
                            }
                            w wVar = this.kSI.get(i);
                            if (categoryTo != wVar.gse) {
                                i++;
                            } else {
                                this.kSM = categoryTo;
                                this.kSL = wVar.name;
                                this.jWW.setCategoryTo(this.kSM);
                                break;
                            }
                        }
                        if (this.kSN != null) {
                            this.kSN.setText(this.kSL);
                            this.kSN.setCategoryContainerData(this.kSI, this.kSJ, this.kSM);
                        }
                    }
                    this.dwT.aMR();
                    return;
                }
                return;
            }
            cWw();
            cVU();
        }
    }

    private void cWw() {
        if ((!this.kSP || this.kTu != null) && this.kTt != null) {
            this.kTu.b(this.writeImagesInfo);
            cWA();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.jWW.getType());
        bundle.putString("forum_id", this.jWW.getForumId());
        bundle.putString("forum_name", this.jWW.getForumName());
        bundle.putString("forum_first_dir", this.jWW.getFirstDir());
        bundle.putString("forum_second_dir", this.jWW.getSecondDir());
        bundle.putString("thread_id", this.jWW.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.jWW.getFloor());
        bundle.putInt("floor_num", this.jWW.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.kTo);
        if (this.kTh) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.dyx);
        if (this.kSD != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.kSD));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.kTq);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.gOk);
        bundle.putInt("album_thread", this.aBY);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cWb().getEditableText().toString();
        if (obj != null) {
            cWb().setText(TbFaceManager.aPQ().a(getPageContext().getPageActivity(), obj, this.kSW));
            cWb().setSelection(cWb().getText().length());
        }
    }

    private String cWf() {
        return (cWb() == null || cWb().getText() == null) ? "" : cWb().getText().toString();
    }

    private String cWg() {
        if (this.jWW == null || cWc() == null || cWc().getVisibility() != 0 || cWc().getText() == null) {
            return "";
        }
        String obj = cWc().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) > 0 && this.jWX != com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) - 1 && this.jWW.getType() != 4 && this.jXu != null && this.jXu.getText() != null) {
            this.jWW.setPostPrefix(this.jXu.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.jWW.getTitle();
        }
        return obj;
    }

    private void Le(String str) {
        if (this.jWW != null && this.kSy != null) {
            if (this.kSy.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.jWW.setIsNoTitle(true);
                    this.jWW.setTitle("");
                    return;
                }
                this.jWW.setIsNoTitle(false);
                this.jWW.setTitle(str);
                return;
            }
            this.jWW.setIsNoTitle(true);
            this.jWW.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWh() {
        cHT();
        this.jWW.setContent(cWf());
        Le(cWg());
        if (this.kTh || this.kSw) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.jWW.getTitle()) || !this.jWW.getTitle().startsWith(string)) {
                Le(string + this.jWW.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.jWW.getContent()) || !this.jWW.getContent().startsWith(str)) {
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
                sb.append(this.jWW.getContent());
                this.jWW.setContent(sb.toString());
            }
        }
        if (this.kSK >= 0) {
            this.jWW.setCategoryFrom(this.kSK);
        }
        if (this.kSM >= 0) {
            this.jWW.setCategoryTo(this.kSM);
        }
        this.jWW.setWriteImagesInfo(this.writeImagesInfo);
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
            this.jWW.setTakePhotoNum(i);
        }
        this.jWW.setHasLocationData(this.dyy != null && this.dyy.brm());
        if (this.writeImagesInfo != null) {
            this.dyz.sS(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.mList) && this.kSQ != null && this.kSQ.mIsGlobalBlock == 0) {
            this.jWW.setForumId(String.valueOf(this.kSQ.mForumId));
            this.jWW.setForumName(this.kSQ.mForumName);
        }
        this.dyz.d(this.jWW);
        this.jWW.setContent(this.jWW.getContent().replaceAll("\u0000\n", ""));
        this.jWW.setContent(this.jWW.getContent().replaceAll("\u0000", ""));
        this.jWW.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.dyz.cHV().setVoice(this.mVoiceModel.getId());
                this.dyz.cHV().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.dyz.cHV().setVoice(null);
                this.dyz.cHV().setVoiceDuringTime(-1);
            }
        } else {
            this.dyz.cHV().setVoice(null);
            this.dyz.cHV().setVoiceDuringTime(-1);
        }
        if (!this.dyz.cMn()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.gfz);
            this.dyz.cMk();
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
            if (this.kSD != null) {
                i2 = this.kSD.getTotalCount();
                i = this.kSD.getAlreadyCount() + 1;
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
                if (this.jXo == getCurrentFocus()) {
                    cWb().clearFocus();
                    this.jXo.requestFocus();
                    if (this.dwT != null) {
                        this.dwT.aMR();
                    }
                    ShowSoftKeyPadDelay(this.jXo);
                } else {
                    cWb().requestFocus();
                    if (this.dwT != null) {
                        this.dwT.aMR();
                    }
                    ShowSoftKeyPadDelay(this.jXs);
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
                            cWb().getText().insert(cWb().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.jWW.getType() == 0 || this.jWW.getType() == 9) {
                    v.c(this.jWW.getForumId(), (WriteData) null);
                    if (postWriteCallBackData2 != null) {
                    }
                } else if (this.jWW.getType() == 1) {
                    v.d(this.jWW.getThreadId(), (WriteData) null);
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
                                cWB();
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
                        if (this.kTQ) {
                            tU(true);
                            this.kTQ = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.kSP) {
                        U(intent);
                        cIc();
                        return;
                    }
                    aC(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.jWW.setVideoInfo(videoInfo);
                        this.dwT.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                        this.dwT.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.dwT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    cIc();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.kSu) {
                                sb2.append(com.baidu.tbadk.plugins.b.dFM);
                                this.kSu = false;
                            }
                            sb2.append(stringExtra);
                            vi(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.isEmpty(this.mList) && !com.baidu.tbadk.core.util.v.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                    this.kSQ = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                    a(this.kSQ);
                }
            }
        } else if (i2 == 0) {
            if (this.dwT != null && !this.dwT.aOw()) {
                this.jXs.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.dwT.aMR();
            }
            switch (i) {
                case 12001:
                    aPc();
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    cWz();
                    if (this.kTQ) {
                        tU(true);
                        this.kTQ = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.jXo == getCurrentFocus()) {
                        cWb().clearFocus();
                        this.jXo.requestFocus();
                        if (this.dwT != null) {
                            this.dwT.aMR();
                        }
                        ShowSoftKeyPadDelay(this.jXo);
                        return;
                    }
                    cWb().requestFocus();
                    if (this.dwT != null) {
                        this.dwT.aMR();
                    }
                    ShowSoftKeyPadDelay(this.jXs);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.kSU.KL(postWriteCallBackData.getErrorString());
                        this.kSU.aU(postWriteCallBackData.getSensitiveWords());
                        this.kSU.b(this.jXo, this.jXs);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.dyx = String.valueOf(System.currentTimeMillis());
                    al.a(getPageContext(), this.dyx);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    cWz();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.kSt)) {
                        cWc().requestFocus();
                        return;
                    } else if ("from_content".equals(this.kSt)) {
                        cWb().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWi() {
        if ("1".equals(this.gOk)) {
            this.jWW.setCanNoForum(true);
            this.jWW.setTransmitForumData("[]");
        } else if ("2".equals(this.gOk)) {
            this.jWW.setCanNoForum(false);
        }
        cWj();
        this.jWW.setPrivacy(this.isPrivacy);
        cWx();
        this.jWW.setToDynamic(this.isToDynamic);
        this.jWW.setCallFrom(this.gOk);
        if (this.jWW.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cWh();
    }

    private void cWj() {
        if (this.dwT != null) {
            this.dwT.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void cWx() {
        if (this.dwT != null) {
            this.dwT.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void cWy() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void cWz() {
        if (this.kSP) {
            this.kTu.b(this.writeImagesInfo);
            cWA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWA() {
        this.kTu.notifyDataSetChanged();
        this.kTt.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.kTu.notifyDataSetChanged();
                WriteActivity.this.kTt.invalidateViews();
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
        cIc();
    }

    private void aB(Intent intent) {
        if (this.kSP) {
            aC(intent);
            cWz();
        } else {
            aF(intent);
        }
        cIc();
    }

    private void aC(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            cWz();
            tV(true);
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

    private void cWB() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void aE(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.kTr.parseJson(stringExtra);
            this.kTr.updateQuality();
            if (this.kTr.getChosedFiles() != null && this.kTr.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.kTr.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.kTr.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cWc());
        HidenSoftKeyPad(this.mInputManager, cWb());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void aF(Intent intent) {
        c(intent, true);
    }

    private void T(Intent intent) {
        this.dyx = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.dyx;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.getEquipmentWidth(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.dyx, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            cWC();
            cWk();
        }
        tV(true);
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
                cWC();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    cWk();
                }
            }
            tV(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWC() {
        if (this.dwT.mp(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void aPc() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.dyx));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void cWD() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.gmH)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                com.baidu.tbadk.util.o oVar = new com.baidu.tbadk.util.o(this, this.gmH, new o.a() { // from class: com.baidu.tieba.write.write.WriteActivity.38
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
                            WriteActivity.this.tV(true);
                        }
                    }
                });
                oVar.setFrom(1);
                oVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tV(boolean z) {
        String forumId = this.jWW == null ? "" : this.jWW.getForumId();
        if (this.kTs != null) {
            this.kTs.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.goy == null) {
            this.goy = VoiceManager.instance();
        }
        return this.goy;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bEl() {
        this.goy = getVoiceManager();
        this.goy.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bb(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.gpF) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.jWW.getType() != 7) {
                if (this.kSD == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                B(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.dyE = i;
        if (this.dwT != null) {
            this.dwT.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void cWk() {
        if (!this.kSP) {
            if (this.dwT != null) {
                this.dwT.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.dwT.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.jWW == null ? "" : this.jWW.getForumId();
            if (this.kTs != null) {
                this.kTs.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gJ(boolean z) {
        if (this.dwT != null) {
            this.dwT.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Es(int i) {
        if (i < this.kSB.size()) {
            for (int i2 = 0; i2 < this.kSB.size(); i2++) {
                this.kSB.get(i2).tK(false);
            }
            this.kSB.get(i).tK(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void Cd(int i) {
        if (i == com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new an("c13014").X("obj_type", 1));
        } else {
            TiebaStatic.log(new an("c13014").X("obj_type", 2));
        }
        this.jWX = i;
        this.jXv.setCurrentIndex(i);
        Es(i);
        this.jXu.setText(this.mPrefixData.getPrefixs().get(i));
        cIc();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.jXv, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.jXx.setSelected(false);
        am.setImageResource(this.jXw, R.drawable.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.jXs);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes13.dex */
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
        if (this.jWW != null) {
            if (this.jWW.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.jWW.getType() == 5) {
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
            aOW();
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = ab.transformPermissionResult(strArr, iArr);
            if (ab.checkCamera(getApplicationContext())) {
                al.a(getPageContext(), this.dyx);
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
        this.auE = z;
        if (this.kTK && System.currentTimeMillis() - this.kTL < 800) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.kTK = false;
        }
        if (this.kST != null && !z) {
            this.kST.byK();
        }
        if (this.kSV != null && !z) {
            cVN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lf(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.kTH != null) {
            Lg(str);
            this.kTH.dismiss();
        }
    }

    private void fI(Context context) {
        kTJ = l.getEquipmentHeight(context);
    }

    private void Lg(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.kTK = true;
        cWC();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            cWk();
        }
        tV(true);
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

    private File cWE() {
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

    private void cWF() {
        if (this.kTF != null && this.jWW.getType() == 0 && this.jWW.getType() == 9) {
            fI(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.kTF != null) {
                        WriteActivity.this.Lf(WriteActivity.this.kTF.getAbsolutePath());
                    }
                }
            });
            this.kTG = (TbImageView) this.mBubbleView.findViewById(R.id.rec_img_view);
            this.kTI = (LinearLayout) this.mBubbleView.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.aFD().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.kTF.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.aFD().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.kTF.getAbsolutePath());
                Bitmap g = g(this.kTF.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (g != null) {
                    this.kTG.setImageBitmap(g);
                    this.kTG.setDrawBorder(true);
                    this.kTG.setBorderWidth(2);
                    this.kTG.setBorderColor(am.getColor(R.color.common_color_10264));
                    this.kTH = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.kTH.setCanceledOnTouchOutside(true);
                    this.kTH.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.kTK) {
                                l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.kTL = System.currentTimeMillis();
                            }
                        }
                    });
                    this.kTH.setContentView(this.mBubbleView);
                    this.kTH.show();
                    Window window = this.kTH.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (kTJ / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.auE && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.kSu = false;
            this.kSt = "";
            if ("from_content".equals(str)) {
                this.kSt = "from_content";
            } else if ("from_title".equals(str)) {
                this.kSt = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.vI(String.valueOf(charSequence.charAt(i)))) {
                tS(false);
            }
        }
    }

    public void cDi() {
        if (this.kTh || !com.baidu.tbadk.core.util.v.isEmpty(this.mList) || !StringUtils.isNull(this.jWW.getTitle())) {
            this.kSy.setVisibility(0);
            this.kSy.requestFocus();
            return;
        }
        this.kSy.setVisibility(8);
    }
}
