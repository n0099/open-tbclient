package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel;
import com.baidu.tieba.y45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class m66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public TbPageContext b;
    public p66 c;
    public AlaNewSquareSubListModel d;
    public boolean e;
    public String f;
    public BdListView.p g;
    public AlaNewSquareSubListModel.b h;
    public View.OnClickListener i;
    public s66 j;
    public y45.g k;

    /* loaded from: classes5.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m66 a;

        public a(m66 m66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m66Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.d != null) {
                    z = this.a.d.j0();
                } else {
                    z = false;
                }
                if (this.a.c != null) {
                    if (!z) {
                        this.a.c.v();
                        return;
                    }
                    this.a.d.l0();
                    this.a.c.i();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AlaNewSquareSubListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m66 a;

        public b(m66 m66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m66Var;
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) && this.a.b != null && this.a.c != null) {
                this.a.c.d();
                this.a.c.g();
                p66 p66Var = this.a.c;
                if (TextUtils.isEmpty(str)) {
                    str = this.a.b.getString(R.string.no_data_text);
                }
                p66Var.u(str, this.a.i, true);
                this.a.c.o(8);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && this.a.b != null && this.a.c != null) {
                this.a.c.d();
                this.a.c.g();
                this.a.c.p(this.a.d.e0());
                this.a.c.l(this.a.d.f0());
                this.a.c.m(this.a.d.i0());
                if (this.a.d != null && this.a.d.getPn() == 0 && this.a.c.e() != null) {
                    this.a.c.e().smoothScrollToPosition(0);
                }
                if (ListUtils.getCount(this.a.d.e0()) == 0) {
                    this.a.c.u(this.a.b.getString(R.string.no_data_text), this.a.i, true);
                    this.a.c.o(8);
                    return;
                }
                this.a.c.h();
                this.a.c.o(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m66 a;

        public c(m66 m66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m66Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements s66 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m66 a;

        public d(m66 m66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m66Var;
        }

        @Override // com.baidu.tieba.s66
        public void a(int i, String str, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, threadData) == null) {
                m66 m66Var = this.a;
                m66Var.g(m66Var.b, threadData, str);
            }
        }

        @Override // com.baidu.tieba.s66
        public void b(l66 l66Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l66Var) == null) && this.a.d != null && l66Var != null && !StringUtils.isNull(l66Var.a)) {
                this.a.d.setSortType(l66Var.a);
                this.a.d.setLat(l66Var.b);
                this.a.d.setLng(l66Var.c);
                this.a.d.p0(l66Var.d);
                this.a.d.m0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements y45.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m66 a;

        public e(m66 m66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m66Var;
        }

        @Override // com.baidu.tieba.y45.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.d != null) {
                this.a.d.m0();
            }
        }
    }

    public m66(TbPageContext tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = false;
        this.g = new a(this);
        this.h = new b(this);
        this.i = new c(this);
        this.j = new d(this);
        this.k = new e(this);
        this.b = tbPageContext;
        this.a = z;
        AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(this.b);
        this.d = alaNewSquareSubListModel;
        alaNewSquareSubListModel.n0(this.h);
        p66 p66Var = new p66(this.b);
        this.c = p66Var;
        p66Var.n(this.j);
        this.c.q(this.k);
        this.c.r(this.g);
        this.c.t();
    }

    public final AlaLiveInfoCoreData j(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, threadData)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(threadData.getThreadAlaInfo());
            alaLiveInfoCoreData.userName = threadData.getAuthor().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.f();
        }
        return (View) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            AlaNewSquareSubListModel alaNewSquareSubListModel = this.d;
            if (alaNewSquareSubListModel != null) {
                alaNewSquareSubListModel.onDestroy();
                this.d = null;
            }
            p66 p66Var = this.c;
            if (p66Var != null) {
                p66Var.k();
                this.c = null;
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.d.m0();
        }
    }

    public final void g(TbPageContext<?> tbPageContext, ThreadData threadData, String str) {
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, threadData, str) == null) && tbPageContext != null && threadData != null && threadData.getAuthor() != null && threadData.getThreadAlaInfo() != null) {
            StatisticItem param = new StatisticItem("c12116").param("obj_id", threadData.getThreadAlaInfo().live_id);
            if (!StringUtils.isNull(this.f)) {
                param.param("locate_type", this.f);
            }
            TiebaStatic.log(param);
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = threadData.getAuthor().getUserId();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, currentAccount);
                str2 = currentAccount;
            } else {
                str2 = "";
                z = false;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(threadData.getThreadAlaInfo());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (ThreadData threadData2 : this.d.g0()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(j(threadData2));
            }
            Activity pageActivity = tbPageContext.getPageActivity();
            if (!"颜值".equals(str)) {
                str = null;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_CATOGORY, str2, z, str, null)));
        }
    }

    public void h(TbPageContext tbPageContext, int i) {
        p66 p66Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) && (p66Var = this.c) != null) {
            p66Var.j(tbPageContext, i);
        }
    }

    public void l(String str, String str2, String str3, List<String> list) {
        String str4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, list) == null) && !StringUtils.isNull(str2)) {
            if (!StringUtils.isNull(str)) {
                this.e = str.equals("16:9");
            }
            this.c.s(this.a, list, str2, str3, this.e, false);
            this.d.setEntryName(str2);
            this.d.setLabelName(str3);
            AlaNewSquareSubListModel alaNewSquareSubListModel = this.d;
            if (ListUtils.isEmpty(list)) {
                str4 = "";
            } else {
                str4 = list.get(0);
            }
            alaNewSquareSubListModel.setSortType(str4);
            this.d.o0(this.e);
            this.f = str2;
        }
    }
}
