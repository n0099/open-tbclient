package com.baidu.tieba.pb.pb.main.adapter;

import android.animation.Animator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.FriendBotView;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.R;
import com.baidu.tieba.bo9;
import com.baidu.tieba.gm9;
import com.baidu.tieba.gr5;
import com.baidu.tieba.hm9;
import com.baidu.tieba.md9;
import com.baidu.tieba.of9;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pv4;
import com.baidu.tieba.qi9;
import com.baidu.tieba.tk9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import tbclient.AbilityConf;
import tbclient.CallRobotEntrance;
/* loaded from: classes7.dex */
public class PbFirstFloorCommentAndPraiseAdapter extends qi9<of9, PbFirstFloorCommentAndPraiseViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public static int m;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener g;
    public tk9 h;
    public Runnable i;
    public final LinkedList<PbFirstFloorCommentAndPraiseViewHolder> j;
    public boolean k;
    public bo9 l;

    /* loaded from: classes7.dex */
    public class a implements FriendBotView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ of9 a;
        public final /* synthetic */ PbFirstFloorCommentAndPraiseAdapter b;

        @Override // com.baidu.tbadk.core.view.FriendBotView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            }
        }

        /* renamed from: com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0438a extends FastRequest.b<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String d;
            public final /* synthetic */ String e;
            public final /* synthetic */ a f;

            public C0438a(a aVar, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str, str2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = aVar;
                this.d = str;
                this.e = str2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.net.FastRequest.b
            /* renamed from: l */
            public void f(int i, @NonNull String str, @Nullable Void r7) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                    super.f(i, str, r7);
                    if (this.f.b.b == null) {
                        return;
                    }
                    this.f.b.b.showToast(str);
                    if (this.f.b.b.e0() != null && this.f.b.b.E6() != null && this.f.b.b.E6().T0() != null) {
                        this.f.b.b.e0().o3();
                        this.f.b.b.E6().T0().f0();
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.net.FastRequest.b
            /* renamed from: m */
            public void i(@NonNull Void r5) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                    super.i(r5);
                    hm9.e(this.d);
                    hm9.b(this.f.b.b.e0(), this.e);
                    if (this.f.b.i != null) {
                        SafeHandler.getInst().removeCallbacks(this.f.b.i);
                    }
                    PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.f.b;
                    pbFirstFloorCommentAndPraiseAdapter.i = new md9(this.e, pbFirstFloorCommentAndPraiseAdapter.b);
                    SafeHandler.getInst().postDelayed(this.f.b.i, 30000L);
                }
            }
        }

        public a(PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter, of9 of9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorCommentAndPraiseAdapter, of9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbFirstFloorCommentAndPraiseAdapter;
            this.a = of9Var;
        }

        @Override // com.baidu.tbadk.core.view.FriendBotView.f
        public void b(boolean z, boolean z2, String str) {
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) != null) || gr5.a()) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.b.b.getContext());
                return;
            }
            String str4 = "";
            if (this.a.c() == null || this.a.c().getCallRobotEntrance() == null || this.a.c().getCallRobotEntrance().ability_conf == null) {
                str2 = "";
            } else {
                str2 = this.a.c().getCallRobotEntrance().ability_conf.bot_uk;
            }
            if (this.a.c() == null) {
                str3 = "";
            } else {
                str3 = String.valueOf(this.a.c().getFid());
            }
            if (this.a.c() != null) {
                str4 = String.valueOf(this.a.c().getTid());
            }
            CommonStatisticUtils.statisticFriendBotView(2, str2, 1, z, str3, str4);
            if (!z) {
                hm9.e(str);
            } else if (this.a.c() != null && this.a.c().getCallRobotEntrance() != null && this.a.c().getCallRobotEntrance().ability_conf != null) {
                CallRobotEntrance callRobotEntrance = this.a.c().getCallRobotEntrance();
                String c = hm9.c(this.a.c().getFirstPostId(), TbadkCoreApplication.getCurrentPortrait(), System.currentTimeMillis());
                TbPageContext<BaseFragmentActivity> pageContext = this.b.b.getPageContext();
                AbilityConf abilityConf = callRobotEntrance.ability_conf;
                hm9.a(pageContext, abilityConf.bot_uk, abilityConf.skill_id.intValue(), this.a.c().tid, this.a.c().getFirstPostId(), c, new C0438a(this, str, c));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class PbFirstFloorCommentAndPraiseViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PbThreadCommentAndPraiseInfoLayout a;
        public View b;
        public int c;
        @NonNull
        public pv4 d;
        public final WeakReference<bo9> e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PbFirstFloorCommentAndPraiseViewHolder(View view2, bo9 bo9Var) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, bo9Var};
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
            this.d = new pv4();
            this.e = new WeakReference<>(bo9Var);
            if (view2 == null) {
                return;
            }
            this.a = (PbThreadCommentAndPraiseInfoLayout) view2.findViewById(R.id.obfuscated_res_0x7f09057d);
            pv4 pv4Var = this.d;
            pv4Var.b = 4;
            pv4Var.h = 7;
            pv4Var.c = this.c;
            pv4Var.f = PbFirstFloorCommentAndPraiseAdapter.m;
            this.a.setAgreeStatisticData(this.d);
            this.a.setIsPbFirst(true);
            View findViewById = view2.findViewById(R.id.bottom_divider_line);
            this.b = findViewById;
            findViewById.setVisibility(0);
        }

        public void a(of9 of9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, of9Var) == null) {
                if (of9Var != null && of9Var.c() != null) {
                    ThreadData c = of9Var.c();
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
                    bo9 bo9Var = this.e.get();
                    if (bo9Var != null && bo9Var.e0() != null && bo9Var.e0().s1() != null) {
                        this.a.C = !gm9.c(bo9Var.e0().s1());
                    }
                    this.a.e0(c, of9Var.b());
                    View view2 = this.b;
                    if (of9Var.e()) {
                        i = 0;
                    }
                    view2.setVisibility(i);
                    if (c.isVideoThreadType() && c.getThreadVideoInfo() != null) {
                        this.c = 2;
                    } else {
                        this.c = 1;
                    }
                    if (of9Var.b) {
                        getView().setPadding(0, 0, 0, BdUtilHelper.getDimens(getView().getContext(), R.dimen.tbds32));
                    }
                    this.a.showOperationMaskView(of9Var.f());
                    this.a.setUseDynamicLikeRes();
                }
                onChangeSkinType();
            }
        }

        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.d.j = str;
            }
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.a.setTopicId(str);
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.a.setTopicSubjectName(str);
            }
        }

        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                SkinManager.setBackgroundColor(this.b, R.color.CAM_X0203);
                this.a.onChangeSkinType();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorCommentAndPraiseAdapter(bo9 bo9Var, BdUniqueId bdUniqueId) {
        super(bo9Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bo9Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((bo9) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new LinkedList<>();
        this.k = false;
        if (bo9Var != null && bo9Var.e0() != null) {
            m = bo9Var.e0().r1();
        }
        this.l = bo9Var;
        this.h = new tk9(bo9Var);
    }

    public void K(String str, String str2) {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            if (this.j.size() > 0) {
                Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.j.iterator();
                while (it.hasNext()) {
                    PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                    if (next != null && (pbThreadCommentAndPraiseInfoLayout = next.a) != null) {
                        pbThreadCommentAndPraiseInfoLayout.Y(str, str2);
                    }
                }
            } else if (N() == null) {
            } else {
                this.h.b(N().getAgreeData());
                PbFragment pbFragment = this.b;
                if (pbFragment != null) {
                    pbFragment.p7();
                }
            }
        }
    }

    public final String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a.e0() != null) {
                return this.a.e0().getForumId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.a.e0() != null) {
                return this.a.e0().getFromForumId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ThreadData N = N();
            if (N != null) {
                return N.getFirstPostId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final String P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            bo9 bo9Var = this.l;
            if (bo9Var != null && bo9Var.e0() != null) {
                return this.l.e0().getTopicId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            bo9 bo9Var = this.l;
            if (bo9Var != null && bo9Var.e0() != null) {
                return this.l.e0().Q1();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void S() {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.j.iterator();
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
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            S();
            tk9 tk9Var = this.h;
            if (tk9Var != null) {
                tk9Var.d();
            }
            SafeHandler.getInst().removeCallbacks(this.i);
        }
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.k = z;
        }
    }

    public void W(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.g = onClickListener;
        }
    }

    public final ThreadData N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a.e0() != null && this.a.e0().s1() != null) {
                return this.a.e0().s1().O();
            }
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: R */
    public PbFirstFloorCommentAndPraiseViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = new PbFirstFloorCommentAndPraiseViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0545, viewGroup, false), this.l);
            pbFirstFloorCommentAndPraiseViewHolder.c(P());
            pbFirstFloorCommentAndPraiseViewHolder.d(Q());
            this.j.add(pbFirstFloorCommentAndPraiseViewHolder);
            return pbFirstFloorCommentAndPraiseViewHolder;
        }
        return (PbFirstFloorCommentAndPraiseViewHolder) invokeL.objValue;
    }

    public void U(Animator.AnimatorListener animatorListener) {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, animatorListener) == null) && this.j.size() > 0) {
            Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.j.iterator();
            while (it.hasNext()) {
                PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                if (next != null && (pbThreadCommentAndPraiseInfoLayout = next.a) != null) {
                    pbThreadCommentAndPraiseInfoLayout.d0(animatorListener);
                }
            }
        }
    }

    public View T(int i, View view2, ViewGroup viewGroup, of9 of9Var, PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, of9Var, pbFirstFloorCommentAndPraiseViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) of9Var, (of9) pbFirstFloorCommentAndPraiseViewHolder);
            if (of9Var != null && pbFirstFloorCommentAndPraiseViewHolder != null) {
                of9Var.c().statFloor = getPositionByType(i) + 1;
                pbFirstFloorCommentAndPraiseViewHolder.a.setOnClickOutListener(this.g);
                pbFirstFloorCommentAndPraiseViewHolder.a.setOnClickBotListener(new a(this, of9Var));
                pbFirstFloorCommentAndPraiseViewHolder.a.setPostId(O());
                pbFirstFloorCommentAndPraiseViewHolder.a.setForumId(L());
                of9Var.h(this.k);
                pbFirstFloorCommentAndPraiseViewHolder.b(M());
                pbFirstFloorCommentAndPraiseViewHolder.a(of9Var);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.qi9, com.baidu.tieba.lh
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        T(i, view2, viewGroup, (of9) obj, (PbFirstFloorCommentAndPraiseViewHolder) viewHolder);
        return view2;
    }
}
