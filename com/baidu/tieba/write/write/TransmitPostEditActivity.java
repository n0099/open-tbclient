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
import com.baidu.bdtask.model.response.TaskResponseData;
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
import com.baidu.tbadk.core.util.CommonStatisticKey;
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
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.WriteImagesInfo;
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
import com.repackage.a09;
import com.repackage.a19;
import com.repackage.bm8;
import com.repackage.bu4;
import com.repackage.c15;
import com.repackage.ce6;
import com.repackage.cr4;
import com.repackage.de6;
import com.repackage.e19;
import com.repackage.ee6;
import com.repackage.ef6;
import com.repackage.en8;
import com.repackage.fo;
import com.repackage.gd5;
import com.repackage.hc5;
import com.repackage.i05;
import com.repackage.j05;
import com.repackage.jz8;
import com.repackage.mg;
import com.repackage.mi;
import com.repackage.ni;
import com.repackage.oi;
import com.repackage.p05;
import com.repackage.qd5;
import com.repackage.qw8;
import com.repackage.qx4;
import com.repackage.rg;
import com.repackage.rw8;
import com.repackage.t86;
import com.repackage.u05;
import com.repackage.u86;
import com.repackage.vt4;
import com.repackage.w05;
import com.repackage.xt4;
import com.repackage.y15;
import com.repackage.zw4;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
/* loaded from: classes4.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements jz8.a, PopupWindow.OnDismissListener, ActivityCompat.OnRequestPermissionsResultCallback {
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
    public qw8 dialog;
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
    public ce6 mCategoryDefault;
    public int mCategoryFromID;
    public List<ce6> mCategoryList;
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
    public final a19 mHighLightController;
    public TextView mHotTopicEdt;
    public InputMethodManager mInputManager;
    public View mInterval;
    public boolean mIsFromShare;
    public List<HotTopicBussinessData> mList;
    public xt4 mLoadingDialog;
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
    public jz8 mPrefixWindow;
    public int mPrivateThread;
    public View mRootView;
    public e19 mTipController;
    public LinearLayout mTitleView;
    public Toast mTooManyEmotionToast;
    public LinearLayout mToolView;
    public String mTopicId;
    public String mTransmitOriginThreadComment;
    public String mTransmitThreadAuthorNameShow;
    public CustomMessageListener mUegValidateListener;
    public TextWatcher mWriteContentTextWatcher;
    public NewWriteModel mWriteModel;
    public TextWatcher mWriteTitleTextWatcher;
    public a09 mWriteTool;
    public boolean needAddHotTopicSign;
    public View post_prefix_layout;
    public View prefix_divider;
    public WriteImagesInfo writeImagesInfo;
    public ScrollView write_scrollview;

    /* loaded from: classes4.dex */
    public class a implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public a(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (view2 == this.a.mPostTitle || view2 == this.a.mBack || view2 == this.a.mPost) {
                    if (z) {
                        this.a.isDisalbeButtons = true;
                        this.a.changeToolButtonStatus();
                        if (this.a.mEditor != null) {
                            this.a.mEditor.q();
                        }
                        oi.L(this.a.getActivity(), this.a.mPostTitle);
                    } else if (view2 == this.a.mPostTitle) {
                        this.a.mPrefix.setVisibility(0);
                    }
                }
                if (view2 == this.a.mPostContent && z) {
                    this.a.isDisalbeButtons = false;
                    this.a.changeToolButtonStatus();
                    this.a.mEditor.q();
                    oi.L(this.a.getActivity(), this.a.mPostContent);
                }
                this.a.updateHintTextColor();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public b(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TransmitPostEditActivity transmitPostEditActivity = this.a;
                transmitPostEditActivity.showToast(transmitPostEditActivity.mDisableAudioMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements j05 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        /* loaded from: classes4.dex */
        public class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
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

        public c(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // com.repackage.j05
        public void onAction(i05 i05Var) {
            Object obj;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, i05Var) == null) || i05Var == null) {
                return;
            }
            if (i05Var.a == 31) {
                Object obj2 = i05Var.c;
                if (obj2 instanceof Integer) {
                    int intValue = ((Integer) obj2).intValue();
                    int i = intValue == 5 ? 4 : intValue == 9 ? 3 : intValue == 26 ? 1 : intValue == 7 ? 2 : 0;
                    if (i > 0) {
                        TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", i));
                    }
                }
            }
            int i2 = i05Var.a;
            if (i2 == 16) {
                if (this.a.isTextFull()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0cf0);
                    return;
                }
                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getPageContext().getPageActivity(), 12004, true);
                if (this.a.getRealContentEdittextInstance() instanceof SpanGroupEditText) {
                    atListActivityConfig.setSelectedAtList(((SpanGroupEditText) this.a.getRealContentEdittextInstance()).getAtDataInText());
                }
                this.a.sendMessage(new CustomMessage(2002001, atListActivityConfig));
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            } else if (i2 == 24) {
                if (this.a.isTextFull()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0cf0);
                    return;
                }
                Object obj3 = i05Var.c;
                if (obj3 == null || !(obj3 instanceof zw4)) {
                    return;
                }
                this.a.insertFaceIconToEditText((zw4) obj3);
            } else if (i2 == 3) {
                this.a.deleteChar();
            } else if (i2 == 12 || i2 == 13 || i2 == 46 || i2 == 49) {
                this.a.refreshPostButton();
            } else if (i2 == 18) {
                boolean h = vt4.k().h("key_post_thread_has_request_location", false);
                if (i05Var.c != null && this.a.mAdditionData == null) {
                    if (h) {
                        this.a.requestLocationIfValid();
                        return;
                    }
                    return;
                }
                int i3 = this.a.mLocationState;
                if (i3 != 0) {
                    if (i3 != 2) {
                        return;
                    }
                    this.a.goToSelectLocationActivity();
                    return;
                }
                Activity pageActivity = this.a.getPageContext().getPageActivity();
                if (PermissionUtil.checkLocationForGoogle(pageActivity) && h) {
                    this.a.onLocViewClickedInInitState();
                } else {
                    PermissionUtil.requestLocation(pageActivity, 0, new a(this));
                }
            } else if (i2 == 20) {
                if (this.a.mLocationModel != null) {
                    this.a.mLocationModel.P(true);
                }
            } else if (i2 == 29) {
                this.a.mEditor.A(new i05(2, 19, null));
                this.a.mEditor.A(new i05(1, 2, null));
                this.a.mData.setVideoInfo(null);
                this.a.refreshPostButton();
                if (this.a.mPostContent != null) {
                    this.a.mPostContent.requestFocus();
                }
                this.a.mEditor.q();
                this.a.mEditor.A(new i05(5, -1, null));
                TransmitPostEditActivity transmitPostEditActivity = this.a;
                transmitPostEditActivity.ShowSoftKeyPad(transmitPostEditActivity.mInputManager, this.a.mPostContent);
            } else if (i2 == 43) {
                vt4.k().u("hot_topic_has_click", true);
                this.a.mEditor.A(new i05(2, 26, null));
                this.a.needAddHotTopicSign = true;
                this.a.performHotTopicClick(true);
                if (this.a.getRealTitleInstance().isFocused()) {
                    this.a.fromWhereToHotSelect = "from_title";
                } else if (this.a.getRealContentEdittextInstance().isFocused()) {
                    this.a.fromWhereToHotSelect = "from_content";
                }
            } else if (i2 == 45) {
                this.a.mTitleView.setVisibility(0);
                this.a.mTitleView.requestFocus();
            } else if (i2 == 53) {
                if (this.a.mTitleView.hasFocus()) {
                    this.a.mPostContent.requestFocus();
                    this.a.mPostContent.setSelection(this.a.mPostContent.getText().toString().length());
                }
                this.a.mTitleView.setVisibility(8);
            } else if (i2 == 55 && (obj = i05Var.c) != null && (obj instanceof Boolean)) {
                this.a.isPrivacy = ((Boolean) obj).booleanValue();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ TransmitPostEditActivity c;

        public d(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = transmitPostEditActivity;
            this.a = "";
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.c.refreshPostButton();
                this.c.updateTitleStyle();
                EditText realTitleInstance = this.c.getRealTitleInstance();
                if (editable == null || realTitleInstance == null || realTitleInstance.getText() == null) {
                    return;
                }
                String str = this.a;
                if (str == null || !str.equals(editable.toString())) {
                    if (this.c.mHighLightController != null) {
                        this.a = realTitleInstance.getText().toString();
                        this.c.mHighLightController.j(realTitleInstance, true);
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
                this.b = charSequence != null ? charSequence.toString() : "";
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                String str = this.b;
                if ((charSequence != null ? charSequence.toString().length() : 0) > (str != null ? str.toString().length() : 0)) {
                    this.c.gotoHotTopicSelectActivity(charSequence, i, i3, "from_title");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ TransmitPostEditActivity c;

        public e(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = transmitPostEditActivity;
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
                int selectionEnd = realContentEdittextInstance.getSelectionEnd();
                String str = this.a;
                if (str == null || !str.equals(editable.toString())) {
                    if (this.c.mHighLightController != null) {
                        this.a = realContentEdittextInstance.getText().toString();
                        this.c.mHighLightController.j(realContentEdittextInstance, false);
                        return;
                    }
                    return;
                }
                realContentEdittextInstance.setSelection(selectionEnd);
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
                if ((charSequence != null ? charSequence.toString().length() : 0) > (str != null ? str.toString().length() : 0)) {
                    this.c.gotoHotTopicSelectActivity(charSequence, i, i3, "from_content");
                    this.c.gotoAtSelectActivity(charSequence, i, i3);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public f(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
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
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public g(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
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
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public h(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.stopTask();
                this.a.popupSaveDraft();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements TabMenuPopView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public i(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
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
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public j(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.mCategoryView.e();
                TransmitPostEditActivity transmitPostEditActivity = this.a;
                transmitPostEditActivity.HidenSoftKeyPad(transmitPostEditActivity.mInputManager, this.a.getRealTitleInstance());
                TransmitPostEditActivity transmitPostEditActivity2 = this.a;
                transmitPostEditActivity2.HidenSoftKeyPad(transmitPostEditActivity2.mInputManager, this.a.getRealContentEdittextInstance());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements TbFaceManager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public k(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
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
    public class l implements TimePickerDialog.OnTimeSetListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public l(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, timePicker, i, i2) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public m(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.mPrefix.setVisibility(0);
                this.a.post_prefix_layout.setSelected(true);
                rg.l(this.a.mPrefixWindow, view2, 0, oi.d(this.a.getPageContext().getPageActivity(), 1.0f));
                this.a.mEditor.q();
                TransmitPostEditActivity transmitPostEditActivity = this.a;
                transmitPostEditActivity.HidenSoftKeyPad(transmitPostEditActivity.mInputManager, this.a.mPostTitle);
                TransmitPostEditActivity transmitPostEditActivity2 = this.a;
                transmitPostEditActivity2.HidenSoftKeyPad(transmitPostEditActivity2.mInputManager, this.a.mPostContent);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public n(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.mPrefix.setSelected(true);
                rg.l(this.a.mPrefixWindow, view2, 0, oi.d(this.a.getPageContext().getPageActivity(), 1.0f));
                this.a.mEditor.q();
                TransmitPostEditActivity transmitPostEditActivity = this.a;
                transmitPostEditActivity.HidenSoftKeyPad(transmitPostEditActivity.mInputManager, this.a.getRealTitleInstance());
                TransmitPostEditActivity transmitPostEditActivity2 = this.a;
                transmitPostEditActivity2.HidenSoftKeyPad(transmitPostEditActivity2.mInputManager, this.a.getRealContentEdittextInstance());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public o(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!mi.z()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c17);
                }
                if (gd5.b() || this.a.isEmotionCountOverLimit()) {
                    return;
                }
                if (this.a.mHighLightController.b(this.a.mPostTitle, this.a.mPostContent)) {
                    TransmitPostEditActivity transmitPostEditActivity = this.a;
                    transmitPostEditActivity.showToast(transmitPostEditActivity.mHighLightController.e());
                    return;
                }
                TransmitPostEditActivity transmitPostEditActivity2 = this.a;
                transmitPostEditActivity2.HidenSoftKeyPad(transmitPostEditActivity2.mInputManager, this.a.getRealTitleInstance());
                TransmitPostEditActivity transmitPostEditActivity3 = this.a;
                transmitPostEditActivity3.HidenSoftKeyPad(transmitPostEditActivity3.mInputManager, this.a.getRealContentEdittextInstance());
                this.a.mEditor.q();
                TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 7));
                if (this.a.mIsFromShare) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 8));
                }
                this.a.postPhotoTextThread();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public p(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
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

    /* loaded from: classes4.dex */
    public class q implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public q(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.destroyWaitingDialog();
                this.a.stopTask();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public r(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
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
    public class s implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        /* loaded from: classes4.dex */
        public class a implements cr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
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
            public final /* synthetic */ s a;

            public b(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = sVar;
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

        public s(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, qx4 qx4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, qx4Var, writeData, antiData}) == null) {
                this.a.closeLoadingDialog();
                if (postWriteCallBackData == null || this.a.mData == null) {
                    return;
                }
                this.a.mHighLightController.n(null);
                if (z) {
                    this.a.sendFinishSendAction(z);
                    this.a.showTipDialog(true, postWriteCallBackData);
                    this.a.sendTopicNotify();
                    this.a.sendUpdatePhotoLiveMessage(postWriteCallBackData);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    this.a.setResult(-1, intent);
                    this.a.finish();
                } else if (postWriteCallBackData.isSensitiveError()) {
                    this.a.showToast(postWriteCallBackData.getErrorString());
                    this.a.mHighLightController.o(postWriteCallBackData.getErrorString());
                    this.a.mHighLightController.n(postWriteCallBackData.getSensitiveWords());
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
                } else if ((qx4Var == null || writeData == null || qx4Var.c() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
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
                        this.a.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.getPageContext().getPageActivity(), 12006, writeData, false, qx4Var.d())));
                    } else {
                        this.a.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.getPageContext().getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                } else {
                    this.a.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t implements LocationModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public t(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
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
                TransmitPostEditActivity transmitPostEditActivity = this.a;
                if (StringUtils.isNull(str)) {
                    str = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a42);
                }
                transmitPostEditActivity.showToast(str);
                this.a.sendLocaionAction(0, true, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(TransmitPostEditActivity transmitPostEditActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity, Integer.valueOf(i)};
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
            this.a = transmitPostEditActivity;
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
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(TransmitPostEditActivity transmitPostEditActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity, Integer.valueOf(i)};
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
            this.a = transmitPostEditActivity;
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
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public w(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
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
    public class x implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public x(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
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
    public class y implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public y(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
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
    public class z extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public z(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
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
        TBDS24 = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
        TBDS44 = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44);
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
        this.mHighLightController = new a19();
        this.mIsFromShare = false;
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
        if (!(interceptable == null || interceptable.invokeL(65584, this, str) == null) || StringUtils.isNull(str)) {
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
        ForumTabSelectedView forumTabSelectedView;
        FrsTabItemData selectedTabItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65585, this) == null) || this.mData == null || (forumTabSelectedView = this.mForumTabSelectedView) == null || (selectedTabItemData = forumTabSelectedView.getSelectedTabItemData()) == null) {
            return;
        }
        this.mData.setTabId(selectedTabItemData.tabId);
        this.mData.setTabName(selectedTabItemData.name);
        this.mData.setIsGeneralTab(selectedTabItemData.isGeneralTab);
    }

    private void changeHotTopicData(HotTopicBussinessData hotTopicBussinessData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65586, this, hotTopicBussinessData) == null) || hotTopicBussinessData == null) {
            return;
        }
        SpannableString i2 = hc5.i(hc5.a(hotTopicBussinessData.mTopicName));
        if (i2 != null) {
            this.mPostTitle.setText(i2);
        }
        this.mHotTopicEdt.setText(hotTopicBussinessData.mForumName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeToolButtonStatus() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65587, this) == null) || (editorTools = this.mEditor) == null) {
            return;
        }
        editorTools.setBarLauncherEnabled(!this.isDisalbeButtons);
        this.mEditor.setToolEnabled(true, 26);
    }

    private boolean checkVideoEasterEgg(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ni.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65589, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65590, this)) == null) ? this.mPostContent : (EditText) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText getRealTitleInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65591, this)) == null) ? this.mPostTitle : (EditText) invokeV.objValue;
    }

    private String getThreadContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65592, this)) == null) {
            if (getRealContentEdittextInstance() == null || getRealContentEdittextInstance().getText() == null) {
                return "";
            }
            String obj = getRealContentEdittextInstance().getText().toString();
            if (StringUtils.isNull(obj)) {
                OriginalThreadInfo.ShareInfo shareInfo = this.mOriginalThreadInfo;
                if (shareInfo != null && shareInfo.showType == 3) {
                    return getString(R.string.obfuscated_res_0x7f0f114b);
                }
                return getString(R.string.obfuscated_res_0x7f0f114a);
            }
            return obj;
        }
        return (String) invokeV.objValue;
    }

    private String getThreadTitle() {
        InterceptResult invokeV;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65593, this)) == null) {
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
                    return getString(R.string.obfuscated_res_0x7f0f114a);
                }
                if (getString(R.string.obfuscated_res_0x7f0f114a).equals(this.mData.getContent())) {
                    return getString(R.string.obfuscated_res_0x7f0f114a);
                }
                return getString(R.string.obfuscated_res_0x7f0f114b).equals(this.mData.getContent()) ? getString(R.string.obfuscated_res_0x7f0f114b) : obj;
            }
            return obj;
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToSelectLocationActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65594, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoAtSelectActivity(CharSequence charSequence, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65595, this, charSequence, i2, i3) == null) && this.isKeyboardVisibility && charSequence != null && i3 == 1 && i2 < charSequence.length() && i2 >= 0 && charSequence.charAt(i2) == '@') {
            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getPageContext().getPageActivity(), 12004, true);
            if (getRealContentEdittextInstance() instanceof SpanGroupEditText) {
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
        if (!(interceptable == null || interceptable.invokeCommon(65596, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) || !this.isKeyboardVisibility || charSequence == null || i3 != 1 || i2 >= charSequence.length() || i2 < 0) {
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

    private void hideEditorTopicTip() {
        e19 e19Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65597, this) == null) || (e19Var = this.mTipController) == null) {
            return;
        }
        e19Var.b();
    }

    private void initAddition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65598, this) == null) {
            this.mAdditionContainer = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09012d);
            this.mAdditionCreateTime = (TextView) findViewById(R.id.obfuscated_res_0x7f09012e);
            this.mAdditionLastTime = (TextView) findViewById(R.id.obfuscated_res_0x7f090132);
            this.mAdditionLastContent = (TextView) findViewById(R.id.obfuscated_res_0x7f090131);
            if (this.mAdditionData != null) {
                this.mAdditionContainer.setVisibility(0);
                TextView textView = this.mAdditionCreateTime;
                textView.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f157f) + StringHelper.getFormatTime(this.mAdditionData.getCreateTime() * 1000));
                if (this.mAdditionData.getAlreadyCount() == 0) {
                    this.mAdditionLastTime.setVisibility(8);
                } else {
                    TextView textView2 = this.mAdditionLastTime;
                    textView2.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f1581) + StringHelper.getFormatTime(this.mAdditionData.getLastAdditionTime() * 1000));
                }
                String lastAdditionContent = this.mAdditionData.getLastAdditionContent();
                if (!TextUtils.isEmpty(lastAdditionContent)) {
                    this.mAdditionLastContent.setText(lastAdditionContent);
                } else {
                    this.mAdditionLastContent.setVisibility(8);
                }
                getRealContentEdittextInstance().setHint(String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f1580), Integer.valueOf(this.mAdditionData.getAlreadyCount()), Integer.valueOf(this.mAdditionData.getTotalCount())));
                this.mName.setText(R.string.obfuscated_res_0x7f0f1583);
                return;
            }
            this.mAdditionContainer.setVisibility(8);
        }
    }

    private void initCategoryData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65599, this) == null) {
            this.mCategoryList = null;
            this.mCategoryFromID = -1;
            this.mCategoryToID = -1;
            ee6 b2 = de6.a().b(1);
            if (b2 == null) {
                return;
            }
            this.mCategoryList = b2.b;
            this.mCategoryFromID = getIntent().getIntExtra("category_id", -1);
            List<ce6> list = this.mCategoryList;
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
    }

    private void initCategoryUI() {
        List<ce6> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65600, this) == null) || (list = this.mCategoryList) == null || list.isEmpty()) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09184d);
        linearLayout.setVisibility(0);
        findViewById(R.id.obfuscated_res_0x7f090f37).setVisibility(0);
        PostCategoryView postCategoryView = (PostCategoryView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0905ad);
        this.mCategoryView = postCategoryView;
        postCategoryView.setText(this.mCategoryName);
        this.mCategoryView.setCategoryContainerData(this.mCategoryList, this.mCategoryDefault, this.mCategoryToID);
        this.mCategoryView.setCategoryContainerClickCallback(new i(this));
        linearLayout.setOnClickListener(new j(this));
    }

    private void initCommonEditorTools() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65601, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            this.mEditor.d(new w05(getActivity(), 2));
            if (this.mAdditionData == null) {
                if (this.mWriteTool == null) {
                    a09 a09Var = new a09(getActivity(), this.mCallFrom);
                    this.mWriteTool = a09Var;
                    a09Var.h();
                    this.mWriteTool.l(FROM_SHARE_WRITE);
                    this.mWriteTool.i(this.mData.getForumId(), this.mPrivateThread);
                }
                this.mEditor.d(this.mWriteTool);
            }
            this.mEditor.h(arrayList);
            u05 n2 = this.mEditor.n(5);
            if (n2 != null) {
                n2.j = 1;
            }
        }
    }

    private void initData(Bundle bundle) {
        String stringExtra;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65602, this, bundle) == null) {
            NewWriteModel newWriteModel = new NewWriteModel(this);
            this.mWriteModel = newWriteModel;
            newWriteModel.n0(this.mOnPostWriteCallback);
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
                this.mTopicId = bundle.getString("topic_id");
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
                this.mIsFromShare = intent.getBooleanExtra("from_share", false);
                this.mTopicId = intent.getStringExtra("topic_id");
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
                this.mPrefixData.getPrefixs().add(0, getPageContext().getString(R.string.obfuscated_res_0x7f0f158b));
            }
            OriginalThreadInfo.ShareInfo shareInfo = this.mOriginalThreadInfo;
            if (shareInfo != null && (str = shareInfo.videoId) != null) {
                this.mData.setVideoId(str);
                this.mData.setOriginalVideoCover(this.mOriginalThreadInfo.showPicUrl);
                this.mData.setOriginalVideoTitle(this.mOriginalThreadInfo.showText);
            }
            if (!ni.isEmpty(this.mTransmitOriginThreadComment)) {
                if (!ni.isEmpty(this.mTransmitThreadAuthorNameShow)) {
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
        if (interceptable == null || interceptable.invokeV(65603, this) == null) {
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
            p05 m2 = this.mEditor.m(6);
            if (m2 != null && !TextUtils.isEmpty(this.mDisableAudioMessage)) {
                ((View) m2).setOnClickListener(new b(this));
            }
            if (!this.isLivePhotoType) {
                this.mEditor.A(new i05(34, 5, 1));
            }
            this.mEditor.q();
            if (!vt4.k().h("hot_topic_has_click", false)) {
                this.mEditor.A(new i05(2, 26, " "));
            }
            if (this.mData.getType() == 0) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
                albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
                albumActivityConfig.getIntent().putExtra("from", this.mFrom);
                albumActivityConfig.setCanEditImage(false);
                albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
            showEditorTopicTip();
        }
    }

    private void initEditorListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65604, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(65605, this) == null) {
            ForumTabSelectedView forumTabSelectedView = (ForumTabSelectedView) findViewById(R.id.obfuscated_res_0x7f090bf0);
            this.mForumTabSelectedView = forumTabSelectedView;
            forumTabSelectedView.setBgColor(R.color.CAM_X0205);
            this.mForumTabSelectedView.setData(this.mFrsTabList);
            this.mForumTabSelectedView.setActivity(this);
        }
    }

    private void initOriginalThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65606, this) == null) {
            OriginalThreadCardView originalThreadCardView = (OriginalThreadCardView) findViewById(R.id.obfuscated_res_0x7f092482);
            this.mOriginalThreadCardView = originalThreadCardView;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) originalThreadCardView.getLayoutParams();
            layoutParams.topMargin -= TBDS24;
            int i2 = TBDS44;
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.mOriginalThreadCardView.setLayoutParams(layoutParams);
            this.mOriginalThreadCardView.setVisibility(0);
            this.mOriginalThreadCardView.f(this.mOriginalThreadInfo);
            this.mOriginalThreadCardView.setEnabled(false);
        }
    }

    private void initPostTopic() {
        WriteData writeData;
        PostTopicData postTopicData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65607, this) == null) || (writeData = this.mData) == null || writeData.getType() != 0 || this.mData.getType() != 9 || this.isFeedBackBar || (postTopicData = this.mPostTopicData) == null || StringUtils.isNull(postTopicData.getTitleTopic())) {
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
        if (interceptable == null || interceptable.invokeV(65608, this) == null) {
            this.post_prefix_layout = findViewById(R.id.obfuscated_res_0x7f0918ad);
            this.mPrefix = (TextView) findViewById(R.id.obfuscated_res_0x7f0918ac);
            this.prefix_divider = findViewById(R.id.obfuscated_res_0x7f0918d0);
            this.mPrefixIcon = (ImageView) findViewById(R.id.obfuscated_res_0x7f0918d1);
            PostPrefixData postPrefixData = this.mPrefixData;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 1) {
                this.post_prefix_layout.setVisibility(0);
                ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
                int size = prefixs.size();
                this.mCurrPrefixPos = 1;
                this.post_prefix_layout.setOnClickListener(new m(this));
                ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f0918d1);
                this.mPrefixIcon = imageView;
                if (size > 1) {
                    imageView.setVisibility(0);
                    this.mPrefix.setOnClickListener(new n(this));
                }
                jz8 jz8Var = new jz8(getPageContext().getPageActivity());
                this.mPrefixWindow = jz8Var;
                jz8Var.e(this);
                this.mPrefixWindow.d(oi.f(getActivity(), R.dimen.obfuscated_res_0x7f0702d9));
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
        if (!(interceptable == null || interceptable.invokeV(65609, this) == null) || (hotTopicBussinessData = (HotTopicBussinessData) ListUtils.getItem(this.mList, 0)) == null || TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            return;
        }
        this.mPostTitle.setText(hc5.i(hc5.a(hotTopicBussinessData.mTopicName)));
        this.mPostTitle.setMovementMethod(rw8.a());
    }

    private void initUI() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65610, this) == null) {
            this.mLoadingDialog = new xt4(getPageContext());
            this.isLivePhotoType = this.mData.getType() == 4 || 5 == this.mData.getType();
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.obfuscated_res_0x7f0d08d9, (ViewGroup) null);
            this.mRootView = inflate;
            setContentView(inflate);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923ad);
            this.mNavigationBar = navigationBar;
            navigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mNavigationBar.getBackImageView(), R.drawable.obfuscated_res_0x7f0809bb, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle("");
            this.mName = centerTextTitle;
            SkinManager.setViewTextColor(centerTextTitle, (int) R.color.CAM_X0105);
            setPostView();
            ScrollView scrollView = (ScrollView) findViewById(R.id.obfuscated_res_0x7f092483);
            this.write_scrollview = scrollView;
            scrollView.setOnTouchListener(new f(this));
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.mParent = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091642);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092080);
            this.mToolView = linearLayout;
            linearLayout.setContentDescription(IStringUtil.TOP_PATH);
            this.mTitleView = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092045);
            this.mInterval = findViewById(R.id.obfuscated_res_0x7f090f36);
            this.mHotTopicEdt = (TextView) findViewById(R.id.obfuscated_res_0x7f090df8);
            initializePostTitle();
            if (this.isLivePhotoType) {
                this.write_scrollview.setVisibility(8);
                this.writeImagesInfo.setMaxImagesAllowed(6);
            }
            initializePostContent();
            initOriginalThread();
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0918a2);
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
            if (this.mData.getType() == 4 && (view2 = this.post_prefix_layout) != null && this.prefix_divider != null) {
                view2.setVisibility(8);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65611, this)) == null) {
            if (((ImageSpan[]) getRealContentEdittextInstance().getText().getSpans(0, getRealContentEdittextInstance().getText().length(), ImageSpan.class)).length > 10) {
                if (this.mTooManyEmotionToast == null) {
                    this.mTooManyEmotionToast = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.obfuscated_res_0x7f0f1403, 0);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65612, this)) == null) {
            return getRealContentEdittextInstance().getText() != null && getRealContentEdittextInstance().getText().length() >= (this.mAdditionData != null ? 1000 : 5000);
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performHotTopicClick(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65613, this, z2) == null) || hc5.c(getPageContext(), z2, false)) {
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
    public void popupSaveDraft() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65614, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(65615, this) == null) {
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
            writeData.setHasLocationData(locationModel != null && locationModel.B());
            this.mWriteModel.i0(this.writeImagesInfo.size() > 0);
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
            this.mWriteModel.b0().setVoice(null);
            this.mWriteModel.b0().setVoiceDuringTime(-1);
            if (!mi.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c17);
                return;
            }
            showLoadingDialog(getPageContext().getString(R.string.obfuscated_res_0x7f0f10ef), this.mDialogCancelListener);
            this.mWriteModel.r0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postPhotoTextThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65616, this) == null) {
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

    private void realInsert(SpannableStringBuilder spannableStringBuilder, int i2, fo foVar, EmotionGroupType emotionGroupType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65617, this, spannableStringBuilder, i2, foVar, emotionGroupType) == null) || spannableStringBuilder == null || getRealContentEdittextInstance() == null || getRealContentEdittextInstance().getText() == null) {
            return;
        }
        Bitmap p2 = foVar.p();
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
            if (getRealContentEdittextInstance() instanceof SpanGroupEditText) {
                this.mContentBuilder.append((CharSequence) ((SpanGroupEditText) getRealContentEdittextInstance()).getSpanGroupManager().y());
            } else {
                this.mContentBuilder.append((CharSequence) text);
            }
            text.clear();
            if (getRealContentEdittextInstance() instanceof SpanGroupEditText) {
                ((SpanGroupEditText) getRealContentEdittextInstance()).getSpanGroupManager().q();
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
        if (!(interceptable == null || interceptable.invokeV(65618, this) == null) || this.mData == null) {
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
        if (interceptable == null || interceptable.invokeV(65619, this) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(65620, this) == null) || (editorTools = this.mEditor) == null) {
            return;
        }
        editorTools.A(new i05(54, 15, null));
    }

    private void resetCheckImgState(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65621, this, i2) == null) || i2 >= this.mPrefixItems.size()) {
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
        if (!(interceptable == null || interceptable.invokeZ(65622, this, z2) == null) || (editorTools = this.mEditor) == null) {
            return;
        }
        editorTools.A(new i05(9, -1, Boolean.valueOf(z2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLocaionAction(int i2, boolean z2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65623, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str}) == null) {
            this.mLocationState = i2;
            EditorTools editorTools = this.mEditor;
            if (editorTools != null) {
                editorTools.A(new i05(19, 15, new y15(i2, z2, str)));
            }
        }
    }

    private void sendSetImgAction() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65624, this) == null) || this.isLivePhotoType || (editorTools = this.mEditor) == null) {
            return;
        }
        editorTools.A(new i05(12, -1, new c15(this.writeImagesInfo, true)));
        this.mEditor.A(new i05(12, 11, new c15(this.writeImagesInfo, true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendTopicNotify() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65625, this) == null) || StringUtils.isNull(this.mTopicId)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921634, this.mTopicId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUpdatePhotoLiveMessage(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65626, this, postWriteCallBackData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
        }
    }

    private void setPostButtonEnabled(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65627, this, z2) == null) {
            SkinManager.setNavbarTitleColor(this.mPost, R.color.CAM_X0302, R.color.s_navbar_title_color);
        }
    }

    private void setPostView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65628, this) == null) {
            TextView addTextButton = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f110e));
            this.mPost = addTextButton;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) addTextButton.getLayoutParams();
            layoutParams.rightMargin = oi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701b2);
            this.mPost.setLayoutParams(layoutParams);
            this.mPost.setOnFocusChangeListener(this.mFocusChangeListener);
        }
    }

    private void showAdditionTip(boolean z2, String str) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65629, this, z2, str) == null) {
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
                    String format = String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f1582), Integer.valueOf(i2 - i3));
                    sb.append("\n");
                    sb.append(format);
                }
            }
            oi.N(getPageContext().getPageActivity(), sb.toString());
        }
    }

    private void showEditorTopicTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65630, this) == null) {
            if (this.mTipController == null) {
                this.mTipController = new e19(getPageContext());
            }
            this.mTipController.c(this.mEditor);
        }
    }

    private void showLocPermissionDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65631, this) == null) {
            cr4 cr4Var = new cr4(getPageContext().getPageActivity());
            cr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0a40).setPositiveButton(R.string.obfuscated_res_0x7f0f0964, new y(this)).setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new x(this)).create(getPageContext());
            cr4Var.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTipDialog(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(65632, this, z2, postWriteCallBackData) == null) || postWriteCallBackData == null) {
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
                errorString2 = getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f10eb);
            }
            showToast(errorString2);
        } else if (this.mData.getType() != 7) {
            if (this.mAdditionData == null) {
                if (checkVideoEasterEgg(postWriteCallBackData)) {
                    return;
                }
                en8.b(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
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
        if (!(interceptable == null || interceptable.invokeV(65633, this) == null) || (writeData = this.mData) == null) {
            return;
        }
        int type = writeData.getType();
        if (type != 0) {
            if (type == 4) {
                this.mName.setText(R.string.obfuscated_res_0x7f0f0ef8);
                this.mPostContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                return;
            } else if (type != 9) {
                this.mName.setText(R.string.obfuscated_res_0x7f0f10ea);
                this.mPostContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.mPostTitle.setVisibility(8);
                return;
            }
        }
        String str3 = this.mCallFrom;
        if (str3 != null && str3.equals("1")) {
            this.mName.setText(R.string.obfuscated_res_0x7f0f1147);
        } else {
            String str4 = this.mCallFrom;
            if (str4 != null && str4.equals("2")) {
                String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.obfuscated_res_0x7f0f1144) + this.mData.getForumName(), 9, true, false);
                if (fixedBarText.length() < 14) {
                    str2 = fixedBarText + getResources().getString(R.string.obfuscated_res_0x7f0f02ca);
                } else {
                    str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.obfuscated_res_0x7f0f02ca);
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
        if (interceptable == null || interceptable.invokeV(65634, this) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(65635, this) == null) || (editText = this.mPostTitle) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (this.mGestureDetector.onTouchEvent(motionEvent)) {
                motionEvent.setAction(3);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.v75
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
            SpanGroupEditText spanGroupEditText = (SpanGroupEditText) findViewById(R.id.obfuscated_res_0x7f0918a0);
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
            if (!ni.isEmpty(this.mTransmitOriginThreadComment)) {
                this.mPostContent.setSelection(0);
            }
            this.mPostContent.setOnFocusChangeListener(this.mFocusChangeListener);
            this.mPostContent.setOnTouchListener(new p(this));
            this.mPostContent.addTextChangedListener(this.mWriteContentTextWatcher);
            OriginalThreadInfo.ShareInfo shareInfo = this.mOriginalThreadInfo;
            if (shareInfo != null && shareInfo.showType == 3) {
                this.mPostContent.setHint(R.string.obfuscated_res_0x7f0f114b);
            } else {
                this.mPostContent.setHint(R.string.obfuscated_res_0x7f0f114a);
            }
        }
    }

    public void initializePostTitle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f0918c2);
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
            this.mPostTitle.setHint(getResources().getString(R.string.obfuscated_res_0x7f0f0ea2));
        }
    }

    public void insertFaceIconToEditText(zw4 zw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, zw4Var) == null) {
            if (((ImageSpan[]) getRealContentEdittextInstance().getText().getSpans(0, getRealContentEdittextInstance().getText().length(), ImageSpan.class)).length >= 10) {
                if (this.mTooManyEmotionToast == null) {
                    this.mTooManyEmotionToast = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.obfuscated_res_0x7f0f1403, 0);
                }
                if (Build.VERSION.SDK_INT >= 28 && this.mTooManyEmotionToast.getView().isShown()) {
                    this.mTooManyEmotionToast.cancel();
                }
                this.mTooManyEmotionToast.show();
                return;
            }
            u86.b(this, zw4Var, getRealContentEdittextInstance());
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
                ArrayList parcelableArrayListExtra = intent != null ? intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA) : null;
                int selectionStart = getRealContentEdittextInstance().getSelectionStart();
                if (selectionStart > 0) {
                    int i4 = selectionStart - 1;
                    if (getRealContentEdittextInstance().getText().toString().charAt(i4) == '@') {
                        getRealContentEdittextInstance().getEditableText().delete(i4, selectionStart);
                    }
                }
                if (getRealContentEdittextInstance() instanceof SpanGroupEditText) {
                    ((SpanGroupEditText) getRealContentEdittextInstance()).e(parcelableArrayListExtra);
                }
                if (parcelableArrayListExtra == null || parcelableArrayListExtra.size() <= 0) {
                    return;
                }
                getRealContentEdittextInstance().getText().delete(getRealContentEdittextInstance().getSelectionStart(), getRealContentEdittextInstance().getSelectionEnd());
                if (getRealContentEdittextInstance() instanceof SpanGroupEditText) {
                    ((SpanGroupEditText) getRealContentEdittextInstance()).b(parcelableArrayListExtra);
                }
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
            } else if (intent == null) {
            } else {
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
            SkinManager.setViewTextColor(this.mName, (int) R.color.CAM_X0105);
            updateHintTextColor();
            updateTitleStyle();
            a19 a19Var = this.mHighLightController;
            if (a19Var != null) {
                a19Var.m(getRealTitleInstance(), getRealContentEdittextInstance());
            }
            OriginalThreadCardView originalThreadCardView = this.mOriginalThreadCardView;
            if (originalThreadCardView != null) {
                originalThreadCardView.q();
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
            locationModel.Q(this.mOnLocationCallBack);
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
            qw8 qw8Var = new qw8(getPageContext().getPageActivity(), new l(this), new Date().getHours(), new Date().getMinutes(), false);
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
                jz8 jz8Var = this.mPrefixWindow;
                if (jz8Var != null && jz8Var.isShowing()) {
                    rg.d(this.mPrefixWindow, getPageContext().getPageActivity());
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
            a09 a09Var = this.mWriteTool;
            if (a09Var != null && !z2) {
                a09Var.g();
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            HidenSoftKeyPad(this.mInputManager, getRealTitleInstance());
            HidenSoftKeyPad(this.mInputManager, getRealContentEdittextInstance());
            super.onPause();
        }
    }

    @Override // com.repackage.jz8.a
    public void onPrefixItemClick(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.mCurrPrefixPos = i2;
            this.mPrefixWindow.c(i2);
            resetCheckImgState(i2);
            this.mPrefix.setText(this.mPrefixData.getPrefixs().get(i2));
            refreshPostButton();
            rg.d(this.mPrefixWindow, getPageContext().getPageActivity());
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
            super.onRequestPermissionsResult(i2, strArr, iArr);
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
            super.overridePendingTransition(R.anim.obfuscated_res_0x7f01000d, R.anim.obfuscated_res_0x7f01000c);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, str, onCancelListener) == null) {
            this.mLoadingDialog.e(null);
            this.mLoadingDialog.i(R.string.obfuscated_res_0x7f0f10ef);
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
