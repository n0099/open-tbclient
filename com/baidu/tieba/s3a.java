package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.s55;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class s3a extends v55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity f;
    public final a1a g;
    public ug5 h;

    /* loaded from: classes7.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s3a a;

        public a(s3a s3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s3aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s3aVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                z55.s("operateNew");
                this.a.c();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ s3a b;

        public b(s3a s3aVar, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s3aVar, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s3aVar;
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && view2.getContext() != null) {
                this.a.dismiss();
                LoginDialogData loginDialogData = new LoginDialogData(view2.getContext(), LoginDialogData.HOME_OPERATE_DIALOG);
                String b = this.b.h.b();
                if (TextUtils.isEmpty(b)) {
                    return;
                }
                if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                    str = "skin=dark";
                } else {
                    str = "skin=default";
                }
                if (b.contains("?")) {
                    str2 = b + "&customfullscreen=1&nonavigationbar=1&" + str;
                } else {
                    str2 = b + "?customfullscreen=1&nonavigationbar=1&" + str;
                }
                loginDialogData.setJumpUrl(str2);
                if (DialogLoginHelper.checkUpIsLogin(loginDialogData)) {
                    qx4.v(view2.getContext(), null, str2, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBAlertBuilder a;
        public final /* synthetic */ AlertDialog b;
        public final /* synthetic */ s3a c;

        public c(s3a s3aVar, TBAlertBuilder tBAlertBuilder, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s3aVar, tBAlertBuilder, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = s3aVar;
            this.a = tBAlertBuilder;
            this.b = alertDialog;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
                if (!z) {
                    this.c.c();
                } else {
                    this.a.A(this.b);
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.c.c();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s3a(@NonNull MainTabActivity mainTabActivity, @NonNull a1a a1aVar) {
        super(mainTabActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, a1aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = a1aVar;
        this.f = mainTabActivity;
    }

    @Override // com.baidu.tieba.s55
    public void d(@NonNull s55.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            boolean z = false;
            if (z55.j()) {
                aVar.callback(false);
            } else if (!n95.m().i(e75.d(), true)) {
                aVar.callback(false);
            } else {
                ug5 homeOperateData = TbSingleton.getInstance().getHomeOperateData();
                this.h = homeOperateData;
                if (homeOperateData == null) {
                    aVar.callback(false);
                } else if (!homeOperateData.c()) {
                    aVar.callback(false);
                } else {
                    if (!TextUtils.isEmpty(this.h.a()) && this.h.a().contains("not_show")) {
                        n95.m().w(e75.d(), false);
                    } else if (this.g.y() != null && this.g.y().getCurrentTabType() == 2) {
                        z = true;
                    }
                    aVar.callback(z);
                }
            }
        }
    }

    @Override // com.baidu.tieba.v55
    public void h(TBAlertBuilder tBAlertBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tBAlertBuilder) == null) {
            n95.m().w(e75.d(), false);
            int h = TBAlertBuilder.h(TbadkCoreApplication.getInst());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(h, (h * 4) / 3);
            TbImageView tbImageView = new TbImageView(this.b);
            tbImageView.setLayoutParams(layoutParams);
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            tBAlertBuilder.k(tbImageView);
            tBAlertBuilder.r(true);
            tBAlertBuilder.v(true);
            tBAlertBuilder.j(false);
            tBAlertBuilder.s(new a(this));
            AlertDialog d = tBAlertBuilder.d();
            tbImageView.setOnClickListener(new b(this, d));
            tbImageView.setEvent(new c(this, tBAlertBuilder, d));
            tbImageView.N(this.h.a(), 10, false);
        }
    }

    @Override // com.baidu.tieba.v55
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            z55.m("operateNew");
        }
    }
}
