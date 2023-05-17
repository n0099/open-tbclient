package com.baidu.tieba.tbadkCore.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class PaymentConfirmRequestData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TERMINAL_ANDROID = "320";
    public static final long serialVersionUID = 5867821330520807722L;
    public transient /* synthetic */ FieldHolder $fh;
    public int currency;
    public long goods_duration;
    public String goods_name;
    public long goods_num;
    public String goods_pic;
    public String goods_unit;
    public int goods_user_level;
    public long open_id;
    public String order_id;
    public int pay_type;
    public long scene_id;
    public long tdou_num;
    public String terminal;

    public PaymentConfirmRequestData() {
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

    public int getCurrency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.currency;
        }
        return invokeV.intValue;
    }

    public long getGoods_duration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.goods_duration;
        }
        return invokeV.longValue;
    }

    public String getGoods_name() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.goods_name;
        }
        return (String) invokeV.objValue;
    }

    public long getGoods_num() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.goods_num;
        }
        return invokeV.longValue;
    }

    public String getGoods_pic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.goods_pic;
        }
        return (String) invokeV.objValue;
    }

    public String getGoods_unit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.goods_unit;
        }
        return (String) invokeV.objValue;
    }

    public int getGoods_user_level() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.goods_user_level;
        }
        return invokeV.intValue;
    }

    public long getOpen_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.open_id;
        }
        return invokeV.longValue;
    }

    public String getOrder_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.order_id;
        }
        return (String) invokeV.objValue;
    }

    public int getPay_type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.pay_type;
        }
        return invokeV.intValue;
    }

    public long getScene_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.scene_id;
        }
        return invokeV.longValue;
    }

    public long getTdou_num() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.tdou_num;
        }
        return invokeV.longValue;
    }

    public String getTerminal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.terminal;
        }
        return (String) invokeV.objValue;
    }

    public void setCurrency(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.currency = i;
        }
    }

    public void setGoods_duration(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            this.goods_duration = j;
        }
    }

    public void setGoods_name(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.goods_name = str;
        }
    }

    public void setGoods_num(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.goods_num = j;
        }
    }

    public void setGoods_pic(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.goods_pic = str;
        }
    }

    public void setGoods_unit(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.goods_unit = str;
        }
    }

    public void setGoods_user_level(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.goods_user_level = i;
        }
    }

    public void setOpen_id(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            this.open_id = j;
        }
    }

    public void setOrder_id(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.order_id = str;
        }
    }

    public void setPay_type(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.pay_type = i;
        }
    }

    public void setScene_id(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j) == null) {
            this.scene_id = j;
        }
    }

    public void setTdou_num(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j) == null) {
            this.tdou_num = j;
        }
    }

    public void setTerminal(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.terminal = str;
        }
    }
}
