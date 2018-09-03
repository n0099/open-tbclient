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
import com.baidu.e.a.a;
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
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.f;
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
    private EditorTools aMi;
    private LocationModel aNK;
    private NewWriteModel aNL;
    private OriginalThreadCardView fke;
    private ImageView gDA;
    private View gDB;
    private int gDb;
    private TextView gDy;
    private com.baidu.tieba.write.d gDz;
    private LinearLayout hyI;
    private LinearLayout hyJ;
    private View hyL;
    private Toast hyN;
    private AdditionData hyO;
    private RelativeLayout hyP;
    private TextView hyQ;
    private TextView hyR;
    private TextView hyS;
    List<x> hyT;
    x hyU;
    private int hyV;
    private String hyW;
    private int hyX;
    private PostCategoryView hyY;
    private HotTopicBussinessData hzb;
    private TextView hzc;
    private com.baidu.tieba.write.editor.b hze;
    private e hzh;
    private com.baidu.tieba.view.b hzo;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String hyF = "";
    private boolean hyG = false;
    private WriteData mData = null;
    private boolean hyH = false;
    private InputMethodManager mInputManager = null;
    private EditText gDt = null;
    private View gDu = null;
    private LinearLayout gDw = null;
    private EditText gDx = null;
    private FeedBackModel hyK = null;
    private ArrayList<WritePrefixItemLayout> hyM = new ArrayList<>();
    private final KeyEvent cVg = new KeyEvent(0, 67);
    private View aAW = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String aNP = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aNQ = 0;
    private View mRootView = null;
    private ScrollView hyZ = null;
    private boolean hza = false;
    private com.baidu.tbadk.core.view.a aVY = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String dHS = "2";
    private SpannableStringBuilder hzd = new SpannableStringBuilder();
    private boolean hzf = false;
    private final b hzg = new b();
    private TbFaceManager.a hzi = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan ha(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.nb());
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
    private final AntiHelper.a dnr = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").r("obj_locate", at.a.aro));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").r("obj_locate", at.a.aro));
        }
    };
    private final NewWriteModel.d aNZ = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, u uVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.hzg.az(null);
                if (z) {
                    TransmitPostEditActivity.this.bL(z);
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
                    TransmitPostEditActivity.this.hzg.vz(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.hzg.az(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.hzg.b(TransmitPostEditActivity.this.gDt, TransmitPostEditActivity.this.gDx);
                } else if ((uVar == null || writeData == null || uVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (uVar != null && writeData != null && uVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(uVar.getVcode_md5());
                    writeData.setVcodeUrl(uVar.getVcode_pic_url());
                    writeData.setVcodeExtra(uVar.Cs());
                    if (com.baidu.tbadk.q.a.hN(uVar.Cr())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, uVar.Cr())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a aNX = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void Ij() {
            TransmitPostEditActivity.this.showToast(f.j.no_network_guide);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void gP(String str) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            if (StringUtils.isNull(str)) {
                str = TransmitPostEditActivity.this.getPageContext().getString(f.j.location_fail);
            }
            transmitPostEditActivity.showToast(str);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bwK())) {
                TransmitPostEditActivity.this.b(2, true, aVar.bwK());
            } else {
                gP(null);
            }
        }
    };
    private final CustomMessageListener gQk = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.aNK.mw(false);
                    TransmitPostEditActivity.this.aNK.co(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.aNK.mw(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hzj = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hzk = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.aMi.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bHs = TransmitPostEditActivity.this.bHs();
            if (bHs >= 0 && bHs < TransmitPostEditActivity.this.gDx.getText().length()) {
                TransmitPostEditActivity.this.gDx.setSelection(bHs);
            }
        }
    };
    private boolean hzl = true;
    private final View.OnFocusChangeListener gDr = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.gDt || view == TransmitPostEditActivity.this.aAW || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.hzl = true;
                    TransmitPostEditActivity.this.bHt();
                    if (TransmitPostEditActivity.this.aMi != null) {
                        TransmitPostEditActivity.this.aMi.FP();
                    }
                    l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gDt);
                } else if (view == TransmitPostEditActivity.this.gDt) {
                    TransmitPostEditActivity.this.gDy.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.gDx && z) {
                TransmitPostEditActivity.this.hzl = false;
                TransmitPostEditActivity.this.bHt();
                TransmitPostEditActivity.this.aMi.FP();
                l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gDx);
            }
            TransmitPostEditActivity.this.bHz();
        }
    };
    private TextWatcher hzm = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String hzq = "";
        private String hzr;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hzr = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hzr != null ? this.hzr.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.brU();
            TransmitPostEditActivity.this.bHA();
            EditText bHL = TransmitPostEditActivity.this.bHL();
            if (editable != null && bHL != null && bHL.getText() != null) {
                if (this.hzq == null || !this.hzq.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.hzg != null) {
                        this.hzq = bHL.getText().toString();
                        TransmitPostEditActivity.this.hzg.k(bHL);
                        return;
                    }
                    return;
                }
                bHL.setSelection(bHL.getSelectionEnd());
            }
        }
    };
    private TextWatcher hzn = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String hzr;
        private String hzs = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hzr = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hzr != null ? this.hzr.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.brU();
            EditText bHK = TransmitPostEditActivity.this.bHK();
            if (editable != null && bHK != null && bHK.getText() != null) {
                int selectionEnd = bHK.getSelectionEnd();
                if (this.hzs == null || !this.hzs.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.hzg != null) {
                        this.hzs = bHK.getText().toString();
                        TransmitPostEditActivity.this.hzg.k(bHK);
                        return;
                    }
                    return;
                }
                bHK.setSelection(selectionEnd);
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
    public void HU() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void HV() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(f.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            HX();
        } else if (this.aNK.bwS()) {
            HU();
        } else {
            this.aNK.mw(false);
            b(1, true, null);
            this.aNK.bwQ();
        }
    }

    private void HX() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cf(f.j.location_app_permission_prompt).a(f.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.jE()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.aNK.afW();
                } else {
                    TransmitPostEditActivity.this.aNX.Ij();
                }
                aVar2.dismiss();
            }
        }).b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TransmitPostEditActivity.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.xe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bHs() {
        int selectionEnd = bHK().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bHK().getText().getSpans(0, bHK().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bHK().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bHK().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHt() {
        if (this.aMi != null) {
            this.aMi.setBarLauncherEnabled(!this.hzl);
            this.aMi.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hza) {
            this.gDt.setVisibility(8);
            brU();
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
        this.aNK = new LocationModel(this);
        this.aNK.a(this.aNX);
        registerListener(this.gQk);
        registerListener(this.hzj);
        initEditor();
        this.gDx.requestFocus();
        bob();
        bHT();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aMi = new EditorTools(getActivity());
        this.aMi.setBarMaxLauCount(4);
        this.aMi.setMoreButtonAtEnd(true);
        this.aMi.setBarLauncherType(1);
        this.aMi.bD(true);
        this.aMi.bE(true);
        this.aMi.setMoreLauncherIcon(f.C0146f.write_more);
        this.aMi.setBackgroundColorId(f.d.cp_bg_line_d);
        bHu();
        this.aMi.Hu();
        if (this.hyI != null) {
            this.hyI.addView(this.aMi);
        }
        bHv();
        this.aMi.oC();
        com.baidu.tbadk.editortools.g eK = this.aMi.eK(6);
        if (eK != null && !TextUtils.isEmpty(this.aNP)) {
            ((View) eK).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.aNP);
                }
            });
        }
        if (!this.hza) {
            this.aMi.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aMi.FP();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aMi.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aMi.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
        bHx();
    }

    private void bHu() {
        com.baidu.tbadk.editortools.k kVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 2);
        aVar.aMP = f.C0146f.write_at;
        this.aMi.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.aMi.b(aVar2);
        aVar2.aMP = f.C0146f.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask != null && (kVar = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar.aMR = 4;
            kVar.aMP = f.C0146f.icon_post_location_selector;
            this.aMi.b(kVar);
        }
        if (this.hyO == null) {
            if (this.hze == null) {
                this.hze = new com.baidu.tieba.write.editor.b(getActivity(), this.dHS);
                this.hze.bGw();
                this.hze.setFrom("from_share_write");
                this.hze.aP(this.mData.getForumId(), this.mPrivateThread);
            }
            this.aMi.b(this.hze);
        }
        this.aMi.F(arrayList);
        com.baidu.tbadk.editortools.k eN = this.aMi.eN(5);
        if (eN != null) {
            eN.aMR = 1;
            eN.aMP = f.C0146f.write_emotion;
        }
    }

    private void bHv() {
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
                        if (TransmitPostEditActivity.this.bHJ()) {
                            TransmitPostEditActivity.this.showToast(f.j.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.bHJ()) {
                            TransmitPostEditActivity.this.showToast(f.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            TransmitPostEditActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.bHM();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.brU();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.hyO == null) {
                            TransmitPostEditActivity.this.HY();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.aNQ) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ac.aM(pageActivity)) {
                                    TransmitPostEditActivity.this.HV();
                                    return;
                                } else {
                                    ac.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.HU();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.aNK != null) {
                            TransmitPostEditActivity.this.aNK.mw(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        an anVar = new an("c10645");
                        if (TransmitPostEditActivity.this.mData != null) {
                            str = TransmitPostEditActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.ae(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(anVar);
                        if (TransmitPostEditActivity.this.mData == null || (videoInfo = TransmitPostEditActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.aMi.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.aMi.Hw()) {
                                        TransmitPostEditActivity.this.aMi.FP();
                                        TransmitPostEditActivity.this.aMi.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(TransmitPostEditActivity.this.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(TransmitPostEditActivity.this.getPageContext(), TransmitPostEditActivity.this.getResources().getString(f.j.plugin_video_not_active), TransmitPostEditActivity.this.getResources().getString(f.j.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(TransmitPostEditActivity.this.getPageContext(), TransmitPostEditActivity.this.getResources().getString(f.j.plugin_video_install_tips), TransmitPostEditActivity.this.getResources().getString(f.j.plugin_go_install));
                            return;
                        }
                        TransmitPostEditActivity.this.aMi.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.aMi.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.aMi.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.aMi.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.brU();
                        if (TransmitPostEditActivity.this.gDx != null) {
                            TransmitPostEditActivity.this.gDx.requestFocus();
                        }
                        TransmitPostEditActivity.this.aMi.FP();
                        TransmitPostEditActivity.this.aMi.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gDx);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.aMi.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.hyG = true;
                        TransmitPostEditActivity.this.nA(true);
                        if (TransmitPostEditActivity.this.bHL().isFocused()) {
                            TransmitPostEditActivity.this.hyF = "from_title";
                        } else if (TransmitPostEditActivity.this.bHK().isFocused()) {
                            TransmitPostEditActivity.this.hyF = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.hyJ.setVisibility(0);
                        TransmitPostEditActivity.this.hyJ.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.hyJ.hasFocus()) {
                            TransmitPostEditActivity.this.gDx.requestFocus();
                            TransmitPostEditActivity.this.gDx.setSelection(TransmitPostEditActivity.this.gDx.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.hyJ.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aMi.setActionListener(31, bVar);
        this.aMi.setActionListener(16, bVar);
        this.aMi.setActionListener(14, bVar);
        this.aMi.setActionListener(24, bVar);
        this.aMi.setActionListener(3, bVar);
        this.aMi.setActionListener(10, bVar);
        this.aMi.setActionListener(11, bVar);
        this.aMi.setActionListener(12, bVar);
        this.aMi.setActionListener(13, bVar);
        this.aMi.setActionListener(15, bVar);
        this.aMi.setActionListener(18, bVar);
        this.aMi.setActionListener(20, bVar);
        this.aMi.setActionListener(25, bVar);
        this.aMi.setActionListener(27, bVar);
        this.aMi.setActionListener(29, bVar);
        this.aMi.setActionListener(43, bVar);
        this.aMi.setActionListener(45, bVar);
        this.aMi.setActionListener(53, bVar);
        this.aMi.setActionListener(48, bVar);
        this.aMi.setActionListener(46, bVar);
        this.aMi.setActionListener(49, bVar);
        this.aMi.setActionListener(47, bVar);
        this.aMi.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HY() {
        if (this.aNK.afS()) {
            if (this.aNK.bwS()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bwO().getLocationData().bwK());
                return;
            }
            b(1, true, null);
            this.aNK.bwQ();
            return;
        }
        b(0, true, null);
    }

    protected void brM() {
        if (this.aNL != null) {
            this.aNL.cancelLoadData();
        }
        if (this.hyK != null) {
            this.hyK.cancelLoadData();
        }
        if (this.aNK != null) {
            this.aNK.cancelLoadData();
        }
    }

    private void bHw() {
        if (this.hzh != null) {
            this.hzh.hideTip();
        }
    }

    private void bHx() {
        if (this.hzh == null) {
            this.hzh = new e(getPageContext());
        }
        this.hzh.c(this.aMi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bHw();
        TiebaPrepareImageService.StopService();
        brM();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHy() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(bHL().getText().toString());
        this.mData.setContent(bHK().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.gDz != null && this.gDz.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gDz, getPageContext().getPageActivity());
                return true;
            } else if (this.aMi.Hw()) {
                this.aMi.FP();
                return true;
            } else {
                brM();
                bHy();
                return true;
            }
        }
        if (i == 67 && (text = bHK().getText()) != null) {
            int selectionStart = bHK().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bHK().onKeyDown(67, this.cVg);
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
        am.c(this.mPost, f.d.cp_link_tip_a, 1);
        bHt();
        am.j(this.gDu, f.d.cp_bg_line_c);
        am.j(bHL(), f.d.cp_bg_line_d);
        am.j(bHK(), f.d.cp_bg_line_d);
        brU();
        this.aMi.onChangeSkinType(i);
        if (this.hyY != null) {
            this.hyY.AD();
        }
        am.h(this.mName, f.d.cp_cont_b);
        bHz();
        bHA();
        if (this.hzg != null) {
            this.hzg.c(bHL(), bHK());
        }
        this.fke.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHz() {
        if (this.gDt.hasFocus()) {
            this.gDt.setHintTextColor(am.getColor(f.d.cp_cont_e));
        } else {
            this.gDt.setHintTextColor(am.getColor(f.d.cp_cont_d));
        }
        if (this.gDx.hasFocus()) {
            this.gDx.setHintTextColor(am.getColor(f.d.cp_cont_e));
        } else {
            this.gDx.setHintTextColor(am.getColor(f.d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHA() {
        if (this.gDt != null) {
            if (this.gDt.getText().toString().length() == 0) {
                this.gDt.getPaint().setFakeBoldText(false);
            } else if (this.gDt.getText().toString().length() > 0) {
                this.gDt.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.aVY = new com.baidu.tbadk.core.view.a(getPageContext());
        this.hza = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(f.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aAW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(f.C0146f.icon_topbar_close, f.C0146f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.h(this.mName, f.d.cp_cont_b);
        bHC();
        this.hyZ = (ScrollView) findViewById(f.g.write_scrollview);
        this.hyZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.gDx != null) {
                        l.a(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.gDx);
                    }
                    if (TransmitPostEditActivity.this.aMi != null) {
                        TransmitPostEditActivity.this.aMi.FP();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mParent = (RelativeLayout) findViewById(f.g.parent);
        this.hyI = (LinearLayout) findViewById(f.g.tool_view);
        this.hyI.setContentDescription("..");
        this.hyJ = (LinearLayout) findViewById(f.g.title_view);
        this.gDu = findViewById(f.g.interval_view);
        this.hzc = (TextView) findViewById(f.g.hot_topic_title_edt);
        brT();
        if (this.hza) {
            this.hyZ.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        brV();
        bHI();
        this.gDw = (LinearLayout) findViewById(f.g.post_content_container);
        this.gDw.setDrawingCacheEnabled(false);
        this.gDw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.aMi.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.gDx.requestFocus();
            }
        });
        this.aAW.setOnFocusChangeListener(this.gDr);
        this.aAW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.brM();
                TransmitPostEditActivity.this.bHy();
            }
        });
        bHF();
        bHH();
        bHB();
        bHt();
        bHG();
        brS();
        bHN();
        if (this.mData.getType() == 4 && this.gDB != null && this.hyL != null) {
            this.gDB.setVisibility(8);
            this.hyL.setVisibility(8);
        }
        brU();
        ShowSoftKeyPad(this.mInputManager, this.gDt);
    }

    private void bHB() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.dHS != null && this.dHS.equals("1")) {
                        this.mName.setText(f.j.share_to_home_page);
                    } else if (this.dHS != null && this.dHS.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(f.j.share_to) + this.mData.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(f.j.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(f.j.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.gDt.setVisibility(0);
                    this.gDx.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(f.j.publish_photo_live);
                    this.gDx.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(f.j.send_reply);
                    this.gDx.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gDt.setVisibility(8);
                    return;
            }
        }
    }

    private void bHC() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(f.j.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.f(getPageContext().getPageActivity(), f.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.gDr);
    }

    private void bHD() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hyH && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = ap.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && bHL() != null) {
                bHL().setText(c);
                bHL().setSelection(c.length());
            }
        }
    }

    private void bHE() {
        this.hyT = null;
        this.hyV = -1;
        this.hyX = -1;
        z kE = y.avH().kE(1);
        if (kE != null) {
            this.hyT = kE.dpw;
            this.hyV = getIntent().getIntExtra("category_id", -1);
            if (this.hyT != null && !this.hyT.isEmpty() && this.hyV >= 0) {
                this.hyU = new x();
                this.hyU.dps = 0;
                this.hyU.name = getPageContext().getResources().getString(f.j.category_auto);
                this.hyX = this.hyU.dps;
                this.hyW = this.hyU.name;
                for (x xVar : this.hyT) {
                    if (xVar.dps == this.hyV) {
                        this.hyX = xVar.dps;
                        this.hyW = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bHF() {
        if (this.hyT != null && !this.hyT.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(f.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(f.g.interval_view_cate).setVisibility(0);
            this.hyY = (PostCategoryView) linearLayout.findViewById(f.g.category_selected);
            this.hyY.setText(this.hyW);
            this.hyY.setCategoryContainerData(this.hyT, this.hyU, this.hyX);
            this.hyY.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, com.baidu.tieba.frs.at atVar) {
                    if (atVar != null) {
                        TransmitPostEditActivity.this.hyY.setText(atVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(atVar.dps);
                        TransmitPostEditActivity.this.hyX = atVar.dps;
                        TransmitPostEditActivity.this.hyY.bHg();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.hyY.bHf();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHL());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHK());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hzo = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hzo.setTitle(f.j.no_disturb_start_time);
        this.hzo.setButton(-1, getPageContext().getString(f.j.alert_yes_button), this.hzo);
        this.hzo.setButton(-2, getPageContext().getString(f.j.cancel), this.hzo);
        return this.hzo;
    }

    private void bHG() {
        this.hyP = (RelativeLayout) findViewById(f.g.addition_container);
        this.hyQ = (TextView) findViewById(f.g.addition_create_time);
        this.hyR = (TextView) findViewById(f.g.addition_last_time);
        this.hyS = (TextView) findViewById(f.g.addition_last_content);
        if (this.hyO != null) {
            this.hyP.setVisibility(0);
            this.hyQ.setText(getPageContext().getString(f.j.write_addition_create) + ap.w(this.hyO.getCreateTime() * 1000));
            if (this.hyO.getAlreadyCount() == 0) {
                this.hyR.setVisibility(8);
            } else {
                this.hyR.setText(getPageContext().getString(f.j.write_addition_last) + ap.w(this.hyO.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hyO.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hyS.setText(lastAdditionContent);
            } else {
                this.hyS.setVisibility(8);
            }
            bHK().setHint(String.format(getPageContext().getString(f.j.write_addition_hint), Integer.valueOf(this.hyO.getAlreadyCount()), Integer.valueOf(this.hyO.getTotalCount())));
            this.mName.setText(f.j.write_addition_title);
            return;
        }
        this.hyP.setVisibility(8);
    }

    private void brS() {
        this.gDB = findViewById(f.g.post_prefix_layout);
        this.gDy = (TextView) findViewById(f.g.post_prefix);
        this.hyL = findViewById(f.g.prefix_divider);
        this.gDA = (ImageView) findViewById(f.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gDB.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gDb = 1;
            this.gDB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.gDy.setVisibility(0);
                    TransmitPostEditActivity.this.gDB.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gDz, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.aMi.FP();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gDt);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gDx);
                }
            });
            this.gDA = (ImageView) findViewById(f.g.prefix_icon);
            if (size > 1) {
                this.gDA.setVisibility(0);
                this.gDy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.gDy.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gDz, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.aMi.FP();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHL());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHK());
                    }
                });
            }
            this.gDz = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.gDz.a(this);
            this.gDz.setMaxHeight(l.f(getActivity(), f.e.ds510));
            this.gDz.setOutsideTouchable(true);
            this.gDz.setFocusable(true);
            this.gDz.setOnDismissListener(this);
            this.gDz.setBackgroundDrawable(am.getDrawable(f.d.cp_bg_line_d));
            int color = am.getColor(f.d.cp_cont_b);
            int color2 = am.getColor(f.d.cp_cont_c);
            am.i(this.gDy, f.d.cp_bg_line_d);
            am.c(this.gDA, f.C0146f.icon_frs_arrow_n);
            this.gDy.setTextColor(color);
            this.hyM.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.hyM.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.gDz.addView(writePrefixItemLayout);
            }
            this.gDz.setCurrentIndex(0);
            this.gDy.setText(prefixs.get(1));
            vG(1);
            return;
        }
        this.gDB.setVisibility(8);
    }

    protected void bHH() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.jE()) {
                    TransmitPostEditActivity.this.showToast(f.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.hzg.a(TransmitPostEditActivity.this.gDt, TransmitPostEditActivity.this.gDx)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.hzg.bFr());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHL());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHK());
                    TransmitPostEditActivity.this.aMi.FP();
                    TiebaStatic.log(new an("c12608").r("obj_locate", 7));
                    TransmitPostEditActivity.this.bHR();
                }
            }
        });
    }

    protected void brT() {
        this.gDt = (EditText) findViewById(f.g.post_title);
        this.gDt.setOnClickListener(this.hzk);
        this.gDt.setOnFocusChangeListener(this.gDr);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.gDt.setText(this.mData.getTitle());
            this.gDt.setSelection(this.mData.getTitle().length());
        }
        this.gDt.addTextChangedListener(this.hzm);
        if (!this.mData.getHaveDraft()) {
            bHD();
        }
        this.gDt.setHint(getResources().getString(f.j.post_title_hint));
    }

    protected void brV() {
        this.gDx = (EditText) findViewById(f.g.post_content);
        this.gDx.setDrawingCacheEnabled(false);
        this.gDx.setOnClickListener(this.hzk);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString W = TbFaceManager.IP().W(getPageContext().getPageActivity(), this.mData.getContent());
            this.gDx.setText(W);
            this.gDx.setSelection(W.length());
        }
        this.gDx.setOnFocusChangeListener(this.gDr);
        this.gDx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.aMi.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.gDx.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gDx.addTextChangedListener(this.hzn);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.gDx.setHint(f.j.share_video_default);
        } else {
            this.gDx.setHint(f.j.share_txt_default);
        }
    }

    private void bHI() {
        this.fke = (OriginalThreadCardView) findViewById(f.g.write_original_thread_cardview);
        this.fke.setVisibility(0);
        this.fke.b(this.mOriginalThreadInfo);
        this.fke.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bHJ() {
        int i = 5000;
        if (this.hyO != null) {
            i = 1000;
        }
        return bHK().getText() != null && bHK().getText().length() >= i;
    }

    private void gG(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hyF)) {
                this.hyF = "";
                bHK().requestFocus();
                if (bHK().getText() != null && bHK().getText().length() + str.length() > 5000) {
                    showToast(f.j.over_limit_tip);
                    return;
                } else {
                    i = bHK().getSelectionStart();
                    editable = bHK().getText();
                }
            } else if ("from_title".equals(this.hyF)) {
                this.hyF = "";
                bHL().requestFocus();
                if (bHL().getText() != null && bHL().getText().length() + str.length() > 31) {
                    showToast(f.j.over_limit_tip);
                    return;
                } else {
                    i = bHL().getSelectionStart();
                    editable = bHL().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nA(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void d(n nVar) {
        if (((ImageSpan[]) bHK().getText().getSpans(0, bHK().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hyN == null) {
                this.hyN = Toast.makeText(getPageContext().getPageActivity(), f.j.too_many_face, 0);
            }
            this.hyN.show();
            return;
        }
        String name = nVar.getName();
        final EmotionGroupType Ci = nVar.Ci();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.ih().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.bHK().getSelectionStart(), aVar, Ci);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bHK() != null && bHK().getText() != null) {
            Bitmap nb = aVar.nb();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(nb);
            int width = nb.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, nb.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.f(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bHK().getSelectionStart() - 1;
                if (bHK().getText().length() > 1 && selectionStart >= 0 && bHK().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bHK().getText().insert(bHK().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bHK().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bHK().getText().insert(bHK().getSelectionStart(), spannableString2);
            }
            Editable text = bHK().getText();
            if (text != null) {
                this.hzd.clear();
                this.hzd.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hzd);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bHK().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bHK().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bHK().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bHK() {
        return this.gDx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bHL() {
        return this.gDt;
    }

    protected void bHM() {
        Editable text;
        if (bHK() != null && (text = bHK().getText()) != null) {
            int selectionStart = bHK().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bHK().onKeyDown(67, this.cVg);
            }
            bHK().onKeyDown(67, this.cVg);
            int selectionStart2 = bHK().getSelectionStart();
            this.hzd.clear();
            this.hzd.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.hzd);
            bHK().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aVY.d(null);
        this.aVY.df(f.j.sending);
        this.aVY.aN(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aVY.aN(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brU() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bHL() != null) {
                str = bHL().getText().toString();
            }
            if (bHK() != null) {
                str2 = bHK().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.gDb == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            nB(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        nB(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    nB(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hza) {
                    nB(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    nB(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                nB(true);
            } else if (this.mData.getVideoInfo() != null) {
                nB(true);
            } else {
                nB(false);
            }
        }
    }

    private void nB(boolean z) {
        am.b(this.mPost, f.d.cp_link_tip_a, f.d.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.aNL = new NewWriteModel(this);
        this.aNL.b(this.aNZ);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.brM();
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
                this.hyO = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hyO != null);
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
            this.dHS = bundle.getString("KEY_CALL_FROM");
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
            this.hyO = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hyO != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.dHS = intent.getStringExtra("KEY_CALL_FROM");
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
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(f.j.write_no_prefix));
        }
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.videoId != null) {
            this.mData.setVideoId(this.mOriginalThreadInfo.videoId);
            this.mData.setOriginalVideoCover(this.mOriginalThreadInfo.showPicUrl);
            this.mData.setOriginalVideoTitle(this.mOriginalThreadInfo.showText);
        }
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.hyH = true;
        }
        bHE();
    }

    private void bHN() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) w.d(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.gDt.setText(com.baidu.tbadk.plugins.b.hp(com.baidu.tbadk.plugins.b.hq(hotTopicBussinessData.mTopicName)));
            this.gDt.setMovementMethod(com.baidu.tieba.view.c.bEt());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString hp = com.baidu.tbadk.plugins.b.hp(com.baidu.tbadk.plugins.b.hq(hotTopicBussinessData.mTopicName));
            if (hp != null) {
                this.gDt.setText(hp);
            }
            this.hzc.setText(hotTopicBussinessData.mForumName);
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
        if (this.hyO != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hyO));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.dHS);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bHK().getEditableText().toString();
        if (obj != null) {
            bHK().setText(TbFaceManager.IP().a(getPageContext().getPageActivity(), obj, this.hzi));
            bHK().setSelection(bHK().getText().length());
        }
    }

    private String bHO() {
        if (bHK() == null || bHK().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(bHK().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(f.j.share_video_default);
            }
            return getString(f.j.share_txt_default);
        }
        return bHK().getText().toString();
    }

    private String bHP() {
        if (this.mData == null || bHL() == null || bHL().getVisibility() != 0 || bHL().getText() == null) {
            return "";
        }
        String obj = bHL().getText().toString();
        if (this.mPrefixData != null && w.y(this.mPrefixData.getPrefixs()) > 0 && this.gDb != 0 && this.mData.getType() != 4 && this.gDy != null && this.gDy.getText() != null) {
            obj = this.gDy.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void bHQ() {
        brM();
        this.mData.setContent(bHO());
        this.mData.setTitle(bHP());
        if (this.hyV >= 0) {
            this.mData.setCategoryFrom(this.hyV);
        }
        if (this.hyX >= 0) {
            this.mData.setCategoryTo(this.hyX);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aNK != null && this.aNK.afS());
        this.aNL.my(this.writeImagesInfo.size() > 0);
        if (!w.z(this.mList) && this.hzb != null && this.hzb.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hzb.mForumId));
            this.mData.setForumName(this.hzb.mForumName);
        }
        this.aNL.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.aNL.getWriteData().setVoice(null);
        this.aNL.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.jE()) {
            showToast(f.j.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(f.j.sending), this.mDialogCancelListener);
        this.aNL.startPostWrite();
    }

    private void q(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.hyO != null) {
                i2 = this.hyO.getTotalCount();
                i = this.hyO.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(f.j.write_addition_left_count), Integer.valueOf(i2 - i)));
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
                if (this.aMi != null && !this.aMi.Hw()) {
                    bHK().requestFocus();
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
                            bHK().getText().insert(bHK().getSelectionStart(), sb.toString());
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
                        if (this.hyG) {
                            sb2.append(com.baidu.tbadk.plugins.b.aVv);
                            this.hyG = false;
                        }
                        sb2.append(stringExtra);
                        gG(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !w.z(this.mList) && !w.z(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.hzb = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.hzb);
            }
        } else if (i2 == 0) {
            if (this.aMi != null && !this.aMi.Hw()) {
                this.gDx.requestFocus();
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
                        this.hzg.vz(postWriteCallBackData.getErrorString());
                        this.hzg.az(postWriteCallBackData.getSensitiveWords());
                        this.hzg.b(this.gDt, this.gDx);
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.hyF)) {
                        bHL().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hyF)) {
                        bHK().requestFocus();
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
    public void bHR() {
        if ("1".equals(this.dHS)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.dHS)) {
            this.mData.setCanNoForum(false);
        }
        bHS();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.dHS);
        bHQ();
    }

    private void bHS() {
        if (this.aMi != null) {
            this.aMi.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bHL());
        HidenSoftKeyPad(this.mInputManager, bHK());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.al(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dnr) != null) {
                    TiebaStatic.log(new an("c12534").r("obj_locate", at.a.aro));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(f.j.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hyO == null) {
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
        this.aNQ = i;
        if (this.aMi != null) {
            this.aMi.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bHT() {
        if (!this.hza && this.aMi != null) {
            this.aMi.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.aMi.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(boolean z) {
        if (this.aMi != null) {
            this.aMi.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void vG(int i) {
        if (i < this.hyM.size()) {
            for (int i2 = 0; i2 < this.hyM.size(); i2++) {
                this.hyM.get(i2).nr(false);
            }
            this.hyM.get(i).nr(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void th(int i) {
        this.gDb = i;
        this.gDz.setCurrentIndex(i);
        vG(i);
        this.gDy.setText(this.mPrefixData.getPrefixs().get(i));
        brU();
        com.baidu.adp.lib.g.g.a(this.gDz, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gDB.setSelected(false);
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            HV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.hzf = z;
        if (this.hze != null && !z) {
            this.hze.aoX();
        }
        if (this.hzh != null && !z) {
            bHw();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(f.a.activity_open_from_bottom, f.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.hzf && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hyG = false;
            this.hyF = "";
            if ("from_content".equals(str)) {
                this.hyF = "from_content";
            } else if ("from_title".equals(str)) {
                this.hyF = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.ho(String.valueOf(charSequence.charAt(i)))) {
                nA(false);
            }
        }
    }

    public void bob() {
        if (!w.z(this.mList)) {
            this.hyJ.setVisibility(0);
            this.hyJ.requestFocus();
            this.aMi.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hyJ.setVisibility(8);
    }
}
