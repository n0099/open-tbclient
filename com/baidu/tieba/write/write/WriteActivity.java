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
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
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
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.m.a.a;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
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
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.SaveDraftDialogView;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.a;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.coreExtra.data.ag;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mutiprocess.event.GoodsEvent;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.switchs.RepostToDynamicDefaultSwitch;
import com.baidu.tbadk.util.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsPublishFineGoodsDialogView;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.x;
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
import com.baidu.tieba.write.write.EBusinessProtocolView;
import com.baidu.tieba.write.write.FindNewLinkBubbleController;
import com.baidu.tieba.write.write.d;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import org.json.JSONArray;
import org.json.JSONObject;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0210a, VoiceManager.c, x.a, i.a {
    private static int mVL = 0;
    private EditorTools eKH;
    private String eMr;
    private LocationModel eMs;
    private NewWriteModel eMt;
    List<af> fPt;
    private String hQN;
    private String hQO;
    private String hQP;
    private VoiceManager hSU;
    private com.baidu.tbadk.core.dialog.i ifZ;
    private SaveDraftDialogView iga;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private LinearLayout kFD;
    private PlayVoiceBntNew kFE;
    private ImageView kFG;
    private TextView lUS;
    private com.baidu.tieba.write.i lUT;
    private ImageView lUU;
    private View lUV;
    private int lUw;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private ListView mListView;
    private FrsTabInfoData mNM;
    private PostTopicData mPostTopicData;
    public PostPrefixData mPrefixData;
    private FindNewLinkBubbleController mSY;
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
    private LinearLayout mUw;
    private LinearLayout mUx;
    private View mVP;
    private View mVQ;
    private TextView mVR;
    private com.baidu.tieba.c.e mVT;
    private b mVU;
    private com.baidu.tieba.write.write.video.a mVV;
    private com.baidu.tieba.write.write.vote.a mVW;
    private RelativeLayout mVX;
    private boolean mVY;
    private com.baidu.tieba.view.b mVb;
    private View mVm;
    private VoiceData.VoiceModel mVoiceModel;
    private i mVu;
    private d mWa;
    private LinearLayout mWb;
    private ImageView mWc;
    private TextView mWd;
    private List<com.baidu.tieba.i.a> mWe;
    private EBusinessProtocolView mWf;
    private int privateThread;
    private String mUs = "";
    private boolean mUt = false;
    protected WriteData lUv = null;
    private boolean mVh = false;
    private boolean mVi = false;
    private boolean mUv = false;
    private boolean mVj = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText lUN = null;
    private HeadImageView mVk = null;
    private View lUO = null;
    private LinearLayout lUQ = null;
    private SpanGroupEditText mUy = null;
    private FeedBackModel mUz = null;
    private FeedBackTopListView mVl = null;
    private ArrayList<WritePrefixItemLayout> mUB = new ArrayList<>();
    private String jYz = null;
    private final KeyEvent hEW = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView mVn = null;
    private TextView kGw = null;
    private TextView mName = null;
    private ImageView mVo = null;
    private DialogInterface.OnCancelListener hJK = null;
    private final Handler mHandler = new Handler();
    private boolean mVp = false;
    private String mVq = null;
    private RelativeLayout jfq = null;
    public boolean mVr = true;
    public String eMx = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int eMy = 0;
    private int mVs = 0;
    private WriteImagesInfo mVt = new WriteImagesInfo();
    private View mRootView = null;
    private GridView mVv = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a mVw = null;
    private ScrollView mUN = null;
    private EditText mVx = null;
    private View mVy = null;
    private View mVz = null;
    private View mVA = null;
    private EditText mVB = null;
    private TextView mVC = null;
    private TextView mVD = null;
    private TextWatcher mVE = null;
    private TextWatcher mVF = null;
    private boolean mUO = false;
    private boolean mVG = false;
    private com.baidu.tbadk.core.view.a eUz = null;
    private String mFrom = "write";
    private File mVH = null;
    private TbImageView mVI = null;
    private View mBubbleView = null;
    private Dialog mVJ = null;
    private LinearLayout mVK = null;
    private boolean mVM = false;
    private long mVN = -1000;
    private boolean mVO = false;
    private String iwx = "2";
    private int boB = 0;
    private boolean canGoods = false;
    private String mTopicId = "";
    private SpannableStringBuilder mUR = new SpannableStringBuilder();
    private boolean mVS = false;
    private boolean bdF = false;
    private final c mUT = new c();
    private boolean mRP = false;
    private final d.a mVZ = new d.a() { // from class: com.baidu.tieba.write.write.WriteActivity.1
        @Override // com.baidu.tieba.write.write.d.a
        public void JN(int i) {
            if (WriteActivity.this.mUy != null) {
                WriteActivity.this.mUy.ph(i);
            }
        }

        @Override // com.baidu.tieba.write.write.d.a
        public void fC(List<t> list) {
            WriteActivity.this.fD(list);
        }
    };
    private boolean mWg = false;
    private int mWh = 0;
    private boolean mWi = false;
    private final HttpMessageListener mWj = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.jYz)) {
                    WriteActivity.this.jYz = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.xu(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.jYz)) {
                    WriteActivity.this.jYz = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.jYz);
                    WriteActivity.this.xu(true);
                }
            }
        }
    };
    private CustomMessageListener mWk = new CustomMessageListener(2921494) { // from class: com.baidu.tieba.write.write.WriteActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (WriteActivity.this.lUv != null && WriteActivity.this.canGoods) {
                TiebaStatic.log(new aq("c13896").ai("obj_locate", 1).dD("fid", WriteActivity.this.lUv.getForumId()).dD("fname", WriteActivity.this.lUv.getForumName()));
            }
        }
    };
    private TbFaceManager.a mUV = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.34
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
    private final AntiHelper.a hUq = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.45
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_WRITE));
        }
    };
    private FindNewLinkBubbleController.a mWl = new FindNewLinkBubbleController.a() { // from class: com.baidu.tieba.write.write.WriteActivity.55
        @Override // com.baidu.tieba.write.write.FindNewLinkBubbleController.a
        public void f(View view, String str) {
            if (WriteActivity.this.mSY != null) {
                TiebaStatic.log("c13802");
                WriteActivity.this.mSY.Qu();
                UtilHelper.clearClipBoard();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, str, false, null)));
            }
        }
    };
    private final NewWriteModel.d eMH = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.56
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.cms();
            WriteActivity.this.closeLoadingDialog();
            WriteActivity.this.mWm = true;
            if (postWriteCallBackData != null && WriteActivity.this.lUv != null) {
                WriteActivity.this.mUT.bf(null);
                if (z) {
                    WriteActivity.this.jr(z);
                    if (WriteActivity.this.e(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    WriteActivity.this.cqd();
                    WriteActivity.this.dIw();
                    if ((WriteActivity.this.lUv.getType() == 0 || WriteActivity.this.lUv.getType() == 9) && !y.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                        TiebaStatic.log(new aq("c11731").dD("obj_id", WriteActivity.this.mTopicId));
                    }
                    WriteActivity.this.l(postWriteCallBackData);
                    if (!at.isEmpty(postWriteCallBackData.getVideoid()) && WriteActivity.this.lUv.getVideoInfo() != null) {
                        postWriteCallBackData.mVideoMd5 = WriteActivity.this.lUv.getVideoInfo().getVideoMd5();
                        if (!at.isEmpty(WriteActivity.this.lUv.getForumName())) {
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
                    WriteActivity.this.mUT.bf(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.mUT.Sw(postWriteCallBackData.getErrorString());
                    WriteActivity.this.mUT.b(WriteActivity.this.lUN, WriteActivity.this.mUy);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.c(WriteActivity.this.getActivity(), WriteActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.c(WriteActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this.getActivity());
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.zA(WriteActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.zA(postWriteCallBackData.getErrorString());
                    }
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.56.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.56.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(WriteActivity.this.getActivity(), 0, 26, 1)));
                            TiebaStatic.log(new aq("c13746").ai("obj_locate", 1).ai("obj_type", 1));
                        }
                    });
                    aVar.b(WriteActivity.this.getPageContext()).bhg();
                    TiebaStatic.log(new aq("c13745").ai("obj_locate", 1).ai("obj_type", 1));
                } else if ((agVar == null || writeData == null || agVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (agVar != null && writeData != null && agVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(agVar.getVcode_md5());
                    writeData.setVcodeUrl(agVar.getVcode_pic_url());
                    writeData.setVcodeExtra(agVar.bmZ());
                    if (com.baidu.tbadk.t.a.CP(agVar.bmY())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, agVar.bmY());
                        if (WriteActivity.this.mVj) {
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
    private final LocationModel.a eMF = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.57
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bsq() {
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
        public void a(LocationData locationData) {
            if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                WriteActivity.this.a(2, true, locationData.getFormatted_address());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener mhC = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.58
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.eMs.wg(false);
                    WriteActivity.this.eMs.fV(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.eMs.wg(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener mUW = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.write.write.WriteActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                WriteActivity.this.dIQ();
            }
        }
    };
    private final View.OnClickListener mUX = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.eKH.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dHK = WriteActivity.this.dHK();
            if (dHK >= 0 && dHK < WriteActivity.this.mUy.getText().length()) {
                WriteActivity.this.mUy.setSelection(dHK);
            }
        }
    };
    private boolean mUY = true;
    private final View.OnFocusChangeListener gsF = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.7
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.lUN || view == WriteActivity.this.mBack || view == WriteActivity.this.kGw) {
                if (z) {
                    WriteActivity.this.mUY = true;
                    WriteActivity.this.dHL();
                    com.baidu.adp.lib.util.l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.lUN);
                    if (WriteActivity.this.eKH != null) {
                        WriteActivity.this.eKH.bpY();
                    }
                } else if (view == WriteActivity.this.lUN) {
                    WriteActivity.this.lUS.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.mUy && z) {
                WriteActivity.this.mUY = false;
                WriteActivity.this.dHL();
                com.baidu.adp.lib.util.l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.mUy);
                if (WriteActivity.this.eKH != null) {
                    WriteActivity.this.eKH.bpY();
                }
            }
            WriteActivity.this.dHQ();
        }
    };
    private com.baidu.tbadk.mutiprocess.h hRZ = new com.baidu.tbadk.mutiprocess.h<GoodsEvent>() { // from class: com.baidu.tieba.write.write.WriteActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(GoodsEvent goodsEvent) {
            if (goodsEvent != null) {
                WriteActivity.this.SY(goodsEvent.getGoodsList());
                goodsEvent.setDispost(true);
            }
            return false;
        }
    };
    private boolean mWm = false;
    private TextWatcher mUZ = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.18
        private String mVd = "";
        private String mVe;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mVe = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.mVe != null ? this.mVe.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dtm();
            WriteActivity.this.dHR();
            EditText dId = WriteActivity.this.dId();
            if (editable != null && dId != null && dId.getText() != null) {
                if (this.mVd == null || !this.mVd.equals(editable.toString())) {
                    if (WriteActivity.this.mUT != null) {
                        this.mVd = dId.getText().toString();
                        WriteActivity.this.mUT.b(dId, true);
                        return;
                    }
                    return;
                }
                dId.setSelection(dId.getSelectionEnd());
            }
        }
    };
    private TextWatcher mVa = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.19
        private String mVe;
        private String mVf = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mVe = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.mVe != null ? this.mVe.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dtm();
            EditText dIc = WriteActivity.this.dIc();
            if (editable != null && dIc != null && dIc.getText() != null) {
                if (this.mVf == null || !this.mVf.equals(editable.toString())) {
                    if (WriteActivity.this.mUT != null) {
                        this.mVf = dIc.getText().toString();
                        WriteActivity.this.mUT.b(dIc, false);
                        return;
                    }
                    return;
                }
                dIc.setSelection(dIc.getSelectionEnd());
            }
        }
    };
    private int mWn = 0;
    private final a.InterfaceC0806a kMz = new a.InterfaceC0806a() { // from class: com.baidu.tieba.write.write.WriteActivity.42
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0806a
        public void onRefresh() {
            WriteActivity.this.jYz = null;
            WriteActivity.this.xu(false);
            WriteActivity.this.eKH.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void l(PostWriteCallBackData postWriteCallBackData) {
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

    public void dIm() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
            if (this.mUS != null) {
                this.mUS.dGv();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bsd();
        } else if (this.eMs != null) {
            this.eMs.wg(false);
            a(1, true, (String) null);
            this.eMs.dxq();
        }
    }

    private void bsd() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nt(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.eMs.dxu();
                } else {
                    WriteActivity.this.eMF.bsq();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.a(0, true, (String) null);
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
            if (this.mVV != null && this.mVV.isVisible()) {
                this.eKH.setBarLauncherEnabled(false);
                this.eKH.setDeskLauncherEnabled(false);
                this.eKH.setToolEnabled(true, 2);
                this.eKH.setToolEnabled(true, 32);
                if (this.mUS != null) {
                    this.mUS.xj(false);
                    return;
                }
                return;
            }
            this.eKH.setBarLauncherEnabled(!this.mUY);
            this.eKH.setDeskLauncherEnabled(this.mUY ? false : true);
            this.eKH.setToolEnabled(true, 26);
            this.eKH.setToolEnabled(true, 2);
            this.eKH.setToolEnabled(true, 30);
            if (this.mUS != null) {
                this.mUS.xj(true);
            }
            dIM();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.mUO) {
            this.lUN.setVisibility(8);
            if (this.lUv.getType() == 5) {
                this.mVA.setVisibility(8);
            } else {
                this.mVA.setVisibility(0);
            }
            a(this.mVD, this.mVx);
            a(this.mVC, this.mVB);
            dtm();
        }
        if (this.mVh) {
            this.mUY = true;
            dHL();
            if (this.eKH != null) {
                this.eKH.bpY();
            }
            this.lUN.requestFocus();
            ShowSoftKeyPadDelay(this.lUN);
        }
        if (this.mVV != null) {
            this.mVV.onResume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
        if (this.mVV != null) {
            this.mVV.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
        if (this.mVV != null) {
            this.mVV.onStop();
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
                    dIk();
                }
                xv(true);
            }
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.lUv.setVideoInfo((VideoInfo) serializableExtra);
            } else {
                this.lUv.setVideoInfo(null);
            }
            if (this.mVV == null) {
                this.mVV = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            }
            if (this.lUv.getVideoInfo() != null && this.lUv.getVideoInfo().isEditVideoDataLegal()) {
                xt(false);
                this.mVV.dJE();
                if (this.mUx != null && this.mUx.getVisibility() == 0) {
                    this.mUx.setVisibility(8);
                    if (this.eKH != null) {
                        this.eKH.qb(30).setName(getResources().getString(R.string.editor_add_title));
                    }
                }
                if (dIc() != null && e(dIc().getText())) {
                    dIc().setText("");
                    this.lUv.setContent("");
                    return;
                }
                return;
            }
            xt(true);
        }
    }

    public void SU(String str) {
        showToastWithDefaultIcon(str, BdToast.DefaultIcon.FAILURE);
    }

    public void xt(boolean z) {
        if (z) {
            this.lUv.setVideoInfo(null);
            this.mVV.setVideoInfo(null);
            this.mVu.dIY().setVisibility(0);
            xu(false);
        } else {
            this.mVV.setVideoInfo(this.lUv.getVideoInfo());
            this.writeImagesInfo.clear();
            this.mVu.dIY().setVisibility(8);
            dIC();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, false));
        }
        dtm();
        dHL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        if (this.lUv.getType() == 0) {
            JQ(this.boB);
        }
        initUI();
        dIB();
        this.eMs = new LocationModel(getPageContext());
        this.eMs.a(this.eMF);
        registerListener(this.mhC);
        registerListener(this.mUW);
        registerListener(this.mBackgroundListener);
        cKF();
        dIP();
        if (this.mUO) {
            this.mVw.setEditorTools(this.eKH);
        } else {
            this.mUy.requestFocus();
        }
        dnW();
        dIk();
        dIN();
        this.hRZ.setPriority(1);
        registerResponsedEventListener(GoodsEvent.class, this.hRZ);
        dIn();
    }

    private void dIn() {
        SY(getIntent().getStringExtra("goods_list"));
    }

    @SuppressLint({"ResourceAsColor"})
    private void cKF() {
        this.eKH = new EditorTools(getActivity());
        this.eKH.setBarMaxLauCount(5);
        this.eKH.setMoreButtonAtEnd(true);
        this.eKH.setBarBackgroundColorId(R.color.cp_bg_line_h);
        this.eKH.setBarLauncherType(1);
        this.eKH.jj(true);
        this.eKH.jk(true);
        switch (this.lUv.getType()) {
            case 4:
            case 5:
                dIq();
                break;
            default:
                dHM();
                break;
        }
        this.eKH.build();
        if (this.mUw != null) {
            this.mUw.addView(this.eKH);
        }
        cJX();
        this.eKH.display();
        com.baidu.tbadk.editortools.h qb = this.eKH.qb(6);
        if (qb != null && !TextUtils.isEmpty(this.eMx)) {
            ((View) qb).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.eMx);
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
        if (com.baidu.tbadk.core.sharedPref.b.bik().getInt("commodity_tip_show_controller", 0) == 0 && this.canGoods) {
            dIr();
            return;
        }
        if (!this.mRP) {
            dHO();
        }
        dIQ();
    }

    private void dIo() {
        this.mVy = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.mVA = this.mVy.findViewById(R.id.live_post_title_container);
        this.mVx = (EditText) this.mVy.findViewById(R.id.live_post_content);
        this.mVv = (GridView) this.mVy.findViewById(R.id.photoLiveGridView);
        this.mVB = (EditText) this.mVy.findViewById(R.id.live_post_title);
        this.mVC = (TextView) this.mVy.findViewById(R.id.titleOverPlusNumber);
        this.mVD = (TextView) this.mVy.findViewById(R.id.contentOverPlusNumber);
        this.mVz = this.mVy.findViewById(R.id.live_interval_view);
        this.mVC.setText(String.valueOf(20));
        this.mVD.setText(String.valueOf(233));
        this.mVy.setVisibility(0);
        this.mVC.setVisibility(0);
        this.mVD.setVisibility(0);
        this.mVB.setHint(R.string.tips_title_limit_new);
        this.mVB.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.10
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.mVG = true;
                    WriteActivity.this.mUY = true;
                    WriteActivity.this.dHL();
                    if (WriteActivity.this.eKH != null) {
                        WriteActivity.this.eKH.bpY();
                    }
                }
            }
        });
        if (this.lUv.getType() == 4) {
            this.mVx.setHint(R.string.live_write_input_content_new);
        } else if (this.lUv.getType() == 5) {
            this.mVx.setHint(R.string.live_write_input_content_update);
        }
        this.mVx.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.mVG = false;
                    WriteActivity.this.mUY = false;
                    WriteActivity.this.dHL();
                    if (WriteActivity.this.eKH != null) {
                        WriteActivity.this.eKH.bpY();
                    }
                }
            }
        });
        this.mVx.requestFocus();
        this.mVx.addTextChangedListener(aoy());
        this.mVB.requestFocus();
        this.mVB.addTextChangedListener(aoy());
        this.mVB.setOnClickListener(this.mUX);
        this.mVx.setOnClickListener(this.mUX);
        this.mVw = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.mVv);
        this.mVw.JH(6);
        this.mVv.setAdapter((ListAdapter) this.mVw);
        View findViewById = this.mVy.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void dHn() {
                WriteActivity.this.dIK();
            }
        });
        dIp();
    }

    private void dIp() {
        if (this.lUv.getType() == 0) {
            if (this.lUv.getTitle() != null) {
                this.mVB.setText(this.lUv.getTitle());
                this.mVB.setSelection(this.lUv.getTitle().length());
                return;
            }
            return;
        }
        if (this.lUv.getType() == 1 || this.lUv.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.mUO) {
            dII();
        }
        if (this.eKH.bry()) {
            this.eKH.bpY();
        }
        JQ(0);
    }

    public boolean dGk() {
        return (!"1".equals(this.iwx) && this.writeImagesInfo.size() == 0 && this.mVoiceModel == null && ((this.mUx == null || this.mUx.getVisibility() != 0) && (this.mUy == null || !this.mUy.blu()))) && (dIc() == null || !e(dIc().getText()));
    }

    private boolean e(Spannable spannable) {
        if (spannable != null) {
            ImageSpan[] imageSpanArr = (ImageSpan[]) spannable.getSpans(0, spannable.length(), ImageSpan.class);
            if (imageSpanArr != null && imageSpanArr.length > 0) {
                return true;
            }
            if (this.mUT != null) {
                if (this.mUT.d(spannable)) {
                    return true;
                }
            }
            if (be.bju().l(spannable)) {
                return true;
            }
        }
        return false;
    }

    private void JQ(int i) {
        if (this.writeImagesInfo != null && this.lUv != null) {
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.lUv.getForumId());
            albumFloatActivityConfig.getIntent().putExtra("forum_name", this.lUv.getForumName());
            albumFloatActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumFloatActivityConfig.setAlbumThread(i);
            albumFloatActivityConfig.setCanSelectVideo(dGk());
            albumFloatActivityConfig.setFromWrite(true);
            albumFloatActivityConfig.setCallFrom(this.iwx);
            albumFloatActivityConfig.setProfessionZone(this.lUv.getProZone());
            albumFloatActivityConfig.setFrsTabInfo(this.mNM);
            AntiData antiData = new AntiData();
            antiData.voice_message = this.eMx;
            antiData.setIfVoice(this.mVr);
            albumFloatActivityConfig.setExtraData(antiData, this.mPrefixData, this.lUv.getFirstDir(), this.lUv.getSecondDir());
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
        }
    }

    private void dIq() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.eKH.bc(arrayList);
        com.baidu.tbadk.editortools.m qe = this.eKH.qe(5);
        if (qe != null) {
            qe.eLu = 2;
        }
        this.eKH.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.eKH.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void dHM() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.m mVar;
        CustomResponsedMessage runTask2;
        com.baidu.tbadk.editortools.m mVar2;
        CustomResponsedMessage runTask3;
        com.baidu.tbadk.editortools.m mVar3;
        CustomResponsedMessage runTask4;
        com.baidu.tbadk.editortools.m mVar4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 1);
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            this.eKH.b(dVar);
        }
        if (!this.mRP) {
            Boolean dIF = dIF();
            if (!this.mVh && dIF != null && dIF.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.dxW() && com.baidu.tieba.tbadkCore.t.d(this.lUv.getForumName(), true) && (runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar4 = (com.baidu.tbadk.editortools.m) runTask4.getData()) != null) {
                mVar4.eLu = 2;
                if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    this.eKH.b(mVar4);
                }
            }
        }
        if (!this.mRP && (runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar3 = (com.baidu.tbadk.editortools.m) runTask3.getData()) != null) {
            mVar3.eLu = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.eKH.b(mVar3);
            }
        }
        if (!this.mRP) {
            this.eKH.b(new com.baidu.tbadk.editortools.l(getActivity(), 6));
        }
        if (!this.mRP) {
            this.eKH.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 7));
        } else {
            this.eKH.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        }
        if (at.equals(this.iwx, "2")) {
            this.eKH.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 3));
            this.eKH.b(new com.baidu.tbadk.editortools.e.a(getActivity(), 8));
        }
        if (!this.mRP && (runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar2 = (com.baidu.tbadk.editortools.m) runTask2.getData()) != null) {
            mVar2.eLw = true;
            mVar2.eLu = 9;
            mVar2.eLo = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.eKH.b(mVar2);
            }
        }
        if (!this.mRP && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar = (com.baidu.tbadk.editortools.m) runTask.getData()) != null) {
            mVar.eLw = true;
            mVar.eLu = 10;
            mVar.eLo = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.eKH.b(mVar);
            }
        }
        if (!this.mRP && this.mUD == null) {
            if (this.mUS == null) {
                this.mUS = new com.baidu.tieba.write.editor.b(getActivity(), this.iwx);
                this.mUS.bM(this.lUv.getForumId(), this.privateThread);
                this.mUS.xi(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.mUS.dGt();
                this.mUS.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                dIm();
            }
            if (!y.isEmpty(this.mList)) {
                this.mUS.dGt();
            }
            this.eKH.b(this.mUS);
        }
        if (!this.mRP && this.canGoods) {
            this.eKH.b(new com.baidu.tbadk.editortools.d(getActivity(), 10));
        }
        this.eKH.bc(arrayList);
        com.baidu.tbadk.editortools.m qe = this.eKH.qe(5);
        if (qe != null) {
            qe.eLu = 4;
        }
    }

    private void dHN() {
        if (this.mUU != null) {
            this.mUU.hideTip();
        }
    }

    private void dIr() {
        if (this.eKH != null) {
            this.eKH.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.14
                @Override // java.lang.Runnable
                public void run() {
                    if (WriteActivity.this.eKH != null && WriteActivity.this.eKH.eKK != null) {
                        if (WriteActivity.this.mVU == null) {
                            WriteActivity.this.mVU = new b(WriteActivity.this.getPageContext());
                        }
                        WriteActivity.this.mVU.showTip(WriteActivity.this.eKH.eKK.qc(2));
                    }
                }
            });
        }
    }

    private void dIs() {
        if (this.mVU != null) {
            this.mVU.hideTip();
        }
    }

    private void dHO() {
        if (this.mUU == null) {
            this.mUU = new g(getPageContext());
        }
        this.mUU.d(this.eKH);
    }

    private void cJX() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                VideoInfo videoInfo;
                WriteVoteData writeVoteData = null;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        TiebaStatic.log(new aq("c12612").ai("obj_locate", 9));
                        if (WriteActivity.this.dIb()) {
                            WriteActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new aq("c12612").ai("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.t)) {
                            com.baidu.tbadk.coreExtra.data.t tVar = (com.baidu.tbadk.coreExtra.data.t) aVar.data;
                            if (tVar.bmP() == EmotionGroupType.BIG_EMOTION || tVar.bmP() == EmotionGroupType.USER_COLLECT) {
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
                                    imageFileInfo.setFilePath(tVar.getName());
                                    imageFileInfo.width = tVar.getWidth();
                                    imageFileInfo.height = tVar.getHeight();
                                    WriteActivity.this.writeImagesInfo.addChooseFile(imageFileInfo);
                                    WriteActivity.this.writeImagesInfo.updateQuality();
                                    WriteActivity.this.xv(true);
                                    WriteActivity.this.dtm();
                                }
                            } else if (WriteActivity.this.dIb()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(tVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.dIe();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.f((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.cYr();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.dIM();
                        WriteActivity.this.dtm();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.JR(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.mUD == null) {
                            WriteActivity.this.bse();
                            return;
                        }
                        switch (WriteActivity.this.eMy) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ae.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.bsb();
                                    return;
                                } else {
                                    ae.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.brZ();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.eMs != null) {
                            WriteActivity.this.eMs.wg(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.jYz = null;
                        } else {
                            WriteActivity.this.jYz = (String) aVar.data;
                        }
                        WriteActivity.this.xu(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        aq aqVar = new aq("c10645");
                        aqVar.dD("fid", WriteActivity.this.lUv != null ? WriteActivity.this.lUv.getForumId() : "");
                        TiebaStatic.log(aqVar);
                        if (WriteActivity.this.lUv == null || (videoInfo = WriteActivity.this.lUv.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.eKH.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.eKH.bry()) {
                                        WriteActivity.this.eKH.bpY();
                                        WriteActivity.this.eKH.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.eKH.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.eKH.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.eKH.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.eKH.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.lUv.setVideoInfo(null);
                        WriteActivity.this.dtm();
                        if (WriteActivity.this.mUy != null) {
                            WriteActivity.this.mUy.requestFocus();
                        }
                        WriteActivity.this.eKH.bpY();
                        WriteActivity.this.eKH.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.mUy);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new aq("c12612").ai("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.eKH.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.mUt = true;
                        WriteActivity.this.xr(true);
                        if (!WriteActivity.this.dId().isFocused() || WriteActivity.this.mUx.getVisibility() != 0) {
                            WriteActivity.this.mUs = "from_content";
                        } else {
                            WriteActivity.this.mUs = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        TiebaStatic.log(new aq("c12612").ai("obj_locate", 8));
                        if (WriteActivity.this.mUx.getVisibility() == 0) {
                            if (WriteActivity.this.mUx.hasFocus()) {
                                WriteActivity.this.mUy.requestFocus();
                                WriteActivity.this.mUy.setSelection(WriteActivity.this.mUy.getText().toString().length());
                            }
                            WriteActivity.this.mUx.setVisibility(8);
                            WriteActivity.this.eKH.qb(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.mUx.setVisibility(0);
                            WriteActivity.this.mUx.requestFocus();
                            WriteActivity.this.eKH.qb(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.dtm();
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
                            TiebaStatic.log(new aq("c12612").ai("obj_locate", 10));
                            int intExtra = intent.getIntExtra(WriteActivityConfig.KEY_ANTI_POLL_LEVEL, 0);
                            if (intent.getIntExtra("key_write_level", -1) >= intExtra) {
                                if (WriteActivity.this.mVW != null && WriteActivity.this.mVW.getWriteVoteData() != null) {
                                    writeVoteData = WriteActivity.this.mVW.getWriteVoteData();
                                }
                                WriteActivity.this.a(writeVoteData);
                                TiebaStatic.log(new aq("c13800").ai("obj_source", 2));
                            } else {
                                WriteActivity.this.showToast(String.format(WriteActivity.this.getResources().getString(R.string.vote_level_tip), Integer.valueOf(intExtra)));
                                return;
                            }
                        }
                        WriteActivity.this.dIt();
                    } else if (aVar.code == 21) {
                        if (WriteActivity.this.mSY != null) {
                            WriteActivity.this.mSY.Qu();
                        }
                        TiebaStatic.log(new aq("c12612").ai("obj_locate", 5));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, "", true, null)));
                    } else if (aVar.code == 59) {
                        WriteActivity.this.dFP();
                    }
                }
            }
        };
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
        this.eKH.setActionListener(56, bVar);
        this.eKH.setActionListener(48, bVar);
        this.eKH.setActionListener(46, bVar);
        this.eKH.setActionListener(49, bVar);
        this.eKH.setActionListener(47, bVar);
        this.eKH.setActionListener(55, bVar);
        this.eKH.setActionListener(58, bVar);
        this.eKH.setActionListener(22, bVar);
        this.eKH.setActionListener(21, bVar);
        this.eKH.setActionListener(59, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIt() {
        if (this.mVo != null) {
            this.mVo.setVisibility(8);
        }
        if (this.mName != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
            layoutParams.rightMargin = this.mWn;
            this.mName.setLayoutParams(layoutParams);
        }
    }

    private void ar(Intent intent) {
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
            if (serializableExtra instanceof WriteVoteData) {
                final WriteVoteData writeVoteData = (WriteVoteData) serializableExtra;
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WriteActivity.this.a(writeVoteData);
                        TiebaStatic.log(new aq("c13800").ai("obj_source", 3));
                    }
                };
                this.mVW.ao(onClickListener);
                this.mVW.setOnItemClickListener(onClickListener);
                this.mVW.b(writeVoteData);
                this.mVW.xx(true);
                dtm();
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
    public void JR(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
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
        if (this.mVV != null) {
            this.mVV.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mWk);
        dHN();
        dIs();
        TiebaPrepareImageService.StopService();
        dte();
        if (!this.mWm) {
            dIu();
        }
        com.baidu.adp.lib.f.g.dismissDialog(this.ifZ, this);
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mVu != null) {
            this.mVu.destroy();
        }
        if (this.mVT != null) {
            this.mVT.NG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIu() {
        if (this.lUv != null && this.lUv.getType() == 2 && this.mVp) {
            finish();
        } else if (this.lUv == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.lUv.setTitle(dId().getText().toString());
            this.lUv.setContent(dIc().getText().toString());
            int type = this.lUv.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    if (this.mRP) {
                        x.e(this.lUv.getForumId(), this.lUv);
                    } else {
                        x.d(this.lUv.getForumId(), this.lUv);
                    }
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    x.d("24591571", this.lUv);
                }
            } else if (type == 1) {
                x.f(this.lUv.getThreadId(), this.lUv);
            } else if (type == 4) {
                x.d(this.lUv.getForumId() + "photolive", this.lUv);
            } else if (type == 5) {
                x.f(this.lUv.getThreadId() + "updatephotolive", this.lUv);
            }
            this.mWm = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIv() {
        if (this.kGw == null || !this.kGw.isEnabled() || this.mVY) {
            cqd();
            dIw();
            setResult(100);
            finish();
            return;
        }
        if (this.iga == null) {
            this.iga = new SaveDraftDialogView(this);
            this.iga.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            WriteActivity.this.cqd();
                            WriteActivity.this.dIw();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            WriteActivity.this.dIu();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        }
                        WriteActivity.this.ifZ.dismiss();
                    }
                }
            });
        }
        if (this.ifZ == null) {
            this.ifZ = new com.baidu.tbadk.core.dialog.i(getPageContext());
            this.ifZ.setContentView(this.iga);
        }
        boolean z = (this.mVV == null || !this.mVV.isVisible() || this.lUv == null || this.lUv.getVideoInfo() == null || this.lUv.getVideoInfo().isVideoMixFinished()) ? false : true;
        this.iga.setText(getString(z ? R.string.write_save_draft_dialog_video_fail_title : R.string.write_save_draft_dialog_normal_title), z ? getString(R.string.write_save_draft_dialog_video_fail_sub_title) : null, getString(z ? R.string.write_save_draft_dialog_video_fail_save_text : R.string.save));
        this.ifZ.Nv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqd() {
        if (this.lUv.getType() == 0 || this.lUv.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.mRP) {
                    x.e(this.lUv.getForumId(), (WriteData) null);
                } else {
                    x.d(this.lUv.getForumId(), (WriteData) null);
                }
            }
        } else if (this.lUv.getType() == 1) {
            x.f(this.lUv.getThreadId(), (WriteData) null);
        }
        this.mWm = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIw() {
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.mtS));
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
                dIv();
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
        getLayoutMode().onModeChanged(this.mVK);
        ap.setBackgroundColor(this.jfq, R.color.cp_bg_line_e);
        if (this.mVI != null && (i == 1 || i == 4)) {
            this.mVI.setBorderColor(ap.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bjq().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.kGw.setTextColor(ap.aP(R.color.cp_link_tip_a, i));
        dHL();
        ap.setBackgroundColor(this.lUO, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.mVz, R.color.cp_bg_line_c);
        ap.setBackgroundColor(dId(), R.color.cp_bg_line_e);
        ap.setImageResource(this.kFG, R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.jYz)) {
            ap.setBackgroundColor(dIc(), R.color.cp_bg_line_e);
        }
        dtm();
        this.eKH.onChangeSkinType(i);
        if (this.mUM != null) {
            this.mUM.bkF();
        }
        if (this.mWa != null) {
            this.mWa.notifyDataSetChanged();
        }
        ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        this.mVu.mWL.notifyDataSetChanged();
        dHQ();
        dHR();
        xu(false);
        if (this.mUT != null) {
            this.mUT.c(dId(), dIc());
        }
        if (this.mSl != null) {
            this.mSl.onChangeSkinType(i);
        }
        if (this.mVV != null) {
            this.mVV.changeSkin();
        }
        if (this.mVW != null) {
            this.mVW.onChangeSkinType(i);
        }
        if (this.mWf != null) {
            this.mWf.onChangeSkinType(i);
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
        if (this.lUN != null && this.lUN.getText() != null && this.lUN.getText().toString() != null && this.lUN.getPaint() != null) {
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
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        this.mVn = (TextView) findViewById(R.id.btn_image_problem);
        dHU();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kGw.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.kGw.setLayoutParams(layoutParams);
        this.kGw.setOnFocusChangeListener(this.gsF);
        this.mUN = (ScrollView) findViewById(R.id.write_scrollview);
        this.mUN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.mUy != null) {
                        com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.mUy);
                    }
                    if (WriteActivity.this.eKH != null) {
                        WriteActivity.this.eKH.bpY();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mVl = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.mVm = findViewById(R.id.feedback_divider);
        this.jfq = (RelativeLayout) findViewById(R.id.parent);
        this.mUw = (LinearLayout) findViewById(R.id.tool_view);
        this.mUw.setContentDescription(IStringUtil.TOP_PATH);
        this.mUx = (LinearLayout) findViewById(R.id.title_view);
        this.lUO = findViewById(R.id.interval_view);
        this.mVP = findViewById(R.id.hot_topic_fourm_view);
        this.mVQ = findViewById(R.id.hot_topic_divider);
        this.mUQ = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.mVR = (TextView) findViewById(R.id.change_one_tv);
        dtl();
        if (this.mUO) {
            this.mUN.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            dIo();
        } else {
            this.mVu = new i(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.mVu.xg(false);
            } else {
                this.mVu.xg(this.lUv.getType() == 0 || this.lUv.getType() == 9);
            }
            this.mVV = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            if (this.lUv.getVideoInfo() != null && this.lUv.getVideoInfo().isEditVideoDataLegal()) {
                xt(false);
                this.mVV.dJE();
            } else {
                xt(true);
            }
        }
        dtn();
        if (this.mVh || this.mUv) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().elB) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.lUQ = (LinearLayout) findViewById(R.id.post_content_container);
        this.lUQ.setDrawingCacheEnabled(false);
        this.lUQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.eKH.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.mUy.requestFocus();
            }
        });
        this.kFD = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.kFE = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.kFG = (ImageView) findViewById(R.id.iv_delete_voice);
        this.kFG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cYr();
            }
        });
        this.mBack.setOnFocusChangeListener(this.gsF);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dte();
                WriteActivity.this.dIv();
            }
        });
        this.mVn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        dHX();
        s(dIF());
        dHZ();
        dHT();
        dID();
        dHL();
        dHY();
        dtk();
        dIf();
        if (this.lUv.getType() == 4 && this.lUV != null && this.mUA != null) {
            this.lUV.setVisibility(8);
            this.mUA.setVisibility(8);
        }
        dtm();
        dIA();
        dGU();
        dHS();
        dIE();
        dIx();
        bGz();
    }

    private void dHS() {
        this.mSl = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.mSl.setData(this.mNM);
        this.mSl.setActivity(this);
    }

    private void dIx() {
        this.mWb = (LinearLayout) this.mRootView.findViewById(R.id.protocol);
        this.mWc = (ImageView) this.mRootView.findViewById(R.id.protocol_tag);
        this.mWd = (TextView) this.mRootView.findViewById(R.id.protocol_info);
        ap.setViewTextColor(this.mWd, R.color.cp_cont_j);
        this.mWf = new EBusinessProtocolView(this);
        this.mWf.a(EBusinessProtocolView.WindowType.PROTOCOL);
        this.mWf.setTitle(getResources().getString(R.string.protocol_title));
        SpannableString spannableString = new SpannableString(getResources().getString(R.string.readed_protocol));
        spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.showDialog(WriteActivity.this.mWf, WriteActivity.this);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(@NonNull TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, 6, 17, 34);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a)), 6, 17, 34);
        this.mWd.setText(spannableString);
        this.mWd.setMovementMethod(LinkMovementMethod.getInstance());
        this.mWc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.mWg) {
                    WriteActivity.this.mWg = false;
                    WriteActivity.this.mWc.setImageResource(R.drawable.icon_pure_use_uncheck16);
                } else {
                    WriteActivity.this.mWg = true;
                    WriteActivity.this.mWc.setImageResource(R.drawable.icon_mask_use_check16);
                }
                if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false) && WriteActivity.this.mWg) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this);
                    aVar.nv(R.color.cp_cont_b);
                    aVar.zz("");
                    aVar.zA(WriteActivity.this.getResources().getString(R.string.protocol_tip));
                    aVar.nw(1);
                    aVar.a("同意", new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.27.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", true);
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(PayHelper.STATUS_CANCEL_DESC, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.27.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false);
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(WriteActivity.this.getPageContext()).bhg();
                }
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false)) {
            this.mWg = true;
            this.mWc.setImageResource(R.drawable.icon_mask_use_check16);
        } else {
            this.mWg = false;
            this.mWc.setImageResource(R.drawable.icon_pure_use_uncheck16);
        }
        this.mWf.a(new EBusinessProtocolView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // com.baidu.tieba.write.write.EBusinessProtocolView.a
            public void xp(boolean z) {
                if (z) {
                    if (!WriteActivity.this.mWg) {
                        WriteActivity.this.mWg = true;
                        WriteActivity.this.mWc.setImageResource(R.drawable.icon_mask_use_check16);
                    }
                } else if (WriteActivity.this.mWg) {
                    WriteActivity.this.mWg = false;
                    WriteActivity.this.mWc.setImageResource(R.drawable.icon_pure_use_uncheck16);
                }
            }
        });
    }

    private void dIy() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
        this.mWn = layoutParams.rightMargin;
        layoutParams.rightMargin = 0;
        this.mName.setLayoutParams(layoutParams);
        this.mVo = (ImageView) this.mNavigationBar.getCenterImgBox();
        ap.setNavbarIconSrc(this.mVo, R.drawable.ic_icon_creation_question16_svg, R.drawable.ic_icon_creation_question16_svg);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds47);
        this.mVo.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mVo.getLayoutParams();
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        layoutParams2.width = dimens + dimens2 + dimens;
        layoutParams2.height = dimens + dimens2 + dimens;
        this.mVo.setLayoutParams(layoutParams2);
        this.mVo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dIz();
            }
        });
        this.mVo.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIz() {
        EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this);
        eBusinessProtocolView.a(EBusinessProtocolView.WindowType.TIP);
        eBusinessProtocolView.setTitle(getResources().getString(R.string.tip_title));
        com.baidu.adp.lib.f.g.showDialog(eBusinessProtocolView, this);
    }

    private void dGU() {
        if (this.mName != null && this.lUv != null && this.lUv.getProZone() == 1) {
            this.mName.setText(R.string.write_zone_profession_title);
        }
    }

    private void dHT() {
        String str;
        String str2;
        if (this.lUv != null) {
            switch (this.lUv.getType()) {
                case 0:
                case 9:
                    if (this.mVh || this.mUv) {
                        if (this.mVj) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.iwx != null && this.iwx.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                        if (this.mRP) {
                            this.mName.setText(R.string.publish_to_dynamic_title);
                        }
                    } else if (this.iwx != null && this.iwx.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.lUv.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.lUv.getForumName() + getResources().getString(R.string.bar));
                        this.lUN.setVisibility(8);
                        String str3 = this.hQP + " " + this.hQN;
                        if (!StringUtils.isNull(str3)) {
                            this.mUy.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.lUN.setVisibility(0);
                    this.mUy.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.mUy.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.lUN.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.mUy.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.lUv.getFloorNum() + 1)));
                    this.mVz.setVisibility(8);
                    return;
                case 7:
                    this.lUN.setVisibility(0);
                    this.mUy.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void dHU() {
        if (this.lUv.getType() == 7) {
            this.kGw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.kGw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void dHV() {
        if (this.lUv != null && this.lUv.getType() == 0 && this.lUv.getType() == 9 && !this.mVh && !this.mUv && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = at.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dId() != null) {
                dId().setText(cutStringWithSuffix);
                dId().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.kFD.setVisibility(0);
            this.kFE.setVoiceModel(voiceModel);
            this.kFE.bPf();
            dtm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYr() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.AM(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.kFD.setVisibility(8);
        this.kFE.cxq();
        this.kFE.setVoiceModel(null);
        com.baidu.tbadk.editortools.m qe = this.eKH.qe(6);
        if (qe != null && qe.eKB != null) {
            qe.eKB.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dtm();
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
            this.mUM.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bf bfVar) {
                    if (bfVar != null) {
                        WriteActivity.this.mUM.setText(bfVar.name);
                        WriteActivity.this.lUv.setCategoryTo(bfVar.hXt);
                        WriteActivity.this.mUL = bfVar.hXt;
                        WriteActivity.this.mUM.dHp();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.mUM.dHo();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dId());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dIc());
                }
            });
        }
    }

    private void dIA() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.mVb = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
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
        if (this.mVT == null) {
            this.mVT = new com.baidu.tieba.c.e(getPageContext(), this.lUV);
            this.mVT.eL(R.drawable.bg_tip_blue_up_left);
            this.mVT.eK(16);
            this.mVT.nu(true);
            this.mVT.setUseDirectOffset(true);
            this.mVT.vF(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.lUS = (TextView) findViewById(R.id.post_prefix);
        this.mUA = findViewById(R.id.prefix_divider);
        this.lUU = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.lUV.setVisibility(0);
            this.mVT.y(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.lUw = 0;
            this.lUV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq("c13013").dD("fid", WriteActivity.this.lUv.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.lUS.setVisibility(0);
                    WriteActivity.this.lUV.setSelected(true);
                    ap.setImageResource(WriteActivity.this.lUU, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.lUT, view, 0, com.baidu.adp.lib.util.l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.eKH.bpY();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.lUN);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.mUy);
                }
            });
            this.lUS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq("c13013").dD("fid", WriteActivity.this.lUv.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.lUS.setSelected(true);
                    ap.setImageResource(WriteActivity.this.lUU, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.lUT, view, 0, com.baidu.adp.lib.util.l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.eKH.bpY();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dId());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dIc());
                }
            });
            this.lUT = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.lUT.a(this);
            this.lUT.setMaxHeight(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds510));
            this.lUT.setOutsideTouchable(true);
            this.lUT.setFocusable(true);
            this.lUT.setOnDismissListener(this);
            this.lUT.setBackgroundDrawable(ap.getDrawable(R.color.cp_bg_line_d));
            int color = ap.getColor(R.color.cp_cont_b);
            ap.getColor(R.color.cp_cont_c);
            ap.setBackgroundResource(this.lUS, R.color.cp_bg_line_d);
            ap.setImageResource(this.lUU, R.drawable.icon_arrow_gray_down);
            this.lUS.setTextColor(color);
            this.mUB.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.mUB.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.xd(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.xd(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.lUT.addView(writePrefixItemLayout);
            }
            this.lUT.setCurrentIndex(0);
            this.lUS.setText(prefixs.get(0));
            JP(0);
            return;
        }
        this.lUV.setVisibility(8);
    }

    private void dIB() {
        if (this.mVh && this.lUv != null) {
            this.mVl.setVisibility(0);
            this.mVm.setVisibility(0);
            this.mUz = new FeedBackModel(getPageContext());
            this.mUz.ST(this.lUv.getForumName());
            this.mUz.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.36
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.mVl.setVisibility(8);
                        WriteActivity.this.mVm.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.mVl.setVisibility(8);
                        WriteActivity.this.mVm.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.mVl.a(feedBackModel.dHw(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void dHZ() {
        this.kGw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.dIU()) {
                    if (!WriteActivity.this.mWi || WriteActivity.this.mWg) {
                        if (WriteActivity.this.dIW()) {
                            int dIV = WriteActivity.this.dIV();
                            if (dIV == 1) {
                                WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_commodity));
                                return;
                            } else if (dIV == 2) {
                                WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_haowu_tab));
                                return;
                            }
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteActivity.this.showToast(R.string.neterror);
                        }
                        if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                            if (WriteActivity.this.mUT.a(WriteActivity.this.lUN, WriteActivity.this.mUy)) {
                                WriteActivity.this.showToast(WriteActivity.this.mUT.dFH());
                                return;
                            }
                            WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dId());
                            WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dIc());
                            WriteActivity.this.eKH.bpY();
                            if (WriteActivity.this.lUv.getType() != 7) {
                                if (WriteActivity.this.mVh) {
                                    WriteActivity.this.cqg();
                                    BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                                } else {
                                    aq aqVar = new aq("c12102");
                                    aqVar.ai("obj_type", StringUtils.isNull(WriteActivity.this.lUv.getForumName()) ? 1 : 2);
                                    TiebaStatic.log(aqVar);
                                    WriteActivity.this.dIi();
                                }
                            } else {
                                TiebaStatic.log("c12015");
                                WriteActivity.this.cqg();
                            }
                            MercatorModel.dxF().startLoad();
                            TiebaStatic.log(new aq("c12262").dD("obj_locate", WriteActivity.this.iwx));
                            return;
                        }
                        return;
                    }
                    WriteActivity.this.showToast(WriteActivity.this.getResources().getString(R.string.publish_faile_toast));
                    return;
                }
                WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_cant_but_commodity));
            }
        });
    }

    protected void dtl() {
        this.mVk = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.mVk.setIsRound(true);
        this.mVk.setDrawBorder(false);
        this.mVk.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String zW = q.zW(currentPortrait);
            this.mVk.setUrl(zW);
            this.mVk.startLoad(zW, 12, false);
        }
        if (this.lUv.isUserFeedback()) {
            this.mVk.setVisibility(0);
        }
        this.lUN = (EditText) findViewById(R.id.post_title);
        this.lUN.setOnClickListener(this.mUX);
        this.lUN.setOnFocusChangeListener(this.gsF);
        if (this.lUv.getType() == 0 || this.lUv.getType() == 9 || this.lUv.getType() == 7) {
            if (this.lUv.getTitle() != null) {
                this.lUN.setText(this.lUv.getTitle());
                this.lUN.setSelection(this.lUv.getTitle().length());
            } else if (this.mVj) {
                this.lUN.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.lUv.getType() == 1 || this.lUv.getType() != 2) {
        }
        this.lUN.addTextChangedListener(this.mUZ);
        if (!this.lUv.getHaveDraft()) {
            dHV();
            this.mVO = true;
        }
        if (this.lUv.isUserFeedback()) {
            this.lUN.setHint(getResources().getString(R.string.feedback_title_hint));
        } else {
            this.lUN.setHint(getResources().getString(R.string.post_title_hint));
        }
    }

    private TextWatcher aoy() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.38
            private EditText mEditText = null;
            private TextView mTextView = null;
            private int mWr;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.dtm();
                if (WriteActivity.this.mUO) {
                    this.mWr = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.mWr);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.mUO || !WriteActivity.this.mVG) {
                    if (WriteActivity.this.mUO) {
                        if (this.mEditText != WriteActivity.this.mVx || this.mTextView != WriteActivity.this.mVD) {
                            this.mEditText = WriteActivity.this.mVx;
                            this.mTextView = WriteActivity.this.mVD;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.mVB || this.mTextView != WriteActivity.this.mVC) {
                    this.mEditText = WriteActivity.this.mVB;
                    this.mTextView = WriteActivity.this.mVC;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.mUO && this.mVG) {
            if (this.mVE != null) {
                this.mVB.removeTextChangedListener(this.mVE);
            }
            this.mVE = textWatcher;
        } else if (this.mUO) {
            if (this.mVF != null) {
                this.mVx.removeTextChangedListener(this.mVF);
            }
            this.mVF = textWatcher;
        }
        return textWatcher;
    }

    private long k(EditText editText) {
        if (editText == this.mVx) {
            return 233L;
        }
        if (editText != this.mVB) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long k = k(editText);
            long l = k - l(editText);
            String valueOf = String.valueOf(l);
            if (k == 20) {
                if (l < 0) {
                    if (l < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(ap.getColor(R.color.common_color_10159));
                } else {
                    textView.setTextColor(ap.getColor(R.color.cp_cont_d));
                }
            } else if (l < 0) {
                if (l < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(ap.getColor(R.color.common_color_10159));
            } else {
                textView.setTextColor(ap.getColor(R.color.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long l(EditText editText) {
        return com.baidu.tieba.write.c.a.u(editText.getText().toString().trim());
    }

    protected void dtn() {
        this.mUy = (SpanGroupEditText) findViewById(R.id.post_content);
        this.mUy.setDrawingCacheEnabled(false);
        this.mUy.setOnClickListener(this.mUX);
        this.mUy.setOnSpanGroupChangedListener(new a.InterfaceC0544a() { // from class: com.baidu.tieba.write.write.WriteActivity.39
            @Override // com.baidu.tbadk.core.view.spanGroup.a.InterfaceC0544a
            public void E(int i, boolean z) {
                WriteActivity.this.Jw();
            }
        });
        this.mUy.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY);
        this.mUy.setForumId(com.baidu.adp.lib.f.b.toLong(this.lUv.getForumId(), 0L));
        this.mUy.setTransLink(!this.mRP);
        if (this.eMt != null) {
            this.eMt.setSpanGroupManager(this.mUy.getSpanGroupManager());
        }
        if (this.lUv != null) {
            this.lUv.setSpanGroupManager(this.mUy.getSpanGroupManager());
        }
        if (this.lUv.getContent() != null && this.lUv.getContent().length() > 0) {
            this.mUy.setText(TbFaceManager.bsW().ap(getPageContext().getPageActivity(), this.lUv.getContent()));
            if (this.mUy.getText() != null) {
                this.mUy.setSelection(this.mUy.getText().length());
            }
        } else if (this.lUv.getType() == 2) {
            if (this.mVp) {
                if (this.mVq != null && this.mVq.length() > 0) {
                    this.mUy.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.mVq}));
                    this.mUy.setSelection(this.mUy.getText().length());
                }
            } else if (this.lUv.getFloorNum() > 0) {
                this.mUy.setText(String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.lUv.getFloorNum())));
                this.mUy.setSelection(this.mUy.getText().length());
            }
        }
        this.mUy.setOnFocusChangeListener(this.gsF);
        this.mUy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.eKH.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.mUy.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.mUy.addTextChangedListener(this.mVa);
        if (this.lUv.getType() == 0) {
            this.mVS = true;
        } else {
            xu(true);
            this.mVS = false;
        }
        if (this.lUv.isUserFeedback()) {
            this.mUy.setHint(R.string.write_input_content);
        } else {
            this.mUy.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void xu(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.mUO && !this.mRP && dIc() != null) {
            dIc().setPadding(0, 0, 0, 0);
            dIc().setBackgroundDrawable(null);
            ap.setBackgroundColor(dIc(), R.color.cp_bg_line_d);
            if (TextUtils.isEmpty(this.jYz) || this.mUD != null) {
                return;
            }
            if (this.mVV == null || !this.mVV.isVisible()) {
                com.baidu.adp.lib.e.c.mM().a(this.jYz, 19, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.41
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass41) aVar, str, i);
                        if (aVar != null && aVar.getRawBitmap() != null && aVar.getPadding() != null) {
                            if (WriteActivity.this.mVV == null || !WriteActivity.this.mVV.isVisible()) {
                                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                                    ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                                }
                                WriteActivity.this.dIc().setBackgroundDrawable(ninePatchDrawable);
                                if (z) {
                                    com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.dIc(), true, WriteActivity.this.kMz);
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

    private void dIC() {
        if (dIc() != null) {
            dIc().setPadding(0, 0, 0, 0);
            dIc().setBackgroundDrawable(null);
            ap.setBackgroundColor(dIc(), R.color.cp_bg_line_d);
        }
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(boolean z) {
        if (!com.baidu.tbadk.plugins.b.k(getPageContext())) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.lUv != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.lUv.getForumId(), 0L), this.lUv.getFirstDir(), this.lUv.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(com.baidu.tbadk.coreExtra.data.t tVar) {
        if (((ImageSpan[]) dIc().getText().getSpans(0, dIc().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.mUC == null) {
                this.mUC = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            this.mUC.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, tVar, dIc());
    }

    EditText dIc() {
        return this.mUO ? this.mVx : this.mUy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dId() {
        return this.mUO ? this.mVB : this.lUN;
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

    private void s(Boolean bool) {
        String str = null;
        if (this.lUv != null) {
            str = this.lUv.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.mVh = true;
        }
    }

    private void dID() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void dIE() {
        this.mVX = (RelativeLayout) this.mRootView.findViewById(R.id.vote_layout_root);
        this.mVW = new com.baidu.tieba.write.write.vote.a(getPageContext(), this.mVX);
        ar(getIntent());
    }

    private void bGz() {
        this.mListView = (ListView) this.mRootView.findViewById(R.id.commodity_list);
        this.mWa = new d(getPageContext());
        this.mWa.a(this.mVZ);
        this.mListView.setAdapter((ListAdapter) this.mWa);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.43
            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (WriteActivity.this.mWa != null && (WriteActivity.this.mWa.getItem(i) instanceof t)) {
                    t tVar = (t) WriteActivity.this.mWa.getItem(i);
                    if (tVar.mType == 1) {
                        if (tVar.dXH == 1) {
                            be.bju().b(WriteActivity.this.getPageContext(), new String[]{tVar.dXz});
                        } else {
                            be.bju().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(tVar.dXz)});
                        }
                    } else if (tVar.mType == 2) {
                        if (!TextUtils.isEmpty(tVar.dXC)) {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(tVar.dXC));
                            intent.addFlags(268468224);
                            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                                WriteActivity.this.startActivity(intent);
                            } else if (!TextUtils.isEmpty(tVar.dXD)) {
                                be.bju().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(tVar.dXD)});
                            }
                        } else if (!TextUtils.isEmpty(tVar.dXD)) {
                            be.bju().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(tVar.dXD)});
                        }
                    }
                }
            }
        });
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

    private Boolean dIF() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                this.mVr = intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true);
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.eMx = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return Boolean.valueOf(this.mVr);
    }

    public void dtm() {
        this.mVY = false;
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
                    if (this.lUw == y.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.lUv.setIsNoTitle(true);
                        } else if (this.mUx.getVisibility() == 0) {
                            this.lUv.setIsNoTitle(false);
                            xs(true);
                            return;
                        }
                    } else if (this.mUx.getVisibility() == 0) {
                        this.lUv.setIsNoTitle(false);
                        xs(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.lUv.setIsNoTitle(true);
                } else if (this.mUx.getVisibility() == 0) {
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
            if (this.lUv.getType() == 4) {
                xs(n(this.mVx) && m(this.mVB));
            } else if (this.lUv.getType() == 5) {
                xs(n(this.mVx));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                xs(true);
            } else if (this.lUv.getVideoInfo() != null) {
                xs(this.lUv.getVideoInfo().isVideoMixFinished());
            } else if (dIS()) {
                xs(true);
                this.mVY = true;
            } else {
                xs(false);
            }
        }
    }

    public void xs(boolean z) {
        this.kGw.setEnabled(z);
    }

    private boolean m(EditText editText) {
        long l = l(editText);
        return l <= 20 && l > 0;
    }

    private boolean n(EditText editText) {
        long l = l(editText);
        if (l > 233) {
            return false;
        }
        return l > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        String str;
        this.eMt = new NewWriteModel(this);
        this.eMt.b(this.eMH);
        registerListener(this.mWj);
        registerListener(this.mWk);
        this.hJK = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.dte();
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
            this.lUv.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.lUv.setFloorNum(bundle.getInt("floor_num", 0));
            this.mVh = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.mVi = bundle.getBoolean(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.mVj = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.mVp = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.mVq = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.eMr = bundle.getString(WriteActivityConfig.PHOTO_NAME);
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
            this.mVs = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.lUv.setTitle(bundle.getString("write_title"));
            this.lUv.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.lUv.setTopicId(this.mTopicId);
            this.iwx = bundle.getString("KEY_CALL_FROM");
            this.boB = bundle.getInt("album_thread");
            this.mNM = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.lUv.setVideoInfo((VideoInfo) bundle.getSerializable(WriteVideoActivityConfig.VIDEO_INFO));
            this.canGoods = bundle.getBoolean(WriteActivityConfig.CAN_GOODS);
            str = string;
        } else {
            Intent intent = getIntent();
            this.lUv.setType(intent.getIntExtra("type", 0));
            this.lUv.setForumId(intent.getStringExtra("forum_id"));
            this.lUv.setForumName(intent.getStringExtra("forum_name"));
            this.lUv.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.lUv.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.lUv.setThreadId(intent.getStringExtra("thread_id"));
            this.lUv.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.lUv.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.mVh = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.mVi = intent.getBooleanExtra(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.mVj = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.mVp = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.mVq = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.mUD = (AdditionData) intent.getSerializableExtra("addition_data");
            this.lUv.setIsAddition(this.mUD != null);
            this.lUv.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mVs = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.hQO = intent.getStringExtra("more_forum_img");
            this.hQP = intent.getStringExtra("more_forum_title");
            this.hQN = intent.getStringExtra("more_forum_url");
            this.lUv.setTitle(intent.getStringExtra("write_title"));
            this.lUv.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.lUv.setTopicId(this.mTopicId);
            this.iwx = intent.getStringExtra("KEY_CALL_FROM");
            this.boB = intent.getIntExtra("album_thread", 0);
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mNM = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.lUv.setVideoInfo((VideoInfo) intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO));
            this.canGoods = intent.getBooleanExtra(WriteActivityConfig.CAN_GOODS, false);
            str = stringExtra;
        }
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.lUv.mDynamicImageTextData = new ImageTextUploadData();
            this.mRP = true;
        }
        if (this.lUv.getType() == 9) {
            this.lUv.setEntranceType(1);
        } else if (this.lUv.getType() == 10) {
            this.lUv.setEntranceType(2);
            this.lUv.setType(9);
        } else if (this.lUv.getType() == 0) {
            this.lUv.setEntranceType(3);
        }
        this.lUv.setIsUserFeedback(this.mVh);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.lUv.getType() == 4 ? 6 : 9);
        this.lUv.setWriteImagesInfo(this.writeImagesInfo);
        if (this.lUv.getType() == 0 || this.lUv.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.mRP) {
                    x.d(this.lUv.getForumId(), this);
                } else {
                    x.c(this.lUv.getForumId(), this);
                }
            }
        } else if (this.lUv.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                x.c("24591571", this);
            }
        } else if (this.lUv.getType() == 1) {
            x.a(this.lUv.getThreadId(), this);
        } else if (this.lUv.getType() == 4) {
            x.c(this.lUv.getForumId() + "photolive", this);
        } else if (this.lUv.getType() == 5) {
            x.a(this.lUv.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.jYz = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.lUv != null && this.lUv.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.lUv.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.mUv = true;
        }
        dHW();
        try {
            this.mVH = dIO();
        } catch (Throwable th) {
            this.mVH = null;
        }
    }

    private void dIf() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) y.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.lUN.setText(com.baidu.tbadk.plugins.b.Cz(com.baidu.tbadk.plugins.b.CA(hotTopicBussinessData.mTopicName)));
            this.lUN.setMovementMethod(com.baidu.tieba.view.c.dFi());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) y.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString Cz = com.baidu.tbadk.plugins.b.Cz(com.baidu.tbadk.plugins.b.CA(hotTopicBussinessData.mTopicName));
            if (Cz != null) {
                this.lUN.setText(Cz);
            }
            this.mUQ.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.x.a
    public void a(WriteData writeData) {
        int i = 0;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !this.mWi) {
            if (writeData != null) {
                if (this.lUv != null) {
                    boolean z = this.lUv.getVideoInfo() != null && this.lUv.getVideoInfo().isEditVideoDataLegal();
                    boolean z2 = (this.lUv.getWriteImagesInfo() == null || y.isEmpty(this.lUv.getWriteImagesInfo().getChosedFiles())) ? false : true;
                    boolean z3 = !com.baidu.adp.lib.util.k.isEmpty(dId().getText().toString());
                    boolean z4 = !com.baidu.adp.lib.util.k.isEmpty(dIc().getText().toString());
                    boolean z5 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle());
                    boolean z6 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent());
                    boolean z7 = at.isEmpty(writeData.getTitle()) && !e(TbFaceManager.bsW().a(getPageContext().getPageActivity(), writeData.getContent(), this.mUV));
                    if (!z || z7) {
                        this.lUv.setHaveDraft(true);
                        if (!z2 && !z) {
                            f(writeData);
                        }
                        if (!z && (!z3 || this.mVO || ((this.mVh || this.mUv) && z5))) {
                            g(writeData);
                        }
                        if (z6 && (!z4 || this.mVh || this.mUv)) {
                            h(writeData);
                        }
                        if (this.lUv != null && !this.lUv.getHaveDraft()) {
                            dHV();
                        }
                        if (writeData.getType() == 4 || writeData.getType() == 5) {
                            dIG();
                        }
                        dtm();
                        int categoryTo = writeData.getCategoryTo();
                        if (categoryTo >= 0 && this.fPt != null) {
                            this.mUL = this.mUI.hXt;
                            this.mUK = this.mUI.name;
                            while (true) {
                                if (i == this.fPt.size()) {
                                    break;
                                }
                                af afVar = this.fPt.get(i);
                                if (categoryTo != afVar.hXt) {
                                    i++;
                                } else {
                                    this.mUL = categoryTo;
                                    this.mUK = afVar.name;
                                    this.lUv.setCategoryTo(this.mUL);
                                    break;
                                }
                            }
                            if (this.mUM != null) {
                                this.mUM.setText(this.mUK);
                                this.mUM.setCategoryContainerData(this.fPt, this.mUI, this.mUL);
                            }
                        }
                        this.eKH.bpY();
                        return;
                    }
                    return;
                }
                return;
            }
            dIG();
            dHV();
        }
    }

    private void f(WriteData writeData) {
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(writeData.getVideoInfo());
            this.lUv.setVideoInfo(videoInfo);
            xt(false);
            return;
        }
        if (writeData.getWriteImagesInfo() != null) {
            this.writeImagesInfo = writeData.getWriteImagesInfo();
        }
        this.lUv.setWriteImagesInfo(this.writeImagesInfo);
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            dIk();
        }
        xv(false);
        xt(true);
    }

    private void g(WriteData writeData) {
        String str;
        String CA;
        if (com.baidu.adp.lib.util.k.isEmpty(this.lUv.getTitle())) {
            this.lUv.setTitle(writeData.getTitle());
        }
        if (!y.isEmpty(this.mList)) {
            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) y.getItem(this.mList, 0);
            if (hotTopicBussinessData == null) {
                str = null;
            } else {
                str = hotTopicBussinessData.mTopicName;
            }
            if (StringUtils.isNull(str)) {
                CA = this.lUv.getTitle();
            } else {
                CA = com.baidu.tbadk.plugins.b.CA(str);
            }
            SpannableString Cz = com.baidu.tbadk.plugins.b.Cz(CA);
            if (Cz != null) {
                dId().setText(Cz);
                dId().setSelection(Cz.length() > CA.length() ? CA.length() : Cz.length());
                return;
            }
            return;
        }
        SpannableString Cz2 = com.baidu.tbadk.plugins.b.Cz(this.lUv.getTitle());
        if (Cz2 != null) {
            dId().setText(Cz2);
            dId().setSelection(this.lUv.getTitle().length() > Cz2.length() ? Cz2.length() : this.lUv.getTitle().length());
        }
    }

    private void h(WriteData writeData) {
        this.lUv.setContent(writeData.getContent());
        SpannableString a2 = TbFaceManager.bsW().a(getPageContext().getPageActivity(), this.lUv.getContent(), this.mUV);
        InputFilter[] filters = this.mUy.getFilters();
        this.mUy.setFilters(new InputFilter[]{new InputFilter.LengthFilter(IMConstants.ERROR_BASE)});
        dIc().setText(a2);
        if (dIc() == this.mUy && this.mUy.getSpanGroupManager() != null) {
            this.mUy.bls();
            this.mUy.getSpanGroupManager().blz();
            this.mUy.blt();
            Jw();
        }
        this.mUy.setFilters(filters);
        if (dIc().getText() != null) {
            dIc().setSelection(dIc().getText().length());
        }
        if (this.mUO) {
            a(this.mVD, this.mVx);
        }
    }

    private void dIG() {
        if ((!this.mUO || this.mVw != null) && this.mVv != null) {
            this.mVw.b(this.writeImagesInfo);
            dIK();
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
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.lUv.getFloor());
        bundle.putInt("floor_num", this.lUv.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.mVp);
        if (this.mVh) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.eMr);
        if (this.mUD != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.mUD));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.mVs);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.iwx);
        bundle.putInt("album_thread", this.boB);
        bundle.putInt("private_thread", this.privateThread);
        bundle.putSerializable("tab_list", this.mNM);
        bundle.putBoolean(WriteActivityConfig.CAN_GOODS, this.canGoods);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
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

    private String getContent() {
        return (dIc() == null || dIc().getText() == null) ? "" : dIc().getText().toString();
    }

    private String dIh() {
        if (this.lUv == null || dId() == null || dId().getVisibility() != 0 || dId().getText() == null) {
            return "";
        }
        String obj = dId().getText().toString();
        if (this.mPrefixData != null && y.getCount(this.mPrefixData.getPrefixs()) > 0 && this.lUw != y.getCount(this.mPrefixData.getPrefixs()) - 1 && this.lUv.getType() != 4 && this.lUS != null && this.lUS.getText() != null) {
            this.lUv.setPostPrefix(this.lUS.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.lUv.getTitle();
        }
        return obj;
    }

    private void SV(String str) {
        if (this.lUv != null && this.mUx != null) {
            if (this.mUx.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.lUv.setIsNoTitle(true);
                    this.lUv.setTitle("");
                    return;
                }
                this.lUv.setIsNoTitle(false);
                this.lUv.setTitle(str);
                return;
            }
            this.lUv.setIsNoTitle(true);
            this.lUv.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqg() {
        if (this.mVV.isVisible() && dIc() != null && dIc().getText() != null) {
            int length = dIc().getText().toString().length();
            if (this.lUV != null && this.lUV.getVisibility() == 0 && this.lUw != y.getCount(this.mPrefixData.getPrefixs()) - 1 && this.lUS != null) {
                length += this.lUS.length();
            }
            if (length > com.baidu.tieba.write.video.b.mRU) {
                SU(String.format(getString(R.string.write_video_title_too_long), Integer.valueOf(com.baidu.tieba.write.video.b.mRU)));
                return;
            }
        }
        dte();
        this.lUv.setContent(getContent());
        SV(dIh());
        if (this.mVh || this.mUv) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.lUv.getTitle()) || !this.lUv.getTitle().startsWith(string)) {
                SV(string + this.lUv.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.lUv.getContent()) || !this.lUv.getContent().startsWith(str)) {
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
                sb.append(this.lUv.getContent());
                this.lUv.setContent(sb.toString());
            }
        }
        if (this.mVi) {
            this.lUv.setZhongcePrefix(String.format(getResources().getString(R.string.homepage_test_post_suffix), Build.MODEL, TbadkCoreApplication.getInst().getVersionName(), com.baidu.adp.lib.util.j.netTypeNameInUpperCase(), Build.VERSION.RELEASE));
        }
        if (this.mUJ >= 0) {
            this.lUv.setCategoryFrom(this.mUJ);
        }
        if (this.mUL >= 0) {
            this.lUv.setCategoryTo(this.mUL);
        }
        this.lUv.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mVW != null) {
            this.lUv.setWriteVoteData(this.mVW.getWriteVoteData());
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
            this.lUv.setTakePhotoNum(i);
        }
        this.lUv.setHasLocationData(this.eMs != null && this.eMs.bXA());
        if (this.writeImagesInfo != null) {
            this.eMt.wi(this.writeImagesInfo.size() > 0);
        }
        if (!y.isEmpty(this.mList) && this.mUP != null && this.mUP.mIsGlobalBlock == 0) {
            this.lUv.setForumId(String.valueOf(this.mUP.mForumId));
            this.lUv.setForumName(this.mUP.mForumName);
        }
        dGX();
        this.eMt.d(this.lUv);
        this.lUv.setContent(this.lUv.getContent().replaceAll("\u0000\n", ""));
        this.lUv.setContent(this.lUv.getContent().replaceAll("\u0000", ""));
        this.lUv.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.eMt.cLa().setVoice(this.mVoiceModel.getId());
                this.eMt.cLa().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.eMt.cLa().setVoice(null);
                this.eMt.cLa().setVoiceDuringTime(-1);
            }
        } else {
            this.eMt.cLa().setVoice(null);
            this.eMt.cLa().setVoiceDuringTime(-1);
        }
        if (!this.eMt.dya()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.lUv.mDynamicImageTextData != null) {
            dGW();
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.hJK);
            this.eMt.dxX();
        }
    }

    private void dGX() {
        FrsTabItemData selectedTabItemData;
        if (this.lUv != null && this.mSl != null && (selectedTabItemData = this.mSl.getSelectedTabItemData()) != null) {
            this.lUv.setTabId(selectedTabItemData.tabId);
            this.lUv.setTabName(selectedTabItemData.name);
            this.lUv.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    public void dGW() {
        if (this.lUv.mDynamicImageTextData != null) {
            showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
            com.baidu.tieba.write.b.a.a(this.lUv, new a.InterfaceC0828a() { // from class: com.baidu.tieba.write.write.WriteActivity.46
                @Override // com.baidu.tieba.write.b.a.InterfaceC0828a
                public void a(BaseUploadData baseUploadData) {
                    com.baidu.tieba.write.b.c.b.dGI().a((ImageTextUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.write.WriteActivity.46.1
                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onSuccess(String str) {
                            WriteActivity.this.cqd();
                            x.e(WriteActivity.this.lUv.getForumId(), (WriteData) null);
                            WriteActivity.this.dIw();
                            com.baidu.tieba.write.b.a.dGz();
                            WriteActivity.this.closeLoadingDialog();
                            com.baidu.tieba.tbadkCore.writeModel.c.g(WriteActivity.this.getPageContext().getPageActivity(), null, null, null);
                            WriteActivity.this.jr(true);
                            Intent intent = new Intent();
                            intent.putExtras(new Bundle());
                            WriteActivity.this.setResult(-1, intent);
                            WriteActivity.this.finish();
                        }

                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onFail(String str) {
                            com.baidu.tieba.write.b.a.dGz();
                            WriteActivity.this.closeLoadingDialog();
                            if (TextUtils.isEmpty(str)) {
                                str = TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error);
                            }
                            com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        }
                    });
                }

                @Override // com.baidu.tieba.write.b.a.InterfaceC0828a
                public void onError() {
                    WriteActivity.this.closeLoadingDialog();
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error));
                }
            });
        }
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
                if (this.lUN == getCurrentFocus()) {
                    dIc().clearFocus();
                    this.lUN.requestFocus();
                    if (this.eKH != null) {
                        this.eKH.bpY();
                    }
                    ShowSoftKeyPadDelay(this.lUN);
                } else {
                    dIc().requestFocus();
                    if (this.eKH != null) {
                        this.eKH.bpY();
                    }
                    ShowSoftKeyPadDelay(this.mUy);
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
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                cqd();
                dIw();
                l(postWriteCallBackData2);
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
                                dIL();
                            } else {
                                au(intent);
                            }
                        } else if (intExtra == 1) {
                            av(intent);
                        } else {
                            as(intent);
                            com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.47
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        xt(y.getCount(this.writeImagesInfo.getChosedFiles()) > 0);
                        if (this.mVS) {
                            xu(true);
                            this.mVS = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.mUO) {
                        F(intent);
                        dtm();
                        return;
                    }
                    at(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.lUv.setVideoInfo(videoInfo);
                        this.eKH.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.eKH.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.eKH.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    dtm();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
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
                } else if (i == 25005 && intent != null && !y.isEmpty(this.mList)) {
                    if (!y.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                        this.mUP = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                        a(this.mUP);
                    }
                } else if (i == 25048) {
                    ar(intent);
                } else if (i == 25049 && intent != null) {
                    String str = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT) + " ";
                    int selectionStart = this.mUy.getSelectionStart();
                    int selectionEnd = this.mUy.getSelectionEnd();
                    if (selectionStart >= 0) {
                        Editable text = this.mUy.getText();
                        if (selectionEnd > selectionStart) {
                            text.replace(selectionStart, selectionEnd, str);
                        } else {
                            text.insert(selectionStart, str);
                        }
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.eKH != null && !this.eKH.bry()) {
                this.mUy.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.eKH.bpY();
            }
            switch (i) {
                case RequestResponseCode.REQUEST_CAMERA /* 12001 */:
                    bsh();
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    dIJ();
                    if (this.mVS) {
                        xu(true);
                        this.mVS = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.lUN == getCurrentFocus()) {
                        dIc().clearFocus();
                        this.lUN.requestFocus();
                        if (this.eKH != null) {
                            this.eKH.bpY();
                        }
                        ShowSoftKeyPadDelay(this.lUN);
                        return;
                    }
                    dIc().requestFocus();
                    if (this.eKH != null) {
                        this.eKH.bpY();
                    }
                    ShowSoftKeyPadDelay(this.mUy);
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
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.eMr = String.valueOf(System.currentTimeMillis());
                    ao.c(getPageContext(), this.eMr);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dIJ();
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
        dIH();
        this.lUv.setToDynamic(this.isToDynamic);
        this.lUv.setCallFrom(this.iwx);
        if (this.lUv.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cqg();
    }

    private void dIj() {
        if (this.eKH != null) {
            this.eKH.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void dIH() {
        if (this.eKH != null) {
            this.eKH.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void dII() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void dIJ() {
        if (this.mUO) {
            this.mVw.b(this.writeImagesInfo);
            dIK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIK() {
        this.mVw.notifyDataSetChanged();
        this.mVv.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.48
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.mVw.notifyDataSetChanged();
                WriteActivity.this.mVv.invalidateViews();
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
        dtm();
    }

    private void as(Intent intent) {
        if (this.mUO) {
            at(intent);
            dIJ();
        } else {
            aw(intent);
        }
        dtm();
    }

    private void at(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            dIJ();
            xv(true);
        }
    }

    private void au(Intent intent) {
        if (this.writeImagesInfo != null) {
            E(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, size)));
            }
        }
    }

    private void dIL() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_CAMERA, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void av(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.mVt.parseJson(stringExtra);
            this.mVt.updateQuality();
            if (this.mVt.getChosedFiles() != null && this.mVt.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.mVt.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.mVt.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dId());
        HidenSoftKeyPad(this.mInputManager, dIc());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
        if (this.mVV != null) {
            this.mVV.onPause();
        }
        if (this.eKH.bry()) {
            this.eKH.bpY();
        }
    }

    private void aw(Intent intent) {
        b(intent, true);
    }

    private void E(Intent intent) {
        this.eMr = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.eMr;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.getEquipmentWidth(getPageContext().getPageActivity())), com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.eMr, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            dIM();
            dIk();
        }
        xv(true);
    }

    private void F(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                dIM();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    dIk();
                }
            }
            xv(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dIM() {
        if (this.eKH.qe(10) != null) {
            this.eKH.setToolEnabled(this.writeImagesInfo == null || y.getCount(this.writeImagesInfo.getChosedFiles()) < this.writeImagesInfo.getMaxImagesAllowed(), 10);
        }
    }

    private void bsh() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.49
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                n.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.eMr));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void dIN() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.hQO)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                o oVar = new o(this, this.hQO, new o.a() { // from class: com.baidu.tieba.write.write.WriteActivity.50
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
                            WriteActivity.this.xv(true);
                        }
                    }
                });
                oVar.setFrom(1);
                oVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(boolean z) {
        String forumId = this.lUv == null ? "" : this.lUv.getForumId();
        if (this.mVu != null) {
            this.mVu.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.hSU == null) {
            this.hSU = VoiceManager.instance();
        }
        return this.hSU;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cms() {
        this.hSU = getVoiceManager();
        this.hSU.stopPlay();
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
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.lUv.getType() != 7) {
                if (this.mUD == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
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
        if (!this.mUO) {
            if (this.eKH != null) {
                this.eKH.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.eKH.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.lUv == null ? "" : this.lUv.getForumId();
            if (this.mVu != null) {
                this.mVu.a(this.writeImagesInfo, this.mFrom, forumId);
            }
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
        if (i == y.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new aq("c13014").ai("obj_type", 1));
        } else {
            TiebaStatic.log(new aq("c13014").ai("obj_type", 2));
        }
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
        ap.setImageResource(this.lUU, R.drawable.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.mUy);
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
            com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
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
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = ae.transformPermissionResult(strArr, iArr);
            if (ae.checkCamera(getApplicationContext())) {
                ao.c(getPageContext(), this.eMr);
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
        this.bdF = z;
        if (this.mVM && System.currentTimeMillis() - this.mVN < 800) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.mVM = false;
        }
        if (this.mUS != null && !z) {
            this.mUS.cfQ();
        }
        if (this.mUU != null && !z) {
            dHN();
        }
        if (this.mVU != null && !z) {
            dIs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SW(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.mVJ != null) {
            SX(str);
            this.mVJ.dismiss();
        }
    }

    private void fP(Context context) {
        mVL = com.baidu.adp.lib.util.l.getEquipmentHeight(context);
    }

    private void SX(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.mVM = true;
        dIM();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            dIk();
        }
        xv(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [5344=4] */
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

    private File dIO() {
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

    private void dIP() {
        if (this.mVH != null && this.lUv.getType() == 0 && this.lUv.getType() == 9) {
            fP(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.51
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.mVH != null) {
                        WriteActivity.this.SW(WriteActivity.this.mVH.getAbsolutePath());
                    }
                }
            });
            this.mVI = (TbImageView) this.mBubbleView.findViewById(R.id.rec_img_view);
            this.mVK = (LinearLayout) this.mBubbleView.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.bik().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.mVH.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.bik().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.mVH.getAbsolutePath());
                Bitmap g = g(this.mVH.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (g != null) {
                    this.mVI.setImageBitmap(g);
                    this.mVI.setDrawBorder(true);
                    this.mVI.setBorderWidth(2);
                    this.mVI.setBorderColor(ap.getColor(R.color.common_color_10264));
                    this.mVJ = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.mVJ.setCanceledOnTouchOutside(true);
                    this.mVJ.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.52
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.mVM) {
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.mVN = System.currentTimeMillis();
                            }
                        }
                    });
                    this.mVJ.setContentView(this.mBubbleView);
                    this.mVJ.show();
                    Window window = this.mVJ.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (mVL / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.mVh || !y.isEmpty(this.mList) || !StringUtils.isNull(this.lUv.getTitle())) {
            this.mUx.setVisibility(0);
            this.mUx.requestFocus();
            return;
        }
        this.mUx.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIQ() {
        if (this.eKH != null) {
            this.eKH.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.53
                @Override // java.lang.Runnable
                public void run() {
                    if (!WriteActivity.this.mRP && WriteActivity.this.eKH != null && WriteActivity.this.eKH.eKK != null) {
                        String clipBoardContent = UtilHelper.getClipBoardContent();
                        if (at.isEmpty(clipBoardContent) || !be.bju().j(clipBoardContent)) {
                            WriteActivity.this.mUS.dgC();
                            return;
                        }
                        if (WriteActivity.this.mSY == null) {
                            WriteActivity.this.mSY = new FindNewLinkBubbleController(WriteActivity.this.getPageContext(), WriteActivity.this.mWl);
                        }
                        WriteActivity.this.mSY.a(WriteActivity.this.eKH.eKK.qc(31), clipBoardContent, FindNewLinkBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
                    }
                }
            });
        }
    }

    public String getCallFrom() {
        return this.iwx;
    }

    public WriteData cLa() {
        return this.lUv;
    }

    public FrsTabInfoData dIR() {
        return this.mNM;
    }

    public String getFrom() {
        return this.mFrom;
    }

    private boolean dIS() {
        return (this.mVW == null || this.mVX == null || this.mVW.getWriteVoteData() == null || this.mVX.getVisibility() != 0) ? false : true;
    }

    public void dFP() {
        if (this.lUv != null) {
            TiebaStatic.log(new aq("c13897").ai("obj_locate", 2).dD("fid", this.lUv.getForumId()).dD("fname", this.lUv.getForumName()));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("commodity_goods_show_first_dialog", false)) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.nw(2);
            aVar.ih(false);
            FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(getPageContext().getPageActivity());
            frsPublishFineGoodsDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.54
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.dismiss();
                        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("commodity_goods_show_first_dialog", true);
                        TiebaStatic.log(new aq("c13959").ai("obj_locate", 2).dD("fid", WriteActivity.this.lUv != null ? WriteActivity.this.lUv.getForumId() : "").dD("fname", WriteActivity.this.lUv != null ? WriteActivity.this.lUv.getForumName() : ""));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + WriteActivity.this.dIT()));
                    }
                }
            });
            aVar.aX(frsPublishFineGoodsDialogView);
            TiebaStatic.log(new aq("c13958").ai("obj_locate", 2).dD("fid", this.lUv != null ? this.lUv.getForumId() : "").dD("fname", this.lUv != null ? this.lUv.getForumName() : ""));
            aVar.b(getPageContext()).bhg();
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + dIT()));
    }

    public void Jw() {
        if (this.mWa != null && this.mWa.dHy() == null && this.mUy != null && this.mUy.getSpanGroupManager() != null) {
            this.mWa.h(this.mUy.getSpanGroupManager().blE());
            this.mWa.refreshData();
        } else if (this.mWa != null && this.mWa.dHy() != null) {
            this.mWa.refreshData();
        }
        if (this.mWa != null) {
            fD(this.mWa.dHx());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fD(List<t> list) {
        boolean z;
        if (list != null) {
            Iterator<t> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().mType == 2) {
                    z = true;
                    break;
                }
            }
            if (!z && this.mWb != null) {
                this.mWb.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SY(String str) {
        this.mWe = new ArrayList();
        ArrayList arrayList = new ArrayList();
        if (!StringUtils.isNull(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    arrayList.add(string);
                    this.mWe.add(com.baidu.tieba.i.a.dJ(jSONObject));
                }
                if (this.mWe.size() > 0) {
                    this.mWi = true;
                    this.mUy.i(this.mWe, arrayList);
                    dIy();
                    Jw();
                    this.mWb.setVisibility(0);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dIT() {
        if (this.mUy == null || this.mUy.getSpanGroupManager() == null) {
            return 10;
        }
        return 10 - this.mUy.getSpanGroupManager().blF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dIU() {
        return this.canGoods || this.mUy == null || this.mUy.getSpanGroupManager() == null || this.mUy.getSpanGroupManager().blF() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dIV() {
        boolean z = this.mWa == null || this.mWa.dHz();
        boolean z2 = (this.mSl == null || this.mSl.getSelectedTabItemData() == null || this.mSl.getSelectedTabItemData().tabType != 3) ? false : true;
        if (z && z2) {
            return 1;
        }
        return (z || z2) ? 0 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dIW() {
        if (this.mNM == null || y.isEmpty(this.mNM.tabList)) {
            return false;
        }
        for (FrsTabItemData frsTabItemData : this.mNM.tabList) {
            if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                return true;
            }
        }
        return false;
    }
}
