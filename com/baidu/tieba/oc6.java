package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.ala.view.ForbidParentSwipeBackRelativeLayout;
import com.baidu.ala.view.ParentDisallowInterceptHListView;
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
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class oc6 extends nl6<wua> implements km6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadSkinView i;
    public TextView j;
    public TextView k;
    public RelativeLayout l;
    public LinearLayout m;
    public View n;
    public ForbidParentSwipeBackRelativeLayout o;
    public ParentDisallowInterceptHListView p;
    public ec6 q;
    public boolean r;
    public wua s;
    public String t;
    public AdapterView.d u;

    @Override // com.baidu.tieba.nl6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.obfuscated_res_0x7f0d0365 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.km6
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements SwipeBackLayout.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc6 a;

        public a(oc6 oc6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc6Var;
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void A0() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.s != null && !ListUtils.isEmpty(this.a.s.a) && this.a.s.a.size() > 1) {
                if (this.a.b.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.a.b.getOrignalPage()).setSwipeBackEnabled(false);
                } else if (this.a.b.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) this.a.b.getOrignalPage()).setSwipeBackEnabled(false);
                }
            }
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void T() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.b.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.a.b.getOrignalPage()).setSwipeBackEnabled(this.a.r);
                } else if (this.a.b.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) this.a.b.getOrignalPage()).setSwipeBackEnabled(this.a.r);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements AdapterView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc6 a;

        public b(oc6 oc6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc6Var;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                ThreadData item = this.a.q.getItem(i);
                this.a.y(item);
                oc6 oc6Var = this.a;
                oc6Var.A(oc6Var.b, item);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oc6(TbPageContext<?> tbPageContext) {
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
        this.r = true;
        this.u = new b(this);
        this.o = (ForbidParentSwipeBackRelativeLayout) i().findViewById(R.id.layout_root);
        this.i = (ThreadSkinView) i().findViewById(R.id.frs_thread_skin);
        this.j = (TextView) i().findViewById(R.id.obfuscated_res_0x7f090d45);
        this.k = (TextView) i().findViewById(R.id.obfuscated_res_0x7f090d47);
        this.l = (RelativeLayout) i().findViewById(R.id.obfuscated_res_0x7f090d48);
        this.p = (ParentDisallowInterceptHListView) i().findViewById(R.id.obfuscated_res_0x7f090d46);
        this.m = (LinearLayout) i().findViewById(R.id.obfuscated_res_0x7f090cde);
        this.n = i().findViewById(R.id.obfuscated_res_0x7f090958);
        this.p.setDividerWidth(this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070364));
        this.p.setBackgroundResource(R.drawable.transparent_bg);
        this.p.setOnItemClickListener(this.u);
        this.p.setSelector(tbPageContext.getPageActivity().getResources().getDrawable(R.drawable.transparent_bg));
        ec6 ec6Var = new ec6(tbPageContext);
        this.q = ec6Var;
        this.p.setAdapter((ListAdapter) ec6Var);
        this.k.setOnClickListener(this);
        if (this.b.getOrignalPage() instanceof BaseActivity) {
            this.r = ((BaseActivity) this.b.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.b.getOrignalPage() instanceof BaseFragmentActivity) {
            this.r = ((BaseFragmentActivity) this.b.getOrignalPage()).isSwipeBackEnabled();
        }
        this.o.setSwipeControlInterface(new a(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nl6
    /* renamed from: B */
    public void j(wua wuaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wuaVar) != null) || wuaVar == null) {
            return;
        }
        this.s = wuaVar;
        z();
        this.q.b(wuaVar.a);
        k(h(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final AlaLiveInfoCoreData C(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(threadData.getThreadAlaInfo());
            alaLiveInfoCoreData.userName = threadData.getAuthor().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }

    @Override // com.baidu.tieba.km6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.t = str;
        }
    }

    public final void y(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, threadData) != null) || threadData == null) {
            return;
        }
        CustomMessage customMessage = new CustomMessage(2921018);
        customMessage.setData(threadData);
        MessageManager.getInstance().sendMessage(customMessage);
        TiebaStatic.log(new StatisticItem("c12638"));
    }

    public void A(TbPageContext<?> tbPageContext, ThreadData threadData) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, tbPageContext, threadData) == null) && tbPageContext != null && threadData != null && threadData.getAuthor() != null && threadData.getThreadAlaInfo() != null) {
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
            wua wuaVar = this.s;
            if (wuaVar != null && !ListUtils.isEmpty(wuaVar.a)) {
                for (ThreadData threadData2 : this.s.a) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(C(threadData2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_INSERT_LIVE, str, z, null, null, this.t)));
        }
    }

    @Override // com.baidu.tieba.nl6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i) == null) && this.a != i) {
            SkinManager.setBackgroundResource(this.o, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0204);
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, view2) == null) && view2 == this.k) {
            TiebaStatic.log(new StatisticItem("c12637"));
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001627, 10001);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.b.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && !ListUtils.isEmpty(this.s.a)) {
            CustomMessage customMessage = new CustomMessage(2921017);
            customMessage.setData(this.s.a.get(0));
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }
}
