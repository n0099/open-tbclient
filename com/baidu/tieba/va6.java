package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.ala.view.ForbidParentSwipeBackRelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.livecard.adapters.FrsAlaStageLiveViewItemAdapter;
import com.baidu.tieba.ala.livecard.vc.FrsAlaStageLiveViewPager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class va6 extends wi6<aq9> implements tj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForbidParentSwipeBackRelativeLayout i;
    public FrsAlaStageLiveViewPager j;
    public FrsAlaStageLiveViewItemAdapter k;
    public LinearLayout l;
    public IndicatorView m;
    public View n;
    public View o;
    public String p;
    public aq9 q;
    public int r;
    public pa6 s;
    public qa6 t;
    public boolean u;
    public int v;
    public boolean w;
    public int x;
    public ViewPager.OnPageChangeListener y;
    public ra6 z;

    @Override // com.baidu.tieba.wi6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? R.layout.obfuscated_res_0x7f0d0331 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
        }
    }

    @Override // com.baidu.tieba.tj6
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements SwipeBackLayout.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va6 a;

        public a(va6 va6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = va6Var;
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void K0() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.q != null && !ListUtils.isEmpty(this.a.q.a) && this.a.q.a.size() > 1) {
                if (this.a.b.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.a.b.getOrignalPage()).setSwipeBackEnabled(false);
                } else if (this.a.b.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) this.a.b.getOrignalPage()).setSwipeBackEnabled(false);
                }
            }
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void m0() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.b.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.a.b.getOrignalPage()).setSwipeBackEnabled(this.a.w);
                } else if (this.a.b.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) this.a.b.getOrignalPage()).setSwipeBackEnabled(this.a.w);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va6 a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        public b(va6 va6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = va6Var;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            int count;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || i == 1 || i != 0 || (count = this.a.k.getCount()) < 2) {
                return;
            }
            int currentItem = this.a.j.getCurrentItem();
            int i2 = count - 2;
            if (currentItem < 1) {
                this.a.j.setCurrentItem(i2, false);
            } else if (currentItem > i2) {
                this.a.j.setCurrentItem(1, false);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a.r = i;
                if (this.a.t == null) {
                    return;
                }
                int a = this.a.t.a(i + 1);
                this.a.r = a;
                if (this.a.m != null) {
                    this.a.m.setPosition(this.a.t.c(a));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ra6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va6 a;

        public c(va6 va6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = va6Var;
        }

        @Override // com.baidu.tieba.ra6
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, threadData) == null) {
                this.a.E(view2, threadData);
                this.a.C(threadData);
                va6 va6Var = this.a;
                va6Var.F(va6Var.b, threadData);
            }
        }

        @Override // com.baidu.tieba.ra6
        public void b(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
                this.a.E(view2, threadData);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public va6(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = 1;
        this.u = false;
        this.v = 5;
        this.w = true;
        this.y = new b(this);
        this.z = new c(this);
        this.i = (ForbidParentSwipeBackRelativeLayout) h().findViewById(R.id.layout_root);
        this.n = h().findViewById(R.id.obfuscated_res_0x7f0908e3);
        this.o = h().findViewById(R.id.obfuscated_res_0x7f0908ef);
        this.j = (FrsAlaStageLiveViewPager) h().findViewById(R.id.obfuscated_res_0x7f090d3a);
        this.l = (LinearLayout) h().findViewById(R.id.obfuscated_res_0x7f090d39);
        this.m = (IndicatorView) h().findViewById(R.id.obfuscated_res_0x7f090d38);
        pa6 pa6Var = new pa6(tbPageContext, this.i);
        this.s = pa6Var;
        pa6Var.d(f());
        this.j.setBackgroundResource(R.drawable.transparent_bg);
        this.j.setOnPageChangeListener(this.y);
        FrsAlaStageLiveViewItemAdapter frsAlaStageLiveViewItemAdapter = new FrsAlaStageLiveViewItemAdapter(this.b, f());
        this.k = frsAlaStageLiveViewItemAdapter;
        this.j.setAdapter(frsAlaStageLiveViewItemAdapter);
        if (this.b.getOrignalPage() instanceof BaseActivity) {
            this.w = ((BaseActivity) this.b.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.b.getOrignalPage() instanceof BaseFragmentActivity) {
            this.w = ((BaseFragmentActivity) this.b.getOrignalPage()).isSwipeBackEnabled();
        }
        this.i.setSwipeControlInterface(new a(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wi6
    /* renamed from: G */
    public void i(aq9 aq9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, aq9Var) == null) && aq9Var != null && aq9Var.a != null) {
            this.q = aq9Var;
            q(0);
            if (this.t == null) {
                qa6 qa6Var = new qa6(aq9Var.a, this.u, this.v);
                this.t = qa6Var;
                qa6Var.i(2);
                this.t.h(6);
                this.t.g(1);
            }
            this.t.j(aq9Var.a);
            this.k.d(this.p);
            this.k.c(this.t.e(), this.z);
            this.j.setCurrentItem(this.t.d(), false);
            if (aq9Var.a.size() >= 2) {
                this.l.setVisibility(0);
                if (this.m.getCount() != this.t.b()) {
                    this.m.setCount(this.t.b());
                    this.r = this.t.d();
                }
                this.m.setPosition(this.t.c(this.r));
            } else {
                this.l.setVisibility(8);
            }
            if (aq9Var.a.size() > 0) {
                this.s.b(aq9Var.a.get(0), "ala_frs_stage_live_feed_back_type");
            }
            D();
            j(g(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.wi6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(this.i, R.drawable.addresslist_item_bg);
                SkinManager.setBackgroundColor(this.n, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204);
                this.a = i;
            }
            this.s.c();
        }
    }

    public final AlaLiveInfoCoreData H(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, threadData)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(threadData.getThreadAlaInfo());
            alaLiveInfoCoreData.userName = threadData.getAuthor().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tj6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.p = str;
        }
    }

    public final void C(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) && threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().user_info != null && threadData.getThreadAlaInfo().user_info.is_official == 2) {
            TiebaStatic.log(new StatisticItem("c12805").param("tid", threadData.getId()));
        }
    }

    public final void D() {
        aq9 aq9Var;
        int c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (aq9Var = this.q) != null && ListUtils.isEmpty(aq9Var.a) && (c2 = this.t.c(this.r)) < this.q.a.size() && c2 >= 0) {
            CustomMessage customMessage = new CustomMessage(2921017);
            List<ThreadData> list = this.q.a;
            if (list != null && list.get(c2) != null) {
                this.q.a.get(c2).statFloor = this.x;
            }
            customMessage.setData(this.q.a.get(c2));
            MessageManager.getInstance().sendMessage(customMessage);
            if (this.q.a.get(c2) != null) {
                TiebaStatic.log(new StatisticItem("c12804").param("tid", this.q.a.get(c2).getId()));
            }
        }
    }

    public final void E(View view2, ThreadData threadData) {
        CustomMessage customMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, threadData) == null) {
            if (view2.getId() == R.id.layout_root) {
                customMessage = new CustomMessage(2921018);
            } else if (view2.getId() != R.id.card_home_page_normal_thread_user_name && view2.getId() != R.id.card_home_page_normal_thread_user_header) {
                if (view2.getId() == R.id.video_container) {
                    customMessage = new CustomMessage(2921019);
                } else {
                    customMessage = null;
                }
            } else {
                customMessage = new CustomMessage(2921016);
            }
            if (customMessage != null && this.b != null) {
                customMessage.setData(threadData);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public void F(TbPageContext<?> tbPageContext, ThreadData threadData) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, tbPageContext, threadData) == null) && tbPageContext != null && threadData != null && threadData.getAuthor() != null && threadData.getThreadAlaInfo() != null) {
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = threadData.getAuthor().getUserId();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, currentAccount);
                str = currentAccount;
            } else {
                str = "";
                z = false;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(threadData.getThreadAlaInfo());
            if (threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().user_info != null) {
                alaLiveInfoCoreData.userName = threadData.getThreadAlaInfo().user_info.user_name;
            }
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            aq9 aq9Var = this.q;
            if (aq9Var != null && !ListUtils.isEmpty(aq9Var.a)) {
                for (ThreadData threadData2 : this.q.a) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(H(threadData2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_INSERT_LIVE, str, z, null, null, this.p)));
        }
    }
}
