package com.baidu.tieba.pb.pb.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.f;
import b.a.r0.k2.g;
import b.a.r0.k2.i;
import b.a.r0.k2.j;
import b.a.r0.k2.r.q;
import b.a.r0.k2.u.f.n;
import b.a.r0.k2.u.f.z0.c;
import b.a.r0.k2.y.b;
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
/* loaded from: classes9.dex */
public class PbFirstFloorCommentAndPraiseAdapter extends n<q, PbFirstFloorCommentAndPraiseViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public static int x;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener s;
    public c t;
    public final LinkedList<PbFirstFloorCommentAndPraiseViewHolder> u;
    public boolean v;
    public b w;

    /* loaded from: classes9.dex */
    public static class PbFirstFloorCommentAndPraiseViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f52462a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public f f52463b;
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
            this.f52463b = new f();
            if (view == null) {
                return;
            }
            this.mCommentAndPraiseLayout = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(i.card_bottom_func_layout);
            f fVar = this.f52463b;
            fVar.f13300b = 4;
            fVar.f13306h = 7;
            fVar.f13301c = this.f52462a;
            fVar.f13304f = PbFirstFloorCommentAndPraiseAdapter.x;
            this.mCommentAndPraiseLayout.setAgreeStatisticData(this.f52463b);
            View findViewById = view.findViewById(i.bottom_divider_line);
            this.mBottomDividerLine = findViewById;
            findViewById.setVisibility(0);
        }

        public void bindDataToView(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qVar) == null) {
                if (qVar != null && qVar.e() != null) {
                    d2 e2 = qVar.e();
                    if (e2.B() != null) {
                        e2.B().postId = e2.W();
                    }
                    this.mCommentAndPraiseLayout.setData(e2, qVar.d());
                    this.mBottomDividerLine.setVisibility(qVar.h() ? 0 : 8);
                    if (e2.E2() && e2.q1() != null) {
                        this.f52462a = 2;
                    } else {
                        this.f52462a = 1;
                    }
                    if (qVar.f18800f) {
                        getView().setPadding(0, 0, 0, l.g(getView().getContext(), g.tbds32));
                    }
                    this.mCommentAndPraiseLayout.showOperationMaskView(qVar.i());
                }
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setBackgroundColor(this.mBottomDividerLine, b.a.r0.k2.f.CAM_X0203);
                this.mCommentAndPraiseLayout.onChangeSkinType();
            }
        }

        public void setFromForumId(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f52463b.j = str;
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

    @Override // b.a.r0.k2.u.f.n, b.a.e.l.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        s0(i2, view, viewGroup, (q) obj, (PbFirstFloorCommentAndPraiseViewHolder) viewHolder);
        return view;
    }

    public void j0(String str, String str2) {
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
            } else if (m0() == null) {
            } else {
                this.t.b(m0().B());
            }
        }
    }

    public final String k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m.getPbModel() != null ? this.m.getPbModel().getForumId() : "" : (String) invokeV.objValue;
    }

    public final String l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m.getPbModel() != null ? this.m.getPbModel().getFromForumId() : "" : (String) invokeV.objValue;
    }

    public final d2 m0() {
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

    public final String n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d2 m0 = m0();
            return m0 != null ? m0.W() : "";
        }
        return (String) invokeV.objValue;
    }

    public final String o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            b bVar = this.w;
            return (bVar == null || bVar.getPbModel() == null) ? "" : this.w.getPbModel().getTopicId();
        }
        return (String) invokeV.objValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            r0();
            c cVar = this.t;
            if (cVar != null) {
                cVar.d();
            }
        }
    }

    public final String p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            b bVar = this.w;
            return (bVar == null || bVar.getPbModel() == null) ? "" : this.w.getPbModel().j1();
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: q0 */
    public PbFirstFloorCommentAndPraiseViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, viewGroup)) == null) {
            PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = new PbFirstFloorCommentAndPraiseViewHolder(LayoutInflater.from(this.f2419e).inflate(j.layout_pb_thread_praise_item, viewGroup, false));
            pbFirstFloorCommentAndPraiseViewHolder.setTopicId(o0());
            pbFirstFloorCommentAndPraiseViewHolder.setTopicSubjectName(p0());
            this.u.add(pbFirstFloorCommentAndPraiseViewHolder);
            return pbFirstFloorCommentAndPraiseViewHolder;
        }
        return (PbFirstFloorCommentAndPraiseViewHolder) invokeL.objValue;
    }

    public final void r0() {
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

    public View s0(int i2, View view, ViewGroup viewGroup, q qVar, PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), view, viewGroup, qVar, pbFirstFloorCommentAndPraiseViewHolder})) == null) {
            super.Z(i2, view, viewGroup, qVar, pbFirstFloorCommentAndPraiseViewHolder);
            if (qVar != null && pbFirstFloorCommentAndPraiseViewHolder != null) {
                qVar.e().T1 = D(i2) + 1;
                pbFirstFloorCommentAndPraiseViewHolder.mCommentAndPraiseLayout.setOnClickOutListener(this.s);
                pbFirstFloorCommentAndPraiseViewHolder.mCommentAndPraiseLayout.setPostId(n0());
                pbFirstFloorCommentAndPraiseViewHolder.mCommentAndPraiseLayout.setForumId(k0());
                qVar.l(this.v);
                pbFirstFloorCommentAndPraiseViewHolder.setFromForumId(l0());
                pbFirstFloorCommentAndPraiseViewHolder.bindDataToView(qVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.v = z;
        }
    }

    public void u0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }
}
