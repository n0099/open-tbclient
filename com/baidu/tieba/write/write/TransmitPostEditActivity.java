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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.n.a.a;
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
/* loaded from: classes8.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0277a, i.a {
    private OriginalThreadCardView ajX;
    private EditorTools fDN;
    private LocationModel fFZ;
    private NewWriteModel fGa;
    List<ab> gOR;
    private boolean isPrivacy;
    private String jcZ;
    private String jda;
    private BaijiahaoData mBaijiahaoData;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private FrsTabInfoData nYG;
    private int ngJ;
    private TextView nhf;
    private com.baidu.tieba.write.i nhg;
    private ImageView nhh;
    private View nhi;
    private int oeA;
    private String oeB;
    private int oeC;
    private PostCategoryView oeD;
    private HotTopicBussinessData oeG;
    private TextView oeH;
    private com.baidu.tieba.write.editor.b oeJ;
    private g oeL;
    private ForumTabSelectedView oeM;
    private com.baidu.tieba.view.b oeT;
    private OriginalThreadInfo.ShareInfo oel;
    private LinearLayout oen;
    private LinearLayout oeo;
    private View oer;
    private Toast oet;
    private AdditionData oeu;
    private RelativeLayout oev;
    private TextView oew;
    private TextView oex;
    private TextView oey;
    ab oez;
    private static final int oei = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    private static final int fYY = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44);
    private String oej = "";
    private boolean oek = false;
    private WriteData ngI = null;
    private boolean oem = false;
    private InputMethodManager mInputManager = null;
    private EditText nha = null;
    private View nhb = null;
    private LinearLayout nhd = null;
    private SpanGroupEditText oep = null;
    private FeedBackModel oeq = null;
    private ArrayList<WritePrefixItemLayout> oes = new ArrayList<>();
    private final KeyEvent iRl = new KeyEvent(0, 67);
    private View mBack = null;
    private TextView lPZ = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener iVZ = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout ltF = null;
    private String fGe = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int fGf = 0;
    private View mRootView = null;
    private ScrollView oeE = null;
    private boolean oeF = false;
    private com.baidu.tbadk.core.view.a fOA = null;
    private String mFrom = "write";
    private String jLR = "2";
    private SpannableStringBuilder oeI = new SpannableStringBuilder();
    private boolean bsq = false;
    private final c oeK = new c();
    private TbFaceManager.a oeN = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan Ed(String str) {
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
    private final AntiHelper.a jgD = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", ax.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", ax.a.LOCATE_WRITE));
        }
    };
    private final NewWriteModel.d fGo = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.ngI != null) {
                TransmitPostEditActivity.this.oeK.bm(null);
                if (z) {
                    TransmitPostEditActivity.this.la(z);
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
                    TransmitPostEditActivity.this.oeK.Vf(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.oeK.bm(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.oeK.b(TransmitPostEditActivity.this.nha, TransmitPostEditActivity.this.oep);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.d(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.d(TransmitPostEditActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(TransmitPostEditActivity.this.getActivity());
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.Bp(TransmitPostEditActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.Bp(postWriteCallBackData.getErrorString());
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
                    aVar.b(TransmitPostEditActivity.this.getPageContext()).btX();
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
                    writeData.setVcodeExtra(ahVar.bAg());
                    if (com.baidu.tbadk.t.a.EQ(ahVar.bAf())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bAf())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a fGm = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bFH() {
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
    private final CustomMessageListener nug = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.fFZ.yn(false);
                    TransmitPostEditActivity.this.fFZ.gv(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.fFZ.yn(true);
                TransmitPostEditActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener oeO = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener oeP = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dZE = TransmitPostEditActivity.this.dZE();
            if (dZE >= 0 && dZE < TransmitPostEditActivity.this.oep.getText().length()) {
                TransmitPostEditActivity.this.oep.setSelection(dZE);
            }
        }
    };
    private boolean oeQ = true;
    private final View.OnFocusChangeListener hxA = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.nha || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.lPZ) {
                if (z) {
                    TransmitPostEditActivity.this.oeQ = true;
                    TransmitPostEditActivity.this.dZF();
                    if (TransmitPostEditActivity.this.fDN != null) {
                        TransmitPostEditActivity.this.fDN.bDe();
                    }
                    l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.nha);
                } else if (view == TransmitPostEditActivity.this.nha) {
                    TransmitPostEditActivity.this.nhf.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.oep && z) {
                TransmitPostEditActivity.this.oeQ = false;
                TransmitPostEditActivity.this.dZF();
                TransmitPostEditActivity.this.fDN.bDe();
                l.showSoftKeyPad(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.oep);
            }
            TransmitPostEditActivity.this.dZK();
        }
    };
    private TextWatcher oeR = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String oeV = "";
        private String oeW;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.oeW = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.oeW != null ? this.oeW.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dLx();
            TransmitPostEditActivity.this.dZL();
            EditText dZX = TransmitPostEditActivity.this.dZX();
            if (editable != null && dZX != null && dZX.getText() != null) {
                if (this.oeV == null || !this.oeV.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.oeK != null) {
                        this.oeV = dZX.getText().toString();
                        TransmitPostEditActivity.this.oeK.b(dZX, true);
                        return;
                    }
                    return;
                }
                dZX.setSelection(dZX.getSelectionEnd());
            }
        }
    };
    private TextWatcher oeS = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String oeW;
        private String oeX = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.oeW = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.oeW != null ? this.oeW.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.dLx();
            EditText dZW = TransmitPostEditActivity.this.dZW();
            if (editable != null && dZW != null && dZW.getText() != null) {
                int selectionEnd = dZW.getSelectionEnd();
                if (this.oeX == null || !this.oeX.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.oeK != null) {
                        this.oeX = dZW.getText().toString();
                        TransmitPostEditActivity.this.oeK.b(dZW, false);
                        return;
                    }
                    return;
                }
                dZW.setSelection(selectionEnd);
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
    public void bFq() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void bFs() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bFu();
        } else if (this.fFZ.dPV()) {
            bFq();
        } else {
            this.fFZ.yn(false);
            a(1, true, (String) null);
            this.fFZ.dPT();
        }
    }

    private void bFu() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.pa(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.a(1, true, (String) null);
                    TransmitPostEditActivity.this.fFZ.dPX();
                } else {
                    TransmitPostEditActivity.this.fGm.bFH();
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
        aVar.btX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dZE() {
        int selectionEnd = dZW().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dZW().getText().getSpans(0, dZW().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dZW().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dZW().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZF() {
        if (this.fDN != null) {
            this.fDN.setBarLauncherEnabled(!this.oeQ);
            this.fDN.setToolEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.oeF) {
            this.nha.setVisibility(8);
            dLx();
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
        this.fFZ = new LocationModel(getPageContext());
        this.fFZ.a(this.fGm);
        registerListener(this.nug);
        registerListener(this.oeO);
        dbQ();
        this.oep.requestFocus();
        dFD();
        eaf();
    }

    @SuppressLint({"ResourceAsColor"})
    private void dbQ() {
        this.fDN = new EditorTools(getActivity());
        this.fDN.setBarMaxLauCount(4);
        this.fDN.setMoreButtonAtEnd(true);
        this.fDN.setBarLauncherType(1);
        this.fDN.kO(true);
        this.fDN.kP(true);
        this.fDN.setBackgroundColorId(R.color.CAM_X0207);
        dZG();
        this.fDN.build();
        if (this.oen != null) {
            this.oen.addView(this.fDN);
        }
        dbq();
        this.fDN.rV();
        com.baidu.tbadk.editortools.h ss = this.fDN.ss(6);
        if (ss != null && !TextUtils.isEmpty(this.fGe)) {
            ((View) ss).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.fGe);
                }
            });
        }
        if (!this.oeF) {
            this.fDN.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.fDN.bDe();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.fDN.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.fDN.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.ngI.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.ngI.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
        dZI();
    }

    private void dZG() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.fDN.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 2));
        if (this.oeu == null) {
            if (this.oeJ == null) {
                this.oeJ = new com.baidu.tieba.write.editor.b(getActivity(), this.jLR);
                this.oeJ.dYI();
                this.oeJ.setFrom("from_share_write");
                this.oeJ.bZ(this.ngI.getForumId(), this.mPrivateThread);
            }
            this.fDN.b(this.oeJ);
        }
        this.fDN.bL(arrayList);
        m sv = this.fDN.sv(5);
        if (sv != null) {
            sv.fEA = 1;
        }
    }

    private void dbq() {
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
                        if (TransmitPostEditActivity.this.dZV()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.dZV()) {
                            TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof u)) {
                            TransmitPostEditActivity.this.e((u) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.dZY();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.dLx();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.oeu == null) {
                            TransmitPostEditActivity.this.bFv();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.fGf) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ad.checkLocationForGoogle(pageActivity)) {
                                    TransmitPostEditActivity.this.bFs();
                                    return;
                                } else {
                                    ad.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.bFq();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.fFZ != null) {
                            TransmitPostEditActivity.this.fFZ.yn(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        aq aqVar = new aq("c10645");
                        if (TransmitPostEditActivity.this.ngI != null) {
                            str = TransmitPostEditActivity.this.ngI.getForumId();
                        } else {
                            str = "";
                        }
                        aqVar.dX("fid", str);
                        TiebaStatic.log(aqVar);
                        if (TransmitPostEditActivity.this.ngI == null || (videoInfo = TransmitPostEditActivity.this.ngI.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.fDN.bEM()) {
                                        TransmitPostEditActivity.this.fDN.bDe();
                                        TransmitPostEditActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.ngI.setVideoInfo(null);
                        TransmitPostEditActivity.this.dLx();
                        if (TransmitPostEditActivity.this.oep != null) {
                            TransmitPostEditActivity.this.oep.requestFocus();
                        }
                        TransmitPostEditActivity.this.fDN.bDe();
                        TransmitPostEditActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.oep);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        TransmitPostEditActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.oek = true;
                        TransmitPostEditActivity.this.zq(true);
                        if (TransmitPostEditActivity.this.dZX().isFocused()) {
                            TransmitPostEditActivity.this.oej = "from_title";
                        } else if (TransmitPostEditActivity.this.dZW().isFocused()) {
                            TransmitPostEditActivity.this.oej = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.oeo.setVisibility(0);
                        TransmitPostEditActivity.this.oeo.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.oeo.hasFocus()) {
                            TransmitPostEditActivity.this.oep.requestFocus();
                            TransmitPostEditActivity.this.oep.setSelection(TransmitPostEditActivity.this.oep.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.oeo.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.fDN.setActionListener(31, bVar);
        this.fDN.setActionListener(16, bVar);
        this.fDN.setActionListener(14, bVar);
        this.fDN.setActionListener(24, bVar);
        this.fDN.setActionListener(3, bVar);
        this.fDN.setActionListener(10, bVar);
        this.fDN.setActionListener(11, bVar);
        this.fDN.setActionListener(12, bVar);
        this.fDN.setActionListener(13, bVar);
        this.fDN.setActionListener(15, bVar);
        this.fDN.setActionListener(18, bVar);
        this.fDN.setActionListener(20, bVar);
        this.fDN.setActionListener(25, bVar);
        this.fDN.setActionListener(27, bVar);
        this.fDN.setActionListener(29, bVar);
        this.fDN.setActionListener(43, bVar);
        this.fDN.setActionListener(45, bVar);
        this.fDN.setActionListener(53, bVar);
        this.fDN.setActionListener(48, bVar);
        this.fDN.setActionListener(46, bVar);
        this.fDN.setActionListener(49, bVar);
        this.fDN.setActionListener(47, bVar);
        this.fDN.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFv() {
        if (this.fFZ.cot()) {
            if (this.fFZ.dPV()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.b.dPQ().getLocationData().getFormatted_address());
                return;
            }
            a(1, true, (String) null);
            this.fFZ.dPT();
            return;
        }
        a(0, true, (String) null);
    }

    protected void dLp() {
        if (this.fGa != null) {
            this.fGa.cancelLoadData();
        }
        if (this.oeq != null) {
            this.oeq.cancelLoadData();
        }
        if (this.fFZ != null) {
            this.fFZ.cancelLoadData();
        }
    }

    private void dZH() {
        if (this.oeL != null) {
            this.oeL.hideTip();
        }
    }

    private void dZI() {
        if (this.oeL == null) {
            this.oeL = new g(getPageContext());
        }
        this.oeL.d(this.fDN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dZH();
        TiebaPrepareImageService.StopService();
        dLp();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZJ() {
        if (this.ngI == null) {
            finish();
            return;
        }
        this.ngI.setTitle(dZX().getText().toString());
        this.ngI.setContent(dZW().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.nhg != null && this.nhg.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.nhg, getPageContext().getPageActivity());
                return true;
            } else if (this.fDN.bEM()) {
                this.fDN.bDe();
                return true;
            } else {
                dLp();
                dZJ();
                return true;
            }
        }
        if (i == 67 && (text = dZW().getText()) != null) {
            int selectionStart = dZW().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dZW().onKeyDown(67, this.iRl);
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
        getLayoutMode().onModeChanged(this.ltF);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ao.setViewTextColor(this.lPZ, R.color.CAM_X0302, 1);
        dZF();
        ao.setBackgroundColor(this.nhb, R.color.CAM_X0204);
        ao.setBackgroundColor(dZX(), R.color.CAM_X0201);
        ao.setBackgroundColor(dZW(), R.color.CAM_X0201);
        dLx();
        this.fDN.onChangeSkinType(i);
        if (this.oeD != null) {
            this.oeD.bxO();
        }
        ao.setViewTextColor(this.mName, R.color.CAM_X0105);
        dZK();
        dZL();
        if (this.oeK != null) {
            this.oeK.c(dZX(), dZW());
        }
        if (this.ajX != null) {
            this.ajX.onChangeSkinType();
        }
        if (this.oeM != null) {
            this.oeM.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZK() {
        if (this.nha.hasFocus()) {
            this.nha.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        } else {
            this.nha.setHintTextColor(ao.getColor(R.color.CAM_X0109));
        }
        if (this.oep.hasFocus()) {
            this.oep.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        } else {
            this.oep.setHintTextColor(ao.getColor(R.color.CAM_X0109));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZL() {
        if (this.nha != null) {
            if (this.nha.getText().toString().length() == 0) {
                this.nha.getPaint().setFakeBoldText(false);
            } else if (this.nha.getText().toString().length() > 0) {
                this.nha.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.fOA = new com.baidu.tbadk.core.view.a(getPageContext());
        this.oeF = this.ngI.getType() == 4 || 5 == this.ngI.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bwq().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ao.setViewTextColor(this.mName, R.color.CAM_X0105);
        dZO();
        this.oeE = (ScrollView) findViewById(R.id.write_scrollview);
        this.oeE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.oep != null) {
                        l.hideSoftKeyPad(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.oep);
                    }
                    if (TransmitPostEditActivity.this.fDN != null) {
                        TransmitPostEditActivity.this.fDN.bDe();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.ltF = (RelativeLayout) findViewById(R.id.parent);
        this.oen = (LinearLayout) findViewById(R.id.tool_view);
        this.oen.setContentDescription(IStringUtil.TOP_PATH);
        this.oeo = (LinearLayout) findViewById(R.id.title_view);
        this.nhb = findViewById(R.id.interval_view);
        this.oeH = (TextView) findViewById(R.id.hot_topic_title_edt);
        dLw();
        if (this.oeF) {
            this.oeE.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        dLy();
        dZU();
        this.nhd = (LinearLayout) findViewById(R.id.post_content_container);
        this.nhd.setDrawingCacheEnabled(false);
        this.nhd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.oep.requestFocus();
            }
        });
        this.mBack.setOnFocusChangeListener(this.hxA);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.dLp();
                TransmitPostEditActivity.this.dZJ();
            }
        });
        dZR();
        dZT();
        dZN();
        dZF();
        dZS();
        dLv();
        dZZ();
        dZM();
        if (this.ngI.getType() == 4 && this.nhi != null && this.oer != null) {
            this.nhi.setVisibility(8);
            this.oer.setVisibility(8);
        }
        dLx();
        ShowSoftKeyPad(this.mInputManager, this.nha);
    }

    private void dZM() {
        this.oeM = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.oeM.setBgColor(R.color.CAM_X0205);
        this.oeM.setData(this.nYG);
        this.oeM.setActivity(this);
    }

    private void dZN() {
        String str;
        String str2;
        if (this.ngI != null) {
            switch (this.ngI.getType()) {
                case 0:
                case 9:
                    if (this.jLR != null && this.jLR.equals("1")) {
                        this.mName.setText(R.string.share_to_home_page);
                    } else if (this.jLR != null && this.jLR.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.ngI.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.nha.setVisibility(0);
                    this.oep.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.oep.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(R.string.send_reply);
                    this.oep.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.nha.setVisibility(8);
                    return;
            }
        }
    }

    private void dZO() {
        this.lPZ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lPZ.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.lPZ.setLayoutParams(layoutParams);
        this.lPZ.setOnFocusChangeListener(this.hxA);
    }

    private void dZP() {
        if (this.ngI != null && this.ngI.getType() == 0 && this.ngI.getType() == 9 && !this.oem && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = at.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dZX() != null) {
                dZX().setText(cutStringWithSuffix);
                dZX().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    private void dZQ() {
        this.gOR = null;
        this.oeA = -1;
        this.oeC = -1;
        com.baidu.tieba.frs.ad At = ac.cHd().At(1);
        if (At != null) {
            this.gOR = At.jjK;
            this.oeA = getIntent().getIntExtra("category_id", -1);
            if (this.gOR != null && !this.gOR.isEmpty() && this.oeA >= 0) {
                this.oez = new ab();
                this.oez.jjG = 0;
                this.oez.name = getPageContext().getResources().getString(R.string.category_auto);
                this.oeC = this.oez.jjG;
                this.oeB = this.oez.name;
                for (ab abVar : this.gOR) {
                    if (abVar.jjG == this.oeA) {
                        this.oeC = abVar.jjG;
                        this.oeB = abVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dZR() {
        if (this.gOR != null && !this.gOR.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.oeD = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.oeD.setText(this.oeB);
            this.oeD.setCategoryContainerData(this.gOR, this.oez, this.oeC);
            this.oeD.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bc bcVar) {
                    if (bcVar != null) {
                        TransmitPostEditActivity.this.oeD.setText(bcVar.name);
                        TransmitPostEditActivity.this.ngI.setCategoryTo(bcVar.jjG);
                        TransmitPostEditActivity.this.oeC = bcVar.jjG;
                        TransmitPostEditActivity.this.oeD.dZg();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.oeD.dZf();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dZX());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dZW());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.oeT = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.oeT.setTitle(R.string.no_disturb_start_time);
        this.oeT.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.oeT);
        this.oeT.setButton(-2, getPageContext().getString(R.string.cancel), this.oeT);
        return this.oeT;
    }

    private void dZS() {
        this.oev = (RelativeLayout) findViewById(R.id.addition_container);
        this.oew = (TextView) findViewById(R.id.addition_create_time);
        this.oex = (TextView) findViewById(R.id.addition_last_time);
        this.oey = (TextView) findViewById(R.id.addition_last_content);
        if (this.oeu != null) {
            this.oev.setVisibility(0);
            this.oew.setText(getPageContext().getString(R.string.write_addition_create) + at.getFormatTime(this.oeu.getCreateTime() * 1000));
            if (this.oeu.getAlreadyCount() == 0) {
                this.oex.setVisibility(8);
            } else {
                this.oex.setText(getPageContext().getString(R.string.write_addition_last) + at.getFormatTime(this.oeu.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.oeu.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.oey.setText(lastAdditionContent);
            } else {
                this.oey.setVisibility(8);
            }
            dZW().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.oeu.getAlreadyCount()), Integer.valueOf(this.oeu.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.oev.setVisibility(8);
    }

    private void dLv() {
        this.nhi = findViewById(R.id.post_prefix_layout);
        this.nhf = (TextView) findViewById(R.id.post_prefix);
        this.oer = findViewById(R.id.prefix_divider);
        this.nhh = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.nhi.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.ngJ = 1;
            this.nhi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.nhf.setVisibility(0);
                    TransmitPostEditActivity.this.nhi.setSelected(true);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.nhg, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.fDN.bDe();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.nha);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.oep);
                }
            });
            this.nhh = (ImageView) findViewById(R.id.prefix_icon);
            if (size > 1) {
                this.nhh.setVisibility(0);
                this.nhf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.nhf.setSelected(true);
                        com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.nhg, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.fDN.bDe();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dZX());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dZW());
                    }
                });
            }
            this.nhg = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.nhg.a(this);
            this.nhg.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.nhg.setOutsideTouchable(true);
            this.nhg.setFocusable(true);
            this.nhg.setOnDismissListener(this);
            this.nhg.setBackgroundDrawable(ao.getDrawable(R.color.CAM_X0201));
            int color = ao.getColor(R.color.CAM_X0105);
            int color2 = ao.getColor(R.color.CAM_X0108);
            ao.setBackgroundResource(this.nhf, R.color.CAM_X0201);
            ao.setImageResource(this.nhh, R.drawable.icon_frs_arrow_n);
            this.nhf.setTextColor(color);
            this.oes.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.oes.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.nhg.addView(writePrefixItemLayout);
            }
            this.nhg.setCurrentIndex(0);
            this.nhf.setText(prefixs.get(1));
            MM(1);
            return;
        }
        this.nhi.setVisibility(8);
    }

    protected void dZT() {
        this.lPZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    TransmitPostEditActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick() && !TransmitPostEditActivity.this.eag()) {
                    if (TransmitPostEditActivity.this.oeK.a(TransmitPostEditActivity.this.nha, TransmitPostEditActivity.this.oep)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.oeK.dXU());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dZX());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.dZW());
                    TransmitPostEditActivity.this.fDN.bDe();
                    TiebaStatic.log(new aq("c12608").an("obj_locate", 7));
                    TransmitPostEditActivity.this.ead();
                }
            }
        });
    }

    protected void dLw() {
        this.nha = (EditText) findViewById(R.id.post_title);
        this.nha.setOnClickListener(this.oeP);
        this.nha.setOnFocusChangeListener(this.hxA);
        if ((this.ngI.getType() == 0 || this.ngI.getType() == 9 || this.ngI.getType() == 7) && this.ngI.getTitle() != null) {
            this.nha.setText(this.ngI.getTitle());
            this.nha.setSelection(this.ngI.getTitle().length());
        }
        this.nha.addTextChangedListener(this.oeR);
        if (!this.ngI.getHaveDraft()) {
            dZP();
        }
        this.nha.setHint(getResources().getString(R.string.post_title_hint));
    }

    protected void dLy() {
        this.oep = (SpanGroupEditText) findViewById(R.id.post_content);
        this.oep.setDrawingCacheEnabled(false);
        this.oep.setOnClickListener(this.oeP);
        if (this.fGa != null) {
            this.fGa.setSpanGroupManager(this.oep.getSpanGroupManager());
        }
        if (this.ngI != null) {
            this.ngI.setSpanGroupManager(this.oep.getSpanGroupManager());
        }
        if (this.ngI.getContent() != null && this.ngI.getContent().length() > 0) {
            this.oep.setText(TbFaceManager.bGo().aE(getPageContext().getPageActivity(), this.ngI.getContent()));
            this.oep.setSelection(this.oep.getText().length());
        }
        if (!at.isEmpty(this.jcZ)) {
            this.oep.setSelection(0);
        }
        this.oep.setOnFocusChangeListener(this.hxA);
        this.oep.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.oep.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.oep.addTextChangedListener(this.oeS);
        if (this.oel != null && this.oel.showType == 3) {
            this.oep.setHint(R.string.share_video_default);
        } else {
            this.oep.setHint(R.string.share_txt_default);
        }
    }

    private void dZU() {
        this.ajX = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajX.getLayoutParams();
        layoutParams.topMargin -= oei;
        layoutParams.leftMargin = fYY;
        layoutParams.rightMargin = fYY;
        this.ajX.setLayoutParams(layoutParams);
        this.ajX.setVisibility(0);
        this.ajX.a(this.oel);
        this.ajX.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dZV() {
        int i = 5000;
        if (this.oeu != null) {
            i = 1000;
        }
        return dZW().getText() != null && dZW().getText().length() >= i;
    }

    private void DN(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.oej)) {
                this.oej = "";
                dZW().requestFocus();
                if (dZW().getText() != null && dZW().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dZW().getSelectionStart();
                    editable = dZW().getText();
                }
            } else if ("from_title".equals(this.oej)) {
                this.oej = "";
                dZX().requestFocus();
                if (dZX().getText() != null && dZX().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dZX().getSelectionStart();
                    editable = dZX().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zq(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.ngI != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.ngI.getForumId(), 0L), this.ngI.getFirstDir(), this.ngI.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(u uVar) {
        if (((ImageSpan[]) dZW().getText().getSpans(0, dZW().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.oet == null) {
                this.oet = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.oet.getView().isShown()) {
                this.oet.cancel();
            }
            this.oet.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, uVar, dZW());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dZW() {
        return this.oep;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dZX() {
        return this.nha;
    }

    protected void dZY() {
        if (dZW().getSelectionStart() > 0) {
            String substring = dZW().getText().toString().substring(0, dZW().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.iRk.matcher(substring);
            if (matcher.find()) {
                dZW().getText().delete(dZW().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dZW().getSelectionStart());
                return;
            }
            dZW().onKeyDown(67, this.iRl);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.fOA.setCancelListener(null);
        this.fOA.setTipString(R.string.sending);
        this.fOA.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.fOA.setDialogVisiable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLx() {
        if (this.ngI != null) {
            String str = "";
            String str2 = "";
            if (dZX() != null) {
                str = dZX().getText().toString();
            }
            if (dZW() != null) {
                str2 = dZW().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.ngI.getType() == 0 || this.ngI.getType() == 9 || this.ngI.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.ngJ == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.ngI.setIsNoTitle(true);
                        } else {
                            this.ngI.setIsNoTitle(false);
                            zr(true);
                            return;
                        }
                    } else {
                        this.ngI.setIsNoTitle(false);
                        zr(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.ngI.setIsNoTitle(true);
                } else {
                    this.ngI.setIsNoTitle(false);
                    zr(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.oeF) {
                    zr(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    zr(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                zr(true);
            } else if (this.ngI.getVideoInfo() != null) {
                zr(true);
            } else {
                zr(false);
            }
        }
    }

    private void zr(boolean z) {
        ao.setNavbarTitleColor(this.lPZ, R.color.CAM_X0302, R.color.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.fGa = new NewWriteModel(this);
        this.fGa.b(this.fGo);
        this.iVZ = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.dLp();
            }
        };
        this.ngI = new WriteData();
        if (bundle != null) {
            this.ngI.setType(bundle.getInt("type", 0));
            this.ngI.setForumId(bundle.getString("forum_id"));
            this.ngI.setForumName(bundle.getString("forum_name"));
            this.ngI.setFirstDir(bundle.getString("forum_first_dir"));
            this.ngI.setSecondDir(bundle.getString("forum_second_dir"));
            this.ngI.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.oeu = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.ngI.setIsAddition(this.oeu != null);
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
            this.ngI.setTitle(bundle.getString("write_title"));
            this.ngI.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.jLR = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.oel = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.ShareInfo.class);
            }
            this.mBaijiahaoData = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.jcZ = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.jda = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.nYG = (FrsTabInfoData) bundle.getSerializable("tab_list");
            str = string;
        } else {
            Intent intent = getIntent();
            this.ngI.setType(intent.getIntExtra("type", 0));
            this.ngI.setForumId(intent.getStringExtra("forum_id"));
            this.ngI.setForumName(intent.getStringExtra("forum_name"));
            this.ngI.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.ngI.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.ngI.setThreadId(intent.getStringExtra("thread_id"));
            this.oeu = (AdditionData) intent.getSerializableExtra("addition_data");
            this.ngI.setIsAddition(this.oeu != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.ngI.setTitle(intent.getStringExtra("write_title"));
            this.ngI.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.jLR = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.oel = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            this.jcZ = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.jda = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.nYG = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.ngI.getType() == 4 ? 6 : 9);
        this.ngI.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.oel != null && this.oel.videoId != null) {
            this.ngI.setVideoId(this.oel.videoId);
            this.ngI.setOriginalVideoCover(this.oel.showPicUrl);
            this.ngI.setOriginalVideoTitle(this.oel.showText);
        }
        if (!at.isEmpty(this.jcZ)) {
            if (!at.isEmpty(this.jda)) {
                this.ngI.setContent("//@" + this.jda + " :" + this.jcZ);
            } else {
                this.ngI.setContent(this.jcZ);
            }
        }
        if (this.ngI != null && this.ngI.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.ngI.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.oem = true;
        }
        dZQ();
    }

    private void dZZ() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) x.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.nha.setText(com.baidu.tbadk.plugins.b.Ev(com.baidu.tbadk.plugins.b.Ew(hotTopicBussinessData.mTopicName)));
            this.nha.setMovementMethod(com.baidu.tieba.view.c.dXv());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString Ev = com.baidu.tbadk.plugins.b.Ev(com.baidu.tbadk.plugins.b.Ew(hotTopicBussinessData.mTopicName));
            if (Ev != null) {
                this.nha.setText(Ev);
            }
            this.oeH.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.ngI.getType());
        bundle.putString("forum_id", this.ngI.getForumId());
        bundle.putString("forum_name", this.ngI.getForumName());
        bundle.putString("forum_first_dir", this.ngI.getFirstDir());
        bundle.putString("forum_second_dir", this.ngI.getSecondDir());
        bundle.putString("thread_id", this.ngI.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jLR);
        bundle.putSerializable("tab_list", this.nYG);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.oeu != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.oeu));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jLR);
        if (this.oel != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.oel));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dZW().getEditableText().toString();
        if (obj != null) {
            dZW().setText(TbFaceManager.bGo().a(getPageContext().getPageActivity(), obj, this.oeN));
            dZW().setSelection(dZW().getText().length());
        }
    }

    private String eaa() {
        if (dZW() == null || dZW().getText() == null) {
            return "";
        }
        String obj = dZW().getText().toString();
        if (StringUtils.isNull(obj)) {
            if (this.oel != null && this.oel.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return obj;
    }

    private String eab() {
        if (this.ngI == null || dZX() == null || dZX().getVisibility() != 0 || dZX().getText() == null) {
            return "";
        }
        String obj = dZX().getText().toString();
        if (this.mPrefixData != null && x.getCount(this.mPrefixData.getPrefixs()) > 0 && this.ngJ != 0 && this.ngI.getType() != 4 && this.nhf != null && this.nhf.getText() != null) {
            obj = this.nhf.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            obj = this.mPrefixData.getImplicitTitle() + this.ngI.getTitle();
        }
        if (TextUtils.isEmpty(obj)) {
            if (TextUtils.isEmpty(this.ngI.getContent())) {
                return getString(R.string.share_txt_default);
            }
            if (getString(R.string.share_txt_default).equals(this.ngI.getContent())) {
                return getString(R.string.share_txt_default);
            }
            if (getString(R.string.share_video_default).equals(this.ngI.getContent())) {
                return getString(R.string.share_video_default);
            }
            return obj;
        }
        return obj;
    }

    private void cJv() {
        dLp();
        this.ngI.setContent(eaa());
        this.ngI.setTitle(eab());
        if (this.oeA >= 0) {
            this.ngI.setCategoryFrom(this.oeA);
        }
        if (this.oeC >= 0) {
            this.ngI.setCategoryTo(this.oeC);
        }
        this.ngI.setWriteImagesInfo(this.writeImagesInfo);
        this.ngI.setHasLocationData(this.fFZ != null && this.fFZ.cot());
        this.fGa.yp(this.writeImagesInfo.size() > 0);
        if (!x.isEmpty(this.mList) && this.oeG != null && this.oeG.mIsGlobalBlock == 0) {
            this.ngI.setForumId(String.valueOf(this.oeG.mForumId));
            this.ngI.setForumName(this.oeG.mForumName);
        }
        eac();
        this.fGa.f(this.ngI);
        this.ngI.setContent(this.ngI.getContent().replaceAll("\u0000\n", ""));
        this.ngI.setContent(this.ngI.getContent().replaceAll("\u0000", ""));
        this.ngI.setVcode(null);
        this.fGa.dco().setVoice(null);
        this.fGa.dco().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.iVZ);
        this.fGa.dQB();
    }

    private void eac() {
        FrsTabItemData selectedTabItemData;
        if (this.ngI != null && this.oeM != null && (selectedTabItemData = this.oeM.getSelectedTabItemData()) != null) {
            this.ngI.setTabId(selectedTabItemData.tabId);
            this.ngI.setTabName(selectedTabItemData.name);
            this.ngI.setIsGeneralTab(selectedTabItemData.isGeneralTab);
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
            if (this.oeu != null) {
                i2 = this.oeu.getTotalCount();
                i = this.oeu.getAlreadyCount() + 1;
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
                if (this.fDN != null && !this.fDN.bEM()) {
                    dZW().requestFocus();
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
                            dZW().getText().insert(dZW().getSelectionStart(), sb.toString());
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
                        if (this.oek) {
                            sb2.append(com.baidu.tbadk.plugins.b.fNU);
                            this.oek = false;
                        }
                        sb2.append(stringExtra);
                        DN(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !x.isEmpty(this.mList) && !x.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                this.oeG = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                a(this.oeG);
            }
        } else if (i2 == 0) {
            if (this.fDN != null && !this.fDN.bEM()) {
                this.oep.requestFocus();
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
                        this.oeK.Vf(postWriteCallBackData.getErrorString());
                        this.oeK.bm(postWriteCallBackData.getSensitiveWords());
                        this.oeK.b(this.nha, this.oep);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.oej)) {
                        dZX().requestFocus();
                        return;
                    } else if ("from_content".equals(this.oej)) {
                        dZW().requestFocus();
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
    public void ead() {
        if ("1".equals(this.jLR)) {
            this.ngI.setCanNoForum(true);
            this.ngI.setTransmitForumData("[]");
        } else if ("2".equals(this.jLR)) {
            this.ngI.setCanNoForum(false);
        }
        eae();
        this.ngI.setPrivacy(this.isPrivacy);
        this.ngI.setIsShareThread(true);
        if (this.oel != null && !StringUtils.isNull(this.oel.threadId)) {
            this.ngI.setOriginalThreadId(this.oel.threadId);
        }
        this.ngI.setBaijiahaoData(this.mBaijiahaoData);
        if (this.oel != null) {
            this.ngI.setOriBaijiahaoData(this.oel.oriUgcInfo);
        }
        this.ngI.setCallFrom(this.jLR);
        cJv();
    }

    private void eae() {
        if (this.fDN != null) {
            this.fDN.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dZX());
        HidenSoftKeyPad(this.mInputManager, dZW());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bP(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.jgD) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).an("obj_locate", ax.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.ngI.getType() != 7) {
                if (this.oeu == null) {
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
        this.fGf = i;
        if (this.fDN != null) {
            this.fDN.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void eaf() {
        if (!this.oeF && this.fDN != null) {
            this.fDN.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.fDN.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la(boolean z) {
        if (this.fDN != null) {
            this.fDN.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void MM(int i) {
        if (i < this.oes.size()) {
            for (int i2 = 0; i2 < this.oes.size(); i2++) {
                this.oes.get(i2).zh(false);
            }
            this.oes.get(i).zh(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void Kv(int i) {
        this.ngJ = i;
        this.nhg.setCurrentIndex(i);
        MM(i);
        this.nhf.setText(this.mPrefixData.getPrefixs().get(i));
        dLx();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.nhg, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.nhi.setSelected(false);
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
        if (this.ngI != null) {
            if (this.ngI.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.ngI.getType() == 5) {
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
            bFs();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.bsq = z;
        if (this.oeJ != null && !z) {
            this.oeJ.cyX();
        }
        if (this.oeL != null && !z) {
            dZH();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.bsq && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.oek = false;
            this.oej = "";
            if ("from_content".equals(str)) {
                this.oej = "from_content";
            } else if ("from_title".equals(str)) {
                this.oej = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.Eu(String.valueOf(charSequence.charAt(i)))) {
                zq(false);
            }
        }
    }

    public void dFD() {
        if (!x.isEmpty(this.mList)) {
            this.oeo.setVisibility(0);
            this.oeo.requestFocus();
            return;
        }
        this.oeo.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eag() {
        if (((ImageSpan[]) dZW().getText().getSpans(0, dZW().getText().length(), ImageSpan.class)).length > 10) {
            if (this.oet == null) {
                this.oet = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.oet.getView().isShown()) {
                this.oet.cancel();
            }
            this.oet.show();
            return true;
        }
        return false;
    }
}
