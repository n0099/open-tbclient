package com.baidu.tieba.livesdk.dispatcher;

import android.content.Context;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.y2a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class MixLiveDispatcher implements y2a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String URL_PREFIX = "com.baidu.tieba://unidispatch/mixlive";
    public transient /* synthetic */ FieldHolder $fh;

    public MixLiveDispatcher() {
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

    @Override // com.baidu.tieba.y2a
    public void dispatch(JSONObject jSONObject, Context context) {
        TbPageContext<?> currentPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && context != null && jSONObject != null && (currentPageContext = TbadkCoreApplication.getInst().getCurrentPageContext(context)) != null) {
            try {
                UrlManager.getInstance().dealOneLink(currentPageContext, new String[]{UrlUtils.appendParam(URL_PREFIX, "url", URLEncoder.encode(jSONObject.optString("url"), "utf-8"))});
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
