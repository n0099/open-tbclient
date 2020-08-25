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
import com.baidu.tbadk.coreExtra.data.ag;
import com.baidu.tbadk.coreExtra.data.t;
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
import com.baidu.tieba.frs.ah;
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
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0210a, i.a {
    private OriginalThreadCardView ahu;
    private EditorTools eKD;
    private LocationModel eMo;
    private NewWriteModel eMp;
    List<af> fPp;
    private String hQF;
    private String hQG;
    private boolean isPrivacy;
    private TextView lUD;
    private com.baidu.tieba.write.i lUE;
    private ImageView lUF;
    private View lUG;
    private int lUh;
    private BaijiahaoData mBaijiahaoData;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private FrsTabInfoData mNu;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private ForumTabSelectedView mRT;
    private com.baidu.tieba.write.editor.b mUA;
    private g mUC;
    private com.baidu.tieba.view.b mUJ;
    private OriginalThreadInfo.ShareInfo mUb;
    private LinearLayout mUd;
    private LinearLayout mUe;
    private View mUh;
    private Toast mUj;
    private AdditionData mUl;
    private RelativeLayout mUm;
    private TextView mUn;
    private TextView mUo;
    private TextView mUp;
    af mUq;
    private int mUr;
    private String mUs;
    private int mUt;
    private PostCategoryView mUu;
    private HotTopicBussinessData mUx;
    private TextView mUy;
    private static final int izP = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    private static final int feH = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44);
    private String mTZ = "";
    private boolean mUa = false;
    private WriteData lUg = null;
    private boolean mUc = false;
    private InputMethodManager mInputManager = null;
    private EditText lUy = null;
    private View lUz = null;
    private LinearLayout lUB = null;
    private SpanGroupEditText mUf = null;
    private FeedBackModel mUg = null;
    private ArrayList<WritePrefixItemLayout> mUi = new ArrayList<>();
    private final KeyEvent hEQ = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView kGp = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener hJE = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout jfk = null;
    private String eMt = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int eMu = 0;
    private View mRootView = null;
    private ScrollView mUv = null;
    private boolean mUw = false;
    private com.baidu.tbadk.core.view.a eUv = null;
    private String mFrom = "write";
    private String iwr = "2";
    private SpannableStringBuilder mUz = new SpannableStringBuilder();
    private boolean bdD = false;
    private final c mUB = new c();
    private boolean mRx = false;
    private TbFaceManager.a mUD = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan Cj(String str) {
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
    private final AntiHelper.a hUk = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d eMD = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.lUg != null) {
                TransmitPostEditActivity.this.mUB.bf(null);
                if (z) {
                    TransmitPostEditActivity.this.jp(z);
                    TransmitPostEditActivity.this.c(true, postWriteCallBackData);
                    TransmitPostEditActivity.this.l(postWriteCallBackData);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    TransmitPostEditActivity.this.setResult(-1, intent);
                    TransmitPostEditActivity.this.finish();
                } else if (postWriteCallBackData.isSensitiveError()) {
                    TransmitPostEditActivity.this.showToast(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.mUB.Sw(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.mUB.bf(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.mUB.b(TransmitPostEditActivity.this.lUy, TransmitPostEditActivity.this.mUf);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.c(TransmitPostEditActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(TransmitPostEditActivity.this.getActivity());
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.zz(TransmitPostEditActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.zz(postWriteCallBackData.getErrorString());
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
                            TiebaStatic.log(new aq("c13746").ai("obj_locate", 1).ai("obj_type", 1));
                        }
                    });
                    aVar.b(TransmitPostEditActivity.this.getPageContext()).bhg();
                    TiebaStatic.log(new aq("c13745").ai("obj_locate", 1).ai("obj_type", 1));
                } else if ((agVar == null || writeData == null || agVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (agVar != null && writeData != null && agVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(agVar.getVcode_md5());
                    writeData.setVcodeUrl(agVar.getVcode_pic_url());
                    writeData.setVcodeExtra(agVar.bmZ());
                    if (com.baidu.tbadk.t.a.CO(agVar.bmY())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, agVar.bmY())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a eMB = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bsp() {
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
    private final CustomMessageListener mhn = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.eMo.we(false);
                    TransmitPostEditActivity.this.eMo.fU(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.eMo.we(true);
                TransmitPostEditActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener mUE = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener mUF = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.eKD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dHB = TransmitPostEditActivity.this.dHB();
            if (dHB >= 0 && dHB < TransmitPostEditActivity.this.mUf.getText().length()) {
                TransmitPostEditActivity.this.mUf.setSelection(dHB);
            }
        }
    };
    private boolean mUG = true;
    private final View.OnFocusChangeListener gsB = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.lUy || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.kGp) {
                if (z) {
                    TransmitPostEditActivity.this.mUG = true;
                    TransmitPostEditActivity.this.dHC();
                    if (TransmitPostEditActivity.this.eKD != null) {
                        TransmitPostEditActivity.this.eKD.bpX();
                    }
                    com.baidu.adp.lib.util.l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.lUy);
                } else if (view == TransmitPostEditActivity.this.lUy) {
                    TransmitPostEditActivity.this.lUD.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.mUf && z) {
                TransmitPostEditActivity.this.mUG = false;
                TransmitPostEditActivity.this.dHC();
                TransmitPostEditActivity.this.eKD.bpX();
                com.baidu.adp.lib.util.l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.mUf);
            }
            TransmitPostEditActivity.this.dHH();
        }
    };
    private TextWatcher mUH = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String mUL = "";
        private String mUM;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mUM = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.mUM != null ? this.mUM.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dth();
            TransmitPostEditActivity.this.dHI();
            EditText dHU = TransmitPostEditActivity.this.dHU();
            if (editable != null && dHU != null && dHU.getText() != null) {
                if (this.mUL == null || !this.mUL.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.mUB != null) {
                        this.mUL = dHU.getText().toString();
                        TransmitPostEditActivity.this.mUB.b(dHU, true);
                        return;
                    }
                    return;
                }
                dHU.setSelection(dHU.getSelectionEnd());
            }
        }
    };
    private TextWatcher mUI = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String mUM;
        private String mUN = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mUM = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.mUM != null ? this.mUM.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dth();
            EditText dHT = TransmitPostEditActivity.this.dHT();
            if (editable != null && dHT != null && dHT.getText() != null) {
                int selectionEnd = dHT.getSelectionEnd();
                if (this.mUN == null || !this.mUN.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.mUB != null) {
                        this.mUN = dHT.getText().toString();
                        TransmitPostEditActivity.this.mUB.b(dHT, false);
                        return;
                    }
                    return;
                }
                dHT.setSelection(selectionEnd);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void l(PostWriteCallBackData postWriteCallBackData) {
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
    public void brY() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void bsa() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bsc();
        } else if (this.eMo.dxn()) {
            brY();
        } else {
            this.eMo.we(false);
            a(1, true, (String) null);
            this.eMo.dxl();
        }
    }

    private void bsc() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nt(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.a(1, true, (String) null);
                    TransmitPostEditActivity.this.eMo.dxp();
                } else {
                    TransmitPostEditActivity.this.eMB.bsp();
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
        aVar.bhg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dHB() {
        int selectionEnd = dHT().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dHT().getText().getSpans(0, dHT().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dHT().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dHT().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHC() {
        if (this.eKD != null) {
            this.eKD.setBarLauncherEnabled(!this.mUG);
            this.eKD.setToolEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mUw) {
            this.lUy.setVisibility(8);
            dth();
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
        this.eMo = new LocationModel(getPageContext());
        this.eMo.a(this.eMB);
        registerListener(this.mhn);
        registerListener(this.mUE);
        cKE();
        this.mUf.requestFocus();
        dnT();
        dIb();
    }

    @SuppressLint({"ResourceAsColor"})
    private void cKE() {
        this.eKD = new EditorTools(getActivity());
        this.eKD.setBarMaxLauCount(4);
        this.eKD.setMoreButtonAtEnd(true);
        this.eKD.setBarLauncherType(1);
        this.eKD.jh(true);
        this.eKD.ji(true);
        this.eKD.setBackgroundColorId(R.color.cp_bg_line_h);
        dHD();
        this.eKD.build();
        if (this.mRx) {
            this.eKD.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        }
        if (this.mUd != null) {
            this.mUd.addView(this.eKD);
        }
        cJW();
        this.eKD.display();
        com.baidu.tbadk.editortools.h qb = this.eKD.qb(6);
        if (qb != null && !TextUtils.isEmpty(this.eMt)) {
            ((View) qb).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.eMt);
                }
            });
        }
        if (!this.mUw) {
            this.eKD.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.eKD.bpX();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.eKD.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.eKD.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.lUg.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.lUg.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        if (!this.mRx) {
            dHF();
        }
    }

    private void dHD() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.eKD.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        if (!this.mRx && this.mUl == null) {
            if (this.mUA == null) {
                this.mUA = new com.baidu.tieba.write.editor.b(getActivity(), this.iwr);
                this.mUA.dGk();
                this.mUA.setFrom("from_share_write");
                this.mUA.bM(this.lUg.getForumId(), this.mPrivateThread);
            }
            this.eKD.b(this.mUA);
        }
        this.eKD.bc(arrayList);
        com.baidu.tbadk.editortools.m qe = this.eKD.qe(5);
        if (qe != null) {
            qe.eLq = 1;
            if (this.mRx) {
                qe.jk(false);
            }
        }
    }

    private void cJW() {
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
                            TiebaStatic.log(new aq("c12608").ai("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.dHS()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.dHS()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof t)) {
                            TransmitPostEditActivity.this.e((t) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.dHV();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.dth();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.mUl == null) {
                            TransmitPostEditActivity.this.bsd();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.eMu) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ae.checkLocationForGoogle(pageActivity)) {
                                    TransmitPostEditActivity.this.bsa();
                                    return;
                                } else {
                                    ae.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.brY();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.eMo != null) {
                            TransmitPostEditActivity.this.eMo.we(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        aq aqVar = new aq("c10645");
                        if (TransmitPostEditActivity.this.lUg != null) {
                            str = TransmitPostEditActivity.this.lUg.getForumId();
                        } else {
                            str = "";
                        }
                        aqVar.dD("fid", str);
                        TiebaStatic.log(aqVar);
                        if (TransmitPostEditActivity.this.lUg == null || (videoInfo = TransmitPostEditActivity.this.lUg.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.eKD.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.eKD.brx()) {
                                        TransmitPostEditActivity.this.eKD.bpX();
                                        TransmitPostEditActivity.this.eKD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.eKD.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.eKD.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.eKD.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.eKD.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.lUg.setVideoInfo(null);
                        TransmitPostEditActivity.this.dth();
                        if (TransmitPostEditActivity.this.mUf != null) {
                            TransmitPostEditActivity.this.mUf.requestFocus();
                        }
                        TransmitPostEditActivity.this.eKD.bpX();
                        TransmitPostEditActivity.this.eKD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.mUf);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.eKD.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.mUa = true;
                        TransmitPostEditActivity.this.xp(true);
                        if (TransmitPostEditActivity.this.dHU().isFocused()) {
                            TransmitPostEditActivity.this.mTZ = "from_title";
                        } else if (TransmitPostEditActivity.this.dHT().isFocused()) {
                            TransmitPostEditActivity.this.mTZ = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.mUe.setVisibility(0);
                        TransmitPostEditActivity.this.mUe.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.mUe.hasFocus()) {
                            TransmitPostEditActivity.this.mUf.requestFocus();
                            TransmitPostEditActivity.this.mUf.setSelection(TransmitPostEditActivity.this.mUf.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.mUe.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.eKD.setActionListener(31, bVar);
        this.eKD.setActionListener(16, bVar);
        this.eKD.setActionListener(14, bVar);
        this.eKD.setActionListener(24, bVar);
        this.eKD.setActionListener(3, bVar);
        this.eKD.setActionListener(10, bVar);
        this.eKD.setActionListener(11, bVar);
        this.eKD.setActionListener(12, bVar);
        this.eKD.setActionListener(13, bVar);
        this.eKD.setActionListener(15, bVar);
        this.eKD.setActionListener(18, bVar);
        this.eKD.setActionListener(20, bVar);
        this.eKD.setActionListener(25, bVar);
        this.eKD.setActionListener(27, bVar);
        this.eKD.setActionListener(29, bVar);
        this.eKD.setActionListener(43, bVar);
        this.eKD.setActionListener(45, bVar);
        this.eKD.setActionListener(53, bVar);
        this.eKD.setActionListener(48, bVar);
        this.eKD.setActionListener(46, bVar);
        this.eKD.setActionListener(49, bVar);
        this.eKD.setActionListener(47, bVar);
        this.eKD.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsd() {
        if (this.eMo.bXz()) {
            if (this.eMo.dxn()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.b.dxi().getLocationData().getFormatted_address());
                return;
            }
            a(1, true, (String) null);
            this.eMo.dxl();
            return;
        }
        a(0, true, (String) null);
    }

    protected void dsZ() {
        if (this.eMp != null) {
            this.eMp.cancelLoadData();
        }
        if (this.mUg != null) {
            this.mUg.cancelLoadData();
        }
        if (this.eMo != null) {
            this.eMo.cancelLoadData();
        }
    }

    private void dHE() {
        if (this.mUC != null) {
            this.mUC.hideTip();
        }
    }

    private void dHF() {
        if (this.mUC == null) {
            this.mUC = new g(getPageContext());
        }
        this.mUC.d(this.eKD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dHE();
        TiebaPrepareImageService.StopService();
        dsZ();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHG() {
        if (this.lUg == null) {
            finish();
            return;
        }
        this.lUg.setTitle(dHU().getText().toString());
        this.lUg.setContent(dHT().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.lUE != null && this.lUE.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.lUE, getPageContext().getPageActivity());
                return true;
            } else if (this.eKD.brx()) {
                this.eKD.bpX();
                return true;
            } else {
                dsZ();
                dHG();
                return true;
            }
        }
        if (i == 67 && (text = dHT().getText()) != null) {
            int selectionStart = dHT().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dHT().onKeyDown(67, this.hEQ);
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
        getLayoutMode().onModeChanged(this.jfk);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.kGp, R.color.cp_link_tip_a, 1);
        dHC();
        ap.setBackgroundColor(this.lUz, R.color.cp_bg_line_c);
        ap.setBackgroundColor(dHU(), R.color.cp_bg_line_d);
        ap.setBackgroundColor(dHT(), R.color.cp_bg_line_d);
        dth();
        this.eKD.onChangeSkinType(i);
        if (this.mUu != null) {
            this.mUu.bkF();
        }
        ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        dHH();
        dHI();
        if (this.mUB != null) {
            this.mUB.c(dHU(), dHT());
        }
        if (this.ahu != null) {
            this.ahu.onChangeSkinType();
        }
        if (this.mRT != null) {
            this.mRT.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHH() {
        if (this.lUy.hasFocus()) {
            this.lUy.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        } else {
            this.lUy.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        }
        if (this.mUf.hasFocus()) {
            this.mUf.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        } else {
            this.mUf.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHI() {
        if (this.lUy != null) {
            if (this.lUy.getText().toString().length() == 0) {
                this.lUy.getPaint().setFakeBoldText(false);
            } else if (this.lUy.getText().toString().length() > 0) {
                this.lUy.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.eUv = new com.baidu.tbadk.core.view.a(getPageContext());
        this.mUw = this.lUg.getType() == 4 || 5 == this.lUg.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bjq().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        dHL();
        this.mUv = (ScrollView) findViewById(R.id.write_scrollview);
        this.mUv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.mUf != null) {
                        com.baidu.adp.lib.util.l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.mUf);
                    }
                    if (TransmitPostEditActivity.this.eKD != null) {
                        TransmitPostEditActivity.this.eKD.bpX();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jfk = (RelativeLayout) findViewById(R.id.parent);
        this.mUd = (LinearLayout) findViewById(R.id.tool_view);
        this.mUd.setContentDescription(IStringUtil.TOP_PATH);
        this.mUe = (LinearLayout) findViewById(R.id.title_view);
        this.lUz = findViewById(R.id.interval_view);
        this.mUy = (TextView) findViewById(R.id.hot_topic_title_edt);
        dtg();
        if (this.mUw) {
            this.mUv.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        dti();
        dHR();
        this.lUB = (LinearLayout) findViewById(R.id.post_content_container);
        this.lUB.setDrawingCacheEnabled(false);
        this.lUB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.eKD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.mUf.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.gsB);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.dsZ();
                TransmitPostEditActivity.this.dHG();
            }
        });
        dHO();
        dHQ();
        dHK();
        dHC();
        dHP();
        dtf();
        dHW();
        dHJ();
        if (this.lUg.getType() == 4 && this.lUG != null && this.mUh != null) {
            this.lUG.setVisibility(8);
            this.mUh.setVisibility(8);
        }
        dth();
        ShowSoftKeyPad(this.mInputManager, this.lUy);
    }

    private void dHJ() {
        this.mRT = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.mRT.setData(this.mNu);
        this.mRT.setActivity(this);
    }

    private void dHK() {
        String str;
        String str2;
        if (this.lUg != null) {
            switch (this.lUg.getType()) {
                case 0:
                case 9:
                    if (this.iwr != null && this.iwr.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                        if (this.mRx) {
                            this.mName.setText(R.string.transmit_to_dynamic_title);
                        }
                    } else if (this.iwr != null && this.iwr.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.lUg.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.lUy.setVisibility(0);
                    this.mUf.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.mUf.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.mUf.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.lUy.setVisibility(8);
                    return;
            }
        }
    }

    private void dHL() {
        if (this.mRx) {
            this.kGp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.dynamic_publish));
        } else {
            this.kGp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kGp.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.kGp.setLayoutParams(layoutParams);
        this.kGp.setOnFocusChangeListener(this.gsB);
    }

    private void dHM() {
        if (this.lUg != null && this.lUg.getType() == 0 && this.lUg.getType() == 9 && !this.mUc && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = at.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dHU() != null) {
                dHU().setText(cutStringWithSuffix);
                dHU().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void dHN() {
        this.fPp = null;
        this.mUr = -1;
        this.mUt = -1;
        ah xt = com.baidu.tieba.frs.ag.cnU().xt(1);
        if (xt != null) {
            this.fPp = xt.hXr;
            this.mUr = getIntent().getIntExtra("category_id", -1);
            if (this.fPp != null && !this.fPp.isEmpty() && this.mUr >= 0) {
                this.mUq = new af();
                this.mUq.hXn = 0;
                this.mUq.name = getPageContext().getResources().getString(R.string.category_auto);
                this.mUt = this.mUq.hXn;
                this.mUs = this.mUq.name;
                for (af afVar : this.fPp) {
                    if (afVar.hXn == this.mUr) {
                        this.mUt = afVar.hXn;
                        this.mUs = afVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dHO() {
        if (this.fPp != null && !this.fPp.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.mUu = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.mUu.setText(this.mUs);
            this.mUu.setCategoryContainerData(this.fPp, this.mUq, this.mUt);
            this.mUu.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bf bfVar) {
                    if (bfVar != null) {
                        TransmitPostEditActivity.this.mUu.setText(bfVar.name);
                        TransmitPostEditActivity.this.lUg.setCategoryTo(bfVar.hXn);
                        TransmitPostEditActivity.this.mUt = bfVar.hXn;
                        TransmitPostEditActivity.this.mUu.dHg();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.mUu.dHf();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dHU());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dHT());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.mUJ = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.mUJ.setTitle(R.string.no_disturb_start_time);
        this.mUJ.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.mUJ);
        this.mUJ.setButton(-2, getPageContext().getString(R.string.cancel), this.mUJ);
        return this.mUJ;
    }

    private void dHP() {
        this.mUm = (RelativeLayout) findViewById(R.id.addition_container);
        this.mUn = (TextView) findViewById(R.id.addition_create_time);
        this.mUo = (TextView) findViewById(R.id.addition_last_time);
        this.mUp = (TextView) findViewById(R.id.addition_last_content);
        if (this.mUl != null) {
            this.mUm.setVisibility(0);
            this.mUn.setText(getPageContext().getString(R.string.write_addition_create) + at.getFormatTime(this.mUl.getCreateTime() * 1000));
            if (this.mUl.getAlreadyCount() == 0) {
                this.mUo.setVisibility(8);
            } else {
                this.mUo.setText(getPageContext().getString(R.string.write_addition_last) + at.getFormatTime(this.mUl.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.mUl.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.mUp.setText(lastAdditionContent);
            } else {
                this.mUp.setVisibility(8);
            }
            dHT().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.mUl.getAlreadyCount()), Integer.valueOf(this.mUl.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.mUm.setVisibility(8);
    }

    private void dtf() {
        this.lUG = findViewById(R.id.post_prefix_layout);
        this.lUD = (TextView) findViewById(R.id.post_prefix);
        this.mUh = findViewById(R.id.prefix_divider);
        this.lUF = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.lUG.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.lUh = 1;
            this.lUG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.lUD.setVisibility(0);
                    TransmitPostEditActivity.this.lUG.setSelected(true);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.lUE, view, 0, com.baidu.adp.lib.util.l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.eKD.bpX();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.lUy);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.mUf);
                }
            });
            this.lUF = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.lUF.setVisibility(0);
                this.lUD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.lUD.setSelected(true);
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.lUE, view, 0, com.baidu.adp.lib.util.l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.eKD.bpX();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dHU());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dHT());
                    }
                });
            }
            this.lUE = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.lUE.a(this);
            this.lUE.setMaxHeight(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds510));
            this.lUE.setOutsideTouchable(true);
            this.lUE.setFocusable(true);
            this.lUE.setOnDismissListener(this);
            this.lUE.setBackgroundDrawable(ap.getDrawable(R.color.cp_bg_line_d));
            int color = ap.getColor(R.color.cp_cont_b);
            int color2 = ap.getColor(R.color.cp_cont_c);
            ap.setBackgroundResource(this.lUD, R.color.cp_bg_line_d);
            ap.setImageResource(this.lUF, R.drawable.icon_frs_arrow_n);
            this.lUD.setTextColor(color);
            this.mUi.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.mUi.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.lUE.addView(writePrefixItemLayout);
            }
            this.lUE.setCurrentIndex(0);
            this.lUD.setText(prefixs.get(1));
            JP(1);
            return;
        }
        this.lUG.setVisibility(8);
    }

    protected void dHQ() {
        this.kGp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick() && !TransmitPostEditActivity.this.dIc()) {
                    if (TransmitPostEditActivity.this.mUB.a(TransmitPostEditActivity.this.lUy, TransmitPostEditActivity.this.mUf)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.mUB.dFy());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dHU());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dHT());
                    TransmitPostEditActivity.this.eKD.bpX();
                    TiebaStatic.log(new aq("c12608").ai("obj_locate", 7));
                    TransmitPostEditActivity.this.dHZ();
                }
            }
        });
    }

    protected void dtg() {
        this.lUy = (EditText) findViewById(R.id.post_title);
        this.lUy.setOnClickListener(this.mUF);
        this.lUy.setOnFocusChangeListener(this.gsB);
        if ((this.lUg.getType() == 0 || this.lUg.getType() == 9 || this.lUg.getType() == 7) && this.lUg.getTitle() != null) {
            this.lUy.setText(this.lUg.getTitle());
            this.lUy.setSelection(this.lUg.getTitle().length());
        }
        this.lUy.addTextChangedListener(this.mUH);
        if (!this.lUg.getHaveDraft()) {
            dHM();
        }
        this.lUy.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void dti() {
        this.mUf = (SpanGroupEditText) findViewById(R.id.post_content);
        this.mUf.setDrawingCacheEnabled(false);
        this.mUf.setOnClickListener(this.mUF);
        this.mUf.setTransLink(!this.mRx);
        if (this.eMp != null) {
            this.eMp.setSpanGroupManager(this.mUf.getSpanGroupManager());
        }
        if (this.lUg != null) {
            this.lUg.setSpanGroupManager(this.mUf.getSpanGroupManager());
        }
        if (this.lUg.getContent() != null && this.lUg.getContent().length() > 0) {
            this.mUf.setText(TbFaceManager.bsV().ap(getPageContext().getPageActivity(), this.lUg.getContent()));
            this.mUf.setSelection(this.mUf.getText().length());
        }
        if (!at.isEmpty(this.hQF)) {
            this.mUf.setSelection(0);
        }
        this.mUf.setOnFocusChangeListener(this.gsB);
        this.mUf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.eKD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.mUf.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.mUf.addTextChangedListener(this.mUI);
        if (this.mRx) {
            this.mUf.setHint(R.string.dynamic_transmit_publish_edit_str);
        } else if (this.mUb != null && this.mUb.showType == 3) {
            this.mUf.setHint(R.string.share_video_default);
        } else {
            this.mUf.setHint(R.string.share_txt_default);
        }
    }

    private void dHR() {
        this.ahu = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ahu.getLayoutParams();
        layoutParams.topMargin -= izP;
        layoutParams.leftMargin = feH;
        layoutParams.rightMargin = feH;
        this.ahu.setLayoutParams(layoutParams);
        this.ahu.setVisibility(0);
        this.ahu.a(this.mUb);
        this.ahu.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dHS() {
        int i = 5000;
        if (this.mUl != null) {
            i = 1000;
        }
        return dHT().getText() != null && dHT().getText().length() >= i;
    }

    private void BT(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.mTZ)) {
                this.mTZ = "";
                dHT().requestFocus();
                if (dHT().getText() != null && dHT().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dHT().getSelectionStart();
                    editable = dHT().getText();
                }
            } else if ("from_title".equals(this.mTZ)) {
                this.mTZ = "";
                dHU().requestFocus();
                if (dHU().getText() != null && dHU().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dHU().getSelectionStart();
                    editable = dHU().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xp(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.lUg != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.lUg.getForumId(), 0L), this.lUg.getFirstDir(), this.lUg.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(t tVar) {
        if (((ImageSpan[]) dHT().getText().getSpans(0, dHT().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.mUj == null) {
                this.mUj = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.mUj.getView().isShown()) {
                this.mUj.cancel();
            }
            this.mUj.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, tVar, dHT());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dHT() {
        return this.mUf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dHU() {
        return this.lUy;
    }

    protected void dHV() {
        if (dHT().getSelectionStart() > 0) {
            String substring = dHT().getText().toString().substring(0, dHT().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.hEP.matcher(substring);
            if (matcher.find()) {
                dHT().getText().delete(dHT().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dHT().getSelectionStart());
                return;
            }
            dHT().onKeyDown(67, this.hEQ);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.eUv.setCancelListener(null);
        this.eUv.setTipString(R.string.sending);
        this.eUv.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.eUv.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dth() {
        if (this.lUg != null) {
            String str = "";
            String str2 = "";
            if (dHU() != null) {
                str = dHU().getText().toString();
            }
            if (dHT() != null) {
                str2 = dHT().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.lUg.getType() == 0 || this.lUg.getType() == 9 || this.lUg.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.lUh == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.lUg.setIsNoTitle(true);
                        } else {
                            this.lUg.setIsNoTitle(false);
                            xq(true);
                            return;
                        }
                    } else {
                        this.lUg.setIsNoTitle(false);
                        xq(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.lUg.setIsNoTitle(true);
                } else {
                    this.lUg.setIsNoTitle(false);
                    xq(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.mUw) {
                    xq(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    xq(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                xq(true);
            } else if (this.lUg.getVideoInfo() != null) {
                xq(true);
            } else {
                xq(false);
            }
        }
    }

    private void xq(boolean z) {
        ap.setNavbarTitleColor(this.kGp, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.eMp = new NewWriteModel(this);
        this.eMp.b(this.eMD);
        this.hJE = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.dsZ();
            }
        };
        this.lUg = new WriteData();
        if (bundle != null) {
            this.lUg.setType(bundle.getInt("type", 0));
            this.lUg.setForumId(bundle.getString("forum_id"));
            this.lUg.setForumName(bundle.getString("forum_name"));
            this.lUg.setFirstDir(bundle.getString("forum_first_dir"));
            this.lUg.setSecondDir(bundle.getString("forum_second_dir"));
            this.lUg.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.mUl = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.lUg.setIsAddition(this.mUl != null);
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
            this.lUg.setTitle(bundle.getString("write_title"));
            this.lUg.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.iwr = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.mUb = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.ShareInfo.class);
            }
            this.mBaijiahaoData = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.hQF = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.hQG = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.mNu = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.lUg.mDynamicForwardData = (ForwardUploadData) bundle.getSerializable(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA);
            str = string;
        } else {
            Intent intent = getIntent();
            this.lUg.setType(intent.getIntExtra("type", 0));
            this.lUg.setForumId(intent.getStringExtra("forum_id"));
            this.lUg.setForumName(intent.getStringExtra("forum_name"));
            this.lUg.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.lUg.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.lUg.setThreadId(intent.getStringExtra("thread_id"));
            this.mUl = (AdditionData) intent.getSerializableExtra("addition_data");
            this.lUg.setIsAddition(this.mUl != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.lUg.setTitle(intent.getStringExtra("write_title"));
            this.lUg.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.iwr = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.mUb = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            this.lUg.mDynamicForwardData = (ForwardUploadData) intent.getSerializableExtra(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA);
            this.hQF = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.hQG = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.mNu = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (this.lUg.mDynamicForwardData != null) {
            this.mRx = true;
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.lUg.getType() == 4 ? 6 : 9);
        this.lUg.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.mUb != null && this.mUb.videoId != null) {
            this.lUg.setVideoId(this.mUb.videoId);
            this.lUg.setOriginalVideoCover(this.mUb.showPicUrl);
            this.lUg.setOriginalVideoTitle(this.mUb.showText);
        }
        if (!at.isEmpty(this.hQF)) {
            if (!at.isEmpty(this.hQG)) {
                this.lUg.setContent("//@" + this.hQG + " :" + this.hQF);
            } else {
                this.lUg.setContent(this.hQF);
            }
        }
        if (this.lUg != null && this.lUg.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.lUg.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.mUc = true;
        }
        dHN();
    }

    private void dHW() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) y.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.lUy.setText(com.baidu.tbadk.plugins.b.Cy(com.baidu.tbadk.plugins.b.Cz(hotTopicBussinessData.mTopicName)));
            this.lUy.setMovementMethod(com.baidu.tieba.view.c.dEZ());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString Cy = com.baidu.tbadk.plugins.b.Cy(com.baidu.tbadk.plugins.b.Cz(hotTopicBussinessData.mTopicName));
            if (Cy != null) {
                this.lUy.setText(Cy);
            }
            this.mUy.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.lUg.getType());
        bundle.putString("forum_id", this.lUg.getForumId());
        bundle.putString("forum_name", this.lUg.getForumName());
        bundle.putString("forum_first_dir", this.lUg.getFirstDir());
        bundle.putString("forum_second_dir", this.lUg.getSecondDir());
        bundle.putString("thread_id", this.lUg.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.iwr);
        bundle.putSerializable("tab_list", this.mNu);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.mUl != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.mUl));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.iwr);
        if (this.lUg.mDynamicForwardData != null) {
            bundle.putSerializable(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA, this.lUg.mDynamicForwardData);
        }
        if (this.mUb != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mUb));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dHT().getEditableText().toString();
        if (obj != null) {
            dHT().setText(TbFaceManager.bsV().a(getPageContext().getPageActivity(), obj, this.mUD));
            dHT().setSelection(dHT().getText().length());
        }
    }

    private String dHX() {
        if (dHT() == null || dHT().getText() == null) {
            return "";
        }
        String obj = dHT().getText().toString();
        if (StringUtils.isNull(obj)) {
            if (this.mUb != null && this.mUb.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return obj;
    }

    private String dHY() {
        if (this.lUg == null || dHU() == null || dHU().getVisibility() != 0 || dHU().getText() == null) {
            return "";
        }
        String obj = dHU().getText().toString();
        if (this.mPrefixData != null && y.getCount(this.mPrefixData.getPrefixs()) > 0 && this.lUh != 0 && this.lUg.getType() != 4 && this.lUD != null && this.lUD.getText() != null) {
            obj = this.lUD.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            obj = this.mPrefixData.getImplicitTitle() + this.lUg.getTitle();
        }
        if (TextUtils.isEmpty(obj)) {
            return getString(R.string.share_txt_default);
        }
        return obj;
    }

    private void cqf() {
        if (this.lUg != null && this.lUg.mDynamicForwardData != null) {
            dGN();
            return;
        }
        dsZ();
        this.lUg.setContent(dHX());
        this.lUg.setTitle(dHY());
        if (this.mUr >= 0) {
            this.lUg.setCategoryFrom(this.mUr);
        }
        if (this.mUt >= 0) {
            this.lUg.setCategoryTo(this.mUt);
        }
        this.lUg.setWriteImagesInfo(this.writeImagesInfo);
        this.lUg.setHasLocationData(this.eMo != null && this.eMo.bXz());
        this.eMp.wg(this.writeImagesInfo.size() > 0);
        if (!y.isEmpty(this.mList) && this.mUx != null && this.mUx.mIsGlobalBlock == 0) {
            this.lUg.setForumId(String.valueOf(this.mUx.mForumId));
            this.lUg.setForumName(this.mUx.mForumName);
        }
        dGO();
        this.eMp.d(this.lUg);
        this.lUg.setContent(this.lUg.getContent().replaceAll("\u0000\n", ""));
        this.lUg.setContent(this.lUg.getContent().replaceAll("\u0000", ""));
        this.lUg.setVcode(null);
        this.eMp.cKZ().setVoice(null);
        this.eMp.cKZ().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.hJE);
        this.eMp.dxS();
    }

    private void dGO() {
        FrsTabItemData selectedTabItemData;
        if (this.lUg != null && this.mRT != null && (selectedTabItemData = this.mRT.getSelectedTabItemData()) != null) {
            this.lUg.setTabId(selectedTabItemData.tabId);
            this.lUg.setTabName(selectedTabItemData.name);
            this.lUg.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    private void dGN() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        this.lUg.mDynamicForwardData.forward_content = dHX();
        this.lUg.mDynamicForwardData.inputText = dHX();
        this.lUg.mDynamicForwardData.locationPoiId = "0";
        showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
        com.baidu.tieba.write.b.c.b.dGz().a(this.lUg.mDynamicForwardData, new b.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // com.baidu.tieba.write.b.c.b.a
            public void onSuccess(String str) {
                TransmitPostEditActivity.this.closeLoadingDialog();
                com.baidu.tieba.tbadkCore.writeModel.c.g(TransmitPostEditActivity.this.getPageContext().getPageActivity(), null, null, null);
                TransmitPostEditActivity.this.jp(true);
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
            if (this.mUl != null) {
                i2 = this.mUl.getTotalCount();
                i = this.mUl.getAlreadyCount() + 1;
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
                if (this.eKD != null && !this.eKD.brx()) {
                    dHT().requestFocus();
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
                            dHT().getText().insert(dHT().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                l((intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data"));
                setResult(-1, intent);
                finish();
            } else if (i == 25004) {
                if (intent != null) {
                    String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                    if (!StringUtils.isNull(stringExtra)) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.mUa) {
                            sb2.append(com.baidu.tbadk.plugins.b.eTO);
                            this.mUa = false;
                        }
                        sb2.append(stringExtra);
                        BT(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !y.isEmpty(this.mList) && !y.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.mUx = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.mUx);
            }
        } else if (i2 == 0) {
            if (this.eKD != null && !this.eKD.brx()) {
                this.mUf.requestFocus();
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
                        this.mUB.Sw(postWriteCallBackData.getErrorString());
                        this.mUB.bf(postWriteCallBackData.getSensitiveWords());
                        this.mUB.b(this.lUy, this.mUf);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.mTZ)) {
                        dHU().requestFocus();
                        return;
                    } else if ("from_content".equals(this.mTZ)) {
                        dHT().requestFocus();
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
    public void dHZ() {
        if ("1".equals(this.iwr)) {
            this.lUg.setCanNoForum(true);
            this.lUg.setTransmitForumData("[]");
        } else if ("2".equals(this.iwr)) {
            this.lUg.setCanNoForum(false);
        }
        dIa();
        this.lUg.setPrivacy(this.isPrivacy);
        this.lUg.setIsShareThread(true);
        if (this.mUb != null && !StringUtils.isNull(this.mUb.threadId)) {
            this.lUg.setOriginalThreadId(this.mUb.threadId);
        }
        this.lUg.setBaijiahaoData(this.mBaijiahaoData);
        if (this.mUb != null) {
            this.lUg.setOriBaijiahaoData(this.mUb.oriUgcInfo);
        }
        this.lUg.setCallFrom(this.iwr);
        cqf();
    }

    private void dIa() {
        if (this.eKD != null) {
            this.eKD.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dHU());
        HidenSoftKeyPad(this.mInputManager, dHT());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bz(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.hUk) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.lUg.getType() != 7) {
                if (this.mUl == null) {
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
        this.eMu = i;
        if (this.eKD != null) {
            this.eKD.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void dIb() {
        if (!this.mUw && this.eKD != null) {
            this.eKD.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.eKD.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jp(boolean z) {
        if (this.eKD != null) {
            this.eKD.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void JP(int i) {
        if (i < this.mUi.size()) {
            for (int i2 = 0; i2 < this.mUi.size(); i2++) {
                this.mUi.get(i2).xc(false);
            }
            this.mUi.get(i).xc(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void Hs(int i) {
        this.lUh = i;
        this.lUE.setCurrentIndex(i);
        JP(i);
        this.lUD.setText(this.mPrefixData.getPrefixs().get(i));
        dth();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.lUE, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.lUG.setSelected(false);
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
        if (this.lUg != null) {
            if (this.lUg.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.lUg.getType() == 5) {
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
            bsa();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.bdD = z;
        if (this.mUA != null && !z) {
            this.mUA.cfP();
        }
        if (this.mUC != null && !z) {
            dHE();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.bdD && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.mUa = false;
            this.mTZ = "";
            if ("from_content".equals(str)) {
                this.mTZ = "from_content";
            } else if ("from_title".equals(str)) {
                this.mTZ = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.Cx(String.valueOf(charSequence.charAt(i)))) {
                xp(false);
            }
        }
    }

    public void dnT() {
        if (!y.isEmpty(this.mList)) {
            this.mUe.setVisibility(0);
            this.mUe.requestFocus();
            return;
        }
        this.mUe.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dIc() {
        if (((ImageSpan[]) dHT().getText().getSpans(0, dHT().getText().length(), ImageSpan.class)).length > 10) {
            if (this.mUj == null) {
                this.mUj = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.mUj.getView().isShown()) {
                this.mUj.cancel();
            }
            this.mUj.show();
            return true;
        }
        return false;
    }
}
