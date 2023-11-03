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
/* loaded from: classes9.dex */
public class xu6 implements oi {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948312912, "Lcom/baidu/tieba/xu6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948312912, "Lcom/baidu/tieba/xu6;");
                return;
            }
        }
        g = BdUniqueId.gen();
    }

    public xu6() {
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
    public xu6 clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            xu6 xu6Var = new xu6();
            xu6Var.a = this.a;
            xu6Var.b = this.b;
            xu6Var.c = this.c;
            xu6Var.d = this.d;
            xu6Var.e = this.e;
            xu6Var.f = this.f;
            return xu6Var;
        }
        return (xu6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oi
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return g;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public static xu6 b(mc5 mc5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, mc5Var)) == null) {
            xu6 xu6Var = new xu6();
            xu6Var.a = mc5Var.b;
            xu6Var.b = mc5Var.d;
            xu6Var.c = mc5Var.e;
            return xu6Var;
        }
        return (xu6) invokeL.objValue;
    }

    public static xu6 c(ManageInfo manageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, manageInfo)) == null) {
            xu6 xu6Var = new xu6();
            ItemData itemData = new ItemData();
            xu6Var.a = itemData;
            itemData.parseProto(manageInfo.item);
            xu6Var.b = manageInfo.item_source.intValue();
            return xu6Var;
        }
        return (xu6) invokeL.objValue;
    }

    public boolean d(xu6 xu6Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        boolean z3;
        ItemData itemData;
        ApkDetail apkDetail;
        ApkDetail apkDetail2;
        ItemData itemData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xu6Var)) == null) {
            if (this.b == xu6Var.b && this.c == xu6Var.c) {
                z = true;
            } else {
                z = false;
            }
            ItemData itemData3 = this.a;
            if (itemData3 != null && (itemData2 = xu6Var.a) != null) {
                z2 = itemData3.pkgName.equals(itemData2.pkgName);
            } else {
                z2 = false;
            }
            ItemData itemData4 = this.a;
            if (itemData4 != null && (itemData = xu6Var.a) != null && (apkDetail = itemData4.apkDetail) != null && (apkDetail2 = itemData.apkDetail) != null) {
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
