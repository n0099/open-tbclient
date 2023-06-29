package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.PeiwanLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.live.interfaces.service.RouterService;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.WebViewBroadcastReceiver;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UrlSchemaJumpHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class iz8 implements RouterService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.live.interfaces.service.RouterService
    public boolean invokeSchemeWithCallBack(Context context, Uri uri, String str, RouterService.LiveShowSchemeCallBack liveShowSchemeCallBack) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, uri, str, liveShowSchemeCallBack)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ iz8 c;

        public a(iz8 iz8Var, String str, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz8Var, str, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = iz8Var;
            this.a = str;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Activity b = h9.f().b();
                if (b != null && (r9.a(b) instanceof TbPageContext)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) r9.a(b), new String[]{this.a}, true);
                } else if (!this.a.startsWith(BdUniDispatchSchemeController.SCHEME)) {
                    this.c.c(this.b, this.a);
                } else {
                    UtilHelper.dealOneScheme(this.b, this.a);
                }
            }
        }
    }

    public iz8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.RouterService
    public boolean invokeScheme(Uri uri, String str, RouterService.LiveShowSchemeCallBack liveShowSchemeCallBack) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, uri, str, liveShowSchemeCallBack)) == null) {
            openScheme(uri.toString());
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (StringUtils.isNull(str) || !str.contains("from=tieba")) {
                return false;
            }
            if (str.contains("com.baidu.tieba.unidispatch://pwStatisticalLog?")) {
                f(Uri.parse(str));
                return true;
            } else if (str.contains("com.baidu.tieba.unidispatch://pwYalogger?")) {
                e(str);
                return true;
            } else if (str.startsWith(UrlSchemaHelper.SCHEMA_MESSAGE_CENTER_PAGE)) {
                UrlSchemaJumpHelper.jumpMessageCenterPage(context, str);
                return true;
            } else if (str.startsWith("com.baidu.tieba://unidispatch/GameGodsDetailPage")) {
                UrlSchemaJumpHelper.jumpGameGodsPage(context, str);
                return true;
            } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_DISPATCH_PAGE)) {
                UrlSchemaJumpHelper.jumpDispatchOrderPage(context, str);
                return true;
            } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_UNPAID_PAGE)) {
                UrlSchemaJumpHelper.jumpUnPaidOrderPage(context, str);
                return true;
            } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_UNPAID_LIST_PAGE)) {
                UrlSchemaJumpHelper.jumpUnPaidListPage(context, str);
                return true;
            } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_PERSON_CHAT)) {
                UrlSchemaJumpHelper.jumpPersonChat(context, str, true);
                return true;
            } else if (str.startsWith("com.baidu.tieba://unidispatch/tbwebview")) {
                UrlSchemaJumpHelper.jumpNativeH5Page(context, str);
                return true;
            } else {
                if (str.startsWith(UrlSchemaHelper.SCHEME_POST_DETAIL_PAGE)) {
                    UrlSchemaJumpHelper.jumpPostDetailPage(context, str);
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            if (context != null) {
                Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str));
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                if (UtilHelper.isIntentAvailable(context, intent)) {
                    try {
                        context.startActivity(intent);
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void d(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) != null) || StringUtils.isNull(str) || b(context, str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str.indexOf("?") > 0) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append(WebViewBroadcastReceiver.INTENT_LOCALE_RECEV_CLOSE);
        sb.append("=1");
        sb.append("&page_from=live");
        yg.a().post(new a(this, sb.toString(), context));
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return;
            }
            PeiwanLog.getInstance().c(parse.getQueryParameter("tag"), parse.getQueryParameter("msg"));
        } catch (Exception e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                e.printStackTrace();
            }
        }
    }

    public final void f(Uri uri) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, uri) != null) || uri == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("key");
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(queryParameter);
        for (String str : uri.getQueryParameterNames()) {
            if (!TextUtils.equals(str, "key")) {
                statisticItem.addParam(str, uri.getQueryParameter(str));
            }
        }
        TiebaStatic.log(statisticItem);
    }

    @Override // com.baidu.searchbox.live.interfaces.service.RouterService
    public void openScheme(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && !StringUtils.isNull(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str.indexOf("?") > 0) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            sb.append(WebViewBroadcastReceiver.INTENT_LOCALE_RECEV_CLOSE);
            sb.append("=1");
            sb.append("&page_from=live");
            Activity b = h9.f().b();
            if (b != null) {
                UrlManager.getInstance().dealOneLink((TbPageContext) r9.a(b), new String[]{sb.toString()}, true);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.RouterService
    public void invoke(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, str) == null) {
            d(context, str);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.RouterService
    public void invokeScheme(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, str) == null) {
            d(context, str);
        }
    }
}
