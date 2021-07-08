package com.baidu.tieba.post;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.o0.i.b;
import d.a.o0.r.f0.f;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PersonThreadFragment extends BaseFragment implements PersonPostModel.d, b.a, PersonPostModel.c, BdListView.p, d.a.p0.q2.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f20375e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.p0.q2.h f20376f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f20377g;

    /* renamed from: h  reason: collision with root package name */
    public View f20378h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.p0.q2.n.a f20379i;
    public PersonPostModel j;
    public boolean k;
    public String l;
    public d.a.o0.r.f0.g m;
    public h n;
    public boolean o;
    public d.a.p0.q2.d p;
    public d.a.p0.q2.b q;
    public boolean r;
    public boolean s;
    public boolean t;
    public int u;
    public ShareSuccessReplyToServerModel v;
    public CustomMessageListener w;
    public CustomMessageListener x;
    public final CustomMessageListener y;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonThreadFragment f20380a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonThreadFragment personThreadFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personThreadFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20380a = personThreadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || this.f20380a.f20379i == null) {
                return;
            }
            this.f20380a.f20379i.c((String) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonThreadFragment f20381a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PersonThreadFragment personThreadFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personThreadFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20381a = personThreadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            l.L(this.f20381a.getActivity(), R.string.thread_has_hide);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonThreadFragment f20382e;

        public c(PersonThreadFragment personThreadFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personThreadFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20382e = personThreadFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20382e.U0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonThreadFragment f20383e;

        public d(PersonThreadFragment personThreadFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personThreadFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20383e = personThreadFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            CardPersonDynamicThreadData cardPersonDynamicThreadData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || i2 < 0 || this.f20383e.f20379i == null || i2 >= ListUtils.getCount(this.f20383e.j.threadList) || (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) this.f20383e.f20379i.f61756a.z(i2)) == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f20383e.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.f14541f), String.valueOf(cardPersonDynamicThreadData.f14542g), "person_page", 18005).setThreadData(cardPersonDynamicThreadData.r)));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonThreadFragment f20384e;

        public e(PersonThreadFragment personThreadFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personThreadFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20384e = personThreadFragment;
        }

        @Override // d.a.o0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                PersonThreadFragment personThreadFragment = this.f20384e;
                if (personThreadFragment.j != null) {
                    personThreadFragment.r = true;
                    if (!j.A()) {
                        if (this.f20384e.f20376f != null) {
                            this.f20384e.f20376f.i(this.f20384e.getString(R.string.neterror), true);
                            return;
                        }
                        return;
                    }
                    this.f20384e.P0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonThreadFragment f20385a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f20386e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f20387f;

            public a(f fVar, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f20387f = fVar;
                this.f20386e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f20387f.f20385a.getPageContext().getPageActivity() == null) {
                    return;
                }
                d.a.p0.h2.j.c.a(this.f20387f.f20385a.getPageContext(), this.f20386e).show();
            }
        }

        public f(PersonThreadFragment personThreadFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personThreadFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20385a = personThreadFragment;
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                d.a.c.e.m.e.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonThreadFragment f20388a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(PersonThreadFragment personThreadFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personThreadFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20388a = personThreadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (j.z() && this.f20388a.t) {
                    this.f20388a.Q0();
                    this.f20388a.n.f();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.c(this.f20388a.f20378h, BdListViewHelper.HeadType.DEFAULT, j.z());
                } else {
                    BdListViewHelper.c(this.f20388a.f20378h, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class h extends d.a.c.k.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public int f20389f;

        /* renamed from: g  reason: collision with root package name */
        public BaseFragmentActivity f20390g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f20391h;

        /* renamed from: i  reason: collision with root package name */
        public ProgressBar f20392i;
        public View.OnClickListener j;
        public View k;
        public View l;
        public int m;

        public h(BaseFragmentActivity baseFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20389f = R.color.CAM_X0201;
            this.f20390g = null;
            this.f20391h = null;
            this.f20392i = null;
            this.j = null;
            this.k = null;
            this.m = 3;
            this.f20390g = baseFragmentActivity;
        }

        @Override // d.a.c.k.e.b
        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View inflate = LayoutInflater.from(this.f20390g.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                this.k = inflate;
                this.f20391h = (TextView) inflate.findViewById(R.id.pb_more_text);
                this.l = this.k.findViewById(R.id.pb_more_view);
                SkinManager.setBackgroundColor(this.k, this.f20389f);
                SkinManager.setBackgroundColor(this.l, this.f20389f);
                this.l.setVisibility(8);
                this.f20392i = (ProgressBar) this.k.findViewById(R.id.progress);
                h(TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setViewTextColor(this.f20391h, R.color.common_color_10039);
                this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(this.f20390g.getPageContext().getPageActivity(), R.dimen.ds120)));
                return this.k;
            }
            return (View) invokeV.objValue;
        }

        @Override // d.a.c.k.e.b
        public void c() {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (onClickListener = this.j) == null) {
                return;
            }
            onClickListener.onClick(this.k);
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
            }
        }

        @SuppressLint({"ResourceAsColor"})
        public void e(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.m == i2) {
                return;
            }
            SkinManager.setViewTextColor(this.f20391h, R.color.common_color_10039);
            SkinManager.setBackgroundColor(this.k, this.f20389f, i2);
            SkinManager.setBackgroundColor(this.l, this.f20389f, i2);
            this.m = i2;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f20392i.setVisibility(0);
                this.f20391h.setText(this.f20390g.getPageContext().getPageActivity().getText(R.string.loading));
                this.l.setVisibility(0);
            }
        }

        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
                ProgressBar progressBar = this.f20392i;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                if (this.f20391h != null) {
                    if (!z) {
                        this.l.setVisibility(0);
                        this.f20391h.setText(this.f20390g.getResources().getString(R.string.list_no_more));
                        return;
                    }
                    this.l.setVisibility(0);
                    this.f20391h.setText(this.f20390g.getResources().getString(R.string.load_more));
                }
            }
        }

        public void h(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                this.f20390g.getLayoutMode().j(this.l);
            }
        }
    }

    public PersonThreadFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20375e = "common";
        this.o = false;
        this.r = true;
        this.s = true;
        this.t = false;
        this.w = new a(this, 2016557);
        this.x = new b(this, 2016558);
        this.y = new g(this, 2000994);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
    public void L(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, personPostModel, z) == null) {
            if (personPostModel != null && (personPostModel2 = this.j) != null) {
                if (z) {
                    personPostModel2.threadList.clear();
                }
                ArrayList<n> arrayList = personPostModel.threadList;
                if (personPostModel.view_card_num > 0 && this.s) {
                    ListUtils.add(arrayList, personPostModel.view_card_num - 1, new d.a.p0.m2.e.j());
                    this.s = false;
                }
                if (this.j.threadList.isEmpty()) {
                    n nVar = (n) ListUtils.getItem(arrayList, 0);
                    if (nVar instanceof CardPersonDynamicThreadData) {
                        ((CardPersonDynamicThreadData) nVar).G = true;
                    } else if (nVar instanceof d.a.p0.m2.e.j) {
                        ((d.a.p0.m2.e.j) nVar).f60265e = true;
                    }
                }
                this.j.threadList.addAll(arrayList);
                PersonPostModel.mergeDynamicThreadByTime(this.j.threadList);
            }
            d.a.p0.q2.b bVar = this.q;
            if (bVar != null) {
                bVar.showRecycleBinRedTip(personPostModel.isShowRecycleBinRedTip);
            }
            S(personPostModel, z);
            this.f20379i.d(this.j.threadList);
            this.f20379i.b();
        }
    }

    public final void O0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            d.a.p0.q2.h hVar = this.f20376f;
            hVar.f61734c.removeHeaderView(hVar.f61735d);
            if (z) {
                this.f20376f.f61735d.setVisibility(0);
                d.a.p0.q2.h hVar2 = this.f20376f;
                hVar2.f61734c.addHeaderView(hVar2.f61735d);
                this.n.b().setVisibility(8);
                return;
            }
            this.n.b().setVisibility(0);
            this.n.d();
        }
    }

    public void P0() {
        PersonPostModel personPostModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (personPostModel = this.j) == null) {
            return;
        }
        personPostModel.fetchPost(getPageContext(), this, true, this.l, true, this.u, false, true, null);
        this.s = true;
    }

    public void Q0() {
        PersonPostModel personPostModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (personPostModel = this.j) == null) {
            return;
        }
        personPostModel.fetchPost(getPageContext(), this, false, this.l, true, false, true, null);
    }

    public d.a.p0.q2.h R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f20376f : (d.a.p0.q2.h) invokeV.objValue;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.d
    public void S(PersonPostModel personPostModel, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, personPostModel, z) == null) {
            this.t = false;
            if (isAdded()) {
                this.f20376f.f61734c.A(0L);
                this.f20376f.f61734c.setEmptyView(null);
                if (personPostModel != null || this.r) {
                    if (personPostModel != null && (personPostModel.threadList.size() != 0 || !this.r || !StringUtils.isNull(personPostModel.getErrorString()))) {
                        if (personPostModel.threadList.size() == 0 && this.r) {
                            O0(true);
                        } else {
                            O0(false);
                        }
                        if (personPostModel.getErrorCode() != 0) {
                            l.M(getActivity(), personPostModel.getErrorString());
                        }
                        this.o = !ListUtils.isEmpty(personPostModel.threadList);
                        if (z) {
                            if (personPostModel.threadList.size() < 20) {
                                this.o = false;
                            } else {
                                this.o = true;
                            }
                            this.r = false;
                        }
                        this.n.g(this.o);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
                        return;
                    }
                    O0(true);
                }
            }
        }
    }

    public final void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d.a.o0.i.a.a(getBaseFragmentActivity()).e(true, true, true, this);
        }
    }

    public void T0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.k) {
            return;
        }
        this.f20376f.f61734c.F();
        this.k = true;
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TiebaStatic.log(TbadkCoreStatisticKey.MYLIVE_TO_BE_ANCHOR);
            S0();
            d.a.o0.i.a.a(getBaseFragmentActivity()).g(1, this);
        }
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            S0();
            d.a.o0.i.a.a(getBaseFragmentActivity()).f(this);
        }
    }

    public void W0(d.a.p0.q2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.q = bVar;
        }
    }

    public void X0(d.a.p0.q2.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.p = dVar;
        }
    }

    @Override // d.a.p0.q2.c
    public void b0() {
        d.a.p0.q2.h hVar;
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (hVar = this.f20376f) == null || (bdTypeListView = hVar.f61734c) == null) {
            return;
        }
        bdTypeListView.F();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onActivityCreated(bundle);
            registerListener(this.w);
            registerListener(this.x);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        ShareItem shareItem;
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        String stringExtra;
        PersonPostModel personPostModel;
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048590, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (i2 == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.f20379i != null && (personPostModel = this.j) != null && ListUtils.getCount(personPostModel.threadList) > 0) {
                    int count = ListUtils.getCount(this.j.threadList);
                    boolean z = false;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= count) {
                            break;
                        }
                        n nVar = (n) ListUtils.getItem(this.j.threadList, i4);
                        if ((nVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) nVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.f14541f))) {
                            z = true;
                            break;
                        }
                        i4++;
                    }
                    if (z && intent.getIntExtra("type", -1) == 0) {
                        ListUtils.remove(this.j.threadList, i4);
                        this.f20379i.b();
                    }
                }
                if (i2 == 24007) {
                    int intExtra = intent.getIntExtra("extra_share_status", 2);
                    int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                    if (intExtra != 1 || (shareItem = TbadkCoreApplication.getInst().getShareItem()) == null || (str = shareItem.t) == null || (shareSuccessReplyToServerModel = this.v) == null) {
                        return;
                    }
                    shareSuccessReplyToServerModel.w(str, intExtra2, new f(this));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (isAdded()) {
                NoDataView noDataView = this.f20376f.f61735d;
                if (noDataView != null) {
                    noDataView.d(getPageContext());
                }
                d.a.o0.r.f0.g gVar = this.m;
                if (gVar != null) {
                    gVar.I(i2);
                }
                d.a.p0.q2.n.a aVar = this.f20379i;
                if (aVar != null) {
                    aVar.b();
                }
                h hVar = this.n;
                if (hVar != null) {
                    hVar.e(i2);
                }
                SkinManager.setBackgroundColor(this.f20376f.f61734c, R.color.CAM_X0201);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.y);
            PersonPostModel personPostModel = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
            this.j = personPostModel;
            personPostModel.setUniqueId(getUniqueId());
            this.v = new ShareSuccessReplyToServerModel();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        String string;
        NoDataViewFactory.c cVar;
        NoDataViewFactory.d dVar;
        String str;
        String string2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
            this.f20377g = (FrameLayout) inflate.findViewById(R.id.root_view);
            d.a.p0.q2.h hVar = new d.a.p0.q2.h(getActivity(), inflate);
            this.f20376f = hVar;
            if (hVar.g() == null) {
                this.f20376f.h(this.p);
            }
            BdTypeListView bdTypeListView = this.f20376f.f61734c;
            if (bdTypeListView != null) {
                SkinManager.setBackgroundColor(bdTypeListView, R.color.CAM_X0201);
            }
            String string3 = getArguments().getString("thread_type_key");
            if (!k.isEmpty(string3)) {
                this.f20375e = string3;
            }
            NoDataViewFactory.b bVar = new NoDataViewFactory.b(getString(R.string.to_be_an_liver), new c(this));
            int dimension = (int) getResources().getDimension(R.dimen.ds102);
            String str2 = "";
            NoDataViewFactory.d b2 = NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, dimension);
            if (this.f20375e.equals(WriteActivity.PHOTO_LIVE_DRAFT_KEY)) {
                int k = d.a.o0.r.d0.b.j().k(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1);
                if (k == 0) {
                    string2 = getPageContext().getResources().getString(R.string.to_live_to_god);
                    str = getPageContext().getResources().getString(R.string.user_not_liver);
                    dVar = NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_06, dimension, -1, -1);
                    cVar = NoDataViewFactory.c.a(bVar);
                } else {
                    dVar = b2;
                    str = "";
                    string2 = getPageContext().getResources().getString(R.string.person_post_lv_empty_host);
                    cVar = null;
                }
                if (k < 0) {
                    V0();
                }
                String str3 = str;
                b2 = dVar;
                string = string2;
                str2 = str3;
            } else {
                string = getArguments().getString(PersonPostActivity.KEY_EMPTYVIEW_TXT);
                cVar = null;
            }
            this.f20376f.f61735d = NoDataViewFactory.a(getActivity(), null, b2, NoDataViewFactory.e.d(str2, string), cVar);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            PersonPostModel personPostModel = this.j;
            if (personPostModel != null) {
                personPostModel.cancelLoadData();
            }
            try {
                d.a.o0.i.a.h();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            BdAsyncTask.removeAllTask(SetPrivacyModel.UNIQUE_ID_SET_PRIVACY_TASK);
            BdAsyncTask.removeAllTask(ForumManageModel.UNIQUE_ID_DEL_POST_TASK);
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onResume();
            T0();
            d.a.p0.q2.n.a aVar = this.f20379i;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.o) {
                Q0();
                this.n.f();
                this.t = true;
                return;
            }
            this.n.g(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onStart();
            NoDataView noDataView = this.f20376f.f61735d;
            if (noDataView != null) {
                noDataView.d(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onStop();
            NoDataView noDataView = this.f20376f.f61735d;
            if (noDataView != null) {
                noDataView.e();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, view, bundle) == null) {
            this.l = getArguments().getString("key_uid");
            if (this.f20375e.equals(WriteActivity.PHOTO_LIVE_DRAFT_KEY)) {
                this.u = 33;
            }
            this.f20379i = new d.a.p0.q2.n.a(getPageContext(), this.f20376f.f61734c);
            this.f20376f.f().setOnItemClickListener(new d(this));
            d.a.o0.r.f0.g gVar = new d.a.o0.r.f0.g(getPageContext());
            this.m = gVar;
            gVar.a(new e(this));
            this.f20376f.f61734c.setPullRefresh(this.m);
            if (TbadkCoreApplication.isMyLive) {
                View d2 = BdListViewHelper.d(getActivity(), this.f20376f.f61734c, BdListViewHelper.HeadType.DEFAULT);
                this.f20378h = d2;
                BdListViewHelper.c(d2, BdListViewHelper.HeadType.DEFAULT, j.z());
            } else {
                View d3 = BdListViewHelper.d(getActivity(), this.f20376f.f61734c, BdListViewHelper.HeadType.HASTAB);
                this.f20378h = d3;
                BdListViewHelper.c(d3, BdListViewHelper.HeadType.HASTAB, true);
            }
            this.f20376f.f61734c.setOnSrollToBottomListener(this);
            h hVar = new h(getBaseFragmentActivity());
            this.n = hVar;
            this.f20376f.f61734c.setNextPage(hVar);
        }
    }
}
