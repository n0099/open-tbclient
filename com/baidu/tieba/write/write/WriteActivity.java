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
    private static int kTv = 0;
    private EditorTools dwF;
    private String dyj;
    private LocationModel dyk;
    private NewWriteModel dyl;
    private String gmr;
    private String gms;
    private String gmt;
    private VoiceManager goj;
    private LinearLayout iJr;
    private PlayVoiceBntNew iJs;
    private ImageView iJu;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private int jWJ;
    private TextView jXg;
    private com.baidu.tieba.write.h jXh;
    private ImageView jXi;
    private View jXj;
    private com.baidu.tieba.write.b.c kQp;
    private HotTopicBussinessData kSC;
    private TextView kSD;
    private com.baidu.tieba.write.editor.b kSF;
    private e kSH;
    private com.baidu.tieba.view.b kSO;
    private View kSX;
    private LinearLayout kSj;
    private LinearLayout kSk;
    private View kSm;
    private Toast kSo;
    private AdditionData kSp;
    private RelativeLayout kSq;
    private TextView kSr;
    private TextView kSs;
    private TextView kSt;
    List<w> kSu;
    w kSv;
    private int kSw;
    private String kSx;
    private int kSy;
    private PostCategoryView kSz;
    private View kTA;
    private TextView kTB;
    private com.baidu.tieba.c.d kTD;
    private g kTe;
    private View kTz;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String kSf = "";
    private boolean kSg = false;
    private WriteData jWI = null;
    private boolean kST = false;
    private boolean kSi = false;
    private boolean kSU = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText jXa = null;
    private HeadImageView kSV = null;
    private View jXb = null;
    private LinearLayout jXd = null;
    private EditText jXe = null;
    private FeedBackModel kSl = null;
    private FeedBackTopListView kSW = null;
    private ArrayList<WritePrefixItemLayout> kSn = new ArrayList<>();
    private String ihk = null;
    private final KeyEvent gat = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView kSY = null;
    private TextView jXf = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener gfk = null;
    private com.baidu.tbadk.core.dialog.a kSZ = null;
    private final Handler mHandler = new Handler();
    private boolean kTa = false;
    private String kTb = null;
    private RelativeLayout hrX = null;
    private String dyp = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int dyq = 0;
    private int kTc = 0;
    private WriteImagesInfo kTd = new WriteImagesInfo();
    private View mRootView = null;
    private GridView kTf = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a kTg = null;
    private ScrollView kSA = null;
    private EditText kTh = null;
    private View kTi = null;
    private View kTj = null;
    private View kTk = null;
    private EditText kTl = null;
    private TextView kTm = null;
    private TextView kTn = null;
    private TextWatcher kTo = null;
    private TextWatcher kTp = null;
    private boolean kSB = false;
    private boolean kTq = false;
    private com.baidu.tbadk.core.view.a dFS = null;
    private String mFrom = "write";
    private File kTr = null;
    private TbImageView kTs = null;
    private View mBubbleView = null;
    private Dialog kTt = null;
    private LinearLayout kTu = null;
    private boolean kTw = false;
    private long kTx = -1000;
    private boolean kTy = false;
    private String gNW = "2";
    private int aBW = 0;
    private String mTopicId = "";
    private SpannableStringBuilder kSE = new SpannableStringBuilder();
    private boolean kTC = false;
    private boolean auD = false;
    private final b kSG = new b();
    private final HttpMessageListener kTE = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.ihk)) {
                    WriteActivity.this.ihk = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.tU(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.ihk)) {
                    WriteActivity.this.ihk = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.ihk);
                    WriteActivity.this.tU(true);
                }
            }
        }
    };
    private TbFaceManager.a kSI = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
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
    private final AntiHelper.a gpq = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d dyz = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.bEi();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.jWI != null) {
                WriteActivity.this.kSG.aU(null);
                if (z) {
                    WriteActivity.this.gJ(z);
                    if (WriteActivity.this.e(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    if (WriteActivity.this.jWI.getType() != 0 && WriteActivity.this.jWI.getType() != 9) {
                        if (WriteActivity.this.jWI.getType() != 7) {
                            if (WriteActivity.this.jWI.getType() == 1) {
                                v.d(WriteActivity.this.jWI.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.jWI.getType() == 5) {
                                v.d(WriteActivity.this.jWI.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            v.c("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            v.c(WriteActivity.this.jWI.getForumId(), (WriteData) null);
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
                    WriteActivity.this.kSG.aU(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.kSG.KK(postWriteCallBackData.getErrorString());
                    WriteActivity.this.kSG.b(WriteActivity.this.jXa, WriteActivity.this.jXe);
                } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aJE());
                    if (com.baidu.tbadk.s.a.wa(aaVar.aJD())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJD());
                        if (WriteActivity.this.kSU) {
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
    private final LocationModel.a dyx = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void aPi() {
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
            if (aVar != null && !StringUtils.isNull(aVar.cLC())) {
                WriteActivity.this.a(2, true, aVar.cLC());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener kiU = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.dyk.sQ(false);
                    WriteActivity.this.dyk.eG(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.dyk.sQ(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener kSJ = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener kSK = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.dwF.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cVH = WriteActivity.this.cVH();
            if (cVH >= 0 && cVH < WriteActivity.this.jXe.getText().length()) {
                WriteActivity.this.jXe.setSelection(cVH);
            }
        }
    };
    private boolean kSL = true;
    private final View.OnFocusChangeListener eVV = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.jXa || view == WriteActivity.this.mBack || view == WriteActivity.this.jXf) {
                if (z) {
                    WriteActivity.this.kSL = true;
                    WriteActivity.this.cVI();
                    l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.jXa);
                    if (WriteActivity.this.dwF != null) {
                        WriteActivity.this.dwF.aMO();
                    }
                } else if (view == WriteActivity.this.jXa) {
                    WriteActivity.this.jXg.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.jXe && z) {
                WriteActivity.this.kSL = false;
                WriteActivity.this.cVI();
                l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.jXe);
                if (WriteActivity.this.dwF != null) {
                    WriteActivity.this.dwF.aMO();
                }
            }
            WriteActivity.this.cVN();
        }
    };
    private TextWatcher kSM = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String kSQ = "";
        private String kSR;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kSR = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.kSR != null ? this.kSR.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cHZ();
            WriteActivity.this.cVO();
            EditText cVZ = WriteActivity.this.cVZ();
            if (editable != null && cVZ != null && cVZ.getText() != null) {
                if (this.kSQ == null || !this.kSQ.equals(editable.toString())) {
                    if (WriteActivity.this.kSG != null) {
                        this.kSQ = cVZ.getText().toString();
                        WriteActivity.this.kSG.b(cVZ, true);
                        return;
                    }
                    return;
                }
                cVZ.setSelection(cVZ.getSelectionEnd());
            }
        }
    };
    private TextWatcher kSN = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String kSR;
        private String kSS = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kSR = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.kSR != null ? this.kSR.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cHZ();
            EditText cVY = WriteActivity.this.cVY();
            if (editable != null && cVY != null && cVY.getText() != null) {
                if (this.kSS == null || !this.kSS.equals(editable.toString())) {
                    if (WriteActivity.this.kSG != null) {
                        this.kSS = cVY.getText().toString();
                        WriteActivity.this.kSG.b(cVY, false);
                        return;
                    }
                    return;
                }
                cVY.setSelection(cVY.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0610a iPt = new a.InterfaceC0610a() { // from class: com.baidu.tieba.write.write.WriteActivity.31
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0610a
        public void onRefresh() {
            WriteActivity.this.ihk = null;
            WriteActivity.this.tU(false);
            WriteActivity.this.dwF.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void aOS() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void aOT() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aOV();
        } else if (this.dyk.cLJ()) {
            aOS();
        } else {
            this.dyk.sQ(false);
            a(1, true, (String) null);
            this.dyk.cLH();
        }
    }

    public void cWj() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
            if (this.kSF != null) {
                this.kSF.cUO();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aOV();
        } else if (this.dyk != null) {
            this.dyk.sQ(false);
            a(1, true, (String) null);
            this.dyk.cLH();
        }
    }

    private void aOV() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.jW(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.dyk.cLL();
                } else {
                    WriteActivity.this.dyx.aPi();
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
        aVar.aEA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cVH() {
        int selectionEnd = cVY().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cVY().getText().getSpans(0, cVY().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cVY().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cVY().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVI() {
        if (this.dwF != null) {
            this.dwF.setBarLauncherEnabled(!this.kSL);
            this.dwF.setBarLauncherEnabled(true, 26);
            this.dwF.setBarLauncherEnabled(true, 2);
            this.dwF.setBarLauncherEnabled(true, 30);
            V(9, this.kSL ? false : true);
        }
    }

    private void V(int i, boolean z) {
        com.baidu.tbadk.editortools.g mm;
        if (this.dwF != null && (mm = this.dwF.mm(i)) != null) {
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
        if (this.kSB) {
            this.jXa.setVisibility(8);
            if (this.jWI.getType() == 5) {
                this.kTk.setVisibility(8);
            } else {
                this.kTk.setVisibility(0);
            }
            a(this.kTn, this.kTh);
            a(this.kTm, this.kTl);
            cHZ();
        }
        if (this.kST) {
            this.kSL = true;
            cVI();
            if (this.dwF != null) {
                this.dwF.aMO();
            }
            this.jXa.requestFocus();
            ShowSoftKeyPadDelay(this.jXa);
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
            cWz();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                cWh();
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
        if (this.jWI.getType() == 0) {
            Et(this.aBW);
        }
        initUI();
        cWo();
        this.dyk = new LocationModel(getPageContext());
        this.dyk.a(this.dyx);
        registerListener(this.kiU);
        registerListener(this.kSJ);
        cfK();
        cWC();
        if (this.kSB) {
            this.kTg.setEditorTools(this.dwF);
        } else {
            this.jXe.requestFocus();
        }
        cDf();
        cWh();
        cWA();
    }

    @SuppressLint({"ResourceAsColor"})
    private void cfK() {
        this.dwF = new EditorTools(getActivity());
        this.dwF.setBarMaxLauCount(5);
        this.dwF.setMoreButtonAtEnd(true);
        this.dwF.setBarBackgroundColorId(R.color.cp_bg_line_h);
        this.dwF.setBarLauncherType(1);
        this.dwF.gB(true);
        this.dwF.gC(true);
        switch (this.jWI.getType()) {
            case 4:
            case 5:
                cWm();
                break;
            default:
                cVJ();
                break;
        }
        this.dwF.build();
        if (this.kSj != null) {
            this.kSj.addView(this.dwF);
        }
        bZN();
        this.dwF.display();
        com.baidu.tbadk.editortools.g mm = this.dwF.mm(6);
        if (mm != null && !TextUtils.isEmpty(this.dyp)) {
            ((View) mm).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.dyp);
                }
            });
        }
        if (!this.kSB) {
            this.dwF.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.dwF.aMO();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.dwF.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.dwF.b(new com.baidu.tbadk.editortools.a(2, 26, HanziToPinyin.Token.SEPARATOR));
        }
        cVL();
    }

    private void cWk() {
        this.kTi = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.kTk = this.kTi.findViewById(R.id.live_post_title_container);
        this.kTh = (EditText) this.kTi.findViewById(R.id.live_post_content);
        this.kTf = (GridView) this.kTi.findViewById(R.id.photoLiveGridView);
        this.kTl = (EditText) this.kTi.findViewById(R.id.live_post_title);
        this.kTm = (TextView) this.kTi.findViewById(R.id.titleOverPlusNumber);
        this.kTn = (TextView) this.kTi.findViewById(R.id.contentOverPlusNumber);
        this.kTj = this.kTi.findViewById(R.id.live_interval_view);
        this.kTm.setText(String.valueOf(20));
        this.kTn.setText(String.valueOf(233));
        this.kTi.setVisibility(0);
        this.kTm.setVisibility(0);
        this.kTn.setVisibility(0);
        this.kTl.setHint(R.string.tips_title_limit_new);
        this.kTl.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.kTq = true;
                    WriteActivity.this.kSL = true;
                    WriteActivity.this.cVI();
                    if (WriteActivity.this.dwF != null) {
                        WriteActivity.this.dwF.aMO();
                    }
                }
            }
        });
        if (this.jWI.getType() == 4) {
            this.kTh.setHint(R.string.live_write_input_content_new);
        } else if (this.jWI.getType() == 5) {
            this.kTh.setHint(R.string.live_write_input_content_update);
        }
        this.kTh.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.kTq = false;
                    WriteActivity.this.kSL = false;
                    WriteActivity.this.cVI();
                    if (WriteActivity.this.dwF != null) {
                        WriteActivity.this.dwF.aMO();
                    }
                }
            }
        });
        this.kTh.requestFocus();
        this.kTh.addTextChangedListener(TK());
        this.kTl.requestFocus();
        this.kTl.addTextChangedListener(TK());
        this.kTl.setOnClickListener(this.kSK);
        this.kTh.setOnClickListener(this.kSK);
        this.kTg = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.kTf);
        this.kTg.En(6);
        this.kTf.setAdapter((ListAdapter) this.kTg);
        View findViewById = this.kTi.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void cVt() {
                WriteActivity.this.cWx();
            }
        });
        cWl();
    }

    private void cWl() {
        if (this.jWI.getType() == 0) {
            if (this.jWI.getTitle() != null) {
                this.kTl.setText(this.jWI.getTitle());
                this.kTl.setSelection(this.jWI.getTitle().length());
                return;
            }
            return;
        }
        if (this.jWI.getType() == 1 || this.jWI.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.kSB) {
            cWv();
        }
        if (this.dwF.aOt()) {
            this.dwF.aMO();
        }
        Et(0);
    }

    private void Et(int i) {
        if (this.writeImagesInfo != null && this.jWI != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.jWI.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.jWI.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.gNW);
            albumActivityConfig.setProfessionZone(this.jWI.getProZone());
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void cWm() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.dwF.aI(arrayList);
        com.baidu.tbadk.editortools.l mp = this.dwF.mp(5);
        if (mp != null) {
            mp.dxp = 2;
        }
        this.dwF.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.dwF.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void cVJ() {
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
            this.dwF.b(dVar);
        }
        Boolean cWs = cWs();
        if (!this.kST && cWs != null && cWs.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.cMg() && r.d(this.jWI.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar5 = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar5.dxp = 3;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dwF.b(lVar5);
            }
        }
        this.dwF.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 4));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask2 != null && (lVar4 = (com.baidu.tbadk.editortools.l) runTask2.getData()) != null) {
            lVar4.dxp = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dwF.b(lVar4);
            }
        }
        this.dwF.b(new com.baidu.tbadk.editortools.k(getActivity(), 6));
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask3 != null && (lVar3 = (com.baidu.tbadk.editortools.l) runTask3.getData()) != null) {
            lVar3.dxp = 7;
            this.dwF.b(lVar3);
        }
        this.dwF.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 8));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask4 != null && (lVar2 = (com.baidu.tbadk.editortools.l) runTask4.getData()) != null) {
            lVar2.dxr = true;
            lVar2.dxp = 9;
            lVar2.dxl = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dwF.b(lVar2);
            }
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask5 != null && (lVar = (com.baidu.tbadk.editortools.l) runTask5.getData()) != null) {
            lVar.dxr = true;
            lVar.dxp = 10;
            lVar.dxl = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dwF.b(lVar);
            }
        }
        if (this.kSp == null) {
            if (this.kSF == null) {
                this.kSF = new com.baidu.tieba.write.editor.b(getActivity(), this.gNW);
                this.kSF.bz(this.jWI.getForumId(), this.privateThread);
                this.kSF.tO(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.kSF.cUK();
                this.kSF.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                cWj();
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.mList)) {
                this.kSF.cUK();
            }
            this.dwF.b(this.kSF);
        }
        this.dwF.aI(arrayList);
        com.baidu.tbadk.editortools.l mp = this.dwF.mp(5);
        if (mp != null) {
            mp.dxp = 1;
        }
    }

    private void cVK() {
        if (this.kSH != null) {
            this.kSH.hideTip();
        }
    }

    private void cVL() {
        if (this.kSH == null) {
            this.kSH = new e(getPageContext());
        }
        this.kSH.c(this.dwF);
    }

    private void bZN() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.cVX()) {
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
                            if (qVar.aJu() == EmotionGroupType.BIG_EMOTION || qVar.aJu() == EmotionGroupType.USER_COLLECT) {
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
                                    WriteActivity.this.cHZ();
                                }
                            } else if (WriteActivity.this.cVX()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(qVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.cWa();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.cno();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.cWz();
                        WriteActivity.this.cHZ();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.Eu(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new an("c12612").X("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.kSp == null) {
                            WriteActivity.this.aOW();
                            return;
                        }
                        switch (WriteActivity.this.dyq) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.aOT();
                                    return;
                                } else {
                                    ab.reuqestLocation(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.aOS();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.dyk != null) {
                            WriteActivity.this.dyk.sQ(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.ihk = null;
                        } else {
                            WriteActivity.this.ihk = (String) aVar.data;
                        }
                        WriteActivity.this.tU(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        an anVar = new an("c10645");
                        if (WriteActivity.this.jWI != null) {
                            str = WriteActivity.this.jWI.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.cy("fid", str);
                        TiebaStatic.log(anVar);
                        if (WriteActivity.this.jWI == null || (videoInfo = WriteActivity.this.jWI.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.dwF.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.dwF.aOt()) {
                                        WriteActivity.this.dwF.aMO();
                                        WriteActivity.this.dwF.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.dwF.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                        WriteActivity.this.dwF.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.dwF.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.dwF.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.jWI.setVideoInfo(null);
                        WriteActivity.this.cHZ();
                        if (WriteActivity.this.jXe != null) {
                            WriteActivity.this.jXe.requestFocus();
                        }
                        WriteActivity.this.dwF.aMO();
                        WriteActivity.this.dwF.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.jXe);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new an("c12612").X("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.dwF.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.kSg = true;
                        WriteActivity.this.tS(true);
                        if (!WriteActivity.this.cVZ().isFocused() || WriteActivity.this.kSk.getVisibility() != 0) {
                            WriteActivity.this.kSf = "from_content";
                        } else {
                            WriteActivity.this.kSf = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        if (WriteActivity.this.kSk.getVisibility() == 0) {
                            if (WriteActivity.this.kSk.hasFocus()) {
                                WriteActivity.this.jXe.requestFocus();
                                WriteActivity.this.jXe.setSelection(WriteActivity.this.jXe.getText().toString().length());
                            }
                            WriteActivity.this.kSk.setVisibility(8);
                            WriteActivity.this.dwF.mm(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.kSk.setVisibility(0);
                            WriteActivity.this.kSk.requestFocus();
                            WriteActivity.this.dwF.mm(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.cHZ();
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
        this.dwF.setActionListener(16, bVar);
        this.dwF.setActionListener(14, bVar);
        this.dwF.setActionListener(24, bVar);
        this.dwF.setActionListener(3, bVar);
        this.dwF.setActionListener(10, bVar);
        this.dwF.setActionListener(11, bVar);
        this.dwF.setActionListener(12, bVar);
        this.dwF.setActionListener(13, bVar);
        this.dwF.setActionListener(15, bVar);
        this.dwF.setActionListener(18, bVar);
        this.dwF.setActionListener(20, bVar);
        this.dwF.setActionListener(25, bVar);
        this.dwF.setActionListener(27, bVar);
        this.dwF.setActionListener(29, bVar);
        this.dwF.setActionListener(43, bVar);
        this.dwF.setActionListener(56, bVar);
        this.dwF.setActionListener(48, bVar);
        this.dwF.setActionListener(46, bVar);
        this.dwF.setActionListener(49, bVar);
        this.dwF.setActionListener(47, bVar);
        this.dwF.setActionListener(55, bVar);
        this.dwF.setActionListener(58, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eu(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOW() {
        if (this.dyk.brj()) {
            if (this.dyk.cLJ()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.cLE().getLocationData().cLC());
                return;
            }
            a(1, true, (String) null);
            this.dyk.cLH();
            return;
        }
        a(0, true, (String) null);
    }

    protected void cHQ() {
        if (this.dyl != null) {
            this.dyl.cancelLoadData();
        }
        if (this.kSl != null) {
            this.kSl.cancelLoadData();
        }
        if (this.dyk != null) {
            this.dyk.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cVK();
        TiebaPrepareImageService.StopService();
        cHQ();
        cWr();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.kTe != null) {
            this.kTe.destroy();
        }
        if (this.kTD != null) {
            this.kTD.zx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVM() {
        if (this.jWI != null && this.jWI.getType() == 2 && this.kTa) {
            finish();
        } else if (this.jWI == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.jWI.setTitle(cVZ().getText().toString());
            this.jWI.setContent(cVY().getText().toString());
            int type = this.jWI.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    v.c(this.jWI.getForumId(), this.jWI);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    v.c("24591571", this.jWI);
                }
            } else if (type == 1) {
                v.d(this.jWI.getThreadId(), this.jWI);
            } else if (type == 4) {
                v.c(this.jWI.getForumId() + "photolive", this.jWI);
            } else if (type == 5) {
                v.d(this.jWI.getThreadId() + "updatephotolive", this.jWI);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.jXh != null && this.jXh.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.jXh, getPageContext().getPageActivity());
                return true;
            } else if (this.dwF.aOt()) {
                this.dwF.aMO();
                return true;
            } else {
                cHQ();
                cVM();
                return true;
            }
        }
        if (i == 67 && (text = cVY().getText()) != null) {
            int selectionStart = cVY().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cVY().onKeyDown(67, this.gat);
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
        getLayoutMode().onModeChanged(this.hrX);
        getLayoutMode().onModeChanged(this.kTu);
        am.setBackgroundColor(this.hrX, R.color.cp_bg_line_e);
        if (this.kTs != null && (i == 1 || i == 4)) {
            this.kTs.setBorderColor(am.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.jXf, R.color.cp_link_tip_a, 1);
        cVI();
        am.setBackgroundColor(this.jXb, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.kTj, R.color.cp_bg_line_c);
        am.setBackgroundColor(cVZ(), R.color.cp_bg_line_e);
        am.setImageResource(this.iJu, R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.ihk)) {
            am.setBackgroundColor(cVY(), R.color.cp_bg_line_e);
        }
        cHZ();
        this.dwF.onChangeSkinType(i);
        if (this.kSz != null) {
            this.kSz.aHL();
        }
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.kTe.kTZ.notifyDataSetChanged();
        cVN();
        cVO();
        tU(false);
        if (this.kSG != null) {
            this.kSG.c(cVZ(), cVY());
        }
        this.kQp.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVN() {
        if (this.jXa.hasFocus()) {
            this.jXa.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.jXa.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.jXe.hasFocus()) {
            this.jXe.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.jXe.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVO() {
        if (this.jXa != null && this.jXa.getText() != null && this.jXa.getText().toString() != null && this.jXa.getPaint() != null) {
            if (this.jXa.getText().toString().length() == 0) {
                this.jXa.getPaint().setFakeBoldText(false);
            } else if (this.jXa.getText().toString().length() > 0) {
                this.jXa.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.dFS = new com.baidu.tbadk.core.view.a(getPageContext());
        this.kSB = this.jWI.getType() == 4 || 5 == this.jWI.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aGA().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.kSY = (TextView) findViewById(R.id.btn_image_problem);
        cVQ();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jXf.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.jXf.setLayoutParams(layoutParams);
        this.jXf.setOnFocusChangeListener(this.eVV);
        this.kSA = (ScrollView) findViewById(R.id.write_scrollview);
        this.kSA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.jXe != null) {
                        l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.jXe);
                    }
                    if (WriteActivity.this.dwF != null) {
                        WriteActivity.this.dwF.aMO();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.kSW = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.kSX = findViewById(R.id.feedback_divider);
        this.hrX = (RelativeLayout) findViewById(R.id.parent);
        this.kSj = (LinearLayout) findViewById(R.id.tool_view);
        this.kSj.setContentDescription(IStringUtil.TOP_PATH);
        this.kSk = (LinearLayout) findViewById(R.id.title_view);
        this.jXb = findViewById(R.id.interval_view);
        this.kTz = findViewById(R.id.hot_topic_fourm_view);
        this.kTA = findViewById(R.id.hot_topic_divider);
        this.kSD = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.kTB = (TextView) findViewById(R.id.change_one_tv);
        cHY();
        if (this.kSB) {
            this.kSA.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            cWk();
        } else {
            this.kTe = new g(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.kTe.tM(false);
            } else {
                g gVar = this.kTe;
                if (this.jWI.getType() != 0 && this.jWI.getType() != 9) {
                    z = false;
                }
                gVar.tM(z);
            }
        }
        cIa();
        if (this.kST || this.kSi) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().daN) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.jXd = (LinearLayout) findViewById(R.id.post_content_container);
        this.jXd.setDrawingCacheEnabled(false);
        this.jXd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.dwF.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.jXe.requestFocus();
            }
        });
        this.iJr = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.iJs = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.iJu = (ImageView) findViewById(R.id.iv_delete_voice);
        this.iJu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cno();
            }
        });
        this.mBack.setOnFocusChangeListener(this.eVV);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cHQ();
                WriteActivity.this.cVM();
            }
        });
        this.kSY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        cVT();
        o(cWs());
        cVV();
        cVP();
        cWp();
        cWq();
        cVI();
        cVU();
        cHX();
        cWb();
        if (this.jWI.getType() == 4 && this.jXj != null && this.kSm != null) {
            this.jXj.setVisibility(8);
            this.kSm.setVisibility(8);
        }
        cHZ();
        cWn();
        cVc();
    }

    private void cVc() {
        this.kQp = new com.baidu.tieba.write.b.c(getPageContext().getPageActivity(), this.mName, this.jWI.getProZone(), isUseStyleImmersiveSticky() ? StatusBarUtil.getStatusBarOffsetPx(getPageContext().getPageActivity()) : 0);
        this.kQp.a(new c.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // com.baidu.tieba.write.b.c.a
            public void Ei(int i) {
                WriteActivity.this.jWI.setProZone(i);
            }
        });
        this.kQp.byt();
    }

    private void cVP() {
        String str;
        String str2;
        if (this.jWI != null) {
            switch (this.jWI.getType()) {
                case 0:
                case 9:
                    if (this.kST || this.kSi) {
                        if (this.kSU) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.gNW != null && this.gNW.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                    } else if (this.gNW != null && this.gNW.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.jWI.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.jWI.getForumName() + getResources().getString(R.string.bar));
                        this.jXa.setVisibility(8);
                        String str3 = this.gmt + HanziToPinyin.Token.SEPARATOR + this.gmr;
                        if (!StringUtils.isNull(str3)) {
                            this.jXe.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.jXa.setVisibility(0);
                    this.jXe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.jXe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.jXa.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.jXe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.jWI.getFloorNum() + 1)));
                    this.kTj.setVisibility(8);
                    return;
                case 7:
                    this.jXa.setVisibility(0);
                    this.jXe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void cVQ() {
        if (this.jWI.getType() == 7) {
            this.jXf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.jXf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void cVR() {
        if (this.jWI != null && this.jWI.getType() == 0 && this.jWI.getType() == 9 && !this.kST && !this.kSi && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = aq.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && cVZ() != null) {
                cVZ().setText(cutStringWithSuffix);
                cVZ().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.iJr.setVisibility(0);
            this.iJs.setVoiceModel(voiceModel);
            this.iJs.cMf();
            cHZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cno() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.iJr.setVisibility(8);
        this.iJs.bOn();
        this.iJs.setVoiceModel(null);
        com.baidu.tbadk.editortools.l mp = this.dwF.mp(6);
        if (mp != null && mp.dwz != null) {
            mp.dwz.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cHZ();
    }

    private void cVS() {
        this.kSu = null;
        this.kSw = -1;
        this.kSy = -1;
        y sY = x.bFB().sY(1);
        if (sY != null) {
            this.kSu = sY.grT;
            this.kSw = getIntent().getIntExtra("category_id", -1);
            if (this.kSu != null && !this.kSu.isEmpty() && this.kSw >= 0) {
                this.kSv = new w();
                this.kSv.grP = 0;
                this.kSv.name = getPageContext().getResources().getString(R.string.category_auto);
                this.kSy = this.kSv.grP;
                this.kSx = this.kSv.name;
                for (w wVar : this.kSu) {
                    if (wVar.grP == this.kSw) {
                        this.kSy = wVar.grP;
                        this.kSx = wVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cVT() {
        if (this.kSu != null && !this.kSu.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.kSz = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.kSz.setText(this.kSx);
            this.kSz.setCategoryContainerData(this.kSu, this.kSv, this.kSy);
            this.kSz.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, as asVar) {
                    if (asVar != null) {
                        WriteActivity.this.kSz.setText(asVar.name);
                        WriteActivity.this.jWI.setCategoryTo(asVar.grP);
                        WriteActivity.this.kSy = asVar.grP;
                        WriteActivity.this.kSz.cVv();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.kSz.cVu();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cVZ());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cVY());
                }
            });
        }
    }

    private void cWn() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.kSO = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.kSO.setTitle(R.string.no_disturb_start_time);
        this.kSO.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.kSO);
        this.kSO.setButton(-2, getPageContext().getString(R.string.cancel), this.kSO);
        return this.kSO;
    }

    private void cVU() {
        this.kSq = (RelativeLayout) findViewById(R.id.addition_container);
        this.kSr = (TextView) findViewById(R.id.addition_create_time);
        this.kSs = (TextView) findViewById(R.id.addition_last_time);
        this.kSt = (TextView) findViewById(R.id.addition_last_content);
        if (this.kSp != null) {
            this.kSq.setVisibility(0);
            this.kSr.setText(getPageContext().getString(R.string.write_addition_create) + aq.getFormatTime(this.kSp.getCreateTime() * 1000));
            if (this.kSp.getAlreadyCount() == 0) {
                this.kSs.setVisibility(8);
            } else {
                this.kSs.setText(getPageContext().getString(R.string.write_addition_last) + aq.getFormatTime(this.kSp.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.kSp.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.kSt.setText(lastAdditionContent);
            } else {
                this.kSt.setVisibility(8);
            }
            cVY().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.kSp.getAlreadyCount()), Integer.valueOf(this.kSp.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.kSq.setVisibility(8);
    }

    private void cHX() {
        this.jXj = findViewById(R.id.post_prefix_layout);
        if (this.kTD == null) {
            this.kTD = new com.baidu.tieba.c.d(getPageContext(), this.jXj);
            this.kTD.ck(R.drawable.bg_tip_blue_up_left);
            this.kTD.cj(16);
            this.kTD.kw(true);
            this.kTD.setUseDirectOffset(true);
            this.kTD.rz(l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.jXg = (TextView) findViewById(R.id.post_prefix);
        this.kSm = findViewById(R.id.prefix_divider);
        this.jXi = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.jXj.setVisibility(0);
            this.kTD.d(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.jWJ = 0;
            this.jXj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").cy("fid", WriteActivity.this.jWI.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.jXg.setVisibility(0);
                    WriteActivity.this.jXj.setSelected(true);
                    am.setImageResource(WriteActivity.this.jXi, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.jXh, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.dwF.aMO();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.jXa);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.jXe);
                }
            });
            this.jXg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").cy("fid", WriteActivity.this.jWI.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.jXg.setSelected(true);
                    am.setImageResource(WriteActivity.this.jXi, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.jXh, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.dwF.aMO();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cVZ());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cVY());
                }
            });
            this.jXh = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.jXh.a(this);
            this.jXh.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.jXh.setOutsideTouchable(true);
            this.jXh.setFocusable(true);
            this.jXh.setOnDismissListener(this);
            this.jXh.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            am.getColor(R.color.cp_cont_c);
            am.setBackgroundResource(this.jXg, R.color.cp_bg_line_d);
            am.setImageResource(this.jXi, R.drawable.icon_arrow_gray_down);
            this.jXg.setTextColor(color);
            this.kSn.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.kSn.add(writePrefixItemLayout);
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
                this.jXh.addView(writePrefixItemLayout);
            }
            this.jXh.setCurrentIndex(0);
            this.jXg.setText(prefixs.get(0));
            Es(0);
            return;
        }
        this.jXj.setVisibility(8);
    }

    private void cWo() {
        if (this.kST && this.jWI != null) {
            this.kSW.setVisibility(0);
            this.kSX.setVisibility(0);
            this.kSl = new FeedBackModel(getPageContext());
            this.kSl.Lc(this.jWI.getForumName());
            this.kSl.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.24
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.kSW.setVisibility(8);
                        WriteActivity.this.kSX.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.kSW.setVisibility(8);
                        WriteActivity.this.kSX.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.kSW.a(feedBackModel.cVx(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void cVV() {
        this.jXf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (WriteActivity.this.kSG.a(WriteActivity.this.jXa, WriteActivity.this.jXe)) {
                        WriteActivity.this.showToast(WriteActivity.this.kSG.cUe());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cVZ());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cVY());
                    WriteActivity.this.dwF.aMO();
                    if (WriteActivity.this.jWI.getType() != 7) {
                        if (WriteActivity.this.kST) {
                            WriteActivity.this.cWe();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            an anVar = new an("c12102");
                            anVar.X("obj_type", StringUtils.isNull(WriteActivity.this.jWI.getForumName()) ? 1 : 2);
                            TiebaStatic.log(anVar);
                            WriteActivity.this.cWf();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.cWe();
                    }
                    TiebaStatic.log(new an("c12262").cy("obj_locate", WriteActivity.this.gNW));
                }
            }
        });
    }

    protected void cWp() {
        this.kSZ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.kSZ.sS(getPageContext().getString(R.string.is_save_draft)).fG(false).a(getPageContext().getString(R.string.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.jWI.setTitle(WriteActivity.this.cVZ().getText().toString());
                WriteActivity.this.jWI.setContent(WriteActivity.this.cVY().getText().toString());
                int type = WriteActivity.this.jWI.getType();
                if (type == 0 || type == 9) {
                    v.c(WriteActivity.this.jWI.getForumId(), WriteActivity.this.jWI);
                } else if (type == 1) {
                    v.d(WriteActivity.this.jWI.getThreadId(), WriteActivity.this.jWI);
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
                int type = WriteActivity.this.jWI.getType();
                if (type == 0 || type == 9) {
                    v.c(WriteActivity.this.jWI.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    v.d(WriteActivity.this.jWI.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.kSZ.b(getPageContext());
    }

    protected void cHY() {
        this.kSV = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.kSV.setIsRound(true);
        this.kSV.setDrawBorder(false);
        this.kSV.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String tn = o.tn(currentPortrait);
            this.kSV.setUrl(tn);
            this.kSV.startLoad(tn, 12, false);
        }
        if (this.jWI.isUserFeedback()) {
            this.kSV.setVisibility(0);
        }
        this.jXa = (EditText) findViewById(R.id.post_title);
        this.jXa.setOnClickListener(this.kSK);
        this.jXa.setOnFocusChangeListener(this.eVV);
        if (this.jWI.getType() == 0 || this.jWI.getType() == 9 || this.jWI.getType() == 7) {
            if (this.jWI.getTitle() != null) {
                this.jXa.setText(this.jWI.getTitle());
                this.jXa.setSelection(this.jWI.getTitle().length());
            } else if (this.kSU) {
                this.jXa.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.jWI.getType() == 1 || this.jWI.getType() != 2) {
        }
        this.jXa.addTextChangedListener(this.kSM);
        if (!this.jWI.getHaveDraft()) {
            cVR();
            this.kTy = true;
        }
        if (this.jWI.isUserFeedback()) {
            this.jXa.setHint(getResources().getString(R.string.feedback_title_hint));
        } else {
            this.jXa.setHint(getResources().getString(R.string.post_title_hint));
        }
    }

    private TextWatcher TK() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            private int kTH;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.cHZ();
                if (WriteActivity.this.kSB) {
                    this.kTH = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.kTH);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.kSB || !WriteActivity.this.kTq) {
                    if (WriteActivity.this.kSB) {
                        if (this.mEditText != WriteActivity.this.kTh || this.mTextView != WriteActivity.this.kTn) {
                            this.mEditText = WriteActivity.this.kTh;
                            this.mTextView = WriteActivity.this.kTn;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.kTl || this.mTextView != WriteActivity.this.kTm) {
                    this.mEditText = WriteActivity.this.kTl;
                    this.mTextView = WriteActivity.this.kTm;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.kSB && this.kTq) {
            if (this.kTo != null) {
                this.kTl.removeTextChangedListener(this.kTo);
            }
            this.kTo = textWatcher;
        } else if (this.kSB) {
            if (this.kTp != null) {
                this.kTh.removeTextChangedListener(this.kTp);
            }
            this.kTp = textWatcher;
        }
        return textWatcher;
    }

    private long j(EditText editText) {
        if (editText == this.kTh) {
            return 233L;
        }
        if (editText != this.kTl) {
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

    protected void cIa() {
        this.jXe = (EditText) findViewById(R.id.post_content);
        this.jXe.setDrawingCacheEnabled(false);
        this.jXe.setOnClickListener(this.kSK);
        if (this.jWI.getContent() != null && this.jWI.getContent().length() > 0) {
            SpannableString aB = TbFaceManager.aPN().aB(getPageContext().getPageActivity(), this.jWI.getContent());
            this.jXe.setText(aB);
            this.jXe.setSelection(aB.length());
        } else if (this.jWI.getType() == 2) {
            if (this.kTa) {
                if (this.kTb != null && this.kTb.length() > 0) {
                    this.jXe.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.kTb}));
                    this.jXe.setSelection(this.jXe.getText().length());
                }
            } else if (this.jWI.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.jWI.getFloorNum()));
                this.jXe.setText(format);
                this.jXe.setSelection(format.length());
            }
        }
        this.jXe.setOnFocusChangeListener(this.eVV);
        this.jXe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.dwF.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.jXe.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.jXe.addTextChangedListener(this.kSN);
        if (this.jWI.getType() == 0) {
            this.kTC = true;
        } else {
            tU(true);
            this.kTC = false;
        }
        if (this.jWI.isUserFeedback()) {
            this.jXe.setHint(R.string.write_input_content);
        } else {
            this.jXe.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void tU(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.kSB) {
            cVY().setPadding(0, 0, 0, 0);
            cVY().setBackgroundDrawable(null);
            am.setBackgroundColor(cVY(), R.color.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.ihk) && this.kSp == null) {
                com.baidu.adp.lib.e.c.gr().a(this.ihk, 19, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.30
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
                            WriteActivity.this.cVY().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.cVY(), true, WriteActivity.this.iPt);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cVX() {
        int i = 5000;
        if (this.kSp != null) {
            i = 1000;
        }
        return cVY().getText() != null && cVY().getText().length() >= i;
    }

    private void vh(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.kSf)) {
                this.kSf = "";
                cVY().requestFocus();
                if (cVY().getText() != null && cVY().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cVY().getSelectionStart();
                    editable = cVY().getText();
                }
            } else if ("from_title".equals(this.kSf)) {
                this.kSf = "";
                cVZ().requestFocus();
                if (cVZ().getText() != null && cVZ().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cVZ().getSelectionStart();
                    editable = cVZ().getText();
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
            if (this.jWI != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.jWI.getForumId(), 0L), this.jWI.getFirstDir(), this.jWI.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(q qVar) {
        if (((ImageSpan[]) cVY().getText().getSpans(0, cVY().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.kSo == null) {
                this.kSo = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            this.kSo.show();
            return;
        }
        String name = qVar.getName();
        final EmotionGroupType aJu = qVar.aJu();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.e.c.gr().a(name, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.32
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass32) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.cVY().getSelectionStart(), aVar, aJu);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cVY() != null && cVY().getText() != null) {
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
                int selectionStart = cVY().getSelectionStart() - 1;
                if (cVY().getText().length() > 1 && selectionStart >= 0 && cVY().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cVY().getText().insert(cVY().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cVY().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cVY().getText().insert(cVY().getSelectionStart(), spannableString2);
            }
            Editable text = cVY().getText();
            if (text != null) {
                this.kSE.clear();
                this.kSE.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.kSE);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cVY().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cVY().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cVY().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cVY() {
        return this.kSB ? this.kTh : this.jXe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cVZ() {
        return this.kSB ? this.kTl : this.jXa;
    }

    protected void cWa() {
        Editable text;
        if (cVY() != null && (text = cVY().getText()) != null) {
            int selectionStart = cVY().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cVY().onKeyDown(67, this.gat);
            }
            cVY().onKeyDown(67, this.gat);
            int selectionStart2 = cVY().getSelectionStart();
            if (text != null) {
                this.kSE.clear();
                this.kSE.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.kSE);
                cVY().setSelection(selectionStart2);
            }
        }
    }

    private void o(Boolean bool) {
        String str = null;
        if (this.jWI != null) {
            str = this.jWI.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.kST = true;
        }
    }

    private void cWq() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void cWr() {
        try {
            if (this.kSZ != null) {
                this.kSZ.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.dFS.setCancelListener(null);
        this.dFS.setTipString(R.string.sending);
        this.dFS.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.dFS.setDialogVisiable(false);
    }

    private Boolean cWs() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.dyp = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void cHZ() {
        if (this.jWI != null) {
            String str = "";
            String str2 = "";
            if (cVZ() != null) {
                str = cVZ().getText().toString();
            }
            if (cVY() != null) {
                str2 = cVY().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.jWI.getType() == 0 || this.jWI.getType() == 9 || this.jWI.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.jWJ == com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.jWI.setIsNoTitle(true);
                        } else if (this.kSk.getVisibility() == 0) {
                            this.jWI.setIsNoTitle(false);
                            tT(true);
                            return;
                        }
                    } else if (this.kSk.getVisibility() == 0) {
                        this.jWI.setIsNoTitle(false);
                        tT(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.jWI.setIsNoTitle(true);
                } else if (this.kSk.getVisibility() == 0) {
                    this.jWI.setIsNoTitle(false);
                    tT(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.kSB) {
                    tT(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    tT(true);
                }
            }
            if (this.jWI.getType() == 4) {
                tT(m(this.kTh) && l(this.kTl));
            } else if (this.jWI.getType() == 5) {
                tT(m(this.kTh));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                tT(true);
            } else if (this.jWI.getVideoInfo() != null) {
                tT(true);
            } else {
                tT(false);
            }
        }
    }

    public void tT(boolean z) {
        if (z) {
            am.setNavbarTitleColor(this.jXf, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.jXf.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.jXf, R.color.cp_cont_d, 1);
        this.jXf.setEnabled(false);
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
        this.dyl = new NewWriteModel(this);
        this.dyl.b(this.dyz);
        registerListener(this.kTE);
        this.gfk = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.cHQ();
            }
        };
        this.jWI = new WriteData();
        if (bundle != null) {
            this.jWI.setType(bundle.getInt("type", 0));
            this.jWI.setForumId(bundle.getString("forum_id"));
            this.jWI.setForumName(bundle.getString("forum_name"));
            this.jWI.setFirstDir(bundle.getString("forum_first_dir"));
            this.jWI.setSecondDir(bundle.getString("forum_second_dir"));
            this.jWI.setThreadId(bundle.getString("thread_id"));
            this.jWI.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.jWI.setFloorNum(bundle.getInt("floor_num", 0));
            this.kST = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.kSU = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.kTa = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.kTb = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.dyj = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.kSp = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.jWI.setIsAddition(this.kSp != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.kTc = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.jWI.setTitle(bundle.getString("write_title"));
            this.jWI.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.jWI.setTopicId(this.mTopicId);
            this.gNW = bundle.getString("KEY_CALL_FROM");
            this.aBW = bundle.getInt("album_thread");
            stringExtra = string;
        } else {
            Intent intent = getIntent();
            this.jWI.setType(intent.getIntExtra("type", 0));
            this.jWI.setForumId(intent.getStringExtra("forum_id"));
            this.jWI.setForumName(intent.getStringExtra("forum_name"));
            this.jWI.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.jWI.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.jWI.setThreadId(intent.getStringExtra("thread_id"));
            this.jWI.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.jWI.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.kST = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.kSU = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.kTa = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.kTb = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.kSp = (AdditionData) intent.getSerializableExtra("addition_data");
            this.jWI.setIsAddition(this.kSp != null);
            this.jWI.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.kTc = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.gms = intent.getStringExtra("more_forum_img");
            this.gmt = intent.getStringExtra("more_forum_title");
            this.gmr = intent.getStringExtra("more_forum_url");
            this.jWI.setTitle(intent.getStringExtra("write_title"));
            this.jWI.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.jWI.setTopicId(this.mTopicId);
            this.gNW = intent.getStringExtra("KEY_CALL_FROM");
            this.aBW = intent.getIntExtra("album_thread", 0);
            stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
        }
        if (this.jWI.getType() == 9) {
            this.jWI.setEntranceType(1);
        } else if (this.jWI.getType() == 10) {
            this.jWI.setEntranceType(2);
            this.jWI.setType(9);
        } else if (this.jWI.getType() == 0) {
            this.jWI.setEntranceType(3);
        }
        this.jWI.setIsUserFeedback(this.kST);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (stringExtra != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.jWI.getType() == 4 ? 6 : 9);
        this.jWI.setWriteImagesInfo(this.writeImagesInfo);
        if (this.jWI.getType() == 0 || this.jWI.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                v.c(this.jWI.getForumId(), this);
            }
        } else if (this.jWI.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                v.c("24591571", this);
            }
        } else if (this.jWI.getType() == 1) {
            v.a(this.jWI.getThreadId(), this);
        } else if (this.jWI.getType() == 4) {
            v.c(this.jWI.getForumId() + "photolive", this);
        } else if (this.jWI.getType() == 5) {
            v.a(this.jWI.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.ihk = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.jWI != null && this.jWI.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.jWI.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.kSi = true;
        }
        cVS();
        try {
            this.kTr = cWB();
        } catch (Throwable th) {
            this.kTr = null;
        }
    }

    private void cWb() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.jXa.setText(com.baidu.tbadk.plugins.b.vI(com.baidu.tbadk.plugins.b.vJ(hotTopicBussinessData.mTopicName)));
            this.jXa.setMovementMethod(com.baidu.tieba.view.c.cTs());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString vI = com.baidu.tbadk.plugins.b.vI(com.baidu.tbadk.plugins.b.vJ(hotTopicBussinessData.mTopicName));
            if (vI != null) {
                this.jXa.setText(vI);
            }
            this.kSD.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.v.a
    public void a(WriteData writeData) {
        String str;
        String vJ;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            if (writeData != null) {
                if (this.jWI != null) {
                    this.jWI.setHaveDraft(true);
                    if (com.baidu.adp.lib.util.k.isEmpty(cVZ().getText().toString()) || this.kTy || ((this.kST || this.kSi) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                        if (com.baidu.adp.lib.util.k.isEmpty(this.jWI.getTitle())) {
                            this.jWI.setTitle(writeData.getTitle());
                        }
                        if (!com.baidu.tbadk.core.util.v.isEmpty(this.mList)) {
                            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.getItem(this.mList, 0);
                            if (hotTopicBussinessData == null) {
                                str = null;
                            } else {
                                str = hotTopicBussinessData.mTopicName;
                            }
                            if (StringUtils.isNull(str)) {
                                vJ = this.jWI.getTitle();
                            } else {
                                vJ = com.baidu.tbadk.plugins.b.vJ(str);
                            }
                            SpannableString vI = com.baidu.tbadk.plugins.b.vI(vJ);
                            if (vI != null) {
                                cVZ().setText(vI);
                                cVZ().setSelection(vI.length() > vJ.length() ? vJ.length() : vI.length());
                            }
                        } else {
                            SpannableString vI2 = com.baidu.tbadk.plugins.b.vI(this.jWI.getTitle());
                            if (vI2 != null) {
                                cVZ().setText(vI2);
                                cVZ().setSelection(this.jWI.getTitle().length() > vI2.length() ? vI2.length() : this.jWI.getTitle().length());
                            }
                        }
                    }
                    if (this.jWI != null && !this.jWI.getHaveDraft()) {
                        cVR();
                    }
                    if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.copy(writeData.getVideoInfo());
                        this.jWI.setVideoInfo(videoInfo);
                        this.dwF.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                    }
                    if ((com.baidu.adp.lib.util.k.isEmpty(cVY().getText().toString()) || this.kST || this.kSi) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                        this.jWI.setContent(writeData.getContent());
                        SpannableString a2 = TbFaceManager.aPN().a(getPageContext().getPageActivity(), this.jWI.getContent(), this.kSI);
                        cVY().setText(a2);
                        cVY().setSelection(a2.length());
                        if (this.kSB) {
                            a(this.kTn, this.kTh);
                        }
                    }
                    if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                        this.writeImagesInfo = writeData.getWriteImagesInfo();
                        this.jWI.setWriteImagesInfo(this.writeImagesInfo);
                        cWz();
                        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                            cWh();
                        }
                        tV(false);
                    }
                    if (writeData.getType() == 4 || writeData.getType() == 5) {
                        cWt();
                    }
                    cHZ();
                    int categoryTo = writeData.getCategoryTo();
                    if (categoryTo >= 0 && this.kSu != null) {
                        this.kSy = this.kSv.grP;
                        this.kSx = this.kSv.name;
                        int i = 0;
                        while (true) {
                            if (i == this.kSu.size()) {
                                break;
                            }
                            w wVar = this.kSu.get(i);
                            if (categoryTo != wVar.grP) {
                                i++;
                            } else {
                                this.kSy = categoryTo;
                                this.kSx = wVar.name;
                                this.jWI.setCategoryTo(this.kSy);
                                break;
                            }
                        }
                        if (this.kSz != null) {
                            this.kSz.setText(this.kSx);
                            this.kSz.setCategoryContainerData(this.kSu, this.kSv, this.kSy);
                        }
                    }
                    this.dwF.aMO();
                    return;
                }
                return;
            }
            cWt();
            cVR();
        }
    }

    private void cWt() {
        if ((!this.kSB || this.kTg != null) && this.kTf != null) {
            this.kTg.b(this.writeImagesInfo);
            cWx();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.jWI.getType());
        bundle.putString("forum_id", this.jWI.getForumId());
        bundle.putString("forum_name", this.jWI.getForumName());
        bundle.putString("forum_first_dir", this.jWI.getFirstDir());
        bundle.putString("forum_second_dir", this.jWI.getSecondDir());
        bundle.putString("thread_id", this.jWI.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.jWI.getFloor());
        bundle.putInt("floor_num", this.jWI.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.kTa);
        if (this.kST) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.dyj);
        if (this.kSp != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.kSp));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.kTc);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.gNW);
        bundle.putInt("album_thread", this.aBW);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cVY().getEditableText().toString();
        if (obj != null) {
            cVY().setText(TbFaceManager.aPN().a(getPageContext().getPageActivity(), obj, this.kSI));
            cVY().setSelection(cVY().getText().length());
        }
    }

    private String cWc() {
        return (cVY() == null || cVY().getText() == null) ? "" : cVY().getText().toString();
    }

    private String cWd() {
        if (this.jWI == null || cVZ() == null || cVZ().getVisibility() != 0 || cVZ().getText() == null) {
            return "";
        }
        String obj = cVZ().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) > 0 && this.jWJ != com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) - 1 && this.jWI.getType() != 4 && this.jXg != null && this.jXg.getText() != null) {
            this.jWI.setPostPrefix(this.jXg.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.jWI.getTitle();
        }
        return obj;
    }

    private void Ld(String str) {
        if (this.jWI != null && this.kSk != null) {
            if (this.kSk.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.jWI.setIsNoTitle(true);
                    this.jWI.setTitle("");
                    return;
                }
                this.jWI.setIsNoTitle(false);
                this.jWI.setTitle(str);
                return;
            }
            this.jWI.setIsNoTitle(true);
            this.jWI.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWe() {
        cHQ();
        this.jWI.setContent(cWc());
        Ld(cWd());
        if (this.kST || this.kSi) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.jWI.getTitle()) || !this.jWI.getTitle().startsWith(string)) {
                Ld(string + this.jWI.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.jWI.getContent()) || !this.jWI.getContent().startsWith(str)) {
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
                sb.append(this.jWI.getContent());
                this.jWI.setContent(sb.toString());
            }
        }
        if (this.kSw >= 0) {
            this.jWI.setCategoryFrom(this.kSw);
        }
        if (this.kSy >= 0) {
            this.jWI.setCategoryTo(this.kSy);
        }
        this.jWI.setWriteImagesInfo(this.writeImagesInfo);
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
            this.jWI.setTakePhotoNum(i);
        }
        this.jWI.setHasLocationData(this.dyk != null && this.dyk.brj());
        if (this.writeImagesInfo != null) {
            this.dyl.sS(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.mList) && this.kSC != null && this.kSC.mIsGlobalBlock == 0) {
            this.jWI.setForumId(String.valueOf(this.kSC.mForumId));
            this.jWI.setForumName(this.kSC.mForumName);
        }
        this.dyl.d(this.jWI);
        this.jWI.setContent(this.jWI.getContent().replaceAll("\u0000\n", ""));
        this.jWI.setContent(this.jWI.getContent().replaceAll("\u0000", ""));
        this.jWI.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.dyl.cHS().setVoice(this.mVoiceModel.getId());
                this.dyl.cHS().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.dyl.cHS().setVoice(null);
                this.dyl.cHS().setVoiceDuringTime(-1);
            }
        } else {
            this.dyl.cHS().setVoice(null);
            this.dyl.cHS().setVoiceDuringTime(-1);
        }
        if (!this.dyl.cMk()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.gfk);
            this.dyl.cMh();
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
            if (this.kSp != null) {
                i2 = this.kSp.getTotalCount();
                i = this.kSp.getAlreadyCount() + 1;
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
                if (this.jXa == getCurrentFocus()) {
                    cVY().clearFocus();
                    this.jXa.requestFocus();
                    if (this.dwF != null) {
                        this.dwF.aMO();
                    }
                    ShowSoftKeyPadDelay(this.jXa);
                } else {
                    cVY().requestFocus();
                    if (this.dwF != null) {
                        this.dwF.aMO();
                    }
                    ShowSoftKeyPadDelay(this.jXe);
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
                            cVY().getText().insert(cVY().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.jWI.getType() == 0 || this.jWI.getType() == 9) {
                    v.c(this.jWI.getForumId(), (WriteData) null);
                    if (postWriteCallBackData2 != null) {
                    }
                } else if (this.jWI.getType() == 1) {
                    v.d(this.jWI.getThreadId(), (WriteData) null);
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
                                cWy();
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
                        if (this.kTC) {
                            tU(true);
                            this.kTC = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.kSB) {
                        U(intent);
                        cHZ();
                        return;
                    }
                    aC(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.jWI.setVideoInfo(videoInfo);
                        this.dwF.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                        this.dwF.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.dwF.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    cHZ();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.kSg) {
                                sb2.append(com.baidu.tbadk.plugins.b.dFy);
                                this.kSg = false;
                            }
                            sb2.append(stringExtra);
                            vh(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.isEmpty(this.mList) && !com.baidu.tbadk.core.util.v.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                    this.kSC = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                    a(this.kSC);
                }
            }
        } else if (i2 == 0) {
            if (this.dwF != null && !this.dwF.aOt()) {
                this.jXe.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.dwF.aMO();
            }
            switch (i) {
                case 12001:
                    aOZ();
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    cWw();
                    if (this.kTC) {
                        tU(true);
                        this.kTC = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.jXa == getCurrentFocus()) {
                        cVY().clearFocus();
                        this.jXa.requestFocus();
                        if (this.dwF != null) {
                            this.dwF.aMO();
                        }
                        ShowSoftKeyPadDelay(this.jXa);
                        return;
                    }
                    cVY().requestFocus();
                    if (this.dwF != null) {
                        this.dwF.aMO();
                    }
                    ShowSoftKeyPadDelay(this.jXe);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.kSG.KK(postWriteCallBackData.getErrorString());
                        this.kSG.aU(postWriteCallBackData.getSensitiveWords());
                        this.kSG.b(this.jXa, this.jXe);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.dyj = String.valueOf(System.currentTimeMillis());
                    al.a(getPageContext(), this.dyj);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    cWw();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.kSf)) {
                        cVZ().requestFocus();
                        return;
                    } else if ("from_content".equals(this.kSf)) {
                        cVY().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWf() {
        if ("1".equals(this.gNW)) {
            this.jWI.setCanNoForum(true);
            this.jWI.setTransmitForumData("[]");
        } else if ("2".equals(this.gNW)) {
            this.jWI.setCanNoForum(false);
        }
        cWg();
        this.jWI.setPrivacy(this.isPrivacy);
        cWu();
        this.jWI.setToDynamic(this.isToDynamic);
        this.jWI.setCallFrom(this.gNW);
        if (this.jWI.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cWe();
    }

    private void cWg() {
        if (this.dwF != null) {
            this.dwF.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void cWu() {
        if (this.dwF != null) {
            this.dwF.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void cWv() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void cWw() {
        if (this.kSB) {
            this.kTg.b(this.writeImagesInfo);
            cWx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWx() {
        this.kTg.notifyDataSetChanged();
        this.kTf.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.kTg.notifyDataSetChanged();
                WriteActivity.this.kTf.invalidateViews();
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
        cHZ();
    }

    private void aB(Intent intent) {
        if (this.kSB) {
            aC(intent);
            cWw();
        } else {
            aF(intent);
        }
        cHZ();
    }

    private void aC(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            cWw();
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

    private void cWy() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void aE(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.kTd.parseJson(stringExtra);
            this.kTd.updateQuality();
            if (this.kTd.getChosedFiles() != null && this.kTd.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.kTd.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.kTd.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cVZ());
        HidenSoftKeyPad(this.mInputManager, cVY());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void aF(Intent intent) {
        c(intent, true);
    }

    private void T(Intent intent) {
        this.dyj = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.dyj;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.getEquipmentWidth(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.dyj, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            cWz();
            cWh();
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
                cWz();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    cWh();
                }
            }
            tV(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWz() {
        if (this.dwF.mp(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void aOZ() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.dyj));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void cWA() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.gms)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                com.baidu.tbadk.util.o oVar = new com.baidu.tbadk.util.o(this, this.gms, new o.a() { // from class: com.baidu.tieba.write.write.WriteActivity.38
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
        String forumId = this.jWI == null ? "" : this.jWI.getForumId();
        if (this.kTe != null) {
            this.kTe.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.goj == null) {
            this.goj = VoiceManager.instance();
        }
        return this.goj;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bEi() {
        this.goj = getVoiceManager();
        this.goj.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bb(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.gpq) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.jWI.getType() != 7) {
                if (this.kSp == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                B(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.dyq = i;
        if (this.dwF != null) {
            this.dwF.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void cWh() {
        if (!this.kSB) {
            if (this.dwF != null) {
                this.dwF.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.dwF.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.jWI == null ? "" : this.jWI.getForumId();
            if (this.kTe != null) {
                this.kTe.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gJ(boolean z) {
        if (this.dwF != null) {
            this.dwF.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Es(int i) {
        if (i < this.kSn.size()) {
            for (int i2 = 0; i2 < this.kSn.size(); i2++) {
                this.kSn.get(i2).tK(false);
            }
            this.kSn.get(i).tK(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void Cd(int i) {
        if (i == com.baidu.tbadk.core.util.v.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new an("c13014").X("obj_type", 1));
        } else {
            TiebaStatic.log(new an("c13014").X("obj_type", 2));
        }
        this.jWJ = i;
        this.jXh.setCurrentIndex(i);
        Es(i);
        this.jXg.setText(this.mPrefixData.getPrefixs().get(i));
        cHZ();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.jXh, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.jXj.setSelected(false);
        am.setImageResource(this.jXi, R.drawable.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.jXe);
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
        if (this.jWI != null) {
            if (this.jWI.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.jWI.getType() == 5) {
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
            aOT();
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = ab.transformPermissionResult(strArr, iArr);
            if (ab.checkCamera(getApplicationContext())) {
                al.a(getPageContext(), this.dyj);
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
        if (this.kTw && System.currentTimeMillis() - this.kTx < 800) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.kTw = false;
        }
        if (this.kSF != null && !z) {
            this.kSF.byH();
        }
        if (this.kSH != null && !z) {
            cVK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Le(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.kTt != null) {
            Lf(str);
            this.kTt.dismiss();
        }
    }

    private void fI(Context context) {
        kTv = l.getEquipmentHeight(context);
    }

    private void Lf(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.kTw = true;
        cWz();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            cWh();
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

    private File cWB() {
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

    private void cWC() {
        if (this.kTr != null && this.jWI.getType() == 0 && this.jWI.getType() == 9) {
            fI(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.kTr != null) {
                        WriteActivity.this.Le(WriteActivity.this.kTr.getAbsolutePath());
                    }
                }
            });
            this.kTs = (TbImageView) this.mBubbleView.findViewById(R.id.rec_img_view);
            this.kTu = (LinearLayout) this.mBubbleView.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.aFB().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.kTr.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.aFB().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.kTr.getAbsolutePath());
                Bitmap g = g(this.kTr.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (g != null) {
                    this.kTs.setImageBitmap(g);
                    this.kTs.setDrawBorder(true);
                    this.kTs.setBorderWidth(2);
                    this.kTs.setBorderColor(am.getColor(R.color.common_color_10264));
                    this.kTt = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.kTt.setCanceledOnTouchOutside(true);
                    this.kTt.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.kTw) {
                                l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.kTx = System.currentTimeMillis();
                            }
                        }
                    });
                    this.kTt.setContentView(this.mBubbleView);
                    this.kTt.show();
                    Window window = this.kTt.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (kTv / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
            this.kSg = false;
            this.kSf = "";
            if ("from_content".equals(str)) {
                this.kSf = "from_content";
            } else if ("from_title".equals(str)) {
                this.kSf = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.vH(String.valueOf(charSequence.charAt(i)))) {
                tS(false);
            }
        }
    }

    public void cDf() {
        if (this.kST || !com.baidu.tbadk.core.util.v.isEmpty(this.mList) || !StringUtils.isNull(this.jWI.getTitle())) {
            this.kSk.setVisibility(0);
            this.kSk.requestFocus();
            return;
        }
        this.kSk.setVisibility(8);
    }
}
