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
import com.baidu.h.a.a;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
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
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.bd;
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
/* loaded from: classes2.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0127a, i.a {
    private OriginalThreadCardView agv;
    private EditorTools etN;
    private LocationModel evw;
    private NewWriteModel evx;
    List<ad> fyR;
    private String hxC;
    private String hxD;
    private boolean isPrivacy;
    private TextView lvG;
    private com.baidu.tieba.write.i lvH;
    private ImageView lvI;
    private View lvJ;
    private int lvj;
    private BaijiahaoData mBaijiahaoData;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private FrsTabInfoData mne;
    private ForumTabSelectedView mrB;
    ad mtA;
    private int mtB;
    private String mtC;
    private int mtD;
    private PostCategoryView mtE;
    private HotTopicBussinessData mtH;
    private TextView mtI;
    private com.baidu.tieba.write.editor.b mtK;
    private e mtM;
    private com.baidu.tieba.view.b mtT;
    private OriginalThreadInfo.ShareInfo mtm;
    private LinearLayout mto;
    private LinearLayout mtp;
    private View mts;
    private Toast mtu;
    private AdditionData mtv;
    private RelativeLayout mtw;
    private TextView mtx;
    private TextView mty;
    private TextView mtz;
    private static final int ifJ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    private static final int eNF = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44);
    private String mtk = "";
    private boolean mtl = false;
    private WriteData lvi = null;
    private boolean mtn = false;
    private InputMethodManager mInputManager = null;
    private EditText lvA = null;
    private View lvB = null;
    private LinearLayout lvD = null;
    private SpanGroupEditText mtq = null;
    private FeedBackModel mtr = null;
    private ArrayList<WritePrefixItemLayout> mtt = new ArrayList<>();
    private final KeyEvent hlO = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView lvF = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener hqD = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout iKg = null;
    private String evB = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int evC = 0;
    private View mRootView = null;
    private ScrollView mtF = null;
    private boolean mtG = false;
    private com.baidu.tbadk.core.view.a eDA = null;
    private String mFrom = "write";
    private String ici = "2";
    private SpannableStringBuilder mtJ = new SpannableStringBuilder();
    private boolean aXk = false;
    private final b mtL = new b();
    private boolean mrf = false;
    private TbFaceManager.a mtN = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan yM(String str) {
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
    private final AntiHelper.a hAZ = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", av.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", av.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d evL = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ad adVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.lvi != null) {
                TransmitPostEditActivity.this.mtL.aY(null);
                if (z) {
                    TransmitPostEditActivity.this.in(z);
                    TransmitPostEditActivity.this.c(true, postWriteCallBackData);
                    TransmitPostEditActivity.this.k(postWriteCallBackData);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    TransmitPostEditActivity.this.setResult(-1, intent);
                    TransmitPostEditActivity.this.finish();
                } else if (postWriteCallBackData.isSensitiveError()) {
                    TransmitPostEditActivity.this.showToast(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.mtL.ON(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.mtL.aY(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.mtL.b(TransmitPostEditActivity.this.lvA, TransmitPostEditActivity.this.mtq);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (ar.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.c(TransmitPostEditActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(TransmitPostEditActivity.this.getActivity());
                    if (ar.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.we(TransmitPostEditActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.we(postWriteCallBackData.getErrorString());
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
                            TiebaStatic.log(new ao("c13746").ag("obj_locate", 1).ag("obj_type", 1));
                        }
                    });
                    aVar.b(TransmitPostEditActivity.this.getPageContext()).aUN();
                    TiebaStatic.log(new ao("c13745").ag("obj_locate", 1).ag("obj_type", 1));
                } else if ((adVar == null || writeData == null || adVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (adVar != null && writeData != null && adVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(adVar.getVcode_md5());
                    writeData.setVcodeUrl(adVar.getVcode_pic_url());
                    writeData.setVcodeExtra(adVar.bas());
                    if (com.baidu.tbadk.t.a.zq(adVar.bar())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, adVar.bar())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a evJ = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bfT() {
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
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.diC())) {
                TransmitPostEditActivity.this.a(2, true, aVar.diC());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener lIo = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.evw.uL(false);
                    TransmitPostEditActivity.this.evw.fB(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.evw.uL(true);
                TransmitPostEditActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener mtO = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener mtP = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.etN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dsL = TransmitPostEditActivity.this.dsL();
            if (dsL >= 0 && dsL < TransmitPostEditActivity.this.mtq.getText().length()) {
                TransmitPostEditActivity.this.mtq.setSelection(dsL);
            }
        }
    };
    private boolean mtQ = true;
    private final View.OnFocusChangeListener gbk = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.lvA || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.lvF) {
                if (z) {
                    TransmitPostEditActivity.this.mtQ = true;
                    TransmitPostEditActivity.this.dsM();
                    if (TransmitPostEditActivity.this.etN != null) {
                        TransmitPostEditActivity.this.etN.bdC();
                    }
                    l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.lvA);
                } else if (view == TransmitPostEditActivity.this.lvA) {
                    TransmitPostEditActivity.this.lvG.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.mtq && z) {
                TransmitPostEditActivity.this.mtQ = false;
                TransmitPostEditActivity.this.dsM();
                TransmitPostEditActivity.this.etN.bdC();
                l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.mtq);
            }
            TransmitPostEditActivity.this.dsR();
        }
    };
    private TextWatcher mtR = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String mtV = "";
        private String mtW;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mtW = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.mtW != null ? this.mtW.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.deD();
            TransmitPostEditActivity.this.dsS();
            EditText dte = TransmitPostEditActivity.this.dte();
            if (editable != null && dte != null && dte.getText() != null) {
                if (this.mtV == null || !this.mtV.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.mtL != null) {
                        this.mtV = dte.getText().toString();
                        TransmitPostEditActivity.this.mtL.b(dte, true);
                        return;
                    }
                    return;
                }
                dte.setSelection(dte.getSelectionEnd());
            }
        }
    };
    private TextWatcher mtS = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String mtW;
        private String mtX = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mtW = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.mtW != null ? this.mtW.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.deD();
            EditText dtd = TransmitPostEditActivity.this.dtd();
            if (editable != null && dtd != null && dtd.getText() != null) {
                int selectionEnd = dtd.getSelectionEnd();
                if (this.mtX == null || !this.mtX.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.mtL != null) {
                        this.mtX = dtd.getText().toString();
                        TransmitPostEditActivity.this.mtL.b(dtd, false);
                        return;
                    }
                    return;
                }
                dtd.setSelection(selectionEnd);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ar.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfC() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void bfE() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bfG();
        } else if (this.evw.diJ()) {
            bfC();
        } else {
            this.evw.uL(false);
            a(1, true, (String) null);
            this.evw.diH();
        }
    }

    private void bfG() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.kT(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.a(1, true, (String) null);
                    TransmitPostEditActivity.this.evw.diL();
                } else {
                    TransmitPostEditActivity.this.evJ.bfT();
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
        aVar.aUN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dsL() {
        int selectionEnd = dtd().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dtd().getText().getSpans(0, dtd().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dtd().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dtd().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsM() {
        if (this.etN != null) {
            this.etN.setBarLauncherEnabled(!this.mtQ);
            this.etN.setToolEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mtG) {
            this.lvA.setVisibility(8);
            deD();
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
        this.evw = new LocationModel(getPageContext());
        this.evw.a(this.evJ);
        registerListener(this.lIo);
        registerListener(this.mtO);
        cBw();
        this.mtq.requestFocus();
        cZD();
        dtl();
    }

    @SuppressLint({"ResourceAsColor"})
    private void cBw() {
        this.etN = new EditorTools(getActivity());
        this.etN.setBarMaxLauCount(4);
        this.etN.setMoreButtonAtEnd(true);
        this.etN.setBarLauncherType(1);
        this.etN.m32if(true);
        this.etN.ig(true);
        this.etN.setBackgroundColorId(R.color.cp_bg_line_h);
        dsN();
        this.etN.build();
        if (this.mrf) {
            this.etN.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        }
        if (this.mto != null) {
            this.mto.addView(this.etN);
        }
        cvi();
        this.etN.display();
        com.baidu.tbadk.editortools.g ny = this.etN.ny(6);
        if (ny != null && !TextUtils.isEmpty(this.evB)) {
            ((View) ny).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.evB);
                }
            });
        }
        if (!this.mtG) {
            this.etN.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.etN.bdC();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.etN.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.etN.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.lvi.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.lvi.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        if (!this.mrf) {
            dsP();
        }
    }

    private void dsN() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.etN.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        if (!this.mrf && this.mtv == null) {
            if (this.mtK == null) {
                this.mtK = new com.baidu.tieba.write.editor.b(getActivity(), this.ici);
                this.mtK.drB();
                this.mtK.setFrom("from_share_write");
                this.mtK.bJ(this.lvi.getForumId(), this.mPrivateThread);
            }
            this.etN.b(this.mtK);
        }
        this.etN.aW(arrayList);
        com.baidu.tbadk.editortools.l nB = this.etN.nB(5);
        if (nB != null) {
            nB.euy = 1;
            if (this.mrf) {
                nB.ii(false);
            }
        }
    }

    private void cvi() {
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
                            TiebaStatic.log(new ao("c12608").ag("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.dtc()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.dtc()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof q)) {
                            TransmitPostEditActivity.this.e((q) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.dtf();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.deD();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.mtv == null) {
                            TransmitPostEditActivity.this.bfH();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.evC) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ac.checkLocationForGoogle(pageActivity)) {
                                    TransmitPostEditActivity.this.bfE();
                                    return;
                                } else {
                                    ac.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.bfC();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.evw != null) {
                            TransmitPostEditActivity.this.evw.uL(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        ao aoVar = new ao("c10645");
                        if (TransmitPostEditActivity.this.lvi != null) {
                            str = TransmitPostEditActivity.this.lvi.getForumId();
                        } else {
                            str = "";
                        }
                        aoVar.dk("fid", str);
                        TiebaStatic.log(aoVar);
                        if (TransmitPostEditActivity.this.lvi == null || (videoInfo = TransmitPostEditActivity.this.lvi.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.etN.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.etN.bfc()) {
                                        TransmitPostEditActivity.this.etN.bdC();
                                        TransmitPostEditActivity.this.etN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.etN.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.etN.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.etN.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.etN.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.lvi.setVideoInfo(null);
                        TransmitPostEditActivity.this.deD();
                        if (TransmitPostEditActivity.this.mtq != null) {
                            TransmitPostEditActivity.this.mtq.requestFocus();
                        }
                        TransmitPostEditActivity.this.etN.bdC();
                        TransmitPostEditActivity.this.etN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.mtq);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.etN.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.mtl = true;
                        TransmitPostEditActivity.this.vU(true);
                        if (TransmitPostEditActivity.this.dte().isFocused()) {
                            TransmitPostEditActivity.this.mtk = "from_title";
                        } else if (TransmitPostEditActivity.this.dtd().isFocused()) {
                            TransmitPostEditActivity.this.mtk = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.mtp.setVisibility(0);
                        TransmitPostEditActivity.this.mtp.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.mtp.hasFocus()) {
                            TransmitPostEditActivity.this.mtq.requestFocus();
                            TransmitPostEditActivity.this.mtq.setSelection(TransmitPostEditActivity.this.mtq.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.mtp.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.etN.setActionListener(31, bVar);
        this.etN.setActionListener(16, bVar);
        this.etN.setActionListener(14, bVar);
        this.etN.setActionListener(24, bVar);
        this.etN.setActionListener(3, bVar);
        this.etN.setActionListener(10, bVar);
        this.etN.setActionListener(11, bVar);
        this.etN.setActionListener(12, bVar);
        this.etN.setActionListener(13, bVar);
        this.etN.setActionListener(15, bVar);
        this.etN.setActionListener(18, bVar);
        this.etN.setActionListener(20, bVar);
        this.etN.setActionListener(25, bVar);
        this.etN.setActionListener(27, bVar);
        this.etN.setActionListener(29, bVar);
        this.etN.setActionListener(43, bVar);
        this.etN.setActionListener(45, bVar);
        this.etN.setActionListener(53, bVar);
        this.etN.setActionListener(48, bVar);
        this.etN.setActionListener(46, bVar);
        this.etN.setActionListener(49, bVar);
        this.etN.setActionListener(47, bVar);
        this.etN.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfH() {
        if (this.evw.bKt()) {
            if (this.evw.diJ()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.diE().getLocationData().diC());
                return;
            }
            a(1, true, (String) null);
            this.evw.diH();
            return;
        }
        a(0, true, (String) null);
    }

    protected void deu() {
        if (this.evx != null) {
            this.evx.cancelLoadData();
        }
        if (this.mtr != null) {
            this.mtr.cancelLoadData();
        }
        if (this.evw != null) {
            this.evw.cancelLoadData();
        }
    }

    private void dsO() {
        if (this.mtM != null) {
            this.mtM.hideTip();
        }
    }

    private void dsP() {
        if (this.mtM == null) {
            this.mtM = new e(getPageContext());
        }
        this.mtM.c(this.etN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dsO();
        TiebaPrepareImageService.StopService();
        deu();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsQ() {
        if (this.lvi == null) {
            finish();
            return;
        }
        this.lvi.setTitle(dte().getText().toString());
        this.lvi.setContent(dtd().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.lvH != null && this.lvH.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.lvH, getPageContext().getPageActivity());
                return true;
            } else if (this.etN.bfc()) {
                this.etN.bdC();
                return true;
            } else {
                deu();
                dsQ();
                return true;
            }
        }
        if (i == 67 && (text = dtd().getText()) != null) {
            int selectionStart = dtd().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dtd().onKeyDown(67, this.hlO);
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
        getLayoutMode().onModeChanged(this.iKg);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        an.setViewTextColor(this.lvF, R.color.cp_link_tip_a, 1);
        dsM();
        an.setBackgroundColor(this.lvB, R.color.cp_bg_line_c);
        an.setBackgroundColor(dte(), R.color.cp_bg_line_d);
        an.setBackgroundColor(dtd(), R.color.cp_bg_line_d);
        deD();
        this.etN.onChangeSkinType(i);
        if (this.mtE != null) {
            this.mtE.aYj();
        }
        an.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        dsR();
        dsS();
        if (this.mtL != null) {
            this.mtL.c(dte(), dtd());
        }
        if (this.agv != null) {
            this.agv.onChangeSkinType();
        }
        if (this.mrB != null) {
            this.mrB.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsR() {
        if (this.lvA.hasFocus()) {
            this.lvA.setHintTextColor(an.getColor(R.color.cp_cont_e));
        } else {
            this.lvA.setHintTextColor(an.getColor(R.color.cp_cont_d));
        }
        if (this.mtq.hasFocus()) {
            this.mtq.setHintTextColor(an.getColor(R.color.cp_cont_e));
        } else {
            this.mtq.setHintTextColor(an.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsS() {
        if (this.lvA != null) {
            if (this.lvA.getText().toString().length() == 0) {
                this.lvA.getPaint().setFakeBoldText(false);
            } else if (this.lvA.getText().toString().length() > 0) {
                this.lvA.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.eDA = new com.baidu.tbadk.core.view.a(getPageContext());
        this.mtG = this.lvi.getType() == 4 || 5 == this.lvi.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aWQ().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        an.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        dsV();
        this.mtF = (ScrollView) findViewById(R.id.write_scrollview);
        this.mtF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.mtq != null) {
                        l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.mtq);
                    }
                    if (TransmitPostEditActivity.this.etN != null) {
                        TransmitPostEditActivity.this.etN.bdC();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.iKg = (RelativeLayout) findViewById(R.id.parent);
        this.mto = (LinearLayout) findViewById(R.id.tool_view);
        this.mto.setContentDescription(IStringUtil.TOP_PATH);
        this.mtp = (LinearLayout) findViewById(R.id.title_view);
        this.lvB = findViewById(R.id.interval_view);
        this.mtI = (TextView) findViewById(R.id.hot_topic_title_edt);
        deC();
        if (this.mtG) {
            this.mtF.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        deE();
        dtb();
        this.lvD = (LinearLayout) findViewById(R.id.post_content_container);
        this.lvD.setDrawingCacheEnabled(false);
        this.lvD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.etN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.mtq.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.gbk);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.deu();
                TransmitPostEditActivity.this.dsQ();
            }
        });
        dsY();
        dta();
        dsU();
        dsM();
        dsZ();
        deB();
        dtg();
        dsT();
        if (this.lvi.getType() == 4 && this.lvJ != null && this.mts != null) {
            this.lvJ.setVisibility(8);
            this.mts.setVisibility(8);
        }
        deD();
        ShowSoftKeyPad(this.mInputManager, this.lvA);
    }

    private void dsT() {
        this.mrB = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.mrB.setData(this.mne);
        this.mrB.setActivity(this);
    }

    private void dsU() {
        String str;
        String str2;
        if (this.lvi != null) {
            switch (this.lvi.getType()) {
                case 0:
                case 9:
                    if (this.ici != null && this.ici.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                        if (this.mrf) {
                            this.mName.setText(R.string.transmit_to_dynamic_title);
                        }
                    } else if (this.ici != null && this.ici.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.lvi.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.lvA.setVisibility(0);
                    this.mtq.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.mtq.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.mtq.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.lvA.setVisibility(8);
                    return;
            }
        }
    }

    private void dsV() {
        if (this.mrf) {
            this.lvF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.dynamic_publish));
        } else {
            this.lvF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lvF.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.lvF.setLayoutParams(layoutParams);
        this.lvF.setOnFocusChangeListener(this.gbk);
    }

    private void dsW() {
        if (this.lvi != null && this.lvi.getType() == 0 && this.lvi.getType() == 9 && !this.mtn && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = ar.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dte() != null) {
                dte().setText(cutStringWithSuffix);
                dte().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void dsX() {
        this.fyR = null;
        this.mtB = -1;
        this.mtD = -1;
        af uK = ae.bZY().uK(1);
        if (uK != null) {
            this.fyR = uK.hDV;
            this.mtB = getIntent().getIntExtra("category_id", -1);
            if (this.fyR != null && !this.fyR.isEmpty() && this.mtB >= 0) {
                this.mtA = new ad();
                this.mtA.hDR = 0;
                this.mtA.name = getPageContext().getResources().getString(R.string.category_auto);
                this.mtD = this.mtA.hDR;
                this.mtC = this.mtA.name;
                for (ad adVar : this.fyR) {
                    if (adVar.hDR == this.mtB) {
                        this.mtD = adVar.hDR;
                        this.mtC = adVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dsY() {
        if (this.fyR != null && !this.fyR.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.mtE = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.mtE.setText(this.mtC);
            this.mtE.setCategoryContainerData(this.fyR, this.mtA, this.mtD);
            this.mtE.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bd bdVar) {
                    if (bdVar != null) {
                        TransmitPostEditActivity.this.mtE.setText(bdVar.name);
                        TransmitPostEditActivity.this.lvi.setCategoryTo(bdVar.hDR);
                        TransmitPostEditActivity.this.mtD = bdVar.hDR;
                        TransmitPostEditActivity.this.mtE.dsx();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.mtE.dsw();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dte());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dtd());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.mtT = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.mtT.setTitle(R.string.no_disturb_start_time);
        this.mtT.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.mtT);
        this.mtT.setButton(-2, getPageContext().getString(R.string.cancel), this.mtT);
        return this.mtT;
    }

    private void dsZ() {
        this.mtw = (RelativeLayout) findViewById(R.id.addition_container);
        this.mtx = (TextView) findViewById(R.id.addition_create_time);
        this.mty = (TextView) findViewById(R.id.addition_last_time);
        this.mtz = (TextView) findViewById(R.id.addition_last_content);
        if (this.mtv != null) {
            this.mtw.setVisibility(0);
            this.mtx.setText(getPageContext().getString(R.string.write_addition_create) + ar.getFormatTime(this.mtv.getCreateTime() * 1000));
            if (this.mtv.getAlreadyCount() == 0) {
                this.mty.setVisibility(8);
            } else {
                this.mty.setText(getPageContext().getString(R.string.write_addition_last) + ar.getFormatTime(this.mtv.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.mtv.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.mtz.setText(lastAdditionContent);
            } else {
                this.mtz.setVisibility(8);
            }
            dtd().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.mtv.getAlreadyCount()), Integer.valueOf(this.mtv.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.mtw.setVisibility(8);
    }

    private void deB() {
        this.lvJ = findViewById(R.id.post_prefix_layout);
        this.lvG = (TextView) findViewById(R.id.post_prefix);
        this.mts = findViewById(R.id.prefix_divider);
        this.lvI = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.lvJ.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.lvj = 1;
            this.lvJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.lvG.setVisibility(0);
                    TransmitPostEditActivity.this.lvJ.setSelected(true);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.lvH, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.etN.bdC();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.lvA);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.mtq);
                }
            });
            this.lvI = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.lvI.setVisibility(0);
                this.lvG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.lvG.setSelected(true);
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.lvH, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.etN.bdC();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dte());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dtd());
                    }
                });
            }
            this.lvH = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.lvH.a(this);
            this.lvH.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.lvH.setOutsideTouchable(true);
            this.lvH.setFocusable(true);
            this.lvH.setOnDismissListener(this);
            this.lvH.setBackgroundDrawable(an.getDrawable(R.color.cp_bg_line_d));
            int color = an.getColor(R.color.cp_cont_b);
            int color2 = an.getColor(R.color.cp_cont_c);
            an.setBackgroundResource(this.lvG, R.color.cp_bg_line_d);
            an.setImageResource(this.lvI, R.drawable.icon_frs_arrow_n);
            this.lvG.setTextColor(color);
            this.mtt.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.mtt.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.lvH.addView(writePrefixItemLayout);
            }
            this.lvH.setCurrentIndex(0);
            this.lvG.setText(prefixs.get(1));
            GU(1);
            return;
        }
        this.lvJ.setVisibility(8);
    }

    protected void dta() {
        this.lvF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick() && !TransmitPostEditActivity.this.dtm()) {
                    if (TransmitPostEditActivity.this.mtL.a(TransmitPostEditActivity.this.lvA, TransmitPostEditActivity.this.mtq)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.mtL.dqQ());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dte());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dtd());
                    TransmitPostEditActivity.this.etN.bdC();
                    TiebaStatic.log(new ao("c12608").ag("obj_locate", 7));
                    TransmitPostEditActivity.this.dtj();
                }
            }
        });
    }

    protected void deC() {
        this.lvA = (EditText) findViewById(R.id.post_title);
        this.lvA.setOnClickListener(this.mtP);
        this.lvA.setOnFocusChangeListener(this.gbk);
        if ((this.lvi.getType() == 0 || this.lvi.getType() == 9 || this.lvi.getType() == 7) && this.lvi.getTitle() != null) {
            this.lvA.setText(this.lvi.getTitle());
            this.lvA.setSelection(this.lvi.getTitle().length());
        }
        this.lvA.addTextChangedListener(this.mtR);
        if (!this.lvi.getHaveDraft()) {
            dsW();
        }
        this.lvA.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void deE() {
        this.mtq = (SpanGroupEditText) findViewById(R.id.post_content);
        this.mtq.setDrawingCacheEnabled(false);
        this.mtq.setOnClickListener(this.mtP);
        this.mtq.setTransLink(!this.mrf);
        if (this.evx != null) {
            this.evx.setSpanGroupManager(this.mtq.getSpanGroupManager());
        }
        if (this.lvi != null) {
            this.lvi.setSpanGroupManager(this.mtq.getSpanGroupManager());
        }
        if (this.lvi.getContent() != null && this.lvi.getContent().length() > 0) {
            this.mtq.setText(TbFaceManager.bgy().ak(getPageContext().getPageActivity(), this.lvi.getContent()));
            this.mtq.setSelection(this.mtq.getText().length());
        }
        if (!ar.isEmpty(this.hxC)) {
            this.mtq.setSelection(0);
        }
        this.mtq.setOnFocusChangeListener(this.gbk);
        this.mtq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.etN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.mtq.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.mtq.addTextChangedListener(this.mtS);
        if (this.mrf) {
            this.mtq.setHint(R.string.dynamic_transmit_publish_edit_str);
        } else if (this.mtm != null && this.mtm.showType == 3) {
            this.mtq.setHint(R.string.share_video_default);
        } else {
            this.mtq.setHint(R.string.share_txt_default);
        }
    }

    private void dtb() {
        this.agv = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agv.getLayoutParams();
        layoutParams.topMargin -= ifJ;
        layoutParams.leftMargin = eNF;
        layoutParams.rightMargin = eNF;
        this.agv.setLayoutParams(layoutParams);
        this.agv.setVisibility(0);
        this.agv.a(this.mtm);
        this.agv.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dtc() {
        int i = 5000;
        if (this.mtv != null) {
            i = 1000;
        }
        return dtd().getText() != null && dtd().getText().length() >= i;
    }

    private void yx(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.mtk)) {
                this.mtk = "";
                dtd().requestFocus();
                if (dtd().getText() != null && dtd().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dtd().getSelectionStart();
                    editable = dtd().getText();
                }
            } else if ("from_title".equals(this.mtk)) {
                this.mtk = "";
                dte().requestFocus();
                if (dte().getText() != null && dte().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dte().getSelectionStart();
                    editable = dte().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vU(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.lvi != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.lvi.getForumId(), 0L), this.lvi.getFirstDir(), this.lvi.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(q qVar) {
        if (((ImageSpan[]) dtd().getText().getSpans(0, dtd().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.mtu == null) {
                this.mtu = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.mtu.getView().isShown()) {
                this.mtu.cancel();
            }
            this.mtu.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, qVar, dtd());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dtd() {
        return this.mtq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dte() {
        return this.lvA;
    }

    protected void dtf() {
        if (dtd().getSelectionStart() > 0) {
            String substring = dtd().getText().toString().substring(0, dtd().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.hlN.matcher(substring);
            if (matcher.find()) {
                dtd().getText().delete(dtd().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dtd().getSelectionStart());
                return;
            }
            dtd().onKeyDown(67, this.hlO);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.eDA.setCancelListener(null);
        this.eDA.setTipString(R.string.sending);
        this.eDA.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.eDA.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deD() {
        if (this.lvi != null) {
            String str = "";
            String str2 = "";
            if (dte() != null) {
                str = dte().getText().toString();
            }
            if (dtd() != null) {
                str2 = dtd().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.lvi.getType() == 0 || this.lvi.getType() == 9 || this.lvi.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.lvj == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.lvi.setIsNoTitle(true);
                        } else {
                            this.lvi.setIsNoTitle(false);
                            vV(true);
                            return;
                        }
                    } else {
                        this.lvi.setIsNoTitle(false);
                        vV(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.lvi.setIsNoTitle(true);
                } else {
                    this.lvi.setIsNoTitle(false);
                    vV(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.mtG) {
                    vV(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    vV(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                vV(true);
            } else if (this.lvi.getVideoInfo() != null) {
                vV(true);
            } else {
                vV(false);
            }
        }
    }

    private void vV(boolean z) {
        an.setNavbarTitleColor(this.lvF, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.evx = new NewWriteModel(this);
        this.evx.b(this.evL);
        this.hqD = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.deu();
            }
        };
        this.lvi = new WriteData();
        if (bundle != null) {
            this.lvi.setType(bundle.getInt("type", 0));
            this.lvi.setForumId(bundle.getString("forum_id"));
            this.lvi.setForumName(bundle.getString("forum_name"));
            this.lvi.setFirstDir(bundle.getString("forum_first_dir"));
            this.lvi.setSecondDir(bundle.getString("forum_second_dir"));
            this.lvi.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.mtv = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.lvi.setIsAddition(this.mtv != null);
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
            this.lvi.setTitle(bundle.getString("write_title"));
            this.lvi.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.ici = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.mtm = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.ShareInfo.class);
            }
            this.mBaijiahaoData = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.hxC = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.hxD = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.mne = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.lvi.mDynamicForwardData = (ForwardUploadData) bundle.getSerializable(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA);
            str = string;
        } else {
            Intent intent = getIntent();
            this.lvi.setType(intent.getIntExtra("type", 0));
            this.lvi.setForumId(intent.getStringExtra("forum_id"));
            this.lvi.setForumName(intent.getStringExtra("forum_name"));
            this.lvi.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.lvi.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.lvi.setThreadId(intent.getStringExtra("thread_id"));
            this.mtv = (AdditionData) intent.getSerializableExtra("addition_data");
            this.lvi.setIsAddition(this.mtv != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.lvi.setTitle(intent.getStringExtra("write_title"));
            this.lvi.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.ici = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.mtm = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            this.lvi.mDynamicForwardData = (ForwardUploadData) intent.getSerializableExtra(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA);
            this.hxC = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.hxD = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.mne = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (this.lvi.mDynamicForwardData != null) {
            this.mrf = true;
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.lvi.getType() == 4 ? 6 : 9);
        this.lvi.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.mtm != null && this.mtm.videoId != null) {
            this.lvi.setVideoId(this.mtm.videoId);
            this.lvi.setOriginalVideoCover(this.mtm.showPicUrl);
            this.lvi.setOriginalVideoTitle(this.mtm.showText);
        }
        if (!ar.isEmpty(this.hxC)) {
            if (!ar.isEmpty(this.hxD)) {
                this.lvi.setContent("//@" + this.hxD + " :" + this.hxC);
            } else {
                this.lvi.setContent(this.hxC);
            }
        }
        if (this.lvi != null && this.lvi.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.lvi.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.mtn = true;
        }
        dsX();
    }

    private void dtg() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) w.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.lvA.setText(com.baidu.tbadk.plugins.b.zb(com.baidu.tbadk.plugins.b.zc(hotTopicBussinessData.mTopicName)));
            this.lvA.setMovementMethod(com.baidu.tieba.view.c.dqu());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString zb = com.baidu.tbadk.plugins.b.zb(com.baidu.tbadk.plugins.b.zc(hotTopicBussinessData.mTopicName));
            if (zb != null) {
                this.lvA.setText(zb);
            }
            this.mtI.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.lvi.getType());
        bundle.putString("forum_id", this.lvi.getForumId());
        bundle.putString("forum_name", this.lvi.getForumName());
        bundle.putString("forum_first_dir", this.lvi.getFirstDir());
        bundle.putString("forum_second_dir", this.lvi.getSecondDir());
        bundle.putString("thread_id", this.lvi.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.ici);
        bundle.putSerializable("tab_list", this.mne);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.mtv != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.mtv));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.ici);
        if (this.lvi.mDynamicForwardData != null) {
            bundle.putSerializable(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA, this.lvi.mDynamicForwardData);
        }
        if (this.mtm != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mtm));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dtd().getEditableText().toString();
        if (obj != null) {
            dtd().setText(TbFaceManager.bgy().a(getPageContext().getPageActivity(), obj, this.mtN));
            dtd().setSelection(dtd().getText().length());
        }
    }

    private String dth() {
        if (dtd() == null || dtd().getText() == null) {
            return "";
        }
        String obj = dtd().getText().toString();
        if (StringUtils.isNull(obj)) {
            if (this.mtm != null && this.mtm.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return obj;
    }

    private String dti() {
        if (this.lvi == null || dte() == null || dte().getVisibility() != 0 || dte().getText() == null) {
            return "";
        }
        String obj = dte().getText().toString();
        if (this.mPrefixData != null && w.getCount(this.mPrefixData.getPrefixs()) > 0 && this.lvj != 0 && this.lvi.getType() != 4 && this.lvG != null && this.lvG.getText() != null) {
            obj = this.lvG.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            obj = this.mPrefixData.getImplicitTitle() + this.lvi.getTitle();
        }
        if (TextUtils.isEmpty(obj)) {
            return getString(R.string.share_txt_default);
        }
        return obj;
    }

    private void ccc() {
        if (this.lvi != null && this.lvi.mDynamicForwardData != null) {
            dse();
            return;
        }
        deu();
        this.lvi.setContent(dth());
        this.lvi.setTitle(dti());
        if (this.mtB >= 0) {
            this.lvi.setCategoryFrom(this.mtB);
        }
        if (this.mtD >= 0) {
            this.lvi.setCategoryTo(this.mtD);
        }
        this.lvi.setWriteImagesInfo(this.writeImagesInfo);
        this.lvi.setHasLocationData(this.evw != null && this.evw.bKt());
        this.evx.uN(this.writeImagesInfo.size() > 0);
        if (!w.isEmpty(this.mList) && this.mtH != null && this.mtH.mIsGlobalBlock == 0) {
            this.lvi.setForumId(String.valueOf(this.mtH.mForumId));
            this.lvi.setForumName(this.mtH.mForumName);
        }
        dsf();
        this.evx.d(this.lvi);
        this.lvi.setContent(this.lvi.getContent().replaceAll("\u0000\n", ""));
        this.lvi.setContent(this.lvi.getContent().replaceAll("\u0000", ""));
        this.lvi.setVcode(null);
        this.evx.dew().setVoice(null);
        this.evx.dew().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.hqD);
        this.evx.djo();
    }

    private void dsf() {
        FrsTabItemData selectedTabItemData;
        if (this.lvi != null && this.mrB != null && (selectedTabItemData = this.mrB.getSelectedTabItemData()) != null) {
            this.lvi.setTabId(selectedTabItemData.tabId);
            this.lvi.setTabName(selectedTabItemData.name);
            this.lvi.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    private void dse() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        this.lvi.mDynamicForwardData.forward_content = dth();
        this.lvi.mDynamicForwardData.inputText = dth();
        this.lvi.mDynamicForwardData.locationPoiId = "0";
        showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
        com.baidu.tieba.write.b.c.b.drQ().a(this.lvi.mDynamicForwardData, new b.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // com.baidu.tieba.write.b.c.b.a
            public void onSuccess(String str) {
                TransmitPostEditActivity.this.closeLoadingDialog();
                com.baidu.tieba.tbadkCore.writeModel.c.f(TransmitPostEditActivity.this.getPageContext().getPageActivity(), null, null, null);
                TransmitPostEditActivity.this.in(true);
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
                l.showToast(TbadkCoreApplication.getInst(), str);
            }
        });
    }

    private void E(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.mtv != null) {
                i2 = this.mtv.getTotalCount();
                i = this.mtv.getAlreadyCount() + 1;
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
                if (this.etN != null && !this.etN.bfc()) {
                    dtd().requestFocus();
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
                            dtd().getText().insert(dtd().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                k((intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data"));
                setResult(-1, intent);
                finish();
            } else if (i == 25004) {
                if (intent != null) {
                    String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                    if (!StringUtils.isNull(stringExtra)) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.mtl) {
                            sb2.append(com.baidu.tbadk.plugins.b.eCT);
                            this.mtl = false;
                        }
                        sb2.append(stringExtra);
                        yx(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !w.isEmpty(this.mList) && !w.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.mtH = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.mtH);
            }
        } else if (i2 == 0) {
            if (this.etN != null && !this.etN.bfc()) {
                this.mtq.requestFocus();
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
                        this.mtL.ON(postWriteCallBackData.getErrorString());
                        this.mtL.aY(postWriteCallBackData.getSensitiveWords());
                        this.mtL.b(this.lvA, this.mtq);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.mtk)) {
                        dte().requestFocus();
                        return;
                    } else if ("from_content".equals(this.mtk)) {
                        dtd().requestFocus();
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
    public void dtj() {
        if ("1".equals(this.ici)) {
            this.lvi.setCanNoForum(true);
            this.lvi.setTransmitForumData("[]");
        } else if ("2".equals(this.ici)) {
            this.lvi.setCanNoForum(false);
        }
        dtk();
        this.lvi.setPrivacy(this.isPrivacy);
        this.lvi.setIsShareThread(true);
        if (this.mtm != null && !StringUtils.isNull(this.mtm.threadId)) {
            this.lvi.setOriginalThreadId(this.mtm.threadId);
        }
        this.lvi.setBaijiahaoData(this.mBaijiahaoData);
        if (this.mtm != null) {
            this.lvi.setOriBaijiahaoData(this.mtm.oriUgcInfo);
        }
        this.lvi.setCallFrom(this.ici);
        ccc();
    }

    private void dtk() {
        if (this.etN != null) {
            this.etN.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dte());
        HidenSoftKeyPad(this.mInputManager, dtd());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bA(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.hAZ) != null) {
                    TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", av.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.lvi.getType() != 7) {
                if (this.mtv == null) {
                    if (!d(postWriteCallBackData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        return;
                    }
                    return;
                }
                E(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.evC = i;
        if (this.etN != null) {
            this.etN.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void dtl() {
        if (!this.mtG && this.etN != null) {
            this.etN.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.etN.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void in(boolean z) {
        if (this.etN != null) {
            this.etN.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void GU(int i) {
        if (i < this.mtt.size()) {
            for (int i2 = 0; i2 < this.mtt.size(); i2++) {
                this.mtt.get(i2).vJ(false);
            }
            this.mtt.get(i).vJ(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void Ez(int i) {
        this.lvj = i;
        this.lvH.setCurrentIndex(i);
        GU(i);
        this.lvG.setText(this.mPrefixData.getPrefixs().get(i));
        deD();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.lvH, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.lvJ.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes2.dex */
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
        if (this.lvi != null) {
            if (this.lvi.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.lvi.getType() == 5) {
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
            bfE();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.aXk = z;
        if (this.mtK != null && !z) {
            this.mtK.bSl();
        }
        if (this.mtM != null && !z) {
            dsO();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.aXk && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.mtl = false;
            this.mtk = "";
            if ("from_content".equals(str)) {
                this.mtk = "from_content";
            } else if ("from_title".equals(str)) {
                this.mtk = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.za(String.valueOf(charSequence.charAt(i)))) {
                vU(false);
            }
        }
    }

    public void cZD() {
        if (!w.isEmpty(this.mList)) {
            this.mtp.setVisibility(0);
            this.mtp.requestFocus();
            return;
        }
        this.mtp.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dtm() {
        if (((ImageSpan[]) dtd().getText().getSpans(0, dtd().getText().length(), ImageSpan.class)).length > 10) {
            if (this.mtu == null) {
                this.mtu = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.mtu.getView().isShown()) {
                this.mtu.cancel();
            }
            this.mtu.show();
            return true;
        }
        return false;
    }
}
