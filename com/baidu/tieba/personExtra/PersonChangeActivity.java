package com.baidu.tieba.personExtra;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.d1.m0;
import b.a.q0.s.s.a;
import b.a.q0.s.s.b;
import b.a.q0.s.s.i;
import b.a.q0.t.i.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.EditNickNameActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.dialog.PopupDialog;
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
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
import java.util.Date;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_DAYS_THRESHOLD = 2000;
    public static final int FIRST_SCROLL_TO_BOTTOM_DELAY = 400;
    public static final String IS_FROM_PERSONINFO = "isFromPersonInfo";
    public static final String TAG_DATA = "data";
    public static final String TAG_PERSON_INFO = "person_change_data";
    public transient /* synthetic */ FieldHolder $fh;
    public final int DEFAULT_NICKNAME_LEFT_DAYS;
    public final int EDIT_MAX_LENGTH;
    public View editLayout;
    public boolean hasUserName;
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
    public CustomMessageListener mChangeLeftDayListener;
    public boolean mClickOnEditor;
    public LinearLayout mClientNumberMain;
    public TextView mClientid;
    public TextView mClientidShow;
    public View mCloseView;
    public b.a.q0.s.s.a mConfirmDialog;
    public RelativeLayout mConstellationLayout;
    public TextView mConstellationView;
    public ImageView mCopyClientid;
    public DialogInterface.OnCancelListener mDialogCancelListener;
    public EditText mEdit;
    public TextView mForumAgeView;
    public boolean mHasModifyNickName;
    public ProgressBar mImageProgressBar;
    public s mImageTask;
    public InputMethodManager mInputManager;
    public b.a.q0.t.i.b mInputUserNameDialog;
    public TextView mIntro;
    public LinearLayout mIntroClick;
    public LinearLayout mIntroTextTip;
    public TextView mIntroTextTipDivider;
    public TextView mIntroTextTipLimit;
    public TextView mIntroTextTipNum;
    public PersonChangeModel mModel;
    public CustomMessageListener mModifyNicknameSucceedListener;
    public t mModifyTask;
    public View mNameContainer;
    public NavigationBar mNavigationBar;
    public b.a.q0.s.s.a mNickNameActivityDialog;
    public ImageView mNickNameMore;
    public EditText mNickNameShow;
    public LinearLayout mParent;
    public PermissionJudgePolicy mPermissionJudgement;
    public ScrollView mPersonChangeScroll;
    public View mPersonNicknameLayout;
    public b.a.e.l.d.a mPhoto;
    public ImageView mPhotoCameraView;
    public HeadImageView mPhotoView;
    public View mRootView;
    public TextView mSave;
    public int mSex;
    public PopupDialog mSexDialog;
    public RelativeLayout mSexLayout;
    public TextView mSexShow;
    public String mTempNickName;
    public View mUserNameMoreIcon;
    public TextView mUserNameShow;
    public final WriteImagesInfo mWriteImagesInfo;
    public TextView tvForumAbs;
    public TextView tvForumAge;

    /* loaded from: classes9.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f53096e;

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
            this.f53096e = personChangeActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f53096e.clickSaveEvents();
                this.f53096e.saveProfile();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f53097e;

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
            this.f53097e = personChangeActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f53097e.mModel.w().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (!this.f53097e.isFromPersonInfo.booleanValue()) {
                        intent.putExtra("data", this.f53097e.mModel.w());
                    } else {
                        intent.putExtra("person_change_data", this.f53097e.mModel.w());
                    }
                    this.f53097e.setResult(-1, intent);
                    this.f53097e.sendUpdateMessage();
                }
                this.f53097e.finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f53098e;

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
            this.f53098e = personChangeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53098e.mPersonChangeScroll.scrollTo(0, 0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f53099a;

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
            this.f53099a = personChangeActivity;
        }

        @Override // b.a.q0.s.s.b.c
        public void a(b.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (i2 == 0) {
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.f53099a.getPageContext().getPageActivity(), this.f53099a.mWriteImagesInfo.toJsonString(), true);
                    albumActivityConfig.setRequestCode(12002);
                    albumActivityConfig.setResourceType(2);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                } else if (i2 == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.f53099a.getPageContext().getPageActivity(), 12014)));
                }
                bVar.e();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f53100e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f53101f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f53102g;

        public e(PersonChangeActivity personChangeActivity, String str, String str2) {
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
            this.f53102g = personChangeActivity;
            this.f53100e = str;
            this.f53101f = str2;
        }

        @Override // b.a.q0.s.s.i.e
        public void onItemClick(b.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (this.f53102g.mSexDialog != null && this.f53102g.mSexDialog.isShowing()) {
                    this.f53102g.mSexDialog.dismiss();
                }
                if (view instanceof TextView) {
                    TextView textView = (TextView) view;
                    if (this.f53100e.equals(textView.getText().toString())) {
                        this.f53102g.mSex = 1;
                        this.f53102g.mSexShow.setText(this.f53100e);
                    } else if (this.f53101f.equals(textView.getText().toString())) {
                        this.f53102g.mSex = 2;
                        this.f53102g.mSexShow.setText(this.f53101f);
                    }
                    if (this.f53102g.mSex != this.f53102g.mModel.w().getSex()) {
                        this.f53102g.isUpdate = true;
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            SkinManager.setViewTextColor(this.f53102g.mSave, R.color.navi_op_text, 1);
                        } else {
                            SkinManager.setViewTextColor(this.f53102g.mSave, R.color.CAM_X0302, 1);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f53103e;

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
            this.f53103e = personChangeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f53103e.mModel.w().getSex() != this.f53103e.mSex) {
                    this.f53103e.isEdited = true;
                }
                this.f53103e.saveTempNickName();
                if (this.f53103e.isEdited || this.f53103e.isUpdateNickName) {
                    this.f53103e.mConfirmDialog.show();
                    return;
                }
                if (this.f53103e.mModel != null && this.f53103e.mModel.w().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (this.f53103e.isFromPersonInfo.booleanValue()) {
                        intent.putExtra("person_change_data", this.f53103e.mModel.w());
                    } else {
                        intent.putExtra("data", this.f53103e.mModel.w());
                    }
                    this.f53103e.sendUpdateMessage();
                    this.f53103e.setResult(-1, intent);
                }
                this.f53103e.finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity currentActivity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || currentActivity.findViewById(16908290) == null) {
                return;
            }
            new BdTopToast(currentActivity).setIcon(true).setContent(currentActivity.getString(R.string.change_name_success)).show((ViewGroup) currentActivity.findViewById(16908290));
        }
    }

    /* loaded from: classes9.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f53104a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(PersonChangeActivity personChangeActivity, int i2) {
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
            this.f53104a = personChangeActivity;
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
                this.f53104a.mHasModifyNickName = true;
                this.f53104a.mTempNickName = str;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f53105a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(PersonChangeActivity personChangeActivity, int i2) {
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
            this.f53105a = personChangeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (this.f53105a.mModel == null || this.f53105a.mModel.w() == null || personChangeData == null) {
                    return;
                }
                this.f53105a.mModel.w().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                this.f53105a.mModel.w().setMem(personChangeData.getMen());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f53106e;

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
            this.f53106e = personChangeActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f53106e.getPageContext().getPageActivity(), null, b.a.r0.k2.c.a(), true)));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f53107e;

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
            this.f53107e = personChangeActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l implements b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f53108a;

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
            this.f53108a = personChangeActivity;
        }

        @Override // b.a.q0.t.i.b.e
        public void a(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, accountData) == null) || accountData == null) {
                return;
            }
            this.f53108a.resetUserName(accountData.getAccount());
        }
    }

    /* loaded from: classes9.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f53109e;

        public m(PersonChangeActivity personChangeActivity) {
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
            this.f53109e = personChangeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53109e.mPersonChangeScroll.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                this.f53109e.mEdit.setFocusableInTouchMode(true);
                this.f53109e.mEdit.requestFocus();
                PersonChangeActivity personChangeActivity = this.f53109e;
                personChangeActivity.ShowSoftKeyPad(personChangeActivity.mInputManager, this.f53109e.mEdit);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class n implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f53110e;

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
            this.f53110e = personChangeActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f53110e.destroyWaitingDialog();
                if (this.f53110e.mModifyTask != null) {
                    this.f53110e.mModifyTask.cancel();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f53111e;

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
            this.f53111e = personChangeActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) || z) {
                return;
            }
            this.f53111e.mNickNameShow.setFocusableInTouchMode(false);
        }
    }

    /* loaded from: classes9.dex */
    public class p implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f53112a;

        public p(PersonChangeActivity personChangeActivity) {
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
            this.f53112a = personChangeActivity;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 == 6) {
                    this.f53112a.mNickNameShow.setFocusableInTouchMode(false);
                    this.f53112a.mNickNameShow.setCursorVisible(false);
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class q implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f53113e;

        public q(PersonChangeActivity personChangeActivity) {
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
            this.f53113e = personChangeActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) || z) {
                return;
            }
            this.f53113e.mEdit.setFocusableInTouchMode(false);
        }
    }

    /* loaded from: classes9.dex */
    public class r implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f53114e;

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
            this.f53114e = personChangeActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || editable.toString().replaceAll("\\s*", "").equals(this.f53114e.mModel.w().getIntro())) {
                return;
            }
            this.f53114e.isUpdate = true;
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                SkinManager.setViewTextColor(this.f53114e.mSave, R.color.navi_op_text, 1);
            } else {
                SkinManager.setViewTextColor(this.f53114e.mSave, R.color.CAM_X0302, 1);
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
                Editable text = this.f53114e.mEdit.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                this.f53114e.mIntroTextTipNum.setText(String.valueOf(length));
                this.f53114e.mIntroTextTip.setVisibility(0);
                this.f53114e.showIntroTextTip();
                if (length > 500) {
                    this.f53114e.showTopToast(R.string.over_limit_tip, false);
                    if (this.f53114e.mEdit.getSelectionStart() - 1 < 0 || this.f53114e.mEdit.getSelectionStart() - 1 > this.f53114e.mEdit.getSelectionEnd()) {
                        this.f53114e.mEdit.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(this.f53114e.mEdit.getSelectionStart() - 1, this.f53114e.mEdit.getSelectionEnd());
                        this.f53114e.mEdit.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd > length2) {
                        selectionEnd = length2;
                    }
                    Selection.setSelection(this.f53114e.mEdit.getText(), selectionEnd);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class s extends BdAsyncTask<Object, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f53115a;

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
            this.f53115a = personChangeActivity;
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
                this.f53115a.mImageTask = null;
                this.f53115a.mImageProgressBar.setVisibility(8);
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
                this.f53115a.mImageProgressBar.setVisibility(0);
                this.f53115a.mPhotoView.setImageDrawable(null);
                this.f53115a.mPhoto = null;
                super.onPreExecute();
            }
        }

        public /* synthetic */ s(PersonChangeActivity personChangeActivity, j jVar) {
            this(personChangeActivity);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, bitmap) == null) {
                super.onPostExecute((s) bitmap);
                this.f53115a.mImageTask = null;
                this.f53115a.mImageProgressBar.setVisibility(8);
                if (bitmap != null) {
                    this.f53115a.mPhoto = new b.a.e.l.d.a(bitmap, false, (String) null);
                    this.f53115a.mPhoto.h(this.f53115a.mPhotoView);
                    b.a.q0.c0.c.k().c(this.f53115a.mModel.w().getPortrait(), this.f53115a.mPhoto, true);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class t extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f53116a;

        /* renamed from: b  reason: collision with root package name */
        public PersonChangeModel f53117b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f53118c;

        public t(PersonChangeActivity personChangeActivity, PersonChangeModel personChangeModel) {
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
            this.f53118c = personChangeActivity;
            this.f53116a = null;
            this.f53117b = null;
            this.f53117b = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53118c.mModifyTask = null;
                NetWork netWork = this.f53116a;
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
                PersonChangeActivity personChangeActivity = this.f53118c;
                personChangeActivity.showLoadingDialog(personChangeActivity.getPageContext().getString(R.string.saving), this.f53118c.mDialogCancelListener);
                super.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                if (this.f53117b == null) {
                    return null;
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.f53116a = netWork;
                netWork.addPostData("sex", String.valueOf(this.f53117b.w().getSex()));
                this.f53116a.addPostData("intro", this.f53117b.w().getIntro());
                this.f53116a.addPostData("birthday_time", String.valueOf(this.f53117b.w().getBirthdayTime()));
                this.f53116a.addPostData("birthday_show_status", String.valueOf(this.f53117b.w().getBirthdayShowStatus()));
                if (b.a.q0.b.d.E()) {
                    this.f53116a.addPostData("need_keep_nickname_flag", "0");
                    this.f53116a.addPostData(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
                    this.f53116a.addPostData("is_business_account", this.f53117b.w().getIsBusinessAccount());
                    if (!TextUtils.isEmpty(this.f53117b.w().getTempNickName())) {
                        this.f53116a.addPostData("nick_name", this.f53117b.w().getTempNickName());
                    }
                } else {
                    this.f53116a.addPostData("need_keep_nickname_flag", "1");
                }
                this.f53116a.postMultiNetData();
                if (this.f53116a.getNetContext().getResponse().isRequestSuccess()) {
                    b.a.r0.l3.p0.a.j();
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
                this.f53118c.mModifyTask = null;
                this.f53118c.closeLoadingDialog();
                NetWork netWork = this.f53116a;
                if (netWork != null) {
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        this.f53118c.setDataAndFinish();
                        PersonChangeActivity.showSuccessToast();
                    } else {
                        this.f53118c.showTopToast(this.f53116a.getErrorString(), false);
                    }
                }
                super.onPostExecute((t) str);
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
        this.mBackClickListener = new f(this);
        this.mModifyNicknameSucceedListener = new h(this, 2921033);
        this.mChangeLeftDayListener = new i(this, 2921061);
    }

    private void InitData(Bundle bundle) {
        PersonChangeData personChangeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, bundle) == null) {
            this.mDialogCancelListener = new n(this);
            if (bundle != null) {
                String string = bundle.getString("data");
                personChangeData = !StringUtils.isNull(string) ? (PersonChangeData) OrmObject.objectWithJsonStr(string, PersonChangeData.class) : null;
            } else {
                personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
            }
            if (personChangeData == null) {
                personChangeData = new PersonChangeData();
            }
            this.mModel = new PersonChangeModel(personChangeData);
        }
    }

    private void InitUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mPhotoCameraView = (ImageView) findViewById(R.id.photo_pop_icon);
            this.mRootView = findViewById(R.id.main_parent);
            this.mPhotoCameraView.setOnClickListener(this);
            HeadImageView headImageView = (HeadImageView) findViewById(R.id.photo);
            this.mPhotoView = headImageView;
            headImageView.setOnClickListener(this);
            this.mPhotoView.startLoad(HeadIconRefreshHelper.headPortraitFilter(this.mModel.w().getPortrait()), 25, false);
            this.mParent = (LinearLayout) findViewById(R.id.parent);
            this.mPersonChangeScroll = (ScrollView) findViewById(R.id.person_change_scroll);
            this.mSexLayout = (RelativeLayout) findViewById(R.id.person_sex);
            this.mSexShow = (TextView) findViewById(R.id.sex_show);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.mBackClickListener);
            this.mCloseView = addCustomView;
            ImageView imageView = (ImageView) addCustomView.findViewById(R.id.widget_navi_back_button);
            this.mBackIcon = imageView;
            imageView.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
            this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
            View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
            this.editLayout = addCustomView2;
            this.mSave = (TextView) addCustomView2.findViewById(R.id.right_textview);
            this.tvForumAbs = (TextView) findViewById(R.id.tv_forum_abs);
            this.tvForumAge = (TextView) findViewById(R.id.tv_forum_age);
            this.mSave.setText(getPageContext().getString(R.string.save));
            SkinManager.setViewTextColor(this.mSave, R.color.navi_op_text, 1);
            this.editLayout.setOnClickListener(this);
            this.mSexLayout.setOnClickListener(this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.intro_click);
            this.mIntroClick = linearLayout;
            linearLayout.setOnClickListener(this);
            EditText editText = (EditText) findViewById(R.id.nick_name_edit);
            this.mNickNameShow = editText;
            editText.setHintTextColor(SkinManager.getColor(R.color.CAM_X0108));
            this.mNickNameShow.setOnClickListener(this);
            this.mNickNameShow.setText(this.mModel.w().getNameShow());
            if (b.a.q0.b.d.E()) {
                this.mNickNameShow.setOnFocusChangeListener(new o(this));
                this.mNickNameShow.setOnEditorActionListener(new p(this));
            } else {
                this.mNickNameShow.setFocusableInTouchMode(false);
                this.mNickNameShow.setCursorVisible(false);
            }
            this.mClientid = (TextView) findViewById(R.id.person_clientid);
            this.mClientNumberMain = (LinearLayout) findViewById(R.id.person_client_number);
            this.mClientidShow = (TextView) findViewById(R.id.person_tclient_show);
            this.mCopyClientid = (ImageView) findViewById(R.id.person_client_copy);
            PersonChangeModel personChangeModel = this.mModel;
            if (personChangeModel != null && personChangeModel.w() != null && !TextUtils.isEmpty(this.mModel.w().getmTiebaId())) {
                this.mClientidShow.setText(this.mModel.w().getmTiebaId());
            } else {
                this.mClientNumberMain.setVisibility(8);
            }
            this.mClientNumberMain.setOnClickListener(this);
            View findViewById = findViewById(R.id.person_nickname);
            this.mPersonNicknameLayout = findViewById;
            findViewById.setOnClickListener(this);
            ImageView imageView2 = (ImageView) findViewById(R.id.nick_name_more);
            this.mNickNameMore = imageView2;
            imageView2.setOnClickListener(this);
            setNicknameMore();
            this.mUserNameShow = (TextView) findViewById(R.id.user_name_show);
            this.mNameContainer = findViewById(R.id.person_name);
            this.mUserNameMoreIcon = findViewById(R.id.user_name_more_icon);
            this.mNameContainer.setOnClickListener(this);
            if (StringUtils.isNull(this.mModel.w().getName())) {
                this.mUserNameShow.setText(getPageContext().getString(R.string.tip_empty_user_name));
                this.hasUserName = false;
                this.mNameContainer.setClickable(true);
                this.mUserNameMoreIcon.setVisibility(0);
            } else {
                this.mUserNameShow.setText(this.mModel.w().getName());
                this.hasUserName = true;
                this.mNameContainer.setClickable(false);
                this.mUserNameMoreIcon.setVisibility(8);
            }
            this.mIntroTextTip = (LinearLayout) findViewById(R.id.intro_text_tip);
            this.mIntroTextTipNum = (TextView) findViewById(R.id.intro_text_tip_num);
            this.mIntroTextTipDivider = (TextView) findViewById(R.id.intro_text_tip_divider);
            this.mIntroTextTipLimit = (TextView) findViewById(R.id.intro_text_tip_limit);
            TextView textView = (TextView) findViewById(R.id.intro);
            this.mIntro = textView;
            textView.setVisibility(8);
            if (this.mModel.w().getIntro() != null && this.mModel.w().getIntro().length() > 0) {
                this.mIntro.setText(this.mModel.w().getIntro());
            } else {
                this.mIntro.setText(getPageContext().getString(R.string.add_intro));
            }
            EditText editText2 = (EditText) findViewById(R.id.edit);
            this.mEdit = editText2;
            editText2.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
            this.mEdit.setHintTextColor(SkinManager.getColor(R.color.CAM_X0108));
            if (!b.a.e.e.p.k.isEmpty(this.mModel.w().getIntro())) {
                this.mEdit.setText(this.mModel.w().getIntro());
                TextView textView2 = this.mIntroTextTipNum;
                textView2.setText(this.mModel.w().getIntro().length() + "");
            } else {
                this.mIntroTextTipNum.setText("0");
            }
            this.mIntroTextTip.setVisibility(0);
            this.mEdit.setOnClickListener(this);
            this.mEdit.setOnFocusChangeListener(new q(this));
            this.mEdit.addTextChangedListener(new r(this));
            if (this.mModel.w().getSex() == 1) {
                this.mSex = 1;
                this.mSexShow.setText(R.string.male);
            } else if (this.mModel.w().getSex() == 2) {
                this.mSex = 2;
                this.mSexShow.setText(R.string.female);
            } else {
                this.mSexShow.setText(R.string.change_sex);
            }
            this.mImageProgressBar = (ProgressBar) findViewById(R.id.image_progress);
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(getPageContext().getPageActivity());
            this.mConfirmDialog = aVar;
            aVar.setMessage(getPageContext().getString(R.string.confirm_giveup));
            this.mConfirmDialog.setPositiveButton(getPageContext().getString(R.string.alert_yes_button), new a(this));
            this.mConfirmDialog.setNegativeButton(getPageContext().getString(R.string.cancel), new b(this));
            this.mConfirmDialog.create(getPageContext());
            this.mAlaIdLayout = (LinearLayout) findViewById(R.id.person_ala_id_layout);
            this.mAlaIdView = (TextView) findViewById(R.id.person_ala_id_show);
            this.mAlaIdNameView = (TextView) findViewById(R.id.person_ala_id_name);
            if (this.mModel.w().getAlaId() > 0) {
                this.mAlaIdLayout.setVisibility(0);
                TextView textView3 = this.mAlaIdView;
                textView3.setText(this.mModel.w().getAlaId() + "");
            }
            TextView textView4 = (TextView) findViewById(R.id.person_forum_age_show);
            this.mForumAgeView = textView4;
            textView4.setText(getResources().getString(R.string.person_forum_age_suffix, this.mModel.w().getForumAge()));
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.person_constellation);
            this.mConstellationLayout = relativeLayout;
            relativeLayout.setOnClickListener(this);
            this.mConstellationView = (TextView) findViewById(R.id.constellation_txt);
            this.mAgeView = (TextView) findViewById(R.id.age_txt);
            if (this.mModel.w().getBirthdayTime() != 0) {
                this.mConstellationView.setText(StringHelper.dateToConstellation(new Date(this.mModel.w().getBirthdayTime() * 1000)));
            }
            if (this.mModel.w().getUserAge() > 0 && this.mModel.w().getBirthdayShowStatus() == 2) {
                this.mAgeView.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.mModel.w().getUserAge())));
                this.mAgeView.setVisibility(0);
            } else {
                this.mAgeView.setVisibility(8);
            }
            this.mPersonChangeScroll.post(new c(this));
        }
    }

    private boolean checkTempNickName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, this)) == null) {
            saveTempNickName();
            String str = this.mTempNickName;
            if (str == null || str.equals(this.mModel.w().getNameShow())) {
                return true;
            }
            return m0.b(this.mTempNickName) <= 20 && m0.b(this.mTempNickName) >= 2;
        }
        return invokeV.booleanValue;
    }

    private void clickChangeNickName() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            if (b.a.q0.b.d.E()) {
                b.a.q0.s.e0.b.j().t("key_has_show_nick_name_red_icon_tip", true);
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
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14378");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clickSaveEvents() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            Editable text = this.mNickNameShow.getText();
            String obj = text == null ? "" : text.toString();
            StatisticItem statisticItem = new StatisticItem("c14379");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_param1", !obj.equals(this.mModel.w().getNameShow()));
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, !this.mEdit.toString().replaceAll("\\s*", "").equals(this.mModel.w().getIntro()));
            TiebaStatic.log(statisticItem);
        }
    }

    public static int getAgeByBirthday(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, date)) == null) {
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
        if (interceptable == null || interceptable.invokeL(65581, this, intent) == null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
        }
    }

    private void getAlbumDataFromImage(Intent intent) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65582, this, intent) == null) || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        this.mWriteImagesInfo.parseJson(stringExtra);
        this.mWriteImagesInfo.updateQuality();
        if (this.mWriteImagesInfo.getChosedFiles() != null && this.mWriteImagesInfo.getChosedFiles().size() > 0) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.mWriteImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
        }
        this.mWriteImagesInfo.clear();
    }

    private void hideEditor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65583, this) == null) {
            if (this.mEdit.getVisibility() == 0 && this.mEdit.isFocused()) {
                String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
                if (replaceAll.length() > 0) {
                    this.mIntro.setText(replaceAll);
                } else {
                    this.mIntro.setText(getPageContext().getString(R.string.add_intro));
                }
                if (this.mModel.w().getIntro() == null || !this.mModel.w().getIntro().equals(replaceAll)) {
                    this.isEdited = true;
                }
                this.mModel.w().setIntro(replaceAll);
                HidenSoftKeyPad(this.mInputManager, this.mEdit);
            } else if (this.mNickNameShow.getVisibility() == 0 && this.mNickNameShow.isFocused()) {
                HidenSoftKeyPad(this.mInputManager, this.mNickNameShow);
            }
        }
    }

    private void refreshHead() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65584, this) == null) {
            s sVar = this.mImageTask;
            if (sVar != null) {
                sVar.cancel();
            }
            this.mPhoto = null;
            s sVar2 = new s(this, null);
            this.mImageTask = sVar2;
            sVar2.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetUserName(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65585, this, str) == null) || StringUtils.isNull(str)) {
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
        if (!(interceptable == null || interceptable.invokeV(65586, this) == null) || (personChangeModel = this.mModel) == null || personChangeModel.w() == null) {
            return;
        }
        hideEditor();
        if (b.a.q0.b.d.E() && !checkTempNickName()) {
            showTopToast(R.string.person_nick_name_toast, false);
        } else if (!b.a.e.e.p.j.z()) {
            showTopToast(R.string.neterror, false);
        } else {
            this.mModel.w().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.mModel.w().setSex(this.mSex);
            if (this.mModifyTask == null) {
                t tVar = new t(this, this.mModel);
                this.mModifyTask = tVar;
                tVar.setPriority(3);
                this.mModifyTask.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveTempNickName() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65587, this) == null) {
            Editable text = this.mNickNameShow.getText();
            this.mTempNickName = text == null ? "" : text.toString();
            this.mModel.w().setTempNickName(this.mTempNickName);
            this.isUpdateNickName = !this.mTempNickName.equals(this.mModel.w().getNameShow());
        }
    }

    private void scrollToBottom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65588, this, i2) == null) {
            this.mPersonChangeScroll.postDelayed(new m(this), i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUpdateMessage() {
        PersonChangeModel personChangeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65589, this) == null) || (personChangeModel = this.mModel) == null || personChangeModel.w() == null) {
            return;
        }
        b.a.q0.a0.b.a().d();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.mModel.w()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataAndFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65590, this) == null) {
            Intent intent = new Intent();
            if (this.isFromPersonInfo.booleanValue()) {
                intent.putExtra("person_change_data", this.mModel.w());
            } else {
                intent.putExtra("data", this.mModel.w());
            }
            setResult(-1, intent);
            sendUpdateMessage();
            finish();
        }
    }

    private void setIntroTextTipStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65591, this, i2) == null) {
            this.mIntroTextTipNum.setTextColor(i2);
            this.mIntroTextTipDivider.setTextColor(i2);
            this.mIntroTextTipLimit.setTextColor(i2);
        }
    }

    private void setNicknameMore() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65592, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNickNameMore.getLayoutParams();
            if (b.a.q0.b.d.E()) {
                layoutParams.width = UtilHelper.getDimenPixelSize(R.dimen.tbds21);
                layoutParams.height = UtilHelper.getDimenPixelSize(R.dimen.tbds21);
                this.mNickNameMore.setImageResource(R.drawable.ic_red_circle);
                if (this.mModel.w().getNickNameLeftDays() == 0 && !b.a.q0.s.e0.b.j().g("key_has_show_nick_name_red_icon_tip", false)) {
                    this.mNickNameMore.setVisibility(0);
                } else {
                    this.mNickNameMore.setVisibility(4);
                }
            } else {
                layoutParams.width = -2;
                layoutParams.height = -2;
                this.mNickNameMore.setImageResource(R.drawable.icon_arrow_more_gray);
                if (!NickNameActivitySwitch.isOn() && this.mModel.w().getNickNameLeftDays() != 0) {
                    this.mNickNameMore.setVisibility(8);
                } else {
                    this.mNickNameMore.setVisibility(0);
                }
            }
            this.mNickNameMore.requestLayout();
        }
    }

    private void showEditor() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65593, this) == null) || this.mEdit.getVisibility() == 0) {
            return;
        }
        this.mIntro.setVisibility(8);
        this.mEdit.setText(this.mModel.w().getIntro());
        EditText editText = this.mEdit;
        editText.setSelection(editText.getText().length());
        this.mEdit.setFocusableInTouchMode(true);
        this.mEdit.requestFocus();
        ShowSoftKeyPad(this.mInputManager, this.mEdit);
        scrollToBottom(400);
    }

    private void showInputDialog(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65594, this, accountData) == null) {
            if (this.mInputUserNameDialog == null) {
                b.a.q0.t.i.b bVar = new b.a.q0.t.i.b(this);
                this.mInputUserNameDialog = bVar;
                bVar.w(new l(this));
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
        if (interceptable == null || interceptable.invokeV(65595, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(65596, this) == null) {
            if (this.mNickNameActivityDialog == null) {
                View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
                b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(getPageContext().getPageActivity());
                this.mNickNameActivityDialog = aVar;
                aVar.setContentView(inflate);
                this.mNickNameActivityDialog.setPositiveButton(R.string.nick_name_confirm, new j(this));
                this.mNickNameActivityDialog.setNegativeButton(R.string.nick_name_cancel, new k(this));
                this.mNickNameActivityDialog.create(getPageContext());
                SkinManager.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), R.color.CAM_X0105);
                SkinManager.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), R.color.common_color_10122);
            }
            this.mNickNameActivityDialog.show();
        }
    }

    private void showSexDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65597, this) == null) {
            if (this.mSexDialog == null) {
                this.mSexDialog = new PopupDialog(getPageContext());
                String string = getPageContext().getString(R.string.male);
                String string2 = getPageContext().getString(R.string.female);
                this.mSexDialog.setDefaultContentView(getString(R.string.choose_sex), new String[]{string, string2}, new e(this, string, string2));
            }
            this.mSexDialog.showDialog();
        }
    }

    public static void showSuccessToast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65598, null) == null) {
            b.a.e.e.m.e.a().postDelayed(new g(), 200L);
        }
    }

    public static void startActivityForResult(Activity activity, int i2, PersonChangeData personChangeData, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65599, null, activity, i2, personChangeData, bool) == null) {
            Intent intent = new Intent(activity, PersonChangeActivity.class);
            intent.putExtra("data", personChangeData);
            intent.putExtra("isFromPersonInfo", bool);
            activity.startActivityForResult(intent, i2);
        }
    }

    private void updateNickName(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65600, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.isUpdateNickName = true;
        this.mModel.w().setPhotoChanged(true);
        this.mModel.w().setNameShow(str);
        this.mModel.w().setNickNameLeftDays(90);
        this.mNickNameShow.setText(str);
        setNicknameMore();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 != -1) {
                if (i3 == 0 && i2 == 12010) {
                    SelectImageHelper.takePhoto(getPageContext());
                }
            } else if (i2 == 1001) {
                if (intent != null) {
                    long longExtra = intent.getLongExtra(PersonConstellationActivity.ACTIVITY_INTENT_BIRTHDAY, 0L);
                    int intExtra = intent.getIntExtra(PersonConstellationActivity.ACTIVITY_INTENT_SHOW_STATUS, 0);
                    if (longExtra == this.mModel.w().getBirthdayTime() && intExtra == this.mModel.w().getBirthdayShowStatus()) {
                        return;
                    }
                    this.mModel.w().setBirthdayShowStatus(intExtra);
                    this.mModel.w().setBirthdayTime(longExtra);
                    this.isEdited = true;
                    this.isUpdate = true;
                    Date date = new Date(longExtra * 1000);
                    this.mConstellationView.setText(StringHelper.dateToConstellation(date));
                    if (this.mModel.w().getBirthdayShowStatus() == 2) {
                        this.mAgeView.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(getAgeByBirthday(date))));
                        this.mAgeView.setVisibility(0);
                        return;
                    }
                    this.mAgeView.setVisibility(8);
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
                this.mModel.w().setPhotoChanged(true);
                if (intent != null) {
                    this.mPhotoView.setImageBitmap(null);
                    this.mPhotoView.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                }
                this.isUpdate = true;
                if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                    SkinManager.setViewTextColor(this.mSave, R.color.navi_op_text, 1);
                } else {
                    SkinManager.setViewTextColor(this.mSave, R.color.CAM_X0302, 1);
                }
            } else if (i2 == 12009 || i2 == 12010) {
                this.mModel.w().setPhotoChanged(true);
                refreshHead();
                this.isUpdate = true;
                if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                    SkinManager.setViewTextColor(this.mSave, R.color.navi_op_text, 1);
                } else {
                    SkinManager.setViewTextColor(this.mSave, R.color.CAM_X0302, 1);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.mParent);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mBackIcon, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            this.mPhotoView.refresh();
            SkinManager.setViewTextColor(this.mUserNameShow, R.color.CAM_X0109);
            WebPManager.setMaskDrawable(this.mPhotoCameraView, R.drawable.icon_mask_personalba_edit40, null);
            WebPManager.setPureDrawable(this.mCopyClientid, R.drawable.icon_pure_wo_recommend_copy18, R.color.CAM_X0108, null);
            SkinManager.setViewTextColor(this.mSave, R.color.CAM_X0302, 1);
            b.a.q0.s.u.c.d(this.mClientid).v(R.color.CAM_X0108);
            b.a.q0.s.u.c.d(this.mClientidShow).v(R.color.CAM_X0108);
            b.a.q0.s.u.c.d(this.tvForumAbs).v(R.color.CAM_X0109);
            b.a.q0.s.u.c.d(this.tvForumAge).v(R.color.CAM_X0109);
            b.a.q0.s.u.c.d(this.mAlaIdNameView).v(R.color.CAM_X0109);
            b.a.q0.s.u.c.d(this.mAlaIdView).v(R.color.CAM_X0109);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        PersonChangeData personChangeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            super.onClick(view);
            if (view != this.mPhotoView && view != this.mPhotoCameraView) {
                if (view == this.editLayout) {
                    saveTempNickName();
                    clickSaveEvents();
                    if (!this.isUpdate && !this.isUpdateNickName) {
                        finish();
                    }
                    if (this.isFromPersonInfo.booleanValue()) {
                        TiebaStatic.log("c10100");
                    } else {
                        TiebaStatic.log("c10101");
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
                            if (personChangeModel == null || personChangeModel.w() == null || StringUtils.isNull(this.mModel.w().getName())) {
                                showInputDialog(TbadkCoreApplication.getCurrentAccountInfo());
                                return;
                            }
                            return;
                        } else if (view == this.mConstellationLayout) {
                            PersonConstellationActivity.startPersonConstellationActivity(getActivity(), this.mModel.w().getBirthdayTime(), this.mModel.w().getBirthdayShowStatus());
                            return;
                        } else if (view != this.mClientNumberMain || this.mClientidShow == null || this.mUserNameShow == null) {
                            return;
                        } else {
                            b.a.e.e.p.a.a(String.format(getResources().getString(R.string.to_share_tieba_id), TbadkCoreApplication.getCurrentAccountNameShow(), this.mClientidShow.getText().toString()));
                            new BdTopToast(this, 3000).setIcon(true).setContent(getResources().getString(R.string.copy_success)).show((ViewGroup) this.mRootView);
                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COPY_CLIENT_NUMBER_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_param1", this.mClientidShow.getText().toString()).param("obj_locate", 2));
                            return;
                        }
                    } else {
                        clickChangeNickNameEvents();
                        if (Build.VERSION.SDK_INT < 19) {
                            showTopToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname), false);
                            return;
                        } else if (NickNameActivitySwitch.isOn()) {
                            showNickNameActivityDialog();
                            return;
                        } else {
                            int nickNameLeftDays = this.mModel.w().getNickNameLeftDays();
                            if (nickNameLeftDays == 0) {
                                clickChangeNickName();
                                return;
                            } else {
                                showTopToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)), false);
                                return;
                            }
                        }
                    }
                }
            }
            PersonChangeModel personChangeModel2 = this.mModel;
            if (personChangeModel2 != null && (personChangeData = personChangeModel2.f53119e) != null && !personChangeData.canModifyAvatar()) {
                if (!StringUtils.isNull(this.mModel.f53119e.getCantModifyAvatarDesc())) {
                    b.a.e.e.p.l.J(TbadkCoreApplication.getInst(), this.mModel.f53119e.getCantModifyAvatarDesc());
                    return;
                } else {
                    b.a.e.e.p.l.I(TbadkCoreApplication.getInst(), R.string.person_cant_edit_avatar_default_tip);
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
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.person_change_activity);
            adjustResizeForSoftInput();
            this.mInputManager = (InputMethodManager) getSystemService("input_method");
            InitData(bundle);
            InitUI();
            if (bundle != null) {
                this.isFromPersonInfo = Boolean.valueOf(bundle.getBoolean("isFromPersonInfo"));
            } else {
                this.isFromPersonInfo = Boolean.valueOf(getIntent().getBooleanExtra("isFromPersonInfo", false));
            }
            TiebaStatic.log("c12204");
            registerListener(this.mModifyNicknameSucceedListener);
            registerListener(this.mChangeLeftDayListener);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.mModifyNicknameSucceedListener);
            s sVar = this.mImageTask;
            if (sVar != null) {
                sVar.cancel();
            }
            t tVar = this.mModifyTask;
            if (tVar != null) {
                tVar.cancel();
            }
            ProgressBar progressBar = this.mImageProgressBar;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            EditText editText = this.mEdit;
            if (editText != null) {
                editText.addTextChangedListener(null);
            }
            b.a.q0.t.i.b bVar = this.mInputUserNameDialog;
            if (bVar != null) {
                bVar.s();
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                hideEditor();
                this.mBackClickListener.onClick(null);
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            if (!this.mHasModifyNickName || TextUtils.isEmpty(this.mTempNickName)) {
                return;
            }
            updateNickName(this.mTempNickName);
            this.mHasModifyNickName = false;
            this.mTempNickName = "";
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (this.mModel.w() != null) {
                bundle.putString("data", OrmObject.jsonStrWithObject(this.mModel.w()));
            }
        }
    }

    public void showHeadDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
            b.a.q0.s.s.b bVar = new b.a.q0.s.s.b(getPageContext().getPageActivity());
            bVar.k(R.string.operation);
            bVar.j(strArr, new d(this));
            bVar.c(getPageContext());
            bVar.m();
        }
    }

    public void showTopToast(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, str, z) == null) {
            new BdTopToast(this).setIcon(z).setContent(str).show((ViewGroup) findViewById(16908290));
        }
    }

    public void showTopToast(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            showTopToast(getString(i2), z);
        }
    }
}
