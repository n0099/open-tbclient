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
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0036a, e.a {
    private com.baidu.tbadk.editortools.i bqg;
    private LocationModel brJ;
    private NewWriteModel brK;
    private OriginalThreadCardView fuU;
    private int gNF;
    private TextView gNZ;
    private com.baidu.tieba.write.e gOa;
    private ImageView gOb;
    private View gOc;
    private com.baidu.tieba.write.b hGn;
    private LinearLayout hIG;
    private LinearLayout hIH;
    private View hIJ;
    private Toast hIK;
    private AdditionData hIL;
    private RelativeLayout hIM;
    private TextView hIN;
    private TextView hIO;
    private TextView hIP;
    List<z> hIQ;
    z hIR;
    private int hIS;
    private String hIT;
    private int hIU;
    private PostCategoryView hIV;
    private HotTopicBussinessData hIY;
    private View hIZ;
    private View hJa;
    private TextView hJb;
    private TextView hJc;
    private com.baidu.tieba.write.editor.d hJg;
    private com.baidu.tieba.write.b hJh;
    private com.baidu.tieba.view.d hJn;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String hID = "";
    private boolean hIE = false;
    private WriteData mData = null;
    private boolean hIF = false;
    private InputMethodManager mInputManager = null;
    private EditText gNW = null;
    private View gNX = null;
    private LinearLayout cwp = null;
    private EditText cwo = null;
    private FeedBackModel hII = null;
    private ArrayList<com.baidu.tieba.write.d> hHz = new ArrayList<>();
    private final KeyEvent don = new KeyEvent(0, 67);
    private View beJ = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String brO = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int brP = 0;
    private View mRootView = null;
    private ScrollView hIW = null;
    private boolean hIX = false;
    private com.baidu.tbadk.core.view.b bAA = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String hnU = "2";
    private String hJd = "";
    private int hJe = 0;
    private SpannableStringBuilder hJf = new SpannableStringBuilder();
    private TbFaceManager.a hJi = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan gu(String str) {
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
            return new com.baidu.tbadk.core.view.i(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a dCc = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").s("obj_locate", ap.a.aVV));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").s("obj_locate", ap.a.aVV));
        }
    };
    private final NewWriteModel.d brY = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.hGn.av(null);
                TransmitPostEditActivity.this.hGn.nq(false);
                TransmitPostEditActivity.this.hJh.av(null);
                TransmitPostEditActivity.this.hJh.nq(false);
                if (z) {
                    TransmitPostEditActivity.this.ci(z);
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
                    TransmitPostEditActivity.this.hGn.av(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.hJh.av(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.hGn.tZ(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.hJh.tZ(postWriteCallBackData.getErrorString());
                    if (!v.E(TransmitPostEditActivity.this.hGn.bEM())) {
                        TransmitPostEditActivity.this.nz(true);
                        TransmitPostEditActivity.this.nF(true);
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
                    writeData.setVcodeExtra(tVar.FA());
                    if (com.baidu.tbadk.p.a.hg(tVar.Fz())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.Fz())));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a brW = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void Lj() {
            TransmitPostEditActivity.this.showToast(d.j.no_network_guide);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void gi(String str) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            if (StringUtils.isNull(str)) {
                str = TransmitPostEditActivity.this.getPageContext().getString(d.j.location_fail);
            }
            transmitPostEditActivity.showToast(str);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bwl())) {
                TransmitPostEditActivity.this.b(2, true, aVar.bwl());
            } else {
                gi(null);
            }
        }
    };
    private final CustomMessageListener hav = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.brJ.mC(false);
                    TransmitPostEditActivity.this.brJ.cf(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.brJ.mC(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hJj = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hJk = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.bqg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bHu = TransmitPostEditActivity.this.bHu();
            if (bHu >= 0 && bHu < TransmitPostEditActivity.this.cwo.getText().length()) {
                TransmitPostEditActivity.this.cwo.setSelection(bHu);
            }
        }
    };
    private boolean hJl = true;
    private final View.OnFocusChangeListener cwv = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.gNW || view == TransmitPostEditActivity.this.beJ || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.hJl = true;
                    TransmitPostEditActivity.this.bHv();
                    if (TransmitPostEditActivity.this.bqg != null) {
                        TransmitPostEditActivity.this.bqg.IE();
                    }
                    l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gNW);
                } else if (view == TransmitPostEditActivity.this.gNW) {
                    TransmitPostEditActivity.this.gNZ.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.cwo && z) {
                TransmitPostEditActivity.this.hJl = false;
                TransmitPostEditActivity.this.bHv();
                TransmitPostEditActivity.this.bqg.IE();
                l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.cwo);
            }
            TransmitPostEditActivity.this.bHy();
        }
    };
    private TextWatcher cwx = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bru();
            if (TransmitPostEditActivity.this.hJh != null) {
                if (!TransmitPostEditActivity.this.hJh.bEP()) {
                    TransmitPostEditActivity.this.nF(false);
                }
                TransmitPostEditActivity.this.hJh.nr(false);
                TransmitPostEditActivity.this.bHz();
            }
        }
    };
    private TextWatcher hJm = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bru();
            if (TransmitPostEditActivity.this.hGn != null) {
                if (!TransmitPostEditActivity.this.hGn.bEP()) {
                    TransmitPostEditActivity.this.nz(false);
                }
                TransmitPostEditActivity.this.hGn.nr(false);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nF(boolean z) {
        if (bHK() != null && bHK().getVisibility() == 0 && bHK().getText() != null) {
            int selectionEnd = bHK().getSelectionEnd();
            SpannableStringBuilder b = this.hJh.b(bHK().getText());
            if (b != null) {
                this.hJh.nr(true);
                bHK().setText(b);
                if (z && this.hJh.bEN() >= 0) {
                    bHK().requestFocus();
                    bHK().setSelection(this.hJh.bEN());
                } else {
                    bHK().setSelection(selectionEnd);
                }
                this.hJh.nq(this.hJh.bEN() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nz(boolean z) {
        if (bHJ() != null && bHJ().getText() != null) {
            int selectionEnd = bHJ().getSelectionEnd();
            SpannableStringBuilder b = this.hGn.b(bHJ().getText());
            if (b != null) {
                this.hGn.nr(true);
                bHJ().setText(b);
                if (z && this.hGn.bEN() >= 0) {
                    bHJ().requestFocus();
                    bHJ().setSelection(this.hGn.bEN());
                } else {
                    bHJ().setSelection(selectionEnd);
                }
                this.hGn.nq(this.hGn.bEN() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KU() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void KV() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            KW();
        } else if (this.brJ.bwt()) {
            KU();
        } else {
            this.brJ.mC(false);
            b(1, true, null);
            this.brJ.bwr();
        }
    }

    private void KW() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.fb(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.oI()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.brJ.agj();
                } else {
                    TransmitPostEditActivity.this.brW.Lj();
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
        aVar.AA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bHu() {
        int selectionEnd = bHJ().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bHJ().getText().getSpans(0, bHJ().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bHJ().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bHJ().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHv() {
        if (this.bqg != null) {
            this.bqg.setBarLauncherEnabled(!this.hJl);
            this.bqg.g(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hIX) {
            this.gNW.setVisibility(8);
            bru();
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
        this.hJh = new com.baidu.tieba.write.b();
        this.hJh.xg(d.C0107d.cp_cont_i);
        this.hJh.xh(d.C0107d.cp_cont_h_alpha85);
        this.hGn = new com.baidu.tieba.write.b();
        this.hGn.xg(d.C0107d.cp_cont_i);
        this.hGn.xh(d.C0107d.cp_cont_h_alpha85);
        initUI();
        this.brJ = new LocationModel(this);
        this.brJ.a(this.brW);
        registerListener(this.hav);
        registerListener(this.hJj);
        initEditor();
        this.cwo.requestFocus();
        IG();
        bHR();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.bqg = new com.baidu.tbadk.editortools.i(getActivity());
        this.bqg.setBarMaxLauCount(4);
        this.bqg.setMoreButtonAtEnd(true);
        this.bqg.setBarLauncherType(1);
        this.bqg.ca(true);
        this.bqg.cb(true);
        this.bqg.setMoreLauncherIcon(d.f.write_more);
        this.bqg.setBackgroundColorId(d.C0107d.cp_bg_line_d);
        bHw();
        this.bqg.Kv();
        if (this.hIG != null) {
            this.hIG.addView(this.bqg);
        }
        bHx();
        this.bqg.th();
        com.baidu.tbadk.editortools.l hH = this.bqg.hH(6);
        if (hH != null && !TextUtils.isEmpty(this.brO)) {
            ((View) hH).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.brO);
                }
            });
        }
        if (!this.hIX) {
            this.bqg.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.bqg.IE();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.bqg.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.bqg.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void bHw() {
        r rVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 2);
        aVar.bqN = d.f.write_at;
        this.bqg.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.bqg.b(aVar2);
        aVar2.bqN = d.f.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), r.class);
        if (runTask != null && (rVar = (r) runTask.getData()) != null) {
            rVar.bqP = 4;
            rVar.bqN = d.f.icon_post_location_selector;
            this.bqg.b(rVar);
        }
        if (this.hIL == null) {
            if (this.hJg == null) {
                this.hJg = new com.baidu.tieba.write.editor.d(getActivity(), this.hnU);
                this.hJg.bFV();
                this.hJg.setFrom("from_share_write");
                this.hJg.aN(this.mData.getForumId(), this.mPrivateThread);
            }
            this.bqg.b(this.hJg);
        }
        this.bqg.I(arrayList);
        r hJ = this.bqg.hJ(5);
        if (hJ != null) {
            hJ.bqP = 1;
            hJ.bqN = d.f.write_emotion;
        }
    }

    private void bHx() {
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
                        if (TransmitPostEditActivity.this.bHI()) {
                            TransmitPostEditActivity.this.showToast(d.j.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.bHI()) {
                            TransmitPostEditActivity.this.showToast(d.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            TransmitPostEditActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.bHL();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.bru();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.hIL == null) {
                            TransmitPostEditActivity.this.KX();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.brP) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.aT(pageActivity)) {
                                    TransmitPostEditActivity.this.KV();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.KU();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.brJ != null) {
                            TransmitPostEditActivity.this.brJ.mC(true);
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
                            TransmitPostEditActivity.this.bqg.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.bqg.Kx()) {
                                        TransmitPostEditActivity.this.bqg.IE();
                                        TransmitPostEditActivity.this.bqg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.bqg.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.bqg.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.bqg.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.bqg.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.bru();
                        if (TransmitPostEditActivity.this.cwo != null) {
                            TransmitPostEditActivity.this.cwo.requestFocus();
                        }
                        TransmitPostEditActivity.this.bqg.IE();
                        TransmitPostEditActivity.this.bqg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cwo);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.bqg.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.hIE = true;
                        TransmitPostEditActivity.this.nG(true);
                        if (TransmitPostEditActivity.this.bHK().isFocused()) {
                            TransmitPostEditActivity.this.hID = "from_title";
                        } else if (TransmitPostEditActivity.this.bHJ().isFocused()) {
                            TransmitPostEditActivity.this.hID = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.hIH.setVisibility(0);
                        TransmitPostEditActivity.this.hIH.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.hIH.hasFocus()) {
                            TransmitPostEditActivity.this.cwo.requestFocus();
                            TransmitPostEditActivity.this.cwo.setSelection(TransmitPostEditActivity.this.cwo.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.hIH.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.bqg.a(31, bVar);
        this.bqg.a(16, bVar);
        this.bqg.a(14, bVar);
        this.bqg.a(24, bVar);
        this.bqg.a(3, bVar);
        this.bqg.a(10, bVar);
        this.bqg.a(11, bVar);
        this.bqg.a(12, bVar);
        this.bqg.a(13, bVar);
        this.bqg.a(15, bVar);
        this.bqg.a(18, bVar);
        this.bqg.a(20, bVar);
        this.bqg.a(25, bVar);
        this.bqg.a(27, bVar);
        this.bqg.a(29, bVar);
        this.bqg.a(43, bVar);
        this.bqg.a(45, bVar);
        this.bqg.a(53, bVar);
        this.bqg.a(48, bVar);
        this.bqg.a(46, bVar);
        this.bqg.a(49, bVar);
        this.bqg.a(47, bVar);
        this.bqg.a(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KX() {
        if (this.brJ.agf()) {
            if (this.brJ.bwt()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bwp().getLocationData().bwl());
                return;
            }
            b(1, true, null);
            this.brJ.bwr();
            return;
        }
        b(0, true, null);
    }

    protected void brm() {
        if (this.brK != null) {
            this.brK.cancelLoadData();
        }
        if (this.hII != null) {
            this.hII.cancelLoadData();
        }
        if (this.brJ != null) {
            this.brJ.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        brm();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGP() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(bHK().getText().toString());
        this.mData.setContent(bHJ().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.gOa != null && this.gOa.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gOa, getPageContext().getPageActivity());
                return true;
            } else if (this.bqg.Kx()) {
                this.bqg.IE();
                return true;
            } else {
                brm();
                bGP();
                return true;
            }
        }
        if (i == 67 && (text = bHJ().getText()) != null) {
            int selectionStart = bHJ().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bHJ().onKeyDown(67, this.don);
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
        aj.e(this.mPost, d.C0107d.cp_link_tip_a, 1);
        bHv();
        aj.t(this.gNX, d.C0107d.cp_bg_line_c);
        aj.t(bHK(), d.C0107d.cp_bg_line_d);
        aj.t(bHJ(), d.C0107d.cp_bg_line_d);
        bru();
        this.bqg.onChangeSkinType(i);
        if (this.hIV != null) {
            this.hIV.DR();
        }
        aj.r(this.mName, d.C0107d.cp_cont_b);
        bHy();
        bHz();
        if (this.hGn != null) {
            this.hGn.onChangeSkinType();
        }
        if (this.hJh != null) {
            this.hJh.onChangeSkinType();
        }
        this.fuU.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHy() {
        if (this.gNW.hasFocus()) {
            this.gNW.setHintTextColor(aj.getColor(d.C0107d.cp_cont_e));
        } else {
            this.gNW.setHintTextColor(aj.getColor(d.C0107d.cp_cont_d));
        }
        if (this.cwo.hasFocus()) {
            this.cwo.setHintTextColor(aj.getColor(d.C0107d.cp_cont_e));
        } else {
            this.cwo.setHintTextColor(aj.getColor(d.C0107d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHz() {
        if (this.gNW != null) {
            if (this.gNW.getText().toString().length() == 0) {
                this.gNW.getPaint().setFakeBoldText(false);
            } else if (this.gNW.getText().toString().length() > 0) {
                this.gNW.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.bAA = new com.baidu.tbadk.core.view.b(getPageContext());
        this.hIX = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.beJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        aj.r(this.mName, d.C0107d.cp_cont_b);
        bHB();
        this.hIW = (ScrollView) findViewById(d.g.write_scrollview);
        this.hIW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.cwo != null) {
                        l.a(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.cwo);
                    }
                    if (TransmitPostEditActivity.this.bqg != null) {
                        TransmitPostEditActivity.this.bqg.IE();
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
        this.hIG = (LinearLayout) findViewById(d.g.tool_view);
        this.hIG.setContentDescription("..");
        this.hIH = (LinearLayout) findViewById(d.g.title_view);
        this.gNX = findViewById(d.g.interval_view);
        this.hIZ = findViewById(d.g.hot_topic_fourm_view);
        this.hJa = findViewById(d.g.hot_topic_divider);
        this.hJb = (TextView) findViewById(d.g.hot_topic_title_edt);
        this.hJc = (TextView) findViewById(d.g.change_one_tv);
        brt();
        if (this.hIX) {
            this.hIW.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        afd();
        bHH();
        this.cwp = (LinearLayout) findViewById(d.g.post_content_container);
        this.cwp.setDrawingCacheEnabled(false);
        this.cwp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.cwo.requestFocus();
                TransmitPostEditActivity.this.bqg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            }
        });
        this.beJ.setOnFocusChangeListener(this.cwv);
        this.beJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.brm();
                TransmitPostEditActivity.this.bGP();
            }
        });
        bHE();
        bHG();
        bHA();
        bHv();
        bHF();
        brs();
        bHM();
        if (this.mData.getType() == 4 && this.gOc != null && this.hIJ != null) {
            this.gOc.setVisibility(8);
            this.hIJ.setVisibility(8);
        }
        bru();
        ShowSoftKeyPad(this.mInputManager, this.gNW);
    }

    private void bHA() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hnU != null && this.hnU.equals("1")) {
                        this.mName.setText(d.j.share_to_home_page);
                    } else if (this.hnU != null && this.hnU.equals("2")) {
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
                    this.gNW.setVisibility(0);
                    this.cwo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(d.j.publish_photo_live);
                    this.cwo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(d.j.send_reply);
                    this.cwo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gNW.setVisibility(8);
                    return;
            }
        }
    }

    private void bHB() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.s(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.cwv);
    }

    private void bHC() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hIF && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = am.d(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(d) && bHK() != null) {
                bHK().setText(d);
                bHK().setSelection(d.length());
            }
        }
    }

    private void bHD() {
        this.hIQ = null;
        this.hIS = -1;
        this.hIU = -1;
        com.baidu.tieba.frs.ab mZ = aa.avi().mZ(1);
        if (mZ != null) {
            this.hIQ = mZ.dDT;
            this.hIS = getIntent().getIntExtra("category_id", -1);
            if (this.hIQ != null && !this.hIQ.isEmpty() && this.hIS >= 0) {
                this.hIR = new z();
                this.hIR.dDP = 0;
                this.hIR.name = getPageContext().getResources().getString(d.j.category_auto);
                this.hIU = this.hIR.dDP;
                this.hIT = this.hIR.name;
                for (z zVar : this.hIQ) {
                    if (zVar.dDP == this.hIS) {
                        this.hIU = zVar.dDP;
                        this.hIT = zVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bHE() {
        if (this.hIQ != null && !this.hIQ.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.hIV = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.hIV.setText(this.hIT);
            this.hIV.b(this.hIQ, this.hIR, this.hIU);
            this.hIV.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, av avVar) {
                    if (avVar != null) {
                        TransmitPostEditActivity.this.hIV.setText(avVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(avVar.dDP);
                        TransmitPostEditActivity.this.hIU = avVar.dDP;
                        TransmitPostEditActivity.this.hIV.bGH();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.hIV.bGG();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHK());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHJ());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hJn = new com.baidu.tieba.view.d(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hJn.setTitle(d.j.no_disturb_start_time);
        this.hJn.setButton(-1, getPageContext().getString(d.j.alert_yes_button), this.hJn);
        this.hJn.setButton(-2, getPageContext().getString(d.j.cancel), this.hJn);
        return this.hJn;
    }

    private void bHF() {
        this.hIM = (RelativeLayout) findViewById(d.g.addition_container);
        this.hIN = (TextView) findViewById(d.g.addition_create_time);
        this.hIO = (TextView) findViewById(d.g.addition_last_time);
        this.hIP = (TextView) findViewById(d.g.addition_last_content);
        if (this.hIL != null) {
            this.hIM.setVisibility(0);
            this.hIN.setText(getPageContext().getString(d.j.write_addition_create) + am.z(this.hIL.getCreateTime() * 1000));
            if (this.hIL.getAlreadyCount() == 0) {
                this.hIO.setVisibility(8);
            } else {
                this.hIO.setText(getPageContext().getString(d.j.write_addition_last) + am.z(this.hIL.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hIL.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hIP.setText(lastAdditionContent);
            } else {
                this.hIP.setVisibility(8);
            }
            bHJ().setHint(String.format(getPageContext().getString(d.j.write_addition_hint), Integer.valueOf(this.hIL.getAlreadyCount()), Integer.valueOf(this.hIL.getTotalCount())));
            this.mName.setText(d.j.write_addition_title);
            return;
        }
        this.hIM.setVisibility(8);
    }

    private void brs() {
        this.gOc = findViewById(d.g.post_prefix_layout);
        this.gNZ = (TextView) findViewById(d.g.post_prefix);
        this.hIJ = findViewById(d.g.prefix_divider);
        this.gOb = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gOc.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gNF = 1;
            this.gOc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.gNZ.setVisibility(0);
                    TransmitPostEditActivity.this.gOc.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gOa, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.bqg.IE();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gNW);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cwo);
                }
            });
            this.gOb = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gOb.setVisibility(0);
                this.gNZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.gNZ.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gOa, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.bqg.IE();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHK());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHJ());
                    }
                });
            }
            this.gOa = new com.baidu.tieba.write.e(getPageContext().getPageActivity());
            this.gOa.a(this);
            this.gOa.setMaxHeight(l.s(getActivity(), d.e.ds510));
            this.gOa.setOutsideTouchable(true);
            this.gOa.setFocusable(true);
            this.gOa.setOnDismissListener(this);
            this.gOa.setBackgroundDrawable(aj.getDrawable(d.C0107d.cp_bg_line_d));
            int color = aj.getColor(d.C0107d.cp_cont_b);
            int color2 = aj.getColor(d.C0107d.cp_cont_c);
            aj.s(this.gNZ, d.C0107d.cp_bg_line_d);
            aj.c(this.gOb, d.f.icon_frs_arrow_n);
            this.gNZ.setTextColor(color);
            this.hHz.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.d dVar = new com.baidu.tieba.write.d(getActivity());
                this.hHz.add(dVar);
                dVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    dVar.setPrefixTextColor(color2);
                } else {
                    dVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    dVar.setDividerStyle(false);
                }
                this.gOa.addView(dVar);
            }
            this.gOa.setCurrentIndex(0);
            this.gNZ.setText(prefixs.get(1));
            xI(1);
            return;
        }
        this.gOc.setVisibility(8);
    }

    protected void bHG() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.oI()) {
                    TransmitPostEditActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.hJh.bEO()) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.hJh.bEQ());
                        TransmitPostEditActivity.this.nF(true);
                    } else if (TransmitPostEditActivity.this.hGn.bEO()) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.hGn.bEQ());
                        TransmitPostEditActivity.this.nz(true);
                    } else {
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHK());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHJ());
                        TransmitPostEditActivity.this.bqg.IE();
                        TiebaStatic.log(new ak("c12608").s("obj_locate", 7));
                        TransmitPostEditActivity.this.bHP();
                    }
                }
            }
        });
    }

    protected void brt() {
        this.gNW = (EditText) findViewById(d.g.post_title);
        this.gNW.setOnClickListener(this.hJk);
        this.gNW.setOnFocusChangeListener(this.cwv);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.gNW.setText(this.mData.getTitle());
            this.gNW.setSelection(this.mData.getTitle().length());
        }
        this.gNW.addTextChangedListener(this.cwx);
        if (!this.mData.getHaveDraft()) {
            bHC();
        }
        this.gNW.setHint(getResources().getString(d.j.post_title_hint));
    }

    protected void afd() {
        this.cwo = (EditText) findViewById(d.g.post_content);
        this.cwo.setDrawingCacheEnabled(false);
        this.cwo.setOnClickListener(this.hJk);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString V = TbFaceManager.LO().V(getPageContext().getPageActivity(), this.mData.getContent());
            this.cwo.setText(V);
            this.cwo.setSelection(V.length());
        }
        this.cwo.setOnFocusChangeListener(this.cwv);
        this.cwo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.bqg.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.cwo.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.cwo.addTextChangedListener(this.hJm);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.cwo.setHint(d.j.share_video_default);
        } else {
            this.cwo.setHint(d.j.share_txt_default);
        }
    }

    private void bHH() {
        this.fuU = (OriginalThreadCardView) findViewById(d.g.write_original_thread_cardview);
        this.fuU.setVisibility(0);
        this.fuU.b(this.mOriginalThreadInfo);
        this.fuU.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bHI() {
        int i = 5000;
        if (this.hIL != null) {
            i = 1000;
        }
        return bHJ().getText() != null && bHJ().getText().length() >= i;
    }

    private void fZ(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hID)) {
                this.hID = "";
                bHJ().requestFocus();
                if (bHJ().getText() != null && bHJ().getText().length() + str.length() > 5000) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bHJ().getSelectionStart();
                    editable = bHJ().getText();
                }
            } else if ("from_title".equals(this.hID)) {
                this.hID = "";
                bHK().requestFocus();
                if (bHK().getText() != null && bHK().getText().length() + str.length() > 31) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bHK().getSelectionStart();
                    editable = bHK().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nG(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    protected void d(n nVar) {
        if (((ImageSpan[]) bHJ().getText().getSpans(0, bHJ().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hIK == null) {
                this.hIK = Toast.makeText(getPageContext().getPageActivity(), d.j.too_many_face, 0);
            }
            this.hIK.show();
            return;
        }
        String name = nVar.getName();
        final EmotionGroupType Fr = nVar.Fr();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.nl().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.bHJ().getSelectionStart(), aVar, Fr);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bHJ() != null && bHJ().getText() != null) {
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
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.i(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bHJ().getSelectionStart() - 1;
                if (bHJ().getText().length() > 1 && selectionStart >= 0 && bHJ().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bHJ().getText().insert(bHJ().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bHJ().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bHJ().getText().insert(bHJ().getSelectionStart(), spannableString2);
            }
            Editable text = bHJ().getText();
            if (text != null) {
                this.hJf.clear();
                this.hJf.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hJf);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bHJ().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bHJ().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bHJ().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bHJ() {
        return this.cwo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bHK() {
        return this.gNW;
    }

    protected void bHL() {
        Editable text;
        if (bHJ() != null && (text = bHJ().getText()) != null) {
            int selectionStart = bHJ().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bHJ().onKeyDown(67, this.don);
            }
            bHJ().onKeyDown(67, this.don);
            int selectionStart2 = bHJ().getSelectionStart();
            this.hJf.clear();
            this.hJf.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.hJf);
            bHJ().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.bAA.c(null);
        this.bAA.fY(d.j.sending);
        this.bAA.bm(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.bAA.bm(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bru() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bHK() != null) {
                str = bHK().getText().toString();
            }
            if (bHJ() != null) {
                str2 = bHJ().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.gNF == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            ee(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        ee(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    ee(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hIX) {
                    ee(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    ee(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                ee(true);
            } else if (this.mData.getVideoInfo() != null) {
                ee(true);
            } else {
                ee(false);
            }
        }
    }

    private void ee(boolean z) {
        aj.d(this.mPost, d.C0107d.cp_link_tip_a, d.C0107d.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.brK = new NewWriteModel(this);
        this.brK.b(this.brY);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.brm();
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
                this.hIL = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hIL != null);
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
            this.hnU = bundle.getString("KEY_CALL_FROM");
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
            this.hIL = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hIL != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hnU = intent.getStringExtra("KEY_CALL_FROM");
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
            this.hIF = true;
        }
        bHD();
    }

    private void bHM() {
        if (v.D(this.mList) > 0 && this.mList.get(0) != null) {
            this.hIZ.setVisibility(0);
            this.hJa.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.gNW.setText(com.baidu.tbadk.plugins.a.gM(ux(this.mList.get(0).mTopicName)));
                this.gNW.setMovementMethod(com.baidu.tieba.view.e.bDU());
            }
            this.hJb.setText(this.mList.get(0).mForumName);
            this.gNW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!TransmitPostEditActivity.this.hJd.equals(charSequence.toString())) {
                        TransmitPostEditActivity.this.hJe = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString gM;
                    if (!TransmitPostEditActivity.this.hJd.equals(editable.toString()) && (gM = com.baidu.tbadk.plugins.a.gM(editable.toString())) != null) {
                        TransmitPostEditActivity.this.hJd = gM.toString();
                        TransmitPostEditActivity.this.gNW.setText(gM);
                        if (TransmitPostEditActivity.this.hJe <= TransmitPostEditActivity.this.gNW.getText().length()) {
                            TransmitPostEditActivity.this.gNW.setSelection(TransmitPostEditActivity.this.hJe);
                        }
                    }
                }
            });
            this.hJc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicChangeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 25005, TransmitPostEditActivity.this.mList)));
                }
            });
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString gM = com.baidu.tbadk.plugins.a.gM(ux(hotTopicBussinessData.mTopicName));
            if (gM != null) {
                this.gNW.setText(gM);
            }
            this.hJb.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String ux(String str) {
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
        if (this.hIL != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hIL));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.hnU);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bHJ().getEditableText().toString();
        if (obj != null) {
            bHJ().setText(TbFaceManager.LO().a(getPageContext().getPageActivity(), obj, this.hJi));
            bHJ().setSelection(bHJ().getText().length());
        }
    }

    private String bHN() {
        if (bHJ() == null || bHJ().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(bHJ().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(d.j.share_video_default);
            }
            return getString(d.j.share_txt_default);
        }
        return bHJ().getText().toString();
    }

    private String bHO() {
        if (this.mData == null || bHK() == null || bHK().getVisibility() != 0 || bHK().getText() == null) {
            return "";
        }
        String obj = bHK().getText().toString();
        if (this.mPrefixData != null && v.D(this.mPrefixData.getPrefixs()) > 0 && this.gNF != 0 && this.mData.getType() != 4 && this.gNZ != null && this.gNZ.getText() != null) {
            obj = this.gNZ.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void bGQ() {
        brm();
        this.mData.setContent(bHN());
        this.mData.setTitle(bHO());
        if (this.hIS >= 0) {
            this.mData.setCategoryFrom(this.hIS);
        }
        if (this.hIU >= 0) {
            this.mData.setCategoryTo(this.hIU);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.brJ != null && this.brJ.agf());
        this.brK.mE(this.writeImagesInfo.size() > 0);
        if (!v.E(this.mList) && this.hIY != null && this.hIY.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hIY.mForumId));
            this.mData.setForumName(this.hIY.mForumName);
        }
        this.brK.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.brK.getWriteData().setVoice(null);
        this.brK.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.oI()) {
            showToast(d.j.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
        this.brK.startPostWrite();
    }

    private void o(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.hIL != null) {
                i2 = this.hIL.getTotalCount();
                i = this.hIL.getAlreadyCount() + 1;
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
                if (this.bqg != null && !this.bqg.Kx()) {
                    bHJ().requestFocus();
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
                            bHJ().getText().insert(bHJ().getSelectionStart(), sb.toString());
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
                        if (this.hIE) {
                            sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                            this.hIE = false;
                        }
                        sb2.append(stringExtra);
                        fZ(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !v.E(this.mList) && !v.E(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.hIY = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.hIY);
            }
        } else if (i2 == 0) {
            if (this.bqg != null && !this.bqg.Kx()) {
                this.cwo.requestFocus();
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
                        this.hGn.av(postWriteCallBackData.getSensitiveWords());
                        this.hJh.av(postWriteCallBackData.getSensitiveWords());
                        if (!v.E(this.hGn.bEM())) {
                            nz(true);
                            nF(true);
                            return;
                        }
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.hID)) {
                        bHK().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hID)) {
                        bHJ().requestFocus();
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
    public void bHP() {
        if ("1".equals(this.hnU)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.hnU)) {
            this.mData.setCanNoForum(false);
        }
        bHQ();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.hnU);
        bGQ();
    }

    private void bHQ() {
        if (this.bqg != null) {
            this.bqg.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bHK());
        HidenSoftKeyPad(this.mInputManager, bHJ());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.vQ(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dCc) != null) {
                    TiebaStatic.log(new ak("c12534").s("obj_locate", ap.a.aVV));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.j.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hIL == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                o(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.brP = i;
        if (this.bqg != null) {
            this.bqg.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bHR() {
        if (!this.hIX && this.bqg != null) {
            this.bqg.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.bqg.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(boolean z) {
        if (this.bqg != null) {
            this.bqg.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void xI(int i) {
        if (i < this.hHz.size()) {
            for (int i2 = 0; i2 < this.hHz.size(); i2++) {
                this.hHz.get(i2).nt(false);
            }
            this.hHz.get(i).nt(true);
        }
    }

    @Override // com.baidu.tieba.write.e.a
    public void vm(int i) {
        this.gNF = i;
        this.gOa.setCurrentIndex(i);
        xI(i);
        this.gNZ.setText(this.mPrefixData.getPrefixs().get(i));
        bru();
        com.baidu.adp.lib.g.g.a(this.gOa, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gOc.setSelected(false);
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
            KV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hJg != null && !z) {
            this.hJg.bdG();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hIE = false;
            this.hID = "";
            if ("from_content".equals(str)) {
                this.hID = "from_content";
            } else if ("from_title".equals(str)) {
                this.hID = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                nG(false);
            }
        }
    }

    public void IG() {
        if (!v.E(this.mList)) {
            this.hIH.setVisibility(0);
            this.hIH.requestFocus();
            this.bqg.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hIH.setVisibility(8);
    }
}
