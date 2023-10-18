package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.mvc.data.INetRequestData;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tbadk.util.NetMessageHelper;
import com.baidu.tieba.immessagecenter.mention.FeedData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import tbclient.ReplyMe.DataReq;
import tbclient.ReplyMe.ReplyMeReqIdl;
/* loaded from: classes7.dex */
public class pp8 implements INetRequestData, xl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public String c;
    public long d;
    public long e;
    public int f;
    public String g;

    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "replyme_cache" : (String) invokeV.objValue;
    }

    public String getCacheTableName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "tb_user_replyme" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mvc.data.IHttpParamRequestData
    public HashMap<String, String> getHttpHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xl5
    public boolean isNeedUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public pp8() {
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
        this.b = 1;
        this.d = 0L;
        this.e = 0L;
        this.f = 0;
        this.g = "";
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b = 1;
            this.a = 1;
            this.c = null;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.b++;
            this.a = 4;
        }
    }

    public void d(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.g = str;
        }
    }

    public void e(FeedData feedData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, feedData) != null) || feedData == null) {
            return;
        }
        this.c = String.format("%s,%s", feedData.getThread_id(), feedData.getPost_id());
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f = i;
        }
    }

    public void g(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.d = j;
        }
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.e = j;
        }
    }

    @Override // com.baidu.tbadk.mvc.data.ISocketProtobufRequestData
    public Object encodeSocketRequestData(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.pn = Integer.valueOf(this.b);
                builder.ids = this.c;
                builder.is_first = Integer.valueOf(this.f);
                builder.call_from = this.g;
                builder.time = Long.valueOf(this.e);
                builder.tid = Long.valueOf(this.d);
                builder.q_type = Integer.valueOf(uu4.c().e());
                builder.scr_dip = Double.valueOf(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
                builder.scr_h = Integer.valueOf(BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst().getApp()));
                builder.scr_w = Integer.valueOf(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst().getApp()));
                if (z || SocketAddCommonParamSwitch.getIsOn()) {
                    NetMessageHelper.bindCommonParamsToProtobufData(builder, true);
                }
                ReplyMeReqIdl.Builder builder2 = new ReplyMeReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeZ.objValue;
    }

    @Override // com.baidu.tbadk.mvc.data.IHttpParamRequestData
    public HashMap<String, Object> makeHttpParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            hashMap.put("pn", String.valueOf(this.b));
            hashMap.put("time", String.valueOf(this.e));
            hashMap.put("tid", String.valueOf(this.d));
            hashMap.put("is_first", String.valueOf(this.f));
            hashMap.put(IntentConfig.CALL_FROM, this.g);
            hashMap.put("q_type", Integer.valueOf(uu4.c().e()));
            hashMap.put("scr_dip", Double.valueOf(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density));
            hashMap.put("scr_h", Integer.valueOf(BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            hashMap.put("scr_w", Integer.valueOf(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            if (this.a == 4 && !TextUtils.isEmpty(this.c)) {
                hashMap.put("ids", this.c);
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }
}
