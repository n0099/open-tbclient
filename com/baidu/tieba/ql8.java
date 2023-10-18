package com.baidu.tieba;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class ql8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayoutManager a;
    public ul8 b;
    public long c;
    public il8 d;
    public boolean e;
    public int f;
    public int g;
    public int h;
    public nm8 i;
    public mm8 j;
    public RecyclerView k;
    public final RecyclerView.OnScrollListener l;
    public Runnable m;

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ql8 a;

        public a(ql8 ql8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ql8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ql8Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLII(1048576, this, recyclerView, i, i2) != null) || !this.a.e || this.a.b.n() == null) {
                return;
            }
            this.a.e = false;
            if (this.a.a.findViewByPosition(this.a.g) != null) {
                ql8 ql8Var = this.a;
                ql8Var.h = ql8Var.a.findViewByPosition(this.a.g).getTop();
            }
            this.a.b.n().scrollBy(0, (this.a.p() - this.a.n()) + this.a.h);
            this.a.h = 0;
            this.a.q();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ql8 a;

        public b(ql8 ql8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ql8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ql8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.k != null && this.a.i != null && this.a.i.a() != null) {
                this.a.i.a().setLocationScrolled(false);
                this.a.k.getAdapter().notifyItemChanged(this.a.f);
            }
        }
    }

    public ql8(@NonNull LinearLayoutManager linearLayoutManager, ul8 ul8Var, long j, il8 il8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {linearLayoutManager, ul8Var, Long.valueOf(j), il8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = false;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.k = null;
        this.l = new a(this);
        this.m = new b(this);
        this.a = linearLayoutManager;
        this.b = ul8Var;
        this.c = j;
        this.d = il8Var;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c = -1L;
            this.e = false;
        }
    }

    public void r() {
        Runnable runnable;
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (runnable = this.m) != null && (recyclerView = this.k) != null) {
            recyclerView.removeCallbacks(runnable);
        }
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.b.r() != null && this.b.n() != null) {
                return (this.b.r().getHeight() / 2) - this.b.n().getTop();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final int o() {
        InterceptResult invokeV;
        il8 il8Var;
        nm8 nm8Var;
        ChatRoomInfo a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.c > 0 && (il8Var = this.d) != null && !ListUtils.isEmpty(il8Var.c())) {
                List<z68> c = this.d.c();
                for (z68 z68Var : c) {
                    if (z68Var != null && (z68Var instanceof mm8)) {
                        mm8 mm8Var = (mm8) z68Var;
                        List<z68> subItems = mm8Var.getSubItems();
                        if (ListUtils.isEmpty(subItems)) {
                            continue;
                        } else {
                            for (z68 z68Var2 : subItems) {
                                if (z68Var2 != null && (z68Var2 instanceof nm8) && (a2 = (nm8Var = (nm8) z68Var2).a()) != null && this.c == a2.getRoomId()) {
                                    this.f = subItems.indexOf(z68Var2);
                                    this.g = c.indexOf(z68Var);
                                    this.i = nm8Var;
                                    this.j = mm8Var;
                                    mm8Var.g(false);
                                    return c.indexOf(z68Var);
                                }
                            }
                            continue;
                        }
                    }
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final int p() {
        InterceptResult invokeV;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.d.getItemsCount() <= 0 || this.f <= 0 || this.b.n() == null || (viewGroup = (ViewGroup) this.b.n().getChildAt(0)) == null || viewGroup.findViewById(R.id.obfuscated_res_0x7f090ecc) == null || (viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.obfuscated_res_0x7f090ecc)) == null || viewGroup2.getChildAt(0) == null) {
                return 0;
            }
            return viewGroup2.getChildAt(0).getHeight() * (this.f + 1);
        }
        return invokeV.intValue;
    }

    public final void q() {
        ViewGroup viewGroup;
        nm8 nm8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (viewGroup = (ViewGroup) this.a.findViewByPosition(this.g)) != null) {
            RecyclerView recyclerView = (RecyclerView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090ecc);
            this.k = recyclerView;
            if (recyclerView != null && recyclerView.getChildAt(this.f) != null && (nm8Var = this.i) != null && nm8Var.a() != null) {
                this.i.a().setLocationScrolled(true);
                this.k.getAdapter().notifyItemChanged(this.f);
                this.k.postDelayed(this.m, 3000L);
            }
        }
    }

    public void s() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int o = o();
            if (o >= 0 && this.b.n() != null) {
                int findFirstVisibleItemPosition = this.a.findFirstVisibleItemPosition();
                int findLastVisibleItemPosition = this.a.findLastVisibleItemPosition();
                if (o >= findFirstVisibleItemPosition && o <= findLastVisibleItemPosition) {
                    this.e = false;
                    if (this.a.findViewByPosition(o) != null) {
                        i = this.a.findViewByPosition(o).getTop();
                    } else {
                        i = 0;
                    }
                    this.b.n().scrollBy(0, (i - n()) + p());
                    q();
                    return;
                }
                this.e = true;
                this.a.scrollToPosition(o);
            } else if (this.a != null && this.b.n() != null) {
                this.a.scrollToPosition(0);
            }
        }
    }
}
