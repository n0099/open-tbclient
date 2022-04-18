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
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
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
import com.baidu.tbadk.core.atomData.LocalChannelTopicListActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.RelevanceItemSearchActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishOpenHelper;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.tbadk.core.data.VoiceData;
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
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mutiprocess.event.GoodsEvent;
import com.baidu.tbadk.switchs.RepostToDynamicDefaultSwitch;
import com.baidu.tbadk.util.InsertGalleryAsyncTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
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
import com.baidu.tieba.write.view.AssociatedItemContainer;
import com.baidu.tieba.write.view.ForumSelectedView;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.tieba.write.view.LocalChannelTopicSelectView;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import com.baidu.tieba.write.view.RichGuideHollowView;
import com.baidu.tieba.write.view.WriteEvaluationHeaderView;
import com.baidu.tieba.write.view.xrichtext.RichTextEditor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.repackage.a09;
import com.repackage.a19;
import com.repackage.a9;
import com.repackage.ak8;
import com.repackage.an8;
import com.repackage.as8;
import com.repackage.b19;
import com.repackage.bm8;
import com.repackage.bu4;
import com.repackage.c15;
import com.repackage.ce6;
import com.repackage.cr4;
import com.repackage.d15;
import com.repackage.de6;
import com.repackage.e19;
import com.repackage.ee6;
import com.repackage.ef6;
import com.repackage.en8;
import com.repackage.ev4;
import com.repackage.f15;
import com.repackage.fk8;
import com.repackage.fo;
import com.repackage.g19;
import com.repackage.gd5;
import com.repackage.h15;
import com.repackage.hc5;
import com.repackage.hg;
import com.repackage.ht6;
import com.repackage.i05;
import com.repackage.i15;
import com.repackage.ig;
import com.repackage.j05;
import com.repackage.jz8;
import com.repackage.kz8;
import com.repackage.l05;
import com.repackage.lr4;
import com.repackage.mg;
import com.repackage.mi;
import com.repackage.mo4;
import com.repackage.ni;
import com.repackage.nk8;
import com.repackage.nz5;
import com.repackage.o09;
import com.repackage.oi;
import com.repackage.p05;
import com.repackage.p19;
import com.repackage.p55;
import com.repackage.pg;
import com.repackage.qd5;
import com.repackage.qw8;
import com.repackage.qx4;
import com.repackage.rg;
import com.repackage.rw8;
import com.repackage.t05;
import com.repackage.t25;
import com.repackage.t86;
import com.repackage.tv4;
import com.repackage.u05;
import com.repackage.u09;
import com.repackage.u86;
import com.repackage.v05;
import com.repackage.v25;
import com.repackage.vr4;
import com.repackage.vs8;
import com.repackage.vt4;
import com.repackage.w05;
import com.repackage.wm8;
import com.repackage.x86;
import com.repackage.xt4;
import com.repackage.y15;
import com.repackage.ym8;
import com.repackage.z09;
import com.repackage.zw4;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements VoiceManager.j, fk8.f, jz8.a, PopupWindow.OnDismissListener, ActivityCompat.OnRequestPermissionsResultCallback {
    public static /* synthetic */ Interceptable $ic = null;
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
    public static final int TAB_LIMIT_TITLE = 5;
    public static final int TAB_NO_CHOOSE_COMMODITY = 1;
    public static final int TAB_NO_CHOOSE_HAOWU_TAB = 2;
    public static final int TITLE_MAX_COUNT = 20;
    public static final String UPDATE_PHOTO_LIVE_DRAFT_KEY = "updatephotolive";
    public static final String WRITE_TITLE_PREFIX_TIP_KEY = "write_title_prefix_tip_key";
    public transient /* synthetic */ FieldHolder $fh;
    public AssociatedItemContainer associatedItemContainer;
    public String beforeText;
    public TextView btn_image_problem;
    public boolean canGoods;
    public qw8 dialog;
    public View feedback_divider;
    public boolean fromErrorDialog;
    public String fromWhereToHotSelect;
    public String goodsListStr;
    public final Runnable handleLastError;
    public boolean hasSetTitleUseHotTopic;
    public WriteImageGridView imageGridView;
    public int isAblumThread;
    public boolean isAgreedProtocol;
    public boolean isAttach;
    public boolean isDisalbeButtons;
    public boolean isEvaluate;
    public boolean isFeedBack;
    public boolean isFeedBackBar;
    public boolean isFromItemDetail;
    public boolean isKeyboardVisibility;
    public boolean isLivePhotoType;
    public boolean isLocalChannelDynamic;
    public boolean isPhotoliveTitleHasFocus;
    public boolean isPrivacy;
    public boolean isProcessedSaveDraft;
    public boolean isProductTie;
    public boolean isRichTextEditorMode;
    public boolean isSaveDraft;
    public boolean isToDynamic;
    public boolean isVcodeFeedBack;
    public boolean isVoiceEnable;
    public final KeyEvent keyEventDown;
    public File latestPic;
    public WriteImagesInfo liveCoverImageInfo;
    public View live_container;
    public View live_interval_view;
    public EditText live_post_content;
    public EditText live_post_title;
    public View live_post_title_container;
    public String localChannelTopic;
    public b19 mAdapter;
    public RelativeLayout mAdditionContainer;
    public TextView mAdditionCreateTime;
    public AdditionData mAdditionData;
    public TextView mAdditionLastContent;
    public TextView mAdditionLastTime;
    public final AntiHelper.k mAntiInjectListener;
    public View mBack;
    public CustomMessageListener mBackgroundListener;
    public TbFaceManager.a mBigEmotionSpanHanlder;
    public LinearLayout mBubbleLayout;
    public final nk8.f mBubbleTipRefreshCallback;
    public String mBubbleUrl;
    public View mBubbleView;
    public String mCallFrom;
    public ce6 mCategoryDefault;
    public int mCategoryFromID;
    public List<ce6> mCategoryList;
    public String mCategoryName;
    public int mCategoryToID;
    public PostCategoryView mCategoryView;
    public z09 mCommodityTipController;
    public SpannableStringBuilder mContentBuilder;
    public TextView mContentOverPlusNumber;
    public HotTopicBussinessData mCurrHotData;
    public int mCurrPrefixPos;
    public WriteData mData;
    public String mDisableAudioMessage;
    public EBusinessProtocolView mEBusinessProtocolView;
    public final View.OnClickListener mEditOnClicked;
    public EditorTools mEditor;
    public CustomMessageListener mEvaluateRelevanceItemSelectedListener;
    public FeedBackModel mFeedBackModel;
    public WriteTipBubbleController mFindNewLinkBubbleController;
    public final View.OnFocusChangeListener mFocusChangeListener;
    public ForumSelectedView mForumSelectedView;
    public ForumTabSelectedView mForumTabSelectedView;
    public View mForumTabSelectedViewDivider;
    public String mFrom;
    public FrsTabInfoData mFrsTabList;
    public GestureDetector mGestureDetector;
    public List<ht6> mGoodsDatas;
    public ImageView mGuide;
    public final Handler mHandler;
    public final a19 mHighLightController;
    public TextView mHotTopicEdt;
    public InputMethodManager mInputManager;
    public SerializableItemInfo mIntentItemInfo;
    public int mIntentStarCount;
    public View mInterval;
    public boolean mIsReplySubPb;
    public boolean mIsWillShowBubble;
    public boolean mItemIsSchool;
    public ImageView mIvDeleteVoice;
    public LinearLayout mLayoutVoicePlay;
    public i15 mLinkTool;
    public List<HotTopicBussinessData> mList;
    public ListView mListView;
    public xt4 mLoadingDialog;
    public LocalChannelTopicSelectView mLocalChannelTopicSelectView;
    public LocationModel mLocationModel;
    public int mLocationState;
    public String mMoreForumImg;
    public String mMoreForumTitle;
    public String mMoreForumUrl;
    public TextView mName;
    public ImageView mNameIcon;
    public View mNameLayout;
    public NavigationBar mNavigationBar;
    public TextWatcher mOldContentTextWatcher;
    public TextWatcher mOldTitleTextWatcher;
    public final b19.b mOnItemDeleteListener;
    public final LocationModel.e mOnLocationCallBack;
    public WriteTipBubbleController.b mOnNewLinkBubbleClickListener;
    public final NewWriteModel.g mOnPostWriteCallback;
    public final CustomMessageListener mOnSelectLocationListener;
    public RelativeLayout mParent;
    public GridView mPhotoLiveGridView;
    public u09 mPhotoLiveGridViewAdapter;
    public nz5 mPiefixTipController;
    public TextView mPost;
    public SpanGroupEditText mPostContent;
    public View mPostContentBg;
    public LinearLayout mPostContentContainer;
    public TextView mPostContentCounter;
    public EditText mPostTitle;
    public PostTopicData mPostTopicData;
    public TextView mPrefix;
    public PostPrefixData mPrefixData;
    public ImageView mPrefixIcon;
    public ArrayList<WritePrefixItemLayout> mPrefixItems;
    public jz8 mPrefixWindow;
    public LinearLayout mProtocol;
    public TextView mProtocolInfo;
    public ImageView mProtocolTag;
    public Dialog mRecDialog;
    public TbImageView mRecImgView;
    public RichTextEditor mRichPostContent;
    public View mRootView;
    public SelectForumData mSelectForumData;
    public final CustomMessageListener mSelectForumListener;
    public String mSubUserName;
    public p55 mSwanappReturnProductDateListener;
    public e19 mTipController;
    public TextView mTitleOverPlusNumber;
    public String mTitleTemp;
    public LinearLayout mTitleView;
    public View mTitleViewDivider;
    public Toast mTooManyEmotionToast;
    public LinearLayout mToolView;
    public FeedBackTopListView mTopListView;
    public String mTopicId;
    public CustomMessageListener mUegValidateListener;
    public final HttpMessageListener mUpdateBubbleListener;
    public HeadImageView mUserHeaderPortrait;
    public VoiceManager mVoiceManager;
    public VoiceData.VoiceModel mVoiceModel;
    public PlayVoiceBntNew mVoicePlayButton;
    public RelativeLayout mVoteLayoutRoot;
    public p19 mVoteViewController;
    public TextWatcher mWriteContentTextWatcher;
    public WriteEvaluationHeaderView mWriteEvaluationeHeaderView;
    public g19 mWriteImageController;
    public ym8 mWriteModel;
    public TextWatcher mWriteTitleTextWatcher;
    public a09 mWriteTool;
    public boolean needAddHotTopicSign;
    public boolean needClosePrePage;
    public CustomMessageListener openMoreToolListener;
    public int originalMargin;
    public String photoName;
    public CustomMessageListener postWorkVideoAsyncListener;
    public View post_prefix_layout;
    public View prefix_divider;
    public int privateThread;
    public long recTimeStamp;
    public boolean richModeEnable;
    public RichGuideHollowView richModeGuideHollowView;
    public View richModeGuideLayout;
    public TBLottieAnimationView richModeGuideLottieView;
    public RelativeLayout richModeGuideMain;
    public TextView richModeTextGuide1;
    public TextView richModeTextGuide2;
    public TextView richModeTextGuide3;
    public TextView richModeTextGuide4;
    public lr4 saveDraftDialog;
    public SaveDraftDialogView saveDraftDialogView;
    public boolean showHomepageTestIcon;
    public Serializable voteDataSerializable;
    public WriteImagesInfo writeImagesInfo;
    public String writeImagesInfoString;
    public ScrollView write_scrollview;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(WriteActivity writeActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedSelectLocation)) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    this.a.mLocationModel.P(false);
                    this.a.mLocationModel.O(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    this.a.sendLocaionAction(2, true, responsedSelectLocation.getName());
                    return;
                }
                this.a.mLocationModel.P(true);
                this.a.sendLocaionAction(0, true, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public a0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.stopTask();
                this.a.popupSaveDraftDialog();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a1 extends hg<fo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ WriteActivity b;

        public a1(WriteActivity writeActivity, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = writeActivity;
            this.a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.hg
        public void onLoaded(fo foVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, foVar, str, i) == null) {
                super.onLoaded((a1) foVar, str, i);
                if (foVar == null || foVar.p() == null || foVar.o() == null) {
                    return;
                }
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), foVar.p(), foVar.p().getNinePatchChunk(), foVar.o(), null);
                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                    ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                }
                if (this.b.isLivePhotoType) {
                    this.b.live_post_content.setBackgroundDrawable(ninePatchDrawable);
                } else {
                    this.b.mPostContentBg.setBackgroundDrawable(ninePatchDrawable);
                }
                if (this.a) {
                    nk8.c(this.b.getPageContext(), this.b.getRealContentEdittextInstance(), true, this.b.mBubbleTipRefreshCallback);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001353, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(WriteActivity writeActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.showToast((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public b0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(this.a.getPageContext().getPageActivity())));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b1 implements nk8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public b1(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.repackage.nk8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.mBubbleUrl = null;
                this.a.refreshBubble(false);
                this.a.mEditor.A(new i05(2, 12, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(WriteActivity writeActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage instanceof BackgroundSwitchMessage) || ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                return;
            }
            this.a.checkClipboardAndShowNewLinkBubble();
        }
    }

    /* loaded from: classes4.dex */
    public class c0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public c0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.richModeGuideLayout.setVisibility(8);
                this.a.richModeGuideLottieView.cancelAnimation();
                if (this.a.getRealTitleInstance().isFocused()) {
                    WriteActivity writeActivity = this.a;
                    writeActivity.ShowSoftKeyPad(writeActivity.mInputManager, this.a.getRealTitleInstance());
                } else if (this.a.getRealContentEdittextInstance().isFocused()) {
                    WriteActivity writeActivity2 = this.a;
                    writeActivity2.ShowSoftKeyPad(writeActivity2.mInputManager, this.a.getRealContentEdittextInstance());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c1 implements TbFaceManager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public c1(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), fo.class);
                fo foVar = runTask != null ? (fo) runTask.getData() : null;
                if (foVar == null) {
                    return null;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(foVar.p());
                int r = foVar.r();
                if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                    bitmapDrawable.setBounds(0, 0, r, foVar.m());
                } else {
                    bitmapDrawable.setBounds(0, 0, r, r);
                }
                bitmapDrawable.setGravity(119);
                return new bu4(bitmapDrawable, 0);
            }
            return (ImageSpan) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(WriteActivity writeActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.clearDraft();
                this.a.setResult(100);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public d0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                vt4.k().u("key_rich_mode_guide_has_show", true);
                WriteActivity writeActivity = this.a;
                writeActivity.HidenSoftKeyPad(writeActivity.mInputManager, this.a.getRealTitleInstance());
                WriteActivity writeActivity2 = this.a;
                writeActivity2.HidenSoftKeyPad(writeActivity2.mInputManager, this.a.getRealContentEdittextInstance());
                this.a.richModeGuideLottieView.playAnimation();
                this.a.richModeGuideLayout.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d1 implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public d1(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.mAdapter != null && (this.a.mAdapter.getItem(i) instanceof mo4)) {
                mo4 mo4Var = (mo4) this.a.mAdapter.getItem(i);
                int i2 = mo4Var.b;
                if (i2 == 1) {
                    if (mo4Var.o == 1) {
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{mo4Var.g});
                        return;
                    }
                    UrlManager urlManager = UrlManager.getInstance();
                    TbPageContext<WriteActivity> pageContext = this.a.getPageContext();
                    urlManager.dealOneLink(pageContext, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + ni.getUrlEncode(mo4Var.g)});
                } else if (i2 == 2) {
                    if (!TextUtils.isEmpty(mo4Var.j)) {
                        if (mo4Var.j.startsWith("tiebaclient://")) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, mo4Var.j));
                            return;
                        }
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(mo4Var.j));
                        intent.addFlags(268468224);
                        if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                            this.a.startActivity(intent);
                        } else if (TextUtils.isEmpty(mo4Var.k)) {
                        } else {
                            UrlManager urlManager2 = UrlManager.getInstance();
                            TbPageContext<WriteActivity> pageContext2 = this.a.getPageContext();
                            urlManager2.dealOneLink(pageContext2, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + ni.getUrlEncode(mo4Var.k)});
                        }
                    } else if (TextUtils.isEmpty(mo4Var.k)) {
                    } else {
                        UrlManager urlManager3 = UrlManager.getInstance();
                        TbPageContext<WriteActivity> pageContext3 = this.a.getPageContext();
                        urlManager3.dealOneLink(pageContext3, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + ni.getUrlEncode(mo4Var.k)});
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(WriteActivity writeActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof EvaluateRelevanceItemSelectedMessage)) {
                this.a.setupRelevanceItemSelected((EvaluateRelevanceItemSelectedMessage) customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public e0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.richModeGuideLayout.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public e1(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.fromErrorDialog) {
                this.a.mOnPostWriteCallback.callback(false, an8.c, an8.d, an8.e, an8.f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public f(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.mEditor.A(new i05(5, -1, null));
                int emotionCheck = this.a.emotionCheck();
                if (emotionCheck < 0 || emotionCheck >= this.a.mPostContent.getText().length()) {
                    return;
                }
                this.a.mPostContent.setSelection(emotionCheck);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f0 implements AssociatedItemContainer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public f0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.baidu.tieba.write.view.AssociatedItemContainer.b
        public void a(ItemData itemData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, itemData) == null) {
                this.a.mData.removeItemData(itemData);
                if (ListUtils.isEmpty(this.a.mData.getItemDatas())) {
                    this.a.changeToolButtonStatus();
                    this.a.associatedItemContainer.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public f1(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oi.w(this.a.getActivity(), this.a.getCurrentFocus());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public g(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                this.a.sendLocaionAction(0, true, null);
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g0(WriteActivity writeActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                WriteActivity writeActivity = this.a;
                if (writeActivity.mData == null || !writeActivity.canGoods) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_SHOW).param("obj_locate", 1).param("fid", this.a.mData.getForumId()).param("fname", this.a.mData.getForumName()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public g1(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.mPhotoLiveGridViewAdapter.notifyDataSetChanged();
                this.a.mPhotoLiveGridView.invalidateViews();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public h(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                if (mi.z()) {
                    this.a.sendLocaionAction(1, true, null);
                    this.a.mLocationModel.N();
                } else {
                    this.a.mOnLocationCallBack.a();
                }
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h0 implements AssociatedItemContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public h0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.baidu.tieba.write.view.AssociatedItemContainer.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                if (this.a.imageGridView.getVisibility() == 0) {
                    this.a.changeAssociatedItemContainerLayoutParams(true);
                } else {
                    this.a.changeAssociatedItemContainerLayoutParams(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h1 extends BdAsyncTask<Void, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public h1(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                FileHelper.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + this.a.photoName));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public i(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (view2 == this.a.mPostTitle || view2 == this.a.mBack || view2 == this.a.mPost) {
                    if (z) {
                        this.a.isDisalbeButtons = true;
                        this.a.changeToolButtonStatus();
                        oi.L(this.a.getActivity(), this.a.mPostTitle);
                        if (this.a.mEditor != null) {
                            this.a.mEditor.q();
                        }
                    } else if (view2 == this.a.mPostTitle) {
                        this.a.mPrefix.setVisibility(0);
                    }
                }
                if (view2 == this.a.mPostContent) {
                    if (z) {
                        this.a.isDisalbeButtons = false;
                        this.a.changeToolButtonStatus();
                        oi.L(this.a.getActivity(), this.a.mPostContent);
                        if (this.a.mEditor != null) {
                            this.a.mEditor.q();
                        }
                    }
                } else if (view2 instanceof SpanGroupEditText) {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f090ffe);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        this.a.isDisalbeButtons = false;
                        this.a.changeToolButtonStatus();
                        oi.L(this.a.getActivity(), view2);
                        if (this.a.mEditor != null) {
                            this.a.mEditor.q();
                        }
                    }
                }
                this.a.updateHintTextColor();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i0 implements WriteEvaluationHeaderView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public i0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.b
        public void a(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
                if (TextUtils.isEmpty(this.a.mPostContent.getText()) || this.a.mPostContent.getText().length() < 20 || this.a.mPostContent.getText().length() > 500 || f <= 0.0f) {
                    this.a.mPost.setEnabled(false);
                } else {
                    this.a.mPost.setEnabled(true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i1 extends InsertGalleryAsyncTask.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public i1(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            }
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && new File(str).exists() && this.a.writeImagesInfo != null) {
                this.a.writeImagesInfo.clear();
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(str);
                imageFileInfo.isFromMoreForum = true;
                this.a.writeImagesInfo.addChooseFile(imageFileInfo);
                this.a.writeImagesInfo.setMaxImagesAllowed(1);
                this.a.addChooseFileOnRichTextMode(imageFileInfo);
                this.a.refreshMutiImage(true);
                this.a.refreshVideoLauncher();
                this.a.refreshImageLauncher();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends p55<GoodsEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity c;

        public j(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = writeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.i55
        /* renamed from: a */
        public boolean onEvent(GoodsEvent goodsEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, goodsEvent)) == null) {
                if (goodsEvent == null) {
                    return false;
                }
                this.c.parseProductData(goodsEvent.getGoodsList());
                goodsEvent.setDispost(true);
                this.c.changeToolButtonStatus();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class j0 implements WriteEvaluationHeaderView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public j0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.c
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.mPost.setEnabled(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public j1(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.latestPic == null) {
                return;
            }
            WriteActivity writeActivity = this.a;
            writeActivity.chooseRecommendPic(writeActivity.latestPic.getAbsolutePath());
        }
    }

    /* loaded from: classes4.dex */
    public class k implements b19.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public k(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.repackage.b19.b
        public void a(List<mo4> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.a.setProtocolVisibility(list);
            }
        }

        @Override // com.repackage.b19.b
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.a.mPostContent == null) {
                return;
            }
            this.a.mPostContent.f(i);
        }
    }

    /* loaded from: classes4.dex */
    public class k0 extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public k0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                rg.i(this.a.mEBusinessProtocolView, this.a);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k1 implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public k1(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) && this.a.isAttach) {
                oi.w(this.a.getPageContext().getPageActivity(), this.a.getCurrentFocus());
                this.a.recTimeStamp = System.currentTimeMillis();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public l(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                WriteActivity writeActivity = this.a;
                writeActivity.showToast(writeActivity.mDisableAudioMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* loaded from: classes4.dex */
        public class a implements cr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(l0 l0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {l0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.cr4.e
            public void onClick(cr4 cr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                    vt4 k = vt4.k();
                    k.u(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", true);
                    cr4Var.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements cr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(l0 l0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {l0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.cr4.e
            public void onClick(cr4 cr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                    vt4 k = vt4.k();
                    k.u(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false);
                    cr4Var.dismiss();
                }
            }
        }

        public l0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.isAgreedProtocol) {
                    this.a.isAgreedProtocol = false;
                    this.a.mProtocolTag.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809d7, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                } else {
                    this.a.isAgreedProtocol = true;
                    this.a.mProtocolTag.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08082e, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                }
                vt4 k = vt4.k();
                if (k.h(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false) || !this.a.isAgreedProtocol) {
                    return;
                }
                cr4 cr4Var = new cr4(this.a);
                cr4Var.setNegativeTextColor(R.color.CAM_X0105);
                cr4Var.setTitle("");
                cr4Var.setMessage(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0ef0));
                cr4Var.setContentViewSize(1);
                cr4Var.setPositiveButton("同意", new a(this));
                cr4Var.setNegativeButton(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL, new b(this));
                cr4Var.create(this.a.getPageContext()).show();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public l1(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.mEditor == null || this.a.mEditor.a == null) {
                return;
            }
            String clipBoardContent = UtilHelper.getClipBoardContent();
            if (ni.isEmpty(clipBoardContent) || !UrlManager.getInstance().isUrlValid(clipBoardContent)) {
                return;
            }
            if (this.a.mFindNewLinkBubbleController == null) {
                WriteActivity writeActivity = this.a;
                writeActivity.mFindNewLinkBubbleController = new WriteTipBubbleController(writeActivity.getPageContext(), this.a.mOnNewLinkBubbleClickListener);
            }
            View s = this.a.mEditor.a.s(31);
            WriteTipBubbleController writeTipBubbleController = this.a.mFindNewLinkBubbleController;
            writeTipBubbleController.d(s, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0618) + "\n" + clipBoardContent, clipBoardContent, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public m(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) && z) {
                this.a.isPhotoliveTitleHasFocus = true;
                this.a.isDisalbeButtons = true;
                this.a.changeToolButtonStatus();
                if (this.a.mEditor != null) {
                    this.a.mEditor.q();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m0 implements EBusinessProtocolView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public m0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.baidu.tieba.view.EBusinessProtocolView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    if (this.a.isAgreedProtocol) {
                        return;
                    }
                    this.a.isAgreedProtocol = true;
                    this.a.mProtocolTag.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08082e, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                } else if (this.a.isAgreedProtocol) {
                    this.a.isAgreedProtocol = false;
                    this.a.mProtocolTag.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809d7, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr4 a;
        public final /* synthetic */ WriteActivity b;

        public m1(WriteActivity writeActivity, cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity, cr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = writeActivity;
            this.a = cr4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            cr4 cr4Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (cr4Var = this.a) == null) {
                return;
            }
            cr4Var.dismiss();
            vt4.k().u("commodity_goods_show_first_dialog", true);
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_CLICK).param("obj_locate", 2);
            WriteData writeData = this.b.mData;
            StatisticItem param2 = param.param("fid", writeData != null ? writeData.getForumId() : "");
            WriteData writeData2 = this.b.mData;
            TiebaStatic.log(param2.param("fname", writeData2 != null ? writeData2.getForumName() : ""));
            String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=" + this.b.getStillCommodityNum()));
        }
    }

    /* loaded from: classes4.dex */
    public class n implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public n(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) && z) {
                this.a.isPhotoliveTitleHasFocus = false;
                this.a.isDisalbeButtons = false;
                this.a.changeToolButtonStatus();
                if (this.a.mEditor != null) {
                    this.a.mEditor.q();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public n0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.showTipWindow();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public n1(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements PhotoLiveLinearLayout.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public o(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.updateGridView();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o0 implements TabMenuPopView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public o0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view2, ef6 ef6Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view2, ef6Var) == null) || ef6Var == null) {
                return;
            }
            this.a.mCategoryView.setText(ef6Var.a);
            this.a.mData.setCategoryTo(ef6Var.b);
            this.a.mCategoryToID = ef6Var.b;
            this.a.mCategoryView.c();
        }
    }

    /* loaded from: classes4.dex */
    public class o1 implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public o1(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || customMessage.getData() == null || !customMessage.getData().booleanValue()) {
                    return null;
                }
                BdTopToast bdTopToast = new BdTopToast(this.a);
                bdTopToast.i(false);
                bdTopToast.h(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f14a6));
                bdTopToast.j((ViewGroup) this.a.mRootView);
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public p(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.mEditor == null || this.a.mEditor.a == null) {
                return;
            }
            if (this.a.mCommodityTipController == null) {
                WriteActivity writeActivity = this.a;
                writeActivity.mCommodityTipController = new z09(writeActivity.getPageContext());
            }
            this.a.mCommodityTipController.b(this.a.mEditor.a.s(2));
        }
    }

    /* loaded from: classes4.dex */
    public class p0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public p0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.mCategoryView.e();
                WriteActivity writeActivity = this.a;
                writeActivity.HidenSoftKeyPad(writeActivity.mInputManager, this.a.getRealTitleInstance());
                WriteActivity writeActivity2 = this.a;
                writeActivity2.HidenSoftKeyPad(writeActivity2.mInputManager, this.a.getRealContentEdittextInstance());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p1 implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public p1(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.b
        public void a(View view2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view2, str) == null) || this.a.mFindNewLinkBubbleController == null) {
                return;
            }
            TiebaStatic.log("c13802");
            this.a.mFindNewLinkBubbleController.c();
            UtilHelper.clearClipBoard();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddLinkActivityConfig(this.a.getActivity(), 25049, str, false, null)));
        }
    }

    /* loaded from: classes4.dex */
    public class q implements j05 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* loaded from: classes4.dex */
        public class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
            public void onPermissionsGranted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    vt4.k().u("key_post_thread_has_request_location", true);
                }
            }
        }

        public q(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.repackage.j05
        public void onAction(i05 i05Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, i05Var) == null) || i05Var == null) {
                return;
            }
            int i = i05Var.a;
            if (i == 16) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 9));
                if (this.a.isTextFull()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0cf0);
                    return;
                }
                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getPageContext().getPageActivity(), 12004, true);
                if (this.a.richModeEnable && this.a.isRichTextEditorMode) {
                    atListActivityConfig.setSelectedAtList(this.a.mRichPostContent.getAtDataInText());
                } else if (this.a.getRealContentEdittextInstance() instanceof SpanGroupEditText) {
                    atListActivityConfig.setSelectedAtList(((SpanGroupEditText) this.a.getRealContentEdittextInstance()).getAtDataInText());
                }
                this.a.sendMessage(new CustomMessage(2002001, atListActivityConfig));
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            } else if (i == 14 || i == 48) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 1));
                this.a.openImageActivity(i05Var);
            } else if (i == 60) {
                this.a.openVideoActivity(i05Var);
            } else if (i == 24) {
                Object obj = i05Var.c;
                if (obj == null || !(obj instanceof zw4)) {
                    return;
                }
                zw4 zw4Var = (zw4) obj;
                if (zw4Var.getType() == EmotionGroupType.BIG_EMOTION || zw4Var.getType() == EmotionGroupType.USER_COLLECT) {
                    if (this.a.mCurrentPermissionJudgePolicy == null) {
                        this.a.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
                    }
                    this.a.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
                    this.a.mCurrentPermissionJudgePolicy.appendRequestPermission(this.a, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.mCurrentPermissionJudgePolicy.startRequestPermission(this.a)) {
                        return;
                    }
                    if (this.a.writeImagesInfo.size() >= this.a.writeImagesInfo.getMaxImagesAllowed()) {
                        this.a.showToast(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0a94), Integer.valueOf(this.a.writeImagesInfo.getMaxImagesAllowed())));
                        return;
                    }
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    imageFileInfo.setImageType(1);
                    imageFileInfo.setFilePath(zw4Var.c());
                    imageFileInfo.width = zw4Var.g();
                    imageFileInfo.height = zw4Var.b();
                    this.a.writeImagesInfo.addChooseFile(imageFileInfo);
                    this.a.writeImagesInfo.updateQuality();
                    this.a.addChooseFileOnRichTextMode(imageFileInfo);
                    this.a.refreshMutiImage(true);
                    this.a.refreshVideoLauncher();
                    this.a.refreshImageLauncher();
                    this.a.refreshPostButton();
                } else if (this.a.isTextFull()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0cf0);
                } else {
                    this.a.insertFaceIconToEditText(zw4Var);
                }
            } else if (i == 3) {
                this.a.deleteChar();
            } else if (i == 10) {
                Object obj2 = i05Var.c;
                if (obj2 instanceof VoiceData.VoiceModel) {
                    this.a.addVoice((VoiceData.VoiceModel) obj2);
                    this.a.refreshVideoLauncher();
                }
            } else if (i == 11) {
                this.a.deleteVoice();
                this.a.refreshVideoLauncher();
            } else if (i == 12 || i == 13 || i == 46 || i == 49) {
                this.a.refreshImageLauncher();
                this.a.refreshVideoLauncher();
                this.a.refreshPostButton();
            } else if (i == 15 || i == 47) {
                Object obj3 = i05Var.c;
                if (obj3 == null || !(obj3 instanceof Integer)) {
                    return;
                }
                this.a.jumpToEditImageActivity(((Integer) obj3).intValue());
            } else if (i == 18) {
                boolean h = vt4.k().h("key_post_thread_has_request_location", false);
                if (i05Var.c == null || this.a.mAdditionData != null) {
                    int i2 = this.a.mLocationState;
                    if (i2 != 0) {
                        if (i2 != 2) {
                            return;
                        }
                        this.a.goToSelectLocationActivity();
                        return;
                    }
                    Activity pageActivity = this.a.getPageContext().getPageActivity();
                    if (PermissionUtil.checkLocationForTieba(pageActivity) && h) {
                        this.a.onLocViewClickedInInitState();
                    } else {
                        PermissionUtil.requestLocation(pageActivity, 0, new a(this));
                    }
                } else if (h || this.a.isLocalChannelDynamic) {
                    this.a.requestLocationIfValid();
                }
            } else if (i == 20) {
                if (this.a.mLocationModel != null) {
                    this.a.mLocationModel.P(true);
                }
            } else {
                WriteVoteData writeVoteData = null;
                if (i == 25) {
                    Object obj4 = i05Var.c;
                    if (obj4 == null || !(obj4 instanceof String)) {
                        this.a.mBubbleUrl = null;
                    } else {
                        this.a.mBubbleUrl = (String) obj4;
                    }
                    this.a.refreshBubble(false);
                } else if (i == 29) {
                    this.a.mEditor.A(new i05(2, 19, null));
                    this.a.mEditor.A(new i05(1, 2, null));
                    this.a.refreshPostButton();
                    if (this.a.mPostContent != null) {
                        this.a.mPostContent.requestFocus();
                    }
                    this.a.mEditor.q();
                    this.a.mEditor.A(new i05(5, -1, null));
                    WriteActivity writeActivity = this.a;
                    writeActivity.ShowSoftKeyPad(writeActivity.mInputManager, this.a.mPostContent);
                } else if (i == 43) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 4));
                    vt4.k().u("hot_topic_has_click", true);
                    this.a.mEditor.A(new i05(2, 26, null));
                    this.a.needAddHotTopicSign = true;
                    this.a.performHotTopicClick(true);
                    if (!this.a.getRealTitleInstance().isFocused() || this.a.mTitleView.getVisibility() != 0) {
                        this.a.fromWhereToHotSelect = "from_content";
                    } else {
                        this.a.fromWhereToHotSelect = "from_title";
                    }
                } else if (i == 56) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 8));
                    if (this.a.mTitleView.getVisibility() == 0) {
                        if (this.a.mTitleView.hasFocus()) {
                            this.a.mPostContent.requestFocus();
                            this.a.mPostContent.setSelection(this.a.mPostContent.getText().toString().length());
                        }
                        this.a.mTitleView.setVisibility(8);
                        if (this.a.imageGridView != null) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.imageGridView.getLayoutParams();
                            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                            this.a.imageGridView.setLayoutParams(layoutParams);
                        }
                        this.a.mTitleViewDivider.setVisibility(8);
                        this.a.mEditor.m(30).setName(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f051a));
                    } else {
                        this.a.mTitleView.setVisibility(0);
                        if (this.a.imageGridView != null) {
                            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.a.imageGridView.getLayoutParams();
                            layoutParams2.topMargin = 0;
                            this.a.imageGridView.setLayoutParams(layoutParams2);
                        }
                        this.a.mTitleViewDivider.setVisibility(0);
                        this.a.mTitleView.requestFocus();
                        if (this.a.mEditor.m(30) != null) {
                            this.a.mEditor.m(30).setName(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0520));
                        }
                    }
                    this.a.refreshPostButton();
                } else if (i == 55) {
                    Object obj5 = i05Var.c;
                    if (obj5 == null || !(obj5 instanceof Boolean)) {
                        return;
                    }
                    this.a.isPrivacy = ((Boolean) obj5).booleanValue();
                } else if (i == 58) {
                    Object obj6 = i05Var.c;
                    if (obj6 == null || !(obj6 instanceof Boolean)) {
                        return;
                    }
                    this.a.isToDynamic = ((Boolean) obj6).booleanValue();
                } else if (i == 22) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 10));
                    if (this.a.mVoteViewController != null && this.a.mVoteViewController.c() != null) {
                        writeVoteData = this.a.mVoteViewController.c();
                    }
                    this.a.jumpToVoteView(writeVoteData);
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 2));
                    this.a.hideGuideTip();
                } else if (i == 21) {
                    if (this.a.mFindNewLinkBubbleController != null) {
                        this.a.mFindNewLinkBubbleController.c();
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 5));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddLinkActivityConfig(this.a.getActivity(), 25049, "", true, null)));
                } else if (i == 59) {
                    this.a.onCommodityClick();
                } else if (i == 61) {
                    this.a.onItemToolClick();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q0 implements TimePickerDialog.OnTimeSetListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public q0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, timePicker, i, i2) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q1 implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* loaded from: classes4.dex */
        public class a implements cr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(q1 q1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {q1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.cr4.e
            public void onClick(cr4 cr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                    cr4Var.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements cr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ q1 a;

            public b(q1 q1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {q1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = q1Var;
            }

            @Override // com.repackage.cr4.e
            public void onClick(cr4 cr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                    cr4Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 1)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 1));
                }
            }
        }

        public q1(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, qx4 qx4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, qx4Var, writeData, antiData}) == null) {
                this.a.stopVoice();
                this.a.closeLoadingDialog();
                this.a.isProcessedSaveDraft = true;
                if (postWriteCallBackData != null) {
                    WriteActivity writeActivity = this.a;
                    if (writeActivity.mData == null) {
                        return;
                    }
                    writeActivity.mHighLightController.n(null);
                    if (z) {
                        this.a.sendFinishSendAction(z);
                        if (this.a.canShowSuccessTip(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(this.a.mFrom)) {
                            this.a.showTipDialog(true, postWriteCallBackData);
                        }
                        o09.f(this.a.mData);
                        this.a.clearDraft();
                        if ((this.a.mData.getType() == 0 || this.a.mData.getType() == 9 || this.a.mData.getType() == 11) && !ListUtils.isEmpty(this.a.mList) && !StringUtils.isNull(this.a.mTopicId)) {
                            TiebaStatic.log(new StatisticItem("c11731").param("obj_id", this.a.mTopicId));
                        }
                        this.a.sendUpdatePhotoLiveMessage(postWriteCallBackData);
                        if (!ni.isEmpty(postWriteCallBackData.getVideoid()) && this.a.mData.getVideoInfo() != null) {
                            if (!ni.isEmpty(this.a.mData.getForumName())) {
                                postWriteCallBackData.mFrom = 2;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001374, postWriteCallBackData));
                        } else {
                            Intent intent = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                            intent.putExtras(bundle);
                            this.a.setResult(-1, intent);
                        }
                        this.a.finish();
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        this.a.showToast(postWriteCallBackData.getErrorString());
                        this.a.mHighLightController.n(postWriteCallBackData.getSensitiveWords());
                        this.a.mHighLightController.o(postWriteCallBackData.getErrorString());
                        this.a.mHighLightController.i(this.a.mPostTitle, this.a.mPostContent);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (ni.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0466), null).u();
                        } else {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        cr4 cr4Var = new cr4(this.a.getActivity());
                        if (ni.isEmpty(postWriteCallBackData.getErrorString())) {
                            cr4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0cc9));
                        } else {
                            cr4Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new a(this));
                        cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0ccb, new b(this));
                        cr4Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 1));
                    } else if ((qx4Var == null || writeData == null || qx4Var.c() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001 && !as8.c(postWriteCallBackData.getErrorCode())) {
                        this.a.showTipDialog(false, postWriteCallBackData);
                    } else if (qx4Var != null && writeData != null && qx4Var.c() != null) {
                        if (writeData.isCanNoForum()) {
                            writeData.setForumName("");
                            writeData.setForumId("0");
                        }
                        writeData.setVcodeMD5(qx4Var.b());
                        writeData.setVcodeUrl(qx4Var.c());
                        writeData.setVcodeExtra(qx4Var.a());
                        if (qd5.b(qx4Var.d())) {
                            NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(this.a.getPageContext().getPageActivity(), 12006, writeData, false, qx4Var.d());
                            if (this.a.isVcodeFeedBack) {
                                newVcodeActivityConfig.setHideFeedBackButton();
                            }
                            this.a.sendMessage(new CustomMessage(2002001, newVcodeActivityConfig));
                            return;
                        }
                        this.a.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.getPageContext().getPageActivity(), writeData, 12006)));
                    } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    } else {
                        this.a.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteVoteData a;
        public final /* synthetic */ WriteActivity b;

        public r(WriteActivity writeActivity, WriteVoteData writeVoteData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity, writeVoteData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = writeActivity;
            this.a = writeVoteData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.jumpToVoteView(this.a);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 3));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r0(WriteActivity writeActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SelectForumData selectForumData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.mForumSelectedView == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof SelectForumData) || (selectForumData = (SelectForumData) customResponsedMessage.getData()) == null || StringUtils.isNull(selectForumData.forumId) || StringUtils.isNull(selectForumData.forumName)) {
                return;
            }
            this.a.initSelectForumData(selectForumData);
        }
    }

    /* loaded from: classes4.dex */
    public class r1 implements LocationModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public r1(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c4e);
                this.a.sendLocaionAction(0, true, null);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b(LocationData locationData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locationData) == null) {
                if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                    this.a.sendLocaionAction(2, true, locationData.getFormatted_address());
                } else {
                    onFail(null);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                WriteActivity writeActivity = this.a;
                if (StringUtils.isNull(str)) {
                    str = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a42);
                }
                writeActivity.showToast(str);
                this.a.sendLocaionAction(0, true, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public s(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091bdc) {
                this.a.clearDraft();
                this.a.setResult(100);
                this.a.finish();
            } else if (id == R.id.obfuscated_res_0x7f091bdd) {
                this.a.processSaveDraft();
                this.a.setResult(100);
                this.a.finish();
            }
            this.a.saveDraftDialog.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class s0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public s0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c13013").param("fid", this.a.mData.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                this.a.mPrefix.setVisibility(0);
                this.a.post_prefix_layout.setSelected(true);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.mPrefixIcon, R.drawable.obfuscated_res_0x7f080909, R.color.CAM_X0105, null);
                rg.l(this.a.mPrefixWindow, view2, 0, oi.d(this.a.getPageContext().getPageActivity(), 1.0f));
                this.a.mEditor.q();
                WriteActivity writeActivity = this.a;
                writeActivity.HidenSoftKeyPad(writeActivity.mInputManager, this.a.mPostTitle);
                WriteActivity writeActivity2 = this.a;
                writeActivity2.HidenSoftKeyPad(writeActivity2.mInputManager, this.a.mPostContent);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s1 extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public s1(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                oi.w(this.a.getActivity(), this.a.getCurrentFocus());
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
            return invokeCommon.booleanValue;
        }

        public /* synthetic */ s1(WriteActivity writeActivity, k kVar) {
            this(writeActivity);
        }
    }

    /* loaded from: classes4.dex */
    public class t implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public t(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.refreshPostButton();
                this.a.updateTitleStyle();
                EditText realTitleInstance = this.a.getRealTitleInstance();
                if (editable == null || realTitleInstance == null || realTitleInstance.getText() == null) {
                    return;
                }
                if (this.a.mTitleTemp == null || !this.a.mTitleTemp.equals(editable.toString())) {
                    if (this.a.mHighLightController != null) {
                        this.a.mTitleTemp = realTitleInstance.getText().toString();
                        this.a.mHighLightController.j(realTitleInstance, true);
                        return;
                    }
                    return;
                }
                realTitleInstance.setSelection(realTitleInstance.getSelectionEnd());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                this.a.beforeText = charSequence != null ? charSequence.toString() : "";
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                if ((charSequence != null ? charSequence.toString().length() : 0) > (this.a.beforeText != null ? this.a.beforeText.length() : 0)) {
                    this.a.gotoHotTopicSelectActivity(charSequence, i, i3, "from_title");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public t0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c13013").param("fid", this.a.mData.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                this.a.mPrefix.setSelected(true);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.mPrefixIcon, R.drawable.obfuscated_res_0x7f080909, R.color.CAM_X0105, null);
                rg.l(this.a.mPrefixWindow, view2, 0, oi.d(this.a.getPageContext().getPageActivity(), 1.0f));
                this.a.mEditor.q();
                WriteActivity writeActivity = this.a;
                writeActivity.HidenSoftKeyPad(writeActivity.mInputManager, this.a.getRealTitleInstance());
                WriteActivity writeActivity2 = this.a;
                writeActivity2.HidenSoftKeyPad(writeActivity2.mInputManager, this.a.getRealContentEdittextInstance());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ WriteActivity c;

        public u(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = writeActivity;
            this.a = "";
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.c.refreshPostButton();
                EditText realContentEdittextInstance = this.c.getRealContentEdittextInstance();
                if (editable == null || realContentEdittextInstance == null || realContentEdittextInstance.getText() == null) {
                    return;
                }
                String str = this.a;
                if (str == null || !str.equals(editable.toString())) {
                    if (this.c.mHighLightController != null) {
                        this.a = realContentEdittextInstance.getText().toString();
                        this.c.mHighLightController.j(realContentEdittextInstance, false);
                    }
                    if (this.c.isEvaluate) {
                        this.c.addEvaluateTextChangeOperation(editable);
                        return;
                    }
                    return;
                }
                realContentEdittextInstance.setSelection(realContentEdittextInstance.getSelectionEnd());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                this.b = charSequence != null ? charSequence.toString() : "";
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                String str = this.b;
                if ((charSequence != null ? charSequence.toString().length() : 0) > (str != null ? str.length() : 0)) {
                    this.c.gotoHotTopicSelectActivity(charSequence, i, i3, "from_content");
                    this.c.gotoAtSelectActivity(charSequence, i, i3);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u0 extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public u0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.hideProgressBar();
                if (obj == null || !(obj instanceof FeedBackModel)) {
                    this.a.mTopListView.setVisibility(8);
                    this.a.feedback_divider.setVisibility(8);
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c17);
                    return;
                }
                FeedBackModel feedBackModel = (FeedBackModel) obj;
                if (feedBackModel.C() != 0) {
                    this.a.mTopListView.setVisibility(8);
                    this.a.feedback_divider.setVisibility(8);
                    return;
                }
                this.a.mTopListView.c(feedBackModel.D(), this.a.getPageContext());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(WriteActivity writeActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.a.mBubbleUrl)) {
                    this.a.mBubbleUrl = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    this.a.refreshBubble(true);
                } else if (TextUtils.isEmpty(str) || str.equals(this.a.mBubbleUrl)) {
                } else {
                    this.a.mBubbleUrl = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(this.a.mBubbleUrl);
                    this.a.refreshBubble(true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public v0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.isEvaluate || (!TextUtils.isEmpty(this.a.mPostTitle.getText().toString()) && this.a.mPostTitle.getText().toString().trim().length() >= 5)) {
                    if ((this.a.richModeEnable || this.a.mForumSelectedView == null || this.a.mSelectForumData != null) && (!this.a.richModeEnable || this.a.mSelectForumData != null || !TextUtils.isEmpty(this.a.mData.getForumName()))) {
                        if (this.a.checkCanGoodsConsistent()) {
                            if (!this.a.isProductTie || this.a.isAgreedProtocol) {
                                if (this.a.checkContainHaowuTab()) {
                                    int checkTabConsistent = this.a.checkTabConsistent();
                                    if (checkTabConsistent == 1) {
                                        this.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f13ff));
                                        return;
                                    } else if (checkTabConsistent == 2) {
                                        this.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1400));
                                        return;
                                    }
                                }
                                if (!mi.z()) {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c17);
                                }
                                if (gd5.b()) {
                                    return;
                                }
                                if (this.a.mHighLightController.b(this.a.mPostTitle, this.a.mPostContent)) {
                                    WriteActivity writeActivity = this.a;
                                    writeActivity.showToast(writeActivity.mHighLightController.e());
                                    return;
                                }
                                WriteActivity writeActivity2 = this.a;
                                writeActivity2.HidenSoftKeyPad(writeActivity2.mInputManager, this.a.getRealTitleInstance());
                                WriteActivity writeActivity3 = this.a;
                                writeActivity3.HidenSoftKeyPad(writeActivity3.mInputManager, this.a.getRealContentEdittextInstance());
                                this.a.mEditor.q();
                                if (this.a.mData.getType() != 7) {
                                    if (this.a.isFeedBack) {
                                        this.a.postNewMessage();
                                        BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                                    } else {
                                        StatisticItem statisticItem = new StatisticItem("c12102");
                                        statisticItem.param("obj_type", StringUtils.isNull(this.a.mData.getForumName()) ? 1 : 2);
                                        TiebaStatic.log(statisticItem);
                                        this.a.postPhotoTextThread();
                                    }
                                } else {
                                    TiebaStatic.log("c12015");
                                    this.a.postNewMessage();
                                }
                                MercatorModel.d().f();
                                TiebaStatic.log(new StatisticItem("c12262").param("obj_locate", this.a.mCallFrom));
                                return;
                            }
                            WriteActivity writeActivity4 = this.a;
                            writeActivity4.showToast(writeActivity4.getResources().getString(R.string.obfuscated_res_0x7f0f0ef7));
                            return;
                        }
                        this.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f13fa));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectForumConfig(this.a)));
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(this.a);
                bdTopToast.i(false);
                bdTopToast.h(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f13f2));
                bdTopToast.j((ViewGroup) this.a.mRootView);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public w(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.richModeEnable) {
                this.a.changeTextEditorMode();
                this.a.updataTitle();
                this.a.changeToolButtonStatus();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w0 implements o09.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public w0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.repackage.o09.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oi.N(TbadkCoreApplication.getInst(), String.format(this.a.getString(R.string.obfuscated_res_0x7f0f158b), 31));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public x(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 2) {
                    if (this.a.mPostContent != null) {
                        oi.w(this.a.getPageContext().getContext(), this.a.mPostContent);
                    }
                    if (this.a.mEditor != null) {
                        this.a.mEditor.q();
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class x0 implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public EditText b;
        public TextView c;
        public final /* synthetic */ WriteActivity d;

        public x0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = writeActivity;
            this.b = null;
            this.c = null;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.d.refreshPostButton();
                if (this.d.isLivePhotoType) {
                    int selectionStart = this.b.getSelectionStart();
                    this.a = selectionStart;
                    this.b.setSelection(selectionStart);
                    this.d.setLeftCount(this.c, this.b);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                if (!this.d.isLivePhotoType || !this.d.isPhotoliveTitleHasFocus) {
                    if (this.d.isLivePhotoType) {
                        if (this.b == this.d.live_post_content && this.c == this.d.mContentOverPlusNumber) {
                            return;
                        }
                        this.b = this.d.live_post_content;
                        this.c = this.d.mContentOverPlusNumber;
                    }
                } else if (this.b == this.d.live_post_title && this.c == this.d.mTitleOverPlusNumber) {
                } else {
                    this.b = this.d.live_post_title;
                    this.c = this.d.mTitleOverPlusNumber;
                }
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public y(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                view2.requestFocus();
                this.a.mEditor.A(new i05(5, -1, null));
                this.a.mPostContent.requestFocus();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y0 implements ev4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public y0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // com.repackage.ev4.a
        public void a(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                this.a.refreshListView();
                this.a.changeToolButtonStatus();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public z(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.deleteVoice();
                this.a.refreshVideoLauncher();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z0 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteActivity a;

        public z0(WriteActivity writeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    view2.requestFocus();
                    this.a.mEditor.A(new i05(5, -1, null));
                    this.a.mPostContent.requestFocus();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(554768059, "Lcom/baidu/tieba/write/write/WriteActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(554768059, "Lcom/baidu/tieba/write/write/WriteActivity;");
        }
    }

    public WriteActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.fromWhereToHotSelect = "";
        this.needAddHotTopicSign = false;
        this.mData = null;
        this.isFeedBack = false;
        this.showHomepageTestIcon = false;
        this.isFeedBackBar = false;
        this.isVcodeFeedBack = false;
        this.mInputManager = null;
        this.mPostTitle = null;
        this.mUserHeaderPortrait = null;
        this.mInterval = null;
        this.mPostContentContainer = null;
        this.mPostContent = null;
        this.mFeedBackModel = null;
        this.mTopListView = null;
        this.mPrefixItems = new ArrayList<>();
        this.mBubbleUrl = null;
        this.keyEventDown = new KeyEvent(0, 67);
        this.mNavigationBar = null;
        this.mBack = null;
        this.btn_image_problem = null;
        this.mPost = null;
        this.mName = null;
        this.mGuide = null;
        this.mHandler = new Handler();
        this.mIsReplySubPb = false;
        this.mSubUserName = null;
        this.mParent = null;
        this.isVoiceEnable = true;
        this.mDisableAudioMessage = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.mLocationState = 0;
        this.mCategoryFromID = -1;
        this.mCategoryToID = -1;
        this.liveCoverImageInfo = new WriteImagesInfo();
        this.mRootView = null;
        this.mPhotoLiveGridView = null;
        this.mPhotoLiveGridViewAdapter = null;
        this.write_scrollview = null;
        this.live_post_content = null;
        this.live_container = null;
        this.live_interval_view = null;
        this.live_post_title_container = null;
        this.live_post_title = null;
        this.mTitleOverPlusNumber = null;
        this.mContentOverPlusNumber = null;
        this.mOldTitleTextWatcher = null;
        this.mOldContentTextWatcher = null;
        this.isLivePhotoType = false;
        this.isPhotoliveTitleHasFocus = false;
        this.mLoadingDialog = null;
        this.mFrom = AlbumActivityConfig.FROM_WRITE;
        this.latestPic = null;
        this.mRecImgView = null;
        this.mBubbleView = null;
        this.mRecDialog = null;
        this.mBubbleLayout = null;
        this.isAttach = false;
        this.recTimeStamp = -1000L;
        this.hasSetTitleUseHotTopic = false;
        this.mCallFrom = "2";
        this.isAblumThread = 0;
        this.canGoods = false;
        this.mTopicId = "";
        this.mContentBuilder = new SpannableStringBuilder();
        this.mIsWillShowBubble = false;
        this.isKeyboardVisibility = false;
        this.mHighLightController = new a19();
        this.isSaveDraft = true;
        this.fromErrorDialog = false;
        this.goodsListStr = null;
        this.needClosePrePage = false;
        this.mTitleTemp = "";
        this.mOnItemDeleteListener = new k(this);
        this.isAgreedProtocol = false;
        this.isProductTie = false;
        this.mUpdateBubbleListener = new v(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
        this.openMoreToolListener = new g0(this, 2921494);
        this.mSelectForumListener = new r0(this, 2921505);
        this.mBigEmotionSpanHanlder = new c1(this);
        this.mAntiInjectListener = new n1(this);
        this.mOnNewLinkBubbleClickListener = new p1(this);
        this.mOnPostWriteCallback = new q1(this);
        this.mOnLocationCallBack = new r1(this);
        this.mOnSelectLocationListener = new a(this, 2001226);
        this.mUegValidateListener = new b(this, 2016554);
        this.mBackgroundListener = new c(this, 2001011);
        this.postWorkVideoAsyncListener = new d(this, 2921622);
        this.mEvaluateRelevanceItemSelectedListener = new e(this, 2921516);
        this.mEditOnClicked = new f(this);
        this.isDisalbeButtons = true;
        this.mFocusChangeListener = new i(this);
        this.mSwanappReturnProductDateListener = new j(this);
        this.isProcessedSaveDraft = false;
        this.mWriteTitleTextWatcher = new t(this);
        this.mWriteContentTextWatcher = new u(this);
        this.originalMargin = 0;
        this.mBubbleTipRefreshCallback = new b1(this);
        this.handleLastError = new e1(this);
    }

    private void addAssociatedItem(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65675, this, itemData) == null) {
            this.mData.addItemData(itemData);
            this.associatedItemContainer.setVisibility(0);
            this.associatedItemContainer.a(itemData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addChooseFileOnRichTextMode(ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65676, this, imageFileInfo) == null) && this.isRichTextEditorMode && imageFileInfo != null) {
            insertImageOnRichTextMode(imageFileInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEvaluateTextChangeOperation(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65677, this, editable) == null) {
            dealPostContentCounter(editable);
            refreshPostStatus(editable);
        }
    }

    private void addHotTopic(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65678, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        int i2 = -1;
        Editable editable = null;
        if ("from_content".equals(this.fromWhereToHotSelect)) {
            this.fromWhereToHotSelect = "";
            getRealContentEdittextInstance().requestFocus();
            if (getRealContentEdittextInstance().getText() != null && getRealContentEdittextInstance().getText().length() + str.length() > 5000) {
                showToast(R.string.obfuscated_res_0x7f0f0cf0);
                return;
            } else {
                i2 = getRealContentEdittextInstance().getSelectionStart();
                editable = getRealContentEdittextInstance().getText();
            }
        } else if ("from_title".equals(this.fromWhereToHotSelect)) {
            this.fromWhereToHotSelect = "";
            getRealTitleInstance().requestFocus();
            if (getRealTitleInstance().getText() != null && getRealTitleInstance().getText().length() + str.length() > 31) {
                showToast(R.string.obfuscated_res_0x7f0f0cf0);
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
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65679, this) == null) || (writeData = this.mData) == null || this.mForumTabSelectedView == null) {
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
    public void addVoice(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65680, this, voiceModel) == null) || voiceModel == null || TextUtils.isEmpty(voiceModel.voiceId) || voiceModel.duration <= 0) {
            return;
        }
        this.mVoiceModel = voiceModel;
        this.mData.setVoiceModel(voiceModel);
        this.mLayoutVoicePlay.setVisibility(0);
        this.mVoicePlayButton.setVoiceModel(voiceModel);
        this.mVoicePlayButton.o();
        refreshPostButton();
    }

    private void bindMoreForumImg() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65681, this) == null) && WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.mMoreForumImg)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                return;
            }
            InsertGalleryAsyncTask insertGalleryAsyncTask = new InsertGalleryAsyncTask(this, this.mMoreForumImg, new i1(this));
            insertGalleryAsyncTask.setFrom(1);
            insertGalleryAsyncTask.execute(new String[0]);
        }
    }

    private boolean canChangeTextEditorMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65682, this)) == null) ? ListUtils.isEmpty(this.mData.getItemDatas()) && this.mData.getVoiceModel() == null && this.mData.getVideoInfo() == null && this.mData.getWriteVoteData() == null && TextUtils.isEmpty(this.mPostContent.getText()) && (!this.isRichTextEditorMode || this.mRichPostContent.t()) && (this.writeImagesInfo.getChosedFiles() == null || this.writeImagesInfo.size() == 0) : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canShowSuccessTip(WriteData writeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65683, this, writeData)) == null) ? writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom())) : invokeL.booleanValue;
    }

    private void changeHotTopicData(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65684, this, hotTopicBussinessData) == null) || hotTopicBussinessData == null || (hotTopicBussinessData2 = (HotTopicBussinessData) ListUtils.getItem(this.mList, 0)) == null || TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            return;
        }
        SpannableString i2 = hc5.i(hc5.a(hotTopicBussinessData.mTopicName));
        if (i2 != null) {
            this.mPostTitle.setText(i2);
        }
        this.mHotTopicEdt.setText(hotTopicBussinessData.mForumName);
    }

    private void changeRichModeStatic(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65685, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CHANGE_RICH_TEXT_MODE);
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
            if (i2 == 0) {
                TiebaStatic.log(CommonStatisticKey.KEY_LIMIT_MODE_CHANGE_TOAST);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeTextEditorMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65686, this) == null) {
            if (canChangeTextEditorMode()) {
                if (this.isRichTextEditorMode) {
                    onNormalTextEditorMode();
                    changeRichModeStatic(1);
                } else {
                    onRichTextEditorMode();
                    changeRichModeStatic(2);
                }
                this.isRichTextEditorMode = !this.isRichTextEditorMode;
                showRichModeGuide();
                refreshMutiImage(true);
                return;
            }
            BdTopToast bdTopToast = new BdTopToast(this);
            bdTopToast.i(false);
            bdTopToast.h(getResources().getString(R.string.obfuscated_res_0x7f0f0515));
            bdTopToast.j((ViewGroup) this.mRootView);
            changeRichModeStatic(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkCanGoodsConsistent() {
        InterceptResult invokeV;
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65687, this)) == null) ? this.canGoods || (spanGroupEditText = this.mPostContent) == null || spanGroupEditText.getSpanGroupManager() == null || this.mPostContent.getSpanGroupManager().x() <= 0 : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkClipboardAndShowNewLinkBubble() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65688, this) == null) || (editorTools = this.mEditor) == null) {
            return;
        }
        editorTools.post(new l1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkContainHaowuTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65689, this)) == null) {
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
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int checkTabConsistent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65690, this)) == null) {
            b19 b19Var = this.mAdapter;
            boolean z2 = b19Var == null || b19Var.e();
            ForumTabSelectedView forumTabSelectedView = this.mForumTabSelectedView;
            boolean z3 = (forumTabSelectedView == null || forumTabSelectedView.getSelectedTabItemData() == null || this.mForumTabSelectedView.getSelectedTabItemData().tabType != 3) ? false : true;
            if (z2 && z3) {
                return 1;
            }
            return (z2 || z3) ? 0 : 2;
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chooseRecommendPic(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65691, this, str) == null) || ni.isEmpty(str) || this.mRecDialog == null) {
            return;
        }
        getRecommendImgData(str);
        this.mRecDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDraft() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65692, this) == null) {
            if (this.mData.getType() != 0 && this.mData.getType() != 9 && this.mData.getType() != 11) {
                if (this.mData.getType() == 1) {
                    fk8.y(this.mData.getThreadId(), null);
                }
            } else if (this.isSaveDraft) {
                if (this.isLocalChannelDynamic) {
                    fk8.v(null);
                } else if (this.mData.isEvaluate()) {
                    fk8.s(this.mData.getItem_id(), null);
                } else if (TextUtils.isEmpty(this.mData.getTopicId())) {
                    fk8.u(this.mData.getForumId(), this.mData, true);
                } else {
                    fk8.A(this.mData.getTopicId(), null);
                }
            }
            this.isProcessedSaveDraft = true;
        }
    }

    private void dealAlbumFromCamera(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65693, this, intent) == null) || this.writeImagesInfo == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65694, this, intent) == null) {
            if (this.isLivePhotoType) {
                getAlbumDataForPhotoLive(intent);
                updateGriViewData();
            } else if (this.isRichTextEditorMode) {
                getAlbumDataOnRichTextMode(intent);
            } else {
                getAlbumData(intent);
            }
            refreshPostButton();
        }
    }

    private void dealLiveCoverFromCamera() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65695, this) == null) || TbadkCoreApplication.getCurrentAccountObj() == null) {
            return;
        }
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) com.kuaishou.weapon.un.w0.I5, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
    }

    private void dealLiveCoverFromImage(Intent intent) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65696, this, intent) == null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        this.liveCoverImageInfo.parseJson(stringExtra);
        this.liveCoverImageInfo.updateQuality();
        if (this.liveCoverImageInfo.getChosedFiles() != null && this.liveCoverImageInfo.getChosedFiles().size() > 0) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) TaskResponseData.ERROR_NO_TASK_OFFLINE_03, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.liveCoverImageInfo.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
        }
        this.liveCoverImageInfo.clear();
    }

    private void dealPostContentCounter(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65697, this, editable) == null) {
            if (editable.length() > 500) {
                this.mPostContentCounter.setText((500 - editable.length()) + "/500");
                this.mPostContentCounter.setVisibility(0);
                return;
            }
            this.mPostContentCounter.setVisibility(4);
        }
    }

    private void deleteTempCameraFile() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65698, this) == null) {
            new h1(this).execute(new Void[0]);
        }
    }

    private void deleteTempVideoFile() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65699, this) == null) {
            FileHelper.deleteFileOrDir(new File(vs8.f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteVoice() {
        v05 v05Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65700, this) == null) {
            VoiceData.VoiceModel voiceModel = this.mVoiceModel;
            if (voiceModel != null) {
                tv4.a(tv4.b(voiceModel.voiceId));
            }
            this.mVoiceModel = null;
            this.mData.setVoiceModel(null);
            this.mLayoutVoicePlay.setVisibility(8);
            this.mVoicePlayButton.p();
            this.mVoicePlayButton.setVoiceModel(null);
            u05 n2 = this.mEditor.n(6);
            if (n2 != null && (v05Var = n2.k) != null) {
                v05Var.onAction(new i05(52, 0, null));
            }
            refreshPostButton();
        }
    }

    private void displayLauncherById(int i2, boolean z2) {
        EditorTools editorTools;
        p05 m2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65701, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) || (editorTools = this.mEditor) == null || (m2 = editorTools.m(i2)) == null) {
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65702, this)) == null) {
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
        return invokeV.intValue;
    }

    private void fillContent(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65703, this, writeData) == null) {
            this.mData.setContent(writeData.getContent());
            SpannableString l2 = TbFaceManager.e().l(getPageContext().getPageActivity(), this.mData.getContent(), this.mBigEmotionSpanHanlder);
            InputFilter[] filters = this.mPostContent.getFilters();
            this.mPostContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50000)});
            getRealContentEdittextInstance().setText(l2);
            EditText realContentEdittextInstance = getRealContentEdittextInstance();
            SpanGroupEditText spanGroupEditText = this.mPostContent;
            if (realContentEdittextInstance == spanGroupEditText && spanGroupEditText.getSpanGroupManager() != null) {
                this.mPostContent.h();
                this.mPostContent.getSpanGroupManager().r();
                this.mPostContent.c();
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
    }

    private void fillRichContent(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65704, this, writeData) == null) && this.richModeEnable && this.isRichTextEditorMode) {
            this.mData.setRichContentData(writeData.getRichContentData());
            this.mRichPostContent.r(writeData.getRichContentData());
        }
    }

    private void fillTitle(WriteData writeData) {
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65705, this, writeData) == null) {
            if (ni.isEmpty(this.mData.getTitle())) {
                this.mData.setTitle(writeData.getTitle());
            }
            if (!ListUtils.isEmpty(this.mList)) {
                HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) ListUtils.getItem(this.mList, 0);
                String str = hotTopicBussinessData != null ? hotTopicBussinessData.mTopicName : null;
                if (StringUtils.isNull(str)) {
                    a2 = this.mData.getTitle();
                } else {
                    a2 = hc5.a(str);
                }
                SpannableString i2 = hc5.i(a2);
                if (i2 != null) {
                    getRealTitleInstance().setText(i2);
                    int length = i2.length() > a2.length() ? a2.length() : i2.length();
                    if (length > getRealTitleInstance().getText().length()) {
                        length = getRealTitleInstance().getText().length();
                    }
                    getRealTitleInstance().setSelection(length);
                    return;
                }
                return;
            }
            SpannableString i3 = hc5.i(this.mData.getTitle());
            if (i3 != null) {
                getRealTitleInstance().setText(i3);
                int length2 = this.mData.getTitle().length() > i3.length() ? i3.length() : this.mData.getTitle().length();
                if (length2 > getRealTitleInstance().getText().length()) {
                    length2 = getRealTitleInstance().getText().length();
                }
                getRealTitleInstance().setSelection(length2);
            }
        }
    }

    private void fillVideoOrImage(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65706, this, writeData) == null) {
            if (writeData.getWriteImagesInfo() != null) {
                this.writeImagesInfo = writeData.getWriteImagesInfo();
            }
            this.mData.setWriteImagesInfo(this.writeImagesInfo);
            this.mRichPostContent.setWriteImagesInfo(this.writeImagesInfo);
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                sendSetImgAction();
            }
            refreshMutiImage(false);
            showPicOrVideo(true, true);
        }
    }

    private void getAlbumData(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65707, this, intent) == null) {
            getResImgData(intent, true);
        }
    }

    private void getAlbumDataForPhotoLive(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65708, this, intent) == null) || intent == null) {
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

    private void getAlbumDataOnRichTextMode(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65709, this, intent) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
            if (chosedFiles != null) {
                for (ImageFileInfo imageFileInfo : chosedFiles) {
                    this.writeImagesInfo.addChooseFile(imageFileInfo);
                    insertImageOnRichTextMode(imageFileInfo);
                }
            }
            refreshImageLauncher();
            refreshVideoLauncher();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                sendSetImgAction();
            }
        }
        refreshMutiImage(true);
    }

    private void getCameraData(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65710, this, intent) == null) {
            this.photoName = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
            String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.photoName;
            if (!TextUtils.isEmpty(str)) {
                try {
                    int readPictureDegree = BitmapHelper.readPictureDegree(str);
                    if (readPictureDegree != 0) {
                        Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, oi.d(getPageContext().getPageActivity(), oi.k(getPageContext().getPageActivity())), oi.d(getPageContext().getPageActivity(), oi.i(getPageContext().getPageActivity())));
                        Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                        if (loadResizedBitmap != rotateBitmapBydegree) {
                            loadResizedBitmap.recycle();
                        }
                        FileHelper.saveBitmapByRelativelyPath(TbConfig.LOCAL_CAMERA_DIR, this.photoName, rotateBitmapBydegree, 100);
                        rotateBitmapBydegree.recycle();
                    }
                } catch (Exception unused) {
                }
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(str);
                imageFileInfo.setTempFile(true);
                this.writeImagesInfo.addChooseFile(imageFileInfo);
                this.writeImagesInfo.updateQuality();
                addChooseFileOnRichTextMode(imageFileInfo);
                refreshImageLauncher();
                refreshVideoLauncher();
                sendSetImgAction();
            }
            refreshMutiImage(true);
        }
    }

    private void getCameraDataOnRichTextMode(@Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65711, this, intent) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
            if (chosedFiles != null) {
                for (ImageFileInfo imageFileInfo : chosedFiles) {
                    this.writeImagesInfo.addChooseFile(imageFileInfo);
                    insertImageOnRichTextMode(imageFileInfo);
                }
            }
            refreshImageLauncher();
            refreshVideoLauncher();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                sendSetImgAction();
            }
        }
        refreshMutiImage(true);
    }

    private String getCommonHead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65712, this)) == null) {
            ArrayList arrayList = new ArrayList();
            WriteEvaluationHeaderView writeEvaluationHeaderView = this.mWriteEvaluationeHeaderView;
            arrayList.add(new HeadItem("", String.valueOf(writeEvaluationHeaderView != null ? writeEvaluationHeaderView.getStarCount() : 0), 2));
            return new Gson().toJson(arrayList);
        }
        return (String) invokeV.objValue;
    }

    private String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65713, this)) == null) ? (getRealContentEdittextInstance() == null || getRealContentEdittextInstance().getText() == null) ? "" : getRealContentEdittextInstance().getText().toString() : (String) invokeV.objValue;
    }

    private void getDimension(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65714, this, context) == null) {
            SCREEN_HEIGHT = oi.i(context);
        }
    }

    private void getEditDataOnRichTextMode(@Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65715, this, intent) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.getChosedFiles().size() > 0) {
                ImageFileInfo imageFileInfo = writeImagesInfo.getChosedFiles().get(0);
                int originalImgIndex = writeImagesInfo.getOriginalImgIndex();
                this.writeImagesInfo.getChosedFiles().remove(originalImgIndex);
                this.writeImagesInfo.getChosedFiles().add(originalImgIndex, imageFileInfo);
                this.mRichPostContent.o(imageFileInfo, writeImagesInfo.getOriginalImgViewIndex());
                refreshImageLauncher();
                refreshVideoLauncher();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    sendSetImgAction();
                }
            }
        }
        refreshMutiImage(true);
    }

    private long getInputCount(EditText editText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65716, this, editText)) == null) ? gd5.a(editText.getText().toString().trim()) : invokeL.longValue;
    }

    private File getLatestPic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65717, this)) == null) {
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
        return (File) invokeV.objValue;
    }

    private long getMaxInpputNum(EditText editText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65718, this, editText)) == null) {
            if (editText == this.live_post_content) {
                return 233L;
            }
            return editText == this.live_post_title ? 20L : 0L;
        }
        return invokeL.longValue;
    }

    private void getMotuData(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65719, this, intent) == null) {
            getResImgData(intent, false);
        }
    }

    public static Bitmap getPreviewImg(String str, float f2) {
        InterceptResult invokeLF;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65720, null, str, f2)) == null) {
            int i2 = (int) f2;
            Bitmap bitmap2 = null;
            if (!ni.isEmpty(str) && i2 > 0) {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(str, options);
                    int i3 = options.outWidth;
                    int i4 = options.outHeight;
                    bitmap = BitmapHelper.resizeBitmapAbsolute(str, (Math.max(i3, i4) * i2) / Math.min(i3, i4));
                    try {
                        Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(bitmap, i2);
                        if (bitmap != null && bitmap != resizedBitmap && !bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                        System.gc();
                        return resizedBitmap;
                    } catch (Exception unused) {
                        if (bitmap != null && bitmap != null && !bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                        System.gc();
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        bitmap2 = bitmap;
                        if (bitmap2 != null && bitmap2 != null && !bitmap2.isRecycled()) {
                            bitmap2.recycle();
                        }
                        System.gc();
                        throw th;
                    }
                } catch (Exception unused2) {
                    bitmap = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return null;
        }
        return (Bitmap) invokeLF.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText getRealTitleInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65721, this)) == null) ? this.isLivePhotoType ? this.live_post_title : this.mPostTitle : (EditText) invokeV.objValue;
    }

    private void getRecommendImgData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65722, this, str) == null) {
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
                showToast(String.format(getPageContext().getContext().getString(R.string.obfuscated_res_0x7f0f0a94), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
                return;
            }
            this.writeImagesInfo.addChooseFileFromCamera(str);
            this.writeImagesInfo.updateQuality();
            addChooseFileOnRichTextMode(this.writeImagesInfo.getChosedFiles().getLast());
            this.isAttach = true;
            refreshImageLauncher();
            refreshVideoLauncher();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                sendSetImgAction();
            }
            refreshMutiImage(true);
        }
    }

    private void getResImgData(Intent intent, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65723, this, intent, z2) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            refreshImageLauncher();
            refreshVideoLauncher();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                sendSetImgAction();
            }
        }
        refreshMutiImage(true);
    }

    private int getStarByScore(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65724, this, new Object[]{Double.valueOf(d2)})) == null) ? (int) ((d2 + 1.0d) / 2.0d) : invokeCommon.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getStillCommodityNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65725, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.mPostContent;
            if (spanGroupEditText == null || spanGroupEditText.getSpanGroupManager() == null) {
                return 10;
            }
            return 10 - this.mPostContent.getSpanGroupManager().x();
        }
        return invokeV.intValue;
    }

    private TextWatcher getTextWatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65726, this)) == null) {
            x0 x0Var = new x0(this);
            if (this.isLivePhotoType && this.isPhotoliveTitleHasFocus) {
                TextWatcher textWatcher = this.mOldTitleTextWatcher;
                if (textWatcher != null) {
                    this.live_post_title.removeTextChangedListener(textWatcher);
                }
                this.mOldTitleTextWatcher = x0Var;
            } else if (this.isLivePhotoType) {
                TextWatcher textWatcher2 = this.mOldContentTextWatcher;
                if (textWatcher2 != null) {
                    this.live_post_content.removeTextChangedListener(textWatcher2);
                }
                this.mOldContentTextWatcher = x0Var;
            }
            return x0Var;
        }
        return (TextWatcher) invokeV.objValue;
    }

    private String getThreadTitle() {
        InterceptResult invokeV;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65727, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    private void getTopList() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65728, this) == null) && this.isFeedBack && this.mData != null) {
            this.mTopListView.setVisibility(0);
            this.feedback_divider.setVisibility(0);
            FeedBackModel feedBackModel = new FeedBackModel(getPageContext());
            this.mFeedBackModel = feedBackModel;
            feedBackModel.B(this.mData.getForumName());
            this.mFeedBackModel.setLoadDataCallBack(new u0(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToSelectLocationActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65729, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoAtSelectActivity(CharSequence charSequence, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65730, this, charSequence, i2, i3) == null) && this.isKeyboardVisibility && charSequence != null && i3 == 1 && i2 < charSequence.length() && i2 >= 0 && charSequence.charAt(i2) == '@') {
            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getPageContext().getPageActivity(), 12004, true);
            if (this.richModeEnable && this.isRichTextEditorMode) {
                atListActivityConfig.setSelectedAtList(this.mRichPostContent.getAtDataInText());
            } else if (getRealContentEdittextInstance() instanceof SpanGroupEditText) {
                atListActivityConfig.setSelectedAtList(((SpanGroupEditText) getRealContentEdittextInstance()).getAtDataInText());
            }
            sendMessage(new CustomMessage(2002001, atListActivityConfig));
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoHotTopicSelectActivity(CharSequence charSequence, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65731, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) || this.isLocalChannelDynamic || !this.isKeyboardVisibility || charSequence == null || i3 != 1 || i2 >= charSequence.length() || i2 < 0) {
            return;
        }
        this.needAddHotTopicSign = false;
        this.fromWhereToHotSelect = "";
        if ("from_content".equals(str)) {
            this.fromWhereToHotSelect = "from_content";
        } else if ("from_title".equals(str)) {
            this.fromWhereToHotSelect = "from_title";
        }
        if (hc5.f(String.valueOf(charSequence.charAt(i2)))) {
            performHotTopicClick(false);
        }
    }

    private boolean hasRichText(Spannable spannable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65732, this, spannable)) == null) {
            if (spannable != null) {
                ImageSpan[] imageSpanArr = (ImageSpan[]) spannable.getSpans(0, spannable.length(), ImageSpan.class);
                if (imageSpanArr == null || imageSpanArr.length <= 0) {
                    a19 a19Var = this.mHighLightController;
                    if (a19Var == null || !a19Var.f(spannable)) {
                        return UrlManager.getInstance().isFindUrlEndWithBlank(spannable);
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean hasWriteVote() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65733, this)) == null) {
            p19 p19Var = this.mVoteViewController;
            return (p19Var == null || this.mVoteLayoutRoot == null || p19Var.c() == null || this.mVoteLayoutRoot.getVisibility() != 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    private void hideBubbleTemporary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65734, this) == null) {
            View view2 = this.isLivePhotoType ? this.live_post_content : this.mPostContentBg;
            view2.setPadding(0, 0, 0, 0);
            view2.setBackgroundDrawable(null);
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
        }
    }

    private void hideCommodityTip() {
        z09 z09Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65735, this) == null) || (z09Var = this.mCommodityTipController) == null) {
            return;
        }
        z09Var.a();
    }

    private void hideEditorTopicTip() {
        e19 e19Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65736, this) == null) || (e19Var = this.mTipController) == null) {
            return;
        }
        e19Var.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideGuideTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65737, this) == null) {
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
    }

    private void initAddition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65738, this) == null) {
            this.mAdditionContainer = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09012d);
            this.mAdditionCreateTime = (TextView) findViewById(R.id.obfuscated_res_0x7f09012e);
            this.mAdditionLastTime = (TextView) findViewById(R.id.obfuscated_res_0x7f090132);
            this.mAdditionLastContent = (TextView) findViewById(R.id.obfuscated_res_0x7f090131);
            if (this.mAdditionData != null) {
                this.mAdditionContainer.setVisibility(0);
                TextView textView = this.mAdditionCreateTime;
                textView.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f157e) + StringHelper.getFormatTime(this.mAdditionData.getCreateTime() * 1000));
                if (this.mAdditionData.getAlreadyCount() == 0) {
                    this.mAdditionLastTime.setVisibility(8);
                } else {
                    TextView textView2 = this.mAdditionLastTime;
                    textView2.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f1580) + StringHelper.getFormatTime(this.mAdditionData.getLastAdditionTime() * 1000));
                }
                String lastAdditionContent = this.mAdditionData.getLastAdditionContent();
                if (!TextUtils.isEmpty(lastAdditionContent)) {
                    this.mAdditionLastContent.setText(lastAdditionContent);
                } else {
                    this.mAdditionLastContent.setVisibility(8);
                }
                getRealContentEdittextInstance().setHint(String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f157f), Integer.valueOf(this.mAdditionData.getAlreadyCount()), Integer.valueOf(this.mAdditionData.getTotalCount())));
                this.mName.setText(R.string.obfuscated_res_0x7f0f1582);
                return;
            }
            this.mAdditionContainer.setVisibility(8);
        }
    }

    private void initAlbumImagesOnRichTextMode() {
        WriteImagesInfo writeImagesInfo;
        LinkedList<ImageFileInfo> chosedFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65739, this) == null) || (writeImagesInfo = this.writeImagesInfo) == null || writeImagesInfo.size() <= 0 || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null) {
            return;
        }
        for (ImageFileInfo imageFileInfo : chosedFiles) {
            if (imageFileInfo != null) {
                insertImageOnRichTextMode(imageFileInfo);
            }
        }
    }

    private void initAssociatedItemContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65740, this) == null) {
            AssociatedItemContainer associatedItemContainer = (AssociatedItemContainer) findViewById(R.id.obfuscated_res_0x7f0902b9);
            this.associatedItemContainer = associatedItemContainer;
            associatedItemContainer.setOnDeletedListener(new f0(this));
            this.associatedItemContainer.setOnAddedListener(new h0(this));
        }
    }

    private void initCategoryData() {
        ee6 b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65741, this) == null) || (b2 = de6.a().b(1)) == null) {
            return;
        }
        List<ce6> list = b2.b;
        this.mCategoryList = list;
        if (list == null || list.isEmpty() || this.mCategoryFromID < 0) {
            return;
        }
        ce6 ce6Var = new ce6();
        this.mCategoryDefault = ce6Var;
        ce6Var.b = 0;
        ce6Var.a = getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0387);
        ce6 ce6Var2 = this.mCategoryDefault;
        this.mCategoryToID = ce6Var2.b;
        this.mCategoryName = ce6Var2.a;
        for (ce6 ce6Var3 : this.mCategoryList) {
            int i2 = ce6Var3.b;
            if (i2 == this.mCategoryFromID) {
                this.mCategoryToID = i2;
                this.mCategoryName = ce6Var3.a;
                return;
            }
        }
    }

    private void initCategoryUI() {
        List<ce6> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65742, this) == null) || (list = this.mCategoryList) == null || list.isEmpty()) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09184d);
        linearLayout.setVisibility(0);
        findViewById(R.id.obfuscated_res_0x7f090f37).setVisibility(0);
        PostCategoryView postCategoryView = (PostCategoryView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0905ad);
        this.mCategoryView = postCategoryView;
        postCategoryView.setText(this.mCategoryName);
        this.mCategoryView.setCategoryContainerData(this.mCategoryList, this.mCategoryDefault, this.mCategoryToID);
        this.mCategoryView.setCategoryContainerClickCallback(new o0(this));
        linearLayout.setOnClickListener(new p0(this));
    }

    private void initCommonEditorTools() {
        u05 u05Var;
        u05 u05Var2;
        CustomResponsedMessage runTask;
        u05 u05Var3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65743, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            f15 f15Var = new f15(getActivity(), 1);
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.mEditor.d(f15Var);
            }
            t25 t25Var = new t25(getActivity(), 2);
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.mEditor.d(t25Var);
            }
            Boolean isEnableAudio = isEnableAudio();
            if (!this.isFeedBack && isEnableAudio != null && isEnableAudio.booleanValue() && wm8.a() && ak8.a(this.mData.getForumName(), Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), u05.class)) != null && (u05Var3 = (u05) runTask.getData()) != null) {
                u05Var3.j = 3;
                if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    this.mEditor.d(u05Var3);
                }
            }
            if (!o09.d() && !this.isEvaluate) {
                this.mEditor.d(new t05(getActivity(), 6));
            }
            this.mEditor.d(new w05(getActivity(), 7));
            if (StringHelper.equals(this.mCallFrom, "2")) {
                i15 i15Var = new i15(getActivity(), 4);
                this.mLinkTool = i15Var;
                if (this.isEvaluate) {
                    i15Var.f(false);
                    this.mLinkTool.g(false);
                }
                this.mEditor.d(this.mLinkTool);
                if (!this.isEvaluate) {
                    this.mEditor.d(new v25(getActivity(), 8));
                }
            }
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), u05.class);
            if (runTask2 != null && (u05Var2 = (u05) runTask2.getData()) != null) {
                u05Var2.m = true;
                u05Var2.j = 9;
                if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    this.mEditor.d(u05Var2);
                }
            }
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), u05.class);
            if (runTask3 != null && (u05Var = (u05) runTask3.getData()) != null) {
                u05Var.m = true;
                u05Var.j = 10;
                if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    this.mEditor.d(u05Var);
                }
            }
            if (this.mAdditionData == null) {
                if (this.mWriteTool == null) {
                    a09 a09Var = new a09(getActivity(), this.mCallFrom);
                    this.mWriteTool = a09Var;
                    a09Var.j(0);
                    this.mWriteTool.k(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
                    if (this.isLocalChannelDynamic) {
                        this.mWriteTool.m(false);
                    }
                }
                if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    this.mWriteTool.h();
                    this.mWriteTool.l(WriteActivityConfig.FROM_FORUM_SHARE);
                    startDefaultLoacation();
                }
                if (!ListUtils.isEmpty(this.mList)) {
                    this.mWriteTool.h();
                }
                this.mEditor.d(this.mWriteTool);
            }
            if (!this.isEvaluate) {
                if (!"main_tab".equals(this.mFrom)) {
                    this.mEditor.d(new l05(getActivity(), 10));
                }
                this.mEditor.d(new h15(getActivity(), 11));
            }
            this.mEditor.h(arrayList);
            u05 n2 = this.mEditor.n(5);
            if (n2 != null) {
                n2.j = 5;
            }
        }
    }

    private void initData(Bundle bundle) {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65744, this, bundle) == null) {
            ym8 k2 = ym8.k();
            this.mWriteModel = k2;
            k2.p(this);
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
                this.needClosePrePage = bundle.getBoolean(WriteActivityConfig.NEED_CLOSE_PRE_PAGE);
                this.richModeEnable = bundle.getBoolean(WriteActivityConfig.RICH_MODE_ENABLE, false);
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
                this.needClosePrePage = intent.getBooleanExtra(WriteActivityConfig.NEED_CLOSE_PRE_PAGE, false);
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
                this.richModeEnable = intent.getBooleanExtra(WriteActivityConfig.RICH_MODE_ENABLE, false);
                if (this.fromErrorDialog && (writeData = an8.e) != null) {
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
                this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.obfuscated_res_0x7f0f158a));
            }
            this.mData.setLocalChannelDynamic(this.isLocalChannelDynamic);
            this.mData.setLocalChannelTopic(this.localChannelTopic);
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
            WriteData writeData4 = this.mData;
            if (writeData4 != null && writeData4.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
                this.isFeedBackBar = true;
            }
            try {
                this.latestPic = getLatestPic();
            } catch (Throwable unused) {
                this.latestPic = null;
            }
            this.mWriteModel.B(this.isLocalChannelDynamic);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65745, this) == null) {
            int l2 = vt4.k().l("write_associate_item_hint_tip_key", 0);
            EditorTools editorTools = new EditorTools(getActivity());
            this.mEditor = editorTools;
            editorTools.setBarMaxLauCount(5);
            this.mEditor.setMoreButtonAtEnd(true);
            this.mEditor.setBarBackgroundColorId(R.color.CAM_X0201);
            this.mEditor.setBarLauncherType(1);
            this.mEditor.C(true);
            this.mEditor.D(false);
            this.mEditor.setShouldShowMorePopTip(!this.isLocalChannelDynamic);
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
            p05 m2 = this.mEditor.m(6);
            if (m2 != null && !TextUtils.isEmpty(this.mDisableAudioMessage)) {
                ((View) m2).setOnClickListener(new l(this));
            }
            if (!this.isLivePhotoType) {
                this.mEditor.A(new i05(34, 5, 1));
            }
            this.mEditor.q();
            if (!vt4.k().h("hot_topic_has_click", false)) {
                this.mEditor.A(new i05(2, 26, " "));
            }
            if (vt4.k().l("commodity_tip_show_controller", 0) != 0 || !this.canGoods) {
                showEditorTopicTip();
                checkClipboardAndShowNewLinkBubble();
            } else if (l2 > 0) {
                showCommodityTip();
            } else {
                vt4.k().w("commodity_tip_show_controller", vt4.k().l("commodity_tip_show_controller", 0) + 1);
            }
        }
    }

    private void initEditorListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65746, this) == null) {
            q qVar = new q(this);
            this.mEditor.setActionListener(16, qVar);
            this.mEditor.setActionListener(14, qVar);
            this.mEditor.setActionListener(60, qVar);
            this.mEditor.setActionListener(24, qVar);
            this.mEditor.setActionListener(3, qVar);
            this.mEditor.setActionListener(10, qVar);
            this.mEditor.setActionListener(11, qVar);
            this.mEditor.setActionListener(12, qVar);
            this.mEditor.setActionListener(13, qVar);
            this.mEditor.setActionListener(15, qVar);
            this.mEditor.setActionListener(18, qVar);
            this.mEditor.setActionListener(20, qVar);
            this.mEditor.setActionListener(25, qVar);
            this.mEditor.setActionListener(27, qVar);
            this.mEditor.setActionListener(29, qVar);
            this.mEditor.setActionListener(43, qVar);
            this.mEditor.setActionListener(56, qVar);
            this.mEditor.setActionListener(48, qVar);
            this.mEditor.setActionListener(46, qVar);
            this.mEditor.setActionListener(49, qVar);
            this.mEditor.setActionListener(47, qVar);
            this.mEditor.setActionListener(55, qVar);
            this.mEditor.setActionListener(58, qVar);
            this.mEditor.setActionListener(22, qVar);
            this.mEditor.setActionListener(21, qVar);
            this.mEditor.setActionListener(59, qVar);
            this.mEditor.setActionListener(61, qVar);
        }
    }

    private void initForumTabSelected() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65747, this) == null) || this.isEvaluate) {
            return;
        }
        ForumTabSelectedView forumTabSelectedView = (ForumTabSelectedView) findViewById(R.id.obfuscated_res_0x7f090bf0);
        this.mForumTabSelectedView = forumTabSelectedView;
        forumTabSelectedView.setBgColor(R.color.CAM_X0205);
        this.mForumTabSelectedViewDivider = findViewById(R.id.obfuscated_res_0x7f090bec);
        this.mForumTabSelectedView.setData(this.mFrsTabList);
        if (this.mForumTabSelectedView.getVisibility() == 0) {
            this.mForumTabSelectedViewDivider.setVisibility(0);
        }
        this.mForumTabSelectedView.setActivity(this);
    }

    private void initGridView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65748, this) == null) {
            View findViewById = this.mRootView.findViewById(R.id.obfuscated_res_0x7f09182a);
            this.live_container = findViewById;
            this.live_post_title_container = findViewById.findViewById(R.id.obfuscated_res_0x7f0912b4);
            this.live_post_content = (EditText) this.live_container.findViewById(R.id.obfuscated_res_0x7f0912b1);
            this.mPhotoLiveGridView = (GridView) this.live_container.findViewById(R.id.obfuscated_res_0x7f091825);
            this.live_post_title = (EditText) this.live_container.findViewById(R.id.obfuscated_res_0x7f0912b3);
            this.mTitleOverPlusNumber = (TextView) this.live_container.findViewById(R.id.obfuscated_res_0x7f092017);
            this.mContentOverPlusNumber = (TextView) this.live_container.findViewById(R.id.obfuscated_res_0x7f0906e3);
            this.live_interval_view = this.live_container.findViewById(R.id.obfuscated_res_0x7f0912ac);
            this.mTitleOverPlusNumber.setText(String.valueOf(20));
            this.mContentOverPlusNumber.setText(String.valueOf((int) CONTENT_MAX_COUNT));
            this.live_container.setVisibility(0);
            this.mTitleOverPlusNumber.setVisibility(0);
            this.mContentOverPlusNumber.setVisibility(0);
            this.live_post_title.setHint(R.string.obfuscated_res_0x7f0f13ec);
            this.live_post_title.setOnFocusChangeListener(new m(this));
            if (this.mData.getType() == 4) {
                this.live_post_content.setHint(R.string.obfuscated_res_0x7f0f0a15);
            } else if (this.mData.getType() == 5) {
                this.live_post_content.setHint(R.string.obfuscated_res_0x7f0f0a16);
            }
            this.live_post_content.setOnFocusChangeListener(new n(this));
            this.live_post_content.requestFocus();
            this.live_post_content.addTextChangedListener(getTextWatcher());
            this.live_post_title.requestFocus();
            this.live_post_title.addTextChangedListener(getTextWatcher());
            this.live_post_title.setOnClickListener(this.mEditOnClicked);
            this.live_post_content.setOnClickListener(this.mEditOnClicked);
            u09 u09Var = new u09(this, this.writeImagesInfo, this.mPhotoLiveGridView);
            this.mPhotoLiveGridViewAdapter = u09Var;
            u09Var.n(6);
            this.mPhotoLiveGridView.setAdapter((ListAdapter) this.mPhotoLiveGridViewAdapter);
            View findViewById2 = this.live_container.findViewById(R.id.obfuscated_res_0x7f0912b2);
            findViewById2.bringToFront();
            ((PhotoLiveLinearLayout) findViewById2).setOnChangeLayoutListener(new o(this));
            readLivePhotoTitleFromDraft();
        }
    }

    private void initLastErrorHandleFromErrorDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65749, this) == null) {
            this.mNavigationBar.postDelayed(this.handleLastError, 500L);
        }
    }

    private void initListView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65750, this) == null) {
            this.mListView = (ListView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f0906a0);
            b19 b19Var = new b19(getPageContext());
            this.mAdapter = b19Var;
            b19Var.j(this.mOnItemDeleteListener);
            this.mListView.setAdapter((ListAdapter) this.mAdapter);
            this.mListView.setOnItemClickListener(new d1(this));
        }
    }

    private void initListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65751, this) == null) {
            registerListener(this.mUpdateBubbleListener);
            registerListener(this.openMoreToolListener);
            registerListener(this.mSelectForumListener);
            registerListener(this.mOnSelectLocationListener);
            registerListener(this.mUegValidateListener);
            registerListener(this.mBackgroundListener);
            registerListener(this.postWorkVideoAsyncListener);
            registerListener(this.mEvaluateRelevanceItemSelectedListener);
        }
    }

    private void initLocalChannelTopicSelectView() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65752, this) == null) && this.isLocalChannelDynamic) {
            LocalChannelTopicSelectView localChannelTopicSelectView = (LocalChannelTopicSelectView) findViewById(R.id.obfuscated_res_0x7f09247e);
            this.mLocalChannelTopicSelectView = localChannelTopicSelectView;
            localChannelTopicSelectView.setVisibility(0);
            this.mLocalChannelTopicSelectView.setLocalChannelTopic(this.localChannelTopic);
        }
    }

    private void initPhotoLiveEditorTools() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65753, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(10);
            arrayList.add(5);
            this.mEditor.h(arrayList);
            u05 n2 = this.mEditor.n(5);
            if (n2 != null) {
                n2.j = 2;
            }
            this.mEditor.d(new w05(getActivity(), 3));
            this.mEditor.d(new d15(getActivity(), 6));
        }
    }

    private void initPostTopic() {
        WriteData writeData;
        PostTopicData postTopicData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65754, this) == null) || (writeData = this.mData) == null || writeData.getType() != 0 || this.mData.getType() != 9 || this.isFeedBack || this.isFeedBackBar || (postTopicData = this.mPostTopicData) == null || StringUtils.isNull(postTopicData.getTitleTopic())) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65755, this) == null) {
            this.post_prefix_layout = findViewById(R.id.obfuscated_res_0x7f0918ad);
            if (this.mPiefixTipController == null) {
                nz5 nz5Var = new nz5(getPageContext(), this.post_prefix_layout);
                this.mPiefixTipController = nz5Var;
                nz5Var.g0(R.drawable.obfuscated_res_0x7f0802f2);
                this.mPiefixTipController.O(16);
                this.mPiefixTipController.U(true);
                this.mPiefixTipController.h0(true);
                this.mPiefixTipController.j0(oi.f(getActivity(), R.dimen.obfuscated_res_0x7f070207));
            }
            this.mPrefix = (TextView) findViewById(R.id.obfuscated_res_0x7f0918ac);
            this.prefix_divider = findViewById(R.id.obfuscated_res_0x7f0918d0);
            this.mPrefixIcon = (ImageView) findViewById(R.id.obfuscated_res_0x7f0918d1);
            initPrefixData();
        }
    }

    private void initPrefixData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65756, this) == null) {
            PostPrefixData postPrefixData = this.mPrefixData;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 1) {
                this.post_prefix_layout.setVisibility(0);
                this.prefix_divider.setVisibility(0);
                this.mPiefixTipController.n0(getString(R.string.obfuscated_res_0x7f0f159b), WRITE_TITLE_PREFIX_TIP_KEY, true);
                ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
                int size = prefixs.size();
                this.mCurrPrefixPos = 0;
                this.post_prefix_layout.setOnClickListener(new s0(this));
                this.mPrefix.setOnClickListener(new t0(this));
                jz8 jz8Var = new jz8(getPageContext().getPageActivity());
                this.mPrefixWindow = jz8Var;
                jz8Var.e(this);
                this.mPrefixWindow.d(oi.f(getActivity(), R.dimen.obfuscated_res_0x7f0702d9));
                this.mPrefixWindow.setOutsideTouchable(true);
                this.mPrefixWindow.setFocusable(true);
                this.mPrefixWindow.setOnDismissListener(this);
                this.mPrefixWindow.setBackgroundDrawable(SkinManager.getDrawable(R.color.CAM_X0201));
                int color = SkinManager.getColor(R.color.CAM_X0105);
                SkinManager.getColor(R.color.CAM_X0108);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mPrefixIcon, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
                vr4 d2 = vr4.d(this.mPrefix);
                d2.v(R.color.CAM_X0105);
                d2.A(R.string.F_X02);
                d2.f(R.color.CAM_X0201);
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
    }

    private void initProductData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65757, this) == null) {
            parseProductData(this.goodsListStr);
        }
    }

    private void initProductTieProtocol() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65758, this) == null) {
            this.mProtocol = (LinearLayout) this.mRootView.findViewById(R.id.obfuscated_res_0x7f091936);
            this.mProtocolTag = (ImageView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f09193b);
            TextView textView = (TextView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f091938);
            this.mProtocolInfo = textView;
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0107);
            EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this, EBusinessProtocolView.WindowType.PROTOCOL);
            this.mEBusinessProtocolView = eBusinessProtocolView;
            eBusinessProtocolView.o(getResources().getString(R.string.obfuscated_res_0x7f0f0ef1));
            this.mEBusinessProtocolView.i(PATH_PROTOCOL);
            SpannableString spannableString = new SpannableString(getResources().getString(R.string.obfuscated_res_0x7f0f0f2f));
            spannableString.setSpan(new k0(this), 6, 17, 34);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), 6, 17, 34);
            this.mProtocolInfo.setText(spannableString);
            this.mProtocolInfo.setMovementMethod(LinkMovementMethod.getInstance());
            this.mProtocolTag.setOnClickListener(new l0(this));
            vt4 k2 = vt4.k();
            if (k2.h(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false)) {
                this.isAgreedProtocol = true;
                this.mProtocolTag.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08082e, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            } else {
                this.isAgreedProtocol = false;
                this.mProtocolTag.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809d7, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
            }
            this.mEBusinessProtocolView.m(new m0(this));
        }
    }

    private void initProfession() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65759, this) == null) || this.mName == null || (writeData = this.mData) == null || writeData.getProZone() != 1) {
            return;
        }
        this.mName.setText(R.string.obfuscated_res_0x7f0f15aa);
    }

    private void initPublishProductGuide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65760, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
            this.originalMargin = layoutParams.rightMargin;
            layoutParams.rightMargin = 0;
            this.mName.setLayoutParams(layoutParams);
            ImageView imageView = (ImageView) this.mNavigationBar.getCenterImgBox();
            this.mGuide = imageView;
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080900, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
            int f2 = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int f3 = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds47);
            this.mGuide.setPadding(f2, f2, f2, f2);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mGuide.getLayoutParams();
            int i2 = f3 + f2 + f2;
            layoutParams2.width = i2;
            layoutParams2.height = i2;
            this.mGuide.setLayoutParams(layoutParams2);
            this.mGuide.setOnClickListener(new n0(this));
            this.mGuide.setVisibility(0);
        }
    }

    private void initRecBubble() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65761, this) == null) && this.latestPic != null && this.mData.getType() == 0 && this.mData.getType() == 9 && this.mData.getType() == 11) {
            getDimension(getActivity());
            View inflate = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d070f, (ViewGroup) null);
            this.mBubbleView = inflate;
            inflate.setOnClickListener(new j1(this));
            this.mRecImgView = (TbImageView) this.mBubbleView.findViewById(R.id.obfuscated_res_0x7f0919bf);
            this.mBubbleLayout = (LinearLayout) this.mBubbleView.findViewById(R.id.obfuscated_res_0x7f0919be);
            if (vt4.k().q("write_rec_pic_path", "").equalsIgnoreCase(this.latestPic.getAbsolutePath())) {
                return;
            }
            vt4.k().y("write_rec_pic_path", this.latestPic.getAbsolutePath());
            Bitmap previewImg = getPreviewImg(this.latestPic.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070256));
            if (previewImg != null) {
                this.mRecImgView.setImageBitmap(previewImg);
                this.mRecImgView.setDrawBorder(true);
                this.mRecImgView.setBorderWidth(2);
                this.mRecImgView.setBorderColor(SkinManager.getColor(R.color.common_color_10264));
                Dialog dialog = new Dialog(getActivity(), R.style.obfuscated_res_0x7f10039b);
                this.mRecDialog = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.mRecDialog.setOnDismissListener(new k1(this));
                this.mRecDialog.setContentView(this.mBubbleView);
                this.mRecDialog.show();
                Window window = this.mRecDialog.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                window.setGravity(83);
                attributes.x = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9);
                attributes.y = (SCREEN_HEIGHT / 18) + getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023e);
                attributes.width = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07025b);
                attributes.height = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070294);
                window.setAttributes(attributes);
            }
        }
    }

    private void initRichGuideView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65762, this) == null) {
            this.richModeGuideLayout = findViewById(R.id.obfuscated_res_0x7f091a7e);
            this.richModeGuideHollowView = (RichGuideHollowView) findViewById(R.id.obfuscated_res_0x7f091a7d);
            this.richModeGuideLottieView = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f091a80);
            this.richModeGuideMain = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091a7c);
            this.richModeTextGuide1 = (TextView) findViewById(R.id.obfuscated_res_0x7f091a81);
            this.richModeTextGuide2 = (TextView) findViewById(R.id.obfuscated_res_0x7f091a82);
            this.richModeTextGuide3 = (TextView) findViewById(R.id.obfuscated_res_0x7f091a83);
            this.richModeTextGuide4 = (TextView) findViewById(R.id.obfuscated_res_0x7f091a84);
            this.richModeGuideHollowView.setTargetView(this.mNameLayout);
            SkinManager.setLottieAnimation(this.richModeGuideLottieView, R.raw.obfuscated_res_0x7f110046);
            this.richModeGuideLottieView.setRepeatCount(3);
            SkinManager.setBackgroundResource(this.richModeGuideMain, R.drawable.obfuscated_res_0x7f080fb7);
            vr4 d2 = vr4.d(this.richModeTextGuide1);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0303);
            vr4 d3 = vr4.d(this.richModeTextGuide2);
            d3.A(R.string.F_X02);
            d3.z(R.dimen.T_X05);
            d3.v(R.color.CAM_X0105);
            vr4 d4 = vr4.d(this.richModeTextGuide3);
            d4.A(R.string.F_X01);
            d4.z(R.dimen.T_X10);
            d4.v(R.color.CAM_X0109);
            vr4.d(findViewById(R.id.obfuscated_res_0x7f091a7f)).o(new int[]{R.color.CAM_X0901, R.color.CAM_X0612});
            vr4 d5 = vr4.d(this.richModeTextGuide4);
            d5.A(R.string.F_X01);
            d5.z(R.dimen.T_X07);
            d5.v(R.color.CAM_X0101);
            d5.n(R.string.J_X07);
            d5.l(R.dimen.L_X01);
            d5.k(R.color.CAM_X0101);
            d5.j(R.string.A_X07);
            d5.h(17170445);
            this.richModeGuideLayout.setOnClickListener(new c0(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSelectForumData(SelectForumData selectForumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65763, this, selectForumData) == null) || selectForumData == null) {
            return;
        }
        this.mSelectForumData = selectForumData;
        WriteData writeData = this.mData;
        if (writeData != null) {
            writeData.setForumId(selectForumData.forumId);
            this.mData.setForumName(this.mSelectForumData.forumName);
        }
        this.mForumSelectedView.setSelectedForum(this.mSelectForumData.forumName);
        this.mFrsTabList = null;
        if (!ListUtils.isEmpty(this.mSelectForumData.tabInfoList)) {
            FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
            this.mFrsTabList = frsTabInfoData;
            frsTabInfoData.selectedTabId = -1;
            SelectForumData selectForumData2 = this.mSelectForumData;
            List<FrsTabItemData> list = selectForumData2.tabInfoList;
            frsTabInfoData.tabList = list;
            if (selectForumData2.isForumBusinessAccount && list != null) {
                FrsTabItemData frsTabItemData = new FrsTabItemData();
                frsTabItemData.tabId = 505;
                frsTabItemData.name = "官方";
                this.mFrsTabList.tabList.add(0, frsTabItemData);
            }
            this.mFrsTabList.isForumBusinessAccount = this.mSelectForumData.isForumBusinessAccount;
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
        PostPrefixData postPrefixData = this.mSelectForumData.postPrefix;
        if (postPrefixData != null && !ListUtils.isEmpty(postPrefixData.getPrefixs())) {
            PostPrefixData postPrefixData2 = this.mSelectForumData.postPrefix;
            this.mPrefixData = postPrefixData2;
            postPrefixData2.getPrefixs().add(getPageContext().getString(R.string.obfuscated_res_0x7f0f158a));
        }
        initPrefixData();
    }

    private void initSelectForumView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65764, this) == null) {
            if ("main_tab".equals(this.mFrom) && !this.fromErrorDialog) {
                ForumSelectedView forumSelectedView = (ForumSelectedView) findViewById(R.id.obfuscated_res_0x7f092483);
                this.mForumSelectedView = forumSelectedView;
                forumSelectedView.setVisibility(0);
            } else if (this.richModeEnable) {
                ForumSelectedView forumSelectedView2 = (ForumSelectedView) findViewById(R.id.obfuscated_res_0x7f092483);
                this.mForumSelectedView = forumSelectedView2;
                forumSelectedView2.setVisibility(0);
                this.mForumSelectedView.setSelectedForum(this.mData.getForumName());
                this.mForumSelectedView.a();
                this.mForumSelectedView.setOnClickListener(null);
            }
        }
    }

    private void initTextEditorMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65765, this) == null) {
            if (this.richModeEnable && this.isRichTextEditorMode) {
                initAlbumImagesOnRichTextMode();
            }
            if (this.isRichTextEditorMode) {
                onRichTextEditorMode();
            } else {
                onNormalTextEditorMode();
            }
        }
    }

    private void initTopicDataInView() {
        HotTopicBussinessData hotTopicBussinessData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65766, this) == null) || (hotTopicBussinessData = (HotTopicBussinessData) ListUtils.getItem(this.mList, 0)) == null || TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            return;
        }
        this.mPostTitle.setText(hc5.i(hc5.a(hotTopicBussinessData.mTopicName)));
        this.mPostTitle.setMovementMethod(rw8.a());
    }

    private void initUI() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65767, this) == null) {
            this.mLoadingDialog = new xt4(getPageContext());
            this.isLivePhotoType = this.mData.getType() == 4 || 5 == this.mData.getType();
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.obfuscated_res_0x7f0d08d9, (ViewGroup) null);
            this.mRootView = inflate;
            setContentView(inflate);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923ac);
            this.mNavigationBar = navigationBar;
            navigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mName = this.mNavigationBar.setCenterTextTitle("");
            this.mNameIcon = (ImageView) this.mNavigationBar.getCenterImgBox();
            View centerImgBoxLayout = this.mNavigationBar.getCenterImgBoxLayout();
            this.mNameLayout = centerImgBoxLayout;
            centerImgBoxLayout.setOnClickListener(new w(this));
            if (this.richModeEnable) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
                this.mName.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mNameIcon.getLayoutParams();
                layoutParams2.width = oi.f(this, R.dimen.tbds31);
                layoutParams2.height = oi.f(this, R.dimen.tbds31);
                this.mNameIcon.setLayoutParams(layoutParams2);
                this.mNameIcon.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08095a, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_DISABLE));
                this.mNameIcon.setVisibility(0);
            }
            SkinManager.setViewTextColor(this.mName, (int) R.color.CAM_X0105);
            this.btn_image_problem = (TextView) findViewById(R.id.obfuscated_res_0x7f09041f);
            setPostView();
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
            layoutParams3.rightMargin = oi.f(getPageContext().getPageActivity(), R.dimen.tbds2);
            this.mPost.setLayoutParams(layoutParams3);
            this.mPost.setOnFocusChangeListener(this.mFocusChangeListener);
            ScrollView scrollView = (ScrollView) findViewById(R.id.obfuscated_res_0x7f092482);
            this.write_scrollview = scrollView;
            scrollView.setOnTouchListener(new x(this));
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.mTopListView = (FeedBackTopListView) findViewById(R.id.obfuscated_res_0x7f090997);
            this.feedback_divider = findViewById(R.id.obfuscated_res_0x7f090995);
            this.mParent = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091642);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092080);
            this.mToolView = linearLayout;
            linearLayout.setContentDescription(IStringUtil.TOP_PATH);
            this.mTitleView = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092045);
            this.imageGridView = (WriteImageGridView) findViewById(R.id.obfuscated_res_0x7f09247c);
            this.mTitleViewDivider = findViewById(R.id.obfuscated_res_0x7f092046);
            this.mInterval = findViewById(R.id.obfuscated_res_0x7f090f36);
            this.mHotTopicEdt = (TextView) findViewById(R.id.obfuscated_res_0x7f090df8);
            initializePostTitle();
            initializePostContent();
            if (this.isLivePhotoType) {
                this.write_scrollview.setVisibility(8);
                this.writeImagesInfo.setMaxImagesAllowed(6);
                initGridView();
            } else {
                this.mWriteImageController = new g19(getPageContext(), this.mRootView);
                if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    this.mWriteImageController.i(false);
                } else {
                    this.mWriteImageController.j(this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 11);
                }
                this.mWriteImageController.h(this.isRichTextEditorMode);
            }
            showPicOrVideo(true, false);
            if (this.isFeedBack || this.isFeedBackBar) {
                getWindow().setSoftInputMode(18);
                if (ICDNIPDirectConnect.getInstance() != null) {
                    if (!ICDNIPDirectConnect.getInstance().isAlreadyInit) {
                        ICDNIPDirectConnect.getInstance().init();
                    }
                    if (ICDNIPDirectConnect.getInstance().hasImageProblem()) {
                        findViewById(R.id.obfuscated_res_0x7f0912ea).setVisibility(0);
                    } else {
                        findViewById(R.id.obfuscated_res_0x7f0912ea).setVisibility(8);
                    }
                }
            }
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0918a2);
            this.mPostContentContainer = linearLayout2;
            linearLayout2.setDrawingCacheEnabled(false);
            this.mPostContentContainer.setOnClickListener(new y(this));
            this.mLayoutVoicePlay = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0911f5);
            this.mVoicePlayButton = (PlayVoiceBntNew) findViewById(R.id.obfuscated_res_0x7f09043a);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fc9);
            this.mIvDeleteVoice = imageView;
            imageView.setOnClickListener(new z(this));
            addVoice(this.mVoiceModel);
            this.mBack.setOnFocusChangeListener(this.mFocusChangeListener);
            this.mBack.setOnClickListener(new a0(this));
            this.btn_image_problem.setOnClickListener(new b0(this));
            initCategoryUI();
            setAudioEnableStatus(isEnableAudio());
            intializePostButton();
            updataTitle();
            initializeRecordVoice();
            changeToolButtonStatus();
            initAddition();
            initPrefix();
            initTopicDataInView();
            if (this.mData.getType() == 4 && (view2 = this.post_prefix_layout) != null && this.prefix_divider != null) {
                view2.setVisibility(8);
                this.prefix_divider.setVisibility(8);
            }
            refreshPostButton();
            updateGroup();
            initProfession();
            initSelectForumView();
            initLocalChannelTopicSelectView();
            initForumTabSelected();
            initWriteEvaluationUI();
            initWriteEvaluationHeaderView();
            initVoteView();
            initProductTieProtocol();
            initListView();
            initAssociatedItemContainer();
            initRichGuideView();
        }
    }

    private void initVoteView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65768, this) == null) {
            this.mVoteLayoutRoot = (RelativeLayout) this.mRootView.findViewById(R.id.obfuscated_res_0x7f092400);
            this.mVoteViewController = new p19(getPageContext(), this.mVoteLayoutRoot);
            showVoteView();
        }
    }

    private void initWriteEvaluationHeaderView() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65769, this) == null) && this.isEvaluate) {
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65770, this) == null) && this.isEvaluate) {
            this.mPostContentCounter = (TextView) findViewById(R.id.obfuscated_res_0x7f0918a3);
            WriteEvaluationHeaderView writeEvaluationHeaderView = (WriteEvaluationHeaderView) findViewById(R.id.obfuscated_res_0x7f09247b);
            this.mWriteEvaluationeHeaderView = writeEvaluationHeaderView;
            writeEvaluationHeaderView.setStarChangeListener(new i0(this));
            this.mWriteEvaluationeHeaderView.setItemCloseListener(new j0(this));
        }
    }

    private void initializeRecordVoice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65771, this) == null) {
            getVoiceManager().onCreate(getPageContext());
        }
    }

    private void insertImageOnRichTextMode(@NonNull ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65772, this, imageFileInfo) == null) {
            this.mRichPostContent.s(imageFileInfo);
        }
    }

    private Boolean isEnableAudio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65773, this)) == null) ? Boolean.valueOf(this.isVoiceEnable) : (Boolean) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTextFull() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65774, this)) == null) {
            return getRealContentEdittextInstance().getText() != null && getRealContentEdittextInstance().getText().length() >= (this.mAdditionData != null ? 1000 : 5000);
        }
        return invokeV.booleanValue;
    }

    private boolean isValidLiveContent(EditText editText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65775, this, editText)) == null) {
            long inputCount = getInputCount(editText);
            if (inputCount > 233) {
                return false;
            }
            return inputCount > 0 || this.writeImagesInfo.size() >= 1;
        }
        return invokeL.booleanValue;
    }

    private boolean isValidLiveTitle(EditText editText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65776, this, editText)) == null) {
            long inputCount = getInputCount(editText);
            return inputCount <= 20 && inputCount > 0;
        }
        return invokeL.booleanValue;
    }

    private void jumpToAlbumActivity(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65777, this, i2) == null) || this.writeImagesInfo == null || this.mData == null) {
            return;
        }
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
        albumFloatActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
        albumFloatActivityConfig.getIntent().putExtra("from", this.mFrom);
        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumFloatActivityConfig.setAlbumThread(i2);
        albumFloatActivityConfig.setCanSelectVideo(false);
        albumFloatActivityConfig.setCanSelectOnlyVideo(false);
        albumFloatActivityConfig.setCanEditImage(false);
        albumFloatActivityConfig.setFromWrite(3);
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

    private void jumpToAlbumActivityOnRichTextMode() {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65778, this) == null) || (writeImagesInfo = this.writeImagesInfo) == null || this.mData == null) {
            return;
        }
        JSONObject json = writeImagesInfo.toJson();
        String str = null;
        if (json != null) {
            try {
                json.put("maxImagesAllowed", 9 - this.writeImagesInfo.size());
                json.put("chosedFiles", (Object) null);
                str = json.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), str, true, true);
        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
        albumFloatActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
        albumFloatActivityConfig.getIntent().putExtra("from", this.mFrom);
        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumFloatActivityConfig.setAlbumThread(0);
        albumFloatActivityConfig.setCanSelectVideo(false);
        albumFloatActivityConfig.setCanSelectOnlyVideo(false);
        albumFloatActivityConfig.setCanEditImage(false);
        albumFloatActivityConfig.setFromWrite(3);
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
        WriteImagesInfo writeImagesInfo;
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65779, this, i2) == null) || (writeImagesInfo = this.writeImagesInfo) == null || writeImagesInfo.getChosedFiles() == null || (size = this.writeImagesInfo.getChosedFiles().size()) < 1 || i2 < 0 || i2 >= size) {
            return;
        }
        sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, i2)));
    }

    private void jumpToVideoAlbumActivity(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65780, this, i2) == null) || this.writeImagesInfo == null || this.mData == null) {
            return;
        }
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
        albumFloatActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
        albumFloatActivityConfig.getIntent().putExtra("from", this.mFrom);
        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumFloatActivityConfig.setAlbumThread(i2);
        albumFloatActivityConfig.setCanSelectVideo(true);
        albumFloatActivityConfig.setCanSelectOnlyVideo(true);
        albumFloatActivityConfig.setCanEditImage(false);
        albumFloatActivityConfig.setFromWrite(3);
        albumFloatActivityConfig.setCallFrom(this.mCallFrom);
        albumFloatActivityConfig.setStatisticFrom(this.mData.getStatisticFrom());
        albumFloatActivityConfig.setProfessionZone(this.mData.getProZone());
        albumFloatActivityConfig.setFrsTabInfo(this.mFrsTabList);
        if (this.mPostTitle.getText().toString() != null) {
            albumFloatActivityConfig.setVideoTitle(this.mPostTitle.getText().toString());
        } else {
            albumFloatActivityConfig.setVideoTitle(this.mTitleTemp);
        }
        albumFloatActivityConfig.setBarName(this.mData.getForumName());
        albumFloatActivityConfig.setBarID(this.mData.getForumId());
        if (this.mSelectForumData == null && this.mData.getForumName() != null) {
            albumFloatActivityConfig.setCanChangeBarName(false);
        } else {
            albumFloatActivityConfig.setCanChangeBarName(true);
        }
        albumFloatActivityConfig.setVideoAbstract(this.mPostContent.getText().toString());
        AntiData antiData = new AntiData();
        antiData.voice_message = this.mDisableAudioMessage;
        antiData.setIfVoice(this.isVoiceEnable);
        albumFloatActivityConfig.setExtraData(antiData, this.mPrefixData, this.mData.getFirstDir(), this.mData.getSecondDir());
        sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToVoteView(WriteVoteData writeVoteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65781, this, writeVoteData) == null) {
            WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(getPageContext().getPageActivity(), 25048);
            if (writeVoteData != null) {
                writeVoteActivityConfig.setExtraData(writeVoteData);
            }
            sendMessage(new CustomMessage(2002001, writeVoteActivityConfig));
        }
    }

    private void loadDraft() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65782, this) == null) {
            if (this.mData.getType() != 0 && this.mData.getType() != 9 && this.mData.getType() != 11) {
                if (this.mData.getType() == 7) {
                    if (this.isSaveDraft) {
                        fk8.k(BOTTLE_FORUM_ID, this);
                    }
                } else if (this.mData.getType() == 1) {
                    fk8.o(this.mData.getThreadId(), this);
                } else if (this.mData.getType() == 4) {
                    fk8.k(this.mData.getForumId() + PHOTO_LIVE_DRAFT_KEY, this);
                } else if (this.mData.getType() == 5) {
                    fk8.o(this.mData.getThreadId() + UPDATE_PHOTO_LIVE_DRAFT_KEY, this);
                }
            } else if (this.isSaveDraft) {
                if (this.mData.isLocalChannelDynamic()) {
                    fk8.l(this);
                } else if (this.mData.isEvaluate()) {
                    fk8.j(this.mData.getItem_id(), this);
                } else if (TextUtils.isEmpty(this.mData.getTopicId())) {
                    fk8.k(this.mData.getForumId(), this);
                } else {
                    fk8.q(this.mData.getTopicId(), this);
                }
            }
        }
    }

    private void loadDraftImageForPhotoLive() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65783, this) == null) {
            if ((this.isLivePhotoType && this.mPhotoLiveGridViewAdapter == null) || this.mPhotoLiveGridView == null) {
                return;
            }
            this.mPhotoLiveGridViewAdapter.l(this.writeImagesInfo);
            updateGridView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onItemToolClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65784, this) == null) {
            if (!this.mData.canAddItem()) {
                oi.M(getActivity(), R.string.obfuscated_res_0x7f0f15a7);
                return;
            }
            RelevanceItemSearchActivityConfig relevanceItemSearchActivityConfig = new RelevanceItemSearchActivityConfig(getActivity(), 0);
            relevanceItemSearchActivityConfig.setSelectedIds(this.mData.getItemDataIds());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, relevanceItemSearchActivityConfig));
        }
    }

    private void onNormalTextEditorMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65785, this) == null) {
            this.mPostContent.setVisibility(0);
            this.mRichPostContent.setVisibility(8);
            g19 g19Var = this.mWriteImageController;
            if (g19Var != null) {
                g19Var.h(false);
            }
        }
    }

    private void onRichTextEditorMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65786, this) == null) {
            this.mPostContent.setVisibility(8);
            this.mRichPostContent.setVisibility(0);
            g19 g19Var = this.mWriteImageController;
            if (g19Var != null) {
                g19Var.h(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseProductData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65787, this, str) == null) {
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
                    this.mGoodsDatas.add(ht6.g(jSONObject));
                }
                if (this.mGoodsDatas.size() > 0) {
                    this.isProductTie = true;
                    this.mPostContent.g(this.mGoodsDatas, arrayList);
                    initPublishProductGuide();
                    refreshListView();
                    this.mProtocol.setVisibility(0);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performHotTopicClick(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65788, this, z2) == null) || hc5.b(getPageContext())) {
            return;
        }
        HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
        WriteData writeData = this.mData;
        if (writeData != null) {
            hotSelectActivityConfig.setForumExtra(mg.g(writeData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
        }
        sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void popupSaveDraftDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65789, this) == null) {
            TextView textView = this.mPost;
            if (textView != null && ((textView.isEnabled() || this.isEvaluate || !ListUtils.isEmpty(this.mData.getItemDatas())) && ((!this.isEvaluate || !TextUtils.isEmpty(this.mPostContent.getText()) || (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() != 0)) && this.isSaveDraft))) {
                if (this.saveDraftDialogView == null) {
                    this.saveDraftDialogView = new SaveDraftDialogView(this);
                    this.saveDraftDialogView.setOnClickListener(new s(this));
                }
                if (this.saveDraftDialog == null) {
                    lr4 lr4Var = new lr4(getPageContext());
                    this.saveDraftDialog = lr4Var;
                    lr4Var.setContentView(this.saveDraftDialogView);
                }
                this.saveDraftDialogView.setText(getString(R.string.obfuscated_res_0x7f0f158f), null, getString(R.string.obfuscated_res_0x7f0f1064));
                this.saveDraftDialog.m();
                return;
            }
            clearDraft();
            setResult(100);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postNewMessage() {
        HotTopicBussinessData hotTopicBussinessData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65790, this) == null) {
            stopTask();
            this.mData.setContent(getContent());
            processTitleForPost(getThreadTitle());
            if (this.isFeedBack || this.isFeedBackBar) {
                String string = getResources().getString(R.string.obfuscated_res_0x7f0f0277);
                if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                    processTitleForPost(string + this.mData.getTitle());
                }
                String str = getResources().getString(R.string.obfuscated_res_0x7f0f029e) + getResources().getString(R.string.obfuscated_res_0x7f0f13b7);
                if (TextUtils.isEmpty(this.mData.getContent()) || !this.mData.getContent().startsWith(str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(TbConfig.getVersion());
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(Build.VERSION.RELEASE);
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(Build.MODEL);
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    if (mi.z()) {
                        sb.append(mi.K());
                    } else {
                        sb.append(RomUtils.UNKNOWN);
                    }
                    sb.append(":");
                    sb.append(this.mData.getContent());
                    this.mData.setContent(sb.toString());
                }
            }
            if (this.showHomepageTestIcon) {
                this.mData.setZhongcePrefix(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0854), Build.MODEL, TbadkCoreApplication.getInst().getVersionName(), mi.K(), Build.VERSION.RELEASE));
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
            this.mRichPostContent.setWriteImagesInfo(this.writeImagesInfo);
            p19 p19Var = this.mVoteViewController;
            if (p19Var != null) {
                this.mData.setWriteVoteData(p19Var.c());
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
            writeData.setHasLocationData(locationModel != null && locationModel.B());
            WriteImagesInfo writeImagesInfo2 = this.writeImagesInfo;
            if (writeImagesInfo2 != null) {
                this.mWriteModel.A(writeImagesInfo2.size() > 0);
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
            this.mWriteModel.H(this.mData);
            WriteData writeData2 = this.mData;
            writeData2.setContent(writeData2.getContent().replaceAll("\u0000\n", ""));
            WriteData writeData3 = this.mData;
            writeData3.setContent(writeData3.getContent().replaceAll("\u0000", ""));
            this.mData.setVcode(null);
            this.mData.setVoiceModel(this.mVoiceModel);
            VoiceData.VoiceModel voiceModel = this.mVoiceModel;
            if (voiceModel != null) {
                if (voiceModel.getId() != null) {
                    this.mWriteModel.o().setVoice(this.mVoiceModel.getId());
                    this.mWriteModel.o().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.mWriteModel.o().setVoice(null);
                    this.mWriteModel.o().setVoiceDuringTime(-1);
                }
            } else {
                this.mWriteModel.o().setVoice(null);
                this.mWriteModel.o().setVoiceDuringTime(-1);
            }
            this.mData.setRichTextEditorMode(this.isRichTextEditorMode);
            if (this.isRichTextEditorMode) {
                this.mData.setServerRichContent(this.mRichPostContent.getPostServerContentData());
            }
            if (!this.mWriteModel.e()) {
                showToast(R.string.obfuscated_res_0x7f0f1586);
            } else if (!mi.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c17);
            } else {
                startAsyncPostWrite();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postPhotoTextThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65791, this) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processSaveDraft() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65792, this) == null) {
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
                this.mData.setRichTextEditorMode(this.isRichTextEditorMode);
                if (this.isRichTextEditorMode) {
                    this.mData.setRichContentData(this.mRichPostContent.getPlainTextContentData());
                }
                int type = this.mData.getType();
                if (type == 0 || type == 9 || type == 11) {
                    if (this.isSaveDraft) {
                        if (this.isLocalChannelDynamic) {
                            fk8.v(this.mData);
                        } else if (this.mData.isEvaluate()) {
                            fk8.s(this.mData.getItem_id(), this.mData);
                        } else if (TextUtils.isEmpty(this.mData.getTopicId())) {
                            fk8.t(this.mData.getForumId(), this.mData);
                        } else {
                            fk8.A(this.mData.getTopicId(), this.mData);
                        }
                    }
                } else if (type == 7) {
                    if (this.isSaveDraft) {
                        fk8.t(BOTTLE_FORUM_ID, this.mData);
                    }
                } else if (type == 1) {
                    fk8.y(this.mData.getThreadId(), this.mData);
                } else if (type == 4) {
                    fk8.t(this.mData.getForumId() + PHOTO_LIVE_DRAFT_KEY, this.mData);
                } else if (type == 5) {
                    fk8.y(this.mData.getThreadId() + UPDATE_PHOTO_LIVE_DRAFT_KEY, this.mData);
                }
                this.isProcessedSaveDraft = true;
            }
        }
    }

    private void processTitleForPost(String str) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65793, this, str) == null) || this.mData == null || (linearLayout = this.mTitleView) == null) {
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65794, this) == null) && this.mData.getType() == 0 && this.mData.getTitle() != null) {
            this.live_post_title.setText(this.mData.getTitle());
            this.live_post_title.setSelection(this.mData.getTitle().length());
        }
    }

    private void realInsert(SpannableStringBuilder spannableStringBuilder, int i2, fo foVar, EmotionGroupType emotionGroupType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65795, this, spannableStringBuilder, i2, foVar, emotionGroupType) == null) || spannableStringBuilder == null || getRealContentEdittextInstance() == null || getRealContentEdittextInstance().getText() == null) {
            return;
        }
        Bitmap p2 = foVar.p();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(p2);
        int width = p2.getWidth();
        if (emotionGroupType != EmotionGroupType.USER_COLLECT && emotionGroupType != EmotionGroupType.BIG_EMOTION) {
            if (emotionGroupType == EmotionGroupType.LOCAL) {
                width = (int) (width * 0.5d);
            }
            bitmapDrawable.setBounds(0, 0, width, width);
        } else {
            bitmapDrawable.setBounds(0, 0, width, p2.getHeight());
        }
        bitmapDrawable.setGravity(119);
        spannableStringBuilder.setSpan(new bu4(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65796, this, z2) == null) || !TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) || this.isLivePhotoType || getRealContentEdittextInstance() == null) {
            return;
        }
        this.mPostContentBg.setPadding(0, 0, 0, 0);
        this.mPostContentBg.setBackgroundDrawable(null);
        SkinManager.setBackgroundColor(this.mPostContentBg, R.color.CAM_X0201);
        if (TextUtils.isEmpty(this.mBubbleUrl) || this.mAdditionData != null) {
            return;
        }
        ig.h().m(this.mBubbleUrl, 19, new a1(this, z2), getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshMutiImage(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65797, this, z2) == null) {
            WriteData writeData = this.mData;
            String forumId = writeData == null ? "" : writeData.getForumId();
            g19 g19Var = this.mWriteImageController;
            if (g19Var != null) {
                g19Var.k(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    private void refreshPostStatus(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65798, this, editable) == null) {
            if (!TextUtils.isEmpty(editable) && editable.length() >= 20 && editable.length() <= 500 && this.mWriteEvaluationeHeaderView.e()) {
                this.mPost.setEnabled(true);
            } else {
                this.mPost.setEnabled(false);
            }
        }
    }

    private void registerVideoPostClickUserCollectionToastTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65799, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921500, new o1(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    private void removeLastFunctionPhoto() {
        WriteImagesInfo writeImagesInfo;
        ImageFileInfo imageFileInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65800, this) == null) || (writeImagesInfo = this.writeImagesInfo) == null || writeImagesInfo.getChosedFiles() == null || this.writeImagesInfo.size() <= 0 || (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) == null || TextUtils.isEmpty(imageFileInfo.getFilePath()) || !imageFileInfo.getFilePath().startsWith("android.resource://")) {
            return;
        }
        this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestLocationIfValid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65801, this) == null) {
            if (this.mLocationModel.B()) {
                if (this.mLocationModel.F()) {
                    sendLocaionAction(2, true, bm8.a().b().getFormatted_address());
                    return;
                }
                sendLocaionAction(1, true, null);
                this.mLocationModel.K();
                return;
            }
            sendLocaionAction(0, true, null);
        }
    }

    private void requestPrivacyStateAction() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65802, this) == null) || (editorTools = this.mEditor) == null) {
            return;
        }
        editorTools.A(new i05(54, 15, null));
    }

    private void requestToDynamicStateAction() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65803, this) == null) || (editorTools = this.mEditor) == null) {
            return;
        }
        editorTools.A(new i05(57, 15, null));
    }

    private void resetCheckImgState(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65804, this, i2) == null) || i2 >= this.mPrefixItems.size()) {
            return;
        }
        for (int i3 = 0; i3 < this.mPrefixItems.size(); i3++) {
            this.mPrefixItems.get(i3).b(false);
        }
        this.mPrefixItems.get(i2).b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFinishSendAction(boolean z2) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65805, this, z2) == null) || (editorTools = this.mEditor) == null) {
            return;
        }
        editorTools.A(new i05(9, -1, Boolean.valueOf(z2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLocaionAction(int i2, boolean z2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65806, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str}) == null) {
            this.mLocationState = i2;
            EditorTools editorTools = this.mEditor;
            if (editorTools != null) {
                editorTools.A(new i05(19, 15, new y15(i2, z2, str)));
            }
        }
    }

    private void sendSetImgAction() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65807, this) == null) || this.isLivePhotoType) {
            return;
        }
        EditorTools editorTools = this.mEditor;
        if (editorTools != null) {
            editorTools.A(new i05(12, -1, new c15(this.writeImagesInfo, true)));
            this.mEditor.A(new i05(12, 11, new c15(this.writeImagesInfo, true)));
        }
        WriteData writeData = this.mData;
        String forumId = writeData == null ? "" : writeData.getForumId();
        g19 g19Var = this.mWriteImageController;
        if (g19Var != null) {
            g19Var.k(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUpdatePhotoLiveMessage(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65808, this, postWriteCallBackData) == null) {
            if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.mFrom)) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUCCES_IN_MISSON);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
        }
    }

    private void setAudioEnableStatus(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65809, this, bool) == null) {
            WriteData writeData = this.mData;
            if (getPageContext().getString(R.string.obfuscated_res_0x7f0f05f5).equals(writeData != null ? writeData.getForumName() : null)) {
                this.isFeedBack = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLeftCount(TextView textView, EditText editText) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65810, this, textView, editText) == null) || textView == null || editText == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65811, this) == null) {
            if (this.mData.getType() == 7) {
                this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f13aa));
                return;
            }
            String string = getPageContext().getString(R.string.obfuscated_res_0x7f0f10e8);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                string = getPageContext().getString(R.string.obfuscated_res_0x7f0f110e);
            }
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProtocolVisibility(List<mo4> list) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65812, this, list) == null) || list == null) {
            return;
        }
        boolean z2 = false;
        Iterator<mo4> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().b == 2) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65813, this, evaluateRelevanceItemSelectedMessage) == null) {
            WriteEvaluationHeaderView writeEvaluationHeaderView = this.mWriteEvaluationeHeaderView;
            if (writeEvaluationHeaderView != null) {
                writeEvaluationHeaderView.setVisibility(0);
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
                return;
            }
            ItemData itemData = new ItemData();
            itemData.itemId = mg.g(evaluateRelevanceItemSelectedMessage.item_id, 0L);
            itemData.mTags = evaluateRelevanceItemSelectedMessage.tags;
            itemData.mScore = evaluateRelevanceItemSelectedMessage.score;
            itemData.mStar = evaluateRelevanceItemSelectedMessage.star;
            itemData.mIconUrl = evaluateRelevanceItemSelectedMessage.icon_url;
            itemData.mIconSize = evaluateRelevanceItemSelectedMessage.icon_size;
            itemData.mTitle = evaluateRelevanceItemSelectedMessage.item_name;
            addAssociatedItem(itemData);
        }
    }

    private void showAdditionTip(boolean z2, String str) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65814, this, z2, str) == null) {
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
                    String format = String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f1581), Integer.valueOf(i2 - i3));
                    sb.append("\n");
                    sb.append(format);
                }
            }
            oi.N(getPageContext().getPageActivity(), sb.toString());
        }
    }

    private void showCommodityTip() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65815, this) == null) || (editorTools = this.mEditor) == null) {
            return;
        }
        editorTools.post(new p(this));
    }

    private void showEditorTopicTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65816, this) == null) {
            if (this.mTipController == null) {
                this.mTipController = new e19(getPageContext());
            }
            this.mTipController.c(this.mEditor);
        }
    }

    private void showLocPermissionDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65817, this) == null) {
            cr4 cr4Var = new cr4(getPageContext().getPageActivity());
            cr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0a40).setPositiveButton(R.string.obfuscated_res_0x7f0f0964, new h(this)).setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new g(this)).create(getPageContext());
            cr4Var.show();
        }
    }

    private void showRichModeGuide() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65818, this) == null) && this.richModeEnable && !vt4.k().h("key_rich_mode_guide_has_show", false)) {
            this.richModeGuideLayout.postDelayed(new d0(this), 500L);
            this.richModeGuideLayout.postDelayed(new e0(this), 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTipDialog(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(65819, this, z2, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
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
                errorString2 = getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0ff9);
            }
            showToast(errorString2);
        } else if (this.mData.getType() != 7) {
            if (this.mAdditionData == null) {
                en8.b(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                return;
            }
            showAdditionTip(z2, errorString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTipWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65820, this) == null) {
            EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this, EBusinessProtocolView.WindowType.TIP);
            eBusinessProtocolView.o(getResources().getString(R.string.obfuscated_res_0x7f0f13e5));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f13d2)).append((CharSequence) "\n");
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f13d3)).append((CharSequence) "\n");
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f13d4)).append((CharSequence) "\n");
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f13d5)).append((CharSequence) "\n");
            spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f13d6));
            eBusinessProtocolView.k(spannableStringBuilder);
            rg.i(eBusinessProtocolView, this);
        }
    }

    private void showVoteView() {
        WriteVoteData writeVoteData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65821, this) == null) {
            Serializable serializable = this.voteDataSerializable;
            if (serializable instanceof WriteVoteData) {
                writeVoteData = (WriteVoteData) serializable;
                this.mData.setWriteVoteData(writeVoteData);
            } else if (this.mData.getWriteVoteData() == null) {
                return;
            } else {
                writeVoteData = this.mData.getWriteVoteData();
            }
            r rVar = new r(this, writeVoteData);
            this.mVoteViewController.f(rVar);
            this.mVoteViewController.e(rVar);
            this.mVoteViewController.g(writeVoteData);
            this.mVoteViewController.h(true);
            refreshPostButton();
        }
    }

    private void startAsyncPostWrite() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65822, this) == null) {
            this.mWriteModel.I();
            o09.f(this.mData);
            stopVoice();
            processSaveDraft();
            if (PersonPolymericActivityConfig.VIDEO_PERSON_FROM_TOPIC_DETAIL.equals(this.mFrom)) {
                setResult(-1);
            } else {
                setResult(100);
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void stopVoice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65823, this) == null) {
            synchronized (this) {
                VoiceManager voiceManager = getVoiceManager();
                this.mVoiceManager = voiceManager;
                voiceManager.stopPlay();
            }
        }
    }

    private void takePhoto(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65824, this, str) == null) || PermissionUtil.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            return;
        }
        SelectImageHelper.takePhoto(getPageContext(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updataTitle() {
        WriteData writeData;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65825, this) == null) || (writeData = this.mData) == null) {
            return;
        }
        int type = writeData.getType();
        if (type != 0) {
            if (type == 7) {
                this.mPostTitle.setVisibility(0);
                this.mPostContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                this.mName.setText(R.string.obfuscated_res_0x7f0f0e94);
                return;
            } else if (type != 9) {
                if (type == 11) {
                    this.mName.setText(R.string.obfuscated_res_0x7f0f0ef4);
                    this.mPostTitle.setVisibility(0);
                    this.mPostContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                } else if (type == 4) {
                    this.mName.setText(R.string.obfuscated_res_0x7f0f0ef8);
                    this.mPostContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                } else if (type != 5) {
                    this.mName.setText(R.string.obfuscated_res_0x7f0f10ea);
                    this.mPostContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.mPostTitle.setVisibility(8);
                    return;
                } else {
                    this.mName.setText(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f148f, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.live_interval_view.setVisibility(8);
                    return;
                }
            }
        }
        if (!this.isFeedBack && !this.isFeedBackBar) {
            if (this.isLocalChannelDynamic) {
                this.mName.setText(R.string.obfuscated_res_0x7f0f0ea0);
            } else if (this.richModeEnable) {
                if (this.isRichTextEditorMode) {
                    this.mName.setText(R.string.obfuscated_res_0x7f0f0fc4);
                } else {
                    this.mName.setText(R.string.obfuscated_res_0x7f0f0c27);
                }
            } else {
                String str3 = this.mCallFrom;
                if (str3 != null && str3.equals("1")) {
                    this.mName.setText(R.string.obfuscated_res_0x7f0f0ea4);
                } else {
                    String str4 = this.mCallFrom;
                    if (str4 != null && str4.equals("2")) {
                        if (this.isEvaluate) {
                            this.mName.setText(R.string.obfuscated_res_0x7f0f0ef4);
                        } else if (StringUtils.isNull(this.mData.getForumName())) {
                            this.mName.setText(R.string.obfuscated_res_0x7f0f0ea5);
                        } else {
                            String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.obfuscated_res_0x7f0f0ea3) + this.mData.getForumName(), 9, true, false);
                            if (fixedBarText.length() < 14) {
                                str2 = fixedBarText + getResources().getString(R.string.obfuscated_res_0x7f0f02ca);
                            } else {
                                str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.obfuscated_res_0x7f0f02ca);
                            }
                            this.mName.setText(str2);
                        }
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.obfuscated_res_0x7f0f1144) + this.mData.getForumName() + getResources().getString(R.string.obfuscated_res_0x7f0f02ca));
                        this.mPostTitle.setVisibility(8);
                        String str5 = this.mMoreForumTitle + " " + this.mMoreForumUrl;
                        if (!StringUtils.isNull(str5)) {
                            this.mPostContent.setText(str5);
                        }
                    } else {
                        this.mName.setText("");
                    }
                }
            }
        } else if (this.isVcodeFeedBack) {
            this.mName.setText(R.string.obfuscated_res_0x7f0f05f8);
        } else {
            this.mName.setText(R.string.obfuscated_res_0x7f0f05f4);
        }
        this.mPostTitle.setVisibility(0);
        this.mPostContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
    }

    private void updateGriViewData() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65826, this) == null) && this.isLivePhotoType) {
            this.mPhotoLiveGridViewAdapter.l(this.writeImagesInfo);
            updateGridView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGridView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65827, this) == null) {
            this.mPhotoLiveGridViewAdapter.notifyDataSetChanged();
            this.mPhotoLiveGridView.invalidate();
            this.mHandler.postDelayed(new g1(this), 550L);
        }
    }

    private void updateGroup() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65828, this) == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHintTextColor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65829, this) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTitleStyle() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65830, this) == null) || (editText = this.mPostTitle) == null || editText.getText() == null || this.mPostTitle.getText().toString() == null || this.mPostTitle.getPaint() == null) {
            return;
        }
        if (this.mPostTitle.getText().toString().length() == 0) {
            this.mPostTitle.getPaint().setFakeBoldText(true);
        } else if (this.mPostTitle.getText().toString().length() > 0) {
            this.mPostTitle.getPaint().setFakeBoldText(true);
        }
    }

    public boolean canSelectVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !"1".equals(this.mCallFrom) && this.writeImagesInfo.size() == 0 && this.mVoiceModel == null : invokeV.booleanValue;
    }

    public void changeAssociatedItemContainerLayoutParams(boolean z2) {
        AssociatedItemContainer associatedItemContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z2) == null) || (associatedItemContainer = this.associatedItemContainer) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) associatedItemContainer.getLayoutParams();
        if (z2) {
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.M_H_X004);
        } else {
            layoutParams.topMargin = 0;
        }
        this.associatedItemContainer.setLayoutParams(layoutParams);
    }

    public void changeToolButtonStatus() {
        EditorTools editorTools;
        i15 i15Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (editorTools = this.mEditor) == null) {
            return;
        }
        editorTools.setBarLauncherEnabled(!this.isDisalbeButtons);
        this.mEditor.setDeskLauncherEnabled(!this.isDisalbeButtons);
        this.mEditor.setToolEnabled(true, 26);
        this.mEditor.setToolEnabled(true, 2);
        this.mEditor.setToolEnabled(true, 30);
        this.mEditor.setToolEnabled(false, 34);
        if (this.isLocalChannelDynamic) {
            this.mEditor.setToolEnabled(false, 31);
        }
        u05 n2 = this.mEditor.n(5);
        if (n2 != null) {
            n2.d(true);
        }
        a09 a09Var = this.mWriteTool;
        if (a09Var != null && !this.isLocalChannelDynamic) {
            a09Var.m(true);
        }
        refreshImageLauncher();
        refreshVideoLauncher();
        refreshItemTool();
        refreshCommercialTool();
        refreshVoteTool();
        if (this.isEvaluate && (i15Var = this.mLinkTool) != null && !i15Var.c()) {
            this.mEditor.setToolEnabled(false, 31);
        } else {
            this.mEditor.setToolEnabled(!this.isRichTextEditorMode, 31);
        }
        this.mEditor.setToolEnabled(!this.isRichTextEditorMode, 6);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.isLocalChannelDynamic) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        xt4 xt4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (xt4Var = this.mLoadingDialog) == null) {
            return;
        }
        xt4Var.h(false);
    }

    public void deleteChar() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || getRealContentEdittextInstance().getSelectionStart() <= 0) {
            return;
        }
        String substring = getRealContentEdittextInstance().getText().toString().substring(0, getRealContentEdittextInstance().getSelectionStart());
        Matcher matcher = t86.b.matcher(substring);
        if (matcher.find()) {
            getRealContentEdittextInstance().getText().delete(getRealContentEdittextInstance().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), getRealContentEdittextInstance().getSelectionStart());
            return;
        }
        getRealContentEdittextInstance().onKeyDown(67, this.keyEventDown);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (this.mGestureDetector.onTouchEvent(motionEvent)) {
                motionEvent.setAction(3);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.isLocalChannelDynamic) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
            }
        }
    }

    public String getCallFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mCallFrom : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.v75
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mFrom : (String) invokeV.objValue;
    }

    public FrsTabInfoData getFrsTabInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mFrsTabList : (FrsTabInfoData) invokeV.objValue;
    }

    public EditText getRealContentEdittextInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.isLivePhotoType ? this.live_post_content : this.isRichTextEditorMode ? this.mRichPostContent.getLastFocusEdit() : this.mPostContent : (EditText) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public synchronized VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this) {
                if (this.mVoiceManager == null) {
                    this.mVoiceManager = VoiceManager.instance();
                }
                voiceManager = this.mVoiceManager;
            }
            return voiceManager;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public WriteData getWriteData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mData : (WriteData) invokeV.objValue;
    }

    public void initTitleView() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.isEvaluate) {
                this.mTitleView.setVisibility(8);
                WriteImageGridView writeImageGridView = this.imageGridView;
                if (writeImageGridView != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) writeImageGridView.getLayoutParams();
                    layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                    this.imageGridView.setLayoutParams(layoutParams);
                }
                this.mTitleViewDivider.setVisibility(8);
            } else if (o09.d()) {
                this.mPostTitle.setHint(R.string.obfuscated_res_0x7f0f13f0);
                this.mTitleView.setVisibility(0);
                WriteImageGridView writeImageGridView2 = this.imageGridView;
                if (writeImageGridView2 != null) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) writeImageGridView2.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    this.imageGridView.setLayoutParams(layoutParams2);
                }
                this.mTitleViewDivider.setVisibility(0);
                this.mTitleView.requestFocus();
            } else {
                this.mPostTitle.setHint(this.isFeedBack ? R.string.obfuscated_res_0x7f0f05f7 : R.string.obfuscated_res_0x7f0f0ea2);
                if (!this.isFeedBack && ListUtils.isEmpty(this.mList) && ((writeData = this.mData) == null || StringUtils.isNull(writeData.getTitle()))) {
                    this.mTitleView.setVisibility(8);
                    WriteImageGridView writeImageGridView3 = this.imageGridView;
                    if (writeImageGridView3 != null) {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) writeImageGridView3.getLayoutParams();
                        layoutParams3.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                        this.imageGridView.setLayoutParams(layoutParams3);
                    }
                    this.mTitleViewDivider.setVisibility(8);
                } else {
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
            if (this.isLocalChannelDynamic) {
                this.mPostTitle.setHint(R.string.obfuscated_res_0x7f0f13f1);
            }
        }
    }

    public void initializePostContent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.mPostContentBg = findViewById(R.id.obfuscated_res_0x7f0918a1);
            RichTextEditor richTextEditor = (RichTextEditor) findViewById(R.id.obfuscated_res_0x7f091a86);
            this.mRichPostContent = richTextEditor;
            richTextEditor.setWriteImagesInfo(this.writeImagesInfo);
            SpanGroupEditText spanGroupEditText = (SpanGroupEditText) findViewById(R.id.obfuscated_res_0x7f0918a0);
            this.mPostContent = spanGroupEditText;
            spanGroupEditText.setDrawingCacheEnabled(false);
            this.mPostContent.setOnClickListener(this.mEditOnClicked);
            y0 y0Var = new y0(this);
            this.mPostContent.setOnSpanGroupChangedListener(y0Var);
            this.mPostContent.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY);
            this.mPostContent.setForumId(mg.g(this.mData.getForumId(), 0L));
            ym8 ym8Var = this.mWriteModel;
            if (ym8Var != null) {
                ym8Var.G(this.mPostContent.getSpanGroupManager());
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
                        this.mPostContent.setText(getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0f9d, new Object[]{this.mSubUserName}));
                        SpanGroupEditText spanGroupEditText3 = this.mPostContent;
                        spanGroupEditText3.setSelection(spanGroupEditText3.getText().length());
                    }
                } else if (this.mData.getFloorNum() > 0) {
                    this.mPostContent.setText(String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f0f9f), Integer.valueOf(this.mData.getFloorNum())));
                    SpanGroupEditText spanGroupEditText4 = this.mPostContent;
                    spanGroupEditText4.setSelection(spanGroupEditText4.getText().length());
                }
            }
            this.mPostContent.setOnFocusChangeListener(this.mFocusChangeListener);
            this.mPostContent.setOnTouchListener(new z0(this));
            this.mPostContent.addTextChangedListener(this.mWriteContentTextWatcher);
            if (this.mData.getType() == 0) {
                this.mIsWillShowBubble = true;
            } else {
                refreshBubble(true);
                this.mIsWillShowBubble = false;
            }
            if (this.isEvaluate) {
                SpannableString spannableString = new SpannableString(" " + ((Object) getResources().getText(R.string.obfuscated_res_0x7f0f1583)));
                Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080978, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL);
                pureDrawable.setBounds(0, 0, pureDrawable.getIntrinsicWidth(), pureDrawable.getIntrinsicHeight());
                spannableString.setSpan(new x86(pureDrawable, 1, oi.f(this, R.dimen.tbds4)), 0, 1, 17);
                this.mPostContent.setHint(spannableString);
            } else if (this.mData.isUserFeedback()) {
                this.mPostContent.setHint(R.string.obfuscated_res_0x7f0f1587);
            } else {
                this.mPostContent.setHint(R.string.obfuscated_res_0x7f0f0a6e);
            }
            this.mRichPostContent.setOnSpanGroupChangedListener(y0Var);
            this.mRichPostContent.setForumId(mg.g(this.mData.getForumId(), 0L));
            this.mRichPostContent.setEditOnClickListener(this.mEditOnClicked);
            this.mRichPostContent.setEditOnFocusChangeListener(this.mFocusChangeListener);
            this.mRichPostContent.setBigEmotionSpanHandler(this.mBigEmotionSpanHanlder);
            this.mRichPostContent.j(this.mWriteContentTextWatcher);
            this.mRichPostContent.m();
            initTextEditorMode();
        }
    }

    public void initializePostTitle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            HeadImageView headImageView = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f09228b);
            this.mUserHeaderPortrait = headImageView;
            headImageView.setIsRound(true);
            this.mUserHeaderPortrait.setDrawBorder(false);
            this.mUserHeaderPortrait.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (!StringUtils.isNull(currentPortrait)) {
                String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(currentPortrait);
                this.mUserHeaderPortrait.setUrl(headPortraitFilter);
                this.mUserHeaderPortrait.K(headPortraitFilter, 12, false);
            }
            if (this.mData.isUserFeedback()) {
                this.mUserHeaderPortrait.setVisibility(0);
            }
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f0918c2);
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
                this.mPostTitle.setText(getResources().getString(R.string.obfuscated_res_0x7f0f14c0));
            }
            this.mPostTitle.addTextChangedListener(this.mWriteTitleTextWatcher);
            this.mPostTitle.setFilters(new InputFilter[]{new o09.b(this.mPostTitle, 31, new w0(this))});
            vr4.d(this.mPostTitle).A(R.string.F_X02);
            if (this.mData.getHaveDraft()) {
                return;
            }
            initPostTopic();
            this.hasSetTitleUseHotTopic = true;
        }
    }

    public void insertFaceIconToEditText(zw4 zw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, zw4Var) == null) {
            if (((ImageSpan[]) getRealContentEdittextInstance().getText().getSpans(0, getRealContentEdittextInstance().getText().length(), ImageSpan.class)).length >= 10) {
                if (this.mTooManyEmotionToast == null) {
                    this.mTooManyEmotionToast = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.obfuscated_res_0x7f0f1403, 0);
                }
                this.mTooManyEmotionToast.show();
                return;
            }
            u86.b(this, zw4Var, getRealContentEdittextInstance());
        }
    }

    public void intializePostButton() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.mPost.setOnClickListener(new v0(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    public void onActivityResult(int i2, int i3, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        String str;
        int i4;
        LocalChannelTopicSelectView localChannelTopicSelectView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048597, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (i2 != 25068) {
                    PostWriteCallBackData postWriteCallBackData2 = null;
                    postWriteCallBackData2 = null;
                    postWriteCallBackData2 = null;
                    if (i2 == 12004) {
                        if (this.mPostTitle == getCurrentFocus()) {
                            getRealContentEdittextInstance().clearFocus();
                            this.mPostTitle.requestFocus();
                            EditorTools editorTools = this.mEditor;
                            if (editorTools != null) {
                                editorTools.q();
                            }
                            ShowSoftKeyPadDelay(this.mPostTitle);
                        } else {
                            getRealContentEdittextInstance().requestFocus();
                            EditorTools editorTools2 = this.mEditor;
                            if (editorTools2 != null) {
                                editorTools2.q();
                            }
                            ShowSoftKeyPadDelay(this.mPostContent);
                        }
                        ArrayList parcelableArrayListExtra = intent != null ? intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA) : null;
                        int selectionStart = getRealContentEdittextInstance().getSelectionStart();
                        if (selectionStart > 0) {
                            int i5 = selectionStart - 1;
                            if (getRealContentEdittextInstance().getText().toString().charAt(i5) == '@') {
                                getRealContentEdittextInstance().getEditableText().delete(i5, selectionStart);
                            }
                        }
                        if (this.richModeEnable && this.isRichTextEditorMode) {
                            this.mRichPostContent.k(parcelableArrayListExtra);
                        } else if (getRealContentEdittextInstance() instanceof SpanGroupEditText) {
                            ((SpanGroupEditText) getRealContentEdittextInstance()).e(parcelableArrayListExtra);
                        }
                        if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
                            getRealContentEdittextInstance().getText().delete(getRealContentEdittextInstance().getSelectionStart(), getRealContentEdittextInstance().getSelectionEnd());
                            if (this.richModeEnable && this.isRichTextEditorMode) {
                                this.mRichPostContent.g(parcelableArrayListExtra);
                            } else if (getRealContentEdittextInstance() instanceof SpanGroupEditText) {
                                ((SpanGroupEditText) getRealContentEdittextInstance()).b(parcelableArrayListExtra);
                            }
                        }
                    } else if (i2 == 12006) {
                        if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) {
                            postWriteCallBackData2 = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                        }
                        clearDraft();
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
                                pg.a().post(new f1(this));
                            }
                            showPicOrVideo(ListUtils.getCount(this.writeImagesInfo.getChosedFiles()) > 0, false);
                            if (this.mIsWillShowBubble) {
                                refreshBubble(true);
                                this.mIsWillShowBubble = false;
                            }
                        } else if (i2 == 12012) {
                            if (this.isRichTextEditorMode) {
                                getEditDataOnRichTextMode(intent);
                            } else if (!this.isLivePhotoType) {
                                getMotuData(intent);
                                refreshPostButton();
                            } else {
                                getAlbumDataForPhotoLive(intent);
                            }
                        } else if (i2 == 13010) {
                            VideoInfo videoInfo = new VideoInfo();
                            videoInfo.parseFromIntent(intent);
                            if (videoInfo.isAvaliable()) {
                                this.mData.setVideoInfo(videoInfo);
                                this.mEditor.A(new i05(2, 19, " "));
                                this.mEditor.A(new i05(28, 20, videoInfo));
                            } else {
                                this.mEditor.A(new i05(5, -1, null));
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
                            StringBuilder sb = new StringBuilder();
                            if (this.needAddHotTopicSign) {
                                sb.append("#");
                                this.needAddHotTopicSign = false;
                            }
                            sb.append(stringExtra);
                            addHotTopic(sb.toString());
                        } else if (i2 != 25005 || intent == null || ListUtils.isEmpty(this.mList)) {
                            if (i2 == 25048) {
                                if (intent == null) {
                                    return;
                                }
                                Serializable serializableExtra = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
                                if (serializableExtra instanceof WriteVoteData) {
                                    this.voteDataSerializable = serializableExtra;
                                    showVoteView();
                                }
                            } else if (i2 == 25049 && intent != null) {
                                String str2 = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT) + " ";
                                int selectionStart2 = this.mPostContent.getSelectionStart();
                                int selectionEnd = this.mPostContent.getSelectionEnd();
                                if (selectionStart2 >= 0) {
                                    Editable text = this.mPostContent.getText();
                                    if (selectionEnd > selectionStart2) {
                                        text.replace(selectionStart2, selectionEnd, str2);
                                    } else {
                                        text.insert(selectionStart2, str2);
                                    }
                                }
                            } else if (i2 == 25064) {
                                if (kz8.b()) {
                                    if (this.writeImagesInfo == null || this.mData == null) {
                                        return;
                                    }
                                    if (this.mPostTitle.getText().toString() != null) {
                                        str = this.mPostTitle.getText().toString();
                                        i4 = 5;
                                    } else {
                                        str = this.mTitleTemp;
                                        i4 = 1;
                                    }
                                    if (this.mSelectForumData == null && this.mData.getForumName() != null) {
                                        kz8.f(getPageContext(), str, this.mPostContent.getText().toString(), this.mData.getForumId(), this.mData.getForumName(), 3, Boolean.FALSE, "", "", "");
                                    } else {
                                        kz8.f(getPageContext(), str, this.mPostContent.getText().toString(), this.mData.getForumId(), this.mData.getForumName(), i4, Boolean.TRUE, "", "", "");
                                    }
                                } else {
                                    jumpToVideoAlbumActivity(0);
                                }
                            }
                        } else if (ListUtils.isEmpty(this.mList) || intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) >= this.mList.size()) {
                            return;
                        } else {
                            HotTopicBussinessData hotTopicBussinessData = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                            this.mCurrHotData = hotTopicBussinessData;
                            changeHotTopicData(hotTopicBussinessData);
                        }
                    }
                } else if (!this.isLocalChannelDynamic || intent == null || (localChannelTopicSelectView = this.mLocalChannelTopicSelectView) == null || localChannelTopicSelectView.getVisibility() != 0) {
                    return;
                } else {
                    String stringExtra2 = intent.getStringExtra(LocalChannelTopicListActivityConfig.KEY_RESPONSE_TOPIC);
                    this.localChannelTopic = stringExtra2;
                    this.mLocalChannelTopicSelectView.setLocalChannelTopic(stringExtra2);
                }
            } else if (i3 == 0) {
                EditorTools editorTools3 = this.mEditor;
                if (editorTools3 != null && !editorTools3.u()) {
                    this.mPostContent.requestFocus();
                    this.mInputManager.toggleSoftInput(0, 2);
                    this.mEditor.q();
                }
                if (i2 == 12001) {
                    deleteTempCameraFile();
                } else if (i2 == 12002) {
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    updateGriViewData();
                    if (this.mIsWillShowBubble) {
                        refreshBubble(true);
                        this.mIsWillShowBubble = false;
                    }
                } else if (i2 != 12004) {
                    if (i2 != 12006) {
                        if (i2 == 12010) {
                            this.photoName = String.valueOf(System.currentTimeMillis());
                            SelectImageHelper.takePhoto(getPageContext(), this.photoName);
                        } else if (i2 == 12012) {
                            updateGriViewData();
                        } else if (i2 == 25004) {
                            if ("from_title".equals(this.fromWhereToHotSelect)) {
                                getRealTitleInstance().requestFocus();
                            } else if ("from_content".equals(this.fromWhereToHotSelect)) {
                                getRealContentEdittextInstance().requestFocus();
                            }
                        }
                    } else if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.mHighLightController.o(postWriteCallBackData.getErrorString());
                        this.mHighLightController.n(postWriteCallBackData.getSensitiveWords());
                        this.mHighLightController.i(this.mPostTitle, this.mPostContent);
                    }
                } else if (this.mPostTitle == getCurrentFocus()) {
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
            }
            changeToolButtonStatus();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            super.onChangeSkinType(i2);
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.mParent);
            getLayoutMode().j(this.mBubbleLayout);
            SkinManager.setBackgroundColor(this.mParent, R.color.CAM_X0205);
            if (this.mRecImgView != null && (i2 == 1 || i2 == 4)) {
                this.mRecImgView.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            }
            RichTextEditor richTextEditor = this.mRichPostContent;
            if (richTextEditor != null) {
                richTextEditor.v();
            }
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            if (this.mNavigationBar.getBackImageView() != null) {
                this.mNavigationBar.getBackImageView().setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b9, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            }
            this.mPost.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, i2));
            changeToolButtonStatus();
            SkinManager.setViewTextColor(this.richModeTextGuide1, (int) R.color.CAM_X0303);
            SkinManager.setViewTextColor(this.richModeTextGuide2, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.richModeTextGuide3, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.richModeTextGuide4, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.richModeGuideMain, R.drawable.obfuscated_res_0x7f080fb7);
            SkinManager.setBackgroundColor(this.mInterval, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.live_interval_view, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(getRealTitleInstance(), R.color.CAM_X0205);
            this.mIvDeleteVoice.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080918, SkinManager.getColor(R.color.CAM_X0107), null));
            this.mVoicePlayButton.d();
            if (TextUtils.isEmpty(this.mBubbleUrl)) {
                if (this.isLivePhotoType) {
                    SkinManager.setBackgroundColor(this.live_post_content, R.color.CAM_X0205);
                } else {
                    SkinManager.setBackgroundColor(this.mPostContentBg, R.color.CAM_X0205);
                }
            }
            refreshPostButton();
            this.mEditor.w(i2);
            PostCategoryView postCategoryView = this.mCategoryView;
            if (postCategoryView != null) {
                postCategoryView.b();
            }
            b19 b19Var = this.mAdapter;
            if (b19Var != null) {
                b19Var.notifyDataSetChanged();
            }
            SkinManager.setViewTextColor(this.mName, (int) R.color.CAM_X0105);
            this.mWriteImageController.d.notifyDataSetChanged();
            updateHintTextColor();
            updateTitleStyle();
            refreshBubble(false);
            a19 a19Var = this.mHighLightController;
            if (a19Var != null) {
                a19Var.m(getRealTitleInstance(), getRealContentEdittextInstance());
            }
            LocalChannelTopicSelectView localChannelTopicSelectView = this.mLocalChannelTopicSelectView;
            if (localChannelTopicSelectView != null) {
                localChannelTopicSelectView.b();
            }
            ForumSelectedView forumSelectedView = this.mForumSelectedView;
            if (forumSelectedView != null) {
                forumSelectedView.c();
            }
            WriteEvaluationHeaderView writeEvaluationHeaderView = this.mWriteEvaluationeHeaderView;
            if (writeEvaluationHeaderView != null) {
                writeEvaluationHeaderView.f();
            }
            ForumTabSelectedView forumTabSelectedView = this.mForumTabSelectedView;
            if (forumTabSelectedView != null) {
                forumTabSelectedView.k(i2);
            }
            p19 p19Var = this.mVoteViewController;
            if (p19Var != null) {
                p19Var.d(i2);
            }
            EBusinessProtocolView eBusinessProtocolView = this.mEBusinessProtocolView;
            if (eBusinessProtocolView != null) {
                eBusinessProtocolView.j(i2);
            }
            TextView textView = this.mPostContentCounter;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0301);
            }
            AssociatedItemContainer associatedItemContainer = this.associatedItemContainer;
            if (associatedItemContainer != null) {
                associatedItemContainer.c();
            }
        }
    }

    public void onCommodityClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (!checkContainHaowuTab()) {
                BdToast.i(this, getString(R.string.obfuscated_res_0x7f0f0e9c), R.drawable.obfuscated_res_0x7f0809a9, true).q();
            } else if (!this.canGoods) {
                BdToast.i(this, getString(R.string.obfuscated_res_0x7f0f0e9d), R.drawable.obfuscated_res_0x7f0809a9, true).q();
            } else {
                if (this.mData != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_CLICK).param("obj_locate", 2).param("fid", this.mData.getForumId()).param("fname", this.mData.getForumName()));
                }
                if (!vt4.k().h("commodity_goods_show_first_dialog", false)) {
                    cr4 cr4Var = new cr4(getPageContext().getPageActivity());
                    cr4Var.setContentViewSize(2);
                    cr4Var.setCanceledOnTouchOutside(false);
                    FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(getPageContext().getPageActivity());
                    frsPublishFineGoodsDialogView.setConfirmButtonListener(new m1(this, cr4Var));
                    cr4Var.setContentView(frsPublishFineGoodsDialogView);
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_SHOW).param("obj_locate", 2);
                    WriteData writeData = this.mData;
                    StatisticItem param2 = param.param("fid", writeData != null ? writeData.getForumId() : "");
                    WriteData writeData2 = this.mData;
                    TiebaStatic.log(param2.param("fname", writeData2 != null ? writeData2.getForumName() : ""));
                    cr4Var.create(getPageContext()).show();
                    return;
                }
                String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=" + getStillCommodityNum()));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            if (bundle != null) {
                this.isLocalChannelDynamic = bundle.getBoolean(WriteActivityConfig.KEY_POST_LOCAL_CHANNEL_DYNAMIC);
                this.localChannelTopic = bundle.getString(WriteActivityConfig.KEY_LOCAL_CHANNEL_TOPIC);
            } else if (getIntent() != null) {
                Intent intent = getIntent();
                this.isLocalChannelDynamic = intent.getBooleanExtra(WriteActivityConfig.KEY_POST_LOCAL_CHANNEL_DYNAMIC, false);
                this.localChannelTopic = intent.getStringExtra(WriteActivityConfig.KEY_LOCAL_CHANNEL_TOPIC);
            }
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new s1(this, null));
            this.mInputManager = (InputMethodManager) getSystemService("input_method");
            initListener();
            initData(bundle);
            if (this.needClosePrePage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921583));
            }
            if (this.mData.getType() == 0) {
                jumpToAlbumActivity(this.isAblumThread);
            }
            initUI();
            getTopList();
            LocationModel locationModel = new LocationModel(getPageContext());
            this.mLocationModel = locationModel;
            locationModel.Q(this.mOnLocationCallBack);
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
            loadDraft();
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
            qw8 qw8Var = new qw8(getPageContext().getPageActivity(), new q0(this), new Date().getHours(), new Date().getMinutes(), false);
            this.dialog = qw8Var;
            qw8Var.setTitle(R.string.obfuscated_res_0x7f0f0c34);
            this.dialog.setButton(-1, getPageContext().getString(R.string.obfuscated_res_0x7f0f025d), this.dialog);
            this.dialog.setButton(-2, getPageContext().getString(R.string.obfuscated_res_0x7f0f036e), this.dialog);
            return this.dialog;
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.mNavigationBar.removeCallbacks(this.handleLastError);
            ym8 ym8Var = this.mWriteModel;
            if (ym8Var != null) {
                ym8Var.t();
            }
            hideEditorTopicTip();
            hideCommodityTip();
            TiebaPrepareImageService.StopService();
            stopTask(true);
            if (!this.isProcessedSaveDraft) {
                processSaveDraft();
            }
            rg.a(this.saveDraftDialog, this);
            super.onDestroy();
            getVoiceManager().onDestory(getPageContext());
            this.mHandler.removeCallbacksAndMessages(null);
            g19 g19Var = this.mWriteImageController;
            if (g19Var != null) {
                g19Var.f();
            }
            nz5 nz5Var = this.mPiefixTipController;
            if (nz5Var != null) {
                nz5Var.I();
            }
            MessageManager.getInstance().unRegisterTask(2921500);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.post_prefix_layout.setSelected(false);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mPrefixIcon, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
            ShowSoftKeyPadDelay(this.mPostContent);
        }
    }

    @Override // com.repackage.fk8.f
    public void onDraftLoaded(WriteData writeData) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, writeData) == null) || WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) || this.isProductTie || this.fromErrorDialog) {
            return;
        }
        if (this.richModeEnable && (writeImagesInfo = this.writeImagesInfo) != null && writeImagesInfo.size() > 0) {
            showRichModeGuide();
        } else if (writeData != null) {
            if (this.mData != null && writeData.isEvaluate() == this.mData.isEvaluate()) {
                int i2 = 0;
                boolean z2 = (this.mData.getWriteImagesInfo() == null || ListUtils.isEmpty(this.mData.getWriteImagesInfo().getChosedFiles())) ? false : true;
                boolean z3 = !ni.isEmpty(getRealTitleInstance().getText().toString());
                boolean z4 = !ni.isEmpty(getRealContentEdittextInstance().getText().toString());
                boolean z5 = !ni.isEmpty(writeData.getTitle());
                boolean z6 = !ni.isEmpty(writeData.getContent());
                boolean z7 = !ListUtils.isEmpty(writeData.getRichContentData());
                this.mData.setHaveDraft(true);
                if (this.richModeEnable) {
                    boolean isRichTextEditorMode = writeData.isRichTextEditorMode();
                    this.isRichTextEditorMode = isRichTextEditorMode;
                    this.mData.setRichTextEditorMode(isRichTextEditorMode);
                    if (this.isRichTextEditorMode) {
                        onRichTextEditorMode();
                        showRichModeGuide();
                    } else {
                        onNormalTextEditorMode();
                    }
                } else {
                    this.isRichTextEditorMode = false;
                    onNormalTextEditorMode();
                }
                if (!z2) {
                    fillVideoOrImage(writeData);
                }
                if (!z3 || this.hasSetTitleUseHotTopic || ((this.isFeedBack || this.isFeedBackBar) && z5)) {
                    fillTitle(writeData);
                }
                if (z6 && (!z4 || this.isFeedBack || this.isFeedBackBar)) {
                    fillContent(writeData);
                }
                if (z7) {
                    fillRichContent(writeData);
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
                    refreshVideoLauncher();
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    loadDraftImageForPhotoLive();
                }
                if (!ListUtils.isEmpty(writeData.getItemDatas()) && !hasWriteVote() && 10 - getStillCommodityNum() == 0) {
                    Iterator<ItemData> it = writeData.getItemDatas().iterator();
                    while (it.hasNext()) {
                        addAssociatedItem(it.next());
                    }
                }
                changeToolButtonStatus();
                refreshPostButton();
                updataTitle();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.mCategoryList != null) {
                    ce6 ce6Var = this.mCategoryDefault;
                    this.mCategoryToID = ce6Var.b;
                    this.mCategoryName = ce6Var.a;
                    while (true) {
                        if (i2 == this.mCategoryList.size()) {
                            break;
                        }
                        ce6 ce6Var2 = this.mCategoryList.get(i2);
                        if (categoryTo == ce6Var2.b) {
                            this.mCategoryToID = categoryTo;
                            this.mCategoryName = ce6Var2.a;
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
            }
        } else {
            loadDraftImageForPhotoLive();
            initPostTopic();
            showRichModeGuide();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Editable text;
        int selectionStart;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048605, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                jz8 jz8Var = this.mPrefixWindow;
                if (jz8Var != null && jz8Var.isShowing()) {
                    rg.d(this.mPrefixWindow, getPageContext().getPageActivity());
                    return true;
                } else if (this.mEditor.u()) {
                    this.mEditor.q();
                    return true;
                } else if (this.richModeGuideLayout.getVisibility() == 0) {
                    this.richModeGuideLayout.performClick();
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
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            super.onKeyboardHeightChanged(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z2) == null) {
            this.isKeyboardVisibility = z2;
            if (this.isAttach && System.currentTimeMillis() - this.recTimeStamp < 800) {
                oi.w(getPageContext().getPageActivity(), getCurrentFocus());
                this.isAttach = false;
            }
            a09 a09Var = this.mWriteTool;
            if (a09Var != null && !z2) {
                a09Var.g();
            }
            if (this.mTipController != null && !z2) {
                hideEditorTopicTip();
            }
            if (this.mCommodityTipController == null || z2) {
                return;
            }
            hideCommodityTip();
        }
    }

    public void onLocViewClickedInInitState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (!this.mLocationModel.G(getPageContext().getPageActivity())) {
                showToast(R.string.obfuscated_res_0x7f0f0a47);
                sendLocaionAction(0, true, null);
            } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
                showLocPermissionDialog();
            } else if (this.mLocationModel.F()) {
                goToSelectLocationActivity();
            } else {
                this.mLocationModel.P(false);
                sendLocaionAction(1, true, null);
                this.mLocationModel.K();
            }
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, intent) == null) {
            super.onNewIntent(intent);
            if (intent == null) {
                return;
            }
            if (this.isRichTextEditorMode) {
                getCameraDataOnRichTextMode(intent);
                return;
            }
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            if (stringExtra == null || (writeImagesInfo = this.writeImagesInfo) == null) {
                return;
            }
            writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                sendSetImgAction();
            }
            refreshMutiImage(true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            HidenSoftKeyPad(this.mInputManager, getRealTitleInstance());
            HidenSoftKeyPad(this.mInputManager, getRealContentEdittextInstance());
            super.onPause();
            getVoiceManager().onPause(getPageContext());
            if (this.mEditor.u()) {
                this.mEditor.q();
            }
        }
    }

    @Override // com.repackage.jz8.a
    public void onPrefixItemClick(int i2) {
        PostPrefixData postPrefixData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048611, this, i2) == null) || (postPrefixData = this.mPrefixData) == null) {
            return;
        }
        if (i2 == ListUtils.getCount(postPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new StatisticItem("c13014").param("obj_type", 1));
        } else {
            TiebaStatic.log(new StatisticItem("c13014").param("obj_type", 2));
        }
        this.mCurrPrefixPos = i2;
        this.mPrefixWindow.c(i2);
        resetCheckImgState(i2);
        this.mPrefix.setText(this.mPrefixData.getPrefixs().get(i2));
        refreshPostButton();
        rg.d(this.mPrefixWindow, getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048612, this, i2, dialog) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048613, this, i2, strArr, iArr) == null) {
            if (i2 == 0) {
                super.onRequestPermissionsResult(i2, strArr, iArr);
                onLocViewClickedInInitState();
            } else if (i2 == 1) {
                ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
                if (PermissionUtil.checkCamera(getApplicationContext())) {
                    SelectImageHelper.takePhoto(getPageContext(), this.photoName);
                } else {
                    showToast(R.string.obfuscated_res_0x7f0f1319);
                }
                if (!transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") || transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                    return;
                }
                showToast(R.string.obfuscated_res_0x7f0f107d);
            } else {
                super.onRequestPermissionsResult(i2, strArr, iArr);
            }
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
            String obj = getRealContentEdittextInstance().getEditableText().toString();
            if (obj != null) {
                getRealContentEdittextInstance().setText(TbFaceManager.e().l(getPageContext().getPageActivity(), obj, this.mBigEmotionSpanHanlder));
                getRealContentEdittextInstance().setSelection(getRealContentEdittextInstance().getText().length());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
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
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, bundle) == null) {
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
            bundle.putBoolean(WriteActivityConfig.NEED_CLOSE_PRE_PAGE, this.needClosePrePage);
            bundle.putInt(WriteActivityConfig.KEY_STATISTIS_FROM, this.mData.getStatisticFrom());
            super.onSaveInstanceState(bundle);
            getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onStart();
            getVoiceManager().onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onStop();
            getVoiceManager().onStop(getPageContext());
            getWindow().setSoftInputMode(18);
        }
    }

    public void openImageActivity(i05 i05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, i05Var) == null) {
            if (this.isLivePhotoType) {
                removeLastFunctionPhoto();
            }
            if (this.mEditor.u()) {
                this.mEditor.q();
            }
            if (this.isRichTextEditorMode) {
                jumpToAlbumActivityOnRichTextMode();
            } else {
                jumpToAlbumActivity(0);
            }
        }
    }

    public void openVideoActivity(i05 i05Var) {
        String str;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, i05Var) == null) {
            if (this.isLivePhotoType) {
                removeLastFunctionPhoto();
            }
            if (this.mEditor.u()) {
                this.mEditor.q();
            }
            int a2 = kz8.a();
            if (kz8.c(a2)) {
                kz8.e(getPageContext().getPageActivity(), a2, WorkPublishOpenHelper.OPEN_WORK_PUBLISH_FROM_FRS_WRITE);
            } else if (kz8.b()) {
                if (this.writeImagesInfo == null || this.mData == null) {
                    return;
                }
                if (this.mPostTitle.getText().toString() != null) {
                    str = this.mPostTitle.getText().toString();
                    i2 = 5;
                } else {
                    str = this.mTitleTemp;
                    i2 = 1;
                }
                if (this.mSelectForumData == null && this.mData.getForumName() != null) {
                    kz8.f(getPageContext(), str, this.mPostContent.getText().toString(), this.mData.getForumId(), this.mData.getForumName(), 3, Boolean.FALSE, "", "", "");
                } else {
                    kz8.f(getPageContext(), str, this.mPostContent.getText().toString(), this.mData.getForumId(), this.mData.getForumName(), i2, Boolean.TRUE, "", "", "");
                }
            } else {
                jumpToVideoAlbumActivity(0);
            }
        }
    }

    public void refreshCommercialTool() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || (writeData = this.mData) == null) {
            return;
        }
        this.mEditor.setToolEnabled(ListUtils.isEmpty(writeData.getItemDatas()) && !this.isRichTextEditorMode, 33);
    }

    public void refreshImageLauncher() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || this.mEditor.n(10) == null) {
            return;
        }
        WriteImagesInfo writeImagesInfo = this.writeImagesInfo;
        this.mEditor.setToolEnabled(writeImagesInfo == null || ListUtils.getCount(writeImagesInfo.getChosedFiles()) < this.writeImagesInfo.getMaxImagesAllowed(), 10);
    }

    public void refreshItemTool() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || this.mData == null) {
            return;
        }
        this.mEditor.setToolEnabled((hasWriteVote() || 10 - getStillCommodityNum() != 0 || this.isRichTextEditorMode) ? false : true, 35);
    }

    public void refreshListView() {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            b19 b19Var = this.mAdapter;
            if (b19Var != null && b19Var.f() == null && (spanGroupEditText = this.mPostContent) != null && spanGroupEditText.getSpanGroupManager() != null) {
                this.mAdapter.i(this.mPostContent.getSpanGroupManager().D());
                this.mAdapter.h();
            } else {
                b19 b19Var2 = this.mAdapter;
                if (b19Var2 != null && b19Var2.f() != null) {
                    this.mAdapter.h();
                }
            }
            b19 b19Var3 = this.mAdapter;
            if (b19Var3 != null) {
                if (b19Var3.getCount() == 0) {
                    this.mListView.setVisibility(8);
                } else {
                    this.mListView.setVisibility(0);
                }
            }
            b19 b19Var4 = this.mAdapter;
            if (b19Var4 != null) {
                setProtocolVisibility(b19Var4.d());
            }
        }
    }

    public void refreshPostButton() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048625, this) == null) || this.mData == null) {
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
                } else if (this.mTitleView.getVisibility() == 0 && !TextUtils.isEmpty(trim2)) {
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
            if (hasWriteVote()) {
                setPostButtonEnabled(true);
            } else {
                setPostButtonEnabled(false);
            }
        } else {
            setPostButtonEnabled(true);
        }
    }

    public void refreshVideoLauncher() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || this.mEditor.n(34) == null) {
            return;
        }
        boolean z2 = true;
        this.mEditor.setToolEnabled(this.isLocalChannelDynamic ? false : (ListUtils.getCount(this.writeImagesInfo.getChosedFiles()) > 0 || this.mVoiceModel != null || this.isRichTextEditorMode) ? false : false, 34);
    }

    public void refreshVoteTool() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || (writeData = this.mData) == null) {
            return;
        }
        this.mEditor.setToolEnabled(ListUtils.isEmpty(writeData.getItemDatas()) && !this.isRichTextEditorMode, 32);
    }

    public void setPostButtonEnabled(boolean z2) {
        SpanGroupEditText spanGroupEditText;
        WriteEvaluationHeaderView writeEvaluationHeaderView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z2) == null) {
            if (z2 && this.isEvaluate && ((spanGroupEditText = this.mPostContent) == null || TextUtils.isEmpty(spanGroupEditText.getText()) || this.mPostContent.getText().length() < 20 || this.mPostContent.getText().length() > 500 || (writeEvaluationHeaderView = this.mWriteEvaluationeHeaderView) == null || !writeEvaluationHeaderView.e())) {
                return;
            }
            this.mPost.setEnabled(z2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048629, this, str, onCancelListener) == null) {
            this.mLoadingDialog.e(null);
            this.mLoadingDialog.i(R.string.obfuscated_res_0x7f0f10ef);
            this.mLoadingDialog.h(true);
        }
    }

    public void showPicOrVideo(boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z2) {
                if (!this.isRichTextEditorMode) {
                    this.mWriteImageController.g().setVisibility(0);
                    changeAssociatedItemContainerLayoutParams(true);
                }
                refreshBubble(false);
            } else {
                this.writeImagesInfo.clear();
                this.mWriteImageController.g().setVisibility(8);
                changeAssociatedItemContainerLayoutParams(false);
                hideBubbleTemporary();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001353, Boolean.FALSE));
            }
            refreshPostButton();
            changeToolButtonStatus();
        }
    }

    public void showTip(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
            showToastWithDefaultIcon(str, BdToast.DefaultIcon.FAILURE);
        }
    }

    public void startDefaultLoacation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            if (!this.mLocationModel.G(getPageContext().getPageActivity())) {
                showToast(R.string.obfuscated_res_0x7f0f0a47);
                sendLocaionAction(0, true, null);
                a09 a09Var = this.mWriteTool;
                if (a09Var != null) {
                    a09Var.f();
                }
            } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
                showLocPermissionDialog();
            } else {
                LocationModel locationModel = this.mLocationModel;
                if (locationModel == null) {
                    return;
                }
                locationModel.P(false);
                sendLocaionAction(1, true, null);
                this.mLocationModel.K();
            }
        }
    }

    public void stopTask(boolean z2) {
        ym8 ym8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z2) == null) {
            if (!z2 && (ym8Var = this.mWriteModel) != null) {
                ym8Var.d();
            }
            FeedBackModel feedBackModel = this.mFeedBackModel;
            if (feedBackModel != null) {
                feedBackModel.cancelLoadData();
            }
            LocationModel locationModel = this.mLocationModel;
            if (locationModel != null) {
                locationModel.cancelLoadData();
            }
        }
    }

    public void upDateVoteInfo(WriteVoteData writeVoteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, writeVoteData) == null) {
            this.mData.setWriteVoteData(writeVoteData);
        }
    }

    public void updateChoseFile(LinkedList<ImageFileInfo> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, linkedList) == null) {
            LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
            if (chosedFiles != null) {
                chosedFiles.clear();
                if (linkedList != null) {
                    chosedFiles.addAll(linkedList);
                }
            }
            refreshPostButton();
        }
    }

    public void stopTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            stopTask(false);
        }
    }
}
