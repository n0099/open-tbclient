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
import android.os.Build;
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
import com.baidu.android.common.others.IStringUtil;
import com.baidu.h.a.a;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.b.c.b;
import com.baidu.tieba.write.i;
import com.baidu.tieba.write.upload.ForwardUploadData;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.tieba.write.view.PostCategoryView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes2.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0125a, i.a {
    private OriginalThreadCardView afK;
    private EditorTools elb;
    private LocationModel emG;
    private NewWriteModel emH;
    List<aa> fns;
    private String hlk;
    private String hll;
    private boolean isPrivacy;
    private FrsTabInfoData lRr;
    private ForumTabSelectedView lVS;
    private TextView lXA;
    private TextView lXB;
    private TextView lXC;
    aa lXD;
    private int lXE;
    private String lXF;
    private int lXG;
    private PostCategoryView lXH;
    private HotTopicBussinessData lXK;
    private TextView lXL;
    private com.baidu.tieba.write.editor.b lXN;
    private e lXP;
    private com.baidu.tieba.view.b lXW;
    private OriginalThreadInfo.ShareInfo lXq;
    private LinearLayout lXs;
    private LinearLayout lXt;
    private View lXv;
    private Toast lXx;
    private AdditionData lXy;
    private RelativeLayout lXz;
    private TextView laA;
    private com.baidu.tieba.write.i laB;
    private ImageView laC;
    private View laD;
    private int lac;
    private BaijiahaoData mBaijiahaoData;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String lXo = "";
    private boolean lXp = false;
    private WriteData lab = null;
    private boolean lXr = false;
    private InputMethodManager mInputManager = null;
    private EditText lau = null;
    private View lav = null;
    private LinearLayout lax = null;
    private EditText lay = null;
    private FeedBackModel lXu = null;
    private ArrayList<WritePrefixItemLayout> lXw = new ArrayList<>();
    private final KeyEvent gZr = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView laz = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener heh = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout isn = null;
    private String emL = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int emM = 0;
    private View mRootView = null;
    private ScrollView lXI = null;
    private boolean lXJ = false;
    private com.baidu.tbadk.core.view.a euw = null;
    private String mFrom = "write";
    private String hOj = "2";
    private SpannableStringBuilder lXM = new SpannableStringBuilder();
    private boolean aUD = false;
    private final b lXO = new b();
    private boolean lVx = false;
    private TbFaceManager.a lXQ = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan yt(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.getRawBitmap());
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
    private final AntiHelper.a hoq = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", at.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", at.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d emV = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.aa aaVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.lab != null) {
                TransmitPostEditActivity.this.lXO.aX(null);
                if (z) {
                    TransmitPostEditActivity.this.ie(z);
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
                    TransmitPostEditActivity.this.lXO.Of(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.lXO.aX(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.lXO.b(TransmitPostEditActivity.this.lau, TransmitPostEditActivity.this.lay);
                } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aYm());
                    if (com.baidu.tbadk.s.a.yX(aaVar.aYl())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aYl())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a emT = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bdN() {
            TransmitPostEditActivity.this.showToast(R.string.no_network_guide);
            TransmitPostEditActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void onFail(String str) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            if (StringUtils.isNull(str)) {
                str = TransmitPostEditActivity.this.getPageContext().getString(R.string.location_fail);
            }
            transmitPostEditActivity.showToast(str);
            TransmitPostEditActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.dea())) {
                TransmitPostEditActivity.this.a(2, true, aVar.dea());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener lnq = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.emG.uw(false);
                    TransmitPostEditActivity.this.emG.fu(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.emG.uw(true);
                TransmitPostEditActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener lXR = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener lXS = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.elb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int doe = TransmitPostEditActivity.this.doe();
            if (doe >= 0 && doe < TransmitPostEditActivity.this.lay.getText().length()) {
                TransmitPostEditActivity.this.lay.setSelection(doe);
            }
        }
    };
    private boolean lXT = true;
    private final View.OnFocusChangeListener fPd = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.lau || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.laz) {
                if (z) {
                    TransmitPostEditActivity.this.lXT = true;
                    TransmitPostEditActivity.this.dof();
                    if (TransmitPostEditActivity.this.elb != null) {
                        TransmitPostEditActivity.this.elb.bbz();
                    }
                    l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.lau);
                } else if (view == TransmitPostEditActivity.this.lau) {
                    TransmitPostEditActivity.this.laA.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.lay && z) {
                TransmitPostEditActivity.this.lXT = false;
                TransmitPostEditActivity.this.dof();
                TransmitPostEditActivity.this.elb.bbz();
                l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.lay);
            }
            TransmitPostEditActivity.this.dok();
        }
    };
    private TextWatcher lXU = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String lXY = "";
        private String lXZ;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.lXZ = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.lXZ != null ? this.lXZ.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cZW();
            TransmitPostEditActivity.this.dol();
            EditText dox = TransmitPostEditActivity.this.dox();
            if (editable != null && dox != null && dox.getText() != null) {
                if (this.lXY == null || !this.lXY.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.lXO != null) {
                        this.lXY = dox.getText().toString();
                        TransmitPostEditActivity.this.lXO.b(dox, true);
                        return;
                    }
                    return;
                }
                dox.setSelection(dox.getSelectionEnd());
            }
        }
    };
    private TextWatcher lXV = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String lXZ;
        private String lYa = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.lXZ = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.lXZ != null ? this.lXZ.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cZW();
            EditText dow = TransmitPostEditActivity.this.dow();
            if (editable != null && dow != null && dow.getText() != null) {
                int selectionEnd = dow.getSelectionEnd();
                if (this.lYa == null || !this.lYa.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.lXO != null) {
                        this.lYa = dow.getText().toString();
                        TransmitPostEditActivity.this.lXO.b(dow, false);
                        return;
                    }
                    return;
                }
                dow.setSelection(selectionEnd);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdx() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void bdy() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bdA();
        } else if (this.emG.deh()) {
            bdx();
        } else {
            this.emG.uw(false);
            a(1, true, (String) null);
            this.emG.def();
        }
    }

    private void bdA() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.kD(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.a(1, true, (String) null);
                    TransmitPostEditActivity.this.emG.dej();
                } else {
                    TransmitPostEditActivity.this.emT.bdN();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TransmitPostEditActivity.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.aST();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int doe() {
        int selectionEnd = dow().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dow().getText().getSpans(0, dow().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dow().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dow().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dof() {
        if (this.elb != null) {
            this.elb.setBarLauncherEnabled(!this.lXT);
            this.elb.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lXJ) {
            this.lau.setVisibility(8);
            cZW();
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
        this.emG = new LocationModel(getPageContext());
        this.emG.a(this.emT);
        registerListener(this.lnq);
        registerListener(this.lXR);
        cxp();
        this.lay.requestFocus();
        cUW();
        doF();
    }

    @SuppressLint({"ResourceAsColor"})
    private void cxp() {
        this.elb = new EditorTools(getActivity());
        this.elb.setBarMaxLauCount(4);
        this.elb.setMoreButtonAtEnd(true);
        this.elb.setBarLauncherType(1);
        this.elb.hW(true);
        this.elb.hX(true);
        this.elb.setBackgroundColorId(R.color.cp_bg_line_h);
        dog();
        this.elb.build();
        if (this.lVx) {
            this.elb.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        }
        if (this.lXs != null) {
            this.lXs.addView(this.elb);
        }
        crh();
        this.elb.display();
        com.baidu.tbadk.editortools.g nc = this.elb.nc(6);
        if (nc != null && !TextUtils.isEmpty(this.emL)) {
            ((View) nc).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.emL);
                }
            });
        }
        if (!this.lXJ) {
            this.elb.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.elb.bbz();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.elb.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.elb.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.lab.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.lab.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        if (!this.lVx) {
            doi();
        }
    }

    private void dog() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.l lVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.elb.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        if (!this.lVx) {
            this.elb.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 3));
        }
        if (!this.lVx && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar.elL = 4;
            lVar.elH = R.drawable.icon_post_location_selector;
            lVar.elJ = false;
            this.elb.b(lVar);
        }
        if (!this.lVx && this.lXy == null) {
            if (this.lXN == null) {
                this.lXN = new com.baidu.tieba.write.editor.b(getActivity(), this.hOj);
                this.lXN.dmS();
                this.lXN.setFrom("from_share_write");
                this.lXN.bK(this.lab.getForumId(), this.mPrivateThread);
            }
            this.elb.b(this.lXN);
        }
        this.elb.aM(arrayList);
        com.baidu.tbadk.editortools.l nf = this.elb.nf(5);
        if (nf != null) {
            nf.elL = 1;
            if (this.lVx) {
                nf.hZ(false);
            }
        }
    }

    private void crh() {
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
                            TiebaStatic.log(new an("c12608").ag("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.dov()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.dov()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof q)) {
                            TransmitPostEditActivity.this.e((q) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.doy();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.cZW();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.lXy == null) {
                            TransmitPostEditActivity.this.bdB();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.emM) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.checkLocationForGoogle(pageActivity)) {
                                    TransmitPostEditActivity.this.bdy();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.bdx();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.emG != null) {
                            TransmitPostEditActivity.this.emG.uw(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        an anVar = new an("c10645");
                        if (TransmitPostEditActivity.this.lab != null) {
                            str = TransmitPostEditActivity.this.lab.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.dh("fid", str);
                        TiebaStatic.log(anVar);
                        if (TransmitPostEditActivity.this.lab == null || (videoInfo = TransmitPostEditActivity.this.lab.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.elb.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.elb.bcY()) {
                                        TransmitPostEditActivity.this.elb.bbz();
                                        TransmitPostEditActivity.this.elb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(TransmitPostEditActivity.this.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(TransmitPostEditActivity.this.getPageContext(), TransmitPostEditActivity.this.getResources().getString(R.string.plugin_video_not_active), TransmitPostEditActivity.this.getResources().getString(R.string.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(TransmitPostEditActivity.this.getPageContext(), TransmitPostEditActivity.this.getResources().getString(R.string.plugin_video_install_tips), TransmitPostEditActivity.this.getResources().getString(R.string.plugin_go_install));
                            return;
                        }
                        TransmitPostEditActivity.this.elb.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.elb.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.elb.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.elb.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.lab.setVideoInfo(null);
                        TransmitPostEditActivity.this.cZW();
                        if (TransmitPostEditActivity.this.lay != null) {
                            TransmitPostEditActivity.this.lay.requestFocus();
                        }
                        TransmitPostEditActivity.this.elb.bbz();
                        TransmitPostEditActivity.this.elb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.lay);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.elb.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.lXp = true;
                        TransmitPostEditActivity.this.vz(true);
                        if (TransmitPostEditActivity.this.dox().isFocused()) {
                            TransmitPostEditActivity.this.lXo = "from_title";
                        } else if (TransmitPostEditActivity.this.dow().isFocused()) {
                            TransmitPostEditActivity.this.lXo = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.lXt.setVisibility(0);
                        TransmitPostEditActivity.this.lXt.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.lXt.hasFocus()) {
                            TransmitPostEditActivity.this.lay.requestFocus();
                            TransmitPostEditActivity.this.lay.setSelection(TransmitPostEditActivity.this.lay.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.lXt.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.elb.setActionListener(31, bVar);
        this.elb.setActionListener(16, bVar);
        this.elb.setActionListener(14, bVar);
        this.elb.setActionListener(24, bVar);
        this.elb.setActionListener(3, bVar);
        this.elb.setActionListener(10, bVar);
        this.elb.setActionListener(11, bVar);
        this.elb.setActionListener(12, bVar);
        this.elb.setActionListener(13, bVar);
        this.elb.setActionListener(15, bVar);
        this.elb.setActionListener(18, bVar);
        this.elb.setActionListener(20, bVar);
        this.elb.setActionListener(25, bVar);
        this.elb.setActionListener(27, bVar);
        this.elb.setActionListener(29, bVar);
        this.elb.setActionListener(43, bVar);
        this.elb.setActionListener(45, bVar);
        this.elb.setActionListener(53, bVar);
        this.elb.setActionListener(48, bVar);
        this.elb.setActionListener(46, bVar);
        this.elb.setActionListener(49, bVar);
        this.elb.setActionListener(47, bVar);
        this.elb.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdB() {
        if (this.emG.bHm()) {
            if (this.emG.deh()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.dec().getLocationData().dea());
                return;
            }
            a(1, true, (String) null);
            this.emG.def();
            return;
        }
        a(0, true, (String) null);
    }

    protected void cZN() {
        if (this.emH != null) {
            this.emH.cancelLoadData();
        }
        if (this.lXu != null) {
            this.lXu.cancelLoadData();
        }
        if (this.emG != null) {
            this.emG.cancelLoadData();
        }
    }

    private void doh() {
        if (this.lXP != null) {
            this.lXP.hideTip();
        }
    }

    private void doi() {
        if (this.lXP == null) {
            this.lXP = new e(getPageContext());
        }
        this.lXP.c(this.elb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        doh();
        TiebaPrepareImageService.StopService();
        cZN();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doj() {
        if (this.lab == null) {
            finish();
            return;
        }
        this.lab.setTitle(dox().getText().toString());
        this.lab.setContent(dow().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.laB != null && this.laB.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.laB, getPageContext().getPageActivity());
                return true;
            } else if (this.elb.bcY()) {
                this.elb.bbz();
                return true;
            } else {
                cZN();
                doj();
                return true;
            }
        }
        if (i == 67 && (text = dow().getText()) != null) {
            int selectionStart = dow().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dow().onKeyDown(67, this.gZr);
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
        getLayoutMode().onModeChanged(this.isn);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.laz, R.color.cp_link_tip_a, 1);
        dof();
        am.setBackgroundColor(this.lav, R.color.cp_bg_line_c);
        am.setBackgroundColor(dox(), R.color.cp_bg_line_d);
        am.setBackgroundColor(dow(), R.color.cp_bg_line_d);
        cZW();
        this.elb.onChangeSkinType(i);
        if (this.lXH != null) {
            this.lXH.aWq();
        }
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        dok();
        dol();
        if (this.lXO != null) {
            this.lXO.c(dox(), dow());
        }
        if (this.afK != null) {
            this.afK.onChangeSkinType();
        }
        if (this.lVS != null) {
            this.lVS.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dok() {
        if (this.lau.hasFocus()) {
            this.lau.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.lau.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
        if (this.lay.hasFocus()) {
            this.lay.setHintTextColor(am.getColor(R.color.cp_cont_e));
        } else {
            this.lay.setHintTextColor(am.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dol() {
        if (this.lau != null) {
            if (this.lau.getText().toString().length() == 0) {
                this.lau.getPaint().setFakeBoldText(false);
            } else if (this.lau.getText().toString().length() > 0) {
                this.lau.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.euw = new com.baidu.tbadk.core.view.a(getPageContext());
        this.lXJ = this.lab.getType() == 4 || 5 == this.lab.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aUV().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        doo();
        this.lXI = (ScrollView) findViewById(R.id.write_scrollview);
        this.lXI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.lay != null) {
                        l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.lay);
                    }
                    if (TransmitPostEditActivity.this.elb != null) {
                        TransmitPostEditActivity.this.elb.bbz();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.isn = (RelativeLayout) findViewById(R.id.parent);
        this.lXs = (LinearLayout) findViewById(R.id.tool_view);
        this.lXs.setContentDescription(IStringUtil.TOP_PATH);
        this.lXt = (LinearLayout) findViewById(R.id.title_view);
        this.lav = findViewById(R.id.interval_view);
        this.lXL = (TextView) findViewById(R.id.hot_topic_title_edt);
        cZV();
        if (this.lXJ) {
            this.lXI.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        cZX();
        dou();
        this.lax = (LinearLayout) findViewById(R.id.post_content_container);
        this.lax.setDrawingCacheEnabled(false);
        this.lax.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.elb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.lay.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.fPd);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.cZN();
                TransmitPostEditActivity.this.doj();
            }
        });
        dor();
        dot();
        don();
        dof();
        dos();
        cZU();
        doz();
        dom();
        if (this.lab.getType() == 4 && this.laD != null && this.lXv != null) {
            this.laD.setVisibility(8);
            this.lXv.setVisibility(8);
        }
        cZW();
        ShowSoftKeyPad(this.mInputManager, this.lau);
    }

    private void dom() {
        this.lVS = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.lVS.setData(this.lRr);
        this.lVS.setActivity(this);
    }

    private void don() {
        String str;
        String str2;
        if (this.lab != null) {
            switch (this.lab.getType()) {
                case 0:
                case 9:
                    if (this.hOj != null && this.hOj.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                        if (this.lVx) {
                            this.mName.setText(R.string.transmit_to_dynamic_title);
                        }
                    } else if (this.hOj != null && this.hOj.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.lab.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.lau.setVisibility(0);
                    this.lay.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.lay.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.lay.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.lau.setVisibility(8);
                    return;
            }
        }
    }

    private void doo() {
        if (this.lVx) {
            this.laz = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.dynamic_publish));
        } else {
            this.laz = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.laz.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.laz.setLayoutParams(layoutParams);
        this.laz.setOnFocusChangeListener(this.fPd);
    }

    private void dop() {
        if (this.lab != null && this.lab.getType() == 0 && this.lab.getType() == 9 && !this.lXr && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = aq.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dox() != null) {
                dox().setText(cutStringWithSuffix);
                dox().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void doq() {
        this.fns = null;
        this.lXE = -1;
        this.lXG = -1;
        ac ud = com.baidu.tieba.frs.ab.bWL().ud(1);
        if (ud != null) {
            this.fns = ud.hqX;
            this.lXE = getIntent().getIntExtra("category_id", -1);
            if (this.fns != null && !this.fns.isEmpty() && this.lXE >= 0) {
                this.lXD = new aa();
                this.lXD.hqT = 0;
                this.lXD.name = getPageContext().getResources().getString(R.string.category_auto);
                this.lXG = this.lXD.hqT;
                this.lXF = this.lXD.name;
                for (aa aaVar : this.fns) {
                    if (aaVar.hqT == this.lXE) {
                        this.lXG = aaVar.hqT;
                        this.lXF = aaVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dor() {
        if (this.fns != null && !this.fns.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.lXH = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.lXH.setText(this.lXF);
            this.lXH.setCategoryContainerData(this.fns, this.lXD, this.lXG);
            this.lXH.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ax axVar) {
                    if (axVar != null) {
                        TransmitPostEditActivity.this.lXH.setText(axVar.name);
                        TransmitPostEditActivity.this.lab.setCategoryTo(axVar.hqT);
                        TransmitPostEditActivity.this.lXG = axVar.hqT;
                        TransmitPostEditActivity.this.lXH.dnS();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.lXH.dnR();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dox());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dow());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.lXW = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.lXW.setTitle(R.string.no_disturb_start_time);
        this.lXW.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.lXW);
        this.lXW.setButton(-2, getPageContext().getString(R.string.cancel), this.lXW);
        return this.lXW;
    }

    private void dos() {
        this.lXz = (RelativeLayout) findViewById(R.id.addition_container);
        this.lXA = (TextView) findViewById(R.id.addition_create_time);
        this.lXB = (TextView) findViewById(R.id.addition_last_time);
        this.lXC = (TextView) findViewById(R.id.addition_last_content);
        if (this.lXy != null) {
            this.lXz.setVisibility(0);
            this.lXA.setText(getPageContext().getString(R.string.write_addition_create) + aq.getFormatTime(this.lXy.getCreateTime() * 1000));
            if (this.lXy.getAlreadyCount() == 0) {
                this.lXB.setVisibility(8);
            } else {
                this.lXB.setText(getPageContext().getString(R.string.write_addition_last) + aq.getFormatTime(this.lXy.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.lXy.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.lXC.setText(lastAdditionContent);
            } else {
                this.lXC.setVisibility(8);
            }
            dow().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.lXy.getAlreadyCount()), Integer.valueOf(this.lXy.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.lXz.setVisibility(8);
    }

    private void cZU() {
        this.laD = findViewById(R.id.post_prefix_layout);
        this.laA = (TextView) findViewById(R.id.post_prefix);
        this.lXv = findViewById(R.id.prefix_divider);
        this.laC = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.laD.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.lac = 1;
            this.laD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.laA.setVisibility(0);
                    TransmitPostEditActivity.this.laD.setSelected(true);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.laB, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.elb.bbz();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.lau);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.lay);
                }
            });
            this.laC = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.laC.setVisibility(0);
                this.laA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.laA.setSelected(true);
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.laB, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.elb.bbz();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dox());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dow());
                    }
                });
            }
            this.laB = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.laB.a(this);
            this.laB.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.laB.setOutsideTouchable(true);
            this.laB.setFocusable(true);
            this.laB.setOnDismissListener(this);
            this.laB.setBackgroundDrawable(am.getDrawable(R.color.cp_bg_line_d));
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_cont_c);
            am.setBackgroundResource(this.laA, R.color.cp_bg_line_d);
            am.setImageResource(this.laC, R.drawable.icon_frs_arrow_n);
            this.laA.setTextColor(color);
            this.lXw.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.lXw.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.laB.addView(writePrefixItemLayout);
            }
            this.laB.setCurrentIndex(0);
            this.laA.setText(prefixs.get(1));
            FN(1);
            return;
        }
        this.laD.setVisibility(8);
    }

    protected void dot() {
        this.laz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick() && !TransmitPostEditActivity.this.doG()) {
                    if (TransmitPostEditActivity.this.lXO.a(TransmitPostEditActivity.this.lau, TransmitPostEditActivity.this.lay)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.lXO.dmk());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dox());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dow());
                    TransmitPostEditActivity.this.elb.bbz();
                    TiebaStatic.log(new an("c12608").ag("obj_locate", 7));
                    TransmitPostEditActivity.this.doD();
                }
            }
        });
    }

    protected void cZV() {
        this.lau = (EditText) findViewById(R.id.post_title);
        this.lau.setOnClickListener(this.lXS);
        this.lau.setOnFocusChangeListener(this.fPd);
        if ((this.lab.getType() == 0 || this.lab.getType() == 9 || this.lab.getType() == 7) && this.lab.getTitle() != null) {
            this.lau.setText(this.lab.getTitle());
            this.lau.setSelection(this.lab.getTitle().length());
        }
        this.lau.addTextChangedListener(this.lXU);
        if (!this.lab.getHaveDraft()) {
            dop();
        }
        this.lau.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void cZX() {
        this.lay = (EditText) findViewById(R.id.post_content);
        this.lay.setDrawingCacheEnabled(false);
        this.lay.setOnClickListener(this.lXS);
        if (this.lab.getContent() != null && this.lab.getContent().length() > 0) {
            SpannableString ak = TbFaceManager.bes().ak(getPageContext().getPageActivity(), this.lab.getContent());
            this.lay.setText(ak);
            this.lay.setSelection(ak.length());
        }
        if (!aq.isEmpty(this.hlk)) {
            this.lay.setSelection(0);
        }
        this.lay.setOnFocusChangeListener(this.fPd);
        this.lay.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.elb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.lay.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.lay.addTextChangedListener(this.lXV);
        if (this.lVx) {
            this.lay.setHint(R.string.dynamic_transmit_publish_edit_str);
        } else if (this.lXq != null && this.lXq.showType == 3) {
            this.lay.setHint(R.string.share_video_default);
        } else {
            this.lay.setHint(R.string.share_txt_default);
        }
    }

    private void dou() {
        this.afK = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        this.afK.setVisibility(0);
        this.afK.a(this.lXq);
        this.afK.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dov() {
        int i = 5000;
        if (this.lXy != null) {
            i = 1000;
        }
        return dow().getText() != null && dow().getText().length() >= i;
    }

    private void ye(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.lXo)) {
                this.lXo = "";
                dow().requestFocus();
                if (dow().getText() != null && dow().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dow().getSelectionStart();
                    editable = dow().getText();
                }
            } else if ("from_title".equals(this.lXo)) {
                this.lXo = "";
                dox().requestFocus();
                if (dox().getText() != null && dox().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dox().getSelectionStart();
                    editable = dox().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vz(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.lab != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.lab.getForumId(), 0L), this.lab.getFirstDir(), this.lab.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(q qVar) {
        if (((ImageSpan[]) dow().getText().getSpans(0, dow().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.lXx == null) {
                this.lXx = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.lXx.getView().isShown()) {
                this.lXx.cancel();
            }
            this.lXx.show();
            return;
        }
        String name = qVar.getName();
        final EmotionGroupType aYc = qVar.aYc();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.e.c.kX().a(name, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.dow().getSelectionStart(), aVar, aYc);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && dow() != null && dow().getText() != null) {
            Bitmap rawBitmap = aVar.getRawBitmap();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(rawBitmap);
            int width = rawBitmap.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, rawBitmap.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = 55;
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.e(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = dow().getSelectionStart() - 1;
                if (dow().getText().length() > 1 && selectionStart >= 0 && dow().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    dow().getText().insert(dow().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            dow().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                dow().getText().insert(dow().getSelectionStart(), spannableString2);
            }
            Editable text = dow().getText();
            if (text != null) {
                this.lXM.clear();
                this.lXM.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.lXM);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && dow().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    dow().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                dow().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dow() {
        return this.lay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dox() {
        return this.lau;
    }

    protected void doy() {
        Editable text;
        if (dow() != null && (text = dow().getText()) != null) {
            int selectionStart = dow().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dow().onKeyDown(67, this.gZr);
            }
            dow().onKeyDown(67, this.gZr);
            int selectionStart2 = dow().getSelectionStart();
            this.lXM.clear();
            this.lXM.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.lXM);
            dow().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.euw.setCancelListener(null);
        this.euw.setTipString(R.string.sending);
        this.euw.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.euw.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZW() {
        if (this.lab != null) {
            String str = "";
            String str2 = "";
            if (dox() != null) {
                str = dox().getText().toString();
            }
            if (dow() != null) {
                str2 = dow().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.lab.getType() == 0 || this.lab.getType() == 9 || this.lab.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.lac == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.lab.setIsNoTitle(true);
                        } else {
                            this.lab.setIsNoTitle(false);
                            vA(true);
                            return;
                        }
                    } else {
                        this.lab.setIsNoTitle(false);
                        vA(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.lab.setIsNoTitle(true);
                } else {
                    this.lab.setIsNoTitle(false);
                    vA(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.lXJ) {
                    vA(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    vA(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                vA(true);
            } else if (this.lab.getVideoInfo() != null) {
                vA(true);
            } else {
                vA(false);
            }
        }
    }

    private void vA(boolean z) {
        am.setNavbarTitleColor(this.laz, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.emH = new NewWriteModel(this);
        this.emH.b(this.emV);
        this.heh = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.cZN();
            }
        };
        this.lab = new WriteData();
        if (bundle != null) {
            this.lab.setType(bundle.getInt("type", 0));
            this.lab.setForumId(bundle.getString("forum_id"));
            this.lab.setForumName(bundle.getString("forum_name"));
            this.lab.setFirstDir(bundle.getString("forum_first_dir"));
            this.lab.setSecondDir(bundle.getString("forum_second_dir"));
            this.lab.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.lXy = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.lab.setIsAddition(this.lXy != null);
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
            this.lab.setTitle(bundle.getString("write_title"));
            this.lab.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.hOj = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.lXq = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.ShareInfo.class);
            }
            this.mBaijiahaoData = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.hlk = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.hll = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.lRr = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.lab.mDynamicForwardData = (ForwardUploadData) bundle.getSerializable(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA);
            str = string;
        } else {
            Intent intent = getIntent();
            this.lab.setType(intent.getIntExtra("type", 0));
            this.lab.setForumId(intent.getStringExtra("forum_id"));
            this.lab.setForumName(intent.getStringExtra("forum_name"));
            this.lab.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.lab.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.lab.setThreadId(intent.getStringExtra("thread_id"));
            this.lXy = (AdditionData) intent.getSerializableExtra("addition_data");
            this.lab.setIsAddition(this.lXy != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.lab.setTitle(intent.getStringExtra("write_title"));
            this.lab.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hOj = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.lXq = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            this.lab.mDynamicForwardData = (ForwardUploadData) intent.getSerializableExtra(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA);
            this.hlk = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.hll = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.lRr = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (this.lab.mDynamicForwardData != null) {
            this.lVx = true;
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.lab.getType() == 4 ? 6 : 9);
        this.lab.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.lXq != null && this.lXq.videoId != null) {
            this.lab.setVideoId(this.lXq.videoId);
            this.lab.setOriginalVideoCover(this.lXq.showPicUrl);
            this.lab.setOriginalVideoTitle(this.lXq.showText);
        }
        if (!aq.isEmpty(this.hlk)) {
            if (!aq.isEmpty(this.hll)) {
                this.lab.setContent("//@" + this.hll + " :" + this.hlk);
            } else {
                this.lab.setContent(this.hlk);
            }
        }
        if (this.lab != null && this.lab.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.lab.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.lXr = true;
        }
        doq();
    }

    private void doz() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.lau.setText(com.baidu.tbadk.plugins.b.yI(com.baidu.tbadk.plugins.b.yJ(hotTopicBussinessData.mTopicName)));
            this.lau.setMovementMethod(com.baidu.tieba.view.c.dlQ());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString yI = com.baidu.tbadk.plugins.b.yI(com.baidu.tbadk.plugins.b.yJ(hotTopicBussinessData.mTopicName));
            if (yI != null) {
                this.lau.setText(yI);
            }
            this.lXL.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.lab.getType());
        bundle.putString("forum_id", this.lab.getForumId());
        bundle.putString("forum_name", this.lab.getForumName());
        bundle.putString("forum_first_dir", this.lab.getFirstDir());
        bundle.putString("forum_second_dir", this.lab.getSecondDir());
        bundle.putString("thread_id", this.lab.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.hOj);
        bundle.putSerializable("tab_list", this.lRr);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.lXy != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.lXy));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.hOj);
        if (this.lab.mDynamicForwardData != null) {
            bundle.putSerializable(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA, this.lab.mDynamicForwardData);
        }
        if (this.lXq != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.lXq));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dow().getEditableText().toString();
        if (obj != null) {
            dow().setText(TbFaceManager.bes().a(getPageContext().getPageActivity(), obj, this.lXQ));
            dow().setSelection(dow().getText().length());
        }
    }

    private String doA() {
        if (dow() == null || dow().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(dow().getText().toString())) {
            if (this.lXq != null && this.lXq.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return dow().getText().toString();
    }

    private String doB() {
        if (this.lab == null || dox() == null || dox().getVisibility() != 0 || dox().getText() == null) {
            return "";
        }
        String obj = dox().getText().toString();
        if (this.mPrefixData != null && v.getCount(this.mPrefixData.getPrefixs()) > 0 && this.lac != 0 && this.lab.getType() != 4 && this.laA != null && this.laA.getText() != null) {
            obj = this.laA.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.lab.getTitle();
        }
        return obj;
    }

    private void doC() {
        if (this.lab != null && this.lab.mDynamicForwardData != null) {
            dny();
            return;
        }
        cZN();
        this.lab.setContent(doA());
        this.lab.setTitle(doB());
        if (this.lXE >= 0) {
            this.lab.setCategoryFrom(this.lXE);
        }
        if (this.lXG >= 0) {
            this.lab.setCategoryTo(this.lXG);
        }
        this.lab.setWriteImagesInfo(this.writeImagesInfo);
        this.lab.setHasLocationData(this.emG != null && this.emG.bHm());
        this.emH.uy(this.writeImagesInfo.size() > 0);
        if (!v.isEmpty(this.mList) && this.lXK != null && this.lXK.mIsGlobalBlock == 0) {
            this.lab.setForumId(String.valueOf(this.lXK.mForumId));
            this.lab.setForumName(this.lXK.mForumName);
        }
        dnz();
        this.emH.d(this.lab);
        this.lab.setContent(this.lab.getContent().replaceAll("\u0000\n", ""));
        this.lab.setContent(this.lab.getContent().replaceAll("\u0000", ""));
        this.lab.setVcode(null);
        this.emH.cZP().setVoice(null);
        this.emH.cZP().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.heh);
        this.emH.deN();
    }

    private void dnz() {
        FrsTabItemData selectedTabItemData;
        if (this.lab != null && this.lVS != null && (selectedTabItemData = this.lVS.getSelectedTabItemData()) != null) {
            this.lab.setTabId(selectedTabItemData.tabId);
            this.lab.setTabName(selectedTabItemData.name);
            this.lab.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    private void dny() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        this.lab.mDynamicForwardData.forward_content = doA();
        this.lab.mDynamicForwardData.inputText = doA();
        this.lab.mDynamicForwardData.locationPoiId = "0";
        showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
        com.baidu.tieba.write.b.c.b.dnj().a(this.lab.mDynamicForwardData, new b.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
            @Override // com.baidu.tieba.write.b.c.b.a
            public void onSuccess(String str) {
                TransmitPostEditActivity.this.closeLoadingDialog();
                com.baidu.tieba.tbadkCore.writeModel.c.f(TransmitPostEditActivity.this.getPageContext().getPageActivity(), null, null, null);
                TransmitPostEditActivity.this.ie(true);
                Intent intent = new Intent();
                intent.putExtras(new Bundle());
                TransmitPostEditActivity.this.setResult(-1, intent);
                TransmitPostEditActivity.this.finish();
            }

            @Override // com.baidu.tieba.write.b.c.b.a
            public void onFail(String str) {
                TransmitPostEditActivity.this.closeLoadingDialog();
                if (TextUtils.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error);
                }
                l.showToast(TbadkCoreApplication.getInst(), str);
            }
        });
    }

    private void C(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.lXy != null) {
                i2 = this.lXy.getTotalCount();
                i = this.lXy.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(R.string.write_addition_left_count), Integer.valueOf(i2 - i)));
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
                if (this.elb != null && !this.elb.bcY()) {
                    dow().requestFocus();
                    this.mInputManager.toggleSoftInput(0, 2);
                }
                ArrayList<String> stringArrayListExtra = intent != null ? intent.getStringArrayListExtra("name_show") : null;
                if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < stringArrayListExtra.size()) {
                            sb.append(UgcConstant.AT_RULE_TAG);
                            sb.append(stringArrayListExtra.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            dow().getText().insert(dow().getSelectionStart(), sb.toString());
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
                        if (this.lXp) {
                            sb2.append(com.baidu.tbadk.plugins.b.euc);
                            this.lXp = false;
                        }
                        sb2.append(stringExtra);
                        ye(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !v.isEmpty(this.mList) && !v.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.lXK = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.lXK);
            }
        } else if (i2 == 0) {
            if (this.elb != null && !this.elb.bcY()) {
                this.lay.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.lXO.Of(postWriteCallBackData.getErrorString());
                        this.lXO.aX(postWriteCallBackData.getSensitiveWords());
                        this.lXO.b(this.lau, this.lay);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.lXo)) {
                        dox().requestFocus();
                        return;
                    } else if ("from_content".equals(this.lXo)) {
                        dow().requestFocus();
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
    public void doD() {
        if ("1".equals(this.hOj)) {
            this.lab.setCanNoForum(true);
            this.lab.setTransmitForumData("[]");
        } else if ("2".equals(this.hOj)) {
            this.lab.setCanNoForum(false);
        }
        doE();
        this.lab.setPrivacy(this.isPrivacy);
        this.lab.setIsShareThread(true);
        if (this.lXq != null && !StringUtils.isNull(this.lXq.threadId)) {
            this.lab.setOriginalThreadId(this.lXq.threadId);
        }
        this.lab.setBaijiahaoData(this.mBaijiahaoData);
        if (this.lXq != null) {
            this.lab.setOriBaijiahaoData(this.lXq.oriUgcInfo);
        }
        this.lab.setCallFrom(this.hOj);
        doC();
    }

    private void doE() {
        if (this.elb != null) {
            this.elb.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dox());
        HidenSoftKeyPad(this.mInputManager, dow());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bv(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.hoq) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", at.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.lab.getType() != 7) {
                if (this.lXy == null) {
                    if (!d(postWriteCallBackData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        return;
                    }
                    return;
                }
                C(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.emM = i;
        if (this.elb != null) {
            this.elb.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void doF() {
        if (!this.lXJ && this.elb != null) {
            this.elb.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.elb.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ie(boolean z) {
        if (this.elb != null) {
            this.elb.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void FN(int i) {
        if (i < this.lXw.size()) {
            for (int i2 = 0; i2 < this.lXw.size(); i2++) {
                this.lXw.get(i2).vp(false);
            }
            this.lXw.get(i).vp(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void Dv(int i) {
        this.lac = i;
        this.laB.setCurrentIndex(i);
        FN(i);
        this.laA.setText(this.mPrefixData.getPrefixs().get(i));
        cZW();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.laB, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.laD.setSelected(false);
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
            l.hideSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.lab != null) {
            if (this.lab.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.lab.getType() == 5) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_UPDATE;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            bdy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.aUD = z;
        if (this.lXN != null && !z) {
            this.lXN.bPf();
        }
        if (this.lXP != null && !z) {
            doh();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.aUD && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.lXp = false;
            this.lXo = "";
            if ("from_content".equals(str)) {
                this.lXo = "from_content";
            } else if ("from_title".equals(str)) {
                this.lXo = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.yH(String.valueOf(charSequence.charAt(i)))) {
                vz(false);
            }
        }
    }

    public void cUW() {
        if (!v.isEmpty(this.mList)) {
            this.lXt.setVisibility(0);
            this.lXt.requestFocus();
            return;
        }
        this.lXt.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doG() {
        if (((ImageSpan[]) dow().getText().getSpans(0, dow().getText().length(), ImageSpan.class)).length > 10) {
            if (this.lXx == null) {
                this.lXx = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.lXx.getView().isShown()) {
                this.lXx.cancel();
            }
            this.lXx.show();
            return true;
        }
        return false;
    }
}
