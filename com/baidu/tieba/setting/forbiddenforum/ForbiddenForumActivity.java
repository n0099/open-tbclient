package com.baidu.tieba.setting.forbiddenforum;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
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
import com.repackage.aa8;
import com.repackage.dq4;
import com.repackage.kq4;
import com.repackage.li;
import com.repackage.mq4;
import com.repackage.oq4;
import com.repackage.x98;
import com.repackage.y98;
import com.repackage.z98;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ForbiddenForumActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView.Adapter adapter;
    public mq4 bottomDialog;
    public oq4 bottomDialogView;
    public HttpMessageListener cancelForbiddenListener;
    public x98 cancelModel;
    public PbListView loadMoreView;
    public z98 model;
    public NavigationBar navigationBar;
    public NoDataView noDataView;
    public z98.b onDataResListener;
    public BdRecyclerView.i onItemClickListener;
    public BdListView.p onScrollToBottomListener;
    public BdRecyclerView recyclerView;
    public View rootView;

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.model == null) {
                return;
            }
            if (this.a.model.g() == null && ListUtils.isEmpty(this.a.model.g().a)) {
                return;
            }
            y98 y98Var = this.a.model.g().a.get(i);
            this.a.showBottomDialog(y98Var.b, y98Var.c);
        }
    }

    /* loaded from: classes3.dex */
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
                        bdTopToast.h(this.a.getString(R.string.obfuscated_res_0x7f0f037a));
                        bdTopToast.i(true);
                        TiebaStatic.log(new StatisticItem("c14057").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", str));
                        this.a.model.f(str);
                        this.a.adapter.notifyDataSetChanged();
                    } else {
                        bdTopToast.h(this.a.getString(R.string.obfuscated_res_0x7f0f0379));
                        bdTopToast.i(false);
                    }
                    bdTopToast.j((ViewGroup) this.a.rootView);
                }
            }
            str = "";
            BdTopToast bdTopToast2 = new BdTopToast(this.a);
            if (httpResponsedMessage.getError() != 0) {
            }
            bdTopToast2.j((ViewGroup) this.a.rootView);
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.model.g().b) {
                this.a.model.j();
                this.a.showLoadMoreView();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.model.g().a.size() : invokeV.intValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder, i) == null) {
                ((l) viewHolder).a(this.a.model.g().a.get(i));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) ? new l(this.a, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d029b, viewGroup, false)) : (RecyclerView.ViewHolder) invokeLI.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements z98.b {
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

        @Override // com.repackage.z98.b
        public void a(aa8 aa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aa8Var) == null) {
                if (this.a.isLoadingViewAttached()) {
                    ForbiddenForumActivity forbiddenForumActivity = this.a;
                    forbiddenForumActivity.hideLoadingView(forbiddenForumActivity.rootView);
                }
                if (ListUtils.isEmpty(this.a.model.g().a)) {
                    this.a.showNoDataView();
                    return;
                }
                this.a.adapter.notifyDataSetChanged();
                if (aa8Var == null || aa8Var.b) {
                    return;
                }
                this.a.showLoadMoreViewNoMore();
            }
        }

        @Override // com.repackage.z98.b
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                ForbiddenForumActivity forbiddenForumActivity = this.a;
                forbiddenForumActivity.hideLoadingView(forbiddenForumActivity.rootView);
                ForbiddenForumActivity forbiddenForumActivity2 = this.a;
                forbiddenForumActivity2.showNetRefreshView(forbiddenForumActivity2.rootView, str, true);
                this.a.recyclerView.setVisibility(8);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements oq4.c {
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

        @Override // com.repackage.oq4.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.hideBottomDialog();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements oq4.d {
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

        @Override // com.repackage.oq4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.hideBottomDialog();
                this.c.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.c.getActivity()).createNormalCfg(this.a, null)));
                TiebaStatic.log(new StatisticItem("c14058").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.b));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements oq4.d {
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

        @Override // com.repackage.oq4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.hideBottomDialog();
                this.b.showCancelForbiddenDialog(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.bottomDialog = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements dq4.e {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                this.b.cancelModel.a(this.a);
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements dq4.e {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            BarImageView barImageView = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e69);
            this.a = barImageView;
            barImageView.setPlaceHolder(1);
            this.a.setShowOval(true);
            this.a.setAutoChangeStyle(true);
            this.a.setStrokeWith(li.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.a.setStrokeColorResId(R.color.CAM_X0401);
            this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f12);
        }

        public void a(y98 y98Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, y98Var) == null) || y98Var == null) {
                return;
            }
            this.a.K(y98Var.a, 10, false);
            TextView textView = this.b;
            textView.setText(y98Var.b + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0652));
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
        this.onScrollToBottomListener = new c(this);
        this.adapter = new d(this);
        this.onDataResListener = new e(this);
        this.onItemClickListener = new a(this);
        this.cancelForbiddenListener = new b(this, CmdConfigHttp.CMD_CANCEL_FORBIDDEN_FORUM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideBottomDialog() {
        mq4 mq4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, this) == null) && (mq4Var = this.bottomDialog) != null && mq4Var.isShowing()) {
            this.bottomDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBottomDialog(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, this, str, str2) == null) && this.bottomDialog == null) {
            if (this.bottomDialogView == null) {
                oq4 oq4Var = new oq4(this);
                this.bottomDialogView = oq4Var;
                oq4Var.m(new f(this));
            }
            ArrayList arrayList = new ArrayList();
            kq4 kq4Var = new kq4(this.bottomDialogView);
            kq4Var.n(getString(R.string.obfuscated_res_0x7f0f0cec));
            kq4Var.m(new g(this, str, str2));
            arrayList.add(kq4Var);
            kq4 kq4Var2 = new kq4(this.bottomDialogView);
            kq4Var2.n(getString(R.string.obfuscated_res_0x7f0f0378));
            kq4Var2.m(new h(this, str2));
            arrayList.add(kq4Var2);
            this.bottomDialogView.j(arrayList);
            oq4 oq4Var2 = this.bottomDialogView;
            oq4Var2.q(str + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0652));
            mq4 mq4Var = new mq4(getPageContext(), this.bottomDialogView);
            this.bottomDialog = mq4Var;
            mq4Var.setOnDismissListener(new i(this));
            this.bottomDialog.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCancelForbiddenDialog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, str) == null) {
            dq4 dq4Var = new dq4(getActivity());
            dq4Var.setMessage(getString(R.string.obfuscated_res_0x7f0f042f));
            dq4Var.setOnlyMessageShowCenter(true);
            dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f042e, new j(this, str));
            dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new k(this));
            dq4Var.create(getPageContext()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            if (this.noDataView == null) {
                this.noDataView = NoDataViewFactory.a(this, this.rootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, li.f(this, R.dimen.tbds308) + this.navigationBar.getBottom()), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c58), null);
                NoDataViewFactory.d.a aVar = new NoDataViewFactory.d.a();
                aVar.i(NoDataViewFactory.ImgType.CREATE);
                this.noDataView.setImgOption(aVar.f());
            }
            if (this.noDataView.getVisibility() == 0) {
                return;
            }
            this.noDataView.f(getPageContext(), TbadkApplication.getInst().getSkinType());
            this.noDataView.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.rootView, R.color.CAM_X0204);
            this.navigationBar.onChangeSkinType(getPageContext(), i2);
            oq4 oq4Var = this.bottomDialogView;
            if (oq4Var != null) {
                oq4Var.i();
            }
            RecyclerView.Adapter adapter = this.adapter;
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0036);
            this.rootView = findViewById(R.id.obfuscated_res_0x7f091adb);
            z98 z98Var = new z98(getUniqueId());
            this.model = z98Var;
            z98Var.k(this.onDataResListener);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0914f2);
            this.navigationBar = navigationBar;
            navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0ed8));
            this.navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.navigationBar.isShowBottomLine(true);
            BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.obfuscated_res_0x7f091a1b);
            this.recyclerView = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            this.recyclerView.setAdapter(this.adapter);
            this.recyclerView.setOnSrollToBottomListener(this.onScrollToBottomListener);
            this.recyclerView.setOnItemClickListener(this.onItemClickListener);
            this.model.j();
            showLoadingView(this.rootView);
            this.cancelModel = new x98();
            registerListener(this.cancelForbiddenListener);
            TiebaStatic.log(new StatisticItem("c14056").param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            hideNetRefreshView(this.rootView);
            this.recyclerView.setVisibility(0);
            this.model.j();
            showLoadingView(this.rootView);
        }
    }

    public void showLoadMoreView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.loadMoreView == null) {
                PbListView pbListView = new PbListView(this);
                this.loadMoreView = pbListView;
                pbListView.a();
                this.loadMoreView.p(R.color.CAM_X0205);
                this.loadMoreView.x();
                this.loadMoreView.E(SkinManager.getColor(R.color.CAM_X0107));
                this.loadMoreView.G(R.dimen.tbfontsize33);
                this.loadMoreView.A(R.color.CAM_X0110);
                this.recyclerView.setNextPage(this.loadMoreView);
            }
            this.loadMoreView.J();
            this.loadMoreView.Q();
            this.loadMoreView.C(this.recyclerView.getContext().getString(R.string.obfuscated_res_0x7f0f09f4));
            this.loadMoreView.L(1);
        }
    }

    public void showLoadMoreViewNoMore() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (pbListView = this.loadMoreView) == null) {
            return;
        }
        pbListView.l(li.f(this, R.dimen.tbds180));
    }
}
