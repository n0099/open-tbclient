package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class zza {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<MetaData> a;
    public final Set<String> b;
    public final ArrayList<MetaData> c;
    public HashMap<String, String> d;

    public zza() {
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
        this.b = new HashSet();
        this.c = new ArrayList<>();
        this.d = null;
    }

    public ArrayList<MetaData> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (ArrayList) invokeV.objValue;
    }

    public Set<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (Set) invokeV.objValue;
    }

    public ArrayList<MetaData> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            try {
                e(new JSONObject(str), true);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void e(JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048580, this, jSONObject, z) != null) || jSONObject == null) {
            return;
        }
        if (z) {
            try {
                if (this.d == null) {
                    this.d = new HashMap<>();
                }
            } catch (Exception e) {
                BdLog.detailException(e);
                return;
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                MetaData metaData = new MetaData();
                metaData.parserJson(optJSONArray.getJSONObject(i));
                if (!TextUtils.isEmpty(metaData.getName_show())) {
                    this.a.add(metaData);
                    if (z) {
                        this.d.put(metaData.getName_show(), metaData.getPortrait());
                    }
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("bot_list");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                MetaData metaData2 = new MetaData();
                metaData2.parserJson(optJSONArray2.getJSONObject(i2));
                if (!TextUtils.isEmpty(metaData2.getName_show())) {
                    this.c.add(metaData2);
                    this.b.add(metaData2.getUserId());
                }
            }
        }
    }
}
