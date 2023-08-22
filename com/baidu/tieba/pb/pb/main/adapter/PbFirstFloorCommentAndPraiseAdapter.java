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
import com.baidu.tieba.aq9;
import com.baidu.tieba.bw5;
import com.baidu.tieba.c15;
import com.baidu.tieba.fo9;
import com.baidu.tieba.go9;
import com.baidu.tieba.mg9;
import com.baidu.tieba.oi9;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.vk9;
import com.baidu.tieba.xm9;
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
public class PbFirstFloorCommentAndPraiseAdapter extends vk9<oi9, PbFirstFloorCommentAndPraiseViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public static int m;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener g;
    public xm9 h;
    public Runnable i;
    public final LinkedList<PbFirstFloorCommentAndPraiseViewHolder> j;
    public boolean k;
    public aq9 l;

    /* loaded from: classes7.dex */
    public class a implements FriendBotView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi9 a;
        public final /* synthetic */ PbFirstFloorCommentAndPraiseAdapter b;

        @Override // com.baidu.tbadk.core.view.FriendBotView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            }
        }

        /* renamed from: com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0447a extends FastRequest.b<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ a d;

            public C0447a(a aVar, String str, String str2) {
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
                this.d = aVar;
                this.b = str;
                this.c = str2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.net.FastRequest.b
            /* renamed from: f */
            public void b(int i, @NonNull String str, @Nullable Void r7) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                    super.b(i, str, r7);
                    if (this.d.b.b == null) {
                        return;
                    }
                    this.d.b.b.showToast(str);
                    if (this.d.b.b.W() != null && this.d.b.b.Y5() != null && this.d.b.b.Y5().T0() != null) {
                        this.d.b.b.W().o3();
                        this.d.b.b.Y5().T0().f0();
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.net.FastRequest.b
            /* renamed from: g */
            public void e(@NonNull Void r5) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                    super.e(r5);
                    go9.e(this.b);
                    go9.b(this.d.b.b.W(), this.c);
                    if (this.d.b.i != null) {
                        SafeHandler.getInst().removeCallbacks(this.d.b.i);
                    }
                    PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.d.b;
                    pbFirstFloorCommentAndPraiseAdapter.i = new mg9(this.c, pbFirstFloorCommentAndPraiseAdapter.b);
                    SafeHandler.getInst().postDelayed(this.d.b.i, 30000L);
                }
            }
        }

        public a(PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter, oi9 oi9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorCommentAndPraiseAdapter, oi9Var};
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
            this.a = oi9Var;
        }

        @Override // com.baidu.tbadk.core.view.FriendBotView.f
        public void b(boolean z, boolean z2, String str) {
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) != null) || bw5.a()) {
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
                go9.e(str);
            } else if (this.a.c() != null && this.a.c().getCallRobotEntrance() != null && this.a.c().getCallRobotEntrance().ability_conf != null) {
                CallRobotEntrance callRobotEntrance = this.a.c().getCallRobotEntrance();
                String c = go9.c(this.a.c().getFirstPostId(), TbadkCoreApplication.getCurrentPortrait(), System.currentTimeMillis());
                TbPageContext<BaseFragmentActivity> pageContext = this.b.b.getPageContext();
                AbilityConf abilityConf = callRobotEntrance.ability_conf;
                go9.a(pageContext, abilityConf.bot_uk, abilityConf.skill_id.intValue(), this.a.c().tid, this.a.c().getFirstPostId(), c, new C0447a(this, str, c));
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
        public c15 d;
        public final WeakReference<aq9> e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PbFirstFloorCommentAndPraiseViewHolder(View view2, aq9 aq9Var) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, aq9Var};
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
            this.d = new c15();
            this.e = new WeakReference<>(aq9Var);
            if (view2 == null) {
                return;
            }
            this.a = (PbThreadCommentAndPraiseInfoLayout) view2.findViewById(R.id.obfuscated_res_0x7f09057c);
            c15 c15Var = this.d;
            c15Var.b = 4;
            c15Var.h = 7;
            c15Var.c = this.c;
            c15Var.f = PbFirstFloorCommentAndPraiseAdapter.m;
            this.a.setAgreeStatisticData(this.d);
            this.a.setIsPbFirst(true);
            View findViewById = view2.findViewById(R.id.bottom_divider_line);
            this.b = findViewById;
            findViewById.setVisibility(0);
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setBackgroundColor(this.b, R.color.CAM_X0203);
                this.a.onChangeSkinType();
            }
        }

        public void b(oi9 oi9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oi9Var) == null) {
                if (oi9Var != null && oi9Var.c() != null) {
                    ThreadData c = oi9Var.c();
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
                    aq9 aq9Var = this.e.get();
                    if (aq9Var != null && aq9Var.W() != null && aq9Var.W().s1() != null) {
                        this.a.C = !fo9.c(aq9Var.W().s1());
                    }
                    this.a.c0(c, oi9Var.b());
                    View view2 = this.b;
                    if (oi9Var.e()) {
                        i = 0;
                    }
                    view2.setVisibility(i);
                    if (c.isVideoThreadType() && c.getThreadVideoInfo() != null) {
                        this.c = 2;
                    } else {
                        this.c = 1;
                    }
                    if (oi9Var.b) {
                        getView().setPadding(0, 0, 0, BdUtilHelper.getDimens(getView().getContext(), R.dimen.tbds32));
                    }
                    this.a.showOperationMaskView(oi9Var.f());
                    this.a.setUseDynamicLikeRes();
                }
                a();
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
    public PbFirstFloorCommentAndPraiseAdapter(aq9 aq9Var, BdUniqueId bdUniqueId) {
        super(aq9Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aq9Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((aq9) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new LinkedList<>();
        this.k = false;
        if (aq9Var != null && aq9Var.W() != null) {
            m = aq9Var.W().r1();
        }
        this.l = aq9Var;
        this.h = new xm9(aq9Var);
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
                        pbThreadCommentAndPraiseInfoLayout.W(str, str2);
                    }
                }
            } else if (N() == null) {
            } else {
                this.h.b(N().getAgreeData());
                PbFragment pbFragment = this.b;
                if (pbFragment != null) {
                    pbFragment.y6();
                }
            }
        }
    }

    public final String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a.W() != null) {
                return this.a.W().getForumId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.a.W() != null) {
                return this.a.W().getFromForumId();
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
            aq9 aq9Var = this.l;
            if (aq9Var != null && aq9Var.W() != null) {
                return this.l.W().getTopicId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            aq9 aq9Var = this.l;
            if (aq9Var != null && aq9Var.W() != null) {
                return this.l.W().Q1();
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
            xm9 xm9Var = this.h;
            if (xm9Var != null) {
                xm9Var.d();
            }
            SafeHandler.getInst().removeCallbacks(this.i);
        }
    }

    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.k = z;
        }
    }

    public void X(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.g = onClickListener;
        }
    }

    public final ThreadData N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a.W() != null && this.a.W().s1() != null) {
                return this.a.W().s1().O();
            }
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: R */
    public PbFirstFloorCommentAndPraiseViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = new PbFirstFloorCommentAndPraiseViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0541, viewGroup, false), this.l);
            pbFirstFloorCommentAndPraiseViewHolder.d(P());
            pbFirstFloorCommentAndPraiseViewHolder.e(Q());
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
                    pbThreadCommentAndPraiseInfoLayout.b0(animatorListener);
                }
            }
        }
    }

    public View T(int i, View view2, ViewGroup viewGroup, oi9 oi9Var, PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, oi9Var, pbFirstFloorCommentAndPraiseViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) oi9Var, (oi9) pbFirstFloorCommentAndPraiseViewHolder);
            if (oi9Var != null && pbFirstFloorCommentAndPraiseViewHolder != null) {
                oi9Var.c().statFloor = getPositionByType(i) + 1;
                pbFirstFloorCommentAndPraiseViewHolder.a.setOnClickOutListener(this.g);
                pbFirstFloorCommentAndPraiseViewHolder.a.setOnClickBotListener(new a(this, oi9Var));
                pbFirstFloorCommentAndPraiseViewHolder.a.setPostId(O());
                pbFirstFloorCommentAndPraiseViewHolder.a.setForumId(L());
                oi9Var.h(this.k);
                pbFirstFloorCommentAndPraiseViewHolder.c(M());
                pbFirstFloorCommentAndPraiseViewHolder.b(oi9Var);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.vk9, com.baidu.tieba.om
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        T(i, view2, viewGroup, (oi9) obj, (PbFirstFloorCommentAndPraiseViewHolder) viewHolder);
        return view2;
    }
}
