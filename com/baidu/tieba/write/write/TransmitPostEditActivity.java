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
import com.baidu.android.common.others.IStringUtil;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.n.a.a;
import com.baidu.searchbox.ugc.model.UgcConstant;
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
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.b.c.b;
import com.baidu.tieba.write.i;
import com.baidu.tieba.write.upload.ForwardUploadData;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.tieba.write.view.PostCategoryView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
/* loaded from: classes3.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0276a, i.a {
    private OriginalThreadCardView ajl;
    private EditorTools fuh;
    private LocationModel fwt;
    private NewWriteModel fwu;
    List<ae> gDd;
    private String iQL;
    private String iQM;
    private boolean isPrivacy;
    private BaijiahaoData mBaijiahaoData;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private FrsTabInfoData nVj;
    private ForumTabSelectedView nZC;
    private com.baidu.tieba.write.i nbA;
    private ImageView nbB;
    private View nbC;
    private int nbd;
    private TextView nbz;
    private OriginalThreadInfo.ShareInfo obY;
    private com.baidu.tieba.view.b ocG;
    private LinearLayout oca;
    private LinearLayout ocb;
    private View oce;
    private Toast ocg;
    private AdditionData och;
    private RelativeLayout oci;
    private TextView ocj;
    private TextView ock;
    private TextView ocl;
    ae ocm;
    private int ocn;
    private String oco;
    private int ocp;
    private PostCategoryView ocq;
    private HotTopicBussinessData ocu;
    private TextView ocv;
    private com.baidu.tieba.write.editor.b ocx;
    private g ocz;
    private static final int obV = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    private static final int fPv = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44);
    private String obW = "";
    private boolean obX = false;
    private WriteData nbc = null;
    private boolean obZ = false;
    private InputMethodManager mInputManager = null;
    private EditText nbu = null;
    private View nbv = null;
    private LinearLayout nbx = null;
    private SpanGroupEditText occ = null;
    private FeedBackModel ocd = null;
    private ArrayList<WritePrefixItemLayout> ocf = new ArrayList<>();
    private final KeyEvent iEX = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView lKK = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener iJM = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout kjE = null;
    private String fwy = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int fwz = 0;
    private View mRootView = null;
    private ScrollView ocs = null;
    private boolean oct = false;
    private com.baidu.tbadk.core.view.a fEW = null;
    private String mFrom = "write";
    private String jzq = "2";
    private SpannableStringBuilder ocw = new SpannableStringBuilder();
    private boolean bqA = false;
    private final c ocy = new c();
    private boolean nZg = false;
    private TbFaceManager.a ocA = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan Eg(String str) {
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
    private final AntiHelper.a iUq = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ay.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ay.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d fwI = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.nbc != null) {
                TransmitPostEditActivity.this.ocy.bn(null);
                if (z) {
                    TransmitPostEditActivity.this.kE(z);
                    TransmitPostEditActivity.this.c(true, postWriteCallBackData);
                    TransmitPostEditActivity.this.m(postWriteCallBackData);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    TransmitPostEditActivity.this.setResult(-1, intent);
                    TransmitPostEditActivity.this.finish();
                } else if (postWriteCallBackData.isSensitiveError()) {
                    TransmitPostEditActivity.this.showToast(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.ocy.VA(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.ocy.bn(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.ocy.b(TransmitPostEditActivity.this.nbu, TransmitPostEditActivity.this.occ);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.d(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.d(TransmitPostEditActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(TransmitPostEditActivity.this.getActivity());
                    if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.Bq(TransmitPostEditActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.Bq(postWriteCallBackData.getErrorString());
                    }
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(TransmitPostEditActivity.this.getActivity(), 0, 26, 1)));
                            TiebaStatic.log(new ar("c13746").al("obj_locate", 1).al("obj_type", 1));
                        }
                    });
                    aVar.b(TransmitPostEditActivity.this.getPageContext()).brv();
                    TiebaStatic.log(new ar("c13745").al("obj_locate", 1).al("obj_type", 1));
                } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bxM());
                    if (com.baidu.tbadk.t.a.ES(ahVar.bxL())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bxL())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a fwG = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bDm() {
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
    private final CustomMessageListener nou = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.fwt.yi(false);
                    TransmitPostEditActivity.this.fwt.gy(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.fwt.yi(true);
                TransmitPostEditActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener ocB = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener ocC = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int eau = TransmitPostEditActivity.this.eau();
            if (eau >= 0 && eau < TransmitPostEditActivity.this.occ.getText().length()) {
                TransmitPostEditActivity.this.occ.setSelection(eau);
            }
        }
    };
    private boolean ocD = true;
    private final View.OnFocusChangeListener hlD = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.nbu || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.lKK) {
                if (z) {
                    TransmitPostEditActivity.this.ocD = true;
                    TransmitPostEditActivity.this.eav();
                    if (TransmitPostEditActivity.this.fuh != null) {
                        TransmitPostEditActivity.this.fuh.bAK();
                    }
                    com.baidu.adp.lib.util.l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.nbu);
                } else if (view == TransmitPostEditActivity.this.nbu) {
                    TransmitPostEditActivity.this.nbz.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.occ && z) {
                TransmitPostEditActivity.this.ocD = false;
                TransmitPostEditActivity.this.eav();
                TransmitPostEditActivity.this.fuh.bAK();
                com.baidu.adp.lib.util.l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.occ);
            }
            TransmitPostEditActivity.this.eaA();
        }
    };
    private TextWatcher ocE = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String ocI = "";
        private String ocJ;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.ocJ = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.ocJ != null ? this.ocJ.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dLF();
            TransmitPostEditActivity.this.eaB();
            EditText eaN = TransmitPostEditActivity.this.eaN();
            if (editable != null && eaN != null && eaN.getText() != null) {
                if (this.ocI == null || !this.ocI.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.ocy != null) {
                        this.ocI = eaN.getText().toString();
                        TransmitPostEditActivity.this.ocy.b(eaN, true);
                        return;
                    }
                    return;
                }
                eaN.setSelection(eaN.getSelectionEnd());
            }
        }
    };
    private TextWatcher ocF = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String ocJ;
        private String ocK = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.ocJ = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.ocJ != null ? this.ocJ.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dLF();
            EditText eaM = TransmitPostEditActivity.this.eaM();
            if (editable != null && eaM != null && eaM.getText() != null) {
                int selectionEnd = eaM.getSelectionEnd();
                if (this.ocK == null || !this.ocK.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.ocy != null) {
                        this.ocK = eaM.getText().toString();
                        TransmitPostEditActivity.this.ocy.b(eaM, false);
                        return;
                    }
                    return;
                }
                eaM.setSelection(selectionEnd);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void m(PostWriteCallBackData postWriteCallBackData) {
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
    public void bCV() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void bCX() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bCZ();
        } else if (this.fwt.dPY()) {
            bCV();
        } else {
            this.fwt.yi(false);
            a(1, true, (String) null);
            this.fwt.dPW();
        }
    }

    private void bCZ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.oQ(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.a(1, true, (String) null);
                    TransmitPostEditActivity.this.fwt.dQa();
                } else {
                    TransmitPostEditActivity.this.fwG.bDm();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TransmitPostEditActivity.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.brv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eau() {
        int selectionEnd = eaM().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) eaM().getText().getSpans(0, eaM().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = eaM().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = eaM().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eav() {
        if (this.fuh != null) {
            this.fuh.setBarLauncherEnabled(!this.ocD);
            this.fuh.setToolEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.oct) {
            this.nbu.setVisibility(8);
            dLF();
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
        this.fwt = new LocationModel(getPageContext());
        this.fwt.a(this.fwG);
        registerListener(this.nou);
        registerListener(this.ocB);
        dci();
        this.occ.requestFocus();
        dFN();
        eaU();
    }

    @SuppressLint({"ResourceAsColor"})
    private void dci() {
        this.fuh = new EditorTools(getActivity());
        this.fuh.setBarMaxLauCount(4);
        this.fuh.setMoreButtonAtEnd(true);
        this.fuh.setBarLauncherType(1);
        this.fuh.ks(true);
        this.fuh.kt(true);
        this.fuh.setBackgroundColorId(R.color.CAM_X0207);
        eaw();
        this.fuh.build();
        if (this.nZg) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        }
        if (this.oca != null) {
            this.oca.addView(this.fuh);
        }
        dbL();
        this.fuh.su();
        com.baidu.tbadk.editortools.h sg = this.fuh.sg(6);
        if (sg != null && !TextUtils.isEmpty(this.fwy)) {
            ((View) sg).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.fwy);
                }
            });
        }
        if (!this.oct) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.fuh.bAK();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.nbc.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.nbc.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        if (!this.nZg) {
            eay();
        }
    }

    private void eaw() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.fuh.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        if (!this.nZg && this.och == null) {
            if (this.ocx == null) {
                this.ocx = new com.baidu.tieba.write.editor.b(getActivity(), this.jzq);
                this.ocx.dZa();
                this.ocx.setFrom("from_share_write");
                this.ocx.bS(this.nbc.getForumId(), this.mPrivateThread);
            }
            this.fuh.b(this.ocx);
        }
        this.fuh.bE(arrayList);
        com.baidu.tbadk.editortools.m sj = this.fuh.sj(5);
        if (sj != null) {
            sj.fuU = 1;
            if (this.nZg) {
                sj.kv(false);
            }
        }
    }

    private void dbL() {
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
                            TiebaStatic.log(new ar("c12608").al("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.eaL()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.eaL()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof u)) {
                            TransmitPostEditActivity.this.e((u) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.eaO();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.dLF();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.och == null) {
                            TransmitPostEditActivity.this.bDa();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.fwz) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (com.baidu.tbadk.core.util.ae.checkLocationForGoogle(pageActivity)) {
                                    TransmitPostEditActivity.this.bCX();
                                    return;
                                } else {
                                    com.baidu.tbadk.core.util.ae.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.bCV();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.fwt != null) {
                            TransmitPostEditActivity.this.fwt.yi(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        ar arVar = new ar("c10645");
                        if (TransmitPostEditActivity.this.nbc != null) {
                            str = TransmitPostEditActivity.this.nbc.getForumId();
                        } else {
                            str = "";
                        }
                        arVar.dY("fid", str);
                        TiebaStatic.log(arVar);
                        if (TransmitPostEditActivity.this.nbc == null || (videoInfo = TransmitPostEditActivity.this.nbc.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.fuh.bCr()) {
                                        TransmitPostEditActivity.this.fuh.bAK();
                                        TransmitPostEditActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.nbc.setVideoInfo(null);
                        TransmitPostEditActivity.this.dLF();
                        if (TransmitPostEditActivity.this.occ != null) {
                            TransmitPostEditActivity.this.occ.requestFocus();
                        }
                        TransmitPostEditActivity.this.fuh.bAK();
                        TransmitPostEditActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.occ);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.obX = true;
                        TransmitPostEditActivity.this.zt(true);
                        if (TransmitPostEditActivity.this.eaN().isFocused()) {
                            TransmitPostEditActivity.this.obW = "from_title";
                        } else if (TransmitPostEditActivity.this.eaM().isFocused()) {
                            TransmitPostEditActivity.this.obW = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.ocb.setVisibility(0);
                        TransmitPostEditActivity.this.ocb.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.ocb.hasFocus()) {
                            TransmitPostEditActivity.this.occ.requestFocus();
                            TransmitPostEditActivity.this.occ.setSelection(TransmitPostEditActivity.this.occ.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.ocb.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.fuh.setActionListener(31, bVar);
        this.fuh.setActionListener(16, bVar);
        this.fuh.setActionListener(14, bVar);
        this.fuh.setActionListener(24, bVar);
        this.fuh.setActionListener(3, bVar);
        this.fuh.setActionListener(10, bVar);
        this.fuh.setActionListener(11, bVar);
        this.fuh.setActionListener(12, bVar);
        this.fuh.setActionListener(13, bVar);
        this.fuh.setActionListener(15, bVar);
        this.fuh.setActionListener(18, bVar);
        this.fuh.setActionListener(20, bVar);
        this.fuh.setActionListener(25, bVar);
        this.fuh.setActionListener(27, bVar);
        this.fuh.setActionListener(29, bVar);
        this.fuh.setActionListener(43, bVar);
        this.fuh.setActionListener(45, bVar);
        this.fuh.setActionListener(53, bVar);
        this.fuh.setActionListener(48, bVar);
        this.fuh.setActionListener(46, bVar);
        this.fuh.setActionListener(49, bVar);
        this.fuh.setActionListener(47, bVar);
        this.fuh.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDa() {
        if (this.fwt.clB()) {
            if (this.fwt.dPY()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.b.dPT().getLocationData().getFormatted_address());
                return;
            }
            a(1, true, (String) null);
            this.fwt.dPW();
            return;
        }
        a(0, true, (String) null);
    }

    protected void dLx() {
        if (this.fwu != null) {
            this.fwu.cancelLoadData();
        }
        if (this.ocd != null) {
            this.ocd.cancelLoadData();
        }
        if (this.fwt != null) {
            this.fwt.cancelLoadData();
        }
    }

    private void eax() {
        if (this.ocz != null) {
            this.ocz.hideTip();
        }
    }

    private void eay() {
        if (this.ocz == null) {
            this.ocz = new g(getPageContext());
        }
        this.ocz.d(this.fuh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        eax();
        TiebaPrepareImageService.StopService();
        dLx();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaz() {
        if (this.nbc == null) {
            finish();
            return;
        }
        this.nbc.setTitle(eaN().getText().toString());
        this.nbc.setContent(eaM().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.nbA != null && this.nbA.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.nbA, getPageContext().getPageActivity());
                return true;
            } else if (this.fuh.bCr()) {
                this.fuh.bAK();
                return true;
            } else {
                dLx();
                eaz();
                return true;
            }
        }
        if (i == 67 && (text = eaM().getText()) != null) {
            int selectionStart = eaM().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                eaM().onKeyDown(67, this.iEX);
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
        getLayoutMode().onModeChanged(this.kjE);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.lKK, R.color.CAM_X0302, 1);
        eav();
        ap.setBackgroundColor(this.nbv, R.color.CAM_X0204);
        ap.setBackgroundColor(eaN(), R.color.CAM_X0201);
        ap.setBackgroundColor(eaM(), R.color.CAM_X0201);
        dLF();
        this.fuh.onChangeSkinType(i);
        if (this.ocq != null) {
            this.ocq.bvt();
        }
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        eaA();
        eaB();
        if (this.ocy != null) {
            this.ocy.c(eaN(), eaM());
        }
        if (this.ajl != null) {
            this.ajl.onChangeSkinType();
        }
        if (this.nZC != null) {
            this.nZC.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaA() {
        if (this.nbu.hasFocus()) {
            this.nbu.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        } else {
            this.nbu.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        }
        if (this.occ.hasFocus()) {
            this.occ.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        } else {
            this.occ.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaB() {
        if (this.nbu != null) {
            if (this.nbu.getText().toString().length() == 0) {
                this.nbu.getPaint().setFakeBoldText(false);
            } else if (this.nbu.getText().toString().length() > 0) {
                this.nbu.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.fEW = new com.baidu.tbadk.core.view.a(getPageContext());
        this.oct = this.nbc.getType() == 4 || 5 == this.nbc.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.btW().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        eaE();
        this.ocs = (ScrollView) findViewById(R.id.write_scrollview);
        this.ocs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.occ != null) {
                        com.baidu.adp.lib.util.l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.occ);
                    }
                    if (TransmitPostEditActivity.this.fuh != null) {
                        TransmitPostEditActivity.this.fuh.bAK();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.kjE = (RelativeLayout) findViewById(R.id.parent);
        this.oca = (LinearLayout) findViewById(R.id.tool_view);
        this.oca.setContentDescription(IStringUtil.TOP_PATH);
        this.ocb = (LinearLayout) findViewById(R.id.title_view);
        this.nbv = findViewById(R.id.interval_view);
        this.ocv = (TextView) findViewById(R.id.hot_topic_title_edt);
        dLE();
        if (this.oct) {
            this.ocs.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        dLG();
        eaK();
        this.nbx = (LinearLayout) findViewById(R.id.post_content_container);
        this.nbx.setDrawingCacheEnabled(false);
        this.nbx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.occ.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.hlD);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.dLx();
                TransmitPostEditActivity.this.eaz();
            }
        });
        eaH();
        eaJ();
        eaD();
        eav();
        eaI();
        dLD();
        eaP();
        eaC();
        if (this.nbc.getType() == 4 && this.nbC != null && this.oce != null) {
            this.nbC.setVisibility(8);
            this.oce.setVisibility(8);
        }
        dLF();
        ShowSoftKeyPad(this.mInputManager, this.nbu);
    }

    private void eaC() {
        this.nZC = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.nZC.setBgColor(R.color.CAM_X0205);
        this.nZC.setData(this.nVj);
        this.nZC.setActivity(this);
    }

    private void eaD() {
        String str;
        String str2;
        if (this.nbc != null) {
            switch (this.nbc.getType()) {
                case 0:
                case 9:
                    if (this.jzq != null && this.jzq.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                        if (this.nZg) {
                            this.mName.setText(R.string.transmit_to_dynamic_title);
                        }
                    } else if (this.jzq != null && this.jzq.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.nbc.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.nbu.setVisibility(0);
                    this.occ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.occ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.occ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.nbu.setVisibility(8);
                    return;
            }
        }
    }

    private void eaE() {
        if (this.nZg) {
            this.lKK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.dynamic_publish));
        } else {
            this.lKK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lKK.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.lKK.setLayoutParams(layoutParams);
        this.lKK.setOnFocusChangeListener(this.hlD);
    }

    private void eaF() {
        if (this.nbc != null && this.nbc.getType() == 0 && this.nbc.getType() == 9 && !this.obZ && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = au.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && eaN() != null) {
                eaN().setText(cutStringWithSuffix);
                eaN().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void eaG() {
        this.gDd = null;
        this.ocn = -1;
        this.ocp = -1;
        ag Ah = af.cEh().Ah(1);
        if (Ah != null) {
            this.gDd = Ah.iXv;
            this.ocn = getIntent().getIntExtra("category_id", -1);
            if (this.gDd != null && !this.gDd.isEmpty() && this.ocn >= 0) {
                this.ocm = new ae();
                this.ocm.iXr = 0;
                this.ocm.name = getPageContext().getResources().getString(R.string.category_auto);
                this.ocp = this.ocm.iXr;
                this.oco = this.ocm.name;
                for (ae aeVar : this.gDd) {
                    if (aeVar.iXr == this.ocn) {
                        this.ocp = aeVar.iXr;
                        this.oco = aeVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void eaH() {
        if (this.gDd != null && !this.gDd.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.ocq = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.ocq.setText(this.oco);
            this.ocq.setCategoryContainerData(this.gDd, this.ocm, this.ocp);
            this.ocq.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bf bfVar) {
                    if (bfVar != null) {
                        TransmitPostEditActivity.this.ocq.setText(bfVar.name);
                        TransmitPostEditActivity.this.nbc.setCategoryTo(bfVar.iXr);
                        TransmitPostEditActivity.this.ocp = bfVar.iXr;
                        TransmitPostEditActivity.this.ocq.dZW();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.ocq.dZV();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.eaN());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.eaM());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.ocG = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.ocG.setTitle(R.string.no_disturb_start_time);
        this.ocG.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.ocG);
        this.ocG.setButton(-2, getPageContext().getString(R.string.cancel), this.ocG);
        return this.ocG;
    }

    private void eaI() {
        this.oci = (RelativeLayout) findViewById(R.id.addition_container);
        this.ocj = (TextView) findViewById(R.id.addition_create_time);
        this.ock = (TextView) findViewById(R.id.addition_last_time);
        this.ocl = (TextView) findViewById(R.id.addition_last_content);
        if (this.och != null) {
            this.oci.setVisibility(0);
            this.ocj.setText(getPageContext().getString(R.string.write_addition_create) + au.getFormatTime(this.och.getCreateTime() * 1000));
            if (this.och.getAlreadyCount() == 0) {
                this.ock.setVisibility(8);
            } else {
                this.ock.setText(getPageContext().getString(R.string.write_addition_last) + au.getFormatTime(this.och.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.och.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.ocl.setText(lastAdditionContent);
            } else {
                this.ocl.setVisibility(8);
            }
            eaM().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.och.getAlreadyCount()), Integer.valueOf(this.och.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.oci.setVisibility(8);
    }

    private void dLD() {
        this.nbC = findViewById(R.id.post_prefix_layout);
        this.nbz = (TextView) findViewById(R.id.post_prefix);
        this.oce = findViewById(R.id.prefix_divider);
        this.nbB = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.nbC.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.nbd = 1;
            this.nbC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.nbz.setVisibility(0);
                    TransmitPostEditActivity.this.nbC.setSelected(true);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.nbA, view, 0, com.baidu.adp.lib.util.l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.fuh.bAK();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.nbu);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.occ);
                }
            });
            this.nbB = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.nbB.setVisibility(0);
                this.nbz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.nbz.setSelected(true);
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.nbA, view, 0, com.baidu.adp.lib.util.l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.fuh.bAK();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.eaN());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.eaM());
                    }
                });
            }
            this.nbA = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.nbA.a(this);
            this.nbA.setMaxHeight(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds510));
            this.nbA.setOutsideTouchable(true);
            this.nbA.setFocusable(true);
            this.nbA.setOnDismissListener(this);
            this.nbA.setBackgroundDrawable(ap.getDrawable(R.color.CAM_X0201));
            int color = ap.getColor(R.color.CAM_X0105);
            int color2 = ap.getColor(R.color.CAM_X0108);
            ap.setBackgroundResource(this.nbz, R.color.CAM_X0201);
            ap.setImageResource(this.nbB, R.drawable.icon_frs_arrow_n);
            this.nbz.setTextColor(color);
            this.ocf.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.ocf.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.nbA.addView(writePrefixItemLayout);
            }
            this.nbA.setCurrentIndex(0);
            this.nbz.setText(prefixs.get(1));
            Na(1);
            return;
        }
        this.nbC.setVisibility(8);
    }

    protected void eaJ() {
        this.lKK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick() && !TransmitPostEditActivity.this.eaV()) {
                    if (TransmitPostEditActivity.this.ocy.a(TransmitPostEditActivity.this.nbu, TransmitPostEditActivity.this.occ)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.ocy.dYq());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.eaN());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.eaM());
                    TransmitPostEditActivity.this.fuh.bAK();
                    TiebaStatic.log(new ar("c12608").al("obj_locate", 7));
                    TransmitPostEditActivity.this.eaS();
                }
            }
        });
    }

    protected void dLE() {
        this.nbu = (EditText) findViewById(R.id.post_title);
        this.nbu.setOnClickListener(this.ocC);
        this.nbu.setOnFocusChangeListener(this.hlD);
        if ((this.nbc.getType() == 0 || this.nbc.getType() == 9 || this.nbc.getType() == 7) && this.nbc.getTitle() != null) {
            this.nbu.setText(this.nbc.getTitle());
            this.nbu.setSelection(this.nbc.getTitle().length());
        }
        this.nbu.addTextChangedListener(this.ocE);
        if (!this.nbc.getHaveDraft()) {
            eaF();
        }
        this.nbu.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void dLG() {
        this.occ = (SpanGroupEditText) findViewById(R.id.post_content);
        this.occ.setDrawingCacheEnabled(false);
        this.occ.setOnClickListener(this.ocC);
        this.occ.setTransLink(!this.nZg);
        if (this.fwu != null) {
            this.fwu.setSpanGroupManager(this.occ.getSpanGroupManager());
        }
        if (this.nbc != null) {
            this.nbc.setSpanGroupManager(this.occ.getSpanGroupManager());
        }
        if (this.nbc.getContent() != null && this.nbc.getContent().length() > 0) {
            this.occ.setText(TbFaceManager.bDU().aw(getPageContext().getPageActivity(), this.nbc.getContent()));
            this.occ.setSelection(this.occ.getText().length());
        }
        if (!au.isEmpty(this.iQL)) {
            this.occ.setSelection(0);
        }
        this.occ.setOnFocusChangeListener(this.hlD);
        this.occ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.occ.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.occ.addTextChangedListener(this.ocF);
        if (this.nZg) {
            this.occ.setHint(R.string.dynamic_transmit_publish_edit_str);
        } else if (this.obY != null && this.obY.showType == 3) {
            this.occ.setHint(R.string.share_video_default);
        } else {
            this.occ.setHint(R.string.share_txt_default);
        }
    }

    private void eaK() {
        this.ajl = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajl.getLayoutParams();
        layoutParams.topMargin -= obV;
        layoutParams.leftMargin = fPv;
        layoutParams.rightMargin = fPv;
        this.ajl.setLayoutParams(layoutParams);
        this.ajl.setVisibility(0);
        this.ajl.a(this.obY);
        this.ajl.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eaL() {
        int i = 5000;
        if (this.och != null) {
            i = 1000;
        }
        return eaM().getText() != null && eaM().getText().length() >= i;
    }

    private void DQ(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.obW)) {
                this.obW = "";
                eaM().requestFocus();
                if (eaM().getText() != null && eaM().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = eaM().getSelectionStart();
                    editable = eaM().getText();
                }
            } else if ("from_title".equals(this.obW)) {
                this.obW = "";
                eaN().requestFocus();
                if (eaN().getText() != null && eaN().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = eaN().getSelectionStart();
                    editable = eaN().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zt(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.nbc != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.nbc.getForumId(), 0L), this.nbc.getFirstDir(), this.nbc.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(u uVar) {
        if (((ImageSpan[]) eaM().getText().getSpans(0, eaM().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.ocg == null) {
                this.ocg = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.ocg.getView().isShown()) {
                this.ocg.cancel();
            }
            this.ocg.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, uVar, eaM());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText eaM() {
        return this.occ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText eaN() {
        return this.nbu;
    }

    protected void eaO() {
        if (eaM().getSelectionStart() > 0) {
            String substring = eaM().getText().toString().substring(0, eaM().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.iEW.matcher(substring);
            if (matcher.find()) {
                eaM().getText().delete(eaM().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), eaM().getSelectionStart());
                return;
            }
            eaM().onKeyDown(67, this.iEX);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.fEW.setCancelListener(null);
        this.fEW.setTipString(R.string.sending);
        this.fEW.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.fEW.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLF() {
        if (this.nbc != null) {
            String str = "";
            String str2 = "";
            if (eaN() != null) {
                str = eaN().getText().toString();
            }
            if (eaM() != null) {
                str2 = eaM().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.nbc.getType() == 0 || this.nbc.getType() == 9 || this.nbc.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.nbd == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.nbc.setIsNoTitle(true);
                        } else {
                            this.nbc.setIsNoTitle(false);
                            zu(true);
                            return;
                        }
                    } else {
                        this.nbc.setIsNoTitle(false);
                        zu(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.nbc.setIsNoTitle(true);
                } else {
                    this.nbc.setIsNoTitle(false);
                    zu(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.oct) {
                    zu(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    zu(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                zu(true);
            } else if (this.nbc.getVideoInfo() != null) {
                zu(true);
            } else {
                zu(false);
            }
        }
    }

    private void zu(boolean z) {
        ap.setNavbarTitleColor(this.lKK, R.color.CAM_X0302, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.fwu = new NewWriteModel(this);
        this.fwu.b(this.fwI);
        this.iJM = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.dLx();
            }
        };
        this.nbc = new WriteData();
        if (bundle != null) {
            this.nbc.setType(bundle.getInt("type", 0));
            this.nbc.setForumId(bundle.getString("forum_id"));
            this.nbc.setForumName(bundle.getString("forum_name"));
            this.nbc.setFirstDir(bundle.getString("forum_first_dir"));
            this.nbc.setSecondDir(bundle.getString("forum_second_dir"));
            this.nbc.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.och = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.nbc.setIsAddition(this.och != null);
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
            this.nbc.setTitle(bundle.getString("write_title"));
            this.nbc.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.jzq = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.obY = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.ShareInfo.class);
            }
            this.mBaijiahaoData = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.iQL = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.iQM = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.nVj = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.nbc.mDynamicForwardData = (ForwardUploadData) bundle.getSerializable(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA);
            str = string;
        } else {
            Intent intent = getIntent();
            this.nbc.setType(intent.getIntExtra("type", 0));
            this.nbc.setForumId(intent.getStringExtra("forum_id"));
            this.nbc.setForumName(intent.getStringExtra("forum_name"));
            this.nbc.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.nbc.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.nbc.setThreadId(intent.getStringExtra("thread_id"));
            this.och = (AdditionData) intent.getSerializableExtra("addition_data");
            this.nbc.setIsAddition(this.och != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.nbc.setTitle(intent.getStringExtra("write_title"));
            this.nbc.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.jzq = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.obY = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            this.nbc.mDynamicForwardData = (ForwardUploadData) intent.getSerializableExtra(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA);
            this.iQL = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.iQM = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.nVj = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (this.nbc.mDynamicForwardData != null) {
            this.nZg = true;
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.nbc.getType() == 4 ? 6 : 9);
        this.nbc.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.obY != null && this.obY.videoId != null) {
            this.nbc.setVideoId(this.obY.videoId);
            this.nbc.setOriginalVideoCover(this.obY.showPicUrl);
            this.nbc.setOriginalVideoTitle(this.obY.showText);
        }
        if (!au.isEmpty(this.iQL)) {
            if (!au.isEmpty(this.iQM)) {
                this.nbc.setContent("//@" + this.iQM + " :" + this.iQL);
            } else {
                this.nbc.setContent(this.iQL);
            }
        }
        if (this.nbc != null && this.nbc.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.nbc.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.obZ = true;
        }
        eaG();
    }

    private void eaP() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) y.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.nbu.setText(com.baidu.tbadk.plugins.b.Ey(com.baidu.tbadk.plugins.b.Ez(hotTopicBussinessData.mTopicName)));
            this.nbu.setMovementMethod(com.baidu.tieba.view.c.dXR());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString Ey = com.baidu.tbadk.plugins.b.Ey(com.baidu.tbadk.plugins.b.Ez(hotTopicBussinessData.mTopicName));
            if (Ey != null) {
                this.nbu.setText(Ey);
            }
            this.ocv.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.nbc.getType());
        bundle.putString("forum_id", this.nbc.getForumId());
        bundle.putString("forum_name", this.nbc.getForumName());
        bundle.putString("forum_first_dir", this.nbc.getFirstDir());
        bundle.putString("forum_second_dir", this.nbc.getSecondDir());
        bundle.putString("thread_id", this.nbc.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jzq);
        bundle.putSerializable("tab_list", this.nVj);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.och != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.och));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jzq);
        if (this.nbc.mDynamicForwardData != null) {
            bundle.putSerializable(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA, this.nbc.mDynamicForwardData);
        }
        if (this.obY != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.obY));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = eaM().getEditableText().toString();
        if (obj != null) {
            eaM().setText(TbFaceManager.bDU().a(getPageContext().getPageActivity(), obj, this.ocA));
            eaM().setSelection(eaM().getText().length());
        }
    }

    private String eaQ() {
        if (eaM() == null || eaM().getText() == null) {
            return "";
        }
        String obj = eaM().getText().toString();
        if (StringUtils.isNull(obj)) {
            if (this.obY != null && this.obY.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return obj;
    }

    private String eaR() {
        if (this.nbc == null || eaN() == null || eaN().getVisibility() != 0 || eaN().getText() == null) {
            return "";
        }
        String obj = eaN().getText().toString();
        if (this.mPrefixData != null && y.getCount(this.mPrefixData.getPrefixs()) > 0 && this.nbd != 0 && this.nbc.getType() != 4 && this.nbz != null && this.nbz.getText() != null) {
            obj = this.nbz.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            obj = this.mPrefixData.getImplicitTitle() + this.nbc.getTitle();
        }
        if (TextUtils.isEmpty(obj)) {
            if (TextUtils.isEmpty(this.nbc.getContent())) {
                return getString(R.string.share_txt_default);
            }
            if (getString(R.string.share_txt_default).equals(this.nbc.getContent())) {
                return getString(R.string.share_txt_default);
            }
            if (getString(R.string.share_video_default).equals(this.nbc.getContent())) {
                return getString(R.string.share_video_default);
            }
            return obj;
        }
        return obj;
    }

    private void cGv() {
        if (this.nbc != null && this.nbc.mDynamicForwardData != null) {
            dZD();
            return;
        }
        dLx();
        this.nbc.setContent(eaQ());
        this.nbc.setTitle(eaR());
        if (this.ocn >= 0) {
            this.nbc.setCategoryFrom(this.ocn);
        }
        if (this.ocp >= 0) {
            this.nbc.setCategoryTo(this.ocp);
        }
        this.nbc.setWriteImagesInfo(this.writeImagesInfo);
        this.nbc.setHasLocationData(this.fwt != null && this.fwt.clB());
        this.fwu.yk(this.writeImagesInfo.size() > 0);
        if (!y.isEmpty(this.mList) && this.ocu != null && this.ocu.mIsGlobalBlock == 0) {
            this.nbc.setForumId(String.valueOf(this.ocu.mForumId));
            this.nbc.setForumName(this.ocu.mForumName);
        }
        dZE();
        this.fwu.e(this.nbc);
        this.nbc.setContent(this.nbc.getContent().replaceAll("\u0000\n", ""));
        this.nbc.setContent(this.nbc.getContent().replaceAll("\u0000", ""));
        this.nbc.setVcode(null);
        this.fwu.dcD().setVoice(null);
        this.fwu.dcD().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.iJM);
        this.fwu.dQD();
    }

    private void dZE() {
        FrsTabItemData selectedTabItemData;
        if (this.nbc != null && this.nZC != null && (selectedTabItemData = this.nZC.getSelectedTabItemData()) != null) {
            this.nbc.setTabId(selectedTabItemData.tabId);
            this.nbc.setTabName(selectedTabItemData.name);
            this.nbc.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    private void dZD() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        this.nbc.mDynamicForwardData.forward_content = eaQ();
        this.nbc.mDynamicForwardData.inputText = eaQ();
        this.nbc.mDynamicForwardData.locationPoiId = "0";
        showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
        com.baidu.tieba.write.b.c.b.dZm().a(this.nbc.mDynamicForwardData, new b.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // com.baidu.tieba.write.b.c.b.a
            public void onSuccess(String str) {
                TransmitPostEditActivity.this.closeLoadingDialog();
                com.baidu.tieba.tbadkCore.writeModel.c.h(TransmitPostEditActivity.this.getPageContext().getPageActivity(), null, null, null);
                TransmitPostEditActivity.this.kE(true);
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
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
            }
        });
    }

    private void I(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.och != null) {
                i2 = this.och.getTotalCount();
                i = this.och.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(R.string.write_addition_left_count), Integer.valueOf(i2 - i)));
            }
        }
        com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), sb.toString());
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
                if (this.fuh != null && !this.fuh.bCr()) {
                    eaM().requestFocus();
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
                            eaM().getText().insert(eaM().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                m((intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data"));
                setResult(-1, intent);
                finish();
            } else if (i == 25004) {
                if (intent != null) {
                    String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                    if (!StringUtils.isNull(stringExtra)) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.obX) {
                            sb2.append(com.baidu.tbadk.plugins.b.fEp);
                            this.obX = false;
                        }
                        sb2.append(stringExtra);
                        DQ(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !y.isEmpty(this.mList) && !y.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.ocu = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.ocu);
            }
        } else if (i2 == 0) {
            if (this.fuh != null && !this.fuh.bCr()) {
                this.occ.requestFocus();
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
                        this.ocy.VA(postWriteCallBackData.getErrorString());
                        this.ocy.bn(postWriteCallBackData.getSensitiveWords());
                        this.ocy.b(this.nbu, this.occ);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.obW)) {
                        eaN().requestFocus();
                        return;
                    } else if ("from_content".equals(this.obW)) {
                        eaM().requestFocus();
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
    public void eaS() {
        if ("1".equals(this.jzq)) {
            this.nbc.setCanNoForum(true);
            this.nbc.setTransmitForumData("[]");
        } else if ("2".equals(this.jzq)) {
            this.nbc.setCanNoForum(false);
        }
        eaT();
        this.nbc.setPrivacy(this.isPrivacy);
        this.nbc.setIsShareThread(true);
        if (this.obY != null && !StringUtils.isNull(this.obY.threadId)) {
            this.nbc.setOriginalThreadId(this.obY.threadId);
        }
        this.nbc.setBaijiahaoData(this.mBaijiahaoData);
        if (this.obY != null) {
            this.nbc.setOriBaijiahaoData(this.obY.oriUgcInfo);
        }
        this.nbc.setCallFrom(this.jzq);
        cGv();
    }

    private void eaT() {
        if (this.fuh != null) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, eaN());
        HidenSoftKeyPad(this.mInputManager, eaM());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bP(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.iUq) != null) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ay.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.nbc.getType() != 7) {
                if (this.och == null) {
                    if (!d(postWriteCallBackData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.h(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
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
        this.fwz = i;
        if (this.fuh != null) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void eaU() {
        if (!this.oct && this.fuh != null) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.fuh.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kE(boolean z) {
        if (this.fuh != null) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Na(int i) {
        if (i < this.ocf.size()) {
            for (int i2 = 0; i2 < this.ocf.size(); i2++) {
                this.ocf.get(i2).zg(false);
            }
            this.ocf.get(i).zg(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void KA(int i) {
        this.nbd = i;
        this.nbA.setCurrentIndex(i);
        Na(i);
        this.nbz.setText(this.mPrefixData.getPrefixs().get(i));
        dLF();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.nbA, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.nbC.setSelected(false);
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
            com.baidu.adp.lib.util.l.hideSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.nbc != null) {
            if (this.nbc.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.nbc.getType() == 5) {
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
            bCX();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.bqA = z;
        if (this.ocx != null && !z) {
            this.ocx.cwd();
        }
        if (this.ocz != null && !z) {
            eax();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.bqA && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.obX = false;
            this.obW = "";
            if ("from_content".equals(str)) {
                this.obW = "from_content";
            } else if ("from_title".equals(str)) {
                this.obW = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.Ex(String.valueOf(charSequence.charAt(i)))) {
                zt(false);
            }
        }
    }

    public void dFN() {
        if (!y.isEmpty(this.mList)) {
            this.ocb.setVisibility(0);
            this.ocb.requestFocus();
            return;
        }
        this.ocb.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eaV() {
        if (((ImageSpan[]) eaM().getText().getSpans(0, eaM().getText().length(), ImageSpan.class)).length > 10) {
            if (this.ocg == null) {
                this.ocg = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.ocg.getView().isShown()) {
                this.ocg.cancel();
            }
            this.ocg.show();
            return true;
        }
        return false;
    }
}
