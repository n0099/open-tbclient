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
/* loaded from: classes8.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0148a, i.a {
    private OriginalThreadCardView aiU;
    private EditorTools fBu;
    private LocationModel fDG;
    private NewWriteModel fDH;
    List<ab> gNf;
    private boolean isPrivacy;
    private String jen;
    private String jeo;
    private BaijiahaoData mBaijiahaoData;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private TextView nmH;
    private com.baidu.tieba.write.i nmI;
    private ImageView nmJ;
    private View nmK;
    private int nml;
    private FrsTabInfoData oeH;
    private OriginalThreadInfo.ShareInfo ojZ;
    private ForumTabSelectedView okA;
    private com.baidu.tieba.view.b okH;
    private LinearLayout okb;
    private LinearLayout okc;
    private View okf;
    private Toast okh;
    private AdditionData oki;
    private RelativeLayout okj;
    private TextView okk;
    private TextView okl;
    private TextView okm;
    ab okn;
    private int oko;
    private String okp;
    private int okq;
    private PostCategoryView okr;
    private HotTopicBussinessData oku;
    private TextView okv;
    private com.baidu.tieba.write.editor.b okx;
    private g okz;
    private static final int ojW = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    private static final int fWF = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44);
    private String ojX = "";
    private boolean ojY = false;
    private WriteData nmk = null;
    private boolean oka = false;
    private InputMethodManager mInputManager = null;
    private EditText nmC = null;
    private View nmD = null;
    private LinearLayout nmF = null;
    private SpanGroupEditText okd = null;
    private FeedBackModel oke = null;
    private ArrayList<WritePrefixItemLayout> okg = new ArrayList<>();
    private final KeyEvent iSz = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView lUF = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener iXn = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout lxr = null;
    private String fDL = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int fDM = 0;
    private View mRootView = null;
    private ScrollView oks = null;
    private boolean okt = false;
    private com.baidu.tbadk.core.view.a fMe = null;
    private String mFrom = "write";
    private String jNd = "2";
    private SpannableStringBuilder okw = new SpannableStringBuilder();
    private boolean brf = false;
    private final c oky = new c();
    private TbFaceManager.a okB = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan Dg(String str) {
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
    private final AntiHelper.a jhQ = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ap("obj_locate", ay.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ap("obj_locate", ay.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d fDW = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.nmk != null) {
                TransmitPostEditActivity.this.oky.bg(null);
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
                    TransmitPostEditActivity.this.oky.Vh(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.oky.bg(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.oky.b(TransmitPostEditActivity.this.nmC, TransmitPostEditActivity.this.okd);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.d(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.d(TransmitPostEditActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(TransmitPostEditActivity.this.getActivity());
                    if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.Au(TransmitPostEditActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.Au(postWriteCallBackData.getErrorString());
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
                            TiebaStatic.log(new ar("c13746").ap("obj_locate", 1).ap("obj_type", 1));
                        }
                    });
                    aVar.b(TransmitPostEditActivity.this.getPageContext()).bqx();
                    TiebaStatic.log(new ar("c13745").ap("obj_locate", 1).ap("obj_type", 1));
                } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bwF());
                    if (com.baidu.tbadk.t.a.DY(ahVar.bwE())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bwE())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a fDU = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bCh() {
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
    private final CustomMessageListener nzK = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.fDG.yC(false);
                    TransmitPostEditActivity.this.fDG.gC(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.fDG.yC(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener okC = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener okD = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dYg = TransmitPostEditActivity.this.dYg();
            if (dYg >= 0 && dYg < TransmitPostEditActivity.this.okd.getText().length()) {
                TransmitPostEditActivity.this.okd.setSelection(dYg);
            }
        }
    };
    private boolean okE = true;
    private final View.OnFocusChangeListener hxs = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.nmC || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.lUF) {
                if (z) {
                    TransmitPostEditActivity.this.okE = true;
                    TransmitPostEditActivity.this.dYh();
                    if (TransmitPostEditActivity.this.fBu != null) {
                        TransmitPostEditActivity.this.fBu.bzD();
                    }
                    l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.nmC);
                } else if (view == TransmitPostEditActivity.this.nmC) {
                    TransmitPostEditActivity.this.nmH.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.okd && z) {
                TransmitPostEditActivity.this.okE = false;
                TransmitPostEditActivity.this.dYh();
                TransmitPostEditActivity.this.fBu.bzD();
                l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.okd);
            }
            TransmitPostEditActivity.this.dYm();
        }
    };
    private TextWatcher okF = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String okJ = "";
        private String okK;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.okK = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.okK != null ? this.okK.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dJZ();
            TransmitPostEditActivity.this.dYn();
            EditText dYz = TransmitPostEditActivity.this.dYz();
            if (editable != null && dYz != null && dYz.getText() != null) {
                if (this.okJ == null || !this.okJ.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.oky != null) {
                        this.okJ = dYz.getText().toString();
                        TransmitPostEditActivity.this.oky.b(dYz, true);
                        return;
                    }
                    return;
                }
                dYz.setSelection(dYz.getSelectionEnd());
            }
        }
    };
    private TextWatcher okG = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String okK;
        private String okL = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.okK = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.okK != null ? this.okK.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dJZ();
            EditText dYy = TransmitPostEditActivity.this.dYy();
            if (editable != null && dYy != null && dYy.getText() != null) {
                int selectionEnd = dYy.getSelectionEnd();
                if (this.okL == null || !this.okL.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.oky != null) {
                        this.okL = dYy.getText().toString();
                        TransmitPostEditActivity.this.oky.b(dYy, false);
                        return;
                    }
                    return;
                }
                dYy.setSelection(selectionEnd);
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
    public void bBP() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void bBR() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bBT();
        } else if (this.fDG.dOx()) {
            bBP();
        } else {
            this.fDG.yC(false);
            b(1, true, null);
            this.fDG.dOv();
        }
    }

    private void bBT() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nx(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.fDG.dOz();
                } else {
                    TransmitPostEditActivity.this.fDU.bCh();
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
        aVar.bqx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dYg() {
        int selectionEnd = dYy().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dYy().getText().getSpans(0, dYy().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dYy().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dYy().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYh() {
        if (this.fBu != null) {
            this.fBu.setBarLauncherEnabled(!this.okE);
            this.fBu.setToolEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.okt) {
            this.nmC.setVisibility(8);
            dJZ();
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
        this.fDG = new LocationModel(getPageContext());
        this.fDG.a(this.fDU);
        registerListener(this.nzK);
        registerListener(this.okC);
        dae();
        this.okd.requestFocus();
        dEc();
        dYH();
    }

    @SuppressLint({"ResourceAsColor"})
    private void dae() {
        this.fBu = new EditorTools(getActivity());
        this.fBu.setBarMaxLauCount(4);
        this.fBu.setMoreButtonAtEnd(true);
        this.fBu.setBarLauncherType(1);
        this.fBu.kN(true);
        this.fBu.kO(true);
        this.fBu.setBackgroundColorId(R.color.CAM_X0207);
        dYi();
        this.fBu.build();
        if (this.okb != null) {
            this.okb.addView(this.fBu);
        }
        cZE();
        this.fBu.display();
        com.baidu.tbadk.editortools.h qR = this.fBu.qR(6);
        if (qR != null && !TextUtils.isEmpty(this.fDL)) {
            ((View) qR).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.fDL);
                }
            });
        }
        if (!this.okt) {
            this.fBu.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.fBu.bzD();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.fBu.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.fBu.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.nmk.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.nmk.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        dYk();
    }

    private void dYi() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.fBu.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        if (this.oki == null) {
            if (this.okx == null) {
                this.okx = new com.baidu.tieba.write.editor.b(getActivity(), this.jNd);
                this.okx.dXn();
                this.okx.setFrom("from_share_write");
                this.okx.ca(this.nmk.getForumId(), this.mPrivateThread);
            }
            this.fBu.b(this.okx);
        }
        this.fBu.bG(arrayList);
        m qU = this.fBu.qU(5);
        if (qU != null) {
            qU.fCh = 1;
        }
    }

    private void cZE() {
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
                            TiebaStatic.log(new ar("c12608").ap("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.dYx()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.dYx()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof u)) {
                            TransmitPostEditActivity.this.e((u) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.dYA();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.dJZ();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.oki == null) {
                            TransmitPostEditActivity.this.bBU();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.fDM) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ae.checkLocationForGoogle(pageActivity)) {
                                    TransmitPostEditActivity.this.bBR();
                                    return;
                                } else {
                                    ae.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.bBP();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.fDG != null) {
                            TransmitPostEditActivity.this.fDG.yC(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        ar arVar = new ar("c10645");
                        if (TransmitPostEditActivity.this.nmk != null) {
                            str = TransmitPostEditActivity.this.nmk.getForumId();
                        } else {
                            str = "";
                        }
                        arVar.dR("fid", str);
                        TiebaStatic.log(arVar);
                        if (TransmitPostEditActivity.this.nmk == null || (videoInfo = TransmitPostEditActivity.this.nmk.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.fBu.bBl()) {
                                        TransmitPostEditActivity.this.fBu.bzD();
                                        TransmitPostEditActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.nmk.setVideoInfo(null);
                        TransmitPostEditActivity.this.dJZ();
                        if (TransmitPostEditActivity.this.okd != null) {
                            TransmitPostEditActivity.this.okd.requestFocus();
                        }
                        TransmitPostEditActivity.this.fBu.bzD();
                        TransmitPostEditActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.okd);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.ojY = true;
                        TransmitPostEditActivity.this.zH(true);
                        if (TransmitPostEditActivity.this.dYz().isFocused()) {
                            TransmitPostEditActivity.this.ojX = "from_title";
                        } else if (TransmitPostEditActivity.this.dYy().isFocused()) {
                            TransmitPostEditActivity.this.ojX = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.okc.setVisibility(0);
                        TransmitPostEditActivity.this.okc.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.okc.hasFocus()) {
                            TransmitPostEditActivity.this.okd.requestFocus();
                            TransmitPostEditActivity.this.okd.setSelection(TransmitPostEditActivity.this.okd.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.okc.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.fBu.setActionListener(31, bVar);
        this.fBu.setActionListener(16, bVar);
        this.fBu.setActionListener(14, bVar);
        this.fBu.setActionListener(24, bVar);
        this.fBu.setActionListener(3, bVar);
        this.fBu.setActionListener(10, bVar);
        this.fBu.setActionListener(11, bVar);
        this.fBu.setActionListener(12, bVar);
        this.fBu.setActionListener(13, bVar);
        this.fBu.setActionListener(15, bVar);
        this.fBu.setActionListener(18, bVar);
        this.fBu.setActionListener(20, bVar);
        this.fBu.setActionListener(25, bVar);
        this.fBu.setActionListener(27, bVar);
        this.fBu.setActionListener(29, bVar);
        this.fBu.setActionListener(43, bVar);
        this.fBu.setActionListener(45, bVar);
        this.fBu.setActionListener(53, bVar);
        this.fBu.setActionListener(48, bVar);
        this.fBu.setActionListener(46, bVar);
        this.fBu.setActionListener(49, bVar);
        this.fBu.setActionListener(47, bVar);
        this.fBu.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBU() {
        if (this.fDG.clH()) {
            if (this.fDG.dOx()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.b.dOs().getLocationData().getFormatted_address());
                return;
            }
            b(1, true, null);
            this.fDG.dOv();
            return;
        }
        b(0, true, null);
    }

    protected void dJR() {
        if (this.fDH != null) {
            this.fDH.cancelLoadData();
        }
        if (this.oke != null) {
            this.oke.cancelLoadData();
        }
        if (this.fDG != null) {
            this.fDG.cancelLoadData();
        }
    }

    private void dYj() {
        if (this.okz != null) {
            this.okz.hideTip();
        }
    }

    private void dYk() {
        if (this.okz == null) {
            this.okz = new g(getPageContext());
        }
        this.okz.d(this.fBu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dYj();
        TiebaPrepareImageService.StopService();
        dJR();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYl() {
        if (this.nmk == null) {
            finish();
            return;
        }
        this.nmk.setTitle(dYz().getText().toString());
        this.nmk.setContent(dYy().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.nmI != null && this.nmI.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.nmI, getPageContext().getPageActivity());
                return true;
            } else if (this.fBu.bBl()) {
                this.fBu.bzD();
                return true;
            } else {
                dJR();
                dYl();
                return true;
            }
        }
        if (i == 67 && (text = dYy().getText()) != null) {
            int selectionStart = dYy().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dYy().onKeyDown(67, this.iSz);
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
        getLayoutMode().onModeChanged(this.lxr);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.lUF, R.color.CAM_X0302, 1);
        dYh();
        ap.setBackgroundColor(this.nmD, R.color.CAM_X0204);
        ap.setBackgroundColor(dYz(), R.color.CAM_X0201);
        ap.setBackgroundColor(dYy(), R.color.CAM_X0201);
        dJZ();
        this.fBu.onChangeSkinType(i);
        if (this.okr != null) {
            this.okr.bup();
        }
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        dYm();
        dYn();
        if (this.oky != null) {
            this.oky.c(dYz(), dYy());
        }
        if (this.aiU != null) {
            this.aiU.onChangeSkinType();
        }
        if (this.okA != null) {
            this.okA.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYm() {
        if (this.nmC.hasFocus()) {
            this.nmC.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        } else {
            this.nmC.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        }
        if (this.okd.hasFocus()) {
            this.okd.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        } else {
            this.okd.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYn() {
        if (this.nmC != null) {
            if (this.nmC.getText().toString().length() == 0) {
                this.nmC.getPaint().setFakeBoldText(false);
            } else if (this.nmC.getText().toString().length() > 0) {
                this.nmC.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.fMe = new com.baidu.tbadk.core.view.a(getPageContext());
        this.okt = this.nmk.getType() == 4 || 5 == this.nmk.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bsR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        dYq();
        this.oks = (ScrollView) findViewById(R.id.write_scrollview);
        this.oks.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.okd != null) {
                        l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.okd);
                    }
                    if (TransmitPostEditActivity.this.fBu != null) {
                        TransmitPostEditActivity.this.fBu.bzD();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.lxr = (RelativeLayout) findViewById(R.id.parent);
        this.okb = (LinearLayout) findViewById(R.id.tool_view);
        this.okb.setContentDescription(IStringUtil.TOP_PATH);
        this.okc = (LinearLayout) findViewById(R.id.title_view);
        this.nmD = findViewById(R.id.interval_view);
        this.okv = (TextView) findViewById(R.id.hot_topic_title_edt);
        dJY();
        if (this.okt) {
            this.oks.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        dKa();
        dYw();
        this.nmF = (LinearLayout) findViewById(R.id.post_content_container);
        this.nmF.setDrawingCacheEnabled(false);
        this.nmF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.okd.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.hxs);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.dJR();
                TransmitPostEditActivity.this.dYl();
            }
        });
        dYt();
        dYv();
        dYp();
        dYh();
        dYu();
        dJX();
        dYB();
        dYo();
        if (this.nmk.getType() == 4 && this.nmK != null && this.okf != null) {
            this.nmK.setVisibility(8);
            this.okf.setVisibility(8);
        }
        dJZ();
        ShowSoftKeyPad(this.mInputManager, this.nmC);
    }

    private void dYo() {
        this.okA = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.okA.setBgColor(R.color.CAM_X0205);
        this.okA.setData(this.oeH);
        this.okA.setActivity(this);
    }

    private void dYp() {
        String str;
        String str2;
        if (this.nmk != null) {
            switch (this.nmk.getType()) {
                case 0:
                case 9:
                    if (this.jNd != null && this.jNd.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                    } else if (this.jNd != null && this.jNd.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.nmk.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.nmC.setVisibility(0);
                    this.okd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.okd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.okd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.nmC.setVisibility(8);
                    return;
            }
        }
    }

    private void dYq() {
        this.lUF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lUF.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.lUF.setLayoutParams(layoutParams);
        this.lUF.setOnFocusChangeListener(this.hxs);
    }

    private void dYr() {
        if (this.nmk != null && this.nmk.getType() == 0 && this.nmk.getType() == 9 && !this.oka && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = au.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dYz() != null) {
                dYz().setText(cutStringWithSuffix);
                dYz().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void dYs() {
        this.gNf = null;
        this.oko = -1;
        this.okq = -1;
        ad yX = ac.cEF().yX(1);
        if (yX != null) {
            this.gNf = yX.jkX;
            this.oko = getIntent().getIntExtra("category_id", -1);
            if (this.gNf != null && !this.gNf.isEmpty() && this.oko >= 0) {
                this.okn = new ab();
                this.okn.jkT = 0;
                this.okn.name = getPageContext().getResources().getString(R.string.category_auto);
                this.okq = this.okn.jkT;
                this.okp = this.okn.name;
                for (ab abVar : this.gNf) {
                    if (abVar.jkT == this.oko) {
                        this.okq = abVar.jkT;
                        this.okp = abVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dYt() {
        if (this.gNf != null && !this.gNf.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.okr = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.okr.setText(this.okp);
            this.okr.setCategoryContainerData(this.gNf, this.okn, this.okq);
            this.okr.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bc bcVar) {
                    if (bcVar != null) {
                        TransmitPostEditActivity.this.okr.setText(bcVar.name);
                        TransmitPostEditActivity.this.nmk.setCategoryTo(bcVar.jkT);
                        TransmitPostEditActivity.this.okq = bcVar.jkT;
                        TransmitPostEditActivity.this.okr.dXL();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.okr.dXK();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dYz());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dYy());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.okH = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.okH.setTitle(R.string.no_disturb_start_time);
        this.okH.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.okH);
        this.okH.setButton(-2, getPageContext().getString(R.string.cancel), this.okH);
        return this.okH;
    }

    private void dYu() {
        this.okj = (RelativeLayout) findViewById(R.id.addition_container);
        this.okk = (TextView) findViewById(R.id.addition_create_time);
        this.okl = (TextView) findViewById(R.id.addition_last_time);
        this.okm = (TextView) findViewById(R.id.addition_last_content);
        if (this.oki != null) {
            this.okj.setVisibility(0);
            this.okk.setText(getPageContext().getString(R.string.write_addition_create) + au.getFormatTime(this.oki.getCreateTime() * 1000));
            if (this.oki.getAlreadyCount() == 0) {
                this.okl.setVisibility(8);
            } else {
                this.okl.setText(getPageContext().getString(R.string.write_addition_last) + au.getFormatTime(this.oki.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.oki.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.okm.setText(lastAdditionContent);
            } else {
                this.okm.setVisibility(8);
            }
            dYy().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.oki.getAlreadyCount()), Integer.valueOf(this.oki.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.okj.setVisibility(8);
    }

    private void dJX() {
        this.nmK = findViewById(R.id.post_prefix_layout);
        this.nmH = (TextView) findViewById(R.id.post_prefix);
        this.okf = findViewById(R.id.prefix_divider);
        this.nmJ = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.nmK.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.nml = 1;
            this.nmK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.nmH.setVisibility(0);
                    TransmitPostEditActivity.this.nmK.setSelected(true);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.nmI, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.fBu.bzD();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.nmC);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.okd);
                }
            });
            this.nmJ = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.nmJ.setVisibility(0);
                this.nmH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.nmH.setSelected(true);
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.nmI, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.fBu.bzD();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dYz());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dYy());
                    }
                });
            }
            this.nmI = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.nmI.a(this);
            this.nmI.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.nmI.setOutsideTouchable(true);
            this.nmI.setFocusable(true);
            this.nmI.setOnDismissListener(this);
            this.nmI.setBackgroundDrawable(ap.getDrawable(R.color.CAM_X0201));
            int color = ap.getColor(R.color.CAM_X0105);
            int color2 = ap.getColor(R.color.CAM_X0108);
            ap.setBackgroundResource(this.nmH, R.color.CAM_X0201);
            ap.setImageResource(this.nmJ, R.drawable.icon_frs_arrow_n);
            this.nmH.setTextColor(color);
            this.okg.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.okg.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.nmI.addView(writePrefixItemLayout);
            }
            this.nmI.setCurrentIndex(0);
            this.nmH.setText(prefixs.get(1));
            LA(1);
            return;
        }
        this.nmK.setVisibility(8);
    }

    protected void dYv() {
        this.lUF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick() && !TransmitPostEditActivity.this.dYI()) {
                    if (TransmitPostEditActivity.this.oky.a(TransmitPostEditActivity.this.nmC, TransmitPostEditActivity.this.okd)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.oky.dWz());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dYz());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dYy());
                    TransmitPostEditActivity.this.fBu.bzD();
                    TiebaStatic.log(new ar("c12608").ap("obj_locate", 7));
                    TransmitPostEditActivity.this.dYF();
                }
            }
        });
    }

    protected void dJY() {
        this.nmC = (EditText) findViewById(R.id.post_title);
        this.nmC.setOnClickListener(this.okD);
        this.nmC.setOnFocusChangeListener(this.hxs);
        if ((this.nmk.getType() == 0 || this.nmk.getType() == 9 || this.nmk.getType() == 7) && this.nmk.getTitle() != null) {
            this.nmC.setText(this.nmk.getTitle());
            this.nmC.setSelection(this.nmk.getTitle().length());
        }
        this.nmC.addTextChangedListener(this.okF);
        if (!this.nmk.getHaveDraft()) {
            dYr();
        }
        this.nmC.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void dKa() {
        this.okd = (SpanGroupEditText) findViewById(R.id.post_content);
        this.okd.setDrawingCacheEnabled(false);
        this.okd.setOnClickListener(this.okD);
        if (this.fDH != null) {
            this.fDH.setSpanGroupManager(this.okd.getSpanGroupManager());
        }
        if (this.nmk != null) {
            this.nmk.setSpanGroupManager(this.okd.getSpanGroupManager());
        }
        if (this.nmk.getContent() != null && this.nmk.getContent().length() > 0) {
            this.okd.setText(TbFaceManager.bCO().aD(getPageContext().getPageActivity(), this.nmk.getContent()));
            this.okd.setSelection(this.okd.getText().length());
        }
        if (!au.isEmpty(this.jen)) {
            this.okd.setSelection(0);
        }
        this.okd.setOnFocusChangeListener(this.hxs);
        this.okd.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.fBu.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.okd.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.okd.addTextChangedListener(this.okG);
        if (this.ojZ != null && this.ojZ.showType == 3) {
            this.okd.setHint(R.string.share_video_default);
        } else {
            this.okd.setHint(R.string.share_txt_default);
        }
    }

    private void dYw() {
        this.aiU = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aiU.getLayoutParams();
        layoutParams.topMargin -= ojW;
        layoutParams.leftMargin = fWF;
        layoutParams.rightMargin = fWF;
        this.aiU.setLayoutParams(layoutParams);
        this.aiU.setVisibility(0);
        this.aiU.a(this.ojZ);
        this.aiU.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dYx() {
        int i = 5000;
        if (this.oki != null) {
            i = 1000;
        }
        return dYy().getText() != null && dYy().getText().length() >= i;
    }

    private void CQ(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.ojX)) {
                this.ojX = "";
                dYy().requestFocus();
                if (dYy().getText() != null && dYy().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dYy().getSelectionStart();
                    editable = dYy().getText();
                }
            } else if ("from_title".equals(this.ojX)) {
                this.ojX = "";
                dYz().requestFocus();
                if (dYz().getText() != null && dYz().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dYz().getSelectionStart();
                    editable = dYz().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zH(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.nmk != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.nmk.getForumId(), 0L), this.nmk.getFirstDir(), this.nmk.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(u uVar) {
        if (((ImageSpan[]) dYy().getText().getSpans(0, dYy().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.okh == null) {
                this.okh = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.okh.getView().isShown()) {
                this.okh.cancel();
            }
            this.okh.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, uVar, dYy());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dYy() {
        return this.okd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dYz() {
        return this.nmC;
    }

    protected void dYA() {
        if (dYy().getSelectionStart() > 0) {
            String substring = dYy().getText().toString().substring(0, dYy().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.iSy.matcher(substring);
            if (matcher.find()) {
                dYy().getText().delete(dYy().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dYy().getSelectionStart());
                return;
            }
            dYy().onKeyDown(67, this.iSz);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.fMe.setCancelListener(null);
        this.fMe.setTipString(R.string.sending);
        this.fMe.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.fMe.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJZ() {
        if (this.nmk != null) {
            String str = "";
            String str2 = "";
            if (dYz() != null) {
                str = dYz().getText().toString();
            }
            if (dYy() != null) {
                str2 = dYy().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.nmk.getType() == 0 || this.nmk.getType() == 9 || this.nmk.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.nml == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.nmk.setIsNoTitle(true);
                        } else {
                            this.nmk.setIsNoTitle(false);
                            zI(true);
                            return;
                        }
                    } else {
                        this.nmk.setIsNoTitle(false);
                        zI(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.nmk.setIsNoTitle(true);
                } else {
                    this.nmk.setIsNoTitle(false);
                    zI(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.okt) {
                    zI(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    zI(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                zI(true);
            } else if (this.nmk.getVideoInfo() != null) {
                zI(true);
            } else {
                zI(false);
            }
        }
    }

    private void zI(boolean z) {
        ap.setNavbarTitleColor(this.lUF, R.color.CAM_X0302, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.fDH = new NewWriteModel(this);
        this.fDH.b(this.fDW);
        this.iXn = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.dJR();
            }
        };
        this.nmk = new WriteData();
        if (bundle != null) {
            this.nmk.setType(bundle.getInt("type", 0));
            this.nmk.setForumId(bundle.getString("forum_id"));
            this.nmk.setForumName(bundle.getString("forum_name"));
            this.nmk.setFirstDir(bundle.getString("forum_first_dir"));
            this.nmk.setSecondDir(bundle.getString("forum_second_dir"));
            this.nmk.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.oki = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.nmk.setIsAddition(this.oki != null);
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
            this.nmk.setTitle(bundle.getString("write_title"));
            this.nmk.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.jNd = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.ojZ = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.ShareInfo.class);
            }
            this.mBaijiahaoData = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.jen = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.jeo = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.oeH = (FrsTabInfoData) bundle.getSerializable("tab_list");
            str = string;
        } else {
            Intent intent = getIntent();
            this.nmk.setType(intent.getIntExtra("type", 0));
            this.nmk.setForumId(intent.getStringExtra("forum_id"));
            this.nmk.setForumName(intent.getStringExtra("forum_name"));
            this.nmk.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.nmk.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.nmk.setThreadId(intent.getStringExtra("thread_id"));
            this.oki = (AdditionData) intent.getSerializableExtra("addition_data");
            this.nmk.setIsAddition(this.oki != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.nmk.setTitle(intent.getStringExtra("write_title"));
            this.nmk.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.jNd = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.ojZ = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            this.jen = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.jeo = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.oeH = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.nmk.getType() == 4 ? 6 : 9);
        this.nmk.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.ojZ != null && this.ojZ.videoId != null) {
            this.nmk.setVideoId(this.ojZ.videoId);
            this.nmk.setOriginalVideoCover(this.ojZ.showPicUrl);
            this.nmk.setOriginalVideoTitle(this.ojZ.showText);
        }
        if (!au.isEmpty(this.jen)) {
            if (!au.isEmpty(this.jeo)) {
                this.nmk.setContent("//@" + this.jeo + " :" + this.jen);
            } else {
                this.nmk.setContent(this.jen);
            }
        }
        if (this.nmk != null && this.nmk.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.nmk.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.oka = true;
        }
        dYs();
    }

    private void dYB() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) y.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.nmC.setText(com.baidu.tbadk.plugins.b.Dy(com.baidu.tbadk.plugins.b.Dz(hotTopicBussinessData.mTopicName)));
            this.nmC.setMovementMethod(com.baidu.tieba.view.c.dVY());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString Dy = com.baidu.tbadk.plugins.b.Dy(com.baidu.tbadk.plugins.b.Dz(hotTopicBussinessData.mTopicName));
            if (Dy != null) {
                this.nmC.setText(Dy);
            }
            this.okv.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.nmk.getType());
        bundle.putString("forum_id", this.nmk.getForumId());
        bundle.putString("forum_name", this.nmk.getForumName());
        bundle.putString("forum_first_dir", this.nmk.getFirstDir());
        bundle.putString("forum_second_dir", this.nmk.getSecondDir());
        bundle.putString("thread_id", this.nmk.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jNd);
        bundle.putSerializable("tab_list", this.oeH);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.oki != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.oki));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jNd);
        if (this.ojZ != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.ojZ));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dYy().getEditableText().toString();
        if (obj != null) {
            dYy().setText(TbFaceManager.bCO().a(getPageContext().getPageActivity(), obj, this.okB));
            dYy().setSelection(dYy().getText().length());
        }
    }

    private String dYC() {
        if (dYy() == null || dYy().getText() == null) {
            return "";
        }
        String obj = dYy().getText().toString();
        if (StringUtils.isNull(obj)) {
            if (this.ojZ != null && this.ojZ.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return obj;
    }

    private String dYD() {
        if (this.nmk == null || dYz() == null || dYz().getVisibility() != 0 || dYz().getText() == null) {
            return "";
        }
        String obj = dYz().getText().toString();
        if (this.mPrefixData != null && y.getCount(this.mPrefixData.getPrefixs()) > 0 && this.nml != 0 && this.nmk.getType() != 4 && this.nmH != null && this.nmH.getText() != null) {
            obj = this.nmH.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            obj = this.mPrefixData.getImplicitTitle() + this.nmk.getTitle();
        }
        if (TextUtils.isEmpty(obj)) {
            if (TextUtils.isEmpty(this.nmk.getContent())) {
                return getString(R.string.share_txt_default);
            }
            if (getString(R.string.share_txt_default).equals(this.nmk.getContent())) {
                return getString(R.string.share_txt_default);
            }
            if (getString(R.string.share_video_default).equals(this.nmk.getContent())) {
                return getString(R.string.share_video_default);
            }
            return obj;
        }
        return obj;
    }

    private void cGY() {
        dJR();
        this.nmk.setContent(dYC());
        this.nmk.setTitle(dYD());
        if (this.oko >= 0) {
            this.nmk.setCategoryFrom(this.oko);
        }
        if (this.okq >= 0) {
            this.nmk.setCategoryTo(this.okq);
        }
        this.nmk.setWriteImagesInfo(this.writeImagesInfo);
        this.nmk.setHasLocationData(this.fDG != null && this.fDG.clH());
        this.fDH.yE(this.writeImagesInfo.size() > 0);
        if (!y.isEmpty(this.mList) && this.oku != null && this.oku.mIsGlobalBlock == 0) {
            this.nmk.setForumId(String.valueOf(this.oku.mForumId));
            this.nmk.setForumName(this.oku.mForumName);
        }
        dYE();
        this.fDH.f(this.nmk);
        this.nmk.setContent(this.nmk.getContent().replaceAll("\u0000\n", ""));
        this.nmk.setContent(this.nmk.getContent().replaceAll("\u0000", ""));
        this.nmk.setVcode(null);
        this.fDH.daC().setVoice(null);
        this.fDH.daC().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.iXn);
        this.fDH.dPd();
    }

    private void dYE() {
        FrsTabItemData selectedTabItemData;
        if (this.nmk != null && this.okA != null && (selectedTabItemData = this.okA.getSelectedTabItemData()) != null) {
            this.nmk.setTabId(selectedTabItemData.tabId);
            this.nmk.setTabName(selectedTabItemData.name);
            this.nmk.setIsGeneralTab(selectedTabItemData.isGeneralTab);
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
            if (this.oki != null) {
                i2 = this.oki.getTotalCount();
                i = this.oki.getAlreadyCount() + 1;
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
                if (this.fBu != null && !this.fBu.bBl()) {
                    dYy().requestFocus();
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
                            dYy().getText().insert(dYy().getSelectionStart(), sb.toString());
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
                        if (this.ojY) {
                            sb2.append(com.baidu.tbadk.plugins.b.fLy);
                            this.ojY = false;
                        }
                        sb2.append(stringExtra);
                        CQ(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !y.isEmpty(this.mList) && !y.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.oku = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.oku);
            }
        } else if (i2 == 0) {
            if (this.fBu != null && !this.fBu.bBl()) {
                this.okd.requestFocus();
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
                        this.oky.Vh(postWriteCallBackData.getErrorString());
                        this.oky.bg(postWriteCallBackData.getSensitiveWords());
                        this.oky.b(this.nmC, this.okd);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.ojX)) {
                        dYz().requestFocus();
                        return;
                    } else if ("from_content".equals(this.ojX)) {
                        dYy().requestFocus();
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
    public void dYF() {
        if ("1".equals(this.jNd)) {
            this.nmk.setCanNoForum(true);
            this.nmk.setTransmitForumData("[]");
        } else if ("2".equals(this.jNd)) {
            this.nmk.setCanNoForum(false);
        }
        dYG();
        this.nmk.setPrivacy(this.isPrivacy);
        this.nmk.setIsShareThread(true);
        if (this.ojZ != null && !StringUtils.isNull(this.ojZ.threadId)) {
            this.nmk.setOriginalThreadId(this.ojZ.threadId);
        }
        this.nmk.setBaijiahaoData(this.mBaijiahaoData);
        if (this.ojZ != null) {
            this.nmk.setOriBaijiahaoData(this.ojZ.oriUgcInfo);
        }
        this.nmk.setCallFrom(this.jNd);
        cGY();
    }

    private void dYG() {
        if (this.fBu != null) {
            this.fBu.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dYz());
        HidenSoftKeyPad(this.mInputManager, dYy());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bX(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.jhQ) != null) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ap("obj_locate", ay.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.nmk.getType() != 7) {
                if (this.oki == null) {
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
        this.fDM = i;
        if (this.fBu != null) {
            this.fBu.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void dYH() {
        if (!this.okt && this.fBu != null) {
            this.fBu.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.fBu.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kZ(boolean z) {
        if (this.fBu != null) {
            this.fBu.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void LA(int i) {
        if (i < this.okg.size()) {
            for (int i2 = 0; i2 < this.okg.size(); i2++) {
                this.okg.get(i2).zz(false);
            }
            this.okg.get(i).zz(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void Ji(int i) {
        this.nml = i;
        this.nmI.setCurrentIndex(i);
        LA(i);
        this.nmH.setText(this.mPrefixData.getPrefixs().get(i));
        dJZ();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.nmI, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.nmK.setSelected(false);
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
        if (this.nmk != null) {
            if (this.nmk.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.nmk.getType() == 5) {
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
            bBR();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.brf = z;
        if (this.okx != null && !z) {
            this.okx.cwz();
        }
        if (this.okz != null && !z) {
            dYj();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.brf && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.ojY = false;
            this.ojX = "";
            if ("from_content".equals(str)) {
                this.ojX = "from_content";
            } else if ("from_title".equals(str)) {
                this.ojX = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.Dx(String.valueOf(charSequence.charAt(i)))) {
                zH(false);
            }
        }
    }

    public void dEc() {
        if (!y.isEmpty(this.mList)) {
            this.okc.setVisibility(0);
            this.okc.requestFocus();
            return;
        }
        this.okc.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dYI() {
        if (((ImageSpan[]) dYy().getText().getSpans(0, dYy().getText().length(), ImageSpan.class)).length > 10) {
            if (this.okh == null) {
                this.okh = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.okh.getView().isShown()) {
                this.okh.cancel();
            }
            this.okh.show();
            return true;
        }
        return false;
    }
}
