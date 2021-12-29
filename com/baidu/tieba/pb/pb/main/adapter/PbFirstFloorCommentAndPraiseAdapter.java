package com.baidu.tieba.pb.pb.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.f;
import c.a.t0.s2.g;
import c.a.t0.s2.i;
import c.a.t0.s2.j;
import c.a.t0.s2.r.r;
import c.a.t0.s2.u.f.a1.c;
import c.a.t0.s2.u.f.n;
import c.a.t0.s2.y.b;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes12.dex */
public class PbFirstFloorCommentAndPraiseAdapter extends n<r, PbFirstFloorCommentAndPraiseViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public static int x;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener s;
    public c t;
    public final LinkedList<PbFirstFloorCommentAndPraiseViewHolder> u;
    public boolean v;
    public b w;

    /* loaded from: classes12.dex */
    public static class PbFirstFloorCommentAndPraiseViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public f f48435b;
        public View mBottomDividerLine;
        public PbThreadCommentAndPraiseInfoLayout mCommentAndPraiseLayout;

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
            this.f48435b = new f();
            if (view == null) {
                return;
            }
            this.mCommentAndPraiseLayout = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(i.card_bottom_func_layout);
            f fVar = this.f48435b;
            fVar.f13685b = 4;
            fVar.f13691h = 7;
            fVar.f13686c = this.a;
            fVar.f13689f = PbFirstFloorCommentAndPraiseAdapter.x;
            this.mCommentAndPraiseLayout.setAgreeStatisticData(this.f48435b);
            View findViewById = view.findViewById(i.bottom_divider_line);
            this.mBottomDividerLine = findViewById;
            findViewById.setVisibility(0);
        }

        public void bindDataToView(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, rVar) == null) {
                if (rVar != null && rVar.e() != null) {
                    d2 e2 = rVar.e();
                    if (e2.B() != null) {
                        e2.B().postId = e2.X();
                    }
                    this.mCommentAndPraiseLayout.setData(e2, rVar.d());
                    this.mBottomDividerLine.setVisibility(rVar.h() ? 0 : 8);
                    if (e2.H2() && e2.t1() != null) {
                        this.a = 2;
                    } else {
                        this.a = 1;
                    }
                    if (rVar.f23081f) {
                        getView().setPadding(0, 0, 0, c.a.d.f.p.n.f(getView().getContext(), g.tbds32));
                    }
                    this.mCommentAndPraiseLayout.showOperationMaskView(rVar.i());
                }
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setBackgroundColor(this.mBottomDividerLine, c.a.t0.s2.f.CAM_X0203);
                this.mCommentAndPraiseLayout.onChangeSkinType();
            }
        }

        public void setFromForumId(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f48435b.f13693j = str;
            }
        }

        public void setTopicId(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.mCommentAndPraiseLayout.setTopicId(str);
            }
        }

        public void setTopicSubjectName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.mCommentAndPraiseLayout.setTopicSubjectName(str);
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
        if (bVar != null && bVar.getPbModel() != null) {
            x = bVar.getPbModel().Q0();
        }
        this.w = bVar;
        this.t = new c(bVar);
    }

    @Override // c.a.t0.s2.u.f.n, c.a.d.n.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        l0(i2, view, viewGroup, (r) obj, (PbFirstFloorCommentAndPraiseViewHolder) viewHolder);
        return view;
    }

    public void c0(String str, String str2) {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            if (this.u.size() > 0) {
                Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.u.iterator();
                while (it.hasNext()) {
                    PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                    if (next != null && (pbThreadCommentAndPraiseInfoLayout = next.mCommentAndPraiseLayout) != null) {
                        pbThreadCommentAndPraiseInfoLayout.doPraiseClick(str, str2);
                    }
                }
            } else if (f0() == null) {
            } else {
                this.t.b(f0().B());
            }
        }
    }

    public final String d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m.getPbModel() != null ? this.m.getPbModel().getForumId() : "" : (String) invokeV.objValue;
    }

    public final String e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m.getPbModel() != null ? this.m.getPbModel().getFromForumId() : "" : (String) invokeV.objValue;
    }

    public final d2 f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.m.getPbModel() == null || this.m.getPbModel().R0() == null) {
                return null;
            }
            return this.m.getPbModel().R0().O();
        }
        return (d2) invokeV.objValue;
    }

    public final String g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d2 f0 = f0();
            return f0 != null ? f0.X() : "";
        }
        return (String) invokeV.objValue;
    }

    public final String h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            b bVar = this.w;
            return (bVar == null || bVar.getPbModel() == null) ? "" : this.w.getPbModel().getTopicId();
        }
        return (String) invokeV.objValue;
    }

    public final String i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            b bVar = this.w;
            return (bVar == null || bVar.getPbModel() == null) ? "" : this.w.getPbModel().l1();
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: j0 */
    public PbFirstFloorCommentAndPraiseViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = new PbFirstFloorCommentAndPraiseViewHolder(LayoutInflater.from(this.f3299e).inflate(j.layout_pb_thread_praise_item, viewGroup, false));
            pbFirstFloorCommentAndPraiseViewHolder.setTopicId(h0());
            pbFirstFloorCommentAndPraiseViewHolder.setTopicSubjectName(i0());
            this.u.add(pbFirstFloorCommentAndPraiseViewHolder);
            return pbFirstFloorCommentAndPraiseViewHolder;
        }
        return (PbFirstFloorCommentAndPraiseViewHolder) invokeL.objValue;
    }

    public final void k0() {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.u.iterator();
            while (it.hasNext()) {
                PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                if (next != null && (pbThreadCommentAndPraiseInfoLayout = next.mCommentAndPraiseLayout) != null) {
                    pbThreadCommentAndPraiseInfoLayout.onDestroy();
                }
            }
        }
    }

    public View l0(int i2, View view, ViewGroup viewGroup, r rVar, PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), view, viewGroup, rVar, pbFirstFloorCommentAndPraiseViewHolder})) == null) {
            super.S(i2, view, viewGroup, rVar, pbFirstFloorCommentAndPraiseViewHolder);
            if (rVar != null && pbFirstFloorCommentAndPraiseViewHolder != null) {
                rVar.e().U1 = C(i2) + 1;
                pbFirstFloorCommentAndPraiseViewHolder.mCommentAndPraiseLayout.setOnClickOutListener(this.s);
                pbFirstFloorCommentAndPraiseViewHolder.mCommentAndPraiseLayout.setPostId(g0());
                pbFirstFloorCommentAndPraiseViewHolder.mCommentAndPraiseLayout.setForumId(d0());
                rVar.l(this.v);
                pbFirstFloorCommentAndPraiseViewHolder.setFromForumId(e0());
                pbFirstFloorCommentAndPraiseViewHolder.bindDataToView(rVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.v = z;
        }
    }

    public void n0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            k0();
            c cVar = this.t;
            if (cVar != null) {
                cVar.d();
            }
        }
    }
}
