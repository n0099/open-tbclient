package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActBtn;
import tbclient.TPointPost;
import tbclient.Timgs;
import tbclient.VideoInfo;
/* loaded from: classes7.dex */
public class nra {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public ArrayList<mra> b;
    public ArrayList<pra> c;

    public nra(TPointPost tPointPost) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tPointPost};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (tPointPost != null) {
            try {
                String str = tPointPost.position;
                tPointPost.template_id.longValue();
                if (tPointPost.is_tuiguang.intValue() == 0) {
                    z = false;
                } else {
                    z = true;
                }
                this.a = z;
                tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.b = new ArrayList<>();
                    for (int i3 = 0; i3 != list.size(); i3++) {
                        this.b.add(new mra(list.get(i3)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.c = new ArrayList<>();
                    for (int i4 = 0; i4 != list2.size(); i4++) {
                        this.c.add(new pra(list2.get(i4)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    new ora(tPointPost.detail_info);
                }
                String str2 = tPointPost.monitor_id;
                tPointPost.hidden_day.intValue();
                VideoInfo videoInfo = tPointPost.t_video;
                String str3 = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public pra a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (pra) ListUtils.getItem(this.c, 0);
        }
        return (pra) invokeV.objValue;
    }
}
