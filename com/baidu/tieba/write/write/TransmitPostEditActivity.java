package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import com.baidu.l.a.a;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.editortools.m;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.i;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.tieba.write.view.PostCategoryView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
/* loaded from: classes7.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0154a, i.a {
    private OriginalThreadCardView akm;
    private EditorTools fCT;
    private LocationModel fFf;
    private NewWriteModel fFg;
    List<ab> gOO;
    private boolean isPrivacy;
    private String jfW;
    private String jfX;
    private BaijiahaoData mBaijiahaoData;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private TextView noN;
    private com.baidu.tieba.write.i noO;
    private ImageView noP;
    private View noQ;
    private int nop;
    private FrsTabInfoData ogN;
    private TextView omA;
    private com.baidu.tieba.write.editor.b omC;
    private g omE;
    private ForumTabSelectedView omF;
    private com.baidu.tieba.view.b omM;
    private OriginalThreadInfo.ShareInfo ome;
    private LinearLayout omg;
    private LinearLayout omh;
    private View omk;
    private Toast omm;
    private AdditionData omn;
    private RelativeLayout omo;
    private TextView omp;
    private TextView omq;
    private TextView omr;
    ab oms;
    private int omt;
    private String omu;
    private int omv;
    private PostCategoryView omw;
    private HotTopicBussinessData omz;
    private static final int omb = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    private static final int fYf = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44);
    private String omc = "";
    private boolean omd = false;
    private WriteData noo = null;
    private boolean omf = false;
    private InputMethodManager mInputManager = null;
    private EditText noI = null;
    private View noJ = null;
    private LinearLayout noL = null;
    private SpanGroupEditText omi = null;
    private FeedBackModel omj = null;
    private ArrayList<WritePrefixItemLayout> oml = new ArrayList<>();
    private final KeyEvent iUi = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView lWH = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener iYW = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout lzu = null;
    private String fFk = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int fFl = 0;
    private View mRootView = null;
    private ScrollView omx = null;
    private boolean omy = false;
    private com.baidu.tbadk.core.view.a fNE = null;
    private String mFrom = "write";
    private String jOM = "2";
    private SpannableStringBuilder omB = new SpannableStringBuilder();
    private boolean bsF = false;
    private final c omD = new c();
    private TbFaceManager.a omG = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan Dn(String str) {
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
    private final AntiHelper.a jjA = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aq("obj_locate", ay.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aq("obj_locate", ay.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d fFv = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.noo != null) {
                TransmitPostEditActivity.this.omD.bg(null);
                if (z) {
                    TransmitPostEditActivity.this.kZ(z);
                    TransmitPostEditActivity.this.c(true, postWriteCallBackData);
                    TransmitPostEditActivity.this.j(postWriteCallBackData);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    TransmitPostEditActivity.this.setResult(-1, intent);
                    TransmitPostEditActivity.this.finish();
                } else if (postWriteCallBackData.isSensitiveError()) {
                    TransmitPostEditActivity.this.showToast(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.omD.Vo(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.omD.bg(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.omD.b(TransmitPostEditActivity.this.noI, TransmitPostEditActivity.this.omi);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.d(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.d(TransmitPostEditActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(TransmitPostEditActivity.this.getActivity());
                    if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.AB(TransmitPostEditActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.AB(postWriteCallBackData.getErrorString());
                    }
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(TransmitPostEditActivity.this.getActivity(), 0, 26, 1)));
                            TiebaStatic.log(new ar("c13746").aq("obj_locate", 1).aq("obj_type", 1));
                        }
                    });
                    aVar.b(TransmitPostEditActivity.this.getPageContext()).bqz();
                    TiebaStatic.log(new ar("c13745").aq("obj_locate", 1).aq("obj_type", 1));
                } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bwI());
                    if (com.baidu.tbadk.t.a.Ef(ahVar.bwH())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bwH())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a fFt = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bCk() {
            TransmitPostEditActivity.this.showToast(R.string.no_network_guide);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void onFail(String str) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            if (StringUtils.isNull(str)) {
                str = TransmitPostEditActivity.this.getPageContext().getString(R.string.location_fail);
            }
            transmitPostEditActivity.showToast(str);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(LocationData locationData) {
            if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                TransmitPostEditActivity.this.b(2, true, locationData.getFormatted_address());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener nBP = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.fFf.yB(false);
                    TransmitPostEditActivity.this.fFf.gC(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.fFf.yB(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener omH = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener omI = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.fCT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dYo = TransmitPostEditActivity.this.dYo();
            if (dYo >= 0 && dYo < TransmitPostEditActivity.this.omi.getText().length()) {
                TransmitPostEditActivity.this.omi.setSelection(dYo);
            }
        }
    };
    private boolean omJ = true;
    private final View.OnFocusChangeListener hzb = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.noI || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.lWH) {
                if (z) {
                    TransmitPostEditActivity.this.omJ = true;
                    TransmitPostEditActivity.this.dYp();
                    if (TransmitPostEditActivity.this.fCT != null) {
                        TransmitPostEditActivity.this.fCT.bzG();
                    }
                    l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.noI);
                } else if (view == TransmitPostEditActivity.this.noI) {
                    TransmitPostEditActivity.this.noN.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.omi && z) {
                TransmitPostEditActivity.this.omJ = false;
                TransmitPostEditActivity.this.dYp();
                TransmitPostEditActivity.this.fCT.bzG();
                l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.omi);
            }
            TransmitPostEditActivity.this.dYu();
        }
    };
    private TextWatcher omK = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String omO = "";
        private String omP;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.omP = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.omP != null ? this.omP.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dKh();
            TransmitPostEditActivity.this.dYv();
            EditText dYH = TransmitPostEditActivity.this.dYH();
            if (editable != null && dYH != null && dYH.getText() != null) {
                if (this.omO == null || !this.omO.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.omD != null) {
                        this.omO = dYH.getText().toString();
                        TransmitPostEditActivity.this.omD.b(dYH, true);
                        return;
                    }
                    return;
                }
                dYH.setSelection(dYH.getSelectionEnd());
            }
        }
    };
    private TextWatcher omL = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String omP;
        private String omQ = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.omP = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.omP != null ? this.omP.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dKh();
            EditText dYG = TransmitPostEditActivity.this.dYG();
            if (editable != null && dYG != null && dYG.getText() != null) {
                int selectionEnd = dYG.getSelectionEnd();
                if (this.omQ == null || !this.omQ.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.omD != null) {
                        this.omQ = dYG.getText().toString();
                        TransmitPostEditActivity.this.omD.b(dYG, false);
                        return;
                    }
                    return;
                }
                dYG.setSelection(selectionEnd);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || au.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBS() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void bBU() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bBW();
        } else if (this.fFf.dOG()) {
            bBS();
        } else {
            this.fFf.yB(false);
            b(1, true, null);
            this.fFf.dOE();
        }
    }

    private void bBW() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ny(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.fFf.dOI();
                } else {
                    TransmitPostEditActivity.this.fFt.bCk();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TransmitPostEditActivity.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.bqz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dYo() {
        int selectionEnd = dYG().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dYG().getText().getSpans(0, dYG().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dYG().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dYG().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYp() {
        if (this.fCT != null) {
            this.fCT.setBarLauncherEnabled(!this.omJ);
            this.fCT.setToolEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.omy) {
            this.noI.setVisibility(8);
            dKh();
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
        this.fFf = new LocationModel(getPageContext());
        this.fFf.a(this.fFt);
        registerListener(this.nBP);
        registerListener(this.omH);
        dan();
        this.omi.requestFocus();
        dEk();
        dYP();
    }

    @SuppressLint({"ResourceAsColor"})
    private void dan() {
        this.fCT = new EditorTools(getActivity());
        this.fCT.setBarMaxLauCount(4);
        this.fCT.setMoreButtonAtEnd(true);
        this.fCT.setBarLauncherType(1);
        this.fCT.kN(true);
        this.fCT.kO(true);
        this.fCT.setBackgroundColorId(R.color.CAM_X0207);
        dYq();
        this.fCT.build();
        if (this.omg != null) {
            this.omg.addView(this.fCT);
        }
        cZL();
        this.fCT.display();
        com.baidu.tbadk.editortools.h qS = this.fCT.qS(6);
        if (qS != null && !TextUtils.isEmpty(this.fFk)) {
            ((View) qS).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.fFk);
                }
            });
        }
        if (!this.omy) {
            this.fCT.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.fCT.bzG();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.fCT.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.fCT.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.noo.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.noo.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        dYs();
    }

    private void dYq() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.fCT.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        if (this.omn == null) {
            if (this.omC == null) {
                this.omC = new com.baidu.tieba.write.editor.b(getActivity(), this.jOM);
                this.omC.dXv();
                this.omC.setFrom("from_share_write");
                this.omC.ca(this.noo.getForumId(), this.mPrivateThread);
            }
            this.fCT.b(this.omC);
        }
        this.fCT.bG(arrayList);
        m qV = this.fCT.qV(5);
        if (qV != null) {
            qV.fDG = 1;
        }
    }

    private void cZL() {
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
                            TiebaStatic.log(new ar("c12608").aq("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.dYF()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.dYF()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof u)) {
                            TransmitPostEditActivity.this.e((u) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.dYI();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.dKh();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.omn == null) {
                            TransmitPostEditActivity.this.bBX();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.fFl) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ae.checkLocationForGoogle(pageActivity)) {
                                    TransmitPostEditActivity.this.bBU();
                                    return;
                                } else {
                                    ae.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.bBS();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.fFf != null) {
                            TransmitPostEditActivity.this.fFf.yB(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        ar arVar = new ar("c10645");
                        if (TransmitPostEditActivity.this.noo != null) {
                            str = TransmitPostEditActivity.this.noo.getForumId();
                        } else {
                            str = "";
                        }
                        arVar.dR("fid", str);
                        TiebaStatic.log(arVar);
                        if (TransmitPostEditActivity.this.noo == null || (videoInfo = TransmitPostEditActivity.this.noo.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.fCT.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.fCT.bBo()) {
                                        TransmitPostEditActivity.this.fCT.bzG();
                                        TransmitPostEditActivity.this.fCT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.fCT.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.fCT.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.fCT.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.fCT.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.noo.setVideoInfo(null);
                        TransmitPostEditActivity.this.dKh();
                        if (TransmitPostEditActivity.this.omi != null) {
                            TransmitPostEditActivity.this.omi.requestFocus();
                        }
                        TransmitPostEditActivity.this.fCT.bzG();
                        TransmitPostEditActivity.this.fCT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.omi);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.fCT.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.omd = true;
                        TransmitPostEditActivity.this.zG(true);
                        if (TransmitPostEditActivity.this.dYH().isFocused()) {
                            TransmitPostEditActivity.this.omc = "from_title";
                        } else if (TransmitPostEditActivity.this.dYG().isFocused()) {
                            TransmitPostEditActivity.this.omc = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.omh.setVisibility(0);
                        TransmitPostEditActivity.this.omh.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.omh.hasFocus()) {
                            TransmitPostEditActivity.this.omi.requestFocus();
                            TransmitPostEditActivity.this.omi.setSelection(TransmitPostEditActivity.this.omi.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.omh.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.fCT.setActionListener(31, bVar);
        this.fCT.setActionListener(16, bVar);
        this.fCT.setActionListener(14, bVar);
        this.fCT.setActionListener(24, bVar);
        this.fCT.setActionListener(3, bVar);
        this.fCT.setActionListener(10, bVar);
        this.fCT.setActionListener(11, bVar);
        this.fCT.setActionListener(12, bVar);
        this.fCT.setActionListener(13, bVar);
        this.fCT.setActionListener(15, bVar);
        this.fCT.setActionListener(18, bVar);
        this.fCT.setActionListener(20, bVar);
        this.fCT.setActionListener(25, bVar);
        this.fCT.setActionListener(27, bVar);
        this.fCT.setActionListener(29, bVar);
        this.fCT.setActionListener(43, bVar);
        this.fCT.setActionListener(45, bVar);
        this.fCT.setActionListener(53, bVar);
        this.fCT.setActionListener(48, bVar);
        this.fCT.setActionListener(46, bVar);
        this.fCT.setActionListener(49, bVar);
        this.fCT.setActionListener(47, bVar);
        this.fCT.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBX() {
        if (this.fFf.clN()) {
            if (this.fFf.dOG()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.b.dOB().getLocationData().getFormatted_address());
                return;
            }
            b(1, true, null);
            this.fFf.dOE();
            return;
        }
        b(0, true, null);
    }

    protected void dJZ() {
        if (this.fFg != null) {
            this.fFg.cancelLoadData();
        }
        if (this.omj != null) {
            this.omj.cancelLoadData();
        }
        if (this.fFf != null) {
            this.fFf.cancelLoadData();
        }
    }

    private void dYr() {
        if (this.omE != null) {
            this.omE.hideTip();
        }
    }

    private void dYs() {
        if (this.omE == null) {
            this.omE = new g(getPageContext());
        }
        this.omE.d(this.fCT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dYr();
        TiebaPrepareImageService.StopService();
        dJZ();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYt() {
        if (this.noo == null) {
            finish();
            return;
        }
        this.noo.setTitle(dYH().getText().toString());
        this.noo.setContent(dYG().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.noO != null && this.noO.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.noO, getPageContext().getPageActivity());
                return true;
            } else if (this.fCT.bBo()) {
                this.fCT.bzG();
                return true;
            } else {
                dJZ();
                dYt();
                return true;
            }
        }
        if (i == 67 && (text = dYG().getText()) != null) {
            int selectionStart = dYG().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dYG().onKeyDown(67, this.iUi);
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
        getLayoutMode().onModeChanged(this.lzu);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.lWH, R.color.CAM_X0302, 1);
        dYp();
        ap.setBackgroundColor(this.noJ, R.color.CAM_X0204);
        ap.setBackgroundColor(dYH(), R.color.CAM_X0201);
        ap.setBackgroundColor(dYG(), R.color.CAM_X0201);
        dKh();
        this.fCT.onChangeSkinType(i);
        if (this.omw != null) {
            this.omw.bus();
        }
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        dYu();
        dYv();
        if (this.omD != null) {
            this.omD.c(dYH(), dYG());
        }
        if (this.akm != null) {
            this.akm.onChangeSkinType();
        }
        if (this.omF != null) {
            this.omF.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYu() {
        if (this.noI.hasFocus()) {
            this.noI.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        } else {
            this.noI.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        }
        if (this.omi.hasFocus()) {
            this.omi.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        } else {
            this.omi.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYv() {
        if (this.noI != null) {
            if (this.noI.getText().toString().length() == 0) {
                this.noI.getPaint().setFakeBoldText(false);
            } else if (this.noI.getText().toString().length() > 0) {
                this.noI.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.fNE = new com.baidu.tbadk.core.view.a(getPageContext());
        this.omy = this.noo.getType() == 4 || 5 == this.noo.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bsU().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        dYy();
        this.omx = (ScrollView) findViewById(R.id.write_scrollview);
        this.omx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.omi != null) {
                        l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.omi);
                    }
                    if (TransmitPostEditActivity.this.fCT != null) {
                        TransmitPostEditActivity.this.fCT.bzG();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.lzu = (RelativeLayout) findViewById(R.id.parent);
        this.omg = (LinearLayout) findViewById(R.id.tool_view);
        this.omg.setContentDescription(IStringUtil.TOP_PATH);
        this.omh = (LinearLayout) findViewById(R.id.title_view);
        this.noJ = findViewById(R.id.interval_view);
        this.omA = (TextView) findViewById(R.id.hot_topic_title_edt);
        dKg();
        if (this.omy) {
            this.omx.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        dKi();
        dYE();
        this.noL = (LinearLayout) findViewById(R.id.post_content_container);
        this.noL.setDrawingCacheEnabled(false);
        this.noL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.fCT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.omi.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.hzb);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.dJZ();
                TransmitPostEditActivity.this.dYt();
            }
        });
        dYB();
        dYD();
        dYx();
        dYp();
        dYC();
        dKf();
        dYJ();
        dYw();
        if (this.noo.getType() == 4 && this.noQ != null && this.omk != null) {
            this.noQ.setVisibility(8);
            this.omk.setVisibility(8);
        }
        dKh();
        ShowSoftKeyPad(this.mInputManager, this.noI);
    }

    private void dYw() {
        this.omF = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.omF.setBgColor(R.color.CAM_X0205);
        this.omF.setData(this.ogN);
        this.omF.setActivity(this);
    }

    private void dYx() {
        String str;
        String str2;
        if (this.noo != null) {
            switch (this.noo.getType()) {
                case 0:
                case 9:
                    if (this.jOM != null && this.jOM.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                    } else if (this.jOM != null && this.jOM.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.noo.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.noI.setVisibility(0);
                    this.omi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.omi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.omi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.noI.setVisibility(8);
                    return;
            }
        }
    }

    private void dYy() {
        this.lWH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lWH.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.lWH.setLayoutParams(layoutParams);
        this.lWH.setOnFocusChangeListener(this.hzb);
    }

    private void dYz() {
        if (this.noo != null && this.noo.getType() == 0 && this.noo.getType() == 9 && !this.omf && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = au.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dYH() != null) {
                dYH().setText(cutStringWithSuffix);
                dYH().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void dYA() {
        this.gOO = null;
        this.omt = -1;
        this.omv = -1;
        ad yY = ac.cEL().yY(1);
        if (yY != null) {
            this.gOO = yY.jmH;
            this.omt = getIntent().getIntExtra("category_id", -1);
            if (this.gOO != null && !this.gOO.isEmpty() && this.omt >= 0) {
                this.oms = new ab();
                this.oms.jmD = 0;
                this.oms.name = getPageContext().getResources().getString(R.string.category_auto);
                this.omv = this.oms.jmD;
                this.omu = this.oms.name;
                for (ab abVar : this.gOO) {
                    if (abVar.jmD == this.omt) {
                        this.omv = abVar.jmD;
                        this.omu = abVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dYB() {
        if (this.gOO != null && !this.gOO.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.omw = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.omw.setText(this.omu);
            this.omw.setCategoryContainerData(this.gOO, this.oms, this.omv);
            this.omw.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bc bcVar) {
                    if (bcVar != null) {
                        TransmitPostEditActivity.this.omw.setText(bcVar.name);
                        TransmitPostEditActivity.this.noo.setCategoryTo(bcVar.jmD);
                        TransmitPostEditActivity.this.omv = bcVar.jmD;
                        TransmitPostEditActivity.this.omw.dXT();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.omw.dXS();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dYH());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dYG());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.omM = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.omM.setTitle(R.string.no_disturb_start_time);
        this.omM.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.omM);
        this.omM.setButton(-2, getPageContext().getString(R.string.cancel), this.omM);
        return this.omM;
    }

    private void dYC() {
        this.omo = (RelativeLayout) findViewById(R.id.addition_container);
        this.omp = (TextView) findViewById(R.id.addition_create_time);
        this.omq = (TextView) findViewById(R.id.addition_last_time);
        this.omr = (TextView) findViewById(R.id.addition_last_content);
        if (this.omn != null) {
            this.omo.setVisibility(0);
            this.omp.setText(getPageContext().getString(R.string.write_addition_create) + au.getFormatTime(this.omn.getCreateTime() * 1000));
            if (this.omn.getAlreadyCount() == 0) {
                this.omq.setVisibility(8);
            } else {
                this.omq.setText(getPageContext().getString(R.string.write_addition_last) + au.getFormatTime(this.omn.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.omn.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.omr.setText(lastAdditionContent);
            } else {
                this.omr.setVisibility(8);
            }
            dYG().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.omn.getAlreadyCount()), Integer.valueOf(this.omn.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.omo.setVisibility(8);
    }

    private void dKf() {
        this.noQ = findViewById(R.id.post_prefix_layout);
        this.noN = (TextView) findViewById(R.id.post_prefix);
        this.omk = findViewById(R.id.prefix_divider);
        this.noP = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.noQ.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.nop = 1;
            this.noQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.noN.setVisibility(0);
                    TransmitPostEditActivity.this.noQ.setSelected(true);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.noO, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.fCT.bzG();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.noI);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.omi);
                }
            });
            this.noP = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.noP.setVisibility(0);
                this.noN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.noN.setSelected(true);
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.noO, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.fCT.bzG();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dYH());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dYG());
                    }
                });
            }
            this.noO = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.noO.a(this);
            this.noO.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.noO.setOutsideTouchable(true);
            this.noO.setFocusable(true);
            this.noO.setOnDismissListener(this);
            this.noO.setBackgroundDrawable(ap.getDrawable(R.color.CAM_X0201));
            int color = ap.getColor(R.color.CAM_X0105);
            int color2 = ap.getColor(R.color.CAM_X0108);
            ap.setBackgroundResource(this.noN, R.color.CAM_X0201);
            ap.setImageResource(this.noP, R.drawable.icon_frs_arrow_n);
            this.noN.setTextColor(color);
            this.oml.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.oml.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.noO.addView(writePrefixItemLayout);
            }
            this.noO.setCurrentIndex(0);
            this.noN.setText(prefixs.get(1));
            LE(1);
            return;
        }
        this.noQ.setVisibility(8);
    }

    protected void dYD() {
        this.lWH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick() && !TransmitPostEditActivity.this.dYQ()) {
                    if (TransmitPostEditActivity.this.omD.a(TransmitPostEditActivity.this.noI, TransmitPostEditActivity.this.omi)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.omD.dWH());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dYH());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dYG());
                    TransmitPostEditActivity.this.fCT.bzG();
                    TiebaStatic.log(new ar("c12608").aq("obj_locate", 7));
                    TransmitPostEditActivity.this.dYN();
                }
            }
        });
    }

    protected void dKg() {
        this.noI = (EditText) findViewById(R.id.post_title);
        this.noI.setOnClickListener(this.omI);
        this.noI.setOnFocusChangeListener(this.hzb);
        if ((this.noo.getType() == 0 || this.noo.getType() == 9 || this.noo.getType() == 7) && this.noo.getTitle() != null) {
            this.noI.setText(this.noo.getTitle());
            this.noI.setSelection(this.noo.getTitle().length());
        }
        this.noI.addTextChangedListener(this.omK);
        if (!this.noo.getHaveDraft()) {
            dYz();
        }
        this.noI.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void dKi() {
        this.omi = (SpanGroupEditText) findViewById(R.id.post_content);
        this.omi.setDrawingCacheEnabled(false);
        this.omi.setOnClickListener(this.omI);
        if (this.fFg != null) {
            this.fFg.setSpanGroupManager(this.omi.getSpanGroupManager());
        }
        if (this.noo != null) {
            this.noo.setSpanGroupManager(this.omi.getSpanGroupManager());
        }
        if (this.noo.getContent() != null && this.noo.getContent().length() > 0) {
            this.omi.setText(TbFaceManager.bCR().aD(getPageContext().getPageActivity(), this.noo.getContent()));
            this.omi.setSelection(this.omi.getText().length());
        }
        if (!au.isEmpty(this.jfW)) {
            this.omi.setSelection(0);
        }
        this.omi.setOnFocusChangeListener(this.hzb);
        this.omi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.fCT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.omi.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.omi.addTextChangedListener(this.omL);
        if (this.ome != null && this.ome.showType == 3) {
            this.omi.setHint(R.string.share_video_default);
        } else {
            this.omi.setHint(R.string.share_txt_default);
        }
    }

    private void dYE() {
        this.akm = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akm.getLayoutParams();
        layoutParams.topMargin -= omb;
        layoutParams.leftMargin = fYf;
        layoutParams.rightMargin = fYf;
        this.akm.setLayoutParams(layoutParams);
        this.akm.setVisibility(0);
        this.akm.a(this.ome);
        this.akm.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dYF() {
        int i = 5000;
        if (this.omn != null) {
            i = 1000;
        }
        return dYG().getText() != null && dYG().getText().length() >= i;
    }

    private void CX(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.omc)) {
                this.omc = "";
                dYG().requestFocus();
                if (dYG().getText() != null && dYG().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dYG().getSelectionStart();
                    editable = dYG().getText();
                }
            } else if ("from_title".equals(this.omc)) {
                this.omc = "";
                dYH().requestFocus();
                if (dYH().getText() != null && dYH().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dYH().getSelectionStart();
                    editable = dYH().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zG(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.noo != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.noo.getForumId(), 0L), this.noo.getFirstDir(), this.noo.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(u uVar) {
        if (((ImageSpan[]) dYG().getText().getSpans(0, dYG().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.omm == null) {
                this.omm = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.omm.getView().isShown()) {
                this.omm.cancel();
            }
            this.omm.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, uVar, dYG());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dYG() {
        return this.omi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dYH() {
        return this.noI;
    }

    protected void dYI() {
        if (dYG().getSelectionStart() > 0) {
            String substring = dYG().getText().toString().substring(0, dYG().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.iUh.matcher(substring);
            if (matcher.find()) {
                dYG().getText().delete(dYG().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dYG().getSelectionStart());
                return;
            }
            dYG().onKeyDown(67, this.iUi);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.fNE.setCancelListener(null);
        this.fNE.setTipString(R.string.sending);
        this.fNE.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.fNE.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dKh() {
        if (this.noo != null) {
            String str = "";
            String str2 = "";
            if (dYH() != null) {
                str = dYH().getText().toString();
            }
            if (dYG() != null) {
                str2 = dYG().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.noo.getType() == 0 || this.noo.getType() == 9 || this.noo.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.nop == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.noo.setIsNoTitle(true);
                        } else {
                            this.noo.setIsNoTitle(false);
                            zH(true);
                            return;
                        }
                    } else {
                        this.noo.setIsNoTitle(false);
                        zH(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.noo.setIsNoTitle(true);
                } else {
                    this.noo.setIsNoTitle(false);
                    zH(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.omy) {
                    zH(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    zH(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                zH(true);
            } else if (this.noo.getVideoInfo() != null) {
                zH(true);
            } else {
                zH(false);
            }
        }
    }

    private void zH(boolean z) {
        ap.setNavbarTitleColor(this.lWH, R.color.CAM_X0302, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.fFg = new NewWriteModel(this);
        this.fFg.b(this.fFv);
        this.iYW = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.dJZ();
            }
        };
        this.noo = new WriteData();
        if (bundle != null) {
            this.noo.setType(bundle.getInt("type", 0));
            this.noo.setForumId(bundle.getString("forum_id"));
            this.noo.setForumName(bundle.getString("forum_name"));
            this.noo.setFirstDir(bundle.getString("forum_first_dir"));
            this.noo.setSecondDir(bundle.getString("forum_second_dir"));
            this.noo.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.omn = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.noo.setIsAddition(this.omn != null);
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
            this.noo.setTitle(bundle.getString("write_title"));
            this.noo.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.jOM = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.ome = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.ShareInfo.class);
            }
            this.mBaijiahaoData = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.jfW = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.jfX = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.ogN = (FrsTabInfoData) bundle.getSerializable("tab_list");
            str = string;
        } else {
            Intent intent = getIntent();
            this.noo.setType(intent.getIntExtra("type", 0));
            this.noo.setForumId(intent.getStringExtra("forum_id"));
            this.noo.setForumName(intent.getStringExtra("forum_name"));
            this.noo.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.noo.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.noo.setThreadId(intent.getStringExtra("thread_id"));
            this.omn = (AdditionData) intent.getSerializableExtra("addition_data");
            this.noo.setIsAddition(this.omn != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.noo.setTitle(intent.getStringExtra("write_title"));
            this.noo.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.jOM = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.ome = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            this.jfW = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.jfX = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.ogN = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.noo.getType() == 4 ? 6 : 9);
        this.noo.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.ome != null && this.ome.videoId != null) {
            this.noo.setVideoId(this.ome.videoId);
            this.noo.setOriginalVideoCover(this.ome.showPicUrl);
            this.noo.setOriginalVideoTitle(this.ome.showText);
        }
        if (!au.isEmpty(this.jfW)) {
            if (!au.isEmpty(this.jfX)) {
                this.noo.setContent("//@" + this.jfX + " :" + this.jfW);
            } else {
                this.noo.setContent(this.jfW);
            }
        }
        if (this.noo != null && this.noo.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.noo.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.omf = true;
        }
        dYA();
    }

    private void dYJ() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) y.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.noI.setText(com.baidu.tbadk.plugins.b.DF(com.baidu.tbadk.plugins.b.DG(hotTopicBussinessData.mTopicName)));
            this.noI.setMovementMethod(com.baidu.tieba.view.c.dWg());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString DF = com.baidu.tbadk.plugins.b.DF(com.baidu.tbadk.plugins.b.DG(hotTopicBussinessData.mTopicName));
            if (DF != null) {
                this.noI.setText(DF);
            }
            this.omA.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.noo.getType());
        bundle.putString("forum_id", this.noo.getForumId());
        bundle.putString("forum_name", this.noo.getForumName());
        bundle.putString("forum_first_dir", this.noo.getFirstDir());
        bundle.putString("forum_second_dir", this.noo.getSecondDir());
        bundle.putString("thread_id", this.noo.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jOM);
        bundle.putSerializable("tab_list", this.ogN);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.omn != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.omn));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jOM);
        if (this.ome != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.ome));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dYG().getEditableText().toString();
        if (obj != null) {
            dYG().setText(TbFaceManager.bCR().a(getPageContext().getPageActivity(), obj, this.omG));
            dYG().setSelection(dYG().getText().length());
        }
    }

    private String dYK() {
        if (dYG() == null || dYG().getText() == null) {
            return "";
        }
        String obj = dYG().getText().toString();
        if (StringUtils.isNull(obj)) {
            if (this.ome != null && this.ome.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return obj;
    }

    private String dYL() {
        if (this.noo == null || dYH() == null || dYH().getVisibility() != 0 || dYH().getText() == null) {
            return "";
        }
        String obj = dYH().getText().toString();
        if (this.mPrefixData != null && y.getCount(this.mPrefixData.getPrefixs()) > 0 && this.nop != 0 && this.noo.getType() != 4 && this.noN != null && this.noN.getText() != null) {
            obj = this.noN.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            obj = this.mPrefixData.getImplicitTitle() + this.noo.getTitle();
        }
        if (TextUtils.isEmpty(obj)) {
            if (TextUtils.isEmpty(this.noo.getContent())) {
                return getString(R.string.share_txt_default);
            }
            if (getString(R.string.share_txt_default).equals(this.noo.getContent())) {
                return getString(R.string.share_txt_default);
            }
            if (getString(R.string.share_video_default).equals(this.noo.getContent())) {
                return getString(R.string.share_video_default);
            }
            return obj;
        }
        return obj;
    }

    private void cHe() {
        dJZ();
        this.noo.setContent(dYK());
        this.noo.setTitle(dYL());
        if (this.omt >= 0) {
            this.noo.setCategoryFrom(this.omt);
        }
        if (this.omv >= 0) {
            this.noo.setCategoryTo(this.omv);
        }
        this.noo.setWriteImagesInfo(this.writeImagesInfo);
        this.noo.setHasLocationData(this.fFf != null && this.fFf.clN());
        this.fFg.yD(this.writeImagesInfo.size() > 0);
        if (!y.isEmpty(this.mList) && this.omz != null && this.omz.mIsGlobalBlock == 0) {
            this.noo.setForumId(String.valueOf(this.omz.mForumId));
            this.noo.setForumName(this.omz.mForumName);
        }
        dYM();
        this.fFg.f(this.noo);
        this.noo.setContent(this.noo.getContent().replaceAll("\u0000\n", ""));
        this.noo.setContent(this.noo.getContent().replaceAll("\u0000", ""));
        this.noo.setVcode(null);
        this.fFg.daL().setVoice(null);
        this.fFg.daL().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.iYW);
        this.fFg.dPm();
    }

    private void dYM() {
        FrsTabItemData selectedTabItemData;
        if (this.noo != null && this.omF != null && (selectedTabItemData = this.omF.getSelectedTabItemData()) != null) {
            this.noo.setTabId(selectedTabItemData.tabId);
            this.noo.setTabName(selectedTabItemData.name);
            this.noo.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    private void Q(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.omn != null) {
                i2 = this.omn.getTotalCount();
                i = this.omn.getAlreadyCount() + 1;
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
                if (this.fCT != null && !this.fCT.bBo()) {
                    dYG().requestFocus();
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
                            dYG().getText().insert(dYG().getSelectionStart(), sb.toString());
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
                        if (this.omd) {
                            sb2.append(com.baidu.tbadk.plugins.b.fMY);
                            this.omd = false;
                        }
                        sb2.append(stringExtra);
                        CX(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !y.isEmpty(this.mList) && !y.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.omz = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.omz);
            }
        } else if (i2 == 0) {
            if (this.fCT != null && !this.fCT.bBo()) {
                this.omi.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12002:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.omD.Vo(postWriteCallBackData.getErrorString());
                        this.omD.bg(postWriteCallBackData.getSensitiveWords());
                        this.omD.b(this.noI, this.omi);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.omc)) {
                        dYH().requestFocus();
                        return;
                    } else if ("from_content".equals(this.omc)) {
                        dYG().requestFocus();
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
    public void dYN() {
        if ("1".equals(this.jOM)) {
            this.noo.setCanNoForum(true);
            this.noo.setTransmitForumData("[]");
        } else if ("2".equals(this.jOM)) {
            this.noo.setCanNoForum(false);
        }
        dYO();
        this.noo.setPrivacy(this.isPrivacy);
        this.noo.setIsShareThread(true);
        if (this.ome != null && !StringUtils.isNull(this.ome.threadId)) {
            this.noo.setOriginalThreadId(this.ome.threadId);
        }
        this.noo.setBaijiahaoData(this.mBaijiahaoData);
        if (this.ome != null) {
            this.noo.setOriBaijiahaoData(this.ome.oriUgcInfo);
        }
        this.noo.setCallFrom(this.jOM);
        cHe();
    }

    private void dYO() {
        if (this.fCT != null) {
            this.fCT.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dYH());
        HidenSoftKeyPad(this.mInputManager, dYG());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bX(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.jjA) != null) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aq("obj_locate", ay.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.noo.getType() != 7) {
                if (this.omn == null) {
                    if (!d(postWriteCallBackData)) {
                        com.baidu.tieba.tbadkCore.writeModel.g.j(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        return;
                    }
                    return;
                }
                Q(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.fFl = i;
        if (this.fCT != null) {
            this.fCT.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void dYP() {
        if (!this.omy && this.fCT != null) {
            this.fCT.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.fCT.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kZ(boolean z) {
        if (this.fCT != null) {
            this.fCT.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void LE(int i) {
        if (i < this.oml.size()) {
            for (int i2 = 0; i2 < this.oml.size(); i2++) {
                this.oml.get(i2).zy(false);
            }
            this.oml.get(i).zy(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void Jm(int i) {
        this.nop = i;
        this.noO.setCurrentIndex(i);
        LE(i);
        this.noN.setText(this.mPrefixData.getPrefixs().get(i));
        dKh();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.noO, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.noQ.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes7.dex */
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
        if (this.noo != null) {
            if (this.noo.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.noo.getType() == 5) {
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
            bBU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.bsF = z;
        if (this.omC != null && !z) {
            this.omC.cwF();
        }
        if (this.omE != null && !z) {
            dYr();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.bsF && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.omd = false;
            this.omc = "";
            if ("from_content".equals(str)) {
                this.omc = "from_content";
            } else if ("from_title".equals(str)) {
                this.omc = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.DE(String.valueOf(charSequence.charAt(i)))) {
                zG(false);
            }
        }
    }

    public void dEk() {
        if (!y.isEmpty(this.mList)) {
            this.omh.setVisibility(0);
            this.omh.requestFocus();
            return;
        }
        this.omh.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dYQ() {
        if (((ImageSpan[]) dYG().getText().getSpans(0, dYG().getText().length(), ImageSpan.class)).length > 10) {
            if (this.omm == null) {
                this.omm = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.omm.getView().isShown()) {
                this.omm.cancel();
            }
            this.omm.show();
            return true;
        }
        return false;
    }
}
