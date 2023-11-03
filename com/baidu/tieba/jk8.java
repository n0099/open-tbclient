package com.baidu.tieba;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.util.orderlist.OrderLinkList;
import com.baidu.tieba.im.base.core.inputtool.GroupInputViewController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class jk8 implements zl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    @NonNull
    public final OrderLinkList<ks8> b;
    @NonNull
    public final GroupInputViewController c;

    public jk8(@NonNull GroupInputViewController groupInputViewController) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {groupInputViewController};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = groupInputViewController;
        this.b = new OrderLinkList<>();
    }

    @Override // com.baidu.tieba.zl8
    public boolean a(@NonNull List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list.isEmpty()) {
                return false;
            }
            for (Integer num : list) {
                if (i(num.intValue()) != null) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.zl8
    public void f(@NonNull List<ks8> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && list.size() > 0) {
            for (ks8 ks8Var : list) {
                ks8Var.b(k(ks8Var.d()));
                ks8Var.h(false);
                this.b.c(ks8Var);
            }
        }
    }

    @Override // com.baidu.tieba.zl8
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.b.d(k(i));
        }
    }

    @Override // com.baidu.tieba.zl8
    public void c(@NonNull ks8 ks8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ks8Var) == null) {
            ks8Var.b(k(ks8Var.d()));
            ks8Var.h(false);
            this.b.c(ks8Var);
        }
    }

    @Override // com.baidu.tieba.zl8
    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.a = i;
        }
    }

    @Nullable
    public ks8 i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return this.b.a(k(i));
        }
        return (ks8) invokeI.objValue;
    }

    @Override // com.baidu.tieba.zl8
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ks8 h = h();
            if (h == null) {
                return false;
            }
            this.c.Q1(h.c());
            this.c.i2(false);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.zl8
    @Nullable
    public ks8 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b.b();
        }
        return (ks8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zl8
    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            int k = k(i);
            ks8 a = this.b.a(k);
            if (i == 7011 && a != null && a.e()) {
                a.f(j(i));
            }
            if (a == null) {
                ks8 ks8Var = new ks8();
                ks8Var.g(i);
                ks8Var.b(k);
                ks8Var.f(j(i));
                ks8Var.h(true);
                this.b.c(ks8Var);
            }
        }
    }

    @SuppressLint({"StringFormatMatches"})
    public final String j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (i != 102) {
                if (i != 7003) {
                    if (i != 7005) {
                        if (i != 7007) {
                            switch (i) {
                                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_THRESHOLD_POST /* 7011 */:
                                    return String.format(tk8.g, Integer.valueOf(this.a));
                                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_THRESHOLD_VIEW /* 7012 */:
                                    return tk8.b;
                                case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_ONLY_MANAGER_CAN_TALK /* 7013 */:
                                    return tk8.e;
                                default:
                                    return "";
                            }
                        }
                        return tk8.c;
                    }
                    return tk8.d;
                }
                return tk8.f;
            }
            return tk8.a;
        }
        return (String) invokeI.objValue;
    }

    public final int k(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (i != 102) {
                switch (i) {
                    case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_MUZZLE /* 7003 */:
                    case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_MUZZLE /* 7004 */:
                        i2 = 5;
                        break;
                    case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_MUZZLE_ALL /* 7005 */:
                    case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_MUZZLE_ALL /* 7006 */:
                        i2 = 7;
                        break;
                    case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_FROZEN /* 7007 */:
                    case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_FROZEN /* 7008 */:
                        i2 = 8;
                        break;
                    default:
                        switch (i) {
                            case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_THRESHOLD_POST /* 7011 */:
                                i2 = 4;
                                break;
                            case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_THRESHOLD_VIEW /* 7012 */:
                                i2 = 9;
                                break;
                            case TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_ONLY_MANAGER_CAN_TALK /* 7013 */:
                                i2 = 6;
                                break;
                            default:
                                i2 = 0;
                                break;
                        }
                }
            } else {
                i2 = 10;
            }
            if (i2 != 0) {
                return i2;
            }
            throw new IllegalArgumentException("The type of the banned msg is unknown!");
        }
        return invokeI.intValue;
    }
}
