package com.baidu.tieba.personExtra;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.e1.o0;
import c.a.s0.s.s.a;
import c.a.s0.s.s.c;
import c.a.s0.s.s.j;
import c.a.s0.t.i.b;
import c.a.t0.l1.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.EditNickNameActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.HeadIconRefreshHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.personExtra.PersonChangeModel;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.widget.InterestForumTagLayout;
import com.baidu.tieba.widget.InterestForumTagView;
import com.baidu.tieba.widget.ManualObservableScrollView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes12.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_DAYS_THRESHOLD = 2000;
    public static final int FIRST_SCROLL_TO_BOTTOM_DELAY = 400;
    public static final String IS_FROM_PERSONINFO = "isFromPersonInfo";
    public static final int START_LOCAL_TRIP_SHOW_DELAY = 200;
    public static final String TAG_DATA = "data";
    public static final String TAG_PERSON_INFO = "person_change_data";
    public transient /* synthetic */ FieldHolder $fh;
    public final int DEFAULT_NICKNAME_LEFT_DAYS;
    public final int EDIT_MAX_LENGTH;
    public View editLayout;
    public boolean hasUserName;
    public boolean isCompleteLocalInfo;
    public boolean isEdited;
    public Boolean isFromPersonInfo;
    public boolean isUpdate;
    public boolean isUpdateNickName;
    public TextView mAgeView;
    public LinearLayout mAlaIdLayout;
    public TextView mAlaIdNameView;
    public TextView mAlaIdView;
    public final View.OnClickListener mBackClickListener;
    public ImageView mBackIcon;
    public c.a.t0.l1.a mBirthdayPickerHelper;
    public CustomMessageListener mChangeLeftDayListener;
    public boolean mClickOnEditor;
    public LinearLayout mClientNumberMain;
    public TextView mClientid;
    public TextView mClientidShow;
    public View mCloseView;
    public c.a.s0.s.s.a mConfirmDialog;
    public TextView mConstellation;
    public ImageView mConstellationArrow;
    public RelativeLayout mConstellationLayout;
    public TextView mConstellationView;
    public ImageView mCopyClientid;
    public DialogInterface.OnCancelListener mDialogCancelListener;
    public EditText mEdit;
    public LinearLayout mForumAgeLayout;
    public TextView mForumAgeView;
    public ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    public boolean mHasModifyNickName;
    public ProgressBar mImageProgressBar;
    public z mImageTask;
    public InputMethodManager mInputManager;
    public c.a.s0.t.i.b mInputUserNameDialog;
    public InterestForumTagLayout mInterestForumTagLayout;
    public TextView mIntro;
    public LinearLayout mIntroClick;
    public LinearLayout mIntroLayout;
    public LinearLayout mIntroTextTip;
    public TextView mIntroTextTipDivider;
    public TextView mIntroTextTipLimit;
    public TextView mIntroTextTipNum;
    public EMTextView mLocalCityTitle;
    public PersonChangeModel mModel;
    public CustomMessageListener mModifyNicknameSucceedListener;
    public a0 mModifyTask;
    public View mNameContainer;
    public NavigationBar mNavigationBar;
    public TextView mNickName;
    public c.a.s0.s.s.a mNickNameActivityDialog;
    public ImageView mNickNameMore;
    public EditText mNickNameShow;
    public LinearLayout mParent;
    public PermissionJudgePolicy mPermissionJudgement;
    public ManualObservableScrollView mPersonChangeScroll;
    public View mPersonNicknameLayout;
    public c.a.d.n.d.a mPhoto;
    public ImageView mPhotoCameraView;
    public FrameLayout mPhotoParent;
    public HeadImageView mPhotoView;
    public int mPreviousRootHeight;
    public ViewGroup mRootView;
    public TextView mSave;
    public int mSex;
    public ImageView mSexArrow;
    public PopupDialog mSexDialog;
    public RelativeLayout mSexLayout;
    public TextView mSexShow;
    public TextView mSexTitle;
    public TextView mStartLocalHint;
    public TextView mStartLocalTrip;
    public LinearLayout mStartLocalTripLayout;
    public final Runnable mStartLocalTripShowRunnable;
    public String mTempNickName;
    public View mUserNameMoreIcon;
    public TextView mUserNameShow;
    public final WriteImagesInfo mWriteImagesInfo;
    public TextView tvForumAbs;
    public TextView tvForumAge;

    /* loaded from: classes12.dex */
    public class a implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f48983e;

        public a(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48983e = personChangeActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) || z) {
                return;
            }
            this.f48983e.mNickNameShow.setFocusableInTouchMode(false);
        }
    }

    /* loaded from: classes12.dex */
    public class a0 extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public PersonChangeModel f48984b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f48985c;

        public a0(PersonChangeActivity personChangeActivity, PersonChangeModel personChangeModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity, personChangeModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48985c = personChangeActivity;
            this.a = null;
            this.f48984b = null;
            this.f48984b = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48985c.mModifyTask = null;
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                PersonChangeActivity personChangeActivity = this.f48985c;
                personChangeActivity.showLoadingDialog(personChangeActivity.getPageContext().getString(c.a.t0.y2.g.saving), this.f48985c.mDialogCancelListener);
                super.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                if (this.f48984b == null) {
                    return null;
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.a = netWork;
                netWork.addPostData("sex", String.valueOf(this.f48984b.A().getSex()));
                this.a.addPostData("intro", this.f48984b.A().getIntro());
                this.a.addPostData("birthday_time", String.valueOf(this.f48984b.A().getBirthdayTime()));
                this.a.addPostData("birthday_show_status", String.valueOf(this.f48984b.A().getBirthdayShowStatus()));
                if (c.a.s0.b.d.M()) {
                    this.a.addPostData("need_keep_nickname_flag", "0");
                    this.a.addPostData(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
                    this.a.addPostData("is_business_account", this.f48984b.A().getIsBusinessAccount());
                    if (!TextUtils.isEmpty(this.f48984b.A().getTempNickName())) {
                        this.a.addPostData("nick_name", this.f48984b.A().getTempNickName());
                    }
                } else {
                    this.a.addPostData("need_keep_nickname_flag", "1");
                }
                if (this.f48985c.isCompleteLocalInfo) {
                    this.a.addPostData("do_from", "local_user_profile");
                    this.a.addPostData("forum_data", this.f48984b.A().getInterestedForumsJsonString());
                }
                this.a.postMultiNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    c.a.t0.w3.p0.a.j();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f48985c.mModifyTask = null;
                this.f48985c.closeLoadingDialog();
                NetWork netWork = this.a;
                if (netWork != null) {
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        this.f48985c.setDataAndFinish();
                        this.f48985c.showSuccessToast();
                    } else {
                        this.f48985c.showTopToast(this.a.getErrorString(), false);
                    }
                }
                super.onPostExecute((a0) str);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public b(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 == 6) {
                    this.a.mNickNameShow.setFocusableInTouchMode(false);
                    this.a.mNickNameShow.setCursorVisible(false);
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f48986e;

        public c(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48986e = personChangeActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f48986e.refreshStartLocalTripStatus();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f48987e;

        public d(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48987e = personChangeActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) || z) {
                return;
            }
            this.f48987e.mEdit.setFocusableInTouchMode(false);
        }
    }

    /* loaded from: classes12.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f48988e;

        public e(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48988e = personChangeActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.f48988e.mModel.A() == null || editable.toString().replaceAll("\\s*", "").equals(this.f48988e.mModel.A().getIntro())) {
                return;
            }
            this.f48988e.isUpdate = true;
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                SkinManager.setViewTextColor(this.f48988e.mSave, c.a.t0.y2.a.navi_op_text, 1);
            } else {
                SkinManager.setViewTextColor(this.f48988e.mSave, c.a.t0.y2.a.CAM_X0302, 1);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                Editable text = this.f48988e.mEdit.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                this.f48988e.mIntroTextTipNum.setText(String.valueOf(length));
                this.f48988e.mIntroTextTip.setVisibility(0);
                this.f48988e.showIntroTextTip();
                if (length > 500) {
                    this.f48988e.showTopToast(c.a.t0.y2.g.over_limit_tip, false);
                    if (this.f48988e.mEdit.getSelectionStart() - 1 < 0 || this.f48988e.mEdit.getSelectionStart() - 1 > this.f48988e.mEdit.getSelectionEnd()) {
                        this.f48988e.mEdit.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(this.f48988e.mEdit.getSelectionStart() - 1, this.f48988e.mEdit.getSelectionEnd());
                        this.f48988e.mEdit.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd > length2) {
                        selectionEnd = length2;
                    }
                    Selection.setSelection(this.f48988e.mEdit.getText(), selectionEnd);
                }
                this.f48988e.refreshStartLocalTripStatus();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f48989e;

        public f(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48989e = personChangeActivity;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f48989e.clickSaveEvents();
                this.f48989e.saveProfile();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f48990e;

        public g(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48990e = personChangeActivity;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f48990e.mModel.A().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (!this.f48990e.isFromPersonInfo.booleanValue()) {
                        intent.putExtra("data", this.f48990e.mModel.A());
                    } else {
                        intent.putExtra("person_change_data", this.f48990e.mModel.A());
                    }
                    this.f48990e.setResult(-1, intent);
                    this.f48990e.sendUpdateMessage();
                }
                this.f48990e.finish();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f48991e;

        public h(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48991e = personChangeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48991e.mPersonChangeScroll.scrollTo(0, 0);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class i implements ManualObservableScrollView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public i(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // com.baidu.tieba.widget.ManualObservableScrollView.a
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
                PersonChangeActivity personChangeActivity = this.a;
                c.a.d.f.p.n.w(personChangeActivity, personChangeActivity.mRootView);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class j implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f48992e;

        public j(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48992e = personChangeActivity;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int height = this.f48992e.mRootView.getHeight();
                if (this.f48992e.mPreviousRootHeight != 0 && this.f48992e.mPreviousRootHeight != height) {
                    if (height > this.f48992e.mPreviousRootHeight) {
                        c.a.d.f.m.e.a().postDelayed(this.f48992e.mStartLocalTripShowRunnable, 200L);
                    } else if (this.f48992e.mStartLocalTripLayout != null) {
                        this.f48992e.mStartLocalTripLayout.setVisibility(8);
                    }
                }
                this.f48992e.mPreviousRootHeight = height;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f48993e;

        public k(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48993e = personChangeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48993e.mStartLocalTripLayout == null) {
                return;
            }
            this.f48993e.mStartLocalTripLayout.setVisibility(0);
        }
    }

    /* loaded from: classes12.dex */
    public class l implements c.InterfaceC0871c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public l(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // c.a.s0.s.s.c.InterfaceC0871c
        public void a(c.a.s0.s.s.c cVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, cVar, i2, view) == null) {
                if (i2 == 0) {
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.a.getPageContext().getPageActivity(), this.a.mWriteImagesInfo.toJsonString(), true);
                    albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                    albumActivityConfig.setResourceType(2);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                } else if (i2 == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.a.getPageContext().getPageActivity(), 12014)));
                }
                cVar.e();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class m implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48994e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48995f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f48996g;

        public m(PersonChangeActivity personChangeActivity, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48996g = personChangeActivity;
            this.f48994e = str;
            this.f48995f = str2;
        }

        @Override // c.a.s0.s.s.j.e
        public void onItemClick(c.a.s0.s.s.j jVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, jVar, i2, view) == null) {
                if (this.f48996g.mSexDialog != null && this.f48996g.mSexDialog.isShowing()) {
                    this.f48996g.mSexDialog.dismiss();
                }
                if (view instanceof TextView) {
                    TextView textView = (TextView) view;
                    if (this.f48994e.equals(textView.getText().toString())) {
                        this.f48996g.mSex = 1;
                        this.f48996g.mSexShow.setText(this.f48994e);
                    } else if (this.f48995f.equals(textView.getText().toString())) {
                        this.f48996g.mSex = 2;
                        this.f48996g.mSexShow.setText(this.f48995f);
                    }
                    SkinManager.setViewTextColor(this.f48996g.mSexShow, c.a.t0.y2.a.CAM_X0105);
                    if (this.f48996g.mSex != this.f48996g.mModel.A().getSex()) {
                        this.f48996g.isUpdate = true;
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            SkinManager.setViewTextColor(this.f48996g.mSave, c.a.t0.y2.a.navi_op_text, 1);
                        } else {
                            SkinManager.setViewTextColor(this.f48996g.mSave, c.a.t0.y2.a.CAM_X0302, 1);
                        }
                    }
                    this.f48996g.refreshStartLocalTripStatus();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f48997e;

        public n(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48997e = personChangeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f48997e.mModel.A().getSex() != this.f48997e.mSex) {
                    this.f48997e.isEdited = true;
                }
                this.f48997e.saveTempNickName();
                if (this.f48997e.isCompleteLocalInfo || (!this.f48997e.isEdited && !this.f48997e.isUpdateNickName)) {
                    if (this.f48997e.mModel != null && this.f48997e.mModel.A().getPhotoChanged()) {
                        Intent intent = new Intent();
                        if (this.f48997e.isFromPersonInfo.booleanValue()) {
                            intent.putExtra("person_change_data", this.f48997e.mModel.A());
                        } else {
                            intent.putExtra("data", this.f48997e.mModel.A());
                        }
                        this.f48997e.sendUpdateMessage();
                        this.f48997e.setResult(-1, intent);
                    }
                    this.f48997e.finish();
                    return;
                }
                this.f48997e.mConfirmDialog.show();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f48998e;

        public o(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48998e = personChangeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity currentActivity;
            String string;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || currentActivity.findViewById(16908290) == null) {
                return;
            }
            if (this.f48998e.isCompleteLocalInfo) {
                string = currentActivity.getString(c.a.t0.y2.g.complete_local_info_success);
            } else {
                string = currentActivity.getString(c.a.t0.y2.g.change_name_success);
            }
            new BdTopToast(currentActivity).setIcon(true).setContent(string).show((ViewGroup) currentActivity.findViewById(16908290));
        }
    }

    /* loaded from: classes12.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(PersonChangeActivity personChangeActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity, Integer.valueOf(i2)};
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
            this.a = personChangeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                String str = (String) data;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.a.mHasModifyNickName = true;
                this.a.mTempNickName = str;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(PersonChangeActivity personChangeActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity, Integer.valueOf(i2)};
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
            this.a = personChangeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (this.a.mModel == null || this.a.mModel.A() == null || personChangeData == null) {
                    return;
                }
                this.a.mModel.A().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                this.a.mModel.A().setMem(personChangeData.getMen());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class r implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public r(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // c.a.t0.l1.a.c
        public void a(Date date, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, date, j2) == null) {
                this.a.mModel.A().setBirthdayTime(j2);
                this.a.mConstellationView.setText(StringHelper.dateToConstellation(date));
                this.a.mAgeView.setText(this.a.getResources().getString(c.a.t0.y2.g.person_information_header_age, Integer.valueOf(PersonChangeActivity.getAgeByBirthday(date))));
                this.a.mAgeView.setVisibility(0);
                SkinManager.setViewTextColor(this.a.mConstellationView, c.a.t0.y2.a.CAM_X0105);
                this.a.refreshStartLocalTripStatus();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class s implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f48999e;

        public s(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48999e = personChangeActivity;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f48999e.getPageContext().getPageActivity(), null, c.a.t0.s2.c.a(), true)));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class t implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f49000e;

        public t(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49000e = personChangeActivity;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class u implements b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public u(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // c.a.s0.t.i.b.e
        public void a(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, accountData) == null) || accountData == null) {
                return;
            }
            this.a.resetUserName(accountData.getAccount());
        }
    }

    /* loaded from: classes12.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f49001e;

        public v(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49001e = personChangeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49001e.mPersonChangeScroll.fullScroll(130);
                this.f49001e.mEdit.setFocusableInTouchMode(true);
                this.f49001e.mEdit.requestFocus();
                PersonChangeActivity personChangeActivity = this.f49001e;
                personChangeActivity.ShowSoftKeyPad(personChangeActivity.mInputManager, this.f49001e.mEdit);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class w implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f49002e;

        public w(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49002e = personChangeActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f49002e.destroyWaitingDialog();
                if (this.f49002e.mModifyTask != null) {
                    this.f49002e.mModifyTask.cancel();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class x implements PersonChangeModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public x(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // com.baidu.tieba.personExtra.PersonChangeModel.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.isLoadingViewAttached()) {
                    PersonChangeActivity personChangeActivity = this.a;
                    personChangeActivity.hideLoadingView(personChangeActivity.mRootView);
                }
                PersonChangeActivity personChangeActivity2 = this.a;
                personChangeActivity2.showNetRefreshView(personChangeActivity2.mRootView, str);
            }
        }

        @Override // com.baidu.tieba.personExtra.PersonChangeModel.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.isLoadingViewAttached()) {
                    PersonChangeActivity personChangeActivity = this.a;
                    personChangeActivity.hideLoadingView(personChangeActivity.mRootView);
                }
                this.a.mParent.setVisibility(0);
                this.a.bindData();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class y implements InterestForumTagView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public y(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // com.baidu.tieba.widget.InterestForumTagView.b
        public void a(SelectForumData selectForumData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, selectForumData) == null) {
                this.a.refreshStartLocalTripStatus();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class z extends BdAsyncTask<Object, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public z(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) ? FileHelper.getImage(null, TbConfig.PERSON_HEAD_FILE) : (Bitmap) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.mImageTask = null;
                this.a.mImageProgressBar.setVisibility(8);
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.onCancelled();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.a.mImageProgressBar.setVisibility(0);
                this.a.mPhotoView.setImageDrawable(null);
                this.a.mPhoto = null;
                super.onPreExecute();
            }
        }

        public /* synthetic */ z(PersonChangeActivity personChangeActivity, k kVar) {
            this(personChangeActivity);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, bitmap) == null) {
                super.onPostExecute((z) bitmap);
                this.a.mImageTask = null;
                this.a.mImageProgressBar.setVisibility(8);
                if (bitmap != null) {
                    this.a.mPhoto = new c.a.d.n.d.a(bitmap, false, (String) null);
                    this.a.mPhoto.h(this.a.mPhotoView);
                    c.a.s0.c0.c.k().c(this.a.mModel.A().getPortrait(), this.a.mPhoto, true);
                }
            }
        }
    }

    public PersonChangeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.DEFAULT_NICKNAME_LEFT_DAYS = 90;
        this.isFromPersonInfo = Boolean.FALSE;
        this.mWriteImagesInfo = new WriteImagesInfo(1);
        this.mNavigationBar = null;
        this.mSave = null;
        this.mParent = null;
        this.mPersonChangeScroll = null;
        this.mSexLayout = null;
        this.mIntroClick = null;
        this.mEdit = null;
        this.mIntroTextTip = null;
        this.mInputManager = null;
        this.mClickOnEditor = false;
        this.mModel = null;
        this.mPhotoView = null;
        this.mPhoto = null;
        this.mImageTask = null;
        this.mModifyTask = null;
        this.mImageProgressBar = null;
        this.mDialogCancelListener = null;
        this.mConfirmDialog = null;
        this.mSexDialog = null;
        this.isEdited = false;
        this.isUpdate = false;
        this.isUpdateNickName = false;
        this.mSex = 0;
        this.EDIT_MAX_LENGTH = 500;
        this.hasUserName = false;
        this.mHasModifyNickName = false;
        this.mStartLocalTripShowRunnable = new k(this);
        this.mBackClickListener = new n(this);
        this.mModifyNicknameSucceedListener = new p(this, 2921033);
        this.mChangeLeftDayListener = new q(this, 2921061);
    }

    private void InitData(Bundle bundle) {
        PersonChangeData personChangeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, bundle) == null) {
            this.mDialogCancelListener = new w(this);
            if (bundle != null) {
                String string = bundle.getString("data");
                personChangeData = !StringUtils.isNull(string) ? (PersonChangeData) OrmObject.objectWithJsonStr(string, PersonChangeData.class) : null;
            } else {
                personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
            }
            if (personChangeData == null) {
                personChangeData = new PersonChangeData();
            }
            this.mModel = new PersonChangeModel(getPageContext(), personChangeData);
            if (this.isCompleteLocalInfo) {
                showViewsForHomeLocalInfoComplete();
                this.mParent.setVisibility(8);
                showLoadingView(this.mRootView);
                this.mModel.B(new x(this));
                this.mModel.loadData();
            } else {
                bindData();
            }
            setupNavigationForPersonInfo();
        }
    }

    private void InitUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mPhotoCameraView = (ImageView) findViewById(c.a.t0.y2.d.photo_pop_icon);
            this.mRootView = (ViewGroup) findViewById(c.a.t0.y2.d.main_parent);
            this.mPhotoCameraView.setOnClickListener(this);
            HeadImageView headImageView = (HeadImageView) findViewById(c.a.t0.y2.d.photo);
            this.mPhotoView = headImageView;
            headImageView.setOnClickListener(this);
            this.mParent = (LinearLayout) findViewById(c.a.t0.y2.d.parent);
            this.mPersonChangeScroll = (ManualObservableScrollView) findViewById(c.a.t0.y2.d.person_change_scroll);
            this.mSexLayout = (RelativeLayout) findViewById(c.a.t0.y2.d.person_sex);
            this.mSexShow = (TextView) findViewById(c.a.t0.y2.d.sex_show);
            NavigationBar navigationBar = (NavigationBar) findViewById(c.a.t0.y2.d.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, c.a.t0.y2.e.widget_nb_item_finish, this.mBackClickListener);
            this.mCloseView = addCustomView;
            ImageView imageView = (ImageView) addCustomView.findViewById(c.a.t0.y2.d.widget_navi_back_button);
            this.mBackIcon = imageView;
            imageView.setContentDescription(getPageContext().getPageActivity().getResources().getString(c.a.t0.y2.g.close));
            this.mForumAgeLayout = (LinearLayout) findViewById(c.a.t0.y2.d.forum_age_ll);
            this.tvForumAbs = (TextView) findViewById(c.a.t0.y2.d.tv_forum_abs);
            this.tvForumAge = (TextView) findViewById(c.a.t0.y2.d.tv_forum_age);
            this.mSexLayout.setOnClickListener(this);
            LinearLayout linearLayout = (LinearLayout) findViewById(c.a.t0.y2.d.intro_click);
            this.mIntroClick = linearLayout;
            linearLayout.setOnClickListener(this);
            EditText editText = (EditText) findViewById(c.a.t0.y2.d.nick_name_edit);
            this.mNickNameShow = editText;
            editText.setHintTextColor(SkinManager.getColor(c.a.t0.y2.a.CAM_X0110));
            this.mNickNameShow.setOnClickListener(this);
            this.mLocalCityTitle = (EMTextView) findViewById(c.a.t0.y2.d.local_city_title);
            this.mPhotoParent = (FrameLayout) findViewById(c.a.t0.y2.d.photo_parent_fl);
            this.mSexTitle = (TextView) findViewById(c.a.t0.y2.d.sex_text);
            this.mSexArrow = (ImageView) findViewById(c.a.t0.y2.d.sex_arrow_iv);
            this.mInterestForumTagLayout = (InterestForumTagLayout) findViewById(c.a.t0.y2.d.interest_forum_tag_layout);
            this.mStartLocalTripLayout = (LinearLayout) findViewById(c.a.t0.y2.d.start_local_ll);
            this.mStartLocalHint = (TextView) findViewById(c.a.t0.y2.d.start_local_hint);
            TextView textView = (TextView) findViewById(c.a.t0.y2.d.start_local_trip);
            this.mStartLocalTrip = textView;
            textView.setOnClickListener(this);
            this.mIntroLayout = (LinearLayout) findViewById(c.a.t0.y2.d.intro_ll);
            this.mNickName = (TextView) findViewById(c.a.t0.y2.d.nick_name);
            if (c.a.s0.b.d.M()) {
                this.mNickNameShow.setOnFocusChangeListener(new a(this));
                this.mNickNameShow.setOnEditorActionListener(new b(this));
                this.mNickNameShow.addTextChangedListener(new c(this));
            } else {
                this.mNickNameShow.setFocusableInTouchMode(false);
                this.mNickNameShow.setCursorVisible(false);
            }
            this.mClientid = (TextView) findViewById(c.a.t0.y2.d.person_clientid);
            this.mClientNumberMain = (LinearLayout) findViewById(c.a.t0.y2.d.person_client_number);
            this.mClientidShow = (TextView) findViewById(c.a.t0.y2.d.person_tclient_show);
            this.mCopyClientid = (ImageView) findViewById(c.a.t0.y2.d.person_client_copy);
            this.mClientNumberMain.setOnClickListener(this);
            View findViewById = findViewById(c.a.t0.y2.d.person_nickname);
            this.mPersonNicknameLayout = findViewById;
            findViewById.setOnClickListener(this);
            ImageView imageView2 = (ImageView) findViewById(c.a.t0.y2.d.nick_name_more);
            this.mNickNameMore = imageView2;
            imageView2.setOnClickListener(this);
            this.mUserNameShow = (TextView) findViewById(c.a.t0.y2.d.user_name_show);
            this.mNameContainer = findViewById(c.a.t0.y2.d.person_name);
            this.mUserNameMoreIcon = findViewById(c.a.t0.y2.d.user_name_more_icon);
            this.mNameContainer.setOnClickListener(this);
            this.mIntroTextTip = (LinearLayout) findViewById(c.a.t0.y2.d.intro_text_tip);
            this.mIntroTextTipNum = (TextView) findViewById(c.a.t0.y2.d.intro_text_tip_num);
            this.mIntroTextTipDivider = (TextView) findViewById(c.a.t0.y2.d.intro_text_tip_divider);
            this.mIntroTextTipLimit = (TextView) findViewById(c.a.t0.y2.d.intro_text_tip_limit);
            TextView textView2 = (TextView) findViewById(c.a.t0.y2.d.intro);
            this.mIntro = textView2;
            textView2.setVisibility(8);
            EditText editText2 = (EditText) findViewById(c.a.t0.y2.d.edit);
            this.mEdit = editText2;
            editText2.setHint(getResources().getString(c.a.t0.y2.g.person_default_sign, "o(〃'▽'〃)o"));
            this.mEdit.setHintTextColor(SkinManager.getColor(c.a.t0.y2.a.CAM_X0110));
            this.mIntroTextTip.setVisibility(0);
            this.mEdit.setOnClickListener(this);
            this.mEdit.setOnFocusChangeListener(new d(this));
            this.mEdit.addTextChangedListener(new e(this));
            this.mImageProgressBar = (ProgressBar) findViewById(c.a.t0.y2.d.image_progress);
            c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(getPageContext().getPageActivity());
            this.mConfirmDialog = aVar;
            aVar.setMessage(getPageContext().getString(c.a.t0.y2.g.confirm_giveup));
            this.mConfirmDialog.setPositiveButton(getPageContext().getString(c.a.t0.y2.g.alert_yes_button), new f(this));
            this.mConfirmDialog.setNegativeButton(getPageContext().getString(c.a.t0.y2.g.cancel), new g(this));
            this.mConfirmDialog.create(getPageContext());
            this.mAlaIdLayout = (LinearLayout) findViewById(c.a.t0.y2.d.person_ala_id_layout);
            this.mAlaIdView = (TextView) findViewById(c.a.t0.y2.d.person_ala_id_show);
            this.mAlaIdNameView = (TextView) findViewById(c.a.t0.y2.d.person_ala_id_name);
            this.mForumAgeView = (TextView) findViewById(c.a.t0.y2.d.person_forum_age_show);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(c.a.t0.y2.d.person_constellation);
            this.mConstellationLayout = relativeLayout;
            relativeLayout.setOnClickListener(this);
            this.mConstellation = (TextView) findViewById(c.a.t0.y2.d.constellation_name);
            this.mConstellationView = (TextView) findViewById(c.a.t0.y2.d.constellation_txt);
            this.mConstellationArrow = (ImageView) findViewById(c.a.t0.y2.d.constellation_arrow_iv);
            this.mAgeView = (TextView) findViewById(c.a.t0.y2.d.age_txt);
            this.mPersonChangeScroll.post(new h(this));
            this.mPersonChangeScroll.setScrollChangedListener(new i(this));
            registerKeyboardEvent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindData() {
        PersonChangeModel personChangeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65587, this) == null) || (personChangeModel = this.mModel) == null || personChangeModel.A() == null) {
            return;
        }
        setNicknameMore();
        this.mPhotoView.startLoad(HeadIconRefreshHelper.headPortraitFilter(this.mModel.A().getPortrait()), 25, false);
        this.mNickNameShow.setText(this.mModel.A().getNameShow());
        PersonChangeModel personChangeModel2 = this.mModel;
        if (personChangeModel2 != null && personChangeModel2.A() != null && !TextUtils.isEmpty(this.mModel.A().getmTiebaId())) {
            this.mClientidShow.setText(this.mModel.A().getmTiebaId());
        } else {
            this.mClientNumberMain.setVisibility(8);
        }
        if (StringUtils.isNull(this.mModel.A().getName())) {
            this.mUserNameShow.setText(getPageContext().getString(c.a.t0.y2.g.tip_empty_user_name));
            this.hasUserName = false;
            this.mNameContainer.setClickable(true);
            this.mUserNameMoreIcon.setVisibility(0);
        } else {
            this.mUserNameShow.setText(this.mModel.A().getName());
            this.hasUserName = true;
            this.mNameContainer.setClickable(false);
            this.mUserNameMoreIcon.setVisibility(8);
        }
        if (this.mModel.A().getIntro() != null && this.mModel.A().getIntro().length() > 0) {
            this.mIntro.setText(this.mModel.A().getIntro());
        } else {
            this.mIntro.setText(getPageContext().getString(c.a.t0.y2.g.add_intro));
        }
        if (!c.a.d.f.p.m.isEmpty(this.mModel.A().getIntro())) {
            this.mEdit.setText(this.mModel.A().getIntro());
            TextView textView = this.mIntroTextTipNum;
            textView.setText(this.mModel.A().getIntro().length() + "");
        } else {
            this.mIntroTextTipNum.setText("0");
        }
        if (this.mModel.A().getSex() == 1) {
            this.mSex = 1;
            this.mSexShow.setText(c.a.t0.y2.g.male);
        } else if (this.mModel.A().getSex() == 2) {
            this.mSex = 2;
            this.mSexShow.setText(c.a.t0.y2.g.female);
        } else {
            SkinManager.setViewTextColor(this.mSexShow, c.a.t0.y2.a.CAM_X0110);
            this.mSexShow.setText(c.a.t0.y2.g.change_sex);
        }
        if (this.mModel.A().getAlaId() > 0) {
            this.mAlaIdLayout.setVisibility(0);
            TextView textView2 = this.mAlaIdView;
            textView2.setText(this.mModel.A().getAlaId() + "");
        }
        this.mForumAgeView.setText(getResources().getString(c.a.t0.y2.g.person_forum_age_suffix, this.mModel.A().getForumAge()));
        if (this.mModel.A().getBirthdayTime() != 0) {
            this.mConstellationView.setText(StringHelper.dateToConstellation(new Date(this.mModel.A().getBirthdayTime() * 1000)));
        }
        if (this.mModel.A().getBirthdayTime() != 0 && this.mModel.A().getUserAge() > 0 && (this.mModel.A().getBirthdayShowStatus() == 2 || this.isCompleteLocalInfo)) {
            this.mAgeView.setText(getResources().getString(c.a.t0.y2.g.person_information_header_age, Integer.valueOf(this.mModel.A().getUserAge())));
            this.mAgeView.setVisibility(0);
        } else {
            this.mAgeView.setVisibility(8);
        }
        if (this.mModel.A().getBirthdayTime() == 0 && this.mAgeView.getVisibility() == 8) {
            this.mConstellationView.setText(getString(c.a.t0.y2.g.change_birthday));
            SkinManager.setViewTextColor(this.mConstellationView, c.a.t0.y2.a.CAM_X0110);
        }
        if (this.isCompleteLocalInfo) {
            this.mInterestForumTagLayout.bindForums(getPageContext(), null, false);
            this.mInterestForumTagLayout.setOnClickListener(this);
            refreshStartLocalTripStatus();
        }
    }

    private boolean checkTempNickName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65588, this)) == null) {
            saveTempNickName();
            String str = this.mTempNickName;
            if (str == null || str.equals(this.mModel.A().getNameShow())) {
                return true;
            }
            return o0.b(this.mTempNickName) <= 20 && o0.b(this.mTempNickName) >= 2;
        }
        return invokeV.booleanValue;
    }

    private void clickChangeNickName() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65589, this) == null) {
            if (c.a.s0.b.d.M()) {
                c.a.s0.s.g0.b.j().t("key_has_show_nick_name_red_icon_tip", true);
                setNicknameMore();
                this.mNickNameShow.setFocusableInTouchMode(true);
                this.mNickNameShow.requestFocus();
                this.mNickNameShow.setCursorVisible(true);
                ShowSoftKeyPad(this.mInputManager, this.mNickNameShow);
                return;
            }
            sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
        }
    }

    private void clickChangeNickNameEvents() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65590, this) == null) || this.isCompleteLocalInfo) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c14378");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        TiebaStatic.log(statisticItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clickSaveEvents() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65591, this) == null) || this.isCompleteLocalInfo) {
            return;
        }
        Editable text = this.mNickNameShow.getText();
        String obj = text == null ? "" : text.toString();
        StatisticItem statisticItem = new StatisticItem("c14379");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_param1", !obj.equals(this.mModel.A().getNameShow()));
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, !this.mEdit.toString().replaceAll("\\s*", "").equals(this.mModel.A().getIntro()));
        TiebaStatic.log(statisticItem);
    }

    public static int getAgeByBirthday(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, null, date)) == null) {
            Calendar calendar = Calendar.getInstance();
            if (calendar.before(date)) {
                return 0;
            }
            int i2 = calendar.get(1);
            int i3 = calendar.get(2) + 1;
            int i4 = calendar.get(5);
            calendar.setTime(date);
            int i5 = calendar.get(1);
            int i6 = calendar.get(2) + 1;
            int i7 = i2 - i5;
            return i3 <= i6 ? (i3 != i6 || i4 < calendar.get(5)) ? i7 - 1 : i7 : i7;
        }
        return invokeL.intValue;
    }

    private void getAlbumDataFromCamera(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65593, this, intent) == null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), w0.I5, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
        }
    }

    private void getAlbumDataFromImage(Intent intent) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65594, this, intent) == null) || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        this.mWriteImagesInfo.parseJson(stringExtra);
        this.mWriteImagesInfo.updateQuality();
        if (this.mWriteImagesInfo.getChosedFiles() != null && this.mWriteImagesInfo.getChosedFiles().size() > 0) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) TaskResponseData.ERROR_NO_TASK_OFFLINE_03, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.mWriteImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
        }
        this.mWriteImagesInfo.clear();
    }

    private c.a.t0.l1.a getBirthdayPickerHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65595, this)) == null) {
            if (this.mBirthdayPickerHelper == null) {
                this.mBirthdayPickerHelper = new c.a.t0.l1.a(this);
            }
            return this.mBirthdayPickerHelper;
        }
        return (c.a.t0.l1.a) invokeV.objValue;
    }

    private a.c getBirthdaySelectListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65596, this)) == null) ? new r(this) : (a.c) invokeV.objValue;
    }

    private void hideEditor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65597, this) == null) {
            if (this.mEdit.getVisibility() == 0 && this.mEdit.isFocused()) {
                String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
                if (replaceAll.length() > 0) {
                    this.mIntro.setText(replaceAll);
                } else {
                    this.mIntro.setText(getPageContext().getString(c.a.t0.y2.g.add_intro));
                }
                if (this.mModel.A().getIntro() == null || !this.mModel.A().getIntro().equals(replaceAll)) {
                    this.isEdited = true;
                }
                this.mModel.A().setIntro(replaceAll);
                HidenSoftKeyPad(this.mInputManager, this.mEdit);
            } else if (this.mNickNameShow.getVisibility() == 0 && this.mNickNameShow.isFocused()) {
                HidenSoftKeyPad(this.mInputManager, this.mNickNameShow);
            }
        }
    }

    private void refreshHead() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65598, this) == null) {
            z zVar = this.mImageTask;
            if (zVar != null) {
                zVar.cancel();
            }
            this.mPhoto = null;
            z zVar2 = new z(this, null);
            this.mImageTask = zVar2;
            zVar2.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshStartLocalTripStatus() {
        PersonChangeModel personChangeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65599, this) == null) || (personChangeModel = this.mModel) == null) {
            return;
        }
        boolean z2 = true;
        this.mStartLocalTrip.setEnabled((!(personChangeModel.y() && this.mSex != 0) || this.mEdit.getText() == null || TextUtils.isEmpty(this.mEdit.getText().toString().trim())) ? false : false);
    }

    private void registerKeyboardEvent() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65600, this) == null) && this.mRootView != null && this.isCompleteLocalInfo) {
            if (this.mGlobalLayoutListener == null) {
                this.mGlobalLayoutListener = new j(this);
            }
            this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetUserName(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65601, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.hasUserName = true;
        this.mUserNameShow.setText(str);
        this.mNameContainer.setClickable(false);
        this.mUserNameMoreIcon.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveProfile() {
        PersonChangeModel personChangeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65602, this) == null) || (personChangeModel = this.mModel) == null || personChangeModel.A() == null) {
            return;
        }
        hideEditor();
        if (c.a.s0.b.d.M() && !checkTempNickName()) {
            showTopToast(c.a.t0.y2.g.person_nick_name_toast, false);
        } else if (!c.a.d.f.p.l.z()) {
            showTopToast(c.a.t0.y2.g.neterror, false);
        } else {
            this.mModel.A().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.mModel.A().setSex(this.mSex);
            if (this.mModifyTask == null) {
                a0 a0Var = new a0(this, this.mModel);
                this.mModifyTask = a0Var;
                a0Var.setPriority(3);
                this.mModifyTask.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveTempNickName() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65603, this) == null) {
            Editable text = this.mNickNameShow.getText();
            this.mTempNickName = text == null ? "" : text.toString();
            this.mModel.A().setTempNickName(this.mTempNickName);
            this.isUpdateNickName = !this.mTempNickName.equals(this.mModel.A().getNameShow());
        }
    }

    private void scrollToBottom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65604, this, i2) == null) {
            this.mPersonChangeScroll.postDelayed(new v(this), i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUpdateMessage() {
        PersonChangeModel personChangeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65605, this) == null) || (personChangeModel = this.mModel) == null || personChangeModel.A() == null) {
            return;
        }
        c.a.s0.a0.b.a().d();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.mModel.A()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataAndFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65606, this) == null) {
            if (!this.isCompleteLocalInfo) {
                Intent intent = new Intent();
                if (this.isFromPersonInfo.booleanValue()) {
                    intent.putExtra("person_change_data", this.mModel.A());
                } else {
                    intent.putExtra("data", this.mModel.A());
                }
                setResult(-1, intent);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921651, Boolean.TRUE));
            }
            sendUpdateMessage();
            finish();
        }
    }

    private void setIntroTextTipStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65607, this, i2) == null) {
            this.mIntroTextTipNum.setTextColor(i2);
            this.mIntroTextTipDivider.setTextColor(i2);
            this.mIntroTextTipLimit.setTextColor(i2);
        }
    }

    private void setNicknameMore() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65608, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNickNameMore.getLayoutParams();
            if (c.a.s0.b.d.M()) {
                layoutParams.width = UtilHelper.getDimenPixelSize(c.a.t0.y2.b.tbds21);
                layoutParams.height = UtilHelper.getDimenPixelSize(c.a.t0.y2.b.tbds21);
                this.mNickNameMore.setImageResource(c.a.t0.y2.c.ic_red_circle);
                if (this.mModel.A().getNickNameLeftDays() == 0 && !c.a.s0.s.g0.b.j().g("key_has_show_nick_name_red_icon_tip", false)) {
                    this.mNickNameMore.setVisibility(0);
                } else {
                    this.mNickNameMore.setVisibility(4);
                }
            } else {
                layoutParams.width = -2;
                layoutParams.height = -2;
                this.mNickNameMore.setImageResource(c.a.t0.y2.c.icon_arrow_more_gray);
                if (!NickNameActivitySwitch.isOn() && this.mModel.A().getNickNameLeftDays() != 0) {
                    this.mNickNameMore.setVisibility(8);
                } else {
                    this.mNickNameMore.setVisibility(0);
                }
            }
            this.mNickNameMore.requestLayout();
        }
    }

    private void setupNavigationForPersonInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65609, this) == null) {
            String string = getResources().getString(c.a.t0.y2.g.my_info);
            if (this.isCompleteLocalInfo) {
                string = getString(c.a.t0.y2.g.local_city_make_friends);
            }
            this.mNavigationBar.setCenterTextTitle(string);
            if (this.isCompleteLocalInfo) {
                return;
            }
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, c.a.t0.y2.e.navigation_right_button_layout, (View.OnClickListener) null);
            this.editLayout = addCustomView;
            TextView textView = (TextView) addCustomView.findViewById(c.a.t0.y2.d.right_textview);
            this.mSave = textView;
            textView.setText(getPageContext().getString(c.a.t0.y2.g.save));
            SkinManager.setViewTextColor(this.mSave, c.a.t0.y2.a.navi_op_text, 1);
            this.editLayout.setOnClickListener(this);
        }
    }

    private void showEditor() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65610, this) == null) || this.mEdit.getVisibility() == 0) {
            return;
        }
        this.mIntro.setVisibility(8);
        this.mEdit.setText(this.mModel.A().getIntro());
        EditText editText = this.mEdit;
        editText.setSelection(editText.getText().length());
        this.mEdit.setFocusableInTouchMode(true);
        this.mEdit.requestFocus();
        ShowSoftKeyPad(this.mInputManager, this.mEdit);
        scrollToBottom(400);
    }

    private void showInputDialog(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65611, this, accountData) == null) {
            if (this.mInputUserNameDialog == null) {
                c.a.s0.t.i.b bVar = new c.a.s0.t.i.b(this);
                this.mInputUserNameDialog = bVar;
                bVar.w(new u(this));
            }
            this.mInputUserNameDialog.p();
            this.mInputUserNameDialog.u(accountData);
            this.mInputUserNameDialog.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showIntroTextTip() {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65612, this) == null) {
            if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 500) {
                color = SkinManager.getColor(c.a.t0.y2.a.common_color_10159);
            } else {
                color = SkinManager.getColor(c.a.t0.y2.a.common_color_10077);
            }
            setIntroTextTipStyle(color);
        }
    }

    private void showNickNameActivityDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65613, this) == null) {
            if (this.mNickNameActivityDialog == null) {
                View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(c.a.t0.y2.e.person_nickname_act_dialog, (ViewGroup) null);
                c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(getPageContext().getPageActivity());
                this.mNickNameActivityDialog = aVar;
                aVar.setContentView(inflate);
                this.mNickNameActivityDialog.setPositiveButton(c.a.t0.y2.g.nick_name_confirm, new s(this));
                this.mNickNameActivityDialog.setNegativeButton(c.a.t0.y2.g.nick_name_cancel, new t(this));
                this.mNickNameActivityDialog.create(getPageContext());
                SkinManager.setViewTextColor(inflate.findViewById(c.a.t0.y2.d.nickname_dialog_title), c.a.t0.y2.a.CAM_X0105);
                SkinManager.setViewTextColor(inflate.findViewById(c.a.t0.y2.d.nickname_dialog_tip), c.a.t0.y2.a.common_color_10122);
            }
            this.mNickNameActivityDialog.show();
        }
    }

    private void showSexDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65614, this) == null) {
            if (this.mSexDialog == null) {
                this.mSexDialog = new PopupDialog(getPageContext());
                String string = getPageContext().getString(c.a.t0.y2.g.male);
                String string2 = getPageContext().getString(c.a.t0.y2.g.female);
                this.mSexDialog.setDefaultContentView(getString(c.a.t0.y2.g.choose_sex), new String[]{string, string2}, new m(this, string, string2));
            }
            this.mSexDialog.showDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSuccessToast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65615, this) == null) {
            c.a.d.f.m.e.a().postDelayed(new o(this), 200L);
        }
    }

    private void showViewsForHomeLocalInfoComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65616, this) == null) {
            this.mLocalCityTitle.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPhotoParent.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, c.a.d.f.p.n.f(this, c.a.t0.y2.b.M_H_X009), layoutParams.rightMargin, layoutParams.bottomMargin);
            this.mNameContainer.setVisibility(8);
            this.mClientNumberMain.setVisibility(8);
            this.mAlaIdLayout.setVisibility(8);
            this.mForumAgeLayout.setVisibility(8);
            this.mInterestForumTagLayout.setVisibility(0);
            this.mStartLocalTripLayout.setVisibility(0);
            this.mIntroLayout.setOrientation(1);
            this.mConstellation.setText(getString(c.a.t0.y2.g.person_age));
            this.tvForumAbs.setText(getString(c.a.t0.y2.g.make_friends_announcement));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mEdit.getLayoutParams();
            layoutParams2.setMargins(0, c.a.d.f.p.n.f(this, c.a.t0.y2.b.tbds18), 0, 0);
            layoutParams2.height = c.a.d.f.p.n.f(this, c.a.t0.y2.b.tbds229);
            this.mEdit.setGravity(51);
            this.mEdit.setHint(getString(c.a.t0.y2.g.local_city_make_friends_hint));
            Drawable pureDrawable = WebPManager.getPureDrawable(c.a.t0.y2.c.icon_pure_mustfill, SkinManager.getColor(c.a.t0.y2.a.CAM_X0301), null);
            if (pureDrawable != null) {
                this.mNickName.setCompoundDrawablePadding(c.a.d.f.p.n.f(this, c.a.t0.y2.b.M_W_X002));
                this.mNickName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
                this.mSexTitle.setCompoundDrawablePadding(c.a.d.f.p.n.f(this, c.a.t0.y2.b.M_W_X002));
                this.mSexTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
                this.mConstellation.setCompoundDrawablePadding(c.a.d.f.p.n.f(this, c.a.t0.y2.b.M_W_X002));
                this.mConstellation.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
                this.tvForumAbs.setCompoundDrawablePadding(c.a.d.f.p.n.f(this, c.a.t0.y2.b.M_W_X002));
                this.tvForumAbs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
            }
            this.mInterestForumTagLayout.setMustFill(true);
            this.mInterestForumTagLayout.setDeleteForumListener(new y(this));
        }
    }

    public static void startActivityForResult(Activity activity, int i2, PersonChangeData personChangeData, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65617, null, activity, i2, personChangeData, bool) == null) {
            Intent intent = new Intent(activity, PersonChangeActivity.class);
            intent.putExtra("data", personChangeData);
            intent.putExtra("isFromPersonInfo", bool);
            activity.startActivityForResult(intent, i2);
        }
    }

    private void updateNickName(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65618, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.isUpdateNickName = true;
        this.mModel.A().setPhotoChanged(true);
        this.mModel.A().setNameShow(str);
        this.mModel.A().setNickNameLeftDays(90);
        this.mNickNameShow.setText(str);
        setNicknameMore();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.isCompleteLocalInfo) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
            } else {
                super.closeAnimation();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.isCompleteLocalInfo) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
            } else {
                super.enterExitAnimation();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 != -1) {
                if (i3 == 0 && i2 == 12010) {
                    SelectImageHelper.takePhoto(getPageContext());
                }
            } else if (i2 == 1001) {
                if (intent != null) {
                    long longExtra = intent.getLongExtra(PersonConstellationActivity.ACTIVITY_INTENT_BIRTHDAY, 0L);
                    int intExtra = intent.getIntExtra(PersonConstellationActivity.ACTIVITY_INTENT_SHOW_STATUS, 0);
                    if (longExtra == this.mModel.A().getBirthdayTime() && intExtra == this.mModel.A().getBirthdayShowStatus()) {
                        return;
                    }
                    this.mModel.A().setBirthdayShowStatus(intExtra);
                    this.mModel.A().setBirthdayTime(longExtra);
                    this.isEdited = true;
                    this.isUpdate = true;
                    Date date = new Date(longExtra * 1000);
                    this.mConstellationView.setText(StringHelper.dateToConstellation(date));
                    if (this.mModel.A().getBirthdayShowStatus() == 2) {
                        this.mAgeView.setText(getResources().getString(c.a.t0.y2.g.person_information_header_age, Integer.valueOf(getAgeByBirthday(date))));
                        this.mAgeView.setVisibility(0);
                    } else {
                        this.mAgeView.setVisibility(8);
                    }
                    SkinManager.setViewTextColor(this.mConstellationView, c.a.t0.y2.a.CAM_X0105);
                }
            } else if (i2 == 12002) {
                if (intent != null) {
                    if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                        getAlbumDataFromCamera(intent);
                    } else {
                        getAlbumDataFromImage(intent);
                    }
                }
            } else if (i2 == 12014) {
                this.mModel.A().setPhotoChanged(true);
                if (intent != null) {
                    this.mPhotoView.setImageBitmap(null);
                    this.mPhotoView.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                }
                this.isUpdate = true;
                if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                    SkinManager.setViewTextColor(this.mSave, c.a.t0.y2.a.navi_op_text, 1);
                } else {
                    SkinManager.setViewTextColor(this.mSave, c.a.t0.y2.a.CAM_X0302, 1);
                }
            } else if (i2 != 25067) {
                if (i2 == 12009 || i2 == 12010) {
                    this.mModel.A().setPhotoChanged(true);
                    refreshHead();
                    this.isUpdate = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        SkinManager.setViewTextColor(this.mSave, c.a.t0.y2.a.navi_op_text, 1);
                    } else {
                        SkinManager.setViewTextColor(this.mSave, c.a.t0.y2.a.CAM_X0302, 1);
                    }
                }
            } else if (intent != null) {
                ArrayList<SelectForumData> parcelableArrayListExtra = intent.getParcelableArrayListExtra(SelectForumConfig.KEY_SELECTED_INTEREST_FORUMS_RESPONSE);
                PersonChangeModel personChangeModel = this.mModel;
                if (personChangeModel == null || personChangeModel.A() == null) {
                    return;
                }
                this.isUpdate = true;
                this.mModel.A().setInterestForums(parcelableArrayListExtra);
                this.mInterestForumTagLayout.bindForums(this.mModel.A().getInterestedForums());
                refreshStartLocalTripStatus();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.mParent);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mBackIcon, c.a.t0.y2.c.icon_pure_topbar_close44_svg, c.a.t0.y2.a.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            this.mPhotoView.refresh();
            SkinManager.setViewTextColor(this.mUserNameShow, c.a.t0.y2.a.CAM_X0109);
            WebPManager.setMaskDrawable(this.mPhotoCameraView, c.a.t0.y2.c.icon_mask_personalba_edit40, null);
            WebPManager.setPureDrawable(this.mCopyClientid, c.a.t0.y2.c.icon_pure_wo_recommend_copy18, c.a.t0.y2.a.CAM_X0108, null);
            TextView textView = this.mSave;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, c.a.t0.y2.a.CAM_X0302, 1);
            }
            c.a.s0.s.u.c.d(this.mClientid).v(c.a.t0.y2.a.CAM_X0108);
            c.a.s0.s.u.c.d(this.mClientidShow).v(c.a.t0.y2.a.CAM_X0108);
            c.a.s0.s.u.c.d(this.tvForumAbs).v(c.a.t0.y2.a.CAM_X0109);
            c.a.s0.s.u.c.d(this.tvForumAge).v(c.a.t0.y2.a.CAM_X0109);
            c.a.s0.s.u.c.d(this.mAlaIdNameView).v(c.a.t0.y2.a.CAM_X0109);
            c.a.s0.s.u.c.d(this.mAlaIdView).v(c.a.t0.y2.a.CAM_X0109);
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.mLocalCityTitle);
            d2.A(c.a.t0.y2.g.F_X02);
            d2.v(c.a.t0.y2.a.CAM_X0105);
            c.a.s0.s.u.c.d(this.mEdit).v(c.a.t0.y2.a.CAM_X0105);
            WebPManager.setPureDrawable(this.mSexArrow, c.a.t0.y2.c.icon_common_arrow16_right_n, c.a.t0.y2.a.CAM_X0109, null);
            WebPManager.setPureDrawable(this.mConstellationArrow, c.a.t0.y2.c.icon_common_arrow16_right_n, c.a.t0.y2.a.CAM_X0109, null);
            c.a.s0.s.u.c.d(this.mStartLocalHint).v(c.a.t0.y2.a.CAM_X0108);
            c.a.s0.s.u.c d3 = c.a.s0.s.u.c.d(this.mStartLocalTrip);
            d3.v(c.a.t0.y2.a.CAM_X0101);
            d3.n(c.a.t0.y2.g.J_X07);
            d3.h(c.a.t0.y2.a.CAM_X0303);
            this.mInterestForumTagLayout.onChangeSkinType(getPageContext(), i2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        PersonChangeData personChangeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            super.onClick(view);
            if (view != this.mPhotoView && view != this.mPhotoCameraView) {
                if (view == this.editLayout) {
                    saveTempNickName();
                    clickSaveEvents();
                    if (!this.isUpdate && !this.isUpdateNickName) {
                        finish();
                    }
                    if (!this.isCompleteLocalInfo) {
                        if (this.isFromPersonInfo.booleanValue()) {
                            TiebaStatic.log("c10100");
                        } else {
                            TiebaStatic.log("c10101");
                        }
                    }
                    saveProfile();
                    return;
                } else if (view == this.mSexLayout) {
                    showSexDialog();
                    return;
                } else if (view == this.mIntroClick) {
                    showEditor();
                    return;
                } else {
                    EditText editText = this.mEdit;
                    if (view == editText) {
                        editText.setFocusableInTouchMode(true);
                        this.mEdit.requestFocus();
                        ShowSoftKeyPad(this.mInputManager, this.mEdit);
                        scrollToBottom(400);
                        return;
                    } else if (view != this.mPersonNicknameLayout && view != this.mNickNameShow && view != this.mNickNameMore) {
                        if (view == this.mNameContainer) {
                            PersonChangeModel personChangeModel = this.mModel;
                            if (personChangeModel == null || personChangeModel.A() == null || StringUtils.isNull(this.mModel.A().getName())) {
                                showInputDialog(TbadkCoreApplication.getCurrentAccountInfo());
                                return;
                            }
                            return;
                        } else if (view == this.mConstellationLayout) {
                            if (this.isCompleteLocalInfo) {
                                c.a.d.f.p.n.w(this, this.mRootView);
                                getBirthdayPickerHelper().e(getBirthdaySelectListener());
                                return;
                            }
                            PersonConstellationActivity.startPersonConstellationActivity(getActivity(), this.mModel.A().getBirthdayTime(), this.mModel.A().getBirthdayShowStatus());
                            return;
                        } else if (view == this.mClientNumberMain) {
                            if (this.mClientidShow == null || this.mUserNameShow == null) {
                                return;
                            }
                            c.a.d.f.p.c.a(String.format(getResources().getString(c.a.t0.y2.g.to_share_tieba_id), TbadkCoreApplication.getCurrentAccountNameShow(), this.mClientidShow.getText().toString()));
                            new BdTopToast(this, 3000).setIcon(true).setContent(getResources().getString(c.a.t0.y2.g.copy_success)).show(this.mRootView);
                            if (this.isCompleteLocalInfo) {
                                return;
                            }
                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COPY_CLIENT_NUMBER_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_param1", this.mClientidShow.getText().toString()).param("obj_locate", 2));
                            return;
                        } else if (view == this.mInterestForumTagLayout) {
                            PersonChangeModel personChangeModel2 = this.mModel;
                            if (personChangeModel2 == null || personChangeModel2.A() == null) {
                                return;
                            }
                            SelectForumConfig selectForumConfig = new SelectForumConfig(this);
                            selectForumConfig.setSelectedInterestedForums(this.mModel.A().getInterestedForums());
                            selectForumConfig.setIsSelectInterestForum(true);
                            selectForumConfig.setRequestCode(25067);
                            selectForumConfig.setIntentAction(IntentAction.ActivityForResult);
                            selectForumConfig.start();
                            return;
                        } else if (view == this.mStartLocalTrip) {
                            c.a.t0.l1.b.a();
                            if (!this.isUpdate && !this.isUpdateNickName) {
                                finish();
                                return;
                            } else {
                                saveProfile();
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        clickChangeNickNameEvents();
                        if (Build.VERSION.SDK_INT < 19) {
                            showTopToast(getPageContext().getPageActivity().getString(c.a.t0.y2.g.support_modify_nickname), false);
                            return;
                        } else if (NickNameActivitySwitch.isOn()) {
                            showNickNameActivityDialog();
                            return;
                        } else {
                            int nickNameLeftDays = this.mModel.A().getNickNameLeftDays();
                            if (nickNameLeftDays == 0) {
                                clickChangeNickName();
                                return;
                            } else {
                                showTopToast(String.format(getPageContext().getPageActivity().getString(c.a.t0.y2.g.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)), false);
                                return;
                            }
                        }
                    }
                }
            }
            PersonChangeModel personChangeModel3 = this.mModel;
            if (personChangeModel3 != null && (personChangeData = personChangeModel3.f49003e) != null && !personChangeData.canModifyAvatar()) {
                if (!StringUtils.isNull(this.mModel.f49003e.getCantModifyAvatarDesc())) {
                    c.a.d.f.p.n.J(TbadkCoreApplication.getInst(), this.mModel.f49003e.getCantModifyAvatarDesc());
                    return;
                } else {
                    c.a.d.f.p.n.I(TbadkCoreApplication.getInst(), c.a.t0.y2.g.person_cant_edit_avatar_default_tip);
                    return;
                }
            }
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                return;
            }
            showHeadDialog();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            if (bundle != null) {
                this.isCompleteLocalInfo = bundle.getBoolean(PersonChangeActivityConfig.IS_COMPLETE_LOCAL_INFO);
            } else if (getIntent() != null) {
                this.isCompleteLocalInfo = getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_COMPLETE_LOCAL_INFO, false);
            }
            super.onCreate(bundle);
            setContentView(c.a.t0.y2.e.person_change_activity);
            adjustResizeForSoftInput();
            this.mInputManager = (InputMethodManager) getSystemService("input_method");
            InitUI();
            InitData(bundle);
            if (bundle != null) {
                this.isFromPersonInfo = Boolean.valueOf(bundle.getBoolean("isFromPersonInfo"));
            } else {
                this.isFromPersonInfo = Boolean.valueOf(getIntent().getBooleanExtra("isFromPersonInfo", false));
            }
            if (!this.isCompleteLocalInfo) {
                TiebaStatic.log("c12204");
            } else {
                c.a.t0.l1.b.b();
            }
            registerListener(this.mModifyNicknameSucceedListener);
            registerListener(this.mChangeLeftDayListener);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.mModifyNicknameSucceedListener);
            z zVar = this.mImageTask;
            if (zVar != null) {
                zVar.cancel();
            }
            a0 a0Var = this.mModifyTask;
            if (a0Var != null) {
                a0Var.cancel();
            }
            ProgressBar progressBar = this.mImageProgressBar;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            EditText editText = this.mEdit;
            if (editText != null) {
                editText.addTextChangedListener(null);
            }
            c.a.s0.t.i.b bVar = this.mInputUserNameDialog;
            if (bVar != null) {
                bVar.s();
            }
            if (this.mGlobalLayoutListener != null && (viewGroup = this.mRootView) != null) {
                viewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            }
            c.a.d.f.m.e.a().removeCallbacks(this.mStartLocalTripShowRunnable);
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i2, keyEvent)) == null) {
            if (isLoadingViewAttached() || isNetRefreshViewAttached()) {
                return super.onKeyDown(i2, keyEvent);
            }
            if (i2 == 4) {
                hideEditor();
                this.mBackClickListener.onClick(null);
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView);
            PersonChangeModel personChangeModel = this.mModel;
            if (personChangeModel != null) {
                personChangeModel.loadData();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            if (!this.mHasModifyNickName || TextUtils.isEmpty(this.mTempNickName)) {
                return;
            }
            updateNickName(this.mTempNickName);
            this.mHasModifyNickName = false;
            this.mTempNickName = "";
            refreshStartLocalTripStatus();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (this.mModel.A() != null) {
                bundle.putString("data", OrmObject.jsonStrWithObject(this.mModel.A()));
            }
        }
    }

    public void showHeadDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            String[] strArr = {getPageContext().getString(c.a.t0.y2.g.change_photo), getPageContext().getString(c.a.t0.y2.g.change_system_photo)};
            c.a.s0.s.s.c cVar = new c.a.s0.s.s.c(getPageContext().getPageActivity());
            cVar.k(c.a.t0.y2.g.operation);
            cVar.j(strArr, new l(this));
            cVar.c(getPageContext());
            cVar.m();
        }
    }

    public void showTopToast(String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, str, z2) == null) {
            new BdTopToast(this).setIcon(z2).setContent(str).show((ViewGroup) findViewById(16908290));
        }
    }

    public void showTopToast(int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            showTopToast(getString(i2), z2);
        }
    }
}
