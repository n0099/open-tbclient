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
import com.baidu.i.a.a;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes3.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0153a, i.a {
    private OriginalThreadCardView agm;
    private EditorTools eAf;
    private LocationModel eBP;
    private NewWriteModel eBQ;
    List<ad> fDY;
    private String hDq;
    private String hDr;
    private boolean isPrivacy;
    private int lCA;
    private TextView lCX;
    private com.baidu.tieba.write.i lCY;
    private ImageView lCZ;
    private View lDa;
    ad mBA;
    private int mBB;
    private String mBC;
    private int mBD;
    private PostCategoryView mBE;
    private HotTopicBussinessData mBH;
    private TextView mBI;
    private com.baidu.tieba.write.editor.b mBK;
    private e mBM;
    private com.baidu.tieba.view.b mBT;
    private BaijiahaoData mBaijiahaoData;
    private OriginalThreadInfo.ShareInfo mBm;
    private LinearLayout mBo;
    private LinearLayout mBp;
    private View mBs;
    private Toast mBu;
    private AdditionData mBv;
    private RelativeLayout mBw;
    private TextView mBx;
    private TextView mBy;
    private TextView mBz;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private FrsTabInfoData mve;
    private ForumTabSelectedView mzB;
    private static final int ilK = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    private static final int eUa = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44);
    private String mBk = "";
    private boolean mBl = false;
    private WriteData lCz = null;
    private boolean mBn = false;
    private InputMethodManager mInputManager = null;
    private EditText lCR = null;
    private View lCS = null;
    private LinearLayout lCU = null;
    private SpanGroupEditText mBq = null;
    private FeedBackModel mBr = null;
    private ArrayList<WritePrefixItemLayout> mBt = new ArrayList<>();
    private final KeyEvent hrA = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView lCW = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener hwp = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout iQl = null;
    private String eBU = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int eBV = 0;
    private View mRootView = null;
    private ScrollView mBF = null;
    private boolean mBG = false;
    private com.baidu.tbadk.core.view.a eJP = null;
    private String mFrom = "write";
    private String iik = "2";
    private SpannableStringBuilder mBJ = new SpannableStringBuilder();
    private boolean aYm = false;
    private final b mBL = new b();
    private boolean mzf = false;
    private TbFaceManager.a mBN = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan zT(String str) {
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
    private final AntiHelper.a hGU = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ah("obj_locate", aw.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ah("obj_locate", aw.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d eCe = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ad adVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.lCz != null) {
                TransmitPostEditActivity.this.mBL.aZ(null);
                if (z) {
                    TransmitPostEditActivity.this.iR(z);
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
                    TransmitPostEditActivity.this.mBL.Py(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.mBL.aZ(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.mBL.b(TransmitPostEditActivity.this.lCR, TransmitPostEditActivity.this.mBq);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (as.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.c(TransmitPostEditActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(TransmitPostEditActivity.this.getActivity());
                    if (as.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.xl(TransmitPostEditActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.xl(postWriteCallBackData.getErrorString());
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
                            TiebaStatic.log(new ap("c13746").ah("obj_locate", 1).ah("obj_type", 1));
                        }
                    });
                    aVar.b(TransmitPostEditActivity.this.getPageContext()).aYL();
                    TiebaStatic.log(new ap("c13745").ah("obj_locate", 1).ah("obj_type", 1));
                } else if ((adVar == null || writeData == null || adVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (adVar != null && writeData != null && adVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(adVar.getVcode_md5());
                    writeData.setVcodeUrl(adVar.getVcode_pic_url());
                    writeData.setVcodeExtra(adVar.bep());
                    if (com.baidu.tbadk.t.a.Ay(adVar.beo())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, adVar.beo())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a eCc = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bjD() {
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
            if (aVar != null && !StringUtils.isNull(aVar.dlK())) {
                TransmitPostEditActivity.this.a(2, true, aVar.dlK());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener lPC = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.eBP.vp(false);
                    TransmitPostEditActivity.this.eBP.fD(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.eBP.vp(true);
                TransmitPostEditActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener mBO = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener mBP = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dvX = TransmitPostEditActivity.this.dvX();
            if (dvX >= 0 && dvX < TransmitPostEditActivity.this.mBq.getText().length()) {
                TransmitPostEditActivity.this.mBq.setSelection(dvX);
            }
        }
    };
    private boolean mBQ = true;
    private final View.OnFocusChangeListener ggs = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.lCR || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.lCW) {
                if (z) {
                    TransmitPostEditActivity.this.mBQ = true;
                    TransmitPostEditActivity.this.dvY();
                    if (TransmitPostEditActivity.this.eAf != null) {
                        TransmitPostEditActivity.this.eAf.bhl();
                    }
                    l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.lCR);
                } else if (view == TransmitPostEditActivity.this.lCR) {
                    TransmitPostEditActivity.this.lCX.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.mBq && z) {
                TransmitPostEditActivity.this.mBQ = false;
                TransmitPostEditActivity.this.dvY();
                TransmitPostEditActivity.this.eAf.bhl();
                l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.mBq);
            }
            TransmitPostEditActivity.this.dwd();
        }
    };
    private TextWatcher mBR = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String mBV = "";
        private String mBW;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mBW = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.mBW != null ? this.mBW.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dhM();
            TransmitPostEditActivity.this.dwe();
            EditText dwq = TransmitPostEditActivity.this.dwq();
            if (editable != null && dwq != null && dwq.getText() != null) {
                if (this.mBV == null || !this.mBV.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.mBL != null) {
                        this.mBV = dwq.getText().toString();
                        TransmitPostEditActivity.this.mBL.b(dwq, true);
                        return;
                    }
                    return;
                }
                dwq.setSelection(dwq.getSelectionEnd());
            }
        }
    };
    private TextWatcher mBS = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String mBW;
        private String mBX = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mBW = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.mBW != null ? this.mBW.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dhM();
            EditText dwp = TransmitPostEditActivity.this.dwp();
            if (editable != null && dwp != null && dwp.getText() != null) {
                int selectionEnd = dwp.getSelectionEnd();
                if (this.mBX == null || !this.mBX.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.mBL != null) {
                        this.mBX = dwp.getText().toString();
                        TransmitPostEditActivity.this.mBL.b(dwp, false);
                        return;
                    }
                    return;
                }
                dwp.setSelection(selectionEnd);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || as.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjm() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void bjo() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bjq();
        } else if (this.eBP.dlR()) {
            bjm();
        } else {
            this.eBP.vp(false);
            a(1, true, (String) null);
            this.eBP.dlP();
        }
    }

    private void bjq() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ln(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.a(1, true, (String) null);
                    TransmitPostEditActivity.this.eBP.dlT();
                } else {
                    TransmitPostEditActivity.this.eCc.bjD();
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
        aVar.aYL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dvX() {
        int selectionEnd = dwp().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dwp().getText().getSpans(0, dwp().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dwp().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dwp().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvY() {
        if (this.eAf != null) {
            this.eAf.setBarLauncherEnabled(!this.mBQ);
            this.eAf.setToolEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mBG) {
            this.lCR.setVisibility(8);
            dhM();
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
        this.eBP = new LocationModel(getPageContext());
        this.eBP.a(this.eCc);
        registerListener(this.lPC);
        registerListener(this.mBO);
        cFt();
        this.mBq.requestFocus();
        dcK();
        dwx();
    }

    @SuppressLint({"ResourceAsColor"})
    private void cFt() {
        this.eAf = new EditorTools(getActivity());
        this.eAf.setBarMaxLauCount(4);
        this.eAf.setMoreButtonAtEnd(true);
        this.eAf.setBarLauncherType(1);
        this.eAf.iJ(true);
        this.eAf.iK(true);
        this.eAf.setBackgroundColorId(R.color.cp_bg_line_h);
        dvZ();
        this.eAf.build();
        if (this.mzf) {
            this.eAf.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        }
        if (this.mBo != null) {
            this.mBo.addView(this.eAf);
        }
        czf();
        this.eAf.display();
        com.baidu.tbadk.editortools.g nQ = this.eAf.nQ(6);
        if (nQ != null && !TextUtils.isEmpty(this.eBU)) {
            ((View) nQ).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.eBU);
                }
            });
        }
        if (!this.mBG) {
            this.eAf.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.eAf.bhl();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.eAf.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.eAf.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.lCz.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.lCz.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        if (!this.mzf) {
            dwb();
        }
    }

    private void dvZ() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.eAf.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        if (!this.mzf && this.mBv == null) {
            if (this.mBK == null) {
                this.mBK = new com.baidu.tieba.write.editor.b(getActivity(), this.iik);
                this.mBK.duN();
                this.mBK.setFrom("from_share_write");
                this.mBK.bH(this.lCz.getForumId(), this.mPrivateThread);
            }
            this.eAf.b(this.mBK);
        }
        this.eAf.bc(arrayList);
        com.baidu.tbadk.editortools.l nT = this.eAf.nT(5);
        if (nT != null) {
            nT.eAR = 1;
            if (this.mzf) {
                nT.iM(false);
            }
        }
    }

    private void czf() {
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
                            TiebaStatic.log(new ap("c12608").ah("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.dwo()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.dwo()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof q)) {
                            TransmitPostEditActivity.this.e((q) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.dwr();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.dhM();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.mBv == null) {
                            TransmitPostEditActivity.this.bjr();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.eBV) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (com.baidu.tbadk.core.util.ad.checkLocationForGoogle(pageActivity)) {
                                    TransmitPostEditActivity.this.bjo();
                                    return;
                                } else {
                                    com.baidu.tbadk.core.util.ad.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.bjm();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.eBP != null) {
                            TransmitPostEditActivity.this.eBP.vp(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        ap apVar = new ap("c10645");
                        if (TransmitPostEditActivity.this.lCz != null) {
                            str = TransmitPostEditActivity.this.lCz.getForumId();
                        } else {
                            str = "";
                        }
                        apVar.dn("fid", str);
                        TiebaStatic.log(apVar);
                        if (TransmitPostEditActivity.this.lCz == null || (videoInfo = TransmitPostEditActivity.this.lCz.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.eAf.biL()) {
                                        TransmitPostEditActivity.this.eAf.bhl();
                                        TransmitPostEditActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.lCz.setVideoInfo(null);
                        TransmitPostEditActivity.this.dhM();
                        if (TransmitPostEditActivity.this.mBq != null) {
                            TransmitPostEditActivity.this.mBq.requestFocus();
                        }
                        TransmitPostEditActivity.this.eAf.bhl();
                        TransmitPostEditActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.mBq);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.mBl = true;
                        TransmitPostEditActivity.this.wz(true);
                        if (TransmitPostEditActivity.this.dwq().isFocused()) {
                            TransmitPostEditActivity.this.mBk = "from_title";
                        } else if (TransmitPostEditActivity.this.dwp().isFocused()) {
                            TransmitPostEditActivity.this.mBk = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.mBp.setVisibility(0);
                        TransmitPostEditActivity.this.mBp.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.mBp.hasFocus()) {
                            TransmitPostEditActivity.this.mBq.requestFocus();
                            TransmitPostEditActivity.this.mBq.setSelection(TransmitPostEditActivity.this.mBq.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.mBp.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.eAf.setActionListener(31, bVar);
        this.eAf.setActionListener(16, bVar);
        this.eAf.setActionListener(14, bVar);
        this.eAf.setActionListener(24, bVar);
        this.eAf.setActionListener(3, bVar);
        this.eAf.setActionListener(10, bVar);
        this.eAf.setActionListener(11, bVar);
        this.eAf.setActionListener(12, bVar);
        this.eAf.setActionListener(13, bVar);
        this.eAf.setActionListener(15, bVar);
        this.eAf.setActionListener(18, bVar);
        this.eAf.setActionListener(20, bVar);
        this.eAf.setActionListener(25, bVar);
        this.eAf.setActionListener(27, bVar);
        this.eAf.setActionListener(29, bVar);
        this.eAf.setActionListener(43, bVar);
        this.eAf.setActionListener(45, bVar);
        this.eAf.setActionListener(53, bVar);
        this.eAf.setActionListener(48, bVar);
        this.eAf.setActionListener(46, bVar);
        this.eAf.setActionListener(49, bVar);
        this.eAf.setActionListener(47, bVar);
        this.eAf.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjr() {
        if (this.eBP.bNz()) {
            if (this.eBP.dlR()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.dlM().getLocationData().dlK());
                return;
            }
            a(1, true, (String) null);
            this.eBP.dlP();
            return;
        }
        a(0, true, (String) null);
    }

    protected void dhD() {
        if (this.eBQ != null) {
            this.eBQ.cancelLoadData();
        }
        if (this.mBr != null) {
            this.mBr.cancelLoadData();
        }
        if (this.eBP != null) {
            this.eBP.cancelLoadData();
        }
    }

    private void dwa() {
        if (this.mBM != null) {
            this.mBM.hideTip();
        }
    }

    private void dwb() {
        if (this.mBM == null) {
            this.mBM = new e(getPageContext());
        }
        this.mBM.d(this.eAf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dwa();
        TiebaPrepareImageService.StopService();
        dhD();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwc() {
        if (this.lCz == null) {
            finish();
            return;
        }
        this.lCz.setTitle(dwq().getText().toString());
        this.lCz.setContent(dwp().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.lCY != null && this.lCY.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.lCY, getPageContext().getPageActivity());
                return true;
            } else if (this.eAf.biL()) {
                this.eAf.bhl();
                return true;
            } else {
                dhD();
                dwc();
                return true;
            }
        }
        if (i == 67 && (text = dwp().getText()) != null) {
            int selectionStart = dwp().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dwp().onKeyDown(67, this.hrA);
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
        getLayoutMode().onModeChanged(this.iQl);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ao.setViewTextColor(this.lCW, R.color.cp_link_tip_a, 1);
        dvY();
        ao.setBackgroundColor(this.lCS, R.color.cp_bg_line_c);
        ao.setBackgroundColor(dwq(), R.color.cp_bg_line_d);
        ao.setBackgroundColor(dwp(), R.color.cp_bg_line_d);
        dhM();
        this.eAf.onChangeSkinType(i);
        if (this.mBE != null) {
            this.mBE.bci();
        }
        ao.setViewTextColor(this.mName, R.color.cp_cont_b);
        dwd();
        dwe();
        if (this.mBL != null) {
            this.mBL.c(dwq(), dwp());
        }
        if (this.agm != null) {
            this.agm.onChangeSkinType();
        }
        if (this.mzB != null) {
            this.mzB.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwd() {
        if (this.lCR.hasFocus()) {
            this.lCR.setHintTextColor(ao.getColor(R.color.cp_cont_e));
        } else {
            this.lCR.setHintTextColor(ao.getColor(R.color.cp_cont_d));
        }
        if (this.mBq.hasFocus()) {
            this.mBq.setHintTextColor(ao.getColor(R.color.cp_cont_e));
        } else {
            this.mBq.setHintTextColor(ao.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwe() {
        if (this.lCR != null) {
            if (this.lCR.getText().toString().length() == 0) {
                this.lCR.getPaint().setFakeBoldText(false);
            } else if (this.lCR.getText().toString().length() > 0) {
                this.lCR.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.eJP = new com.baidu.tbadk.core.view.a(getPageContext());
        this.mBG = this.lCz.getType() == 4 || 5 == this.lCz.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.baR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ao.setViewTextColor(this.mName, R.color.cp_cont_b);
        dwh();
        this.mBF = (ScrollView) findViewById(R.id.write_scrollview);
        this.mBF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.mBq != null) {
                        l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.mBq);
                    }
                    if (TransmitPostEditActivity.this.eAf != null) {
                        TransmitPostEditActivity.this.eAf.bhl();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.iQl = (RelativeLayout) findViewById(R.id.parent);
        this.mBo = (LinearLayout) findViewById(R.id.tool_view);
        this.mBo.setContentDescription(IStringUtil.TOP_PATH);
        this.mBp = (LinearLayout) findViewById(R.id.title_view);
        this.lCS = findViewById(R.id.interval_view);
        this.mBI = (TextView) findViewById(R.id.hot_topic_title_edt);
        dhL();
        if (this.mBG) {
            this.mBF.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        dhN();
        dwn();
        this.lCU = (LinearLayout) findViewById(R.id.post_content_container);
        this.lCU.setDrawingCacheEnabled(false);
        this.lCU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.mBq.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.ggs);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.dhD();
                TransmitPostEditActivity.this.dwc();
            }
        });
        dwk();
        dwm();
        dwg();
        dvY();
        dwl();
        dhK();
        dws();
        dwf();
        if (this.lCz.getType() == 4 && this.lDa != null && this.mBs != null) {
            this.lDa.setVisibility(8);
            this.mBs.setVisibility(8);
        }
        dhM();
        ShowSoftKeyPad(this.mInputManager, this.lCR);
    }

    private void dwf() {
        this.mzB = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.mzB.setData(this.mve);
        this.mzB.setActivity(this);
    }

    private void dwg() {
        String str;
        String str2;
        if (this.lCz != null) {
            switch (this.lCz.getType()) {
                case 0:
                case 9:
                    if (this.iik != null && this.iik.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                        if (this.mzf) {
                            this.mName.setText(R.string.transmit_to_dynamic_title);
                        }
                    } else if (this.iik != null && this.iik.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.lCz.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.lCR.setVisibility(0);
                    this.mBq.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.mBq.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.mBq.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.lCR.setVisibility(8);
                    return;
            }
        }
    }

    private void dwh() {
        if (this.mzf) {
            this.lCW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.dynamic_publish));
        } else {
            this.lCW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lCW.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.lCW.setLayoutParams(layoutParams);
        this.lCW.setOnFocusChangeListener(this.ggs);
    }

    private void dwi() {
        if (this.lCz != null && this.lCz.getType() == 0 && this.lCz.getType() == 9 && !this.mBn && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = as.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dwq() != null) {
                dwq().setText(cutStringWithSuffix);
                dwq().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void dwj() {
        this.fDY = null;
        this.mBB = -1;
        this.mBD = -1;
        af vc = ae.cdv().vc(1);
        if (vc != null) {
            this.fDY = vc.hJT;
            this.mBB = getIntent().getIntExtra("category_id", -1);
            if (this.fDY != null && !this.fDY.isEmpty() && this.mBB >= 0) {
                this.mBA = new ad();
                this.mBA.hJP = 0;
                this.mBA.name = getPageContext().getResources().getString(R.string.category_auto);
                this.mBD = this.mBA.hJP;
                this.mBC = this.mBA.name;
                for (ad adVar : this.fDY) {
                    if (adVar.hJP == this.mBB) {
                        this.mBD = adVar.hJP;
                        this.mBC = adVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dwk() {
        if (this.fDY != null && !this.fDY.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.mBE = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.mBE.setText(this.mBC);
            this.mBE.setCategoryContainerData(this.fDY, this.mBA, this.mBD);
            this.mBE.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bd bdVar) {
                    if (bdVar != null) {
                        TransmitPostEditActivity.this.mBE.setText(bdVar.name);
                        TransmitPostEditActivity.this.lCz.setCategoryTo(bdVar.hJP);
                        TransmitPostEditActivity.this.mBD = bdVar.hJP;
                        TransmitPostEditActivity.this.mBE.dvJ();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.mBE.dvI();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dwq());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dwp());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.mBT = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.mBT.setTitle(R.string.no_disturb_start_time);
        this.mBT.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.mBT);
        this.mBT.setButton(-2, getPageContext().getString(R.string.cancel), this.mBT);
        return this.mBT;
    }

    private void dwl() {
        this.mBw = (RelativeLayout) findViewById(R.id.addition_container);
        this.mBx = (TextView) findViewById(R.id.addition_create_time);
        this.mBy = (TextView) findViewById(R.id.addition_last_time);
        this.mBz = (TextView) findViewById(R.id.addition_last_content);
        if (this.mBv != null) {
            this.mBw.setVisibility(0);
            this.mBx.setText(getPageContext().getString(R.string.write_addition_create) + as.getFormatTime(this.mBv.getCreateTime() * 1000));
            if (this.mBv.getAlreadyCount() == 0) {
                this.mBy.setVisibility(8);
            } else {
                this.mBy.setText(getPageContext().getString(R.string.write_addition_last) + as.getFormatTime(this.mBv.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.mBv.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.mBz.setText(lastAdditionContent);
            } else {
                this.mBz.setVisibility(8);
            }
            dwp().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.mBv.getAlreadyCount()), Integer.valueOf(this.mBv.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.mBw.setVisibility(8);
    }

    private void dhK() {
        this.lDa = findViewById(R.id.post_prefix_layout);
        this.lCX = (TextView) findViewById(R.id.post_prefix);
        this.mBs = findViewById(R.id.prefix_divider);
        this.lCZ = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.lDa.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.lCA = 1;
            this.lDa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.lCX.setVisibility(0);
                    TransmitPostEditActivity.this.lDa.setSelected(true);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.lCY, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.eAf.bhl();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.lCR);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.mBq);
                }
            });
            this.lCZ = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.lCZ.setVisibility(0);
                this.lCX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.lCX.setSelected(true);
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.lCY, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.eAf.bhl();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dwq());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dwp());
                    }
                });
            }
            this.lCY = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.lCY.a(this);
            this.lCY.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.lCY.setOutsideTouchable(true);
            this.lCY.setFocusable(true);
            this.lCY.setOnDismissListener(this);
            this.lCY.setBackgroundDrawable(ao.getDrawable(R.color.cp_bg_line_d));
            int color = ao.getColor(R.color.cp_cont_b);
            int color2 = ao.getColor(R.color.cp_cont_c);
            ao.setBackgroundResource(this.lCX, R.color.cp_bg_line_d);
            ao.setImageResource(this.lCZ, R.drawable.icon_frs_arrow_n);
            this.lCX.setTextColor(color);
            this.mBt.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.mBt.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.lCY.addView(writePrefixItemLayout);
            }
            this.lCY.setCurrentIndex(0);
            this.lCX.setText(prefixs.get(1));
            Hp(1);
            return;
        }
        this.lDa.setVisibility(8);
    }

    protected void dwm() {
        this.lCW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick() && !TransmitPostEditActivity.this.dwy()) {
                    if (TransmitPostEditActivity.this.mBL.a(TransmitPostEditActivity.this.lCR, TransmitPostEditActivity.this.mBq)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.mBL.duc());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dwq());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dwp());
                    TransmitPostEditActivity.this.eAf.bhl();
                    TiebaStatic.log(new ap("c12608").ah("obj_locate", 7));
                    TransmitPostEditActivity.this.dwv();
                }
            }
        });
    }

    protected void dhL() {
        this.lCR = (EditText) findViewById(R.id.post_title);
        this.lCR.setOnClickListener(this.mBP);
        this.lCR.setOnFocusChangeListener(this.ggs);
        if ((this.lCz.getType() == 0 || this.lCz.getType() == 9 || this.lCz.getType() == 7) && this.lCz.getTitle() != null) {
            this.lCR.setText(this.lCz.getTitle());
            this.lCR.setSelection(this.lCz.getTitle().length());
        }
        this.lCR.addTextChangedListener(this.mBR);
        if (!this.lCz.getHaveDraft()) {
            dwi();
        }
        this.lCR.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void dhN() {
        this.mBq = (SpanGroupEditText) findViewById(R.id.post_content);
        this.mBq.setDrawingCacheEnabled(false);
        this.mBq.setOnClickListener(this.mBP);
        this.mBq.setTransLink(!this.mzf);
        if (this.eBQ != null) {
            this.eBQ.setSpanGroupManager(this.mBq.getSpanGroupManager());
        }
        if (this.lCz != null) {
            this.lCz.setSpanGroupManager(this.mBq.getSpanGroupManager());
        }
        if (this.lCz.getContent() != null && this.lCz.getContent().length() > 0) {
            this.mBq.setText(TbFaceManager.bkj().al(getPageContext().getPageActivity(), this.lCz.getContent()));
            this.mBq.setSelection(this.mBq.getText().length());
        }
        if (!as.isEmpty(this.hDq)) {
            this.mBq.setSelection(0);
        }
        this.mBq.setOnFocusChangeListener(this.ggs);
        this.mBq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.mBq.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.mBq.addTextChangedListener(this.mBS);
        if (this.mzf) {
            this.mBq.setHint(R.string.dynamic_transmit_publish_edit_str);
        } else if (this.mBm != null && this.mBm.showType == 3) {
            this.mBq.setHint(R.string.share_video_default);
        } else {
            this.mBq.setHint(R.string.share_txt_default);
        }
    }

    private void dwn() {
        this.agm = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agm.getLayoutParams();
        layoutParams.topMargin -= ilK;
        layoutParams.leftMargin = eUa;
        layoutParams.rightMargin = eUa;
        this.agm.setLayoutParams(layoutParams);
        this.agm.setVisibility(0);
        this.agm.a(this.mBm);
        this.agm.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dwo() {
        int i = 5000;
        if (this.mBv != null) {
            i = 1000;
        }
        return dwp().getText() != null && dwp().getText().length() >= i;
    }

    private void zD(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.mBk)) {
                this.mBk = "";
                dwp().requestFocus();
                if (dwp().getText() != null && dwp().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dwp().getSelectionStart();
                    editable = dwp().getText();
                }
            } else if ("from_title".equals(this.mBk)) {
                this.mBk = "";
                dwq().requestFocus();
                if (dwq().getText() != null && dwq().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dwq().getSelectionStart();
                    editable = dwq().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wz(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.lCz != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.lCz.getForumId(), 0L), this.lCz.getFirstDir(), this.lCz.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(q qVar) {
        if (((ImageSpan[]) dwp().getText().getSpans(0, dwp().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.mBu == null) {
                this.mBu = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.mBu.getView().isShown()) {
                this.mBu.cancel();
            }
            this.mBu.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, qVar, dwp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dwp() {
        return this.mBq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dwq() {
        return this.lCR;
    }

    protected void dwr() {
        if (dwp().getSelectionStart() > 0) {
            String substring = dwp().getText().toString().substring(0, dwp().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.hrz.matcher(substring);
            if (matcher.find()) {
                dwp().getText().delete(dwp().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dwp().getSelectionStart());
                return;
            }
            dwp().onKeyDown(67, this.hrA);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.eJP.setCancelListener(null);
        this.eJP.setTipString(R.string.sending);
        this.eJP.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.eJP.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhM() {
        if (this.lCz != null) {
            String str = "";
            String str2 = "";
            if (dwq() != null) {
                str = dwq().getText().toString();
            }
            if (dwp() != null) {
                str2 = dwp().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.lCz.getType() == 0 || this.lCz.getType() == 9 || this.lCz.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.lCA == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.lCz.setIsNoTitle(true);
                        } else {
                            this.lCz.setIsNoTitle(false);
                            wA(true);
                            return;
                        }
                    } else {
                        this.lCz.setIsNoTitle(false);
                        wA(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.lCz.setIsNoTitle(true);
                } else {
                    this.lCz.setIsNoTitle(false);
                    wA(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.mBG) {
                    wA(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    wA(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                wA(true);
            } else if (this.lCz.getVideoInfo() != null) {
                wA(true);
            } else {
                wA(false);
            }
        }
    }

    private void wA(boolean z) {
        ao.setNavbarTitleColor(this.lCW, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.eBQ = new NewWriteModel(this);
        this.eBQ.b(this.eCe);
        this.hwp = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.dhD();
            }
        };
        this.lCz = new WriteData();
        if (bundle != null) {
            this.lCz.setType(bundle.getInt("type", 0));
            this.lCz.setForumId(bundle.getString("forum_id"));
            this.lCz.setForumName(bundle.getString("forum_name"));
            this.lCz.setFirstDir(bundle.getString("forum_first_dir"));
            this.lCz.setSecondDir(bundle.getString("forum_second_dir"));
            this.lCz.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.mBv = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.lCz.setIsAddition(this.mBv != null);
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
            this.lCz.setTitle(bundle.getString("write_title"));
            this.lCz.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.iik = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.mBm = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.ShareInfo.class);
            }
            this.mBaijiahaoData = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.hDq = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.hDr = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.mve = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.lCz.mDynamicForwardData = (ForwardUploadData) bundle.getSerializable(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA);
            str = string;
        } else {
            Intent intent = getIntent();
            this.lCz.setType(intent.getIntExtra("type", 0));
            this.lCz.setForumId(intent.getStringExtra("forum_id"));
            this.lCz.setForumName(intent.getStringExtra("forum_name"));
            this.lCz.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.lCz.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.lCz.setThreadId(intent.getStringExtra("thread_id"));
            this.mBv = (AdditionData) intent.getSerializableExtra("addition_data");
            this.lCz.setIsAddition(this.mBv != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.lCz.setTitle(intent.getStringExtra("write_title"));
            this.lCz.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.iik = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.mBm = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            this.lCz.mDynamicForwardData = (ForwardUploadData) intent.getSerializableExtra(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA);
            this.hDq = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.hDr = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.mve = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (this.lCz.mDynamicForwardData != null) {
            this.mzf = true;
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.lCz.getType() == 4 ? 6 : 9);
        this.lCz.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.mBm != null && this.mBm.videoId != null) {
            this.lCz.setVideoId(this.mBm.videoId);
            this.lCz.setOriginalVideoCover(this.mBm.showPicUrl);
            this.lCz.setOriginalVideoTitle(this.mBm.showText);
        }
        if (!as.isEmpty(this.hDq)) {
            if (!as.isEmpty(this.hDr)) {
                this.lCz.setContent("//@" + this.hDr + " :" + this.hDq);
            } else {
                this.lCz.setContent(this.hDq);
            }
        }
        if (this.lCz != null && this.lCz.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.lCz.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.mBn = true;
        }
        dwj();
    }

    private void dws() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) x.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.lCR.setText(com.baidu.tbadk.plugins.b.Ai(com.baidu.tbadk.plugins.b.Aj(hotTopicBussinessData.mTopicName)));
            this.lCR.setMovementMethod(com.baidu.tieba.view.c.dtD());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString Ai = com.baidu.tbadk.plugins.b.Ai(com.baidu.tbadk.plugins.b.Aj(hotTopicBussinessData.mTopicName));
            if (Ai != null) {
                this.lCR.setText(Ai);
            }
            this.mBI.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.lCz.getType());
        bundle.putString("forum_id", this.lCz.getForumId());
        bundle.putString("forum_name", this.lCz.getForumName());
        bundle.putString("forum_first_dir", this.lCz.getFirstDir());
        bundle.putString("forum_second_dir", this.lCz.getSecondDir());
        bundle.putString("thread_id", this.lCz.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.iik);
        bundle.putSerializable("tab_list", this.mve);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.mBv != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.mBv));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.iik);
        if (this.lCz.mDynamicForwardData != null) {
            bundle.putSerializable(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA, this.lCz.mDynamicForwardData);
        }
        if (this.mBm != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mBm));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dwp().getEditableText().toString();
        if (obj != null) {
            dwp().setText(TbFaceManager.bkj().a(getPageContext().getPageActivity(), obj, this.mBN));
            dwp().setSelection(dwp().getText().length());
        }
    }

    private String dwt() {
        if (dwp() == null || dwp().getText() == null) {
            return "";
        }
        String obj = dwp().getText().toString();
        if (StringUtils.isNull(obj)) {
            if (this.mBm != null && this.mBm.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return obj;
    }

    private String dwu() {
        if (this.lCz == null || dwq() == null || dwq().getVisibility() != 0 || dwq().getText() == null) {
            return "";
        }
        String obj = dwq().getText().toString();
        if (this.mPrefixData != null && x.getCount(this.mPrefixData.getPrefixs()) > 0 && this.lCA != 0 && this.lCz.getType() != 4 && this.lCX != null && this.lCX.getText() != null) {
            obj = this.lCX.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            obj = this.mPrefixData.getImplicitTitle() + this.lCz.getTitle();
        }
        if (TextUtils.isEmpty(obj)) {
            return getString(R.string.share_txt_default);
        }
        return obj;
    }

    private void cfA() {
        if (this.lCz != null && this.lCz.mDynamicForwardData != null) {
            dvq();
            return;
        }
        dhD();
        this.lCz.setContent(dwt());
        this.lCz.setTitle(dwu());
        if (this.mBB >= 0) {
            this.lCz.setCategoryFrom(this.mBB);
        }
        if (this.mBD >= 0) {
            this.lCz.setCategoryTo(this.mBD);
        }
        this.lCz.setWriteImagesInfo(this.writeImagesInfo);
        this.lCz.setHasLocationData(this.eBP != null && this.eBP.bNz());
        this.eBQ.vr(this.writeImagesInfo.size() > 0);
        if (!x.isEmpty(this.mList) && this.mBH != null && this.mBH.mIsGlobalBlock == 0) {
            this.lCz.setForumId(String.valueOf(this.mBH.mForumId));
            this.lCz.setForumName(this.mBH.mForumName);
        }
        dvr();
        this.eBQ.d(this.lCz);
        this.lCz.setContent(this.lCz.getContent().replaceAll("\u0000\n", ""));
        this.lCz.setContent(this.lCz.getContent().replaceAll("\u0000", ""));
        this.lCz.setVcode(null);
        this.eBQ.dhF().setVoice(null);
        this.eBQ.dhF().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.hwp);
        this.eBQ.dmw();
    }

    private void dvr() {
        FrsTabItemData selectedTabItemData;
        if (this.lCz != null && this.mzB != null && (selectedTabItemData = this.mzB.getSelectedTabItemData()) != null) {
            this.lCz.setTabId(selectedTabItemData.tabId);
            this.lCz.setTabName(selectedTabItemData.name);
            this.lCz.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    private void dvq() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        this.lCz.mDynamicForwardData.forward_content = dwt();
        this.lCz.mDynamicForwardData.inputText = dwt();
        this.lCz.mDynamicForwardData.locationPoiId = "0";
        showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
        com.baidu.tieba.write.b.c.b.dvc().a(this.lCz.mDynamicForwardData, new b.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // com.baidu.tieba.write.b.c.b.a
            public void onSuccess(String str) {
                TransmitPostEditActivity.this.closeLoadingDialog();
                com.baidu.tieba.tbadkCore.writeModel.c.f(TransmitPostEditActivity.this.getPageContext().getPageActivity(), null, null, null);
                TransmitPostEditActivity.this.iR(true);
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
            if (this.mBv != null) {
                i2 = this.mBv.getTotalCount();
                i = this.mBv.getAlreadyCount() + 1;
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
                if (this.eAf != null && !this.eAf.biL()) {
                    dwp().requestFocus();
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
                            dwp().getText().insert(dwp().getSelectionStart(), sb.toString());
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
                        if (this.mBl) {
                            sb2.append(com.baidu.tbadk.plugins.b.eJi);
                            this.mBl = false;
                        }
                        sb2.append(stringExtra);
                        zD(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !x.isEmpty(this.mList) && !x.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.mBH = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.mBH);
            }
        } else if (i2 == 0) {
            if (this.eAf != null && !this.eAf.biL()) {
                this.mBq.requestFocus();
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
                        this.mBL.Py(postWriteCallBackData.getErrorString());
                        this.mBL.aZ(postWriteCallBackData.getSensitiveWords());
                        this.mBL.b(this.lCR, this.mBq);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.mBk)) {
                        dwq().requestFocus();
                        return;
                    } else if ("from_content".equals(this.mBk)) {
                        dwp().requestFocus();
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
    public void dwv() {
        if ("1".equals(this.iik)) {
            this.lCz.setCanNoForum(true);
            this.lCz.setTransmitForumData("[]");
        } else if ("2".equals(this.iik)) {
            this.lCz.setCanNoForum(false);
        }
        dww();
        this.lCz.setPrivacy(this.isPrivacy);
        this.lCz.setIsShareThread(true);
        if (this.mBm != null && !StringUtils.isNull(this.mBm.threadId)) {
            this.lCz.setOriginalThreadId(this.mBm.threadId);
        }
        this.lCz.setBaijiahaoData(this.mBaijiahaoData);
        if (this.mBm != null) {
            this.lCz.setOriBaijiahaoData(this.mBm.oriUgcInfo);
        }
        this.lCz.setCallFrom(this.iik);
        cfA();
    }

    private void dww() {
        if (this.eAf != null) {
            this.eAf.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dwq());
        HidenSoftKeyPad(this.mInputManager, dwp());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bB(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.hGU) != null) {
                    TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ah("obj_locate", aw.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.lCz.getType() != 7) {
                if (this.mBv == null) {
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
        this.eBV = i;
        if (this.eAf != null) {
            this.eAf.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void dwx() {
        if (!this.mBG && this.eAf != null) {
            this.eAf.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.eAf.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iR(boolean z) {
        if (this.eAf != null) {
            this.eAf.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Hp(int i) {
        if (i < this.mBt.size()) {
            for (int i2 = 0; i2 < this.mBt.size(); i2++) {
                this.mBt.get(i2).wn(false);
            }
            this.mBt.get(i).wn(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void EV(int i) {
        this.lCA = i;
        this.lCY.setCurrentIndex(i);
        Hp(i);
        this.lCX.setText(this.mPrefixData.getPrefixs().get(i));
        dhM();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.lCY, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.lDa.setSelected(false);
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
            l.hideSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.lCz != null) {
            if (this.lCz.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.lCz.getType() == 5) {
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
            bjo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.aYm = z;
        if (this.mBK != null && !z) {
            this.mBK.bVC();
        }
        if (this.mBM != null && !z) {
            dwa();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.aYm && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.mBl = false;
            this.mBk = "";
            if ("from_content".equals(str)) {
                this.mBk = "from_content";
            } else if ("from_title".equals(str)) {
                this.mBk = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.Ah(String.valueOf(charSequence.charAt(i)))) {
                wz(false);
            }
        }
    }

    public void dcK() {
        if (!x.isEmpty(this.mList)) {
            this.mBp.setVisibility(0);
            this.mBp.requestFocus();
            return;
        }
        this.mBp.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dwy() {
        if (((ImageSpan[]) dwp().getText().getSpans(0, dwp().getText().length(), ImageSpan.class)).length > 10) {
            if (this.mBu == null) {
                this.mBu = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.mBu.getView().isShown()) {
                this.mBu.cancel();
            }
            this.mBu.show();
            return true;
        }
        return false;
    }
}
