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
/* loaded from: classes7.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0148a, i.a {
    private OriginalThreadCardView ajg;
    private LocationModel fBr;
    private NewWriteModel fBs;
    private EditorTools fzf;
    List<ab> gKl;
    private String iYs;
    private String iYt;
    private boolean isPrivacy;
    private BaijiahaoData mBaijiahaoData;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private FrsTabInfoData nUa;
    private OriginalThreadInfo.ShareInfo nZD;
    private LinearLayout nZF;
    private LinearLayout nZG;
    private View nZJ;
    private Toast nZL;
    private AdditionData nZM;
    private RelativeLayout nZN;
    private TextView nZO;
    private TextView nZP;
    private TextView nZQ;
    ab nZR;
    private int nZS;
    private String nZT;
    private int nZU;
    private PostCategoryView nZV;
    private HotTopicBussinessData nZY;
    private TextView nZZ;
    private com.baidu.tieba.write.i ncA;
    private ImageView ncB;
    private View ncC;
    private int ncd;
    private TextView ncz;
    private com.baidu.tieba.write.editor.b oab;
    private g oad;
    private ForumTabSelectedView oae;
    private com.baidu.tieba.view.b oal;
    private static final int nZA = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    private static final int fUr = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44);
    private String nZB = "";
    private boolean nZC = false;
    private WriteData ncc = null;
    private boolean nZE = false;
    private InputMethodManager mInputManager = null;
    private EditText ncu = null;
    private View ncv = null;
    private LinearLayout ncx = null;
    private SpanGroupEditText nZH = null;
    private FeedBackModel nZI = null;
    private ArrayList<WritePrefixItemLayout> nZK = new ArrayList<>();
    private final KeyEvent iME = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView lLu = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener iRs = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout loZ = null;
    private String fBw = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int fBx = 0;
    private View mRootView = null;
    private ScrollView nZW = null;
    private boolean nZX = false;
    private com.baidu.tbadk.core.view.a fJT = null;
    private String mFrom = "write";
    private String jHl = "2";
    private SpannableStringBuilder oaa = new SpannableStringBuilder();
    private boolean bnE = false;
    private final c oac = new c();
    private TbFaceManager.a oaf = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan CR(String str) {
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
    private final AntiHelper.a jbW = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", ax.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", ax.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d fBH = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.ncc != null) {
                TransmitPostEditActivity.this.oac.bh(null);
                if (z) {
                    TransmitPostEditActivity.this.kW(z);
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
                    TransmitPostEditActivity.this.oac.TW(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.oac.bh(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.oac.b(TransmitPostEditActivity.this.ncu, TransmitPostEditActivity.this.nZH);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.d(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.d(TransmitPostEditActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(TransmitPostEditActivity.this.getActivity());
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.Ad(TransmitPostEditActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.Ad(postWriteCallBackData.getErrorString());
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
                    aVar.b(TransmitPostEditActivity.this.getPageContext()).bqe();
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
                    writeData.setVcodeExtra(ahVar.bwn());
                    if (com.baidu.tbadk.t.a.DE(ahVar.bwm())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bwm())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a fBF = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bBP() {
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
    private final CustomMessageListener npA = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.fBr.yj(false);
                    TransmitPostEditActivity.this.fBr.gu(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.fBr.yj(true);
                TransmitPostEditActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener oag = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener oah = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.fzf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dVN = TransmitPostEditActivity.this.dVN();
            if (dVN >= 0 && dVN < TransmitPostEditActivity.this.nZH.getText().length()) {
                TransmitPostEditActivity.this.nZH.setSelection(dVN);
            }
        }
    };
    private boolean oai = true;
    private final View.OnFocusChangeListener hsU = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.ncu || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.lLu) {
                if (z) {
                    TransmitPostEditActivity.this.oai = true;
                    TransmitPostEditActivity.this.dVO();
                    if (TransmitPostEditActivity.this.fzf != null) {
                        TransmitPostEditActivity.this.fzf.bzl();
                    }
                    l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.ncu);
                } else if (view == TransmitPostEditActivity.this.ncu) {
                    TransmitPostEditActivity.this.ncz.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.nZH && z) {
                TransmitPostEditActivity.this.oai = false;
                TransmitPostEditActivity.this.dVO();
                TransmitPostEditActivity.this.fzf.bzl();
                l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.nZH);
            }
            TransmitPostEditActivity.this.dVT();
        }
    };
    private TextWatcher oaj = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String oan = "";
        private String oao;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.oao = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.oao != null ? this.oao.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dHG();
            TransmitPostEditActivity.this.dVU();
            EditText dWg = TransmitPostEditActivity.this.dWg();
            if (editable != null && dWg != null && dWg.getText() != null) {
                if (this.oan == null || !this.oan.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.oac != null) {
                        this.oan = dWg.getText().toString();
                        TransmitPostEditActivity.this.oac.b(dWg, true);
                        return;
                    }
                    return;
                }
                dWg.setSelection(dWg.getSelectionEnd());
            }
        }
    };
    private TextWatcher oak = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String oao;
        private String oap = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.oao = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.oao != null ? this.oao.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dHG();
            EditText dWf = TransmitPostEditActivity.this.dWf();
            if (editable != null && dWf != null && dWf.getText() != null) {
                int selectionEnd = dWf.getSelectionEnd();
                if (this.oap == null || !this.oap.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.oac != null) {
                        this.oap = dWf.getText().toString();
                        TransmitPostEditActivity.this.oac.b(dWf, false);
                        return;
                    }
                    return;
                }
                dWf.setSelection(selectionEnd);
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
    public void bBx() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void bBz() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bBB();
        } else if (this.fBr.dMe()) {
            bBx();
        } else {
            this.fBr.yj(false);
            a(1, true, (String) null);
            this.fBr.dMc();
        }
    }

    private void bBB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nu(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.a(1, true, (String) null);
                    TransmitPostEditActivity.this.fBr.dMg();
                } else {
                    TransmitPostEditActivity.this.fBF.bBP();
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
        aVar.bqe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dVN() {
        int selectionEnd = dWf().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dWf().getText().getSpans(0, dWf().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dWf().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dWf().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVO() {
        if (this.fzf != null) {
            this.fzf.setBarLauncherEnabled(!this.oai);
            this.fzf.setToolEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nZX) {
            this.ncu.setVisibility(8);
            dHG();
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
        this.fBr = new LocationModel(getPageContext());
        this.fBr.a(this.fBF);
        registerListener(this.npA);
        registerListener(this.oag);
        cXZ();
        this.nZH.requestFocus();
        dBM();
        dWo();
    }

    @SuppressLint({"ResourceAsColor"})
    private void cXZ() {
        this.fzf = new EditorTools(getActivity());
        this.fzf.setBarMaxLauCount(4);
        this.fzf.setMoreButtonAtEnd(true);
        this.fzf.setBarLauncherType(1);
        this.fzf.kK(true);
        this.fzf.kL(true);
        this.fzf.setBackgroundColorId(R.color.CAM_X0207);
        dVP();
        this.fzf.build();
        if (this.nZF != null) {
            this.nZF.addView(this.fzf);
        }
        cXz();
        this.fzf.rV();
        com.baidu.tbadk.editortools.h qM = this.fzf.qM(6);
        if (qM != null && !TextUtils.isEmpty(this.fBw)) {
            ((View) qM).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.fBw);
                }
            });
        }
        if (!this.nZX) {
            this.fzf.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.fzf.bzl();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.fzf.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.fzf.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.ncc.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.ncc.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        dVR();
    }

    private void dVP() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.fzf.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        if (this.nZM == null) {
            if (this.oab == null) {
                this.oab = new com.baidu.tieba.write.editor.b(getActivity(), this.jHl);
                this.oab.dUR();
                this.oab.setFrom("from_share_write");
                this.oab.bZ(this.ncc.getForumId(), this.mPrivateThread);
            }
            this.fzf.b(this.oab);
        }
        this.fzf.bL(arrayList);
        m qP = this.fzf.qP(5);
        if (qP != null) {
            qP.fzS = 1;
        }
    }

    private void cXz() {
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
                        if (TransmitPostEditActivity.this.dWe()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.dWe()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof u)) {
                            TransmitPostEditActivity.this.e((u) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.dWh();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.dHG();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.nZM == null) {
                            TransmitPostEditActivity.this.bBC();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.fBx) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ad.checkLocationForGoogle(pageActivity)) {
                                    TransmitPostEditActivity.this.bBz();
                                    return;
                                } else {
                                    ad.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.bBx();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.fBr != null) {
                            TransmitPostEditActivity.this.fBr.yj(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        aq aqVar = new aq("c10645");
                        if (TransmitPostEditActivity.this.ncc != null) {
                            str = TransmitPostEditActivity.this.ncc.getForumId();
                        } else {
                            str = "";
                        }
                        aqVar.dW("fid", str);
                        TiebaStatic.log(aqVar);
                        if (TransmitPostEditActivity.this.ncc == null || (videoInfo = TransmitPostEditActivity.this.ncc.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.fzf.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.fzf.bAT()) {
                                        TransmitPostEditActivity.this.fzf.bzl();
                                        TransmitPostEditActivity.this.fzf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.fzf.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.fzf.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.fzf.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.fzf.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.ncc.setVideoInfo(null);
                        TransmitPostEditActivity.this.dHG();
                        if (TransmitPostEditActivity.this.nZH != null) {
                            TransmitPostEditActivity.this.nZH.requestFocus();
                        }
                        TransmitPostEditActivity.this.fzf.bzl();
                        TransmitPostEditActivity.this.fzf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.nZH);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.fzf.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.nZC = true;
                        TransmitPostEditActivity.this.zm(true);
                        if (TransmitPostEditActivity.this.dWg().isFocused()) {
                            TransmitPostEditActivity.this.nZB = "from_title";
                        } else if (TransmitPostEditActivity.this.dWf().isFocused()) {
                            TransmitPostEditActivity.this.nZB = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.nZG.setVisibility(0);
                        TransmitPostEditActivity.this.nZG.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.nZG.hasFocus()) {
                            TransmitPostEditActivity.this.nZH.requestFocus();
                            TransmitPostEditActivity.this.nZH.setSelection(TransmitPostEditActivity.this.nZH.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.nZG.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.fzf.setActionListener(31, bVar);
        this.fzf.setActionListener(16, bVar);
        this.fzf.setActionListener(14, bVar);
        this.fzf.setActionListener(24, bVar);
        this.fzf.setActionListener(3, bVar);
        this.fzf.setActionListener(10, bVar);
        this.fzf.setActionListener(11, bVar);
        this.fzf.setActionListener(12, bVar);
        this.fzf.setActionListener(13, bVar);
        this.fzf.setActionListener(15, bVar);
        this.fzf.setActionListener(18, bVar);
        this.fzf.setActionListener(20, bVar);
        this.fzf.setActionListener(25, bVar);
        this.fzf.setActionListener(27, bVar);
        this.fzf.setActionListener(29, bVar);
        this.fzf.setActionListener(43, bVar);
        this.fzf.setActionListener(45, bVar);
        this.fzf.setActionListener(53, bVar);
        this.fzf.setActionListener(48, bVar);
        this.fzf.setActionListener(46, bVar);
        this.fzf.setActionListener(49, bVar);
        this.fzf.setActionListener(47, bVar);
        this.fzf.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBC() {
        if (this.fBr.ckC()) {
            if (this.fBr.dMe()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.b.dLZ().getLocationData().getFormatted_address());
                return;
            }
            a(1, true, (String) null);
            this.fBr.dMc();
            return;
        }
        a(0, true, (String) null);
    }

    protected void dHy() {
        if (this.fBs != null) {
            this.fBs.cancelLoadData();
        }
        if (this.nZI != null) {
            this.nZI.cancelLoadData();
        }
        if (this.fBr != null) {
            this.fBr.cancelLoadData();
        }
    }

    private void dVQ() {
        if (this.oad != null) {
            this.oad.hideTip();
        }
    }

    private void dVR() {
        if (this.oad == null) {
            this.oad = new g(getPageContext());
        }
        this.oad.d(this.fzf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dVQ();
        TiebaPrepareImageService.StopService();
        dHy();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVS() {
        if (this.ncc == null) {
            finish();
            return;
        }
        this.ncc.setTitle(dWg().getText().toString());
        this.ncc.setContent(dWf().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.ncA != null && this.ncA.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.ncA, getPageContext().getPageActivity());
                return true;
            } else if (this.fzf.bAT()) {
                this.fzf.bzl();
                return true;
            } else {
                dHy();
                dVS();
                return true;
            }
        }
        if (i == 67 && (text = dWf().getText()) != null) {
            int selectionStart = dWf().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dWf().onKeyDown(67, this.iME);
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
        getLayoutMode().onModeChanged(this.loZ);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ao.setViewTextColor(this.lLu, R.color.CAM_X0302, 1);
        dVO();
        ao.setBackgroundColor(this.ncv, R.color.CAM_X0204);
        ao.setBackgroundColor(dWg(), R.color.CAM_X0201);
        ao.setBackgroundColor(dWf(), R.color.CAM_X0201);
        dHG();
        this.fzf.onChangeSkinType(i);
        if (this.nZV != null) {
            this.nZV.btV();
        }
        ao.setViewTextColor(this.mName, R.color.CAM_X0105);
        dVT();
        dVU();
        if (this.oac != null) {
            this.oac.c(dWg(), dWf());
        }
        if (this.ajg != null) {
            this.ajg.onChangeSkinType();
        }
        if (this.oae != null) {
            this.oae.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVT() {
        if (this.ncu.hasFocus()) {
            this.ncu.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        } else {
            this.ncu.setHintTextColor(ao.getColor(R.color.CAM_X0109));
        }
        if (this.nZH.hasFocus()) {
            this.nZH.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        } else {
            this.nZH.setHintTextColor(ao.getColor(R.color.CAM_X0109));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVU() {
        if (this.ncu != null) {
            if (this.ncu.getText().toString().length() == 0) {
                this.ncu.getPaint().setFakeBoldText(false);
            } else if (this.ncu.getText().toString().length() > 0) {
                this.ncu.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.fJT = new com.baidu.tbadk.core.view.a(getPageContext());
        this.nZX = this.ncc.getType() == 4 || 5 == this.ncc.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bsx().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ao.setViewTextColor(this.mName, R.color.CAM_X0105);
        dVX();
        this.nZW = (ScrollView) findViewById(R.id.write_scrollview);
        this.nZW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.nZH != null) {
                        l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.nZH);
                    }
                    if (TransmitPostEditActivity.this.fzf != null) {
                        TransmitPostEditActivity.this.fzf.bzl();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.loZ = (RelativeLayout) findViewById(R.id.parent);
        this.nZF = (LinearLayout) findViewById(R.id.tool_view);
        this.nZF.setContentDescription(IStringUtil.TOP_PATH);
        this.nZG = (LinearLayout) findViewById(R.id.title_view);
        this.ncv = findViewById(R.id.interval_view);
        this.nZZ = (TextView) findViewById(R.id.hot_topic_title_edt);
        dHF();
        if (this.nZX) {
            this.nZW.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        dHH();
        dWd();
        this.ncx = (LinearLayout) findViewById(R.id.post_content_container);
        this.ncx.setDrawingCacheEnabled(false);
        this.ncx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.fzf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.nZH.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.hsU);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.dHy();
                TransmitPostEditActivity.this.dVS();
            }
        });
        dWa();
        dWc();
        dVW();
        dVO();
        dWb();
        dHE();
        dWi();
        dVV();
        if (this.ncc.getType() == 4 && this.ncC != null && this.nZJ != null) {
            this.ncC.setVisibility(8);
            this.nZJ.setVisibility(8);
        }
        dHG();
        ShowSoftKeyPad(this.mInputManager, this.ncu);
    }

    private void dVV() {
        this.oae = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.oae.setBgColor(R.color.CAM_X0205);
        this.oae.setData(this.nUa);
        this.oae.setActivity(this);
    }

    private void dVW() {
        String str;
        String str2;
        if (this.ncc != null) {
            switch (this.ncc.getType()) {
                case 0:
                case 9:
                    if (this.jHl != null && this.jHl.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                    } else if (this.jHl != null && this.jHl.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.ncc.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.ncu.setVisibility(0);
                    this.nZH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.nZH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.nZH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.ncu.setVisibility(8);
                    return;
            }
        }
    }

    private void dVX() {
        this.lLu = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lLu.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.lLu.setLayoutParams(layoutParams);
        this.lLu.setOnFocusChangeListener(this.hsU);
    }

    private void dVY() {
        if (this.ncc != null && this.ncc.getType() == 0 && this.ncc.getType() == 9 && !this.nZE && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = at.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dWg() != null) {
                dWg().setText(cutStringWithSuffix);
                dWg().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void dVZ() {
        this.gKl = null;
        this.nZS = -1;
        this.nZU = -1;
        com.baidu.tieba.frs.ad yN = ac.cDm().yN(1);
        if (yN != null) {
            this.gKl = yN.jfc;
            this.nZS = getIntent().getIntExtra("category_id", -1);
            if (this.gKl != null && !this.gKl.isEmpty() && this.nZS >= 0) {
                this.nZR = new ab();
                this.nZR.jeY = 0;
                this.nZR.name = getPageContext().getResources().getString(R.string.category_auto);
                this.nZU = this.nZR.jeY;
                this.nZT = this.nZR.name;
                for (ab abVar : this.gKl) {
                    if (abVar.jeY == this.nZS) {
                        this.nZU = abVar.jeY;
                        this.nZT = abVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dWa() {
        if (this.gKl != null && !this.gKl.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.nZV = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.nZV.setText(this.nZT);
            this.nZV.setCategoryContainerData(this.gKl, this.nZR, this.nZU);
            this.nZV.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bc bcVar) {
                    if (bcVar != null) {
                        TransmitPostEditActivity.this.nZV.setText(bcVar.name);
                        TransmitPostEditActivity.this.ncc.setCategoryTo(bcVar.jeY);
                        TransmitPostEditActivity.this.nZU = bcVar.jeY;
                        TransmitPostEditActivity.this.nZV.dVp();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.nZV.dVo();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dWg());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dWf());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.oal = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.oal.setTitle(R.string.no_disturb_start_time);
        this.oal.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.oal);
        this.oal.setButton(-2, getPageContext().getString(R.string.cancel), this.oal);
        return this.oal;
    }

    private void dWb() {
        this.nZN = (RelativeLayout) findViewById(R.id.addition_container);
        this.nZO = (TextView) findViewById(R.id.addition_create_time);
        this.nZP = (TextView) findViewById(R.id.addition_last_time);
        this.nZQ = (TextView) findViewById(R.id.addition_last_content);
        if (this.nZM != null) {
            this.nZN.setVisibility(0);
            this.nZO.setText(getPageContext().getString(R.string.write_addition_create) + at.getFormatTime(this.nZM.getCreateTime() * 1000));
            if (this.nZM.getAlreadyCount() == 0) {
                this.nZP.setVisibility(8);
            } else {
                this.nZP.setText(getPageContext().getString(R.string.write_addition_last) + at.getFormatTime(this.nZM.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.nZM.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.nZQ.setText(lastAdditionContent);
            } else {
                this.nZQ.setVisibility(8);
            }
            dWf().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.nZM.getAlreadyCount()), Integer.valueOf(this.nZM.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.nZN.setVisibility(8);
    }

    private void dHE() {
        this.ncC = findViewById(R.id.post_prefix_layout);
        this.ncz = (TextView) findViewById(R.id.post_prefix);
        this.nZJ = findViewById(R.id.prefix_divider);
        this.ncB = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.ncC.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.ncd = 1;
            this.ncC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.ncz.setVisibility(0);
                    TransmitPostEditActivity.this.ncC.setSelected(true);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.ncA, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.fzf.bzl();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.ncu);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.nZH);
                }
            });
            this.ncB = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.ncB.setVisibility(0);
                this.ncz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.ncz.setSelected(true);
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.ncA, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.fzf.bzl();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dWg());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dWf());
                    }
                });
            }
            this.ncA = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.ncA.a(this);
            this.ncA.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.ncA.setOutsideTouchable(true);
            this.ncA.setFocusable(true);
            this.ncA.setOnDismissListener(this);
            this.ncA.setBackgroundDrawable(ao.getDrawable(R.color.CAM_X0201));
            int color = ao.getColor(R.color.CAM_X0105);
            int color2 = ao.getColor(R.color.CAM_X0108);
            ao.setBackgroundResource(this.ncz, R.color.CAM_X0201);
            ao.setImageResource(this.ncB, R.drawable.icon_frs_arrow_n);
            this.ncz.setTextColor(color);
            this.nZK.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.nZK.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.ncA.addView(writePrefixItemLayout);
            }
            this.ncA.setCurrentIndex(0);
            this.ncz.setText(prefixs.get(1));
            Lf(1);
            return;
        }
        this.ncC.setVisibility(8);
    }

    protected void dWc() {
        this.lLu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick() && !TransmitPostEditActivity.this.dWp()) {
                    if (TransmitPostEditActivity.this.oac.a(TransmitPostEditActivity.this.ncu, TransmitPostEditActivity.this.nZH)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.oac.dUd());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dWg());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dWf());
                    TransmitPostEditActivity.this.fzf.bzl();
                    TiebaStatic.log(new aq("c12608").an("obj_locate", 7));
                    TransmitPostEditActivity.this.dWm();
                }
            }
        });
    }

    protected void dHF() {
        this.ncu = (EditText) findViewById(R.id.post_title);
        this.ncu.setOnClickListener(this.oah);
        this.ncu.setOnFocusChangeListener(this.hsU);
        if ((this.ncc.getType() == 0 || this.ncc.getType() == 9 || this.ncc.getType() == 7) && this.ncc.getTitle() != null) {
            this.ncu.setText(this.ncc.getTitle());
            this.ncu.setSelection(this.ncc.getTitle().length());
        }
        this.ncu.addTextChangedListener(this.oaj);
        if (!this.ncc.getHaveDraft()) {
            dVY();
        }
        this.ncu.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void dHH() {
        this.nZH = (SpanGroupEditText) findViewById(R.id.post_content);
        this.nZH.setDrawingCacheEnabled(false);
        this.nZH.setOnClickListener(this.oah);
        if (this.fBs != null) {
            this.fBs.setSpanGroupManager(this.nZH.getSpanGroupManager());
        }
        if (this.ncc != null) {
            this.ncc.setSpanGroupManager(this.nZH.getSpanGroupManager());
        }
        if (this.ncc.getContent() != null && this.ncc.getContent().length() > 0) {
            this.nZH.setText(TbFaceManager.bCw().aE(getPageContext().getPageActivity(), this.ncc.getContent()));
            this.nZH.setSelection(this.nZH.getText().length());
        }
        if (!at.isEmpty(this.iYs)) {
            this.nZH.setSelection(0);
        }
        this.nZH.setOnFocusChangeListener(this.hsU);
        this.nZH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.fzf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.nZH.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.nZH.addTextChangedListener(this.oak);
        if (this.nZD != null && this.nZD.showType == 3) {
            this.nZH.setHint(R.string.share_video_default);
        } else {
            this.nZH.setHint(R.string.share_txt_default);
        }
    }

    private void dWd() {
        this.ajg = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajg.getLayoutParams();
        layoutParams.topMargin -= nZA;
        layoutParams.leftMargin = fUr;
        layoutParams.rightMargin = fUr;
        this.ajg.setLayoutParams(layoutParams);
        this.ajg.setVisibility(0);
        this.ajg.a(this.nZD);
        this.ajg.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dWe() {
        int i = 5000;
        if (this.nZM != null) {
            i = 1000;
        }
        return dWf().getText() != null && dWf().getText().length() >= i;
    }

    private void CB(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.nZB)) {
                this.nZB = "";
                dWf().requestFocus();
                if (dWf().getText() != null && dWf().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dWf().getSelectionStart();
                    editable = dWf().getText();
                }
            } else if ("from_title".equals(this.nZB)) {
                this.nZB = "";
                dWg().requestFocus();
                if (dWg().getText() != null && dWg().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dWg().getSelectionStart();
                    editable = dWg().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zm(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.ncc != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.ncc.getForumId(), 0L), this.ncc.getFirstDir(), this.ncc.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(u uVar) {
        if (((ImageSpan[]) dWf().getText().getSpans(0, dWf().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.nZL == null) {
                this.nZL = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.nZL.getView().isShown()) {
                this.nZL.cancel();
            }
            this.nZL.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, uVar, dWf());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dWf() {
        return this.nZH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dWg() {
        return this.ncu;
    }

    protected void dWh() {
        if (dWf().getSelectionStart() > 0) {
            String substring = dWf().getText().toString().substring(0, dWf().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.iMD.matcher(substring);
            if (matcher.find()) {
                dWf().getText().delete(dWf().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dWf().getSelectionStart());
                return;
            }
            dWf().onKeyDown(67, this.iME);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.fJT.setCancelListener(null);
        this.fJT.setTipString(R.string.sending);
        this.fJT.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.fJT.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHG() {
        if (this.ncc != null) {
            String str = "";
            String str2 = "";
            if (dWg() != null) {
                str = dWg().getText().toString();
            }
            if (dWf() != null) {
                str2 = dWf().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.ncc.getType() == 0 || this.ncc.getType() == 9 || this.ncc.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.ncd == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.ncc.setIsNoTitle(true);
                        } else {
                            this.ncc.setIsNoTitle(false);
                            zn(true);
                            return;
                        }
                    } else {
                        this.ncc.setIsNoTitle(false);
                        zn(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.ncc.setIsNoTitle(true);
                } else {
                    this.ncc.setIsNoTitle(false);
                    zn(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.nZX) {
                    zn(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    zn(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                zn(true);
            } else if (this.ncc.getVideoInfo() != null) {
                zn(true);
            } else {
                zn(false);
            }
        }
    }

    private void zn(boolean z) {
        ao.setNavbarTitleColor(this.lLu, R.color.CAM_X0302, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.fBs = new NewWriteModel(this);
        this.fBs.b(this.fBH);
        this.iRs = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.dHy();
            }
        };
        this.ncc = new WriteData();
        if (bundle != null) {
            this.ncc.setType(bundle.getInt("type", 0));
            this.ncc.setForumId(bundle.getString("forum_id"));
            this.ncc.setForumName(bundle.getString("forum_name"));
            this.ncc.setFirstDir(bundle.getString("forum_first_dir"));
            this.ncc.setSecondDir(bundle.getString("forum_second_dir"));
            this.ncc.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.nZM = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.ncc.setIsAddition(this.nZM != null);
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
            this.ncc.setTitle(bundle.getString("write_title"));
            this.ncc.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.jHl = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.nZD = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.ShareInfo.class);
            }
            this.mBaijiahaoData = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.iYs = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.iYt = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.nUa = (FrsTabInfoData) bundle.getSerializable("tab_list");
            str = string;
        } else {
            Intent intent = getIntent();
            this.ncc.setType(intent.getIntExtra("type", 0));
            this.ncc.setForumId(intent.getStringExtra("forum_id"));
            this.ncc.setForumName(intent.getStringExtra("forum_name"));
            this.ncc.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.ncc.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.ncc.setThreadId(intent.getStringExtra("thread_id"));
            this.nZM = (AdditionData) intent.getSerializableExtra("addition_data");
            this.ncc.setIsAddition(this.nZM != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.ncc.setTitle(intent.getStringExtra("write_title"));
            this.ncc.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.jHl = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.nZD = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            this.iYs = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.iYt = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.nUa = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.ncc.getType() == 4 ? 6 : 9);
        this.ncc.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.nZD != null && this.nZD.videoId != null) {
            this.ncc.setVideoId(this.nZD.videoId);
            this.ncc.setOriginalVideoCover(this.nZD.showPicUrl);
            this.ncc.setOriginalVideoTitle(this.nZD.showText);
        }
        if (!at.isEmpty(this.iYs)) {
            if (!at.isEmpty(this.iYt)) {
                this.ncc.setContent("//@" + this.iYt + " :" + this.iYs);
            } else {
                this.ncc.setContent(this.iYs);
            }
        }
        if (this.ncc != null && this.ncc.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.ncc.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.nZE = true;
        }
        dVZ();
    }

    private void dWi() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) x.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.ncu.setText(com.baidu.tbadk.plugins.b.Dj(com.baidu.tbadk.plugins.b.Dk(hotTopicBussinessData.mTopicName)));
            this.ncu.setMovementMethod(com.baidu.tieba.view.c.dTE());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString Dj = com.baidu.tbadk.plugins.b.Dj(com.baidu.tbadk.plugins.b.Dk(hotTopicBussinessData.mTopicName));
            if (Dj != null) {
                this.ncu.setText(Dj);
            }
            this.nZZ.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.ncc.getType());
        bundle.putString("forum_id", this.ncc.getForumId());
        bundle.putString("forum_name", this.ncc.getForumName());
        bundle.putString("forum_first_dir", this.ncc.getFirstDir());
        bundle.putString("forum_second_dir", this.ncc.getSecondDir());
        bundle.putString("thread_id", this.ncc.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jHl);
        bundle.putSerializable("tab_list", this.nUa);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.nZM != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.nZM));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jHl);
        if (this.nZD != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.nZD));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dWf().getEditableText().toString();
        if (obj != null) {
            dWf().setText(TbFaceManager.bCw().a(getPageContext().getPageActivity(), obj, this.oaf));
            dWf().setSelection(dWf().getText().length());
        }
    }

    private String dWj() {
        if (dWf() == null || dWf().getText() == null) {
            return "";
        }
        String obj = dWf().getText().toString();
        if (StringUtils.isNull(obj)) {
            if (this.nZD != null && this.nZD.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return obj;
    }

    private String dWk() {
        if (this.ncc == null || dWg() == null || dWg().getVisibility() != 0 || dWg().getText() == null) {
            return "";
        }
        String obj = dWg().getText().toString();
        if (this.mPrefixData != null && x.getCount(this.mPrefixData.getPrefixs()) > 0 && this.ncd != 0 && this.ncc.getType() != 4 && this.ncz != null && this.ncz.getText() != null) {
            obj = this.ncz.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            obj = this.mPrefixData.getImplicitTitle() + this.ncc.getTitle();
        }
        if (TextUtils.isEmpty(obj)) {
            if (TextUtils.isEmpty(this.ncc.getContent())) {
                return getString(R.string.share_txt_default);
            }
            if (getString(R.string.share_txt_default).equals(this.ncc.getContent())) {
                return getString(R.string.share_txt_default);
            }
            if (getString(R.string.share_video_default).equals(this.ncc.getContent())) {
                return getString(R.string.share_video_default);
            }
            return obj;
        }
        return obj;
    }

    private void cFE() {
        dHy();
        this.ncc.setContent(dWj());
        this.ncc.setTitle(dWk());
        if (this.nZS >= 0) {
            this.ncc.setCategoryFrom(this.nZS);
        }
        if (this.nZU >= 0) {
            this.ncc.setCategoryTo(this.nZU);
        }
        this.ncc.setWriteImagesInfo(this.writeImagesInfo);
        this.ncc.setHasLocationData(this.fBr != null && this.fBr.ckC());
        this.fBs.yl(this.writeImagesInfo.size() > 0);
        if (!x.isEmpty(this.mList) && this.nZY != null && this.nZY.mIsGlobalBlock == 0) {
            this.ncc.setForumId(String.valueOf(this.nZY.mForumId));
            this.ncc.setForumName(this.nZY.mForumName);
        }
        dWl();
        this.fBs.f(this.ncc);
        this.ncc.setContent(this.ncc.getContent().replaceAll("\u0000\n", ""));
        this.ncc.setContent(this.ncc.getContent().replaceAll("\u0000", ""));
        this.ncc.setVcode(null);
        this.fBs.cYx().setVoice(null);
        this.fBs.cYx().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.iRs);
        this.fBs.dMK();
    }

    private void dWl() {
        FrsTabItemData selectedTabItemData;
        if (this.ncc != null && this.oae != null && (selectedTabItemData = this.oae.getSelectedTabItemData()) != null) {
            this.ncc.setTabId(selectedTabItemData.tabId);
            this.ncc.setTabName(selectedTabItemData.name);
            this.ncc.setIsGeneralTab(selectedTabItemData.isGeneralTab);
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
            if (this.nZM != null) {
                i2 = this.nZM.getTotalCount();
                i = this.nZM.getAlreadyCount() + 1;
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
                if (this.fzf != null && !this.fzf.bAT()) {
                    dWf().requestFocus();
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
                            dWf().getText().insert(dWf().getSelectionStart(), sb.toString());
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
                        if (this.nZC) {
                            sb2.append(com.baidu.tbadk.plugins.b.fJn);
                            this.nZC = false;
                        }
                        sb2.append(stringExtra);
                        CB(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !x.isEmpty(this.mList) && !x.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.nZY = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.nZY);
            }
        } else if (i2 == 0) {
            if (this.fzf != null && !this.fzf.bAT()) {
                this.nZH.requestFocus();
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
                        this.oac.TW(postWriteCallBackData.getErrorString());
                        this.oac.bh(postWriteCallBackData.getSensitiveWords());
                        this.oac.b(this.ncu, this.nZH);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.nZB)) {
                        dWg().requestFocus();
                        return;
                    } else if ("from_content".equals(this.nZB)) {
                        dWf().requestFocus();
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
    public void dWm() {
        if ("1".equals(this.jHl)) {
            this.ncc.setCanNoForum(true);
            this.ncc.setTransmitForumData("[]");
        } else if ("2".equals(this.jHl)) {
            this.ncc.setCanNoForum(false);
        }
        dWn();
        this.ncc.setPrivacy(this.isPrivacy);
        this.ncc.setIsShareThread(true);
        if (this.nZD != null && !StringUtils.isNull(this.nZD.threadId)) {
            this.ncc.setOriginalThreadId(this.nZD.threadId);
        }
        this.ncc.setBaijiahaoData(this.mBaijiahaoData);
        if (this.nZD != null) {
            this.ncc.setOriBaijiahaoData(this.nZD.oriUgcInfo);
        }
        this.ncc.setCallFrom(this.jHl);
        cFE();
    }

    private void dWn() {
        if (this.fzf != null) {
            this.fzf.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dWg());
        HidenSoftKeyPad(this.mInputManager, dWf());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bQ(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.jbW) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).an("obj_locate", ax.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.ncc.getType() != 7) {
                if (this.nZM == null) {
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
        this.fBx = i;
        if (this.fzf != null) {
            this.fzf.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void dWo() {
        if (!this.nZX && this.fzf != null) {
            this.fzf.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.fzf.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kW(boolean z) {
        if (this.fzf != null) {
            this.fzf.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Lf(int i) {
        if (i < this.nZK.size()) {
            for (int i2 = 0; i2 < this.nZK.size(); i2++) {
                this.nZK.get(i2).zd(false);
            }
            this.nZK.get(i).zd(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void IO(int i) {
        this.ncd = i;
        this.ncA.setCurrentIndex(i);
        Lf(i);
        this.ncz.setText(this.mPrefixData.getPrefixs().get(i));
        dHG();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.ncA, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.ncC.setSelected(false);
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
        if (this.ncc != null) {
            if (this.ncc.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.ncc.getType() == 5) {
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
            bBz();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.bnE = z;
        if (this.oab != null && !z) {
            this.oab.cvg();
        }
        if (this.oad != null && !z) {
            dVQ();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.bnE && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.nZC = false;
            this.nZB = "";
            if ("from_content".equals(str)) {
                this.nZB = "from_content";
            } else if ("from_title".equals(str)) {
                this.nZB = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.Di(String.valueOf(charSequence.charAt(i)))) {
                zm(false);
            }
        }
    }

    public void dBM() {
        if (!x.isEmpty(this.mList)) {
            this.nZG.setVisibility(0);
            this.nZG.requestFocus();
            return;
        }
        this.nZG.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dWp() {
        if (((ImageSpan[]) dWf().getText().getSpans(0, dWf().getText().length(), ImageSpan.class)).length > 10) {
            if (this.nZL == null) {
                this.nZL = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.nZL.getView().isShown()) {
                this.nZL.cancel();
            }
            this.nZL.show();
            return true;
        }
        return false;
    }
}
