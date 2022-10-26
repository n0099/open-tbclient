package com.baidu.tieba.pb.pb.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.e38;
import com.baidu.tieba.fj;
import com.baidu.tieba.gr4;
import com.baidu.tieba.i08;
import com.baidu.tieba.iw7;
import com.baidu.tieba.ly7;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class PbFirstFloorCommentAndPraiseAdapter extends ly7 {
    public static /* synthetic */ Interceptable $ic;
    public static int l;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener g;
    public i08 h;
    public final LinkedList i;
    public boolean j;
    public e38 k;

    /* loaded from: classes5.dex */
    public class PbFirstFloorCommentAndPraiseViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PbThreadCommentAndPraiseInfoLayout a;
        public View b;
        public int c;
        public gr4 d;

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
            this.d = new gr4();
            if (view2 == null) {
                return;
            }
            this.a = (PbThreadCommentAndPraiseInfoLayout) view2.findViewById(R.id.obfuscated_res_0x7f0904dc);
            gr4 gr4Var = this.d;
            gr4Var.b = 4;
            gr4Var.h = 7;
            gr4Var.c = this.c;
            gr4Var.f = PbFirstFloorCommentAndPraiseAdapter.l;
            this.a.setAgreeStatisticData(this.d);
            this.a.setIsPbFirst(true);
            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f0903f0);
            this.b = findViewById;
            findViewById.setVisibility(0);
        }

        public void a(iw7 iw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iw7Var) == null) {
                if (iw7Var != null && iw7Var.c() != null) {
                    ThreadData c = iw7Var.c();
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
                    this.a.Y(c, iw7Var.b());
                    View view2 = this.b;
                    if (iw7Var.g()) {
                        i = 0;
                    }
                    view2.setVisibility(i);
                    if (c.isVideoThreadType() && c.getThreadVideoInfo() != null) {
                        this.c = 2;
                    } else {
                        this.c = 1;
                    }
                    if (iw7Var.b) {
                        getView().setPadding(0, 0, 0, fj.f(getView().getContext(), R.dimen.tbds32));
                    }
                    this.a.showOperationMaskView(iw7Var.h());
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
    public PbFirstFloorCommentAndPraiseAdapter(e38 e38Var, BdUniqueId bdUniqueId) {
        super(e38Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e38Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((e38) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new LinkedList();
        this.j = false;
        if (e38Var != null && e38Var.K() != null) {
            l = e38Var.K().R1();
        }
        this.k = e38Var;
        this.h = new i08(e38Var);
    }

    public void v(String str, String str2) {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            if (this.i.size() > 0) {
                Iterator it = this.i.iterator();
                while (it.hasNext()) {
                    PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = (PbFirstFloorCommentAndPraiseViewHolder) it.next();
                    if (pbFirstFloorCommentAndPraiseViewHolder != null && (pbThreadCommentAndPraiseInfoLayout = pbFirstFloorCommentAndPraiseViewHolder.a) != null) {
                        pbThreadCommentAndPraiseInfoLayout.T(str, str2);
                    }
                }
            } else if (y() == null) {
            } else {
                this.h.b(y().getAgreeData());
                PbFragment pbFragment = this.b;
                if (pbFragment != null) {
                    pbFragment.y6();
                }
            }
        }
    }

    public final String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e38 e38Var = this.k;
            if (e38Var != null && e38Var.K() != null) {
                return this.k.K().getTopicId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            e38 e38Var = this.k;
            if (e38Var != null && e38Var.K() != null) {
                return this.k.K().q2();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void D() {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Iterator it = this.i.iterator();
            while (it.hasNext()) {
                PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = (PbFirstFloorCommentAndPraiseViewHolder) it.next();
                if (pbFirstFloorCommentAndPraiseViewHolder != null && (pbThreadCommentAndPraiseInfoLayout = pbFirstFloorCommentAndPraiseViewHolder.a) != null) {
                    pbThreadCommentAndPraiseInfoLayout.onDestroy();
                }
            }
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            D();
            i08 i08Var = this.h;
            if (i08Var != null) {
                i08Var.d();
            }
        }
    }

    public final String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.a.K() != null) {
                return this.a.K().getForumId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.a.K() != null) {
                return this.a.K().getFromForumId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ThreadData y = y();
            if (y != null) {
                return y.getFirstPostId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    /* renamed from: C */
    public PbFirstFloorCommentAndPraiseViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = new PbFirstFloorCommentAndPraiseViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d04bc, viewGroup, false));
            pbFirstFloorCommentAndPraiseViewHolder.d(A());
            pbFirstFloorCommentAndPraiseViewHolder.e(B());
            this.i.add(pbFirstFloorCommentAndPraiseViewHolder);
            return pbFirstFloorCommentAndPraiseViewHolder;
        }
        return (PbFirstFloorCommentAndPraiseViewHolder) invokeL.objValue;
    }

    public View E(int i, View view2, ViewGroup viewGroup, iw7 iw7Var, PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, iw7Var, pbFirstFloorCommentAndPraiseViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, iw7Var, pbFirstFloorCommentAndPraiseViewHolder);
            if (iw7Var != null && pbFirstFloorCommentAndPraiseViewHolder != null) {
                iw7Var.c().statFloor = getPositionByType(i) + 1;
                pbFirstFloorCommentAndPraiseViewHolder.a.setOnClickOutListener(this.g);
                pbFirstFloorCommentAndPraiseViewHolder.a.setPostId(z());
                pbFirstFloorCommentAndPraiseViewHolder.a.setForumId(w());
                iw7Var.k(this.j);
                pbFirstFloorCommentAndPraiseViewHolder.c(x());
                pbFirstFloorCommentAndPraiseViewHolder.a(iw7Var);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.j = z;
        }
    }

    public void G(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.g = onClickListener;
        }
    }

    @Override // com.baidu.tieba.ly7, com.baidu.tieba.rn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        E(i, view2, viewGroup, (iw7) obj, (PbFirstFloorCommentAndPraiseViewHolder) viewHolder);
        return view2;
    }

    public final ThreadData y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.a.K() != null && this.a.K().S1() != null) {
                return this.a.K().S1().P();
            }
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }
}
