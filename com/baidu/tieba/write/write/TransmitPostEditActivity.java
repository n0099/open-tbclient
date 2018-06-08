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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
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
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.frs.x;
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
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0061a, d.a {
    private EditorTools aLp;
    private LocationModel aMS;
    private NewWriteModel aMT;
    private OriginalThreadCardView fga;
    private int gxX;
    private TextView gyu;
    private com.baidu.tieba.write.d gyv;
    private ImageView gyw;
    private View gyx;
    private TextView htA;
    List<v> htB;
    v htC;
    private int htD;
    private String htE;
    private int htF;
    private PostCategoryView htG;
    private HotTopicBussinessData htJ;
    private TextView htK;
    private com.baidu.tieba.write.editor.b htM;
    private e htP;
    private com.baidu.tieba.view.b htW;
    private LinearLayout htq;
    private LinearLayout htr;
    private View htt;
    private Toast htv;
    private AdditionData htw;
    private RelativeLayout htx;
    private TextView hty;
    private TextView htz;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String htn = "";
    private boolean hto = false;
    private WriteData mData = null;
    private boolean htp = false;
    private InputMethodManager mInputManager = null;
    private EditText gyp = null;
    private View gyq = null;
    private LinearLayout gys = null;
    private EditText gyt = null;
    private FeedBackModel hts = null;
    private ArrayList<WritePrefixItemLayout> htu = new ArrayList<>();
    private final KeyEvent cUv = new KeyEvent(0, 67);
    private View aAn = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String aMX = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aMY = 0;
    private View mRootView = null;
    private ScrollView htH = null;
    private boolean htI = false;
    private com.baidu.tbadk.core.view.a aVb = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String gYa = "2";
    private SpannableStringBuilder htL = new SpannableStringBuilder();
    private boolean htN = false;
    private final b htO = new b();
    private TbFaceManager.a htQ = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan ha(String str) {
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
            return new com.baidu.tbadk.core.view.e(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a diC = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").r("obj_locate", as.a.arj));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").r("obj_locate", as.a.arj));
        }
    };
    private final NewWriteModel.d aNh = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.htO.ax(null);
                if (z) {
                    TransmitPostEditActivity.this.bJ(z);
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
                    TransmitPostEditActivity.this.htO.vy(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.htO.ax(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.htO.b(TransmitPostEditActivity.this.gyp, TransmitPostEditActivity.this.gyt);
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.Ck());
                    if (com.baidu.tbadk.p.a.hM(tVar.Cj())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.Cj())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a aNf = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void HW() {
            TransmitPostEditActivity.this.showToast(d.k.no_network_guide);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void gP(String str) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            if (StringUtils.isNull(str)) {
                str = TransmitPostEditActivity.this.getPageContext().getString(d.k.location_fail);
            }
            transmitPostEditActivity.showToast(str);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bxD())) {
                TransmitPostEditActivity.this.b(2, true, aVar.bxD());
            } else {
                gP(null);
            }
        }
    };
    private final CustomMessageListener gLk = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.aMS.mA(false);
                    TransmitPostEditActivity.this.aMS.cn(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.aMS.mA(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener htR = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener htS = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.aLp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bIb = TransmitPostEditActivity.this.bIb();
            if (bIb >= 0 && bIb < TransmitPostEditActivity.this.gyt.getText().length()) {
                TransmitPostEditActivity.this.gyt.setSelection(bIb);
            }
        }
    };
    private boolean htT = true;
    private final View.OnFocusChangeListener gyn = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.gyp || view == TransmitPostEditActivity.this.aAn || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.htT = true;
                    TransmitPostEditActivity.this.bIc();
                    if (TransmitPostEditActivity.this.aLp != null) {
                        TransmitPostEditActivity.this.aLp.FB();
                    }
                    l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gyp);
                } else if (view == TransmitPostEditActivity.this.gyp) {
                    TransmitPostEditActivity.this.gyu.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.gyt && z) {
                TransmitPostEditActivity.this.htT = false;
                TransmitPostEditActivity.this.bIc();
                TransmitPostEditActivity.this.aLp.FB();
                l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gyt);
            }
            TransmitPostEditActivity.this.bIi();
        }
    };
    private TextWatcher htU = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String htY = "";
        private String htZ;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.htZ = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.htZ != null ? this.htZ.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bsQ();
            TransmitPostEditActivity.this.bIj();
            EditText bIu = TransmitPostEditActivity.this.bIu();
            if (editable != null && bIu != null && bIu.getText() != null) {
                if (this.htY == null || !this.htY.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.htO != null) {
                        this.htY = bIu.getText().toString();
                        TransmitPostEditActivity.this.htO.k(bIu);
                        return;
                    }
                    return;
                }
                bIu.setSelection(bIu.getSelectionEnd());
            }
        }
    };
    private TextWatcher htV = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String htZ;
        private String hua = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.htZ = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.htZ != null ? this.htZ.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bsQ();
            EditText bIt = TransmitPostEditActivity.this.bIt();
            if (editable != null && bIt != null && bIt.getText() != null) {
                int selectionEnd = bIt.getSelectionEnd();
                if (this.hua == null || !this.hua.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.htO != null) {
                        this.hua = bIt.getText().toString();
                        TransmitPostEditActivity.this.htO.k(bIt);
                        return;
                    }
                    return;
                }
                bIt.setSelection(selectionEnd);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ao.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HH() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void HI() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.k.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            HK();
        } else if (this.aMS.bxL()) {
            HH();
        } else {
            this.aMS.mA(false);
            b(1, true, null);
            this.aMS.bxJ();
        }
    }

    private void HK() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cc(d.k.location_app_permission_prompt).a(d.k.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.jD()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.aMS.aeS();
                } else {
                    TransmitPostEditActivity.this.aNf.HW();
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
        aVar.xa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bIb() {
        int selectionEnd = bIt().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bIt().getText().getSpans(0, bIt().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bIt().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bIt().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIc() {
        if (this.aLp != null) {
            this.aLp.setBarLauncherEnabled(!this.htT);
            this.aLp.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.htI) {
            this.gyp.setVisibility(8);
            bsQ();
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
        this.aMS = new LocationModel(this);
        this.aMS.a(this.aNf);
        registerListener(this.gLk);
        registerListener(this.htR);
        initEditor();
        this.gyt.requestFocus();
        boU();
        bIC();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aLp = new EditorTools(getActivity());
        this.aLp.setBarMaxLauCount(4);
        this.aLp.setMoreButtonAtEnd(true);
        this.aLp.setBarLauncherType(1);
        this.aLp.bB(true);
        this.aLp.bC(true);
        this.aLp.setMoreLauncherIcon(d.f.write_more);
        this.aLp.setBackgroundColorId(d.C0141d.cp_bg_line_d);
        bId();
        this.aLp.Hh();
        if (this.htq != null) {
            this.htq.addView(this.aLp);
        }
        bIe();
        this.aLp.oD();
        com.baidu.tbadk.editortools.g eJ = this.aLp.eJ(6);
        if (eJ != null && !TextUtils.isEmpty(this.aMX)) {
            ((View) eJ).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.aMX);
                }
            });
        }
        if (!this.htI) {
            this.aLp.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aLp.FB();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aLp.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aLp.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
        bIg();
    }

    private void bId() {
        com.baidu.tbadk.editortools.k kVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 2);
        aVar.aLW = d.f.write_at;
        this.aLp.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.aLp.b(aVar2);
        aVar2.aLW = d.f.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask != null && (kVar = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar.aLY = 4;
            kVar.aLW = d.f.icon_post_location_selector;
            this.aLp.b(kVar);
        }
        if (this.htw == null) {
            if (this.htM == null) {
                this.htM = new com.baidu.tieba.write.editor.b(getActivity(), this.gYa);
                this.htM.bHg();
                this.htM.setFrom("from_share_write");
                this.htM.aS(this.mData.getForumId(), this.mPrivateThread);
            }
            this.aLp.b(this.htM);
        }
        this.aLp.F(arrayList);
        com.baidu.tbadk.editortools.k eM = this.aLp.eM(5);
        if (eM != null) {
            eM.aLY = 1;
            eM.aLW = d.f.write_emotion;
        }
    }

    private void bIe() {
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
                            TiebaStatic.log(new am("c12608").r("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.bIs()) {
                            TransmitPostEditActivity.this.showToast(d.k.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.bIs()) {
                            TransmitPostEditActivity.this.showToast(d.k.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            TransmitPostEditActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.bIv();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.bsQ();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.htw == null) {
                            TransmitPostEditActivity.this.HL();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.aMY) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ac.aM(pageActivity)) {
                                    TransmitPostEditActivity.this.HI();
                                    return;
                                } else {
                                    ac.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.HH();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.aMS != null) {
                            TransmitPostEditActivity.this.aMS.mA(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        am amVar = new am("c10645");
                        if (TransmitPostEditActivity.this.mData != null) {
                            str = TransmitPostEditActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        amVar.ah(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(amVar);
                        if (TransmitPostEditActivity.this.mData == null || (videoInfo = TransmitPostEditActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.aLp.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.aLp.Hj()) {
                                        TransmitPostEditActivity.this.aLp.FB();
                                        TransmitPostEditActivity.this.aLp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.aLp.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.aLp.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.aLp.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.aLp.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.bsQ();
                        if (TransmitPostEditActivity.this.gyt != null) {
                            TransmitPostEditActivity.this.gyt.requestFocus();
                        }
                        TransmitPostEditActivity.this.aLp.FB();
                        TransmitPostEditActivity.this.aLp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gyt);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.aLp.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.hto = true;
                        TransmitPostEditActivity.this.nE(true);
                        if (TransmitPostEditActivity.this.bIu().isFocused()) {
                            TransmitPostEditActivity.this.htn = "from_title";
                        } else if (TransmitPostEditActivity.this.bIt().isFocused()) {
                            TransmitPostEditActivity.this.htn = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.htr.setVisibility(0);
                        TransmitPostEditActivity.this.htr.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.htr.hasFocus()) {
                            TransmitPostEditActivity.this.gyt.requestFocus();
                            TransmitPostEditActivity.this.gyt.setSelection(TransmitPostEditActivity.this.gyt.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.htr.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aLp.setActionListener(31, bVar);
        this.aLp.setActionListener(16, bVar);
        this.aLp.setActionListener(14, bVar);
        this.aLp.setActionListener(24, bVar);
        this.aLp.setActionListener(3, bVar);
        this.aLp.setActionListener(10, bVar);
        this.aLp.setActionListener(11, bVar);
        this.aLp.setActionListener(12, bVar);
        this.aLp.setActionListener(13, bVar);
        this.aLp.setActionListener(15, bVar);
        this.aLp.setActionListener(18, bVar);
        this.aLp.setActionListener(20, bVar);
        this.aLp.setActionListener(25, bVar);
        this.aLp.setActionListener(27, bVar);
        this.aLp.setActionListener(29, bVar);
        this.aLp.setActionListener(43, bVar);
        this.aLp.setActionListener(45, bVar);
        this.aLp.setActionListener(53, bVar);
        this.aLp.setActionListener(48, bVar);
        this.aLp.setActionListener(46, bVar);
        this.aLp.setActionListener(49, bVar);
        this.aLp.setActionListener(47, bVar);
        this.aLp.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HL() {
        if (this.aMS.aeO()) {
            if (this.aMS.bxL()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bxH().getLocationData().bxD());
                return;
            }
            b(1, true, null);
            this.aMS.bxJ();
            return;
        }
        b(0, true, null);
    }

    protected void bsI() {
        if (this.aMT != null) {
            this.aMT.cancelLoadData();
        }
        if (this.hts != null) {
            this.hts.cancelLoadData();
        }
        if (this.aMS != null) {
            this.aMS.cancelLoadData();
        }
    }

    private void bIf() {
        if (this.htP != null) {
            this.htP.hideTip();
        }
    }

    private void bIg() {
        if (this.htP == null) {
            this.htP = new e(getPageContext());
        }
        this.htP.c(this.aLp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bIf();
        TiebaPrepareImageService.StopService();
        bsI();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIh() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(bIu().getText().toString());
        this.mData.setContent(bIt().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.gyv != null && this.gyv.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gyv, getPageContext().getPageActivity());
                return true;
            } else if (this.aLp.Hj()) {
                this.aLp.FB();
                return true;
            } else {
                bsI();
                bIh();
                return true;
            }
        }
        if (i == 67 && (text = bIt().getText()) != null) {
            int selectionStart = bIt().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bIt().onKeyDown(67, this.cUv);
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
        al.c(this.mPost, d.C0141d.cp_link_tip_a, 1);
        bIc();
        al.j(this.gyq, d.C0141d.cp_bg_line_c);
        al.j(bIu(), d.C0141d.cp_bg_line_d);
        al.j(bIt(), d.C0141d.cp_bg_line_d);
        bsQ();
        this.aLp.onChangeSkinType(i);
        if (this.htG != null) {
            this.htG.Ay();
        }
        al.h(this.mName, d.C0141d.cp_cont_b);
        bIi();
        bIj();
        if (this.htO != null) {
            this.htO.c(bIu(), bIt());
        }
        this.fga.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIi() {
        if (this.gyp.hasFocus()) {
            this.gyp.setHintTextColor(al.getColor(d.C0141d.cp_cont_e));
        } else {
            this.gyp.setHintTextColor(al.getColor(d.C0141d.cp_cont_d));
        }
        if (this.gyt.hasFocus()) {
            this.gyt.setHintTextColor(al.getColor(d.C0141d.cp_cont_e));
        } else {
            this.gyt.setHintTextColor(al.getColor(d.C0141d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIj() {
        if (this.gyp != null) {
            if (this.gyp.getText().toString().length() == 0) {
                this.gyp.getPaint().setFakeBoldText(false);
            } else if (this.gyp.getText().toString().length() > 0) {
                this.gyp.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.aVb = new com.baidu.tbadk.core.view.a(getPageContext());
        this.htI = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.i.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aAn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        al.h(this.mName, d.C0141d.cp_cont_b);
        bIl();
        this.htH = (ScrollView) findViewById(d.g.write_scrollview);
        this.htH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.gyt != null) {
                        l.b(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.gyt);
                    }
                    if (TransmitPostEditActivity.this.aLp != null) {
                        TransmitPostEditActivity.this.aLp.FB();
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
        this.htq = (LinearLayout) findViewById(d.g.tool_view);
        this.htq.setContentDescription("..");
        this.htr = (LinearLayout) findViewById(d.g.title_view);
        this.gyq = findViewById(d.g.interval_view);
        this.htK = (TextView) findViewById(d.g.hot_topic_title_edt);
        bsP();
        if (this.htI) {
            this.htH.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        bsR();
        bIr();
        this.gys = (LinearLayout) findViewById(d.g.post_content_container);
        this.gys.setDrawingCacheEnabled(false);
        this.gys.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.aLp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.gyt.requestFocus();
            }
        });
        this.aAn.setOnFocusChangeListener(this.gyn);
        this.aAn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.bsI();
                TransmitPostEditActivity.this.bIh();
            }
        });
        bIo();
        bIq();
        bIk();
        bIc();
        bIp();
        bsO();
        bIw();
        if (this.mData.getType() == 4 && this.gyx != null && this.htt != null) {
            this.gyx.setVisibility(8);
            this.htt.setVisibility(8);
        }
        bsQ();
        ShowSoftKeyPad(this.mInputManager, this.gyp);
    }

    private void bIk() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.gYa != null && this.gYa.equals("1")) {
                        this.mName.setText(d.k.share_to_home_page);
                    } else if (this.gYa != null && this.gYa.equals("2")) {
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
                    this.gyp.setVisibility(0);
                    this.gyt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(d.k.publish_photo_live);
                    this.gyt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(d.k.send_reply);
                    this.gyt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gyp.setVisibility(8);
                    return;
            }
        }
    }

    private void bIl() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.e(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.gyn);
    }

    private void bIm() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.htp && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = ao.d(this.mPostTopicData.getTitleTopic(), 31, (String) null);
            if (!StringUtils.isNull(d) && bIu() != null) {
                bIu().setText(d);
                bIu().setSelection(d.length());
            }
        }
    }

    private void bIn() {
        this.htB = null;
        this.htD = -1;
        this.htF = -1;
        x ko = w.auJ().ko(1);
        if (ko != null) {
            this.htB = ko.dkz;
            this.htD = getIntent().getIntExtra("category_id", -1);
            if (this.htB != null && !this.htB.isEmpty() && this.htD >= 0) {
                this.htC = new v();
                this.htC.dkv = 0;
                this.htC.name = getPageContext().getResources().getString(d.k.category_auto);
                this.htF = this.htC.dkv;
                this.htE = this.htC.name;
                for (v vVar : this.htB) {
                    if (vVar.dkv == this.htD) {
                        this.htF = vVar.dkv;
                        this.htE = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bIo() {
        if (this.htB != null && !this.htB.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.htG = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.htG.setText(this.htE);
            this.htG.setCategoryContainerData(this.htB, this.htC, this.htF);
            this.htG.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ar arVar) {
                    if (arVar != null) {
                        TransmitPostEditActivity.this.htG.setText(arVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(arVar.dkv);
                        TransmitPostEditActivity.this.htF = arVar.dkv;
                        TransmitPostEditActivity.this.htG.bHQ();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.htG.bHP();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIu());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIt());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.htW = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.htW.setTitle(d.k.no_disturb_start_time);
        this.htW.setButton(-1, getPageContext().getString(d.k.alert_yes_button), this.htW);
        this.htW.setButton(-2, getPageContext().getString(d.k.cancel), this.htW);
        return this.htW;
    }

    private void bIp() {
        this.htx = (RelativeLayout) findViewById(d.g.addition_container);
        this.hty = (TextView) findViewById(d.g.addition_create_time);
        this.htz = (TextView) findViewById(d.g.addition_last_time);
        this.htA = (TextView) findViewById(d.g.addition_last_content);
        if (this.htw != null) {
            this.htx.setVisibility(0);
            this.hty.setText(getPageContext().getString(d.k.write_addition_create) + ao.v(this.htw.getCreateTime() * 1000));
            if (this.htw.getAlreadyCount() == 0) {
                this.htz.setVisibility(8);
            } else {
                this.htz.setText(getPageContext().getString(d.k.write_addition_last) + ao.v(this.htw.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.htw.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.htA.setText(lastAdditionContent);
            } else {
                this.htA.setVisibility(8);
            }
            bIt().setHint(String.format(getPageContext().getString(d.k.write_addition_hint), Integer.valueOf(this.htw.getAlreadyCount()), Integer.valueOf(this.htw.getTotalCount())));
            this.mName.setText(d.k.write_addition_title);
            return;
        }
        this.htx.setVisibility(8);
    }

    private void bsO() {
        this.gyx = findViewById(d.g.post_prefix_layout);
        this.gyu = (TextView) findViewById(d.g.post_prefix);
        this.htt = findViewById(d.g.prefix_divider);
        this.gyw = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gyx.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gxX = 1;
            this.gyx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.gyu.setVisibility(0);
                    TransmitPostEditActivity.this.gyx.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gyv, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.aLp.FB();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gyp);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gyt);
                }
            });
            this.gyw = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gyw.setVisibility(0);
                this.gyu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.gyu.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gyv, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.aLp.FB();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIu());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIt());
                    }
                });
            }
            this.gyv = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.gyv.a(this);
            this.gyv.setMaxHeight(l.e(getActivity(), d.e.ds510));
            this.gyv.setOutsideTouchable(true);
            this.gyv.setFocusable(true);
            this.gyv.setOnDismissListener(this);
            this.gyv.setBackgroundDrawable(al.getDrawable(d.C0141d.cp_bg_line_d));
            int color = al.getColor(d.C0141d.cp_cont_b);
            int color2 = al.getColor(d.C0141d.cp_cont_c);
            al.i(this.gyu, d.C0141d.cp_bg_line_d);
            al.c(this.gyw, d.f.icon_frs_arrow_n);
            this.gyu.setTextColor(color);
            this.htu.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.htu.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.gyv.addView(writePrefixItemLayout);
            }
            this.gyv.setCurrentIndex(0);
            this.gyu.setText(prefixs.get(1));
            vy(1);
            return;
        }
        this.gyx.setVisibility(8);
    }

    protected void bIq() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.jD()) {
                    TransmitPostEditActivity.this.showToast(d.k.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.htO.a(TransmitPostEditActivity.this.gyp, TransmitPostEditActivity.this.gyt)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.htO.bGc());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIu());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIt());
                    TransmitPostEditActivity.this.aLp.FB();
                    TiebaStatic.log(new am("c12608").r("obj_locate", 7));
                    TransmitPostEditActivity.this.bIA();
                }
            }
        });
    }

    protected void bsP() {
        this.gyp = (EditText) findViewById(d.g.post_title);
        this.gyp.setOnClickListener(this.htS);
        this.gyp.setOnFocusChangeListener(this.gyn);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.gyp.setText(this.mData.getTitle());
            this.gyp.setSelection(this.mData.getTitle().length());
        }
        this.gyp.addTextChangedListener(this.htU);
        if (!this.mData.getHaveDraft()) {
            bIm();
        }
        this.gyp.setHint(getResources().getString(d.k.post_title_hint));
    }

    protected void bsR() {
        this.gyt = (EditText) findViewById(d.g.post_content);
        this.gyt.setDrawingCacheEnabled(false);
        this.gyt.setOnClickListener(this.htS);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString U = TbFaceManager.IC().U(getPageContext().getPageActivity(), this.mData.getContent());
            this.gyt.setText(U);
            this.gyt.setSelection(U.length());
        }
        this.gyt.setOnFocusChangeListener(this.gyn);
        this.gyt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.aLp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.gyt.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gyt.addTextChangedListener(this.htV);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.gyt.setHint(d.k.share_video_default);
        } else {
            this.gyt.setHint(d.k.share_txt_default);
        }
    }

    private void bIr() {
        this.fga = (OriginalThreadCardView) findViewById(d.g.write_original_thread_cardview);
        this.fga.setVisibility(0);
        this.fga.b(this.mOriginalThreadInfo);
        this.fga.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIs() {
        int i = 5000;
        if (this.htw != null) {
            i = 1000;
        }
        return bIt().getText() != null && bIt().getText().length() >= i;
    }

    private void gG(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.htn)) {
                this.htn = "";
                bIt().requestFocus();
                if (bIt().getText() != null && bIt().getText().length() + str.length() > 5000) {
                    showToast(d.k.over_limit_tip);
                    return;
                } else {
                    i = bIt().getSelectionStart();
                    editable = bIt().getText();
                }
            } else if ("from_title".equals(this.htn)) {
                this.htn = "";
                bIu().requestFocus();
                if (bIu().getText() != null && bIu().getText().length() + str.length() > 31) {
                    showToast(d.k.over_limit_tip);
                    return;
                } else {
                    i = bIu().getSelectionStart();
                    editable = bIu().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nE(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void d(n nVar) {
        if (((ImageSpan[]) bIt().getText().getSpans(0, bIt().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.htv == null) {
                this.htv = Toast.makeText(getPageContext().getPageActivity(), d.k.too_many_face, 0);
            }
            this.htv.show();
            return;
        }
        String name = nVar.getName();
        final EmotionGroupType Cb = nVar.Cb();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.ig().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.bIt().getSelectionStart(), aVar, Cb);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bIt() != null && bIt().getText() != null) {
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
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.e(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bIt().getSelectionStart() - 1;
                if (bIt().getText().length() > 1 && selectionStart >= 0 && bIt().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bIt().getText().insert(bIt().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bIt().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bIt().getText().insert(bIt().getSelectionStart(), spannableString2);
            }
            Editable text = bIt().getText();
            if (text != null) {
                this.htL.clear();
                this.htL.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.htL);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bIt().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bIt().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bIt().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bIt() {
        return this.gyt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bIu() {
        return this.gyp;
    }

    protected void bIv() {
        Editable text;
        if (bIt() != null && (text = bIt().getText()) != null) {
            int selectionStart = bIt().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bIt().onKeyDown(67, this.cUv);
            }
            bIt().onKeyDown(67, this.cUv);
            int selectionStart2 = bIt().getSelectionStart();
            this.htL.clear();
            this.htL.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.htL);
            bIt().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aVb.d(null);
        this.aVb.dc(d.k.sending);
        this.aVb.aM(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aVb.aM(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsQ() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bIu() != null) {
                str = bIu().getText().toString();
            }
            if (bIt() != null) {
                str2 = bIt().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.gxX == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            nF(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        nF(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    nF(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.htI) {
                    nF(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    nF(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                nF(true);
            } else if (this.mData.getVideoInfo() != null) {
                nF(true);
            } else {
                nF(false);
            }
        }
    }

    private void nF(boolean z) {
        al.b(this.mPost, d.C0141d.cp_link_tip_a, d.C0141d.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.aMT = new NewWriteModel(this);
        this.aMT.b(this.aNh);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.bsI();
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
                this.htw = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.htw != null);
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
            this.gYa = bundle.getString("KEY_CALL_FROM");
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
            this.htw = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.htw != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.gYa = intent.getStringExtra("KEY_CALL_FROM");
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
            this.htp = true;
        }
        bIn();
    }

    private void bIw() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.w.c(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.gyp.setText(com.baidu.tbadk.plugins.b.ho(com.baidu.tbadk.plugins.b.hp(hotTopicBussinessData.mTopicName)));
            this.gyp.setMovementMethod(com.baidu.tieba.view.c.bFg());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString ho = com.baidu.tbadk.plugins.b.ho(com.baidu.tbadk.plugins.b.hp(hotTopicBussinessData.mTopicName));
            if (ho != null) {
                this.gyp.setText(ho);
            }
            this.htK.setText(hotTopicBussinessData.mForumName);
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
        if (this.htw != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.htw));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.gYa);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bIt().getEditableText().toString();
        if (obj != null) {
            bIt().setText(TbFaceManager.IC().a(getPageContext().getPageActivity(), obj, this.htQ));
            bIt().setSelection(bIt().getText().length());
        }
    }

    private String bIx() {
        if (bIt() == null || bIt().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(bIt().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(d.k.share_video_default);
            }
            return getString(d.k.share_txt_default);
        }
        return bIt().getText().toString();
    }

    private String bIy() {
        if (this.mData == null || bIu() == null || bIu().getVisibility() != 0 || bIu().getText() == null) {
            return "";
        }
        String obj = bIu().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.w.y(this.mPrefixData.getPrefixs()) > 0 && this.gxX != 0 && this.mData.getType() != 4 && this.gyu != null && this.gyu.getText() != null) {
            obj = this.gyu.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void bIz() {
        bsI();
        this.mData.setContent(bIx());
        this.mData.setTitle(bIy());
        if (this.htD >= 0) {
            this.mData.setCategoryFrom(this.htD);
        }
        if (this.htF >= 0) {
            this.mData.setCategoryTo(this.htF);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aMS != null && this.aMS.aeO());
        this.aMT.mC(this.writeImagesInfo.size() > 0);
        if (!com.baidu.tbadk.core.util.w.z(this.mList) && this.htJ != null && this.htJ.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.htJ.mForumId));
            this.mData.setForumName(this.htJ.mForumName);
        }
        this.aMT.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.aMT.getWriteData().setVoice(null);
        this.aMT.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.jD()) {
            showToast(d.k.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(d.k.sending), this.mDialogCancelListener);
        this.aMT.startPostWrite();
    }

    private void r(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.htw != null) {
                i2 = this.htw.getTotalCount();
                i = this.htw.getAlreadyCount() + 1;
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
                if (this.aLp != null && !this.aLp.Hj()) {
                    bIt().requestFocus();
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
                            bIt().getText().insert(bIt().getSelectionStart(), sb.toString());
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
                        if (this.hto) {
                            sb2.append(com.baidu.tbadk.plugins.b.aUy);
                            this.hto = false;
                        }
                        sb2.append(stringExtra);
                        gG(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.w.z(this.mList) && !com.baidu.tbadk.core.util.w.z(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.htJ = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.htJ);
            }
        } else if (i2 == 0) {
            if (this.aLp != null && !this.aLp.Hj()) {
                this.gyt.requestFocus();
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
                        this.htO.vy(postWriteCallBackData.getErrorString());
                        this.htO.ax(postWriteCallBackData.getSensitiveWords());
                        this.htO.b(this.gyp, this.gyt);
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.htn)) {
                        bIu().requestFocus();
                        return;
                    } else if ("from_content".equals(this.htn)) {
                        bIt().requestFocus();
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
    public void bIA() {
        if ("1".equals(this.gYa)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.gYa)) {
            this.mData.setCanNoForum(false);
        }
        bIB();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.gYa);
        bIz();
    }

    private void bIB() {
        if (this.aLp != null) {
            this.aLp.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bIu());
        HidenSoftKeyPad(this.mInputManager, bIt());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.tE(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.diC) != null) {
                    TiebaStatic.log(new am("c12534").r("obj_locate", as.a.arj));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.k.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.htw == null) {
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
        this.aMY = i;
        if (this.aLp != null) {
            this.aLp.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bIC() {
        if (!this.htI && this.aLp != null) {
            this.aLp.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.aLp.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(boolean z) {
        if (this.aLp != null) {
            this.aLp.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void vy(int i) {
        if (i < this.htu.size()) {
            for (int i2 = 0; i2 < this.htu.size(); i2++) {
                this.htu.get(i2).nv(false);
            }
            this.htu.get(i).nv(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void sZ(int i) {
        this.gxX = i;
        this.gyv.setCurrentIndex(i);
        vy(i);
        this.gyu.setText(this.mPrefixData.getPrefixs().get(i));
        bsQ();
        com.baidu.adp.lib.g.g.a(this.gyv, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gyx.setSelected(false);
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

    @Override // android.app.Activity, com.baidu.d.a.a.InterfaceC0061a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            HI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.htN = z;
        if (this.htM != null && !z) {
            this.htM.apc();
        }
        if (this.htP != null && !z) {
            bIf();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.htN && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hto = false;
            this.htn = "";
            if ("from_content".equals(str)) {
                this.htn = "from_content";
            } else if ("from_title".equals(str)) {
                this.htn = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.hn(String.valueOf(charSequence.charAt(i)))) {
                nE(false);
            }
        }
    }

    public void boU() {
        if (!com.baidu.tbadk.core.util.w.z(this.mList)) {
            this.htr.setVisibility(0);
            this.htr.requestFocus();
            this.aLp.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.htr.setVisibility(8);
    }
}
