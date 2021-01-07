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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.n.a.a;
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
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes8.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0277a, i.a {
    private OriginalThreadCardView ajX;
    private EditorTools fDN;
    private LocationModel fFZ;
    private NewWriteModel fGa;
    List<ab> gOR;
    private boolean isPrivacy;
    private String jcZ;
    private String jda;
    private BaijiahaoData mBaijiahaoData;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private FrsTabInfoData nYF;
    private int ngI;
    private TextView nhe;
    private com.baidu.tieba.write.i nhf;
    private ImageView nhg;
    private View nhh;
    private String oeA;
    private int oeB;
    private PostCategoryView oeC;
    private HotTopicBussinessData oeF;
    private TextView oeG;
    private com.baidu.tieba.write.editor.b oeI;
    private g oeK;
    private ForumTabSelectedView oeL;
    private com.baidu.tieba.view.b oeS;
    private OriginalThreadInfo.ShareInfo oek;
    private LinearLayout oem;
    private LinearLayout oen;
    private View oeq;
    private Toast oes;
    private AdditionData oet;
    private RelativeLayout oeu;
    private TextView oev;
    private TextView oew;
    private TextView oex;
    ab oey;
    private int oez;
    private static final int oeh = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    private static final int fYY = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44);
    private String oei = "";
    private boolean oej = false;
    private WriteData ngH = null;
    private boolean oel = false;
    private InputMethodManager mInputManager = null;
    private EditText ngZ = null;
    private View nha = null;
    private LinearLayout nhc = null;
    private SpanGroupEditText oeo = null;
    private FeedBackModel oep = null;
    private ArrayList<WritePrefixItemLayout> oer = new ArrayList<>();
    private final KeyEvent iRl = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView lPY = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener iVZ = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout ltF = null;
    private String fGe = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int fGf = 0;
    private View mRootView = null;
    private ScrollView oeD = null;
    private boolean oeE = false;
    private com.baidu.tbadk.core.view.a fOA = null;
    private String mFrom = "write";
    private String jLR = "2";
    private SpannableStringBuilder oeH = new SpannableStringBuilder();
    private boolean bsq = false;
    private final c oeJ = new c();
    private TbFaceManager.a oeM = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan Ec(String str) {
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
    private final AntiHelper.a jgD = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", ax.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", ax.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d fGo = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.ngH != null) {
                TransmitPostEditActivity.this.oeJ.bm(null);
                if (z) {
                    TransmitPostEditActivity.this.la(z);
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
                    TransmitPostEditActivity.this.oeJ.Ve(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.oeJ.bm(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.oeJ.b(TransmitPostEditActivity.this.ngZ, TransmitPostEditActivity.this.oeo);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.d(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.d(TransmitPostEditActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(TransmitPostEditActivity.this.getActivity());
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.Bo(TransmitPostEditActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.Bo(postWriteCallBackData.getErrorString());
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
                            TiebaStatic.log(new aq("c13746").an("obj_locate", 1).an("obj_type", 1));
                        }
                    });
                    aVar.b(TransmitPostEditActivity.this.getPageContext()).btY();
                    TiebaStatic.log(new aq("c13745").an("obj_locate", 1).an("obj_type", 1));
                } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bAh());
                    if (com.baidu.tbadk.t.a.EP(ahVar.bAg())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bAg())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a fGm = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bFI() {
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
        public void a(LocationData locationData) {
            if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                TransmitPostEditActivity.this.a(2, true, locationData.getFormatted_address());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener nuf = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.fFZ.yn(false);
                    TransmitPostEditActivity.this.fFZ.gv(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.fFZ.yn(true);
                TransmitPostEditActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener oeN = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener oeO = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dZF = TransmitPostEditActivity.this.dZF();
            if (dZF >= 0 && dZF < TransmitPostEditActivity.this.oeo.getText().length()) {
                TransmitPostEditActivity.this.oeo.setSelection(dZF);
            }
        }
    };
    private boolean oeP = true;
    private final View.OnFocusChangeListener hxA = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.ngZ || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.lPY) {
                if (z) {
                    TransmitPostEditActivity.this.oeP = true;
                    TransmitPostEditActivity.this.dZG();
                    if (TransmitPostEditActivity.this.fDN != null) {
                        TransmitPostEditActivity.this.fDN.bDf();
                    }
                    l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.ngZ);
                } else if (view == TransmitPostEditActivity.this.ngZ) {
                    TransmitPostEditActivity.this.nhe.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.oeo && z) {
                TransmitPostEditActivity.this.oeP = false;
                TransmitPostEditActivity.this.dZG();
                TransmitPostEditActivity.this.fDN.bDf();
                l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.oeo);
            }
            TransmitPostEditActivity.this.dZL();
        }
    };
    private TextWatcher oeQ = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String oeU = "";
        private String oeV;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.oeV = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.oeV != null ? this.oeV.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dLy();
            TransmitPostEditActivity.this.dZM();
            EditText dZY = TransmitPostEditActivity.this.dZY();
            if (editable != null && dZY != null && dZY.getText() != null) {
                if (this.oeU == null || !this.oeU.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.oeJ != null) {
                        this.oeU = dZY.getText().toString();
                        TransmitPostEditActivity.this.oeJ.b(dZY, true);
                        return;
                    }
                    return;
                }
                dZY.setSelection(dZY.getSelectionEnd());
            }
        }
    };
    private TextWatcher oeR = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String oeV;
        private String oeW = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.oeV = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.oeV != null ? this.oeV.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dLy();
            EditText dZX = TransmitPostEditActivity.this.dZX();
            if (editable != null && dZX != null && dZX.getText() != null) {
                int selectionEnd = dZX.getSelectionEnd();
                if (this.oeW == null || !this.oeW.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.oeJ != null) {
                        this.oeW = dZX.getText().toString();
                        TransmitPostEditActivity.this.oeJ.b(dZX, false);
                        return;
                    }
                    return;
                }
                dZX.setSelection(selectionEnd);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFr() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void bFt() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bFv();
        } else if (this.fFZ.dPW()) {
            bFr();
        } else {
            this.fFZ.yn(false);
            a(1, true, (String) null);
            this.fFZ.dPU();
        }
    }

    private void bFv() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.pa(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.a(1, true, (String) null);
                    TransmitPostEditActivity.this.fFZ.dPY();
                } else {
                    TransmitPostEditActivity.this.fGm.bFI();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TransmitPostEditActivity.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.btY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dZF() {
        int selectionEnd = dZX().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dZX().getText().getSpans(0, dZX().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dZX().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dZX().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZG() {
        if (this.fDN != null) {
            this.fDN.setBarLauncherEnabled(!this.oeP);
            this.fDN.setToolEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.oeE) {
            this.ngZ.setVisibility(8);
            dLy();
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
        this.fFZ = new LocationModel(getPageContext());
        this.fFZ.a(this.fGm);
        registerListener(this.nuf);
        registerListener(this.oeN);
        dbR();
        this.oeo.requestFocus();
        dFE();
        eag();
    }

    @SuppressLint({"ResourceAsColor"})
    private void dbR() {
        this.fDN = new EditorTools(getActivity());
        this.fDN.setBarMaxLauCount(4);
        this.fDN.setMoreButtonAtEnd(true);
        this.fDN.setBarLauncherType(1);
        this.fDN.kO(true);
        this.fDN.kP(true);
        this.fDN.setBackgroundColorId(R.color.CAM_X0207);
        dZH();
        this.fDN.build();
        if (this.oem != null) {
            this.oem.addView(this.fDN);
        }
        dbr();
        this.fDN.rV();
        com.baidu.tbadk.editortools.h ss = this.fDN.ss(6);
        if (ss != null && !TextUtils.isEmpty(this.fGe)) {
            ((View) ss).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.fGe);
                }
            });
        }
        if (!this.oeE) {
            this.fDN.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.fDN.bDf();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.fDN.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.fDN.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.ngH.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.ngH.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        dZJ();
    }

    private void dZH() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.fDN.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        if (this.oet == null) {
            if (this.oeI == null) {
                this.oeI = new com.baidu.tieba.write.editor.b(getActivity(), this.jLR);
                this.oeI.dYJ();
                this.oeI.setFrom("from_share_write");
                this.oeI.bZ(this.ngH.getForumId(), this.mPrivateThread);
            }
            this.fDN.b(this.oeI);
        }
        this.fDN.bL(arrayList);
        m sv = this.fDN.sv(5);
        if (sv != null) {
            sv.fEA = 1;
        }
    }

    private void dbr() {
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
                            TiebaStatic.log(new aq("c12608").an("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.dZW()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.dZW()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof u)) {
                            TransmitPostEditActivity.this.e((u) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.dZZ();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.dLy();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.oet == null) {
                            TransmitPostEditActivity.this.bFw();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.fGf) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ad.checkLocationForGoogle(pageActivity)) {
                                    TransmitPostEditActivity.this.bFt();
                                    return;
                                } else {
                                    ad.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.bFr();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.fFZ != null) {
                            TransmitPostEditActivity.this.fFZ.yn(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        aq aqVar = new aq("c10645");
                        if (TransmitPostEditActivity.this.ngH != null) {
                            str = TransmitPostEditActivity.this.ngH.getForumId();
                        } else {
                            str = "";
                        }
                        aqVar.dX("fid", str);
                        TiebaStatic.log(aqVar);
                        if (TransmitPostEditActivity.this.ngH == null || (videoInfo = TransmitPostEditActivity.this.ngH.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.fDN.bEN()) {
                                        TransmitPostEditActivity.this.fDN.bDf();
                                        TransmitPostEditActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.ngH.setVideoInfo(null);
                        TransmitPostEditActivity.this.dLy();
                        if (TransmitPostEditActivity.this.oeo != null) {
                            TransmitPostEditActivity.this.oeo.requestFocus();
                        }
                        TransmitPostEditActivity.this.fDN.bDf();
                        TransmitPostEditActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.oeo);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.oej = true;
                        TransmitPostEditActivity.this.zq(true);
                        if (TransmitPostEditActivity.this.dZY().isFocused()) {
                            TransmitPostEditActivity.this.oei = "from_title";
                        } else if (TransmitPostEditActivity.this.dZX().isFocused()) {
                            TransmitPostEditActivity.this.oei = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.oen.setVisibility(0);
                        TransmitPostEditActivity.this.oen.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.oen.hasFocus()) {
                            TransmitPostEditActivity.this.oeo.requestFocus();
                            TransmitPostEditActivity.this.oeo.setSelection(TransmitPostEditActivity.this.oeo.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.oen.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.fDN.setActionListener(31, bVar);
        this.fDN.setActionListener(16, bVar);
        this.fDN.setActionListener(14, bVar);
        this.fDN.setActionListener(24, bVar);
        this.fDN.setActionListener(3, bVar);
        this.fDN.setActionListener(10, bVar);
        this.fDN.setActionListener(11, bVar);
        this.fDN.setActionListener(12, bVar);
        this.fDN.setActionListener(13, bVar);
        this.fDN.setActionListener(15, bVar);
        this.fDN.setActionListener(18, bVar);
        this.fDN.setActionListener(20, bVar);
        this.fDN.setActionListener(25, bVar);
        this.fDN.setActionListener(27, bVar);
        this.fDN.setActionListener(29, bVar);
        this.fDN.setActionListener(43, bVar);
        this.fDN.setActionListener(45, bVar);
        this.fDN.setActionListener(53, bVar);
        this.fDN.setActionListener(48, bVar);
        this.fDN.setActionListener(46, bVar);
        this.fDN.setActionListener(49, bVar);
        this.fDN.setActionListener(47, bVar);
        this.fDN.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFw() {
        if (this.fFZ.cou()) {
            if (this.fFZ.dPW()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.b.dPR().getLocationData().getFormatted_address());
                return;
            }
            a(1, true, (String) null);
            this.fFZ.dPU();
            return;
        }
        a(0, true, (String) null);
    }

    protected void dLq() {
        if (this.fGa != null) {
            this.fGa.cancelLoadData();
        }
        if (this.oep != null) {
            this.oep.cancelLoadData();
        }
        if (this.fFZ != null) {
            this.fFZ.cancelLoadData();
        }
    }

    private void dZI() {
        if (this.oeK != null) {
            this.oeK.hideTip();
        }
    }

    private void dZJ() {
        if (this.oeK == null) {
            this.oeK = new g(getPageContext());
        }
        this.oeK.d(this.fDN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dZI();
        TiebaPrepareImageService.StopService();
        dLq();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZK() {
        if (this.ngH == null) {
            finish();
            return;
        }
        this.ngH.setTitle(dZY().getText().toString());
        this.ngH.setContent(dZX().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.nhf != null && this.nhf.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.nhf, getPageContext().getPageActivity());
                return true;
            } else if (this.fDN.bEN()) {
                this.fDN.bDf();
                return true;
            } else {
                dLq();
                dZK();
                return true;
            }
        }
        if (i == 67 && (text = dZX().getText()) != null) {
            int selectionStart = dZX().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dZX().onKeyDown(67, this.iRl);
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
        getLayoutMode().onModeChanged(this.ltF);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ao.setViewTextColor(this.lPY, R.color.CAM_X0302, 1);
        dZG();
        ao.setBackgroundColor(this.nha, R.color.CAM_X0204);
        ao.setBackgroundColor(dZY(), R.color.CAM_X0201);
        ao.setBackgroundColor(dZX(), R.color.CAM_X0201);
        dLy();
        this.fDN.onChangeSkinType(i);
        if (this.oeC != null) {
            this.oeC.bxP();
        }
        ao.setViewTextColor(this.mName, R.color.CAM_X0105);
        dZL();
        dZM();
        if (this.oeJ != null) {
            this.oeJ.c(dZY(), dZX());
        }
        if (this.ajX != null) {
            this.ajX.onChangeSkinType();
        }
        if (this.oeL != null) {
            this.oeL.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZL() {
        if (this.ngZ.hasFocus()) {
            this.ngZ.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        } else {
            this.ngZ.setHintTextColor(ao.getColor(R.color.CAM_X0109));
        }
        if (this.oeo.hasFocus()) {
            this.oeo.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        } else {
            this.oeo.setHintTextColor(ao.getColor(R.color.CAM_X0109));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZM() {
        if (this.ngZ != null) {
            if (this.ngZ.getText().toString().length() == 0) {
                this.ngZ.getPaint().setFakeBoldText(false);
            } else if (this.ngZ.getText().toString().length() > 0) {
                this.ngZ.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.fOA = new com.baidu.tbadk.core.view.a(getPageContext());
        this.oeE = this.ngH.getType() == 4 || 5 == this.ngH.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bwr().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ao.setViewTextColor(this.mName, R.color.CAM_X0105);
        dZP();
        this.oeD = (ScrollView) findViewById(R.id.write_scrollview);
        this.oeD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.oeo != null) {
                        l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.oeo);
                    }
                    if (TransmitPostEditActivity.this.fDN != null) {
                        TransmitPostEditActivity.this.fDN.bDf();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.ltF = (RelativeLayout) findViewById(R.id.parent);
        this.oem = (LinearLayout) findViewById(R.id.tool_view);
        this.oem.setContentDescription(IStringUtil.TOP_PATH);
        this.oen = (LinearLayout) findViewById(R.id.title_view);
        this.nha = findViewById(R.id.interval_view);
        this.oeG = (TextView) findViewById(R.id.hot_topic_title_edt);
        dLx();
        if (this.oeE) {
            this.oeD.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        dLz();
        dZV();
        this.nhc = (LinearLayout) findViewById(R.id.post_content_container);
        this.nhc.setDrawingCacheEnabled(false);
        this.nhc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.oeo.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.hxA);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.dLq();
                TransmitPostEditActivity.this.dZK();
            }
        });
        dZS();
        dZU();
        dZO();
        dZG();
        dZT();
        dLw();
        eaa();
        dZN();
        if (this.ngH.getType() == 4 && this.nhh != null && this.oeq != null) {
            this.nhh.setVisibility(8);
            this.oeq.setVisibility(8);
        }
        dLy();
        ShowSoftKeyPad(this.mInputManager, this.ngZ);
    }

    private void dZN() {
        this.oeL = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.oeL.setBgColor(R.color.CAM_X0205);
        this.oeL.setData(this.nYF);
        this.oeL.setActivity(this);
    }

    private void dZO() {
        String str;
        String str2;
        if (this.ngH != null) {
            switch (this.ngH.getType()) {
                case 0:
                case 9:
                    if (this.jLR != null && this.jLR.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                    } else if (this.jLR != null && this.jLR.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.ngH.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.ngZ.setVisibility(0);
                    this.oeo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.oeo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.oeo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.ngZ.setVisibility(8);
                    return;
            }
        }
    }

    private void dZP() {
        this.lPY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lPY.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.lPY.setLayoutParams(layoutParams);
        this.lPY.setOnFocusChangeListener(this.hxA);
    }

    private void dZQ() {
        if (this.ngH != null && this.ngH.getType() == 0 && this.ngH.getType() == 9 && !this.oel && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = at.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dZY() != null) {
                dZY().setText(cutStringWithSuffix);
                dZY().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void dZR() {
        this.gOR = null;
        this.oez = -1;
        this.oeB = -1;
        com.baidu.tieba.frs.ad At = ac.cHe().At(1);
        if (At != null) {
            this.gOR = At.jjK;
            this.oez = getIntent().getIntExtra("category_id", -1);
            if (this.gOR != null && !this.gOR.isEmpty() && this.oez >= 0) {
                this.oey = new ab();
                this.oey.jjG = 0;
                this.oey.name = getPageContext().getResources().getString(R.string.category_auto);
                this.oeB = this.oey.jjG;
                this.oeA = this.oey.name;
                for (ab abVar : this.gOR) {
                    if (abVar.jjG == this.oez) {
                        this.oeB = abVar.jjG;
                        this.oeA = abVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dZS() {
        if (this.gOR != null && !this.gOR.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.oeC = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.oeC.setText(this.oeA);
            this.oeC.setCategoryContainerData(this.gOR, this.oey, this.oeB);
            this.oeC.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bc bcVar) {
                    if (bcVar != null) {
                        TransmitPostEditActivity.this.oeC.setText(bcVar.name);
                        TransmitPostEditActivity.this.ngH.setCategoryTo(bcVar.jjG);
                        TransmitPostEditActivity.this.oeB = bcVar.jjG;
                        TransmitPostEditActivity.this.oeC.dZh();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.oeC.dZg();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dZY());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dZX());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.oeS = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.oeS.setTitle(R.string.no_disturb_start_time);
        this.oeS.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.oeS);
        this.oeS.setButton(-2, getPageContext().getString(R.string.cancel), this.oeS);
        return this.oeS;
    }

    private void dZT() {
        this.oeu = (RelativeLayout) findViewById(R.id.addition_container);
        this.oev = (TextView) findViewById(R.id.addition_create_time);
        this.oew = (TextView) findViewById(R.id.addition_last_time);
        this.oex = (TextView) findViewById(R.id.addition_last_content);
        if (this.oet != null) {
            this.oeu.setVisibility(0);
            this.oev.setText(getPageContext().getString(R.string.write_addition_create) + at.getFormatTime(this.oet.getCreateTime() * 1000));
            if (this.oet.getAlreadyCount() == 0) {
                this.oew.setVisibility(8);
            } else {
                this.oew.setText(getPageContext().getString(R.string.write_addition_last) + at.getFormatTime(this.oet.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.oet.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.oex.setText(lastAdditionContent);
            } else {
                this.oex.setVisibility(8);
            }
            dZX().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.oet.getAlreadyCount()), Integer.valueOf(this.oet.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.oeu.setVisibility(8);
    }

    private void dLw() {
        this.nhh = findViewById(R.id.post_prefix_layout);
        this.nhe = (TextView) findViewById(R.id.post_prefix);
        this.oeq = findViewById(R.id.prefix_divider);
        this.nhg = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.nhh.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.ngI = 1;
            this.nhh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.nhe.setVisibility(0);
                    TransmitPostEditActivity.this.nhh.setSelected(true);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.nhf, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.fDN.bDf();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.ngZ);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.oeo);
                }
            });
            this.nhg = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.nhg.setVisibility(0);
                this.nhe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.nhe.setSelected(true);
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.nhf, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.fDN.bDf();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dZY());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dZX());
                    }
                });
            }
            this.nhf = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.nhf.a(this);
            this.nhf.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.nhf.setOutsideTouchable(true);
            this.nhf.setFocusable(true);
            this.nhf.setOnDismissListener(this);
            this.nhf.setBackgroundDrawable(ao.getDrawable(R.color.CAM_X0201));
            int color = ao.getColor(R.color.CAM_X0105);
            int color2 = ao.getColor(R.color.CAM_X0108);
            ao.setBackgroundResource(this.nhe, R.color.CAM_X0201);
            ao.setImageResource(this.nhg, R.drawable.icon_frs_arrow_n);
            this.nhe.setTextColor(color);
            this.oer.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.oer.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.nhf.addView(writePrefixItemLayout);
            }
            this.nhf.setCurrentIndex(0);
            this.nhe.setText(prefixs.get(1));
            MM(1);
            return;
        }
        this.nhh.setVisibility(8);
    }

    protected void dZU() {
        this.lPY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick() && !TransmitPostEditActivity.this.eah()) {
                    if (TransmitPostEditActivity.this.oeJ.a(TransmitPostEditActivity.this.ngZ, TransmitPostEditActivity.this.oeo)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.oeJ.dXV());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dZY());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dZX());
                    TransmitPostEditActivity.this.fDN.bDf();
                    TiebaStatic.log(new aq("c12608").an("obj_locate", 7));
                    TransmitPostEditActivity.this.eae();
                }
            }
        });
    }

    protected void dLx() {
        this.ngZ = (EditText) findViewById(R.id.post_title);
        this.ngZ.setOnClickListener(this.oeO);
        this.ngZ.setOnFocusChangeListener(this.hxA);
        if ((this.ngH.getType() == 0 || this.ngH.getType() == 9 || this.ngH.getType() == 7) && this.ngH.getTitle() != null) {
            this.ngZ.setText(this.ngH.getTitle());
            this.ngZ.setSelection(this.ngH.getTitle().length());
        }
        this.ngZ.addTextChangedListener(this.oeQ);
        if (!this.ngH.getHaveDraft()) {
            dZQ();
        }
        this.ngZ.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void dLz() {
        this.oeo = (SpanGroupEditText) findViewById(R.id.post_content);
        this.oeo.setDrawingCacheEnabled(false);
        this.oeo.setOnClickListener(this.oeO);
        if (this.fGa != null) {
            this.fGa.setSpanGroupManager(this.oeo.getSpanGroupManager());
        }
        if (this.ngH != null) {
            this.ngH.setSpanGroupManager(this.oeo.getSpanGroupManager());
        }
        if (this.ngH.getContent() != null && this.ngH.getContent().length() > 0) {
            this.oeo.setText(TbFaceManager.bGp().aE(getPageContext().getPageActivity(), this.ngH.getContent()));
            this.oeo.setSelection(this.oeo.getText().length());
        }
        if (!at.isEmpty(this.jcZ)) {
            this.oeo.setSelection(0);
        }
        this.oeo.setOnFocusChangeListener(this.hxA);
        this.oeo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.oeo.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.oeo.addTextChangedListener(this.oeR);
        if (this.oek != null && this.oek.showType == 3) {
            this.oeo.setHint(R.string.share_video_default);
        } else {
            this.oeo.setHint(R.string.share_txt_default);
        }
    }

    private void dZV() {
        this.ajX = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajX.getLayoutParams();
        layoutParams.topMargin -= oeh;
        layoutParams.leftMargin = fYY;
        layoutParams.rightMargin = fYY;
        this.ajX.setLayoutParams(layoutParams);
        this.ajX.setVisibility(0);
        this.ajX.a(this.oek);
        this.ajX.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dZW() {
        int i = 5000;
        if (this.oet != null) {
            i = 1000;
        }
        return dZX().getText() != null && dZX().getText().length() >= i;
    }

    private void DM(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.oei)) {
                this.oei = "";
                dZX().requestFocus();
                if (dZX().getText() != null && dZX().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dZX().getSelectionStart();
                    editable = dZX().getText();
                }
            } else if ("from_title".equals(this.oei)) {
                this.oei = "";
                dZY().requestFocus();
                if (dZY().getText() != null && dZY().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dZY().getSelectionStart();
                    editable = dZY().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zq(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.ngH != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.ngH.getForumId(), 0L), this.ngH.getFirstDir(), this.ngH.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(u uVar) {
        if (((ImageSpan[]) dZX().getText().getSpans(0, dZX().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.oes == null) {
                this.oes = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.oes.getView().isShown()) {
                this.oes.cancel();
            }
            this.oes.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, uVar, dZX());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dZX() {
        return this.oeo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dZY() {
        return this.ngZ;
    }

    protected void dZZ() {
        if (dZX().getSelectionStart() > 0) {
            String substring = dZX().getText().toString().substring(0, dZX().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.iRk.matcher(substring);
            if (matcher.find()) {
                dZX().getText().delete(dZX().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dZX().getSelectionStart());
                return;
            }
            dZX().onKeyDown(67, this.iRl);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.fOA.setCancelListener(null);
        this.fOA.setTipString(R.string.sending);
        this.fOA.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.fOA.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLy() {
        if (this.ngH != null) {
            String str = "";
            String str2 = "";
            if (dZY() != null) {
                str = dZY().getText().toString();
            }
            if (dZX() != null) {
                str2 = dZX().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.ngH.getType() == 0 || this.ngH.getType() == 9 || this.ngH.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.ngI == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.ngH.setIsNoTitle(true);
                        } else {
                            this.ngH.setIsNoTitle(false);
                            zr(true);
                            return;
                        }
                    } else {
                        this.ngH.setIsNoTitle(false);
                        zr(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.ngH.setIsNoTitle(true);
                } else {
                    this.ngH.setIsNoTitle(false);
                    zr(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.oeE) {
                    zr(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    zr(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                zr(true);
            } else if (this.ngH.getVideoInfo() != null) {
                zr(true);
            } else {
                zr(false);
            }
        }
    }

    private void zr(boolean z) {
        ao.setNavbarTitleColor(this.lPY, R.color.CAM_X0302, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.fGa = new NewWriteModel(this);
        this.fGa.b(this.fGo);
        this.iVZ = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.dLq();
            }
        };
        this.ngH = new WriteData();
        if (bundle != null) {
            this.ngH.setType(bundle.getInt("type", 0));
            this.ngH.setForumId(bundle.getString("forum_id"));
            this.ngH.setForumName(bundle.getString("forum_name"));
            this.ngH.setFirstDir(bundle.getString("forum_first_dir"));
            this.ngH.setSecondDir(bundle.getString("forum_second_dir"));
            this.ngH.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.oet = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.ngH.setIsAddition(this.oet != null);
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
            this.ngH.setTitle(bundle.getString("write_title"));
            this.ngH.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.jLR = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.oek = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.ShareInfo.class);
            }
            this.mBaijiahaoData = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.jcZ = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.jda = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.nYF = (FrsTabInfoData) bundle.getSerializable("tab_list");
            str = string;
        } else {
            Intent intent = getIntent();
            this.ngH.setType(intent.getIntExtra("type", 0));
            this.ngH.setForumId(intent.getStringExtra("forum_id"));
            this.ngH.setForumName(intent.getStringExtra("forum_name"));
            this.ngH.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.ngH.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.ngH.setThreadId(intent.getStringExtra("thread_id"));
            this.oet = (AdditionData) intent.getSerializableExtra("addition_data");
            this.ngH.setIsAddition(this.oet != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.ngH.setTitle(intent.getStringExtra("write_title"));
            this.ngH.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.jLR = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.oek = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            this.jcZ = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.jda = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.nYF = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.ngH.getType() == 4 ? 6 : 9);
        this.ngH.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.oek != null && this.oek.videoId != null) {
            this.ngH.setVideoId(this.oek.videoId);
            this.ngH.setOriginalVideoCover(this.oek.showPicUrl);
            this.ngH.setOriginalVideoTitle(this.oek.showText);
        }
        if (!at.isEmpty(this.jcZ)) {
            if (!at.isEmpty(this.jda)) {
                this.ngH.setContent("//@" + this.jda + " :" + this.jcZ);
            } else {
                this.ngH.setContent(this.jcZ);
            }
        }
        if (this.ngH != null && this.ngH.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.ngH.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.oel = true;
        }
        dZR();
    }

    private void eaa() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) x.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.ngZ.setText(com.baidu.tbadk.plugins.b.Eu(com.baidu.tbadk.plugins.b.Ev(hotTopicBussinessData.mTopicName)));
            this.ngZ.setMovementMethod(com.baidu.tieba.view.c.dXw());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString Eu = com.baidu.tbadk.plugins.b.Eu(com.baidu.tbadk.plugins.b.Ev(hotTopicBussinessData.mTopicName));
            if (Eu != null) {
                this.ngZ.setText(Eu);
            }
            this.oeG.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.ngH.getType());
        bundle.putString("forum_id", this.ngH.getForumId());
        bundle.putString("forum_name", this.ngH.getForumName());
        bundle.putString("forum_first_dir", this.ngH.getFirstDir());
        bundle.putString("forum_second_dir", this.ngH.getSecondDir());
        bundle.putString("thread_id", this.ngH.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jLR);
        bundle.putSerializable("tab_list", this.nYF);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.oet != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.oet));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jLR);
        if (this.oek != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.oek));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dZX().getEditableText().toString();
        if (obj != null) {
            dZX().setText(TbFaceManager.bGp().a(getPageContext().getPageActivity(), obj, this.oeM));
            dZX().setSelection(dZX().getText().length());
        }
    }

    private String eab() {
        if (dZX() == null || dZX().getText() == null) {
            return "";
        }
        String obj = dZX().getText().toString();
        if (StringUtils.isNull(obj)) {
            if (this.oek != null && this.oek.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return obj;
    }

    private String eac() {
        if (this.ngH == null || dZY() == null || dZY().getVisibility() != 0 || dZY().getText() == null) {
            return "";
        }
        String obj = dZY().getText().toString();
        if (this.mPrefixData != null && x.getCount(this.mPrefixData.getPrefixs()) > 0 && this.ngI != 0 && this.ngH.getType() != 4 && this.nhe != null && this.nhe.getText() != null) {
            obj = this.nhe.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            obj = this.mPrefixData.getImplicitTitle() + this.ngH.getTitle();
        }
        if (TextUtils.isEmpty(obj)) {
            if (TextUtils.isEmpty(this.ngH.getContent())) {
                return getString(R.string.share_txt_default);
            }
            if (getString(R.string.share_txt_default).equals(this.ngH.getContent())) {
                return getString(R.string.share_txt_default);
            }
            if (getString(R.string.share_video_default).equals(this.ngH.getContent())) {
                return getString(R.string.share_video_default);
            }
            return obj;
        }
        return obj;
    }

    private void cJw() {
        dLq();
        this.ngH.setContent(eab());
        this.ngH.setTitle(eac());
        if (this.oez >= 0) {
            this.ngH.setCategoryFrom(this.oez);
        }
        if (this.oeB >= 0) {
            this.ngH.setCategoryTo(this.oeB);
        }
        this.ngH.setWriteImagesInfo(this.writeImagesInfo);
        this.ngH.setHasLocationData(this.fFZ != null && this.fFZ.cou());
        this.fGa.yp(this.writeImagesInfo.size() > 0);
        if (!x.isEmpty(this.mList) && this.oeF != null && this.oeF.mIsGlobalBlock == 0) {
            this.ngH.setForumId(String.valueOf(this.oeF.mForumId));
            this.ngH.setForumName(this.oeF.mForumName);
        }
        ead();
        this.fGa.f(this.ngH);
        this.ngH.setContent(this.ngH.getContent().replaceAll("\u0000\n", ""));
        this.ngH.setContent(this.ngH.getContent().replaceAll("\u0000", ""));
        this.ngH.setVcode(null);
        this.fGa.dcp().setVoice(null);
        this.fGa.dcp().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.iVZ);
        this.fGa.dQC();
    }

    private void ead() {
        FrsTabItemData selectedTabItemData;
        if (this.ngH != null && this.oeL != null && (selectedTabItemData = this.oeL.getSelectedTabItemData()) != null) {
            this.ngH.setTabId(selectedTabItemData.tabId);
            this.ngH.setTabName(selectedTabItemData.name);
            this.ngH.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    private void I(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.oet != null) {
                i2 = this.oet.getTotalCount();
                i = this.oet.getAlreadyCount() + 1;
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
                if (this.fDN != null && !this.fDN.bEN()) {
                    dZX().requestFocus();
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
                            dZX().getText().insert(dZX().getSelectionStart(), sb.toString());
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
                        if (this.oej) {
                            sb2.append(com.baidu.tbadk.plugins.b.fNU);
                            this.oej = false;
                        }
                        sb2.append(stringExtra);
                        DM(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !x.isEmpty(this.mList) && !x.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.oeF = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.oeF);
            }
        } else if (i2 == 0) {
            if (this.fDN != null && !this.fDN.bEN()) {
                this.oeo.requestFocus();
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
                        this.oeJ.Ve(postWriteCallBackData.getErrorString());
                        this.oeJ.bm(postWriteCallBackData.getSensitiveWords());
                        this.oeJ.b(this.ngZ, this.oeo);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.oei)) {
                        dZY().requestFocus();
                        return;
                    } else if ("from_content".equals(this.oei)) {
                        dZX().requestFocus();
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
    public void eae() {
        if ("1".equals(this.jLR)) {
            this.ngH.setCanNoForum(true);
            this.ngH.setTransmitForumData("[]");
        } else if ("2".equals(this.jLR)) {
            this.ngH.setCanNoForum(false);
        }
        eaf();
        this.ngH.setPrivacy(this.isPrivacy);
        this.ngH.setIsShareThread(true);
        if (this.oek != null && !StringUtils.isNull(this.oek.threadId)) {
            this.ngH.setOriginalThreadId(this.oek.threadId);
        }
        this.ngH.setBaijiahaoData(this.mBaijiahaoData);
        if (this.oek != null) {
            this.ngH.setOriBaijiahaoData(this.oek.oriUgcInfo);
        }
        this.ngH.setCallFrom(this.jLR);
        cJw();
    }

    private void eaf() {
        if (this.fDN != null) {
            this.fDN.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dZY());
        HidenSoftKeyPad(this.mInputManager, dZX());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bP(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.jgD) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).an("obj_locate", ax.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.ngH.getType() != 7) {
                if (this.oet == null) {
                    if (!d(postWriteCallBackData)) {
                        com.baidu.tieba.tbadkCore.writeModel.g.i(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        return;
                    }
                    return;
                }
                I(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.fGf = i;
        if (this.fDN != null) {
            this.fDN.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void eag() {
        if (!this.oeE && this.fDN != null) {
            this.fDN.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.fDN.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la(boolean z) {
        if (this.fDN != null) {
            this.fDN.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void MM(int i) {
        if (i < this.oer.size()) {
            for (int i2 = 0; i2 < this.oer.size(); i2++) {
                this.oer.get(i2).zh(false);
            }
            this.oer.get(i).zh(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void Kv(int i) {
        this.ngI = i;
        this.nhf.setCurrentIndex(i);
        MM(i);
        this.nhe.setText(this.mPrefixData.getPrefixs().get(i));
        dLy();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.nhf, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.nhh.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes8.dex */
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
        if (this.ngH != null) {
            if (this.ngH.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.ngH.getType() == 5) {
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
            bFt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.bsq = z;
        if (this.oeI != null && !z) {
            this.oeI.cyY();
        }
        if (this.oeK != null && !z) {
            dZI();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.bsq && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.oej = false;
            this.oei = "";
            if ("from_content".equals(str)) {
                this.oei = "from_content";
            } else if ("from_title".equals(str)) {
                this.oei = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.Et(String.valueOf(charSequence.charAt(i)))) {
                zq(false);
            }
        }
    }

    public void dFE() {
        if (!x.isEmpty(this.mList)) {
            this.oen.setVisibility(0);
            this.oen.requestFocus();
            return;
        }
        this.oen.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eah() {
        if (((ImageSpan[]) dZX().getText().getSpans(0, dZX().getText().length(), ImageSpan.class)).length > 10) {
            if (this.oes == null) {
                this.oes = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.oes.getView().isShown()) {
                this.oes.cancel();
            }
            this.oes.show();
            return true;
        }
        return false;
    }
}
