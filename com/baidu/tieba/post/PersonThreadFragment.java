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
import com.repackage.a88;
import com.repackage.b88;
import com.repackage.c88;
import com.repackage.fo;
import com.repackage.g88;
import com.repackage.gt7;
import com.repackage.h58;
import com.repackage.iu4;
import com.repackage.ki;
import com.repackage.li;
import com.repackage.m88;
import com.repackage.mi;
import com.repackage.ng;
import com.repackage.pu4;
import com.repackage.qu4;
import com.repackage.ro;
import com.repackage.yl4;
import com.repackage.zl4;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PersonThreadFragment extends BaseFragment implements PersonPostModel.d, zl4.a, PersonPostModel.c, BdListView.p, b88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public g88 b;
    public FrameLayout c;
    public View d;
    public m88 e;
    public PersonPostModel f;
    public boolean g;
    public String h;
    public qu4 i;
    public h j;
    public boolean k;
    public c88 l;
    public a88 m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public ShareSuccessReplyToServerModel r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public final CustomMessageListener u;

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || this.a.e == null) {
                return;
            }
            this.a.e.c((String) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes3.dex */
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
            mi.M(this.a.getActivity(), R.string.obfuscated_res_0x7f0f13c5);
        }
    }

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.P0();
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            CardPersonDynamicThreadData cardPersonDynamicThreadData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || i < 0 || this.a.e == null || i >= ListUtils.getCount(this.a.f.threadList) || (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) this.a.e.a.z(i)) == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createCfgForPersonCenter(String.valueOf(cardPersonDynamicThreadData.b), String.valueOf(cardPersonDynamicThreadData.e), "person_page", 18005).setThreadData(cardPersonDynamicThreadData.p)));
        }
    }

    /* loaded from: classes3.dex */
    public class e implements pu4.g {
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

        @Override // com.repackage.pu4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                PersonThreadFragment personThreadFragment = this.a;
                if (personThreadFragment.f != null) {
                    personThreadFragment.n = true;
                    if (!ki.A()) {
                        if (this.a.b != null) {
                            this.a.b.i(this.a.getString(R.string.obfuscated_res_0x7f0f0c2d), true);
                            return;
                        }
                        return;
                    }
                    this.a.K0();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonThreadFragment a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ f b;

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
                this.b = fVar;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.a.getPageContext().getPageActivity() == null) {
                    return;
                }
                gt7.a(this.b.a.getPageContext(), this.a).show();
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
                ng.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if (ki.z() && this.a.p) {
                    this.a.L0();
                    this.a.j.f();
                }
                if (TbadkCoreApplication.isMyLive) {
                    BdListViewHelper.c(this.a.d, BdListViewHelper.HeadType.DEFAULT, ki.z());
                } else {
                    BdListViewHelper.c(this.a.d, BdListViewHelper.HeadType.HASTAB, true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class h extends fo {
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
            this.b = R.color.CAM_X0201;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.i = 3;
            this.c = baseFragmentActivity;
        }

        @Override // com.repackage.fo
        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View inflate = LayoutInflater.from(this.c.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d05f4, (ViewGroup) null);
                this.g = inflate;
                this.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091713);
                this.h = this.g.findViewById(R.id.obfuscated_res_0x7f091716);
                SkinManager.setBackgroundColor(this.g, this.b);
                SkinManager.setBackgroundColor(this.h, this.b);
                this.h.setVisibility(8);
                this.e = (ProgressBar) this.g.findViewById(R.id.obfuscated_res_0x7f091975);
                h(TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setViewTextColor(this.d, (int) R.color.common_color_10039);
                this.h.setLayoutParams(new LinearLayout.LayoutParams(-1, mi.f(this.c.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07023f)));
                return this.g;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.repackage.fo
        public void c() {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (onClickListener = this.f) == null) {
                return;
            }
            onClickListener.onClick(this.g);
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                SkinManager.setBackgroundColor(this.g, R.color.CAM_X0204);
            }
        }

        @SuppressLint({"ResourceAsColor"})
        public void e(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.i == i) {
                return;
            }
            SkinManager.setViewTextColor(this.d, (int) R.color.common_color_10039);
            SkinManager.setBackgroundColor(this.g, this.b, i);
            SkinManager.setBackgroundColor(this.h, this.b, i);
            this.i = i;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.e.setVisibility(0);
                this.d.setText(this.c.getPageContext().getPageActivity().getText(R.string.obfuscated_res_0x7f0f0a34));
                this.h.setVisibility(0);
            }
        }

        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
                ProgressBar progressBar = this.e;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                if (this.d != null) {
                    if (!z) {
                        this.h.setVisibility(0);
                        this.d.setText(this.c.getResources().getString(R.string.obfuscated_res_0x7f0f09ee));
                        return;
                    }
                    this.h.setVisibility(0);
                    this.d.setText(this.c.getResources().getString(R.string.obfuscated_res_0x7f0f0a31));
                }
            }
        }

        public void h(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                this.c.getLayoutMode().j(this.h);
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
            if (personPostModel != null && (personPostModel2 = this.f) != null) {
                if (z) {
                    personPostModel2.threadList.clear();
                }
                ArrayList<ro> arrayList = personPostModel.threadList;
                if (personPostModel.view_card_num > 0 && this.o) {
                    ListUtils.add(arrayList, personPostModel.view_card_num - 1, new h58());
                    this.o = false;
                }
                if (this.f.threadList.isEmpty()) {
                    ro roVar = (ro) ListUtils.getItem(arrayList, 0);
                    if (roVar instanceof CardPersonDynamicThreadData) {
                        ((CardPersonDynamicThreadData) roVar).E = true;
                    } else if (roVar instanceof h58) {
                        ((h58) roVar).a = true;
                    }
                }
                this.f.threadList.addAll(arrayList);
                PersonPostModel.mergeDynamicThreadByTime(this.f.threadList);
            }
            a88 a88Var = this.m;
            if (a88Var != null) {
                a88Var.showRecycleBinRedTip(personPostModel.isShowRecycleBinRedTip);
            }
            O(personPostModel, z);
            this.e.d(this.f.threadList);
            this.e.b();
        }
    }

    public final void J0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            g88 g88Var = this.b;
            g88Var.c.removeHeaderView(g88Var.d);
            if (z) {
                this.b.d.setVisibility(0);
                g88 g88Var2 = this.b;
                g88Var2.c.addHeaderView(g88Var2.d);
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (personPostModel = this.f) == null) {
            return;
        }
        personPostModel.fetchPost(getPageContext(), this, true, this.h, true, this.q, false, true, null);
        this.o = true;
    }

    public void L0() {
        PersonPostModel personPostModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (personPostModel = this.f) == null) {
            return;
        }
        personPostModel.fetchPost(getPageContext(), this, false, this.h, true, false, true, null);
    }

    public g88 M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (g88) invokeV.objValue;
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            yl4.a(getBaseFragmentActivity()).e(true, true, true, this);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.d
    public void O(PersonPostModel personPostModel, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, personPostModel, z) == null) {
            this.p = false;
            if (isAdded()) {
                this.b.c.A(0L);
                this.b.c.setEmptyView(null);
                if (personPostModel != null || this.n) {
                    if (personPostModel != null && (personPostModel.threadList.size() != 0 || !this.n || !StringUtils.isNull(personPostModel.getErrorString()))) {
                        if (personPostModel.threadList.size() == 0 && this.n) {
                            J0(true);
                        } else {
                            J0(false);
                        }
                        if (personPostModel.getErrorCode() != 0) {
                            mi.N(getActivity(), personPostModel.getErrorString());
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.g) {
            return;
        }
        this.b.c.F();
        this.g = true;
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TiebaStatic.log(TbadkCoreStatisticKey.MYLIVE_TO_BE_ANCHOR);
            N0();
            yl4.a(getBaseFragmentActivity()).g(1, this);
        }
    }

    public final void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            N0();
            yl4.a(getBaseFragmentActivity()).f(this);
        }
    }

    public void R0(a88 a88Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, a88Var) == null) {
            this.m = a88Var;
        }
    }

    public void S0(c88 c88Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, c88Var) == null) {
            this.l = c88Var;
        }
    }

    @Override // com.repackage.b88
    public void Y() {
        g88 g88Var;
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (g88Var = this.b) == null || (bdTypeListView = g88Var.c) == null) {
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
                if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.e != null && (personPostModel = this.f) != null && ListUtils.getCount(personPostModel.threadList) > 0) {
                    int count = ListUtils.getCount(this.f.threadList);
                    boolean z = false;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= count) {
                            break;
                        }
                        ro roVar = (ro) ListUtils.getItem(this.f.threadList, i3);
                        if ((roVar instanceof CardPersonDynamicThreadData) && (cardPersonDynamicThreadData = (CardPersonDynamicThreadData) roVar) != null && stringExtra.equals(String.valueOf(cardPersonDynamicThreadData.b))) {
                            z = true;
                            break;
                        }
                        i3++;
                    }
                    if (z && intent.getIntExtra("type", -1) == 0) {
                        ListUtils.remove(this.f.threadList, i3);
                        this.e.b();
                    }
                }
                if (i == 24007) {
                    int intExtra = intent.getIntExtra("extra_share_status", 2);
                    int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                    if (intExtra != 1 || (shareItem = TbadkCoreApplication.getInst().getShareItem()) == null || (str = shareItem.v) == null || (shareSuccessReplyToServerModel = this.r) == null) {
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
                NoDataView noDataView = this.b.d;
                if (noDataView != null) {
                    noDataView.d(getPageContext());
                }
                qu4 qu4Var = this.i;
                if (qu4Var != null) {
                    qu4Var.H(i);
                }
                m88 m88Var = this.e;
                if (m88Var != null) {
                    m88Var.b();
                }
                h hVar = this.j;
                if (hVar != null) {
                    hVar.e(i);
                }
                SkinManager.setBackgroundColor(this.b.c, R.color.CAM_X0201);
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
            this.f = personPostModel;
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
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d06d2, viewGroup, false);
            this.c = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091b2c);
            g88 g88Var = new g88(getActivity(), inflate);
            this.b = g88Var;
            if (g88Var.g() == null) {
                this.b.h(this.l);
            }
            BdTypeListView bdTypeListView = this.b.c;
            if (bdTypeListView != null) {
                SkinManager.setBackgroundColor(bdTypeListView, R.color.CAM_X0201);
            }
            String string3 = getArguments().getString("thread_type_key");
            if (!li.isEmpty(string3)) {
                this.a = string3;
            }
            NoDataViewFactory.b bVar = new NoDataViewFactory.b(getString(R.string.obfuscated_res_0x7f0f141d), new c(this));
            int dimension = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070235);
            String str2 = "";
            NoDataViewFactory.d b2 = NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, dimension);
            if (this.a.equals(WriteActivity.PHOTO_LIVE_DRAFT_KEY)) {
                int l = iu4.k().l(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1);
                if (l == 0) {
                    string2 = getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f1420);
                    str = getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f14e0);
                    dVar = NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_06, dimension, -1, -1);
                    cVar = NoDataViewFactory.c.a(bVar);
                } else {
                    dVar = b2;
                    str = "";
                    string2 = getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0e49);
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
            this.b.d = NoDataViewFactory.a(getActivity(), null, b2, NoDataViewFactory.e.d(str2, string), cVar);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            PersonPostModel personPostModel = this.f;
            if (personPostModel != null) {
                personPostModel.cancelLoadData();
            }
            try {
                yl4.h();
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
            m88 m88Var = this.e;
            if (m88Var != null) {
                m88Var.b();
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
            NoDataView noDataView = this.b.d;
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
            NoDataView noDataView = this.b.d;
            if (noDataView != null) {
                noDataView.e();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, view2, bundle) == null) {
            this.h = getArguments().getString("key_uid");
            if (this.a.equals(WriteActivity.PHOTO_LIVE_DRAFT_KEY)) {
                this.q = 33;
            }
            this.e = new m88(getPageContext(), this.b.c);
            this.b.f().setOnItemClickListener(new d(this));
            qu4 qu4Var = new qu4(getPageContext());
            this.i = qu4Var;
            qu4Var.e(new e(this));
            this.b.c.setPullRefresh(this.i);
            if (TbadkCoreApplication.isMyLive) {
                View d2 = BdListViewHelper.d(getActivity(), this.b.c, BdListViewHelper.HeadType.DEFAULT);
                this.d = d2;
                BdListViewHelper.c(d2, BdListViewHelper.HeadType.DEFAULT, ki.z());
            } else {
                View d3 = BdListViewHelper.d(getActivity(), this.b.c, BdListViewHelper.HeadType.HASTAB);
                this.d = d3;
                BdListViewHelper.c(d3, BdListViewHelper.HeadType.HASTAB, true);
            }
            this.b.c.setOnSrollToBottomListener(this);
            h hVar = new h(getBaseFragmentActivity());
            this.j = hVar;
            this.b.c.setNextPage(hVar);
        }
    }
}
