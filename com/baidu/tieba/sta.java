package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.AndroidUtils;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class sta implements rta {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pta a;
    public ota b;
    public TbPageContext<?> c;

    @Override // com.baidu.tieba.rta
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.baidu.tieba.rta
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ sta b;

        public a(sta staVar, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {staVar, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = staVar;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AndroidUtils.copyToClipboard(this.a.linkUrl);
                BdUtilHelper.showToast(this.b.c.getPageActivity(), view2.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sta a;

        public b(sta staVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {staVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = staVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dialogInterface) != null) {
                return;
            }
            this.a.h();
        }
    }

    public sta(TbPageContext<?> tbPageContext, ota otaVar, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, otaVar, intent};
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
        this.b = otaVar;
        qta qtaVar = new qta();
        this.a = qtaVar;
        qtaVar.b(intent);
        this.a.e(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.rta
    public void a() {
        ota otaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (otaVar = this.b) != null) {
            otaVar.showErrorView();
        }
    }

    @Override // com.baidu.tieba.rta
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.c == null) {
            return;
        }
        if (!ShareSwitch.isOn() && !ViewHelper.checkUpIsLogin(this.c.getPageActivity())) {
            return;
        }
        i();
    }

    @Override // com.baidu.tieba.rta
    public void c() {
        pta ptaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (ptaVar = this.a) != null) {
            SharedPrefHelper.getInstance().putBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount(ptaVar.c()), false);
        }
    }

    @Override // com.baidu.tieba.rta
    public void d() {
        pta ptaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (ptaVar = this.a) != null && this.b != null) {
            this.b.x0(ptaVar.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.rta
    public void e() {
        ota otaVar;
        pta ptaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (otaVar = this.b) != null && (ptaVar = this.a) != null) {
            otaVar.g0(ptaVar.a(), this.a.g());
        }
    }

    public final void h() {
        pta ptaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (ptaVar = this.a) != null && this.b != null) {
            this.b.u0(ptaVar.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.rta
    public void onClose() {
        ota otaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (otaVar = this.b) != null) {
            otaVar.finishActivity();
        }
    }

    @Override // com.baidu.tieba.rta
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            h();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.a != null && this.c != null) {
            ShareItem shareItem = new ShareItem();
            shareItem.title = this.a.d();
            shareItem.content = this.a.i();
            shareItem.linkUrl = this.a.f();
            shareItem.spareLinkUrl = this.a.f();
            if (!ei.isEmpty(this.a.h())) {
                shareItem.imageUri = Uri.parse(this.a.h());
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.c.getPageActivity(), shareItem, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
            shareDialogConfig.setOnDismissListener(new b(this));
            this.c.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }
}
