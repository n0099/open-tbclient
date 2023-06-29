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
/* loaded from: classes6.dex */
public class jw6 implements xn {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947897760, "Lcom/baidu/tieba/jw6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947897760, "Lcom/baidu/tieba/jw6;");
                return;
            }
        }
        e = BdUniqueId.gen();
    }

    public jw6() {
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
    public jw6 clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            jw6 jw6Var = new jw6();
            jw6Var.a = this.a;
            jw6Var.b = this.b;
            jw6Var.c = this.c;
            jw6Var.d = this.d;
            return jw6Var;
        }
        return (jw6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return e;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public static jw6 b(zg5 zg5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, zg5Var)) == null) {
            jw6 jw6Var = new jw6();
            jw6Var.a = zg5Var.b;
            jw6Var.b = zg5Var.d;
            jw6Var.c = zg5Var.e;
            return jw6Var;
        }
        return (jw6) invokeL.objValue;
    }

    public static jw6 c(ManageInfo manageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, manageInfo)) == null) {
            jw6 jw6Var = new jw6();
            ItemData itemData = new ItemData();
            jw6Var.a = itemData;
            itemData.parseProto(manageInfo.item);
            jw6Var.b = manageInfo.item_source.intValue();
            return jw6Var;
        }
        return (jw6) invokeL.objValue;
    }

    public boolean d(jw6 jw6Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        boolean z3;
        ItemData itemData;
        ApkDetail apkDetail;
        ApkDetail apkDetail2;
        ItemData itemData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jw6Var)) == null) {
            if (this.b == jw6Var.b && this.c == jw6Var.c) {
                z = true;
            } else {
                z = false;
            }
            ItemData itemData3 = this.a;
            if (itemData3 != null && (itemData2 = jw6Var.a) != null) {
                z2 = itemData3.pkgName.equals(itemData2.pkgName);
            } else {
                z2 = false;
            }
            ItemData itemData4 = this.a;
            if (itemData4 != null && (itemData = jw6Var.a) != null && (apkDetail = itemData4.apkDetail) != null && (apkDetail2 = itemData.apkDetail) != null) {
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
