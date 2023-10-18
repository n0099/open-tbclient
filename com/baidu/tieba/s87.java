package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class s87 implements y67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public s87() {
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

    @Override // com.baidu.tieba.y67
    public List<g77<?, ?>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new s77("abstract"));
            arrayList.add(new h87("video"));
            arrayList.add(new l87("common_card"));
            arrayList.add(new w77("live"));
            arrayList.add(new x77("mount"));
            arrayList.add(new p87("sideway_card"));
            arrayList.add(new t77("mount_app"));
            arrayList.add(new u77("feed_entrybar"));
            arrayList.add(new k87("card_vote"));
            arrayList.add(new q87("recommend_card_person_attention"));
            arrayList.add(new v77("feed_head"));
            arrayList.add(new g87("video_ad"));
            arrayList.add(new f87("title"));
            arrayList.add(new o87("live_card"));
            arrayList.add(new a87("pei_wan"));
            arrayList.add(new j87("feed_voice"));
            arrayList.add(new n87("img_text"));
            arrayList.add(new r87("social_bar"));
            arrayList.add(new c87("recommend_info"));
            arrayList.add(new t87("video_card"));
            arrayList.add(new r77("browse_location"));
            arrayList.add(new z77("origin_card"));
            arrayList.add(new d87("reply"));
            arrayList.add(new m87("delegate-layout"));
            arrayList.add(new b87("pic"));
            arrayList.add(new y77("card_multi_link"));
            arrayList.add(new i87("virtual_head"));
            arrayList.add(new e87("card_single_link"));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
