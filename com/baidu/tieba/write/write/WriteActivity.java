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
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
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
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
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
import com.baidu.tbadk.core.atomData.SelectForumConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.WriteTipBubbleController;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.message.EvaluateRelevanceItemSelectedMessage;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.HeadIconRefreshHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.SaveDraftDialogView;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.HeadItem;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mutiprocess.event.GoodsEvent;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.switchs.RepostToDynamicDefaultSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsPublishFineGoodsDialogView;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.EBusinessProtocolView;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.view.ForumSelectedView;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import com.baidu.tieba.write.view.TitleTipView;
import com.baidu.tieba.write.view.WriteEvaluationHeaderView;
import com.google.gson.Gson;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.kwai.video.player.PlayerPostEvent;
import d.b.h0.r.f0.p.a;
import d.b.h0.r.s.a;
import d.b.h0.z0.q;
import d.b.i0.c3.g0.a;
import d.b.i0.c3.y;
import d.b.i0.u3.i;
import d.b.i0.u3.v.d;
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
/* loaded from: classes5.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements VoiceManager.j, y.d, i.a, PopupWindow.OnDismissListener, ActivityCompat.OnRequestPermissionsResultCallback {
    public static final String BOTTLE_FORUM_ID = "24591571";
    public static final int CONTENT_MAX_COUNT = 233;
    public static final String FROM_CONTENT = "from_content";
    public static final String FROM_TITLE = "from_title";
    public static final String FROM_WRITEACTIVITY_LIVEPHOTO = "from_writeActivity_livePhoto";
    public static final int MAX_COMMODITY_NUM = 10;
    public static final int MAX_NEW_CONTENT_COUNT = 5000;
    public static final int MAX_NEW_REPLY_COUNT = 1000;
    public static final int NORMAL_TITLE_MAX_COUNT = 31;
    public static final String PATH_PROTOCOL = "file:///android_asset/protocol.html";
    public static final float PHOTO_LIVE_COVER_CUT_SIZE = 0.56f;
    public static final String PHOTO_LIVE_DRAFT_KEY = "photolive";
    public static final int REQUEST_LOCATION = 0;
    public static int SCREEN_HEIGHT = 0;
    public static final int TAB_CONSISTENT = 0;
    public static final int TAB_NO_CHOOSE_COMMODITY = 1;
    public static final int TAB_NO_CHOOSE_HAOWU_TAB = 2;
    public static final int TITLE_MAX_COUNT = 20;
    public static final String UPDATE_PHOTO_LIVE_DRAFT_KEY = "updatephotolive";
    public static final String WRITE_TITLE_PREFIX_TIP_KEY = "write_title_prefix_tip_key";
    public d.b.i0.t3.b dialog;
    public View feedback_divider;
    public WriteImageGridView imageGridView;
    public boolean isEvaluate;
    public boolean isFromItemDetail;
    public boolean isPrivacy;
    public boolean isToDynamic;
    public d.b.i0.u3.v.d mAdapter;
    public RelativeLayout mAdditionContainer;
    public TextView mAdditionCreateTime;
    public AdditionData mAdditionData;
    public TextView mAdditionLastContent;
    public TextView mAdditionLastTime;
    public d.b.i0.p0.c0 mCategoryDefault;
    public List<d.b.i0.p0.c0> mCategoryList;
    public String mCategoryName;
    public PostCategoryView mCategoryView;
    public d.b.i0.u3.v.b mCommodityTipController;
    public HotTopicBussinessData mCurrHotData;
    public int mCurrPrefixPos;
    public EBusinessProtocolView mEBusinessProtocolView;
    public EditorTools mEditor;
    public WriteTipBubbleController mFindNewLinkBubbleController;
    public ForumSelectedView mForumSelectedView;
    public ForumTabSelectedView mForumTabSelectedView;
    public View mForumTabSelectedViewDivider;
    public FrsTabInfoData mFrsTabList;
    public GestureDetector mGestureDetector;
    public List<d.b.i0.v0.a> mGoodsDatas;
    public TextView mHotTopicEdt;
    public SerializableItemInfo mIntentItemInfo;
    public int mIntentStarCount;
    public boolean mItemIsSchool;
    public ImageView mIvDeleteVoice;
    public LinearLayout mLayoutVoicePlay;
    public d.b.h0.w.t.a mLinkTool;
    public List<HotTopicBussinessData> mList;
    public ListView mListView;
    public LocationModel mLocationModel;
    public String mMoreForumImg;
    public String mMoreForumTitle;
    public String mMoreForumUrl;
    public d.b.i0.b0.e mPiefixTipController;
    public TextView mPostContentCounter;
    public TitleTipView mPostTitleTip;
    public PostTopicData mPostTopicData;
    public TextView mPrefix;
    public PostPrefixData mPrefixData;
    public ImageView mPrefixIcon;
    public d.b.i0.u3.i mPrefixWindow;
    public LinearLayout mProtocol;
    public TextView mProtocolInfo;
    public ImageView mProtocolTag;
    public d.b.h0.t.i mSelectForumData;
    public d.b.i0.u3.v.g mTipController;
    public LinearLayout mTitleView;
    public View mTitleViewDivider;
    public Toast mTooManyEmotionToast;
    public LinearLayout mToolView;
    public VoiceManager mVoiceManager;
    public VoiceData$VoiceModel mVoiceModel;
    public PlayVoiceBntNew mVoicePlayButton;
    public RelativeLayout mVoteLayoutRoot;
    public d.b.i0.u3.v.p.a mVoteViewController;
    public WriteEvaluationHeaderView mWriteEvaluationeHeaderView;
    public d.b.i0.u3.v.i mWriteImageController;
    public d.b.i0.c3.q0.a mWriteModel;
    public d.b.i0.u3.n.b mWriteTool;
    public String photoName;
    public View post_prefix_layout;
    public View prefix_divider;
    public int privateThread;
    public d.b.h0.r.s.j saveDraftDialog;
    public SaveDraftDialogView saveDraftDialogView;
    public Serializable voteDataSerializable;
    public String writeImagesInfoString;
    public d.b.i0.u3.v.o.a writeVideoController;
    public String fromWhereToHotSelect = "";
    public boolean needAddHotTopicSign = false;
    public WriteData mData = null;
    public boolean isFeedBack = false;
    public boolean showHomepageTestIcon = false;
    public boolean isFeedBackBar = false;
    public boolean isVcodeFeedBack = false;
    public InputMethodManager mInputManager = null;
    public EditText mPostTitle = null;
    public HeadImageView mUserHeaderPortrait = null;
    public View mInterval = null;
    public LinearLayout mPostContentContainer = null;
    public SpanGroupEditText mPostContent = null;
    public FeedBackModel mFeedBackModel = null;
    public FeedBackTopListView mTopListView = null;
    public ArrayList<WritePrefixItemLayout> mPrefixItems = new ArrayList<>();
    public String mBubbleUrl = null;
    public final KeyEvent keyEventDown = new KeyEvent(0, 67);
    public NavigationBar mNavigationBar = null;
    public View mBack = null;
    public TextView btn_image_problem = null;
    public TextView mPost = null;
    public TextView mName = null;
    public ImageView mGuide = null;
    public final Handler mHandler = new Handler();
    public boolean mIsReplySubPb = false;
    public String mSubUserName = null;
    public RelativeLayout mParent = null;
    public boolean isVoiceEnable = true;
    public String mDisableAudioMessage = null;
    public WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    public int mLocationState = 0;
    public int mCategoryFromID = -1;
    public int mCategoryToID = -1;
    public WriteImagesInfo liveCoverImageInfo = new WriteImagesInfo();
    public View mRootView = null;
    public GridView mPhotoLiveGridView = null;
    public d.b.i0.u3.u.b.a mPhotoLiveGridViewAdapter = null;
    public ScrollView write_scrollview = null;
    public EditText live_post_content = null;
    public View live_container = null;
    public View live_interval_view = null;
    public View live_post_title_container = null;
    public EditText live_post_title = null;
    public TextView mTitleOverPlusNumber = null;
    public TextView mContentOverPlusNumber = null;
    public TextWatcher mOldTitleTextWatcher = null;
    public TextWatcher mOldContentTextWatcher = null;
    public boolean isLivePhotoType = false;
    public boolean isPhotoliveTitleHasFocus = false;
    public d.b.h0.r.f0.a mLoadingDialog = null;
    public String mFrom = AlbumActivityConfig.FROM_WRITE;
    public File latestPic = null;
    public TbImageView mRecImgView = null;
    public View mBubbleView = null;
    public Dialog mRecDialog = null;
    public LinearLayout mBubbleLayout = null;
    public boolean isAttach = false;
    public long recTimeStamp = -1000;
    public boolean hasSetTitleUseHotTopic = false;
    public String mCallFrom = "2";
    public int isAblumThread = 0;
    public boolean canGoods = false;
    public String mTopicId = "";
    public SpannableStringBuilder mContentBuilder = new SpannableStringBuilder();
    public boolean mIsWillShowBubble = false;
    public boolean isKeyboardVisibility = false;
    public final d.b.i0.u3.v.c mHighLightController = new d.b.i0.u3.v.c();
    public boolean isSaveDraft = true;
    public boolean fromErrorDialog = false;
    public String goodsListStr = null;
    public final d.b mOnItemDeleteListener = new k();
    public boolean isAgreedProtocol = false;
    public boolean isProductTie = false;
    public final HttpMessageListener mUpdateBubbleListener = new v(CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    public CustomMessageListener openMoreToolListener = new g0(2921494);
    public final CustomMessageListener mSelectForumListener = new r0(2921505);
    public TbFaceManager.a mBigEmotionSpanHanlder = new c1();
    public final AntiHelper.k mAntiInjectListener = new g1();
    public WriteTipBubbleController.b mOnNewLinkBubbleClickListener = new h1();
    public final NewWriteModel.g mOnPostWriteCallback = new i1();
    public final LocationModel.e mOnLocationCallBack = new j1();
    public final CustomMessageListener mOnSelectLocationListener = new a(2001226);
    public CustomMessageListener mUegValidateListener = new b(2016554);
    public CustomMessageListener mBackgroundListener = new c(2001011);
    public CustomMessageListener mEvaluateRelevanceItemSelectedListener = new d(2921516);
    public final View.OnClickListener mEditOnClicked = new e();
    public boolean isDisalbeButtons = true;
    public final View.OnFocusChangeListener mFocusChangeListener = new h();
    public d.b.h0.f0.h mSwanappReturnProductDateListener = new i();
    public boolean isProcessedSaveDraft = false;
    public TextWatcher mWriteTitleTextWatcher = new s();
    public TextWatcher mWriteContentTextWatcher = new t();
    public int originalMargin = 0;
    public final a.f mBubbleTipRefreshCallback = new t0();
    public final Runnable handleLastError = new v0();

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.mLocationModel.H(false);
                    WriteActivity.this.mLocationModel.G(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.sendLocaionAction(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.mLocationModel.H(true);
                WriteActivity.this.sendLocaionAction(0, true, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements WriteEvaluationHeaderView.b {
        public a0() {
        }

        @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.b
        public void a(float f2) {
            if (TextUtils.isEmpty(WriteActivity.this.mPostContent.getText()) || WriteActivity.this.mPostContent.getText().length() < 20 || WriteActivity.this.mPostContent.getText().length() > 500 || f2 <= 0.0f) {
                WriteActivity.this.mPost.setEnabled(false);
            } else {
                WriteActivity.this.mPost.setEnabled(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a1 implements View.OnClickListener {
        public a1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WriteActivity.this.latestPic != null) {
                WriteActivity writeActivity = WriteActivity.this;
                writeActivity.chooseRecommendPic(writeActivity.latestPic.getAbsolutePath());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            WriteActivity.this.showToast((String) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements WriteEvaluationHeaderView.c {
        public b0() {
        }

        @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.c
        public void onClose() {
            WriteActivity.this.mPost.setEnabled(false);
        }
    }

    /* loaded from: classes5.dex */
    public class b1 implements DialogInterface.OnDismissListener {
        public b1() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (WriteActivity.this.isAttach) {
                d.b.b.e.p.l.w(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                WriteActivity.this.recTimeStamp = System.currentTimeMillis();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof BackgroundSwitchMessage) || ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                return;
            }
            WriteActivity.this.checkClipboardAndShowNewLinkBubble();
        }
    }

    /* loaded from: classes5.dex */
    public class c0 extends ClickableSpan {
        public c0() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            d.b.b.e.m.g.i(WriteActivity.this.mEBusinessProtocolView, WriteActivity.this);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    /* loaded from: classes5.dex */
    public class c1 implements TbFaceManager.a {
        public c1() {
        }

        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan a(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), d.b.b.j.d.a.class);
            d.b.b.j.d.a aVar = runTask != null ? (d.b.b.j.d.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.p());
            int r = aVar.r();
            if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                bitmapDrawable.setBounds(0, 0, r, aVar.m());
            } else {
                bitmapDrawable.setBounds(0, 0, r, r);
            }
            bitmapDrawable.setGravity(119);
            return new d.b.h0.r.f0.e(bitmapDrawable, 0);
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof EvaluateRelevanceItemSelectedMessage)) {
                return;
            }
            WriteActivity.this.setupRelevanceItemSelected((EvaluateRelevanceItemSelectedMessage) customResponsedMessage);
        }
    }

    /* loaded from: classes5.dex */
    public class d0 implements View.OnClickListener {

        /* loaded from: classes5.dex */
        public class a implements a.e {
            public a(d0 d0Var) {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
                i.s(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", true);
                aVar.dismiss();
            }
        }

        /* loaded from: classes5.dex */
        public class b implements a.e {
            public b(d0 d0Var) {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
                i.s(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false);
                aVar.dismiss();
            }
        }

        public d0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WriteActivity.this.isAgreedProtocol) {
                WriteActivity.this.isAgreedProtocol = false;
                WriteActivity.this.mProtocolTag.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_use_uncheck16, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
            } else {
                WriteActivity.this.isAgreedProtocol = true;
                WriteActivity.this.mProtocolTag.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_mask_use_check16, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            }
            d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
            if (i.g(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false) || !WriteActivity.this.isAgreedProtocol) {
                return;
            }
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(WriteActivity.this);
            aVar.setNegativeTextColor(R.color.CAM_X0105);
            aVar.setTitle("");
            aVar.setMessage(WriteActivity.this.getResources().getString(R.string.protocol_tip));
            aVar.setContentViewSize(1);
            aVar.setPositiveButton("同意", new a(this));
            aVar.setNegativeButton("取消", new b(this));
            aVar.create(WriteActivity.this.getPageContext()).show();
        }
    }

    /* loaded from: classes5.dex */
    public class d1 implements Runnable {
        public d1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WriteActivity.this.mEditor == null || WriteActivity.this.mEditor.f13843e == null) {
                return;
            }
            String clipBoardContent = UtilHelper.getClipBoardContent();
            if (d.b.b.e.p.k.isEmpty(clipBoardContent) || !UrlManager.getInstance().isUrlValid(clipBoardContent)) {
                WriteActivity.this.mWriteTool.o();
                return;
            }
            if (WriteActivity.this.mFindNewLinkBubbleController == null) {
                WriteActivity writeActivity = WriteActivity.this;
                writeActivity.mFindNewLinkBubbleController = new WriteTipBubbleController(writeActivity.getPageContext(), WriteActivity.this.mOnNewLinkBubbleClickListener);
            }
            View s = WriteActivity.this.mEditor.f13843e.s(31);
            WriteTipBubbleController writeTipBubbleController = WriteActivity.this.mFindNewLinkBubbleController;
            writeTipBubbleController.d(s, WriteActivity.this.getPageContext().getString(R.string.find_new_link) + "\n" + clipBoardContent, clipBoardContent, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.mEditor.A(new d.b.h0.w.a(5, -1, null));
            int emotionCheck = WriteActivity.this.emotionCheck();
            if (emotionCheck < 0 || emotionCheck >= WriteActivity.this.mPostContent.getText().length()) {
                return;
            }
            WriteActivity.this.mPostContent.setSelection(emotionCheck);
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements EBusinessProtocolView.f {
        public e0() {
        }

        @Override // com.baidu.tieba.view.EBusinessProtocolView.f
        public void a(boolean z) {
            if (z) {
                if (WriteActivity.this.isAgreedProtocol) {
                    return;
                }
                WriteActivity.this.isAgreedProtocol = true;
                WriteActivity.this.mProtocolTag.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_mask_use_check16, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            } else if (WriteActivity.this.isAgreedProtocol) {
                WriteActivity.this.isAgreedProtocol = false;
                WriteActivity.this.mProtocolTag.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_use_uncheck16, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e1 implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f22490e;

        public e1(d.b.h0.r.s.a aVar) {
            this.f22490e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.h0.r.s.a aVar = this.f22490e;
            if (aVar != null) {
                aVar.dismiss();
                d.b.h0.r.d0.b.i().s("commodity_goods_show_first_dialog", true);
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_CLICK).param("obj_locate", 2);
                WriteData writeData = WriteActivity.this.mData;
                StatisticItem param2 = param.param("fid", writeData != null ? writeData.getForumId() : "");
                WriteData writeData2 = WriteActivity.this.mData;
                TiebaStatic.log(param2.param("fname", writeData2 != null ? writeData2.getForumName() : ""));
                String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=" + WriteActivity.this.getStillCommodityNum()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements a.e {
        public f() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            WriteActivity.this.sendLocaionAction(0, true, null);
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements View.OnClickListener {
        public f0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.showTipWindow();
        }
    }

    /* loaded from: classes5.dex */
    public class f1 implements CustomMessageTask.CustomRunnable<Boolean> {
        public f1() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            if (customMessage == null || customMessage.getData() == null || !customMessage.getData().booleanValue()) {
                return null;
            }
            BdTopToast bdTopToast = new BdTopToast(WriteActivity.this);
            bdTopToast.i(false);
            bdTopToast.h(WriteActivity.this.getResources().getString(R.string.user_collection_emotion_unclickable_hint));
            bdTopToast.j((ViewGroup) WriteActivity.this.mRootView);
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements a.e {
        public g() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            if (d.b.b.e.p.j.z()) {
                WriteActivity.this.sendLocaionAction(1, true, null);
                WriteActivity.this.mLocationModel.F();
            } else {
                WriteActivity.this.mOnLocationCallBack.a();
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class g0 extends CustomMessageListener {
        public g0(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            WriteActivity writeActivity = WriteActivity.this;
            if (writeActivity.mData == null || !writeActivity.canGoods) {
                return;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_SHOW).param("obj_locate", 1).param("fid", WriteActivity.this.mData.getForumId()).param("fname", WriteActivity.this.mData.getForumName()));
        }
    }

    /* loaded from: classes5.dex */
    public class g1 implements AntiHelper.k {
        public g1() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnFocusChangeListener {
        public h() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.mPostTitle || view == WriteActivity.this.mBack || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.isDisalbeButtons = true;
                    WriteActivity.this.changeToolButtonStatus();
                    d.b.b.e.p.l.J(WriteActivity.this.getActivity(), WriteActivity.this.mPostTitle);
                    if (WriteActivity.this.mEditor != null) {
                        WriteActivity.this.mEditor.q();
                    }
                } else if (view == WriteActivity.this.mPostTitle) {
                    WriteActivity.this.mPrefix.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.mPostContent && z) {
                WriteActivity.this.isDisalbeButtons = false;
                WriteActivity.this.changeToolButtonStatus();
                d.b.b.e.p.l.J(WriteActivity.this.getActivity(), WriteActivity.this.mPostContent);
                if (WriteActivity.this.mEditor != null) {
                    WriteActivity.this.mEditor.q();
                }
            }
            WriteActivity.this.updateHintTextColor();
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements TabMenuPopView.c {
        public h0() {
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view, d.b.i0.p0.e1 e1Var) {
            if (e1Var == null) {
                return;
            }
            WriteActivity.this.mCategoryView.setText(e1Var.f57401a);
            WriteActivity.this.mData.setCategoryTo(e1Var.f57402b);
            WriteActivity.this.mCategoryToID = e1Var.f57402b;
            WriteActivity.this.mCategoryView.c();
        }
    }

    /* loaded from: classes5.dex */
    public class h1 implements WriteTipBubbleController.b {
        public h1() {
        }

        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.b
        public void a(View view, String str) {
            if (WriteActivity.this.mFindNewLinkBubbleController == null) {
                return;
            }
            TiebaStatic.log("c13802");
            WriteActivity.this.mFindNewLinkBubbleController.c();
            UtilHelper.clearClipBoard();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddLinkActivityConfig(WriteActivity.this.getActivity(), 25049, str, false, null)));
        }
    }

    /* loaded from: classes5.dex */
    public class i extends d.b.h0.f0.h<GoodsEvent> {
        public i() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.f0.b
        /* renamed from: a */
        public boolean onEvent(GoodsEvent goodsEvent) {
            if (goodsEvent == null) {
                return false;
            }
            WriteActivity.this.parseProductData(goodsEvent.getGoodsList());
            goodsEvent.setDispost(true);
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class i0 implements View.OnClickListener {
        public i0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.mCategoryView.e();
            WriteActivity writeActivity = WriteActivity.this;
            writeActivity.HidenSoftKeyPad(writeActivity.mInputManager, WriteActivity.this.getRealTitleInstance());
            WriteActivity writeActivity2 = WriteActivity.this;
            writeActivity2.HidenSoftKeyPad(writeActivity2.mInputManager, WriteActivity.this.getRealContentEdittextInstance());
        }
    }

    /* loaded from: classes5.dex */
    public class i1 implements NewWriteModel.g {

        /* loaded from: classes5.dex */
        public class a implements a.e {
            public a(i1 i1Var) {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        /* loaded from: classes5.dex */
        public class b implements a.e {
            public b() {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                aVar.dismiss();
                WriteActivity.this.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(WriteActivity.this.getActivity(), 0, 26, 1)));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 1));
            }
        }

        public i1() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d.b.h0.s.c.f0 f0Var, WriteData writeData, AntiData antiData) {
            WriteActivity.this.stopVoice();
            WriteActivity.this.closeLoadingDialog();
            WriteActivity.this.isProcessedSaveDraft = true;
            if (postWriteCallBackData != null) {
                WriteActivity writeActivity = WriteActivity.this;
                if (writeActivity.mData == null) {
                    return;
                }
                writeActivity.mHighLightController.n(null);
                if (z) {
                    WriteActivity.this.sendFinishSendAction(z);
                    if (WriteActivity.this.canShowSuccessTip(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.showTipDialog(true, postWriteCallBackData);
                    }
                    d.b.i0.u3.s.b.e(WriteActivity.this.mData);
                    WriteActivity.this.clearDraft();
                    WriteActivity.this.deleteTempVideoFile();
                    if ((WriteActivity.this.mData.getType() == 0 || WriteActivity.this.mData.getType() == 9 || WriteActivity.this.mData.getType() == 11) && !ListUtils.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                        TiebaStatic.log(new StatisticItem("c11731").param("obj_id", WriteActivity.this.mTopicId));
                    }
                    WriteActivity.this.sendUpdatePhotoLiveMessage(postWriteCallBackData);
                    if (!d.b.b.e.p.k.isEmpty(postWriteCallBackData.getVideoid()) && WriteActivity.this.mData.getVideoInfo() != null) {
                        postWriteCallBackData.mVideoMd5 = WriteActivity.this.mData.getVideoInfo().getVideoMd5();
                        if (!d.b.b.e.p.k.isEmpty(WriteActivity.this.mData.getForumName())) {
                            postWriteCallBackData.mFrom = 2;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001374, postWriteCallBackData));
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
                    WriteActivity.this.mHighLightController.n(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.mHighLightController.o(postWriteCallBackData.getErrorString());
                    WriteActivity.this.mHighLightController.i(WriteActivity.this.mPostTitle, WriteActivity.this.mPostContent);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (d.b.b.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(WriteActivity.this.getActivity(), WriteActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(WriteActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(WriteActivity.this.getActivity());
                    if (d.b.b.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(WriteActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(R.string.cancel, new a(this));
                    aVar.setPositiveButton(R.string.open_now, new b());
                    aVar.create(WriteActivity.this.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 1));
                } else if ((f0Var == null || writeData == null || f0Var.c() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001 && !d.b.i0.m3.a.c(postWriteCallBackData.getErrorCode())) {
                    WriteActivity.this.showTipDialog(false, postWriteCallBackData);
                } else if (f0Var != null && writeData != null && f0Var.c() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(f0Var.b());
                    writeData.setVcodeUrl(f0Var.c());
                    writeData.setVcodeExtra(f0Var.a());
                    if (d.b.h0.a1.a.b(f0Var.d())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, f0Var.d());
                        if (WriteActivity.this.isVcodeFeedBack) {
                            newVcodeActivityConfig.setHideFeedBackButton();
                        }
                        WriteActivity.this.sendMessage(new CustomMessage(2002001, newVcodeActivityConfig));
                        return;
                    }
                    WriteActivity.this.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), writeData, 12006)));
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                } else {
                    WriteActivity.this.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(WriteActivity.this.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity writeActivity = WriteActivity.this;
            writeActivity.showToast(writeActivity.mDisableAudioMessage);
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements TimePickerDialog.OnTimeSetListener {
        public j0() {
        }

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker timePicker, int i, int i2) {
        }
    }

    /* loaded from: classes5.dex */
    public class j1 implements LocationModel.e {
        public j1() {
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void a() {
            WriteActivity.this.showToast(R.string.no_network_guide);
            WriteActivity.this.sendLocaionAction(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b(LocationData locationData) {
            if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                WriteActivity.this.sendLocaionAction(2, true, locationData.getFormatted_address());
            } else {
                onFail(null);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void onFail(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(R.string.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.sendLocaionAction(0, true, null);
        }
    }

    /* loaded from: classes5.dex */
    public class k implements d.b {
        public k() {
        }

        @Override // d.b.i0.u3.v.d.b
        public void a(List<d.b.h0.r.q.v> list) {
            WriteActivity.this.setProtocolVisibility(list);
        }

        @Override // d.b.i0.u3.v.d.b
        public void b(int i) {
            if (WriteActivity.this.mPostContent == null) {
                return;
            }
            WriteActivity.this.mPostContent.c(i);
        }
    }

    /* loaded from: classes5.dex */
    public class k0 implements View.OnClickListener {
        public k0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c13013").param("fid", WriteActivity.this.mData.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            WriteActivity.this.mPrefix.setVisibility(0);
            WriteActivity.this.post_prefix_layout.setSelected(true);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(WriteActivity.this.mPrefixIcon, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, null);
            d.b.b.e.m.g.l(WriteActivity.this.mPrefixWindow, view, 0, d.b.b.e.p.l.e(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
            WriteActivity.this.mEditor.q();
            WriteActivity writeActivity = WriteActivity.this;
            writeActivity.HidenSoftKeyPad(writeActivity.mInputManager, WriteActivity.this.mPostTitle);
            WriteActivity writeActivity2 = WriteActivity.this;
            writeActivity2.HidenSoftKeyPad(writeActivity2.mInputManager, WriteActivity.this.mPostContent);
        }
    }

    /* loaded from: classes5.dex */
    public class k1 extends GestureDetector.SimpleOnGestureListener {
        public k1() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            d.b.b.e.p.l.w(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f2, f3);
        }

        public /* synthetic */ k1(WriteActivity writeActivity, k kVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public class l implements View.OnFocusChangeListener {
        public l() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                WriteActivity.this.isPhotoliveTitleHasFocus = true;
                WriteActivity.this.isDisalbeButtons = true;
                WriteActivity.this.changeToolButtonStatus();
                if (WriteActivity.this.mEditor != null) {
                    WriteActivity.this.mEditor.q();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l0 implements View.OnClickListener {
        public l0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c13013").param("fid", WriteActivity.this.mData.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            WriteActivity.this.mPrefix.setSelected(true);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(WriteActivity.this.mPrefixIcon, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, null);
            d.b.b.e.m.g.l(WriteActivity.this.mPrefixWindow, view, 0, d.b.b.e.p.l.e(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
            WriteActivity.this.mEditor.q();
            WriteActivity writeActivity = WriteActivity.this;
            writeActivity.HidenSoftKeyPad(writeActivity.mInputManager, WriteActivity.this.getRealTitleInstance());
            WriteActivity writeActivity2 = WriteActivity.this;
            writeActivity2.HidenSoftKeyPad(writeActivity2.mInputManager, WriteActivity.this.getRealContentEdittextInstance());
        }
    }

    /* loaded from: classes5.dex */
    public class m implements View.OnFocusChangeListener {
        public m() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                WriteActivity.this.isPhotoliveTitleHasFocus = false;
                WriteActivity.this.isDisalbeButtons = false;
                WriteActivity.this.changeToolButtonStatus();
                if (WriteActivity.this.mEditor != null) {
                    WriteActivity.this.mEditor.q();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m0 extends d.b.b.a.e {
        public m0() {
        }

        @Override // d.b.b.a.e
        public void c(Object obj) {
            WriteActivity.this.hideProgressBar();
            if (obj == null || !(obj instanceof FeedBackModel)) {
                WriteActivity.this.mTopListView.setVisibility(8);
                WriteActivity.this.feedback_divider.setVisibility(8);
                WriteActivity.this.showToast(R.string.neterror);
                return;
            }
            FeedBackModel feedBackModel = (FeedBackModel) obj;
            if (feedBackModel.w() != 0) {
                WriteActivity.this.mTopListView.setVisibility(8);
                WriteActivity.this.feedback_divider.setVisibility(8);
                return;
            }
            WriteActivity.this.mTopListView.c(feedBackModel.x(), WriteActivity.this.getPageContext());
        }
    }

    /* loaded from: classes5.dex */
    public class n implements PhotoLiveLinearLayout.a {
        public n() {
        }

        @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
        public void a() {
            WriteActivity.this.updateGridView();
        }
    }

    /* loaded from: classes5.dex */
    public class n0 implements View.OnClickListener {
        public n0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WriteActivity.this.mForumSelectedView == null || WriteActivity.this.mSelectForumData != null) {
                if (WriteActivity.this.checkCanGoodsConsistent()) {
                    if (!WriteActivity.this.isProductTie || WriteActivity.this.isAgreedProtocol) {
                        if (WriteActivity.this.checkContainHaowuTab()) {
                            int checkTabConsistent = WriteActivity.this.checkTabConsistent();
                            if (checkTabConsistent == 1) {
                                WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_commodity));
                                return;
                            } else if (checkTabConsistent == 2) {
                                WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_haowu_tab));
                                return;
                            }
                        }
                        if (!d.b.b.e.p.j.z()) {
                            WriteActivity.this.showToast(R.string.neterror);
                        }
                        if (d.b.i0.u3.s.a.b()) {
                            return;
                        }
                        if (WriteActivity.this.mHighLightController.c(WriteActivity.this.mPostTitle, WriteActivity.this.mPostContent)) {
                            WriteActivity writeActivity = WriteActivity.this;
                            writeActivity.showToast(writeActivity.mHighLightController.f());
                            return;
                        }
                        WriteActivity writeActivity2 = WriteActivity.this;
                        writeActivity2.HidenSoftKeyPad(writeActivity2.mInputManager, WriteActivity.this.getRealTitleInstance());
                        WriteActivity writeActivity3 = WriteActivity.this;
                        writeActivity3.HidenSoftKeyPad(writeActivity3.mInputManager, WriteActivity.this.getRealContentEdittextInstance());
                        WriteActivity.this.mEditor.q();
                        if (WriteActivity.this.mData.getType() != 7) {
                            if (WriteActivity.this.isFeedBack) {
                                WriteActivity.this.postNewMessage();
                                BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                            } else {
                                StatisticItem statisticItem = new StatisticItem("c12102");
                                statisticItem.param("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                                TiebaStatic.log(statisticItem);
                                WriteActivity.this.postPhotoTextThread();
                            }
                        } else {
                            TiebaStatic.log("c12015");
                            WriteActivity.this.postNewMessage();
                        }
                        MercatorModel.d().f();
                        TiebaStatic.log(new StatisticItem("c12262").param("obj_locate", WriteActivity.this.mCallFrom));
                        return;
                    }
                    WriteActivity writeActivity4 = WriteActivity.this;
                    writeActivity4.showToast(writeActivity4.getResources().getString(R.string.publish_faile_toast));
                    return;
                }
                WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_cant_but_commodity));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectForumConfig(WriteActivity.this)));
        }
    }

    /* loaded from: classes5.dex */
    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WriteActivity.this.mEditor == null || WriteActivity.this.mEditor.f13843e == null) {
                return;
            }
            if (WriteActivity.this.mCommodityTipController == null) {
                WriteActivity writeActivity = WriteActivity.this;
                writeActivity.mCommodityTipController = new d.b.i0.u3.v.b(writeActivity.getPageContext());
            }
            WriteActivity.this.mCommodityTipController.b(WriteActivity.this.mEditor.f13843e.s(2));
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public int f22518e;

        /* renamed from: f  reason: collision with root package name */
        public EditText f22519f = null;

        /* renamed from: g  reason: collision with root package name */
        public TextView f22520g = null;

        public o0() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.refreshPostButton();
            if (WriteActivity.this.isLivePhotoType) {
                int selectionStart = this.f22519f.getSelectionStart();
                this.f22518e = selectionStart;
                this.f22519f.setSelection(selectionStart);
                WriteActivity.this.setLeftCount(this.f22520g, this.f22519f);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!WriteActivity.this.isLivePhotoType || !WriteActivity.this.isPhotoliveTitleHasFocus) {
                if (WriteActivity.this.isLivePhotoType) {
                    if (this.f22519f == WriteActivity.this.live_post_content && this.f22520g == WriteActivity.this.mContentOverPlusNumber) {
                        return;
                    }
                    this.f22519f = WriteActivity.this.live_post_content;
                    this.f22520g = WriteActivity.this.mContentOverPlusNumber;
                }
            } else if (this.f22519f == WriteActivity.this.live_post_title && this.f22520g == WriteActivity.this.mTitleOverPlusNumber) {
            } else {
                this.f22519f = WriteActivity.this.live_post_title;
                this.f22520g = WriteActivity.this.mTitleOverPlusNumber;
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes5.dex */
    public class p implements d.b.h0.w.b {
        public p() {
        }

        @Override // d.b.h0.w.b
        public void onAction(d.b.h0.w.a aVar) {
            VideoInfo videoInfo;
            if (aVar == null) {
                return;
            }
            int i = aVar.f51523a;
            if (i == 16) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 9));
                if (WriteActivity.this.isTextFull()) {
                    WriteActivity.this.showToast(R.string.over_limit_tip);
                } else {
                    WriteActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12004, true)));
                }
            } else if (i == 14 || i == 48) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 1));
                WriteActivity.this.openImageActivity(aVar);
            } else if (i == 24) {
                Object obj = aVar.f51525c;
                if (obj == null || !(obj instanceof d.b.h0.s.c.t)) {
                    return;
                }
                d.b.h0.s.c.t tVar = (d.b.h0.s.c.t) obj;
                if (tVar.e() == EmotionGroupType.BIG_EMOTION || tVar.e() == EmotionGroupType.USER_COLLECT) {
                    if (WriteActivity.this.mCurrentPermissionJudgePolicy == null) {
                        WriteActivity.this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
                    }
                    WriteActivity.this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
                    WriteActivity.this.mCurrentPermissionJudgePolicy.appendRequestPermission(WriteActivity.this, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                    if (WriteActivity.this.mCurrentPermissionJudgePolicy.startRequestPermission(WriteActivity.this)) {
                        return;
                    }
                    if (WriteActivity.this.writeImagesInfo.size() >= WriteActivity.this.writeImagesInfo.getMaxImagesAllowed()) {
                        WriteActivity.this.showToast(String.format(WriteActivity.this.getString(R.string.max_choose_image_count), Integer.valueOf(WriteActivity.this.writeImagesInfo.getMaxImagesAllowed())));
                        return;
                    }
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    imageFileInfo.setImageType(1);
                    imageFileInfo.setFilePath(tVar.b());
                    imageFileInfo.width = tVar.g();
                    imageFileInfo.height = tVar.a();
                    WriteActivity.this.writeImagesInfo.addChooseFile(imageFileInfo);
                    WriteActivity.this.writeImagesInfo.updateQuality();
                    WriteActivity.this.refreshMutiImage(true);
                    WriteActivity.this.refreshPostButton();
                } else if (WriteActivity.this.isTextFull()) {
                    WriteActivity.this.showToast(R.string.over_limit_tip);
                } else {
                    WriteActivity.this.insertFaceIconToEditText(tVar);
                }
            } else if (i == 3) {
                WriteActivity.this.deleteChar();
            } else if (i == 10) {
                Object obj2 = aVar.f51525c;
                if (obj2 instanceof VoiceData$VoiceModel) {
                    WriteActivity.this.addVoice((VoiceData$VoiceModel) obj2);
                }
            } else if (i == 11) {
                WriteActivity.this.deleteVoice();
            } else if (i == 12 || i == 13 || i == 46 || i == 49) {
                WriteActivity.this.refreshImageLauncher();
                WriteActivity.this.refreshPostButton();
            } else if (i == 15 || i == 47) {
                Object obj3 = aVar.f51525c;
                if (obj3 == null || !(obj3 instanceof Integer)) {
                    return;
                }
                WriteActivity.this.jumpToEditImageActivity(((Integer) obj3).intValue());
            } else if (i == 18) {
                if (aVar.f51525c == null || WriteActivity.this.mAdditionData != null) {
                    int i2 = WriteActivity.this.mLocationState;
                    if (i2 != 0) {
                        if (i2 != 2) {
                            return;
                        }
                        WriteActivity.this.goToSelectLocationActivity();
                        return;
                    }
                    Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                    if (PermissionUtil.checkLocationForGoogle(pageActivity)) {
                        WriteActivity.this.onLocViewClickedInInitState();
                        return;
                    } else {
                        PermissionUtil.reuqestLocation(pageActivity, 0);
                        return;
                    }
                }
                WriteActivity.this.requestLocationIfValid();
            } else if (i == 20) {
                if (WriteActivity.this.mLocationModel != null) {
                    WriteActivity.this.mLocationModel.H(true);
                }
            } else {
                WriteVoteData writeVoteData = null;
                if (i == 25) {
                    Object obj4 = aVar.f51525c;
                    if (obj4 == null || !(obj4 instanceof String)) {
                        WriteActivity.this.mBubbleUrl = null;
                    } else {
                        WriteActivity.this.mBubbleUrl = (String) obj4;
                    }
                    WriteActivity.this.refreshBubble(false);
                } else if (i == 27) {
                    d.b.h0.r.d0.b.i().s("xiaoying_has_click", true);
                    StatisticItem statisticItem = new StatisticItem("c10645");
                    WriteData writeData = WriteActivity.this.mData;
                    statisticItem.param("fid", writeData != null ? writeData.getForumId() : "");
                    TiebaStatic.log(statisticItem);
                    WriteData writeData2 = WriteActivity.this.mData;
                    if (writeData2 == null || (videoInfo = writeData2.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                        WriteActivity.this.mEditor.A(new d.b.h0.w.a(2, 19, null));
                        if (XiaoyingUtil.isXiaoyingInstalled()) {
                            if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                if (WriteActivity.this.mEditor.u()) {
                                    WriteActivity.this.mEditor.q();
                                    WriteActivity.this.mEditor.A(new d.b.h0.w.a(5, -1, null));
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
                    WriteActivity.this.mEditor.A(new d.b.h0.w.a(2, 19, " "));
                    WriteActivity.this.mEditor.A(new d.b.h0.w.a(28, 20, videoInfo));
                } else if (i == 29) {
                    WriteActivity.this.mEditor.A(new d.b.h0.w.a(2, 19, null));
                    WriteActivity.this.mEditor.A(new d.b.h0.w.a(1, 2, null));
                    WriteActivity.this.mData.setVideoInfo(null);
                    WriteActivity.this.refreshPostButton();
                    if (WriteActivity.this.mPostContent != null) {
                        WriteActivity.this.mPostContent.requestFocus();
                    }
                    WriteActivity.this.mEditor.q();
                    WriteActivity.this.mEditor.A(new d.b.h0.w.a(5, -1, null));
                    WriteActivity writeActivity = WriteActivity.this;
                    writeActivity.ShowSoftKeyPad(writeActivity.mInputManager, WriteActivity.this.mPostContent);
                } else if (i == 43) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 4));
                    d.b.h0.r.d0.b.i().s("hot_topic_has_click", true);
                    WriteActivity.this.mEditor.A(new d.b.h0.w.a(2, 26, null));
                    WriteActivity.this.needAddHotTopicSign = true;
                    WriteActivity.this.performHotTopicClick(true);
                    if (!WriteActivity.this.getRealTitleInstance().isFocused() || WriteActivity.this.mTitleView.getVisibility() != 0) {
                        WriteActivity.this.fromWhereToHotSelect = "from_content";
                    } else {
                        WriteActivity.this.fromWhereToHotSelect = "from_title";
                    }
                } else if (i == 56) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 8));
                    if (WriteActivity.this.mTitleView.getVisibility() == 0) {
                        if (WriteActivity.this.mTitleView.hasFocus()) {
                            WriteActivity.this.mPostContent.requestFocus();
                            WriteActivity.this.mPostContent.setSelection(WriteActivity.this.mPostContent.getText().toString().length());
                        }
                        WriteActivity.this.mTitleView.setVisibility(8);
                        if (WriteActivity.this.imageGridView != null) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) WriteActivity.this.imageGridView.getLayoutParams();
                            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                            WriteActivity.this.imageGridView.setLayoutParams(layoutParams);
                        }
                        WriteActivity.this.mTitleViewDivider.setVisibility(8);
                        WriteActivity.this.mEditor.m(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                    } else {
                        WriteActivity.this.mTitleView.setVisibility(0);
                        if (WriteActivity.this.imageGridView != null) {
                            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) WriteActivity.this.imageGridView.getLayoutParams();
                            layoutParams2.topMargin = 0;
                            WriteActivity.this.imageGridView.setLayoutParams(layoutParams2);
                        }
                        WriteActivity.this.mTitleViewDivider.setVisibility(0);
                        WriteActivity.this.mTitleView.requestFocus();
                        WriteActivity.this.mEditor.m(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                    }
                    WriteActivity.this.refreshPostButton();
                } else if (i == 55) {
                    Object obj5 = aVar.f51525c;
                    if (obj5 == null || !(obj5 instanceof Boolean)) {
                        return;
                    }
                    WriteActivity.this.isPrivacy = ((Boolean) obj5).booleanValue();
                } else if (i == 58) {
                    Object obj6 = aVar.f51525c;
                    if (obj6 == null || !(obj6 instanceof Boolean)) {
                        return;
                    }
                    WriteActivity.this.isToDynamic = ((Boolean) obj6).booleanValue();
                } else if (i == 22) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 10));
                    if (WriteActivity.this.mVoteViewController != null && WriteActivity.this.mVoteViewController.c() != null) {
                        writeVoteData = WriteActivity.this.mVoteViewController.c();
                    }
                    WriteActivity.this.jumpToVoteView(writeVoteData);
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 2));
                    WriteActivity.this.hideGuideTip();
                } else if (i != 21) {
                    if (i == 59) {
                        WriteActivity.this.onCommodityClick();
                    }
                } else {
                    if (WriteActivity.this.mFindNewLinkBubbleController != null) {
                        WriteActivity.this.mFindNewLinkBubbleController.c();
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddLinkActivityConfig(WriteActivity.this.getActivity(), 25049, "", true, null)));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p0 implements a.InterfaceC1076a {
        public p0() {
        }

        @Override // d.b.h0.r.f0.p.a.InterfaceC1076a
        public void a(int i, boolean z) {
            WriteActivity.this.refreshListView();
        }
    }

    /* loaded from: classes5.dex */
    public class q implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteVoteData f22524e;

        public q(WriteVoteData writeVoteData) {
            this.f22524e = writeVoteData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.jumpToVoteView(this.f22524e);
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 3));
        }
    }

    /* loaded from: classes5.dex */
    public class q0 implements View.OnTouchListener {
        public q0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                view.requestFocus();
                WriteActivity.this.mEditor.A(new d.b.h0.w.a(5, -1, null));
                WriteActivity.this.mPostContent.requestFocus();
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null) {
                return;
            }
            int id = view.getId();
            if (id == R.id.save_draft_dialog_not_save) {
                WriteActivity.this.clearDraft();
                WriteActivity.this.deleteTempVideoFile();
                WriteActivity.this.setResult(100);
                WriteActivity.this.finish();
            } else if (id == R.id.save_draft_dialog_save) {
                WriteActivity.this.processSaveDraft();
                WriteActivity.this.setResult(100);
                WriteActivity.this.finish();
            }
            WriteActivity.this.saveDraftDialog.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class r0 extends CustomMessageListener {
        public r0(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.b.h0.t.i iVar;
            if (WriteActivity.this.mForumSelectedView == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.h0.t.i) || (iVar = (d.b.h0.t.i) customResponsedMessage.getData()) == null || StringUtils.isNull(iVar.f51470a) || StringUtils.isNull(iVar.f51472c)) {
                return;
            }
            WriteActivity.this.initSelectForumData(iVar);
        }
    }

    /* loaded from: classes5.dex */
    public class s implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public String f22529e = "";

        /* renamed from: f  reason: collision with root package name */
        public String f22530f;

        public s() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.refreshPostButton();
            WriteActivity.this.updateTitleStyle();
            EditText realTitleInstance = WriteActivity.this.getRealTitleInstance();
            if (editable == null || realTitleInstance == null || realTitleInstance.getText() == null) {
                return;
            }
            String str = this.f22529e;
            if (str == null || !str.equals(editable.toString())) {
                if (WriteActivity.this.mHighLightController != null) {
                    this.f22529e = realTitleInstance.getText().toString();
                    WriteActivity.this.mHighLightController.j(realTitleInstance, true);
                    return;
                }
                return;
            }
            realTitleInstance.setSelection(realTitleInstance.getSelectionEnd());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f22530f = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String str = this.f22530f;
            if ((charSequence != null ? charSequence.toString().length() : 0) > (str != null ? str.length() : 0)) {
                WriteActivity.this.gotoHotTopicSelectActivity(charSequence, i, i3, "from_title");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s0 extends d.b.b.e.l.c<d.b.b.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f22532a;

        public s0(boolean z) {
            this.f22532a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            super.onLoaded((s0) aVar, str, i);
            if (aVar == null || aVar.p() == null || aVar.o() == null) {
                return;
            }
            if (WriteActivity.this.writeVideoController != null && WriteActivity.this.writeVideoController.n()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001353, Boolean.FALSE));
                return;
            }
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.p(), aVar.p().getNinePatchChunk(), aVar.o(), null);
            if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
            }
            WriteActivity.this.getRealContentEdittextInstance().setBackgroundDrawable(ninePatchDrawable);
            if (this.f22532a) {
                d.b.i0.c3.g0.a.c(WriteActivity.this.getPageContext(), WriteActivity.this.getRealContentEdittextInstance(), true, WriteActivity.this.mBubbleTipRefreshCallback);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001353, Boolean.TRUE));
        }
    }

    /* loaded from: classes5.dex */
    public class t implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public String f22534e = "";

        /* renamed from: f  reason: collision with root package name */
        public String f22535f;

        public t() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.refreshPostButton();
            EditText realContentEdittextInstance = WriteActivity.this.getRealContentEdittextInstance();
            if (editable == null || realContentEdittextInstance == null || realContentEdittextInstance.getText() == null) {
                return;
            }
            String str = this.f22534e;
            if (str == null || !str.equals(editable.toString())) {
                if (WriteActivity.this.mHighLightController != null) {
                    this.f22534e = realContentEdittextInstance.getText().toString();
                    WriteActivity.this.mHighLightController.j(realContentEdittextInstance, false);
                }
                if (WriteActivity.this.isEvaluate) {
                    WriteActivity.this.addEvaluateTextChangeOperation(editable);
                    return;
                }
                return;
            }
            realContentEdittextInstance.setSelection(realContentEdittextInstance.getSelectionEnd());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f22535f = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String str = this.f22535f;
            if ((charSequence != null ? charSequence.toString().length() : 0) > (str != null ? str.length() : 0)) {
                WriteActivity.this.gotoHotTopicSelectActivity(charSequence, i, i3, "from_content");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t0 implements a.f {
        public t0() {
        }

        @Override // d.b.i0.c3.g0.a.f
        public void onRefresh() {
            WriteActivity.this.mBubbleUrl = null;
            WriteActivity.this.refreshBubble(false);
            WriteActivity.this.mEditor.A(new d.b.h0.w.a(2, 12, null));
        }
    }

    /* loaded from: classes5.dex */
    public class u implements View.OnTouchListener {
        public u() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 2) {
                if (WriteActivity.this.mPostContent != null) {
                    d.b.b.e.p.l.w(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.mPostContent);
                }
                if (WriteActivity.this.mEditor != null) {
                    WriteActivity.this.mEditor.q();
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class u0 implements AdapterView.OnItemClickListener {
        public u0() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (WriteActivity.this.mAdapter == null || !(WriteActivity.this.mAdapter.getItem(i) instanceof d.b.h0.r.q.v)) {
                return;
            }
            d.b.h0.r.q.v vVar = (d.b.h0.r.q.v) WriteActivity.this.mAdapter.getItem(i);
            int i2 = vVar.f50897f;
            if (i2 == 1) {
                if (vVar.s == 1) {
                    UrlManager.getInstance().dealOneLink(WriteActivity.this.getPageContext(), new String[]{vVar.k});
                    return;
                }
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<WriteActivity> pageContext = WriteActivity.this.getPageContext();
                urlManager.dealOneLink(pageContext, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + d.b.b.e.p.k.getUrlEncode(vVar.k)});
            } else if (i2 == 2) {
                if (!TextUtils.isEmpty(vVar.n)) {
                    if (vVar.n.startsWith("tiebaclient://")) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, vVar.n));
                        return;
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(vVar.n));
                    intent.addFlags(268468224);
                    if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                        WriteActivity.this.startActivity(intent);
                    } else if (TextUtils.isEmpty(vVar.o)) {
                    } else {
                        UrlManager urlManager2 = UrlManager.getInstance();
                        TbPageContext<WriteActivity> pageContext2 = WriteActivity.this.getPageContext();
                        urlManager2.dealOneLink(pageContext2, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + d.b.b.e.p.k.getUrlEncode(vVar.o)});
                    }
                } else if (TextUtils.isEmpty(vVar.o)) {
                } else {
                    UrlManager urlManager3 = UrlManager.getInstance();
                    TbPageContext<WriteActivity> pageContext3 = WriteActivity.this.getPageContext();
                    urlManager3.dealOneLink(pageContext3, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + d.b.b.e.p.k.getUrlEncode(vVar.o)});
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v extends HttpMessageListener {
        public v(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() != 0) {
                return;
            }
            String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
            if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.mBubbleUrl)) {
                WriteActivity.this.mBubbleUrl = str;
                TbadkCoreApplication.getInst().setDefaultBubble(str);
                WriteActivity.this.refreshBubble(true);
            } else if (TextUtils.isEmpty(str) || str.equals(WriteActivity.this.mBubbleUrl)) {
            } else {
                WriteActivity.this.mBubbleUrl = str;
                TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.mBubbleUrl);
                WriteActivity.this.refreshBubble(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v0 implements Runnable {
        public v0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WriteActivity.this.fromErrorDialog) {
                WriteActivity.this.mOnPostWriteCallback.callback(false, d.b.i0.c3.q0.c.f53583c, d.b.i0.c3.q0.c.f53584d, d.b.i0.c3.q0.c.f53585e, d.b.i0.c3.q0.c.f53586f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements View.OnClickListener {
        public w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            view.requestFocus();
            WriteActivity.this.mEditor.A(new d.b.h0.w.a(5, -1, null));
            WriteActivity.this.mPostContent.requestFocus();
        }
    }

    /* loaded from: classes5.dex */
    public class w0 implements Runnable {
        public w0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.b.e.p.l.w(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
        }
    }

    /* loaded from: classes5.dex */
    public class x implements View.OnClickListener {
        public x() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.deleteVoice();
        }
    }

    /* loaded from: classes5.dex */
    public class x0 implements Runnable {
        public x0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WriteActivity.this.mPhotoLiveGridViewAdapter.notifyDataSetChanged();
            WriteActivity.this.mPhotoLiveGridView.invalidateViews();
        }
    }

    /* loaded from: classes5.dex */
    public class y implements View.OnClickListener {
        public y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.stopTask();
            WriteActivity.this.popupSaveDraftDialog();
        }
    }

    /* loaded from: classes5.dex */
    public class y0 extends BdAsyncTask<Void, Integer, Void> {
        public y0() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            FileHelper.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.photoName));
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public class z implements View.OnClickListener {
        public z() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
        }
    }

    /* loaded from: classes5.dex */
    public class z0 extends q.a {
        public z0() {
        }

        @Override // d.b.h0.z0.q.a
        public void onError(int i, String str) {
        }

        @Override // d.b.h0.z0.q.a
        public void onSuccess(String str) {
            if (!new File(str).exists() || WriteActivity.this.writeImagesInfo == null) {
                return;
            }
            WriteActivity.this.writeImagesInfo.clear();
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.isFromMoreForum = true;
            WriteActivity.this.writeImagesInfo.addChooseFile(imageFileInfo);
            WriteActivity.this.writeImagesInfo.setMaxImagesAllowed(1);
            WriteActivity.this.refreshMutiImage(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEvaluateTextChangeOperation(Editable editable) {
        dealPostContentCounter(editable);
        refreshPostStatus(editable);
    }

    private void addHotTopic(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        int i2 = -1;
        Editable editable = null;
        if ("from_content".equals(this.fromWhereToHotSelect)) {
            this.fromWhereToHotSelect = "";
            getRealContentEdittextInstance().requestFocus();
            if (getRealContentEdittextInstance().getText() != null && getRealContentEdittextInstance().getText().length() + str.length() > 5000) {
                showToast(R.string.over_limit_tip);
                return;
            } else {
                i2 = getRealContentEdittextInstance().getSelectionStart();
                editable = getRealContentEdittextInstance().getText();
            }
        } else if ("from_title".equals(this.fromWhereToHotSelect)) {
            this.fromWhereToHotSelect = "";
            getRealTitleInstance().requestFocus();
            if (getRealTitleInstance().getText() != null && getRealTitleInstance().getText().length() + str.length() > 31) {
                showToast(R.string.over_limit_tip);
                return;
            } else {
                i2 = getRealTitleInstance().getSelectionStart();
                editable = getRealTitleInstance().getText();
            }
        }
        if (editable == null || i2 < 0 || i2 > editable.length()) {
            return;
        }
        editable.insert(i2, str);
    }

    private void addTabInfoForPostWriteIfNeed() {
        WriteData writeData = this.mData;
        if (writeData == null || this.mForumTabSelectedView == null) {
            return;
        }
        FrsTabInfoData frsTabInfoData = this.mFrsTabList;
        writeData.setIsForumBusinessAccount(frsTabInfoData == null ? false : frsTabInfoData.isForumBusinessAccount);
        FrsTabItemData selectedTabItemData = this.mForumTabSelectedView.getSelectedTabItemData();
        if (selectedTabItemData == null) {
            return;
        }
        this.mData.setTabId(selectedTabItemData.tabId);
        this.mData.setTabName(selectedTabItemData.name);
        this.mData.setIsGeneralTab(selectedTabItemData.isGeneralTab);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addVoice(VoiceData$VoiceModel voiceData$VoiceModel) {
        if (voiceData$VoiceModel == null || TextUtils.isEmpty(voiceData$VoiceModel.voiceId) || voiceData$VoiceModel.duration <= 0) {
            return;
        }
        this.mVoiceModel = voiceData$VoiceModel;
        this.mData.setVoiceModel(voiceData$VoiceModel);
        this.mLayoutVoicePlay.setVisibility(0);
        this.mVoicePlayButton.setVoiceModel(voiceData$VoiceModel);
        this.mVoicePlayButton.o();
        refreshPostButton();
    }

    private void bindMoreForumImg() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.mMoreForumImg)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            if (this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                return;
            }
            d.b.h0.z0.q qVar = new d.b.h0.z0.q(this, this.mMoreForumImg, new z0());
            qVar.p(1);
            qVar.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canShowSuccessTip(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    private void changeHotTopicData(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData == null || (hotTopicBussinessData2 = (HotTopicBussinessData) ListUtils.getItem(this.mList, 0)) == null || TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            return;
        }
        SpannableString j2 = d.b.h0.p0.b.j(d.b.h0.p0.b.a(hotTopicBussinessData.mTopicName));
        if (j2 != null) {
            this.mPostTitle.setText(j2);
        }
        this.mHotTopicEdt.setText(hotTopicBussinessData.mForumName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeToolButtonStatus() {
        d.b.h0.w.t.a aVar;
        if (this.mEditor != null) {
            d.b.i0.u3.v.o.a aVar2 = this.writeVideoController;
            if (aVar2 != null && aVar2.n()) {
                this.mEditor.setBarLauncherEnabled(!this.isDisalbeButtons);
                this.mEditor.setDeskLauncherEnabled(!this.isDisalbeButtons);
                this.mEditor.setToolEnabled(true, 2);
                this.mEditor.setToolEnabled(true, 32);
                this.mEditor.setToolEnabled(false, 10);
                this.mEditor.setToolEnabled(false, 6);
                this.mEditor.setToolEnabled(false, 18);
                this.mEditor.n(5).e(false);
                d.b.i0.u3.n.b bVar = this.mWriteTool;
                if (bVar != null) {
                    bVar.n(true);
                }
            } else {
                this.mEditor.setBarLauncherEnabled(!this.isDisalbeButtons);
                this.mEditor.setDeskLauncherEnabled(!this.isDisalbeButtons);
                this.mEditor.setToolEnabled(true, 26);
                this.mEditor.setToolEnabled(true, 2);
                this.mEditor.setToolEnabled(true, 30);
                this.mEditor.n(5).e(true);
                d.b.i0.u3.n.b bVar2 = this.mWriteTool;
                if (bVar2 != null) {
                    bVar2.n(true);
                }
                refreshImageLauncher();
            }
            if (!this.isEvaluate || (aVar = this.mLinkTool) == null || aVar.d()) {
                return;
            }
            this.mEditor.setToolEnabled(false, 31);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkCanGoodsConsistent() {
        SpanGroupEditText spanGroupEditText;
        return this.canGoods || (spanGroupEditText = this.mPostContent) == null || spanGroupEditText.getSpanGroupManager() == null || this.mPostContent.getSpanGroupManager().o() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkClipboardAndShowNewLinkBubble() {
        EditorTools editorTools = this.mEditor;
        if (editorTools == null) {
            return;
        }
        editorTools.post(new d1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkContainHaowuTab() {
        FrsTabInfoData frsTabInfoData = this.mFrsTabList;
        if (frsTabInfoData != null && !ListUtils.isEmpty(frsTabInfoData.tabList)) {
            for (FrsTabItemData frsTabItemData : this.mFrsTabList.tabList) {
                if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int checkTabConsistent() {
        d.b.i0.u3.v.d dVar = this.mAdapter;
        boolean z2 = dVar == null || dVar.e();
        ForumTabSelectedView forumTabSelectedView = this.mForumTabSelectedView;
        boolean z3 = (forumTabSelectedView == null || forumTabSelectedView.getSelectedTabItemData() == null || this.mForumTabSelectedView.getSelectedTabItemData().tabType != 3) ? false : true;
        if (z2 && z3) {
            return 1;
        }
        return (z2 || z3) ? 0 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chooseRecommendPic(String str) {
        if (d.b.b.e.p.k.isEmpty(str) || this.mRecDialog == null) {
            return;
        }
        getRecommendImgData(str);
        this.mRecDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDraft() {
        if (this.mData.getType() != 0 && this.mData.getType() != 9 && this.mData.getType() != 11) {
            if (this.mData.getType() == 1) {
                d.b.i0.c3.y.p(this.mData.getThreadId(), null);
            }
        } else if (this.isSaveDraft) {
            if (this.mData.isEvaluate()) {
                d.b.i0.c3.y.m(this.mData.getItem_id(), null);
            } else if (TextUtils.isEmpty(this.mData.getTopicId())) {
                d.b.i0.c3.y.o(this.mData.getForumId(), this.mData, true);
            } else {
                d.b.i0.c3.y.r(this.mData.getTopicId(), null);
            }
        }
        this.isProcessedSaveDraft = true;
    }

    private void dealAlbumFromCamera(Intent intent) {
        if (this.writeImagesInfo == null) {
            return;
        }
        getCameraData(intent);
        int size = this.writeImagesInfo.size() - 1;
        if (size <= -1 || this.writeImagesInfo.getChosedFiles() == null || this.writeImagesInfo.size() < 1) {
            return;
        }
        sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
    }

    private void dealAlbumFromImages(Intent intent) {
        if (this.isLivePhotoType) {
            getAlbumDataForPhotoLive(intent);
            updateGriViewData();
        } else {
            getAlbumData(intent);
        }
        refreshPostButton();
    }

    private void dealLiveCoverFromCamera() {
        if (TbadkCoreApplication.getCurrentAccountObj() == null) {
            return;
        }
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) PlayerPostEvent.MEDIA_REP_CHANGE_START, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
    }

    private void dealLiveCoverFromImage(Intent intent) {
        String stringExtra;
        if (intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        this.liveCoverImageInfo.parseJson(stringExtra);
        this.liveCoverImageInfo.updateQuality();
        if (this.liveCoverImageInfo.getChosedFiles() != null && this.liveCoverImageInfo.getChosedFiles().size() > 0) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) PlayerPostEvent.MEDIA_REP_CHANGE_END, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.liveCoverImageInfo.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
        }
        this.liveCoverImageInfo.clear();
    }

    private void dealPostContentCounter(Editable editable) {
        if (editable.length() > 500) {
            this.mPostContentCounter.setText((500 - editable.length()) + "/500");
            this.mPostContentCounter.setVisibility(0);
            return;
        }
        this.mPostContentCounter.setVisibility(4);
    }

    private void deleteTempCameraFile() {
        new y0().execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteTempVideoFile() {
        FileHelper.deleteFileOrDir(new File(d.b.i0.p3.c.f58889c));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteVoice() {
        d.b.h0.w.n nVar;
        VoiceData$VoiceModel voiceData$VoiceModel = this.mVoiceModel;
        if (voiceData$VoiceModel != null) {
            d.b.h0.r.g0.a.a(d.b.h0.r.g0.a.b(voiceData$VoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.mData.setVoiceModel(null);
        this.mLayoutVoicePlay.setVisibility(8);
        this.mVoicePlayButton.p();
        this.mVoicePlayButton.setVoiceModel(null);
        d.b.h0.w.m n2 = this.mEditor.n(6);
        if (n2 != null && (nVar = n2.k) != null) {
            nVar.onAction(new d.b.h0.w.a(52, 0, null));
        }
        refreshPostButton();
    }

    private void displayLauncherById(int i2, boolean z2) {
        d.b.h0.w.h m2;
        EditorTools editorTools = this.mEditor;
        if (editorTools == null || (m2 = editorTools.m(i2)) == null) {
            return;
        }
        if (z2) {
            m2.b();
        } else {
            m2.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int emotionCheck() {
        int selectionEnd = getRealContentEdittextInstance().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) getRealContentEdittextInstance().getText().getSpans(0, getRealContentEdittextInstance().getText().length(), ImageSpan.class);
        for (int i2 = 0; i2 < imageSpanArr.length; i2++) {
            int spanStart = getRealContentEdittextInstance().getText().getSpanStart(imageSpanArr[i2]);
            int spanEnd = getRealContentEdittextInstance().getText().getSpanEnd(imageSpanArr[i2]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    private void fillContent(WriteData writeData) {
        this.mData.setContent(writeData.getContent());
        SpannableString l2 = TbFaceManager.e().l(getPageContext().getPageActivity(), this.mData.getContent(), this.mBigEmotionSpanHanlder);
        InputFilter[] filters = this.mPostContent.getFilters();
        this.mPostContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(IMConstants.ERROR_BASE)});
        getRealContentEdittextInstance().setText(l2);
        EditText realContentEdittextInstance = getRealContentEdittextInstance();
        SpanGroupEditText spanGroupEditText = this.mPostContent;
        if (realContentEdittextInstance == spanGroupEditText && spanGroupEditText.getSpanGroupManager() != null) {
            this.mPostContent.f();
            this.mPostContent.getSpanGroupManager().m();
            this.mPostContent.b();
            refreshListView();
        }
        this.mPostContent.setFilters(filters);
        if (getRealContentEdittextInstance().getText() != null) {
            getRealContentEdittextInstance().setSelection(getRealContentEdittextInstance().getText().length());
        }
        if (this.isLivePhotoType) {
            setLeftCount(this.mContentOverPlusNumber, this.live_post_content);
        }
    }

    private void fillTitle(WriteData writeData) {
        String a2;
        if (d.b.b.e.p.k.isEmpty(this.mData.getTitle())) {
            this.mData.setTitle(writeData.getTitle());
        }
        if (!ListUtils.isEmpty(this.mList)) {
            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) ListUtils.getItem(this.mList, 0);
            String str = hotTopicBussinessData != null ? hotTopicBussinessData.mTopicName : null;
            if (StringUtils.isNull(str)) {
                a2 = this.mData.getTitle();
            } else {
                a2 = d.b.h0.p0.b.a(str);
            }
            SpannableString j2 = d.b.h0.p0.b.j(a2);
            if (j2 != null) {
                getRealTitleInstance().setText(j2);
                getRealTitleInstance().setSelection(j2.length() > a2.length() ? a2.length() : j2.length());
                return;
            }
            return;
        }
        SpannableString j3 = d.b.h0.p0.b.j(this.mData.getTitle());
        if (j3 != null) {
            getRealTitleInstance().setText(j3);
            getRealTitleInstance().setSelection(this.mData.getTitle().length() > j3.length() ? j3.length() : this.mData.getTitle().length());
        }
    }

    private void fillVideoOrImage(WriteData writeData) {
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(writeData.getVideoInfo());
            this.mData.setVideoInfo(videoInfo);
            showPicOrVideo(false, true);
            return;
        }
        if (writeData.getWriteImagesInfo() != null) {
            this.writeImagesInfo = writeData.getWriteImagesInfo();
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            sendSetImgAction();
        }
        refreshMutiImage(false);
        showPicOrVideo(true, true);
    }

    private void getAlbumData(Intent intent) {
        getResImgData(intent, true);
    }

    private void getAlbumDataForPhotoLive(Intent intent) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
        }
        updateGriViewData();
        refreshMutiImage(true);
    }

    private void getCameraData(Intent intent) {
        this.photoName = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.photoName;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, d.b.b.e.p.l.e(getPageContext().getPageActivity(), d.b.b.e.p.l.k(getPageContext().getPageActivity())), d.b.b.e.p.l.e(getPageContext().getPageActivity(), d.b.b.e.p.l.i(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    FileHelper.SaveFile(TbConfig.LOCAL_CAMERA_DIR, this.photoName, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception unused) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            refreshImageLauncher();
            sendSetImgAction();
        }
        refreshMutiImage(true);
    }

    private String getCommonHead() {
        ArrayList arrayList = new ArrayList();
        WriteEvaluationHeaderView writeEvaluationHeaderView = this.mWriteEvaluationeHeaderView;
        arrayList.add(new HeadItem("", String.valueOf(writeEvaluationHeaderView != null ? writeEvaluationHeaderView.getStarCount() : 0), 2));
        return new Gson().toJson(arrayList);
    }

    private String getContent() {
        return (getRealContentEdittextInstance() == null || getRealContentEdittextInstance().getText() == null) ? "" : getRealContentEdittextInstance().getText().toString();
    }

    private void getDimension(Context context) {
        SCREEN_HEIGHT = d.b.b.e.p.l.i(context);
    }

    private long getInputCount(EditText editText) {
        return d.b.i0.u3.s.a.a(editText.getText().toString().trim());
    }

    private File getLatestPic() {
        Cursor query = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_data", "bucket_display_name", "datetaken", "mime_type"}, null, null, "datetaken DESC");
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
                if (!upperCase.contains("DCIM/CAMERA") && !upperCase.contains("DCIM/100ANDRO") && !upperCase.contains("DCIM/100MEDIA") && !upperCase.contains("SCREENSHOTS") && !upperCase.contains(name.toUpperCase()) && !upperCase.contains(name2.toUpperCase())) {
                    query.moveToNext();
                }
                return file;
            }
            return null;
        } finally {
            query.close();
        }
    }

    private long getMaxInpputNum(EditText editText) {
        if (editText == this.live_post_content) {
            return 233L;
        }
        return editText == this.live_post_title ? 20L : 0L;
    }

    private void getMotuData(Intent intent) {
        getResImgData(intent, false);
    }

    public static Bitmap getPreviewImg(String str, float f2) {
        Bitmap bitmap;
        int i2 = (int) f2;
        Bitmap bitmap2 = null;
        if (!d.b.b.e.p.k.isEmpty(str) && i2 > 0) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                int i3 = options.outWidth;
                int i4 = options.outHeight;
                bitmap = BitmapHelper.resizeBitmapAbsolute(str, (Math.max(i3, i4) * i2) / Math.min(i3, i4));
            } catch (Exception unused) {
                bitmap = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(bitmap, i2);
                if (bitmap != null && bitmap != resizedBitmap && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                System.gc();
                return resizedBitmap;
            } catch (Exception unused2) {
                if (bitmap != null && bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                System.gc();
                return null;
            } catch (Throwable th2) {
                th = th2;
                bitmap2 = bitmap;
                if (bitmap2 != null && bitmap2 != null && !bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
                System.gc();
                throw th;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText getRealTitleInstance() {
        return this.isLivePhotoType ? this.live_post_title : this.mPostTitle;
    }

    private void getRecommendImgData(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.isAttach = true;
        refreshImageLauncher();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            sendSetImgAction();
        }
        refreshMutiImage(true);
    }

    private void getResImgData(Intent intent, boolean z2) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            refreshImageLauncher();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                sendSetImgAction();
            }
        }
        refreshMutiImage(true);
    }

    private int getStarByScore(double d2) {
        return (int) ((d2 + 1.0d) / 2.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getStillCommodityNum() {
        SpanGroupEditText spanGroupEditText = this.mPostContent;
        if (spanGroupEditText == null || spanGroupEditText.getSpanGroupManager() == null) {
            return 10;
        }
        return 10 - this.mPostContent.getSpanGroupManager().o();
    }

    private TextWatcher getTextWatcher() {
        o0 o0Var = new o0();
        if (this.isLivePhotoType && this.isPhotoliveTitleHasFocus) {
            TextWatcher textWatcher = this.mOldTitleTextWatcher;
            if (textWatcher != null) {
                this.live_post_title.removeTextChangedListener(textWatcher);
            }
            this.mOldTitleTextWatcher = o0Var;
        } else if (this.isLivePhotoType) {
            TextWatcher textWatcher2 = this.mOldContentTextWatcher;
            if (textWatcher2 != null) {
                this.live_post_content.removeTextChangedListener(textWatcher2);
            }
            this.mOldContentTextWatcher = o0Var;
        }
        return o0Var;
    }

    private String getThreadTitle() {
        TextView textView;
        if (this.mData == null || getRealTitleInstance() == null || getRealTitleInstance().getVisibility() != 0 || getRealTitleInstance().getText() == null) {
            return "";
        }
        String obj = getRealTitleInstance().getText().toString();
        PostPrefixData postPrefixData = this.mPrefixData;
        if (postPrefixData != null && ListUtils.getCount(postPrefixData.getPrefixs()) > 0 && this.mCurrPrefixPos != ListUtils.getCount(this.mPrefixData.getPrefixs()) - 1 && this.mData.getType() != 4 && (textView = this.mPrefix) != null && textView.getText() != null) {
            this.mData.setPostPrefix(this.mPrefix.getText().toString());
        }
        PostPrefixData postPrefixData2 = this.mPrefixData;
        if (postPrefixData2 == null || StringUtils.isNull(postPrefixData2.getImplicitTitle())) {
            return obj;
        }
        return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
    }

    private void getTopList() {
        if (!this.isFeedBack || this.mData == null) {
            return;
        }
        this.mTopListView.setVisibility(0);
        this.feedback_divider.setVisibility(0);
        FeedBackModel feedBackModel = new FeedBackModel(getPageContext());
        this.mFeedBackModel = feedBackModel;
        feedBackModel.v(this.mData.getForumName());
        this.mFeedBackModel.setLoadDataCallBack(new m0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToSelectLocationActivity() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoHotTopicSelectActivity(CharSequence charSequence, int i2, int i3, String str) {
        if (!this.isKeyboardVisibility || charSequence == null || i3 != 1 || i2 >= charSequence.length() || i2 < 0) {
            return;
        }
        this.needAddHotTopicSign = false;
        this.fromWhereToHotSelect = "";
        if ("from_content".equals(str)) {
            this.fromWhereToHotSelect = "from_content";
        } else if ("from_title".equals(str)) {
            this.fromWhereToHotSelect = "from_title";
        }
        if (d.b.h0.p0.b.f(String.valueOf(charSequence.charAt(i2)))) {
            performHotTopicClick(false);
        }
    }

    private boolean hasRichText(Spannable spannable) {
        if (spannable != null) {
            ImageSpan[] imageSpanArr = (ImageSpan[]) spannable.getSpans(0, spannable.length(), ImageSpan.class);
            if (imageSpanArr == null || imageSpanArr.length <= 0) {
                d.b.i0.u3.v.c cVar = this.mHighLightController;
                if (cVar == null || !cVar.g(spannable)) {
                    return UrlManager.getInstance().isFindUrlEndWithBlank(spannable);
                }
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean hasWriteVote() {
        d.b.i0.u3.v.p.a aVar = this.mVoteViewController;
        return (aVar == null || this.mVoteLayoutRoot == null || aVar.c() == null || this.mVoteLayoutRoot.getVisibility() != 0) ? false : true;
    }

    private void hideBubbleTemporary() {
        if (getRealContentEdittextInstance() == null) {
            return;
        }
        getRealContentEdittextInstance().setPadding(0, 0, 0, 0);
        getRealContentEdittextInstance().setBackgroundDrawable(null);
        SkinManager.setBackgroundColor(getRealContentEdittextInstance(), R.color.CAM_X0201);
    }

    private void hideCommodityTip() {
        d.b.i0.u3.v.b bVar = this.mCommodityTipController;
        if (bVar != null) {
            bVar.a();
        }
    }

    private void hideEditorTopicTip() {
        d.b.i0.u3.v.g gVar = this.mTipController;
        if (gVar != null) {
            gVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideGuideTip() {
        ImageView imageView = this.mGuide;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = this.mName;
        if (textView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.rightMargin = this.originalMargin;
            this.mName.setLayoutParams(layoutParams);
        }
    }

    private void initAddition() {
        this.mAdditionContainer = (RelativeLayout) findViewById(R.id.addition_container);
        this.mAdditionCreateTime = (TextView) findViewById(R.id.addition_create_time);
        this.mAdditionLastTime = (TextView) findViewById(R.id.addition_last_time);
        this.mAdditionLastContent = (TextView) findViewById(R.id.addition_last_content);
        if (this.mAdditionData != null) {
            this.mAdditionContainer.setVisibility(0);
            TextView textView = this.mAdditionCreateTime;
            textView.setText(getPageContext().getString(R.string.write_addition_create) + StringHelper.getFormatTime(this.mAdditionData.getCreateTime() * 1000));
            if (this.mAdditionData.getAlreadyCount() == 0) {
                this.mAdditionLastTime.setVisibility(8);
            } else {
                TextView textView2 = this.mAdditionLastTime;
                textView2.setText(getPageContext().getString(R.string.write_addition_last) + StringHelper.getFormatTime(this.mAdditionData.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.mAdditionData.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.mAdditionLastContent.setText(lastAdditionContent);
            } else {
                this.mAdditionLastContent.setVisibility(8);
            }
            getRealContentEdittextInstance().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.mAdditionData.getAlreadyCount()), Integer.valueOf(this.mAdditionData.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.mAdditionContainer.setVisibility(8);
    }

    private void initCategoryData() {
        d.b.i0.p0.e0 b2 = d.b.i0.p0.d0.a().b(1);
        if (b2 == null) {
            return;
        }
        List<d.b.i0.p0.c0> list = b2.f57400b;
        this.mCategoryList = list;
        if (list == null || list.isEmpty() || this.mCategoryFromID < 0) {
            return;
        }
        d.b.i0.p0.c0 c0Var = new d.b.i0.p0.c0();
        this.mCategoryDefault = c0Var;
        c0Var.f57361b = 0;
        c0Var.f57360a = getPageContext().getResources().getString(R.string.category_auto);
        d.b.i0.p0.c0 c0Var2 = this.mCategoryDefault;
        this.mCategoryToID = c0Var2.f57361b;
        this.mCategoryName = c0Var2.f57360a;
        for (d.b.i0.p0.c0 c0Var3 : this.mCategoryList) {
            int i2 = c0Var3.f57361b;
            if (i2 == this.mCategoryFromID) {
                this.mCategoryToID = i2;
                this.mCategoryName = c0Var3.f57360a;
                return;
            }
        }
    }

    private void initCategoryUI() {
        List<d.b.i0.p0.c0> list = this.mCategoryList;
        if (list == null || list.isEmpty()) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
        linearLayout.setVisibility(0);
        findViewById(R.id.interval_view_cate).setVisibility(0);
        PostCategoryView postCategoryView = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
        this.mCategoryView = postCategoryView;
        postCategoryView.setText(this.mCategoryName);
        this.mCategoryView.setCategoryContainerData(this.mCategoryList, this.mCategoryDefault, this.mCategoryToID);
        this.mCategoryView.setCategoryContainerClickCallback(new h0());
        linearLayout.setOnClickListener(new i0());
    }

    private void initCommonEditorTools() {
        d.b.h0.w.m mVar;
        d.b.h0.w.m mVar2;
        d.b.h0.w.m mVar3;
        CustomResponsedMessage runTask;
        d.b.h0.w.m mVar4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        d.b.h0.w.r.d dVar = new d.b.h0.w.r.d(getActivity(), 1);
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            this.mEditor.d(dVar);
        }
        Boolean isEnableAudio = isEnableAudio();
        if (!this.isFeedBack && isEnableAudio != null && isEnableAudio.booleanValue() && d.b.i0.c3.p0.c.a() && d.b.i0.c3.u.a(this.mData.getForumName(), Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), d.b.h0.w.m.class)) != null && (mVar4 = (d.b.h0.w.m) runTask.getData()) != null) {
            mVar4.j = 2;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.mEditor.d(mVar4);
            }
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001343, getActivity()), d.b.h0.w.m.class);
        if (runTask2 != null && (mVar3 = (d.b.h0.w.m) runTask2.getData()) != null) {
            mVar3.j = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.mEditor.d(mVar3);
            }
        }
        if (!d.b.i0.u3.s.b.c() && !this.isEvaluate) {
            this.mEditor.d(new d.b.h0.w.l(getActivity(), 6));
        }
        this.mEditor.d(new d.b.h0.w.o.a(getActivity(), 7));
        if (StringHelper.equals(this.mCallFrom, "2")) {
            d.b.h0.w.t.a aVar = new d.b.h0.w.t.a(getActivity(), 3);
            this.mLinkTool = aVar;
            if (this.isEvaluate) {
                aVar.g(false);
                this.mLinkTool.h(false);
            }
            this.mEditor.d(this.mLinkTool);
            if (!this.isEvaluate) {
                this.mEditor.d(new d.b.h0.w.z.a(getActivity(), 8));
            }
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), d.b.h0.w.m.class);
        if (runTask3 != null && (mVar2 = (d.b.h0.w.m) runTask3.getData()) != null) {
            mVar2.m = true;
            mVar2.j = 9;
            mVar2.f51532d = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.mEditor.d(mVar2);
            }
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), d.b.h0.w.m.class);
        if (runTask4 != null && (mVar = (d.b.h0.w.m) runTask4.getData()) != null) {
            mVar.m = true;
            mVar.j = 10;
            mVar.f51532d = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.mEditor.d(mVar);
            }
        }
        if (this.mAdditionData == null) {
            if (this.mWriteTool == null) {
                d.b.i0.u3.n.b bVar = new d.b.i0.u3.n.b(getActivity(), this.mCallFrom);
                this.mWriteTool = bVar;
                bVar.k(0);
                this.mWriteTool.l(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.mWriteTool.i();
                this.mWriteTool.m(WriteActivityConfig.FROM_FORUM_SHARE);
                startDefaultLoacation();
            }
            if (!ListUtils.isEmpty(this.mList)) {
                this.mWriteTool.i();
            }
            this.mEditor.d(this.mWriteTool);
        }
        if (!this.isEvaluate && !"main_tab".equals(this.mFrom)) {
            this.mEditor.d(new d.b.h0.w.d(getActivity(), 10));
        }
        this.mEditor.h(arrayList);
        d.b.h0.w.m n2 = this.mEditor.n(5);
        if (n2 != null) {
            n2.j = 4;
        }
    }

    private void initData(Bundle bundle) {
        WriteData writeData;
        d.b.i0.c3.q0.a f2 = d.b.i0.c3.q0.a.f();
        this.mWriteModel = f2;
        f2.k(this);
        WriteData writeData2 = new WriteData();
        this.mData = writeData2;
        if (bundle != null) {
            writeData2.setType(bundle.getInt("type", 0));
            this.mData.setForumId(bundle.getString("forum_id"));
            this.mData.setForumName(bundle.getString("forum_name"));
            this.mData.setFirstDir(bundle.getString(IntentConfig.FORUM_FIRST_DIR));
            this.mData.setSecondDir(bundle.getString(IntentConfig.FORUM_SECOND_DIR));
            this.mData.setThreadId(bundle.getString("thread_id"));
            this.mData.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(bundle.getInt("floor_num", 0));
            this.mData.setVideoInfo((VideoInfo) bundle.getSerializable(WriteActivityConfig.VIDEO_INFO));
            String string = bundle.getString("addition_data");
            if (!StringUtils.isNull(string)) {
                this.mAdditionData = (AdditionData) OrmObject.objectWithJsonStr(string, AdditionData.class);
            }
            this.mData.setIsAddition(this.mAdditionData != null);
            String string2 = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.mTopicId = string2;
            this.mData.setTopicId(string2);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mData.setStatisticFrom(bundle.getInt(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
            this.isFeedBack = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.showHomepageTestIcon = bundle.getBoolean(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.isVcodeFeedBack = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.mIsReplySubPb = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.mSubUserName = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfoString = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.photoName = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.mFrom = bundle.getString("from");
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mCallFrom = bundle.getString("KEY_CALL_FROM");
            this.isAblumThread = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.mFrsTabList = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.canGoods = bundle.getBoolean(WriteActivityConfig.CAN_GOODS);
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 9));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setFirstDir(intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR));
            this.mData.setSecondDir(intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            AdditionData additionData = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mAdditionData = additionData;
            this.mData.setIsAddition(additionData != null);
            this.mData.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            String stringExtra = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.mTopicId = stringExtra;
            this.mData.setTopicId(stringExtra);
            this.mData.setVideoInfo((VideoInfo) intent.getSerializableExtra(WriteActivityConfig.VIDEO_INFO));
            this.mData.setStatisticFrom(intent.getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
            this.isFeedBack = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.showHomepageTestIcon = intent.getBooleanExtra(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.isVcodeFeedBack = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.mIsReplySubPb = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.mSubUserName = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mMoreForumImg = intent.getStringExtra("more_forum_img");
            this.mMoreForumTitle = intent.getStringExtra("more_forum_title");
            this.mMoreForumUrl = intent.getStringExtra("more_forum_url");
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mCallFrom = intent.getStringExtra("KEY_CALL_FROM");
            this.isAblumThread = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
            this.writeImagesInfoString = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            FrsTabInfoData frsTabInfoData = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.mFrsTabList = frsTabInfoData;
            this.mData.setFrsTabInfoData(frsTabInfoData);
            this.canGoods = intent.getBooleanExtra(WriteActivityConfig.CAN_GOODS, false);
            boolean booleanExtra = getIntent().getBooleanExtra(IntentConfig.IS_EVALUATE, false);
            this.isEvaluate = booleanExtra;
            this.mData.setIsEvaluate(booleanExtra);
            this.isFromItemDetail = getIntent().getBooleanExtra(IntentConfig.IS_ITEM_DETAIL, false);
            this.mIntentStarCount = getIntent().getIntExtra(WriteActivityConfig.STAR_COUNT, 0);
            Serializable serializableExtra = getIntent().getSerializableExtra("item_info");
            if (serializableExtra instanceof SerializableItemInfo) {
                SerializableItemInfo serializableItemInfo = (SerializableItemInfo) serializableExtra;
                this.mIntentItemInfo = serializableItemInfo;
                this.mData.setItem_id(String.valueOf(serializableItemInfo.id));
            }
            this.mItemIsSchool = getIntent().getBooleanExtra("item_is_school", false);
            this.isSaveDraft = getIntent().getBooleanExtra("need_save_draft", true);
            this.fromErrorDialog = getIntent().getBooleanExtra(WriteActivityConfig.IS_FROM_ERROR_DIALOG, false);
            this.mCategoryFromID = getIntent().getIntExtra("category_id", -1);
            this.goodsListStr = getIntent().getStringExtra(WriteActivityConfig.GOODS_LIST);
            this.voteDataSerializable = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
            this.isVoiceEnable = intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true);
            this.mDisableAudioMessage = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            if (this.fromErrorDialog && (writeData = d.b.i0.c3.q0.c.f53585e) != null) {
                this.mData = writeData;
                writeData.setType(9);
                WriteData writeData3 = this.mData;
                writeData3.setContent(writeData3.getContentString());
                this.writeImagesInfo = this.mData.getWriteImagesInfo();
                this.mFrsTabList = this.mData.getFrsTabInfoData();
                if (this.mData.getItemInfo() != null) {
                    this.mIntentItemInfo = null;
                }
                this.mVoiceModel = this.mData.getVoiceModel();
            }
        }
        PostPrefixData postPrefixData = this.mPrefixData;
        if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.mData.getType() == 9) {
            this.mData.setEntranceType(1);
        } else if (this.mData.getType() == 10) {
            this.mData.setEntranceType(2);
            this.mData.setType(9);
        } else if (this.mData.getType() == 0) {
            this.mData.setEntranceType(3);
        }
        this.mData.setIsUserFeedback(this.isFeedBack);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        String str = this.writeImagesInfoString;
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.mData.getType() == 4 ? 6 : 9);
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mBubbleUrl = TbadkCoreApplication.getInst().getDefaultBubble();
        initCategoryData();
        if (this.mData.getType() != 0 && this.mData.getType() != 9 && this.mData.getType() != 11) {
            if (this.mData.getType() == 7) {
                if (this.isSaveDraft) {
                    d.b.i0.c3.y.h(BOTTLE_FORUM_ID, this);
                }
            } else if (this.mData.getType() == 1) {
                d.b.i0.c3.y.i(this.mData.getThreadId(), this);
            } else if (this.mData.getType() == 4) {
                d.b.i0.c3.y.h(this.mData.getForumId() + PHOTO_LIVE_DRAFT_KEY, this);
            } else if (this.mData.getType() == 5) {
                d.b.i0.c3.y.i(this.mData.getThreadId() + UPDATE_PHOTO_LIVE_DRAFT_KEY, this);
            }
        } else if (this.isSaveDraft) {
            if (this.mData.isEvaluate()) {
                d.b.i0.c3.y.g(this.mData.getItem_id(), this);
            } else if (TextUtils.isEmpty(this.mData.getTopicId())) {
                d.b.i0.c3.y.h(this.mData.getForumId(), this);
            } else {
                d.b.i0.c3.y.k(this.mData.getTopicId(), this);
            }
        }
        WriteData writeData4 = this.mData;
        if (writeData4 != null && writeData4.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.isFeedBackBar = true;
        }
        try {
            this.latestPic = getLatestPic();
        } catch (Throwable unused) {
            this.latestPic = null;
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        EditorTools editorTools = new EditorTools(getActivity());
        this.mEditor = editorTools;
        editorTools.setBarMaxLauCount(5);
        this.mEditor.setMoreButtonAtEnd(true);
        this.mEditor.setBarBackgroundColorId(R.color.CAM_X0201);
        this.mEditor.setBarLauncherType(1);
        this.mEditor.C(true);
        this.mEditor.D(false);
        int type = this.mData.getType();
        if (type != 4 && type != 5) {
            initCommonEditorTools();
        } else {
            initPhotoLiveEditorTools();
        }
        this.mEditor.f();
        LinearLayout linearLayout = this.mToolView;
        if (linearLayout != null) {
            linearLayout.addView(this.mEditor);
        }
        initEditorListener();
        this.mEditor.j();
        d.b.h0.w.h m2 = this.mEditor.m(6);
        if (m2 != null && !TextUtils.isEmpty(this.mDisableAudioMessage)) {
            ((View) m2).setOnClickListener(new j());
        }
        if (!this.isLivePhotoType) {
            this.mEditor.A(new d.b.h0.w.a(34, 5, 1));
        }
        this.mEditor.q();
        if (XiaoyingUtil.showXiaoyingTool() && !d.b.h0.r.d0.b.i().g("xiaoying_has_click", false)) {
            this.mEditor.A(new d.b.h0.w.a(2, 19, "N"));
        }
        if (!d.b.h0.r.d0.b.i().g("hot_topic_has_click", false)) {
            this.mEditor.A(new d.b.h0.w.a(2, 26, " "));
        }
        if (d.b.h0.r.d0.b.i().j("commodity_tip_show_controller", 0) == 0 && this.canGoods) {
            showCommodityTip();
            return;
        }
        showEditorTopicTip();
        checkClipboardAndShowNewLinkBubble();
    }

    private void initEditorListener() {
        p pVar = new p();
        this.mEditor.setActionListener(16, pVar);
        this.mEditor.setActionListener(14, pVar);
        this.mEditor.setActionListener(24, pVar);
        this.mEditor.setActionListener(3, pVar);
        this.mEditor.setActionListener(10, pVar);
        this.mEditor.setActionListener(11, pVar);
        this.mEditor.setActionListener(12, pVar);
        this.mEditor.setActionListener(13, pVar);
        this.mEditor.setActionListener(15, pVar);
        this.mEditor.setActionListener(18, pVar);
        this.mEditor.setActionListener(20, pVar);
        this.mEditor.setActionListener(25, pVar);
        this.mEditor.setActionListener(27, pVar);
        this.mEditor.setActionListener(29, pVar);
        this.mEditor.setActionListener(43, pVar);
        this.mEditor.setActionListener(56, pVar);
        this.mEditor.setActionListener(48, pVar);
        this.mEditor.setActionListener(46, pVar);
        this.mEditor.setActionListener(49, pVar);
        this.mEditor.setActionListener(47, pVar);
        this.mEditor.setActionListener(55, pVar);
        this.mEditor.setActionListener(58, pVar);
        this.mEditor.setActionListener(22, pVar);
        this.mEditor.setActionListener(21, pVar);
        this.mEditor.setActionListener(59, pVar);
    }

    private void initForumTabSelected() {
        if (this.isEvaluate) {
            return;
        }
        ForumTabSelectedView forumTabSelectedView = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.mForumTabSelectedView = forumTabSelectedView;
        forumTabSelectedView.setBgColor(R.color.CAM_X0205);
        this.mForumTabSelectedViewDivider = findViewById(R.id.frs_tab__divider);
        this.mForumTabSelectedView.setData(this.mFrsTabList);
        if (this.mForumTabSelectedView.getVisibility() == 0) {
            this.mForumTabSelectedViewDivider.setVisibility(0);
        }
        this.mForumTabSelectedView.setActivity(this);
    }

    private void initGridView() {
        View findViewById = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.live_container = findViewById;
        this.live_post_title_container = findViewById.findViewById(R.id.live_post_title_container);
        this.live_post_content = (EditText) this.live_container.findViewById(R.id.live_post_content);
        this.mPhotoLiveGridView = (GridView) this.live_container.findViewById(R.id.photoLiveGridView);
        this.live_post_title = (EditText) this.live_container.findViewById(R.id.live_post_title);
        this.mTitleOverPlusNumber = (TextView) this.live_container.findViewById(R.id.titleOverPlusNumber);
        this.mContentOverPlusNumber = (TextView) this.live_container.findViewById(R.id.contentOverPlusNumber);
        this.live_interval_view = this.live_container.findViewById(R.id.live_interval_view);
        this.mTitleOverPlusNumber.setText(String.valueOf(20));
        this.mContentOverPlusNumber.setText(String.valueOf((int) CONTENT_MAX_COUNT));
        this.live_container.setVisibility(0);
        this.mTitleOverPlusNumber.setVisibility(0);
        this.mContentOverPlusNumber.setVisibility(0);
        this.live_post_title.setHint(R.string.tips_title_limit_new);
        this.live_post_title.setOnFocusChangeListener(new l());
        if (this.mData.getType() == 4) {
            this.live_post_content.setHint(R.string.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.live_post_content.setHint(R.string.live_write_input_content_update);
        }
        this.live_post_content.setOnFocusChangeListener(new m());
        this.live_post_content.requestFocus();
        this.live_post_content.addTextChangedListener(getTextWatcher());
        this.live_post_title.requestFocus();
        this.live_post_title.addTextChangedListener(getTextWatcher());
        this.live_post_title.setOnClickListener(this.mEditOnClicked);
        this.live_post_content.setOnClickListener(this.mEditOnClicked);
        d.b.i0.u3.u.b.a aVar = new d.b.i0.u3.u.b.a(this, this.writeImagesInfo, this.mPhotoLiveGridView);
        this.mPhotoLiveGridViewAdapter = aVar;
        aVar.n(6);
        this.mPhotoLiveGridView.setAdapter((ListAdapter) this.mPhotoLiveGridViewAdapter);
        View findViewById2 = this.live_container.findViewById(R.id.live_post_content_container);
        findViewById2.bringToFront();
        ((PhotoLiveLinearLayout) findViewById2).setOnChangeLayoutListener(new n());
        readLivePhotoTitleFromDraft();
    }

    private void initLastErrorHandleFromErrorDialog() {
        this.mNavigationBar.postDelayed(this.handleLastError, 500L);
    }

    private void initListView() {
        this.mListView = (ListView) this.mRootView.findViewById(R.id.commodity_list);
        d.b.i0.u3.v.d dVar = new d.b.i0.u3.v.d(getPageContext());
        this.mAdapter = dVar;
        dVar.j(this.mOnItemDeleteListener);
        this.mListView.setAdapter((ListAdapter) this.mAdapter);
        this.mListView.setOnItemClickListener(new u0());
    }

    private void initListener() {
        registerListener(this.mUpdateBubbleListener);
        registerListener(this.openMoreToolListener);
        registerListener(this.mSelectForumListener);
        registerListener(this.mOnSelectLocationListener);
        registerListener(this.mUegValidateListener);
        registerListener(this.mBackgroundListener);
        registerListener(this.mEvaluateRelevanceItemSelectedListener);
    }

    private void initPhotoLiveEditorTools() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.mEditor.h(arrayList);
        d.b.h0.w.m n2 = this.mEditor.n(5);
        if (n2 != null) {
            n2.j = 2;
        }
        this.mEditor.d(new d.b.h0.w.o.a(getActivity(), 3));
        this.mEditor.d(new d.b.h0.w.r.b(getActivity(), 6));
    }

    private void initPostTopic() {
        PostTopicData postTopicData;
        WriteData writeData = this.mData;
        if (writeData == null || writeData.getType() != 0 || this.mData.getType() != 9 || this.isFeedBack || this.isFeedBackBar || (postTopicData = this.mPostTopicData) == null || StringUtils.isNull(postTopicData.getTitleTopic())) {
            return;
        }
        String cutStringWithSuffix = StringHelper.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
        if (StringUtils.isNull(cutStringWithSuffix) || getRealTitleInstance() == null) {
            return;
        }
        getRealTitleInstance().setText(cutStringWithSuffix);
        getRealTitleInstance().setSelection(cutStringWithSuffix.length());
    }

    private void initPrefix() {
        this.post_prefix_layout = findViewById(R.id.post_prefix_layout);
        if (this.mPiefixTipController == null) {
            d.b.i0.b0.e eVar = new d.b.i0.b0.e(getPageContext(), this.post_prefix_layout);
            this.mPiefixTipController = eVar;
            eVar.c0(R.drawable.bg_tip_blue_up_left);
            this.mPiefixTipController.N(16);
            this.mPiefixTipController.T(true);
            this.mPiefixTipController.d0(true);
            this.mPiefixTipController.f0(d.b.b.e.p.l.g(getActivity(), R.dimen.ds32));
        }
        this.mPrefix = (TextView) findViewById(R.id.post_prefix);
        this.prefix_divider = findViewById(R.id.prefix_divider);
        this.mPrefixIcon = (ImageView) findViewById(R.id.prefix_icon);
        initPrefixData();
    }

    private void initPrefixData() {
        PostPrefixData postPrefixData = this.mPrefixData;
        if (postPrefixData != null && postPrefixData.getPrefixs().size() > 1) {
            this.post_prefix_layout.setVisibility(0);
            this.prefix_divider.setVisibility(0);
            this.mPiefixTipController.j0(getString(R.string.write_title_prefix_tip), WRITE_TITLE_PREFIX_TIP_KEY, true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.mCurrPrefixPos = 0;
            this.post_prefix_layout.setOnClickListener(new k0());
            this.mPrefix.setOnClickListener(new l0());
            d.b.i0.u3.i iVar = new d.b.i0.u3.i(getPageContext().getPageActivity());
            this.mPrefixWindow = iVar;
            iVar.e(this);
            this.mPrefixWindow.d(d.b.b.e.p.l.g(getActivity(), R.dimen.ds510));
            this.mPrefixWindow.setOutsideTouchable(true);
            this.mPrefixWindow.setFocusable(true);
            this.mPrefixWindow.setOnDismissListener(this);
            this.mPrefixWindow.setBackgroundDrawable(SkinManager.getDrawable(R.color.CAM_X0201));
            int color = SkinManager.getColor(R.color.CAM_X0105);
            SkinManager.getColor(R.color.CAM_X0108);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mPrefixIcon, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
            d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.mPrefix);
            a2.n(R.color.CAM_X0105);
            a2.s(R.string.F_X02);
            a2.c(R.color.CAM_X0201);
            this.mPrefixItems.clear();
            for (int i2 = 0; i2 < size; i2++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.mPrefixItems.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i2));
                int i3 = size - 1;
                if (i2 == i3) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.c(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.c(false);
                }
                if (i2 != i3) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.mPrefixWindow.a(writePrefixItemLayout);
            }
            this.mPrefixWindow.c(0);
            this.mPrefix.setText(prefixs.get(0));
            resetCheckImgState(0);
            return;
        }
        this.post_prefix_layout.setVisibility(8);
        this.prefix_divider.setVisibility(8);
    }

    private void initProductData() {
        parseProductData(this.goodsListStr);
    }

    private void initProductTieProtocol() {
        this.mProtocol = (LinearLayout) this.mRootView.findViewById(R.id.protocol);
        this.mProtocolTag = (ImageView) this.mRootView.findViewById(R.id.protocol_tag);
        TextView textView = (TextView) this.mRootView.findViewById(R.id.protocol_info);
        this.mProtocolInfo = textView;
        SkinManager.setViewTextColor(textView, R.color.CAM_X0107);
        EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this, EBusinessProtocolView.WindowType.PROTOCOL);
        this.mEBusinessProtocolView = eBusinessProtocolView;
        eBusinessProtocolView.o(getResources().getString(R.string.protocol_title));
        this.mEBusinessProtocolView.i(PATH_PROTOCOL);
        SpannableString spannableString = new SpannableString(getResources().getString(R.string.readed_protocol));
        spannableString.setSpan(new c0(), 6, 17, 34);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), 6, 17, 34);
        this.mProtocolInfo.setText(spannableString);
        this.mProtocolInfo.setMovementMethod(LinkMovementMethod.getInstance());
        this.mProtocolTag.setOnClickListener(new d0());
        d.b.h0.r.d0.b i2 = d.b.h0.r.d0.b.i();
        if (i2.g(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false)) {
            this.isAgreedProtocol = true;
            this.mProtocolTag.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_mask_use_check16, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        } else {
            this.isAgreedProtocol = false;
            this.mProtocolTag.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_use_uncheck16, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
        }
        this.mEBusinessProtocolView.m(new e0());
    }

    private void initProfession() {
        WriteData writeData;
        if (this.mName == null || (writeData = this.mData) == null || writeData.getProZone() != 1) {
            return;
        }
        this.mName.setText(R.string.write_zone_profession_title);
    }

    private void initPublishProductGuide() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
        this.originalMargin = layoutParams.rightMargin;
        layoutParams.rightMargin = 0;
        this.mName.setLayoutParams(layoutParams);
        ImageView imageView = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.mGuide = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_creation_question16, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
        int g2 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int g3 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds47);
        this.mGuide.setPadding(g2, g2, g2, g2);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mGuide.getLayoutParams();
        int i2 = g3 + g2 + g2;
        layoutParams2.width = i2;
        layoutParams2.height = i2;
        this.mGuide.setLayoutParams(layoutParams2);
        this.mGuide.setOnClickListener(new f0());
        this.mGuide.setVisibility(0);
    }

    private void initRecBubble() {
        if (this.latestPic != null && this.mData.getType() == 0 && this.mData.getType() == 9 && this.mData.getType() == 11) {
            getDimension(getActivity());
            View inflate = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.mBubbleView = inflate;
            inflate.setOnClickListener(new a1());
            this.mRecImgView = (TbImageView) this.mBubbleView.findViewById(R.id.rec_img_view);
            this.mBubbleLayout = (LinearLayout) this.mBubbleView.findViewById(R.id.rec_bubble_layout);
            if (d.b.h0.r.d0.b.i().o("write_rec_pic_path", "").equalsIgnoreCase(this.latestPic.getAbsolutePath())) {
                return;
            }
            d.b.h0.r.d0.b.i().w("write_rec_pic_path", this.latestPic.getAbsolutePath());
            Bitmap previewImg = getPreviewImg(this.latestPic.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
            if (previewImg != null) {
                this.mRecImgView.setImageBitmap(previewImg);
                this.mRecImgView.setDrawBorder(true);
                this.mRecImgView.setBorderWidth(2);
                this.mRecImgView.setBorderColor(SkinManager.getColor(R.color.common_color_10264));
                Dialog dialog = new Dialog(getActivity(), R.style.bubble_dialog);
                this.mRecDialog = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.mRecDialog.setOnDismissListener(new b1());
                this.mRecDialog.setContentView(this.mBubbleView);
                this.mRecDialog.show();
                Window window = this.mRecDialog.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                window.setGravity(83);
                attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                attributes.y = (SCREEN_HEIGHT / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
                attributes.width = getResources().getDimensionPixelSize(R.dimen.ds168);
                attributes.height = getResources().getDimensionPixelSize(R.dimen.ds278);
                window.setAttributes(attributes);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSelectForumData(d.b.h0.t.i iVar) {
        if (iVar == null) {
            return;
        }
        this.mSelectForumData = iVar;
        WriteData writeData = this.mData;
        if (writeData != null) {
            writeData.setForumId(iVar.f51470a);
            this.mData.setForumName(this.mSelectForumData.f51472c);
        }
        this.mForumSelectedView.setSelectedForum(this.mSelectForumData.f51472c);
        this.mFrsTabList = null;
        if (!ListUtils.isEmpty(this.mSelectForumData.f51477h)) {
            FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
            this.mFrsTabList = frsTabInfoData;
            frsTabInfoData.selectedTabId = -1;
            d.b.h0.t.i iVar2 = this.mSelectForumData;
            List<FrsTabItemData> list = iVar2.f51477h;
            frsTabInfoData.tabList = list;
            if (iVar2.j && list != null) {
                FrsTabItemData frsTabItemData = new FrsTabItemData();
                frsTabItemData.tabId = 505;
                frsTabItemData.name = "官方";
                this.mFrsTabList.tabList.add(0, frsTabItemData);
            }
            this.mFrsTabList.isForumBusinessAccount = this.mSelectForumData.j;
        }
        this.mForumTabSelectedView.setData(this.mFrsTabList);
        WriteData writeData2 = this.mData;
        if (writeData2 != null) {
            writeData2.setFrsTabInfoData(this.mFrsTabList);
        }
        if (this.mForumTabSelectedView.getVisibility() == 0) {
            this.mForumTabSelectedViewDivider.setVisibility(0);
        }
        this.mPrefixData = null;
        PostPrefixData postPrefixData = this.mSelectForumData.i;
        if (postPrefixData != null && !ListUtils.isEmpty(postPrefixData.getPrefixs())) {
            PostPrefixData postPrefixData2 = this.mSelectForumData.i;
            this.mPrefixData = postPrefixData2;
            postPrefixData2.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        initPrefixData();
    }

    private void initSelectForumView() {
        if (!"main_tab".equals(this.mFrom) || this.fromErrorDialog) {
            return;
        }
        ForumSelectedView forumSelectedView = (ForumSelectedView) findViewById(R.id.write_select_forum_view);
        this.mForumSelectedView = forumSelectedView;
        forumSelectedView.setVisibility(0);
    }

    private void initTopicDataInView() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) ListUtils.getItem(this.mList, 0);
        if (hotTopicBussinessData == null || TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            return;
        }
        this.mPostTitle.setText(d.b.h0.p0.b.j(d.b.h0.p0.b.a(hotTopicBussinessData.mTopicName)));
        this.mPostTitle.setMovementMethod(d.b.i0.t3.c.a());
    }

    private void initUI() {
        View view;
        this.mLoadingDialog = new d.b.h0.r.f0.a(getPageContext());
        this.isLivePhotoType = this.mData.getType() == 4 || 5 == this.mData.getType();
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        this.mRootView = inflate;
        setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle("");
        this.mName = centerTextTitle;
        SkinManager.setViewTextColor(centerTextTitle, R.color.CAM_X0105);
        this.btn_image_problem = (TextView) findViewById(R.id.btn_image_problem);
        setPostView();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = d.b.b.e.p.l.g(getPageContext().getPageActivity(), R.dimen.tbds2);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.mFocusChangeListener);
        ScrollView scrollView = (ScrollView) findViewById(R.id.write_scrollview);
        this.write_scrollview = scrollView;
        scrollView.setOnTouchListener(new u());
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mTopListView = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.feedback_divider = findViewById(R.id.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(R.id.parent);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.tool_view);
        this.mToolView = linearLayout;
        linearLayout.setContentDescription(IStringUtil.TOP_PATH);
        this.mTitleView = (LinearLayout) findViewById(R.id.title_view);
        this.imageGridView = (WriteImageGridView) findViewById(R.id.write_image_grid_view);
        this.mTitleViewDivider = findViewById(R.id.title_view_divider);
        this.mInterval = findViewById(R.id.interval_view);
        this.mHotTopicEdt = (TextView) findViewById(R.id.hot_topic_title_edt);
        initializePostTitle();
        if (this.isLivePhotoType) {
            this.write_scrollview.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            initGridView();
        } else {
            this.mWriteImageController = new d.b.i0.u3.v.i(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.mWriteImageController.g(false);
            } else {
                this.mWriteImageController.g(this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 11);
            }
            this.writeVideoController = new d.b.i0.u3.v.o.a(getPageContext(), this.mRootView);
            if (this.mData.getVideoInfo() != null && this.mData.getVideoInfo().isEditVideoDataLegal()) {
                showPicOrVideo(false, false);
                this.writeVideoController.v();
            } else {
                showPicOrVideo(true, false);
            }
        }
        initializePostContent();
        if (this.isFeedBack || this.isFeedBackBar) {
            getWindow().setSoftInputMode(18);
            if (ICDNIPDirectConnect.getInstance() != null) {
                if (!ICDNIPDirectConnect.getInstance().isAlreadyInit) {
                    ICDNIPDirectConnect.getInstance().init();
                }
                if (ICDNIPDirectConnect.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.post_content_container);
        this.mPostContentContainer = linearLayout2;
        linearLayout2.setDrawingCacheEnabled(false);
        this.mPostContentContainer.setOnClickListener(new w());
        this.mLayoutVoicePlay = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.mVoicePlayButton = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        ImageView imageView = (ImageView) findViewById(R.id.iv_delete_voice);
        this.mIvDeleteVoice = imageView;
        imageView.setOnClickListener(new x());
        addVoice(this.mVoiceModel);
        this.mBack.setOnFocusChangeListener(this.mFocusChangeListener);
        this.mBack.setOnClickListener(new y());
        this.btn_image_problem.setOnClickListener(new z());
        initCategoryUI();
        setAudioEnableStatus(isEnableAudio());
        intializePostButton();
        updataTitle();
        initializeRecordVoice();
        changeToolButtonStatus();
        initAddition();
        initPrefix();
        initTopicDataInView();
        if (this.mData.getType() == 4 && (view = this.post_prefix_layout) != null && this.prefix_divider != null) {
            view.setVisibility(8);
            this.prefix_divider.setVisibility(8);
        }
        refreshPostButton();
        updateGroup();
        initProfession();
        initSelectForumView();
        initForumTabSelected();
        initWriteEvaluationUI();
        initWriteEvaluationHeaderView();
        initVoteView();
        initProductTieProtocol();
        initListView();
    }

    private void initVoteView() {
        this.mVoteLayoutRoot = (RelativeLayout) this.mRootView.findViewById(R.id.vote_layout_root);
        this.mVoteViewController = new d.b.i0.u3.v.p.a(getPageContext(), this.mVoteLayoutRoot);
        showVoteView();
    }

    private void initWriteEvaluationHeaderView() {
        if (this.isEvaluate) {
            this.mWriteEvaluationeHeaderView.setVisibility(0);
            if (this.mItemIsSchool) {
                return;
            }
            if (this.isFromItemDetail) {
                this.mWriteEvaluationeHeaderView.setShowItemInfo(false);
            }
            if (this.mIntentItemInfo != null) {
                TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
                tbRichTextEvaluateItemInfo.setItemID(String.valueOf(this.mIntentItemInfo.id));
                tbRichTextEvaluateItemInfo.setTags(this.mIntentItemInfo.tags);
                tbRichTextEvaluateItemInfo.setScore(this.mIntentItemInfo.averageScore);
                tbRichTextEvaluateItemInfo.setStar(getStarByScore(this.mIntentItemInfo.averageScore));
                tbRichTextEvaluateItemInfo.setIconUrl(this.mIntentItemInfo.icon_url);
                tbRichTextEvaluateItemInfo.setIconSize(this.mIntentItemInfo.icon_size);
                tbRichTextEvaluateItemInfo.setTitle(this.mIntentItemInfo.name);
                this.mWriteEvaluationeHeaderView.setItemInfo(tbRichTextEvaluateItemInfo);
                this.mWriteEvaluationeHeaderView.setStarCount(this.mIntentStarCount);
                this.mData.setItemInfo(tbRichTextEvaluateItemInfo);
                this.mData.setEvaluationStar(this.mIntentStarCount);
            } else if (this.mData.getItemInfo() != null) {
                this.mWriteEvaluationeHeaderView.setItemInfo(this.mData.getItemInfo());
                this.mWriteEvaluationeHeaderView.setStarCount(this.mData.getEvaluationStar());
            }
        }
    }

    private void initWriteEvaluationUI() {
        if (this.isEvaluate) {
            this.mPostContentCounter = (TextView) findViewById(R.id.post_content_counter);
            WriteEvaluationHeaderView writeEvaluationHeaderView = (WriteEvaluationHeaderView) findViewById(R.id.write_evaluation_header_view);
            this.mWriteEvaluationeHeaderView = writeEvaluationHeaderView;
            writeEvaluationHeaderView.setStarChangeListener(new a0());
            this.mWriteEvaluationeHeaderView.setItemCloseListener(new b0());
        }
    }

    private void initializeRecordVoice() {
        getVoiceManager().onCreate(getPageContext());
    }

    private Boolean isEnableAudio() {
        return Boolean.valueOf(this.isVoiceEnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTextFull() {
        return getRealContentEdittextInstance().getText() != null && getRealContentEdittextInstance().getText().length() >= (this.mAdditionData != null ? 1000 : 5000);
    }

    private boolean isValidLiveContent(EditText editText) {
        long inputCount = getInputCount(editText);
        if (inputCount > 233) {
            return false;
        }
        return inputCount > 0 || this.writeImagesInfo.size() >= 1;
    }

    private boolean isValidLiveTitle(EditText editText) {
        long inputCount = getInputCount(editText);
        return inputCount <= 20 && inputCount > 0;
    }

    private void jumpToAlbumActivity(int i2) {
        if (this.writeImagesInfo == null || this.mData == null) {
            return;
        }
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
        albumFloatActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
        albumFloatActivityConfig.getIntent().putExtra("from", this.mFrom);
        albumFloatActivityConfig.setRequestCode(PlayerPostEvent.MEDIA_REP_CHANGE_END);
        albumFloatActivityConfig.setAlbumThread(i2);
        albumFloatActivityConfig.setCanSelectVideo(canSelectVideo());
        albumFloatActivityConfig.setFromWrite(true);
        albumFloatActivityConfig.setCallFrom(this.mCallFrom);
        albumFloatActivityConfig.setStatisticFrom(this.mData.getStatisticFrom());
        albumFloatActivityConfig.setProfessionZone(this.mData.getProZone());
        albumFloatActivityConfig.setFrsTabInfo(this.mFrsTabList);
        AntiData antiData = new AntiData();
        antiData.voice_message = this.mDisableAudioMessage;
        antiData.setIfVoice(this.isVoiceEnable);
        albumFloatActivityConfig.setExtraData(antiData, this.mPrefixData, this.mData.getFirstDir(), this.mData.getSecondDir());
        sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToEditImageActivity(int i2) {
        int size;
        WriteImagesInfo writeImagesInfo = this.writeImagesInfo;
        if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i2 >= 0 && i2 < size) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, i2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToVoteView(WriteVoteData writeVoteData) {
        WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(getPageContext().getPageActivity(), 25048);
        if (writeVoteData != null) {
            writeVoteActivityConfig.setExtraData(writeVoteData);
        }
        sendMessage(new CustomMessage(2002001, writeVoteActivityConfig));
    }

    private void loadDraftImageForPhotoLive() {
        if ((this.isLivePhotoType && this.mPhotoLiveGridViewAdapter == null) || this.mPhotoLiveGridView == null) {
            return;
        }
        this.mPhotoLiveGridViewAdapter.l(this.writeImagesInfo);
        updateGridView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseProductData(String str) {
        this.mGoodsDatas = new ArrayList();
        ArrayList arrayList = new ArrayList();
        if (StringUtils.isNull(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                arrayList.add(string);
                this.mGoodsDatas.add(d.b.i0.v0.a.g(jSONObject));
            }
            if (this.mGoodsDatas.size() > 0) {
                this.isProductTie = true;
                this.mPostContent.e(this.mGoodsDatas, arrayList);
                initPublishProductGuide();
                refreshListView();
                this.mProtocol.setVisibility(0);
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performHotTopicClick(boolean z2) {
        if (d.b.h0.p0.b.b(getPageContext())) {
            return;
        }
        HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
        WriteData writeData = this.mData;
        if (writeData != null) {
            hotSelectActivityConfig.setForumExtra(d.b.b.e.m.b.f(writeData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
        }
        sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void popupSaveDraftDialog() {
        WriteData writeData;
        d.b.i0.u3.v.o.a aVar;
        TextView textView = this.mPost;
        if (textView != null && ((textView.isEnabled() || this.isEvaluate) && ((!this.isEvaluate || !TextUtils.isEmpty(this.mPostContent.getText()) || ((this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() != 0) || ((aVar = this.writeVideoController) != null && aVar.n()))) && this.isSaveDraft))) {
            if (this.saveDraftDialogView == null) {
                this.saveDraftDialogView = new SaveDraftDialogView(this);
                this.saveDraftDialogView.setOnClickListener(new r());
            }
            if (this.saveDraftDialog == null) {
                d.b.h0.r.s.j jVar = new d.b.h0.r.s.j(getPageContext());
                this.saveDraftDialog = jVar;
                jVar.setContentView(this.saveDraftDialogView);
            }
            d.b.i0.u3.v.o.a aVar2 = this.writeVideoController;
            boolean z2 = (aVar2 == null || !aVar2.n() || (writeData = this.mData) == null || writeData.getVideoInfo() == null || this.mData.getVideoInfo().isVideoMixFinished()) ? false : true;
            this.saveDraftDialogView.setText(getString(z2 ? R.string.write_save_draft_dialog_video_fail_title : R.string.write_save_draft_dialog_normal_title), z2 ? getString(R.string.write_save_draft_dialog_video_fail_sub_title) : null, getString(z2 ? R.string.write_save_draft_dialog_video_fail_save_text : R.string.save));
            this.saveDraftDialog.l();
            return;
        }
        clearDraft();
        deleteTempVideoFile();
        setResult(100);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postNewMessage() {
        HotTopicBussinessData hotTopicBussinessData;
        stopTask();
        this.mData.setContent(getContent());
        processTitleForPost(getThreadTitle());
        if (this.isFeedBack || this.isFeedBackBar) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                processTitleForPost(string + this.mData.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.mData.getContent()) || !this.mData.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(Build.VERSION.RELEASE);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(Build.MODEL);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                if (d.b.b.e.p.j.z()) {
                    sb.append(d.b.b.e.p.j.K());
                } else {
                    sb.append(RomUtils.UNKNOWN);
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.showHomepageTestIcon) {
            this.mData.setZhongcePrefix(String.format(getResources().getString(R.string.homepage_test_post_suffix), Build.MODEL, TbadkCoreApplication.getInst().getVersionName(), d.b.b.e.p.j.K(), Build.VERSION.RELEASE));
        }
        int i2 = this.mCategoryFromID;
        if (i2 >= 0) {
            this.mData.setCategoryFrom(i2);
        }
        int i3 = this.mCategoryToID;
        if (i3 >= 0) {
            this.mData.setCategoryTo(i3);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        d.b.i0.u3.v.p.a aVar = this.mVoteViewController;
        if (aVar != null) {
            this.mData.setWriteVoteData(aVar.c());
        }
        WriteImagesInfo writeImagesInfo = this.writeImagesInfo;
        if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
            Iterator<ImageFileInfo> it = this.writeImagesInfo.getChosedFiles().iterator();
            int i4 = 0;
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.isFromCamera()) {
                    i4++;
                }
            }
            this.mData.setTakePhotoNum(i4);
        }
        WriteData writeData = this.mData;
        LocationModel locationModel = this.mLocationModel;
        writeData.setHasLocationData(locationModel != null && locationModel.v());
        WriteImagesInfo writeImagesInfo2 = this.writeImagesInfo;
        if (writeImagesInfo2 != null) {
            this.mWriteModel.p(writeImagesInfo2.size() > 0);
        }
        if (!ListUtils.isEmpty(this.mList) && (hotTopicBussinessData = this.mCurrHotData) != null && hotTopicBussinessData.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(hotTopicBussinessData.mForumId));
            this.mData.setForumName(this.mCurrHotData.mForumName);
        }
        WriteEvaluationHeaderView writeEvaluationHeaderView = this.mWriteEvaluationeHeaderView;
        if (writeEvaluationHeaderView != null && writeEvaluationHeaderView.getEvaluateItemInfo() != null) {
            this.mData.setItem_id(this.mWriteEvaluationeHeaderView.getEvaluateItemInfo().getItemID());
            this.mData.setComment_head(getCommonHead());
        }
        addTabInfoForPostWriteIfNeed();
        this.mWriteModel.u(this.mData);
        WriteData writeData2 = this.mData;
        writeData2.setContent(writeData2.getContent().replaceAll("\u0000\n", ""));
        WriteData writeData3 = this.mData;
        writeData3.setContent(writeData3.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.mData.setVoiceModel(this.mVoiceModel);
        VoiceData$VoiceModel voiceData$VoiceModel = this.mVoiceModel;
        if (voiceData$VoiceModel != null) {
            if (voiceData$VoiceModel.getId() != null) {
                this.mWriteModel.j().setVoice(this.mVoiceModel.getId());
                this.mWriteModel.j().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.mWriteModel.j().setVoice(null);
                this.mWriteModel.j().setVoiceDuringTime(-1);
            }
        } else {
            this.mWriteModel.j().setVoice(null);
            this.mWriteModel.j().setVoiceDuringTime(-1);
        }
        if (!this.mWriteModel.b()) {
            showToast(R.string.write_img_limit);
        } else if (!d.b.b.e.p.j.z()) {
            showToast(R.string.neterror);
        } else {
            startAsyncPostWrite();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postPhotoTextThread() {
        if ("1".equals(this.mCallFrom)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.mCallFrom)) {
            this.mData.setCanNoForum(false);
        }
        requestPrivacyStateAction();
        this.mData.setPrivacy(this.isPrivacy);
        requestToDynamicStateAction();
        this.mData.setToDynamic(this.isToDynamic);
        this.mData.setCallFrom(this.mCallFrom);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        postNewMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processSaveDraft() {
        WriteData writeData = this.mData;
        if (writeData != null && writeData.getType() == 2 && this.mIsReplySubPb) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.mData.setTitle(getRealTitleInstance().getText().toString());
            this.mData.setContent(getRealContentEdittextInstance().getText().toString());
            WriteEvaluationHeaderView writeEvaluationHeaderView = this.mWriteEvaluationeHeaderView;
            if (writeEvaluationHeaderView != null) {
                this.mData.setEvaluationStar(writeEvaluationHeaderView.getStarCount());
            }
            int type = this.mData.getType();
            if (type == 0 || type == 9 || type == 11) {
                if (this.isSaveDraft) {
                    if (this.mData.isEvaluate()) {
                        d.b.i0.c3.y.m(this.mData.getItem_id(), this.mData);
                    } else if (TextUtils.isEmpty(this.mData.getTopicId())) {
                        d.b.i0.c3.y.n(this.mData.getForumId(), this.mData);
                    } else {
                        d.b.i0.c3.y.r(this.mData.getTopicId(), this.mData);
                    }
                }
            } else if (type == 7) {
                if (this.isSaveDraft) {
                    d.b.i0.c3.y.n(BOTTLE_FORUM_ID, this.mData);
                }
            } else if (type == 1) {
                d.b.i0.c3.y.p(this.mData.getThreadId(), this.mData);
            } else if (type == 4) {
                d.b.i0.c3.y.n(this.mData.getForumId() + PHOTO_LIVE_DRAFT_KEY, this.mData);
            } else if (type == 5) {
                d.b.i0.c3.y.p(this.mData.getThreadId() + UPDATE_PHOTO_LIVE_DRAFT_KEY, this.mData);
            }
            this.isProcessedSaveDraft = true;
        }
    }

    private void processTitleForPost(String str) {
        LinearLayout linearLayout;
        if (this.mData == null || (linearLayout = this.mTitleView) == null) {
            return;
        }
        if (linearLayout.getVisibility() == 0) {
            if (StringUtils.isNull(str)) {
                this.mData.setIsNoTitle(true);
                this.mData.setTitle("");
                return;
            }
            this.mData.setIsNoTitle(false);
            this.mData.setTitle(str);
            return;
        }
        this.mData.setIsNoTitle(true);
        this.mData.setTitle("");
    }

    private void readLivePhotoTitleFromDraft() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.live_post_title.setText(this.mData.getTitle());
                this.live_post_title.setSelection(this.mData.getTitle().length());
            }
        } else if (this.mData.getType() != 1) {
            this.mData.getType();
        }
    }

    private void realInsert(SpannableStringBuilder spannableStringBuilder, int i2, d.b.b.j.d.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder == null || getRealContentEdittextInstance() == null || getRealContentEdittextInstance().getText() == null) {
            return;
        }
        Bitmap p2 = aVar.p();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(p2);
        int width = p2.getWidth();
        if (emotionGroupType != EmotionGroupType.USER_COLLECT && emotionGroupType != EmotionGroupType.BIG_EMOTION) {
            if (emotionGroupType == EmotionGroupType.LOCAL) {
                double d2 = width;
                Double.isNaN(d2);
                width = (int) (d2 * 0.5d);
            }
            bitmapDrawable.setBounds(0, 0, width, width);
        } else {
            bitmapDrawable.setBounds(0, 0, width, p2.getHeight());
        }
        bitmapDrawable.setGravity(119);
        spannableStringBuilder.setSpan(new d.b.h0.r.f0.e(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
        if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
            int selectionStart = getRealContentEdittextInstance().getSelectionStart() - 1;
            if (getRealContentEdittextInstance().getText().length() > 1 && selectionStart >= 0 && getRealContentEdittextInstance().getText().charAt(selectionStart) != '\n') {
                SpannableString spannableString = new SpannableString("\u0000\n");
                getRealContentEdittextInstance().getText().insert(getRealContentEdittextInstance().getSelectionStart(), spannableString);
                i2 += spannableString.length();
            }
        }
        getRealContentEdittextInstance().getText().insert(i2, spannableStringBuilder);
        SpannableString spannableString2 = null;
        if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
            spannableString2 = new SpannableString("\u0000\n");
            getRealContentEdittextInstance().getText().insert(getRealContentEdittextInstance().getSelectionStart(), spannableString2);
        }
        Editable text = getRealContentEdittextInstance().getText();
        if (text != null) {
            this.mContentBuilder.clear();
            this.mContentBuilder.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.mContentBuilder);
            if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && getRealContentEdittextInstance().length() > spannableStringBuilder.length() + i2 + spannableString2.length()) {
                getRealContentEdittextInstance().setSelection(i2 + spannableStringBuilder.length() + spannableString2.length());
            } else {
                getRealContentEdittextInstance().setSelection(i2 + spannableStringBuilder.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void refreshBubble(boolean z2) {
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) || this.isLivePhotoType || getRealContentEdittextInstance() == null) {
            return;
        }
        getRealContentEdittextInstance().setPadding(0, 0, 0, 0);
        getRealContentEdittextInstance().setBackgroundDrawable(null);
        SkinManager.setBackgroundColor(getRealContentEdittextInstance(), R.color.CAM_X0201);
        if (TextUtils.isEmpty(this.mBubbleUrl) || this.mAdditionData != null) {
            return;
        }
        d.b.i0.u3.v.o.a aVar = this.writeVideoController;
        if (aVar == null || !aVar.n()) {
            d.b.b.e.l.d.h().m(this.mBubbleUrl, 19, new s0(z2), getUniqueId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshMutiImage(boolean z2) {
        WriteData writeData = this.mData;
        String forumId = writeData == null ? "" : writeData.getForumId();
        d.b.i0.u3.v.i iVar = this.mWriteImageController;
        if (iVar != null) {
            iVar.h(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    private void refreshPostStatus(Editable editable) {
        if (!TextUtils.isEmpty(editable) && editable.length() >= 20 && editable.length() <= 500 && this.mWriteEvaluationeHeaderView.e()) {
            this.mPost.setEnabled(true);
        } else {
            this.mPost.setEnabled(false);
        }
    }

    private void registerVideoPostClickUserCollectionToastTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921500, new f1());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void removeLastFunctionPhoto() {
        ImageFileInfo imageFileInfo;
        WriteImagesInfo writeImagesInfo = this.writeImagesInfo;
        if (writeImagesInfo == null || writeImagesInfo.getChosedFiles() == null || this.writeImagesInfo.size() <= 0 || (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) == null || TextUtils.isEmpty(imageFileInfo.getFilePath()) || !imageFileInfo.getFilePath().startsWith("android.resource://")) {
            return;
        }
        this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestLocationIfValid() {
        if (this.mLocationModel.v()) {
            if (this.mLocationModel.z()) {
                sendLocaionAction(2, true, d.b.i0.c3.m0.b.a().b().getFormatted_address());
                return;
            }
            sendLocaionAction(1, true, null);
            this.mLocationModel.D();
            return;
        }
        sendLocaionAction(0, true, null);
    }

    private void requestPrivacyStateAction() {
        EditorTools editorTools = this.mEditor;
        if (editorTools != null) {
            editorTools.A(new d.b.h0.w.a(54, 15, null));
        }
    }

    private void requestToDynamicStateAction() {
        EditorTools editorTools = this.mEditor;
        if (editorTools != null) {
            editorTools.A(new d.b.h0.w.a(57, 15, null));
        }
    }

    private void resetCheckImgState(int i2) {
        if (i2 >= this.mPrefixItems.size()) {
            return;
        }
        for (int i3 = 0; i3 < this.mPrefixItems.size(); i3++) {
            this.mPrefixItems.get(i3).b(false);
        }
        this.mPrefixItems.get(i2).b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFinishSendAction(boolean z2) {
        EditorTools editorTools = this.mEditor;
        if (editorTools != null) {
            editorTools.A(new d.b.h0.w.a(9, -1, Boolean.valueOf(z2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLocaionAction(int i2, boolean z2, String str) {
        this.mLocationState = i2;
        EditorTools editorTools = this.mEditor;
        if (editorTools != null) {
            editorTools.A(new d.b.h0.w.a(19, 15, new d.b.h0.w.u.a(i2, z2, str)));
        }
    }

    private void sendSetImgAction() {
        if (this.isLivePhotoType) {
            return;
        }
        EditorTools editorTools = this.mEditor;
        if (editorTools != null) {
            editorTools.A(new d.b.h0.w.a(12, -1, new d.b.h0.w.r.a(this.writeImagesInfo, true)));
            this.mEditor.A(new d.b.h0.w.a(12, 11, new d.b.h0.w.r.a(this.writeImagesInfo, true)));
        }
        WriteData writeData = this.mData;
        String forumId = writeData == null ? "" : writeData.getForumId();
        d.b.i0.u3.v.i iVar = this.mWriteImageController;
        if (iVar != null) {
            iVar.h(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUpdatePhotoLiveMessage(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.mFrom)) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUCCES_IN_MISSON);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
    }

    private void setAudioEnableStatus(Boolean bool) {
        WriteData writeData = this.mData;
        if (getPageContext().getString(R.string.feedback_bar_name).equals(writeData != null ? writeData.getForumName() : null)) {
            this.isFeedBack = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLeftCount(TextView textView, EditText editText) {
        if (textView == null || editText == null) {
            return;
        }
        long maxInpputNum = getMaxInpputNum(editText);
        long inputCount = maxInpputNum - getInputCount(editText);
        String valueOf = String.valueOf(inputCount);
        if (maxInpputNum == 20) {
            if (inputCount < 0) {
                if (inputCount < -9) {
                    valueOf = "-∞";
                }
                textView.setTextColor(SkinManager.getColor(R.color.common_color_10159));
            } else {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            }
        } else if (inputCount < 0) {
            if (inputCount < -99) {
                valueOf = "-∞";
            }
            textView.setTextColor(SkinManager.getColor(R.color.common_color_10159));
        } else {
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
        }
        textView.setText(valueOf);
    }

    private void setPostView() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProtocolVisibility(List<d.b.h0.r.q.v> list) {
        LinearLayout linearLayout;
        if (list == null) {
            return;
        }
        boolean z2 = false;
        Iterator<d.b.h0.r.q.v> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().f50897f == 2) {
                z2 = true;
                break;
            }
        }
        if (z2 || (linearLayout = this.mProtocol) == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupRelevanceItemSelected(EvaluateRelevanceItemSelectedMessage evaluateRelevanceItemSelectedMessage) {
        this.mWriteEvaluationeHeaderView.setVisibility(0);
        TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
        tbRichTextEvaluateItemInfo.setItemID(evaluateRelevanceItemSelectedMessage.item_id);
        tbRichTextEvaluateItemInfo.setTags(evaluateRelevanceItemSelectedMessage.tags);
        tbRichTextEvaluateItemInfo.setScore(evaluateRelevanceItemSelectedMessage.score);
        tbRichTextEvaluateItemInfo.setStar(evaluateRelevanceItemSelectedMessage.star);
        tbRichTextEvaluateItemInfo.setIconUrl(evaluateRelevanceItemSelectedMessage.icon_url);
        tbRichTextEvaluateItemInfo.setIconSize(evaluateRelevanceItemSelectedMessage.icon_size);
        tbRichTextEvaluateItemInfo.setTitle(evaluateRelevanceItemSelectedMessage.item_name);
        this.mData.setItemInfo(tbRichTextEvaluateItemInfo);
        this.mWriteEvaluationeHeaderView.setItemInfo(tbRichTextEvaluateItemInfo);
    }

    private void showAdditionTip(boolean z2, String str) {
        int i2;
        int i3;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z2) {
            AdditionData additionData = this.mAdditionData;
            if (additionData != null) {
                i2 = additionData.getTotalCount();
                i3 = this.mAdditionData.getAlreadyCount() + 1;
            } else {
                i2 = 0;
                i3 = 0;
            }
            if (i2 > i3) {
                String format = String.format(getPageContext().getString(R.string.write_addition_left_count), Integer.valueOf(i2 - i3));
                sb.append("\n");
                sb.append(format);
            }
        }
        d.b.b.e.p.l.L(getPageContext().getPageActivity(), sb.toString());
    }

    private void showCommodityTip() {
        EditorTools editorTools = this.mEditor;
        if (editorTools == null) {
            return;
        }
        editorTools.post(new o());
    }

    private void showEditorTopicTip() {
        if (this.mTipController == null) {
            this.mTipController = new d.b.i0.u3.v.g(getPageContext());
        }
        this.mTipController.c(this.mEditor);
    }

    private void showLocPermissionDialog() {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(getPageContext().getPageActivity());
        aVar.setMessageId(R.string.location_app_permission_prompt).setPositiveButton(R.string.isopen, new g()).setNegativeButton(R.string.cancel, new f()).create(getPageContext());
        aVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTipDialog(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.w(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.mAntiInjectListener) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                if (postWriteCallBackData.getErrorCode() == 230278) {
                    return;
                }
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.mAdditionData == null) {
                    d.b.i0.c3.q0.g.b(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                showAdditionTip(z2, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTipWindow() {
        EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this, EBusinessProtocolView.WindowType.TIP);
        eBusinessProtocolView.o(getResources().getString(R.string.tip_title));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) getString(R.string.tip_content_1)).append((CharSequence) "\n");
        spannableStringBuilder.append((CharSequence) getString(R.string.tip_content_2)).append((CharSequence) "\n");
        spannableStringBuilder.append((CharSequence) getString(R.string.tip_content_3)).append((CharSequence) "\n");
        spannableStringBuilder.append((CharSequence) getString(R.string.tip_content_4)).append((CharSequence) "\n");
        spannableStringBuilder.append((CharSequence) getString(R.string.tip_content_5));
        eBusinessProtocolView.k(spannableStringBuilder);
        d.b.b.e.m.g.i(eBusinessProtocolView, this);
    }

    private void showVoteView() {
        WriteVoteData writeVoteData;
        Serializable serializable = this.voteDataSerializable;
        if (serializable instanceof WriteVoteData) {
            writeVoteData = (WriteVoteData) serializable;
            this.mData.setWriteVoteData(writeVoteData);
        } else if (this.mData.getWriteVoteData() == null) {
            return;
        } else {
            writeVoteData = this.mData.getWriteVoteData();
        }
        q qVar = new q(writeVoteData);
        this.mVoteViewController.f(qVar);
        this.mVoteViewController.e(qVar);
        this.mVoteViewController.g(writeVoteData);
        this.mVoteViewController.h(true);
        refreshPostButton();
    }

    private void startAsyncPostWrite() {
        this.mWriteModel.v();
        d.b.i0.u3.s.b.e(this.mData);
        stopVoice();
        processSaveDraft();
        setResult(100);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void stopVoice() {
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        voiceManager.stopPlay();
    }

    private void takePhoto(String str) {
        if (PermissionUtil.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            return;
        }
        SelectImageHelper.takePhoto(getPageContext(), str);
    }

    private void updataTitle() {
        String str;
        String str2;
        WriteData writeData = this.mData;
        if (writeData == null) {
            return;
        }
        int type = writeData.getType();
        if (type != 0) {
            if (type == 7) {
                this.mPostTitle.setVisibility(0);
                this.mPostContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                this.mName.setText(R.string.post_drift_bottle);
                return;
            } else if (type != 9) {
                if (type == 11) {
                    this.mName.setText(R.string.publish_comment);
                    this.mPostTitle.setVisibility(0);
                    this.mPostContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                } else if (type == 4) {
                    this.mName.setText(R.string.publish_photo_live);
                    this.mPostContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                } else if (type != 5) {
                    this.mName.setText(R.string.send_reply);
                    this.mPostContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.mPostTitle.setVisibility(8);
                    return;
                } else {
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.live_interval_view.setVisibility(8);
                    return;
                }
            }
        }
        if (!this.isFeedBack && !this.isFeedBackBar) {
            String str3 = this.mCallFrom;
            if (str3 != null && str3.equals("1")) {
                this.mName.setText(R.string.post_to_home_page);
            } else {
                String str4 = this.mCallFrom;
                if (str4 != null && str4.equals("2")) {
                    if (this.isEvaluate) {
                        this.mName.setText(R.string.publish_comment);
                    } else if (StringUtils.isNull(this.mData.getForumName())) {
                        this.mName.setText(R.string.post_to_thread);
                    } else {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.mData.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    }
                } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    this.mName.setText(getResources().getString(R.string.share_to) + this.mData.getForumName() + getResources().getString(R.string.bar));
                    this.mPostTitle.setVisibility(8);
                    String str5 = this.mMoreForumTitle + " " + this.mMoreForumUrl;
                    if (!StringUtils.isNull(str5)) {
                        this.mPostContent.setText(str5);
                    }
                } else {
                    this.mName.setText("");
                }
            }
        } else if (this.isVcodeFeedBack) {
            this.mName.setText(R.string.feedback_vcode);
        } else {
            this.mName.setText(R.string.feedback);
        }
        this.mPostTitle.setVisibility(0);
        this.mPostContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
    }

    private void updateGriViewData() {
        if (this.isLivePhotoType) {
            this.mPhotoLiveGridViewAdapter.l(this.writeImagesInfo);
            updateGridView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGridView() {
        this.mPhotoLiveGridViewAdapter.notifyDataSetChanged();
        this.mPhotoLiveGridView.invalidate();
        this.mHandler.postDelayed(new x0(), 550L);
    }

    private void updateGroup() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHintTextColor() {
        if (this.mPostTitle.hasFocus()) {
            this.mPostTitle.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        } else {
            this.mPostTitle.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        }
        if (this.mPostContent.hasFocus()) {
            this.mPostContent.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        } else {
            this.mPostContent.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTitleStyle() {
        EditText editText = this.mPostTitle;
        if (editText == null || editText.getText() == null || this.mPostTitle.getText().toString() == null || this.mPostTitle.getPaint() == null) {
            return;
        }
        if (this.mPostTitle.getText().toString().length() == 0) {
            this.mPostTitle.getPaint().setFakeBoldText(true);
        } else if (this.mPostTitle.getText().toString().length() > 0) {
            this.mPostTitle.getPaint().setFakeBoldText(true);
        }
    }

    public boolean canSelectVideo() {
        return !"1".equals(this.mCallFrom) && this.writeImagesInfo.size() == 0 && this.mVoiceModel == null;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        d.b.h0.r.f0.a aVar = this.mLoadingDialog;
        if (aVar != null) {
            aVar.h(false);
        }
    }

    public void deleteChar() {
        if (getRealContentEdittextInstance().getSelectionStart() > 0) {
            String substring = getRealContentEdittextInstance().getText().toString().substring(0, getRealContentEdittextInstance().getSelectionStart());
            Matcher matcher = d.b.i0.k0.a.f56419b.matcher(substring);
            if (matcher.find()) {
                getRealContentEdittextInstance().getText().delete(getRealContentEdittextInstance().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), getRealContentEdittextInstance().getSelectionStart());
                return;
            }
            getRealContentEdittextInstance().onKeyDown(67, this.keyEventDown);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public String getCallFrom() {
        return this.mCallFrom;
    }

    @Override // com.baidu.tbadk.BaseActivity, d.b.h0.k0.a
    public String getCurrentPageKey() {
        WriteData writeData = this.mData;
        if (writeData != null) {
            if (writeData.getType() == 4) {
                return "a015";
            }
            if (this.mData.getType() == 5) {
                return "a016";
            }
            return null;
        }
        return null;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public FrsTabInfoData getFrsTabInfoData() {
        return this.mFrsTabList;
    }

    public EditText getRealContentEdittextInstance() {
        return this.isLivePhotoType ? this.live_post_content : this.mPostContent;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public synchronized VoiceManager getVoiceManager() {
        if (this.mVoiceManager == null) {
            this.mVoiceManager = VoiceManager.instance();
        }
        return this.mVoiceManager;
    }

    public WriteData getWriteData() {
        return this.mData;
    }

    public void initTitleView() {
        WriteData writeData;
        if (this.isEvaluate) {
            this.mTitleView.setVisibility(8);
            WriteImageGridView writeImageGridView = this.imageGridView;
            if (writeImageGridView != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) writeImageGridView.getLayoutParams();
                layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                this.imageGridView.setLayoutParams(layoutParams);
            }
            this.mTitleViewDivider.setVisibility(8);
        } else if (d.b.i0.u3.s.b.c()) {
            this.mPostTitle.setHint(R.string.title_hint_for_hot);
            this.mTitleView.setVisibility(0);
            WriteImageGridView writeImageGridView2 = this.imageGridView;
            if (writeImageGridView2 != null) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) writeImageGridView2.getLayoutParams();
                layoutParams2.topMargin = 0;
                this.imageGridView.setLayoutParams(layoutParams2);
            }
            this.mTitleViewDivider.setVisibility(0);
            d.b.i0.u3.s.b.g(this.mPostTitleTip);
            this.mTitleView.requestFocus();
        } else {
            this.mPostTitleTip.setVisibility(8);
            this.mPostTitle.setHint(this.isFeedBack ? R.string.feedback_title_hint : R.string.post_title_hint);
            if (!this.isFeedBack && ListUtils.isEmpty(this.mList) && ((writeData = this.mData) == null || StringUtils.isNull(writeData.getTitle()))) {
                this.mTitleView.setVisibility(8);
                WriteImageGridView writeImageGridView3 = this.imageGridView;
                if (writeImageGridView3 != null) {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) writeImageGridView3.getLayoutParams();
                    layoutParams3.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                    this.imageGridView.setLayoutParams(layoutParams3);
                }
                this.mTitleViewDivider.setVisibility(8);
                return;
            }
            this.mTitleView.setVisibility(0);
            WriteImageGridView writeImageGridView4 = this.imageGridView;
            if (writeImageGridView4 != null) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) writeImageGridView4.getLayoutParams();
                layoutParams4.topMargin = 0;
                this.imageGridView.setLayoutParams(layoutParams4);
            }
            this.mTitleViewDivider.setVisibility(0);
            this.mTitleView.requestFocus();
        }
    }

    public void initializePostContent() {
        SpanGroupEditText spanGroupEditText = (SpanGroupEditText) findViewById(R.id.post_content);
        this.mPostContent = spanGroupEditText;
        spanGroupEditText.setDrawingCacheEnabled(false);
        this.mPostContent.setOnClickListener(this.mEditOnClicked);
        this.mPostContent.setOnSpanGroupChangedListener(new p0());
        this.mPostContent.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY);
        this.mPostContent.setForumId(d.b.b.e.m.b.f(this.mData.getForumId(), 0L));
        d.b.i0.c3.q0.a aVar = this.mWriteModel;
        if (aVar != null) {
            aVar.t(this.mPostContent.getSpanGroupManager());
        }
        WriteData writeData = this.mData;
        if (writeData != null) {
            writeData.setSpanGroupManager(this.mPostContent.getSpanGroupManager());
        }
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            this.mPostContent.setText(TbFaceManager.e().j(getPageContext().getPageActivity(), this.mData.getContent()));
            if (this.mPostContent.getText() != null) {
                SpanGroupEditText spanGroupEditText2 = this.mPostContent;
                spanGroupEditText2.setSelection(spanGroupEditText2.getText().length());
            }
        } else if (this.mData.getType() == 2) {
            if (this.mIsReplySubPb) {
                String str = this.mSubUserName;
                if (str != null && str.length() > 0) {
                    this.mPostContent.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.mSubUserName}));
                    SpanGroupEditText spanGroupEditText3 = this.mPostContent;
                    spanGroupEditText3.setSelection(spanGroupEditText3.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                this.mPostContent.setText(String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.mData.getFloorNum())));
                SpanGroupEditText spanGroupEditText4 = this.mPostContent;
                spanGroupEditText4.setSelection(spanGroupEditText4.getText().length());
            }
        }
        this.mPostContent.setOnFocusChangeListener(this.mFocusChangeListener);
        this.mPostContent.setOnTouchListener(new q0());
        this.mPostContent.addTextChangedListener(this.mWriteContentTextWatcher);
        if (this.mData.getType() == 0) {
            this.mIsWillShowBubble = true;
        } else {
            refreshBubble(true);
            this.mIsWillShowBubble = false;
        }
        if (this.isEvaluate) {
            SpannableString spannableString = new SpannableString(" " + ((Object) getResources().getText(R.string.write_evalute_hint)));
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_post_redact16, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL);
            pureDrawable.setBounds(0, 0, pureDrawable.getIntrinsicWidth(), pureDrawable.getIntrinsicHeight());
            spannableString.setSpan(new d.b.i0.k0.d.a(pureDrawable, 1, d.b.b.e.p.l.g(this, R.dimen.tbds4)), 0, 1, 17);
            this.mPostContent.setHint(spannableString);
        } else if (this.mData.isUserFeedback()) {
            this.mPostContent.setHint(R.string.write_input_content);
        } else {
            this.mPostContent.setHint(R.string.main_body);
        }
    }

    public void initializePostTitle() {
        HeadImageView headImageView = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.mUserHeaderPortrait = headImageView;
        headImageView.setIsRound(true);
        this.mUserHeaderPortrait.setDrawBorder(false);
        this.mUserHeaderPortrait.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(currentPortrait);
            this.mUserHeaderPortrait.setUrl(headPortraitFilter);
            this.mUserHeaderPortrait.W(headPortraitFilter, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.mUserHeaderPortrait.setVisibility(0);
        }
        EditText editText = (EditText) findViewById(R.id.post_title);
        this.mPostTitle = editText;
        editText.setOnClickListener(this.mEditOnClicked);
        this.mPostTitle.setOnFocusChangeListener(this.mFocusChangeListener);
        if (this.mData.getType() != 0 && this.mData.getType() != 9 && this.mData.getType() != 11 && this.mData.getType() != 7) {
            if (this.mData.getType() != 1) {
                this.mData.getType();
            }
        } else if (this.mData.getTitle() != null) {
            this.mPostTitle.setText(this.mData.getTitle());
            this.mPostTitle.setSelection(this.mData.getTitle().length());
        } else if (this.isVcodeFeedBack) {
            this.mPostTitle.setText(getResources().getString(R.string.vcode_feed_back_title));
        }
        this.mPostTitle.addTextChangedListener(this.mWriteTitleTextWatcher);
        d.b.h0.r.u.c.a(this.mPostTitle).s(R.string.F_X02);
        if (!this.mData.getHaveDraft()) {
            initPostTopic();
            this.hasSetTitleUseHotTopic = true;
        }
        this.mPostTitleTip = (TitleTipView) findViewById(R.id.post_title_tip);
    }

    public void insertFaceIconToEditText(d.b.h0.s.c.t tVar) {
        if (((ImageSpan[]) getRealContentEdittextInstance().getText().getSpans(0, getRealContentEdittextInstance().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.mTooManyEmotionToast == null) {
                this.mTooManyEmotionToast = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            this.mTooManyEmotionToast.show();
            return;
        }
        d.b.i0.k0.b.b(this, tVar, getRealContentEdittextInstance());
    }

    public void intializePostButton() {
        this.mPost.setOnClickListener(new n0());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    public void onActivityResult(int i2, int i3, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            if (i3 == 0) {
                EditorTools editorTools = this.mEditor;
                if (editorTools != null && !editorTools.u()) {
                    this.mPostContent.requestFocus();
                    this.mInputManager.toggleSoftInput(0, 2);
                    this.mEditor.q();
                }
                if (i2 == 12001) {
                    deleteTempCameraFile();
                    return;
                } else if (i2 == 12002) {
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    updateGriViewData();
                    if (this.mIsWillShowBubble) {
                        refreshBubble(true);
                        this.mIsWillShowBubble = false;
                        return;
                    }
                    return;
                } else if (i2 == 12004) {
                    if (this.mPostTitle == getCurrentFocus()) {
                        getRealContentEdittextInstance().clearFocus();
                        this.mPostTitle.requestFocus();
                        EditorTools editorTools2 = this.mEditor;
                        if (editorTools2 != null) {
                            editorTools2.q();
                        }
                        ShowSoftKeyPadDelay(this.mPostTitle);
                        return;
                    }
                    getRealContentEdittextInstance().requestFocus();
                    EditorTools editorTools3 = this.mEditor;
                    if (editorTools3 != null) {
                        editorTools3.q();
                    }
                    ShowSoftKeyPadDelay(this.mPostContent);
                    return;
                } else if (i2 == 12006) {
                    if (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) || (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) == null || !postWriteCallBackData.isSensitiveError()) {
                        return;
                    }
                    showToast(postWriteCallBackData.getErrorString());
                    this.mHighLightController.o(postWriteCallBackData.getErrorString());
                    this.mHighLightController.n(postWriteCallBackData.getSensitiveWords());
                    this.mHighLightController.i(this.mPostTitle, this.mPostContent);
                    return;
                } else if (i2 == 12010) {
                    this.photoName = String.valueOf(System.currentTimeMillis());
                    SelectImageHelper.takePhoto(getPageContext(), this.photoName);
                    return;
                } else if (i2 == 12012) {
                    updateGriViewData();
                    return;
                } else if (i2 != 25004) {
                    return;
                } else {
                    if ("from_title".equals(this.fromWhereToHotSelect)) {
                        getRealTitleInstance().requestFocus();
                        return;
                    } else if ("from_content".equals(this.fromWhereToHotSelect)) {
                        getRealContentEdittextInstance().requestFocus();
                        return;
                    } else {
                        return;
                    }
                }
            }
            return;
        }
        PostWriteCallBackData postWriteCallBackData2 = null;
        postWriteCallBackData2 = null;
        postWriteCallBackData2 = null;
        if (i2 == 12004) {
            if (this.mPostTitle == getCurrentFocus()) {
                getRealContentEdittextInstance().clearFocus();
                this.mPostTitle.requestFocus();
                EditorTools editorTools4 = this.mEditor;
                if (editorTools4 != null) {
                    editorTools4.q();
                }
                ShowSoftKeyPadDelay(this.mPostTitle);
            } else {
                getRealContentEdittextInstance().requestFocus();
                EditorTools editorTools5 = this.mEditor;
                if (editorTools5 != null) {
                    editorTools5.q();
                }
                ShowSoftKeyPadDelay(this.mPostContent);
            }
            ArrayList<String> stringArrayListExtra = intent != null ? intent.getStringArrayListExtra("name_show") : null;
            if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i4 = 0; i4 < stringArrayListExtra.size(); i4++) {
                sb.append("@");
                sb.append(stringArrayListExtra.get(i4));
                sb.append(" ");
            }
            getRealContentEdittextInstance().getText().insert(getRealContentEdittextInstance().getSelectionStart(), sb.toString());
        } else if (i2 == 12006) {
            if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) {
                postWriteCallBackData2 = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
            }
            clearDraft();
            deleteTempVideoFile();
            sendUpdatePhotoLiveMessage(postWriteCallBackData2);
            setResult(-1, intent);
            finish();
        } else if (i2 != 12010 && i2 != 12009) {
            if (i2 == 12002) {
                if (intent == null) {
                    return;
                }
                if (intent.getBooleanExtra(AlbumActivityConfig.FINISH_SELF, false)) {
                    setResult(-1, intent);
                    finish();
                    return;
                }
                int intExtra = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                    if (intExtra == 1) {
                        dealLiveCoverFromCamera();
                    } else {
                        dealAlbumFromCamera(intent);
                    }
                } else if (intExtra == 1) {
                    dealLiveCoverFromImage(intent);
                } else {
                    dealAlbumFromImages(intent);
                    d.b.b.e.m.e.a().post(new w0());
                }
                showPicOrVideo(ListUtils.getCount(this.writeImagesInfo.getChosedFiles()) > 0, false);
                if (this.mIsWillShowBubble) {
                    refreshBubble(true);
                    this.mIsWillShowBubble = false;
                }
            } else if (i2 == 12012) {
                if (!this.isLivePhotoType) {
                    getMotuData(intent);
                    refreshPostButton();
                    return;
                }
                getAlbumDataForPhotoLive(intent);
            } else if (i2 == 13010) {
                VideoInfo videoInfo = new VideoInfo();
                videoInfo.parseFromIntent(intent);
                if (videoInfo.isAvaliable()) {
                    this.mData.setVideoInfo(videoInfo);
                    this.mEditor.A(new d.b.h0.w.a(2, 19, " "));
                    this.mEditor.A(new d.b.h0.w.a(28, 20, videoInfo));
                } else {
                    this.mEditor.A(new d.b.h0.w.a(5, -1, null));
                }
                refreshPostButton();
            } else if (i2 == 23004) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
            } else if (i2 == 25004) {
                if (intent == null) {
                    return;
                }
                String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                if (StringUtils.isNull(stringExtra)) {
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                if (this.needAddHotTopicSign) {
                    sb2.append(d.b.h0.p0.b.f50404a);
                    this.needAddHotTopicSign = false;
                }
                sb2.append(stringExtra);
                addHotTopic(sb2.toString());
            } else if (i2 == 25005 && intent != null && !ListUtils.isEmpty(this.mList)) {
                if (ListUtils.isEmpty(this.mList) || intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) >= this.mList.size()) {
                    return;
                }
                HotTopicBussinessData hotTopicBussinessData = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                this.mCurrHotData = hotTopicBussinessData;
                changeHotTopicData(hotTopicBussinessData);
            } else if (i2 == 25048) {
                Serializable serializableExtra = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
                if (serializableExtra instanceof WriteVoteData) {
                    this.voteDataSerializable = serializableExtra;
                    showVoteView();
                }
            } else if (i2 == 25049 && intent != null) {
                String str = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT) + " ";
                int selectionStart = this.mPostContent.getSelectionStart();
                int selectionEnd = this.mPostContent.getSelectionEnd();
                if (selectionStart >= 0) {
                    Editable text = this.mPostContent.getText();
                    if (selectionEnd > selectionStart) {
                        text.replace(selectionStart, selectionEnd, str);
                    } else {
                        text.insert(selectionStart, str);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        getLayoutMode().k(i2 == 1);
        getLayoutMode().j(this.mParent);
        getLayoutMode().j(this.mBubbleLayout);
        SkinManager.setBackgroundColor(this.mParent, R.color.CAM_X0205);
        if (this.mRecImgView != null && (i2 == 1 || i2 == 4)) {
            this.mRecImgView.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        if (this.mNavigationBar.getBackImageView() != null) {
            this.mNavigationBar.getBackImageView().setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_close40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
        this.mPost.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, i2));
        changeToolButtonStatus();
        SkinManager.setBackgroundColor(this.mInterval, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.live_interval_view, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(getRealTitleInstance(), R.color.CAM_X0205);
        this.mIvDeleteVoice.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_home_delete16, SkinManager.getColor(R.color.CAM_X0107), null));
        if (TextUtils.isEmpty(this.mBubbleUrl)) {
            SkinManager.setBackgroundColor(getRealContentEdittextInstance(), R.color.CAM_X0205);
        }
        refreshPostButton();
        this.mEditor.w(i2);
        PostCategoryView postCategoryView = this.mCategoryView;
        if (postCategoryView != null) {
            postCategoryView.b();
        }
        d.b.i0.u3.v.d dVar = this.mAdapter;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
        SkinManager.setViewTextColor(this.mName, R.color.CAM_X0105);
        this.mWriteImageController.f61802d.notifyDataSetChanged();
        updateHintTextColor();
        updateTitleStyle();
        refreshBubble(false);
        d.b.i0.u3.v.c cVar = this.mHighLightController;
        if (cVar != null) {
            cVar.m(getRealTitleInstance(), getRealContentEdittextInstance());
        }
        ForumSelectedView forumSelectedView = this.mForumSelectedView;
        if (forumSelectedView != null) {
            forumSelectedView.b();
        }
        WriteEvaluationHeaderView writeEvaluationHeaderView = this.mWriteEvaluationeHeaderView;
        if (writeEvaluationHeaderView != null) {
            writeEvaluationHeaderView.f();
        }
        ForumTabSelectedView forumTabSelectedView = this.mForumTabSelectedView;
        if (forumTabSelectedView != null) {
            forumTabSelectedView.k(i2);
        }
        d.b.i0.u3.v.o.a aVar = this.writeVideoController;
        if (aVar != null) {
            aVar.k();
        }
        d.b.i0.u3.v.p.a aVar2 = this.mVoteViewController;
        if (aVar2 != null) {
            aVar2.d(i2);
        }
        EBusinessProtocolView eBusinessProtocolView = this.mEBusinessProtocolView;
        if (eBusinessProtocolView != null) {
            eBusinessProtocolView.j(i2);
        }
        TitleTipView titleTipView = this.mPostTitleTip;
        if (titleTipView != null) {
            titleTipView.c(i2);
        }
        TextView textView = this.mPostContentCounter;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0301);
        }
    }

    public void onCommodityClick() {
        if (!checkContainHaowuTab()) {
            BdToast.i(this, getString(R.string.post_goods_no_tab_tip), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        } else if (!this.canGoods) {
            BdToast.i(this, getString(R.string.post_goods_tip), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        } else {
            if (this.mData != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_CLICK).param("obj_locate", 2).param("fid", this.mData.getForumId()).param("fname", this.mData.getForumName()));
            }
            if (!d.b.h0.r.d0.b.i().g("commodity_goods_show_first_dialog", false)) {
                d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(getPageContext().getPageActivity());
                aVar.setContentViewSize(2);
                aVar.setCanceledOnTouchOutside(false);
                FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(getPageContext().getPageActivity());
                frsPublishFineGoodsDialogView.setConfirmButtonListener(new e1(aVar));
                aVar.setContentView(frsPublishFineGoodsDialogView);
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_SHOW).param("obj_locate", 2);
                WriteData writeData = this.mData;
                StatisticItem param2 = param.param("fid", writeData != null ? writeData.getForumId() : "");
                WriteData writeData2 = this.mData;
                TiebaStatic.log(param2.param("fname", writeData2 != null ? writeData2.getForumName() : ""));
                aVar.create(getPageContext()).show();
                return;
            }
            String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=" + getStillCommodityNum()));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new k1(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initListener();
        initData(bundle);
        if (this.mData.getType() == 0) {
            jumpToAlbumActivity(this.isAblumThread);
        }
        initUI();
        getTopList();
        LocationModel locationModel = new LocationModel(getPageContext());
        this.mLocationModel = locationModel;
        locationModel.I(this.mOnLocationCallBack);
        registerVideoPostClickUserCollectionToastTask();
        initEditor();
        initRecBubble();
        if (this.isLivePhotoType) {
            this.mPhotoLiveGridViewAdapter.m(this.mEditor);
        } else {
            this.mPostContent.requestFocus();
        }
        initTitleView();
        sendSetImgAction();
        bindMoreForumImg();
        this.mSwanappReturnProductDateListener.setPriority(1);
        registerResponsedEventListener(GoodsEvent.class, this.mSwanappReturnProductDateListener);
        initProductData();
        if (this.fromErrorDialog) {
            fillContent(this.mData);
            refreshPostButton();
            initLastErrorHandleFromErrorDialog();
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        d.b.i0.t3.b bVar = new d.b.i0.t3.b(getPageContext().getPageActivity(), new j0(), new Date().getHours(), new Date().getMinutes(), false);
        this.dialog = bVar;
        bVar.setTitle(R.string.no_disturb_start_time);
        this.dialog.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.dialog);
        this.dialog.setButton(-2, getPageContext().getString(R.string.cancel), this.dialog);
        return this.dialog;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mNavigationBar.removeCallbacks(this.handleLastError);
        d.b.i0.c3.q0.a aVar = this.mWriteModel;
        if (aVar != null) {
            aVar.m();
        }
        hideEditorTopicTip();
        hideCommodityTip();
        TiebaPrepareImageService.StopService();
        stopTask(true);
        if (!this.isProcessedSaveDraft) {
            processSaveDraft();
        }
        d.b.b.e.m.g.a(this.saveDraftDialog, this);
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        d.b.i0.u3.v.i iVar = this.mWriteImageController;
        if (iVar != null) {
            iVar.e();
        }
        d.b.i0.b0.e eVar = this.mPiefixTipController;
        if (eVar != null) {
            eVar.H();
        }
        MessageManager.getInstance().unRegisterTask(2921500);
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.post_prefix_layout.setSelected(false);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mPrefixIcon, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
        ShowSoftKeyPadDelay(this.mPostContent);
    }

    @Override // d.b.i0.c3.y.d
    public void onDraftLoaded(WriteData writeData) {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) || this.isProductTie || this.fromErrorDialog) {
            return;
        }
        if (writeData != null) {
            if (this.mData != null && writeData.isEvaluate() == this.mData.isEvaluate()) {
                int i2 = 0;
                boolean z2 = this.mData.getVideoInfo() != null && this.mData.getVideoInfo().isEditVideoDataLegal();
                boolean z3 = (this.mData.getWriteImagesInfo() == null || ListUtils.isEmpty(this.mData.getWriteImagesInfo().getChosedFiles())) ? false : true;
                boolean z4 = !d.b.b.e.p.k.isEmpty(getRealTitleInstance().getText().toString());
                boolean z5 = !d.b.b.e.p.k.isEmpty(getRealContentEdittextInstance().getText().toString());
                boolean z6 = !d.b.b.e.p.k.isEmpty(writeData.getTitle());
                boolean z7 = !d.b.b.e.p.k.isEmpty(writeData.getContent());
                this.mData.setHaveDraft(true);
                if (!z3 && !z2) {
                    fillVideoOrImage(writeData);
                }
                if (!z4 || this.hasSetTitleUseHotTopic || ((this.isFeedBack || this.isFeedBackBar) && z6)) {
                    fillTitle(writeData);
                }
                if (z7 && (!z5 || this.isFeedBack || this.isFeedBackBar)) {
                    fillContent(writeData);
                }
                WriteData writeData2 = this.mData;
                if (writeData2 != null && !writeData2.getHaveDraft()) {
                    initPostTopic();
                }
                if (writeData.getItemInfo() != null) {
                    this.mData.setItemInfo(writeData.getItemInfo());
                    this.mData.setEvaluationStar(writeData.getEvaluationStar());
                    this.mIntentItemInfo = null;
                    initWriteEvaluationHeaderView();
                }
                if (writeData.getWriteVoteData() != null) {
                    this.mData.setWriteVoteData(writeData.getWriteVoteData());
                    showVoteView();
                }
                if (writeData.getVoiceModel() != null) {
                    addVoice(writeData.getVoiceModel());
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    loadDraftImageForPhotoLive();
                }
                refreshPostButton();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.mCategoryList != null) {
                    d.b.i0.p0.c0 c0Var = this.mCategoryDefault;
                    this.mCategoryToID = c0Var.f57361b;
                    this.mCategoryName = c0Var.f57360a;
                    while (true) {
                        if (i2 == this.mCategoryList.size()) {
                            break;
                        }
                        d.b.i0.p0.c0 c0Var2 = this.mCategoryList.get(i2);
                        if (categoryTo == c0Var2.f57361b) {
                            this.mCategoryToID = categoryTo;
                            this.mCategoryName = c0Var2.f57360a;
                            this.mData.setCategoryTo(categoryTo);
                            break;
                        }
                        i2++;
                    }
                    PostCategoryView postCategoryView = this.mCategoryView;
                    if (postCategoryView != null) {
                        postCategoryView.setText(this.mCategoryName);
                        this.mCategoryView.setCategoryContainerData(this.mCategoryList, this.mCategoryDefault, this.mCategoryToID);
                    }
                }
                this.mEditor.q();
                return;
            }
            return;
        }
        loadDraftImageForPhotoLive();
        initPostTopic();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        Editable text;
        int selectionStart;
        if (i2 == 4) {
            d.b.i0.u3.i iVar = this.mPrefixWindow;
            if (iVar != null && iVar.isShowing()) {
                d.b.b.e.m.g.d(this.mPrefixWindow, getPageContext().getPageActivity());
                return true;
            } else if (this.mEditor.u()) {
                this.mEditor.q();
                return true;
            } else {
                stopTask();
                popupSaveDraftDialog();
                return true;
            }
        }
        if (i2 == 67 && (text = getRealContentEdittextInstance().getText()) != null && (selectionStart = getRealContentEdittextInstance().getSelectionStart() - 1) > 0 && selectionStart < text.length() && text.charAt(selectionStart) == 0) {
            getRealContentEdittextInstance().onKeyDown(67, this.keyEventDown);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i2) {
        super.onKeyboardHeightChanged(i2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z2) {
        this.isKeyboardVisibility = z2;
        if (this.isAttach && System.currentTimeMillis() - this.recTimeStamp < 800) {
            d.b.b.e.p.l.w(getPageContext().getPageActivity(), getCurrentFocus());
            this.isAttach = false;
        }
        d.b.i0.u3.n.b bVar = this.mWriteTool;
        if (bVar != null && !z2) {
            bVar.h();
        }
        if (this.mTipController != null && !z2) {
            hideEditorTopicTip();
        }
        if (this.mCommodityTipController == null || z2) {
            return;
        }
        hideCommodityTip();
    }

    public void onLocViewClickedInInitState() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            sendLocaionAction(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            showLocPermissionDialog();
        } else if (this.mLocationModel.z()) {
            goToSelectLocationActivity();
        } else {
            this.mLocationModel.H(false);
            sendLocaionAction(1, true, null);
            this.mLocationModel.D();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        WriteImagesInfo writeImagesInfo;
        super.onNewIntent(intent);
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
        if (stringExtra != null && (writeImagesInfo = this.writeImagesInfo) != null) {
            writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                sendSetImgAction();
            }
            refreshMutiImage(true);
        }
        Serializable serializableExtra = intent.getSerializableExtra(WriteActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mData.setVideoInfo((VideoInfo) serializableExtra);
        } else {
            this.mData.setVideoInfo(null);
        }
        if (this.writeVideoController == null) {
            this.writeVideoController = new d.b.i0.u3.v.o.a(getPageContext(), this.mRootView);
        }
        if (this.mData.getVideoInfo() != null && this.mData.getVideoInfo().isEditVideoDataLegal()) {
            showPicOrVideo(false, false);
            this.writeVideoController.v();
            return;
        }
        showPicOrVideo(true, false);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, getRealTitleInstance());
        HidenSoftKeyPad(this.mInputManager, getRealContentEdittextInstance());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
        d.b.i0.u3.v.o.a aVar = this.writeVideoController;
        if (aVar != null) {
            aVar.p();
        }
        if (this.mEditor.u()) {
            this.mEditor.q();
        }
    }

    @Override // d.b.i0.u3.i.a
    public void onPrefixItemClick(int i2) {
        if (i2 == ListUtils.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new StatisticItem("c13014").param("obj_type", 1));
        } else {
            TiebaStatic.log(new StatisticItem("c13014").param("obj_type", 2));
        }
        this.mCurrPrefixPos = i2;
        this.mPrefixWindow.c(i2);
        resetCheckImgState(i2);
        this.mPrefix.setText(this.mPrefixData.getPrefixs().get(i2));
        refreshPostButton();
        d.b.b.e.m.g.d(this.mPrefixWindow, getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 0) {
            onLocViewClickedInInitState();
        } else if (i2 == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (PermissionUtil.checkCamera(getApplicationContext())) {
                SelectImageHelper.takePhoto(getPageContext(), this.photoName);
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            if (!transformPermissionResult.containsKey(StorageUtils.EXTERNAL_STORAGE_PERMISSION) || transformPermissionResult.get(StorageUtils.EXTERNAL_STORAGE_PERMISSION).booleanValue()) {
                return;
            }
            showToast(R.string.sdcard_permission_denied_advert_for_camera);
        } else {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = getRealContentEdittextInstance().getEditableText().toString();
        if (obj != null) {
            getRealContentEdittextInstance().setText(TbFaceManager.e().l(getPageContext().getPageActivity(), obj, this.mBigEmotionSpanHanlder));
            getRealContentEdittextInstance().setSelection(getRealContentEdittextInstance().getText().length());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.isLivePhotoType) {
            this.mPostTitle.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.live_post_title_container.setVisibility(8);
            } else {
                this.live_post_title_container.setVisibility(0);
            }
            setLeftCount(this.mContentOverPlusNumber, this.live_post_content);
            setLeftCount(this.mTitleOverPlusNumber, this.live_post_title);
            refreshPostButton();
        }
        if (this.isFeedBack) {
            this.isDisalbeButtons = true;
            changeToolButtonStatus();
            EditorTools editorTools = this.mEditor;
            if (editorTools != null) {
                editorTools.q();
            }
            this.mPostTitle.requestFocus();
            ShowSoftKeyPadDelay(this.mPostTitle);
        }
        d.b.i0.u3.v.o.a aVar = this.writeVideoController;
        if (aVar != null) {
            aVar.q();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.mData.getType());
        bundle.putString("forum_id", this.mData.getForumId());
        bundle.putString("forum_name", this.mData.getForumName());
        bundle.putString(IntentConfig.FORUM_FIRST_DIR, this.mData.getFirstDir());
        bundle.putString(IntentConfig.FORUM_SECOND_DIR, this.mData.getSecondDir());
        bundle.putString("thread_id", this.mData.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.mData.getFloor());
        bundle.putInt("floor_num", this.mData.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.mIsReplySubPb);
        if (this.isFeedBack) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        WriteImagesInfo writeImagesInfo = this.writeImagesInfo;
        if (writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.photoName);
        AdditionData additionData = this.mAdditionData;
        if (additionData != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(additionData));
        }
        PostPrefixData postPrefixData = this.mPrefixData;
        if (postPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(postPrefixData));
        }
        PostTopicData postTopicData = this.mPostTopicData;
        if (postTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(postTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.mCallFrom);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.isAblumThread);
        bundle.putInt("private_thread", this.privateThread);
        bundle.putSerializable("tab_list", this.mFrsTabList);
        bundle.putBoolean(WriteActivityConfig.CAN_GOODS, this.canGoods);
        bundle.putInt(WriteActivityConfig.KEY_STATISTIS_FROM, this.mData.getStatisticFrom());
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
        d.b.i0.u3.v.o.a aVar = this.writeVideoController;
        if (aVar != null) {
            aVar.r();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
        d.b.i0.u3.v.o.a aVar = this.writeVideoController;
        if (aVar != null) {
            aVar.s();
        }
    }

    public void openImageActivity(d.b.h0.w.a aVar) {
        if (this.isLivePhotoType) {
            removeLastFunctionPhoto();
        }
        if (this.mEditor.u()) {
            this.mEditor.q();
        }
        jumpToAlbumActivity(0);
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    public void refreshImageLauncher() {
        if (this.mEditor.n(10) == null) {
            return;
        }
        WriteImagesInfo writeImagesInfo = this.writeImagesInfo;
        this.mEditor.setToolEnabled(writeImagesInfo == null || ListUtils.getCount(writeImagesInfo.getChosedFiles()) < this.writeImagesInfo.getMaxImagesAllowed(), 10);
    }

    public void refreshListView() {
        SpanGroupEditText spanGroupEditText;
        d.b.i0.u3.v.d dVar = this.mAdapter;
        if (dVar != null && dVar.f() == null && (spanGroupEditText = this.mPostContent) != null && spanGroupEditText.getSpanGroupManager() != null) {
            this.mAdapter.i(this.mPostContent.getSpanGroupManager().s());
            this.mAdapter.h();
        } else {
            d.b.i0.u3.v.d dVar2 = this.mAdapter;
            if (dVar2 != null && dVar2.f() != null) {
                this.mAdapter.h();
            }
        }
        d.b.i0.u3.v.d dVar3 = this.mAdapter;
        if (dVar3 != null) {
            setProtocolVisibility(dVar3.d());
        }
    }

    public void refreshPostButton() {
        if (this.mData == null) {
            return;
        }
        String obj = getRealTitleInstance() != null ? getRealTitleInstance().getText().toString() : "";
        String trim = getRealContentEdittextInstance() != null ? getRealContentEdittextInstance().getText().toString().trim() : "";
        String trim2 = obj.trim();
        boolean z2 = false;
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            PostPrefixData postPrefixData = this.mPrefixData;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                if (this.mCurrPrefixPos == ListUtils.getCount(this.mPrefixData.getPrefixs()) - 1) {
                    if (TextUtils.isEmpty(trim2)) {
                        this.mData.setIsNoTitle(true);
                    } else if (this.mTitleView.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        setPostButtonEnabled(true);
                        return;
                    }
                } else if (this.mTitleView.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    setPostButtonEnabled(true);
                    return;
                }
            } else if (TextUtils.isEmpty(trim2)) {
                this.mData.setIsNoTitle(true);
            } else if (this.mTitleView.getVisibility() == 0) {
                this.mData.setIsNoTitle(false);
                setPostButtonEnabled(true);
                return;
            }
        }
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
            if (!this.isLivePhotoType) {
                setPostButtonEnabled(true);
                return;
            } else if (this.writeImagesInfo.size() >= 1) {
                setPostButtonEnabled(true);
            }
        }
        if (this.mData.getType() == 4) {
            if (isValidLiveContent(this.live_post_content) && isValidLiveTitle(this.live_post_title)) {
                z2 = true;
            }
            setPostButtonEnabled(z2);
        } else if (this.mData.getType() == 5) {
            setPostButtonEnabled(isValidLiveContent(this.live_post_content));
        } else if (TextUtils.isEmpty(trim) && this.mVoiceModel == null) {
            if (this.mData.getVideoInfo() != null) {
                setPostButtonEnabled(this.mData.getVideoInfo().isVideoMixFinished());
            } else if (hasWriteVote()) {
                setPostButtonEnabled(true);
            } else {
                setPostButtonEnabled(false);
            }
        } else {
            setPostButtonEnabled(true);
        }
    }

    public void setPostButtonEnabled(boolean z2) {
        SpanGroupEditText spanGroupEditText;
        WriteEvaluationHeaderView writeEvaluationHeaderView;
        if (z2 && this.isEvaluate && ((spanGroupEditText = this.mPostContent) == null || TextUtils.isEmpty(spanGroupEditText.getText()) || this.mPostContent.getText().length() < 20 || this.mPostContent.getText().length() > 500 || (writeEvaluationHeaderView = this.mWriteEvaluationeHeaderView) == null || !writeEvaluationHeaderView.e())) {
            return;
        }
        this.mPost.setEnabled(z2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.mLoadingDialog.e(null);
        this.mLoadingDialog.i(R.string.sending);
        this.mLoadingDialog.h(true);
    }

    public void showPicOrVideo(boolean z2, boolean z3) {
        if (z2) {
            this.mData.setVideoInfo(null);
            this.writeVideoController.t(null, z3);
            this.mWriteImageController.f().setVisibility(0);
            refreshBubble(false);
        } else {
            this.writeVideoController.t(this.mData.getVideoInfo(), z3);
            this.writeImagesInfo.clear();
            this.mWriteImageController.f().setVisibility(8);
            hideBubbleTemporary();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001353, Boolean.FALSE));
        }
        refreshPostButton();
        changeToolButtonStatus();
    }

    public void showTip(String str) {
        showToastWithDefaultIcon(str, BdToast.DefaultIcon.FAILURE);
    }

    public void startDefaultLoacation() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            sendLocaionAction(0, true, null);
            d.b.i0.u3.n.b bVar = this.mWriteTool;
            if (bVar != null) {
                bVar.g();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            showLocPermissionDialog();
        } else {
            LocationModel locationModel = this.mLocationModel;
            if (locationModel == null) {
                return;
            }
            locationModel.H(false);
            sendLocaionAction(1, true, null);
            this.mLocationModel.D();
        }
    }

    public void stopTask(boolean z2) {
        d.b.i0.c3.q0.a aVar;
        if (!z2 && (aVar = this.mWriteModel) != null) {
            aVar.a();
        }
        FeedBackModel feedBackModel = this.mFeedBackModel;
        if (feedBackModel != null) {
            feedBackModel.cancelLoadData();
        }
        LocationModel locationModel = this.mLocationModel;
        if (locationModel != null) {
            locationModel.cancelLoadData();
        }
        d.b.i0.u3.v.o.a aVar2 = this.writeVideoController;
        if (aVar2 != null) {
            aVar2.o();
        }
    }

    public void updateChoseFile(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        refreshPostButton();
    }

    public void stopTask() {
        stopTask(false);
    }
}
