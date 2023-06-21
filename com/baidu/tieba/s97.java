package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class s97 implements f87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public s97() {
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

    @Override // com.baidu.tieba.f87
    public List<n87<?, ?>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new q97("recommend_card_person_attention"));
            arrayList.add(new c97("mount"));
            arrayList.add(new n97("img_text"));
            arrayList.add(new p97("sideway_card"));
            arrayList.add(new l97("common_card"));
            arrayList.add(new o97("live_card"));
            arrayList.add(new d97("card_multi_link"));
            arrayList.add(new y87("mount_app"));
            arrayList.add(new k97("feed_voice"));
            arrayList.add(new r97("social_bar"));
            arrayList.add(new b97("live"));
            arrayList.add(new i97("video"));
            arrayList.add(new g97("card_single_link"));
            arrayList.add(new h97("title"));
            arrayList.add(new a97("feed_head"));
            arrayList.add(new m97("delegate-layout"));
            arrayList.add(new t97("video_card"));
            arrayList.add(new z87("feed_entrybar"));
            arrayList.add(new j97("virtual_head"));
            arrayList.add(new e97("origin_card"));
            arrayList.add(new f97("pic"));
            arrayList.add(new x87("abstract"));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
