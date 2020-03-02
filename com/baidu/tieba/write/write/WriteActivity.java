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
    private static int kTx = 0;
    private EditorTools dwG;
    private String dyk;
    private LocationModel dyl;
    private NewWriteModel dym;
    private String gmt;
    private String gmu;
    private String gmv;
    private VoiceManager gol;
    private LinearLayout iJt;
    private PlayVoiceBntNew iJu;
    private ImageView iJw;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private int jWL;
    private TextView jXi;
    private com.baidu.tieba.write.h jXj;
    private ImageView jXk;
    private View jXl;
    private com.baidu.tieba.write.b.c kQr;
    private int kSA;
    private PostCategoryView kSB;
    private HotTopicBussinessData kSE;
    private TextView kSF;
    private com.baidu.tieba.write.editor.b kSH;
    private e kSJ;
    private com.baidu.tieba.view.b kSQ;
    private View kSZ;
    private LinearLayout kSl;
    private LinearLayout kSm;
    private View kSo;
    private Toast kSq;
    private AdditionData kSr;
    private RelativeLayout kSs;
    private TextView kSt;
    private TextView kSu;
    private TextView kSv;
    List<w> kSw;
    w kSx;
    private int kSy;
    private String kSz;
    private View kTB;
    private View kTC;
    private TextView kTD;
    private com.baidu.tieba.c.d kTF;
    private g kTg;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String kSh = "";
    private boolean kSi = false;
    private WriteData jWK = null;
    private boolean kSV = false;
    private boolean kSk = false;
    private boolean kSW = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText jXc = null;
    private HeadImageView kSX = null;
    private View jXd = null;
    private LinearLayout jXf = null;
    private EditText jXg = null;
    private FeedBackModel kSn = null;
    private FeedBackTopListView kSY = null;
    private ArrayList<WritePrefixItemLayout> kSp = new ArrayList<>();
    private String ihm = null;
    private final KeyEvent gav = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView kTa = null;
    private TextView jXh = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener gfm = null;
    private com.baidu.tbadk.core.dialog.a kTb = null;
    private final Handler mHandler = new Handler();
    private boolean kTc = false;
    private String kTd = null;
    private RelativeLayout hrZ = null;
    private String dyq = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int dyr = 0;
    private int kTe = 0;
    private WriteImagesInfo kTf = new WriteImagesInfo();
    private View mRootView = null;
    private GridView kTh = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a kTi = null;
    private ScrollView kSC = null;
    private EditText kTj = null;
    private View kTk = null;
    private View kTl = null;
    private View kTm = null;
    private EditText kTn = null;
    private TextView kTo = null;
    private TextView kTp = null;
    private TextWatcher kTq = null;
    private TextWatcher kTr = null;
    private boolean kSD = false;
    private boolean kTs = false;
    private com.baidu.tbadk.core.view.a dFT = null;
    private String mFrom = "write";
    private File kTt = null;
    private TbImageView kTu = null;
    private View mBubbleView = null;
    private Dialog kTv = null;
    private LinearLayout kTw = null;
    private boolean kTy = false;
    private long kTz = -1000;
    private boolean kTA = false;
    private String gNY = "2";
    private int aBX = 0;
    private String mTopicId = "";
    private SpannableStringBuilder kSG = new SpannableStringBuilder();
    private boolean kTE = false;
    private boolean auD = false;
    private final b kSI = new b();
    private final HttpMessageListener kTG = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.ihm)) {
                    WriteActivity.this.ihm = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.tU(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.ihm)) {
                    WriteActivity.this.ihm = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.ihm);
                    WriteActivity.this.tU(true);
                }
            }
        }
    };
    private TbFaceManager.a kSK = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan vv(String str) {
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
    private final AntiHelper.a gps = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d dyA = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.bEk();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.jWK != null) {
                WriteActivity.this.kSI.aU(null);
                if (z) {
                    WriteActivity.this.gJ(z);
                    if (WriteActivity.this.e(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    if (WriteActivity.this.jWK.getType() != 0 && WriteActivity.this.jWK.getType() != 9) {
                        if (WriteActivity.this.jWK.getType() != 7) {
                            if (WriteActivity.this.jWK.getType() == 1) {
                                v.d(WriteActivity.this.jWK.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.jWK.getType() == 5) {
                                v.d(WriteActivity.this.jWK.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            v.c("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            v.c(WriteActivity.this.jWK.getForumId(), (WriteData) null);
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
                    WriteActivity.this.kSI.aU(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.kSI.KK(postWriteCallBackData.getErrorString());
                    WriteActivity.this.kSI.b(WriteActivity.this.jXc, WriteActivity.this.jXg);
                } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aJG());
                    if (com.baidu.tbadk.s.a.wa(aaVar.aJF())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJF());
                        if (WriteActivity.this.kSW) {
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
    private final LocationModel.a dyy = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void aPk() {
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
            if (aVar != null && !StringUtils.isNull(aVar.cLE())) {
                WriteActivity.this.a(2, true, aVar.cLE());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener kiW = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.dyl.sQ(false);
                    WriteActivity.this.dyl.eG(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.dyl.sQ(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener kSL = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener kSM = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.dwG.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cVJ = WriteActivity.this.cVJ();
            if (cVJ >= 0 && cVJ < WriteActivity.this.jXg.getText().length()) {
                WriteActivity.this.jXg.setSelection(cVJ);
            }
        }
    };
    private boolean kSN = true;
    private final View.OnFocusChangeListener eVW = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.jXc || view == WriteActivity.this.mBack || view == WriteActivity.this.jXh) {
                if (z) {
                    WriteActivity.this.kSN = true;
                    WriteActivity.this.cVK();
                    l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.jXc);
                    if (WriteActivity.this.dwG != null) {
                        WriteActivity.this.dwG.aMQ();
                    }
                } else if (view == WriteActivity.this.jXc) {
                    WriteActivity.this.jXi.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.jXg && z) {
                WriteActivity.this.kSN = false;
                WriteActivity.this.cVK();
                l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.jXg);
                if (WriteActivity.this.dwG != null) {
                    WriteActivity.this.dwG.aMQ();
                }
            }
            WriteActivity.this.cVP();
        }
    };
    private TextWatcher kSO = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String kSS = "";
        private String kST;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kST = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.kST != null ? this.kST.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cIb();
            WriteActivity.this.cVQ();
            EditText cWb = WriteActivity.this.cWb();
            if (editable != null && cWb != null && cWb.getText() != null) {
                if (this.kSS == null || !this.kSS.equals(editable.toString())) {
                    if (WriteActivity.this.kSI != null) {
                        this.kSS = cWb.getText().toString();
                        WriteActivity.this.kSI.b(cWb, true);
                        return;
                    }
                    return;
                }
                cWb.setSelection(cWb.getSelectionEnd());
            }
        }
    };
    private TextWatcher kSP = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String kST;
        private String kSU = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kST = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.kST != null ? this.kST.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cIb();
            EditText cWa = WriteActivity.this.cWa();
            if (editable != null && cWa != null && cWa.getText() != null) {
                if (this.kSU == null || !this.kSU.equals(editable.toString())) {
                    if (WriteActivity.this.kSI != null) {
                        this.kSU = cWa.getText().toString();
                        WriteActivity.this.kSI.b(cWa, false);
                        return;
                    }
                    return;
                }
                cWa.setSelection(cWa.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0610a iPv = new a.InterfaceC0610a() { // from class: com.baidu.tieba.write.write.WriteActivity.31
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0610a
        public void onRefresh() {
            WriteActivity.this.ihm = null;
            WriteActivity.this.tU(false);
            WriteActivity.this.dwG.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void aOU() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void aOV() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aOX();
        } else if (this.dyl.cLL()) {
            aOU();
        } else {
            this.dyl.sQ(false);
            a(1, true, (String) null);
            this.dyl.cLJ();
        }
    }

    public void cWl() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
            if (this.kSH != null) {
                this.kSH.cUQ();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aOX();
        } else if (this.dyl != null) {
            this.dyl.sQ(false);
            a(1, true, (String) null);
            this.dyl.cLJ();
        }
    }

    private void aOX() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.jW(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.dyl.cLN();
                } else {
                    WriteActivity.this.dyy.aPk();
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
    public int cVJ() {
        int selectionEnd = cWa().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cWa().getText().getSpans(0, cWa().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cWa().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cWa().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVK() {
        if (this.dwG != null) {
            this.dwG.setBarLauncherEnabled(!this.kSN);
            this.dwG.setBarLauncherEnabled(true, 26);
            this.dwG.setBarLauncherEnabled(true, 2);
            this.dwG.setBarLauncherEnabled(true, 30);
            V(9, this.kSN ? false : true);
        }
    }

    private void V(int i, boolean z) {
        com.baidu.tbadk.editortools.g mm;
        if (this.dwG != null && (mm = this.dwG.mm(i)) != null) {
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
        if (this.kSD) {
            this.jXc.setVisibility(8);
            if (this.jWK.getType() == 5) {
                this.kTm.setVisibility(8);
            } else {
                this.kTm.setVisibility(0);
            }
            a(this.kTp, this.kTj);
            a(this.kTo, this.kTn);
            cIb();
        }
        if (this.kSV) {
            this.kSN = true;
            cVK();
            if (this.dwG != null) {
                this.dwG.aMQ();
            }
            this.jXc.requestFocus();
            ShowSoftKeyPadDelay(this.jXc);
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
            cWB();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                cWj();
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
        if (this.jWK.getType() == 0) {
            Et(this.aBX);
        }
        initUI();
        cWq();
        this.dyl = new LocationModel(getPageContext());
        this.dyl.a(this.dyy);
        registerListener(this.kiW);
        registerListener(this.kSL);
        cfM();
        cWE();
        if (this.kSD) {
            this.kTi.setEditorTools(this.dwG);
        } else {
            this.jXg.requestFocus();
        }
        cDh();
        cWj();
        cWC();
    }

    @SuppressLint({"ResourceAsColor"})
    private void cfM() {
        this.dwG = new EditorTools(getActivity());
        this.dwG.setBarMaxLauCount(5);
        this.dwG.setMoreButtonAtEnd(true);
        this.dwG.setBarBackgroundColorId(R.color.cp_bg_line_h);
        this.dwG.setBarLauncherType(1);
        this.dwG.gB(true);
        this.dwG.gC(true);
        switch (this.jWK.getType()) {
            case 4:
            case 5:
                cWo();
                break;
            default:
                cVL();
                break;
        }
        this.dwG.build();
        if (this.kSl != null) {
            this.kSl.addView(this.dwG);
        }
        bZP();
        this.dwG.display();
        com.baidu.tbadk.editortools.g mm = this.dwG.mm(6);
        if (mm != null && !TextUtils.isEmpty(this.dyq)) {
            ((View) mm).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.dyq);
                }
            });
        }
        if (!this.kSD) {
            this.dwG.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.dwG.aMQ();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.dwG.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.dwG.b(new com.baidu.tbadk.editortools.a(2, 26, HanziToPinyin.Token.SEPARATOR));
        }
        cVN();
    }

    private void cWm() {
        this.kTk = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.kTm = this.kTk.findViewById(R.id.live_post_title_container);
        this.kTj = (EditText) this.kTk.findViewById(R.id.live_post_content);
        this.kTh = (GridView) this.kTk.findViewById(R.id.photoLiveGridView);
        this.kTn = (EditText) this.kTk.findViewById(R.id.live_post_title);
        this.kTo = (TextView) this.kTk.findViewById(R.id.titleOverPlusNumber);
        this.kTp = (TextView) this.kTk.findViewById(R.id.contentOverPlusNumber);
        this.kTl = this.kTk.findViewById(R.id.live_interval_view);
        this.kTo.setText(String.valueOf(20));
        this.kTp.setText(String.valueOf(233));
        this.kTk.setVisibility(0);
        this.kTo.setVisibility(0);
        this.kTp.setVisibility(0);
        this.kTn.setHint(R.string.tips_title_limit_new);
        this.kTn.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.kTs = true;
                    WriteActivity.this.kSN = true;
                    WriteActivity.this.cVK();
                    if (WriteActivity.this.dwG != null) {
                        WriteActivity.this.dwG.aMQ();
                    }
                }
            }
        });
        if (this.jWK.getType() == 4) {
            this.kTj.setHint(R.string.live_write_input_content_new);
        } else if (this.jWK.getType() == 5) {
            this.kTj.setHint(R.string.live_write_input_content_update);
        }
        this.kTj.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.kTs = false;
                    WriteActivity.this.kSN = false;
                    WriteActivity.this.cVK();
                    if (WriteActivity.this.dwG != null) {
                        WriteActivity.this.dwG.aMQ();
                    }
                }
            }
        });
        this.kTj.requestFocus();
        this.kTj.addTextChangedListener(TM());
        this.kTn.requestFocus();
        this.kTn.addTextChangedListener(TM());
        this.kTn.setOnClickListener(this.kSM);
        this.kTj.setOnClickListener(this.kSM);
        this.kTi = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.kTh);
        this.kTi.En(6);
        this.kTh.setAdapter((ListAdapter) this.kTi);
        View findViewById = this.kTk.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void cVv() {
                WriteActivity.this.cWz();
            }
        });
        cWn();
    }

    private void cWn() {
        if (this.jWK.getType() == 0) {
            if (this.jWK.getTitle() != null) {
                this.kTn.setText(this.jWK.getTitle());
                this.kTn.setSelection(this.jWK.getTitle().length());
                return;
            }
            return;
        }
        if (this.jWK.getType() == 1 || this.jWK.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.kSD) {
            cWx();
        }
        if (this.dwG.aOv()) {
            this.dwG.aMQ();
        }
        Et(0);
    }

    private void Et(int i) {
        if (this.writeImagesInfo != null && this.jWK != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.jWK.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.jWK.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.gNY);
            albumActivityConfig.setProfessionZone(this.jWK.getProZone());
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void cWo() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.dwG.aI(arrayList);
        com.baidu.tbadk.editortools.l mp = this.dwG.mp(5);
        if (mp != null) {
            mp.dxq = 2;
        }
        this.dwG.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.dwG.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void cVL() {
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
            this.dwG.b(dVar);
        }
        Boolean cWu = cWu();
        if (!this.kSV && cWu != null && cWu.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.cMi() && r.d(this.jWK.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar5 = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar5.dxq = 3;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dwG.b(lVar5);
            }
        }
        this.dwG.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 4));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask2 != null && (lVar4 = (com.baidu.tbadk.editortools.l) runTask2.getData()) != null) {
            lVar4.dxq = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dwG.b(lVar4);
            }
        }
        this.dwG.b(new com.baidu.tbadk.editortools.k(getActivity(), 6));
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask3 != null && (lVar3 = (com.baidu.tbadk.editortools.l) runTask3.getData()) != null) {
            lVar3.dxq = 7;
            this.dwG.b(lVar3);
        }
        this.dwG.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 8));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask4 != null && (lVar2 = (com.baidu.tbadk.editortools.l) runTask4.getData()) != null) {
            lVar2.dxs = true;
            lVar2.dxq = 9;
            lVar2.dxm = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dwG.b(lVar2);
            }
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask5 != null && (lVar = (com.baidu.tbadk.editortools.l) runTask5.getData()) != null) {
            lVar.dxs = true;
            lVar.dxq = 10;
            lVar.dxm = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dwG.b(lVar);
            }
        }
        if (this.kSr == null) {
            if (this.kSH == null) {
                this.kSH = new com.baidu.tieba.write.editor.b(getActivity(), this.gNY);
                this.kSH.bz(this.jWK.getForumId(), this.privateThread);
                this.kSH.tO(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.kSH.cUM();
                this.kSH.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                cWl();
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.mList)) {
                this.kSH.cUM();
            }
            this.dwG.b(this.kSH);
        }
        this.dwG.aI(arrayList);
        com.baidu.tbadk.editortools.l mp = this.dwG.mp(5);
        if (mp != null) {
            mp.dxq = 1;
        }
    }

    private void cVM() {
        if (this.kSJ != null) {
            this.kSJ.hideTip();
        }
    }

    private void cVN() {
        if (this.kSJ == null) {
            this.kSJ = new e(getPageContext());
        }
        this.kSJ.c(this.dwG);
    }

    private void bZP() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.cVZ()) {
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
                            if (qVar.aJw() == EmotionGroupType.BIG_EMOTION || qVar.aJw() == EmotionGroupType.USER_COLLECT) {
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
                                    imageFileInfo.setFilePath(qVar.getName());
                                    imageFileInfo.width = qVar.getWidth();
                                    imageFileInfo.height = qVar.getHeight();
                                    WriteActivity.this.writeImagesInfo.addChooseFile(imageFileInfo);
                                    WriteActivity.this.writeImagesInfo.updateQuality();
                                    WriteActivity.this.tV(true);
                                    WriteActivity.this.cIb();
                                }
                            } else if (WriteActivity.this.cVZ()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(qVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.cWc();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.cnq();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.cWB();
                        WriteActivity.this.cIb();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.Eu(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new an("c12612").X("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.kSr == null) {
                            WriteActivity.this.aOY();
                            return;
                        }
                        switch (WriteActivity.this.dyr) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.aOV();
                                    return;
                                } else {
                                    ab.reuqestLocation(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.aOU();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.dyl != null) {
                            WriteActivity.this.dyl.sQ(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.ihm = null;
                        } else {
                            WriteActivity.this.ihm = (String) aVar.data;
                        }
                        WriteActivity.this.tU(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        an anVar = new an("c10645");
                        if (WriteActivity.this.jWK != null) {
                            str = WriteActivity.this.jWK.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.cy("fid", str);
                        TiebaStatic.log(anVar);
                        if (WriteActivity.this.jWK == null || (videoInfo = WriteActivity.this.jWK.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.dwG.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.dwG.aOv()) {
                                        WriteActivity.this.dwG.aMQ();
                                        WriteActivity.this.dwG.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.dwG.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                        WriteActivity.this.dwG.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.dwG.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.dwG.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.jWK.setVideoInfo(null);
                        WriteActivity.this.cIb();
                        if (WriteActivity.this.jXg != null) {
                            WriteActivity.this.jXg.requestFocus();
                        }
                        WriteActivity.this.dwG.aMQ();
                        WriteActivity.this.dwG.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.jXg);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new an("c12612").X("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.dwG.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.kSi = true;
                        WriteActivity.this.tS(true);
                        if (!WriteActivity.this.cWb().isFocused() || WriteActivity.this.kSm.getVisibility() != 0) {
                            WriteActivity.this.kSh = "from_content";
                        } else {
                            WriteActivity.this.kSh = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        if (WriteActivity.this.kSm.getVisibility() == 0) {
                            if (WriteActivity.this.kSm.hasFocus()) {
                                WriteActivity.this.jXg.requestFocus();
                                WriteActivity.this.jXg.setSelection(WriteActivity.this.jXg.getText().toString().length());
                            }
                            WriteActivity.this.kSm.setVisibility(8);
                            WriteActivity.this.dwG.mm(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.kSm.setVisibility(0);
                            WriteActivity.this.kSm.requestFocus();
                            WriteActivity.this.dwG.mm(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.cIb();
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
        this.dwG.setActionListener(16, bVar);
        this.dwG.setActionListener(14, bVar);
        this.dwG.setActionListener(24, bVar);
        this.dwG.setActionListener(3, bVar);
        this.dwG.setActionListener(10, bVar);
        this.dwG.setActionListener(11, bVar);
        this.dwG.setActionListener(12, bVar);
        this.dwG.setActionListener(13, bVar);
        this.dwG.setActionListener(15, bVar);
        this.dwG.setActionListener(18, bVar);
        this.dwG.setActionListener(20, bVar);
        this.dwG.setActionListener(25, bVar);
        this.dwG.setActionListener(27, bVar);
        this.dwG.setActionListener(29, bVar);
        this.dwG.setActionListener(43, bVar);
        this.dwG.setActionListener(56, bVar);
        this.dwG.setActionListener(48, bVar);
        this.dwG.setActionListener(46, bVar);
        this.dwG.setActionListener(49, bVar);
        this.dwG.setActionListener(47, bVar);
        this.dwG.setActionListener(55, bVar);
        this.dwG.setActionListener(58, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eu(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOY() {
        if (this.dyl.brl()) {
            if (this.dyl.cLL()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.cLG().getLocationData().cLE());
                return;
            }
            a(1, true, (String) null);
            this.dyl.cLJ();
            return;
        }
        a(0, true, (String) null);
    }

    protected void cHS() {
        if (this.dym != null) {
            this.dym.cancelLoadData();
        }
        if (this.kSn != null) {
            this.kSn.cancelLoadData();
        }
        if (this.dyl != null) {
            this.dyl.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cVM();
        TiebaPrepareImageService.StopService();
        cHS();
        cWt();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.kTg != null) {
            this.kTg.destroy();
        }
        if (this.kTF != null) {
            this.kTF.zz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVO() {
        if (this.jWK != null && this.jWK.getType() == 2 && this.kTc) {
            finish();
        } else if (this.jWK == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.jWK.setTitle(cWb().getText().toString());
            this.jWK.setContent(cWa().getText().toString());
            int type = this.jWK.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    v.c(this.jWK.getForumId(), this.jWK);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    v.c("24591571", this.jWK);
                }
            } else if (type == 1) {
                v.d(this.jWK.getThreadId(), this.jWK);
            } else if (type == 4) {
                v.c(this.jWK.getForumId() + "photolive", this.jWK);
            } else if (type == 5) {
                v.d(this.jWK.getThreadId() + "updatephotolive", this.jWK);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.jXj != null && this.jXj.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.jXj, getPageContext().getPageActivity());
                return true;
            } else if (this.dwG.aOv()) {
                this.dwG.aMQ();
                return true;
            } else {
                cHS();
                cVO();
                return true;
            }
        }
        if (i == 67 && (text = cWa().getText()) != null) {
            int selectionStart = cWa().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cWa().onKeyDown(67, this.gav);
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
        getLayoutMode().onModeChanged(this.hrZ);
        getLayoutMode().onModeChanged(this.kTw);
        am.setBackgroundColor(this.hrZ, R.color.cp_bg_line_e);
        if (this.kTu != null && (i == 1 || i == 4)) {
            this.kTu.setBorderColor(am.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.jXh, R.color.cp_link_tip_a, 1);
        cVK();
        am.setBackgroundColor(this.jXd, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.kTl, R.color.cp_bg_line_c);
        am.setBackgroundColor(cWb(), R.color.cp_bg_line_e);
        am.setImageResource(this.iJw, R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.ihm)) {
            am.setBackgroundColor(cWa(), R.color.cp_bg_line_e);
        }
        cIb();
        this.dwG.onChangeSkinType(i);
        if (this.kSB != null) {
            this.kSB.aHN();
        }
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.kTg.kUb.notifyDataSetChanged();
        cVP();
        cVQ();
        tU(false);
        if (this.kSI != null) {
            this.kSI.c(cWb(), cWa());
        }
        this.kQr.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVP() {
        if (this.jXc.hasFocus()) {
            this.jXc.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.jXc.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.jXg.hasFocus()) {
            this.jXg.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.jXg.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVQ() {
        if (this.jXc != null && this.jXc.getText() != null && this.jXc.getText().toString() != null && this.jXc.getPaint() != null) {
            if (this.jXc.getText().toString().length() == 0) {
                this.jXc.getPaint().setFakeBoldText(false);
            } else if (this.jXc.getText().toString().length() > 0) {
                this.jXc.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.dFT = new com.baidu.tbadk.core.view.a(getPageContext());
        this.kSD = this.jWK.getType() == 4 || 5 == this.jWK.getType();
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
        this.kTa = (TextView) findViewById(R.id.btn_image_problem);
        cVS();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jXh.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.jXh.setLayoutParams(layoutParams);
        this.jXh.setOnFocusChangeListener(this.eVW);
        this.kSC = (ScrollView) findViewById(R.id.write_scrollview);
        this.kSC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.jXg != null) {
                        l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.jXg);
                    }
                    if (WriteActivity.this.dwG != null) {
                        WriteActivity.this.dwG.aMQ();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.kSY = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.kSZ = findViewById(R.id.feedback_divider);
        this.hrZ = (RelativeLayout) findViewById(R.id.parent);
        this.kSl = (LinearLayout) findViewById(R.id.tool_view);
        this.kSl.setContentDescription(IStringUtil.TOP_PATH);
        this.kSm = (LinearLayout) findViewById(R.id.title_view);
        this.jXd = findViewById(R.id.interval_view);
        this.kTB = findViewById(R.id.hot_topic_fourm_view);
        this.kTC = findViewById(R.id.hot_topic_divider);
        this.kSF = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.kTD = (TextView) findViewById(R.id.change_one_tv);
        cIa();
        if (this.kSD) {
            this.kSC.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            cWm();
        } else {
            this.kTg = new g(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.kTg.tM(false);
            } else {
                g gVar = this.kTg;
                if (this.jWK.getType() != 0 && this.jWK.getType() != 9) {
                    z = false;
                }
                gVar.tM(z);
            }
        }
        cIc();
        if (this.kSV || this.kSk) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().daO) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.jXf = (LinearLayout) findViewById(R.id.post_content_container);
        this.jXf.setDrawingCacheEnabled(false);
        this.jXf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.dwG.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.jXg.requestFocus();
            }
        });
        this.iJt = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.iJu = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.iJw = (ImageView) findViewById(R.id.iv_delete_voice);
        this.iJw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cnq();
            }
        });
        this.mBack.setOnFocusChangeListener(this.eVW);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cHS();
                WriteActivity.this.cVO();
            }
        });
        this.kTa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        cVV();
        o(cWu());
        cVX();
        cVR();
        cWr();
        cWs();
        cVK();
        cVW();
        cHZ();
        cWd();
        if (this.jWK.getType() == 4 && this.jXl != null && this.kSo != null) {
            this.jXl.setVisibility(8);
            this.kSo.setVisibility(8);
        }
        cIb();
        cWp();
        cVe();
    }

    private void cVe() {
        this.kQr = new com.baidu.tieba.write.b.c(getPageContext().getPageActivity(), this.mName, this.jWK.getProZone(), isUseStyleImmersiveSticky() ? StatusBarUtil.getStatusBarOffsetPx(getPageContext().getPageActivity()) : 0);
        this.kQr.a(new c.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // com.baidu.tieba.write.b.c.a
            public void Ei(int i) {
                WriteActivity.this.jWK.setProZone(i);
            }
        });
        this.kQr.byv();
    }

    private void cVR() {
        String str;
        String str2;
        if (this.jWK != null) {
            switch (this.jWK.getType()) {
                case 0:
                case 9:
                    if (this.kSV || this.kSk) {
                        if (this.kSW) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.gNY != null && this.gNY.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                    } else if (this.gNY != null && this.gNY.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.jWK.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.jWK.getForumName() + getResources().getString(R.string.bar));
                        this.jXc.setVisibility(8);
                        String str3 = this.gmv + HanziToPinyin.Token.SEPARATOR + this.gmt;
                        if (!StringUtils.isNull(str3)) {
                            this.jXg.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.jXc.setVisibility(0);
                    this.jXg.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.jXg.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.jXc.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.jXg.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.jWK.getFloorNum() + 1)));
                    this.kTl.setVisibility(8);
                    return;
                case 7:
                    this.jXc.setVisibility(0);
                    this.jXg.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void cVS() {
        if (this.jWK.getType() == 7) {
            this.jXh = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.jXh = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void cVT() {
        if (this.jWK != null && this.jWK.getType() == 0 && this.jWK.getType() == 9 && !this.kSV && !this.kSk && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = aq.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && cWb() != null) {
                cWb().setText(cutStringWithSuffix);
                cWb().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.iJt.setVisibility(0);
            this.iJu.setVoiceModel(voiceModel);
            this.iJu.cMh();
            cIb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnq() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.iJt.setVisibility(8);
        this.iJu.bOp();
        this.iJu.setVoiceModel(null);
        com.baidu.tbadk.editortools.l mp = this.dwG.mp(6);
        if (mp != null && mp.dwA != null) {
            mp.dwA.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cIb();
    }

    private void cVU() {
        this.kSw = null;
        this.kSy = -1;
        this.kSA = -1;
        y sY = x.bFD().sY(1);
        if (sY != null) {
            this.kSw = sY.grV;
            this.kSy = getIntent().getIntExtra("category_id", -1);
            if (this.kSw != null && !this.kSw.isEmpty() && this.kSy >= 0) {
                this.kSx = new w();
                this.kSx.grR = 0;
                this.kSx.name = getPageContext().getResources().getString(R.string.category_auto);
                this.kSA = this.kSx.grR;
                this.kSz = this.kSx.name;
                for (w wVar : this.kSw) {
                    if (wVar.grR == this.kSy) {
                        this.kSA = wVar.grR;
                        this.kSz = wVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cVV() {
        if (this.kSw != null && !this.kSw.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.kSB = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.kSB.setText(this.kSz);
            this.kSB.setCategoryContainerData(this.kSw, this.kSx, this.kSA);
            this.kSB.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, as asVar) {
                    if (asVar != null) {
                        WriteActivity.this.kSB.setText(asVar.name);
                        WriteActivity.this.jWK.setCategoryTo(asVar.grR);
                        WriteActivity.this.kSA = asVar.grR;
                        WriteActivity.this.kSB.cVx();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.kSB.cVw();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cWb());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cWa());
                }
            });
        }
    }

    private void cWp() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.kSQ = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.kSQ.setTitle(R.string.no_disturb_start_time);
        this.kSQ.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.kSQ);
        this.kSQ.setButton(-2, getPageContext().getString(R.string.cancel), this.kSQ);
        return this.kSQ;
    }

    private void cVW() {
        this.kSs = (RelativeLayout) findViewById(R.id.addition_container);
        this.kSt = (TextView) findViewById(R.id.addition_create_time);
        this.kSu = (TextView) findViewById(R.id.addition_last_time);
        this.kSv = (TextView) findViewById(R.id.addition_last_content);
        if (this.kSr != null) {
            this.kSs.setVisibility(0);
            this.kSt.setText(getPageContext().getString(R.string.write_addition_create) + aq.getFormatTime(this.kSr.getCreateTime() * 1000));
            if (this.kSr.getAlreadyCount() == 0) {
                this.kSu.setVisibility(8);
            } else {
                this.kSu.setText(getPageContext().getString(R.string.write_addition_last) + aq.getFormatTime(this.kSr.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.kSr.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.kSv.setText(lastAdditionContent);
            } else {
                this.kSv.setVisibility(8);
            }
            cWa().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.kSr.getAlreadyCount()), Integer.valueOf(this.kSr.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.kSs.setVisibility(8);
    }

    private void cHZ() {
        this.jXl = findViewById(R.id.post_prefix_layout);
        if (this.kTF == null) {
            this.kTF = new com.baidu.tieba.c.d(getPageContext(), this.jXl);
            this.kTF.ck(R.drawable.bg_tip_blue_up_left);
            this.kTF.cj(16);
            this.kTF.kw(true);
            this.kTF.setUseDirectOffset(true);
            this.kTF.rz(l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.jXi = (TextView) findViewById(R.id.post_prefix);
        this.kSo = findViewById(R.id.prefix_divider);
        this.jXk = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.jXl.setVisibility(0);
            this.kTF.d(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.jWL = 0;
            this.jXl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").cy("fid", WriteActivity.this.jWK.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.jXi.setVisibility(0);
                    WriteActivity.this.jXl.setSelected(true);
                    am.setImageResource(WriteActivity.this.jXk, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.jXj, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.dwG.aMQ();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.jXc);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.jXg);
                }
            });
            this.jXi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").cy("fid", WriteActivity.this.jWK.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.jXi.setSelected(true);
                    am.setImageResource(WriteActivity.this.jXk, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.jXj, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.dwG.aMQ();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cWb());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cWa());
                }
            });
            this.jXj = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.jXj.a(this);
            this.jXj.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.jXj.setOutsideTouchable(true);
            this.jXj.setFocusable(true);
            this.jXj.setOnDismissListener(this);
            this.jXj.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            am.getColor(R.color.cp_cont_c);
            am.setBackgroundResource(this.jXi, R.color.cp_bg_line_d);
            am.setImageResource(this.jXk, R.drawable.icon_arrow_gray_down);
            this.jXi.setTextColor(color);
            this.kSp.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.kSp.add(writePrefixItemLayout);
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
                this.jXj.addView(writePrefixItemLayout);
            }
            this.jXj.setCurrentIndex(0);
            this.jXi.setText(prefixs.get(0));
            Es(0);
            return;
        }
        this.jXl.setVisibility(8);
    }

    private void cWq() {
        if (this.kSV && this.jWK != null) {
            this.kSY.setVisibility(0);
            this.kSZ.setVisibility(0);
            this.kSn = new FeedBackModel(getPageContext());
            this.kSn.Lc(this.jWK.getForumName());
            this.kSn.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.24
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.kSY.setVisibility(8);
                        WriteActivity.this.kSZ.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.kSY.setVisibility(8);
                        WriteActivity.this.kSZ.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.kSY.a(feedBackModel.cVz(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void cVX() {
        this.jXh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (WriteActivity.this.kSI.a(WriteActivity.this.jXc, WriteActivity.this.jXg)) {
                        WriteActivity.this.showToast(WriteActivity.this.kSI.cUg());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cWb());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cWa());
                    WriteActivity.this.dwG.aMQ();
                    if (WriteActivity.this.jWK.getType() != 7) {
                        if (WriteActivity.this.kSV) {
                            WriteActivity.this.cWg();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            an anVar = new an("c12102");
                            anVar.X("obj_type", StringUtils.isNull(WriteActivity.this.jWK.getForumName()) ? 1 : 2);
                            TiebaStatic.log(anVar);
                            WriteActivity.this.cWh();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.cWg();
                    }
                    TiebaStatic.log(new an("c12262").cy("obj_locate", WriteActivity.this.gNY));
                }
            }
        });
    }

    protected void cWr() {
        this.kTb = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.kTb.sS(getPageContext().getString(R.string.is_save_draft)).fG(false).a(getPageContext().getString(R.string.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.jWK.setTitle(WriteActivity.this.cWb().getText().toString());
                WriteActivity.this.jWK.setContent(WriteActivity.this.cWa().getText().toString());
                int type = WriteActivity.this.jWK.getType();
                if (type == 0 || type == 9) {
                    v.c(WriteActivity.this.jWK.getForumId(), WriteActivity.this.jWK);
                } else if (type == 1) {
                    v.d(WriteActivity.this.jWK.getThreadId(), WriteActivity.this.jWK);
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
                int type = WriteActivity.this.jWK.getType();
                if (type == 0 || type == 9) {
                    v.c(WriteActivity.this.jWK.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    v.d(WriteActivity.this.jWK.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.kTb.b(getPageContext());
    }

    protected void cIa() {
        this.kSX = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.kSX.setIsRound(true);
        this.kSX.setDrawBorder(false);
        this.kSX.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String tn = o.tn(currentPortrait);
            this.kSX.setUrl(tn);
            this.kSX.startLoad(tn, 12, false);
        }
        if (this.jWK.isUserFeedback()) {
            this.kSX.setVisibility(0);
        }
        this.jXc = (EditText) findViewById(R.id.post_title);
        this.jXc.setOnClickListener(this.kSM);
        this.jXc.setOnFocusChangeListener(this.eVW);
        if (this.jWK.getType() == 0 || this.jWK.getType() == 9 || this.jWK.getType() == 7) {
            if (this.jWK.getTitle() != null) {
                this.jXc.setText(this.jWK.getTitle());
                this.jXc.setSelection(this.jWK.getTitle().length());
            } else if (this.kSW) {
                this.jXc.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.jWK.getType() == 1 || this.jWK.getType() != 2) {
        }
        this.jXc.addTextChangedListener(this.kSO);
        if (!this.jWK.getHaveDraft()) {
            cVT();
            this.kTA = true;
        }
        if (this.jWK.isUserFeedback()) {
            this.jXc.setHint(getResources().getString(R.string.feedback_title_hint));
        } else {
            this.jXc.setHint(getResources().getString(R.string.post_title_hint));
        }
    }

    private TextWatcher TM() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            private int kTJ;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.cIb();
                if (WriteActivity.this.kSD) {
                    this.kTJ = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.kTJ);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.kSD || !WriteActivity.this.kTs) {
                    if (WriteActivity.this.kSD) {
                        if (this.mEditText != WriteActivity.this.kTj || this.mTextView != WriteActivity.this.kTp) {
                            this.mEditText = WriteActivity.this.kTj;
                            this.mTextView = WriteActivity.this.kTp;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.kTn || this.mTextView != WriteActivity.this.kTo) {
                    this.mEditText = WriteActivity.this.kTn;
                    this.mTextView = WriteActivity.this.kTo;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.kSD && this.kTs) {
            if (this.kTq != null) {
                this.kTn.removeTextChangedListener(this.kTq);
            }
            this.kTq = textWatcher;
        } else if (this.kSD) {
            if (this.kTr != null) {
                this.kTj.removeTextChangedListener(this.kTr);
            }
            this.kTr = textWatcher;
        }
        return textWatcher;
    }

    private long j(EditText editText) {
        if (editText == this.kTj) {
            return 233L;
        }
        if (editText != this.kTn) {
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

    protected void cIc() {
        this.jXg = (EditText) findViewById(R.id.post_content);
        this.jXg.setDrawingCacheEnabled(false);
        this.jXg.setOnClickListener(this.kSM);
        if (this.jWK.getContent() != null && this.jWK.getContent().length() > 0) {
            SpannableString aB = TbFaceManager.aPP().aB(getPageContext().getPageActivity(), this.jWK.getContent());
            this.jXg.setText(aB);
            this.jXg.setSelection(aB.length());
        } else if (this.jWK.getType() == 2) {
            if (this.kTc) {
                if (this.kTd != null && this.kTd.length() > 0) {
                    this.jXg.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.kTd}));
                    this.jXg.setSelection(this.jXg.getText().length());
                }
            } else if (this.jWK.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.jWK.getFloorNum()));
                this.jXg.setText(format);
                this.jXg.setSelection(format.length());
            }
        }
        this.jXg.setOnFocusChangeListener(this.eVW);
        this.jXg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.dwG.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.jXg.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.jXg.addTextChangedListener(this.kSP);
        if (this.jWK.getType() == 0) {
            this.kTE = true;
        } else {
            tU(true);
            this.kTE = false;
        }
        if (this.jWK.isUserFeedback()) {
            this.jXg.setHint(R.string.write_input_content);
        } else {
            this.jXg.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void tU(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.kSD) {
            cWa().setPadding(0, 0, 0, 0);
            cWa().setBackgroundDrawable(null);
            am.setBackgroundColor(cWa(), R.color.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.ihm) && this.kSr == null) {
                com.baidu.adp.lib.e.c.gr().a(this.ihm, 19, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.30
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
                            WriteActivity.this.cWa().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.cWa(), true, WriteActivity.this.iPv);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cVZ() {
        int i = 5000;
        if (this.kSr != null) {
            i = 1000;
        }
        return cWa().getText() != null && cWa().getText().length() >= i;
    }

    private void vh(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.kSh)) {
                this.kSh = "";
                cWa().requestFocus();
                if (cWa().getText() != null && cWa().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cWa().getSelectionStart();
                    editable = cWa().getText();
                }
            } else if ("from_title".equals(this.kSh)) {
                this.kSh = "";
                cWb().requestFocus();
                if (cWb().getText() != null && cWb().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cWb().getSelectionStart();
                    editable = cWb().getText();
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
            if (this.jWK != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.jWK.getForumId(), 0L), this.jWK.getFirstDir(), this.jWK.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(q qVar) {
        if (((ImageSpan[]) cWa().getText().getSpans(0, cWa().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.kSq == null) {
                this.kSq = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            this.kSq.show();
            return;
        }
        String name = qVar.getName();
        final EmotionGroupType aJw = qVar.aJw();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.e.c.gr().a(name, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.32
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass32) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.cWa().getSelectionStart(), aVar, aJw);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cWa() != null && cWa().getText() != null) {
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
                int selectionStart = cWa().getSelectionStart() - 1;
                if (cWa().getText().length() > 1 && selectionStart >= 0 && cWa().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cWa().getText().insert(cWa().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cWa().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cWa().getText().insert(cWa().getSelectionStart(), spannableString2);
            }
            Editable text = cWa().getText();
            if (text != null) {
                this.kSG.clear();
                this.kSG.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.kSG);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cWa().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cWa().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cWa().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cWa() {
        return this.kSD ? this.kTj : this.jXg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cWb() {
        return this.kSD ? this.kTn : this.jXc;
    }

    protected void cWc() {
        Editable text;
        if (cWa() != null && (text = cWa().getText()) != null) {
            int selectionStart = cWa().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cWa().onKeyDown(67, this.gav);
            }
            cWa().onKeyDown(67, this.gav);
            int selectionStart2 = cWa().getSelectionStart();
            if (text != null) {
                this.kSG.clear();
                this.kSG.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.kSG);
                cWa().setSelection(selectionStart2);
            }
        }
    }

    private void o(Boolean bool) {
        String str = null;
        if (this.jWK != null) {
            str = this.jWK.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.kSV = true;
        }
    }

    private void cWs() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void cWt() {
        try {
            if (this.kTb != null) {
                this.kTb.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.dFT.setCancelListener(null);
        this.dFT.setTipString(R.string.sending);
        this.dFT.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.dFT.setDialogVisiable(false);
    }

    private Boolean cWu() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.dyq = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void cIb() {
        if (this.jWK != null) {
            String str = "";
            String str2 = "";
            if (cWb() != null) {
                str = cWb().getText().toString();
            }
            if (cWa() != null) {
                str2 = cWa().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.jWK.getType() == 0 || this.jWK.getType() == 9 || this.jWK.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.jWL == com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.jWK.setIsNoTitle(true);
                        } else if (this.kSm.getVisibility() == 0) {
                            this.jWK.setIsNoTitle(false);
                            tT(true);
                            return;
                        }
                    } else if (this.kSm.getVisibility() == 0) {
                        this.jWK.setIsNoTitle(false);
                        tT(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.jWK.setIsNoTitle(true);
                } else if (this.kSm.getVisibility() == 0) {
                    this.jWK.setIsNoTitle(false);
                    tT(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.kSD) {
                    tT(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    tT(true);
                }
            }
            if (this.jWK.getType() == 4) {
                tT(m(this.kTj) && l(this.kTn));
            } else if (this.jWK.getType() == 5) {
                tT(m(this.kTj));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                tT(true);
            } else if (this.jWK.getVideoInfo() != null) {
                tT(true);
            } else {
                tT(false);
            }
        }
    }

    public void tT(boolean z) {
        if (z) {
            am.setNavbarTitleColor(this.jXh, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.jXh.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.jXh, R.color.cp_cont_d, 1);
        this.jXh.setEnabled(false);
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
        this.dym = new NewWriteModel(this);
        this.dym.b(this.dyA);
        registerListener(this.kTG);
        this.gfm = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.cHS();
            }
        };
        this.jWK = new WriteData();
        if (bundle != null) {
            this.jWK.setType(bundle.getInt("type", 0));
            this.jWK.setForumId(bundle.getString("forum_id"));
            this.jWK.setForumName(bundle.getString("forum_name"));
            this.jWK.setFirstDir(bundle.getString("forum_first_dir"));
            this.jWK.setSecondDir(bundle.getString("forum_second_dir"));
            this.jWK.setThreadId(bundle.getString("thread_id"));
            this.jWK.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.jWK.setFloorNum(bundle.getInt("floor_num", 0));
            this.kSV = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.kSW = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.kTc = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.kTd = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.dyk = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.kSr = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.jWK.setIsAddition(this.kSr != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.kTe = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.jWK.setTitle(bundle.getString("write_title"));
            this.jWK.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.jWK.setTopicId(this.mTopicId);
            this.gNY = bundle.getString("KEY_CALL_FROM");
            this.aBX = bundle.getInt("album_thread");
            stringExtra = string;
        } else {
            Intent intent = getIntent();
            this.jWK.setType(intent.getIntExtra("type", 0));
            this.jWK.setForumId(intent.getStringExtra("forum_id"));
            this.jWK.setForumName(intent.getStringExtra("forum_name"));
            this.jWK.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.jWK.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.jWK.setThreadId(intent.getStringExtra("thread_id"));
            this.jWK.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.jWK.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.kSV = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.kSW = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.kTc = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.kTd = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.kSr = (AdditionData) intent.getSerializableExtra("addition_data");
            this.jWK.setIsAddition(this.kSr != null);
            this.jWK.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.kTe = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.gmu = intent.getStringExtra("more_forum_img");
            this.gmv = intent.getStringExtra("more_forum_title");
            this.gmt = intent.getStringExtra("more_forum_url");
            this.jWK.setTitle(intent.getStringExtra("write_title"));
            this.jWK.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.jWK.setTopicId(this.mTopicId);
            this.gNY = intent.getStringExtra("KEY_CALL_FROM");
            this.aBX = intent.getIntExtra("album_thread", 0);
            stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
        }
        if (this.jWK.getType() == 9) {
            this.jWK.setEntranceType(1);
        } else if (this.jWK.getType() == 10) {
            this.jWK.setEntranceType(2);
            this.jWK.setType(9);
        } else if (this.jWK.getType() == 0) {
            this.jWK.setEntranceType(3);
        }
        this.jWK.setIsUserFeedback(this.kSV);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (stringExtra != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.jWK.getType() == 4 ? 6 : 9);
        this.jWK.setWriteImagesInfo(this.writeImagesInfo);
        if (this.jWK.getType() == 0 || this.jWK.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                v.c(this.jWK.getForumId(), this);
            }
        } else if (this.jWK.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                v.c("24591571", this);
            }
        } else if (this.jWK.getType() == 1) {
            v.a(this.jWK.getThreadId(), this);
        } else if (this.jWK.getType() == 4) {
            v.c(this.jWK.getForumId() + "photolive", this);
        } else if (this.jWK.getType() == 5) {
            v.a(this.jWK.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.ihm = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.jWK != null && this.jWK.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.jWK.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.kSk = true;
        }
        cVU();
        try {
            this.kTt = cWD();
        } catch (Throwable th) {
            this.kTt = null;
        }
    }

    private void cWd() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.jXc.setText(com.baidu.tbadk.plugins.b.vI(com.baidu.tbadk.plugins.b.vJ(hotTopicBussinessData.mTopicName)));
            this.jXc.setMovementMethod(com.baidu.tieba.view.c.cTu());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString vI = com.baidu.tbadk.plugins.b.vI(com.baidu.tbadk.plugins.b.vJ(hotTopicBussinessData.mTopicName));
            if (vI != null) {
                this.jXc.setText(vI);
            }
            this.kSF.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.v.a
    public void a(WriteData writeData) {
        String str;
        String vJ;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            if (writeData != null) {
                if (this.jWK != null) {
                    this.jWK.setHaveDraft(true);
                    if (com.baidu.adp.lib.util.k.isEmpty(cWb().getText().toString()) || this.kTA || ((this.kSV || this.kSk) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                        if (com.baidu.adp.lib.util.k.isEmpty(this.jWK.getTitle())) {
                            this.jWK.setTitle(writeData.getTitle());
                        }
                        if (!com.baidu.tbadk.core.util.v.isEmpty(this.mList)) {
                            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.getItem(this.mList, 0);
                            if (hotTopicBussinessData == null) {
                                str = null;
                            } else {
                                str = hotTopicBussinessData.mTopicName;
                            }
                            if (StringUtils.isNull(str)) {
                                vJ = this.jWK.getTitle();
                            } else {
                                vJ = com.baidu.tbadk.plugins.b.vJ(str);
                            }
                            SpannableString vI = com.baidu.tbadk.plugins.b.vI(vJ);
                            if (vI != null) {
                                cWb().setText(vI);
                                cWb().setSelection(vI.length() > vJ.length() ? vJ.length() : vI.length());
                            }
                        } else {
                            SpannableString vI2 = com.baidu.tbadk.plugins.b.vI(this.jWK.getTitle());
                            if (vI2 != null) {
                                cWb().setText(vI2);
                                cWb().setSelection(this.jWK.getTitle().length() > vI2.length() ? vI2.length() : this.jWK.getTitle().length());
                            }
                        }
                    }
                    if (this.jWK != null && !this.jWK.getHaveDraft()) {
                        cVT();
                    }
                    if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.copy(writeData.getVideoInfo());
                        this.jWK.setVideoInfo(videoInfo);
                        this.dwG.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                    }
                    if ((com.baidu.adp.lib.util.k.isEmpty(cWa().getText().toString()) || this.kSV || this.kSk) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                        this.jWK.setContent(writeData.getContent());
                        SpannableString a2 = TbFaceManager.aPP().a(getPageContext().getPageActivity(), this.jWK.getContent(), this.kSK);
                        cWa().setText(a2);
                        cWa().setSelection(a2.length());
                        if (this.kSD) {
                            a(this.kTp, this.kTj);
                        }
                    }
                    if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                        this.writeImagesInfo = writeData.getWriteImagesInfo();
                        this.jWK.setWriteImagesInfo(this.writeImagesInfo);
                        cWB();
                        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                            cWj();
                        }
                        tV(false);
                    }
                    if (writeData.getType() == 4 || writeData.getType() == 5) {
                        cWv();
                    }
                    cIb();
                    int categoryTo = writeData.getCategoryTo();
                    if (categoryTo >= 0 && this.kSw != null) {
                        this.kSA = this.kSx.grR;
                        this.kSz = this.kSx.name;
                        int i = 0;
                        while (true) {
                            if (i == this.kSw.size()) {
                                break;
                            }
                            w wVar = this.kSw.get(i);
                            if (categoryTo != wVar.grR) {
                                i++;
                            } else {
                                this.kSA = categoryTo;
                                this.kSz = wVar.name;
                                this.jWK.setCategoryTo(this.kSA);
                                break;
                            }
                        }
                        if (this.kSB != null) {
                            this.kSB.setText(this.kSz);
                            this.kSB.setCategoryContainerData(this.kSw, this.kSx, this.kSA);
                        }
                    }
                    this.dwG.aMQ();
                    return;
                }
                return;
            }
            cWv();
            cVT();
        }
    }

    private void cWv() {
        if ((!this.kSD || this.kTi != null) && this.kTh != null) {
            this.kTi.b(this.writeImagesInfo);
            cWz();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.jWK.getType());
        bundle.putString("forum_id", this.jWK.getForumId());
        bundle.putString("forum_name", this.jWK.getForumName());
        bundle.putString("forum_first_dir", this.jWK.getFirstDir());
        bundle.putString("forum_second_dir", this.jWK.getSecondDir());
        bundle.putString("thread_id", this.jWK.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.jWK.getFloor());
        bundle.putInt("floor_num", this.jWK.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.kTc);
        if (this.kSV) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.dyk);
        if (this.kSr != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.kSr));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.kTe);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.gNY);
        bundle.putInt("album_thread", this.aBX);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cWa().getEditableText().toString();
        if (obj != null) {
            cWa().setText(TbFaceManager.aPP().a(getPageContext().getPageActivity(), obj, this.kSK));
            cWa().setSelection(cWa().getText().length());
        }
    }

    private String cWe() {
        return (cWa() == null || cWa().getText() == null) ? "" : cWa().getText().toString();
    }

    private String cWf() {
        if (this.jWK == null || cWb() == null || cWb().getVisibility() != 0 || cWb().getText() == null) {
            return "";
        }
        String obj = cWb().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) > 0 && this.jWL != com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) - 1 && this.jWK.getType() != 4 && this.jXi != null && this.jXi.getText() != null) {
            this.jWK.setPostPrefix(this.jXi.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.jWK.getTitle();
        }
        return obj;
    }

    private void Ld(String str) {
        if (this.jWK != null && this.kSm != null) {
            if (this.kSm.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.jWK.setIsNoTitle(true);
                    this.jWK.setTitle("");
                    return;
                }
                this.jWK.setIsNoTitle(false);
                this.jWK.setTitle(str);
                return;
            }
            this.jWK.setIsNoTitle(true);
            this.jWK.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWg() {
        cHS();
        this.jWK.setContent(cWe());
        Ld(cWf());
        if (this.kSV || this.kSk) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.jWK.getTitle()) || !this.jWK.getTitle().startsWith(string)) {
                Ld(string + this.jWK.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.jWK.getContent()) || !this.jWK.getContent().startsWith(str)) {
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
                sb.append(this.jWK.getContent());
                this.jWK.setContent(sb.toString());
            }
        }
        if (this.kSy >= 0) {
            this.jWK.setCategoryFrom(this.kSy);
        }
        if (this.kSA >= 0) {
            this.jWK.setCategoryTo(this.kSA);
        }
        this.jWK.setWriteImagesInfo(this.writeImagesInfo);
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
            this.jWK.setTakePhotoNum(i);
        }
        this.jWK.setHasLocationData(this.dyl != null && this.dyl.brl());
        if (this.writeImagesInfo != null) {
            this.dym.sS(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.mList) && this.kSE != null && this.kSE.mIsGlobalBlock == 0) {
            this.jWK.setForumId(String.valueOf(this.kSE.mForumId));
            this.jWK.setForumName(this.kSE.mForumName);
        }
        this.dym.d(this.jWK);
        this.jWK.setContent(this.jWK.getContent().replaceAll("\u0000\n", ""));
        this.jWK.setContent(this.jWK.getContent().replaceAll("\u0000", ""));
        this.jWK.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.dym.cHU().setVoice(this.mVoiceModel.getId());
                this.dym.cHU().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.dym.cHU().setVoice(null);
                this.dym.cHU().setVoiceDuringTime(-1);
            }
        } else {
            this.dym.cHU().setVoice(null);
            this.dym.cHU().setVoiceDuringTime(-1);
        }
        if (!this.dym.cMm()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.gfm);
            this.dym.cMj();
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
            if (this.kSr != null) {
                i2 = this.kSr.getTotalCount();
                i = this.kSr.getAlreadyCount() + 1;
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
                if (this.jXc == getCurrentFocus()) {
                    cWa().clearFocus();
                    this.jXc.requestFocus();
                    if (this.dwG != null) {
                        this.dwG.aMQ();
                    }
                    ShowSoftKeyPadDelay(this.jXc);
                } else {
                    cWa().requestFocus();
                    if (this.dwG != null) {
                        this.dwG.aMQ();
                    }
                    ShowSoftKeyPadDelay(this.jXg);
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
                            cWa().getText().insert(cWa().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.jWK.getType() == 0 || this.jWK.getType() == 9) {
                    v.c(this.jWK.getForumId(), (WriteData) null);
                    if (postWriteCallBackData2 != null) {
                    }
                } else if (this.jWK.getType() == 1) {
                    v.d(this.jWK.getThreadId(), (WriteData) null);
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
                                cWA();
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
                        if (this.kTE) {
                            tU(true);
                            this.kTE = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.kSD) {
                        U(intent);
                        cIb();
                        return;
                    }
                    aC(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.jWK.setVideoInfo(videoInfo);
                        this.dwG.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                        this.dwG.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.dwG.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    cIb();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.kSi) {
                                sb2.append(com.baidu.tbadk.plugins.b.dFz);
                                this.kSi = false;
                            }
                            sb2.append(stringExtra);
                            vh(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.isEmpty(this.mList) && !com.baidu.tbadk.core.util.v.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                    this.kSE = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                    a(this.kSE);
                }
            }
        } else if (i2 == 0) {
            if (this.dwG != null && !this.dwG.aOv()) {
                this.jXg.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.dwG.aMQ();
            }
            switch (i) {
                case 12001:
                    aPb();
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    cWy();
                    if (this.kTE) {
                        tU(true);
                        this.kTE = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.jXc == getCurrentFocus()) {
                        cWa().clearFocus();
                        this.jXc.requestFocus();
                        if (this.dwG != null) {
                            this.dwG.aMQ();
                        }
                        ShowSoftKeyPadDelay(this.jXc);
                        return;
                    }
                    cWa().requestFocus();
                    if (this.dwG != null) {
                        this.dwG.aMQ();
                    }
                    ShowSoftKeyPadDelay(this.jXg);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.kSI.KK(postWriteCallBackData.getErrorString());
                        this.kSI.aU(postWriteCallBackData.getSensitiveWords());
                        this.kSI.b(this.jXc, this.jXg);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.dyk = String.valueOf(System.currentTimeMillis());
                    al.a(getPageContext(), this.dyk);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    cWy();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.kSh)) {
                        cWb().requestFocus();
                        return;
                    } else if ("from_content".equals(this.kSh)) {
                        cWa().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWh() {
        if ("1".equals(this.gNY)) {
            this.jWK.setCanNoForum(true);
            this.jWK.setTransmitForumData("[]");
        } else if ("2".equals(this.gNY)) {
            this.jWK.setCanNoForum(false);
        }
        cWi();
        this.jWK.setPrivacy(this.isPrivacy);
        cWw();
        this.jWK.setToDynamic(this.isToDynamic);
        this.jWK.setCallFrom(this.gNY);
        if (this.jWK.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cWg();
    }

    private void cWi() {
        if (this.dwG != null) {
            this.dwG.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void cWw() {
        if (this.dwG != null) {
            this.dwG.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void cWx() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void cWy() {
        if (this.kSD) {
            this.kTi.b(this.writeImagesInfo);
            cWz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWz() {
        this.kTi.notifyDataSetChanged();
        this.kTh.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.kTi.notifyDataSetChanged();
                WriteActivity.this.kTh.invalidateViews();
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
        cIb();
    }

    private void aB(Intent intent) {
        if (this.kSD) {
            aC(intent);
            cWy();
        } else {
            aF(intent);
        }
        cIb();
    }

    private void aC(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            cWy();
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

    private void cWA() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void aE(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.kTf.parseJson(stringExtra);
            this.kTf.updateQuality();
            if (this.kTf.getChosedFiles() != null && this.kTf.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.kTf.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.kTf.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cWb());
        HidenSoftKeyPad(this.mInputManager, cWa());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void aF(Intent intent) {
        c(intent, true);
    }

    private void T(Intent intent) {
        this.dyk = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.dyk;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.getEquipmentWidth(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.dyk, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            cWB();
            cWj();
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
                cWB();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    cWj();
                }
            }
            tV(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWB() {
        if (this.dwG.mp(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void aPb() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.dyk));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void cWC() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.gmu)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                com.baidu.tbadk.util.o oVar = new com.baidu.tbadk.util.o(this, this.gmu, new o.a() { // from class: com.baidu.tieba.write.write.WriteActivity.38
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
        String forumId = this.jWK == null ? "" : this.jWK.getForumId();
        if (this.kTg != null) {
            this.kTg.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.gol == null) {
            this.gol = VoiceManager.instance();
        }
        return this.gol;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bEk() {
        this.gol = getVoiceManager();
        this.gol.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bb(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.gps) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.jWK.getType() != 7) {
                if (this.kSr == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                B(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.dyr = i;
        if (this.dwG != null) {
            this.dwG.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void cWj() {
        if (!this.kSD) {
            if (this.dwG != null) {
                this.dwG.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.dwG.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.jWK == null ? "" : this.jWK.getForumId();
            if (this.kTg != null) {
                this.kTg.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gJ(boolean z) {
        if (this.dwG != null) {
            this.dwG.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Es(int i) {
        if (i < this.kSp.size()) {
            for (int i2 = 0; i2 < this.kSp.size(); i2++) {
                this.kSp.get(i2).tK(false);
            }
            this.kSp.get(i).tK(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void Cd(int i) {
        if (i == com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new an("c13014").X("obj_type", 1));
        } else {
            TiebaStatic.log(new an("c13014").X("obj_type", 2));
        }
        this.jWL = i;
        this.jXj.setCurrentIndex(i);
        Es(i);
        this.jXi.setText(this.mPrefixData.getPrefixs().get(i));
        cIb();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.jXj, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.jXl.setSelected(false);
        am.setImageResource(this.jXk, R.drawable.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.jXg);
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
        if (this.jWK != null) {
            if (this.jWK.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.jWK.getType() == 5) {
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
            aOV();
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = ab.transformPermissionResult(strArr, iArr);
            if (ab.checkCamera(getApplicationContext())) {
                al.a(getPageContext(), this.dyk);
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
        this.auD = z;
        if (this.kTy && System.currentTimeMillis() - this.kTz < 800) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.kTy = false;
        }
        if (this.kSH != null && !z) {
            this.kSH.byJ();
        }
        if (this.kSJ != null && !z) {
            cVM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Le(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.kTv != null) {
            Lf(str);
            this.kTv.dismiss();
        }
    }

    private void fI(Context context) {
        kTx = l.getEquipmentHeight(context);
    }

    private void Lf(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.kTy = true;
        cWB();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            cWj();
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

    private File cWD() {
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

    private void cWE() {
        if (this.kTt != null && this.jWK.getType() == 0 && this.jWK.getType() == 9) {
            fI(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.kTt != null) {
                        WriteActivity.this.Le(WriteActivity.this.kTt.getAbsolutePath());
                    }
                }
            });
            this.kTu = (TbImageView) this.mBubbleView.findViewById(R.id.rec_img_view);
            this.kTw = (LinearLayout) this.mBubbleView.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.aFD().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.kTt.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.aFD().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.kTt.getAbsolutePath());
                Bitmap g = g(this.kTt.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (g != null) {
                    this.kTu.setImageBitmap(g);
                    this.kTu.setDrawBorder(true);
                    this.kTu.setBorderWidth(2);
                    this.kTu.setBorderColor(am.getColor(R.color.common_color_10264));
                    this.kTv = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.kTv.setCanceledOnTouchOutside(true);
                    this.kTv.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.kTy) {
                                l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.kTz = System.currentTimeMillis();
                            }
                        }
                    });
                    this.kTv.setContentView(this.mBubbleView);
                    this.kTv.show();
                    Window window = this.kTv.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (kTx / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.auD && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.kSi = false;
            this.kSh = "";
            if ("from_content".equals(str)) {
                this.kSh = "from_content";
            } else if ("from_title".equals(str)) {
                this.kSh = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.vH(String.valueOf(charSequence.charAt(i)))) {
                tS(false);
            }
        }
    }

    public void cDh() {
        if (this.kSV || !com.baidu.tbadk.core.util.v.isEmpty(this.mList) || !StringUtils.isNull(this.jWK.getTitle())) {
            this.kSm.setVisibility(0);
            this.kSm.requestFocus();
            return;
        }
        this.kSm.setVisibility(8);
    }
}
