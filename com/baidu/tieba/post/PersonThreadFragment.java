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
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.i.b;
import c.a.o0.r.l0.f;
import c.a.p0.b3.e.j;
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
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class PersonThreadFragment extends BaseFragment implements PersonPostModel.d, b.a, PersonPostModel.c, BdListView.p, c.a.p0.f3.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.f3.h f35617b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f35618c;

    /* renamed from: d  reason: collision with root package name */
    public View f35619d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.f3.n.a f35620e;

    /* renamed from: f  reason: collision with root package name */
    public PersonPostModel f35621f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35622g;

    /* renamed from: h  reason: collision with root package name */
    public String f35623h;
    public c.a.o0.r.l0.g i;
    public h j;
    public boolean k;
    public c.a.p0.f3.d l;
    public c.a.p0.f3.b m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public ShareSuccessReplyToServerModel r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public final CustomMessageListener u;

    /* loaded from: classes5.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || this.a.f35620e == null) {
                return;
            }
            this.a.f35620e.c((String) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes5.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            n.M(this.a.getActivity(), R.string.obfuscated_res_0x7f0f1399);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonThreadFragment a;

        public c(PersonThreadFragment personThreadFragment) {
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.P0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements AdapterView.OnItemClickListener {
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

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            CardPersonDynamicThreadData cardPersonDynamicThreadData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) || i < 0 || this.a.f35620e == null || i >= ListUtils.getCount(this.a.f35621f.threadList) || (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) this.a.f35620e.a.z(i)) == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.f31670b), String.valueOf(cardPersonDynamicThreadData.f31673e), "person_page", 18005).setThreadData(cardPersonDynamicThreadData.p)));
        }
    }

    /* loaded from: classes5.dex */
    public class e implements f.g {
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

        @Override // c.a.o0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                PersonThreadFragment personThreadFragment = this.a;
                if (personThreadFragment.f35621f != null) {
                    personThreadFragment.n = true;
                    if (!l.A()) {
                        if (this.a.f35617b != null) {
                            this.a.f35617b.i(this.a.getString(R.string.obfuscated_res_0x7f0f0c15), true);
                            return;
                        }
                        return;
                    }
                    this.a.K0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonThreadFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ f f35624b;

            public a(f fVar, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f35624b = fVar;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f35624b.a.getPageContext().getPageActivity() == null) {
                    return;
                }
                c.a.p0.w2.k.c.a(this.f35624b.a.getPageContext(), this.a).show();
            }
        }

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
                c.a.d.f.m.e.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonThreadFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(PersonThreadFragment personThreadFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                if (l.z() && this.a.p) {
                    this.a.L0();
                    this.a.j.f();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.c(this.a.f35619d, BdListViewHelper.HeadType.DEFAULT, l.z());
                } else {
                    BdListViewHelper.c(this.a.f35619d, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class h extends c.a.d.o.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public int f35625b;

        /* renamed from: c  reason: collision with root package name */
        public BaseFragmentActivity f35626c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f35627d;

        /* renamed from: e  reason: collision with root package name */
        public ProgressBar f35628e;

        /* renamed from: f  reason: collision with root package name */
        public View.OnClickListener f35629f;

        /* renamed from: g  reason: collision with root package name */
        public View f35630g;

        /* renamed from: h  reason: collision with root package name */
        public View f35631h;
        public int i;

        public h(BaseFragmentActivity baseFragmentActivity) {
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
            this.f35625b = R.color.CAM_X0201;
            this.f35626c = null;
            this.f35627d = null;
            this.f35628e = null;
            this.f35629f = null;
            this.f35630g = null;
            this.i = 3;
            this.f35626c = baseFragmentActivity;
        }

        @Override // c.a.d.o.e.b
        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View inflate = LayoutInflater.from(this.f35626c.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d05fe, (ViewGroup) null);
                this.f35630g = inflate;
                this.f35627d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0916ed);
                this.f35631h = this.f35630g.findViewById(R.id.obfuscated_res_0x7f0916f0);
                SkinManager.setBackgroundColor(this.f35630g, this.f35625b);
                SkinManager.setBackgroundColor(this.f35631h, this.f35625b);
                this.f35631h.setVisibility(8);
                this.f35628e = (ProgressBar) this.f35630g.findViewById(R.id.obfuscated_res_0x7f091929);
                h(TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setViewTextColor(this.f35627d, (int) R.color.common_color_10039);
                this.f35631h.setLayoutParams(new LinearLayout.LayoutParams(-1, n.f(this.f35626c.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070235)));
                return this.f35630g;
            }
            return (View) invokeV.objValue;
        }

        @Override // c.a.d.o.e.b
        public void c() {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (onClickListener = this.f35629f) == null) {
                return;
            }
            onClickListener.onClick(this.f35630g);
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                SkinManager.setBackgroundColor(this.f35630g, R.color.CAM_X0204);
            }
        }

        @SuppressLint({"ResourceAsColor"})
        public void e(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.i == i) {
                return;
            }
            SkinManager.setViewTextColor(this.f35627d, (int) R.color.common_color_10039);
            SkinManager.setBackgroundColor(this.f35630g, this.f35625b, i);
            SkinManager.setBackgroundColor(this.f35631h, this.f35625b, i);
            this.i = i;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f35628e.setVisibility(0);
                this.f35627d.setText(this.f35626c.getPageContext().getPageActivity().getText(R.string.obfuscated_res_0x7f0f0a2e));
                this.f35631h.setVisibility(0);
            }
        }

        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
                ProgressBar progressBar = this.f35628e;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                if (this.f35627d != null) {
                    if (!z) {
                        this.f35631h.setVisibility(0);
                        this.f35627d.setText(this.f35626c.getResources().getString(R.string.obfuscated_res_0x7f0f09e8));
                        return;
                    }
                    this.f35631h.setVisibility(0);
                    this.f35627d.setText(this.f35626c.getResources().getString(R.string.obfuscated_res_0x7f0f0a2b));
                }
            }
        }

        public void h(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                this.f35626c.getLayoutMode().j(this.f35631h);
            }
        }
    }

    public PersonThreadFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "common";
        this.k = false;
        this.n = true;
        this.o = true;
        this.p = false;
        this.s = new a(this, 2016557);
        this.t = new b(this, 2016558);
        this.u = new g(this, 2000994);
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
    public void I(PersonPostModel personPostModel, boolean z) {
        PersonPostModel personPostModel2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, personPostModel, z) == null) {
            if (personPostModel != null && (personPostModel2 = this.f35621f) != null) {
                if (z) {
                    personPostModel2.threadList.clear();
                }
                ArrayList<c.a.d.o.e.n> arrayList = personPostModel.threadList;
                if (personPostModel.view_card_num > 0 && this.o) {
                    ListUtils.add(arrayList, personPostModel.view_card_num - 1, new j());
                    this.o = false;
                }
                if (this.f35621f.threadList.isEmpty()) {
                    c.a.d.o.e.n nVar = (c.a.d.o.e.n) ListUtils.getItem(arrayList, 0);
                    if (nVar instanceof CardPersonDynamicThreadData) {
                        ((CardPersonDynamicThreadData) nVar).E = true;
                    } else if (nVar instanceof j) {
                        ((j) nVar).a = true;
                    }
                }
                this.f35621f.threadList.addAll(arrayList);
                PersonPostModel.mergeDynamicThreadByTime(this.f35621f.threadList);
            }
            c.a.p0.f3.b bVar = this.m;
            if (bVar != null) {
                bVar.showRecycleBinRedTip(personPostModel.isShowRecycleBinRedTip);
            }
            O(personPostModel, z);
            this.f35620e.d(this.f35621f.threadList);
            this.f35620e.b();
        }
    }

    public final void J0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            c.a.p0.f3.h hVar = this.f35617b;
            hVar.f14961c.removeHeaderView(hVar.f14962d);
            if (z) {
                this.f35617b.f14962d.setVisibility(0);
                c.a.p0.f3.h hVar2 = this.f35617b;
                hVar2.f14961c.addHeaderView(hVar2.f14962d);
                this.j.b().setVisibility(8);
                return;
            }
            this.j.b().setVisibility(0);
            this.j.d();
        }
    }

    public void K0() {
        PersonPostModel personPostModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (personPostModel = this.f35621f) == null) {
            return;
        }
        personPostModel.fetchPost(getPageContext(), this, true, this.f35623h, true, this.q, false, true, null);
        this.o = true;
    }

    public void L0() {
        PersonPostModel personPostModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (personPostModel = this.f35621f) == null) {
            return;
        }
        personPostModel.fetchPost(getPageContext(), this, false, this.f35623h, true, false, true, null);
    }

    public c.a.p0.f3.h M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f35617b : (c.a.p0.f3.h) invokeV.objValue;
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.o0.i.a.a(getBaseFragmentActivity()).e(true, true, true, this);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.d
    public void O(PersonPostModel personPostModel, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, personPostModel, z) == null) {
            this.p = false;
            if (isAdded()) {
                this.f35617b.f14961c.A(0L);
                this.f35617b.f14961c.setEmptyView(null);
                if (personPostModel != null || this.n) {
                    if (personPostModel != null && (personPostModel.threadList.size() != 0 || !this.n || !StringUtils.isNull(personPostModel.getErrorString()))) {
                        if (personPostModel.threadList.size() == 0 && this.n) {
                            J0(true);
                        } else {
                            J0(false);
                        }
                        if (personPostModel.getErrorCode() != 0) {
                            n.N(getActivity(), personPostModel.getErrorString());
                        }
                        this.k = !ListUtils.isEmpty(personPostModel.threadList);
                        if (z) {
                            if (personPostModel.threadList.size() < 20) {
                                this.k = false;
                            } else {
                                this.k = true;
                            }
                            this.n = false;
                        }
                        this.j.g(this.k);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016221));
                        return;
                    }
                    J0(true);
                }
            }
        }
    }

    public void O0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f35622g) {
            return;
        }
        this.f35617b.f14961c.F();
        this.f35622g = true;
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TiebaStatic.log(TbadkCoreStatisticKey.MYLIVE_TO_BE_ANCHOR);
            N0();
            c.a.o0.i.a.a(getBaseFragmentActivity()).g(1, this);
        }
    }

    public final void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            N0();
            c.a.o0.i.a.a(getBaseFragmentActivity()).f(this);
        }
    }

    public void R0(c.a.p0.f3.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.m = bVar;
        }
    }

    public void S0(c.a.p0.f3.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.l = dVar;
        }
    }

    @Override // c.a.p0.f3.c
    public void Y() {
        c.a.p0.f3.h hVar;
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (hVar = this.f35617b) == null || (bdTypeListView = hVar.f14961c) == null) {
            return;
        }
        bdTypeListView.F();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onActivityCreated(bundle);
            registerListener(this.s);
            registerListener(this.t);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        ShareItem shareItem;
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        String stringExtra;
        PersonPostModel personPostModel;
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048590, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.f35620e != null && (personPostModel = this.f35621f) != null && ListUtils.getCount(personPostModel.threadList) > 0) {
                    int count = ListUtils.getCount(this.f35621f.threadList);
                    boolean z = false;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= count) {
                            break;
                        }
                        c.a.d.o.e.n nVar = (c.a.d.o.e.n) ListUtils.getItem(this.f35621f.threadList, i3);
                        if ((nVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) nVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.f31670b))) {
                            z = true;
                            break;
                        }
                        i3++;
                    }
                    if (z && intent.getIntExtra("type", -1) == 0) {
                        ListUtils.remove(this.f35621f.threadList, i3);
                        this.f35620e.b();
                    }
                }
                if (i == 24007) {
                    int intExtra = intent.getIntExtra("extra_share_status", 2);
                    int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                    if (intExtra != 1 || (shareItem = TbadkCoreApplication.getInst().getShareItem()) == null || (str = shareItem.t) == null || (shareSuccessReplyToServerModel = this.r) == null) {
                        return;
                    }
                    shareSuccessReplyToServerModel.y(str, intExtra2, new f(this));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            super.onChangeSkinType(i);
            if (isAdded()) {
                NoDataView noDataView = this.f35617b.f14962d;
                if (noDataView != null) {
                    noDataView.d(getPageContext());
                }
                c.a.o0.r.l0.g gVar = this.i;
                if (gVar != null) {
                    gVar.H(i);
                }
                c.a.p0.f3.n.a aVar = this.f35620e;
                if (aVar != null) {
                    aVar.b();
                }
                h hVar = this.j;
                if (hVar != null) {
                    hVar.e(i);
                }
                SkinManager.setBackgroundColor(this.f35617b.f14961c, R.color.CAM_X0201);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.u);
            PersonPostModel personPostModel = new PersonPostModel(getPageContext(), getUniqueId(), this, true, PersonPostModel.FROM_PERSON_POST);
            this.f35621f = personPostModel;
            personPostModel.setUniqueId(getUniqueId());
            this.r = new ShareSuccessReplyToServerModel();
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
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d06dd, viewGroup, false);
            this.f35618c = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091aee);
            c.a.p0.f3.h hVar = new c.a.p0.f3.h(getActivity(), inflate);
            this.f35617b = hVar;
            if (hVar.g() == null) {
                this.f35617b.h(this.l);
            }
            BdTypeListView bdTypeListView = this.f35617b.f14961c;
            if (bdTypeListView != null) {
                SkinManager.setBackgroundColor(bdTypeListView, R.color.CAM_X0201);
            }
            String string3 = getArguments().getString("thread_type_key");
            if (!m.isEmpty(string3)) {
                this.a = string3;
            }
            NoDataViewFactory.b bVar = new NoDataViewFactory.b(getString(R.string.obfuscated_res_0x7f0f13ee), new c(this));
            int dimension = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07022a);
            String str2 = "";
            NoDataViewFactory.d b2 = NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, dimension);
            if (this.a.equals(WriteActivity.PHOTO_LIVE_DRAFT_KEY)) {
                int l = c.a.o0.r.j0.b.k().l(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1);
                if (l == 0) {
                    string2 = getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f13f1);
                    str = getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f14ad);
                    dVar = NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_06, dimension, -1, -1);
                    cVar = NoDataViewFactory.c.a(bVar);
                } else {
                    dVar = b2;
                    str = "";
                    string2 = getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0e28);
                    cVar = null;
                }
                if (l < 0) {
                    Q0();
                }
                String str3 = str;
                b2 = dVar;
                string = string2;
                str2 = str3;
            } else {
                string = getArguments().getString(PersonPostActivity.KEY_EMPTYVIEW_TXT);
                cVar = null;
            }
            this.f35617b.f14962d = NoDataViewFactory.a(getActivity(), null, b2, NoDataViewFactory.e.d(str2, string), cVar);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            PersonPostModel personPostModel = this.f35621f;
            if (personPostModel != null) {
                personPostModel.cancelLoadData();
            }
            try {
                c.a.o0.i.a.h();
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
            O0();
            c.a.p0.f3.n.a aVar = this.f35620e;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.k) {
                L0();
                this.j.f();
                this.p = true;
                return;
            }
            this.j.g(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onStart();
            NoDataView noDataView = this.f35617b.f14962d;
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
            NoDataView noDataView = this.f35617b.f14962d;
            if (noDataView != null) {
                noDataView.e();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, view, bundle) == null) {
            this.f35623h = getArguments().getString("key_uid");
            if (this.a.equals(WriteActivity.PHOTO_LIVE_DRAFT_KEY)) {
                this.q = 33;
            }
            this.f35620e = new c.a.p0.f3.n.a(getPageContext(), this.f35617b.f14961c);
            this.f35617b.f().setOnItemClickListener(new d(this));
            c.a.o0.r.l0.g gVar = new c.a.o0.r.l0.g(getPageContext());
            this.i = gVar;
            gVar.f(new e(this));
            this.f35617b.f14961c.setPullRefresh(this.i);
            if (TbadkCoreApplication.isMyLive) {
                View d2 = BdListViewHelper.d(getActivity(), this.f35617b.f14961c, BdListViewHelper.HeadType.DEFAULT);
                this.f35619d = d2;
                BdListViewHelper.c(d2, BdListViewHelper.HeadType.DEFAULT, l.z());
            } else {
                View d3 = BdListViewHelper.d(getActivity(), this.f35617b.f14961c, BdListViewHelper.HeadType.HASTAB);
                this.f35619d = d3;
                BdListViewHelper.c(d3, BdListViewHelper.HeadType.HASTAB, true);
            }
            this.f35617b.f14961c.setOnSrollToBottomListener(this);
            h hVar = new h(getBaseFragmentActivity());
            this.j = hVar;
            this.f35617b.f14961c.setNextPage(hVar);
        }
    }
}
