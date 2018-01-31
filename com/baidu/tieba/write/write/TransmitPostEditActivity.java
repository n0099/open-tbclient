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
    private com.baidu.tbadk.editortools.i bqp;
    private LocationModel brS;
    private NewWriteModel brT;
    private OriginalThreadCardView fvp;
    private int gNZ;
    private TextView gOt;
    private com.baidu.tieba.write.e gOu;
    private ImageView gOv;
    private View gOw;
    private com.baidu.tieba.write.b hGH;
    private com.baidu.tieba.write.editor.d hJA;
    private com.baidu.tieba.write.b hJB;
    private com.baidu.tieba.view.d hJH;
    private LinearLayout hJa;
    private LinearLayout hJb;
    private View hJd;
    private Toast hJe;
    private AdditionData hJf;
    private RelativeLayout hJg;
    private TextView hJh;
    private TextView hJi;
    private TextView hJj;
    List<z> hJk;
    z hJl;
    private int hJm;
    private String hJn;
    private int hJo;
    private PostCategoryView hJp;
    private HotTopicBussinessData hJs;
    private View hJt;
    private View hJu;
    private TextView hJv;
    private TextView hJw;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String hIX = "";
    private boolean hIY = false;
    private WriteData mData = null;
    private boolean hIZ = false;
    private InputMethodManager mInputManager = null;
    private EditText gOq = null;
    private View gOr = null;
    private LinearLayout cwA = null;
    private EditText cwz = null;
    private FeedBackModel hJc = null;
    private ArrayList<com.baidu.tieba.write.d> hHT = new ArrayList<>();
    private final KeyEvent doI = new KeyEvent(0, 67);
    private View beR = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String brX = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int brY = 0;
    private View mRootView = null;
    private ScrollView hJq = null;
    private boolean hJr = false;
    private com.baidu.tbadk.core.view.b bAI = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String hoo = "2";
    private String hJx = "";
    private int hJy = 0;
    private SpannableStringBuilder hJz = new SpannableStringBuilder();
    private TbFaceManager.a hJC = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan gB(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.a.a.class);
            com.baidu.adp.widget.a.a aVar = runTask != null ? (com.baidu.adp.widget.a.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.sj());
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
    private final AntiHelper.a dCx = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").s("obj_locate", ap.a.aVY));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").s("obj_locate", ap.a.aVY));
        }
    };
    private final NewWriteModel.d bsh = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.hGH.av(null);
                TransmitPostEditActivity.this.hGH.ns(false);
                TransmitPostEditActivity.this.hJB.av(null);
                TransmitPostEditActivity.this.hJB.ns(false);
                if (z) {
                    TransmitPostEditActivity.this.cj(z);
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
                    TransmitPostEditActivity.this.hGH.av(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.hJB.av(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.hGH.ug(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.hJB.ug(postWriteCallBackData.getErrorString());
                    if (!v.E(TransmitPostEditActivity.this.hGH.bEO())) {
                        TransmitPostEditActivity.this.nB(true);
                        TransmitPostEditActivity.this.nH(true);
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
                    writeData.setVcodeExtra(tVar.FC());
                    if (com.baidu.tbadk.p.a.hn(tVar.FB())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.FB())));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a bsf = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void Ll() {
            TransmitPostEditActivity.this.showToast(d.j.no_network_guide);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void gp(String str) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            if (StringUtils.isNull(str)) {
                str = TransmitPostEditActivity.this.getPageContext().getString(d.j.location_fail);
            }
            transmitPostEditActivity.showToast(str);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bwn())) {
                TransmitPostEditActivity.this.b(2, true, aVar.bwn());
            } else {
                gp(null);
            }
        }
    };
    private final CustomMessageListener haP = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.brS.mE(false);
                    TransmitPostEditActivity.this.brS.ce(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.brS.mE(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hJD = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hJE = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.bqp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bHw = TransmitPostEditActivity.this.bHw();
            if (bHw >= 0 && bHw < TransmitPostEditActivity.this.cwz.getText().length()) {
                TransmitPostEditActivity.this.cwz.setSelection(bHw);
            }
        }
    };
    private boolean hJF = true;
    private final View.OnFocusChangeListener cwG = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.gOq || view == TransmitPostEditActivity.this.beR || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.hJF = true;
                    TransmitPostEditActivity.this.bHx();
                    if (TransmitPostEditActivity.this.bqp != null) {
                        TransmitPostEditActivity.this.bqp.IG();
                    }
                    l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gOq);
                } else if (view == TransmitPostEditActivity.this.gOq) {
                    TransmitPostEditActivity.this.gOt.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.cwz && z) {
                TransmitPostEditActivity.this.hJF = false;
                TransmitPostEditActivity.this.bHx();
                TransmitPostEditActivity.this.bqp.IG();
                l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.cwz);
            }
            TransmitPostEditActivity.this.bHA();
        }
    };
    private TextWatcher cwI = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.brw();
            if (TransmitPostEditActivity.this.hJB != null) {
                if (!TransmitPostEditActivity.this.hJB.bER()) {
                    TransmitPostEditActivity.this.nH(false);
                }
                TransmitPostEditActivity.this.hJB.nt(false);
                TransmitPostEditActivity.this.bHB();
            }
        }
    };
    private TextWatcher hJG = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.brw();
            if (TransmitPostEditActivity.this.hGH != null) {
                if (!TransmitPostEditActivity.this.hGH.bER()) {
                    TransmitPostEditActivity.this.nB(false);
                }
                TransmitPostEditActivity.this.hGH.nt(false);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nH(boolean z) {
        if (bHM() != null && bHM().getVisibility() == 0 && bHM().getText() != null) {
            int selectionEnd = bHM().getSelectionEnd();
            SpannableStringBuilder b = this.hJB.b(bHM().getText());
            if (b != null) {
                this.hJB.nt(true);
                bHM().setText(b);
                if (z && this.hJB.bEP() >= 0) {
                    bHM().requestFocus();
                    bHM().setSelection(this.hJB.bEP());
                } else {
                    bHM().setSelection(selectionEnd);
                }
                this.hJB.ns(this.hJB.bEP() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nB(boolean z) {
        if (bHL() != null && bHL().getText() != null) {
            int selectionEnd = bHL().getSelectionEnd();
            SpannableStringBuilder b = this.hGH.b(bHL().getText());
            if (b != null) {
                this.hGH.nt(true);
                bHL().setText(b);
                if (z && this.hGH.bEP() >= 0) {
                    bHL().requestFocus();
                    bHL().setSelection(this.hGH.bEP());
                } else {
                    bHL().setSelection(selectionEnd);
                }
                this.hGH.ns(this.hGH.bEP() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KW() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void KX() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            KY();
        } else if (this.brS.bwv()) {
            KW();
        } else {
            this.brS.mE(false);
            b(1, true, null);
            this.brS.bwt();
        }
    }

    private void KY() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.fb(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.oJ()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.brS.agm();
                } else {
                    TransmitPostEditActivity.this.bsf.Ll();
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
        aVar.AB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bHw() {
        int selectionEnd = bHL().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bHL().getText().getSpans(0, bHL().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bHL().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bHL().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHx() {
        if (this.bqp != null) {
            this.bqp.setBarLauncherEnabled(!this.hJF);
            this.bqp.g(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hJr) {
            this.gOq.setVisibility(8);
            brw();
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
        this.hJB = new com.baidu.tieba.write.b();
        this.hJB.xg(d.C0108d.cp_cont_i);
        this.hJB.xh(d.C0108d.cp_cont_h_alpha85);
        this.hGH = new com.baidu.tieba.write.b();
        this.hGH.xg(d.C0108d.cp_cont_i);
        this.hGH.xh(d.C0108d.cp_cont_h_alpha85);
        initUI();
        this.brS = new LocationModel(this);
        this.brS.a(this.bsf);
        registerListener(this.haP);
        registerListener(this.hJD);
        initEditor();
        this.cwz.requestFocus();
        II();
        bHT();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.bqp = new com.baidu.tbadk.editortools.i(getActivity());
        this.bqp.setBarMaxLauCount(4);
        this.bqp.setMoreButtonAtEnd(true);
        this.bqp.setBarLauncherType(1);
        this.bqp.cb(true);
        this.bqp.cc(true);
        this.bqp.setMoreLauncherIcon(d.f.write_more);
        this.bqp.setBackgroundColorId(d.C0108d.cp_bg_line_d);
        bHy();
        this.bqp.Kx();
        if (this.hJa != null) {
            this.hJa.addView(this.bqp);
        }
        bHz();
        this.bqp.ti();
        com.baidu.tbadk.editortools.l hH = this.bqp.hH(6);
        if (hH != null && !TextUtils.isEmpty(this.brX)) {
            ((View) hH).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.brX);
                }
            });
        }
        if (!this.hJr) {
            this.bqp.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.bqp.IG();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.bqp.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.bqp.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void bHy() {
        r rVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 2);
        aVar.bqW = d.f.write_at;
        this.bqp.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.bqp.b(aVar2);
        aVar2.bqW = d.f.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), r.class);
        if (runTask != null && (rVar = (r) runTask.getData()) != null) {
            rVar.bqY = 4;
            rVar.bqW = d.f.icon_post_location_selector;
            this.bqp.b(rVar);
        }
        if (this.hJf == null) {
            if (this.hJA == null) {
                this.hJA = new com.baidu.tieba.write.editor.d(getActivity(), this.hoo);
                this.hJA.bFX();
                this.hJA.setFrom("from_share_write");
                this.hJA.aN(this.mData.getForumId(), this.mPrivateThread);
            }
            this.bqp.b(this.hJA);
        }
        this.bqp.I(arrayList);
        r hJ = this.bqp.hJ(5);
        if (hJ != null) {
            hJ.bqY = 1;
            hJ.bqW = d.f.write_emotion;
        }
    }

    private void bHz() {
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
                        if (TransmitPostEditActivity.this.bHK()) {
                            TransmitPostEditActivity.this.showToast(d.j.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.bHK()) {
                            TransmitPostEditActivity.this.showToast(d.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            TransmitPostEditActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.bHN();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.brw();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.hJf == null) {
                            TransmitPostEditActivity.this.KZ();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.brY) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.aT(pageActivity)) {
                                    TransmitPostEditActivity.this.KX();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.KW();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.brS != null) {
                            TransmitPostEditActivity.this.brS.mE(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        ak akVar = new ak("c10645");
                        if (TransmitPostEditActivity.this.mData != null) {
                            str = TransmitPostEditActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        akVar.aa(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(akVar);
                        if (TransmitPostEditActivity.this.mData == null || (videoInfo = TransmitPostEditActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.bqp.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.bqp.Kz()) {
                                        TransmitPostEditActivity.this.bqp.IG();
                                        TransmitPostEditActivity.this.bqp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.bqp.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.bqp.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.bqp.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.bqp.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.brw();
                        if (TransmitPostEditActivity.this.cwz != null) {
                            TransmitPostEditActivity.this.cwz.requestFocus();
                        }
                        TransmitPostEditActivity.this.bqp.IG();
                        TransmitPostEditActivity.this.bqp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cwz);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.bqp.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.hIY = true;
                        TransmitPostEditActivity.this.nI(true);
                        if (TransmitPostEditActivity.this.bHM().isFocused()) {
                            TransmitPostEditActivity.this.hIX = "from_title";
                        } else if (TransmitPostEditActivity.this.bHL().isFocused()) {
                            TransmitPostEditActivity.this.hIX = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.hJb.setVisibility(0);
                        TransmitPostEditActivity.this.hJb.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.hJb.hasFocus()) {
                            TransmitPostEditActivity.this.cwz.requestFocus();
                            TransmitPostEditActivity.this.cwz.setSelection(TransmitPostEditActivity.this.cwz.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.hJb.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.bqp.a(31, bVar);
        this.bqp.a(16, bVar);
        this.bqp.a(14, bVar);
        this.bqp.a(24, bVar);
        this.bqp.a(3, bVar);
        this.bqp.a(10, bVar);
        this.bqp.a(11, bVar);
        this.bqp.a(12, bVar);
        this.bqp.a(13, bVar);
        this.bqp.a(15, bVar);
        this.bqp.a(18, bVar);
        this.bqp.a(20, bVar);
        this.bqp.a(25, bVar);
        this.bqp.a(27, bVar);
        this.bqp.a(29, bVar);
        this.bqp.a(43, bVar);
        this.bqp.a(45, bVar);
        this.bqp.a(53, bVar);
        this.bqp.a(48, bVar);
        this.bqp.a(46, bVar);
        this.bqp.a(49, bVar);
        this.bqp.a(47, bVar);
        this.bqp.a(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KZ() {
        if (this.brS.agi()) {
            if (this.brS.bwv()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bwr().getLocationData().bwn());
                return;
            }
            b(1, true, null);
            this.brS.bwt();
            return;
        }
        b(0, true, null);
    }

    protected void bro() {
        if (this.brT != null) {
            this.brT.cancelLoadData();
        }
        if (this.hJc != null) {
            this.hJc.cancelLoadData();
        }
        if (this.brS != null) {
            this.brS.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bro();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGR() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(bHM().getText().toString());
        this.mData.setContent(bHL().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.gOu != null && this.gOu.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gOu, getPageContext().getPageActivity());
                return true;
            } else if (this.bqp.Kz()) {
                this.bqp.IG();
                return true;
            } else {
                bro();
                bGR();
                return true;
            }
        }
        if (i == 67 && (text = bHL().getText()) != null) {
            int selectionStart = bHL().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bHL().onKeyDown(67, this.doI);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aN(i == 1);
        getLayoutMode().aM(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.e(this.mPost, d.C0108d.cp_link_tip_a, 1);
        bHx();
        aj.t(this.gOr, d.C0108d.cp_bg_line_c);
        aj.t(bHM(), d.C0108d.cp_bg_line_d);
        aj.t(bHL(), d.C0108d.cp_bg_line_d);
        brw();
        this.bqp.onChangeSkinType(i);
        if (this.hJp != null) {
            this.hJp.DT();
        }
        aj.r(this.mName, d.C0108d.cp_cont_b);
        bHA();
        bHB();
        if (this.hGH != null) {
            this.hGH.onChangeSkinType();
        }
        if (this.hJB != null) {
            this.hJB.onChangeSkinType();
        }
        this.fvp.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHA() {
        if (this.gOq.hasFocus()) {
            this.gOq.setHintTextColor(aj.getColor(d.C0108d.cp_cont_e));
        } else {
            this.gOq.setHintTextColor(aj.getColor(d.C0108d.cp_cont_d));
        }
        if (this.cwz.hasFocus()) {
            this.cwz.setHintTextColor(aj.getColor(d.C0108d.cp_cont_e));
        } else {
            this.cwz.setHintTextColor(aj.getColor(d.C0108d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHB() {
        if (this.gOq != null) {
            if (this.gOq.getText().toString().length() == 0) {
                this.gOq.getPaint().setFakeBoldText(false);
            } else if (this.gOq.getText().toString().length() > 0) {
                this.gOq.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.bAI = new com.baidu.tbadk.core.view.b(getPageContext());
        this.hJr = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.beR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        aj.r(this.mName, d.C0108d.cp_cont_b);
        bHD();
        this.hJq = (ScrollView) findViewById(d.g.write_scrollview);
        this.hJq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.cwz != null) {
                        l.a(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.cwz);
                    }
                    if (TransmitPostEditActivity.this.bqp != null) {
                        TransmitPostEditActivity.this.bqp.IG();
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
        this.hJa = (LinearLayout) findViewById(d.g.tool_view);
        this.hJa.setContentDescription("..");
        this.hJb = (LinearLayout) findViewById(d.g.title_view);
        this.gOr = findViewById(d.g.interval_view);
        this.hJt = findViewById(d.g.hot_topic_fourm_view);
        this.hJu = findViewById(d.g.hot_topic_divider);
        this.hJv = (TextView) findViewById(d.g.hot_topic_title_edt);
        this.hJw = (TextView) findViewById(d.g.change_one_tv);
        brv();
        if (this.hJr) {
            this.hJq.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        afg();
        bHJ();
        this.cwA = (LinearLayout) findViewById(d.g.post_content_container);
        this.cwA.setDrawingCacheEnabled(false);
        this.cwA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.cwz.requestFocus();
                TransmitPostEditActivity.this.bqp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            }
        });
        this.beR.setOnFocusChangeListener(this.cwG);
        this.beR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.bro();
                TransmitPostEditActivity.this.bGR();
            }
        });
        bHG();
        bHI();
        bHC();
        bHx();
        bHH();
        bru();
        bHO();
        if (this.mData.getType() == 4 && this.gOw != null && this.hJd != null) {
            this.gOw.setVisibility(8);
            this.hJd.setVisibility(8);
        }
        brw();
        ShowSoftKeyPad(this.mInputManager, this.gOq);
    }

    private void bHC() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hoo != null && this.hoo.equals("1")) {
                        this.mName.setText(d.j.share_to_home_page);
                    } else if (this.hoo != null && this.hoo.equals("2")) {
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
                    this.gOq.setVisibility(0);
                    this.cwz.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(d.j.publish_photo_live);
                    this.cwz.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(d.j.send_reply);
                    this.cwz.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gOq.setVisibility(8);
                    return;
            }
        }
    }

    private void bHD() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.s(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.cwG);
    }

    private void bHE() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hIZ && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = am.d(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(d) && bHM() != null) {
                bHM().setText(d);
                bHM().setSelection(d.length());
            }
        }
    }

    private void bHF() {
        this.hJk = null;
        this.hJm = -1;
        this.hJo = -1;
        com.baidu.tieba.frs.ab mZ = aa.avn().mZ(1);
        if (mZ != null) {
            this.hJk = mZ.dEo;
            this.hJm = getIntent().getIntExtra("category_id", -1);
            if (this.hJk != null && !this.hJk.isEmpty() && this.hJm >= 0) {
                this.hJl = new z();
                this.hJl.dEk = 0;
                this.hJl.name = getPageContext().getResources().getString(d.j.category_auto);
                this.hJo = this.hJl.dEk;
                this.hJn = this.hJl.name;
                for (z zVar : this.hJk) {
                    if (zVar.dEk == this.hJm) {
                        this.hJo = zVar.dEk;
                        this.hJn = zVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bHG() {
        if (this.hJk != null && !this.hJk.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.hJp = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.hJp.setText(this.hJn);
            this.hJp.b(this.hJk, this.hJl, this.hJo);
            this.hJp.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, av avVar) {
                    if (avVar != null) {
                        TransmitPostEditActivity.this.hJp.setText(avVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(avVar.dEk);
                        TransmitPostEditActivity.this.hJo = avVar.dEk;
                        TransmitPostEditActivity.this.hJp.bGJ();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.hJp.bGI();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHM());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHL());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hJH = new com.baidu.tieba.view.d(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hJH.setTitle(d.j.no_disturb_start_time);
        this.hJH.setButton(-1, getPageContext().getString(d.j.alert_yes_button), this.hJH);
        this.hJH.setButton(-2, getPageContext().getString(d.j.cancel), this.hJH);
        return this.hJH;
    }

    private void bHH() {
        this.hJg = (RelativeLayout) findViewById(d.g.addition_container);
        this.hJh = (TextView) findViewById(d.g.addition_create_time);
        this.hJi = (TextView) findViewById(d.g.addition_last_time);
        this.hJj = (TextView) findViewById(d.g.addition_last_content);
        if (this.hJf != null) {
            this.hJg.setVisibility(0);
            this.hJh.setText(getPageContext().getString(d.j.write_addition_create) + am.z(this.hJf.getCreateTime() * 1000));
            if (this.hJf.getAlreadyCount() == 0) {
                this.hJi.setVisibility(8);
            } else {
                this.hJi.setText(getPageContext().getString(d.j.write_addition_last) + am.z(this.hJf.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hJf.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hJj.setText(lastAdditionContent);
            } else {
                this.hJj.setVisibility(8);
            }
            bHL().setHint(String.format(getPageContext().getString(d.j.write_addition_hint), Integer.valueOf(this.hJf.getAlreadyCount()), Integer.valueOf(this.hJf.getTotalCount())));
            this.mName.setText(d.j.write_addition_title);
            return;
        }
        this.hJg.setVisibility(8);
    }

    private void bru() {
        this.gOw = findViewById(d.g.post_prefix_layout);
        this.gOt = (TextView) findViewById(d.g.post_prefix);
        this.hJd = findViewById(d.g.prefix_divider);
        this.gOv = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gOw.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gNZ = 1;
            this.gOw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.gOt.setVisibility(0);
                    TransmitPostEditActivity.this.gOw.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gOu, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.bqp.IG();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gOq);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cwz);
                }
            });
            this.gOv = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gOv.setVisibility(0);
                this.gOt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.gOt.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gOu, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.bqp.IG();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHM());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHL());
                    }
                });
            }
            this.gOu = new com.baidu.tieba.write.e(getPageContext().getPageActivity());
            this.gOu.a(this);
            this.gOu.setMaxHeight(l.s(getActivity(), d.e.ds510));
            this.gOu.setOutsideTouchable(true);
            this.gOu.setFocusable(true);
            this.gOu.setOnDismissListener(this);
            this.gOu.setBackgroundDrawable(aj.getDrawable(d.C0108d.cp_bg_line_d));
            int color = aj.getColor(d.C0108d.cp_cont_b);
            int color2 = aj.getColor(d.C0108d.cp_cont_c);
            aj.s(this.gOt, d.C0108d.cp_bg_line_d);
            aj.c(this.gOv, d.f.icon_frs_arrow_n);
            this.gOt.setTextColor(color);
            this.hHT.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.d dVar = new com.baidu.tieba.write.d(getActivity());
                this.hHT.add(dVar);
                dVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    dVar.setPrefixTextColor(color2);
                } else {
                    dVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    dVar.setDividerStyle(false);
                }
                this.gOu.addView(dVar);
            }
            this.gOu.setCurrentIndex(0);
            this.gOt.setText(prefixs.get(1));
            xI(1);
            return;
        }
        this.gOw.setVisibility(8);
    }

    protected void bHI() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    TransmitPostEditActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.hJB.bEQ()) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.hJB.bES());
                        TransmitPostEditActivity.this.nH(true);
                    } else if (TransmitPostEditActivity.this.hGH.bEQ()) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.hGH.bES());
                        TransmitPostEditActivity.this.nB(true);
                    } else {
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHM());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHL());
                        TransmitPostEditActivity.this.bqp.IG();
                        TiebaStatic.log(new ak("c12608").s("obj_locate", 7));
                        TransmitPostEditActivity.this.bHR();
                    }
                }
            }
        });
    }

    protected void brv() {
        this.gOq = (EditText) findViewById(d.g.post_title);
        this.gOq.setOnClickListener(this.hJE);
        this.gOq.setOnFocusChangeListener(this.cwG);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.gOq.setText(this.mData.getTitle());
            this.gOq.setSelection(this.mData.getTitle().length());
        }
        this.gOq.addTextChangedListener(this.cwI);
        if (!this.mData.getHaveDraft()) {
            bHE();
        }
        this.gOq.setHint(getResources().getString(d.j.post_title_hint));
    }

    protected void afg() {
        this.cwz = (EditText) findViewById(d.g.post_content);
        this.cwz.setDrawingCacheEnabled(false);
        this.cwz.setOnClickListener(this.hJE);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString U = TbFaceManager.LQ().U(getPageContext().getPageActivity(), this.mData.getContent());
            this.cwz.setText(U);
            this.cwz.setSelection(U.length());
        }
        this.cwz.setOnFocusChangeListener(this.cwG);
        this.cwz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.bqp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.cwz.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.cwz.addTextChangedListener(this.hJG);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.cwz.setHint(d.j.share_video_default);
        } else {
            this.cwz.setHint(d.j.share_txt_default);
        }
    }

    private void bHJ() {
        this.fvp = (OriginalThreadCardView) findViewById(d.g.write_original_thread_cardview);
        this.fvp.setVisibility(0);
        this.fvp.b(this.mOriginalThreadInfo);
        this.fvp.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bHK() {
        int i = 5000;
        if (this.hJf != null) {
            i = 1000;
        }
        return bHL().getText() != null && bHL().getText().length() >= i;
    }

    private void gg(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hIX)) {
                this.hIX = "";
                bHL().requestFocus();
                if (bHL().getText() != null && bHL().getText().length() + str.length() > 5000) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bHL().getSelectionStart();
                    editable = bHL().getText();
                }
            } else if ("from_title".equals(this.hIX)) {
                this.hIX = "";
                bHM().requestFocus();
                if (bHM().getText() != null && bHM().getText().length() + str.length() > 31) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bHM().getSelectionStart();
                    editable = bHM().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nI(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    protected void d(n nVar) {
        if (((ImageSpan[]) bHL().getText().getSpans(0, bHL().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hJe == null) {
                this.hJe = Toast.makeText(getPageContext().getPageActivity(), d.j.too_many_face, 0);
            }
            this.hJe.show();
            return;
        }
        String name = nVar.getName();
        final EmotionGroupType Ft = nVar.Ft();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.nm().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.bHL().getSelectionStart(), aVar, Ft);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bHL() != null && bHL().getText() != null) {
            Bitmap sj = aVar.sj();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(sj);
            int width = sj.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, sj.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.i(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bHL().getSelectionStart() - 1;
                if (bHL().getText().length() > 1 && selectionStart >= 0 && bHL().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bHL().getText().insert(bHL().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bHL().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bHL().getText().insert(bHL().getSelectionStart(), spannableString2);
            }
            Editable text = bHL().getText();
            if (text != null) {
                this.hJz.clear();
                this.hJz.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hJz);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bHL().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bHL().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bHL().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bHL() {
        return this.cwz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bHM() {
        return this.gOq;
    }

    protected void bHN() {
        Editable text;
        if (bHL() != null && (text = bHL().getText()) != null) {
            int selectionStart = bHL().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bHL().onKeyDown(67, this.doI);
            }
            bHL().onKeyDown(67, this.doI);
            int selectionStart2 = bHL().getSelectionStart();
            this.hJz.clear();
            this.hJz.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.hJz);
            bHL().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.bAI.c(null);
        this.bAI.fY(d.j.sending);
        this.bAI.bn(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.bAI.bn(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brw() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bHM() != null) {
                str = bHM().getText().toString();
            }
            if (bHL() != null) {
                str2 = bHL().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.gNZ == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            ef(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        ef(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    ef(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hJr) {
                    ef(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    ef(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                ef(true);
            } else if (this.mData.getVideoInfo() != null) {
                ef(true);
            } else {
                ef(false);
            }
        }
    }

    private void ef(boolean z) {
        aj.d(this.mPost, d.C0108d.cp_link_tip_a, d.C0108d.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.brT = new NewWriteModel(this);
        this.brT.b(this.bsh);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.bro();
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
                this.hJf = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hJf != null);
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
            this.hoo = bundle.getString("KEY_CALL_FROM");
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
            this.hJf = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hJf != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hoo = intent.getStringExtra("KEY_CALL_FROM");
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
            this.hIZ = true;
        }
        bHF();
    }

    private void bHO() {
        if (v.D(this.mList) > 0 && this.mList.get(0) != null) {
            this.hJt.setVisibility(0);
            this.hJu.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.gOq.setText(com.baidu.tbadk.plugins.a.gT(uE(this.mList.get(0).mTopicName)));
                this.gOq.setMovementMethod(com.baidu.tieba.view.e.bDW());
            }
            this.hJv.setText(this.mList.get(0).mForumName);
            this.gOq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!TransmitPostEditActivity.this.hJx.equals(charSequence.toString())) {
                        TransmitPostEditActivity.this.hJy = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString gT;
                    if (!TransmitPostEditActivity.this.hJx.equals(editable.toString()) && (gT = com.baidu.tbadk.plugins.a.gT(editable.toString())) != null) {
                        TransmitPostEditActivity.this.hJx = gT.toString();
                        TransmitPostEditActivity.this.gOq.setText(gT);
                        if (TransmitPostEditActivity.this.hJy <= TransmitPostEditActivity.this.gOq.getText().length()) {
                            TransmitPostEditActivity.this.gOq.setSelection(TransmitPostEditActivity.this.hJy);
                        }
                    }
                }
            });
            this.hJw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicChangeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 25005, TransmitPostEditActivity.this.mList)));
                }
            });
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString gT = com.baidu.tbadk.plugins.a.gT(uE(hotTopicBussinessData.mTopicName));
            if (gT != null) {
                this.gOq.setText(gT);
            }
            this.hJv.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String uE(String str) {
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
        if (this.hJf != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hJf));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.hoo);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bHL().getEditableText().toString();
        if (obj != null) {
            bHL().setText(TbFaceManager.LQ().a(getPageContext().getPageActivity(), obj, this.hJC));
            bHL().setSelection(bHL().getText().length());
        }
    }

    private String bHP() {
        if (bHL() == null || bHL().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(bHL().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(d.j.share_video_default);
            }
            return getString(d.j.share_txt_default);
        }
        return bHL().getText().toString();
    }

    private String bHQ() {
        if (this.mData == null || bHM() == null || bHM().getVisibility() != 0 || bHM().getText() == null) {
            return "";
        }
        String obj = bHM().getText().toString();
        if (this.mPrefixData != null && v.D(this.mPrefixData.getPrefixs()) > 0 && this.gNZ != 0 && this.mData.getType() != 4 && this.gOt != null && this.gOt.getText() != null) {
            obj = this.gOt.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void bGS() {
        bro();
        this.mData.setContent(bHP());
        this.mData.setTitle(bHQ());
        if (this.hJm >= 0) {
            this.mData.setCategoryFrom(this.hJm);
        }
        if (this.hJo >= 0) {
            this.mData.setCategoryTo(this.hJo);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.brS != null && this.brS.agi());
        this.brT.mG(this.writeImagesInfo.size() > 0);
        if (!v.E(this.mList) && this.hJs != null && this.hJs.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hJs.mForumId));
            this.mData.setForumName(this.hJs.mForumName);
        }
        this.brT.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.brT.getWriteData().setVoice(null);
        this.brT.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.oJ()) {
            showToast(d.j.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
        this.brT.startPostWrite();
    }

    private void o(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.hJf != null) {
                i2 = this.hJf.getTotalCount();
                i = this.hJf.getAlreadyCount() + 1;
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
                if (this.bqp != null && !this.bqp.Kz()) {
                    bHL().requestFocus();
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
                            bHL().getText().insert(bHL().getSelectionStart(), sb.toString());
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
                        if (this.hIY) {
                            sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                            this.hIY = false;
                        }
                        sb2.append(stringExtra);
                        gg(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !v.E(this.mList) && !v.E(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.hJs = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.hJs);
            }
        } else if (i2 == 0) {
            if (this.bqp != null && !this.bqp.Kz()) {
                this.cwz.requestFocus();
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
                        this.hGH.av(postWriteCallBackData.getSensitiveWords());
                        this.hJB.av(postWriteCallBackData.getSensitiveWords());
                        if (!v.E(this.hGH.bEO())) {
                            nB(true);
                            nH(true);
                            return;
                        }
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.hIX)) {
                        bHM().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hIX)) {
                        bHL().requestFocus();
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
        if ("1".equals(this.hoo)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.hoo)) {
            this.mData.setCanNoForum(false);
        }
        bHS();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.hoo);
        bGS();
    }

    private void bHS() {
        if (this.bqp != null) {
            this.bqp.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bHM());
        HidenSoftKeyPad(this.mInputManager, bHL());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.vQ(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dCx) != null) {
                    TiebaStatic.log(new ak("c12534").s("obj_locate", ap.a.aVY));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.j.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hJf == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                o(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.brY = i;
        if (this.bqp != null) {
            this.bqp.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bHT() {
        if (!this.hJr && this.bqp != null) {
            this.bqp.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.bqp.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj(boolean z) {
        if (this.bqp != null) {
            this.bqp.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void xI(int i) {
        if (i < this.hHT.size()) {
            for (int i2 = 0; i2 < this.hHT.size(); i2++) {
                this.hHT.get(i2).nv(false);
            }
            this.hHT.get(i).nv(true);
        }
    }

    @Override // com.baidu.tieba.write.e.a
    public void vm(int i) {
        this.gNZ = i;
        this.gOu.setCurrentIndex(i);
        xI(i);
        this.gOt.setText(this.mPrefixData.getPrefixs().get(i));
        brw();
        com.baidu.adp.lib.g.g.a(this.gOu, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gOw.setSelected(false);
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
            KX();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hJA != null && !z) {
            this.hJA.bdL();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hIY = false;
            this.hIX = "";
            if ("from_content".equals(str)) {
                this.hIX = "from_content";
            } else if ("from_title".equals(str)) {
                this.hIX = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                nI(false);
            }
        }
    }

    public void II() {
        if (!v.E(this.mList)) {
            this.hJb.setVisibility(0);
            this.hJb.requestFocus();
            this.bqp.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hJb.setVisibility(8);
    }
}
