package com.baidu.tieba.recapp.report;

import android.os.Build;
import b.a.e.f.p.j;
import b.a.r0.a3.l0.c;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class AdUploadHttpRequest extends HttpMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_AD = "ad";
    public static final String KEY_BRAND = "brand";
    public static final String KEY_NET_TYPE = "net_type";
    public static final String KEY_OS_TYPE = "_os_type";
    public static final String KEY_OS_VERSION = "_os_version";
    public static final String KEY_PRODUCT_ID = "productId";
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<c> dataArray;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdUploadHttpRequest(ArrayList<c> arrayList) {
        super(CmdConfigHttp.CMD_AD_UPLOAD);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ArrayList<c> arrayList2 = new ArrayList<>();
        this.dataArray = arrayList2;
        arrayList2.addAll(arrayList);
        addParam("ad", toJSONString(this.dataArray));
        addParam("brand", Build.BRAND);
        addParam(KEY_OS_VERSION, Build.VERSION.SDK);
        addParam("productId", 2);
        addParam("net_type", j.I());
        addParam(KEY_OS_TYPE, 2);
    }

    private String toJSONString(ArrayList<c> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, arrayList)) == null) {
            if (ListUtils.getCount(arrayList) <= 0) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null) {
                    jSONArray.put(next.b());
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeL.objValue;
    }

    public ArrayList<c> getDataArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.dataArray : (ArrayList) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpMessage, com.baidu.adp.framework.message.Message
    public synchronized List<Map.Entry<String, Object>> encodeInBackGround() {
        InterceptResult invokeV;
        List<Map.Entry<String, Object>> encodeInBackGround;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                removeParam(HttpRequest.PHONE_IMEI);
                encodeInBackGround = super.encodeInBackGround();
            }
            return encodeInBackGround;
        }
        return (List) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdUploadHttpRequest(c cVar) {
        super(CmdConfigHttp.CMD_AD_UPLOAD);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ArrayList<c> arrayList = new ArrayList<>();
        this.dataArray = arrayList;
        arrayList.add(cVar);
        addParam("ad", toJSONString(this.dataArray));
        addParam("brand", Build.BRAND);
        addParam(KEY_OS_VERSION, Build.VERSION.SDK);
    }
}
