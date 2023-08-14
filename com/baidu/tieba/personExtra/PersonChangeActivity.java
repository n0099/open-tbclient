package com.baidu.tieba.personExtra;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
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
import android.view.MotionEvent;
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
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.AndroidUtils;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.EditNickNameActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.IMUserExtraData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.message.UserGrowthTaskRequestMessage;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.BdToastHelper;
import com.baidu.tbadk.core.util.FileHelper;
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
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.bi;
import com.baidu.tieba.lk5;
import com.baidu.tieba.m45;
import com.baidu.tieba.n45;
import com.baidu.tieba.pay.panel.PayPanelUtils;
import com.baidu.tieba.personExtra.PersonChangeModel;
import com.baidu.tieba.qf5;
import com.baidu.tieba.rw5;
import com.baidu.tieba.sca;
import com.baidu.tieba.u45;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.vw7;
import com.baidu.tieba.w45;
import com.baidu.tieba.widget.InterestForumTagLayout;
import com.baidu.tieba.widget.InterestForumTagView;
import com.baidu.tieba.widget.ManualObservableScrollView;
import com.baidu.tieba.ww7;
import com.baidu.tieba.xb9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InputMethodManager A;
    public TextView A0;
    public PersonChangeModel B;
    public vw7 B0;
    public FrameLayout C;
    public boolean C0;
    public HeadImageView D;
    public int D0;
    public BdImage E;
    public ViewTreeObserver.OnGlobalLayoutListener E0;
    public c0 F;
    public TBAlertBuilder F0;
    public d0 G;
    public final Runnable G0;
    public ProgressBar H;
    public PersonChangeModel.b H0;
    public DialogInterface.OnCancelListener I;
    public final View.OnClickListener I0;
    public m45 J;
    public CustomMessageListener J0;
    public u45 K;
    public CustomMessageListener K0;
    public boolean L;
    public boolean M;
    public boolean N;
    public int O;
    public View P;
    public View Q;
    public View R;
    public ImageView S;

    /* renamed from: T  reason: collision with root package name */
    public View f1152T;
    public ViewGroup U;
    public ImageView V;
    public ImageView W;
    public ImageView X;
    public m45 Y;
    public boolean Z;
    public Boolean a;
    public String a0;
    public final WriteImagesInfo b;
    public PermissionJudgePolicy b0;
    public NavigationBar c;
    public qf5 c0;
    public TextView d;
    public LinearLayout d0;
    public EMTextView e;
    public TextView e0;
    public LinearLayout f;
    public TextView f0;
    public TextView g;
    public TextView g0;
    public TextView h;
    public TextView h0;
    public View i;
    public ImageView i0;
    public LinearLayout j;
    public TextView j0;
    public ManualObservableScrollView k;
    public TextView l;
    public EditText m;
    public TextView n;
    public LinearLayout o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView r0;
    public ImageView s;
    public TextView s0;
    public TextView t;
    public TextView t0;
    public TextView u;
    public TextView u0;
    public TextView v;
    public RelativeLayout v0;
    public RelativeLayout w;
    public LinearLayout w0;
    public LinearLayout x;
    public InterestForumTagLayout x0;
    public EditText y;
    public LinearLayout y0;
    public LinearLayout z;
    public TextView z0;

    /* loaded from: classes7.dex */
    public class a implements PersonChangeModel.b {
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

        @Override // com.baidu.tieba.personExtra.PersonChangeModel.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.isLoadingViewAttached()) {
                    PersonChangeActivity personChangeActivity = this.a;
                    personChangeActivity.hideLoadingView(personChangeActivity.U);
                }
                PersonChangeActivity personChangeActivity2 = this.a;
                personChangeActivity2.showNetRefreshView(personChangeActivity2.U, str);
            }
        }

        @Override // com.baidu.tieba.personExtra.PersonChangeModel.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.isLoadingViewAttached()) {
                    PersonChangeActivity personChangeActivity = this.a;
                    personChangeActivity.hideLoadingView(personChangeActivity.U);
                }
                if (this.a.j != null) {
                    this.a.j.setVisibility(0);
                }
                this.a.u2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public a0(PersonChangeActivity personChangeActivity) {
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
                this.a.k.fullScroll(130);
                this.a.y.setFocusableInTouchMode(true);
                this.a.y.requestFocus();
                PersonChangeActivity personChangeActivity = this.a;
                personChangeActivity.ShowSoftKeyPad(personChangeActivity.A, this.a.y);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements InterestForumTagView.b {
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

        @Override // com.baidu.tieba.widget.InterestForumTagView.b
        public void a(SelectForumData selectForumData) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, selectForumData) != null) {
                return;
            }
            this.a.G2();
        }
    }

    /* loaded from: classes7.dex */
    public class b0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public b0(PersonChangeActivity personChangeActivity) {
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
                if (this.a.G != null) {
                    this.a.G.cancel();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnFocusChangeListener {
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

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) && !z) {
                this.a.m.setFocusableInTouchMode(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c0 extends BdAsyncTask<Object, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public c0(PersonChangeActivity personChangeActivity) {
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
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                return FileHelper.getImage(null, TbConfig.PERSON_HEAD_FILE);
            }
            return (Bitmap) invokeL.objValue;
        }

        public /* synthetic */ c0(PersonChangeActivity personChangeActivity, k kVar) {
            this(personChangeActivity);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.F = null;
                this.a.H.setVisibility(8);
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
                this.a.H.setVisibility(0);
                this.a.D.setImageDrawable(null);
                this.a.E = null;
                super.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, bitmap) == null) {
                super.onPostExecute((c0) bitmap);
                this.a.F = null;
                this.a.H.setVisibility(8);
                if (bitmap != null) {
                    this.a.E = new BdImage(bitmap, false, (String) null);
                    this.a.E.drawImageTo(this.a.D);
                    TbImageMemoryCache.B().k(this.a.B.R().getPortrait(), this.a.E, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements TextView.OnEditorActionListener {
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

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                if (i == 6) {
                    this.a.m.setFocusableInTouchMode(false);
                    this.a.m.setCursorVisible(false);
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d0 extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public PersonChangeModel b;
        public final /* synthetic */ PersonChangeActivity c;

        public d0(PersonChangeActivity personChangeActivity, PersonChangeModel personChangeModel) {
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
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.G = null;
            NetWork netWork = this.a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            super.cancel(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                PersonChangeActivity personChangeActivity = this.c;
                personChangeActivity.showLoadingDialog(personChangeActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f12dc), this.c.I);
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
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.a = netWork;
                netWork.addPostData("sex", String.valueOf(this.b.R().getSex()));
                this.a.addPostData("intro", this.b.R().getIntro());
                this.a.addPostData("birthday_time", String.valueOf(this.b.R().getBirthdayTime()));
                this.a.addPostData("birthday_show_status", String.valueOf(this.b.R().getBirthdayShowStatus()));
                if (UbsABTestHelper.isNickNameABTest()) {
                    this.a.addPostData("need_keep_nickname_flag", "0");
                    this.a.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
                    this.a.addPostData(IMUserExtraData.KEY_IS_BUSINESS_ACCOUNT, this.b.R().getIsBusinessAccount());
                    if (!TextUtils.isEmpty(this.b.R().getTempNickName())) {
                        this.a.addPostData("nick_name", this.b.R().getTempNickName());
                    }
                } else {
                    this.a.addPostData("need_keep_nickname_flag", "1");
                }
                if (this.c.C0) {
                    this.a.addPostData("do_from", "local_user_profile");
                    this.a.addPostData("forum_data", this.b.R().getInterestedForumsJsonString());
                }
                this.a.postMultiNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    sca.j();
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
                this.c.G = null;
                this.c.closeLoadingDialog();
                NetWork netWork = this.a;
                if (netWork != null) {
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        this.c.N2();
                        this.c.X2();
                    } else {
                        this.c.Z2(this.a.getErrorString(), false);
                    }
                }
                super.onPostExecute((d0) str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

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
            if (interceptable != null && interceptable.invokeL(1048576, this, editable) != null) {
                return;
            }
            this.a.G2();
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnTouchListener {
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

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                view2.getParent().requestDisallowInterceptTouchEvent(true);
                int action = motionEvent.getAction() & 255;
                if (action != 1) {
                    if (action == 2) {
                        this.a.y.setFocusable(false);
                    }
                } else {
                    this.a.y.setFocusable(true);
                    this.a.y.setFocusableInTouchMode(true);
                    view2.getParent().requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnFocusChangeListener {
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

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) && !z) {
                this.a.y.setFocusableInTouchMode(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

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

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, editable) != null) || this.a.B.R() == null || editable.toString().replaceAll("\\s*", "").equals(this.a.B.R().getIntro())) {
                return;
            }
            this.a.M = true;
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                SkinManager.setViewTextColor(this.a.d, R.color.navi_op_text, 1);
            } else {
                SkinManager.setViewTextColor(this.a.d, R.color.CAM_X0302, 1);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                Editable text = this.a.y.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                this.a.t.setText(String.valueOf(length));
                this.a.z.setVisibility(0);
                this.a.U2();
                if (length > 500) {
                    this.a.Y2(R.string.over_limit_tip, false);
                    if (this.a.y.getSelectionStart() - 1 >= 0 && this.a.y.getSelectionStart() - 1 <= this.a.y.getSelectionEnd()) {
                        text.delete(this.a.y.getSelectionStart() - 1, this.a.y.getSelectionEnd());
                        this.a.y.setText(charSequence);
                    } else {
                        this.a.y.setText(replaceAll.substring(0, 500));
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd > length2) {
                        selectionEnd = length2;
                    }
                    Selection.setSelection(this.a.y.getText(), selectionEnd);
                }
                this.a.G2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements m45.e {
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

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                m45Var.dismiss();
                this.a.y2();
                this.a.J2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements m45.e {
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

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                m45Var.dismiss();
                if (this.a.B.R().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (this.a.a.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.a.B.R());
                    } else {
                        intent.putExtra("data", this.a.B.R());
                    }
                    this.a.setResult(-1, intent);
                    this.a.M2();
                }
                this.a.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.y0 != null) {
                this.a.y0.setVisibility(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k.scrollTo(0, 0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements ManualObservableScrollView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public m(PersonChangeActivity personChangeActivity) {
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
                BdUtilHelper.hideSoftKeyPad(personChangeActivity, personChangeActivity.U);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements ViewTreeObserver.OnGlobalLayoutListener {
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

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int height = this.a.U.getHeight();
                if (this.a.D0 != 0 && this.a.D0 != height) {
                    if (height > this.a.D0) {
                        SafeHandler.getInst().postDelayed(this.a.G0, 200L);
                    } else if (this.a.y0 != null) {
                        this.a.y0.setVisibility(8);
                    }
                }
                this.a.D0 = height;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements n45.c {
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

        @Override // com.baidu.tieba.n45.c
        public void a(n45 n45Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, n45Var, i, view2) == null) {
                if (i == 0) {
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.a.getPageContext().getPageActivity(), this.a.b.toJsonString(), true);
                    albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                    albumActivityConfig.setResourceType(2);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                } else if (i == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.a.getPageContext().getPageActivity(), 12014)));
                }
                n45Var.e();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements w45.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PersonChangeActivity c;

        public p(PersonChangeActivity personChangeActivity, String str, String str2) {
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

        @Override // com.baidu.tieba.w45.f
        public void K0(w45 w45Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, w45Var, i, view2) == null) {
                if (this.c.K != null && this.c.K.isShowing()) {
                    this.c.K.dismiss();
                }
                if (!(view2 instanceof TextView)) {
                    return;
                }
                TextView textView = (TextView) view2;
                if (!this.a.equals(textView.getText().toString())) {
                    if (this.b.equals(textView.getText().toString())) {
                        this.c.O = 2;
                        this.c.r.setText(this.b);
                    }
                } else {
                    this.c.O = 1;
                    this.c.r.setText(this.a);
                }
                SkinManager.setViewTextColor(this.c.r, (int) R.color.CAM_X0105);
                if (this.c.O != this.c.B.R().getSex()) {
                    this.c.M = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        SkinManager.setViewTextColor(this.c.d, R.color.navi_op_text, 1);
                    } else {
                        SkinManager.setViewTextColor(this.c.d, R.color.CAM_X0302, 1);
                    }
                }
                this.c.G2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public q(PersonChangeActivity personChangeActivity) {
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
                if (this.a.B.R().getSex() != this.a.O) {
                    this.a.L = true;
                }
                this.a.K2();
                if (!this.a.C0 && (this.a.L || this.a.N)) {
                    this.a.J.show();
                    return;
                }
                if (this.a.B != null && this.a.B.R().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (this.a.a.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.a.B.R());
                    } else {
                        intent.putExtra("data", this.a.B.R());
                    }
                    this.a.M2();
                    this.a.setResult(-1, intent);
                }
                this.a.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Activity currentActivity;
            String string;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && currentActivity.findViewById(16908290) != null) {
                if (this.a.C0) {
                    string = currentActivity.getString(R.string.obfuscated_res_0x7f0f04b4);
                } else {
                    string = currentActivity.getString(R.string.obfuscated_res_0x7f0f03ef);
                }
                if (this.a.m != null && this.a.m.getText() != null && this.a.B != null && this.a.B.R() != null && !this.a.m.getText().equals(this.a.B.R().getNameShow())) {
                    string = currentActivity.getString(R.string.obfuscated_res_0x7f0f0490);
                    if (!TbSingleton.getInstance().isUserGrowthTaskCompleted(UserGrowthTaskRequestMessage.SET_USER_NICK)) {
                        MessageManager.getInstance().sendMessage(new UserGrowthTaskRequestMessage(UserGrowthTaskRequestMessage.SET_USER_NICK));
                    }
                }
                if (BdToastHelper.getBdToastData().getContent() == null) {
                    new BdTopToast(currentActivity).setIcon(true).setContent(string).show((ViewGroup) currentActivity.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(PersonChangeActivity personChangeActivity, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    this.a.Z = true;
                    this.a.a0 = str;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(PersonChangeActivity personChangeActivity, int i) {
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
                if (this.a.B != null && this.a.B.R() != null && personChangeData != null) {
                    this.a.B.R().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    this.a.B.R().setMem(personChangeData.getMen());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Dialog a;
        public final /* synthetic */ PersonChangeActivity b;

        public u(PersonChangeActivity personChangeActivity, Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity, dialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personChangeActivity;
            this.a = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Dialog dialog;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (dialog = this.a) != null && dialog.isShowing()) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Dialog a;
        public final /* synthetic */ PersonChangeActivity b;

        public v(PersonChangeActivity personChangeActivity, Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity, dialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personChangeActivity;
            this.a = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                PayPanelUtils.launchPayPanel(this.b.getPageContext(), (int) IMConstants.IM_MSG_TYPE_FAST_SHIELD);
                Dialog dialog = this.a;
                if (dialog != null && dialog.isShowing()) {
                    this.a.dismiss();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w implements vw7.b {
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

        @Override // com.baidu.tieba.vw7.b
        public void a(Date date, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, date, j) == null) {
                this.a.B.R().setBirthdayTime(j);
                this.a.h0.setText(StringHelper.dateToConstellation(date));
                this.a.j0.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1075, Integer.valueOf(PersonChangeActivity.z2(date))));
                this.a.j0.setVisibility(0);
                SkinManager.setViewTextColor(this.a.h0, (int) R.color.CAM_X0105);
                this.a.G2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x implements m45.e {
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

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                BrowserHelper.startWebActivity((Context) this.a.getPageContext().getPageActivity(), (String) null, xb9.a(), true);
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y implements m45.e {
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

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z implements qf5.e {
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

        @Override // com.baidu.tieba.qf5.e
        public void a(AccountData accountData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, accountData) != null) || accountData == null) {
                return;
            }
            this.a.I2(accountData.getAccount());
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
        this.a = Boolean.FALSE;
        this.b = new WriteImagesInfo(1);
        this.c = null;
        this.d = null;
        this.j = null;
        this.k = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = 0;
        this.Z = false;
        this.G0 = new k(this);
        this.H0 = new a(this);
        this.I0 = new q(this);
        this.J0 = new s(this, 2921033);
        this.K0 = new t(this, 2921061);
    }

    public final void E2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.y.getVisibility() == 0 && this.y.isFocused()) {
                String replaceAll = this.y.getText().toString().replaceAll("\\s*", "");
                if (replaceAll.length() > 0) {
                    this.p.setText(replaceAll);
                } else {
                    this.p.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f00fb));
                }
                if (this.B.R().getIntro() == null || !this.B.R().getIntro().equals(replaceAll)) {
                    this.L = true;
                }
                this.B.R().setIntro(replaceAll);
                HidenSoftKeyPad(this.A, this.y);
            } else if (this.m.getVisibility() == 0 && this.m.isFocused()) {
                HidenSoftKeyPad(this.A, this.m);
            }
        }
    }

    public final void J2() {
        PersonChangeModel personChangeModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (personChangeModel = this.B) != null && personChangeModel.R() != null) {
            E2();
            if (UbsABTestHelper.isNickNameABTest() && !v2()) {
                Y2(R.string.obfuscated_res_0x7f0f107e, false);
            } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                Y2(R.string.obfuscated_res_0x7f0f0e21, false);
            } else {
                this.B.R().setIntro(this.y.getText().toString().replaceAll("\\s*", ""));
                this.B.R().setSex(this.O);
                if (this.G == null) {
                    d0 d0Var = new d0(this, this.B);
                    this.G = d0Var;
                    d0Var.setPriority(3);
                    this.G.execute(new String[0]);
                }
            }
        }
    }

    public final void P2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.S.getLayoutParams();
            if (UbsABTestHelper.isNickNameABTest()) {
                layoutParams.width = UtilHelper.getDimenPixelSize(R.dimen.tbds21);
                layoutParams.height = UtilHelper.getDimenPixelSize(R.dimen.tbds21);
                this.S.setImageResource(R.drawable.obfuscated_res_0x7f0807dc);
                if (this.B.R().getNickNameLeftDays() == 0 && !SharedPrefHelper.getInstance().getBoolean("key_has_show_nick_name_red_icon_tip", false)) {
                    this.S.setVisibility(0);
                } else {
                    this.S.setVisibility(4);
                }
            } else {
                layoutParams.width = -2;
                layoutParams.height = -2;
                this.S.setImageResource(R.drawable.icon_arrow_more_gray);
                if (!NickNameActivitySwitch.isOn() && this.B.R().getNickNameLeftDays() != 0) {
                    this.S.setVisibility(8);
                } else {
                    this.S.setVisibility(0);
                }
            }
            this.S.requestLayout();
        }
    }

    public final void Q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            String string = getResources().getString(R.string.obfuscated_res_0x7f0f0d16);
            if (this.C0) {
                string = getString(R.string.obfuscated_res_0x7f0f0bee);
            }
            this.c.setCenterTextTitle(string);
            if (this.C0) {
                return;
            }
            View addCustomView = this.c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
            this.i = addCustomView;
            TextView textView = (TextView) addCustomView.findViewById(R.id.right_textview);
            this.d = textView;
            textView.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f12cc));
            SkinManager.setViewTextColor(this.d, R.color.navi_op_text, 1);
            this.i.setOnClickListener(this);
        }
    }

    public final void V2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.Y == null) {
                View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d07e7, (ViewGroup) null);
                m45 m45Var = new m45(getPageContext().getPageActivity());
                this.Y = m45Var;
                m45Var.setContentView(inflate);
                this.Y.setPositiveButton(R.string.nick_name_confirm, new x(this));
                this.Y.setNegativeButton(R.string.nick_name_cancel, new y(this));
                this.Y.create(getPageContext());
                SkinManager.setViewTextColor(inflate.findViewById(R.id.obfuscated_res_0x7f091947), (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(inflate.findViewById(R.id.obfuscated_res_0x7f091946), (int) R.color.common_color_10122);
            }
            this.Y.show();
        }
    }

    public final void y2() {
        String obj;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048622, this) != null) || this.C0) {
            return;
        }
        Editable text = this.m.getText();
        if (text == null) {
            obj = "";
        } else {
            obj = text.toString();
        }
        StatisticItem statisticItem = new StatisticItem("c14379");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_param1", !obj.equals(this.B.R().getNameShow()));
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, !this.y.toString().replaceAll("\\s*", "").equals(this.B.R().getIntro()));
        TiebaStatic.log(statisticItem);
    }

    public final void I2(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        this.r0.setText(str);
        this.P.setClickable(false);
        this.Q.setVisibility(8);
    }

    public final void L2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.k.postDelayed(new a0(this), i2);
        }
    }

    public final void O2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.t.setTextColor(i2);
            this.u.setTextColor(i2);
            this.v.setTextColor(i2);
        }
    }

    public final void T2(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, accountData) == null) {
            if (this.c0 == null) {
                qf5 qf5Var = new qf5(this);
                this.c0 = qf5Var;
                qf5Var.w(new z(this));
            }
            this.c0.p();
            this.c0.u(accountData);
            this.c0.y();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (this.B.R() != null) {
                bundle.putString("data", OrmObject.jsonStrWithObject(this.B.R()));
            }
        }
    }

    public void Y2(int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            Z2(getString(i2), z2);
        }
    }

    public void Z2(String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048601, this, str, z2) == null) {
            new BdTopToast(this).setIcon(z2).setContent(str).show((ViewGroup) findViewById(16908290));
        }
    }

    public static void startActivityForResult(Activity activity, int i2, PersonChangeData personChangeData, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65580, null, activity, i2, personChangeData, bool) == null) {
            Intent intent = new Intent(activity, PersonChangeActivity.class);
            intent.putExtra("data", personChangeData);
            intent.putExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, bool);
            activity.startActivityForResult(intent, i2);
        }
    }

    public static int z2(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, date)) == null) {
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
            int i7 = calendar.get(5);
            int i8 = i2 - i5;
            if (i3 <= i6) {
                if (i3 != i6 || i4 < i7) {
                    return i8 - 1;
                }
                return i8;
            }
            return i8;
        }
        return invokeL.intValue;
    }

    public final void A2(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, intent) == null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f).setUserGrowthTask(TbSingleton.getInstance().getUserGrowthTaskListData())));
        }
    }

    public final void c3(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, str) == null) && !TextUtils.isEmpty(str)) {
            this.N = true;
            this.B.R().setPhotoChanged(true);
            this.B.R().setNameShow(str);
            this.B.R().setNickNameLeftDays(90);
            this.m.setText(str);
            P2();
        }
    }

    public final void B2(Intent intent) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) == null) && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.b.parseJson(stringExtra);
            this.b.updateQuality();
            if (this.b.getChosedFiles() != null && this.b.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) TaskResponseData.ERROR_NO_TASK_OFFLINE_03, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.b.getChosedFiles().get(0).getFilePath(), 1.0f).setUserGrowthTask(TbSingleton.getInstance().getUserGrowthTaskListData())));
            }
            this.b.clear();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bundle) == null) {
            if (bundle != null) {
                this.C0 = bundle.getBoolean(PersonChangeActivityConfig.IS_COMPLETE_LOCAL_INFO);
            } else if (getIntent() != null) {
                this.C0 = getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_COMPLETE_LOCAL_INFO, false);
            }
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d07d1);
            adjustResizeForSoftInput();
            this.A = (InputMethodManager) getSystemService("input_method");
            v1();
            u1(bundle);
            if (bundle != null) {
                this.a = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
            } else {
                this.a = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
            }
            if (!this.C0) {
                TiebaStatic.log("c12204");
            } else {
                ww7.b();
            }
            registerListener(this.J0);
            registerListener(this.K0);
        }
    }

    public final void u1(Bundle bundle) {
        PersonChangeData personChangeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, bundle) == null) {
            this.I = new b0(this);
            if (bundle != null) {
                String string = bundle.getString("data");
                if (!StringUtils.isNull(string)) {
                    personChangeData = (PersonChangeData) OrmObject.objectWithJsonStr(string, PersonChangeData.class);
                } else {
                    personChangeData = null;
                }
            } else {
                personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
            }
            if (personChangeData == null) {
                personChangeData = new PersonChangeData();
            }
            PersonChangeModel personChangeModel = new PersonChangeModel(getPageContext(), personChangeData);
            this.B = personChangeModel;
            personChangeModel.S(this.H0);
            if (this.C0) {
                b3();
                this.j.setVisibility(8);
            }
            showLoadingView(this.U);
            this.B.loadData();
            Q2();
        }
    }

    public final vw7 C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.B0 == null) {
                this.B0 = new vw7(this);
            }
            return this.B0;
        }
        return (vw7) invokeV.objValue;
    }

    public final vw7.b D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new w(this);
        }
        return (vw7.b) invokeV.objValue;
    }

    public final void F2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c0 c0Var = this.F;
            if (c0Var != null) {
                c0Var.cancel();
            }
            this.E = null;
            c0 c0Var2 = new c0(this, null);
            this.F = c0Var2;
            c0Var2.execute(new Object[0]);
        }
    }

    public final void H2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || this.U == null || !this.C0) {
            return;
        }
        if (this.E0 == null) {
            this.E0 = new n(this);
        }
        this.U.getViewTreeObserver().addOnGlobalLayoutListener(this.E0);
    }

    public final void X2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            SafeHandler.getInst().postDelayed(new r(this), 200L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (this.C0) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
            } else {
                super.closeAnimation();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (this.C0) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
            } else {
                super.enterExitAnimation();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            hideNetRefreshView(this.U);
            showLoadingView(this.U);
            PersonChangeModel personChangeModel = this.B;
            if (personChangeModel != null) {
                personChangeModel.loadData();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onResume();
            if (this.Z && !TextUtils.isEmpty(this.a0)) {
                c3(this.a0);
                this.Z = false;
                this.a0 = "";
                G2();
            }
        }
    }

    public final void x2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048621, this) != null) || this.C0) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c14378");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        TiebaStatic.log(statisticItem);
    }

    public final void G2() {
        PersonChangeModel personChangeModel;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (personChangeModel = this.B) == null) {
            return;
        }
        boolean z3 = true;
        if (personChangeModel.P() && this.O != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.A0.setEnabled((!z2 || this.y.getText() == null || TextUtils.isEmpty(this.y.getText().toString().trim())) ? false : false);
    }

    public final void K2() {
        PersonChangeModel personChangeModel;
        String obj;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || (personChangeModel = this.B) == null || personChangeModel.R() == null || this.B.R().isNickNameInVerifying) {
            return;
        }
        Editable text = this.m.getText();
        if (text == null) {
            obj = "";
        } else {
            obj = text.toString();
        }
        this.a0 = obj;
        this.B.R().setTempNickName(this.a0);
        this.N = !this.a0.equals(this.B.R().getNameShow());
    }

    public final void N2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (!this.C0) {
                Intent intent = new Intent();
                if (this.a.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.B.R());
                } else {
                    intent.putExtra("data", this.B.R());
                }
                setResult(-1, intent);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921651, Boolean.TRUE));
            }
            M2();
            finish();
        }
    }

    public final void R2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.y.getVisibility() != 0) {
            this.p.setVisibility(8);
            this.y.setText(this.B.R().getIntro());
            EditText editText = this.y;
            editText.setSelection(editText.getText().length());
            this.y.setFocusableInTouchMode(true);
            this.y.requestFocus();
            ShowSoftKeyPad(this.A, this.y);
            L2(400);
        }
    }

    public void S2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
            n45 n45Var = new n45(getPageContext().getPageActivity());
            n45Var.k(R.string.obfuscated_res_0x7f0f0efb);
            n45Var.j(strArr, new o(this));
            n45Var.c(getPageContext());
            n45Var.m();
        }
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (this.K == null) {
                this.K = new u45(getPageContext());
                String string = getPageContext().getString(R.string.obfuscated_res_0x7f0f0c31);
                String string2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f0727);
                this.K.i(getString(R.string.obfuscated_res_0x7f0f0447), new String[]{string, string2}, new p(this, string, string2));
            }
            this.K.l();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.J0);
            c0 c0Var = this.F;
            if (c0Var != null) {
                c0Var.cancel();
            }
            d0 d0Var = this.G;
            if (d0Var != null) {
                d0Var.cancel();
            }
            ProgressBar progressBar = this.H;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            EditText editText = this.y;
            if (editText != null) {
                editText.addTextChangedListener(null);
            }
            qf5 qf5Var = this.c0;
            if (qf5Var != null) {
                qf5Var.s();
            }
            if (this.E0 != null && (viewGroup = this.U) != null) {
                viewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this.E0);
            }
            SafeHandler.getInst().removeCallbacks(this.G0);
            super.onDestroy();
        }
    }

    public final void w2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            if (UbsABTestHelper.isNickNameABTest()) {
                SharedPrefHelper.getInstance().putBoolean("key_has_show_nick_name_red_icon_tip", true);
                P2();
                this.m.setFocusableInTouchMode(true);
                this.m.requestFocus();
                this.m.setCursorVisible(true);
                ShowSoftKeyPad(this.A, this.m);
                return;
            }
            sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
        }
    }

    public final void M2() {
        PersonChangeModel personChangeModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (personChangeModel = this.B) != null && personChangeModel.R() != null) {
            lk5.d().h();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.B.R()));
        }
    }

    public final void U2() {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.y.getText().toString().replaceAll("\\s*", "").length() >= 500) {
                color = SkinManager.getColor(R.color.common_color_10159);
            } else {
                color = SkinManager.getColor(R.color.common_color_10077);
            }
            O2(color);
        }
    }

    public final boolean v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            K2();
            String str = this.a0;
            if (str == null || str.equals(this.B.R().getNameShow())) {
                return true;
            }
            if (rw5.c(this.a0) <= 20 && rw5.c(this.a0) >= 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void a3() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f0b3e, TBAlertConfig.OperateBtnStyle.SECONDARY);
            TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig(getString(R.string.obfuscated_res_0x7f0f0ef1), SkinManager.getColor(R.color.CAM_X0101), TBAlertConfig.OperateBtnStyle.BG_GRADIENT, null);
            operateBtnConfig2.setBgGradientColor(new String[]{"#2E62FF", "#9A2EFF"}).setBgGradientDirection(DrawableSelector.LEFT_RIGHT);
            PersonChangeModel personChangeModel = this.B;
            if (personChangeModel != null && personChangeModel.R() != null) {
                i2 = this.B.R().getNickNameLeftDays();
            } else {
                i2 = 0;
            }
            TBAlertBuilder cancelable = new TBAlertBuilder(getActivity()).setTitle(R.string.obfuscated_res_0x7f0f17cd).setDescStr(String.format(getString(R.string.obfuscated_res_0x7f0f0e38), Integer.valueOf(i2))).setDescGravity(3).setOperateBtn(operateBtnConfig, operateBtnConfig2).setCancelable(true);
            this.F0 = cancelable;
            AlertDialog show = cancelable.show();
            operateBtnConfig.setListener(new u(this, show));
            operateBtnConfig2.setListener(new v(this, show));
        }
    }

    public final void b3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.e.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.C.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, BdUtilHelper.getDimens(this, R.dimen.M_H_X009), layoutParams.rightMargin, layoutParams.bottomMargin);
            this.P.setVisibility(8);
            this.w0.setVisibility(8);
            this.d0.setVisibility(8);
            this.f.setVisibility(8);
            this.x0.setVisibility(0);
            this.y0.setVisibility(0);
            this.o.setOrientation(1);
            this.s0.setText(getString(R.string.obfuscated_res_0x7f0f103a));
            this.g.setText(getString(R.string.obfuscated_res_0x7f0f0c2d));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.y.getLayoutParams();
            layoutParams2.setMargins(0, BdUtilHelper.getDimens(this, R.dimen.tbds18), 0, 0);
            layoutParams2.height = BdUtilHelper.getDimens(this, R.dimen.tbds229);
            this.y.setGravity(51);
            this.y.setHint(getString(R.string.obfuscated_res_0x7f0f0bef));
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_mustfill, SkinManager.getColor(R.color.CAM_X0301), null);
            if (pureDrawable != null) {
                this.l.setCompoundDrawablePadding(BdUtilHelper.getDimens(this, R.dimen.M_W_X002));
                this.l.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
                this.q.setCompoundDrawablePadding(BdUtilHelper.getDimens(this, R.dimen.M_W_X002));
                this.q.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
                this.s0.setCompoundDrawablePadding(BdUtilHelper.getDimens(this, R.dimen.M_W_X002));
                this.s0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
                this.g.setCompoundDrawablePadding(BdUtilHelper.getDimens(this, R.dimen.M_W_X002));
                this.g.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
            }
            this.x0.setMustFill(true);
            this.x0.setDeleteForumListener(new b(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048607, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (i2 != 1001) {
                    if (i2 != 12002) {
                        if (i2 != 12014) {
                            if (i2 != 25067) {
                                if (i2 == 12009 || i2 == 12010) {
                                    this.B.R().setPhotoChanged(true);
                                    F2();
                                    this.M = true;
                                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                        SkinManager.setViewTextColor(this.d, R.color.navi_op_text, 1);
                                        return;
                                    } else {
                                        SkinManager.setViewTextColor(this.d, R.color.CAM_X0302, 1);
                                        return;
                                    }
                                }
                                return;
                            } else if (intent != null) {
                                ArrayList<SelectForumData> parcelableArrayListExtra = intent.getParcelableArrayListExtra(SelectForumConfig.KEY_SELECTED_INTEREST_FORUMS_RESPONSE);
                                PersonChangeModel personChangeModel = this.B;
                                if (personChangeModel != null && personChangeModel.R() != null) {
                                    this.M = true;
                                    this.B.R().setInterestForums(parcelableArrayListExtra);
                                    this.x0.i(this.B.R().getInterestedForums());
                                    G2();
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        }
                        this.B.R().setPhotoChanged(true);
                        if (intent != null) {
                            this.D.setImageBitmap(null);
                            this.D.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                        }
                        this.M = true;
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            SkinManager.setViewTextColor(this.d, R.color.navi_op_text, 1);
                        } else {
                            SkinManager.setViewTextColor(this.d, R.color.CAM_X0302, 1);
                        }
                    } else if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            A2(intent);
                        } else {
                            B2(intent);
                        }
                    }
                } else if (intent != null) {
                    long longExtra = intent.getLongExtra("constellation_birthday", 0L);
                    int intExtra = intent.getIntExtra("constellation_show_status", 0);
                    if (longExtra != this.B.R().getBirthdayTime() || intExtra != this.B.R().getBirthdayShowStatus()) {
                        this.B.R().setBirthdayShowStatus(intExtra);
                        this.B.R().setBirthdayTime(longExtra);
                        this.L = true;
                        this.M = true;
                        Date date = new Date(longExtra * 1000);
                        this.h0.setText(StringHelper.dateToConstellation(date));
                        if (this.B.R().getBirthdayShowStatus() == 2) {
                            this.j0.setText(getResources().getString(R.string.obfuscated_res_0x7f0f1075, Integer.valueOf(z2(date))));
                            this.j0.setVisibility(0);
                        } else {
                            this.j0.setVisibility(8);
                        }
                        SkinManager.setViewTextColor(this.h0, (int) R.color.CAM_X0105);
                    }
                }
            } else if (i3 == 0 && i2 == 12010) {
                SelectImageHelper.takePhoto(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            super.onChangeSkinType(i2);
            BDLayoutMode layoutMode = getLayoutMode();
            if (i2 == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            layoutMode.setNightMode(z2);
            getLayoutMode().onModeChanged(this.j);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.V, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.c.onChangeSkinType(getPageContext(), i2);
            this.D.refresh();
            SkinManager.setViewTextColor(this.r0, (int) R.color.CAM_X0109);
            WebPManager.setMaskDrawable(this.X, R.drawable.obfuscated_res_0x7f0809e6, null);
            WebPManager.setPureDrawable(this.W, R.drawable.obfuscated_res_0x7f080c48, R.color.CAM_X0108, null);
            TextView textView = this.d;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0302, 1);
            }
            EMManager.from(this.t0).setTextColor(R.color.CAM_X0108);
            EMManager.from(this.u0).setTextColor(R.color.CAM_X0108);
            EMManager.from(this.g).setTextColor(R.color.CAM_X0109);
            EMManager.from(this.h).setTextColor(R.color.CAM_X0109);
            EMManager.from(this.f0).setTextColor(R.color.CAM_X0109);
            EMManager.from(this.e0).setTextColor(R.color.CAM_X0109);
            EMManager.from(this.e).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.y).setTextColor(R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.s, R.drawable.icon_common_arrow16_right_n, R.color.CAM_X0109, null);
            WebPManager.setPureDrawable(this.i0, R.drawable.icon_common_arrow16_right_n, R.color.CAM_X0109, null);
            EMManager.from(this.z0).setTextColor(R.color.CAM_X0108);
            EMManager.from(this.A0).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X07).setBackGroundSelectorColor(R.color.CAM_X0303);
            this.x0.onChangeSkinType(getPageContext(), i2);
            EMManager.from(this.n).setTextColor(R.color.CAM_X0108).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0204);
            TBAlertBuilder tBAlertBuilder = this.F0;
            if (tBAlertBuilder != null) {
                tBAlertBuilder.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        PersonChangeData personChangeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, view2) == null) {
            super.onClick(view2);
            if (view2 != this.D && view2 != this.X) {
                if (view2 == this.i) {
                    K2();
                    y2();
                    if (!this.M && !this.N) {
                        finish();
                    }
                    if (!this.C0) {
                        if (this.a.booleanValue()) {
                            TiebaStatic.log("c10100");
                        } else {
                            TiebaStatic.log("c10101");
                        }
                    }
                    J2();
                    return;
                } else if (view2 == this.w) {
                    W2();
                    return;
                } else if (view2 == this.x) {
                    R2();
                    return;
                } else {
                    EditText editText = this.y;
                    if (view2 == editText) {
                        editText.setFocusableInTouchMode(true);
                        this.y.requestFocus();
                        ShowSoftKeyPad(this.A, this.y);
                        L2(400);
                        return;
                    } else if (view2 != this.R && view2 != this.m && view2 != this.S) {
                        if (view2 == this.P) {
                            PersonChangeModel personChangeModel = this.B;
                            if (personChangeModel != null && personChangeModel.R() != null && !StringUtils.isNull(this.B.R().getName())) {
                                return;
                            }
                            T2(TbadkCoreApplication.getCurrentAccountInfo());
                            return;
                        } else if (view2 == this.v0) {
                            if (this.C0) {
                                BdUtilHelper.hideSoftKeyPad(this, this.U);
                                C2().c(D2());
                                return;
                            }
                            PersonConstellationActivity.J1(getActivity(), this.B.R().getBirthdayTime(), this.B.R().getBirthdayShowStatus());
                            return;
                        } else if (view2 == this.w0) {
                            if (this.u0 != null && this.r0 != null) {
                                AndroidUtils.copyToClipboard(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f16a9), TbadkCoreApplication.getCurrentAccountNameShow(), this.u0.getText().toString()));
                                new BdTopToast(this, 3000).setIcon(true).setContent(getResources().getString(R.string.copy_success)).show(this.U);
                                if (this.C0) {
                                    return;
                                }
                                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COPY_CLIENT_NUMBER_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_param1", this.u0.getText().toString()).param("obj_locate", 2));
                                return;
                            }
                            return;
                        } else if (view2 == this.x0) {
                            PersonChangeModel personChangeModel2 = this.B;
                            if (personChangeModel2 != null && personChangeModel2.R() != null) {
                                SelectForumConfig selectForumConfig = new SelectForumConfig(this);
                                selectForumConfig.setSelectedInterestedForums(this.B.R().getInterestedForums());
                                selectForumConfig.setIsSelectInterestForum(true);
                                selectForumConfig.setRequestCode(25067);
                                selectForumConfig.setIntentAction(IntentAction.ActivityForResult);
                                selectForumConfig.start();
                                return;
                            }
                            return;
                        } else if (view2 == this.A0) {
                            ww7.a();
                            if (!this.M && !this.N) {
                                finish();
                                return;
                            } else {
                                J2();
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        x2();
                        if (Build.VERSION.SDK_INT < 19) {
                            Z2(getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f148a), false);
                            return;
                        } else if (NickNameActivitySwitch.isOn()) {
                            V2();
                            return;
                        } else if (this.B.R().isNickNameInVerifying) {
                            Z2(getString(R.string.obfuscated_res_0x7f0f0e39), false);
                            return;
                        } else if (this.B.R().getNickNameLeftDays() == 0) {
                            w2();
                            return;
                        } else {
                            a3();
                            return;
                        }
                    }
                }
            }
            PersonChangeModel personChangeModel3 = this.B;
            if (personChangeModel3 != null && (personChangeData = personChangeModel3.a) != null && !personChangeData.canModifyAvatar()) {
                if (!StringUtils.isNull(this.B.a.getCantModifyAvatarDesc())) {
                    BdUtilHelper.showLongToast(TbadkCoreApplication.getInst(), this.B.a.getCantModifyAvatarDesc());
                    return;
                } else {
                    BdUtilHelper.showLongToast(TbadkCoreApplication.getInst(), (int) R.string.obfuscated_res_0x7f0f1044);
                    return;
                }
            }
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.b0 == null) {
                this.b0 = new PermissionJudgePolicy();
            }
            this.b0.clearRequestPermissionList();
            this.b0.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.b0.startRequestPermission(pageActivity)) {
                return;
            }
            S2();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048612, this, i2, keyEvent)) == null) {
            if (!isLoadingViewAttached() && !isNetRefreshViewAttached()) {
                if (i2 == 4) {
                    E2();
                    this.I0.onClick(null);
                    return true;
                }
                return super.onKeyDown(i2, keyEvent);
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void u2() {
        PersonChangeModel personChangeModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && (personChangeModel = this.B) != null && personChangeModel.R() != null) {
            P2();
            this.D.startLoad(this.B.R().getPortrait(), 25, false);
            if (this.B.R().isNickNameInVerifying) {
                this.m.setText(this.B.R().nickNameInVerifying);
                this.m.setHint("");
                this.n.setVisibility(0);
            } else {
                this.m.setText(this.B.R().getNameShow());
                this.n.setVisibility(8);
            }
            PersonChangeModel personChangeModel2 = this.B;
            if (personChangeModel2 != null && personChangeModel2.R() != null && !TextUtils.isEmpty(this.B.R().getmTiebaId())) {
                this.u0.setText(this.B.R().getmTiebaId());
            } else {
                this.w0.setVisibility(8);
            }
            if (StringUtils.isNull(this.B.R().getName())) {
                this.r0.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f1683));
                this.P.setClickable(true);
                this.Q.setVisibility(0);
            } else {
                this.r0.setText(this.B.R().getName());
                this.P.setClickable(false);
                this.Q.setVisibility(8);
            }
            if (this.B.R().getIntro() != null && this.B.R().getIntro().length() > 0) {
                this.p.setText(this.B.R().getIntro());
            } else {
                this.p.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f00fb));
            }
            if (!bi.isEmpty(this.B.R().getIntro())) {
                this.y.setText(this.B.R().getIntro());
                TextView textView = this.t;
                textView.setText(this.B.R().getIntro().length() + "");
            } else {
                this.t.setText("0");
            }
            if (this.B.R().getSex() == 1) {
                this.O = 1;
                this.r.setText(R.string.obfuscated_res_0x7f0f0c31);
            } else if (this.B.R().getSex() == 2) {
                this.O = 2;
                this.r.setText(R.string.obfuscated_res_0x7f0f0727);
            } else {
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0110);
                this.r.setText(R.string.obfuscated_res_0x7f0f03f2);
            }
            if (this.B.R().getAlaId() > 0) {
                this.d0.setVisibility(0);
                TextView textView2 = this.e0;
                textView2.setText(this.B.R().getAlaId() + "");
            }
            this.g0.setText(getResources().getString(R.string.obfuscated_res_0x7f0f106a, this.B.R().getForumAge()));
            if (this.B.R().getBirthdayTime() != 0) {
                this.h0.setText(StringHelper.dateToConstellation(new Date(this.B.R().getBirthdayTime() * 1000)));
            }
            if (this.B.R().getBirthdayTime() != 0 && this.B.R().getUserAge() > 0 && (this.B.R().getBirthdayShowStatus() == 2 || this.C0)) {
                this.j0.setText(getResources().getString(R.string.obfuscated_res_0x7f0f1075, Integer.valueOf(this.B.R().getUserAge())));
                this.j0.setVisibility(0);
            } else {
                this.j0.setVisibility(8);
            }
            if (this.B.R().getBirthdayTime() == 0 && this.j0.getVisibility() == 8) {
                this.h0.setText(getString(R.string.obfuscated_res_0x7f0f03ec));
                SkinManager.setViewTextColor(this.h0, (int) R.color.CAM_X0110);
            }
            if (this.C0) {
                this.x0.h(getPageContext(), null, false);
                this.x0.setOnClickListener(this);
                G2();
            }
        }
    }

    public final void v1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.X = (ImageView) findViewById(R.id.obfuscated_res_0x7f091c6e);
            this.U = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0916a7);
            this.X.setOnClickListener(this);
            HeadImageView headImageView = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f091c67);
            this.D = headImageView;
            headImageView.setOnClickListener(this);
            this.j = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091a32);
            this.k = (ManualObservableScrollView) findViewById(R.id.obfuscated_res_0x7f091bb3);
            this.w = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091c29);
            this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f092187);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.c = navigationBar;
            View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.I0);
            this.f1152T = addCustomView;
            ImageView imageView = (ImageView) addCustomView.findViewById(R.id.widget_navi_back_button);
            this.V = imageView;
            imageView.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0471));
            this.f = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090bab);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f0926ff);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f092700);
            this.w.setOnClickListener(this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091176);
            this.x = linearLayout;
            linearLayout.setOnClickListener(this);
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f091941);
            this.m = editText;
            editText.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            this.m.setOnClickListener(this);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f091944);
            this.e = (EMTextView) findViewById(R.id.obfuscated_res_0x7f091643);
            this.C = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091c6d);
            this.q = (TextView) findViewById(R.id.obfuscated_res_0x7f092188);
            this.s = (ImageView) findViewById(R.id.obfuscated_res_0x7f092185);
            this.x0 = (InterestForumTagLayout) findViewById(R.id.obfuscated_res_0x7f09114a);
            this.y0 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0922ad);
            this.z0 = (TextView) findViewById(R.id.obfuscated_res_0x7f0922ac);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0922ae);
            this.A0 = textView;
            textView.setOnClickListener(this);
            this.o = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091178);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f091940);
            if (UbsABTestHelper.isNickNameABTest()) {
                this.m.setOnFocusChangeListener(new c(this));
                this.m.setOnEditorActionListener(new d(this));
                this.m.addTextChangedListener(new e(this));
            } else {
                this.m.setFocusableInTouchMode(false);
                this.m.setCursorVisible(false);
            }
            this.t0 = (TextView) findViewById(R.id.obfuscated_res_0x7f091bb8);
            this.w0 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091bb7);
            this.u0 = (TextView) findViewById(R.id.obfuscated_res_0x7f091c2b);
            this.W = (ImageView) findViewById(R.id.obfuscated_res_0x7f091bb6);
            this.w0.setOnClickListener(this);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091c27);
            this.R = findViewById;
            findViewById.setOnClickListener(this);
            ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f091943);
            this.S = imageView2;
            imageView2.setOnClickListener(this);
            this.r0 = (TextView) findViewById(R.id.obfuscated_res_0x7f092836);
            this.P = findViewById(R.id.obfuscated_res_0x7f091c21);
            this.Q = findViewById(R.id.obfuscated_res_0x7f092835);
            this.P.setOnClickListener(this);
            this.z = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09117a);
            this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f09117d);
            this.u = (TextView) findViewById(R.id.obfuscated_res_0x7f09117b);
            this.v = (TextView) findViewById(R.id.obfuscated_res_0x7f09117c);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f091175);
            this.p = textView2;
            textView2.setVisibility(8);
            EditText editText2 = (EditText) findViewById(R.id.obfuscated_res_0x7f09096f);
            this.y = editText2;
            editText2.setHint(getResources().getString(R.string.obfuscated_res_0x7f0f1063, "o(〃'▽'〃)o"));
            this.y.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            this.y.setOnTouchListener(new f(this));
            this.z.setVisibility(0);
            this.y.setOnClickListener(this);
            this.y.setOnFocusChangeListener(new g(this));
            this.y.addTextChangedListener(new h(this));
            this.H = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091093);
            m45 m45Var = new m45(getPageContext().getPageActivity());
            this.J = m45Var;
            m45Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f04c6));
            this.J.setPositiveButton(getPageContext().getString(R.string.alert_yes_button), new i(this));
            this.J.setNegativeButton(getPageContext().getString(R.string.obfuscated_res_0x7f0f03ce), new j(this));
            this.J.create(getPageContext());
            this.d0 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091b73);
            this.e0 = (TextView) findViewById(R.id.obfuscated_res_0x7f091b75);
            this.f0 = (TextView) findViewById(R.id.obfuscated_res_0x7f091b74);
            this.g0 = (TextView) findViewById(R.id.obfuscated_res_0x7f091bdd);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091bba);
            this.v0 = relativeLayout;
            relativeLayout.setOnClickListener(this);
            this.s0 = (TextView) findViewById(R.id.obfuscated_res_0x7f0907af);
            this.h0 = (TextView) findViewById(R.id.obfuscated_res_0x7f0907b0);
            this.i0 = (ImageView) findViewById(R.id.obfuscated_res_0x7f0907ac);
            this.j0 = (TextView) findViewById(R.id.obfuscated_res_0x7f09015f);
            this.k.post(new l(this));
            this.k.setScrollChangedListener(new m(this));
            H2();
        }
    }
}
