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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.d;
import com.baidu.tieba.write.view.PostCategoryView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes3.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0062a, d.a {
    private EditorTools aMl;
    private LocationModel aNO;
    private NewWriteModel aNP;
    private OriginalThreadCardView fjY;
    private int gBQ;
    private TextView gCn;
    private com.baidu.tieba.write.d gCo;
    private ImageView gCp;
    private View gCq;
    private LinearLayout hxA;
    private View hxC;
    private Toast hxE;
    private AdditionData hxF;
    private RelativeLayout hxG;
    private TextView hxH;
    private TextView hxI;
    private TextView hxJ;
    List<x> hxK;
    x hxL;
    private int hxM;
    private String hxN;
    private int hxO;
    private PostCategoryView hxP;
    private HotTopicBussinessData hxS;
    private TextView hxT;
    private com.baidu.tieba.write.editor.b hxV;
    private e hxY;
    private LinearLayout hxz;
    private com.baidu.tieba.view.b hyf;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String hxw = "";
    private boolean hxx = false;
    private WriteData mData = null;
    private boolean hxy = false;
    private InputMethodManager mInputManager = null;
    private EditText gCi = null;
    private View gCj = null;
    private LinearLayout gCl = null;
    private EditText gCm = null;
    private FeedBackModel hxB = null;
    private ArrayList<WritePrefixItemLayout> hxD = new ArrayList<>();
    private final KeyEvent cSx = new KeyEvent(0, 67);
    private View aBf = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String aNT = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aNU = 0;
    private View mRootView = null;
    private ScrollView hxQ = null;
    private boolean hxR = false;
    private com.baidu.tbadk.core.view.a aVW = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String hcf = "2";
    private SpannableStringBuilder hxU = new SpannableStringBuilder();
    private boolean hxW = false;
    private final b hxX = new b();
    private TbFaceManager.a hxZ = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan he(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.mZ());
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
    private final AntiHelper.a dkD = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").r("obj_locate", at.a.arM));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").r("obj_locate", at.a.arM));
        }
    };
    private final NewWriteModel.d aOd = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.hxX.aB(null);
                if (z) {
                    TransmitPostEditActivity.this.bM(z);
                    TransmitPostEditActivity.this.c(true, postWriteCallBackData);
                    TransmitPostEditActivity.this.k(postWriteCallBackData);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    TransmitPostEditActivity.this.setResult(-1, intent);
                    TransmitPostEditActivity.this.finish();
                } else if (postWriteCallBackData.isSensitiveError()) {
                    TransmitPostEditActivity.this.showToast(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.hxX.vu(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.hxX.aB(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.hxX.b(TransmitPostEditActivity.this.gCi, TransmitPostEditActivity.this.gCm);
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.CC());
                    if (com.baidu.tbadk.p.a.hQ(tVar.CB())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.CB())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a aOb = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void Io() {
            TransmitPostEditActivity.this.showToast(d.k.no_network_guide);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void gT(String str) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            if (StringUtils.isNull(str)) {
                str = TransmitPostEditActivity.this.getPageContext().getString(d.k.location_fail);
            }
            transmitPostEditActivity.showToast(str);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.byg())) {
                TransmitPostEditActivity.this.b(2, true, aVar.byg());
            } else {
                gT(null);
            }
        }
    };
    private final CustomMessageListener gPl = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.aNO.mL(false);
                    TransmitPostEditActivity.this.aNO.cr(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.aNO.mL(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hya = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hyb = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bIC = TransmitPostEditActivity.this.bIC();
            if (bIC >= 0 && bIC < TransmitPostEditActivity.this.gCm.getText().length()) {
                TransmitPostEditActivity.this.gCm.setSelection(bIC);
            }
        }
    };
    private boolean hyc = true;
    private final View.OnFocusChangeListener gCg = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.gCi || view == TransmitPostEditActivity.this.aBf || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.hyc = true;
                    TransmitPostEditActivity.this.bID();
                    if (TransmitPostEditActivity.this.aMl != null) {
                        TransmitPostEditActivity.this.aMl.FT();
                    }
                    l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gCi);
                } else if (view == TransmitPostEditActivity.this.gCi) {
                    TransmitPostEditActivity.this.gCn.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.gCm && z) {
                TransmitPostEditActivity.this.hyc = false;
                TransmitPostEditActivity.this.bID();
                TransmitPostEditActivity.this.aMl.FT();
                l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gCm);
            }
            TransmitPostEditActivity.this.bIJ();
        }
    };
    private TextWatcher hyd = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String hyh = "";
        private String hyi;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hyi = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hyi != null ? this.hyi.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.btq();
            TransmitPostEditActivity.this.bIK();
            EditText bIV = TransmitPostEditActivity.this.bIV();
            if (editable != null && bIV != null && bIV.getText() != null) {
                if (this.hyh == null || !this.hyh.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.hxX != null) {
                        this.hyh = bIV.getText().toString();
                        TransmitPostEditActivity.this.hxX.k(bIV);
                        return;
                    }
                    return;
                }
                bIV.setSelection(bIV.getSelectionEnd());
            }
        }
    };
    private TextWatcher hye = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String hyi;
        private String hyj = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hyi = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hyi != null ? this.hyi.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.btq();
            EditText bIU = TransmitPostEditActivity.this.bIU();
            if (editable != null && bIU != null && bIU.getText() != null) {
                int selectionEnd = bIU.getSelectionEnd();
                if (this.hyj == null || !this.hyj.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.hxX != null) {
                        this.hyj = bIU.getText().toString();
                        TransmitPostEditActivity.this.hxX.k(bIU);
                        return;
                    }
                    return;
                }
                bIU.setSelection(selectionEnd);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ap.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HZ() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Ia() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.k.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Ic();
        } else if (this.aNO.byo()) {
            HZ();
        } else {
            this.aNO.mL(false);
            b(1, true, null);
            this.aNO.bym();
        }
    }

    private void Ic() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cd(d.k.location_app_permission_prompt).a(d.k.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.jD()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.aNO.afA();
                } else {
                    TransmitPostEditActivity.this.aOb.Io();
                }
                aVar2.dismiss();
            }
        }).b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TransmitPostEditActivity.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.xn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bIC() {
        int selectionEnd = bIU().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bIU().getText().getSpans(0, bIU().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bIU().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bIU().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bID() {
        if (this.aMl != null) {
            this.aMl.setBarLauncherEnabled(!this.hyc);
            this.aMl.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hxR) {
            this.gCi.setVisibility(8);
            btq();
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
        initUI();
        this.aNO = new LocationModel(this);
        this.aNO.a(this.aOb);
        registerListener(this.gPl);
        registerListener(this.hya);
        initEditor();
        this.gCm.requestFocus();
        bpv();
        bJd();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aMl = new EditorTools(getActivity());
        this.aMl.setBarMaxLauCount(4);
        this.aMl.setMoreButtonAtEnd(true);
        this.aMl.setBarLauncherType(1);
        this.aMl.bE(true);
        this.aMl.bF(true);
        this.aMl.setMoreLauncherIcon(d.f.write_more);
        this.aMl.setBackgroundColorId(d.C0142d.cp_bg_line_d);
        bIE();
        this.aMl.Hz();
        if (this.hxz != null) {
            this.hxz.addView(this.aMl);
        }
        bIF();
        this.aMl.oD();
        com.baidu.tbadk.editortools.g eK = this.aMl.eK(6);
        if (eK != null && !TextUtils.isEmpty(this.aNT)) {
            ((View) eK).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.aNT);
                }
            });
        }
        if (!this.hxR) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aMl.FT();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
        bIH();
    }

    private void bIE() {
        com.baidu.tbadk.editortools.k kVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 2);
        aVar.aMS = d.f.write_at;
        this.aMl.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.aMl.b(aVar2);
        aVar2.aMS = d.f.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask != null && (kVar = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar.aMU = 4;
            kVar.aMS = d.f.icon_post_location_selector;
            this.aMl.b(kVar);
        }
        if (this.hxF == null) {
            if (this.hxV == null) {
                this.hxV = new com.baidu.tieba.write.editor.b(getActivity(), this.hcf);
                this.hxV.bHH();
                this.hxV.setFrom("from_share_write");
                this.hxV.aT(this.mData.getForumId(), this.mPrivateThread);
            }
            this.aMl.b(this.hxV);
        }
        this.aMl.G(arrayList);
        com.baidu.tbadk.editortools.k eN = this.aMl.eN(5);
        if (eN != null) {
            eN.aMU = 1;
            eN.aMS = d.f.write_emotion;
        }
    }

    private void bIF() {
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
                            TiebaStatic.log(new an("c12608").r("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.bIT()) {
                            TransmitPostEditActivity.this.showToast(d.k.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.bIT()) {
                            TransmitPostEditActivity.this.showToast(d.k.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            TransmitPostEditActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.bIW();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.btq();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.hxF == null) {
                            TransmitPostEditActivity.this.Id();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.aNU) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ac.aM(pageActivity)) {
                                    TransmitPostEditActivity.this.Ia();
                                    return;
                                } else {
                                    ac.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.HZ();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.aNO != null) {
                            TransmitPostEditActivity.this.aNO.mL(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        an anVar = new an("c10645");
                        if (TransmitPostEditActivity.this.mData != null) {
                            str = TransmitPostEditActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.ah(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(anVar);
                        if (TransmitPostEditActivity.this.mData == null || (videoInfo = TransmitPostEditActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.aMl.HB()) {
                                        TransmitPostEditActivity.this.aMl.FT();
                                        TransmitPostEditActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(TransmitPostEditActivity.this.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(TransmitPostEditActivity.this.getPageContext(), TransmitPostEditActivity.this.getResources().getString(d.k.plugin_video_not_active), TransmitPostEditActivity.this.getResources().getString(d.k.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(TransmitPostEditActivity.this.getPageContext(), TransmitPostEditActivity.this.getResources().getString(d.k.plugin_video_install_tips), TransmitPostEditActivity.this.getResources().getString(d.k.plugin_go_install));
                            return;
                        }
                        TransmitPostEditActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.btq();
                        if (TransmitPostEditActivity.this.gCm != null) {
                            TransmitPostEditActivity.this.gCm.requestFocus();
                        }
                        TransmitPostEditActivity.this.aMl.FT();
                        TransmitPostEditActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gCm);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.hxx = true;
                        TransmitPostEditActivity.this.nM(true);
                        if (TransmitPostEditActivity.this.bIV().isFocused()) {
                            TransmitPostEditActivity.this.hxw = "from_title";
                        } else if (TransmitPostEditActivity.this.bIU().isFocused()) {
                            TransmitPostEditActivity.this.hxw = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.hxA.setVisibility(0);
                        TransmitPostEditActivity.this.hxA.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.hxA.hasFocus()) {
                            TransmitPostEditActivity.this.gCm.requestFocus();
                            TransmitPostEditActivity.this.gCm.setSelection(TransmitPostEditActivity.this.gCm.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.hxA.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aMl.setActionListener(31, bVar);
        this.aMl.setActionListener(16, bVar);
        this.aMl.setActionListener(14, bVar);
        this.aMl.setActionListener(24, bVar);
        this.aMl.setActionListener(3, bVar);
        this.aMl.setActionListener(10, bVar);
        this.aMl.setActionListener(11, bVar);
        this.aMl.setActionListener(12, bVar);
        this.aMl.setActionListener(13, bVar);
        this.aMl.setActionListener(15, bVar);
        this.aMl.setActionListener(18, bVar);
        this.aMl.setActionListener(20, bVar);
        this.aMl.setActionListener(25, bVar);
        this.aMl.setActionListener(27, bVar);
        this.aMl.setActionListener(29, bVar);
        this.aMl.setActionListener(43, bVar);
        this.aMl.setActionListener(45, bVar);
        this.aMl.setActionListener(53, bVar);
        this.aMl.setActionListener(48, bVar);
        this.aMl.setActionListener(46, bVar);
        this.aMl.setActionListener(49, bVar);
        this.aMl.setActionListener(47, bVar);
        this.aMl.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Id() {
        if (this.aNO.afw()) {
            if (this.aNO.byo()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.byk().getLocationData().byg());
                return;
            }
            b(1, true, null);
            this.aNO.bym();
            return;
        }
        b(0, true, null);
    }

    protected void bti() {
        if (this.aNP != null) {
            this.aNP.cancelLoadData();
        }
        if (this.hxB != null) {
            this.hxB.cancelLoadData();
        }
        if (this.aNO != null) {
            this.aNO.cancelLoadData();
        }
    }

    private void bIG() {
        if (this.hxY != null) {
            this.hxY.hideTip();
        }
    }

    private void bIH() {
        if (this.hxY == null) {
            this.hxY = new e(getPageContext());
        }
        this.hxY.c(this.aMl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bIG();
        TiebaPrepareImageService.StopService();
        bti();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bII() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(bIV().getText().toString());
        this.mData.setContent(bIU().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.gCo != null && this.gCo.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gCo, getPageContext().getPageActivity());
                return true;
            } else if (this.aMl.HB()) {
                this.aMl.FT();
                return true;
            } else {
                bti();
                bII();
                return true;
            }
        }
        if (i == 67 && (text = bIU().getText()) != null) {
            int selectionStart = bIU().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bIU().onKeyDown(67, this.cSx);
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
        getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.c(this.mPost, d.C0142d.cp_link_tip_a, 1);
        bID();
        am.j(this.gCj, d.C0142d.cp_bg_line_c);
        am.j(bIV(), d.C0142d.cp_bg_line_d);
        am.j(bIU(), d.C0142d.cp_bg_line_d);
        btq();
        this.aMl.onChangeSkinType(i);
        if (this.hxP != null) {
            this.hxP.AP();
        }
        am.h(this.mName, d.C0142d.cp_cont_b);
        bIJ();
        bIK();
        if (this.hxX != null) {
            this.hxX.c(bIV(), bIU());
        }
        this.fjY.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIJ() {
        if (this.gCi.hasFocus()) {
            this.gCi.setHintTextColor(am.getColor(d.C0142d.cp_cont_e));
        } else {
            this.gCi.setHintTextColor(am.getColor(d.C0142d.cp_cont_d));
        }
        if (this.gCm.hasFocus()) {
            this.gCm.setHintTextColor(am.getColor(d.C0142d.cp_cont_e));
        } else {
            this.gCm.setHintTextColor(am.getColor(d.C0142d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIK() {
        if (this.gCi != null) {
            if (this.gCi.getText().toString().length() == 0) {
                this.gCi.getPaint().setFakeBoldText(false);
            } else if (this.gCi.getText().toString().length() > 0) {
                this.gCi.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.aVW = new com.baidu.tbadk.core.view.a(getPageContext());
        this.hxR = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.i.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aBf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.h(this.mName, d.C0142d.cp_cont_b);
        bIM();
        this.hxQ = (ScrollView) findViewById(d.g.write_scrollview);
        this.hxQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.gCm != null) {
                        l.b(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.gCm);
                    }
                    if (TransmitPostEditActivity.this.aMl != null) {
                        TransmitPostEditActivity.this.aMl.FT();
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
        this.hxz = (LinearLayout) findViewById(d.g.tool_view);
        this.hxz.setContentDescription("..");
        this.hxA = (LinearLayout) findViewById(d.g.title_view);
        this.gCj = findViewById(d.g.interval_view);
        this.hxT = (TextView) findViewById(d.g.hot_topic_title_edt);
        btp();
        if (this.hxR) {
            this.hxQ.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        btr();
        bIS();
        this.gCl = (LinearLayout) findViewById(d.g.post_content_container);
        this.gCl.setDrawingCacheEnabled(false);
        this.gCl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.gCm.requestFocus();
            }
        });
        this.aBf.setOnFocusChangeListener(this.gCg);
        this.aBf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.bti();
                TransmitPostEditActivity.this.bII();
            }
        });
        bIP();
        bIR();
        bIL();
        bID();
        bIQ();
        bto();
        bIX();
        if (this.mData.getType() == 4 && this.gCq != null && this.hxC != null) {
            this.gCq.setVisibility(8);
            this.hxC.setVisibility(8);
        }
        btq();
        ShowSoftKeyPad(this.mInputManager, this.gCi);
    }

    private void bIL() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hcf != null && this.hcf.equals("1")) {
                        this.mName.setText(d.k.share_to_home_page);
                    } else if (this.hcf != null && this.hcf.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(d.k.share_to) + this.mData.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(d.k.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(d.k.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.gCi.setVisibility(0);
                    this.gCm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(d.k.publish_photo_live);
                    this.gCm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(d.k.send_reply);
                    this.gCm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gCi.setVisibility(8);
                    return;
            }
        }
    }

    private void bIM() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.e(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.gCg);
    }

    private void bIN() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hxy && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = ap.d(this.mPostTopicData.getTitleTopic(), 31, (String) null);
            if (!StringUtils.isNull(d) && bIV() != null) {
                bIV().setText(d);
                bIV().setSelection(d.length());
            }
        }
    }

    private void bIO() {
        this.hxK = null;
        this.hxM = -1;
        this.hxO = -1;
        z ku = y.avd().ku(1);
        if (ku != null) {
            this.hxK = ku.dmG;
            this.hxM = getIntent().getIntExtra("category_id", -1);
            if (this.hxK != null && !this.hxK.isEmpty() && this.hxM >= 0) {
                this.hxL = new x();
                this.hxL.dmC = 0;
                this.hxL.name = getPageContext().getResources().getString(d.k.category_auto);
                this.hxO = this.hxL.dmC;
                this.hxN = this.hxL.name;
                for (x xVar : this.hxK) {
                    if (xVar.dmC == this.hxM) {
                        this.hxO = xVar.dmC;
                        this.hxN = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bIP() {
        if (this.hxK != null && !this.hxK.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.hxP = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.hxP.setText(this.hxN);
            this.hxP.setCategoryContainerData(this.hxK, this.hxL, this.hxO);
            this.hxP.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, com.baidu.tieba.frs.at atVar) {
                    if (atVar != null) {
                        TransmitPostEditActivity.this.hxP.setText(atVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(atVar.dmC);
                        TransmitPostEditActivity.this.hxO = atVar.dmC;
                        TransmitPostEditActivity.this.hxP.bIr();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.hxP.bIq();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIV());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIU());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hyf = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hyf.setTitle(d.k.no_disturb_start_time);
        this.hyf.setButton(-1, getPageContext().getString(d.k.alert_yes_button), this.hyf);
        this.hyf.setButton(-2, getPageContext().getString(d.k.cancel), this.hyf);
        return this.hyf;
    }

    private void bIQ() {
        this.hxG = (RelativeLayout) findViewById(d.g.addition_container);
        this.hxH = (TextView) findViewById(d.g.addition_create_time);
        this.hxI = (TextView) findViewById(d.g.addition_last_time);
        this.hxJ = (TextView) findViewById(d.g.addition_last_content);
        if (this.hxF != null) {
            this.hxG.setVisibility(0);
            this.hxH.setText(getPageContext().getString(d.k.write_addition_create) + ap.w(this.hxF.getCreateTime() * 1000));
            if (this.hxF.getAlreadyCount() == 0) {
                this.hxI.setVisibility(8);
            } else {
                this.hxI.setText(getPageContext().getString(d.k.write_addition_last) + ap.w(this.hxF.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hxF.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hxJ.setText(lastAdditionContent);
            } else {
                this.hxJ.setVisibility(8);
            }
            bIU().setHint(String.format(getPageContext().getString(d.k.write_addition_hint), Integer.valueOf(this.hxF.getAlreadyCount()), Integer.valueOf(this.hxF.getTotalCount())));
            this.mName.setText(d.k.write_addition_title);
            return;
        }
        this.hxG.setVisibility(8);
    }

    private void bto() {
        this.gCq = findViewById(d.g.post_prefix_layout);
        this.gCn = (TextView) findViewById(d.g.post_prefix);
        this.hxC = findViewById(d.g.prefix_divider);
        this.gCp = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gCq.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gBQ = 1;
            this.gCq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.gCn.setVisibility(0);
                    TransmitPostEditActivity.this.gCq.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gCo, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.aMl.FT();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gCi);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gCm);
                }
            });
            this.gCp = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gCp.setVisibility(0);
                this.gCn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.gCn.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gCo, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.aMl.FT();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIV());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIU());
                    }
                });
            }
            this.gCo = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.gCo.a(this);
            this.gCo.setMaxHeight(l.e(getActivity(), d.e.ds510));
            this.gCo.setOutsideTouchable(true);
            this.gCo.setFocusable(true);
            this.gCo.setOnDismissListener(this);
            this.gCo.setBackgroundDrawable(am.getDrawable(d.C0142d.cp_bg_line_d));
            int color = am.getColor(d.C0142d.cp_cont_b);
            int color2 = am.getColor(d.C0142d.cp_cont_c);
            am.i(this.gCn, d.C0142d.cp_bg_line_d);
            am.c(this.gCp, d.f.icon_frs_arrow_n);
            this.gCn.setTextColor(color);
            this.hxD.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.hxD.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.gCo.addView(writePrefixItemLayout);
            }
            this.gCo.setCurrentIndex(0);
            this.gCn.setText(prefixs.get(1));
            vH(1);
            return;
        }
        this.gCq.setVisibility(8);
    }

    protected void bIR() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.jD()) {
                    TransmitPostEditActivity.this.showToast(d.k.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.hxX.a(TransmitPostEditActivity.this.gCi, TransmitPostEditActivity.this.gCm)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.hxX.bGC());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIV());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIU());
                    TransmitPostEditActivity.this.aMl.FT();
                    TiebaStatic.log(new an("c12608").r("obj_locate", 7));
                    TransmitPostEditActivity.this.bJb();
                }
            }
        });
    }

    protected void btp() {
        this.gCi = (EditText) findViewById(d.g.post_title);
        this.gCi.setOnClickListener(this.hyb);
        this.gCi.setOnFocusChangeListener(this.gCg);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.gCi.setText(this.mData.getTitle());
            this.gCi.setSelection(this.mData.getTitle().length());
        }
        this.gCi.addTextChangedListener(this.hyd);
        if (!this.mData.getHaveDraft()) {
            bIN();
        }
        this.gCi.setHint(getResources().getString(d.k.post_title_hint));
    }

    protected void btr() {
        this.gCm = (EditText) findViewById(d.g.post_content);
        this.gCm.setDrawingCacheEnabled(false);
        this.gCm.setOnClickListener(this.hyb);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString U = TbFaceManager.IU().U(getPageContext().getPageActivity(), this.mData.getContent());
            this.gCm.setText(U);
            this.gCm.setSelection(U.length());
        }
        this.gCm.setOnFocusChangeListener(this.gCg);
        this.gCm.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.gCm.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gCm.addTextChangedListener(this.hye);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.gCm.setHint(d.k.share_video_default);
        } else {
            this.gCm.setHint(d.k.share_txt_default);
        }
    }

    private void bIS() {
        this.fjY = (OriginalThreadCardView) findViewById(d.g.write_original_thread_cardview);
        this.fjY.setVisibility(0);
        this.fjY.b(this.mOriginalThreadInfo);
        this.fjY.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIT() {
        int i = 5000;
        if (this.hxF != null) {
            i = 1000;
        }
        return bIU().getText() != null && bIU().getText().length() >= i;
    }

    private void gK(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hxw)) {
                this.hxw = "";
                bIU().requestFocus();
                if (bIU().getText() != null && bIU().getText().length() + str.length() > 5000) {
                    showToast(d.k.over_limit_tip);
                    return;
                } else {
                    i = bIU().getSelectionStart();
                    editable = bIU().getText();
                }
            } else if ("from_title".equals(this.hxw)) {
                this.hxw = "";
                bIV().requestFocus();
                if (bIV().getText() != null && bIV().getText().length() + str.length() > 31) {
                    showToast(d.k.over_limit_tip);
                    return;
                } else {
                    i = bIV().getSelectionStart();
                    editable = bIV().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nM(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void d(n nVar) {
        if (((ImageSpan[]) bIU().getText().getSpans(0, bIU().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hxE == null) {
                this.hxE = Toast.makeText(getPageContext().getPageActivity(), d.k.too_many_face, 0);
            }
            this.hxE.show();
            return;
        }
        String name = nVar.getName();
        final EmotionGroupType Ct = nVar.Ct();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.ig().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.bIU().getSelectionStart(), aVar, Ct);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bIU() != null && bIU().getText() != null) {
            Bitmap mZ = aVar.mZ();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(mZ);
            int width = mZ.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, mZ.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.f(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bIU().getSelectionStart() - 1;
                if (bIU().getText().length() > 1 && selectionStart >= 0 && bIU().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bIU().getText().insert(bIU().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bIU().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bIU().getText().insert(bIU().getSelectionStart(), spannableString2);
            }
            Editable text = bIU().getText();
            if (text != null) {
                this.hxU.clear();
                this.hxU.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hxU);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bIU().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bIU().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bIU().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bIU() {
        return this.gCm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bIV() {
        return this.gCi;
    }

    protected void bIW() {
        Editable text;
        if (bIU() != null && (text = bIU().getText()) != null) {
            int selectionStart = bIU().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bIU().onKeyDown(67, this.cSx);
            }
            bIU().onKeyDown(67, this.cSx);
            int selectionStart2 = bIU().getSelectionStart();
            this.hxU.clear();
            this.hxU.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.hxU);
            bIU().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aVW.d(null);
        this.aVW.dd(d.k.sending);
        this.aVW.aO(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aVW.aO(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btq() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bIV() != null) {
                str = bIV().getText().toString();
            }
            if (bIU() != null) {
                str2 = bIU().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.gBQ == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            nN(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        nN(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    nN(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hxR) {
                    nN(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    nN(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                nN(true);
            } else if (this.mData.getVideoInfo() != null) {
                nN(true);
            } else {
                nN(false);
            }
        }
    }

    private void nN(boolean z) {
        am.b(this.mPost, d.C0142d.cp_link_tip_a, d.C0142d.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.aNP = new NewWriteModel(this);
        this.aNP.b(this.aOd);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.bti();
            }
        };
        this.mData = new WriteData();
        if (bundle != null) {
            this.mData.setType(bundle.getInt("type", 0));
            this.mData.setForumId(bundle.getString("forum_id"));
            this.mData.setForumName(bundle.getString("forum_name"));
            this.mData.setFirstDir(bundle.getString(IntentConfig.FORUM_FIRST_DIR));
            this.mData.setSecondDir(bundle.getString(IntentConfig.FORUM_SECOND_DIR));
            this.mData.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.hxF = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hxF != null);
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
            this.hcf = bundle.getString("KEY_CALL_FROM");
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
            this.mData.setFirstDir(intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR));
            this.mData.setSecondDir(intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.hxF = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hxF != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hcf = intent.getStringExtra("KEY_CALL_FROM");
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
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(d.k.write_no_prefix));
        }
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.videoId != null) {
            this.mData.setVideoId(this.mOriginalThreadInfo.videoId);
            this.mData.setOriginalVideoCover(this.mOriginalThreadInfo.showPicUrl);
            this.mData.setOriginalVideoTitle(this.mOriginalThreadInfo.showText);
        }
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.hxy = true;
        }
        bIO();
    }

    private void bIX() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) w.d(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.gCi.setText(com.baidu.tbadk.plugins.b.hs(com.baidu.tbadk.plugins.b.ht(hotTopicBussinessData.mTopicName)));
            this.gCi.setMovementMethod(com.baidu.tieba.view.c.bFG());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString hs = com.baidu.tbadk.plugins.b.hs(com.baidu.tbadk.plugins.b.ht(hotTopicBussinessData.mTopicName));
            if (hs != null) {
                this.gCi.setText(hs);
            }
            this.hxT.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.mData.getType());
        bundle.putString("forum_id", this.mData.getForumId());
        bundle.putString("forum_name", this.mData.getForumName());
        bundle.putString(IntentConfig.FORUM_FIRST_DIR, this.mData.getFirstDir());
        bundle.putString(IntentConfig.FORUM_SECOND_DIR, this.mData.getSecondDir());
        bundle.putString("thread_id", this.mData.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.hxF != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hxF));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.hcf);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bIU().getEditableText().toString();
        if (obj != null) {
            bIU().setText(TbFaceManager.IU().a(getPageContext().getPageActivity(), obj, this.hxZ));
            bIU().setSelection(bIU().getText().length());
        }
    }

    private String bIY() {
        if (bIU() == null || bIU().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(bIU().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(d.k.share_video_default);
            }
            return getString(d.k.share_txt_default);
        }
        return bIU().getText().toString();
    }

    private String bIZ() {
        if (this.mData == null || bIV() == null || bIV().getVisibility() != 0 || bIV().getText() == null) {
            return "";
        }
        String obj = bIV().getText().toString();
        if (this.mPrefixData != null && w.z(this.mPrefixData.getPrefixs()) > 0 && this.gBQ != 0 && this.mData.getType() != 4 && this.gCn != null && this.gCn.getText() != null) {
            obj = this.gCn.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void bJa() {
        bti();
        this.mData.setContent(bIY());
        this.mData.setTitle(bIZ());
        if (this.hxM >= 0) {
            this.mData.setCategoryFrom(this.hxM);
        }
        if (this.hxO >= 0) {
            this.mData.setCategoryTo(this.hxO);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aNO != null && this.aNO.afw());
        this.aNP.mN(this.writeImagesInfo.size() > 0);
        if (!w.A(this.mList) && this.hxS != null && this.hxS.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hxS.mForumId));
            this.mData.setForumName(this.hxS.mForumName);
        }
        this.aNP.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.aNP.getWriteData().setVoice(null);
        this.aNP.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.jD()) {
            showToast(d.k.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(d.k.sending), this.mDialogCancelListener);
        this.aNP.startPostWrite();
    }

    private void r(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.hxF != null) {
                i2 = this.hxF.getTotalCount();
                i = this.hxF.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(d.k.write_addition_left_count), Integer.valueOf(i2 - i)));
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
                if (this.aMl != null && !this.aMl.HB()) {
                    bIU().requestFocus();
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
                            bIU().getText().insert(bIU().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                k((intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data"));
                setResult(-1, intent);
                finish();
            } else if (i == 25004) {
                if (intent != null) {
                    String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                    if (!StringUtils.isNull(stringExtra)) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.hxx) {
                            sb2.append(com.baidu.tbadk.plugins.b.aVu);
                            this.hxx = false;
                        }
                        sb2.append(stringExtra);
                        gK(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !w.A(this.mList) && !w.A(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.hxS = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.hxS);
            }
        } else if (i2 == 0) {
            if (this.aMl != null && !this.aMl.HB()) {
                this.gCm.requestFocus();
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
                        this.hxX.vu(postWriteCallBackData.getErrorString());
                        this.hxX.aB(postWriteCallBackData.getSensitiveWords());
                        this.hxX.b(this.gCi, this.gCm);
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.hxw)) {
                        bIV().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hxw)) {
                        bIU().requestFocus();
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
    public void bJb() {
        if ("1".equals(this.hcf)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.hcf)) {
            this.mData.setCanNoForum(false);
        }
        bJc();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.hcf);
        bJa();
    }

    private void bJc() {
        if (this.aMl != null) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bIV());
        HidenSoftKeyPad(this.mInputManager, bIU());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.tQ(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dkD) != null) {
                    TiebaStatic.log(new an("c12534").r("obj_locate", at.a.arM));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.k.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hxF == null) {
                    if (!d(postWriteCallBackData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        return;
                    }
                    return;
                }
                r(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aNU = i;
        if (this.aMl != null) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bJd() {
        if (!this.hxR && this.aMl != null) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.aMl.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(boolean z) {
        if (this.aMl != null) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void vH(int i) {
        if (i < this.hxD.size()) {
            for (int i2 = 0; i2 < this.hxD.size(); i2++) {
                this.hxD.get(i2).nD(false);
            }
            this.hxD.get(i).nD(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void tj(int i) {
        this.gBQ = i;
        this.gCo.setCurrentIndex(i);
        vH(i);
        this.gCn.setText(this.mPrefixData.getPrefixs().get(i));
        btq();
        com.baidu.adp.lib.g.g.a(this.gCo, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gCq.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes3.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getCurrentFocus());
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

    @Override // android.app.Activity, com.baidu.d.a.a.InterfaceC0062a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            Ia();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.hxW = z;
        if (this.hxV != null && !z) {
            this.hxV.aox();
        }
        if (this.hxY != null && !z) {
            bIG();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.hxW && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hxx = false;
            this.hxw = "";
            if ("from_content".equals(str)) {
                this.hxw = "from_content";
            } else if ("from_title".equals(str)) {
                this.hxw = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.hr(String.valueOf(charSequence.charAt(i)))) {
                nM(false);
            }
        }
    }

    public void bpv() {
        if (!w.A(this.mList)) {
            this.hxA.setVisibility(0);
            this.hxA.requestFocus();
            this.aMl.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hxA.setVisibility(8);
    }
}
