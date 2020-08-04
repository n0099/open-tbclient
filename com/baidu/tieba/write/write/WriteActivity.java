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
    private static int mCF = 0;
    private EditorTools eAf;
    private String eBO;
    private LocationModel eBP;
    private NewWriteModel eBQ;
    List<ad> fDY;
    private String hDs;
    private String hDt;
    private String hDu;
    private VoiceManager hFy;
    private com.baidu.tbadk.core.dialog.i hRL;
    private SaveDraftDialogView hRM;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private LinearLayout kqe;
    private PlayVoiceBntNew kqf;
    private ImageView kqh;
    private int lCC;
    private TextView lCZ;
    private com.baidu.tieba.write.i lDa;
    private ImageView lDb;
    private View lDc;
    private FindNewLinkBubbleController mAn;
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
    private LinearLayout mBq;
    private LinearLayout mBr;
    private View mBu;
    private Toast mBw;
    private AdditionData mBx;
    private RelativeLayout mBy;
    private TextView mBz;
    private View mCJ;
    private View mCK;
    private TextView mCL;
    private com.baidu.tieba.c.e mCN;
    private com.baidu.tieba.write.write.video.a mCO;
    private com.baidu.tieba.write.write.vote.a mCP;
    private RelativeLayout mCQ;
    private boolean mCR;
    private View mCg;
    private g mCn;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    public PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private FrsTabInfoData mvg;
    private ForumTabSelectedView mzD;
    private int privateThread;
    private String mBm = "";
    private boolean mBn = false;
    protected WriteData lCB = null;
    private boolean mCb = false;
    private boolean mCc = false;
    private boolean mBp = false;
    private boolean mCd = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText lCT = null;
    private HeadImageView mCe = null;
    private View lCU = null;
    private LinearLayout lCW = null;
    private SpanGroupEditText mBs = null;
    private FeedBackModel mBt = null;
    private FeedBackTopListView mCf = null;
    private ArrayList<WritePrefixItemLayout> mBv = new ArrayList<>();
    private String jJb = null;
    private final KeyEvent hrA = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView mCh = null;
    private TextView lCY = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener hwp = null;
    private final Handler mHandler = new Handler();
    private boolean mCi = false;
    private String mCj = null;
    private RelativeLayout iQn = null;
    public boolean mCk = true;
    public String eBU = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int eBV = 0;
    private int mCl = 0;
    private WriteImagesInfo mCm = new WriteImagesInfo();
    private View mRootView = null;
    private GridView mCo = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a mCp = null;
    private ScrollView mBH = null;
    private EditText mCq = null;
    private View mCr = null;
    private View mCs = null;
    private View mCt = null;
    private EditText mCu = null;
    private TextView mCw = null;
    private TextView mCx = null;
    private TextWatcher mCy = null;
    private TextWatcher mCz = null;
    private boolean mBI = false;
    private boolean mCA = false;
    private com.baidu.tbadk.core.view.a eJP = null;
    private String mFrom = "write";
    private File mCB = null;
    private TbImageView mCC = null;
    private View mBubbleView = null;
    private Dialog mCD = null;
    private LinearLayout mCE = null;
    private boolean mCG = false;
    private long mCH = -1000;
    private boolean mCI = false;
    private String iim = "2";
    private int biT = 0;
    private String mTopicId = "";
    private SpannableStringBuilder mBL = new SpannableStringBuilder();
    private boolean mCM = false;
    private boolean aYm = false;
    private final b mBN = new b();
    private boolean mzh = false;
    private final HttpMessageListener mCS = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.jJb)) {
                    WriteActivity.this.jJb = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.wC(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.jJb)) {
                    WriteActivity.this.jJb = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.jJb);
                    WriteActivity.this.wC(true);
                }
            }
        }
    };
    private TbFaceManager.a mBP = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
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
    private FindNewLinkBubbleController.a mCT = new FindNewLinkBubbleController.a() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.write.write.FindNewLinkBubbleController.a
        public void f(View view, String str) {
            if (WriteActivity.this.mAn != null) {
                TiebaStatic.log("c13802");
                WriteActivity.this.mAn.KC();
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
            WriteActivity.this.mCU = true;
            if (postWriteCallBackData != null && WriteActivity.this.lCB != null) {
                WriteActivity.this.mBN.aZ(null);
                if (z) {
                    WriteActivity.this.iR(z);
                    if (WriteActivity.this.e(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    WriteActivity.this.cfx();
                    WriteActivity.this.dwG();
                    if ((WriteActivity.this.lCB.getType() == 0 || WriteActivity.this.lCB.getType() == 9) && !x.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                        TiebaStatic.log(new ap("c11731").dn("obj_id", WriteActivity.this.mTopicId));
                    }
                    WriteActivity.this.k(postWriteCallBackData);
                    if (!as.isEmpty(postWriteCallBackData.getVideoid()) && WriteActivity.this.lCB.getVideoInfo() != null) {
                        postWriteCallBackData.mVideoMd5 = WriteActivity.this.lCB.getVideoInfo().getVideoMd5();
                        if (!as.isEmpty(WriteActivity.this.lCB.getForumName())) {
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
                    WriteActivity.this.mBN.aZ(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.mBN.Py(postWriteCallBackData.getErrorString());
                    WriteActivity.this.mBN.b(WriteActivity.this.lCT, WriteActivity.this.mBs);
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
                        if (WriteActivity.this.mCd) {
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
            if (aVar != null && !StringUtils.isNull(aVar.dlL())) {
                WriteActivity.this.a(2, true, aVar.dlL());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener lPE = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.45
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
    private CustomMessageListener mBQ = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.46
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
                WriteActivity.this.dwX();
            }
        }
    };
    private final View.OnClickListener mBR = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dvY = WriteActivity.this.dvY();
            if (dvY >= 0 && dvY < WriteActivity.this.mBs.getText().length()) {
                WriteActivity.this.mBs.setSelection(dvY);
            }
        }
    };
    private boolean mBS = true;
    private final View.OnFocusChangeListener ggs = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.lCT || view == WriteActivity.this.mBack || view == WriteActivity.this.lCY) {
                if (z) {
                    WriteActivity.this.mBS = true;
                    WriteActivity.this.dvZ();
                    l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.lCT);
                    if (WriteActivity.this.eAf != null) {
                        WriteActivity.this.eAf.bhl();
                    }
                } else if (view == WriteActivity.this.lCT) {
                    WriteActivity.this.lCZ.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.mBs && z) {
                WriteActivity.this.mBS = false;
                WriteActivity.this.dvZ();
                l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.mBs);
                if (WriteActivity.this.eAf != null) {
                    WriteActivity.this.eAf.bhl();
                }
            }
            WriteActivity.this.dwe();
        }
    };
    private boolean mCU = false;
    private TextWatcher mBT = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.14
        private String mBX = "";
        private String mBY;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mBY = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.mBY != null ? this.mBY.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dhM();
            WriteActivity.this.dwf();
            EditText dwr = WriteActivity.this.dwr();
            if (editable != null && dwr != null && dwr.getText() != null) {
                if (this.mBX == null || !this.mBX.equals(editable.toString())) {
                    if (WriteActivity.this.mBN != null) {
                        this.mBX = dwr.getText().toString();
                        WriteActivity.this.mBN.b(dwr, true);
                        return;
                    }
                    return;
                }
                dwr.setSelection(dwr.getSelectionEnd());
            }
        }
    };
    private TextWatcher mBU = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.15
        private String mBY;
        private String mBZ = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mBY = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.mBY != null ? this.mBY.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dhM();
            EditText dwq = WriteActivity.this.dwq();
            if (editable != null && dwq != null && dwq.getText() != null) {
                if (this.mBZ == null || !this.mBZ.equals(editable.toString())) {
                    if (WriteActivity.this.mBN != null) {
                        this.mBZ = dwq.getText().toString();
                        WriteActivity.this.mBN.b(dwq, false);
                        return;
                    }
                    return;
                }
                dwq.setSelection(dwq.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0753a kwN = new a.InterfaceC0753a() { // from class: com.baidu.tieba.write.write.WriteActivity.32
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0753a
        public void onRefresh() {
            WriteActivity.this.jJb = null;
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
        } else if (this.eBP.dlS()) {
            bjm();
        } else {
            this.eBP.vp(false);
            a(1, true, (String) null);
            this.eBP.dlQ();
        }
    }

    public void dwA() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
            if (this.mBM != null) {
                this.mBM.duQ();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bjq();
        } else if (this.eBP != null) {
            this.eBP.vp(false);
            a(1, true, (String) null);
            this.eBP.dlQ();
        }
    }

    private void bjq() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ln(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.eBP.dlU();
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
            if (this.mCO != null && this.mCO.isVisible()) {
                this.eAf.setBarLauncherEnabled(false);
                this.eAf.setDeskLauncherEnabled(false);
                this.eAf.setToolEnabled(true, 2);
                if (this.mBM != null) {
                    this.mBM.ws(false);
                    return;
                }
                return;
            }
            this.eAf.setBarLauncherEnabled(!this.mBS);
            this.eAf.setDeskLauncherEnabled(this.mBS ? false : true);
            this.eAf.setToolEnabled(true, 26);
            this.eAf.setToolEnabled(true, 2);
            this.eAf.setToolEnabled(true, 30);
            if (this.mBM != null) {
                this.mBM.ws(true);
            }
            dwT();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.mBI) {
            this.lCT.setVisibility(8);
            if (this.lCB.getType() == 5) {
                this.mCt.setVisibility(8);
            } else {
                this.mCt.setVisibility(0);
            }
            a(this.mCx, this.mCq);
            a(this.mCw, this.mCu);
            dhM();
        }
        if (this.mCb) {
            this.mBS = true;
            dvZ();
            if (this.eAf != null) {
                this.eAf.bhl();
            }
            this.lCT.requestFocus();
            ShowSoftKeyPadDelay(this.lCT);
        }
        if (this.mCO != null) {
            this.mCO.onResume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
        if (this.mCO != null) {
            this.mCO.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
        if (this.mCO != null) {
            this.mCO.onStop();
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
                    dwy();
                }
                wD(true);
            }
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.lCB.setVideoInfo((VideoInfo) serializableExtra);
            } else {
                this.lCB.setVideoInfo(null);
            }
            if (this.mCO == null) {
                this.mCO = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            }
            if (this.lCB.getVideoInfo() != null && this.lCB.getVideoInfo().isEditVideoDataLegal()) {
                wB(false);
                this.mCO.dxI();
                if (this.mBr != null && this.mBr.getVisibility() == 0) {
                    this.mBr.setVisibility(8);
                    if (this.eAf != null) {
                        this.eAf.nQ(30).setName(getResources().getString(R.string.editor_add_title));
                    }
                }
                if (dwq() != null && e(dwq().getText())) {
                    dwq().setText("");
                    this.lCB.setContent("");
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
            this.lCB.setVideoInfo(null);
            this.mCO.setVideoInfo(null);
            this.mCn.dxb().setVisibility(0);
            wC(false);
        } else {
            this.mCO.setVideoInfo(this.lCB.getVideoInfo());
            this.writeImagesInfo.clear();
            this.mCn.dxb().setVisibility(8);
            dwJ();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, false));
        }
        dhM();
        dvZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        if (this.lCB.getType() == 0) {
            Hq(this.biT);
        }
        initUI();
        dwI();
        this.eBP = new LocationModel(getPageContext());
        this.eBP.a(this.eCc);
        registerListener(this.lPE);
        registerListener(this.mBQ);
        registerListener(this.mBackgroundListener);
        cFt();
        dwW();
        if (this.mBI) {
            this.mCp.setEditorTools(this.eAf);
        } else {
            this.mBs.requestFocus();
        }
        dcK();
        dwy();
        dwU();
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
        switch (this.lCB.getType()) {
            case 4:
            case 5:
                dwD();
                break;
            default:
                dwa();
                break;
        }
        this.eAf.build();
        if (this.mBq != null) {
            this.mBq.addView(this.eAf);
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
        if (!this.mzh) {
            dwc();
        }
        dwX();
    }

    private void dwB() {
        this.mCr = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.mCt = this.mCr.findViewById(R.id.live_post_title_container);
        this.mCq = (EditText) this.mCr.findViewById(R.id.live_post_content);
        this.mCo = (GridView) this.mCr.findViewById(R.id.photoLiveGridView);
        this.mCu = (EditText) this.mCr.findViewById(R.id.live_post_title);
        this.mCw = (TextView) this.mCr.findViewById(R.id.titleOverPlusNumber);
        this.mCx = (TextView) this.mCr.findViewById(R.id.contentOverPlusNumber);
        this.mCs = this.mCr.findViewById(R.id.live_interval_view);
        this.mCw.setText(String.valueOf(20));
        this.mCx.setText(String.valueOf(233));
        this.mCr.setVisibility(0);
        this.mCw.setVisibility(0);
        this.mCx.setVisibility(0);
        this.mCu.setHint(R.string.tips_title_limit_new);
        this.mCu.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.mCA = true;
                    WriteActivity.this.mBS = true;
                    WriteActivity.this.dvZ();
                    if (WriteActivity.this.eAf != null) {
                        WriteActivity.this.eAf.bhl();
                    }
                }
            }
        });
        if (this.lCB.getType() == 4) {
            this.mCq.setHint(R.string.live_write_input_content_new);
        } else if (this.lCB.getType() == 5) {
            this.mCq.setHint(R.string.live_write_input_content_update);
        }
        this.mCq.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.mCA = false;
                    WriteActivity.this.mBS = false;
                    WriteActivity.this.dvZ();
                    if (WriteActivity.this.eAf != null) {
                        WriteActivity.this.eAf.bhl();
                    }
                }
            }
        });
        this.mCq.requestFocus();
        this.mCq.addTextChangedListener(agY());
        this.mCu.requestFocus();
        this.mCu.addTextChangedListener(agY());
        this.mCu.setOnClickListener(this.mBR);
        this.mCq.setOnClickListener(this.mBR);
        this.mCp = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.mCo);
        this.mCp.Hk(6);
        this.mCo.setAdapter((ListAdapter) this.mCp);
        View findViewById = this.mCr.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.9
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void dvI() {
                WriteActivity.this.dwR();
            }
        });
        dwC();
    }

    private void dwC() {
        if (this.lCB.getType() == 0) {
            if (this.lCB.getTitle() != null) {
                this.mCu.setText(this.lCB.getTitle());
                this.mCu.setSelection(this.lCB.getTitle().length());
                return;
            }
            return;
        }
        if (this.lCB.getType() == 1 || this.lCB.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.mBI) {
            dwP();
        }
        if (this.eAf.biL()) {
            this.eAf.bhl();
        }
        Hq(0);
    }

    public boolean duF() {
        return (!"1".equals(this.iim) && this.writeImagesInfo.size() == 0 && this.mVoiceModel == null && ((this.mBr == null || this.mBr.getVisibility() != 0) && ((this.mBs == null || !this.mBs.bcV()) && !dwZ()))) && (dwq() == null || !e(dwq().getText()));
    }

    private boolean e(Spannable spannable) {
        if (spannable != null) {
            ImageSpan[] imageSpanArr = (ImageSpan[]) spannable.getSpans(0, spannable.length(), ImageSpan.class);
            if (imageSpanArr != null && imageSpanArr.length > 0) {
                return true;
            }
            if (this.mBN != null) {
                if (this.mBN.d(spannable)) {
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
        if (this.writeImagesInfo != null && this.lCB != null) {
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.lCB.getForumId());
            albumFloatActivityConfig.getIntent().putExtra("forum_name", this.lCB.getForumName());
            albumFloatActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumFloatActivityConfig.setAlbumThread(i);
            albumFloatActivityConfig.setCanSelectVideo(duF());
            albumFloatActivityConfig.setFromWrite(true);
            albumFloatActivityConfig.setCallFrom(this.iim);
            albumFloatActivityConfig.setProfessionZone(this.lCB.getProZone());
            albumFloatActivityConfig.setFrsTabInfo(this.mvg);
            AntiData antiData = new AntiData();
            antiData.voice_message = this.eBU;
            antiData.setIfVoice(this.mCk);
            albumFloatActivityConfig.setExtraData(antiData, this.mPrefixData, this.lCB.getFirstDir(), this.lCB.getSecondDir());
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
        }
    }

    private void dwD() {
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

    private void dwa() {
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
        if (!this.mzh) {
            Boolean dwM = dwM();
            if (!this.mCb && dwM != null && dwM.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.dmw() && s.d(this.lCB.getForumName(), true) && (runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar4 = (com.baidu.tbadk.editortools.l) runTask4.getData()) != null) {
                lVar4.eAR = 2;
                if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    this.eAf.b(lVar4);
                }
            }
        }
        if (!this.mzh && (runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar3 = (com.baidu.tbadk.editortools.l) runTask3.getData()) != null) {
            lVar3.eAR = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.eAf.b(lVar3);
            }
        }
        if (!this.mzh) {
            this.eAf.b(new com.baidu.tbadk.editortools.k(getActivity(), 6));
        }
        if (!this.mzh) {
            this.eAf.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 7));
        } else {
            this.eAf.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        }
        if (as.equals(this.iim, "2")) {
            this.eAf.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 3));
            this.eAf.b(new com.baidu.tbadk.editortools.e.a(getActivity(), 8));
        }
        if (!this.mzh && (runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar2 = (com.baidu.tbadk.editortools.l) runTask2.getData()) != null) {
            lVar2.eAT = true;
            lVar2.eAR = 9;
            lVar2.eAM = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.eAf.b(lVar2);
            }
        }
        if (!this.mzh && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar.eAT = true;
            lVar.eAR = 10;
            lVar.eAM = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.eAf.b(lVar);
            }
        }
        if (!this.mzh && this.mBx == null) {
            if (this.mBM == null) {
                this.mBM = new com.baidu.tieba.write.editor.b(getActivity(), this.iim);
                this.mBM.bH(this.lCB.getForumId(), this.privateThread);
                this.mBM.wr(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.mBM.duO();
                this.mBM.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                dwA();
            }
            if (!x.isEmpty(this.mList)) {
                this.mBM.duO();
            }
            this.eAf.b(this.mBM);
        }
        this.eAf.bc(arrayList);
        com.baidu.tbadk.editortools.l nT = this.eAf.nT(5);
        if (nT != null) {
            nT.eAR = 4;
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

    private void czf() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.10
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                VideoInfo videoInfo;
                WriteVoteData writeVoteData = null;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        TiebaStatic.log(new ap("c12612").ah("obj_locate", 9));
                        if (WriteActivity.this.dwp()) {
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
                            } else if (WriteActivity.this.dwp()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(qVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.dws();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.f((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.cNB();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.dwT();
                        WriteActivity.this.dhM();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.Hr(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.mBx == null) {
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
                            WriteActivity.this.jJb = null;
                        } else {
                            WriteActivity.this.jJb = (String) aVar.data;
                        }
                        WriteActivity.this.wC(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        ap apVar = new ap("c10645");
                        apVar.dn("fid", WriteActivity.this.lCB != null ? WriteActivity.this.lCB.getForumId() : "");
                        TiebaStatic.log(apVar);
                        if (WriteActivity.this.lCB == null || (videoInfo = WriteActivity.this.lCB.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
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
                        WriteActivity.this.lCB.setVideoInfo(null);
                        WriteActivity.this.dhM();
                        if (WriteActivity.this.mBs != null) {
                            WriteActivity.this.mBs.requestFocus();
                        }
                        WriteActivity.this.eAf.bhl();
                        WriteActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.mBs);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new ap("c12612").ah("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.mBn = true;
                        WriteActivity.this.wz(true);
                        if (!WriteActivity.this.dwr().isFocused() || WriteActivity.this.mBr.getVisibility() != 0) {
                            WriteActivity.this.mBm = "from_content";
                        } else {
                            WriteActivity.this.mBm = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        TiebaStatic.log(new ap("c12612").ah("obj_locate", 8));
                        if (WriteActivity.this.mBr.getVisibility() == 0) {
                            if (WriteActivity.this.mBr.hasFocus()) {
                                WriteActivity.this.mBs.requestFocus();
                                WriteActivity.this.mBs.setSelection(WriteActivity.this.mBs.getText().toString().length());
                            }
                            WriteActivity.this.mBr.setVisibility(8);
                            WriteActivity.this.eAf.nQ(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.mBr.setVisibility(0);
                            WriteActivity.this.mBr.requestFocus();
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
                                if (WriteActivity.this.mCP != null && WriteActivity.this.mCP.getWriteVoteData() != null) {
                                    writeVoteData = WriteActivity.this.mCP.getWriteVoteData();
                                }
                                WriteActivity.this.a(writeVoteData);
                                TiebaStatic.log(new ap("c13800").ah("obj_source", 2));
                                return;
                            }
                            WriteActivity.this.showToast(String.format(WriteActivity.this.getResources().getString(R.string.vote_level_tip), Integer.valueOf(intExtra)));
                        }
                    } else if (aVar.code == 21) {
                        if (WriteActivity.this.mAn != null) {
                            WriteActivity.this.mAn.KC();
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
                this.mCP.an(onClickListener);
                this.mCP.setOnItemClickListener(onClickListener);
                this.mCP.b(writeVoteData);
                this.mCP.wF(true);
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
        if (this.mCO != null) {
            this.mCO.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dwb();
        TiebaPrepareImageService.StopService();
        dhD();
        if (!this.mCU) {
            dwE();
        }
        com.baidu.adp.lib.f.g.dismissDialog(this.hRL, this);
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mCn != null) {
            this.mCn.destroy();
        }
        if (this.mCN != null) {
            this.mCN.HN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwE() {
        if (this.lCB != null && this.lCB.getType() == 2 && this.mCi) {
            finish();
        } else if (this.lCB == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.lCB.setTitle(dwr().getText().toString());
            this.lCB.setContent(dwq().getText().toString());
            int type = this.lCB.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    if (this.mzh) {
                        w.e(this.lCB.getForumId(), this.lCB);
                    } else {
                        w.d(this.lCB.getForumId(), this.lCB);
                    }
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    w.d("24591571", this.lCB);
                }
            } else if (type == 1) {
                w.f(this.lCB.getThreadId(), this.lCB);
            } else if (type == 4) {
                w.d(this.lCB.getForumId() + "photolive", this.lCB);
            } else if (type == 5) {
                w.f(this.lCB.getThreadId() + "updatephotolive", this.lCB);
            }
            this.mCU = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwF() {
        if (this.lCY == null || !this.lCY.isEnabled() || this.mCR) {
            cfx();
            dwG();
            setResult(100);
            finish();
            return;
        }
        if (this.hRM == null) {
            this.hRM = new SaveDraftDialogView(this);
            this.hRM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            WriteActivity.this.cfx();
                            WriteActivity.this.dwG();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            WriteActivity.this.dwE();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        }
                        WriteActivity.this.hRL.dismiss();
                    }
                }
            });
        }
        if (this.hRL == null) {
            this.hRL = new com.baidu.tbadk.core.dialog.i(getPageContext());
            this.hRL.setContentView(this.hRM);
        }
        boolean z = (this.mCO == null || !this.mCO.isVisible() || this.lCB == null || this.lCB.getVideoInfo() == null || this.lCB.getVideoInfo().isVideoMixFinished()) ? false : true;
        this.hRM.setText(getString(z ? R.string.write_save_draft_dialog_video_fail_title : R.string.write_save_draft_dialog_normal_title), z ? getString(R.string.write_save_draft_dialog_video_fail_sub_title) : null, getString(z ? R.string.write_save_draft_dialog_video_fail_save_text : R.string.save));
        this.hRL.showDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfx() {
        if (this.lCB.getType() == 0 || this.lCB.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.mzh) {
                    w.e(this.lCB.getForumId(), (WriteData) null);
                } else {
                    w.d(this.lCB.getForumId(), (WriteData) null);
                }
            }
        } else if (this.lCB.getType() == 1) {
            w.f(this.lCB.getThreadId(), (WriteData) null);
        }
        this.mCU = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwG() {
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.mbP));
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
                dwF();
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
        getLayoutMode().onModeChanged(this.mCE);
        ao.setBackgroundColor(this.iQn, R.color.cp_bg_line_e);
        if (this.mCC != null && (i == 1 || i == 4)) {
            this.mCC.setBorderColor(ao.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.baR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.lCY.setTextColor(ao.lO(R.color.cp_link_tip_a));
        dvZ();
        ao.setBackgroundColor(this.lCU, R.color.cp_bg_line_c);
        ao.setBackgroundColor(this.mCs, R.color.cp_bg_line_c);
        ao.setBackgroundColor(dwr(), R.color.cp_bg_line_e);
        ao.setImageResource(this.kqh, R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.jJb)) {
            ao.setBackgroundColor(dwq(), R.color.cp_bg_line_e);
        }
        dhM();
        this.eAf.onChangeSkinType(i);
        if (this.mBG != null) {
            this.mBG.bci();
        }
        ao.setViewTextColor(this.mName, R.color.cp_cont_b);
        this.mCn.mDs.notifyDataSetChanged();
        dwe();
        dwf();
        wC(false);
        if (this.mBN != null) {
            this.mBN.c(dwr(), dwq());
        }
        if (this.mzD != null) {
            this.mzD.onChangeSkinType(i);
        }
        if (this.mCO != null) {
            this.mCO.changeSkin();
        }
        if (this.mCP != null) {
            this.mCP.onChangeSkinType(i);
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
        if (this.lCT != null && this.lCT.getText() != null && this.lCT.getText().toString() != null && this.lCT.getPaint() != null) {
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
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ao.setViewTextColor(this.mName, R.color.cp_cont_b);
        this.mCh = (TextView) findViewById(R.id.btn_image_problem);
        dwi();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lCY.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.lCY.setLayoutParams(layoutParams);
        this.lCY.setOnFocusChangeListener(this.ggs);
        this.mBH = (ScrollView) findViewById(R.id.write_scrollview);
        this.mBH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.mBs != null) {
                        l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.mBs);
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
        this.mCf = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.mCg = findViewById(R.id.feedback_divider);
        this.iQn = (RelativeLayout) findViewById(R.id.parent);
        this.mBq = (LinearLayout) findViewById(R.id.tool_view);
        this.mBq.setContentDescription(IStringUtil.TOP_PATH);
        this.mBr = (LinearLayout) findViewById(R.id.title_view);
        this.lCU = findViewById(R.id.interval_view);
        this.mCJ = findViewById(R.id.hot_topic_fourm_view);
        this.mCK = findViewById(R.id.hot_topic_divider);
        this.mBK = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.mCL = (TextView) findViewById(R.id.change_one_tv);
        dhL();
        if (this.mBI) {
            this.mBH.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            dwB();
        } else {
            this.mCn = new g(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.mCn.wp(false);
            } else {
                this.mCn.wp(this.lCB.getType() == 0 || this.lCB.getType() == 9);
            }
            this.mCO = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            if (this.lCB.getVideoInfo() != null && this.lCB.getVideoInfo().isEditVideoDataLegal()) {
                wB(false);
                this.mCO.dxI();
            } else {
                wB(true);
            }
        }
        dhN();
        if (this.mCb || this.mBp) {
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
        this.lCW = (LinearLayout) findViewById(R.id.post_content_container);
        this.lCW.setDrawingCacheEnabled(false);
        this.lCW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.mBs.requestFocus();
            }
        });
        this.kqe = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.kqf = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.kqh = (ImageView) findViewById(R.id.iv_delete_voice);
        this.kqh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
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
                WriteActivity.this.dwF();
            }
        });
        this.mCh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        dwl();
        q(dwM());
        dwn();
        dwh();
        dwK();
        dvZ();
        dwm();
        dhK();
        dwt();
        if (this.lCB.getType() == 4 && this.lDc != null && this.mBu != null) {
            this.lDc.setVisibility(8);
            this.mBu.setVisibility(8);
        }
        dhM();
        dwH();
        dvp();
        dwg();
        dwL();
    }

    private void dwg() {
        this.mzD = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.mzD.setData(this.mvg);
        this.mzD.setActivity(this);
    }

    private void dvp() {
        if (this.mName != null && this.lCB != null && this.lCB.getProZone() == 1) {
            this.mName.setText(R.string.write_zone_profession_title);
        }
    }

    private void dwh() {
        String str;
        String str2;
        if (this.lCB != null) {
            switch (this.lCB.getType()) {
                case 0:
                case 9:
                    if (this.mCb || this.mBp) {
                        if (this.mCd) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.iim != null && this.iim.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                        if (this.mzh) {
                            this.mName.setText(R.string.publish_to_dynamic_title);
                        }
                    } else if (this.iim != null && this.iim.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.lCB.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.lCB.getForumName() + getResources().getString(R.string.bar));
                        this.lCT.setVisibility(8);
                        String str3 = this.hDu + " " + this.hDs;
                        if (!StringUtils.isNull(str3)) {
                            this.mBs.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.lCT.setVisibility(0);
                    this.mBs.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.mBs.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.lCT.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.mBs.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.lCB.getFloorNum() + 1)));
                    this.mCs.setVisibility(8);
                    return;
                case 7:
                    this.lCT.setVisibility(0);
                    this.mBs.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void dwi() {
        if (this.lCB.getType() == 7) {
            this.lCY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.lCY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void dwj() {
        if (this.lCB != null && this.lCB.getType() == 0 && this.lCB.getType() == 9 && !this.mCb && !this.mBp && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = as.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dwr() != null) {
                dwr().setText(cutStringWithSuffix);
                dwr().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.kqe.setVisibility(0);
            this.kqf.setVoiceModel(voiceModel);
            this.kqf.bFz();
            dhM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNB() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.yw(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.kqe.setVisibility(8);
        this.kqf.cmG();
        this.kqf.setVoiceModel(null);
        com.baidu.tbadk.editortools.l nT = this.eAf.nT(6);
        if (nT != null && nT.ezZ != null) {
            nT.ezZ.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dhM();
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
            this.mBG.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, com.baidu.tieba.frs.bd bdVar) {
                    if (bdVar != null) {
                        WriteActivity.this.mBG.setText(bdVar.name);
                        WriteActivity.this.lCB.setCategoryTo(bdVar.hJP);
                        WriteActivity.this.mBF = bdVar.hJP;
                        WriteActivity.this.mBG.dvK();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.mBG.dvJ();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dwr());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dwq());
                }
            });
        }
    }

    private void dwH() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.mBV = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
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
        if (this.mCN == null) {
            this.mCN = new com.baidu.tieba.c.e(getPageContext(), this.lDc);
            this.mCN.cS(R.drawable.bg_tip_blue_up_left);
            this.mCN.cR(16);
            this.mCN.mP(true);
            this.mCN.setUseDirectOffset(true);
            this.mCN.tr(l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.lCZ = (TextView) findViewById(R.id.post_prefix);
        this.mBu = findViewById(R.id.prefix_divider);
        this.lDb = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.lDc.setVisibility(0);
            this.mCN.z(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.lCC = 0;
            this.lDc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ap("c13013").dn("fid", WriteActivity.this.lCB.getForumId()).t("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.lCZ.setVisibility(0);
                    WriteActivity.this.lDc.setSelected(true);
                    ao.setImageResource(WriteActivity.this.lDb, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.lDa, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.eAf.bhl();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.lCT);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.mBs);
                }
            });
            this.lCZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.26
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ap("c13013").dn("fid", WriteActivity.this.lCB.getForumId()).t("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.lCZ.setSelected(true);
                    ao.setImageResource(WriteActivity.this.lDb, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.lDa, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.eAf.bhl();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dwr());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dwq());
                }
            });
            this.lDa = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.lDa.a(this);
            this.lDa.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.lDa.setOutsideTouchable(true);
            this.lDa.setFocusable(true);
            this.lDa.setOnDismissListener(this);
            this.lDa.setBackgroundDrawable(ao.getDrawable(R.color.cp_bg_line_d));
            int color = ao.getColor(R.color.cp_cont_b);
            ao.getColor(R.color.cp_cont_c);
            ao.setBackgroundResource(this.lCZ, R.color.cp_bg_line_d);
            ao.setImageResource(this.lDb, R.drawable.icon_arrow_gray_down);
            this.lCZ.setTextColor(color);
            this.mBv.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.mBv.add(writePrefixItemLayout);
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
                this.lDa.addView(writePrefixItemLayout);
            }
            this.lDa.setCurrentIndex(0);
            this.lCZ.setText(prefixs.get(0));
            Hp(0);
            return;
        }
        this.lDc.setVisibility(8);
    }

    private void dwI() {
        if (this.mCb && this.lCB != null) {
            this.mCf.setVisibility(0);
            this.mCg.setVisibility(0);
            this.mBt = new FeedBackModel(getPageContext());
            this.mBt.PV(this.lCB.getForumName());
            this.mBt.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.27
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.mCf.setVisibility(8);
                        WriteActivity.this.mCg.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.mCf.setVisibility(8);
                        WriteActivity.this.mCg.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.mCf.a(feedBackModel.dvO(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void dwn() {
        this.lCY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (WriteActivity.this.mBN.a(WriteActivity.this.lCT, WriteActivity.this.mBs)) {
                        WriteActivity.this.showToast(WriteActivity.this.mBN.dud());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dwr());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dwq());
                    WriteActivity.this.eAf.bhl();
                    if (WriteActivity.this.lCB.getType() != 7) {
                        if (WriteActivity.this.mCb) {
                            WriteActivity.this.cfA();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            ap apVar = new ap("c12102");
                            apVar.ah("obj_type", StringUtils.isNull(WriteActivity.this.lCB.getForumName()) ? 1 : 2);
                            TiebaStatic.log(apVar);
                            WriteActivity.this.dww();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.cfA();
                    }
                    MercatorModel.dmf().startLoad();
                    TiebaStatic.log(new ap("c12262").dn("obj_locate", WriteActivity.this.iim));
                }
            }
        });
    }

    protected void dhL() {
        this.mCe = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.mCe.setIsRound(true);
        this.mCe.setDrawBorder(false);
        this.mCe.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String xH = com.baidu.tbadk.core.util.q.xH(currentPortrait);
            this.mCe.setUrl(xH);
            this.mCe.startLoad(xH, 12, false);
        }
        if (this.lCB.isUserFeedback()) {
            this.mCe.setVisibility(0);
        }
        this.lCT = (EditText) findViewById(R.id.post_title);
        this.lCT.setOnClickListener(this.mBR);
        this.lCT.setOnFocusChangeListener(this.ggs);
        if (this.lCB.getType() == 0 || this.lCB.getType() == 9 || this.lCB.getType() == 7) {
            if (this.lCB.getTitle() != null) {
                this.lCT.setText(this.lCB.getTitle());
                this.lCT.setSelection(this.lCB.getTitle().length());
            } else if (this.mCd) {
                this.lCT.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.lCB.getType() == 1 || this.lCB.getType() != 2) {
        }
        this.lCT.addTextChangedListener(this.mBT);
        if (!this.lCB.getHaveDraft()) {
            dwj();
            this.mCI = true;
        }
        if (this.lCB.isUserFeedback()) {
            this.lCT.setHint(getResources().getString(R.string.feedback_title_hint));
        } else {
            this.lCT.setHint(getResources().getString(R.string.post_title_hint));
        }
    }

    private TextWatcher agY() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            private int mCX;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.dhM();
                if (WriteActivity.this.mBI) {
                    this.mCX = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.mCX);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.mBI || !WriteActivity.this.mCA) {
                    if (WriteActivity.this.mBI) {
                        if (this.mEditText != WriteActivity.this.mCq || this.mTextView != WriteActivity.this.mCx) {
                            this.mEditText = WriteActivity.this.mCq;
                            this.mTextView = WriteActivity.this.mCx;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.mCu || this.mTextView != WriteActivity.this.mCw) {
                    this.mEditText = WriteActivity.this.mCu;
                    this.mTextView = WriteActivity.this.mCw;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.mBI && this.mCA) {
            if (this.mCy != null) {
                this.mCu.removeTextChangedListener(this.mCy);
            }
            this.mCy = textWatcher;
        } else if (this.mBI) {
            if (this.mCz != null) {
                this.mCq.removeTextChangedListener(this.mCz);
            }
            this.mCz = textWatcher;
        }
        return textWatcher;
    }

    private long j(EditText editText) {
        if (editText == this.mCq) {
            return 233L;
        }
        if (editText != this.mCu) {
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
            if (this.mBs.getText() != null) {
                this.mBs.setSelection(this.mBs.getText().length());
            }
        } else if (this.lCB.getType() == 2) {
            if (this.mCi) {
                if (this.mCj != null && this.mCj.length() > 0) {
                    this.mBs.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.mCj}));
                    this.mBs.setSelection(this.mBs.getText().length());
                }
            } else if (this.lCB.getFloorNum() > 0) {
                this.mBs.setText(String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.lCB.getFloorNum())));
                this.mBs.setSelection(this.mBs.getText().length());
            }
        }
        this.mBs.setOnFocusChangeListener(this.ggs);
        this.mBs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.30
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.eAf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.mBs.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.mBs.addTextChangedListener(this.mBU);
        if (this.lCB.getType() == 0) {
            this.mCM = true;
        } else {
            wC(true);
            this.mCM = false;
        }
        if (this.lCB.isUserFeedback()) {
            this.mBs.setHint(R.string.write_input_content);
        } else {
            this.mBs.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void wC(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.mBI && !this.mzh && dwq() != null) {
            dwq().setPadding(0, 0, 0, 0);
            dwq().setBackgroundDrawable(null);
            ao.setBackgroundColor(dwq(), R.color.cp_bg_line_d);
            if (TextUtils.isEmpty(this.jJb) || this.mBx != null) {
                return;
            }
            if (this.mCO == null || !this.mCO.isVisible()) {
                com.baidu.adp.lib.e.c.ln().a(this.jJb, 19, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass31) aVar, str, i);
                        if (aVar != null && aVar.getRawBitmap() != null && aVar.getPadding() != null) {
                            if (WriteActivity.this.mCO == null || !WriteActivity.this.mCO.isVisible()) {
                                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                                    ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                                }
                                WriteActivity.this.dwq().setBackgroundDrawable(ninePatchDrawable);
                                if (z) {
                                    com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.dwq(), true, WriteActivity.this.kwN);
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

    private void dwJ() {
        if (dwq() != null) {
            dwq().setPadding(0, 0, 0, 0);
            dwq().setBackgroundDrawable(null);
            ao.setBackgroundColor(dwq(), R.color.cp_bg_line_d);
        }
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wz(boolean z) {
        if (!com.baidu.tbadk.plugins.b.k(getPageContext())) {
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
            this.mBw.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, qVar, dwq());
    }

    EditText dwq() {
        return this.mBI ? this.mCq : this.mBs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dwr() {
        return this.mBI ? this.mCu : this.lCT;
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

    private void q(Boolean bool) {
        String str = null;
        if (this.lCB != null) {
            str = this.lCB.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.mCb = true;
        }
    }

    private void dwK() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void dwL() {
        this.mCQ = (RelativeLayout) this.mRootView.findViewById(R.id.vote_layout_root);
        this.mCP = new com.baidu.tieba.write.write.vote.a(getPageContext(), this.mCQ);
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

    private Boolean dwM() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                this.mCk = intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true);
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.eBU = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return Boolean.valueOf(this.mCk);
    }

    public void dhM() {
        this.mCR = false;
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
                    if (this.lCC == x.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.lCB.setIsNoTitle(true);
                        } else if (this.mBr.getVisibility() == 0) {
                            this.lCB.setIsNoTitle(false);
                            wA(true);
                            return;
                        }
                    } else if (this.mBr.getVisibility() == 0) {
                        this.lCB.setIsNoTitle(false);
                        wA(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.lCB.setIsNoTitle(true);
                } else if (this.mBr.getVisibility() == 0) {
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
            if (this.lCB.getType() == 4) {
                wA(m(this.mCq) && l(this.mCu));
            } else if (this.lCB.getType() == 5) {
                wA(m(this.mCq));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                wA(true);
            } else if (this.lCB.getVideoInfo() != null) {
                wA(this.lCB.getVideoInfo().isVideoMixFinished());
            } else if (dwZ()) {
                wA(true);
                this.mCR = true;
            } else {
                wA(false);
            }
        }
    }

    public void wA(boolean z) {
        this.lCY.setEnabled(z);
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
        registerListener(this.mCS);
        this.hwp = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.dhD();
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
            this.lCB.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.lCB.setFloorNum(bundle.getInt("floor_num", 0));
            this.mCb = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.mCc = bundle.getBoolean(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.mCd = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.mCi = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.mCj = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.eBO = bundle.getString(WriteActivityConfig.PHOTO_NAME);
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
            this.mCl = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.lCB.setTitle(bundle.getString("write_title"));
            this.lCB.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.lCB.setTopicId(this.mTopicId);
            this.iim = bundle.getString("KEY_CALL_FROM");
            this.biT = bundle.getInt("album_thread");
            this.mvg = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.lCB.setVideoInfo((VideoInfo) bundle.getSerializable(WriteVideoActivityConfig.VIDEO_INFO));
            str = string;
        } else {
            Intent intent = getIntent();
            this.lCB.setType(intent.getIntExtra("type", 0));
            this.lCB.setForumId(intent.getStringExtra("forum_id"));
            this.lCB.setForumName(intent.getStringExtra("forum_name"));
            this.lCB.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.lCB.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.lCB.setThreadId(intent.getStringExtra("thread_id"));
            this.lCB.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.lCB.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.mCb = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.mCc = intent.getBooleanExtra(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.mCd = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.mCi = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.mCj = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.mBx = (AdditionData) intent.getSerializableExtra("addition_data");
            this.lCB.setIsAddition(this.mBx != null);
            this.lCB.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mCl = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.hDt = intent.getStringExtra("more_forum_img");
            this.hDu = intent.getStringExtra("more_forum_title");
            this.hDs = intent.getStringExtra("more_forum_url");
            this.lCB.setTitle(intent.getStringExtra("write_title"));
            this.lCB.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.lCB.setTopicId(this.mTopicId);
            this.iim = intent.getStringExtra("KEY_CALL_FROM");
            this.biT = intent.getIntExtra("album_thread", 0);
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mvg = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.lCB.setVideoInfo((VideoInfo) intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO));
            str = stringExtra;
        }
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.lCB.mDynamicImageTextData = new ImageTextUploadData();
            this.mzh = true;
        }
        if (this.lCB.getType() == 9) {
            this.lCB.setEntranceType(1);
        } else if (this.lCB.getType() == 10) {
            this.lCB.setEntranceType(2);
            this.lCB.setType(9);
        } else if (this.lCB.getType() == 0) {
            this.lCB.setEntranceType(3);
        }
        this.lCB.setIsUserFeedback(this.mCb);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.lCB.getType() == 4 ? 6 : 9);
        this.lCB.setWriteImagesInfo(this.writeImagesInfo);
        if (this.lCB.getType() == 0 || this.lCB.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.mzh) {
                    w.d(this.lCB.getForumId(), this);
                } else {
                    w.c(this.lCB.getForumId(), this);
                }
            }
        } else if (this.lCB.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                w.c("24591571", this);
            }
        } else if (this.lCB.getType() == 1) {
            w.a(this.lCB.getThreadId(), this);
        } else if (this.lCB.getType() == 4) {
            w.c(this.lCB.getForumId() + "photolive", this);
        } else if (this.lCB.getType() == 5) {
            w.a(this.lCB.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.jJb = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.lCB != null && this.lCB.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.lCB.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.mBp = true;
        }
        dwk();
        try {
            this.mCB = dwV();
        } catch (Throwable th) {
            this.mCB = null;
        }
    }

    private void dwt() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) x.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.lCT.setText(com.baidu.tbadk.plugins.b.Ai(com.baidu.tbadk.plugins.b.Aj(hotTopicBussinessData.mTopicName)));
            this.lCT.setMovementMethod(com.baidu.tieba.view.c.dtE());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) x.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString Ai = com.baidu.tbadk.plugins.b.Ai(com.baidu.tbadk.plugins.b.Aj(hotTopicBussinessData.mTopicName));
            if (Ai != null) {
                this.lCT.setText(Ai);
            }
            this.mBK.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.w.a
    public void a(WriteData writeData) {
        int i = 0;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            if (writeData != null) {
                if (this.lCB != null) {
                    boolean z = this.lCB.getVideoInfo() != null && this.lCB.getVideoInfo().isEditVideoDataLegal();
                    boolean z2 = (this.lCB.getWriteImagesInfo() == null || x.isEmpty(this.lCB.getWriteImagesInfo().getChosedFiles())) ? false : true;
                    boolean z3 = !com.baidu.adp.lib.util.k.isEmpty(dwr().getText().toString());
                    boolean z4 = !com.baidu.adp.lib.util.k.isEmpty(dwq().getText().toString());
                    boolean z5 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle());
                    boolean z6 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent());
                    boolean z7 = as.isEmpty(writeData.getTitle()) && !e(TbFaceManager.bkj().a(getPageContext().getPageActivity(), writeData.getContent(), this.mBP));
                    if (!z || z7) {
                        this.lCB.setHaveDraft(true);
                        if (!z2 && !z) {
                            f(writeData);
                        }
                        if (!z && (!z3 || this.mCI || ((this.mCb || this.mBp) && z5))) {
                            g(writeData);
                        }
                        if (z6 && (!z4 || this.mCb || this.mBp)) {
                            h(writeData);
                        }
                        if (this.lCB != null && !this.lCB.getHaveDraft()) {
                            dwj();
                        }
                        if (writeData.getType() == 4 || writeData.getType() == 5) {
                            dwN();
                        }
                        dhM();
                        int categoryTo = writeData.getCategoryTo();
                        if (categoryTo >= 0 && this.fDY != null) {
                            this.mBF = this.mBC.hJP;
                            this.mBE = this.mBC.name;
                            while (true) {
                                if (i == this.fDY.size()) {
                                    break;
                                }
                                ad adVar = this.fDY.get(i);
                                if (categoryTo != adVar.hJP) {
                                    i++;
                                } else {
                                    this.mBF = categoryTo;
                                    this.mBE = adVar.name;
                                    this.lCB.setCategoryTo(this.mBF);
                                    break;
                                }
                            }
                            if (this.mBG != null) {
                                this.mBG.setText(this.mBE);
                                this.mBG.setCategoryContainerData(this.fDY, this.mBC, this.mBF);
                            }
                        }
                        this.eAf.bhl();
                        return;
                    }
                    return;
                }
                return;
            }
            dwN();
            dwj();
        }
    }

    private void f(WriteData writeData) {
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(writeData.getVideoInfo());
            this.lCB.setVideoInfo(videoInfo);
            wB(false);
            return;
        }
        if (writeData.getWriteImagesInfo() != null) {
            this.writeImagesInfo = writeData.getWriteImagesInfo();
        }
        this.lCB.setWriteImagesInfo(this.writeImagesInfo);
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            dwy();
        }
        wD(false);
        wB(true);
    }

    private void g(WriteData writeData) {
        String str;
        String Aj;
        if (com.baidu.adp.lib.util.k.isEmpty(this.lCB.getTitle())) {
            this.lCB.setTitle(writeData.getTitle());
        }
        if (!x.isEmpty(this.mList)) {
            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) x.getItem(this.mList, 0);
            if (hotTopicBussinessData == null) {
                str = null;
            } else {
                str = hotTopicBussinessData.mTopicName;
            }
            if (StringUtils.isNull(str)) {
                Aj = this.lCB.getTitle();
            } else {
                Aj = com.baidu.tbadk.plugins.b.Aj(str);
            }
            SpannableString Ai = com.baidu.tbadk.plugins.b.Ai(Aj);
            if (Ai != null) {
                dwr().setText(Ai);
                dwr().setSelection(Ai.length() > Aj.length() ? Aj.length() : Ai.length());
                return;
            }
            return;
        }
        SpannableString Ai2 = com.baidu.tbadk.plugins.b.Ai(this.lCB.getTitle());
        if (Ai2 != null) {
            dwr().setText(Ai2);
            dwr().setSelection(this.lCB.getTitle().length() > Ai2.length() ? Ai2.length() : this.lCB.getTitle().length());
        }
    }

    private void h(WriteData writeData) {
        this.lCB.setContent(writeData.getContent());
        dwq().setText(TbFaceManager.bkj().a(getPageContext().getPageActivity(), this.lCB.getContent(), this.mBP));
        if (dwq().getText() != null) {
            dwq().setSelection(dwq().getText().length());
        }
        if (this.mBI) {
            a(this.mCx, this.mCq);
        }
    }

    private void dwN() {
        if ((!this.mBI || this.mCp != null) && this.mCo != null) {
            this.mCp.b(this.writeImagesInfo);
            dwR();
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
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.lCB.getFloor());
        bundle.putInt("floor_num", this.lCB.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.mCi);
        if (this.mCb) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.eBO);
        if (this.mBx != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.mBx));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.mCl);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.iim);
        bundle.putInt("album_thread", this.biT);
        bundle.putInt("private_thread", this.privateThread);
        bundle.putSerializable("tab_list", this.mvg);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
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

    private String getContent() {
        return (dwq() == null || dwq().getText() == null) ? "" : dwq().getText().toString();
    }

    private String dwv() {
        if (this.lCB == null || dwr() == null || dwr().getVisibility() != 0 || dwr().getText() == null) {
            return "";
        }
        String obj = dwr().getText().toString();
        if (this.mPrefixData != null && x.getCount(this.mPrefixData.getPrefixs()) > 0 && this.lCC != x.getCount(this.mPrefixData.getPrefixs()) - 1 && this.lCB.getType() != 4 && this.lCZ != null && this.lCZ.getText() != null) {
            this.lCB.setPostPrefix(this.lCZ.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.lCB.getTitle();
        }
        return obj;
    }

    private void PX(String str) {
        if (this.lCB != null && this.mBr != null) {
            if (this.mBr.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.lCB.setIsNoTitle(true);
                    this.lCB.setTitle("");
                    return;
                }
                this.lCB.setIsNoTitle(false);
                this.lCB.setTitle(str);
                return;
            }
            this.lCB.setIsNoTitle(true);
            this.lCB.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfA() {
        if (this.mCO.isVisible() && dwq() != null && dwq().getText() != null) {
            int length = dwq().getText().toString().length();
            if (this.lDc != null && this.lDc.getVisibility() == 0 && this.lCC != x.getCount(this.mPrefixData.getPrefixs()) - 1 && this.lCZ != null) {
                length += this.lCZ.length();
            }
            if (length > com.baidu.tieba.write.video.b.mzm) {
                PW(String.format(getString(R.string.write_video_title_too_long), Integer.valueOf(com.baidu.tieba.write.video.b.mzm)));
                return;
            }
        }
        dhD();
        this.lCB.setContent(getContent());
        PX(dwv());
        if (this.mCb || this.mBp) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.lCB.getTitle()) || !this.lCB.getTitle().startsWith(string)) {
                PX(string + this.lCB.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.lCB.getContent()) || !this.lCB.getContent().startsWith(str)) {
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
                sb.append(this.lCB.getContent());
                this.lCB.setContent(sb.toString());
            }
        }
        if (this.mCc) {
            this.lCB.setContent(String.format(getResources().getString(R.string.homepage_test_post_suffix), Build.MODEL, TbadkCoreApplication.getInst().getVersionName(), com.baidu.adp.lib.util.j.netTypeNameInUpperCase(), Build.VERSION.RELEASE) + "\n" + this.lCB.getContent());
        }
        if (this.mBD >= 0) {
            this.lCB.setCategoryFrom(this.mBD);
        }
        if (this.mBF >= 0) {
            this.lCB.setCategoryTo(this.mBF);
        }
        this.lCB.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mCP != null) {
            this.lCB.setWriteVoteData(this.mCP.getWriteVoteData());
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
            this.lCB.setTakePhotoNum(i);
        }
        this.lCB.setHasLocationData(this.eBP != null && this.eBP.bNz());
        if (this.writeImagesInfo != null) {
            this.eBQ.vr(this.writeImagesInfo.size() > 0);
        }
        if (!x.isEmpty(this.mList) && this.mBJ != null && this.mBJ.mIsGlobalBlock == 0) {
            this.lCB.setForumId(String.valueOf(this.mBJ.mForumId));
            this.lCB.setForumName(this.mBJ.mForumName);
        }
        dvs();
        this.eBQ.d(this.lCB);
        this.lCB.setContent(this.lCB.getContent().replaceAll("\u0000\n", ""));
        this.lCB.setContent(this.lCB.getContent().replaceAll("\u0000", ""));
        this.lCB.setVcode(null);
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
        if (!this.eBQ.dmA()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.lCB.mDynamicImageTextData != null) {
            dvr();
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.hwp);
            this.eBQ.dmx();
        }
    }

    private void dvs() {
        FrsTabItemData selectedTabItemData;
        if (this.lCB != null && this.mzD != null && (selectedTabItemData = this.mzD.getSelectedTabItemData()) != null) {
            this.lCB.setTabId(selectedTabItemData.tabId);
            this.lCB.setTabName(selectedTabItemData.name);
            this.lCB.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    public void dvr() {
        if (this.lCB.mDynamicImageTextData != null) {
            showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
            com.baidu.tieba.write.b.a.a(this.lCB, new a.InterfaceC0775a() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                @Override // com.baidu.tieba.write.b.a.InterfaceC0775a
                public void a(BaseUploadData baseUploadData) {
                    com.baidu.tieba.write.b.c.b.dvd().a((ImageTextUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.write.WriteActivity.35.1
                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onSuccess(String str) {
                            WriteActivity.this.cfx();
                            w.e(WriteActivity.this.lCB.getForumId(), (WriteData) null);
                            WriteActivity.this.dwG();
                            com.baidu.tieba.write.b.a.duU();
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
                            com.baidu.tieba.write.b.a.duU();
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
                if (this.lCT == getCurrentFocus()) {
                    dwq().clearFocus();
                    this.lCT.requestFocus();
                    if (this.eAf != null) {
                        this.eAf.bhl();
                    }
                    ShowSoftKeyPadDelay(this.lCT);
                } else {
                    dwq().requestFocus();
                    if (this.eAf != null) {
                        this.eAf.bhl();
                    }
                    ShowSoftKeyPadDelay(this.mBs);
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
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                cfx();
                dwG();
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
                                dwS();
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
                        if (this.mCM) {
                            wC(true);
                            this.mCM = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.mBI) {
                        D(intent);
                        dhM();
                        return;
                    }
                    ar(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.lCB.setVideoInfo(videoInfo);
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
                            if (this.mBn) {
                                sb2.append(com.baidu.tbadk.plugins.b.eJi);
                                this.mBn = false;
                            }
                            sb2.append(stringExtra);
                            zD(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !x.isEmpty(this.mList)) {
                    if (!x.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                        this.mBJ = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                        a(this.mBJ);
                    }
                } else if (i == 25048) {
                    ap(intent);
                } else if (i == 25049 && intent != null) {
                    String str = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT) + " ";
                    int selectionStart = this.mBs.getSelectionStart();
                    int selectionEnd = this.mBs.getSelectionEnd();
                    if (selectionStart >= 0) {
                        Editable text = this.mBs.getText();
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
                this.mBs.requestFocus();
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
                    dwQ();
                    if (this.mCM) {
                        wC(true);
                        this.mCM = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.lCT == getCurrentFocus()) {
                        dwq().clearFocus();
                        this.lCT.requestFocus();
                        if (this.eAf != null) {
                            this.eAf.bhl();
                        }
                        ShowSoftKeyPadDelay(this.lCT);
                        return;
                    }
                    dwq().requestFocus();
                    if (this.eAf != null) {
                        this.eAf.bhl();
                    }
                    ShowSoftKeyPadDelay(this.mBs);
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
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.eBO = String.valueOf(System.currentTimeMillis());
                    an.c(getPageContext(), this.eBO);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dwQ();
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
        dwO();
        this.lCB.setToDynamic(this.isToDynamic);
        this.lCB.setCallFrom(this.iim);
        if (this.lCB.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cfA();
    }

    private void dwx() {
        if (this.eAf != null) {
            this.eAf.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void dwO() {
        if (this.eAf != null) {
            this.eAf.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void dwP() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void dwQ() {
        if (this.mBI) {
            this.mCp.b(this.writeImagesInfo);
            dwR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwR() {
        this.mCp.notifyDataSetChanged();
        this.mCo.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.mCp.notifyDataSetChanged();
                WriteActivity.this.mCo.invalidateViews();
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
        if (this.mBI) {
            ar(intent);
            dwQ();
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
            dwQ();
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

    private void dwS() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void at(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.mCm.parseJson(stringExtra);
            this.mCm.updateQuality();
            if (this.mCm.getChosedFiles() != null && this.mCm.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.mCm.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.mCm.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dwr());
        HidenSoftKeyPad(this.mInputManager, dwq());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
        if (this.mCO != null) {
            this.mCO.onPause();
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
            dwT();
            dwy();
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
                dwT();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    dwy();
                }
            }
            wD(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dwT() {
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

    private void dwU() {
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
        String forumId = this.lCB == null ? "" : this.lCB.getForumId();
        if (this.mCn != null) {
            this.mCn.a(this.writeImagesInfo, this.mFrom, forumId);
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
            } else if (this.lCB.getType() != 7) {
                if (this.mBx == null) {
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

    private void dwy() {
        if (!this.mBI) {
            if (this.eAf != null) {
                this.eAf.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.eAf.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.lCB == null ? "" : this.lCB.getForumId();
            if (this.mCn != null) {
                this.mCn.a(this.writeImagesInfo, this.mFrom, forumId);
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
        if (i < this.mBv.size()) {
            for (int i2 = 0; i2 < this.mBv.size(); i2++) {
                this.mBv.get(i2).wn(false);
            }
            this.mBv.get(i).wn(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void EV(int i) {
        if (i == x.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new ap("c13014").ah("obj_type", 1));
        } else {
            TiebaStatic.log(new ap("c13014").ah("obj_type", 2));
        }
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
        ao.setImageResource(this.lDb, R.drawable.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.mBs);
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
        if (this.mCG && System.currentTimeMillis() - this.mCH < 800) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.mCG = false;
        }
        if (this.mBM != null && !z) {
            this.mBM.bVC();
        }
        if (this.mBO != null && !z) {
            dwb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PY(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.mCD != null) {
            PZ(str);
            this.mCD.dismiss();
        }
    }

    private void fC(Context context) {
        mCF = l.getEquipmentHeight(context);
    }

    private void PZ(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.mCG = true;
        dwT();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            dwy();
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

    private File dwV() {
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

    private void dwW() {
        if (this.mCB != null && this.lCB.getType() == 0 && this.lCB.getType() == 9) {
            fC(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.mCB != null) {
                        WriteActivity.this.PY(WriteActivity.this.mCB.getAbsolutePath());
                    }
                }
            });
            this.mCC = (TbImageView) this.mBubbleView.findViewById(R.id.rec_img_view);
            this.mCE = (LinearLayout) this.mBubbleView.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.aZP().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.mCB.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.aZP().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.mCB.getAbsolutePath());
                Bitmap g = g(this.mCB.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (g != null) {
                    this.mCC.setImageBitmap(g);
                    this.mCC.setDrawBorder(true);
                    this.mCC.setBorderWidth(2);
                    this.mCC.setBorderColor(ao.getColor(R.color.common_color_10264));
                    this.mCD = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.mCD.setCanceledOnTouchOutside(true);
                    this.mCD.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.41
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.mCG) {
                                l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.mCH = System.currentTimeMillis();
                            }
                        }
                    });
                    this.mCD.setContentView(this.mBubbleView);
                    this.mCD.show();
                    Window window = this.mCD.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (mCF / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.mCb || !x.isEmpty(this.mList) || !StringUtils.isNull(this.lCB.getTitle())) {
            this.mBr.setVisibility(0);
            this.mBr.requestFocus();
            return;
        }
        this.mBr.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwX() {
        if (this.eAf != null) {
            this.eAf.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.42
                @Override // java.lang.Runnable
                public void run() {
                    if (!WriteActivity.this.mzh && WriteActivity.this.eAf != null && WriteActivity.this.eAf.eAi != null) {
                        String clipBoardContent = UtilHelper.getClipBoardContent();
                        if (as.isEmpty(clipBoardContent) || !bd.baV().j(clipBoardContent)) {
                            WriteActivity.this.mBM.cVE();
                            return;
                        }
                        if (WriteActivity.this.mAn == null) {
                            WriteActivity.this.mAn = new FindNewLinkBubbleController(WriteActivity.this.getPageContext(), WriteActivity.this.mCT);
                        }
                        WriteActivity.this.mAn.a(WriteActivity.this.eAf.eAi.nR(31), clipBoardContent, FindNewLinkBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
                    }
                }
            });
        }
    }

    public String getCallFrom() {
        return this.iim;
    }

    public WriteData dhF() {
        return this.lCB;
    }

    public FrsTabInfoData dwY() {
        return this.mvg;
    }

    public String getFrom() {
        return this.mFrom;
    }

    private boolean dwZ() {
        return (this.mCP == null || this.mCQ == null || this.mCP.getWriteVoteData() == null || this.mCQ.getVisibility() != 0) ? false : true;
    }
}
