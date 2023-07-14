package com.baidu.tieba.pb.pb.main.adapter;

import android.animation.Animator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.FriendBotView;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.coreExtra.data.FriendBotPostConfigData;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.R;
import com.baidu.tieba.bn9;
import com.baidu.tieba.gl9;
import com.baidu.tieba.hl9;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pf9;
import com.baidu.tieba.wh9;
import com.baidu.tieba.yi;
import com.baidu.tieba.yj9;
import com.baidu.tieba.z15;
import com.baidu.tieba.zg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class PbFirstFloorCommentAndPraiseAdapter extends wh9<pf9, PbFirstFloorCommentAndPraiseViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public static int m;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener g;
    public yj9 h;
    public Runnable i;
    public final LinkedList<PbFirstFloorCommentAndPraiseViewHolder> j;
    public boolean k;
    public bn9 l;

    /* loaded from: classes7.dex */
    public class a implements FriendBotView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pf9 a;
        public final /* synthetic */ PbFirstFloorCommentAndPraiseAdapter b;

        /* renamed from: com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0444a extends FastRequest.b<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String b;
            public final /* synthetic */ long c;
            public final /* synthetic */ a d;

            public C0444a(a aVar, String str, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str, Long.valueOf(j)};
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
                this.c = j;
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
                    if (this.d.b.b.Q() != null && this.d.b.b.L5() != null && this.d.b.b.L5().F0() != null) {
                        this.d.b.b.Q().t3();
                        this.d.b.b.L5().F0().f0();
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
                    hl9.e(this.b);
                    String c = hl9.c(this.d.a.c().getFirstPostId(), TbadkCoreApplication.getCurrentPortrait(), this.c);
                    hl9.b(this.d.b.b.Q(), c);
                    if (this.d.b.i != null) {
                        zg.a().removeCallbacks(this.d.b.i);
                    }
                    PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.d.b;
                    pbFirstFloorCommentAndPraiseAdapter.i = new b(pbFirstFloorCommentAndPraiseAdapter, c, pbFirstFloorCommentAndPraiseAdapter.b);
                    zg.a().postDelayed(this.d.b.i, 30000L);
                }
            }
        }

        public a(PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter, pf9 pf9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorCommentAndPraiseAdapter, pf9Var};
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
            this.a = pf9Var;
        }

        @Override // com.baidu.tbadk.core.view.FriendBotView.d
        public void a(boolean z, String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                String str3 = "";
                if (this.a.c() == null || this.a.c().getCallRobotEntrance() == null || this.a.c().getCallRobotEntrance().ability_conf == null) {
                    str2 = "";
                } else {
                    str2 = this.a.c().getCallRobotEntrance().ability_conf.bot_uk;
                }
                if (this.a.c() != null) {
                    str3 = String.valueOf(this.a.c().getFid());
                }
                CommonStatisticUtils.statisticFriendBotView(2, str2, 1, z, str3);
                if (!z) {
                    hl9.e(str);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                hl9.a(this.b.b.getPageContext(), this.a.c(), currentTimeMillis, new C0444a(this, str, currentTimeMillis));
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
        public z15 d;
        public final WeakReference<bn9> e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PbFirstFloorCommentAndPraiseViewHolder(View view2, bn9 bn9Var) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, bn9Var};
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
            this.d = new z15();
            this.e = new WeakReference<>(bn9Var);
            if (view2 == null) {
                return;
            }
            this.a = (PbThreadCommentAndPraiseInfoLayout) view2.findViewById(R.id.obfuscated_res_0x7f09056c);
            z15 z15Var = this.d;
            z15Var.b = 4;
            z15Var.h = 7;
            z15Var.c = this.c;
            z15Var.f = PbFirstFloorCommentAndPraiseAdapter.m;
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

        public void b(pf9 pf9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pf9Var) == null) {
                if (pf9Var != null && pf9Var.c() != null) {
                    ThreadData c = pf9Var.c();
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
                    bn9 bn9Var = this.e.get();
                    if (bn9Var != null && bn9Var.Q() != null && bn9Var.Q().z1() != null) {
                        this.a.C = !gl9.c(bn9Var.Q().z1());
                    }
                    this.a.c0(c, pf9Var.b());
                    View view2 = this.b;
                    if (pf9Var.e()) {
                        i = 0;
                    }
                    view2.setVisibility(i);
                    if (c.isVideoThreadType() && c.getThreadVideoInfo() != null) {
                        this.c = 2;
                    } else {
                        this.c = 1;
                    }
                    if (pf9Var.b) {
                        getView().setPadding(0, 0, 0, yi.g(getView().getContext(), R.dimen.tbds32));
                    }
                    this.a.showOperationMaskView(pf9Var.f());
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

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<PbFragment> a;
        public String b;

        public b(PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter, String str, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorCommentAndPraiseAdapter, str, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = "";
            this.a = new WeakReference<>(pbFragment);
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FriendBotPostConfigData friendBotPostConfigData = TbSingleton.getInstance().getFriendBotPostConfigData();
                if (friendBotPostConfigData == null) {
                    str = "";
                } else {
                    str = friendBotPostConfigData.getLoadingPostDefaultContent();
                }
                if (TextUtils.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07ee);
                }
                hl9.d(this.b, str, "", 2);
                PbFragment pbFragment = this.a.get();
                if (pbFragment != null && pbFragment.L5() != null && pbFragment.L5().F0() != null) {
                    pbFragment.L5().F0().f0();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorCommentAndPraiseAdapter(bn9 bn9Var, BdUniqueId bdUniqueId) {
        super(bn9Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bn9Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((bn9) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new LinkedList<>();
        this.k = false;
        if (bn9Var != null && bn9Var.Q() != null) {
            m = bn9Var.Q().y1();
        }
        this.l = bn9Var;
        this.h = new yj9(bn9Var);
    }

    public void J(String str, String str2) {
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
                    pbFragment.l6();
                }
            }
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

    public final String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a.Q() != null) {
                return this.a.Q().getForumId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.a.Q() != null) {
                return this.a.Q().getFromForumId();
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
            bn9 bn9Var = this.l;
            if (bn9Var != null && bn9Var.Q() != null) {
                return this.l.Q().getTopicId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            bn9 bn9Var = this.l;
            if (bn9Var != null && bn9Var.Q() != null) {
                return this.l.Q().W1();
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
            yj9 yj9Var = this.h;
            if (yj9Var != null) {
                yj9Var.d();
            }
            zg.a().removeCallbacks(this.i);
        }
    }

    public final ThreadData N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a.Q() != null && this.a.Q().z1() != null) {
                return this.a.Q().z1().N();
            }
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: R */
    public PbFirstFloorCommentAndPraiseViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = new PbFirstFloorCommentAndPraiseViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0535, viewGroup, false), this.l);
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

    public View T(int i, View view2, ViewGroup viewGroup, pf9 pf9Var, PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, pf9Var, pbFirstFloorCommentAndPraiseViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) pf9Var, (pf9) pbFirstFloorCommentAndPraiseViewHolder);
            if (pf9Var != null && pbFirstFloorCommentAndPraiseViewHolder != null) {
                pf9Var.c().statFloor = getPositionByType(i) + 1;
                pbFirstFloorCommentAndPraiseViewHolder.a.setOnClickOutListener(this.g);
                pbFirstFloorCommentAndPraiseViewHolder.a.setOnClickBotListener(new a(this, pf9Var));
                pbFirstFloorCommentAndPraiseViewHolder.a.setPostId(O());
                pbFirstFloorCommentAndPraiseViewHolder.a.setForumId(L());
                pf9Var.h(this.k);
                pbFirstFloorCommentAndPraiseViewHolder.c(M());
                pbFirstFloorCommentAndPraiseViewHolder.b(pf9Var);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.wh9, com.baidu.tieba.ln
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        T(i, view2, viewGroup, (pf9) obj, (PbFirstFloorCommentAndPraiseViewHolder) viewHolder);
        return view2;
    }
}
