package com.baidu.tieba;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.forum.statistic.ForumStatConstant$TabType;
import com.baidu.tieba.gb7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class tm7 implements gb7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public final Bundle b;
    public final List<ub7> c;
    public final ForumStatConstant$TabType d;
    public final long e;

    public tm7(BdUniqueId pageId, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageId, bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.a = pageId;
        this.b = bundle;
        this.c = new ArrayList();
        this.d = um7.a(this.b);
        this.e = this.b.getLong("forum_id");
    }

    @Override // com.baidu.tieba.gb7.c
    public void a(sb7<?> data, rb7<?, ?> template, int i) {
        cb7 cb7Var;
        Map<String, String> emptyMap;
        Map<String, String> emptyMap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, data, template, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(template, "template");
            if (data instanceof cb7) {
                cb7Var = (cb7) data;
            } else {
                cb7Var = null;
            }
            if (cb7Var == null) {
                return;
            }
            n77 n77Var = cb7Var.a;
            if (n77Var == null || (emptyMap = n77Var.a()) == null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("get_position", String.valueOf(i + 1));
            linkedHashMap.put(LegoListActivityConfig.PAGE_ID, this.a.toString());
            v57 v57Var = cb7Var.b;
            if (v57Var == null || (emptyMap2 = v57Var.a()) == null) {
                emptyMap2 = MapsKt__MapsKt.emptyMap();
            }
            this.c.add(new ub7("card_show", emptyMap, linkedHashMap, emptyMap2));
            cb7 cb7Var2 = (cb7) data;
            if (cb7Var2.b() instanceof w57) {
                T b = cb7Var2.b();
                if (b != 0) {
                    Iterator<sb7<? extends Object>> it = ((w57) b).c().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        sb7<? extends Object> next = it.next();
                        if (next instanceof o47) {
                            o47 o47Var = (o47) next;
                            c(o47Var.p().c(), linkedHashMap);
                            c(o47Var.p().a(), linkedHashMap);
                            break;
                        } else if (next instanceof c57) {
                            c57 c57Var = (c57) next;
                            c(c57Var.p().d(), linkedHashMap);
                            c(c57Var.p().b(), linkedHashMap);
                            break;
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.feed.data.CardData<*>");
                }
            }
            zm7.a.e(emptyMap2, this.d, String.valueOf(this.e), i);
        }
    }

    @Override // com.baidu.tieba.gb7.c
    public void b(RecyclerView rv) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rv) == null) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            e();
        }
    }

    public final void c(List<? extends l67> list, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, map) == null) {
            for (l67 l67Var : list) {
                if (!l67Var.E().isEmpty()) {
                    this.c.add(new ub7("head_tag_show", l67Var.E(), map, MapsKt__MapsKt.emptyMap()));
                }
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e();
            bc7.a.a(this.a.toString());
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (ub7 ub7Var : this.c) {
                bc7.a.c(ub7Var);
            }
            this.c.clear();
        }
    }
}
