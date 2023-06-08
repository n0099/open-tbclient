package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class n97 implements a87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public n97() {
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

    @Override // com.baidu.tieba.a87
    public List<i87<?, ?>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new l97("recommend_card_person_attention"));
            arrayList.add(new x87("mount"));
            arrayList.add(new i97("img_text"));
            arrayList.add(new k97("sideway_card"));
            arrayList.add(new g97("common_card"));
            arrayList.add(new j97("live_card"));
            arrayList.add(new y87("card_multi_link"));
            arrayList.add(new t87("mount_app"));
            arrayList.add(new f97("feed_voice"));
            arrayList.add(new m97("social_bar"));
            arrayList.add(new w87("live"));
            arrayList.add(new d97("video"));
            arrayList.add(new b97("card_single_link"));
            arrayList.add(new c97("title"));
            arrayList.add(new v87("feed_head"));
            arrayList.add(new h97("delegate-layout"));
            arrayList.add(new o97("video_card"));
            arrayList.add(new u87("feed_entrybar"));
            arrayList.add(new e97("virtual_head"));
            arrayList.add(new z87("origin_card"));
            arrayList.add(new a97("pic"));
            arrayList.add(new s87("abstract"));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
