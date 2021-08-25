package com.baidu.tieba.pb.pb.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.f;
import c.a.q0.i2.h.p;
import c.a.q0.i2.k.e.m;
import c.a.q0.i2.k.e.x0.c;
import c.a.q0.i2.o.b;
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
public class PbFirstFloorCommentAndPraiseAdapter extends m<p, PbFirstFloorCommentAndPraiseViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public static int w;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener s;
    public c t;
    public final LinkedList<PbFirstFloorCommentAndPraiseViewHolder> u;
    public boolean v;

    /* loaded from: classes7.dex */
    public static class PbFirstFloorCommentAndPraiseViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f55078a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public f f55079b;
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
            this.f55079b = new f();
            if (view == null) {
                return;
            }
            this.mCommentAndPraiseLayout = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
            f fVar = this.f55079b;
            fVar.f14219b = 4;
            fVar.f14225h = 7;
            fVar.f14220c = this.f55078a;
            fVar.f14223f = PbFirstFloorCommentAndPraiseAdapter.w;
            this.mCommentAndPraiseLayout.setAgreeStatisticData(this.f55079b);
            View findViewById = view.findViewById(R.id.bottom_divider_line);
            this.mBottomDividerLine = findViewById;
            findViewById.setVisibility(0);
        }

        public void bindDataToView(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) {
                if (pVar != null && pVar.d() != null) {
                    c2 d2 = pVar.d();
                    if (d2.B() != null) {
                        d2.B().postId = d2.W();
                    }
                    this.mCommentAndPraiseLayout.setData(d2, pVar.c());
                    this.mBottomDividerLine.setVisibility(pVar.h() ? 0 : 8);
                    if (d2.A2() && d2.o1() != null) {
                        this.f55078a = 2;
                    } else {
                        this.f55078a = 1;
                    }
                    if (pVar.f19109f) {
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
                this.f55079b.f14227j = str;
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
            w = bVar.getPbModel().N0();
        }
        this.t = new c(bVar);
    }

    @Override // c.a.q0.i2.k.e.m, c.a.e.l.e.a
    public /* bridge */ /* synthetic */ View a0(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        r0(i2, view, viewGroup, (p) obj, (PbFirstFloorCommentAndPraiseViewHolder) viewHolder);
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

    public final c2 n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.m.getPbModel() == null || this.m.getPbModel().O0() == null) {
                return null;
            }
            return this.m.getPbModel().O0().O();
        }
        return (c2) invokeV.objValue;
    }

    public final String o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c2 n0 = n0();
            return n0 != null ? n0.W() : "";
        }
        return (String) invokeV.objValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            q0();
            c cVar = this.t;
            if (cVar != null) {
                cVar.d();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: p0 */
    public PbFirstFloorCommentAndPraiseViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = new PbFirstFloorCommentAndPraiseViewHolder(LayoutInflater.from(this.f2966e).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
            this.u.add(pbFirstFloorCommentAndPraiseViewHolder);
            return pbFirstFloorCommentAndPraiseViewHolder;
        }
        return (PbFirstFloorCommentAndPraiseViewHolder) invokeL.objValue;
    }

    public final void q0() {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.u.iterator();
            while (it.hasNext()) {
                PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                if (next != null && (pbThreadCommentAndPraiseInfoLayout = next.mCommentAndPraiseLayout) != null) {
                    pbThreadCommentAndPraiseInfoLayout.onDestroy();
                }
            }
        }
    }

    public View r0(int i2, View view, ViewGroup viewGroup, p pVar, PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), view, viewGroup, pVar, pbFirstFloorCommentAndPraiseViewHolder})) == null) {
            super.a0(i2, view, viewGroup, pVar, pbFirstFloorCommentAndPraiseViewHolder);
            if (pVar != null && pbFirstFloorCommentAndPraiseViewHolder != null) {
                pVar.d().Q1 = D(i2) + 1;
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

    public void s0(boolean z) {
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
