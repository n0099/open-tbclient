package com.baidu.tieba.pb.pb.main.adapter;

import android.animation.Animator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.bl8;
import com.baidu.tieba.hi;
import com.baidu.tieba.nw4;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.wp8;
import com.baidu.tieba.yi8;
import com.baidu.tieba.zm8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class PbFirstFloorCommentAndPraiseAdapter extends bl8<yi8, PbFirstFloorCommentAndPraiseViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public static int l;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener g;
    public zm8 h;
    public final LinkedList<PbFirstFloorCommentAndPraiseViewHolder> i;
    public boolean j;
    public wp8 k;

    /* loaded from: classes5.dex */
    public static class PbFirstFloorCommentAndPraiseViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PbThreadCommentAndPraiseInfoLayout a;
        public View b;
        public int c;
        @NonNull
        public nw4 d;

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
            this.d = new nw4();
            if (view2 == null) {
                return;
            }
            this.a = (PbThreadCommentAndPraiseInfoLayout) view2.findViewById(R.id.obfuscated_res_0x7f090546);
            nw4 nw4Var = this.d;
            nw4Var.b = 4;
            nw4Var.h = 7;
            nw4Var.c = this.c;
            nw4Var.f = PbFirstFloorCommentAndPraiseAdapter.l;
            this.a.setAgreeStatisticData(this.d);
            this.a.setIsPbFirst(true);
            View findViewById = view2.findViewById(R.id.bottom_divider_line);
            this.b = findViewById;
            findViewById.setVisibility(0);
        }

        public void a(yi8 yi8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, yi8Var) == null) {
                if (yi8Var != null && yi8Var.c() != null) {
                    ThreadData c = yi8Var.c();
                    int i = 8;
                    if (c.isQuestionThread()) {
                        this.a.setVisibility(8);
                        this.b.setVisibility(8);
                        return;
                    }
                    this.a.setVisibility(0);
                    this.b.setVisibility(0);
                    if (c.getAgreeData() != null) {
                        c.getAgreeData().postId = c.getFirstPostId();
                    }
                    this.a.Z(c, yi8Var.b());
                    View view2 = this.b;
                    if (yi8Var.g()) {
                        i = 0;
                    }
                    view2.setVisibility(i);
                    if (c.isVideoThreadType() && c.getThreadVideoInfo() != null) {
                        this.c = 2;
                    } else {
                        this.c = 1;
                    }
                    if (yi8Var.b) {
                        getView().setPadding(0, 0, 0, hi.g(getView().getContext(), R.dimen.tbds32));
                    }
                    this.a.showOperationMaskView(yi8Var.h());
                    this.a.setUseDynamicLikeRes();
                }
                b();
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setBackgroundColor(this.b, R.color.CAM_X0203);
                this.a.onChangeSkinType();
            }
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.d.j = str;
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.a.setTopicId(str);
            }
        }

        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.setTopicSubjectName(str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorCommentAndPraiseAdapter(wp8 wp8Var, BdUniqueId bdUniqueId) {
        super(wp8Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wp8Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((wp8) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new LinkedList<>();
        this.j = false;
        if (wp8Var != null && wp8Var.L() != null) {
            l = wp8Var.L().v1();
        }
        this.k = wp8Var;
        this.h = new zm8(wp8Var);
    }

    public void x(String str, String str2) {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) {
            if (this.i.size() > 0) {
                Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.i.iterator();
                while (it.hasNext()) {
                    PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                    if (next != null && (pbThreadCommentAndPraiseInfoLayout = next.a) != null) {
                        pbThreadCommentAndPraiseInfoLayout.T(str, str2);
                    }
                }
            } else if (A() == null) {
            } else {
                this.h.b(A().getAgreeData());
                PbFragment pbFragment = this.b;
                if (pbFragment != null) {
                    pbFragment.p6();
                }
            }
        }
    }

    public final String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ThreadData A = A();
            if (A != null) {
                return A.getFirstPostId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            wp8 wp8Var = this.k;
            if (wp8Var != null && wp8Var.L() != null) {
                return this.k.L().getTopicId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            wp8 wp8Var = this.k;
            if (wp8Var != null && wp8Var.L() != null) {
                return this.k.L().U1();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void F() {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.i.iterator();
            while (it.hasNext()) {
                PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                if (next != null && (pbThreadCommentAndPraiseInfoLayout = next.a) != null) {
                    pbThreadCommentAndPraiseInfoLayout.onDestroy();
                }
            }
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            F();
            zm8 zm8Var = this.h;
            if (zm8Var != null) {
                zm8Var.d();
            }
        }
    }

    public final String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.a.L() != null) {
                return this.a.L().getForumId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.a.L() != null) {
                return this.a.L().getFromForumId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final ThreadData A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a.L() != null && this.a.L().w1() != null) {
                return this.a.L().w1().Q();
            }
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: E */
    public PbFirstFloorCommentAndPraiseViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = new PbFirstFloorCommentAndPraiseViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d04fa, viewGroup, false));
            pbFirstFloorCommentAndPraiseViewHolder.d(C());
            pbFirstFloorCommentAndPraiseViewHolder.e(D());
            this.i.add(pbFirstFloorCommentAndPraiseViewHolder);
            return pbFirstFloorCommentAndPraiseViewHolder;
        }
        return (PbFirstFloorCommentAndPraiseViewHolder) invokeL.objValue;
    }

    public void H(Animator.AnimatorListener animatorListener) {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, animatorListener) == null) && this.i.size() > 0) {
            Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.i.iterator();
            while (it.hasNext()) {
                PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                if (next != null && (pbThreadCommentAndPraiseInfoLayout = next.a) != null) {
                    pbThreadCommentAndPraiseInfoLayout.Y(animatorListener);
                }
            }
        }
    }

    public View G(int i, View view2, ViewGroup viewGroup, yi8 yi8Var, PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, yi8Var, pbFirstFloorCommentAndPraiseViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) yi8Var, (yi8) pbFirstFloorCommentAndPraiseViewHolder);
            if (yi8Var != null && pbFirstFloorCommentAndPraiseViewHolder != null) {
                yi8Var.c().statFloor = getPositionByType(i) + 1;
                pbFirstFloorCommentAndPraiseViewHolder.a.setOnClickOutListener(this.g);
                pbFirstFloorCommentAndPraiseViewHolder.a.setPostId(B());
                pbFirstFloorCommentAndPraiseViewHolder.a.setForumId(y());
                yi8Var.j(this.j);
                pbFirstFloorCommentAndPraiseViewHolder.c(z());
                pbFirstFloorCommentAndPraiseViewHolder.a(yi8Var);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.j = z;
        }
    }

    public void J(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.g = onClickListener;
        }
    }

    @Override // com.baidu.tieba.bl8, com.baidu.tieba.tm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        G(i, view2, viewGroup, (yi8) obj, (PbFirstFloorCommentAndPraiseViewHolder) viewHolder);
        return view2;
    }
}
