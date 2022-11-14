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
/* loaded from: classes5.dex */
public class or6 extends sr4 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId b;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<tr6> a;

    @Override // com.baidu.tieba.sr4
    public pt4 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (pt4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sr4
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948041910, "Lcom/baidu/tieba/or6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948041910, "Lcom/baidu/tieba/or6;");
                return;
            }
        }
        b = BdUniqueId.gen();
    }

    public or6() {
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

    public ArrayList<tr6> c() {
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

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.xn
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
                this.a = new ArrayList<>();
            }
            this.a.clear();
            if (itemInfo != null && (apkDetail = itemInfo.apk_detail) != null) {
                if (!xi.isEmpty(apkDetail.developer)) {
                    this.a.add(new tr6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04f7), itemInfo.apk_detail.developer, null));
                }
                if (!xi.isEmpty(itemInfo.apk_detail.publisher)) {
                    this.a.add(new tr6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0f8d), itemInfo.apk_detail.publisher, null));
                }
                if (!xi.isEmpty(itemInfo.apk_detail.version)) {
                    this.a.add(new tr6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0490), itemInfo.apk_detail.version, null));
                }
                if (!xi.isEmpty(itemInfo.apk_detail.update_time)) {
                    this.a.add(new tr6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1529), itemInfo.apk_detail.update_time, null));
                }
                if (xg.g(itemInfo.apk_detail.size, 0L) > 0) {
                    this.a.add(new tr6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0635), StringHelper.getFormatSize(xg.g(itemInfo.apk_detail.size, 0L)), null));
                }
                int intValue = itemInfo.apk_detail.need_network.intValue();
                int i2 = R.string.obfuscated_res_0x7f0f054a;
                if (intValue > 0) {
                    ArrayList<tr6> arrayList = this.a;
                    String string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09b0);
                    Resources resources = TbadkCoreApplication.getInst().getResources();
                    if (itemInfo.apk_detail.need_network.intValue() == 1) {
                        i = R.string.obfuscated_res_0x7f0f054a;
                    } else {
                        i = R.string.obfuscated_res_0x7f0f0549;
                    }
                    arrayList.add(new tr6(string, resources.getString(i), null));
                }
                if (itemInfo.apk_detail.need_inner_buy.intValue() > 0) {
                    ArrayList<tr6> arrayList2 = this.a;
                    String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0858);
                    Resources resources2 = TbadkCoreApplication.getInst().getResources();
                    if (itemInfo.apk_detail.need_inner_buy.intValue() != 1) {
                        i2 = R.string.obfuscated_res_0x7f0f0549;
                    }
                    arrayList2.add(new tr6(string2, resources2.getString(i2), null));
                }
                if (!xi.isEmpty(itemInfo.apk_detail.authority_url)) {
                    this.a.add(new tr6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e58), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09b3), itemInfo.apk_detail.authority_url));
                }
                if (!xi.isEmpty(itemInfo.apk_detail.privacy_url)) {
                    this.a.add(new tr6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0f47), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09b3), itemInfo.apk_detail.privacy_url));
                }
            }
        }
    }
}
