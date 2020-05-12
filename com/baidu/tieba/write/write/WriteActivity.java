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
import com.baidu.android.util.devices.RomUtils;
import com.baidu.h.a.a;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.searchbox.ugc.model.UgcConstant;
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
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.ax;
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
import com.baidu.tieba.write.b.a;
import com.baidu.tieba.write.b.c.b;
import com.baidu.tieba.write.h;
import com.baidu.tieba.write.upload.BaseUploadData;
import com.baidu.tieba.write.upload.ImageTextUploadData;
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
/* loaded from: classes2.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0121a, VoiceManager.c, w.a, h.a {
    private static int lFq = 0;
    private EditorTools dWS;
    private String dYw;
    private LocationModel dYx;
    private NewWriteModel dYy;
    private String gWA;
    private String gWB;
    private String gWC;
    private VoiceManager gYv;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private LinearLayout jvt;
    private PlayVoiceBntNew jvu;
    private ImageView jvw;
    private int kHN;
    private TextView kIk;
    private com.baidu.tieba.write.h kIl;
    private ImageView kIm;
    private View kIn;
    private ForumTabSelectedView lCE;
    private com.baidu.tieba.write.editor.b lEA;
    private e lEC;
    private com.baidu.tieba.view.b lEJ;
    private View lES;
    private g lEZ;
    private LinearLayout lEe;
    private LinearLayout lEf;
    private View lEh;
    private Toast lEj;
    private AdditionData lEk;
    private RelativeLayout lEl;
    private TextView lEm;
    private TextView lEn;
    private TextView lEo;
    List<aa> lEp;
    aa lEq;
    private int lEr;
    private String lEs;
    private int lEt;
    private PostCategoryView lEu;
    private HotTopicBussinessData lEx;
    private TextView lEy;
    private View lFu;
    private View lFv;
    private TextView lFw;
    private com.baidu.tieba.c.d lFy;
    private FrsTabInfoData lyc;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String lEa = "";
    private boolean lEb = false;
    private WriteData kHM = null;
    private boolean lEO = false;
    private boolean lEd = false;
    private boolean lEP = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText kIe = null;
    private HeadImageView lEQ = null;
    private View kIf = null;
    private LinearLayout kIh = null;
    private EditText kIi = null;
    private FeedBackModel lEg = null;
    private FeedBackTopListView lER = null;
    private ArrayList<WritePrefixItemLayout> lEi = new ArrayList<>();
    private String iTf = null;
    private final KeyEvent gKF = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView lET = null;
    private TextView kIj = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener gPv = null;
    private com.baidu.tbadk.core.dialog.a lEU = null;
    private final Handler mHandler = new Handler();
    private boolean lEV = false;
    private String lEW = null;
    private RelativeLayout idE = null;
    private String dYC = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int dYD = 0;
    private int lEX = 0;
    private WriteImagesInfo lEY = new WriteImagesInfo();
    private View mRootView = null;
    private GridView lFa = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a lFb = null;
    private ScrollView lEv = null;
    private EditText lFc = null;
    private View lFd = null;
    private View lFe = null;
    private View lFf = null;
    private EditText lFg = null;
    private TextView lFh = null;
    private TextView lFi = null;
    private TextWatcher lFj = null;
    private TextWatcher lFk = null;
    private boolean lEw = false;
    private boolean lFl = false;
    private com.baidu.tbadk.core.view.a egi = null;
    private String mFrom = "write";
    private File lFm = null;
    private TbImageView lFn = null;
    private View mBubbleView = null;
    private Dialog lFo = null;
    private LinearLayout lFp = null;
    private boolean lFr = false;
    private long lFs = -1000;
    private boolean lFt = false;
    private String hzw = "2";
    private int aVY = 0;
    private String mTopicId = "";
    private SpannableStringBuilder lEz = new SpannableStringBuilder();
    private boolean lFx = false;
    private boolean aOv = false;
    private final b lEB = new b();
    private boolean lCj = false;
    private final HttpMessageListener lFz = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.iTf)) {
                    WriteActivity.this.iTf = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.vd(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.iTf)) {
                    WriteActivity.this.iTf = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.iTf);
                    WriteActivity.this.vd(true);
                }
            }
        }
    };
    private TbFaceManager.a lED = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan wN(String str) {
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
    private final AntiHelper.a gZC = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).af("obj_locate", at.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).af("obj_locate", at.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d dYM = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.aa aaVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.bOS();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.kHM != null) {
                WriteActivity.this.lEB.aW(null);
                if (z) {
                    WriteActivity.this.hI(z);
                    if (WriteActivity.this.e(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    if (WriteActivity.this.kHM.getType() != 0 && WriteActivity.this.kHM.getType() != 9) {
                        if (WriteActivity.this.kHM.getType() != 7) {
                            if (WriteActivity.this.kHM.getType() == 1) {
                                w.d(WriteActivity.this.kHM.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.kHM.getType() == 5) {
                                w.d(WriteActivity.this.kHM.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            w.c("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            w.c(WriteActivity.this.kHM.getForumId(), (WriteData) null);
                        }
                        if (!v.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                            TiebaStatic.log(new an("c11731").cI("obj_id", WriteActivity.this.mTopicId));
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
                    WriteActivity.this.lEB.aW(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.lEB.Ms(postWriteCallBackData.getErrorString());
                    WriteActivity.this.lEB.b(WriteActivity.this.kIe, WriteActivity.this.kIi);
                } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aSf());
                    if (com.baidu.tbadk.s.a.xr(aaVar.aSe())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aSe());
                        if (WriteActivity.this.lEP) {
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
    private final LocationModel.a dYK = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void aXE() {
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
            if (aVar != null && !StringUtils.isNull(aVar.cWT())) {
                WriteActivity.this.a(2, true, aVar.cWT());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener kUU = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.dYx.tY(false);
                    WriteActivity.this.dYx.eT(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.dYx.tY(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener lEE = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener lEF = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.dWS.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dgN = WriteActivity.this.dgN();
            if (dgN >= 0 && dgN < WriteActivity.this.kIi.getText().length()) {
                WriteActivity.this.kIi.setSelection(dgN);
            }
        }
    };
    private boolean lEG = true;
    private final View.OnFocusChangeListener fBa = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.kIe || view == WriteActivity.this.mBack || view == WriteActivity.this.kIj) {
                if (z) {
                    WriteActivity.this.lEG = true;
                    WriteActivity.this.dgO();
                    l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.kIe);
                    if (WriteActivity.this.dWS != null) {
                        WriteActivity.this.dWS.aVq();
                    }
                } else if (view == WriteActivity.this.kIe) {
                    WriteActivity.this.kIk.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.kIi && z) {
                WriteActivity.this.lEG = false;
                WriteActivity.this.dgO();
                l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.kIi);
                if (WriteActivity.this.dWS != null) {
                    WriteActivity.this.dWS.aVq();
                }
            }
            WriteActivity.this.dgT();
        }
    };
    private TextWatcher lEH = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String lEL = "";
        private String lEM;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.lEM = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.lEM != null ? this.lEM.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cSS();
            WriteActivity.this.dgU();
            EditText dhg = WriteActivity.this.dhg();
            if (editable != null && dhg != null && dhg.getText() != null) {
                if (this.lEL == null || !this.lEL.equals(editable.toString())) {
                    if (WriteActivity.this.lEB != null) {
                        this.lEL = dhg.getText().toString();
                        WriteActivity.this.lEB.b(dhg, true);
                        return;
                    }
                    return;
                }
                dhg.setSelection(dhg.getSelectionEnd());
            }
        }
    };
    private TextWatcher lEI = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String lEM;
        private String lEN = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.lEM = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.lEM != null ? this.lEM.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cSS();
            EditText dhf = WriteActivity.this.dhf();
            if (editable != null && dhf != null && dhf.getText() != null) {
                if (this.lEN == null || !this.lEN.equals(editable.toString())) {
                    if (WriteActivity.this.lEB != null) {
                        this.lEN = dhf.getText().toString();
                        WriteActivity.this.lEB.b(dhf, false);
                        return;
                    }
                    return;
                }
                dhf.setSelection(dhf.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0673a jBv = new a.InterfaceC0673a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0673a
        public void onRefresh() {
            WriteActivity.this.iTf = null;
            WriteActivity.this.vd(false);
            WriteActivity.this.dWS.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void aXo() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void aXp() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aXr();
        } else if (this.dYx.cXa()) {
            aXo();
        } else {
            this.dYx.tY(false);
            a(1, true, (String) null);
            this.dYx.cWY();
        }
    }

    public void dhq() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
            if (this.lEA != null) {
                this.lEA.dfG();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aXr();
        } else if (this.dYx != null) {
            this.dYx.tY(false);
            a(1, true, (String) null);
            this.dYx.cWY();
        }
    }

    private void aXr() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.kd(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.dYx.cXc();
                } else {
                    WriteActivity.this.dYK.aXE();
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
        aVar.aMS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dgN() {
        int selectionEnd = dhf().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dhf().getText().getSpans(0, dhf().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dhf().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dhf().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgO() {
        if (this.dWS != null) {
            this.dWS.setBarLauncherEnabled(!this.lEG);
            this.dWS.setBarLauncherEnabled(true, 26);
            this.dWS.setBarLauncherEnabled(true, 2);
            this.dWS.setBarLauncherEnabled(true, 30);
            ac(9, this.lEG ? false : true);
        }
    }

    private void ac(int i, boolean z) {
        com.baidu.tbadk.editortools.g mA;
        if (this.dWS != null && (mA = this.dWS.mA(i)) != null) {
            if (z) {
                mA.display();
            } else {
                mA.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.lEw) {
            this.kIe.setVisibility(8);
            if (this.kHM.getType() == 5) {
                this.lFf.setVisibility(8);
            } else {
                this.lFf.setVisibility(0);
            }
            a(this.lFi, this.lFc);
            a(this.lFh, this.lFg);
            cSS();
        }
        if (this.lEO) {
            this.lEG = true;
            dgO();
            if (this.dWS != null) {
                this.dWS.aVq();
            }
            this.kIe.requestFocus();
            ShowSoftKeyPadDelay(this.kIe);
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
            dhG();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                dho();
            }
            ve(true);
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
        if (this.kHM.getType() == 0) {
            Fb(this.aVY);
        }
        initUI();
        dhv();
        this.dYx = new LocationModel(getPageContext());
        this.dYx.a(this.dYK);
        registerListener(this.kUU);
        registerListener(this.lEE);
        cqM();
        dhJ();
        if (this.lEw) {
            this.lFb.setEditorTools(this.dWS);
        } else {
            this.kIi.requestFocus();
        }
        cNW();
        dho();
        dhH();
    }

    @SuppressLint({"ResourceAsColor"})
    private void cqM() {
        this.dWS = new EditorTools(getActivity());
        this.dWS.setBarMaxLauCount(5);
        this.dWS.setMoreButtonAtEnd(true);
        this.dWS.setBarBackgroundColorId(R.color.cp_bg_line_h);
        this.dWS.setBarLauncherType(1);
        this.dWS.hA(true);
        this.dWS.hB(true);
        switch (this.kHM.getType()) {
            case 4:
            case 5:
                dht();
                break;
            default:
                dgP();
                break;
        }
        this.dWS.build();
        if (this.lEe != null) {
            this.lEe.addView(this.dWS);
        }
        ckI();
        this.dWS.display();
        com.baidu.tbadk.editortools.g mA = this.dWS.mA(6);
        if (mA != null && !TextUtils.isEmpty(this.dYC)) {
            ((View) mA).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.dYC);
                }
            });
        }
        if (!this.lEw) {
            this.dWS.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.dWS.aVq();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.dWS.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.dWS.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (!this.lCj) {
            dgR();
        }
    }

    private void dhr() {
        this.lFd = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.lFf = this.lFd.findViewById(R.id.live_post_title_container);
        this.lFc = (EditText) this.lFd.findViewById(R.id.live_post_content);
        this.lFa = (GridView) this.lFd.findViewById(R.id.photoLiveGridView);
        this.lFg = (EditText) this.lFd.findViewById(R.id.live_post_title);
        this.lFh = (TextView) this.lFd.findViewById(R.id.titleOverPlusNumber);
        this.lFi = (TextView) this.lFd.findViewById(R.id.contentOverPlusNumber);
        this.lFe = this.lFd.findViewById(R.id.live_interval_view);
        this.lFh.setText(String.valueOf(20));
        this.lFi.setText(String.valueOf(233));
        this.lFd.setVisibility(0);
        this.lFh.setVisibility(0);
        this.lFi.setVisibility(0);
        this.lFg.setHint(R.string.tips_title_limit_new);
        this.lFg.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.lFl = true;
                    WriteActivity.this.lEG = true;
                    WriteActivity.this.dgO();
                    if (WriteActivity.this.dWS != null) {
                        WriteActivity.this.dWS.aVq();
                    }
                }
            }
        });
        if (this.kHM.getType() == 4) {
            this.lFc.setHint(R.string.live_write_input_content_new);
        } else if (this.kHM.getType() == 5) {
            this.lFc.setHint(R.string.live_write_input_content_update);
        }
        this.lFc.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.lFl = false;
                    WriteActivity.this.lEG = false;
                    WriteActivity.this.dgO();
                    if (WriteActivity.this.dWS != null) {
                        WriteActivity.this.dWS.aVq();
                    }
                }
            }
        });
        this.lFc.requestFocus();
        this.lFc.addTextChangedListener(abD());
        this.lFg.requestFocus();
        this.lFg.addTextChangedListener(abD());
        this.lFg.setOnClickListener(this.lEF);
        this.lFc.setOnClickListener(this.lEF);
        this.lFb = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.lFa);
        this.lFb.EV(6);
        this.lFa.setAdapter((ListAdapter) this.lFb);
        View findViewById = this.lFd.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void dgz() {
                WriteActivity.this.dhE();
            }
        });
        dhs();
    }

    private void dhs() {
        if (this.kHM.getType() == 0) {
            if (this.kHM.getTitle() != null) {
                this.lFg.setText(this.kHM.getTitle());
                this.lFg.setSelection(this.kHM.getTitle().length());
                return;
            }
            return;
        }
        if (this.kHM.getType() == 1 || this.kHM.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.lEw) {
            dhC();
        }
        if (this.dWS.aWP()) {
            this.dWS.aVq();
        }
        Fb(0);
    }

    private void Fb(int i) {
        if (this.writeImagesInfo != null && this.kHM != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.kHM.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.kHM.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.hzw);
            albumActivityConfig.setProfessionZone(this.kHM.getProZone());
            albumActivityConfig.setFrsTabInfo(this.lyc);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void dht() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.dWS.aR(arrayList);
        com.baidu.tbadk.editortools.l mD = this.dWS.mD(5);
        if (mD != null) {
            mD.dXC = 2;
        }
        this.dWS.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.dWS.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void dgP() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.l lVar;
        CustomResponsedMessage runTask2;
        com.baidu.tbadk.editortools.l lVar2;
        CustomResponsedMessage runTask3;
        com.baidu.tbadk.editortools.l lVar3;
        CustomResponsedMessage runTask4;
        com.baidu.tbadk.editortools.l lVar4;
        CustomResponsedMessage runTask5;
        com.baidu.tbadk.editortools.l lVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            this.dWS.b(dVar);
        }
        if (!this.lCj) {
            Boolean dhz = dhz();
            if (!this.lEO && dhz != null && dhz.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.cXy() && s.d(this.kHM.getForumName(), true) && (runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar5 = (com.baidu.tbadk.editortools.l) runTask5.getData()) != null) {
                lVar5.dXC = 3;
                if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    this.dWS.b(lVar5);
                }
            }
        }
        if (!this.lCj) {
            this.dWS.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 4));
        }
        if (!this.lCj && (runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar4 = (com.baidu.tbadk.editortools.l) runTask4.getData()) != null) {
            lVar4.dXC = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dWS.b(lVar4);
            }
        }
        if (!this.lCj) {
            this.dWS.b(new com.baidu.tbadk.editortools.k(getActivity(), 6));
        }
        if (!this.lCj && (runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar3 = (com.baidu.tbadk.editortools.l) runTask3.getData()) != null) {
            lVar3.dXC = 7;
            this.dWS.b(lVar3);
        }
        if (!this.lCj) {
            this.dWS.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 8));
        } else {
            this.dWS.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        }
        if (!this.lCj && (runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar2 = (com.baidu.tbadk.editortools.l) runTask2.getData()) != null) {
            lVar2.dXE = true;
            lVar2.dXC = 9;
            lVar2.dXy = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dWS.b(lVar2);
            }
        }
        if (!this.lCj && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar.dXE = true;
            lVar.dXC = 10;
            lVar.dXy = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dWS.b(lVar);
            }
        }
        if (!this.lCj && this.lEk == null) {
            if (this.lEA == null) {
                this.lEA = new com.baidu.tieba.write.editor.b(getActivity(), this.hzw);
                this.lEA.bJ(this.kHM.getForumId(), this.privateThread);
                this.lEA.uV(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.lEA.dfC();
                this.lEA.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                dhq();
            }
            if (!v.isEmpty(this.mList)) {
                this.lEA.dfC();
            }
            this.dWS.b(this.lEA);
        }
        this.dWS.aR(arrayList);
        com.baidu.tbadk.editortools.l mD = this.dWS.mD(5);
        if (mD != null) {
            mD.dXC = 1;
        }
    }

    private void dgQ() {
        if (this.lEC != null) {
            this.lEC.hideTip();
        }
    }

    private void dgR() {
        if (this.lEC == null) {
            this.lEC = new e(getPageContext());
        }
        this.lEC.c(this.dWS);
    }

    private void ckI() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.dhe()) {
                            WriteActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new an("c12612").af("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (aVar.data != null && (aVar.data instanceof q)) {
                            q qVar = (q) aVar.data;
                            if (qVar.aRV() == EmotionGroupType.BIG_EMOTION || qVar.aRV() == EmotionGroupType.USER_COLLECT) {
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
                                    WriteActivity.this.ve(true);
                                    WriteActivity.this.cSS();
                                }
                            } else if (WriteActivity.this.dhe()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(qVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.dhh();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.cyq();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.dhG();
                        WriteActivity.this.cSS();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.Fc(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new an("c12612").af("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.lEk == null) {
                            WriteActivity.this.aXs();
                            return;
                        }
                        switch (WriteActivity.this.dYD) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.aXp();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.aXo();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.dYx != null) {
                            WriteActivity.this.dYx.tY(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.iTf = null;
                        } else {
                            WriteActivity.this.iTf = (String) aVar.data;
                        }
                        WriteActivity.this.vd(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        an anVar = new an("c10645");
                        if (WriteActivity.this.kHM != null) {
                            str = WriteActivity.this.kHM.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.cI("fid", str);
                        TiebaStatic.log(anVar);
                        if (WriteActivity.this.kHM == null || (videoInfo = WriteActivity.this.kHM.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.dWS.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.dWS.aWP()) {
                                        WriteActivity.this.dWS.aVq();
                                        WriteActivity.this.dWS.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.dWS.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.dWS.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.dWS.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.dWS.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.kHM.setVideoInfo(null);
                        WriteActivity.this.cSS();
                        if (WriteActivity.this.kIi != null) {
                            WriteActivity.this.kIi.requestFocus();
                        }
                        WriteActivity.this.dWS.aVq();
                        WriteActivity.this.dWS.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.kIi);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new an("c12612").af("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.dWS.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.lEb = true;
                        WriteActivity.this.vb(true);
                        if (!WriteActivity.this.dhg().isFocused() || WriteActivity.this.lEf.getVisibility() != 0) {
                            WriteActivity.this.lEa = "from_content";
                        } else {
                            WriteActivity.this.lEa = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        if (WriteActivity.this.lEf.getVisibility() == 0) {
                            if (WriteActivity.this.lEf.hasFocus()) {
                                WriteActivity.this.kIi.requestFocus();
                                WriteActivity.this.kIi.setSelection(WriteActivity.this.kIi.getText().toString().length());
                            }
                            WriteActivity.this.lEf.setVisibility(8);
                            WriteActivity.this.dWS.mA(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.lEf.setVisibility(0);
                            WriteActivity.this.lEf.requestFocus();
                            WriteActivity.this.dWS.mA(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.cSS();
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
        this.dWS.setActionListener(16, bVar);
        this.dWS.setActionListener(14, bVar);
        this.dWS.setActionListener(24, bVar);
        this.dWS.setActionListener(3, bVar);
        this.dWS.setActionListener(10, bVar);
        this.dWS.setActionListener(11, bVar);
        this.dWS.setActionListener(12, bVar);
        this.dWS.setActionListener(13, bVar);
        this.dWS.setActionListener(15, bVar);
        this.dWS.setActionListener(18, bVar);
        this.dWS.setActionListener(20, bVar);
        this.dWS.setActionListener(25, bVar);
        this.dWS.setActionListener(27, bVar);
        this.dWS.setActionListener(29, bVar);
        this.dWS.setActionListener(43, bVar);
        this.dWS.setActionListener(56, bVar);
        this.dWS.setActionListener(48, bVar);
        this.dWS.setActionListener(46, bVar);
        this.dWS.setActionListener(49, bVar);
        this.dWS.setActionListener(47, bVar);
        this.dWS.setActionListener(55, bVar);
        this.dWS.setActionListener(58, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fc(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXs() {
        if (this.dYx.bAS()) {
            if (this.dYx.cXa()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.cWV().getLocationData().cWT());
                return;
            }
            a(1, true, (String) null);
            this.dYx.cWY();
            return;
        }
        a(0, true, (String) null);
    }

    protected void cSJ() {
        if (this.dYy != null) {
            this.dYy.cancelLoadData();
        }
        if (this.lEg != null) {
            this.lEg.cancelLoadData();
        }
        if (this.dYx != null) {
            this.dYx.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dgQ();
        TiebaPrepareImageService.StopService();
        cSJ();
        dhy();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.lEZ != null) {
            this.lEZ.destroy();
        }
        if (this.lFy != null) {
            this.lFy.ED();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgS() {
        if (this.kHM != null && this.kHM.getType() == 2 && this.lEV) {
            finish();
        } else if (this.kHM == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.kHM.setTitle(dhg().getText().toString());
            this.kHM.setContent(dhf().getText().toString());
            int type = this.kHM.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    w.c(this.kHM.getForumId(), this.kHM);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    w.c("24591571", this.kHM);
                }
            } else if (type == 1) {
                w.d(this.kHM.getThreadId(), this.kHM);
            } else if (type == 4) {
                w.c(this.kHM.getForumId() + "photolive", this.kHM);
            } else if (type == 5) {
                w.d(this.kHM.getThreadId() + "updatephotolive", this.kHM);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.kIl != null && this.kIl.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.kIl, getPageContext().getPageActivity());
                return true;
            } else if (this.dWS.aWP()) {
                this.dWS.aVq();
                return true;
            } else {
                cSJ();
                dgS();
                return true;
            }
        }
        if (i == 67 && (text = dhf().getText()) != null) {
            int selectionStart = dhf().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dhf().onKeyDown(67, this.gKF);
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
        getLayoutMode().onModeChanged(this.idE);
        getLayoutMode().onModeChanged(this.lFp);
        am.setBackgroundColor(this.idE, R.color.cp_bg_line_e);
        if (this.lFn != null && (i == 1 || i == 4)) {
            this.lFn.setBorderColor(am.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.kIj, R.color.cp_link_tip_a, 1);
        dgO();
        am.setBackgroundColor(this.kIf, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.lFe, R.color.cp_bg_line_c);
        am.setBackgroundColor(dhg(), R.color.cp_bg_line_e);
        am.setImageResource(this.jvw, R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.iTf)) {
            am.setBackgroundColor(dhf(), R.color.cp_bg_line_e);
        }
        cSS();
        this.dWS.onChangeSkinType(i);
        if (this.lEu != null) {
            this.lEu.aQm();
        }
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.lEZ.lFV.notifyDataSetChanged();
        dgT();
        dgU();
        vd(false);
        if (this.lEB != null) {
            this.lEB.c(dhg(), dhf());
        }
        if (this.lCE != null) {
            this.lCE.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgT() {
        if (this.kIe.hasFocus()) {
            this.kIe.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.kIe.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.kIi.hasFocus()) {
            this.kIi.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.kIi.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgU() {
        if (this.kIe != null && this.kIe.getText() != null && this.kIe.getText().toString() != null && this.kIe.getPaint() != null) {
            if (this.kIe.getText().toString().length() == 0) {
                this.kIe.getPaint().setFakeBoldText(false);
            } else if (this.kIe.getText().toString().length() > 0) {
                this.kIe.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.egi = new com.baidu.tbadk.core.view.a(getPageContext());
        this.lEw = this.kHM.getType() == 4 || 5 == this.kHM.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aOR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.lET = (TextView) findViewById(R.id.btn_image_problem);
        dgX();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kIj.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.kIj.setLayoutParams(layoutParams);
        this.kIj.setOnFocusChangeListener(this.fBa);
        this.lEv = (ScrollView) findViewById(R.id.write_scrollview);
        this.lEv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.kIi != null) {
                        l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.kIi);
                    }
                    if (WriteActivity.this.dWS != null) {
                        WriteActivity.this.dWS.aVq();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.lER = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.lES = findViewById(R.id.feedback_divider);
        this.idE = (RelativeLayout) findViewById(R.id.parent);
        this.lEe = (LinearLayout) findViewById(R.id.tool_view);
        this.lEe.setContentDescription(IStringUtil.TOP_PATH);
        this.lEf = (LinearLayout) findViewById(R.id.title_view);
        this.kIf = findViewById(R.id.interval_view);
        this.lFu = findViewById(R.id.hot_topic_fourm_view);
        this.lFv = findViewById(R.id.hot_topic_divider);
        this.lEy = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.lFw = (TextView) findViewById(R.id.change_one_tv);
        cSR();
        if (this.lEw) {
            this.lEv.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            dhr();
        } else {
            this.lEZ = new g(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.lEZ.uT(false);
            } else {
                g gVar = this.lEZ;
                if (this.kHM.getType() != 0 && this.kHM.getType() != 9) {
                    z = false;
                }
                gVar.uT(z);
            }
        }
        cST();
        if (this.lEO || this.lEd) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().dAv) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.kIh = (LinearLayout) findViewById(R.id.post_content_container);
        this.kIh.setDrawingCacheEnabled(false);
        this.kIh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.dWS.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.kIi.requestFocus();
            }
        });
        this.jvt = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.jvu = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.jvw = (ImageView) findViewById(R.id.iv_delete_voice);
        this.jvw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cyq();
            }
        });
        this.mBack.setOnFocusChangeListener(this.fBa);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cSJ();
                WriteActivity.this.dgS();
            }
        });
        this.lET.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        dha();
        o(dhz());
        dhc();
        dgW();
        dhw();
        dhx();
        dgO();
        dhb();
        cSQ();
        dhi();
        if (this.kHM.getType() == 4 && this.kIn != null && this.lEh != null) {
            this.kIn.setVisibility(8);
            this.lEh.setVisibility(8);
        }
        cSS();
        dhu();
        dgf();
        dgV();
    }

    private void dgV() {
        this.lCE = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.lCE.setData(this.lyc);
        this.lCE.setActivity(this);
    }

    private void dgf() {
        if (this.mName != null && this.kHM != null && this.kHM.getProZone() == 1) {
            this.mName.setText(R.string.write_zone_profession_title);
        }
    }

    private void dgW() {
        String str;
        String str2;
        if (this.kHM != null) {
            switch (this.kHM.getType()) {
                case 0:
                case 9:
                    if (this.lEO || this.lEd) {
                        if (this.lEP) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.hzw != null && this.hzw.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                        if (this.lCj) {
                            this.mName.setText(R.string.publish_to_dynamic_title);
                        }
                    } else if (this.hzw != null && this.hzw.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.kHM.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.kHM.getForumName() + getResources().getString(R.string.bar));
                        this.kIe.setVisibility(8);
                        String str3 = this.gWC + " " + this.gWA;
                        if (!StringUtils.isNull(str3)) {
                            this.kIi.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.kIe.setVisibility(0);
                    this.kIi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.kIi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.kIe.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.kIi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.kHM.getFloorNum() + 1)));
                    this.lFe.setVisibility(8);
                    return;
                case 7:
                    this.kIe.setVisibility(0);
                    this.kIi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void dgX() {
        if (this.kHM.getType() == 7) {
            this.kIj = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.kIj = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void dgY() {
        if (this.kHM != null && this.kHM.getType() == 0 && this.kHM.getType() == 9 && !this.lEO && !this.lEd && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = aq.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dhg() != null) {
                dhg().setText(cutStringWithSuffix);
                dhg().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.jvt.setVisibility(0);
            this.jvu.setVoiceModel(voiceModel);
            this.jvu.cXx();
            cSS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyq() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.vs(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.jvt.setVisibility(8);
        this.jvu.bZe();
        this.jvu.setVoiceModel(null);
        com.baidu.tbadk.editortools.l mD = this.dWS.mD(6);
        if (mD != null && mD.dWM != null) {
            mD.dWM.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cSS();
    }

    private void dgZ() {
        this.lEp = null;
        this.lEr = -1;
        this.lEt = -1;
        ac ty = com.baidu.tieba.frs.ab.bQp().ty(1);
        if (ty != null) {
            this.lEp = ty.hcj;
            this.lEr = getIntent().getIntExtra("category_id", -1);
            if (this.lEp != null && !this.lEp.isEmpty() && this.lEr >= 0) {
                this.lEq = new aa();
                this.lEq.hcf = 0;
                this.lEq.name = getPageContext().getResources().getString(R.string.category_auto);
                this.lEt = this.lEq.hcf;
                this.lEs = this.lEq.name;
                for (aa aaVar : this.lEp) {
                    if (aaVar.hcf == this.lEr) {
                        this.lEt = aaVar.hcf;
                        this.lEs = aaVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dha() {
        if (this.lEp != null && !this.lEp.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.lEu = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.lEu.setText(this.lEs);
            this.lEu.setCategoryContainerData(this.lEp, this.lEq, this.lEt);
            this.lEu.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ax axVar) {
                    if (axVar != null) {
                        WriteActivity.this.lEu.setText(axVar.name);
                        WriteActivity.this.kHM.setCategoryTo(axVar.hcf);
                        WriteActivity.this.lEt = axVar.hcf;
                        WriteActivity.this.lEu.dgB();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.lEu.dgA();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dhg());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dhf());
                }
            });
        }
    }

    private void dhu() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.lEJ = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.lEJ.setTitle(R.string.no_disturb_start_time);
        this.lEJ.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.lEJ);
        this.lEJ.setButton(-2, getPageContext().getString(R.string.cancel), this.lEJ);
        return this.lEJ;
    }

    private void dhb() {
        this.lEl = (RelativeLayout) findViewById(R.id.addition_container);
        this.lEm = (TextView) findViewById(R.id.addition_create_time);
        this.lEn = (TextView) findViewById(R.id.addition_last_time);
        this.lEo = (TextView) findViewById(R.id.addition_last_content);
        if (this.lEk != null) {
            this.lEl.setVisibility(0);
            this.lEm.setText(getPageContext().getString(R.string.write_addition_create) + aq.getFormatTime(this.lEk.getCreateTime() * 1000));
            if (this.lEk.getAlreadyCount() == 0) {
                this.lEn.setVisibility(8);
            } else {
                this.lEn.setText(getPageContext().getString(R.string.write_addition_last) + aq.getFormatTime(this.lEk.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.lEk.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.lEo.setText(lastAdditionContent);
            } else {
                this.lEo.setVisibility(8);
            }
            dhf().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.lEk.getAlreadyCount()), Integer.valueOf(this.lEk.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.lEl.setVisibility(8);
    }

    private void cSQ() {
        this.kIn = findViewById(R.id.post_prefix_layout);
        if (this.lFy == null) {
            this.lFy = new com.baidu.tieba.c.d(getPageContext(), this.kIn);
            this.lFy.cz(R.drawable.bg_tip_blue_up_left);
            this.lFy.cy(16);
            this.lFy.lE(true);
            this.lFy.setUseDirectOffset(true);
            this.lFy.rS(l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.kIk = (TextView) findViewById(R.id.post_prefix);
        this.lEh = findViewById(R.id.prefix_divider);
        this.kIm = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.kIn.setVisibility(0);
            this.lFy.d(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.kHN = 0;
            this.kIn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").cI("fid", WriteActivity.this.kHM.getForumId()).t("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.kIk.setVisibility(0);
                    WriteActivity.this.kIn.setSelected(true);
                    am.setImageResource(WriteActivity.this.kIm, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.kIl, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.dWS.aVq();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.kIe);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.kIi);
                }
            });
            this.kIk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").cI("fid", WriteActivity.this.kHM.getForumId()).t("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.kIk.setSelected(true);
                    am.setImageResource(WriteActivity.this.kIm, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.kIl, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.dWS.aVq();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dhg());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dhf());
                }
            });
            this.kIl = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.kIl.a(this);
            this.kIl.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.kIl.setOutsideTouchable(true);
            this.kIl.setFocusable(true);
            this.kIl.setOnDismissListener(this);
            this.kIl.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            am.getColor(R.color.cp_cont_c);
            am.setBackgroundResource(this.kIk, R.color.cp_bg_line_d);
            am.setImageResource(this.kIm, R.drawable.icon_arrow_gray_down);
            this.kIk.setTextColor(color);
            this.lEi.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.lEi.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.uQ(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.uQ(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.kIl.addView(writePrefixItemLayout);
            }
            this.kIl.setCurrentIndex(0);
            this.kIk.setText(prefixs.get(0));
            Fa(0);
            return;
        }
        this.kIn.setVisibility(8);
    }

    private void dhv() {
        if (this.lEO && this.kHM != null) {
            this.lER.setVisibility(0);
            this.lES.setVisibility(0);
            this.lEg = new FeedBackModel(getPageContext());
            this.lEg.MM(this.kHM.getForumName());
            this.lEg.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.lER.setVisibility(8);
                        WriteActivity.this.lES.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.lER.setVisibility(8);
                        WriteActivity.this.lES.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.lER.a(feedBackModel.dgD(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void dhc() {
        this.kIj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (WriteActivity.this.lEB.a(WriteActivity.this.kIe, WriteActivity.this.kIi)) {
                        WriteActivity.this.showToast(WriteActivity.this.lEB.deU());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dhg());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dhf());
                    WriteActivity.this.dWS.aVq();
                    if (WriteActivity.this.kHM.getType() != 7) {
                        if (WriteActivity.this.lEO) {
                            WriteActivity.this.dhl();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            an anVar = new an("c12102");
                            anVar.af("obj_type", StringUtils.isNull(WriteActivity.this.kHM.getForumName()) ? 1 : 2);
                            TiebaStatic.log(anVar);
                            WriteActivity.this.dhm();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.dhl();
                    }
                    TiebaStatic.log(new an("c12262").cI("obj_locate", WriteActivity.this.hzw));
                }
            }
        });
    }

    protected void dhw() {
        this.lEU = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.lEU.ui(getPageContext().getString(R.string.is_save_draft)).gE(false).a(getPageContext().getString(R.string.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.kHM.setTitle(WriteActivity.this.dhg().getText().toString());
                WriteActivity.this.kHM.setContent(WriteActivity.this.dhf().getText().toString());
                int type = WriteActivity.this.kHM.getType();
                if (type == 0 || type == 9) {
                    w.c(WriteActivity.this.kHM.getForumId(), WriteActivity.this.kHM);
                } else if (type == 1) {
                    w.d(WriteActivity.this.kHM.getThreadId(), WriteActivity.this.kHM);
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
                int type = WriteActivity.this.kHM.getType();
                if (type == 0 || type == 9) {
                    w.c(WriteActivity.this.kHM.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    w.d(WriteActivity.this.kHM.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.lEU.b(getPageContext());
    }

    protected void cSR() {
        this.lEQ = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.lEQ.setIsRound(true);
        this.lEQ.setDrawBorder(false);
        this.lEQ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String uD = o.uD(currentPortrait);
            this.lEQ.setUrl(uD);
            this.lEQ.startLoad(uD, 12, false);
        }
        if (this.kHM.isUserFeedback()) {
            this.lEQ.setVisibility(0);
        }
        this.kIe = (EditText) findViewById(R.id.post_title);
        this.kIe.setOnClickListener(this.lEF);
        this.kIe.setOnFocusChangeListener(this.fBa);
        if (this.kHM.getType() == 0 || this.kHM.getType() == 9 || this.kHM.getType() == 7) {
            if (this.kHM.getTitle() != null) {
                this.kIe.setText(this.kHM.getTitle());
                this.kIe.setSelection(this.kHM.getTitle().length());
            } else if (this.lEP) {
                this.kIe.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.kHM.getType() == 1 || this.kHM.getType() != 2) {
        }
        this.kIe.addTextChangedListener(this.lEH);
        if (!this.kHM.getHaveDraft()) {
            dgY();
            this.lFt = true;
        }
        if (this.kHM.isUserFeedback()) {
            this.kIe.setHint(getResources().getString(R.string.feedback_title_hint));
        } else {
            this.kIe.setHint(getResources().getString(R.string.post_title_hint));
        }
    }

    private TextWatcher abD() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int lFC;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.cSS();
                if (WriteActivity.this.lEw) {
                    this.lFC = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.lFC);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.lEw || !WriteActivity.this.lFl) {
                    if (WriteActivity.this.lEw) {
                        if (this.mEditText != WriteActivity.this.lFc || this.mTextView != WriteActivity.this.lFi) {
                            this.mEditText = WriteActivity.this.lFc;
                            this.mTextView = WriteActivity.this.lFi;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.lFg || this.mTextView != WriteActivity.this.lFh) {
                    this.mEditText = WriteActivity.this.lFg;
                    this.mTextView = WriteActivity.this.lFh;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.lEw && this.lFl) {
            if (this.lFj != null) {
                this.lFg.removeTextChangedListener(this.lFj);
            }
            this.lFj = textWatcher;
        } else if (this.lEw) {
            if (this.lFk != null) {
                this.lFc.removeTextChangedListener(this.lFk);
            }
            this.lFk = textWatcher;
        }
        return textWatcher;
    }

    private long i(EditText editText) {
        if (editText == this.lFc) {
            return 233L;
        }
        if (editText != this.lFg) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long i = i(editText);
            long j = i - j(editText);
            String valueOf = String.valueOf(j);
            if (i == 20) {
                if (j < 0) {
                    if (j < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(am.getColor(R.color.common_color_10159));
                } else {
                    textView.setTextColor(am.getColor(R.color.cp_cont_d));
                }
            } else if (j < 0) {
                if (j < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(am.getColor(R.color.common_color_10159));
            } else {
                textView.setTextColor(am.getColor(R.color.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long j(EditText editText) {
        return com.baidu.tieba.write.c.a.p(editText.getText().toString().trim());
    }

    protected void cST() {
        this.kIi = (EditText) findViewById(R.id.post_content);
        this.kIi.setDrawingCacheEnabled(false);
        this.kIi.setOnClickListener(this.lEF);
        if (this.kHM.getContent() != null && this.kHM.getContent().length() > 0) {
            SpannableString aj = TbFaceManager.aYj().aj(getPageContext().getPageActivity(), this.kHM.getContent());
            this.kIi.setText(aj);
            this.kIi.setSelection(aj.length());
        } else if (this.kHM.getType() == 2) {
            if (this.lEV) {
                if (this.lEW != null && this.lEW.length() > 0) {
                    this.kIi.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.lEW}));
                    this.kIi.setSelection(this.kIi.getText().length());
                }
            } else if (this.kHM.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.kHM.getFloorNum()));
                this.kIi.setText(format);
                this.kIi.setSelection(format.length());
            }
        }
        this.kIi.setOnFocusChangeListener(this.fBa);
        this.kIi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.dWS.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.kIi.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.kIi.addTextChangedListener(this.lEI);
        if (this.kHM.getType() == 0) {
            this.lFx = true;
        } else {
            vd(true);
            this.lFx = false;
        }
        if (this.kHM.isUserFeedback()) {
            this.kIi.setHint(R.string.write_input_content);
        } else {
            this.kIi.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void vd(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.lEw && !this.lCj) {
            dhf().setPadding(0, 0, 0, 0);
            dhf().setBackgroundDrawable(null);
            am.setBackgroundColor(dhf(), R.color.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.iTf) && this.lEk == null) {
                com.baidu.adp.lib.e.c.kV().a(this.iTf, 19, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
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
                            WriteActivity.this.dhf().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.dhf(), true, WriteActivity.this.jBv);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dhe() {
        int i = 5000;
        if (this.lEk != null) {
            i = 1000;
        }
        return dhf().getText() != null && dhf().getText().length() >= i;
    }

    private void wy(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.lEa)) {
                this.lEa = "";
                dhf().requestFocus();
                if (dhf().getText() != null && dhf().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dhf().getSelectionStart();
                    editable = dhf().getText();
                }
            } else if ("from_title".equals(this.lEa)) {
                this.lEa = "";
                dhg().requestFocus();
                if (dhg().getText() != null && dhg().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dhg().getSelectionStart();
                    editable = dhg().getText();
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
    public void vb(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.kHM != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.kHM.getForumId(), 0L), this.kHM.getFirstDir(), this.kHM.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(q qVar) {
        if (((ImageSpan[]) dhf().getText().getSpans(0, dhf().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.lEj == null) {
                this.lEj = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            this.lEj.show();
            return;
        }
        String name = qVar.getName();
        final EmotionGroupType aRV = qVar.aRV();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.e.c.kV().a(name, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.dhf().getSelectionStart(), aVar, aRV);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && dhf() != null && dhf().getText() != null) {
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
                int selectionStart = dhf().getSelectionStart() - 1;
                if (dhf().getText().length() > 1 && selectionStart >= 0 && dhf().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    dhf().getText().insert(dhf().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            dhf().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                dhf().getText().insert(dhf().getSelectionStart(), spannableString2);
            }
            Editable text = dhf().getText();
            if (text != null) {
                this.lEz.clear();
                this.lEz.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.lEz);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && dhf().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    dhf().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                dhf().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dhf() {
        return this.lEw ? this.lFc : this.kIi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dhg() {
        return this.lEw ? this.lFg : this.kIe;
    }

    protected void dhh() {
        Editable text;
        if (dhf() != null && (text = dhf().getText()) != null) {
            int selectionStart = dhf().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dhf().onKeyDown(67, this.gKF);
            }
            dhf().onKeyDown(67, this.gKF);
            int selectionStart2 = dhf().getSelectionStart();
            if (text != null) {
                this.lEz.clear();
                this.lEz.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.lEz);
                dhf().setSelection(selectionStart2);
            }
        }
    }

    private void o(Boolean bool) {
        String str = null;
        if (this.kHM != null) {
            str = this.kHM.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.lEO = true;
        }
    }

    private void dhx() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void dhy() {
        try {
            if (this.lEU != null) {
                this.lEU.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.egi.setCancelListener(null);
        this.egi.setTipString(R.string.sending);
        this.egi.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.egi.setDialogVisiable(false);
    }

    private Boolean dhz() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.dYC = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void cSS() {
        if (this.kHM != null) {
            String str = "";
            String str2 = "";
            if (dhg() != null) {
                str = dhg().getText().toString();
            }
            if (dhf() != null) {
                str2 = dhf().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.kHM.getType() == 0 || this.kHM.getType() == 9 || this.kHM.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.kHN == v.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.kHM.setIsNoTitle(true);
                        } else if (this.lEf.getVisibility() == 0) {
                            this.kHM.setIsNoTitle(false);
                            vc(true);
                            return;
                        }
                    } else if (this.lEf.getVisibility() == 0) {
                        this.kHM.setIsNoTitle(false);
                        vc(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.kHM.setIsNoTitle(true);
                } else if (this.lEf.getVisibility() == 0) {
                    this.kHM.setIsNoTitle(false);
                    vc(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.lEw) {
                    vc(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    vc(true);
                }
            }
            if (this.kHM.getType() == 4) {
                vc(l(this.lFc) && k(this.lFg));
            } else if (this.kHM.getType() == 5) {
                vc(l(this.lFc));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                vc(true);
            } else if (this.kHM.getVideoInfo() != null) {
                vc(true);
            } else {
                vc(false);
            }
        }
    }

    public void vc(boolean z) {
        if (z) {
            am.setNavbarTitleColor(this.kIj, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.kIj.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.kIj, R.color.cp_cont_d, 1);
        this.kIj.setEnabled(false);
    }

    private boolean k(EditText editText) {
        long j = j(editText);
        return j <= 20 && j > 0;
    }

    private boolean l(EditText editText) {
        long j = j(editText);
        if (j > 233) {
            return false;
        }
        return j > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        String str;
        this.dYy = new NewWriteModel(this);
        this.dYy.b(this.dYM);
        registerListener(this.lFz);
        this.gPv = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.cSJ();
            }
        };
        this.kHM = new WriteData();
        if (bundle != null) {
            this.kHM.setType(bundle.getInt("type", 0));
            this.kHM.setForumId(bundle.getString("forum_id"));
            this.kHM.setForumName(bundle.getString("forum_name"));
            this.kHM.setFirstDir(bundle.getString("forum_first_dir"));
            this.kHM.setSecondDir(bundle.getString("forum_second_dir"));
            this.kHM.setThreadId(bundle.getString("thread_id"));
            this.kHM.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.kHM.setFloorNum(bundle.getInt("floor_num", 0));
            this.lEO = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.lEP = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.lEV = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.lEW = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.dYw = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.lEk = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.kHM.setIsAddition(this.lEk != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.lEX = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.kHM.setTitle(bundle.getString("write_title"));
            this.kHM.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.kHM.setTopicId(this.mTopicId);
            this.hzw = bundle.getString("KEY_CALL_FROM");
            this.aVY = bundle.getInt("album_thread");
            this.lyc = (FrsTabInfoData) bundle.getSerializable("tab_list");
            str = string;
        } else {
            Intent intent = getIntent();
            this.kHM.setType(intent.getIntExtra("type", 0));
            this.kHM.setForumId(intent.getStringExtra("forum_id"));
            this.kHM.setForumName(intent.getStringExtra("forum_name"));
            this.kHM.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.kHM.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.kHM.setThreadId(intent.getStringExtra("thread_id"));
            this.kHM.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.kHM.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.lEO = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.lEP = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.lEV = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.lEW = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.lEk = (AdditionData) intent.getSerializableExtra("addition_data");
            this.kHM.setIsAddition(this.lEk != null);
            this.kHM.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.lEX = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.gWB = intent.getStringExtra("more_forum_img");
            this.gWC = intent.getStringExtra("more_forum_title");
            this.gWA = intent.getStringExtra("more_forum_url");
            this.kHM.setTitle(intent.getStringExtra("write_title"));
            this.kHM.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.kHM.setTopicId(this.mTopicId);
            this.hzw = intent.getStringExtra("KEY_CALL_FROM");
            this.aVY = intent.getIntExtra("album_thread", 0);
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.lyc = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            str = stringExtra;
        }
        if (this.kHM.getType() == 9) {
            this.kHM.setEntranceType(1);
        } else if (this.kHM.getType() == 10) {
            this.kHM.setEntranceType(2);
            this.kHM.setType(9);
        } else if (this.kHM.getType() == 0) {
            this.kHM.setEntranceType(3);
        }
        this.kHM.setIsUserFeedback(this.lEO);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.kHM.getType() == 4 ? 6 : 9);
        this.kHM.setWriteImagesInfo(this.writeImagesInfo);
        if (this.kHM.getType() == 0 || this.kHM.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                w.c(this.kHM.getForumId(), this);
            }
        } else if (this.kHM.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                w.c("24591571", this);
            }
        } else if (this.kHM.getType() == 1) {
            w.a(this.kHM.getThreadId(), this);
        } else if (this.kHM.getType() == 4) {
            w.c(this.kHM.getForumId() + "photolive", this);
        } else if (this.kHM.getType() == 5) {
            w.a(this.kHM.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.iTf = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.kHM != null && this.kHM.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.kHM.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.lEd = true;
        }
        dgZ();
        try {
            this.lFm = dhI();
        } catch (Throwable th) {
            this.lFm = null;
        }
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.kHM.mDynamicImageTextData = new ImageTextUploadData();
            this.lCj = true;
        }
    }

    private void dhi() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.kIe.setText(com.baidu.tbadk.plugins.b.xc(com.baidu.tbadk.plugins.b.xd(hotTopicBussinessData.mTopicName)));
            this.kIe.setMovementMethod(com.baidu.tieba.view.c.deB());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) v.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString xc = com.baidu.tbadk.plugins.b.xc(com.baidu.tbadk.plugins.b.xd(hotTopicBussinessData.mTopicName));
            if (xc != null) {
                this.kIe.setText(xc);
            }
            this.lEy.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.w.a
    public void a(WriteData writeData) {
        String str;
        String xd;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            if (writeData != null) {
                if (this.kHM != null) {
                    this.kHM.setHaveDraft(true);
                    if (com.baidu.adp.lib.util.k.isEmpty(dhg().getText().toString()) || this.lFt || ((this.lEO || this.lEd) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                        if (com.baidu.adp.lib.util.k.isEmpty(this.kHM.getTitle())) {
                            this.kHM.setTitle(writeData.getTitle());
                        }
                        if (!v.isEmpty(this.mList)) {
                            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.getItem(this.mList, 0);
                            if (hotTopicBussinessData == null) {
                                str = null;
                            } else {
                                str = hotTopicBussinessData.mTopicName;
                            }
                            if (StringUtils.isNull(str)) {
                                xd = this.kHM.getTitle();
                            } else {
                                xd = com.baidu.tbadk.plugins.b.xd(str);
                            }
                            SpannableString xc = com.baidu.tbadk.plugins.b.xc(xd);
                            if (xc != null) {
                                dhg().setText(xc);
                                dhg().setSelection(xc.length() > xd.length() ? xd.length() : xc.length());
                            }
                        } else {
                            SpannableString xc2 = com.baidu.tbadk.plugins.b.xc(this.kHM.getTitle());
                            if (xc2 != null) {
                                dhg().setText(xc2);
                                dhg().setSelection(this.kHM.getTitle().length() > xc2.length() ? xc2.length() : this.kHM.getTitle().length());
                            }
                        }
                    }
                    if (this.kHM != null && !this.kHM.getHaveDraft()) {
                        dgY();
                    }
                    if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.copy(writeData.getVideoInfo());
                        this.kHM.setVideoInfo(videoInfo);
                        this.dWS.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                    }
                    if ((com.baidu.adp.lib.util.k.isEmpty(dhf().getText().toString()) || this.lEO || this.lEd) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                        this.kHM.setContent(writeData.getContent());
                        SpannableString a2 = TbFaceManager.aYj().a(getPageContext().getPageActivity(), this.kHM.getContent(), this.lED);
                        dhf().setText(a2);
                        dhf().setSelection(a2.length());
                        if (this.lEw) {
                            a(this.lFi, this.lFc);
                        }
                    }
                    if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                        this.writeImagesInfo = writeData.getWriteImagesInfo();
                        this.kHM.setWriteImagesInfo(this.writeImagesInfo);
                        dhG();
                        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                            dho();
                        }
                        ve(false);
                    }
                    if (writeData.getType() == 4 || writeData.getType() == 5) {
                        dhA();
                    }
                    cSS();
                    int categoryTo = writeData.getCategoryTo();
                    if (categoryTo >= 0 && this.lEp != null) {
                        this.lEt = this.lEq.hcf;
                        this.lEs = this.lEq.name;
                        int i = 0;
                        while (true) {
                            if (i == this.lEp.size()) {
                                break;
                            }
                            aa aaVar = this.lEp.get(i);
                            if (categoryTo != aaVar.hcf) {
                                i++;
                            } else {
                                this.lEt = categoryTo;
                                this.lEs = aaVar.name;
                                this.kHM.setCategoryTo(this.lEt);
                                break;
                            }
                        }
                        if (this.lEu != null) {
                            this.lEu.setText(this.lEs);
                            this.lEu.setCategoryContainerData(this.lEp, this.lEq, this.lEt);
                        }
                    }
                    this.dWS.aVq();
                    return;
                }
                return;
            }
            dhA();
            dgY();
        }
    }

    private void dhA() {
        if ((!this.lEw || this.lFb != null) && this.lFa != null) {
            this.lFb.b(this.writeImagesInfo);
            dhE();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.kHM.getType());
        bundle.putString("forum_id", this.kHM.getForumId());
        bundle.putString("forum_name", this.kHM.getForumName());
        bundle.putString("forum_first_dir", this.kHM.getFirstDir());
        bundle.putString("forum_second_dir", this.kHM.getSecondDir());
        bundle.putString("thread_id", this.kHM.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.kHM.getFloor());
        bundle.putInt("floor_num", this.kHM.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.lEV);
        if (this.lEO) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.dYw);
        if (this.lEk != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.lEk));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.lEX);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.hzw);
        bundle.putInt("album_thread", this.aVY);
        bundle.putInt("private_thread", this.privateThread);
        bundle.putSerializable("tab_list", this.lyc);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dhf().getEditableText().toString();
        if (obj != null) {
            dhf().setText(TbFaceManager.aYj().a(getPageContext().getPageActivity(), obj, this.lED));
            dhf().setSelection(dhf().getText().length());
        }
    }

    private String dhj() {
        return (dhf() == null || dhf().getText() == null) ? "" : dhf().getText().toString();
    }

    private String dhk() {
        if (this.kHM == null || dhg() == null || dhg().getVisibility() != 0 || dhg().getText() == null) {
            return "";
        }
        String obj = dhg().getText().toString();
        if (this.mPrefixData != null && v.getCount(this.mPrefixData.getPrefixs()) > 0 && this.kHN != v.getCount(this.mPrefixData.getPrefixs()) - 1 && this.kHM.getType() != 4 && this.kIk != null && this.kIk.getText() != null) {
            this.kHM.setPostPrefix(this.kIk.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.kHM.getTitle();
        }
        return obj;
    }

    private void MN(String str) {
        if (this.kHM != null && this.lEf != null) {
            if (this.lEf.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.kHM.setIsNoTitle(true);
                    this.kHM.setTitle("");
                    return;
                }
                this.kHM.setIsNoTitle(false);
                this.kHM.setTitle(str);
                return;
            }
            this.kHM.setIsNoTitle(true);
            this.kHM.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhl() {
        cSJ();
        this.kHM.setContent(dhj());
        MN(dhk());
        if (this.lEO || this.lEd) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.kHM.getTitle()) || !this.kHM.getTitle().startsWith(string)) {
                MN(string + this.kHM.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.kHM.getContent()) || !this.kHM.getContent().startsWith(str)) {
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
                sb.append(this.kHM.getContent());
                this.kHM.setContent(sb.toString());
            }
        }
        if (this.lEr >= 0) {
            this.kHM.setCategoryFrom(this.lEr);
        }
        if (this.lEt >= 0) {
            this.kHM.setCategoryTo(this.lEt);
        }
        this.kHM.setWriteImagesInfo(this.writeImagesInfo);
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
            this.kHM.setTakePhotoNum(i);
        }
        this.kHM.setHasLocationData(this.dYx != null && this.dYx.bAS());
        if (this.writeImagesInfo != null) {
            this.dYy.ua(this.writeImagesInfo.size() > 0);
        }
        if (!v.isEmpty(this.mList) && this.lEx != null && this.lEx.mIsGlobalBlock == 0) {
            this.kHM.setForumId(String.valueOf(this.lEx.mForumId));
            this.kHM.setForumName(this.lEx.mForumName);
        }
        dgi();
        this.dYy.d(this.kHM);
        this.kHM.setContent(this.kHM.getContent().replaceAll("\u0000\n", ""));
        this.kHM.setContent(this.kHM.getContent().replaceAll("\u0000", ""));
        this.kHM.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.dYy.cSL().setVoice(this.mVoiceModel.getId());
                this.dYy.cSL().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.dYy.cSL().setVoice(null);
                this.dYy.cSL().setVoiceDuringTime(-1);
            }
        } else {
            this.dYy.cSL().setVoice(null);
            this.dYy.cSL().setVoiceDuringTime(-1);
        }
        if (!this.dYy.cXC()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.kHM.mDynamicImageTextData != null) {
            dgh();
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.gPv);
            this.dYy.cXz();
        }
    }

    private void dgi() {
        FrsTabItemData selectedTabItemData;
        if (this.kHM != null && this.lCE != null && (selectedTabItemData = this.lCE.getSelectedTabItemData()) != null) {
            this.kHM.setTabId(selectedTabItemData.tabId);
            this.kHM.setTabName(selectedTabItemData.name);
            this.kHM.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    public void dgh() {
        if (this.kHM.mDynamicImageTextData != null) {
            showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
            com.baidu.tieba.write.b.a.a(this.kHM, new a.InterfaceC0695a() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                @Override // com.baidu.tieba.write.b.a.InterfaceC0695a
                public void a(BaseUploadData baseUploadData) {
                    com.baidu.tieba.write.b.c.b.dfT().a((ImageTextUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.write.WriteActivity.33.1
                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onSuccess(String str) {
                            com.baidu.tieba.write.b.a.dfK();
                            WriteActivity.this.closeLoadingDialog();
                            com.baidu.tieba.tbadkCore.writeModel.c.g(WriteActivity.this.getPageContext().getPageActivity(), null, null, null);
                            WriteActivity.this.hI(true);
                            Intent intent = new Intent();
                            intent.putExtras(new Bundle());
                            WriteActivity.this.setResult(-1, intent);
                            WriteActivity.this.finish();
                        }

                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onFail(String str) {
                            com.baidu.tieba.write.b.a.dfK();
                            WriteActivity.this.closeLoadingDialog();
                            if (TextUtils.isEmpty(str)) {
                                str = TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error);
                            }
                            l.showToast(TbadkCoreApplication.getInst(), str);
                        }
                    });
                }

                @Override // com.baidu.tieba.write.b.a.InterfaceC0695a
                public void onError() {
                    WriteActivity.this.closeLoadingDialog();
                    l.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error));
                }
            });
        }
    }

    private void C(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.lEk != null) {
                i2 = this.lEk.getTotalCount();
                i = this.lEk.getAlreadyCount() + 1;
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
                if (this.kIe == getCurrentFocus()) {
                    dhf().clearFocus();
                    this.kIe.requestFocus();
                    if (this.dWS != null) {
                        this.dWS.aVq();
                    }
                    ShowSoftKeyPadDelay(this.kIe);
                } else {
                    dhf().requestFocus();
                    if (this.dWS != null) {
                        this.dWS.aVq();
                    }
                    ShowSoftKeyPadDelay(this.kIi);
                }
                ArrayList<String> stringArrayListExtra = intent != null ? intent.getStringArrayListExtra("name_show") : null;
                if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < stringArrayListExtra.size()) {
                            sb.append(UgcConstant.AT_RULE_TAG);
                            sb.append(stringArrayListExtra.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            dhf().getText().insert(dhf().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.kHM.getType() == 0 || this.kHM.getType() == 9) {
                    w.c(this.kHM.getForumId(), (WriteData) null);
                    if (postWriteCallBackData2 != null) {
                    }
                } else if (this.kHM.getType() == 1) {
                    w.d(this.kHM.getThreadId(), (WriteData) null);
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
                                dhF();
                            } else {
                                ap(intent);
                            }
                        } else if (intExtra == 1) {
                            aq(intent);
                        } else {
                            an(intent);
                            com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.lFx) {
                            vd(true);
                            this.lFx = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.lEw) {
                        G(intent);
                        cSS();
                        return;
                    }
                    ao(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.kHM.setVideoInfo(videoInfo);
                        this.dWS.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.dWS.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.dWS.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    cSS();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.lEb) {
                                sb2.append(com.baidu.tbadk.plugins.b.efO);
                                this.lEb = false;
                            }
                            sb2.append(stringExtra);
                            wy(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !v.isEmpty(this.mList) && !v.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                    this.lEx = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                    a(this.lEx);
                }
            }
        } else if (i2 == 0) {
            if (this.dWS != null && !this.dWS.aWP()) {
                this.kIi.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.dWS.aVq();
            }
            switch (i) {
                case 12001:
                    aXv();
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    dhD();
                    if (this.lFx) {
                        vd(true);
                        this.lFx = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.kIe == getCurrentFocus()) {
                        dhf().clearFocus();
                        this.kIe.requestFocus();
                        if (this.dWS != null) {
                            this.dWS.aVq();
                        }
                        ShowSoftKeyPadDelay(this.kIe);
                        return;
                    }
                    dhf().requestFocus();
                    if (this.dWS != null) {
                        this.dWS.aVq();
                    }
                    ShowSoftKeyPadDelay(this.kIi);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.lEB.Ms(postWriteCallBackData.getErrorString());
                        this.lEB.aW(postWriteCallBackData.getSensitiveWords());
                        this.lEB.b(this.kIe, this.kIi);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.dYw = String.valueOf(System.currentTimeMillis());
                    al.a(getPageContext(), this.dYw);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dhD();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.lEa)) {
                        dhg().requestFocus();
                        return;
                    } else if ("from_content".equals(this.lEa)) {
                        dhf().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhm() {
        if ("1".equals(this.hzw)) {
            this.kHM.setCanNoForum(true);
            this.kHM.setTransmitForumData("[]");
        } else if ("2".equals(this.hzw)) {
            this.kHM.setCanNoForum(false);
        }
        dhn();
        this.kHM.setPrivacy(this.isPrivacy);
        dhB();
        this.kHM.setToDynamic(this.isToDynamic);
        this.kHM.setCallFrom(this.hzw);
        if (this.kHM.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        dhl();
    }

    private void dhn() {
        if (this.dWS != null) {
            this.dWS.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void dhB() {
        if (this.dWS != null) {
            this.dWS.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void dhC() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void dhD() {
        if (this.lEw) {
            this.lFb.b(this.writeImagesInfo);
            dhE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhE() {
        this.lFb.notifyDataSetChanged();
        this.lFa.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.lFb.notifyDataSetChanged();
                WriteActivity.this.lFa.invalidateViews();
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
        cSS();
    }

    private void an(Intent intent) {
        if (this.lEw) {
            ao(intent);
            dhD();
        } else {
            ar(intent);
        }
        cSS();
    }

    private void ao(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            dhD();
            ve(true);
        }
    }

    private void ap(Intent intent) {
        if (this.writeImagesInfo != null) {
            F(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, size)));
            }
        }
    }

    private void dhF() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void aq(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.lEY.parseJson(stringExtra);
            this.lEY.updateQuality();
            if (this.lEY.getChosedFiles() != null && this.lEY.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.lEY.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.lEY.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dhg());
        HidenSoftKeyPad(this.mInputManager, dhf());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ar(Intent intent) {
        c(intent, true);
    }

    private void F(Intent intent) {
        this.dYw = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.dYw;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.getEquipmentWidth(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.dYw, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            dhG();
            dho();
        }
        ve(true);
    }

    private void G(Intent intent) {
        c(intent, false);
    }

    private void c(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                dhG();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    dho();
                }
            }
            ve(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhG() {
        if (this.dWS.mD(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void aXv() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.dYw));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void dhH() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.gWB)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                com.baidu.tbadk.util.o oVar = new com.baidu.tbadk.util.o(this, this.gWB, new o.a() { // from class: com.baidu.tieba.write.write.WriteActivity.38
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
                            WriteActivity.this.ve(true);
                        }
                    }
                });
                oVar.setFrom(1);
                oVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve(boolean z) {
        String forumId = this.kHM == null ? "" : this.kHM.getForumId();
        if (this.lEZ != null) {
            this.lEZ.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.gYv == null) {
            this.gYv = VoiceManager.instance();
        }
        return this.gYv;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bOS() {
        this.gYv = getVoiceManager();
        this.gYv.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bq(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.gZC) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).af("obj_locate", at.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.kHM.getType() != 7) {
                if (this.lEk == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                C(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.dYD = i;
        if (this.dWS != null) {
            this.dWS.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void dho() {
        if (!this.lEw) {
            if (this.dWS != null) {
                this.dWS.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.dWS.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.kHM == null ? "" : this.kHM.getForumId();
            if (this.lEZ != null) {
                this.lEZ.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hI(boolean z) {
        if (this.dWS != null) {
            this.dWS.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Fa(int i) {
        if (i < this.lEi.size()) {
            for (int i2 = 0; i2 < this.lEi.size(); i2++) {
                this.lEi.get(i2).uR(false);
            }
            this.lEi.get(i).uR(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void CL(int i) {
        if (i == v.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new an("c13014").af("obj_type", 1));
        } else {
            TiebaStatic.log(new an("c13014").af("obj_type", 2));
        }
        this.kHN = i;
        this.kIl.setCurrentIndex(i);
        Fa(i);
        this.kIk.setText(this.mPrefixData.getPrefixs().get(i));
        cSS();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.kIl, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.kIn.setSelected(false);
        am.setImageResource(this.kIm, R.drawable.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.kIi);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes2.dex */
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
        if (this.kHM != null) {
            if (this.kHM.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.kHM.getType() == 5) {
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
            aXp();
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = ab.transformPermissionResult(strArr, iArr);
            if (ab.checkCamera(getApplicationContext())) {
                al.a(getPageContext(), this.dYw);
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
        this.aOv = z;
        if (this.lFr && System.currentTimeMillis() - this.lFs < 800) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.lFr = false;
        }
        if (this.lEA != null && !z) {
            this.lEA.bIM();
        }
        if (this.lEC != null && !z) {
            dgQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MO(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.lFo != null) {
            MP(str);
            this.lFo.dismiss();
        }
    }

    private void fj(Context context) {
        lFq = l.getEquipmentHeight(context);
    }

    private void MP(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.lFr = true;
        dhG();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            dho();
        }
        ve(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [4568=4] */
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

    private File dhI() {
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

    private void dhJ() {
        if (this.lFm != null && this.kHM.getType() == 0 && this.kHM.getType() == 9) {
            fj(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.lFm != null) {
                        WriteActivity.this.MO(WriteActivity.this.lFm.getAbsolutePath());
                    }
                }
            });
            this.lFn = (TbImageView) this.mBubbleView.findViewById(R.id.rec_img_view);
            this.lFp = (LinearLayout) this.mBubbleView.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.aNT().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.lFm.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.aNT().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.lFm.getAbsolutePath());
                Bitmap g = g(this.lFm.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (g != null) {
                    this.lFn.setImageBitmap(g);
                    this.lFn.setDrawBorder(true);
                    this.lFn.setBorderWidth(2);
                    this.lFn.setBorderColor(am.getColor(R.color.common_color_10264));
                    this.lFo = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.lFo.setCanceledOnTouchOutside(true);
                    this.lFo.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.lFr) {
                                l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.lFs = System.currentTimeMillis();
                            }
                        }
                    });
                    this.lFo.setContentView(this.mBubbleView);
                    this.lFo.show();
                    Window window = this.lFo.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (lFq / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.aOv && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.lEb = false;
            this.lEa = "";
            if ("from_content".equals(str)) {
                this.lEa = "from_content";
            } else if ("from_title".equals(str)) {
                this.lEa = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.xb(String.valueOf(charSequence.charAt(i)))) {
                vb(false);
            }
        }
    }

    public void cNW() {
        if (this.lEO || !v.isEmpty(this.mList) || !StringUtils.isNull(this.kHM.getTitle())) {
            this.lEf.setVisibility(0);
            this.lEf.requestFocus();
            return;
        }
        this.lEf.setVisibility(8);
    }
}
