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
/* loaded from: classes6.dex */
public class kha {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    public kha(TbPageContext tbPageContext) {
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

    public void a(Intent intent, gha ghaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, intent, ghaVar) != null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(MainTabActivityConfig.PUSH_DES_PAGE);
        if (!TextUtils.isEmpty(stringExtra)) {
            String string = this.a.getString(R.string.des_page_home_recommend);
            wx4 wx4Var = new wx4();
            Matcher matcher = Pattern.compile(UrlSchemaHelper.PB_URL).matcher(intent.getStringExtra("target_scheme"));
            int i = 1;
            if (matcher.find()) {
                wx4Var.c = matcher.group(1);
            }
            if (stringExtra.equals(string)) {
                wx4Var.a = 1;
            } else {
                wx4Var.a = 2;
                wx4Var.b = stringExtra;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921453, wx4Var));
            if (stringExtra.equals(string)) {
                intent.putExtra(MainEntrance.GO_SUB_TYPE, 1);
                i = 2;
            } else {
                intent.putExtra(MainEntrance.GO_SUB_TYPE, stringExtra);
            }
            if (ghaVar != null && ghaVar.A() != null) {
                ghaVar.A().setCurrentTabByType(i);
                FragmentTabHost.c h = ghaVar.A().h(i);
                if (h != null) {
                    Fragment fragment = h.c;
                    if (fragment instanceof nu4) {
                        ((nu4) fragment).L1(intent);
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
