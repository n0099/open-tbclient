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
import c.a.q0.s.s.a;
import c.a.q0.s.s.i;
import c.a.r0.k3.a.c;
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
import com.baidu.tbadk.core.dialog.PopupDialog;
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
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class ForbiddenForumActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView.Adapter adapter;
    public PopupDialog bottomDialog;
    public c.a.q0.s.s.i bottomDialogView;
    public HttpMessageListener cancelForbiddenListener;
    public c.a.r0.k3.a.a cancelModel;
    public PbListView loadMoreView;
    public c.a.r0.k3.a.c model;
    public NavigationBar navigationBar;
    public NoDataView noDataView;
    public c.b onDataResListener;
    public BdRecyclerView.i onItemClickListener;
    public BdListView.p onScrollToBottomListener;
    public BdRecyclerView recyclerView;
    public View rootView;

    /* loaded from: classes11.dex */
    public class a implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForbiddenForumActivity f48896e;

        public a(ForbiddenForumActivity forbiddenForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbiddenForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48896e = forbiddenForumActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f48896e.model == null) {
                return;
            }
            if (this.f48896e.model.g() == null && ListUtils.isEmpty(this.f48896e.model.g().a)) {
                return;
            }
            c.a.r0.k3.a.b bVar = this.f48896e.model.g().a.get(i2);
            this.f48896e.showBottomDialog(bVar.f18654b, bVar.f18655c);
        }
    }

    /* loaded from: classes11.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForbiddenForumActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ForbiddenForumActivity forbiddenForumActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbiddenForumActivity, Integer.valueOf(i2)};
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
            this.a = forbiddenForumActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0075  */
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
                        bdTopToast.setContent(this.a.getString(R.string.cancel_forbidden_sucessful));
                        bdTopToast.setIcon(true);
                        TiebaStatic.log(new StatisticItem("c14057").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", str));
                        this.a.model.f(str);
                        this.a.adapter.notifyDataSetChanged();
                    } else {
                        bdTopToast.setContent(this.a.getString(R.string.cancel_forbidden_failed));
                        bdTopToast.setIcon(false);
                    }
                    bdTopToast.show((ViewGroup) this.a.rootView);
                }
            }
            str = "";
            BdTopToast bdTopToast2 = new BdTopToast(this.a);
            if (httpResponsedMessage.getError() != 0) {
            }
            bdTopToast2.show((ViewGroup) this.a.rootView);
        }
    }

    /* loaded from: classes11.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForbiddenForumActivity f48897e;

        public c(ForbiddenForumActivity forbiddenForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbiddenForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48897e = forbiddenForumActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f48897e.model.g().f18660b) {
                this.f48897e.model.j();
                this.f48897e.showLoadMoreView();
            }
        }
    }

    /* loaded from: classes11.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder, i2) == null) {
                ((l) viewHolder).a(this.a.model.g().a.get(i2));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2)) == null) ? new l(this.a, LayoutInflater.from(this.a).inflate(R.layout.forbidden_forum_item_view, viewGroup, false)) : (RecyclerView.ViewHolder) invokeLI.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public class e implements c.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forbiddenForumActivity;
        }

        @Override // c.a.r0.k3.a.c.b
        public void a(c.a.r0.k3.a.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
                if (this.a.isLoadingViewAttached()) {
                    ForbiddenForumActivity forbiddenForumActivity = this.a;
                    forbiddenForumActivity.hideLoadingView(forbiddenForumActivity.rootView);
                }
                if (ListUtils.isEmpty(this.a.model.g().a)) {
                    this.a.showNoDataView();
                    return;
                }
                this.a.adapter.notifyDataSetChanged();
                if (dVar == null || dVar.f18660b) {
                    return;
                }
                this.a.showLoadMoreViewNoMore();
            }
        }

        @Override // c.a.r0.k3.a.c.b
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                ForbiddenForumActivity forbiddenForumActivity = this.a;
                forbiddenForumActivity.hideLoadingView(forbiddenForumActivity.rootView);
                ForbiddenForumActivity forbiddenForumActivity2 = this.a;
                forbiddenForumActivity2.showNetRefreshView(forbiddenForumActivity2.rootView, str, true);
                this.a.recyclerView.setVisibility(8);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class f implements i.c {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forbiddenForumActivity;
        }

        @Override // c.a.q0.s.s.i.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.hideBottomDialog();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class g implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48898b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ForbiddenForumActivity f48899c;

        public g(ForbiddenForumActivity forbiddenForumActivity, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbiddenForumActivity, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48899c = forbiddenForumActivity;
            this.a = str;
            this.f48898b = str2;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48899c.hideBottomDialog();
                this.f48899c.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f48899c.getActivity()).createNormalCfg(this.a, null)));
                TiebaStatic.log(new StatisticItem("c14058").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f48898b));
            }
        }
    }

    /* loaded from: classes11.dex */
    public class h implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ForbiddenForumActivity f48900b;

        public h(ForbiddenForumActivity forbiddenForumActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbiddenForumActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48900b = forbiddenForumActivity;
            this.a = str;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48900b.hideBottomDialog();
                this.f48900b.showCancelForbiddenDialog(this.a);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class i implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForbiddenForumActivity f48901e;

        public i(ForbiddenForumActivity forbiddenForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbiddenForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48901e = forbiddenForumActivity;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f48901e.bottomDialog = null;
            }
        }
    }

    /* loaded from: classes11.dex */
    public class j implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48902e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForbiddenForumActivity f48903f;

        public j(ForbiddenForumActivity forbiddenForumActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbiddenForumActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48903f = forbiddenForumActivity;
            this.f48902e = str;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f48903f.cancelModel.a(this.f48902e);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class k implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForbiddenForumActivity f48904e;

        public k(ForbiddenForumActivity forbiddenForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbiddenForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48904e = forbiddenForumActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class l extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BarImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f48905b;

        /* renamed from: c  reason: collision with root package name */
        public int f48906c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ForbiddenForumActivity f48907d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(@NonNull ForbiddenForumActivity forbiddenForumActivity, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbiddenForumActivity, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48907d = forbiddenForumActivity;
            this.f48906c = 3;
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.img_bar);
            this.a = barImageView;
            barImageView.setPlaceHolder(1);
            this.a.setShowOval(true);
            this.a.setAutoChangeStyle(true);
            this.a.setStrokeWith(c.a.d.f.p.l.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.a.setStrokeColorResId(R.color.CAM_X0401);
            this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f48905b = (TextView) view.findViewById(R.id.text_bar);
        }

        public void a(c.a.r0.k3.a.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null) {
                return;
            }
            this.a.startLoad(bVar.a, 10, false);
            TextView textView = this.f48905b;
            textView.setText(bVar.f18654b + TbadkCoreApplication.getInst().getString(R.string.forum));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public final void onChangeSkinType(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f48906c == i2) {
                return;
            }
            SkinManager.setBackgroundColor(this.itemView, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.f48905b, R.color.CAM_X0105);
            this.f48906c = i2;
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
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, this) == null) && (popupDialog = this.bottomDialog) != null && popupDialog.isShowing()) {
            this.bottomDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBottomDialog(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, this, str, str2) == null) && this.bottomDialog == null) {
            if (this.bottomDialogView == null) {
                c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(this);
                this.bottomDialogView = iVar;
                iVar.l(new f(this));
            }
            ArrayList arrayList = new ArrayList();
            c.a.q0.s.s.f fVar = new c.a.q0.s.s.f(this.bottomDialogView);
            fVar.m(getString(R.string.open_the_forum));
            fVar.l(new g(this, str, str2));
            arrayList.add(fVar);
            c.a.q0.s.s.f fVar2 = new c.a.q0.s.s.f(this.bottomDialogView);
            fVar2.m(getString(R.string.cancel_forbidden));
            fVar2.l(new h(this, str2));
            arrayList.add(fVar2);
            this.bottomDialogView.j(arrayList);
            c.a.q0.s.s.i iVar2 = this.bottomDialogView;
            iVar2.p(str + TbadkCoreApplication.getInst().getString(R.string.forum));
            PopupDialog popupDialog = new PopupDialog(getPageContext(), this.bottomDialogView);
            this.bottomDialog = popupDialog;
            popupDialog.setOnDismissListener(new i(this));
            this.bottomDialog.showDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCancelForbiddenDialog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, str) == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(getActivity());
            aVar.setMessage(getString(R.string.confirm_cancel_forbidden_forum));
            aVar.setOnlyMessageShowCenter(true);
            aVar.setPositiveButton(R.string.confirm, new j(this, str));
            aVar.setNegativeButton(R.string.cancel, new k(this));
            aVar.create(getPageContext()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            if (this.noDataView == null) {
                this.noDataView = NoDataViewFactory.a(this, this.rootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, c.a.d.f.p.l.f(this, R.dimen.tbds308) + this.navigationBar.getBottom()), NoDataViewFactory.e.a(R.string.no_forbidden_forum), null);
                NoDataViewFactory.d.a aVar = new NoDataViewFactory.d.a();
                aVar.i(NoDataViewFactory.ImgType.CREATE);
                this.noDataView.setImgOption(aVar.f());
            }
            if (this.noDataView.getVisibility() == 0) {
                return;
            }
            this.noDataView.onChangeSkinType(getPageContext(), TbadkApplication.getInst().getSkinType());
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
            c.a.q0.s.s.i iVar = this.bottomDialogView;
            if (iVar != null) {
                iVar.i();
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
            setContentView(R.layout.activity_forbidden_forum);
            this.rootView = findViewById(R.id.root_view);
            c.a.r0.k3.a.c cVar = new c.a.r0.k3.a.c(getUniqueId());
            this.model = cVar;
            cVar.k(this.onDataResListener);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.navigationBar = navigationBar;
            navigationBar.setCenterTextTitle(getString(R.string.privacy_forbidden_forum));
            this.navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.navigationBar.isShowBottomLine(true);
            BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.recycler_view);
            this.recyclerView = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            this.recyclerView.setAdapter(this.adapter);
            this.recyclerView.setOnSrollToBottomListener(this.onScrollToBottomListener);
            this.recyclerView.setOnItemClickListener(this.onItemClickListener);
            this.model.j();
            showLoadingView(this.rootView);
            this.cancelModel = new c.a.r0.k3.a.a();
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
            this.loadMoreView.C(this.recyclerView.getContext().getString(R.string.list_loading));
            this.loadMoreView.L(1);
        }
    }

    public void showLoadMoreViewNoMore() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (pbListView = this.loadMoreView) == null) {
            return;
        }
        pbListView.l(c.a.d.f.p.l.f(this, R.dimen.tbds180));
    }
}
