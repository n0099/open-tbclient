package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.util.ArrayMap;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
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
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.i.a.a;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AddLinkActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.ImageProblemActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.SaveDraftDialogView;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.switchs.RepostToDynamicDefaultSwitch;
import com.baidu.tbadk.util.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.s;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.b.a;
import com.baidu.tieba.write.b.c.b;
import com.baidu.tieba.write.i;
import com.baidu.tieba.write.upload.BaseUploadData;
import com.baidu.tieba.write.upload.ImageTextUploadData;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import com.baidu.tieba.write.write.FindNewLinkBubbleController;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0153a, VoiceManager.c, w.a, i.a {
    private static int mCD = 0;
    private EditorTools eAf;
    private String eBO;
    private LocationModel eBP;
    private NewWriteModel eBQ;
    List<ad> fDY;
    private String hDs;
    private String hDt;
    private String hDu;
    private VoiceManager hFy;
    private com.baidu.tbadk.core.dialog.i hRJ;
    private SaveDraftDialogView hRK;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private LinearLayout kqc;
    private PlayVoiceBntNew kqd;
    private ImageView kqf;
    private int lCA;
    private TextView lCX;
    private com.baidu.tieba.write.i lCY;
    private ImageView lCZ;
    private View lDa;
    private FindNewLinkBubbleController mAl;
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
    private LinearLayout mBo;
    private LinearLayout mBp;
    private View mBs;
    private Toast mBu;
    private AdditionData mBv;
    private RelativeLayout mBw;
    private TextView mBx;
    private TextView mBy;
    private TextView mBz;
    private View mCH;
    private View mCI;
    private TextView mCJ;
    private com.baidu.tieba.c.e mCL;
    private com.baidu.tieba.write.write.video.a mCM;
    private com.baidu.tieba.write.write.vote.a mCN;
    private RelativeLayout mCO;
    private boolean mCP;
    private View mCe;
    private g mCl;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    public PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private FrsTabInfoData mve;
    private ForumTabSelectedView mzB;
    private int privateThread;
    private String mBk = "";
    private boolean mBl = false;
    protected WriteData lCz = null;
    private boolean mBZ = false;
    private boolean mCa = false;
    private boolean mBn = false;
    private boolean mCb = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText lCR = null;
    private HeadImageView mCc = null;
    private View lCS = null;
    private LinearLayout lCU = null;
    private SpanGroupEditText mBq = null;
    private FeedBackModel mBr = null;
    private FeedBackTopListView mCd = null;
    private ArrayList<WritePrefixItemLayout> mBt = new ArrayList<>();
    private String jIZ = null;
    private final KeyEvent hrA = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView mCf = null;
    private TextView lCW = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener hwp = null;
    private final Handler mHandler = new Handler();
    private boolean mCg = false;
    private String mCh = null;
    private RelativeLayout iQl = null;
    public boolean mCi = true;
    public String eBU = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int eBV = 0;
    private int mCj = 0;
    private WriteImagesInfo mCk = new WriteImagesInfo();
    private View mRootView = null;
    private GridView mCm = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a mCn = null;
    private ScrollView mBF = null;
    private EditText mCo = null;
    private View mCp = null;
    private View mCq = null;
    private View mCr = null;
    private EditText mCs = null;
    private TextView mCt = null;
    private TextView mCu = null;
    private TextWatcher mCw = null;
    private TextWatcher mCx = null;
    private boolean mBG = false;
    private boolean mCy = false;
    private com.baidu.tbadk.core.view.a eJP = null;
    private String mFrom = "write";
    private File mCz = null;
    private TbImageView mCA = null;
    private View mBubbleView = null;
    private Dialog mCB = null;
    private LinearLayout mCC = null;
    private boolean mCE = false;
    private long mCF = -1000;
    private boolean mCG = false;
    private String iik = "2";
    private int biT = 0;
    private String mTopicId = "";
    private SpannableStringBuilder mBJ = new SpannableStringBuilder();
    private boolean mCK = false;
    private boolean aYm = false;
    private final b mBL = new b();
    private boolean mzf = false;
    private final HttpMessageListener mCQ = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.jIZ)) {
                    WriteActivity.this.jIZ = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.wC(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.jIZ)) {
                    WriteActivity.this.jIZ = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.jIZ);
                    WriteActivity.this.wC(true);
                }
            }
        }
    };
    private TbFaceManager.a mBN = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
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
    private final AntiHelper.a hGU = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ah("obj_locate", aw.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ah("obj_locate", aw.a.LOCATE_WRITE));
        }
    };
    private FindNewLinkBubbleController.a mCR = new FindNewLinkBubbleController.a() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.write.write.FindNewLinkBubbleController.a
        public void f(View view, String str) {
            if (WriteActivity.this.mAl != null) {
                TiebaStatic.log("c13802");
                WriteActivity.this.mAl.KC();
                UtilHelper.clearClipBoard();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, str, false, null)));
            }
        }
    };
    private final NewWriteModel.d eCe = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.43
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ad adVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.cbU();
            WriteActivity.this.closeLoadingDialog();
            WriteActivity.this.mCS = true;
            if (postWriteCallBackData != null && WriteActivity.this.lCz != null) {
                WriteActivity.this.mBL.aZ(null);
                if (z) {
                    WriteActivity.this.iR(z);
                    if (WriteActivity.this.e(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    WriteActivity.this.cfx();
                    WriteActivity.this.dwF();
                    if ((WriteActivity.this.lCz.getType() == 0 || WriteActivity.this.lCz.getType() == 9) && !x.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                        TiebaStatic.log(new ap("c11731").dn("obj_id", WriteActivity.this.mTopicId));
                    }
                    WriteActivity.this.k(postWriteCallBackData);
                    if (!as.isEmpty(postWriteCallBackData.getVideoid()) && WriteActivity.this.lCz.getVideoInfo() != null) {
                        postWriteCallBackData.mVideoMd5 = WriteActivity.this.lCz.getVideoInfo().getVideoMd5();
                        if (!as.isEmpty(WriteActivity.this.lCz.getForumName())) {
                            postWriteCallBackData.mFrom = 2;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS, postWriteCallBackData));
                    } else {
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                        intent.putExtras(bundle);
                        WriteActivity.this.setResult(-1, intent);
                    }
                    WriteActivity.this.finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    WriteActivity.this.showToast(postWriteCallBackData.getErrorString());
                    WriteActivity.this.mBL.aZ(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.mBL.Py(postWriteCallBackData.getErrorString());
                    WriteActivity.this.mBL.b(WriteActivity.this.lCR, WriteActivity.this.mBq);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (as.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.c(WriteActivity.this.getActivity(), WriteActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.c(WriteActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this.getActivity());
                    if (as.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.xl(WriteActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.xl(postWriteCallBackData.getErrorString());
                    }
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.43.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.43.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(WriteActivity.this.getActivity(), 0, 26, 1)));
                            TiebaStatic.log(new ap("c13746").ah("obj_locate", 1).ah("obj_type", 1));
                        }
                    });
                    aVar.b(WriteActivity.this.getPageContext()).aYL();
                    TiebaStatic.log(new ap("c13745").ah("obj_locate", 1).ah("obj_type", 1));
                } else if ((adVar == null || writeData == null || adVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (adVar != null && writeData != null && adVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(adVar.getVcode_md5());
                    writeData.setVcodeUrl(adVar.getVcode_pic_url());
                    writeData.setVcodeExtra(adVar.bep());
                    if (com.baidu.tbadk.t.a.Ay(adVar.beo())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, adVar.beo());
                        if (WriteActivity.this.mCb) {
                            newVcodeActivityConfig.setHideFeedBackButton();
                        }
                        WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newVcodeActivityConfig));
                        return;
                    }
                    WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a eCc = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bjD() {
            WriteActivity.this.showToast(R.string.no_network_guide);
            WriteActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void onFail(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(R.string.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.dlK())) {
                WriteActivity.this.a(2, true, aVar.dlK());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener lPC = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.eBP.vp(false);
                    WriteActivity.this.eBP.fD(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.eBP.vp(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener mBO = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.46
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.write.write.WriteActivity.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                WriteActivity.this.dwW();
            }
        }
    };
    private final View.OnClickListener mBP = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dvX = WriteActivity.this.dvX();
            if (dvX >= 0 && dvX < WriteActivity.this.mBq.getText().length()) {
                WriteActivity.this.mBq.setSelection(dvX);
            }
        }
    };
    private boolean mBQ = true;
    private final View.OnFocusChangeListener ggs = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.lCR || view == WriteActivity.this.mBack || view == WriteActivity.this.lCW) {
                if (z) {
                    WriteActivity.this.mBQ = true;
                    WriteActivity.this.dvY();
                    l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.lCR);
                    if (WriteActivity.this.eAf != null) {
                        WriteActivity.this.eAf.bhl();
                    }
                } else if (view == WriteActivity.this.lCR) {
                    WriteActivity.this.lCX.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.mBq && z) {
                WriteActivity.this.mBQ = false;
                WriteActivity.this.dvY();
                l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.mBq);
                if (WriteActivity.this.eAf != null) {
                    WriteActivity.this.eAf.bhl();
                }
            }
            WriteActivity.this.dwd();
        }
    };
    private boolean mCS = false;
    private TextWatcher mBR = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.14
        private String mBV = "";
        private String mBW;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mBW = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.mBW != null ? this.mBW.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dhM();
            WriteActivity.this.dwe();
            EditText dwq = WriteActivity.this.dwq();
            if (editable != null && dwq != null && dwq.getText() != null) {
                if (this.mBV == null || !this.mBV.equals(editable.toString())) {
                    if (WriteActivity.this.mBL != null) {
                        this.mBV = dwq.getText().toString();
                        WriteActivity.this.mBL.b(dwq, true);
                        return;
                    }
                    return;
                }
                dwq.setSelection(dwq.getSelectionEnd());
            }
        }
    };
    private TextWatcher mBS = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.15
        private String mBW;
        private String mBX = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mBW = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.mBW != null ? this.mBW.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dhM();
            EditText dwp = WriteActivity.this.dwp();
            if (editable != null && dwp != null && dwp.getText() != null) {
                if (this.mBX == null || !this.mBX.equals(editable.toString())) {
                    if (WriteActivity.this.mBL != null) {
                        this.mBX = dwp.getText().toString();
                        WriteActivity.this.mBL.b(dwp, false);
                        return;
                    }
                    return;
                }
                dwp.setSelection(dwp.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0753a kwL = new a.InterfaceC0753a() { // from class: com.baidu.tieba.write.write.WriteActivity.32
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0753a
        public void onRefresh() {
            WriteActivity.this.jIZ = null;
            WriteActivity.this.wC(false);
            WriteActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.mFrom)) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUCCES_IN_MISSON);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
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

    public void dwz() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
            if (this.mBK != null) {
                this.mBK.duP();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bjq();
        } else if (this.eBP != null) {
            this.eBP.vp(false);
            a(1, true, (String) null);
            this.eBP.dlP();
        }
    }

    private void bjq() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ln(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.eBP.dlT();
                } else {
                    WriteActivity.this.eCc.bjD();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.a(0, true, (String) null);
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
            if (this.mCM != null && this.mCM.isVisible()) {
                this.eAf.setBarLauncherEnabled(false);
                this.eAf.setDeskLauncherEnabled(false);
                this.eAf.setToolEnabled(true, 2);
                if (this.mBK != null) {
                    this.mBK.ws(false);
                    return;
                }
                return;
            }
            this.eAf.setBarLauncherEnabled(!this.mBQ);
            this.eAf.setDeskLauncherEnabled(this.mBQ ? false : true);
            this.eAf.setToolEnabled(true, 26);
            this.eAf.setToolEnabled(true, 2);
            this.eAf.setToolEnabled(true, 30);
            if (this.mBK != null) {
                this.mBK.ws(true);
            }
            dwS();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.mBG) {
            this.lCR.setVisibility(8);
            if (this.lCz.getType() == 5) {
                this.mCr.setVisibility(8);
            } else {
                this.mCr.setVisibility(0);
            }
            a(this.mCu, this.mCo);
            a(this.mCt, this.mCs);
            dhM();
        }
        if (this.mBZ) {
            this.mBQ = true;
            dvY();
            if (this.eAf != null) {
                this.eAf.bhl();
            }
            this.lCR.requestFocus();
            ShowSoftKeyPadDelay(this.lCR);
        }
        if (this.mCM != null) {
            this.mCM.onResume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
        if (this.mCM != null) {
            this.mCM.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
        if (this.mCM != null) {
            this.mCM.onStop();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            if (stringExtra != null && this.writeImagesInfo != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    dwx();
                }
                wD(true);
            }
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.lCz.setVideoInfo((VideoInfo) serializableExtra);
            } else {
                this.lCz.setVideoInfo(null);
            }
            if (this.mCM == null) {
                this.mCM = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            }
            if (this.lCz.getVideoInfo() != null && this.lCz.getVideoInfo().isEditVideoDataLegal()) {
                wB(false);
                this.mCM.dxH();
                if (this.mBp != null && this.mBp.getVisibility() == 0) {
                    this.mBp.setVisibility(8);
                    if (this.eAf != null) {
                        this.eAf.nQ(30).setName(getResources().getString(R.string.editor_add_title));
                    }
                }
                if (dwp() != null && e(dwp().getText())) {
                    dwp().setText("");
                    this.lCz.setContent("");
                    return;
                }
                return;
            }
            wB(true);
        }
    }

    public void PW(String str) {
        showToastWithDefaultIcon(str, BdToast.DefaultIcon.FAILURE);
    }

    public void wB(boolean z) {
        if (z) {
            this.lCz.setVideoInfo(null);
            this.mCM.setVideoInfo(null);
            this.mCl.dxa().setVisibility(0);
            wC(false);
        } else {
            this.mCM.setVideoInfo(this.lCz.getVideoInfo());
            this.writeImagesInfo.clear();
            this.mCl.dxa().setVisibility(8);
            dwI();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, false));
        }
        dhM();
        dvY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        if (this.lCz.getType() == 0) {
            Hq(this.biT);
        }
        initUI();
        dwH();
        this.eBP = new LocationModel(getPageContext());
        this.eBP.a(this.eCc);
        registerListener(this.lPC);
        registerListener(this.mBO);
        registerListener(this.mBackgroundListener);
        cFt();
        dwV();
        if (this.mBG) {
            this.mCn.setEditorTools(this.eAf);
        } else {
            this.mBq.requestFocus();
        }
        dcK();
        dwx();
        dwT();
    }

    @SuppressLint({"ResourceAsColor"})
    private void cFt() {
        this.eAf = new EditorTools(getActivity());
        this.eAf.setBarMaxLauCount(5);
        this.eAf.setMoreButtonAtEnd(true);
        this.eAf.setBarBackgroundColorId(R.color.cp_bg_line_h);
        this.eAf.setBarLauncherType(1);
        this.eAf.iJ(true);
        this.eAf.iK(true);
        switch (this.lCz.getType()) {
            case 4:
            case 5:
                dwC();
                break;
            default:
                dvZ();
                break;
        }
        this.eAf.build();
        if (this.mBo != null) {
            this.mBo.addView(this.eAf);
        }
        czf();
        this.eAf.display();
        com.baidu.tbadk.editortools.g nQ = this.eAf.nQ(6);
        if (nQ != null && !TextUtils.isEmpty(this.eBU)) {
            ((View) nQ).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.eBU);
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
        if (!this.mzf) {
            dwb();
        }
        dwW();
    }

    private void dwA() {
        this.mCp = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.mCr = this.mCp.findViewById(R.id.live_post_title_container);
        this.mCo = (EditText) this.mCp.findViewById(R.id.live_post_content);
        this.mCm = (GridView) this.mCp.findViewById(R.id.photoLiveGridView);
        this.mCs = (EditText) this.mCp.findViewById(R.id.live_post_title);
        this.mCt = (TextView) this.mCp.findViewById(R.id.titleOverPlusNumber);
        this.mCu = (TextView) this.mCp.findViewById(R.id.contentOverPlusNumber);
        this.mCq = this.mCp.findViewById(R.id.live_interval_view);
        this.mCt.setText(String.valueOf(20));
        this.mCu.setText(String.valueOf(233));
        this.mCp.setVisibility(0);
        this.mCt.setVisibility(0);
        this.mCu.setVisibility(0);
        this.mCs.setHint(R.string.tips_title_limit_new);
        this.mCs.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.mCy = true;
                    WriteActivity.this.mBQ = true;
                    WriteActivity.this.dvY();
                    if (WriteActivity.this.eAf != null) {
                        WriteActivity.this.eAf.bhl();
                    }
                }
            }
        });
        if (this.lCz.getType() == 4) {
            this.mCo.setHint(R.string.live_write_input_content_new);
        } else if (this.lCz.getType() == 5) {
            this.mCo.setHint(R.string.live_write_input_content_update);
        }
        this.mCo.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.mCy = false;
                    WriteActivity.this.mBQ = false;
                    WriteActivity.this.dvY();
                    if (WriteActivity.this.eAf != null) {
                        WriteActivity.this.eAf.bhl();
                    }
                }
            }
        });
        this.mCo.requestFocus();
        this.mCo.addTextChangedListener(agY());
        this.mCs.requestFocus();
        this.mCs.addTextChangedListener(agY());
        this.mCs.setOnClickListener(this.mBP);
        this.mCo.setOnClickListener(this.mBP);
        this.mCn = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.mCm);
        this.mCn.Hk(6);
        this.mCm.setAdapter((ListAdapter) this.mCn);
        View findViewById = this.mCp.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.9
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void dvH() {
                WriteActivity.this.dwQ();
            }
        });
        dwB();
    }

    private void dwB() {
        if (this.lCz.getType() == 0) {
            if (this.lCz.getTitle() != null) {
                this.mCs.setText(this.lCz.getTitle());
                this.mCs.setSelection(this.lCz.getTitle().length());
                return;
            }
            return;
        }
        if (this.lCz.getType() == 1 || this.lCz.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.mBG) {
            dwO();
        }
        if (this.eAf.biL()) {
            this.eAf.bhl();
        }
        Hq(0);
    }

    public boolean duE() {
        return (!"1".equals(this.iik) && this.writeImagesInfo.size() == 0 && this.mVoiceModel == null && ((this.mBp == null || this.mBp.getVisibility() != 0) && ((this.mBq == null || !this.mBq.bcV()) && !dwY()))) && (dwp() == null || !e(dwp().getText()));
    }

    private boolean e(Spannable spannable) {
        if (spannable != null) {
            ImageSpan[] imageSpanArr = (ImageSpan[]) spannable.getSpans(0, spannable.length(), ImageSpan.class);
            if (imageSpanArr != null && imageSpanArr.length > 0) {
                return true;
            }
            if (this.mBL != null) {
                if (this.mBL.d(spannable)) {
                    return true;
                }
            }
            if (bd.baV().l(spannable)) {
                return true;
            }
        }
        return false;
    }

    private void Hq(int i) {
        if (this.writeImagesInfo != null && this.lCz != null) {
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.lCz.getForumId());
            albumFloatActivityConfig.getIntent().putExtra("forum_name", this.lCz.getForumName());
            albumFloatActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumFloatActivityConfig.setAlbumThread(i);
            albumFloatActivityConfig.setCanSelectVideo(duE());
            albumFloatActivityConfig.setFromWrite(true);
            albumFloatActivityConfig.setCallFrom(this.iik);
            albumFloatActivityConfig.setProfessionZone(this.lCz.getProZone());
            albumFloatActivityConfig.setFrsTabInfo(this.mve);
            AntiData antiData = new AntiData();
            antiData.voice_message = this.eBU;
            antiData.setIfVoice(this.mCi);
            albumFloatActivityConfig.setExtraData(antiData, this.mPrefixData, this.lCz.getFirstDir(), this.lCz.getSecondDir());
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
        }
    }

    private void dwC() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.eAf.bc(arrayList);
        com.baidu.tbadk.editortools.l nT = this.eAf.nT(5);
        if (nT != null) {
            nT.eAR = 2;
        }
        this.eAf.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.eAf.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void dvZ() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.l lVar;
        CustomResponsedMessage runTask2;
        com.baidu.tbadk.editortools.l lVar2;
        CustomResponsedMessage runTask3;
        com.baidu.tbadk.editortools.l lVar3;
        CustomResponsedMessage runTask4;
        com.baidu.tbadk.editortools.l lVar4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 1);
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            this.eAf.b(dVar);
        }
        if (!this.mzf) {
            Boolean dwL = dwL();
            if (!this.mBZ && dwL != null && dwL.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.dmv() && s.d(this.lCz.getForumName(), true) && (runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar4 = (com.baidu.tbadk.editortools.l) runTask4.getData()) != null) {
                lVar4.eAR = 2;
                if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    this.eAf.b(lVar4);
                }
            }
        }
        if (!this.mzf && (runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar3 = (com.baidu.tbadk.editortools.l) runTask3.getData()) != null) {
            lVar3.eAR = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.eAf.b(lVar3);
            }
        }
        if (!this.mzf) {
            this.eAf.b(new com.baidu.tbadk.editortools.k(getActivity(), 6));
        }
        if (!this.mzf) {
            this.eAf.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 7));
        } else {
            this.eAf.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        }
        if (as.equals(this.iik, "2")) {
            this.eAf.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 3));
            this.eAf.b(new com.baidu.tbadk.editortools.e.a(getActivity(), 8));
        }
        if (!this.mzf && (runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar2 = (com.baidu.tbadk.editortools.l) runTask2.getData()) != null) {
            lVar2.eAT = true;
            lVar2.eAR = 9;
            lVar2.eAM = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.eAf.b(lVar2);
            }
        }
        if (!this.mzf && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar.eAT = true;
            lVar.eAR = 10;
            lVar.eAM = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.eAf.b(lVar);
            }
        }
        if (!this.mzf && this.mBv == null) {
            if (this.mBK == null) {
                this.mBK = new com.baidu.tieba.write.editor.b(getActivity(), this.iik);
                this.mBK.bH(this.lCz.getForumId(), this.privateThread);
                this.mBK.wr(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.mBK.duN();
                this.mBK.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                dwz();
            }
            if (!x.isEmpty(this.mList)) {
                this.mBK.duN();
            }
            this.eAf.b(this.mBK);
        }
        this.eAf.bc(arrayList);
        com.baidu.tbadk.editortools.l nT = this.eAf.nT(5);
        if (nT != null) {
            nT.eAR = 4;
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

    private void czf() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.10
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                VideoInfo videoInfo;
                WriteVoteData writeVoteData = null;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        TiebaStatic.log(new ap("c12612").ah("obj_locate", 9));
                        if (WriteActivity.this.dwo()) {
                            WriteActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new ap("c12612").ah("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (aVar.data != null && (aVar.data instanceof q)) {
                            q qVar = (q) aVar.data;
                            if (qVar.bef() == EmotionGroupType.BIG_EMOTION || qVar.bef() == EmotionGroupType.USER_COLLECT) {
                                if (WriteActivity.this.mCurrentPermissionJudgePolicy == null) {
                                    WriteActivity.this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
                                }
                                WriteActivity.this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
                                WriteActivity.this.mCurrentPermissionJudgePolicy.appendRequestPermission(WriteActivity.this, "android.permission.WRITE_EXTERNAL_STORAGE");
                                if (!WriteActivity.this.mCurrentPermissionJudgePolicy.startRequestPermission(WriteActivity.this)) {
                                    if (WriteActivity.this.writeImagesInfo.size() >= WriteActivity.this.writeImagesInfo.getMaxImagesAllowed()) {
                                        WriteActivity.this.showToast(String.format(WriteActivity.this.getString(R.string.max_choose_image_count), Integer.valueOf(WriteActivity.this.writeImagesInfo.getMaxImagesAllowed())));
                                        return;
                                    }
                                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                                    imageFileInfo.setImageType(1);
                                    imageFileInfo.setFilePath(qVar.getName());
                                    imageFileInfo.width = qVar.getWidth();
                                    imageFileInfo.height = qVar.getHeight();
                                    WriteActivity.this.writeImagesInfo.addChooseFile(imageFileInfo);
                                    WriteActivity.this.writeImagesInfo.updateQuality();
                                    WriteActivity.this.wD(true);
                                    WriteActivity.this.dhM();
                                }
                            } else if (WriteActivity.this.dwo()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(qVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.dwr();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.f((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.cNB();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.dwS();
                        WriteActivity.this.dhM();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.Hr(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.mBv == null) {
                            WriteActivity.this.bjr();
                            return;
                        }
                        switch (WriteActivity.this.eBV) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (com.baidu.tbadk.core.util.ad.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.bjo();
                                    return;
                                } else {
                                    com.baidu.tbadk.core.util.ad.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.bjm();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.eBP != null) {
                            WriteActivity.this.eBP.vp(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.jIZ = null;
                        } else {
                            WriteActivity.this.jIZ = (String) aVar.data;
                        }
                        WriteActivity.this.wC(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        ap apVar = new ap("c10645");
                        apVar.dn("fid", WriteActivity.this.lCz != null ? WriteActivity.this.lCz.getForumId() : "");
                        TiebaStatic.log(apVar);
                        if (WriteActivity.this.lCz == null || (videoInfo = WriteActivity.this.lCz.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.eAf.biL()) {
                                        WriteActivity.this.eAf.bhl();
                                        WriteActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(WriteActivity.this.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(R.string.plugin_video_not_active), WriteActivity.this.getResources().getString(R.string.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(R.string.plugin_video_install_tips), WriteActivity.this.getResources().getString(R.string.plugin_go_install));
                            return;
                        }
                        WriteActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.lCz.setVideoInfo(null);
                        WriteActivity.this.dhM();
                        if (WriteActivity.this.mBq != null) {
                            WriteActivity.this.mBq.requestFocus();
                        }
                        WriteActivity.this.eAf.bhl();
                        WriteActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.mBq);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new ap("c12612").ah("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.mBl = true;
                        WriteActivity.this.wz(true);
                        if (!WriteActivity.this.dwq().isFocused() || WriteActivity.this.mBp.getVisibility() != 0) {
                            WriteActivity.this.mBk = "from_content";
                        } else {
                            WriteActivity.this.mBk = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        TiebaStatic.log(new ap("c12612").ah("obj_locate", 8));
                        if (WriteActivity.this.mBp.getVisibility() == 0) {
                            if (WriteActivity.this.mBp.hasFocus()) {
                                WriteActivity.this.mBq.requestFocus();
                                WriteActivity.this.mBq.setSelection(WriteActivity.this.mBq.getText().toString().length());
                            }
                            WriteActivity.this.mBp.setVisibility(8);
                            WriteActivity.this.eAf.nQ(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.mBp.setVisibility(0);
                            WriteActivity.this.mBp.requestFocus();
                            WriteActivity.this.eAf.nQ(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.dhM();
                    } else if (aVar.code == 55) {
                        if (aVar.data != null && (aVar.data instanceof Boolean)) {
                            WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                        }
                    } else if (aVar.code == 58) {
                        if (aVar.data != null && (aVar.data instanceof Boolean)) {
                            WriteActivity.this.isToDynamic = ((Boolean) aVar.data).booleanValue();
                        }
                    } else if (aVar.code == 22) {
                        Intent intent = WriteActivity.this.getIntent();
                        if (intent != null) {
                            TiebaStatic.log(new ap("c12612").ah("obj_locate", 10));
                            int intExtra = intent.getIntExtra(WriteActivityConfig.KEY_ANTI_POLL_LEVEL, 0);
                            if (intent.getIntExtra("key_write_level", -1) >= intExtra) {
                                if (WriteActivity.this.mCN != null && WriteActivity.this.mCN.getWriteVoteData() != null) {
                                    writeVoteData = WriteActivity.this.mCN.getWriteVoteData();
                                }
                                WriteActivity.this.a(writeVoteData);
                                TiebaStatic.log(new ap("c13800").ah("obj_source", 2));
                                return;
                            }
                            WriteActivity.this.showToast(String.format(WriteActivity.this.getResources().getString(R.string.vote_level_tip), Integer.valueOf(intExtra)));
                        }
                    } else if (aVar.code == 21) {
                        if (WriteActivity.this.mAl != null) {
                            WriteActivity.this.mAl.KC();
                        }
                        TiebaStatic.log(new ap("c12612").ah("obj_locate", 5));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, "", true, null)));
                    }
                }
            }
        };
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
        this.eAf.setActionListener(56, bVar);
        this.eAf.setActionListener(48, bVar);
        this.eAf.setActionListener(46, bVar);
        this.eAf.setActionListener(49, bVar);
        this.eAf.setActionListener(47, bVar);
        this.eAf.setActionListener(55, bVar);
        this.eAf.setActionListener(58, bVar);
        this.eAf.setActionListener(22, bVar);
        this.eAf.setActionListener(21, bVar);
    }

    private void ap(Intent intent) {
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
            if (serializableExtra instanceof WriteVoteData) {
                final WriteVoteData writeVoteData = (WriteVoteData) serializableExtra;
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WriteActivity.this.a(writeVoteData);
                        TiebaStatic.log(new ap("c13800").ah("obj_source", 3));
                    }
                };
                this.mCN.an(onClickListener);
                this.mCN.setOnItemClickListener(onClickListener);
                this.mCN.b(writeVoteData);
                this.mCN.wF(true);
                dhM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteVoteData writeVoteData) {
        WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_SDK_WEB_VIEW);
        if (writeVoteData != null) {
            writeVoteActivityConfig.setExtraData(writeVoteData);
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVoteActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hr(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
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
        if (this.mCM != null) {
            this.mCM.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dwa();
        TiebaPrepareImageService.StopService();
        dhD();
        if (!this.mCS) {
            dwD();
        }
        com.baidu.adp.lib.f.g.dismissDialog(this.hRJ, this);
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mCl != null) {
            this.mCl.destroy();
        }
        if (this.mCL != null) {
            this.mCL.HN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwD() {
        if (this.lCz != null && this.lCz.getType() == 2 && this.mCg) {
            finish();
        } else if (this.lCz == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.lCz.setTitle(dwq().getText().toString());
            this.lCz.setContent(dwp().getText().toString());
            int type = this.lCz.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    if (this.mzf) {
                        w.e(this.lCz.getForumId(), this.lCz);
                    } else {
                        w.d(this.lCz.getForumId(), this.lCz);
                    }
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    w.d("24591571", this.lCz);
                }
            } else if (type == 1) {
                w.f(this.lCz.getThreadId(), this.lCz);
            } else if (type == 4) {
                w.d(this.lCz.getForumId() + "photolive", this.lCz);
            } else if (type == 5) {
                w.f(this.lCz.getThreadId() + "updatephotolive", this.lCz);
            }
            this.mCS = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwE() {
        if (this.lCW == null || !this.lCW.isEnabled() || this.mCP) {
            cfx();
            dwF();
            setResult(100);
            finish();
            return;
        }
        if (this.hRK == null) {
            this.hRK = new SaveDraftDialogView(this);
            this.hRK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            WriteActivity.this.cfx();
                            WriteActivity.this.dwF();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            WriteActivity.this.dwD();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        }
                        WriteActivity.this.hRJ.dismiss();
                    }
                }
            });
        }
        if (this.hRJ == null) {
            this.hRJ = new com.baidu.tbadk.core.dialog.i(getPageContext());
            this.hRJ.setContentView(this.hRK);
        }
        boolean z = (this.mCM == null || !this.mCM.isVisible() || this.lCz == null || this.lCz.getVideoInfo() == null || this.lCz.getVideoInfo().isVideoMixFinished()) ? false : true;
        this.hRK.setText(getString(z ? R.string.write_save_draft_dialog_video_fail_title : R.string.write_save_draft_dialog_normal_title), z ? getString(R.string.write_save_draft_dialog_video_fail_sub_title) : null, getString(z ? R.string.write_save_draft_dialog_video_fail_save_text : R.string.save));
        this.hRJ.showDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfx() {
        if (this.lCz.getType() == 0 || this.lCz.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.mzf) {
                    w.e(this.lCz.getForumId(), (WriteData) null);
                } else {
                    w.d(this.lCz.getForumId(), (WriteData) null);
                }
            }
        } else if (this.lCz.getType() == 1) {
            w.f(this.lCz.getThreadId(), (WriteData) null);
        }
        this.mCS = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwF() {
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.mbN));
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
                dwE();
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
        getLayoutMode().onModeChanged(this.mCC);
        ao.setBackgroundColor(this.iQl, R.color.cp_bg_line_e);
        if (this.mCA != null && (i == 1 || i == 4)) {
            this.mCA.setBorderColor(ao.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.baR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.lCW.setTextColor(ao.lO(R.color.cp_link_tip_a));
        dvY();
        ao.setBackgroundColor(this.lCS, R.color.cp_bg_line_c);
        ao.setBackgroundColor(this.mCq, R.color.cp_bg_line_c);
        ao.setBackgroundColor(dwq(), R.color.cp_bg_line_e);
        ao.setImageResource(this.kqf, R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.jIZ)) {
            ao.setBackgroundColor(dwp(), R.color.cp_bg_line_e);
        }
        dhM();
        this.eAf.onChangeSkinType(i);
        if (this.mBE != null) {
            this.mBE.bci();
        }
        ao.setViewTextColor(this.mName, R.color.cp_cont_b);
        this.mCl.mDq.notifyDataSetChanged();
        dwd();
        dwe();
        wC(false);
        if (this.mBL != null) {
            this.mBL.c(dwq(), dwp());
        }
        if (this.mzB != null) {
            this.mzB.onChangeSkinType(i);
        }
        if (this.mCM != null) {
            this.mCM.changeSkin();
        }
        if (this.mCN != null) {
            this.mCN.onChangeSkinType(i);
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
        if (this.lCR != null && this.lCR.getText() != null && this.lCR.getText().toString() != null && this.lCR.getPaint() != null) {
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
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ao.setViewTextColor(this.mName, R.color.cp_cont_b);
        this.mCf = (TextView) findViewById(R.id.btn_image_problem);
        dwh();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lCW.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.lCW.setLayoutParams(layoutParams);
        this.lCW.setOnFocusChangeListener(this.ggs);
        this.mBF = (ScrollView) findViewById(R.id.write_scrollview);
        this.mBF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.mBq != null) {
                        l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.mBq);
                    }
                    if (WriteActivity.this.eAf != null) {
                        WriteActivity.this.eAf.bhl();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mCd = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.mCe = findViewById(R.id.feedback_divider);
        this.iQl = (RelativeLayout) findViewById(R.id.parent);
        this.mBo = (LinearLayout) findViewById(R.id.tool_view);
        this.mBo.setContentDescription(IStringUtil.TOP_PATH);
        this.mBp = (LinearLayout) findViewById(R.id.title_view);
        this.lCS = findViewById(R.id.interval_view);
        this.mCH = findViewById(R.id.hot_topic_fourm_view);
        this.mCI = findViewById(R.id.hot_topic_divider);
        this.mBI = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.mCJ = (TextView) findViewById(R.id.change_one_tv);
        dhL();
        if (this.mBG) {
            this.mBF.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            dwA();
        } else {
            this.mCl = new g(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.mCl.wp(false);
            } else {
                this.mCl.wp(this.lCz.getType() == 0 || this.lCz.getType() == 9);
            }
            this.mCM = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            if (this.lCz.getVideoInfo() != null && this.lCz.getVideoInfo().isEditVideoDataLegal()) {
                wB(false);
                this.mCM.dxH();
            } else {
                wB(true);
            }
        }
        dhN();
        if (this.mBZ || this.mBn) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().ebO) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.lCU = (LinearLayout) findViewById(R.id.post_content_container);
        this.lCU.setDrawingCacheEnabled(false);
        this.lCU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.mBq.requestFocus();
            }
        });
        this.kqc = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.kqd = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.kqf = (ImageView) findViewById(R.id.iv_delete_voice);
        this.kqf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cNB();
            }
        });
        this.mBack.setOnFocusChangeListener(this.ggs);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dhD();
                WriteActivity.this.dwE();
            }
        });
        this.mCf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        dwk();
        q(dwL());
        dwm();
        dwg();
        dwJ();
        dvY();
        dwl();
        dhK();
        dws();
        if (this.lCz.getType() == 4 && this.lDa != null && this.mBs != null) {
            this.lDa.setVisibility(8);
            this.mBs.setVisibility(8);
        }
        dhM();
        dwG();
        dvo();
        dwf();
        dwK();
    }

    private void dwf() {
        this.mzB = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.mzB.setData(this.mve);
        this.mzB.setActivity(this);
    }

    private void dvo() {
        if (this.mName != null && this.lCz != null && this.lCz.getProZone() == 1) {
            this.mName.setText(R.string.write_zone_profession_title);
        }
    }

    private void dwg() {
        String str;
        String str2;
        if (this.lCz != null) {
            switch (this.lCz.getType()) {
                case 0:
                case 9:
                    if (this.mBZ || this.mBn) {
                        if (this.mCb) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.iik != null && this.iik.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                        if (this.mzf) {
                            this.mName.setText(R.string.publish_to_dynamic_title);
                        }
                    } else if (this.iik != null && this.iik.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.lCz.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.lCz.getForumName() + getResources().getString(R.string.bar));
                        this.lCR.setVisibility(8);
                        String str3 = this.hDu + " " + this.hDs;
                        if (!StringUtils.isNull(str3)) {
                            this.mBq.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.lCR.setVisibility(0);
                    this.mBq.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.mBq.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.lCR.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.mBq.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.lCz.getFloorNum() + 1)));
                    this.mCq.setVisibility(8);
                    return;
                case 7:
                    this.lCR.setVisibility(0);
                    this.mBq.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void dwh() {
        if (this.lCz.getType() == 7) {
            this.lCW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.lCW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void dwi() {
        if (this.lCz != null && this.lCz.getType() == 0 && this.lCz.getType() == 9 && !this.mBZ && !this.mBn && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = as.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dwq() != null) {
                dwq().setText(cutStringWithSuffix);
                dwq().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.kqc.setVisibility(0);
            this.kqd.setVoiceModel(voiceModel);
            this.kqd.bFz();
            dhM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNB() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.yw(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.kqc.setVisibility(8);
        this.kqd.cmG();
        this.kqd.setVoiceModel(null);
        com.baidu.tbadk.editortools.l nT = this.eAf.nT(6);
        if (nT != null && nT.ezZ != null) {
            nT.ezZ.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dhM();
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
            this.mBE.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, com.baidu.tieba.frs.bd bdVar) {
                    if (bdVar != null) {
                        WriteActivity.this.mBE.setText(bdVar.name);
                        WriteActivity.this.lCz.setCategoryTo(bdVar.hJP);
                        WriteActivity.this.mBD = bdVar.hJP;
                        WriteActivity.this.mBE.dvJ();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.mBE.dvI();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dwq());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dwp());
                }
            });
        }
    }

    private void dwG() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.mBT = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
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
        if (this.mCL == null) {
            this.mCL = new com.baidu.tieba.c.e(getPageContext(), this.lDa);
            this.mCL.cS(R.drawable.bg_tip_blue_up_left);
            this.mCL.cR(16);
            this.mCL.mP(true);
            this.mCL.setUseDirectOffset(true);
            this.mCL.tr(l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.lCX = (TextView) findViewById(R.id.post_prefix);
        this.mBs = findViewById(R.id.prefix_divider);
        this.lCZ = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.lDa.setVisibility(0);
            this.mCL.z(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.lCA = 0;
            this.lDa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ap("c13013").dn("fid", WriteActivity.this.lCz.getForumId()).t("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.lCX.setVisibility(0);
                    WriteActivity.this.lDa.setSelected(true);
                    ao.setImageResource(WriteActivity.this.lCZ, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.lCY, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.eAf.bhl();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.lCR);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.mBq);
                }
            });
            this.lCX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.26
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ap("c13013").dn("fid", WriteActivity.this.lCz.getForumId()).t("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.lCX.setSelected(true);
                    ao.setImageResource(WriteActivity.this.lCZ, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.lCY, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.eAf.bhl();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dwq());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dwp());
                }
            });
            this.lCY = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.lCY.a(this);
            this.lCY.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.lCY.setOutsideTouchable(true);
            this.lCY.setFocusable(true);
            this.lCY.setOnDismissListener(this);
            this.lCY.setBackgroundDrawable(ao.getDrawable(R.color.cp_bg_line_d));
            int color = ao.getColor(R.color.cp_cont_b);
            ao.getColor(R.color.cp_cont_c);
            ao.setBackgroundResource(this.lCX, R.color.cp_bg_line_d);
            ao.setImageResource(this.lCZ, R.drawable.icon_arrow_gray_down);
            this.lCX.setTextColor(color);
            this.mBt.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.mBt.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.wm(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.wm(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.lCY.addView(writePrefixItemLayout);
            }
            this.lCY.setCurrentIndex(0);
            this.lCX.setText(prefixs.get(0));
            Hp(0);
            return;
        }
        this.lDa.setVisibility(8);
    }

    private void dwH() {
        if (this.mBZ && this.lCz != null) {
            this.mCd.setVisibility(0);
            this.mCe.setVisibility(0);
            this.mBr = new FeedBackModel(getPageContext());
            this.mBr.PV(this.lCz.getForumName());
            this.mBr.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.27
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.mCd.setVisibility(8);
                        WriteActivity.this.mCe.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.mCd.setVisibility(8);
                        WriteActivity.this.mCe.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.mCd.a(feedBackModel.dvN(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void dwm() {
        this.lCW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (WriteActivity.this.mBL.a(WriteActivity.this.lCR, WriteActivity.this.mBq)) {
                        WriteActivity.this.showToast(WriteActivity.this.mBL.duc());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dwq());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dwp());
                    WriteActivity.this.eAf.bhl();
                    if (WriteActivity.this.lCz.getType() != 7) {
                        if (WriteActivity.this.mBZ) {
                            WriteActivity.this.cfA();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            ap apVar = new ap("c12102");
                            apVar.ah("obj_type", StringUtils.isNull(WriteActivity.this.lCz.getForumName()) ? 1 : 2);
                            TiebaStatic.log(apVar);
                            WriteActivity.this.dwv();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.cfA();
                    }
                    MercatorModel.dme().startLoad();
                    TiebaStatic.log(new ap("c12262").dn("obj_locate", WriteActivity.this.iik));
                }
            }
        });
    }

    protected void dhL() {
        this.mCc = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.mCc.setIsRound(true);
        this.mCc.setDrawBorder(false);
        this.mCc.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String xH = com.baidu.tbadk.core.util.q.xH(currentPortrait);
            this.mCc.setUrl(xH);
            this.mCc.startLoad(xH, 12, false);
        }
        if (this.lCz.isUserFeedback()) {
            this.mCc.setVisibility(0);
        }
        this.lCR = (EditText) findViewById(R.id.post_title);
        this.lCR.setOnClickListener(this.mBP);
        this.lCR.setOnFocusChangeListener(this.ggs);
        if (this.lCz.getType() == 0 || this.lCz.getType() == 9 || this.lCz.getType() == 7) {
            if (this.lCz.getTitle() != null) {
                this.lCR.setText(this.lCz.getTitle());
                this.lCR.setSelection(this.lCz.getTitle().length());
            } else if (this.mCb) {
                this.lCR.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.lCz.getType() == 1 || this.lCz.getType() != 2) {
        }
        this.lCR.addTextChangedListener(this.mBR);
        if (!this.lCz.getHaveDraft()) {
            dwi();
            this.mCG = true;
        }
        if (this.lCz.isUserFeedback()) {
            this.lCR.setHint(getResources().getString(R.string.feedback_title_hint));
        } else {
            this.lCR.setHint(getResources().getString(R.string.post_title_hint));
        }
    }

    private TextWatcher agY() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            private int mCV;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.dhM();
                if (WriteActivity.this.mBG) {
                    this.mCV = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.mCV);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.mBG || !WriteActivity.this.mCy) {
                    if (WriteActivity.this.mBG) {
                        if (this.mEditText != WriteActivity.this.mCo || this.mTextView != WriteActivity.this.mCu) {
                            this.mEditText = WriteActivity.this.mCo;
                            this.mTextView = WriteActivity.this.mCu;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.mCs || this.mTextView != WriteActivity.this.mCt) {
                    this.mEditText = WriteActivity.this.mCs;
                    this.mTextView = WriteActivity.this.mCt;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.mBG && this.mCy) {
            if (this.mCw != null) {
                this.mCs.removeTextChangedListener(this.mCw);
            }
            this.mCw = textWatcher;
        } else if (this.mBG) {
            if (this.mCx != null) {
                this.mCo.removeTextChangedListener(this.mCx);
            }
            this.mCx = textWatcher;
        }
        return textWatcher;
    }

    private long j(EditText editText) {
        if (editText == this.mCo) {
            return 233L;
        }
        if (editText != this.mCs) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long j = j(editText);
            long k = j - k(editText);
            String valueOf = String.valueOf(k);
            if (j == 20) {
                if (k < 0) {
                    if (k < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(ao.getColor(R.color.common_color_10159));
                } else {
                    textView.setTextColor(ao.getColor(R.color.cp_cont_d));
                }
            } else if (k < 0) {
                if (k < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(ao.getColor(R.color.common_color_10159));
            } else {
                textView.setTextColor(ao.getColor(R.color.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long k(EditText editText) {
        return com.baidu.tieba.write.c.a.u(editText.getText().toString().trim());
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
            if (this.mBq.getText() != null) {
                this.mBq.setSelection(this.mBq.getText().length());
            }
        } else if (this.lCz.getType() == 2) {
            if (this.mCg) {
                if (this.mCh != null && this.mCh.length() > 0) {
                    this.mBq.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.mCh}));
                    this.mBq.setSelection(this.mBq.getText().length());
                }
            } else if (this.lCz.getFloorNum() > 0) {
                this.mBq.setText(String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.lCz.getFloorNum())));
                this.mBq.setSelection(this.mBq.getText().length());
            }
        }
        this.mBq.setOnFocusChangeListener(this.ggs);
        this.mBq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.30
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.mBq.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.mBq.addTextChangedListener(this.mBS);
        if (this.lCz.getType() == 0) {
            this.mCK = true;
        } else {
            wC(true);
            this.mCK = false;
        }
        if (this.lCz.isUserFeedback()) {
            this.mBq.setHint(R.string.write_input_content);
        } else {
            this.mBq.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void wC(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.mBG && !this.mzf && dwp() != null) {
            dwp().setPadding(0, 0, 0, 0);
            dwp().setBackgroundDrawable(null);
            ao.setBackgroundColor(dwp(), R.color.cp_bg_line_d);
            if (TextUtils.isEmpty(this.jIZ) || this.mBv != null) {
                return;
            }
            if (this.mCM == null || !this.mCM.isVisible()) {
                com.baidu.adp.lib.e.c.ln().a(this.jIZ, 19, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass31) aVar, str, i);
                        if (aVar != null && aVar.getRawBitmap() != null && aVar.getPadding() != null) {
                            if (WriteActivity.this.mCM == null || !WriteActivity.this.mCM.isVisible()) {
                                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                                    ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                                }
                                WriteActivity.this.dwp().setBackgroundDrawable(ninePatchDrawable);
                                if (z) {
                                    com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.dwp(), true, WriteActivity.this.kwL);
                                }
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, true));
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, false));
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    private void dwI() {
        if (dwp() != null) {
            dwp().setPadding(0, 0, 0, 0);
            dwp().setBackgroundDrawable(null);
            ao.setBackgroundColor(dwp(), R.color.cp_bg_line_d);
        }
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wz(boolean z) {
        if (!com.baidu.tbadk.plugins.b.k(getPageContext())) {
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
            this.mBu.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, qVar, dwp());
    }

    EditText dwp() {
        return this.mBG ? this.mCo : this.mBq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dwq() {
        return this.mBG ? this.mCs : this.lCR;
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

    private void q(Boolean bool) {
        String str = null;
        if (this.lCz != null) {
            str = this.lCz.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.mBZ = true;
        }
    }

    private void dwJ() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void dwK() {
        this.mCO = (RelativeLayout) this.mRootView.findViewById(R.id.vote_layout_root);
        this.mCN = new com.baidu.tieba.write.write.vote.a(getPageContext(), this.mCO);
        ap(getIntent());
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

    private Boolean dwL() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                this.mCi = intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true);
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.eBU = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return Boolean.valueOf(this.mCi);
    }

    public void dhM() {
        this.mCP = false;
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
                    if (this.lCA == x.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.lCz.setIsNoTitle(true);
                        } else if (this.mBp.getVisibility() == 0) {
                            this.lCz.setIsNoTitle(false);
                            wA(true);
                            return;
                        }
                    } else if (this.mBp.getVisibility() == 0) {
                        this.lCz.setIsNoTitle(false);
                        wA(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.lCz.setIsNoTitle(true);
                } else if (this.mBp.getVisibility() == 0) {
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
            if (this.lCz.getType() == 4) {
                wA(m(this.mCo) && l(this.mCs));
            } else if (this.lCz.getType() == 5) {
                wA(m(this.mCo));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                wA(true);
            } else if (this.lCz.getVideoInfo() != null) {
                wA(this.lCz.getVideoInfo().isVideoMixFinished());
            } else if (dwY()) {
                wA(true);
                this.mCP = true;
            } else {
                wA(false);
            }
        }
    }

    public void wA(boolean z) {
        this.lCW.setEnabled(z);
    }

    private boolean l(EditText editText) {
        long k = k(editText);
        return k <= 20 && k > 0;
    }

    private boolean m(EditText editText) {
        long k = k(editText);
        if (k > 233) {
            return false;
        }
        return k > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        String str;
        this.eBQ = new NewWriteModel(this);
        this.eBQ.b(this.eCe);
        registerListener(this.mCQ);
        this.hwp = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.dhD();
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
            this.lCz.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.lCz.setFloorNum(bundle.getInt("floor_num", 0));
            this.mBZ = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.mCa = bundle.getBoolean(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.mCb = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.mCg = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.mCh = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.eBO = bundle.getString(WriteActivityConfig.PHOTO_NAME);
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
            this.mCj = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.lCz.setTitle(bundle.getString("write_title"));
            this.lCz.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.lCz.setTopicId(this.mTopicId);
            this.iik = bundle.getString("KEY_CALL_FROM");
            this.biT = bundle.getInt("album_thread");
            this.mve = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.lCz.setVideoInfo((VideoInfo) bundle.getSerializable(WriteVideoActivityConfig.VIDEO_INFO));
            str = string;
        } else {
            Intent intent = getIntent();
            this.lCz.setType(intent.getIntExtra("type", 0));
            this.lCz.setForumId(intent.getStringExtra("forum_id"));
            this.lCz.setForumName(intent.getStringExtra("forum_name"));
            this.lCz.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.lCz.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.lCz.setThreadId(intent.getStringExtra("thread_id"));
            this.lCz.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.lCz.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.mBZ = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.mCa = intent.getBooleanExtra(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.mCb = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.mCg = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.mCh = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.mBv = (AdditionData) intent.getSerializableExtra("addition_data");
            this.lCz.setIsAddition(this.mBv != null);
            this.lCz.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mCj = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.hDt = intent.getStringExtra("more_forum_img");
            this.hDu = intent.getStringExtra("more_forum_title");
            this.hDs = intent.getStringExtra("more_forum_url");
            this.lCz.setTitle(intent.getStringExtra("write_title"));
            this.lCz.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.lCz.setTopicId(this.mTopicId);
            this.iik = intent.getStringExtra("KEY_CALL_FROM");
            this.biT = intent.getIntExtra("album_thread", 0);
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mve = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.lCz.setVideoInfo((VideoInfo) intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO));
            str = stringExtra;
        }
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.lCz.mDynamicImageTextData = new ImageTextUploadData();
            this.mzf = true;
        }
        if (this.lCz.getType() == 9) {
            this.lCz.setEntranceType(1);
        } else if (this.lCz.getType() == 10) {
            this.lCz.setEntranceType(2);
            this.lCz.setType(9);
        } else if (this.lCz.getType() == 0) {
            this.lCz.setEntranceType(3);
        }
        this.lCz.setIsUserFeedback(this.mBZ);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.lCz.getType() == 4 ? 6 : 9);
        this.lCz.setWriteImagesInfo(this.writeImagesInfo);
        if (this.lCz.getType() == 0 || this.lCz.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.mzf) {
                    w.d(this.lCz.getForumId(), this);
                } else {
                    w.c(this.lCz.getForumId(), this);
                }
            }
        } else if (this.lCz.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                w.c("24591571", this);
            }
        } else if (this.lCz.getType() == 1) {
            w.a(this.lCz.getThreadId(), this);
        } else if (this.lCz.getType() == 4) {
            w.c(this.lCz.getForumId() + "photolive", this);
        } else if (this.lCz.getType() == 5) {
            w.a(this.lCz.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.jIZ = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.lCz != null && this.lCz.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.lCz.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.mBn = true;
        }
        dwj();
        try {
            this.mCz = dwU();
        } catch (Throwable th) {
            this.mCz = null;
        }
    }

    private void dws() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) x.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.lCR.setText(com.baidu.tbadk.plugins.b.Ai(com.baidu.tbadk.plugins.b.Aj(hotTopicBussinessData.mTopicName)));
            this.lCR.setMovementMethod(com.baidu.tieba.view.c.dtD());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) x.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString Ai = com.baidu.tbadk.plugins.b.Ai(com.baidu.tbadk.plugins.b.Aj(hotTopicBussinessData.mTopicName));
            if (Ai != null) {
                this.lCR.setText(Ai);
            }
            this.mBI.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.w.a
    public void a(WriteData writeData) {
        int i = 0;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            if (writeData != null) {
                if (this.lCz != null) {
                    boolean z = this.lCz.getVideoInfo() != null && this.lCz.getVideoInfo().isEditVideoDataLegal();
                    boolean z2 = (this.lCz.getWriteImagesInfo() == null || x.isEmpty(this.lCz.getWriteImagesInfo().getChosedFiles())) ? false : true;
                    boolean z3 = !com.baidu.adp.lib.util.k.isEmpty(dwq().getText().toString());
                    boolean z4 = !com.baidu.adp.lib.util.k.isEmpty(dwp().getText().toString());
                    boolean z5 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle());
                    boolean z6 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent());
                    boolean z7 = as.isEmpty(writeData.getTitle()) && !e(TbFaceManager.bkj().a(getPageContext().getPageActivity(), writeData.getContent(), this.mBN));
                    if (!z || z7) {
                        this.lCz.setHaveDraft(true);
                        if (!z2 && !z) {
                            f(writeData);
                        }
                        if (!z && (!z3 || this.mCG || ((this.mBZ || this.mBn) && z5))) {
                            g(writeData);
                        }
                        if (z6 && (!z4 || this.mBZ || this.mBn)) {
                            h(writeData);
                        }
                        if (this.lCz != null && !this.lCz.getHaveDraft()) {
                            dwi();
                        }
                        if (writeData.getType() == 4 || writeData.getType() == 5) {
                            dwM();
                        }
                        dhM();
                        int categoryTo = writeData.getCategoryTo();
                        if (categoryTo >= 0 && this.fDY != null) {
                            this.mBD = this.mBA.hJP;
                            this.mBC = this.mBA.name;
                            while (true) {
                                if (i == this.fDY.size()) {
                                    break;
                                }
                                ad adVar = this.fDY.get(i);
                                if (categoryTo != adVar.hJP) {
                                    i++;
                                } else {
                                    this.mBD = categoryTo;
                                    this.mBC = adVar.name;
                                    this.lCz.setCategoryTo(this.mBD);
                                    break;
                                }
                            }
                            if (this.mBE != null) {
                                this.mBE.setText(this.mBC);
                                this.mBE.setCategoryContainerData(this.fDY, this.mBA, this.mBD);
                            }
                        }
                        this.eAf.bhl();
                        return;
                    }
                    return;
                }
                return;
            }
            dwM();
            dwi();
        }
    }

    private void f(WriteData writeData) {
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(writeData.getVideoInfo());
            this.lCz.setVideoInfo(videoInfo);
            wB(false);
            return;
        }
        if (writeData.getWriteImagesInfo() != null) {
            this.writeImagesInfo = writeData.getWriteImagesInfo();
        }
        this.lCz.setWriteImagesInfo(this.writeImagesInfo);
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            dwx();
        }
        wD(false);
        wB(true);
    }

    private void g(WriteData writeData) {
        String str;
        String Aj;
        if (com.baidu.adp.lib.util.k.isEmpty(this.lCz.getTitle())) {
            this.lCz.setTitle(writeData.getTitle());
        }
        if (!x.isEmpty(this.mList)) {
            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) x.getItem(this.mList, 0);
            if (hotTopicBussinessData == null) {
                str = null;
            } else {
                str = hotTopicBussinessData.mTopicName;
            }
            if (StringUtils.isNull(str)) {
                Aj = this.lCz.getTitle();
            } else {
                Aj = com.baidu.tbadk.plugins.b.Aj(str);
            }
            SpannableString Ai = com.baidu.tbadk.plugins.b.Ai(Aj);
            if (Ai != null) {
                dwq().setText(Ai);
                dwq().setSelection(Ai.length() > Aj.length() ? Aj.length() : Ai.length());
                return;
            }
            return;
        }
        SpannableString Ai2 = com.baidu.tbadk.plugins.b.Ai(this.lCz.getTitle());
        if (Ai2 != null) {
            dwq().setText(Ai2);
            dwq().setSelection(this.lCz.getTitle().length() > Ai2.length() ? Ai2.length() : this.lCz.getTitle().length());
        }
    }

    private void h(WriteData writeData) {
        this.lCz.setContent(writeData.getContent());
        dwp().setText(TbFaceManager.bkj().a(getPageContext().getPageActivity(), this.lCz.getContent(), this.mBN));
        if (dwp().getText() != null) {
            dwp().setSelection(dwp().getText().length());
        }
        if (this.mBG) {
            a(this.mCu, this.mCo);
        }
    }

    private void dwM() {
        if ((!this.mBG || this.mCn != null) && this.mCm != null) {
            this.mCn.b(this.writeImagesInfo);
            dwQ();
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
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.lCz.getFloor());
        bundle.putInt("floor_num", this.lCz.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.mCg);
        if (this.mBZ) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.eBO);
        if (this.mBv != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.mBv));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.mCj);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.iik);
        bundle.putInt("album_thread", this.biT);
        bundle.putInt("private_thread", this.privateThread);
        bundle.putSerializable("tab_list", this.mve);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
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

    private String getContent() {
        return (dwp() == null || dwp().getText() == null) ? "" : dwp().getText().toString();
    }

    private String dwu() {
        if (this.lCz == null || dwq() == null || dwq().getVisibility() != 0 || dwq().getText() == null) {
            return "";
        }
        String obj = dwq().getText().toString();
        if (this.mPrefixData != null && x.getCount(this.mPrefixData.getPrefixs()) > 0 && this.lCA != x.getCount(this.mPrefixData.getPrefixs()) - 1 && this.lCz.getType() != 4 && this.lCX != null && this.lCX.getText() != null) {
            this.lCz.setPostPrefix(this.lCX.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.lCz.getTitle();
        }
        return obj;
    }

    private void PX(String str) {
        if (this.lCz != null && this.mBp != null) {
            if (this.mBp.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.lCz.setIsNoTitle(true);
                    this.lCz.setTitle("");
                    return;
                }
                this.lCz.setIsNoTitle(false);
                this.lCz.setTitle(str);
                return;
            }
            this.lCz.setIsNoTitle(true);
            this.lCz.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfA() {
        if (this.mCM.isVisible() && dwp() != null && dwp().getText() != null) {
            int length = dwp().getText().toString().length();
            if (this.lDa != null && this.lDa.getVisibility() == 0 && this.lCA != x.getCount(this.mPrefixData.getPrefixs()) - 1 && this.lCX != null) {
                length += this.lCX.length();
            }
            if (length > com.baidu.tieba.write.video.b.mzk) {
                PW(String.format(getString(R.string.write_video_title_too_long), Integer.valueOf(com.baidu.tieba.write.video.b.mzk)));
                return;
            }
        }
        dhD();
        this.lCz.setContent(getContent());
        PX(dwu());
        if (this.mBZ || this.mBn) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.lCz.getTitle()) || !this.lCz.getTitle().startsWith(string)) {
                PX(string + this.lCz.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.lCz.getContent()) || !this.lCz.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    sb.append(com.baidu.adp.lib.util.j.netTypeNameInUpperCase());
                } else {
                    sb.append(RomUtils.UNKNOWN);
                }
                sb.append(":");
                sb.append(this.lCz.getContent());
                this.lCz.setContent(sb.toString());
            }
        }
        if (this.mCa) {
            this.lCz.setContent(String.format(getResources().getString(R.string.homepage_test_post_suffix), Build.MODEL, TbadkCoreApplication.getInst().getVersionName(), com.baidu.adp.lib.util.j.netTypeNameInUpperCase(), Build.VERSION.RELEASE) + "\n" + this.lCz.getContent());
        }
        if (this.mBB >= 0) {
            this.lCz.setCategoryFrom(this.mBB);
        }
        if (this.mBD >= 0) {
            this.lCz.setCategoryTo(this.mBD);
        }
        this.lCz.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mCN != null) {
            this.lCz.setWriteVoteData(this.mCN.getWriteVoteData());
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            Iterator<ImageFileInfo> it = this.writeImagesInfo.getChosedFiles().iterator();
            int i = 0;
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.isFromCamera()) {
                    i++;
                }
                i = i;
            }
            this.lCz.setTakePhotoNum(i);
        }
        this.lCz.setHasLocationData(this.eBP != null && this.eBP.bNz());
        if (this.writeImagesInfo != null) {
            this.eBQ.vr(this.writeImagesInfo.size() > 0);
        }
        if (!x.isEmpty(this.mList) && this.mBH != null && this.mBH.mIsGlobalBlock == 0) {
            this.lCz.setForumId(String.valueOf(this.mBH.mForumId));
            this.lCz.setForumName(this.mBH.mForumName);
        }
        dvr();
        this.eBQ.d(this.lCz);
        this.lCz.setContent(this.lCz.getContent().replaceAll("\u0000\n", ""));
        this.lCz.setContent(this.lCz.getContent().replaceAll("\u0000", ""));
        this.lCz.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.eBQ.dhF().setVoice(this.mVoiceModel.getId());
                this.eBQ.dhF().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.eBQ.dhF().setVoice(null);
                this.eBQ.dhF().setVoiceDuringTime(-1);
            }
        } else {
            this.eBQ.dhF().setVoice(null);
            this.eBQ.dhF().setVoiceDuringTime(-1);
        }
        if (!this.eBQ.dmz()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.lCz.mDynamicImageTextData != null) {
            dvq();
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.hwp);
            this.eBQ.dmw();
        }
    }

    private void dvr() {
        FrsTabItemData selectedTabItemData;
        if (this.lCz != null && this.mzB != null && (selectedTabItemData = this.mzB.getSelectedTabItemData()) != null) {
            this.lCz.setTabId(selectedTabItemData.tabId);
            this.lCz.setTabName(selectedTabItemData.name);
            this.lCz.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    public void dvq() {
        if (this.lCz.mDynamicImageTextData != null) {
            showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
            com.baidu.tieba.write.b.a.a(this.lCz, new a.InterfaceC0775a() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                @Override // com.baidu.tieba.write.b.a.InterfaceC0775a
                public void a(BaseUploadData baseUploadData) {
                    com.baidu.tieba.write.b.c.b.dvc().a((ImageTextUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.write.WriteActivity.35.1
                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onSuccess(String str) {
                            WriteActivity.this.cfx();
                            w.e(WriteActivity.this.lCz.getForumId(), (WriteData) null);
                            WriteActivity.this.dwF();
                            com.baidu.tieba.write.b.a.duT();
                            WriteActivity.this.closeLoadingDialog();
                            com.baidu.tieba.tbadkCore.writeModel.c.f(WriteActivity.this.getPageContext().getPageActivity(), null, null, null);
                            WriteActivity.this.iR(true);
                            Intent intent = new Intent();
                            intent.putExtras(new Bundle());
                            WriteActivity.this.setResult(-1, intent);
                            WriteActivity.this.finish();
                        }

                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onFail(String str) {
                            com.baidu.tieba.write.b.a.duT();
                            WriteActivity.this.closeLoadingDialog();
                            if (TextUtils.isEmpty(str)) {
                                str = TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error);
                            }
                            l.showToast(TbadkCoreApplication.getInst(), str);
                        }
                    });
                }

                @Override // com.baidu.tieba.write.b.a.InterfaceC0775a
                public void onError() {
                    WriteActivity.this.closeLoadingDialog();
                    l.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error));
                }
            });
        }
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
                if (this.lCR == getCurrentFocus()) {
                    dwp().clearFocus();
                    this.lCR.requestFocus();
                    if (this.eAf != null) {
                        this.eAf.bhl();
                    }
                    ShowSoftKeyPadDelay(this.lCR);
                } else {
                    dwp().requestFocus();
                    if (this.eAf != null) {
                        this.eAf.bhl();
                    }
                    ShowSoftKeyPadDelay(this.mBq);
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
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                cfx();
                dwF();
                k(postWriteCallBackData2);
                setResult(-1, intent);
                finish();
            } else if (i != 12010 && i != 12009) {
                if (i == 12002) {
                    if (intent != null) {
                        if (intent.getBooleanExtra("finish_self", false)) {
                            setResult(-1, intent);
                            finish();
                            return;
                        }
                        int intExtra = intent.getIntExtra("camera_request_from", 0);
                        if (intent.getBooleanExtra("camera_result", false)) {
                            if (intExtra == 1) {
                                dwR();
                            } else {
                                as(intent);
                            }
                        } else if (intExtra == 1) {
                            at(intent);
                        } else {
                            aq(intent);
                            com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        wB(x.getCount(this.writeImagesInfo.getChosedFiles()) > 0);
                        if (this.mCK) {
                            wC(true);
                            this.mCK = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.mBG) {
                        D(intent);
                        dhM();
                        return;
                    }
                    ar(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.lCz.setVideoInfo(videoInfo);
                        this.eAf.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.eAf.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.eAf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    dhM();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
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
                } else if (i == 25005 && intent != null && !x.isEmpty(this.mList)) {
                    if (!x.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                        this.mBH = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                        a(this.mBH);
                    }
                } else if (i == 25048) {
                    ap(intent);
                } else if (i == 25049 && intent != null) {
                    String str = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT) + " ";
                    int selectionStart = this.mBq.getSelectionStart();
                    int selectionEnd = this.mBq.getSelectionEnd();
                    if (selectionStart >= 0) {
                        Editable text = this.mBq.getText();
                        if (selectionEnd > selectionStart) {
                            text.replace(selectionStart, selectionEnd, str);
                        } else {
                            text.insert(selectionStart, str);
                        }
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.eAf != null && !this.eAf.biL()) {
                this.mBq.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.eAf.bhl();
            }
            switch (i) {
                case 12001:
                    bju();
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    dwP();
                    if (this.mCK) {
                        wC(true);
                        this.mCK = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.lCR == getCurrentFocus()) {
                        dwp().clearFocus();
                        this.lCR.requestFocus();
                        if (this.eAf != null) {
                            this.eAf.bhl();
                        }
                        ShowSoftKeyPadDelay(this.lCR);
                        return;
                    }
                    dwp().requestFocus();
                    if (this.eAf != null) {
                        this.eAf.bhl();
                    }
                    ShowSoftKeyPadDelay(this.mBq);
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
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.eBO = String.valueOf(System.currentTimeMillis());
                    an.c(getPageContext(), this.eBO);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dwP();
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
        dwN();
        this.lCz.setToDynamic(this.isToDynamic);
        this.lCz.setCallFrom(this.iik);
        if (this.lCz.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cfA();
    }

    private void dww() {
        if (this.eAf != null) {
            this.eAf.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void dwN() {
        if (this.eAf != null) {
            this.eAf.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void dwO() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void dwP() {
        if (this.mBG) {
            this.mCn.b(this.writeImagesInfo);
            dwQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwQ() {
        this.mCn.notifyDataSetChanged();
        this.mCm.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.mCn.notifyDataSetChanged();
                WriteActivity.this.mCm.invalidateViews();
            }
        }, 550L);
    }

    public void q(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        dhM();
    }

    private void aq(Intent intent) {
        if (this.mBG) {
            ar(intent);
            dwP();
        } else {
            au(intent);
        }
        dhM();
    }

    private void ar(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            dwP();
            wD(true);
        }
    }

    private void as(Intent intent) {
        if (this.writeImagesInfo != null) {
            C(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, size)));
            }
        }
    }

    private void dwR() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void at(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.mCk.parseJson(stringExtra);
            this.mCk.updateQuality();
            if (this.mCk.getChosedFiles() != null && this.mCk.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.mCk.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.mCk.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dwq());
        HidenSoftKeyPad(this.mInputManager, dwp());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
        if (this.mCM != null) {
            this.mCM.onPause();
        }
        if (this.eAf.biL()) {
            this.eAf.bhl();
        }
    }

    private void au(Intent intent) {
        c(intent, true);
    }

    private void C(Intent intent) {
        this.eBO = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.eBO;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.getEquipmentWidth(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.eBO, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            dwS();
            dwx();
        }
        wD(true);
    }

    private void D(Intent intent) {
        c(intent, false);
    }

    private void c(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                dwS();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    dwx();
                }
            }
            wD(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dwS() {
        if (this.eAf.nT(10) != null) {
            this.eAf.setToolEnabled(this.writeImagesInfo == null || x.getCount(this.writeImagesInfo.getChosedFiles()) < this.writeImagesInfo.getMaxImagesAllowed(), 10);
        }
    }

    private void bju() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.38
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                n.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.eBO));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void dwT() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.hDt)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                o oVar = new o(this, this.hDt, new o.a() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                    @Override // com.baidu.tbadk.util.o.a
                    public void onError(int i, String str) {
                    }

                    @Override // com.baidu.tbadk.util.o.a
                    public void onSuccess(String str) {
                        if (new File(str).exists() && WriteActivity.this.writeImagesInfo != null) {
                            WriteActivity.this.writeImagesInfo.clear();
                            ImageFileInfo imageFileInfo = new ImageFileInfo();
                            imageFileInfo.setFilePath(str);
                            imageFileInfo.isFromMoreForum = true;
                            WriteActivity.this.writeImagesInfo.addChooseFile(imageFileInfo);
                            WriteActivity.this.writeImagesInfo.setMaxImagesAllowed(1);
                            WriteActivity.this.wD(true);
                        }
                    }
                });
                oVar.setFrom(1);
                oVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wD(boolean z) {
        String forumId = this.lCz == null ? "" : this.lCz.getForumId();
        if (this.mCl != null) {
            this.mCl.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.hFy == null) {
            this.hFy = VoiceManager.instance();
        }
        return this.hFy;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cbU() {
        this.hFy = getVoiceManager();
        this.hFy.stopPlay();
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
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.lCz.getType() != 7) {
                if (this.mBv == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
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
        if (!this.mBG) {
            if (this.eAf != null) {
                this.eAf.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.eAf.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.lCz == null ? "" : this.lCz.getForumId();
            if (this.mCl != null) {
                this.mCl.a(this.writeImagesInfo, this.mFrom, forumId);
            }
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
        if (i == x.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new ap("c13014").ah("obj_type", 1));
        } else {
            TiebaStatic.log(new ap("c13014").ah("obj_type", 2));
        }
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
        ao.setImageResource(this.lCZ, R.drawable.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.mBq);
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
            l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
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
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = com.baidu.tbadk.core.util.ad.transformPermissionResult(strArr, iArr);
            if (com.baidu.tbadk.core.util.ad.checkCamera(getApplicationContext())) {
                an.c(getPageContext(), this.eBO);
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.aYm = z;
        if (this.mCE && System.currentTimeMillis() - this.mCF < 800) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.mCE = false;
        }
        if (this.mBK != null && !z) {
            this.mBK.bVC();
        }
        if (this.mBM != null && !z) {
            dwa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PY(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.mCB != null) {
            PZ(str);
            this.mCB.dismiss();
        }
    }

    private void fC(Context context) {
        mCD = l.getEquipmentHeight(context);
    }

    private void PZ(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.mCE = true;
        dwS();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            dwx();
        }
        wD(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [4956=4] */
    private static Bitmap g(String str, float f) {
        Bitmap bitmap;
        Throwable th;
        Bitmap bitmap2 = null;
        int i = (int) f;
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && i > 0) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                int i2 = options.outWidth;
                int i3 = options.outHeight;
                bitmap = BitmapHelper.resizeBitmapAbsolute(str, (Math.max(i2, i3) * i) / Math.min(i2, i3));
            } catch (Exception e) {
                bitmap = null;
            } catch (Throwable th2) {
                bitmap = null;
                th = th2;
            }
            try {
                bitmap2 = BitmapHelper.getResizedBitmap(bitmap, i);
                if (bitmap != null && bitmap != bitmap2 && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                System.gc();
            } catch (Exception e2) {
                if (bitmap != null && bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                System.gc();
                return bitmap2;
            } catch (Throwable th3) {
                th = th3;
                if (bitmap != null && bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                System.gc();
                throw th;
            }
        }
        return bitmap2;
    }

    private File dwU() {
        Cursor query = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{IMConstants.MSG_ROW_ID, "_data", "bucket_display_name", "datetaken", "mime_type"}, null, null, "datetaken DESC");
        if (query == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String name = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getName();
        String name2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getName();
        try {
            query.moveToFirst();
            while (!query.isAfterLast()) {
                String string = query.getString(query.getColumnIndex("_data"));
                File file = new File(string);
                if ((currentTimeMillis - file.lastModified()) / 60000 > 1) {
                    break;
                }
                String upperCase = string.toUpperCase();
                if (upperCase.contains("DCIM/CAMERA") || upperCase.contains("DCIM/100ANDRO") || upperCase.contains("DCIM/100MEDIA") || upperCase.contains("SCREENSHOTS") || upperCase.contains(name.toUpperCase()) || upperCase.contains(name2.toUpperCase())) {
                    return file;
                }
                query.moveToNext();
            }
            return null;
        } finally {
            query.close();
        }
    }

    private void dwV() {
        if (this.mCz != null && this.lCz.getType() == 0 && this.lCz.getType() == 9) {
            fC(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.mCz != null) {
                        WriteActivity.this.PY(WriteActivity.this.mCz.getAbsolutePath());
                    }
                }
            });
            this.mCA = (TbImageView) this.mBubbleView.findViewById(R.id.rec_img_view);
            this.mCC = (LinearLayout) this.mBubbleView.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.aZP().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.mCz.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.aZP().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.mCz.getAbsolutePath());
                Bitmap g = g(this.mCz.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (g != null) {
                    this.mCA.setImageBitmap(g);
                    this.mCA.setDrawBorder(true);
                    this.mCA.setBorderWidth(2);
                    this.mCA.setBorderColor(ao.getColor(R.color.common_color_10264));
                    this.mCB = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.mCB.setCanceledOnTouchOutside(true);
                    this.mCB.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.41
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.mCE) {
                                l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.mCF = System.currentTimeMillis();
                            }
                        }
                    });
                    this.mCB.setContentView(this.mBubbleView);
                    this.mCB.show();
                    Window window = this.mCB.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (mCD / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
                    attributes.width = getResources().getDimensionPixelSize(R.dimen.ds168);
                    attributes.height = getResources().getDimensionPixelSize(R.dimen.ds278);
                    window.setAttributes(attributes);
                }
            }
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
        if (this.mBZ || !x.isEmpty(this.mList) || !StringUtils.isNull(this.lCz.getTitle())) {
            this.mBp.setVisibility(0);
            this.mBp.requestFocus();
            return;
        }
        this.mBp.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwW() {
        if (this.eAf != null) {
            this.eAf.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.42
                @Override // java.lang.Runnable
                public void run() {
                    if (!WriteActivity.this.mzf && WriteActivity.this.eAf != null && WriteActivity.this.eAf.eAi != null) {
                        String clipBoardContent = UtilHelper.getClipBoardContent();
                        if (as.isEmpty(clipBoardContent) || !bd.baV().j(clipBoardContent)) {
                            WriteActivity.this.mBK.cVE();
                            return;
                        }
                        if (WriteActivity.this.mAl == null) {
                            WriteActivity.this.mAl = new FindNewLinkBubbleController(WriteActivity.this.getPageContext(), WriteActivity.this.mCR);
                        }
                        WriteActivity.this.mAl.a(WriteActivity.this.eAf.eAi.nR(31), clipBoardContent, FindNewLinkBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
                    }
                }
            });
        }
    }

    public String getCallFrom() {
        return this.iik;
    }

    public WriteData dhF() {
        return this.lCz;
    }

    public FrsTabInfoData dwX() {
        return this.mve;
    }

    public String getFrom() {
        return this.mFrom;
    }

    private boolean dwY() {
        return (this.mCN == null || this.mCO == null || this.mCN.getWriteVoteData() == null || this.mCO.getVisibility() != 0) ? false : true;
    }
}
