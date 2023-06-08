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
public class zv6 implements vn {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId e;
    public transient /* synthetic */ FieldHolder $fh;
    public ItemData a;
    public int b;
    public int c;
    public boolean d;

    public static boolean e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) ? i == 3 || i == 4 : invokeI.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948373455, "Lcom/baidu/tieba/zv6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948373455, "Lcom/baidu/tieba/zv6;");
                return;
            }
        }
        e = BdUniqueId.gen();
    }

    public zv6() {
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public zv6 clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            zv6 zv6Var = new zv6();
            zv6Var.a = this.a;
            zv6Var.b = this.b;
            zv6Var.c = this.c;
            zv6Var.d = this.d;
            return zv6Var;
        }
        return (zv6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return e;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public static zv6 b(rg5 rg5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, rg5Var)) == null) {
            zv6 zv6Var = new zv6();
            zv6Var.a = rg5Var.b;
            zv6Var.b = rg5Var.d;
            zv6Var.c = rg5Var.e;
            return zv6Var;
        }
        return (zv6) invokeL.objValue;
    }

    public static zv6 c(ManageInfo manageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, manageInfo)) == null) {
            zv6 zv6Var = new zv6();
            ItemData itemData = new ItemData();
            zv6Var.a = itemData;
            itemData.parseProto(manageInfo.item);
            zv6Var.b = manageInfo.item_source.intValue();
            return zv6Var;
        }
        return (zv6) invokeL.objValue;
    }

    public boolean d(zv6 zv6Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        boolean z3;
        ItemData itemData;
        ApkDetail apkDetail;
        ApkDetail apkDetail2;
        ItemData itemData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zv6Var)) == null) {
            if (this.b == zv6Var.b && this.c == zv6Var.c) {
                z = true;
            } else {
                z = false;
            }
            ItemData itemData3 = this.a;
            if (itemData3 != null && (itemData2 = zv6Var.a) != null) {
                z2 = itemData3.pkgName.equals(itemData2.pkgName);
            } else {
                z2 = false;
            }
            ItemData itemData4 = this.a;
            if (itemData4 != null && (itemData = zv6Var.a) != null && (apkDetail = itemData4.apkDetail) != null && (apkDetail2 = itemData.apkDetail) != null) {
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
