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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import d.a.p0.b1.k0;
import d.a.p0.s.s.a;
import d.a.q0.a4.h;
import d.a.q0.u0.b0;
import d.a.q0.u0.c0;
import d.a.q0.u0.d0;
import d.a.q0.u0.d1;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
/* loaded from: classes4.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements h.a, PopupWindow.OnDismissListener, ActivityCompat.OnRequestPermissionsResultCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_CONTENT = "from_content";
    public static final String FROM_SHARE_WRITE = "from_share_write";
    public static final String FROM_TITLE = "from_title";
    public static final int MAX_NEW_CONTENT_COUNT = 5000;
    public static final int MAX_NEW_REPLY_COUNT = 1000;
    public static final int NORMAL_TITLE_MAX_COUNT = 31;
    public static final int REQUEST_LOCATION = 0;
    public static final int TBDS24;
    public static final int TBDS44;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.q0.z3.b dialog;
    public String fromWhereToHotSelect;
    public boolean isDisalbeButtons;
    public boolean isFeedBackBar;
    public boolean isKeyboardVisibility;
    public boolean isLivePhotoType;
    public boolean isPrivacy;
    public final KeyEvent keyEventDown;
    public RelativeLayout mAdditionContainer;
    public TextView mAdditionCreateTime;
    public AdditionData mAdditionData;
    public TextView mAdditionLastContent;
    public TextView mAdditionLastTime;
    public final AntiHelper.k mAntiInjectListener;
    public View mBack;
    public BaijiahaoData mBaijiahaoData;
    public TbFaceManager.a mBigEmotionSpanHanlder;
    public String mCallFrom;
    public b0 mCategoryDefault;
    public int mCategoryFromID;
    public List<b0> mCategoryList;
    public String mCategoryName;
    public int mCategoryToID;
    public PostCategoryView mCategoryView;
    public SpannableStringBuilder mContentBuilder;
    public HotTopicBussinessData mCurrHotData;
    public int mCurrPrefixPos;
    public WriteData mData;
    public DialogInterface.OnCancelListener mDialogCancelListener;
    public String mDisableAudioMessage;
    public final View.OnClickListener mEditOnClicked;
    public EditorTools mEditor;
    public FeedBackModel mFeedBackModel;
    public final View.OnFocusChangeListener mFocusChangeListener;
    public ForumTabSelectedView mForumTabSelectedView;
    public String mFrom;
    public FrsTabInfoData mFrsTabList;
    public GestureDetector mGestureDetector;
    public final Handler mHandler;
    public final d.a.q0.a4.u.c mHighLightController;
    public TextView mHotTopicEdt;
    public InputMethodManager mInputManager;
    public View mInterval;
    public List<HotTopicBussinessData> mList;
    public d.a.p0.s.f0.a mLoadingDialog;
    public LocationModel mLocationModel;
    public int mLocationState;
    public TextView mName;
    public NavigationBar mNavigationBar;
    public final LocationModel.e mOnLocationCallBack;
    public final NewWriteModel.g mOnPostWriteCallback;
    public final CustomMessageListener mOnSelectLocationListener;
    public OriginalThreadCardView mOriginalThreadCardView;
    public OriginalThreadInfo.ShareInfo mOriginalThreadInfo;
    public RelativeLayout mParent;
    public TextView mPost;
    public SpanGroupEditText mPostContent;
    public LinearLayout mPostContentContainer;
    public EditText mPostTitle;
    public PostTopicData mPostTopicData;
    public TextView mPrefix;
    public PostPrefixData mPrefixData;
    public ImageView mPrefixIcon;
    public ArrayList<WritePrefixItemLayout> mPrefixItems;
    public d.a.q0.a4.h mPrefixWindow;
    public int mPrivateThread;
    public View mRootView;
    public d.a.q0.a4.u.g mTipController;
    public LinearLayout mTitleView;
    public Toast mTooManyEmotionToast;
    public LinearLayout mToolView;
    public String mTransmitOriginThreadComment;
    public String mTransmitThreadAuthorNameShow;
    public CustomMessageListener mUegValidateListener;
    public TextWatcher mWriteContentTextWatcher;
    public NewWriteModel mWriteModel;
    public TextWatcher mWriteTitleTextWatcher;
    public d.a.q0.a4.m.b mWriteTool;
    public boolean needAddHotTopicSign;
    public View post_prefix_layout;
    public View prefix_divider;
    public WriteImagesInfo writeImagesInfo;
    public ScrollView write_scrollview;

    /* loaded from: classes4.dex */
    public class a implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22917e;

        public a(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22917e = transmitPostEditActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (view == this.f22917e.mPostTitle || view == this.f22917e.mBack || view == this.f22917e.mPost) {
                    if (z) {
                        this.f22917e.isDisalbeButtons = true;
                        this.f22917e.changeToolButtonStatus();
                        if (this.f22917e.mEditor != null) {
                            this.f22917e.mEditor.q();
                        }
                        d.a.d.e.p.l.K(this.f22917e.getActivity(), this.f22917e.mPostTitle);
                    } else if (view == this.f22917e.mPostTitle) {
                        this.f22917e.mPrefix.setVisibility(0);
                    }
                }
                if (view == this.f22917e.mPostContent && z) {
                    this.f22917e.isDisalbeButtons = false;
                    this.f22917e.changeToolButtonStatus();
                    this.f22917e.mEditor.q();
                    d.a.d.e.p.l.K(this.f22917e.getActivity(), this.f22917e.mPostContent);
                }
                this.f22917e.updateHintTextColor();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22918e;

        public b(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22918e = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TransmitPostEditActivity transmitPostEditActivity = this.f22918e;
                transmitPostEditActivity.showToast(transmitPostEditActivity.mDisableAudioMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.p0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22919e;

        public c(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22919e = transmitPostEditActivity;
        }

        @Override // d.a.p0.x.b
        public void onAction(d.a.p0.x.a aVar) {
            Object obj;
            VideoInfo videoInfo;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            if (aVar.f54158a == 31) {
                Object obj2 = aVar.f54160c;
                if (obj2 instanceof Integer) {
                    int intValue = ((Integer) obj2).intValue();
                    int i2 = intValue == 5 ? 4 : intValue == 9 ? 3 : intValue == 26 ? 1 : intValue == 7 ? 2 : 0;
                    if (i2 > 0) {
                        TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", i2));
                    }
                }
            }
            int i3 = aVar.f54158a;
            if (i3 == 16) {
                if (this.f22919e.isTextFull()) {
                    this.f22919e.showToast(R.string.over_limit_tip);
                } else {
                    this.f22919e.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.f22919e.getPageContext().getPageActivity(), 12004, true)));
                }
            } else if (i3 == 24) {
                if (this.f22919e.isTextFull()) {
                    this.f22919e.showToast(R.string.over_limit_tip);
                    return;
                }
                Object obj3 = aVar.f54160c;
                if (obj3 == null || !(obj3 instanceof d.a.p0.t.c.v)) {
                    return;
                }
                this.f22919e.insertFaceIconToEditText((d.a.p0.t.c.v) obj3);
            } else if (i3 == 3) {
                this.f22919e.deleteChar();
            } else if (i3 == 12 || i3 == 13 || i3 == 46 || i3 == 49) {
                this.f22919e.refreshPostButton();
            } else if (i3 == 18) {
                if (aVar.f54160c == null || this.f22919e.mAdditionData != null) {
                    int i4 = this.f22919e.mLocationState;
                    if (i4 != 0) {
                        if (i4 != 2) {
                            return;
                        }
                        this.f22919e.goToSelectLocationActivity();
                        return;
                    }
                    Activity pageActivity = this.f22919e.getPageContext().getPageActivity();
                    if (PermissionUtil.checkLocationForGoogle(pageActivity)) {
                        this.f22919e.onLocViewClickedInInitState();
                        return;
                    } else {
                        PermissionUtil.reuqestLocation(pageActivity, 0);
                        return;
                    }
                }
                this.f22919e.requestLocationIfValid();
            } else if (i3 == 20) {
                if (this.f22919e.mLocationModel != null) {
                    this.f22919e.mLocationModel.M(true);
                }
            } else if (i3 == 27) {
                d.a.p0.s.d0.b.j().t("xiaoying_has_click", true);
                StatisticItem statisticItem = new StatisticItem("c10645");
                statisticItem.param("fid", this.f22919e.mData != null ? this.f22919e.mData.getForumId() : "");
                TiebaStatic.log(statisticItem);
                if (this.f22919e.mData == null || (videoInfo = this.f22919e.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                    this.f22919e.mEditor.A(new d.a.p0.x.a(2, 19, null));
                    if (XiaoyingUtil.isXiaoyingInstalled()) {
                        if (!XiaoyingUtil.isXiaoyingForbidden()) {
                            if (this.f22919e.mEditor.u()) {
                                this.f22919e.mEditor.q();
                                this.f22919e.mEditor.A(new d.a.p0.x.a(5, -1, null));
                            }
                            XiaoyingUtil.startXiaoying(this.f22919e.getActivity());
                            return;
                        }
                        XiaoyingUtil.showGoPluginDetailDialog(this.f22919e.getPageContext(), this.f22919e.getResources().getString(R.string.plugin_video_not_active), this.f22919e.getResources().getString(R.string.setup));
                        return;
                    }
                    XiaoyingUtil.showGoPluginDetailDialog(this.f22919e.getPageContext(), this.f22919e.getResources().getString(R.string.plugin_video_install_tips), this.f22919e.getResources().getString(R.string.plugin_go_install));
                    return;
                }
                this.f22919e.mEditor.A(new d.a.p0.x.a(2, 19, " "));
                this.f22919e.mEditor.A(new d.a.p0.x.a(28, 20, videoInfo));
            } else if (i3 == 29) {
                this.f22919e.mEditor.A(new d.a.p0.x.a(2, 19, null));
                this.f22919e.mEditor.A(new d.a.p0.x.a(1, 2, null));
                this.f22919e.mData.setVideoInfo(null);
                this.f22919e.refreshPostButton();
                if (this.f22919e.mPostContent != null) {
                    this.f22919e.mPostContent.requestFocus();
                }
                this.f22919e.mEditor.q();
                this.f22919e.mEditor.A(new d.a.p0.x.a(5, -1, null));
                TransmitPostEditActivity transmitPostEditActivity = this.f22919e;
                transmitPostEditActivity.ShowSoftKeyPad(transmitPostEditActivity.mInputManager, this.f22919e.mPostContent);
            } else if (i3 == 43) {
                d.a.p0.s.d0.b.j().t("hot_topic_has_click", true);
                this.f22919e.mEditor.A(new d.a.p0.x.a(2, 26, null));
                this.f22919e.needAddHotTopicSign = true;
                this.f22919e.performHotTopicClick(true);
                if (this.f22919e.getRealTitleInstance().isFocused()) {
                    this.f22919e.fromWhereToHotSelect = "from_title";
                } else if (this.f22919e.getRealContentEdittextInstance().isFocused()) {
                    this.f22919e.fromWhereToHotSelect = "from_content";
                }
            } else if (i3 == 45) {
                this.f22919e.mTitleView.setVisibility(0);
                this.f22919e.mTitleView.requestFocus();
            } else if (i3 == 53) {
                if (this.f22919e.mTitleView.hasFocus()) {
                    this.f22919e.mPostContent.requestFocus();
                    this.f22919e.mPostContent.setSelection(this.f22919e.mPostContent.getText().toString().length());
                }
                this.f22919e.mTitleView.setVisibility(8);
            } else if (i3 == 55 && (obj = aVar.f54160c) != null && (obj instanceof Boolean)) {
                this.f22919e.isPrivacy = ((Boolean) obj).booleanValue();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f22920e;

        /* renamed from: f  reason: collision with root package name */
        public String f22921f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22922g;

        public d(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22922g = transmitPostEditActivity;
            this.f22920e = "";
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f22922g.refreshPostButton();
                this.f22922g.updateTitleStyle();
                EditText realTitleInstance = this.f22922g.getRealTitleInstance();
                if (editable == null || realTitleInstance == null || realTitleInstance.getText() == null) {
                    return;
                }
                String str = this.f22920e;
                if (str == null || !str.equals(editable.toString())) {
                    if (this.f22922g.mHighLightController != null) {
                        this.f22920e = realTitleInstance.getText().toString();
                        this.f22922g.mHighLightController.j(realTitleInstance, true);
                        return;
                    }
                    return;
                }
                realTitleInstance.setSelection(realTitleInstance.getSelectionEnd());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                this.f22921f = charSequence != null ? charSequence.toString() : "";
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                String str = this.f22921f;
                if ((charSequence != null ? charSequence.toString().length() : 0) > (str != null ? str.toString().length() : 0)) {
                    this.f22922g.gotoHotTopicSelectActivity(charSequence, i2, i4, "from_title");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f22923e;

        /* renamed from: f  reason: collision with root package name */
        public String f22924f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22925g;

        public e(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22925g = transmitPostEditActivity;
            this.f22923e = "";
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f22925g.refreshPostButton();
                EditText realContentEdittextInstance = this.f22925g.getRealContentEdittextInstance();
                if (editable == null || realContentEdittextInstance == null || realContentEdittextInstance.getText() == null) {
                    return;
                }
                int selectionEnd = realContentEdittextInstance.getSelectionEnd();
                String str = this.f22923e;
                if (str == null || !str.equals(editable.toString())) {
                    if (this.f22925g.mHighLightController != null) {
                        this.f22923e = realContentEdittextInstance.getText().toString();
                        this.f22925g.mHighLightController.j(realContentEdittextInstance, false);
                        return;
                    }
                    return;
                }
                realContentEdittextInstance.setSelection(selectionEnd);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                this.f22924f = charSequence != null ? charSequence.toString() : "";
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                String str = this.f22924f;
                if ((charSequence != null ? charSequence.toString().length() : 0) > (str != null ? str.toString().length() : 0)) {
                    this.f22925g.gotoHotTopicSelectActivity(charSequence, i2, i4, "from_content");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22926e;

        public f(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22926e = transmitPostEditActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 2) {
                    if (this.f22926e.mPostContent != null) {
                        d.a.d.e.p.l.x(this.f22926e.getPageContext().getContext(), this.f22926e.mPostContent);
                    }
                    if (this.f22926e.mEditor != null) {
                        this.f22926e.mEditor.q();
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
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22927e;

        public g(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22927e = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.requestFocus();
                this.f22927e.mEditor.A(new d.a.p0.x.a(5, -1, null));
                this.f22927e.mPostContent.requestFocus();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22928e;

        public h(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22928e = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22928e.stopTask();
                this.f22928e.popupSaveDraft();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements TabMenuPopView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22929a;

        public i(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22929a = transmitPostEditActivity;
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view, d1 d1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, d1Var) == null) || d1Var == null) {
                return;
            }
            this.f22929a.mCategoryView.setText(d1Var.f63254a);
            this.f22929a.mData.setCategoryTo(d1Var.f63255b);
            this.f22929a.mCategoryToID = d1Var.f63255b;
            this.f22929a.mCategoryView.c();
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22930e;

        public j(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22930e = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22930e.mCategoryView.e();
                TransmitPostEditActivity transmitPostEditActivity = this.f22930e;
                transmitPostEditActivity.HidenSoftKeyPad(transmitPostEditActivity.mInputManager, this.f22930e.getRealTitleInstance());
                TransmitPostEditActivity transmitPostEditActivity2 = this.f22930e;
                transmitPostEditActivity2.HidenSoftKeyPad(transmitPostEditActivity2.mInputManager, this.f22930e.getRealContentEdittextInstance());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements TbFaceManager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22931a;

        public k(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22931a = transmitPostEditActivity;
        }

        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), d.a.d.k.d.a.class);
                d.a.d.k.d.a aVar = runTask != null ? (d.a.d.k.d.a) runTask.getData() : null;
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
                return new d.a.p0.s.f0.e(bitmapDrawable, 0);
            }
            return (ImageSpan) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class l implements TimePickerDialog.OnTimeSetListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22932a;

        public l(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22932a = transmitPostEditActivity;
        }

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, timePicker, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22933e;

        public m(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22933e = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22933e.mPrefix.setVisibility(0);
                this.f22933e.post_prefix_layout.setSelected(true);
                d.a.d.e.m.g.l(this.f22933e.mPrefixWindow, view, 0, d.a.d.e.p.l.e(this.f22933e.getPageContext().getPageActivity(), 1.0f));
                this.f22933e.mEditor.q();
                TransmitPostEditActivity transmitPostEditActivity = this.f22933e;
                transmitPostEditActivity.HidenSoftKeyPad(transmitPostEditActivity.mInputManager, this.f22933e.mPostTitle);
                TransmitPostEditActivity transmitPostEditActivity2 = this.f22933e;
                transmitPostEditActivity2.HidenSoftKeyPad(transmitPostEditActivity2.mInputManager, this.f22933e.mPostContent);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22934e;

        public n(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22934e = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22934e.mPrefix.setSelected(true);
                d.a.d.e.m.g.l(this.f22934e.mPrefixWindow, view, 0, d.a.d.e.p.l.e(this.f22934e.getPageContext().getPageActivity(), 1.0f));
                this.f22934e.mEditor.q();
                TransmitPostEditActivity transmitPostEditActivity = this.f22934e;
                transmitPostEditActivity.HidenSoftKeyPad(transmitPostEditActivity.mInputManager, this.f22934e.getRealTitleInstance());
                TransmitPostEditActivity transmitPostEditActivity2 = this.f22934e;
                transmitPostEditActivity2.HidenSoftKeyPad(transmitPostEditActivity2.mInputManager, this.f22934e.getRealContentEdittextInstance());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22935e;

        public o(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22935e = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!d.a.d.e.p.j.z()) {
                    this.f22935e.showToast(R.string.neterror);
                }
                if (k0.b() || this.f22935e.isEmotionCountOverLimit()) {
                    return;
                }
                if (this.f22935e.mHighLightController.c(this.f22935e.mPostTitle, this.f22935e.mPostContent)) {
                    TransmitPostEditActivity transmitPostEditActivity = this.f22935e;
                    transmitPostEditActivity.showToast(transmitPostEditActivity.mHighLightController.f());
                    return;
                }
                TransmitPostEditActivity transmitPostEditActivity2 = this.f22935e;
                transmitPostEditActivity2.HidenSoftKeyPad(transmitPostEditActivity2.mInputManager, this.f22935e.getRealTitleInstance());
                TransmitPostEditActivity transmitPostEditActivity3 = this.f22935e;
                transmitPostEditActivity3.HidenSoftKeyPad(transmitPostEditActivity3.mInputManager, this.f22935e.getRealContentEdittextInstance());
                this.f22935e.mEditor.q();
                TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 7));
                this.f22935e.postPhotoTextThread();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22936e;

        public p(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22936e = transmitPostEditActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    this.f22936e.mEditor.A(new d.a.p0.x.a(5, -1, null));
                    this.f22936e.mPostContent.requestFocus();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class q implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22937e;

        public q(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22937e = transmitPostEditActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f22937e.destroyWaitingDialog();
                this.f22937e.stopTask();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22938a;

        public r(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22938a = transmitPostEditActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22939a;

        /* loaded from: classes4.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // d.a.p0.s.s.a.e
            public void onClick(d.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ s f22940e;

            public b(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f22940e = sVar;
            }

            @Override // d.a.p0.s.s.a.e
            public void onClick(d.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f22940e.f22939a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f22940e.f22939a.getActivity(), 0, 26, 1)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 1));
                }
            }
        }

        public s(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22939a = transmitPostEditActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d.a.p0.t.c.k0 k0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) {
                this.f22939a.closeLoadingDialog();
                if (postWriteCallBackData == null || this.f22939a.mData == null) {
                    return;
                }
                this.f22939a.mHighLightController.n(null);
                if (z) {
                    this.f22939a.sendFinishSendAction(z);
                    this.f22939a.showTipDialog(true, postWriteCallBackData);
                    this.f22939a.sendUpdatePhotoLiveMessage(postWriteCallBackData);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    this.f22939a.setResult(-1, intent);
                    this.f22939a.finish();
                } else if (postWriteCallBackData.isSensitiveError()) {
                    this.f22939a.showToast(postWriteCallBackData.getErrorString());
                    this.f22939a.mHighLightController.o(postWriteCallBackData.getErrorString());
                    this.f22939a.mHighLightController.n(postWriteCallBackData.getSensitiveWords());
                    this.f22939a.mHighLightController.i(this.f22939a.mPostTitle, this.f22939a.mPostContent);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (d.a.d.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.f22939a.getActivity(), this.f22939a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.f22939a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f22939a.getActivity());
                    if (d.a.d.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.f22939a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(R.string.cancel, new a(this));
                    aVar.setPositiveButton(R.string.open_now, new b(this));
                    aVar.create(this.f22939a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 1));
                } else if (postWriteCallBackData == null || !d.a.q0.r3.a.c(postWriteCallBackData.getErrorCode())) {
                    if ((k0Var == null || writeData == null || k0Var.c() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        this.f22939a.showTipDialog(false, postWriteCallBackData);
                    } else if (k0Var != null && writeData != null && k0Var.c() != null) {
                        if (writeData.isCanNoForum()) {
                            writeData.setForumName("");
                            writeData.setForumId("0");
                        }
                        writeData.setVcodeMD5(k0Var.b());
                        writeData.setVcodeUrl(k0Var.c());
                        writeData.setVcodeExtra(k0Var.a());
                        if (d.a.p0.c1.a.b(k0Var.d())) {
                            this.f22939a.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.f22939a.getPageContext().getPageActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData, false, k0Var.d())));
                        } else {
                            this.f22939a.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.f22939a.getPageContext().getPageActivity(), writeData, CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE)));
                        }
                    } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    } else {
                        this.f22939a.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.f22939a.getActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t implements LocationModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22941a;

        public t(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22941a = transmitPostEditActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22941a.showToast(R.string.no_network_guide);
                this.f22941a.sendLocaionAction(0, true, null);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b(LocationData locationData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locationData) == null) {
                if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                    this.f22941a.sendLocaionAction(2, true, locationData.getFormatted_address());
                } else {
                    onFail(null);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                TransmitPostEditActivity transmitPostEditActivity = this.f22941a;
                if (StringUtils.isNull(str)) {
                    str = this.f22941a.getPageContext().getString(R.string.location_fail);
                }
                transmitPostEditActivity.showToast(str);
                this.f22941a.sendLocaionAction(0, true, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22942a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(TransmitPostEditActivity transmitPostEditActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22942a = transmitPostEditActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedSelectLocation)) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    this.f22942a.mLocationModel.M(false);
                    this.f22942a.mLocationModel.L(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    this.f22942a.sendLocaionAction(2, true, responsedSelectLocation.getName());
                    return;
                }
                this.f22942a.mLocationModel.M(true);
                this.f22942a.sendLocaionAction(0, true, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22943a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(TransmitPostEditActivity transmitPostEditActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22943a = transmitPostEditActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f22943a.showToast((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22944e;

        public w(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22944e = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22944e.mEditor.A(new d.a.p0.x.a(5, -1, null));
                int emotionCheck = this.f22944e.emotionCheck();
                if (emotionCheck < 0 || emotionCheck >= this.f22944e.mPostContent.getText().length()) {
                    return;
                }
                this.f22944e.mPostContent.setSelection(emotionCheck);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22945e;

        public x(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22945e = transmitPostEditActivity;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f22945e.sendLocaionAction(0, true, null);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22946e;

        public y(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22946e = transmitPostEditActivity;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (d.a.d.e.p.j.z()) {
                    this.f22946e.sendLocaionAction(1, true, null);
                    this.f22946e.mLocationModel.K();
                } else {
                    this.f22946e.mOnLocationCallBack.a();
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TransmitPostEditActivity f22947e;

        public z(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22947e = transmitPostEditActivity;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                d.a.d.e.p.l.x(this.f22947e.getActivity(), this.f22947e.getCurrentFocus());
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }
            return invokeCommon.booleanValue;
        }

        public /* synthetic */ z(TransmitPostEditActivity transmitPostEditActivity, k kVar) {
            this(transmitPostEditActivity);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-255645436, "Lcom/baidu/tieba/write/write/TransmitPostEditActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-255645436, "Lcom/baidu/tieba/write/write/TransmitPostEditActivity;");
                return;
            }
        }
        TBDS24 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
        TBDS44 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44);
    }

    public TransmitPostEditActivity() {
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
        this.isFeedBackBar = false;
        this.mInputManager = null;
        this.mPostTitle = null;
        this.mInterval = null;
        this.mPostContentContainer = null;
        this.mPostContent = null;
        this.mFeedBackModel = null;
        this.mPrefixItems = new ArrayList<>();
        this.keyEventDown = new KeyEvent(0, 67);
        this.mBack = null;
        this.mPost = null;
        this.mName = null;
        this.mDialogCancelListener = null;
        this.mHandler = new Handler();
        this.mParent = null;
        this.mDisableAudioMessage = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.mLocationState = 0;
        this.mRootView = null;
        this.write_scrollview = null;
        this.isLivePhotoType = false;
        this.mLoadingDialog = null;
        this.mFrom = AlbumActivityConfig.FROM_WRITE;
        this.mCallFrom = "2";
        this.mContentBuilder = new SpannableStringBuilder();
        this.isKeyboardVisibility = false;
        this.mHighLightController = new d.a.q0.a4.u.c();
        this.mBigEmotionSpanHanlder = new k(this);
        this.mAntiInjectListener = new r(this);
        this.mOnPostWriteCallback = new s(this);
        this.mOnLocationCallBack = new t(this);
        this.mOnSelectLocationListener = new u(this, 2001226);
        this.mUegValidateListener = new v(this, 2016554);
        this.mEditOnClicked = new w(this);
        this.isDisalbeButtons = true;
        this.mFocusChangeListener = new a(this);
        this.mWriteTitleTextWatcher = new d(this);
        this.mWriteContentTextWatcher = new e(this);
    }

    private void addHotTopic(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65581, this, str) == null) || StringUtils.isNull(str)) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65582, this) == null) || this.mData == null || (forumTabSelectedView = this.mForumTabSelectedView) == null || (selectedTabItemData = forumTabSelectedView.getSelectedTabItemData()) == null) {
            return;
        }
        this.mData.setTabId(selectedTabItemData.tabId);
        this.mData.setTabName(selectedTabItemData.name);
        this.mData.setIsGeneralTab(selectedTabItemData.isGeneralTab);
    }

    private void changeHotTopicData(HotTopicBussinessData hotTopicBussinessData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65583, this, hotTopicBussinessData) == null) || hotTopicBussinessData == null) {
            return;
        }
        SpannableString j2 = d.a.p0.r0.b.j(d.a.p0.r0.b.a(hotTopicBussinessData.mTopicName));
        if (j2 != null) {
            this.mPostTitle.setText(j2);
        }
        this.mHotTopicEdt.setText(hotTopicBussinessData.mForumName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeToolButtonStatus() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65584, this) == null) || (editorTools = this.mEditor) == null) {
            return;
        }
        editorTools.setBarLauncherEnabled(!this.isDisalbeButtons);
        this.mEditor.setToolEnabled(true, 26);
    }

    private boolean checkVideoEasterEgg(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || d.a.d.e.p.k.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int emotionCheck() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65586, this)) == null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public EditText getRealContentEdittextInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65587, this)) == null) ? this.mPostContent : (EditText) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText getRealTitleInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65588, this)) == null) ? this.mPostTitle : (EditText) invokeV.objValue;
    }

    private String getThreadContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65589, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    private String getThreadTitle() {
        InterceptResult invokeV;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65590, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToSelectLocationActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65591, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoHotTopicSelectActivity(CharSequence charSequence, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65592, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) || !this.isKeyboardVisibility || charSequence == null || i3 != 1 || i2 >= charSequence.length() || i2 < 0) {
            return;
        }
        this.needAddHotTopicSign = false;
        this.fromWhereToHotSelect = "";
        if ("from_content".equals(str)) {
            this.fromWhereToHotSelect = "from_content";
        } else if ("from_title".equals(str)) {
            this.fromWhereToHotSelect = "from_title";
        }
        if (d.a.p0.r0.b.f(String.valueOf(charSequence.charAt(i2)))) {
            performHotTopicClick(false);
        }
    }

    private void hideEditorTopicTip() {
        d.a.q0.a4.u.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65593, this) == null) || (gVar = this.mTipController) == null) {
            return;
        }
        gVar.b();
    }

    private void initAddition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65594, this) == null) {
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
    }

    private void initCategoryData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65595, this) == null) {
            this.mCategoryList = null;
            this.mCategoryFromID = -1;
            this.mCategoryToID = -1;
            d0 b2 = c0.a().b(1);
            if (b2 == null) {
                return;
            }
            this.mCategoryList = b2.f63253b;
            this.mCategoryFromID = getIntent().getIntExtra("category_id", -1);
            List<b0> list = this.mCategoryList;
            if (list == null || list.isEmpty() || this.mCategoryFromID < 0) {
                return;
            }
            b0 b0Var = new b0();
            this.mCategoryDefault = b0Var;
            b0Var.f63211b = 0;
            b0Var.f63210a = getPageContext().getResources().getString(R.string.category_auto);
            b0 b0Var2 = this.mCategoryDefault;
            this.mCategoryToID = b0Var2.f63211b;
            this.mCategoryName = b0Var2.f63210a;
            for (b0 b0Var3 : this.mCategoryList) {
                int i2 = b0Var3.f63211b;
                if (i2 == this.mCategoryFromID) {
                    this.mCategoryToID = i2;
                    this.mCategoryName = b0Var3.f63210a;
                    return;
                }
            }
        }
    }

    private void initCategoryUI() {
        List<b0> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65596, this) == null) || (list = this.mCategoryList) == null || list.isEmpty()) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
        linearLayout.setVisibility(0);
        findViewById(R.id.interval_view_cate).setVisibility(0);
        PostCategoryView postCategoryView = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
        this.mCategoryView = postCategoryView;
        postCategoryView.setText(this.mCategoryName);
        this.mCategoryView.setCategoryContainerData(this.mCategoryList, this.mCategoryDefault, this.mCategoryToID);
        this.mCategoryView.setCategoryContainerClickCallback(new i(this));
        linearLayout.setOnClickListener(new j(this));
    }

    private void initCommonEditorTools() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65597, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            this.mEditor.d(new d.a.p0.x.o.a(getActivity(), 2));
            if (this.mAdditionData == null) {
                if (this.mWriteTool == null) {
                    d.a.q0.a4.m.b bVar = new d.a.q0.a4.m.b(getActivity(), this.mCallFrom);
                    this.mWriteTool = bVar;
                    bVar.i();
                    this.mWriteTool.m(FROM_SHARE_WRITE);
                    this.mWriteTool.j(this.mData.getForumId(), this.mPrivateThread);
                }
                this.mEditor.d(this.mWriteTool);
            }
            this.mEditor.h(arrayList);
            d.a.p0.x.m n2 = this.mEditor.n(5);
            if (n2 != null) {
                n2.j = 1;
            }
        }
    }

    private void initData(Bundle bundle) {
        String stringExtra;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65598, this, bundle) == null) {
            NewWriteModel newWriteModel = new NewWriteModel(this);
            this.mWriteModel = newWriteModel;
            newWriteModel.h0(this.mOnPostWriteCallback);
            this.mDialogCancelListener = new q(this);
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
            if (!d.a.d.e.p.k.isEmpty(this.mTransmitOriginThreadComment)) {
                if (!d.a.d.e.p.k.isEmpty(this.mTransmitThreadAuthorNameShow)) {
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
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65599, this) == null) {
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
            d.a.p0.x.h m2 = this.mEditor.m(6);
            if (m2 != null && !TextUtils.isEmpty(this.mDisableAudioMessage)) {
                ((View) m2).setOnClickListener(new b(this));
            }
            if (!this.isLivePhotoType) {
                this.mEditor.A(new d.a.p0.x.a(34, 5, 1));
            }
            this.mEditor.q();
            if (XiaoyingUtil.showXiaoyingTool() && !d.a.p0.s.d0.b.j().g("xiaoying_has_click", false)) {
                this.mEditor.A(new d.a.p0.x.a(2, 19, "N"));
            }
            if (!d.a.p0.s.d0.b.j().g("hot_topic_has_click", false)) {
                this.mEditor.A(new d.a.p0.x.a(2, 26, " "));
            }
            if (this.mData.getType() == 0) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
                albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
                albumActivityConfig.getIntent().putExtra("from", this.mFrom);
                albumActivityConfig.setCanEditImage(false);
                albumActivityConfig.setRequestCode(12002);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
            showEditorTopicTip();
        }
    }

    private void initEditorListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65600, this) == null) {
            c cVar = new c(this);
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
    }

    private void initForumTabSelected() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65601, this) == null) {
            ForumTabSelectedView forumTabSelectedView = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
            this.mForumTabSelectedView = forumTabSelectedView;
            forumTabSelectedView.setBgColor(R.color.CAM_X0205);
            this.mForumTabSelectedView.setData(this.mFrsTabList);
            this.mForumTabSelectedView.setActivity(this);
        }
    }

    private void initOriginalThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65602, this) == null) {
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
    }

    private void initPostTopic() {
        WriteData writeData;
        PostTopicData postTopicData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65603, this) == null) || (writeData = this.mData) == null || writeData.getType() != 0 || this.mData.getType() != 9 || this.isFeedBackBar || (postTopicData = this.mPostTopicData) == null || StringUtils.isNull(postTopicData.getTitleTopic())) {
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
        if (interceptable == null || interceptable.invokeV(65604, this) == null) {
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
                this.post_prefix_layout.setOnClickListener(new m(this));
                ImageView imageView = (ImageView) findViewById(R.id.prefix_icon);
                this.mPrefixIcon = imageView;
                if (size > 1) {
                    imageView.setVisibility(0);
                    this.mPrefix.setOnClickListener(new n(this));
                }
                d.a.q0.a4.h hVar = new d.a.q0.a4.h(getPageContext().getPageActivity());
                this.mPrefixWindow = hVar;
                hVar.e(this);
                this.mPrefixWindow.d(d.a.d.e.p.l.g(getActivity(), R.dimen.ds510));
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
    }

    private void initTopicDataInView() {
        HotTopicBussinessData hotTopicBussinessData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65605, this) == null) || (hotTopicBussinessData = (HotTopicBussinessData) ListUtils.getItem(this.mList, 0)) == null || TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            return;
        }
        this.mPostTitle.setText(d.a.p0.r0.b.j(d.a.p0.r0.b.a(hotTopicBussinessData.mTopicName)));
        this.mPostTitle.setMovementMethod(d.a.q0.z3.c.a());
    }

    private void initUI() {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65606, this) == null) {
            this.mLoadingDialog = new d.a.p0.s.f0.a(getPageContext());
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
            scrollView.setOnTouchListener(new f(this));
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
            this.mPostContentContainer.setOnClickListener(new g(this));
            this.mBack.setOnFocusChangeListener(this.mFocusChangeListener);
            this.mBack.setOnClickListener(new h(this));
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isEmotionCountOverLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65607, this)) == null) {
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
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTextFull() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65608, this)) == null) {
            return getRealContentEdittextInstance().getText() != null && getRealContentEdittextInstance().getText().length() >= (this.mAdditionData != null ? 1000 : 5000);
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performHotTopicClick(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65609, this, z2) == null) || d.a.p0.r0.b.c(getPageContext(), z2, false)) {
            return;
        }
        HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
        WriteData writeData = this.mData;
        if (writeData != null) {
            hotSelectActivityConfig.setForumExtra(d.a.d.e.m.b.f(writeData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
        }
        sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void popupSaveDraft() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65610, this) == null) {
            WriteData writeData = this.mData;
            if (writeData == null) {
                finish();
                return;
            }
            writeData.setTitle(getRealTitleInstance().getText().toString());
            this.mData.setContent(getRealContentEdittextInstance().getText().toString());
            finish();
        }
    }

    private void postNewMessage() {
        HotTopicBussinessData hotTopicBussinessData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65611, this) == null) {
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
            writeData.setHasLocationData(locationModel != null && locationModel.z());
            this.mWriteModel.d0(this.writeImagesInfo.size() > 0);
            if (!ListUtils.isEmpty(this.mList) && (hotTopicBussinessData = this.mCurrHotData) != null && hotTopicBussinessData.mIsGlobalBlock == 0) {
                this.mData.setForumId(String.valueOf(hotTopicBussinessData.mForumId));
                this.mData.setForumName(this.mCurrHotData.mForumName);
            }
            addTabInfoForPostWriteIfNeed();
            this.mWriteModel.setWriteData(this.mData);
            WriteData writeData2 = this.mData;
            writeData2.setContent(writeData2.getContent().replaceAll("\u0000\n", ""));
            WriteData writeData3 = this.mData;
            writeData3.setContent(writeData3.getContent().replaceAll("\u0000", ""));
            this.mData.setVcode(null);
            this.mWriteModel.X().setVoice(null);
            this.mWriteModel.X().setVoiceDuringTime(-1);
            if (!d.a.d.e.p.j.z()) {
                showToast(R.string.neterror);
                return;
            }
            showLoadingDialog(getPageContext().getString(R.string.sending), this.mDialogCancelListener);
            this.mWriteModel.l0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postPhotoTextThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65612, this) == null) {
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
    }

    private void realInsert(SpannableStringBuilder spannableStringBuilder, int i2, d.a.d.k.d.a aVar, EmotionGroupType emotionGroupType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65613, this, spannableStringBuilder, i2, aVar, emotionGroupType) == null) || spannableStringBuilder == null || getRealContentEdittextInstance() == null || getRealContentEdittextInstance().getText() == null) {
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
        spannableStringBuilder.setSpan(new d.a.p0.s.f0.e(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65614, this) == null) || this.mData == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65615, this) == null) {
            if (this.mLocationModel.z()) {
                if (this.mLocationModel.D()) {
                    sendLocaionAction(2, true, d.a.q0.h3.m0.b.a().b().getFormatted_address());
                    return;
                }
                sendLocaionAction(1, true, null);
                this.mLocationModel.H();
                return;
            }
            sendLocaionAction(0, true, null);
        }
    }

    private void requestPrivacyStateAction() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65616, this) == null) || (editorTools = this.mEditor) == null) {
            return;
        }
        editorTools.A(new d.a.p0.x.a(54, 15, null));
    }

    private void resetCheckImgState(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65617, this, i2) == null) || i2 >= this.mPrefixItems.size()) {
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
        if (!(interceptable == null || interceptable.invokeZ(65618, this, z2) == null) || (editorTools = this.mEditor) == null) {
            return;
        }
        editorTools.A(new d.a.p0.x.a(9, -1, Boolean.valueOf(z2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLocaionAction(int i2, boolean z2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65619, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str}) == null) {
            this.mLocationState = i2;
            EditorTools editorTools = this.mEditor;
            if (editorTools != null) {
                editorTools.A(new d.a.p0.x.a(19, 15, new d.a.p0.x.u.a(i2, z2, str)));
            }
        }
    }

    private void sendSetImgAction() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65620, this) == null) || this.isLivePhotoType || (editorTools = this.mEditor) == null) {
            return;
        }
        editorTools.A(new d.a.p0.x.a(12, -1, new d.a.p0.x.r.a(this.writeImagesInfo, true)));
        this.mEditor.A(new d.a.p0.x.a(12, 11, new d.a.p0.x.r.a(this.writeImagesInfo, true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUpdatePhotoLiveMessage(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65621, this, postWriteCallBackData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
        }
    }

    private void setPostButtonEnabled(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65622, this, z2) == null) {
            SkinManager.setNavbarTitleColor(this.mPost, R.color.CAM_X0302, R.color.s_navbar_title_color);
        }
    }

    private void setPostView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65623, this) == null) {
            TextView addTextButton = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.share));
            this.mPost = addTextButton;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) addTextButton.getLayoutParams();
            layoutParams.rightMargin = d.a.d.e.p.l.g(getPageContext().getPageActivity(), R.dimen.ds14);
            this.mPost.setLayoutParams(layoutParams);
            this.mPost.setOnFocusChangeListener(this.mFocusChangeListener);
        }
    }

    private void showAdditionTip(boolean z2, String str) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65624, this, z2, str) == null) {
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
            d.a.d.e.p.l.M(getPageContext().getPageActivity(), sb.toString());
        }
    }

    private void showEditorTopicTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65625, this) == null) {
            if (this.mTipController == null) {
                this.mTipController = new d.a.q0.a4.u.g(getPageContext());
            }
            this.mTipController.c(this.mEditor);
        }
    }

    private void showLocPermissionDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65626, this) == null) {
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(getPageContext().getPageActivity());
            aVar.setMessageId(R.string.location_app_permission_prompt).setPositiveButton(R.string.isopen, new y(this)).setNegativeButton(R.string.cancel, new x(this)).create(getPageContext());
            aVar.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTipDialog(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(65627, this, z2, postWriteCallBackData) == null) || postWriteCallBackData == null) {
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
                d.a.q0.h3.q0.m.b(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                return;
            }
            showAdditionTip(z2, errorString);
        }
    }

    private void updataTitle() {
        WriteData writeData;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65628, this) == null) || (writeData = this.mData) == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65629, this) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTitleStyle() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65630, this) == null) || (editText = this.mPostTitle) == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mLoadingDialog.h(false);
        }
    }

    public void deleteChar() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || getRealContentEdittextInstance().getSelectionStart() <= 0) {
            return;
        }
        String substring = getRealContentEdittextInstance().getText().toString().substring(0, getRealContentEdittextInstance().getSelectionStart());
        Matcher matcher = d.a.q0.o0.a.f61680b.matcher(substring);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (this.mGestureDetector.onTouchEvent(motionEvent)) {
                motionEvent.setAction(3);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.p0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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

    public void initTitleView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!ListUtils.isEmpty(this.mList)) {
                this.mTitleView.setVisibility(0);
                this.mTitleView.requestFocus();
                return;
            }
            this.mTitleView.setVisibility(8);
        }
    }

    public void initializePostContent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
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
            if (!d.a.d.e.p.k.isEmpty(this.mTransmitOriginThreadComment)) {
                this.mPostContent.setSelection(0);
            }
            this.mPostContent.setOnFocusChangeListener(this.mFocusChangeListener);
            this.mPostContent.setOnTouchListener(new p(this));
            this.mPostContent.addTextChangedListener(this.mWriteContentTextWatcher);
            OriginalThreadInfo.ShareInfo shareInfo = this.mOriginalThreadInfo;
            if (shareInfo != null && shareInfo.showType == 3) {
                this.mPostContent.setHint(R.string.share_video_default);
            } else {
                this.mPostContent.setHint(R.string.share_txt_default);
            }
        }
    }

    public void initializePostTitle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
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
    }

    public void insertFaceIconToEditText(d.a.p0.t.c.v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, vVar) == null) {
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
            d.a.q0.o0.b.b(this, vVar, getRealContentEdittextInstance());
        }
    }

    public void intializePostButton() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mPost.setOnClickListener(new o(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    public void onActivityResult(int i2, int i3, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048585, this, i2, i3, intent) == null) {
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
                    sb.append(TNCManager.TNC_PROBE_HEADER_SECEPTOR);
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
                    sb2.append(d.a.p0.r0.b.f52908a);
                    this.needAddHotTopicSign = false;
                }
                sb2.append(stringExtra);
                addHotTopic(sb2.toString());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
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
            d.a.q0.a4.u.c cVar = this.mHighLightController;
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
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new z(this, null));
            this.mInputManager = (InputMethodManager) getSystemService("input_method");
            initData(bundle);
            initUI();
            LocationModel locationModel = new LocationModel(getPageContext());
            this.mLocationModel = locationModel;
            locationModel.N(this.mOnLocationCallBack);
            registerListener(this.mOnSelectLocationListener);
            registerListener(this.mUegValidateListener);
            initEditor();
            this.mPostContent.requestFocus();
            initTitleView();
            sendSetImgAction();
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            d.a.q0.z3.b bVar = new d.a.q0.z3.b(getPageContext().getPageActivity(), new l(this), new Date().getHours(), new Date().getMinutes(), false);
            this.dialog = bVar;
            bVar.setTitle(R.string.no_disturb_start_time);
            this.dialog.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.dialog);
            this.dialog.setButton(-2, getPageContext().getString(R.string.cancel), this.dialog);
            return this.dialog;
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            hideEditorTopicTip();
            TiebaPrepareImageService.StopService();
            stopTask();
            super.onDestroy();
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.post_prefix_layout.setSelected(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Editable text;
        int selectionStart;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048591, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                d.a.q0.a4.h hVar = this.mPrefixWindow;
                if (hVar != null && hVar.isShowing()) {
                    d.a.d.e.m.g.d(this.mPrefixWindow, getPageContext().getPageActivity());
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
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z2) == null) {
            this.isKeyboardVisibility = z2;
            d.a.q0.a4.m.b bVar = this.mWriteTool;
            if (bVar != null && !z2) {
                bVar.h();
            }
            if (this.mTipController == null || z2) {
                return;
            }
            hideEditorTopicTip();
        }
    }

    public void onLocViewClickedInInitState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
                showToast(R.string.location_system_permission_prompt);
                sendLocaionAction(0, true, null);
            } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
                showLocPermissionDialog();
            } else if (this.mLocationModel.D()) {
                goToSelectLocationActivity();
            } else {
                this.mLocationModel.M(false);
                sendLocaionAction(1, true, null);
                this.mLocationModel.H();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            HidenSoftKeyPad(this.mInputManager, getRealTitleInstance());
            HidenSoftKeyPad(this.mInputManager, getRealContentEdittextInstance());
            super.onPause();
        }
    }

    @Override // d.a.q0.a4.h.a
    public void onPrefixItemClick(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.mCurrPrefixPos = i2;
            this.mPrefixWindow.c(i2);
            resetCheckImgState(i2);
            this.mPrefix.setText(this.mPrefixData.getPrefixs().get(i2));
            refreshPostButton();
            d.a.d.e.m.g.d(this.mPrefixWindow, getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048596, this, i2, dialog) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048597, this, i2, strArr, iArr) == null) && i2 == 0) {
            onLocViewClickedInInitState();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onResume();
            if (this.isLivePhotoType) {
                this.mPostTitle.setVisibility(8);
                refreshPostButton();
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
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
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onStop();
            getWindow().setSoftInputMode(18);
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048602, this, i2, i3) == null) {
            super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, str, onCancelListener) == null) {
            this.mLoadingDialog.e(null);
            this.mLoadingDialog.i(R.string.sending);
            this.mLoadingDialog.h(true);
        }
    }

    public void stopTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
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
}
