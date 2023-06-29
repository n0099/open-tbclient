package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumList;
import tbclient.GetDislikeList.DataRes;
/* loaded from: classes7.dex */
public class ov9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<mv9> a;
    public boolean b;

    public ov9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.b = true;
    }

    public void a(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, dataRes) != null) || dataRes == null) {
            return;
        }
        for (ForumList forumList : dataRes.forum_list) {
            mv9 mv9Var = new mv9();
            mv9Var.a = forumList.avatar;
            mv9Var.b = forumList.forum_name;
            mv9Var.c = String.valueOf(forumList.forum_id);
            this.a.add(mv9Var);
        }
        boolean z = true;
        if (dataRes.has_more.intValue() != 1) {
            z = false;
        }
        this.b = z;
    }
}
