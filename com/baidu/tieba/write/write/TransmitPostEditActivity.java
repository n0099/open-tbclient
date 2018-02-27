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
    private com.baidu.tbadk.editortools.i bsp;
    private LocationModel btT;
    private NewWriteModel btU;
    private OriginalThreadCardView fyD;
    private View gQA;
    private int gQa;
    private TextView gQx;
    private com.baidu.tieba.write.e gQy;
    private ImageView gQz;
    private com.baidu.tieba.write.b hHQ;
    private HotTopicBussinessData hKB;
    private View hKC;
    private View hKD;
    private TextView hKE;
    private TextView hKF;
    private com.baidu.tieba.write.editor.d hKJ;
    private com.baidu.tieba.write.b hKK;
    private com.baidu.tieba.view.d hKR;
    private LinearLayout hKj;
    private LinearLayout hKk;
    private View hKm;
    private Toast hKn;
    private AdditionData hKo;
    private RelativeLayout hKp;
    private TextView hKq;
    private TextView hKr;
    private TextView hKs;
    List<z> hKt;
    z hKu;
    private int hKv;
    private String hKw;
    private int hKx;
    private PostCategoryView hKy;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String hKg = "";
    private boolean hKh = false;
    private WriteData mData = null;
    private boolean hKi = false;
    private InputMethodManager mInputManager = null;
    private EditText gQs = null;
    private View gQt = null;
    private LinearLayout gQv = null;
    private EditText gQw = null;
    private FeedBackModel hKl = null;
    private ArrayList<com.baidu.tieba.write.d> hJc = new ArrayList<>();
    private final KeyEvent drp = new KeyEvent(0, 67);
    private View bgy = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String btY = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int btZ = 0;
    private View mRootView = null;
    private ScrollView hKz = null;
    private boolean hKA = false;
    private com.baidu.tbadk.core.view.b bCz = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String hpq = "2";
    private String hKG = "";
    private int hKH = 0;
    private SpannableStringBuilder hKI = new SpannableStringBuilder();
    private TbFaceManager.a hKL = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
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
    private final AntiHelper.a dFi = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXv));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXv));
        }
    };
    private final NewWriteModel.d buj = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.hHQ.aw(null);
                TransmitPostEditActivity.this.hHQ.nA(false);
                TransmitPostEditActivity.this.hKK.aw(null);
                TransmitPostEditActivity.this.hKK.nA(false);
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
                    TransmitPostEditActivity.this.hHQ.aw(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.hKK.aw(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.hHQ.un(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.hKK.un(postWriteCallBackData.getErrorString());
                    if (!v.E(TransmitPostEditActivity.this.hHQ.bFB())) {
                        TransmitPostEditActivity.this.nJ(true);
                        TransmitPostEditActivity.this.nP(true);
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
                    writeData.setVcodeExtra(tVar.FX());
                    if (com.baidu.tbadk.p.a.hx(tVar.FW())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.FW())));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a buh = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void LQ() {
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
            if (aVar != null && !StringUtils.isNull(aVar.bxv())) {
                TransmitPostEditActivity.this.b(2, true, aVar.bxv());
            } else {
                gA(null);
            }
        }
    };
    private final CustomMessageListener hcO = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.btT.mM(false);
                    TransmitPostEditActivity.this.btT.cg(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.btT.mM(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hKM = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hKN = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.bsp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bIj = TransmitPostEditActivity.this.bIj();
            if (bIj >= 0 && bIj < TransmitPostEditActivity.this.gQw.getText().length()) {
                TransmitPostEditActivity.this.gQw.setSelection(bIj);
            }
        }
    };
    private boolean hKO = true;
    private final View.OnFocusChangeListener gQq = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.gQs || view == TransmitPostEditActivity.this.bgy || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.hKO = true;
                    TransmitPostEditActivity.this.bIk();
                    if (TransmitPostEditActivity.this.bsp != null) {
                        TransmitPostEditActivity.this.bsp.Jl();
                    }
                    l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gQs);
                } else if (view == TransmitPostEditActivity.this.gQs) {
                    TransmitPostEditActivity.this.gQx.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.gQw && z) {
                TransmitPostEditActivity.this.hKO = false;
                TransmitPostEditActivity.this.bIk();
                TransmitPostEditActivity.this.bsp.Jl();
                l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gQw);
            }
            TransmitPostEditActivity.this.bIn();
        }
    };
    private TextWatcher hKP = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bsI();
            if (TransmitPostEditActivity.this.hKK != null) {
                if (!TransmitPostEditActivity.this.hKK.bFE()) {
                    TransmitPostEditActivity.this.nP(false);
                }
                TransmitPostEditActivity.this.hKK.nB(false);
                TransmitPostEditActivity.this.bIo();
            }
        }
    };
    private TextWatcher hKQ = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bsI();
            if (TransmitPostEditActivity.this.hHQ != null) {
                if (!TransmitPostEditActivity.this.hHQ.bFE()) {
                    TransmitPostEditActivity.this.nJ(false);
                }
                TransmitPostEditActivity.this.hHQ.nB(false);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nP(boolean z) {
        if (bIz() != null && bIz().getVisibility() == 0 && bIz().getText() != null) {
            int selectionEnd = bIz().getSelectionEnd();
            SpannableStringBuilder b = this.hKK.b(bIz().getText());
            if (b != null) {
                this.hKK.nB(true);
                bIz().setText(b);
                if (z && this.hKK.bFC() >= 0) {
                    bIz().requestFocus();
                    bIz().setSelection(this.hKK.bFC());
                } else {
                    bIz().setSelection(selectionEnd);
                }
                this.hKK.nA(this.hKK.bFC() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nJ(boolean z) {
        if (bIy() != null && bIy().getText() != null) {
            int selectionEnd = bIy().getSelectionEnd();
            SpannableStringBuilder b = this.hHQ.b(bIy().getText());
            if (b != null) {
                this.hHQ.nB(true);
                bIy().setText(b);
                if (z && this.hHQ.bFC() >= 0) {
                    bIy().requestFocus();
                    bIy().setSelection(this.hHQ.bFC());
                } else {
                    bIy().setSelection(selectionEnd);
                }
                this.hHQ.nA(this.hHQ.bFC() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LC() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void LD() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            LE();
        } else if (this.btT.bxD()) {
            LC();
        } else {
            this.btT.mM(false);
            b(1, true, null);
            this.btT.bxB();
        }
    }

    private void LE() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.fb(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.oJ()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.btT.ahl();
                } else {
                    TransmitPostEditActivity.this.buh.LQ();
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
        aVar.AU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bIj() {
        int selectionEnd = bIy().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bIy().getText().getSpans(0, bIy().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bIy().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bIy().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIk() {
        if (this.bsp != null) {
            this.bsp.setBarLauncherEnabled(!this.hKO);
            this.bsp.g(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hKA) {
            this.gQs.setVisibility(8);
            bsI();
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
        this.hKK = new com.baidu.tieba.write.b();
        this.hKK.xg(d.C0141d.cp_cont_i);
        this.hKK.xh(d.C0141d.cp_cont_h_alpha85);
        this.hHQ = new com.baidu.tieba.write.b();
        this.hHQ.xg(d.C0141d.cp_cont_i);
        this.hHQ.xh(d.C0141d.cp_cont_h_alpha85);
        initUI();
        this.btT = new LocationModel(this);
        this.btT.a(this.buh);
        registerListener(this.hcO);
        registerListener(this.hKM);
        initEditor();
        this.gQw.requestFocus();
        Jn();
        bIG();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.bsp = new com.baidu.tbadk.editortools.i(getActivity());
        this.bsp.setBarMaxLauCount(4);
        this.bsp.setMoreButtonAtEnd(true);
        this.bsp.setBarLauncherType(1);
        this.bsp.cf(true);
        this.bsp.cg(true);
        this.bsp.setMoreLauncherIcon(d.f.write_more);
        this.bsp.setBackgroundColorId(d.C0141d.cp_bg_line_d);
        bIl();
        this.bsp.Lc();
        if (this.hKj != null) {
            this.hKj.addView(this.bsp);
        }
        bIm();
        this.bsp.th();
        com.baidu.tbadk.editortools.l hG = this.bsp.hG(6);
        if (hG != null && !TextUtils.isEmpty(this.btY)) {
            ((View) hG).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.btY);
                }
            });
        }
        if (!this.hKA) {
            this.bsp.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.bsp.Jl();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.bsp.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.bsp.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void bIl() {
        r rVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 2);
        aVar.bsW = d.f.write_at;
        this.bsp.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.bsp.b(aVar2);
        aVar2.bsW = d.f.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), r.class);
        if (runTask != null && (rVar = (r) runTask.getData()) != null) {
            rVar.bsY = 4;
            rVar.bsW = d.f.icon_post_location_selector;
            this.bsp.b(rVar);
        }
        if (this.hKo == null) {
            if (this.hKJ == null) {
                this.hKJ = new com.baidu.tieba.write.editor.d(getActivity(), this.hpq);
                this.hKJ.bGK();
                this.hKJ.setFrom("from_share_write");
                this.hKJ.aO(this.mData.getForumId(), this.mPrivateThread);
            }
            this.bsp.b(this.hKJ);
        }
        this.bsp.K(arrayList);
        r hI = this.bsp.hI(5);
        if (hI != null) {
            hI.bsY = 1;
            hI.bsW = d.f.write_emotion;
        }
    }

    private void bIm() {
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
                        if (TransmitPostEditActivity.this.bIx()) {
                            TransmitPostEditActivity.this.showToast(d.j.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.bIx()) {
                            TransmitPostEditActivity.this.showToast(d.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            TransmitPostEditActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.bIA();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.bsI();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.hKo == null) {
                            TransmitPostEditActivity.this.LF();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.btZ) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.aS(pageActivity)) {
                                    TransmitPostEditActivity.this.LD();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.LC();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.btT != null) {
                            TransmitPostEditActivity.this.btT.mM(true);
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
                            TransmitPostEditActivity.this.bsp.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.bsp.Le()) {
                                        TransmitPostEditActivity.this.bsp.Jl();
                                        TransmitPostEditActivity.this.bsp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.bsp.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.bsp.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.bsp.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.bsp.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.bsI();
                        if (TransmitPostEditActivity.this.gQw != null) {
                            TransmitPostEditActivity.this.gQw.requestFocus();
                        }
                        TransmitPostEditActivity.this.bsp.Jl();
                        TransmitPostEditActivity.this.bsp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gQw);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.bsp.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.hKh = true;
                        TransmitPostEditActivity.this.nQ(true);
                        if (TransmitPostEditActivity.this.bIz().isFocused()) {
                            TransmitPostEditActivity.this.hKg = "from_title";
                        } else if (TransmitPostEditActivity.this.bIy().isFocused()) {
                            TransmitPostEditActivity.this.hKg = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.hKk.setVisibility(0);
                        TransmitPostEditActivity.this.hKk.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.hKk.hasFocus()) {
                            TransmitPostEditActivity.this.gQw.requestFocus();
                            TransmitPostEditActivity.this.gQw.setSelection(TransmitPostEditActivity.this.gQw.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.hKk.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.bsp.a(31, bVar);
        this.bsp.a(16, bVar);
        this.bsp.a(14, bVar);
        this.bsp.a(24, bVar);
        this.bsp.a(3, bVar);
        this.bsp.a(10, bVar);
        this.bsp.a(11, bVar);
        this.bsp.a(12, bVar);
        this.bsp.a(13, bVar);
        this.bsp.a(15, bVar);
        this.bsp.a(18, bVar);
        this.bsp.a(20, bVar);
        this.bsp.a(25, bVar);
        this.bsp.a(27, bVar);
        this.bsp.a(29, bVar);
        this.bsp.a(43, bVar);
        this.bsp.a(45, bVar);
        this.bsp.a(53, bVar);
        this.bsp.a(48, bVar);
        this.bsp.a(46, bVar);
        this.bsp.a(49, bVar);
        this.bsp.a(47, bVar);
        this.bsp.a(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LF() {
        if (this.btT.ahh()) {
            if (this.btT.bxD()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bxz().getLocationData().bxv());
                return;
            }
            b(1, true, null);
            this.btT.bxB();
            return;
        }
        b(0, true, null);
    }

    protected void bsA() {
        if (this.btU != null) {
            this.btU.cancelLoadData();
        }
        if (this.hKl != null) {
            this.hKl.cancelLoadData();
        }
        if (this.btT != null) {
            this.btT.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bsA();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHE() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(bIz().getText().toString());
        this.mData.setContent(bIy().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.gQy != null && this.gQy.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gQy, getPageContext().getPageActivity());
                return true;
            } else if (this.bsp.Le()) {
                this.bsp.Jl();
                return true;
            } else {
                bsA();
                bHE();
                return true;
            }
        }
        if (i == 67 && (text = bIy().getText()) != null) {
            int selectionStart = bIy().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bIy().onKeyDown(67, this.drp);
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
        bIk();
        aj.t(this.gQt, d.C0141d.cp_bg_line_c);
        aj.t(bIz(), d.C0141d.cp_bg_line_d);
        aj.t(bIy(), d.C0141d.cp_bg_line_d);
        bsI();
        this.bsp.onChangeSkinType(i);
        if (this.hKy != null) {
            this.hKy.Em();
        }
        aj.r(this.mName, d.C0141d.cp_cont_b);
        bIn();
        bIo();
        if (this.hHQ != null) {
            this.hHQ.onChangeSkinType();
        }
        if (this.hKK != null) {
            this.hKK.onChangeSkinType();
        }
        this.fyD.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIn() {
        if (this.gQs.hasFocus()) {
            this.gQs.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
        } else {
            this.gQs.setHintTextColor(aj.getColor(d.C0141d.cp_cont_d));
        }
        if (this.gQw.hasFocus()) {
            this.gQw.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
        } else {
            this.gQw.setHintTextColor(aj.getColor(d.C0141d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIo() {
        if (this.gQs != null) {
            if (this.gQs.getText().toString().length() == 0) {
                this.gQs.getPaint().setFakeBoldText(false);
            } else if (this.gQs.getText().toString().length() > 0) {
                this.gQs.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.bCz = new com.baidu.tbadk.core.view.b(getPageContext());
        this.hKA = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.bgy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        aj.r(this.mName, d.C0141d.cp_cont_b);
        bIq();
        this.hKz = (ScrollView) findViewById(d.g.write_scrollview);
        this.hKz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.gQw != null) {
                        l.a(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.gQw);
                    }
                    if (TransmitPostEditActivity.this.bsp != null) {
                        TransmitPostEditActivity.this.bsp.Jl();
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
        this.hKj = (LinearLayout) findViewById(d.g.tool_view);
        this.hKj.setContentDescription("..");
        this.hKk = (LinearLayout) findViewById(d.g.title_view);
        this.gQt = findViewById(d.g.interval_view);
        this.hKC = findViewById(d.g.hot_topic_fourm_view);
        this.hKD = findViewById(d.g.hot_topic_divider);
        this.hKE = (TextView) findViewById(d.g.hot_topic_title_edt);
        this.hKF = (TextView) findViewById(d.g.change_one_tv);
        bsH();
        if (this.hKA) {
            this.hKz.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        bsJ();
        bIw();
        this.gQv = (LinearLayout) findViewById(d.g.post_content_container);
        this.gQv.setDrawingCacheEnabled(false);
        this.gQv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.gQw.requestFocus();
                TransmitPostEditActivity.this.bsp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            }
        });
        this.bgy.setOnFocusChangeListener(this.gQq);
        this.bgy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.bsA();
                TransmitPostEditActivity.this.bHE();
            }
        });
        bIt();
        bIv();
        bIp();
        bIk();
        bIu();
        bsG();
        bIB();
        if (this.mData.getType() == 4 && this.gQA != null && this.hKm != null) {
            this.gQA.setVisibility(8);
            this.hKm.setVisibility(8);
        }
        bsI();
        ShowSoftKeyPad(this.mInputManager, this.gQs);
    }

    private void bIp() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hpq != null && this.hpq.equals("1")) {
                        this.mName.setText(d.j.share_to_home_page);
                    } else if (this.hpq != null && this.hpq.equals("2")) {
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
                    this.gQs.setVisibility(0);
                    this.gQw.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(d.j.publish_photo_live);
                    this.gQw.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(d.j.send_reply);
                    this.gQw.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gQs.setVisibility(8);
                    return;
            }
        }
    }

    private void bIq() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.t(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.gQq);
    }

    private void bIr() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hKi && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = am.d(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(d) && bIz() != null) {
                bIz().setText(d);
                bIz().setSelection(d.length());
            }
        }
    }

    private void bIs() {
        this.hKt = null;
        this.hKv = -1;
        this.hKx = -1;
        com.baidu.tieba.frs.ab mX = aa.awk().mX(1);
        if (mX != null) {
            this.hKt = mX.dHf;
            this.hKv = getIntent().getIntExtra("category_id", -1);
            if (this.hKt != null && !this.hKt.isEmpty() && this.hKv >= 0) {
                this.hKu = new z();
                this.hKu.dHb = 0;
                this.hKu.name = getPageContext().getResources().getString(d.j.category_auto);
                this.hKx = this.hKu.dHb;
                this.hKw = this.hKu.name;
                for (z zVar : this.hKt) {
                    if (zVar.dHb == this.hKv) {
                        this.hKx = zVar.dHb;
                        this.hKw = zVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bIt() {
        if (this.hKt != null && !this.hKt.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.hKy = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.hKy.setText(this.hKw);
            this.hKy.b(this.hKt, this.hKu, this.hKx);
            this.hKy.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, av avVar) {
                    if (avVar != null) {
                        TransmitPostEditActivity.this.hKy.setText(avVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(avVar.dHb);
                        TransmitPostEditActivity.this.hKx = avVar.dHb;
                        TransmitPostEditActivity.this.hKy.bHw();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.hKy.bHv();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIz());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIy());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hKR = new com.baidu.tieba.view.d(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hKR.setTitle(d.j.no_disturb_start_time);
        this.hKR.setButton(-1, getPageContext().getString(d.j.alert_yes_button), this.hKR);
        this.hKR.setButton(-2, getPageContext().getString(d.j.cancel), this.hKR);
        return this.hKR;
    }

    private void bIu() {
        this.hKp = (RelativeLayout) findViewById(d.g.addition_container);
        this.hKq = (TextView) findViewById(d.g.addition_create_time);
        this.hKr = (TextView) findViewById(d.g.addition_last_time);
        this.hKs = (TextView) findViewById(d.g.addition_last_content);
        if (this.hKo != null) {
            this.hKp.setVisibility(0);
            this.hKq.setText(getPageContext().getString(d.j.write_addition_create) + am.z(this.hKo.getCreateTime() * 1000));
            if (this.hKo.getAlreadyCount() == 0) {
                this.hKr.setVisibility(8);
            } else {
                this.hKr.setText(getPageContext().getString(d.j.write_addition_last) + am.z(this.hKo.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hKo.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hKs.setText(lastAdditionContent);
            } else {
                this.hKs.setVisibility(8);
            }
            bIy().setHint(String.format(getPageContext().getString(d.j.write_addition_hint), Integer.valueOf(this.hKo.getAlreadyCount()), Integer.valueOf(this.hKo.getTotalCount())));
            this.mName.setText(d.j.write_addition_title);
            return;
        }
        this.hKp.setVisibility(8);
    }

    private void bsG() {
        this.gQA = findViewById(d.g.post_prefix_layout);
        this.gQx = (TextView) findViewById(d.g.post_prefix);
        this.hKm = findViewById(d.g.prefix_divider);
        this.gQz = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gQA.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gQa = 1;
            this.gQA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.gQx.setVisibility(0);
                    TransmitPostEditActivity.this.gQA.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gQy, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.bsp.Jl();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gQs);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gQw);
                }
            });
            this.gQz = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gQz.setVisibility(0);
                this.gQx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.gQx.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gQy, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.bsp.Jl();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIz());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIy());
                    }
                });
            }
            this.gQy = new com.baidu.tieba.write.e(getPageContext().getPageActivity());
            this.gQy.a(this);
            this.gQy.setMaxHeight(l.t(getActivity(), d.e.ds510));
            this.gQy.setOutsideTouchable(true);
            this.gQy.setFocusable(true);
            this.gQy.setOnDismissListener(this);
            this.gQy.setBackgroundDrawable(aj.getDrawable(d.C0141d.cp_bg_line_d));
            int color = aj.getColor(d.C0141d.cp_cont_b);
            int color2 = aj.getColor(d.C0141d.cp_cont_c);
            aj.s(this.gQx, d.C0141d.cp_bg_line_d);
            aj.c(this.gQz, d.f.icon_frs_arrow_n);
            this.gQx.setTextColor(color);
            this.hJc.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.d dVar = new com.baidu.tieba.write.d(getActivity());
                this.hJc.add(dVar);
                dVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    dVar.setPrefixTextColor(color2);
                } else {
                    dVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    dVar.setDividerStyle(false);
                }
                this.gQy.addView(dVar);
            }
            this.gQy.setCurrentIndex(0);
            this.gQx.setText(prefixs.get(1));
            xI(1);
            return;
        }
        this.gQA.setVisibility(8);
    }

    protected void bIv() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    TransmitPostEditActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.hKK.bFD()) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.hKK.bFF());
                        TransmitPostEditActivity.this.nP(true);
                    } else if (TransmitPostEditActivity.this.hHQ.bFD()) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.hHQ.bFF());
                        TransmitPostEditActivity.this.nJ(true);
                    } else {
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIz());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIy());
                        TransmitPostEditActivity.this.bsp.Jl();
                        TiebaStatic.log(new ak("c12608").s("obj_locate", 7));
                        TransmitPostEditActivity.this.bIE();
                    }
                }
            }
        });
    }

    protected void bsH() {
        this.gQs = (EditText) findViewById(d.g.post_title);
        this.gQs.setOnClickListener(this.hKN);
        this.gQs.setOnFocusChangeListener(this.gQq);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.gQs.setText(this.mData.getTitle());
            this.gQs.setSelection(this.mData.getTitle().length());
        }
        this.gQs.addTextChangedListener(this.hKP);
        if (!this.mData.getHaveDraft()) {
            bIr();
        }
        this.gQs.setHint(getResources().getString(d.j.post_title_hint));
    }

    protected void bsJ() {
        this.gQw = (EditText) findViewById(d.g.post_content);
        this.gQw.setDrawingCacheEnabled(false);
        this.gQw.setOnClickListener(this.hKN);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString W = TbFaceManager.Mv().W(getPageContext().getPageActivity(), this.mData.getContent());
            this.gQw.setText(W);
            this.gQw.setSelection(W.length());
        }
        this.gQw.setOnFocusChangeListener(this.gQq);
        this.gQw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.bsp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.gQw.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gQw.addTextChangedListener(this.hKQ);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.gQw.setHint(d.j.share_video_default);
        } else {
            this.gQw.setHint(d.j.share_txt_default);
        }
    }

    private void bIw() {
        this.fyD = (OriginalThreadCardView) findViewById(d.g.write_original_thread_cardview);
        this.fyD.setVisibility(0);
        this.fyD.b(this.mOriginalThreadInfo);
        this.fyD.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIx() {
        int i = 5000;
        if (this.hKo != null) {
            i = 1000;
        }
        return bIy().getText() != null && bIy().getText().length() >= i;
    }

    private void gq(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hKg)) {
                this.hKg = "";
                bIy().requestFocus();
                if (bIy().getText() != null && bIy().getText().length() + str.length() > 5000) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bIy().getSelectionStart();
                    editable = bIy().getText();
                }
            } else if ("from_title".equals(this.hKg)) {
                this.hKg = "";
                bIz().requestFocus();
                if (bIz().getText() != null && bIz().getText().length() + str.length() > 31) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bIz().getSelectionStart();
                    editable = bIz().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nQ(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    protected void d(n nVar) {
        if (((ImageSpan[]) bIy().getText().getSpans(0, bIy().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hKn == null) {
                this.hKn = Toast.makeText(getPageContext().getPageActivity(), d.j.too_many_face, 0);
            }
            this.hKn.show();
            return;
        }
        String name = nVar.getName();
        final EmotionGroupType FO = nVar.FO();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.nm().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.bIy().getSelectionStart(), aVar, FO);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bIy() != null && bIy().getText() != null) {
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
                int selectionStart = bIy().getSelectionStart() - 1;
                if (bIy().getText().length() > 1 && selectionStart >= 0 && bIy().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bIy().getText().insert(bIy().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bIy().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bIy().getText().insert(bIy().getSelectionStart(), spannableString2);
            }
            Editable text = bIy().getText();
            if (text != null) {
                this.hKI.clear();
                this.hKI.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hKI);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bIy().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bIy().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bIy().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bIy() {
        return this.gQw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bIz() {
        return this.gQs;
    }

    protected void bIA() {
        Editable text;
        if (bIy() != null && (text = bIy().getText()) != null) {
            int selectionStart = bIy().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bIy().onKeyDown(67, this.drp);
            }
            bIy().onKeyDown(67, this.drp);
            int selectionStart2 = bIy().getSelectionStart();
            this.hKI.clear();
            this.hKI.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.hKI);
            bIy().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.bCz.d(null);
        this.bCz.ga(d.j.sending);
        this.bCz.bq(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.bCz.bq(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsI() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bIz() != null) {
                str = bIz().getText().toString();
            }
            if (bIy() != null) {
                str2 = bIy().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.gQa == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            nR(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        nR(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    nR(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hKA) {
                    nR(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    nR(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                nR(true);
            } else if (this.mData.getVideoInfo() != null) {
                nR(true);
            } else {
                nR(false);
            }
        }
    }

    private void nR(boolean z) {
        aj.d(this.mPost, d.C0141d.cp_link_tip_a, d.C0141d.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.btU = new NewWriteModel(this);
        this.btU.b(this.buj);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.bsA();
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
                this.hKo = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hKo != null);
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
            this.hpq = bundle.getString("KEY_CALL_FROM");
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
            this.hKo = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hKo != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hpq = intent.getStringExtra("KEY_CALL_FROM");
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
            this.hKi = true;
        }
        bIs();
    }

    private void bIB() {
        if (v.D(this.mList) > 0 && this.mList.get(0) != null) {
            this.hKC.setVisibility(0);
            this.hKD.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.gQs.setText(com.baidu.tbadk.plugins.a.hd(uJ(this.mList.get(0).mTopicName)));
                this.gQs.setMovementMethod(com.baidu.tieba.view.e.bEL());
            }
            this.hKE.setText(this.mList.get(0).mForumName);
            this.gQs.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!TransmitPostEditActivity.this.hKG.equals(charSequence.toString())) {
                        TransmitPostEditActivity.this.hKH = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString hd;
                    if (!TransmitPostEditActivity.this.hKG.equals(editable.toString()) && (hd = com.baidu.tbadk.plugins.a.hd(editable.toString())) != null) {
                        TransmitPostEditActivity.this.hKG = hd.toString();
                        TransmitPostEditActivity.this.gQs.setText(hd);
                        if (TransmitPostEditActivity.this.hKH <= TransmitPostEditActivity.this.gQs.getText().length()) {
                            TransmitPostEditActivity.this.gQs.setSelection(TransmitPostEditActivity.this.hKH);
                        }
                    }
                }
            });
            this.hKF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
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
                this.gQs.setText(hd);
            }
            this.hKE.setText(hotTopicBussinessData.mForumName);
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
        if (this.hKo != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hKo));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.hpq);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bIy().getEditableText().toString();
        if (obj != null) {
            bIy().setText(TbFaceManager.Mv().a(getPageContext().getPageActivity(), obj, this.hKL));
            bIy().setSelection(bIy().getText().length());
        }
    }

    private String bIC() {
        if (bIy() == null || bIy().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(bIy().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(d.j.share_video_default);
            }
            return getString(d.j.share_txt_default);
        }
        return bIy().getText().toString();
    }

    private String bID() {
        if (this.mData == null || bIz() == null || bIz().getVisibility() != 0 || bIz().getText() == null) {
            return "";
        }
        String obj = bIz().getText().toString();
        if (this.mPrefixData != null && v.D(this.mPrefixData.getPrefixs()) > 0 && this.gQa != 0 && this.mData.getType() != 4 && this.gQx != null && this.gQx.getText() != null) {
            obj = this.gQx.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void bHF() {
        bsA();
        this.mData.setContent(bIC());
        this.mData.setTitle(bID());
        if (this.hKv >= 0) {
            this.mData.setCategoryFrom(this.hKv);
        }
        if (this.hKx >= 0) {
            this.mData.setCategoryTo(this.hKx);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.btT != null && this.btT.ahh());
        this.btU.mO(this.writeImagesInfo.size() > 0);
        if (!v.E(this.mList) && this.hKB != null && this.hKB.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hKB.mForumId));
            this.mData.setForumName(this.hKB.mForumName);
        }
        this.btU.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.btU.getWriteData().setVoice(null);
        this.btU.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.oJ()) {
            showToast(d.j.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
        this.btU.startPostWrite();
    }

    private void o(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.hKo != null) {
                i2 = this.hKo.getTotalCount();
                i = this.hKo.getAlreadyCount() + 1;
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
                if (this.bsp != null && !this.bsp.Le()) {
                    bIy().requestFocus();
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
                            bIy().getText().insert(bIy().getSelectionStart(), sb.toString());
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
                        if (this.hKh) {
                            sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                            this.hKh = false;
                        }
                        sb2.append(stringExtra);
                        gq(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !v.E(this.mList) && !v.E(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.hKB = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.hKB);
            }
        } else if (i2 == 0) {
            if (this.bsp != null && !this.bsp.Le()) {
                this.gQw.requestFocus();
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
                        this.hHQ.aw(postWriteCallBackData.getSensitiveWords());
                        this.hKK.aw(postWriteCallBackData.getSensitiveWords());
                        if (!v.E(this.hHQ.bFB())) {
                            nJ(true);
                            nP(true);
                            return;
                        }
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.hKg)) {
                        bIz().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hKg)) {
                        bIy().requestFocus();
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
    public void bIE() {
        if ("1".equals(this.hpq)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.hpq)) {
            this.mData.setCanNoForum(false);
        }
        bIF();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.hpq);
        bHF();
    }

    private void bIF() {
        if (this.bsp != null) {
            this.bsp.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bIz());
        HidenSoftKeyPad(this.mInputManager, bIy());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.vR(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dFi) != null) {
                    TiebaStatic.log(new ak("c12534").s("obj_locate", aq.a.aXv));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.j.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hKo == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                o(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.btZ = i;
        if (this.bsp != null) {
            this.bsp.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bIG() {
        if (!this.hKA && this.bsp != null) {
            this.bsp.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.bsp.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(boolean z) {
        if (this.bsp != null) {
            this.bsp.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void xI(int i) {
        if (i < this.hJc.size()) {
            for (int i2 = 0; i2 < this.hJc.size(); i2++) {
                this.hJc.get(i2).nD(false);
            }
            this.hJc.get(i).nD(true);
        }
    }

    @Override // com.baidu.tieba.write.e.a
    public void vm(int i) {
        this.gQa = i;
        this.gQy.setCurrentIndex(i);
        xI(i);
        this.gQx.setText(this.mPrefixData.getPrefixs().get(i));
        bsI();
        com.baidu.adp.lib.g.g.a(this.gQy, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gQA.setSelected(false);
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
            LD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hKJ != null && !z) {
            this.hKJ.bfl();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hKh = false;
            this.hKg = "";
            if ("from_content".equals(str)) {
                this.hKg = "from_content";
            } else if ("from_title".equals(str)) {
                this.hKg = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                nQ(false);
            }
        }
    }

    public void Jn() {
        if (!v.E(this.mList)) {
            this.hKk.setVisibility(0);
            this.hKk.requestFocus();
            this.bsp.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hKk.setVisibility(8);
    }
}
