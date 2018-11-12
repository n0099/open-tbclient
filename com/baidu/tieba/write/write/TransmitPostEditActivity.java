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
    private EditorTools aUR;
    private LocationModel aWt;
    private NewWriteModel aWu;
    private OriginalThreadCardView fAD;
    private int gTC;
    private TextView gTZ;
    private com.baidu.tieba.write.d gUa;
    private ImageView gUb;
    private View gUc;
    private e hQB;
    private com.baidu.tieba.view.b hQI;
    private LinearLayout hQc;
    private LinearLayout hQd;
    private View hQf;
    private Toast hQh;
    private AdditionData hQi;
    private RelativeLayout hQj;
    private TextView hQk;
    private TextView hQl;
    private TextView hQm;
    List<x> hQn;
    x hQo;
    private int hQp;
    private String hQq;
    private int hQr;
    private PostCategoryView hQs;
    private HotTopicBussinessData hQv;
    private TextView hQw;
    private com.baidu.tieba.write.editor.b hQy;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String hPZ = "";
    private boolean hQa = false;
    private WriteData mData = null;
    private boolean hQb = false;
    private InputMethodManager mInputManager = null;
    private EditText gTU = null;
    private View gTV = null;
    private LinearLayout gTX = null;
    private EditText gTY = null;
    private FeedBackModel hQe = null;
    private ArrayList<WritePrefixItemLayout> hQg = new ArrayList<>();
    private final KeyEvent dkp = new KeyEvent(0, 67);
    private View aJu = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String aWy = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aWz = 0;
    private View mRootView = null;
    private ScrollView hQt = null;
    private boolean hQu = false;
    private com.baidu.tbadk.core.view.d beC = null;
    private String mFrom = "write";
    private String dYg = "2";
    private SpannableStringBuilder hQx = new SpannableStringBuilder();
    private boolean hQz = false;
    private final b hQA = new b();
    private TbFaceManager.a hQC = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan hL(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.oq());
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
    private final AntiHelper.a dCH = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").x("obj_locate", as.a.azk));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").x("obj_locate", as.a.azk));
        }
    };
    private final NewWriteModel.d aWI = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.hQA.az(null);
                if (z) {
                    TransmitPostEditActivity.this.cx(z);
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
                    TransmitPostEditActivity.this.hQA.wO(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.hQA.az(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.hQA.b(TransmitPostEditActivity.this.gTU, TransmitPostEditActivity.this.gTY);
                } else if ((wVar == null || writeData == null || wVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (wVar != null && writeData != null && wVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(wVar.getVcode_md5());
                    writeData.setVcodeUrl(wVar.getVcode_pic_url());
                    writeData.setVcodeExtra(wVar.FS());
                    if (com.baidu.tbadk.q.a.iA(wVar.FR())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, wVar.FR())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a aWG = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void LJ() {
            TransmitPostEditActivity.this.showToast(e.j.no_network_guide);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void hA(String str) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            if (StringUtils.isNull(str)) {
                str = TransmitPostEditActivity.this.getPageContext().getString(e.j.location_fail);
            }
            transmitPostEditActivity.showToast(str);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bBZ())) {
                TransmitPostEditActivity.this.b(2, true, aVar.bBZ());
            } else {
                hA(null);
            }
        }
    };
    private final CustomMessageListener hgG = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.aWt.nv(false);
                    TransmitPostEditActivity.this.aWt.cJ(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.aWt.nv(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hQD = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hQE = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.aUR.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bMU = TransmitPostEditActivity.this.bMU();
            if (bMU >= 0 && bMU < TransmitPostEditActivity.this.gTY.getText().length()) {
                TransmitPostEditActivity.this.gTY.setSelection(bMU);
            }
        }
    };
    private boolean hQF = true;
    private final View.OnFocusChangeListener gTS = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.gTU || view == TransmitPostEditActivity.this.aJu || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.hQF = true;
                    TransmitPostEditActivity.this.bMV();
                    if (TransmitPostEditActivity.this.aUR != null) {
                        TransmitPostEditActivity.this.aUR.Js();
                    }
                    l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gTU);
                } else if (view == TransmitPostEditActivity.this.gTU) {
                    TransmitPostEditActivity.this.gTZ.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.gTY && z) {
                TransmitPostEditActivity.this.hQF = false;
                TransmitPostEditActivity.this.bMV();
                TransmitPostEditActivity.this.aUR.Js();
                l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gTY);
            }
            TransmitPostEditActivity.this.bNb();
        }
    };
    private TextWatcher hQG = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String hQK = "";
        private String hQL;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hQL = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hQL != null ? this.hQL.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bxk();
            TransmitPostEditActivity.this.bNc();
            EditText bNn = TransmitPostEditActivity.this.bNn();
            if (editable != null && bNn != null && bNn.getText() != null) {
                if (this.hQK == null || !this.hQK.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.hQA != null) {
                        this.hQK = bNn.getText().toString();
                        TransmitPostEditActivity.this.hQA.k(bNn);
                        return;
                    }
                    return;
                }
                bNn.setSelection(bNn.getSelectionEnd());
            }
        }
    };
    private TextWatcher hQH = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String hQL;
        private String hQM = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hQL = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hQL != null ? this.hQL.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bxk();
            EditText bNm = TransmitPostEditActivity.this.bNm();
            if (editable != null && bNm != null && bNm.getText() != null) {
                int selectionEnd = bNm.getSelectionEnd();
                if (this.hQM == null || !this.hQM.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.hQA != null) {
                        this.hQM = bNm.getText().toString();
                        TransmitPostEditActivity.this.hQA.k(bNm);
                        return;
                    }
                    return;
                }
                bNm.setSelection(selectionEnd);
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
    public void Lu() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Lv() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(e.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Lx();
        } else if (this.aWt.bCg()) {
            Lu();
        } else {
            this.aWt.nv(false);
            b(1, true, null);
            this.aWt.bCe();
        }
    }

    private void Lx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cN(e.j.location_app_permission_prompt).a(e.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kV()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.aWt.akJ();
                } else {
                    TransmitPostEditActivity.this.aWG.LJ();
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
        aVar.AB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bMU() {
        int selectionEnd = bNm().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bNm().getText().getSpans(0, bNm().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bNm().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bNm().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMV() {
        if (this.aUR != null) {
            this.aUR.setBarLauncherEnabled(!this.hQF);
            this.aUR.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hQu) {
            this.gTU.setVisibility(8);
            bxk();
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
        this.aWt = new LocationModel(this);
        this.aWt.a(this.aWG);
        registerListener(this.hgG);
        registerListener(this.hQD);
        initEditor();
        this.gTY.requestFocus();
        btt();
        bNv();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aUR = new EditorTools(getActivity());
        this.aUR.setBarMaxLauCount(4);
        this.aUR.setMoreButtonAtEnd(true);
        this.aUR.setBarLauncherType(1);
        this.aUR.cp(true);
        this.aUR.cq(true);
        this.aUR.setMoreLauncherIcon(e.f.write_more);
        this.aUR.setBackgroundColorId(e.d.cp_bg_line_d);
        bMW();
        this.aUR.KU();
        if (this.hQc != null) {
            this.hQc.addView(this.aUR);
        }
        bMX();
        this.aUR.pO();
        com.baidu.tbadk.editortools.g ft = this.aUR.ft(6);
        if (ft != null && !TextUtils.isEmpty(this.aWy)) {
            ((View) ft).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.aWy);
                }
            });
        }
        if (!this.hQu) {
            this.aUR.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aUR.Js();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aUR.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aUR.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
        bMZ();
    }

    private void bMW() {
        com.baidu.tbadk.editortools.k kVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 2);
        aVar.aVy = e.f.write_at;
        this.aUR.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.aUR.b(aVar2);
        aVar2.aVy = e.f.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask != null && (kVar = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar.aVA = 4;
            kVar.aVy = e.f.icon_post_location_selector;
            this.aUR.b(kVar);
        }
        if (this.hQi == null) {
            if (this.hQy == null) {
                this.hQy = new com.baidu.tieba.write.editor.b(getActivity(), this.dYg);
                this.hQy.bLX();
                this.hQy.setFrom("from_share_write");
                this.hQy.aY(this.mData.getForumId(), this.mPrivateThread);
            }
            this.aUR.b(this.hQy);
        }
        this.aUR.w(arrayList);
        com.baidu.tbadk.editortools.k fw = this.aUR.fw(5);
        if (fw != null) {
            fw.aVA = 1;
            fw.aVy = e.f.write_emotion;
        }
    }

    private void bMX() {
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
                        if (TransmitPostEditActivity.this.bNl()) {
                            TransmitPostEditActivity.this.showToast(e.j.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.bNl()) {
                            TransmitPostEditActivity.this.showToast(e.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof p)) {
                            TransmitPostEditActivity.this.d((p) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.bNo();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.bxk();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.hQi == null) {
                            TransmitPostEditActivity.this.Ly();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.aWz) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.bz(pageActivity)) {
                                    TransmitPostEditActivity.this.Lv();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.Lu();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.aWt != null) {
                            TransmitPostEditActivity.this.aWt.nv(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        am amVar = new am("c10645");
                        if (TransmitPostEditActivity.this.mData != null) {
                            str = TransmitPostEditActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        amVar.ax(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(amVar);
                        if (TransmitPostEditActivity.this.mData == null || (videoInfo = TransmitPostEditActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.aUR.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.aUR.KW()) {
                                        TransmitPostEditActivity.this.aUR.Js();
                                        TransmitPostEditActivity.this.aUR.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.aUR.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.aUR.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.aUR.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.aUR.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.bxk();
                        if (TransmitPostEditActivity.this.gTY != null) {
                            TransmitPostEditActivity.this.gTY.requestFocus();
                        }
                        TransmitPostEditActivity.this.aUR.Js();
                        TransmitPostEditActivity.this.aUR.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gTY);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.aUR.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.hQa = true;
                        TransmitPostEditActivity.this.oB(true);
                        if (TransmitPostEditActivity.this.bNn().isFocused()) {
                            TransmitPostEditActivity.this.hPZ = "from_title";
                        } else if (TransmitPostEditActivity.this.bNm().isFocused()) {
                            TransmitPostEditActivity.this.hPZ = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.hQd.setVisibility(0);
                        TransmitPostEditActivity.this.hQd.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.hQd.hasFocus()) {
                            TransmitPostEditActivity.this.gTY.requestFocus();
                            TransmitPostEditActivity.this.gTY.setSelection(TransmitPostEditActivity.this.gTY.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.hQd.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aUR.setActionListener(31, bVar);
        this.aUR.setActionListener(16, bVar);
        this.aUR.setActionListener(14, bVar);
        this.aUR.setActionListener(24, bVar);
        this.aUR.setActionListener(3, bVar);
        this.aUR.setActionListener(10, bVar);
        this.aUR.setActionListener(11, bVar);
        this.aUR.setActionListener(12, bVar);
        this.aUR.setActionListener(13, bVar);
        this.aUR.setActionListener(15, bVar);
        this.aUR.setActionListener(18, bVar);
        this.aUR.setActionListener(20, bVar);
        this.aUR.setActionListener(25, bVar);
        this.aUR.setActionListener(27, bVar);
        this.aUR.setActionListener(29, bVar);
        this.aUR.setActionListener(43, bVar);
        this.aUR.setActionListener(45, bVar);
        this.aUR.setActionListener(53, bVar);
        this.aUR.setActionListener(48, bVar);
        this.aUR.setActionListener(46, bVar);
        this.aUR.setActionListener(49, bVar);
        this.aUR.setActionListener(47, bVar);
        this.aUR.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ly() {
        if (this.aWt.akF()) {
            if (this.aWt.bCg()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bCc().getLocationData().bBZ());
                return;
            }
            b(1, true, null);
            this.aWt.bCe();
            return;
        }
        b(0, true, null);
    }

    protected void bxc() {
        if (this.aWu != null) {
            this.aWu.cancelLoadData();
        }
        if (this.hQe != null) {
            this.hQe.cancelLoadData();
        }
        if (this.aWt != null) {
            this.aWt.cancelLoadData();
        }
    }

    private void bMY() {
        if (this.hQB != null) {
            this.hQB.hideTip();
        }
    }

    private void bMZ() {
        if (this.hQB == null) {
            this.hQB = new e(getPageContext());
        }
        this.hQB.c(this.aUR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bMY();
        TiebaPrepareImageService.StopService();
        bxc();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNa() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(bNn().getText().toString());
        this.mData.setContent(bNm().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.gUa != null && this.gUa.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gUa, getPageContext().getPageActivity());
                return true;
            } else if (this.aUR.KW()) {
                this.aUR.Js();
                return true;
            } else {
                bxc();
                bNa();
                return true;
            }
        }
        if (i == 67 && (text = bNm().getText()) != null) {
            int selectionStart = bNm().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bNm().onKeyDown(67, this.dkp);
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
        bMV();
        al.j(this.gTV, e.d.cp_bg_line_c);
        al.j(bNn(), e.d.cp_bg_line_d);
        al.j(bNm(), e.d.cp_bg_line_d);
        bxk();
        this.aUR.onChangeSkinType(i);
        if (this.hQs != null) {
            this.hQs.Ef();
        }
        al.h(this.mName, e.d.cp_cont_b);
        bNb();
        bNc();
        if (this.hQA != null) {
            this.hQA.c(bNn(), bNm());
        }
        this.fAD.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNb() {
        if (this.gTU.hasFocus()) {
            this.gTU.setHintTextColor(al.getColor(e.d.cp_cont_e));
        } else {
            this.gTU.setHintTextColor(al.getColor(e.d.cp_cont_d));
        }
        if (this.gTY.hasFocus()) {
            this.gTY.setHintTextColor(al.getColor(e.d.cp_cont_e));
        } else {
            this.gTY.setHintTextColor(al.getColor(e.d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNc() {
        if (this.gTU != null) {
            if (this.gTU.getText().toString().length() == 0) {
                this.gTU.getPaint().setFakeBoldText(false);
            } else if (this.gTU.getText().toString().length() > 0) {
                this.gTU.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.beC = new com.baidu.tbadk.core.view.d(getPageContext());
        this.hQu = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(e.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aJu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(e.f.icon_topbar_close, e.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        al.h(this.mName, e.d.cp_cont_b);
        bNe();
        this.hQt = (ScrollView) findViewById(e.g.write_scrollview);
        this.hQt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.gTY != null) {
                        l.b(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.gTY);
                    }
                    if (TransmitPostEditActivity.this.aUR != null) {
                        TransmitPostEditActivity.this.aUR.Js();
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
        this.hQc = (LinearLayout) findViewById(e.g.tool_view);
        this.hQc.setContentDescription("..");
        this.hQd = (LinearLayout) findViewById(e.g.title_view);
        this.gTV = findViewById(e.g.interval_view);
        this.hQw = (TextView) findViewById(e.g.hot_topic_title_edt);
        bxj();
        if (this.hQu) {
            this.hQt.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        bxl();
        bNk();
        this.gTX = (LinearLayout) findViewById(e.g.post_content_container);
        this.gTX.setDrawingCacheEnabled(false);
        this.gTX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.aUR.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.gTY.requestFocus();
            }
        });
        this.aJu.setOnFocusChangeListener(this.gTS);
        this.aJu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.bxc();
                TransmitPostEditActivity.this.bNa();
            }
        });
        bNh();
        bNj();
        bNd();
        bMV();
        bNi();
        bxi();
        bNp();
        if (this.mData.getType() == 4 && this.gUc != null && this.hQf != null) {
            this.gUc.setVisibility(8);
            this.hQf.setVisibility(8);
        }
        bxk();
        ShowSoftKeyPad(this.mInputManager, this.gTU);
    }

    private void bNd() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.dYg != null && this.dYg.equals("1")) {
                        this.mName.setText(e.j.share_to_home_page);
                    } else if (this.dYg != null && this.dYg.equals("2")) {
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
                    this.gTU.setVisibility(0);
                    this.gTY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 4:
                    this.mName.setText(e.j.publish_photo_live);
                    this.gTY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                default:
                    this.mName.setText(e.j.send_reply);
                    this.gTY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gTU.setVisibility(8);
                    return;
            }
        }
    }

    private void bNe() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0200e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.gTS);
    }

    private void bNf() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hQb && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = ao.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && bNn() != null) {
                bNn().setText(c);
                bNn().setSelection(c.length());
            }
        }
    }

    private void bNg() {
        this.hQn = null;
        this.hQp = -1;
        this.hQr = -1;
        z lX = y.aAH().lX(1);
        if (lX != null) {
            this.hQn = lX.dEU;
            this.hQp = getIntent().getIntExtra("category_id", -1);
            if (this.hQn != null && !this.hQn.isEmpty() && this.hQp >= 0) {
                this.hQo = new x();
                this.hQo.dEQ = 0;
                this.hQo.name = getPageContext().getResources().getString(e.j.category_auto);
                this.hQr = this.hQo.dEQ;
                this.hQq = this.hQo.name;
                for (x xVar : this.hQn) {
                    if (xVar.dEQ == this.hQp) {
                        this.hQr = xVar.dEQ;
                        this.hQq = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bNh() {
        if (this.hQn != null && !this.hQn.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(e.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(e.g.interval_view_cate).setVisibility(0);
            this.hQs = (PostCategoryView) linearLayout.findViewById(e.g.category_selected);
            this.hQs.setText(this.hQq);
            this.hQs.setCategoryContainerData(this.hQn, this.hQo, this.hQr);
            this.hQs.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, at atVar) {
                    if (atVar != null) {
                        TransmitPostEditActivity.this.hQs.setText(atVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(atVar.dEQ);
                        TransmitPostEditActivity.this.hQr = atVar.dEQ;
                        TransmitPostEditActivity.this.hQs.bMI();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.hQs.bMH();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bNn());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bNm());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hQI = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hQI.setTitle(e.j.no_disturb_start_time);
        this.hQI.setButton(-1, getPageContext().getString(e.j.alert_yes_button), this.hQI);
        this.hQI.setButton(-2, getPageContext().getString(e.j.cancel), this.hQI);
        return this.hQI;
    }

    private void bNi() {
        this.hQj = (RelativeLayout) findViewById(e.g.addition_container);
        this.hQk = (TextView) findViewById(e.g.addition_create_time);
        this.hQl = (TextView) findViewById(e.g.addition_last_time);
        this.hQm = (TextView) findViewById(e.g.addition_last_content);
        if (this.hQi != null) {
            this.hQj.setVisibility(0);
            this.hQk.setText(getPageContext().getString(e.j.write_addition_create) + ao.E(this.hQi.getCreateTime() * 1000));
            if (this.hQi.getAlreadyCount() == 0) {
                this.hQl.setVisibility(8);
            } else {
                this.hQl.setText(getPageContext().getString(e.j.write_addition_last) + ao.E(this.hQi.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hQi.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hQm.setText(lastAdditionContent);
            } else {
                this.hQm.setVisibility(8);
            }
            bNm().setHint(String.format(getPageContext().getString(e.j.write_addition_hint), Integer.valueOf(this.hQi.getAlreadyCount()), Integer.valueOf(this.hQi.getTotalCount())));
            this.mName.setText(e.j.write_addition_title);
            return;
        }
        this.hQj.setVisibility(8);
    }

    private void bxi() {
        this.gUc = findViewById(e.g.post_prefix_layout);
        this.gTZ = (TextView) findViewById(e.g.post_prefix);
        this.hQf = findViewById(e.g.prefix_divider);
        this.gUb = (ImageView) findViewById(e.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gUc.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gTC = 1;
            this.gUc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.gTZ.setVisibility(0);
                    TransmitPostEditActivity.this.gUc.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gUa, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.aUR.Js();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gTU);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gTY);
                }
            });
            this.gUb = (ImageView) findViewById(e.g.prefix_icon);
            if (size > 1) {
                this.gUb.setVisibility(0);
                this.gTZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.gTZ.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gUa, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.aUR.Js();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bNn());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bNm());
                    }
                });
            }
            this.gUa = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.gUa.a(this);
            this.gUa.setMaxHeight(l.h(getActivity(), e.C0200e.ds510));
            this.gUa.setOutsideTouchable(true);
            this.gUa.setFocusable(true);
            this.gUa.setOnDismissListener(this);
            this.gUa.setBackgroundDrawable(al.getDrawable(e.d.cp_bg_line_d));
            int color = al.getColor(e.d.cp_cont_b);
            int color2 = al.getColor(e.d.cp_cont_c);
            al.i(this.gTZ, e.d.cp_bg_line_d);
            al.c(this.gUb, e.f.icon_frs_arrow_n);
            this.gTZ.setTextColor(color);
            this.hQg.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.hQg.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.gUa.addView(writePrefixItemLayout);
            }
            this.gUa.setCurrentIndex(0);
            this.gTZ.setText(prefixs.get(1));
            wW(1);
            return;
        }
        this.gUc.setVisibility(8);
    }

    protected void bNj() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.kV()) {
                    TransmitPostEditActivity.this.showToast(e.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.hQA.a(TransmitPostEditActivity.this.gTU, TransmitPostEditActivity.this.gTY)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.hQA.bKT());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bNn());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bNm());
                    TransmitPostEditActivity.this.aUR.Js();
                    TiebaStatic.log(new am("c12608").x("obj_locate", 7));
                    TransmitPostEditActivity.this.bNt();
                }
            }
        });
    }

    protected void bxj() {
        this.gTU = (EditText) findViewById(e.g.post_title);
        this.gTU.setOnClickListener(this.hQE);
        this.gTU.setOnFocusChangeListener(this.gTS);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.gTU.setText(this.mData.getTitle());
            this.gTU.setSelection(this.mData.getTitle().length());
        }
        this.gTU.addTextChangedListener(this.hQG);
        if (!this.mData.getHaveDraft()) {
            bNf();
        }
        this.gTU.setHint(getResources().getString(e.j.post_title_hint));
    }

    protected void bxl() {
        this.gTY = (EditText) findViewById(e.g.post_content);
        this.gTY.setDrawingCacheEnabled(false);
        this.gTY.setOnClickListener(this.hQE);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString aj = TbFaceManager.Mp().aj(getPageContext().getPageActivity(), this.mData.getContent());
            this.gTY.setText(aj);
            this.gTY.setSelection(aj.length());
        }
        this.gTY.setOnFocusChangeListener(this.gTS);
        this.gTY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.aUR.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.gTY.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gTY.addTextChangedListener(this.hQH);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.gTY.setHint(e.j.share_video_default);
        } else {
            this.gTY.setHint(e.j.share_txt_default);
        }
    }

    private void bNk() {
        this.fAD = (OriginalThreadCardView) findViewById(e.g.write_original_thread_cardview);
        this.fAD.setVisibility(0);
        this.fAD.b(this.mOriginalThreadInfo);
        this.fAD.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bNl() {
        int i = UIMsg.m_AppUI.MSG_APP_GPS;
        if (this.hQi != null) {
            i = 1000;
        }
        return bNm().getText() != null && bNm().getText().length() >= i;
    }

    private void hr(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hPZ)) {
                this.hPZ = "";
                bNm().requestFocus();
                if (bNm().getText() != null && bNm().getText().length() + str.length() > 5000) {
                    showToast(e.j.over_limit_tip);
                    return;
                } else {
                    i = bNm().getSelectionStart();
                    editable = bNm().getText();
                }
            } else if ("from_title".equals(this.hPZ)) {
                this.hPZ = "";
                bNn().requestFocus();
                if (bNn().getText() != null && bNn().getText().length() + str.length() > 31) {
                    showToast(e.j.over_limit_tip);
                    return;
                } else {
                    i = bNn().getSelectionStart();
                    editable = bNn().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oB(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.d(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void d(p pVar) {
        if (((ImageSpan[]) bNm().getText().getSpans(0, bNm().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hQh == null) {
                this.hQh = Toast.makeText(getPageContext().getPageActivity(), e.j.too_many_face, 0);
            }
            this.hQh.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType FI = pVar.FI();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.jA().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.bNm().getSelectionStart(), aVar, FI);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bNm() != null && bNm().getText() != null) {
            Bitmap oq = aVar.oq();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(oq);
            int width = oq.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, oq.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.i(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bNm().getSelectionStart() - 1;
                if (bNm().getText().length() > 1 && selectionStart >= 0 && bNm().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bNm().getText().insert(bNm().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bNm().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bNm().getText().insert(bNm().getSelectionStart(), spannableString2);
            }
            Editable text = bNm().getText();
            if (text != null) {
                this.hQx.clear();
                this.hQx.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hQx);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bNm().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bNm().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bNm().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bNm() {
        return this.gTY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bNn() {
        return this.gTU;
    }

    protected void bNo() {
        Editable text;
        if (bNm() != null && (text = bNm().getText()) != null) {
            int selectionStart = bNm().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bNm().onKeyDown(67, this.dkp);
            }
            bNm().onKeyDown(67, this.dkp);
            int selectionStart2 = bNm().getSelectionStart();
            this.hQx.clear();
            this.hQx.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.hQx);
            bNm().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.beC.d(null);
        this.beC.dO(e.j.sending);
        this.beC.bz(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.beC.bz(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxk() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bNn() != null) {
                str = bNn().getText().toString();
            }
            if (bNm() != null) {
                str2 = bNm().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.gTC == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            oC(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        oC(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    oC(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hQu) {
                    oC(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    oC(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                oC(true);
            } else if (this.mData.getVideoInfo() != null) {
                oC(true);
            } else {
                oC(false);
            }
        }
    }

    private void oC(boolean z) {
        al.b(this.mPost, e.d.cp_link_tip_a, e.d.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.aWu = new NewWriteModel(this);
        this.aWu.b(this.aWI);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.bxc();
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
                this.hQi = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hQi != null);
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
            this.dYg = bundle.getString("KEY_CALL_FROM");
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
            this.hQi = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hQi != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.dYg = intent.getStringExtra("KEY_CALL_FROM");
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
            this.hQb = true;
        }
        bNg();
    }

    private void bNp() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.d(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.gTU.setText(com.baidu.tbadk.plugins.b.ia(com.baidu.tbadk.plugins.b.ib(hotTopicBussinessData.mTopicName)));
            this.gTU.setMovementMethod(com.baidu.tieba.view.c.bJV());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString ia = com.baidu.tbadk.plugins.b.ia(com.baidu.tbadk.plugins.b.ib(hotTopicBussinessData.mTopicName));
            if (ia != null) {
                this.gTU.setText(ia);
            }
            this.hQw.setText(hotTopicBussinessData.mForumName);
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
        if (this.hQi != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hQi));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.dYg);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bNm().getEditableText().toString();
        if (obj != null) {
            bNm().setText(TbFaceManager.Mp().a(getPageContext().getPageActivity(), obj, this.hQC));
            bNm().setSelection(bNm().getText().length());
        }
    }

    private String bNq() {
        if (bNm() == null || bNm().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(bNm().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(e.j.share_video_default);
            }
            return getString(e.j.share_txt_default);
        }
        return bNm().getText().toString();
    }

    private String bNr() {
        if (this.mData == null || bNn() == null || bNn().getVisibility() != 0 || bNn().getText() == null) {
            return "";
        }
        String obj = bNn().getText().toString();
        if (this.mPrefixData != null && v.H(this.mPrefixData.getPrefixs()) > 0 && this.gTC != 0 && this.mData.getType() != 4 && this.gTZ != null && this.gTZ.getText() != null) {
            obj = this.gTZ.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void bNs() {
        bxc();
        this.mData.setContent(bNq());
        this.mData.setTitle(bNr());
        if (this.hQp >= 0) {
            this.mData.setCategoryFrom(this.hQp);
        }
        if (this.hQr >= 0) {
            this.mData.setCategoryTo(this.hQr);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aWt != null && this.aWt.akF());
        this.aWu.nx(this.writeImagesInfo.size() > 0);
        if (!v.I(this.mList) && this.hQv != null && this.hQv.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hQv.mForumId));
            this.mData.setForumName(this.hQv.mForumName);
        }
        this.aWu.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.aWu.getWriteData().setVoice(null);
        this.aWu.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.kV()) {
            showToast(e.j.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(e.j.sending), this.mDialogCancelListener);
        this.aWu.startPostWrite();
    }

    private void u(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.hQi != null) {
                i2 = this.hQi.getTotalCount();
                i = this.hQi.getAlreadyCount() + 1;
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
                if (this.aUR != null && !this.aUR.KW()) {
                    bNm().requestFocus();
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
                            bNm().getText().insert(bNm().getSelectionStart(), sb.toString());
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
                        if (this.hQa) {
                            sb2.append(com.baidu.tbadk.plugins.b.bdX);
                            this.hQa = false;
                        }
                        sb2.append(stringExtra);
                        hr(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !v.I(this.mList) && !v.I(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.hQv = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.hQv);
            }
        } else if (i2 == 0) {
            if (this.aUR != null && !this.aUR.KW()) {
                this.gTY.requestFocus();
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
                        this.hQA.wO(postWriteCallBackData.getErrorString());
                        this.hQA.az(postWriteCallBackData.getSensitiveWords());
                        this.hQA.b(this.gTU, this.gTY);
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.hPZ)) {
                        bNn().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hPZ)) {
                        bNm().requestFocus();
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
    public void bNt() {
        if ("1".equals(this.dYg)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.dYg)) {
            this.mData.setCanNoForum(false);
        }
        bNu();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.dYg);
        bNs();
    }

    private void bNu() {
        if (this.aUR != null) {
            this.aUR.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bNn());
        HidenSoftKeyPad(this.mInputManager, bNm());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.ai(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dCH) != null) {
                    TiebaStatic.log(new am("c12534").x("obj_locate", as.a.azk));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(e.j.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hQi == null) {
                    if (!d(postWriteCallBackData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        return;
                    }
                    return;
                }
                u(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aWz = i;
        if (this.aUR != null) {
            this.aUR.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bNv() {
        if (!this.hQu && this.aUR != null) {
            this.aUR.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.aUR.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx(boolean z) {
        if (this.aUR != null) {
            this.aUR.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void wW(int i) {
        if (i < this.hQg.size()) {
            for (int i2 = 0; i2 < this.hQg.size(); i2++) {
                this.hQg.get(i2).os(false);
            }
            this.hQg.get(i).os(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void ux(int i) {
        this.gTC = i;
        this.gUa.setCurrentIndex(i);
        wW(i);
        this.gTZ.setText(this.mPrefixData.getPrefixs().get(i));
        bxk();
        com.baidu.adp.lib.g.g.a(this.gUa, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gUc.setSelected(false);
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
            Lv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.hQz = z;
        if (this.hQy != null && !z) {
            this.hQy.atH();
        }
        if (this.hQB != null && !z) {
            bMY();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(e.a.activity_open_from_bottom, e.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.hQz && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hQa = false;
            this.hPZ = "";
            if ("from_content".equals(str)) {
                this.hPZ = "from_content";
            } else if ("from_title".equals(str)) {
                this.hPZ = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.hZ(String.valueOf(charSequence.charAt(i)))) {
                oB(false);
            }
        }
    }

    public void btt() {
        if (!v.I(this.mList)) {
            this.hQd.setVisibility(0);
            this.hQd.requestFocus();
            this.aUR.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hQd.setVisibility(8);
    }
}
