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
import com.baidu.tieba.a0a;
import com.baidu.tieba.f2a;
import com.baidu.tieba.i6a;
import com.baidu.tieba.l4a;
import com.baidu.tieba.lw4;
import com.baidu.tieba.nt5;
import com.baidu.tieba.nu9;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pw9;
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
public class PbFirstFloorCommentAndPraiseAdapter extends a0a<pw9, PbFirstFloorCommentAndPraiseViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public static int m;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener g;
    public f2a h;
    public Runnable i;
    public final LinkedList<PbFirstFloorCommentAndPraiseViewHolder> j;
    public boolean k;
    public i6a l;

    /* loaded from: classes7.dex */
    public class a implements FriendBotView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pw9 a;
        public final /* synthetic */ PbFirstFloorCommentAndPraiseAdapter b;

        @Override // com.baidu.tbadk.core.view.FriendBotView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            }
        }

        /* renamed from: com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0436a extends FastRequest.b<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String d;
            public final /* synthetic */ String e;
            public final /* synthetic */ a f;

            public C0436a(a aVar, String str, String str2) {
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
                    if (this.f.b.b.l0() != null && this.f.b.b.i7() != null && this.f.b.b.i7().G0() != null) {
                        this.f.b.b.l0().m3();
                        this.f.b.b.i7().G0().v();
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
                    l4a.e(this.d);
                    l4a.b(this.f.b.b.l0(), this.e);
                    if (this.f.b.i != null) {
                        SafeHandler.getInst().removeCallbacks(this.f.b.i);
                    }
                    PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.f.b;
                    pbFirstFloorCommentAndPraiseAdapter.i = new nu9(this.e, pbFirstFloorCommentAndPraiseAdapter.b);
                    SafeHandler.getInst().postDelayed(this.f.b.i, 30000L);
                }
            }
        }

        public a(PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter, pw9 pw9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorCommentAndPraiseAdapter, pw9Var};
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
            this.a = pw9Var;
        }

        @Override // com.baidu.tbadk.core.view.FriendBotView.f
        public void b(boolean z, boolean z2, String str) {
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) != null) || nt5.a()) {
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
                l4a.e(str);
            } else if (this.a.c() != null && this.a.c().getCallRobotEntrance() != null && this.a.c().getCallRobotEntrance().ability_conf != null) {
                CallRobotEntrance callRobotEntrance = this.a.c().getCallRobotEntrance();
                String c = l4a.c(this.a.c().getFirstPostId(), TbadkCoreApplication.getCurrentPortrait(), System.currentTimeMillis());
                TbPageContext<BaseFragmentActivity> pageContext = this.b.b.getPageContext();
                AbilityConf abilityConf = callRobotEntrance.ability_conf;
                l4a.a(pageContext, abilityConf.bot_uk, abilityConf.skill_id.intValue(), this.a.c().tid, this.a.c().getFirstPostId(), c, new C0436a(this, str, c));
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
        public lw4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PbFirstFloorCommentAndPraiseViewHolder(View view2, i6a i6aVar) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, i6aVar};
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
            this.d = new lw4();
            new WeakReference(i6aVar);
            if (view2 == null) {
                return;
            }
            this.a = (PbThreadCommentAndPraiseInfoLayout) view2.findViewById(R.id.obfuscated_res_0x7f0905b6);
            lw4 lw4Var = this.d;
            lw4Var.b = 4;
            lw4Var.h = 7;
            lw4Var.c = this.c;
            lw4Var.f = PbFirstFloorCommentAndPraiseAdapter.m;
            this.a.setAgreeStatisticData(this.d);
            this.a.setIsPbFirst(true);
            View findViewById = view2.findViewById(R.id.bottom_divider_line);
            this.b = findViewById;
            findViewById.setVisibility(0);
        }

        public void a(pw9 pw9Var) {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pw9Var) == null) {
                if (pw9Var != null && pw9Var.c() != null) {
                    ThreadData c = pw9Var.c();
                    int i = 8;
                    if (c.isQuestionThread()) {
                        this.a.setVisibility(8);
                        this.b.setVisibility(8);
                        return;
                    }
                    this.a.setVisibility(0);
                    this.b.setVisibility(0);
                    if ((this.a.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && (marginLayoutParams = (ViewGroup.MarginLayoutParams) this.a.getLayoutParams()) != null) {
                        marginLayoutParams.topMargin = pw9Var.d();
                        this.a.setLayoutParams(marginLayoutParams);
                    }
                    if (c.getAgreeData() != null) {
                        c.getAgreeData().postId = c.getFirstPostId();
                    }
                    this.a.b0(c, pw9Var.b());
                    View view2 = this.b;
                    if (pw9Var.f()) {
                        i = 0;
                    }
                    view2.setVisibility(i);
                    if (c.isVideoThreadType() && c.getThreadVideoInfo() != null) {
                        this.c = 2;
                    } else {
                        this.c = 1;
                    }
                    if (pw9Var.b) {
                        getView().setPadding(0, 0, 0, BdUtilHelper.getDimens(getView().getContext(), R.dimen.tbds32));
                    }
                    this.a.showOperationMaskView(pw9Var.g());
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
    public PbFirstFloorCommentAndPraiseAdapter(i6a i6aVar, BdUniqueId bdUniqueId) {
        super(i6aVar, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i6aVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((i6a) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new LinkedList<>();
        this.k = false;
        if (i6aVar != null && i6aVar.l0() != null) {
            m = i6aVar.l0().r1();
        }
        this.l = i6aVar;
        this.h = new f2a(i6aVar);
    }

    public void L(String str, String str2) {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            if (this.j.size() > 0) {
                Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.j.iterator();
                while (it.hasNext()) {
                    PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                    if (next != null && (pbThreadCommentAndPraiseInfoLayout = next.a) != null) {
                        pbThreadCommentAndPraiseInfoLayout.V(str, str2);
                    }
                }
            } else if (O() == null) {
            } else {
                this.h.b(O().getAgreeData());
                PbFragment pbFragment = this.b;
                if (pbFragment != null) {
                    pbFragment.U7();
                }
            }
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

    public final String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a.l0() != null) {
                return this.a.l0().getForumId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.a.l0() != null) {
                return this.a.l0().getFromForumId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final String P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ThreadData O = O();
            if (O != null) {
                return O.getFirstPostId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            i6a i6aVar = this.l;
            if (i6aVar != null && i6aVar.l0() != null) {
                return this.l.l0().getTopicId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final String R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            i6a i6aVar = this.l;
            if (i6aVar != null && i6aVar.l0() != null) {
                return this.l.l0().Q1();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void T() {
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
            T();
            f2a f2aVar = this.h;
            if (f2aVar != null) {
                f2aVar.d();
            }
            SafeHandler.getInst().removeCallbacks(this.i);
        }
    }

    public final ThreadData O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a.l0() != null && this.a.l0().s1() != null) {
                return this.a.l0().s1().R();
            }
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: S */
    public PbFirstFloorCommentAndPraiseViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = new PbFirstFloorCommentAndPraiseViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0573, viewGroup, false), this.l);
            pbFirstFloorCommentAndPraiseViewHolder.c(Q());
            pbFirstFloorCommentAndPraiseViewHolder.d(R());
            this.j.add(pbFirstFloorCommentAndPraiseViewHolder);
            return pbFirstFloorCommentAndPraiseViewHolder;
        }
        return (PbFirstFloorCommentAndPraiseViewHolder) invokeL.objValue;
    }

    public void V(Animator.AnimatorListener animatorListener) {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, animatorListener) == null) && this.j.size() > 0) {
            Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.j.iterator();
            while (it.hasNext()) {
                PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                if (next != null && (pbThreadCommentAndPraiseInfoLayout = next.a) != null) {
                    pbThreadCommentAndPraiseInfoLayout.a0(animatorListener);
                }
            }
        }
    }

    public View U(int i, View view2, ViewGroup viewGroup, pw9 pw9Var, PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, pw9Var, pbFirstFloorCommentAndPraiseViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) pw9Var, (pw9) pbFirstFloorCommentAndPraiseViewHolder);
            if (pw9Var != null && pbFirstFloorCommentAndPraiseViewHolder != null) {
                pw9Var.c().statFloor = getPositionByType(i) + 1;
                pbFirstFloorCommentAndPraiseViewHolder.a.setOnClickOutListener(this.g);
                pbFirstFloorCommentAndPraiseViewHolder.a.setOnClickBotListener(new a(this, pw9Var));
                pbFirstFloorCommentAndPraiseViewHolder.a.setPostId(P());
                pbFirstFloorCommentAndPraiseViewHolder.a.setForumId(M());
                pw9Var.k(this.k);
                pbFirstFloorCommentAndPraiseViewHolder.b(N());
                pbFirstFloorCommentAndPraiseViewHolder.a(pw9Var);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.a0a, com.baidu.tieba.ci
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        U(i, view2, viewGroup, (pw9) obj, (PbFirstFloorCommentAndPraiseViewHolder) viewHolder);
        return view2;
    }
}
