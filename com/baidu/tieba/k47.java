package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class k47 implements x27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k47() {
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

    @Override // com.baidu.tieba.x27
    public List<f37<?, ?>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new i47("recommend_card_person_attention"));
            arrayList.add(new u37("mount"));
            arrayList.add(new f47("img_text"));
            arrayList.add(new h47("sideway_card"));
            arrayList.add(new d47("common_card"));
            arrayList.add(new g47("live_card"));
            arrayList.add(new v37("card_multi_link"));
            arrayList.add(new q37("mount_app"));
            arrayList.add(new c47("feed_voice"));
            arrayList.add(new j47("social_bar"));
            arrayList.add(new t37("live"));
            arrayList.add(new a47("video"));
            arrayList.add(new y37("card_single_link"));
            arrayList.add(new z37("title"));
            arrayList.add(new s37("feed_head"));
            arrayList.add(new e47("delegate-layout"));
            arrayList.add(new l47("video_card"));
            arrayList.add(new r37("feed_entrybar"));
            arrayList.add(new b47("virtual_head"));
            arrayList.add(new w37("origin_card"));
            arrayList.add(new x37("pic"));
            arrayList.add(new p37("abstract"));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
