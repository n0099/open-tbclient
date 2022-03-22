package com.baidu.tieba.pb.pb.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.r.r.f;
import c.a.p0.w2.i.s;
import c.a.p0.w2.m.f.h1.c;
import c.a.p0.w2.m.f.r;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class PbFirstFloorCommentAndPraiseAdapter extends r<s, PbFirstFloorCommentAndPraiseViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public static int t;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener o;
    public c p;
    public final LinkedList<PbFirstFloorCommentAndPraiseViewHolder> q;
    public boolean r;
    public c.a.p0.w2.q.c s;

    /* loaded from: classes5.dex */
    public static class PbFirstFloorCommentAndPraiseViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PbThreadCommentAndPraiseInfoLayout a;

        /* renamed from: b  reason: collision with root package name */
        public View f35004b;

        /* renamed from: c  reason: collision with root package name */
        public int f35005c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        public f f35006d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PbFirstFloorCommentAndPraiseViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35006d = new f();
            if (view == null) {
                return;
            }
            this.a = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.obfuscated_res_0x7f0904c8);
            f fVar = this.f35006d;
            fVar.f10852b = 4;
            fVar.f10858h = 7;
            fVar.f10853c = this.f35005c;
            fVar.f10856f = PbFirstFloorCommentAndPraiseAdapter.t;
            this.a.setAgreeStatisticData(this.f35006d);
            View findViewById = view.findViewById(R.id.obfuscated_res_0x7f0903c2);
            this.f35004b = findViewById;
            findViewById.setVisibility(0);
        }

        public void c(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sVar) == null) {
                if (sVar != null && sVar.e() != null) {
                    ThreadData e2 = sVar.e();
                    if (e2.getAgreeData() != null) {
                        e2.getAgreeData().postId = e2.getFirstPostId();
                    }
                    this.a.R(e2, sVar.b());
                    this.f35004b.setVisibility(sVar.g() ? 0 : 8);
                    if (e2.isVideoThreadType() && e2.getThreadVideoInfo() != null) {
                        this.f35005c = 2;
                    } else {
                        this.f35005c = 1;
                    }
                    if (sVar.f19855b) {
                        b().setPadding(0, 0, 0, n.f(b().getContext(), R.dimen.tbds32));
                    }
                    this.a.showOperationMaskView(sVar.i());
                }
                d();
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setBackgroundColor(this.f35004b, R.color.CAM_X0203);
                this.a.onChangeSkinType();
            }
        }

        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f35006d.j = str;
            }
        }

        public void f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.a.setTopicId(str);
            }
        }

        public void g(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.setTopicSubjectName(str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorCommentAndPraiseAdapter(c.a.p0.w2.q.c cVar, BdUniqueId bdUniqueId) {
        super(cVar, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.p0.w2.q.c) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new LinkedList<>();
        this.r = false;
        if (cVar != null && cVar.w() != null) {
            t = cVar.w().R0();
        }
        this.s = cVar;
        this.p = new c(cVar);
    }

    @Override // c.a.p0.w2.m.f.r, c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        l0(i, view, viewGroup, (s) obj, (PbFirstFloorCommentAndPraiseViewHolder) viewHolder);
        return view;
    }

    public void c0(String str, String str2) {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            if (this.q.size() > 0) {
                Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.q.iterator();
                while (it.hasNext()) {
                    PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                    if (next != null && (pbThreadCommentAndPraiseInfoLayout = next.a) != null) {
                        pbThreadCommentAndPraiseInfoLayout.N(str, str2);
                    }
                }
            } else if (f0() == null) {
            } else {
                this.p.b(f0().getAgreeData());
            }
        }
    }

    public final String d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.i.w() != null ? this.i.w().getForumId() : "" : (String) invokeV.objValue;
    }

    public final String e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.i.w() != null ? this.i.w().getFromForumId() : "" : (String) invokeV.objValue;
    }

    public final ThreadData f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.i.w() == null || this.i.w().S0() == null) {
                return null;
            }
            return this.i.w().S0().O();
        }
        return (ThreadData) invokeV.objValue;
    }

    public final String g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ThreadData f0 = f0();
            return f0 != null ? f0.getFirstPostId() : "";
        }
        return (String) invokeV.objValue;
    }

    public final String h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.p0.w2.q.c cVar = this.s;
            return (cVar == null || cVar.w() == null) ? "" : this.s.w().getTopicId();
        }
        return (String) invokeV.objValue;
    }

    public final String i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c.a.p0.w2.q.c cVar = this.s;
            return (cVar == null || cVar.w() == null) ? "" : this.s.w().o1();
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: j0 */
    public PbFirstFloorCommentAndPraiseViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = new PbFirstFloorCommentAndPraiseViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d04af, viewGroup, false));
            pbFirstFloorCommentAndPraiseViewHolder.f(h0());
            pbFirstFloorCommentAndPraiseViewHolder.g(i0());
            this.q.add(pbFirstFloorCommentAndPraiseViewHolder);
            return pbFirstFloorCommentAndPraiseViewHolder;
        }
        return (PbFirstFloorCommentAndPraiseViewHolder) invokeL.objValue;
    }

    public final void k0() {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.q.iterator();
            while (it.hasNext()) {
                PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                if (next != null && (pbThreadCommentAndPraiseInfoLayout = next.a) != null) {
                    pbThreadCommentAndPraiseInfoLayout.onDestroy();
                }
            }
        }
    }

    public View l0(int i, View view, ViewGroup viewGroup, s sVar, PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), view, viewGroup, sVar, pbFirstFloorCommentAndPraiseViewHolder})) == null) {
            super.S(i, view, viewGroup, sVar, pbFirstFloorCommentAndPraiseViewHolder);
            if (sVar != null && pbFirstFloorCommentAndPraiseViewHolder != null) {
                sVar.e().statFloor = C(i) + 1;
                pbFirstFloorCommentAndPraiseViewHolder.a.setOnClickOutListener(this.o);
                pbFirstFloorCommentAndPraiseViewHolder.a.setPostId(g0());
                pbFirstFloorCommentAndPraiseViewHolder.a.setForumId(d0());
                sVar.k(this.r);
                pbFirstFloorCommentAndPraiseViewHolder.e(e0());
                pbFirstFloorCommentAndPraiseViewHolder.c(sVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.r = z;
        }
    }

    public void n0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            k0();
            c cVar = this.p;
            if (cVar != null) {
                cVar.d();
            }
        }
    }
}
