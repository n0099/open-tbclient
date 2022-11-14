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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
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
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.message.UserGrowthTaskRequestMessage;
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
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.ah;
import com.baidu.tieba.e95;
import com.baidu.tieba.fy6;
import com.baidu.tieba.gy6;
import com.baidu.tieba.in;
import com.baidu.tieba.jq8;
import com.baidu.tieba.jv4;
import com.baidu.tieba.k95;
import com.baidu.tieba.lv4;
import com.baidu.tieba.oi;
import com.baidu.tieba.ow7;
import com.baidu.tieba.personExtra.PersonChangeModel;
import com.baidu.tieba.pw4;
import com.baidu.tieba.py4;
import com.baidu.tieba.rq4;
import com.baidu.tieba.s45;
import com.baidu.tieba.sv4;
import com.baidu.tieba.tj5;
import com.baidu.tieba.uv4;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.widget.InterestForumTagLayout;
import com.baidu.tieba.widget.InterestForumTagView;
import com.baidu.tieba.widget.ManualObservableScrollView;
import com.baidu.tieba.xi;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InputMethodManager A;
    public fy6 A0;
    public PersonChangeModel B;
    public boolean B0;
    public FrameLayout C;
    public int C0;
    public HeadImageView D;
    public ViewTreeObserver.OnGlobalLayoutListener D0;
    public in E;
    public final Runnable E0;
    public b0 F;
    public PersonChangeModel.b F0;
    public c0 G;
    public final View.OnClickListener G0;
    public ProgressBar H;
    public CustomMessageListener H0;
    public DialogInterface.OnCancelListener I;
    public CustomMessageListener I0;
    public jv4 J;
    public sv4 K;
    public boolean L;
    public boolean M;
    public boolean N;
    public int O;
    public View P;
    public View Q;
    public View R;
    public ImageView S;
    public View T;
    public ViewGroup U;
    public ImageView V;
    public ImageView W;
    public ImageView X;
    public jv4 Y;
    public boolean Z;
    public Boolean a;
    public String a0;
    public final WriteImagesInfo b;
    public PermissionJudgePolicy b0;
    public NavigationBar c;
    public s45 c0;
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
    public TextView q0;
    public TextView r;
    public TextView r0;
    public ImageView s;
    public TextView s0;
    public TextView t;
    public TextView t0;
    public TextView u;
    public RelativeLayout u0;
    public TextView v;
    public LinearLayout v0;
    public RelativeLayout w;
    public InterestForumTagLayout w0;
    public LinearLayout x;
    public LinearLayout x0;
    public EditText y;
    public TextView y0;
    public LinearLayout z;
    public TextView z0;

    /* loaded from: classes5.dex */
    public class a implements InterestForumTagView.b {
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

        @Override // com.baidu.tieba.widget.InterestForumTagView.b
        public void a(SelectForumData selectForumData) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, selectForumData) != null) {
                return;
            }
            this.a.H2();
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements PersonChangeModel.b {
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
                this.a.v2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnFocusChangeListener {
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

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) && !z) {
                this.a.m.setFocusableInTouchMode(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 extends BdAsyncTask<Object, Integer, Bitmap> {
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

        public /* synthetic */ b0(PersonChangeActivity personChangeActivity, k kVar) {
            this(personChangeActivity);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.F = null;
            this.a.H.setVisibility(8);
            super.cancel(true);
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
                super.onPostExecute((b0) bitmap);
                this.a.F = null;
                this.a.H.setVisibility(8);
                if (bitmap != null) {
                    this.a.E = new in(bitmap, false, (String) null);
                    this.a.E.h(this.a.D);
                    k95.k().c(this.a.B.D().getPortrait(), this.a.E, true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements TextView.OnEditorActionListener {
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

    /* loaded from: classes5.dex */
    public class c0 extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public PersonChangeModel b;
        public final /* synthetic */ PersonChangeActivity c;

        public c0(PersonChangeActivity personChangeActivity, PersonChangeModel personChangeModel) {
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
                personChangeActivity.showLoadingDialog(personChangeActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f10e5), this.c.I);
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
                netWork.addPostData("sex", String.valueOf(this.b.D().getSex()));
                this.a.addPostData("intro", this.b.D().getIntro());
                this.a.addPostData("birthday_time", String.valueOf(this.b.D().getBirthdayTime()));
                this.a.addPostData("birthday_show_status", String.valueOf(this.b.D().getBirthdayShowStatus()));
                if (UbsABTestHelper.isNickNameABTest()) {
                    this.a.addPostData("need_keep_nickname_flag", "0");
                    this.a.addPostData(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
                    this.a.addPostData("is_business_account", this.b.D().getIsBusinessAccount());
                    if (!TextUtils.isEmpty(this.b.D().getTempNickName())) {
                        this.a.addPostData("nick_name", this.b.D().getTempNickName());
                    }
                } else {
                    this.a.addPostData("need_keep_nickname_flag", "1");
                }
                if (this.c.B0) {
                    this.a.addPostData("do_from", "local_user_profile");
                    this.a.addPostData("forum_data", this.b.D().getInterestedForumsJsonString());
                }
                this.a.postMultiNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    jq8.j();
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
                        this.c.O2();
                        this.c.Y2();
                    } else {
                        this.c.a3(this.a.getErrorString(), false);
                    }
                }
                super.onPostExecute((c0) str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements TextWatcher {
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

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, editable) != null) {
                return;
            }
            this.a.H2();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnTouchListener {
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

    /* loaded from: classes5.dex */
    public class f implements View.OnFocusChangeListener {
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

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) && !z) {
                this.a.y.setFocusableInTouchMode(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

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

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, editable) != null) || this.a.B.D() == null || editable.toString().replaceAll("\\s*", "").equals(this.a.B.D().getIntro())) {
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
                this.a.V2();
                if (length > 500) {
                    this.a.Z2(R.string.obfuscated_res_0x7f0f0d61, false);
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
                this.a.H2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements jv4.e {
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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
                this.a.z2();
                this.a.K2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements jv4.e {
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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
                if (this.a.B.D().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (this.a.a.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.a.B.D());
                    } else {
                        intent.putExtra("data", this.a.B.D());
                    }
                    this.a.setResult(-1, intent);
                    this.a.N2();
                }
                this.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k.scrollTo(0, 0);
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.x0 != null) {
                this.a.x0.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements ManualObservableScrollView.a {
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

        @Override // com.baidu.tieba.widget.ManualObservableScrollView.a
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
                PersonChangeActivity personChangeActivity = this.a;
                yi.z(personChangeActivity, personChangeActivity.U);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements ViewTreeObserver.OnGlobalLayoutListener {
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

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int height = this.a.U.getHeight();
                if (this.a.C0 != 0 && this.a.C0 != height) {
                    if (height > this.a.C0) {
                        ah.a().postDelayed(this.a.E0, 200L);
                    } else if (this.a.x0 != null) {
                        this.a.x0.setVisibility(8);
                    }
                }
                this.a.C0 = height;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements lv4.c {
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

        @Override // com.baidu.tieba.lv4.c
        public void a(lv4 lv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lv4Var, i, view2) == null) {
                if (i == 0) {
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.a.getPageContext().getPageActivity(), this.a.b.toJsonString(), true);
                    albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                    albumActivityConfig.setResourceType(2);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                } else if (i == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.a.getPageContext().getPageActivity(), 12014)));
                }
                lv4Var.e();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements uv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PersonChangeActivity c;

        public o(PersonChangeActivity personChangeActivity, String str, String str2) {
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

        @Override // com.baidu.tieba.uv4.e
        public void n0(uv4 uv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, uv4Var, i, view2) == null) {
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
                if (this.c.O != this.c.B.D().getSex()) {
                    this.c.M = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        SkinManager.setViewTextColor(this.c.d, R.color.navi_op_text, 1);
                    } else {
                        SkinManager.setViewTextColor(this.c.d, R.color.CAM_X0302, 1);
                    }
                }
                this.c.H2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        public p(PersonChangeActivity personChangeActivity) {
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
                if (this.a.B.D().getSex() != this.a.O) {
                    this.a.L = true;
                }
                this.a.L2();
                if (!this.a.B0 && (this.a.L || this.a.N)) {
                    this.a.J.show();
                    return;
                }
                if (this.a.B != null && this.a.B.D().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (this.a.a.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.a.B.D());
                    } else {
                        intent.putExtra("data", this.a.B.D());
                    }
                    this.a.N2();
                    this.a.setResult(-1, intent);
                }
                this.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Activity currentActivity;
            String string;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && currentActivity.findViewById(16908290) != null) {
                if (this.a.B0) {
                    string = currentActivity.getString(R.string.obfuscated_res_0x7f0f0432);
                } else {
                    string = currentActivity.getString(R.string.obfuscated_res_0x7f0f0398);
                }
                if (this.a.m != null && this.a.m.getText() != null && this.a.B != null && this.a.B.D() != null && !this.a.m.getText().equals(this.a.B.D().getNameShow())) {
                    string = currentActivity.getString(R.string.obfuscated_res_0x7f0f0420);
                    if (!TbSingleton.getInstance().isUserGrowthTaskCompleted(UserGrowthTaskRequestMessage.SET_USER_NICK)) {
                        MessageManager.getInstance().sendMessage(new UserGrowthTaskRequestMessage(UserGrowthTaskRequestMessage.SET_USER_NICK));
                    }
                }
                if (BdToastHelper.getBdToastData().getContent() == null) {
                    BdTopToast bdTopToast = new BdTopToast(currentActivity);
                    bdTopToast.h(true);
                    bdTopToast.g(string);
                    bdTopToast.i((ViewGroup) currentActivity.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(PersonChangeActivity personChangeActivity, int i) {
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

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (this.a.B != null && this.a.B.D() != null && personChangeData != null) {
                    this.a.B.D().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    this.a.B.D().setMem(personChangeData.getMen());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Dialog a;
        public final /* synthetic */ PersonChangeActivity b;

        public t(PersonChangeActivity personChangeActivity, Dialog dialog) {
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
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements fy6.b {
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

        @Override // com.baidu.tieba.fy6.b
        public void a(Date date, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, date, j) == null) {
                this.a.B.D().setBirthdayTime(j);
                this.a.h0.setText(StringHelper.dateToConstellation(date));
                this.a.j0.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e9b, Integer.valueOf(PersonChangeActivity.A2(date))));
                this.a.j0.setVisibility(0);
                SkinManager.setViewTextColor(this.a.h0, (int) R.color.CAM_X0105);
                this.a.H2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v implements jv4.e {
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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.getPageContext().getPageActivity(), null, ow7.a(), true)));
                jv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements jv4.e {
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

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements s45.e {
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

        @Override // com.baidu.tieba.s45.e
        public void a(AccountData accountData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, accountData) != null) || accountData == null) {
                return;
            }
            this.a.J2(accountData.getAccount());
        }
    }

    /* loaded from: classes5.dex */
    public class y implements Runnable {
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

    /* loaded from: classes5.dex */
    public class z implements DialogInterface.OnCancelListener {
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
        this.E0 = new k(this);
        this.F0 = new a0(this);
        this.G0 = new p(this);
        this.H0 = new r(this, 2921033);
        this.I0 = new s(this, 2921061);
    }

    public final void F2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.y.getVisibility() == 0 && this.y.isFocused()) {
                String replaceAll = this.y.getText().toString().replaceAll("\\s*", "");
                if (replaceAll.length() > 0) {
                    this.p.setText(replaceAll);
                } else {
                    this.p.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f00cf));
                }
                if (this.B.D().getIntro() == null || !this.B.D().getIntro().equals(replaceAll)) {
                    this.L = true;
                }
                this.B.D().setIntro(replaceAll);
                HidenSoftKeyPad(this.A, this.y);
            } else if (this.m.getVisibility() == 0 && this.m.isFocused()) {
                HidenSoftKeyPad(this.A, this.m);
            }
        }
    }

    public final void K2() {
        PersonChangeModel personChangeModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (personChangeModel = this.B) != null && personChangeModel.D() != null) {
            F2();
            if (UbsABTestHelper.isNickNameABTest() && !w2()) {
                Z2(R.string.obfuscated_res_0x7f0f0ea4, false);
            } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                Z2(R.string.obfuscated_res_0x7f0f0c81, false);
            } else {
                this.B.D().setIntro(this.y.getText().toString().replaceAll("\\s*", ""));
                this.B.D().setSex(this.O);
                if (this.G == null) {
                    c0 c0Var = new c0(this, this.B);
                    this.G = c0Var;
                    c0Var.setPriority(3);
                    this.G.execute(new String[0]);
                }
            }
        }
    }

    public final void Q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.S.getLayoutParams();
            if (UbsABTestHelper.isNickNameABTest()) {
                layoutParams.width = UtilHelper.getDimenPixelSize(R.dimen.tbds21);
                layoutParams.height = UtilHelper.getDimenPixelSize(R.dimen.tbds21);
                this.S.setImageResource(R.drawable.obfuscated_res_0x7f080663);
                if (this.B.D().getNickNameLeftDays() == 0 && !py4.k().h("key_has_show_nick_name_red_icon_tip", false)) {
                    this.S.setVisibility(0);
                } else {
                    this.S.setVisibility(4);
                }
            } else {
                layoutParams.width = -2;
                layoutParams.height = -2;
                this.S.setImageResource(R.drawable.icon_arrow_more_gray);
                if (!NickNameActivitySwitch.isOn() && this.B.D().getNickNameLeftDays() != 0) {
                    this.S.setVisibility(8);
                } else {
                    this.S.setVisibility(0);
                }
            }
            this.S.requestLayout();
        }
    }

    public final void R2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            String string = getResources().getString(R.string.obfuscated_res_0x7f0f0b83);
            if (this.B0) {
                string = getString(R.string.obfuscated_res_0x7f0f0a7b);
            }
            this.c.setCenterTextTitle(string);
            if (this.B0) {
                return;
            }
            View addCustomView = this.c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0640, (View.OnClickListener) null);
            this.i = addCustomView;
            TextView textView = (TextView) addCustomView.findViewById(R.id.obfuscated_res_0x7f091c92);
            this.d = textView;
            textView.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f10d6));
            SkinManager.setViewTextColor(this.d, R.color.navi_op_text, 1);
            this.i.setOnClickListener(this);
        }
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.Y == null) {
                View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0738, (ViewGroup) null);
                jv4 jv4Var = new jv4(getPageContext().getPageActivity());
                this.Y = jv4Var;
                jv4Var.setContentView(inflate);
                this.Y.setPositiveButton(R.string.obfuscated_res_0x7f0f0c92, new v(this));
                this.Y.setNegativeButton(R.string.obfuscated_res_0x7f0f0c91, new w(this));
                this.Y.create(getPageContext());
                SkinManager.setViewTextColor(inflate.findViewById(R.id.obfuscated_res_0x7f0916f9), (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(inflate.findViewById(R.id.obfuscated_res_0x7f0916f8), (int) R.color.common_color_10122);
            }
            this.Y.show();
        }
    }

    public final void b3() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f09d4, TBAlertConfig.OperateBtnStyle.MAIN);
            PersonChangeModel personChangeModel = this.B;
            if (personChangeModel != null && personChangeModel.D() != null) {
                i2 = this.B.D().getNickNameLeftDays();
            } else {
                i2 = 0;
            }
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(getActivity());
            tBAlertBuilder.t(R.string.obfuscated_res_0x7f0f155e);
            tBAlertBuilder.o(String.format(getString(R.string.obfuscated_res_0x7f0f0c93), Integer.valueOf(i2)));
            tBAlertBuilder.r(aVar);
            tBAlertBuilder.h(true);
            aVar.a(new t(this, tBAlertBuilder.w()));
        }
    }

    public final void z2() {
        String obj;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048622, this) != null) || this.B0) {
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
        statisticItem.param("obj_param1", !obj.equals(this.B.D().getNameShow()));
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, !this.y.toString().replaceAll("\\s*", "").equals(this.B.D().getIntro()));
        TiebaStatic.log(statisticItem);
    }

    public final void J2(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        this.q0.setText(str);
        this.P.setClickable(false);
        this.Q.setVisibility(8);
    }

    public final void M2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.k.postDelayed(new y(this), i2);
        }
    }

    public final void P2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.t.setTextColor(i2);
            this.u.setTextColor(i2);
            this.v.setTextColor(i2);
        }
    }

    public final void U2(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, accountData) == null) {
            if (this.c0 == null) {
                s45 s45Var = new s45(this);
                this.c0 = s45Var;
                s45Var.w(new x(this));
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
            if (this.B.D() != null) {
                bundle.putString("data", OrmObject.jsonStrWithObject(this.B.D()));
            }
        }
    }

    public static int A2(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, date)) == null) {
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

    public void Z2(int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            a3(getString(i2), z2);
        }
    }

    public void a3(String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048601, this, str, z2) == null) {
            BdTopToast bdTopToast = new BdTopToast(this);
            bdTopToast.h(z2);
            bdTopToast.g(str);
            bdTopToast.i((ViewGroup) findViewById(16908290));
        }
    }

    public static void startActivityForResult(Activity activity, int i2, PersonChangeData personChangeData, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65583, null, activity, i2, personChangeData, bool) == null) {
            Intent intent = new Intent(activity, PersonChangeActivity.class);
            intent.putExtra("data", personChangeData);
            intent.putExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, bool);
            activity.startActivityForResult(intent, i2);
        }
    }

    public final void B2(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, intent) == null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f).setUserGrowthTask(TbSingleton.getInstance().getUserGrowthTaskListData())));
        }
    }

    public final void d3(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, str) == null) && !TextUtils.isEmpty(str)) {
            this.N = true;
            this.B.D().setPhotoChanged(true);
            this.B.D().setNameShow(str);
            this.B.D().setNickNameLeftDays(90);
            this.m.setText(str);
            Q2();
        }
    }

    public final void C2(Intent intent) {
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
                this.B0 = bundle.getBoolean(PersonChangeActivityConfig.IS_COMPLETE_LOCAL_INFO);
            } else if (getIntent() != null) {
                this.B0 = getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_COMPLETE_LOCAL_INFO, false);
            }
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0721);
            adjustResizeForSoftInput();
            this.A = (InputMethodManager) getSystemService("input_method");
            y1();
            x1(bundle);
            if (bundle != null) {
                this.a = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
            } else {
                this.a = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
            }
            if (!this.B0) {
                TiebaStatic.log("c12204");
            } else {
                gy6.b();
            }
            registerListener(this.H0);
            registerListener(this.I0);
        }
    }

    public final void x1(Bundle bundle) {
        PersonChangeData personChangeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bundle) == null) {
            this.I = new z(this);
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
            personChangeModel.E(this.F0);
            if (this.B0) {
                c3();
                this.j.setVisibility(8);
            }
            showLoadingView(this.U);
            this.B.loadData();
            R2();
        }
    }

    public final fy6 D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.A0 == null) {
                this.A0 = new fy6(this);
            }
            return this.A0;
        }
        return (fy6) invokeV.objValue;
    }

    public final fy6.b E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new u(this);
        }
        return (fy6.b) invokeV.objValue;
    }

    public final void G2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b0 b0Var = this.F;
            if (b0Var != null) {
                b0Var.cancel();
            }
            this.E = null;
            b0 b0Var2 = new b0(this, null);
            this.F = b0Var2;
            b0Var2.execute(new Object[0]);
        }
    }

    public final void I2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || this.U == null || !this.B0) {
            return;
        }
        if (this.D0 == null) {
            this.D0 = new m(this);
        }
        this.U.getViewTreeObserver().addOnGlobalLayoutListener(this.D0);
    }

    public final void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            ah.a().postDelayed(new q(this), 200L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (this.B0) {
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
            if (this.B0) {
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
                d3(this.a0);
                this.Z = false;
                this.a0 = "";
                H2();
            }
        }
    }

    public final void y2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048621, this) != null) || this.B0) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c14378");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        TiebaStatic.log(statisticItem);
    }

    public final void H2() {
        PersonChangeModel personChangeModel;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (personChangeModel = this.B) == null) {
            return;
        }
        boolean z3 = true;
        if (personChangeModel.B() && this.O != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.z0.setEnabled((!z2 || this.y.getText() == null || TextUtils.isEmpty(this.y.getText().toString().trim())) ? false : false);
    }

    public final void L2() {
        PersonChangeModel personChangeModel;
        String obj;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || (personChangeModel = this.B) == null || personChangeModel.D() == null || this.B.D().isNickNameInVerifying) {
            return;
        }
        Editable text = this.m.getText();
        if (text == null) {
            obj = "";
        } else {
            obj = text.toString();
        }
        this.a0 = obj;
        this.B.D().setTempNickName(this.a0);
        this.N = !this.a0.equals(this.B.D().getNameShow());
    }

    public final void O2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (!this.B0) {
                Intent intent = new Intent();
                if (this.a.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.B.D());
                } else {
                    intent.putExtra("data", this.B.D());
                }
                setResult(-1, intent);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921651, Boolean.TRUE));
            }
            N2();
            finish();
        }
    }

    public final void S2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.y.getVisibility() != 0) {
            this.p.setVisibility(8);
            this.y.setText(this.B.D().getIntro());
            EditText editText = this.y;
            editText.setSelection(editText.getText().length());
            this.y.setFocusableInTouchMode(true);
            this.y.requestFocus();
            ShowSoftKeyPad(this.A, this.y);
            M2(400);
        }
    }

    public void T2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            String[] strArr = {getPageContext().getString(R.string.obfuscated_res_0x7f0f039a), getPageContext().getString(R.string.obfuscated_res_0x7f0f039e)};
            lv4 lv4Var = new lv4(getPageContext().getPageActivity());
            lv4Var.k(R.string.obfuscated_res_0x7f0f0d4b);
            lv4Var.j(strArr, new n(this));
            lv4Var.c(getPageContext());
            lv4Var.m();
        }
    }

    public final void X2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (this.K == null) {
                this.K = new sv4(getPageContext());
                String string = getPageContext().getString(R.string.obfuscated_res_0x7f0f0abb);
                String string2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f062f);
                this.K.i(getString(R.string.obfuscated_res_0x7f0f03db), new String[]{string, string2}, new o(this, string, string2));
            }
            this.K.k();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.H0);
            b0 b0Var = this.F;
            if (b0Var != null) {
                b0Var.cancel();
            }
            c0 c0Var = this.G;
            if (c0Var != null) {
                c0Var.cancel();
            }
            ProgressBar progressBar = this.H;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            EditText editText = this.y;
            if (editText != null) {
                editText.addTextChangedListener(null);
            }
            s45 s45Var = this.c0;
            if (s45Var != null) {
                s45Var.s();
            }
            if (this.D0 != null && (viewGroup = this.U) != null) {
                viewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this.D0);
            }
            ah.a().removeCallbacks(this.E0);
            super.onDestroy();
        }
    }

    public final void x2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (UbsABTestHelper.isNickNameABTest()) {
                py4.k().u("key_has_show_nick_name_red_icon_tip", true);
                Q2();
                this.m.setFocusableInTouchMode(true);
                this.m.requestFocus();
                this.m.setCursorVisible(true);
                ShowSoftKeyPad(this.A, this.m);
                return;
            }
            sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
        }
    }

    public final void N2() {
        PersonChangeModel personChangeModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (personChangeModel = this.B) != null && personChangeModel.D() != null) {
            e95.d().h();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.B.D()));
        }
    }

    public final void V2() {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.y.getText().toString().replaceAll("\\s*", "").length() >= 500) {
                color = SkinManager.getColor(R.color.common_color_10159);
            } else {
                color = SkinManager.getColor(R.color.common_color_10077);
            }
            P2(color);
        }
    }

    public final boolean w2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            L2();
            String str = this.a0;
            if (str == null || str.equals(this.B.D().getNameShow())) {
                return true;
            }
            if (tj5.b(this.a0) <= 20 && tj5.b(this.a0) >= 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.e.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.C.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, yi.g(this, R.dimen.M_H_X009), layoutParams.rightMargin, layoutParams.bottomMargin);
            this.P.setVisibility(8);
            this.v0.setVisibility(8);
            this.d0.setVisibility(8);
            this.f.setVisibility(8);
            this.w0.setVisibility(0);
            this.x0.setVisibility(0);
            this.o.setOrientation(1);
            this.r0.setText(getString(R.string.obfuscated_res_0x7f0f0e5a));
            this.g.setText(getString(R.string.obfuscated_res_0x7f0f0ab7));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.y.getLayoutParams();
            layoutParams2.setMargins(0, yi.g(this, R.dimen.tbds18), 0, 0);
            layoutParams2.height = yi.g(this, R.dimen.tbds229);
            this.y.setGravity(51);
            this.y.setHint(getString(R.string.obfuscated_res_0x7f0f0a7c));
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080996, SkinManager.getColor(R.color.CAM_X0301), null);
            if (pureDrawable != null) {
                this.l.setCompoundDrawablePadding(yi.g(this, R.dimen.M_W_X002));
                this.l.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
                this.q.setCompoundDrawablePadding(yi.g(this, R.dimen.M_W_X002));
                this.q.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
                this.r0.setCompoundDrawablePadding(yi.g(this, R.dimen.M_W_X002));
                this.r0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
                this.g.setCompoundDrawablePadding(yi.g(this, R.dimen.M_W_X002));
                this.g.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
            }
            this.w0.setMustFill(true);
            this.w0.setDeleteForumListener(new a(this));
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
                                    this.B.D().setPhotoChanged(true);
                                    G2();
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
                                if (personChangeModel != null && personChangeModel.D() != null) {
                                    this.M = true;
                                    this.B.D().setInterestForums(parcelableArrayListExtra);
                                    this.w0.i(this.B.D().getInterestedForums());
                                    H2();
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        }
                        this.B.D().setPhotoChanged(true);
                        if (intent != null) {
                            this.D.setImageBitmap(null);
                            this.D.K(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                        }
                        this.M = true;
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            SkinManager.setViewTextColor(this.d, R.color.navi_op_text, 1);
                        } else {
                            SkinManager.setViewTextColor(this.d, R.color.CAM_X0302, 1);
                        }
                    } else if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            B2(intent);
                        } else {
                            C2(intent);
                        }
                    }
                } else if (intent != null) {
                    long longExtra = intent.getLongExtra("constellation_birthday", 0L);
                    int intExtra = intent.getIntExtra("constellation_show_status", 0);
                    if (longExtra != this.B.D().getBirthdayTime() || intExtra != this.B.D().getBirthdayShowStatus()) {
                        this.B.D().setBirthdayShowStatus(intExtra);
                        this.B.D().setBirthdayTime(longExtra);
                        this.L = true;
                        this.M = true;
                        Date date = new Date(longExtra * 1000);
                        this.h0.setText(StringHelper.dateToConstellation(date));
                        if (this.B.D().getBirthdayShowStatus() == 2) {
                            this.j0.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0e9b, Integer.valueOf(A2(date))));
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
            rq4 layoutMode = getLayoutMode();
            if (i2 == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            layoutMode.l(z2);
            getLayoutMode().k(this.j);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.V, R.drawable.obfuscated_res_0x7f080a32, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.c.onChangeSkinType(getPageContext(), i2);
            this.D.refresh();
            SkinManager.setViewTextColor(this.q0, (int) R.color.CAM_X0109);
            WebPManager.setMaskDrawable(this.X, R.drawable.obfuscated_res_0x7f080823, null);
            WebPManager.setPureDrawable(this.W, R.drawable.obfuscated_res_0x7f080a71, R.color.CAM_X0108, null);
            TextView textView = this.d;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0302, 1);
            }
            pw4.d(this.s0).v(R.color.CAM_X0108);
            pw4.d(this.t0).v(R.color.CAM_X0108);
            pw4.d(this.g).v(R.color.CAM_X0109);
            pw4.d(this.h).v(R.color.CAM_X0109);
            pw4.d(this.f0).v(R.color.CAM_X0109);
            pw4.d(this.e0).v(R.color.CAM_X0109);
            pw4 d2 = pw4.d(this.e);
            d2.A(R.string.F_X02);
            d2.v(R.color.CAM_X0105);
            pw4.d(this.y).v(R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.s, R.drawable.icon_common_arrow16_right_n, R.color.CAM_X0109, null);
            WebPManager.setPureDrawable(this.i0, R.drawable.icon_common_arrow16_right_n, R.color.CAM_X0109, null);
            pw4.d(this.y0).v(R.color.CAM_X0108);
            pw4 d3 = pw4.d(this.z0);
            d3.v(R.color.CAM_X0101);
            d3.n(R.string.J_X07);
            d3.h(R.color.CAM_X0303);
            this.w0.onChangeSkinType(getPageContext(), i2);
            pw4 d4 = pw4.d(this.n);
            d4.v(R.color.CAM_X0108);
            d4.n(R.string.J_X04);
            d4.f(R.color.CAM_X0204);
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
                    L2();
                    z2();
                    if (!this.M && !this.N) {
                        finish();
                    }
                    if (!this.B0) {
                        if (this.a.booleanValue()) {
                            TiebaStatic.log("c10100");
                        } else {
                            TiebaStatic.log("c10101");
                        }
                    }
                    K2();
                    return;
                } else if (view2 == this.w) {
                    X2();
                    return;
                } else if (view2 == this.x) {
                    S2();
                    return;
                } else {
                    EditText editText = this.y;
                    if (view2 == editText) {
                        editText.setFocusableInTouchMode(true);
                        this.y.requestFocus();
                        ShowSoftKeyPad(this.A, this.y);
                        M2(400);
                        return;
                    } else if (view2 != this.R && view2 != this.m && view2 != this.S) {
                        if (view2 == this.P) {
                            PersonChangeModel personChangeModel = this.B;
                            if (personChangeModel != null && personChangeModel.D() != null && !StringUtils.isNull(this.B.D().getName())) {
                                return;
                            }
                            U2(TbadkCoreApplication.getCurrentAccountInfo());
                            return;
                        } else if (view2 == this.u0) {
                            if (this.B0) {
                                yi.z(this, this.U);
                                D2().f(E2());
                                return;
                            }
                            PersonConstellationActivity.K1(getActivity(), this.B.D().getBirthdayTime(), this.B.D().getBirthdayShowStatus());
                            return;
                        } else if (view2 == this.v0) {
                            if (this.t0 != null && this.q0 != null) {
                                oi.a(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f148b), TbadkCoreApplication.getCurrentAccountNameShow(), this.t0.getText().toString()));
                                BdTopToast bdTopToast = new BdTopToast(this, 3000);
                                bdTopToast.h(true);
                                bdTopToast.g(getResources().getString(R.string.obfuscated_res_0x7f0f0460));
                                bdTopToast.i(this.U);
                                if (this.B0) {
                                    return;
                                }
                                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COPY_CLIENT_NUMBER_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_param1", this.t0.getText().toString()).param("obj_locate", 2));
                                return;
                            }
                            return;
                        } else if (view2 == this.w0) {
                            PersonChangeModel personChangeModel2 = this.B;
                            if (personChangeModel2 != null && personChangeModel2.D() != null) {
                                SelectForumConfig selectForumConfig = new SelectForumConfig(this);
                                selectForumConfig.setSelectedInterestedForums(this.B.D().getInterestedForums());
                                selectForumConfig.setIsSelectInterestForum(true);
                                selectForumConfig.setRequestCode(25067);
                                selectForumConfig.setIntentAction(IntentAction.ActivityForResult);
                                selectForumConfig.start();
                                return;
                            }
                            return;
                        } else if (view2 == this.z0) {
                            gy6.a();
                            if (!this.M && !this.N) {
                                finish();
                                return;
                            } else {
                                K2();
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        y2();
                        if (Build.VERSION.SDK_INT < 19) {
                            a3(getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f127d), false);
                            return;
                        } else if (NickNameActivitySwitch.isOn()) {
                            W2();
                            return;
                        } else if (this.B.D().isNickNameInVerifying) {
                            a3(getString(R.string.obfuscated_res_0x7f0f0c94), false);
                            return;
                        } else if (this.B.D().getNickNameLeftDays() == 0) {
                            x2();
                            return;
                        } else {
                            b3();
                            return;
                        }
                    }
                }
            }
            PersonChangeModel personChangeModel3 = this.B;
            if (personChangeModel3 != null && (personChangeData = personChangeModel3.a) != null && !personChangeData.canModifyAvatar()) {
                if (!StringUtils.isNull(this.B.a.getCantModifyAvatarDesc())) {
                    yi.M(TbadkCoreApplication.getInst(), this.B.a.getCantModifyAvatarDesc());
                    return;
                } else {
                    yi.L(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0e64);
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
            T2();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048612, this, i2, keyEvent)) == null) {
            if (!isLoadingViewAttached() && !isNetRefreshViewAttached()) {
                if (i2 == 4) {
                    F2();
                    this.G0.onClick(null);
                    return true;
                }
                return super.onKeyDown(i2, keyEvent);
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void v2() {
        PersonChangeModel personChangeModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && (personChangeModel = this.B) != null && personChangeModel.D() != null) {
            Q2();
            this.D.K(this.B.D().getPortrait(), 25, false);
            if (this.B.D().isNickNameInVerifying) {
                this.m.setText(this.B.D().nickNameInVerifying);
                this.m.setHint("");
                this.n.setVisibility(0);
            } else {
                this.m.setText(this.B.D().getNameShow());
                this.n.setVisibility(8);
            }
            PersonChangeModel personChangeModel2 = this.B;
            if (personChangeModel2 != null && personChangeModel2.D() != null && !TextUtils.isEmpty(this.B.D().getmTiebaId())) {
                this.t0.setText(this.B.D().getmTiebaId());
            } else {
                this.v0.setVisibility(8);
            }
            if (StringUtils.isNull(this.B.D().getName())) {
                this.q0.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f1467));
                this.P.setClickable(true);
                this.Q.setVisibility(0);
            } else {
                this.q0.setText(this.B.D().getName());
                this.P.setClickable(false);
                this.Q.setVisibility(8);
            }
            if (this.B.D().getIntro() != null && this.B.D().getIntro().length() > 0) {
                this.p.setText(this.B.D().getIntro());
            } else {
                this.p.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f00cf));
            }
            if (!xi.isEmpty(this.B.D().getIntro())) {
                this.y.setText(this.B.D().getIntro());
                TextView textView = this.t;
                textView.setText(this.B.D().getIntro().length() + "");
            } else {
                this.t.setText("0");
            }
            if (this.B.D().getSex() == 1) {
                this.O = 1;
                this.r.setText(R.string.obfuscated_res_0x7f0f0abb);
            } else if (this.B.D().getSex() == 2) {
                this.O = 2;
                this.r.setText(R.string.obfuscated_res_0x7f0f062f);
            } else {
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0110);
                this.r.setText(R.string.obfuscated_res_0x7f0f039b);
            }
            if (this.B.D().getAlaId() > 0) {
                this.d0.setVisibility(0);
                TextView textView2 = this.e0;
                textView2.setText(this.B.D().getAlaId() + "");
            }
            this.g0.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0e8a, this.B.D().getForumAge()));
            if (this.B.D().getBirthdayTime() != 0) {
                this.h0.setText(StringHelper.dateToConstellation(new Date(this.B.D().getBirthdayTime() * 1000)));
            }
            if (this.B.D().getBirthdayTime() != 0 && this.B.D().getUserAge() > 0 && (this.B.D().getBirthdayShowStatus() == 2 || this.B0)) {
                this.j0.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0e9b, Integer.valueOf(this.B.D().getUserAge())));
                this.j0.setVisibility(0);
            } else {
                this.j0.setVisibility(8);
            }
            if (this.B.D().getBirthdayTime() == 0 && this.j0.getVisibility() == 8) {
                this.h0.setText(getString(R.string.obfuscated_res_0x7f0f0395));
                SkinManager.setViewTextColor(this.h0, (int) R.color.CAM_X0110);
            }
            if (this.B0) {
                this.w0.h(getPageContext(), null, false);
                this.w0.setOnClickListener(this);
                H2();
            }
        }
    }

    public final void y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.X = (ImageView) findViewById(R.id.obfuscated_res_0x7f091a0e);
            this.U = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0914bf);
            this.X.setOnClickListener(this);
            HeadImageView headImageView = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f091a07);
            this.D = headImageView;
            headImageView.setOnClickListener(this);
            this.j = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0917cc);
            this.k = (ManualObservableScrollView) findViewById(R.id.obfuscated_res_0x7f091954);
            this.w = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0919cc);
            this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f091eca);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f092613);
            this.c = navigationBar;
            View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d093c, this.G0);
            this.T = addCustomView;
            ImageView imageView = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f0926cf);
            this.V = imageView;
            imageView.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0402));
            this.f = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090a65);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f0923e9);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f0923ea);
            this.w.setOnClickListener(this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090fa6);
            this.x = linearLayout;
            linearLayout.setOnClickListener(this);
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f0916f4);
            this.m = editText;
            editText.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            this.m.setOnClickListener(this);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f0916f7);
            this.e = (EMTextView) findViewById(R.id.obfuscated_res_0x7f09145f);
            this.C = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091a0d);
            this.q = (TextView) findViewById(R.id.obfuscated_res_0x7f091ecb);
            this.s = (ImageView) findViewById(R.id.obfuscated_res_0x7f091ec8);
            this.w0 = (InterestForumTagLayout) findViewById(R.id.obfuscated_res_0x7f090f7a);
            this.x0 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091fd1);
            this.y0 = (TextView) findViewById(R.id.obfuscated_res_0x7f091fd0);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091fd2);
            this.z0 = textView;
            textView.setOnClickListener(this);
            this.o = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090fa8);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f0916f3);
            if (UbsABTestHelper.isNickNameABTest()) {
                this.m.setOnFocusChangeListener(new b(this));
                this.m.setOnEditorActionListener(new c(this));
                this.m.addTextChangedListener(new d(this));
            } else {
                this.m.setFocusableInTouchMode(false);
                this.m.setCursorVisible(false);
            }
            this.s0 = (TextView) findViewById(R.id.obfuscated_res_0x7f091959);
            this.v0 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091958);
            this.t0 = (TextView) findViewById(R.id.obfuscated_res_0x7f0919ce);
            this.W = (ImageView) findViewById(R.id.obfuscated_res_0x7f091957);
            this.v0.setOnClickListener(this);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0919ca);
            this.R = findViewById;
            findViewById.setOnClickListener(this);
            ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f0916f6);
            this.S = imageView2;
            imageView2.setOnClickListener(this);
            this.q0 = (TextView) findViewById(R.id.obfuscated_res_0x7f092509);
            this.P = findViewById(R.id.obfuscated_res_0x7f0919c4);
            this.Q = findViewById(R.id.obfuscated_res_0x7f092508);
            this.P.setOnClickListener(this);
            this.z = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090faa);
            this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f090fad);
            this.u = (TextView) findViewById(R.id.obfuscated_res_0x7f090fab);
            this.v = (TextView) findViewById(R.id.obfuscated_res_0x7f090fac);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f090fa5);
            this.p = textView2;
            textView2.setVisibility(8);
            EditText editText2 = (EditText) findViewById(R.id.obfuscated_res_0x7f090884);
            this.y = editText2;
            editText2.setHint(getResources().getString(R.string.obfuscated_res_0x7f0f0e83, "o(〃'▽'〃)o"));
            this.y.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            this.y.setOnTouchListener(new e(this));
            this.z.setVisibility(0);
            this.y.setOnClickListener(this);
            this.y.setOnFocusChangeListener(new f(this));
            this.y.addTextChangedListener(new g(this));
            this.H = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f090ed2);
            jv4 jv4Var = new jv4(getPageContext().getPageActivity());
            this.J = jv4Var;
            jv4Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f0445));
            this.J.setPositiveButton(getPageContext().getString(R.string.obfuscated_res_0x7f0f026b), new h(this));
            this.J.setNegativeButton(getPageContext().getString(R.string.obfuscated_res_0x7f0f0377), new i(this));
            this.J.create(getPageContext());
            this.d0 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091914);
            this.e0 = (TextView) findViewById(R.id.obfuscated_res_0x7f091916);
            this.f0 = (TextView) findViewById(R.id.obfuscated_res_0x7f091915);
            this.g0 = (TextView) findViewById(R.id.obfuscated_res_0x7f09197e);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09195b);
            this.u0 = relativeLayout;
            relativeLayout.setOnClickListener(this);
            this.r0 = (TextView) findViewById(R.id.obfuscated_res_0x7f0906e9);
            this.h0 = (TextView) findViewById(R.id.obfuscated_res_0x7f0906ea);
            this.i0 = (ImageView) findViewById(R.id.obfuscated_res_0x7f0906e6);
            this.j0 = (TextView) findViewById(R.id.obfuscated_res_0x7f090157);
            this.k.post(new j(this));
            this.k.setScrollChangedListener(new l(this));
            I2();
        }
    }
}
