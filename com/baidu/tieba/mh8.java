package com.baidu.tieba;

import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class mh8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(TbPageContext<?> tbPageContext, String str, int i) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65536, null, tbPageContext, str, i) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("level", i);
                jSONObject.put("success_jump_url", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("page", "pass/accountAuth");
                jSONObject2.put("pageParams", jSONObject);
                String jSONObject3 = jSONObject2.toString();
                Uri.Builder builder = new Uri.Builder();
                builder.scheme("tiebaapp").authority(DI.ROUTER_NAME).path("/portal").appendQueryParameter("params", jSONObject3);
                str2 = builder.build().toString();
            } catch (JSONException e) {
                BdLog.e(e);
                str2 = "";
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str2});
        }
    }
}
