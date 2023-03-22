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
import com.baidu.tieba.g05;
import com.baidu.tieba.hi;
import com.baidu.tieba.i05;
import com.baidu.tieba.k05;
import com.baidu.tieba.u39;
import com.baidu.tieba.v39;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.w39;
import com.baidu.tieba.x39;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ForbiddenForumActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public BdRecyclerView b;
    public w39 c;
    public View d;
    public PbListView e;
    public i05 f;
    public k05 g;
    public u39 h;
    public NoDataView i;
    public BdListView.p j;
    public RecyclerView.Adapter k;
    public w39.b l;
    public BdRecyclerView.i m;
    public HttpMessageListener n;

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.c != null) {
                if (this.a.c.g() != null || !ListUtils.isEmpty(this.a.c.g().a)) {
                    v39 v39Var = this.a.c.g().a.get(i);
                    this.a.L1(v39Var.b, v39Var.c);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || httpResponsedMessage == null) {
                return;
            }
            if (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                if (httpMessage.getParams() != null) {
                    str = String.valueOf(httpMessage.getParams().get("forum_id"));
                    BdTopToast bdTopToast = new BdTopToast(this.a);
                    if (httpResponsedMessage.getError() != 0) {
                        bdTopToast.g(this.a.getString(R.string.obfuscated_res_0x7f0f0392));
                        bdTopToast.h(true);
                        TiebaStatic.log(new StatisticItem("c14057").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", str));
                        this.a.c.f(str);
                        this.a.k.notifyDataSetChanged();
                    } else {
                        bdTopToast.g(this.a.getString(R.string.obfuscated_res_0x7f0f0391));
                        bdTopToast.h(false);
                    }
                    bdTopToast.i((ViewGroup) this.a.d);
                }
            }
            str = "";
            BdTopToast bdTopToast2 = new BdTopToast(this.a);
            if (httpResponsedMessage.getError() != 0) {
            }
            bdTopToast2.i((ViewGroup) this.a.d);
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.c.g().a.size();
            }
            return invokeV.intValue;
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
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                return new l(this.a, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d02ba, viewGroup, false));
            }
            return (RecyclerView.ViewHolder) invokeLI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements w39.b {
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

        @Override // com.baidu.tieba.w39.b
        public void a(x39 x39Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x39Var) == null) {
                if (this.a.isLoadingViewAttached()) {
                    ForbiddenForumActivity forbiddenForumActivity = this.a;
                    forbiddenForumActivity.hideLoadingView(forbiddenForumActivity.d);
                }
                if (ListUtils.isEmpty(this.a.c.g().a)) {
                    this.a.showNoDataView();
                    return;
                }
                this.a.k.notifyDataSetChanged();
                if (x39Var != null && !x39Var.b) {
                    this.a.O1();
                }
            }
        }

        @Override // com.baidu.tieba.w39.b
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

    /* loaded from: classes6.dex */
    public class f implements k05.c {
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

        @Override // com.baidu.tieba.k05.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K1();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements k05.e {
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

        @Override // com.baidu.tieba.k05.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.K1();
                this.c.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.c.getActivity()).createNormalCfg(this.a, null)));
                TiebaStatic.log(new StatisticItem("c14058").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.b));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements k05.e {
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

        @Override // com.baidu.tieba.k05.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.K1();
                this.b.M1(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, dialogInterface) != null) {
                return;
            }
            this.a.f = null;
        }
    }

    /* loaded from: classes6.dex */
    public class j implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                this.b.h.a(this.a);
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
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
            BarImageView barImageView = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f091029);
            this.a = barImageView;
            barImageView.setPlaceHolder(1);
            this.a.setShowOval(true);
            this.a.setAutoChangeStyle(true);
            this.a.setStrokeWith(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.a.setStrokeColorResId(R.color.CAM_X0401);
            this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092309);
        }

        public void a(v39 v39Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, v39Var) != null) || v39Var == null) {
                return;
            }
            this.a.M(v39Var.a, 10, false);
            TextView textView = this.b;
            textView.setText(v39Var.b + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f06bd));
            b(TbadkCoreApplication.getInst().getSkinType());
        }

        public final void b(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && this.c != i) {
                SkinManager.setBackgroundColor(this.itemView, R.color.CAM_X0205);
                SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
                this.c = i;
            }
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

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0204);
            this.a.onChangeSkinType(getPageContext(), i2);
            k05 k05Var = this.g;
            if (k05Var != null) {
                k05Var.j();
            }
            RecyclerView.Adapter adapter = this.k;
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    public final void K1() {
        i05 i05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (i05Var = this.f) != null && i05Var.isShowing()) {
            this.f.dismiss();
        }
    }

    public void O1() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (pbListView = this.e) == null) {
            return;
        }
        pbListView.n(hi.g(this, R.dimen.tbds180));
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

    public final void L1(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) != null) || this.f != null) {
            return;
        }
        if (this.g == null) {
            k05 k05Var = new k05(this);
            this.g = k05Var;
            k05Var.n(new f(this));
        }
        ArrayList arrayList = new ArrayList();
        g05 g05Var = new g05(this.g);
        g05Var.n(getString(R.string.obfuscated_res_0x7f0f0ddf));
        g05Var.m(new g(this, str, str2));
        arrayList.add(g05Var);
        g05 g05Var2 = new g05(this.g);
        g05Var2.n(getString(R.string.obfuscated_res_0x7f0f0390));
        g05Var2.m(new h(this, str2));
        arrayList.add(g05Var2);
        this.g.k(arrayList);
        k05 k05Var2 = this.g;
        k05Var2.s(str + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f06bd));
        i05 i05Var = new i05(getPageContext(), this.g);
        this.f = i05Var;
        i05Var.setOnDismissListener(new i(this));
        this.f.k();
    }

    public final void M1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            zz4 zz4Var = new zz4(getActivity());
            zz4Var.setMessage(getString(R.string.obfuscated_res_0x7f0f045f));
            zz4Var.setOnlyMessageShowCenter(true);
            zz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f045e, new j(this, str));
            zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038e, new k(this));
            zz4Var.create(getPageContext()).show();
        }
    }

    public void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.e == null) {
                PbListView pbListView = new PbListView(this);
                this.e = pbListView;
                pbListView.a();
                this.e.r(R.color.CAM_X0205);
                this.e.A();
                this.e.H(SkinManager.getColor(R.color.CAM_X0107));
                this.e.J(R.dimen.tbfontsize33);
                this.e.D(R.color.CAM_X0110);
                this.b.setNextPage(this.e);
            }
            this.e.M();
            this.e.T();
            this.e.F(this.b.getContext().getString(R.string.list_loading));
            this.e.O(1);
        }
    }

    public final void showNoDataView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.i == null) {
                this.i = NoDataViewFactory.a(this, this.d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, hi.g(this, R.dimen.tbds308) + this.a.getBottom()), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0d47), null);
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0038);
            this.d = findViewById(R.id.obfuscated_res_0x7f091e45);
            w39 w39Var = new w39(getUniqueId());
            this.c = w39Var;
            w39Var.k(this.l);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.a = navigationBar;
            navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0fdf));
            this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.a.isShowBottomLine(true);
            BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.recycler_view);
            this.b = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            this.b.setAdapter(this.k);
            this.b.setOnSrollToBottomListener(this.j);
            this.b.setOnItemClickListener(this.m);
            this.c.j();
            showLoadingView(this.d);
            this.h = new u39();
            registerListener(this.n);
            TiebaStatic.log(new StatisticItem("c14056").param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }
}
