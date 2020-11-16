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
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0248a, i.a {
    private OriginalThreadCardView aim;
    private EditorTools fmD;
    private LocationModel foO;
    private NewWriteModel foP;
    List<af> guu;
    private String iFT;
    private String iFU;
    private boolean isPrivacy;
    private BaijiahaoData mBaijiahaoData;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private int mNa;
    private NavigationBar mNavigationBar;
    private TextView mNw;
    private com.baidu.tieba.write.i mNx;
    private ImageView mNy;
    private View mNz;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private FrsTabInfoData nHd;
    private ForumTabSelectedView nLw;
    private OriginalThreadInfo.ShareInfo nNG;
    private LinearLayout nNI;
    private LinearLayout nNJ;
    private View nNM;
    private Toast nNO;
    private AdditionData nNP;
    private RelativeLayout nNQ;
    private TextView nNR;
    private TextView nNS;
    private TextView nNT;
    af nNU;
    private int nNV;
    private String nNW;
    private int nNX;
    private PostCategoryView nNY;
    private HotTopicBussinessData nOb;
    private TextView nOc;
    private com.baidu.tieba.write.editor.b nOe;
    private g nOg;
    private com.baidu.tieba.view.b nOn;
    private static final int nND = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    private static final int fHI = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44);
    private String nNE = "";
    private boolean nNF = false;
    private WriteData mMZ = null;
    private boolean nNH = false;
    private InputMethodManager mInputManager = null;
    private EditText mNr = null;
    private View mNs = null;
    private LinearLayout mNu = null;
    private SpanGroupEditText nNK = null;
    private FeedBackModel nNL = null;
    private ArrayList<WritePrefixItemLayout> nNN = new ArrayList<>();
    private final KeyEvent iuf = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView lwX = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener iyU = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout jVZ = null;
    private String foT = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int foU = 0;
    private View mRootView = null;
    private ScrollView nNZ = null;
    private boolean nOa = false;
    private com.baidu.tbadk.core.view.a fxh = null;
    private String mFrom = "write";
    private String jlN = "2";
    private SpannableStringBuilder nOd = new SpannableStringBuilder();
    private boolean blo = false;
    private final c nOf = new c();
    private boolean nLa = false;
    private TbFaceManager.a nOh = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan Dy(String str) {
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
    private final AntiHelper.a iJy = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ak("obj_locate", ay.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ak("obj_locate", ay.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d fpd = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mMZ != null) {
                TransmitPostEditActivity.this.nOf.bl(null);
                if (z) {
                    TransmitPostEditActivity.this.kn(z);
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
                    TransmitPostEditActivity.this.nOf.Ul(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.nOf.bl(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.nOf.b(TransmitPostEditActivity.this.mNr, TransmitPostEditActivity.this.nNK);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.c(TransmitPostEditActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(TransmitPostEditActivity.this.getActivity());
                    if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.AJ(TransmitPostEditActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.AJ(postWriteCallBackData.getErrorString());
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
                            TiebaStatic.log(new ar("c13746").ak("obj_locate", 1).ak("obj_type", 1));
                        }
                    });
                    aVar.b(TransmitPostEditActivity.this.getPageContext()).bog();
                    TiebaStatic.log(new ar("c13745").ak("obj_locate", 1).ak("obj_type", 1));
                } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bum());
                    if (com.baidu.tbadk.t.a.Ef(ahVar.bul())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bul())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a fpb = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bzM() {
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
    private final CustomMessageListener nat = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.foO.xD(false);
                    TransmitPostEditActivity.this.foO.gt(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.foO.xD(true);
                TransmitPostEditActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener nOi = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener nOj = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.fmD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dUY = TransmitPostEditActivity.this.dUY();
            if (dUY >= 0 && dUY < TransmitPostEditActivity.this.nNK.getText().length()) {
                TransmitPostEditActivity.this.nNK.setSelection(dUY);
            }
        }
    };
    private boolean nOk = true;
    private final View.OnFocusChangeListener hbU = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.mNr || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.lwX) {
                if (z) {
                    TransmitPostEditActivity.this.nOk = true;
                    TransmitPostEditActivity.this.dUZ();
                    if (TransmitPostEditActivity.this.fmD != null) {
                        TransmitPostEditActivity.this.fmD.bxk();
                    }
                    com.baidu.adp.lib.util.l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.mNr);
                } else if (view == TransmitPostEditActivity.this.mNr) {
                    TransmitPostEditActivity.this.mNw.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.nNK && z) {
                TransmitPostEditActivity.this.nOk = false;
                TransmitPostEditActivity.this.dUZ();
                TransmitPostEditActivity.this.fmD.bxk();
                com.baidu.adp.lib.util.l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.nNK);
            }
            TransmitPostEditActivity.this.dVe();
        }
    };
    private TextWatcher nOl = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String nOp = "";
        private String nOq;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.nOq = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.nOq != null ? this.nOq.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dGr();
            TransmitPostEditActivity.this.dVf();
            EditText dVr = TransmitPostEditActivity.this.dVr();
            if (editable != null && dVr != null && dVr.getText() != null) {
                if (this.nOp == null || !this.nOp.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.nOf != null) {
                        this.nOp = dVr.getText().toString();
                        TransmitPostEditActivity.this.nOf.b(dVr, true);
                        return;
                    }
                    return;
                }
                dVr.setSelection(dVr.getSelectionEnd());
            }
        }
    };
    private TextWatcher nOm = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String nOq;
        private String nOr = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.nOq = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.nOq != null ? this.nOq.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dGr();
            EditText dVq = TransmitPostEditActivity.this.dVq();
            if (editable != null && dVq != null && dVq.getText() != null) {
                int selectionEnd = dVq.getSelectionEnd();
                if (this.nOr == null || !this.nOr.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.nOf != null) {
                        this.nOr = dVq.getText().toString();
                        TransmitPostEditActivity.this.nOf.b(dVq, false);
                        return;
                    }
                    return;
                }
                dVq.setSelection(selectionEnd);
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
    public void bzv() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void bzx() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bzz();
        } else if (this.foO.dKG()) {
            bzv();
        } else {
            this.foO.xD(false);
            a(1, true, (String) null);
            this.foO.dKE();
        }
    }

    private void bzz() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.os(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.a(1, true, (String) null);
                    TransmitPostEditActivity.this.foO.dKI();
                } else {
                    TransmitPostEditActivity.this.fpb.bzM();
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
        aVar.bog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dUY() {
        int selectionEnd = dVq().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dVq().getText().getSpans(0, dVq().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dVq().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dVq().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUZ() {
        if (this.fmD != null) {
            this.fmD.setBarLauncherEnabled(!this.nOk);
            this.fmD.setToolEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nOa) {
            this.mNr.setVisibility(8);
            dGr();
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
        this.foO = new LocationModel(getPageContext());
        this.foO.a(this.fpb);
        registerListener(this.nat);
        registerListener(this.nOi);
        cWX();
        this.nNK.requestFocus();
        dAw();
        dVy();
    }

    @SuppressLint({"ResourceAsColor"})
    private void cWX() {
        this.fmD = new EditorTools(getActivity());
        this.fmD.setBarMaxLauCount(4);
        this.fmD.setMoreButtonAtEnd(true);
        this.fmD.setBarLauncherType(1);
        this.fmD.kc(true);
        this.fmD.kd(true);
        this.fmD.setBackgroundColorId(R.color.CAM_X0207);
        dVa();
        this.fmD.build();
        if (this.nLa) {
            this.fmD.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        }
        if (this.nNI != null) {
            this.nNI.addView(this.fmD);
        }
        cWz();
        this.fmD.display();
        com.baidu.tbadk.editortools.h rF = this.fmD.rF(6);
        if (rF != null && !TextUtils.isEmpty(this.foT)) {
            ((View) rF).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.foT);
                }
            });
        }
        if (!this.nOa) {
            this.fmD.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.fmD.bxk();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.fmD.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.fmD.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mMZ.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mMZ.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        if (!this.nLa) {
            dVc();
        }
    }

    private void dVa() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.fmD.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        if (!this.nLa && this.nNP == null) {
            if (this.nOe == null) {
                this.nOe = new com.baidu.tieba.write.editor.b(getActivity(), this.jlN);
                this.nOe.dTG();
                this.nOe.setFrom("from_share_write");
                this.nOe.bP(this.mMZ.getForumId(), this.mPrivateThread);
            }
            this.fmD.b(this.nOe);
        }
        this.fmD.bA(arrayList);
        com.baidu.tbadk.editortools.m rI = this.fmD.rI(5);
        if (rI != null) {
            rI.fnq = 1;
            if (this.nLa) {
                rI.kf(false);
            }
        }
    }

    private void cWz() {
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
                            TiebaStatic.log(new ar("c12608").ak("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.dVp()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.dVp()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof u)) {
                            TransmitPostEditActivity.this.e((u) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.dVs();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.dGr();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.nNP == null) {
                            TransmitPostEditActivity.this.bzA();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.foU) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ae.checkLocationForGoogle(pageActivity)) {
                                    TransmitPostEditActivity.this.bzx();
                                    return;
                                } else {
                                    ae.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.bzv();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.foO != null) {
                            TransmitPostEditActivity.this.foO.xD(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        ar arVar = new ar("c10645");
                        if (TransmitPostEditActivity.this.mMZ != null) {
                            str = TransmitPostEditActivity.this.mMZ.getForumId();
                        } else {
                            str = "";
                        }
                        arVar.dR("fid", str);
                        TiebaStatic.log(arVar);
                        if (TransmitPostEditActivity.this.mMZ == null || (videoInfo = TransmitPostEditActivity.this.mMZ.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.fmD.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.fmD.byR()) {
                                        TransmitPostEditActivity.this.fmD.bxk();
                                        TransmitPostEditActivity.this.fmD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.fmD.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.fmD.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.fmD.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.fmD.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mMZ.setVideoInfo(null);
                        TransmitPostEditActivity.this.dGr();
                        if (TransmitPostEditActivity.this.nNK != null) {
                            TransmitPostEditActivity.this.nNK.requestFocus();
                        }
                        TransmitPostEditActivity.this.fmD.bxk();
                        TransmitPostEditActivity.this.fmD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.nNK);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.fmD.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.nNF = true;
                        TransmitPostEditActivity.this.yO(true);
                        if (TransmitPostEditActivity.this.dVr().isFocused()) {
                            TransmitPostEditActivity.this.nNE = "from_title";
                        } else if (TransmitPostEditActivity.this.dVq().isFocused()) {
                            TransmitPostEditActivity.this.nNE = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.nNJ.setVisibility(0);
                        TransmitPostEditActivity.this.nNJ.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.nNJ.hasFocus()) {
                            TransmitPostEditActivity.this.nNK.requestFocus();
                            TransmitPostEditActivity.this.nNK.setSelection(TransmitPostEditActivity.this.nNK.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.nNJ.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.fmD.setActionListener(31, bVar);
        this.fmD.setActionListener(16, bVar);
        this.fmD.setActionListener(14, bVar);
        this.fmD.setActionListener(24, bVar);
        this.fmD.setActionListener(3, bVar);
        this.fmD.setActionListener(10, bVar);
        this.fmD.setActionListener(11, bVar);
        this.fmD.setActionListener(12, bVar);
        this.fmD.setActionListener(13, bVar);
        this.fmD.setActionListener(15, bVar);
        this.fmD.setActionListener(18, bVar);
        this.fmD.setActionListener(20, bVar);
        this.fmD.setActionListener(25, bVar);
        this.fmD.setActionListener(27, bVar);
        this.fmD.setActionListener(29, bVar);
        this.fmD.setActionListener(43, bVar);
        this.fmD.setActionListener(45, bVar);
        this.fmD.setActionListener(53, bVar);
        this.fmD.setActionListener(48, bVar);
        this.fmD.setActionListener(46, bVar);
        this.fmD.setActionListener(49, bVar);
        this.fmD.setActionListener(47, bVar);
        this.fmD.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzA() {
        if (this.foO.chG()) {
            if (this.foO.dKG()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.b.dKB().getLocationData().getFormatted_address());
                return;
            }
            a(1, true, (String) null);
            this.foO.dKE();
            return;
        }
        a(0, true, (String) null);
    }

    protected void dGj() {
        if (this.foP != null) {
            this.foP.cancelLoadData();
        }
        if (this.nNL != null) {
            this.nNL.cancelLoadData();
        }
        if (this.foO != null) {
            this.foO.cancelLoadData();
        }
    }

    private void dVb() {
        if (this.nOg != null) {
            this.nOg.hideTip();
        }
    }

    private void dVc() {
        if (this.nOg == null) {
            this.nOg = new g(getPageContext());
        }
        this.nOg.d(this.fmD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dVb();
        TiebaPrepareImageService.StopService();
        dGj();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVd() {
        if (this.mMZ == null) {
            finish();
            return;
        }
        this.mMZ.setTitle(dVr().getText().toString());
        this.mMZ.setContent(dVq().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.mNx != null && this.mNx.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mNx, getPageContext().getPageActivity());
                return true;
            } else if (this.fmD.byR()) {
                this.fmD.bxk();
                return true;
            } else {
                dGj();
                dVd();
                return true;
            }
        }
        if (i == 67 && (text = dVq().getText()) != null) {
            int selectionStart = dVq().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dVq().onKeyDown(67, this.iuf);
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
        getLayoutMode().onModeChanged(this.jVZ);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.lwX, R.color.CAM_X0302, 1);
        dUZ();
        ap.setBackgroundColor(this.mNs, R.color.CAM_X0204);
        ap.setBackgroundColor(dVr(), R.color.CAM_X0201);
        ap.setBackgroundColor(dVq(), R.color.CAM_X0201);
        dGr();
        this.fmD.onChangeSkinType(i);
        if (this.nNY != null) {
            this.nNY.brT();
        }
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        dVe();
        dVf();
        if (this.nOf != null) {
            this.nOf.c(dVr(), dVq());
        }
        if (this.aim != null) {
            this.aim.onChangeSkinType();
        }
        if (this.nLw != null) {
            this.nLw.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVe() {
        if (this.mNr.hasFocus()) {
            this.mNr.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        } else {
            this.mNr.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        }
        if (this.nNK.hasFocus()) {
            this.nNK.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        } else {
            this.nNK.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVf() {
        if (this.mNr != null) {
            if (this.mNr.getText().toString().length() == 0) {
                this.mNr.getPaint().setFakeBoldText(false);
            } else if (this.mNr.getText().toString().length() > 0) {
                this.mNr.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.fxh = new com.baidu.tbadk.core.view.a(getPageContext());
        this.nOa = this.mMZ.getType() == 4 || 5 == this.mMZ.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bqB().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        dVi();
        this.nNZ = (ScrollView) findViewById(R.id.write_scrollview);
        this.nNZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.nNK != null) {
                        com.baidu.adp.lib.util.l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.nNK);
                    }
                    if (TransmitPostEditActivity.this.fmD != null) {
                        TransmitPostEditActivity.this.fmD.bxk();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jVZ = (RelativeLayout) findViewById(R.id.parent);
        this.nNI = (LinearLayout) findViewById(R.id.tool_view);
        this.nNI.setContentDescription(IStringUtil.TOP_PATH);
        this.nNJ = (LinearLayout) findViewById(R.id.title_view);
        this.mNs = findViewById(R.id.interval_view);
        this.nOc = (TextView) findViewById(R.id.hot_topic_title_edt);
        dGq();
        if (this.nOa) {
            this.nNZ.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        dGs();
        dVo();
        this.mNu = (LinearLayout) findViewById(R.id.post_content_container);
        this.mNu.setDrawingCacheEnabled(false);
        this.mNu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.fmD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.nNK.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.hbU);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.dGj();
                TransmitPostEditActivity.this.dVd();
            }
        });
        dVl();
        dVn();
        dVh();
        dUZ();
        dVm();
        dGp();
        dVt();
        dVg();
        if (this.mMZ.getType() == 4 && this.mNz != null && this.nNM != null) {
            this.mNz.setVisibility(8);
            this.nNM.setVisibility(8);
        }
        dGr();
        ShowSoftKeyPad(this.mInputManager, this.mNr);
    }

    private void dVg() {
        this.nLw = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.nLw.setBgColor(R.color.CAM_X0205);
        this.nLw.setData(this.nHd);
        this.nLw.setActivity(this);
    }

    private void dVh() {
        String str;
        String str2;
        if (this.mMZ != null) {
            switch (this.mMZ.getType()) {
                case 0:
                case 9:
                    if (this.jlN != null && this.jlN.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                        if (this.nLa) {
                            this.mName.setText(R.string.transmit_to_dynamic_title);
                        }
                    } else if (this.jlN != null && this.jlN.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.mMZ.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.mNr.setVisibility(0);
                    this.nNK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.nNK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.nNK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.mNr.setVisibility(8);
                    return;
            }
        }
    }

    private void dVi() {
        if (this.nLa) {
            this.lwX = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.dynamic_publish));
        } else {
            this.lwX = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lwX.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.lwX.setLayoutParams(layoutParams);
        this.lwX.setOnFocusChangeListener(this.hbU);
    }

    private void dVj() {
        if (this.mMZ != null && this.mMZ.getType() == 0 && this.mMZ.getType() == 9 && !this.nNH && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = au.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dVr() != null) {
                dVr().setText(cutStringWithSuffix);
                dVr().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void dVk() {
        this.guu = null;
        this.nNV = -1;
        this.nNX = -1;
        com.baidu.tieba.frs.ah zC = ag.czR().zC(1);
        if (zC != null) {
            this.guu = zC.iME;
            this.nNV = getIntent().getIntExtra("category_id", -1);
            if (this.guu != null && !this.guu.isEmpty() && this.nNV >= 0) {
                this.nNU = new af();
                this.nNU.iMA = 0;
                this.nNU.name = getPageContext().getResources().getString(R.string.category_auto);
                this.nNX = this.nNU.iMA;
                this.nNW = this.nNU.name;
                for (af afVar : this.guu) {
                    if (afVar.iMA == this.nNV) {
                        this.nNX = afVar.iMA;
                        this.nNW = afVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dVl() {
        if (this.guu != null && !this.guu.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.nNY = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.nNY.setText(this.nNW);
            this.nNY.setCategoryContainerData(this.guu, this.nNU, this.nNX);
            this.nNY.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bf bfVar) {
                    if (bfVar != null) {
                        TransmitPostEditActivity.this.nNY.setText(bfVar.name);
                        TransmitPostEditActivity.this.mMZ.setCategoryTo(bfVar.iMA);
                        TransmitPostEditActivity.this.nNX = bfVar.iMA;
                        TransmitPostEditActivity.this.nNY.dUC();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.nNY.dUB();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dVr());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dVq());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.nOn = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.nOn.setTitle(R.string.no_disturb_start_time);
        this.nOn.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.nOn);
        this.nOn.setButton(-2, getPageContext().getString(R.string.cancel), this.nOn);
        return this.nOn;
    }

    private void dVm() {
        this.nNQ = (RelativeLayout) findViewById(R.id.addition_container);
        this.nNR = (TextView) findViewById(R.id.addition_create_time);
        this.nNS = (TextView) findViewById(R.id.addition_last_time);
        this.nNT = (TextView) findViewById(R.id.addition_last_content);
        if (this.nNP != null) {
            this.nNQ.setVisibility(0);
            this.nNR.setText(getPageContext().getString(R.string.write_addition_create) + au.getFormatTime(this.nNP.getCreateTime() * 1000));
            if (this.nNP.getAlreadyCount() == 0) {
                this.nNS.setVisibility(8);
            } else {
                this.nNS.setText(getPageContext().getString(R.string.write_addition_last) + au.getFormatTime(this.nNP.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.nNP.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.nNT.setText(lastAdditionContent);
            } else {
                this.nNT.setVisibility(8);
            }
            dVq().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.nNP.getAlreadyCount()), Integer.valueOf(this.nNP.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.nNQ.setVisibility(8);
    }

    private void dGp() {
        this.mNz = findViewById(R.id.post_prefix_layout);
        this.mNw = (TextView) findViewById(R.id.post_prefix);
        this.nNM = findViewById(R.id.prefix_divider);
        this.mNy = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.mNz.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.mNa = 1;
            this.mNz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.mNw.setVisibility(0);
                    TransmitPostEditActivity.this.mNz.setSelected(true);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.mNx, view, 0, com.baidu.adp.lib.util.l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.fmD.bxk();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.mNr);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.nNK);
                }
            });
            this.mNy = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.mNy.setVisibility(0);
                this.mNw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.mNw.setSelected(true);
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.mNx, view, 0, com.baidu.adp.lib.util.l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.fmD.bxk();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dVr());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dVq());
                    }
                });
            }
            this.mNx = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.mNx.a(this);
            this.mNx.setMaxHeight(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds510));
            this.mNx.setOutsideTouchable(true);
            this.mNx.setFocusable(true);
            this.mNx.setOnDismissListener(this);
            this.mNx.setBackgroundDrawable(ap.getDrawable(R.color.CAM_X0201));
            int color = ap.getColor(R.color.CAM_X0105);
            int color2 = ap.getColor(R.color.CAM_X0108);
            ap.setBackgroundResource(this.mNw, R.color.CAM_X0201);
            ap.setImageResource(this.mNy, R.drawable.icon_frs_arrow_n);
            this.mNw.setTextColor(color);
            this.nNN.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.nNN.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.mNx.addView(writePrefixItemLayout);
            }
            this.mNx.setCurrentIndex(0);
            this.mNw.setText(prefixs.get(1));
            Mi(1);
            return;
        }
        this.mNz.setVisibility(8);
    }

    protected void dVn() {
        this.lwX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick() && !TransmitPostEditActivity.this.dVz()) {
                    if (TransmitPostEditActivity.this.nOf.a(TransmitPostEditActivity.this.mNr, TransmitPostEditActivity.this.nNK)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.nOf.dSW());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dVr());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dVq());
                    TransmitPostEditActivity.this.fmD.bxk();
                    TiebaStatic.log(new ar("c12608").ak("obj_locate", 7));
                    TransmitPostEditActivity.this.dVw();
                }
            }
        });
    }

    protected void dGq() {
        this.mNr = (EditText) findViewById(R.id.post_title);
        this.mNr.setOnClickListener(this.nOj);
        this.mNr.setOnFocusChangeListener(this.hbU);
        if ((this.mMZ.getType() == 0 || this.mMZ.getType() == 9 || this.mMZ.getType() == 7) && this.mMZ.getTitle() != null) {
            this.mNr.setText(this.mMZ.getTitle());
            this.mNr.setSelection(this.mMZ.getTitle().length());
        }
        this.mNr.addTextChangedListener(this.nOl);
        if (!this.mMZ.getHaveDraft()) {
            dVj();
        }
        this.mNr.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void dGs() {
        this.nNK = (SpanGroupEditText) findViewById(R.id.post_content);
        this.nNK.setDrawingCacheEnabled(false);
        this.nNK.setOnClickListener(this.nOj);
        this.nNK.setTransLink(!this.nLa);
        if (this.foP != null) {
            this.foP.setSpanGroupManager(this.nNK.getSpanGroupManager());
        }
        if (this.mMZ != null) {
            this.mMZ.setSpanGroupManager(this.nNK.getSpanGroupManager());
        }
        if (this.mMZ.getContent() != null && this.mMZ.getContent().length() > 0) {
            this.nNK.setText(TbFaceManager.bAs().at(getPageContext().getPageActivity(), this.mMZ.getContent()));
            this.nNK.setSelection(this.nNK.getText().length());
        }
        if (!au.isEmpty(this.iFT)) {
            this.nNK.setSelection(0);
        }
        this.nNK.setOnFocusChangeListener(this.hbU);
        this.nNK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.fmD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.nNK.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.nNK.addTextChangedListener(this.nOm);
        if (this.nLa) {
            this.nNK.setHint(R.string.dynamic_transmit_publish_edit_str);
        } else if (this.nNG != null && this.nNG.showType == 3) {
            this.nNK.setHint(R.string.share_video_default);
        } else {
            this.nNK.setHint(R.string.share_txt_default);
        }
    }

    private void dVo() {
        this.aim = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aim.getLayoutParams();
        layoutParams.topMargin -= nND;
        layoutParams.leftMargin = fHI;
        layoutParams.rightMargin = fHI;
        this.aim.setLayoutParams(layoutParams);
        this.aim.setVisibility(0);
        this.aim.a(this.nNG);
        this.aim.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dVp() {
        int i = 5000;
        if (this.nNP != null) {
            i = 1000;
        }
        return dVq().getText() != null && dVq().getText().length() >= i;
    }

    private void Di(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.nNE)) {
                this.nNE = "";
                dVq().requestFocus();
                if (dVq().getText() != null && dVq().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dVq().getSelectionStart();
                    editable = dVq().getText();
                }
            } else if ("from_title".equals(this.nNE)) {
                this.nNE = "";
                dVr().requestFocus();
                if (dVr().getText() != null && dVr().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dVr().getSelectionStart();
                    editable = dVr().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yO(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mMZ != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.mMZ.getForumId(), 0L), this.mMZ.getFirstDir(), this.mMZ.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(u uVar) {
        if (((ImageSpan[]) dVq().getText().getSpans(0, dVq().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.nNO == null) {
                this.nNO = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.nNO.getView().isShown()) {
                this.nNO.cancel();
            }
            this.nNO.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, uVar, dVq());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dVq() {
        return this.nNK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dVr() {
        return this.mNr;
    }

    protected void dVs() {
        if (dVq().getSelectionStart() > 0) {
            String substring = dVq().getText().toString().substring(0, dVq().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.iue.matcher(substring);
            if (matcher.find()) {
                dVq().getText().delete(dVq().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dVq().getSelectionStart());
                return;
            }
            dVq().onKeyDown(67, this.iuf);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.fxh.setCancelListener(null);
        this.fxh.setTipString(R.string.sending);
        this.fxh.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.fxh.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGr() {
        if (this.mMZ != null) {
            String str = "";
            String str2 = "";
            if (dVr() != null) {
                str = dVr().getText().toString();
            }
            if (dVq() != null) {
                str2 = dVq().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mMZ.getType() == 0 || this.mMZ.getType() == 9 || this.mMZ.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.mNa == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mMZ.setIsNoTitle(true);
                        } else {
                            this.mMZ.setIsNoTitle(false);
                            yP(true);
                            return;
                        }
                    } else {
                        this.mMZ.setIsNoTitle(false);
                        yP(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mMZ.setIsNoTitle(true);
                } else {
                    this.mMZ.setIsNoTitle(false);
                    yP(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.nOa) {
                    yP(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    yP(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                yP(true);
            } else if (this.mMZ.getVideoInfo() != null) {
                yP(true);
            } else {
                yP(false);
            }
        }
    }

    private void yP(boolean z) {
        ap.setNavbarTitleColor(this.lwX, R.color.CAM_X0302, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.foP = new NewWriteModel(this);
        this.foP.b(this.fpd);
        this.iyU = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.dGj();
            }
        };
        this.mMZ = new WriteData();
        if (bundle != null) {
            this.mMZ.setType(bundle.getInt("type", 0));
            this.mMZ.setForumId(bundle.getString("forum_id"));
            this.mMZ.setForumName(bundle.getString("forum_name"));
            this.mMZ.setFirstDir(bundle.getString("forum_first_dir"));
            this.mMZ.setSecondDir(bundle.getString("forum_second_dir"));
            this.mMZ.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.nNP = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mMZ.setIsAddition(this.nNP != null);
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
            this.mMZ.setTitle(bundle.getString("write_title"));
            this.mMZ.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.jlN = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.nNG = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.ShareInfo.class);
            }
            this.mBaijiahaoData = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.iFT = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.iFU = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.nHd = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.mMZ.mDynamicForwardData = (ForwardUploadData) bundle.getSerializable(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA);
            str = string;
        } else {
            Intent intent = getIntent();
            this.mMZ.setType(intent.getIntExtra("type", 0));
            this.mMZ.setForumId(intent.getStringExtra("forum_id"));
            this.mMZ.setForumName(intent.getStringExtra("forum_name"));
            this.mMZ.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.mMZ.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.mMZ.setThreadId(intent.getStringExtra("thread_id"));
            this.nNP = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mMZ.setIsAddition(this.nNP != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mMZ.setTitle(intent.getStringExtra("write_title"));
            this.mMZ.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.jlN = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.nNG = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            this.mMZ.mDynamicForwardData = (ForwardUploadData) intent.getSerializableExtra(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA);
            this.iFT = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.iFU = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.nHd = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (this.mMZ.mDynamicForwardData != null) {
            this.nLa = true;
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.mMZ.getType() == 4 ? 6 : 9);
        this.mMZ.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.nNG != null && this.nNG.videoId != null) {
            this.mMZ.setVideoId(this.nNG.videoId);
            this.mMZ.setOriginalVideoCover(this.nNG.showPicUrl);
            this.mMZ.setOriginalVideoTitle(this.nNG.showText);
        }
        if (!au.isEmpty(this.iFT)) {
            if (!au.isEmpty(this.iFU)) {
                this.mMZ.setContent("//@" + this.iFU + " :" + this.iFT);
            } else {
                this.mMZ.setContent(this.iFT);
            }
        }
        if (this.mMZ != null && this.mMZ.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mMZ.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.nNH = true;
        }
        dVk();
    }

    private void dVt() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) y.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.mNr.setText(com.baidu.tbadk.plugins.b.DN(com.baidu.tbadk.plugins.b.DO(hotTopicBussinessData.mTopicName)));
            this.mNr.setMovementMethod(com.baidu.tieba.view.c.dSx());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString DN = com.baidu.tbadk.plugins.b.DN(com.baidu.tbadk.plugins.b.DO(hotTopicBussinessData.mTopicName));
            if (DN != null) {
                this.mNr.setText(DN);
            }
            this.nOc.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.mMZ.getType());
        bundle.putString("forum_id", this.mMZ.getForumId());
        bundle.putString("forum_name", this.mMZ.getForumName());
        bundle.putString("forum_first_dir", this.mMZ.getFirstDir());
        bundle.putString("forum_second_dir", this.mMZ.getSecondDir());
        bundle.putString("thread_id", this.mMZ.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jlN);
        bundle.putSerializable("tab_list", this.nHd);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.nNP != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.nNP));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jlN);
        if (this.mMZ.mDynamicForwardData != null) {
            bundle.putSerializable(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA, this.mMZ.mDynamicForwardData);
        }
        if (this.nNG != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.nNG));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dVq().getEditableText().toString();
        if (obj != null) {
            dVq().setText(TbFaceManager.bAs().a(getPageContext().getPageActivity(), obj, this.nOh));
            dVq().setSelection(dVq().getText().length());
        }
    }

    private String dVu() {
        if (dVq() == null || dVq().getText() == null) {
            return "";
        }
        String obj = dVq().getText().toString();
        if (StringUtils.isNull(obj)) {
            if (this.nNG != null && this.nNG.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return obj;
    }

    private String dVv() {
        if (this.mMZ == null || dVr() == null || dVr().getVisibility() != 0 || dVr().getText() == null) {
            return "";
        }
        String obj = dVr().getText().toString();
        if (this.mPrefixData != null && y.getCount(this.mPrefixData.getPrefixs()) > 0 && this.mNa != 0 && this.mMZ.getType() != 4 && this.mNw != null && this.mNw.getText() != null) {
            obj = this.mNw.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            obj = this.mPrefixData.getImplicitTitle() + this.mMZ.getTitle();
        }
        if (TextUtils.isEmpty(obj)) {
            if (TextUtils.isEmpty(this.mMZ.getContent())) {
                return getString(R.string.share_txt_default);
            }
            if (getString(R.string.share_txt_default).equals(this.mMZ.getContent())) {
                return getString(R.string.share_txt_default);
            }
            if (getString(R.string.share_video_default).equals(this.mMZ.getContent())) {
                return getString(R.string.share_video_default);
            }
            return obj;
        }
        return obj;
    }

    private void cCc() {
        if (this.mMZ != null && this.mMZ.mDynamicForwardData != null) {
            dUj();
            return;
        }
        dGj();
        this.mMZ.setContent(dVu());
        this.mMZ.setTitle(dVv());
        if (this.nNV >= 0) {
            this.mMZ.setCategoryFrom(this.nNV);
        }
        if (this.nNX >= 0) {
            this.mMZ.setCategoryTo(this.nNX);
        }
        this.mMZ.setWriteImagesInfo(this.writeImagesInfo);
        this.mMZ.setHasLocationData(this.foO != null && this.foO.chG());
        this.foP.xF(this.writeImagesInfo.size() > 0);
        if (!y.isEmpty(this.mList) && this.nOb != null && this.nOb.mIsGlobalBlock == 0) {
            this.mMZ.setForumId(String.valueOf(this.nOb.mForumId));
            this.mMZ.setForumName(this.nOb.mForumName);
        }
        dUk();
        this.foP.e(this.mMZ);
        this.mMZ.setContent(this.mMZ.getContent().replaceAll("\u0000\n", ""));
        this.mMZ.setContent(this.mMZ.getContent().replaceAll("\u0000", ""));
        this.mMZ.setVcode(null);
        this.foP.cXs().setVoice(null);
        this.foP.cXs().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.iyU);
        this.foP.dLl();
    }

    private void dUk() {
        FrsTabItemData selectedTabItemData;
        if (this.mMZ != null && this.nLw != null && (selectedTabItemData = this.nLw.getSelectedTabItemData()) != null) {
            this.mMZ.setTabId(selectedTabItemData.tabId);
            this.mMZ.setTabName(selectedTabItemData.name);
            this.mMZ.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    private void dUj() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        this.mMZ.mDynamicForwardData.forward_content = dVu();
        this.mMZ.mDynamicForwardData.inputText = dVu();
        this.mMZ.mDynamicForwardData.locationPoiId = "0";
        showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
        com.baidu.tieba.write.b.c.b.dTS().a(this.mMZ.mDynamicForwardData, new b.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // com.baidu.tieba.write.b.c.b.a
            public void onSuccess(String str) {
                TransmitPostEditActivity.this.closeLoadingDialog();
                com.baidu.tieba.tbadkCore.writeModel.c.g(TransmitPostEditActivity.this.getPageContext().getPageActivity(), null, null, null);
                TransmitPostEditActivity.this.kn(true);
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
            if (this.nNP != null) {
                i2 = this.nNP.getTotalCount();
                i = this.nNP.getAlreadyCount() + 1;
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
                if (this.fmD != null && !this.fmD.byR()) {
                    dVq().requestFocus();
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
                            dVq().getText().insert(dVq().getSelectionStart(), sb.toString());
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
                        if (this.nNF) {
                            sb2.append(com.baidu.tbadk.plugins.b.fwA);
                            this.nNF = false;
                        }
                        sb2.append(stringExtra);
                        Di(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !y.isEmpty(this.mList) && !y.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.nOb = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.nOb);
            }
        } else if (i2 == 0) {
            if (this.fmD != null && !this.fmD.byR()) {
                this.nNK.requestFocus();
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
                        this.nOf.Ul(postWriteCallBackData.getErrorString());
                        this.nOf.bl(postWriteCallBackData.getSensitiveWords());
                        this.nOf.b(this.mNr, this.nNK);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.nNE)) {
                        dVr().requestFocus();
                        return;
                    } else if ("from_content".equals(this.nNE)) {
                        dVq().requestFocus();
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
    public void dVw() {
        if ("1".equals(this.jlN)) {
            this.mMZ.setCanNoForum(true);
            this.mMZ.setTransmitForumData("[]");
        } else if ("2".equals(this.jlN)) {
            this.mMZ.setCanNoForum(false);
        }
        dVx();
        this.mMZ.setPrivacy(this.isPrivacy);
        this.mMZ.setIsShareThread(true);
        if (this.nNG != null && !StringUtils.isNull(this.nNG.threadId)) {
            this.mMZ.setOriginalThreadId(this.nNG.threadId);
        }
        this.mMZ.setBaijiahaoData(this.mBaijiahaoData);
        if (this.nNG != null) {
            this.mMZ.setOriBaijiahaoData(this.nNG.oriUgcInfo);
        }
        this.mMZ.setCallFrom(this.jlN);
        cCc();
    }

    private void dVx() {
        if (this.fmD != null) {
            this.fmD.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dVr());
        HidenSoftKeyPad(this.mInputManager, dVq());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bP(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.iJy) != null) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ak("obj_locate", ay.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mMZ.getType() != 7) {
                if (this.nNP == null) {
                    if (!d(postWriteCallBackData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
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
        this.foU = i;
        if (this.fmD != null) {
            this.fmD.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void dVy() {
        if (!this.nOa && this.fmD != null) {
            this.fmD.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.fmD.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kn(boolean z) {
        if (this.fmD != null) {
            this.fmD.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Mi(int i) {
        if (i < this.nNN.size()) {
            for (int i2 = 0; i2 < this.nNN.size(); i2++) {
                this.nNN.get(i2).yB(false);
            }
            this.nNN.get(i).yB(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void JJ(int i) {
        this.mNa = i;
        this.mNx.setCurrentIndex(i);
        Mi(i);
        this.mNw.setText(this.mPrefixData.getPrefixs().get(i));
        dGr();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.mNx, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.mNz.setSelected(false);
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
        if (this.mMZ != null) {
            if (this.mMZ.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.mMZ.getType() == 5) {
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
            bzx();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.blo = z;
        if (this.nOe != null && !z) {
            this.nOe.crO();
        }
        if (this.nOg != null && !z) {
            dVb();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.blo && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.nNF = false;
            this.nNE = "";
            if ("from_content".equals(str)) {
                this.nNE = "from_content";
            } else if ("from_title".equals(str)) {
                this.nNE = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.DM(String.valueOf(charSequence.charAt(i)))) {
                yO(false);
            }
        }
    }

    public void dAw() {
        if (!y.isEmpty(this.mList)) {
            this.nNJ.setVisibility(0);
            this.nNJ.requestFocus();
            return;
        }
        this.nNJ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dVz() {
        if (((ImageSpan[]) dVq().getText().getSpans(0, dVq().getText().length(), ImageSpan.class)).length > 10) {
            if (this.nNO == null) {
                this.nNO = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.nNO.getView().isShown()) {
                this.nNO.cancel();
            }
            this.nNO.show();
            return true;
        }
        return false;
    }
}
