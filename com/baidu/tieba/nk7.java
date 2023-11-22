package com.baidu.tieba;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.forum.statistic.ForumStatConstant$TabType;
import com.baidu.tieba.oa7;
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
public final class nk7 implements oa7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public final Bundle b;
    public final List<cb7> c;
    public final ForumStatConstant$TabType d;
    public final long e;

    public nk7(BdUniqueId pageId, Bundle bundle) {
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
        this.d = ok7.a(this.b);
        this.e = this.b.getLong("forum_id");
    }

    @Override // com.baidu.tieba.oa7.c
    public void a(ab7<?> data, za7<?, ?> template, int i) {
        ka7 ka7Var;
        Map<String, String> emptyMap;
        Map<String, String> emptyMap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, data, template, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(template, "template");
            if (data instanceof ka7) {
                ka7Var = (ka7) data;
            } else {
                ka7Var = null;
            }
            if (ka7Var == null) {
                return;
            }
            w67 w67Var = ka7Var.a;
            if (w67Var == null || (emptyMap = w67Var.a()) == null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("get_position", String.valueOf(i + 1));
            linkedHashMap.put(LegoListActivityConfig.PAGE_ID, this.a.toString());
            e57 e57Var = ka7Var.b;
            if (e57Var == null || (emptyMap2 = e57Var.a()) == null) {
                emptyMap2 = MapsKt__MapsKt.emptyMap();
            }
            this.c.add(new cb7("card_show", emptyMap, linkedHashMap, emptyMap2));
            ka7 ka7Var2 = (ka7) data;
            if (ka7Var2.b() instanceof f57) {
                T b = ka7Var2.b();
                if (b != 0) {
                    Iterator<ab7<? extends Object>> it = ((f57) b).c().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ab7<? extends Object> next = it.next();
                        if (next instanceof x37) {
                            x37 x37Var = (x37) next;
                            c(x37Var.p().c(), linkedHashMap);
                            c(x37Var.p().a(), linkedHashMap);
                            break;
                        } else if (next instanceof l47) {
                            l47 l47Var = (l47) next;
                            c(l47Var.p().d(), linkedHashMap);
                            c(l47Var.p().b(), linkedHashMap);
                            break;
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.feed.data.CardData<*>");
                }
            }
            rk7.a.e(emptyMap2, this.d, String.valueOf(this.e), i);
        }
    }

    @Override // com.baidu.tieba.oa7.c
    public void b(RecyclerView rv) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rv) == null) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            e();
        }
    }

    public final void c(List<? extends u57> list, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, map) == null) {
            for (u57 u57Var : list) {
                if (!u57Var.E().isEmpty()) {
                    this.c.add(new cb7("head_tag_show", u57Var.E(), map, MapsKt__MapsKt.emptyMap()));
                }
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e();
            jb7.a.a(this.a.toString());
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (cb7 cb7Var : this.c) {
                jb7.a.c(cb7Var);
            }
            this.c.clear();
        }
    }
}
