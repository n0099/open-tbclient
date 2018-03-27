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
import com.baidu.d.a.a;
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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.coreExtra.data.t;
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
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0056a, e.a {
    private com.baidu.tbadk.editortools.i bss;
    private LocationModel btW;
    private NewWriteModel btX;
    private OriginalThreadCardView fyT;
    private TextView gQN;
    private com.baidu.tieba.write.e gQO;
    private ImageView gQP;
    private View gQQ;
    private int gQq;
    private com.baidu.tieba.write.b hIo;
    private LinearLayout hKH;
    private LinearLayout hKI;
    private View hKK;
    private Toast hKL;
    private AdditionData hKM;
    private RelativeLayout hKN;
    private TextView hKO;
    private TextView hKP;
    private TextView hKQ;
    List<z> hKR;
    z hKS;
    private int hKT;
    private String hKU;
    private int hKV;
    private PostCategoryView hKW;
    private HotTopicBussinessData hKZ;
    private View hLa;
    private View hLb;
    private TextView hLc;
    private TextView hLd;
    private com.baidu.tieba.write.editor.d hLh;
    private com.baidu.tieba.write.b hLi;
    private com.baidu.tieba.view.d hLp;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String hKE = "";
    private boolean hKF = false;
    private WriteData mData = null;
    private boolean hKG = false;
    private InputMethodManager mInputManager = null;
    private EditText gQI = null;
    private View gQJ = null;
    private LinearLayout gQL = null;
    private EditText gQM = null;
    private FeedBackModel hKJ = null;
    private ArrayList<com.baidu.tieba.write.d> hJA = new ArrayList<>();
    private final KeyEvent drs = new KeyEvent(0, 67);
    private View bgB = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String bub = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int buc = 0;
    private View mRootView = null;
    private ScrollView hKX = null;
    private boolean hKY = false;
    private com.baidu.tbadk.core.view.b bCC = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String hpO = "2";
    private String hLe = "";
    private int hLf = 0;
    private SpannableStringBuilder hLg = new SpannableStringBuilder();
    private TbFaceManager.a hLj = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan gL(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.a.a.class);
            com.baidu.adp.widget.a.a aVar = runTask != null ? (com.baidu.adp.widget.a.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.sh());
            int width = aVar.getWidth();
            if (str.startsWith("#(meme,")) {
                bitmapDrawable.setBounds(0, 0, width, aVar.getHeight());
            } else {
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            return new com.baidu.tbadk.core.view.i(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a dFl = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXx));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXx));
        }
    };
    private final NewWriteModel.d bum = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.hIo.aw(null);
                TransmitPostEditActivity.this.hIo.nF(false);
                TransmitPostEditActivity.this.hLi.aw(null);
                TransmitPostEditActivity.this.hLi.nF(false);
                if (z) {
                    TransmitPostEditActivity.this.cn(z);
                    TransmitPostEditActivity.this.c(true, postWriteCallBackData);
                    if (TransmitPostEditActivity.this.mData.getType() == 4) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, "from_write", 18003)));
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
                    TransmitPostEditActivity.this.hIo.aw(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.hLi.aw(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.hIo.un(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.hLi.un(postWriteCallBackData.getErrorString());
                    if (!v.E(TransmitPostEditActivity.this.hIo.bFG())) {
                        TransmitPostEditActivity.this.nO(true);
                        TransmitPostEditActivity.this.nU(true);
                    }
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.FY());
                    if (com.baidu.tbadk.p.a.hx(tVar.FX())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.FX())));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a buk = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void LR() {
            TransmitPostEditActivity.this.showToast(d.j.no_network_guide);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void gA(String str) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            if (StringUtils.isNull(str)) {
                str = TransmitPostEditActivity.this.getPageContext().getString(d.j.location_fail);
            }
            transmitPostEditActivity.showToast(str);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bxA())) {
                TransmitPostEditActivity.this.b(2, true, aVar.bxA());
            } else {
                gA(null);
            }
        }
    };
    private final CustomMessageListener hdm = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.btW.mR(false);
                    TransmitPostEditActivity.this.btW.cg(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.btW.mR(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hLk = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hLl = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.bss.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bIo = TransmitPostEditActivity.this.bIo();
            if (bIo >= 0 && bIo < TransmitPostEditActivity.this.gQM.getText().length()) {
                TransmitPostEditActivity.this.gQM.setSelection(bIo);
            }
        }
    };
    private boolean hLm = true;
    private final View.OnFocusChangeListener gQG = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.gQI || view == TransmitPostEditActivity.this.bgB || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.hLm = true;
                    TransmitPostEditActivity.this.bIp();
                    if (TransmitPostEditActivity.this.bss != null) {
                        TransmitPostEditActivity.this.bss.Jm();
                    }
                    l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gQI);
                } else if (view == TransmitPostEditActivity.this.gQI) {
                    TransmitPostEditActivity.this.gQN.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.gQM && z) {
                TransmitPostEditActivity.this.hLm = false;
                TransmitPostEditActivity.this.bIp();
                TransmitPostEditActivity.this.bss.Jm();
                l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gQM);
            }
            TransmitPostEditActivity.this.bIs();
        }
    };
    private TextWatcher hLn = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bsJ();
            if (TransmitPostEditActivity.this.hLi != null) {
                if (!TransmitPostEditActivity.this.hLi.bFJ()) {
                    TransmitPostEditActivity.this.nU(false);
                }
                TransmitPostEditActivity.this.hLi.nG(false);
                TransmitPostEditActivity.this.bIt();
            }
        }
    };
    private TextWatcher hLo = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bsJ();
            if (TransmitPostEditActivity.this.hIo != null) {
                if (!TransmitPostEditActivity.this.hIo.bFJ()) {
                    TransmitPostEditActivity.this.nO(false);
                }
                TransmitPostEditActivity.this.hIo.nG(false);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nU(boolean z) {
        if (bIE() != null && bIE().getVisibility() == 0 && bIE().getText() != null) {
            int selectionEnd = bIE().getSelectionEnd();
            SpannableStringBuilder b = this.hLi.b(bIE().getText());
            if (b != null) {
                this.hLi.nG(true);
                bIE().setText(b);
                if (z && this.hLi.bFH() >= 0) {
                    bIE().requestFocus();
                    bIE().setSelection(this.hLi.bFH());
                } else {
                    bIE().setSelection(selectionEnd);
                }
                this.hLi.nF(this.hLi.bFH() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nO(boolean z) {
        if (bID() != null && bID().getText() != null) {
            int selectionEnd = bID().getSelectionEnd();
            SpannableStringBuilder b = this.hIo.b(bID().getText());
            if (b != null) {
                this.hIo.nG(true);
                bID().setText(b);
                if (z && this.hIo.bFH() >= 0) {
                    bID().requestFocus();
                    bID().setSelection(this.hIo.bFH());
                } else {
                    bID().setSelection(selectionEnd);
                }
                this.hIo.nF(this.hIo.bFH() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LD() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void LE() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            LF();
        } else if (this.btW.bxI()) {
            LD();
        } else {
            this.btW.mR(false);
            b(1, true, null);
            this.btW.bxG();
        }
    }

    private void LF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.fb(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.oJ()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.btW.ahm();
                } else {
                    TransmitPostEditActivity.this.buk.LR();
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
        aVar.AV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bIo() {
        int selectionEnd = bID().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bID().getText().getSpans(0, bID().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bID().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bID().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIp() {
        if (this.bss != null) {
            this.bss.setBarLauncherEnabled(!this.hLm);
            this.bss.g(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hKY) {
            this.gQI.setVisibility(8);
            bsJ();
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
        this.hLi = new com.baidu.tieba.write.b();
        this.hLi.xg(d.C0141d.cp_cont_i);
        this.hLi.xh(d.C0141d.cp_cont_h_alpha85);
        this.hIo = new com.baidu.tieba.write.b();
        this.hIo.xg(d.C0141d.cp_cont_i);
        this.hIo.xh(d.C0141d.cp_cont_h_alpha85);
        initUI();
        this.btW = new LocationModel(this);
        this.btW.a(this.buk);
        registerListener(this.hdm);
        registerListener(this.hLk);
        initEditor();
        this.gQM.requestFocus();
        Jo();
        bIL();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.bss = new com.baidu.tbadk.editortools.i(getActivity());
        this.bss.setBarMaxLauCount(4);
        this.bss.setMoreButtonAtEnd(true);
        this.bss.setBarLauncherType(1);
        this.bss.cf(true);
        this.bss.cg(true);
        this.bss.setMoreLauncherIcon(d.f.write_more);
        this.bss.setBackgroundColorId(d.C0141d.cp_bg_line_d);
        bIq();
        this.bss.Ld();
        if (this.hKH != null) {
            this.hKH.addView(this.bss);
        }
        bIr();
        this.bss.th();
        com.baidu.tbadk.editortools.l hG = this.bss.hG(6);
        if (hG != null && !TextUtils.isEmpty(this.bub)) {
            ((View) hG).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.bub);
                }
            });
        }
        if (!this.hKY) {
            this.bss.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.bss.Jm();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.bss.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.bss.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void bIq() {
        r rVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 2);
        aVar.bsZ = d.f.write_at;
        this.bss.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.bss.b(aVar2);
        aVar2.bsZ = d.f.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), r.class);
        if (runTask != null && (rVar = (r) runTask.getData()) != null) {
            rVar.btb = 4;
            rVar.bsZ = d.f.icon_post_location_selector;
            this.bss.b(rVar);
        }
        if (this.hKM == null) {
            if (this.hLh == null) {
                this.hLh = new com.baidu.tieba.write.editor.d(getActivity(), this.hpO);
                this.hLh.bGP();
                this.hLh.setFrom("from_share_write");
                this.hLh.aO(this.mData.getForumId(), this.mPrivateThread);
            }
            this.bss.b(this.hLh);
        }
        this.bss.K(arrayList);
        r hI = this.bss.hI(5);
        if (hI != null) {
            hI.btb = 1;
            hI.bsZ = d.f.write_emotion;
        }
    }

    private void bIr() {
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
                        if (TransmitPostEditActivity.this.bIC()) {
                            TransmitPostEditActivity.this.showToast(d.j.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.bIC()) {
                            TransmitPostEditActivity.this.showToast(d.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            TransmitPostEditActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.bIF();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.bsJ();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.hKM == null) {
                            TransmitPostEditActivity.this.LG();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.buc) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.aS(pageActivity)) {
                                    TransmitPostEditActivity.this.LE();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.LD();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.btW != null) {
                            TransmitPostEditActivity.this.btW.mR(true);
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
                            TransmitPostEditActivity.this.bss.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.bss.Lf()) {
                                        TransmitPostEditActivity.this.bss.Jm();
                                        TransmitPostEditActivity.this.bss.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.bss.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.bss.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.bss.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.bss.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.bsJ();
                        if (TransmitPostEditActivity.this.gQM != null) {
                            TransmitPostEditActivity.this.gQM.requestFocus();
                        }
                        TransmitPostEditActivity.this.bss.Jm();
                        TransmitPostEditActivity.this.bss.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gQM);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.bss.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.hKF = true;
                        TransmitPostEditActivity.this.nV(true);
                        if (TransmitPostEditActivity.this.bIE().isFocused()) {
                            TransmitPostEditActivity.this.hKE = "from_title";
                        } else if (TransmitPostEditActivity.this.bID().isFocused()) {
                            TransmitPostEditActivity.this.hKE = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.hKI.setVisibility(0);
                        TransmitPostEditActivity.this.hKI.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.hKI.hasFocus()) {
                            TransmitPostEditActivity.this.gQM.requestFocus();
                            TransmitPostEditActivity.this.gQM.setSelection(TransmitPostEditActivity.this.gQM.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.hKI.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.bss.a(31, bVar);
        this.bss.a(16, bVar);
        this.bss.a(14, bVar);
        this.bss.a(24, bVar);
        this.bss.a(3, bVar);
        this.bss.a(10, bVar);
        this.bss.a(11, bVar);
        this.bss.a(12, bVar);
        this.bss.a(13, bVar);
        this.bss.a(15, bVar);
        this.bss.a(18, bVar);
        this.bss.a(20, bVar);
        this.bss.a(25, bVar);
        this.bss.a(27, bVar);
        this.bss.a(29, bVar);
        this.bss.a(43, bVar);
        this.bss.a(45, bVar);
        this.bss.a(53, bVar);
        this.bss.a(48, bVar);
        this.bss.a(46, bVar);
        this.bss.a(49, bVar);
        this.bss.a(47, bVar);
        this.bss.a(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LG() {
        if (this.btW.ahi()) {
            if (this.btW.bxI()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bxE().getLocationData().bxA());
                return;
            }
            b(1, true, null);
            this.btW.bxG();
            return;
        }
        b(0, true, null);
    }

    protected void bsB() {
        if (this.btX != null) {
            this.btX.cancelLoadData();
        }
        if (this.hKJ != null) {
            this.hKJ.cancelLoadData();
        }
        if (this.btW != null) {
            this.btW.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bsB();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHJ() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(bIE().getText().toString());
        this.mData.setContent(bID().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.gQO != null && this.gQO.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gQO, getPageContext().getPageActivity());
                return true;
            } else if (this.bss.Lf()) {
                this.bss.Jm();
                return true;
            } else {
                bsB();
                bHJ();
                return true;
            }
        }
        if (i == 67 && (text = bID().getText()) != null) {
            int selectionStart = bID().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bID().onKeyDown(67, this.drs);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.e(this.mPost, d.C0141d.cp_link_tip_a, 1);
        bIp();
        aj.t(this.gQJ, d.C0141d.cp_bg_line_c);
        aj.t(bIE(), d.C0141d.cp_bg_line_d);
        aj.t(bID(), d.C0141d.cp_bg_line_d);
        bsJ();
        this.bss.onChangeSkinType(i);
        if (this.hKW != null) {
            this.hKW.En();
        }
        aj.r(this.mName, d.C0141d.cp_cont_b);
        bIs();
        bIt();
        if (this.hIo != null) {
            this.hIo.onChangeSkinType();
        }
        if (this.hLi != null) {
            this.hLi.onChangeSkinType();
        }
        this.fyT.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIs() {
        if (this.gQI.hasFocus()) {
            this.gQI.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
        } else {
            this.gQI.setHintTextColor(aj.getColor(d.C0141d.cp_cont_d));
        }
        if (this.gQM.hasFocus()) {
            this.gQM.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
        } else {
            this.gQM.setHintTextColor(aj.getColor(d.C0141d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIt() {
        if (this.gQI != null) {
            if (this.gQI.getText().toString().length() == 0) {
                this.gQI.getPaint().setFakeBoldText(false);
            } else if (this.gQI.getText().toString().length() > 0) {
                this.gQI.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.bCC = new com.baidu.tbadk.core.view.b(getPageContext());
        this.hKY = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.bgB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        aj.r(this.mName, d.C0141d.cp_cont_b);
        bIv();
        this.hKX = (ScrollView) findViewById(d.g.write_scrollview);
        this.hKX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.gQM != null) {
                        l.a(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.gQM);
                    }
                    if (TransmitPostEditActivity.this.bss != null) {
                        TransmitPostEditActivity.this.bss.Jm();
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
        this.hKH = (LinearLayout) findViewById(d.g.tool_view);
        this.hKH.setContentDescription("..");
        this.hKI = (LinearLayout) findViewById(d.g.title_view);
        this.gQJ = findViewById(d.g.interval_view);
        this.hLa = findViewById(d.g.hot_topic_fourm_view);
        this.hLb = findViewById(d.g.hot_topic_divider);
        this.hLc = (TextView) findViewById(d.g.hot_topic_title_edt);
        this.hLd = (TextView) findViewById(d.g.change_one_tv);
        bsI();
        if (this.hKY) {
            this.hKX.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        bsK();
        bIB();
        this.gQL = (LinearLayout) findViewById(d.g.post_content_container);
        this.gQL.setDrawingCacheEnabled(false);
        this.gQL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.gQM.requestFocus();
                TransmitPostEditActivity.this.bss.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            }
        });
        this.bgB.setOnFocusChangeListener(this.gQG);
        this.bgB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.bsB();
                TransmitPostEditActivity.this.bHJ();
            }
        });
        bIy();
        bIA();
        bIu();
        bIp();
        bIz();
        bsH();
        bIG();
        if (this.mData.getType() == 4 && this.gQQ != null && this.hKK != null) {
            this.gQQ.setVisibility(8);
            this.hKK.setVisibility(8);
        }
        bsJ();
        ShowSoftKeyPad(this.mInputManager, this.gQI);
    }

    private void bIu() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hpO != null && this.hpO.equals("1")) {
                        this.mName.setText(d.j.share_to_home_page);
                    } else if (this.hpO != null && this.hpO.equals("2")) {
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
                    this.gQI.setVisibility(0);
                    this.gQM.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(d.j.publish_photo_live);
                    this.gQM.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(d.j.send_reply);
                    this.gQM.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gQI.setVisibility(8);
                    return;
            }
        }
    }

    private void bIv() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.t(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.gQG);
    }

    private void bIw() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hKG && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = am.d(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(d) && bIE() != null) {
                bIE().setText(d);
                bIE().setSelection(d.length());
            }
        }
    }

    private void bIx() {
        this.hKR = null;
        this.hKT = -1;
        this.hKV = -1;
        com.baidu.tieba.frs.ab mX = aa.awm().mX(1);
        if (mX != null) {
            this.hKR = mX.dHk;
            this.hKT = getIntent().getIntExtra("category_id", -1);
            if (this.hKR != null && !this.hKR.isEmpty() && this.hKT >= 0) {
                this.hKS = new z();
                this.hKS.dHg = 0;
                this.hKS.name = getPageContext().getResources().getString(d.j.category_auto);
                this.hKV = this.hKS.dHg;
                this.hKU = this.hKS.name;
                for (z zVar : this.hKR) {
                    if (zVar.dHg == this.hKT) {
                        this.hKV = zVar.dHg;
                        this.hKU = zVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bIy() {
        if (this.hKR != null && !this.hKR.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.hKW = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.hKW.setText(this.hKU);
            this.hKW.b(this.hKR, this.hKS, this.hKV);
            this.hKW.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, av avVar) {
                    if (avVar != null) {
                        TransmitPostEditActivity.this.hKW.setText(avVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(avVar.dHg);
                        TransmitPostEditActivity.this.hKV = avVar.dHg;
                        TransmitPostEditActivity.this.hKW.bHB();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.hKW.bHA();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIE());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bID());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hLp = new com.baidu.tieba.view.d(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hLp.setTitle(d.j.no_disturb_start_time);
        this.hLp.setButton(-1, getPageContext().getString(d.j.alert_yes_button), this.hLp);
        this.hLp.setButton(-2, getPageContext().getString(d.j.cancel), this.hLp);
        return this.hLp;
    }

    private void bIz() {
        this.hKN = (RelativeLayout) findViewById(d.g.addition_container);
        this.hKO = (TextView) findViewById(d.g.addition_create_time);
        this.hKP = (TextView) findViewById(d.g.addition_last_time);
        this.hKQ = (TextView) findViewById(d.g.addition_last_content);
        if (this.hKM != null) {
            this.hKN.setVisibility(0);
            this.hKO.setText(getPageContext().getString(d.j.write_addition_create) + am.z(this.hKM.getCreateTime() * 1000));
            if (this.hKM.getAlreadyCount() == 0) {
                this.hKP.setVisibility(8);
            } else {
                this.hKP.setText(getPageContext().getString(d.j.write_addition_last) + am.z(this.hKM.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hKM.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hKQ.setText(lastAdditionContent);
            } else {
                this.hKQ.setVisibility(8);
            }
            bID().setHint(String.format(getPageContext().getString(d.j.write_addition_hint), Integer.valueOf(this.hKM.getAlreadyCount()), Integer.valueOf(this.hKM.getTotalCount())));
            this.mName.setText(d.j.write_addition_title);
            return;
        }
        this.hKN.setVisibility(8);
    }

    private void bsH() {
        this.gQQ = findViewById(d.g.post_prefix_layout);
        this.gQN = (TextView) findViewById(d.g.post_prefix);
        this.hKK = findViewById(d.g.prefix_divider);
        this.gQP = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gQQ.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gQq = 1;
            this.gQQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.gQN.setVisibility(0);
                    TransmitPostEditActivity.this.gQQ.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gQO, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.bss.Jm();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gQI);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gQM);
                }
            });
            this.gQP = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gQP.setVisibility(0);
                this.gQN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.gQN.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gQO, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.bss.Jm();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIE());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bID());
                    }
                });
            }
            this.gQO = new com.baidu.tieba.write.e(getPageContext().getPageActivity());
            this.gQO.a(this);
            this.gQO.setMaxHeight(l.t(getActivity(), d.e.ds510));
            this.gQO.setOutsideTouchable(true);
            this.gQO.setFocusable(true);
            this.gQO.setOnDismissListener(this);
            this.gQO.setBackgroundDrawable(aj.getDrawable(d.C0141d.cp_bg_line_d));
            int color = aj.getColor(d.C0141d.cp_cont_b);
            int color2 = aj.getColor(d.C0141d.cp_cont_c);
            aj.s(this.gQN, d.C0141d.cp_bg_line_d);
            aj.c(this.gQP, d.f.icon_frs_arrow_n);
            this.gQN.setTextColor(color);
            this.hJA.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.d dVar = new com.baidu.tieba.write.d(getActivity());
                this.hJA.add(dVar);
                dVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    dVar.setPrefixTextColor(color2);
                } else {
                    dVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    dVar.setDividerStyle(false);
                }
                this.gQO.addView(dVar);
            }
            this.gQO.setCurrentIndex(0);
            this.gQN.setText(prefixs.get(1));
            xI(1);
            return;
        }
        this.gQQ.setVisibility(8);
    }

    protected void bIA() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    TransmitPostEditActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.hLi.bFI()) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.hLi.bFK());
                        TransmitPostEditActivity.this.nU(true);
                    } else if (TransmitPostEditActivity.this.hIo.bFI()) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.hIo.bFK());
                        TransmitPostEditActivity.this.nO(true);
                    } else {
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIE());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bID());
                        TransmitPostEditActivity.this.bss.Jm();
                        TiebaStatic.log(new ak("c12608").s("obj_locate", 7));
                        TransmitPostEditActivity.this.bIJ();
                    }
                }
            }
        });
    }

    protected void bsI() {
        this.gQI = (EditText) findViewById(d.g.post_title);
        this.gQI.setOnClickListener(this.hLl);
        this.gQI.setOnFocusChangeListener(this.gQG);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.gQI.setText(this.mData.getTitle());
            this.gQI.setSelection(this.mData.getTitle().length());
        }
        this.gQI.addTextChangedListener(this.hLn);
        if (!this.mData.getHaveDraft()) {
            bIw();
        }
        this.gQI.setHint(getResources().getString(d.j.post_title_hint));
    }

    protected void bsK() {
        this.gQM = (EditText) findViewById(d.g.post_content);
        this.gQM.setDrawingCacheEnabled(false);
        this.gQM.setOnClickListener(this.hLl);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString W = TbFaceManager.Mw().W(getPageContext().getPageActivity(), this.mData.getContent());
            this.gQM.setText(W);
            this.gQM.setSelection(W.length());
        }
        this.gQM.setOnFocusChangeListener(this.gQG);
        this.gQM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.bss.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.gQM.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gQM.addTextChangedListener(this.hLo);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.gQM.setHint(d.j.share_video_default);
        } else {
            this.gQM.setHint(d.j.share_txt_default);
        }
    }

    private void bIB() {
        this.fyT = (OriginalThreadCardView) findViewById(d.g.write_original_thread_cardview);
        this.fyT.setVisibility(0);
        this.fyT.b(this.mOriginalThreadInfo);
        this.fyT.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIC() {
        int i = 5000;
        if (this.hKM != null) {
            i = 1000;
        }
        return bID().getText() != null && bID().getText().length() >= i;
    }

    private void gq(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hKE)) {
                this.hKE = "";
                bID().requestFocus();
                if (bID().getText() != null && bID().getText().length() + str.length() > 5000) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bID().getSelectionStart();
                    editable = bID().getText();
                }
            } else if ("from_title".equals(this.hKE)) {
                this.hKE = "";
                bIE().requestFocus();
                if (bIE().getText() != null && bIE().getText().length() + str.length() > 31) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bIE().getSelectionStart();
                    editable = bIE().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nV(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    protected void d(n nVar) {
        if (((ImageSpan[]) bID().getText().getSpans(0, bID().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hKL == null) {
                this.hKL = Toast.makeText(getPageContext().getPageActivity(), d.j.too_many_face, 0);
            }
            this.hKL.show();
            return;
        }
        String name = nVar.getName();
        final EmotionGroupType FP = nVar.FP();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.nm().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.bID().getSelectionStart(), aVar, FP);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bID() != null && bID().getText() != null) {
            Bitmap sh = aVar.sh();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(sh);
            int width = sh.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, sh.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.i(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bID().getSelectionStart() - 1;
                if (bID().getText().length() > 1 && selectionStart >= 0 && bID().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bID().getText().insert(bID().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bID().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bID().getText().insert(bID().getSelectionStart(), spannableString2);
            }
            Editable text = bID().getText();
            if (text != null) {
                this.hLg.clear();
                this.hLg.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hLg);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bID().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bID().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bID().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bID() {
        return this.gQM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bIE() {
        return this.gQI;
    }

    protected void bIF() {
        Editable text;
        if (bID() != null && (text = bID().getText()) != null) {
            int selectionStart = bID().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bID().onKeyDown(67, this.drs);
            }
            bID().onKeyDown(67, this.drs);
            int selectionStart2 = bID().getSelectionStart();
            this.hLg.clear();
            this.hLg.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.hLg);
            bID().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.bCC.d(null);
        this.bCC.ga(d.j.sending);
        this.bCC.bq(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.bCC.bq(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsJ() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bIE() != null) {
                str = bIE().getText().toString();
            }
            if (bID() != null) {
                str2 = bID().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.gQq == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            nW(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        nW(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    nW(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hKY) {
                    nW(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    nW(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                nW(true);
            } else if (this.mData.getVideoInfo() != null) {
                nW(true);
            } else {
                nW(false);
            }
        }
    }

    private void nW(boolean z) {
        aj.d(this.mPost, d.C0141d.cp_link_tip_a, d.C0141d.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.btX = new NewWriteModel(this);
        this.btX.b(this.bum);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.bsB();
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
                this.hKM = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hKM != null);
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
            this.hpO = bundle.getString("KEY_CALL_FROM");
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
            this.hKM = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hKM != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hpO = intent.getStringExtra("KEY_CALL_FROM");
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
            this.hKG = true;
        }
        bIx();
    }

    private void bIG() {
        if (v.D(this.mList) > 0 && this.mList.get(0) != null) {
            this.hLa.setVisibility(0);
            this.hLb.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.gQI.setText(com.baidu.tbadk.plugins.a.hd(uJ(this.mList.get(0).mTopicName)));
                this.gQI.setMovementMethod(com.baidu.tieba.view.e.bEQ());
            }
            this.hLc.setText(this.mList.get(0).mForumName);
            this.gQI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!TransmitPostEditActivity.this.hLe.equals(charSequence.toString())) {
                        TransmitPostEditActivity.this.hLf = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString hd;
                    if (!TransmitPostEditActivity.this.hLe.equals(editable.toString()) && (hd = com.baidu.tbadk.plugins.a.hd(editable.toString())) != null) {
                        TransmitPostEditActivity.this.hLe = hd.toString();
                        TransmitPostEditActivity.this.gQI.setText(hd);
                        if (TransmitPostEditActivity.this.hLf <= TransmitPostEditActivity.this.gQI.getText().length()) {
                            TransmitPostEditActivity.this.gQI.setSelection(TransmitPostEditActivity.this.hLf);
                        }
                    }
                }
            });
            this.hLd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotTopicChangeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 25005, TransmitPostEditActivity.this.mList)));
                }
            });
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString hd = com.baidu.tbadk.plugins.a.hd(uJ(hotTopicBussinessData.mTopicName));
            if (hd != null) {
                this.gQI.setText(hd);
            }
            this.hLc.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String uJ(String str) {
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
        if (this.hKM != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hKM));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.hpO);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bID().getEditableText().toString();
        if (obj != null) {
            bID().setText(TbFaceManager.Mw().a(getPageContext().getPageActivity(), obj, this.hLj));
            bID().setSelection(bID().getText().length());
        }
    }

    private String bIH() {
        if (bID() == null || bID().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(bID().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(d.j.share_video_default);
            }
            return getString(d.j.share_txt_default);
        }
        return bID().getText().toString();
    }

    private String bII() {
        if (this.mData == null || bIE() == null || bIE().getVisibility() != 0 || bIE().getText() == null) {
            return "";
        }
        String obj = bIE().getText().toString();
        if (this.mPrefixData != null && v.D(this.mPrefixData.getPrefixs()) > 0 && this.gQq != 0 && this.mData.getType() != 4 && this.gQN != null && this.gQN.getText() != null) {
            obj = this.gQN.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void bHK() {
        bsB();
        this.mData.setContent(bIH());
        this.mData.setTitle(bII());
        if (this.hKT >= 0) {
            this.mData.setCategoryFrom(this.hKT);
        }
        if (this.hKV >= 0) {
            this.mData.setCategoryTo(this.hKV);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.btW != null && this.btW.ahi());
        this.btX.mT(this.writeImagesInfo.size() > 0);
        if (!v.E(this.mList) && this.hKZ != null && this.hKZ.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hKZ.mForumId));
            this.mData.setForumName(this.hKZ.mForumName);
        }
        this.btX.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.btX.getWriteData().setVoice(null);
        this.btX.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.oJ()) {
            showToast(d.j.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
        this.btX.startPostWrite();
    }

    private void o(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.hKM != null) {
                i2 = this.hKM.getTotalCount();
                i = this.hKM.getAlreadyCount() + 1;
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
                if (this.bss != null && !this.bss.Lf()) {
                    bID().requestFocus();
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
                            bID().getText().insert(bID().getSelectionStart(), sb.toString());
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
                        if (this.hKF) {
                            sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                            this.hKF = false;
                        }
                        sb2.append(stringExtra);
                        gq(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !v.E(this.mList) && !v.E(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.hKZ = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.hKZ);
            }
        } else if (i2 == 0) {
            if (this.bss != null && !this.bss.Lf()) {
                this.gQM.requestFocus();
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
                        this.hIo.aw(postWriteCallBackData.getSensitiveWords());
                        this.hLi.aw(postWriteCallBackData.getSensitiveWords());
                        if (!v.E(this.hIo.bFG())) {
                            nO(true);
                            nU(true);
                            return;
                        }
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.hKE)) {
                        bIE().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hKE)) {
                        bID().requestFocus();
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
    public void bIJ() {
        if ("1".equals(this.hpO)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.hpO)) {
            this.mData.setCanNoForum(false);
        }
        bIK();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.hpO);
        bHK();
    }

    private void bIK() {
        if (this.bss != null) {
            this.bss.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bIE());
        HidenSoftKeyPad(this.mInputManager, bID());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.vR(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dFl) != null) {
                    TiebaStatic.log(new ak("c12534").s("obj_locate", aq.a.aXx));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.j.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hKM == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                o(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.buc = i;
        if (this.bss != null) {
            this.bss.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bIL() {
        if (!this.hKY && this.bss != null) {
            this.bss.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.bss.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(boolean z) {
        if (this.bss != null) {
            this.bss.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void xI(int i) {
        if (i < this.hJA.size()) {
            for (int i2 = 0; i2 < this.hJA.size(); i2++) {
                this.hJA.get(i2).nI(false);
            }
            this.hJA.get(i).nI(true);
        }
    }

    @Override // com.baidu.tieba.write.e.a
    public void vm(int i) {
        this.gQq = i;
        this.gQO.setCurrentIndex(i);
        xI(i);
        this.gQN.setText(this.mPrefixData.getPrefixs().get(i));
        bsJ();
        com.baidu.adp.lib.g.g.a(this.gQO, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gQQ.setSelected(false);
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

    @Override // android.app.Activity, com.baidu.d.a.a.InterfaceC0056a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            LE();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hLh != null && !z) {
            this.hLh.bfm();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hKF = false;
            this.hKE = "";
            if ("from_content".equals(str)) {
                this.hKE = "from_content";
            } else if ("from_title".equals(str)) {
                this.hKE = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                nV(false);
            }
        }
    }

    public void Jo() {
        if (!v.E(this.mList)) {
            this.hKI.setVisibility(0);
            this.hKI.requestFocus();
            this.bss.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hKI.setVisibility(8);
    }
}
