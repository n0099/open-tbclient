package com.baidu.tieba;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.forum.statistic.ForumStatConstant$TabType;
import com.baidu.tieba.na7;
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
/* loaded from: classes7.dex */
public final class mk7 implements na7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public final Bundle b;
    public final List<bb7> c;
    public final ForumStatConstant$TabType d;
    public final long e;

    public mk7(BdUniqueId pageId, Bundle bundle) {
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
        this.d = nk7.a(this.b);
        this.e = this.b.getLong("forum_id");
    }

    @Override // com.baidu.tieba.na7.c
    public void a(za7<?> data, ya7<?, ?> template, int i) {
        ja7 ja7Var;
        Map<String, String> emptyMap;
        Map<String, String> emptyMap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, data, template, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(template, "template");
            if (data instanceof ja7) {
                ja7Var = (ja7) data;
            } else {
                ja7Var = null;
            }
            if (ja7Var == null) {
                return;
            }
            v67 v67Var = ja7Var.a;
            if (v67Var == null || (emptyMap = v67Var.a()) == null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("get_position", String.valueOf(i + 1));
            linkedHashMap.put(LegoListActivityConfig.PAGE_ID, this.a.toString());
            d57 d57Var = ja7Var.b;
            if (d57Var == null || (emptyMap2 = d57Var.a()) == null) {
                emptyMap2 = MapsKt__MapsKt.emptyMap();
            }
            this.c.add(new bb7("card_show", emptyMap, linkedHashMap, emptyMap2));
            ja7 ja7Var2 = (ja7) data;
            if (ja7Var2.b() instanceof e57) {
                T b = ja7Var2.b();
                if (b != 0) {
                    Iterator<za7<? extends Object>> it = ((e57) b).c().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        za7<? extends Object> next = it.next();
                        if (next instanceof w37) {
                            w37 w37Var = (w37) next;
                            c(w37Var.p().c(), linkedHashMap);
                            c(w37Var.p().a(), linkedHashMap);
                            break;
                        } else if (next instanceof k47) {
                            k47 k47Var = (k47) next;
                            c(k47Var.p().d(), linkedHashMap);
                            c(k47Var.p().b(), linkedHashMap);
                            break;
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.feed.data.CardData<*>");
                }
            }
            qk7.a.e(emptyMap2, this.d, String.valueOf(this.e), i);
        }
    }

    @Override // com.baidu.tieba.na7.c
    public void b(RecyclerView rv) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rv) == null) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            e();
        }
    }

    public final void c(List<? extends t57> list, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, map) == null) {
            for (t57 t57Var : list) {
                if (!t57Var.E().isEmpty()) {
                    this.c.add(new bb7("head_tag_show", t57Var.E(), map, MapsKt__MapsKt.emptyMap()));
                }
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e();
            ib7.a.a(this.a.toString());
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (bb7 bb7Var : this.c) {
                ib7.a.c(bb7Var);
            }
            this.c.clear();
        }
    }
}
