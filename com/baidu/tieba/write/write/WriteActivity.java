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
import com.baidu.tbadk.core.util.v;
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
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.s;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.h;
import com.baidu.tieba.write.view.ForumTabSelectedView;
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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0078a, VoiceManager.c, w.a, h.a {
    private static int kVm = 0;
    private EditorTools dxg;
    private String dyK;
    private LocationModel dyL;
    private NewWriteModel dyM;
    private String gno;
    private String gnp;
    private String gnq;
    private VoiceManager gpi;
    private LinearLayout iLg;
    private PlayVoiceBntNew iLh;
    private ImageView iLj;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private TextView jYW;
    private com.baidu.tieba.write.h jYX;
    private ImageView jYY;
    private View jYZ;
    private int jYz;
    private FrsTabInfoData kOH;
    private ForumTabSelectedView kSA;
    private com.baidu.tieba.view.b kUF;
    private View kUO;
    private g kUV;
    private LinearLayout kUa;
    private LinearLayout kUb;
    private View kUd;
    private Toast kUf;
    private AdditionData kUg;
    private RelativeLayout kUh;
    private TextView kUi;
    private TextView kUj;
    private TextView kUk;
    List<x> kUl;
    x kUm;
    private int kUn;
    private String kUo;
    private int kUp;
    private PostCategoryView kUq;
    private HotTopicBussinessData kUt;
    private TextView kUu;
    private com.baidu.tieba.write.editor.b kUw;
    private e kUy;
    private View kVq;
    private View kVr;
    private TextView kVs;
    private com.baidu.tieba.c.d kVu;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String kTW = "";
    private boolean kTX = false;
    private WriteData jYy = null;
    private boolean kUK = false;
    private boolean kTZ = false;
    private boolean kUL = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText jYQ = null;
    private HeadImageView kUM = null;
    private View jYR = null;
    private LinearLayout jYT = null;
    private EditText jYU = null;
    private FeedBackModel kUc = null;
    private FeedBackTopListView kUN = null;
    private ArrayList<WritePrefixItemLayout> kUe = new ArrayList<>();
    private String iiY = null;
    private final KeyEvent gbq = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView kUP = null;
    private TextView jYV = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener ggh = null;
    private com.baidu.tbadk.core.dialog.a kUQ = null;
    private final Handler mHandler = new Handler();
    private boolean kUR = false;
    private String kUS = null;
    private RelativeLayout htL = null;
    private String dyQ = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int dyR = 0;
    private int kUT = 0;
    private WriteImagesInfo kUU = new WriteImagesInfo();
    private View mRootView = null;
    private GridView kUW = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a kUX = null;
    private ScrollView kUr = null;
    private EditText kUY = null;
    private View kUZ = null;
    private View kVa = null;
    private View kVb = null;
    private EditText kVc = null;
    private TextView kVd = null;
    private TextView kVe = null;
    private TextWatcher kVf = null;
    private TextWatcher kVg = null;
    private boolean kUs = false;
    private boolean kVh = false;
    private com.baidu.tbadk.core.view.a dGw = null;
    private String mFrom = "write";
    private File kVi = null;
    private TbImageView kVj = null;
    private View mBubbleView = null;
    private Dialog kVk = null;
    private LinearLayout kVl = null;
    private boolean kVn = false;
    private long kVo = -1000;
    private boolean kVp = false;
    private String gPr = "2";
    private int aCm = 0;
    private String mTopicId = "";
    private SpannableStringBuilder kUv = new SpannableStringBuilder();
    private boolean kVt = false;
    private boolean auO = false;
    private final b kUx = new b();
    private final HttpMessageListener kVv = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.iiY)) {
                    WriteActivity.this.iiY = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.ub(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.iiY)) {
                    WriteActivity.this.iiY = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.iiY);
                    WriteActivity.this.ub(true);
                }
            }
        }
    };
    private TbFaceManager.a kUz = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
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
    private final AntiHelper.a gqp = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d dza = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.bEu();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.jYy != null) {
                WriteActivity.this.kUx.aU(null);
                if (z) {
                    WriteActivity.this.gK(z);
                    if (WriteActivity.this.e(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    if (WriteActivity.this.jYy.getType() != 0 && WriteActivity.this.jYy.getType() != 9) {
                        if (WriteActivity.this.jYy.getType() != 7) {
                            if (WriteActivity.this.jYy.getType() == 1) {
                                w.d(WriteActivity.this.jYy.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.jYy.getType() == 5) {
                                w.d(WriteActivity.this.jYy.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            w.c("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            w.c(WriteActivity.this.jYy.getForumId(), (WriteData) null);
                        }
                        if (!v.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                            TiebaStatic.log(new an("c11731").cx("obj_id", WriteActivity.this.mTopicId));
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
                    WriteActivity.this.kUx.aU(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.kUx.KL(postWriteCallBackData.getErrorString());
                    WriteActivity.this.kUx.b(WriteActivity.this.jYQ, WriteActivity.this.jYU);
                } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aJL());
                    if (com.baidu.tbadk.s.a.wc(aaVar.aJK())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJK());
                        if (WriteActivity.this.kUL) {
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
    private final LocationModel.a dyY = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.40
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void aPp() {
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
            if (aVar != null && !StringUtils.isNull(aVar.cLZ())) {
                WriteActivity.this.a(2, true, aVar.cLZ());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener kkK = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.dyL.sW(false);
                    WriteActivity.this.dyL.eE(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.dyL.sW(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener kUA = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener kUB = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.43
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.dxg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cWh = WriteActivity.this.cWh();
            if (cWh >= 0 && cWh < WriteActivity.this.jYU.getText().length()) {
                WriteActivity.this.jYU.setSelection(cWh);
            }
        }
    };
    private boolean kUC = true;
    private final View.OnFocusChangeListener eWH = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.jYQ || view == WriteActivity.this.mBack || view == WriteActivity.this.jYV) {
                if (z) {
                    WriteActivity.this.kUC = true;
                    WriteActivity.this.cWi();
                    l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.jYQ);
                    if (WriteActivity.this.dxg != null) {
                        WriteActivity.this.dxg.aMV();
                    }
                } else if (view == WriteActivity.this.jYQ) {
                    WriteActivity.this.jYW.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.jYU && z) {
                WriteActivity.this.kUC = false;
                WriteActivity.this.cWi();
                l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.jYU);
                if (WriteActivity.this.dxg != null) {
                    WriteActivity.this.dxg.aMV();
                }
            }
            WriteActivity.this.cWn();
        }
    };
    private TextWatcher kUD = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String kUH = "";
        private String kUI;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kUI = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.kUI != null ? this.kUI.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cIw();
            WriteActivity.this.cWo();
            EditText cWA = WriteActivity.this.cWA();
            if (editable != null && cWA != null && cWA.getText() != null) {
                if (this.kUH == null || !this.kUH.equals(editable.toString())) {
                    if (WriteActivity.this.kUx != null) {
                        this.kUH = cWA.getText().toString();
                        WriteActivity.this.kUx.b(cWA, true);
                        return;
                    }
                    return;
                }
                cWA.setSelection(cWA.getSelectionEnd());
            }
        }
    };
    private TextWatcher kUE = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String kUI;
        private String kUJ = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kUI = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.kUI != null ? this.kUI.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cIw();
            EditText cWz = WriteActivity.this.cWz();
            if (editable != null && cWz != null && cWz.getText() != null) {
                if (this.kUJ == null || !this.kUJ.equals(editable.toString())) {
                    if (WriteActivity.this.kUx != null) {
                        this.kUJ = cWz.getText().toString();
                        WriteActivity.this.kUx.b(cWz, false);
                        return;
                    }
                    return;
                }
                cWz.setSelection(cWz.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0611a iRi = new a.InterfaceC0611a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0611a
        public void onRefresh() {
            WriteActivity.this.iiY = null;
            WriteActivity.this.ub(false);
            WriteActivity.this.dxg.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void aOZ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void aPa() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aPc();
        } else if (this.dyL.cMg()) {
            aOZ();
        } else {
            this.dyL.sW(false);
            a(1, true, (String) null);
            this.dyL.cMe();
        }
    }

    public void cWK() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
            if (this.kUw != null) {
                this.kUw.cVm();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aPc();
        } else if (this.dyL != null) {
            this.dyL.sW(false);
            a(1, true, (String) null);
            this.dyL.cMe();
        }
    }

    private void aPc() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.jW(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.dyL.cMi();
                } else {
                    WriteActivity.this.dyY.aPp();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.44
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.aEG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cWh() {
        int selectionEnd = cWz().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cWz().getText().getSpans(0, cWz().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cWz().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cWz().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWi() {
        if (this.dxg != null) {
            this.dxg.setBarLauncherEnabled(!this.kUC);
            this.dxg.setBarLauncherEnabled(true, 26);
            this.dxg.setBarLauncherEnabled(true, 2);
            this.dxg.setBarLauncherEnabled(true, 30);
            V(9, this.kUC ? false : true);
        }
    }

    private void V(int i, boolean z) {
        com.baidu.tbadk.editortools.g mo;
        if (this.dxg != null && (mo = this.dxg.mo(i)) != null) {
            if (z) {
                mo.display();
            } else {
                mo.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.kUs) {
            this.jYQ.setVisibility(8);
            if (this.jYy.getType() == 5) {
                this.kVb.setVisibility(8);
            } else {
                this.kVb.setVisibility(0);
            }
            a(this.kVe, this.kUY);
            a(this.kVd, this.kVc);
            cIw();
        }
        if (this.kUK) {
            this.kUC = true;
            cWi();
            if (this.dxg != null) {
                this.dxg.aMV();
            }
            this.jYQ.requestFocus();
            ShowSoftKeyPadDelay(this.jYQ);
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
            cXa();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                cWI();
            }
            uc(true);
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
        if (this.jYy.getType() == 0) {
            EA(this.aCm);
        }
        initUI();
        cWP();
        this.dyL = new LocationModel(getPageContext());
        this.dyL.a(this.dyY);
        registerListener(this.kkK);
        registerListener(this.kUA);
        cgh();
        cXd();
        if (this.kUs) {
            this.kUX.setEditorTools(this.dxg);
        } else {
            this.jYU.requestFocus();
        }
        cDC();
        cWI();
        cXb();
    }

    @SuppressLint({"ResourceAsColor"})
    private void cgh() {
        this.dxg = new EditorTools(getActivity());
        this.dxg.setBarMaxLauCount(5);
        this.dxg.setMoreButtonAtEnd(true);
        this.dxg.setBarBackgroundColorId(R.color.cp_bg_line_h);
        this.dxg.setBarLauncherType(1);
        this.dxg.gC(true);
        this.dxg.gD(true);
        switch (this.jYy.getType()) {
            case 4:
            case 5:
                cWN();
                break;
            default:
                cWj();
                break;
        }
        this.dxg.build();
        if (this.kUa != null) {
            this.kUa.addView(this.dxg);
        }
        cai();
        this.dxg.display();
        com.baidu.tbadk.editortools.g mo = this.dxg.mo(6);
        if (mo != null && !TextUtils.isEmpty(this.dyQ)) {
            ((View) mo).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.dyQ);
                }
            });
        }
        if (!this.kUs) {
            this.dxg.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.dxg.aMV();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.dxg.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.dxg.b(new com.baidu.tbadk.editortools.a(2, 26, HanziToPinyin.Token.SEPARATOR));
        }
        cWl();
    }

    private void cWL() {
        this.kUZ = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.kVb = this.kUZ.findViewById(R.id.live_post_title_container);
        this.kUY = (EditText) this.kUZ.findViewById(R.id.live_post_content);
        this.kUW = (GridView) this.kUZ.findViewById(R.id.photoLiveGridView);
        this.kVc = (EditText) this.kUZ.findViewById(R.id.live_post_title);
        this.kVd = (TextView) this.kUZ.findViewById(R.id.titleOverPlusNumber);
        this.kVe = (TextView) this.kUZ.findViewById(R.id.contentOverPlusNumber);
        this.kVa = this.kUZ.findViewById(R.id.live_interval_view);
        this.kVd.setText(String.valueOf(20));
        this.kVe.setText(String.valueOf(233));
        this.kUZ.setVisibility(0);
        this.kVd.setVisibility(0);
        this.kVe.setVisibility(0);
        this.kVc.setHint(R.string.tips_title_limit_new);
        this.kVc.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.kVh = true;
                    WriteActivity.this.kUC = true;
                    WriteActivity.this.cWi();
                    if (WriteActivity.this.dxg != null) {
                        WriteActivity.this.dxg.aMV();
                    }
                }
            }
        });
        if (this.jYy.getType() == 4) {
            this.kUY.setHint(R.string.live_write_input_content_new);
        } else if (this.jYy.getType() == 5) {
            this.kUY.setHint(R.string.live_write_input_content_update);
        }
        this.kUY.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.kVh = false;
                    WriteActivity.this.kUC = false;
                    WriteActivity.this.cWi();
                    if (WriteActivity.this.dxg != null) {
                        WriteActivity.this.dxg.aMV();
                    }
                }
            }
        });
        this.kUY.requestFocus();
        this.kUY.addTextChangedListener(TP());
        this.kVc.requestFocus();
        this.kVc.addTextChangedListener(TP());
        this.kVc.setOnClickListener(this.kUB);
        this.kUY.setOnClickListener(this.kUB);
        this.kUX = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.kUW);
        this.kUX.Eu(6);
        this.kUW.setAdapter((ListAdapter) this.kUX);
        View findViewById = this.kUZ.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void cVT() {
                WriteActivity.this.cWY();
            }
        });
        cWM();
    }

    private void cWM() {
        if (this.jYy.getType() == 0) {
            if (this.jYy.getTitle() != null) {
                this.kVc.setText(this.jYy.getTitle());
                this.kVc.setSelection(this.jYy.getTitle().length());
                return;
            }
            return;
        }
        if (this.jYy.getType() == 1 || this.jYy.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.kUs) {
            cWW();
        }
        if (this.dxg.aOA()) {
            this.dxg.aMV();
        }
        EA(0);
    }

    private void EA(int i) {
        if (this.writeImagesInfo != null && this.jYy != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.jYy.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.jYy.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.gPr);
            albumActivityConfig.setProfessionZone(this.jYy.getProZone());
            albumActivityConfig.setFrsTabInfo(this.kOH);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void cWN() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.dxg.aI(arrayList);
        com.baidu.tbadk.editortools.l mr = this.dxg.mr(5);
        if (mr != null) {
            mr.dxQ = 2;
        }
        this.dxg.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.dxg.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void cWj() {
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
            this.dxg.b(dVar);
        }
        Boolean cWT = cWT();
        if (!this.kUK && cWT != null && cWT.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.cMD() && s.d(this.jYy.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar5 = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar5.dxQ = 3;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dxg.b(lVar5);
            }
        }
        this.dxg.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 4));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask2 != null && (lVar4 = (com.baidu.tbadk.editortools.l) runTask2.getData()) != null) {
            lVar4.dxQ = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dxg.b(lVar4);
            }
        }
        this.dxg.b(new com.baidu.tbadk.editortools.k(getActivity(), 6));
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask3 != null && (lVar3 = (com.baidu.tbadk.editortools.l) runTask3.getData()) != null) {
            lVar3.dxQ = 7;
            this.dxg.b(lVar3);
        }
        this.dxg.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 8));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask4 != null && (lVar2 = (com.baidu.tbadk.editortools.l) runTask4.getData()) != null) {
            lVar2.dxS = true;
            lVar2.dxQ = 9;
            lVar2.dxM = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dxg.b(lVar2);
            }
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class);
        if (runTask5 != null && (lVar = (com.baidu.tbadk.editortools.l) runTask5.getData()) != null) {
            lVar.dxS = true;
            lVar.dxQ = 10;
            lVar.dxM = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dxg.b(lVar);
            }
        }
        if (this.kUg == null) {
            if (this.kUw == null) {
                this.kUw = new com.baidu.tieba.write.editor.b(getActivity(), this.gPr);
                this.kUw.bz(this.jYy.getForumId(), this.privateThread);
                this.kUw.tV(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.kUw.cVi();
                this.kUw.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                cWK();
            }
            if (!v.isEmpty(this.mList)) {
                this.kUw.cVi();
            }
            this.dxg.b(this.kUw);
        }
        this.dxg.aI(arrayList);
        com.baidu.tbadk.editortools.l mr = this.dxg.mr(5);
        if (mr != null) {
            mr.dxQ = 1;
        }
    }

    private void cWk() {
        if (this.kUy != null) {
            this.kUy.hideTip();
        }
    }

    private void cWl() {
        if (this.kUy == null) {
            this.kUy = new e(getPageContext());
        }
        this.kUy.c(this.dxg);
    }

    private void cai() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.cWy()) {
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
                            if (qVar.aJB() == EmotionGroupType.BIG_EMOTION || qVar.aJB() == EmotionGroupType.USER_COLLECT) {
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
                                    WriteActivity.this.uc(true);
                                    WriteActivity.this.cIw();
                                }
                            } else if (WriteActivity.this.cWy()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(qVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.cWB();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.cnM();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.cXa();
                        WriteActivity.this.cIw();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.EB(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new an("c12612").X("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.kUg == null) {
                            WriteActivity.this.aPd();
                            return;
                        }
                        switch (WriteActivity.this.dyR) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.aPa();
                                    return;
                                } else {
                                    ab.e(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.aOZ();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.dyL != null) {
                            WriteActivity.this.dyL.sW(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.iiY = null;
                        } else {
                            WriteActivity.this.iiY = (String) aVar.data;
                        }
                        WriteActivity.this.ub(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        an anVar = new an("c10645");
                        if (WriteActivity.this.jYy != null) {
                            str = WriteActivity.this.jYy.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.cx("fid", str);
                        TiebaStatic.log(anVar);
                        if (WriteActivity.this.jYy == null || (videoInfo = WriteActivity.this.jYy.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.dxg.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.dxg.aOA()) {
                                        WriteActivity.this.dxg.aMV();
                                        WriteActivity.this.dxg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.dxg.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                        WriteActivity.this.dxg.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.dxg.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.dxg.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.jYy.setVideoInfo(null);
                        WriteActivity.this.cIw();
                        if (WriteActivity.this.jYU != null) {
                            WriteActivity.this.jYU.requestFocus();
                        }
                        WriteActivity.this.dxg.aMV();
                        WriteActivity.this.dxg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.jYU);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new an("c12612").X("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.dxg.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.kTX = true;
                        WriteActivity.this.tZ(true);
                        if (!WriteActivity.this.cWA().isFocused() || WriteActivity.this.kUb.getVisibility() != 0) {
                            WriteActivity.this.kTW = "from_content";
                        } else {
                            WriteActivity.this.kTW = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        if (WriteActivity.this.kUb.getVisibility() == 0) {
                            if (WriteActivity.this.kUb.hasFocus()) {
                                WriteActivity.this.jYU.requestFocus();
                                WriteActivity.this.jYU.setSelection(WriteActivity.this.jYU.getText().toString().length());
                            }
                            WriteActivity.this.kUb.setVisibility(8);
                            WriteActivity.this.dxg.mo(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.kUb.setVisibility(0);
                            WriteActivity.this.kUb.requestFocus();
                            WriteActivity.this.dxg.mo(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.cIw();
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
        this.dxg.setActionListener(16, bVar);
        this.dxg.setActionListener(14, bVar);
        this.dxg.setActionListener(24, bVar);
        this.dxg.setActionListener(3, bVar);
        this.dxg.setActionListener(10, bVar);
        this.dxg.setActionListener(11, bVar);
        this.dxg.setActionListener(12, bVar);
        this.dxg.setActionListener(13, bVar);
        this.dxg.setActionListener(15, bVar);
        this.dxg.setActionListener(18, bVar);
        this.dxg.setActionListener(20, bVar);
        this.dxg.setActionListener(25, bVar);
        this.dxg.setActionListener(27, bVar);
        this.dxg.setActionListener(29, bVar);
        this.dxg.setActionListener(43, bVar);
        this.dxg.setActionListener(56, bVar);
        this.dxg.setActionListener(48, bVar);
        this.dxg.setActionListener(46, bVar);
        this.dxg.setActionListener(49, bVar);
        this.dxg.setActionListener(47, bVar);
        this.dxg.setActionListener(55, bVar);
        this.dxg.setActionListener(58, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EB(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPd() {
        if (this.dyL.brr()) {
            if (this.dyL.cMg()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.cMb().getLocationData().cLZ());
                return;
            }
            a(1, true, (String) null);
            this.dyL.cMe();
            return;
        }
        a(0, true, (String) null);
    }

    protected void cIn() {
        if (this.dyM != null) {
            this.dyM.cancelLoadData();
        }
        if (this.kUc != null) {
            this.kUc.cancelLoadData();
        }
        if (this.dyL != null) {
            this.dyL.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cWk();
        TiebaPrepareImageService.StopService();
        cIn();
        cWS();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.kUV != null) {
            this.kUV.destroy();
        }
        if (this.kVu != null) {
            this.kVu.zG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWm() {
        if (this.jYy != null && this.jYy.getType() == 2 && this.kUR) {
            finish();
        } else if (this.jYy == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.jYy.setTitle(cWA().getText().toString());
            this.jYy.setContent(cWz().getText().toString());
            int type = this.jYy.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    w.c(this.jYy.getForumId(), this.jYy);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    w.c("24591571", this.jYy);
                }
            } else if (type == 1) {
                w.d(this.jYy.getThreadId(), this.jYy);
            } else if (type == 4) {
                w.c(this.jYy.getForumId() + "photolive", this.jYy);
            } else if (type == 5) {
                w.d(this.jYy.getThreadId() + "updatephotolive", this.jYy);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.jYX != null && this.jYX.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.jYX, getPageContext().getPageActivity());
                return true;
            } else if (this.dxg.aOA()) {
                this.dxg.aMV();
                return true;
            } else {
                cIn();
                cWm();
                return true;
            }
        }
        if (i == 67 && (text = cWz().getText()) != null) {
            int selectionStart = cWz().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cWz().onKeyDown(67, this.gbq);
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
        getLayoutMode().onModeChanged(this.htL);
        getLayoutMode().onModeChanged(this.kVl);
        am.setBackgroundColor(this.htL, R.color.cp_bg_line_e);
        if (this.kVj != null && (i == 1 || i == 4)) {
            this.kVj.setBorderColor(am.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.jYV, R.color.cp_link_tip_a, 1);
        cWi();
        am.setBackgroundColor(this.jYR, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.kVa, R.color.cp_bg_line_c);
        am.setBackgroundColor(cWA(), R.color.cp_bg_line_e);
        am.setImageResource(this.iLj, R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.iiY)) {
            am.setBackgroundColor(cWz(), R.color.cp_bg_line_e);
        }
        cIw();
        this.dxg.onChangeSkinType(i);
        if (this.kUq != null) {
            this.kUq.aHS();
        }
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.kUV.kVQ.notifyDataSetChanged();
        cWn();
        cWo();
        ub(false);
        if (this.kUx != null) {
            this.kUx.c(cWA(), cWz());
        }
        if (this.kSA != null) {
            this.kSA.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWn() {
        if (this.jYQ.hasFocus()) {
            this.jYQ.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.jYQ.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.jYU.hasFocus()) {
            this.jYU.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.jYU.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWo() {
        if (this.jYQ != null && this.jYQ.getText() != null && this.jYQ.getText().toString() != null && this.jYQ.getPaint() != null) {
            if (this.jYQ.getText().toString().length() == 0) {
                this.jYQ.getPaint().setFakeBoldText(false);
            } else if (this.jYQ.getText().toString().length() > 0) {
                this.jYQ.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.dGw = new com.baidu.tbadk.core.view.a(getPageContext());
        this.kUs = this.jYy.getType() == 4 || 5 == this.jYy.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aGG().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.kUP = (TextView) findViewById(R.id.btn_image_problem);
        cWr();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jYV.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.jYV.setLayoutParams(layoutParams);
        this.jYV.setOnFocusChangeListener(this.eWH);
        this.kUr = (ScrollView) findViewById(R.id.write_scrollview);
        this.kUr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.jYU != null) {
                        l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.jYU);
                    }
                    if (WriteActivity.this.dxg != null) {
                        WriteActivity.this.dxg.aMV();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.kUN = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.kUO = findViewById(R.id.feedback_divider);
        this.htL = (RelativeLayout) findViewById(R.id.parent);
        this.kUa = (LinearLayout) findViewById(R.id.tool_view);
        this.kUa.setContentDescription(IStringUtil.TOP_PATH);
        this.kUb = (LinearLayout) findViewById(R.id.title_view);
        this.jYR = findViewById(R.id.interval_view);
        this.kVq = findViewById(R.id.hot_topic_fourm_view);
        this.kVr = findViewById(R.id.hot_topic_divider);
        this.kUu = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.kVs = (TextView) findViewById(R.id.change_one_tv);
        cIv();
        if (this.kUs) {
            this.kUr.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            cWL();
        } else {
            this.kUV = new g(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.kUV.tT(false);
            } else {
                g gVar = this.kUV;
                if (this.jYy.getType() != 0 && this.jYy.getType() != 9) {
                    z = false;
                }
                gVar.tT(z);
            }
        }
        cIx();
        if (this.kUK || this.kTZ) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().dbc) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.jYT = (LinearLayout) findViewById(R.id.post_content_container);
        this.jYT.setDrawingCacheEnabled(false);
        this.jYT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.dxg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.jYU.requestFocus();
            }
        });
        this.iLg = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.iLh = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.iLj = (ImageView) findViewById(R.id.iv_delete_voice);
        this.iLj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cnM();
            }
        });
        this.mBack.setOnFocusChangeListener(this.eWH);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cIn();
                WriteActivity.this.cWm();
            }
        });
        this.kUP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        cWu();
        o(cWT());
        cWw();
        cWq();
        cWQ();
        cWR();
        cWi();
        cWv();
        cIu();
        cWC();
        if (this.jYy.getType() == 4 && this.jYZ != null && this.kUd != null) {
            this.jYZ.setVisibility(8);
            this.kUd.setVisibility(8);
        }
        cIw();
        cWO();
        cVz();
        cWp();
    }

    private void cWp() {
        this.kSA = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.kSA.setData(this.kOH);
        this.kSA.setActivity(this);
    }

    private void cVz() {
        if (this.mName != null && this.jYy != null && this.jYy.getProZone() == 1) {
            this.mName.setText(R.string.write_zone_profession_title);
        }
    }

    private void cWq() {
        String str;
        String str2;
        if (this.jYy != null) {
            switch (this.jYy.getType()) {
                case 0:
                case 9:
                    if (this.kUK || this.kTZ) {
                        if (this.kUL) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.gPr != null && this.gPr.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                    } else if (this.gPr != null && this.gPr.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.jYy.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.jYy.getForumName() + getResources().getString(R.string.bar));
                        this.jYQ.setVisibility(8);
                        String str3 = this.gnq + HanziToPinyin.Token.SEPARATOR + this.gno;
                        if (!StringUtils.isNull(str3)) {
                            this.jYU.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.jYQ.setVisibility(0);
                    this.jYU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.jYU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.jYQ.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.jYU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.jYy.getFloorNum() + 1)));
                    this.kVa.setVisibility(8);
                    return;
                case 7:
                    this.jYQ.setVisibility(0);
                    this.jYU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void cWr() {
        if (this.jYy.getType() == 7) {
            this.jYV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.jYV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void cWs() {
        if (this.jYy != null && this.jYy.getType() == 0 && this.jYy.getType() == 9 && !this.kUK && !this.kTZ && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = aq.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && cWA() != null) {
                cWA().setText(cutStringWithSuffix);
                cWA().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.iLg.setVisibility(0);
            this.iLh.setVoiceModel(voiceModel);
            this.iLh.cMC();
            cIw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnM() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.iLg.setVisibility(8);
        this.iLh.bOE();
        this.iLh.setVoiceModel(null);
        com.baidu.tbadk.editortools.l mr = this.dxg.mr(6);
        if (mr != null && mr.dxa != null) {
            mr.dxa.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cIw();
    }

    private void cWt() {
        this.kUl = null;
        this.kUn = -1;
        this.kUp = -1;
        z ta = y.bFO().ta(1);
        if (ta != null) {
            this.kUl = ta.gsS;
            this.kUn = getIntent().getIntExtra("category_id", -1);
            if (this.kUl != null && !this.kUl.isEmpty() && this.kUn >= 0) {
                this.kUm = new x();
                this.kUm.gsO = 0;
                this.kUm.name = getPageContext().getResources().getString(R.string.category_auto);
                this.kUp = this.kUm.gsO;
                this.kUo = this.kUm.name;
                for (x xVar : this.kUl) {
                    if (xVar.gsO == this.kUn) {
                        this.kUp = xVar.gsO;
                        this.kUo = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cWu() {
        if (this.kUl != null && !this.kUl.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.kUq = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.kUq.setText(this.kUo);
            this.kUq.setCategoryContainerData(this.kUl, this.kUm, this.kUp);
            this.kUq.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, com.baidu.tieba.frs.at atVar) {
                    if (atVar != null) {
                        WriteActivity.this.kUq.setText(atVar.name);
                        WriteActivity.this.jYy.setCategoryTo(atVar.gsO);
                        WriteActivity.this.kUp = atVar.gsO;
                        WriteActivity.this.kUq.cVV();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.kUq.cVU();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cWA());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cWz());
                }
            });
        }
    }

    private void cWO() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.kUF = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.kUF.setTitle(R.string.no_disturb_start_time);
        this.kUF.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.kUF);
        this.kUF.setButton(-2, getPageContext().getString(R.string.cancel), this.kUF);
        return this.kUF;
    }

    private void cWv() {
        this.kUh = (RelativeLayout) findViewById(R.id.addition_container);
        this.kUi = (TextView) findViewById(R.id.addition_create_time);
        this.kUj = (TextView) findViewById(R.id.addition_last_time);
        this.kUk = (TextView) findViewById(R.id.addition_last_content);
        if (this.kUg != null) {
            this.kUh.setVisibility(0);
            this.kUi.setText(getPageContext().getString(R.string.write_addition_create) + aq.getFormatTime(this.kUg.getCreateTime() * 1000));
            if (this.kUg.getAlreadyCount() == 0) {
                this.kUj.setVisibility(8);
            } else {
                this.kUj.setText(getPageContext().getString(R.string.write_addition_last) + aq.getFormatTime(this.kUg.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.kUg.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.kUk.setText(lastAdditionContent);
            } else {
                this.kUk.setVisibility(8);
            }
            cWz().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.kUg.getAlreadyCount()), Integer.valueOf(this.kUg.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.kUh.setVisibility(8);
    }

    private void cIu() {
        this.jYZ = findViewById(R.id.post_prefix_layout);
        if (this.kVu == null) {
            this.kVu = new com.baidu.tieba.c.d(getPageContext(), this.jYZ);
            this.kVu.ck(R.drawable.bg_tip_blue_up_left);
            this.kVu.cj(16);
            this.kVu.kB(true);
            this.kVu.setUseDirectOffset(true);
            this.kVu.rB(l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.jYW = (TextView) findViewById(R.id.post_prefix);
        this.kUd = findViewById(R.id.prefix_divider);
        this.jYY = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.jYZ.setVisibility(0);
            this.kVu.d(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.jYz = 0;
            this.jYZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").cx("fid", WriteActivity.this.jYy.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.jYW.setVisibility(0);
                    WriteActivity.this.jYZ.setSelected(true);
                    am.setImageResource(WriteActivity.this.jYY, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.jYX, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.dxg.aMV();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.jYQ);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.jYU);
                }
            });
            this.jYW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").cx("fid", WriteActivity.this.jYy.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.jYW.setSelected(true);
                    am.setImageResource(WriteActivity.this.jYY, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.jYX, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.dxg.aMV();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cWA());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cWz());
                }
            });
            this.jYX = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.jYX.a(this);
            this.jYX.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.jYX.setOutsideTouchable(true);
            this.jYX.setFocusable(true);
            this.jYX.setOnDismissListener(this);
            this.jYX.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            am.getColor(R.color.cp_cont_c);
            am.setBackgroundResource(this.jYW, R.color.cp_bg_line_d);
            am.setImageResource(this.jYY, R.drawable.icon_arrow_gray_down);
            this.jYW.setTextColor(color);
            this.kUe.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.kUe.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.tQ(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.tQ(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.jYX.addView(writePrefixItemLayout);
            }
            this.jYX.setCurrentIndex(0);
            this.jYW.setText(prefixs.get(0));
            Ez(0);
            return;
        }
        this.jYZ.setVisibility(8);
    }

    private void cWP() {
        if (this.kUK && this.jYy != null) {
            this.kUN.setVisibility(0);
            this.kUO.setVisibility(0);
            this.kUc = new FeedBackModel(getPageContext());
            this.kUc.Ld(this.jYy.getForumName());
            this.kUc.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.kUN.setVisibility(8);
                        WriteActivity.this.kUO.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.kUN.setVisibility(8);
                        WriteActivity.this.kUO.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.kUN.a(feedBackModel.cVX(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void cWw() {
        this.jYV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (WriteActivity.this.kUx.a(WriteActivity.this.jYQ, WriteActivity.this.jYU)) {
                        WriteActivity.this.showToast(WriteActivity.this.kUx.cUB());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cWA());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.cWz());
                    WriteActivity.this.dxg.aMV();
                    if (WriteActivity.this.jYy.getType() != 7) {
                        if (WriteActivity.this.kUK) {
                            WriteActivity.this.cWF();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            an anVar = new an("c12102");
                            anVar.X("obj_type", StringUtils.isNull(WriteActivity.this.jYy.getForumName()) ? 1 : 2);
                            TiebaStatic.log(anVar);
                            WriteActivity.this.cWG();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.cWF();
                    }
                    TiebaStatic.log(new an("c12262").cx("obj_locate", WriteActivity.this.gPr));
                }
            }
        });
    }

    protected void cWQ() {
        this.kUQ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.kUQ.sS(getPageContext().getString(R.string.is_save_draft)).fH(false).a(getPageContext().getString(R.string.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.jYy.setTitle(WriteActivity.this.cWA().getText().toString());
                WriteActivity.this.jYy.setContent(WriteActivity.this.cWz().getText().toString());
                int type = WriteActivity.this.jYy.getType();
                if (type == 0 || type == 9) {
                    w.c(WriteActivity.this.jYy.getForumId(), WriteActivity.this.jYy);
                } else if (type == 1) {
                    w.d(WriteActivity.this.jYy.getThreadId(), WriteActivity.this.jYy);
                }
                WriteActivity.this.showToast(R.string.draft_save_success);
                WriteActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.26.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WriteActivity.this.finish();
                    }
                }, 1000L);
            }
        }).b(getPageContext().getString(R.string.not_save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                int type = WriteActivity.this.jYy.getType();
                if (type == 0 || type == 9) {
                    w.c(WriteActivity.this.jYy.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    w.d(WriteActivity.this.jYy.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.kUQ.b(getPageContext());
    }

    protected void cIv() {
        this.kUM = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.kUM.setIsRound(true);
        this.kUM.setDrawBorder(false);
        this.kUM.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String tn = o.tn(currentPortrait);
            this.kUM.setUrl(tn);
            this.kUM.startLoad(tn, 12, false);
        }
        if (this.jYy.isUserFeedback()) {
            this.kUM.setVisibility(0);
        }
        this.jYQ = (EditText) findViewById(R.id.post_title);
        this.jYQ.setOnClickListener(this.kUB);
        this.jYQ.setOnFocusChangeListener(this.eWH);
        if (this.jYy.getType() == 0 || this.jYy.getType() == 9 || this.jYy.getType() == 7) {
            if (this.jYy.getTitle() != null) {
                this.jYQ.setText(this.jYy.getTitle());
                this.jYQ.setSelection(this.jYy.getTitle().length());
            } else if (this.kUL) {
                this.jYQ.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.jYy.getType() == 1 || this.jYy.getType() != 2) {
        }
        this.jYQ.addTextChangedListener(this.kUD);
        if (!this.jYy.getHaveDraft()) {
            cWs();
            this.kVp = true;
        }
        if (this.jYy.isUserFeedback()) {
            this.jYQ.setHint(getResources().getString(R.string.feedback_title_hint));
        } else {
            this.jYQ.setHint(getResources().getString(R.string.post_title_hint));
        }
    }

    private TextWatcher TP() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int kVy;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.cIw();
                if (WriteActivity.this.kUs) {
                    this.kVy = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.kVy);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.kUs || !WriteActivity.this.kVh) {
                    if (WriteActivity.this.kUs) {
                        if (this.mEditText != WriteActivity.this.kUY || this.mTextView != WriteActivity.this.kVe) {
                            this.mEditText = WriteActivity.this.kUY;
                            this.mTextView = WriteActivity.this.kVe;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.kVc || this.mTextView != WriteActivity.this.kVd) {
                    this.mEditText = WriteActivity.this.kVc;
                    this.mTextView = WriteActivity.this.kVd;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.kUs && this.kVh) {
            if (this.kVf != null) {
                this.kVc.removeTextChangedListener(this.kVf);
            }
            this.kVf = textWatcher;
        } else if (this.kUs) {
            if (this.kVg != null) {
                this.kUY.removeTextChangedListener(this.kVg);
            }
            this.kVg = textWatcher;
        }
        return textWatcher;
    }

    private long j(EditText editText) {
        if (editText == this.kUY) {
            return 233L;
        }
        if (editText != this.kVc) {
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
        return com.baidu.tieba.write.b.a.o(editText.getText().toString().trim());
    }

    protected void cIx() {
        this.jYU = (EditText) findViewById(R.id.post_content);
        this.jYU.setDrawingCacheEnabled(false);
        this.jYU.setOnClickListener(this.kUB);
        if (this.jYy.getContent() != null && this.jYy.getContent().length() > 0) {
            SpannableString aB = TbFaceManager.aPU().aB(getPageContext().getPageActivity(), this.jYy.getContent());
            this.jYU.setText(aB);
            this.jYU.setSelection(aB.length());
        } else if (this.jYy.getType() == 2) {
            if (this.kUR) {
                if (this.kUS != null && this.kUS.length() > 0) {
                    this.jYU.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.kUS}));
                    this.jYU.setSelection(this.jYU.getText().length());
                }
            } else if (this.jYy.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.jYy.getFloorNum()));
                this.jYU.setText(format);
                this.jYU.setSelection(format.length());
            }
        }
        this.jYU.setOnFocusChangeListener(this.eWH);
        this.jYU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.dxg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.jYU.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.jYU.addTextChangedListener(this.kUE);
        if (this.jYy.getType() == 0) {
            this.kVt = true;
        } else {
            ub(true);
            this.kVt = false;
        }
        if (this.jYy.isUserFeedback()) {
            this.jYU.setHint(R.string.write_input_content);
        } else {
            this.jYU.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void ub(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.kUs) {
            cWz().setPadding(0, 0, 0, 0);
            cWz().setBackgroundDrawable(null);
            am.setBackgroundColor(cWz(), R.color.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.iiY) && this.kUg == null) {
                com.baidu.adp.lib.e.c.gr().a(this.iiY, 19, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass29) aVar, str, i);
                        if (aVar != null && aVar.getRawBitmap() != null && aVar.getPadding() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.cWz().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.cWz(), true, WriteActivity.this.iRi);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cWy() {
        int i = 5000;
        if (this.kUg != null) {
            i = 1000;
        }
        return cWz().getText() != null && cWz().getText().length() >= i;
    }

    private void vi(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.kTW)) {
                this.kTW = "";
                cWz().requestFocus();
                if (cWz().getText() != null && cWz().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cWz().getSelectionStart();
                    editable = cWz().getText();
                }
            } else if ("from_title".equals(this.kTW)) {
                this.kTW = "";
                cWA().requestFocus();
                if (cWA().getText() != null && cWA().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = cWA().getSelectionStart();
                    editable = cWA().getText();
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
    public void tZ(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.jYy != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.jYy.getForumId(), 0L), this.jYy.getFirstDir(), this.jYy.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(q qVar) {
        if (((ImageSpan[]) cWz().getText().getSpans(0, cWz().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.kUf == null) {
                this.kUf = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            this.kUf.show();
            return;
        }
        String name = qVar.getName();
        final EmotionGroupType aJB = qVar.aJB();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.e.c.gr().a(name, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.cWz().getSelectionStart(), aVar, aJB);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cWz() != null && cWz().getText() != null) {
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
                int selectionStart = cWz().getSelectionStart() - 1;
                if (cWz().getText().length() > 1 && selectionStart >= 0 && cWz().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cWz().getText().insert(cWz().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cWz().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cWz().getText().insert(cWz().getSelectionStart(), spannableString2);
            }
            Editable text = cWz().getText();
            if (text != null) {
                this.kUv.clear();
                this.kUv.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.kUv);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cWz().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cWz().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cWz().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cWz() {
        return this.kUs ? this.kUY : this.jYU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cWA() {
        return this.kUs ? this.kVc : this.jYQ;
    }

    protected void cWB() {
        Editable text;
        if (cWz() != null && (text = cWz().getText()) != null) {
            int selectionStart = cWz().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cWz().onKeyDown(67, this.gbq);
            }
            cWz().onKeyDown(67, this.gbq);
            int selectionStart2 = cWz().getSelectionStart();
            if (text != null) {
                this.kUv.clear();
                this.kUv.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.kUv);
                cWz().setSelection(selectionStart2);
            }
        }
    }

    private void o(Boolean bool) {
        String str = null;
        if (this.jYy != null) {
            str = this.jYy.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.kUK = true;
        }
    }

    private void cWR() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void cWS() {
        try {
            if (this.kUQ != null) {
                this.kUQ.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.dGw.setCancelListener(null);
        this.dGw.setTipString(R.string.sending);
        this.dGw.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.dGw.setDialogVisiable(false);
    }

    private Boolean cWT() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.dyQ = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void cIw() {
        if (this.jYy != null) {
            String str = "";
            String str2 = "";
            if (cWA() != null) {
                str = cWA().getText().toString();
            }
            if (cWz() != null) {
                str2 = cWz().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.jYy.getType() == 0 || this.jYy.getType() == 9 || this.jYy.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.jYz == v.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.jYy.setIsNoTitle(true);
                        } else if (this.kUb.getVisibility() == 0) {
                            this.jYy.setIsNoTitle(false);
                            ua(true);
                            return;
                        }
                    } else if (this.kUb.getVisibility() == 0) {
                        this.jYy.setIsNoTitle(false);
                        ua(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.jYy.setIsNoTitle(true);
                } else if (this.kUb.getVisibility() == 0) {
                    this.jYy.setIsNoTitle(false);
                    ua(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.kUs) {
                    ua(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    ua(true);
                }
            }
            if (this.jYy.getType() == 4) {
                ua(m(this.kUY) && l(this.kVc));
            } else if (this.jYy.getType() == 5) {
                ua(m(this.kUY));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                ua(true);
            } else if (this.jYy.getVideoInfo() != null) {
                ua(true);
            } else {
                ua(false);
            }
        }
    }

    public void ua(boolean z) {
        if (z) {
            am.setNavbarTitleColor(this.jYV, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.jYV.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.jYV, R.color.cp_cont_d, 1);
        this.jYV.setEnabled(false);
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
        String str;
        this.dyM = new NewWriteModel(this);
        this.dyM.b(this.dza);
        registerListener(this.kVv);
        this.ggh = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.cIn();
            }
        };
        this.jYy = new WriteData();
        if (bundle != null) {
            this.jYy.setType(bundle.getInt("type", 0));
            this.jYy.setForumId(bundle.getString("forum_id"));
            this.jYy.setForumName(bundle.getString("forum_name"));
            this.jYy.setFirstDir(bundle.getString("forum_first_dir"));
            this.jYy.setSecondDir(bundle.getString("forum_second_dir"));
            this.jYy.setThreadId(bundle.getString("thread_id"));
            this.jYy.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.jYy.setFloorNum(bundle.getInt("floor_num", 0));
            this.kUK = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.kUL = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.kUR = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.kUS = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.dyK = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.kUg = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.jYy.setIsAddition(this.kUg != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.kUT = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.jYy.setTitle(bundle.getString("write_title"));
            this.jYy.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.jYy.setTopicId(this.mTopicId);
            this.gPr = bundle.getString("KEY_CALL_FROM");
            this.aCm = bundle.getInt("album_thread");
            this.kOH = (FrsTabInfoData) bundle.getSerializable("tab_list");
            str = string;
        } else {
            Intent intent = getIntent();
            this.jYy.setType(intent.getIntExtra("type", 0));
            this.jYy.setForumId(intent.getStringExtra("forum_id"));
            this.jYy.setForumName(intent.getStringExtra("forum_name"));
            this.jYy.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.jYy.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.jYy.setThreadId(intent.getStringExtra("thread_id"));
            this.jYy.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.jYy.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.kUK = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.kUL = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.kUR = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.kUS = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.kUg = (AdditionData) intent.getSerializableExtra("addition_data");
            this.jYy.setIsAddition(this.kUg != null);
            this.jYy.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.kUT = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.gnp = intent.getStringExtra("more_forum_img");
            this.gnq = intent.getStringExtra("more_forum_title");
            this.gno = intent.getStringExtra("more_forum_url");
            this.jYy.setTitle(intent.getStringExtra("write_title"));
            this.jYy.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.jYy.setTopicId(this.mTopicId);
            this.gPr = intent.getStringExtra("KEY_CALL_FROM");
            this.aCm = intent.getIntExtra("album_thread", 0);
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.kOH = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            str = stringExtra;
        }
        if (this.jYy.getType() == 9) {
            this.jYy.setEntranceType(1);
        } else if (this.jYy.getType() == 10) {
            this.jYy.setEntranceType(2);
            this.jYy.setType(9);
        } else if (this.jYy.getType() == 0) {
            this.jYy.setEntranceType(3);
        }
        this.jYy.setIsUserFeedback(this.kUK);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.jYy.getType() == 4 ? 6 : 9);
        this.jYy.setWriteImagesInfo(this.writeImagesInfo);
        if (this.jYy.getType() == 0 || this.jYy.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                w.c(this.jYy.getForumId(), this);
            }
        } else if (this.jYy.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                w.c("24591571", this);
            }
        } else if (this.jYy.getType() == 1) {
            w.a(this.jYy.getThreadId(), this);
        } else if (this.jYy.getType() == 4) {
            w.c(this.jYy.getForumId() + "photolive", this);
        } else if (this.jYy.getType() == 5) {
            w.a(this.jYy.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.iiY = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.jYy != null && this.jYy.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.jYy.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.kTZ = true;
        }
        cWt();
        try {
            this.kVi = cXc();
        } catch (Throwable th) {
            this.kVi = null;
        }
    }

    private void cWC() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.jYQ.setText(com.baidu.tbadk.plugins.b.vK(com.baidu.tbadk.plugins.b.vL(hotTopicBussinessData.mTopicName)));
            this.jYQ.setMovementMethod(com.baidu.tieba.view.c.cTP());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) v.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString vK = com.baidu.tbadk.plugins.b.vK(com.baidu.tbadk.plugins.b.vL(hotTopicBussinessData.mTopicName));
            if (vK != null) {
                this.jYQ.setText(vK);
            }
            this.kUu.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.w.a
    public void a(WriteData writeData) {
        String str;
        String vL;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            if (writeData != null) {
                if (this.jYy != null) {
                    this.jYy.setHaveDraft(true);
                    if (com.baidu.adp.lib.util.k.isEmpty(cWA().getText().toString()) || this.kVp || ((this.kUK || this.kTZ) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                        if (com.baidu.adp.lib.util.k.isEmpty(this.jYy.getTitle())) {
                            this.jYy.setTitle(writeData.getTitle());
                        }
                        if (!v.isEmpty(this.mList)) {
                            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.getItem(this.mList, 0);
                            if (hotTopicBussinessData == null) {
                                str = null;
                            } else {
                                str = hotTopicBussinessData.mTopicName;
                            }
                            if (StringUtils.isNull(str)) {
                                vL = this.jYy.getTitle();
                            } else {
                                vL = com.baidu.tbadk.plugins.b.vL(str);
                            }
                            SpannableString vK = com.baidu.tbadk.plugins.b.vK(vL);
                            if (vK != null) {
                                cWA().setText(vK);
                                cWA().setSelection(vK.length() > vL.length() ? vL.length() : vK.length());
                            }
                        } else {
                            SpannableString vK2 = com.baidu.tbadk.plugins.b.vK(this.jYy.getTitle());
                            if (vK2 != null) {
                                cWA().setText(vK2);
                                cWA().setSelection(this.jYy.getTitle().length() > vK2.length() ? vK2.length() : this.jYy.getTitle().length());
                            }
                        }
                    }
                    if (this.jYy != null && !this.jYy.getHaveDraft()) {
                        cWs();
                    }
                    if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.copy(writeData.getVideoInfo());
                        this.jYy.setVideoInfo(videoInfo);
                        this.dxg.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                    }
                    if ((com.baidu.adp.lib.util.k.isEmpty(cWz().getText().toString()) || this.kUK || this.kTZ) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                        this.jYy.setContent(writeData.getContent());
                        SpannableString a2 = TbFaceManager.aPU().a(getPageContext().getPageActivity(), this.jYy.getContent(), this.kUz);
                        cWz().setText(a2);
                        cWz().setSelection(a2.length());
                        if (this.kUs) {
                            a(this.kVe, this.kUY);
                        }
                    }
                    if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                        this.writeImagesInfo = writeData.getWriteImagesInfo();
                        this.jYy.setWriteImagesInfo(this.writeImagesInfo);
                        cXa();
                        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                            cWI();
                        }
                        uc(false);
                    }
                    if (writeData.getType() == 4 || writeData.getType() == 5) {
                        cWU();
                    }
                    cIw();
                    int categoryTo = writeData.getCategoryTo();
                    if (categoryTo >= 0 && this.kUl != null) {
                        this.kUp = this.kUm.gsO;
                        this.kUo = this.kUm.name;
                        int i = 0;
                        while (true) {
                            if (i == this.kUl.size()) {
                                break;
                            }
                            x xVar = this.kUl.get(i);
                            if (categoryTo != xVar.gsO) {
                                i++;
                            } else {
                                this.kUp = categoryTo;
                                this.kUo = xVar.name;
                                this.jYy.setCategoryTo(this.kUp);
                                break;
                            }
                        }
                        if (this.kUq != null) {
                            this.kUq.setText(this.kUo);
                            this.kUq.setCategoryContainerData(this.kUl, this.kUm, this.kUp);
                        }
                    }
                    this.dxg.aMV();
                    return;
                }
                return;
            }
            cWU();
            cWs();
        }
    }

    private void cWU() {
        if ((!this.kUs || this.kUX != null) && this.kUW != null) {
            this.kUX.b(this.writeImagesInfo);
            cWY();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.jYy.getType());
        bundle.putString("forum_id", this.jYy.getForumId());
        bundle.putString("forum_name", this.jYy.getForumName());
        bundle.putString("forum_first_dir", this.jYy.getFirstDir());
        bundle.putString("forum_second_dir", this.jYy.getSecondDir());
        bundle.putString("thread_id", this.jYy.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.jYy.getFloor());
        bundle.putInt("floor_num", this.jYy.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.kUR);
        if (this.kUK) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.dyK);
        if (this.kUg != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.kUg));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.kUT);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.gPr);
        bundle.putInt("album_thread", this.aCm);
        bundle.putInt("private_thread", this.privateThread);
        bundle.putSerializable("tab_list", this.kOH);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cWz().getEditableText().toString();
        if (obj != null) {
            cWz().setText(TbFaceManager.aPU().a(getPageContext().getPageActivity(), obj, this.kUz));
            cWz().setSelection(cWz().getText().length());
        }
    }

    private String cWD() {
        return (cWz() == null || cWz().getText() == null) ? "" : cWz().getText().toString();
    }

    private String cWE() {
        if (this.jYy == null || cWA() == null || cWA().getVisibility() != 0 || cWA().getText() == null) {
            return "";
        }
        String obj = cWA().getText().toString();
        if (this.mPrefixData != null && v.getCount(this.mPrefixData.getPrefixs()) > 0 && this.jYz != v.getCount(this.mPrefixData.getPrefixs()) - 1 && this.jYy.getType() != 4 && this.jYW != null && this.jYW.getText() != null) {
            this.jYy.setPostPrefix(this.jYW.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.jYy.getTitle();
        }
        return obj;
    }

    private void Le(String str) {
        if (this.jYy != null && this.kUb != null) {
            if (this.kUb.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.jYy.setIsNoTitle(true);
                    this.jYy.setTitle("");
                    return;
                }
                this.jYy.setIsNoTitle(false);
                this.jYy.setTitle(str);
                return;
            }
            this.jYy.setIsNoTitle(true);
            this.jYy.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWF() {
        cIn();
        this.jYy.setContent(cWD());
        Le(cWE());
        if (this.kUK || this.kTZ) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.jYy.getTitle()) || !this.jYy.getTitle().startsWith(string)) {
                Le(string + this.jYy.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.jYy.getContent()) || !this.jYy.getContent().startsWith(str)) {
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
                sb.append(this.jYy.getContent());
                this.jYy.setContent(sb.toString());
            }
        }
        if (this.kUn >= 0) {
            this.jYy.setCategoryFrom(this.kUn);
        }
        if (this.kUp >= 0) {
            this.jYy.setCategoryTo(this.kUp);
        }
        this.jYy.setWriteImagesInfo(this.writeImagesInfo);
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
            this.jYy.setTakePhotoNum(i);
        }
        this.jYy.setHasLocationData(this.dyL != null && this.dyL.brr());
        if (this.writeImagesInfo != null) {
            this.dyM.sY(this.writeImagesInfo.size() > 0);
        }
        if (!v.isEmpty(this.mList) && this.kUt != null && this.kUt.mIsGlobalBlock == 0) {
            this.jYy.setForumId(String.valueOf(this.kUt.mForumId));
            this.jYy.setForumName(this.kUt.mForumName);
        }
        cVB();
        this.dyM.d(this.jYy);
        this.jYy.setContent(this.jYy.getContent().replaceAll("\u0000\n", ""));
        this.jYy.setContent(this.jYy.getContent().replaceAll("\u0000", ""));
        this.jYy.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.dyM.cIp().setVoice(this.mVoiceModel.getId());
                this.dyM.cIp().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.dyM.cIp().setVoice(null);
                this.dyM.cIp().setVoiceDuringTime(-1);
            }
        } else {
            this.dyM.cIp().setVoice(null);
            this.dyM.cIp().setVoiceDuringTime(-1);
        }
        if (!this.dyM.cMH()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.ggh);
            this.dyM.cME();
        }
    }

    private void cVB() {
        FrsTabItemData selectedTabItemData;
        if (this.jYy != null && this.kSA != null && (selectedTabItemData = this.kSA.getSelectedTabItemData()) != null) {
            this.jYy.setTabId(selectedTabItemData.tabId);
            this.jYy.setTabName(selectedTabItemData.name);
            this.jYy.setIsGeneralTab(selectedTabItemData.isGeneralTab);
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
            if (this.kUg != null) {
                i2 = this.kUg.getTotalCount();
                i = this.kUg.getAlreadyCount() + 1;
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
                if (this.jYQ == getCurrentFocus()) {
                    cWz().clearFocus();
                    this.jYQ.requestFocus();
                    if (this.dxg != null) {
                        this.dxg.aMV();
                    }
                    ShowSoftKeyPadDelay(this.jYQ);
                } else {
                    cWz().requestFocus();
                    if (this.dxg != null) {
                        this.dxg.aMV();
                    }
                    ShowSoftKeyPadDelay(this.jYU);
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
                            cWz().getText().insert(cWz().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.jYy.getType() == 0 || this.jYy.getType() == 9) {
                    w.c(this.jYy.getForumId(), (WriteData) null);
                    if (postWriteCallBackData2 != null) {
                    }
                } else if (this.jYy.getType() == 1) {
                    w.d(this.jYy.getThreadId(), (WriteData) null);
                }
                k(postWriteCallBackData2);
                setResult(-1, intent);
                finish();
            } else if (i != 12010 && i != 12009) {
                if (i == 12002) {
                    if (intent != null) {
                        if (intent.getBooleanExtra("finish_self", false)) {
                            setResult(-1, intent);
                            finish();
                            return;
                        }
                        int intExtra = intent.getIntExtra("camera_request_from", 0);
                        if (intent.getBooleanExtra("camera_result", false)) {
                            if (intExtra == 1) {
                                cWZ();
                            } else {
                                aD(intent);
                            }
                        } else if (intExtra == 1) {
                            aE(intent);
                        } else {
                            aB(intent);
                            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.kVt) {
                            ub(true);
                            this.kVt = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.kUs) {
                        U(intent);
                        cIw();
                        return;
                    }
                    aC(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.jYy.setVideoInfo(videoInfo);
                        this.dxg.b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
                        this.dxg.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.dxg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    cIw();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.kTX) {
                                sb2.append(com.baidu.tbadk.plugins.b.dGc);
                                this.kTX = false;
                            }
                            sb2.append(stringExtra);
                            vi(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !v.isEmpty(this.mList) && !v.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                    this.kUt = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                    a(this.kUt);
                }
            }
        } else if (i2 == 0) {
            if (this.dxg != null && !this.dxg.aOA()) {
                this.jYU.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.dxg.aMV();
            }
            switch (i) {
                case 12001:
                    aPg();
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    cWX();
                    if (this.kVt) {
                        ub(true);
                        this.kVt = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.jYQ == getCurrentFocus()) {
                        cWz().clearFocus();
                        this.jYQ.requestFocus();
                        if (this.dxg != null) {
                            this.dxg.aMV();
                        }
                        ShowSoftKeyPadDelay(this.jYQ);
                        return;
                    }
                    cWz().requestFocus();
                    if (this.dxg != null) {
                        this.dxg.aMV();
                    }
                    ShowSoftKeyPadDelay(this.jYU);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.kUx.KL(postWriteCallBackData.getErrorString());
                        this.kUx.aU(postWriteCallBackData.getSensitiveWords());
                        this.kUx.b(this.jYQ, this.jYU);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.dyK = String.valueOf(System.currentTimeMillis());
                    al.a(getPageContext(), this.dyK);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    cWX();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.kTW)) {
                        cWA().requestFocus();
                        return;
                    } else if ("from_content".equals(this.kTW)) {
                        cWz().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWG() {
        if ("1".equals(this.gPr)) {
            this.jYy.setCanNoForum(true);
            this.jYy.setTransmitForumData("[]");
        } else if ("2".equals(this.gPr)) {
            this.jYy.setCanNoForum(false);
        }
        cWH();
        this.jYy.setPrivacy(this.isPrivacy);
        cWV();
        this.jYy.setToDynamic(this.isToDynamic);
        this.jYy.setCallFrom(this.gPr);
        if (this.jYy.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cWF();
    }

    private void cWH() {
        if (this.dxg != null) {
            this.dxg.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void cWV() {
        if (this.dxg != null) {
            this.dxg.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void cWW() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void cWX() {
        if (this.kUs) {
            this.kUX.b(this.writeImagesInfo);
            cWY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWY() {
        this.kUX.notifyDataSetChanged();
        this.kUW.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.kUX.notifyDataSetChanged();
                WriteActivity.this.kUW.invalidateViews();
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
        cIw();
    }

    private void aB(Intent intent) {
        if (this.kUs) {
            aC(intent);
            cWX();
        } else {
            aF(intent);
        }
        cIw();
    }

    private void aC(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            cWX();
            uc(true);
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

    private void cWZ() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void aE(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.kUU.parseJson(stringExtra);
            this.kUU.updateQuality();
            if (this.kUU.getChosedFiles() != null && this.kUU.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.kUU.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.kUU.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cWA());
        HidenSoftKeyPad(this.mInputManager, cWz());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void aF(Intent intent) {
        c(intent, true);
    }

    private void T(Intent intent) {
        this.dyK = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.dyK;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.getEquipmentWidth(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.dyK, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            cXa();
            cWI();
        }
        uc(true);
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
                cXa();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    cWI();
                }
            }
            uc(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXa() {
        if (this.dxg.mr(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void aPg() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.dyK));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void cXb() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.gnp)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                com.baidu.tbadk.util.o oVar = new com.baidu.tbadk.util.o(this, this.gnp, new o.a() { // from class: com.baidu.tieba.write.write.WriteActivity.37
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
                            WriteActivity.this.uc(true);
                        }
                    }
                });
                oVar.setFrom(1);
                oVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uc(boolean z) {
        String forumId = this.jYy == null ? "" : this.jYy.getForumId();
        if (this.kUV != null) {
            this.kUV.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.gpi == null) {
            this.gpi = VoiceManager.instance();
        }
        return this.gpi;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bEu() {
        this.gpi = getVoiceManager();
        this.gpi.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bb(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.gqp) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.jYy.getType() != 7) {
                if (this.kUg == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                B(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.dyR = i;
        if (this.dxg != null) {
            this.dxg.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void cWI() {
        if (!this.kUs) {
            if (this.dxg != null) {
                this.dxg.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.dxg.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.jYy == null ? "" : this.jYy.getForumId();
            if (this.kUV != null) {
                this.kUV.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gK(boolean z) {
        if (this.dxg != null) {
            this.dxg.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Ez(int i) {
        if (i < this.kUe.size()) {
            for (int i2 = 0; i2 < this.kUe.size(); i2++) {
                this.kUe.get(i2).tR(false);
            }
            this.kUe.get(i).tR(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void Cl(int i) {
        if (i == v.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new an("c13014").X("obj_type", 1));
        } else {
            TiebaStatic.log(new an("c13014").X("obj_type", 2));
        }
        this.jYz = i;
        this.jYX.setCurrentIndex(i);
        Ez(i);
        this.jYW.setText(this.mPrefixData.getPrefixs().get(i));
        cIw();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.jYX, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.jYZ.setSelected(false);
        am.setImageResource(this.jYY, R.drawable.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.jYU);
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
        if (this.jYy != null) {
            if (this.jYy.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.jYy.getType() == 5) {
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
            aPa();
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = ab.transformPermissionResult(strArr, iArr);
            if (ab.checkCamera(getApplicationContext())) {
                al.a(getPageContext(), this.dyK);
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
        this.auO = z;
        if (this.kVn && System.currentTimeMillis() - this.kVo < 800) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.kVn = false;
        }
        if (this.kUw != null && !z) {
            this.kUw.byQ();
        }
        if (this.kUy != null && !z) {
            cWk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lf(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.kVk != null) {
            Lg(str);
            this.kVk.dismiss();
        }
    }

    private void fH(Context context) {
        kVm = l.getEquipmentHeight(context);
    }

    private void Lg(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.kVn = true;
        cXa();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            cWI();
        }
        uc(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [4484=4] */
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

    private File cXc() {
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

    private void cXd() {
        if (this.kVi != null && this.jYy.getType() == 0 && this.jYy.getType() == 9) {
            fH(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.kVi != null) {
                        WriteActivity.this.Lf(WriteActivity.this.kVi.getAbsolutePath());
                    }
                }
            });
            this.kVj = (TbImageView) this.mBubbleView.findViewById(R.id.rec_img_view);
            this.kVl = (LinearLayout) this.mBubbleView.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.aFH().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.kVi.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.aFH().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.kVi.getAbsolutePath());
                Bitmap g = g(this.kVi.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (g != null) {
                    this.kVj.setImageBitmap(g);
                    this.kVj.setDrawBorder(true);
                    this.kVj.setBorderWidth(2);
                    this.kVj.setBorderColor(am.getColor(R.color.common_color_10264));
                    this.kVk = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.kVk.setCanceledOnTouchOutside(true);
                    this.kVk.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.kVn) {
                                l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.kVo = System.currentTimeMillis();
                            }
                        }
                    });
                    this.kVk.setContentView(this.mBubbleView);
                    this.kVk.show();
                    Window window = this.kVk.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (kVm / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.auO && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.kTX = false;
            this.kTW = "";
            if ("from_content".equals(str)) {
                this.kTW = "from_content";
            } else if ("from_title".equals(str)) {
                this.kTW = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.vJ(String.valueOf(charSequence.charAt(i)))) {
                tZ(false);
            }
        }
    }

    public void cDC() {
        if (this.kUK || !v.isEmpty(this.mList) || !StringUtils.isNull(this.jYy.getTitle())) {
            this.kUb.setVisibility(0);
            this.kUb.requestFocus();
            return;
        }
        this.kUb.setVisibility(8);
    }
}
