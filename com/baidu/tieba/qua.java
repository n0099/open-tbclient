package com.baidu.tieba;

import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.mainentrance.MainEntrance;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class qua {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    public qua(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        MessageManager.getInstance().registerStickyMode(2921453);
    }

    public void a(Intent intent, mua muaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, intent, muaVar) != null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(MainTabActivityConfig.PUSH_DES_PAGE);
        if (!TextUtils.isEmpty(stringExtra)) {
            String string = this.a.getString(R.string.des_page_home_recommend);
            oy4 oy4Var = new oy4();
            Matcher matcher = Pattern.compile(UrlSchemaHelper.PB_URL).matcher(intent.getStringExtra("target_scheme"));
            int i = 1;
            if (matcher.find()) {
                oy4Var.c = matcher.group(1);
            }
            if (stringExtra.equals(string)) {
                oy4Var.a = 1;
            } else {
                oy4Var.a = 2;
                oy4Var.b = stringExtra;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921453, oy4Var));
            if (stringExtra.equals(string)) {
                intent.putExtra(MainEntrance.GO_SUB_TYPE, 1);
                i = 2;
            } else {
                intent.putExtra(MainEntrance.GO_SUB_TYPE, stringExtra);
            }
            if (muaVar != null && muaVar.A() != null) {
                muaVar.A().setCurrentTabByType(i);
                FragmentTabHost.c h = muaVar.A().h(i);
                if (h != null) {
                    Fragment fragment = h.c;
                    if (fragment instanceof ev4) {
                        ((ev4) fragment).c2(intent);
                    }
                }
            }
        }
        intent.removeExtra(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION);
        intent.removeExtra(MainTabActivityConfig.PUSH_DES_PAGE);
    }

    public boolean b(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent)) == null) {
            if (intent.getIntExtra(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION, 0) != 1) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
