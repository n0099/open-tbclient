package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetVipInfo.VipThemeItem;
/* loaded from: classes7.dex */
public class s99 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    public s99(VipThemeItem vipThemeItem) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipThemeItem};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        vipThemeItem.props_id.intValue();
        String str = vipThemeItem.title;
        String str2 = vipThemeItem.img_url;
        String str3 = vipThemeItem.tag_img_url;
        this.a = vipThemeItem.props_category.intValue();
        String str4 = vipThemeItem.props_category_name;
        String str5 = vipThemeItem.link;
        String str6 = vipThemeItem.update_time;
        vipThemeItem.id.intValue();
        vipThemeItem.type.intValue();
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }
}
