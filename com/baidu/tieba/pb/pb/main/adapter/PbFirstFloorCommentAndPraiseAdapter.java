package com.baidu.tieba.pb.pb.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jz7;
import com.repackage.oi;
import com.repackage.ps7;
import com.repackage.pw7;
import com.repackage.vn4;
import com.repackage.wu7;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class PbFirstFloorCommentAndPraiseAdapter extends wu7<ps7, PbFirstFloorCommentAndPraiseViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public static int t;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener o;
    public pw7 p;
    public final LinkedList<PbFirstFloorCommentAndPraiseViewHolder> q;
    public boolean r;
    public jz7 s;

    /* loaded from: classes3.dex */
    public static class PbFirstFloorCommentAndPraiseViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PbThreadCommentAndPraiseInfoLayout a;
        public View b;
        public int c;
        @NonNull
        public vn4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PbFirstFloorCommentAndPraiseViewHolder(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
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
            this.d = new vn4();
            if (view2 == null) {
                return;
            }
            this.a = (PbThreadCommentAndPraiseInfoLayout) view2.findViewById(R.id.obfuscated_res_0x7f0904d0);
            vn4 vn4Var = this.d;
            vn4Var.b = 4;
            vn4Var.h = 7;
            vn4Var.c = this.c;
            vn4Var.f = PbFirstFloorCommentAndPraiseAdapter.t;
            this.a.setAgreeStatisticData(this.d);
            this.a.setIsPbFirst(true);
            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f0903cc);
            this.b = findViewById;
            findViewById.setVisibility(0);
        }

        public void c(ps7 ps7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ps7Var) == null) {
                if (ps7Var != null && ps7Var.e() != null) {
                    ThreadData e = ps7Var.e();
                    if (e.getAgreeData() != null) {
                        e.getAgreeData().postId = e.getFirstPostId();
                    }
                    this.a.T(e, ps7Var.b());
                    this.b.setVisibility(ps7Var.g() ? 0 : 8);
                    if (e.isVideoThreadType() && e.getThreadVideoInfo() != null) {
                        this.c = 2;
                    } else {
                        this.c = 1;
                    }
                    if (ps7Var.b) {
                        b().setPadding(0, 0, 0, oi.f(b().getContext(), R.dimen.tbds32));
                    }
                    this.a.showOperationMaskView(ps7Var.i());
                    if (UbsABTestHelper.isLikeModifyTestA()) {
                        this.a.setUseDynamicLikeRes();
                    }
                }
                d();
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setBackgroundColor(this.b, R.color.CAM_X0203);
                this.a.onChangeSkinType();
            }
        }

        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.d.j = str;
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
    public PbFirstFloorCommentAndPraiseAdapter(jz7 jz7Var, BdUniqueId bdUniqueId) {
        super(jz7Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jz7Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((jz7) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new LinkedList<>();
        this.r = false;
        if (jz7Var != null && jz7Var.w() != null) {
            t = jz7Var.w().S0();
        }
        this.s = jz7Var;
        this.p = new pw7(jz7Var);
    }

    @Override // com.repackage.wu7, com.repackage.ho
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        l0(i, view2, viewGroup, (ps7) obj, (PbFirstFloorCommentAndPraiseViewHolder) viewHolder);
        return view2;
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
                        pbThreadCommentAndPraiseInfoLayout.P(str, str2);
                    }
                }
            } else if (f0() == null) {
            } else {
                this.p.b(f0().getAgreeData());
                PbFragment pbFragment = this.j;
                if (pbFragment != null) {
                    pbFragment.x5();
                }
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
            if (this.i.w() == null || this.i.w().T0() == null) {
                return null;
            }
            return this.i.w().T0().O();
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
            jz7 jz7Var = this.s;
            return (jz7Var == null || jz7Var.w() == null) ? "" : this.s.w().getTopicId();
        }
        return (String) invokeV.objValue;
    }

    public final String i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            jz7 jz7Var = this.s;
            return (jz7Var == null || jz7Var.w() == null) ? "" : this.s.w().p1();
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: j0 */
    public PbFirstFloorCommentAndPraiseViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = new PbFirstFloorCommentAndPraiseViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d04aa, viewGroup, false));
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

    public View l0(int i, View view2, ViewGroup viewGroup, ps7 ps7Var, PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ps7Var, pbFirstFloorCommentAndPraiseViewHolder})) == null) {
            super.S(i, view2, viewGroup, ps7Var, pbFirstFloorCommentAndPraiseViewHolder);
            if (ps7Var != null && pbFirstFloorCommentAndPraiseViewHolder != null) {
                ps7Var.e().statFloor = C(i) + 1;
                pbFirstFloorCommentAndPraiseViewHolder.a.setOnClickOutListener(this.o);
                pbFirstFloorCommentAndPraiseViewHolder.a.setPostId(g0());
                pbFirstFloorCommentAndPraiseViewHolder.a.setForumId(d0());
                ps7Var.k(this.r);
                pbFirstFloorCommentAndPraiseViewHolder.e(e0());
                pbFirstFloorCommentAndPraiseViewHolder.c(ps7Var);
            }
            return view2;
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
            pw7 pw7Var = this.p;
            if (pw7Var != null) {
                pw7Var.d();
            }
        }
    }
}
