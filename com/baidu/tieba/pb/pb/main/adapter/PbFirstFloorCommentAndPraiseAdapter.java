package com.baidu.tieba.pb.pb.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import d.a.c.e.p.l;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.f;
import d.a.s0.h2.h.p;
import d.a.s0.h2.k.e.o;
import d.a.s0.h2.k.e.z0.c;
import d.a.s0.h2.o.b;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class PbFirstFloorCommentAndPraiseAdapter extends o<p, PbFirstFloorCommentAndPraiseViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public static int w;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener s;
    public c t;
    public final LinkedList<PbFirstFloorCommentAndPraiseViewHolder> u;
    public boolean v;

    /* loaded from: classes5.dex */
    public static class PbFirstFloorCommentAndPraiseViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public PbThreadCommentAndPraiseInfoLayout f19434a;

        /* renamed from: b  reason: collision with root package name */
        public View f19435b;

        /* renamed from: c  reason: collision with root package name */
        public int f19436c;

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
            if (view == null) {
                return;
            }
            this.f19434a = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
            f fVar = new f();
            fVar.f55932b = 4;
            fVar.f55938h = 7;
            fVar.f55933c = this.f19436c;
            fVar.f55936f = PbFirstFloorCommentAndPraiseAdapter.w;
            this.f19434a.setAgreeStatisticData(fVar);
            View findViewById = view.findViewById(R.id.bottom_divider_line);
            this.f19435b = findViewById;
            findViewById.setVisibility(0);
        }

        public void b(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) {
                if (pVar != null && pVar.d() != null) {
                    b2 d2 = pVar.d();
                    if (d2.z() != null) {
                        d2.z().postId = d2.T();
                    }
                    this.f19434a.U(d2, pVar.c());
                    this.f19435b.setVisibility(pVar.h() ? 0 : 8);
                    if (d2.q2() && d2.l1() != null) {
                        this.f19436c = 2;
                    } else {
                        this.f19436c = 1;
                    }
                    if (pVar.f60180f) {
                        a().setPadding(0, 0, 0, l.g(a().getContext(), R.dimen.tbds32));
                    }
                    this.f19434a.showOperationMaskView(pVar.i());
                }
                c();
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setBackgroundColor(this.f19435b, R.color.CAM_X0203);
                this.f19434a.onChangeSkinType();
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
            w = bVar.y().C0();
        }
        this.t = new c(bVar);
    }

    @Override // d.a.s0.h2.k.e.o, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        q0(i2, view, viewGroup, (p) obj, (PbFirstFloorCommentAndPraiseViewHolder) viewHolder);
        return view;
    }

    public void i0(String str) {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (this.u.size() > 0) {
                Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.u.iterator();
                while (it.hasNext()) {
                    PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                    if (next != null && (pbThreadCommentAndPraiseInfoLayout = next.f19434a) != null) {
                        pbThreadCommentAndPraiseInfoLayout.Q(str);
                    }
                }
            } else if (k0() == null) {
            } else {
                this.t.b(k0().z());
            }
        }
    }

    public final String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m.y() != null ? this.m.y().getForumId() : "" : (String) invokeV.objValue;
    }

    public final b2 k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.m.y() == null || this.m.y().D0() == null) {
                return null;
            }
            return this.m.y().D0().N();
        }
        return (b2) invokeV.objValue;
    }

    public final String l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b2 k0 = k0();
            return k0 != null ? k0.T() : "";
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: m0 */
    public PbFirstFloorCommentAndPraiseViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = new PbFirstFloorCommentAndPraiseViewHolder(LayoutInflater.from(this.f44821e).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
            this.u.add(pbFirstFloorCommentAndPraiseViewHolder);
            return pbFirstFloorCommentAndPraiseViewHolder;
        }
        return (PbFirstFloorCommentAndPraiseViewHolder) invokeL.objValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            p0();
            c cVar = this.t;
            if (cVar != null) {
                cVar.d();
            }
        }
    }

    public final void p0() {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.u.iterator();
            while (it.hasNext()) {
                PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                if (next != null && (pbThreadCommentAndPraiseInfoLayout = next.f19434a) != null) {
                    pbThreadCommentAndPraiseInfoLayout.onDestroy();
                }
            }
        }
    }

    public View q0(int i2, View view, ViewGroup viewGroup, p pVar, PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), view, viewGroup, pVar, pbFirstFloorCommentAndPraiseViewHolder})) == null) {
            super.X(i2, view, viewGroup, pVar, pbFirstFloorCommentAndPraiseViewHolder);
            if (pVar != null && pbFirstFloorCommentAndPraiseViewHolder != null) {
                pbFirstFloorCommentAndPraiseViewHolder.f19434a.setOnClickOutListener(this.s);
                pbFirstFloorCommentAndPraiseViewHolder.f19434a.setPostId(l0());
                pbFirstFloorCommentAndPraiseViewHolder.f19434a.setForumId(j0());
                pVar.l(this.v);
                pbFirstFloorCommentAndPraiseViewHolder.b(pVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void s0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.v = z;
        }
    }

    public void t0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }
}
