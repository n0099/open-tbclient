package com.baidu.tieba;

import android.os.Build;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.h5power.DescriptionTableInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class up8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<pp8> a;

    public up8() {
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
        this.a = new ArrayList<>();
    }

    public void a(pp8 pp8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pp8Var) == null) {
            this.a.add(pp8Var);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) && webView != null && !wi.isEmpty(str) && !wi.isEmpty(str2)) {
            if (Build.VERSION.SDK_INT >= 19) {
                webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
                return;
            }
            webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
        }
    }

    public rp8 c(tp8 tp8Var, rp8 rp8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tp8Var, rp8Var)) == null) {
            if (rp8Var == null) {
                rp8Var = new rp8();
            }
            if (ActionJsonData.TAG_NOTIFICATION.equals(tp8Var.c()) && "addObserver".equals(tp8Var.a())) {
                Iterator<pp8> it = this.a.iterator();
                while (it.hasNext()) {
                    rp8Var = it.next().addObserver(tp8Var.d(), rp8Var, true);
                    if (rp8Var.j()) {
                        return rp8Var;
                    }
                }
                if (!rp8Var.j()) {
                    rp8Var.y(202);
                    rp8Var.u(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f036d));
                }
            } else {
                String c = tp8Var.c();
                if (!wi.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    rp8Var.y(201);
                    return rp8Var;
                }
                Iterator<pp8> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    rp8Var = it2.next().dispatch(tp8Var, rp8Var);
                    if (rp8Var.i()) {
                        return rp8Var;
                    }
                }
                if (!rp8Var.i()) {
                    rp8Var.y(202);
                }
            }
            return rp8Var;
        }
        return (rp8) invokeLL.objValue;
    }

    public void d(WebView webView, rp8 rp8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, webView, rp8Var) != null) || webView == null || rp8Var == null || !rp8Var.k()) {
            return;
        }
        b(webView, rp8Var.c(), rp8Var.d());
    }

    public void e(WebView webView, List<rp8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) && webView != null && !ListUtils.isEmpty(list)) {
            for (rp8 rp8Var : list) {
                if (rp8Var != null && rp8Var.k()) {
                    b(webView, rp8Var.c(), rp8Var.d());
                }
            }
        }
    }

    public List<rp8> f(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, hashMap)) == null) {
            List<rp8> list = null;
            if (wi.isEmpty(str)) {
                return null;
            }
            Iterator<pp8> it = this.a.iterator();
            while (it.hasNext()) {
                list = it.next().processNotification(str, hashMap);
                if (!ListUtils.isEmpty(list)) {
                    break;
                }
            }
            return list;
        }
        return (List) invokeLL.objValue;
    }
}
