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
    private OriginalThreadCardView ahw;
    private EditorTools eKH;
    private LocationModel eMs;
    private NewWriteModel eMt;
    List<af> fPt;
    private String hQL;
    private String hQM;
    private boolean isPrivacy;
    private TextView lUS;
    private com.baidu.tieba.write.i lUT;
    private ImageView lUU;
    private View lUV;
    private int lUw;
    private BaijiahaoData mBaijiahaoData;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private FrsTabInfoData mNM;
    private NavigationBar mNavigationBar;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private ForumTabSelectedView mSl;
    private View mUA;
    private Toast mUC;
    private AdditionData mUD;
    private RelativeLayout mUE;
    private TextView mUF;
    private TextView mUG;
    private TextView mUH;
    af mUI;
    private int mUJ;
    private String mUK;
    private int mUL;
    private PostCategoryView mUM;
    private HotTopicBussinessData mUP;
    private TextView mUQ;
    private com.baidu.tieba.write.editor.b mUS;
    private g mUU;
    private OriginalThreadInfo.ShareInfo mUu;
    private LinearLayout mUw;
    private LinearLayout mUx;
    private com.baidu.tieba.view.b mVb;
    private static final int izV = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    private static final int feL = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44);
    private String mUs = "";
    private boolean mUt = false;
    private WriteData lUv = null;
    private boolean mUv = false;
    private InputMethodManager mInputManager = null;
    private EditText lUN = null;
    private View lUO = null;
    private LinearLayout lUQ = null;
    private SpanGroupEditText mUy = null;
    private FeedBackModel mUz = null;
    private ArrayList<WritePrefixItemLayout> mUB = new ArrayList<>();
    private final KeyEvent hEW = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView kGw = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener hJK = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout jfq = null;
    private String eMx = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int eMy = 0;
    private View mRootView = null;
    private ScrollView mUN = null;
    private boolean mUO = false;
    private com.baidu.tbadk.core.view.a eUz = null;
    private String mFrom = "write";
    private String iwx = "2";
    private SpannableStringBuilder mUR = new SpannableStringBuilder();
    private boolean bdF = false;
    private final c mUT = new c();
    private boolean mRP = false;
    private TbFaceManager.a mUV = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan Ck(String str) {
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
    private final AntiHelper.a hUq = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d eMH = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.lUv != null) {
                TransmitPostEditActivity.this.mUT.bf(null);
                if (z) {
                    TransmitPostEditActivity.this.jr(z);
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
                    TransmitPostEditActivity.this.mUT.Sw(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.mUT.bf(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.mUT.b(TransmitPostEditActivity.this.lUN, TransmitPostEditActivity.this.mUy);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.c(TransmitPostEditActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(TransmitPostEditActivity.this.getActivity());
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.zA(TransmitPostEditActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.zA(postWriteCallBackData.getErrorString());
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
                    if (com.baidu.tbadk.t.a.CP(agVar.bmY())) {
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
    private final LocationModel.a eMF = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bsq() {
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
    private final CustomMessageListener mhC = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.eMs.wg(false);
                    TransmitPostEditActivity.this.eMs.fV(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.eMs.wg(true);
                TransmitPostEditActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener mUW = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener mUX = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.eKH.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dHK = TransmitPostEditActivity.this.dHK();
            if (dHK >= 0 && dHK < TransmitPostEditActivity.this.mUy.getText().length()) {
                TransmitPostEditActivity.this.mUy.setSelection(dHK);
            }
        }
    };
    private boolean mUY = true;
    private final View.OnFocusChangeListener gsF = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.lUN || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.kGw) {
                if (z) {
                    TransmitPostEditActivity.this.mUY = true;
                    TransmitPostEditActivity.this.dHL();
                    if (TransmitPostEditActivity.this.eKH != null) {
                        TransmitPostEditActivity.this.eKH.bpY();
                    }
                    com.baidu.adp.lib.util.l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.lUN);
                } else if (view == TransmitPostEditActivity.this.lUN) {
                    TransmitPostEditActivity.this.lUS.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.mUy && z) {
                TransmitPostEditActivity.this.mUY = false;
                TransmitPostEditActivity.this.dHL();
                TransmitPostEditActivity.this.eKH.bpY();
                com.baidu.adp.lib.util.l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.mUy);
            }
            TransmitPostEditActivity.this.dHQ();
        }
    };
    private TextWatcher mUZ = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String mVd = "";
        private String mVe;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mVe = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.mVe != null ? this.mVe.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dtm();
            TransmitPostEditActivity.this.dHR();
            EditText dId = TransmitPostEditActivity.this.dId();
            if (editable != null && dId != null && dId.getText() != null) {
                if (this.mVd == null || !this.mVd.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.mUT != null) {
                        this.mVd = dId.getText().toString();
                        TransmitPostEditActivity.this.mUT.b(dId, true);
                        return;
                    }
                    return;
                }
                dId.setSelection(dId.getSelectionEnd());
            }
        }
    };
    private TextWatcher mVa = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String mVe;
        private String mVf = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mVe = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.mVe != null ? this.mVe.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dtm();
            EditText dIc = TransmitPostEditActivity.this.dIc();
            if (editable != null && dIc != null && dIc.getText() != null) {
                int selectionEnd = dIc.getSelectionEnd();
                if (this.mVf == null || !this.mVf.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.mUT != null) {
                        this.mVf = dIc.getText().toString();
                        TransmitPostEditActivity.this.mUT.b(dIc, false);
                        return;
                    }
                    return;
                }
                dIc.setSelection(selectionEnd);
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
    public void brZ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void bsb() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bsd();
        } else if (this.eMs.dxs()) {
            brZ();
        } else {
            this.eMs.wg(false);
            a(1, true, (String) null);
            this.eMs.dxq();
        }
    }

    private void bsd() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nt(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.a(1, true, (String) null);
                    TransmitPostEditActivity.this.eMs.dxu();
                } else {
                    TransmitPostEditActivity.this.eMF.bsq();
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
    public int dHK() {
        int selectionEnd = dIc().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dIc().getText().getSpans(0, dIc().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dIc().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dIc().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHL() {
        if (this.eKH != null) {
            this.eKH.setBarLauncherEnabled(!this.mUY);
            this.eKH.setToolEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mUO) {
            this.lUN.setVisibility(8);
            dtm();
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
        this.eMs = new LocationModel(getPageContext());
        this.eMs.a(this.eMF);
        registerListener(this.mhC);
        registerListener(this.mUW);
        cKF();
        this.mUy.requestFocus();
        dnW();
        dIk();
    }

    @SuppressLint({"ResourceAsColor"})
    private void cKF() {
        this.eKH = new EditorTools(getActivity());
        this.eKH.setBarMaxLauCount(4);
        this.eKH.setMoreButtonAtEnd(true);
        this.eKH.setBarLauncherType(1);
        this.eKH.jj(true);
        this.eKH.jk(true);
        this.eKH.setBackgroundColorId(R.color.cp_bg_line_h);
        dHM();
        this.eKH.build();
        if (this.mRP) {
            this.eKH.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        }
        if (this.mUw != null) {
            this.mUw.addView(this.eKH);
        }
        cJX();
        this.eKH.display();
        com.baidu.tbadk.editortools.h qb = this.eKH.qb(6);
        if (qb != null && !TextUtils.isEmpty(this.eMx)) {
            ((View) qb).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.eMx);
                }
            });
        }
        if (!this.mUO) {
            this.eKH.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.eKH.bpY();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.eKH.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.eKH.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.lUv.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.lUv.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        if (!this.mRP) {
            dHO();
        }
    }

    private void dHM() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.eKH.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        if (!this.mRP && this.mUD == null) {
            if (this.mUS == null) {
                this.mUS = new com.baidu.tieba.write.editor.b(getActivity(), this.iwx);
                this.mUS.dGt();
                this.mUS.setFrom("from_share_write");
                this.mUS.bM(this.lUv.getForumId(), this.mPrivateThread);
            }
            this.eKH.b(this.mUS);
        }
        this.eKH.bc(arrayList);
        com.baidu.tbadk.editortools.m qe = this.eKH.qe(5);
        if (qe != null) {
            qe.eLu = 1;
            if (this.mRP) {
                qe.jm(false);
            }
        }
    }

    private void cJX() {
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
                        if (TransmitPostEditActivity.this.dIb()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.dIb()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof t)) {
                            TransmitPostEditActivity.this.e((t) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.dIe();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.dtm();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.mUD == null) {
                            TransmitPostEditActivity.this.bse();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.eMy) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ae.checkLocationForGoogle(pageActivity)) {
                                    TransmitPostEditActivity.this.bsb();
                                    return;
                                } else {
                                    ae.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.brZ();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.eMs != null) {
                            TransmitPostEditActivity.this.eMs.wg(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        aq aqVar = new aq("c10645");
                        if (TransmitPostEditActivity.this.lUv != null) {
                            str = TransmitPostEditActivity.this.lUv.getForumId();
                        } else {
                            str = "";
                        }
                        aqVar.dD("fid", str);
                        TiebaStatic.log(aqVar);
                        if (TransmitPostEditActivity.this.lUv == null || (videoInfo = TransmitPostEditActivity.this.lUv.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.eKH.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.eKH.bry()) {
                                        TransmitPostEditActivity.this.eKH.bpY();
                                        TransmitPostEditActivity.this.eKH.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.eKH.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.eKH.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.eKH.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.eKH.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.lUv.setVideoInfo(null);
                        TransmitPostEditActivity.this.dtm();
                        if (TransmitPostEditActivity.this.mUy != null) {
                            TransmitPostEditActivity.this.mUy.requestFocus();
                        }
                        TransmitPostEditActivity.this.eKH.bpY();
                        TransmitPostEditActivity.this.eKH.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.mUy);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.eKH.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.mUt = true;
                        TransmitPostEditActivity.this.xr(true);
                        if (TransmitPostEditActivity.this.dId().isFocused()) {
                            TransmitPostEditActivity.this.mUs = "from_title";
                        } else if (TransmitPostEditActivity.this.dIc().isFocused()) {
                            TransmitPostEditActivity.this.mUs = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.mUx.setVisibility(0);
                        TransmitPostEditActivity.this.mUx.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.mUx.hasFocus()) {
                            TransmitPostEditActivity.this.mUy.requestFocus();
                            TransmitPostEditActivity.this.mUy.setSelection(TransmitPostEditActivity.this.mUy.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.mUx.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.eKH.setActionListener(31, bVar);
        this.eKH.setActionListener(16, bVar);
        this.eKH.setActionListener(14, bVar);
        this.eKH.setActionListener(24, bVar);
        this.eKH.setActionListener(3, bVar);
        this.eKH.setActionListener(10, bVar);
        this.eKH.setActionListener(11, bVar);
        this.eKH.setActionListener(12, bVar);
        this.eKH.setActionListener(13, bVar);
        this.eKH.setActionListener(15, bVar);
        this.eKH.setActionListener(18, bVar);
        this.eKH.setActionListener(20, bVar);
        this.eKH.setActionListener(25, bVar);
        this.eKH.setActionListener(27, bVar);
        this.eKH.setActionListener(29, bVar);
        this.eKH.setActionListener(43, bVar);
        this.eKH.setActionListener(45, bVar);
        this.eKH.setActionListener(53, bVar);
        this.eKH.setActionListener(48, bVar);
        this.eKH.setActionListener(46, bVar);
        this.eKH.setActionListener(49, bVar);
        this.eKH.setActionListener(47, bVar);
        this.eKH.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bse() {
        if (this.eMs.bXA()) {
            if (this.eMs.dxs()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.b.dxn().getLocationData().getFormatted_address());
                return;
            }
            a(1, true, (String) null);
            this.eMs.dxq();
            return;
        }
        a(0, true, (String) null);
    }

    protected void dte() {
        if (this.eMt != null) {
            this.eMt.cancelLoadData();
        }
        if (this.mUz != null) {
            this.mUz.cancelLoadData();
        }
        if (this.eMs != null) {
            this.eMs.cancelLoadData();
        }
    }

    private void dHN() {
        if (this.mUU != null) {
            this.mUU.hideTip();
        }
    }

    private void dHO() {
        if (this.mUU == null) {
            this.mUU = new g(getPageContext());
        }
        this.mUU.d(this.eKH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dHN();
        TiebaPrepareImageService.StopService();
        dte();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHP() {
        if (this.lUv == null) {
            finish();
            return;
        }
        this.lUv.setTitle(dId().getText().toString());
        this.lUv.setContent(dIc().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.lUT != null && this.lUT.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.lUT, getPageContext().getPageActivity());
                return true;
            } else if (this.eKH.bry()) {
                this.eKH.bpY();
                return true;
            } else {
                dte();
                dHP();
                return true;
            }
        }
        if (i == 67 && (text = dIc().getText()) != null) {
            int selectionStart = dIc().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dIc().onKeyDown(67, this.hEW);
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
        getLayoutMode().onModeChanged(this.jfq);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.kGw, R.color.cp_link_tip_a, 1);
        dHL();
        ap.setBackgroundColor(this.lUO, R.color.cp_bg_line_c);
        ap.setBackgroundColor(dId(), R.color.cp_bg_line_d);
        ap.setBackgroundColor(dIc(), R.color.cp_bg_line_d);
        dtm();
        this.eKH.onChangeSkinType(i);
        if (this.mUM != null) {
            this.mUM.bkF();
        }
        ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        dHQ();
        dHR();
        if (this.mUT != null) {
            this.mUT.c(dId(), dIc());
        }
        if (this.ahw != null) {
            this.ahw.onChangeSkinType();
        }
        if (this.mSl != null) {
            this.mSl.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHQ() {
        if (this.lUN.hasFocus()) {
            this.lUN.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        } else {
            this.lUN.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        }
        if (this.mUy.hasFocus()) {
            this.mUy.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        } else {
            this.mUy.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHR() {
        if (this.lUN != null) {
            if (this.lUN.getText().toString().length() == 0) {
                this.lUN.getPaint().setFakeBoldText(false);
            } else if (this.lUN.getText().toString().length() > 0) {
                this.lUN.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.eUz = new com.baidu.tbadk.core.view.a(getPageContext());
        this.mUO = this.lUv.getType() == 4 || 5 == this.lUv.getType();
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
        dHU();
        this.mUN = (ScrollView) findViewById(R.id.write_scrollview);
        this.mUN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.mUy != null) {
                        com.baidu.adp.lib.util.l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.mUy);
                    }
                    if (TransmitPostEditActivity.this.eKH != null) {
                        TransmitPostEditActivity.this.eKH.bpY();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jfq = (RelativeLayout) findViewById(R.id.parent);
        this.mUw = (LinearLayout) findViewById(R.id.tool_view);
        this.mUw.setContentDescription(IStringUtil.TOP_PATH);
        this.mUx = (LinearLayout) findViewById(R.id.title_view);
        this.lUO = findViewById(R.id.interval_view);
        this.mUQ = (TextView) findViewById(R.id.hot_topic_title_edt);
        dtl();
        if (this.mUO) {
            this.mUN.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        dtn();
        dIa();
        this.lUQ = (LinearLayout) findViewById(R.id.post_content_container);
        this.lUQ.setDrawingCacheEnabled(false);
        this.lUQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.eKH.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.mUy.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.gsF);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.dte();
                TransmitPostEditActivity.this.dHP();
            }
        });
        dHX();
        dHZ();
        dHT();
        dHL();
        dHY();
        dtk();
        dIf();
        dHS();
        if (this.lUv.getType() == 4 && this.lUV != null && this.mUA != null) {
            this.lUV.setVisibility(8);
            this.mUA.setVisibility(8);
        }
        dtm();
        ShowSoftKeyPad(this.mInputManager, this.lUN);
    }

    private void dHS() {
        this.mSl = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.mSl.setData(this.mNM);
        this.mSl.setActivity(this);
    }

    private void dHT() {
        String str;
        String str2;
        if (this.lUv != null) {
            switch (this.lUv.getType()) {
                case 0:
                case 9:
                    if (this.iwx != null && this.iwx.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                        if (this.mRP) {
                            this.mName.setText(R.string.transmit_to_dynamic_title);
                        }
                    } else if (this.iwx != null && this.iwx.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.lUv.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.lUN.setVisibility(0);
                    this.mUy.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.mUy.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.mUy.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.lUN.setVisibility(8);
                    return;
            }
        }
    }

    private void dHU() {
        if (this.mRP) {
            this.kGw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.dynamic_publish));
        } else {
            this.kGw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kGw.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.kGw.setLayoutParams(layoutParams);
        this.kGw.setOnFocusChangeListener(this.gsF);
    }

    private void dHV() {
        if (this.lUv != null && this.lUv.getType() == 0 && this.lUv.getType() == 9 && !this.mUv && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = at.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dId() != null) {
                dId().setText(cutStringWithSuffix);
                dId().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void dHW() {
        this.fPt = null;
        this.mUJ = -1;
        this.mUL = -1;
        ah xt = com.baidu.tieba.frs.ag.cnV().xt(1);
        if (xt != null) {
            this.fPt = xt.hXx;
            this.mUJ = getIntent().getIntExtra("category_id", -1);
            if (this.fPt != null && !this.fPt.isEmpty() && this.mUJ >= 0) {
                this.mUI = new af();
                this.mUI.hXt = 0;
                this.mUI.name = getPageContext().getResources().getString(R.string.category_auto);
                this.mUL = this.mUI.hXt;
                this.mUK = this.mUI.name;
                for (af afVar : this.fPt) {
                    if (afVar.hXt == this.mUJ) {
                        this.mUL = afVar.hXt;
                        this.mUK = afVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dHX() {
        if (this.fPt != null && !this.fPt.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.mUM = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.mUM.setText(this.mUK);
            this.mUM.setCategoryContainerData(this.fPt, this.mUI, this.mUL);
            this.mUM.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bf bfVar) {
                    if (bfVar != null) {
                        TransmitPostEditActivity.this.mUM.setText(bfVar.name);
                        TransmitPostEditActivity.this.lUv.setCategoryTo(bfVar.hXt);
                        TransmitPostEditActivity.this.mUL = bfVar.hXt;
                        TransmitPostEditActivity.this.mUM.dHp();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.mUM.dHo();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dId());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dIc());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.mVb = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.mVb.setTitle(R.string.no_disturb_start_time);
        this.mVb.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.mVb);
        this.mVb.setButton(-2, getPageContext().getString(R.string.cancel), this.mVb);
        return this.mVb;
    }

    private void dHY() {
        this.mUE = (RelativeLayout) findViewById(R.id.addition_container);
        this.mUF = (TextView) findViewById(R.id.addition_create_time);
        this.mUG = (TextView) findViewById(R.id.addition_last_time);
        this.mUH = (TextView) findViewById(R.id.addition_last_content);
        if (this.mUD != null) {
            this.mUE.setVisibility(0);
            this.mUF.setText(getPageContext().getString(R.string.write_addition_create) + at.getFormatTime(this.mUD.getCreateTime() * 1000));
            if (this.mUD.getAlreadyCount() == 0) {
                this.mUG.setVisibility(8);
            } else {
                this.mUG.setText(getPageContext().getString(R.string.write_addition_last) + at.getFormatTime(this.mUD.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.mUD.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.mUH.setText(lastAdditionContent);
            } else {
                this.mUH.setVisibility(8);
            }
            dIc().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.mUD.getAlreadyCount()), Integer.valueOf(this.mUD.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.mUE.setVisibility(8);
    }

    private void dtk() {
        this.lUV = findViewById(R.id.post_prefix_layout);
        this.lUS = (TextView) findViewById(R.id.post_prefix);
        this.mUA = findViewById(R.id.prefix_divider);
        this.lUU = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.lUV.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.lUw = 1;
            this.lUV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.lUS.setVisibility(0);
                    TransmitPostEditActivity.this.lUV.setSelected(true);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.lUT, view, 0, com.baidu.adp.lib.util.l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.eKH.bpY();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.lUN);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.mUy);
                }
            });
            this.lUU = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.lUU.setVisibility(0);
                this.lUS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.lUS.setSelected(true);
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.lUT, view, 0, com.baidu.adp.lib.util.l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.eKH.bpY();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dId());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dIc());
                    }
                });
            }
            this.lUT = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.lUT.a(this);
            this.lUT.setMaxHeight(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds510));
            this.lUT.setOutsideTouchable(true);
            this.lUT.setFocusable(true);
            this.lUT.setOnDismissListener(this);
            this.lUT.setBackgroundDrawable(ap.getDrawable(R.color.cp_bg_line_d));
            int color = ap.getColor(R.color.cp_cont_b);
            int color2 = ap.getColor(R.color.cp_cont_c);
            ap.setBackgroundResource(this.lUS, R.color.cp_bg_line_d);
            ap.setImageResource(this.lUU, R.drawable.icon_frs_arrow_n);
            this.lUS.setTextColor(color);
            this.mUB.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.mUB.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.lUT.addView(writePrefixItemLayout);
            }
            this.lUT.setCurrentIndex(0);
            this.lUS.setText(prefixs.get(1));
            JP(1);
            return;
        }
        this.lUV.setVisibility(8);
    }

    protected void dHZ() {
        this.kGw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick() && !TransmitPostEditActivity.this.dIl()) {
                    if (TransmitPostEditActivity.this.mUT.a(TransmitPostEditActivity.this.lUN, TransmitPostEditActivity.this.mUy)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.mUT.dFH());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dId());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dIc());
                    TransmitPostEditActivity.this.eKH.bpY();
                    TiebaStatic.log(new aq("c12608").ai("obj_locate", 7));
                    TransmitPostEditActivity.this.dIi();
                }
            }
        });
    }

    protected void dtl() {
        this.lUN = (EditText) findViewById(R.id.post_title);
        this.lUN.setOnClickListener(this.mUX);
        this.lUN.setOnFocusChangeListener(this.gsF);
        if ((this.lUv.getType() == 0 || this.lUv.getType() == 9 || this.lUv.getType() == 7) && this.lUv.getTitle() != null) {
            this.lUN.setText(this.lUv.getTitle());
            this.lUN.setSelection(this.lUv.getTitle().length());
        }
        this.lUN.addTextChangedListener(this.mUZ);
        if (!this.lUv.getHaveDraft()) {
            dHV();
        }
        this.lUN.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void dtn() {
        this.mUy = (SpanGroupEditText) findViewById(R.id.post_content);
        this.mUy.setDrawingCacheEnabled(false);
        this.mUy.setOnClickListener(this.mUX);
        this.mUy.setTransLink(!this.mRP);
        if (this.eMt != null) {
            this.eMt.setSpanGroupManager(this.mUy.getSpanGroupManager());
        }
        if (this.lUv != null) {
            this.lUv.setSpanGroupManager(this.mUy.getSpanGroupManager());
        }
        if (this.lUv.getContent() != null && this.lUv.getContent().length() > 0) {
            this.mUy.setText(TbFaceManager.bsW().ap(getPageContext().getPageActivity(), this.lUv.getContent()));
            this.mUy.setSelection(this.mUy.getText().length());
        }
        if (!at.isEmpty(this.hQL)) {
            this.mUy.setSelection(0);
        }
        this.mUy.setOnFocusChangeListener(this.gsF);
        this.mUy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.eKH.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.mUy.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.mUy.addTextChangedListener(this.mVa);
        if (this.mRP) {
            this.mUy.setHint(R.string.dynamic_transmit_publish_edit_str);
        } else if (this.mUu != null && this.mUu.showType == 3) {
            this.mUy.setHint(R.string.share_video_default);
        } else {
            this.mUy.setHint(R.string.share_txt_default);
        }
    }

    private void dIa() {
        this.ahw = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ahw.getLayoutParams();
        layoutParams.topMargin -= izV;
        layoutParams.leftMargin = feL;
        layoutParams.rightMargin = feL;
        this.ahw.setLayoutParams(layoutParams);
        this.ahw.setVisibility(0);
        this.ahw.a(this.mUu);
        this.ahw.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dIb() {
        int i = 5000;
        if (this.mUD != null) {
            i = 1000;
        }
        return dIc().getText() != null && dIc().getText().length() >= i;
    }

    private void BU(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.mUs)) {
                this.mUs = "";
                dIc().requestFocus();
                if (dIc().getText() != null && dIc().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dIc().getSelectionStart();
                    editable = dIc().getText();
                }
            } else if ("from_title".equals(this.mUs)) {
                this.mUs = "";
                dId().requestFocus();
                if (dId().getText() != null && dId().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dId().getSelectionStart();
                    editable = dId().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.lUv != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.lUv.getForumId(), 0L), this.lUv.getFirstDir(), this.lUv.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(t tVar) {
        if (((ImageSpan[]) dIc().getText().getSpans(0, dIc().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.mUC == null) {
                this.mUC = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.mUC.getView().isShown()) {
                this.mUC.cancel();
            }
            this.mUC.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, tVar, dIc());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dIc() {
        return this.mUy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dId() {
        return this.lUN;
    }

    protected void dIe() {
        if (dIc().getSelectionStart() > 0) {
            String substring = dIc().getText().toString().substring(0, dIc().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.hEV.matcher(substring);
            if (matcher.find()) {
                dIc().getText().delete(dIc().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dIc().getSelectionStart());
                return;
            }
            dIc().onKeyDown(67, this.hEW);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.eUz.setCancelListener(null);
        this.eUz.setTipString(R.string.sending);
        this.eUz.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.eUz.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtm() {
        if (this.lUv != null) {
            String str = "";
            String str2 = "";
            if (dId() != null) {
                str = dId().getText().toString();
            }
            if (dIc() != null) {
                str2 = dIc().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.lUv.getType() == 0 || this.lUv.getType() == 9 || this.lUv.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.lUw == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.lUv.setIsNoTitle(true);
                        } else {
                            this.lUv.setIsNoTitle(false);
                            xs(true);
                            return;
                        }
                    } else {
                        this.lUv.setIsNoTitle(false);
                        xs(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.lUv.setIsNoTitle(true);
                } else {
                    this.lUv.setIsNoTitle(false);
                    xs(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.mUO) {
                    xs(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    xs(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                xs(true);
            } else if (this.lUv.getVideoInfo() != null) {
                xs(true);
            } else {
                xs(false);
            }
        }
    }

    private void xs(boolean z) {
        ap.setNavbarTitleColor(this.kGw, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.eMt = new NewWriteModel(this);
        this.eMt.b(this.eMH);
        this.hJK = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.dte();
            }
        };
        this.lUv = new WriteData();
        if (bundle != null) {
            this.lUv.setType(bundle.getInt("type", 0));
            this.lUv.setForumId(bundle.getString("forum_id"));
            this.lUv.setForumName(bundle.getString("forum_name"));
            this.lUv.setFirstDir(bundle.getString("forum_first_dir"));
            this.lUv.setSecondDir(bundle.getString("forum_second_dir"));
            this.lUv.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.mUD = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.lUv.setIsAddition(this.mUD != null);
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
            this.lUv.setTitle(bundle.getString("write_title"));
            this.lUv.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.iwx = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.mUu = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.ShareInfo.class);
            }
            this.mBaijiahaoData = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.hQL = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.hQM = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.mNM = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.lUv.mDynamicForwardData = (ForwardUploadData) bundle.getSerializable(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA);
            str = string;
        } else {
            Intent intent = getIntent();
            this.lUv.setType(intent.getIntExtra("type", 0));
            this.lUv.setForumId(intent.getStringExtra("forum_id"));
            this.lUv.setForumName(intent.getStringExtra("forum_name"));
            this.lUv.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.lUv.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.lUv.setThreadId(intent.getStringExtra("thread_id"));
            this.mUD = (AdditionData) intent.getSerializableExtra("addition_data");
            this.lUv.setIsAddition(this.mUD != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.lUv.setTitle(intent.getStringExtra("write_title"));
            this.lUv.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.iwx = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.mUu = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            this.lUv.mDynamicForwardData = (ForwardUploadData) intent.getSerializableExtra(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA);
            this.hQL = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.hQM = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.mNM = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (this.lUv.mDynamicForwardData != null) {
            this.mRP = true;
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.lUv.getType() == 4 ? 6 : 9);
        this.lUv.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.mUu != null && this.mUu.videoId != null) {
            this.lUv.setVideoId(this.mUu.videoId);
            this.lUv.setOriginalVideoCover(this.mUu.showPicUrl);
            this.lUv.setOriginalVideoTitle(this.mUu.showText);
        }
        if (!at.isEmpty(this.hQL)) {
            if (!at.isEmpty(this.hQM)) {
                this.lUv.setContent("//@" + this.hQM + " :" + this.hQL);
            } else {
                this.lUv.setContent(this.hQL);
            }
        }
        if (this.lUv != null && this.lUv.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.lUv.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.mUv = true;
        }
        dHW();
    }

    private void dIf() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) y.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.lUN.setText(com.baidu.tbadk.plugins.b.Cz(com.baidu.tbadk.plugins.b.CA(hotTopicBussinessData.mTopicName)));
            this.lUN.setMovementMethod(com.baidu.tieba.view.c.dFi());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString Cz = com.baidu.tbadk.plugins.b.Cz(com.baidu.tbadk.plugins.b.CA(hotTopicBussinessData.mTopicName));
            if (Cz != null) {
                this.lUN.setText(Cz);
            }
            this.mUQ.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.lUv.getType());
        bundle.putString("forum_id", this.lUv.getForumId());
        bundle.putString("forum_name", this.lUv.getForumName());
        bundle.putString("forum_first_dir", this.lUv.getFirstDir());
        bundle.putString("forum_second_dir", this.lUv.getSecondDir());
        bundle.putString("thread_id", this.lUv.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.iwx);
        bundle.putSerializable("tab_list", this.mNM);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.mUD != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.mUD));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.iwx);
        if (this.lUv.mDynamicForwardData != null) {
            bundle.putSerializable(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA, this.lUv.mDynamicForwardData);
        }
        if (this.mUu != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mUu));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dIc().getEditableText().toString();
        if (obj != null) {
            dIc().setText(TbFaceManager.bsW().a(getPageContext().getPageActivity(), obj, this.mUV));
            dIc().setSelection(dIc().getText().length());
        }
    }

    private String dIg() {
        if (dIc() == null || dIc().getText() == null) {
            return "";
        }
        String obj = dIc().getText().toString();
        if (StringUtils.isNull(obj)) {
            if (this.mUu != null && this.mUu.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return obj;
    }

    private String dIh() {
        if (this.lUv == null || dId() == null || dId().getVisibility() != 0 || dId().getText() == null) {
            return "";
        }
        String obj = dId().getText().toString();
        if (this.mPrefixData != null && y.getCount(this.mPrefixData.getPrefixs()) > 0 && this.lUw != 0 && this.lUv.getType() != 4 && this.lUS != null && this.lUS.getText() != null) {
            obj = this.lUS.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            obj = this.mPrefixData.getImplicitTitle() + this.lUv.getTitle();
        }
        if (TextUtils.isEmpty(obj)) {
            return getString(R.string.share_txt_default);
        }
        return obj;
    }

    private void cqg() {
        if (this.lUv != null && this.lUv.mDynamicForwardData != null) {
            dGW();
            return;
        }
        dte();
        this.lUv.setContent(dIg());
        this.lUv.setTitle(dIh());
        if (this.mUJ >= 0) {
            this.lUv.setCategoryFrom(this.mUJ);
        }
        if (this.mUL >= 0) {
            this.lUv.setCategoryTo(this.mUL);
        }
        this.lUv.setWriteImagesInfo(this.writeImagesInfo);
        this.lUv.setHasLocationData(this.eMs != null && this.eMs.bXA());
        this.eMt.wi(this.writeImagesInfo.size() > 0);
        if (!y.isEmpty(this.mList) && this.mUP != null && this.mUP.mIsGlobalBlock == 0) {
            this.lUv.setForumId(String.valueOf(this.mUP.mForumId));
            this.lUv.setForumName(this.mUP.mForumName);
        }
        dGX();
        this.eMt.d(this.lUv);
        this.lUv.setContent(this.lUv.getContent().replaceAll("\u0000\n", ""));
        this.lUv.setContent(this.lUv.getContent().replaceAll("\u0000", ""));
        this.lUv.setVcode(null);
        this.eMt.cLa().setVoice(null);
        this.eMt.cLa().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.hJK);
        this.eMt.dxX();
    }

    private void dGX() {
        FrsTabItemData selectedTabItemData;
        if (this.lUv != null && this.mSl != null && (selectedTabItemData = this.mSl.getSelectedTabItemData()) != null) {
            this.lUv.setTabId(selectedTabItemData.tabId);
            this.lUv.setTabName(selectedTabItemData.name);
            this.lUv.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    private void dGW() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        this.lUv.mDynamicForwardData.forward_content = dIg();
        this.lUv.mDynamicForwardData.inputText = dIg();
        this.lUv.mDynamicForwardData.locationPoiId = "0";
        showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
        com.baidu.tieba.write.b.c.b.dGI().a(this.lUv.mDynamicForwardData, new b.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // com.baidu.tieba.write.b.c.b.a
            public void onSuccess(String str) {
                TransmitPostEditActivity.this.closeLoadingDialog();
                com.baidu.tieba.tbadkCore.writeModel.c.g(TransmitPostEditActivity.this.getPageContext().getPageActivity(), null, null, null);
                TransmitPostEditActivity.this.jr(true);
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
            if (this.mUD != null) {
                i2 = this.mUD.getTotalCount();
                i = this.mUD.getAlreadyCount() + 1;
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
                if (this.eKH != null && !this.eKH.bry()) {
                    dIc().requestFocus();
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
                            dIc().getText().insert(dIc().getSelectionStart(), sb.toString());
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
                        if (this.mUt) {
                            sb2.append(com.baidu.tbadk.plugins.b.eTS);
                            this.mUt = false;
                        }
                        sb2.append(stringExtra);
                        BU(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !y.isEmpty(this.mList) && !y.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.mUP = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.mUP);
            }
        } else if (i2 == 0) {
            if (this.eKH != null && !this.eKH.bry()) {
                this.mUy.requestFocus();
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
                        this.mUT.Sw(postWriteCallBackData.getErrorString());
                        this.mUT.bf(postWriteCallBackData.getSensitiveWords());
                        this.mUT.b(this.lUN, this.mUy);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.mUs)) {
                        dId().requestFocus();
                        return;
                    } else if ("from_content".equals(this.mUs)) {
                        dIc().requestFocus();
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
    public void dIi() {
        if ("1".equals(this.iwx)) {
            this.lUv.setCanNoForum(true);
            this.lUv.setTransmitForumData("[]");
        } else if ("2".equals(this.iwx)) {
            this.lUv.setCanNoForum(false);
        }
        dIj();
        this.lUv.setPrivacy(this.isPrivacy);
        this.lUv.setIsShareThread(true);
        if (this.mUu != null && !StringUtils.isNull(this.mUu.threadId)) {
            this.lUv.setOriginalThreadId(this.mUu.threadId);
        }
        this.lUv.setBaijiahaoData(this.mBaijiahaoData);
        if (this.mUu != null) {
            this.lUv.setOriBaijiahaoData(this.mUu.oriUgcInfo);
        }
        this.lUv.setCallFrom(this.iwx);
        cqg();
    }

    private void dIj() {
        if (this.eKH != null) {
            this.eKH.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dId());
        HidenSoftKeyPad(this.mInputManager, dIc());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.by(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.hUq) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.lUv.getType() != 7) {
                if (this.mUD == null) {
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
        this.eMy = i;
        if (this.eKH != null) {
            this.eKH.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void dIk() {
        if (!this.mUO && this.eKH != null) {
            this.eKH.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.eKH.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jr(boolean z) {
        if (this.eKH != null) {
            this.eKH.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void JP(int i) {
        if (i < this.mUB.size()) {
            for (int i2 = 0; i2 < this.mUB.size(); i2++) {
                this.mUB.get(i2).xe(false);
            }
            this.mUB.get(i).xe(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void Hs(int i) {
        this.lUw = i;
        this.lUT.setCurrentIndex(i);
        JP(i);
        this.lUS.setText(this.mPrefixData.getPrefixs().get(i));
        dtm();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.lUT, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.lUV.setSelected(false);
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
        if (this.lUv != null) {
            if (this.lUv.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.lUv.getType() == 5) {
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
            bsb();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.bdF = z;
        if (this.mUS != null && !z) {
            this.mUS.cfQ();
        }
        if (this.mUU != null && !z) {
            dHN();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.bdF && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.mUt = false;
            this.mUs = "";
            if ("from_content".equals(str)) {
                this.mUs = "from_content";
            } else if ("from_title".equals(str)) {
                this.mUs = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.Cy(String.valueOf(charSequence.charAt(i)))) {
                xr(false);
            }
        }
    }

    public void dnW() {
        if (!y.isEmpty(this.mList)) {
            this.mUx.setVisibility(0);
            this.mUx.requestFocus();
            return;
        }
        this.mUx.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dIl() {
        if (((ImageSpan[]) dIc().getText().getSpans(0, dIc().getText().length(), ImageSpan.class)).length > 10) {
            if (this.mUC == null) {
                this.mUC = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.mUC.getView().isShown()) {
                this.mUC.cancel();
            }
            this.mUC.show();
            return true;
        }
        return false;
    }
}
