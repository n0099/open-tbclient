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
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0250a, i.a {
    private OriginalThreadCardView aij;
    private EditorTools fnv;
    private LocationModel fpH;
    private NewWriteModel fpI;
    List<af> guN;
    private String iFf;
    private String iFg;
    private boolean isPrivacy;
    private BaijiahaoData mBaijiahaoData;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private TextView mMD;
    private com.baidu.tieba.write.i mME;
    private ImageView mMF;
    private View mMG;
    private int mMh;
    private NavigationBar mNavigationBar;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private FrsTabInfoData nFC;
    private ForumTabSelectedView nJV;
    private TextView nMA;
    private com.baidu.tieba.write.editor.b nMC;
    private g nME;
    private com.baidu.tieba.view.b nML;
    private OriginalThreadInfo.ShareInfo nMe;
    private LinearLayout nMg;
    private LinearLayout nMh;
    private View nMk;
    private Toast nMm;
    private AdditionData nMn;
    private RelativeLayout nMo;
    private TextView nMp;
    private TextView nMq;
    private TextView nMr;
    af nMs;
    private int nMt;
    private String nMu;
    private int nMv;
    private PostCategoryView nMw;
    private HotTopicBussinessData nMz;
    private static final int joB = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    private static final int fIe = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44);
    private String nMc = "";
    private boolean nMd = false;
    private WriteData mMg = null;
    private boolean nMf = false;
    private InputMethodManager mInputManager = null;
    private EditText mMy = null;
    private View mMz = null;
    private LinearLayout mMB = null;
    private SpanGroupEditText nMi = null;
    private FeedBackModel nMj = null;
    private ArrayList<WritePrefixItemLayout> nMl = new ArrayList<>();
    private final KeyEvent itr = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView lwH = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener iyf = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout jVp = null;
    private String fpM = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int fpN = 0;
    private View mRootView = null;
    private ScrollView nMx = null;
    private boolean nMy = false;
    private com.baidu.tbadk.core.view.a fxS = null;
    private String mFrom = "write";
    private String jld = "2";
    private SpannableStringBuilder nMB = new SpannableStringBuilder();
    private boolean bmZ = false;
    private final c nMD = new c();
    private boolean nJz = false;
    private TbFaceManager.a nMF = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan DZ(String str) {
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
    private final AntiHelper.a iIK = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ax.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ax.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d fpW = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mMg != null) {
                TransmitPostEditActivity.this.nMD.bk(null);
                if (z) {
                    TransmitPostEditActivity.this.km(z);
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
                    TransmitPostEditActivity.this.nMD.UA(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.nMD.bk(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.nMD.b(TransmitPostEditActivity.this.mMy, TransmitPostEditActivity.this.nMi);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.c(TransmitPostEditActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(TransmitPostEditActivity.this.getActivity());
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.Bo(TransmitPostEditActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.Bo(postWriteCallBackData.getErrorString());
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
                            TiebaStatic.log(new aq("c13746").al("obj_locate", 1).al("obj_type", 1));
                        }
                    });
                    aVar.b(TransmitPostEditActivity.this.getPageContext()).bpc();
                    TiebaStatic.log(new aq("c13745").al("obj_locate", 1).al("obj_type", 1));
                } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.buW());
                    if (com.baidu.tbadk.t.a.EE(ahVar.buV())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.buV())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a fpU = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bAw() {
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
    private final CustomMessageListener mZs = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.fpH.xw(false);
                    TransmitPostEditActivity.this.fpH.gt(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.fpH.xw(true);
                TransmitPostEditActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener nMG = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener nMH = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.fnv.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dUZ = TransmitPostEditActivity.this.dUZ();
            if (dUZ >= 0 && dUZ < TransmitPostEditActivity.this.nMi.getText().length()) {
                TransmitPostEditActivity.this.nMi.setSelection(dUZ);
            }
        }
    };
    private boolean nMI = true;
    private final View.OnFocusChangeListener hcn = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.mMy || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.lwH) {
                if (z) {
                    TransmitPostEditActivity.this.nMI = true;
                    TransmitPostEditActivity.this.dVa();
                    if (TransmitPostEditActivity.this.fnv != null) {
                        TransmitPostEditActivity.this.fnv.bxU();
                    }
                    com.baidu.adp.lib.util.l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.mMy);
                } else if (view == TransmitPostEditActivity.this.mMy) {
                    TransmitPostEditActivity.this.mMD.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.nMi && z) {
                TransmitPostEditActivity.this.nMI = false;
                TransmitPostEditActivity.this.dVa();
                TransmitPostEditActivity.this.fnv.bxU();
                com.baidu.adp.lib.util.l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.nMi);
            }
            TransmitPostEditActivity.this.dVf();
        }
    };
    private TextWatcher nMJ = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String nMN = "";
        private String nMO;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.nMO = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.nMO != null ? this.nMO.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dGA();
            TransmitPostEditActivity.this.dVg();
            EditText dVs = TransmitPostEditActivity.this.dVs();
            if (editable != null && dVs != null && dVs.getText() != null) {
                if (this.nMN == null || !this.nMN.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.nMD != null) {
                        this.nMN = dVs.getText().toString();
                        TransmitPostEditActivity.this.nMD.b(dVs, true);
                        return;
                    }
                    return;
                }
                dVs.setSelection(dVs.getSelectionEnd());
            }
        }
    };
    private TextWatcher nMK = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String nMO;
        private String nMP = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.nMO = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.nMO != null ? this.nMO.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dGA();
            EditText dVr = TransmitPostEditActivity.this.dVr();
            if (editable != null && dVr != null && dVr.getText() != null) {
                int selectionEnd = dVr.getSelectionEnd();
                if (this.nMP == null || !this.nMP.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.nMD != null) {
                        this.nMP = dVr.getText().toString();
                        TransmitPostEditActivity.this.nMD.b(dVr, false);
                        return;
                    }
                    return;
                }
                dVr.setSelection(selectionEnd);
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
    public void bAf() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void bAh() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bAj();
        } else if (this.fpH.dKH()) {
            bAf();
        } else {
            this.fpH.xw(false);
            a(1, true, (String) null);
            this.fpH.dKF();
        }
    }

    private void bAj() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ow(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.a(1, true, (String) null);
                    TransmitPostEditActivity.this.fpH.dKJ();
                } else {
                    TransmitPostEditActivity.this.fpU.bAw();
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
        aVar.bpc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dUZ() {
        int selectionEnd = dVr().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dVr().getText().getSpans(0, dVr().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dVr().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dVr().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVa() {
        if (this.fnv != null) {
            this.fnv.setBarLauncherEnabled(!this.nMI);
            this.fnv.setToolEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nMy) {
            this.mMy.setVisibility(8);
            dGA();
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
        this.fpH = new LocationModel(getPageContext());
        this.fpH.a(this.fpU);
        registerListener(this.mZs);
        registerListener(this.nMG);
        cXB();
        this.nMi.requestFocus();
        dAZ();
        dVz();
    }

    @SuppressLint({"ResourceAsColor"})
    private void cXB() {
        this.fnv = new EditorTools(getActivity());
        this.fnv.setBarMaxLauCount(4);
        this.fnv.setMoreButtonAtEnd(true);
        this.fnv.setBarLauncherType(1);
        this.fnv.kb(true);
        this.fnv.kc(true);
        this.fnv.setBackgroundColorId(R.color.cp_bg_line_h);
        dVb();
        this.fnv.build();
        if (this.nJz) {
            this.fnv.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        }
        if (this.nMg != null) {
            this.nMg.addView(this.fnv);
        }
        cWT();
        this.fnv.display();
        com.baidu.tbadk.editortools.h rh = this.fnv.rh(6);
        if (rh != null && !TextUtils.isEmpty(this.fpM)) {
            ((View) rh).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.fpM);
                }
            });
        }
        if (!this.nMy) {
            this.fnv.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.fnv.bxU();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.fnv.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.fnv.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mMg.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mMg.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        if (!this.nJz) {
            dVd();
        }
    }

    private void dVb() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.fnv.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        if (!this.nJz && this.nMn == null) {
            if (this.nMC == null) {
                this.nMC = new com.baidu.tieba.write.editor.b(getActivity(), this.jld);
                this.nMC.dTH();
                this.nMC.setFrom("from_share_write");
                this.nMC.bQ(this.mMg.getForumId(), this.mPrivateThread);
            }
            this.fnv.b(this.nMC);
        }
        this.fnv.bA(arrayList);
        com.baidu.tbadk.editortools.m rk = this.fnv.rk(5);
        if (rk != null) {
            rk.foi = 1;
            if (this.nJz) {
                rk.ke(false);
            }
        }
    }

    private void cWT() {
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
                            TiebaStatic.log(new aq("c12608").al("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.dVq()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.dVq()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof u)) {
                            TransmitPostEditActivity.this.e((u) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.dVt();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.dGA();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.nMn == null) {
                            TransmitPostEditActivity.this.bAk();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.fpN) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ae.checkLocationForGoogle(pageActivity)) {
                                    TransmitPostEditActivity.this.bAh();
                                    return;
                                } else {
                                    ae.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.bAf();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.fpH != null) {
                            TransmitPostEditActivity.this.fpH.xw(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        aq aqVar = new aq("c10645");
                        if (TransmitPostEditActivity.this.mMg != null) {
                            str = TransmitPostEditActivity.this.mMg.getForumId();
                        } else {
                            str = "";
                        }
                        aqVar.dR("fid", str);
                        TiebaStatic.log(aqVar);
                        if (TransmitPostEditActivity.this.mMg == null || (videoInfo = TransmitPostEditActivity.this.mMg.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.fnv.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.fnv.bzB()) {
                                        TransmitPostEditActivity.this.fnv.bxU();
                                        TransmitPostEditActivity.this.fnv.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.fnv.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.fnv.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.fnv.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.fnv.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mMg.setVideoInfo(null);
                        TransmitPostEditActivity.this.dGA();
                        if (TransmitPostEditActivity.this.nMi != null) {
                            TransmitPostEditActivity.this.nMi.requestFocus();
                        }
                        TransmitPostEditActivity.this.fnv.bxU();
                        TransmitPostEditActivity.this.fnv.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.nMi);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.fnv.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.nMd = true;
                        TransmitPostEditActivity.this.yH(true);
                        if (TransmitPostEditActivity.this.dVs().isFocused()) {
                            TransmitPostEditActivity.this.nMc = "from_title";
                        } else if (TransmitPostEditActivity.this.dVr().isFocused()) {
                            TransmitPostEditActivity.this.nMc = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.nMh.setVisibility(0);
                        TransmitPostEditActivity.this.nMh.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.nMh.hasFocus()) {
                            TransmitPostEditActivity.this.nMi.requestFocus();
                            TransmitPostEditActivity.this.nMi.setSelection(TransmitPostEditActivity.this.nMi.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.nMh.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.fnv.setActionListener(31, bVar);
        this.fnv.setActionListener(16, bVar);
        this.fnv.setActionListener(14, bVar);
        this.fnv.setActionListener(24, bVar);
        this.fnv.setActionListener(3, bVar);
        this.fnv.setActionListener(10, bVar);
        this.fnv.setActionListener(11, bVar);
        this.fnv.setActionListener(12, bVar);
        this.fnv.setActionListener(13, bVar);
        this.fnv.setActionListener(15, bVar);
        this.fnv.setActionListener(18, bVar);
        this.fnv.setActionListener(20, bVar);
        this.fnv.setActionListener(25, bVar);
        this.fnv.setActionListener(27, bVar);
        this.fnv.setActionListener(29, bVar);
        this.fnv.setActionListener(43, bVar);
        this.fnv.setActionListener(45, bVar);
        this.fnv.setActionListener(53, bVar);
        this.fnv.setActionListener(48, bVar);
        this.fnv.setActionListener(46, bVar);
        this.fnv.setActionListener(49, bVar);
        this.fnv.setActionListener(47, bVar);
        this.fnv.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAk() {
        if (this.fpH.cin()) {
            if (this.fpH.dKH()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.b.dKC().getLocationData().getFormatted_address());
                return;
            }
            a(1, true, (String) null);
            this.fpH.dKF();
            return;
        }
        a(0, true, (String) null);
    }

    protected void dGs() {
        if (this.fpI != null) {
            this.fpI.cancelLoadData();
        }
        if (this.nMj != null) {
            this.nMj.cancelLoadData();
        }
        if (this.fpH != null) {
            this.fpH.cancelLoadData();
        }
    }

    private void dVc() {
        if (this.nME != null) {
            this.nME.hideTip();
        }
    }

    private void dVd() {
        if (this.nME == null) {
            this.nME = new g(getPageContext());
        }
        this.nME.d(this.fnv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dVc();
        TiebaPrepareImageService.StopService();
        dGs();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVe() {
        if (this.mMg == null) {
            finish();
            return;
        }
        this.mMg.setTitle(dVs().getText().toString());
        this.mMg.setContent(dVr().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.mME != null && this.mME.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mME, getPageContext().getPageActivity());
                return true;
            } else if (this.fnv.bzB()) {
                this.fnv.bxU();
                return true;
            } else {
                dGs();
                dVe();
                return true;
            }
        }
        if (i == 67 && (text = dVr().getText()) != null) {
            int selectionStart = dVr().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dVr().onKeyDown(67, this.itr);
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
        getLayoutMode().onModeChanged(this.jVp);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.lwH, R.color.cp_link_tip_a, 1);
        dVa();
        ap.setBackgroundColor(this.mMz, R.color.cp_bg_line_c);
        ap.setBackgroundColor(dVs(), R.color.cp_bg_line_d);
        ap.setBackgroundColor(dVr(), R.color.cp_bg_line_d);
        dGA();
        this.fnv.onChangeSkinType(i);
        if (this.nMw != null) {
            this.nMw.bsD();
        }
        ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        dVf();
        dVg();
        if (this.nMD != null) {
            this.nMD.c(dVs(), dVr());
        }
        if (this.aij != null) {
            this.aij.onChangeSkinType();
        }
        if (this.nJV != null) {
            this.nJV.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVf() {
        if (this.mMy.hasFocus()) {
            this.mMy.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        } else {
            this.mMy.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        }
        if (this.nMi.hasFocus()) {
            this.nMi.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        } else {
            this.nMi.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVg() {
        if (this.mMy != null) {
            if (this.mMy.getText().toString().length() == 0) {
                this.mMy.getPaint().setFakeBoldText(false);
            } else if (this.mMy.getText().toString().length() > 0) {
                this.mMy.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.fxS = new com.baidu.tbadk.core.view.a(getPageContext());
        this.nMy = this.mMg.getType() == 4 || 5 == this.mMg.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.brn().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        dVj();
        this.nMx = (ScrollView) findViewById(R.id.write_scrollview);
        this.nMx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.nMi != null) {
                        com.baidu.adp.lib.util.l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.nMi);
                    }
                    if (TransmitPostEditActivity.this.fnv != null) {
                        TransmitPostEditActivity.this.fnv.bxU();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jVp = (RelativeLayout) findViewById(R.id.parent);
        this.nMg = (LinearLayout) findViewById(R.id.tool_view);
        this.nMg.setContentDescription(IStringUtil.TOP_PATH);
        this.nMh = (LinearLayout) findViewById(R.id.title_view);
        this.mMz = findViewById(R.id.interval_view);
        this.nMA = (TextView) findViewById(R.id.hot_topic_title_edt);
        dGz();
        if (this.nMy) {
            this.nMx.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        dGB();
        dVp();
        this.mMB = (LinearLayout) findViewById(R.id.post_content_container);
        this.mMB.setDrawingCacheEnabled(false);
        this.mMB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.fnv.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.nMi.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.hcn);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.dGs();
                TransmitPostEditActivity.this.dVe();
            }
        });
        dVm();
        dVo();
        dVi();
        dVa();
        dVn();
        dGy();
        dVu();
        dVh();
        if (this.mMg.getType() == 4 && this.mMG != null && this.nMk != null) {
            this.mMG.setVisibility(8);
            this.nMk.setVisibility(8);
        }
        dGA();
        ShowSoftKeyPad(this.mInputManager, this.mMy);
    }

    private void dVh() {
        this.nJV = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.nJV.setData(this.nFC);
        this.nJV.setActivity(this);
    }

    private void dVi() {
        String str;
        String str2;
        if (this.mMg != null) {
            switch (this.mMg.getType()) {
                case 0:
                case 9:
                    if (this.jld != null && this.jld.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                        if (this.nJz) {
                            this.mName.setText(R.string.transmit_to_dynamic_title);
                        }
                    } else if (this.jld != null && this.jld.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.mMg.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.mMy.setVisibility(0);
                    this.nMi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.nMi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.nMi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.mMy.setVisibility(8);
                    return;
            }
        }
    }

    private void dVj() {
        if (this.nJz) {
            this.lwH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.dynamic_publish));
        } else {
            this.lwH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lwH.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.lwH.setLayoutParams(layoutParams);
        this.lwH.setOnFocusChangeListener(this.hcn);
    }

    private void dVk() {
        if (this.mMg != null && this.mMg.getType() == 0 && this.mMg.getType() == 9 && !this.nMf && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = at.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dVs() != null) {
                dVs().setText(cutStringWithSuffix);
                dVs().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void dVl() {
        this.guN = null;
        this.nMt = -1;
        this.nMv = -1;
        com.baidu.tieba.frs.ah ze = ag.cAo().ze(1);
        if (ze != null) {
            this.guN = ze.iLR;
            this.nMt = getIntent().getIntExtra("category_id", -1);
            if (this.guN != null && !this.guN.isEmpty() && this.nMt >= 0) {
                this.nMs = new af();
                this.nMs.iLN = 0;
                this.nMs.name = getPageContext().getResources().getString(R.string.category_auto);
                this.nMv = this.nMs.iLN;
                this.nMu = this.nMs.name;
                for (af afVar : this.guN) {
                    if (afVar.iLN == this.nMt) {
                        this.nMv = afVar.iLN;
                        this.nMu = afVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dVm() {
        if (this.guN != null && !this.guN.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.nMw = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.nMw.setText(this.nMu);
            this.nMw.setCategoryContainerData(this.guN, this.nMs, this.nMv);
            this.nMw.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bf bfVar) {
                    if (bfVar != null) {
                        TransmitPostEditActivity.this.nMw.setText(bfVar.name);
                        TransmitPostEditActivity.this.mMg.setCategoryTo(bfVar.iLN);
                        TransmitPostEditActivity.this.nMv = bfVar.iLN;
                        TransmitPostEditActivity.this.nMw.dUD();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.nMw.dUC();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dVs());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dVr());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.nML = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.nML.setTitle(R.string.no_disturb_start_time);
        this.nML.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.nML);
        this.nML.setButton(-2, getPageContext().getString(R.string.cancel), this.nML);
        return this.nML;
    }

    private void dVn() {
        this.nMo = (RelativeLayout) findViewById(R.id.addition_container);
        this.nMp = (TextView) findViewById(R.id.addition_create_time);
        this.nMq = (TextView) findViewById(R.id.addition_last_time);
        this.nMr = (TextView) findViewById(R.id.addition_last_content);
        if (this.nMn != null) {
            this.nMo.setVisibility(0);
            this.nMp.setText(getPageContext().getString(R.string.write_addition_create) + at.getFormatTime(this.nMn.getCreateTime() * 1000));
            if (this.nMn.getAlreadyCount() == 0) {
                this.nMq.setVisibility(8);
            } else {
                this.nMq.setText(getPageContext().getString(R.string.write_addition_last) + at.getFormatTime(this.nMn.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.nMn.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.nMr.setText(lastAdditionContent);
            } else {
                this.nMr.setVisibility(8);
            }
            dVr().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.nMn.getAlreadyCount()), Integer.valueOf(this.nMn.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.nMo.setVisibility(8);
    }

    private void dGy() {
        this.mMG = findViewById(R.id.post_prefix_layout);
        this.mMD = (TextView) findViewById(R.id.post_prefix);
        this.nMk = findViewById(R.id.prefix_divider);
        this.mMF = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.mMG.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.mMh = 1;
            this.mMG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.mMD.setVisibility(0);
                    TransmitPostEditActivity.this.mMG.setSelected(true);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.mME, view, 0, com.baidu.adp.lib.util.l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.fnv.bxU();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.mMy);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.nMi);
                }
            });
            this.mMF = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.mMF.setVisibility(0);
                this.mMD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.mMD.setSelected(true);
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.mME, view, 0, com.baidu.adp.lib.util.l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.fnv.bxU();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dVs());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dVr());
                    }
                });
            }
            this.mME = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.mME.a(this);
            this.mME.setMaxHeight(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds510));
            this.mME.setOutsideTouchable(true);
            this.mME.setFocusable(true);
            this.mME.setOnDismissListener(this);
            this.mME.setBackgroundDrawable(ap.getDrawable(R.color.cp_bg_line_d));
            int color = ap.getColor(R.color.cp_cont_b);
            int color2 = ap.getColor(R.color.cp_cont_c);
            ap.setBackgroundResource(this.mMD, R.color.cp_bg_line_d);
            ap.setImageResource(this.mMF, R.drawable.icon_frs_arrow_n);
            this.mMD.setTextColor(color);
            this.nMl.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.nMl.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.mME.addView(writePrefixItemLayout);
            }
            this.mME.setCurrentIndex(0);
            this.mMD.setText(prefixs.get(1));
            LF(1);
            return;
        }
        this.mMG.setVisibility(8);
    }

    protected void dVo() {
        this.lwH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick() && !TransmitPostEditActivity.this.dVA()) {
                    if (TransmitPostEditActivity.this.nMD.a(TransmitPostEditActivity.this.mMy, TransmitPostEditActivity.this.nMi)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.nMD.dSX());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dVs());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dVr());
                    TransmitPostEditActivity.this.fnv.bxU();
                    TiebaStatic.log(new aq("c12608").al("obj_locate", 7));
                    TransmitPostEditActivity.this.dVx();
                }
            }
        });
    }

    protected void dGz() {
        this.mMy = (EditText) findViewById(R.id.post_title);
        this.mMy.setOnClickListener(this.nMH);
        this.mMy.setOnFocusChangeListener(this.hcn);
        if ((this.mMg.getType() == 0 || this.mMg.getType() == 9 || this.mMg.getType() == 7) && this.mMg.getTitle() != null) {
            this.mMy.setText(this.mMg.getTitle());
            this.mMy.setSelection(this.mMg.getTitle().length());
        }
        this.mMy.addTextChangedListener(this.nMJ);
        if (!this.mMg.getHaveDraft()) {
            dVk();
        }
        this.mMy.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void dGB() {
        this.nMi = (SpanGroupEditText) findViewById(R.id.post_content);
        this.nMi.setDrawingCacheEnabled(false);
        this.nMi.setOnClickListener(this.nMH);
        this.nMi.setTransLink(!this.nJz);
        if (this.fpI != null) {
            this.fpI.setSpanGroupManager(this.nMi.getSpanGroupManager());
        }
        if (this.mMg != null) {
            this.mMg.setSpanGroupManager(this.nMi.getSpanGroupManager());
        }
        if (this.mMg.getContent() != null && this.mMg.getContent().length() > 0) {
            this.nMi.setText(TbFaceManager.bBc().aw(getPageContext().getPageActivity(), this.mMg.getContent()));
            this.nMi.setSelection(this.nMi.getText().length());
        }
        if (!at.isEmpty(this.iFf)) {
            this.nMi.setSelection(0);
        }
        this.nMi.setOnFocusChangeListener(this.hcn);
        this.nMi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.fnv.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.nMi.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.nMi.addTextChangedListener(this.nMK);
        if (this.nJz) {
            this.nMi.setHint(R.string.dynamic_transmit_publish_edit_str);
        } else if (this.nMe != null && this.nMe.showType == 3) {
            this.nMi.setHint(R.string.share_video_default);
        } else {
            this.nMi.setHint(R.string.share_txt_default);
        }
    }

    private void dVp() {
        this.aij = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aij.getLayoutParams();
        layoutParams.topMargin -= joB;
        layoutParams.leftMargin = fIe;
        layoutParams.rightMargin = fIe;
        this.aij.setLayoutParams(layoutParams);
        this.aij.setVisibility(0);
        this.aij.a(this.nMe);
        this.aij.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dVq() {
        int i = 5000;
        if (this.nMn != null) {
            i = 1000;
        }
        return dVr().getText() != null && dVr().getText().length() >= i;
    }

    private void DJ(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.nMc)) {
                this.nMc = "";
                dVr().requestFocus();
                if (dVr().getText() != null && dVr().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dVr().getSelectionStart();
                    editable = dVr().getText();
                }
            } else if ("from_title".equals(this.nMc)) {
                this.nMc = "";
                dVs().requestFocus();
                if (dVs().getText() != null && dVs().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dVs().getSelectionStart();
                    editable = dVs().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yH(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mMg != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.mMg.getForumId(), 0L), this.mMg.getFirstDir(), this.mMg.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(u uVar) {
        if (((ImageSpan[]) dVr().getText().getSpans(0, dVr().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.nMm == null) {
                this.nMm = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.nMm.getView().isShown()) {
                this.nMm.cancel();
            }
            this.nMm.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, uVar, dVr());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dVr() {
        return this.nMi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dVs() {
        return this.mMy;
    }

    protected void dVt() {
        if (dVr().getSelectionStart() > 0) {
            String substring = dVr().getText().toString().substring(0, dVr().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.itq.matcher(substring);
            if (matcher.find()) {
                dVr().getText().delete(dVr().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dVr().getSelectionStart());
                return;
            }
            dVr().onKeyDown(67, this.itr);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.fxS.setCancelListener(null);
        this.fxS.setTipString(R.string.sending);
        this.fxS.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.fxS.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGA() {
        if (this.mMg != null) {
            String str = "";
            String str2 = "";
            if (dVs() != null) {
                str = dVs().getText().toString();
            }
            if (dVr() != null) {
                str2 = dVr().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mMg.getType() == 0 || this.mMg.getType() == 9 || this.mMg.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.mMh == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mMg.setIsNoTitle(true);
                        } else {
                            this.mMg.setIsNoTitle(false);
                            yI(true);
                            return;
                        }
                    } else {
                        this.mMg.setIsNoTitle(false);
                        yI(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mMg.setIsNoTitle(true);
                } else {
                    this.mMg.setIsNoTitle(false);
                    yI(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.nMy) {
                    yI(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    yI(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                yI(true);
            } else if (this.mMg.getVideoInfo() != null) {
                yI(true);
            } else {
                yI(false);
            }
        }
    }

    private void yI(boolean z) {
        ap.setNavbarTitleColor(this.lwH, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.fpI = new NewWriteModel(this);
        this.fpI.b(this.fpW);
        this.iyf = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.dGs();
            }
        };
        this.mMg = new WriteData();
        if (bundle != null) {
            this.mMg.setType(bundle.getInt("type", 0));
            this.mMg.setForumId(bundle.getString("forum_id"));
            this.mMg.setForumName(bundle.getString("forum_name"));
            this.mMg.setFirstDir(bundle.getString("forum_first_dir"));
            this.mMg.setSecondDir(bundle.getString("forum_second_dir"));
            this.mMg.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.nMn = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mMg.setIsAddition(this.nMn != null);
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
            this.mMg.setTitle(bundle.getString("write_title"));
            this.mMg.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.jld = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.nMe = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.ShareInfo.class);
            }
            this.mBaijiahaoData = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.iFf = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.iFg = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.nFC = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.mMg.mDynamicForwardData = (ForwardUploadData) bundle.getSerializable(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA);
            str = string;
        } else {
            Intent intent = getIntent();
            this.mMg.setType(intent.getIntExtra("type", 0));
            this.mMg.setForumId(intent.getStringExtra("forum_id"));
            this.mMg.setForumName(intent.getStringExtra("forum_name"));
            this.mMg.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.mMg.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.mMg.setThreadId(intent.getStringExtra("thread_id"));
            this.nMn = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mMg.setIsAddition(this.nMn != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mMg.setTitle(intent.getStringExtra("write_title"));
            this.mMg.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.jld = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.nMe = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            this.mMg.mDynamicForwardData = (ForwardUploadData) intent.getSerializableExtra(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA);
            this.iFf = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.iFg = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.nFC = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (this.mMg.mDynamicForwardData != null) {
            this.nJz = true;
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.mMg.getType() == 4 ? 6 : 9);
        this.mMg.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.nMe != null && this.nMe.videoId != null) {
            this.mMg.setVideoId(this.nMe.videoId);
            this.mMg.setOriginalVideoCover(this.nMe.showPicUrl);
            this.mMg.setOriginalVideoTitle(this.nMe.showText);
        }
        if (!at.isEmpty(this.iFf)) {
            if (!at.isEmpty(this.iFg)) {
                this.mMg.setContent("//@" + this.iFg + " :" + this.iFf);
            } else {
                this.mMg.setContent(this.iFf);
            }
        }
        if (this.mMg != null && this.mMg.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mMg.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.nMf = true;
        }
        dVl();
    }

    private void dVu() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) y.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.mMy.setText(com.baidu.tbadk.plugins.b.Eo(com.baidu.tbadk.plugins.b.Ep(hotTopicBussinessData.mTopicName)));
            this.mMy.setMovementMethod(com.baidu.tieba.view.c.dSy());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString Eo = com.baidu.tbadk.plugins.b.Eo(com.baidu.tbadk.plugins.b.Ep(hotTopicBussinessData.mTopicName));
            if (Eo != null) {
                this.mMy.setText(Eo);
            }
            this.nMA.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.mMg.getType());
        bundle.putString("forum_id", this.mMg.getForumId());
        bundle.putString("forum_name", this.mMg.getForumName());
        bundle.putString("forum_first_dir", this.mMg.getFirstDir());
        bundle.putString("forum_second_dir", this.mMg.getSecondDir());
        bundle.putString("thread_id", this.mMg.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jld);
        bundle.putSerializable("tab_list", this.nFC);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.nMn != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.nMn));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jld);
        if (this.mMg.mDynamicForwardData != null) {
            bundle.putSerializable(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA, this.mMg.mDynamicForwardData);
        }
        if (this.nMe != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.nMe));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dVr().getEditableText().toString();
        if (obj != null) {
            dVr().setText(TbFaceManager.bBc().a(getPageContext().getPageActivity(), obj, this.nMF));
            dVr().setSelection(dVr().getText().length());
        }
    }

    private String dVv() {
        if (dVr() == null || dVr().getText() == null) {
            return "";
        }
        String obj = dVr().getText().toString();
        if (StringUtils.isNull(obj)) {
            if (this.nMe != null && this.nMe.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return obj;
    }

    private String dVw() {
        if (this.mMg == null || dVs() == null || dVs().getVisibility() != 0 || dVs().getText() == null) {
            return "";
        }
        String obj = dVs().getText().toString();
        if (this.mPrefixData != null && y.getCount(this.mPrefixData.getPrefixs()) > 0 && this.mMh != 0 && this.mMg.getType() != 4 && this.mMD != null && this.mMD.getText() != null) {
            obj = this.mMD.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            obj = this.mPrefixData.getImplicitTitle() + this.mMg.getTitle();
        }
        if (TextUtils.isEmpty(obj)) {
            return getString(R.string.share_txt_default);
        }
        return obj;
    }

    private void cCy() {
        if (this.mMg != null && this.mMg.mDynamicForwardData != null) {
            dUk();
            return;
        }
        dGs();
        this.mMg.setContent(dVv());
        this.mMg.setTitle(dVw());
        if (this.nMt >= 0) {
            this.mMg.setCategoryFrom(this.nMt);
        }
        if (this.nMv >= 0) {
            this.mMg.setCategoryTo(this.nMv);
        }
        this.mMg.setWriteImagesInfo(this.writeImagesInfo);
        this.mMg.setHasLocationData(this.fpH != null && this.fpH.cin());
        this.fpI.xy(this.writeImagesInfo.size() > 0);
        if (!y.isEmpty(this.mList) && this.nMz != null && this.nMz.mIsGlobalBlock == 0) {
            this.mMg.setForumId(String.valueOf(this.nMz.mForumId));
            this.mMg.setForumName(this.nMz.mForumName);
        }
        dUl();
        this.fpI.e(this.mMg);
        this.mMg.setContent(this.mMg.getContent().replaceAll("\u0000\n", ""));
        this.mMg.setContent(this.mMg.getContent().replaceAll("\u0000", ""));
        this.mMg.setVcode(null);
        this.fpI.cXW().setVoice(null);
        this.fpI.cXW().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.iyf);
        this.fpI.dLm();
    }

    private void dUl() {
        FrsTabItemData selectedTabItemData;
        if (this.mMg != null && this.nJV != null && (selectedTabItemData = this.nJV.getSelectedTabItemData()) != null) {
            this.mMg.setTabId(selectedTabItemData.tabId);
            this.mMg.setTabName(selectedTabItemData.name);
            this.mMg.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    private void dUk() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        this.mMg.mDynamicForwardData.forward_content = dVv();
        this.mMg.mDynamicForwardData.inputText = dVv();
        this.mMg.mDynamicForwardData.locationPoiId = "0";
        showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
        com.baidu.tieba.write.b.c.b.dTT().a(this.mMg.mDynamicForwardData, new b.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // com.baidu.tieba.write.b.c.b.a
            public void onSuccess(String str) {
                TransmitPostEditActivity.this.closeLoadingDialog();
                com.baidu.tieba.tbadkCore.writeModel.c.g(TransmitPostEditActivity.this.getPageContext().getPageActivity(), null, null, null);
                TransmitPostEditActivity.this.km(true);
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

    private void H(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.nMn != null) {
                i2 = this.nMn.getTotalCount();
                i = this.nMn.getAlreadyCount() + 1;
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
                if (this.fnv != null && !this.fnv.bzB()) {
                    dVr().requestFocus();
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
                            dVr().getText().insert(dVr().getSelectionStart(), sb.toString());
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
                        if (this.nMd) {
                            sb2.append(com.baidu.tbadk.plugins.b.fxl);
                            this.nMd = false;
                        }
                        sb2.append(stringExtra);
                        DJ(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !y.isEmpty(this.mList) && !y.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.nMz = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.nMz);
            }
        } else if (i2 == 0) {
            if (this.fnv != null && !this.fnv.bzB()) {
                this.nMi.requestFocus();
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
                        this.nMD.UA(postWriteCallBackData.getErrorString());
                        this.nMD.bk(postWriteCallBackData.getSensitiveWords());
                        this.nMD.b(this.mMy, this.nMi);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.nMc)) {
                        dVs().requestFocus();
                        return;
                    } else if ("from_content".equals(this.nMc)) {
                        dVr().requestFocus();
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
    public void dVx() {
        if ("1".equals(this.jld)) {
            this.mMg.setCanNoForum(true);
            this.mMg.setTransmitForumData("[]");
        } else if ("2".equals(this.jld)) {
            this.mMg.setCanNoForum(false);
        }
        dVy();
        this.mMg.setPrivacy(this.isPrivacy);
        this.mMg.setIsShareThread(true);
        if (this.nMe != null && !StringUtils.isNull(this.nMe.threadId)) {
            this.mMg.setOriginalThreadId(this.nMe.threadId);
        }
        this.mMg.setBaijiahaoData(this.mBaijiahaoData);
        if (this.nMe != null) {
            this.mMg.setOriBaijiahaoData(this.nMe.oriUgcInfo);
        }
        this.mMg.setCallFrom(this.jld);
        cCy();
    }

    private void dVy() {
        if (this.fnv != null) {
            this.fnv.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dVs());
        HidenSoftKeyPad(this.mInputManager, dVr());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bR(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.iIK) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ax.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mMg.getType() != 7) {
                if (this.nMn == null) {
                    if (!d(postWriteCallBackData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        return;
                    }
                    return;
                }
                H(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.fpN = i;
        if (this.fnv != null) {
            this.fnv.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void dVz() {
        if (!this.nMy && this.fnv != null) {
            this.fnv.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.fnv.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void km(boolean z) {
        if (this.fnv != null) {
            this.fnv.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void LF(int i) {
        if (i < this.nMl.size()) {
            for (int i2 = 0; i2 < this.nMl.size(); i2++) {
                this.nMl.get(i2).yu(false);
            }
            this.nMl.get(i).yu(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void Jh(int i) {
        this.mMh = i;
        this.mME.setCurrentIndex(i);
        LF(i);
        this.mMD.setText(this.mPrefixData.getPrefixs().get(i));
        dGA();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.mME, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.mMG.setSelected(false);
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
        if (this.mMg != null) {
            if (this.mMg.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.mMg.getType() == 5) {
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
            bAh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.bmZ = z;
        if (this.nMC != null && !z) {
            this.nMC.csl();
        }
        if (this.nME != null && !z) {
            dVc();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.bmZ && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.nMd = false;
            this.nMc = "";
            if ("from_content".equals(str)) {
                this.nMc = "from_content";
            } else if ("from_title".equals(str)) {
                this.nMc = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.En(String.valueOf(charSequence.charAt(i)))) {
                yH(false);
            }
        }
    }

    public void dAZ() {
        if (!y.isEmpty(this.mList)) {
            this.nMh.setVisibility(0);
            this.nMh.requestFocus();
            return;
        }
        this.nMh.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dVA() {
        if (((ImageSpan[]) dVr().getText().getSpans(0, dVr().getText().length(), ImageSpan.class)).length > 10) {
            if (this.nMm == null) {
                this.nMm = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.nMm.getView().isShown()) {
                this.nMm.cancel();
            }
            this.nMm.show();
            return true;
        }
        return false;
    }
}
