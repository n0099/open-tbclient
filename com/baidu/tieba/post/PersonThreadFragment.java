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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
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
import com.baidu.tieba.ai9;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.cl9;
import com.baidu.tieba.fx4;
import com.baidu.tieba.gx4;
import com.baidu.tieba.il9;
import com.baidu.tieba.kn;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.o95;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.t59;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.vi;
import com.baidu.tieba.wi;
import com.baidu.tieba.wk9;
import com.baidu.tieba.wn;
import com.baidu.tieba.x95;
import com.baidu.tieba.xg;
import com.baidu.tieba.xk9;
import com.baidu.tieba.y95;
import com.baidu.tieba.yk9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class PersonThreadFragment extends BaseFragment implements PersonPostModel.d, gx4.a, PersonPostModel.c, BdListView.p, xk9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public cl9 b;
    public FrameLayout c;
    public View d;
    public il9 e;
    public PersonPostModel f;
    public boolean g;
    public String h;
    public String i;
    public y95 j;
    public i k;
    public boolean l;
    public yk9 m;
    public wk9 n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public ShareSuccessReplyToServerModel s;
    public final CustomMessageListener t;
    public CustomMessageListener u;
    public CustomMessageListener v;
    public final CustomMessageListener w;

    /* loaded from: classes7.dex */
    public class g implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonThreadFragment a;

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ g b;

            public a(g gVar, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = gVar;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.getPageContext().getPageActivity() != null) {
                    t59.a(this.b.a.getPageContext(), this.a).show();
                }
            }
        }

        public g(PersonThreadFragment personThreadFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personThreadFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personThreadFragment;
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                xg.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonThreadFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonThreadFragment personThreadFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personThreadFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personThreadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (this.a.e != null) {
                    this.a.e.c(str);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonThreadFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PersonThreadFragment personThreadFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personThreadFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personThreadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && this.a.e != null) {
                this.a.e.c((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonThreadFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonThreadFragment personThreadFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personThreadFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personThreadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                wi.P(this.a.getActivity(), R.string.thread_has_hide);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonThreadFragment a;

        public d(PersonThreadFragment personThreadFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personThreadFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personThreadFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.U1();
        }
    }

    /* loaded from: classes7.dex */
    public class e implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonThreadFragment a;

        public e(PersonThreadFragment personThreadFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personThreadFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personThreadFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            CardPersonDynamicThreadData cardPersonDynamicThreadData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && i >= 0 && this.a.e != null && i < ListUtils.getCount(this.a.f.threadList) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) this.a.e.a.getItem(i)) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.b), String.valueOf(cardPersonDynamicThreadData.e), "person_page", 18005).setThreadData(cardPersonDynamicThreadData.p)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements x95.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonThreadFragment a;

        public f(PersonThreadFragment personThreadFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personThreadFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personThreadFragment;
        }

        @Override // com.baidu.tieba.x95.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                PersonThreadFragment personThreadFragment = this.a;
                if (personThreadFragment.f == null) {
                    return;
                }
                personThreadFragment.o = true;
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    this.a.P1();
                } else if (this.a.b != null) {
                    this.a.b.i(this.a.getString(R.string.obfuscated_res_0x7f0f0df3), true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonThreadFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(PersonThreadFragment personThreadFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personThreadFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personThreadFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage.getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage)) {
                return;
            }
            if (BdNetTypeUtil.isNetWorkAvailable() && this.a.q) {
                this.a.Q1();
                this.a.k.g();
            }
            if (TbadkCoreApplication.isMyLive) {
                BdListViewHelper.c(this.a.d, BdListViewHelper.HeadType.DEFAULT, BdNetTypeUtil.isNetWorkAvailable());
            } else {
                BdListViewHelper.c(this.a.d, BdListViewHelper.HeadType.HASTAB, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class i extends kn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int b;
        public BaseFragmentActivity c;
        public TextView d;
        public ProgressBar e;
        public View.OnClickListener f;
        public View g;
        public View h;
        public int i;

        public i(BaseFragmentActivity baseFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = R.color.CAM_X0201;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.i = 3;
            this.c = baseFragmentActivity;
        }

        @Override // com.baidu.tieba.kn
        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View inflate = LayoutInflater.from(this.c.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                this.g = inflate;
                this.d = (TextView) inflate.findViewById(R.id.pb_more_text);
                this.h = this.g.findViewById(R.id.pb_more_view);
                SkinManager.setBackgroundColor(this.g, this.b);
                SkinManager.setBackgroundColor(this.h, this.b);
                this.h.setVisibility(8);
                this.e = (ProgressBar) this.g.findViewById(R.id.obfuscated_res_0x7f091cd3);
                i(TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setViewTextColor(this.d, (int) R.color.common_color_10039);
                this.h.setLayoutParams(new LinearLayout.LayoutParams(-1, wi.g(this.c.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07035e)));
                return this.g;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.baidu.tieba.kn
        public void d() {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (onClickListener = this.f) != null) {
                onClickListener.onClick(this.g);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                SkinManager.setBackgroundColor(this.g, R.color.CAM_X0204);
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.e.setVisibility(0);
                this.d.setText(this.c.getPageContext().getPageActivity().getText(R.string.obfuscated_res_0x7f0f0bd2));
                this.h.setVisibility(0);
            }
        }

        @SuppressLint({"ResourceAsColor"})
        public void f(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && this.i != i) {
                SkinManager.setViewTextColor(this.d, (int) R.color.common_color_10039);
                SkinManager.setBackgroundColor(this.g, this.b, i);
                SkinManager.setBackgroundColor(this.h, this.b, i);
                this.i = i;
            }
        }

        public void i(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                this.c.getLayoutMode().k(this.h);
            }
        }

        public void h(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
                ProgressBar progressBar = this.e;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                if (this.d != null) {
                    if (!z) {
                        this.h.setVisibility(0);
                        this.d.setText(this.c.getResources().getString(R.string.list_no_more));
                        return;
                    }
                    this.h.setVisibility(0);
                    this.d.setText(this.c.getResources().getString(R.string.load_more));
                }
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
        this.a = "common";
        this.l = false;
        this.o = true;
        this.p = true;
        this.q = false;
        this.t = new a(this, 2921031);
        this.u = new b(this, 2016557);
        this.v = new c(this, 2016558);
        this.w = new h(this, 2000994);
    }

    public void W1(wk9 wk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, wk9Var) == null) {
            this.n = wk9Var;
        }
    }

    public void X1(yk9 yk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, yk9Var) == null) {
            this.m = yk9Var;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onActivityCreated(bundle);
            registerListener(this.u);
            registerListener(this.v);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.d
    public void B0(PersonPostModel personPostModel, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, personPostModel, z) == null) {
            this.q = false;
            if (!isAdded()) {
                return;
            }
            this.b.c.z(0L);
            this.b.c.setEmptyView(null);
            if (personPostModel == null && !this.o) {
                return;
            }
            if (personPostModel != null && (personPostModel.threadList.size() != 0 || !this.o || !StringUtils.isNull(personPostModel.getErrorString()))) {
                if (personPostModel.threadList.size() == 0 && this.o) {
                    O1(true);
                } else {
                    O1(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    wi.Q(getActivity(), personPostModel.getErrorString());
                }
                this.l = !ListUtils.isEmpty(personPostModel.threadList);
                if (z) {
                    if (personPostModel.threadList.size() < 20) {
                        this.l = false;
                    } else {
                        this.l = true;
                    }
                    this.o = false;
                }
                this.k.h(this.l);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
                return;
            }
            O1(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, view2, bundle) == null) {
            this.h = getArguments().getString("key_uid");
            this.i = getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL);
            if (this.a.equals("photolive")) {
                this.r = 33;
            }
            this.e = new il9(getPageContext(), this.b.c);
            this.b.f().setOnItemClickListener(new e(this));
            y95 y95Var = new y95(getPageContext());
            this.j = y95Var;
            y95Var.f(new f(this));
            this.b.c.setPullRefresh(this.j);
            if (TbadkCoreApplication.isMyLive) {
                View d2 = BdListViewHelper.d(getActivity(), this.b.c, BdListViewHelper.HeadType.DEFAULT);
                this.d = d2;
                BdListViewHelper.c(d2, BdListViewHelper.HeadType.DEFAULT, BdNetTypeUtil.isNetWorkAvailable());
            } else {
                View d3 = BdListViewHelper.d(getActivity(), this.b.c, BdListViewHelper.HeadType.HASTAB);
                this.d = d3;
                BdListViewHelper.c(d3, BdListViewHelper.HeadType.HASTAB, true);
            }
            this.b.c.setOnSrollToBottomListener(this);
            i iVar = new i(getBaseFragmentActivity());
            this.k = iVar;
            this.b.c.setNextPage(iVar);
        }
    }

    public final void O1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            cl9 cl9Var = this.b;
            cl9Var.c.removeHeaderView(cl9Var.d);
            if (z) {
                this.b.d.setVisibility(0);
                cl9 cl9Var2 = this.b;
                cl9Var2.c.addHeaderView(cl9Var2.d);
                this.k.c().setVisibility(8);
                return;
            }
            this.k.c().setVisibility(0);
            this.k.e();
        }
    }

    @Override // com.baidu.tieba.xk9
    public void P0() {
        cl9 cl9Var;
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (cl9Var = this.b) != null && (bdTypeListView = cl9Var.c) != null) {
            bdTypeListView.E();
        }
    }

    public void P1() {
        PersonPostModel personPostModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (personPostModel = this.f) != null) {
            personPostModel.fetchPost(getPageContext(), this, true, this.h, true, this.r, false, true, null, this.i);
            this.p = true;
        }
    }

    public void Q1() {
        PersonPostModel personPostModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (personPostModel = this.f) != null) {
            personPostModel.fetchPost(getPageContext(), this, false, this.h, true, 0, false, true, null, this.i);
        }
    }

    public cl9 R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (cl9) invokeV.objValue;
    }

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            fx4.a(getBaseFragmentActivity()).e(true, true, true, this);
        }
    }

    public void T1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && !this.g) {
            this.b.c.E();
            this.g = true;
        }
    }

    public final void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TiebaStatic.log(TbadkCoreStatisticKey.MYLIVE_TO_BE_ANCHOR);
            S1();
            fx4.a(getBaseFragmentActivity()).g(1, this);
        }
    }

    public final void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            S1();
            fx4.a(getBaseFragmentActivity()).f(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            PersonPostModel personPostModel = this.f;
            if (personPostModel != null) {
                personPostModel.cancelLoadData();
            }
            try {
                fx4.h();
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
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
            T1();
            il9 il9Var = this.e;
            if (il9Var != null) {
                il9Var.b();
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.l) {
                Q1();
                this.k.g();
                this.q = true;
                return;
            }
            this.k.h(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onStart();
            NoDataView noDataView = this.b.d;
            if (noDataView != null) {
                noDataView.d(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onStop();
            NoDataView noDataView = this.b.d;
            if (noDataView != null) {
                noDataView.e();
            }
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
                if (i2 == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.e != null && (personPostModel = this.f) != null && ListUtils.getCount(personPostModel.threadList) > 0) {
                    int count = ListUtils.getCount(this.f.threadList);
                    boolean z = false;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= count) {
                            break;
                        }
                        wn wnVar = (wn) ListUtils.getItem(this.f.threadList, i4);
                        if ((wnVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) wnVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.b))) {
                            z = true;
                            break;
                        }
                        i4++;
                    }
                    if (z && intent.getIntExtra("type", -1) == 0) {
                        ListUtils.remove(this.f.threadList, i4);
                        this.e.b();
                    }
                }
                if (i2 == 24007) {
                    int intExtra = intent.getIntExtra("extra_share_status", 2);
                    int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                    if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && (str = shareItem.x) != null && (shareSuccessReplyToServerModel = this.s) != null) {
                        shareSuccessReplyToServerModel.U(str, intExtra2, new g(this));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (!isAdded()) {
                return;
            }
            NoDataView noDataView = this.b.d;
            if (noDataView != null) {
                noDataView.d(getPageContext());
            }
            y95 y95Var = this.j;
            if (y95Var != null) {
                y95Var.H(i2);
            }
            il9 il9Var = this.e;
            if (il9Var != null) {
                il9Var.b();
            }
            i iVar = this.k;
            if (iVar != null) {
                iVar.f(i2);
            }
            SkinManager.setBackgroundColor(this.b.c, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.w);
            registerListener(this.t);
            PersonPostModel personPostModel = new PersonPostModel(getPageContext(), getUniqueId(), this, true, 2);
            this.f = personPostModel;
            personPostModel.setUniqueId(getUniqueId());
            this.s = new ShareSuccessReplyToServerModel();
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
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d07c3, viewGroup, false);
            this.c = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091edb);
            cl9 cl9Var = new cl9(getActivity(), inflate);
            this.b = cl9Var;
            if (cl9Var.g() == null) {
                this.b.h(this.m);
            }
            BdTypeListView bdTypeListView = this.b.c;
            if (bdTypeListView != null) {
                SkinManager.setBackgroundColor(bdTypeListView, R.color.CAM_X0201);
            }
            String string3 = getArguments().getString("thread_type_key");
            if (!vi.isEmpty(string3)) {
                this.a = string3;
            }
            NoDataViewFactory.b bVar = new NoDataViewFactory.b(getString(R.string.to_be_an_liver), new d(this));
            int dimension = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070354);
            String str2 = "";
            NoDataViewFactory.d b2 = NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, dimension);
            if (this.a.equals("photolive")) {
                int q = o95.p().q(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1);
                if (q == 0) {
                    string2 = getPageContext().getResources().getString(R.string.to_live_to_god);
                    str = getPageContext().getResources().getString(R.string.user_not_liver);
                    dVar = NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_06, dimension, -1, -1);
                    cVar = NoDataViewFactory.c.a(bVar);
                } else {
                    dVar = b2;
                    str = "";
                    string2 = getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f1057);
                    cVar = null;
                }
                if (q < 0) {
                    V1();
                }
                String str3 = str;
                b2 = dVar;
                string = string2;
                str2 = str3;
            } else {
                string = getArguments().getString("key_empty_view_text");
                cVar = null;
            }
            this.b.d = NoDataViewFactory.a(getActivity(), null, b2, NoDataViewFactory.e.d(str2, string), cVar);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
    public void s0(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048599, this, personPostModel, z) == null) {
            if (personPostModel != null && (personPostModel2 = this.f) != null) {
                if (z) {
                    personPostModel2.threadList.clear();
                }
                ArrayList<wn> arrayList = personPostModel.threadList;
                if (personPostModel.view_card_num > 0 && this.p) {
                    ListUtils.add(arrayList, personPostModel.view_card_num - 1, new ai9());
                    this.p = false;
                }
                if (this.f.threadList.isEmpty()) {
                    wn wnVar = (wn) ListUtils.getItem(arrayList, 0);
                    if (wnVar instanceof CardPersonDynamicThreadData) {
                        ((CardPersonDynamicThreadData) wnVar).E = true;
                    } else if (wnVar instanceof ai9) {
                        ((ai9) wnVar).a = true;
                    }
                }
                this.f.threadList.addAll(arrayList);
                PersonPostModel.mergeDynamicThreadByTime(this.f.threadList);
            }
            wk9 wk9Var = this.n;
            if (wk9Var != null) {
                wk9Var.p0(personPostModel.isShowRecycleBinRedTip);
            }
            B0(personPostModel, z);
            this.e.d(this.f.threadList);
            this.e.b();
        }
    }
}
