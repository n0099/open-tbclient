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
public class kd7 extends jw4 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId b;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<pd7> a;

    @Override // com.baidu.tieba.jw4
    public hy4 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (hy4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jw4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947909323, "Lcom/baidu/tieba/kd7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947909323, "Lcom/baidu/tieba/kd7;");
                return;
            }
        }
        b = BdUniqueId.gen();
    }

    public kd7() {
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

    public ArrayList<pd7> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return !ListUtils.isEmpty(this.a);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.hn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return b;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void e(ItemInfo itemInfo) {
        ApkDetail apkDetail;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, itemInfo) == null) {
            if (this.a == null) {
                this.a = new ArrayList<>();
            }
            this.a.clear();
            if (itemInfo != null && (apkDetail = itemInfo.apk_detail) != null) {
                if (!hi.isEmpty(apkDetail.developer)) {
                    this.a.add(new pd7(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0517), itemInfo.apk_detail.developer, null));
                }
                if (!hi.isEmpty(itemInfo.apk_detail.publisher)) {
                    this.a.add(new pd7(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1017), itemInfo.apk_detail.publisher, null));
                }
                if (!hi.isEmpty(itemInfo.apk_detail.version)) {
                    this.a.add(new pd7(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04ae), itemInfo.apk_detail.version, null));
                }
                if (!hi.isEmpty(itemInfo.apk_detail.update_time)) {
                    this.a.add(new pd7(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1601), itemInfo.apk_detail.update_time, null));
                }
                if (gg.g(itemInfo.apk_detail.size, 0L) > 0) {
                    this.a.add(new pd7(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f066e), StringHelper.getFormatSize(gg.g(itemInfo.apk_detail.size, 0L)), null));
                }
                int intValue = itemInfo.apk_detail.need_network.intValue();
                int i2 = R.string.editor_dialog_yes;
                if (intValue > 0) {
                    ArrayList<pd7> arrayList = this.a;
                    String string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a3f);
                    Resources resources = TbadkCoreApplication.getInst().getResources();
                    if (itemInfo.apk_detail.need_network.intValue() == 1) {
                        i = R.string.editor_dialog_yes;
                    } else {
                        i = R.string.editor_dialog_no;
                    }
                    arrayList.add(new pd7(string, resources.getString(i), null));
                }
                if (itemInfo.apk_detail.need_inner_buy.intValue() > 0) {
                    ArrayList<pd7> arrayList2 = this.a;
                    String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f08d6);
                    Resources resources2 = TbadkCoreApplication.getInst().getResources();
                    if (itemInfo.apk_detail.need_inner_buy.intValue() != 1) {
                        i2 = R.string.editor_dialog_no;
                    }
                    arrayList2.add(new pd7(string2, resources2.getString(i2), null));
                }
                if (!hi.isEmpty(itemInfo.apk_detail.authority_url)) {
                    this.a.add(new pd7(TbadkCoreApplication.getInst().getResources().getString(R.string.permission_info), TbadkCoreApplication.getInst().getResources().getString(R.string.item_browse), itemInfo.apk_detail.authority_url));
                }
                if (!hi.isEmpty(itemInfo.apk_detail.privacy_url)) {
                    this.a.add(new pd7(TbadkCoreApplication.getInst().getResources().getString(R.string.privacy_info), TbadkCoreApplication.getInst().getResources().getString(R.string.item_browse), itemInfo.apk_detail.privacy_url));
                }
            }
        }
    }
}
