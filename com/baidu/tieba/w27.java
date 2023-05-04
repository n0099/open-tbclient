package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class w27 implements j17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public w27() {
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

    @Override // com.baidu.tieba.j17
    public List<r17<?, ?>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new u27("recommend_card_person_attention"));
            arrayList.add(new g27("mount"));
            arrayList.add(new r27("img_text"));
            arrayList.add(new t27("sideway_card"));
            arrayList.add(new p27("common_card"));
            arrayList.add(new s27("live_card"));
            arrayList.add(new h27("card_multi_link"));
            arrayList.add(new c27("mount_app"));
            arrayList.add(new o27("feed_voice"));
            arrayList.add(new v27("social_bar"));
            arrayList.add(new f27("live"));
            arrayList.add(new m27("video"));
            arrayList.add(new k27("card_single_link"));
            arrayList.add(new l27("title"));
            arrayList.add(new e27("feed_head"));
            arrayList.add(new q27("delegate-layout"));
            arrayList.add(new x27("video_card"));
            arrayList.add(new d27("feed_entrybar"));
            arrayList.add(new n27("virtual_head"));
            arrayList.add(new i27("origin_card"));
            arrayList.add(new j27("pic"));
            arrayList.add(new b27("abstract"));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
