package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class tc7 implements ab7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public tc7() {
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

    @Override // com.baidu.tieba.ab7
    public List<ib7<?, ?>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new gc7("title"));
            arrayList.add(new qc7("sideway_card"));
            arrayList.add(new ac7("card_multi_link"));
            arrayList.add(new zb7("mount"));
            arrayList.add(new lc7("card_vote"));
            arrayList.add(new sc7("social_bar"));
            arrayList.add(new jc7("virtual_head"));
            arrayList.add(new mc7("common_card"));
            arrayList.add(new ec7("reply"));
            arrayList.add(new vb7("mount_app"));
            arrayList.add(new tb7("browse_location"));
            arrayList.add(new wb7("feed_entrybar"));
            arrayList.add(new kc7("feed_voice"));
            arrayList.add(new fc7("card_single_link"));
            arrayList.add(new ub7("abstract"));
            arrayList.add(new pc7("live_card"));
            arrayList.add(new oc7("img_text"));
            arrayList.add(new xb7("feed_head"));
            arrayList.add(new ic7("video"));
            arrayList.add(new cc7("pic"));
            arrayList.add(new bc7("origin_card"));
            arrayList.add(new rc7("recommend_card_person_attention"));
            arrayList.add(new uc7("video_card"));
            arrayList.add(new dc7("recommend_info"));
            arrayList.add(new hc7("video_ad"));
            arrayList.add(new nc7("delegate-layout"));
            arrayList.add(new yb7("live"));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
