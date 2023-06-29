package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ClassForumInfo;
import tbclient.GetVerticalForumList.DataRes;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes6.dex */
public class m69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<k69> a;

    public m69() {
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

    public void a(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, dataRes) != null) || dataRes == null) {
            return;
        }
        if (dataRes.class_foruminfo != null) {
            this.a = new ArrayList();
            for (ClassForumInfo classForumInfo : dataRes.class_foruminfo) {
                k69 k69Var = new k69();
                k69Var.b = classForumInfo.class_id;
                k69Var.c = classForumInfo.class_name;
                k69Var.d = classForumInfo.class_icon;
                ArrayList arrayList = new ArrayList();
                for (RecommendForumInfo recommendForumInfo : classForumInfo.forum_info) {
                    arrayList.add(new q69(recommendForumInfo, false));
                }
                k69Var.a = arrayList;
                this.a.add(k69Var);
            }
        }
        Page page = dataRes.page;
    }
}
