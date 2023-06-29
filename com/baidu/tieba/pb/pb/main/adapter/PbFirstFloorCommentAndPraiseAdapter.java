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
import com.baidu.tieba.bf9;
import com.baidu.tieba.cf9;
import com.baidu.tieba.k99;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.r15;
import com.baidu.tieba.rb9;
import com.baidu.tieba.td9;
import com.baidu.tieba.vg9;
import com.baidu.tieba.xi;
import com.baidu.tieba.yg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class PbFirstFloorCommentAndPraiseAdapter extends rb9<k99, PbFirstFloorCommentAndPraiseViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public static int m;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener g;
    public td9 h;
    public Runnable i;
    public final LinkedList<PbFirstFloorCommentAndPraiseViewHolder> j;
    public boolean k;
    public vg9 l;

    /* loaded from: classes7.dex */
    public class a implements FriendBotView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k99 a;
        public final /* synthetic */ PbFirstFloorCommentAndPraiseAdapter b;

        /* renamed from: com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0446a extends FastRequest.b<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String b;
            public final /* synthetic */ long c;
            public final /* synthetic */ a d;

            public C0446a(a aVar, String str, long j) {
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
                        this.d.b.b.Q().s3();
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
                    cf9.e(this.b);
                    String c = cf9.c(this.d.a.c().getFirstPostId(), TbadkCoreApplication.getCurrentPortrait(), this.c);
                    cf9.b(this.d.b.b.Q(), c);
                    if (this.d.b.i != null) {
                        yg.a().removeCallbacks(this.d.b.i);
                    }
                    PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.d.b;
                    pbFirstFloorCommentAndPraiseAdapter.i = new b(pbFirstFloorCommentAndPraiseAdapter, c, pbFirstFloorCommentAndPraiseAdapter.b);
                    yg.a().postDelayed(this.d.b.i, 30000L);
                }
            }
        }

        public a(PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter, k99 k99Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorCommentAndPraiseAdapter, k99Var};
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
            this.a = k99Var;
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
                    cf9.e(str);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                cf9.a(this.b.b.getPageContext(), this.a.c(), currentTimeMillis, new C0446a(this, str, currentTimeMillis));
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
        public r15 d;
        public final WeakReference<vg9> e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PbFirstFloorCommentAndPraiseViewHolder(View view2, vg9 vg9Var) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, vg9Var};
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
            this.d = new r15();
            this.e = new WeakReference<>(vg9Var);
            if (view2 == null) {
                return;
            }
            this.a = (PbThreadCommentAndPraiseInfoLayout) view2.findViewById(R.id.obfuscated_res_0x7f09056b);
            r15 r15Var = this.d;
            r15Var.b = 4;
            r15Var.h = 7;
            r15Var.c = this.c;
            r15Var.f = PbFirstFloorCommentAndPraiseAdapter.m;
            this.a.setAgreeStatisticData(this.d);
            this.a.setIsPbFirst(true);
            View findViewById = view2.findViewById(R.id.bottom_divider_line);
            this.b = findViewById;
            findViewById.setVisibility(0);
        }

        public void a(k99 k99Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k99Var) == null) {
                if (k99Var != null && k99Var.c() != null) {
                    ThreadData c = k99Var.c();
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
                    vg9 vg9Var = this.e.get();
                    if (vg9Var != null && vg9Var.Q() != null && vg9Var.Q().y1() != null) {
                        this.a.C = !bf9.c(vg9Var.Q().y1());
                    }
                    this.a.c0(c, k99Var.b());
                    View view2 = this.b;
                    if (k99Var.e()) {
                        i = 0;
                    }
                    view2.setVisibility(i);
                    if (c.isVideoThreadType() && c.getThreadVideoInfo() != null) {
                        this.c = 2;
                    } else {
                        this.c = 1;
                    }
                    if (k99Var.b) {
                        getView().setPadding(0, 0, 0, xi.g(getView().getContext(), R.dimen.tbds32));
                    }
                    this.a.showOperationMaskView(k99Var.f());
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
                    str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07e5);
                }
                cf9.d(this.b, str, "", 2);
                PbFragment pbFragment = this.a.get();
                if (pbFragment != null && pbFragment.L5() != null && pbFragment.L5().F0() != null) {
                    pbFragment.L5().F0().f0();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorCommentAndPraiseAdapter(vg9 vg9Var, BdUniqueId bdUniqueId) {
        super(vg9Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vg9Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((vg9) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new LinkedList<>();
        this.k = false;
        if (vg9Var != null && vg9Var.Q() != null) {
            m = vg9Var.Q().x1();
        }
        this.l = vg9Var;
        this.h = new td9(vg9Var);
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

    public final String K() {
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
            vg9 vg9Var = this.l;
            if (vg9Var != null && vg9Var.Q() != null) {
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
            vg9 vg9Var = this.l;
            if (vg9Var != null && vg9Var.Q() != null) {
                return this.l.Q().V1();
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
            td9 td9Var = this.h;
            if (td9Var != null) {
                td9Var.d();
            }
            yg.a().removeCallbacks(this.i);
        }
    }

    public final ThreadData N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a.Q() != null && this.a.Q().y1() != null) {
                return this.a.Q().y1().N();
            }
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: R */
    public PbFirstFloorCommentAndPraiseViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = new PbFirstFloorCommentAndPraiseViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0529, viewGroup, false), this.l);
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

    public View T(int i, View view2, ViewGroup viewGroup, k99 k99Var, PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, k99Var, pbFirstFloorCommentAndPraiseViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) k99Var, (k99) pbFirstFloorCommentAndPraiseViewHolder);
            if (k99Var != null && pbFirstFloorCommentAndPraiseViewHolder != null) {
                k99Var.c().statFloor = getPositionByType(i) + 1;
                pbFirstFloorCommentAndPraiseViewHolder.a.setOnClickOutListener(this.g);
                pbFirstFloorCommentAndPraiseViewHolder.a.setOnClickBotListener(new a(this, k99Var));
                pbFirstFloorCommentAndPraiseViewHolder.a.setPostId(O());
                pbFirstFloorCommentAndPraiseViewHolder.a.setForumId(K());
                k99Var.i(this.k);
                pbFirstFloorCommentAndPraiseViewHolder.c(M());
                pbFirstFloorCommentAndPraiseViewHolder.a(k99Var);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.rb9, com.baidu.tieba.kn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        T(i, view2, viewGroup, (k99) obj, (PbFirstFloorCommentAndPraiseViewHolder) viewHolder);
        return view2;
    }
}
