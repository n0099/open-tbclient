package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.b.a.a;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicChangeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.m;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.e;
import com.baidu.tieba.write.view.PostCategoryView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes2.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0022a, e.a {
    private com.baidu.tbadk.editortools.i aBU;
    private LocationModel aDy;
    private NewWriteModel aDz;
    private OriginalThreadCardView eFR;
    private int ghM;
    private TextView gih;
    private com.baidu.tieba.write.e gii;
    private ImageView gij;
    private View gik;
    private com.baidu.tieba.write.b hfG;
    private LinearLayout hhT;
    private LinearLayout hhU;
    private View hhW;
    private Toast hhX;
    private AdditionData hhY;
    private RelativeLayout hhZ;
    private com.baidu.tieba.view.c hiB;
    private TextView hia;
    private TextView hib;
    private TextView hic;
    List<y> hie;
    y hif;
    private int hig;
    private String hih;
    private int hii;
    private PostCategoryView hij;
    private HotTopicBussinessData him;
    private View hin;
    private View hio;
    private TextView hip;
    private TextView hiq;
    private com.baidu.tieba.write.editor.c hiu;
    private com.baidu.tieba.write.b hiv;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private String hhQ = "";
    private boolean hhR = false;
    private WriteData mData = null;
    private boolean hhS = false;
    private InputMethodManager mInputManager = null;
    private EditText gie = null;
    private View gif = null;
    private LinearLayout bHo = null;
    private EditText bHn = null;
    private FeedBackModel hhV = null;
    private ArrayList<com.baidu.tieba.write.d> hgO = new ArrayList<>();
    private final KeyEvent cvd = new KeyEvent(0, 67);
    private View aqy = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String aDD = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aDE = 0;
    private View mRootView = null;
    private ScrollView hik = null;
    private boolean hil = false;
    private com.baidu.tbadk.core.view.a aMx = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String hef = "2";
    private String hir = "";
    private int his = 0;
    private SpannableStringBuilder hit = new SpannableStringBuilder();
    private TbFaceManager.a hiw = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan gm(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.a.a.class);
            com.baidu.adp.widget.a.a aVar = runTask != null ? (com.baidu.adp.widget.a.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.kK());
            int width = aVar.getWidth();
            if (str.startsWith("#(meme,")) {
                bitmapDrawable.setBounds(0, 0, width, aVar.getHeight());
            } else {
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            return new ImageSpan(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a cHQ = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahP));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahP));
        }
    };
    private final NewWriteModel.d aDN = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, r rVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.hfG.aB(null);
                TransmitPostEditActivity.this.hfG.nS(false);
                TransmitPostEditActivity.this.hiv.aB(null);
                TransmitPostEditActivity.this.hiv.nS(false);
                if (z) {
                    TransmitPostEditActivity.this.bF(z);
                    TransmitPostEditActivity.this.c(true, postWriteCallBackData);
                    if (TransmitPostEditActivity.this.mData.getType() == 4) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, "from_write", 18003)));
                    }
                    TransmitPostEditActivity.this.j(postWriteCallBackData);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    TransmitPostEditActivity.this.setResult(-1, intent);
                    TransmitPostEditActivity.this.finish();
                } else if (postWriteCallBackData.isSensitiveError()) {
                    TransmitPostEditActivity.this.showToast(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.hfG.aB(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.hiv.aB(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.hfG.uw(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.hiv.uw(postWriteCallBackData.getErrorString());
                    if (!v.w(TransmitPostEditActivity.this.hfG.bES())) {
                        TransmitPostEditActivity.this.oa(true);
                        TransmitPostEditActivity.this.og(true);
                    }
                } else if ((rVar == null || writeData == null || rVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (rVar != null && writeData != null && rVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(rVar.getVcode_md5());
                    writeData.setVcodeUrl(rVar.getVcode_pic_url());
                    writeData.setVcodeExtra(rVar.yj());
                    if (com.baidu.tbadk.p.a.he(rVar.yi())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, rVar.yi())));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, 12006)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a aDL = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void DS() {
            TransmitPostEditActivity.this.showToast(d.j.no_network_guide);
            TransmitPostEditActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void gb(String str) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            if (StringUtils.isNull(str)) {
                str = TransmitPostEditActivity.this.getPageContext().getString(d.j.location_fail);
            }
            transmitPostEditActivity.showToast(str);
            TransmitPostEditActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bwS())) {
                TransmitPostEditActivity.this.a(2, true, aVar.bwS());
            } else {
                gb(null);
            }
        }
    };
    private final CustomMessageListener gBs = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.aDy.ne(false);
                    TransmitPostEditActivity.this.aDy.ch(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.aDy.ne(true);
                TransmitPostEditActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener hix = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hiy = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.aBU.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bHt = TransmitPostEditActivity.this.bHt();
            if (bHt >= 0 && bHt < TransmitPostEditActivity.this.bHn.getText().length()) {
                TransmitPostEditActivity.this.bHn.setSelection(bHt);
            }
        }
    };
    private boolean hiz = true;
    private final View.OnFocusChangeListener bHu = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.gie || view == TransmitPostEditActivity.this.aqy || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.hiz = true;
                    TransmitPostEditActivity.this.bHu();
                    if (TransmitPostEditActivity.this.aBU != null) {
                        TransmitPostEditActivity.this.aBU.Bm();
                    }
                    l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gie);
                } else if (view == TransmitPostEditActivity.this.gie) {
                    TransmitPostEditActivity.this.gih.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.bHn && z) {
                TransmitPostEditActivity.this.hiz = false;
                TransmitPostEditActivity.this.bHu();
                TransmitPostEditActivity.this.aBU.Bm();
                l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.bHn);
            }
            TransmitPostEditActivity.this.bHx();
        }
    };
    private TextWatcher bHw = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bpM();
            if (TransmitPostEditActivity.this.hiv != null) {
                if (!TransmitPostEditActivity.this.hiv.bEV()) {
                    TransmitPostEditActivity.this.og(false);
                }
                TransmitPostEditActivity.this.hiv.nT(false);
                TransmitPostEditActivity.this.bHy();
            }
        }
    };
    private TextWatcher hiA = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bpM();
            if (TransmitPostEditActivity.this.hfG != null) {
                if (!TransmitPostEditActivity.this.hfG.bEV()) {
                    TransmitPostEditActivity.this.oa(false);
                }
                TransmitPostEditActivity.this.hfG.nT(false);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void og(boolean z) {
        if (bHJ() != null && bHJ().getVisibility() == 0 && bHJ().getText() != null) {
            int selectionEnd = bHJ().getSelectionEnd();
            SpannableStringBuilder b = this.hiv.b(bHJ().getText());
            if (b != null) {
                this.hiv.nT(true);
                bHJ().setText(b);
                if (z && this.hiv.bET() >= 0) {
                    bHJ().requestFocus();
                    bHJ().setSelection(this.hiv.bET());
                } else {
                    bHJ().setSelection(selectionEnd);
                }
                this.hiv.nS(this.hiv.bET() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oa(boolean z) {
        if (bHI() != null && bHI().getText() != null) {
            int selectionEnd = bHI().getSelectionEnd();
            SpannableStringBuilder b = this.hfG.b(bHI().getText());
            if (b != null) {
                this.hfG.nT(true);
                bHI().setText(b);
                if (z && this.hfG.bET() >= 0) {
                    bHI().requestFocus();
                    bHI().setSelection(this.hfG.bET());
                } else {
                    bHI().setSelection(selectionEnd);
                }
                this.hfG.nS(this.hfG.bET() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DD() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void DE() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.j.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            DF();
        } else if (this.aDy.bxa()) {
            DD();
        } else {
            this.aDy.ne(false);
            a(1, true, (String) null);
            this.aDy.bwY();
        }
    }

    private void DF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cd(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.hh()) {
                    TransmitPostEditActivity.this.a(1, true, (String) null);
                    TransmitPostEditActivity.this.aDy.YM();
                } else {
                    TransmitPostEditActivity.this.aDL.DS();
                }
                aVar2.dismiss();
            }
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TransmitPostEditActivity.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.tk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bHt() {
        int selectionEnd = bHI().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bHI().getText().getSpans(0, bHI().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bHI().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bHI().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHu() {
        if (this.aBU != null) {
            this.aBU.setBarLauncherEnabled(!this.hiz);
            this.aBU.d(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hil) {
            this.gie.setVisibility(8);
            bpM();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getWindow().setSoftInputMode(18);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        this.hiv = new com.baidu.tieba.write.b();
        this.hiv.vA(d.C0082d.cp_cont_i);
        this.hiv.vB(d.C0082d.cp_cont_h_alpha85);
        this.hfG = new com.baidu.tieba.write.b();
        this.hfG.vA(d.C0082d.cp_cont_i);
        this.hfG.vB(d.C0082d.cp_cont_h_alpha85);
        initUI();
        this.aDy = new LocationModel(this);
        this.aDy.a(this.aDL);
        registerListener(this.gBs);
        registerListener(this.hix);
        initEditor();
        this.bHn.requestFocus();
        Bo();
        bHP();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aBU = new com.baidu.tbadk.editortools.i(getActivity());
        this.aBU.setBarMaxLauCount(4);
        this.aBU.setMoreButtonAtEnd(true);
        this.aBU.setBarLauncherType(1);
        this.aBU.bx(true);
        this.aBU.by(true);
        this.aBU.setMoreLauncherIcon(d.f.write_more);
        this.aBU.setBackgroundColorId(d.C0082d.cp_bg_line_d);
        bHv();
        this.aBU.De();
        if (this.hhT != null) {
            this.hhT.addView(this.aBU);
        }
        bHw();
        this.aBU.lE();
        com.baidu.tbadk.editortools.l eN = this.aBU.eN(6);
        if (eN != null && !TextUtils.isEmpty(this.aDD)) {
            ((View) eN).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.aDD);
                }
            });
        }
        if (!this.hil) {
            this.aBU.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aBU.Bm();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aBU.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aBU.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void bHv() {
        com.baidu.tbadk.editortools.r rVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 2);
        aVar.aCB = d.f.write_at;
        this.aBU.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.aBU.b(aVar2);
        aVar2.aCB = d.f.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask != null && (rVar = (com.baidu.tbadk.editortools.r) runTask.getData()) != null) {
            rVar.aCD = 4;
            rVar.aCB = d.f.icon_post_location_selector;
            this.aBU.b(rVar);
        }
        if (this.hhY == null) {
            if (this.hiu == null) {
                this.hiu = new com.baidu.tieba.write.editor.c(getActivity(), this.hef);
                this.hiu.bFW();
                this.hiu.setFrom("from_share_write");
            }
            this.aBU.b(this.hiu);
        }
        this.aBU.B(arrayList);
        com.baidu.tbadk.editortools.r eP = this.aBU.eP(5);
        if (eP != null) {
            eP.aCD = 1;
            eP.aCB = d.f.write_emotion;
        }
    }

    private void bHw() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.4
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                int i;
                if (aVar != null) {
                    if (aVar.code == 31 && (aVar.data instanceof Integer)) {
                        int intValue = ((Integer) aVar.data).intValue();
                        if (intValue == 5) {
                            i = 4;
                        } else if (intValue == 9) {
                            i = 3;
                        } else if (intValue == 26) {
                            i = 1;
                        } else {
                            i = intValue == 7 ? 2 : 0;
                        }
                        if (i > 0) {
                            TiebaStatic.log(new ak("c12608").r("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.bHH()) {
                            TransmitPostEditActivity.this.showToast(d.j.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 12004, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.bHH()) {
                            TransmitPostEditActivity.this.showToast(d.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof m)) {
                            TransmitPostEditActivity.this.d((m) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.bHK();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.bpM();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.hhY == null) {
                            TransmitPostEditActivity.this.DG();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.aDE) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.aK(pageActivity)) {
                                    TransmitPostEditActivity.this.DE();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.DD();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.aDy != null) {
                            TransmitPostEditActivity.this.aDy.ne(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        ak akVar = new ak("c10645");
                        if (TransmitPostEditActivity.this.mData != null) {
                            str = TransmitPostEditActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        akVar.ac(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(akVar);
                        if (TransmitPostEditActivity.this.mData == null || (videoInfo = TransmitPostEditActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.aBU.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.aBU.Dg()) {
                                        TransmitPostEditActivity.this.aBU.Bm();
                                        TransmitPostEditActivity.this.aBU.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(TransmitPostEditActivity.this.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(TransmitPostEditActivity.this.getPageContext(), TransmitPostEditActivity.this.getResources().getString(d.j.plugin_video_not_active), TransmitPostEditActivity.this.getResources().getString(d.j.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(TransmitPostEditActivity.this.getPageContext(), TransmitPostEditActivity.this.getResources().getString(d.j.plugin_video_install_tips), TransmitPostEditActivity.this.getResources().getString(d.j.plugin_go_install));
                            return;
                        }
                        TransmitPostEditActivity.this.aBU.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.aBU.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.aBU.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.aBU.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.bpM();
                        if (TransmitPostEditActivity.this.bHn != null) {
                            TransmitPostEditActivity.this.bHn.requestFocus();
                        }
                        TransmitPostEditActivity.this.aBU.Bm();
                        TransmitPostEditActivity.this.aBU.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHn);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.aBU.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.hhR = true;
                        TransmitPostEditActivity.this.oh(true);
                        if (TransmitPostEditActivity.this.bHJ().isFocused()) {
                            TransmitPostEditActivity.this.hhQ = "from_title";
                        } else if (TransmitPostEditActivity.this.bHI().isFocused()) {
                            TransmitPostEditActivity.this.hhQ = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.hhU.setVisibility(0);
                        TransmitPostEditActivity.this.hhU.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.hhU.hasFocus()) {
                            TransmitPostEditActivity.this.bHn.requestFocus();
                            TransmitPostEditActivity.this.bHn.setSelection(TransmitPostEditActivity.this.bHn.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.hhU.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aBU.a(31, bVar);
        this.aBU.a(16, bVar);
        this.aBU.a(14, bVar);
        this.aBU.a(24, bVar);
        this.aBU.a(3, bVar);
        this.aBU.a(10, bVar);
        this.aBU.a(11, bVar);
        this.aBU.a(12, bVar);
        this.aBU.a(13, bVar);
        this.aBU.a(15, bVar);
        this.aBU.a(18, bVar);
        this.aBU.a(20, bVar);
        this.aBU.a(25, bVar);
        this.aBU.a(27, bVar);
        this.aBU.a(29, bVar);
        this.aBU.a(43, bVar);
        this.aBU.a(45, bVar);
        this.aBU.a(53, bVar);
        this.aBU.a(48, bVar);
        this.aBU.a(46, bVar);
        this.aBU.a(49, bVar);
        this.aBU.a(47, bVar);
        this.aBU.a(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DG() {
        if (this.aDy.YI()) {
            if (this.aDy.bxa()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.bwW().getLocationData().bwS());
                return;
            }
            a(1, true, (String) null);
            this.aDy.bwY();
            return;
        }
        a(0, true, (String) null);
    }

    protected void bpE() {
        if (this.aDz != null) {
            this.aDz.cancelLoadData();
        }
        if (this.hhV != null) {
            this.hhV.cancelLoadData();
        }
        if (this.aDy != null) {
            this.aDy.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bpE();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGP() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(bHJ().getText().toString());
        this.mData.setContent(bHI().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.gii != null && this.gii.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gii, getPageContext().getPageActivity());
                return true;
            } else if (this.aBU.Dg()) {
                this.aBU.Bm();
                return true;
            } else {
                bpE();
                bGP();
                return true;
            }
        }
        if (i == 67 && (text = bHI().getText()) != null) {
            int selectionStart = bHI().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bHI().onKeyDown(67, this.cvd);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ag(i == 1);
        getLayoutMode().t(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.c(this.mPost, d.C0082d.cp_link_tip_a, 1);
        bHu();
        aj.k(this.gif, d.C0082d.cp_bg_line_c);
        aj.k(bHJ(), d.C0082d.cp_bg_line_d);
        aj.k(bHI(), d.C0082d.cp_bg_line_d);
        bpM();
        this.aBU.onChangeSkinType(i);
        if (this.hij != null) {
            this.hij.wE();
        }
        aj.i(this.mName, d.C0082d.cp_cont_b);
        bHx();
        bHy();
        if (this.hfG != null) {
            this.hfG.onChangeSkinType();
        }
        if (this.hiv != null) {
            this.hiv.onChangeSkinType();
        }
        this.eFR.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHx() {
        if (this.gie.hasFocus()) {
            this.gie.setHintTextColor(aj.getColor(d.C0082d.cp_cont_e));
        } else {
            this.gie.setHintTextColor(aj.getColor(d.C0082d.cp_cont_d));
        }
        if (this.bHn.hasFocus()) {
            this.bHn.setHintTextColor(aj.getColor(d.C0082d.cp_cont_e));
        } else {
            this.bHn.setHintTextColor(aj.getColor(d.C0082d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHy() {
        if (this.gie != null) {
            if (this.gie.getText().toString().length() == 0) {
                this.gie.getPaint().setFakeBoldText(false);
            } else if (this.gie.getText().toString().length() > 0) {
                this.gie.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.aMx = new com.baidu.tbadk.core.view.a(getPageContext());
        this.hil = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aqy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        aj.i(this.mName, d.C0082d.cp_cont_b);
        bHA();
        this.hik = (ScrollView) findViewById(d.g.write_scrollview);
        this.hik.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.bHn != null) {
                        l.a(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.bHn);
                    }
                    if (TransmitPostEditActivity.this.aBU != null) {
                        TransmitPostEditActivity.this.aBU.Bm();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.hhT = (LinearLayout) findViewById(d.g.tool_view);
        this.hhT.setContentDescription("..");
        this.hhU = (LinearLayout) findViewById(d.g.title_view);
        this.gif = findViewById(d.g.interval_view);
        this.hin = findViewById(d.g.hot_topic_fourm_view);
        this.hio = findViewById(d.g.hot_topic_divider);
        this.hip = (TextView) findViewById(d.g.hot_topic_title_edt);
        this.hiq = (TextView) findViewById(d.g.change_one_tv);
        bpL();
        if (this.hil) {
            this.hik.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        XG();
        bHG();
        this.bHo = (LinearLayout) findViewById(d.g.post_content_container);
        this.bHo.setDrawingCacheEnabled(false);
        this.bHo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.bHn.requestFocus();
                TransmitPostEditActivity.this.aBU.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            }
        });
        this.aqy.setOnFocusChangeListener(this.bHu);
        this.aqy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.bpE();
                TransmitPostEditActivity.this.bGP();
            }
        });
        bHD();
        bHF();
        bHz();
        bHu();
        bHE();
        bpK();
        bHL();
        if (this.mData.getType() == 4 && this.gik != null && this.hhW != null) {
            this.gik.setVisibility(8);
            this.hhW.setVisibility(8);
        }
        bpM();
        ShowSoftKeyPad(this.mInputManager, this.gie);
    }

    private void bHz() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hef != null && this.hef.equals("1")) {
                        this.mName.setText(d.j.share_to_home_page);
                    } else if (this.hef != null && this.hef.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(d.j.share_to) + this.mData.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(d.j.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(d.j.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.gie.setVisibility(0);
                    this.bHn.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(d.j.publish_photo_live);
                    this.bHn.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(d.j.send_reply);
                    this.bHn.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gie.setVisibility(8);
                    return;
            }
        }
    }

    private void bHA() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.f(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.bHu);
    }

    private void bHB() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hhS && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = am.d(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(d) && bHJ() != null) {
                bHJ().setText(d);
                bHJ().setSelection(d.length());
            }
        }
    }

    private void bHC() {
        this.hie = null;
        this.hig = -1;
        this.hii = -1;
        aa jT = z.amo().jT(1);
        if (jT != null) {
            this.hie = jT.cJX;
            this.hig = getIntent().getIntExtra("category_id", -1);
            if (this.hie != null && !this.hie.isEmpty() && this.hig >= 0) {
                this.hif = new y();
                this.hif.cJT = 0;
                this.hif.name = getPageContext().getResources().getString(d.j.category_auto);
                this.hii = this.hif.cJT;
                this.hih = this.hif.name;
                for (y yVar : this.hie) {
                    if (yVar.cJT == this.hig) {
                        this.hii = yVar.cJT;
                        this.hih = yVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bHD() {
        if (this.hie != null && !this.hie.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.hij = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.hij.setText(this.hih);
            this.hij.b(this.hie, this.hif, this.hii);
            this.hij.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, at atVar) {
                    if (atVar != null) {
                        TransmitPostEditActivity.this.hij.setText(atVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(atVar.cJT);
                        TransmitPostEditActivity.this.hii = atVar.cJT;
                        TransmitPostEditActivity.this.hij.bGH();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.hij.bGG();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHJ());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHI());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hiB = new com.baidu.tieba.view.c(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hiB.setTitle(d.j.no_disturb_start_time);
        this.hiB.setButton(-1, getPageContext().getString(d.j.alert_yes_button), this.hiB);
        this.hiB.setButton(-2, getPageContext().getString(d.j.cancel), this.hiB);
        return this.hiB;
    }

    private void bHE() {
        this.hhZ = (RelativeLayout) findViewById(d.g.addition_container);
        this.hia = (TextView) findViewById(d.g.addition_create_time);
        this.hib = (TextView) findViewById(d.g.addition_last_time);
        this.hic = (TextView) findViewById(d.g.addition_last_content);
        if (this.hhY != null) {
            this.hhZ.setVisibility(0);
            this.hia.setText(getPageContext().getString(d.j.write_addition_create) + am.r(this.hhY.getCreateTime() * 1000));
            if (this.hhY.getAlreadyCount() == 0) {
                this.hib.setVisibility(8);
            } else {
                this.hib.setText(getPageContext().getString(d.j.write_addition_last) + am.r(this.hhY.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hhY.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hic.setText(lastAdditionContent);
            } else {
                this.hic.setVisibility(8);
            }
            bHI().setHint(String.format(getPageContext().getString(d.j.write_addition_hint), Integer.valueOf(this.hhY.getAlreadyCount()), Integer.valueOf(this.hhY.getTotalCount())));
            this.mName.setText(d.j.write_addition_title);
            return;
        }
        this.hhZ.setVisibility(8);
    }

    private void bpK() {
        this.gik = findViewById(d.g.post_prefix_layout);
        this.gih = (TextView) findViewById(d.g.post_prefix);
        this.hhW = findViewById(d.g.prefix_divider);
        this.gij = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gik.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.ghM = 1;
            this.gik.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.gih.setVisibility(0);
                    TransmitPostEditActivity.this.gik.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gii, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.aBU.Bm();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gie);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHn);
                }
            });
            this.gij = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gij.setVisibility(0);
                this.gih.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.gih.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gii, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.aBU.Bm();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHJ());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHI());
                    }
                });
            }
            this.gii = new com.baidu.tieba.write.e(getPageContext().getPageActivity());
            this.gii.a(this);
            this.gii.setMaxHeight(l.f(getActivity(), d.e.ds510));
            this.gii.setOutsideTouchable(true);
            this.gii.setFocusable(true);
            this.gii.setOnDismissListener(this);
            this.gii.setBackgroundDrawable(aj.getDrawable(d.C0082d.cp_bg_line_d));
            int color = aj.getColor(d.C0082d.cp_cont_b);
            int color2 = aj.getColor(d.C0082d.cp_cont_c);
            aj.j(this.gih, d.C0082d.cp_bg_line_d);
            aj.c(this.gij, d.f.icon_frs_arrow_n);
            this.gih.setTextColor(color);
            this.hgO.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.d dVar = new com.baidu.tieba.write.d(getActivity());
                this.hgO.add(dVar);
                dVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    dVar.setPrefixTextColor(color2);
                } else {
                    dVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    dVar.setDividerStyle(false);
                }
                this.gii.addView(dVar);
            }
            this.gii.setCurrentIndex(0);
            this.gih.setText(prefixs.get(1));
            wb(1);
            return;
        }
        this.gik.setVisibility(8);
    }

    protected void bHF() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.hh()) {
                    TransmitPostEditActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.hiv.bEU()) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.hiv.bEW());
                        TransmitPostEditActivity.this.og(true);
                    } else if (TransmitPostEditActivity.this.hfG.bEU()) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.hfG.bEW());
                        TransmitPostEditActivity.this.oa(true);
                    } else {
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHJ());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHI());
                        TransmitPostEditActivity.this.aBU.Bm();
                        TiebaStatic.log(new ak("c12608").r("obj_locate", 7));
                        TransmitPostEditActivity.this.bHN();
                    }
                }
            }
        });
    }

    protected void bpL() {
        this.gie = (EditText) findViewById(d.g.post_title);
        this.gie.setOnClickListener(this.hiy);
        this.gie.setOnFocusChangeListener(this.bHu);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.gie.setText(this.mData.getTitle());
            this.gie.setSelection(this.mData.getTitle().length());
        }
        this.gie.addTextChangedListener(this.bHw);
        if (!this.mData.getHaveDraft()) {
            bHB();
        }
        this.gie.setHint(getResources().getString(d.j.post_title_hint));
    }

    protected void XG() {
        this.bHn = (EditText) findViewById(d.g.post_content);
        this.bHn.setDrawingCacheEnabled(false);
        this.bHn.setOnClickListener(this.hiy);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString U = TbFaceManager.Ey().U(getPageContext().getPageActivity(), this.mData.getContent());
            this.bHn.setText(U);
            this.bHn.setSelection(U.length());
        }
        this.bHn.setOnFocusChangeListener(this.bHu);
        this.bHn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.aBU.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.bHn.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.bHn.addTextChangedListener(this.hiA);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.bHn.setHint(d.j.share_video_default);
        } else {
            this.bHn.setHint(d.j.share_txt_default);
        }
    }

    private void bHG() {
        this.eFR = (OriginalThreadCardView) findViewById(d.g.write_original_thread_cardview);
        this.eFR.setVisibility(0);
        this.eFR.b(this.mOriginalThreadInfo);
        this.eFR.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bHH() {
        int i = 5000;
        if (this.hhY != null) {
            i = 1000;
        }
        return bHI().getText() != null && bHI().getText().length() >= i;
    }

    private void fS(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hhQ)) {
                this.hhQ = "";
                bHI().requestFocus();
                if (bHI().getText() != null && bHI().getText().length() + str.length() > 5000) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bHI().getSelectionStart();
                    editable = bHI().getText();
                }
            } else if ("from_title".equals(this.hhQ)) {
                this.hhQ = "";
                bHJ().requestFocus();
                if (bHJ().getText() != null && bHJ().getText().length() + str.length() > 31) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bHJ().getSelectionStart();
                    editable = bHJ().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oh(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    protected void d(m mVar) {
        if (((ImageSpan[]) bHI().getText().getSpans(0, bHI().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hhX == null) {
                this.hhX = Toast.makeText(getPageContext().getPageActivity(), d.j.too_many_face, 0);
            }
            this.hhX.show();
            return;
        }
        String name = mVar.getName();
        final EmotionGroupType ya = mVar.ya();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.fJ().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.bHI().getSelectionStart(), aVar, ya);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bHI() != null && bHI().getText() != null) {
            Bitmap kK = aVar.kK();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(kK);
            int width = kK.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, kK.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bHI().getSelectionStart() - 1;
                if (bHI().getText().length() > 1 && selectionStart >= 0 && bHI().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bHI().getText().insert(bHI().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bHI().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bHI().getText().insert(bHI().getSelectionStart(), spannableString2);
            }
            Editable text = bHI().getText();
            if (text != null) {
                this.hit.clear();
                this.hit.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hit);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bHI().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bHI().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bHI().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bHI() {
        return this.bHn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bHJ() {
        return this.gie;
    }

    protected void bHK() {
        Editable text;
        if (bHI() != null && (text = bHI().getText()) != null) {
            int selectionStart = bHI().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bHI().onKeyDown(67, this.cvd);
            }
            bHI().onKeyDown(67, this.cvd);
            int selectionStart2 = bHI().getSelectionStart();
            this.hit.clear();
            this.hit.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.hit);
            bHI().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aMx.c(null);
        this.aMx.db(d.j.sending);
        this.aMx.aE(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aMx.aE(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpM() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bHJ() != null) {
                str = bHJ().getText().toString();
            }
            if (bHI() != null) {
                str2 = bHI().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.ghM == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            dx(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        dx(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    dx(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hil) {
                    dx(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    dx(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                dx(true);
            } else if (this.mData.getVideoInfo() != null) {
                dx(true);
            } else {
                dx(false);
            }
        }
    }

    private void dx(boolean z) {
        aj.b(this.mPost, d.C0082d.cp_link_tip_a, d.C0082d.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.aDz = new NewWriteModel(this);
        this.aDz.b(this.aDN);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.bpE();
            }
        };
        this.mData = new WriteData();
        if (bundle != null) {
            this.mData.setType(bundle.getInt("type", 0));
            this.mData.setForumId(bundle.getString("forum_id"));
            this.mData.setForumName(bundle.getString("forum_name"));
            this.mData.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.hhY = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hhY != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.mFrom = bundle.getString("from");
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.hef = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.mOriginalThreadInfo = (OriginalThreadInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.class);
            }
            str = string;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.hhY = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hhY != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hef = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mOriginalThreadInfo = (OriginalThreadInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.mData.getType() == 4 ? 6 : 10);
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(d.j.write_no_prefix));
        }
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.videoId != null) {
            this.mData.setVideoId(this.mOriginalThreadInfo.videoId);
            this.mData.setOriginalVideoCover(this.mOriginalThreadInfo.showPicUrl);
            this.mData.setOriginalVideoTitle(this.mOriginalThreadInfo.showText);
        }
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.hhS = true;
        }
        bHC();
    }

    private void bHL() {
        if (v.v(this.mList) > 0 && this.mList.get(0) != null) {
            this.hin.setVisibility(0);
            this.hio.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.gie.setText(com.baidu.tbadk.plugins.a.gJ(uR(this.mList.get(0).mTopicName)));
                this.gie.setMovementMethod(com.baidu.tieba.view.d.bEa());
            }
            this.hip.setText(this.mList.get(0).mForumName);
            this.gie.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!TransmitPostEditActivity.this.hir.equals(charSequence.toString())) {
                        TransmitPostEditActivity.this.his = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString gJ;
                    if (!TransmitPostEditActivity.this.hir.equals(editable.toString()) && (gJ = com.baidu.tbadk.plugins.a.gJ(editable.toString())) != null) {
                        TransmitPostEditActivity.this.hir = gJ.toString();
                        TransmitPostEditActivity.this.gie.setText(gJ);
                        if (TransmitPostEditActivity.this.his <= TransmitPostEditActivity.this.gie.getText().length()) {
                            TransmitPostEditActivity.this.gie.setSelection(TransmitPostEditActivity.this.his);
                        }
                    }
                }
            });
            this.hiq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicChangeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 25005, TransmitPostEditActivity.this.mList)));
                }
            });
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString gJ = com.baidu.tbadk.plugins.a.gJ(uR(hotTopicBussinessData.mTopicName));
            if (gJ != null) {
                this.gie.setText(gJ);
            }
            this.hip.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String uR(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("#").append(str).append("#");
        return sb.toString();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.mData.getType());
        bundle.putString("forum_id", this.mData.getForumId());
        bundle.putString("forum_name", this.mData.getForumName());
        bundle.putString("thread_id", this.mData.getThreadId());
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.hhY != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hhY));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.hef);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bHI().getEditableText().toString();
        if (obj != null) {
            bHI().setText(TbFaceManager.Ey().a(getPageContext().getPageActivity(), obj, this.hiw));
            bHI().setSelection(bHI().getText().length());
        }
    }

    private String bHM() {
        if (bHI() == null || bHI().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(bHI().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(d.j.share_video_default);
            }
            return getString(d.j.share_txt_default);
        }
        return bHI().getText().toString();
    }

    private String bes() {
        if (this.mData == null || bHJ() == null || bHJ().getVisibility() != 0 || bHJ().getText() == null) {
            return "";
        }
        String obj = bHJ().getText().toString();
        if (this.mPrefixData != null && v.v(this.mPrefixData.getPrefixs()) > 0 && this.ghM != 0 && this.mData.getType() != 4 && this.gih != null && this.gih.getText() != null) {
            obj = this.gih.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void bGQ() {
        bpE();
        this.mData.setContent(bHM());
        this.mData.setTitle(bes());
        if (this.hig >= 0) {
            this.mData.setCategoryFrom(this.hig);
        }
        if (this.hii >= 0) {
            this.mData.setCategoryTo(this.hii);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aDy != null && this.aDy.YI());
        this.aDz.ng(this.writeImagesInfo.size() > 0);
        if (!v.w(this.mList) && this.him != null && this.him.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.him.mForumId));
            this.mData.setForumName(this.him.mForumName);
        }
        this.aDz.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.aDz.getWriteData().setVoice(null);
        this.aDz.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.hh()) {
            showToast(d.j.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
        this.aDz.startPostWrite();
    }

    private void t(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.hhY != null) {
                i2 = this.hhY.getTotalCount();
                i = this.hhY.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(d.j.write_addition_left_count), Integer.valueOf(i2 - i)));
            }
        }
        l.showToast(getPageContext().getPageActivity(), sb.toString());
    }

    @Override // android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    protected void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                if (this.aBU != null && !this.aBU.Dg()) {
                    bHI().requestFocus();
                    this.mInputManager.toggleSoftInput(0, 2);
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
                            bHI().getText().insert(bHI().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                j((intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data"));
                setResult(-1, intent);
                finish();
            } else if (i == 25004) {
                if (intent != null) {
                    String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                    if (!StringUtils.isNull(stringExtra)) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.hhR) {
                            sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                            this.hhR = false;
                        }
                        sb2.append(stringExtra);
                        fS(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !v.w(this.mList) && !v.w(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.him = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.him);
            }
        } else if (i2 == 0) {
            if (this.aBU != null && !this.aBU.Dg()) {
                this.bHn.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                        return;
                    }
                    return;
                case 12006:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.hfG.aB(postWriteCallBackData.getSensitiveWords());
                        this.hiv.aB(postWriteCallBackData.getSensitiveWords());
                        if (!v.w(this.hfG.bES())) {
                            oa(true);
                            og(true);
                            return;
                        }
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.hhQ)) {
                        bHJ().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hhQ)) {
                        bHI().requestFocus();
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHN() {
        if ("1".equals(this.hef)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.hef)) {
            this.mData.setCanNoForum(false);
        }
        bHO();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.hef);
        bGQ();
    }

    private void bHO() {
        if (this.aBU != null) {
            this.aBU.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bHJ());
        HidenSoftKeyPad(this.mInputManager, bHI());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.uq(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.cHQ) != null) {
                    TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahP));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.j.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hhY == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                t(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.aDE = i;
        if (this.aBU != null) {
            this.aBU.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bHP() {
        if (!this.hil && this.aBU != null) {
            this.aBU.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.aBU.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(boolean z) {
        if (this.aBU != null) {
            this.aBU.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void wb(int i) {
        if (i < this.hgO.size()) {
            for (int i2 = 0; i2 < this.hgO.size(); i2++) {
                this.hgO.get(i2).nV(false);
            }
            this.hgO.get(i).nV(true);
        }
    }

    @Override // com.baidu.tieba.write.e.a
    public void tC(int i) {
        this.ghM = i;
        this.gii.setCurrentIndex(i);
        wb(i);
        this.gih.setText(this.mPrefixData.getPrefixs().get(i));
        bpM();
        com.baidu.adp.lib.g.g.a(this.gii, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gik.setSelected(false);
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
            l.a(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
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

    @Override // android.app.Activity, com.baidu.b.a.a.InterfaceC0022a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            DE();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hiu != null && !z) {
            this.hiu.aWg();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hhR = false;
            this.hhQ = "";
            if ("from_content".equals(str)) {
                this.hhQ = "from_content";
            } else if ("from_title".equals(str)) {
                this.hhQ = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                oh(false);
            }
        }
    }

    public void Bo() {
        if (!v.w(this.mList)) {
            this.hhU.setVisibility(0);
            this.hhU.requestFocus();
            this.aBU.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hhU.setVisibility(8);
    }
}
