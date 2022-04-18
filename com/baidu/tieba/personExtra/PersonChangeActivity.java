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
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.EditNickNameActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
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
import com.baidu.tieba.R;
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
import com.repackage.c35;
import com.repackage.cm8;
import com.repackage.cr4;
import com.repackage.di;
import com.repackage.dr7;
import com.repackage.er4;
import com.repackage.fd5;
import com.repackage.fo;
import com.repackage.h35;
import com.repackage.lr4;
import com.repackage.mi;
import com.repackage.mt6;
import com.repackage.ni;
import com.repackage.nr4;
import com.repackage.nt6;
import com.repackage.oi;
import com.repackage.pg;
import com.repackage.vr4;
import com.repackage.vt4;
import com.repackage.wy4;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
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
    public mt6 mBirthdayPickerHelper;
    public CustomMessageListener mChangeLeftDayListener;
    public boolean mClickOnEditor;
    public LinearLayout mClientNumberMain;
    public TextView mClientid;
    public TextView mClientidShow;
    public View mCloseView;
    public cr4 mConfirmDialog;
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
    public wy4 mInputUserNameDialog;
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
    public cr4 mNickNameActivityDialog;
    public ImageView mNickNameMore;
    public EditText mNickNameShow;
    public LinearLayout mParent;
    public PermissionJudgePolicy mPermissionJudgement;
    public ManualObservableScrollView mPersonChangeScroll;
    public View mPersonNicknameLayout;
    public fo mPhoto;
    public ImageView mPhotoCameraView;
    public FrameLayout mPhotoParent;
    public HeadImageView mPhotoView;
    public int mPreviousRootHeight;
    public ViewGroup mRootView;
    public TextView mSave;
    public int mSex;
    public ImageView mSexArrow;
    public lr4 mSexDialog;
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

    /* loaded from: classes3.dex */
    public class a implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public a(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) || z) {
                return;
            }
            this.a.mNickNameShow.setFocusableInTouchMode(false);
        }
    }

    /* loaded from: classes3.dex */
    public class a0 extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public PersonChangeModel b;
        public final /* synthetic */ PersonChangeActivity c;

        public a0(PersonChangeActivity personChangeActivity, PersonChangeModel personChangeModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity, personChangeModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = personChangeActivity;
            this.a = null;
            this.b = null;
            this.b = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.mModifyTask = null;
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
                PersonChangeActivity personChangeActivity = this.c;
                personChangeActivity.showLoadingDialog(personChangeActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f1071), this.c.mDialogCancelListener);
                super.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                if (this.b == null) {
                    return null;
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.a = netWork;
                netWork.addPostData("sex", String.valueOf(this.b.C().getSex()));
                this.a.addPostData("intro", this.b.C().getIntro());
                this.a.addPostData("birthday_time", String.valueOf(this.b.C().getBirthdayTime()));
                this.a.addPostData("birthday_show_status", String.valueOf(this.b.C().getBirthdayShowStatus()));
                if (UbsABTestHelper.isNickNameABTest()) {
                    this.a.addPostData("need_keep_nickname_flag", "0");
                    this.a.addPostData(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
                    this.a.addPostData("is_business_account", this.b.C().getIsBusinessAccount());
                    if (!TextUtils.isEmpty(this.b.C().getTempNickName())) {
                        this.a.addPostData("nick_name", this.b.C().getTempNickName());
                    }
                } else {
                    this.a.addPostData("need_keep_nickname_flag", "1");
                }
                if (this.c.isCompleteLocalInfo) {
                    this.a.addPostData("do_from", "local_user_profile");
                    this.a.addPostData("forum_data", this.b.C().getInterestedForumsJsonString());
                }
                this.a.postMultiNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    cm8.j();
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
                this.c.mModifyTask = null;
                this.c.closeLoadingDialog();
                NetWork netWork = this.a;
                if (netWork != null) {
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        this.c.setDataAndFinish();
                        this.c.showSuccessToast();
                    } else {
                        this.c.showTopToast(this.a.getErrorString(), false);
                    }
                }
                super.onPostExecute((a0) str);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                if (i == 6) {
                    this.a.mNickNameShow.setFocusableInTouchMode(false);
                    this.a.mNickNameShow.setCursorVisible(false);
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public c(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.refreshStartLocalTripStatus();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public d(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) || z) {
                return;
            }
            this.a.mEdit.setFocusableInTouchMode(false);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public e(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.a.mModel.C() == null || editable.toString().replaceAll("\\s*", "").equals(this.a.mModel.C().getIntro())) {
                return;
            }
            this.a.isUpdate = true;
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                SkinManager.setViewTextColor(this.a.mSave, R.color.navi_op_text, 1);
            } else {
                SkinManager.setViewTextColor(this.a.mSave, R.color.CAM_X0302, 1);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                Editable text = this.a.mEdit.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                this.a.mIntroTextTipNum.setText(String.valueOf(length));
                this.a.mIntroTextTip.setVisibility(0);
                this.a.showIntroTextTip();
                if (length > 500) {
                    this.a.showTopToast(R.string.obfuscated_res_0x7f0f0cf0, false);
                    if (this.a.mEdit.getSelectionStart() - 1 < 0 || this.a.mEdit.getSelectionStart() - 1 > this.a.mEdit.getSelectionEnd()) {
                        this.a.mEdit.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(this.a.mEdit.getSelectionStart() - 1, this.a.mEdit.getSelectionEnd());
                        this.a.mEdit.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd > length2) {
                        selectionEnd = length2;
                    }
                    Selection.setSelection(this.a.mEdit.getText(), selectionEnd);
                }
                this.a.refreshStartLocalTripStatus();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public f(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
                this.a.clickSaveEvents();
                this.a.saveProfile();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public g(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
                if (this.a.mModel.C().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (!this.a.isFromPersonInfo.booleanValue()) {
                        intent.putExtra("data", this.a.mModel.C());
                    } else {
                        intent.putExtra("person_change_data", this.a.mModel.C());
                    }
                    this.a.setResult(-1, intent);
                    this.a.sendUpdateMessage();
                }
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public h(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.mPersonChangeScroll.scrollTo(0, 0);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // com.baidu.tieba.widget.ManualObservableScrollView.a
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
                PersonChangeActivity personChangeActivity = this.a;
                oi.w(personChangeActivity, personChangeActivity.mRootView);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public j(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int height = this.a.mRootView.getHeight();
                if (this.a.mPreviousRootHeight != 0 && this.a.mPreviousRootHeight != height) {
                    if (height > this.a.mPreviousRootHeight) {
                        pg.a().postDelayed(this.a.mStartLocalTripShowRunnable, 200L);
                    } else if (this.a.mStartLocalTripLayout != null) {
                        this.a.mStartLocalTripLayout.setVisibility(8);
                    }
                }
                this.a.mPreviousRootHeight = height;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public k(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.mStartLocalTripLayout == null) {
                return;
            }
            this.a.mStartLocalTripLayout.setVisibility(0);
        }
    }

    /* loaded from: classes3.dex */
    public class l implements er4.c {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // com.repackage.er4.c
        public void a(er4 er4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, er4Var, i, view2) == null) {
                if (i == 0) {
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.a.getPageContext().getPageActivity(), this.a.mWriteImagesInfo.toJsonString(), true);
                    albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                    albumActivityConfig.setResourceType(2);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                } else if (i == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.a.getPageContext().getPageActivity(), 12014)));
                }
                er4Var.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PersonChangeActivity c;

        public m(PersonChangeActivity personChangeActivity, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = personChangeActivity;
            this.a = str;
            this.b = str2;
        }

        @Override // com.repackage.nr4.e
        public void onItemClick(nr4 nr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nr4Var, i, view2) == null) {
                if (this.c.mSexDialog != null && this.c.mSexDialog.isShowing()) {
                    this.c.mSexDialog.dismiss();
                }
                if (view2 instanceof TextView) {
                    TextView textView = (TextView) view2;
                    if (this.a.equals(textView.getText().toString())) {
                        this.c.mSex = 1;
                        this.c.mSexShow.setText(this.a);
                    } else if (this.b.equals(textView.getText().toString())) {
                        this.c.mSex = 2;
                        this.c.mSexShow.setText(this.b);
                    }
                    SkinManager.setViewTextColor(this.c.mSexShow, (int) R.color.CAM_X0105);
                    if (this.c.mSex != this.c.mModel.C().getSex()) {
                        this.c.isUpdate = true;
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            SkinManager.setViewTextColor(this.c.mSave, R.color.navi_op_text, 1);
                        } else {
                            SkinManager.setViewTextColor(this.c.mSave, R.color.CAM_X0302, 1);
                        }
                    }
                    this.c.refreshStartLocalTripStatus();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public n(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.mModel.C().getSex() != this.a.mSex) {
                    this.a.isEdited = true;
                }
                this.a.saveTempNickName();
                if (this.a.isCompleteLocalInfo || (!this.a.isEdited && !this.a.isUpdateNickName)) {
                    if (this.a.mModel != null && this.a.mModel.C().getPhotoChanged()) {
                        Intent intent = new Intent();
                        if (this.a.isFromPersonInfo.booleanValue()) {
                            intent.putExtra("person_change_data", this.a.mModel.C());
                        } else {
                            intent.putExtra("data", this.a.mModel.C());
                        }
                        this.a.sendUpdateMessage();
                        this.a.setResult(-1, intent);
                    }
                    this.a.finish();
                    return;
                }
                this.a.mConfirmDialog.show();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public o(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity currentActivity;
            String string;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || currentActivity.findViewById(16908290) == null) {
                return;
            }
            if (this.a.isCompleteLocalInfo) {
                string = currentActivity.getString(R.string.obfuscated_res_0x7f0f0414);
            } else {
                string = currentActivity.getString(R.string.obfuscated_res_0x7f0f0390);
            }
            BdTopToast bdTopToast = new BdTopToast(currentActivity);
            bdTopToast.i(true);
            bdTopToast.h(string);
            bdTopToast.j((ViewGroup) currentActivity.findViewById(16908290));
        }
    }

    /* loaded from: classes3.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(PersonChangeActivity personChangeActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity, Integer.valueOf(i)};
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

    /* loaded from: classes3.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(PersonChangeActivity personChangeActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity, Integer.valueOf(i)};
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
            this.a = personChangeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (this.a.mModel == null || this.a.mModel.C() == null || personChangeData == null) {
                    return;
                }
                this.a.mModel.C().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                this.a.mModel.C().setMem(personChangeData.getMen());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r implements mt6.c {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // com.repackage.mt6.c
        public void a(Date date, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, date, j) == null) {
                this.a.mModel.C().setBirthdayTime(j);
                this.a.mConstellationView.setText(StringHelper.dateToConstellation(date));
                this.a.mAgeView.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e19, Integer.valueOf(PersonChangeActivity.getAgeByBirthday(date))));
                this.a.mAgeView.setVisibility(0);
                SkinManager.setViewTextColor(this.a.mConstellationView, (int) R.color.CAM_X0105);
                this.a.refreshStartLocalTripStatus();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public s(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.getPageContext().getPageActivity(), null, dr7.a(), true)));
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public t(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u implements wy4.e {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // com.repackage.wy4.e
        public void a(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, accountData) == null) || accountData == null) {
                return;
            }
            this.a.resetUserName(accountData.getAccount());
        }
    }

    /* loaded from: classes3.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public v(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.mPersonChangeScroll.fullScroll(130);
                this.a.mEdit.setFocusableInTouchMode(true);
                this.a.mEdit.requestFocus();
                PersonChangeActivity personChangeActivity = this.a;
                personChangeActivity.ShowSoftKeyPad(personChangeActivity.mInputManager, this.a.mEdit);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public w(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personChangeActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.destroyWaitingDialog();
                if (this.a.mModifyTask != null) {
                    this.a.mModifyTask.cancel();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                    this.a.mPhoto = new fo(bitmap, false, (String) null);
                    this.a.mPhoto.h(this.a.mPhotoView);
                    h35.k().c(this.a.mModel.C().getPortrait(), this.a.mPhoto, true);
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
                this.mModel.D(new x(this));
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
            this.mPhotoCameraView = (ImageView) findViewById(R.id.obfuscated_res_0x7f09182c);
            this.mRootView = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09136b);
            this.mPhotoCameraView.setOnClickListener(this);
            HeadImageView headImageView = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f091824);
            this.mPhotoView = headImageView;
            headImageView.setOnClickListener(this);
            this.mParent = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091642);
            this.mPersonChangeScroll = (ManualObservableScrollView) findViewById(R.id.obfuscated_res_0x7f09179e);
            this.mSexLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0917f8);
            this.mSexShow = (TextView) findViewById(R.id.obfuscated_res_0x7f091c9e);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923ac);
            this.mNavigationBar = navigationBar;
            View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d08c5, this.mBackClickListener);
            this.mCloseView = addCustomView;
            ImageView imageView = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f09244b);
            this.mBackIcon = imageView;
            imageView.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f03e8));
            this.mForumAgeLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090a22);
            this.tvForumAbs = (TextView) findViewById(R.id.obfuscated_res_0x7f092192);
            this.tvForumAge = (TextView) findViewById(R.id.obfuscated_res_0x7f092193);
            this.mSexLayout.setOnClickListener(this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090f43);
            this.mIntroClick = linearLayout;
            linearLayout.setOnClickListener(this);
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f091571);
            this.mNickNameShow = editText;
            editText.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            this.mNickNameShow.setOnClickListener(this);
            this.mLocalCityTitle = (EMTextView) findViewById(R.id.obfuscated_res_0x7f091313);
            this.mPhotoParent = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09182b);
            this.mSexTitle = (TextView) findViewById(R.id.obfuscated_res_0x7f091c9f);
            this.mSexArrow = (ImageView) findViewById(R.id.obfuscated_res_0x7f091c9c);
            this.mInterestForumTagLayout = (InterestForumTagLayout) findViewById(R.id.obfuscated_res_0x7f090f13);
            this.mStartLocalTripLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091d8d);
            this.mStartLocalHint = (TextView) findViewById(R.id.obfuscated_res_0x7f091d8c);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091d8e);
            this.mStartLocalTrip = textView;
            textView.setOnClickListener(this);
            this.mIntroLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090f45);
            this.mNickName = (TextView) findViewById(R.id.obfuscated_res_0x7f091570);
            if (UbsABTestHelper.isNickNameABTest()) {
                this.mNickNameShow.setOnFocusChangeListener(new a(this));
                this.mNickNameShow.setOnEditorActionListener(new b(this));
                this.mNickNameShow.addTextChangedListener(new c(this));
            } else {
                this.mNickNameShow.setFocusableInTouchMode(false);
                this.mNickNameShow.setCursorVisible(false);
            }
            this.mClientid = (TextView) findViewById(R.id.obfuscated_res_0x7f0917a3);
            this.mClientNumberMain = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0917a2);
            this.mClientidShow = (TextView) findViewById(R.id.obfuscated_res_0x7f0917fa);
            this.mCopyClientid = (ImageView) findViewById(R.id.obfuscated_res_0x7f0917a1);
            this.mClientNumberMain.setOnClickListener(this);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0917f6);
            this.mPersonNicknameLayout = findViewById;
            findViewById.setOnClickListener(this);
            ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f091573);
            this.mNickNameMore = imageView2;
            imageView2.setOnClickListener(this);
            this.mUserNameShow = (TextView) findViewById(R.id.obfuscated_res_0x7f0922a1);
            this.mNameContainer = findViewById(R.id.obfuscated_res_0x7f0917f0);
            this.mUserNameMoreIcon = findViewById(R.id.obfuscated_res_0x7f0922a0);
            this.mNameContainer.setOnClickListener(this);
            this.mIntroTextTip = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090f47);
            this.mIntroTextTipNum = (TextView) findViewById(R.id.obfuscated_res_0x7f090f4a);
            this.mIntroTextTipDivider = (TextView) findViewById(R.id.obfuscated_res_0x7f090f48);
            this.mIntroTextTipLimit = (TextView) findViewById(R.id.obfuscated_res_0x7f090f49);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f090f42);
            this.mIntro = textView2;
            textView2.setVisibility(8);
            EditText editText2 = (EditText) findViewById(R.id.obfuscated_res_0x7f090851);
            this.mEdit = editText2;
            editText2.setHint(getResources().getString(R.string.obfuscated_res_0x7f0f0e01, "o(〃'▽'〃)o"));
            this.mEdit.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            this.mIntroTextTip.setVisibility(0);
            this.mEdit.setOnClickListener(this);
            this.mEdit.setOnFocusChangeListener(new d(this));
            this.mEdit.addTextChangedListener(new e(this));
            this.mImageProgressBar = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f090e7d);
            cr4 cr4Var = new cr4(getPageContext().getPageActivity());
            this.mConfirmDialog = cr4Var;
            cr4Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f0426));
            this.mConfirmDialog.setPositiveButton(getPageContext().getString(R.string.obfuscated_res_0x7f0f025d), new f(this));
            this.mConfirmDialog.setNegativeButton(getPageContext().getString(R.string.obfuscated_res_0x7f0f036e), new g(this));
            this.mConfirmDialog.create(getPageContext());
            this.mAlaIdLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09176f);
            this.mAlaIdView = (TextView) findViewById(R.id.obfuscated_res_0x7f091771);
            this.mAlaIdNameView = (TextView) findViewById(R.id.obfuscated_res_0x7f091770);
            this.mForumAgeView = (TextView) findViewById(R.id.obfuscated_res_0x7f0917ad);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0917a4);
            this.mConstellationLayout = relativeLayout;
            relativeLayout.setOnClickListener(this);
            this.mConstellation = (TextView) findViewById(R.id.obfuscated_res_0x7f0906d0);
            this.mConstellationView = (TextView) findViewById(R.id.obfuscated_res_0x7f0906d1);
            this.mConstellationArrow = (ImageView) findViewById(R.id.obfuscated_res_0x7f0906cd);
            this.mAgeView = (TextView) findViewById(R.id.obfuscated_res_0x7f090154);
            this.mPersonChangeScroll.post(new h(this));
            this.mPersonChangeScroll.setScrollChangedListener(new i(this));
            registerKeyboardEvent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindData() {
        PersonChangeModel personChangeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65587, this) == null) || (personChangeModel = this.mModel) == null || personChangeModel.C() == null) {
            return;
        }
        setNicknameMore();
        this.mPhotoView.K(HeadIconRefreshHelper.headPortraitFilter(this.mModel.C().getPortrait()), 25, false);
        this.mNickNameShow.setText(this.mModel.C().getNameShow());
        PersonChangeModel personChangeModel2 = this.mModel;
        if (personChangeModel2 != null && personChangeModel2.C() != null && !TextUtils.isEmpty(this.mModel.C().getmTiebaId())) {
            this.mClientidShow.setText(this.mModel.C().getmTiebaId());
        } else {
            this.mClientNumberMain.setVisibility(8);
        }
        if (StringUtils.isNull(this.mModel.C().getName())) {
            this.mUserNameShow.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f13d9));
            this.hasUserName = false;
            this.mNameContainer.setClickable(true);
            this.mUserNameMoreIcon.setVisibility(0);
        } else {
            this.mUserNameShow.setText(this.mModel.C().getName());
            this.hasUserName = true;
            this.mNameContainer.setClickable(false);
            this.mUserNameMoreIcon.setVisibility(8);
        }
        if (this.mModel.C().getIntro() != null && this.mModel.C().getIntro().length() > 0) {
            this.mIntro.setText(this.mModel.C().getIntro());
        } else {
            this.mIntro.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f00ca));
        }
        if (!ni.isEmpty(this.mModel.C().getIntro())) {
            this.mEdit.setText(this.mModel.C().getIntro());
            TextView textView = this.mIntroTextTipNum;
            textView.setText(this.mModel.C().getIntro().length() + "");
        } else {
            this.mIntroTextTipNum.setText("0");
        }
        if (this.mModel.C().getSex() == 1) {
            this.mSex = 1;
            this.mSexShow.setText(R.string.obfuscated_res_0x7f0f0a76);
        } else if (this.mModel.C().getSex() == 2) {
            this.mSex = 2;
            this.mSexShow.setText(R.string.obfuscated_res_0x7f0f05f9);
        } else {
            SkinManager.setViewTextColor(this.mSexShow, (int) R.color.CAM_X0110);
            this.mSexShow.setText(R.string.obfuscated_res_0x7f0f0393);
        }
        if (this.mModel.C().getAlaId() > 0) {
            this.mAlaIdLayout.setVisibility(0);
            TextView textView2 = this.mAlaIdView;
            textView2.setText(this.mModel.C().getAlaId() + "");
        }
        this.mForumAgeView.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0e08, this.mModel.C().getForumAge()));
        if (this.mModel.C().getBirthdayTime() != 0) {
            this.mConstellationView.setText(StringHelper.dateToConstellation(new Date(this.mModel.C().getBirthdayTime() * 1000)));
        }
        if (this.mModel.C().getBirthdayTime() != 0 && this.mModel.C().getUserAge() > 0 && (this.mModel.C().getBirthdayShowStatus() == 2 || this.isCompleteLocalInfo)) {
            this.mAgeView.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0e19, Integer.valueOf(this.mModel.C().getUserAge())));
            this.mAgeView.setVisibility(0);
        } else {
            this.mAgeView.setVisibility(8);
        }
        if (this.mModel.C().getBirthdayTime() == 0 && this.mAgeView.getVisibility() == 8) {
            this.mConstellationView.setText(getString(R.string.obfuscated_res_0x7f0f038d));
            SkinManager.setViewTextColor(this.mConstellationView, (int) R.color.CAM_X0110);
        }
        if (this.isCompleteLocalInfo) {
            this.mInterestForumTagLayout.h(getPageContext(), null, false);
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
            if (str == null || str.equals(this.mModel.C().getNameShow())) {
                return true;
            }
            return fd5.b(this.mTempNickName) <= 20 && fd5.b(this.mTempNickName) >= 2;
        }
        return invokeV.booleanValue;
    }

    private void clickChangeNickName() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65589, this) == null) {
            if (UbsABTestHelper.isNickNameABTest()) {
                vt4.k().u("key_has_show_nick_name_red_icon_tip", true);
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
        statisticItem.param("obj_param1", !obj.equals(this.mModel.C().getNameShow()));
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, !this.mEdit.toString().replaceAll("\\s*", "").equals(this.mModel.C().getIntro()));
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

    private mt6 getBirthdayPickerHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65595, this)) == null) {
            if (this.mBirthdayPickerHelper == null) {
                this.mBirthdayPickerHelper = new mt6(this);
            }
            return this.mBirthdayPickerHelper;
        }
        return (mt6) invokeV.objValue;
    }

    private mt6.c getBirthdaySelectListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65596, this)) == null) ? new r(this) : (mt6.c) invokeV.objValue;
    }

    private void hideEditor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65597, this) == null) {
            if (this.mEdit.getVisibility() == 0 && this.mEdit.isFocused()) {
                String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
                if (replaceAll.length() > 0) {
                    this.mIntro.setText(replaceAll);
                } else {
                    this.mIntro.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f00ca));
                }
                if (this.mModel.C().getIntro() == null || !this.mModel.C().getIntro().equals(replaceAll)) {
                    this.isEdited = true;
                }
                this.mModel.C().setIntro(replaceAll);
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
        this.mStartLocalTrip.setEnabled((!(personChangeModel.A() && this.mSex != 0) || this.mEdit.getText() == null || TextUtils.isEmpty(this.mEdit.getText().toString().trim())) ? false : false);
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
        if (!(interceptable == null || interceptable.invokeV(65602, this) == null) || (personChangeModel = this.mModel) == null || personChangeModel.C() == null) {
            return;
        }
        hideEditor();
        if (UbsABTestHelper.isNickNameABTest() && !checkTempNickName()) {
            showTopToast(R.string.obfuscated_res_0x7f0f0e22, false);
        } else if (!mi.z()) {
            showTopToast(R.string.obfuscated_res_0x7f0f0c17, false);
        } else {
            this.mModel.C().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.mModel.C().setSex(this.mSex);
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
            this.mModel.C().setTempNickName(this.mTempNickName);
            this.isUpdateNickName = !this.mTempNickName.equals(this.mModel.C().getNameShow());
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
        if (!(interceptable == null || interceptable.invokeV(65605, this) == null) || (personChangeModel = this.mModel) == null || personChangeModel.C() == null) {
            return;
        }
        c35.d().h();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.mModel.C()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataAndFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65606, this) == null) {
            if (!this.isCompleteLocalInfo) {
                Intent intent = new Intent();
                if (this.isFromPersonInfo.booleanValue()) {
                    intent.putExtra("person_change_data", this.mModel.C());
                } else {
                    intent.putExtra("data", this.mModel.C());
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
            if (UbsABTestHelper.isNickNameABTest()) {
                layoutParams.width = UtilHelper.getDimenPixelSize(R.dimen.tbds21);
                layoutParams.height = UtilHelper.getDimenPixelSize(R.dimen.tbds21);
                this.mNickNameMore.setImageResource(R.drawable.obfuscated_res_0x7f080655);
                if (this.mModel.C().getNickNameLeftDays() == 0 && !vt4.k().h("key_has_show_nick_name_red_icon_tip", false)) {
                    this.mNickNameMore.setVisibility(0);
                } else {
                    this.mNickNameMore.setVisibility(4);
                }
            } else {
                layoutParams.width = -2;
                layoutParams.height = -2;
                this.mNickNameMore.setImageResource(R.drawable.icon_arrow_more_gray);
                if (!NickNameActivitySwitch.isOn() && this.mModel.C().getNickNameLeftDays() != 0) {
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
            String string = getResources().getString(R.string.obfuscated_res_0x7f0f0b2f);
            if (this.isCompleteLocalInfo) {
                string = getString(R.string.obfuscated_res_0x7f0f0a38);
            }
            this.mNavigationBar.setCenterTextTitle(string);
            if (this.isCompleteLocalInfo) {
                return;
            }
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d05e6, (View.OnClickListener) null);
            this.editLayout = addCustomView;
            TextView textView = (TextView) addCustomView.findViewById(R.id.obfuscated_res_0x7f091aa9);
            this.mSave = textView;
            textView.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f1064));
            SkinManager.setViewTextColor(this.mSave, R.color.navi_op_text, 1);
            this.editLayout.setOnClickListener(this);
        }
    }

    private void showEditor() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65610, this) == null) || this.mEdit.getVisibility() == 0) {
            return;
        }
        this.mIntro.setVisibility(8);
        this.mEdit.setText(this.mModel.C().getIntro());
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
                wy4 wy4Var = new wy4(this);
                this.mInputUserNameDialog = wy4Var;
                wy4Var.w(new u(this));
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
                color = SkinManager.getColor(R.color.common_color_10159);
            } else {
                color = SkinManager.getColor(R.color.common_color_10077);
            }
            setIntroTextTipStyle(color);
        }
    }

    private void showNickNameActivityDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65613, this) == null) {
            if (this.mNickNameActivityDialog == null) {
                View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06cb, (ViewGroup) null);
                cr4 cr4Var = new cr4(getPageContext().getPageActivity());
                this.mNickNameActivityDialog = cr4Var;
                cr4Var.setContentView(inflate);
                this.mNickNameActivityDialog.setPositiveButton(R.string.obfuscated_res_0x7f0f0c26, new s(this));
                this.mNickNameActivityDialog.setNegativeButton(R.string.obfuscated_res_0x7f0f0c25, new t(this));
                this.mNickNameActivityDialog.create(getPageContext());
                SkinManager.setViewTextColor(inflate.findViewById(R.id.obfuscated_res_0x7f091575), (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(inflate.findViewById(R.id.obfuscated_res_0x7f091574), (int) R.color.common_color_10122);
            }
            this.mNickNameActivityDialog.show();
        }
    }

    private void showSexDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65614, this) == null) {
            if (this.mSexDialog == null) {
                this.mSexDialog = new lr4(getPageContext());
                String string = getPageContext().getString(R.string.obfuscated_res_0x7f0f0a76);
                String string2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f05f9);
                this.mSexDialog.j(getString(R.string.obfuscated_res_0x7f0f03c3), new String[]{string, string2}, new m(this, string, string2));
            }
            this.mSexDialog.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSuccessToast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65615, this) == null) {
            pg.a().postDelayed(new o(this), 200L);
        }
    }

    private void showViewsForHomeLocalInfoComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65616, this) == null) {
            this.mLocalCityTitle.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPhotoParent.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, oi.f(this, R.dimen.M_H_X009), layoutParams.rightMargin, layoutParams.bottomMargin);
            this.mNameContainer.setVisibility(8);
            this.mClientNumberMain.setVisibility(8);
            this.mAlaIdLayout.setVisibility(8);
            this.mForumAgeLayout.setVisibility(8);
            this.mInterestForumTagLayout.setVisibility(0);
            this.mStartLocalTripLayout.setVisibility(0);
            this.mIntroLayout.setOrientation(1);
            this.mConstellation.setText(getString(R.string.obfuscated_res_0x7f0f0ddc));
            this.tvForumAbs.setText(getString(R.string.obfuscated_res_0x7f0f0a72));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mEdit.getLayoutParams();
            layoutParams2.setMargins(0, oi.f(this, R.dimen.tbds18), 0, 0);
            layoutParams2.height = oi.f(this, R.dimen.tbds229);
            this.mEdit.setGravity(51);
            this.mEdit.setHint(getString(R.string.obfuscated_res_0x7f0f0a39));
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080928, SkinManager.getColor(R.color.CAM_X0301), null);
            if (pureDrawable != null) {
                this.mNickName.setCompoundDrawablePadding(oi.f(this, R.dimen.M_W_X002));
                this.mNickName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
                this.mSexTitle.setCompoundDrawablePadding(oi.f(this, R.dimen.M_W_X002));
                this.mSexTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
                this.mConstellation.setCompoundDrawablePadding(oi.f(this, R.dimen.M_W_X002));
                this.mConstellation.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
                this.tvForumAbs.setCompoundDrawablePadding(oi.f(this, R.dimen.M_W_X002));
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
        this.mModel.C().setPhotoChanged(true);
        this.mModel.C().setNameShow(str);
        this.mModel.C().setNickNameLeftDays(90);
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
                    if (longExtra == this.mModel.C().getBirthdayTime() && intExtra == this.mModel.C().getBirthdayShowStatus()) {
                        return;
                    }
                    this.mModel.C().setBirthdayShowStatus(intExtra);
                    this.mModel.C().setBirthdayTime(longExtra);
                    this.isEdited = true;
                    this.isUpdate = true;
                    Date date = new Date(longExtra * 1000);
                    this.mConstellationView.setText(StringHelper.dateToConstellation(date));
                    if (this.mModel.C().getBirthdayShowStatus() == 2) {
                        this.mAgeView.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0e19, Integer.valueOf(getAgeByBirthday(date))));
                        this.mAgeView.setVisibility(0);
                    } else {
                        this.mAgeView.setVisibility(8);
                    }
                    SkinManager.setViewTextColor(this.mConstellationView, (int) R.color.CAM_X0105);
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
                this.mModel.C().setPhotoChanged(true);
                if (intent != null) {
                    this.mPhotoView.setImageBitmap(null);
                    this.mPhotoView.K(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                }
                this.isUpdate = true;
                if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                    SkinManager.setViewTextColor(this.mSave, R.color.navi_op_text, 1);
                } else {
                    SkinManager.setViewTextColor(this.mSave, R.color.CAM_X0302, 1);
                }
            } else if (i2 != 25067) {
                if (i2 == 12009 || i2 == 12010) {
                    this.mModel.C().setPhotoChanged(true);
                    refreshHead();
                    this.isUpdate = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        SkinManager.setViewTextColor(this.mSave, R.color.navi_op_text, 1);
                    } else {
                        SkinManager.setViewTextColor(this.mSave, R.color.CAM_X0302, 1);
                    }
                }
            } else if (intent != null) {
                ArrayList<SelectForumData> parcelableArrayListExtra = intent.getParcelableArrayListExtra(SelectForumConfig.KEY_SELECTED_INTEREST_FORUMS_RESPONSE);
                PersonChangeModel personChangeModel = this.mModel;
                if (personChangeModel == null || personChangeModel.C() == null) {
                    return;
                }
                this.isUpdate = true;
                this.mModel.C().setInterestForums(parcelableArrayListExtra);
                this.mInterestForumTagLayout.i(this.mModel.C().getInterestedForums());
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
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mBackIcon, R.drawable.obfuscated_res_0x7f0809bb, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            this.mPhotoView.refresh();
            SkinManager.setViewTextColor(this.mUserNameShow, (int) R.color.CAM_X0109);
            WebPManager.setMaskDrawable(this.mPhotoCameraView, R.drawable.obfuscated_res_0x7f080808, null);
            WebPManager.setPureDrawable(this.mCopyClientid, R.drawable.obfuscated_res_0x7f0809f2, R.color.CAM_X0108, null);
            TextView textView = this.mSave;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0302, 1);
            }
            vr4.d(this.mClientid).v(R.color.CAM_X0108);
            vr4.d(this.mClientidShow).v(R.color.CAM_X0108);
            vr4.d(this.tvForumAbs).v(R.color.CAM_X0109);
            vr4.d(this.tvForumAge).v(R.color.CAM_X0109);
            vr4.d(this.mAlaIdNameView).v(R.color.CAM_X0109);
            vr4.d(this.mAlaIdView).v(R.color.CAM_X0109);
            vr4 d2 = vr4.d(this.mLocalCityTitle);
            d2.A(R.string.F_X02);
            d2.v(R.color.CAM_X0105);
            vr4.d(this.mEdit).v(R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.mSexArrow, R.drawable.icon_common_arrow16_right_n, R.color.CAM_X0109, null);
            WebPManager.setPureDrawable(this.mConstellationArrow, R.drawable.icon_common_arrow16_right_n, R.color.CAM_X0109, null);
            vr4.d(this.mStartLocalHint).v(R.color.CAM_X0108);
            vr4 d3 = vr4.d(this.mStartLocalTrip);
            d3.v(R.color.CAM_X0101);
            d3.n(R.string.J_X07);
            d3.h(R.color.CAM_X0303);
            this.mInterestForumTagLayout.onChangeSkinType(getPageContext(), i2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        PersonChangeData personChangeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            super.onClick(view2);
            if (view2 != this.mPhotoView && view2 != this.mPhotoCameraView) {
                if (view2 == this.editLayout) {
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
                } else if (view2 == this.mSexLayout) {
                    showSexDialog();
                    return;
                } else if (view2 == this.mIntroClick) {
                    showEditor();
                    return;
                } else {
                    EditText editText = this.mEdit;
                    if (view2 == editText) {
                        editText.setFocusableInTouchMode(true);
                        this.mEdit.requestFocus();
                        ShowSoftKeyPad(this.mInputManager, this.mEdit);
                        scrollToBottom(400);
                        return;
                    } else if (view2 != this.mPersonNicknameLayout && view2 != this.mNickNameShow && view2 != this.mNickNameMore) {
                        if (view2 == this.mNameContainer) {
                            PersonChangeModel personChangeModel = this.mModel;
                            if (personChangeModel == null || personChangeModel.C() == null || StringUtils.isNull(this.mModel.C().getName())) {
                                showInputDialog(TbadkCoreApplication.getCurrentAccountInfo());
                                return;
                            }
                            return;
                        } else if (view2 == this.mConstellationLayout) {
                            if (this.isCompleteLocalInfo) {
                                oi.w(this, this.mRootView);
                                getBirthdayPickerHelper().e(getBirthdaySelectListener());
                                return;
                            }
                            PersonConstellationActivity.startPersonConstellationActivity(getActivity(), this.mModel.C().getBirthdayTime(), this.mModel.C().getBirthdayShowStatus());
                            return;
                        } else if (view2 == this.mClientNumberMain) {
                            if (this.mClientidShow == null || this.mUserNameShow == null) {
                                return;
                            }
                            di.a(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f13f9), TbadkCoreApplication.getCurrentAccountNameShow(), this.mClientidShow.getText().toString()));
                            BdTopToast bdTopToast = new BdTopToast(this, 3000);
                            bdTopToast.i(true);
                            bdTopToast.h(getResources().getString(R.string.obfuscated_res_0x7f0f0440));
                            bdTopToast.j(this.mRootView);
                            if (this.isCompleteLocalInfo) {
                                return;
                            }
                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COPY_CLIENT_NUMBER_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_param1", this.mClientidShow.getText().toString()).param("obj_locate", 2));
                            return;
                        } else if (view2 == this.mInterestForumTagLayout) {
                            PersonChangeModel personChangeModel2 = this.mModel;
                            if (personChangeModel2 == null || personChangeModel2.C() == null) {
                                return;
                            }
                            SelectForumConfig selectForumConfig = new SelectForumConfig(this);
                            selectForumConfig.setSelectedInterestedForums(this.mModel.C().getInterestedForums());
                            selectForumConfig.setIsSelectInterestForum(true);
                            selectForumConfig.setRequestCode(25067);
                            selectForumConfig.setIntentAction(IntentAction.ActivityForResult);
                            selectForumConfig.start();
                            return;
                        } else if (view2 == this.mStartLocalTrip) {
                            nt6.a();
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
                            showTopToast(getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f11ff), false);
                            return;
                        } else if (NickNameActivitySwitch.isOn()) {
                            showNickNameActivityDialog();
                            return;
                        } else {
                            int nickNameLeftDays = this.mModel.C().getNickNameLeftDays();
                            if (nickNameLeftDays == 0) {
                                clickChangeNickName();
                                return;
                            } else {
                                showTopToast(String.format(getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0ac8), Integer.valueOf(nickNameLeftDays)), false);
                                return;
                            }
                        }
                    }
                }
            }
            PersonChangeModel personChangeModel3 = this.mModel;
            if (personChangeModel3 != null && (personChangeData = personChangeModel3.a) != null && !personChangeData.canModifyAvatar()) {
                if (!StringUtils.isNull(this.mModel.a.getCantModifyAvatarDesc())) {
                    oi.K(TbadkCoreApplication.getInst(), this.mModel.a.getCantModifyAvatarDesc());
                    return;
                } else {
                    oi.J(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0de6);
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
            setContentView(R.layout.obfuscated_res_0x7f0d06b7);
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
                nt6.b();
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
            wy4 wy4Var = this.mInputUserNameDialog;
            if (wy4Var != null) {
                wy4Var.s();
            }
            if (this.mGlobalLayoutListener != null && (viewGroup = this.mRootView) != null) {
                viewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            }
            pg.a().removeCallbacks(this.mStartLocalTripShowRunnable);
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
            if (this.mModel.C() != null) {
                bundle.putString("data", OrmObject.jsonStrWithObject(this.mModel.C()));
            }
        }
    }

    public void showHeadDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            String[] strArr = {getPageContext().getString(R.string.obfuscated_res_0x7f0f0392), getPageContext().getString(R.string.obfuscated_res_0x7f0f0395)};
            er4 er4Var = new er4(getPageContext().getPageActivity());
            er4Var.k(R.string.obfuscated_res_0x7f0f0cda);
            er4Var.j(strArr, new l(this));
            er4Var.c(getPageContext());
            er4Var.m();
        }
    }

    public void showTopToast(String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, str, z2) == null) {
            BdTopToast bdTopToast = new BdTopToast(this);
            bdTopToast.i(z2);
            bdTopToast.h(str);
            bdTopToast.j((ViewGroup) findViewById(16908290));
        }
    }

    public void showTopToast(int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            showTopToast(getString(i2), z2);
        }
    }
}
