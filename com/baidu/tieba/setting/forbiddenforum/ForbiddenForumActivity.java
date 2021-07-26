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
import d.a.p0.s.s.a;
import d.a.p0.s.s.l;
import d.a.q0.z2.a.c;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ForbiddenForumActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView.Adapter adapter;
    public d.a.p0.s.s.j bottomDialog;
    public d.a.p0.s.s.l bottomDialogView;
    public HttpMessageListener cancelForbiddenListener;
    public d.a.q0.z2.a.a cancelModel;
    public PbListView loadMoreView;
    public d.a.q0.z2.a.c model;
    public NavigationBar navigationBar;
    public NoDataView noDataView;
    public c.b onDataResListener;
    public BdRecyclerView.i onItemClickListener;
    public BdListView.p onScrollToBottomListener;
    public BdRecyclerView recyclerView;
    public View rootView;

    /* loaded from: classes4.dex */
    public class a implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForbiddenForumActivity f20830e;

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
            this.f20830e = forbiddenForumActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f20830e.model == null) {
                return;
            }
            if (this.f20830e.model.g() == null && ListUtils.isEmpty(this.f20830e.model.g().f67241a)) {
                return;
            }
            d.a.q0.z2.a.b bVar = this.f20830e.model.g().f67241a.get(i2);
            this.f20830e.showBottomDialog(bVar.f67233b, bVar.f67234c);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForbiddenForumActivity f20831a;

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
            this.f20831a = forbiddenForumActivity;
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
                    BdTopToast bdTopToast = new BdTopToast(this.f20831a);
                    if (httpResponsedMessage.getError() != 0) {
                        bdTopToast.h(this.f20831a.getString(R.string.cancel_forbidden_sucessful));
                        bdTopToast.i(true);
                        TiebaStatic.log(new StatisticItem("c14057").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", str));
                        this.f20831a.model.f(str);
                        this.f20831a.adapter.notifyDataSetChanged();
                    } else {
                        bdTopToast.h(this.f20831a.getString(R.string.cancel_forbidden_failed));
                        bdTopToast.i(false);
                    }
                    bdTopToast.j((ViewGroup) this.f20831a.rootView);
                }
            }
            str = "";
            BdTopToast bdTopToast2 = new BdTopToast(this.f20831a);
            if (httpResponsedMessage.getError() != 0) {
            }
            bdTopToast2.j((ViewGroup) this.f20831a.rootView);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForbiddenForumActivity f20832e;

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
            this.f20832e = forbiddenForumActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f20832e.model.g().f67242b) {
                this.f20832e.model.j();
                this.f20832e.showLoadMoreView();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends RecyclerView.Adapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForbiddenForumActivity f20833a;

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
            this.f20833a = forbiddenForumActivity;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20833a.model.g().f67241a.size() : invokeV.intValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder, i2) == null) {
                ((l) viewHolder).a(this.f20833a.model.g().f67241a.get(i2));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2)) == null) ? new l(this.f20833a, LayoutInflater.from(this.f20833a).inflate(R.layout.forbidden_forum_item_view, viewGroup, false)) : (RecyclerView.ViewHolder) invokeLI.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForbiddenForumActivity f20834a;

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
            this.f20834a = forbiddenForumActivity;
        }

        @Override // d.a.q0.z2.a.c.b
        public void a(d.a.q0.z2.a.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
                if (this.f20834a.isLoadingViewAttached()) {
                    ForbiddenForumActivity forbiddenForumActivity = this.f20834a;
                    forbiddenForumActivity.hideLoadingView(forbiddenForumActivity.rootView);
                }
                if (ListUtils.isEmpty(this.f20834a.model.g().f67241a)) {
                    this.f20834a.showNoDataView();
                    return;
                }
                this.f20834a.adapter.notifyDataSetChanged();
                if (dVar == null || dVar.f67242b) {
                    return;
                }
                this.f20834a.showLoadMoreViewNoMore();
            }
        }

        @Override // d.a.q0.z2.a.c.b
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                ForbiddenForumActivity forbiddenForumActivity = this.f20834a;
                forbiddenForumActivity.hideLoadingView(forbiddenForumActivity.rootView);
                ForbiddenForumActivity forbiddenForumActivity2 = this.f20834a;
                forbiddenForumActivity2.showNetRefreshView(forbiddenForumActivity2.rootView, str, true);
                this.f20834a.recyclerView.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForbiddenForumActivity f20835a;

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
            this.f20835a = forbiddenForumActivity;
        }

        @Override // d.a.p0.s.s.l.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20835a.hideBottomDialog();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f20836a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f20837b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ForbiddenForumActivity f20838c;

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
            this.f20838c = forbiddenForumActivity;
            this.f20836a = str;
            this.f20837b = str2;
        }

        @Override // d.a.p0.s.s.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20838c.hideBottomDialog();
                this.f20838c.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f20838c.getActivity()).createNormalCfg(this.f20836a, null)));
                TiebaStatic.log(new StatisticItem("c14058").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f20837b));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f20839a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ForbiddenForumActivity f20840b;

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
            this.f20840b = forbiddenForumActivity;
            this.f20839a = str;
        }

        @Override // d.a.p0.s.s.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20840b.hideBottomDialog();
                this.f20840b.showCancelForbiddenDialog(this.f20839a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForbiddenForumActivity f20841e;

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
            this.f20841e = forbiddenForumActivity;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f20841e.bottomDialog = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20842e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForbiddenForumActivity f20843f;

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
            this.f20843f = forbiddenForumActivity;
            this.f20842e = str;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f20843f.cancelModel.a(this.f20842e);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForbiddenForumActivity f20844e;

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
            this.f20844e = forbiddenForumActivity;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f20845a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f20846b;

        /* renamed from: c  reason: collision with root package name */
        public int f20847c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ForbiddenForumActivity f20848d;

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
            this.f20848d = forbiddenForumActivity;
            this.f20847c = 3;
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.img_bar);
            this.f20845a = barImageView;
            barImageView.setPlaceHolder(1);
            this.f20845a.setShowOval(true);
            this.f20845a.setAutoChangeStyle(true);
            this.f20845a.setStrokeWith(d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f20845a.setStrokeColorResId(R.color.CAM_X0401);
            this.f20845a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f20846b = (TextView) view.findViewById(R.id.text_bar);
        }

        public void a(d.a.q0.z2.a.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null) {
                return;
            }
            this.f20845a.M(bVar.f67232a, 10, false);
            TextView textView = this.f20846b;
            textView.setText(bVar.f67233b + TbadkCoreApplication.getInst().getString(R.string.forum));
            b(TbadkCoreApplication.getInst().getSkinType());
        }

        public final void b(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f20847c == i2) {
                return;
            }
            SkinManager.setBackgroundColor(this.itemView, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.f20846b, R.color.CAM_X0105);
            this.f20847c = i2;
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
        d.a.p0.s.s.j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, this) == null) && (jVar = this.bottomDialog) != null && jVar.isShowing()) {
            this.bottomDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBottomDialog(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, this, str, str2) == null) && this.bottomDialog == null) {
            if (this.bottomDialogView == null) {
                d.a.p0.s.s.l lVar = new d.a.p0.s.s.l(this);
                this.bottomDialogView = lVar;
                lVar.m(new f(this));
            }
            ArrayList arrayList = new ArrayList();
            d.a.p0.s.s.h hVar = new d.a.p0.s.s.h(this.bottomDialogView);
            hVar.n(getString(R.string.open_the_forum));
            hVar.m(new g(this, str, str2));
            arrayList.add(hVar);
            d.a.p0.s.s.h hVar2 = new d.a.p0.s.s.h(this.bottomDialogView);
            hVar2.n(getString(R.string.cancel_forbidden));
            hVar2.m(new h(this, str2));
            arrayList.add(hVar2);
            this.bottomDialogView.k(arrayList);
            d.a.p0.s.s.l lVar2 = this.bottomDialogView;
            lVar2.q(str + TbadkCoreApplication.getInst().getString(R.string.forum));
            d.a.p0.s.s.j jVar = new d.a.p0.s.s.j(getPageContext(), this.bottomDialogView);
            this.bottomDialog = jVar;
            jVar.setOnDismissListener(new i(this));
            this.bottomDialog.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCancelForbiddenDialog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, str) == null) {
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(getActivity());
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
                this.noDataView = NoDataViewFactory.a(this, this.rootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, d.a.d.e.p.l.g(this, R.dimen.tbds308) + this.navigationBar.getBottom()), NoDataViewFactory.e.a(R.string.no_forbidden_forum), null);
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
            d.a.p0.s.s.l lVar = this.bottomDialogView;
            if (lVar != null) {
                lVar.j();
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
            d.a.q0.z2.a.c cVar = new d.a.q0.z2.a.c(getUniqueId());
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
            this.cancelModel = new d.a.q0.z2.a.a();
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
                this.loadMoreView.o(R.color.CAM_X0205);
                this.loadMoreView.v();
                this.loadMoreView.C(SkinManager.getColor(R.color.CAM_X0107));
                this.loadMoreView.E(R.dimen.tbfontsize33);
                this.loadMoreView.y(R.color.CAM_X0110);
                this.recyclerView.setNextPage(this.loadMoreView);
            }
            this.loadMoreView.H();
            this.loadMoreView.O();
            this.loadMoreView.A(this.recyclerView.getContext().getString(R.string.list_loading));
            this.loadMoreView.J(1);
        }
    }

    public void showLoadMoreViewNoMore() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (pbListView = this.loadMoreView) == null) {
            return;
        }
        pbListView.k(d.a.d.e.p.l.g(this, R.dimen.tbds180));
    }
}
