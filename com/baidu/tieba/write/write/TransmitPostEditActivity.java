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
import com.baidu.n.a.a;
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
import com.baidu.tieba.frs.ae;
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
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0276a, i.a {
    private OriginalThreadCardView ajl;
    private EditorTools fuh;
    private LocationModel fwt;
    private NewWriteModel fwu;
    List<ae> gDf;
    private String iQN;
    private String iQO;
    private boolean isPrivacy;
    private BaijiahaoData mBaijiahaoData;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private FrsTabInfoData nVl;
    private ForumTabSelectedView nZE;
    private TextView nbB;
    private com.baidu.tieba.write.i nbC;
    private ImageView nbD;
    private View nbE;
    private int nbf;
    private g ocB;
    private com.baidu.tieba.view.b ocI;
    private OriginalThreadInfo.ShareInfo oca;
    private LinearLayout occ;
    private LinearLayout ocd;
    private View ocg;
    private Toast oci;
    private AdditionData ocj;
    private RelativeLayout ock;
    private TextView ocl;
    private TextView ocm;
    private TextView ocn;
    ae oco;
    private int ocp;
    private String ocq;
    private int ocs;
    private PostCategoryView oct;
    private HotTopicBussinessData ocw;
    private TextView ocx;
    private com.baidu.tieba.write.editor.b ocz;
    private static final int obX = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    private static final int fPv = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44);
    private String obY = "";
    private boolean obZ = false;
    private WriteData nbe = null;
    private boolean ocb = false;
    private InputMethodManager mInputManager = null;
    private EditText nbw = null;
    private View nbx = null;
    private LinearLayout nbz = null;
    private SpanGroupEditText oce = null;
    private FeedBackModel ocf = null;
    private ArrayList<WritePrefixItemLayout> och = new ArrayList<>();
    private final KeyEvent iEZ = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView lKM = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener iJO = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout kjG = null;
    private String fwy = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int fwz = 0;
    private View mRootView = null;
    private ScrollView ocu = null;
    private boolean ocv = false;
    private com.baidu.tbadk.core.view.a fEW = null;
    private String mFrom = "write";
    private String jzs = "2";
    private SpannableStringBuilder ocy = new SpannableStringBuilder();
    private boolean bqA = false;
    private final c ocA = new c();
    private boolean nZi = false;
    private TbFaceManager.a ocC = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan Eg(String str) {
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
    private final AntiHelper.a iUs = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ay.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ay.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d fwI = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.nbe != null) {
                TransmitPostEditActivity.this.ocA.bn(null);
                if (z) {
                    TransmitPostEditActivity.this.kE(z);
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
                    TransmitPostEditActivity.this.ocA.VA(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.ocA.bn(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.ocA.b(TransmitPostEditActivity.this.nbw, TransmitPostEditActivity.this.oce);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.d(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.d(TransmitPostEditActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(TransmitPostEditActivity.this.getActivity());
                    if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.Bq(TransmitPostEditActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.Bq(postWriteCallBackData.getErrorString());
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
                            TiebaStatic.log(new ar("c13746").al("obj_locate", 1).al("obj_type", 1));
                        }
                    });
                    aVar.b(TransmitPostEditActivity.this.getPageContext()).brv();
                    TiebaStatic.log(new ar("c13745").al("obj_locate", 1).al("obj_type", 1));
                } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bxM());
                    if (com.baidu.tbadk.t.a.ES(ahVar.bxL())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bxL())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a fwG = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bDm() {
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
    private final CustomMessageListener nox = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.fwt.yi(false);
                    TransmitPostEditActivity.this.fwt.gy(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.fwt.yi(true);
                TransmitPostEditActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener ocD = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener ocE = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int eav = TransmitPostEditActivity.this.eav();
            if (eav >= 0 && eav < TransmitPostEditActivity.this.oce.getText().length()) {
                TransmitPostEditActivity.this.oce.setSelection(eav);
            }
        }
    };
    private boolean ocF = true;
    private final View.OnFocusChangeListener hlF = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.nbw || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.lKM) {
                if (z) {
                    TransmitPostEditActivity.this.ocF = true;
                    TransmitPostEditActivity.this.eaw();
                    if (TransmitPostEditActivity.this.fuh != null) {
                        TransmitPostEditActivity.this.fuh.bAK();
                    }
                    com.baidu.adp.lib.util.l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.nbw);
                } else if (view == TransmitPostEditActivity.this.nbw) {
                    TransmitPostEditActivity.this.nbB.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.oce && z) {
                TransmitPostEditActivity.this.ocF = false;
                TransmitPostEditActivity.this.eaw();
                TransmitPostEditActivity.this.fuh.bAK();
                com.baidu.adp.lib.util.l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.oce);
            }
            TransmitPostEditActivity.this.eaB();
        }
    };
    private TextWatcher ocG = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String ocK = "";
        private String ocL;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.ocL = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.ocL != null ? this.ocL.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dLG();
            TransmitPostEditActivity.this.eaC();
            EditText eaO = TransmitPostEditActivity.this.eaO();
            if (editable != null && eaO != null && eaO.getText() != null) {
                if (this.ocK == null || !this.ocK.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.ocA != null) {
                        this.ocK = eaO.getText().toString();
                        TransmitPostEditActivity.this.ocA.b(eaO, true);
                        return;
                    }
                    return;
                }
                eaO.setSelection(eaO.getSelectionEnd());
            }
        }
    };
    private TextWatcher ocH = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String ocL;
        private String ocM = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.ocL = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.ocL != null ? this.ocL.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dLG();
            EditText eaN = TransmitPostEditActivity.this.eaN();
            if (editable != null && eaN != null && eaN.getText() != null) {
                int selectionEnd = eaN.getSelectionEnd();
                if (this.ocM == null || !this.ocM.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.ocA != null) {
                        this.ocM = eaN.getText().toString();
                        TransmitPostEditActivity.this.ocA.b(eaN, false);
                        return;
                    }
                    return;
                }
                eaN.setSelection(selectionEnd);
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
    public void bCV() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void bCX() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bCZ();
        } else if (this.fwt.dPZ()) {
            bCV();
        } else {
            this.fwt.yi(false);
            a(1, true, (String) null);
            this.fwt.dPX();
        }
    }

    private void bCZ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.oQ(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.a(1, true, (String) null);
                    TransmitPostEditActivity.this.fwt.dQb();
                } else {
                    TransmitPostEditActivity.this.fwG.bDm();
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
        aVar.brv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eav() {
        int selectionEnd = eaN().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) eaN().getText().getSpans(0, eaN().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = eaN().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = eaN().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaw() {
        if (this.fuh != null) {
            this.fuh.setBarLauncherEnabled(!this.ocF);
            this.fuh.setToolEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.ocv) {
            this.nbw.setVisibility(8);
            dLG();
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
        this.fwt = new LocationModel(getPageContext());
        this.fwt.a(this.fwG);
        registerListener(this.nox);
        registerListener(this.ocD);
        dcj();
        this.oce.requestFocus();
        dFO();
        eaV();
    }

    @SuppressLint({"ResourceAsColor"})
    private void dcj() {
        this.fuh = new EditorTools(getActivity());
        this.fuh.setBarMaxLauCount(4);
        this.fuh.setMoreButtonAtEnd(true);
        this.fuh.setBarLauncherType(1);
        this.fuh.ks(true);
        this.fuh.kt(true);
        this.fuh.setBackgroundColorId(R.color.CAM_X0207);
        eax();
        this.fuh.build();
        if (this.nZi) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        }
        if (this.occ != null) {
            this.occ.addView(this.fuh);
        }
        dbM();
        this.fuh.su();
        com.baidu.tbadk.editortools.h sg = this.fuh.sg(6);
        if (sg != null && !TextUtils.isEmpty(this.fwy)) {
            ((View) sg).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.fwy);
                }
            });
        }
        if (!this.ocv) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.fuh.bAK();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.nbe.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.nbe.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        if (!this.nZi) {
            eaz();
        }
    }

    private void eax() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.fuh.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        if (!this.nZi && this.ocj == null) {
            if (this.ocz == null) {
                this.ocz = new com.baidu.tieba.write.editor.b(getActivity(), this.jzs);
                this.ocz.dZb();
                this.ocz.setFrom("from_share_write");
                this.ocz.bS(this.nbe.getForumId(), this.mPrivateThread);
            }
            this.fuh.b(this.ocz);
        }
        this.fuh.bE(arrayList);
        com.baidu.tbadk.editortools.m sj = this.fuh.sj(5);
        if (sj != null) {
            sj.fuU = 1;
            if (this.nZi) {
                sj.kv(false);
            }
        }
    }

    private void dbM() {
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
                            TiebaStatic.log(new ar("c12608").al("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.eaM()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.eaM()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof u)) {
                            TransmitPostEditActivity.this.e((u) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.eaP();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.dLG();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.ocj == null) {
                            TransmitPostEditActivity.this.bDa();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.fwz) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (com.baidu.tbadk.core.util.ae.checkLocationForGoogle(pageActivity)) {
                                    TransmitPostEditActivity.this.bCX();
                                    return;
                                } else {
                                    com.baidu.tbadk.core.util.ae.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.bCV();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.fwt != null) {
                            TransmitPostEditActivity.this.fwt.yi(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        ar arVar = new ar("c10645");
                        if (TransmitPostEditActivity.this.nbe != null) {
                            str = TransmitPostEditActivity.this.nbe.getForumId();
                        } else {
                            str = "";
                        }
                        arVar.dY("fid", str);
                        TiebaStatic.log(arVar);
                        if (TransmitPostEditActivity.this.nbe == null || (videoInfo = TransmitPostEditActivity.this.nbe.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.fuh.bCr()) {
                                        TransmitPostEditActivity.this.fuh.bAK();
                                        TransmitPostEditActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.nbe.setVideoInfo(null);
                        TransmitPostEditActivity.this.dLG();
                        if (TransmitPostEditActivity.this.oce != null) {
                            TransmitPostEditActivity.this.oce.requestFocus();
                        }
                        TransmitPostEditActivity.this.fuh.bAK();
                        TransmitPostEditActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.oce);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.obZ = true;
                        TransmitPostEditActivity.this.zt(true);
                        if (TransmitPostEditActivity.this.eaO().isFocused()) {
                            TransmitPostEditActivity.this.obY = "from_title";
                        } else if (TransmitPostEditActivity.this.eaN().isFocused()) {
                            TransmitPostEditActivity.this.obY = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.ocd.setVisibility(0);
                        TransmitPostEditActivity.this.ocd.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.ocd.hasFocus()) {
                            TransmitPostEditActivity.this.oce.requestFocus();
                            TransmitPostEditActivity.this.oce.setSelection(TransmitPostEditActivity.this.oce.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.ocd.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.fuh.setActionListener(31, bVar);
        this.fuh.setActionListener(16, bVar);
        this.fuh.setActionListener(14, bVar);
        this.fuh.setActionListener(24, bVar);
        this.fuh.setActionListener(3, bVar);
        this.fuh.setActionListener(10, bVar);
        this.fuh.setActionListener(11, bVar);
        this.fuh.setActionListener(12, bVar);
        this.fuh.setActionListener(13, bVar);
        this.fuh.setActionListener(15, bVar);
        this.fuh.setActionListener(18, bVar);
        this.fuh.setActionListener(20, bVar);
        this.fuh.setActionListener(25, bVar);
        this.fuh.setActionListener(27, bVar);
        this.fuh.setActionListener(29, bVar);
        this.fuh.setActionListener(43, bVar);
        this.fuh.setActionListener(45, bVar);
        this.fuh.setActionListener(53, bVar);
        this.fuh.setActionListener(48, bVar);
        this.fuh.setActionListener(46, bVar);
        this.fuh.setActionListener(49, bVar);
        this.fuh.setActionListener(47, bVar);
        this.fuh.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDa() {
        if (this.fwt.clC()) {
            if (this.fwt.dPZ()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.b.dPU().getLocationData().getFormatted_address());
                return;
            }
            a(1, true, (String) null);
            this.fwt.dPX();
            return;
        }
        a(0, true, (String) null);
    }

    protected void dLy() {
        if (this.fwu != null) {
            this.fwu.cancelLoadData();
        }
        if (this.ocf != null) {
            this.ocf.cancelLoadData();
        }
        if (this.fwt != null) {
            this.fwt.cancelLoadData();
        }
    }

    private void eay() {
        if (this.ocB != null) {
            this.ocB.hideTip();
        }
    }

    private void eaz() {
        if (this.ocB == null) {
            this.ocB = new g(getPageContext());
        }
        this.ocB.d(this.fuh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        eay();
        TiebaPrepareImageService.StopService();
        dLy();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaA() {
        if (this.nbe == null) {
            finish();
            return;
        }
        this.nbe.setTitle(eaO().getText().toString());
        this.nbe.setContent(eaN().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.nbC != null && this.nbC.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.nbC, getPageContext().getPageActivity());
                return true;
            } else if (this.fuh.bCr()) {
                this.fuh.bAK();
                return true;
            } else {
                dLy();
                eaA();
                return true;
            }
        }
        if (i == 67 && (text = eaN().getText()) != null) {
            int selectionStart = eaN().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                eaN().onKeyDown(67, this.iEZ);
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
        getLayoutMode().onModeChanged(this.kjG);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.lKM, R.color.CAM_X0302, 1);
        eaw();
        ap.setBackgroundColor(this.nbx, R.color.CAM_X0204);
        ap.setBackgroundColor(eaO(), R.color.CAM_X0201);
        ap.setBackgroundColor(eaN(), R.color.CAM_X0201);
        dLG();
        this.fuh.onChangeSkinType(i);
        if (this.oct != null) {
            this.oct.bvt();
        }
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        eaB();
        eaC();
        if (this.ocA != null) {
            this.ocA.c(eaO(), eaN());
        }
        if (this.ajl != null) {
            this.ajl.onChangeSkinType();
        }
        if (this.nZE != null) {
            this.nZE.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaB() {
        if (this.nbw.hasFocus()) {
            this.nbw.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        } else {
            this.nbw.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        }
        if (this.oce.hasFocus()) {
            this.oce.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        } else {
            this.oce.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaC() {
        if (this.nbw != null) {
            if (this.nbw.getText().toString().length() == 0) {
                this.nbw.getPaint().setFakeBoldText(false);
            } else if (this.nbw.getText().toString().length() > 0) {
                this.nbw.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.fEW = new com.baidu.tbadk.core.view.a(getPageContext());
        this.ocv = this.nbe.getType() == 4 || 5 == this.nbe.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.btW().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        eaF();
        this.ocu = (ScrollView) findViewById(R.id.write_scrollview);
        this.ocu.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.oce != null) {
                        com.baidu.adp.lib.util.l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.oce);
                    }
                    if (TransmitPostEditActivity.this.fuh != null) {
                        TransmitPostEditActivity.this.fuh.bAK();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.kjG = (RelativeLayout) findViewById(R.id.parent);
        this.occ = (LinearLayout) findViewById(R.id.tool_view);
        this.occ.setContentDescription(IStringUtil.TOP_PATH);
        this.ocd = (LinearLayout) findViewById(R.id.title_view);
        this.nbx = findViewById(R.id.interval_view);
        this.ocx = (TextView) findViewById(R.id.hot_topic_title_edt);
        dLF();
        if (this.ocv) {
            this.ocu.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        dLH();
        eaL();
        this.nbz = (LinearLayout) findViewById(R.id.post_content_container);
        this.nbz.setDrawingCacheEnabled(false);
        this.nbz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.oce.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.hlF);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.dLy();
                TransmitPostEditActivity.this.eaA();
            }
        });
        eaI();
        eaK();
        eaE();
        eaw();
        eaJ();
        dLE();
        eaQ();
        eaD();
        if (this.nbe.getType() == 4 && this.nbE != null && this.ocg != null) {
            this.nbE.setVisibility(8);
            this.ocg.setVisibility(8);
        }
        dLG();
        ShowSoftKeyPad(this.mInputManager, this.nbw);
    }

    private void eaD() {
        this.nZE = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.nZE.setBgColor(R.color.CAM_X0205);
        this.nZE.setData(this.nVl);
        this.nZE.setActivity(this);
    }

    private void eaE() {
        String str;
        String str2;
        if (this.nbe != null) {
            switch (this.nbe.getType()) {
                case 0:
                case 9:
                    if (this.jzs != null && this.jzs.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                        if (this.nZi) {
                            this.mName.setText(R.string.transmit_to_dynamic_title);
                        }
                    } else if (this.jzs != null && this.jzs.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.nbe.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.nbw.setVisibility(0);
                    this.oce.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.oce.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.oce.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.nbw.setVisibility(8);
                    return;
            }
        }
    }

    private void eaF() {
        if (this.nZi) {
            this.lKM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.dynamic_publish));
        } else {
            this.lKM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lKM.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.lKM.setLayoutParams(layoutParams);
        this.lKM.setOnFocusChangeListener(this.hlF);
    }

    private void eaG() {
        if (this.nbe != null && this.nbe.getType() == 0 && this.nbe.getType() == 9 && !this.ocb && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = au.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && eaO() != null) {
                eaO().setText(cutStringWithSuffix);
                eaO().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void eaH() {
        this.gDf = null;
        this.ocp = -1;
        this.ocs = -1;
        ag Ah = af.cEi().Ah(1);
        if (Ah != null) {
            this.gDf = Ah.iXx;
            this.ocp = getIntent().getIntExtra("category_id", -1);
            if (this.gDf != null && !this.gDf.isEmpty() && this.ocp >= 0) {
                this.oco = new ae();
                this.oco.iXt = 0;
                this.oco.name = getPageContext().getResources().getString(R.string.category_auto);
                this.ocs = this.oco.iXt;
                this.ocq = this.oco.name;
                for (ae aeVar : this.gDf) {
                    if (aeVar.iXt == this.ocp) {
                        this.ocs = aeVar.iXt;
                        this.ocq = aeVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void eaI() {
        if (this.gDf != null && !this.gDf.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.oct = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.oct.setText(this.ocq);
            this.oct.setCategoryContainerData(this.gDf, this.oco, this.ocs);
            this.oct.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bf bfVar) {
                    if (bfVar != null) {
                        TransmitPostEditActivity.this.oct.setText(bfVar.name);
                        TransmitPostEditActivity.this.nbe.setCategoryTo(bfVar.iXt);
                        TransmitPostEditActivity.this.ocs = bfVar.iXt;
                        TransmitPostEditActivity.this.oct.dZX();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.oct.dZW();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.eaO());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.eaN());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.ocI = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.ocI.setTitle(R.string.no_disturb_start_time);
        this.ocI.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.ocI);
        this.ocI.setButton(-2, getPageContext().getString(R.string.cancel), this.ocI);
        return this.ocI;
    }

    private void eaJ() {
        this.ock = (RelativeLayout) findViewById(R.id.addition_container);
        this.ocl = (TextView) findViewById(R.id.addition_create_time);
        this.ocm = (TextView) findViewById(R.id.addition_last_time);
        this.ocn = (TextView) findViewById(R.id.addition_last_content);
        if (this.ocj != null) {
            this.ock.setVisibility(0);
            this.ocl.setText(getPageContext().getString(R.string.write_addition_create) + au.getFormatTime(this.ocj.getCreateTime() * 1000));
            if (this.ocj.getAlreadyCount() == 0) {
                this.ocm.setVisibility(8);
            } else {
                this.ocm.setText(getPageContext().getString(R.string.write_addition_last) + au.getFormatTime(this.ocj.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.ocj.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.ocn.setText(lastAdditionContent);
            } else {
                this.ocn.setVisibility(8);
            }
            eaN().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.ocj.getAlreadyCount()), Integer.valueOf(this.ocj.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.ock.setVisibility(8);
    }

    private void dLE() {
        this.nbE = findViewById(R.id.post_prefix_layout);
        this.nbB = (TextView) findViewById(R.id.post_prefix);
        this.ocg = findViewById(R.id.prefix_divider);
        this.nbD = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.nbE.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.nbf = 1;
            this.nbE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.nbB.setVisibility(0);
                    TransmitPostEditActivity.this.nbE.setSelected(true);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.nbC, view, 0, com.baidu.adp.lib.util.l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.fuh.bAK();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.nbw);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.oce);
                }
            });
            this.nbD = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.nbD.setVisibility(0);
                this.nbB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.nbB.setSelected(true);
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.nbC, view, 0, com.baidu.adp.lib.util.l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.fuh.bAK();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.eaO());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.eaN());
                    }
                });
            }
            this.nbC = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.nbC.a(this);
            this.nbC.setMaxHeight(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds510));
            this.nbC.setOutsideTouchable(true);
            this.nbC.setFocusable(true);
            this.nbC.setOnDismissListener(this);
            this.nbC.setBackgroundDrawable(ap.getDrawable(R.color.CAM_X0201));
            int color = ap.getColor(R.color.CAM_X0105);
            int color2 = ap.getColor(R.color.CAM_X0108);
            ap.setBackgroundResource(this.nbB, R.color.CAM_X0201);
            ap.setImageResource(this.nbD, R.drawable.icon_frs_arrow_n);
            this.nbB.setTextColor(color);
            this.och.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.och.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.nbC.addView(writePrefixItemLayout);
            }
            this.nbC.setCurrentIndex(0);
            this.nbB.setText(prefixs.get(1));
            Na(1);
            return;
        }
        this.nbE.setVisibility(8);
    }

    protected void eaK() {
        this.lKM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick() && !TransmitPostEditActivity.this.eaW()) {
                    if (TransmitPostEditActivity.this.ocA.a(TransmitPostEditActivity.this.nbw, TransmitPostEditActivity.this.oce)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.ocA.dYr());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.eaO());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.eaN());
                    TransmitPostEditActivity.this.fuh.bAK();
                    TiebaStatic.log(new ar("c12608").al("obj_locate", 7));
                    TransmitPostEditActivity.this.eaT();
                }
            }
        });
    }

    protected void dLF() {
        this.nbw = (EditText) findViewById(R.id.post_title);
        this.nbw.setOnClickListener(this.ocE);
        this.nbw.setOnFocusChangeListener(this.hlF);
        if ((this.nbe.getType() == 0 || this.nbe.getType() == 9 || this.nbe.getType() == 7) && this.nbe.getTitle() != null) {
            this.nbw.setText(this.nbe.getTitle());
            this.nbw.setSelection(this.nbe.getTitle().length());
        }
        this.nbw.addTextChangedListener(this.ocG);
        if (!this.nbe.getHaveDraft()) {
            eaG();
        }
        this.nbw.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void dLH() {
        this.oce = (SpanGroupEditText) findViewById(R.id.post_content);
        this.oce.setDrawingCacheEnabled(false);
        this.oce.setOnClickListener(this.ocE);
        this.oce.setTransLink(!this.nZi);
        if (this.fwu != null) {
            this.fwu.setSpanGroupManager(this.oce.getSpanGroupManager());
        }
        if (this.nbe != null) {
            this.nbe.setSpanGroupManager(this.oce.getSpanGroupManager());
        }
        if (this.nbe.getContent() != null && this.nbe.getContent().length() > 0) {
            this.oce.setText(TbFaceManager.bDU().aw(getPageContext().getPageActivity(), this.nbe.getContent()));
            this.oce.setSelection(this.oce.getText().length());
        }
        if (!au.isEmpty(this.iQN)) {
            this.oce.setSelection(0);
        }
        this.oce.setOnFocusChangeListener(this.hlF);
        this.oce.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.fuh.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.oce.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.oce.addTextChangedListener(this.ocH);
        if (this.nZi) {
            this.oce.setHint(R.string.dynamic_transmit_publish_edit_str);
        } else if (this.oca != null && this.oca.showType == 3) {
            this.oce.setHint(R.string.share_video_default);
        } else {
            this.oce.setHint(R.string.share_txt_default);
        }
    }

    private void eaL() {
        this.ajl = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajl.getLayoutParams();
        layoutParams.topMargin -= obX;
        layoutParams.leftMargin = fPv;
        layoutParams.rightMargin = fPv;
        this.ajl.setLayoutParams(layoutParams);
        this.ajl.setVisibility(0);
        this.ajl.a(this.oca);
        this.ajl.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eaM() {
        int i = 5000;
        if (this.ocj != null) {
            i = 1000;
        }
        return eaN().getText() != null && eaN().getText().length() >= i;
    }

    private void DQ(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.obY)) {
                this.obY = "";
                eaN().requestFocus();
                if (eaN().getText() != null && eaN().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = eaN().getSelectionStart();
                    editable = eaN().getText();
                }
            } else if ("from_title".equals(this.obY)) {
                this.obY = "";
                eaO().requestFocus();
                if (eaO().getText() != null && eaO().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = eaO().getSelectionStart();
                    editable = eaO().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zt(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.nbe != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.nbe.getForumId(), 0L), this.nbe.getFirstDir(), this.nbe.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(u uVar) {
        if (((ImageSpan[]) eaN().getText().getSpans(0, eaN().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.oci == null) {
                this.oci = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.oci.getView().isShown()) {
                this.oci.cancel();
            }
            this.oci.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, uVar, eaN());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText eaN() {
        return this.oce;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText eaO() {
        return this.nbw;
    }

    protected void eaP() {
        if (eaN().getSelectionStart() > 0) {
            String substring = eaN().getText().toString().substring(0, eaN().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.iEY.matcher(substring);
            if (matcher.find()) {
                eaN().getText().delete(eaN().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), eaN().getSelectionStart());
                return;
            }
            eaN().onKeyDown(67, this.iEZ);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.fEW.setCancelListener(null);
        this.fEW.setTipString(R.string.sending);
        this.fEW.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.fEW.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLG() {
        if (this.nbe != null) {
            String str = "";
            String str2 = "";
            if (eaO() != null) {
                str = eaO().getText().toString();
            }
            if (eaN() != null) {
                str2 = eaN().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.nbe.getType() == 0 || this.nbe.getType() == 9 || this.nbe.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.nbf == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.nbe.setIsNoTitle(true);
                        } else {
                            this.nbe.setIsNoTitle(false);
                            zu(true);
                            return;
                        }
                    } else {
                        this.nbe.setIsNoTitle(false);
                        zu(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.nbe.setIsNoTitle(true);
                } else {
                    this.nbe.setIsNoTitle(false);
                    zu(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.ocv) {
                    zu(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    zu(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                zu(true);
            } else if (this.nbe.getVideoInfo() != null) {
                zu(true);
            } else {
                zu(false);
            }
        }
    }

    private void zu(boolean z) {
        ap.setNavbarTitleColor(this.lKM, R.color.CAM_X0302, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.fwu = new NewWriteModel(this);
        this.fwu.b(this.fwI);
        this.iJO = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.dLy();
            }
        };
        this.nbe = new WriteData();
        if (bundle != null) {
            this.nbe.setType(bundle.getInt("type", 0));
            this.nbe.setForumId(bundle.getString("forum_id"));
            this.nbe.setForumName(bundle.getString("forum_name"));
            this.nbe.setFirstDir(bundle.getString("forum_first_dir"));
            this.nbe.setSecondDir(bundle.getString("forum_second_dir"));
            this.nbe.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.ocj = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.nbe.setIsAddition(this.ocj != null);
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
            this.nbe.setTitle(bundle.getString("write_title"));
            this.nbe.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.jzs = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.oca = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.ShareInfo.class);
            }
            this.mBaijiahaoData = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.iQN = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.iQO = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.nVl = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.nbe.mDynamicForwardData = (ForwardUploadData) bundle.getSerializable(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA);
            str = string;
        } else {
            Intent intent = getIntent();
            this.nbe.setType(intent.getIntExtra("type", 0));
            this.nbe.setForumId(intent.getStringExtra("forum_id"));
            this.nbe.setForumName(intent.getStringExtra("forum_name"));
            this.nbe.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.nbe.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.nbe.setThreadId(intent.getStringExtra("thread_id"));
            this.ocj = (AdditionData) intent.getSerializableExtra("addition_data");
            this.nbe.setIsAddition(this.ocj != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.nbe.setTitle(intent.getStringExtra("write_title"));
            this.nbe.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.jzs = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.oca = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            this.nbe.mDynamicForwardData = (ForwardUploadData) intent.getSerializableExtra(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA);
            this.iQN = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.iQO = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.nVl = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (this.nbe.mDynamicForwardData != null) {
            this.nZi = true;
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.nbe.getType() == 4 ? 6 : 9);
        this.nbe.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.oca != null && this.oca.videoId != null) {
            this.nbe.setVideoId(this.oca.videoId);
            this.nbe.setOriginalVideoCover(this.oca.showPicUrl);
            this.nbe.setOriginalVideoTitle(this.oca.showText);
        }
        if (!au.isEmpty(this.iQN)) {
            if (!au.isEmpty(this.iQO)) {
                this.nbe.setContent("//@" + this.iQO + " :" + this.iQN);
            } else {
                this.nbe.setContent(this.iQN);
            }
        }
        if (this.nbe != null && this.nbe.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.nbe.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.ocb = true;
        }
        eaH();
    }

    private void eaQ() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) y.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.nbw.setText(com.baidu.tbadk.plugins.b.Ey(com.baidu.tbadk.plugins.b.Ez(hotTopicBussinessData.mTopicName)));
            this.nbw.setMovementMethod(com.baidu.tieba.view.c.dXS());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString Ey = com.baidu.tbadk.plugins.b.Ey(com.baidu.tbadk.plugins.b.Ez(hotTopicBussinessData.mTopicName));
            if (Ey != null) {
                this.nbw.setText(Ey);
            }
            this.ocx.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.nbe.getType());
        bundle.putString("forum_id", this.nbe.getForumId());
        bundle.putString("forum_name", this.nbe.getForumName());
        bundle.putString("forum_first_dir", this.nbe.getFirstDir());
        bundle.putString("forum_second_dir", this.nbe.getSecondDir());
        bundle.putString("thread_id", this.nbe.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jzs);
        bundle.putSerializable("tab_list", this.nVl);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.ocj != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.ocj));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jzs);
        if (this.nbe.mDynamicForwardData != null) {
            bundle.putSerializable(TransmitPostEditActivityConfig.PUBLISH_FORWARD_UPLOAD_DATA, this.nbe.mDynamicForwardData);
        }
        if (this.oca != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.oca));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = eaN().getEditableText().toString();
        if (obj != null) {
            eaN().setText(TbFaceManager.bDU().a(getPageContext().getPageActivity(), obj, this.ocC));
            eaN().setSelection(eaN().getText().length());
        }
    }

    private String eaR() {
        if (eaN() == null || eaN().getText() == null) {
            return "";
        }
        String obj = eaN().getText().toString();
        if (StringUtils.isNull(obj)) {
            if (this.oca != null && this.oca.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return obj;
    }

    private String eaS() {
        if (this.nbe == null || eaO() == null || eaO().getVisibility() != 0 || eaO().getText() == null) {
            return "";
        }
        String obj = eaO().getText().toString();
        if (this.mPrefixData != null && y.getCount(this.mPrefixData.getPrefixs()) > 0 && this.nbf != 0 && this.nbe.getType() != 4 && this.nbB != null && this.nbB.getText() != null) {
            obj = this.nbB.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            obj = this.mPrefixData.getImplicitTitle() + this.nbe.getTitle();
        }
        if (TextUtils.isEmpty(obj)) {
            if (TextUtils.isEmpty(this.nbe.getContent())) {
                return getString(R.string.share_txt_default);
            }
            if (getString(R.string.share_txt_default).equals(this.nbe.getContent())) {
                return getString(R.string.share_txt_default);
            }
            if (getString(R.string.share_video_default).equals(this.nbe.getContent())) {
                return getString(R.string.share_video_default);
            }
            return obj;
        }
        return obj;
    }

    private void cGw() {
        if (this.nbe != null && this.nbe.mDynamicForwardData != null) {
            dZE();
            return;
        }
        dLy();
        this.nbe.setContent(eaR());
        this.nbe.setTitle(eaS());
        if (this.ocp >= 0) {
            this.nbe.setCategoryFrom(this.ocp);
        }
        if (this.ocs >= 0) {
            this.nbe.setCategoryTo(this.ocs);
        }
        this.nbe.setWriteImagesInfo(this.writeImagesInfo);
        this.nbe.setHasLocationData(this.fwt != null && this.fwt.clC());
        this.fwu.yk(this.writeImagesInfo.size() > 0);
        if (!y.isEmpty(this.mList) && this.ocw != null && this.ocw.mIsGlobalBlock == 0) {
            this.nbe.setForumId(String.valueOf(this.ocw.mForumId));
            this.nbe.setForumName(this.ocw.mForumName);
        }
        dZF();
        this.fwu.e(this.nbe);
        this.nbe.setContent(this.nbe.getContent().replaceAll("\u0000\n", ""));
        this.nbe.setContent(this.nbe.getContent().replaceAll("\u0000", ""));
        this.nbe.setVcode(null);
        this.fwu.dcE().setVoice(null);
        this.fwu.dcE().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.iJO);
        this.fwu.dQE();
    }

    private void dZF() {
        FrsTabItemData selectedTabItemData;
        if (this.nbe != null && this.nZE != null && (selectedTabItemData = this.nZE.getSelectedTabItemData()) != null) {
            this.nbe.setTabId(selectedTabItemData.tabId);
            this.nbe.setTabName(selectedTabItemData.name);
            this.nbe.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    private void dZE() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        this.nbe.mDynamicForwardData.forward_content = eaR();
        this.nbe.mDynamicForwardData.inputText = eaR();
        this.nbe.mDynamicForwardData.locationPoiId = "0";
        showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
        com.baidu.tieba.write.b.c.b.dZn().a(this.nbe.mDynamicForwardData, new b.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // com.baidu.tieba.write.b.c.b.a
            public void onSuccess(String str) {
                TransmitPostEditActivity.this.closeLoadingDialog();
                com.baidu.tieba.tbadkCore.writeModel.c.h(TransmitPostEditActivity.this.getPageContext().getPageActivity(), null, null, null);
                TransmitPostEditActivity.this.kE(true);
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
            if (this.ocj != null) {
                i2 = this.ocj.getTotalCount();
                i = this.ocj.getAlreadyCount() + 1;
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
                if (this.fuh != null && !this.fuh.bCr()) {
                    eaN().requestFocus();
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
                            eaN().getText().insert(eaN().getSelectionStart(), sb.toString());
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
                        if (this.obZ) {
                            sb2.append(com.baidu.tbadk.plugins.b.fEp);
                            this.obZ = false;
                        }
                        sb2.append(stringExtra);
                        DQ(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !y.isEmpty(this.mList) && !y.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.ocw = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.ocw);
            }
        } else if (i2 == 0) {
            if (this.fuh != null && !this.fuh.bCr()) {
                this.oce.requestFocus();
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
                        this.ocA.VA(postWriteCallBackData.getErrorString());
                        this.ocA.bn(postWriteCallBackData.getSensitiveWords());
                        this.ocA.b(this.nbw, this.oce);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.obY)) {
                        eaO().requestFocus();
                        return;
                    } else if ("from_content".equals(this.obY)) {
                        eaN().requestFocus();
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
    public void eaT() {
        if ("1".equals(this.jzs)) {
            this.nbe.setCanNoForum(true);
            this.nbe.setTransmitForumData("[]");
        } else if ("2".equals(this.jzs)) {
            this.nbe.setCanNoForum(false);
        }
        eaU();
        this.nbe.setPrivacy(this.isPrivacy);
        this.nbe.setIsShareThread(true);
        if (this.oca != null && !StringUtils.isNull(this.oca.threadId)) {
            this.nbe.setOriginalThreadId(this.oca.threadId);
        }
        this.nbe.setBaijiahaoData(this.mBaijiahaoData);
        if (this.oca != null) {
            this.nbe.setOriBaijiahaoData(this.oca.oriUgcInfo);
        }
        this.nbe.setCallFrom(this.jzs);
        cGw();
    }

    private void eaU() {
        if (this.fuh != null) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, eaO());
        HidenSoftKeyPad(this.mInputManager, eaN());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bP(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.iUs) != null) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ay.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.nbe.getType() != 7) {
                if (this.ocj == null) {
                    if (!d(postWriteCallBackData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.h(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
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
        this.fwz = i;
        if (this.fuh != null) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void eaV() {
        if (!this.ocv && this.fuh != null) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.fuh.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kE(boolean z) {
        if (this.fuh != null) {
            this.fuh.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Na(int i) {
        if (i < this.och.size()) {
            for (int i2 = 0; i2 < this.och.size(); i2++) {
                this.och.get(i2).zg(false);
            }
            this.och.get(i).zg(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void KA(int i) {
        this.nbf = i;
        this.nbC.setCurrentIndex(i);
        Na(i);
        this.nbB.setText(this.mPrefixData.getPrefixs().get(i));
        dLG();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.nbC, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.nbE.setSelected(false);
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
        if (this.nbe != null) {
            if (this.nbe.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.nbe.getType() == 5) {
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
            bCX();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.bqA = z;
        if (this.ocz != null && !z) {
            this.ocz.cwe();
        }
        if (this.ocB != null && !z) {
            eay();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.bqA && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.obZ = false;
            this.obY = "";
            if ("from_content".equals(str)) {
                this.obY = "from_content";
            } else if ("from_title".equals(str)) {
                this.obY = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.Ex(String.valueOf(charSequence.charAt(i)))) {
                zt(false);
            }
        }
    }

    public void dFO() {
        if (!y.isEmpty(this.mList)) {
            this.ocd.setVisibility(0);
            this.ocd.requestFocus();
            return;
        }
        this.ocd.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eaW() {
        if (((ImageSpan[]) eaN().getText().getSpans(0, eaN().getText().length(), ImageSpan.class)).length > 10) {
            if (this.oci == null) {
                this.oci = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.oci.getView().isShown()) {
                this.oci.cancel();
            }
            this.oci.show();
            return true;
        }
        return false;
    }
}
