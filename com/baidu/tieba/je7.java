package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class je7 implements pc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public je7() {
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

    @Override // com.baidu.tieba.pc7
    public List<xc7<?, ?>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new od7("mount"));
            arrayList.add(new sd7("pic"));
            arrayList.add(new jd7("abstract"));
            arrayList.add(new ee7("img_text"));
            arrayList.add(new nd7("live"));
            arrayList.add(new ie7("social_bar"));
            arrayList.add(new ae7("feed_voice"));
            arrayList.add(new vd7("card_single_link"));
            arrayList.add(new ke7("video_card"));
            arrayList.add(new pd7("card_multi_link"));
            arrayList.add(new td7("recommend_info"));
            arrayList.add(new he7("recommend_card_person_attention"));
            arrayList.add(new ld7("feed_entrybar"));
            arrayList.add(new id7("browse_location"));
            arrayList.add(new yd7("video"));
            arrayList.add(new zd7("virtual_head"));
            arrayList.add(new de7("delegate-layout"));
            arrayList.add(new rd7("pei_wan"));
            arrayList.add(new kd7("mount_app"));
            arrayList.add(new ud7("reply"));
            arrayList.add(new wd7("title"));
            arrayList.add(new qd7("origin_card"));
            arrayList.add(new xd7("video_ad"));
            arrayList.add(new ce7("common_card"));
            arrayList.add(new ge7("sideway_card"));
            arrayList.add(new fe7("live_card"));
            arrayList.add(new md7("feed_head"));
            arrayList.add(new be7("card_vote"));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
