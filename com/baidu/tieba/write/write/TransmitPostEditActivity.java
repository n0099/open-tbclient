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
import com.baidu.m.a.a;
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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
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
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0224a, i.a {
    private OriginalThreadCardView aii;
    private EditorTools eZf;
    private LocationModel fbq;
    private NewWriteModel fbr;
    List<af> geX;
    private String imL;
    private String imM;
    private boolean isPrivacy;
    private BaijiahaoData mBaijiahaoData;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private int mtB;
    private TextView mtX;
    private com.baidu.tieba.write.i mtY;
    private ImageView mtZ;
    private View mua;
    private FrsTabInfoData nnh;
    private ForumTabSelectedView nrC;
    private OriginalThreadInfo.ShareInfo ntL;
    private LinearLayout ntN;
    private LinearLayout ntO;
    private View ntR;
    private Toast ntT;
    private AdditionData ntU;
    private RelativeLayout ntV;
    private TextView ntW;
    private TextView ntX;
    private TextView ntY;
    af ntZ;
    private int nua;
    private String nub;
    private int nuc;
    private PostCategoryView nud;
    private HotTopicBussinessData nug;
    private TextView nuh;
    private com.baidu.tieba.write.editor.b nuj;
    private g nul;
    private com.baidu.tieba.view.b nut;
    private static final int iWg = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    private static final int ftT = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44);
    private String ntJ = "";
    private boolean ntK = false;
    private WriteData mtA = null;
    private boolean ntM = false;
    private InputMethodManager mInputManager = null;
    private EditText mtS = null;
    private View mtT = null;
    private LinearLayout mtV = null;
    private SpanGroupEditText ntP = null;
    private FeedBackModel ntQ = null;
    private ArrayList<WritePrefixItemLayout> ntS = new ArrayList<>();
    private final KeyEvent iaS = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView leh = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener ifK = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout jCT = null;
    private String fbv = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int fbw = 0;
    private View mRootView = null;
    private ScrollView nue = null;
    private boolean nuf = false;
    private com.baidu.tbadk.core.view.a fjB = null;
    private String mFrom = "write";
    private String iSJ = "2";
    private SpannableStringBuilder nui = new SpannableStringBuilder();
    private boolean bkk = false;
    private final c nuk = new c();
    private boolean nrg = false;
    private TbFaceManager.a nun = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan Ds(String str) {
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
    private final AntiHelper.a iqr = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aj("obj_locate", ax.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aj("obj_locate", ax.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d fbF = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mtA != null) {
                TransmitPostEditActivity.this.nuk.bh(null);
                if (z) {
                    TransmitPostEditActivity.this.jQ(z);
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
                    TransmitPostEditActivity.this.nuk.TK(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.nuk.bh(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.nuk.b(TransmitPostEditActivity.this.mtS, TransmitPostEditActivity.this.ntP);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.c(TransmitPostEditActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(TransmitPostEditActivity.this.getActivity());
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.AH(TransmitPostEditActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.AH(postWriteCallBackData.getErrorString());
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
                            TiebaStatic.log(new aq("c13746").aj("obj_locate", 1).aj("obj_type", 1));
                        }
                    });
                    aVar.b(TransmitPostEditActivity.this.getPageContext()).bkJ();
                    TiebaStatic.log(new aq("c13745").aj("obj_locate", 1).aj("obj_type", 1));
                } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bqD());
                    if (com.baidu.tbadk.t.a.DX(ahVar.bqC())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bqC())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a fbD = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bwe() {
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
    private final CustomMessageListener mGK = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.fbq.wW(false);
                    TransmitPostEditActivity.this.fbq.go(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.fbq.wW(true);
                TransmitPostEditActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener nuo = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener nup = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.eZf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dPr = TransmitPostEditActivity.this.dPr();
            if (dPr >= 0 && dPr < TransmitPostEditActivity.this.ntP.getText().length()) {
                TransmitPostEditActivity.this.ntP.setSelection(dPr);
            }
        }
    };
    private boolean nuq = true;
    private final View.OnFocusChangeListener gKu = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.mtS || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.leh) {
                if (z) {
                    TransmitPostEditActivity.this.nuq = true;
                    TransmitPostEditActivity.this.dPs();
                    if (TransmitPostEditActivity.this.eZf != null) {
                        TransmitPostEditActivity.this.eZf.btC();
                    }
                    com.baidu.adp.lib.util.l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.mtS);
                } else if (view == TransmitPostEditActivity.this.mtS) {
                    TransmitPostEditActivity.this.mtX.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.ntP && z) {
                TransmitPostEditActivity.this.nuq = false;
                TransmitPostEditActivity.this.dPs();
                TransmitPostEditActivity.this.eZf.btC();
                com.baidu.adp.lib.util.l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.ntP);
            }
            TransmitPostEditActivity.this.dPx();
        }
    };
    private TextWatcher nur = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String nuv = "";
        private String nuw;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.nuw = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.nuw != null ? this.nuw.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dAQ();
            TransmitPostEditActivity.this.dPy();
            EditText dPK = TransmitPostEditActivity.this.dPK();
            if (editable != null && dPK != null && dPK.getText() != null) {
                if (this.nuv == null || !this.nuv.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.nuk != null) {
                        this.nuv = dPK.getText().toString();
                        TransmitPostEditActivity.this.nuk.b(dPK, true);
                        return;
                    }
                    return;
                }
                dPK.setSelection(dPK.getSelectionEnd());
            }
        }
    };
    private TextWatcher nus = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String nuw;
        private String nux = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.nuw = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.nuw != null ? this.nuw.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dAQ();
            EditText dPJ = TransmitPostEditActivity.this.dPJ();
            if (editable != null && dPJ != null && dPJ.getText() != null) {
                int selectionEnd = dPJ.getSelectionEnd();
                if (this.nux == null || !this.nux.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.nuk != null) {
                        this.nux = dPJ.getText().toString();
                        TransmitPostEditActivity.this.nuk.b(dPJ, false);
                        return;
                    }
                    return;
                }
                dPJ.setSelection(selectionEnd);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void m(PostWriteCallBackData postWriteCallBackData) {
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
    public void bvN() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void bvP() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bvR();
        } else if (this.fbq.dEX()) {
            bvN();
        } else {
            this.fbq.wW(false);
            a(1, true, (String) null);
            this.fbq.dEV();
        }
    }

    private void bvR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ob(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.a(1, true, (String) null);
                    TransmitPostEditActivity.this.fbq.dEZ();
                } else {
                    TransmitPostEditActivity.this.fbD.bwe();
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
        aVar.bkJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dPr() {
        int selectionEnd = dPJ().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dPJ().getText().getSpans(0, dPJ().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dPJ().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dPJ().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPs() {
        if (this.eZf != null) {
            this.eZf.setBarLauncherEnabled(!this.nuq);
            this.eZf.setToolEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nuf) {
            this.mtS.setVisibility(8);
            dAQ();
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
        this.fbq = new LocationModel(getPageContext());
        this.fbq.a(this.fbD);
        registerListener(this.mGK);
        registerListener(this.nuo);
        cRT();
        this.ntP.requestFocus();
        dvq();
        dPR();
    }

    @SuppressLint({"ResourceAsColor"})
    private void cRT() {
        this.eZf = new EditorTools(getActivity());
        this.eZf.setBarMaxLauCount(4);
        this.eZf.setMoreButtonAtEnd(true);
        this.eZf.setBarLauncherType(1);
        this.eZf.jF(true);
        this.eZf.jG(true);
        this.eZf.setBackgroundColorId(R.color.cp_bg_line_h);
        dPt();
        this.eZf.build();
        if (this.nrg) {
            this.eZf.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        }
        if (this.ntN != null) {
            this.ntN.addView(this.eZf);
        }
        cRl();
        this.eZf.display();
        com.baidu.tbadk.editortools.h qM = this.eZf.qM(6);
        if (qM != null && !TextUtils.isEmpty(this.fbv)) {
            ((View) qM).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.fbv);
                }
            });
        }
        if (!this.nuf) {
            this.eZf.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.eZf.btC();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.eZf.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.eZf.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mtA.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mtA.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        if (!this.nrg) {
            dPv();
        }
    }

    private void dPt() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.eZf.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        if (!this.nrg && this.ntU == null) {
            if (this.nuj == null) {
                this.nuj = new com.baidu.tieba.write.editor.b(getActivity(), this.iSJ);
                this.nuj.dNZ();
                this.nuj.setFrom("from_share_write");
                this.nuj.bN(this.mtA.getForumId(), this.mPrivateThread);
            }
            this.eZf.b(this.nuj);
        }
        this.eZf.bj(arrayList);
        com.baidu.tbadk.editortools.m qP = this.eZf.qP(5);
        if (qP != null) {
            qP.eZS = 1;
            if (this.nrg) {
                qP.jI(false);
            }
        }
    }

    private void cRl() {
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
                            TiebaStatic.log(new aq("c12608").aj("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.dPI()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.dPI()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof u)) {
                            TransmitPostEditActivity.this.e((u) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.dPL();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.dAQ();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.ntU == null) {
                            TransmitPostEditActivity.this.bvS();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.fbw) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ae.checkLocationForGoogle(pageActivity)) {
                                    TransmitPostEditActivity.this.bvP();
                                    return;
                                } else {
                                    ae.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.bvN();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.fbq != null) {
                            TransmitPostEditActivity.this.fbq.wW(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        aq aqVar = new aq("c10645");
                        if (TransmitPostEditActivity.this.mtA != null) {
                            str = TransmitPostEditActivity.this.mtA.getForumId();
                        } else {
                            str = "";
                        }
                        aqVar.dK("fid", str);
                        TiebaStatic.log(aqVar);
                        if (TransmitPostEditActivity.this.mtA == null || (videoInfo = TransmitPostEditActivity.this.mtA.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.eZf.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.eZf.bvj()) {
                                        TransmitPostEditActivity.this.eZf.btC();
                                        TransmitPostEditActivity.this.eZf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.eZf.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.eZf.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.eZf.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.eZf.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mtA.setVideoInfo(null);
                        TransmitPostEditActivity.this.dAQ();
                        if (TransmitPostEditActivity.this.ntP != null) {
                            TransmitPostEditActivity.this.ntP.requestFocus();
                        }
                        TransmitPostEditActivity.this.eZf.btC();
                        TransmitPostEditActivity.this.eZf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.ntP);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.eZf.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.ntK = true;
                        TransmitPostEditActivity.this.yh(true);
                        if (TransmitPostEditActivity.this.dPK().isFocused()) {
                            TransmitPostEditActivity.this.ntJ = "from_title";
                        } else if (TransmitPostEditActivity.this.dPJ().isFocused()) {
                            TransmitPostEditActivity.this.ntJ = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.ntO.setVisibility(0);
                        TransmitPostEditActivity.this.ntO.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.ntO.hasFocus()) {
                            TransmitPostEditActivity.this.ntP.requestFocus();
                            TransmitPostEditActivity.this.ntP.setSelection(TransmitPostEditActivity.this.ntP.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.ntO.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.eZf.setActionListener(31, bVar);
        this.eZf.setActionListener(16, bVar);
        this.eZf.setActionListener(14, bVar);
        this.eZf.setActionListener(24, bVar);
        this.eZf.setActionListener(3, bVar);
        this.eZf.setActionListener(10, bVar);
        this.eZf.setActionListener(11, bVar);
        this.eZf.setActionListener(12, bVar);
        this.eZf.setActionListener(13, bVar);
        this.eZf.setActionListener(15, bVar);
        this.eZf.setActionListener(18, bVar);
        this.eZf.setActionListener(20, bVar);
        this.eZf.setActionListener(25, bVar);
        this.eZf.setActionListener(27, bVar);
        this.eZf.setActionListener(29, bVar);
        this.eZf.setActionListener(43, bVar);
        this.eZf.setActionListener(45, bVar);
        this.eZf.setActionListener(53, bVar);
        this.eZf.setActionListener(48, bVar);
        this.eZf.setActionListener(46, bVar);
        this.eZf.setActionListener(49, bVar);
        this.eZf.setActionListener(47, bVar);
        this.eZf.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvS() {
        if (this.fbq.ccF()) {
            if (this.fbq.dEX()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.b.dES().getLocationData().getFormatted_address());
                return;
            }
            a(1, true, (String) null);
            this.fbq.dEV();
            return;
        }
        a(0, true, (String) null);
    }

    protected void dAI() {
        if (this.fbr != null) {
            this.fbr.cancelLoadData();
        }
        if (this.ntQ != null) {
            this.ntQ.cancelLoadData();
        }
        if (this.fbq != null) {
            this.fbq.cancelLoadData();
        }
    }

    private void dPu() {
        if (this.nul != null) {
            this.nul.hideTip();
        }
    }

    private void dPv() {
        if (this.nul == null) {
            this.nul = new g(getPageContext());
        }
        this.nul.d(this.eZf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dPu();
        TiebaPrepareImageService.StopService();
        dAI();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPw() {
        if (this.mtA == null) {
            finish();
            return;
        }
        this.mtA.setTitle(dPK().getText().toString());
        this.mtA.setContent(dPJ().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.mtY != null && this.mtY.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mtY, getPageContext().getPageActivity());
                return true;
            } else if (this.eZf.bvj()) {
                this.eZf.btC();
                return true;
            } else {
                dAI();
                dPw();
                return true;
            }
        }
        if (i == 67 && (text = dPJ().getText()) != null) {
            int selectionStart = dPJ().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dPJ().onKeyDown(67, this.iaS);
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
        getLayoutMode().onModeChanged(this.jCT);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.leh, R.color.cp_link_tip_a, 1);
        dPs();
        ap.setBackgroundColor(this.mtT, R.color.cp_bg_line_c);
        ap.setBackgroundColor(dPK(), R.color.cp_bg_line_d);
        ap.setBackgroundColor(dPJ(), R.color.cp_bg_line_d);
        dAQ();
        this.eZf.onChangeSkinType(i);
        if (this.nud != null) {
            this.nud.bok();
        }
        ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        dPx();
        dPy();
        if (this.nuk != null) {
            this.nuk.c(dPK(), dPJ());
        }
        if (this.aii != null) {
            this.aii.onChangeSkinType();
        }
        if (this.nrC != null) {
            this.nrC.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPx() {
        if (this.mtS.hasFocus()) {
            this.mtS.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        } else {
            this.mtS.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        }
        if (this.ntP.hasFocus()) {
            this.ntP.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        } else {
            this.ntP.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPy() {
        if (this.mtS != null) {
            if (this.mtS.getText().toString().length() == 0) {
                this.mtS.getPaint().setFakeBoldText(false);
            } else if (this.mtS.getText().toString().length() > 0) {
                this.mtS.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.fjB = new com.baidu.tbadk.core.view.a(getPageContext());
        this.nuf = this.mtA.getType() == 4 || 5 == this.mtA.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bmU().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        dPB();
        this.nue = (ScrollView) findViewById(R.id.write_scrollview);
        this.nue.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.ntP != null) {
                        com.baidu.adp.lib.util.l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.ntP);
                    }
                    if (TransmitPostEditActivity.this.eZf != null) {
                        TransmitPostEditActivity.this.eZf.btC();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jCT = (RelativeLayout) findViewById(R.id.parent);
        this.ntN = (LinearLayout) findViewById(R.id.tool_view);
        this.ntN.setContentDescription(IStringUtil.TOP_PATH);
        this.ntO = (LinearLayout) findViewById(R.id.title_view);
        this.mtT = findViewById(R.id.interval_view);
        this.nuh = (TextView) findViewById(R.id.hot_topic_title_edt);
        dAP();
        if (this.nuf) {
            this.nue.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        dAR();
        dPH();
        this.mtV = (LinearLayout) findViewById(R.id.post_content_container);
        this.mtV.setDrawingCacheEnabled(false);
        this.mtV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.eZf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.ntP.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.gKu);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.dAI();
                TransmitPostEditActivity.this.dPw();
            }
        });
        dPE();
        dPG();
        dPA();
        dPs();
        dPF();
        dAO();
        dPM();
        dPz();
        if (this.mtA.getType() == 4 && this.mua != null && this.ntR != null) {
            this.mua.setVisibility(8);
            this.ntR.setVisibility(8);
        }
        dAQ();
        ShowSoftKeyPad(this.mInputManager, this.mtS);
    }

    private void dPz() {
        this.nrC = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.nrC.setData(this.nnh);
        this.nrC.setActivity(this);
    }

    private void dPA() {
        String str;
        String str2;
        if (this.mtA != null) {
            switch (this.mtA.getType()) {
                case 0:
                case 9:
                    if (this.iSJ != null && this.iSJ.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                        if (this.nrg) {
                            this.mName.setText(R.string.transmit_to_dynamic_title);
                        }
                    } else if (this.iSJ != null && this.iSJ.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.mtA.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.mtS.setVisibility(0);
                    this.ntP.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.ntP.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.ntP.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.mtS.setVisibility(8);
                    return;
            }
        }
    }

    private void dPB() {
        if (this.nrg) {
            this.leh = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.dynamic_publish));
        } else {
            this.leh = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.leh.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.leh.setLayoutParams(layoutParams);
        this.leh.setOnFocusChangeListener(this.gKu);
    }

    private void dPC() {
        if (this.mtA != null && this.mtA.getType() == 0 && this.mtA.getType() == 9 && !this.ntM && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = at.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dPK() != null) {
                dPK().setText(cutStringWithSuffix);
                dPK().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void dPD() {
        this.geX = null;
        this.nua = -1;
        this.nuc = -1;
        com.baidu.tieba.frs.ah yy = ag.cuG().yy(1);
        if (yy != null) {
            this.geX = yy.ity;
            this.nua = getIntent().getIntExtra("category_id", -1);
            if (this.geX != null && !this.geX.isEmpty() && this.nua >= 0) {
                this.ntZ = new af();
                this.ntZ.itu = 0;
                this.ntZ.name = getPageContext().getResources().getString(R.string.category_auto);
                this.nuc = this.ntZ.itu;
                this.nub = this.ntZ.name;
                for (af afVar : this.geX) {
                    if (afVar.itu == this.nua) {
                        this.nuc = afVar.itu;
                        this.nub = afVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dPE() {
        if (this.geX != null && !this.geX.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.nud = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.nud.setText(this.nub);
            this.nud.setCategoryContainerData(this.geX, this.ntZ, this.nuc);
            this.nud.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bf bfVar) {
                    if (bfVar != null) {
                        TransmitPostEditActivity.this.nud.setText(bfVar.name);
                        TransmitPostEditActivity.this.mtA.setCategoryTo(bfVar.itu);
                        TransmitPostEditActivity.this.nuc = bfVar.itu;
                        TransmitPostEditActivity.this.nud.dOV();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.nud.dOU();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dPK());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dPJ());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.nut = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.nut.setTitle(R.string.no_disturb_start_time);
        this.nut.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.nut);
        this.nut.setButton(-2, getPageContext().getString(R.string.cancel), this.nut);
        return this.nut;
    }

    private void dPF() {
        this.ntV = (RelativeLayout) findViewById(R.id.addition_container);
        this.ntW = (TextView) findViewById(R.id.addition_create_time);
        this.ntX = (TextView) findViewById(R.id.addition_last_time);
        this.ntY = (TextView) findViewById(R.id.addition_last_content);
        if (this.ntU != null) {
            this.ntV.setVisibility(0);
            this.ntW.setText(getPageContext().getString(R.string.write_addition_create) + at.getFormatTime(this.ntU.getCreateTime() * 1000));
            if (this.ntU.getAlreadyCount() == 0) {
                this.ntX.setVisibility(8);
            } else {
                this.ntX.setText(getPageContext().getString(R.string.write_addition_last) + at.getFormatTime(this.ntU.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.ntU.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.ntY.setText(lastAdditionContent);
            } else {
                this.ntY.setVisibility(8);
            }
            dPJ().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.ntU.getAlreadyCount()), Integer.valueOf(this.ntU.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.ntV.setVisibility(8);
    }

    private void dAO() {
        this.mua = findViewById(R.id.post_prefix_layout);
        this.mtX = (TextView) findViewById(R.id.post_prefix);
        this.ntR = findViewById(R.id.prefix_divider);
        this.mtZ = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.mua.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.mtB = 1;
            this.mua.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.mtX.setVisibility(0);
                    TransmitPostEditActivity.this.mua.setSelected(true);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.mtY, view, 0, com.baidu.adp.lib.util.l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.eZf.btC();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.mtS);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.ntP);
                }
            });
            this.mtZ = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.mtZ.setVisibility(0);
                this.mtX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.mtX.setSelected(true);
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.mtY, view, 0, com.baidu.adp.lib.util.l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.eZf.btC();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dPK());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dPJ());
                    }
                });
            }
            this.mtY = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.mtY.a(this);
            this.mtY.setMaxHeight(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds510));
            this.mtY.setOutsideTouchable(true);
            this.mtY.setFocusable(true);
            this.mtY.setOnDismissListener(this);
            this.mtY.setBackgroundDrawable(ap.getDrawable(R.color.cp_bg_line_d));
            int color = ap.getColor(R.color.cp_cont_b);
            int color2 = ap.getColor(R.color.cp_cont_c);
            ap.setBackgroundResource(this.mtX, R.color.cp_bg_line_d);
            ap.setImageResource(this.mtZ, R.drawable.icon_frs_arrow_n);
            this.mtX.setTextColor(color);
            this.ntS.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.ntS.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.mtY.addView(writePrefixItemLayout);
            }
            this.mtY.setCurrentIndex(0);
            this.mtX.setText(prefixs.get(1));
            La(1);
            return;
        }
        this.mua.setVisibility(8);
    }

    protected void dPG() {
        this.leh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick() && !TransmitPostEditActivity.this.dPS()) {
                    if (TransmitPostEditActivity.this.nuk.a(TransmitPostEditActivity.this.mtS, TransmitPostEditActivity.this.ntP)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.nuk.dNn());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dPK());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dPJ());
                    TransmitPostEditActivity.this.eZf.btC();
                    TiebaStatic.log(new aq("c12608").aj("obj_locate", 7));
                    TransmitPostEditActivity.this.dPP();
                }
            }
        });
    }

    protected void dAP() {
        this.mtS = (EditText) findViewById(R.id.post_title);
        this.mtS.setOnClickListener(this.nup);
        this.mtS.setOnFocusChangeListener(this.gKu);
        if ((this.mtA.getType() == 0 || this.mtA.getType() == 9 || this.mtA.getType() == 7) && this.mtA.getTitle() != null) {
            this.mtS.setText(this.mtA.getTitle());
            this.mtS.setSelection(this.mtA.getTitle().length());
        }
        this.mtS.addTextChangedListener(this.nur);
        if (!this.mtA.getHaveDraft()) {
            dPC();
        }
        this.mtS.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void dAR() {
        this.ntP = (SpanGroupEditText) findViewById(R.id.post_content);
        this.ntP.setDrawingCacheEnabled(false);
        this.ntP.setOnClickListener(this.nup);
        this.ntP.setTransLink(!this.nrg);
        if (this.fbr != null) {
            this.fbr.setSpanGroupManager(this.ntP.getSpanGroupManager());
        }
        if (this.mtA != null) {
            this.mtA.setSpanGroupManager(this.ntP.getSpanGroupManager());
        }
        if (this.mtA.getContent() != null && this.mtA.getContent().length() > 0) {
            this.ntP.setText(TbFaceManager.bwK().av(getPageContext().getPageActivity(), this.mtA.getContent()));
            this.ntP.setSelection(this.ntP.getText().length());
        }
        if (!at.isEmpty(this.imL)) {
            this.ntP.setSelection(0);
        }
        this.ntP.setOnFocusChangeListener(this.gKu);
        this.ntP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.eZf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.ntP.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.ntP.addTextChangedListener(this.nus);
        if (this.nrg) {
            this.ntP.setHint(R.string.dynamic_transmit_publish_edit_str);
        } else if (this.ntL != null && this.ntL.showType == 3) {
            this.ntP.setHint(R.string.share_video_default);
        } else {
            this.ntP.setHint(R.string.share_txt_default);
        }
    }

    private void dPH() {
        this.aii = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aii.getLayoutParams();
        layoutParams.topMargin -= iWg;
        layoutParams.leftMargin = ftT;
        layoutParams.rightMargin = ftT;
        this.aii.setLayoutParams(layoutParams);
        this.aii.setVisibility(0);
        this.aii.a(this.ntL);
        this.aii.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dPI() {
        int i = 5000;
        if (this.ntU != null) {
            i = 1000;
        }
        return dPJ().getText() != null && dPJ().getText().length() >= i;
    }

    private void Dc(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.ntJ)) {
                this.ntJ = "";
                dPJ().requestFocus();
                if (dPJ().getText() != null && dPJ().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dPJ().getSelectionStart();
                    editable = dPJ().getText();
                }
            } else if ("from_title".equals(this.ntJ)) {
                this.ntJ = "";
                dPK().requestFocus();
                if (dPK().getText() != null && dPK().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dPK().getSelectionStart();
                    editable = dPK().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mtA != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.mtA.getForumId(), 0L), this.mtA.getFirstDir(), this.mtA.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(u uVar) {
        if (((ImageSpan[]) dPJ().getText().getSpans(0, dPJ().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.ntT == null) {
                this.ntT = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.ntT.getView().isShown()) {
                this.ntT.cancel();
            }
            this.ntT.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, uVar, dPJ());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dPJ() {
        return this.ntP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dPK() {
        return this.mtS;
    }

    protected void dPL() {
        if (dPJ().getSelectionStart() > 0) {
            String substring = dPJ().getText().toString().substring(0, dPJ().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.iaR.matcher(substring);
            if (matcher.find()) {
                dPJ().getText().delete(dPJ().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dPJ().getSelectionStart());
                return;
            }
            dPJ().onKeyDown(67, this.iaS);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.fjB.setCancelListener(null);
        this.fjB.setTipString(R.string.sending);
        this.fjB.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.fjB.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAQ() {
        if (this.mtA != null) {
            String str = "";
            String str2 = "";
            if (dPK() != null) {
                str = dPK().getText().toString();
            }
            if (dPJ() != null) {
                str2 = dPJ().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mtA.getType() == 0 || this.mtA.getType() == 9 || this.mtA.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.mtB == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mtA.setIsNoTitle(true);
                        } else {
                            this.mtA.setIsNoTitle(false);
                            yi(true);
                            return;
                        }
                    } else {
                        this.mtA.setIsNoTitle(false);
                        yi(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mtA.setIsNoTitle(true);
                } else {
                    this.mtA.setIsNoTitle(false);
                    yi(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.nuf) {
                    yi(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    yi(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                yi(true);
            } else if (this.mtA.getVideoInfo() != null) {
                yi(true);
            } else {
                yi(false);
            }
        }
    }

    private void yi(boolean z) {
        ap.setNavbarTitleColor(this.leh, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.fbr = new NewWriteModel(this);
        this.fbr.b(this.fbF);
        this.ifK = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.dAI();
            }
        };
        this.mtA = new WriteData();
        if (bundle != null) {
            this.mtA.setType(bundle.getInt("type", 0));
            this.mtA.setForumId(bundle.getString("forum_id"));
            this.mtA.setForumName(bundle.getString("forum_name"));
            this.mtA.setFirstDir(bundle.getString("forum_first_dir"));
            this.mtA.setSecondDir(bundle.getString("forum_second_dir"));
            this.mtA.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.ntU = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mtA.setIsAddition(this.ntU != null);
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
            this.mtA.setTitle(bundle.getString("write_title"));
            this.mtA.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.iSJ = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.ntL = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.ShareInfo.class);
            }
            this.mBaijiahaoData = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.imL = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.imM = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.nnh = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.mtA.mDynamicForwardData = (ForwardUploadData) bundle.getSerializable(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA);
            str = string;
        } else {
            Intent intent = getIntent();
            this.mtA.setType(intent.getIntExtra("type", 0));
            this.mtA.setForumId(intent.getStringExtra("forum_id"));
            this.mtA.setForumName(intent.getStringExtra("forum_name"));
            this.mtA.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.mtA.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.mtA.setThreadId(intent.getStringExtra("thread_id"));
            this.ntU = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mtA.setIsAddition(this.ntU != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mtA.setTitle(intent.getStringExtra("write_title"));
            this.mtA.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.iSJ = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.ntL = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            this.mtA.mDynamicForwardData = (ForwardUploadData) intent.getSerializableExtra(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA);
            this.imL = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.imM = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.nnh = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (this.mtA.mDynamicForwardData != null) {
            this.nrg = true;
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.mtA.getType() == 4 ? 6 : 9);
        this.mtA.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.ntL != null && this.ntL.videoId != null) {
            this.mtA.setVideoId(this.ntL.videoId);
            this.mtA.setOriginalVideoCover(this.ntL.showPicUrl);
            this.mtA.setOriginalVideoTitle(this.ntL.showText);
        }
        if (!at.isEmpty(this.imL)) {
            if (!at.isEmpty(this.imM)) {
                this.mtA.setContent("//@" + this.imM + " :" + this.imL);
            } else {
                this.mtA.setContent(this.imL);
            }
        }
        if (this.mtA != null && this.mtA.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mtA.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.ntM = true;
        }
        dPD();
    }

    private void dPM() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) y.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.mtS.setText(com.baidu.tbadk.plugins.b.DH(com.baidu.tbadk.plugins.b.DI(hotTopicBussinessData.mTopicName)));
            this.mtS.setMovementMethod(com.baidu.tieba.view.c.dMO());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString DH = com.baidu.tbadk.plugins.b.DH(com.baidu.tbadk.plugins.b.DI(hotTopicBussinessData.mTopicName));
            if (DH != null) {
                this.mtS.setText(DH);
            }
            this.nuh.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.mtA.getType());
        bundle.putString("forum_id", this.mtA.getForumId());
        bundle.putString("forum_name", this.mtA.getForumName());
        bundle.putString("forum_first_dir", this.mtA.getFirstDir());
        bundle.putString("forum_second_dir", this.mtA.getSecondDir());
        bundle.putString("thread_id", this.mtA.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.iSJ);
        bundle.putSerializable("tab_list", this.nnh);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.ntU != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.ntU));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.iSJ);
        if (this.mtA.mDynamicForwardData != null) {
            bundle.putSerializable(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA, this.mtA.mDynamicForwardData);
        }
        if (this.ntL != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.ntL));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dPJ().getEditableText().toString();
        if (obj != null) {
            dPJ().setText(TbFaceManager.bwK().a(getPageContext().getPageActivity(), obj, this.nun));
            dPJ().setSelection(dPJ().getText().length());
        }
    }

    private String dPN() {
        if (dPJ() == null || dPJ().getText() == null) {
            return "";
        }
        String obj = dPJ().getText().toString();
        if (StringUtils.isNull(obj)) {
            if (this.ntL != null && this.ntL.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return obj;
    }

    private String dPO() {
        if (this.mtA == null || dPK() == null || dPK().getVisibility() != 0 || dPK().getText() == null) {
            return "";
        }
        String obj = dPK().getText().toString();
        if (this.mPrefixData != null && y.getCount(this.mPrefixData.getPrefixs()) > 0 && this.mtB != 0 && this.mtA.getType() != 4 && this.mtX != null && this.mtX.getText() != null) {
            obj = this.mtX.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            obj = this.mPrefixData.getImplicitTitle() + this.mtA.getTitle();
        }
        if (TextUtils.isEmpty(obj)) {
            return getString(R.string.share_txt_default);
        }
        return obj;
    }

    private void cwQ() {
        if (this.mtA != null && this.mtA.mDynamicForwardData != null) {
            dOC();
            return;
        }
        dAI();
        this.mtA.setContent(dPN());
        this.mtA.setTitle(dPO());
        if (this.nua >= 0) {
            this.mtA.setCategoryFrom(this.nua);
        }
        if (this.nuc >= 0) {
            this.mtA.setCategoryTo(this.nuc);
        }
        this.mtA.setWriteImagesInfo(this.writeImagesInfo);
        this.mtA.setHasLocationData(this.fbq != null && this.fbq.ccF());
        this.fbr.wY(this.writeImagesInfo.size() > 0);
        if (!y.isEmpty(this.mList) && this.nug != null && this.nug.mIsGlobalBlock == 0) {
            this.mtA.setForumId(String.valueOf(this.nug.mForumId));
            this.mtA.setForumName(this.nug.mForumName);
        }
        dOD();
        this.fbr.e(this.mtA);
        this.mtA.setContent(this.mtA.getContent().replaceAll("\u0000\n", ""));
        this.mtA.setContent(this.mtA.getContent().replaceAll("\u0000", ""));
        this.mtA.setVcode(null);
        this.fbr.cSo().setVoice(null);
        this.fbr.cSo().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.ifK);
        this.fbr.dFC();
    }

    private void dOD() {
        FrsTabItemData selectedTabItemData;
        if (this.mtA != null && this.nrC != null && (selectedTabItemData = this.nrC.getSelectedTabItemData()) != null) {
            this.mtA.setTabId(selectedTabItemData.tabId);
            this.mtA.setTabName(selectedTabItemData.name);
            this.mtA.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    private void dOC() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        this.mtA.mDynamicForwardData.forward_content = dPN();
        this.mtA.mDynamicForwardData.inputText = dPN();
        this.mtA.mDynamicForwardData.locationPoiId = "0";
        showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
        com.baidu.tieba.write.b.c.b.dOl().a(this.mtA.mDynamicForwardData, new b.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // com.baidu.tieba.write.b.c.b.a
            public void onSuccess(String str) {
                TransmitPostEditActivity.this.closeLoadingDialog();
                com.baidu.tieba.tbadkCore.writeModel.c.g(TransmitPostEditActivity.this.getPageContext().getPageActivity(), null, null, null);
                TransmitPostEditActivity.this.jQ(true);
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

    private void F(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.ntU != null) {
                i2 = this.ntU.getTotalCount();
                i = this.ntU.getAlreadyCount() + 1;
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
                if (this.eZf != null && !this.eZf.bvj()) {
                    dPJ().requestFocus();
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
                            dPJ().getText().insert(dPJ().getSelectionStart(), sb.toString());
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
                        if (this.ntK) {
                            sb2.append(com.baidu.tbadk.plugins.b.fiU);
                            this.ntK = false;
                        }
                        sb2.append(stringExtra);
                        Dc(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !y.isEmpty(this.mList) && !y.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.nug = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.nug);
            }
        } else if (i2 == 0) {
            if (this.eZf != null && !this.eZf.bvj()) {
                this.ntP.requestFocus();
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
                        this.nuk.TK(postWriteCallBackData.getErrorString());
                        this.nuk.bh(postWriteCallBackData.getSensitiveWords());
                        this.nuk.b(this.mtS, this.ntP);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.ntJ)) {
                        dPK().requestFocus();
                        return;
                    } else if ("from_content".equals(this.ntJ)) {
                        dPJ().requestFocus();
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
    public void dPP() {
        if ("1".equals(this.iSJ)) {
            this.mtA.setCanNoForum(true);
            this.mtA.setTransmitForumData("[]");
        } else if ("2".equals(this.iSJ)) {
            this.mtA.setCanNoForum(false);
        }
        dPQ();
        this.mtA.setPrivacy(this.isPrivacy);
        this.mtA.setIsShareThread(true);
        if (this.ntL != null && !StringUtils.isNull(this.ntL.threadId)) {
            this.mtA.setOriginalThreadId(this.ntL.threadId);
        }
        this.mtA.setBaijiahaoData(this.mBaijiahaoData);
        if (this.ntL != null) {
            this.mtA.setOriBaijiahaoData(this.ntL.oriUgcInfo);
        }
        this.mtA.setCallFrom(this.iSJ);
        cwQ();
    }

    private void dPQ() {
        if (this.eZf != null) {
            this.eZf.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dPK());
        HidenSoftKeyPad(this.mInputManager, dPJ());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bM(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.iqr) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aj("obj_locate", ax.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mtA.getType() != 7) {
                if (this.ntU == null) {
                    if (!d(postWriteCallBackData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        return;
                    }
                    return;
                }
                F(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.fbw = i;
        if (this.eZf != null) {
            this.eZf.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void dPR() {
        if (!this.nuf && this.eZf != null) {
            this.eZf.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.eZf.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jQ(boolean z) {
        if (this.eZf != null) {
            this.eZf.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void La(int i) {
        if (i < this.ntS.size()) {
            for (int i2 = 0; i2 < this.ntS.size(); i2++) {
                this.ntS.get(i2).xU(false);
            }
            this.ntS.get(i).xU(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void IB(int i) {
        this.mtB = i;
        this.mtY.setCurrentIndex(i);
        La(i);
        this.mtX.setText(this.mPrefixData.getPrefixs().get(i));
        dAQ();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.mtY, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.mua.setSelected(false);
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
        if (this.mtA != null) {
            if (this.mtA.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.mtA.getType() == 5) {
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
            bvP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.bkk = z;
        if (this.nuj != null && !z) {
            this.nuj.cmD();
        }
        if (this.nul != null && !z) {
            dPu();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.bkk && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.ntK = false;
            this.ntJ = "";
            if ("from_content".equals(str)) {
                this.ntJ = "from_content";
            } else if ("from_title".equals(str)) {
                this.ntJ = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.DG(String.valueOf(charSequence.charAt(i)))) {
                yh(false);
            }
        }
    }

    public void dvq() {
        if (!y.isEmpty(this.mList)) {
            this.ntO.setVisibility(0);
            this.ntO.requestFocus();
            return;
        }
        this.ntO.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dPS() {
        if (((ImageSpan[]) dPJ().getText().getSpans(0, dPJ().getText().length(), ImageSpan.class)).length > 10) {
            if (this.ntT == null) {
                this.ntT = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.ntT.getView().isShown()) {
                this.ntT.cancel();
            }
            this.ntT.show();
            return true;
        }
        return false;
    }
}
