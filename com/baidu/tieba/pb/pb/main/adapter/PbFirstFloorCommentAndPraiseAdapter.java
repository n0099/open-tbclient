package com.baidu.tieba.pb.pb.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.f;
import c.a.r0.k2.h.p;
import c.a.r0.k2.k.e.n;
import c.a.r0.k2.k.e.z0.c;
import c.a.r0.k2.o.b;
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
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class PbFirstFloorCommentAndPraiseAdapter extends n<p, PbFirstFloorCommentAndPraiseViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public static int x;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener s;
    public c t;
    public final LinkedList<PbFirstFloorCommentAndPraiseViewHolder> u;
    public boolean v;
    public b w;

    /* loaded from: classes7.dex */
    public static class PbFirstFloorCommentAndPraiseViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f55275a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public f f55276b;
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
            this.f55276b = new f();
            if (view == null) {
                return;
            }
            this.mCommentAndPraiseLayout = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
            f fVar = this.f55276b;
            fVar.f14190b = 4;
            fVar.f14196h = 7;
            fVar.f14191c = this.f55275a;
            fVar.f14194f = PbFirstFloorCommentAndPraiseAdapter.x;
            this.mCommentAndPraiseLayout.setAgreeStatisticData(this.f55276b);
            View findViewById = view.findViewById(R.id.bottom_divider_line);
            this.mBottomDividerLine = findViewById;
            findViewById.setVisibility(0);
        }

        public void bindDataToView(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) {
                if (pVar != null && pVar.d() != null) {
                    d2 d2 = pVar.d();
                    if (d2.B() != null) {
                        d2.B().postId = d2.W();
                    }
                    this.mCommentAndPraiseLayout.setData(d2, pVar.c());
                    this.mBottomDividerLine.setVisibility(pVar.h() ? 0 : 8);
                    if (d2.E2() && d2.q1() != null) {
                        this.f55275a = 2;
                    } else {
                        this.f55275a = 1;
                    }
                    if (pVar.f19850f) {
                        getView().setPadding(0, 0, 0, l.g(getView().getContext(), R.dimen.tbds32));
                    }
                    this.mCommentAndPraiseLayout.showOperationMaskView(pVar.i());
                }
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setBackgroundColor(this.mBottomDividerLine, R.color.CAM_X0203);
                this.mCommentAndPraiseLayout.onChangeSkinType();
            }
        }

        public void setFromForumId(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f55276b.f14198j = str;
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
            x = bVar.getPbModel().O0();
        }
        this.w = bVar;
        this.t = new c(bVar);
    }

    @Override // c.a.r0.k2.k.e.n, c.a.e.l.e.a
    public /* bridge */ /* synthetic */ View a0(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        t0(i2, view, viewGroup, (p) obj, (PbFirstFloorCommentAndPraiseViewHolder) viewHolder);
        return view;
    }

    public void k0(String str, String str2) {
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
            } else if (n0() == null) {
            } else {
                this.t.b(n0().B());
            }
        }
    }

    public final String l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m.getPbModel() != null ? this.m.getPbModel().getForumId() : "" : (String) invokeV.objValue;
    }

    public final String m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m.getPbModel() != null ? this.m.getPbModel().getFromForumId() : "" : (String) invokeV.objValue;
    }

    public final d2 n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.m.getPbModel() == null || this.m.getPbModel().P0() == null) {
                return null;
            }
            return this.m.getPbModel().P0().O();
        }
        return (d2) invokeV.objValue;
    }

    public final String o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d2 n0 = n0();
            return n0 != null ? n0.W() : "";
        }
        return (String) invokeV.objValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            s0();
            c cVar = this.t;
            if (cVar != null) {
                cVar.d();
            }
        }
    }

    public final String p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            b bVar = this.w;
            return (bVar == null || bVar.getPbModel() == null) ? "" : this.w.getPbModel().getTopicId();
        }
        return (String) invokeV.objValue;
    }

    public final String q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            b bVar = this.w;
            return (bVar == null || bVar.getPbModel() == null) ? "" : this.w.getPbModel().j1();
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: r0 */
    public PbFirstFloorCommentAndPraiseViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, viewGroup)) == null) {
            PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = new PbFirstFloorCommentAndPraiseViewHolder(LayoutInflater.from(this.f2958e).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
            pbFirstFloorCommentAndPraiseViewHolder.setTopicId(p0());
            pbFirstFloorCommentAndPraiseViewHolder.setTopicSubjectName(q0());
            this.u.add(pbFirstFloorCommentAndPraiseViewHolder);
            return pbFirstFloorCommentAndPraiseViewHolder;
        }
        return (PbFirstFloorCommentAndPraiseViewHolder) invokeL.objValue;
    }

    public final void s0() {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.u.iterator();
            while (it.hasNext()) {
                PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                if (next != null && (pbThreadCommentAndPraiseInfoLayout = next.mCommentAndPraiseLayout) != null) {
                    pbThreadCommentAndPraiseInfoLayout.onDestroy();
                }
            }
        }
    }

    public View t0(int i2, View view, ViewGroup viewGroup, p pVar, PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), view, viewGroup, pVar, pbFirstFloorCommentAndPraiseViewHolder})) == null) {
            super.a0(i2, view, viewGroup, pVar, pbFirstFloorCommentAndPraiseViewHolder);
            if (pVar != null && pbFirstFloorCommentAndPraiseViewHolder != null) {
                pVar.d().T1 = D(i2) + 1;
                pbFirstFloorCommentAndPraiseViewHolder.mCommentAndPraiseLayout.setOnClickOutListener(this.s);
                pbFirstFloorCommentAndPraiseViewHolder.mCommentAndPraiseLayout.setPostId(o0());
                pbFirstFloorCommentAndPraiseViewHolder.mCommentAndPraiseLayout.setForumId(l0());
                pVar.l(this.v);
                pbFirstFloorCommentAndPraiseViewHolder.setFromForumId(m0());
                pbFirstFloorCommentAndPraiseViewHolder.bindDataToView(pVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.v = z;
        }
    }

    public void v0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }
}
