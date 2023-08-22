package com.baidu.tieba.person.more;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.atomData.PersonMoreActivityConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.baidu.tieba.jo6;
import com.baidu.tieba.or9;
import com.baidu.tieba.ps9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PersonCenterMoreActivity extends BaseActivity<PersonCenterMoreActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public or9 a;
    public Bundle b;
    public ps9 c;
    public jo6 d;

    /* loaded from: classes7.dex */
    public class a extends jo6<ps9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonCenterMoreActivity b;

        public a(PersonCenterMoreActivity personCenterMoreActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterMoreActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personCenterMoreActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jo6
        /* renamed from: d */
        public void a(View view2, ps9 ps9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ps9Var) != null) {
                return;
            }
            this.b.c = ps9Var;
            if (this.b.c == null || this.b.z1()) {
                return;
            }
            PersonCenterMoreActivity personCenterMoreActivity = this.b;
            personCenterMoreActivity.x1(personCenterMoreActivity.c.f);
        }
    }

    public PersonCenterMoreActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new a(this);
    }

    public final boolean z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Activity pageActivity = getPageContext().getPageActivity();
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            return permissionJudgePolicy.startRequestPermission(pageActivity);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            or9 or9Var = this.a;
            if (or9Var != null) {
                or9Var.d();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            Intent intent = getIntent();
            if (intent != null) {
                this.b = intent.getBundleExtra(PersonMoreActivityConfig.URL_BUNDLE);
            }
            setContentView(R.layout.obfuscated_res_0x7f0d07ca);
            or9 or9Var = new or9(getPageContext(), this.b, this.d);
            this.a = or9Var;
            or9Var.c();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, strArr, iArr) == null) && 25040 == i && iArr[0] == 0) {
            x1(this.c.f);
        }
    }

    public final void x1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        if (str.startsWith("tieba&")) {
            y1(str);
        } else if (str.startsWith("nohead:url")) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.replaceFirst("nohead:url=", ""));
            String str2 = "?";
            if (str.contains("?")) {
                str2 = "&";
            }
            sb.append(str2);
            sb.append("jump=open_full_screen_web_page&nonavigationbar=1");
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{sb.toString()});
        } else {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        }
    }

    public final void y1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        if (str.startsWith("tieba&")) {
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                BdUtilHelper.showToast(getPageContext().getPageActivity(), (int) R.string.cosume_record_plugin_not_install_tip);
                return;
            }
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str.substring(6)});
        } else if (!str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001387, str));
        } else {
            BrowserHelper.startWebActivity((Context) getPageContext().getPageActivity(), true, str);
        }
    }
}
