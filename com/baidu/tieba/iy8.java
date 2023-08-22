package com.baidu.tieba;

import com.baidu.adp.log.DefaultLog;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
@Service
/* loaded from: classes6.dex */
public final class iy8 implements bf5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public iy8() {
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

    @Override // com.baidu.tieba.bf5
    public void parseJson(JSONObject json) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, json) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                JSONArray jSONArray = new JSONObject(json.optString("funny_sprite_config")).getJSONArray("funny_sprite_waiting_content");
                jy8.a().clear();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    jy8.a().add(jSONArray.getString(i));
                }
            } catch (Exception e) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.e("sendSpriteMsg", "情感词数据解析失败" + e.getMessage());
            }
        }
    }
}
