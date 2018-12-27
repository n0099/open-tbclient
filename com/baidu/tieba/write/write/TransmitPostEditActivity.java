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
import com.baidu.mapapi.UIMsg;
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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.at;
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
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0073a, d.a {
    private EditorTools aYr;
    private LocationModel aZT;
    private NewWriteModel aZU;
    private OriginalThreadCardView fKl;
    private TextView hdV;
    private com.baidu.tieba.write.d hdW;
    private ImageView hdX;
    private View hdY;
    private int hdy;
    private View iaA;
    private Toast iaC;
    private AdditionData iaD;
    private RelativeLayout iaE;
    private TextView iaF;
    private TextView iaG;
    private TextView iaH;
    List<x> iaI;
    x iaJ;
    private int iaK;
    private String iaL;
    private int iaM;
    private PostCategoryView iaN;
    private HotTopicBussinessData iaQ;
    private TextView iaR;
    private com.baidu.tieba.write.editor.b iaT;
    private e iaW;
    private LinearLayout iax;
    private LinearLayout iay;
    private com.baidu.tieba.view.b ibd;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String iau = "";
    private boolean iav = false;
    private WriteData mData = null;
    private boolean iaw = false;
    private InputMethodManager mInputManager = null;
    private EditText hdQ = null;
    private View hdR = null;
    private LinearLayout hdT = null;
    private EditText hdU = null;
    private FeedBackModel iaz = null;
    private ArrayList<WritePrefixItemLayout> iaB = new ArrayList<>();
    private final KeyEvent dtF = new KeyEvent(0, 67);
    private View aMW = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String aZY = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aZZ = 0;
    private View mRootView = null;
    private ScrollView iaO = null;
    private boolean iaP = false;
    private com.baidu.tbadk.core.view.d bif = null;
    private String mFrom = "write";
    private String ehA = "2";
    private SpannableStringBuilder iaS = new SpannableStringBuilder();
    private boolean iaU = false;
    private final b iaV = new b();
    private TbFaceManager.a iaX = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan ie(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.op());
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
    private final AntiHelper.a dLU = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").x("obj_locate", as.a.aCL));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").x("obj_locate", as.a.aCL));
        }
    };
    private final NewWriteModel.d bai = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.iaV.aA(null);
                if (z) {
                    TransmitPostEditActivity.this.cy(z);
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
                    TransmitPostEditActivity.this.iaV.xu(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.iaV.aA(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.iaV.b(TransmitPostEditActivity.this.hdQ, TransmitPostEditActivity.this.hdU);
                } else if ((wVar == null || writeData == null || wVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (wVar != null && writeData != null && wVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(wVar.getVcode_md5());
                    writeData.setVcodeUrl(wVar.getVcode_pic_url());
                    writeData.setVcodeExtra(wVar.GX());
                    if (com.baidu.tbadk.r.a.iT(wVar.GW())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, wVar.GW())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a bag = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void MO() {
            TransmitPostEditActivity.this.showToast(e.j.no_network_guide);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void dj(String str) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            if (StringUtils.isNull(str)) {
                str = TransmitPostEditActivity.this.getPageContext().getString(e.j.location_fail);
            }
            transmitPostEditActivity.showToast(str);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bEL())) {
                TransmitPostEditActivity.this.b(2, true, aVar.bEL());
            } else {
                dj(null);
            }
        }
    };
    private final CustomMessageListener hqM = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.aZT.nA(false);
                    TransmitPostEditActivity.this.aZT.cO(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.aZT.nA(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener iaY = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener iaZ = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.aYr.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bPQ = TransmitPostEditActivity.this.bPQ();
            if (bPQ >= 0 && bPQ < TransmitPostEditActivity.this.hdU.getText().length()) {
                TransmitPostEditActivity.this.hdU.setSelection(bPQ);
            }
        }
    };
    private boolean iba = true;
    private final View.OnFocusChangeListener hdO = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.hdQ || view == TransmitPostEditActivity.this.aMW || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.iba = true;
                    TransmitPostEditActivity.this.bPR();
                    if (TransmitPostEditActivity.this.aYr != null) {
                        TransmitPostEditActivity.this.aYr.Kx();
                    }
                    l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.hdQ);
                } else if (view == TransmitPostEditActivity.this.hdQ) {
                    TransmitPostEditActivity.this.hdV.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.hdU && z) {
                TransmitPostEditActivity.this.iba = false;
                TransmitPostEditActivity.this.bPR();
                TransmitPostEditActivity.this.aYr.Kx();
                l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.hdU);
            }
            TransmitPostEditActivity.this.bPX();
        }
    };
    private TextWatcher ibb = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String ibf = "";
        private String ibg;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.ibg = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.ibg != null ? this.ibg.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bzT();
            TransmitPostEditActivity.this.bPY();
            EditText bQj = TransmitPostEditActivity.this.bQj();
            if (editable != null && bQj != null && bQj.getText() != null) {
                if (this.ibf == null || !this.ibf.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.iaV != null) {
                        this.ibf = bQj.getText().toString();
                        TransmitPostEditActivity.this.iaV.k(bQj);
                        return;
                    }
                    return;
                }
                bQj.setSelection(bQj.getSelectionEnd());
            }
        }
    };
    private TextWatcher ibc = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String ibg;
        private String ibh = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.ibg = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.ibg != null ? this.ibg.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bzT();
            EditText bQi = TransmitPostEditActivity.this.bQi();
            if (editable != null && bQi != null && bQi.getText() != null) {
                int selectionEnd = bQi.getSelectionEnd();
                if (this.ibh == null || !this.ibh.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.iaV != null) {
                        this.ibh = bQi.getText().toString();
                        TransmitPostEditActivity.this.iaV.k(bQi);
                        return;
                    }
                    return;
                }
                bQi.setSelection(selectionEnd);
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
    public void Mz() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void MA() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(e.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            MC();
        } else if (this.aZT.bES()) {
            Mz();
        } else {
            this.aZT.nA(false);
            b(1, true, null);
            this.aZT.bEQ();
        }
    }

    private void MC() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.db(e.j.location_app_permission_prompt).a(e.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kV()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.aZT.ams();
                } else {
                    TransmitPostEditActivity.this.bag.MO();
                }
                aVar2.dismiss();
            }
        }).b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TransmitPostEditActivity.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.BF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bPQ() {
        int selectionEnd = bQi().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bQi().getText().getSpans(0, bQi().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bQi().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bQi().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPR() {
        if (this.aYr != null) {
            this.aYr.setBarLauncherEnabled(!this.iba);
            this.aYr.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iaP) {
            this.hdQ.setVisibility(8);
            bzT();
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
        this.aZT = new LocationModel(this);
        this.aZT.a(this.bag);
        registerListener(this.hqM);
        registerListener(this.iaY);
        initEditor();
        this.hdU.requestFocus();
        bvX();
        bQr();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aYr = new EditorTools(getActivity());
        this.aYr.setBarMaxLauCount(4);
        this.aYr.setMoreButtonAtEnd(true);
        this.aYr.setBarLauncherType(1);
        this.aYr.cq(true);
        this.aYr.cr(true);
        this.aYr.setMoreLauncherIcon(e.f.write_more);
        this.aYr.setBackgroundColorId(e.d.cp_bg_line_d);
        bPS();
        this.aYr.LZ();
        if (this.iax != null) {
            this.iax.addView(this.aYr);
        }
        bPT();
        this.aYr.pN();
        com.baidu.tbadk.editortools.g fI = this.aYr.fI(6);
        if (fI != null && !TextUtils.isEmpty(this.aZY)) {
            ((View) fI).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.aZY);
                }
            });
        }
        if (!this.iaP) {
            this.aYr.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aYr.Kx();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aYr.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aYr.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
        bPV();
    }

    private void bPS() {
        com.baidu.tbadk.editortools.k kVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 2);
        aVar.aYY = e.f.write_at;
        this.aYr.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.aYr.b(aVar2);
        aVar2.aYY = e.f.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask != null && (kVar = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar.aZa = 4;
            kVar.aYY = e.f.icon_post_location_selector;
            this.aYr.b(kVar);
        }
        if (this.iaD == null) {
            if (this.iaT == null) {
                this.iaT = new com.baidu.tieba.write.editor.b(getActivity(), this.ehA);
                this.iaT.bOT();
                this.iaT.setFrom("from_share_write");
                this.iaT.ba(this.mData.getForumId(), this.mPrivateThread);
            }
            this.aYr.b(this.iaT);
        }
        this.aYr.w(arrayList);
        com.baidu.tbadk.editortools.k fL = this.aYr.fL(5);
        if (fL != null) {
            fL.aZa = 1;
            fL.aYY = e.f.write_emotion;
        }
    }

    private void bPT() {
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
                            TiebaStatic.log(new am("c12608").x("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.bQh()) {
                            TransmitPostEditActivity.this.showToast(e.j.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.bQh()) {
                            TransmitPostEditActivity.this.showToast(e.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof p)) {
                            TransmitPostEditActivity.this.d((p) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.bQk();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.bzT();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.iaD == null) {
                            TransmitPostEditActivity.this.MD();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.aZZ) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.bC(pageActivity)) {
                                    TransmitPostEditActivity.this.MA();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.Mz();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.aZT != null) {
                            TransmitPostEditActivity.this.aZT.nA(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        am amVar = new am("c10645");
                        if (TransmitPostEditActivity.this.mData != null) {
                            str = TransmitPostEditActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        amVar.aA(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(amVar);
                        if (TransmitPostEditActivity.this.mData == null || (videoInfo = TransmitPostEditActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.aYr.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.aYr.Mb()) {
                                        TransmitPostEditActivity.this.aYr.Kx();
                                        TransmitPostEditActivity.this.aYr.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(TransmitPostEditActivity.this.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(TransmitPostEditActivity.this.getPageContext(), TransmitPostEditActivity.this.getResources().getString(e.j.plugin_video_not_active), TransmitPostEditActivity.this.getResources().getString(e.j.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(TransmitPostEditActivity.this.getPageContext(), TransmitPostEditActivity.this.getResources().getString(e.j.plugin_video_install_tips), TransmitPostEditActivity.this.getResources().getString(e.j.plugin_go_install));
                            return;
                        }
                        TransmitPostEditActivity.this.aYr.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.aYr.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.aYr.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.aYr.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.bzT();
                        if (TransmitPostEditActivity.this.hdU != null) {
                            TransmitPostEditActivity.this.hdU.requestFocus();
                        }
                        TransmitPostEditActivity.this.aYr.Kx();
                        TransmitPostEditActivity.this.aYr.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.hdU);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.aYr.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.iav = true;
                        TransmitPostEditActivity.this.oG(true);
                        if (TransmitPostEditActivity.this.bQj().isFocused()) {
                            TransmitPostEditActivity.this.iau = "from_title";
                        } else if (TransmitPostEditActivity.this.bQi().isFocused()) {
                            TransmitPostEditActivity.this.iau = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.iay.setVisibility(0);
                        TransmitPostEditActivity.this.iay.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.iay.hasFocus()) {
                            TransmitPostEditActivity.this.hdU.requestFocus();
                            TransmitPostEditActivity.this.hdU.setSelection(TransmitPostEditActivity.this.hdU.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.iay.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aYr.setActionListener(31, bVar);
        this.aYr.setActionListener(16, bVar);
        this.aYr.setActionListener(14, bVar);
        this.aYr.setActionListener(24, bVar);
        this.aYr.setActionListener(3, bVar);
        this.aYr.setActionListener(10, bVar);
        this.aYr.setActionListener(11, bVar);
        this.aYr.setActionListener(12, bVar);
        this.aYr.setActionListener(13, bVar);
        this.aYr.setActionListener(15, bVar);
        this.aYr.setActionListener(18, bVar);
        this.aYr.setActionListener(20, bVar);
        this.aYr.setActionListener(25, bVar);
        this.aYr.setActionListener(27, bVar);
        this.aYr.setActionListener(29, bVar);
        this.aYr.setActionListener(43, bVar);
        this.aYr.setActionListener(45, bVar);
        this.aYr.setActionListener(53, bVar);
        this.aYr.setActionListener(48, bVar);
        this.aYr.setActionListener(46, bVar);
        this.aYr.setActionListener(49, bVar);
        this.aYr.setActionListener(47, bVar);
        this.aYr.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MD() {
        if (this.aZT.amo()) {
            if (this.aZT.bES()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bEO().getLocationData().bEL());
                return;
            }
            b(1, true, null);
            this.aZT.bEQ();
            return;
        }
        b(0, true, null);
    }

    protected void bzL() {
        if (this.aZU != null) {
            this.aZU.cancelLoadData();
        }
        if (this.iaz != null) {
            this.iaz.cancelLoadData();
        }
        if (this.aZT != null) {
            this.aZT.cancelLoadData();
        }
    }

    private void bPU() {
        if (this.iaW != null) {
            this.iaW.hideTip();
        }
    }

    private void bPV() {
        if (this.iaW == null) {
            this.iaW = new e(getPageContext());
        }
        this.iaW.c(this.aYr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bPU();
        TiebaPrepareImageService.StopService();
        bzL();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPW() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(bQj().getText().toString());
        this.mData.setContent(bQi().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.hdW != null && this.hdW.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.hdW, getPageContext().getPageActivity());
                return true;
            } else if (this.aYr.Mb()) {
                this.aYr.Kx();
                return true;
            } else {
                bzL();
                bPW();
                return true;
            }
        }
        if (i == 67 && (text = bQi().getText()) != null) {
            int selectionStart = bQi().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bQi().onKeyDown(67, this.dtF);
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
        al.c(this.mPost, e.d.cp_link_tip_a, 1);
        bPR();
        al.j(this.hdR, e.d.cp_bg_line_c);
        al.j(bQj(), e.d.cp_bg_line_d);
        al.j(bQi(), e.d.cp_bg_line_d);
        bzT();
        this.aYr.onChangeSkinType(i);
        if (this.iaN != null) {
            this.iaN.Fj();
        }
        al.h(this.mName, e.d.cp_cont_b);
        bPX();
        bPY();
        if (this.iaV != null) {
            this.iaV.c(bQj(), bQi());
        }
        this.fKl.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPX() {
        if (this.hdQ.hasFocus()) {
            this.hdQ.setHintTextColor(al.getColor(e.d.cp_cont_e));
        } else {
            this.hdQ.setHintTextColor(al.getColor(e.d.cp_cont_d));
        }
        if (this.hdU.hasFocus()) {
            this.hdU.setHintTextColor(al.getColor(e.d.cp_cont_e));
        } else {
            this.hdU.setHintTextColor(al.getColor(e.d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPY() {
        if (this.hdQ != null) {
            if (this.hdQ.getText().toString().length() == 0) {
                this.hdQ.getPaint().setFakeBoldText(false);
            } else if (this.hdQ.getText().toString().length() > 0) {
                this.hdQ.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.bif = new com.baidu.tbadk.core.view.d(getPageContext());
        this.iaP = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(e.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aMW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(e.f.icon_topbar_close, e.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        al.h(this.mName, e.d.cp_cont_b);
        bQa();
        this.iaO = (ScrollView) findViewById(e.g.write_scrollview);
        this.iaO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.hdU != null) {
                        l.b(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.hdU);
                    }
                    if (TransmitPostEditActivity.this.aYr != null) {
                        TransmitPostEditActivity.this.aYr.Kx();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mParent = (RelativeLayout) findViewById(e.g.parent);
        this.iax = (LinearLayout) findViewById(e.g.tool_view);
        this.iax.setContentDescription("..");
        this.iay = (LinearLayout) findViewById(e.g.title_view);
        this.hdR = findViewById(e.g.interval_view);
        this.iaR = (TextView) findViewById(e.g.hot_topic_title_edt);
        bzS();
        if (this.iaP) {
            this.iaO.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        bzU();
        bQg();
        this.hdT = (LinearLayout) findViewById(e.g.post_content_container);
        this.hdT.setDrawingCacheEnabled(false);
        this.hdT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.aYr.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.hdU.requestFocus();
            }
        });
        this.aMW.setOnFocusChangeListener(this.hdO);
        this.aMW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.bzL();
                TransmitPostEditActivity.this.bPW();
            }
        });
        bQd();
        bQf();
        bPZ();
        bPR();
        bQe();
        bzR();
        bQl();
        if (this.mData.getType() == 4 && this.hdY != null && this.iaA != null) {
            this.hdY.setVisibility(8);
            this.iaA.setVisibility(8);
        }
        bzT();
        ShowSoftKeyPad(this.mInputManager, this.hdQ);
    }

    private void bPZ() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.ehA != null && this.ehA.equals("1")) {
                        this.mName.setText(e.j.share_to_home_page);
                    } else if (this.ehA != null && this.ehA.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(e.j.share_to) + this.mData.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(e.j.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(e.j.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.hdQ.setVisibility(0);
                    this.hdU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 4:
                    this.mName.setText(e.j.publish_photo_live);
                    this.hdU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                default:
                    this.mName.setText(e.j.send_reply);
                    this.hdU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.hdQ.setVisibility(8);
                    return;
            }
        }
    }

    private void bQa() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0210e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.hdO);
    }

    private void bQb() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.iaw && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = ao.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && bQj() != null) {
                bQj().setText(c);
                bQj().setSelection(c.length());
            }
        }
    }

    private void bQc() {
        this.iaI = null;
        this.iaK = -1;
        this.iaM = -1;
        z mA = y.aDg().mA(1);
        if (mA != null) {
            this.iaI = mA.dOh;
            this.iaK = getIntent().getIntExtra("category_id", -1);
            if (this.iaI != null && !this.iaI.isEmpty() && this.iaK >= 0) {
                this.iaJ = new x();
                this.iaJ.dOd = 0;
                this.iaJ.name = getPageContext().getResources().getString(e.j.category_auto);
                this.iaM = this.iaJ.dOd;
                this.iaL = this.iaJ.name;
                for (x xVar : this.iaI) {
                    if (xVar.dOd == this.iaK) {
                        this.iaM = xVar.dOd;
                        this.iaL = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bQd() {
        if (this.iaI != null && !this.iaI.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(e.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(e.g.interval_view_cate).setVisibility(0);
            this.iaN = (PostCategoryView) linearLayout.findViewById(e.g.category_selected);
            this.iaN.setText(this.iaL);
            this.iaN.setCategoryContainerData(this.iaI, this.iaJ, this.iaM);
            this.iaN.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, at atVar) {
                    if (atVar != null) {
                        TransmitPostEditActivity.this.iaN.setText(atVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(atVar.dOd);
                        TransmitPostEditActivity.this.iaM = atVar.dOd;
                        TransmitPostEditActivity.this.iaN.bPE();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.iaN.bPD();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bQj());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bQi());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.ibd = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.ibd.setTitle(e.j.no_disturb_start_time);
        this.ibd.setButton(-1, getPageContext().getString(e.j.alert_yes_button), this.ibd);
        this.ibd.setButton(-2, getPageContext().getString(e.j.cancel), this.ibd);
        return this.ibd;
    }

    private void bQe() {
        this.iaE = (RelativeLayout) findViewById(e.g.addition_container);
        this.iaF = (TextView) findViewById(e.g.addition_create_time);
        this.iaG = (TextView) findViewById(e.g.addition_last_time);
        this.iaH = (TextView) findViewById(e.g.addition_last_content);
        if (this.iaD != null) {
            this.iaE.setVisibility(0);
            this.iaF.setText(getPageContext().getString(e.j.write_addition_create) + ao.M(this.iaD.getCreateTime() * 1000));
            if (this.iaD.getAlreadyCount() == 0) {
                this.iaG.setVisibility(8);
            } else {
                this.iaG.setText(getPageContext().getString(e.j.write_addition_last) + ao.M(this.iaD.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.iaD.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.iaH.setText(lastAdditionContent);
            } else {
                this.iaH.setVisibility(8);
            }
            bQi().setHint(String.format(getPageContext().getString(e.j.write_addition_hint), Integer.valueOf(this.iaD.getAlreadyCount()), Integer.valueOf(this.iaD.getTotalCount())));
            this.mName.setText(e.j.write_addition_title);
            return;
        }
        this.iaE.setVisibility(8);
    }

    private void bzR() {
        this.hdY = findViewById(e.g.post_prefix_layout);
        this.hdV = (TextView) findViewById(e.g.post_prefix);
        this.iaA = findViewById(e.g.prefix_divider);
        this.hdX = (ImageView) findViewById(e.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.hdY.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.hdy = 1;
            this.hdY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.hdV.setVisibility(0);
                    TransmitPostEditActivity.this.hdY.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.hdW, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.aYr.Kx();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.hdQ);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.hdU);
                }
            });
            this.hdX = (ImageView) findViewById(e.g.prefix_icon);
            if (size > 1) {
                this.hdX.setVisibility(0);
                this.hdV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.hdV.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.hdW, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.aYr.Kx();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bQj());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bQi());
                    }
                });
            }
            this.hdW = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.hdW.a(this);
            this.hdW.setMaxHeight(l.h(getActivity(), e.C0210e.ds510));
            this.hdW.setOutsideTouchable(true);
            this.hdW.setFocusable(true);
            this.hdW.setOnDismissListener(this);
            this.hdW.setBackgroundDrawable(al.getDrawable(e.d.cp_bg_line_d));
            int color = al.getColor(e.d.cp_cont_b);
            int color2 = al.getColor(e.d.cp_cont_c);
            al.i(this.hdV, e.d.cp_bg_line_d);
            al.c(this.hdX, e.f.icon_frs_arrow_n);
            this.hdV.setTextColor(color);
            this.iaB.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.iaB.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.hdW.addView(writePrefixItemLayout);
            }
            this.hdW.setCurrentIndex(0);
            this.hdV.setText(prefixs.get(1));
            xG(1);
            return;
        }
        this.hdY.setVisibility(8);
    }

    protected void bQf() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.kV()) {
                    TransmitPostEditActivity.this.showToast(e.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.iaV.a(TransmitPostEditActivity.this.hdQ, TransmitPostEditActivity.this.hdU)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.iaV.bNP());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bQj());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bQi());
                    TransmitPostEditActivity.this.aYr.Kx();
                    TiebaStatic.log(new am("c12608").x("obj_locate", 7));
                    TransmitPostEditActivity.this.bQp();
                }
            }
        });
    }

    protected void bzS() {
        this.hdQ = (EditText) findViewById(e.g.post_title);
        this.hdQ.setOnClickListener(this.iaZ);
        this.hdQ.setOnFocusChangeListener(this.hdO);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.hdQ.setText(this.mData.getTitle());
            this.hdQ.setSelection(this.mData.getTitle().length());
        }
        this.hdQ.addTextChangedListener(this.ibb);
        if (!this.mData.getHaveDraft()) {
            bQb();
        }
        this.hdQ.setHint(getResources().getString(e.j.post_title_hint));
    }

    protected void bzU() {
        this.hdU = (EditText) findViewById(e.g.post_content);
        this.hdU.setDrawingCacheEnabled(false);
        this.hdU.setOnClickListener(this.iaZ);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString am = TbFaceManager.Nu().am(getPageContext().getPageActivity(), this.mData.getContent());
            this.hdU.setText(am);
            this.hdU.setSelection(am.length());
        }
        this.hdU.setOnFocusChangeListener(this.hdO);
        this.hdU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.aYr.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.hdU.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.hdU.addTextChangedListener(this.ibc);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.hdU.setHint(e.j.share_video_default);
        } else {
            this.hdU.setHint(e.j.share_txt_default);
        }
    }

    private void bQg() {
        this.fKl = (OriginalThreadCardView) findViewById(e.g.write_original_thread_cardview);
        this.fKl.setVisibility(0);
        this.fKl.b(this.mOriginalThreadInfo);
        this.fKl.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bQh() {
        int i = UIMsg.m_AppUI.MSG_APP_GPS;
        if (this.iaD != null) {
            i = 1000;
        }
        return bQi().getText() != null && bQi().getText().length() >= i;
    }

    private void hK(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.iau)) {
                this.iau = "";
                bQi().requestFocus();
                if (bQi().getText() != null && bQi().getText().length() + str.length() > 5000) {
                    showToast(e.j.over_limit_tip);
                    return;
                } else {
                    i = bQi().getSelectionStart();
                    editable = bQi().getText();
                }
            } else if ("from_title".equals(this.iau)) {
                this.iau = "";
                bQj().requestFocus();
                if (bQj().getText() != null && bQj().getText().length() + str.length() > 31) {
                    showToast(e.j.over_limit_tip);
                    return;
                } else {
                    i = bQj().getSelectionStart();
                    editable = bQj().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oG(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.d(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void d(p pVar) {
        if (((ImageSpan[]) bQi().getText().getSpans(0, bQi().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.iaC == null) {
                this.iaC = Toast.makeText(getPageContext().getPageActivity(), e.j.too_many_face, 0);
            }
            this.iaC.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType GN = pVar.GN();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.jA().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.bQi().getSelectionStart(), aVar, GN);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bQi() != null && bQi().getText() != null) {
            Bitmap op = aVar.op();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(op);
            int width = op.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, op.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.i(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bQi().getSelectionStart() - 1;
                if (bQi().getText().length() > 1 && selectionStart >= 0 && bQi().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bQi().getText().insert(bQi().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bQi().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bQi().getText().insert(bQi().getSelectionStart(), spannableString2);
            }
            Editable text = bQi().getText();
            if (text != null) {
                this.iaS.clear();
                this.iaS.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.iaS);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bQi().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bQi().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bQi().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bQi() {
        return this.hdU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bQj() {
        return this.hdQ;
    }

    protected void bQk() {
        Editable text;
        if (bQi() != null && (text = bQi().getText()) != null) {
            int selectionStart = bQi().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bQi().onKeyDown(67, this.dtF);
            }
            bQi().onKeyDown(67, this.dtF);
            int selectionStart2 = bQi().getSelectionStart();
            this.iaS.clear();
            this.iaS.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.iaS);
            bQi().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.bif.d(null);
        this.bif.ec(e.j.sending);
        this.bif.bA(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.bif.bA(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzT() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bQj() != null) {
                str = bQj().getText().toString();
            }
            if (bQi() != null) {
                str2 = bQi().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.hdy == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            oH(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        oH(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    oH(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.iaP) {
                    oH(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    oH(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                oH(true);
            } else if (this.mData.getVideoInfo() != null) {
                oH(true);
            } else {
                oH(false);
            }
        }
    }

    private void oH(boolean z) {
        al.b(this.mPost, e.d.cp_link_tip_a, e.d.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.aZU = new NewWriteModel(this);
        this.aZU.b(this.bai);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.bzL();
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
                this.iaD = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.iaD != null);
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
            this.ehA = bundle.getString("KEY_CALL_FROM");
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
            this.iaD = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.iaD != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.ehA = intent.getStringExtra("KEY_CALL_FROM");
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
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(e.j.write_no_prefix));
        }
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.videoId != null) {
            this.mData.setVideoId(this.mOriginalThreadInfo.videoId);
            this.mData.setOriginalVideoCover(this.mOriginalThreadInfo.showPicUrl);
            this.mData.setOriginalVideoTitle(this.mOriginalThreadInfo.showText);
        }
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.iaw = true;
        }
        bQc();
    }

    private void bQl() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.d(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.hdQ.setText(com.baidu.tbadk.plugins.b.it(com.baidu.tbadk.plugins.b.iu(hotTopicBussinessData.mTopicName)));
            this.hdQ.setMovementMethod(com.baidu.tieba.view.c.bMP());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString it = com.baidu.tbadk.plugins.b.it(com.baidu.tbadk.plugins.b.iu(hotTopicBussinessData.mTopicName));
            if (it != null) {
                this.hdQ.setText(it);
            }
            this.iaR.setText(hotTopicBussinessData.mForumName);
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
        if (this.iaD != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.iaD));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.ehA);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bQi().getEditableText().toString();
        if (obj != null) {
            bQi().setText(TbFaceManager.Nu().a(getPageContext().getPageActivity(), obj, this.iaX));
            bQi().setSelection(bQi().getText().length());
        }
    }

    private String bQm() {
        if (bQi() == null || bQi().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(bQi().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(e.j.share_video_default);
            }
            return getString(e.j.share_txt_default);
        }
        return bQi().getText().toString();
    }

    private String bQn() {
        if (this.mData == null || bQj() == null || bQj().getVisibility() != 0 || bQj().getText() == null) {
            return "";
        }
        String obj = bQj().getText().toString();
        if (this.mPrefixData != null && v.H(this.mPrefixData.getPrefixs()) > 0 && this.hdy != 0 && this.mData.getType() != 4 && this.hdV != null && this.hdV.getText() != null) {
            obj = this.hdV.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void bQo() {
        bzL();
        this.mData.setContent(bQm());
        this.mData.setTitle(bQn());
        if (this.iaK >= 0) {
            this.mData.setCategoryFrom(this.iaK);
        }
        if (this.iaM >= 0) {
            this.mData.setCategoryTo(this.iaM);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aZT != null && this.aZT.amo());
        this.aZU.nC(this.writeImagesInfo.size() > 0);
        if (!v.I(this.mList) && this.iaQ != null && this.iaQ.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.iaQ.mForumId));
            this.mData.setForumName(this.iaQ.mForumName);
        }
        this.aZU.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.aZU.getWriteData().setVoice(null);
        this.aZU.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.kV()) {
            showToast(e.j.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(e.j.sending), this.mDialogCancelListener);
        this.aZU.startPostWrite();
    }

    private void v(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.iaD != null) {
                i2 = this.iaD.getTotalCount();
                i = this.iaD.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(e.j.write_addition_left_count), Integer.valueOf(i2 - i)));
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
                if (this.aYr != null && !this.aYr.Mb()) {
                    bQi().requestFocus();
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
                            bQi().getText().insert(bQi().getSelectionStart(), sb.toString());
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
                        if (this.iav) {
                            sb2.append(com.baidu.tbadk.plugins.b.bhB);
                            this.iav = false;
                        }
                        sb2.append(stringExtra);
                        hK(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !v.I(this.mList) && !v.I(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.iaQ = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.iaQ);
            }
        } else if (i2 == 0) {
            if (this.aYr != null && !this.aYr.Mb()) {
                this.hdU.requestFocus();
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
                        this.iaV.xu(postWriteCallBackData.getErrorString());
                        this.iaV.aA(postWriteCallBackData.getSensitiveWords());
                        this.iaV.b(this.hdQ, this.hdU);
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.iau)) {
                        bQj().requestFocus();
                        return;
                    } else if ("from_content".equals(this.iau)) {
                        bQi().requestFocus();
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
    public void bQp() {
        if ("1".equals(this.ehA)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.ehA)) {
            this.mData.setCanNoForum(false);
        }
        bQq();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.ehA);
        bQo();
    }

    private void bQq() {
        if (this.aYr != null) {
            this.aYr.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bQj());
        HidenSoftKeyPad(this.mInputManager, bQi());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.aj(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dLU) != null) {
                    TiebaStatic.log(new am("c12534").x("obj_locate", as.a.aCL));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(e.j.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.iaD == null) {
                    if (!d(postWriteCallBackData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        return;
                    }
                    return;
                }
                v(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aZZ = i;
        if (this.aYr != null) {
            this.aYr.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bQr() {
        if (!this.iaP && this.aYr != null) {
            this.aYr.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.aYr.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(boolean z) {
        if (this.aYr != null) {
            this.aYr.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void xG(int i) {
        if (i < this.iaB.size()) {
            for (int i2 = 0; i2 < this.iaB.size(); i2++) {
                this.iaB.get(i2).ox(false);
            }
            this.iaB.get(i).ox(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void vg(int i) {
        this.hdy = i;
        this.hdW.setCurrentIndex(i);
        xG(i);
        this.hdV.setText(this.mPrefixData.getPrefixs().get(i));
        bzT();
        com.baidu.adp.lib.g.g.a(this.hdW, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.hdY.setSelected(false);
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            MA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.iaU = z;
        if (this.iaT != null && !z) {
            this.iaT.blO();
        }
        if (this.iaW != null && !z) {
            bPU();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(e.a.activity_open_from_bottom, e.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.iaU && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.iav = false;
            this.iau = "";
            if ("from_content".equals(str)) {
                this.iau = "from_content";
            } else if ("from_title".equals(str)) {
                this.iau = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.is(String.valueOf(charSequence.charAt(i)))) {
                oG(false);
            }
        }
    }

    public void bvX() {
        if (!v.I(this.mList)) {
            this.iay.setVisibility(0);
            this.iay.requestFocus();
            this.aYr.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.iay.setVisibility(8);
    }
}
