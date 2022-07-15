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
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
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
import com.repackage.cr4;
import com.repackage.ei;
import com.repackage.er4;
import com.repackage.f45;
import com.repackage.hs6;
import com.repackage.is6;
import com.repackage.je5;
import com.repackage.l45;
import com.repackage.lq7;
import com.repackage.lr4;
import com.repackage.ni;
import com.repackage.nr4;
import com.repackage.oi;
import com.repackage.oj8;
import com.repackage.pi;
import com.repackage.qg;
import com.repackage.sz4;
import com.repackage.ur4;
import com.repackage.xt4;
import com.repackage.ym;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InputMethodManager A;
    public hs6 A0;
    public PersonChangeModel B;
    public boolean B0;
    public FrameLayout C;
    public int C0;
    public HeadImageView D;
    public ViewTreeObserver.OnGlobalLayoutListener D0;
    public ym E;
    public final Runnable E0;
    public a0 F;
    public PersonChangeModel.b F0;
    public b0 G;
    public final View.OnClickListener G0;
    public ProgressBar H;
    public CustomMessageListener H0;
    public DialogInterface.OnCancelListener I;
    public CustomMessageListener I0;
    public cr4 J;
    public lr4 K;
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
    public cr4 Y;
    public boolean Z;
    public Boolean a;
    public final WriteImagesInfo b;
    public NavigationBar c;
    public TextView d;
    public EMTextView e;
    public LinearLayout f;
    public TextView g;
    public String g0;
    public TextView h;
    public PermissionJudgePolicy h0;
    public View i;
    public sz4 i0;
    public LinearLayout j;
    public LinearLayout j0;
    public ManualObservableScrollView k;
    public TextView k0;
    public TextView l;
    public TextView l0;
    public EditText m;
    public TextView m0;
    public TextView n;
    public TextView n0;
    public LinearLayout o;
    public ImageView o0;
    public TextView p;
    public TextView p0;
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

    /* loaded from: classes3.dex */
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
            if (interceptable == null || interceptable.invokeL(1048576, this, selectForumData) == null) {
                this.a.K2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a0 extends BdAsyncTask<Object, Integer, Bitmap> {
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

        public /* synthetic */ a0(PersonChangeActivity personChangeActivity, k kVar) {
            this(personChangeActivity);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, bitmap) == null) {
                super.onPostExecute((a0) bitmap);
                this.a.F = null;
                this.a.H.setVisibility(8);
                if (bitmap != null) {
                    this.a.E = new ym(bitmap, false, (String) null);
                    this.a.E.h(this.a.D);
                    l45.k().c(this.a.B.E().getPortrait(), this.a.E, true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) || z) {
                return;
            }
            this.a.m.setFocusableInTouchMode(false);
        }
    }

    /* loaded from: classes3.dex */
    public class b0 extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public PersonChangeModel b;
        public final /* synthetic */ PersonChangeActivity c;

        public b0(PersonChangeActivity personChangeActivity, PersonChangeModel personChangeModel) {
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
                this.c.G = null;
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
                personChangeActivity.showLoadingDialog(personChangeActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f109b), this.c.I);
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
                netWork.addPostData("sex", String.valueOf(this.b.E().getSex()));
                this.a.addPostData("intro", this.b.E().getIntro());
                this.a.addPostData("birthday_time", String.valueOf(this.b.E().getBirthdayTime()));
                this.a.addPostData("birthday_show_status", String.valueOf(this.b.E().getBirthdayShowStatus()));
                if (UbsABTestHelper.isNickNameABTest()) {
                    this.a.addPostData("need_keep_nickname_flag", "0");
                    this.a.addPostData(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
                    this.a.addPostData("is_business_account", this.b.E().getIsBusinessAccount());
                    if (!TextUtils.isEmpty(this.b.E().getTempNickName())) {
                        this.a.addPostData("nick_name", this.b.E().getTempNickName());
                    }
                } else {
                    this.a.addPostData("need_keep_nickname_flag", "1");
                }
                if (this.c.B0) {
                    this.a.addPostData("do_from", "local_user_profile");
                    this.a.addPostData("forum_data", this.b.E().getInterestedForumsJsonString());
                }
                this.a.postMultiNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    oj8.j();
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
                        this.c.R2();
                        this.c.b3();
                    } else {
                        this.c.d3(this.a.getErrorString(), false);
                    }
                }
                super.onPostExecute((b0) str);
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class d implements TextWatcher {
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

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.K2();
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
    public class e implements View.OnFocusChangeListener {
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

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) || z) {
                return;
            }
            this.a.y.setFocusableInTouchMode(false);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements TextWatcher {
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

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.a.B.E() == null || editable.toString().replaceAll("\\s*", "").equals(this.a.B.E().getIntro())) {
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
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
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
                this.a.Y2();
                if (length > 500) {
                    this.a.c3(R.string.obfuscated_res_0x7f0f0d07, false);
                    if (this.a.y.getSelectionStart() - 1 < 0 || this.a.y.getSelectionStart() - 1 > this.a.y.getSelectionEnd()) {
                        this.a.y.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(this.a.y.getSelectionStart() - 1, this.a.y.getSelectionEnd());
                        this.a.y.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd > length2) {
                        selectionEnd = length2;
                    }
                    Selection.setSelection(this.a.y.getText(), selectionEnd);
                }
                this.a.K2();
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
                this.a.C2();
                this.a.N2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements cr4.e {
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

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
                if (this.a.B.E().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (!this.a.a.booleanValue()) {
                        intent.putExtra("data", this.a.B.E());
                    } else {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.a.B.E());
                    }
                    this.a.setResult(-1, intent);
                    this.a.Q2();
                }
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k.scrollTo(0, 0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements ManualObservableScrollView.a {
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

        @Override // com.baidu.tieba.widget.ManualObservableScrollView.a
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
                PersonChangeActivity personChangeActivity = this.a;
                pi.x(personChangeActivity, personChangeActivity.U);
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.x0 == null) {
                return;
            }
            this.a.x0.setVisibility(0);
        }
    }

    /* loaded from: classes3.dex */
    public class l implements ViewTreeObserver.OnGlobalLayoutListener {
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

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int height = this.a.U.getHeight();
                if (this.a.C0 != 0 && this.a.C0 != height) {
                    if (height > this.a.C0) {
                        qg.a().postDelayed(this.a.E0, 200L);
                    } else if (this.a.x0 != null) {
                        this.a.x0.setVisibility(8);
                    }
                }
                this.a.C0 = height;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements er4.c {
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

        @Override // com.repackage.er4.c
        public void a(er4 er4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, er4Var, i, view2) == null) {
                if (i == 0) {
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.a.getPageContext().getPageActivity(), this.a.b.toJsonString(), true);
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
    public class n implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PersonChangeActivity c;

        public n(PersonChangeActivity personChangeActivity, String str, String str2) {
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
        public void N(nr4 nr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nr4Var, i, view2) == null) {
                if (this.c.K != null && this.c.K.isShowing()) {
                    this.c.K.dismiss();
                }
                if (view2 instanceof TextView) {
                    TextView textView = (TextView) view2;
                    if (this.a.equals(textView.getText().toString())) {
                        this.c.O = 1;
                        this.c.r.setText(this.a);
                    } else if (this.b.equals(textView.getText().toString())) {
                        this.c.O = 2;
                        this.c.r.setText(this.b);
                    }
                    SkinManager.setViewTextColor(this.c.r, (int) R.color.CAM_X0105);
                    if (this.c.O != this.c.B.E().getSex()) {
                        this.c.M = true;
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            SkinManager.setViewTextColor(this.c.d, R.color.navi_op_text, 1);
                        } else {
                            SkinManager.setViewTextColor(this.c.d, R.color.CAM_X0302, 1);
                        }
                    }
                    this.c.K2();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.B.E().getSex() != this.a.O) {
                    this.a.L = true;
                }
                this.a.O2();
                if (this.a.B0 || (!this.a.L && !this.a.N)) {
                    if (this.a.B != null && this.a.B.E().getPhotoChanged()) {
                        Intent intent = new Intent();
                        if (this.a.a.booleanValue()) {
                            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.a.B.E());
                        } else {
                            intent.putExtra("data", this.a.B.E());
                        }
                        this.a.Q2();
                        this.a.setResult(-1, intent);
                    }
                    this.a.finish();
                    return;
                }
                this.a.J.show();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Activity currentActivity;
            String string;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || currentActivity.findViewById(16908290) == null) {
                return;
            }
            if (this.a.B0) {
                string = currentActivity.getString(R.string.obfuscated_res_0x7f0f0419);
            } else {
                string = currentActivity.getString(R.string.obfuscated_res_0x7f0f038b);
            }
            if (this.a.m != null && this.a.m.getText() != null && this.a.B != null && this.a.B.E() != null && !this.a.m.getText().equals(this.a.B.E().getNameShow())) {
                string = currentActivity.getString(R.string.obfuscated_res_0x7f0f0407);
            }
            BdTopToast bdTopToast = new BdTopToast(currentActivity);
            bdTopToast.i(true);
            bdTopToast.h(string);
            bdTopToast.j((ViewGroup) currentActivity.findViewById(16908290));
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                String str = (String) data;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.a.Z = true;
                this.a.g0 = str;
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (this.a.B == null || this.a.B.E() == null || personChangeData == null) {
                    return;
                }
                this.a.B.E().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                this.a.B.E().setMem(personChangeData.getMen());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Dialog a;
        public final /* synthetic */ PersonChangeActivity b;

        public s(PersonChangeActivity personChangeActivity, Dialog dialog) {
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

    /* loaded from: classes3.dex */
    public class t implements hs6.c {
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

        @Override // com.repackage.hs6.c
        public void a(Date date, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, date, j) == null) {
                this.a.B.E().setBirthdayTime(j);
                this.a.n0.setText(StringHelper.dateToConstellation(date));
                this.a.p0.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e39, Integer.valueOf(PersonChangeActivity.D2(date))));
                this.a.p0.setVisibility(0);
                SkinManager.setViewTextColor(this.a.n0, (int) R.color.CAM_X0105);
                this.a.K2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u implements cr4.e {
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

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.getPageContext().getPageActivity(), null, lq7.a(), true)));
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class v implements cr4.e {
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

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w implements sz4.e {
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

        @Override // com.repackage.sz4.e
        public void a(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, accountData) == null) || accountData == null) {
                return;
            }
            this.a.M2(accountData.getAccount());
        }
    }

    /* loaded from: classes3.dex */
    public class x implements Runnable {
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

    /* loaded from: classes3.dex */
    public class y implements DialogInterface.OnCancelListener {
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

    /* loaded from: classes3.dex */
    public class z implements PersonChangeModel.b {
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
                this.a.y2();
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
        this.F0 = new z(this);
        this.G0 = new o(this);
        this.H0 = new q(this, 2921033);
        this.I0 = new r(this, 2921061);
    }

    public static int D2(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, date)) == null) {
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

    public static void startActivityForResult(Activity activity, int i2, PersonChangeData personChangeData, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65581, null, activity, i2, personChangeData, bool) == null) {
            Intent intent = new Intent(activity, PersonChangeActivity.class);
            intent.putExtra("data", personChangeData);
            intent.putExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, bool);
            activity.startActivityForResult(intent, i2);
        }
    }

    public final void A1(Bundle bundle) {
        PersonChangeData personChangeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            this.I = new y(this);
            if (bundle != null) {
                String string = bundle.getString("data");
                personChangeData = !StringUtils.isNull(string) ? (PersonChangeData) OrmObject.objectWithJsonStr(string, PersonChangeData.class) : null;
            } else {
                personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
            }
            if (personChangeData == null) {
                personChangeData = new PersonChangeData();
            }
            PersonChangeModel personChangeModel = new PersonChangeModel(getPageContext(), personChangeData);
            this.B = personChangeModel;
            personChangeModel.F(this.F0);
            if (this.B0) {
                f3();
                this.j.setVisibility(8);
            }
            showLoadingView(this.U);
            this.B.loadData();
            U2();
        }
    }

    public final void A2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (UbsABTestHelper.isNickNameABTest()) {
                xt4.k().u("key_has_show_nick_name_red_icon_tip", true);
                T2();
                this.m.setFocusableInTouchMode(true);
                this.m.requestFocus();
                this.m.setCursorVisible(true);
                ShowSoftKeyPad(this.A, this.m);
                return;
            }
            sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
        }
    }

    public final void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.X = (ImageView) findViewById(R.id.obfuscated_res_0x7f0918d7);
            this.U = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0913dd);
            this.X.setOnClickListener(this);
            HeadImageView headImageView = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f0918ce);
            this.D = headImageView;
            headImageView.setOnClickListener(this);
            this.j = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0916ba);
            this.k = (ManualObservableScrollView) findViewById(R.id.obfuscated_res_0x7f09182d);
            this.w = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0918a1);
            this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f091d2f);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f092437);
            this.c = navigationBar;
            View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d08cc, this.G0);
            this.T = addCustomView;
            ImageView imageView = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f0924ef);
            this.V = imageView;
            imageView.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f03e8));
            this.f = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0909f8);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f09222e);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f09222f);
            this.w.setOnClickListener(this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090f15);
            this.x = linearLayout;
            linearLayout.setOnClickListener(this);
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f0915e7);
            this.m = editText;
            editText.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            this.m.setOnClickListener(this);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f0915ea);
            this.e = (EMTextView) findViewById(R.id.obfuscated_res_0x7f091381);
            this.C = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0918d6);
            this.q = (TextView) findViewById(R.id.obfuscated_res_0x7f091d30);
            this.s = (ImageView) findViewById(R.id.obfuscated_res_0x7f091d2d);
            this.w0 = (InterestForumTagLayout) findViewById(R.id.obfuscated_res_0x7f090ee8);
            this.x0 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091e2c);
            this.y0 = (TextView) findViewById(R.id.obfuscated_res_0x7f091e2b);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091e2d);
            this.z0 = textView;
            textView.setOnClickListener(this);
            this.o = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090f17);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f0915e6);
            if (UbsABTestHelper.isNickNameABTest()) {
                this.m.setOnFocusChangeListener(new b(this));
                this.m.setOnEditorActionListener(new c(this));
                this.m.addTextChangedListener(new d(this));
            } else {
                this.m.setFocusableInTouchMode(false);
                this.m.setCursorVisible(false);
            }
            this.s0 = (TextView) findViewById(R.id.obfuscated_res_0x7f091832);
            this.v0 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091831);
            this.t0 = (TextView) findViewById(R.id.obfuscated_res_0x7f0918a3);
            this.W = (ImageView) findViewById(R.id.obfuscated_res_0x7f091830);
            this.v0.setOnClickListener(this);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f09189f);
            this.R = findViewById;
            findViewById.setOnClickListener(this);
            ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f0915e9);
            this.S = imageView2;
            imageView2.setOnClickListener(this);
            this.q0 = (TextView) findViewById(R.id.obfuscated_res_0x7f092331);
            this.P = findViewById(R.id.obfuscated_res_0x7f091899);
            this.Q = findViewById(R.id.obfuscated_res_0x7f092330);
            this.P.setOnClickListener(this);
            this.z = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090f19);
            this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f090f1c);
            this.u = (TextView) findViewById(R.id.obfuscated_res_0x7f090f1a);
            this.v = (TextView) findViewById(R.id.obfuscated_res_0x7f090f1b);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f090f14);
            this.p = textView2;
            textView2.setVisibility(8);
            EditText editText2 = (EditText) findViewById(R.id.obfuscated_res_0x7f09081f);
            this.y = editText2;
            editText2.setHint(getResources().getString(R.string.obfuscated_res_0x7f0f0e21, "o(〃'▽'〃)o"));
            this.y.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            this.z.setVisibility(0);
            this.y.setOnClickListener(this);
            this.y.setOnFocusChangeListener(new e(this));
            this.y.addTextChangedListener(new f(this));
            this.H = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f090e48);
            cr4 cr4Var = new cr4(getPageContext().getPageActivity());
            this.J = cr4Var;
            cr4Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f042c));
            this.J.setPositiveButton(getPageContext().getString(R.string.obfuscated_res_0x7f0f0262), new g(this));
            this.J.setNegativeButton(getPageContext().getString(R.string.obfuscated_res_0x7f0f036a), new h(this));
            this.J.create(getPageContext());
            this.j0 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0917f2);
            this.k0 = (TextView) findViewById(R.id.obfuscated_res_0x7f0917f4);
            this.l0 = (TextView) findViewById(R.id.obfuscated_res_0x7f0917f3);
            this.m0 = (TextView) findViewById(R.id.obfuscated_res_0x7f091857);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091834);
            this.u0 = relativeLayout;
            relativeLayout.setOnClickListener(this);
            this.r0 = (TextView) findViewById(R.id.obfuscated_res_0x7f09069e);
            this.n0 = (TextView) findViewById(R.id.obfuscated_res_0x7f09069f);
            this.o0 = (ImageView) findViewById(R.id.obfuscated_res_0x7f09069b);
            this.p0 = (TextView) findViewById(R.id.obfuscated_res_0x7f090148);
            this.k.post(new i(this));
            this.k.setScrollChangedListener(new j(this));
            L2();
        }
    }

    public final void B2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.B0) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c14378");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        TiebaStatic.log(statisticItem);
    }

    public final void C2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.B0) {
            return;
        }
        Editable text = this.m.getText();
        String obj = text == null ? "" : text.toString();
        StatisticItem statisticItem = new StatisticItem("c14379");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_param1", !obj.equals(this.B.E().getNameShow()));
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, !this.y.toString().replaceAll("\\s*", "").equals(this.B.E().getIntro()));
        TiebaStatic.log(statisticItem);
    }

    public final void E2(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, intent) == null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
        }
    }

    public final void F2(Intent intent) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, intent) == null) || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        this.b.parseJson(stringExtra);
        this.b.updateQuality();
        if (this.b.getChosedFiles() != null && this.b.getChosedFiles().size() > 0) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) TaskResponseData.ERROR_NO_TASK_OFFLINE_03, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.b.getChosedFiles().get(0).getFilePath(), 1.0f)));
        }
        this.b.clear();
    }

    public final hs6 G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.A0 == null) {
                this.A0 = new hs6(this);
            }
            return this.A0;
        }
        return (hs6) invokeV.objValue;
    }

    public final hs6.c H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new t(this) : (hs6.c) invokeV.objValue;
    }

    public final void I2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.y.getVisibility() == 0 && this.y.isFocused()) {
                String replaceAll = this.y.getText().toString().replaceAll("\\s*", "");
                if (replaceAll.length() > 0) {
                    this.p.setText(replaceAll);
                } else {
                    this.p.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f00cd));
                }
                if (this.B.E().getIntro() == null || !this.B.E().getIntro().equals(replaceAll)) {
                    this.L = true;
                }
                this.B.E().setIntro(replaceAll);
                HidenSoftKeyPad(this.A, this.y);
            } else if (this.m.getVisibility() == 0 && this.m.isFocused()) {
                HidenSoftKeyPad(this.A, this.m);
            }
        }
    }

    public final void J2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            a0 a0Var = this.F;
            if (a0Var != null) {
                a0Var.cancel();
            }
            this.E = null;
            a0 a0Var2 = new a0(this, null);
            this.F = a0Var2;
            a0Var2.execute(new Object[0]);
        }
    }

    public final void K2() {
        PersonChangeModel personChangeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (personChangeModel = this.B) == null) {
            return;
        }
        boolean z2 = true;
        this.z0.setEnabled((!(personChangeModel.C() && this.O != 0) || this.y.getText() == null || TextUtils.isEmpty(this.y.getText().toString().trim())) ? false : false);
    }

    public final void L2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.U != null && this.B0) {
            if (this.D0 == null) {
                this.D0 = new l(this);
            }
            this.U.getViewTreeObserver().addOnGlobalLayoutListener(this.D0);
        }
    }

    public final void M2(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.q0.setText(str);
        this.P.setClickable(false);
        this.Q.setVisibility(8);
    }

    public final void N2() {
        PersonChangeModel personChangeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (personChangeModel = this.B) == null || personChangeModel.E() == null) {
            return;
        }
        I2();
        if (UbsABTestHelper.isNickNameABTest() && !z2()) {
            c3(R.string.obfuscated_res_0x7f0f0e42, false);
        } else if (!ni.z()) {
            c3(R.string.obfuscated_res_0x7f0f0c2b, false);
        } else {
            this.B.E().setIntro(this.y.getText().toString().replaceAll("\\s*", ""));
            this.B.E().setSex(this.O);
            if (this.G == null) {
                b0 b0Var = new b0(this, this.B);
                this.G = b0Var;
                b0Var.setPriority(3);
                this.G.execute(new String[0]);
            }
        }
    }

    public final void O2() {
        PersonChangeModel personChangeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (personChangeModel = this.B) == null || personChangeModel.E() == null || this.B.E().isNickNameInVerifying) {
            return;
        }
        Editable text = this.m.getText();
        this.g0 = text == null ? "" : text.toString();
        this.B.E().setTempNickName(this.g0);
        this.N = !this.g0.equals(this.B.E().getNameShow());
    }

    public final void P2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.k.postDelayed(new x(this), i2);
        }
    }

    public final void Q2() {
        PersonChangeModel personChangeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (personChangeModel = this.B) == null || personChangeModel.E() == null) {
            return;
        }
        f45.d().h();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.B.E()));
    }

    public final void R2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (!this.B0) {
                Intent intent = new Intent();
                if (this.a.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.B.E());
                } else {
                    intent.putExtra("data", this.B.E());
                }
                setResult(-1, intent);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921651, Boolean.TRUE));
            }
            Q2();
            finish();
        }
    }

    public final void S2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.t.setTextColor(i2);
            this.u.setTextColor(i2);
            this.v.setTextColor(i2);
        }
    }

    public final void T2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.S.getLayoutParams();
            if (UbsABTestHelper.isNickNameABTest()) {
                layoutParams.width = UtilHelper.getDimenPixelSize(R.dimen.tbds21);
                layoutParams.height = UtilHelper.getDimenPixelSize(R.dimen.tbds21);
                this.S.setImageResource(R.drawable.obfuscated_res_0x7f080640);
                if (this.B.E().getNickNameLeftDays() == 0 && !xt4.k().h("key_has_show_nick_name_red_icon_tip", false)) {
                    this.S.setVisibility(0);
                } else {
                    this.S.setVisibility(4);
                }
            } else {
                layoutParams.width = -2;
                layoutParams.height = -2;
                this.S.setImageResource(R.drawable.icon_arrow_more_gray);
                if (!NickNameActivitySwitch.isOn() && this.B.E().getNickNameLeftDays() != 0) {
                    this.S.setVisibility(8);
                } else {
                    this.S.setVisibility(0);
                }
            }
            this.S.requestLayout();
        }
    }

    public final void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            String string = getResources().getString(R.string.obfuscated_res_0x7f0f0b3c);
            if (this.B0) {
                string = getString(R.string.obfuscated_res_0x7f0f0a36);
            }
            this.c.setCenterTextTitle(string);
            if (this.B0) {
                return;
            }
            View addCustomView = this.c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d05e8, (View.OnClickListener) null);
            this.i = addCustomView;
            TextView textView = (TextView) addCustomView.findViewById(R.id.obfuscated_res_0x7f091b3d);
            this.d = textView;
            textView.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f108e));
            SkinManager.setViewTextColor(this.d, R.color.navi_op_text, 1);
            this.i.setOnClickListener(this);
        }
    }

    public final void V2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.y.getVisibility() == 0) {
            return;
        }
        this.p.setVisibility(8);
        this.y.setText(this.B.E().getIntro());
        EditText editText = this.y;
        editText.setSelection(editText.getText().length());
        this.y.setFocusableInTouchMode(true);
        this.y.requestFocus();
        ShowSoftKeyPad(this.A, this.y);
        P2(400);
    }

    public void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            String[] strArr = {getPageContext().getString(R.string.obfuscated_res_0x7f0f038d), getPageContext().getString(R.string.obfuscated_res_0x7f0f0390)};
            er4 er4Var = new er4(getPageContext().getPageActivity());
            er4Var.k(R.string.obfuscated_res_0x7f0f0cf1);
            er4Var.j(strArr, new m(this));
            er4Var.c(getPageContext());
            er4Var.m();
        }
    }

    public final void X2(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, accountData) == null) {
            if (this.i0 == null) {
                sz4 sz4Var = new sz4(this);
                this.i0 = sz4Var;
                sz4Var.w(new w(this));
            }
            this.i0.p();
            this.i0.u(accountData);
            this.i0.y();
        }
    }

    public final void Y2() {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.y.getText().toString().replaceAll("\\s*", "").length() >= 500) {
                color = SkinManager.getColor(R.color.common_color_10159);
            } else {
                color = SkinManager.getColor(R.color.common_color_10077);
            }
            S2(color);
        }
    }

    public final void Z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (this.Y == null) {
                View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06d2, (ViewGroup) null);
                cr4 cr4Var = new cr4(getPageContext().getPageActivity());
                this.Y = cr4Var;
                cr4Var.setContentView(inflate);
                this.Y.setPositiveButton(R.string.obfuscated_res_0x7f0f0c3a, new u(this));
                this.Y.setNegativeButton(R.string.obfuscated_res_0x7f0f0c39, new v(this));
                this.Y.create(getPageContext());
                SkinManager.setViewTextColor(inflate.findViewById(R.id.obfuscated_res_0x7f0915ec), (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(inflate.findViewById(R.id.obfuscated_res_0x7f0915eb), (int) R.color.common_color_10122);
            }
            this.Y.show();
        }
    }

    public final void a3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (this.K == null) {
                this.K = new lr4(getPageContext());
                String string = getPageContext().getString(R.string.obfuscated_res_0x7f0f0a75);
                String string2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f0604);
                this.K.j(getString(R.string.obfuscated_res_0x7f0f03c3), new String[]{string, string2}, new n(this, string, string2));
            }
            this.K.m();
        }
    }

    public final void b3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            qg.a().postDelayed(new p(this), 200L);
        }
    }

    public void c3(int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            d3(getString(i2), z2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (this.B0) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
            } else {
                super.closeAnimation();
            }
        }
    }

    public void d3(String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048607, this, str, z2) == null) {
            BdTopToast bdTopToast = new BdTopToast(this);
            bdTopToast.i(z2);
            bdTopToast.h(str);
            bdTopToast.j((ViewGroup) findViewById(16908290));
        }
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f099e, TBAlertConfig.OperateBtnStyle.MAIN);
            PersonChangeModel personChangeModel = this.B;
            int nickNameLeftDays = (personChangeModel == null || personChangeModel.E() == null) ? 0 : this.B.E().getNickNameLeftDays();
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(getActivity());
            tBAlertBuilder.t(R.string.obfuscated_res_0x7f0f1503);
            tBAlertBuilder.p(String.format(getString(R.string.obfuscated_res_0x7f0f0c3b), Integer.valueOf(nickNameLeftDays)));
            tBAlertBuilder.r(aVar);
            tBAlertBuilder.i(true);
            aVar.a(new s(this, tBAlertBuilder.w()));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (this.B0) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
            } else {
                super.enterExitAnimation();
            }
        }
    }

    public final void f3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.e.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.C.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, pi.f(this, R.dimen.M_H_X009), layoutParams.rightMargin, layoutParams.bottomMargin);
            this.P.setVisibility(8);
            this.v0.setVisibility(8);
            this.j0.setVisibility(8);
            this.f.setVisibility(8);
            this.w0.setVisibility(0);
            this.x0.setVisibility(0);
            this.o.setOrientation(1);
            this.r0.setText(getString(R.string.obfuscated_res_0x7f0f0df8));
            this.g.setText(getString(R.string.obfuscated_res_0x7f0f0a71));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.y.getLayoutParams();
            layoutParams2.setMargins(0, pi.f(this, R.dimen.tbds18), 0, 0);
            layoutParams2.height = pi.f(this, R.dimen.tbds229);
            this.y.setGravity(51);
            this.y.setHint(getString(R.string.obfuscated_res_0x7f0f0a37));
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08093c, SkinManager.getColor(R.color.CAM_X0301), null);
            if (pureDrawable != null) {
                this.l.setCompoundDrawablePadding(pi.f(this, R.dimen.M_W_X002));
                this.l.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
                this.q.setCompoundDrawablePadding(pi.f(this, R.dimen.M_W_X002));
                this.q.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
                this.r0.setCompoundDrawablePadding(pi.f(this, R.dimen.M_W_X002));
                this.r0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
                this.g.setCompoundDrawablePadding(pi.f(this, R.dimen.M_W_X002));
                this.g.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
            }
            this.w0.setMustFill(true);
            this.w0.setDeleteForumListener(new a(this));
        }
    }

    public final void g3(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.N = true;
        this.B.E().setPhotoChanged(true);
        this.B.E().setNameShow(str);
        this.B.E().setNickNameLeftDays(90);
        this.m.setText(str);
        T2();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048612, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 != -1) {
                if (i3 == 0 && i2 == 12010) {
                    SelectImageHelper.takePhoto(getPageContext());
                }
            } else if (i2 == 1001) {
                if (intent != null) {
                    long longExtra = intent.getLongExtra("constellation_birthday", 0L);
                    int intExtra = intent.getIntExtra("constellation_show_status", 0);
                    if (longExtra == this.B.E().getBirthdayTime() && intExtra == this.B.E().getBirthdayShowStatus()) {
                        return;
                    }
                    this.B.E().setBirthdayShowStatus(intExtra);
                    this.B.E().setBirthdayTime(longExtra);
                    this.L = true;
                    this.M = true;
                    Date date = new Date(longExtra * 1000);
                    this.n0.setText(StringHelper.dateToConstellation(date));
                    if (this.B.E().getBirthdayShowStatus() == 2) {
                        this.p0.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0e39, Integer.valueOf(D2(date))));
                        this.p0.setVisibility(0);
                    } else {
                        this.p0.setVisibility(8);
                    }
                    SkinManager.setViewTextColor(this.n0, (int) R.color.CAM_X0105);
                }
            } else if (i2 == 12002) {
                if (intent != null) {
                    if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                        E2(intent);
                    } else {
                        F2(intent);
                    }
                }
            } else if (i2 == 12014) {
                this.B.E().setPhotoChanged(true);
                if (intent != null) {
                    this.D.setImageBitmap(null);
                    this.D.J(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                }
                this.M = true;
                if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                    SkinManager.setViewTextColor(this.d, R.color.navi_op_text, 1);
                } else {
                    SkinManager.setViewTextColor(this.d, R.color.CAM_X0302, 1);
                }
            } else if (i2 != 25067) {
                if (i2 == 12009 || i2 == 12010) {
                    this.B.E().setPhotoChanged(true);
                    J2();
                    this.M = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        SkinManager.setViewTextColor(this.d, R.color.navi_op_text, 1);
                    } else {
                        SkinManager.setViewTextColor(this.d, R.color.CAM_X0302, 1);
                    }
                }
            } else if (intent != null) {
                ArrayList<SelectForumData> parcelableArrayListExtra = intent.getParcelableArrayListExtra(SelectForumConfig.KEY_SELECTED_INTEREST_FORUMS_RESPONSE);
                PersonChangeModel personChangeModel = this.B;
                if (personChangeModel == null || personChangeModel.E() == null) {
                    return;
                }
                this.M = true;
                this.B.E().setInterestForums(parcelableArrayListExtra);
                this.w0.i(this.B.E().getInterestedForums());
                K2();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            super.onChangeSkinType(i2);
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.j);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.V, R.drawable.obfuscated_res_0x7f0809d1, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.c.onChangeSkinType(getPageContext(), i2);
            this.D.refresh();
            SkinManager.setViewTextColor(this.q0, (int) R.color.CAM_X0109);
            WebPManager.setMaskDrawable(this.X, R.drawable.obfuscated_res_0x7f0807e2, null);
            WebPManager.setPureDrawable(this.W, R.drawable.obfuscated_res_0x7f080a0a, R.color.CAM_X0108, null);
            TextView textView = this.d;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0302, 1);
            }
            ur4.d(this.s0).v(R.color.CAM_X0108);
            ur4.d(this.t0).v(R.color.CAM_X0108);
            ur4.d(this.g).v(R.color.CAM_X0109);
            ur4.d(this.h).v(R.color.CAM_X0109);
            ur4.d(this.l0).v(R.color.CAM_X0109);
            ur4.d(this.k0).v(R.color.CAM_X0109);
            ur4 d2 = ur4.d(this.e);
            d2.A(R.string.F_X02);
            d2.v(R.color.CAM_X0105);
            ur4.d(this.y).v(R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.s, R.drawable.icon_common_arrow16_right_n, R.color.CAM_X0109, null);
            WebPManager.setPureDrawable(this.o0, R.drawable.icon_common_arrow16_right_n, R.color.CAM_X0109, null);
            ur4.d(this.y0).v(R.color.CAM_X0108);
            ur4 d3 = ur4.d(this.z0);
            d3.v(R.color.CAM_X0101);
            d3.n(R.string.J_X07);
            d3.h(R.color.CAM_X0303);
            this.w0.onChangeSkinType(getPageContext(), i2);
            ur4 d4 = ur4.d(this.n);
            d4.v(R.color.CAM_X0108);
            d4.n(R.string.J_X04);
            d4.f(R.color.CAM_X0204);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        PersonChangeData personChangeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, view2) == null) {
            super.onClick(view2);
            if (view2 != this.D && view2 != this.X) {
                if (view2 == this.i) {
                    O2();
                    C2();
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
                    N2();
                    return;
                } else if (view2 == this.w) {
                    a3();
                    return;
                } else if (view2 == this.x) {
                    V2();
                    return;
                } else {
                    EditText editText = this.y;
                    if (view2 == editText) {
                        editText.setFocusableInTouchMode(true);
                        this.y.requestFocus();
                        ShowSoftKeyPad(this.A, this.y);
                        P2(400);
                        return;
                    } else if (view2 != this.R && view2 != this.m && view2 != this.S) {
                        if (view2 == this.P) {
                            PersonChangeModel personChangeModel = this.B;
                            if (personChangeModel == null || personChangeModel.E() == null || StringUtils.isNull(this.B.E().getName())) {
                                X2(TbadkCoreApplication.getCurrentAccountInfo());
                                return;
                            }
                            return;
                        } else if (view2 == this.u0) {
                            if (this.B0) {
                                pi.x(this, this.U);
                                G2().e(H2());
                                return;
                            }
                            PersonConstellationActivity.N1(getActivity(), this.B.E().getBirthdayTime(), this.B.E().getBirthdayShowStatus());
                            return;
                        } else if (view2 == this.v0) {
                            if (this.t0 == null || this.q0 == null) {
                                return;
                            }
                            ei.a(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f143a), TbadkCoreApplication.getCurrentAccountNameShow(), this.t0.getText().toString()));
                            BdTopToast bdTopToast = new BdTopToast(this, 3000);
                            bdTopToast.i(true);
                            bdTopToast.h(getResources().getString(R.string.obfuscated_res_0x7f0f0447));
                            bdTopToast.j(this.U);
                            if (this.B0) {
                                return;
                            }
                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COPY_CLIENT_NUMBER_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_param1", this.t0.getText().toString()).param("obj_locate", 2));
                            return;
                        } else if (view2 == this.w0) {
                            PersonChangeModel personChangeModel2 = this.B;
                            if (personChangeModel2 == null || personChangeModel2.E() == null) {
                                return;
                            }
                            SelectForumConfig selectForumConfig = new SelectForumConfig(this);
                            selectForumConfig.setSelectedInterestedForums(this.B.E().getInterestedForums());
                            selectForumConfig.setIsSelectInterestForum(true);
                            selectForumConfig.setRequestCode(25067);
                            selectForumConfig.setIntentAction(IntentAction.ActivityForResult);
                            selectForumConfig.start();
                            return;
                        } else if (view2 == this.z0) {
                            is6.a();
                            if (!this.M && !this.N) {
                                finish();
                                return;
                            } else {
                                N2();
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        B2();
                        if (Build.VERSION.SDK_INT < 19) {
                            d3(getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f1236), false);
                            return;
                        } else if (NickNameActivitySwitch.isOn()) {
                            Z2();
                            return;
                        } else if (this.B.E().isNickNameInVerifying) {
                            d3(getString(R.string.obfuscated_res_0x7f0f0c3c), false);
                            return;
                        } else if (this.B.E().getNickNameLeftDays() == 0) {
                            A2();
                            return;
                        } else {
                            e3();
                            return;
                        }
                    }
                }
            }
            PersonChangeModel personChangeModel3 = this.B;
            if (personChangeModel3 != null && (personChangeData = personChangeModel3.a) != null && !personChangeData.canModifyAvatar()) {
                if (!StringUtils.isNull(this.B.a.getCantModifyAvatarDesc())) {
                    pi.L(TbadkCoreApplication.getInst(), this.B.a.getCantModifyAvatarDesc());
                    return;
                } else {
                    pi.K(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0e02);
                    return;
                }
            }
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.h0 == null) {
                this.h0 = new PermissionJudgePolicy();
            }
            this.h0.clearRequestPermissionList();
            this.h0.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.h0.startRequestPermission(pageActivity)) {
                return;
            }
            W2();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, bundle) == null) {
            if (bundle != null) {
                this.B0 = bundle.getBoolean(PersonChangeActivityConfig.IS_COMPLETE_LOCAL_INFO);
            } else if (getIntent() != null) {
                this.B0 = getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_COMPLETE_LOCAL_INFO, false);
            }
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d06bb);
            adjustResizeForSoftInput();
            this.A = (InputMethodManager) getSystemService("input_method");
            B1();
            A1(bundle);
            if (bundle != null) {
                this.a = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
            } else {
                this.a = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
            }
            if (!this.B0) {
                TiebaStatic.log("c12204");
            } else {
                is6.b();
            }
            registerListener(this.H0);
            registerListener(this.I0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.H0);
            a0 a0Var = this.F;
            if (a0Var != null) {
                a0Var.cancel();
            }
            b0 b0Var = this.G;
            if (b0Var != null) {
                b0Var.cancel();
            }
            ProgressBar progressBar = this.H;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            EditText editText = this.y;
            if (editText != null) {
                editText.addTextChangedListener(null);
            }
            sz4 sz4Var = this.i0;
            if (sz4Var != null) {
                sz4Var.s();
            }
            if (this.D0 != null && (viewGroup = this.U) != null) {
                viewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this.D0);
            }
            qg.a().removeCallbacks(this.E0);
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048617, this, i2, keyEvent)) == null) {
            if (isLoadingViewAttached() || isNetRefreshViewAttached()) {
                return super.onKeyDown(i2, keyEvent);
            }
            if (i2 == 4) {
                I2();
                this.G0.onClick(null);
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onResume();
            if (!this.Z || TextUtils.isEmpty(this.g0)) {
                return;
            }
            g3(this.g0);
            this.Z = false;
            this.g0 = "";
            K2();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (this.B.E() != null) {
                bundle.putString("data", OrmObject.jsonStrWithObject(this.B.E()));
            }
        }
    }

    public final void y2() {
        PersonChangeModel personChangeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || (personChangeModel = this.B) == null || personChangeModel.E() == null) {
            return;
        }
        T2();
        this.D.J(HeadIconRefreshHelper.headPortraitFilter(this.B.E().getPortrait()), 25, false);
        if (this.B.E().isNickNameInVerifying) {
            this.m.setText(this.B.E().nickNameInVerifying);
            this.m.setHint("");
            this.n.setVisibility(0);
        } else {
            this.m.setText(this.B.E().getNameShow());
            this.n.setVisibility(8);
        }
        PersonChangeModel personChangeModel2 = this.B;
        if (personChangeModel2 != null && personChangeModel2.E() != null && !TextUtils.isEmpty(this.B.E().getmTiebaId())) {
            this.t0.setText(this.B.E().getmTiebaId());
        } else {
            this.v0.setVisibility(8);
        }
        if (StringUtils.isNull(this.B.E().getName())) {
            this.q0.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f1416));
            this.P.setClickable(true);
            this.Q.setVisibility(0);
        } else {
            this.q0.setText(this.B.E().getName());
            this.P.setClickable(false);
            this.Q.setVisibility(8);
        }
        if (this.B.E().getIntro() != null && this.B.E().getIntro().length() > 0) {
            this.p.setText(this.B.E().getIntro());
        } else {
            this.p.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f00cd));
        }
        if (!oi.isEmpty(this.B.E().getIntro())) {
            this.y.setText(this.B.E().getIntro());
            TextView textView = this.t;
            textView.setText(this.B.E().getIntro().length() + "");
        } else {
            this.t.setText("0");
        }
        if (this.B.E().getSex() == 1) {
            this.O = 1;
            this.r.setText(R.string.obfuscated_res_0x7f0f0a75);
        } else if (this.B.E().getSex() == 2) {
            this.O = 2;
            this.r.setText(R.string.obfuscated_res_0x7f0f0604);
        } else {
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0110);
            this.r.setText(R.string.obfuscated_res_0x7f0f038e);
        }
        if (this.B.E().getAlaId() > 0) {
            this.j0.setVisibility(0);
            TextView textView2 = this.k0;
            textView2.setText(this.B.E().getAlaId() + "");
        }
        this.m0.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0e28, this.B.E().getForumAge()));
        if (this.B.E().getBirthdayTime() != 0) {
            this.n0.setText(StringHelper.dateToConstellation(new Date(this.B.E().getBirthdayTime() * 1000)));
        }
        if (this.B.E().getBirthdayTime() != 0 && this.B.E().getUserAge() > 0 && (this.B.E().getBirthdayShowStatus() == 2 || this.B0)) {
            this.p0.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0e39, Integer.valueOf(this.B.E().getUserAge())));
            this.p0.setVisibility(0);
        } else {
            this.p0.setVisibility(8);
        }
        if (this.B.E().getBirthdayTime() == 0 && this.p0.getVisibility() == 8) {
            this.n0.setText(getString(R.string.obfuscated_res_0x7f0f0388));
            SkinManager.setViewTextColor(this.n0, (int) R.color.CAM_X0110);
        }
        if (this.B0) {
            this.w0.h(getPageContext(), null, false);
            this.w0.setOnClickListener(this);
            K2();
        }
    }

    public final boolean z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            O2();
            String str = this.g0;
            if (str == null || str.equals(this.B.E().getNameShow())) {
                return true;
            }
            return je5.b(this.g0) <= 20 && je5.b(this.g0) >= 2;
        }
        return invokeV.booleanValue;
    }
}
