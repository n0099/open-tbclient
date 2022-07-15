package com.baidu.tieba.setting.forbiddenforum;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ac8;
import com.repackage.bc8;
import com.repackage.cc8;
import com.repackage.cr4;
import com.repackage.jr4;
import com.repackage.lr4;
import com.repackage.nr4;
import com.repackage.pi;
import com.repackage.zb8;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ForbiddenForumActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public BdRecyclerView b;
    public bc8 c;
    public View d;
    public PbListView e;
    public lr4 f;
    public nr4 g;
    public zb8 h;
    public NoDataView i;
    public BdListView.p j;
    public RecyclerView.Adapter k;
    public bc8.b l;
    public BdRecyclerView.i m;
    public HttpMessageListener n;

    /* loaded from: classes4.dex */
    public class a implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForbiddenForumActivity a;

        public a(ForbiddenForumActivity forbiddenForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbiddenForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forbiddenForumActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view2, Object obj, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.c == null) {
                return;
            }
            if (this.a.c.g() == null && ListUtils.isEmpty(this.a.c.g().a)) {
                return;
            }
            ac8 ac8Var = this.a.c.g().a.get(i);
            this.a.L1(ac8Var.b, ac8Var.c);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForbiddenForumActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ForbiddenForumActivity forbiddenForumActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbiddenForumActivity, Integer.valueOf(i)};
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
            this.a = forbiddenForumActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0076  */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null) {
                return;
            }
            if (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                if (httpMessage.getParams() != null) {
                    str = String.valueOf(httpMessage.getParams().get("forum_id"));
                    BdTopToast bdTopToast = new BdTopToast(this.a);
                    if (httpResponsedMessage.getError() != 0) {
                        bdTopToast.h(this.a.getString(R.string.obfuscated_res_0x7f0f036e));
                        bdTopToast.i(true);
                        TiebaStatic.log(new StatisticItem("c14057").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", str));
                        this.a.c.f(str);
                        this.a.k.notifyDataSetChanged();
                    } else {
                        bdTopToast.h(this.a.getString(R.string.obfuscated_res_0x7f0f036d));
                        bdTopToast.i(false);
                    }
                    bdTopToast.j((ViewGroup) this.a.d);
                }
            }
            str = "";
            BdTopToast bdTopToast2 = new BdTopToast(this.a);
            if (httpResponsedMessage.getError() != 0) {
            }
            bdTopToast2.j((ViewGroup) this.a.d);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForbiddenForumActivity a;

        public c(ForbiddenForumActivity forbiddenForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbiddenForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forbiddenForumActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c.g().b) {
                this.a.c.j();
                this.a.N1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends RecyclerView.Adapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForbiddenForumActivity a;

        public d(ForbiddenForumActivity forbiddenForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbiddenForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forbiddenForumActivity;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.c.g().a.size() : invokeV.intValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder, i) == null) {
                ((l) viewHolder).a(this.a.c.g().a.get(i));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) ? new l(this.a, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0299, viewGroup, false)) : (RecyclerView.ViewHolder) invokeLI.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements bc8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForbiddenForumActivity a;

        public e(ForbiddenForumActivity forbiddenForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbiddenForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forbiddenForumActivity;
        }

        @Override // com.repackage.bc8.b
        public void a(cc8 cc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cc8Var) == null) {
                if (this.a.isLoadingViewAttached()) {
                    ForbiddenForumActivity forbiddenForumActivity = this.a;
                    forbiddenForumActivity.hideLoadingView(forbiddenForumActivity.d);
                }
                if (ListUtils.isEmpty(this.a.c.g().a)) {
                    this.a.showNoDataView();
                    return;
                }
                this.a.k.notifyDataSetChanged();
                if (cc8Var == null || cc8Var.b) {
                    return;
                }
                this.a.O1();
            }
        }

        @Override // com.repackage.bc8.b
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                ForbiddenForumActivity forbiddenForumActivity = this.a;
                forbiddenForumActivity.hideLoadingView(forbiddenForumActivity.d);
                ForbiddenForumActivity forbiddenForumActivity2 = this.a;
                forbiddenForumActivity2.showNetRefreshView(forbiddenForumActivity2.d, str, true);
                this.a.b.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements nr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForbiddenForumActivity a;

        public f(ForbiddenForumActivity forbiddenForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbiddenForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forbiddenForumActivity;
        }

        @Override // com.repackage.nr4.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements nr4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ForbiddenForumActivity c;

        public g(ForbiddenForumActivity forbiddenForumActivity, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbiddenForumActivity, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = forbiddenForumActivity;
            this.a = str;
            this.b = str2;
        }

        @Override // com.repackage.nr4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.K1();
                this.c.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.c.getActivity()).createNormalCfg(this.a, null)));
                TiebaStatic.log(new StatisticItem("c14058").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.b));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements nr4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ForbiddenForumActivity b;

        public h(ForbiddenForumActivity forbiddenForumActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbiddenForumActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = forbiddenForumActivity;
            this.a = str;
        }

        @Override // com.repackage.nr4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.K1();
                this.b.M1(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForbiddenForumActivity a;

        public i(ForbiddenForumActivity forbiddenForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbiddenForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forbiddenForumActivity;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.f = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ForbiddenForumActivity b;

        public j(ForbiddenForumActivity forbiddenForumActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbiddenForumActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = forbiddenForumActivity;
            this.a = str;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                this.b.h.a(this.a);
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForbiddenForumActivity a;

        public k(ForbiddenForumActivity forbiddenForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbiddenForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forbiddenForumActivity;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BarImageView a;
        public TextView b;
        public int c;
        public final /* synthetic */ ForbiddenForumActivity d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(@NonNull ForbiddenForumActivity forbiddenForumActivity, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbiddenForumActivity, view2};
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
            this.d = forbiddenForumActivity;
            this.c = 3;
            BarImageView barImageView = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e6a);
            this.a = barImageView;
            barImageView.setPlaceHolder(1);
            this.a.setShowOval(true);
            this.a.setAutoChangeStyle(true);
            this.a.setStrokeWith(pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.a.setStrokeColorResId(R.color.CAM_X0401);
            this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091fb6);
        }

        public void a(ac8 ac8Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ac8Var) == null) || ac8Var == null) {
                return;
            }
            this.a.J(ac8Var.a, 10, false);
            TextView textView = this.b;
            textView.setText(ac8Var.b + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0650));
            b(TbadkCoreApplication.getInst().getSkinType());
        }

        public final void b(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.c == i) {
                return;
            }
            SkinManager.setBackgroundColor(this.itemView, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
            this.c = i;
        }
    }

    public ForbiddenForumActivity() {
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
        this.j = new c(this);
        this.k = new d(this);
        this.l = new e(this);
        this.m = new a(this);
        this.n = new b(this, CmdConfigHttp.CMD_CANCEL_FORBIDDEN_FORUM);
    }

    public final void K1() {
        lr4 lr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (lr4Var = this.f) != null && lr4Var.isShowing()) {
            this.f.dismiss();
        }
    }

    public final void L1(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) && this.f == null) {
            if (this.g == null) {
                nr4 nr4Var = new nr4(this);
                this.g = nr4Var;
                nr4Var.m(new f(this));
            }
            ArrayList arrayList = new ArrayList();
            jr4 jr4Var = new jr4(this.g);
            jr4Var.n(getString(R.string.obfuscated_res_0x7f0f0ce5));
            jr4Var.m(new g(this, str, str2));
            arrayList.add(jr4Var);
            jr4 jr4Var2 = new jr4(this.g);
            jr4Var2.n(getString(R.string.obfuscated_res_0x7f0f036c));
            jr4Var2.m(new h(this, str2));
            arrayList.add(jr4Var2);
            this.g.j(arrayList);
            nr4 nr4Var2 = this.g;
            nr4Var2.q(str + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0650));
            lr4 lr4Var = new lr4(getPageContext(), this.g);
            this.f = lr4Var;
            lr4Var.setOnDismissListener(new i(this));
            this.f.m();
        }
    }

    public final void M1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            cr4 cr4Var = new cr4(getActivity());
            cr4Var.setMessage(getString(R.string.obfuscated_res_0x7f0f0428));
            cr4Var.setOnlyMessageShowCenter(true);
            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0427, new j(this, str));
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new k(this));
            cr4Var.create(getPageContext()).show();
        }
    }

    public void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.e == null) {
                PbListView pbListView = new PbListView(this);
                this.e = pbListView;
                pbListView.a();
                this.e.p(R.color.CAM_X0205);
                this.e.x();
                this.e.E(SkinManager.getColor(R.color.CAM_X0107));
                this.e.G(R.dimen.tbfontsize33);
                this.e.A(R.color.CAM_X0110);
                this.b.setNextPage(this.e);
            }
            this.e.J();
            this.e.Q();
            this.e.C(this.b.getContext().getString(R.string.obfuscated_res_0x7f0f09e6));
            this.e.L(1);
        }
    }

    public void O1() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (pbListView = this.e) == null) {
            return;
        }
        pbListView.l(pi.f(this, R.dimen.tbds180));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0204);
            this.a.onChangeSkinType(getPageContext(), i2);
            nr4 nr4Var = this.g;
            if (nr4Var != null) {
                nr4Var.i();
            }
            RecyclerView.Adapter adapter = this.k;
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0036);
            this.d = findViewById(R.id.obfuscated_res_0x7f091b72);
            bc8 bc8Var = new bc8(getUniqueId());
            this.c = bc8Var;
            bc8Var.k(this.l);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f09158d);
            this.a = navigationBar;
            navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0edd));
            this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.a.isShowBottomLine(true);
            BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.obfuscated_res_0x7f091aba);
            this.b = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            this.b.setAdapter(this.k);
            this.b.setOnSrollToBottomListener(this.j);
            this.b.setOnItemClickListener(this.m);
            this.c.j();
            showLoadingView(this.d);
            this.h = new zb8();
            registerListener(this.n);
            TiebaStatic.log(new StatisticItem("c14056").param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            hideNetRefreshView(this.d);
            this.b.setVisibility(0);
            this.c.j();
            showLoadingView(this.d);
        }
    }

    public final void showNoDataView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.i == null) {
                this.i = NoDataViewFactory.a(this, this.d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, pi.f(this, R.dimen.tbds308) + this.a.getBottom()), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c4f), null);
                NoDataViewFactory.d.a aVar = new NoDataViewFactory.d.a();
                aVar.i(NoDataViewFactory.ImgType.CREATE);
                this.i.setImgOption(aVar.f());
            }
            if (this.i.getVisibility() == 0) {
                return;
            }
            this.i.f(getPageContext(), TbadkApplication.getInst().getSkinType());
            this.i.setVisibility(0);
        }
    }
}
