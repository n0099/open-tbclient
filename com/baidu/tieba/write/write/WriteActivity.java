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
    private static int mVt = 0;
    private EditorTools eKD;
    private String eMn;
    private LocationModel eMo;
    private NewWriteModel eMp;
    List<af> fPp;
    private String hQH;
    private String hQI;
    private String hQJ;
    private VoiceManager hSO;
    private com.baidu.tbadk.core.dialog.i ifT;
    private SaveDraftDialogView ifU;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private LinearLayout kFw;
    private PlayVoiceBntNew kFx;
    private ImageView kFz;
    private TextView lUD;
    private com.baidu.tieba.write.i lUE;
    private ImageView lUF;
    private View lUG;
    private int lUh;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private ListView mListView;
    private FrsTabInfoData mNu;
    private PostTopicData mPostTopicData;
    public PostPrefixData mPrefixData;
    private ForumTabSelectedView mRT;
    private FindNewLinkBubbleController mSF;
    private com.baidu.tieba.write.editor.b mUA;
    private g mUC;
    private com.baidu.tieba.view.b mUJ;
    private View mUU;
    private LinearLayout mUd;
    private LinearLayout mUe;
    private View mUh;
    private Toast mUj;
    private AdditionData mUl;
    private RelativeLayout mUm;
    private TextView mUn;
    private TextView mUo;
    private TextView mUp;
    af mUq;
    private int mUr;
    private String mUs;
    private int mUt;
    private PostCategoryView mUu;
    private HotTopicBussinessData mUx;
    private TextView mUy;
    private com.baidu.tieba.c.e mVB;
    private b mVC;
    private com.baidu.tieba.write.write.video.a mVD;
    private com.baidu.tieba.write.write.vote.a mVE;
    private RelativeLayout mVF;
    private boolean mVG;
    private d mVI;
    private LinearLayout mVJ;
    private ImageView mVK;
    private TextView mVL;
    private List<com.baidu.tieba.i.a> mVM;
    private EBusinessProtocolView mVN;
    private i mVc;
    private VoiceData.VoiceModel mVoiceModel;
    private View mVx;
    private View mVy;
    private TextView mVz;
    private int privateThread;
    private String mTZ = "";
    private boolean mUa = false;
    protected WriteData lUg = null;
    private boolean mUP = false;
    private boolean mUQ = false;
    private boolean mUc = false;
    private boolean mUR = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText lUy = null;
    private HeadImageView mUS = null;
    private View lUz = null;
    private LinearLayout lUB = null;
    private SpanGroupEditText mUf = null;
    private FeedBackModel mUg = null;
    private FeedBackTopListView mUT = null;
    private ArrayList<WritePrefixItemLayout> mUi = new ArrayList<>();
    private String jYs = null;
    private final KeyEvent hEQ = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView mUV = null;
    private TextView kGp = null;
    private TextView mName = null;
    private ImageView mUW = null;
    private DialogInterface.OnCancelListener hJE = null;
    private final Handler mHandler = new Handler();
    private boolean mUX = false;
    private String mUY = null;
    private RelativeLayout jfk = null;
    public boolean mUZ = true;
    public String eMt = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int eMu = 0;
    private int mVa = 0;
    private WriteImagesInfo mVb = new WriteImagesInfo();
    private View mRootView = null;
    private GridView mVd = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a mVe = null;
    private ScrollView mUv = null;
    private EditText mVf = null;
    private View mVg = null;
    private View mVh = null;
    private View mVi = null;
    private EditText mVj = null;
    private TextView mVk = null;
    private TextView mVl = null;
    private TextWatcher mVm = null;
    private TextWatcher mVn = null;
    private boolean mUw = false;
    private boolean mVo = false;
    private com.baidu.tbadk.core.view.a eUv = null;
    private String mFrom = "write";
    private File mVp = null;
    private TbImageView mVq = null;
    private View mBubbleView = null;
    private Dialog mVr = null;
    private LinearLayout mVs = null;
    private boolean mVu = false;
    private long mVv = -1000;
    private boolean mVw = false;
    private String iwr = "2";
    private int boy = 0;
    private boolean canGoods = false;
    private String mTopicId = "";
    private SpannableStringBuilder mUz = new SpannableStringBuilder();
    private boolean mVA = false;
    private boolean bdD = false;
    private final c mUB = new c();
    private boolean mRx = false;
    private final d.a mVH = new d.a() { // from class: com.baidu.tieba.write.write.WriteActivity.1
        @Override // com.baidu.tieba.write.write.d.a
        public void JN(int i) {
            if (WriteActivity.this.mUf != null) {
                WriteActivity.this.mUf.ph(i);
            }
        }

        @Override // com.baidu.tieba.write.write.d.a
        public void fC(List<t> list) {
            WriteActivity.this.fD(list);
        }
    };
    private boolean mVO = false;
    private int mVP = 0;
    private boolean mVQ = false;
    private final HttpMessageListener mVR = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.jYs)) {
                    WriteActivity.this.jYs = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.xs(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.jYs)) {
                    WriteActivity.this.jYs = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.jYs);
                    WriteActivity.this.xs(true);
                }
            }
        }
    };
    private CustomMessageListener mVS = new CustomMessageListener(2921494) { // from class: com.baidu.tieba.write.write.WriteActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (WriteActivity.this.lUg != null && WriteActivity.this.canGoods) {
                TiebaStatic.log(new aq("c13896").ai("obj_locate", 1).dD("fid", WriteActivity.this.lUg.getForumId()).dD("fname", WriteActivity.this.lUg.getForumName()));
            }
        }
    };
    private TbFaceManager.a mUD = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan Cj(String str) {
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
    private final AntiHelper.a hUk = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.45
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_WRITE));
        }
    };
    private FindNewLinkBubbleController.a mVT = new FindNewLinkBubbleController.a() { // from class: com.baidu.tieba.write.write.WriteActivity.55
        @Override // com.baidu.tieba.write.write.FindNewLinkBubbleController.a
        public void f(View view, String str) {
            if (WriteActivity.this.mSF != null) {
                TiebaStatic.log("c13802");
                WriteActivity.this.mSF.Qu();
                UtilHelper.clearClipBoard();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, str, false, null)));
            }
        }
    };
    private final NewWriteModel.d eMD = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.56
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.cmr();
            WriteActivity.this.closeLoadingDialog();
            WriteActivity.this.mVU = true;
            if (postWriteCallBackData != null && WriteActivity.this.lUg != null) {
                WriteActivity.this.mUB.bf(null);
                if (z) {
                    WriteActivity.this.jp(z);
                    if (WriteActivity.this.e(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    WriteActivity.this.cqc();
                    WriteActivity.this.dIn();
                    if ((WriteActivity.this.lUg.getType() == 0 || WriteActivity.this.lUg.getType() == 9) && !y.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                        TiebaStatic.log(new aq("c11731").dD("obj_id", WriteActivity.this.mTopicId));
                    }
                    WriteActivity.this.l(postWriteCallBackData);
                    if (!at.isEmpty(postWriteCallBackData.getVideoid()) && WriteActivity.this.lUg.getVideoInfo() != null) {
                        postWriteCallBackData.mVideoMd5 = WriteActivity.this.lUg.getVideoInfo().getVideoMd5();
                        if (!at.isEmpty(WriteActivity.this.lUg.getForumName())) {
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
                    WriteActivity.this.mUB.bf(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.mUB.Sw(postWriteCallBackData.getErrorString());
                    WriteActivity.this.mUB.b(WriteActivity.this.lUy, WriteActivity.this.mUf);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.c(WriteActivity.this.getActivity(), WriteActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.c(WriteActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this.getActivity());
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.zz(WriteActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.zz(postWriteCallBackData.getErrorString());
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
                    if (com.baidu.tbadk.t.a.CO(agVar.bmY())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, agVar.bmY());
                        if (WriteActivity.this.mUR) {
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
    private final LocationModel.a eMB = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.57
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bsp() {
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
    private final CustomMessageListener mhn = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.58
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.eMo.we(false);
                    WriteActivity.this.eMo.fU(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.eMo.we(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener mUE = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.2
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
                WriteActivity.this.dIH();
            }
        }
    };
    private final View.OnClickListener mUF = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.eKD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dHB = WriteActivity.this.dHB();
            if (dHB >= 0 && dHB < WriteActivity.this.mUf.getText().length()) {
                WriteActivity.this.mUf.setSelection(dHB);
            }
        }
    };
    private boolean mUG = true;
    private final View.OnFocusChangeListener gsB = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.7
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.lUy || view == WriteActivity.this.mBack || view == WriteActivity.this.kGp) {
                if (z) {
                    WriteActivity.this.mUG = true;
                    WriteActivity.this.dHC();
                    com.baidu.adp.lib.util.l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.lUy);
                    if (WriteActivity.this.eKD != null) {
                        WriteActivity.this.eKD.bpX();
                    }
                } else if (view == WriteActivity.this.lUy) {
                    WriteActivity.this.lUD.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.mUf && z) {
                WriteActivity.this.mUG = false;
                WriteActivity.this.dHC();
                com.baidu.adp.lib.util.l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.mUf);
                if (WriteActivity.this.eKD != null) {
                    WriteActivity.this.eKD.bpX();
                }
            }
            WriteActivity.this.dHH();
        }
    };
    private com.baidu.tbadk.mutiprocess.h hRT = new com.baidu.tbadk.mutiprocess.h<GoodsEvent>() { // from class: com.baidu.tieba.write.write.WriteActivity.8
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
    private boolean mVU = false;
    private TextWatcher mUH = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.18
        private String mUL = "";
        private String mUM;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mUM = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.mUM != null ? this.mUM.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dth();
            WriteActivity.this.dHI();
            EditText dHU = WriteActivity.this.dHU();
            if (editable != null && dHU != null && dHU.getText() != null) {
                if (this.mUL == null || !this.mUL.equals(editable.toString())) {
                    if (WriteActivity.this.mUB != null) {
                        this.mUL = dHU.getText().toString();
                        WriteActivity.this.mUB.b(dHU, true);
                        return;
                    }
                    return;
                }
                dHU.setSelection(dHU.getSelectionEnd());
            }
        }
    };
    private TextWatcher mUI = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.19
        private String mUM;
        private String mUN = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mUM = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.mUM != null ? this.mUM.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dth();
            EditText dHT = WriteActivity.this.dHT();
            if (editable != null && dHT != null && dHT.getText() != null) {
                if (this.mUN == null || !this.mUN.equals(editable.toString())) {
                    if (WriteActivity.this.mUB != null) {
                        this.mUN = dHT.getText().toString();
                        WriteActivity.this.mUB.b(dHT, false);
                        return;
                    }
                    return;
                }
                dHT.setSelection(dHT.getSelectionEnd());
            }
        }
    };
    private int mVV = 0;
    private final a.InterfaceC0806a kMs = new a.InterfaceC0806a() { // from class: com.baidu.tieba.write.write.WriteActivity.42
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0806a
        public void onRefresh() {
            WriteActivity.this.jYs = null;
            WriteActivity.this.xs(false);
            WriteActivity.this.eKD.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void brY() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void bsa() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bsc();
        } else if (this.eMo.dxn()) {
            brY();
        } else {
            this.eMo.we(false);
            a(1, true, (String) null);
            this.eMo.dxl();
        }
    }

    public void dId() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
            if (this.mUA != null) {
                this.mUA.dGm();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bsc();
        } else if (this.eMo != null) {
            this.eMo.we(false);
            a(1, true, (String) null);
            this.eMo.dxl();
        }
    }

    private void bsc() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nt(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.eMo.dxp();
                } else {
                    WriteActivity.this.eMB.bsp();
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
    public int dHB() {
        int selectionEnd = dHT().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dHT().getText().getSpans(0, dHT().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dHT().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dHT().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHC() {
        if (this.eKD != null) {
            if (this.mVD != null && this.mVD.isVisible()) {
                this.eKD.setBarLauncherEnabled(false);
                this.eKD.setDeskLauncherEnabled(false);
                this.eKD.setToolEnabled(true, 2);
                this.eKD.setToolEnabled(true, 32);
                if (this.mUA != null) {
                    this.mUA.xh(false);
                    return;
                }
                return;
            }
            this.eKD.setBarLauncherEnabled(!this.mUG);
            this.eKD.setDeskLauncherEnabled(this.mUG ? false : true);
            this.eKD.setToolEnabled(true, 26);
            this.eKD.setToolEnabled(true, 2);
            this.eKD.setToolEnabled(true, 30);
            if (this.mUA != null) {
                this.mUA.xh(true);
            }
            dID();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.mUw) {
            this.lUy.setVisibility(8);
            if (this.lUg.getType() == 5) {
                this.mVi.setVisibility(8);
            } else {
                this.mVi.setVisibility(0);
            }
            a(this.mVl, this.mVf);
            a(this.mVk, this.mVj);
            dth();
        }
        if (this.mUP) {
            this.mUG = true;
            dHC();
            if (this.eKD != null) {
                this.eKD.bpX();
            }
            this.lUy.requestFocus();
            ShowSoftKeyPadDelay(this.lUy);
        }
        if (this.mVD != null) {
            this.mVD.onResume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
        if (this.mVD != null) {
            this.mVD.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
        if (this.mVD != null) {
            this.mVD.onStop();
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
                    dIb();
                }
                xt(true);
            }
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.lUg.setVideoInfo((VideoInfo) serializableExtra);
            } else {
                this.lUg.setVideoInfo(null);
            }
            if (this.mVD == null) {
                this.mVD = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            }
            if (this.lUg.getVideoInfo() != null && this.lUg.getVideoInfo().isEditVideoDataLegal()) {
                xr(false);
                this.mVD.dJv();
                if (this.mUe != null && this.mUe.getVisibility() == 0) {
                    this.mUe.setVisibility(8);
                    if (this.eKD != null) {
                        this.eKD.qb(30).setName(getResources().getString(R.string.editor_add_title));
                    }
                }
                if (dHT() != null && e(dHT().getText())) {
                    dHT().setText("");
                    this.lUg.setContent("");
                    return;
                }
                return;
            }
            xr(true);
        }
    }

    public void SU(String str) {
        showToastWithDefaultIcon(str, BdToast.DefaultIcon.FAILURE);
    }

    public void xr(boolean z) {
        if (z) {
            this.lUg.setVideoInfo(null);
            this.mVD.setVideoInfo(null);
            this.mVc.dIP().setVisibility(0);
            xs(false);
        } else {
            this.mVD.setVideoInfo(this.lUg.getVideoInfo());
            this.writeImagesInfo.clear();
            this.mVc.dIP().setVisibility(8);
            dIt();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, false));
        }
        dth();
        dHC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        if (this.lUg.getType() == 0) {
            JQ(this.boy);
        }
        initUI();
        dIs();
        this.eMo = new LocationModel(getPageContext());
        this.eMo.a(this.eMB);
        registerListener(this.mhn);
        registerListener(this.mUE);
        registerListener(this.mBackgroundListener);
        cKE();
        dIG();
        if (this.mUw) {
            this.mVe.setEditorTools(this.eKD);
        } else {
            this.mUf.requestFocus();
        }
        dnT();
        dIb();
        dIE();
        this.hRT.setPriority(1);
        registerResponsedEventListener(GoodsEvent.class, this.hRT);
        dIe();
    }

    private void dIe() {
        SY(getIntent().getStringExtra("goods_list"));
    }

    @SuppressLint({"ResourceAsColor"})
    private void cKE() {
        this.eKD = new EditorTools(getActivity());
        this.eKD.setBarMaxLauCount(5);
        this.eKD.setMoreButtonAtEnd(true);
        this.eKD.setBarBackgroundColorId(R.color.cp_bg_line_h);
        this.eKD.setBarLauncherType(1);
        this.eKD.jh(true);
        this.eKD.ji(true);
        switch (this.lUg.getType()) {
            case 4:
            case 5:
                dIh();
                break;
            default:
                dHD();
                break;
        }
        this.eKD.build();
        if (this.mUd != null) {
            this.mUd.addView(this.eKD);
        }
        cJW();
        this.eKD.display();
        com.baidu.tbadk.editortools.h qb = this.eKD.qb(6);
        if (qb != null && !TextUtils.isEmpty(this.eMt)) {
            ((View) qb).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.eMt);
                }
            });
        }
        if (!this.mUw) {
            this.eKD.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.eKD.bpX();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.eKD.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.eKD.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (com.baidu.tbadk.core.sharedPref.b.bik().getInt("commodity_tip_show_controller", 0) == 0 && this.canGoods) {
            dIi();
            return;
        }
        if (!this.mRx) {
            dHF();
        }
        dIH();
    }

    private void dIf() {
        this.mVg = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.mVi = this.mVg.findViewById(R.id.live_post_title_container);
        this.mVf = (EditText) this.mVg.findViewById(R.id.live_post_content);
        this.mVd = (GridView) this.mVg.findViewById(R.id.photoLiveGridView);
        this.mVj = (EditText) this.mVg.findViewById(R.id.live_post_title);
        this.mVk = (TextView) this.mVg.findViewById(R.id.titleOverPlusNumber);
        this.mVl = (TextView) this.mVg.findViewById(R.id.contentOverPlusNumber);
        this.mVh = this.mVg.findViewById(R.id.live_interval_view);
        this.mVk.setText(String.valueOf(20));
        this.mVl.setText(String.valueOf(233));
        this.mVg.setVisibility(0);
        this.mVk.setVisibility(0);
        this.mVl.setVisibility(0);
        this.mVj.setHint(R.string.tips_title_limit_new);
        this.mVj.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.10
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.mVo = true;
                    WriteActivity.this.mUG = true;
                    WriteActivity.this.dHC();
                    if (WriteActivity.this.eKD != null) {
                        WriteActivity.this.eKD.bpX();
                    }
                }
            }
        });
        if (this.lUg.getType() == 4) {
            this.mVf.setHint(R.string.live_write_input_content_new);
        } else if (this.lUg.getType() == 5) {
            this.mVf.setHint(R.string.live_write_input_content_update);
        }
        this.mVf.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.mVo = false;
                    WriteActivity.this.mUG = false;
                    WriteActivity.this.dHC();
                    if (WriteActivity.this.eKD != null) {
                        WriteActivity.this.eKD.bpX();
                    }
                }
            }
        });
        this.mVf.requestFocus();
        this.mVf.addTextChangedListener(aoy());
        this.mVj.requestFocus();
        this.mVj.addTextChangedListener(aoy());
        this.mVj.setOnClickListener(this.mUF);
        this.mVf.setOnClickListener(this.mUF);
        this.mVe = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.mVd);
        this.mVe.JH(6);
        this.mVd.setAdapter((ListAdapter) this.mVe);
        View findViewById = this.mVg.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void dHe() {
                WriteActivity.this.dIB();
            }
        });
        dIg();
    }

    private void dIg() {
        if (this.lUg.getType() == 0) {
            if (this.lUg.getTitle() != null) {
                this.mVj.setText(this.lUg.getTitle());
                this.mVj.setSelection(this.lUg.getTitle().length());
                return;
            }
            return;
        }
        if (this.lUg.getType() == 1 || this.lUg.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.mUw) {
            dIz();
        }
        if (this.eKD.brx()) {
            this.eKD.bpX();
        }
        JQ(0);
    }

    public boolean dGb() {
        return (!"1".equals(this.iwr) && this.writeImagesInfo.size() == 0 && this.mVoiceModel == null && ((this.mUe == null || this.mUe.getVisibility() != 0) && (this.mUf == null || !this.mUf.blu()))) && (dHT() == null || !e(dHT().getText()));
    }

    private boolean e(Spannable spannable) {
        if (spannable != null) {
            ImageSpan[] imageSpanArr = (ImageSpan[]) spannable.getSpans(0, spannable.length(), ImageSpan.class);
            if (imageSpanArr != null && imageSpanArr.length > 0) {
                return true;
            }
            if (this.mUB != null) {
                if (this.mUB.d(spannable)) {
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
        if (this.writeImagesInfo != null && this.lUg != null) {
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.lUg.getForumId());
            albumFloatActivityConfig.getIntent().putExtra("forum_name", this.lUg.getForumName());
            albumFloatActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumFloatActivityConfig.setAlbumThread(i);
            albumFloatActivityConfig.setCanSelectVideo(dGb());
            albumFloatActivityConfig.setFromWrite(true);
            albumFloatActivityConfig.setCallFrom(this.iwr);
            albumFloatActivityConfig.setProfessionZone(this.lUg.getProZone());
            albumFloatActivityConfig.setFrsTabInfo(this.mNu);
            AntiData antiData = new AntiData();
            antiData.voice_message = this.eMt;
            antiData.setIfVoice(this.mUZ);
            albumFloatActivityConfig.setExtraData(antiData, this.mPrefixData, this.lUg.getFirstDir(), this.lUg.getSecondDir());
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
        }
    }

    private void dIh() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.eKD.bc(arrayList);
        com.baidu.tbadk.editortools.m qe = this.eKD.qe(5);
        if (qe != null) {
            qe.eLq = 2;
        }
        this.eKD.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.eKD.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void dHD() {
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
            this.eKD.b(dVar);
        }
        if (!this.mRx) {
            Boolean dIw = dIw();
            if (!this.mUP && dIw != null && dIw.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.dxR() && com.baidu.tieba.tbadkCore.t.d(this.lUg.getForumName(), true) && (runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar4 = (com.baidu.tbadk.editortools.m) runTask4.getData()) != null) {
                mVar4.eLq = 2;
                if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    this.eKD.b(mVar4);
                }
            }
        }
        if (!this.mRx && (runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar3 = (com.baidu.tbadk.editortools.m) runTask3.getData()) != null) {
            mVar3.eLq = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.eKD.b(mVar3);
            }
        }
        if (!this.mRx) {
            this.eKD.b(new com.baidu.tbadk.editortools.l(getActivity(), 6));
        }
        if (!this.mRx) {
            this.eKD.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 7));
        } else {
            this.eKD.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        }
        if (at.equals(this.iwr, "2")) {
            this.eKD.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 3));
            this.eKD.b(new com.baidu.tbadk.editortools.e.a(getActivity(), 8));
        }
        if (!this.mRx && (runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar2 = (com.baidu.tbadk.editortools.m) runTask2.getData()) != null) {
            mVar2.eLs = true;
            mVar2.eLq = 9;
            mVar2.eLk = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.eKD.b(mVar2);
            }
        }
        if (!this.mRx && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.m.class)) != null && (mVar = (com.baidu.tbadk.editortools.m) runTask.getData()) != null) {
            mVar.eLs = true;
            mVar.eLq = 10;
            mVar.eLk = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.eKD.b(mVar);
            }
        }
        if (!this.mRx && this.mUl == null) {
            if (this.mUA == null) {
                this.mUA = new com.baidu.tieba.write.editor.b(getActivity(), this.iwr);
                this.mUA.bM(this.lUg.getForumId(), this.privateThread);
                this.mUA.xg(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.mUA.dGk();
                this.mUA.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                dId();
            }
            if (!y.isEmpty(this.mList)) {
                this.mUA.dGk();
            }
            this.eKD.b(this.mUA);
        }
        if (!this.mRx && this.canGoods) {
            this.eKD.b(new com.baidu.tbadk.editortools.d(getActivity(), 10));
        }
        this.eKD.bc(arrayList);
        com.baidu.tbadk.editortools.m qe = this.eKD.qe(5);
        if (qe != null) {
            qe.eLq = 4;
        }
    }

    private void dHE() {
        if (this.mUC != null) {
            this.mUC.hideTip();
        }
    }

    private void dIi() {
        if (this.eKD != null) {
            this.eKD.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.14
                @Override // java.lang.Runnable
                public void run() {
                    if (WriteActivity.this.eKD != null && WriteActivity.this.eKD.eKG != null) {
                        if (WriteActivity.this.mVC == null) {
                            WriteActivity.this.mVC = new b(WriteActivity.this.getPageContext());
                        }
                        WriteActivity.this.mVC.showTip(WriteActivity.this.eKD.eKG.qc(2));
                    }
                }
            });
        }
    }

    private void dIj() {
        if (this.mVC != null) {
            this.mVC.hideTip();
        }
    }

    private void dHF() {
        if (this.mUC == null) {
            this.mUC = new g(getPageContext());
        }
        this.mUC.d(this.eKD);
    }

    private void cJW() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                VideoInfo videoInfo;
                WriteVoteData writeVoteData = null;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        TiebaStatic.log(new aq("c12612").ai("obj_locate", 9));
                        if (WriteActivity.this.dHS()) {
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
                                    WriteActivity.this.xt(true);
                                    WriteActivity.this.dth();
                                }
                            } else if (WriteActivity.this.dHS()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(tVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.dHV();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.f((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.cYq();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.dID();
                        WriteActivity.this.dth();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.JR(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.mUl == null) {
                            WriteActivity.this.bsd();
                            return;
                        }
                        switch (WriteActivity.this.eMu) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ae.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.bsa();
                                    return;
                                } else {
                                    ae.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.brY();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.eMo != null) {
                            WriteActivity.this.eMo.we(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.jYs = null;
                        } else {
                            WriteActivity.this.jYs = (String) aVar.data;
                        }
                        WriteActivity.this.xs(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        aq aqVar = new aq("c10645");
                        aqVar.dD("fid", WriteActivity.this.lUg != null ? WriteActivity.this.lUg.getForumId() : "");
                        TiebaStatic.log(aqVar);
                        if (WriteActivity.this.lUg == null || (videoInfo = WriteActivity.this.lUg.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.eKD.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.eKD.brx()) {
                                        WriteActivity.this.eKD.bpX();
                                        WriteActivity.this.eKD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.eKD.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.eKD.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.eKD.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.eKD.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.lUg.setVideoInfo(null);
                        WriteActivity.this.dth();
                        if (WriteActivity.this.mUf != null) {
                            WriteActivity.this.mUf.requestFocus();
                        }
                        WriteActivity.this.eKD.bpX();
                        WriteActivity.this.eKD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.mUf);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new aq("c12612").ai("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.eKD.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.mUa = true;
                        WriteActivity.this.xp(true);
                        if (!WriteActivity.this.dHU().isFocused() || WriteActivity.this.mUe.getVisibility() != 0) {
                            WriteActivity.this.mTZ = "from_content";
                        } else {
                            WriteActivity.this.mTZ = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        TiebaStatic.log(new aq("c12612").ai("obj_locate", 8));
                        if (WriteActivity.this.mUe.getVisibility() == 0) {
                            if (WriteActivity.this.mUe.hasFocus()) {
                                WriteActivity.this.mUf.requestFocus();
                                WriteActivity.this.mUf.setSelection(WriteActivity.this.mUf.getText().toString().length());
                            }
                            WriteActivity.this.mUe.setVisibility(8);
                            WriteActivity.this.eKD.qb(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.mUe.setVisibility(0);
                            WriteActivity.this.mUe.requestFocus();
                            WriteActivity.this.eKD.qb(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.dth();
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
                                if (WriteActivity.this.mVE != null && WriteActivity.this.mVE.getWriteVoteData() != null) {
                                    writeVoteData = WriteActivity.this.mVE.getWriteVoteData();
                                }
                                WriteActivity.this.a(writeVoteData);
                                TiebaStatic.log(new aq("c13800").ai("obj_source", 2));
                            } else {
                                WriteActivity.this.showToast(String.format(WriteActivity.this.getResources().getString(R.string.vote_level_tip), Integer.valueOf(intExtra)));
                                return;
                            }
                        }
                        WriteActivity.this.dIk();
                    } else if (aVar.code == 21) {
                        if (WriteActivity.this.mSF != null) {
                            WriteActivity.this.mSF.Qu();
                        }
                        TiebaStatic.log(new aq("c12612").ai("obj_locate", 5));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, "", true, null)));
                    } else if (aVar.code == 59) {
                        WriteActivity.this.dFG();
                    }
                }
            }
        };
        this.eKD.setActionListener(16, bVar);
        this.eKD.setActionListener(14, bVar);
        this.eKD.setActionListener(24, bVar);
        this.eKD.setActionListener(3, bVar);
        this.eKD.setActionListener(10, bVar);
        this.eKD.setActionListener(11, bVar);
        this.eKD.setActionListener(12, bVar);
        this.eKD.setActionListener(13, bVar);
        this.eKD.setActionListener(15, bVar);
        this.eKD.setActionListener(18, bVar);
        this.eKD.setActionListener(20, bVar);
        this.eKD.setActionListener(25, bVar);
        this.eKD.setActionListener(27, bVar);
        this.eKD.setActionListener(29, bVar);
        this.eKD.setActionListener(43, bVar);
        this.eKD.setActionListener(56, bVar);
        this.eKD.setActionListener(48, bVar);
        this.eKD.setActionListener(46, bVar);
        this.eKD.setActionListener(49, bVar);
        this.eKD.setActionListener(47, bVar);
        this.eKD.setActionListener(55, bVar);
        this.eKD.setActionListener(58, bVar);
        this.eKD.setActionListener(22, bVar);
        this.eKD.setActionListener(21, bVar);
        this.eKD.setActionListener(59, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIk() {
        if (this.mUW != null) {
            this.mUW.setVisibility(8);
        }
        if (this.mName != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
            layoutParams.rightMargin = this.mVV;
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
                this.mVE.ao(onClickListener);
                this.mVE.setOnItemClickListener(onClickListener);
                this.mVE.b(writeVoteData);
                this.mVE.xv(true);
                dth();
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
    public void bsd() {
        if (this.eMo.bXz()) {
            if (this.eMo.dxn()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.b.dxi().getLocationData().getFormatted_address());
                return;
            }
            a(1, true, (String) null);
            this.eMo.dxl();
            return;
        }
        a(0, true, (String) null);
    }

    protected void dsZ() {
        if (this.eMp != null) {
            this.eMp.cancelLoadData();
        }
        if (this.mUg != null) {
            this.mUg.cancelLoadData();
        }
        if (this.eMo != null) {
            this.eMo.cancelLoadData();
        }
        if (this.mVD != null) {
            this.mVD.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mVS);
        dHE();
        dIj();
        TiebaPrepareImageService.StopService();
        dsZ();
        if (!this.mVU) {
            dIl();
        }
        com.baidu.adp.lib.f.g.dismissDialog(this.ifT, this);
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mVc != null) {
            this.mVc.destroy();
        }
        if (this.mVB != null) {
            this.mVB.NG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIl() {
        if (this.lUg != null && this.lUg.getType() == 2 && this.mUX) {
            finish();
        } else if (this.lUg == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.lUg.setTitle(dHU().getText().toString());
            this.lUg.setContent(dHT().getText().toString());
            int type = this.lUg.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    if (this.mRx) {
                        x.e(this.lUg.getForumId(), this.lUg);
                    } else {
                        x.d(this.lUg.getForumId(), this.lUg);
                    }
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    x.d("24591571", this.lUg);
                }
            } else if (type == 1) {
                x.f(this.lUg.getThreadId(), this.lUg);
            } else if (type == 4) {
                x.d(this.lUg.getForumId() + "photolive", this.lUg);
            } else if (type == 5) {
                x.f(this.lUg.getThreadId() + "updatephotolive", this.lUg);
            }
            this.mVU = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIm() {
        if (this.kGp == null || !this.kGp.isEnabled() || this.mVG) {
            cqc();
            dIn();
            setResult(100);
            finish();
            return;
        }
        if (this.ifU == null) {
            this.ifU = new SaveDraftDialogView(this);
            this.ifU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            WriteActivity.this.cqc();
                            WriteActivity.this.dIn();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            WriteActivity.this.dIl();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        }
                        WriteActivity.this.ifT.dismiss();
                    }
                }
            });
        }
        if (this.ifT == null) {
            this.ifT = new com.baidu.tbadk.core.dialog.i(getPageContext());
            this.ifT.setContentView(this.ifU);
        }
        boolean z = (this.mVD == null || !this.mVD.isVisible() || this.lUg == null || this.lUg.getVideoInfo() == null || this.lUg.getVideoInfo().isVideoMixFinished()) ? false : true;
        this.ifU.setText(getString(z ? R.string.write_save_draft_dialog_video_fail_title : R.string.write_save_draft_dialog_normal_title), z ? getString(R.string.write_save_draft_dialog_video_fail_sub_title) : null, getString(z ? R.string.write_save_draft_dialog_video_fail_save_text : R.string.save));
        this.ifT.Nv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqc() {
        if (this.lUg.getType() == 0 || this.lUg.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.mRx) {
                    x.e(this.lUg.getForumId(), (WriteData) null);
                } else {
                    x.d(this.lUg.getForumId(), (WriteData) null);
                }
            }
        } else if (this.lUg.getType() == 1) {
            x.f(this.lUg.getThreadId(), (WriteData) null);
        }
        this.mVU = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIn() {
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.mtA));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.lUE != null && this.lUE.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.lUE, getPageContext().getPageActivity());
                return true;
            } else if (this.eKD.brx()) {
                this.eKD.bpX();
                return true;
            } else {
                dsZ();
                dIm();
                return true;
            }
        }
        if (i == 67 && (text = dHT().getText()) != null) {
            int selectionStart = dHT().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dHT().onKeyDown(67, this.hEQ);
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
        getLayoutMode().onModeChanged(this.jfk);
        getLayoutMode().onModeChanged(this.mVs);
        ap.setBackgroundColor(this.jfk, R.color.cp_bg_line_e);
        if (this.mVq != null && (i == 1 || i == 4)) {
            this.mVq.setBorderColor(ap.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bjq().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.kGp.setTextColor(ap.aP(R.color.cp_link_tip_a, i));
        dHC();
        ap.setBackgroundColor(this.lUz, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.mVh, R.color.cp_bg_line_c);
        ap.setBackgroundColor(dHU(), R.color.cp_bg_line_e);
        ap.setImageResource(this.kFz, R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.jYs)) {
            ap.setBackgroundColor(dHT(), R.color.cp_bg_line_e);
        }
        dth();
        this.eKD.onChangeSkinType(i);
        if (this.mUu != null) {
            this.mUu.bkF();
        }
        if (this.mVI != null) {
            this.mVI.notifyDataSetChanged();
        }
        ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        this.mVc.mWt.notifyDataSetChanged();
        dHH();
        dHI();
        xs(false);
        if (this.mUB != null) {
            this.mUB.c(dHU(), dHT());
        }
        if (this.mRT != null) {
            this.mRT.onChangeSkinType(i);
        }
        if (this.mVD != null) {
            this.mVD.changeSkin();
        }
        if (this.mVE != null) {
            this.mVE.onChangeSkinType(i);
        }
        if (this.mVN != null) {
            this.mVN.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHH() {
        if (this.lUy.hasFocus()) {
            this.lUy.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        } else {
            this.lUy.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        }
        if (this.mUf.hasFocus()) {
            this.mUf.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        } else {
            this.mUf.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHI() {
        if (this.lUy != null && this.lUy.getText() != null && this.lUy.getText().toString() != null && this.lUy.getPaint() != null) {
            if (this.lUy.getText().toString().length() == 0) {
                this.lUy.getPaint().setFakeBoldText(false);
            } else if (this.lUy.getText().toString().length() > 0) {
                this.lUy.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.eUv = new com.baidu.tbadk.core.view.a(getPageContext());
        this.mUw = this.lUg.getType() == 4 || 5 == this.lUg.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        this.mUV = (TextView) findViewById(R.id.btn_image_problem);
        dHL();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kGp.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.kGp.setLayoutParams(layoutParams);
        this.kGp.setOnFocusChangeListener(this.gsB);
        this.mUv = (ScrollView) findViewById(R.id.write_scrollview);
        this.mUv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.mUf != null) {
                        com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.mUf);
                    }
                    if (WriteActivity.this.eKD != null) {
                        WriteActivity.this.eKD.bpX();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mUT = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.mUU = findViewById(R.id.feedback_divider);
        this.jfk = (RelativeLayout) findViewById(R.id.parent);
        this.mUd = (LinearLayout) findViewById(R.id.tool_view);
        this.mUd.setContentDescription(IStringUtil.TOP_PATH);
        this.mUe = (LinearLayout) findViewById(R.id.title_view);
        this.lUz = findViewById(R.id.interval_view);
        this.mVx = findViewById(R.id.hot_topic_fourm_view);
        this.mVy = findViewById(R.id.hot_topic_divider);
        this.mUy = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.mVz = (TextView) findViewById(R.id.change_one_tv);
        dtg();
        if (this.mUw) {
            this.mUv.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            dIf();
        } else {
            this.mVc = new i(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.mVc.xe(false);
            } else {
                this.mVc.xe(this.lUg.getType() == 0 || this.lUg.getType() == 9);
            }
            this.mVD = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            if (this.lUg.getVideoInfo() != null && this.lUg.getVideoInfo().isEditVideoDataLegal()) {
                xr(false);
                this.mVD.dJv();
            } else {
                xr(true);
            }
        }
        dti();
        if (this.mUP || this.mUc) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().elx) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.lUB = (LinearLayout) findViewById(R.id.post_content_container);
        this.lUB.setDrawingCacheEnabled(false);
        this.lUB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.eKD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.mUf.requestFocus();
            }
        });
        this.kFw = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.kFx = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.kFz = (ImageView) findViewById(R.id.iv_delete_voice);
        this.kFz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cYq();
            }
        });
        this.mBack.setOnFocusChangeListener(this.gsB);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dsZ();
                WriteActivity.this.dIm();
            }
        });
        this.mUV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        dHO();
        s(dIw());
        dHQ();
        dHK();
        dIu();
        dHC();
        dHP();
        dtf();
        dHW();
        if (this.lUg.getType() == 4 && this.lUG != null && this.mUh != null) {
            this.lUG.setVisibility(8);
            this.mUh.setVisibility(8);
        }
        dth();
        dIr();
        dGL();
        dHJ();
        dIv();
        dIo();
        bGy();
    }

    private void dHJ() {
        this.mRT = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.mRT.setData(this.mNu);
        this.mRT.setActivity(this);
    }

    private void dIo() {
        this.mVJ = (LinearLayout) this.mRootView.findViewById(R.id.protocol);
        this.mVK = (ImageView) this.mRootView.findViewById(R.id.protocol_tag);
        this.mVL = (TextView) this.mRootView.findViewById(R.id.protocol_info);
        ap.setViewTextColor(this.mVL, R.color.cp_cont_j);
        this.mVN = new EBusinessProtocolView(this);
        this.mVN.a(EBusinessProtocolView.WindowType.PROTOCOL);
        this.mVN.setTitle(getResources().getString(R.string.protocol_title));
        SpannableString spannableString = new SpannableString(getResources().getString(R.string.readed_protocol));
        spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.showDialog(WriteActivity.this.mVN, WriteActivity.this);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(@NonNull TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, 6, 17, 34);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a)), 6, 17, 34);
        this.mVL.setText(spannableString);
        this.mVL.setMovementMethod(LinkMovementMethod.getInstance());
        this.mVK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.mVO) {
                    WriteActivity.this.mVO = false;
                    WriteActivity.this.mVK.setImageResource(R.drawable.icon_pure_use_uncheck16);
                } else {
                    WriteActivity.this.mVO = true;
                    WriteActivity.this.mVK.setImageResource(R.drawable.icon_mask_use_check16);
                }
                if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false) && WriteActivity.this.mVO) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this);
                    aVar.nv(R.color.cp_cont_b);
                    aVar.zy("");
                    aVar.zz(WriteActivity.this.getResources().getString(R.string.protocol_tip));
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
            this.mVO = true;
            this.mVK.setImageResource(R.drawable.icon_mask_use_check16);
        } else {
            this.mVO = false;
            this.mVK.setImageResource(R.drawable.icon_pure_use_uncheck16);
        }
        this.mVN.a(new EBusinessProtocolView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // com.baidu.tieba.write.write.EBusinessProtocolView.a
            public void xn(boolean z) {
                if (z) {
                    if (!WriteActivity.this.mVO) {
                        WriteActivity.this.mVO = true;
                        WriteActivity.this.mVK.setImageResource(R.drawable.icon_mask_use_check16);
                    }
                } else if (WriteActivity.this.mVO) {
                    WriteActivity.this.mVO = false;
                    WriteActivity.this.mVK.setImageResource(R.drawable.icon_pure_use_uncheck16);
                }
            }
        });
    }

    private void dIp() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
        this.mVV = layoutParams.rightMargin;
        layoutParams.rightMargin = 0;
        this.mName.setLayoutParams(layoutParams);
        this.mUW = (ImageView) this.mNavigationBar.getCenterImgBox();
        ap.setNavbarIconSrc(this.mUW, R.drawable.ic_icon_creation_question16_svg, R.drawable.ic_icon_creation_question16_svg);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds47);
        this.mUW.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mUW.getLayoutParams();
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        layoutParams2.width = dimens + dimens2 + dimens;
        layoutParams2.height = dimens + dimens2 + dimens;
        this.mUW.setLayoutParams(layoutParams2);
        this.mUW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dIq();
            }
        });
        this.mUW.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIq() {
        EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this);
        eBusinessProtocolView.a(EBusinessProtocolView.WindowType.TIP);
        eBusinessProtocolView.setTitle(getResources().getString(R.string.tip_title));
        com.baidu.adp.lib.f.g.showDialog(eBusinessProtocolView, this);
    }

    private void dGL() {
        if (this.mName != null && this.lUg != null && this.lUg.getProZone() == 1) {
            this.mName.setText(R.string.write_zone_profession_title);
        }
    }

    private void dHK() {
        String str;
        String str2;
        if (this.lUg != null) {
            switch (this.lUg.getType()) {
                case 0:
                case 9:
                    if (this.mUP || this.mUc) {
                        if (this.mUR) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.iwr != null && this.iwr.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                        if (this.mRx) {
                            this.mName.setText(R.string.publish_to_dynamic_title);
                        }
                    } else if (this.iwr != null && this.iwr.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.lUg.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.lUg.getForumName() + getResources().getString(R.string.bar));
                        this.lUy.setVisibility(8);
                        String str3 = this.hQJ + " " + this.hQH;
                        if (!StringUtils.isNull(str3)) {
                            this.mUf.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.lUy.setVisibility(0);
                    this.mUf.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.mUf.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.lUy.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.mUf.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.lUg.getFloorNum() + 1)));
                    this.mVh.setVisibility(8);
                    return;
                case 7:
                    this.lUy.setVisibility(0);
                    this.mUf.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void dHL() {
        if (this.lUg.getType() == 7) {
            this.kGp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.kGp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void dHM() {
        if (this.lUg != null && this.lUg.getType() == 0 && this.lUg.getType() == 9 && !this.mUP && !this.mUc && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = at.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dHU() != null) {
                dHU().setText(cutStringWithSuffix);
                dHU().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.kFw.setVisibility(0);
            this.kFx.setVoiceModel(voiceModel);
            this.kFx.bPe();
            dth();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYq() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.AL(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.kFw.setVisibility(8);
        this.kFx.cxp();
        this.kFx.setVoiceModel(null);
        com.baidu.tbadk.editortools.m qe = this.eKD.qe(6);
        if (qe != null && qe.eKx != null) {
            qe.eKx.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dth();
    }

    private void dHN() {
        this.fPp = null;
        this.mUr = -1;
        this.mUt = -1;
        ah xt = com.baidu.tieba.frs.ag.cnU().xt(1);
        if (xt != null) {
            this.fPp = xt.hXr;
            this.mUr = getIntent().getIntExtra("category_id", -1);
            if (this.fPp != null && !this.fPp.isEmpty() && this.mUr >= 0) {
                this.mUq = new af();
                this.mUq.hXn = 0;
                this.mUq.name = getPageContext().getResources().getString(R.string.category_auto);
                this.mUt = this.mUq.hXn;
                this.mUs = this.mUq.name;
                for (af afVar : this.fPp) {
                    if (afVar.hXn == this.mUr) {
                        this.mUt = afVar.hXn;
                        this.mUs = afVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dHO() {
        if (this.fPp != null && !this.fPp.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.mUu = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.mUu.setText(this.mUs);
            this.mUu.setCategoryContainerData(this.fPp, this.mUq, this.mUt);
            this.mUu.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bf bfVar) {
                    if (bfVar != null) {
                        WriteActivity.this.mUu.setText(bfVar.name);
                        WriteActivity.this.lUg.setCategoryTo(bfVar.hXn);
                        WriteActivity.this.mUt = bfVar.hXn;
                        WriteActivity.this.mUu.dHg();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.mUu.dHf();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dHU());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dHT());
                }
            });
        }
    }

    private void dIr() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.mUJ = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.mUJ.setTitle(R.string.no_disturb_start_time);
        this.mUJ.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.mUJ);
        this.mUJ.setButton(-2, getPageContext().getString(R.string.cancel), this.mUJ);
        return this.mUJ;
    }

    private void dHP() {
        this.mUm = (RelativeLayout) findViewById(R.id.addition_container);
        this.mUn = (TextView) findViewById(R.id.addition_create_time);
        this.mUo = (TextView) findViewById(R.id.addition_last_time);
        this.mUp = (TextView) findViewById(R.id.addition_last_content);
        if (this.mUl != null) {
            this.mUm.setVisibility(0);
            this.mUn.setText(getPageContext().getString(R.string.write_addition_create) + at.getFormatTime(this.mUl.getCreateTime() * 1000));
            if (this.mUl.getAlreadyCount() == 0) {
                this.mUo.setVisibility(8);
            } else {
                this.mUo.setText(getPageContext().getString(R.string.write_addition_last) + at.getFormatTime(this.mUl.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.mUl.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.mUp.setText(lastAdditionContent);
            } else {
                this.mUp.setVisibility(8);
            }
            dHT().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.mUl.getAlreadyCount()), Integer.valueOf(this.mUl.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.mUm.setVisibility(8);
    }

    private void dtf() {
        this.lUG = findViewById(R.id.post_prefix_layout);
        if (this.mVB == null) {
            this.mVB = new com.baidu.tieba.c.e(getPageContext(), this.lUG);
            this.mVB.eL(R.drawable.bg_tip_blue_up_left);
            this.mVB.eK(16);
            this.mVB.ns(true);
            this.mVB.setUseDirectOffset(true);
            this.mVB.vF(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.lUD = (TextView) findViewById(R.id.post_prefix);
        this.mUh = findViewById(R.id.prefix_divider);
        this.lUF = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.lUG.setVisibility(0);
            this.mVB.y(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.lUh = 0;
            this.lUG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq("c13013").dD("fid", WriteActivity.this.lUg.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.lUD.setVisibility(0);
                    WriteActivity.this.lUG.setSelected(true);
                    ap.setImageResource(WriteActivity.this.lUF, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.lUE, view, 0, com.baidu.adp.lib.util.l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.eKD.bpX();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.lUy);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.mUf);
                }
            });
            this.lUD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq("c13013").dD("fid", WriteActivity.this.lUg.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.lUD.setSelected(true);
                    ap.setImageResource(WriteActivity.this.lUF, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.lUE, view, 0, com.baidu.adp.lib.util.l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.eKD.bpX();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dHU());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dHT());
                }
            });
            this.lUE = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.lUE.a(this);
            this.lUE.setMaxHeight(com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds510));
            this.lUE.setOutsideTouchable(true);
            this.lUE.setFocusable(true);
            this.lUE.setOnDismissListener(this);
            this.lUE.setBackgroundDrawable(ap.getDrawable(R.color.cp_bg_line_d));
            int color = ap.getColor(R.color.cp_cont_b);
            ap.getColor(R.color.cp_cont_c);
            ap.setBackgroundResource(this.lUD, R.color.cp_bg_line_d);
            ap.setImageResource(this.lUF, R.drawable.icon_arrow_gray_down);
            this.lUD.setTextColor(color);
            this.mUi.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.mUi.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.xb(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.xb(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.lUE.addView(writePrefixItemLayout);
            }
            this.lUE.setCurrentIndex(0);
            this.lUD.setText(prefixs.get(0));
            JP(0);
            return;
        }
        this.lUG.setVisibility(8);
    }

    private void dIs() {
        if (this.mUP && this.lUg != null) {
            this.mUT.setVisibility(0);
            this.mUU.setVisibility(0);
            this.mUg = new FeedBackModel(getPageContext());
            this.mUg.ST(this.lUg.getForumName());
            this.mUg.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.36
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.mUT.setVisibility(8);
                        WriteActivity.this.mUU.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.mUT.setVisibility(8);
                        WriteActivity.this.mUU.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.mUT.a(feedBackModel.dHn(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void dHQ() {
        this.kGp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.dIL()) {
                    if (!WriteActivity.this.mVQ || WriteActivity.this.mVO) {
                        if (WriteActivity.this.dIN()) {
                            int dIM = WriteActivity.this.dIM();
                            if (dIM == 1) {
                                WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_commodity));
                                return;
                            } else if (dIM == 2) {
                                WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_haowu_tab));
                                return;
                            }
                        }
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            WriteActivity.this.showToast(R.string.neterror);
                        }
                        if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                            if (WriteActivity.this.mUB.a(WriteActivity.this.lUy, WriteActivity.this.mUf)) {
                                WriteActivity.this.showToast(WriteActivity.this.mUB.dFy());
                                return;
                            }
                            WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dHU());
                            WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dHT());
                            WriteActivity.this.eKD.bpX();
                            if (WriteActivity.this.lUg.getType() != 7) {
                                if (WriteActivity.this.mUP) {
                                    WriteActivity.this.cqf();
                                    BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                                } else {
                                    aq aqVar = new aq("c12102");
                                    aqVar.ai("obj_type", StringUtils.isNull(WriteActivity.this.lUg.getForumName()) ? 1 : 2);
                                    TiebaStatic.log(aqVar);
                                    WriteActivity.this.dHZ();
                                }
                            } else {
                                TiebaStatic.log("c12015");
                                WriteActivity.this.cqf();
                            }
                            MercatorModel.dxA().startLoad();
                            TiebaStatic.log(new aq("c12262").dD("obj_locate", WriteActivity.this.iwr));
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

    protected void dtg() {
        this.mUS = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.mUS.setIsRound(true);
        this.mUS.setDrawBorder(false);
        this.mUS.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String zV = q.zV(currentPortrait);
            this.mUS.setUrl(zV);
            this.mUS.startLoad(zV, 12, false);
        }
        if (this.lUg.isUserFeedback()) {
            this.mUS.setVisibility(0);
        }
        this.lUy = (EditText) findViewById(R.id.post_title);
        this.lUy.setOnClickListener(this.mUF);
        this.lUy.setOnFocusChangeListener(this.gsB);
        if (this.lUg.getType() == 0 || this.lUg.getType() == 9 || this.lUg.getType() == 7) {
            if (this.lUg.getTitle() != null) {
                this.lUy.setText(this.lUg.getTitle());
                this.lUy.setSelection(this.lUg.getTitle().length());
            } else if (this.mUR) {
                this.lUy.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.lUg.getType() == 1 || this.lUg.getType() != 2) {
        }
        this.lUy.addTextChangedListener(this.mUH);
        if (!this.lUg.getHaveDraft()) {
            dHM();
            this.mVw = true;
        }
        if (this.lUg.isUserFeedback()) {
            this.lUy.setHint(getResources().getString(R.string.feedback_title_hint));
        } else {
            this.lUy.setHint(getResources().getString(R.string.post_title_hint));
        }
    }

    private TextWatcher aoy() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.38
            private EditText mEditText = null;
            private TextView mTextView = null;
            private int mVZ;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.dth();
                if (WriteActivity.this.mUw) {
                    this.mVZ = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.mVZ);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.mUw || !WriteActivity.this.mVo) {
                    if (WriteActivity.this.mUw) {
                        if (this.mEditText != WriteActivity.this.mVf || this.mTextView != WriteActivity.this.mVl) {
                            this.mEditText = WriteActivity.this.mVf;
                            this.mTextView = WriteActivity.this.mVl;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.mVj || this.mTextView != WriteActivity.this.mVk) {
                    this.mEditText = WriteActivity.this.mVj;
                    this.mTextView = WriteActivity.this.mVk;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.mUw && this.mVo) {
            if (this.mVm != null) {
                this.mVj.removeTextChangedListener(this.mVm);
            }
            this.mVm = textWatcher;
        } else if (this.mUw) {
            if (this.mVn != null) {
                this.mVf.removeTextChangedListener(this.mVn);
            }
            this.mVn = textWatcher;
        }
        return textWatcher;
    }

    private long k(EditText editText) {
        if (editText == this.mVf) {
            return 233L;
        }
        if (editText != this.mVj) {
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

    protected void dti() {
        this.mUf = (SpanGroupEditText) findViewById(R.id.post_content);
        this.mUf.setDrawingCacheEnabled(false);
        this.mUf.setOnClickListener(this.mUF);
        this.mUf.setOnSpanGroupChangedListener(new a.InterfaceC0544a() { // from class: com.baidu.tieba.write.write.WriteActivity.39
            @Override // com.baidu.tbadk.core.view.spanGroup.a.InterfaceC0544a
            public void E(int i, boolean z) {
                WriteActivity.this.Jw();
            }
        });
        this.mUf.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY);
        this.mUf.setForumId(com.baidu.adp.lib.f.b.toLong(this.lUg.getForumId(), 0L));
        this.mUf.setTransLink(!this.mRx);
        if (this.eMp != null) {
            this.eMp.setSpanGroupManager(this.mUf.getSpanGroupManager());
        }
        if (this.lUg != null) {
            this.lUg.setSpanGroupManager(this.mUf.getSpanGroupManager());
        }
        if (this.lUg.getContent() != null && this.lUg.getContent().length() > 0) {
            this.mUf.setText(TbFaceManager.bsV().ap(getPageContext().getPageActivity(), this.lUg.getContent()));
            if (this.mUf.getText() != null) {
                this.mUf.setSelection(this.mUf.getText().length());
            }
        } else if (this.lUg.getType() == 2) {
            if (this.mUX) {
                if (this.mUY != null && this.mUY.length() > 0) {
                    this.mUf.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.mUY}));
                    this.mUf.setSelection(this.mUf.getText().length());
                }
            } else if (this.lUg.getFloorNum() > 0) {
                this.mUf.setText(String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.lUg.getFloorNum())));
                this.mUf.setSelection(this.mUf.getText().length());
            }
        }
        this.mUf.setOnFocusChangeListener(this.gsB);
        this.mUf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.eKD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.mUf.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.mUf.addTextChangedListener(this.mUI);
        if (this.lUg.getType() == 0) {
            this.mVA = true;
        } else {
            xs(true);
            this.mVA = false;
        }
        if (this.lUg.isUserFeedback()) {
            this.mUf.setHint(R.string.write_input_content);
        } else {
            this.mUf.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void xs(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.mUw && !this.mRx && dHT() != null) {
            dHT().setPadding(0, 0, 0, 0);
            dHT().setBackgroundDrawable(null);
            ap.setBackgroundColor(dHT(), R.color.cp_bg_line_d);
            if (TextUtils.isEmpty(this.jYs) || this.mUl != null) {
                return;
            }
            if (this.mVD == null || !this.mVD.isVisible()) {
                com.baidu.adp.lib.e.c.mM().a(this.jYs, 19, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.41
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass41) aVar, str, i);
                        if (aVar != null && aVar.getRawBitmap() != null && aVar.getPadding() != null) {
                            if (WriteActivity.this.mVD == null || !WriteActivity.this.mVD.isVisible()) {
                                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                                    ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                                }
                                WriteActivity.this.dHT().setBackgroundDrawable(ninePatchDrawable);
                                if (z) {
                                    com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.dHT(), true, WriteActivity.this.kMs);
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

    private void dIt() {
        if (dHT() != null) {
            dHT().setPadding(0, 0, 0, 0);
            dHT().setBackgroundDrawable(null);
            ap.setBackgroundColor(dHT(), R.color.cp_bg_line_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dHS() {
        int i = 5000;
        if (this.mUl != null) {
            i = 1000;
        }
        return dHT().getText() != null && dHT().getText().length() >= i;
    }

    private void BT(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.mTZ)) {
                this.mTZ = "";
                dHT().requestFocus();
                if (dHT().getText() != null && dHT().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dHT().getSelectionStart();
                    editable = dHT().getText();
                }
            } else if ("from_title".equals(this.mTZ)) {
                this.mTZ = "";
                dHU().requestFocus();
                if (dHU().getText() != null && dHU().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dHU().getSelectionStart();
                    editable = dHU().getText();
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
    public void xp(boolean z) {
        if (!com.baidu.tbadk.plugins.b.k(getPageContext())) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.lUg != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.lUg.getForumId(), 0L), this.lUg.getFirstDir(), this.lUg.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(com.baidu.tbadk.coreExtra.data.t tVar) {
        if (((ImageSpan[]) dHT().getText().getSpans(0, dHT().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.mUj == null) {
                this.mUj = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            this.mUj.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, tVar, dHT());
    }

    EditText dHT() {
        return this.mUw ? this.mVf : this.mUf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dHU() {
        return this.mUw ? this.mVj : this.lUy;
    }

    protected void dHV() {
        if (dHT().getSelectionStart() > 0) {
            String substring = dHT().getText().toString().substring(0, dHT().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.hEP.matcher(substring);
            if (matcher.find()) {
                dHT().getText().delete(dHT().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dHT().getSelectionStart());
                return;
            }
            dHT().onKeyDown(67, this.hEQ);
        }
    }

    private void s(Boolean bool) {
        String str = null;
        if (this.lUg != null) {
            str = this.lUg.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.mUP = true;
        }
    }

    private void dIu() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void dIv() {
        this.mVF = (RelativeLayout) this.mRootView.findViewById(R.id.vote_layout_root);
        this.mVE = new com.baidu.tieba.write.write.vote.a(getPageContext(), this.mVF);
        ar(getIntent());
    }

    private void bGy() {
        this.mListView = (ListView) this.mRootView.findViewById(R.id.commodity_list);
        this.mVI = new d(getPageContext());
        this.mVI.a(this.mVH);
        this.mListView.setAdapter((ListAdapter) this.mVI);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.43
            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (WriteActivity.this.mVI != null && (WriteActivity.this.mVI.getItem(i) instanceof t)) {
                    t tVar = (t) WriteActivity.this.mVI.getItem(i);
                    if (tVar.mType == 1) {
                        if (tVar.dXD == 1) {
                            be.bju().b(WriteActivity.this.getPageContext(), new String[]{tVar.dXv});
                        } else {
                            be.bju().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(tVar.dXv)});
                        }
                    } else if (tVar.mType == 2) {
                        if (!TextUtils.isEmpty(tVar.dXy)) {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(tVar.dXy));
                            intent.addFlags(268468224);
                            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                                WriteActivity.this.startActivity(intent);
                            } else if (!TextUtils.isEmpty(tVar.dXz)) {
                                be.bju().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(tVar.dXz)});
                            }
                        } else if (!TextUtils.isEmpty(tVar.dXz)) {
                            be.bju().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(tVar.dXz)});
                        }
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.eUv.setCancelListener(null);
        this.eUv.setTipString(R.string.sending);
        this.eUv.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.eUv.setDialogVisiable(false);
    }

    private Boolean dIw() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                this.mUZ = intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true);
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.eMt = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return Boolean.valueOf(this.mUZ);
    }

    public void dth() {
        this.mVG = false;
        if (this.lUg != null) {
            String str = "";
            String str2 = "";
            if (dHU() != null) {
                str = dHU().getText().toString();
            }
            if (dHT() != null) {
                str2 = dHT().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.lUg.getType() == 0 || this.lUg.getType() == 9 || this.lUg.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.lUh == y.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.lUg.setIsNoTitle(true);
                        } else if (this.mUe.getVisibility() == 0) {
                            this.lUg.setIsNoTitle(false);
                            xq(true);
                            return;
                        }
                    } else if (this.mUe.getVisibility() == 0) {
                        this.lUg.setIsNoTitle(false);
                        xq(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.lUg.setIsNoTitle(true);
                } else if (this.mUe.getVisibility() == 0) {
                    this.lUg.setIsNoTitle(false);
                    xq(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.mUw) {
                    xq(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    xq(true);
                }
            }
            if (this.lUg.getType() == 4) {
                xq(n(this.mVf) && m(this.mVj));
            } else if (this.lUg.getType() == 5) {
                xq(n(this.mVf));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                xq(true);
            } else if (this.lUg.getVideoInfo() != null) {
                xq(this.lUg.getVideoInfo().isVideoMixFinished());
            } else if (dIJ()) {
                xq(true);
                this.mVG = true;
            } else {
                xq(false);
            }
        }
    }

    public void xq(boolean z) {
        this.kGp.setEnabled(z);
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
        this.eMp = new NewWriteModel(this);
        this.eMp.b(this.eMD);
        registerListener(this.mVR);
        registerListener(this.mVS);
        this.hJE = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.dsZ();
            }
        };
        this.lUg = new WriteData();
        if (bundle != null) {
            this.lUg.setType(bundle.getInt("type", 0));
            this.lUg.setForumId(bundle.getString("forum_id"));
            this.lUg.setForumName(bundle.getString("forum_name"));
            this.lUg.setFirstDir(bundle.getString("forum_first_dir"));
            this.lUg.setSecondDir(bundle.getString("forum_second_dir"));
            this.lUg.setThreadId(bundle.getString("thread_id"));
            this.lUg.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.lUg.setFloorNum(bundle.getInt("floor_num", 0));
            this.mUP = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.mUQ = bundle.getBoolean(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.mUR = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.mUX = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.mUY = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.eMn = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.mUl = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.lUg.setIsAddition(this.mUl != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.mVa = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.lUg.setTitle(bundle.getString("write_title"));
            this.lUg.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.lUg.setTopicId(this.mTopicId);
            this.iwr = bundle.getString("KEY_CALL_FROM");
            this.boy = bundle.getInt("album_thread");
            this.mNu = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.lUg.setVideoInfo((VideoInfo) bundle.getSerializable(WriteVideoActivityConfig.VIDEO_INFO));
            this.canGoods = bundle.getBoolean(WriteActivityConfig.CAN_GOODS);
            str = string;
        } else {
            Intent intent = getIntent();
            this.lUg.setType(intent.getIntExtra("type", 0));
            this.lUg.setForumId(intent.getStringExtra("forum_id"));
            this.lUg.setForumName(intent.getStringExtra("forum_name"));
            this.lUg.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.lUg.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.lUg.setThreadId(intent.getStringExtra("thread_id"));
            this.lUg.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.lUg.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.mUP = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.mUQ = intent.getBooleanExtra(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.mUR = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.mUX = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.mUY = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.mUl = (AdditionData) intent.getSerializableExtra("addition_data");
            this.lUg.setIsAddition(this.mUl != null);
            this.lUg.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mVa = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.hQI = intent.getStringExtra("more_forum_img");
            this.hQJ = intent.getStringExtra("more_forum_title");
            this.hQH = intent.getStringExtra("more_forum_url");
            this.lUg.setTitle(intent.getStringExtra("write_title"));
            this.lUg.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.lUg.setTopicId(this.mTopicId);
            this.iwr = intent.getStringExtra("KEY_CALL_FROM");
            this.boy = intent.getIntExtra("album_thread", 0);
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mNu = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.lUg.setVideoInfo((VideoInfo) intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO));
            this.canGoods = intent.getBooleanExtra(WriteActivityConfig.CAN_GOODS, false);
            str = stringExtra;
        }
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.lUg.mDynamicImageTextData = new ImageTextUploadData();
            this.mRx = true;
        }
        if (this.lUg.getType() == 9) {
            this.lUg.setEntranceType(1);
        } else if (this.lUg.getType() == 10) {
            this.lUg.setEntranceType(2);
            this.lUg.setType(9);
        } else if (this.lUg.getType() == 0) {
            this.lUg.setEntranceType(3);
        }
        this.lUg.setIsUserFeedback(this.mUP);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.lUg.getType() == 4 ? 6 : 9);
        this.lUg.setWriteImagesInfo(this.writeImagesInfo);
        if (this.lUg.getType() == 0 || this.lUg.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.mRx) {
                    x.d(this.lUg.getForumId(), this);
                } else {
                    x.c(this.lUg.getForumId(), this);
                }
            }
        } else if (this.lUg.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                x.c("24591571", this);
            }
        } else if (this.lUg.getType() == 1) {
            x.a(this.lUg.getThreadId(), this);
        } else if (this.lUg.getType() == 4) {
            x.c(this.lUg.getForumId() + "photolive", this);
        } else if (this.lUg.getType() == 5) {
            x.a(this.lUg.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.jYs = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.lUg != null && this.lUg.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.lUg.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.mUc = true;
        }
        dHN();
        try {
            this.mVp = dIF();
        } catch (Throwable th) {
            this.mVp = null;
        }
    }

    private void dHW() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) y.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.lUy.setText(com.baidu.tbadk.plugins.b.Cy(com.baidu.tbadk.plugins.b.Cz(hotTopicBussinessData.mTopicName)));
            this.lUy.setMovementMethod(com.baidu.tieba.view.c.dEZ());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) y.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString Cy = com.baidu.tbadk.plugins.b.Cy(com.baidu.tbadk.plugins.b.Cz(hotTopicBussinessData.mTopicName));
            if (Cy != null) {
                this.lUy.setText(Cy);
            }
            this.mUy.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.x.a
    public void a(WriteData writeData) {
        int i = 0;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !this.mVQ) {
            if (writeData != null) {
                if (this.lUg != null) {
                    boolean z = this.lUg.getVideoInfo() != null && this.lUg.getVideoInfo().isEditVideoDataLegal();
                    boolean z2 = (this.lUg.getWriteImagesInfo() == null || y.isEmpty(this.lUg.getWriteImagesInfo().getChosedFiles())) ? false : true;
                    boolean z3 = !com.baidu.adp.lib.util.k.isEmpty(dHU().getText().toString());
                    boolean z4 = !com.baidu.adp.lib.util.k.isEmpty(dHT().getText().toString());
                    boolean z5 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle());
                    boolean z6 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent());
                    boolean z7 = at.isEmpty(writeData.getTitle()) && !e(TbFaceManager.bsV().a(getPageContext().getPageActivity(), writeData.getContent(), this.mUD));
                    if (!z || z7) {
                        this.lUg.setHaveDraft(true);
                        if (!z2 && !z) {
                            f(writeData);
                        }
                        if (!z && (!z3 || this.mVw || ((this.mUP || this.mUc) && z5))) {
                            g(writeData);
                        }
                        if (z6 && (!z4 || this.mUP || this.mUc)) {
                            h(writeData);
                        }
                        if (this.lUg != null && !this.lUg.getHaveDraft()) {
                            dHM();
                        }
                        if (writeData.getType() == 4 || writeData.getType() == 5) {
                            dIx();
                        }
                        dth();
                        int categoryTo = writeData.getCategoryTo();
                        if (categoryTo >= 0 && this.fPp != null) {
                            this.mUt = this.mUq.hXn;
                            this.mUs = this.mUq.name;
                            while (true) {
                                if (i == this.fPp.size()) {
                                    break;
                                }
                                af afVar = this.fPp.get(i);
                                if (categoryTo != afVar.hXn) {
                                    i++;
                                } else {
                                    this.mUt = categoryTo;
                                    this.mUs = afVar.name;
                                    this.lUg.setCategoryTo(this.mUt);
                                    break;
                                }
                            }
                            if (this.mUu != null) {
                                this.mUu.setText(this.mUs);
                                this.mUu.setCategoryContainerData(this.fPp, this.mUq, this.mUt);
                            }
                        }
                        this.eKD.bpX();
                        return;
                    }
                    return;
                }
                return;
            }
            dIx();
            dHM();
        }
    }

    private void f(WriteData writeData) {
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(writeData.getVideoInfo());
            this.lUg.setVideoInfo(videoInfo);
            xr(false);
            return;
        }
        if (writeData.getWriteImagesInfo() != null) {
            this.writeImagesInfo = writeData.getWriteImagesInfo();
        }
        this.lUg.setWriteImagesInfo(this.writeImagesInfo);
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            dIb();
        }
        xt(false);
        xr(true);
    }

    private void g(WriteData writeData) {
        String str;
        String Cz;
        if (com.baidu.adp.lib.util.k.isEmpty(this.lUg.getTitle())) {
            this.lUg.setTitle(writeData.getTitle());
        }
        if (!y.isEmpty(this.mList)) {
            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) y.getItem(this.mList, 0);
            if (hotTopicBussinessData == null) {
                str = null;
            } else {
                str = hotTopicBussinessData.mTopicName;
            }
            if (StringUtils.isNull(str)) {
                Cz = this.lUg.getTitle();
            } else {
                Cz = com.baidu.tbadk.plugins.b.Cz(str);
            }
            SpannableString Cy = com.baidu.tbadk.plugins.b.Cy(Cz);
            if (Cy != null) {
                dHU().setText(Cy);
                dHU().setSelection(Cy.length() > Cz.length() ? Cz.length() : Cy.length());
                return;
            }
            return;
        }
        SpannableString Cy2 = com.baidu.tbadk.plugins.b.Cy(this.lUg.getTitle());
        if (Cy2 != null) {
            dHU().setText(Cy2);
            dHU().setSelection(this.lUg.getTitle().length() > Cy2.length() ? Cy2.length() : this.lUg.getTitle().length());
        }
    }

    private void h(WriteData writeData) {
        this.lUg.setContent(writeData.getContent());
        SpannableString a2 = TbFaceManager.bsV().a(getPageContext().getPageActivity(), this.lUg.getContent(), this.mUD);
        InputFilter[] filters = this.mUf.getFilters();
        this.mUf.setFilters(new InputFilter[]{new InputFilter.LengthFilter(IMConstants.ERROR_BASE)});
        dHT().setText(a2);
        if (dHT() == this.mUf && this.mUf.getSpanGroupManager() != null) {
            this.mUf.bls();
            this.mUf.getSpanGroupManager().blz();
            this.mUf.blt();
            Jw();
        }
        this.mUf.setFilters(filters);
        if (dHT().getText() != null) {
            dHT().setSelection(dHT().getText().length());
        }
        if (this.mUw) {
            a(this.mVl, this.mVf);
        }
    }

    private void dIx() {
        if ((!this.mUw || this.mVe != null) && this.mVd != null) {
            this.mVe.b(this.writeImagesInfo);
            dIB();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.lUg.getType());
        bundle.putString("forum_id", this.lUg.getForumId());
        bundle.putString("forum_name", this.lUg.getForumName());
        bundle.putString("forum_first_dir", this.lUg.getFirstDir());
        bundle.putString("forum_second_dir", this.lUg.getSecondDir());
        bundle.putString("thread_id", this.lUg.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.lUg.getFloor());
        bundle.putInt("floor_num", this.lUg.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.mUX);
        if (this.mUP) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.eMn);
        if (this.mUl != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.mUl));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.mVa);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.iwr);
        bundle.putInt("album_thread", this.boy);
        bundle.putInt("private_thread", this.privateThread);
        bundle.putSerializable("tab_list", this.mNu);
        bundle.putBoolean(WriteActivityConfig.CAN_GOODS, this.canGoods);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dHT().getEditableText().toString();
        if (obj != null) {
            dHT().setText(TbFaceManager.bsV().a(getPageContext().getPageActivity(), obj, this.mUD));
            dHT().setSelection(dHT().getText().length());
        }
    }

    private String getContent() {
        return (dHT() == null || dHT().getText() == null) ? "" : dHT().getText().toString();
    }

    private String dHY() {
        if (this.lUg == null || dHU() == null || dHU().getVisibility() != 0 || dHU().getText() == null) {
            return "";
        }
        String obj = dHU().getText().toString();
        if (this.mPrefixData != null && y.getCount(this.mPrefixData.getPrefixs()) > 0 && this.lUh != y.getCount(this.mPrefixData.getPrefixs()) - 1 && this.lUg.getType() != 4 && this.lUD != null && this.lUD.getText() != null) {
            this.lUg.setPostPrefix(this.lUD.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.lUg.getTitle();
        }
        return obj;
    }

    private void SV(String str) {
        if (this.lUg != null && this.mUe != null) {
            if (this.mUe.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.lUg.setIsNoTitle(true);
                    this.lUg.setTitle("");
                    return;
                }
                this.lUg.setIsNoTitle(false);
                this.lUg.setTitle(str);
                return;
            }
            this.lUg.setIsNoTitle(true);
            this.lUg.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqf() {
        if (this.mVD.isVisible() && dHT() != null && dHT().getText() != null) {
            int length = dHT().getText().toString().length();
            if (this.lUG != null && this.lUG.getVisibility() == 0 && this.lUh != y.getCount(this.mPrefixData.getPrefixs()) - 1 && this.lUD != null) {
                length += this.lUD.length();
            }
            if (length > com.baidu.tieba.write.video.b.mRC) {
                SU(String.format(getString(R.string.write_video_title_too_long), Integer.valueOf(com.baidu.tieba.write.video.b.mRC)));
                return;
            }
        }
        dsZ();
        this.lUg.setContent(getContent());
        SV(dHY());
        if (this.mUP || this.mUc) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.lUg.getTitle()) || !this.lUg.getTitle().startsWith(string)) {
                SV(string + this.lUg.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.lUg.getContent()) || !this.lUg.getContent().startsWith(str)) {
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
                sb.append(this.lUg.getContent());
                this.lUg.setContent(sb.toString());
            }
        }
        if (this.mUQ) {
            this.lUg.setZhongcePrefix(String.format(getResources().getString(R.string.homepage_test_post_suffix), Build.MODEL, TbadkCoreApplication.getInst().getVersionName(), com.baidu.adp.lib.util.j.netTypeNameInUpperCase(), Build.VERSION.RELEASE));
        }
        if (this.mUr >= 0) {
            this.lUg.setCategoryFrom(this.mUr);
        }
        if (this.mUt >= 0) {
            this.lUg.setCategoryTo(this.mUt);
        }
        this.lUg.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mVE != null) {
            this.lUg.setWriteVoteData(this.mVE.getWriteVoteData());
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
            this.lUg.setTakePhotoNum(i);
        }
        this.lUg.setHasLocationData(this.eMo != null && this.eMo.bXz());
        if (this.writeImagesInfo != null) {
            this.eMp.wg(this.writeImagesInfo.size() > 0);
        }
        if (!y.isEmpty(this.mList) && this.mUx != null && this.mUx.mIsGlobalBlock == 0) {
            this.lUg.setForumId(String.valueOf(this.mUx.mForumId));
            this.lUg.setForumName(this.mUx.mForumName);
        }
        dGO();
        this.eMp.d(this.lUg);
        this.lUg.setContent(this.lUg.getContent().replaceAll("\u0000\n", ""));
        this.lUg.setContent(this.lUg.getContent().replaceAll("\u0000", ""));
        this.lUg.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.eMp.cKZ().setVoice(this.mVoiceModel.getId());
                this.eMp.cKZ().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.eMp.cKZ().setVoice(null);
                this.eMp.cKZ().setVoiceDuringTime(-1);
            }
        } else {
            this.eMp.cKZ().setVoice(null);
            this.eMp.cKZ().setVoiceDuringTime(-1);
        }
        if (!this.eMp.dxV()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.lUg.mDynamicImageTextData != null) {
            dGN();
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.hJE);
            this.eMp.dxS();
        }
    }

    private void dGO() {
        FrsTabItemData selectedTabItemData;
        if (this.lUg != null && this.mRT != null && (selectedTabItemData = this.mRT.getSelectedTabItemData()) != null) {
            this.lUg.setTabId(selectedTabItemData.tabId);
            this.lUg.setTabName(selectedTabItemData.name);
            this.lUg.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    public void dGN() {
        if (this.lUg.mDynamicImageTextData != null) {
            showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
            com.baidu.tieba.write.b.a.a(this.lUg, new a.InterfaceC0828a() { // from class: com.baidu.tieba.write.write.WriteActivity.46
                @Override // com.baidu.tieba.write.b.a.InterfaceC0828a
                public void a(BaseUploadData baseUploadData) {
                    com.baidu.tieba.write.b.c.b.dGz().a((ImageTextUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.write.WriteActivity.46.1
                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onSuccess(String str) {
                            WriteActivity.this.cqc();
                            x.e(WriteActivity.this.lUg.getForumId(), (WriteData) null);
                            WriteActivity.this.dIn();
                            com.baidu.tieba.write.b.a.dGq();
                            WriteActivity.this.closeLoadingDialog();
                            com.baidu.tieba.tbadkCore.writeModel.c.g(WriteActivity.this.getPageContext().getPageActivity(), null, null, null);
                            WriteActivity.this.jp(true);
                            Intent intent = new Intent();
                            intent.putExtras(new Bundle());
                            WriteActivity.this.setResult(-1, intent);
                            WriteActivity.this.finish();
                        }

                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onFail(String str) {
                            com.baidu.tieba.write.b.a.dGq();
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
            if (this.mUl != null) {
                i2 = this.mUl.getTotalCount();
                i = this.mUl.getAlreadyCount() + 1;
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
                if (this.lUy == getCurrentFocus()) {
                    dHT().clearFocus();
                    this.lUy.requestFocus();
                    if (this.eKD != null) {
                        this.eKD.bpX();
                    }
                    ShowSoftKeyPadDelay(this.lUy);
                } else {
                    dHT().requestFocus();
                    if (this.eKD != null) {
                        this.eKD.bpX();
                    }
                    ShowSoftKeyPadDelay(this.mUf);
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
                            dHT().getText().insert(dHT().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                cqc();
                dIn();
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
                                dIC();
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
                        xr(y.getCount(this.writeImagesInfo.getChosedFiles()) > 0);
                        if (this.mVA) {
                            xs(true);
                            this.mVA = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.mUw) {
                        F(intent);
                        dth();
                        return;
                    }
                    at(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.lUg.setVideoInfo(videoInfo);
                        this.eKD.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.eKD.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.eKD.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    dth();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.mUa) {
                                sb2.append(com.baidu.tbadk.plugins.b.eTO);
                                this.mUa = false;
                            }
                            sb2.append(stringExtra);
                            BT(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !y.isEmpty(this.mList)) {
                    if (!y.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                        this.mUx = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                        a(this.mUx);
                    }
                } else if (i == 25048) {
                    ar(intent);
                } else if (i == 25049 && intent != null) {
                    String str = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT) + " ";
                    int selectionStart = this.mUf.getSelectionStart();
                    int selectionEnd = this.mUf.getSelectionEnd();
                    if (selectionStart >= 0) {
                        Editable text = this.mUf.getText();
                        if (selectionEnd > selectionStart) {
                            text.replace(selectionStart, selectionEnd, str);
                        } else {
                            text.insert(selectionStart, str);
                        }
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.eKD != null && !this.eKD.brx()) {
                this.mUf.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.eKD.bpX();
            }
            switch (i) {
                case RequestResponseCode.REQUEST_CAMERA /* 12001 */:
                    bsg();
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    dIA();
                    if (this.mVA) {
                        xs(true);
                        this.mVA = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.lUy == getCurrentFocus()) {
                        dHT().clearFocus();
                        this.lUy.requestFocus();
                        if (this.eKD != null) {
                            this.eKD.bpX();
                        }
                        ShowSoftKeyPadDelay(this.lUy);
                        return;
                    }
                    dHT().requestFocus();
                    if (this.eKD != null) {
                        this.eKD.bpX();
                    }
                    ShowSoftKeyPadDelay(this.mUf);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.mUB.Sw(postWriteCallBackData.getErrorString());
                        this.mUB.bf(postWriteCallBackData.getSensitiveWords());
                        this.mUB.b(this.lUy, this.mUf);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.eMn = String.valueOf(System.currentTimeMillis());
                    ao.c(getPageContext(), this.eMn);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dIA();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.mTZ)) {
                        dHU().requestFocus();
                        return;
                    } else if ("from_content".equals(this.mTZ)) {
                        dHT().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHZ() {
        if ("1".equals(this.iwr)) {
            this.lUg.setCanNoForum(true);
            this.lUg.setTransmitForumData("[]");
        } else if ("2".equals(this.iwr)) {
            this.lUg.setCanNoForum(false);
        }
        dIa();
        this.lUg.setPrivacy(this.isPrivacy);
        dIy();
        this.lUg.setToDynamic(this.isToDynamic);
        this.lUg.setCallFrom(this.iwr);
        if (this.lUg.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cqf();
    }

    private void dIa() {
        if (this.eKD != null) {
            this.eKD.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void dIy() {
        if (this.eKD != null) {
            this.eKD.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void dIz() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void dIA() {
        if (this.mUw) {
            this.mVe.b(this.writeImagesInfo);
            dIB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIB() {
        this.mVe.notifyDataSetChanged();
        this.mVd.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.48
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.mVe.notifyDataSetChanged();
                WriteActivity.this.mVd.invalidateViews();
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
        dth();
    }

    private void as(Intent intent) {
        if (this.mUw) {
            at(intent);
            dIA();
        } else {
            aw(intent);
        }
        dth();
    }

    private void at(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            dIA();
            xt(true);
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

    private void dIC() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_CAMERA, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void av(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.mVb.parseJson(stringExtra);
            this.mVb.updateQuality();
            if (this.mVb.getChosedFiles() != null && this.mVb.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.mVb.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.mVb.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dHU());
        HidenSoftKeyPad(this.mInputManager, dHT());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
        if (this.mVD != null) {
            this.mVD.onPause();
        }
        if (this.eKD.brx()) {
            this.eKD.bpX();
        }
    }

    private void aw(Intent intent) {
        b(intent, true);
    }

    private void E(Intent intent) {
        this.eMn = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.eMn;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.getEquipmentWidth(getPageContext().getPageActivity())), com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.eMn, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            dID();
            dIb();
        }
        xt(true);
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
                dID();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    dIb();
                }
            }
            xt(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dID() {
        if (this.eKD.qe(10) != null) {
            this.eKD.setToolEnabled(this.writeImagesInfo == null || y.getCount(this.writeImagesInfo.getChosedFiles()) < this.writeImagesInfo.getMaxImagesAllowed(), 10);
        }
    }

    private void bsg() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.49
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                n.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.eMn));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void dIE() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.hQI)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                o oVar = new o(this, this.hQI, new o.a() { // from class: com.baidu.tieba.write.write.WriteActivity.50
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
                            WriteActivity.this.xt(true);
                        }
                    }
                });
                oVar.setFrom(1);
                oVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(boolean z) {
        String forumId = this.lUg == null ? "" : this.lUg.getForumId();
        if (this.mVc != null) {
            this.mVc.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.hSO == null) {
            this.hSO = VoiceManager.instance();
        }
        return this.hSO;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cmr() {
        this.hSO = getVoiceManager();
        this.hSO.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bz(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.hUk) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.lUg.getType() != 7) {
                if (this.mUl == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                F(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.eMu = i;
        if (this.eKD != null) {
            this.eKD.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void dIb() {
        if (!this.mUw) {
            if (this.eKD != null) {
                this.eKD.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.eKD.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.lUg == null ? "" : this.lUg.getForumId();
            if (this.mVc != null) {
                this.mVc.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jp(boolean z) {
        if (this.eKD != null) {
            this.eKD.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void JP(int i) {
        if (i < this.mUi.size()) {
            for (int i2 = 0; i2 < this.mUi.size(); i2++) {
                this.mUi.get(i2).xc(false);
            }
            this.mUi.get(i).xc(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void Hs(int i) {
        if (i == y.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new aq("c13014").ai("obj_type", 1));
        } else {
            TiebaStatic.log(new aq("c13014").ai("obj_type", 2));
        }
        this.lUh = i;
        this.lUE.setCurrentIndex(i);
        JP(i);
        this.lUD.setText(this.mPrefixData.getPrefixs().get(i));
        dth();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.lUE, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.lUG.setSelected(false);
        ap.setImageResource(this.lUF, R.drawable.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.mUf);
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
        if (this.lUg != null) {
            if (this.lUg.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.lUg.getType() == 5) {
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
            bsa();
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = ae.transformPermissionResult(strArr, iArr);
            if (ae.checkCamera(getApplicationContext())) {
                ao.c(getPageContext(), this.eMn);
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
        this.bdD = z;
        if (this.mVu && System.currentTimeMillis() - this.mVv < 800) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.mVu = false;
        }
        if (this.mUA != null && !z) {
            this.mUA.cfP();
        }
        if (this.mUC != null && !z) {
            dHE();
        }
        if (this.mVC != null && !z) {
            dIj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SW(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.mVr != null) {
            SX(str);
            this.mVr.dismiss();
        }
    }

    private void fP(Context context) {
        mVt = com.baidu.adp.lib.util.l.getEquipmentHeight(context);
    }

    private void SX(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.mVu = true;
        dID();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            dIb();
        }
        xt(true);
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

    private File dIF() {
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

    private void dIG() {
        if (this.mVp != null && this.lUg.getType() == 0 && this.lUg.getType() == 9) {
            fP(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.51
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.mVp != null) {
                        WriteActivity.this.SW(WriteActivity.this.mVp.getAbsolutePath());
                    }
                }
            });
            this.mVq = (TbImageView) this.mBubbleView.findViewById(R.id.rec_img_view);
            this.mVs = (LinearLayout) this.mBubbleView.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.bik().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.mVp.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.bik().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.mVp.getAbsolutePath());
                Bitmap g = g(this.mVp.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (g != null) {
                    this.mVq.setImageBitmap(g);
                    this.mVq.setDrawBorder(true);
                    this.mVq.setBorderWidth(2);
                    this.mVq.setBorderColor(ap.getColor(R.color.common_color_10264));
                    this.mVr = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.mVr.setCanceledOnTouchOutside(true);
                    this.mVr.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.52
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.mVu) {
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.mVv = System.currentTimeMillis();
                            }
                        }
                    });
                    this.mVr.setContentView(this.mBubbleView);
                    this.mVr.show();
                    Window window = this.mVr.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (mVt / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.bdD && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.mUa = false;
            this.mTZ = "";
            if ("from_content".equals(str)) {
                this.mTZ = "from_content";
            } else if ("from_title".equals(str)) {
                this.mTZ = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.Cx(String.valueOf(charSequence.charAt(i)))) {
                xp(false);
            }
        }
    }

    public void dnT() {
        if (this.mUP || !y.isEmpty(this.mList) || !StringUtils.isNull(this.lUg.getTitle())) {
            this.mUe.setVisibility(0);
            this.mUe.requestFocus();
            return;
        }
        this.mUe.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIH() {
        if (this.eKD != null) {
            this.eKD.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.53
                @Override // java.lang.Runnable
                public void run() {
                    if (!WriteActivity.this.mRx && WriteActivity.this.eKD != null && WriteActivity.this.eKD.eKG != null) {
                        String clipBoardContent = UtilHelper.getClipBoardContent();
                        if (at.isEmpty(clipBoardContent) || !be.bju().j(clipBoardContent)) {
                            WriteActivity.this.mUA.dgB();
                            return;
                        }
                        if (WriteActivity.this.mSF == null) {
                            WriteActivity.this.mSF = new FindNewLinkBubbleController(WriteActivity.this.getPageContext(), WriteActivity.this.mVT);
                        }
                        WriteActivity.this.mSF.a(WriteActivity.this.eKD.eKG.qc(31), clipBoardContent, FindNewLinkBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
                    }
                }
            });
        }
    }

    public String getCallFrom() {
        return this.iwr;
    }

    public WriteData cKZ() {
        return this.lUg;
    }

    public FrsTabInfoData dII() {
        return this.mNu;
    }

    public String getFrom() {
        return this.mFrom;
    }

    private boolean dIJ() {
        return (this.mVE == null || this.mVF == null || this.mVE.getWriteVoteData() == null || this.mVF.getVisibility() != 0) ? false : true;
    }

    public void dFG() {
        if (this.lUg != null) {
            TiebaStatic.log(new aq("c13897").ai("obj_locate", 2).dD("fid", this.lUg.getForumId()).dD("fname", this.lUg.getForumName()));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("commodity_goods_show_first_dialog", false)) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.nw(2);
            aVar.ig(false);
            FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(getPageContext().getPageActivity());
            frsPublishFineGoodsDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.54
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aVar != null) {
                        aVar.dismiss();
                        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("commodity_goods_show_first_dialog", true);
                        TiebaStatic.log(new aq("c13959").ai("obj_locate", 2).dD("fid", WriteActivity.this.lUg != null ? WriteActivity.this.lUg.getForumId() : "").dD("fname", WriteActivity.this.lUg != null ? WriteActivity.this.lUg.getForumName() : ""));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + WriteActivity.this.dIK()));
                    }
                }
            });
            aVar.aX(frsPublishFineGoodsDialogView);
            TiebaStatic.log(new aq("c13958").ai("obj_locate", 2).dD("fid", this.lUg != null ? this.lUg.getForumId() : "").dD("fname", this.lUg != null ? this.lUg.getForumName() : ""));
            aVar.b(getPageContext()).bhg();
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + dIK()));
    }

    public void Jw() {
        if (this.mVI != null && this.mVI.dHp() == null && this.mUf != null && this.mUf.getSpanGroupManager() != null) {
            this.mVI.h(this.mUf.getSpanGroupManager().blE());
            this.mVI.refreshData();
        } else if (this.mVI != null && this.mVI.dHp() != null) {
            this.mVI.refreshData();
        }
        if (this.mVI != null) {
            fD(this.mVI.dHo());
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
            if (!z && this.mVJ != null) {
                this.mVJ.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SY(String str) {
        this.mVM = new ArrayList();
        ArrayList arrayList = new ArrayList();
        if (!StringUtils.isNull(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    arrayList.add(string);
                    this.mVM.add(com.baidu.tieba.i.a.dJ(jSONObject));
                }
                if (this.mVM.size() > 0) {
                    this.mVQ = true;
                    this.mUf.i(this.mVM, arrayList);
                    dIp();
                    Jw();
                    this.mVJ.setVisibility(0);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dIK() {
        if (this.mUf == null || this.mUf.getSpanGroupManager() == null) {
            return 10;
        }
        return 10 - this.mUf.getSpanGroupManager().blF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dIL() {
        return this.canGoods || this.mUf == null || this.mUf.getSpanGroupManager() == null || this.mUf.getSpanGroupManager().blF() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dIM() {
        boolean z = this.mVI == null || this.mVI.dHq();
        boolean z2 = (this.mRT == null || this.mRT.getSelectedTabItemData() == null || this.mRT.getSelectedTabItemData().tabType != 3) ? false : true;
        if (z && z2) {
            return 1;
        }
        return (z || z2) ? 0 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dIN() {
        if (this.mNu == null || y.isEmpty(this.mNu.tabList)) {
            return false;
        }
        for (FrsTabItemData frsTabItemData : this.mNu.tabList) {
            if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                return true;
            }
        }
        return false;
    }
}
