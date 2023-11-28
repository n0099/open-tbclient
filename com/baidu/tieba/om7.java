package com.baidu.tieba;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.bb7;
import com.baidu.tieba.forum.statistic.ForumStatConstant$TabType;
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
public final class om7 implements bb7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public final Bundle b;
    public final List<pb7> c;
    public final ForumStatConstant$TabType d;
    public final long e;

    public om7(BdUniqueId pageId, Bundle bundle) {
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
        this.d = pm7.a(this.b);
        this.e = this.b.getLong("forum_id");
    }

    @Override // com.baidu.tieba.bb7.c
    public void a(nb7<?> data, mb7<?, ?> template, int i) {
        xa7 xa7Var;
        Map<String, String> emptyMap;
        Map<String, String> emptyMap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, data, template, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(template, "template");
            if (data instanceof xa7) {
                xa7Var = (xa7) data;
            } else {
                xa7Var = null;
            }
            if (xa7Var == null) {
                return;
            }
            j77 j77Var = xa7Var.a;
            if (j77Var == null || (emptyMap = j77Var.a()) == null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("get_position", String.valueOf(i + 1));
            linkedHashMap.put(LegoListActivityConfig.PAGE_ID, this.a.toString());
            r57 r57Var = xa7Var.b;
            if (r57Var == null || (emptyMap2 = r57Var.a()) == null) {
                emptyMap2 = MapsKt__MapsKt.emptyMap();
            }
            this.c.add(new pb7("card_show", emptyMap, linkedHashMap, emptyMap2));
            xa7 xa7Var2 = (xa7) data;
            if (xa7Var2.b() instanceof s57) {
                T b = xa7Var2.b();
                if (b != 0) {
                    Iterator<nb7<? extends Object>> it = ((s57) b).c().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        nb7<? extends Object> next = it.next();
                        if (next instanceof k47) {
                            k47 k47Var = (k47) next;
                            c(k47Var.p().c(), linkedHashMap);
                            c(k47Var.p().a(), linkedHashMap);
                            break;
                        } else if (next instanceof y47) {
                            y47 y47Var = (y47) next;
                            c(y47Var.p().d(), linkedHashMap);
                            c(y47Var.p().b(), linkedHashMap);
                            break;
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.feed.data.CardData<*>");
                }
            }
            um7.a.e(emptyMap2, this.d, String.valueOf(this.e), i);
        }
    }

    @Override // com.baidu.tieba.bb7.c
    public void b(RecyclerView rv) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rv) == null) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            e();
        }
    }

    public final void c(List<? extends h67> list, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, map) == null) {
            for (h67 h67Var : list) {
                if (!h67Var.E().isEmpty()) {
                    this.c.add(new pb7("head_tag_show", h67Var.E(), map, MapsKt__MapsKt.emptyMap()));
                }
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e();
            wb7.a.a(this.a.toString());
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (pb7 pb7Var : this.c) {
                wb7.a.c(pb7Var);
            }
            this.c.clear();
        }
    }
}
