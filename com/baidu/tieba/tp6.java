package com.baidu.tieba;

import android.content.res.Resources;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.ApkDetail;
import tbclient.ItemInfo;
/* loaded from: classes6.dex */
public class tp6 extends ar4 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId b;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList a;

    @Override // com.baidu.tieba.ar4
    public xs4 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (xs4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ar4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948188943, "Lcom/baidu/tieba/tp6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948188943, "Lcom/baidu/tieba/tp6;");
                return;
            }
        }
        b = BdUniqueId.gen();
    }

    public tp6() {
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
        setSupportType(BaseCardInfo.SupportType.FULL);
    }

    public ArrayList c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return !ListUtils.isEmpty(this.a);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.eo
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return b;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void h(ItemInfo itemInfo) {
        ApkDetail apkDetail;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, itemInfo) == null) {
            if (this.a == null) {
                this.a = new ArrayList();
            }
            this.a.clear();
            if (itemInfo != null && (apkDetail = itemInfo.apk_detail) != null) {
                if (!ej.isEmpty(apkDetail.developer)) {
                    this.a.add(new yp6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04f4), itemInfo.apk_detail.developer, null));
                }
                if (!ej.isEmpty(itemInfo.apk_detail.publisher)) {
                    this.a.add(new yp6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0f70), itemInfo.apk_detail.publisher, null));
                }
                if (!ej.isEmpty(itemInfo.apk_detail.version)) {
                    this.a.add(new yp6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f048d), itemInfo.apk_detail.version, null));
                }
                if (!ej.isEmpty(itemInfo.apk_detail.update_time)) {
                    this.a.add(new yp6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1504), itemInfo.apk_detail.update_time, null));
                }
                if (eh.g(itemInfo.apk_detail.size, 0L) > 0) {
                    this.a.add(new yp6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0631), StringHelper.getFormatSize(eh.g(itemInfo.apk_detail.size, 0L)), null));
                }
                int intValue = itemInfo.apk_detail.need_network.intValue();
                int i2 = R.string.obfuscated_res_0x7f0f0546;
                if (intValue > 0) {
                    ArrayList arrayList = this.a;
                    String string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09a2);
                    Resources resources = TbadkCoreApplication.getInst().getResources();
                    if (itemInfo.apk_detail.need_network.intValue() == 1) {
                        i = R.string.obfuscated_res_0x7f0f0546;
                    } else {
                        i = R.string.obfuscated_res_0x7f0f0545;
                    }
                    arrayList.add(new yp6(string, resources.getString(i), null));
                }
                if (itemInfo.apk_detail.need_inner_buy.intValue() > 0) {
                    ArrayList arrayList2 = this.a;
                    String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0850);
                    Resources resources2 = TbadkCoreApplication.getInst().getResources();
                    if (itemInfo.apk_detail.need_inner_buy.intValue() != 1) {
                        i2 = R.string.obfuscated_res_0x7f0f0545;
                    }
                    arrayList2.add(new yp6(string2, resources2.getString(i2), null));
                }
                if (!ej.isEmpty(itemInfo.apk_detail.authority_url)) {
                    this.a.add(new yp6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e3b), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09a5), itemInfo.apk_detail.authority_url));
                }
                if (!ej.isEmpty(itemInfo.apk_detail.privacy_url)) {
                    this.a.add(new yp6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0f2a), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09a5), itemInfo.apk_detail.privacy_url));
                }
            }
        }
    }
}
