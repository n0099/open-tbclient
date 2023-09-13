package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ApkDetail;
import tbclient.ManageInfo;
/* loaded from: classes8.dex */
public class sy6 implements cn {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId g;
    public transient /* synthetic */ FieldHolder $fh;
    public ItemData a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;

    public static boolean e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) ? i == 3 || i == 4 : invokeI.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948167801, "Lcom/baidu/tieba/sy6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948167801, "Lcom/baidu/tieba/sy6;");
                return;
            }
        }
        g = BdUniqueId.gen();
    }

    public sy6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = 0;
        this.c = 0;
        this.d = true;
        this.e = false;
        this.f = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public sy6 clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            sy6 sy6Var = new sy6();
            sy6Var.a = this.a;
            sy6Var.b = this.b;
            sy6Var.c = this.c;
            sy6Var.d = this.d;
            sy6Var.e = this.e;
            sy6Var.f = this.f;
            return sy6Var;
        }
        return (sy6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return g;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public static sy6 b(ih5 ih5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ih5Var)) == null) {
            sy6 sy6Var = new sy6();
            sy6Var.a = ih5Var.b;
            sy6Var.b = ih5Var.d;
            sy6Var.c = ih5Var.e;
            return sy6Var;
        }
        return (sy6) invokeL.objValue;
    }

    public static sy6 c(ManageInfo manageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, manageInfo)) == null) {
            sy6 sy6Var = new sy6();
            ItemData itemData = new ItemData();
            sy6Var.a = itemData;
            itemData.parseProto(manageInfo.item);
            sy6Var.b = manageInfo.item_source.intValue();
            return sy6Var;
        }
        return (sy6) invokeL.objValue;
    }

    public boolean d(sy6 sy6Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        boolean z3;
        ItemData itemData;
        ApkDetail apkDetail;
        ApkDetail apkDetail2;
        ItemData itemData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sy6Var)) == null) {
            if (this.b == sy6Var.b && this.c == sy6Var.c) {
                z = true;
            } else {
                z = false;
            }
            ItemData itemData3 = this.a;
            if (itemData3 != null && (itemData2 = sy6Var.a) != null) {
                z2 = itemData3.pkgName.equals(itemData2.pkgName);
            } else {
                z2 = false;
            }
            ItemData itemData4 = this.a;
            if (itemData4 != null && (itemData = sy6Var.a) != null && (apkDetail = itemData4.apkDetail) != null && (apkDetail2 = itemData.apkDetail) != null) {
                z3 = apkDetail.version_code.equals(apkDetail2.version_code);
            } else {
                z3 = false;
            }
            if (z && z2 && z3) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
