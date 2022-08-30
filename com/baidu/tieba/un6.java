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
public class un6 extends ho4 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId b;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<zn6> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948216812, "Lcom/baidu/tieba/un6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948216812, "Lcom/baidu/tieba/un6;");
                return;
            }
        }
        b = BdUniqueId.gen();
    }

    public un6() {
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

    public ArrayList<zn6> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !ListUtils.isEmpty(this.a) : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ho4
    public eq4 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (eq4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ho4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.pn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? b : (BdUniqueId) invokeV.objValue;
    }

    public void h(ItemInfo itemInfo) {
        ApkDetail apkDetail;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, itemInfo) == null) {
            if (this.a == null) {
                this.a = new ArrayList<>();
            }
            this.a.clear();
            if (itemInfo == null || (apkDetail = itemInfo.apk_detail) == null) {
                return;
            }
            if (!qi.isEmpty(apkDetail.developer)) {
                this.a.add(new zn6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04e8), itemInfo.apk_detail.developer, null));
            }
            if (!qi.isEmpty(itemInfo.apk_detail.publisher)) {
                this.a.add(new zn6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0f40), itemInfo.apk_detail.publisher, null));
            }
            if (!qi.isEmpty(itemInfo.apk_detail.version)) {
                this.a.add(new zn6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0481), itemInfo.apk_detail.version, null));
            }
            if (!qi.isEmpty(itemInfo.apk_detail.update_time)) {
                this.a.add(new zn6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14ca), itemInfo.apk_detail.update_time, null));
            }
            if (pg.g(itemInfo.apk_detail.size, 0L) > 0) {
                this.a.add(new zn6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0615), StringHelper.getFormatSize(pg.g(itemInfo.apk_detail.size, 0L)), null));
            }
            int intValue = itemInfo.apk_detail.need_network.intValue();
            int i = R.string.obfuscated_res_0x7f0f0532;
            if (intValue > 0) {
                this.a.add(new zn6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0982), TbadkCoreApplication.getInst().getResources().getString(itemInfo.apk_detail.need_network.intValue() == 1 ? R.string.obfuscated_res_0x7f0f0532 : R.string.obfuscated_res_0x7f0f0531), null));
            }
            if (itemInfo.apk_detail.need_inner_buy.intValue() > 0) {
                ArrayList<zn6> arrayList = this.a;
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0831);
                Resources resources = TbadkCoreApplication.getInst().getResources();
                if (itemInfo.apk_detail.need_inner_buy.intValue() != 1) {
                    i = R.string.obfuscated_res_0x7f0f0531;
                }
                arrayList.add(new zn6(string, resources.getString(i), null));
            }
            if (!qi.isEmpty(itemInfo.apk_detail.authority_url)) {
                this.a.add(new zn6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e10), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0985), itemInfo.apk_detail.authority_url));
            }
            if (qi.isEmpty(itemInfo.apk_detail.privacy_url)) {
                return;
            }
            this.a.add(new zn6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0efb), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0985), itemInfo.apk_detail.privacy_url));
        }
    }
}
