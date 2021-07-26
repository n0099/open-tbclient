package com.baidu.tieba.pb.pb.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.f;
import d.a.q0.h2.h.p;
import d.a.q0.h2.k.e.a1.c;
import d.a.q0.h2.k.e.o;
import d.a.q0.h2.o.b;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class PbFirstFloorCommentAndPraiseAdapter extends o<p, PbFirstFloorCommentAndPraiseViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public static int w;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener s;
    public c t;
    public final LinkedList<PbFirstFloorCommentAndPraiseViewHolder> u;
    public boolean v;

    /* loaded from: classes4.dex */
    public static class PbFirstFloorCommentAndPraiseViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public PbThreadCommentAndPraiseInfoLayout f19564a;

        /* renamed from: b  reason: collision with root package name */
        public View f19565b;

        /* renamed from: c  reason: collision with root package name */
        public int f19566c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        public f f19567d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PbFirstFloorCommentAndPraiseViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19567d = new f();
            if (view == null) {
                return;
            }
            this.f19564a = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
            f fVar = this.f19567d;
            fVar.f53311b = 4;
            fVar.f53317h = 7;
            fVar.f53312c = this.f19566c;
            fVar.f53315f = PbFirstFloorCommentAndPraiseAdapter.w;
            this.f19564a.setAgreeStatisticData(this.f19567d);
            View findViewById = view.findViewById(R.id.bottom_divider_line);
            this.f19565b = findViewById;
            findViewById.setVisibility(0);
        }

        public void b(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) {
                if (pVar != null && pVar.d() != null) {
                    b2 d2 = pVar.d();
                    if (d2.z() != null) {
                        d2.z().postId = d2.U();
                    }
                    this.f19564a.V(d2, pVar.c());
                    this.f19565b.setVisibility(pVar.h() ? 0 : 8);
                    if (d2.s2() && d2.m1() != null) {
                        this.f19566c = 2;
                    } else {
                        this.f19566c = 1;
                    }
                    if (pVar.f57480f) {
                        a().setPadding(0, 0, 0, l.g(a().getContext(), R.dimen.tbds32));
                    }
                    this.f19564a.showOperationMaskView(pVar.i());
                }
                c();
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setBackgroundColor(this.f19565b, R.color.CAM_X0203);
                this.f19564a.onChangeSkinType();
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f19567d.j = str;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorCommentAndPraiseAdapter(b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = new LinkedList<>();
        this.v = false;
        if (bVar != null && bVar.y() != null) {
            w = bVar.y().K0();
        }
        this.t = new c(bVar);
    }

    @Override // d.a.q0.h2.k.e.o, d.a.d.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        p0(i2, view, viewGroup, (p) obj, (PbFirstFloorCommentAndPraiseViewHolder) viewHolder);
        return view;
    }

    public void i0(String str, String str2) {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            if (this.u.size() > 0) {
                Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.u.iterator();
                while (it.hasNext()) {
                    PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                    if (next != null && (pbThreadCommentAndPraiseInfoLayout = next.f19564a) != null) {
                        pbThreadCommentAndPraiseInfoLayout.R(str, str2);
                    }
                }
            } else if (l0() == null) {
            } else {
                this.t.b(l0().z());
            }
        }
    }

    public final String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m.y() != null ? this.m.y().getForumId() : "" : (String) invokeV.objValue;
    }

    public final String k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m.y() != null ? this.m.y().getFromForumId() : "" : (String) invokeV.objValue;
    }

    public final b2 l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.m.y() == null || this.m.y().L0() == null) {
                return null;
            }
            return this.m.y().L0().N();
        }
        return (b2) invokeV.objValue;
    }

    public final String m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b2 l0 = l0();
            return l0 != null ? l0.U() : "";
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: n0 */
    public PbFirstFloorCommentAndPraiseViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = new PbFirstFloorCommentAndPraiseViewHolder(LayoutInflater.from(this.f42341e).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
            this.u.add(pbFirstFloorCommentAndPraiseViewHolder);
            return pbFirstFloorCommentAndPraiseViewHolder;
        }
        return (PbFirstFloorCommentAndPraiseViewHolder) invokeL.objValue;
    }

    public final void o0() {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.u.iterator();
            while (it.hasNext()) {
                PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                if (next != null && (pbThreadCommentAndPraiseInfoLayout = next.f19564a) != null) {
                    pbThreadCommentAndPraiseInfoLayout.onDestroy();
                }
            }
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            o0();
            c cVar = this.t;
            if (cVar != null) {
                cVar.d();
            }
        }
    }

    public View p0(int i2, View view, ViewGroup viewGroup, p pVar, PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), view, viewGroup, pVar, pbFirstFloorCommentAndPraiseViewHolder})) == null) {
            super.X(i2, view, viewGroup, pVar, pbFirstFloorCommentAndPraiseViewHolder);
            if (pVar != null && pbFirstFloorCommentAndPraiseViewHolder != null) {
                pVar.d().P1 = F(i2) + 1;
                pbFirstFloorCommentAndPraiseViewHolder.f19564a.setOnClickOutListener(this.s);
                pbFirstFloorCommentAndPraiseViewHolder.f19564a.setPostId(m0());
                pbFirstFloorCommentAndPraiseViewHolder.f19564a.setForumId(j0());
                pVar.l(this.v);
                pbFirstFloorCommentAndPraiseViewHolder.d(k0());
                pbFirstFloorCommentAndPraiseViewHolder.b(pVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void r0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.v = z;
        }
    }

    public void t0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }
}
