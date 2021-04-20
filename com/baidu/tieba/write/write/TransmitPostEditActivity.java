package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
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
import com.baidu.permissionhelper.app.ActivityCompat;
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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
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
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.tieba.write.view.PostCategoryView;
import com.kwai.video.player.PlayerPostEvent;
import d.b.h0.r.s.a;
import d.b.h0.s.c.h0;
import d.b.i0.q0.c0;
import d.b.i0.q0.d0;
import d.b.i0.q0.e0;
import d.b.i0.q0.e1;
import d.b.i0.v3.i;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
/* loaded from: classes5.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements i.a, PopupWindow.OnDismissListener, ActivityCompat.OnRequestPermissionsResultCallback {
    public static final String FROM_CONTENT = "from_content";
    public static final String FROM_SHARE_WRITE = "from_share_write";
    public static final String FROM_TITLE = "from_title";
    public static final int MAX_NEW_CONTENT_COUNT = 5000;
    public static final int MAX_NEW_REPLY_COUNT = 1000;
    public static final int NORMAL_TITLE_MAX_COUNT = 31;
    public static final int REQUEST_LOCATION = 0;
    public static final int TBDS24 = d.b.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    public static final int TBDS44 = d.b.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44);
    public d.b.i0.u3.b dialog;
    public boolean isPrivacy;
    public RelativeLayout mAdditionContainer;
    public TextView mAdditionCreateTime;
    public AdditionData mAdditionData;
    public TextView mAdditionLastContent;
    public TextView mAdditionLastTime;
    public BaijiahaoData mBaijiahaoData;
    public c0 mCategoryDefault;
    public int mCategoryFromID;
    public List<c0> mCategoryList;
    public String mCategoryName;
    public int mCategoryToID;
    public PostCategoryView mCategoryView;
    public HotTopicBussinessData mCurrHotData;
    public int mCurrPrefixPos;
    public EditorTools mEditor;
    public ForumTabSelectedView mForumTabSelectedView;
    public FrsTabInfoData mFrsTabList;
    public GestureDetector mGestureDetector;
    public TextView mHotTopicEdt;
    public List<HotTopicBussinessData> mList;
    public LocationModel mLocationModel;
    public NavigationBar mNavigationBar;
    public OriginalThreadCardView mOriginalThreadCardView;
    public OriginalThreadInfo.ShareInfo mOriginalThreadInfo;
    public PostTopicData mPostTopicData;
    public TextView mPrefix;
    public PostPrefixData mPrefixData;
    public ImageView mPrefixIcon;
    public d.b.i0.v3.i mPrefixWindow;
    public int mPrivateThread;
    public d.b.i0.v3.v.g mTipController;
    public LinearLayout mTitleView;
    public Toast mTooManyEmotionToast;
    public LinearLayout mToolView;
    public String mTransmitOriginThreadComment;
    public String mTransmitThreadAuthorNameShow;
    public NewWriteModel mWriteModel;
    public d.b.i0.v3.n.b mWriteTool;
    public View post_prefix_layout;
    public View prefix_divider;
    public String fromWhereToHotSelect = "";
    public boolean needAddHotTopicSign = false;
    public WriteData mData = null;
    public boolean isFeedBackBar = false;
    public InputMethodManager mInputManager = null;
    public EditText mPostTitle = null;
    public View mInterval = null;
    public LinearLayout mPostContentContainer = null;
    public SpanGroupEditText mPostContent = null;
    public FeedBackModel mFeedBackModel = null;
    public ArrayList<WritePrefixItemLayout> mPrefixItems = new ArrayList<>();
    public final KeyEvent keyEventDown = new KeyEvent(0, 67);
    public View mBack = null;
    public TextView mPost = null;
    public TextView mName = null;
    public DialogInterface.OnCancelListener mDialogCancelListener = null;
    public final Handler mHandler = new Handler();
    public RelativeLayout mParent = null;
    public String mDisableAudioMessage = null;
    public WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    public int mLocationState = 0;
    public View mRootView = null;
    public ScrollView write_scrollview = null;
    public boolean isLivePhotoType = false;
    public d.b.h0.r.f0.a mLoadingDialog = null;
    public String mFrom = AlbumActivityConfig.FROM_WRITE;
    public String mCallFrom = "2";
    public SpannableStringBuilder mContentBuilder = new SpannableStringBuilder();
    public boolean isKeyboardVisibility = false;
    public final d.b.i0.v3.v.c mHighLightController = new d.b.i0.v3.v.c();
    public TbFaceManager.a mBigEmotionSpanHanlder = new k();
    public final AntiHelper.k mAntiInjectListener = new r();
    public final NewWriteModel.g mOnPostWriteCallback = new s();
    public final LocationModel.e mOnLocationCallBack = new t();
    public final CustomMessageListener mOnSelectLocationListener = new u(2001226);
    public CustomMessageListener mUegValidateListener = new v(2016554);
    public final View.OnClickListener mEditOnClicked = new w();
    public boolean isDisalbeButtons = true;
    public final View.OnFocusChangeListener mFocusChangeListener = new a();
    public TextWatcher mWriteTitleTextWatcher = new d();
    public TextWatcher mWriteContentTextWatcher = new e();

    /* loaded from: classes5.dex */
    public class a implements View.OnFocusChangeListener {
        public a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.mPostTitle || view == TransmitPostEditActivity.this.mBack || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.isDisalbeButtons = true;
                    TransmitPostEditActivity.this.changeToolButtonStatus();
                    if (TransmitPostEditActivity.this.mEditor != null) {
                        TransmitPostEditActivity.this.mEditor.q();
                    }
                    d.b.c.e.p.l.J(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.mPostTitle);
                } else if (view == TransmitPostEditActivity.this.mPostTitle) {
                    TransmitPostEditActivity.this.mPrefix.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.mPostContent && z) {
                TransmitPostEditActivity.this.isDisalbeButtons = false;
                TransmitPostEditActivity.this.changeToolButtonStatus();
                TransmitPostEditActivity.this.mEditor.q();
                d.b.c.e.p.l.J(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.mPostContent);
            }
            TransmitPostEditActivity.this.updateHintTextColor();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            transmitPostEditActivity.showToast(transmitPostEditActivity.mDisableAudioMessage);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements d.b.h0.w.b {
        public c() {
        }

        @Override // d.b.h0.w.b
        public void onAction(d.b.h0.w.a aVar) {
            Object obj;
            VideoInfo videoInfo;
            if (aVar == null) {
                return;
            }
            if (aVar.f51942a == 31) {
                Object obj2 = aVar.f51944c;
                if (obj2 instanceof Integer) {
                    int intValue = ((Integer) obj2).intValue();
                    int i = intValue == 5 ? 4 : intValue == 9 ? 3 : intValue == 26 ? 1 : intValue == 7 ? 2 : 0;
                    if (i > 0) {
                        TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", i));
                    }
                }
            }
            int i2 = aVar.f51942a;
            if (i2 == 16) {
                if (TransmitPostEditActivity.this.isTextFull()) {
                    TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                } else {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 12004, true)));
                }
            } else if (i2 == 24) {
                if (TransmitPostEditActivity.this.isTextFull()) {
                    TransmitPostEditActivity.this.showToast(R.string.over_limit_tip);
                    return;
                }
                Object obj3 = aVar.f51944c;
                if (obj3 == null || !(obj3 instanceof d.b.h0.s.c.v)) {
                    return;
                }
                TransmitPostEditActivity.this.insertFaceIconToEditText((d.b.h0.s.c.v) obj3);
            } else if (i2 == 3) {
                TransmitPostEditActivity.this.deleteChar();
            } else if (i2 == 12 || i2 == 13 || i2 == 46 || i2 == 49) {
                TransmitPostEditActivity.this.refreshPostButton();
            } else if (i2 == 18) {
                if (aVar.f51944c == null || TransmitPostEditActivity.this.mAdditionData != null) {
                    int i3 = TransmitPostEditActivity.this.mLocationState;
                    if (i3 != 0) {
                        if (i3 != 2) {
                            return;
                        }
                        TransmitPostEditActivity.this.goToSelectLocationActivity();
                        return;
                    }
                    Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                    if (PermissionUtil.checkLocationForGoogle(pageActivity)) {
                        TransmitPostEditActivity.this.onLocViewClickedInInitState();
                        return;
                    } else {
                        PermissionUtil.reuqestLocation(pageActivity, 0);
                        return;
                    }
                }
                TransmitPostEditActivity.this.requestLocationIfValid();
            } else if (i2 == 20) {
                if (TransmitPostEditActivity.this.mLocationModel != null) {
                    TransmitPostEditActivity.this.mLocationModel.H(true);
                }
            } else if (i2 == 27) {
                d.b.h0.r.d0.b.j().t("xiaoying_has_click", true);
                StatisticItem statisticItem = new StatisticItem("c10645");
                statisticItem.param("fid", TransmitPostEditActivity.this.mData != null ? TransmitPostEditActivity.this.mData.getForumId() : "");
                TiebaStatic.log(statisticItem);
                if (TransmitPostEditActivity.this.mData == null || (videoInfo = TransmitPostEditActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                    TransmitPostEditActivity.this.mEditor.A(new d.b.h0.w.a(2, 19, null));
                    if (XiaoyingUtil.isXiaoyingInstalled()) {
                        if (!XiaoyingUtil.isXiaoyingForbidden()) {
                            if (TransmitPostEditActivity.this.mEditor.u()) {
                                TransmitPostEditActivity.this.mEditor.q();
                                TransmitPostEditActivity.this.mEditor.A(new d.b.h0.w.a(5, -1, null));
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
                TransmitPostEditActivity.this.mEditor.A(new d.b.h0.w.a(2, 19, " "));
                TransmitPostEditActivity.this.mEditor.A(new d.b.h0.w.a(28, 20, videoInfo));
            } else if (i2 == 29) {
                TransmitPostEditActivity.this.mEditor.A(new d.b.h0.w.a(2, 19, null));
                TransmitPostEditActivity.this.mEditor.A(new d.b.h0.w.a(1, 2, null));
                TransmitPostEditActivity.this.mData.setVideoInfo(null);
                TransmitPostEditActivity.this.refreshPostButton();
                if (TransmitPostEditActivity.this.mPostContent != null) {
                    TransmitPostEditActivity.this.mPostContent.requestFocus();
                }
                TransmitPostEditActivity.this.mEditor.q();
                TransmitPostEditActivity.this.mEditor.A(new d.b.h0.w.a(5, -1, null));
                TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
                transmitPostEditActivity.ShowSoftKeyPad(transmitPostEditActivity.mInputManager, TransmitPostEditActivity.this.mPostContent);
            } else if (i2 == 43) {
                d.b.h0.r.d0.b.j().t("hot_topic_has_click", true);
                TransmitPostEditActivity.this.mEditor.A(new d.b.h0.w.a(2, 26, null));
                TransmitPostEditActivity.this.needAddHotTopicSign = true;
                TransmitPostEditActivity.this.performHotTopicClick(true);
                if (TransmitPostEditActivity.this.getRealTitleInstance().isFocused()) {
                    TransmitPostEditActivity.this.fromWhereToHotSelect = "from_title";
                } else if (TransmitPostEditActivity.this.getRealContentEdittextInstance().isFocused()) {
                    TransmitPostEditActivity.this.fromWhereToHotSelect = "from_content";
                }
            } else if (i2 == 45) {
                TransmitPostEditActivity.this.mTitleView.setVisibility(0);
                TransmitPostEditActivity.this.mTitleView.requestFocus();
            } else if (i2 == 53) {
                if (TransmitPostEditActivity.this.mTitleView.hasFocus()) {
                    TransmitPostEditActivity.this.mPostContent.requestFocus();
                    TransmitPostEditActivity.this.mPostContent.setSelection(TransmitPostEditActivity.this.mPostContent.getText().toString().length());
                }
                TransmitPostEditActivity.this.mTitleView.setVisibility(8);
            } else if (i2 == 55 && (obj = aVar.f51944c) != null && (obj instanceof Boolean)) {
                TransmitPostEditActivity.this.isPrivacy = ((Boolean) obj).booleanValue();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public String f22134e = "";

        /* renamed from: f  reason: collision with root package name */
        public String f22135f;

        public d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.refreshPostButton();
            TransmitPostEditActivity.this.updateTitleStyle();
            EditText realTitleInstance = TransmitPostEditActivity.this.getRealTitleInstance();
            if (editable == null || realTitleInstance == null || realTitleInstance.getText() == null) {
                return;
            }
            String str = this.f22134e;
            if (str == null || !str.equals(editable.toString())) {
                if (TransmitPostEditActivity.this.mHighLightController != null) {
                    this.f22134e = realTitleInstance.getText().toString();
                    TransmitPostEditActivity.this.mHighLightController.j(realTitleInstance, true);
                    return;
                }
                return;
            }
            realTitleInstance.setSelection(realTitleInstance.getSelectionEnd());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f22135f = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String str = this.f22135f;
            if ((charSequence != null ? charSequence.toString().length() : 0) > (str != null ? str.toString().length() : 0)) {
                TransmitPostEditActivity.this.gotoHotTopicSelectActivity(charSequence, i, i3, "from_title");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public String f22137e = "";

        /* renamed from: f  reason: collision with root package name */
        public String f22138f;

        public e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.refreshPostButton();
            EditText realContentEdittextInstance = TransmitPostEditActivity.this.getRealContentEdittextInstance();
            if (editable == null || realContentEdittextInstance == null || realContentEdittextInstance.getText() == null) {
                return;
            }
            int selectionEnd = realContentEdittextInstance.getSelectionEnd();
            String str = this.f22137e;
            if (str == null || !str.equals(editable.toString())) {
                if (TransmitPostEditActivity.this.mHighLightController != null) {
                    this.f22137e = realContentEdittextInstance.getText().toString();
                    TransmitPostEditActivity.this.mHighLightController.j(realContentEdittextInstance, false);
                    return;
                }
                return;
            }
            realContentEdittextInstance.setSelection(selectionEnd);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f22138f = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String str = this.f22138f;
            if ((charSequence != null ? charSequence.toString().length() : 0) > (str != null ? str.toString().length() : 0)) {
                TransmitPostEditActivity.this.gotoHotTopicSelectActivity(charSequence, i, i3, "from_content");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 2) {
                if (TransmitPostEditActivity.this.mPostContent != null) {
                    d.b.c.e.p.l.w(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.mPostContent);
                }
                if (TransmitPostEditActivity.this.mEditor != null) {
                    TransmitPostEditActivity.this.mEditor.q();
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            view.requestFocus();
            TransmitPostEditActivity.this.mEditor.A(new d.b.h0.w.a(5, -1, null));
            TransmitPostEditActivity.this.mPostContent.requestFocus();
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.stopTask();
            TransmitPostEditActivity.this.popupSaveDraft();
        }
    }

    /* loaded from: classes5.dex */
    public class i implements TabMenuPopView.c {
        public i() {
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view, e1 e1Var) {
            if (e1Var == null) {
                return;
            }
            TransmitPostEditActivity.this.mCategoryView.setText(e1Var.f59101a);
            TransmitPostEditActivity.this.mData.setCategoryTo(e1Var.f59102b);
            TransmitPostEditActivity.this.mCategoryToID = e1Var.f59102b;
            TransmitPostEditActivity.this.mCategoryView.c();
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.mCategoryView.e();
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            transmitPostEditActivity.HidenSoftKeyPad(transmitPostEditActivity.mInputManager, TransmitPostEditActivity.this.getRealTitleInstance());
            TransmitPostEditActivity transmitPostEditActivity2 = TransmitPostEditActivity.this;
            transmitPostEditActivity2.HidenSoftKeyPad(transmitPostEditActivity2.mInputManager, TransmitPostEditActivity.this.getRealContentEdittextInstance());
        }
    }

    /* loaded from: classes5.dex */
    public class k implements TbFaceManager.a {
        public k() {
        }

        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan a(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), d.b.c.j.d.a.class);
            d.b.c.j.d.a aVar = runTask != null ? (d.b.c.j.d.a) runTask.getData() : null;
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
    public class l implements TimePickerDialog.OnTimeSetListener {
        public l() {
        }

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker timePicker, int i, int i2) {
        }
    }

    /* loaded from: classes5.dex */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.mPrefix.setVisibility(0);
            TransmitPostEditActivity.this.post_prefix_layout.setSelected(true);
            d.b.c.e.m.g.l(TransmitPostEditActivity.this.mPrefixWindow, view, 0, d.b.c.e.p.l.e(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
            TransmitPostEditActivity.this.mEditor.q();
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            transmitPostEditActivity.HidenSoftKeyPad(transmitPostEditActivity.mInputManager, TransmitPostEditActivity.this.mPostTitle);
            TransmitPostEditActivity transmitPostEditActivity2 = TransmitPostEditActivity.this;
            transmitPostEditActivity2.HidenSoftKeyPad(transmitPostEditActivity2.mInputManager, TransmitPostEditActivity.this.mPostContent);
        }
    }

    /* loaded from: classes5.dex */
    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.mPrefix.setSelected(true);
            d.b.c.e.m.g.l(TransmitPostEditActivity.this.mPrefixWindow, view, 0, d.b.c.e.p.l.e(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
            TransmitPostEditActivity.this.mEditor.q();
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            transmitPostEditActivity.HidenSoftKeyPad(transmitPostEditActivity.mInputManager, TransmitPostEditActivity.this.getRealTitleInstance());
            TransmitPostEditActivity transmitPostEditActivity2 = TransmitPostEditActivity.this;
            transmitPostEditActivity2.HidenSoftKeyPad(transmitPostEditActivity2.mInputManager, TransmitPostEditActivity.this.getRealContentEdittextInstance());
        }
    }

    /* loaded from: classes5.dex */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!d.b.c.e.p.j.z()) {
                TransmitPostEditActivity.this.showToast(R.string.neterror);
            }
            if (d.b.i0.v3.s.a.b() || TransmitPostEditActivity.this.isEmotionCountOverLimit()) {
                return;
            }
            if (TransmitPostEditActivity.this.mHighLightController.c(TransmitPostEditActivity.this.mPostTitle, TransmitPostEditActivity.this.mPostContent)) {
                TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
                transmitPostEditActivity.showToast(transmitPostEditActivity.mHighLightController.f());
                return;
            }
            TransmitPostEditActivity transmitPostEditActivity2 = TransmitPostEditActivity.this;
            transmitPostEditActivity2.HidenSoftKeyPad(transmitPostEditActivity2.mInputManager, TransmitPostEditActivity.this.getRealTitleInstance());
            TransmitPostEditActivity transmitPostEditActivity3 = TransmitPostEditActivity.this;
            transmitPostEditActivity3.HidenSoftKeyPad(transmitPostEditActivity3.mInputManager, TransmitPostEditActivity.this.getRealContentEdittextInstance());
            TransmitPostEditActivity.this.mEditor.q();
            TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 7));
            TransmitPostEditActivity.this.postPhotoTextThread();
        }
    }

    /* loaded from: classes5.dex */
    public class p implements View.OnTouchListener {
        public p() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                view.requestFocus();
                TransmitPostEditActivity.this.mEditor.A(new d.b.h0.w.a(5, -1, null));
                TransmitPostEditActivity.this.mPostContent.requestFocus();
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class q implements DialogInterface.OnCancelListener {
        public q() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            TransmitPostEditActivity.this.destroyWaitingDialog();
            TransmitPostEditActivity.this.stopTask();
        }
    }

    /* loaded from: classes5.dex */
    public class r implements AntiHelper.k {
        public r() {
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
    public class s implements NewWriteModel.g {

        /* loaded from: classes5.dex */
        public class a implements a.e {
            public a(s sVar) {
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
                TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(TransmitPostEditActivity.this.getActivity(), 0, 26, 1)));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 1));
            }
        }

        public s() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, h0 h0Var, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData == null || TransmitPostEditActivity.this.mData == null) {
                return;
            }
            TransmitPostEditActivity.this.mHighLightController.n(null);
            if (z) {
                TransmitPostEditActivity.this.sendFinishSendAction(z);
                TransmitPostEditActivity.this.showTipDialog(true, postWriteCallBackData);
                TransmitPostEditActivity.this.sendUpdatePhotoLiveMessage(postWriteCallBackData);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                TransmitPostEditActivity.this.setResult(-1, intent);
                TransmitPostEditActivity.this.finish();
            } else if (postWriteCallBackData.isSensitiveError()) {
                TransmitPostEditActivity.this.showToast(postWriteCallBackData.getErrorString());
                TransmitPostEditActivity.this.mHighLightController.o(postWriteCallBackData.getErrorString());
                TransmitPostEditActivity.this.mHighLightController.n(postWriteCallBackData.getSensitiveWords());
                TransmitPostEditActivity.this.mHighLightController.i(TransmitPostEditActivity.this.mPostTitle, TransmitPostEditActivity.this.mPostContent);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (d.b.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.s(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                } else {
                    DefaultNavigationBarCoverTip.s(TransmitPostEditActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(TransmitPostEditActivity.this.getActivity());
                if (d.b.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.setMessage(TransmitPostEditActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.setMessage(postWriteCallBackData.getErrorString());
                }
                aVar.setNegativeButton(R.string.cancel, new a(this));
                aVar.setPositiveButton(R.string.open_now, new b());
                aVar.create(TransmitPostEditActivity.this.getPageContext()).show();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 1));
            } else if (postWriteCallBackData == null || !d.b.i0.n3.a.c(postWriteCallBackData.getErrorCode())) {
                if ((h0Var == null || writeData == null || h0Var.c() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.showTipDialog(false, postWriteCallBackData);
                } else if (h0Var != null && writeData != null && h0Var.c() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(h0Var.b());
                    writeData.setVcodeUrl(h0Var.c());
                    writeData.setVcodeExtra(h0Var.a());
                    if (d.b.h0.a1.a.b(h0Var.d())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, h0Var.d())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, 12006)));
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                } else {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements LocationModel.e {
        public t() {
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void a() {
            TransmitPostEditActivity.this.showToast(R.string.no_network_guide);
            TransmitPostEditActivity.this.sendLocaionAction(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b(LocationData locationData) {
            if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                TransmitPostEditActivity.this.sendLocaionAction(2, true, locationData.getFormatted_address());
            } else {
                onFail(null);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void onFail(String str) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            if (StringUtils.isNull(str)) {
                str = TransmitPostEditActivity.this.getPageContext().getString(R.string.location_fail);
            }
            transmitPostEditActivity.showToast(str);
            TransmitPostEditActivity.this.sendLocaionAction(0, true, null);
        }
    }

    /* loaded from: classes5.dex */
    public class u extends CustomMessageListener {
        public u(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.mLocationModel.H(false);
                    TransmitPostEditActivity.this.mLocationModel.G(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.sendLocaionAction(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.mLocationModel.H(true);
                TransmitPostEditActivity.this.sendLocaionAction(0, true, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v extends CustomMessageListener {
        public v(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes5.dex */
    public class w implements View.OnClickListener {
        public w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.mEditor.A(new d.b.h0.w.a(5, -1, null));
            int emotionCheck = TransmitPostEditActivity.this.emotionCheck();
            if (emotionCheck < 0 || emotionCheck >= TransmitPostEditActivity.this.mPostContent.getText().length()) {
                return;
            }
            TransmitPostEditActivity.this.mPostContent.setSelection(emotionCheck);
        }
    }

    /* loaded from: classes5.dex */
    public class x implements a.e {
        public x() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            TransmitPostEditActivity.this.sendLocaionAction(0, true, null);
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class y implements a.e {
        public y() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            if (d.b.c.e.p.j.z()) {
                TransmitPostEditActivity.this.sendLocaionAction(1, true, null);
                TransmitPostEditActivity.this.mLocationModel.F();
            } else {
                TransmitPostEditActivity.this.mOnLocationCallBack.a();
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class z extends GestureDetector.SimpleOnGestureListener {
        public z() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            d.b.c.e.p.l.w(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f2, f3);
        }

        public /* synthetic */ z(TransmitPostEditActivity transmitPostEditActivity, k kVar) {
            this();
        }
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
        ForumTabSelectedView forumTabSelectedView;
        FrsTabItemData selectedTabItemData;
        if (this.mData == null || (forumTabSelectedView = this.mForumTabSelectedView) == null || (selectedTabItemData = forumTabSelectedView.getSelectedTabItemData()) == null) {
            return;
        }
        this.mData.setTabId(selectedTabItemData.tabId);
        this.mData.setTabName(selectedTabItemData.name);
        this.mData.setIsGeneralTab(selectedTabItemData.isGeneralTab);
    }

    private void changeHotTopicData(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData == null) {
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
        EditorTools editorTools = this.mEditor;
        if (editorTools != null) {
            editorTools.setBarLauncherEnabled(!this.isDisalbeButtons);
            this.mEditor.setToolEnabled(true, 26);
        }
    }

    private boolean checkVideoEasterEgg(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || d.b.c.e.p.k.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
        return true;
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

    /* JADX INFO: Access modifiers changed from: private */
    public EditText getRealContentEdittextInstance() {
        return this.mPostContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText getRealTitleInstance() {
        return this.mPostTitle;
    }

    private String getThreadContent() {
        if (getRealContentEdittextInstance() == null || getRealContentEdittextInstance().getText() == null) {
            return "";
        }
        String obj = getRealContentEdittextInstance().getText().toString();
        if (StringUtils.isNull(obj)) {
            OriginalThreadInfo.ShareInfo shareInfo = this.mOriginalThreadInfo;
            if (shareInfo != null && shareInfo.showType == 3) {
                return getString(R.string.share_video_default);
            }
            return getString(R.string.share_txt_default);
        }
        return obj;
    }

    private String getThreadTitle() {
        TextView textView;
        if (this.mData == null || getRealTitleInstance() == null || getRealTitleInstance().getVisibility() != 0 || getRealTitleInstance().getText() == null) {
            return "";
        }
        String obj = getRealTitleInstance().getText().toString();
        PostPrefixData postPrefixData = this.mPrefixData;
        if (postPrefixData != null && ListUtils.getCount(postPrefixData.getPrefixs()) > 0 && this.mCurrPrefixPos != 0 && this.mData.getType() != 4 && (textView = this.mPrefix) != null && textView.getText() != null) {
            obj = this.mPrefix.getText().toString() + obj;
        }
        PostPrefixData postPrefixData2 = this.mPrefixData;
        if (postPrefixData2 != null && !StringUtils.isNull(postPrefixData2.getImplicitTitle())) {
            obj = this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        if (TextUtils.isEmpty(obj)) {
            if (TextUtils.isEmpty(this.mData.getContent())) {
                return getString(R.string.share_txt_default);
            }
            if (getString(R.string.share_txt_default).equals(this.mData.getContent())) {
                return getString(R.string.share_txt_default);
            }
            return getString(R.string.share_video_default).equals(this.mData.getContent()) ? getString(R.string.share_video_default) : obj;
        }
        return obj;
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

    private void hideEditorTopicTip() {
        d.b.i0.v3.v.g gVar = this.mTipController;
        if (gVar != null) {
            gVar.b();
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
        this.mCategoryList = null;
        this.mCategoryFromID = -1;
        this.mCategoryToID = -1;
        e0 b2 = d0.a().b(1);
        if (b2 == null) {
            return;
        }
        this.mCategoryList = b2.f59100b;
        this.mCategoryFromID = getIntent().getIntExtra("category_id", -1);
        List<c0> list = this.mCategoryList;
        if (list == null || list.isEmpty() || this.mCategoryFromID < 0) {
            return;
        }
        c0 c0Var = new c0();
        this.mCategoryDefault = c0Var;
        c0Var.f59061b = 0;
        c0Var.f59060a = getPageContext().getResources().getString(R.string.category_auto);
        c0 c0Var2 = this.mCategoryDefault;
        this.mCategoryToID = c0Var2.f59061b;
        this.mCategoryName = c0Var2.f59060a;
        for (c0 c0Var3 : this.mCategoryList) {
            int i2 = c0Var3.f59061b;
            if (i2 == this.mCategoryFromID) {
                this.mCategoryToID = i2;
                this.mCategoryName = c0Var3.f59060a;
                return;
            }
        }
    }

    private void initCategoryUI() {
        List<c0> list = this.mCategoryList;
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
        this.mCategoryView.setCategoryContainerClickCallback(new i());
        linearLayout.setOnClickListener(new j());
    }

    private void initCommonEditorTools() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.mEditor.d(new d.b.h0.w.o.a(getActivity(), 2));
        if (this.mAdditionData == null) {
            if (this.mWriteTool == null) {
                d.b.i0.v3.n.b bVar = new d.b.i0.v3.n.b(getActivity(), this.mCallFrom);
                this.mWriteTool = bVar;
                bVar.i();
                this.mWriteTool.m(FROM_SHARE_WRITE);
                this.mWriteTool.j(this.mData.getForumId(), this.mPrivateThread);
            }
            this.mEditor.d(this.mWriteTool);
        }
        this.mEditor.h(arrayList);
        d.b.h0.w.m n2 = this.mEditor.n(5);
        if (n2 != null) {
            n2.j = 1;
        }
    }

    private void initData(Bundle bundle) {
        String stringExtra;
        String str;
        NewWriteModel newWriteModel = new NewWriteModel(this);
        this.mWriteModel = newWriteModel;
        newWriteModel.d0(this.mOnPostWriteCallback);
        this.mDialogCancelListener = new q();
        WriteData writeData = new WriteData();
        this.mData = writeData;
        if (bundle != null) {
            writeData.setType(bundle.getInt("type", 0));
            this.mData.setForumId(bundle.getString("forum_id"));
            this.mData.setForumName(bundle.getString("forum_name"));
            this.mData.setFirstDir(bundle.getString(IntentConfig.FORUM_FIRST_DIR));
            this.mData.setSecondDir(bundle.getString(IntentConfig.FORUM_SECOND_DIR));
            this.mData.setThreadId(bundle.getString("thread_id"));
            stringExtra = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string = bundle.getString("addition_data");
            if (!StringUtils.isNull(string)) {
                this.mAdditionData = (AdditionData) OrmObject.objectWithJsonStr(string, AdditionData.class);
            }
            this.mData.setIsAddition(this.mAdditionData != null);
            String string2 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string2)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string2, PostPrefixData.class);
            }
            String string3 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string3)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string3, PostTopicData.class);
            }
            this.mFrom = bundle.getString("from");
            this.mPrivateThread = bundle.getInt("private_thread");
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mCallFrom = bundle.getString("KEY_CALL_FROM");
            String string4 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string4)) {
                this.mOriginalThreadInfo = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string4, OriginalThreadInfo.ShareInfo.class);
            }
            this.mBaijiahaoData = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.mTransmitOriginThreadComment = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.mTransmitThreadAuthorNameShow = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.mFrsTabList = (FrsTabInfoData) bundle.getSerializable("tab_list");
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setFirstDir(intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR));
            this.mData.setSecondDir(intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            AdditionData additionData = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mAdditionData = additionData;
            this.mData.setIsAddition(additionData != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mCallFrom = intent.getStringExtra("KEY_CALL_FROM");
            stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
            this.mOriginalThreadInfo = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            this.mTransmitOriginThreadComment = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.mTransmitThreadAuthorNameShow = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.mFrsTabList = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (stringExtra != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.mData.getType() == 4 ? 6 : 9);
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        PostPrefixData postPrefixData = this.mPrefixData;
        if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
        }
        OriginalThreadInfo.ShareInfo shareInfo = this.mOriginalThreadInfo;
        if (shareInfo != null && (str = shareInfo.videoId) != null) {
            this.mData.setVideoId(str);
            this.mData.setOriginalVideoCover(this.mOriginalThreadInfo.showPicUrl);
            this.mData.setOriginalVideoTitle(this.mOriginalThreadInfo.showText);
        }
        if (!d.b.c.e.p.k.isEmpty(this.mTransmitOriginThreadComment)) {
            if (!d.b.c.e.p.k.isEmpty(this.mTransmitThreadAuthorNameShow)) {
                WriteData writeData2 = this.mData;
                writeData2.setContent("//@" + this.mTransmitThreadAuthorNameShow + " :" + this.mTransmitOriginThreadComment);
            } else {
                this.mData.setContent(this.mTransmitOriginThreadComment);
            }
        }
        WriteData writeData3 = this.mData;
        if (writeData3 != null && writeData3.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.isFeedBackBar = true;
        }
        initCategoryData();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        EditorTools editorTools = new EditorTools(getActivity());
        this.mEditor = editorTools;
        editorTools.setBarMaxLauCount(4);
        this.mEditor.setMoreButtonAtEnd(true);
        this.mEditor.setBarLauncherType(1);
        this.mEditor.C(true);
        this.mEditor.D(true);
        this.mEditor.setBackgroundColorId(R.color.CAM_X0207);
        initCommonEditorTools();
        this.mEditor.f();
        LinearLayout linearLayout = this.mToolView;
        if (linearLayout != null) {
            linearLayout.addView(this.mEditor);
        }
        initEditorListener();
        this.mEditor.j();
        d.b.h0.w.h m2 = this.mEditor.m(6);
        if (m2 != null && !TextUtils.isEmpty(this.mDisableAudioMessage)) {
            ((View) m2).setOnClickListener(new b());
        }
        if (!this.isLivePhotoType) {
            this.mEditor.A(new d.b.h0.w.a(34, 5, 1));
        }
        this.mEditor.q();
        if (XiaoyingUtil.showXiaoyingTool() && !d.b.h0.r.d0.b.j().g("xiaoying_has_click", false)) {
            this.mEditor.A(new d.b.h0.w.a(2, 19, "N"));
        }
        if (!d.b.h0.r.d0.b.j().g("hot_topic_has_click", false)) {
            this.mEditor.A(new d.b.h0.w.a(2, 26, " "));
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(PlayerPostEvent.MEDIA_REP_CHANGE_END);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
        showEditorTopicTip();
    }

    private void initEditorListener() {
        c cVar = new c();
        this.mEditor.setActionListener(31, cVar);
        this.mEditor.setActionListener(16, cVar);
        this.mEditor.setActionListener(14, cVar);
        this.mEditor.setActionListener(24, cVar);
        this.mEditor.setActionListener(3, cVar);
        this.mEditor.setActionListener(10, cVar);
        this.mEditor.setActionListener(11, cVar);
        this.mEditor.setActionListener(12, cVar);
        this.mEditor.setActionListener(13, cVar);
        this.mEditor.setActionListener(15, cVar);
        this.mEditor.setActionListener(18, cVar);
        this.mEditor.setActionListener(20, cVar);
        this.mEditor.setActionListener(25, cVar);
        this.mEditor.setActionListener(27, cVar);
        this.mEditor.setActionListener(29, cVar);
        this.mEditor.setActionListener(43, cVar);
        this.mEditor.setActionListener(45, cVar);
        this.mEditor.setActionListener(53, cVar);
        this.mEditor.setActionListener(48, cVar);
        this.mEditor.setActionListener(46, cVar);
        this.mEditor.setActionListener(49, cVar);
        this.mEditor.setActionListener(47, cVar);
        this.mEditor.setActionListener(55, cVar);
    }

    private void initForumTabSelected() {
        ForumTabSelectedView forumTabSelectedView = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.mForumTabSelectedView = forumTabSelectedView;
        forumTabSelectedView.setBgColor(R.color.CAM_X0205);
        this.mForumTabSelectedView.setData(this.mFrsTabList);
        this.mForumTabSelectedView.setActivity(this);
    }

    private void initOriginalThread() {
        OriginalThreadCardView originalThreadCardView = (OriginalThreadCardView) findViewById(R.id.write_original_thread_cardview);
        this.mOriginalThreadCardView = originalThreadCardView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) originalThreadCardView.getLayoutParams();
        layoutParams.topMargin -= TBDS24;
        int i2 = TBDS44;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i2;
        this.mOriginalThreadCardView.setLayoutParams(layoutParams);
        this.mOriginalThreadCardView.setVisibility(0);
        this.mOriginalThreadCardView.e(this.mOriginalThreadInfo);
        this.mOriginalThreadCardView.setEnabled(false);
    }

    private void initPostTopic() {
        PostTopicData postTopicData;
        WriteData writeData = this.mData;
        if (writeData == null || writeData.getType() != 0 || this.mData.getType() != 9 || this.isFeedBackBar || (postTopicData = this.mPostTopicData) == null || StringUtils.isNull(postTopicData.getTitleTopic())) {
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
        this.mPrefix = (TextView) findViewById(R.id.post_prefix);
        this.prefix_divider = findViewById(R.id.prefix_divider);
        this.mPrefixIcon = (ImageView) findViewById(R.id.prefix_icon);
        PostPrefixData postPrefixData = this.mPrefixData;
        if (postPrefixData != null && postPrefixData.getPrefixs().size() > 1) {
            this.post_prefix_layout.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.mCurrPrefixPos = 1;
            this.post_prefix_layout.setOnClickListener(new m());
            ImageView imageView = (ImageView) findViewById(R.id.prefix_icon);
            this.mPrefixIcon = imageView;
            if (size > 1) {
                imageView.setVisibility(0);
                this.mPrefix.setOnClickListener(new n());
            }
            d.b.i0.v3.i iVar = new d.b.i0.v3.i(getPageContext().getPageActivity());
            this.mPrefixWindow = iVar;
            iVar.e(this);
            this.mPrefixWindow.d(d.b.c.e.p.l.g(getActivity(), R.dimen.ds510));
            this.mPrefixWindow.setOutsideTouchable(true);
            this.mPrefixWindow.setFocusable(true);
            this.mPrefixWindow.setOnDismissListener(this);
            this.mPrefixWindow.setBackgroundDrawable(SkinManager.getDrawable(R.color.CAM_X0201));
            int color = SkinManager.getColor(R.color.CAM_X0105);
            int color2 = SkinManager.getColor(R.color.CAM_X0108);
            SkinManager.setBackgroundResource(this.mPrefix, R.color.CAM_X0201);
            SkinManager.setImageResource(this.mPrefixIcon, R.drawable.icon_frs_arrow_n);
            this.mPrefix.setTextColor(color);
            this.mPrefixItems.clear();
            for (int i2 = 0; i2 < size; i2++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.mPrefixItems.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i2));
                if (i2 == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i2 != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.mPrefixWindow.a(writePrefixItemLayout);
            }
            this.mPrefixWindow.c(0);
            this.mPrefix.setText(prefixs.get(1));
            resetCheckImgState(1);
            return;
        }
        this.post_prefix_layout.setVisibility(8);
    }

    private void initTopicDataInView() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) ListUtils.getItem(this.mList, 0);
        if (hotTopicBussinessData == null || TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            return;
        }
        this.mPostTitle.setText(d.b.h0.p0.b.j(d.b.h0.p0.b.a(hotTopicBussinessData.mTopicName)));
        this.mPostTitle.setMovementMethod(d.b.i0.u3.c.a());
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
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle("");
        this.mName = centerTextTitle;
        SkinManager.setViewTextColor(centerTextTitle, R.color.CAM_X0105);
        setPostView();
        ScrollView scrollView = (ScrollView) findViewById(R.id.write_scrollview);
        this.write_scrollview = scrollView;
        scrollView.setOnTouchListener(new f());
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mParent = (RelativeLayout) findViewById(R.id.parent);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.tool_view);
        this.mToolView = linearLayout;
        linearLayout.setContentDescription(IStringUtil.TOP_PATH);
        this.mTitleView = (LinearLayout) findViewById(R.id.title_view);
        this.mInterval = findViewById(R.id.interval_view);
        this.mHotTopicEdt = (TextView) findViewById(R.id.hot_topic_title_edt);
        initializePostTitle();
        if (this.isLivePhotoType) {
            this.write_scrollview.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        initializePostContent();
        initOriginalThread();
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.post_content_container);
        this.mPostContentContainer = linearLayout2;
        linearLayout2.setDrawingCacheEnabled(false);
        this.mPostContentContainer.setOnClickListener(new g());
        this.mBack.setOnFocusChangeListener(this.mFocusChangeListener);
        this.mBack.setOnClickListener(new h());
        initCategoryUI();
        intializePostButton();
        updataTitle();
        changeToolButtonStatus();
        initAddition();
        initPrefix();
        initTopicDataInView();
        initForumTabSelected();
        if (this.mData.getType() == 4 && (view = this.post_prefix_layout) != null && this.prefix_divider != null) {
            view.setVisibility(8);
            this.prefix_divider.setVisibility(8);
        }
        refreshPostButton();
        ShowSoftKeyPad(this.mInputManager, this.mPostTitle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isEmotionCountOverLimit() {
        if (((ImageSpan[]) getRealContentEdittextInstance().getText().getSpans(0, getRealContentEdittextInstance().getText().length(), ImageSpan.class)).length > 10) {
            if (this.mTooManyEmotionToast == null) {
                this.mTooManyEmotionToast = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.mTooManyEmotionToast.getView().isShown()) {
                this.mTooManyEmotionToast.cancel();
            }
            this.mTooManyEmotionToast.show();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTextFull() {
        return getRealContentEdittextInstance().getText() != null && getRealContentEdittextInstance().getText().length() >= (this.mAdditionData != null ? 1000 : 5000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performHotTopicClick(boolean z2) {
        if (d.b.h0.p0.b.c(getPageContext(), z2, false)) {
            return;
        }
        HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
        WriteData writeData = this.mData;
        if (writeData != null) {
            hotSelectActivityConfig.setForumExtra(d.b.c.e.m.b.f(writeData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
        }
        sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void popupSaveDraft() {
        WriteData writeData = this.mData;
        if (writeData == null) {
            finish();
            return;
        }
        writeData.setTitle(getRealTitleInstance().getText().toString());
        this.mData.setContent(getRealContentEdittextInstance().getText().toString());
        finish();
    }

    private void postNewMessage() {
        HotTopicBussinessData hotTopicBussinessData;
        stopTask();
        this.mData.setContent(getThreadContent());
        this.mData.setTitle(getThreadTitle());
        int i2 = this.mCategoryFromID;
        if (i2 >= 0) {
            this.mData.setCategoryFrom(i2);
        }
        int i3 = this.mCategoryToID;
        if (i3 >= 0) {
            this.mData.setCategoryTo(i3);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        WriteData writeData = this.mData;
        LocationModel locationModel = this.mLocationModel;
        writeData.setHasLocationData(locationModel != null && locationModel.v());
        this.mWriteModel.Z(this.writeImagesInfo.size() > 0);
        if (!ListUtils.isEmpty(this.mList) && (hotTopicBussinessData = this.mCurrHotData) != null && hotTopicBussinessData.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(hotTopicBussinessData.mForumId));
            this.mData.setForumName(this.mCurrHotData.mForumName);
        }
        addTabInfoForPostWriteIfNeed();
        this.mWriteModel.f0(this.mData);
        WriteData writeData2 = this.mData;
        writeData2.setContent(writeData2.getContent().replaceAll("\u0000\n", ""));
        WriteData writeData3 = this.mData;
        writeData3.setContent(writeData3.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.mWriteModel.T().setVoice(null);
        this.mWriteModel.T().setVoiceDuringTime(-1);
        if (!d.b.c.e.p.j.z()) {
            showToast(R.string.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.sending), this.mDialogCancelListener);
        this.mWriteModel.i0();
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
        this.mData.setIsShareThread(true);
        OriginalThreadInfo.ShareInfo shareInfo = this.mOriginalThreadInfo;
        if (shareInfo != null && !StringUtils.isNull(shareInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setBaijiahaoData(this.mBaijiahaoData);
        OriginalThreadInfo.ShareInfo shareInfo2 = this.mOriginalThreadInfo;
        if (shareInfo2 != null) {
            this.mData.setOriBaijiahaoData(shareInfo2.oriUgcInfo);
        }
        this.mData.setCallFrom(this.mCallFrom);
        postNewMessage();
    }

    private void realInsert(SpannableStringBuilder spannableStringBuilder, int i2, d.b.c.j.d.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder == null || getRealContentEdittextInstance() == null || getRealContentEdittextInstance().getText() == null) {
            return;
        }
        Bitmap p2 = aVar.p();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(p2);
        int width = p2.getWidth();
        if (emotionGroupType != EmotionGroupType.USER_COLLECT && emotionGroupType != EmotionGroupType.BIG_EMOTION) {
            if (emotionGroupType == EmotionGroupType.LOCAL) {
                width = 55;
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
            if (getRealContentEdittextInstance() instanceof SpanGroupEditText) {
                this.mContentBuilder.append((CharSequence) ((SpanGroupEditText) getRealContentEdittextInstance()).getSpanGroupManager().p());
            } else {
                this.mContentBuilder.append((CharSequence) text);
            }
            text.clear();
            if (getRealContentEdittextInstance() instanceof SpanGroupEditText) {
                ((SpanGroupEditText) getRealContentEdittextInstance()).getSpanGroupManager().k();
            }
            text.append((CharSequence) this.mContentBuilder);
            if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && getRealContentEdittextInstance().length() > spannableStringBuilder.length() + i2 + spannableString2.length()) {
                getRealContentEdittextInstance().setSelection(i2 + spannableStringBuilder.length() + spannableString2.length());
            } else {
                getRealContentEdittextInstance().setSelection(i2 + spannableStringBuilder.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshPostButton() {
        if (this.mData == null) {
            return;
        }
        String obj = getRealTitleInstance() != null ? getRealTitleInstance().getText().toString() : "";
        String trim = getRealContentEdittextInstance() != null ? getRealContentEdittextInstance().getText().toString().trim() : "";
        String trim2 = obj.trim();
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            PostPrefixData postPrefixData = this.mPrefixData;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                this.mPrefixData.getPrefixs();
                if (this.mCurrPrefixPos == 0) {
                    if (TextUtils.isEmpty(trim2)) {
                        this.mData.setIsNoTitle(true);
                    } else {
                        this.mData.setIsNoTitle(false);
                        setPostButtonEnabled(true);
                        return;
                    }
                } else {
                    this.mData.setIsNoTitle(false);
                    setPostButtonEnabled(true);
                    return;
                }
            } else if (TextUtils.isEmpty(trim2)) {
                this.mData.setIsNoTitle(true);
            } else {
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
        if (!TextUtils.isEmpty(trim)) {
            setPostButtonEnabled(true);
        } else if (this.mData.getVideoInfo() != null) {
            setPostButtonEnabled(true);
        } else {
            setPostButtonEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestLocationIfValid() {
        if (this.mLocationModel.v()) {
            if (this.mLocationModel.z()) {
                sendLocaionAction(2, true, d.b.i0.d3.m0.b.a().b().getFormatted_address());
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
        EditorTools editorTools;
        if (this.isLivePhotoType || (editorTools = this.mEditor) == null) {
            return;
        }
        editorTools.A(new d.b.h0.w.a(12, -1, new d.b.h0.w.r.a(this.writeImagesInfo, true)));
        this.mEditor.A(new d.b.h0.w.a(12, 11, new d.b.h0.w.r.a(this.writeImagesInfo, true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUpdatePhotoLiveMessage(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
    }

    private void setPostButtonEnabled(boolean z2) {
        SkinManager.setNavbarTitleColor(this.mPost, R.color.CAM_X0302, R.color.s_navbar_title_color);
    }

    private void setPostView() {
        TextView addTextButton = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
        this.mPost = addTextButton;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) addTextButton.getLayoutParams();
        layoutParams.rightMargin = d.b.c.e.p.l.g(getPageContext().getPageActivity(), R.dimen.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.mFocusChangeListener);
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
        d.b.c.e.p.l.L(getPageContext().getPageActivity(), sb.toString());
    }

    private void showEditorTopicTip() {
        if (this.mTipController == null) {
            this.mTipController = new d.b.i0.v3.v.g(getPageContext());
        }
        this.mTipController.c(this.mEditor);
    }

    private void showLocPermissionDialog() {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(getPageContext().getPageActivity());
        aVar.setMessageId(R.string.location_app_permission_prompt).setPositiveButton(R.string.isopen, new y()).setNegativeButton(R.string.cancel, new x()).create(getPageContext());
        aVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTipDialog(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null) {
            return;
        }
        String errorString = postWriteCallBackData.getErrorString();
        if (AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
            if (AntiHelper.w(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.mAntiInjectListener) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
            }
        } else if (postWriteCallBackData.getErrorCode() != 0) {
            String errorString2 = postWriteCallBackData.getErrorString();
            if (TextUtils.isEmpty(errorString2)) {
                errorString2 = getPageContext().getPageActivity().getString(R.string.send_share_thread_fail);
            }
            showToast(errorString2);
        } else if (this.mData.getType() != 7) {
            if (this.mAdditionData == null) {
                if (checkVideoEasterEgg(postWriteCallBackData)) {
                    return;
                }
                d.b.i0.d3.q0.g.b(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                return;
            }
            showAdditionTip(z2, errorString);
        }
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
            if (type == 4) {
                this.mName.setText(R.string.publish_photo_live);
                this.mPostContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                return;
            } else if (type != 9) {
                this.mName.setText(R.string.send_reply);
                this.mPostContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.mPostTitle.setVisibility(8);
                return;
            }
        }
        String str3 = this.mCallFrom;
        if (str3 != null && str3.equals("1")) {
            this.mName.setText(R.string.share_to_home_page);
        } else {
            String str4 = this.mCallFrom;
            if (str4 != null && str4.equals("2")) {
                String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.mData.getForumName(), 9, true, false);
                if (fixedBarText.length() < 14) {
                    str2 = fixedBarText + getResources().getString(R.string.bar);
                } else {
                    str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                }
                this.mName.setText(str2);
            } else {
                this.mName.setText("");
            }
        }
        this.mPostTitle.setVisibility(0);
        this.mPostContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHintTextColor() {
        if (this.mPostTitle.hasFocus()) {
            this.mPostTitle.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        } else {
            this.mPostTitle.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
        }
        if (this.mPostContent.hasFocus()) {
            this.mPostContent.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        } else {
            this.mPostContent.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTitleStyle() {
        EditText editText = this.mPostTitle;
        if (editText == null) {
            return;
        }
        if (editText.getText().toString().length() == 0) {
            this.mPostTitle.getPaint().setFakeBoldText(false);
        } else if (this.mPostTitle.getText().toString().length() > 0) {
            this.mPostTitle.getPaint().setFakeBoldText(true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.mLoadingDialog.h(false);
    }

    public void deleteChar() {
        if (getRealContentEdittextInstance().getSelectionStart() > 0) {
            String substring = getRealContentEdittextInstance().getText().toString().substring(0, getRealContentEdittextInstance().getSelectionStart());
            Matcher matcher = d.b.i0.k0.a.f57842b.matcher(substring);
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

    public void initTitleView() {
        if (!ListUtils.isEmpty(this.mList)) {
            this.mTitleView.setVisibility(0);
            this.mTitleView.requestFocus();
            return;
        }
        this.mTitleView.setVisibility(8);
    }

    public void initializePostContent() {
        SpanGroupEditText spanGroupEditText = (SpanGroupEditText) findViewById(R.id.post_content);
        this.mPostContent = spanGroupEditText;
        spanGroupEditText.setDrawingCacheEnabled(false);
        this.mPostContent.setOnClickListener(this.mEditOnClicked);
        NewWriteModel newWriteModel = this.mWriteModel;
        if (newWriteModel != null) {
            newWriteModel.setSpanGroupManager(this.mPostContent.getSpanGroupManager());
        }
        WriteData writeData = this.mData;
        if (writeData != null) {
            writeData.setSpanGroupManager(this.mPostContent.getSpanGroupManager());
        }
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            this.mPostContent.setText(TbFaceManager.e().j(getPageContext().getPageActivity(), this.mData.getContent()));
            SpanGroupEditText spanGroupEditText2 = this.mPostContent;
            spanGroupEditText2.setSelection(spanGroupEditText2.getText().length());
        }
        if (!d.b.c.e.p.k.isEmpty(this.mTransmitOriginThreadComment)) {
            this.mPostContent.setSelection(0);
        }
        this.mPostContent.setOnFocusChangeListener(this.mFocusChangeListener);
        this.mPostContent.setOnTouchListener(new p());
        this.mPostContent.addTextChangedListener(this.mWriteContentTextWatcher);
        OriginalThreadInfo.ShareInfo shareInfo = this.mOriginalThreadInfo;
        if (shareInfo != null && shareInfo.showType == 3) {
            this.mPostContent.setHint(R.string.share_video_default);
        } else {
            this.mPostContent.setHint(R.string.share_txt_default);
        }
    }

    public void initializePostTitle() {
        EditText editText = (EditText) findViewById(R.id.post_title);
        this.mPostTitle = editText;
        editText.setOnClickListener(this.mEditOnClicked);
        this.mPostTitle.setOnFocusChangeListener(this.mFocusChangeListener);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.mPostTitle.setText(this.mData.getTitle());
            this.mPostTitle.setSelection(this.mData.getTitle().length());
        }
        this.mPostTitle.addTextChangedListener(this.mWriteTitleTextWatcher);
        if (!this.mData.getHaveDraft()) {
            initPostTopic();
        }
        this.mPostTitle.setHint(getResources().getString(R.string.post_title_hint));
    }

    public void insertFaceIconToEditText(d.b.h0.s.c.v vVar) {
        if (((ImageSpan[]) getRealContentEdittextInstance().getText().getSpans(0, getRealContentEdittextInstance().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.mTooManyEmotionToast == null) {
                this.mTooManyEmotionToast = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.mTooManyEmotionToast.getView().isShown()) {
                this.mTooManyEmotionToast.cancel();
            }
            this.mTooManyEmotionToast.show();
            return;
        }
        d.b.i0.k0.b.b(this, vVar, getRealContentEdittextInstance());
    }

    public void intializePostButton() {
        this.mPost.setOnClickListener(new o());
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
                }
                if (i2 == 12002) {
                    if (intent == null || !intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        return;
                    }
                    this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    return;
                } else if (i2 != 12006) {
                    if (i2 != 25004) {
                        return;
                    }
                    if ("from_title".equals(this.fromWhereToHotSelect)) {
                        getRealTitleInstance().requestFocus();
                        return;
                    } else if ("from_content".equals(this.fromWhereToHotSelect)) {
                        getRealContentEdittextInstance().requestFocus();
                        return;
                    } else {
                        return;
                    }
                } else if (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) || (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                } else {
                    showToast(postWriteCallBackData.getErrorString());
                    this.mHighLightController.o(postWriteCallBackData.getErrorString());
                    this.mHighLightController.n(postWriteCallBackData.getSensitiveWords());
                    this.mHighLightController.i(this.mPostTitle, this.mPostContent);
                    return;
                }
            }
            return;
        }
        PostWriteCallBackData postWriteCallBackData2 = null;
        postWriteCallBackData2 = null;
        postWriteCallBackData2 = null;
        if (i2 == 12004) {
            EditorTools editorTools2 = this.mEditor;
            if (editorTools2 != null && !editorTools2.u()) {
                getRealContentEdittextInstance().requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
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
            sendUpdatePhotoLiveMessage(postWriteCallBackData2);
            setResult(-1, intent);
            finish();
        } else if (i2 != 25004) {
            if (i2 != 25005 || intent == null || ListUtils.isEmpty(this.mList) || ListUtils.isEmpty(this.mList) || intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) >= this.mList.size()) {
                return;
            }
            HotTopicBussinessData hotTopicBussinessData = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
            this.mCurrHotData = hotTopicBussinessData;
            changeHotTopicData(hotTopicBussinessData);
        } else if (intent != null) {
            String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
            if (StringUtils.isNull(stringExtra)) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.needAddHotTopicSign) {
                sb2.append(d.b.h0.p0.b.f50812a);
                this.needAddHotTopicSign = false;
            }
            sb2.append(stringExtra);
            addHotTopic(sb2.toString());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        getLayoutMode().k(i2 == 1);
        getLayoutMode().j(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        SkinManager.setViewTextColor(this.mPost, R.color.CAM_X0302, 1);
        changeToolButtonStatus();
        SkinManager.setBackgroundColor(this.mInterval, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(getRealTitleInstance(), R.color.CAM_X0201);
        SkinManager.setBackgroundColor(getRealContentEdittextInstance(), R.color.CAM_X0201);
        refreshPostButton();
        this.mEditor.w(i2);
        PostCategoryView postCategoryView = this.mCategoryView;
        if (postCategoryView != null) {
            postCategoryView.b();
        }
        SkinManager.setViewTextColor(this.mName, R.color.CAM_X0105);
        updateHintTextColor();
        updateTitleStyle();
        d.b.i0.v3.v.c cVar = this.mHighLightController;
        if (cVar != null) {
            cVar.m(getRealTitleInstance(), getRealContentEdittextInstance());
        }
        OriginalThreadCardView originalThreadCardView = this.mOriginalThreadCardView;
        if (originalThreadCardView != null) {
            originalThreadCardView.n();
        }
        ForumTabSelectedView forumTabSelectedView = this.mForumTabSelectedView;
        if (forumTabSelectedView != null) {
            forumTabSelectedView.k(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new z(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        initUI();
        LocationModel locationModel = new LocationModel(getPageContext());
        this.mLocationModel = locationModel;
        locationModel.I(this.mOnLocationCallBack);
        registerListener(this.mOnSelectLocationListener);
        registerListener(this.mUegValidateListener);
        initEditor();
        this.mPostContent.requestFocus();
        initTitleView();
        sendSetImgAction();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        d.b.i0.u3.b bVar = new d.b.i0.u3.b(getPageContext().getPageActivity(), new l(), new Date().getHours(), new Date().getMinutes(), false);
        this.dialog = bVar;
        bVar.setTitle(R.string.no_disturb_start_time);
        this.dialog.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.dialog);
        this.dialog.setButton(-2, getPageContext().getString(R.string.cancel), this.dialog);
        return this.dialog;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        hideEditorTopicTip();
        TiebaPrepareImageService.StopService();
        stopTask();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.post_prefix_layout.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        Editable text;
        int selectionStart;
        if (i2 == 4) {
            d.b.i0.v3.i iVar = this.mPrefixWindow;
            if (iVar != null && iVar.isShowing()) {
                d.b.c.e.m.g.d(this.mPrefixWindow, getPageContext().getPageActivity());
                return true;
            } else if (this.mEditor.u()) {
                this.mEditor.q();
                return true;
            } else {
                stopTask();
                popupSaveDraft();
                return true;
            }
        }
        if (i2 == 67 && (text = getRealContentEdittextInstance().getText()) != null && (selectionStart = getRealContentEdittextInstance().getSelectionStart() - 1) > 0 && selectionStart < text.length() && text.charAt(selectionStart) == 0) {
            getRealContentEdittextInstance().onKeyDown(67, this.keyEventDown);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z2) {
        this.isKeyboardVisibility = z2;
        d.b.i0.v3.n.b bVar = this.mWriteTool;
        if (bVar != null && !z2) {
            bVar.h();
        }
        if (this.mTipController == null || z2) {
            return;
        }
        hideEditorTopicTip();
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, getRealTitleInstance());
        HidenSoftKeyPad(this.mInputManager, getRealContentEdittextInstance());
        super.onPause();
    }

    @Override // d.b.i0.v3.i.a
    public void onPrefixItemClick(int i2) {
        this.mCurrPrefixPos = i2;
        this.mPrefixWindow.c(i2);
        resetCheckImgState(i2);
        this.mPrefix.setText(this.mPrefixData.getPrefixs().get(i2));
        refreshPostButton();
        d.b.c.e.m.g.d(this.mPrefixWindow, getPageContext().getPageActivity());
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
        if (this.isLivePhotoType) {
            this.mPostTitle.setVisibility(8);
            refreshPostButton();
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
        bundle.putInt("private_thread", this.mPrivateThread);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.mCallFrom);
        bundle.putSerializable("tab_list", this.mFrsTabList);
        WriteImagesInfo writeImagesInfo = this.writeImagesInfo;
        if (writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", writeImagesInfo.toJsonString());
        }
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
        OriginalThreadInfo.ShareInfo shareInfo = this.mOriginalThreadInfo;
        if (shareInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(shareInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getWindow().setSoftInputMode(18);
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.mLoadingDialog.e(null);
        this.mLoadingDialog.i(R.string.sending);
        this.mLoadingDialog.h(true);
    }

    public void stopTask() {
        NewWriteModel newWriteModel = this.mWriteModel;
        if (newWriteModel != null) {
            newWriteModel.cancelLoadData();
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
