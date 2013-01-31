package com.baidu.zeus;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Interpolator;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.Editable;
import android.text.Selection;
import android.util.AttributeSet;
import android.util.EventLog;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsoluteLayout;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomButtonsController;
import android.widget.ZoomControls;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.browser.webpool.BdWebPoolView;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClientOption;
import com.baidu.zeus.ViewManager;
import com.baidu.zeus.WebSettings;
import com.baidu.zeus.WebTextView;
import com.baidu.zeus.WebViewCore;
import com.baidu.zeus.bouncycastle.DERTags;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimerTask;
import java.util.Vector;
import junit.framework.Assert;
/* loaded from: classes.dex */
public class WebView extends AbsoluteLayout implements ViewGroup.OnHierarchyChangeListener, ViewTreeObserver.OnGlobalFocusChangeListener {
    private static final boolean AUTO_REDRAW_HACK = false;
    private static final int AWAKEN_SCROLL_BARS = 9;
    static final int CENTER_FIT_RECT = 127;
    static final int CLEAR_TEXT_ENTRY = 111;
    private static final boolean DEBUG_DRAG_TRACKER = false;
    private static float DEFAULT_MAX_ZOOM_SCALE = 0.0f;
    private static float DEFAULT_MIN_ZOOM_SCALE = 0.0f;
    static int DEFAULT_SCALE_PERCENT = 0;
    static final int DOM_FOCUS_CHANGED = 122;
    private static final boolean DOUBLE_DELAY_DEBUG = false;
    static final int DO_MOTION_UP = 119;
    private static final int DO_REAL_SETENDSCALE = 11;
    private static final int DO_REAL_SHOWSOFTKB = 12;
    private static final int DO_REAL_SPLITCONTENT = 13;
    private static final int DRAG_HELD_MOTIONLESS = 8;
    private static final int DRAW_EXTRAS_CURSOR_RING = 3;
    private static final int DRAW_EXTRAS_FIND = 1;
    private static final int DRAW_EXTRAS_NONE = 0;
    private static final int DRAW_EXTRAS_SELECTION = 2;
    private static final int EDIT_TEXT_DELAY_SEND_TO_WEBCORE = 14;
    private static final int EVENT_LOG_BROWSER_SNAP_CENTER = 70150;
    private static final int EVENT_LOG_BROWSER_TEXT_SIZE_CHANGE = 70151;
    private static final int EVENT_LOG_DOUBLE_TAP_DURATION = 70102;
    private static final int EVENT_LOG_ZOOM_LEVEL_CHANGE = 70101;
    static final int FIND_AGAIN = 126;
    static final int FIRST_LAYOUT_MSG_ID = 130;
    private static final int FIRST_PACKAGE_MSG_ID = 101;
    private static final int FIRST_PRIVATE_MSG_ID = 1;
    static final int FOCUSED_INPUT_BOUNDS_CHANGED = 131;
    static final int HIDE_FULLSCREEN = 121;
    private static final int HIGHLIGHT_COLOR = 1714664933;
    static final int IMMEDIATE_REPAINT_MSG_ID = 123;
    private static final int LAST_PACKAGE_MSG_ID = 129;
    private static final int LAST_PRIVATE_MSG_ID = 10;
    static final String LOGTAG = "webviewJava";
    static final int LONG_PRESS_CENTER = 114;
    private static final int LONG_PRESS_TIMEOUT = 1000;
    private static final int MAX_DURATION = 750;
    private static final float MAX_SLOPE_FOR_DIAG = 1.5f;
    private static final float MINIMUM_VELOCITY_RATIO_FOR_ACCELERATION = 0.2f;
    private static final int MIN_BREAK_SNAP_CROSS_DISTANCE = 80;
    private static final int MIN_FLING_TIME = 250;
    private static final int MIN_SCROLL_AMOUNT_TO_DISABLE_DRAG_TRACKER = 4;
    private static final int MOTIONLESS_FALSE = 0;
    private static final int MOTIONLESS_IGNORE = 3;
    private static final int MOTIONLESS_PENDING = 1;
    private static final int MOTIONLESS_TIME = 100;
    private static final int MOTIONLESS_TRUE = 2;
    public static final boolean MOVE_EDIT_PROGRAMMLY = true;
    static final int MOVE_OUT_OF_PLUGIN = 110;
    private static final int NEVER_REMEMBER_PASSWORD = 2;
    static final int NEW_PICTURE_MSG_ID = 105;
    private static final int NO_LEFTEDGE = -1;
    private static final int PAGE_SCROLL_OVERLAP = 24;
    private static final int PRECESS_SINGLE_TAP = 16;
    private static final int PREVENT_DEFAULT_IGNORE = 4;
    private static final int PREVENT_DEFAULT_MAYBE_YES = 1;
    private static final int PREVENT_DEFAULT_NO = 0;
    private static final int PREVENT_DEFAULT_NO_FROM_TOUCH_DOWN = 2;
    private static final int PREVENT_DEFAULT_TIMEOUT = 10;
    private static final int PREVENT_DEFAULT_YES = 3;
    static final int PREVENT_TOUCH_ID = 115;
    private static final String PROXY_HOST_CMWAP = "10.0.0.172";
    private static final String PROXY_HOST_CTWAP = "10.0.0.200";
    private static final int RELEASE_SINGLE_TAP = 5;
    private static final int REMEMBER_PASSWORD = 1;
    private static final int REQUEST_FORM_DATA = 6;
    static final int REQUEST_KEYBOARD = 118;
    static final int REQUEST_KEYBOARD_WITH_SELECTION_EXT = 133;
    static final int REQUEST_KEYBOARD_WITH_SELECTION_MSG_ID = 128;
    private static final int RESUME_WEBCORE_PRIORITY = 7;
    static final int RETURN_LABEL = 125;
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_TEL = "tel:";
    private static final int SCROLLBAR_ALWAYSOFF = 1;
    private static final int SCROLLBAR_ALWAYSON = 2;
    private static final int SCROLLBAR_AUTO = 0;
    static final int SCROLL_BY_MSG_ID = 102;
    private static final int SCROLL_SELECT_TEXT = 15;
    static final int SCROLL_TO_MSG_ID = 101;
    private static final int SELECT_CURSOR_OFFSET = 16;
    private static final int SELECT_SCROLL = 5;
    private static final long SELECT_SCROLL_INTERVAL = 16;
    static final int SEND_CAPTURE_SCALE_PIC = 132;
    static final int SEND_ON_SUBJECT_CLICK = 142;
    static final int SEND_SUBJECT_RECTS = 146;
    static final int SET_HAS_PLUGIN = 143;
    static final int SET_IS_MOBILE_SITE_ZEUS = 144;
    static final int SET_ROOT_LAYER_MSG_ID = 124;
    static final int SET_SCROLLBAR_MODES = 129;
    static final int SET_TOUCH_HIGHLIGHT_RECTS = 134;
    static final int SHOW_DOUBLE_TAP_SCALE = 147;
    static final int SHOW_FULLSCREEN = 120;
    static final int SHOW_RECT_MSG_ID = 113;
    public static final boolean SHOW_WEB_TEXT_VIEW = true;
    private static final int SLIDE_TITLE_DURATION = 500;
    private static final int SNAP_LOCK = 1;
    private static final int SNAP_NONE = 0;
    private static final int SNAP_X = 2;
    private static final int SNAP_Y = 4;
    static final int SPAWN_SCROLL_TO_MSG_ID = 103;
    private static final int STD_SPEED = 480;
    private static final int SWITCH_TO_LONGPRESS = 4;
    private static final int SWITCH_TO_SHORTPRESS = 3;
    static final int SYNC_SCROLL_TO_MSG_ID = 104;
    private static final int TAP_TIMEOUT = 200;
    private static final int TOUCH_DONE_MODE = 7;
    private static final int TOUCH_DOUBLE_TAP_MODE = 6;
    private static final int TOUCH_DRAG_LAYER_MODE = 9;
    private static final int TOUCH_DRAG_MODE = 3;
    private static final int TOUCH_DRAG_START_MODE = 2;
    private static final int TOUCH_INIT_MODE = 1;
    private static final int TOUCH_PINCH_DRAG = 8;
    private static final int TOUCH_SENT_INTERVAL = 50;
    private static final int TOUCH_SHORTPRESS_MODE = 5;
    private static final int TOUCH_SHORTPRESS_START_MODE = 4;
    private static final int TRACKBALL_KEY_TIMEOUT = 1000;
    private static final int TRACKBALL_MOVE_COUNT = 10;
    private static final int TRACKBALL_MULTIPLIER = 3;
    private static final int TRACKBALL_SCALE = 400;
    private static final int TRACKBALL_SCROLL_COUNT = 5;
    private static final int TRACKBALL_TIMEOUT = 200;
    private static final int TRACKBALL_WAIT = 100;
    static final int UPDATE_TEXTFIELD_TEXT_MSG_ID = 108;
    static final int UPDATE_TEXT_ENTRY_MSG_ID = 106;
    static final int UPDATE_TEXT_SELECTION_MSG_ID = 112;
    static final int UPDATE_ZOOM_RANGE = 109;
    static final boolean USE_JAVA_TEXT_SELECTION = true;
    static final boolean USE_WEBKIT_RINGS = false;
    static final int WEBCORE_INITIALIZED_MSG_ID = 107;
    static final int WEBCORE_NEED_TOUCH_EVENTS = 116;
    static final int ZEUS_ENG_WORD_SELECTION_RESULT = 139;
    static final int ZEUS_GET_SELECTION_DONE = 137;
    static final int ZEUS_HIDE_CURSOR = 138;
    static final int ZEUS_LONG_PRESS = 136;
    static final int ZEUS_NOTIFY_SCALE = 145;
    static final int ZEUS_PLUGIN_FULL_SCREEN_ENTER = 140;
    static final int ZEUS_PLUGIN_FULL_SCREEN_EXIT = 141;
    static final int ZEUS_QUICK_CLICK = 135;
    private static final int ZOOM_ANIMATION_LENGTH = 200;
    private static ConnectivityManager mConnectivityManager = null;
    private static final boolean mEnableMagnifierBkgCache = true;
    private static final boolean mEnableNativeCanvasCache = true;
    private static String mImeiStr;
    private static Paint mOverScrollBackground;
    private static Paint mOverScrollBorder;
    private static ProxyReceiver sProxyReceiver;
    public final int LARGE_SCALE_STATE;
    public final int MEDIUM_SCALE_STATE;
    public final float NEED_ZOOM_SCALE;
    public final int SMALL_SCALE_STATE;
    private final int SOFT_KEYBOARD_HEIGHT;
    private boolean isZeusPluginFullScreen;
    public int lastProgress;
    private boolean mActionDown;
    private float mActualScale;
    private float mAdjustScale;
    private boolean mAllowPanAndScale;
    private int mAnchorX;
    private int mAnchorY;
    private boolean mAutoRedraw;
    private int mAutoScrollX;
    private int mAutoScrollY;
    private int mBackgroundColor;
    private float mBeginScaleSpan;
    private Bitmap mBitmapMask1;
    private Bitmap mBitmapMask2;
    private int mBitmapMaskCnt;
    private int mBitmapMaskMetaSize;
    private int mBitmapMaskMode;
    private Rect mBlockRect;
    private boolean mBlockWebkitViewMessages;
    private final CallbackProxy mCallbackProxy;
    private Bitmap mCanvasCacheBmp;
    private boolean mCaptureFlag;
    private SslCertificate mCertificate;
    private boolean mClickUrlPauseDraw;
    private boolean mConfirmMove;
    private int mContentChangeState;
    private int mContentHeight;
    private int mContentHeightAdded;
    private boolean mContentHeightChanged;
    private int mContentWidth;
    public boolean mCopyingSth;
    private InvokeListBox mCurListBox;
    private float mCurrentMultiScale;
    private float mCurrentScale;
    private float mCurrentScaleOnTouch;
    private int mCurrentTouchInterval;
    private String mCurrentUrl;
    private final WebViewDatabase mDatabase;
    private float mDefaultScale;
    private int mDeferTouchMode;
    private boolean mDeferTouchProcess;
    private boolean mDelayedDeleteRootLayer;
    public boolean mDidFirstLayout;
    private boolean mDisplaySoftKeyboard;
    private int mDoubleTapSlopSquare;
    private int mDragFinish;
    boolean mDragFromTextInput;
    private DragState mDragState;
    private DragTracker mDragTracker;
    private DragTrackerHandler mDragTrackerHandler;
    public boolean mDragging;
    private boolean mDrawCursorRing;
    private boolean mDrawFlag;
    private boolean mDrawHistory;
    private boolean mDrawSelectionPointer;
    private Rect mDstRectForDraging;
    private boolean mEnableSelectText;
    private boolean mEndSessionFlag;
    private EditText mEtText;
    private boolean mExtendSelection;
    private float mFakeZoomCenterX;
    private float mFakeZoomCenterY;
    private int mFindHeight;
    private boolean mFindIsUp;
    private boolean mFirstAnimateOut;
    private int mFlag;
    private boolean mFocusSizeChanged;
    private boolean mFocusedInputBoundsChanged;
    private boolean mForceCapture;
    private boolean mForwardTouchEvents;
    PluginFullScreenHolder mFullScreenHolder;
    private boolean mGLCapScalePic;
    private final Rect mGLRectViewport;
    private boolean mGLViewportEmpty;
    private InnerGlobalLayoutListener mGlobalLayoutListener;
    private boolean mGotCenterDown;
    private boolean mHardwareAccelSkia;
    public hasPluginState mHasPlugin;
    boolean mHeightCanMeasure;
    private int mHeldMotionless;
    private int mHistoryHeight;
    private Picture mHistoryPicture;
    private int mHistoryWidth;
    private int mHorizontalScrollBarMode;
    private boolean mInOverScrollMode;
    boolean mInZoomOverview;
    private float mInitViewScale;
    private int mInitialScaleInPercent;
    private int mInitialScrollX;
    private int mInitialScrollY;
    private float mInvActualScale;
    private float mInvFinalZoomScale;
    private float mInvInitialZoomScale;
    private boolean mIsMobileSiteGuessed;
    private boolean mIsPaused;
    private boolean mIsShiftPressed;
    private boolean mIsSubjectWebView;
    private boolean mIsUnderSubject;
    private Vector mKeysPressed;
    private Rect mLastCursorBounds;
    private long mLastCursorTime;
    private float mLastDeferTouchX;
    private float mLastDeferTouchY;
    private long mLastDownTime;
    private String mLastFind;
    private Rect mLastGlobalRect;
    int mLastHeightSent;
    private float mLastScale;
    private int mLastScrollX;
    private int mLastScrollY;
    private int mLastSelX;
    private int mLastSelY;
    private long mLastSentTouchTime;
    private long mLastTouchTime;
    private long mLastTouchUpTime;
    private float mLastTouchX;
    private float mLastTouchY;
    private float mLastVelX;
    private float mLastVelY;
    private float mLastVelocity;
    private Rect mLastVisibleRectSent;
    int mLastWidthSent;
    private boolean mMagnifierMode;
    private boolean mMagnifierOn;
    private boolean mMapTrackballToArrowKeys;
    private int mMaxAutoScrollX;
    private int mMaxAutoScrollY;
    private float mMaxZoomScale;
    private int mMaximumFling;
    private int mMinAutoScrollX;
    private int mMinAutoScrollY;
    private int mMinLockSnapReverseDistance;
    private float mMinZoomScale;
    private boolean mMinZoomScaleFixed;
    private boolean mMultiScaling;
    private boolean mMultiScalingFirstTime;
    private boolean mMultiZoomScaleFlag;
    private int mNativeClass;
    private int mNavSlop;
    private boolean mNeedToAdjustWebTextView;
    private boolean mNeedToShowSelectionActionDialog;
    private boolean mOnDrawing;
    private int mOverflingDistance;
    private boolean mOverlayHorizontalScrollbar;
    private boolean mOverlayVerticalScrollbar;
    private int mOverscrollDeltaX;
    private int mOverscrollDeltaY;
    private boolean mOwnEditOn;
    private String mPageThatNeedsToSlideTitleBarOffScreen;
    private PictureListener mPictureListener;
    private int mPreventDefault;
    private boolean mPreviewZoomOnly;
    final Handler mPrivateHandler;
    private boolean mProcessCaptureFlag;
    private boolean mRebuildWebTextView;
    private Rect mRectForRefresh;
    private ScaleGestureDetector mScaleDetector;
    private float mScaleForDraging;
    private float mScaleScrollX;
    private float mScaleScrollY;
    private InnerScrollChangedListener mScrollChangedListener;
    private int mScrollIframeDeltaX;
    private int mScrollIframeDeltaY;
    private ScrollState mScrollState;
    private int mScrollXDraging;
    private int mScrollYDraging;
    private boolean mScrollZoomScaleFlag;
    public ZeusScroller mScroller;
    private int mScrollingLayer;
    private Rect mScrollingLayerBounds;
    private Rect mScrollingLayerRect;
    private Drawable mSelectHandleLeft;
    private Drawable mSelectHandleRight;
    private int mSelectX;
    private int mSelectY;
    private boolean mSelectingText;
    private boolean mSelectionStarted;
    private boolean mSentAutoScrollMessage;
    private boolean mShiftIsPressed;
    private boolean mShouldCapture;
    private boolean mShowOwnEdit;
    private boolean mShowSelectionActionDialog;
    private boolean mSnapPositive;
    private int mSnapScrollMode;
    private int mSplitContentCnt;
    private Rect mSrcRectForDraging;
    private ScaleThread mStInstance;
    private int mStartScrollPosX;
    private int mStartScrollPosY;
    public boolean mStopingLoading;
    private int mSubjectClickIndex;
    private ArrayList mSubjectClickRects;
    private boolean mSubjectNeedScrollOnLoad;
    private Paint mSubjectPaint;
    private ArrayList mSubjectRects;
    private int mSubjectScrollOffsetY;
    private ArrayList mSubjectViewRects;
    private boolean mSupportMultiTouch;
    private boolean mSuspendWebView;
    private boolean mSwitchScreenFlag;
    private boolean mTapOnSubject;
    private int mTextGeneration;
    private Paint mTextSelectionPaint;
    private Region mTextSelectionRegion;
    float mTextWrapScale;
    private View mTitleBar;
    private Drawable mTitleShadow;
    private final TouchEventQueue mTouchEventQueue;
    private int mTouchFinish;
    private Region mTouchHighlightRegion;
    private long mTouchHighlightRequested;
    private int mTouchMode;
    private int mTouchSlopSquare;
    private boolean mTrackballDown;
    private long mTrackballFirstTime;
    private long mTrackballLastTime;
    private float mTrackballRemainsX;
    private float mTrackballRemainsY;
    private long mTrackballUpTime;
    private int mTrackballXMove;
    private int mTrackballYMove;
    private boolean mUnderSubject;
    private boolean mUseGL;
    private boolean mUserScroll;
    VelocityTracker mVelocityTracker;
    private int mVerticalScrollBarMode;
    private int mViewHeight;
    final ViewManager mViewManager;
    private final Rect mViewRectViewport;
    private int mViewWidth;
    private boolean mWaitingZoom2Block;
    private WebTextView mWebTextView;
    private WebViewAction mWebViewAction;
    private WebViewCore mWebViewCore;
    private WebViewType mWebViewType;
    private boolean mWebViewVisible;
    boolean mWidthCanMeasure;
    private boolean mWrapContent;
    private int mYDistanceToSlideTitleOffScreen;
    private ZoomButtonsController mZoomButtonsController;
    private float mZoomCenterX;
    private float mZoomCenterY;
    private Runnable mZoomControlRunnable;
    private ExtendedZoomControls mZoomControls;
    private boolean mZoomEndFlag;
    private int mZoomFlag;
    private ZoomButtonsController.OnZoomListener mZoomListener;
    private boolean mZoomOutFlag;
    int mZoomOverviewWidth;
    private float mZoomScale;
    private long mZoomStart;
    private ZoomState mZoomState;
    private boolean mZoomWhenScrolling;
    public boolean m_ExitFullScreen;
    private boolean m_newPage;
    private Bitmap magnifierBmp;
    private int magnifierX;
    private int magnifierY;
    private float mfLeft;
    private float mfTop;
    private boolean needHitTestNormalText;
    private java.util.Timer nightTimer;
    private java.util.Timer progressTimer;
    private static ZeusScaleStore mZeusScaleStore = null;
    private static Bitmap mBitmapMask3 = null;
    private static int mScreenWidth = 0;
    private static int mScreenHeight = 0;
    private static Canvas mCanvas = null;
    private static Canvas mCanvasSubject = null;
    private static Bitmap mBitmapForDraging = null;
    private static Bitmap mBitmapForScale = null;
    private static int mCurrScreenWidth = 0;
    private static int mCurrScreenHeight = 0;
    private static int mScreenViewWidth = 0;
    private static int mScreenViewHeight = 0;
    private static int mSmallestWidth = 0;
    private static int mSmallestHeight = 0;
    private static float mBmpFactor = 1.0f;
    private static boolean mIsNeedToFindTreasure = false;
    private static boolean mUseBackThread = true;
    private static boolean mNeedTextDeleteBtn = false;
    private static boolean mDrawingSubject = false;
    private static int SCROLL_DELTA = 30;
    private static boolean mSubjectFlag = false;
    private static boolean sNotificationsEnabled = true;
    private static float mDensity = 0.0f;
    private static final long ZOOM_CONTROLS_TIMEOUT = ViewConfiguration.getZoomControlsTimeout();
    private static float PREVIEW_SCALE_INCREMENT = 0.01f;
    static final String[] HandlerPrivateDebugString = {"REMEMBER_PASSWORD", "NEVER_REMEMBER_PASSWORD", "SWITCH_TO_SHORTPRESS", "SWITCH_TO_LONGPRESS", "RELEASE_SINGLE_TAP", "REQUEST_FORM_DATA", "RESUME_WEBCORE_PRIORITY", "DRAG_HELD_MOTIONLESS", "AWAKEN_SCROLL_BARS", "PREVENT_DEFAULT_TIMEOUT", "DO_REAL_SETENDSCALE", "DO_REAL_SHOWSOFTKB", "DO_REAL_SPLITCONTENT", "EDIT_TEXT_DELAY_SEND_TO_WEBCORE", "SCROLL_SELECT_TEXT", "PRECESS_SINGLE_TAP"};
    static final String[] HandlerPackageDebugString = {"SCROLL_TO_MSG_ID", "SCROLL_BY_MSG_ID", "SPAWN_SCROLL_TO_MSG_ID", "SYNC_SCROLL_TO_MSG_ID", "NEW_PICTURE_MSG_ID", "UPDATE_TEXT_ENTRY_MSG_ID", "WEBCORE_INITIALIZED_MSG_ID", "UPDATE_TEXTFIELD_TEXT_MSG_ID", "UPDATE_ZOOM_RANGE", "MOVE_OUT_OF_PLUGIN", "CLEAR_TEXT_ENTRY", "UPDATE_TEXT_SELECTION_MSG_ID", "SHOW_RECT_MSG_ID", "LONG_PRESS_CENTER", "PREVENT_TOUCH_ID", "WEBCORE_NEED_TOUCH_EVENTS", "INVAL_RECT_MSG_ID", "REQUEST_KEYBOARD", "DO_MOTION_UP", "SHOW_FULLSCREEN", "HIDE_FULLSCREEN", "DOM_FOCUS_CHANGED", "IMMEDIATE_REPAINT_MSG_ID", "SET_ROOT_LAYER_MSG_ID", "RETURN_LABEL", "FIND_AGAIN", "CENTER_FIT_RECT", "REQUEST_KEYBOARD_WITH_SELECTION_MSG_ID", "SET_SCROLLBAR_MODES", "FIRST_LAYOUT_MSG_ID", "FOCUSED_INPUT_BOUNDS_CHANGED", "SEND_CAPTURE_SCALE_PIC", "REQUEST_KEYBOARD_WITH_SELECTION_EXT", "SET_TOUCH_HIGHLIGHT_RECTS"};
    static final int DEFAULT_VIEWPORT_WIDTH = 800;
    static int sMaxViewportWidth = DEFAULT_VIEWPORT_WIDTH;
    private static float fakeMaxZoomScale = 3.0f;
    private static float MINIMUM_SCALE_INCREMENT = 0.04f;
    static boolean mLogEvent = true;
    private static String mProxyHost = null;
    private static int mProxyPort = 0;
    private static final Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
    private static int EDIT_TEXT_DELAY_TIME = 500;
    private static ArrayList mSubjectRingScale = new ArrayList();
    private static int lastRectHeight = -1;
    private static Bitmap mSubjectClickBmp = null;
    private static Rect mSubjectClickBmpRect = null;
    private static final int TEMP_SUBJECT_WIDTH_ADJUST = 40;
    private static int SUBJECT_WIDTH_ADJUST = TEMP_SUBJECT_WIDTH_ADJUST;
    private static boolean notifyCient = true;
    private static int mSubjectClickDrawableId = 0;
    static final int INVAL_RECT_MSG_ID = 117;
    private static final int SUBJECT_RING_COLOR = Color.argb((int) INVAL_RECT_MSG_ID, 182, 198, 216);
    private static final int SUBJECT_RING_COLOR_CLICK_DAY = Color.argb(255, 182, 198, 216);
    private static final int SUBJECT_RING_COLOR_CLICK_NIGHT = Color.argb(176, 182, 198, 216);
    private static final int SUBJECT_SHADOW_COLOR_NORMAL = Color.argb(255, 255, 202, 0);
    private static final int SUBJECT_SHADOW_COLOR_CLICK = Color.argb(255, 255, 86, 0);
    private static final int SUBJECT_SHADLE_COLOR = Color.argb(160, 55, 58, 62);
    private static int mLastSubjectClickIndex = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum DragState {
        DragUnknown,
        DragDown,
        DragStop,
        Draging
    }

    /* loaded from: classes.dex */
    public enum PageType {
        NormalType,
        DesktopType
    }

    /* loaded from: classes.dex */
    public interface PictureListener {
        void onNewPicture(WebView webView, Picture picture);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum ScrollState {
        ScrollUnknown,
        ScrollStop,
        Scrolling
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ViewSizeData {
        int mAnchorX;
        int mAnchorY;
        int mHeight;
        boolean mIgnoreHeight;
        float mScale;
        int mTextWrapWidth;
        int mWidth;
    }

    /* loaded from: classes.dex */
    public enum WebViewAction {
        NormalAction,
        SingleWindowPauseAction,
        MultipleWindowPauseAction
    }

    /* loaded from: classes.dex */
    public enum WebViewType {
        NORMAL,
        BIGPLUGIN
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum ZoomState {
        ZoomOverview,
        ZoomDefault,
        ZoomBlock,
        ZoomOther
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum hasPluginState {
        Unknown,
        HasPlugin,
        HasNoPlugin
    }

    private native String nativeActionNodeText(int i);

    private native int nativeActionNodesCount();

    private native int nativeCacheHitFramePointer();

    private native Rect nativeCacheHitNodeBounds();

    private native int nativeCacheHitNodePointer();

    private native boolean nativeCachedHitNodeIsTextInput(int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeCreate(int i);

    private native boolean nativeCursorContainImgNode();

    private native int nativeCursorFramePointer();

    private native String nativeCursorInnerText();

    private native boolean nativeCursorIntersects(Rect rect);

    private native boolean nativeCursorIsAnchor();

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean nativeCursorIsTextInput();

    private native Rect nativeCursorNodeBounds();

    private native int nativeCursorNodePointer();

    private native Point nativeCursorPosition();

    private native String nativeCursorText();

    private native boolean nativeCursorWantsKeyEvents();

    private native void nativeDebugDump();

    private native void nativeDestroy();

    private native void nativeDestroyCacheBackBmp();

    private native void nativeDrawCircle(int i, int i2);

    private native void nativeDrawExtras(Canvas canvas, int i);

    private native void nativeDrawGL(Rect rect, Rect rect2, float f, int i);

    private native void nativeDumpDisplayTree(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean nativeEngWordSelection(int i, int i2, int i3, int i4, int i5, int i6);

    private native boolean nativeEvaluateLayersAnimations();

    private native void nativeExtendSelection(int i, int i2);

    private native int nativeFindAll(String str, String str2);

    private native int nativeFindIndex();

    private native void nativeFindNext(boolean z);

    private native boolean nativeFocusCandidateIsContentEditable();

    private native boolean nativeFocusCandidateIsRtlText();

    private native boolean nativeFocusCandidateIsTextInput();

    private native Rect nativeFocusCandidateNodeBounds(boolean z);

    private native Rect nativeFocusCandidatePaddingRect();

    private native String nativeFocusCandidateText(boolean z);

    private native int nativeFocusCandidateTextSize();

    private native int nativeFocusCandidateType();

    private native boolean nativeFocusIsPlugin();

    private native Rect nativeFocusNodeBounds();

    private native int nativeGetBlockLeftEdge(int i, int i2, float f);

    private native String nativeGetCacheHitNodeAnchorURL();

    private native Rect nativeGetCursorRingBounds();

    private native int nativeGetDrawGLFunction(int i, Rect rect, Rect rect2, float f, int i2);

    private native void nativeGetFocusedPicture(Picture picture);

    private native Region nativeGetSelection();

    private native boolean nativeHasCursorNode();

    private native boolean nativeHasFocusNode();

    private native void nativeHideCursor();

    private native boolean nativeHitSelection(int i, int i2);

    private native String nativeImageURI(int i, int i2);

    private native void nativeInstrumentReport();

    private native boolean nativeMotionUp(int i, int i2, int i3, boolean z);

    private native boolean nativeMoveCursor(int i, int i2, boolean z);

    private native int nativeMoveGeneration();

    private native void nativeMoveSelection(int i, int i2);

    private native void nativeOnClickActionNode(int i);

    private native boolean nativePointInNavCache(int i, int i2, int i3);

    private static native void nativePreconnectUrl(String str);

    private native void nativeRecordButtons(boolean z, boolean z2, boolean z3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeRefreshControls();

    private native void nativeResetSelection();

    private static native void nativeResolveUrl(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean nativeScrollLayer(int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeScrollableLayer(int i, int i2, Rect rect, Rect rect2);

    private native void nativeSelectAll();

    private native void nativeSelectBestAt(Rect rect);

    private native int nativeSelectionBottom();

    private native int nativeSelectionLeft();

    private native int nativeSelectionRight();

    private native int nativeSelectionTop();

    private native int nativeSelectionX();

    private native int nativeSelectionY();

    private native void nativeSetBaseLayer(int i, Region region, boolean z, boolean z2, boolean z3);

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean nativeSetCachedNodeFocusFromPt(int i, int i2, int i3);

    private native void nativeSetExtendSelection();

    private native void nativeSetFindIsEmpty();

    private native void nativeSetFindIsUp(boolean z);

    private native void nativeSetFocusedPicture(int i, int i2);

    private native void nativeSetFollowedLink(boolean z);

    private native void nativeSetHeightCanMeasure(boolean z);

    private native void nativeSetIsScrolling(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSetRootLayer(int i);

    private native void nativeSetSelectionPointer(boolean z, float f, int i, int i2);

    private native void nativeSetSelectionRegion(boolean z);

    private native boolean nativeShowCacheBackBmp();

    private native boolean nativeStartSelection(int i, int i2, boolean z);

    private native void nativeStopGL();

    private native Rect nativeSubtractLayers(Rect rect);

    private native int nativeTapOnSubject(int i, int i2);

    private native int nativeTextGeneration();

    private native void nativeUpdateCachedTextfield(String str, int i);

    private native void nativeUpdateDrawGLFunction(Rect rect, Rect rect2);

    private native void nativeUpdateInputTextfield(String str, int i);

    private native void nativeUseHardwareAccelSkia(boolean z);

    private native boolean nativeWordSelection(int i, int i2);

    public native void flushCache(int i);

    public native int getZeusBitmapFromCanvas(Canvas canvas, Bitmap bitmap);

    native void nativeClearCursor();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native boolean nativeCursorMatchesFocus();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int nativeFocusCandidateFramePointer();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native boolean nativeFocusCandidateHasNextTextfield();

    native boolean nativeFocusCandidateIsPassword();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int nativeFocusCandidateMaxLength();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native String nativeFocusCandidateName();

    native int nativeFocusCandidatePointer();

    native int nativeFocusNodePointer();

    public native boolean nativeHitTextNode(int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native boolean nativeMoveCursorToNextTextInput();

    public native void nativeSetBigPluginView();

    public native void nativeSuperOnConfChanged(Configuration configuration);

    public static void prepareToQuit() {
        if (mZeusScaleStore != null) {
            mZeusScaleStore.save();
            mZeusScaleStore = null;
        }
    }

    /* loaded from: classes.dex */
    class InnerGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private InnerGlobalLayoutListener() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (WebView.this.isShown()) {
                WebView.this.setGLRectViewport();
            }
        }
    }

    /* loaded from: classes.dex */
    class InnerScrollChangedListener implements ViewTreeObserver.OnScrollChangedListener {
        private InnerScrollChangedListener() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            if (WebView.this.isShown()) {
                WebView.this.setGLRectViewport();
            }
        }
    }

    public boolean isZeusPluginFullScreenMode() {
        return this.isZeusPluginFullScreen;
    }

    public void setHasPlugin(boolean z) {
        if (z) {
            this.mHasPlugin = hasPluginState.HasPlugin;
        } else {
            this.mHasPlugin = hasPluginState.HasNoPlugin;
        }
    }

    public void quitZeusPluginFullScreenMode() {
        this.isZeusPluginFullScreen = false;
    }

    public static boolean ifNeedTextDeleteBtn() {
        return mNeedTextDeleteBtn;
    }

    public void setNeedTextDeleteBtn(boolean z) {
        mNeedTextDeleteBtn = z;
    }

    public void setContentChangeState(int i) {
        this.mContentChangeState = i;
    }

    public int getContentChangeState() {
        return this.mContentChangeState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ExtendedZoomControls extends FrameLayout {
        ZoomControls mPlusMinusZoomControls;

        public ExtendedZoomControls(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(17367154, (ViewGroup) this, true);
            this.mPlusMinusZoomControls = (ZoomControls) findViewById(16908805);
            findViewById(16908808).setVisibility(8);
        }

        public void show(boolean z, boolean z2) {
            this.mPlusMinusZoomControls.setVisibility(z ? 0 : 8);
            fade(0, 0.0f, 1.0f);
        }

        public void hide() {
            fade(8, 1.0f, 0.0f);
        }

        private void fade(int i, float f, float f2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
            alphaAnimation.setDuration(500L);
            startAnimation(alphaAnimation);
            setVisibility(i);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean hasFocus() {
            return this.mPlusMinusZoomControls.hasFocus();
        }

        public void setOnZoomInClickListener(View.OnClickListener onClickListener) {
            this.mPlusMinusZoomControls.setOnZoomInClickListener(onClickListener);
        }

        public void setOnZoomOutClickListener(View.OnClickListener onClickListener) {
            this.mPlusMinusZoomControls.setOnZoomOutClickListener(onClickListener);
        }
    }

    /* loaded from: classes.dex */
    public class WebViewTransport {
        private WebView mWebview;

        public WebViewTransport() {
        }

        public synchronized void setWebView(WebView webView) {
            this.mWebview = webView;
        }

        public synchronized WebView getWebView() {
            return this.mWebview;
        }
    }

    /* loaded from: classes.dex */
    public class HitTestResult {
        public static final int ANCHOR_TYPE = 1;
        public static final int EDIT_TEXT_TYPE = 9;
        public static final int EMAIL_TYPE = 4;
        public static final int GEO_TYPE = 3;
        public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int IMAGE_TYPE = 5;
        public static final int NORMAL_TEXT_TYPE = 10;
        public static final int PHONE_TYPE = 2;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int SRC_JS_ANCHOR_TYPE = 11;
        public static final int UNKNOWN_TYPE = 0;
        private String mExtra;
        private String mExtra2;
        private int mType = 0;

        HitTestResult() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(int i) {
            this.mType = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtra(String str) {
            this.mExtra = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtra2(String str) {
            this.mExtra2 = str;
        }

        public int getType() {
            return this.mType;
        }

        public String getExtra() {
            return this.mExtra;
        }

        public String getExtra2() {
            return this.mExtra2;
        }
    }

    /* loaded from: classes.dex */
    public class NotifyClientStatus {
        public static final int STATUS_FIRSTSHOW_MAIN_ACTION = 2;
        public static final int STATUS_FIRSTSHOW_PAGE_CONTENT = 3;
        public static final int STATUS_FIRSTSHOW_SUBJECT = 1;
        public static final int STATUS_NONE = 0;

        public NotifyClientStatus() {
        }
    }

    public void updateZoomButtons() {
        if (getSettings().getBuiltInZoomControls() && this.mZoomButtonsController.isVisible()) {
            updateZoomButtonsEnabled();
        }
    }

    public WebView(Context context) {
        this(context, null);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842885);
    }

    public WebView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    protected WebView(Context context, AttributeSet attributeSet, int i, Map map) {
        super(context, attributeSet, i);
        this.mInitViewScale = 0.0f;
        this.mGlobalLayoutListener = null;
        this.mScrollChangedListener = null;
        this.mShowOwnEdit = false;
        this.mZoomFlag = 0;
        this.mScaleForDraging = 0.0f;
        this.mDstRectForDraging = new Rect(0, 0, 0, 0);
        this.mSrcRectForDraging = new Rect(0, 0, 0, 0);
        this.mFlag = 1;
        this.mCurrentScale = 0.0f;
        this.mCurrentMultiScale = 0.0f;
        this.mCurrentScaleOnTouch = 0.0f;
        this.mDragFinish = 1;
        this.mTouchFinish = 1;
        this.mBitmapMask1 = null;
        this.mBitmapMask2 = null;
        this.mBitmapMaskCnt = TEMP_SUBJECT_WIDTH_ADJUST;
        this.mZoomOutFlag = false;
        this.mBitmapMaskMode = 2;
        this.mBitmapMaskMetaSize = 5;
        this.mZoomEndFlag = true;
        this.mViewHeight = 0;
        this.mViewWidth = 0;
        this.mDrawFlag = true;
        this.mUseGL = false;
        this.mGLCapScalePic = false;
        this.mScrollState = ScrollState.ScrollUnknown;
        this.mContentChangeState = 0;
        this.mEndSessionFlag = false;
        this.mDragging = false;
        this.mCaptureFlag = false;
        this.mProcessCaptureFlag = false;
        this.mScrollZoomScaleFlag = false;
        this.mMultiZoomScaleFlag = false;
        this.mfLeft = 0.0f;
        this.mfTop = 0.0f;
        this.mRectForRefresh = new Rect(0, 0, 0, 0);
        this.mSuspendWebView = false;
        this.mWebViewVisible = true;
        this.m_newPage = false;
        this.mLastScale = 0.0f;
        this.mUnderSubject = false;
        this.mAdjustScale = 0.0f;
        this.mForceCapture = false;
        this.mSplitContentCnt = 0;
        this.mFakeZoomCenterX = 0.0f;
        this.mFakeZoomCenterY = 0.0f;
        this.mDragState = DragState.DragUnknown;
        this.mLastScrollX = 0;
        this.mLastScrollY = 0;
        this.mScrollXDraging = 0;
        this.mScrollYDraging = 0;
        this.mSwitchScreenFlag = false;
        this.mOnDrawing = false;
        this.mStInstance = null;
        this.mShouldCapture = false;
        this.mZoomWhenScrolling = false;
        this.mClickUrlPauseDraw = false;
        this.mWebViewType = WebViewType.NORMAL;
        this.mWebViewAction = WebViewAction.NormalAction;
        this.mIsSubjectWebView = false;
        this.mSubjectNeedScrollOnLoad = false;
        this.mSubjectScrollOffsetY = -1;
        this.mHardwareAccelSkia = false;
        this.mScrollIframeDeltaX = 0;
        this.mScrollIframeDeltaY = 0;
        this.mStartScrollPosX = 0;
        this.mStartScrollPosY = 0;
        this.mSentAutoScrollMessage = false;
        this.mTouchHighlightRegion = new Region();
        this.mBlockWebkitViewMessages = false;
        this.mAutoScrollX = 0;
        this.mAutoScrollY = 0;
        this.mMinAutoScrollX = 0;
        this.mMaxAutoScrollX = 0;
        this.mMinAutoScrollY = 0;
        this.mMaxAutoScrollY = 0;
        this.mScrollingLayerBounds = new Rect();
        this.mScrollingLayer = 0;
        this.mScrollingLayerRect = new Rect();
        this.mTouchEventQueue = new TouchEventQueue();
        this.isZeusPluginFullScreen = false;
        this.m_ExitFullScreen = false;
        this.mHasPlugin = hasPluginState.HasPlugin;
        this.mGLRectViewport = new Rect();
        this.mViewRectViewport = new Rect();
        this.mGLViewportEmpty = false;
        this.mPrivateHandler = new PrivateHandler();
        this.mCurrentTouchInterval = TOUCH_SENT_INTERVAL;
        this.mTouchMode = 7;
        this.mForwardTouchEvents = false;
        this.mPreventDefault = 4;
        this.mTapOnSubject = false;
        this.mDeferTouchMode = 7;
        this.mDrawCursorRing = true;
        this.mOverlayHorizontalScrollbar = true;
        this.mOverlayVerticalScrollbar = false;
        this.mInOverScrollMode = false;
        this.mMinZoomScaleFixed = true;
        this.mInitialScaleInPercent = 0;
        this.mInZoomOverview = false;
        this.mZoomOverviewWidth = DEFAULT_VIEWPORT_WIDTH;
        this.mZoomState = ZoomState.ZoomDefault;
        this.mPreviewZoomOnly = false;
        this.mFirstAnimateOut = false;
        this.mUserScroll = false;
        this.mSnapScrollMode = 0;
        this.mHorizontalScrollBarMode = 0;
        this.mVerticalScrollBarMode = 0;
        this.mLastTouchUpTime = 0L;
        this.mBackgroundColor = -1;
        this.mZoomListener = new ZoomButtonsController.OnZoomListener() { // from class: com.baidu.zeus.WebView.1
            @Override // android.widget.ZoomButtonsController.OnZoomListener
            public void onVisibilityChanged(boolean z) {
                if (z) {
                    WebView.this.switchOutDrawHistory();
                    WebView.this.mZoomButtonsController.getZoomControls().setVisibility(0);
                    WebView.this.updateZoomButtonsEnabled();
                }
            }

            @Override // android.widget.ZoomButtonsController.OnZoomListener
            public void onZoom(boolean z) {
                if (z) {
                    WebView.this.zoomIn();
                } else {
                    WebView.this.zoomOut();
                }
                WebView.this.updateZoomButtonsEnabled();
            }
        };
        this.mIsMobileSiteGuessed = false;
        this.needHitTestNormalText = true;
        this.magnifierBmp = null;
        this.mCanvasCacheBmp = null;
        this.mDidFirstLayout = false;
        this.magnifierX = 0;
        this.magnifierY = 0;
        this.mTextSelectionRegion = new Region();
        this.mSubjectClickRects = new ArrayList();
        this.mSubjectRects = new ArrayList();
        this.mSubjectViewRects = new ArrayList();
        this.mSubjectPaint = new Paint();
        this.mSubjectClickIndex = -1;
        this.mIsUnderSubject = false;
        this.mDrawHistory = false;
        this.mHistoryPicture = null;
        this.mHistoryWidth = 0;
        this.mHistoryHeight = 0;
        this.mRebuildWebTextView = false;
        this.mDisplaySoftKeyboard = false;
        this.mFocusedInputBoundsChanged = false;
        this.mOwnEditOn = false;
        this.NEED_ZOOM_SCALE = 0.7f;
        this.SMALL_SCALE_STATE = 1;
        this.MEDIUM_SCALE_STATE = 2;
        this.LARGE_SCALE_STATE = 3;
        this.SOFT_KEYBOARD_HEIGHT = 300;
        this.mContentHeightChanged = false;
        this.mContentHeightAdded = 0;
        this.mGotCenterDown = false;
        this.mIsShiftPressed = false;
        this.mCopyingSth = false;
        this.mBeginScaleSpan = 0.0f;
        this.mMultiScaling = false;
        this.mMultiScalingFirstTime = false;
        this.mScaleScrollX = 0.0f;
        this.mScaleScrollY = 0.0f;
        this.mLastSelX = 0;
        this.mLastSelY = 0;
        this.mNeedToShowSelectionActionDialog = false;
        this.mActionDown = false;
        this.mTrackballFirstTime = 0L;
        this.mTrackballLastTime = 0L;
        this.mTrackballRemainsX = 0.0f;
        this.mTrackballRemainsY = 0.0f;
        this.mTrackballXMove = 0;
        this.mTrackballYMove = 0;
        this.mSelectingText = false;
        this.mSelectionStarted = false;
        this.mExtendSelection = false;
        this.mDrawSelectionPointer = false;
        this.mShowSelectionActionDialog = false;
        this.mMagnifierMode = false;
        this.mMagnifierOn = false;
        this.mSelectX = 0;
        this.mSelectY = 0;
        this.mFocusSizeChanged = false;
        this.mShiftIsPressed = false;
        this.mTrackballDown = false;
        this.mTrackballUpTime = 0L;
        this.mLastCursorTime = 0L;
        this.mEnableSelectText = true;
        this.mMapTrackballToArrowKeys = true;
        this.mStopingLoading = false;
        this.progressTimer = null;
        this.lastProgress = 10;
        this.nightTimer = null;
        this.mLastDownTime = 0L;
        this.mCurListBox = null;
        init();
        if (context == null) {
            throw new IllegalArgumentException("Invalid context argument");
        }
        JniUtil.setContext(context);
        this.mCallbackProxy = new CallbackProxy(context, this);
        this.mViewManager = new ViewManager(this);
        this.mWebViewCore = new WebViewCore(context, this, this.mCallbackProxy, map);
        this.mDatabase = WebViewDatabase.getInstance(context);
        this.mScroller = new ZeusScroller(context);
        this.mContext = context;
        mConnectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        setupProxyListener(context);
        updateMultiTouchSupport(context);
        if (mZeusScaleStore == null) {
            mZeusScaleStore = new ZeusScaleStore(context.getFilesDir().getAbsolutePath());
            mZeusScaleStore.load();
        }
    }

    public void simulateTouchUp(int i, int i2) {
        this.mWebViewCore.simulateTouchUp(i, i2);
    }

    public void simulateKeyDown(KeyEvent keyEvent) {
        this.mWebViewCore.simulateKeyDown(keyEvent);
    }

    public void simulateKeyUp(KeyEvent keyEvent) {
        this.mWebViewCore.simulateKeyUp(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ProxyReceiver extends BroadcastReceiver {
        private ProxyReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.PROXY_CHANGE")) {
                WebView.handleProxyBroadcast(intent);
            }
        }
    }

    private static synchronized void checkApnType(NetworkInfo networkInfo) {
        String str;
        int i;
        String str2;
        boolean z = true;
        synchronized (WebView.class) {
            if (networkInfo == null) {
                mProxyHost = null;
            } else {
                Context context = JniUtil.getContext();
                int i2 = -1;
                String lowerCase = networkInfo.getExtraInfo() != null ? networkInfo.getExtraInfo().toLowerCase() : null;
                if (lowerCase == null) {
                    mProxyHost = null;
                } else {
                    if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
                        str = "10.0.0.172";
                        i2 = 80;
                    } else if (lowerCase.startsWith("ctwap")) {
                        str = PROXY_HOST_CTWAP;
                        i2 = 80;
                    } else if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                        str = null;
                    } else {
                        z = false;
                        str = null;
                    }
                    Cursor query = (z || context == null) ? null : context.getContentResolver().query(PREFERRED_APN_URI, new String[]{"_id", "apn", "proxy", "user"}, null, null, null);
                    if (query != null) {
                        query.moveToFirst();
                        query.getCount();
                        if (!query.isAfterLast()) {
                            String string = query.getString(1);
                            String string2 = query.getString(2);
                            String string3 = query.getString(3);
                            if (string2 != null && string2.length() > 0) {
                                if ("10.0.0.172".equals(string2.trim())) {
                                    i = 80;
                                    str2 = "10.0.0.172";
                                } else if (PROXY_HOST_CTWAP.equals(string2.trim())) {
                                    i = 80;
                                    str2 = PROXY_HOST_CTWAP;
                                }
                                query.close();
                            } else if (string != null && string.length() > 0) {
                                String upperCase = string.toUpperCase();
                                if (upperCase.equals("CMWAP") || upperCase.equals("UNIWAP") || upperCase.equals("3GWAP")) {
                                    i = 80;
                                    str2 = "10.0.0.172";
                                } else if (upperCase.equals("CTWAP")) {
                                    i = 80;
                                    str2 = PROXY_HOST_CTWAP;
                                } else if (string3 != null && string3.toUpperCase().startsWith("CMWAP")) {
                                    i = 80;
                                    str2 = "10.0.0.172";
                                }
                                query.close();
                            }
                        }
                        i = i2;
                        str2 = str;
                        query.close();
                    } else {
                        i = i2;
                        str2 = str;
                    }
                    if (str2 != null && i > 0) {
                        mProxyHost = str2;
                        mProxyPort = i;
                    } else {
                        mProxyHost = null;
                    }
                }
            }
        }
    }

    private static void setProxyConfig() {
        NetworkInfo activeNetworkInfo = mConnectivityManager != null ? mConnectivityManager.getActiveNetworkInfo() : null;
        if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
            mProxyHost = null;
        } else {
            checkApnType(activeNetworkInfo);
        }
    }

    private static synchronized void setupProxyListener(Context context) {
        synchronized (WebView.class) {
            if (JniUtil.useChromiumHttpStack() && sProxyReceiver == null && sNotificationsEnabled) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.PROXY_CHANGE");
                sProxyReceiver = new ProxyReceiver();
                Intent registerReceiver = context.getApplicationContext().registerReceiver(sProxyReceiver, intentFilter);
                if (registerReceiver != null) {
                    handleProxyBroadcast(registerReceiver);
                } else {
                    handleProxyBroadcast(null);
                }
            }
        }
    }

    private static synchronized void disableProxyListener(Context context) {
        synchronized (WebView.class) {
            if (sProxyReceiver != null) {
                context.getApplicationContext().unregisterReceiver(sProxyReceiver);
                sProxyReceiver = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleProxyBroadcast(Intent intent) {
        setProxyConfig();
        ProxyProperties proxyProperties = new ProxyProperties(mProxyHost, mProxyPort, null);
        if (proxyProperties == null || proxyProperties.getHost() == null) {
            WebViewCore.sendStaticMessage(193, null);
        } else {
            WebViewCore.sendStaticMessage(193, proxyProperties);
        }
    }

    public void suspendWebView() {
        this.mSuspendWebView = true;
        this.mWebViewCore.suspendWebView();
    }

    public void resumeWebView() {
        this.mSuspendWebView = false;
        this.mWebViewCore.resumeWebView();
    }

    public void setWebViewVisible(boolean z) {
        this.mWebViewVisible = z;
        if (z) {
            captureScalePic();
        }
    }

    public boolean notifyNativeExitFullScreenIfNeeded(int i) {
        if (this.mWebViewCore == null || !this.mWebViewCore.needNotifyNativeExitFullScreen()) {
            return false;
        }
        this.mWebViewCore.sendMessage(BdWebErrorView.ERROR_CODE_409, i);
        return true;
    }

    public float getCurrentScale() {
        return 1 == this.mZoomFlag ? this.mCurrentScale : this.mActualScale;
    }

    public final boolean canZoomIn() {
        return this.mMaxZoomScale - this.mActualScale > MINIMUM_SCALE_INCREMENT;
    }

    public final boolean canZoomOut() {
        return this.mActualScale - this.mMinZoomScale > MINIMUM_SCALE_INCREMENT && !this.mInZoomOverview;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsMobileSiteZeusFlag(boolean z) {
        this.mIsMobileSiteGuessed = z;
    }

    public boolean isMobileSite() {
        return this.mIsMobileSiteGuessed;
    }

    public boolean ifWapAllowScale() {
        if (getSettings().getIsForcePageCanBeScaled()) {
            return true;
        }
        return this.mMaxZoomScale - this.mMinZoomScale > 0.01f && this.mMinZoomScale < 2.0f;
    }

    public boolean isWapPage() {
        if (getSettings().getIsForcePageCanBeScaled()) {
            if (this.mMinZoomScale >= mDensity || this.mMinZoomScale == this.mDefaultScale) {
                return true;
            }
        } else if (this.mMaxZoomScale - this.mMinZoomScale <= 0.01f || this.mMinZoomScale == this.mDefaultScale) {
            return true;
        }
        return false;
    }

    public static void setToFindTreasure(boolean z) {
        mIsNeedToFindTreasure = z;
    }

    public boolean ifNeedToFindTreasure() {
        return mIsNeedToFindTreasure;
    }

    public static void setImei(String str) {
        mImeiStr = str;
    }

    public String getImei() {
        return mImeiStr;
    }

    protected void buildBitmapMask() {
        int i = getContext().getResources().getDisplayMetrics().heightPixels;
        int i2 = getContext().getResources().getDisplayMetrics().widthPixels;
        if (this.mBitmapMaskMode == 1) {
            if (this.mBitmapMask1 == null || this.mBitmapMask2 == null) {
                int width = getWidth() / this.mBitmapMaskCnt;
                int height = getHeight() / this.mBitmapMaskCnt;
                this.mBitmapMask1 = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
                this.mBitmapMask2 = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
                for (int i3 = 0; i3 < width; i3++) {
                    for (int i4 = 0; i4 < height; i4++) {
                        this.mBitmapMask1.setPixel(i3, i4, -1);
                        this.mBitmapMask2.setPixel(i3, i4, -3355444);
                    }
                }
            }
        } else if (this.mBitmapMaskMode == 2) {
            if (mBitmapMask3 == null || i != mScreenHeight || i2 != mScreenWidth) {
                mScreenHeight = i;
                mScreenWidth = i2;
                if (mBitmapMask3 != null && !WebKitInit.isVersion40() && !WebKitInit.isVersion41()) {
                    mBitmapMask3.recycle();
                }
                int i5 = mScreenWidth + this.mBitmapMaskMetaSize;
                int i6 = mScreenHeight + this.mBitmapMaskMetaSize;
                int i7 = this.mBitmapMaskMetaSize;
                int i8 = this.mBitmapMaskMetaSize;
                int i9 = i5 / this.mBitmapMaskMetaSize;
                int i10 = i6 / this.mBitmapMaskMetaSize;
                try {
                    mBitmapMask3 = Bitmap.createBitmap(i5, i6, Bitmap.Config.RGB_565);
                } catch (Exception e) {
                    Log.e(LOGTAG, "mBitmapMask3 create failure");
                }
                Canvas canvas = new Canvas(mBitmapMask3);
                Paint paint = new Paint();
                paint.setColor(-1);
                Paint paint2 = new Paint();
                paint2.setColor(-3355444);
                Rect rect = new Rect(0, 0, this.mBitmapMaskMetaSize, this.mBitmapMaskMetaSize);
                for (int i11 = 0; i11 < i10; i11++) {
                    for (int i12 = 0; i12 < i9; i12++) {
                        rect.top = i11 * i8;
                        rect.left = i12 * i7;
                        rect.right = (i12 + 1) * i7;
                        rect.bottom = (i11 + 1) * i8;
                        if (((i11 + i12) & 1) == 0) {
                            try {
                                canvas.drawRect(rect, paint);
                            } catch (Exception e2) {
                                Log.e(LOGTAG, "drawRect(MASKmode=2) failure");
                            }
                        } else {
                            canvas.drawRect(rect, paint2);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateMultiTouchSupport(Context context) {
        this.mSupportMultiTouch = context.getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch") && getSettings().supportZoom();
        if (this.mSupportMultiTouch && this.mScaleDetector == null) {
            this.mScaleDetector = new ScaleGestureDetector(context, new ScaleDetectorListener());
        } else if (!this.mSupportMultiTouch && this.mScaleDetector != null) {
            this.mScaleDetector = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateZoomButtonsEnabled() {
        boolean z = true;
        if (this.mZoomButtonsController != null) {
            boolean z2 = this.mActualScale < this.mMaxZoomScale;
            if (this.mActualScale <= this.mMinZoomScale || this.mInZoomOverview) {
                z = false;
            }
            if (!z2 && !z) {
                this.mZoomButtonsController.getZoomControls().setVisibility(8);
                return;
            }
            this.mZoomButtonsController.setZoomInEnabled(z2);
            this.mZoomButtonsController.setZoomOutEnabled(z);
        }
    }

    public void setIsSubjectWebView() {
        this.mIsSubjectWebView = true;
    }

    public void setSubjectNeedScrollOnload(int i) {
        this.mSubjectNeedScrollOnLoad = true;
        this.mSubjectScrollOffsetY = i;
    }

    private void init() {
        setWillNotDraw(false);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setClickable(true);
        setLongClickable(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mTouchSlopSquare = scaledTouchSlop * scaledTouchSlop;
        this.mMinLockSnapReverseDistance = scaledTouchSlop;
        int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
        this.mDoubleTapSlopSquare = scaledDoubleTapSlop * scaledDoubleTapSlop;
        float f = getContext().getResources().getDisplayMetrics().density;
        mDensity = f;
        SUBJECT_WIDTH_ADJUST = (int) ((40.0f * f) / 1.2d);
        this.mNavSlop = (int) (16.0f * f);
        DEFAULT_SCALE_PERCENT = (int) (100.0f * f);
        this.mDefaultScale = f;
        fakeMaxZoomScale = 3.0f * f;
        this.mWaitingZoom2Block = false;
        this.mActualScale = f;
        this.mInvActualScale = 1.0f / f;
        this.mTextWrapScale = f;
        DEFAULT_MAX_ZOOM_SCALE = 4.0f * f;
        DEFAULT_MIN_ZOOM_SCALE = f * 0.25f;
        this.mMaxZoomScale = DEFAULT_MAX_ZOOM_SCALE;
        this.mMinZoomScale = DEFAULT_MIN_ZOOM_SCALE;
        this.mMaximumFling = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mKeysPressed = new Vector(2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateDefaultZoomDensity(int i) {
        float f = (getContext().getResources().getDisplayMetrics().density * 100.0f) / i;
        if (Math.abs(f - this.mDefaultScale) > 0.01d) {
            float f2 = f / this.mDefaultScale;
            this.mNavSlop = (int) (16.0f * f);
            DEFAULT_SCALE_PERCENT = (int) (100.0f * f);
            DEFAULT_MAX_ZOOM_SCALE = 4.0f * f;
            DEFAULT_MIN_ZOOM_SCALE = 0.25f * f;
            this.mDefaultScale = f;
            this.mMaxZoomScale *= f2;
            this.mMinZoomScale *= f2;
            setNewZoomScale(this.mActualScale * f2, true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onSavePassword(String str, String str2, String str3, final Message message) {
        if (message == null) {
            this.mDatabase.setUsernamePassword(str, str2, str3);
            return false;
        }
        final Message obtainMessage = this.mPrivateHandler.obtainMessage(1);
        obtainMessage.getData().putString("host", str);
        obtainMessage.getData().putString("username", str2);
        obtainMessage.getData().putString("password", str3);
        obtainMessage.obj = message;
        final Message obtainMessage2 = this.mPrivateHandler.obtainMessage(2);
        obtainMessage2.getData().putString("host", str);
        obtainMessage2.getData().putString("username", str2);
        obtainMessage2.getData().putString("password", str3);
        obtainMessage2.obj = message;
        new AlertDialog.Builder(getContext()).setTitle(this.mCallbackProxy.getStringById(0)).setMessage(this.mCallbackProxy.getStringById(1)).setPositiveButton(this.mCallbackProxy.getStringById(2), new DialogInterface.OnClickListener() { // from class: com.baidu.zeus.WebView.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                message.sendToTarget();
            }
        }).setNeutralButton(this.mCallbackProxy.getStringById(3), new DialogInterface.OnClickListener() { // from class: com.baidu.zeus.WebView.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                obtainMessage.sendToTarget();
            }
        }).setNegativeButton(this.mCallbackProxy.getStringById(4), new DialogInterface.OnClickListener() { // from class: com.baidu.zeus.WebView.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                obtainMessage2.sendToTarget();
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.zeus.WebView.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                message.sendToTarget();
            }
        }).show();
        return true;
    }

    @Override // android.view.View
    public void setScrollBarStyle(int i) {
        if (i == 16777216 || i == 50331648) {
            this.mOverlayVerticalScrollbar = false;
            this.mOverlayHorizontalScrollbar = false;
        } else {
            this.mOverlayVerticalScrollbar = true;
            this.mOverlayHorizontalScrollbar = true;
        }
        super.setScrollBarStyle(i);
    }

    public void setHorizontalScrollbarOverlay(boolean z) {
        this.mOverlayHorizontalScrollbar = z;
    }

    public void setVerticalScrollbarOverlay(boolean z) {
        this.mOverlayVerticalScrollbar = z;
    }

    public boolean overlayHorizontalScrollbar() {
        return this.mOverlayHorizontalScrollbar;
    }

    public boolean overlayVerticalScrollbar() {
        return this.mOverlayVerticalScrollbar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getViewWidth() {
        return (!isVerticalScrollBarEnabled() || this.mOverlayVerticalScrollbar) ? getWidth() : getWidth() - getVerticalScrollbarWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTitleHeight() {
        if (this.mTitleBar != null) {
            return this.mTitleBar.getHeight();
        }
        return 0;
    }

    public int getVisibleTitleHeight() {
        return Math.max(getTitleHeight() - Math.max(0, this.mScrollY), 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getViewHeight() {
        return getViewHeightWithTitle() - getVisibleTitleHeight();
    }

    private int getViewHeightWithTitle() {
        int height = getHeight();
        if (isHorizontalScrollBarEnabled() && !this.mOverlayHorizontalScrollbar) {
            return height - getHorizontalScrollbarHeight();
        }
        return height;
    }

    public SslCertificate getCertificate() {
        return this.mCertificate;
    }

    public void setCertificate(SslCertificate sslCertificate) {
        this.mCertificate = sslCertificate;
    }

    public void savePassword(String str, String str2, String str3) {
        this.mDatabase.setUsernamePassword(str, str2, str3);
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        this.mDatabase.setHttpAuthUsernamePassword(str, str2, str3, str4);
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        return this.mDatabase.getHttpAuthUsernamePassword(str, str2);
    }

    private void clearHelpers() {
        dismissListBox();
        clearTextEntry(false);
        selectionDone();
    }

    public void destroy() {
        clearHelpers();
        setWebViewVisible(false);
        this.mViewManager.hideAll();
        this.mViewManager.removeChildView();
        if (this.mWebTextView != null) {
            this.mWebTextView.remove();
            this.mWebTextView = null;
        }
        if (this.mNativeClass != 0) {
            nativeStopGL();
        }
        if (this.mWebViewCore != null) {
            this.mCallbackProxy.setWebViewClient(null);
            this.mCallbackProxy.setWebChromeClient(null);
            synchronized (this) {
                WebViewCore webViewCore = this.mWebViewCore;
                this.mWebViewCore = null;
                webViewCore.destroy();
            }
            this.mPrivateHandler.removeCallbacksAndMessages(null);
            this.mCallbackProxy.removeCallbacksAndMessages(null);
            synchronized (this.mCallbackProxy) {
                this.mCallbackProxy.notify();
            }
        }
        if (this.mNativeClass != 0) {
            nativeDestroy();
            this.mNativeClass = 0;
        }
    }

    public static void enablePlatformNotifications() {
        sNotificationsEnabled = true;
        Context context = JniUtil.getContext();
        if (context != null) {
            setupProxyListener(context);
        }
        Network.enablePlatformNotifications();
    }

    public static void disablePlatformNotifications() {
        sNotificationsEnabled = false;
        Context context = JniUtil.getContext();
        if (context != null) {
            disableProxyListener(context);
        }
        Network.disablePlatformNotifications();
    }

    public void setJsFlags(String str) {
        this.mWebViewCore.sendMessage(174, str);
    }

    public void setNetworkAvailable(boolean z) {
        this.mWebViewCore.sendMessage(DO_MOTION_UP, z ? 1 : 0, 0);
    }

    public void setNetworkType(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        hashMap.put("subtype", str2);
        this.mWebViewCore.sendMessage(183, hashMap);
    }

    public WebBackForwardList saveState(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        WebBackForwardList copyBackForwardList = copyBackForwardList();
        int currentIndex = copyBackForwardList.getCurrentIndex();
        int size = copyBackForwardList.getSize();
        if (currentIndex < 0 || currentIndex >= size || size == 0) {
            return null;
        }
        bundle.putInt("index", currentIndex);
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            WebHistoryItem itemAtIndex = copyBackForwardList.getItemAtIndex(i);
            if (itemAtIndex == null) {
                Log.w(LOGTAG, "saveState: Unexpected null history item.");
                return null;
            }
            byte[] flattenedData = itemAtIndex.getFlattenedData();
            if (flattenedData == null) {
                return null;
            }
            arrayList.add(flattenedData);
        }
        bundle.putSerializable("history", arrayList);
        if (this.mCertificate != null) {
            bundle.putBundle("certificate", SslCertificate.saveState(this.mCertificate));
        }
        return copyBackForwardList;
    }

    public boolean savePicture(Bundle bundle, final File file) {
        if (file == null || bundle == null) {
            return false;
        }
        final Picture capturePicture = capturePicture();
        final File file2 = new File(file.getPath() + ".writing");
        new Thread(new Runnable() { // from class: com.baidu.zeus.WebView.6
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2356=4] */
            @Override // java.lang.Runnable
            public void run() {
                FileOutputStream fileOutputStream;
                FileOutputStream fileOutputStream2 = null;
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e) {
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    capturePicture.writeToStream(fileOutputStream);
                    file2.renameTo(file);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e2) {
                        }
                    }
                    file2.delete();
                } catch (Exception e3) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e4) {
                        }
                    }
                    file2.delete();
                } catch (Throwable th2) {
                    fileOutputStream2 = fileOutputStream;
                    th = th2;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Exception e5) {
                        }
                    }
                    file2.delete();
                    throw th;
                }
            }
        }).start();
        bundle.putInt("scrollX", this.mScrollX);
        bundle.putInt("scrollY", this.mScrollY);
        bundle.putFloat("scale", this.mActualScale);
        bundle.putFloat("textwrapScale", this.mTextWrapScale);
        bundle.putBoolean("overview", this.mInZoomOverview);
        return true;
    }

    public void saveFocusedPictureToDisk(final File file) {
        Picture picture = new Picture();
        nativeGetFocusedPicture(picture);
        final Bitmap createBitmap = Bitmap.createBitmap(picture.getWidth(), picture.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawPicture(picture);
        new Thread(new Runnable() { // from class: com.baidu.zeus.WebView.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    createBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (Exception e) {
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restoreHistoryPictureFields(Picture picture, Bundle bundle) {
        int i = bundle.getInt("scrollX", 0);
        int i2 = bundle.getInt("scrollY", 0);
        float f = bundle.getFloat("scale", 1.0f);
        this.mDrawHistory = true;
        this.mHistoryPicture = picture;
        this.mScrollX = i;
        this.mScrollY = i2;
        this.mHistoryWidth = Math.round(picture.getWidth() * f);
        this.mHistoryHeight = Math.round(picture.getHeight() * f);
        this.mActualScale = f;
        this.mInvActualScale = 1.0f / f;
        this.mTextWrapScale = bundle.getFloat("textwrapScale", f);
        this.mInZoomOverview = bundle.getBoolean("overview");
        invalidate();
    }

    public boolean restorePicture(Bundle bundle, File file) {
        if (file == null || bundle == null || !file.exists()) {
            return false;
        }
        try {
            final FileInputStream fileInputStream = new FileInputStream(file);
            final Bundle bundle2 = new Bundle(bundle);
            new Thread(new Runnable() { // from class: com.baidu.zeus.WebView.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        final Picture createFromStream = Picture.createFromStream(fileInputStream);
                        if (createFromStream != null) {
                            WebView.this.mPrivateHandler.post(new Runnable() { // from class: com.baidu.zeus.WebView.8.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    WebView.this.restoreHistoryPictureFields(createFromStream, bundle2);
                                }
                            });
                        }
                    } finally {
                        try {
                            fileInputStream.close();
                        } catch (Exception e) {
                        }
                    }
                }
            }).start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        WebBackForwardList webBackForwardList;
        if (bundle == null) {
            return null;
        }
        if (bundle.containsKey("index") && bundle.containsKey("history")) {
            this.mCertificate = SslCertificate.restoreState(bundle.getBundle("certificate"));
            WebBackForwardList backForwardList = this.mCallbackProxy.getBackForwardList();
            int i = bundle.getInt("index");
            synchronized (backForwardList) {
                List list = (List) bundle.getSerializable("history");
                int size = list.size();
                if (i < 0 || i >= size) {
                    return null;
                }
                for (int i2 = 0; i2 < size; i2++) {
                    byte[] bArr = (byte[]) list.remove(0);
                    if (bArr == null) {
                        return null;
                    }
                    backForwardList.addHistoryItem(new WebHistoryItem(bArr));
                }
                webBackForwardList = copyBackForwardList();
                webBackForwardList.setCurrentIndex(i);
                this.mWebViewCore.removeMessages();
                this.mWebViewCore.sendMessage(UPDATE_TEXTFIELD_TEXT_MSG_ID, i);
            }
        } else {
            webBackForwardList = null;
        }
        return webBackForwardList;
    }

    public void loadUrl(String str, Map map, PageType pageType) {
        stopProgressTimer();
        switchOutDrawHistory();
        WebViewCore.GetUrlData getUrlData = new WebViewCore.GetUrlData();
        getUrlData.mUrl = str;
        getUrlData.mExtraHeaders = map;
        getUrlData.mType = pageType;
        this.mWebViewCore.sendMessage(100, getUrlData);
        clearHelpers();
        this.mEndSessionFlag = false;
        if (!URLUtil.isJavaScriptUrl(str) && this.mWebViewVisible) {
            if (mBitmapForScale != null) {
                mBitmapForScale.eraseColor(this.mBackgroundColor);
            }
            if (mBitmapForDraging != null) {
                mBitmapForDraging.eraseColor(this.mBackgroundColor);
            }
        }
        setContentChangeState(0);
    }

    public void loadUrl(String str) {
        if (str != null) {
            loadUrl(str, null, PageType.NormalType);
        }
    }

    public void loadUrl(String str, PageType pageType) {
        if (str != null) {
            loadUrl(str, null, pageType);
        }
    }

    public void postUrl(String str, byte[] bArr) {
        if (URLUtil.isNetworkUrl(str)) {
            switchOutDrawHistory();
            WebViewCore.PostUrlData postUrlData = new WebViewCore.PostUrlData();
            postUrlData.mUrl = str;
            postUrlData.mPostData = bArr;
            this.mWebViewCore.sendMessage(SEND_CAPTURE_SCALE_PIC, postUrlData);
            clearHelpers();
            return;
        }
        loadUrl(str);
    }

    public void loadData(String str, String str2, String str3) {
        loadUrl("data:" + str2 + ";" + str3 + "," + str);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (str != null && str.toLowerCase().startsWith("data:")) {
            loadData(str2, str3, str4);
            return;
        }
        switchOutDrawHistory();
        WebViewCore.BaseUrlData baseUrlData = new WebViewCore.BaseUrlData();
        baseUrlData.mBaseUrl = str;
        baseUrlData.mData = str2;
        baseUrlData.mMimeType = str3;
        baseUrlData.mEncoding = str4;
        baseUrlData.mHistoryUrl = str5;
        this.mWebViewCore.sendMessage(ZEUS_ENG_WORD_SELECTION_RESULT, baseUrlData);
        clearHelpers();
    }

    public void stopLoading() {
        this.mEndSessionFlag = true;
        stopProgressTimer();
        switchOutDrawHistory();
        if (this.mWebViewCore != null) {
            this.mWebViewCore.sendMessage(WebChromeClient.STRING_DLG_TITLE_DATETIME);
        }
    }

    public void reload() {
        clearHelpers();
        switchOutDrawHistory();
        this.mWebViewCore.sendMessage(102);
    }

    public boolean canGoBack() {
        WebBackForwardList backForwardList = this.mCallbackProxy.getBackForwardList();
        synchronized (backForwardList) {
            if (!backForwardList.getClearPending()) {
                r0 = backForwardList.getCurrentIndex() > 0;
            }
        }
        return r0;
    }

    public void goBack() {
        goBackOrForward(-1);
    }

    public boolean canGoForward() {
        WebBackForwardList backForwardList = this.mCallbackProxy.getBackForwardList();
        synchronized (backForwardList) {
            if (!backForwardList.getClearPending()) {
                r0 = backForwardList.getCurrentIndex() < backForwardList.getSize() + (-1);
            }
        }
        return r0;
    }

    public void goForward() {
        goBackOrForward(1);
    }

    public boolean canGoBackOrForward(int i) {
        boolean z = false;
        WebBackForwardList backForwardList = this.mCallbackProxy.getBackForwardList();
        synchronized (backForwardList) {
            if (!backForwardList.getClearPending()) {
                int currentIndex = backForwardList.getCurrentIndex() + i;
                if (currentIndex >= 0 && currentIndex < backForwardList.getSize()) {
                    z = true;
                }
            }
        }
        return z;
    }

    public void goBackOrForward(int i) {
        goBackOrForward(i, false);
    }

    private void goBackOrForward(int i, boolean z) {
        if (i != 0) {
            clearHelpers();
            this.mWebViewCore.sendMessage(UPDATE_TEXT_ENTRY_MSG_ID, i, z ? 1 : 0);
        }
    }

    private boolean extendScroll(int i) {
        int finalY = this.mScroller.getFinalY();
        int pinLocY = pinLocY(finalY + i);
        if (pinLocY == finalY) {
            return false;
        }
        this.mScroller.setFinalY(pinLocY);
        this.mScroller.extendDuration(computeDuration(0, i));
        return true;
    }

    public boolean pageUp(boolean z) {
        int i;
        if (this.mNativeClass == 0) {
            return false;
        }
        nativeClearCursor();
        if (z) {
            return pinScrollTo(this.mScrollX, 0, true, 0);
        }
        int height = getHeight();
        if (height > 48) {
            i = (-height) + 24;
        } else {
            i = (-height) / 2;
        }
        this.mUserScroll = true;
        return this.mScroller.isFinished() ? pinScrollBy(0, i, true, 0) : extendScroll(i);
    }

    public boolean pageDown(boolean z) {
        int i;
        if (this.mNativeClass == 0) {
            return false;
        }
        nativeClearCursor();
        if (z) {
            return pinScrollTo(this.mScrollX, computeRealVerticalScrollRange(), true, 0);
        }
        int height = getHeight();
        if (height > 48) {
            i = height - 24;
        } else {
            i = height / 2;
        }
        this.mUserScroll = true;
        return this.mScroller.isFinished() ? pinScrollBy(0, i, true, 0) : extendScroll(i);
    }

    public void clearView() {
        this.mContentWidth = 0;
        this.mContentHeight = 0;
        this.mWebViewCore.removeMessages(FIRST_LAYOUT_MSG_ID);
        this.mWebViewCore.sendMessage(SET_TOUCH_HIGHLIGHT_RECTS);
        setBaseLayer(0, null, false, false, false);
    }

    void sendPluginDrawMsg() {
        this.mWebViewCore.sendMessage(500);
    }

    public Bitmap capturePictureZeus() {
        if (this.mWebViewCore == null) {
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.mContentWidth, this.mContentHeight, Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas();
            canvas.setBitmap(createBitmap);
            this.mWebViewCore.copyContentPicture(this.mContentWidth, this.mContentHeight, getZeusBitmapFromCanvas(canvas, createBitmap), this.mContentWidth, this.mContentHeight, this.mScrollX, this.mScrollY);
            return createBitmap;
        } catch (OutOfMemoryError e) {
            Log.e(LOGTAG, "capturePictureZeus: failed to create bitmap" + e);
            System.gc();
            return null;
        }
    }

    public Bitmap capturePictureZeus(int i, int i2) {
        if (this.mWebViewCore == null || this.mContentWidth == 0 || this.mContentHeight == 0) {
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas();
            canvas.setBitmap(createBitmap);
            this.mWebViewCore.copyContentPicture(i, i2, getZeusBitmapFromCanvas(canvas, createBitmap), this.mContentWidth, this.mContentHeight, this.mScrollX, this.mScrollY);
            return createBitmap;
        } catch (OutOfMemoryError e) {
            Log.e(LOGTAG, "capturePictureZeus: failed to create bitmap" + e);
            System.gc();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Picture capturePicture() {
        return null;
    }

    public void exitFullScreenMode() {
        if (this.isZeusPluginFullScreen) {
            quitZeusPluginFullScreenMode();
            if (getSettings().getFlashFullScreenMode()) {
                this.m_ExitFullScreen = true;
                onPause();
            }
            this.mWebViewCore.sendMessage(302);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean inEditingMode() {
        return (this.mWebTextView == null || this.mWebTextView.getParent() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTextEntry(boolean z) {
        if (inEditingMode()) {
            WebViewCore.resumeUpdatePicture(this.mWebViewCore);
            WebViewCore.resumePriority();
            if (this.mPrivateHandler.hasMessages(14)) {
                this.mPrivateHandler.removeMessages(14);
            }
            this.mWebTextView.remove();
            if (this.mShowOwnEdit) {
                this.mEtText.getText().toString();
                updateCachedTextfield(this.mEtText.getText().toString());
                nativeUpdateInputTextfield(this.mEtText.getText().toString(), 0);
                removeView(this.mEtText);
                setNeedTextDeleteBtn(false);
            }
            if (z) {
                setFocusControllerInactive();
                return;
            }
            return;
        }
        hideSoftKeyboard();
    }

    private void clearTextEntry(boolean z, boolean z2) {
        if (inEditingMode() && !z2) {
            setCoreCaretDisable();
        }
        clearTextEntry(z);
    }

    private void setCoreCaretDisable() {
        if (this.mNativeClass != 0) {
            this.mWebViewCore.sendMessage(BdWebErrorView.ERROR_CODE_401, 0, 0);
        }
    }

    public void editTextDelaySendToCore() {
        if (this.mPrivateHandler.hasMessages(14)) {
            this.mPrivateHandler.removeMessages(14);
        }
        WebViewCore.pauseUpdatePicture(this.mWebViewCore);
        this.mPrivateHandler.sendEmptyMessageDelayed(14, EDIT_TEXT_DELAY_TIME);
    }

    public float getScale() {
        return this.mActualScale;
    }

    public void setInitialScale(int i) {
        this.mInitialScaleInPercent = i;
    }

    public void invokeZoomPicker() {
        if (!getSettings().supportZoom()) {
            Log.w(LOGTAG, "This WebView doesn't support zoom.");
            return;
        }
        clearTextEntry(false);
        if (getSettings().getBuiltInZoomControls()) {
            getZoomButtonsController().setVisible(true);
            return;
        }
        this.mPrivateHandler.removeCallbacks(this.mZoomControlRunnable);
        this.mPrivateHandler.postDelayed(this.mZoomControlRunnable, ZOOM_CONTROLS_TIMEOUT);
    }

    public HitTestResult getHitTestResult() {
        if (this.mNativeClass == 0) {
            return null;
        }
        HitTestResult hitTestResult = new HitTestResult();
        if (nativeHasCursorNode()) {
            if (nativeCursorIsTextInput()) {
                hitTestResult.setType(9);
            } else {
                String nativeCursorText = nativeCursorText();
                if (nativeCursorText != null) {
                    if (nativeCursorText.startsWith("tel:")) {
                        hitTestResult.setType(2);
                        hitTestResult.setExtra(nativeCursorText.substring("tel:".length()));
                    } else if (nativeCursorText.startsWith("mailto:")) {
                        hitTestResult.setType(4);
                        hitTestResult.setExtra(nativeCursorText.substring("mailto:".length()));
                    } else if (nativeCursorText.startsWith("geo:0,0?q=")) {
                        hitTestResult.setType(3);
                        hitTestResult.setExtra(URLDecoder.decode(nativeCursorText.substring("geo:0,0?q=".length())));
                    } else if (nativeCursorIsAnchor()) {
                        hitTestResult.setType(7);
                        hitTestResult.setExtra(nativeCursorText);
                        hitTestResult.setExtra2(nativeCursorInnerText());
                    }
                } else if (nativeCursorIsAnchor()) {
                    hitTestResult.setType(11);
                }
            }
        }
        int type = hitTestResult.getType();
        if (type == 0 || type == 7 || (type == 11 && nativeCursorContainImgNode())) {
            String nativeImageURI = nativeImageURI(viewToContentX(((int) this.mLastTouchX) + this.mScrollX), viewToContentY(((int) this.mLastTouchY) + this.mScrollY));
            if (nativeImageURI != null) {
                if (type == 0 || type == 11) {
                    hitTestResult.setType(5);
                    hitTestResult.setExtra(nativeImageURI);
                } else {
                    hitTestResult.setType(8);
                    hitTestResult.setExtra2(hitTestResult.getExtra());
                    hitTestResult.setExtra(nativeImageURI);
                }
            } else if (this.needHitTestNormalText && type == 0) {
                hitTestResult.setType(10);
            }
        }
        if (11 == hitTestResult.getType()) {
            hitTestResult.setType(0);
            return hitTestResult;
        }
        return hitTestResult;
    }

    private void domChangedFocus() {
        if (inEditingMode()) {
            this.mPrivateHandler.obtainMessage(DOM_FOCUS_CHANGED).sendToTarget();
        }
    }

    public void requestFocusNodeHref(Message message) {
        if (message != null && this.mNativeClass != 0 && nativeCursorIsAnchor()) {
            this.mWebViewCore.sendMessage(ZEUS_GET_SELECTION_DONE, nativeCursorFramePointer(), nativeCursorNodePointer(), message);
        }
    }

    public void requestImageRef(Message message) {
        if (this.mNativeClass != 0) {
            String nativeImageURI = nativeImageURI(viewToContentX(((int) this.mLastTouchX) + this.mScrollX), viewToContentY(((int) this.mLastTouchY) + this.mScrollY));
            Bundle data = message.getData();
            data.putString("url", nativeImageURI);
            message.setData(data);
            message.sendToTarget();
        }
    }

    private static int pinLoc(int i, int i2, int i3) {
        if (i3 >= i2 && i >= 0) {
            if (i + i2 > i3) {
                return i3 - i2;
            }
            return i;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int pinLocX(int i) {
        return this.mInOverScrollMode ? i : pinLoc(i, getViewWidth(), computeRealHorizontalScrollRange());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int pinLocY(int i) {
        return this.mInOverScrollMode ? i : pinLoc(i, getViewHeightWithTitle(), computeRealVerticalScrollRange() + getTitleHeight());
    }

    public void setEmbeddedTitleBar(View view) {
        if (this.mTitleBar != view) {
            if (this.mTitleBar != null) {
                removeView(this.mTitleBar);
            }
            if (view != null) {
                addView(view, new AbsoluteLayout.LayoutParams(-1, -2, 0, 0));
                if (this.mTitleShadow == null) {
                    try {
                        this.mTitleShadow = this.mContext.getResources().getDrawable(this.mContext.getResources().getIdentifier("zeus_title_bar_shadow", "drawable", this.mContext.getPackageName()));
                    } catch (Exception e) {
                        Log.e(LOGTAG, "no resource " + e);
                    }
                }
            }
            this.mTitleBar = view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int viewToContentDimension(int i) {
        return Math.round(i * this.mInvActualScale);
    }

    int viewToContentX(int i) {
        return viewToContentDimension(i);
    }

    int viewToContentY(int i) {
        return viewToContentDimension(i - getTitleHeight());
    }

    private float viewToContentXf(int i) {
        return i * this.mInvActualScale;
    }

    private float viewToContentYf(int i) {
        return (i - getTitleHeight()) * this.mInvActualScale;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int contentToViewDimension(int i) {
        return Math.round(i * this.mActualScale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int contentToViewX(int i) {
        return contentToViewDimension(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int contentToViewY(int i) {
        return contentToViewDimension(i) + getTitleHeight();
    }

    private Rect contentToViewRect(Rect rect) {
        return new Rect(contentToViewX(rect.left), contentToViewY(rect.top), contentToViewX(rect.right), contentToViewY(rect.bottom));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void viewInvalidate(int i, int i2, int i3, int i4) {
        float f = this.mActualScale;
        int titleHeight = getTitleHeight();
        invalidate((int) Math.floor(i * f), ((int) Math.floor(i2 * f)) + titleHeight, (int) Math.ceil(i3 * f), ((int) Math.ceil(f * i4)) + titleHeight);
    }

    private void viewInvalidateDelayed(long j, int i, int i2, int i3, int i4) {
        float f = this.mActualScale;
        int titleHeight = getTitleHeight();
        postInvalidateDelayed(j, (int) Math.floor(i * f), ((int) Math.floor(i2 * f)) + titleHeight, (int) Math.ceil(i3 * f), ((int) Math.ceil(f * i4)) + titleHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateContentRect(Rect rect) {
        viewInvalidate(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void abortAnimation() {
        this.mScroller.abortAnimation();
        this.mLastVelocity = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordNewContentSize(int i, int i2, boolean z) {
        if ((i | i2) != 0) {
            if (this.mContentWidth != i || this.mContentHeight != i2) {
                if (this.mContentHeight != i2 && this.mContentHeightChanged) {
                    setContentChangeState(3);
                    invalidate();
                }
                this.mContentWidth = i;
                this.mContentHeight = i2;
                if (!this.mDrawHistory) {
                    int i3 = this.mScrollX;
                    int i4 = this.mScrollY;
                    this.mScrollX = pinLocX(this.mScrollX);
                    this.mScrollY = pinLocY(this.mScrollY);
                    if (i3 != this.mScrollX || i4 != this.mScrollY) {
                        onScrollChanged(this.mScrollX, this.mScrollY, i3, i4);
                    }
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.setFinalX(pinLocX(this.mScroller.getFinalX()));
                        this.mScroller.setFinalY(pinLocY(this.mScroller.getFinalY()));
                    }
                }
            }
            contentSizeChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNewZoomScale(float f, boolean z, boolean z2) {
        if (f < this.mMinZoomScale) {
            f = this.mMinZoomScale;
            if (f < this.mDefaultScale) {
                this.mInZoomOverview = true;
            }
        } else if (f > this.mMaxZoomScale) {
            f = this.mMaxZoomScale;
        }
        if (z) {
            this.mTextWrapScale = f;
            this.mLastHeightSent = 0;
        }
        if (f != this.mActualScale || z2) {
            if (this.mInZoomOverview) {
                setZoomState(ZoomState.ZoomOverview);
            }
            if (f > this.mActualScale) {
                this.mZoomOutFlag = false;
            } else {
                this.mZoomOutFlag = true;
            }
            if (this.mDrawHistory) {
                if (f != this.mActualScale && !this.mPreviewZoomOnly) {
                    this.mCallbackProxy.onScaleChanged(this.mActualScale, f);
                }
                this.mActualScale = f;
                this.mInvActualScale = 1.0f / f;
                sendViewSizeZoom();
                return;
            }
            int i = this.mScrollX;
            int i2 = this.mScrollY;
            float f2 = this.mInvActualScale * f;
            float f3 = (i * f2) + ((f2 - 1.0f) * this.mZoomCenterX);
            float titleHeight = ((f2 - 1.0f) * (this.mZoomCenterY - getTitleHeight())) + (i2 * f2);
            if (f != this.mActualScale && !this.mPreviewZoomOnly) {
                this.mCallbackProxy.onScaleChanged(this.mActualScale, f);
            }
            this.mActualScale = f;
            this.mInvActualScale = 1.0f / f;
            this.mViewManager.scaleAll();
            this.mScrollX = pinLocX(Math.round(f3));
            this.mScrollY = pinLocY(Math.round(titleHeight));
            if (this.mZoomState == ZoomState.ZoomBlock) {
                contentToViewDimension(this.mBlockRect.left);
                this.mScrollX = pinLocX(contentToViewDimension(this.mBlockRect.left));
            }
            if (i != this.mScrollX || i2 != this.mScrollY) {
                onScrollChanged(this.mScrollX, this.mScrollY, i, i2);
            } else {
                sendOurVisibleRect();
            }
            sendViewSizeZoom();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setZoomState(ZoomState zoomState) {
        if (this.mInZoomOverview) {
            this.mZoomState = ZoomState.ZoomOverview;
        } else {
            this.mZoomState = zoomState;
        }
    }

    private Rect sendOurVisibleRect() {
        if (this.mPreviewZoomOnly) {
            return this.mLastVisibleRectSent;
        }
        Rect rect = new Rect();
        if (this.mWebViewCore != null) {
            calcOurContentVisibleRect(rect);
            if (!rect.equals(this.mLastVisibleRectSent)) {
                this.mWebViewCore.sendMessage(WEBCORE_INITIALIZED_MSG_ID, nativeMoveGeneration(), 0, new Point(rect.left, rect.top));
                this.mLastVisibleRectSent = rect;
            }
            Rect rect2 = new Rect();
            if (getGlobalVisibleRect(rect2) && !rect2.equals(this.mLastGlobalRect)) {
                this.mWebViewCore.sendMessage(WEBCORE_NEED_TOUCH_EVENTS, rect2);
                this.mLastGlobalRect = rect2;
                return rect;
            }
            return rect;
        }
        return rect;
    }

    private void calcOurVisibleRect(Rect rect) {
        Point point = new Point();
        getGlobalVisibleRect(rect, point);
        rect.offset(-point.x, -point.y);
        if (this.mFindIsUp) {
            rect.bottom -= this.mFindHeight;
        }
    }

    private void calcOurContentVisibleRect(Rect rect) {
        calcOurVisibleRect(rect);
        rect.left = Math.max(viewToContentX(rect.left), 0);
        rect.top = Math.max(viewToContentY(rect.top + getVisibleTitleHeight()), 0);
        rect.right = Math.min(viewToContentX(rect.right), this.mContentWidth);
        rect.bottom = Math.min(viewToContentY(rect.bottom), this.mContentHeight);
    }

    private void calcOurContentVisibleRectF(RectF rectF) {
        Rect rect = new Rect(0, 0, 0, 0);
        calcOurVisibleRect(rect);
        rectF.left = Math.max(viewToContentXf(rect.left), 0.0f);
        rectF.top = Math.max(viewToContentYf(rect.top + getVisibleTitleHeight()), 0.0f);
        rectF.right = Math.min(viewToContentXf(rect.right), this.mContentWidth);
        rectF.bottom = Math.min(viewToContentYf(rect.bottom), this.mContentHeight);
    }

    private boolean sendViewSizeZoom() {
        if (this.mPreviewZoomOnly) {
            return false;
        }
        int viewWidth = getViewWidth();
        int round = Math.round(viewWidth * this.mInvActualScale);
        int round2 = Math.round(getViewHeight() * this.mInvActualScale);
        if (round > this.mLastWidthSent && this.mWrapContent) {
            round2 = 0;
        }
        if (round == this.mLastWidthSent && round2 == this.mLastHeightSent) {
            return false;
        }
        ViewSizeData viewSizeData = new ViewSizeData();
        viewSizeData.mWidth = round;
        viewSizeData.mHeight = round2;
        viewSizeData.mTextWrapWidth = Math.round(viewWidth / this.mTextWrapScale);
        viewSizeData.mScale = this.mActualScale;
        viewSizeData.mIgnoreHeight = (this.mZoomScale == 0.0f || this.mHeightCanMeasure) ? false : true;
        viewSizeData.mAnchorX = this.mAnchorX;
        viewSizeData.mAnchorY = this.mAnchorY;
        this.mWebViewCore.sendMessage(105, viewSizeData);
        this.mLastWidthSent = round;
        this.mLastHeightSent = round2;
        this.mAnchorY = 0;
        this.mAnchorX = 0;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int computeRealHorizontalScrollRange() {
        return this.mDrawHistory ? this.mHistoryWidth : (int) Math.floor(this.mContentWidth * this.mActualScale);
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        int computeRealHorizontalScrollRange = computeRealHorizontalScrollRange();
        int i = this.mScrollX;
        int computeMaxScrollX = computeMaxScrollX();
        if (i < 0) {
            return computeRealHorizontalScrollRange - i;
        }
        if (i > computeMaxScrollX) {
            return computeRealHorizontalScrollRange + (i - computeMaxScrollX);
        }
        return computeRealHorizontalScrollRange;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollOffset() {
        return Math.max(this.mScrollX, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int computeRealVerticalScrollRange() {
        return this.mDrawHistory ? this.mHistoryHeight : (int) Math.floor(this.mContentHeight * this.mActualScale);
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        int computeRealVerticalScrollRange = computeRealVerticalScrollRange();
        int i = this.mScrollY;
        int computeMaxScrollY = computeMaxScrollY();
        if (i < 0) {
            return computeRealVerticalScrollRange - i;
        }
        if (i > computeMaxScrollY) {
            return computeRealVerticalScrollRange + (i - computeMaxScrollY);
        }
        return computeRealVerticalScrollRange;
    }

    @Override // android.view.View
    protected int computeVerticalScrollOffset() {
        return Math.max(this.mScrollY - getTitleHeight(), 0);
    }

    @Override // android.view.View
    protected int computeVerticalScrollExtent() {
        return getViewHeight();
    }

    protected void onDrawVerticalScrollBar(Canvas canvas, Drawable drawable, int i, int i2, int i3, int i4) {
        if (this.mScrollY < 0) {
            i2 -= this.mScrollY;
        }
        drawable.setBounds(i, getVisibleTitleHeight() + i2, i3, i4);
        drawable.draw(canvas);
    }

    public String getUrl() {
        WebHistoryItem currentItem = this.mCallbackProxy.getBackForwardList().getCurrentItem();
        if (currentItem != null) {
            return currentItem.getUrl();
        }
        return null;
    }

    public String getOriginalUrl() {
        WebHistoryItem currentItem = this.mCallbackProxy.getBackForwardList().getCurrentItem();
        if (currentItem != null) {
            return currentItem.getOriginalUrl();
        }
        return null;
    }

    public String getTitle() {
        WebHistoryItem currentItem = this.mCallbackProxy.getBackForwardList().getCurrentItem();
        if (currentItem != null) {
            return currentItem.getTitle();
        }
        return null;
    }

    public Bitmap getFavicon() {
        WebHistoryItem currentItem = this.mCallbackProxy.getBackForwardList().getCurrentItem();
        if (currentItem != null) {
            return currentItem.getFavicon();
        }
        return null;
    }

    public String getTouchIconUrl() {
        WebHistoryItem currentItem = this.mCallbackProxy.getBackForwardList().getCurrentItem();
        if (currentItem != null) {
            return currentItem.getTouchIconUrl();
        }
        return null;
    }

    public int getProgress() {
        return this.mCallbackProxy.getProgress();
    }

    public int getContentHeight() {
        return this.mContentHeight;
    }

    public int getContentWidth() {
        return this.mContentWidth;
    }

    public void pauseWebkitDraw() {
        WebViewCore.pauseUpdatePicture(this.mWebViewCore);
        this.mUnderSubject = true;
        mSubjectFlag = true;
    }

    public void resumeWebkitDraw() {
        setUnderSubject(false);
        WebViewCore.resumeUpdatePicture(this.mWebViewCore);
        this.mUnderSubject = false;
        captureScalePic();
        mSubjectFlag = false;
    }

    public void setClosed() {
        this.mUnderSubject = false;
    }

    public void pauseTimers() {
        this.mWebViewCore.sendMessage(UPDATE_ZOOM_RANGE);
    }

    public void resumeTimers() {
        this.mWebViewCore.sendMessage(MOVE_OUT_OF_PLUGIN);
    }

    public void PauseMedia(int i) {
        this.mWebViewCore.sendMessage(BdWebErrorView.ERROR_CODE_503);
    }

    public void ResumeMedia(int i) {
        this.mWebViewCore.sendMessage(BdWebErrorView.ERROR_CODE_504);
    }

    public void onPause() {
        if (!this.mIsPaused) {
            this.mIsPaused = true;
            this.mWebViewCore.sendMessage(SET_HAS_PLUGIN);
        }
    }

    public void onResume() {
        if (!this.m_ExitFullScreen && this.mIsPaused) {
            this.mIsPaused = false;
            this.mWebViewCore.sendMessage(SET_IS_MOBILE_SITE_ZEUS);
        }
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public void freeMemory() {
        this.mWebViewCore.sendMessage(ZEUS_NOTIFY_SCALE);
    }

    public void clearCache(boolean z) {
        this.mWebViewCore.sendMessage(CLEAR_TEXT_ENTRY, z ? 1 : 0, 0);
    }

    public void clearFormData() {
        if (inEditingMode()) {
            this.mWebTextView.setAdapterCustom(null);
        }
    }

    public void clearHistory() {
        this.mCallbackProxy.getBackForwardList().setClearPending();
        this.mWebViewCore.sendMessage(UPDATE_TEXT_SELECTION_MSG_ID);
    }

    public void clearSslPreferences() {
        this.mWebViewCore.sendMessage(WebChromeClient.STRING_DLG_BTN_SET);
    }

    public WebBackForwardList copyBackForwardList() {
        return this.mCallbackProxy.getBackForwardList().m249clone();
    }

    public void findNext(boolean z) {
        if (this.mNativeClass != 0) {
            nativeFindNext(z);
        }
    }

    public int findAll(String str) {
        if (this.mNativeClass != 0) {
            r0 = str != null ? nativeFindAll(str.toLowerCase(), str.toUpperCase()) : 0;
            invalidate();
            this.mLastFind = str;
        }
        return r0;
    }

    public void setFindIsUp(boolean z) {
        this.mFindIsUp = z;
        if (z) {
            recordNewContentSize(this.mContentWidth, this.mContentHeight + this.mFindHeight, false);
        }
        if (this.mNativeClass != 0) {
            nativeSetFindIsUp(z);
        }
    }

    public int findIndex() {
        if (this.mNativeClass == 0) {
            return -1;
        }
        return nativeFindIndex();
    }

    public static String findAddress(String str) {
        return findAddress(str, false);
    }

    public static String findAddress(String str, boolean z) {
        return WebViewCore.nativeFindAddress(str, z);
    }

    public void clearMatches() {
        this.mLastFind = "";
        if (this.mNativeClass != 0) {
            nativeSetFindIsEmpty();
            invalidate();
        }
    }

    public void notifyFindDialogDismissed() {
        if (this.mWebViewCore != null) {
            clearMatches();
            setFindIsUp(false);
            recordNewContentSize(this.mContentWidth, this.mContentHeight - this.mFindHeight, false);
            pinScrollTo(this.mScrollX, this.mScrollY, false, 0);
            invalidate();
        }
    }

    public void setFindDialogHeight(int i) {
        this.mFindHeight = i;
    }

    public void documentHasImages(Message message) {
        if (message != null) {
            this.mWebViewCore.sendMessage(SHOW_FULLSCREEN, message);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mTouchMode == 9 && this.mScrollingLayer != 0) {
            if (this.mScroller.computeScrollOffset()) {
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                postInvalidate();
                nativeScrollLayer(this.mScrollingLayer, currX, currY);
                return;
            }
            super.computeScroll();
        } else if (this.mScroller.computeScrollOffset()) {
            int i = this.mScrollX;
            int i2 = this.mScrollY;
            this.mScrollX = this.mScroller.getCurrX();
            this.mScrollY = this.mScroller.getCurrY();
            postInvalidate();
            if (i != this.mScrollX || i2 != this.mScrollY) {
                onScrollChanged(this.mScrollX, this.mScrollY, i, i2);
            }
        } else {
            super.computeScroll();
        }
    }

    private static int computeDuration(int i, int i2) {
        return Math.min((Math.max(Math.abs(i), Math.abs(i2)) * LocationClientOption.MIN_SCAN_SPAN) / STD_SPEED, (int) MAX_DURATION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pinScrollBy(int i, int i2, boolean z, int i3) {
        return pinScrollTo(this.mScrollX + i, this.mScrollY + i2, z, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pinScrollTo(int i, int i2, boolean z, int i3) {
        int pinLocX = pinLocX(i);
        int pinLocY = pinLocY(i2);
        int i4 = pinLocX - this.mScrollX;
        int i5 = pinLocY - this.mScrollY;
        if ((i4 | i5) == 0) {
            return false;
        }
        if (z) {
            this.mScroller.startScroll(this.mScrollX, this.mScrollY, i4, i5, i3 > 0 ? i3 : computeDuration(i4, i5));
            awakenScrollBars(this.mScroller.getDuration());
            invalidate();
        } else {
            abortAnimation();
            scrollTo(pinLocX, pinLocY);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setContentScrollBy(int i, int i2, boolean z) {
        if (this.mDrawHistory) {
            return false;
        }
        int contentToViewDimension = contentToViewDimension(i);
        int contentToViewDimension2 = contentToViewDimension(i2);
        if (this.mHeightCanMeasure) {
            if (contentToViewDimension2 != 0) {
                Rect rect = new Rect();
                calcOurVisibleRect(rect);
                rect.offset(contentToViewDimension, contentToViewDimension2);
                requestRectangleOnScreen(rect);
            }
            return contentToViewDimension2 == 0 && contentToViewDimension != 0 && pinScrollBy(contentToViewDimension, 0, z, 0);
        }
        return pinScrollBy(contentToViewDimension, contentToViewDimension2, z, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class SubjectPostScroll implements Runnable {
        final WebView mWebView;
        final int offsetY;

        public SubjectPostScroll(WebView webView, int i) {
            this.mWebView = webView;
            this.offsetY = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mWebView.mWebViewCore != null) {
                this.mWebView.pinScrollTo(0, this.offsetY, false, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPageFinished(String str) {
        if (this.mPageThatNeedsToSlideTitleBarOffScreen != null) {
            if (this.mPageThatNeedsToSlideTitleBarOffScreen.equals(str) && this.mScrollX == 0 && this.mScrollY == 0) {
                pinScrollTo(0, this.mYDistanceToSlideTitleOffScreen, true, 500);
            }
            this.mPageThatNeedsToSlideTitleBarOffScreen = null;
        }
        this.mEndSessionFlag = true;
        captureScalePic();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setContentScrollTo(int i, int i2) {
        int contentToViewX;
        int contentToViewY;
        if (this.mDrawHistory) {
            return false;
        }
        if ((i | i2) == 0) {
            contentToViewY = 0;
            contentToViewX = 0;
        } else {
            contentToViewX = contentToViewX(i);
            contentToViewY = contentToViewY(i2);
        }
        if (i == 0 && i2 == 1 && this.mScrollX == 0 && this.mScrollY == 0 && this.mTitleBar != null) {
            if (getProgress() < 100) {
                this.mPageThatNeedsToSlideTitleBarOffScreen = getUrl();
                this.mYDistanceToSlideTitleOffScreen = contentToViewY;
                return false;
            }
            pinScrollTo(contentToViewX, contentToViewY, true, 500);
            return false;
        }
        this.m_newPage = true;
        pinScrollTo(contentToViewX, contentToViewY, false, 0);
        return (this.mScrollX != contentToViewX && i >= 0) || (this.mScrollY != contentToViewY && i2 >= 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void spawnContentScrollTo(int i, int i2) {
        if (!this.mDrawHistory) {
            pinScrollTo(contentToViewX(i), contentToViewY(i2), true, 0);
        }
    }

    private void contentSizeChanged(boolean z) {
        if ((this.mContentWidth | this.mContentHeight) != 0) {
            if (this.mHeightCanMeasure) {
                if (getMeasuredHeight() != contentToViewDimension(this.mContentHeight) || z) {
                    requestLayout();
                }
            } else if (this.mWidthCanMeasure) {
                if (getMeasuredWidth() != contentToViewDimension(this.mContentWidth) || z) {
                    requestLayout();
                }
            } else {
                sendViewSizeZoom();
            }
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        this.mCallbackProxy.setWebViewClient(webViewClient);
    }

    public WebViewClient getWebViewClient() {
        return this.mCallbackProxy.getWebViewClient();
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        this.mCallbackProxy.setDownloadListener(downloadListener);
    }

    public WebViewType getWebViewType() {
        return this.mWebViewType;
    }

    public void setWebViewType(WebViewType webViewType) {
        this.mWebViewType = webViewType;
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.mCallbackProxy.setWebChromeClient(webChromeClient);
    }

    public WebChromeClient getWebChromeClient() {
        return this.mCallbackProxy.getWebChromeClient();
    }

    public void setWebBackForwardListClient(WebBackForwardListClient webBackForwardListClient) {
        this.mCallbackProxy.setWebBackForwardListClient(webBackForwardListClient);
    }

    public WebBackForwardListClient getWebBackForwardListClient() {
        return this.mCallbackProxy.getWebBackForwardListClient();
    }

    public void setPictureListener(PictureListener pictureListener) {
        this.mPictureListener = pictureListener;
    }

    public void externalRepresentation(Message message) {
        this.mWebViewCore.sendMessage(160, message);
    }

    public void documentAsText(Message message) {
        this.mWebViewCore.sendMessage(BDLocation.TypeNetWorkLocation, message);
    }

    public void addJavascriptInterface(Object obj, String str) {
        WebViewCore.JSInterfaceData jSInterfaceData = new WebViewCore.JSInterfaceData();
        jSInterfaceData.mObject = obj;
        jSInterfaceData.mInterfaceName = str;
        this.mWebViewCore.sendMessage(ZEUS_HIDE_CURSOR, jSInterfaceData);
    }

    public WebSettings getSettings() {
        return this.mWebViewCore.getSettings();
    }

    public void addPackageNames(Set set) {
        this.mWebViewCore.sendMessage(184, set);
    }

    public void addPackageName(String str) {
        this.mWebViewCore.sendMessage(185, str);
    }

    public void removePackageName(String str) {
        this.mWebViewCore.sendMessage(186, str);
    }

    @Deprecated
    public static synchronized PluginList getPluginList() {
        PluginList pluginList;
        synchronized (WebView.class) {
            pluginList = new PluginList();
        }
        return pluginList;
    }

    @Deprecated
    public void refreshPlugins(boolean z) {
    }

    protected void finalize() {
        try {
            if (this.mNativeClass != 0) {
                this.mPrivateHandler.post(new Runnable() { // from class: com.baidu.zeus.WebView.9
                    @Override // java.lang.Runnable
                    public void run() {
                        WebView.this.destroy();
                    }
                });
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        if (view == this.mTitleBar) {
            this.mTitleBar.offsetLeftAndRight(this.mScrollX - this.mTitleBar.getLeft());
        }
        return super.drawChild(canvas, view, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawContent(Canvas canvas) {
        boolean z = true;
        boolean z2 = hasFocus() && hasWindowFocus();
        if (this.mTouchMode != 4 && !this.mTrackballDown && !this.mGotCenterDown) {
            z = false;
        }
        nativeRecordButtons(z2, z, false);
        drawCoreAndCursorRing(canvas, this.mBackgroundColor, this.mDrawCursorRing);
    }

    public Bitmap getMagnifierBmp() {
        return this.magnifierBmp;
    }

    public Bitmap getCanvasCacheBmp() {
        if (!this.mUseGL) {
            return mBitmapForDraging;
        }
        if (this.mSelectingText) {
            int save = mCanvasSubject.save();
            mCanvasSubject.translate(-this.mScrollX, -this.mScrollY);
            drawTextSelectionHandles(mCanvasSubject);
            mCanvasSubject.restoreToCount(save);
        }
        drawMagnifierCircle(mCanvasSubject, (int) this.mLastTouchX, (int) this.mLastTouchY);
        return mBitmapForScale;
    }

    public void destroyCanvasCacheBmp() {
        Log.e(LOGTAG, "destroyCanvasCacheBmp in");
    }

    public void showMagnifier(int i, int i2, int i3, int i4, boolean z) {
        if (this.mUnderSubject) {
            this.mUnderSubject = false;
            onDraw(mCanvas);
        }
        if (this.mUseGL) {
            doCaptureScalePicViewSize();
        }
        if (this.magnifierBmp != null) {
            if (!WebKitInit.isVersion40() && !WebKitInit.isVersion41()) {
                this.magnifierBmp.recycle();
            }
            this.magnifierBmp = null;
        }
        WebViewCore.pauseUpdatePicture(this.mWebViewCore);
        this.mMagnifierOn = true;
        try {
            if (nativeShowCacheBackBmp()) {
            }
        } catch (OutOfMemoryError e) {
            Log.e(LOGTAG, "showMagnifier out of memory: " + e);
            System.gc();
        }
        this.magnifierX = i;
        this.magnifierY = i2;
        this.mMagnifierMode = z;
        hideSelectionActionDialogPrivate();
        if (getWebChromeClient() != null && i >= 0 && i2 >= 0 && i3 >= 0 && i4 >= 0) {
            getWebChromeClient().showMagnifier(this.mWebViewCore.getWebView(), i, i2, i3, i4);
        }
    }

    public void moveMagnifier(int i, int i2) {
        if (isDrawingCacheEnabled()) {
            buildDrawingCache();
            this.magnifierBmp = getDrawingCache();
        }
        this.magnifierX = i;
        this.magnifierY = i2;
        invalidate();
    }

    public void hideMagnifier(int i, int i2) {
        if (this.magnifierBmp != null || this.mMagnifierOn) {
            this.mMagnifierOn = false;
            if (this.magnifierBmp != null) {
                if (!WebKitInit.isVersion40() && !WebKitInit.isVersion41()) {
                    this.magnifierBmp.recycle();
                }
                this.magnifierBmp = null;
            }
            this.magnifierX = i;
            this.magnifierY = i2;
            if (getWebChromeClient() != null) {
                getWebChromeClient().hideMagnifier(this, i, i2);
            }
        }
    }

    public void doCaptureScalePicViewSize() {
        this.mWebViewCore.drawContentPictureInScale(mCanvas, this.mBackgroundColor, false, false, mBitmapForScale, this.mActualScale, this.mScrollX * this.mInvActualScale, this.mScrollY * this.mInvActualScale, (this.mScrollX + this.mViewWidth) * this.mInvActualScale, (this.mScrollY + this.mViewHeight) * this.mInvActualScale, Math.round(this.mScrollX), Math.round(this.mScrollY), 0, false, this.mUnderSubject);
    }

    public boolean doCaptureScalePic() {
        float f;
        float f2;
        this.mGLCapScalePic = false;
        if (this.mMinZoomScale > 0.4f) {
            float f3 = this.mMinZoomScale - MINIMUM_VELOCITY_RATIO_FOR_ACCELERATION;
        } else {
            float f4 = this.mMinZoomScale - 0.1f;
        }
        if (this.mLastScrollX != this.mScrollX || this.mLastScrollY != this.mScrollY) {
            this.mLastScrollX = this.mScrollX;
            this.mLastScrollY = this.mScrollY;
        }
        int i = this.mScrollX;
        int i2 = this.mScrollY;
        if (this.mForceCapture) {
            f = this.mMinZoomScale > 0.4f ? this.mMinZoomScale - MINIMUM_VELOCITY_RATIO_FOR_ACCELERATION : this.mMinZoomScale - 0.1f;
            this.mFakeZoomCenterX = getViewWidth() / 2;
            this.mFakeZoomCenterY = getViewHeight() / 2;
        } else {
            f = this.mMinZoomScale;
            this.mFakeZoomCenterX = this.mZoomCenterX;
            this.mFakeZoomCenterY = this.mZoomCenterY;
        }
        if (isWapPage()) {
            f2 = this.mMinZoomScale >= 1.0f ? 1.0f : 0.7f;
        } else {
            f2 = f;
        }
        if (this.mZoomScale != 0.0f) {
            this.mFakeZoomCenterX = this.mZoomCenterX;
            this.mFakeZoomCenterY = this.mZoomCenterY;
        }
        if ((1 == this.mZoomFlag || this.mForceCapture) && (this.mZoomOutFlag || this.mForceCapture)) {
            if (mBitmapForScale == null) {
                prepareForCacheCanvas();
                return false;
            } else if ((!this.mCaptureFlag && !this.mProcessCaptureFlag) || (this.mForceCapture && !this.mProcessCaptureFlag)) {
                if (this.mScrollZoomScaleFlag) {
                }
                if (this.mMultiZoomScaleFlag || this.mForceCapture) {
                    this.mProcessCaptureFlag = true;
                    float f5 = this.mFakeZoomCenterX;
                    float f6 = this.mFakeZoomCenterY;
                    float f7 = this.mFakeZoomCenterX + i;
                    float f8 = this.mFakeZoomCenterY + i2;
                    float f9 = this.mInvActualScale * f2;
                    mBitmapForScale.eraseColor(this.mBackgroundColor);
                    this.mfLeft = Math.round(f7 * f9) - this.mFakeZoomCenterX;
                    this.mfTop = Math.round(f8 * f9) - this.mFakeZoomCenterY;
                    this.mWebViewCore.drawContentPictureInScale(mCanvas, this.mBackgroundColor, false, false, mBitmapForScale, f2, this.mfLeft, this.mfTop, (Math.round(this.mfLeft) + this.mViewWidth) / f2, (Math.round(this.mfTop) + this.mViewHeight) / f2, Math.round(this.mfLeft), Math.round(this.mfTop), 0, false, this.mUnderSubject);
                    this.mCaptureFlag = true;
                    this.mProcessCaptureFlag = false;
                } else {
                    Log.e(LOGTAG, "There must be an error when zoom");
                    return false;
                }
            }
        }
        return true;
    }

    public boolean captureScalePic() {
        if (this.mZoomFlag == 0 && ((this.mUseGL || this.mActualScale - this.mMinZoomScale > 0.01f) && this.mWebViewVisible && !this.mUnderSubject && !mDrawingSubject && !mSubjectFlag)) {
            this.mShouldCapture = true;
        }
        return true;
    }

    public boolean captureScalePic(boolean z) {
        if (z || (this.mZoomFlag == 0 && ((this.mUseGL || this.mActualScale - this.mMinZoomScale > 0.01f) && this.mWebViewVisible && !this.mUnderSubject && !mDrawingSubject))) {
            this.mShouldCapture = true;
        }
        return true;
    }

    protected boolean onZoomScale(Canvas canvas) {
        float f;
        float f2;
        float f3 = this.mMinZoomScale > 0.4f ? this.mMinZoomScale - MINIMUM_VELOCITY_RATIO_FOR_ACCELERATION : this.mMinZoomScale - 0.1f;
        float viewWidth = getViewWidth();
        float viewHeight = getViewHeight();
        boolean z = this.mZoomScale != 0.0f;
        if (z) {
            this.mZoomFlag = 1;
            if (!this.mFirstAnimateOut) {
                this.mForceCapture = true;
                doCaptureScalePic();
                this.mForceCapture = false;
                this.mFirstAnimateOut = true;
                this.mZoomStart = SystemClock.uptimeMillis();
            }
            int uptimeMillis = (int) (SystemClock.uptimeMillis() - this.mZoomStart);
            if (uptimeMillis < 200) {
                f2 = 1.0f / (((uptimeMillis / 200.0f) * (this.mInvFinalZoomScale - this.mInvInitialZoomScale)) + this.mInvInitialZoomScale);
                invalidate();
            } else {
                this.mFirstAnimateOut = false;
                this.mZoomFlag = 0;
                this.mZoomOutFlag = false;
                this.mMultiZoomScaleFlag = false;
                f2 = this.mZoomScale;
                this.mZoomScale = 0.0f;
                WebViewCore.resumeUpdatePicture(this.mWebViewCore);
                invalidate();
                if (this.mNeedToAdjustWebTextView) {
                    this.mNeedToAdjustWebTextView = false;
                    if (didUpdateTextViewBounds(false) && nativeFocusCandidateIsPassword()) {
                        this.mWebTextView.setInPassword(true);
                    }
                }
            }
            this.mCurrentScale = f2;
            if (inEditingMode() && !this.mNeedToAdjustWebTextView && this.mZoomScale != 0.0f) {
                this.mNeedToAdjustWebTextView = true;
                if (nativeFocusCandidateIsPassword()) {
                    this.mWebTextView.setInPassword(false);
                }
            }
        }
        if (isWapPage()) {
            f = this.mMinZoomScale >= 1.0f ? 1.0f : 0.7f;
        } else {
            f = f3;
        }
        if (1 == this.mZoomFlag) {
            setContentChangeState(0);
            if (this.mZoomOutFlag) {
                if (mBitmapForScale == null) {
                    return false;
                }
                if (!this.mCaptureFlag && !mUseBackThread) {
                    if (this.mScrollZoomScaleFlag) {
                        int i = this.mScrollX;
                        int i2 = this.mScrollY;
                        float f4 = this.mInvActualScale * f;
                        float f5 = (i * f4) + ((f4 - 1.0f) * this.mZoomCenterX);
                        float titleHeight = ((f4 - 1.0f) * (this.mZoomCenterY - getTitleHeight())) + (i2 * f4);
                        System.currentTimeMillis();
                        this.mWebViewCore.drawContentPictureInScale(canvas, this.mBackgroundColor, false, false, mBitmapForScale, f, Math.round(f5), Math.round(titleHeight), (viewWidth + Math.round(f5)) / f, (viewHeight + Math.round(titleHeight)) / f, Math.round(f5), Math.round(titleHeight), 0, false, this.mUnderSubject);
                        this.mCaptureFlag = true;
                    } else if (this.mMultiZoomScaleFlag) {
                        float f6 = this.mZoomCenterX;
                        float f7 = this.mZoomCenterY;
                        int i3 = this.mScrollX;
                        int i4 = this.mScrollY;
                        float f8 = this.mZoomCenterX + this.mScrollX;
                        float f9 = this.mZoomCenterY + this.mScrollY;
                        float f10 = this.mInvActualScale * f;
                        this.mfLeft = Math.round(f8 * f10) - this.mZoomCenterX;
                        this.mfTop = Math.round(f9 * f10) - this.mZoomCenterY;
                        this.mWebViewCore.drawContentPictureInScale(canvas, this.mBackgroundColor, false, false, mBitmapForScale, f, this.mfLeft, this.mfTop, (Math.round(this.mfLeft) + viewWidth) / f, (Math.round(this.mfTop) + viewHeight) / f, Math.round(this.mfLeft), Math.round(this.mfTop), 0, false, this.mUnderSubject);
                        this.mCaptureFlag = true;
                    } else {
                        Log.e(LOGTAG, "There must be an error when zoom");
                        return false;
                    }
                }
            }
            try {
                if (this.mUseGL && this.mGLCapScalePic && !this.mFirstAnimateOut) {
                    this.mZoomWhenScrolling = true;
                    this.mForceCapture = true;
                    doCaptureScalePic();
                    this.mForceCapture = false;
                }
                if (this.mZoomOutFlag) {
                    if ((this.mLastScrollX != this.mScrollX || this.mLastScrollY != this.mScrollY) && !this.mZoomWhenScrolling && !this.mGLCapScalePic && !this.mFirstAnimateOut) {
                        this.mZoomWhenScrolling = true;
                        this.mForceCapture = true;
                        doCaptureScalePic();
                        this.mForceCapture = false;
                    }
                    int save = canvas.save();
                    if (this.mScrollZoomScaleFlag) {
                        canvas.scale(this.mCurrentScale / f, this.mCurrentScale / f, this.mScrollX, this.mScrollY);
                        this.mSrcRectForDraging.left = (int) (((this.mScrollX * this.mInvActualScale) * f) - this.mfLeft);
                        this.mSrcRectForDraging.top = (int) (((this.mScrollY * this.mInvActualScale) * f) - this.mfTop);
                        this.mSrcRectForDraging.right = getViewWidth();
                        this.mSrcRectForDraging.bottom = getViewHeight();
                        this.mDstRectForDraging.left = this.mScrollX;
                        this.mDstRectForDraging.top = this.mScrollY;
                        this.mDstRectForDraging.right = (this.mScrollX + this.mSrcRectForDraging.right) - this.mSrcRectForDraging.left;
                        this.mDstRectForDraging.bottom = (this.mScrollY + this.mSrcRectForDraging.bottom) - this.mSrcRectForDraging.top;
                        canvas.drawBitmap(mBitmapForScale, this.mSrcRectForDraging, this.mDstRectForDraging, (Paint) null);
                    } else if (this.mMultiZoomScaleFlag) {
                        canvas.scale(this.mCurrentScale / f, this.mCurrentScale / f, this.mFakeZoomCenterX + this.mScrollX, this.mFakeZoomCenterY + this.mScrollY);
                        canvas.drawBitmap(mBitmapForScale, this.mScrollX, this.mScrollY, (Paint) null);
                    }
                    canvas.restoreToCount(save);
                    if (!this.mUseGL && this.mScrollZoomScaleFlag && this.mSrcRectForDraging != null && this.mDstRectForDraging != null && !this.mZoomWhenScrolling) {
                        int save2 = canvas.save();
                        canvas.scale(this.mCurrentScale / this.mActualScale, this.mCurrentScale / this.mActualScale, this.mZoomCenterX + this.mScrollX, this.mZoomCenterY + this.mScrollY);
                        this.mSrcRectForDraging.left = 0;
                        this.mSrcRectForDraging.top = 0;
                        this.mSrcRectForDraging.right = getViewWidth();
                        this.mSrcRectForDraging.bottom = getViewHeight();
                        this.mDstRectForDraging.left = this.mScrollX;
                        this.mDstRectForDraging.top = this.mScrollY;
                        this.mDstRectForDraging.right = this.mScrollX + this.mSrcRectForDraging.right;
                        this.mDstRectForDraging.bottom = this.mScrollY + this.mSrcRectForDraging.bottom;
                        canvas.drawBitmap(mBitmapForDraging, this.mSrcRectForDraging, this.mDstRectForDraging, (Paint) null);
                        canvas.restoreToCount(save2);
                    } else if (!this.mUseGL && this.mMultiZoomScaleFlag && this.mSrcRectForDraging != null && this.mDstRectForDraging != null && !z) {
                        int save3 = canvas.save();
                        canvas.scale(this.mCurrentScale / this.mActualScale, this.mCurrentScale / this.mActualScale, this.mFakeZoomCenterX + this.mScrollX, this.mFakeZoomCenterY + this.mScrollY);
                        this.mSrcRectForDraging.left = 0;
                        this.mSrcRectForDraging.top = 0;
                        this.mSrcRectForDraging.right = getViewWidth();
                        this.mSrcRectForDraging.bottom = getViewHeight();
                        this.mDstRectForDraging.left = this.mScrollX;
                        this.mDstRectForDraging.top = this.mScrollY;
                        this.mDstRectForDraging.right = this.mScrollX + this.mSrcRectForDraging.right;
                        this.mDstRectForDraging.bottom = this.mScrollY + this.mSrcRectForDraging.bottom;
                        canvas.drawBitmap(mBitmapForDraging, this.mSrcRectForDraging, this.mDstRectForDraging, (Paint) null);
                        canvas.restoreToCount(save3);
                    }
                    if (z) {
                        int save4 = canvas.save();
                        canvas.scale(this.mCurrentScale / f, this.mCurrentScale / f, this.mZoomCenterX + this.mScrollX, this.mZoomCenterY + this.mScrollY);
                        canvas.drawBitmap(mBitmapForScale, this.mScrollX, this.mScrollY, (Paint) null);
                        canvas.restoreToCount(save4);
                    }
                } else if (this.mUseGL) {
                    int save5 = canvas.save();
                    if (z) {
                        canvas.scale(this.mCurrentScale / f, this.mCurrentScale / f, this.mZoomCenterX + this.mScrollX, this.mZoomCenterY + this.mScrollY);
                        canvas.drawBitmap(mBitmapForScale, this.mScrollX, this.mScrollY, (Paint) null);
                    } else if (this.mMultiZoomScaleFlag) {
                        canvas.scale(this.mCurrentScale / f, this.mCurrentScale / f, this.mFakeZoomCenterX + this.mScrollX, this.mFakeZoomCenterY + this.mScrollY);
                        canvas.drawBitmap(mBitmapForScale, this.mScrollX, this.mScrollY, (Paint) null);
                    } else if (this.mScrollZoomScaleFlag) {
                        canvas.scale(this.mCurrentScale / f, this.mCurrentScale / f, this.mScrollX, this.mScrollY);
                        this.mSrcRectForDraging.left = (int) (((this.mScrollX * this.mInvActualScale) * f) - this.mfLeft);
                        this.mSrcRectForDraging.top = (int) (((this.mScrollY * this.mInvActualScale) * f) - this.mfTop);
                        this.mSrcRectForDraging.right = getViewWidth();
                        this.mSrcRectForDraging.bottom = getViewHeight();
                        this.mDstRectForDraging.left = this.mScrollX;
                        this.mDstRectForDraging.top = this.mScrollY;
                        this.mDstRectForDraging.right = (this.mScrollX + this.mSrcRectForDraging.right) - this.mSrcRectForDraging.left;
                        this.mDstRectForDraging.bottom = (this.mScrollY + this.mSrcRectForDraging.bottom) - this.mSrcRectForDraging.top;
                        canvas.drawBitmap(mBitmapForScale, this.mSrcRectForDraging, this.mDstRectForDraging, (Paint) null);
                    }
                    canvas.restoreToCount(save5);
                } else {
                    int save6 = canvas.save();
                    if (z) {
                        canvas.scale(this.mCurrentScale * this.mInvInitialZoomScale, this.mCurrentScale * this.mInvInitialZoomScale, this.mZoomCenterX + this.mScrollX, this.mZoomCenterY + this.mScrollY);
                    } else {
                        canvas.scale(this.mCurrentScale / this.mActualScale, this.mCurrentScale / this.mActualScale, this.mZoomCenterX + this.mScrollX, this.mZoomCenterY + this.mScrollY);
                    }
                    canvas.drawBitmap(mBitmapForDraging, this.mScrollX, this.mScrollY, (Paint) null);
                    canvas.restoreToCount(save6);
                }
                return true;
            } catch (Exception e) {
                if (mBitmapForDraging == null) {
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mNativeClass != 0 && this.mWebViewVisible && !onZoomScale(canvas)) {
            boolean z = getSettings().getUseGLRendering() && JniUtil.myIsUseHardwareAccelerate(canvas);
            if (z) {
                this.mUseGL = true;
                this.mGLCapScalePic = true;
                if (prepareForCacheCanvas()) {
                    int save = canvas.save();
                    canvas.scale(this.mActualScale, this.mActualScale);
                    this.mRectForRefresh = canvas.getClipBounds();
                    canvas.restoreToCount(save);
                    this.mDrawFlag = false;
                } else {
                    return;
                }
            } else if (!z) {
                if (this.mUseGL && !this.mDrawFlag) {
                    this.mDrawFlag = true;
                }
                this.mUseGL = false;
            }
            if (this.mDrawFlag) {
                if ((this.mContentWidth | this.mContentHeight) == 0 && this.mHistoryPicture == null) {
                    canvas.drawColor(this.mBackgroundColor);
                } else if (prepareForCacheCanvas()) {
                    int save2 = canvas.save();
                    canvas.scale(this.mActualScale, this.mActualScale);
                    this.mRectForRefresh = canvas.getClipBounds();
                    canvas.restoreToCount(save2);
                    this.mDrawFlag = false;
                    this.mOnDrawing = true;
                    onDraw(mCanvas);
                    this.mOnDrawing = false;
                    if (this.mWebViewVisible) {
                        if (JniUtil.myIsUseHardwareAccelerate(canvas)) {
                            flushCache(2);
                        }
                        if (this.mUnderSubject) {
                            canvas.drawBitmap(mBitmapForScale, this.mScrollX, this.mScrollY, (Paint) null);
                        } else {
                            canvas.drawBitmap(mBitmapForDraging, this.mScrollX, this.mScrollY, (Paint) null);
                        }
                    }
                    int save3 = canvas.save();
                    if (JniUtil.myIsUseHardwareAccelerate(canvas) && (isZeusPluginFullScreenMode() || hasPluginState.HasNoPlugin != this.mHasPlugin)) {
                        drawContent(canvas);
                    }
                    canvas.restoreToCount(save3);
                    mCanvas.restore();
                    this.mDrawFlag = true;
                    if (!z) {
                        checkAndDrawSubject(canvas);
                    }
                }
            } else if ((this.mContentWidth | this.mContentHeight) == 0 && this.mHistoryPicture == null) {
                canvas.drawColor(this.mBackgroundColor);
            } else {
                int save4 = canvas.save();
                if (this.mTitleBar != null) {
                    canvas.translate(0.0f, this.mTitleBar.getHeight());
                }
                if (this.mDragTrackerHandler == null) {
                    drawContent(canvas);
                } else {
                    if (!this.mDragTrackerHandler.draw(canvas)) {
                        drawContent(canvas);
                    }
                    if (this.mDragTrackerHandler.isFinished()) {
                        this.mDragTrackerHandler = null;
                    }
                }
                if (this.mSubjectClickIndex == -1 || this.mSelectingText || !this.mMagnifierMode) {
                }
                if (this.mUseGL) {
                    checkAndDrawSubject(canvas);
                }
                if (this.mSubjectClickIndex == -1 && this.mTapOnSubject) {
                    this.mTapOnSubject = false;
                }
                int i = (int) this.mLastTouchX;
                int i2 = (int) this.mLastTouchY;
                if (this.mUseGL) {
                    i += this.mScrollX;
                    i2 += this.mScrollY;
                }
                drawMagnifierCircle(canvas, i, i2);
                canvas.restoreToCount(save4);
                int visibleTitleHeight = getVisibleTitleHeight();
                if (this.mTitleBar != null && visibleTitleHeight == 0) {
                    this.mTitleShadow.setBounds(this.mScrollX, this.mScrollY, this.mScrollX + getWidth(), ((int) (5.0f * getContext().getResources().getDisplayMetrics().density)) + this.mScrollY);
                    this.mTitleShadow.draw(canvas);
                }
                if (inEditingMode()) {
                }
                this.mWebViewCore.signalRepaintDone();
                if (this.mNeedToShowSelectionActionDialog) {
                    this.mNeedToShowSelectionActionDialog = false;
                    this.mWebViewCore.sendMessage(BdWebErrorView.ERROR_CODE_403, getSelection());
                }
                if (this.magnifierBmp != null && this.mCanvasCacheBmp != null) {
                    if (!WebKitInit.isVersion40() && !WebKitInit.isVersion41()) {
                        this.mCanvasCacheBmp.recycle();
                    }
                    this.mCanvasCacheBmp = null;
                }
                if (this.mDidFirstLayout) {
                    this.mDidFirstLayout = false;
                    if (this.mCallbackProxy != null) {
                        this.mCallbackProxy.onFirstLayoutDid(this.mCurrentUrl);
                    }
                }
            }
        }
    }

    private void removeTouchHighlight() {
        this.mWebViewCore.removeMessages(301);
        this.mPrivateHandler.removeMessages(SET_TOUCH_HIGHLIGHT_RECTS);
        setTouchHighlightRects(null);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams.height == -2) {
            this.mWrapContent = true;
        }
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public boolean performLongClick() {
        if (getParent() == null) {
            return false;
        }
        dismissListBox();
        if (this.mNativeClass != 0 && nativeCursorIsTextInput()) {
            centerKeyPressOnTextField();
            rebuildWebTextView();
        } else {
            clearTextEntry(true);
        }
        if (inEditingMode()) {
            return this.mWebTextView.performLongClick();
        }
        return super.performLongClick();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean inAnimateZoom() {
        return this.mZoomScale != 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean didUpdateTextViewBounds(boolean z) {
        Rect contentToViewRect = contentToViewRect(nativeFocusCandidateNodeBounds(false));
        Rect rect = new Rect();
        calcOurVisibleRect(rect);
        if (!z ? rect.contains(contentToViewRect) : Rect.intersects(rect, contentToViewRect)) {
            return true;
        }
        this.mWebTextView.remove();
        if (this.mShowOwnEdit) {
            this.mEtText.getText().toString();
            updateCachedTextfield(this.mEtText.getText().toString());
            nativeUpdateInputTextfield(this.mEtText.getText().toString(), 0);
            removeView(this.mEtText);
            return false;
        }
        return false;
    }

    public static boolean HasGPU() {
        return WebViewCore.HasGPU();
    }

    public void setBaseLayer(int i, Region region, boolean z, boolean z2, boolean z3) {
        if (this.mNativeClass != 0) {
            nativeSetBaseLayer(i, region, z, z2, z3);
        }
    }

    private void drawExtras(Canvas canvas, int i, boolean z) {
        if (z) {
            canvas.setDrawFilter(this.mWebViewCore.mZoomFilter);
        }
        nativeDrawExtras(canvas, i);
        canvas.setDrawFilter(null);
    }

    private boolean InvalidatePaintRect() {
        boolean z = ((float) (this.mRectForRefresh.right - this.mRectForRefresh.left)) * this.mActualScale >= ((float) getViewWidth()) && ((float) (this.mRectForRefresh.bottom - this.mRectForRefresh.top)) * this.mActualScale >= ((float) getViewHeight());
        if (z && this.mLastScrollX == this.mScrollX && this.mLastScrollY == this.mScrollY) {
            return false;
        }
        return z;
    }

    private void drawCoreAndCursorRing(Canvas canvas, int i, boolean z) {
        int i2;
        int i3;
        float f;
        int round;
        if (this.mDrawHistory) {
            canvas.scale(this.mActualScale, this.mActualScale);
            canvas.drawPicture(this.mHistoryPicture);
            return;
        }
        boolean z2 = this.mZoomScale != 0.0f;
        boolean z3 = !((this.mScroller.isFinished() && this.mVelocityTracker == null) || (this.mTouchMode == 3 && this.mHeldMotionless == 2)) || this.mDeferTouchMode == 3;
        if (this.mTouchMode == 3) {
            if (this.mHeldMotionless == 1) {
                this.mPrivateHandler.removeMessages(8);
                this.mPrivateHandler.removeMessages(9);
                this.mHeldMotionless = 0;
            }
            if (this.mHeldMotionless == 0) {
                this.mPrivateHandler.sendMessageDelayed(this.mPrivateHandler.obtainMessage(8), 100L);
                this.mHeldMotionless = 1;
            }
        }
        if (z2) {
            int uptimeMillis = (int) (SystemClock.uptimeMillis() - this.mZoomStart);
            if (uptimeMillis < 200) {
                f = 1.0f / (((uptimeMillis / 200.0f) * (this.mInvFinalZoomScale - this.mInvInitialZoomScale)) + this.mInvInitialZoomScale);
                invalidate();
            } else {
                f = this.mZoomScale;
                this.mZoomScale = 0.0f;
                WebViewCore.resumeUpdatePicture(this.mWebViewCore);
                invalidate();
                if (this.mNeedToAdjustWebTextView) {
                    this.mNeedToAdjustWebTextView = false;
                    if (didUpdateTextViewBounds(false) && nativeFocusCandidateIsPassword()) {
                        this.mWebTextView.setInPassword(true);
                    }
                }
            }
            float f2 = this.mInvInitialZoomScale * f;
            int i4 = (-pinLoc(Math.round(((this.mInitialScrollX + this.mZoomCenterX) * f2) - this.mZoomCenterX), getViewWidth(), Math.round(this.mContentWidth * f))) + this.mScrollX;
            int titleHeight = getTitleHeight();
            canvas.translate(i4, (-(Math.round((f2 * ((this.mInitialScrollY + this.mZoomCenterY) - titleHeight)) - (this.mZoomCenterY - titleHeight)) <= titleHeight ? Math.max(round, 0) : pinLoc(round - titleHeight, getViewHeight(), Math.round(this.mContentHeight * f)) + titleHeight)) + this.mScrollY);
            canvas.scale(f, f);
            if (inEditingMode() && !this.mNeedToAdjustWebTextView && this.mZoomScale != 0.0f) {
                this.mNeedToAdjustWebTextView = true;
                if (nativeFocusCandidateIsPassword()) {
                    this.mWebTextView.setInPassword(false);
                }
            }
        } else if (!JniUtil.myIsUseHardwareAccelerate(canvas)) {
            canvas.scale(this.mActualScale, this.mActualScale);
        }
        boolean z4 = false;
        if (this.mNativeClass != 0 && nativeEvaluateLayersAnimations()) {
            z4 = true;
            if (!JniUtil.myIsUseHardwareAccelerate(canvas)) {
                invalidate();
            }
        }
        boolean z5 = z4;
        if (!this.mUseGL && JniUtil.myIsUseHardwareAccelerate(canvas)) {
            i3 = 0;
        } else {
            if (this.magnifierBmp == null) {
                if (this.mDragging) {
                    setContentChangeState(1);
                }
                if (getWebViewType() == WebViewType.BIGPLUGIN) {
                    setContentChangeState(3);
                }
                if (this.mUnderSubject) {
                    mDrawingSubject = true;
                    this.mWebViewCore.drawContentPictureInScale(canvas, i, z2 || this.mPreviewZoomOnly || z5, z3, mBitmapForDraging, this.mActualScale, canvas.getClipBounds().left, canvas.getClipBounds().top, canvas.getClipBounds().right, canvas.getClipBounds().bottom, this.mScrollX, this.mScrollY, getContentChangeState(), (this.mTapOnSubject || this.mSelectingText) ? false : true, this.mUnderSubject);
                    mDrawingSubject = false;
                } else {
                    if (!this.mUseGL) {
                        this.mWebViewCore.drawContentPicture(canvas, i, z2 || this.mPreviewZoomOnly || z5, z3, mBitmapForDraging, this.mActualScale, this.mRectForRefresh.left, this.mRectForRefresh.top, this.mRectForRefresh.right, this.mRectForRefresh.bottom, this.mScrollX, this.mScrollY, getContentChangeState(), (this.mTapOnSubject || this.mSelectingText) ? false : true, this.mWebViewVisible);
                    } else {
                        this.mWebViewCore.emulateDrawContentPicture(canvas, i, z2 || this.mPreviewZoomOnly || z5, z3, mBitmapForDraging, this.mActualScale, this.mRectForRefresh.left, this.mRectForRefresh.top, this.mRectForRefresh.right, this.mRectForRefresh.bottom, this.mScrollX, this.mScrollY, getContentChangeState(), this.m_newPage, this.mWebViewVisible);
                        this.m_newPage = false;
                    }
                    this.mScrollXDraging = this.mScrollX;
                    this.mScrollYDraging = this.mScrollY;
                    if ((InvalidatePaintRect() && ((this.mDragState == DragState.DragStop || this.mDragState == DragState.DragUnknown) && this.mScrollState != ScrollState.Scrolling)) || this.mSwitchScreenFlag) {
                        if (this.mDragState == DragState.DragStop) {
                            this.mDragState = DragState.DragUnknown;
                        }
                        captureScalePic();
                    } else if (this.mScrollState == ScrollState.ScrollStop && (this.mDragState == DragState.DragStop || this.mDragState == DragState.DragUnknown)) {
                        captureScalePic();
                    }
                    if (this.mScrollState == ScrollState.ScrollStop) {
                        this.mScrollState = ScrollState.ScrollUnknown;
                    }
                }
                if (this.mShouldCapture && !this.mUseGL) {
                    this.mForceCapture = true;
                    doCaptureScalePic();
                    this.mForceCapture = false;
                    this.mShouldCapture = false;
                }
                if (this.mEndSessionFlag) {
                    setContentChangeState(1);
                }
                setContentChangeState(0);
            } else {
                new Rect(0, 0, this.magnifierBmp.getWidth(), this.magnifierBmp.getHeight());
                new Rect(this.mScrollX, this.mScrollY, getWidth() + this.mScrollX, getHeight() + this.mScrollY);
                if (!z2) {
                    canvas.scale(this.mActualScale, this.mActualScale);
                }
            }
            if (this.mNativeClass != 0) {
                if (this.mFindIsUp) {
                    i2 = 1;
                } else if (this.mSelectingText) {
                    i2 = 2;
                    nativeSetSelectionPointer(this.mDrawSelectionPointer, this.mInvActualScale, this.mSelectX, this.mSelectY - getTitleHeight());
                } else if (!z) {
                    i2 = 0;
                } else {
                    i2 = 3;
                }
                if (!JniUtil.myIsUseHardwareAccelerate(canvas) || 2 == i2) {
                    drawExtras(canvas, i2, z5);
                }
                if (i2 == 3 && this.mTouchMode == 4) {
                    this.mTouchMode = 5;
                }
                i3 = i2;
            } else {
                return;
            }
        }
        if (JniUtil.myIsUseHardwareAccelerate(canvas)) {
            if (this.mNativeClass != 0) {
                JniUtil.myCallDrawGLFunction(canvas, nativeGetDrawGLFunction(this.mNativeClass, this.mGLViewportEmpty ? null : this.mGLRectViewport, this.mGLViewportEmpty ? null : this.mViewRectViewport, getScale(), i3));
                if (this.mHardwareAccelSkia != getSettings().getHardwareAccelSkiaEnabled()) {
                    this.mHardwareAccelSkia = getSettings().getHardwareAccelSkiaEnabled();
                    nativeUseHardwareAccelSkia(this.mHardwareAccelSkia);
                }
                if (this.mSelectingText) {
                    drawTextSelectionHandles(canvas);
                }
            } else {
                return;
            }
        }
        if (this.mFocusSizeChanged) {
            this.mFocusSizeChanged = false;
            if (!z2 && inEditingMode()) {
                didUpdateTextViewBounds(true);
            }
        }
    }

    private void drawMagnifierCircle(Canvas canvas, int i, int i2) {
        if (this.mMagnifierMode) {
            if (!this.mUseGL) {
                nativeDrawCircle(i, i2);
                return;
            }
            Paint paint = new Paint();
            paint.setColor(Color.argb(128, 180, 208, 249));
            canvas.drawCircle(i, i2, 7.0f, paint);
        }
    }

    private void sendSubjectOnClickIndex(int i) {
        this.mSubjectClickIndex = i;
        mLastSubjectClickIndex = i;
    }

    public int getLastSubjectClickIndex() {
        return mLastSubjectClickIndex;
    }

    public boolean isNeedSubjectRingInitial(int i) {
        if (mSubjectRingScale.size() == i && getViewWidth() == mScreenViewWidth && getViewHeight() == mScreenViewHeight) {
            return false;
        }
        initialSubjectRingScale();
        return true;
    }

    public void checkSubjectRing(int i, int i2) {
        if (i < mSmallestWidth || i2 < mSmallestHeight) {
            mSubjectRingScale.add(Float.valueOf(0.1f));
            return;
        }
        float viewWidth = ((int) (getViewWidth() * 0.8d)) / i;
        float viewHeight = ((int) (getViewHeight() * 0.8d)) / i2;
        if (viewWidth > viewHeight) {
            if (viewWidth < this.mMinZoomScale) {
                viewWidth = this.mMinZoomScale;
            }
            mSubjectRingScale.add(Float.valueOf(viewWidth));
            return;
        }
        mSubjectRingScale.add(Float.valueOf(viewHeight < this.mMinZoomScale ? this.mMinZoomScale : viewHeight));
    }

    public boolean isCanDrawSubjectRing(int i, int i2) {
        if (mSubjectRingScale.size() != i2) {
            mSubjectRingScale.clear();
            setSubjectRingDrawScale(i2);
        }
        return getCurrentScale() - ((Float) mSubjectRingScale.get(i)).floatValue() <= 0.01f;
    }

    public void initialSubjectRingScale() {
        mScreenViewWidth = getViewWidth();
        mScreenViewHeight = getViewHeight();
        mSubjectRingScale.clear();
        int i = (int) (mScreenViewWidth * 0.1d);
        int i2 = (int) (mScreenViewHeight * 0.1d);
        if (this.mMinZoomScale > 0.01f) {
            mSmallestWidth = (int) (i / this.mMinZoomScale);
            mSmallestHeight = (int) (i2 / this.mMinZoomScale);
            return;
        }
        mSmallestWidth = 1;
        mSmallestHeight = 1;
    }

    private void setSubjectRingDrawScale(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            Rect subjectRect = getSubjectRect(i2);
            checkSubjectRing(subjectRect.width(), subjectRect.height());
        }
    }

    public void setUnderSubject(boolean z) {
        this.mIsUnderSubject = z;
    }

    public boolean isUnderSubject() {
        return this.mIsUnderSubject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sendSubjectOnClick(String str, String str2, String str3) {
        if (isZeusPluginFullScreenMode()) {
            return false;
        }
        if (this.mUnderSubject) {
            this.mUnderSubject = false;
            onDraw(mCanvas);
        }
        return this.mCallbackProxy.sendSubjectOnClick(str, str2, str3);
    }

    public void initialSubjectRects() {
        if (this.mSubjectRects == null) {
            this.mSubjectRects = new ArrayList();
        }
        this.mSubjectRects.clear();
        if (this.mSubjectClickRects == null) {
            this.mSubjectClickRects = new ArrayList();
        }
        this.mSubjectClickRects.clear();
        if (this.mSubjectViewRects == null) {
            this.mSubjectViewRects = new ArrayList();
        }
        this.mSubjectViewRects.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubjectRectsFromWebCore(ArrayList arrayList) {
        if (this.mSubjectRects == null) {
            this.mSubjectRects = new ArrayList();
        }
        if (this.mSubjectClickRects == null) {
            this.mSubjectClickRects = new ArrayList();
        }
        if (this.mSubjectViewRects == null) {
            this.mSubjectViewRects = new ArrayList();
        }
        if (arrayList != null) {
            if (arrayList.size() != getSubjectCount()) {
                this.mSubjectRects.clear();
                this.mSubjectClickRects.clear();
                this.mSubjectViewRects.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Rect rect = (Rect) it.next();
                    this.mSubjectRects.add(new Rect(rect));
                    this.mSubjectViewRects.add(new Rect(rect));
                    this.mSubjectClickRects.add(new Rect(rect));
                }
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < getSubjectCount()) {
                    getSubjectRect(i2).set((Rect) arrayList.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private int getSubjectCount() {
        return this.mSubjectRects.size();
    }

    private Rect getSubjectRect(int i) {
        return (Rect) this.mSubjectRects.get(i);
    }

    private Rect getSubjectClickRect(int i) {
        return (Rect) this.mSubjectClickRects.get(i);
    }

    private Rect getSubjectViewRect(int i) {
        return (Rect) this.mSubjectViewRects.get(i);
    }

    private void drawSubjectTapShadow(Canvas canvas, Rect rect, boolean z, int i) {
        setupPaintDrawShadow(z, i);
        canvas.drawRect(rect, this.mSubjectPaint);
    }

    private void setupPaintDrawRing() {
        this.mSubjectPaint.setStyle(Paint.Style.STROKE);
        this.mSubjectPaint.setStrokeWidth(MAX_SLOPE_FOR_DIAG);
        this.mSubjectPaint.setColor(SUBJECT_RING_COLOR);
    }

    private void setupPaintDrawShadow(boolean z, int i) {
        this.mSubjectPaint.setStyle(Paint.Style.FILL);
        if (z) {
            this.mSubjectPaint.setColor(SUBJECT_SHADLE_COLOR);
        } else if (this.mTapOnSubject && i == this.mSubjectClickIndex) {
            this.mSubjectPaint.setColor(SUBJECT_SHADOW_COLOR_CLICK);
        } else if (!getSettings().nightModeEnabled()) {
            this.mSubjectPaint.setColor(SUBJECT_SHADOW_COLOR_NORMAL);
        } else {
            this.mSubjectPaint.setColor(SUBJECT_RING_COLOR);
        }
    }

    private void drawSubjectRing(Canvas canvas, Rect rect) {
        setupPaintDrawRing();
        int i = this.mScrollX;
        int i2 = this.mScrollY;
        int viewWidth = this.mScrollX + getViewWidth();
        int viewHeight = this.mScrollY + getViewHeight();
        if (rect.left < viewWidth && i < rect.right && i2 < rect.bottom && rect.top < viewHeight) {
            int max = Math.max(i, rect.left);
            int max2 = Math.max(i2, rect.top);
            int min = Math.min(viewWidth, rect.right);
            int min2 = Math.min(viewHeight, rect.bottom);
            if (max != i || max == 0) {
                canvas.drawLine(max, max2, max, min2, this.mSubjectPaint);
            }
            if (max2 != i2 || i2 == 0) {
                canvas.drawLine(max, max2, min, max2, this.mSubjectPaint);
            }
            if (min != viewWidth || computeMaxScrollX() == i) {
                canvas.drawLine(min, max2, min, min2, this.mSubjectPaint);
            }
            if (min2 != viewHeight || computeMaxScrollY() == i2) {
                canvas.drawLine(max, min2, min, min2, this.mSubjectPaint);
            }
        }
    }

    private void drawSubjectClickBitmap(Canvas canvas, Rect rect) {
        this.mSubjectPaint.setFilterBitmap(true);
        canvas.drawBitmap(mSubjectClickBmp, mSubjectClickBmpRect, rect, this.mSubjectPaint);
    }

    private void drawSubjectThing(Canvas canvas, Rect rect, int i) {
        drawSubjectRing(canvas, rect);
        Rect subjectClickRect = getSubjectClickRect(i);
        subjectClickRect.set(rect.right - SUBJECT_WIDTH_ADJUST, rect.top, rect.right, rect.top + SUBJECT_WIDTH_ADJUST);
        if (this.mTapOnSubject && i == this.mSubjectClickIndex) {
            if (!getSettings().nightModeEnabled()) {
                this.mSubjectPaint.setColor(SUBJECT_RING_COLOR_CLICK_DAY);
            } else {
                this.mSubjectPaint.setColor(SUBJECT_RING_COLOR_CLICK_NIGHT);
            }
            drawSubjectClickBitmap(canvas, subjectClickRect);
            return;
        }
        this.mSubjectPaint.setColor(SUBJECT_RING_COLOR);
        drawSubjectClickBitmap(canvas, subjectClickRect);
    }

    private void onSubjectRingDrawed(int i) {
        boolean markSubjectEnabled;
        if (this.mCallbackProxy != null && (markSubjectEnabled = getSettings().markSubjectEnabled())) {
            this.mCallbackProxy.onSubjectsCollected(markSubjectEnabled, i);
        }
    }

    private int tapOnSubjectIndex(int i, int i2) {
        int subjectCount = getSubjectCount();
        for (int i3 = 0; i3 < subjectCount; i3++) {
            if (isCanDrawSubjectRing(i3, subjectCount)) {
                Rect subjectClickRect = getSubjectClickRect(i3);
                int viewToContentX = viewToContentX(subjectClickRect.left);
                int viewToContentY = viewToContentY(subjectClickRect.top);
                int viewToContentDimension = viewToContentDimension(subjectClickRect.width());
                int viewToContentDimension2 = viewToContentDimension(subjectClickRect.height());
                if (i >= viewToContentX && i <= viewToContentX + viewToContentDimension && i2 >= viewToContentY && i2 <= viewToContentDimension2 + viewToContentY) {
                    return i3;
                }
            }
        }
        return -1;
    }

    private boolean checkDrawSubjectNeeds() {
        boolean z;
        if (this.mSubjectPaint == null) {
            this.mSubjectPaint = new Paint();
        }
        if (mSubjectRingScale == null) {
            mSubjectRingScale = new ArrayList();
        }
        if (this.mSubjectRects == null) {
            this.mSubjectRects = new ArrayList();
            z = true;
        } else {
            z = false;
        }
        if (this.mSubjectViewRects == null) {
            this.mSubjectViewRects = new ArrayList();
            z = true;
        }
        if (this.mSubjectClickRects == null) {
            this.mSubjectClickRects = new ArrayList();
            z = true;
        }
        if (z) {
            this.mSubjectRects.clear();
            this.mSubjectViewRects.clear();
            this.mSubjectClickRects.clear();
            return false;
        }
        if (mSubjectClickDrawableId == 0 && getContext() != null) {
            mSubjectClickDrawableId = getContext().getResources().getIdentifier("zeus_subject", "drawable", getContext().getPackageName());
        }
        if (mSubjectClickBmp == null) {
            if (mSubjectClickDrawableId == 0) {
                return false;
            }
            mSubjectClickBmp = BitmapFactory.decodeResource(getResources(), mSubjectClickDrawableId);
            if (mSubjectClickBmp == null) {
                return false;
            }
            mSubjectClickBmpRect = new Rect(0, 0, mSubjectClickBmp.getWidth(), mSubjectClickBmp.getHeight());
        }
        return true;
    }

    private void checkAndDrawSubject(Canvas canvas) {
        int subjectCount;
        if (!isZeusPluginFullScreenMode() && this.mScrollingLayer == 0 && !isMobileSite() && getSettings() != null && getSettings().markSubjectEnabled() && checkDrawSubjectNeeds() && (subjectCount = getSubjectCount()) > 0) {
            for (int i = 0; i < subjectCount; i++) {
                Rect subjectRect = getSubjectRect(i);
                if (i == 0) {
                    if (isNeedSubjectRingInitial(subjectCount)) {
                        setSubjectRingDrawScale(subjectCount);
                        lastRectHeight = subjectRect.height();
                    } else if (lastRectHeight != subjectRect.height()) {
                        isNeedSubjectRingInitial(0);
                        setSubjectRingDrawScale(subjectCount);
                        lastRectHeight = subjectRect.height();
                    }
                }
                if (isCanDrawSubjectRing(i, subjectCount)) {
                    Rect subjectViewRect = getSubjectViewRect(i);
                    subjectViewRect.set(contentToViewX(subjectRect.left), contentToViewY(subjectRect.top), contentToViewX(subjectRect.right), contentToViewY(subjectRect.bottom));
                    drawSubjectThing(canvas, subjectViewRect, i);
                    notifyCient = true;
                    if (notifyCient) {
                        onSubjectRingDrawed(subjectCount);
                        notifyCient = false;
                    }
                }
            }
        }
    }

    private void drawTextSelectionHandles(Canvas canvas) {
        int i = -1;
        if (this.mTextSelectionPaint == null) {
            this.mTextSelectionPaint = new Paint();
            this.mTextSelectionPaint.setColor(HIGHLIGHT_COLOR);
        }
        this.mTextSelectionRegion.setEmpty();
        Region region = new Region(nativeGetSelection());
        Rect rect = new Rect();
        RegionIterator regionIterator = new RegionIterator(region);
        int i2 = -1;
        int i3 = -1;
        Rect rect2 = rect;
        int i4 = -1;
        while (regionIterator.next(rect2)) {
            Rect rect3 = new Rect(contentToViewDimension(rect2.left), contentToViewDimension(rect2.top), contentToViewDimension(rect2.right), contentToViewDimension(rect2.bottom));
            if (i3 < 0 || i2 < 0) {
                i3 = rect3.left;
                i2 = rect3.top;
            }
            i4 = rect3.right;
            i = rect3.bottom;
            canvas.drawRect(rect3, this.mTextSelectionPaint);
            rect2 = rect3;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Path path = new Path();
        path.moveTo(i3, i2);
        path.lineTo((i3 - 8) + 1, i2 - 8);
        path.lineTo((i3 - 8) + 1, (i2 - 35) + 1);
        path.lineTo((i3 + 8) - 1, (i2 - 35) + 1);
        path.lineTo((i3 + 8) - 1, i2 - 8);
        path.close();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-791751204);
        canvas.drawPath(path, paint);
        Path path2 = new Path();
        path2.moveTo(i3, i2);
        path2.lineTo(i3 - 8, i2 - 8);
        path2.lineTo(i3 - 8, i2 - 35);
        path2.lineTo(i3 + 8, i2 - 35);
        path2.lineTo(i3 + 8, i2 - 8);
        path2.close();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(-1879048192);
        paint.setStrokeWidth(2);
        canvas.drawPath(path2, paint);
        Path path3 = new Path();
        path3.moveTo(i4, i);
        path3.lineTo((i4 - 8) + 1, i + 8);
        path3.lineTo((i4 - 8) + 1, (i + 35) - 1);
        path3.lineTo((i4 + 8) - 1, (i + 35) - 1);
        path3.lineTo((i4 + 8) - 1, i + 8);
        path3.close();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-791751204);
        canvas.drawPath(path3, paint);
        Path path4 = new Path();
        path4.moveTo(i4, i);
        path4.lineTo(i4 - 8, i + 8);
        path4.lineTo(i4 - 8, i + 35);
        path4.lineTo(i4 + 8, 35 + i);
        path4.lineTo(i4 + 8, i + 8);
        path4.close();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(-1879048192);
        paint.setStrokeWidth(2);
        canvas.drawPath(path4, paint);
    }

    public void drawExtrasExternal(Canvas canvas, boolean z, boolean z2) {
        if (this.mNativeClass != 0) {
            int i = 0;
            if (this.mFindIsUp) {
                i = 1;
            } else if (this.mSelectingText) {
                i = 2;
                nativeSetSelectionPointer(this.mDrawSelectionPointer, this.mInvActualScale, this.mSelectX, this.mSelectY - getTitleHeight());
            } else if (z) {
                i = 3;
            }
            drawExtras(canvas, i, z2);
            if (i == 3 && this.mTouchMode == 4) {
                this.mTouchMode = 5;
            }
        }
    }

    boolean drawHistory() {
        return this.mDrawHistory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void switchOutDrawHistory() {
        if (this.mWebViewCore != null && this.mDrawHistory && this.mWebViewCore.pictureReady()) {
            this.mDrawHistory = false;
            this.mHistoryPicture = null;
            invalidate();
            int i = this.mScrollX;
            int i2 = this.mScrollY;
            this.mScrollX = pinLocX(this.mScrollX);
            this.mScrollY = pinLocY(this.mScrollY);
            if (i != this.mScrollX || i2 != this.mScrollY) {
                this.mUserScroll = false;
                this.mWebViewCore.sendMessage(FOCUSED_INPUT_BOUNDS_CHANGED, i, i2);
                onScrollChanged(this.mScrollX, this.mScrollY, i, i2);
                return;
            }
            sendOurVisibleRect();
        }
    }

    WebViewCore.CursorData cursorData() {
        WebViewCore.CursorData cursorData = new WebViewCore.CursorData();
        cursorData.mMoveGeneration = nativeMoveGeneration();
        cursorData.mFrame = nativeCursorFramePointer();
        Point nativeCursorPosition = nativeCursorPosition();
        cursorData.mX = nativeCursorPosition.x;
        cursorData.mY = nativeCursorPosition.y;
        return cursorData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void deleteSelection(int i, int i2) {
        this.mTextGeneration++;
        this.mWebViewCore.sendMessage(DOM_FOCUS_CHANGED, this.mTextGeneration, 0, new WebViewCore.TextSelectionData(i, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSelection(int i, int i2) {
        this.mWebViewCore.sendMessage(SHOW_RECT_MSG_ID, i, i2);
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        editorInfo.imeOptions |= Integer.MIN_VALUE;
        return onCreateInputConnection;
    }

    public void setRebuildWebTextView(boolean z) {
        this.mRebuildWebTextView = z;
    }

    public void setOwnEditOn(boolean z) {
        this.mOwnEditOn = z;
    }

    public boolean isOwnEditOn() {
        return this.mOwnEditOn;
    }

    public int getCurrentScaleState() {
        float currentScale = getCurrentScale();
        if (currentScale < 0.7f) {
            return 1;
        }
        if (currentScale >= 0.7f && currentScale <= this.mDefaultScale) {
            return 2;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ifNeedStorePageScale() {
        return getSettings().useScaleStore() && isMobileSite();
    }

    private boolean zoomWhenEditing() {
        this.mInZoomOverview = false;
        this.mZoomCenterX = this.mLastTouchX;
        this.mZoomCenterY = this.mLastTouchY;
        getCurrentScale();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void displaySoftKeyboard(boolean z) {
        displaySoftKeyboardInternal(z, false, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void displaySoftKeyboard(boolean z, Rect rect, String str) {
        displaySoftKeyboardInternal(z, true, rect, str);
    }

    private void displaySoftKeyboardInternal(boolean z, boolean z2, Rect rect, String str) {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        boolean z3 = this.mActualScale < this.mDefaultScale;
        zoomWhenEditing();
        if (z) {
            this.mDisplaySoftKeyboard = true;
            if (!z2) {
                rebuildWebTextView();
            } else {
                rebuildWebTextView(rect, str);
            }
            this.mDisplaySoftKeyboard = false;
            if (inEditingMode()) {
                if (!this.mShowOwnEdit || this.mEtText.getParent() == null) {
                    inputMethodManager.showSoftInput(this.mWebTextView, 0);
                } else {
                    inputMethodManager.showSoftInput(this.mEtText, 0);
                }
                if (z3) {
                    didUpdateTextViewBounds(true);
                    return;
                }
                return;
            }
        }
        inputMethodManager.focusIn(this);
        inputMethodManager.showSoftInput(this, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideSoftKeyboard() {
        InputMethodManager peekInstance = InputMethodManager.peekInstance();
        if (peekInstance != null) {
            if (peekInstance.isActive(this) || (inEditingMode() && peekInstance.isActive(this.mWebTextView))) {
                peekInstance.hideSoftInputFromWindow(getWindowToken(), 0);
            }
        }
    }

    public Rect calculateTextViewBox(Rect rect, String str) {
        float f = 1.0f;
        Rect rect2 = new Rect(rect);
        float currentScale = getCurrentScale();
        int currentScaleState = getCurrentScaleState();
        getClass();
        if (currentScaleState == 1) {
            f = 1.0f / currentScale;
        } else {
            int currentScaleState2 = getCurrentScaleState();
            getClass();
            if (currentScaleState2 == 2) {
                f = ((56.25f + (0.625f * (currentScale * 100.0f))) / 100.0f) / currentScale;
            }
        }
        if (this.mWebTextView != null) {
            this.mWebTextView.setTextSize(0, contentToViewDimension(nativeFocusCandidateTextSize()) * f);
        }
        rect2.inset(0, (-(((int) ((f + 0.1f) * rect.height())) - rect.height())) / 2);
        return rect2;
    }

    private int getVirtualSoftKeyboardHt() {
        return (getViewHeight() * 11) / 20;
    }

    public void restoreContentHeight() {
        if (this.mContentHeightChanged) {
            recordNewContentSize(this.mContentWidth, this.mContentHeight - this.mContentHeightAdded, false);
            pinScrollTo(this.mScrollX, this.mScrollY, false, 0);
            invalidate();
            this.mContentHeightChanged = false;
        }
    }

    public void rebuildWebTextView() {
        rebuildWebTextViewInternal(false, null, null);
    }

    public void rebuildWebTextView(Rect rect, String str) {
        rebuildWebTextViewInternal(true, rect, str);
    }

    private void scrollTextFieldWhenDisplayKeyBoard(Rect rect, Rect rect2) {
        if (this.mDisplaySoftKeyboard || this.mRebuildWebTextView) {
            int virtualSoftKeyboardHt = getVirtualSoftKeyboardHt();
            int viewHeight = rect.top - (((getViewHeight() - virtualSoftKeyboardHt) - rect.height()) / 2);
            if (viewHeight < 0) {
                viewHeight = 0;
            }
            int i = this.mScrollX;
            if (rect2.bottom + viewToContentDimension(virtualSoftKeyboardHt) > this.mContentHeight) {
                this.mContentHeightAdded = viewToContentDimension(virtualSoftKeyboardHt);
                recordNewContentSize(this.mContentWidth, this.mContentHeight + this.mContentHeightAdded, false);
                this.mContentHeightChanged = true;
            }
            pinScrollTo(i, viewHeight, true, 0);
        }
    }

    private void rebuildWebTextViewInternal(boolean z, Rect rect, String str) {
        String nativeFocusCandidateText;
        if (this.mDisplaySoftKeyboard) {
            WebViewCore.reducePriority();
        }
        if (hasFocus() || (this.mWebTextView != null && this.mWebTextView.hasFocus())) {
            boolean inEditingMode = inEditingMode();
            if (this.mNativeClass == 0 || !nativeFocusCandidateIsTextInput()) {
                if (inEditingMode) {
                    this.mWebTextView.remove();
                }
                if (nativeFocusCandidateIsContentEditable()) {
                    if (!z || rect == null) {
                        rect = nativeFocusCandidateNodeBounds(this.mDisplaySoftKeyboard || this.mFocusedInputBoundsChanged);
                    }
                    scrollTextFieldWhenDisplayKeyBoard(contentToViewRect(rect), rect);
                    return;
                }
                return;
            }
            if (this.mWebTextView == null) {
                try {
                    this.mWebTextView = (WebTextView) LayoutInflater.from(this.mContext).inflate(this.mContext.getResources().getIdentifier("zeus_webtextview", "layout", this.mContext.getPackageName()), (ViewGroup) null);
                    if (this.mWebTextView != null) {
                        this.mWebTextView.setWebView(this);
                    }
                } catch (Exception e) {
                    Log.e(LOGTAG, "rebuild text view using layout inflater exception! " + e);
                    this.mWebTextView = new WebTextView(this.mContext, this);
                }
                this.mTextGeneration = 0;
            }
            this.mWebTextView.setTextSize(0, contentToViewDimension(nativeFocusCandidateTextSize()));
            Rect rect2 = new Rect();
            calcOurContentVisibleRect(rect2);
            if (!z || rect == null) {
                rect = nativeFocusCandidateNodeBounds(this.mDisplaySoftKeyboard || this.mFocusedInputBoundsChanged);
            }
            Rect contentToViewRect = contentToViewRect(rect);
            scrollTextFieldWhenDisplayKeyBoard(contentToViewRect, rect);
            if (!z || str == null) {
                nativeFocusCandidateText = nativeFocusCandidateText(this.mDisplaySoftKeyboard || this.mFocusedInputBoundsChanged);
            } else {
                nativeFocusCandidateText = str;
            }
            int nativeFocusCandidatePointer = nativeFocusCandidatePointer();
            setNeedTextDeleteBtn(false);
            if (nativeFocusCandidateText != null && nativeFocusCandidateText.length() > 0) {
                setNeedTextDeleteBtn(true);
            }
            if (this.mDisplaySoftKeyboard || this.mFocusedInputBoundsChanged) {
                this.mWebTextView.setRect(contentToViewRect.left, contentToViewRect.top, contentToViewRect.width(), contentToViewRect.height(), nativeFocusCandidateText);
            }
            if (!Rect.intersects(rect, rect2)) {
                this.mWebTextView.bringIntoView();
            }
            if (inEditingMode && this.mWebTextView.isSameTextField(nativeFocusCandidatePointer)) {
                if (nativeFocusCandidateText != null && !nativeFocusCandidateText.equals(this.mWebTextView.getText().toString()) && nativeTextGeneration() == this.mTextGeneration) {
                    this.mWebTextView.setTextAndKeepSelection(nativeFocusCandidateText);
                }
            } else {
                this.mWebTextView.setGravity(nativeFocusCandidateIsRtlText() ? 5 : 0);
                this.mWebTextView.setNodePointer(nativeFocusCandidatePointer);
                this.mWebTextView.setType(nativeFocusCandidateType());
                if (nativeFocusCandidateText == null) {
                    nativeFocusCandidateText = "";
                }
                this.mWebTextView.setTextAndKeepSelection(nativeFocusCandidateText);
                InputMethodManager peekInstance = InputMethodManager.peekInstance();
                if (peekInstance != null && peekInstance.isActive(this.mWebTextView)) {
                    peekInstance.restartInput(this.mWebTextView);
                }
            }
            if (this.mDisplaySoftKeyboard) {
                this.mWebTextView.requestFocus();
                setOwnEditOn(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestFormData(String str, int i) {
        if (this.mWebViewCore.getSettings().getSaveFormData()) {
            Message obtainMessage = this.mPrivateHandler.obtainMessage(6);
            obtainMessage.arg1 = i;
            new Thread(new RequestFormData(str, getUrl(), obtainMessage)).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestLabel(int i, int i2) {
        this.mWebViewCore.sendMessage(97, i, i2);
    }

    /* loaded from: classes.dex */
    class RequestFormData implements Runnable {
        private String mName;
        private Message mUpdateMessage;
        private String mUrl;

        public RequestFormData(String str, String str2, Message message) {
            this.mName = str;
            this.mUrl = str2;
            this.mUpdateMessage = message;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList formData = WebView.this.mDatabase.getFormData(this.mUrl, this.mName);
            if (formData.size() > 0) {
                this.mUpdateMessage.obj = new WebTextView.AutoCompleteAdapter(WebView.this.mContext, formData);
                this.mUpdateMessage.sendToTarget();
            }
        }
    }

    public void dumpDisplayTree() {
        nativeDumpDisplayTree(getUrl());
    }

    public void dumpDomTree(boolean z) {
        this.mWebViewCore.sendMessage(170, z ? 1 : 0, 0);
    }

    public void dumpRenderTree(boolean z) {
        this.mWebViewCore.sendMessage(171, z ? 1 : 0, 0);
    }

    public void useMockDeviceOrientation() {
        this.mWebViewCore.sendMessage(191);
    }

    public void setMockDeviceOrientation(boolean z, double d, boolean z2, double d2, boolean z3, double d3) {
        this.mWebViewCore.setMockDeviceOrientation(z, d, z2, d2, z3, d3);
    }

    public void dumpV8Counters() {
        this.mWebViewCore.sendMessage(173);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        if (i != 0 || keyEvent.getCharacters() == null) {
            return false;
        }
        this.mWebViewCore.sendMessage(103, keyEvent);
        this.mWebViewCore.sendMessage(104, keyEvent);
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int i2;
        int i3 = 0;
        r3 = false;
        boolean z = false;
        if (this.mNativeClass == 0) {
            return false;
        }
        if (keyEvent.isSystem() || this.mCallbackProxy.uiOverrideKeyEvent(keyEvent)) {
            return false;
        }
        if (i == 59 || i == 60) {
            if (nativeFocusIsPlugin()) {
                this.mShiftIsPressed = true;
            } else if (!nativeCursorWantsKeyEvents() && !this.mSelectingText) {
                setUpSelect();
            }
        }
        if (i >= 19 && i <= 22) {
            switchOutDrawHistory();
            if (nativeFocusIsPlugin()) {
                letPluginHandleNavKey(i, keyEvent.getEventTime(), true);
                return true;
            } else if (this.mSelectingText) {
                if (i == 21) {
                    i2 = -1;
                } else {
                    i2 = i == 22 ? 1 : 0;
                }
                if (i == 19) {
                    i3 = -1;
                } else if (i == 20) {
                    i3 = 1;
                }
                int repeatCount = keyEvent.getRepeatCount() + 1;
                moveSelection(i2 * repeatCount, repeatCount * i3);
                return true;
            } else if (navHandledKey(i, 1, false, keyEvent.getEventTime())) {
                playSoundEffect(keyCodeToSoundsEffect(i));
                return true;
            } else {
                return false;
            }
        } else if (i == 23) {
            switchOutDrawHistory();
            if (keyEvent.getRepeatCount() == 0) {
                if (this.mSelectingText) {
                    return true;
                }
                this.mGotCenterDown = true;
                this.mPrivateHandler.sendMessageDelayed(this.mPrivateHandler.obtainMessage(LONG_PRESS_CENTER), 1000L);
                if (hasFocus() && hasWindowFocus()) {
                    z = true;
                }
                nativeRecordButtons(z, true, true);
                return true;
            }
            return false;
        } else {
            if (i != 59 && i != 60) {
                selectionDone();
                this.mShiftIsPressed = false;
            }
            if (getSettings().getNavDump()) {
                switch (i) {
                    case 11:
                        dumpDisplayTree();
                        break;
                    case 12:
                    case 13:
                        dumpDomTree(i == 12);
                        break;
                    case 14:
                    case 15:
                        dumpRenderTree(i == 14);
                        break;
                    case 16:
                        nativeInstrumentReport();
                        return true;
                }
            }
            if (nativeCursorIsTextInput()) {
                if (!isOwnEditOn()) {
                    return true;
                }
                this.mWebViewCore.sendMessage(REQUEST_KEYBOARD, nativeCursorFramePointer(), nativeCursorNodePointer());
                rebuildWebTextView();
                if (inEditingMode()) {
                    this.mWebTextView.setDefaultSelection();
                    return this.mWebTextView.dispatchKeyEvent(keyEvent);
                }
            } else if (nativeHasFocusNode()) {
                rebuildWebTextView();
                if (inEditingMode()) {
                    this.mWebTextView.setDefaultSelection();
                    return this.mWebTextView.dispatchKeyEvent(keyEvent);
                }
            }
            if (!nativeCursorWantsKeyEvents()) {
            }
            this.mWebViewCore.sendMessage(103, keyEvent);
            return true;
        }
    }

    public void pageVisibilityChange(int i, boolean z) {
        if (this.mWebViewCore != null) {
            this.mWebViewCore.sendMessage(BdWebErrorView.ERROR_CODE_501, i, z ? 1 : 0);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.mNativeClass == 0) {
            return false;
        }
        if (i == 5 && nativeHasCursorNode()) {
            String nativeCursorText = nativeCursorText();
            if (!nativeCursorIsTextInput() && nativeCursorText != null && nativeCursorText.startsWith("tel:")) {
                getContext().startActivity(new Intent("android.intent.action.DIAL", Uri.parse(nativeCursorText)));
                return true;
            }
        }
        if (keyEvent.isSystem() || this.mCallbackProxy.uiOverrideKeyEvent(keyEvent)) {
            return false;
        }
        if (i == 59 || i == 60) {
            if (nativeFocusIsPlugin()) {
                this.mShiftIsPressed = false;
            } else if (copySelection()) {
                selectionDone();
                return true;
            }
        }
        if (i >= 19 && i <= 22) {
            if (nativeFocusIsPlugin()) {
                letPluginHandleNavKey(i, keyEvent.getEventTime(), false);
                return true;
            }
            return false;
        } else if (i == 23) {
            this.mPrivateHandler.removeMessages(LONG_PRESS_CENTER);
            this.mGotCenterDown = false;
            if (this.mSelectingText) {
                if (this.mExtendSelection) {
                    copySelection();
                    selectionDone();
                } else {
                    this.mExtendSelection = true;
                    nativeSetExtendSelection();
                    invalidate();
                }
                return true;
            } else if (nativeCursorIntersects(sendOurVisibleRect())) {
                WebViewCore.CursorData cursorData = cursorData();
                this.mWebViewCore.sendMessage(ZEUS_QUICK_CLICK, cursorData);
                playSoundEffect(0);
                if (nativeCursorIsTextInput()) {
                    rebuildWebTextView();
                    centerKeyPressOnTextField();
                    if (inEditingMode()) {
                        this.mWebTextView.setDefaultSelection();
                    }
                    return true;
                }
                clearTextEntry(true);
                nativeSetFollowedLink(true);
                if (!this.mCallbackProxy.uiOverrideUrlLoading(nativeCursorText())) {
                    this.mWebViewCore.sendMessage(REQUEST_KEYBOARD, cursorData.mFrame, nativeCursorNodePointer());
                }
                return true;
            } else {
                return false;
            }
        } else {
            if (!nativeCursorWantsKeyEvents()) {
            }
            this.mWebViewCore.sendMessage(104, keyEvent);
            return true;
        }
    }

    public void setUpSelect() {
        if (enableSelectText() && this.mNativeClass != 0 && !inFullScreenMode() && !this.mSelectingText) {
            this.mExtendSelection = false;
            this.mDrawSelectionPointer = true;
            this.mSelectingText = true;
            WebViewCore.pauseUpdatePicture(this.mWebViewCore);
            nativeResetSelection();
            if (nativeHasCursorNode()) {
                Rect nativeCursorNodeBounds = nativeCursorNodeBounds();
                this.mSelectX = contentToViewX(nativeCursorNodeBounds.left);
                this.mSelectY = contentToViewY(nativeCursorNodeBounds.top);
            } else if (this.mLastTouchY > getVisibleTitleHeight()) {
                this.mSelectX = this.mScrollX + ((int) this.mLastTouchX);
                this.mSelectY = this.mScrollY + ((int) this.mLastTouchY);
            } else {
                this.mSelectX = this.mScrollX + (getViewWidth() / 2);
                this.mSelectY = this.mScrollY + (getViewHeightWithTitle() / 2);
            }
            nativeHideCursor();
        }
    }

    public void emulateShiftHeld() {
        this.mIsShiftPressed = true;
        setUpSelect();
    }

    public void emulateShiftHeldOnLink() {
        emulateShiftHeld();
        int viewToContentX = viewToContentX(((int) this.mLastTouchX) + this.mScrollX);
        int viewToContentY = viewToContentY(((int) this.mLastTouchY) + this.mScrollY);
        if (this.mNativeClass == 0 || nativeWordSelection(viewToContentX, viewToContentY)) {
        }
    }

    public void selectAll() {
        if (this.mNativeClass != 0 && !inFullScreenMode()) {
            if (!this.mSelectingText) {
                setUpSelect();
            }
            nativeSelectAll();
            this.mDrawSelectionPointer = false;
            this.mExtendSelection = true;
            invalidate();
        }
    }

    public boolean selectDialogIsUp() {
        return this.mSelectingText;
    }

    public void notifySelectDialogDismissed() {
        this.mSelectingText = false;
        this.mShowSelectionActionDialog = false;
        this.mIsShiftPressed = false;
        WebViewCore.resumeUpdatePicture(this.mWebViewCore);
    }

    public void selectionDone() {
        if (this.mSelectingText) {
            hideMagnifier((int) this.mLastTouchX, (int) this.mLastTouchY);
            WebViewCore.resumeUpdatePicture(this.mWebViewCore);
            this.mMagnifierMode = false;
            getWebChromeClient();
            hideSelectionActionDialogPrivate();
            notifySelectDialogDismissed();
            setContentChangeState(3);
            this.mSentAutoScrollMessage = false;
            invalidate();
        }
    }

    public boolean copySelection() {
        boolean z = true;
        this.mCopyingSth = true;
        Region region = new Region(nativeGetSelection());
        if (region.isEmpty()) {
            z = false;
        } else {
            this.mWebViewCore.sendMessage(BdWebErrorView.ERROR_CODE_403, region);
        }
        invalidate();
        selectionDone();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void copySelectionPrivate(String str) {
        if (str != null && str != "" && getWebChromeClient() != null) {
            getWebChromeClient().copyText(this, str);
        }
    }

    public Region getSelection() {
        if (this.mNativeClass == 0) {
            return null;
        }
        return nativeGetSelection();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (hasWindowFocus()) {
            setActive(true);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (this.mGlobalLayoutListener == null) {
            this.mGlobalLayoutListener = new InnerGlobalLayoutListener();
            viewTreeObserver.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
        }
        if (this.mScrollChangedListener == null) {
            this.mScrollChangedListener = new InnerScrollChangedListener();
            viewTreeObserver.addOnScrollChangedListener(this.mScrollChangedListener);
        }
        this.mTouchEventQueue.reset();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        clearHelpers();
        dismissZoomControl();
        if (hasWindowFocus()) {
            setActive(false);
        }
        super.onDetachedFromWindow();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (this.mGlobalLayoutListener != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        if (this.mScrollChangedListener != null) {
            viewTreeObserver.removeOnScrollChangedListener(this.mScrollChangedListener);
            this.mScrollChangedListener = null;
        }
    }

    private void destroyPluginView() {
        if (this.mWebViewCore != null) {
            this.mWebViewCore.sendMessage(300, (Object) null);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    @Deprecated
    public void onChildViewAdded(View view, View view2) {
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    @Deprecated
    public void onChildViewRemoved(View view, View view2) {
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    @Deprecated
    public void onGlobalFocusChanged(View view, View view2) {
    }

    private void setActive(boolean z) {
        if (z) {
            if (hasFocus()) {
                this.mDrawCursorRing = true;
                setFocusControllerActive(true);
                if (this.mNativeClass != 0) {
                    nativeRecordButtons(true, false, true);
                    if (inEditingMode()) {
                        this.mWebViewCore.sendMessage(SEND_ON_SUBJECT_CLICK, 1, 0);
                    }
                }
            } else {
                this.mDrawCursorRing = false;
            }
        } else {
            if (this.mWebViewCore != null && getSettings() != null && getSettings().getBuiltInZoomControls() && (this.mZoomButtonsController == null || !this.mZoomButtonsController.isVisible())) {
                this.mDrawCursorRing = false;
            }
            this.mKeysPressed.clear();
            this.mShiftIsPressed = false;
            this.mPrivateHandler.removeMessages(4);
            cancelLongPressDelay();
            this.mTouchMode = 7;
            if (this.mNativeClass != 0) {
                nativeRecordButtons(false, false, true);
            }
            setFocusControllerInactive();
        }
        invalidate();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        setActive(z);
        if (z) {
            BrowserFrame.sJavaBridge.setActiveWebView(this);
        } else {
            BrowserFrame.sJavaBridge.removeActiveWebView(this);
        }
        super.onWindowFocusChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFocusControllerInactive() {
        if (this.mNativeClass != 0) {
            this.mWebViewCore.sendMessage(SEND_ON_SUBJECT_CLICK, 0, 0);
        }
    }

    void clearCoreFocus() {
        if (this.mNativeClass != 0) {
            this.mWebViewCore.sendMessage(187, 0, 0);
        }
    }

    void setFocusControllerActive(boolean z) {
        if (this.mWebViewCore != null) {
            this.mWebViewCore.sendMessage(SEND_ON_SUBJECT_CLICK, z ? 1 : 0, 0);
        }
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            if (hasWindowFocus()) {
                this.mDrawCursorRing = true;
                if (this.mNativeClass != 0) {
                    nativeRecordButtons(true, false, true);
                }
                setFocusControllerActive(true);
            }
        } else {
            if (!inEditingMode()) {
                this.mDrawCursorRing = false;
                if (this.mNativeClass != 0) {
                    nativeRecordButtons(false, false, true);
                }
                setFocusControllerInactive();
            } else if (this.mShowOwnEdit) {
            }
            this.mKeysPressed.clear();
        }
        super.onFocusChanged(z, i, rect);
    }

    protected boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (!frame && this.mHeightCanMeasure) {
            sendViewSizeZoom();
        }
        return frame;
    }

    /* loaded from: classes.dex */
    class PostScale implements Runnable {
        final boolean mUpdateTextWrap;
        final WebView mWebView;

        public PostScale(WebView webView, boolean z) {
            this.mWebView = webView;
            this.mUpdateTextWrap = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mWebView.mWebViewCore != null) {
                this.mWebView.setNewZoomScale(this.mWebView.mActualScale, this.mUpdateTextWrap, true);
                if (this.mWebView.getSettings().getBuiltInZoomControls()) {
                    this.mWebView.updateZoomButtonsEnabled();
                }
            }
        }
    }

    void setGLRectViewport() {
        if (getGlobalVisibleRect(this.mGLRectViewport)) {
            int height = getRootView().getHeight();
            this.mViewRectViewport.set(this.mGLRectViewport);
            int i = this.mGLRectViewport.bottom;
            this.mGLRectViewport.bottom = (height - this.mGLRectViewport.top) - getVisibleTitleHeightImpl();
            this.mGLRectViewport.top = height - i;
            this.mGLViewportEmpty = false;
        } else {
            this.mGLViewportEmpty = true;
        }
        nativeUpdateDrawGLFunction(this.mGLViewportEmpty ? null : this.mGLRectViewport, this.mGLViewportEmpty ? null : this.mViewRectViewport);
    }

    private int getVisibleTitleHeightImpl() {
        return Math.max(getTitleHeight() - Math.max(0, this.mScrollY), 0);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mTouchMode = 7;
        selectionDone();
        dismissListBox();
        if (i != i3 && isOwnEditOn()) {
            clearTextEntry(false);
        }
        if (this.mZoomScale == 0.0f) {
            this.mZoomCenterX = 0.0f;
            this.mZoomCenterY = getVisibleTitleHeight();
            this.mAnchorX = viewToContentX(((int) this.mZoomCenterX) + this.mScrollX);
            this.mAnchorY = viewToContentY(((int) this.mZoomCenterY) + this.mScrollY);
        }
        int max = (int) (Math.max(i, i2) / DEFAULT_MIN_ZOOM_SCALE);
        if (max > sMaxViewportWidth) {
            sMaxViewportWidth = max;
        }
        if (!this.mMinZoomScaleFixed) {
            this.mMinZoomScale = Math.min(1.0f, getViewWidth() / (this.mDrawHistory ? this.mHistoryPicture.getWidth() : this.mZoomOverviewWidth));
            if (this.mInitialScaleInPercent > 0) {
                float f = this.mInitialScaleInPercent / 100.0f;
                if (this.mMinZoomScale > f) {
                    this.mMinZoomScale = f;
                }
            }
        }
        dismissZoomControl();
        post(new PostScale(this, i != i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        this.mScrollState = ScrollState.Scrolling;
        super.onScrollChanged(i, i2, i3, i4);
        if (!this.mInOverScrollMode) {
            sendOurVisibleRect();
            int titleHeight = getTitleHeight();
            if (Math.max(titleHeight - i2, 0) != Math.max(titleHeight - i4, 0)) {
                sendViewSizeZoom();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        switch (keyEvent.getAction()) {
            case 0:
                this.mKeysPressed.add(Integer.valueOf(keyEvent.getKeyCode()));
                break;
            case 1:
                int indexOf = this.mKeysPressed.indexOf(Integer.valueOf(keyEvent.getKeyCode()));
                if (indexOf == -1) {
                    return false;
                }
                this.mKeysPressed.remove(indexOf);
                break;
        }
        if (inEditingMode() && this.mWebTextView.isFocused()) {
            return this.mWebTextView.dispatchKeyEvent(keyEvent);
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    private static int sign(float f) {
        if (f > 0.0f) {
            return 1;
        }
        return f < 0.0f ? -1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class DragTrackerHandler {
        private static final int ANIMATING_STATE = 1;
        private static final int DRAGGING_STATE = 0;
        private static final int FINISHED_STATE = 2;
        private float mCurrStretchX;
        private float mCurrStretchY;
        private Interpolator mInterp;
        private final float mMaxDX;
        private final float mMaxDY;
        private final float mMinDX;
        private final float mMinDY;
        private final DragTracker mProxy;
        private int mSX;
        private int mSY;
        private final float mStartX;
        private final float mStartY;
        private int mState;
        private float[] mXY = new float[2];

        public DragTrackerHandler(float f, float f2, DragTracker dragTracker) {
            this.mProxy = dragTracker;
            int computeRealVerticalScrollRange = WebView.this.computeRealVerticalScrollRange() + WebView.this.getTitleHeight();
            int scrollY = WebView.this.getScrollY();
            int height = WebView.this.getHeight() + scrollY;
            this.mStartY = f2;
            this.mMinDY = -scrollY;
            this.mMaxDY = computeRealVerticalScrollRange - height;
            int computeRealHorizontalScrollRange = WebView.this.computeRealHorizontalScrollRange();
            int scrollX = WebView.this.getScrollX();
            int width = WebView.this.getWidth() + scrollX;
            this.mStartX = f;
            this.mMinDX = -scrollX;
            this.mMaxDX = computeRealHorizontalScrollRange - width;
            this.mState = 0;
            this.mProxy.onStartDrag(f, f2);
            this.mSX = -99999;
        }

        private float computeStretch(float f, float f2, float f3) {
            if (f3 - f2 <= 4.0f) {
                return 0.0f;
            }
            if (f < f2) {
                return f - f2;
            }
            if (f <= f3) {
                return 0.0f;
            }
            return f - f3;
        }

        public void dragTo(float f, float f2) {
            float f3 = 0.0f;
            float computeStretch = computeStretch(this.mStartY - f2, this.mMinDY, this.mMaxDY);
            float computeStretch2 = computeStretch(this.mStartX - f, this.mMinDX, this.mMaxDX);
            if ((WebView.this.mSnapScrollMode & 2) == 0) {
                if ((WebView.this.mSnapScrollMode & 4) != 0) {
                    computeStretch2 = 0.0f;
                    f3 = computeStretch;
                } else {
                    f3 = computeStretch;
                }
            }
            if (this.mCurrStretchX != computeStretch2 || this.mCurrStretchY != f3) {
                this.mCurrStretchX = computeStretch2;
                this.mCurrStretchY = f3;
                if (this.mProxy.onStretchChange(computeStretch2, f3)) {
                    WebView.this.invalidate();
                }
            }
        }

        public void stopDrag() {
            int uptimeMillis = (int) SystemClock.uptimeMillis();
            this.mInterp = new Interpolator(2);
            this.mXY[0] = this.mCurrStretchX;
            this.mXY[1] = this.mCurrStretchY;
            this.mInterp.setKeyFrame(0, uptimeMillis, this.mXY, new float[]{0.0f, 0.5f, 0.75f, 1.0f});
            this.mInterp.setKeyFrame(1, uptimeMillis + BdWebPoolView.DELAYED_TIME, new float[]{0.0f, 0.0f}, null);
            this.mState = 1;
        }

        public boolean isFinished() {
            return this.mState == 2;
        }

        private int hiddenHeightOfTitleBar() {
            return WebView.this.getTitleHeight() - WebView.this.getVisibleTitleHeight();
        }

        private Bitmap.Config offscreenBitmapConfig() {
            return Bitmap.Config.RGB_565;
        }

        public boolean draw(Canvas canvas) {
            if (this.mCurrStretchX == 0.0f && this.mCurrStretchY == 0.0f) {
                return false;
            }
            int scrollX = WebView.this.getScrollX();
            int scrollY = WebView.this.getScrollY() - hiddenHeightOfTitleBar();
            if (this.mSX != scrollX || this.mSY != scrollY) {
                buildBitmap(scrollX, scrollY);
                this.mSX = scrollX;
                this.mSY = scrollY;
            }
            if (this.mState == 1) {
                if (this.mInterp.timeToValues(this.mXY) == Interpolator.Result.FREEZE_END) {
                    this.mState = 2;
                    return false;
                }
                this.mProxy.onStretchChange(this.mXY[0], this.mXY[1]);
                WebView.this.invalidate();
            }
            int save = canvas.save(1);
            canvas.translate(scrollX, scrollY);
            this.mProxy.onDraw(canvas);
            canvas.restoreToCount(save);
            return true;
        }

        private void buildBitmap(int i, int i2) {
            Bitmap createBitmap = Bitmap.createBitmap(WebView.this.getWidth(), WebView.this.getViewHeight(), offscreenBitmapConfig());
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate(-i, -i2);
            WebView.this.drawContent(canvas);
            this.mProxy.onBitmapChange(createBitmap);
        }
    }

    /* loaded from: classes.dex */
    public class DragTracker {
        public void onStartDrag(float f, float f2) {
        }

        public boolean onStretchChange(float f, float f2) {
            return false;
        }

        public void onStopDrag() {
        }

        public void onBitmapChange(Bitmap bitmap) {
        }

        public void onDraw(Canvas canvas) {
        }
    }

    public DragTracker getDragTracker() {
        return this.mDragTracker;
    }

    public void setDragTracker(DragTracker dragTracker) {
        this.mDragTracker = dragTracker;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ScaleDetectorListener implements ScaleGestureDetector.OnScaleGestureListener {
        private ScaleDetectorListener() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            WebView.this.setBeginScale();
            WebView.this.mMultiScaling = true;
            WebView.this.mBeginScaleSpan = scaleGestureDetector.getCurrentSpan();
            WebView.this.cancelTouch();
            WebView.this.dismissEditor();
            WebView.this.dismissZoomControl();
            WebView.this.dismissListBox();
            if (!WebKitInit.isVersionCanUseGL()) {
                WebView.this.mViewManager.hideAll();
            }
            WebView.this.mCurrentScale = WebView.this.mActualScale;
            WebView.this.mMultiScalingFirstTime = true;
            WebView.this.mLastScale = WebView.this.mActualScale;
            WebView.this.mViewManager.startZoom();
            WebViewCore.pauseUpdatePicture(WebView.this.mWebViewCore);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            WebView.this.setContentChangeState(0);
            if (!WebKitInit.isVersionCanUseGL()) {
                WebView.this.mViewManager.showAll();
            }
            if (WebView.this.mZoomFlag == 1 || WebView.this.mPreviewZoomOnly) {
                WebView.this.mPreviewZoomOnly = false;
                WebView.this.mAnchorX = WebView.this.viewToContentX(((int) WebView.this.mZoomCenterX) + WebView.this.mScrollX);
                WebView.this.mAnchorY = WebView.this.viewToContentY(((int) WebView.this.mZoomCenterY) + WebView.this.mScrollY);
                boolean z = WebView.this.mCurrentScale - WebView.this.mMinZoomScale <= WebView.MINIMUM_SCALE_INCREMENT || ((double) WebView.this.mCurrentScale) <= 0.8d * ((double) WebView.this.mTextWrapScale);
                if (WebView.this.ifNeedStorePageScale()) {
                    WebView.mZeusScaleStore.put(WebView.this.getUrl(), WebView.this.mCurrentScale);
                }
                WebView.this.setNewZoomScale(WebView.this.mCurrentScale, z, true);
                WebView.this.invalidate();
            }
            if (WebView.this.inEditingMode() && WebView.this.didUpdateTextViewBounds(false) && WebView.this.nativeFocusCandidateIsPassword()) {
                WebView.this.mWebTextView.setInPassword(true);
            }
            WebView.this.mTouchMode = 8;
            WebView.this.mConfirmMove = true;
            WebView.this.startTouch(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), WebView.this.mLastTouchTime);
            WebView.this.mViewManager.endZoom();
            WebView.this.mZoomFlag = 0;
            WebView.this.mMultiScaling = false;
            WebView.this.mCaptureFlag = false;
            WebView.this.mMultiZoomScaleFlag = false;
            WebView.this.captureScalePic();
            WebView.this.mZoomWhenScrolling = false;
            WebViewCore.resumeUpdatePicture(WebView.this.mWebViewCore);
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (WebView.this.mUnderSubject) {
                WebView.this.mUnderSubject = false;
                WebView.this.onDraw(WebView.mCanvas);
            }
            if (WebView.this.ifWapAllowScale()) {
                float round = (float) (Math.round((scaleGestureDetector.getScaleFactor() * WebView.this.mCurrentScale) * 100.0f) / 100.0d);
                if (round > WebView.fakeMaxZoomScale) {
                    round = WebView.fakeMaxZoomScale;
                } else if (round < WebView.this.mMinZoomScale) {
                    round = WebView.this.mMinZoomScale;
                }
                if (round < WebView.this.mActualScale) {
                    WebView.this.mZoomOutFlag = true;
                } else {
                    WebView.this.mZoomOutFlag = false;
                }
                if (Math.abs(round - WebView.this.mActualScale) >= WebView.MINIMUM_SCALE_INCREMENT) {
                    WebView.this.mPreviewZoomOnly = true;
                    WebView.this.mZoomFlag = 1;
                    WebView.this.mMultiZoomScaleFlag = true;
                    if (WebView.this.mMultiScalingFirstTime) {
                        WebView.this.mZoomCenterX = scaleGestureDetector.getFocusX();
                        WebView.this.mZoomCenterY = scaleGestureDetector.getFocusY();
                        WebView.this.mMultiScalingFirstTime = false;
                    }
                    WebView.this.mCurrentScale = round;
                    WebView.this.mCurrentMultiScale = scaleGestureDetector.getScaleFactor();
                    WebView.this.invalidate();
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    private boolean hitFocusedPlugin(int i, int i2) {
        return nativeFocusIsPlugin() && nativeFocusNodeBounds().contains(i, i2);
    }

    private boolean shouldForwardTouchEvent() {
        if (this.mFullScreenHolder != null) {
            return true;
        }
        if (this.mBlockWebkitViewMessages) {
            return false;
        }
        return (!this.mForwardTouchEvents || this.mSelectingText || this.mPreventDefault == 4 || this.mPreventDefault == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean inFullScreenMode() {
        return this.mFullScreenHolder != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissFullScreenMode() {
        if (inFullScreenMode()) {
            this.mFullScreenHolder.dismiss();
            this.mFullScreenHolder = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startScrollingLayer(float f, float f2) {
        this.mScrollingLayer = nativeScrollableLayer(viewToContentX(((int) f) + this.mScrollX), viewToContentY(((int) f2) + this.mScrollY), this.mScrollingLayerRect, this.mScrollingLayerBounds);
        if (this.mScrollingLayer != 0) {
            this.mTouchMode = 9;
        }
        this.mStartScrollPosX = this.mScrollingLayerRect.left;
        this.mStartScrollPosY = this.mScrollingLayerRect.top;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSelectionActionDialogPrivate(String str) {
        if (this.mSelectingText && !this.mShowSelectionActionDialog) {
            int contentToViewDimension = contentToViewDimension(nativeSelectionTop()) - this.mScrollY;
            int contentToViewDimension2 = contentToViewDimension(nativeSelectionBottom()) - this.mScrollY;
            int contentToViewDimension3 = contentToViewDimension(nativeSelectionLeft()) - this.mScrollX;
            int contentToViewDimension4 = contentToViewDimension(nativeSelectionRight()) - this.mScrollX;
            if (getWebChromeClient() != null) {
                getWebChromeClient().ShowSelectionActionDialog(this, contentToViewDimension, contentToViewDimension2, contentToViewDimension3, contentToViewDimension4, str);
            }
            this.mShowSelectionActionDialog = true;
        }
    }

    private void hideSelectionActionDialogPrivate() {
        if (this.mShowSelectionActionDialog) {
            if (getWebChromeClient() != null) {
                getWebChromeClient().HideSelectionActionDialog(this);
            }
            this.mShowSelectionActionDialog = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:303:0x079d, code lost:
        if (r5 < (-r19.mMinLockSnapReverseDistance)) goto L289;
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x0806, code lost:
        if (r4 < (-r19.mMinLockSnapReverseDistance)) goto L304;
     */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0727 A[Catch: IllegalArgumentException -> 0x023f, TryCatch #0 {IllegalArgumentException -> 0x023f, blocks: (B:18:0x0039, B:20:0x0043, B:22:0x0049, B:24:0x0050, B:26:0x0056, B:28:0x0062, B:30:0x0075, B:33:0x0081, B:34:0x0094, B:36:0x00ad, B:37:0x00b2, B:39:0x00bd, B:40:0x00c5, B:42:0x00d0, B:43:0x00d8, B:44:0x00fe, B:58:0x0132, B:60:0x015c, B:62:0x0162, B:65:0x016b, B:66:0x0178, B:68:0x0182, B:69:0x019b, B:71:0x01a2, B:132:0x03b9, B:134:0x03c4, B:73:0x01a9, B:75:0x01b9, B:76:0x01c3, B:78:0x01c9, B:125:0x0382, B:127:0x0388, B:81:0x01d4, B:83:0x01da, B:85:0x0228, B:129:0x0396, B:131:0x03a5, B:128:0x038f, B:80:0x01cf, B:89:0x024a, B:91:0x0255, B:93:0x0263, B:95:0x026e, B:96:0x0275, B:98:0x0283, B:100:0x0289, B:101:0x028f, B:103:0x0297, B:105:0x02a7, B:107:0x02ad, B:108:0x02b3, B:110:0x02ca, B:112:0x02fe, B:113:0x0306, B:115:0x030a, B:117:0x0316, B:118:0x0333, B:120:0x0339, B:122:0x0352, B:123:0x037a, B:140:0x03e7, B:142:0x03ed, B:144:0x03f3, B:145:0x0403, B:147:0x040b, B:148:0x0411, B:150:0x0417, B:152:0x0428, B:153:0x042b, B:155:0x0431, B:165:0x047c, B:167:0x0483, B:173:0x049a, B:175:0x04ba, B:176:0x04bf, B:178:0x04c5, B:181:0x04cd, B:183:0x04de, B:185:0x0549, B:187:0x055a, B:189:0x0560, B:190:0x0578, B:192:0x057f, B:194:0x0586, B:196:0x058c, B:198:0x0592, B:199:0x0595, B:201:0x059b, B:203:0x05a1, B:205:0x05ce, B:207:0x05d4, B:208:0x05d7, B:210:0x05dd, B:221:0x0616, B:228:0x0628, B:212:0x05e3, B:219:0x05fd, B:229:0x0636, B:231:0x063d, B:233:0x0645, B:235:0x064b, B:237:0x0652, B:240:0x065f, B:242:0x0665, B:244:0x066f, B:246:0x0680, B:249:0x0688, B:280:0x0741, B:282:0x074a, B:285:0x0752, B:250:0x068c, B:252:0x0692, B:239:0x0659, B:253:0x06ab, B:255:0x06b1, B:256:0x06b8, B:258:0x06e1, B:264:0x06f1, B:266:0x06fd, B:268:0x0707, B:269:0x0711, B:271:0x0718, B:273:0x0720, B:275:0x0727, B:276:0x072f, B:287:0x075a, B:289:0x0761, B:305:0x07a9, B:307:0x07af, B:310:0x07b9, B:313:0x07bf, B:315:0x07c5, B:316:0x07c9, B:317:0x07ce, B:337:0x081c, B:291:0x0768, B:293:0x0777, B:297:0x0784, B:298:0x0789, B:300:0x0792, B:302:0x0798, B:304:0x079f, B:318:0x07d9, B:321:0x07e0, B:325:0x07ed, B:326:0x07f2, B:328:0x07fb, B:330:0x0801, B:332:0x0808, B:333:0x0813, B:261:0x06e9, B:263:0x06ed, B:220:0x060b, B:169:0x0489, B:171:0x048f, B:139:0x03db, B:158:0x0444, B:161:0x0457, B:164:0x046a, B:339:0x0829, B:341:0x0831, B:342:0x0837, B:344:0x0843, B:345:0x0848, B:347:0x084e, B:349:0x0854, B:350:0x0862, B:352:0x0868, B:355:0x0875, B:357:0x087b, B:358:0x0880, B:360:0x0886, B:362:0x089a, B:364:0x08a2, B:366:0x08ab, B:369:0x08b5, B:371:0x08c2, B:372:0x08db, B:374:0x08e1, B:376:0x0933, B:377:0x0937, B:378:0x0940, B:380:0x094a, B:382:0x0950, B:383:0x095d, B:384:0x0961, B:385:0x0964, B:386:0x0969, B:388:0x0982, B:394:0x09e7, B:396:0x09ee, B:390:0x0988, B:392:0x09d8, B:393:0x09dc, B:397:0x09f8, B:399:0x0a11, B:401:0x0a18, B:403:0x0a1e, B:405:0x0a24, B:414:0x0a92, B:415:0x0a97, B:417:0x0a9d, B:419:0x0aa5, B:420:0x0aa8, B:421:0x0aad, B:424:0x0ac1, B:426:0x0ac8, B:429:0x0ad0, B:430:0x0adc, B:432:0x0ae2, B:434:0x0ae8, B:435:0x0af0, B:406:0x0a34, B:408:0x0a4c, B:410:0x0a58, B:412:0x0a5e, B:413:0x0a88, B:436:0x0af4, B:437:0x0afe, B:438:0x0b06, B:354:0x086e, B:439:0x0b17, B:441:0x0b1e, B:442:0x0b21, B:48:0x0107, B:57:0x0124), top: B:448:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x073b  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0777 A[Catch: IllegalArgumentException -> 0x023f, TryCatch #0 {IllegalArgumentException -> 0x023f, blocks: (B:18:0x0039, B:20:0x0043, B:22:0x0049, B:24:0x0050, B:26:0x0056, B:28:0x0062, B:30:0x0075, B:33:0x0081, B:34:0x0094, B:36:0x00ad, B:37:0x00b2, B:39:0x00bd, B:40:0x00c5, B:42:0x00d0, B:43:0x00d8, B:44:0x00fe, B:58:0x0132, B:60:0x015c, B:62:0x0162, B:65:0x016b, B:66:0x0178, B:68:0x0182, B:69:0x019b, B:71:0x01a2, B:132:0x03b9, B:134:0x03c4, B:73:0x01a9, B:75:0x01b9, B:76:0x01c3, B:78:0x01c9, B:125:0x0382, B:127:0x0388, B:81:0x01d4, B:83:0x01da, B:85:0x0228, B:129:0x0396, B:131:0x03a5, B:128:0x038f, B:80:0x01cf, B:89:0x024a, B:91:0x0255, B:93:0x0263, B:95:0x026e, B:96:0x0275, B:98:0x0283, B:100:0x0289, B:101:0x028f, B:103:0x0297, B:105:0x02a7, B:107:0x02ad, B:108:0x02b3, B:110:0x02ca, B:112:0x02fe, B:113:0x0306, B:115:0x030a, B:117:0x0316, B:118:0x0333, B:120:0x0339, B:122:0x0352, B:123:0x037a, B:140:0x03e7, B:142:0x03ed, B:144:0x03f3, B:145:0x0403, B:147:0x040b, B:148:0x0411, B:150:0x0417, B:152:0x0428, B:153:0x042b, B:155:0x0431, B:165:0x047c, B:167:0x0483, B:173:0x049a, B:175:0x04ba, B:176:0x04bf, B:178:0x04c5, B:181:0x04cd, B:183:0x04de, B:185:0x0549, B:187:0x055a, B:189:0x0560, B:190:0x0578, B:192:0x057f, B:194:0x0586, B:196:0x058c, B:198:0x0592, B:199:0x0595, B:201:0x059b, B:203:0x05a1, B:205:0x05ce, B:207:0x05d4, B:208:0x05d7, B:210:0x05dd, B:221:0x0616, B:228:0x0628, B:212:0x05e3, B:219:0x05fd, B:229:0x0636, B:231:0x063d, B:233:0x0645, B:235:0x064b, B:237:0x0652, B:240:0x065f, B:242:0x0665, B:244:0x066f, B:246:0x0680, B:249:0x0688, B:280:0x0741, B:282:0x074a, B:285:0x0752, B:250:0x068c, B:252:0x0692, B:239:0x0659, B:253:0x06ab, B:255:0x06b1, B:256:0x06b8, B:258:0x06e1, B:264:0x06f1, B:266:0x06fd, B:268:0x0707, B:269:0x0711, B:271:0x0718, B:273:0x0720, B:275:0x0727, B:276:0x072f, B:287:0x075a, B:289:0x0761, B:305:0x07a9, B:307:0x07af, B:310:0x07b9, B:313:0x07bf, B:315:0x07c5, B:316:0x07c9, B:317:0x07ce, B:337:0x081c, B:291:0x0768, B:293:0x0777, B:297:0x0784, B:298:0x0789, B:300:0x0792, B:302:0x0798, B:304:0x079f, B:318:0x07d9, B:321:0x07e0, B:325:0x07ed, B:326:0x07f2, B:328:0x07fb, B:330:0x0801, B:332:0x0808, B:333:0x0813, B:261:0x06e9, B:263:0x06ed, B:220:0x060b, B:169:0x0489, B:171:0x048f, B:139:0x03db, B:158:0x0444, B:161:0x0457, B:164:0x046a, B:339:0x0829, B:341:0x0831, B:342:0x0837, B:344:0x0843, B:345:0x0848, B:347:0x084e, B:349:0x0854, B:350:0x0862, B:352:0x0868, B:355:0x0875, B:357:0x087b, B:358:0x0880, B:360:0x0886, B:362:0x089a, B:364:0x08a2, B:366:0x08ab, B:369:0x08b5, B:371:0x08c2, B:372:0x08db, B:374:0x08e1, B:376:0x0933, B:377:0x0937, B:378:0x0940, B:380:0x094a, B:382:0x0950, B:383:0x095d, B:384:0x0961, B:385:0x0964, B:386:0x0969, B:388:0x0982, B:394:0x09e7, B:396:0x09ee, B:390:0x0988, B:392:0x09d8, B:393:0x09dc, B:397:0x09f8, B:399:0x0a11, B:401:0x0a18, B:403:0x0a1e, B:405:0x0a24, B:414:0x0a92, B:415:0x0a97, B:417:0x0a9d, B:419:0x0aa5, B:420:0x0aa8, B:421:0x0aad, B:424:0x0ac1, B:426:0x0ac8, B:429:0x0ad0, B:430:0x0adc, B:432:0x0ae2, B:434:0x0ae8, B:435:0x0af0, B:406:0x0a34, B:408:0x0a4c, B:410:0x0a58, B:412:0x0a5e, B:413:0x0a88, B:436:0x0af4, B:437:0x0afe, B:438:0x0b06, B:354:0x086e, B:439:0x0b17, B:441:0x0b1e, B:442:0x0b21, B:48:0x0107, B:57:0x0124), top: B:448:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x07af A[Catch: IllegalArgumentException -> 0x023f, TryCatch #0 {IllegalArgumentException -> 0x023f, blocks: (B:18:0x0039, B:20:0x0043, B:22:0x0049, B:24:0x0050, B:26:0x0056, B:28:0x0062, B:30:0x0075, B:33:0x0081, B:34:0x0094, B:36:0x00ad, B:37:0x00b2, B:39:0x00bd, B:40:0x00c5, B:42:0x00d0, B:43:0x00d8, B:44:0x00fe, B:58:0x0132, B:60:0x015c, B:62:0x0162, B:65:0x016b, B:66:0x0178, B:68:0x0182, B:69:0x019b, B:71:0x01a2, B:132:0x03b9, B:134:0x03c4, B:73:0x01a9, B:75:0x01b9, B:76:0x01c3, B:78:0x01c9, B:125:0x0382, B:127:0x0388, B:81:0x01d4, B:83:0x01da, B:85:0x0228, B:129:0x0396, B:131:0x03a5, B:128:0x038f, B:80:0x01cf, B:89:0x024a, B:91:0x0255, B:93:0x0263, B:95:0x026e, B:96:0x0275, B:98:0x0283, B:100:0x0289, B:101:0x028f, B:103:0x0297, B:105:0x02a7, B:107:0x02ad, B:108:0x02b3, B:110:0x02ca, B:112:0x02fe, B:113:0x0306, B:115:0x030a, B:117:0x0316, B:118:0x0333, B:120:0x0339, B:122:0x0352, B:123:0x037a, B:140:0x03e7, B:142:0x03ed, B:144:0x03f3, B:145:0x0403, B:147:0x040b, B:148:0x0411, B:150:0x0417, B:152:0x0428, B:153:0x042b, B:155:0x0431, B:165:0x047c, B:167:0x0483, B:173:0x049a, B:175:0x04ba, B:176:0x04bf, B:178:0x04c5, B:181:0x04cd, B:183:0x04de, B:185:0x0549, B:187:0x055a, B:189:0x0560, B:190:0x0578, B:192:0x057f, B:194:0x0586, B:196:0x058c, B:198:0x0592, B:199:0x0595, B:201:0x059b, B:203:0x05a1, B:205:0x05ce, B:207:0x05d4, B:208:0x05d7, B:210:0x05dd, B:221:0x0616, B:228:0x0628, B:212:0x05e3, B:219:0x05fd, B:229:0x0636, B:231:0x063d, B:233:0x0645, B:235:0x064b, B:237:0x0652, B:240:0x065f, B:242:0x0665, B:244:0x066f, B:246:0x0680, B:249:0x0688, B:280:0x0741, B:282:0x074a, B:285:0x0752, B:250:0x068c, B:252:0x0692, B:239:0x0659, B:253:0x06ab, B:255:0x06b1, B:256:0x06b8, B:258:0x06e1, B:264:0x06f1, B:266:0x06fd, B:268:0x0707, B:269:0x0711, B:271:0x0718, B:273:0x0720, B:275:0x0727, B:276:0x072f, B:287:0x075a, B:289:0x0761, B:305:0x07a9, B:307:0x07af, B:310:0x07b9, B:313:0x07bf, B:315:0x07c5, B:316:0x07c9, B:317:0x07ce, B:337:0x081c, B:291:0x0768, B:293:0x0777, B:297:0x0784, B:298:0x0789, B:300:0x0792, B:302:0x0798, B:304:0x079f, B:318:0x07d9, B:321:0x07e0, B:325:0x07ed, B:326:0x07f2, B:328:0x07fb, B:330:0x0801, B:332:0x0808, B:333:0x0813, B:261:0x06e9, B:263:0x06ed, B:220:0x060b, B:169:0x0489, B:171:0x048f, B:139:0x03db, B:158:0x0444, B:161:0x0457, B:164:0x046a, B:339:0x0829, B:341:0x0831, B:342:0x0837, B:344:0x0843, B:345:0x0848, B:347:0x084e, B:349:0x0854, B:350:0x0862, B:352:0x0868, B:355:0x0875, B:357:0x087b, B:358:0x0880, B:360:0x0886, B:362:0x089a, B:364:0x08a2, B:366:0x08ab, B:369:0x08b5, B:371:0x08c2, B:372:0x08db, B:374:0x08e1, B:376:0x0933, B:377:0x0937, B:378:0x0940, B:380:0x094a, B:382:0x0950, B:383:0x095d, B:384:0x0961, B:385:0x0964, B:386:0x0969, B:388:0x0982, B:394:0x09e7, B:396:0x09ee, B:390:0x0988, B:392:0x09d8, B:393:0x09dc, B:397:0x09f8, B:399:0x0a11, B:401:0x0a18, B:403:0x0a1e, B:405:0x0a24, B:414:0x0a92, B:415:0x0a97, B:417:0x0a9d, B:419:0x0aa5, B:420:0x0aa8, B:421:0x0aad, B:424:0x0ac1, B:426:0x0ac8, B:429:0x0ad0, B:430:0x0adc, B:432:0x0ae2, B:434:0x0ae8, B:435:0x0af0, B:406:0x0a34, B:408:0x0a4c, B:410:0x0a58, B:412:0x0a5e, B:413:0x0a88, B:436:0x0af4, B:437:0x0afe, B:438:0x0b06, B:354:0x086e, B:439:0x0b17, B:441:0x0b1e, B:442:0x0b21, B:48:0x0107, B:57:0x0124), top: B:448:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x07bd  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x07e0 A[Catch: IllegalArgumentException -> 0x023f, TryCatch #0 {IllegalArgumentException -> 0x023f, blocks: (B:18:0x0039, B:20:0x0043, B:22:0x0049, B:24:0x0050, B:26:0x0056, B:28:0x0062, B:30:0x0075, B:33:0x0081, B:34:0x0094, B:36:0x00ad, B:37:0x00b2, B:39:0x00bd, B:40:0x00c5, B:42:0x00d0, B:43:0x00d8, B:44:0x00fe, B:58:0x0132, B:60:0x015c, B:62:0x0162, B:65:0x016b, B:66:0x0178, B:68:0x0182, B:69:0x019b, B:71:0x01a2, B:132:0x03b9, B:134:0x03c4, B:73:0x01a9, B:75:0x01b9, B:76:0x01c3, B:78:0x01c9, B:125:0x0382, B:127:0x0388, B:81:0x01d4, B:83:0x01da, B:85:0x0228, B:129:0x0396, B:131:0x03a5, B:128:0x038f, B:80:0x01cf, B:89:0x024a, B:91:0x0255, B:93:0x0263, B:95:0x026e, B:96:0x0275, B:98:0x0283, B:100:0x0289, B:101:0x028f, B:103:0x0297, B:105:0x02a7, B:107:0x02ad, B:108:0x02b3, B:110:0x02ca, B:112:0x02fe, B:113:0x0306, B:115:0x030a, B:117:0x0316, B:118:0x0333, B:120:0x0339, B:122:0x0352, B:123:0x037a, B:140:0x03e7, B:142:0x03ed, B:144:0x03f3, B:145:0x0403, B:147:0x040b, B:148:0x0411, B:150:0x0417, B:152:0x0428, B:153:0x042b, B:155:0x0431, B:165:0x047c, B:167:0x0483, B:173:0x049a, B:175:0x04ba, B:176:0x04bf, B:178:0x04c5, B:181:0x04cd, B:183:0x04de, B:185:0x0549, B:187:0x055a, B:189:0x0560, B:190:0x0578, B:192:0x057f, B:194:0x0586, B:196:0x058c, B:198:0x0592, B:199:0x0595, B:201:0x059b, B:203:0x05a1, B:205:0x05ce, B:207:0x05d4, B:208:0x05d7, B:210:0x05dd, B:221:0x0616, B:228:0x0628, B:212:0x05e3, B:219:0x05fd, B:229:0x0636, B:231:0x063d, B:233:0x0645, B:235:0x064b, B:237:0x0652, B:240:0x065f, B:242:0x0665, B:244:0x066f, B:246:0x0680, B:249:0x0688, B:280:0x0741, B:282:0x074a, B:285:0x0752, B:250:0x068c, B:252:0x0692, B:239:0x0659, B:253:0x06ab, B:255:0x06b1, B:256:0x06b8, B:258:0x06e1, B:264:0x06f1, B:266:0x06fd, B:268:0x0707, B:269:0x0711, B:271:0x0718, B:273:0x0720, B:275:0x0727, B:276:0x072f, B:287:0x075a, B:289:0x0761, B:305:0x07a9, B:307:0x07af, B:310:0x07b9, B:313:0x07bf, B:315:0x07c5, B:316:0x07c9, B:317:0x07ce, B:337:0x081c, B:291:0x0768, B:293:0x0777, B:297:0x0784, B:298:0x0789, B:300:0x0792, B:302:0x0798, B:304:0x079f, B:318:0x07d9, B:321:0x07e0, B:325:0x07ed, B:326:0x07f2, B:328:0x07fb, B:330:0x0801, B:332:0x0808, B:333:0x0813, B:261:0x06e9, B:263:0x06ed, B:220:0x060b, B:169:0x0489, B:171:0x048f, B:139:0x03db, B:158:0x0444, B:161:0x0457, B:164:0x046a, B:339:0x0829, B:341:0x0831, B:342:0x0837, B:344:0x0843, B:345:0x0848, B:347:0x084e, B:349:0x0854, B:350:0x0862, B:352:0x0868, B:355:0x0875, B:357:0x087b, B:358:0x0880, B:360:0x0886, B:362:0x089a, B:364:0x08a2, B:366:0x08ab, B:369:0x08b5, B:371:0x08c2, B:372:0x08db, B:374:0x08e1, B:376:0x0933, B:377:0x0937, B:378:0x0940, B:380:0x094a, B:382:0x0950, B:383:0x095d, B:384:0x0961, B:385:0x0964, B:386:0x0969, B:388:0x0982, B:394:0x09e7, B:396:0x09ee, B:390:0x0988, B:392:0x09d8, B:393:0x09dc, B:397:0x09f8, B:399:0x0a11, B:401:0x0a18, B:403:0x0a1e, B:405:0x0a24, B:414:0x0a92, B:415:0x0a97, B:417:0x0a9d, B:419:0x0aa5, B:420:0x0aa8, B:421:0x0aad, B:424:0x0ac1, B:426:0x0ac8, B:429:0x0ad0, B:430:0x0adc, B:432:0x0ae2, B:434:0x0ae8, B:435:0x0af0, B:406:0x0a34, B:408:0x0a4c, B:410:0x0a58, B:412:0x0a5e, B:413:0x0a88, B:436:0x0af4, B:437:0x0afe, B:438:0x0b06, B:354:0x086e, B:439:0x0b17, B:441:0x0b1e, B:442:0x0b21, B:48:0x0107, B:57:0x0124), top: B:448:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x081c A[Catch: IllegalArgumentException -> 0x023f, TryCatch #0 {IllegalArgumentException -> 0x023f, blocks: (B:18:0x0039, B:20:0x0043, B:22:0x0049, B:24:0x0050, B:26:0x0056, B:28:0x0062, B:30:0x0075, B:33:0x0081, B:34:0x0094, B:36:0x00ad, B:37:0x00b2, B:39:0x00bd, B:40:0x00c5, B:42:0x00d0, B:43:0x00d8, B:44:0x00fe, B:58:0x0132, B:60:0x015c, B:62:0x0162, B:65:0x016b, B:66:0x0178, B:68:0x0182, B:69:0x019b, B:71:0x01a2, B:132:0x03b9, B:134:0x03c4, B:73:0x01a9, B:75:0x01b9, B:76:0x01c3, B:78:0x01c9, B:125:0x0382, B:127:0x0388, B:81:0x01d4, B:83:0x01da, B:85:0x0228, B:129:0x0396, B:131:0x03a5, B:128:0x038f, B:80:0x01cf, B:89:0x024a, B:91:0x0255, B:93:0x0263, B:95:0x026e, B:96:0x0275, B:98:0x0283, B:100:0x0289, B:101:0x028f, B:103:0x0297, B:105:0x02a7, B:107:0x02ad, B:108:0x02b3, B:110:0x02ca, B:112:0x02fe, B:113:0x0306, B:115:0x030a, B:117:0x0316, B:118:0x0333, B:120:0x0339, B:122:0x0352, B:123:0x037a, B:140:0x03e7, B:142:0x03ed, B:144:0x03f3, B:145:0x0403, B:147:0x040b, B:148:0x0411, B:150:0x0417, B:152:0x0428, B:153:0x042b, B:155:0x0431, B:165:0x047c, B:167:0x0483, B:173:0x049a, B:175:0x04ba, B:176:0x04bf, B:178:0x04c5, B:181:0x04cd, B:183:0x04de, B:185:0x0549, B:187:0x055a, B:189:0x0560, B:190:0x0578, B:192:0x057f, B:194:0x0586, B:196:0x058c, B:198:0x0592, B:199:0x0595, B:201:0x059b, B:203:0x05a1, B:205:0x05ce, B:207:0x05d4, B:208:0x05d7, B:210:0x05dd, B:221:0x0616, B:228:0x0628, B:212:0x05e3, B:219:0x05fd, B:229:0x0636, B:231:0x063d, B:233:0x0645, B:235:0x064b, B:237:0x0652, B:240:0x065f, B:242:0x0665, B:244:0x066f, B:246:0x0680, B:249:0x0688, B:280:0x0741, B:282:0x074a, B:285:0x0752, B:250:0x068c, B:252:0x0692, B:239:0x0659, B:253:0x06ab, B:255:0x06b1, B:256:0x06b8, B:258:0x06e1, B:264:0x06f1, B:266:0x06fd, B:268:0x0707, B:269:0x0711, B:271:0x0718, B:273:0x0720, B:275:0x0727, B:276:0x072f, B:287:0x075a, B:289:0x0761, B:305:0x07a9, B:307:0x07af, B:310:0x07b9, B:313:0x07bf, B:315:0x07c5, B:316:0x07c9, B:317:0x07ce, B:337:0x081c, B:291:0x0768, B:293:0x0777, B:297:0x0784, B:298:0x0789, B:300:0x0792, B:302:0x0798, B:304:0x079f, B:318:0x07d9, B:321:0x07e0, B:325:0x07ed, B:326:0x07f2, B:328:0x07fb, B:330:0x0801, B:332:0x0808, B:333:0x0813, B:261:0x06e9, B:263:0x06ed, B:220:0x060b, B:169:0x0489, B:171:0x048f, B:139:0x03db, B:158:0x0444, B:161:0x0457, B:164:0x046a, B:339:0x0829, B:341:0x0831, B:342:0x0837, B:344:0x0843, B:345:0x0848, B:347:0x084e, B:349:0x0854, B:350:0x0862, B:352:0x0868, B:355:0x0875, B:357:0x087b, B:358:0x0880, B:360:0x0886, B:362:0x089a, B:364:0x08a2, B:366:0x08ab, B:369:0x08b5, B:371:0x08c2, B:372:0x08db, B:374:0x08e1, B:376:0x0933, B:377:0x0937, B:378:0x0940, B:380:0x094a, B:382:0x0950, B:383:0x095d, B:384:0x0961, B:385:0x0964, B:386:0x0969, B:388:0x0982, B:394:0x09e7, B:396:0x09ee, B:390:0x0988, B:392:0x09d8, B:393:0x09dc, B:397:0x09f8, B:399:0x0a11, B:401:0x0a18, B:403:0x0a1e, B:405:0x0a24, B:414:0x0a92, B:415:0x0a97, B:417:0x0a9d, B:419:0x0aa5, B:420:0x0aa8, B:421:0x0aad, B:424:0x0ac1, B:426:0x0ac8, B:429:0x0ad0, B:430:0x0adc, B:432:0x0ae2, B:434:0x0ae8, B:435:0x0af0, B:406:0x0a34, B:408:0x0a4c, B:410:0x0a58, B:412:0x0a5e, B:413:0x0a88, B:436:0x0af4, B:437:0x0afe, B:438:0x0b06, B:354:0x086e, B:439:0x0b17, B:441:0x0b1e, B:442:0x0b21, B:48:0x0107, B:57:0x0124), top: B:448:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0826  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x;
        float y;
        int i;
        float f;
        float f2;
        boolean z;
        boolean z2;
        if (inAnimateZoom() || this.mWaitingZoom2Block) {
            return true;
        }
        if (this.mUnderSubject) {
            this.mUnderSubject = false;
            onDraw(mCanvas);
        }
        this.mActionDown = false;
        if (this.mNativeClass == 0 || (!isClickable() && !isLongClickable())) {
            return false;
        }
        try {
            long eventTime = motionEvent.getEventTime();
            if (!isZeusPluginFullScreenMode() && this.mSupportMultiTouch && motionEvent.getPointerCount() > 1) {
                if (this.mAllowPanAndScale || this.mMinZoomScale < this.mMaxZoomScale) {
                    this.mScaleDetector.onTouchEvent(motionEvent);
                    if (this.mScaleDetector.isInProgress()) {
                        this.mLastTouchTime = eventTime;
                        if (!this.mAllowPanAndScale) {
                            return true;
                        }
                        this.mPrivateHandler.removeMessages(3);
                        this.mPrivateHandler.removeMessages(4);
                        cancelLongPressDelay();
                    }
                    x = this.mScaleDetector.getFocusX();
                    y = this.mScaleDetector.getFocusY();
                    int action = motionEvent.getAction() & 255;
                    if (action == 5) {
                        cancelTouch();
                        i = 0;
                    } else if (action == 6) {
                        this.mLastTouchX = x;
                        this.mLastTouchY = y;
                        i = action;
                    } else if (action == 2 && (x < 0.0f || y < 0.0f)) {
                        return true;
                    } else {
                        i = action;
                    }
                } else {
                    return true;
                }
            } else {
                int action2 = motionEvent.getAction();
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = action2;
            }
            float viewWidth = x > ((float) (getViewWidth() + (-1))) ? getViewWidth() - 1 : x;
            float viewHeightWithTitle = y > ((float) (getViewHeightWithTitle() + (-1))) ? getViewHeightWithTitle() - 1 : y;
            float f3 = this.mLastTouchX - viewWidth;
            float f4 = this.mLastTouchY - viewHeightWithTitle;
            int i2 = (int) f3;
            int i3 = (int) f4;
            int viewToContentX = viewToContentX(((int) viewWidth) + this.mScrollX);
            int viewToContentY = viewToContentY(((int) viewHeightWithTitle) + this.mScrollY);
            switch (i) {
                case 0:
                    this.mDragState = DragState.DragDown;
                    this.mActionDown = true;
                    this.mLastDownTime = System.currentTimeMillis();
                    setContentChangeState(1);
                    this.mPreventDefault = 0;
                    this.mConfirmMove = false;
                    int i4 = -1;
                    if (!isZeusPluginFullScreenMode() && !isMobileSite()) {
                        i4 = tapOnSubjectIndex(viewToContentX, viewToContentY);
                    }
                    if (i4 != -1) {
                        sendSubjectOnClickIndex(i4);
                        invalidate();
                        this.mTapOnSubject = true;
                    }
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.abortAnimation();
                        this.mTouchMode = 2;
                        this.mConfirmMove = true;
                        this.mPrivateHandler.removeMessages(7);
                    } else if (this.mPrivateHandler.hasMessages(5)) {
                        this.mPrivateHandler.removeMessages(5);
                        if (!isZeusPluginFullScreenMode() && (i2 * i2) + (i3 * i3) < this.mDoubleTapSlopSquare) {
                            this.mTouchMode = 6;
                        } else {
                            doShortPress();
                            this.mTouchMode = 1;
                            this.mDeferTouchProcess = (inFullScreenMode() || !this.mForwardTouchEvents) ? false : hitFocusedPlugin(viewToContentX, viewToContentY);
                        }
                    } else {
                        this.mPreviewZoomOnly = false;
                        this.mTouchMode = 1;
                        this.mDeferTouchProcess = (inFullScreenMode() || !this.mForwardTouchEvents) ? false : hitFocusedPlugin(viewToContentX, viewToContentY);
                        this.mWebViewCore.sendMessage(98);
                        if (getSettings().supportTouchOnly()) {
                            WebViewCore.TouchHighlightData touchHighlightData = new WebViewCore.TouchHighlightData();
                            touchHighlightData.mX = viewToContentX;
                            touchHighlightData.mY = viewToContentY;
                            touchHighlightData.mNativeLayerRect = new Rect();
                            touchHighlightData.mNativeLayer = nativeScrollableLayer(viewToContentX, viewToContentY, touchHighlightData.mNativeLayerRect, null);
                            touchHighlightData.mSlop = viewToContentDimension(this.mNavSlop);
                            this.mTouchHighlightRegion.setEmpty();
                            if (!this.mBlockWebkitViewMessages) {
                                this.mTouchHighlightRequested = System.currentTimeMillis();
                            }
                        }
                        if (mLogEvent && eventTime - this.mLastTouchUpTime < 1000) {
                            EventLog.writeEvent((int) EVENT_LOG_DOUBLE_TAP_DURATION, Long.valueOf(eventTime - this.mLastTouchUpTime), Long.valueOf(eventTime));
                        }
                        if (this.mSelectingText) {
                            this.mDrawSelectionPointer = false;
                            this.mSelectionStarted = nativeStartSelection(viewToContentX, viewToContentY, this.mIsShiftPressed);
                            if (this.mSelectionStarted) {
                                showMagnifier((int) viewWidth, (int) viewHeightWithTitle, contentToViewDimension(nativeSelectionX()) - this.mScrollX, contentToViewDimension(nativeSelectionY()) - this.mScrollY, false);
                            }
                            invalidate();
                        }
                    }
                    if (this.mTouchMode == 1 || this.mTouchMode == 6) {
                        this.mPrivateHandler.sendEmptyMessageDelayed(3, 200L);
                        if (!this.mSelectingText) {
                            this.mPrivateHandler.sendEmptyMessageDelayed(4, 1000L);
                        }
                        if (inFullScreenMode() || this.mDeferTouchProcess) {
                            this.mPreventDefault = 3;
                        } else if (this.mForwardTouchEvents) {
                            this.mPreventDefault = 1;
                        } else {
                            this.mPreventDefault = 0;
                        }
                        if (shouldForwardTouchEvent()) {
                            WebViewCore.TouchEventData touchEventData = new WebViewCore.TouchEventData();
                            touchEventData.mAction = i;
                            touchEventData.mIds = new int[1];
                            touchEventData.mIds[0] = motionEvent.getPointerId(0);
                            touchEventData.mX = viewToContentX;
                            touchEventData.mY = viewToContentY;
                            touchEventData.mViewX = viewWidth;
                            touchEventData.mViewY = viewHeightWithTitle;
                            touchEventData.mMetaState = motionEvent.getMetaState();
                            touchEventData.mReprocess = this.mDeferTouchProcess;
                            touchEventData.mNativeLayer = nativeScrollableLayer(viewToContentX, viewToContentY, touchEventData.mNativeLayerRect, null);
                            touchEventData.mSequence = this.mTouchEventQueue.nextTouchSequence();
                            this.mTouchEventQueue.preQueueTouchEventData(touchEventData);
                            if (this.mDeferTouchProcess) {
                                this.mLastTouchX = viewWidth;
                                this.mLastTouchY = viewHeightWithTitle;
                                touchEventData.mViewX = viewWidth;
                                touchEventData.mViewY = viewHeightWithTitle;
                                this.mWebViewCore.sendMessage(ZEUS_PLUGIN_FULL_SCREEN_EXIT, touchEventData);
                                break;
                            } else {
                                this.mWebViewCore.sendMessage(ZEUS_PLUGIN_FULL_SCREEN_EXIT, touchEventData);
                                if (!inFullScreenMode()) {
                                    this.mPrivateHandler.sendMessageDelayed(this.mPrivateHandler.obtainMessage(10, i, 0), 200L);
                                }
                            }
                        }
                    }
                    startTouch(viewWidth, viewHeightWithTitle, eventTime);
                    if (!this.mTapOnSubject) {
                        this.mPrivateHandler.obtainMessage(ZEUS_QUICK_CLICK, viewToContentX, viewToContentY).sendToTarget();
                        break;
                    }
                    break;
                case 1:
                    if (DragState.Draging == this.mDragState) {
                        this.mDragState = DragState.DragStop;
                    }
                    this.mDragging = false;
                    if (this.mSubjectClickIndex != -1) {
                        this.mSubjectClickIndex = -1;
                    }
                    if (isOwnEditOn() && this.mShowOwnEdit) {
                        clearTextEntry(true);
                        nativeClearCursor();
                        hideSoftKeyboard();
                        break;
                    } else {
                        if (this.magnifierBmp != null || this.mMagnifierOn) {
                            hideMagnifier((int) viewWidth, (int) viewHeightWithTitle);
                        }
                        if (this.mSelectionStarted) {
                            this.mSelectionStarted = false;
                        }
                        if (this.mMagnifierMode) {
                            this.mMagnifierMode = false;
                            nativeSetCachedNodeFocusFromPt(viewToContentX, viewToContentY, 5);
                            invalidate();
                            HitTestResult hitTestResult = getHitTestResult();
                            if (hitTestResult != null) {
                                if (hitTestResult.getType() == 10) {
                                    setUpSelect();
                                    if (this.mNativeClass == 0 || nativeWordSelection(viewToContentX, viewToContentY)) {
                                    }
                                } else {
                                    WebViewCore.resumeUpdatePicture(this.mWebViewCore);
                                    if (getWebChromeClient() != null) {
                                        getWebChromeClient().PerformLongClick(this, hitTestResult.getType(), hitTestResult.getExtra(), hitTestResult.getExtra2(), (int) viewWidth, (int) viewHeightWithTitle);
                                        break;
                                    }
                                }
                            }
                        } else {
                            if (shouldForwardTouchEvent()) {
                                WebViewCore.TouchEventData touchEventData2 = new WebViewCore.TouchEventData();
                                touchEventData2.mIds = new int[1];
                                touchEventData2.mIds[0] = motionEvent.getPointerId(0);
                                touchEventData2.mAction = i;
                                touchEventData2.mX = viewToContentX;
                                touchEventData2.mY = viewToContentY;
                                touchEventData2.mViewX = viewWidth;
                                touchEventData2.mViewY = viewHeightWithTitle;
                                touchEventData2.mMetaState = motionEvent.getMetaState();
                                touchEventData2.mReprocess = this.mDeferTouchProcess;
                                touchEventData2.mNativeLayer = this.mScrollingLayer;
                                touchEventData2.mNativeLayerRect.set(this.mScrollingLayerRect);
                                touchEventData2.mSequence = this.mTouchEventQueue.nextTouchSequence();
                                this.mTouchEventQueue.preQueueTouchEventData(touchEventData2);
                                if (this.mDeferTouchProcess) {
                                    touchEventData2.mViewX = viewWidth;
                                    touchEventData2.mViewY = viewHeightWithTitle;
                                }
                                this.mWebViewCore.sendMessage(ZEUS_PLUGIN_FULL_SCREEN_EXIT, touchEventData2);
                            }
                            this.mLastTouchUpTime = eventTime;
                            if (this.mSelectingText && !this.mShowSelectionActionDialog) {
                                this.mWebViewCore.sendMessage(BdWebErrorView.ERROR_CODE_403, getSelection());
                            }
                            switch (this.mTouchMode) {
                                case 1:
                                case 4:
                                case 5:
                                    this.mPrivateHandler.removeMessages(3);
                                    this.mPrivateHandler.removeMessages(4);
                                    cancelLongPressDelay();
                                    if (this.mConfirmMove) {
                                        if (this.mPreventDefault != 3 && (computeMaxScrollX() > 0 || computeMaxScrollY() > 0)) {
                                            cancelWebCoreTouchEvent(viewToContentX, viewToContentY, true);
                                            WebViewCore.reducePriority();
                                            WebViewCore.pauseUpdatePicture(this.mWebViewCore);
                                        } else {
                                            invalidate();
                                            break;
                                        }
                                    } else if (this.mSelectingText) {
                                        if (nativeHitSelection(viewToContentX, viewToContentY)) {
                                            copySelection();
                                        }
                                        selectionDone();
                                        break;
                                    } else {
                                        boolean z3 = false;
                                        if (nativeCachedHitNodeIsTextInput(viewToContentX, viewToContentY, viewToContentDimension(this.mNavSlop))) {
                                            z3 = true;
                                        }
                                        if (this.mTouchMode == 1 && !this.mTapOnSubject && !z3) {
                                            this.mPrivateHandler.sendEmptyMessageDelayed(5, getDoubleTapDelay());
                                        } else {
                                            doShortPress();
                                        }
                                        if (nativeHasCursorNode() && !nativeCursorIsTextInput()) {
                                            playSoundEffect(0);
                                            break;
                                        }
                                    }
                                    break;
                                case 3:
                                case 9:
                                    this.mPrivateHandler.removeMessages(8);
                                    this.mPrivateHandler.removeMessages(9);
                                    if (!isZeusPluginFullScreenMode()) {
                                        if (eventTime - this.mLastTouchTime <= 250) {
                                            if (this.mVelocityTracker == null) {
                                                Log.e(LOGTAG, "Got null mVelocityTracker when mPreventDefault = " + this.mPreventDefault + " mDeferTouchProcess = " + this.mDeferTouchProcess);
                                            } else {
                                                this.mVelocityTracker.addMovement(motionEvent);
                                            }
                                            this.mHeldMotionless = 3;
                                            doFling();
                                            break;
                                        } else {
                                            this.mHeldMotionless = 2;
                                            invalidate();
                                        }
                                    }
                                    break;
                                case 2:
                                    this.mLastVelocity = 0.0f;
                                    WebViewCore.resumePriority();
                                    WebViewCore.resumeUpdatePicture(this.mWebViewCore);
                                    break;
                                case 6:
                                    this.mPrivateHandler.removeMessages(3);
                                    this.mPrivateHandler.removeMessages(4);
                                    cancelLongPressDelay();
                                    if (inFullScreenMode() || this.mDeferTouchProcess) {
                                        WebViewCore.TouchEventData touchEventData3 = new WebViewCore.TouchEventData();
                                        touchEventData3.mIds = new int[1];
                                        touchEventData3.mIds[0] = motionEvent.getPointerId(0);
                                        touchEventData3.mAction = 512;
                                        touchEventData3.mX = viewToContentX;
                                        touchEventData3.mY = viewToContentY;
                                        touchEventData3.mViewX = viewWidth;
                                        touchEventData3.mViewY = viewHeightWithTitle;
                                        touchEventData3.mMetaState = motionEvent.getMetaState();
                                        touchEventData3.mReprocess = this.mDeferTouchProcess;
                                        touchEventData3.mNativeLayer = nativeScrollableLayer(viewToContentX, viewToContentY, touchEventData3.mNativeLayerRect, null);
                                        touchEventData3.mSequence = this.mTouchEventQueue.nextTouchSequence();
                                        this.mTouchEventQueue.preQueueTouchEventData(touchEventData3);
                                        if (this.mDeferTouchProcess) {
                                            touchEventData3.mViewX = viewWidth;
                                            touchEventData3.mViewY = viewHeightWithTitle;
                                        }
                                        this.mWebViewCore.sendMessage(ZEUS_PLUGIN_FULL_SCREEN_EXIT, touchEventData3);
                                        break;
                                    } else if (this.mPreventDefault != 3) {
                                        doDoubleTap();
                                        this.mTouchMode = 7;
                                        break;
                                    }
                                    break;
                            }
                            stopTouch();
                            break;
                        }
                    }
                    break;
                case 2:
                    if (i2 != 0 || i3 != 0) {
                        if (i2 >= 0 && i3 >= 0) {
                            this.mScrollIframeDeltaX = SCROLL_DELTA;
                            this.mScrollIframeDeltaY = SCROLL_DELTA;
                        } else if (i2 >= 0 && i3 <= 0) {
                            this.mScrollIframeDeltaX = SCROLL_DELTA;
                            this.mScrollIframeDeltaY = SCROLL_DELTA * (-1);
                        } else if (i2 <= 0 && i3 >= 0) {
                            this.mScrollIframeDeltaX = SCROLL_DELTA * (-1);
                            this.mScrollIframeDeltaY = SCROLL_DELTA;
                        } else if (i2 <= 0 && i3 <= 0) {
                            this.mScrollIframeDeltaX = SCROLL_DELTA * (-1);
                            this.mScrollIframeDeltaY = SCROLL_DELTA * (-1);
                        }
                    }
                    if (this.mClickUrlPauseDraw && this.mConfirmMove) {
                        this.mClickUrlPauseDraw = false;
                        WebViewCore webViewCore = this.mWebViewCore;
                        WebViewCore.resumeUpdatePicture(this.mWebViewCore);
                    }
                    if (DragState.DragDown == this.mDragState) {
                        this.mDragState = DragState.Draging;
                    }
                    if (this.mMagnifierMode) {
                        this.mLastTouchX = viewWidth;
                        this.mLastTouchY = viewHeightWithTitle;
                        invalidate();
                        if (this.mUseGL) {
                            doCaptureScalePicViewSize();
                        }
                        if (getWebChromeClient() != null) {
                            getWebChromeClient().moveMagnifier(this, (int) viewWidth, (int) viewHeightWithTitle, (int) viewWidth, (int) viewHeightWithTitle);
                            break;
                        }
                    } else {
                        boolean z4 = false;
                        if ((this.mSelectingText && this.mSelectionStarted) || (!this.mConfirmMove && (i2 * i2) + (i3 * i3) >= this.mTouchSlopSquare)) {
                            this.mPrivateHandler.removeMessages(3);
                            this.mPrivateHandler.removeMessages(4);
                            cancelLongPressDelay();
                            this.mConfirmMove = true;
                            z4 = true;
                            if (this.mTouchMode == 6) {
                                this.mTouchMode = 1;
                            }
                        }
                        if (shouldForwardTouchEvent() && this.mConfirmMove && (z4 || eventTime - this.mLastSentTouchTime > this.mCurrentTouchInterval)) {
                            this.mLastSentTouchTime = eventTime;
                            WebViewCore.TouchEventData touchEventData4 = new WebViewCore.TouchEventData();
                            touchEventData4.mAction = i;
                            touchEventData4.mIds = new int[1];
                            touchEventData4.mIds[0] = motionEvent.getPointerId(0);
                            touchEventData4.mX = viewToContentX;
                            touchEventData4.mY = viewToContentY;
                            touchEventData4.mViewX = viewWidth;
                            touchEventData4.mViewY = viewHeightWithTitle;
                            touchEventData4.mMetaState = motionEvent.getMetaState();
                            touchEventData4.mReprocess = this.mDeferTouchProcess;
                            touchEventData4.mNativeLayer = this.mScrollingLayer;
                            touchEventData4.mNativeLayerRect.set(this.mScrollingLayerRect);
                            touchEventData4.mSequence = this.mTouchEventQueue.nextTouchSequence();
                            this.mTouchEventQueue.preQueueTouchEventData(touchEventData4);
                            this.mWebViewCore.sendMessage(ZEUS_PLUGIN_FULL_SCREEN_EXIT, touchEventData4);
                            this.mLastSentTouchTime = eventTime;
                            if (this.mDeferTouchProcess) {
                                touchEventData4.mViewX = viewWidth;
                                touchEventData4.mViewY = viewHeightWithTitle;
                                this.mWebViewCore.sendMessage(ZEUS_PLUGIN_FULL_SCREEN_EXIT, touchEventData4);
                                break;
                            } else if (z4 && !inFullScreenMode()) {
                                this.mPrivateHandler.sendMessageDelayed(this.mPrivateHandler.obtainMessage(10, i, 0), 200L);
                            }
                        }
                        if (this.mTouchMode != 7 && this.mPreventDefault != 3) {
                            if (this.mVelocityTracker != null) {
                                this.mVelocityTracker.addMovement(motionEvent);
                            }
                            if (this.mSelectingText) {
                                hideSelectionActionDialogPrivate();
                            }
                            if (this.mSelectingText && this.mSelectionStarted) {
                                nativeExtendSelection(viewToContentX, viewToContentY);
                                invalidate();
                                int contentToViewDimension = contentToViewDimension(nativeSelectionX()) - this.mScrollX;
                                int contentToViewDimension2 = contentToViewDimension(nativeSelectionY()) - this.mScrollY;
                                if (this.mMagnifierOn) {
                                    if (this.mUseGL) {
                                        doCaptureScalePicViewSize();
                                    }
                                    if (this.mLastSelX != contentToViewDimension || this.mLastSelY != contentToViewDimension2) {
                                        this.mLastSelX = contentToViewDimension;
                                        this.mLastSelY = contentToViewDimension2;
                                        if (getWebChromeClient() != null && viewWidth >= 0.0f && viewHeightWithTitle >= 0.0f && contentToViewDimension2 >= 0) {
                                            getWebChromeClient().moveMagnifier(this, (int) viewWidth, (int) viewHeightWithTitle, (int) viewWidth, contentToViewDimension2);
                                            break;
                                        }
                                    } else if (getWebChromeClient() != null && viewWidth >= 0.0f && viewHeightWithTitle >= 0.0f && contentToViewDimension2 >= 0) {
                                        getWebChromeClient().moveMagnifier(this, (int) viewWidth, (int) viewHeightWithTitle, (int) viewWidth, contentToViewDimension2);
                                        break;
                                    }
                                }
                            } else {
                                if (this.mTouchMode != 3 && this.mTouchMode != 9) {
                                    if (this.mConfirmMove) {
                                        if (this.mPreventDefault == 1 || this.mPreventDefault == 2) {
                                            this.mLastTouchTime = eventTime;
                                            break;
                                        } else {
                                            if (this.mScaleDetector != null && !this.mScaleDetector.isInProgress()) {
                                                int abs = Math.abs(i2);
                                                int abs2 = Math.abs(i3);
                                                if (abs > MAX_SLOPE_FOR_DIAG * abs2) {
                                                    this.mSnapScrollMode = 2;
                                                    this.mSnapPositive = i2 > 0;
                                                } else if (abs2 > abs * MAX_SLOPE_FOR_DIAG) {
                                                    this.mSnapScrollMode = 4;
                                                    this.mSnapPositive = i3 > 0;
                                                }
                                            }
                                            if (!isZeusPluginFullScreenMode()) {
                                                this.mTouchMode = 3;
                                                this.mLastTouchX = viewWidth;
                                                this.mLastTouchY = viewHeightWithTitle;
                                                f3 = 0.0f;
                                                f4 = 0.0f;
                                                i2 = 0;
                                                i3 = 0;
                                                startScrollingLayer(viewWidth, viewHeightWithTitle);
                                                startDrag();
                                            }
                                        }
                                    }
                                }
                                if (this.mDragTrackerHandler != null) {
                                    this.mDragTrackerHandler.dragTo(viewWidth, viewHeightWithTitle);
                                }
                                int pinLocX = pinLocX(this.mScrollX + i2) - this.mScrollX;
                                int pinLocY = pinLocY(this.mScrollY + i3) - this.mScrollY;
                                if (this.mTouchMode != 9 || this.mScrollingLayer == 0) {
                                    if (i2 != pinLocX) {
                                        f3 = pinLocX;
                                        i2 = pinLocX;
                                    }
                                    if (i3 != pinLocY) {
                                        i3 = pinLocY;
                                        f = f3;
                                        f2 = pinLocY;
                                        z = false;
                                        z2 = false;
                                        if (Math.abs(f) >= 1.0f && Math.abs(f2) < 1.0f) {
                                            this.mLastTouchX = viewWidth;
                                            this.mLastTouchY = viewHeightWithTitle;
                                            z2 = true;
                                            z = true;
                                        } else {
                                            if (this.mSnapScrollMode != 2 || this.mSnapScrollMode == 4) {
                                                int abs3 = Math.abs(i2);
                                                int abs4 = Math.abs(i3);
                                                if (this.mSnapScrollMode != 2) {
                                                    if (abs4 > MAX_SLOPE_FOR_DIAG * abs3 && abs4 > 80) {
                                                        this.mSnapScrollMode = 0;
                                                    }
                                                    if (abs3 > abs4 * MAX_SLOPE_FOR_DIAG) {
                                                        if (this.mSnapPositive) {
                                                            break;
                                                        } else if (i2 > this.mMinLockSnapReverseDistance) {
                                                            this.mSnapScrollMode |= 1;
                                                        }
                                                    }
                                                } else {
                                                    if (abs3 > MAX_SLOPE_FOR_DIAG * abs4 && abs3 > 80) {
                                                        this.mSnapScrollMode = 0;
                                                    }
                                                    if (abs4 > abs3 * MAX_SLOPE_FOR_DIAG) {
                                                        if (this.mSnapPositive) {
                                                            break;
                                                        } else if (i3 > this.mMinLockSnapReverseDistance) {
                                                            this.mSnapScrollMode |= 1;
                                                        }
                                                    }
                                                }
                                            }
                                            if (this.mSnapScrollMode != 0) {
                                                if ((this.mSnapScrollMode & 2) == 2) {
                                                    i3 = 0;
                                                } else {
                                                    i2 = 0;
                                                }
                                            }
                                            if ((i2 | i3) == 0) {
                                                if (i2 != 0) {
                                                    this.mLastTouchX = viewWidth;
                                                }
                                                if (i3 != 0) {
                                                    this.mLastTouchY = viewHeightWithTitle;
                                                }
                                                this.mHeldMotionless = 0;
                                            } else {
                                                this.mLastTouchX = viewWidth;
                                                this.mLastTouchY = viewHeightWithTitle;
                                                z2 = true;
                                            }
                                            this.mLastTouchTime = eventTime;
                                            this.mUserScroll = true;
                                        }
                                        doDrag(i2, i3);
                                        if (z2 && this.mTouchMode != 9) {
                                            if (this.mHeldMotionless != 2) {
                                                this.mHeldMotionless = 2;
                                                invalidate();
                                            }
                                            awakenScrollBars(ViewConfiguration.getScrollDefaultDelay(), false);
                                            return z;
                                        }
                                    }
                                }
                                f = f3;
                                f2 = f4;
                                z = false;
                                z2 = false;
                                if (Math.abs(f) >= 1.0f) {
                                }
                                if (this.mSnapScrollMode != 2) {
                                }
                                int abs32 = Math.abs(i2);
                                int abs42 = Math.abs(i3);
                                if (this.mSnapScrollMode != 2) {
                                }
                                if (this.mSnapScrollMode != 0) {
                                }
                                if ((i2 | i3) == 0) {
                                }
                                this.mLastTouchTime = eventTime;
                                this.mUserScroll = true;
                                doDrag(i2, i3);
                                if (z2) {
                                    if (this.mHeldMotionless != 2) {
                                    }
                                    awakenScrollBars(ViewConfiguration.getScrollDefaultDelay(), false);
                                    if (z) {
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    if (this.mTouchMode == 3) {
                        invalidate();
                    }
                    cancelWebCoreTouchEvent(viewToContentX, viewToContentY, false);
                    cancelTouch();
                    break;
            }
            return true;
        } catch (IllegalArgumentException e) {
            Log.e(LOGTAG, "catch OntouchEvent exception....");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelWebCoreTouchEvent(int i, int i2, boolean z) {
        if (shouldForwardTouchEvent()) {
            if (z) {
                this.mWebViewCore.removeMessages(ZEUS_PLUGIN_FULL_SCREEN_EXIT);
            }
            WebViewCore.TouchEventData touchEventData = new WebViewCore.TouchEventData();
            touchEventData.mIds = new int[1];
            touchEventData.mIds[0] = 0;
            touchEventData.mX = i;
            touchEventData.mY = i2;
            touchEventData.mViewX = contentToViewX(i) - this.mScrollX;
            touchEventData.mViewY = contentToViewY(i2) - this.mScrollY;
            touchEventData.mAction = 3;
            touchEventData.mNativeLayer = nativeScrollableLayer(i, i2, touchEventData.mNativeLayerRect, null);
            touchEventData.mSequence = this.mTouchEventQueue.nextTouchSequence();
            this.mWebViewCore.sendMessage(ZEUS_PLUGIN_FULL_SCREEN_EXIT, touchEventData);
            this.mPreventDefault = 4;
            if (z) {
                this.mTouchEventQueue.ignoreCurrentlyMissingEvents();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTouch(float f, float f2, long j) {
        this.mLastTouchX = f;
        this.mLastTouchY = f2;
        this.mLastTouchTime = j;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mSnapScrollMode = 0;
        if (this.mDragTracker != null) {
            this.mDragTrackerHandler = new DragTrackerHandler(f, f2, this.mDragTracker);
        }
        if (nativePointInNavCache(viewToContentX(((int) this.mLastTouchX) + this.mScrollX), viewToContentY(((int) this.mLastTouchY) + this.mScrollY), viewToContentDimension(this.mNavSlop)) && nativeGetCacheHitNodeAnchorURL() != null) {
            WebViewCore.pauseUpdatePicture(this.mWebViewCore);
            this.mWebViewCore.setForceResumeUpdatePicture(true);
            this.mClickUrlPauseDraw = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDrag() {
        if (!isZeusPluginFullScreenMode()) {
            this.mDragging = true;
            WebViewCore.reducePriority();
            WebViewCore.pauseUpdatePicture(this.mWebViewCore);
            nativeSetIsScrolling(true);
            if (!this.mDragFromTextInput) {
                nativeHideCursor();
            }
            WebSettings settings = getSettings();
            if (!settings.supportZoom() || !settings.getBuiltInZoomControls() || getZoomButtonsController().isVisible() || this.mMinZoomScale >= this.mMaxZoomScale) {
                return;
            }
            if (this.mHorizontalScrollBarMode != 1 || this.mVerticalScrollBarMode != 1) {
                this.mZoomButtonsController.setVisible(true);
                int doubleTapToastCount = settings.getDoubleTapToastCount();
                if (this.mInZoomOverview && doubleTapToastCount > 0) {
                    settings.setDoubleTapToastCount(doubleTapToastCount - 1);
                    Toast.makeText(this.mContext, 17040004, 1).show();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDrag(int i, int i2) {
        if (!isZeusPluginFullScreenMode()) {
            if (this.mTouchMode == 9 && this.mScrollingLayer != 0) {
                if ((i | i2) != 0) {
                    int i3 = this.mScrollX;
                    int i4 = this.mScrollY;
                    computeMaxScrollX();
                    computeMaxScrollY();
                    if (this.mScrollingLayer != 0) {
                        int viewToContentDimension = viewToContentDimension(i);
                        int viewToContentDimension2 = viewToContentDimension(i2);
                        int i5 = this.mScrollingLayerRect.right;
                        int i6 = this.mScrollingLayerRect.bottom;
                        int max = Math.max(0, Math.min(viewToContentDimension + this.mScrollingLayerRect.left, i5));
                        int max2 = Math.max(0, Math.min(viewToContentDimension2 + this.mScrollingLayerRect.top, i6));
                        if (max != this.mScrollingLayerRect.left || max2 != this.mScrollingLayerRect.top) {
                            this.mTouchMode = 9;
                            int i7 = this.mScrollingLayerRect.left;
                            int i8 = this.mScrollingLayerRect.top;
                            return;
                        }
                        this.mTouchMode = 3;
                        return;
                    }
                    return;
                }
                return;
            }
            if ((i | i2) != 0) {
                scrollBy(i, i2);
            }
            if (!getSettings().getBuiltInZoomControls()) {
                boolean z = this.mMinZoomScale < this.mMaxZoomScale;
                if (this.mZoomControls != null && z) {
                    if (this.mZoomControls.getVisibility() == 0) {
                        this.mPrivateHandler.removeCallbacks(this.mZoomControlRunnable);
                    } else {
                        this.mZoomControls.show(z, false);
                    }
                    this.mPrivateHandler.postDelayed(this.mZoomControlRunnable, ZOOM_CONTROLS_TIMEOUT);
                }
            }
        }
    }

    private void stopTouch() {
        if (this.mScroller.isFinished() && !this.mSelectingText && (this.mTouchMode == 3 || this.mTouchMode == 9)) {
            WebViewCore.resumePriority();
            WebViewCore.resumeUpdatePicture(this.mWebViewCore);
            nativeSetIsScrolling(false);
        }
        if (this.mDragTrackerHandler != null) {
            this.mDragTrackerHandler.stopDrag();
        }
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelTouch() {
        if (this.mDragTrackerHandler != null) {
            this.mDragTrackerHandler.stopDrag();
        }
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        if (this.mTouchMode == 3 || this.mTouchMode == 9) {
            WebViewCore.resumePriority();
            WebViewCore.resumeUpdatePicture(this.mWebViewCore);
            nativeSetIsScrolling(false);
        }
        this.mPrivateHandler.removeMessages(3);
        this.mPrivateHandler.removeMessages(4);
        cancelLongPressDelay();
        this.mPrivateHandler.removeMessages(8);
        this.mPrivateHandler.removeMessages(9);
        this.mHeldMotionless = 2;
        this.mTouchMode = 7;
        nativeHideCursor();
    }

    public boolean enableSelectText() {
        return this.mEnableSelectText;
    }

    public void setEnableSelectText(boolean z) {
        this.mEnableSelectText = z;
    }

    public void setMapTrackballToArrowKeys(boolean z) {
        this.mMapTrackballToArrowKeys = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetTrackballTime() {
        this.mTrackballLastTime = 0L;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (this.mSelectingText) {
            return true;
        }
        long eventTime = motionEvent.getEventTime();
        if ((motionEvent.getMetaState() & 2) != 0) {
            if (motionEvent.getY() > 0.0f) {
                pageDown(true);
            }
            if (motionEvent.getY() < 0.0f) {
                pageUp(true);
                return true;
            }
            return true;
        } else if (motionEvent.getAction() == 0) {
            if (this.mSelectingText) {
                return true;
            }
            this.mTrackballDown = true;
            if (this.mNativeClass == 0) {
                return false;
            }
            nativeRecordButtons(hasFocus() && hasWindowFocus(), true, true);
            if (eventTime - this.mLastCursorTime <= 200 && !this.mLastCursorBounds.equals(nativeGetCursorRingBounds())) {
                nativeSelectBestAt(this.mLastCursorBounds);
            }
            if (isInTouchMode()) {
                requestFocusFromTouch();
            }
            return false;
        } else if (motionEvent.getAction() == 1) {
            this.mPrivateHandler.removeMessages(LONG_PRESS_CENTER);
            this.mTrackballDown = false;
            this.mTrackballUpTime = eventTime;
            if (this.mSelectingText) {
                if (this.mExtendSelection) {
                    copySelection();
                    selectionDone();
                    return true;
                }
                this.mExtendSelection = true;
                nativeSetExtendSelection();
                invalidate();
                return true;
            }
            return false;
        } else if (!this.mMapTrackballToArrowKeys || this.mShiftIsPressed) {
            if (this.mTrackballDown || eventTime - this.mTrackballUpTime < 200) {
                return true;
            }
            switchOutDrawHistory();
            if (eventTime - this.mTrackballLastTime > 200) {
                this.mTrackballFirstTime = eventTime;
                this.mTrackballYMove = 0;
                this.mTrackballXMove = 0;
            }
            this.mTrackballLastTime = eventTime;
            this.mTrackballRemainsX += motionEvent.getX();
            this.mTrackballRemainsY += motionEvent.getY();
            doTrackball(eventTime);
            return true;
        } else {
            return false;
        }
    }

    void moveSelection(float f, float f2) {
        int i;
        int i2 = -16;
        if (this.mNativeClass != 0) {
            int viewWidth = getViewWidth();
            int viewHeight = getViewHeight();
            this.mSelectX = (int) (this.mSelectX + f);
            this.mSelectY = (int) (this.mSelectY + f2);
            int i3 = viewWidth + this.mScrollX;
            int i4 = viewHeight + this.mScrollY;
            this.mSelectX = Math.min(i3, Math.max(this.mScrollX - 16, this.mSelectX));
            this.mSelectY = Math.min(i4, Math.max(this.mScrollY - 16, this.mSelectY));
            nativeMoveSelection(viewToContentX(this.mSelectX), viewToContentY(this.mSelectY));
            if (this.mSelectX < this.mScrollX) {
                i = -16;
            } else {
                i = this.mSelectX > i3 + (-16) ? 16 : 0;
            }
            if (this.mSelectY >= this.mScrollY) {
                i2 = this.mSelectY > i4 + (-16) ? 16 : 0;
            }
            pinScrollBy(i, i2, true, 0);
            requestRectangleOnScreen(new Rect(this.mSelectX, this.mSelectY, this.mSelectX + 1, this.mSelectY + 1));
            invalidate();
        }
    }

    private int scaleTrackballX(float f, int i) {
        int i2;
        int i3 = (int) ((f / 400.0f) * i);
        if (i3 > 0) {
            if (i3 > this.mTrackballXMove) {
                i2 = i3 - this.mTrackballXMove;
            }
            i2 = i3;
        } else {
            if (i3 < this.mTrackballXMove) {
                i2 = i3 - this.mTrackballXMove;
            }
            i2 = i3;
        }
        this.mTrackballXMove = i3;
        return i2;
    }

    private int scaleTrackballY(float f, int i) {
        int i2;
        int i3 = (int) ((f / 400.0f) * i);
        if (i3 > 0) {
            if (i3 > this.mTrackballYMove) {
                i2 = i3 - this.mTrackballYMove;
            }
            i2 = i3;
        } else {
            if (i3 < this.mTrackballYMove) {
                i2 = i3 - this.mTrackballYMove;
            }
            i2 = i3;
        }
        this.mTrackballYMove = i3;
        return i2;
    }

    private int keyCodeToSoundsEffect(int i) {
        switch (i) {
            case 19:
                return 2;
            case 20:
                return 4;
            case 21:
                return 1;
            case DERTags.IA5_STRING /* 22 */:
                return 3;
            default:
                throw new IllegalArgumentException("keyCode must be one of {KEYCODE_DPAD_UP, KEYCODE_DPAD_RIGHT, KEYCODE_DPAD_DOWN, KEYCODE_DPAD_LEFT}.");
        }
    }

    private void doTrackball(long j) {
        int i;
        int i2 = (int) (this.mTrackballLastTime - this.mTrackballFirstTime);
        if (i2 == 0) {
            i2 = BdWebPoolView.DELAYED_TIME;
        }
        float f = (this.mTrackballRemainsX * 1000.0f) / i2;
        float f2 = (this.mTrackballRemainsY * 1000.0f) / i2;
        int viewWidth = getViewWidth();
        int viewHeight = getViewHeight();
        if (this.mSelectingText) {
            if (!this.mDrawSelectionPointer) {
                this.mSelectX = contentToViewX(nativeSelectionX());
                this.mSelectY = contentToViewY(nativeSelectionY());
                this.mExtendSelection = true;
                this.mDrawSelectionPointer = true;
                nativeSetExtendSelection();
            }
            moveSelection(scaleTrackballX(f, viewWidth), scaleTrackballY(f2, viewHeight));
            this.mTrackballRemainsY = 0.0f;
            this.mTrackballRemainsX = 0.0f;
            return;
        }
        Math.max(Math.abs(f), Math.abs(f2));
        int i3 = this.mContentWidth - viewWidth;
        int i4 = this.mContentHeight - viewHeight;
        int i5 = i3 < 0 ? 0 : i3;
        int i6 = i4 < 0 ? 0 : i4;
        float abs = Math.abs(this.mTrackballRemainsX * 3.0f);
        float abs2 = Math.abs(this.mTrackballRemainsY * 3.0f);
        int max = Math.max(0, (int) Math.max(abs, abs2));
        int i7 = this.mScrollX;
        int i8 = this.mScrollY;
        if (max > 0) {
            if (abs < abs2) {
                i = this.mTrackballRemainsY < 0.0f ? 19 : 20;
            } else {
                i = this.mTrackballRemainsX < 0.0f ? 21 : 22;
            }
            max = Math.min(max, 10);
            if (this.mNativeClass != 0 && nativeFocusIsPlugin()) {
                for (int i9 = 0; i9 < max; i9++) {
                    letPluginHandleNavKey(i, j, true);
                }
                letPluginHandleNavKey(i, j, false);
            } else if (navHandledKey(i, max, false, j)) {
                playSoundEffect(keyCodeToSoundsEffect(i));
            }
            this.mTrackballRemainsY = 0.0f;
            this.mTrackballRemainsX = 0.0f;
        }
        if (max >= 5) {
            int scaleTrackballX = scaleTrackballX(f, i5);
            int scaleTrackballY = scaleTrackballY(f2, i6);
            if (Math.abs(this.mScrollX - i7) > Math.abs(scaleTrackballX)) {
                scaleTrackballX = 0;
            }
            if (Math.abs(this.mScrollY - i8) > Math.abs(scaleTrackballY)) {
                scaleTrackballY = 0;
            }
            if (scaleTrackballX != 0 || scaleTrackballY != 0) {
                pinScrollBy(scaleTrackballX, scaleTrackballY, true, 0);
            }
            this.mUserScroll = true;
        }
    }

    public int computeMaxScrollX() {
        return Math.max(computeRealHorizontalScrollRange() - getViewWidth(), 0);
    }

    public int computeMaxScrollY() {
        return Math.max((computeRealVerticalScrollRange() + getTitleHeight()) - getViewHeightWithTitle(), 0);
    }

    public void flingScroll(int i, int i2) {
        this.mScroller.fling(this.mScrollX, this.mScrollY, i, i2, 0, computeMaxScrollX(), 0, computeMaxScrollY());
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doFling() {
        float f;
        int i;
        int i2;
        if (this.mVelocityTracker != null) {
            int computeMaxScrollX = computeMaxScrollX();
            int computeMaxScrollY = computeMaxScrollY();
            this.mVelocityTracker.computeCurrentVelocity(LocationClientOption.MIN_SCAN_SPAN, this.mMaximumFling);
            int xVelocity = (int) this.mVelocityTracker.getXVelocity();
            int yVelocity = (int) this.mVelocityTracker.getYVelocity();
            int i3 = this.mScrollX;
            int i4 = this.mScrollY;
            int i5 = this.mOverflingDistance;
            if (this.mTouchMode == 9) {
                i3 = this.mScrollingLayerRect.left;
                i4 = this.mScrollingLayerRect.top;
                computeMaxScrollX = this.mScrollingLayerRect.right;
                computeMaxScrollY = this.mScrollingLayerRect.bottom;
            }
            if (this.mSnapScrollMode != 0) {
                if ((this.mSnapScrollMode & 2) == 2) {
                    yVelocity = 0;
                } else {
                    xVelocity = 0;
                }
            }
            if ((computeMaxScrollX == 0 && yVelocity == 0) || (computeMaxScrollY == 0 && xVelocity == 0)) {
                WebViewCore.resumePriority();
                if (!this.mSelectingText) {
                    WebViewCore.resumeUpdatePicture(this.mWebViewCore);
                    return;
                }
                return;
            }
            float currVelocity = this.mScroller.getCurrVelocity();
            float hypot = (float) Math.hypot(xVelocity, yVelocity);
            if (this.mLastVelocity > 0.0f && currVelocity > 0.0f && hypot > this.mLastVelocity * MINIMUM_VELOCITY_RATIO_FOR_ACCELERATION) {
                float abs = (float) Math.abs(Math.atan2(this.mLastVelY, this.mLastVelX) - Math.atan2(yVelocity, xVelocity));
                if (abs > 5.6548667f || abs < 0.62831855f) {
                    int i6 = (int) (xVelocity + ((this.mLastVelX * currVelocity) / this.mLastVelocity));
                    int i7 = (int) (yVelocity + ((this.mLastVelY * currVelocity) / this.mLastVelocity));
                    f = (float) Math.hypot(i6, i7);
                    i = i7;
                    i2 = i6;
                    if ((i3 != 0 || i3 == computeMaxScrollX) && Math.abs(i2) < Math.abs(i)) {
                        i2 = 0;
                    }
                    int i8 = ((i4 != 0 || i4 == computeMaxScrollY) && Math.abs(i) < Math.abs(i2)) ? 0 : i;
                    this.mLastVelX = i2;
                    this.mLastVelY = i8;
                    this.mLastVelocity = f;
                    this.mScroller.fling(i3, i4, -i2, -i8, 0, computeMaxScrollX, 0, computeMaxScrollY);
                    int duration = this.mScroller.getDuration();
                    if (this.mTouchMode != 9) {
                        awakenScrollBars(duration);
                    }
                    this.mPrivateHandler.sendEmptyMessageDelayed(7, duration);
                    invalidate();
                }
            }
            f = hypot;
            i = yVelocity;
            i2 = xVelocity;
            if (i3 != 0) {
            }
            i2 = 0;
            if (i4 != 0) {
            }
            this.mLastVelX = i2;
            this.mLastVelY = i8;
            this.mLastVelocity = f;
            this.mScroller.fling(i3, i4, -i2, -i8, 0, computeMaxScrollX, 0, computeMaxScrollY);
            int duration2 = this.mScroller.getDuration();
            if (this.mTouchMode != 9) {
            }
            this.mPrivateHandler.sendEmptyMessageDelayed(7, duration2);
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zoomWithPreview(float f, boolean z) {
        float f2 = this.mActualScale;
        this.mInitialScrollX = this.mScrollX;
        this.mInitialScrollY = this.mScrollY;
        if (this.mZoomState != ZoomState.ZoomBlock && Math.abs(f - this.mDefaultScale) < MINIMUM_SCALE_INCREMENT) {
            f = this.mDefaultScale;
        }
        setNewZoomScale(f, z, false);
        if (f2 != this.mActualScale) {
            this.mZoomStart = SystemClock.uptimeMillis();
            this.mInvInitialZoomScale = 1.0f / f2;
            this.mInvFinalZoomScale = 1.0f / this.mActualScale;
            this.mZoomScale = this.mActualScale;
            WebViewCore.pauseUpdatePicture(this.mWebViewCore);
            invalidate();
            return true;
        }
        return false;
    }

    @Deprecated
    public View getZoomControls() {
        if (!getSettings().supportZoom()) {
            return null;
        }
        if (this.mZoomControls == null) {
            this.mZoomControls = createZoomControls();
            this.mZoomControls.setVisibility(0);
            this.mZoomControlRunnable = new Runnable() { // from class: com.baidu.zeus.WebView.10
                @Override // java.lang.Runnable
                public void run() {
                    if (!WebView.this.mZoomControls.hasFocus()) {
                        WebView.this.mZoomControls.hide();
                        return;
                    }
                    WebView.this.mPrivateHandler.removeCallbacks(WebView.this.mZoomControlRunnable);
                    WebView.this.mPrivateHandler.postDelayed(WebView.this.mZoomControlRunnable, WebView.ZOOM_CONTROLS_TIMEOUT);
                }
            };
        }
        return this.mZoomControls;
    }

    private ExtendedZoomControls createZoomControls() {
        ExtendedZoomControls extendedZoomControls = new ExtendedZoomControls(this.mContext, null);
        extendedZoomControls.setOnZoomInClickListener(new View.OnClickListener() { // from class: com.baidu.zeus.WebView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WebView.this.mPrivateHandler.removeCallbacks(WebView.this.mZoomControlRunnable);
                WebView.this.mPrivateHandler.postDelayed(WebView.this.mZoomControlRunnable, WebView.ZOOM_CONTROLS_TIMEOUT);
                WebView.this.zoomIn();
            }
        });
        extendedZoomControls.setOnZoomOutClickListener(new View.OnClickListener() { // from class: com.baidu.zeus.WebView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WebView.this.mPrivateHandler.removeCallbacks(WebView.this.mZoomControlRunnable);
                WebView.this.mPrivateHandler.postDelayed(WebView.this.mZoomControlRunnable, WebView.ZOOM_CONTROLS_TIMEOUT);
                WebView.this.zoomOut();
            }
        });
        return extendedZoomControls;
    }

    public ZoomButtonsController getZoomButtonsController() {
        if (this.mZoomButtonsController == null) {
            this.mZoomButtonsController = new ZoomButtonsController(this);
            this.mZoomButtonsController.setOnZoomListener(this.mZoomListener);
            ViewGroup.LayoutParams layoutParams = this.mZoomButtonsController.getZoomControls().getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 5;
            }
        }
        return this.mZoomButtonsController;
    }

    public boolean zoomIn() {
        switchOutDrawHistory();
        this.mInZoomOverview = false;
        this.mZoomCenterX = getViewWidth() * 0.5f;
        this.mZoomCenterY = getViewHeight() * 0.5f;
        this.mAnchorX = viewToContentX(((int) this.mZoomCenterX) + this.mScrollX);
        this.mAnchorY = viewToContentY(((int) this.mZoomCenterY) + this.mScrollY);
        return zoomWithPreview(this.mActualScale * 1.25f, true);
    }

    public boolean zoomOut() {
        switchOutDrawHistory();
        this.mZoomCenterX = getViewWidth() * 0.5f;
        this.mZoomCenterY = getViewHeight() * 0.5f;
        this.mAnchorX = viewToContentX(((int) this.mZoomCenterX) + this.mScrollX);
        this.mAnchorY = viewToContentY(((int) this.mZoomCenterY) + this.mScrollY);
        return zoomWithPreview(this.mActualScale * 0.8f, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelection() {
        if (this.mNativeClass != 0) {
            int viewToContentX = viewToContentX(((int) this.mLastTouchX) + this.mScrollX);
            int viewToContentY = viewToContentY(((int) this.mLastTouchY) + this.mScrollY);
            int viewToContentDimension = viewToContentDimension(this.mNavSlop);
            nativeSelectBestAt(new Rect(viewToContentX - viewToContentDimension, viewToContentY - viewToContentDimension, viewToContentX + viewToContentDimension, viewToContentY + viewToContentDimension));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void scrollFocusedTextInput(float f, int i) {
        if (inEditingMode() && this.mWebViewCore != null) {
            this.mWebViewCore.sendMessage(99, viewToContentDimension(i), new Float(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initiateTextFieldDrag(float f, float f2, long j) {
        if (inEditingMode()) {
            this.mLastTouchX = (this.mWebTextView.getLeft() - this.mScrollX) + f;
            this.mLastTouchY = (this.mWebTextView.getTop() - this.mScrollY) + f2;
            this.mLastTouchTime = j;
            if (!this.mScroller.isFinished()) {
                abortAnimation();
                this.mPrivateHandler.removeMessages(7);
            }
            this.mSnapScrollMode = 0;
            this.mVelocityTracker = VelocityTracker.obtain();
            this.mTouchMode = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean textFieldDrag(MotionEvent motionEvent) {
        if (inEditingMode()) {
            this.mDragFromTextInput = true;
            motionEvent.offsetLocation(this.mWebTextView.getLeft() - this.mScrollX, this.mWebTextView.getTop() - this.mScrollY);
            boolean onTouchEvent = onTouchEvent(motionEvent);
            this.mDragFromTextInput = false;
            return onTouchEvent;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void touchUpOnTextField(MotionEvent motionEvent) {
        if (inEditingMode()) {
            nativeMotionUp(viewToContentX(((int) motionEvent.getX()) + this.mWebTextView.getLeft()), viewToContentY(((int) motionEvent.getY()) + this.mWebTextView.getTop()), viewToContentDimension(this.mNavSlop), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void centerKeyPressOnTextField() {
        this.mWebViewCore.sendMessage(REQUEST_KEYBOARD, nativeCursorFramePointer(), nativeCursorNodePointer());
    }

    public boolean isLoading() {
        return this.mCallbackProxy != null && this.mCallbackProxy.getProgress() > 0 && this.mCallbackProxy.getProgress() < 100;
    }

    public void startProgressTimer() {
        if (this.progressTimer == null) {
            this.progressTimer = new java.util.Timer();
        }
        this.progressTimer.schedule(new TimerTask() { // from class: com.baidu.zeus.WebView.13
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                synchronized (this) {
                    int i = WebView.this.lastProgress + 1;
                    if (i > WebView.TOUCH_SENT_INTERVAL) {
                        i = WebView.this.lastProgress;
                    }
                    WebView.this.getWebChromeClient().onProgressChanged(WebView.this.getWebViewCore().getWebView(), i);
                    WebView.this.lastProgress = i;
                }
            }
        }, 0L, 200L);
    }

    public void startNightTimer() {
        if (this.nightTimer == null) {
            this.nightTimer = new java.util.Timer();
        }
        this.nightTimer.schedule(new TimerTask() { // from class: com.baidu.zeus.WebView.14
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                synchronized (this) {
                    WebSettings settings = WebView.this.getSettings();
                    if (settings != null) {
                        settings.setNightModeEnabled(!settings.nightModeEnabled());
                    }
                }
            }
        }, 0L, 200L);
    }

    public void stopProgressTimer() {
        if (this.progressTimer != null) {
            this.progressTimer.cancel();
            this.progressTimer = null;
            this.lastProgress = 10;
            this.mStopingLoading = false;
            this.mCallbackProxy.mInStopLoading = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doShortPress() {
        int tapOnSubjectIndex;
        Log.e(LOGTAG, "doShortPress 1");
        if (this.mNativeClass != 0 && this.mPreventDefault != 3) {
            this.mTouchMode = 7;
            switchOutDrawHistory();
            int viewToContentX = viewToContentX(((int) this.mLastTouchX) + this.mScrollX);
            int viewToContentY = viewToContentY(((int) this.mLastTouchY) + this.mScrollY);
            int viewToContentDimension = viewToContentDimension(this.mNavSlop);
            if (viewToContentDimension != 4 && !isZeusPluginFullScreenMode() && !isMobileSite() && this.mWebViewCore != null && (tapOnSubjectIndex = tapOnSubjectIndex(viewToContentX, viewToContentY)) != -1) {
                Log.e(LOGTAG, "CHECK_CLICK_ON_SUBJECT :" + tapOnSubjectIndex);
                this.mWebViewCore.sendMessage(BdWebErrorView.ERROR_CODE_408, tapOnSubjectIndex);
                return;
            }
            if (nativePointInNavCache(viewToContentX, viewToContentY, viewToContentDimension)) {
                String nativeGetCacheHitNodeAnchorURL = nativeGetCacheHitNodeAnchorURL();
                if (nativeGetCacheHitNodeAnchorURL != null && !this.isZeusPluginFullScreen && isLoading()) {
                    updateSelection();
                    invalidate();
                    getWebChromeClient().onSetLoadURL(this, nativeGetCacheHitNodeAnchorURL);
                    getWebChromeClient().notifyClickWhenLoad();
                    BrowserFrame.mUserClick = true;
                    loadUrl(nativeGetCacheHitNodeAnchorURL);
                    WebViewCore.MotionUpData motionUpData = new WebViewCore.MotionUpData();
                    motionUpData.mFrame = nativeCacheHitFramePointer();
                    motionUpData.mNode = nativeCacheHitNodePointer();
                    motionUpData.mBounds = nativeCacheHitNodeBounds();
                    motionUpData.mX = viewToContentX;
                    motionUpData.mY = viewToContentY;
                    motionUpData.sendToCore = false;
                    this.mWebViewCore.sendMessageAtFrontOfQueue(SEND_SUBJECT_RECTS, motionUpData);
                } else {
                    logE("doShortPress 333333333333");
                    WebViewCore.MotionUpData motionUpData2 = new WebViewCore.MotionUpData();
                    motionUpData2.mFrame = nativeCacheHitFramePointer();
                    motionUpData2.mNode = nativeCacheHitNodePointer();
                    motionUpData2.mBounds = nativeCacheHitNodeBounds();
                    motionUpData2.mX = viewToContentX;
                    motionUpData2.mY = viewToContentY;
                    this.mWebViewCore.sendMessageAtFrontOfQueue(SEND_SUBJECT_RECTS, motionUpData2);
                }
            } else {
                Log.e(LOGTAG, "doShortPress 5");
                doMotionUp(viewToContentX, viewToContentY, true);
            }
            Log.e(LOGTAG, "doShortPress out");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doMotionUp(int i, int i2, boolean z) {
        logE("enter doMotionUp()");
        if (!dismissListBox()) {
            int viewToContentDimension = viewToContentDimension(this.mNavSlop);
            if (mLogEvent && nativeMotionUp(i, i2, viewToContentDimension, z)) {
                EventLog.writeEvent((int) EVENT_LOG_BROWSER_SNAP_CENTER, new Object[0]);
            }
        }
    }

    private boolean isPluginFitOnScreen(ViewManager.ChildView childView) {
        int viewWidth = getViewWidth();
        int viewHeightWithTitle = getViewHeightWithTitle();
        float min = Math.min(viewWidth / childView.width, viewHeightWithTitle / childView.height);
        if (min < this.mMinZoomScale) {
            min = this.mMinZoomScale;
        } else if (min > this.mMaxZoomScale) {
            min = this.mMaxZoomScale;
        }
        if (Math.abs(min - this.mActualScale) < MINIMUM_SCALE_INCREMENT && contentToViewX(childView.x) >= this.mScrollX && contentToViewX(childView.x + childView.width) <= viewWidth + this.mScrollX && contentToViewY(childView.y) >= this.mScrollY && contentToViewY(childView.y + childView.height) <= this.mScrollY + viewHeightWithTitle) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void centerFitRect(int i, int i2, int i3, int i4) {
        int viewWidth = getViewWidth();
        int viewHeightWithTitle = getViewHeightWithTitle();
        float min = Math.min(viewWidth / i3, viewHeightWithTitle / i4);
        if (min < this.mMinZoomScale) {
            min = this.mMinZoomScale;
        } else if (min > this.mMaxZoomScale) {
            min = this.mMaxZoomScale;
        }
        if (Math.abs(min - this.mActualScale) < MINIMUM_SCALE_INCREMENT) {
            pinScrollTo(contentToViewX((i3 / 2) + i) - (viewWidth / 2), contentToViewY((i4 / 2) + i2) - (viewHeightWithTitle / 2), true, 0);
            return;
        }
        float f = (i * this.mActualScale) - this.mScrollX;
        float f2 = i * min;
        float f3 = i3 * min;
        float f4 = this.mContentWidth * min;
        float f5 = (viewWidth - f3) / 2.0f;
        if (f5 <= f2) {
            f2 = f5 > (f4 - f2) - f3 ? viewWidth - (f4 - f2) : f5;
        }
        this.mZoomCenterX = ((f * min) - (f2 * this.mActualScale)) / (min - this.mActualScale);
        float titleHeight = ((i2 * this.mActualScale) + getTitleHeight()) - this.mScrollY;
        float titleHeight2 = (i2 * min) + getTitleHeight();
        float f6 = i4 * min;
        float titleHeight3 = getTitleHeight() + (this.mContentHeight * min);
        float f7 = (viewHeightWithTitle - f6) / 2.0f;
        if (f7 <= titleHeight2) {
            titleHeight2 = f7 > (titleHeight3 - titleHeight2) - f6 ? viewHeightWithTitle - (titleHeight3 - titleHeight2) : f7;
        }
        this.mZoomCenterY = ((titleHeight * min) - (titleHeight2 * this.mActualScale)) / (min - this.mActualScale);
        zoomWithPreview(min, false);
    }

    void dismissEditor() {
        if (isOwnEditOn()) {
            clearTextEntry(false, false);
            nativeClearCursor();
            hideSoftKeyboard();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dismissZoomControl() {
        if (this.mWebViewCore == null) {
            if (this.mZoomButtonsController != null) {
                this.mZoomButtonsController.setVisible(false);
            }
            if (this.mZoomControls != null) {
                this.mZoomControls.hide();
            }
        } else if (getSettings().getBuiltInZoomControls()) {
            if (this.mZoomButtonsController != null) {
                this.mZoomButtonsController.setVisible(false);
            }
        } else {
            if (this.mZoomControlRunnable != null) {
                this.mPrivateHandler.removeCallbacks(this.mZoomControlRunnable);
            }
            if (this.mZoomControls != null) {
                this.mZoomControls.hide();
            }
        }
    }

    private boolean needDoubleTapDelay() {
        if (this.mZoomState == ZoomState.ZoomOverview || this.mZoomState == ZoomState.ZoomOther || this.mZoomState == ZoomState.ZoomBlock) {
            return true;
        }
        if (ifWapAllowScale() && this.mWebViewCore.getSettings().getUseWideViewPort()) {
            float viewWidth = getViewWidth() / this.mZoomOverviewWidth;
            if (getSettings().getLayoutAlgorithm() != WebSettings.LayoutAlgorithm.NARROW_COLUMNS || Math.abs(this.mActualScale - this.mTextWrapScale) < MINIMUM_SCALE_INCREMENT) {
                return (!this.mInZoomOverview && (Math.abs(this.mActualScale - viewWidth) >= MINIMUM_SCALE_INCREMENT || Math.abs(this.mActualScale - this.mDefaultScale) >= MINIMUM_SCALE_INCREMENT)) || this.mInZoomOverview;
            }
            return true;
        }
        return false;
    }

    private long getDoubleTapDelay() {
        if (needDoubleTapDelay()) {
            long doubleTapTimeout = (ViewConfiguration.getDoubleTapTimeout() - System.currentTimeMillis()) + this.mLastDownTime;
            if (doubleTapTimeout <= 0) {
                doubleTapTimeout = 0;
            }
            return doubleTapTimeout;
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDoubleTap() {
        if (ifWapAllowScale() && this.mWebViewCore.getSettings().getUseWideViewPort()) {
            this.mZoomCenterX = this.mLastTouchX;
            this.mZoomCenterY = this.mLastTouchY;
            this.mAnchorX = viewToContentX(((int) this.mZoomCenterX) + this.mScrollX);
            this.mAnchorY = viewToContentY(((int) this.mZoomCenterY) + this.mScrollY);
            getSettings().setDoubleTapToastCount(0);
            dismissEditor();
            dismissZoomControl();
            dismissListBox();
            ViewManager.ChildView hitTest = this.mViewManager.hitTest(this.mAnchorX, this.mAnchorY);
            if (hitTest != null) {
                if (isPluginFitOnScreen(hitTest)) {
                    this.mInZoomOverview = true;
                    if (this.mScrollY < getTitleHeight()) {
                        this.mScrollY = 0;
                    }
                    zoomWithPreview(getViewWidth() / this.mZoomOverviewWidth, true);
                    return;
                }
                this.mInZoomOverview = false;
                centerFitRect(hitTest.x, hitTest.y, hitTest.width, hitTest.height);
            } else if (this.mZoomState == ZoomState.ZoomDefault || Math.abs(this.mActualScale - this.mDefaultScale) < MINIMUM_SCALE_INCREMENT) {
                zoom2Overview(true);
            } else if (this.mZoomState == ZoomState.ZoomOverview || this.mZoomState == ZoomState.ZoomOther || this.mZoomState == ZoomState.ZoomBlock) {
                this.mInZoomOverview = false;
                int i = getContext().getResources().getDisplayMetrics().widthPixels;
                float f = getContext().getResources().getDisplayMetrics().density;
                WebViewCore.DoubleTapScaleData doubleTapScaleData = new WebViewCore.DoubleTapScaleData();
                doubleTapScaleData.mScreenWidth = i;
                doubleTapScaleData.mAnchorX = this.mAnchorX;
                doubleTapScaleData.mAnchorY = this.mAnchorY;
                doubleTapScaleData.mNode = 0;
                if (nativePointInNavCache(this.mAnchorX, this.mAnchorY, viewToContentDimension(this.mNavSlop))) {
                    doubleTapScaleData.mNode = nativeCacheHitNodePointer();
                }
                this.mWebViewCore.sendMessageAtFrontOfQueue(BdWebErrorView.ERROR_CODE_502, doubleTapScaleData);
                this.mWaitingZoom2Block = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zoom2Default() {
        this.mInZoomOverview = false;
        int nativeGetBlockLeftEdge = nativeGetBlockLeftEdge(this.mAnchorX, this.mAnchorY, this.mActualScale);
        if (nativeGetBlockLeftEdge != -1) {
            int contentToViewX = contentToViewX(nativeGetBlockLeftEdge < 5 ? 0 : nativeGetBlockLeftEdge - 5) - this.mScrollX;
            if (contentToViewX > 0) {
                this.mZoomCenterX = (contentToViewX * this.mDefaultScale) / (this.mDefaultScale - this.mActualScale);
            } else {
                scrollBy(contentToViewX, 0);
                this.mZoomCenterX = 0.0f;
            }
        }
        if (ifNeedStorePageScale()) {
            mZeusScaleStore.put(getUrl(), this.mDefaultScale);
        }
        zoomWithPreview(this.mDefaultScale, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zoom2Overview(boolean z) {
        float viewWidth = getViewWidth() / this.mZoomOverviewWidth;
        if (z || Math.abs(this.mActualScale - viewWidth) >= MINIMUM_SCALE_INCREMENT) {
            this.mInZoomOverview = true;
            this.mZoomOutFlag = true;
            setZoomState(ZoomState.ZoomOverview);
            if (this.mScrollY < getTitleHeight()) {
                this.mScrollY = 0;
            }
            if (ifNeedStorePageScale()) {
                mZeusScaleStore.remove(getUrl());
            }
            zoomWithPreview(viewWidth, true);
            return true;
        }
        return false;
    }

    private void overrideLoading(String str) {
        this.mCallbackProxy.uiOverrideUrlLoading(str);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, Rect rect) {
        boolean z;
        int i2;
        if (inEditingMode()) {
            if (this.mShowOwnEdit) {
                z = this.mEtText.requestFocus(i, rect);
            } else {
                z = this.mWebTextView.requestFocus(i, rect);
            }
        } else {
            boolean requestFocus = super.requestFocus(i, rect);
            if (this.mWebViewCore.getSettings().getNeedInitialFocus()) {
                switch (i) {
                    case 17:
                        i2 = 21;
                        break;
                    case 33:
                        i2 = 19;
                        break;
                    case BDLocation.TypeOffLineLocation /* 66 */:
                        i2 = 22;
                        break;
                    case FIRST_LAYOUT_MSG_ID /* 130 */:
                        i2 = 20;
                        break;
                    default:
                        return requestFocus;
                }
                if (this.mNativeClass != 0 && !nativeHasCursorNode()) {
                    navHandledKey(i2, 1, true, 0L);
                }
            }
            z = requestFocus;
        }
        return z;
    }

    @Override // android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i);
        int contentToViewDimension = contentToViewDimension(this.mContentHeight);
        int contentToViewDimension2 = contentToViewDimension(this.mContentWidth);
        if (mode != 1073741824) {
            this.mHeightCanMeasure = true;
            if (mode != Integer.MIN_VALUE || contentToViewDimension <= size) {
                size = contentToViewDimension;
            } else {
                this.mHeightCanMeasure = false;
            }
        } else {
            this.mHeightCanMeasure = false;
        }
        if (this.mNativeClass != 0) {
            nativeSetHeightCanMeasure(this.mHeightCanMeasure);
        }
        if (mode2 == 0) {
            this.mWidthCanMeasure = true;
            i3 = contentToViewDimension2;
        } else {
            this.mWidthCanMeasure = false;
            i3 = size2;
        }
        synchronized (this) {
            setMeasuredDimension(i3, size);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        int i;
        int i2;
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        Rect rect2 = new Rect(viewToContentX(this.mScrollX), viewToContentY(this.mScrollY), viewToContentX((this.mScrollX + getWidth()) - getVerticalScrollbarWidth()), viewToContentY(this.mScrollY + getViewHeightWithTitle()));
        if (!this.mContentHeightChanged) {
            rect2 = nativeSubtractLayers(rect2);
        }
        if (rect2.isEmpty()) {
            return false;
        }
        int contentToViewY = contentToViewY(rect2.top);
        int contentToViewY2 = contentToViewY(rect2.bottom);
        int i3 = contentToViewY2 - contentToViewY;
        if (rect.bottom > contentToViewY2) {
            int i4 = i3 / 3;
            if (rect.height() > i4 * 2) {
                i = rect.top - contentToViewY;
            } else {
                i = rect.top - (contentToViewY + i4);
            }
        } else {
            i = rect.top < contentToViewY ? rect.top - contentToViewY : 0;
        }
        int contentToViewX = contentToViewX(rect2.left);
        int contentToViewX2 = contentToViewX(rect2.right);
        int i5 = contentToViewX2 - contentToViewX;
        if (rect.right > contentToViewX2 && rect.left > contentToViewX) {
            if (rect.width() > i5) {
                i2 = (rect.left - contentToViewX) + 0;
            } else {
                i2 = (rect.right - contentToViewX2) + 0;
            }
        } else {
            i2 = rect.left < contentToViewX ? 0 - (contentToViewX - rect.left) : 0;
        }
        if ((i | i2) != 0) {
            return pinScrollBy(i2, i, !z, 0);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void replaceTextfieldText(int i, int i2, String str, int i3, int i4) {
        WebViewCore.ReplaceTextData replaceTextData = new WebViewCore.ReplaceTextData();
        replaceTextData.mReplace = str;
        replaceTextData.mNewStart = i3;
        replaceTextData.mNewEnd = i4;
        this.mTextGeneration++;
        replaceTextData.mTextGeneration = this.mTextGeneration;
        this.mWebViewCore.sendMessage(LONG_PRESS_CENTER, i, i2, replaceTextData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void passToJavaScript(String str, KeyEvent keyEvent) {
        WebViewCore.JSKeyData jSKeyData = new WebViewCore.JSKeyData();
        jSKeyData.mEvent = keyEvent;
        jSKeyData.mCurrentText = str;
        this.mTextGeneration++;
        this.mWebViewCore.sendMessage(PREVENT_TOUCH_ID, this.mTextGeneration, 0, jSKeyData);
        this.mWebViewCore.removeMessages(128);
        this.mWebViewCore.sendMessageDelayed(128, cursorData(), 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized WebViewCore getWebViewCore() {
        return this.mWebViewCore;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class QueuedTouch {
        MotionEvent mEvent;
        QueuedTouch mNext;
        long mSequence;
        WebViewCore.TouchEventData mTed;

        private QueuedTouch() {
        }

        public QueuedTouch set(WebViewCore.TouchEventData touchEventData) {
            this.mSequence = touchEventData.mSequence;
            this.mTed = touchEventData;
            this.mEvent = null;
            this.mNext = null;
            return this;
        }

        public QueuedTouch set(MotionEvent motionEvent, long j) {
            this.mEvent = MotionEvent.obtain(motionEvent);
            this.mSequence = j;
            this.mTed = null;
            this.mNext = null;
            return this;
        }

        public QueuedTouch add(QueuedTouch queuedTouch) {
            if (queuedTouch.mSequence < this.mSequence) {
                queuedTouch.mNext = this;
                return queuedTouch;
            }
            QueuedTouch queuedTouch2 = this;
            while (queuedTouch2.mNext != null && queuedTouch2.mNext.mSequence < queuedTouch.mSequence) {
                queuedTouch2 = queuedTouch2.mNext;
            }
            queuedTouch.mNext = queuedTouch2.mNext;
            queuedTouch2.mNext = queuedTouch;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class TouchEventQueue {
        private static final int MAX_RECYCLED_QUEUED_TOUCH = 15;
        private static final int QUEUED_GESTURE_TIMEOUT = 1000;
        private long mIgnoreUntilSequence;
        private long mLastEventTime;
        private long mLastHandledTouchSequence;
        private long mNextTouchSequence;
        private QueuedTouch mPreQueue;
        private QueuedTouch mQueuedTouchRecycleBin;
        private int mQueuedTouchRecycleCount;
        private QueuedTouch mTouchEventQueue;

        private TouchEventQueue() {
            this.mNextTouchSequence = -9223372036854775807L;
            this.mLastHandledTouchSequence = Long.MIN_VALUE;
            this.mIgnoreUntilSequence = -9223372036854775807L;
            this.mLastEventTime = Long.MAX_VALUE;
        }

        private QueuedTouch obtainQueuedTouch() {
            if (this.mQueuedTouchRecycleBin != null) {
                QueuedTouch queuedTouch = this.mQueuedTouchRecycleBin;
                this.mQueuedTouchRecycleBin = queuedTouch.mNext;
                this.mQueuedTouchRecycleCount--;
                return queuedTouch;
            }
            return new QueuedTouch();
        }

        public void ignoreCurrentlyMissingEvents() {
            this.mIgnoreUntilSequence = this.mNextTouchSequence;
            runQueuedAndPreQueuedEvents();
        }

        private void runQueuedAndPreQueuedEvents() {
            QueuedTouch queuedTouch = this.mPreQueue;
            boolean z = true;
            while (queuedTouch != null && queuedTouch.mSequence == this.mLastHandledTouchSequence + 1) {
                handleQueuedTouch(queuedTouch);
                if (z) {
                    this.mPreQueue = queuedTouch.mNext;
                } else {
                    this.mTouchEventQueue = queuedTouch.mNext;
                }
                recycleQueuedTouch(queuedTouch);
                this.mLastHandledTouchSequence++;
                z = (this.mPreQueue != null ? this.mPreQueue.mSequence : Long.MAX_VALUE) < (this.mTouchEventQueue != null ? this.mTouchEventQueue.mSequence : Long.MAX_VALUE);
                queuedTouch = z ? this.mPreQueue : this.mTouchEventQueue;
            }
        }

        public void preQueueTouchEventData(WebViewCore.TouchEventData touchEventData) {
            QueuedTouch queuedTouch = obtainQueuedTouch().set(touchEventData);
            if (this.mPreQueue == null) {
                this.mPreQueue = queuedTouch;
                return;
            }
            QueuedTouch queuedTouch2 = this.mPreQueue;
            while (queuedTouch2.mNext != null && queuedTouch2.mNext.mSequence < queuedTouch.mSequence) {
                queuedTouch2 = queuedTouch2.mNext;
            }
            queuedTouch.mNext = queuedTouch2.mNext;
            queuedTouch2.mNext = queuedTouch;
        }

        private void recycleQueuedTouch(QueuedTouch queuedTouch) {
            if (this.mQueuedTouchRecycleCount < 15) {
                queuedTouch.mNext = this.mQueuedTouchRecycleBin;
                this.mQueuedTouchRecycleBin = queuedTouch;
                this.mQueuedTouchRecycleCount++;
            }
        }

        public void reset() {
            this.mNextTouchSequence = -9223372036854775807L;
            this.mLastHandledTouchSequence = Long.MIN_VALUE;
            this.mIgnoreUntilSequence = -9223372036854775807L;
            while (this.mTouchEventQueue != null) {
                QueuedTouch queuedTouch = this.mTouchEventQueue;
                this.mTouchEventQueue = this.mTouchEventQueue.mNext;
                recycleQueuedTouch(queuedTouch);
            }
            while (this.mPreQueue != null) {
                QueuedTouch queuedTouch2 = this.mPreQueue;
                this.mPreQueue = this.mPreQueue.mNext;
                recycleQueuedTouch(queuedTouch2);
            }
        }

        public long nextTouchSequence() {
            long j = this.mNextTouchSequence;
            this.mNextTouchSequence = 1 + j;
            return j;
        }

        public boolean enqueueTouchEvent(WebViewCore.TouchEventData touchEventData) {
            QueuedTouch queuedTouch = this.mPreQueue;
            if (queuedTouch != null) {
                if (queuedTouch.mSequence != touchEventData.mSequence) {
                    while (true) {
                        if (queuedTouch.mNext == null) {
                            queuedTouch = null;
                            break;
                        } else if (queuedTouch.mNext.mSequence == touchEventData.mSequence) {
                            QueuedTouch queuedTouch2 = queuedTouch.mNext;
                            queuedTouch.mNext = queuedTouch2.mNext;
                            queuedTouch = queuedTouch2;
                            break;
                        } else {
                            queuedTouch = queuedTouch.mNext;
                        }
                    }
                } else {
                    this.mPreQueue = queuedTouch.mNext;
                }
            }
            if (touchEventData.mSequence >= this.mLastHandledTouchSequence && !dropStaleGestures(touchEventData.mMotionEvent, touchEventData.mSequence)) {
                runNextQueuedEvents();
                if (this.mLastHandledTouchSequence + 1 == touchEventData.mSequence) {
                    if (queuedTouch != null) {
                        recycleQueuedTouch(queuedTouch);
                    }
                    handleQueuedTouchEventData(touchEventData);
                    this.mLastHandledTouchSequence++;
                    runNextQueuedEvents();
                } else {
                    if (queuedTouch == null) {
                        queuedTouch = obtainQueuedTouch().set(touchEventData);
                    }
                    if (this.mTouchEventQueue != null) {
                        queuedTouch = this.mTouchEventQueue.add(queuedTouch);
                    }
                    this.mTouchEventQueue = queuedTouch;
                }
                return true;
            }
            return false;
        }

        public void enqueueTouchEvent(MotionEvent motionEvent) {
            long nextTouchSequence = nextTouchSequence();
            if (!dropStaleGestures(motionEvent, nextTouchSequence)) {
                runNextQueuedEvents();
                if (this.mLastHandledTouchSequence + 1 == nextTouchSequence) {
                    handleQueuedMotionEvent(motionEvent);
                    this.mLastHandledTouchSequence++;
                    runNextQueuedEvents();
                    return;
                }
                QueuedTouch queuedTouch = obtainQueuedTouch().set(motionEvent, nextTouchSequence);
                if (this.mTouchEventQueue != null) {
                    queuedTouch = this.mTouchEventQueue.add(queuedTouch);
                }
                this.mTouchEventQueue = queuedTouch;
            }
        }

        private void runNextQueuedEvents() {
            QueuedTouch queuedTouch = this.mTouchEventQueue;
            while (queuedTouch != null && queuedTouch.mSequence == this.mLastHandledTouchSequence + 1) {
                handleQueuedTouch(queuedTouch);
                QueuedTouch queuedTouch2 = queuedTouch.mNext;
                recycleQueuedTouch(queuedTouch);
                this.mLastHandledTouchSequence++;
                queuedTouch = queuedTouch2;
            }
            this.mTouchEventQueue = queuedTouch;
        }

        private boolean dropStaleGestures(MotionEvent motionEvent, long j) {
            if (motionEvent != null && motionEvent.getAction() == 2 && !WebView.this.mConfirmMove) {
                int round = (int) (Math.round(motionEvent.getX()) - WebView.this.mLastTouchX);
                int round2 = (int) (Math.round(motionEvent.getY()) - WebView.this.mLastTouchY);
                if ((round * round) + (round2 * round2) > WebView.this.mTouchSlopSquare) {
                    WebView.this.mPrivateHandler.removeMessages(3);
                    WebView.this.mPrivateHandler.removeMessages(4);
                    WebView.this.cancelLongPressDelay();
                }
            }
            if (this.mTouchEventQueue == null) {
                return j <= this.mLastHandledTouchSequence;
            }
            if (motionEvent != null && motionEvent.getAction() == 0 && motionEvent.getEventTime() > this.mLastEventTime + 1000) {
                Log.w(WebView.LOGTAG, "Got ACTION_DOWN but still waiting on stale event. Catching up.");
                runQueuedAndPreQueuedEvents();
                QueuedTouch queuedTouch = this.mTouchEventQueue;
                while (queuedTouch != null && queuedTouch.mSequence < j) {
                    QueuedTouch queuedTouch2 = queuedTouch.mNext;
                    recycleQueuedTouch(queuedTouch);
                    queuedTouch = queuedTouch2;
                }
                this.mTouchEventQueue = queuedTouch;
                this.mLastHandledTouchSequence = j - 1;
            }
            if (this.mIgnoreUntilSequence - 1 > this.mLastHandledTouchSequence) {
                QueuedTouch queuedTouch3 = this.mTouchEventQueue;
                while (queuedTouch3 != null && queuedTouch3.mSequence < this.mIgnoreUntilSequence) {
                    QueuedTouch queuedTouch4 = queuedTouch3.mNext;
                    recycleQueuedTouch(queuedTouch3);
                    queuedTouch3 = queuedTouch4;
                }
                this.mTouchEventQueue = queuedTouch3;
                this.mLastHandledTouchSequence = this.mIgnoreUntilSequence - 1;
            }
            if (this.mPreQueue != null) {
                QueuedTouch queuedTouch5 = this.mPreQueue;
                while (queuedTouch5 != null && queuedTouch5.mSequence < this.mIgnoreUntilSequence) {
                    QueuedTouch queuedTouch6 = queuedTouch5.mNext;
                    recycleQueuedTouch(queuedTouch5);
                    queuedTouch5 = queuedTouch6;
                }
                this.mPreQueue = queuedTouch5;
            }
            return j <= this.mLastHandledTouchSequence;
        }

        private void handleQueuedTouch(QueuedTouch queuedTouch) {
            if (queuedTouch.mTed != null) {
                handleQueuedTouchEventData(queuedTouch.mTed);
                return;
            }
            handleQueuedMotionEvent(queuedTouch.mEvent);
            queuedTouch.mEvent.recycle();
        }

        private void handleQueuedMotionEvent(MotionEvent motionEvent) {
            this.mLastEventTime = motionEvent.getEventTime();
            int action = motionEvent.getAction() & 255;
            if (motionEvent.getPointerCount() <= 1) {
                ScaleGestureDetector scaleGestureDetector = WebView.this.mScaleDetector;
                if (scaleGestureDetector != null && WebView.this.mPreventDefault != 3) {
                    scaleGestureDetector.onTouchEvent(motionEvent);
                }
                WebView.this.onTouchEvent(motionEvent);
                return;
            }
            Log.v(WebView.LOGTAG, "enter handleQueuedMotionEvent,handleMultiTouchInWebView doesn't exist");
        }

        private void handleQueuedTouchEventData(WebViewCore.TouchEventData touchEventData) {
            if (touchEventData.mMotionEvent != null) {
                this.mLastEventTime = touchEventData.mMotionEvent.getEventTime();
            }
            if (!touchEventData.mReprocess) {
                if (touchEventData.mAction == 0 && WebView.this.mPreventDefault == 1) {
                    WebView.this.mPreventDefault = touchEventData.mNativeResult ? 3 : 2;
                } else if (touchEventData.mAction == 2 && WebView.this.mPreventDefault == 2) {
                    WebView.this.mPreventDefault = touchEventData.mNativeResult ? 3 : 0;
                }
                if (WebView.this.mPreventDefault == 3) {
                    WebView.this.mTouchHighlightRegion.setEmpty();
                }
            } else if (!touchEventData.mNativeResult) {
                switch (touchEventData.mAction) {
                    case 0:
                        WebView.this.mLastDeferTouchX = touchEventData.mX;
                        WebView.this.mLastDeferTouchY = touchEventData.mY;
                        WebView.this.mDeferTouchMode = 1;
                        return;
                    case 1:
                    case 3:
                        if (WebView.this.mDeferTouchMode == 3) {
                            WebView.this.invalidate();
                            WebViewCore.resumePriority();
                            WebViewCore.resumeUpdatePicture(WebView.this.mWebViewCore);
                        }
                        WebView.this.mDeferTouchMode = 7;
                        return;
                    case 2:
                        int i = (int) touchEventData.mViewX;
                        int i2 = (int) touchEventData.mViewY;
                        if (WebView.this.mDeferTouchMode != 3) {
                            WebView.this.mDeferTouchMode = 3;
                            WebView.this.mLastDeferTouchX = i;
                            WebView.this.mLastDeferTouchY = i2;
                            WebView.this.startScrollingLayer(i, i2);
                            WebView.this.startDrag();
                        }
                        int pinLocX = WebView.this.pinLocX((int) ((WebView.this.mScrollX + WebView.this.mLastDeferTouchX) - i)) - WebView.this.mScrollX;
                        int pinLocY = WebView.this.pinLocY((int) ((WebView.this.mScrollY + WebView.this.mLastDeferTouchY) - i2)) - WebView.this.mScrollY;
                        Log.v(WebView.LOGTAG, "enter handleQueuedTouchEventData:ACTION_MOVE,ready to invoke doDrag");
                        WebView.this.doDrag(pinLocX, pinLocY);
                        if (pinLocX != 0) {
                            WebView.this.mLastDeferTouchX = i;
                        }
                        if (pinLocY != 0) {
                            WebView.this.mLastDeferTouchY = i2;
                            return;
                        }
                        return;
                    case 256:
                        HitTestResult hitTestResult = WebView.this.getHitTestResult();
                        if (hitTestResult != null && hitTestResult.mType != 0) {
                            WebView.this.performLongClick();
                        }
                        WebView.this.mDeferTouchMode = 7;
                        return;
                    case 512:
                        WebView.this.mLastDeferTouchX = touchEventData.mViewX;
                        WebView.this.mLastDeferTouchY = touchEventData.mViewY;
                        WebView.this.mDeferTouchMode = 7;
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class PrivateHandler extends Handler {
        PrivateHandler() {
        }

        /* JADX WARN: Removed duplicated region for block: B:118:0x05b9  */
        /* JADX WARN: Removed duplicated region for block: B:453:? A[RETURN, SYNTHETIC] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            float f;
            if (WebView.this.mWebViewCore != null) {
                switch (message.what) {
                    case 1:
                        WebView.this.mDatabase.setUsernamePassword(message.getData().getString("host"), message.getData().getString("username"), message.getData().getString("password"));
                        ((Message) message.obj).sendToTarget();
                        return;
                    case 2:
                        WebView.this.mDatabase.setUsernamePassword(message.getData().getString("host"), null, null);
                        ((Message) message.obj).sendToTarget();
                        return;
                    case 3:
                        if (WebView.this.mTouchMode == 1) {
                            if (WebView.this.mPreventDefault != 3) {
                                WebView.this.mTouchMode = 4;
                                WebView.this.updateSelection();
                                return;
                            }
                            WebView.this.mTouchMode = 5;
                            return;
                        } else if (WebView.this.mTouchMode == 6) {
                            WebView.this.mTouchMode = 7;
                            return;
                        } else {
                            return;
                        }
                    case 4:
                        if (!WebView.this.inFullScreenMode() && !WebView.this.mDeferTouchProcess) {
                            if (WebView.this.mPreventDefault != 3) {
                                if (!WebView.this.mSelectingText) {
                                    WebView.this.updateSelection();
                                    HitTestResult hitTestResult = WebView.this.getHitTestResult();
                                    if (hitTestResult != null) {
                                        WebView.this.performHapticFeedback(0);
                                        if (WebView.this.mEnableSelectText && 10 == hitTestResult.getType()) {
                                            WebView.this.mWebViewCore.sendMessage(402, WebView.this.viewToContentX(((int) WebView.this.mLastTouchX) + WebView.this.mScrollX), WebView.this.viewToContentY(((int) WebView.this.mLastTouchY) + WebView.this.mScrollY));
                                        } else if (WebView.this.getWebChromeClient() != null) {
                                            WebView.this.getWebChromeClient().PerformLongClick(WebView.this.mWebViewCore.getWebView(), hitTestResult.getType(), hitTestResult.getExtra(), hitTestResult.getExtra2(), (int) WebView.this.mLastTouchX, (int) WebView.this.mLastTouchY);
                                            if (WebView.this.mClickUrlPauseDraw) {
                                                WebView.this.mClickUrlPauseDraw = false;
                                                WebViewCore.resumeUpdatePicture(WebView.this.mWebViewCore);
                                            }
                                        }
                                    }
                                    WebView.this.mTouchMode = 7;
                                    WebView.this.performLongClick();
                                    return;
                                }
                                Log.e(WebView.LOGTAG, "no need to long press when selecting text");
                                return;
                            } else if (!WebView.this.isZeusPluginFullScreen && !WebView.this.getSettings().getFlashFullScreenMode()) {
                                WebViewCore.TouchEventData touchEventData = new WebViewCore.TouchEventData();
                                touchEventData.mAction = 256;
                                touchEventData.mIds = new int[1];
                                touchEventData.mIds[0] = 0;
                                touchEventData.mX = WebView.this.viewToContentX((int) (WebView.this.mLastTouchX + WebView.this.mScrollX));
                                touchEventData.mY = WebView.this.viewToContentY((int) (WebView.this.mLastTouchY + WebView.this.mScrollY));
                                touchEventData.mViewX = WebView.this.mLastTouchX;
                                touchEventData.mViewY = WebView.this.mLastTouchY;
                                touchEventData.mMetaState = 0;
                                touchEventData.mReprocess = WebView.this.mDeferTouchProcess;
                                touchEventData.mNativeLayer = 0;
                                touchEventData.mSequence = WebView.this.mTouchEventQueue.nextTouchSequence();
                                WebView.this.mTouchEventQueue.preQueueTouchEventData(touchEventData);
                                if (WebView.this.mDeferTouchProcess) {
                                    touchEventData.mViewX = WebView.this.mLastTouchX;
                                    touchEventData.mViewY = WebView.this.mLastTouchY;
                                }
                                WebView.this.mWebViewCore.sendMessage(WebView.ZEUS_PLUGIN_FULL_SCREEN_EXIT, touchEventData);
                                return;
                            } else {
                                return;
                            }
                        }
                        WebViewCore.TouchEventData touchEventData2 = new WebViewCore.TouchEventData();
                        touchEventData2.mAction = 256;
                        touchEventData2.mIds = new int[1];
                        touchEventData2.mIds[0] = 0;
                        touchEventData2.mX = WebView.this.viewToContentX((int) (WebView.this.mLastTouchX + WebView.this.mScrollX));
                        touchEventData2.mY = WebView.this.viewToContentY((int) (WebView.this.mLastTouchY + WebView.this.mScrollY));
                        touchEventData2.mViewX = WebView.this.mLastTouchX;
                        touchEventData2.mViewY = WebView.this.mLastTouchY;
                        touchEventData2.mMetaState = 0;
                        touchEventData2.mReprocess = WebView.this.mDeferTouchProcess;
                        touchEventData2.mNativeLayer = WebView.this.nativeScrollableLayer(touchEventData2.mX, touchEventData2.mY, touchEventData2.mNativeLayerRect, null);
                        touchEventData2.mSequence = WebView.this.mTouchEventQueue.nextTouchSequence();
                        WebView.this.mTouchEventQueue.preQueueTouchEventData(touchEventData2);
                        if (WebView.this.mDeferTouchProcess) {
                            touchEventData2.mViewX = WebView.this.mLastTouchX;
                            touchEventData2.mViewY = WebView.this.mLastTouchY;
                        }
                        WebView.this.mWebViewCore.sendMessage(WebView.ZEUS_PLUGIN_FULL_SCREEN_EXIT, touchEventData2);
                        return;
                    case 5:
                        WebView.this.doShortPress();
                        return;
                    case 6:
                        WebTextView.AutoCompleteAdapter autoCompleteAdapter = (WebTextView.AutoCompleteAdapter) message.obj;
                        if (WebView.this.mWebTextView.isSameTextField(message.arg1)) {
                            WebView.this.mWebTextView.setAdapterCustom(autoCompleteAdapter);
                            return;
                        }
                        return;
                    case 7:
                        WebViewCore.resumePriority();
                        WebViewCore.resumeUpdatePicture(WebView.this.mWebViewCore);
                        return;
                    case 8:
                        WebView.this.mHeldMotionless = 2;
                        WebView.this.invalidate();
                        if (WebView.this.mTouchMode != 3 && WebView.this.mHeldMotionless == 2) {
                            WebView.this.awakenScrollBars(ViewConfiguration.getScrollDefaultDelay(), false);
                            WebView.this.mPrivateHandler.sendMessageDelayed(WebView.this.mPrivateHandler.obtainMessage(9), ViewConfiguration.getScrollDefaultDelay());
                            return;
                        }
                        return;
                    case 9:
                        if (WebView.this.mTouchMode != 3) {
                            return;
                        }
                        return;
                    case 10:
                        if ((message.arg1 == 0 && WebView.this.mPreventDefault == 1) || (message.arg1 == 2 && WebView.this.mPreventDefault == 2)) {
                            WebView.this.cancelWebCoreTouchEvent(WebView.this.viewToContentX(((int) WebView.this.mLastTouchX) + WebView.this.mScrollX), WebView.this.viewToContentY(((int) WebView.this.mLastTouchY) + WebView.this.mScrollY), true);
                            return;
                        }
                        return;
                    case 11:
                        WebView.this.dismissListBox();
                        if (WebView.this.isOwnEditOn()) {
                            WebView.this.clearTextEntry(false);
                        }
                        boolean z = WebView.this.mPreviewZoomOnly;
                        if (WebView.this.mPreviewZoomOnly) {
                            WebViewCore.resumeUpdatePicture(WebView.this.mWebViewCore);
                            if (!WebKitInit.isVersionCanUseGL()) {
                                WebView.this.mViewManager.showAll();
                            }
                            WebView.this.mPreviewZoomOnly = false;
                            WebView.this.mAnchorX = WebView.this.viewToContentX(((int) WebView.this.mZoomCenterX) + WebView.this.mScrollX);
                            WebView.this.mAnchorY = WebView.this.viewToContentY(((int) WebView.this.mZoomCenterY) + WebView.this.mScrollY);
                            if (WebView.this.mActualScale - WebView.this.mMinZoomScale <= 0.01f || WebView.this.mActualScale <= 0.8d * WebView.this.mTextWrapScale) {
                            }
                            if (!WebView.this.mZoomOutFlag || WebView.this.mCurrentScale - WebView.this.mMinZoomScale <= 0.01f || WebView.this.mCurrentScale <= 0.8d * WebView.this.mTextWrapScale) {
                            }
                            if (WebView.this.ifNeedStorePageScale()) {
                                if (WebView.this.mCurrentScale - WebView.this.mMinZoomScale <= 0.01f) {
                                    WebView.mZeusScaleStore.remove(WebView.this.getUrl());
                                } else {
                                    WebView.mZeusScaleStore.put(WebView.this.getUrl(), WebView.this.mCurrentScale);
                                }
                            }
                            WebView.this.setNewZoomScale(WebView.this.mCurrentScale, true, true);
                            WebView.this.setContentChangeState(0);
                            WebView.this.invalidate();
                        }
                        WebView.this.mZoomEndFlag = true;
                        WebView.this.mZoomFlag = 0;
                        WebView.this.mCurrentScale = WebView.this.mActualScale;
                        WebView.this.mFlag = 1;
                        WebView.this.mDragFinish = 1;
                        WebView.this.mCaptureFlag = false;
                        WebView.this.mScrollZoomScaleFlag = false;
                        if (z) {
                            WebView.this.captureScalePic();
                        }
                        WebView.this.mZoomWhenScrolling = false;
                        WebView.this.mPreviewZoomOnly = false;
                        return;
                    case 12:
                        ((InputMethodManager) WebView.this.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
                        return;
                    case 13:
                        if (WebView.this.mSplitContentCnt > 10) {
                            if (WebView.this.mWebViewCore != null) {
                                WebView.this.mWebViewCore.SplitContent();
                            }
                            WebView.this.mSplitContentCnt = 0;
                            return;
                        }
                        return;
                    case 14:
                        WebViewCore.resumeUpdatePicture(WebView.this.mWebViewCore);
                        return;
                    case 15:
                        if (WebView.this.mAutoScrollX != 0 || WebView.this.mAutoScrollY != 0) {
                            if (WebView.this.mScrollingLayer == 0) {
                                WebView.this.pinScrollBy(WebView.this.mAutoScrollX, WebView.this.mAutoScrollY, true, 0);
                            } else {
                                WebView.this.mScrollingLayerRect.left += WebView.this.mAutoScrollX;
                                WebView.this.mScrollingLayerRect.top += WebView.this.mAutoScrollY;
                                WebView.this.nativeScrollLayer(WebView.this.mScrollingLayer, WebView.this.mScrollingLayerRect.left, WebView.this.mScrollingLayerRect.top);
                                WebView.this.invalidate();
                            }
                            sendEmptyMessageDelayed(15, WebView.SELECT_SCROLL_INTERVAL);
                            return;
                        }
                        WebView.this.mSentAutoScrollMessage = false;
                        return;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case DERTags.IA5_STRING /* 22 */:
                    case DERTags.UTC_TIME /* 23 */:
                    case 24:
                    case DERTags.GRAPHIC_STRING /* 25 */:
                    case DERTags.VISIBLE_STRING /* 26 */:
                    case DERTags.GENERAL_STRING /* 27 */:
                    case DERTags.UNIVERSAL_STRING /* 28 */:
                    case 29:
                    case DERTags.BMP_STRING /* 30 */:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case WebView.TEMP_SUBJECT_WIDTH_ADJUST /* 40 */:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                    case WebView.TOUCH_SENT_INTERVAL /* 50 */:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case BDLocation.TypeGpsLocation /* 61 */:
                    case BDLocation.TypeCriteriaException /* 62 */:
                    case BDLocation.TypeNetWorkException /* 63 */:
                    case DERTags.APPLICATION /* 64 */:
                    case BDLocation.TypeCacheLocation /* 65 */:
                    case BDLocation.TypeOffLineLocation /* 66 */:
                    case BDLocation.TypeOffLineLocationFail /* 67 */:
                    case BDLocation.TypeOffLineLocationNetworkFail /* 68 */:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                    case 78:
                    case 79:
                    case 80:
                    case 81:
                    case 82:
                    case 83:
                    case 84:
                    case 85:
                    case 86:
                    case 87:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 96:
                    case 97:
                    case 98:
                    case 99:
                    case 100:
                    default:
                        super.handleMessage(message);
                        return;
                    case WebChromeClient.STRING_DLG_TITLE_DATETIME /* 101 */:
                        if (!WebView.this.setContentScrollTo(message.arg1, message.arg2)) {
                            WebView.this.mUserScroll = false;
                            WebView.this.mWebViewCore.sendMessage(WebView.FOCUSED_INPUT_BOUNDS_CHANGED, message.arg1, message.arg2);
                            return;
                        }
                        return;
                    case 102:
                        WebView.this.setContentScrollBy(message.arg1, message.arg2, ((Boolean) message.obj).booleanValue());
                        return;
                    case 103:
                        WebView.this.spawnContentScrollTo(message.arg1, message.arg2);
                        return;
                    case 104:
                        if (WebView.this.mUserScroll) {
                            WebView.this.mUserScroll = false;
                            return;
                        }
                        if (!WebView.this.setContentScrollTo(message.arg1, message.arg2)) {
                        }
                        break;
                    case 105:
                        if (WebView.this.mDelayedDeleteRootLayer) {
                            WebView.this.mDelayedDeleteRootLayer = false;
                            WebView.this.nativeSetRootLayer(0);
                        }
                        WebSettings settings = WebView.this.mWebViewCore.getSettings();
                        int viewWidth = WebView.this.getViewWidth();
                        WebViewCore.DrawData drawData = (WebViewCore.DrawData) message.obj;
                        Point point = drawData.mViewPoint;
                        WebView.this.setBaseLayer(drawData.mBaseLayer, drawData.mInvalRegion, false, drawData.mUpdateViewPort, false);
                        boolean useWideViewPort = settings.getUseWideViewPort();
                        WebViewCore.RestoreState restoreState = drawData.mRestoreState;
                        boolean z2 = restoreState != null;
                        if (z2) {
                            WebView.this.updateZoomRange(restoreState, point.x, drawData.mMinPrefWidth, true);
                            if (!WebView.this.mDrawHistory) {
                                WebView.this.mInZoomOverview = false;
                                WebView.this.mInitViewScale = restoreState.mViewScale;
                                if (WebView.this.mInitialScaleInPercent > 0) {
                                    WebView.this.setNewZoomScale(WebView.this.mInitialScaleInPercent / 100.0f, ((float) WebView.this.mInitialScaleInPercent) != WebView.this.mTextWrapScale * 100.0f, false);
                                } else if (restoreState.mViewScale > 0.0f) {
                                    WebView.this.mTextWrapScale = restoreState.mTextWrapScale;
                                    float f2 = WebView.this.ifNeedStorePageScale() ? WebView.mZeusScaleStore.get(WebView.this.getUrl()) : 0.0f;
                                    if (f2 == 0.0f) {
                                        WebView.this.setNewZoomScale(restoreState.mViewScale, false, false);
                                    } else {
                                        WebView.this.setNewZoomScale(f2, true, false);
                                    }
                                } else {
                                    if (!WebView.this.isWapPage()) {
                                        WebView.this.mInZoomOverview = useWideViewPort && settings.getLoadWithOverviewMode();
                                    } else {
                                        WebView.this.mInZoomOverview = false;
                                    }
                                    if (WebView.this.mInZoomOverview) {
                                        f = viewWidth / 800.0f;
                                    } else {
                                        f = restoreState.mTextWrapScale;
                                    }
                                    WebView.this.setNewZoomScale(f, Math.abs(f - WebView.this.mTextWrapScale) >= WebView.MINIMUM_SCALE_INCREMENT, false);
                                }
                                WebView.this.setContentScrollTo(restoreState.mScrollX, restoreState.mScrollY);
                                WebView.this.clearTextEntry(false);
                                if (WebView.this.getSettings().getBuiltInZoomControls()) {
                                    WebView.this.updateZoomButtonsEnabled();
                                }
                            }
                        }
                        WebView.this.recordNewContentSize(drawData.mWidthHeight.x, (WebView.this.mContentHeightChanged ? WebView.this.mContentHeightAdded : 0) + drawData.mWidthHeight.y + (WebView.this.mFindIsUp ? WebView.this.mFindHeight : 0), point.x == WebView.this.mLastWidthSent && point.y == WebView.this.mLastHeightSent);
                        WebView.this.invalidateContentRect(drawData.mInvalRegion.getBounds());
                        if (WebView.this.mPictureListener != null) {
                            WebView.this.mPictureListener.onNewPicture(WebView.this, WebView.this.capturePicture());
                        }
                        if (useWideViewPort) {
                            WebView.this.mZoomOverviewWidth = Math.min(WebView.sMaxViewportWidth, Math.max((int) (viewWidth / WebView.this.mDefaultScale), Math.max(drawData.mMinPrefWidth, drawData.mViewPoint.x)));
                        }
                        if (!WebView.this.mMinZoomScaleFixed) {
                            WebView.this.mMinZoomScale = viewWidth / WebView.this.mZoomOverviewWidth;
                        }
                        if (!WebView.this.mDrawHistory && WebView.this.mInZoomOverview) {
                            float f3 = WebView.this.getSettings().useScaleStore() ? WebView.mZeusScaleStore.get(WebView.this.getUrl()) : 0.0f;
                            if (f3 == 0.0f) {
                                if (Math.abs((viewWidth * WebView.this.mInvActualScale) - WebView.this.mZoomOverviewWidth) > 1.0f) {
                                    WebView.this.setNewZoomScale(viewWidth / WebView.this.mZoomOverviewWidth, Math.abs(WebView.this.mActualScale - WebView.this.mTextWrapScale) < WebView.MINIMUM_SCALE_INCREMENT, false);
                                }
                            } else if (f3 != WebView.this.mActualScale) {
                                WebView.this.setNewZoomScale(f3, Math.abs(WebView.this.mActualScale - WebView.this.mTextWrapScale) < WebView.MINIMUM_SCALE_INCREMENT, false);
                            }
                        }
                        if (drawData.mFocusSizeChanged && WebView.this.inEditingMode()) {
                            WebView.this.mFocusSizeChanged = true;
                        }
                        if (z2) {
                            WebView.this.mViewManager.postReadyToDrawAll();
                            return;
                        }
                        return;
                    case WebView.UPDATE_TEXT_ENTRY_MSG_ID /* 106 */:
                        WebView.this.selectionDone();
                        if (WebView.this.inEditingMode() && WebView.this.nativeCursorIsTextInput()) {
                            WebView.this.mWebTextView.bringIntoView();
                            WebView.this.rebuildWebTextView();
                            return;
                        }
                        return;
                    case WebView.WEBCORE_INITIALIZED_MSG_ID /* 107 */:
                        WebView.this.nativeCreate(message.arg1);
                        WebView.this.setNativeBigPluginView();
                        return;
                    case WebView.UPDATE_TEXTFIELD_TEXT_MSG_ID /* 108 */:
                        if (WebView.this.inEditingMode() && WebView.this.mWebTextView.isSameTextField(message.arg1)) {
                            if (message.getData().getBoolean("password")) {
                                Editable text = WebView.this.mWebTextView.getText();
                                int selectionStart = Selection.getSelectionStart(text);
                                int selectionEnd = Selection.getSelectionEnd(text);
                                WebView.this.mWebTextView.setInPassword(true);
                                Selection.setSelection(WebView.this.mWebTextView.getText(), selectionStart, selectionEnd);
                                return;
                            } else if (message.arg2 == WebView.this.mTextGeneration) {
                                WebView.this.mWebTextView.setTextAndKeepSelection((String) message.obj);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    case WebView.UPDATE_ZOOM_RANGE /* 109 */:
                        WebViewCore.RestoreState restoreState2 = (WebViewCore.RestoreState) message.obj;
                        WebView.this.updateZoomRange(restoreState2, WebView.this.getViewWidth(), restoreState2.mScrollX, false);
                        return;
                    case WebView.MOVE_OUT_OF_PLUGIN /* 110 */:
                        WebView.this.navHandledKey(message.arg1, 1, false, 0L);
                        return;
                    case WebView.CLEAR_TEXT_ENTRY /* 111 */:
                        WebView.this.clearTextEntry(false);
                        return;
                    case WebView.UPDATE_TEXT_SELECTION_MSG_ID /* 112 */:
                        WebView.this.rebuildWebTextView();
                        WebView.this.updateTextSelectionFromMessage(message.arg1, message.arg2, (WebViewCore.TextSelectionData) message.obj);
                        return;
                    case WebView.SHOW_RECT_MSG_ID /* 113 */:
                        WebViewCore.ShowRectData showRectData = (WebViewCore.ShowRectData) message.obj;
                        int i = WebView.this.mScrollX;
                        int contentToViewX = WebView.this.contentToViewX(showRectData.mLeft);
                        int contentToViewDimension = WebView.this.contentToViewDimension(showRectData.mWidth);
                        int contentToViewDimension2 = WebView.this.contentToViewDimension(showRectData.mContentWidth);
                        int viewWidth2 = WebView.this.getViewWidth();
                        int max = Math.max(0, Math.min(contentToViewDimension2, (contentToViewDimension < viewWidth2 ? i + (((contentToViewX + (contentToViewDimension / 2)) - WebView.this.mScrollX) - (viewWidth2 / 2)) : i + ((int) (((contentToViewX + (contentToViewDimension * showRectData.mXPercentInDoc)) - WebView.this.mScrollX) - (showRectData.mXPercentInView * viewWidth2)))) + viewWidth2) - viewWidth2);
                        int contentToViewY = WebView.this.contentToViewY(showRectData.mTop);
                        int contentToViewDimension3 = WebView.this.contentToViewDimension(showRectData.mHeight);
                        int contentToViewDimension4 = WebView.this.contentToViewDimension(showRectData.mContentHeight);
                        int viewHeight = WebView.this.getViewHeight();
                        int max2 = Math.max(0, Math.max(0, Math.min(contentToViewDimension4, ((int) ((contentToViewY + (contentToViewDimension3 * showRectData.mYPercentInDoc)) - (showRectData.mYPercentInView * viewHeight))) + viewHeight) - viewHeight) - WebView.this.getVisibleTitleHeight());
                        if (WebView.this.mZoomState != ZoomState.ZoomBlock) {
                            WebView.this.scrollTo(max, max2);
                            return;
                        }
                        return;
                    case WebView.LONG_PRESS_CENTER /* 114 */:
                        WebView.this.mGotCenterDown = false;
                        WebView.this.mTrackballDown = false;
                        WebView.this.performLongClick();
                        return;
                    case WebView.PREVENT_TOUCH_ID /* 115 */:
                        if (!WebView.this.inFullScreenMode()) {
                            if (message.obj == null) {
                                if (message.arg1 == 0 && WebView.this.mPreventDefault == 1) {
                                    WebView.this.mPreventDefault = message.arg2 == 1 ? 3 : 2;
                                    return;
                                } else if (message.arg1 == 2 && WebView.this.mPreventDefault == 2) {
                                    WebView.this.mPreventDefault = message.arg2 != 1 ? 0 : 3;
                                    return;
                                } else {
                                    return;
                                }
                            } else if (message.arg2 == 0) {
                                WebViewCore.TouchEventData touchEventData3 = (WebViewCore.TouchEventData) message.obj;
                                switch (touchEventData3.mAction) {
                                    case 0:
                                        WebView.this.mLastDeferTouchX = touchEventData3.mViewX;
                                        WebView.this.mLastDeferTouchY = touchEventData3.mViewY;
                                        WebView.this.mDeferTouchMode = 1;
                                        return;
                                    case 1:
                                    case 3:
                                        if (WebView.this.mDeferTouchMode == 3) {
                                            WebView.this.invalidate();
                                            WebViewCore.resumePriority();
                                            WebViewCore.resumeUpdatePicture(WebView.this.mWebViewCore);
                                        }
                                        WebView.this.mDeferTouchMode = 7;
                                        return;
                                    case 2:
                                        if (WebView.this.mDeferTouchMode != 3) {
                                            WebView.this.mDeferTouchMode = 3;
                                            WebView.this.mLastDeferTouchX = touchEventData3.mViewX;
                                            WebView.this.mLastDeferTouchY = touchEventData3.mViewY;
                                            WebView.this.startDrag();
                                        }
                                        int pinLocX = WebView.this.pinLocX((int) ((WebView.this.mScrollX + WebView.this.mLastDeferTouchX) - touchEventData3.mViewX)) - WebView.this.mScrollX;
                                        int pinLocY = WebView.this.pinLocY((int) ((WebView.this.mScrollY + WebView.this.mLastDeferTouchY) - touchEventData3.mViewY)) - WebView.this.mScrollY;
                                        WebView.this.doDrag(pinLocX, pinLocY);
                                        if (pinLocX != 0) {
                                            WebView.this.mLastDeferTouchX = touchEventData3.mViewX;
                                        }
                                        if (pinLocY != 0) {
                                            WebView.this.mLastDeferTouchY = touchEventData3.mViewY;
                                            return;
                                        }
                                        return;
                                    case 256:
                                        HitTestResult hitTestResult2 = WebView.this.getHitTestResult();
                                        if (hitTestResult2 != null && hitTestResult2.mType != 0) {
                                            WebView.this.performLongClick();
                                            WebView.this.rebuildWebTextView();
                                        }
                                        WebView.this.mDeferTouchMode = 7;
                                        return;
                                    case 512:
                                        WebView.this.mLastTouchX = touchEventData3.mViewX;
                                        WebView.this.mLastTouchY = touchEventData3.mViewY;
                                        WebView.this.doDoubleTap();
                                        WebView.this.mDeferTouchMode = 7;
                                        return;
                                    default:
                                        return;
                                }
                            } else {
                                return;
                            }
                        }
                        return;
                    case WebView.WEBCORE_NEED_TOUCH_EVENTS /* 116 */:
                        WebView.this.mForwardTouchEvents = message.arg1 != 0;
                        return;
                    case WebView.INVAL_RECT_MSG_ID /* 117 */:
                        Rect rect = (Rect) message.obj;
                        if (rect != null) {
                            WebView.this.viewInvalidate(rect.left, rect.top, rect.right, rect.bottom);
                            return;
                        } else {
                            WebView.this.invalidate();
                            return;
                        }
                    case WebView.REQUEST_KEYBOARD /* 118 */:
                        if (message.arg1 == 0) {
                            WebView.this.hideSoftKeyboard();
                            return;
                        } else {
                            WebView.this.displaySoftKeyboard(false);
                            return;
                        }
                    case WebView.DO_MOTION_UP /* 119 */:
                        WebView.this.doMotionUp(message.arg1, message.arg2, ((Boolean) message.obj).booleanValue());
                        return;
                    case WebView.SHOW_FULLSCREEN /* 120 */:
                        View view = (View) message.obj;
                        int i2 = message.arg1;
                        int i3 = message.arg2;
                        if (WebView.this.inFullScreenMode()) {
                            Log.w(WebView.LOGTAG, "Should not have another full screen.");
                            WebView.this.dismissFullScreenMode();
                        }
                        WebView.this.mFullScreenHolder = new PluginFullScreenHolder(WebView.this, i3);
                        WebView.this.mFullScreenHolder.setContentView(view);
                        WebView.this.mFullScreenHolder.setCancelable(false);
                        WebView.this.mFullScreenHolder.setCanceledOnTouchOutside(false);
                        WebView.this.mFullScreenHolder.show();
                        return;
                    case WebView.HIDE_FULLSCREEN /* 121 */:
                        WebView.this.dismissFullScreenMode();
                        return;
                    case WebView.DOM_FOCUS_CHANGED /* 122 */:
                        if (WebView.this.inEditingMode()) {
                            WebView.this.nativeClearCursor();
                            WebView.this.mDisplaySoftKeyboard = true;
                            WebView.this.rebuildWebTextView();
                            WebView.this.mDisplaySoftKeyboard = false;
                            return;
                        }
                        return;
                    case WebView.IMMEDIATE_REPAINT_MSG_ID /* 123 */:
                        WebView.this.invalidate();
                        return;
                    case WebView.SET_ROOT_LAYER_MSG_ID /* 124 */:
                        if (message.arg1 == 0) {
                            WebView.this.mDelayedDeleteRootLayer = true;
                            return;
                        }
                        WebView.this.mDelayedDeleteRootLayer = false;
                        WebView.this.nativeSetRootLayer(message.arg1);
                        WebView.this.invalidate();
                        return;
                    case WebView.RETURN_LABEL /* 125 */:
                        if (WebView.this.inEditingMode() && WebView.this.mWebTextView.isSameTextField(message.arg1)) {
                            InputMethodManager peekInstance = InputMethodManager.peekInstance();
                            if (WebView.this.mShowOwnEdit) {
                                if (peekInstance != null && peekInstance.isActive(WebView.this.mEtText)) {
                                    peekInstance.restartInput(WebView.this.mEtText);
                                    return;
                                }
                                return;
                            } else if (peekInstance != null && peekInstance.isActive(WebView.this.mWebTextView)) {
                                peekInstance.restartInput(WebView.this.mWebTextView);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    case WebView.FIND_AGAIN /* 126 */:
                        if (WebView.this.mFindIsUp) {
                            WebView.this.findAll(WebView.this.mLastFind);
                            return;
                        }
                        return;
                    case WebView.CENTER_FIT_RECT /* 127 */:
                        Rect rect2 = (Rect) message.obj;
                        WebView.this.mInZoomOverview = false;
                        WebView.this.centerFitRect(rect2.left, rect2.top, rect2.width(), rect2.height());
                        return;
                    case 128:
                        WebView.this.displaySoftKeyboard(true);
                        WebView.this.updateTextSelectionFromMessage(message.arg1, message.arg2, (WebViewCore.TextSelectionData) message.obj);
                        return;
                    case 129:
                        WebView.this.mHorizontalScrollBarMode = message.arg1;
                        WebView.this.mVerticalScrollBarMode = message.arg2;
                        return;
                    case WebView.FIRST_LAYOUT_MSG_ID /* 130 */:
                        WebView.this.mCurrentUrl = (String) message.obj;
                        WebView.this.mDidFirstLayout = true;
                        return;
                    case WebView.FOCUSED_INPUT_BOUNDS_CHANGED /* 131 */:
                        WebViewCore.RequestKeyboardData requestKeyboardData = (WebViewCore.RequestKeyboardData) message.obj;
                        if (requestKeyboardData != null) {
                            WebView.this.mFocusedInputBoundsChanged = true;
                            if (WebView.this.inEditingMode()) {
                                WebView.this.rebuildWebTextView(requestKeyboardData.mBounds, requestKeyboardData.mText);
                            }
                            WebView.this.mFocusedInputBoundsChanged = false;
                            return;
                        }
                        return;
                    case WebView.SEND_CAPTURE_SCALE_PIC /* 132 */:
                        WebView.this.captureScalePic();
                        WebView.this.nativeRefreshControls();
                        WebView.this.invalidate();
                        return;
                    case WebView.REQUEST_KEYBOARD_WITH_SELECTION_EXT /* 133 */:
                        WebView.this.dismissListBox();
                        WebViewCore.RequestKeyboardData requestKeyboardData2 = (WebViewCore.RequestKeyboardData) message.obj;
                        if (requestKeyboardData2 != null) {
                            WebView.this.displaySoftKeyboard(true, requestKeyboardData2.mBounds, requestKeyboardData2.mText);
                            WebView.this.updateTextSelectionFromMessage(message.arg1, message.arg2, requestKeyboardData2.mSelData);
                            return;
                        }
                        return;
                    case WebView.SET_TOUCH_HIGHLIGHT_RECTS /* 134 */:
                        WebView.this.setTouchHighlightRects((ArrayList) message.obj);
                        return;
                    case WebView.ZEUS_QUICK_CLICK /* 135 */:
                        WebView.this.nativeSetCachedNodeFocusFromPt(message.arg1, message.arg2, WebView.this.viewToContentDimension(WebView.this.mNavSlop));
                        WebView.this.invalidate();
                        return;
                    case WebView.ZEUS_LONG_PRESS /* 136 */:
                        if (WebView.this.mEnableSelectText && message.arg1 == 1) {
                            WebView.this.showMagnifier((int) WebView.this.mLastTouchX, (int) WebView.this.mLastTouchY, (int) WebView.this.mLastTouchX, (int) WebView.this.mLastTouchY, true);
                            WebView.this.invalidate();
                            return;
                        } else if (WebView.this.getWebChromeClient() != null) {
                            WebView.this.getWebChromeClient().PerformLongClick(WebView.this.mWebViewCore.getWebView(), 0, null, null, (int) WebView.this.mLastTouchX, (int) WebView.this.mLastTouchY);
                            return;
                        } else {
                            return;
                        }
                    case WebView.ZEUS_GET_SELECTION_DONE /* 137 */:
                        String str = (String) message.obj;
                        if (WebView.this.mCopyingSth) {
                            WebView.this.copySelectionPrivate(str);
                            WebView.this.mCopyingSth = false;
                            return;
                        }
                        WebView.this.showSelectionActionDialogPrivate(str);
                        return;
                    case WebView.ZEUS_HIDE_CURSOR /* 138 */:
                        WebView.this.nativeClearCursor();
                        return;
                    case WebView.ZEUS_ENG_WORD_SELECTION_RESULT /* 139 */:
                        Rect rect3 = (Rect) message.obj;
                        if (rect3 != null) {
                            if (WebView.this.nativeEngWordSelection(WebView.this.viewToContentX(((int) WebView.this.mLastTouchX) + WebView.this.mScrollX), WebView.this.viewToContentY(((int) WebView.this.mLastTouchY) + WebView.this.mScrollY), rect3.left, rect3.top, rect3.right, rect3.bottom)) {
                                WebView.this.mNeedToShowSelectionActionDialog = true;
                                WebView.this.invalidate();
                                return;
                            }
                            return;
                        }
                        return;
                    case WebView.ZEUS_PLUGIN_FULL_SCREEN_ENTER /* 140 */:
                        WebView.this.isZeusPluginFullScreen = true;
                        return;
                    case WebView.ZEUS_PLUGIN_FULL_SCREEN_EXIT /* 141 */:
                        WebView.this.isZeusPluginFullScreen = false;
                        return;
                    case WebView.SEND_ON_SUBJECT_CLICK /* 142 */:
                        WebView.this.sendSubjectOnClick((String) message.obj, "text/html", BdUtil.UTF8);
                        return;
                    case WebView.SET_HAS_PLUGIN /* 143 */:
                        WebView.this.setHasPlugin(true);
                        return;
                    case WebView.SET_IS_MOBILE_SITE_ZEUS /* 144 */:
                        WebView.this.setIsMobileSiteZeusFlag(((Boolean) message.obj).booleanValue());
                        return;
                    case WebView.ZEUS_NOTIFY_SCALE /* 145 */:
                        WebView.this.mPreviewZoomOnly = false;
                        WebView.this.mInZoomOverview = false;
                        WebView.this.mZoomCenterX = 0.0f;
                        WebView.this.mZoomCenterY = 0.0f;
                        WebView.this.mAnchorX = WebView.this.viewToContentX(((int) WebView.this.mZoomCenterX) + WebView.this.mScrollX);
                        WebView.this.mAnchorY = WebView.this.viewToContentY(((int) WebView.this.mZoomCenterY) + WebView.this.mScrollY);
                        WebView.this.setNewZoomScale(WebView.this.mAdjustScale, false, true);
                        WebView.this.invalidate();
                        return;
                    case WebView.SEND_SUBJECT_RECTS /* 146 */:
                        WebView.this.setSubjectRectsFromWebCore((ArrayList) message.obj);
                        return;
                    case WebView.SHOW_DOUBLE_TAP_SCALE /* 147 */:
                        Rect rect4 = ((WebViewCore.DoubleTapScaleData) message.obj).mBlockRect;
                        float unused = WebView.this.mDefaultScale;
                        WebView.this.mWaitingZoom2Block = false;
                        WebView.this.mMultiZoomScaleFlag = false;
                        WebView.this.mScrollZoomScaleFlag = false;
                        int i4 = WebView.this.getContext().getResources().getDisplayMetrics().widthPixels;
                        if (rect4.width() > 0 && rect4.width() < WebView.this.mZoomOverviewWidth) {
                            float width = i4 / rect4.width();
                            if (width > WebView.fakeMaxZoomScale) {
                                width = WebView.fakeMaxZoomScale;
                            }
                            if (Math.abs(WebView.this.mActualScale - width) < WebView.MINIMUM_SCALE_INCREMENT) {
                                if (WebView.this.mZoomState == ZoomState.ZoomBlock && WebView.this.mDefaultScale > width + WebView.MINIMUM_VELOCITY_RATIO_FOR_ACCELERATION) {
                                    WebView.this.setZoomState(ZoomState.ZoomDefault);
                                    WebView.this.zoom2Default();
                                    return;
                                }
                            } else {
                                int i5 = rect4.left;
                                int i6 = rect4.right - rect4.left;
                                int viewWidth3 = WebView.this.getViewWidth();
                                float f4 = (i5 * WebView.this.mActualScale) - WebView.this.mScrollX;
                                float f5 = i5 * width;
                                float f6 = i6 * width;
                                float f7 = WebView.this.mContentWidth * width;
                                float f8 = (viewWidth3 - f6) / 2.0f;
                                if (f8 <= f5) {
                                    f5 = f8 > (f7 - f5) - f6 ? viewWidth3 - (f7 - f5) : f8;
                                }
                                WebView.this.mZoomCenterX = ((f4 * width) - (f5 * WebView.this.mActualScale)) / (width - WebView.this.mActualScale);
                                WebView.this.mAnchorX = WebView.this.viewToContentX(((int) WebView.this.mZoomCenterX) + WebView.this.mScrollX);
                                WebView.this.setZoomState(ZoomState.ZoomBlock);
                                WebView.this.mBlockRect = rect4;
                                if (WebView.this.ifNeedStorePageScale()) {
                                    WebView.mZeusScaleStore.put(WebView.this.getUrl(), width);
                                }
                                WebView.this.zoomWithPreview(width, WebView.this.mZoomState != ZoomState.ZoomBlock);
                                return;
                            }
                        }
                        float viewWidth4 = WebView.this.getViewWidth() / WebView.this.mZoomOverviewWidth;
                        if (WebView.this.mZoomState == ZoomState.ZoomOverview || Math.abs(WebView.this.mActualScale - viewWidth4) < WebView.MINIMUM_SCALE_INCREMENT) {
                            WebView.this.setZoomState(ZoomState.ZoomDefault);
                            WebView.this.zoom2Default();
                            return;
                        }
                        WebView.this.zoom2Overview(true);
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTouchHighlightRects(ArrayList arrayList) {
        invalidate(this.mTouchHighlightRegion.getBounds());
        this.mTouchHighlightRegion.setEmpty();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Rect contentToViewRect = contentToViewRect((Rect) it.next());
                if (contentToViewRect.width() < (getWidth() >> 1) || contentToViewRect.height() < (getHeight() >> 1)) {
                    this.mTouchHighlightRegion.union(contentToViewRect);
                } else {
                    Log.w(LOGTAG, "Skip the huge selection rect:" + contentToViewRect);
                }
            }
            invalidate(this.mTouchHighlightRegion.getBounds());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTextSelectionFromMessage(int i, int i2, WebViewCore.TextSelectionData textSelectionData) {
        if (inEditingMode() && this.mWebTextView.isSameTextField(i) && i2 == this.mTextGeneration) {
            this.mWebTextView.setSelectionFromWebKit(textSelectionData.mStart, textSelectionData.mEnd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dismissListBox() {
        if (this.mCurListBox == null || this.mCurListBox.isRemoved()) {
            return false;
        }
        this.mCurListBox.dismissPopListView();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class InvokeListBox implements Runnable {
        private static final String RES_FILE_CHECK_ICON = "check_icon";
        private static final String RES_FILE_CHECK_ICON_SELECT = "check_icon_select";
        private static final String RES_FILE_LIST_BG = "list_bg";
        private static final String RES_FILE_LIST_BG_NIGHT = "list_bg_night";
        private static final String RES_FILE_LIST_SELECTED_ITEM_BG = "list_selecteditem_bg";
        private static final String RES_FILE_LIST_SEP = "list_sep";
        private static final String RES_FILE_LIST_SEP_NIGHT = "list_sep_night";
        private int clickId;
        MyArrayListAdapter mAdapter;
        private int mCheckedResId;
        private Container[] mContainers;
        private int mDividerNightResId;
        private int mDividerResId;
        private boolean mDropListMode;
        private int mHeight;
        private int mItemSelectedBgResId;
        SelectItemsAdapter mListAdapter;
        private int mListBgNightResId;
        private int mListBgResId;
        ListView mListView;
        private boolean mMultiple;
        PopupWindow mPopupDropList;
        boolean mRemoved;
        private int[] mSelectedArray;
        private int mSelection;
        private boolean mShowUp;
        private int mTextSize;
        private int mWidth;
        private int mX;
        private int mY;
        final /* synthetic */ WebView this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class Container {
            static final int OPTGROUP = -1;
            static final int OPTION_DISABLED = 0;
            static final int OPTION_ENABLED = 1;
            int mEnabled;
            int mId;
            String mString;

            private Container() {
            }

            public String toString() {
                return this.mString;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class SelectItemsAdapter extends ArrayAdapter {
            private static final int DEFAULT_ITEM_HEIGHT = 62;
            private static final int DEFAULT_TEXT_SIZE = 24;
            private int mDefaultTextHeight;
            private int mSelectedItem;
            private int mTextSize;

            public SelectItemsAdapter(Context context, Container[] containerArr, boolean z) {
                super(context, z ? 17367059 : 17367043, containerArr);
                this.mTextSize = 24;
                this.mSelectedItem = 0;
                this.mDefaultTextHeight = 0;
                this.mDefaultTextHeight = getTextHeight(24);
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(final int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, null, viewGroup);
                Container item = item(i);
                TextView textView = (TextView) view2;
                if (this.mSelectedItem == i) {
                    if (InvokeListBox.this.this$0.mWebViewCore != null && InvokeListBox.this.this$0.getSettings() != null && InvokeListBox.this.this$0.getSettings().nightModeEnabled()) {
                        textView.setBackgroundColor(-11640458);
                        textView.setTextColor(-5592406);
                    } else {
                        textView.setBackgroundColor(-8809035);
                        textView.setTextColor(-1);
                    }
                } else {
                    textView.setBackgroundResource(0);
                    if (InvokeListBox.this.this$0.mWebViewCore != null && InvokeListBox.this.this$0.getSettings() != null && InvokeListBox.this.this$0.getSettings().nightModeEnabled()) {
                        textView.setTextColor(-8284763);
                    } else {
                        textView.setTextColor(-16777216);
                    }
                }
                if (-1 == item.mEnabled) {
                    textView.getPaint().setFakeBoldText(true);
                }
                textView.setTextSize(0, this.mTextSize);
                textView.setSingleLine(true);
                textView.setPadding(4, 0, 4, 0);
                textView.getLayoutParams().height = (getTextHeight(this.mTextSize) * 62) / this.mDefaultTextHeight;
                if (item != null && 1 == item.mEnabled) {
                    view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.zeus.WebView.InvokeListBox.SelectItemsAdapter.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view3, MotionEvent motionEvent) {
                            if (motionEvent.getAction() == 0) {
                                InvokeListBox.this.this$0.logE("adapter view action down: " + i);
                                InvokeListBox.this.clickId = i;
                                SelectItemsAdapter.this.setSelectedItem(i);
                                SelectItemsAdapter.this.notifyDataSetChanged();
                            }
                            return false;
                        }
                    });
                }
                if (item != null && 1 != item.mEnabled && item.mEnabled == 0) {
                    view2.setEnabled(false);
                }
                return view2;
            }

            @Override // android.widget.BaseAdapter, android.widget.Adapter
            public boolean hasStableIds() {
                return false;
            }

            private Container item(int i) {
                if (i < 0 || i >= getCount()) {
                    return null;
                }
                return (Container) getItem(i);
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public long getItemId(int i) {
                Container item = item(i);
                if (item == null) {
                    return -1L;
                }
                return item.mId;
            }

            @Override // android.widget.BaseAdapter, android.widget.ListAdapter
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override // android.widget.BaseAdapter, android.widget.ListAdapter
            public boolean isEnabled(int i) {
                Container item = item(i);
                if (item == null) {
                    return false;
                }
                return 1 == item.mEnabled;
            }

            public void setTextSize(int i) {
                this.mTextSize = i;
            }

            public void setSelectedItem(int i) {
                this.mSelectedItem = i;
            }

            public int getTextHeight(int i) {
                Paint paint = new Paint();
                paint.setTextSize(i);
                Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                return ((int) Math.ceil(fontMetrics.descent - fontMetrics.top)) + 2;
            }

            public int getTextWidth(String str, int i) {
                Paint paint = new Paint();
                paint.setTextSize(i);
                return (int) paint.measureText(str);
            }
        }

        /* loaded from: classes.dex */
        class MyArrayListAdapter extends ArrayAdapter {
            private int mSelectedItem;

            public MyArrayListAdapter(Context context, Container[] containerArr, boolean z) {
                super(context, z ? 17367059 : 17367058, containerArr);
            }

            public int getFontHeight(float f) {
                Paint paint = new Paint();
                paint.setTextSize(f);
                Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                return ((int) Math.ceil(fontMetrics.descent - fontMetrics.top)) + 2;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, null, viewGroup);
                Container item = item(i);
                if (item != null && 1 != item.mEnabled) {
                    LinearLayout linearLayout = new LinearLayout(InvokeListBox.this.this$0.mContext);
                    linearLayout.setOrientation(1);
                    if (i > 0) {
                        View view3 = new View(InvokeListBox.this.this$0.mContext);
                        view3.setBackgroundResource(17301522);
                        linearLayout.addView(view3);
                    }
                    if (-1 == item.mEnabled) {
                        Assert.assertTrue(view2 instanceof CheckedTextView);
                        ((CheckedTextView) view2).setCheckMarkDrawable((Drawable) null);
                    } else {
                        view2.setEnabled(false);
                    }
                    linearLayout.addView(view2);
                    if (i < getCount() - 1) {
                        View view4 = new View(InvokeListBox.this.this$0.mContext);
                        view4.setBackgroundResource(17301522);
                        linearLayout.addView(view4);
                    }
                    return linearLayout;
                }
                return view2;
            }

            @Override // android.widget.BaseAdapter, android.widget.Adapter
            public boolean hasStableIds() {
                return false;
            }

            private Container item(int i) {
                if (i < 0 || i >= getCount()) {
                    return null;
                }
                return (Container) getItem(i);
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public long getItemId(int i) {
                Container item = item(i);
                if (item == null) {
                    return -1L;
                }
                return item.mId;
            }

            @Override // android.widget.BaseAdapter, android.widget.ListAdapter
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override // android.widget.BaseAdapter, android.widget.ListAdapter
            public boolean isEnabled(int i) {
                Container item = item(i);
                if (item == null) {
                    return false;
                }
                return 1 == item.mEnabled;
            }

            public void setSelectedItem(int i) {
                this.mSelectedItem = i;
            }
        }

        private InvokeListBox(WebView webView, String[] strArr, int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, int i5, boolean z) {
            this(webView, strArr, iArr, iArr2);
            this.mX = i;
            this.mY = (z ? -4 : 4) + i2;
            this.mWidth = i3;
            this.mHeight = i4;
            this.mTextSize = i5;
            this.mShowUp = z;
            this.mDropListMode = true;
        }

        private InvokeListBox(WebView webView, String[] strArr, int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
            this(webView, strArr, iArr, i);
            this.mX = i2;
            this.mY = (z ? -3 : 3) + i3;
            this.mWidth = i4;
            this.mHeight = i5;
            this.mTextSize = i6;
            this.mShowUp = z;
            this.mDropListMode = true;
        }

        private InvokeListBox(WebView webView, String[] strArr, int[] iArr, int[] iArr2) {
            this.this$0 = webView;
            this.clickId = -2;
            this.mX = 0;
            this.mY = 0;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mTextSize = 0;
            this.mShowUp = false;
            this.mDropListMode = false;
            this.mListBgResId = 0;
            this.mListBgNightResId = 0;
            this.mDividerNightResId = 0;
            this.mListView = null;
            this.mPopupDropList = null;
            this.mAdapter = null;
            this.mListAdapter = null;
            this.mRemoved = false;
            this.mMultiple = true;
            this.mSelectedArray = iArr2;
            int length = strArr.length;
            this.mContainers = new Container[length];
            for (int i = 0; i < length; i++) {
                this.mContainers[i] = new Container();
                this.mContainers[i].mString = strArr[i];
                this.mContainers[i].mEnabled = iArr[i];
                this.mContainers[i].mId = i;
            }
        }

        private InvokeListBox(WebView webView, String[] strArr, int[] iArr, int i) {
            this.this$0 = webView;
            this.clickId = -2;
            this.mX = 0;
            this.mY = 0;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mTextSize = 0;
            this.mShowUp = false;
            this.mDropListMode = false;
            this.mListBgResId = 0;
            this.mListBgNightResId = 0;
            this.mDividerNightResId = 0;
            this.mListView = null;
            this.mPopupDropList = null;
            this.mAdapter = null;
            this.mListAdapter = null;
            this.mRemoved = false;
            this.mSelection = i;
            this.mMultiple = false;
            int length = strArr.length;
            this.mContainers = new Container[length];
            for (int i2 = 0; i2 < length; i2++) {
                this.mContainers[i2] = new Container();
                this.mContainers[i2].mString = strArr[i2];
                this.mContainers[i2].mEnabled = iArr[i2];
                this.mContainers[i2].mId = i2;
            }
        }

        /* loaded from: classes.dex */
        class SingleDataSetObserver extends DataSetObserver {
            private Adapter mAdapter;
            private long mCheckedId;
            private ListView mListView;

            public SingleDataSetObserver(long j, ListView listView, Adapter adapter) {
                this.mCheckedId = j;
                this.mListView = listView;
                this.mAdapter = adapter;
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                if (this.mCheckedId != this.mAdapter.getItemId(this.mListView.getCheckedItemPosition())) {
                    this.mListView.clearChoices();
                    int count = this.mAdapter.getCount();
                    for (int i = 0; i < count; i++) {
                        if (this.mAdapter.getItemId(i) == this.mCheckedId) {
                            this.mListView.setItemChecked(i, true);
                            return;
                        }
                    }
                }
            }

            public void onInvalidate() {
            }
        }

        public void initSingle(String[] strArr, int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
            this.mSelection = i;
            this.mMultiple = false;
            int length = strArr.length;
            this.mContainers = new Container[length];
            for (int i7 = 0; i7 < length; i7++) {
                this.mContainers[i7] = new Container();
                this.mContainers[i7].mString = strArr[i7];
                this.mContainers[i7].mEnabled = iArr[i7];
                this.mContainers[i7].mId = i7;
            }
            this.mX = i2;
            this.mY = (z ? -3 : 3) + i3;
            this.mWidth = i4;
            this.mHeight = i5;
            this.mTextSize = i6;
            this.mShowUp = z;
            this.mDropListMode = true;
            this.clickId = -2;
        }

        private void initListView() {
            if (this.mListView == null) {
                this.mListView = createListView();
            }
            this.mListAdapter = new SelectItemsAdapter(this.this$0.mContext, this.mContainers, this.mMultiple);
            this.mListAdapter.setTextSize(this.mTextSize);
            this.mListAdapter.setSelectedItem(this.mSelection);
            this.mListView.setAdapter((ListAdapter) this.mListAdapter);
            this.mListView.setBackgroundResource(this.this$0.getSettings().nightModeEnabled() ? this.mListBgNightResId : this.mListBgResId);
            if (this.mSelection != -1) {
                this.mListView.setSelection(this.mSelection);
                this.mListAdapter.setSelectedItem(this.mSelection);
                this.mListAdapter.notifyDataSetChanged();
            }
        }

        private ListView createListView() {
            ListView listView = new ListView(this.this$0.mContext);
            listView.setCacheColorHint(0);
            listView.setBackgroundColor(-1);
            listView.setFocusableInTouchMode(true);
            listView.setVerticalFadingEdgeEnabled(false);
            ApplicationInfo applicationInfo = this.this$0.mContext.getApplicationInfo();
            this.mListBgNightResId = this.this$0.mContext.getResources().getIdentifier(RES_FILE_LIST_BG_NIGHT, "drawable", applicationInfo.packageName);
            this.mListBgResId = this.this$0.mContext.getResources().getIdentifier(RES_FILE_LIST_BG, "drawable", applicationInfo.packageName);
            this.mItemSelectedBgResId = this.this$0.mContext.getResources().getIdentifier(RES_FILE_LIST_SELECTED_ITEM_BG, "drawable", applicationInfo.packageName);
            listView.setSelector(new ColorDrawable(0));
            this.mDividerNightResId = this.this$0.mContext.getResources().getIdentifier(RES_FILE_LIST_SEP_NIGHT, "drawable", applicationInfo.packageName);
            this.mDividerResId = this.this$0.mContext.getResources().getIdentifier(RES_FILE_LIST_SEP, "drawable", applicationInfo.packageName);
            listView.setDividerHeight(0);
            this.mCheckedResId = this.this$0.mContext.getResources().getIdentifier(RES_FILE_CHECK_ICON, "drawable", applicationInfo.packageName);
            listView.setPadding(1, 0, 1, 0);
            if (!this.mMultiple) {
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.zeus.WebView.InvokeListBox.1
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
                        InvokeListBox.this.this$0.logE("item click: " + i);
                        InvokeListBox.this.clickId = i;
                        InvokeListBox.this.mListAdapter.setSelectedItem(i);
                        InvokeListBox.this.mListAdapter.notifyDataSetChanged();
                        InvokeListBox.this.dismissPopListView();
                    }
                });
                listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.baidu.zeus.WebView.InvokeListBox.2
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
                        InvokeListBox.this.mListAdapter.setSelectedItem(i);
                        InvokeListBox.this.mListAdapter.notifyDataSetChanged();
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView adapterView) {
                    }
                });
            }
            return listView;
        }

        private void adjustPopupListSize(ListView listView) {
            int dividerHeight;
            int i = 0;
            for (int i2 = 0; i2 < this.mListAdapter.getCount(); i2++) {
                View view = this.mListAdapter.getView(i2, null, listView);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                View.MeasureSpec.makeMeasureSpec(0, 0);
                View.MeasureSpec.makeMeasureSpec(0, 0);
                view.measure(0, 0);
                if (layoutParams == null) {
                    this.this$0.logE("item[" + i2 + "].getMeasuredHeight() = " + view.getMeasuredHeight());
                    dividerHeight = view.getMeasuredHeight() + listView.getDividerHeight();
                } else {
                    dividerHeight = layoutParams.height + listView.getDividerHeight();
                }
                if (i + dividerHeight < this.mHeight) {
                    i += dividerHeight;
                }
            }
            int i3 = i + 10;
            if (i3 < this.mHeight) {
                int i4 = this.mHeight - i3;
                if (this.mShowUp) {
                    this.mY = i4 + this.mY;
                }
                this.mHeight = i3;
            }
            this.mWidth += 8;
        }

        private void showDropList() {
            ListView createListView = createListView();
            this.this$0.logE("padding[" + createListView.getPaddingLeft() + ", " + createListView.getPaddingTop() + ", " + createListView.getPaddingRight() + ", " + createListView.getPaddingBottom() + "]");
            if (createListView != null) {
                this.mPopupDropList = new PopupWindow(this.this$0.mContext);
                this.mPopupDropList.setBackgroundDrawable(new BitmapDrawable());
                this.mPopupDropList.setAnimationStyle(0);
                this.mPopupDropList.setFocusable(true);
                this.mPopupDropList.setTouchable(true);
                this.mPopupDropList.setOutsideTouchable(true);
                this.mPopupDropList.setContentView(createListView);
                this.mPopupDropList.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.zeus.WebView.InvokeListBox.3
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        InvokeListBox.this.this$0.mWebViewCore.sendMessage(WebView.SET_ROOT_LAYER_MSG_ID, InvokeListBox.this.clickId, 0);
                    }
                });
                adjustPopupListSize(createListView);
                this.mPopupDropList.setWidth(this.mWidth);
                this.mPopupDropList.setHeight(this.mHeight);
                this.mPopupDropList.showAtLocation(this.this$0, 51, this.mX, this.mY);
                this.mPopupDropList.update();
            }
        }

        private void showPopListView() {
            this.this$0.logE("enter showPopListView()");
            initListView();
            adjustPopupListSize(this.mListView);
            this.this$0.addView(this.mListView, new AbsoluteLayout.LayoutParams(this.mWidth, this.mHeight, this.mX, this.mY));
            this.mListView.requestFocus();
            this.mRemoved = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dismissPopListView() {
            this.this$0.logE("dismissPopListView() -> id = " + this.clickId);
            this.this$0.removeView(this.mListView);
            this.this$0.requestFocus();
            this.this$0.mWebViewCore.sendMessage(WebView.SET_ROOT_LAYER_MSG_ID, this.clickId, 0);
            this.mRemoved = true;
        }

        public boolean isRemoved() {
            return this.mRemoved;
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.e(WebView.LOGTAG, "mDropListMode = " + this.mDropListMode);
            if (this.mDropListMode) {
                showPopListView();
                return;
            }
            final ListView listView = new ListView(this.this$0.mContext);
            listView.setCacheColorHint(-1);
            final MyArrayListAdapter myArrayListAdapter = new MyArrayListAdapter(this.this$0.mContext, this.mContainers, this.mMultiple);
            AlertDialog.Builder inverseBackgroundForced = new AlertDialog.Builder(this.this$0.mContext).setView(listView).setCancelable(true).setInverseBackgroundForced(true);
            if (this.mMultiple) {
                inverseBackgroundForced.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.baidu.zeus.WebView.InvokeListBox.4
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        InvokeListBox.this.this$0.mWebViewCore.sendMessage(WebView.IMMEDIATE_REPAINT_MSG_ID, myArrayListAdapter.getCount(), 0, listView.getCheckedItemPositions());
                    }
                });
                inverseBackgroundForced.setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.baidu.zeus.WebView.InvokeListBox.5
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        InvokeListBox.this.this$0.mWebViewCore.sendMessage(WebView.SET_ROOT_LAYER_MSG_ID, -2, 0);
                    }
                });
            }
            listView.setAdapter((ListAdapter) myArrayListAdapter);
            listView.setFocusableInTouchMode(true);
            listView.setTextFilterEnabled(!this.mMultiple);
            if (this.mMultiple) {
                listView.setChoiceMode(2);
                int length = this.mSelectedArray.length;
                for (int i = 0; i < length; i++) {
                    listView.setItemChecked(this.mSelectedArray[i], true);
                }
            } else {
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.zeus.WebView.InvokeListBox.6
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView adapterView, View view, int i2, long j) {
                        InvokeListBox.this.clickId = i2;
                    }
                });
                if (this.mSelection != -1) {
                    listView.setSelection(this.mSelection);
                    listView.setChoiceMode(1);
                    listView.setItemChecked(this.mSelection, true);
                    myArrayListAdapter.registerDataSetObserver(new SingleDataSetObserver(myArrayListAdapter.getItemId(this.mSelection), listView, myArrayListAdapter));
                }
            }
            if (!this.mMultiple) {
                inverseBackgroundForced.setTitle(this.this$0.mCallbackProxy.getStringById(5));
                inverseBackgroundForced.setPositiveButton(this.this$0.mCallbackProxy.getStringById(0), new DialogInterface.OnClickListener() { // from class: com.baidu.zeus.WebView.InvokeListBox.7
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        InvokeListBox.this.this$0.mWebViewCore.sendMessage(WebView.SET_ROOT_LAYER_MSG_ID, InvokeListBox.this.clickId, 0);
                        dialogInterface.dismiss();
                    }
                });
                inverseBackgroundForced.setNegativeButton(this.this$0.mCallbackProxy.getStringById(6), new DialogInterface.OnClickListener() { // from class: com.baidu.zeus.WebView.InvokeListBox.8
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        InvokeListBox.this.this$0.mWebViewCore.sendMessage(WebView.SET_ROOT_LAYER_MSG_ID, -2, 0);
                    }
                });
            }
            AlertDialog create = inverseBackgroundForced.create();
            create.getWindow().setFlags(NotificationProxy.MAX_URL_LENGTH, NotificationProxy.MAX_URL_LENGTH);
            create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.zeus.WebView.InvokeListBox.9
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    InvokeListBox.this.this$0.mWebViewCore.sendMessage(WebView.SET_ROOT_LAYER_MSG_ID, -2, 0);
                }
            });
            create.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logE(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestListBox(String[] strArr, int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, int i5) {
        int contentToViewDimension = contentToViewDimension(i3);
        int contentToViewDimension2 = contentToViewDimension(i4);
        Handler handler = this.mPrivateHandler;
        InvokeListBox invokeListBox = new InvokeListBox(strArr, iArr, iArr2, contentToViewX(i), contentToViewY(i2) + getTop(), contentToViewDimension, contentToViewDimension2, i5, false);
        this.mCurListBox = invokeListBox;
        handler.post(invokeListBox);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestListBox(String[] strArr, int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        Rect rect = new Rect(i2, i3, i2 + i4, i3 + i5);
        Rect contentToViewRect = contentToViewRect(rect);
        int[] iArr2 = new int[2];
        getLocationInWindow(new int[2]);
        getLocationOnScreen(iArr2);
        int i9 = this.mScrollX;
        int i10 = this.mScrollY;
        Rect rect2 = new Rect();
        rect2.top = iArr2[1];
        rect2.left = iArr2[0];
        rect2.bottom = rect2.top + getHeight();
        rect2.right = rect2.left + getWidth();
        logE("localScreenPos[" + iArr2[0] + ", " + iArr2[1] + "]");
        logE("mScrollX = " + this.mScrollX);
        logE("mScrollY = " + this.mScrollY);
        Rect rect3 = new Rect();
        rect3.top = (contentToViewY(i3) + iArr2[1]) - i10;
        rect3.left = (iArr2[0] + contentToViewX(i2)) - i9;
        rect3.bottom = rect3.top + contentToViewDimension(i5);
        rect3.right = rect3.left + contentToViewDimension(i4);
        logE("originalRect[" + rect.left + ", " + rect.top + ", " + rect.right + ", " + rect.bottom + "]");
        logE("convertRect[" + contentToViewY(i3) + ", " + contentToViewX(i2) + ", " + (contentToViewY(i3) + contentToViewDimension(i5)) + ", " + (contentToViewX(i2) + contentToViewDimension(i4)) + "]");
        logE("selectRect[" + rect3.left + ", " + rect3.top + ", " + rect3.right + ", " + rect3.bottom + "]");
        int i11 = rect3.top - rect2.top;
        int i12 = rect2.bottom - rect3.bottom;
        logE("topHeight = " + i11);
        logE("bottomHeight = " + i12);
        int i13 = rect3.left >= 0 ? rect3.left : 0;
        int i14 = rect3.top;
        int width = (rect3.right >= getWidth() ? getWidth() : rect3.right) - i13;
        int max = Math.max(i11, i12);
        if (i12 > i11) {
            i7 = rect3.height() + i14;
        } else {
            i7 = i14 - max;
        }
        int contentToViewDimension = contentToViewDimension(i6);
        logE("x = " + i13 + " y = " + i7 + " w = " + width + " h = " + max);
        int i15 = contentToViewRect.left;
        int i16 = contentToViewRect.top;
        int width2 = contentToViewRect.width();
        if (i12 > i11) {
            i8 = i16 + contentToViewRect.height();
        } else {
            i8 = i16 - max;
        }
        if (this.mCurListBox == null) {
            this.mCurListBox = new InvokeListBox(strArr, iArr, i, i15, i8, width2, max, contentToViewDimension, i12 <= i11);
        } else {
            this.mCurListBox.initSingle(strArr, iArr, i, i15, i8, width2, max, contentToViewDimension, i12 <= i11);
        }
        this.mPrivateHandler.post(this.mCurListBox);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestListBox(String[] strArr, int[] iArr, int[] iArr2) {
        this.mPrivateHandler.post(new InvokeListBox(strArr, iArr, iArr2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateZoomRange(WebViewCore.RestoreState restoreState, int i, int i2, boolean z) {
        boolean z2 = true;
        if (restoreState.mMinScale == 0.0f) {
            if (restoreState.mMobileSite) {
                if (i2 > Math.max(0, i)) {
                    this.mMinZoomScale = i / i2;
                    this.mMinZoomScaleFixed = false;
                    if (z) {
                        WebSettings settings = getSettings();
                        if (!isWapPage()) {
                            if (!settings.getUseWideViewPort() || !settings.getLoadWithOverviewMode()) {
                                z2 = false;
                            }
                            this.mInZoomOverview = z2;
                        } else {
                            this.mInZoomOverview = false;
                        }
                    }
                } else {
                    this.mMinZoomScale = restoreState.mDefaultScale;
                    this.mMinZoomScaleFixed = true;
                }
            } else {
                this.mMinZoomScale = DEFAULT_MIN_ZOOM_SCALE;
                this.mMinZoomScaleFixed = false;
            }
        } else {
            this.mMinZoomScale = restoreState.mMinScale;
            this.mMinZoomScaleFixed = true;
        }
        if (restoreState.mMaxScale == 0.0f) {
            this.mMaxZoomScale = DEFAULT_MAX_ZOOM_SCALE;
        } else {
            this.mMaxZoomScale = restoreState.mMaxScale;
        }
        if (this.mCallbackProxy != null && ifWapAllowScale()) {
            this.mCallbackProxy.onPageCanBeScaled();
        }
        if (this.mIsSubjectWebView && this.mSubjectNeedScrollOnLoad && this.mSubjectScrollOffsetY > 0) {
            post(new SubjectPostScroll(this, this.mSubjectScrollOffsetY));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestListBox(String[] strArr, int[] iArr, int i) {
        this.mPrivateHandler.post(new InvokeListBox(strArr, iArr, i));
    }

    private void sendMoveFocus(int i, int i2) {
        this.mWebViewCore.sendMessage(CENTER_FIT_RECT, new WebViewCore.CursorData(i, i2, 0, 0));
    }

    private void sendMoveMouse(int i, int i2, int i3, int i4) {
        this.mWebViewCore.sendMessage(ZEUS_QUICK_CLICK, new WebViewCore.CursorData(i, i2, i3, i4));
    }

    private void sendMoveMouseIfLatest(boolean z) {
        if (z) {
            clearTextEntry(true);
        }
        this.mWebViewCore.sendMessage(ZEUS_LONG_PRESS, cursorData());
    }

    private void sendMotionUp(int i, int i2, int i3, int i4, int i5) {
        WebViewCore.TouchUpData touchUpData = new WebViewCore.TouchUpData();
        touchUpData.mMoveGeneration = i;
        touchUpData.mFrame = i2;
        touchUpData.mNode = i3;
        touchUpData.mX = i4;
        touchUpData.mY = i5;
        touchUpData.mNativeLayer = nativeScrollableLayer(i4, i5, touchUpData.mNativeLayerRect, null);
        this.mWebViewCore.sendMessage(ZEUS_PLUGIN_FULL_SCREEN_ENTER, touchUpData);
        if (this.mClickUrlPauseDraw) {
            this.mClickUrlPauseDraw = false;
            WebViewCore.resumeUpdatePicture(this.mWebViewCore);
        }
    }

    void sendEngWordSelection(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        WebViewCore.EngWordData engWordData = new WebViewCore.EngWordData();
        engWordData.x = i;
        engWordData.y = i2;
        engWordData.picture = i3;
        engWordData.left = i4;
        engWordData.top = i5;
        engWordData.right = i6;
        engWordData.bottom = i7;
        this.mWebViewCore.sendMessage(BdWebErrorView.ERROR_CODE_404, engWordData);
    }

    private int getScaledMaxXScroll() {
        int width;
        if (!this.mHeightCanMeasure) {
            width = getViewWidth() / 4;
        } else {
            Rect rect = new Rect();
            calcOurVisibleRect(rect);
            width = rect.width() / 2;
        }
        return viewToContentX(width);
    }

    private int getScaledMaxYScroll() {
        int height;
        if (!this.mHeightCanMeasure) {
            height = getViewHeight() / 4;
        } else {
            Rect rect = new Rect();
            calcOurVisibleRect(rect);
            height = rect.height() / 2;
        }
        return Math.round(height * this.mInvActualScale);
    }

    private void viewInvalidate(boolean z) {
        if (z) {
            setContentChangeState(0);
            invalidate();
            return;
        }
        setContentChangeState(1);
    }

    private void letPluginHandleNavKey(int i, long j, boolean z) {
        int i2;
        int i3;
        if (z) {
            i2 = 0;
            playSoundEffect(keyCodeToSoundsEffect(i));
            i3 = 103;
        } else {
            i2 = 1;
            i3 = 104;
        }
        this.mWebViewCore.sendMessage(i3, new KeyEvent(j, j, i2, i, 1, (this.mShiftIsPressed ? 1 : 0) | 0 | 0, 0, 0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean navHandledKey(int i, int i2, boolean z, long j) {
        if (this.mNativeClass == 0) {
            return false;
        }
        this.mLastCursorTime = j;
        this.mLastCursorBounds = nativeGetCursorRingBounds();
        boolean z2 = !nativeMoveCursor(i, i2, z);
        if (z2 && this.mHeightCanMeasure) {
            Rect nativeGetCursorRingBounds = nativeGetCursorRingBounds();
            if (nativeGetCursorRingBounds.isEmpty()) {
                return z2;
            }
            Rect contentToViewRect = contentToViewRect(nativeGetCursorRingBounds);
            Rect rect = new Rect();
            calcOurVisibleRect(rect);
            Rect rect2 = new Rect(rect);
            int width = rect.width() / 2;
            rect2.inset(-width, -(rect.height() / 2));
            if (Rect.intersects(rect2, contentToViewRect)) {
                int min = Math.min(contentToViewRect.right - rect.right, width);
                if (min > 0) {
                    pinScrollBy(min, 0, true, 0);
                } else {
                    int max = Math.max(contentToViewRect.left - rect.left, -width);
                    if (max < 0) {
                        pinScrollBy(max, 0, true, 0);
                    }
                }
                if (!this.mLastCursorBounds.isEmpty() && !this.mLastCursorBounds.equals(nativeGetCursorRingBounds)) {
                    requestRectangleOnScreen(contentToViewRect);
                    this.mUserScroll = true;
                    return z2;
                }
                return z2;
            }
            return z2;
        }
        return z2;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
        this.mWebViewCore.sendMessage(FIND_AGAIN, i);
    }

    public void setWebViewAction(WebViewAction webViewAction) {
        this.mWebViewCore.sendMessage(149, webViewAction == WebViewAction.SingleWindowPauseAction ? 1 : 0);
    }

    public void setBackgroundColorNotCore(int i) {
        this.mBackgroundColor = i;
    }

    public void debugDump() {
        nativeDebugDump();
        this.mWebViewCore.sendMessage(172);
    }

    public void drawPage(Canvas canvas) {
        this.mWebViewCore.drawContentPicture(canvas, 0, false, false, mBitmapForDraging, this.mActualScale, canvas.getClipBounds().left, canvas.getClipBounds().top, canvas.getClipBounds().right, canvas.getClipBounds().bottom, this.mScrollX, this.mScrollY, getContentChangeState(), !this.mTapOnSubject, this.mWebViewVisible);
    }

    public void setTouchInterval(int i) {
        this.mCurrentTouchInterval = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateCachedTextfield(String str) {
        nativeUpdateCachedTextfield(str, this.mTextGeneration);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        if (!WebKitInit.isAndroidVersion21()) {
            Log.d(LOGTAG, "Not android 2.1 platform, invoke WebView onConfigurationChanged");
            try {
                nativeSuperOnConfChanged(configuration);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        Log.d(LOGTAG, "Android 2.1 platform, has no WebView onConfigurationChanged to invoke");
    }

    ViewManager getViewManager() {
        return this.mViewManager;
    }

    public static void PreconnectUrl(String str, Context context) {
        JniUtil.setContext(context);
        nativePreconnectUrl(str);
    }

    public static void ResolveUrl(String str, Context context) {
        JniUtil.setContext(context);
        nativeResolveUrl(str);
    }

    public void setNativeBigPluginView() {
        if (this.mWebViewType == WebViewType.BIGPLUGIN && this.mWebViewCore != null) {
            this.mWebViewCore.sendMessage(BdWebErrorView.ERROR_CODE_407);
        }
    }

    public int getActionNodesCount() {
        if (getSettings().collectMainAction()) {
            return nativeActionNodesCount();
        }
        return 0;
    }

    public String getActionNodeText(int i) {
        return nativeActionNodeText(i);
    }

    public void onClickActionNode(int i) {
        nativeOnClickActionNode(i);
    }

    public void setPinScrollTo(int i, int i2) {
        float f = this.mActualScale;
        pinScrollTo(((int) (i * f)) - (getViewWidth() / 2), ((int) (f * i2)) - (getViewHeightWithTitle() / 2), false, 0);
    }

    public Bitmap getCurrBmp() {
        return mBitmapForDraging;
    }

    public boolean SplitContent() {
        this.mSplitContentCnt++;
        this.mPrivateHandler.sendMessageDelayed(this.mPrivateHandler.obtainMessage(13), 100L);
        return true;
    }

    public boolean prepareForCacheCanvas() {
        int i = getContext().getResources().getDisplayMetrics().heightPixels;
        int i2 = getContext().getResources().getDisplayMetrics().widthPixels;
        this.mSwitchScreenFlag = false;
        if (mBitmapForDraging == null || !this.mUnderSubject) {
        }
        if (mCanvas == null || mBitmapForDraging == null || mBitmapForScale == null || i != mCurrScreenHeight || i2 != mCurrScreenWidth) {
            setContentChangeState(0);
            mCurrScreenHeight = i;
            mCurrScreenWidth = i2;
            if (mBitmapForDraging != null && !WebKitInit.isVersion40() && !WebKitInit.isVersion41()) {
                mBitmapForDraging.recycle();
            }
            if (mBitmapForScale != null && !WebKitInit.isVersion40() && !WebKitInit.isVersion41()) {
                mBitmapForScale.recycle();
            }
            try {
                mBitmapForDraging = Bitmap.createBitmap((int) (mCurrScreenWidth * mBmpFactor), (int) (mCurrScreenHeight * mBmpFactor), Bitmap.Config.RGB_565);
                mBitmapForScale = Bitmap.createBitmap((int) (mCurrScreenWidth * mBmpFactor), (int) (mCurrScreenHeight * mBmpFactor), Bitmap.Config.RGB_565);
                System.gc();
                mBitmapForDraging.setDensity(getContext().getResources().getDisplayMetrics().densityDpi);
                mCanvas = new Canvas();
                mCanvas.setBitmap(mBitmapForDraging);
                mCanvasSubject = new Canvas();
                mCanvasSubject.setBitmap(mBitmapForScale);
                this.mWebViewCore.SetCanvasWidthHeight(mCurrScreenWidth, mCurrScreenHeight, getZeusBitmapFromCanvas(mCanvas, mBitmapForDraging));
                this.mWebViewCore.SetSubjectBitmap(mCurrScreenWidth, mCurrScreenHeight, getZeusBitmapFromCanvas(mCanvasSubject, mBitmapForScale));
                this.mSwitchScreenFlag = true;
            } catch (OutOfMemoryError e) {
                Log.e(LOGTAG, "PrepareforcacheCanvas: failed to create bitmap" + e);
                mBitmapForDraging = null;
                mBitmapForScale = null;
                System.gc();
                return false;
            }
        }
        if (getViewWidth() != this.mViewWidth || getViewHeight() != this.mViewHeight) {
            this.mViewWidth = getViewWidth();
            this.mViewHeight = getViewHeight();
            this.mWebViewCore.SetViewWidthHeight(this.mViewWidth, this.mViewHeight);
        }
        mCanvas.save();
        mCanvas.translate(-this.mScrollX, -this.mScrollY);
        return true;
    }

    public boolean stopScroll() {
        this.mScrollState = ScrollState.ScrollStop;
        this.mWebViewCore.setForceResumeUpdatePicture(true);
        if (this.mPrivateHandler.hasMessages(7)) {
            this.mPrivateHandler.removeMessages(7);
            this.mPrivateHandler.sendEmptyMessage(7);
        }
        return true;
    }

    public boolean startPreviewZoomScale() {
        if (this.mFlag == 1) {
            this.mCurrentScale = this.mActualScale;
            this.mFlag = 0;
        }
        return true;
    }

    public void setAdjustScale(float f) {
        this.mAdjustScale = this.mActualScale * f;
    }

    public boolean setPreviewZoomScale(float f) {
        float f2;
        boolean z;
        if (ifWapAllowScale()) {
            if (this.mUnderSubject) {
                this.mUnderSubject = false;
                onDraw(mCanvas);
            }
            this.mZoomEndFlag = false;
            this.mPreviewZoomOnly = true;
            this.mZoomCenterX = 0.0f;
            this.mZoomCenterY = 0.0f;
            if (!this.mScrollZoomScaleFlag) {
                WebViewCore.pauseUpdatePicture(this.mWebViewCore);
                if (!WebKitInit.isVersionCanUseGL()) {
                    this.mViewManager.hideAll();
                }
                this.mLastScale = this.mActualScale;
                if (!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }
            }
            if (f > 0.0f) {
                f2 = this.mActualScale + ((fakeMaxZoomScale - this.mMinZoomScale) * f);
                z = true;
            } else {
                f2 = this.mActualScale + ((fakeMaxZoomScale - this.mMinZoomScale) * f);
                z = false;
            }
            if (f2 > this.mMaxZoomScale) {
                f2 = this.mMaxZoomScale;
            }
            if (f2 > fakeMaxZoomScale) {
                f2 = fakeMaxZoomScale;
            } else if (f2 < this.mMinZoomScale) {
                f2 = this.mMinZoomScale;
            }
            if (z || this.mActualScale - this.mMinZoomScale >= 0.01f) {
                if (Math.abs(f2 - this.mCurrentScale) < 0.01f) {
                    this.mZoomFlag = 1;
                    this.mScrollZoomScaleFlag = true;
                    invalidate();
                    return true;
                }
                float f3 = f2 / this.mCurrentScale;
                if (z) {
                    this.mZoomOutFlag = false;
                    if (f2 <= fakeMaxZoomScale) {
                        this.mCurrentScale = f2;
                    }
                } else {
                    this.mZoomOutFlag = true;
                    if (f2 >= this.mMinZoomScale) {
                        this.mCurrentScale = f2;
                    }
                }
                setZoomState(ZoomState.ZoomOther);
                this.mZoomFlag = 1;
                this.mScrollZoomScaleFlag = true;
                invalidate();
                return true;
            }
            return false;
        }
        return false;
    }

    public void setEndScale() {
        dismissListBox();
        setZoomState(ZoomState.ZoomOther);
        this.mPrivateHandler.obtainMessage(11).sendToTarget();
    }

    public void setBeginScale() {
        dismissListBox();
        if (getZoomButtonsController().isVisible()) {
            getZoomButtonsController().setVisible(false);
        }
        this.mInZoomOverview = false;
        setZoomState(ZoomState.ZoomOther);
    }

    public float getActualZoomScale() {
        return this.mActualScale;
    }

    public float getMinZoomScale() {
        return this.mMinZoomScale;
    }

    public float getMaxZoomScale() {
        return this.mMaxZoomScale;
    }

    /* loaded from: classes.dex */
    class ScaleThread extends Thread {
        private int mCaptureCnt = 0;
        private int mCaptureCntBak = 0;
        private boolean mCapturing = false;

        public ScaleThread() {
        }

        public void Inc() {
            this.mCaptureCnt++;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.mCaptureCnt++;
        }
    }

    @Override // android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (this.mTouchMode == 9) {
            nativeScrollLayer(this.mScrollingLayer, i, i2);
            this.mScrollingLayerRect.left = i;
            this.mScrollingLayerRect.top = i2;
            invalidate();
            return;
        }
        this.mInOverScrollMode = false;
        int computeMaxScrollX = computeMaxScrollX();
        int computeMaxScrollY = computeMaxScrollY();
        if (computeMaxScrollX == 0) {
            i = pinLocX(i);
        } else if (i < 0 || i > computeMaxScrollX) {
            this.mInOverScrollMode = true;
        }
        if (i2 < 0 || i2 > computeMaxScrollY) {
            this.mInOverScrollMode = true;
        }
        int i3 = this.mScrollX;
        int i4 = this.mScrollY;
        super.scrollTo(i, i2);
    }

    public void cancelLongPressDelay() {
        if (this.mPrivateHandler != null && this.mWebViewCore != null) {
            this.mPrivateHandler.removeMessages(ZEUS_LONG_PRESS);
            this.mWebViewCore.removeMessages(402);
        }
    }

    public void setCanCachePage(boolean z) {
        if (this.mWebViewCore != null) {
            this.mWebViewCore.sendMessage(BdWebErrorView.ERROR_CODE_405, Boolean.valueOf(z));
        }
    }
}
