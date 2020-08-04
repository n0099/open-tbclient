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
    private int lCC;
    private TextView lCZ;
    private com.baidu.tieba.write.i lDa;
    private ImageView lDb;
    private View lDc;
    private TextView mBA;
    private TextView mBB;
    ad mBC;
    private int mBD;
    private String mBE;
    private int mBF;
    private PostCategoryView mBG;
    private HotTopicBussinessData mBJ;
    private TextView mBK;
    private com.baidu.tieba.write.editor.b mBM;
    private e mBO;
    private com.baidu.tieba.view.b mBV;
    private BaijiahaoData mBaijiahaoData;
    private OriginalThreadInfo.ShareInfo mBo;
    private LinearLayout mBq;
    private LinearLayout mBr;
    private View mBu;
    private Toast mBw;
    private AdditionData mBx;
    private RelativeLayout mBy;
    private TextView mBz;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private FrsTabInfoData mvg;
    private ForumTabSelectedView mzD;
    private static final int ilM = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    private static final int eUa = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44);
    private String mBm = "";
    private boolean mBn = false;
    private WriteData lCB = null;
    private boolean mBp = false;
    private InputMethodManager mInputManager = null;
    private EditText lCT = null;
    private View lCU = null;
    private LinearLayout lCW = null;
    private SpanGroupEditText mBs = null;
    private FeedBackModel mBt = null;
    private ArrayList<WritePrefixItemLayout> mBv = new ArrayList<>();
    private final KeyEvent hrA = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView lCY = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener hwp = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout iQn = null;
    private String eBU = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int eBV = 0;
    private View mRootView = null;
    private ScrollView mBH = null;
    private boolean mBI = false;
    private com.baidu.tbadk.core.view.a eJP = null;
    private String mFrom = "write";
    private String iim = "2";
    private SpannableStringBuilder mBL = new SpannableStringBuilder();
    private boolean aYm = false;
    private final b mBN = new b();
    private boolean mzh = false;
    private TbFaceManager.a mBP = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
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
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.lCB != null) {
                TransmitPostEditActivity.this.mBN.aZ(null);
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
                    TransmitPostEditActivity.this.mBN.Py(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.mBN.aZ(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.mBN.b(TransmitPostEditActivity.this.lCT, TransmitPostEditActivity.this.mBs);
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
            if (aVar != null && !StringUtils.isNull(aVar.dlL())) {
                TransmitPostEditActivity.this.a(2, true, aVar.dlL());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener lPE = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
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
    private CustomMessageListener mBQ = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener mBR = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dvY = TransmitPostEditActivity.this.dvY();
            if (dvY >= 0 && dvY < TransmitPostEditActivity.this.mBs.getText().length()) {
                TransmitPostEditActivity.this.mBs.setSelection(dvY);
            }
        }
    };
    private boolean mBS = true;
    private final View.OnFocusChangeListener ggs = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.lCT || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.lCY) {
                if (z) {
                    TransmitPostEditActivity.this.mBS = true;
                    TransmitPostEditActivity.this.dvZ();
                    if (TransmitPostEditActivity.this.eAf != null) {
                        TransmitPostEditActivity.this.eAf.bhl();
                    }
                    l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.lCT);
                } else if (view == TransmitPostEditActivity.this.lCT) {
                    TransmitPostEditActivity.this.lCZ.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.mBs && z) {
                TransmitPostEditActivity.this.mBS = false;
                TransmitPostEditActivity.this.dvZ();
                TransmitPostEditActivity.this.eAf.bhl();
                l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.mBs);
            }
            TransmitPostEditActivity.this.dwe();
        }
    };
    private TextWatcher mBT = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String mBX = "";
        private String mBY;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mBY = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.mBY != null ? this.mBY.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dhM();
            TransmitPostEditActivity.this.dwf();
            EditText dwr = TransmitPostEditActivity.this.dwr();
            if (editable != null && dwr != null && dwr.getText() != null) {
                if (this.mBX == null || !this.mBX.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.mBN != null) {
                        this.mBX = dwr.getText().toString();
                        TransmitPostEditActivity.this.mBN.b(dwr, true);
                        return;
                    }
                    return;
                }
                dwr.setSelection(dwr.getSelectionEnd());
            }
        }
    };
    private TextWatcher mBU = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String mBY;
        private String mBZ = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mBY = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.mBY != null ? this.mBY.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dhM();
            EditText dwq = TransmitPostEditActivity.this.dwq();
            if (editable != null && dwq != null && dwq.getText() != null) {
                int selectionEnd = dwq.getSelectionEnd();
                if (this.mBZ == null || !this.mBZ.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.mBN != null) {
                        this.mBZ = dwq.getText().toString();
                        TransmitPostEditActivity.this.mBN.b(dwq, false);
                        return;
                    }
                    return;
                }
                dwq.setSelection(selectionEnd);
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
        } else if (this.eBP.dlS()) {
            bjm();
        } else {
            this.eBP.vp(false);
            a(1, true, (String) null);
            this.eBP.dlQ();
        }
    }

    private void bjq() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ln(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.a(1, true, (String) null);
                    TransmitPostEditActivity.this.eBP.dlU();
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
    public int dvY() {
        int selectionEnd = dwq().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dwq().getText().getSpans(0, dwq().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dwq().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dwq().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvZ() {
        if (this.eAf != null) {
            this.eAf.setBarLauncherEnabled(!this.mBS);
            this.eAf.setToolEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mBI) {
            this.lCT.setVisibility(8);
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
        registerListener(this.lPE);
        registerListener(this.mBQ);
        cFt();
        this.mBs.requestFocus();
        dcK();
        dwy();
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
        dwa();
        this.eAf.build();
        if (this.mzh) {
            this.eAf.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        }
        if (this.mBq != null) {
            this.mBq.addView(this.eAf);
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
        if (!this.mBI) {
            this.eAf.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.eAf.bhl();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.eAf.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.eAf.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.lCB.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.lCB.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        if (!this.mzh) {
            dwc();
        }
    }

    private void dwa() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.eAf.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        if (!this.mzh && this.mBx == null) {
            if (this.mBM == null) {
                this.mBM = new com.baidu.tieba.write.editor.b(getActivity(), this.iim);
                this.mBM.duO();
                this.mBM.setFrom("from_share_write");
                this.mBM.bH(this.lCB.getForumId(), this.mPrivateThread);
            }
            this.eAf.b(this.mBM);
        }
        this.eAf.bc(arrayList);
        com.baidu.tbadk.editortools.l nT = this.eAf.nT(5);
        if (nT != null) {
            nT.eAR = 1;
            if (this.mzh) {
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
                        if (TransmitPostEditActivity.this.dwp()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.dwp()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof q)) {
                            TransmitPostEditActivity.this.e((q) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.dws();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.dhM();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.mBx == null) {
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
                        if (TransmitPostEditActivity.this.lCB != null) {
                            str = TransmitPostEditActivity.this.lCB.getForumId();
                        } else {
                            str = "";
                        }
                        apVar.dn("fid", str);
                        TiebaStatic.log(apVar);
                        if (TransmitPostEditActivity.this.lCB == null || (videoInfo = TransmitPostEditActivity.this.lCB.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
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
                        TransmitPostEditActivity.this.lCB.setVideoInfo(null);
                        TransmitPostEditActivity.this.dhM();
                        if (TransmitPostEditActivity.this.mBs != null) {
                            TransmitPostEditActivity.this.mBs.requestFocus();
                        }
                        TransmitPostEditActivity.this.eAf.bhl();
                        TransmitPostEditActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.mBs);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.mBn = true;
                        TransmitPostEditActivity.this.wz(true);
                        if (TransmitPostEditActivity.this.dwr().isFocused()) {
                            TransmitPostEditActivity.this.mBm = "from_title";
                        } else if (TransmitPostEditActivity.this.dwq().isFocused()) {
                            TransmitPostEditActivity.this.mBm = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.mBr.setVisibility(0);
                        TransmitPostEditActivity.this.mBr.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.mBr.hasFocus()) {
                            TransmitPostEditActivity.this.mBs.requestFocus();
                            TransmitPostEditActivity.this.mBs.setSelection(TransmitPostEditActivity.this.mBs.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.mBr.setVisibility(8);
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
            if (this.eBP.dlS()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.dlN().getLocationData().dlL());
                return;
            }
            a(1, true, (String) null);
            this.eBP.dlQ();
            return;
        }
        a(0, true, (String) null);
    }

    protected void dhD() {
        if (this.eBQ != null) {
            this.eBQ.cancelLoadData();
        }
        if (this.mBt != null) {
            this.mBt.cancelLoadData();
        }
        if (this.eBP != null) {
            this.eBP.cancelLoadData();
        }
    }

    private void dwb() {
        if (this.mBO != null) {
            this.mBO.hideTip();
        }
    }

    private void dwc() {
        if (this.mBO == null) {
            this.mBO = new e(getPageContext());
        }
        this.mBO.d(this.eAf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dwb();
        TiebaPrepareImageService.StopService();
        dhD();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwd() {
        if (this.lCB == null) {
            finish();
            return;
        }
        this.lCB.setTitle(dwr().getText().toString());
        this.lCB.setContent(dwq().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.lDa != null && this.lDa.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.lDa, getPageContext().getPageActivity());
                return true;
            } else if (this.eAf.biL()) {
                this.eAf.bhl();
                return true;
            } else {
                dhD();
                dwd();
                return true;
            }
        }
        if (i == 67 && (text = dwq().getText()) != null) {
            int selectionStart = dwq().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dwq().onKeyDown(67, this.hrA);
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
        getLayoutMode().onModeChanged(this.iQn);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ao.setViewTextColor(this.lCY, R.color.cp_link_tip_a, 1);
        dvZ();
        ao.setBackgroundColor(this.lCU, R.color.cp_bg_line_c);
        ao.setBackgroundColor(dwr(), R.color.cp_bg_line_d);
        ao.setBackgroundColor(dwq(), R.color.cp_bg_line_d);
        dhM();
        this.eAf.onChangeSkinType(i);
        if (this.mBG != null) {
            this.mBG.bci();
        }
        ao.setViewTextColor(this.mName, R.color.cp_cont_b);
        dwe();
        dwf();
        if (this.mBN != null) {
            this.mBN.c(dwr(), dwq());
        }
        if (this.agm != null) {
            this.agm.onChangeSkinType();
        }
        if (this.mzD != null) {
            this.mzD.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwe() {
        if (this.lCT.hasFocus()) {
            this.lCT.setHintTextColor(ao.getColor(R.color.cp_cont_e));
        } else {
            this.lCT.setHintTextColor(ao.getColor(R.color.cp_cont_d));
        }
        if (this.mBs.hasFocus()) {
            this.mBs.setHintTextColor(ao.getColor(R.color.cp_cont_e));
        } else {
            this.mBs.setHintTextColor(ao.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwf() {
        if (this.lCT != null) {
            if (this.lCT.getText().toString().length() == 0) {
                this.lCT.getPaint().setFakeBoldText(false);
            } else if (this.lCT.getText().toString().length() > 0) {
                this.lCT.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.eJP = new com.baidu.tbadk.core.view.a(getPageContext());
        this.mBI = this.lCB.getType() == 4 || 5 == this.lCB.getType();
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
        dwi();
        this.mBH = (ScrollView) findViewById(R.id.write_scrollview);
        this.mBH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.mBs != null) {
                        l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.mBs);
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
        this.iQn = (RelativeLayout) findViewById(R.id.parent);
        this.mBq = (LinearLayout) findViewById(R.id.tool_view);
        this.mBq.setContentDescription(IStringUtil.TOP_PATH);
        this.mBr = (LinearLayout) findViewById(R.id.title_view);
        this.lCU = findViewById(R.id.interval_view);
        this.mBK = (TextView) findViewById(R.id.hot_topic_title_edt);
        dhL();
        if (this.mBI) {
            this.mBH.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        dhN();
        dwo();
        this.lCW = (LinearLayout) findViewById(R.id.post_content_container);
        this.lCW.setDrawingCacheEnabled(false);
        this.lCW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.mBs.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.ggs);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.dhD();
                TransmitPostEditActivity.this.dwd();
            }
        });
        dwl();
        dwn();
        dwh();
        dvZ();
        dwm();
        dhK();
        dwt();
        dwg();
        if (this.lCB.getType() == 4 && this.lDc != null && this.mBu != null) {
            this.lDc.setVisibility(8);
            this.mBu.setVisibility(8);
        }
        dhM();
        ShowSoftKeyPad(this.mInputManager, this.lCT);
    }

    private void dwg() {
        this.mzD = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.mzD.setData(this.mvg);
        this.mzD.setActivity(this);
    }

    private void dwh() {
        String str;
        String str2;
        if (this.lCB != null) {
            switch (this.lCB.getType()) {
                case 0:
                case 9:
                    if (this.iim != null && this.iim.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                        if (this.mzh) {
                            this.mName.setText(R.string.transmit_to_dynamic_title);
                        }
                    } else if (this.iim != null && this.iim.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.lCB.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.lCT.setVisibility(0);
                    this.mBs.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.mBs.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.mBs.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.lCT.setVisibility(8);
                    return;
            }
        }
    }

    private void dwi() {
        if (this.mzh) {
            this.lCY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.dynamic_publish));
        } else {
            this.lCY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lCY.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.lCY.setLayoutParams(layoutParams);
        this.lCY.setOnFocusChangeListener(this.ggs);
    }

    private void dwj() {
        if (this.lCB != null && this.lCB.getType() == 0 && this.lCB.getType() == 9 && !this.mBp && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = as.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dwr() != null) {
                dwr().setText(cutStringWithSuffix);
                dwr().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void dwk() {
        this.fDY = null;
        this.mBD = -1;
        this.mBF = -1;
        af vc = ae.cdv().vc(1);
        if (vc != null) {
            this.fDY = vc.hJT;
            this.mBD = getIntent().getIntExtra("category_id", -1);
            if (this.fDY != null && !this.fDY.isEmpty() && this.mBD >= 0) {
                this.mBC = new ad();
                this.mBC.hJP = 0;
                this.mBC.name = getPageContext().getResources().getString(R.string.category_auto);
                this.mBF = this.mBC.hJP;
                this.mBE = this.mBC.name;
                for (ad adVar : this.fDY) {
                    if (adVar.hJP == this.mBD) {
                        this.mBF = adVar.hJP;
                        this.mBE = adVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dwl() {
        if (this.fDY != null && !this.fDY.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.mBG = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.mBG.setText(this.mBE);
            this.mBG.setCategoryContainerData(this.fDY, this.mBC, this.mBF);
            this.mBG.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bd bdVar) {
                    if (bdVar != null) {
                        TransmitPostEditActivity.this.mBG.setText(bdVar.name);
                        TransmitPostEditActivity.this.lCB.setCategoryTo(bdVar.hJP);
                        TransmitPostEditActivity.this.mBF = bdVar.hJP;
                        TransmitPostEditActivity.this.mBG.dvK();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.mBG.dvJ();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dwr());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dwq());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.mBV = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.mBV.setTitle(R.string.no_disturb_start_time);
        this.mBV.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.mBV);
        this.mBV.setButton(-2, getPageContext().getString(R.string.cancel), this.mBV);
        return this.mBV;
    }

    private void dwm() {
        this.mBy = (RelativeLayout) findViewById(R.id.addition_container);
        this.mBz = (TextView) findViewById(R.id.addition_create_time);
        this.mBA = (TextView) findViewById(R.id.addition_last_time);
        this.mBB = (TextView) findViewById(R.id.addition_last_content);
        if (this.mBx != null) {
            this.mBy.setVisibility(0);
            this.mBz.setText(getPageContext().getString(R.string.write_addition_create) + as.getFormatTime(this.mBx.getCreateTime() * 1000));
            if (this.mBx.getAlreadyCount() == 0) {
                this.mBA.setVisibility(8);
            } else {
                this.mBA.setText(getPageContext().getString(R.string.write_addition_last) + as.getFormatTime(this.mBx.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.mBx.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.mBB.setText(lastAdditionContent);
            } else {
                this.mBB.setVisibility(8);
            }
            dwq().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.mBx.getAlreadyCount()), Integer.valueOf(this.mBx.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.mBy.setVisibility(8);
    }

    private void dhK() {
        this.lDc = findViewById(R.id.post_prefix_layout);
        this.lCZ = (TextView) findViewById(R.id.post_prefix);
        this.mBu = findViewById(R.id.prefix_divider);
        this.lDb = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.lDc.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.lCC = 1;
            this.lDc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.lCZ.setVisibility(0);
                    TransmitPostEditActivity.this.lDc.setSelected(true);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.lDa, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.eAf.bhl();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.lCT);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.mBs);
                }
            });
            this.lDb = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.lDb.setVisibility(0);
                this.lCZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.lCZ.setSelected(true);
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.lDa, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.eAf.bhl();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dwr());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dwq());
                    }
                });
            }
            this.lDa = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.lDa.a(this);
            this.lDa.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.lDa.setOutsideTouchable(true);
            this.lDa.setFocusable(true);
            this.lDa.setOnDismissListener(this);
            this.lDa.setBackgroundDrawable(ao.getDrawable(R.color.cp_bg_line_d));
            int color = ao.getColor(R.color.cp_cont_b);
            int color2 = ao.getColor(R.color.cp_cont_c);
            ao.setBackgroundResource(this.lCZ, R.color.cp_bg_line_d);
            ao.setImageResource(this.lDb, R.drawable.icon_frs_arrow_n);
            this.lCZ.setTextColor(color);
            this.mBv.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.mBv.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.lDa.addView(writePrefixItemLayout);
            }
            this.lDa.setCurrentIndex(0);
            this.lCZ.setText(prefixs.get(1));
            Hp(1);
            return;
        }
        this.lDc.setVisibility(8);
    }

    protected void dwn() {
        this.lCY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick() && !TransmitPostEditActivity.this.dwz()) {
                    if (TransmitPostEditActivity.this.mBN.a(TransmitPostEditActivity.this.lCT, TransmitPostEditActivity.this.mBs)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.mBN.dud());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dwr());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dwq());
                    TransmitPostEditActivity.this.eAf.bhl();
                    TiebaStatic.log(new ap("c12608").ah("obj_locate", 7));
                    TransmitPostEditActivity.this.dww();
                }
            }
        });
    }

    protected void dhL() {
        this.lCT = (EditText) findViewById(R.id.post_title);
        this.lCT.setOnClickListener(this.mBR);
        this.lCT.setOnFocusChangeListener(this.ggs);
        if ((this.lCB.getType() == 0 || this.lCB.getType() == 9 || this.lCB.getType() == 7) && this.lCB.getTitle() != null) {
            this.lCT.setText(this.lCB.getTitle());
            this.lCT.setSelection(this.lCB.getTitle().length());
        }
        this.lCT.addTextChangedListener(this.mBT);
        if (!this.lCB.getHaveDraft()) {
            dwj();
        }
        this.lCT.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void dhN() {
        this.mBs = (SpanGroupEditText) findViewById(R.id.post_content);
        this.mBs.setDrawingCacheEnabled(false);
        this.mBs.setOnClickListener(this.mBR);
        this.mBs.setTransLink(!this.mzh);
        if (this.eBQ != null) {
            this.eBQ.setSpanGroupManager(this.mBs.getSpanGroupManager());
        }
        if (this.lCB != null) {
            this.lCB.setSpanGroupManager(this.mBs.getSpanGroupManager());
        }
        if (this.lCB.getContent() != null && this.lCB.getContent().length() > 0) {
            this.mBs.setText(TbFaceManager.bkj().al(getPageContext().getPageActivity(), this.lCB.getContent()));
            this.mBs.setSelection(this.mBs.getText().length());
        }
        if (!as.isEmpty(this.hDq)) {
            this.mBs.setSelection(0);
        }
        this.mBs.setOnFocusChangeListener(this.ggs);
        this.mBs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.mBs.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.mBs.addTextChangedListener(this.mBU);
        if (this.mzh) {
            this.mBs.setHint(R.string.dynamic_transmit_publish_edit_str);
        } else if (this.mBo != null && this.mBo.showType == 3) {
            this.mBs.setHint(R.string.share_video_default);
        } else {
            this.mBs.setHint(R.string.share_txt_default);
        }
    }

    private void dwo() {
        this.agm = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agm.getLayoutParams();
        layoutParams.topMargin -= ilM;
        layoutParams.leftMargin = eUa;
        layoutParams.rightMargin = eUa;
        this.agm.setLayoutParams(layoutParams);
        this.agm.setVisibility(0);
        this.agm.a(this.mBo);
        this.agm.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dwp() {
        int i = 5000;
        if (this.mBx != null) {
            i = 1000;
        }
        return dwq().getText() != null && dwq().getText().length() >= i;
    }

    private void zD(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.mBm)) {
                this.mBm = "";
                dwq().requestFocus();
                if (dwq().getText() != null && dwq().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dwq().getSelectionStart();
                    editable = dwq().getText();
                }
            } else if ("from_title".equals(this.mBm)) {
                this.mBm = "";
                dwr().requestFocus();
                if (dwr().getText() != null && dwr().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dwr().getSelectionStart();
                    editable = dwr().getText();
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
            if (this.lCB != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.lCB.getForumId(), 0L), this.lCB.getFirstDir(), this.lCB.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(q qVar) {
        if (((ImageSpan[]) dwq().getText().getSpans(0, dwq().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.mBw == null) {
                this.mBw = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.mBw.getView().isShown()) {
                this.mBw.cancel();
            }
            this.mBw.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, qVar, dwq());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dwq() {
        return this.mBs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dwr() {
        return this.lCT;
    }

    protected void dws() {
        if (dwq().getSelectionStart() > 0) {
            String substring = dwq().getText().toString().substring(0, dwq().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.hrz.matcher(substring);
            if (matcher.find()) {
                dwq().getText().delete(dwq().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dwq().getSelectionStart());
                return;
            }
            dwq().onKeyDown(67, this.hrA);
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
        if (this.lCB != null) {
            String str = "";
            String str2 = "";
            if (dwr() != null) {
                str = dwr().getText().toString();
            }
            if (dwq() != null) {
                str2 = dwq().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.lCB.getType() == 0 || this.lCB.getType() == 9 || this.lCB.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.lCC == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.lCB.setIsNoTitle(true);
                        } else {
                            this.lCB.setIsNoTitle(false);
                            wA(true);
                            return;
                        }
                    } else {
                        this.lCB.setIsNoTitle(false);
                        wA(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.lCB.setIsNoTitle(true);
                } else {
                    this.lCB.setIsNoTitle(false);
                    wA(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.mBI) {
                    wA(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    wA(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                wA(true);
            } else if (this.lCB.getVideoInfo() != null) {
                wA(true);
            } else {
                wA(false);
            }
        }
    }

    private void wA(boolean z) {
        ao.setNavbarTitleColor(this.lCY, R.color.cp_link_tip_a, R.color.s_navbar_title_color);
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
        this.lCB = new WriteData();
        if (bundle != null) {
            this.lCB.setType(bundle.getInt("type", 0));
            this.lCB.setForumId(bundle.getString("forum_id"));
            this.lCB.setForumName(bundle.getString("forum_name"));
            this.lCB.setFirstDir(bundle.getString("forum_first_dir"));
            this.lCB.setSecondDir(bundle.getString("forum_second_dir"));
            this.lCB.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.mBx = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.lCB.setIsAddition(this.mBx != null);
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
            this.lCB.setTitle(bundle.getString("write_title"));
            this.lCB.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.iim = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.mBo = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.ShareInfo.class);
            }
            this.mBaijiahaoData = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.hDq = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.hDr = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.mvg = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.lCB.mDynamicForwardData = (ForwardUploadData) bundle.getSerializable(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA);
            str = string;
        } else {
            Intent intent = getIntent();
            this.lCB.setType(intent.getIntExtra("type", 0));
            this.lCB.setForumId(intent.getStringExtra("forum_id"));
            this.lCB.setForumName(intent.getStringExtra("forum_name"));
            this.lCB.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.lCB.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.lCB.setThreadId(intent.getStringExtra("thread_id"));
            this.mBx = (AdditionData) intent.getSerializableExtra("addition_data");
            this.lCB.setIsAddition(this.mBx != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.lCB.setTitle(intent.getStringExtra("write_title"));
            this.lCB.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.iim = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.mBo = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            this.lCB.mDynamicForwardData = (ForwardUploadData) intent.getSerializableExtra(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA);
            this.hDq = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.hDr = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.mvg = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (this.lCB.mDynamicForwardData != null) {
            this.mzh = true;
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.lCB.getType() == 4 ? 6 : 9);
        this.lCB.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.mBo != null && this.mBo.videoId != null) {
            this.lCB.setVideoId(this.mBo.videoId);
            this.lCB.setOriginalVideoCover(this.mBo.showPicUrl);
            this.lCB.setOriginalVideoTitle(this.mBo.showText);
        }
        if (!as.isEmpty(this.hDq)) {
            if (!as.isEmpty(this.hDr)) {
                this.lCB.setContent("//@" + this.hDr + " :" + this.hDq);
            } else {
                this.lCB.setContent(this.hDq);
            }
        }
        if (this.lCB != null && this.lCB.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.lCB.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.mBp = true;
        }
        dwk();
    }

    private void dwt() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) x.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.lCT.setText(com.baidu.tbadk.plugins.b.Ai(com.baidu.tbadk.plugins.b.Aj(hotTopicBussinessData.mTopicName)));
            this.lCT.setMovementMethod(com.baidu.tieba.view.c.dtE());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString Ai = com.baidu.tbadk.plugins.b.Ai(com.baidu.tbadk.plugins.b.Aj(hotTopicBussinessData.mTopicName));
            if (Ai != null) {
                this.lCT.setText(Ai);
            }
            this.mBK.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.lCB.getType());
        bundle.putString("forum_id", this.lCB.getForumId());
        bundle.putString("forum_name", this.lCB.getForumName());
        bundle.putString("forum_first_dir", this.lCB.getFirstDir());
        bundle.putString("forum_second_dir", this.lCB.getSecondDir());
        bundle.putString("thread_id", this.lCB.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.iim);
        bundle.putSerializable("tab_list", this.mvg);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.mBx != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.mBx));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.iim);
        if (this.lCB.mDynamicForwardData != null) {
            bundle.putSerializable(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA, this.lCB.mDynamicForwardData);
        }
        if (this.mBo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mBo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dwq().getEditableText().toString();
        if (obj != null) {
            dwq().setText(TbFaceManager.bkj().a(getPageContext().getPageActivity(), obj, this.mBP));
            dwq().setSelection(dwq().getText().length());
        }
    }

    private String dwu() {
        if (dwq() == null || dwq().getText() == null) {
            return "";
        }
        String obj = dwq().getText().toString();
        if (StringUtils.isNull(obj)) {
            if (this.mBo != null && this.mBo.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return obj;
    }

    private String dwv() {
        if (this.lCB == null || dwr() == null || dwr().getVisibility() != 0 || dwr().getText() == null) {
            return "";
        }
        String obj = dwr().getText().toString();
        if (this.mPrefixData != null && x.getCount(this.mPrefixData.getPrefixs()) > 0 && this.lCC != 0 && this.lCB.getType() != 4 && this.lCZ != null && this.lCZ.getText() != null) {
            obj = this.lCZ.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            obj = this.mPrefixData.getImplicitTitle() + this.lCB.getTitle();
        }
        if (TextUtils.isEmpty(obj)) {
            return getString(R.string.share_txt_default);
        }
        return obj;
    }

    private void cfA() {
        if (this.lCB != null && this.lCB.mDynamicForwardData != null) {
            dvr();
            return;
        }
        dhD();
        this.lCB.setContent(dwu());
        this.lCB.setTitle(dwv());
        if (this.mBD >= 0) {
            this.lCB.setCategoryFrom(this.mBD);
        }
        if (this.mBF >= 0) {
            this.lCB.setCategoryTo(this.mBF);
        }
        this.lCB.setWriteImagesInfo(this.writeImagesInfo);
        this.lCB.setHasLocationData(this.eBP != null && this.eBP.bNz());
        this.eBQ.vr(this.writeImagesInfo.size() > 0);
        if (!x.isEmpty(this.mList) && this.mBJ != null && this.mBJ.mIsGlobalBlock == 0) {
            this.lCB.setForumId(String.valueOf(this.mBJ.mForumId));
            this.lCB.setForumName(this.mBJ.mForumName);
        }
        dvs();
        this.eBQ.d(this.lCB);
        this.lCB.setContent(this.lCB.getContent().replaceAll("\u0000\n", ""));
        this.lCB.setContent(this.lCB.getContent().replaceAll("\u0000", ""));
        this.lCB.setVcode(null);
        this.eBQ.dhF().setVoice(null);
        this.eBQ.dhF().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.hwp);
        this.eBQ.dmx();
    }

    private void dvs() {
        FrsTabItemData selectedTabItemData;
        if (this.lCB != null && this.mzD != null && (selectedTabItemData = this.mzD.getSelectedTabItemData()) != null) {
            this.lCB.setTabId(selectedTabItemData.tabId);
            this.lCB.setTabName(selectedTabItemData.name);
            this.lCB.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    private void dvr() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        this.lCB.mDynamicForwardData.forward_content = dwu();
        this.lCB.mDynamicForwardData.inputText = dwu();
        this.lCB.mDynamicForwardData.locationPoiId = "0";
        showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
        com.baidu.tieba.write.b.c.b.dvd().a(this.lCB.mDynamicForwardData, new b.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
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
            if (this.mBx != null) {
                i2 = this.mBx.getTotalCount();
                i = this.mBx.getAlreadyCount() + 1;
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
                    dwq().requestFocus();
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
                            dwq().getText().insert(dwq().getSelectionStart(), sb.toString());
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
                        if (this.mBn) {
                            sb2.append(com.baidu.tbadk.plugins.b.eJi);
                            this.mBn = false;
                        }
                        sb2.append(stringExtra);
                        zD(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !x.isEmpty(this.mList) && !x.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.mBJ = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.mBJ);
            }
        } else if (i2 == 0) {
            if (this.eAf != null && !this.eAf.biL()) {
                this.mBs.requestFocus();
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
                        this.mBN.Py(postWriteCallBackData.getErrorString());
                        this.mBN.aZ(postWriteCallBackData.getSensitiveWords());
                        this.mBN.b(this.lCT, this.mBs);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.mBm)) {
                        dwr().requestFocus();
                        return;
                    } else if ("from_content".equals(this.mBm)) {
                        dwq().requestFocus();
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
    public void dww() {
        if ("1".equals(this.iim)) {
            this.lCB.setCanNoForum(true);
            this.lCB.setTransmitForumData("[]");
        } else if ("2".equals(this.iim)) {
            this.lCB.setCanNoForum(false);
        }
        dwx();
        this.lCB.setPrivacy(this.isPrivacy);
        this.lCB.setIsShareThread(true);
        if (this.mBo != null && !StringUtils.isNull(this.mBo.threadId)) {
            this.lCB.setOriginalThreadId(this.mBo.threadId);
        }
        this.lCB.setBaijiahaoData(this.mBaijiahaoData);
        if (this.mBo != null) {
            this.lCB.setOriBaijiahaoData(this.mBo.oriUgcInfo);
        }
        this.lCB.setCallFrom(this.iim);
        cfA();
    }

    private void dwx() {
        if (this.eAf != null) {
            this.eAf.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dwr());
        HidenSoftKeyPad(this.mInputManager, dwq());
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
            } else if (this.lCB.getType() != 7) {
                if (this.mBx == null) {
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

    private void dwy() {
        if (!this.mBI && this.eAf != null) {
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
        if (i < this.mBv.size()) {
            for (int i2 = 0; i2 < this.mBv.size(); i2++) {
                this.mBv.get(i2).wn(false);
            }
            this.mBv.get(i).wn(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void EV(int i) {
        this.lCC = i;
        this.lDa.setCurrentIndex(i);
        Hp(i);
        this.lCZ.setText(this.mPrefixData.getPrefixs().get(i));
        dhM();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.lDa, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.lDc.setSelected(false);
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
        if (this.lCB != null) {
            if (this.lCB.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.lCB.getType() == 5) {
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
        if (this.mBM != null && !z) {
            this.mBM.bVC();
        }
        if (this.mBO != null && !z) {
            dwb();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.aYm && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.mBn = false;
            this.mBm = "";
            if ("from_content".equals(str)) {
                this.mBm = "from_content";
            } else if ("from_title".equals(str)) {
                this.mBm = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.Ah(String.valueOf(charSequence.charAt(i)))) {
                wz(false);
            }
        }
    }

    public void dcK() {
        if (!x.isEmpty(this.mList)) {
            this.mBr.setVisibility(0);
            this.mBr.requestFocus();
            return;
        }
        this.mBr.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dwz() {
        if (((ImageSpan[]) dwq().getText().getSpans(0, dwq().getText().length(), ImageSpan.class)).length > 10) {
            if (this.mBw == null) {
                this.mBw = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.mBw.getView().isShown()) {
                this.mBw.cancel();
            }
            this.mBw.show();
            return true;
        }
        return false;
    }
}
