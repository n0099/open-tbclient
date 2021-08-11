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
import c.a.e.e.p.j;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.e.k.e.n;
import c.a.o0.j.b;
import c.a.o0.s.f0.f;
import c.a.o0.s.q.n0;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class PersonThreadFragment extends BaseFragment implements PersonPostModel.d, b.a, PersonPostModel.c, BdListView.p, c.a.p0.r2.c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String THREAD_TYPE_COMMON = "common";
    public static final String THREAD_TYPE_KEY = "thread_type_key";
    public static final String THREAD_TYPE_PHOTO = "photolive";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f55875e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.r2.h f55876f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f55877g;

    /* renamed from: h  reason: collision with root package name */
    public View f55878h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.r2.n.a f55879i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f55880j;
    public String k;
    public c.a.o0.s.f0.g l;
    public i m;
    public PersonPostModel mModel;
    public boolean n;
    public c.a.p0.r2.d o;
    public c.a.p0.r2.b p;
    public boolean q;
    public boolean r;
    public boolean s;
    public int t;
    public ShareSuccessReplyToServerModel u;
    public CustomMessageListener v;
    public CustomMessageListener w;
    public final CustomMessageListener x;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonThreadFragment f55881a;

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
            this.f55881a = personThreadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || this.f55881a.f55879i == null) {
                return;
            }
            this.f55881a.f55879i.c((String) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonThreadFragment f55882a;

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
            this.f55882a = personThreadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            l.L(this.f55882a.getActivity(), R.string.thread_has_hide);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonThreadFragment f55883e;

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
            this.f55883e = personThreadFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55883e.k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonThreadFragment f55884e;

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
            this.f55884e = personThreadFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            CardPersonDynamicThreadData cardPersonDynamicThreadData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || i2 < 0 || this.f55884e.f55879i == null || i2 >= ListUtils.getCount(this.f55884e.mModel.threadList) || (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) this.f55884e.f55879i.f23844a.z(i2)) == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f55884e.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.f49767f), String.valueOf(cardPersonDynamicThreadData.f49768g), "person_page", 18005).setThreadData(cardPersonDynamicThreadData.r)));
        }
    }

    /* loaded from: classes7.dex */
    public class e implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonThreadFragment f55885e;

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
            this.f55885e = personThreadFragment;
        }

        @Override // c.a.o0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                PersonThreadFragment personThreadFragment = this.f55885e;
                if (personThreadFragment.mModel != null) {
                    personThreadFragment.q = true;
                    if (!j.A()) {
                        if (this.f55885e.f55876f != null) {
                            this.f55885e.f55876f.i(this.f55885e.getString(R.string.neterror), true);
                            return;
                        }
                        return;
                    }
                    this.f55885e.fetchDataWithReset();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonThreadFragment f55886a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f55887e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f55888f;

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
                this.f55888f = fVar;
                this.f55887e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f55888f.f55886a.getPageContext().getPageActivity() == null) {
                    return;
                }
                c.a.p0.i2.j.c.a(this.f55888f.f55886a.getPageContext(), this.f55887e).show();
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
            this.f55886a = personThreadFragment;
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
                c.a.e.e.m.e.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonThreadFragment f55889a;

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
            this.f55889a = personThreadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (j.z() && this.f55889a.s) {
                    this.f55889a.fetchDataWithoutReset();
                    this.f55889a.m.f();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.c(this.f55889a.f55878h, BdListViewHelper.HeadType.DEFAULT, j.z());
                } else {
                    BdListViewHelper.c(this.f55889a.f55878h, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonThreadFragment f55890e;

        public h(PersonThreadFragment personThreadFragment) {
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
            this.f55890e = personThreadFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55890e.k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class i extends c.a.e.k.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public int f55891f;

        /* renamed from: g  reason: collision with root package name */
        public BaseFragmentActivity f55892g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f55893h;

        /* renamed from: i  reason: collision with root package name */
        public ProgressBar f55894i;

        /* renamed from: j  reason: collision with root package name */
        public View.OnClickListener f55895j;
        public View k;
        public View l;
        public int m;

        public i(BaseFragmentActivity baseFragmentActivity) {
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
            this.f55891f = R.color.CAM_X0201;
            this.f55892g = null;
            this.f55893h = null;
            this.f55894i = null;
            this.f55895j = null;
            this.k = null;
            this.m = 3;
            this.f55892g = baseFragmentActivity;
        }

        @Override // c.a.e.k.e.b
        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View inflate = LayoutInflater.from(this.f55892g.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                this.k = inflate;
                this.f55893h = (TextView) inflate.findViewById(R.id.pb_more_text);
                this.l = this.k.findViewById(R.id.pb_more_view);
                SkinManager.setBackgroundColor(this.k, this.f55891f);
                SkinManager.setBackgroundColor(this.l, this.f55891f);
                this.l.setVisibility(8);
                this.f55894i = (ProgressBar) this.k.findViewById(R.id.progress);
                h(TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setViewTextColor(this.f55893h, R.color.common_color_10039);
                this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(this.f55892g.getPageContext().getPageActivity(), R.dimen.ds120)));
                return this.k;
            }
            return (View) invokeV.objValue;
        }

        @Override // c.a.e.k.e.b
        public void c() {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (onClickListener = this.f55895j) == null) {
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
            SkinManager.setViewTextColor(this.f55893h, R.color.common_color_10039);
            SkinManager.setBackgroundColor(this.k, this.f55891f, i2);
            SkinManager.setBackgroundColor(this.l, this.f55891f, i2);
            this.m = i2;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f55894i.setVisibility(0);
                this.f55893h.setText(this.f55892g.getPageContext().getPageActivity().getText(R.string.loading));
                this.l.setVisibility(0);
            }
        }

        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
                ProgressBar progressBar = this.f55894i;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                if (this.f55893h != null) {
                    if (!z) {
                        this.l.setVisibility(0);
                        this.f55893h.setText(this.f55892g.getResources().getString(R.string.list_no_more));
                        return;
                    }
                    this.l.setVisibility(0);
                    this.f55893h.setText(this.f55892g.getResources().getString(R.string.load_more));
                }
            }
        }

        public void h(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                this.f55892g.getLayoutMode().j(this.l);
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
        this.f55875e = "common";
        this.n = false;
        this.q = true;
        this.r = true;
        this.s = false;
        this.v = new a(this, 2016557);
        this.w = new b(this, 2016558);
        this.x = new g(this, 2000994);
    }

    public void callBackResults(boolean z, int i2, int i3, n0 n0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), n0Var}) == null) {
            h(z, i2);
        }
    }

    @Override // c.a.p0.r2.c
    public void fetchDataOnNoNetRefresh() {
        c.a.p0.r2.h hVar;
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (hVar = this.f55876f) == null || (bdTypeListView = hVar.f23822c) == null) {
            return;
        }
        bdTypeListView.startPullRefresh();
    }

    public void fetchDataWithReset() {
        PersonPostModel personPostModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (personPostModel = this.mModel) == null) {
            return;
        }
        personPostModel.fetchPost(getPageContext(), this, true, this.k, true, this.t, false, true, null);
        this.r = true;
    }

    public void fetchDataWithoutReset() {
        PersonPostModel personPostModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (personPostModel = this.mModel) == null) {
            return;
        }
        personPostModel.fetchPost(getPageContext(), this, false, this.k, true, false, true, null);
    }

    public c.a.p0.r2.h getPersonThreadView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f55876f : (c.a.p0.r2.h) invokeV.objValue;
    }

    public final void h(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (i2 > 0) {
                if (this.f55875e.equals("photolive")) {
                    NoDataViewFactory.d b2 = NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds320));
                    String string = getPageContext().getResources().getString(R.string.person_post_lv_empty_host);
                    this.f55876f.f23823d.setImgOption(b2);
                    this.f55876f.f23823d.setTextOption(NoDataViewFactory.e.c(string));
                    this.f55876f.f23823d.setButtonOption(null);
                    NoDataView noDataView = this.f55876f.f23823d;
                    if (noDataView != null) {
                        noDataView.onActivityStart(getPageContext());
                    }
                }
            } else if (this.f55875e.equals("photolive")) {
                NoDataViewFactory.d c2 = NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_06, (int) getResources().getDimension(R.dimen.ds80), -1, -1);
                NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(getString(R.string.to_be_an_liver), new h(this)));
                NoDataViewFactory.e d2 = NoDataViewFactory.e.d(getPageContext().getResources().getString(R.string.user_not_liver), getPageContext().getResources().getString(R.string.to_live_to_god));
                this.f55876f.f23823d.setImgOption(c2);
                this.f55876f.f23823d.setTextOption(d2);
                this.f55876f.f23823d.setButtonOption(a2);
                NoDataView noDataView2 = this.f55876f.f23823d;
                if (noDataView2 != null) {
                    noDataView2.onActivityStart(getPageContext());
                }
            }
        }
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            c.a.p0.r2.h hVar = this.f55876f;
            hVar.f23822c.removeHeaderView(hVar.f23823d);
            if (z) {
                this.f55876f.f23823d.setVisibility(0);
                c.a.p0.r2.h hVar2 = this.f55876f;
                hVar2.f23822c.addHeaderView(hVar2.f23823d);
                this.m.b().setVisibility(8);
                return;
            }
            this.m.b().setVisibility(0);
            this.m.d();
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.o0.j.a.a(getBaseFragmentActivity()).e(true, true, true, this);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TiebaStatic.log(TbadkCoreStatisticKey.MYLIVE_TO_BE_ANCHOR);
            j();
            c.a.o0.j.a.a(getBaseFragmentActivity()).g(1, this);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            j();
            c.a.o0.j.a.a(getBaseFragmentActivity()).f(this);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.d
    public void on(PersonPostModel personPostModel, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, personPostModel, z) == null) {
            this.s = false;
            if (isAdded()) {
                this.f55876f.f23822c.completePullRefreshPostDelayed(0L);
                this.f55876f.f23822c.setEmptyView(null);
                if (personPostModel != null || this.q) {
                    if (personPostModel != null && (personPostModel.threadList.size() != 0 || !this.q || !StringUtils.isNull(personPostModel.getErrorString()))) {
                        if (personPostModel.threadList.size() == 0 && this.q) {
                            i(true);
                        } else {
                            i(false);
                        }
                        if (personPostModel.getErrorCode() != 0) {
                            l.M(getActivity(), personPostModel.getErrorString());
                        }
                        this.n = !ListUtils.isEmpty(personPostModel.threadList);
                        if (z) {
                            if (personPostModel.threadList.size() < 20) {
                                this.n = false;
                            } else {
                                this.n = true;
                            }
                            this.q = false;
                        }
                        this.m.g(this.n);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
                        return;
                    }
                    i(true);
                }
            }
        }
    }

    public void onActive() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f55880j) {
            return;
        }
        this.f55876f.f23822c.startPullRefresh();
        this.f55880j = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onActivityCreated(bundle);
            registerListener(this.v);
            registerListener(this.w);
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
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (i2 == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.f55879i != null && (personPostModel = this.mModel) != null && ListUtils.getCount(personPostModel.threadList) > 0) {
                    int count = ListUtils.getCount(this.mModel.threadList);
                    boolean z = false;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= count) {
                            break;
                        }
                        n nVar = (n) ListUtils.getItem(this.mModel.threadList, i4);
                        if ((nVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) nVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.f49767f))) {
                            z = true;
                            break;
                        }
                        i4++;
                    }
                    if (z && intent.getIntExtra("type", -1) == 0) {
                        ListUtils.remove(this.mModel.threadList, i4);
                        this.f55879i.b();
                    }
                }
                if (i2 == 24007) {
                    int intExtra = intent.getIntExtra("extra_share_status", 2);
                    int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                    if (intExtra != 1 || (shareItem = TbadkCoreApplication.getInst().getShareItem()) == null || (str = shareItem.t) == null || (shareSuccessReplyToServerModel = this.u) == null) {
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
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (isAdded()) {
                NoDataView noDataView = this.f55876f.f23823d;
                if (noDataView != null) {
                    noDataView.onActivityStart(getPageContext());
                }
                c.a.o0.s.f0.g gVar = this.l;
                if (gVar != null) {
                    gVar.D(i2);
                }
                c.a.p0.r2.n.a aVar = this.f55879i;
                if (aVar != null) {
                    aVar.b();
                }
                i iVar = this.m;
                if (iVar != null) {
                    iVar.e(i2);
                }
                SkinManager.setBackgroundColor(this.f55876f.f23822c, R.color.CAM_X0201);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.x);
            PersonPostModel personPostModel = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
            this.mModel = personPostModel;
            personPostModel.setUniqueId(getUniqueId());
            this.u = new ShareSuccessReplyToServerModel();
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
            this.f55877g = (FrameLayout) inflate.findViewById(R.id.root_view);
            c.a.p0.r2.h hVar = new c.a.p0.r2.h(getActivity(), inflate);
            this.f55876f = hVar;
            if (hVar.g() == null) {
                this.f55876f.h(this.o);
            }
            BdTypeListView bdTypeListView = this.f55876f.f23822c;
            if (bdTypeListView != null) {
                SkinManager.setBackgroundColor(bdTypeListView, R.color.CAM_X0201);
            }
            String string3 = getArguments().getString(THREAD_TYPE_KEY);
            if (!k.isEmpty(string3)) {
                this.f55875e = string3;
            }
            NoDataViewFactory.b bVar = new NoDataViewFactory.b(getString(R.string.to_be_an_liver), new c(this));
            int dimension = (int) getResources().getDimension(R.dimen.ds102);
            String str2 = "";
            NoDataViewFactory.d b2 = NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, dimension);
            if (this.f55875e.equals("photolive")) {
                int k = c.a.o0.s.d0.b.j().k(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1);
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
                    l();
                }
                String str3 = str;
                b2 = dVar;
                string = string2;
                str2 = str3;
            } else {
                string = getArguments().getString(PersonPostActivity.KEY_EMPTYVIEW_TXT);
                cVar = null;
            }
            this.f55876f.f23823d = NoDataViewFactory.a(getActivity(), null, b2, NoDataViewFactory.e.d(str2, string), cVar);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    public void onDeleteData(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            i(z);
            i iVar = this.m;
            if (iVar != null) {
                iVar.g(z);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            PersonPostModel personPostModel = this.mModel;
            if (personPostModel != null) {
                personPostModel.cancelLoadData();
            }
            try {
                c.a.o0.j.a.h();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            BdAsyncTask.removeAllTask(SetPrivacyModel.UNIQUE_ID_SET_PRIVACY_TASK);
            BdAsyncTask.removeAllTask(ForumManageModel.UNIQUE_ID_DEL_POST_TASK);
            super.onDestroy();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
    public void onResult(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048595, this, personPostModel, z) == null) {
            if (personPostModel != null && (personPostModel2 = this.mModel) != null) {
                if (z) {
                    personPostModel2.threadList.clear();
                }
                ArrayList<n> arrayList = personPostModel.threadList;
                if (personPostModel.view_card_num > 0 && this.r) {
                    ListUtils.add(arrayList, personPostModel.view_card_num - 1, new c.a.p0.n2.e.j());
                    this.r = false;
                }
                if (this.mModel.threadList.isEmpty()) {
                    n nVar = (n) ListUtils.getItem(arrayList, 0);
                    if (nVar instanceof CardPersonDynamicThreadData) {
                        ((CardPersonDynamicThreadData) nVar).G = true;
                    } else if (nVar instanceof c.a.p0.n2.e.j) {
                        ((c.a.p0.n2.e.j) nVar).f22310e = true;
                    }
                }
                this.mModel.threadList.addAll(arrayList);
                PersonPostModel.mergeDynamicThreadByTime(this.mModel.threadList);
            }
            c.a.p0.r2.b bVar = this.p;
            if (bVar != null) {
                bVar.showRecycleBinRedTip(personPostModel.isShowRecycleBinRedTip);
            }
            on(personPostModel, z);
            this.f55879i.d(this.mModel.threadList);
            this.f55879i.b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onResume();
            onActive();
            c.a.p0.r2.n.a aVar = this.f55879i;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.n) {
                fetchDataWithoutReset();
                this.m.f();
                this.s = true;
                return;
            }
            this.m.g(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onStart();
            NoDataView noDataView = this.f55876f.f23823d;
            if (noDataView != null) {
                noDataView.onActivityStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onStop();
            NoDataView noDataView = this.f55876f.f23823d;
            if (noDataView != null) {
                noDataView.onActivityStop();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, view, bundle) == null) {
            this.k = getArguments().getString("key_uid");
            if (this.f55875e.equals("photolive")) {
                this.t = 33;
            }
            this.f55879i = new c.a.p0.r2.n.a(getPageContext(), this.f55876f.f23822c);
            this.f55876f.f().setOnItemClickListener(new d(this));
            c.a.o0.s.f0.g gVar = new c.a.o0.s.f0.g(getPageContext());
            this.l = gVar;
            gVar.a(new e(this));
            this.f55876f.f23822c.setPullRefresh(this.l);
            if (TbadkCoreApplication.isMyLive) {
                View d2 = BdListViewHelper.d(getActivity(), this.f55876f.f23822c, BdListViewHelper.HeadType.DEFAULT);
                this.f55878h = d2;
                BdListViewHelper.c(d2, BdListViewHelper.HeadType.DEFAULT, j.z());
            } else {
                View d3 = BdListViewHelper.d(getActivity(), this.f55876f.f23822c, BdListViewHelper.HeadType.HASTAB);
                this.f55878h = d3;
                BdListViewHelper.c(d3, BdListViewHelper.HeadType.HASTAB, true);
            }
            this.f55876f.f23822c.setOnSrollToBottomListener(this);
            i iVar = new i(getBaseFragmentActivity());
            this.m = iVar;
            this.f55876f.f23822c.setNextPage(iVar);
        }
    }

    public void setNavigationBarRedTipListener(c.a.p0.r2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bVar) == null) {
            this.p = bVar;
        }
    }

    public void setNoNetRefreshListener(c.a.p0.r2.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, dVar) == null) {
            this.o = dVar;
        }
    }
}
