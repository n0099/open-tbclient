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
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
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
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.editortools.r;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.av;
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
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0036a, e.a {
    private com.baidu.tbadk.editortools.i bpX;
    private LocationModel brA;
    private NewWriteModel brB;
    private OriginalThreadCardView ftt;
    private TextView gYQ;
    private com.baidu.tieba.write.e gYR;
    private ImageView gYS;
    private View gYT;
    private int gYw;
    private com.baidu.tieba.write.b hQF;
    private LinearLayout hSX;
    private LinearLayout hSY;
    private com.baidu.tieba.view.d hTE;
    private View hTa;
    private Toast hTb;
    private AdditionData hTc;
    private RelativeLayout hTd;
    private TextView hTe;
    private TextView hTf;
    private TextView hTg;
    List<z> hTh;
    z hTi;
    private int hTj;
    private String hTk;
    private int hTl;
    private PostCategoryView hTm;
    private HotTopicBussinessData hTp;
    private View hTq;
    private View hTr;
    private TextView hTs;
    private TextView hTt;
    private com.baidu.tieba.write.editor.d hTx;
    private com.baidu.tieba.write.b hTy;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String hSU = "";
    private boolean hSV = false;
    private WriteData mData = null;
    private boolean hSW = false;
    private InputMethodManager mInputManager = null;
    private EditText gYN = null;
    private View gYO = null;
    private LinearLayout cwe = null;
    private EditText cwd = null;
    private FeedBackModel hSZ = null;
    private ArrayList<com.baidu.tieba.write.d> hRQ = new ArrayList<>();
    private final KeyEvent djM = new KeyEvent(0, 67);
    private View beD = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String brF = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int brG = 0;
    private View mRootView = null;
    private ScrollView hTn = null;
    private boolean hTo = false;
    private com.baidu.tbadk.core.view.b bAr = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String hyr = "2";
    private String hTu = "";
    private int hTv = 0;
    private SpannableStringBuilder hTw = new SpannableStringBuilder();
    private TbFaceManager.a hTz = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan gt(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.a.a.class);
            com.baidu.adp.widget.a.a aVar = runTask != null ? (com.baidu.adp.widget.a.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.si());
            int width = aVar.getWidth();
            if (str.startsWith("#(meme,")) {
                bitmapDrawable.setBounds(0, 0, width, aVar.getHeight());
            } else {
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            return new com.baidu.tbadk.core.view.h(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a dxB = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").s("obj_locate", ap.a.aVW));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").s("obj_locate", ap.a.aVW));
        }
    };
    private final NewWriteModel.d brP = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.hQF.aB(null);
                TransmitPostEditActivity.this.hQF.on(false);
                TransmitPostEditActivity.this.hTy.aB(null);
                TransmitPostEditActivity.this.hTy.on(false);
                if (z) {
                    TransmitPostEditActivity.this.ck(z);
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
                    TransmitPostEditActivity.this.hQF.aB(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.hTy.aB(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.hQF.uE(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.hTy.uE(postWriteCallBackData.getErrorString());
                    if (!v.G(TransmitPostEditActivity.this.hQF.bLm())) {
                        TransmitPostEditActivity.this.ow(true);
                        TransmitPostEditActivity.this.oC(true);
                    }
                } else if ((sVar == null || writeData == null || sVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (sVar != null && writeData != null && sVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(sVar.getVcode_md5());
                    writeData.setVcodeUrl(sVar.getVcode_pic_url());
                    writeData.setVcodeExtra(sVar.FJ());
                    if (com.baidu.tbadk.p.a.hf(sVar.FI())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, sVar.FI())));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a brN = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void Lu() {
            TransmitPostEditActivity.this.showToast(d.j.no_network_guide);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void gh(String str) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            if (StringUtils.isNull(str)) {
                str = TransmitPostEditActivity.this.getPageContext().getString(d.j.location_fail);
            }
            transmitPostEditActivity.showToast(str);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bCP())) {
                TransmitPostEditActivity.this.b(2, true, aVar.bCP());
            } else {
                gh(null);
            }
        }
    };
    private final CustomMessageListener hkU = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.brA.nA(false);
                    TransmitPostEditActivity.this.brA.cj(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.brA.nA(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hTA = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hTB = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.bpX.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bNU = TransmitPostEditActivity.this.bNU();
            if (bNU >= 0 && bNU < TransmitPostEditActivity.this.cwd.getText().length()) {
                TransmitPostEditActivity.this.cwd.setSelection(bNU);
            }
        }
    };
    private boolean hTC = true;
    private final View.OnFocusChangeListener cwk = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.gYN || view == TransmitPostEditActivity.this.beD || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.hTC = true;
                    TransmitPostEditActivity.this.bNV();
                    if (TransmitPostEditActivity.this.bpX != null) {
                        TransmitPostEditActivity.this.bpX.IP();
                    }
                    l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gYN);
                } else if (view == TransmitPostEditActivity.this.gYN) {
                    TransmitPostEditActivity.this.gYQ.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.cwd && z) {
                TransmitPostEditActivity.this.hTC = false;
                TransmitPostEditActivity.this.bNV();
                TransmitPostEditActivity.this.bpX.IP();
                l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.cwd);
            }
            TransmitPostEditActivity.this.bNY();
        }
    };
    private TextWatcher cwm = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bya();
            if (TransmitPostEditActivity.this.hTy != null) {
                if (!TransmitPostEditActivity.this.hTy.bLp()) {
                    TransmitPostEditActivity.this.oC(false);
                }
                TransmitPostEditActivity.this.hTy.oo(false);
                TransmitPostEditActivity.this.bNZ();
            }
        }
    };
    private TextWatcher hTD = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bya();
            if (TransmitPostEditActivity.this.hQF != null) {
                if (!TransmitPostEditActivity.this.hQF.bLp()) {
                    TransmitPostEditActivity.this.ow(false);
                }
                TransmitPostEditActivity.this.hQF.oo(false);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oC(boolean z) {
        if (bOk() != null && bOk().getVisibility() == 0 && bOk().getText() != null) {
            int selectionEnd = bOk().getSelectionEnd();
            SpannableStringBuilder b = this.hTy.b(bOk().getText());
            if (b != null) {
                this.hTy.oo(true);
                bOk().setText(b);
                if (z && this.hTy.bLn() >= 0) {
                    bOk().requestFocus();
                    bOk().setSelection(this.hTy.bLn());
                } else {
                    bOk().setSelection(selectionEnd);
                }
                this.hTy.on(this.hTy.bLn() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ow(boolean z) {
        if (bOj() != null && bOj().getText() != null) {
            int selectionEnd = bOj().getSelectionEnd();
            SpannableStringBuilder b = this.hQF.b(bOj().getText());
            if (b != null) {
                this.hQF.oo(true);
                bOj().setText(b);
                if (z && this.hQF.bLn() >= 0) {
                    bOj().requestFocus();
                    bOj().setSelection(this.hQF.bLn());
                } else {
                    bOj().setSelection(selectionEnd);
                }
                this.hQF.on(this.hQF.bLn() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lf() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Lg() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Lh();
        } else if (this.brA.bCX()) {
            Lf();
        } else {
            this.brA.nA(false);
            b(1, true, null);
            this.brA.bCV();
        }
    }

    private void Lh() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.fd(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.oI()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.brA.agv();
                } else {
                    TransmitPostEditActivity.this.brN.Lu();
                }
                aVar2.dismiss();
            }
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TransmitPostEditActivity.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.AI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bNU() {
        int selectionEnd = bOj().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bOj().getText().getSpans(0, bOj().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bOj().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bOj().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNV() {
        if (this.bpX != null) {
            this.bpX.setBarLauncherEnabled(!this.hTC);
            this.bpX.g(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hTo) {
            this.gYN.setVisibility(8);
            bya();
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
        this.hTy = new com.baidu.tieba.write.b();
        this.hTy.yD(d.C0108d.cp_cont_i);
        this.hTy.yE(d.C0108d.cp_cont_h_alpha85);
        this.hQF = new com.baidu.tieba.write.b();
        this.hQF.yD(d.C0108d.cp_cont_i);
        this.hQF.yE(d.C0108d.cp_cont_h_alpha85);
        initUI();
        this.brA = new LocationModel(this);
        this.brA.a(this.brN);
        registerListener(this.hkU);
        registerListener(this.hTA);
        initEditor();
        this.cwd.requestFocus();
        IR();
        bOq();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.bpX = new com.baidu.tbadk.editortools.i(getActivity());
        this.bpX.setBarMaxLauCount(4);
        this.bpX.setMoreButtonAtEnd(true);
        this.bpX.setBarLauncherType(1);
        this.bpX.cc(true);
        this.bpX.cd(true);
        this.bpX.setMoreLauncherIcon(d.f.write_more);
        this.bpX.setBackgroundColorId(d.C0108d.cp_bg_line_d);
        bNW();
        this.bpX.KG();
        if (this.hSX != null) {
            this.hSX.addView(this.bpX);
        }
        bNX();
        this.bpX.th();
        com.baidu.tbadk.editortools.l hL = this.bpX.hL(6);
        if (hL != null && !TextUtils.isEmpty(this.brF)) {
            ((View) hL).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.brF);
                }
            });
        }
        if (!this.hTo) {
            this.bpX.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.bpX.IP();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.bpX.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.bpX.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void bNW() {
        r rVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 2);
        aVar.bqE = d.f.write_at;
        this.bpX.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.bpX.b(aVar2);
        aVar2.bqE = d.f.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), r.class);
        if (runTask != null && (rVar = (r) runTask.getData()) != null) {
            rVar.bqG = 4;
            rVar.bqE = d.f.icon_post_location_selector;
            this.bpX.b(rVar);
        }
        if (this.hTc == null) {
            if (this.hTx == null) {
                this.hTx = new com.baidu.tieba.write.editor.d(getActivity(), this.hyr);
                this.hTx.bMv();
                this.hTx.setFrom("from_share_write");
                this.hTx.aL(this.mData.getForumId(), this.mPrivateThread);
            }
            this.bpX.b(this.hTx);
        }
        this.bpX.K(arrayList);
        r hN = this.bpX.hN(5);
        if (hN != null) {
            hN.bqG = 1;
            hN.bqE = d.f.write_emotion;
        }
    }

    private void bNX() {
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
                            TiebaStatic.log(new ak("c12608").s("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.bOi()) {
                            TransmitPostEditActivity.this.showToast(d.j.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.bOi()) {
                            TransmitPostEditActivity.this.showToast(d.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            TransmitPostEditActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.bOl();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.bya();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.hTc == null) {
                            TransmitPostEditActivity.this.Li();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.brG) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.aT(pageActivity)) {
                                    TransmitPostEditActivity.this.Lg();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.Lf();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.brA != null) {
                            TransmitPostEditActivity.this.brA.nA(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        ak akVar = new ak("c10645");
                        if (TransmitPostEditActivity.this.mData != null) {
                            str = TransmitPostEditActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        akVar.ab(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(akVar);
                        if (TransmitPostEditActivity.this.mData == null || (videoInfo = TransmitPostEditActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.bpX.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.bpX.KI()) {
                                        TransmitPostEditActivity.this.bpX.IP();
                                        TransmitPostEditActivity.this.bpX.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.bpX.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.bpX.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.bpX.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.bpX.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.bya();
                        if (TransmitPostEditActivity.this.cwd != null) {
                            TransmitPostEditActivity.this.cwd.requestFocus();
                        }
                        TransmitPostEditActivity.this.bpX.IP();
                        TransmitPostEditActivity.this.bpX.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cwd);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.bpX.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.hSV = true;
                        TransmitPostEditActivity.this.oD(true);
                        if (TransmitPostEditActivity.this.bOk().isFocused()) {
                            TransmitPostEditActivity.this.hSU = "from_title";
                        } else if (TransmitPostEditActivity.this.bOj().isFocused()) {
                            TransmitPostEditActivity.this.hSU = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.hSY.setVisibility(0);
                        TransmitPostEditActivity.this.hSY.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.hSY.hasFocus()) {
                            TransmitPostEditActivity.this.cwd.requestFocus();
                            TransmitPostEditActivity.this.cwd.setSelection(TransmitPostEditActivity.this.cwd.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.hSY.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.bpX.a(31, bVar);
        this.bpX.a(16, bVar);
        this.bpX.a(14, bVar);
        this.bpX.a(24, bVar);
        this.bpX.a(3, bVar);
        this.bpX.a(10, bVar);
        this.bpX.a(11, bVar);
        this.bpX.a(12, bVar);
        this.bpX.a(13, bVar);
        this.bpX.a(15, bVar);
        this.bpX.a(18, bVar);
        this.bpX.a(20, bVar);
        this.bpX.a(25, bVar);
        this.bpX.a(27, bVar);
        this.bpX.a(29, bVar);
        this.bpX.a(43, bVar);
        this.bpX.a(45, bVar);
        this.bpX.a(53, bVar);
        this.bpX.a(48, bVar);
        this.bpX.a(46, bVar);
        this.bpX.a(49, bVar);
        this.bpX.a(47, bVar);
        this.bpX.a(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Li() {
        if (this.brA.agr()) {
            if (this.brA.bCX()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bCT().getLocationData().bCP());
                return;
            }
            b(1, true, null);
            this.brA.bCV();
            return;
        }
        b(0, true, null);
    }

    protected void bxS() {
        if (this.brB != null) {
            this.brB.cancelLoadData();
        }
        if (this.hSZ != null) {
            this.hSZ.cancelLoadData();
        }
        if (this.brA != null) {
            this.brA.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bxS();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNp() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(bOk().getText().toString());
        this.mData.setContent(bOj().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.gYR != null && this.gYR.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gYR, getPageContext().getPageActivity());
                return true;
            } else if (this.bpX.KI()) {
                this.bpX.IP();
                return true;
            } else {
                bxS();
                bNp();
                return true;
            }
        }
        if (i == 67 && (text = bOj().getText()) != null) {
            int selectionStart = bOj().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bOj().onKeyDown(67, this.djM);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aM(i == 1);
        getLayoutMode().aM(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.e(this.mPost, d.C0108d.cp_link_tip_a, 1);
        bNV();
        aj.t(this.gYO, d.C0108d.cp_bg_line_c);
        aj.t(bOk(), d.C0108d.cp_bg_line_d);
        aj.t(bOj(), d.C0108d.cp_bg_line_d);
        bya();
        this.bpX.onChangeSkinType(i);
        if (this.hTm != null) {
            this.hTm.Ea();
        }
        aj.r(this.mName, d.C0108d.cp_cont_b);
        bNY();
        bNZ();
        if (this.hQF != null) {
            this.hQF.onChangeSkinType();
        }
        if (this.hTy != null) {
            this.hTy.onChangeSkinType();
        }
        this.ftt.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNY() {
        if (this.gYN.hasFocus()) {
            this.gYN.setHintTextColor(aj.getColor(d.C0108d.cp_cont_e));
        } else {
            this.gYN.setHintTextColor(aj.getColor(d.C0108d.cp_cont_d));
        }
        if (this.cwd.hasFocus()) {
            this.cwd.setHintTextColor(aj.getColor(d.C0108d.cp_cont_e));
        } else {
            this.cwd.setHintTextColor(aj.getColor(d.C0108d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNZ() {
        if (this.gYN != null) {
            if (this.gYN.getText().toString().length() == 0) {
                this.gYN.getPaint().setFakeBoldText(false);
            } else if (this.gYN.getText().toString().length() > 0) {
                this.gYN.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.bAr = new com.baidu.tbadk.core.view.b(getPageContext());
        this.hTo = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.beD = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        aj.r(this.mName, d.C0108d.cp_cont_b);
        bOb();
        this.hTn = (ScrollView) findViewById(d.g.write_scrollview);
        this.hTn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.cwd != null) {
                        l.a(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.cwd);
                    }
                    if (TransmitPostEditActivity.this.bpX != null) {
                        TransmitPostEditActivity.this.bpX.IP();
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
        this.hSX = (LinearLayout) findViewById(d.g.tool_view);
        this.hSX.setContentDescription("..");
        this.hSY = (LinearLayout) findViewById(d.g.title_view);
        this.gYO = findViewById(d.g.interval_view);
        this.hTq = findViewById(d.g.hot_topic_fourm_view);
        this.hTr = findViewById(d.g.hot_topic_divider);
        this.hTs = (TextView) findViewById(d.g.hot_topic_title_edt);
        this.hTt = (TextView) findViewById(d.g.change_one_tv);
        bxZ();
        if (this.hTo) {
            this.hTn.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        afp();
        bOh();
        this.cwe = (LinearLayout) findViewById(d.g.post_content_container);
        this.cwe.setDrawingCacheEnabled(false);
        this.cwe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.cwd.requestFocus();
                TransmitPostEditActivity.this.bpX.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            }
        });
        this.beD.setOnFocusChangeListener(this.cwk);
        this.beD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.bxS();
                TransmitPostEditActivity.this.bNp();
            }
        });
        bOe();
        bOg();
        bOa();
        bNV();
        bOf();
        bxY();
        bOm();
        if (this.mData.getType() == 4 && this.gYT != null && this.hTa != null) {
            this.gYT.setVisibility(8);
            this.hTa.setVisibility(8);
        }
        bya();
        ShowSoftKeyPad(this.mInputManager, this.gYN);
    }

    private void bOa() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hyr != null && this.hyr.equals("1")) {
                        this.mName.setText(d.j.share_to_home_page);
                    } else if (this.hyr != null && this.hyr.equals("2")) {
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
                    this.gYN.setVisibility(0);
                    this.cwd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(d.j.publish_photo_live);
                    this.cwd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(d.j.send_reply);
                    this.cwd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gYN.setVisibility(8);
                    return;
            }
        }
    }

    private void bOb() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.s(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.cwk);
    }

    private void bOc() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hSW && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = am.d(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(d) && bOk() != null) {
                bOk().setText(d);
                bOk().setSelection(d.length());
            }
        }
    }

    private void bOd() {
        this.hTh = null;
        this.hTj = -1;
        this.hTl = -1;
        com.baidu.tieba.frs.ab mW = aa.auf().mW(1);
        if (mW != null) {
            this.hTh = mW.dzs;
            this.hTj = getIntent().getIntExtra("category_id", -1);
            if (this.hTh != null && !this.hTh.isEmpty() && this.hTj >= 0) {
                this.hTi = new z();
                this.hTi.dzo = 0;
                this.hTi.name = getPageContext().getResources().getString(d.j.category_auto);
                this.hTl = this.hTi.dzo;
                this.hTk = this.hTi.name;
                for (z zVar : this.hTh) {
                    if (zVar.dzo == this.hTj) {
                        this.hTl = zVar.dzo;
                        this.hTk = zVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bOe() {
        if (this.hTh != null && !this.hTh.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.hTm = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.hTm.setText(this.hTk);
            this.hTm.b(this.hTh, this.hTi, this.hTl);
            this.hTm.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, av avVar) {
                    if (avVar != null) {
                        TransmitPostEditActivity.this.hTm.setText(avVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(avVar.dzo);
                        TransmitPostEditActivity.this.hTl = avVar.dzo;
                        TransmitPostEditActivity.this.hTm.bNh();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.hTm.bNg();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bOk());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bOj());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hTE = new com.baidu.tieba.view.d(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hTE.setTitle(d.j.no_disturb_start_time);
        this.hTE.setButton(-1, getPageContext().getString(d.j.alert_yes_button), this.hTE);
        this.hTE.setButton(-2, getPageContext().getString(d.j.cancel), this.hTE);
        return this.hTE;
    }

    private void bOf() {
        this.hTd = (RelativeLayout) findViewById(d.g.addition_container);
        this.hTe = (TextView) findViewById(d.g.addition_create_time);
        this.hTf = (TextView) findViewById(d.g.addition_last_time);
        this.hTg = (TextView) findViewById(d.g.addition_last_content);
        if (this.hTc != null) {
            this.hTd.setVisibility(0);
            this.hTe.setText(getPageContext().getString(d.j.write_addition_create) + am.z(this.hTc.getCreateTime() * 1000));
            if (this.hTc.getAlreadyCount() == 0) {
                this.hTf.setVisibility(8);
            } else {
                this.hTf.setText(getPageContext().getString(d.j.write_addition_last) + am.z(this.hTc.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hTc.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hTg.setText(lastAdditionContent);
            } else {
                this.hTg.setVisibility(8);
            }
            bOj().setHint(String.format(getPageContext().getString(d.j.write_addition_hint), Integer.valueOf(this.hTc.getAlreadyCount()), Integer.valueOf(this.hTc.getTotalCount())));
            this.mName.setText(d.j.write_addition_title);
            return;
        }
        this.hTd.setVisibility(8);
    }

    private void bxY() {
        this.gYT = findViewById(d.g.post_prefix_layout);
        this.gYQ = (TextView) findViewById(d.g.post_prefix);
        this.hTa = findViewById(d.g.prefix_divider);
        this.gYS = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gYT.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gYw = 1;
            this.gYT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.gYQ.setVisibility(0);
                    TransmitPostEditActivity.this.gYT.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gYR, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.bpX.IP();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gYN);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cwd);
                }
            });
            this.gYS = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gYS.setVisibility(0);
                this.gYQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.gYQ.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gYR, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.bpX.IP();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bOk());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bOj());
                    }
                });
            }
            this.gYR = new com.baidu.tieba.write.e(getPageContext().getPageActivity());
            this.gYR.a(this);
            this.gYR.setMaxHeight(l.s(getActivity(), d.e.ds510));
            this.gYR.setOutsideTouchable(true);
            this.gYR.setFocusable(true);
            this.gYR.setOnDismissListener(this);
            this.gYR.setBackgroundDrawable(aj.getDrawable(d.C0108d.cp_bg_line_d));
            int color = aj.getColor(d.C0108d.cp_cont_b);
            int color2 = aj.getColor(d.C0108d.cp_cont_c);
            aj.s(this.gYQ, d.C0108d.cp_bg_line_d);
            aj.c(this.gYS, d.f.icon_frs_arrow_n);
            this.gYQ.setTextColor(color);
            this.hRQ.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.d dVar = new com.baidu.tieba.write.d(getActivity());
                this.hRQ.add(dVar);
                dVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    dVar.setPrefixTextColor(color2);
                } else {
                    dVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    dVar.setDividerStyle(false);
                }
                this.gYR.addView(dVar);
            }
            this.gYR.setCurrentIndex(0);
            this.gYQ.setText(prefixs.get(1));
            zf(1);
            return;
        }
        this.gYT.setVisibility(8);
    }

    protected void bOg() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.oI()) {
                    TransmitPostEditActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.hTy.bLo()) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.hTy.bLq());
                        TransmitPostEditActivity.this.oC(true);
                    } else if (TransmitPostEditActivity.this.hQF.bLo()) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.hQF.bLq());
                        TransmitPostEditActivity.this.ow(true);
                    } else {
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bOk());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bOj());
                        TransmitPostEditActivity.this.bpX.IP();
                        TiebaStatic.log(new ak("c12608").s("obj_locate", 7));
                        TransmitPostEditActivity.this.bOo();
                    }
                }
            }
        });
    }

    protected void bxZ() {
        this.gYN = (EditText) findViewById(d.g.post_title);
        this.gYN.setOnClickListener(this.hTB);
        this.gYN.setOnFocusChangeListener(this.cwk);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.gYN.setText(this.mData.getTitle());
            this.gYN.setSelection(this.mData.getTitle().length());
        }
        this.gYN.addTextChangedListener(this.cwm);
        if (!this.mData.getHaveDraft()) {
            bOc();
        }
        this.gYN.setHint(getResources().getString(d.j.post_title_hint));
    }

    protected void afp() {
        this.cwd = (EditText) findViewById(d.g.post_content);
        this.cwd.setDrawingCacheEnabled(false);
        this.cwd.setOnClickListener(this.hTB);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString W = TbFaceManager.Ma().W(getPageContext().getPageActivity(), this.mData.getContent());
            this.cwd.setText(W);
            this.cwd.setSelection(W.length());
        }
        this.cwd.setOnFocusChangeListener(this.cwk);
        this.cwd.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.bpX.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.cwd.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.cwd.addTextChangedListener(this.hTD);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.cwd.setHint(d.j.share_video_default);
        } else {
            this.cwd.setHint(d.j.share_txt_default);
        }
    }

    private void bOh() {
        this.ftt = (OriginalThreadCardView) findViewById(d.g.write_original_thread_cardview);
        this.ftt.setVisibility(0);
        this.ftt.b(this.mOriginalThreadInfo);
        this.ftt.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bOi() {
        int i = 5000;
        if (this.hTc != null) {
            i = 1000;
        }
        return bOj().getText() != null && bOj().getText().length() >= i;
    }

    private void fY(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hSU)) {
                this.hSU = "";
                bOj().requestFocus();
                if (bOj().getText() != null && bOj().getText().length() + str.length() > 5000) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bOj().getSelectionStart();
                    editable = bOj().getText();
                }
            } else if ("from_title".equals(this.hSU)) {
                this.hSU = "";
                bOk().requestFocus();
                if (bOk().getText() != null && bOk().getText().length() + str.length() > 31) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bOk().getSelectionStart();
                    editable = bOk().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oD(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    protected void d(n nVar) {
        if (((ImageSpan[]) bOj().getText().getSpans(0, bOj().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hTb == null) {
                this.hTb = Toast.makeText(getPageContext().getPageActivity(), d.j.too_many_face, 0);
            }
            this.hTb.show();
            return;
        }
        String name = nVar.getName();
        final EmotionGroupType FA = nVar.FA();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.nl().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.bOj().getSelectionStart(), aVar, FA);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bOj() != null && bOj().getText() != null) {
            Bitmap si = aVar.si();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(si);
            int width = si.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, si.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.h(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bOj().getSelectionStart() - 1;
                if (bOj().getText().length() > 1 && selectionStart >= 0 && bOj().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bOj().getText().insert(bOj().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bOj().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bOj().getText().insert(bOj().getSelectionStart(), spannableString2);
            }
            Editable text = bOj().getText();
            if (text != null) {
                this.hTw.clear();
                this.hTw.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hTw);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bOj().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bOj().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bOj().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bOj() {
        return this.cwd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bOk() {
        return this.gYN;
    }

    protected void bOl() {
        Editable text;
        if (bOj() != null && (text = bOj().getText()) != null) {
            int selectionStart = bOj().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bOj().onKeyDown(67, this.djM);
            }
            bOj().onKeyDown(67, this.djM);
            int selectionStart2 = bOj().getSelectionStart();
            this.hTw.clear();
            this.hTw.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.hTw);
            bOj().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.bAr.c(null);
        this.bAr.ga(d.j.sending);
        this.bAr.bm(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.bAr.bm(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bya() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bOk() != null) {
                str = bOk().getText().toString();
            }
            if (bOj() != null) {
                str2 = bOj().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.gYw == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            ef(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        ef(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    ef(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hTo) {
                    ef(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    ef(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                ef(true);
            } else if (this.mData.getVideoInfo() != null) {
                ef(true);
            } else {
                ef(false);
            }
        }
    }

    private void ef(boolean z) {
        aj.d(this.mPost, d.C0108d.cp_link_tip_a, d.C0108d.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.brB = new NewWriteModel(this);
        this.brB.b(this.brP);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.bxS();
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
                this.hTc = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hTc != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.mFrom = bundle.getString("from");
            this.mPrivateThread = bundle.getInt("private_thread");
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.hyr = bundle.getString("KEY_CALL_FROM");
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
            this.hTc = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hTc != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hyr = intent.getStringExtra("KEY_CALL_FROM");
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
            this.hSW = true;
        }
        bOd();
    }

    private void bOm() {
        if (v.F(this.mList) > 0 && this.mList.get(0) != null) {
            this.hTq.setVisibility(0);
            this.hTr.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.gYN.setText(com.baidu.tbadk.plugins.a.gL(vc(this.mList.get(0).mTopicName)));
                this.gYN.setMovementMethod(com.baidu.tieba.view.e.bKu());
            }
            this.hTs.setText(this.mList.get(0).mForumName);
            this.gYN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!TransmitPostEditActivity.this.hTu.equals(charSequence.toString())) {
                        TransmitPostEditActivity.this.hTv = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString gL;
                    if (!TransmitPostEditActivity.this.hTu.equals(editable.toString()) && (gL = com.baidu.tbadk.plugins.a.gL(editable.toString())) != null) {
                        TransmitPostEditActivity.this.hTu = gL.toString();
                        TransmitPostEditActivity.this.gYN.setText(gL);
                        if (TransmitPostEditActivity.this.hTv <= TransmitPostEditActivity.this.gYN.getText().length()) {
                            TransmitPostEditActivity.this.gYN.setSelection(TransmitPostEditActivity.this.hTv);
                        }
                    }
                }
            });
            this.hTt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicChangeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 25005, TransmitPostEditActivity.this.mList)));
                }
            });
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString gL = com.baidu.tbadk.plugins.a.gL(vc(hotTopicBussinessData.mTopicName));
            if (gL != null) {
                this.gYN.setText(gL);
            }
            this.hTs.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String vc(String str) {
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
        bundle.putInt("private_thread", this.mPrivateThread);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.hTc != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hTc));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.hyr);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bOj().getEditableText().toString();
        if (obj != null) {
            bOj().setText(TbFaceManager.Ma().a(getPageContext().getPageActivity(), obj, this.hTz));
            bOj().setSelection(bOj().getText().length());
        }
    }

    private String bOn() {
        if (bOj() == null || bOj().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(bOj().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(d.j.share_video_default);
            }
            return getString(d.j.share_txt_default);
        }
        return bOj().getText().toString();
    }

    private String blT() {
        if (this.mData == null || bOk() == null || bOk().getVisibility() != 0 || bOk().getText() == null) {
            return "";
        }
        String obj = bOk().getText().toString();
        if (this.mPrefixData != null && v.F(this.mPrefixData.getPrefixs()) > 0 && this.gYw != 0 && this.mData.getType() != 4 && this.gYQ != null && this.gYQ.getText() != null) {
            obj = this.gYQ.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void bNq() {
        bxS();
        this.mData.setContent(bOn());
        this.mData.setTitle(blT());
        if (this.hTj >= 0) {
            this.mData.setCategoryFrom(this.hTj);
        }
        if (this.hTl >= 0) {
            this.mData.setCategoryTo(this.hTl);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.brA != null && this.brA.agr());
        this.brB.nC(this.writeImagesInfo.size() > 0);
        if (!v.G(this.mList) && this.hTp != null && this.hTp.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hTp.mForumId));
            this.mData.setForumName(this.hTp.mForumName);
        }
        this.brB.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.brB.getWriteData().setVoice(null);
        this.brB.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.oI()) {
            showToast(d.j.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
        this.brB.startPostWrite();
    }

    private void s(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.hTc != null) {
                i2 = this.hTc.getTotalCount();
                i = this.hTc.getAlreadyCount() + 1;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    public void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                if (this.bpX != null && !this.bpX.KI()) {
                    bOj().requestFocus();
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
                            bOj().getText().insert(bOj().getSelectionStart(), sb.toString());
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
                        if (this.hSV) {
                            sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                            this.hSV = false;
                        }
                        sb2.append(stringExtra);
                        fY(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !v.G(this.mList) && !v.G(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.hTp = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.hTp);
            }
        } else if (i2 == 0) {
            if (this.bpX != null && !this.bpX.KI()) {
                this.cwd.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.hQF.aB(postWriteCallBackData.getSensitiveWords());
                        this.hTy.aB(postWriteCallBackData.getSensitiveWords());
                        if (!v.G(this.hQF.bLm())) {
                            ow(true);
                            oC(true);
                            return;
                        }
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.hSU)) {
                        bOk().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hSU)) {
                        bOj().requestFocus();
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
    public void bOo() {
        if ("1".equals(this.hyr)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.hyr)) {
            this.mData.setCanNoForum(false);
        }
        bOp();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.hyr);
        bNq();
    }

    private void bOp() {
        if (this.bpX != null) {
            this.bpX.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bOk());
        HidenSoftKeyPad(this.mInputManager, bOj());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.xo(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dxB) != null) {
                    TiebaStatic.log(new ak("c12534").s("obj_locate", ap.a.aVW));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.j.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hTc == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                s(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.brG = i;
        if (this.bpX != null) {
            this.bpX.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bOq() {
        if (!this.hTo && this.bpX != null) {
            this.bpX.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.bpX.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(boolean z) {
        if (this.bpX != null) {
            this.bpX.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void zf(int i) {
        if (i < this.hRQ.size()) {
            for (int i2 = 0; i2 < this.hRQ.size(); i2++) {
                this.hRQ.get(i2).oq(false);
            }
            this.hRQ.get(i).oq(true);
        }
    }

    @Override // com.baidu.tieba.write.e.a
    public void wL(int i) {
        this.gYw = i;
        this.gYR.setCurrentIndex(i);
        zf(i);
        this.gYQ.setText(this.mPrefixData.getPrefixs().get(i));
        bya();
        com.baidu.adp.lib.g.g.a(this.gYR, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gYT.setSelected(false);
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

    @Override // android.app.Activity, com.baidu.b.a.a.InterfaceC0036a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            Lg();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hTx != null && !z) {
            this.hTx.bdC();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hSV = false;
            this.hSU = "";
            if ("from_content".equals(str)) {
                this.hSU = "from_content";
            } else if ("from_title".equals(str)) {
                this.hSU = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                oD(false);
            }
        }
    }

    public void IR() {
        if (!v.G(this.mList)) {
            this.hSY.setVisibility(0);
            this.hSY.requestFocus();
            this.bpX.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hSY.setVisibility(8);
    }
}
