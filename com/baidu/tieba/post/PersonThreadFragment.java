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
import d.a.d.e.p.j;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.d.k.e.n;
import d.a.p0.j.b;
import d.a.p0.s.f0.f;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PersonThreadFragment extends BaseFragment implements PersonPostModel.d, b.a, PersonPostModel.c, BdListView.p, d.a.q0.q2.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f20493e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.q2.h f20494f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f20495g;

    /* renamed from: h  reason: collision with root package name */
    public View f20496h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.q2.n.a f20497i;
    public PersonPostModel j;
    public boolean k;
    public String l;
    public d.a.p0.s.f0.g m;
    public h n;
    public boolean o;
    public d.a.q0.q2.d p;
    public d.a.q0.q2.b q;
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
        public final /* synthetic */ PersonThreadFragment f20498a;

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
            this.f20498a = personThreadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || this.f20498a.f20497i == null) {
                return;
            }
            this.f20498a.f20497i.c((String) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonThreadFragment f20499a;

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
            this.f20499a = personThreadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            l.L(this.f20499a.getActivity(), R.string.thread_has_hide);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonThreadFragment f20500e;

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
            this.f20500e = personThreadFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20500e.Z0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonThreadFragment f20501e;

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
            this.f20501e = personThreadFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            CardPersonDynamicThreadData cardPersonDynamicThreadData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || i2 < 0 || this.f20501e.f20497i == null || i2 >= ListUtils.getCount(this.f20501e.j.threadList) || (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) this.f20501e.f20497i.f62370a.z(i2)) == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f20501e.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.f14589f), String.valueOf(cardPersonDynamicThreadData.f14590g), "person_page", 18005).setThreadData(cardPersonDynamicThreadData.r)));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonThreadFragment f20502e;

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
            this.f20502e = personThreadFragment;
        }

        @Override // d.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                PersonThreadFragment personThreadFragment = this.f20502e;
                if (personThreadFragment.j != null) {
                    personThreadFragment.r = true;
                    if (!j.A()) {
                        if (this.f20502e.f20494f != null) {
                            this.f20502e.f20494f.i(this.f20502e.getString(R.string.neterror), true);
                            return;
                        }
                        return;
                    }
                    this.f20502e.U0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonThreadFragment f20503a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f20504e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f20505f;

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
                this.f20505f = fVar;
                this.f20504e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f20505f.f20503a.getPageContext().getPageActivity() == null) {
                    return;
                }
                d.a.q0.h2.j.c.a(this.f20505f.f20503a.getPageContext(), this.f20504e).show();
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
            this.f20503a = personThreadFragment;
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
                d.a.d.e.m.e.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonThreadFragment f20506a;

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
            this.f20506a = personThreadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (j.z() && this.f20506a.t) {
                    this.f20506a.V0();
                    this.f20506a.n.f();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.c(this.f20506a.f20496h, BdListViewHelper.HeadType.DEFAULT, j.z());
                } else {
                    BdListViewHelper.c(this.f20506a.f20496h, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class h extends d.a.d.k.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public int f20507f;

        /* renamed from: g  reason: collision with root package name */
        public BaseFragmentActivity f20508g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f20509h;

        /* renamed from: i  reason: collision with root package name */
        public ProgressBar f20510i;
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
            this.f20507f = R.color.CAM_X0201;
            this.f20508g = null;
            this.f20509h = null;
            this.f20510i = null;
            this.j = null;
            this.k = null;
            this.m = 3;
            this.f20508g = baseFragmentActivity;
        }

        @Override // d.a.d.k.e.b
        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View inflate = LayoutInflater.from(this.f20508g.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                this.k = inflate;
                this.f20509h = (TextView) inflate.findViewById(R.id.pb_more_text);
                this.l = this.k.findViewById(R.id.pb_more_view);
                SkinManager.setBackgroundColor(this.k, this.f20507f);
                SkinManager.setBackgroundColor(this.l, this.f20507f);
                this.l.setVisibility(8);
                this.f20510i = (ProgressBar) this.k.findViewById(R.id.progress);
                h(TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setViewTextColor(this.f20509h, R.color.common_color_10039);
                this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(this.f20508g.getPageContext().getPageActivity(), R.dimen.ds120)));
                return this.k;
            }
            return (View) invokeV.objValue;
        }

        @Override // d.a.d.k.e.b
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
            SkinManager.setViewTextColor(this.f20509h, R.color.common_color_10039);
            SkinManager.setBackgroundColor(this.k, this.f20507f, i2);
            SkinManager.setBackgroundColor(this.l, this.f20507f, i2);
            this.m = i2;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f20510i.setVisibility(0);
                this.f20509h.setText(this.f20508g.getPageContext().getPageActivity().getText(R.string.loading));
                this.l.setVisibility(0);
            }
        }

        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
                ProgressBar progressBar = this.f20510i;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                if (this.f20509h != null) {
                    if (!z) {
                        this.l.setVisibility(0);
                        this.f20509h.setText(this.f20508g.getResources().getString(R.string.list_no_more));
                        return;
                    }
                    this.l.setVisibility(0);
                    this.f20509h.setText(this.f20508g.getResources().getString(R.string.load_more));
                }
            }
        }

        public void h(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                this.f20508g.getLayoutMode().j(this.l);
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
        this.f20493e = "common";
        this.o = false;
        this.r = true;
        this.s = true;
        this.t = false;
        this.w = new a(this, 2016557);
        this.x = new b(this, 2016558);
        this.y = new g(this, 2000994);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
    public void M(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, personPostModel, z) == null) {
            if (personPostModel != null && (personPostModel2 = this.j) != null) {
                if (z) {
                    personPostModel2.threadList.clear();
                }
                ArrayList<n> arrayList = personPostModel.threadList;
                if (personPostModel.view_card_num > 0 && this.s) {
                    ListUtils.add(arrayList, personPostModel.view_card_num - 1, new d.a.q0.m2.e.j());
                    this.s = false;
                }
                if (this.j.threadList.isEmpty()) {
                    n nVar = (n) ListUtils.getItem(arrayList, 0);
                    if (nVar instanceof CardPersonDynamicThreadData) {
                        ((CardPersonDynamicThreadData) nVar).G = true;
                    } else if (nVar instanceof d.a.q0.m2.e.j) {
                        ((d.a.q0.m2.e.j) nVar).f60879e = true;
                    }
                }
                this.j.threadList.addAll(arrayList);
                PersonPostModel.mergeDynamicThreadByTime(this.j.threadList);
            }
            d.a.q0.q2.b bVar = this.q;
            if (bVar != null) {
                bVar.showRecycleBinRedTip(personPostModel.isShowRecycleBinRedTip);
            }
            T(personPostModel, z);
            this.f20497i.d(this.j.threadList);
            this.f20497i.b();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.d
    public void T(PersonPostModel personPostModel, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, personPostModel, z) == null) {
            this.t = false;
            if (isAdded()) {
                this.f20494f.f62348c.A(0L);
                this.f20494f.f62348c.setEmptyView(null);
                if (personPostModel != null || this.r) {
                    if (personPostModel != null && (personPostModel.threadList.size() != 0 || !this.r || !StringUtils.isNull(personPostModel.getErrorString()))) {
                        if (personPostModel.threadList.size() == 0 && this.r) {
                            T0(true);
                        } else {
                            T0(false);
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
                    T0(true);
                }
            }
        }
    }

    public final void T0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            d.a.q0.q2.h hVar = this.f20494f;
            hVar.f62348c.removeHeaderView(hVar.f62349d);
            if (z) {
                this.f20494f.f62349d.setVisibility(0);
                d.a.q0.q2.h hVar2 = this.f20494f;
                hVar2.f62348c.addHeaderView(hVar2.f62349d);
                this.n.b().setVisibility(8);
                return;
            }
            this.n.b().setVisibility(0);
            this.n.d();
        }
    }

    public void U0() {
        PersonPostModel personPostModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (personPostModel = this.j) == null) {
            return;
        }
        personPostModel.fetchPost(getPageContext(), this, true, this.l, true, this.u, false, true, null);
        this.s = true;
    }

    public void V0() {
        PersonPostModel personPostModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (personPostModel = this.j) == null) {
            return;
        }
        personPostModel.fetchPost(getPageContext(), this, false, this.l, true, false, true, null);
    }

    public d.a.q0.q2.h W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20494f : (d.a.q0.q2.h) invokeV.objValue;
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d.a.p0.j.a.a(getBaseFragmentActivity()).e(true, true, true, this);
        }
    }

    public void Y0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.k) {
            return;
        }
        this.f20494f.f62348c.F();
        this.k = true;
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TiebaStatic.log(TbadkCoreStatisticKey.MYLIVE_TO_BE_ANCHOR);
            X0();
            d.a.p0.j.a.a(getBaseFragmentActivity()).g(1, this);
        }
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            X0();
            d.a.p0.j.a.a(getBaseFragmentActivity()).f(this);
        }
    }

    public void b1(d.a.q0.q2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.q = bVar;
        }
    }

    public void c1(d.a.q0.q2.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.p = dVar;
        }
    }

    @Override // d.a.q0.q2.c
    public void e0() {
        d.a.q0.q2.h hVar;
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (hVar = this.f20494f) == null || (bdTypeListView = hVar.f62348c) == null) {
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
                if (i2 == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.f20497i != null && (personPostModel = this.j) != null && ListUtils.getCount(personPostModel.threadList) > 0) {
                    int count = ListUtils.getCount(this.j.threadList);
                    boolean z = false;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= count) {
                            break;
                        }
                        n nVar = (n) ListUtils.getItem(this.j.threadList, i4);
                        if ((nVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) nVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.f14589f))) {
                            z = true;
                            break;
                        }
                        i4++;
                    }
                    if (z && intent.getIntExtra("type", -1) == 0) {
                        ListUtils.remove(this.j.threadList, i4);
                        this.f20497i.b();
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
                NoDataView noDataView = this.f20494f.f62349d;
                if (noDataView != null) {
                    noDataView.d(getPageContext());
                }
                d.a.p0.s.f0.g gVar = this.m;
                if (gVar != null) {
                    gVar.I(i2);
                }
                d.a.q0.q2.n.a aVar = this.f20497i;
                if (aVar != null) {
                    aVar.b();
                }
                h hVar = this.n;
                if (hVar != null) {
                    hVar.e(i2);
                }
                SkinManager.setBackgroundColor(this.f20494f.f62348c, R.color.CAM_X0201);
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
            this.f20495g = (FrameLayout) inflate.findViewById(R.id.root_view);
            d.a.q0.q2.h hVar = new d.a.q0.q2.h(getActivity(), inflate);
            this.f20494f = hVar;
            if (hVar.g() == null) {
                this.f20494f.h(this.p);
            }
            BdTypeListView bdTypeListView = this.f20494f.f62348c;
            if (bdTypeListView != null) {
                SkinManager.setBackgroundColor(bdTypeListView, R.color.CAM_X0201);
            }
            String string3 = getArguments().getString("thread_type_key");
            if (!k.isEmpty(string3)) {
                this.f20493e = string3;
            }
            NoDataViewFactory.b bVar = new NoDataViewFactory.b(getString(R.string.to_be_an_liver), new c(this));
            int dimension = (int) getResources().getDimension(R.dimen.ds102);
            String str2 = "";
            NoDataViewFactory.d b2 = NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, dimension);
            if (this.f20493e.equals(WriteActivity.PHOTO_LIVE_DRAFT_KEY)) {
                int k = d.a.p0.s.d0.b.j().k(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1);
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
                    a1();
                }
                String str3 = str;
                b2 = dVar;
                string = string2;
                str2 = str3;
            } else {
                string = getArguments().getString(PersonPostActivity.KEY_EMPTYVIEW_TXT);
                cVar = null;
            }
            this.f20494f.f62349d = NoDataViewFactory.a(getActivity(), null, b2, NoDataViewFactory.e.d(str2, string), cVar);
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
                d.a.p0.j.a.h();
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
            Y0();
            d.a.q0.q2.n.a aVar = this.f20497i;
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
                V0();
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
            NoDataView noDataView = this.f20494f.f62349d;
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
            NoDataView noDataView = this.f20494f.f62349d;
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
            if (this.f20493e.equals(WriteActivity.PHOTO_LIVE_DRAFT_KEY)) {
                this.u = 33;
            }
            this.f20497i = new d.a.q0.q2.n.a(getPageContext(), this.f20494f.f62348c);
            this.f20494f.f().setOnItemClickListener(new d(this));
            d.a.p0.s.f0.g gVar = new d.a.p0.s.f0.g(getPageContext());
            this.m = gVar;
            gVar.a(new e(this));
            this.f20494f.f62348c.setPullRefresh(this.m);
            if (TbadkCoreApplication.isMyLive) {
                View d2 = BdListViewHelper.d(getActivity(), this.f20494f.f62348c, BdListViewHelper.HeadType.DEFAULT);
                this.f20496h = d2;
                BdListViewHelper.c(d2, BdListViewHelper.HeadType.DEFAULT, j.z());
            } else {
                View d3 = BdListViewHelper.d(getActivity(), this.f20494f.f62348c, BdListViewHelper.HeadType.HASTAB);
                this.f20496h = d3;
                BdListViewHelper.c(d3, BdListViewHelper.HeadType.HASTAB, true);
            }
            this.f20494f.f62348c.setOnSrollToBottomListener(this);
            h hVar = new h(getBaseFragmentActivity());
            this.n = hVar;
            this.f20494f.f62348c.setNextPage(hVar);
        }
    }
}
