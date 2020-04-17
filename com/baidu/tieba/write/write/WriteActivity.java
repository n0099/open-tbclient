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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0100a, VoiceManager.c, w.a, h.a {
    private static int lFm = 0;
    private EditorTools dWN;
    private String dYr;
    private LocationModel dYs;
    private NewWriteModel dYt;
    private String gWu;
    private String gWv;
    private String gWw;
    private VoiceManager gYp;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private LinearLayout jvp;
    private PlayVoiceBntNew jvq;
    private ImageView jvs;
    private int kHJ;
    private TextView kIg;
    private com.baidu.tieba.write.h kIh;
    private ImageView kIi;
    private View kIj;
    private ForumTabSelectedView lCA;
    private com.baidu.tieba.view.b lEF;
    private View lEO;
    private g lEV;
    private LinearLayout lEa;
    private LinearLayout lEb;
    private View lEd;
    private Toast lEf;
    private AdditionData lEg;
    private RelativeLayout lEh;
    private TextView lEi;
    private TextView lEj;
    private TextView lEk;
    List<aa> lEl;
    aa lEm;
    private int lEn;
    private String lEo;
    private int lEp;
    private PostCategoryView lEq;
    private HotTopicBussinessData lEt;
    private TextView lEu;
    private com.baidu.tieba.write.editor.b lEw;
    private e lEy;
    private View lFq;
    private View lFr;
    private TextView lFs;
    private com.baidu.tieba.c.d lFu;
    private FrsTabInfoData lxY;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String lDW = "";
    private boolean lDX = false;
    private WriteData kHI = null;
    private boolean lEK = false;
    private boolean lDZ = false;
    private boolean lEL = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText kIa = null;
    private HeadImageView lEM = null;
    private View kIb = null;
    private LinearLayout kId = null;
    private EditText kIe = null;
    private FeedBackModel lEc = null;
    private FeedBackTopListView lEN = null;
    private ArrayList<WritePrefixItemLayout> lEe = new ArrayList<>();
    private String iTb = null;
    private final KeyEvent gKz = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView lEP = null;
    private TextView kIf = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener gPp = null;
    private com.baidu.tbadk.core.dialog.a lEQ = null;
    private final Handler mHandler = new Handler();
    private boolean lER = false;
    private String lES = null;
    private RelativeLayout idy = null;
    private String dYx = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int dYy = 0;
    private int lET = 0;
    private WriteImagesInfo lEU = new WriteImagesInfo();
    private View mRootView = null;
    private GridView lEW = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a lEX = null;
    private ScrollView lEr = null;
    private EditText lEY = null;
    private View lEZ = null;
    private View lFa = null;
    private View lFb = null;
    private EditText lFc = null;
    private TextView lFd = null;
    private TextView lFe = null;
    private TextWatcher lFf = null;
    private TextWatcher lFg = null;
    private boolean lEs = false;
    private boolean lFh = false;
    private com.baidu.tbadk.core.view.a egd = null;
    private String mFrom = "write";
    private File lFi = null;
    private TbImageView lFj = null;
    private View mBubbleView = null;
    private Dialog lFk = null;
    private LinearLayout lFl = null;
    private boolean lFn = false;
    private long lFo = -1000;
    private boolean lFp = false;
    private String hzq = "2";
    private int aVT = 0;
    private String mTopicId = "";
    private SpannableStringBuilder lEv = new SpannableStringBuilder();
    private boolean lFt = false;
    private boolean aOp = false;
    private final b lEx = new b();
    private boolean lCf = false;
    private final HttpMessageListener lFv = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.iTb)) {
                    WriteActivity.this.iTb = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.vd(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.iTb)) {
                    WriteActivity.this.iTb = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.iTb);
                    WriteActivity.this.vd(true);
                }
            }
        }
    };
    private TbFaceManager.a lEz = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan wK(String str) {
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
    private final AntiHelper.a gZw = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).af("obj_locate", at.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).af("obj_locate", at.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d dYH = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.aa aaVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.bOT();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.kHI != null) {
                WriteActivity.this.lEx.aW(null);
                if (z) {
                    WriteActivity.this.hI(z);
                    if (WriteActivity.this.e(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    if (WriteActivity.this.kHI.getType() != 0 && WriteActivity.this.kHI.getType() != 9) {
                        if (WriteActivity.this.kHI.getType() != 7) {
                            if (WriteActivity.this.kHI.getType() == 1) {
                                w.d(WriteActivity.this.kHI.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.kHI.getType() == 5) {
                                w.d(WriteActivity.this.kHI.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            w.c("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            w.c(WriteActivity.this.kHI.getForumId(), (WriteData) null);
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
                    WriteActivity.this.lEx.aW(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.lEx.Mp(postWriteCallBackData.getErrorString());
                    WriteActivity.this.lEx.b(WriteActivity.this.kIa, WriteActivity.this.kIe);
                } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aSi());
                    if (com.baidu.tbadk.s.a.xo(aaVar.aSh())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aSh());
                        if (WriteActivity.this.lEL) {
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
    private final LocationModel.a dYF = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void aXG() {
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
            if (aVar != null && !StringUtils.isNull(aVar.cWV())) {
                WriteActivity.this.a(2, true, aVar.cWV());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener kUQ = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.dYs.tY(false);
                    WriteActivity.this.dYs.eT(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.dYs.tY(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener lEA = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener lEB = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.dWN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dgP = WriteActivity.this.dgP();
            if (dgP >= 0 && dgP < WriteActivity.this.kIe.getText().length()) {
                WriteActivity.this.kIe.setSelection(dgP);
            }
        }
    };
    private boolean lEC = true;
    private final View.OnFocusChangeListener fAV = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.kIa || view == WriteActivity.this.mBack || view == WriteActivity.this.kIf) {
                if (z) {
                    WriteActivity.this.lEC = true;
                    WriteActivity.this.dgQ();
                    l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.kIa);
                    if (WriteActivity.this.dWN != null) {
                        WriteActivity.this.dWN.aVs();
                    }
                } else if (view == WriteActivity.this.kIa) {
                    WriteActivity.this.kIg.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.kIe && z) {
                WriteActivity.this.lEC = false;
                WriteActivity.this.dgQ();
                l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.kIe);
                if (WriteActivity.this.dWN != null) {
                    WriteActivity.this.dWN.aVs();
                }
            }
            WriteActivity.this.dgV();
        }
    };
    private TextWatcher lED = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String lEH = "";
        private String lEI;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.lEI = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.lEI != null ? this.lEI.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cSU();
            WriteActivity.this.dgW();
            EditText dhi = WriteActivity.this.dhi();
            if (editable != null && dhi != null && dhi.getText() != null) {
                if (this.lEH == null || !this.lEH.equals(editable.toString())) {
                    if (WriteActivity.this.lEx != null) {
                        this.lEH = dhi.getText().toString();
                        WriteActivity.this.lEx.b(dhi, true);
                        return;
                    }
                    return;
                }
                dhi.setSelection(dhi.getSelectionEnd());
            }
        }
    };
    private TextWatcher lEE = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String lEI;
        private String lEJ = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.lEI = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.lEI != null ? this.lEI.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.cSU();
            EditText dhh = WriteActivity.this.dhh();
            if (editable != null && dhh != null && dhh.getText() != null) {
                if (this.lEJ == null || !this.lEJ.equals(editable.toString())) {
                    if (WriteActivity.this.lEx != null) {
                        this.lEJ = dhh.getText().toString();
                        WriteActivity.this.lEx.b(dhh, false);
                        return;
                    }
                    return;
                }
                dhh.setSelection(dhh.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0652a jBr = new a.InterfaceC0652a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0652a
        public void onRefresh() {
            WriteActivity.this.iTb = null;
            WriteActivity.this.vd(false);
            WriteActivity.this.dWN.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void aXq() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void aXr() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aXt();
        } else if (this.dYs.cXc()) {
            aXq();
        } else {
            this.dYs.tY(false);
            a(1, true, (String) null);
            this.dYs.cXa();
        }
    }

    public void dhs() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
            if (this.lEw != null) {
                this.lEw.dfI();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aXt();
        } else if (this.dYs != null) {
            this.dYs.tY(false);
            a(1, true, (String) null);
            this.dYs.cXa();
        }
    }

    private void aXt() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.kd(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.dYs.cXe();
                } else {
                    WriteActivity.this.dYF.aXG();
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
        aVar.aMU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dgP() {
        int selectionEnd = dhh().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dhh().getText().getSpans(0, dhh().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dhh().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dhh().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgQ() {
        if (this.dWN != null) {
            this.dWN.setBarLauncherEnabled(!this.lEC);
            this.dWN.setBarLauncherEnabled(true, 26);
            this.dWN.setBarLauncherEnabled(true, 2);
            this.dWN.setBarLauncherEnabled(true, 30);
            ac(9, this.lEC ? false : true);
        }
    }

    private void ac(int i, boolean z) {
        com.baidu.tbadk.editortools.g mA;
        if (this.dWN != null && (mA = this.dWN.mA(i)) != null) {
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
        if (this.lEs) {
            this.kIa.setVisibility(8);
            if (this.kHI.getType() == 5) {
                this.lFb.setVisibility(8);
            } else {
                this.lFb.setVisibility(0);
            }
            a(this.lFe, this.lEY);
            a(this.lFd, this.lFc);
            cSU();
        }
        if (this.lEK) {
            this.lEC = true;
            dgQ();
            if (this.dWN != null) {
                this.dWN.aVs();
            }
            this.kIa.requestFocus();
            ShowSoftKeyPadDelay(this.kIa);
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
            dhI();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                dhq();
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
        if (this.kHI.getType() == 0) {
            Fb(this.aVT);
        }
        initUI();
        dhx();
        this.dYs = new LocationModel(getPageContext());
        this.dYs.a(this.dYF);
        registerListener(this.kUQ);
        registerListener(this.lEA);
        cqO();
        dhL();
        if (this.lEs) {
            this.lEX.setEditorTools(this.dWN);
        } else {
            this.kIe.requestFocus();
        }
        cNY();
        dhq();
        dhJ();
    }

    @SuppressLint({"ResourceAsColor"})
    private void cqO() {
        this.dWN = new EditorTools(getActivity());
        this.dWN.setBarMaxLauCount(5);
        this.dWN.setMoreButtonAtEnd(true);
        this.dWN.setBarBackgroundColorId(R.color.cp_bg_line_h);
        this.dWN.setBarLauncherType(1);
        this.dWN.hA(true);
        this.dWN.hB(true);
        switch (this.kHI.getType()) {
            case 4:
            case 5:
                dhv();
                break;
            default:
                dgR();
                break;
        }
        this.dWN.build();
        if (this.lEa != null) {
            this.lEa.addView(this.dWN);
        }
        ckJ();
        this.dWN.display();
        com.baidu.tbadk.editortools.g mA = this.dWN.mA(6);
        if (mA != null && !TextUtils.isEmpty(this.dYx)) {
            ((View) mA).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.dYx);
                }
            });
        }
        if (!this.lEs) {
            this.dWN.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.dWN.aVs();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.dWN.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.dWN.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (!this.lCf) {
            dgT();
        }
    }

    private void dht() {
        this.lEZ = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.lFb = this.lEZ.findViewById(R.id.live_post_title_container);
        this.lEY = (EditText) this.lEZ.findViewById(R.id.live_post_content);
        this.lEW = (GridView) this.lEZ.findViewById(R.id.photoLiveGridView);
        this.lFc = (EditText) this.lEZ.findViewById(R.id.live_post_title);
        this.lFd = (TextView) this.lEZ.findViewById(R.id.titleOverPlusNumber);
        this.lFe = (TextView) this.lEZ.findViewById(R.id.contentOverPlusNumber);
        this.lFa = this.lEZ.findViewById(R.id.live_interval_view);
        this.lFd.setText(String.valueOf(20));
        this.lFe.setText(String.valueOf(233));
        this.lEZ.setVisibility(0);
        this.lFd.setVisibility(0);
        this.lFe.setVisibility(0);
        this.lFc.setHint(R.string.tips_title_limit_new);
        this.lFc.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.lFh = true;
                    WriteActivity.this.lEC = true;
                    WriteActivity.this.dgQ();
                    if (WriteActivity.this.dWN != null) {
                        WriteActivity.this.dWN.aVs();
                    }
                }
            }
        });
        if (this.kHI.getType() == 4) {
            this.lEY.setHint(R.string.live_write_input_content_new);
        } else if (this.kHI.getType() == 5) {
            this.lEY.setHint(R.string.live_write_input_content_update);
        }
        this.lEY.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.lFh = false;
                    WriteActivity.this.lEC = false;
                    WriteActivity.this.dgQ();
                    if (WriteActivity.this.dWN != null) {
                        WriteActivity.this.dWN.aVs();
                    }
                }
            }
        });
        this.lEY.requestFocus();
        this.lEY.addTextChangedListener(abE());
        this.lFc.requestFocus();
        this.lFc.addTextChangedListener(abE());
        this.lFc.setOnClickListener(this.lEB);
        this.lEY.setOnClickListener(this.lEB);
        this.lEX = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.lEW);
        this.lEX.EV(6);
        this.lEW.setAdapter((ListAdapter) this.lEX);
        View findViewById = this.lEZ.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void dgB() {
                WriteActivity.this.dhG();
            }
        });
        dhu();
    }

    private void dhu() {
        if (this.kHI.getType() == 0) {
            if (this.kHI.getTitle() != null) {
                this.lFc.setText(this.kHI.getTitle());
                this.lFc.setSelection(this.kHI.getTitle().length());
                return;
            }
            return;
        }
        if (this.kHI.getType() == 1 || this.kHI.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.lEs) {
            dhE();
        }
        if (this.dWN.aWR()) {
            this.dWN.aVs();
        }
        Fb(0);
    }

    private void Fb(int i) {
        if (this.writeImagesInfo != null && this.kHI != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.kHI.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.kHI.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.hzq);
            albumActivityConfig.setProfessionZone(this.kHI.getProZone());
            albumActivityConfig.setFrsTabInfo(this.lxY);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void dhv() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.dWN.aR(arrayList);
        com.baidu.tbadk.editortools.l mD = this.dWN.mD(5);
        if (mD != null) {
            mD.dXx = 2;
        }
        this.dWN.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.dWN.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void dgR() {
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
            this.dWN.b(dVar);
        }
        if (!this.lCf) {
            Boolean dhB = dhB();
            if (!this.lEK && dhB != null && dhB.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.cXA() && s.d(this.kHI.getForumName(), true) && (runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar5 = (com.baidu.tbadk.editortools.l) runTask5.getData()) != null) {
                lVar5.dXx = 3;
                if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    this.dWN.b(lVar5);
                }
            }
        }
        if (!this.lCf) {
            this.dWN.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 4));
        }
        if (!this.lCf && (runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar4 = (com.baidu.tbadk.editortools.l) runTask4.getData()) != null) {
            lVar4.dXx = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dWN.b(lVar4);
            }
        }
        if (!this.lCf) {
            this.dWN.b(new com.baidu.tbadk.editortools.k(getActivity(), 6));
        }
        if (!this.lCf && (runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar3 = (com.baidu.tbadk.editortools.l) runTask3.getData()) != null) {
            lVar3.dXx = 7;
            this.dWN.b(lVar3);
        }
        if (!this.lCf) {
            this.dWN.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 8));
        } else {
            this.dWN.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        }
        if (!this.lCf && (runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar2 = (com.baidu.tbadk.editortools.l) runTask2.getData()) != null) {
            lVar2.dXz = true;
            lVar2.dXx = 9;
            lVar2.dXt = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dWN.b(lVar2);
            }
        }
        if (!this.lCf && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar.dXz = true;
            lVar.dXx = 10;
            lVar.dXt = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.dWN.b(lVar);
            }
        }
        if (!this.lCf && this.lEg == null) {
            if (this.lEw == null) {
                this.lEw = new com.baidu.tieba.write.editor.b(getActivity(), this.hzq);
                this.lEw.bJ(this.kHI.getForumId(), this.privateThread);
                this.lEw.uV(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.lEw.dfE();
                this.lEw.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                dhs();
            }
            if (!v.isEmpty(this.mList)) {
                this.lEw.dfE();
            }
            this.dWN.b(this.lEw);
        }
        this.dWN.aR(arrayList);
        com.baidu.tbadk.editortools.l mD = this.dWN.mD(5);
        if (mD != null) {
            mD.dXx = 1;
        }
    }

    private void dgS() {
        if (this.lEy != null) {
            this.lEy.hideTip();
        }
    }

    private void dgT() {
        if (this.lEy == null) {
            this.lEy = new e(getPageContext());
        }
        this.lEy.c(this.dWN);
    }

    private void ckJ() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.dhg()) {
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
                            if (qVar.aRY() == EmotionGroupType.BIG_EMOTION || qVar.aRY() == EmotionGroupType.USER_COLLECT) {
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
                                    WriteActivity.this.cSU();
                                }
                            } else if (WriteActivity.this.dhg()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(qVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.dhj();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.cys();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.dhI();
                        WriteActivity.this.cSU();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.Fc(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new an("c12612").af("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.lEg == null) {
                            WriteActivity.this.aXu();
                            return;
                        }
                        switch (WriteActivity.this.dYy) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.aXr();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.aXq();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.dYs != null) {
                            WriteActivity.this.dYs.tY(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.iTb = null;
                        } else {
                            WriteActivity.this.iTb = (String) aVar.data;
                        }
                        WriteActivity.this.vd(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        an anVar = new an("c10645");
                        if (WriteActivity.this.kHI != null) {
                            str = WriteActivity.this.kHI.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.cI("fid", str);
                        TiebaStatic.log(anVar);
                        if (WriteActivity.this.kHI == null || (videoInfo = WriteActivity.this.kHI.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.dWN.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.dWN.aWR()) {
                                        WriteActivity.this.dWN.aVs();
                                        WriteActivity.this.dWN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.dWN.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.dWN.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.dWN.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.dWN.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.kHI.setVideoInfo(null);
                        WriteActivity.this.cSU();
                        if (WriteActivity.this.kIe != null) {
                            WriteActivity.this.kIe.requestFocus();
                        }
                        WriteActivity.this.dWN.aVs();
                        WriteActivity.this.dWN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.kIe);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new an("c12612").af("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.dWN.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.lDX = true;
                        WriteActivity.this.vb(true);
                        if (!WriteActivity.this.dhi().isFocused() || WriteActivity.this.lEb.getVisibility() != 0) {
                            WriteActivity.this.lDW = "from_content";
                        } else {
                            WriteActivity.this.lDW = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        if (WriteActivity.this.lEb.getVisibility() == 0) {
                            if (WriteActivity.this.lEb.hasFocus()) {
                                WriteActivity.this.kIe.requestFocus();
                                WriteActivity.this.kIe.setSelection(WriteActivity.this.kIe.getText().toString().length());
                            }
                            WriteActivity.this.lEb.setVisibility(8);
                            WriteActivity.this.dWN.mA(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.lEb.setVisibility(0);
                            WriteActivity.this.lEb.requestFocus();
                            WriteActivity.this.dWN.mA(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.cSU();
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
        this.dWN.setActionListener(16, bVar);
        this.dWN.setActionListener(14, bVar);
        this.dWN.setActionListener(24, bVar);
        this.dWN.setActionListener(3, bVar);
        this.dWN.setActionListener(10, bVar);
        this.dWN.setActionListener(11, bVar);
        this.dWN.setActionListener(12, bVar);
        this.dWN.setActionListener(13, bVar);
        this.dWN.setActionListener(15, bVar);
        this.dWN.setActionListener(18, bVar);
        this.dWN.setActionListener(20, bVar);
        this.dWN.setActionListener(25, bVar);
        this.dWN.setActionListener(27, bVar);
        this.dWN.setActionListener(29, bVar);
        this.dWN.setActionListener(43, bVar);
        this.dWN.setActionListener(56, bVar);
        this.dWN.setActionListener(48, bVar);
        this.dWN.setActionListener(46, bVar);
        this.dWN.setActionListener(49, bVar);
        this.dWN.setActionListener(47, bVar);
        this.dWN.setActionListener(55, bVar);
        this.dWN.setActionListener(58, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fc(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXu() {
        if (this.dYs.bAU()) {
            if (this.dYs.cXc()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.cWX().getLocationData().cWV());
                return;
            }
            a(1, true, (String) null);
            this.dYs.cXa();
            return;
        }
        a(0, true, (String) null);
    }

    protected void cSL() {
        if (this.dYt != null) {
            this.dYt.cancelLoadData();
        }
        if (this.lEc != null) {
            this.lEc.cancelLoadData();
        }
        if (this.dYs != null) {
            this.dYs.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dgS();
        TiebaPrepareImageService.StopService();
        cSL();
        dhA();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.lEV != null) {
            this.lEV.destroy();
        }
        if (this.lFu != null) {
            this.lFu.EE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgU() {
        if (this.kHI != null && this.kHI.getType() == 2 && this.lER) {
            finish();
        } else if (this.kHI == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.kHI.setTitle(dhi().getText().toString());
            this.kHI.setContent(dhh().getText().toString());
            int type = this.kHI.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    w.c(this.kHI.getForumId(), this.kHI);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    w.c("24591571", this.kHI);
                }
            } else if (type == 1) {
                w.d(this.kHI.getThreadId(), this.kHI);
            } else if (type == 4) {
                w.c(this.kHI.getForumId() + "photolive", this.kHI);
            } else if (type == 5) {
                w.d(this.kHI.getThreadId() + "updatephotolive", this.kHI);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.kIh != null && this.kIh.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.kIh, getPageContext().getPageActivity());
                return true;
            } else if (this.dWN.aWR()) {
                this.dWN.aVs();
                return true;
            } else {
                cSL();
                dgU();
                return true;
            }
        }
        if (i == 67 && (text = dhh().getText()) != null) {
            int selectionStart = dhh().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dhh().onKeyDown(67, this.gKz);
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
        getLayoutMode().onModeChanged(this.idy);
        getLayoutMode().onModeChanged(this.lFl);
        am.setBackgroundColor(this.idy, R.color.cp_bg_line_e);
        if (this.lFj != null && (i == 1 || i == 4)) {
            this.lFj.setBorderColor(am.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.kIf, R.color.cp_link_tip_a, 1);
        dgQ();
        am.setBackgroundColor(this.kIb, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.lFa, R.color.cp_bg_line_c);
        am.setBackgroundColor(dhi(), R.color.cp_bg_line_e);
        am.setImageResource(this.jvs, R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.iTb)) {
            am.setBackgroundColor(dhh(), R.color.cp_bg_line_e);
        }
        cSU();
        this.dWN.onChangeSkinType(i);
        if (this.lEq != null) {
            this.lEq.aQp();
        }
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.lEV.lFR.notifyDataSetChanged();
        dgV();
        dgW();
        vd(false);
        if (this.lEx != null) {
            this.lEx.c(dhi(), dhh());
        }
        if (this.lCA != null) {
            this.lCA.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgV() {
        if (this.kIa.hasFocus()) {
            this.kIa.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.kIa.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.kIe.hasFocus()) {
            this.kIe.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.kIe.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgW() {
        if (this.kIa != null && this.kIa.getText() != null && this.kIa.getText().toString() != null && this.kIa.getPaint() != null) {
            if (this.kIa.getText().toString().length() == 0) {
                this.kIa.getPaint().setFakeBoldText(false);
            } else if (this.kIa.getText().toString().length() > 0) {
                this.kIa.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.egd = new com.baidu.tbadk.core.view.a(getPageContext());
        this.lEs = this.kHI.getType() == 4 || 5 == this.kHI.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aOU().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.lEP = (TextView) findViewById(R.id.btn_image_problem);
        dgZ();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kIf.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.kIf.setLayoutParams(layoutParams);
        this.kIf.setOnFocusChangeListener(this.fAV);
        this.lEr = (ScrollView) findViewById(R.id.write_scrollview);
        this.lEr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.kIe != null) {
                        l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.kIe);
                    }
                    if (WriteActivity.this.dWN != null) {
                        WriteActivity.this.dWN.aVs();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.lEN = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.lEO = findViewById(R.id.feedback_divider);
        this.idy = (RelativeLayout) findViewById(R.id.parent);
        this.lEa = (LinearLayout) findViewById(R.id.tool_view);
        this.lEa.setContentDescription(IStringUtil.TOP_PATH);
        this.lEb = (LinearLayout) findViewById(R.id.title_view);
        this.kIb = findViewById(R.id.interval_view);
        this.lFq = findViewById(R.id.hot_topic_fourm_view);
        this.lFr = findViewById(R.id.hot_topic_divider);
        this.lEu = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.lFs = (TextView) findViewById(R.id.change_one_tv);
        cST();
        if (this.lEs) {
            this.lEr.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            dht();
        } else {
            this.lEV = new g(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.lEV.uT(false);
            } else {
                g gVar = this.lEV;
                if (this.kHI.getType() != 0 && this.kHI.getType() != 9) {
                    z = false;
                }
                gVar.uT(z);
            }
        }
        cSV();
        if (this.lEK || this.lDZ) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().dAr) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.kId = (LinearLayout) findViewById(R.id.post_content_container);
        this.kId.setDrawingCacheEnabled(false);
        this.kId.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.dWN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.kIe.requestFocus();
            }
        });
        this.jvp = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.jvq = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.jvs = (ImageView) findViewById(R.id.iv_delete_voice);
        this.jvs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cys();
            }
        });
        this.mBack.setOnFocusChangeListener(this.fAV);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cSL();
                WriteActivity.this.dgU();
            }
        });
        this.lEP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        dhc();
        o(dhB());
        dhe();
        dgY();
        dhy();
        dhz();
        dgQ();
        dhd();
        cSS();
        dhk();
        if (this.kHI.getType() == 4 && this.kIj != null && this.lEd != null) {
            this.kIj.setVisibility(8);
            this.lEd.setVisibility(8);
        }
        cSU();
        dhw();
        dgh();
        dgX();
    }

    private void dgX() {
        this.lCA = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.lCA.setData(this.lxY);
        this.lCA.setActivity(this);
    }

    private void dgh() {
        if (this.mName != null && this.kHI != null && this.kHI.getProZone() == 1) {
            this.mName.setText(R.string.write_zone_profession_title);
        }
    }

    private void dgY() {
        String str;
        String str2;
        if (this.kHI != null) {
            switch (this.kHI.getType()) {
                case 0:
                case 9:
                    if (this.lEK || this.lDZ) {
                        if (this.lEL) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.hzq != null && this.hzq.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                        if (this.lCf) {
                            this.mName.setText(R.string.publish_to_dynamic_title);
                        }
                    } else if (this.hzq != null && this.hzq.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.kHI.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.kHI.getForumName() + getResources().getString(R.string.bar));
                        this.kIa.setVisibility(8);
                        String str3 = this.gWw + " " + this.gWu;
                        if (!StringUtils.isNull(str3)) {
                            this.kIe.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.kIa.setVisibility(0);
                    this.kIe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.kIe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.kIa.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.kIe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.kHI.getFloorNum() + 1)));
                    this.lFa.setVisibility(8);
                    return;
                case 7:
                    this.kIa.setVisibility(0);
                    this.kIe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void dgZ() {
        if (this.kHI.getType() == 7) {
            this.kIf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.kIf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void dha() {
        if (this.kHI != null && this.kHI.getType() == 0 && this.kHI.getType() == 9 && !this.lEK && !this.lDZ && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = aq.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dhi() != null) {
                dhi().setText(cutStringWithSuffix);
                dhi().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.jvp.setVisibility(0);
            this.jvq.setVoiceModel(voiceModel);
            this.jvq.cXz();
            cSU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cys() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.vp(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.jvp.setVisibility(8);
        this.jvq.bZf();
        this.jvq.setVoiceModel(null);
        com.baidu.tbadk.editortools.l mD = this.dWN.mD(6);
        if (mD != null && mD.dWH != null) {
            mD.dWH.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        cSU();
    }

    private void dhb() {
        this.lEl = null;
        this.lEn = -1;
        this.lEp = -1;
        ac ty = com.baidu.tieba.frs.ab.bQq().ty(1);
        if (ty != null) {
            this.lEl = ty.hcd;
            this.lEn = getIntent().getIntExtra("category_id", -1);
            if (this.lEl != null && !this.lEl.isEmpty() && this.lEn >= 0) {
                this.lEm = new aa();
                this.lEm.hbZ = 0;
                this.lEm.name = getPageContext().getResources().getString(R.string.category_auto);
                this.lEp = this.lEm.hbZ;
                this.lEo = this.lEm.name;
                for (aa aaVar : this.lEl) {
                    if (aaVar.hbZ == this.lEn) {
                        this.lEp = aaVar.hbZ;
                        this.lEo = aaVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dhc() {
        if (this.lEl != null && !this.lEl.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.lEq = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.lEq.setText(this.lEo);
            this.lEq.setCategoryContainerData(this.lEl, this.lEm, this.lEp);
            this.lEq.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ax axVar) {
                    if (axVar != null) {
                        WriteActivity.this.lEq.setText(axVar.name);
                        WriteActivity.this.kHI.setCategoryTo(axVar.hbZ);
                        WriteActivity.this.lEp = axVar.hbZ;
                        WriteActivity.this.lEq.dgD();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.lEq.dgC();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dhi());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dhh());
                }
            });
        }
    }

    private void dhw() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.lEF = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.lEF.setTitle(R.string.no_disturb_start_time);
        this.lEF.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.lEF);
        this.lEF.setButton(-2, getPageContext().getString(R.string.cancel), this.lEF);
        return this.lEF;
    }

    private void dhd() {
        this.lEh = (RelativeLayout) findViewById(R.id.addition_container);
        this.lEi = (TextView) findViewById(R.id.addition_create_time);
        this.lEj = (TextView) findViewById(R.id.addition_last_time);
        this.lEk = (TextView) findViewById(R.id.addition_last_content);
        if (this.lEg != null) {
            this.lEh.setVisibility(0);
            this.lEi.setText(getPageContext().getString(R.string.write_addition_create) + aq.getFormatTime(this.lEg.getCreateTime() * 1000));
            if (this.lEg.getAlreadyCount() == 0) {
                this.lEj.setVisibility(8);
            } else {
                this.lEj.setText(getPageContext().getString(R.string.write_addition_last) + aq.getFormatTime(this.lEg.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.lEg.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.lEk.setText(lastAdditionContent);
            } else {
                this.lEk.setVisibility(8);
            }
            dhh().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.lEg.getAlreadyCount()), Integer.valueOf(this.lEg.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.lEh.setVisibility(8);
    }

    private void cSS() {
        this.kIj = findViewById(R.id.post_prefix_layout);
        if (this.lFu == null) {
            this.lFu = new com.baidu.tieba.c.d(getPageContext(), this.kIj);
            this.lFu.cz(R.drawable.bg_tip_blue_up_left);
            this.lFu.cy(16);
            this.lFu.lE(true);
            this.lFu.setUseDirectOffset(true);
            this.lFu.rS(l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.kIg = (TextView) findViewById(R.id.post_prefix);
        this.lEd = findViewById(R.id.prefix_divider);
        this.kIi = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.kIj.setVisibility(0);
            this.lFu.d(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.kHJ = 0;
            this.kIj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").cI("fid", WriteActivity.this.kHI.getForumId()).t("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.kIg.setVisibility(0);
                    WriteActivity.this.kIj.setSelected(true);
                    am.setImageResource(WriteActivity.this.kIi, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.kIh, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.dWN.aVs();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.kIa);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.kIe);
                }
            });
            this.kIg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").cI("fid", WriteActivity.this.kHI.getForumId()).t("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.kIg.setSelected(true);
                    am.setImageResource(WriteActivity.this.kIi, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.kIh, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.dWN.aVs();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dhi());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dhh());
                }
            });
            this.kIh = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.kIh.a(this);
            this.kIh.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.kIh.setOutsideTouchable(true);
            this.kIh.setFocusable(true);
            this.kIh.setOnDismissListener(this);
            this.kIh.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            am.getColor(R.color.cp_cont_c);
            am.setBackgroundResource(this.kIg, R.color.cp_bg_line_d);
            am.setImageResource(this.kIi, R.drawable.icon_arrow_gray_down);
            this.kIg.setTextColor(color);
            this.lEe.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.lEe.add(writePrefixItemLayout);
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
                this.kIh.addView(writePrefixItemLayout);
            }
            this.kIh.setCurrentIndex(0);
            this.kIg.setText(prefixs.get(0));
            Fa(0);
            return;
        }
        this.kIj.setVisibility(8);
    }

    private void dhx() {
        if (this.lEK && this.kHI != null) {
            this.lEN.setVisibility(0);
            this.lEO.setVisibility(0);
            this.lEc = new FeedBackModel(getPageContext());
            this.lEc.MJ(this.kHI.getForumName());
            this.lEc.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.lEN.setVisibility(8);
                        WriteActivity.this.lEO.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.lEN.setVisibility(8);
                        WriteActivity.this.lEO.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.lEN.a(feedBackModel.dgF(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void dhe() {
        this.kIf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (WriteActivity.this.lEx.a(WriteActivity.this.kIa, WriteActivity.this.kIe)) {
                        WriteActivity.this.showToast(WriteActivity.this.lEx.deW());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dhi());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dhh());
                    WriteActivity.this.dWN.aVs();
                    if (WriteActivity.this.kHI.getType() != 7) {
                        if (WriteActivity.this.lEK) {
                            WriteActivity.this.dhn();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            an anVar = new an("c12102");
                            anVar.af("obj_type", StringUtils.isNull(WriteActivity.this.kHI.getForumName()) ? 1 : 2);
                            TiebaStatic.log(anVar);
                            WriteActivity.this.dho();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.dhn();
                    }
                    TiebaStatic.log(new an("c12262").cI("obj_locate", WriteActivity.this.hzq));
                }
            }
        });
    }

    protected void dhy() {
        this.lEQ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.lEQ.uf(getPageContext().getString(R.string.is_save_draft)).gE(false).a(getPageContext().getString(R.string.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.kHI.setTitle(WriteActivity.this.dhi().getText().toString());
                WriteActivity.this.kHI.setContent(WriteActivity.this.dhh().getText().toString());
                int type = WriteActivity.this.kHI.getType();
                if (type == 0 || type == 9) {
                    w.c(WriteActivity.this.kHI.getForumId(), WriteActivity.this.kHI);
                } else if (type == 1) {
                    w.d(WriteActivity.this.kHI.getThreadId(), WriteActivity.this.kHI);
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
                int type = WriteActivity.this.kHI.getType();
                if (type == 0 || type == 9) {
                    w.c(WriteActivity.this.kHI.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    w.d(WriteActivity.this.kHI.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.lEQ.b(getPageContext());
    }

    protected void cST() {
        this.lEM = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.lEM.setIsRound(true);
        this.lEM.setDrawBorder(false);
        this.lEM.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String uA = o.uA(currentPortrait);
            this.lEM.setUrl(uA);
            this.lEM.startLoad(uA, 12, false);
        }
        if (this.kHI.isUserFeedback()) {
            this.lEM.setVisibility(0);
        }
        this.kIa = (EditText) findViewById(R.id.post_title);
        this.kIa.setOnClickListener(this.lEB);
        this.kIa.setOnFocusChangeListener(this.fAV);
        if (this.kHI.getType() == 0 || this.kHI.getType() == 9 || this.kHI.getType() == 7) {
            if (this.kHI.getTitle() != null) {
                this.kIa.setText(this.kHI.getTitle());
                this.kIa.setSelection(this.kHI.getTitle().length());
            } else if (this.lEL) {
                this.kIa.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.kHI.getType() == 1 || this.kHI.getType() != 2) {
        }
        this.kIa.addTextChangedListener(this.lED);
        if (!this.kHI.getHaveDraft()) {
            dha();
            this.lFp = true;
        }
        if (this.kHI.isUserFeedback()) {
            this.kIa.setHint(getResources().getString(R.string.feedback_title_hint));
        } else {
            this.kIa.setHint(getResources().getString(R.string.post_title_hint));
        }
    }

    private TextWatcher abE() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int lFy;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.cSU();
                if (WriteActivity.this.lEs) {
                    this.lFy = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.lFy);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.lEs || !WriteActivity.this.lFh) {
                    if (WriteActivity.this.lEs) {
                        if (this.mEditText != WriteActivity.this.lEY || this.mTextView != WriteActivity.this.lFe) {
                            this.mEditText = WriteActivity.this.lEY;
                            this.mTextView = WriteActivity.this.lFe;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.lFc || this.mTextView != WriteActivity.this.lFd) {
                    this.mEditText = WriteActivity.this.lFc;
                    this.mTextView = WriteActivity.this.lFd;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.lEs && this.lFh) {
            if (this.lFf != null) {
                this.lFc.removeTextChangedListener(this.lFf);
            }
            this.lFf = textWatcher;
        } else if (this.lEs) {
            if (this.lFg != null) {
                this.lEY.removeTextChangedListener(this.lFg);
            }
            this.lFg = textWatcher;
        }
        return textWatcher;
    }

    private long i(EditText editText) {
        if (editText == this.lEY) {
            return 233L;
        }
        if (editText != this.lFc) {
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

    protected void cSV() {
        this.kIe = (EditText) findViewById(R.id.post_content);
        this.kIe.setDrawingCacheEnabled(false);
        this.kIe.setOnClickListener(this.lEB);
        if (this.kHI.getContent() != null && this.kHI.getContent().length() > 0) {
            SpannableString av = TbFaceManager.aYl().av(getPageContext().getPageActivity(), this.kHI.getContent());
            this.kIe.setText(av);
            this.kIe.setSelection(av.length());
        } else if (this.kHI.getType() == 2) {
            if (this.lER) {
                if (this.lES != null && this.lES.length() > 0) {
                    this.kIe.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.lES}));
                    this.kIe.setSelection(this.kIe.getText().length());
                }
            } else if (this.kHI.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.kHI.getFloorNum()));
                this.kIe.setText(format);
                this.kIe.setSelection(format.length());
            }
        }
        this.kIe.setOnFocusChangeListener(this.fAV);
        this.kIe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.dWN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.kIe.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.kIe.addTextChangedListener(this.lEE);
        if (this.kHI.getType() == 0) {
            this.lFt = true;
        } else {
            vd(true);
            this.lFt = false;
        }
        if (this.kHI.isUserFeedback()) {
            this.kIe.setHint(R.string.write_input_content);
        } else {
            this.kIe.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void vd(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.lEs && !this.lCf) {
            dhh().setPadding(0, 0, 0, 0);
            dhh().setBackgroundDrawable(null);
            am.setBackgroundColor(dhh(), R.color.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.iTb) && this.lEg == null) {
                com.baidu.adp.lib.e.c.kV().a(this.iTb, 19, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
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
                            WriteActivity.this.dhh().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.dhh(), true, WriteActivity.this.jBr);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dhg() {
        int i = 5000;
        if (this.lEg != null) {
            i = 1000;
        }
        return dhh().getText() != null && dhh().getText().length() >= i;
    }

    private void wv(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.lDW)) {
                this.lDW = "";
                dhh().requestFocus();
                if (dhh().getText() != null && dhh().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dhh().getSelectionStart();
                    editable = dhh().getText();
                }
            } else if ("from_title".equals(this.lDW)) {
                this.lDW = "";
                dhi().requestFocus();
                if (dhi().getText() != null && dhi().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dhi().getSelectionStart();
                    editable = dhi().getText();
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
            if (this.kHI != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.kHI.getForumId(), 0L), this.kHI.getFirstDir(), this.kHI.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(q qVar) {
        if (((ImageSpan[]) dhh().getText().getSpans(0, dhh().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.lEf == null) {
                this.lEf = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            this.lEf.show();
            return;
        }
        String name = qVar.getName();
        final EmotionGroupType aRY = qVar.aRY();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.e.c.kV().a(name, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.dhh().getSelectionStart(), aVar, aRY);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && dhh() != null && dhh().getText() != null) {
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
                int selectionStart = dhh().getSelectionStart() - 1;
                if (dhh().getText().length() > 1 && selectionStart >= 0 && dhh().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    dhh().getText().insert(dhh().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            dhh().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                dhh().getText().insert(dhh().getSelectionStart(), spannableString2);
            }
            Editable text = dhh().getText();
            if (text != null) {
                this.lEv.clear();
                this.lEv.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.lEv);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && dhh().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    dhh().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                dhh().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dhh() {
        return this.lEs ? this.lEY : this.kIe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dhi() {
        return this.lEs ? this.lFc : this.kIa;
    }

    protected void dhj() {
        Editable text;
        if (dhh() != null && (text = dhh().getText()) != null) {
            int selectionStart = dhh().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dhh().onKeyDown(67, this.gKz);
            }
            dhh().onKeyDown(67, this.gKz);
            int selectionStart2 = dhh().getSelectionStart();
            if (text != null) {
                this.lEv.clear();
                this.lEv.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.lEv);
                dhh().setSelection(selectionStart2);
            }
        }
    }

    private void o(Boolean bool) {
        String str = null;
        if (this.kHI != null) {
            str = this.kHI.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.lEK = true;
        }
    }

    private void dhz() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void dhA() {
        try {
            if (this.lEQ != null) {
                this.lEQ.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.egd.setCancelListener(null);
        this.egd.setTipString(R.string.sending);
        this.egd.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.egd.setDialogVisiable(false);
    }

    private Boolean dhB() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.dYx = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void cSU() {
        if (this.kHI != null) {
            String str = "";
            String str2 = "";
            if (dhi() != null) {
                str = dhi().getText().toString();
            }
            if (dhh() != null) {
                str2 = dhh().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.kHI.getType() == 0 || this.kHI.getType() == 9 || this.kHI.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.kHJ == v.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.kHI.setIsNoTitle(true);
                        } else if (this.lEb.getVisibility() == 0) {
                            this.kHI.setIsNoTitle(false);
                            vc(true);
                            return;
                        }
                    } else if (this.lEb.getVisibility() == 0) {
                        this.kHI.setIsNoTitle(false);
                        vc(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.kHI.setIsNoTitle(true);
                } else if (this.lEb.getVisibility() == 0) {
                    this.kHI.setIsNoTitle(false);
                    vc(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.lEs) {
                    vc(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    vc(true);
                }
            }
            if (this.kHI.getType() == 4) {
                vc(l(this.lEY) && k(this.lFc));
            } else if (this.kHI.getType() == 5) {
                vc(l(this.lEY));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                vc(true);
            } else if (this.kHI.getVideoInfo() != null) {
                vc(true);
            } else {
                vc(false);
            }
        }
    }

    public void vc(boolean z) {
        if (z) {
            am.setNavbarTitleColor(this.kIf, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
            this.kIf.setEnabled(true);
            return;
        }
        am.setViewTextColor(this.kIf, R.color.cp_cont_d, 1);
        this.kIf.setEnabled(false);
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
        this.dYt = new NewWriteModel(this);
        this.dYt.b(this.dYH);
        registerListener(this.lFv);
        this.gPp = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.cSL();
            }
        };
        this.kHI = new WriteData();
        if (bundle != null) {
            this.kHI.setType(bundle.getInt("type", 0));
            this.kHI.setForumId(bundle.getString("forum_id"));
            this.kHI.setForumName(bundle.getString("forum_name"));
            this.kHI.setFirstDir(bundle.getString("forum_first_dir"));
            this.kHI.setSecondDir(bundle.getString("forum_second_dir"));
            this.kHI.setThreadId(bundle.getString("thread_id"));
            this.kHI.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.kHI.setFloorNum(bundle.getInt("floor_num", 0));
            this.lEK = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.lEL = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.lER = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.lES = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.dYr = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.lEg = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.kHI.setIsAddition(this.lEg != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.lET = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.kHI.setTitle(bundle.getString("write_title"));
            this.kHI.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.kHI.setTopicId(this.mTopicId);
            this.hzq = bundle.getString("KEY_CALL_FROM");
            this.aVT = bundle.getInt("album_thread");
            this.lxY = (FrsTabInfoData) bundle.getSerializable("tab_list");
            str = string;
        } else {
            Intent intent = getIntent();
            this.kHI.setType(intent.getIntExtra("type", 0));
            this.kHI.setForumId(intent.getStringExtra("forum_id"));
            this.kHI.setForumName(intent.getStringExtra("forum_name"));
            this.kHI.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.kHI.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.kHI.setThreadId(intent.getStringExtra("thread_id"));
            this.kHI.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.kHI.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.lEK = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.lEL = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.lER = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.lES = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.lEg = (AdditionData) intent.getSerializableExtra("addition_data");
            this.kHI.setIsAddition(this.lEg != null);
            this.kHI.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.lET = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.gWv = intent.getStringExtra("more_forum_img");
            this.gWw = intent.getStringExtra("more_forum_title");
            this.gWu = intent.getStringExtra("more_forum_url");
            this.kHI.setTitle(intent.getStringExtra("write_title"));
            this.kHI.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.kHI.setTopicId(this.mTopicId);
            this.hzq = intent.getStringExtra("KEY_CALL_FROM");
            this.aVT = intent.getIntExtra("album_thread", 0);
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.lxY = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            str = stringExtra;
        }
        if (this.kHI.getType() == 9) {
            this.kHI.setEntranceType(1);
        } else if (this.kHI.getType() == 10) {
            this.kHI.setEntranceType(2);
            this.kHI.setType(9);
        } else if (this.kHI.getType() == 0) {
            this.kHI.setEntranceType(3);
        }
        this.kHI.setIsUserFeedback(this.lEK);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.kHI.getType() == 4 ? 6 : 9);
        this.kHI.setWriteImagesInfo(this.writeImagesInfo);
        if (this.kHI.getType() == 0 || this.kHI.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                w.c(this.kHI.getForumId(), this);
            }
        } else if (this.kHI.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                w.c("24591571", this);
            }
        } else if (this.kHI.getType() == 1) {
            w.a(this.kHI.getThreadId(), this);
        } else if (this.kHI.getType() == 4) {
            w.c(this.kHI.getForumId() + "photolive", this);
        } else if (this.kHI.getType() == 5) {
            w.a(this.kHI.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.iTb = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.kHI != null && this.kHI.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.kHI.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.lDZ = true;
        }
        dhb();
        try {
            this.lFi = dhK();
        } catch (Throwable th) {
            this.lFi = null;
        }
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.kHI.mDynamicImageTextData = new ImageTextUploadData();
            this.lCf = true;
        }
    }

    private void dhk() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.kIa.setText(com.baidu.tbadk.plugins.b.wZ(com.baidu.tbadk.plugins.b.xa(hotTopicBussinessData.mTopicName)));
            this.kIa.setMovementMethod(com.baidu.tieba.view.c.deD());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) v.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString wZ = com.baidu.tbadk.plugins.b.wZ(com.baidu.tbadk.plugins.b.xa(hotTopicBussinessData.mTopicName));
            if (wZ != null) {
                this.kIa.setText(wZ);
            }
            this.lEu.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.w.a
    public void a(WriteData writeData) {
        String str;
        String xa;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            if (writeData != null) {
                if (this.kHI != null) {
                    this.kHI.setHaveDraft(true);
                    if (com.baidu.adp.lib.util.k.isEmpty(dhi().getText().toString()) || this.lFp || ((this.lEK || this.lDZ) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                        if (com.baidu.adp.lib.util.k.isEmpty(this.kHI.getTitle())) {
                            this.kHI.setTitle(writeData.getTitle());
                        }
                        if (!v.isEmpty(this.mList)) {
                            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.getItem(this.mList, 0);
                            if (hotTopicBussinessData == null) {
                                str = null;
                            } else {
                                str = hotTopicBussinessData.mTopicName;
                            }
                            if (StringUtils.isNull(str)) {
                                xa = this.kHI.getTitle();
                            } else {
                                xa = com.baidu.tbadk.plugins.b.xa(str);
                            }
                            SpannableString wZ = com.baidu.tbadk.plugins.b.wZ(xa);
                            if (wZ != null) {
                                dhi().setText(wZ);
                                dhi().setSelection(wZ.length() > xa.length() ? xa.length() : wZ.length());
                            }
                        } else {
                            SpannableString wZ2 = com.baidu.tbadk.plugins.b.wZ(this.kHI.getTitle());
                            if (wZ2 != null) {
                                dhi().setText(wZ2);
                                dhi().setSelection(this.kHI.getTitle().length() > wZ2.length() ? wZ2.length() : this.kHI.getTitle().length());
                            }
                        }
                    }
                    if (this.kHI != null && !this.kHI.getHaveDraft()) {
                        dha();
                    }
                    if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.copy(writeData.getVideoInfo());
                        this.kHI.setVideoInfo(videoInfo);
                        this.dWN.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                    }
                    if ((com.baidu.adp.lib.util.k.isEmpty(dhh().getText().toString()) || this.lEK || this.lDZ) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                        this.kHI.setContent(writeData.getContent());
                        SpannableString a2 = TbFaceManager.aYl().a(getPageContext().getPageActivity(), this.kHI.getContent(), this.lEz);
                        dhh().setText(a2);
                        dhh().setSelection(a2.length());
                        if (this.lEs) {
                            a(this.lFe, this.lEY);
                        }
                    }
                    if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                        this.writeImagesInfo = writeData.getWriteImagesInfo();
                        this.kHI.setWriteImagesInfo(this.writeImagesInfo);
                        dhI();
                        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                            dhq();
                        }
                        ve(false);
                    }
                    if (writeData.getType() == 4 || writeData.getType() == 5) {
                        dhC();
                    }
                    cSU();
                    int categoryTo = writeData.getCategoryTo();
                    if (categoryTo >= 0 && this.lEl != null) {
                        this.lEp = this.lEm.hbZ;
                        this.lEo = this.lEm.name;
                        int i = 0;
                        while (true) {
                            if (i == this.lEl.size()) {
                                break;
                            }
                            aa aaVar = this.lEl.get(i);
                            if (categoryTo != aaVar.hbZ) {
                                i++;
                            } else {
                                this.lEp = categoryTo;
                                this.lEo = aaVar.name;
                                this.kHI.setCategoryTo(this.lEp);
                                break;
                            }
                        }
                        if (this.lEq != null) {
                            this.lEq.setText(this.lEo);
                            this.lEq.setCategoryContainerData(this.lEl, this.lEm, this.lEp);
                        }
                    }
                    this.dWN.aVs();
                    return;
                }
                return;
            }
            dhC();
            dha();
        }
    }

    private void dhC() {
        if ((!this.lEs || this.lEX != null) && this.lEW != null) {
            this.lEX.b(this.writeImagesInfo);
            dhG();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.kHI.getType());
        bundle.putString("forum_id", this.kHI.getForumId());
        bundle.putString("forum_name", this.kHI.getForumName());
        bundle.putString("forum_first_dir", this.kHI.getFirstDir());
        bundle.putString("forum_second_dir", this.kHI.getSecondDir());
        bundle.putString("thread_id", this.kHI.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.kHI.getFloor());
        bundle.putInt("floor_num", this.kHI.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.lER);
        if (this.lEK) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.dYr);
        if (this.lEg != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.lEg));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.lET);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.hzq);
        bundle.putInt("album_thread", this.aVT);
        bundle.putInt("private_thread", this.privateThread);
        bundle.putSerializable("tab_list", this.lxY);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dhh().getEditableText().toString();
        if (obj != null) {
            dhh().setText(TbFaceManager.aYl().a(getPageContext().getPageActivity(), obj, this.lEz));
            dhh().setSelection(dhh().getText().length());
        }
    }

    private String dhl() {
        return (dhh() == null || dhh().getText() == null) ? "" : dhh().getText().toString();
    }

    private String dhm() {
        if (this.kHI == null || dhi() == null || dhi().getVisibility() != 0 || dhi().getText() == null) {
            return "";
        }
        String obj = dhi().getText().toString();
        if (this.mPrefixData != null && v.getCount(this.mPrefixData.getPrefixs()) > 0 && this.kHJ != v.getCount(this.mPrefixData.getPrefixs()) - 1 && this.kHI.getType() != 4 && this.kIg != null && this.kIg.getText() != null) {
            this.kHI.setPostPrefix(this.kIg.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.kHI.getTitle();
        }
        return obj;
    }

    private void MK(String str) {
        if (this.kHI != null && this.lEb != null) {
            if (this.lEb.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.kHI.setIsNoTitle(true);
                    this.kHI.setTitle("");
                    return;
                }
                this.kHI.setIsNoTitle(false);
                this.kHI.setTitle(str);
                return;
            }
            this.kHI.setIsNoTitle(true);
            this.kHI.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhn() {
        cSL();
        this.kHI.setContent(dhl());
        MK(dhm());
        if (this.lEK || this.lDZ) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.kHI.getTitle()) || !this.kHI.getTitle().startsWith(string)) {
                MK(string + this.kHI.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.kHI.getContent()) || !this.kHI.getContent().startsWith(str)) {
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
                sb.append(this.kHI.getContent());
                this.kHI.setContent(sb.toString());
            }
        }
        if (this.lEn >= 0) {
            this.kHI.setCategoryFrom(this.lEn);
        }
        if (this.lEp >= 0) {
            this.kHI.setCategoryTo(this.lEp);
        }
        this.kHI.setWriteImagesInfo(this.writeImagesInfo);
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
            this.kHI.setTakePhotoNum(i);
        }
        this.kHI.setHasLocationData(this.dYs != null && this.dYs.bAU());
        if (this.writeImagesInfo != null) {
            this.dYt.ua(this.writeImagesInfo.size() > 0);
        }
        if (!v.isEmpty(this.mList) && this.lEt != null && this.lEt.mIsGlobalBlock == 0) {
            this.kHI.setForumId(String.valueOf(this.lEt.mForumId));
            this.kHI.setForumName(this.lEt.mForumName);
        }
        dgk();
        this.dYt.d(this.kHI);
        this.kHI.setContent(this.kHI.getContent().replaceAll("\u0000\n", ""));
        this.kHI.setContent(this.kHI.getContent().replaceAll("\u0000", ""));
        this.kHI.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.dYt.cSN().setVoice(this.mVoiceModel.getId());
                this.dYt.cSN().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.dYt.cSN().setVoice(null);
                this.dYt.cSN().setVoiceDuringTime(-1);
            }
        } else {
            this.dYt.cSN().setVoice(null);
            this.dYt.cSN().setVoiceDuringTime(-1);
        }
        if (!this.dYt.cXE()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.kHI.mDynamicImageTextData != null) {
            dgj();
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.gPp);
            this.dYt.cXB();
        }
    }

    private void dgk() {
        FrsTabItemData selectedTabItemData;
        if (this.kHI != null && this.lCA != null && (selectedTabItemData = this.lCA.getSelectedTabItemData()) != null) {
            this.kHI.setTabId(selectedTabItemData.tabId);
            this.kHI.setTabName(selectedTabItemData.name);
            this.kHI.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    public void dgj() {
        if (this.kHI.mDynamicImageTextData != null) {
            showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
            com.baidu.tieba.write.b.a.a(this.kHI, new a.InterfaceC0674a() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                @Override // com.baidu.tieba.write.b.a.InterfaceC0674a
                public void a(BaseUploadData baseUploadData) {
                    com.baidu.tieba.write.b.c.b.dfV().a((ImageTextUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.write.WriteActivity.33.1
                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onSuccess(String str) {
                            com.baidu.tieba.write.b.a.dfM();
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
                            com.baidu.tieba.write.b.a.dfM();
                            WriteActivity.this.closeLoadingDialog();
                            if (TextUtils.isEmpty(str)) {
                                str = TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error);
                            }
                            l.showToast(TbadkCoreApplication.getInst(), str);
                        }
                    });
                }

                @Override // com.baidu.tieba.write.b.a.InterfaceC0674a
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
            if (this.lEg != null) {
                i2 = this.lEg.getTotalCount();
                i = this.lEg.getAlreadyCount() + 1;
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
                if (this.kIa == getCurrentFocus()) {
                    dhh().clearFocus();
                    this.kIa.requestFocus();
                    if (this.dWN != null) {
                        this.dWN.aVs();
                    }
                    ShowSoftKeyPadDelay(this.kIa);
                } else {
                    dhh().requestFocus();
                    if (this.dWN != null) {
                        this.dWN.aVs();
                    }
                    ShowSoftKeyPadDelay(this.kIe);
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
                            dhh().getText().insert(dhh().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.kHI.getType() == 0 || this.kHI.getType() == 9) {
                    w.c(this.kHI.getForumId(), (WriteData) null);
                    if (postWriteCallBackData2 != null) {
                    }
                } else if (this.kHI.getType() == 1) {
                    w.d(this.kHI.getThreadId(), (WriteData) null);
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
                                dhH();
                            } else {
                                aC(intent);
                            }
                        } else if (intExtra == 1) {
                            aD(intent);
                        } else {
                            aA(intent);
                            com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.lFt) {
                            vd(true);
                            this.lFt = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.lEs) {
                        T(intent);
                        cSU();
                        return;
                    }
                    aB(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.kHI.setVideoInfo(videoInfo);
                        this.dWN.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.dWN.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.dWN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    cSU();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.lDX) {
                                sb2.append(com.baidu.tbadk.plugins.b.efJ);
                                this.lDX = false;
                            }
                            sb2.append(stringExtra);
                            wv(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !v.isEmpty(this.mList) && !v.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                    this.lEt = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                    a(this.lEt);
                }
            }
        } else if (i2 == 0) {
            if (this.dWN != null && !this.dWN.aWR()) {
                this.kIe.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.dWN.aVs();
            }
            switch (i) {
                case 12001:
                    aXx();
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    dhF();
                    if (this.lFt) {
                        vd(true);
                        this.lFt = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.kIa == getCurrentFocus()) {
                        dhh().clearFocus();
                        this.kIa.requestFocus();
                        if (this.dWN != null) {
                            this.dWN.aVs();
                        }
                        ShowSoftKeyPadDelay(this.kIa);
                        return;
                    }
                    dhh().requestFocus();
                    if (this.dWN != null) {
                        this.dWN.aVs();
                    }
                    ShowSoftKeyPadDelay(this.kIe);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.lEx.Mp(postWriteCallBackData.getErrorString());
                        this.lEx.aW(postWriteCallBackData.getSensitiveWords());
                        this.lEx.b(this.kIa, this.kIe);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.dYr = String.valueOf(System.currentTimeMillis());
                    al.a(getPageContext(), this.dYr);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dhF();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.lDW)) {
                        dhi().requestFocus();
                        return;
                    } else if ("from_content".equals(this.lDW)) {
                        dhh().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dho() {
        if ("1".equals(this.hzq)) {
            this.kHI.setCanNoForum(true);
            this.kHI.setTransmitForumData("[]");
        } else if ("2".equals(this.hzq)) {
            this.kHI.setCanNoForum(false);
        }
        dhp();
        this.kHI.setPrivacy(this.isPrivacy);
        dhD();
        this.kHI.setToDynamic(this.isToDynamic);
        this.kHI.setCallFrom(this.hzq);
        if (this.kHI.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        dhn();
    }

    private void dhp() {
        if (this.dWN != null) {
            this.dWN.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void dhD() {
        if (this.dWN != null) {
            this.dWN.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void dhE() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void dhF() {
        if (this.lEs) {
            this.lEX.b(this.writeImagesInfo);
            dhG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhG() {
        this.lEX.notifyDataSetChanged();
        this.lEW.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.lEX.notifyDataSetChanged();
                WriteActivity.this.lEW.invalidateViews();
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
        cSU();
    }

    private void aA(Intent intent) {
        if (this.lEs) {
            aB(intent);
            dhF();
        } else {
            aE(intent);
        }
        cSU();
    }

    private void aB(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            dhF();
            ve(true);
        }
    }

    private void aC(Intent intent) {
        if (this.writeImagesInfo != null) {
            S(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, size)));
            }
        }
    }

    private void dhH() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void aD(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.lEU.parseJson(stringExtra);
            this.lEU.updateQuality();
            if (this.lEU.getChosedFiles() != null && this.lEU.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.lEU.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.lEU.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dhi());
        HidenSoftKeyPad(this.mInputManager, dhh());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void aE(Intent intent) {
        c(intent, true);
    }

    private void S(Intent intent) {
        this.dYr = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.dYr;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.getEquipmentWidth(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.dYr, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            dhI();
            dhq();
        }
        ve(true);
    }

    private void T(Intent intent) {
        c(intent, false);
    }

    private void c(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                dhI();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    dhq();
                }
            }
            ve(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhI() {
        if (this.dWN.mD(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void aXx() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.dYr));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void dhJ() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.gWv)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                com.baidu.tbadk.util.o oVar = new com.baidu.tbadk.util.o(this, this.gWv, new o.a() { // from class: com.baidu.tieba.write.write.WriteActivity.38
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
        String forumId = this.kHI == null ? "" : this.kHI.getForumId();
        if (this.lEV != null) {
            this.lEV.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.gYp == null) {
            this.gYp = VoiceManager.instance();
        }
        return this.gYp;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bOT() {
        this.gYp = getVoiceManager();
        this.gYp.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bq(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.gZw) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).af("obj_locate", at.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.kHI.getType() != 7) {
                if (this.lEg == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                C(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.dYy = i;
        if (this.dWN != null) {
            this.dWN.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void dhq() {
        if (!this.lEs) {
            if (this.dWN != null) {
                this.dWN.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.dWN.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.kHI == null ? "" : this.kHI.getForumId();
            if (this.lEV != null) {
                this.lEV.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hI(boolean z) {
        if (this.dWN != null) {
            this.dWN.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Fa(int i) {
        if (i < this.lEe.size()) {
            for (int i2 = 0; i2 < this.lEe.size(); i2++) {
                this.lEe.get(i2).uR(false);
            }
            this.lEe.get(i).uR(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void CL(int i) {
        if (i == v.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new an("c13014").af("obj_type", 1));
        } else {
            TiebaStatic.log(new an("c13014").af("obj_type", 2));
        }
        this.kHJ = i;
        this.kIh.setCurrentIndex(i);
        Fa(i);
        this.kIg.setText(this.mPrefixData.getPrefixs().get(i));
        cSU();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.kIh, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.kIj.setSelected(false);
        am.setImageResource(this.kIi, R.drawable.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.kIe);
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
        if (this.kHI != null) {
            if (this.kHI.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.kHI.getType() == 5) {
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
            aXr();
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = ab.transformPermissionResult(strArr, iArr);
            if (ab.checkCamera(getApplicationContext())) {
                al.a(getPageContext(), this.dYr);
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
        this.aOp = z;
        if (this.lFn && System.currentTimeMillis() - this.lFo < 800) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.lFn = false;
        }
        if (this.lEw != null && !z) {
            this.lEw.bIN();
        }
        if (this.lEy != null && !z) {
            dgS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ML(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.lFk != null) {
            MM(str);
            this.lFk.dismiss();
        }
    }

    private void fv(Context context) {
        lFm = l.getEquipmentHeight(context);
    }

    private void MM(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.lFn = true;
        dhI();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            dhq();
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

    private File dhK() {
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

    private void dhL() {
        if (this.lFi != null && this.kHI.getType() == 0 && this.kHI.getType() == 9) {
            fv(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.lFi != null) {
                        WriteActivity.this.ML(WriteActivity.this.lFi.getAbsolutePath());
                    }
                }
            });
            this.lFj = (TbImageView) this.mBubbleView.findViewById(R.id.rec_img_view);
            this.lFl = (LinearLayout) this.mBubbleView.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.aNV().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.lFi.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.aNV().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.lFi.getAbsolutePath());
                Bitmap g = g(this.lFi.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (g != null) {
                    this.lFj.setImageBitmap(g);
                    this.lFj.setDrawBorder(true);
                    this.lFj.setBorderWidth(2);
                    this.lFj.setBorderColor(am.getColor(R.color.common_color_10264));
                    this.lFk = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.lFk.setCanceledOnTouchOutside(true);
                    this.lFk.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.lFn) {
                                l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.lFo = System.currentTimeMillis();
                            }
                        }
                    });
                    this.lFk.setContentView(this.mBubbleView);
                    this.lFk.show();
                    Window window = this.lFk.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (lFm / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.aOp && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.lDX = false;
            this.lDW = "";
            if ("from_content".equals(str)) {
                this.lDW = "from_content";
            } else if ("from_title".equals(str)) {
                this.lDW = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.wY(String.valueOf(charSequence.charAt(i)))) {
                vb(false);
            }
        }
    }

    public void cNY() {
        if (this.lEK || !v.isEmpty(this.mList) || !StringUtils.isNull(this.kHI.getTitle())) {
            this.lEb.setVisibility(0);
            this.lEb.requestFocus();
            return;
        }
        this.lEb.setVisibility(8);
    }
}
