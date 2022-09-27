package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class kx8 implements jx8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hx8 a;
    public gx8 b;
    public TbPageContext<?> c;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ kx8 b;

        public a(kx8 kx8Var, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kx8Var, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kx8Var;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ui.a(this.a.x);
                ej.N(this.b.c.getPageActivity(), view2.getResources().getString(R.string.obfuscated_res_0x7f0f0455));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kx8 a;

        public b(kx8 kx8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kx8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kx8Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.h();
            }
        }
    }

    public kx8(TbPageContext<?> tbPageContext, gx8 gx8Var, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, gx8Var, intent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = tbPageContext;
        this.b = gx8Var;
        ix8 ix8Var = new ix8();
        this.a = ix8Var;
        ix8Var.b(intent);
        this.a.e(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.jx8
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.c == null) {
            return;
        }
        if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.c.getPageActivity())) {
            i();
        }
    }

    @Override // com.baidu.tieba.jx8
    public void b() {
        hx8 hx8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (hx8Var = this.a) == null) {
            return;
        }
        ox4.k().u(ox4.o(hx8Var.c()), false);
    }

    @Override // com.baidu.tieba.jx8
    public void c() {
        hx8 hx8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (hx8Var = this.a) == null || this.b == null) {
            return;
        }
        this.b.K0(hx8Var.getVideoUrl());
    }

    @Override // com.baidu.tieba.jx8
    public void d() {
        gx8 gx8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gx8Var = this.b) == null) {
            return;
        }
        gx8Var.showErrorView();
    }

    @Override // com.baidu.tieba.jx8
    public void e() {
        gx8 gx8Var;
        hx8 hx8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gx8Var = this.b) == null || (hx8Var = this.a) == null) {
            return;
        }
        gx8Var.r0(hx8Var.a(), this.a.g());
    }

    public final void h() {
        hx8 hx8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (hx8Var = this.a) == null || this.b == null) {
            return;
        }
        this.b.G0(hx8Var.getVideoUrl());
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.a == null || this.c == null) {
            return;
        }
        ShareItem shareItem = new ShareItem();
        shareItem.v = this.a.d();
        shareItem.w = this.a.i();
        shareItem.x = this.a.f();
        shareItem.y = this.a.f();
        if (!dj.isEmpty(this.a.h())) {
            shareItem.z = Uri.parse(this.a.h());
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.c.getPageActivity(), shareItem, true, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
        shareDialogConfig.setOnDismissListener(new b(this));
        this.c.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    @Override // com.baidu.tieba.jx8
    public void onClose() {
        gx8 gx8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (gx8Var = this.b) == null) {
            return;
        }
        gx8Var.f0();
    }

    @Override // com.baidu.tieba.jx8
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.baidu.tieba.jx8
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.baidu.tieba.jx8
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            h();
        }
    }
}
