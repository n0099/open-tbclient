package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public abstract class m6a implements tc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m6a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.tc7
    public Map<String, String> a(f87 businessInfo) {
        InterceptResult invokeL;
        String str;
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            HashMap hashMap = new HashMap();
            Map<String, String> a = businessInfo.a();
            hashMap.put("page_type", "a002");
            String str3 = a.get("thread_id");
            String str4 = "";
            if (str3 == null) {
                str3 = "";
            }
            hashMap.put("obj_id", str3);
            String str5 = a.get("recom_source");
            if (str5 == null) {
                str5 = "";
            }
            hashMap.put("list_strategy", str5);
            jc5 adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            boolean z2 = false;
            if (adAdSense != null && (str2 = adAdSense.k) != null) {
                if (str2.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    hashMap.put("ab_tag", str2);
                }
            }
            CharSequence charSequence = (CharSequence) hashMap.get("ab_tag");
            if ((charSequence == null || charSequence.length() == 0) ? true : true) {
                String str6 = a.get("abtest_tag");
                if (str6 == null) {
                    str6 = "";
                }
                hashMap.put("ab_tag", str6);
            }
            String str7 = a.get("is_video_work");
            String str8 = "0";
            if (str7 == null) {
                str7 = "0";
            }
            hashMap.put(TiebaStatic.Params.IS_ZP, str7);
            String str9 = a.get(TiebaStatic.Params.GUA_TYPE);
            if (str9 == null) {
                str9 = "0";
            }
            hashMap.put(TiebaStatic.Params.GUA_TYPE, str9);
            String str10 = a.get(TiebaStatic.Params.IS_SPECIAL_THREAD);
            if (str10 == null) {
                str10 = "0";
            }
            hashMap.put(TiebaStatic.Params.IS_SPECIAL_THREAD, str10);
            String str11 = a.get(TiebaStatic.Params.RECOM_TYPE);
            if (str11 != null) {
                str4 = str11;
            }
            hashMap.put(TiebaStatic.Params.RECOM_TYPE, str4);
            if (!PermissionUtil.isBrowseMode()) {
                str = "0";
            } else {
                str = "1";
            }
            hashMap.put(TiebaStatic.Params.PURE_BROWSING, str);
            String str12 = a.get("has_forum_head_pendants");
            if (str12 != null) {
                str8 = str12;
            }
            hashMap.put(TiebaStatic.Params.OBJ_PARAM3, str8);
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
