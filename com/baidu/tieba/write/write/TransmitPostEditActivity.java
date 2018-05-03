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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
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
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0045a, d.a {
    private EditorTools aCS;
    private LocationModel aEv;
    private NewWriteModel aEw;
    private OriginalThreadCardView eTB;
    private TextView glQ;
    private com.baidu.tieba.write.d glR;
    private ImageView glS;
    private View glT;
    private int glt;
    private TextView hgA;
    List<v> hgB;
    v hgC;
    private int hgD;
    private String hgE;
    private int hgF;
    private PostCategoryView hgG;
    private HotTopicBussinessData hgJ;
    private TextView hgK;
    private com.baidu.tieba.write.editor.b hgM;
    private e hgP;
    private com.baidu.tieba.view.b hgW;
    private LinearLayout hgq;
    private LinearLayout hgr;
    private View hgt;
    private Toast hgv;
    private AdditionData hgw;
    private RelativeLayout hgx;
    private TextView hgy;
    private TextView hgz;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String hgn = "";
    private boolean hgo = false;
    private WriteData mData = null;
    private boolean hgp = false;
    private InputMethodManager mInputManager = null;
    private EditText glL = null;
    private View glM = null;
    private LinearLayout glO = null;
    private EditText glP = null;
    private FeedBackModel hgs = null;
    private ArrayList<WritePrefixItemLayout> hgu = new ArrayList<>();
    private final KeyEvent cKg = new KeyEvent(0, 67);
    private View asg = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String aEA = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aEB = 0;
    private View mRootView = null;
    private ScrollView hgH = null;
    private boolean hgI = false;
    private com.baidu.tbadk.core.view.a aNc = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String gLv = "2";
    private SpannableStringBuilder hgL = new SpannableStringBuilder();
    private boolean hgN = false;
    private final b hgO = new b();
    private TbFaceManager.a hgQ = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan gC(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.km());
            int width = aVar.getWidth();
            if (str.startsWith("#(meme,")) {
                bitmapDrawable.setBounds(0, 0, width, aVar.getHeight());
            } else {
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            return new com.baidu.tbadk.core.view.d(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a cYe = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new al("c12536").r("obj_locate", ar.a.ajb));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new al("c12535").r("obj_locate", ar.a.ajb));
        }
    };
    private final NewWriteModel.d aEK = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.hgO.ax(null);
                if (z) {
                    TransmitPostEditActivity.this.bF(z);
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
                    TransmitPostEditActivity.this.hgO.uB(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.hgO.ax(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.hgO.b(TransmitPostEditActivity.this.glL, TransmitPostEditActivity.this.glP);
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.yL());
                    if (com.baidu.tbadk.p.a.hq(tVar.yK())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.yK())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a aEI = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void Eu() {
            TransmitPostEditActivity.this.showToast(d.k.no_network_guide);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void gq(String str) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            if (StringUtils.isNull(str)) {
                str = TransmitPostEditActivity.this.getPageContext().getString(d.k.location_fail);
            }
            transmitPostEditActivity.showToast(str);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bsA())) {
                TransmitPostEditActivity.this.b(2, true, aVar.bsA());
            } else {
                gq(null);
            }
        }
    };
    private final CustomMessageListener gyE = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.aEv.mt(false);
                    TransmitPostEditActivity.this.aEv.cf(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.aEv.mt(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hgR = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hgS = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            TransmitPostEditActivity.this.aCS.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bCY = TransmitPostEditActivity.this.bCY();
            if (bCY >= 0 && bCY < TransmitPostEditActivity.this.glP.getText().length()) {
                TransmitPostEditActivity.this.glP.setSelection(bCY);
            }
        }
    };
    private boolean hgT = true;
    private final View.OnFocusChangeListener glJ = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            if (view2 == TransmitPostEditActivity.this.glL || view2 == TransmitPostEditActivity.this.asg || view2 == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.hgT = true;
                    TransmitPostEditActivity.this.bCZ();
                    if (TransmitPostEditActivity.this.aCS != null) {
                        TransmitPostEditActivity.this.aCS.Ca();
                    }
                    l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.glL);
                } else if (view2 == TransmitPostEditActivity.this.glL) {
                    TransmitPostEditActivity.this.glQ.setVisibility(0);
                }
            }
            if (view2 == TransmitPostEditActivity.this.glP && z) {
                TransmitPostEditActivity.this.hgT = false;
                TransmitPostEditActivity.this.bCZ();
                TransmitPostEditActivity.this.aCS.Ca();
                l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.glP);
            }
            TransmitPostEditActivity.this.bDf();
        }
    };
    private TextWatcher hgU = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String hgY = "";
        private String hgZ;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hgZ = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hgZ != null ? this.hgZ.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bnS();
            TransmitPostEditActivity.this.bDg();
            EditText bDr = TransmitPostEditActivity.this.bDr();
            if (editable != null && bDr != null && bDr.getText() != null) {
                if (this.hgY == null || !this.hgY.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.hgO != null) {
                        this.hgY = bDr.getText().toString();
                        TransmitPostEditActivity.this.hgO.k(bDr);
                        return;
                    }
                    return;
                }
                bDr.setSelection(bDr.getSelectionEnd());
            }
        }
    };
    private TextWatcher hgV = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String hgZ;
        private String hha = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hgZ = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hgZ != null ? this.hgZ.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bnS();
            EditText bDq = TransmitPostEditActivity.this.bDq();
            if (editable != null && bDq != null && bDq.getText() != null) {
                int selectionEnd = bDq.getSelectionEnd();
                if (this.hha == null || !this.hha.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.hgO != null) {
                        this.hha = bDq.getText().toString();
                        TransmitPostEditActivity.this.hgO.k(bDq);
                        return;
                    }
                    return;
                }
                bDq.setSelection(selectionEnd);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || an.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eg() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Eh() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.k.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Ei();
        } else if (this.aEv.bsI()) {
            Eg();
        } else {
            this.aEv.mt(false);
            b(1, true, null);
            this.aEv.bsG();
        }
    }

    private void Ei() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bZ(d.k.location_app_permission_prompt).a(d.k.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.gP()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.aEv.abs();
                } else {
                    TransmitPostEditActivity.this.aEI.Eu();
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
        aVar.tD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bCY() {
        int selectionEnd = bDq().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bDq().getText().getSpans(0, bDq().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bDq().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bDq().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCZ() {
        if (this.aCS != null) {
            this.aCS.setBarLauncherEnabled(!this.hgT);
            this.aCS.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hgI) {
            this.glL.setVisibility(8);
            bnS();
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
        this.aEv = new LocationModel(this);
        this.aEv.a(this.aEI);
        registerListener(this.gyE);
        registerListener(this.hgR);
        initEditor();
        this.glP.requestFocus();
        bjW();
        bDz();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aCS = new EditorTools(getActivity());
        this.aCS.setBarMaxLauCount(4);
        this.aCS.setMoreButtonAtEnd(true);
        this.aCS.setBarLauncherType(1);
        this.aCS.bx(true);
        this.aCS.by(true);
        this.aCS.setMoreLauncherIcon(d.f.write_more);
        this.aCS.setBackgroundColorId(d.C0126d.cp_bg_line_d);
        bDa();
        this.aCS.DG();
        if (this.hgq != null) {
            this.hgq.addView(this.aCS);
        }
        bDb();
        this.aCS.lN();
        com.baidu.tbadk.editortools.g eE = this.aCS.eE(6);
        if (eE != null && !TextUtils.isEmpty(this.aEA)) {
            ((View) eE).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.aEA);
                }
            });
        }
        if (!this.hgI) {
            this.aCS.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aCS.Ca();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aCS.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aCS.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
        bDd();
    }

    private void bDa() {
        com.baidu.tbadk.editortools.k kVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 2);
        aVar.aDz = d.f.write_at;
        this.aCS.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.aCS.b(aVar2);
        aVar2.aDz = d.f.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask != null && (kVar = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar.aDB = 4;
            kVar.aDz = d.f.icon_post_location_selector;
            this.aCS.b(kVar);
        }
        if (this.hgw == null) {
            if (this.hgM == null) {
                this.hgM = new com.baidu.tieba.write.editor.b(getActivity(), this.gLv);
                this.hgM.bCc();
                this.hgM.setFrom("from_share_write");
                this.hgM.aP(this.mData.getForumId(), this.mPrivateThread);
            }
            this.aCS.b(this.hgM);
        }
        this.aCS.C(arrayList);
        com.baidu.tbadk.editortools.k eH = this.aCS.eH(5);
        if (eH != null) {
            eH.aDB = 1;
            eH.aDz = d.f.write_emotion;
        }
    }

    private void bDb() {
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
                            TiebaStatic.log(new al("c12608").r("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.bDp()) {
                            TransmitPostEditActivity.this.showToast(d.k.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.bDp()) {
                            TransmitPostEditActivity.this.showToast(d.k.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            TransmitPostEditActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.bDs();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.bnS();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.hgw == null) {
                            TransmitPostEditActivity.this.Ej();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.aEB) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.aC(pageActivity)) {
                                    TransmitPostEditActivity.this.Eh();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.Eg();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.aEv != null) {
                            TransmitPostEditActivity.this.aEv.mt(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        al alVar = new al("c10645");
                        if (TransmitPostEditActivity.this.mData != null) {
                            str = TransmitPostEditActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        alVar.ac(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(alVar);
                        if (TransmitPostEditActivity.this.mData == null || (videoInfo = TransmitPostEditActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.aCS.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.aCS.DI()) {
                                        TransmitPostEditActivity.this.aCS.Ca();
                                        TransmitPostEditActivity.this.aCS.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.aCS.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.aCS.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.aCS.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.aCS.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.bnS();
                        if (TransmitPostEditActivity.this.glP != null) {
                            TransmitPostEditActivity.this.glP.requestFocus();
                        }
                        TransmitPostEditActivity.this.aCS.Ca();
                        TransmitPostEditActivity.this.aCS.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.glP);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.aCS.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.hgo = true;
                        TransmitPostEditActivity.this.nv(true);
                        if (TransmitPostEditActivity.this.bDr().isFocused()) {
                            TransmitPostEditActivity.this.hgn = "from_title";
                        } else if (TransmitPostEditActivity.this.bDq().isFocused()) {
                            TransmitPostEditActivity.this.hgn = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.hgr.setVisibility(0);
                        TransmitPostEditActivity.this.hgr.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.hgr.hasFocus()) {
                            TransmitPostEditActivity.this.glP.requestFocus();
                            TransmitPostEditActivity.this.glP.setSelection(TransmitPostEditActivity.this.glP.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.hgr.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aCS.setActionListener(31, bVar);
        this.aCS.setActionListener(16, bVar);
        this.aCS.setActionListener(14, bVar);
        this.aCS.setActionListener(24, bVar);
        this.aCS.setActionListener(3, bVar);
        this.aCS.setActionListener(10, bVar);
        this.aCS.setActionListener(11, bVar);
        this.aCS.setActionListener(12, bVar);
        this.aCS.setActionListener(13, bVar);
        this.aCS.setActionListener(15, bVar);
        this.aCS.setActionListener(18, bVar);
        this.aCS.setActionListener(20, bVar);
        this.aCS.setActionListener(25, bVar);
        this.aCS.setActionListener(27, bVar);
        this.aCS.setActionListener(29, bVar);
        this.aCS.setActionListener(43, bVar);
        this.aCS.setActionListener(45, bVar);
        this.aCS.setActionListener(53, bVar);
        this.aCS.setActionListener(48, bVar);
        this.aCS.setActionListener(46, bVar);
        this.aCS.setActionListener(49, bVar);
        this.aCS.setActionListener(47, bVar);
        this.aCS.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ej() {
        if (this.aEv.abo()) {
            if (this.aEv.bsI()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bsE().getLocationData().bsA());
                return;
            }
            b(1, true, null);
            this.aEv.bsG();
            return;
        }
        b(0, true, null);
    }

    protected void bnK() {
        if (this.aEw != null) {
            this.aEw.cancelLoadData();
        }
        if (this.hgs != null) {
            this.hgs.cancelLoadData();
        }
        if (this.aEv != null) {
            this.aEv.cancelLoadData();
        }
    }

    private void bDc() {
        if (this.hgP != null) {
            this.hgP.hideTip();
        }
    }

    private void bDd() {
        if (this.hgP == null) {
            this.hgP = new e(getPageContext());
        }
        this.hgP.c(this.aCS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bDc();
        TiebaPrepareImageService.StopService();
        bnK();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDe() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(bDr().getText().toString());
        this.mData.setContent(bDq().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.glR != null && this.glR.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.glR, getPageContext().getPageActivity());
                return true;
            } else if (this.aCS.DI()) {
                this.aCS.Ca();
                return true;
            } else {
                bnK();
                bDe();
                return true;
            }
        }
        if (i == 67 && (text = bDq().getText()) != null) {
            int selectionStart = bDq().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bDq().onKeyDown(67, this.cKg);
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
        getLayoutMode().u(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ak.c(this.mPost, d.C0126d.cp_link_tip_a, 1);
        bCZ();
        ak.j(this.glM, d.C0126d.cp_bg_line_c);
        ak.j(bDr(), d.C0126d.cp_bg_line_d);
        ak.j(bDq(), d.C0126d.cp_bg_line_d);
        bnS();
        this.aCS.onChangeSkinType(i);
        if (this.hgG != null) {
            this.hgG.wY();
        }
        ak.h(this.mName, d.C0126d.cp_cont_b);
        bDf();
        bDg();
        if (this.hgO != null) {
            this.hgO.c(bDr(), bDq());
        }
        this.eTB.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDf() {
        if (this.glL.hasFocus()) {
            this.glL.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        } else {
            this.glL.setHintTextColor(ak.getColor(d.C0126d.cp_cont_d));
        }
        if (this.glP.hasFocus()) {
            this.glP.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        } else {
            this.glP.setHintTextColor(ak.getColor(d.C0126d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDg() {
        if (this.glL != null) {
            if (this.glL.getText().toString().length() == 0) {
                this.glL.getPaint().setFakeBoldText(false);
            } else if (this.glL.getText().toString().length() > 0) {
                this.glL.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.aNc = new com.baidu.tbadk.core.view.a(getPageContext());
        this.hgI = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.i.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.asg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ak.h(this.mName, d.C0126d.cp_cont_b);
        bDi();
        this.hgH = (ScrollView) findViewById(d.g.write_scrollview);
        this.hgH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.glP != null) {
                        l.b(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.glP);
                    }
                    if (TransmitPostEditActivity.this.aCS != null) {
                        TransmitPostEditActivity.this.aCS.Ca();
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
        this.hgq = (LinearLayout) findViewById(d.g.tool_view);
        this.hgq.setContentDescription("..");
        this.hgr = (LinearLayout) findViewById(d.g.title_view);
        this.glM = findViewById(d.g.interval_view);
        this.hgK = (TextView) findViewById(d.g.hot_topic_title_edt);
        bnR();
        if (this.hgI) {
            this.hgH.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        bnT();
        bDo();
        this.glO = (LinearLayout) findViewById(d.g.post_content_container);
        this.glO.setDrawingCacheEnabled(false);
        this.glO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                view2.requestFocus();
                TransmitPostEditActivity.this.aCS.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.glP.requestFocus();
            }
        });
        this.asg.setOnFocusChangeListener(this.glJ);
        this.asg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TransmitPostEditActivity.this.bnK();
                TransmitPostEditActivity.this.bDe();
            }
        });
        bDl();
        bDn();
        bDh();
        bCZ();
        bDm();
        bnQ();
        bDt();
        if (this.mData.getType() == 4 && this.glT != null && this.hgt != null) {
            this.glT.setVisibility(8);
            this.hgt.setVisibility(8);
        }
        bnS();
        ShowSoftKeyPad(this.mInputManager, this.glL);
    }

    private void bDh() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.gLv != null && this.gLv.equals("1")) {
                        this.mName.setText(d.k.share_to_home_page);
                    } else if (this.gLv != null && this.gLv.equals("2")) {
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
                    this.glL.setVisibility(0);
                    this.glP.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(d.k.publish_photo_live);
                    this.glP.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(d.k.send_reply);
                    this.glP.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.glL.setVisibility(8);
                    return;
            }
        }
    }

    private void bDi() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.e(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.glJ);
    }

    private void bDj() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hgp && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = an.d(this.mPostTopicData.getTitleTopic(), 31, (String) null);
            if (!StringUtils.isNull(d) && bDr() != null) {
                bDr().setText(d);
                bDr().setSelection(d.length());
            }
        }
    }

    private void bDk() {
        this.hgB = null;
        this.hgD = -1;
        this.hgF = -1;
        x kk = w.aqF().kk(1);
        if (kk != null) {
            this.hgB = kk.daa;
            this.hgD = getIntent().getIntExtra("category_id", -1);
            if (this.hgB != null && !this.hgB.isEmpty() && this.hgD >= 0) {
                this.hgC = new v();
                this.hgC.cZW = 0;
                this.hgC.name = getPageContext().getResources().getString(d.k.category_auto);
                this.hgF = this.hgC.cZW;
                this.hgE = this.hgC.name;
                for (v vVar : this.hgB) {
                    if (vVar.cZW == this.hgD) {
                        this.hgF = vVar.cZW;
                        this.hgE = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bDl() {
        if (this.hgB != null && !this.hgB.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.hgG = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.hgG.setText(this.hgE);
            this.hgG.setCategoryContainerData(this.hgB, this.hgC, this.hgF);
            this.hgG.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view2, com.baidu.tieba.frs.ar arVar) {
                    if (arVar != null) {
                        TransmitPostEditActivity.this.hgG.setText(arVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(arVar.cZW);
                        TransmitPostEditActivity.this.hgF = arVar.cZW;
                        TransmitPostEditActivity.this.hgG.bCN();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TransmitPostEditActivity.this.hgG.bCM();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bDr());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bDq());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hgW = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hgW.setTitle(d.k.no_disturb_start_time);
        this.hgW.setButton(-1, getPageContext().getString(d.k.alert_yes_button), this.hgW);
        this.hgW.setButton(-2, getPageContext().getString(d.k.cancel), this.hgW);
        return this.hgW;
    }

    private void bDm() {
        this.hgx = (RelativeLayout) findViewById(d.g.addition_container);
        this.hgy = (TextView) findViewById(d.g.addition_create_time);
        this.hgz = (TextView) findViewById(d.g.addition_last_time);
        this.hgA = (TextView) findViewById(d.g.addition_last_content);
        if (this.hgw != null) {
            this.hgx.setVisibility(0);
            this.hgy.setText(getPageContext().getString(d.k.write_addition_create) + an.s(this.hgw.getCreateTime() * 1000));
            if (this.hgw.getAlreadyCount() == 0) {
                this.hgz.setVisibility(8);
            } else {
                this.hgz.setText(getPageContext().getString(d.k.write_addition_last) + an.s(this.hgw.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hgw.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hgA.setText(lastAdditionContent);
            } else {
                this.hgA.setVisibility(8);
            }
            bDq().setHint(String.format(getPageContext().getString(d.k.write_addition_hint), Integer.valueOf(this.hgw.getAlreadyCount()), Integer.valueOf(this.hgw.getTotalCount())));
            this.mName.setText(d.k.write_addition_title);
            return;
        }
        this.hgx.setVisibility(8);
    }

    private void bnQ() {
        this.glT = findViewById(d.g.post_prefix_layout);
        this.glQ = (TextView) findViewById(d.g.post_prefix);
        this.hgt = findViewById(d.g.prefix_divider);
        this.glS = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.glT.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.glt = 1;
            this.glT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TransmitPostEditActivity.this.glQ.setVisibility(0);
                    TransmitPostEditActivity.this.glT.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.glR, view2, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.aCS.Ca();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.glL);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.glP);
                }
            });
            this.glS = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.glS.setVisibility(0);
                this.glQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TransmitPostEditActivity.this.glQ.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.glR, view2, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.aCS.Ca();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bDr());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bDq());
                    }
                });
            }
            this.glR = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.glR.a(this);
            this.glR.setMaxHeight(l.e(getActivity(), d.e.ds510));
            this.glR.setOutsideTouchable(true);
            this.glR.setFocusable(true);
            this.glR.setOnDismissListener(this);
            this.glR.setBackgroundDrawable(ak.getDrawable(d.C0126d.cp_bg_line_d));
            int color = ak.getColor(d.C0126d.cp_cont_b);
            int color2 = ak.getColor(d.C0126d.cp_cont_c);
            ak.i(this.glQ, d.C0126d.cp_bg_line_d);
            ak.c(this.glS, d.f.icon_frs_arrow_n);
            this.glQ.setTextColor(color);
            this.hgu.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.hgu.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.glR.addView(writePrefixItemLayout);
            }
            this.glR.setCurrentIndex(0);
            this.glQ.setText(prefixs.get(1));
            vh(1);
            return;
        }
        this.glT.setVisibility(8);
    }

    protected void bDn() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.adp.lib.util.j.gP()) {
                    TransmitPostEditActivity.this.showToast(d.k.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.hgO.a(TransmitPostEditActivity.this.glL, TransmitPostEditActivity.this.glP)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.hgO.bAY());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bDr());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bDq());
                    TransmitPostEditActivity.this.aCS.Ca();
                    TiebaStatic.log(new al("c12608").r("obj_locate", 7));
                    TransmitPostEditActivity.this.bDx();
                }
            }
        });
    }

    protected void bnR() {
        this.glL = (EditText) findViewById(d.g.post_title);
        this.glL.setOnClickListener(this.hgS);
        this.glL.setOnFocusChangeListener(this.glJ);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.glL.setText(this.mData.getTitle());
            this.glL.setSelection(this.mData.getTitle().length());
        }
        this.glL.addTextChangedListener(this.hgU);
        if (!this.mData.getHaveDraft()) {
            bDj();
        }
        this.glL.setHint(getResources().getString(d.k.post_title_hint));
    }

    protected void bnT() {
        this.glP = (EditText) findViewById(d.g.post_content);
        this.glP.setDrawingCacheEnabled(false);
        this.glP.setOnClickListener(this.hgS);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString R = TbFaceManager.EZ().R(getPageContext().getPageActivity(), this.mData.getContent());
            this.glP.setText(R);
            this.glP.setSelection(R.length());
        }
        this.glP.setOnFocusChangeListener(this.glJ);
        this.glP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view2.requestFocus();
                    TransmitPostEditActivity.this.aCS.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.glP.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.glP.addTextChangedListener(this.hgV);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.glP.setHint(d.k.share_video_default);
        } else {
            this.glP.setHint(d.k.share_txt_default);
        }
    }

    private void bDo() {
        this.eTB = (OriginalThreadCardView) findViewById(d.g.write_original_thread_cardview);
        this.eTB.setVisibility(0);
        this.eTB.b(this.mOriginalThreadInfo);
        this.eTB.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bDp() {
        int i = 5000;
        if (this.hgw != null) {
            i = 1000;
        }
        return bDq().getText() != null && bDq().getText().length() >= i;
    }

    private void gh(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hgn)) {
                this.hgn = "";
                bDq().requestFocus();
                if (bDq().getText() != null && bDq().getText().length() + str.length() > 5000) {
                    showToast(d.k.over_limit_tip);
                    return;
                } else {
                    i = bDq().getSelectionStart();
                    editable = bDq().getText();
                }
            } else if ("from_title".equals(this.hgn)) {
                this.hgn = "";
                bDr().requestFocus();
                if (bDr().getText() != null && bDr().getText().length() + str.length() > 31) {
                    showToast(d.k.over_limit_tip);
                    return;
                } else {
                    i = bDr().getSelectionStart();
                    editable = bDr().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nv(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void d(n nVar) {
        if (((ImageSpan[]) bDq().getText().getSpans(0, bDq().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hgv == null) {
                this.hgv = Toast.makeText(getPageContext().getPageActivity(), d.k.too_many_face, 0);
            }
            this.hgv.show();
            return;
        }
        String name = nVar.getName();
        final EmotionGroupType yC = nVar.yC();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.fp().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.bDq().getSelectionStart(), aVar, yC);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bDq() != null && bDq().getText() != null) {
            Bitmap km = aVar.km();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(km);
            int width = km.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, km.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.d(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bDq().getSelectionStart() - 1;
                if (bDq().getText().length() > 1 && selectionStart >= 0 && bDq().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bDq().getText().insert(bDq().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bDq().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bDq().getText().insert(bDq().getSelectionStart(), spannableString2);
            }
            Editable text = bDq().getText();
            if (text != null) {
                this.hgL.clear();
                this.hgL.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hgL);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bDq().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bDq().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bDq().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bDq() {
        return this.glP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bDr() {
        return this.glL;
    }

    protected void bDs() {
        Editable text;
        if (bDq() != null && (text = bDq().getText()) != null) {
            int selectionStart = bDq().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bDq().onKeyDown(67, this.cKg);
            }
            bDq().onKeyDown(67, this.cKg);
            int selectionStart2 = bDq().getSelectionStart();
            this.hgL.clear();
            this.hgL.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.hgL);
            bDq().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aNc.d(null);
        this.aNc.cZ(d.k.sending);
        this.aNc.aI(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aNc.aI(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnS() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bDr() != null) {
                str = bDr().getText().toString();
            }
            if (bDq() != null) {
                str2 = bDq().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.glt == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            nw(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        nw(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    nw(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hgI) {
                    nw(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    nw(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                nw(true);
            } else if (this.mData.getVideoInfo() != null) {
                nw(true);
            } else {
                nw(false);
            }
        }
    }

    private void nw(boolean z) {
        ak.b(this.mPost, d.C0126d.cp_link_tip_a, d.C0126d.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.aEw = new NewWriteModel(this);
        this.aEw.b(this.aEK);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.bnK();
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
                this.hgw = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hgw != null);
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
            this.gLv = bundle.getString("KEY_CALL_FROM");
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
            this.hgw = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hgw != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.gLv = intent.getStringExtra("KEY_CALL_FROM");
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
            this.hgp = true;
        }
        bDk();
    }

    private void bDt() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.glL.setText(com.baidu.tbadk.plugins.b.gT(com.baidu.tbadk.plugins.b.gU(hotTopicBussinessData.mTopicName)));
            this.glL.setMovementMethod(com.baidu.tieba.view.c.bAd());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString gT = com.baidu.tbadk.plugins.b.gT(com.baidu.tbadk.plugins.b.gU(hotTopicBussinessData.mTopicName));
            if (gT != null) {
                this.glL.setText(gT);
            }
            this.hgK.setText(hotTopicBussinessData.mForumName);
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
        if (this.hgw != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hgw));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.gLv);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bDq().getEditableText().toString();
        if (obj != null) {
            bDq().setText(TbFaceManager.EZ().a(getPageContext().getPageActivity(), obj, this.hgQ));
            bDq().setSelection(bDq().getText().length());
        }
    }

    private String bDu() {
        if (bDq() == null || bDq().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(bDq().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(d.k.share_video_default);
            }
            return getString(d.k.share_txt_default);
        }
        return bDq().getText().toString();
    }

    private String bDv() {
        if (this.mData == null || bDr() == null || bDr().getVisibility() != 0 || bDr().getText() == null) {
            return "";
        }
        String obj = bDr().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.v(this.mPrefixData.getPrefixs()) > 0 && this.glt != 0 && this.mData.getType() != 4 && this.glQ != null && this.glQ.getText() != null) {
            obj = this.glQ.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void bDw() {
        bnK();
        this.mData.setContent(bDu());
        this.mData.setTitle(bDv());
        if (this.hgD >= 0) {
            this.mData.setCategoryFrom(this.hgD);
        }
        if (this.hgF >= 0) {
            this.mData.setCategoryTo(this.hgF);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aEv != null && this.aEv.abo());
        this.aEw.mv(this.writeImagesInfo.size() > 0);
        if (!com.baidu.tbadk.core.util.v.w(this.mList) && this.hgJ != null && this.hgJ.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hgJ.mForumId));
            this.mData.setForumName(this.hgJ.mForumName);
        }
        this.aEw.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.aEw.getWriteData().setVoice(null);
        this.aEw.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.gP()) {
            showToast(d.k.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(d.k.sending), this.mDialogCancelListener);
        this.aEw.startPostWrite();
    }

    private void q(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.hgw != null) {
                i2 = this.hgw.getTotalCount();
                i = this.hgw.getAlreadyCount() + 1;
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
                if (this.aCS != null && !this.aCS.DI()) {
                    bDq().requestFocus();
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
                            bDq().getText().insert(bDq().getSelectionStart(), sb.toString());
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
                        if (this.hgo) {
                            sb2.append(com.baidu.tbadk.plugins.b.aMz);
                            this.hgo = false;
                        }
                        sb2.append(stringExtra);
                        gh(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.w(this.mList) && !com.baidu.tbadk.core.util.v.w(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.hgJ = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.hgJ);
            }
        } else if (i2 == 0) {
            if (this.aCS != null && !this.aCS.DI()) {
                this.glP.requestFocus();
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
                        this.hgO.uB(postWriteCallBackData.getErrorString());
                        this.hgO.ax(postWriteCallBackData.getSensitiveWords());
                        this.hgO.b(this.glL, this.glP);
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.hgn)) {
                        bDr().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hgn)) {
                        bDq().requestFocus();
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
    public void bDx() {
        if ("1".equals(this.gLv)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.gLv)) {
            this.mData.setCanNoForum(false);
        }
        bDy();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.gLv);
        bDw();
    }

    private void bDy() {
        if (this.aCS != null) {
            this.aCS.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bDr());
        HidenSoftKeyPad(this.mInputManager, bDq());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.tt(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.cYe) != null) {
                    TiebaStatic.log(new al("c12534").r("obj_locate", ar.a.ajb));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.k.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hgw == null) {
                    if (!d(postWriteCallBackData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        return;
                    }
                    return;
                }
                q(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aEB = i;
        if (this.aCS != null) {
            this.aCS.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bDz() {
        if (!this.hgI && this.aCS != null) {
            this.aCS.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.aCS.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(boolean z) {
        if (this.aCS != null) {
            this.aCS.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void vh(int i) {
        if (i < this.hgu.size()) {
            for (int i2 = 0; i2 < this.hgu.size(); i2++) {
                this.hgu.get(i2).nm(false);
            }
            this.hgu.get(i).nm(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void sO(int i) {
        this.glt = i;
        this.glR.setCurrentIndex(i);
        vh(i);
        this.glQ.setText(this.mPrefixData.getPrefixs().get(i));
        bnS();
        com.baidu.adp.lib.g.g.a(this.glR, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.glT.setSelected(false);
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

    @Override // android.app.Activity, com.baidu.d.a.a.InterfaceC0045a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            Eh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.hgN = z;
        if (this.hgM != null && !z) {
            this.hgM.akW();
        }
        if (this.hgP != null && !z) {
            bDc();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.hgN && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hgo = false;
            this.hgn = "";
            if ("from_content".equals(str)) {
                this.hgn = "from_content";
            } else if ("from_title".equals(str)) {
                this.hgn = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.gS(String.valueOf(charSequence.charAt(i)))) {
                nv(false);
            }
        }
    }

    public void bjW() {
        if (!com.baidu.tbadk.core.util.v.w(this.mList)) {
            this.hgr.setVisibility(0);
            this.hgr.requestFocus();
            this.aCS.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hgr.setVisibility(8);
    }
}
