package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class x97 implements k87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public x97() {
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

    @Override // com.baidu.tieba.k87
    public List<s87<?, ?>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new v97("recommend_card_person_attention"));
            arrayList.add(new h97("mount"));
            arrayList.add(new s97("img_text"));
            arrayList.add(new u97("sideway_card"));
            arrayList.add(new q97("common_card"));
            arrayList.add(new t97("live_card"));
            arrayList.add(new i97("card_multi_link"));
            arrayList.add(new d97("mount_app"));
            arrayList.add(new p97("feed_voice"));
            arrayList.add(new w97("social_bar"));
            arrayList.add(new g97("live"));
            arrayList.add(new n97("video"));
            arrayList.add(new l97("card_single_link"));
            arrayList.add(new m97("title"));
            arrayList.add(new f97("feed_head"));
            arrayList.add(new r97("delegate-layout"));
            arrayList.add(new y97("video_card"));
            arrayList.add(new e97("feed_entrybar"));
            arrayList.add(new o97("virtual_head"));
            arrayList.add(new j97("origin_card"));
            arrayList.add(new k97("pic"));
            arrayList.add(new c97("abstract"));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
