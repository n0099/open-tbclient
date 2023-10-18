package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.cq8;
import com.baidu.tieba.immessagecenter.mention.MessageCenterActivity;
import com.baidu.tieba.immessagecenter.mention.ReplyMeModel;
import com.baidu.tieba.immessagecenter.mention.ReplyMessageFragment;
import com.baidu.tieba.immessagecenter.mention.reply.InteractionManagerSizer;
import com.baidu.tieba.l45;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class rp8 extends BdBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public long B;
    public DataModel<MessageCenterActivity> C;
    public NewWriteModel.d D;
    public Runnable E;
    public final ReplyMeModel.b F;
    public final RecyclerView.OnScrollListener G;
    public final ReplyMessageFragment a;
    public PbListView b;
    public NoDataView c;
    public bq8 d;
    public BdSwipeRefreshLayout e;
    public BdTypeRecyclerView f;
    public NavigationBarShadowView g;
    public ViewGroup h;
    public m45 i;
    public cq8 j;
    public boolean k;
    public ReplyPrivacyCheckController l;
    public AttentionHostData m;
    public int n;
    public boolean o;
    public InteractionManagerSizer p;
    public View.OnClickListener q;
    public final l45.g r;
    public RecyclerView.OnScrollListener s;
    public final pq8 t;
    public cq8.b u;
    public ReplyMeModel v;
    public kf5 w;
    public vp8 x;
    public String y;
    public String z;

    public void g0(NewsNotifyMessage newsNotifyMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, newsNotifyMessage) != null) || newsNotifyMessage == null) {
        }
    }

    public void i0(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, errorData) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class o extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final LinearSmoothScroller a;
        public final /* synthetic */ rp8 b;

        /* loaded from: classes8.dex */
        public class a extends LinearSmoothScroller {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int getVerticalSnapPreference() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return -1;
                }
                return invokeV.intValue;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(o oVar, Context context) {
                super(context);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Context) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(rp8 rp8Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp8Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rp8Var;
            this.a = new a(this, this.b.mContext.getContext());
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, recyclerView, state, i) == null) {
                this.a.setTargetPosition(i);
                startSmoothScroll(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements cq8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp8 a;

        public a(rp8 rp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp8Var;
        }

        @Override // com.baidu.tieba.cq8.b
        public void onClose() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.j != null) {
                this.a.f.removeHeaderView(this.a.j.f());
                this.a.o = false;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends DataModel<MessageCenterActivity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp8 a;

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String R() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String S() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String T() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean W() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean X() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean Y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.adp.base.BdBaseModel
        public boolean cancelLoadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String getFromForumId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.adp.base.BdBaseModel
        public boolean loadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(rp8 rp8Var, BdPageContext bdPageContext) {
            super(bdPageContext);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp8Var, bdPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((BdPageContext) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp8Var;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String P() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.x != null) {
                    return this.a.x.o();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String Q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.x != null) {
                    return this.a.x.v();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String getForumId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048586, this)) != null) {
                return (String) invokeV.objValue;
            }
            return this.a.y;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public WriteData U(String str) {
            InterceptResult invokeL;
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                WriteData writeData = new WriteData();
                writeData.setForumId(this.a.y);
                writeData.setForumName(this.a.z);
                writeData.setThreadId(this.a.x.v());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (this.a.x.A()) {
                    if (this.a.A > 0) {
                        str3 = String.valueOf(this.a.A);
                    } else {
                        str3 = this.a.x.l().n;
                    }
                    writeData.setFloor(str3);
                } else {
                    writeData.setFloor(this.a.x.o());
                }
                if (this.a.B > 0) {
                    writeData.setRepostId(String.valueOf(this.a.B));
                    if (this.a.x.A()) {
                        str2 = String.valueOf(this.a.B);
                    } else {
                        str2 = null;
                    }
                    writeData.setReSubPostId(str2);
                }
                if (this.a.x != null) {
                    writeData.setBaijiahaoData(this.a.x.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }
            return (WriteData) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp8 a;

        public c(rp8 rp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp8Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m85 m85Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m85Var, writeData, antiData}) != null) || this.a.a.getBaseFragmentActivity() == null) {
                return;
            }
            this.a.a.getBaseFragmentActivity().hideProgressBar();
            this.a.w.a().q();
            if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                this.a.l.setLikeUserData(this.a.m);
                this.a.l.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                return;
            }
            if (postWriteCallBackData != null && m85Var == null && !AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                this.a.a.showToast(postWriteCallBackData.getErrorString());
            }
            if (z && postWriteCallBackData != null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
                statisticItem.param("tid", postWriteCallBackData.getPostId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", 8);
                tm5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this.a.mContext.getPageActivity());
                if (currentVisiblePageExtra != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements ef5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp8 a;

        public d(rp8 rp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp8Var;
        }

        @Override // com.baidu.tieba.ef5
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.getBaseFragmentActivity() != null) {
                this.a.a.getBaseFragmentActivity().showProgressBar();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp8 a;

        public e(rp8 rp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.w != null) {
                this.a.w.B();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp8 a;

        public f(rp8 rp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.w != null && this.a.w.v() != null) {
                BdUtilHelper.showSoftKeyPad(this.a.getPageContext().getPageActivity(), this.a.w.v().j());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements ReplyMeModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp8 a;

        public g(rp8 rp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp8Var;
        }

        @Override // com.baidu.tieba.immessagecenter.mention.ReplyMeModel.b
        public void a(long j, long j2, long j3, String str, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str, Long.valueOf(j4)}) == null) {
                this.a.y = String.valueOf(j);
                this.a.z = str;
                this.a.A = j2;
                this.a.B = j3;
                this.a.o0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp8 a;

        public h(rp8 rp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp8Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (i != 0 && this.a.w != null) {
                    this.a.w.B();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp8 a;

        public i(rp8 rp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null && this.a.a != null) {
                this.a.b.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.a.b.G(null);
                this.a.b.U();
                this.a.a.w2();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements l45.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp8 a;

        public j(rp8 rp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp8Var;
        }

        @Override // com.baidu.tieba.l45.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    if (this.a.a != null) {
                        this.a.a.z2();
                    }
                } else if (this.a.e != null) {
                    this.a.e.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp8 a;

        public k(rp8 rp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp8Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (i != 0) {
                    if (i == 1 || i == 2) {
                        this.a.g.c();
                    }
                } else if (recyclerView.canScrollVertically(-1)) {
                    this.a.g.c();
                } else {
                    this.a.g.a();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements pq8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp8 a;

        public l(rp8 rp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp8Var;
        }

        @Override // com.baidu.tieba.pq8
        public void a(@NonNull mq8 mq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mq8Var) == null) {
                this.a.a.v2(mq8Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp8 a;

        public m(rp8 rp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp8Var;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z && this.a.w != null) {
                this.a.w.J();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n extends bk6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp8 b;

        public n(rp8 rp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rp8Var;
        }

        @Override // com.baidu.tieba.bk6
        public void a(View view2, BaseCardInfo baseCardInfo) {
            long j;
            BaijiahaoData baijiahaoData;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, baseCardInfo) == null) && view2 != null && (baseCardInfo instanceof vp8)) {
                vp8 vp8Var = (vp8) baseCardInfo;
                if (vp8Var.y() && view2.getId() != R.id.obfuscated_res_0x7f091c99 && view2.getId() != R.id.user_name) {
                    vp8Var.E(false);
                    this.b.b0();
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f09176f) {
                    this.b.x = vp8Var;
                    if (vp8Var.A()) {
                        j = JavaTypesHelper.toLong(vp8Var.p(), 0L);
                    } else {
                        j = JavaTypesHelper.toLong(vp8Var.o(), 0L);
                    }
                    long j2 = j;
                    if (this.b.w != null) {
                        this.b.w.X(this.b.x.o());
                        kf5 kf5Var = this.b.w;
                        if (vp8Var.A()) {
                            str = this.b.x.o();
                        } else {
                            str = null;
                        }
                        kf5Var.f0(str);
                    }
                    if (this.b.m == null) {
                        this.b.m = new AttentionHostData();
                    }
                    if (this.b.x != null) {
                        this.b.m.parserWithMetaData(this.b.x.u());
                    }
                    if (this.b.x != null) {
                        baijiahaoData = this.b.x.getBaijiahaoData();
                    } else {
                        baijiahaoData = null;
                    }
                    this.b.v.Q(j2, 2, vp8Var.d(), vp8Var.v(), baijiahaoData);
                    StatisticItem statisticItem = new StatisticItem("c13784");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(statisticItem);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090621) {
                    Object tag = view2.getTag(R.id.item_data);
                    if (StringUtils.isNotNull(vp8Var.getTargetScheme())) {
                        UrlManager.getInstance().dealOneLink(vp8Var.getTargetScheme());
                    } else if (tag instanceof Boolean) {
                        String p = vp8Var.p();
                        if (((Boolean) tag).booleanValue()) {
                            this.b.a.q2(vp8Var, p);
                        } else if (vp8Var.getThreadType() == 40) {
                            this.b.a.u2(vp8Var, true, p);
                        } else {
                            this.b.a.s2(vp8Var, p);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p(rp8 rp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view2 = viewHolder.itemView;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp8 a;

        public q(rp8 rp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp8Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                this.a.b.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.a.b.G(null);
                this.a.b.R();
                this.a.a.w2();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rp8(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {replyMessageFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = R.color.CAM_X0204;
        this.o = false;
        this.q = new i(this);
        this.r = new j(this);
        this.s = new k(this);
        this.t = new l(this);
        this.u = new a(this);
        this.v = null;
        this.E = new f(this);
        this.F = new g(this);
        this.G = new h(this);
        this.a = replyMessageFragment;
        ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(replyMessageFragment.getPageContext());
        this.l = replyPrivacyCheckController;
        replyPrivacyCheckController.setAttentionCallback(new m(this));
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            kf5 kf5Var = this.w;
            if (kf5Var != null && kf5Var.a() != null) {
                this.w.a().z(i2);
            }
            PbListView pbListView = this.b;
            if (pbListView != null) {
                pbListView.J(SkinManager.getColor(R.color.CAM_X0109));
                this.b.e(i2);
            }
            m45 m45Var = this.i;
            if (m45Var != null) {
                m45Var.D(i2);
            }
            NoDataView noDataView = this.c;
            if (noDataView != null) {
                noDataView.f(this.mContext, i2);
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            }
            b0();
            SkinManager.setBackgroundColor(this.f, this.n);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0205);
            cq8 cq8Var = this.j;
            if (cq8Var != null) {
                cq8Var.g(i2, false);
            }
            InteractionManagerSizer interactionManagerSizer = this.p;
            if (interactionManagerSizer != null) {
                interactionManagerSizer.onChangeSkinType(null, i2);
            }
        }
    }

    public void e0(@NonNull List<mq8> list, @NonNull List<mq8> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, list, list2) == null) {
            this.p.g(list2, list);
        }
    }

    public final void k0(BdTypeRecyclerView bdTypeRecyclerView, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, bdTypeRecyclerView, str) == null) && bdTypeRecyclerView != null && str != null) {
            int U = U(bdTypeRecyclerView, str);
            if ((bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) && U >= 0) {
                bdTypeRecyclerView.smoothScrollToPosition(U);
            }
        }
    }

    public void T(int i2) {
        bq8 bq8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && (bq8Var = this.d) != null) {
            bq8Var.a(i2);
        }
    }

    public void l0(ji jiVar) {
        bq8 bq8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, jiVar) == null) && (bq8Var = this.d) != null) {
            bq8Var.g(jiVar);
        }
    }

    public void m0(ii iiVar) {
        bq8 bq8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, iiVar) == null) && (bq8Var = this.d) != null) {
            bq8Var.e(iiVar);
        }
    }

    public void n0(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && this.e != null) {
            if (z && (bdTypeRecyclerView = this.f) != null && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
                this.f.setSelection(0);
            }
            this.e.setRefreshing(z);
        }
    }

    public final void S() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.f == null) {
            return;
        }
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.a.getFragmentActivity()).areNotificationsEnabled();
        StatisticItem statisticItem = new StatisticItem("c13616");
        if (areNotificationsEnabled) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        statisticItem.param("obj_type", i2);
        TiebaStatic.log(statisticItem);
        if (areNotificationsEnabled) {
            cq8 cq8Var = this.j;
            if (cq8Var != null) {
                this.f.removeHeaderView(cq8Var.f());
                this.o = false;
                return;
            }
            return;
        }
        long j2 = SharedPrefHelper.getInstance().getLong("key_im_open_notification_close_time", 0L);
        if (!this.o) {
            if (j2 == 0 || System.currentTimeMillis() - j2 > 604800000) {
                if (this.j == null) {
                    cq8 cq8Var2 = new cq8(this.a.getPageContext(), false);
                    this.j = cq8Var2;
                    cq8Var2.h(this.u);
                }
                this.f.addHeaderView(this.j.f(), 0);
                this.o = true;
            }
        }
    }

    public final int U(BdTypeRecyclerView bdTypeRecyclerView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bdTypeRecyclerView, str)) == null) {
            if (bdTypeRecyclerView != null && !TextUtils.isEmpty(str)) {
                List<yh> data = bdTypeRecyclerView.getData();
                int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
                if (data != null && data.size() > 0) {
                    int size = data.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        yh yhVar = data.get(i2);
                        if ((yhVar instanceof vp8) && str.equals(((vp8) yhVar).o())) {
                            return i2 + headerViewsCount;
                        }
                    }
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public BdSwipeRefreshLayout V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (BdSwipeRefreshLayout) invokeV.objValue;
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.C = new b(this, k4.a(this.a.getPageContext().getContext()));
            this.D = new c(this);
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            S();
        }
    }

    public void b0() {
        bq8 bq8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (bq8Var = this.d) != null) {
            bq8Var.c();
        }
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            kf5 kf5Var = this.w;
            if (kf5Var != null && kf5Var.a() != null && this.w.a().getVisibility() == 0) {
                this.w.B();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            S();
        }
    }

    public final void W(int i2, Intent intent) {
        pd5 pd5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, intent) == null) {
            this.w.a().t();
            this.w.B();
            this.w.a().B();
            if (intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (!(serializableExtra instanceof PbEditorData)) {
                return;
            }
            PbEditorData pbEditorData = (PbEditorData) serializableExtra;
            WriteData writeData = new WriteData();
            writeData.setContent(pbEditorData.getContent());
            writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
            this.w.E(writeData);
            this.w.h0(pbEditorData.getVoiceModel());
            od5 p2 = this.w.a().p(6);
            if (p2 != null && (pd5Var = p2.m) != null) {
                pd5Var.O(new cd5(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.w.J();
            }
        }
    }

    public final void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            kf5 kf5Var = this.w;
            if (kf5Var != null && kf5Var.a() != null && this.w.a().getParent() != null) {
                ((ViewGroup) this.w.a().getParent()).removeView(this.w.a());
            }
            kf5 kf5Var2 = (kf5) new lf5(z).a(this.a.getPageContext().getPageActivity());
            this.w = kf5Var2;
            kf5Var2.R(this.a.getPageContext());
            this.w.e0(this.C);
            this.w.S(3);
            this.w.C(this.a.getPageContext());
            this.w.a().F(true);
            this.w.a().z(TbadkCoreApplication.getInst().getSkinType());
            if (this.w.a() != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                this.h.addView(this.w.a(), layoutParams);
                this.w.a().q();
            }
            this.w.Y(new d(this));
            this.w.U(this.D);
            if (this.w.a() != null) {
                this.w.a().setOnCancelClickListener(new e(this));
            }
        }
    }

    public boolean c0(int i2, int i3, Intent intent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i2, i3, intent)) == null) {
            kf5 kf5Var = this.w;
            if (kf5Var != null) {
                if (i2 == 12005) {
                    kf5Var.n0();
                    SafeHandler.getInst().postDelayed(this.E, 300L);
                }
                this.w.F(i2, i3, intent);
            }
            if (i2 == 25035) {
                W(i3, intent);
                return false;
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.E);
            kf5 kf5Var = this.w;
            if (kf5Var != null) {
                kf5Var.G();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.l;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            ReplyMeModel replyMeModel = this.v;
            if (replyMeModel != null) {
                replyMeModel.R(null);
                this.v.onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController2 = this.l;
            if (replyPrivacyCheckController2 != null) {
                replyPrivacyCheckController2.setAttentionCallback(null);
            }
        }
    }

    public View f0(ViewGroup viewGroup, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, viewGroup, str)) == null) {
            if (viewGroup == null) {
                return null;
            }
            this.h = viewGroup;
            this.g = (NavigationBarShadowView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091916);
            if (this.i == null) {
                m45 m45Var = new m45(this.a.getPageContext());
                this.i = m45Var;
                m45Var.a(this.r);
            }
            this.i.W(this.a.getUniqueId());
            if (this.b == null) {
                PbListView pbListView = new PbListView(this.a.getContext());
                this.b = pbListView;
                pbListView.c();
            }
            this.b.s(R.color.CAM_X0205);
            this.b.v();
            this.b.w(BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds182));
            this.b.B();
            this.b.L(R.dimen.tbfontsize33);
            this.b.J(SkinManager.getColor(R.color.CAM_X0109));
            this.b.F(R.color.CAM_X0110);
            this.b.G(this.q);
            InteractionManagerSizer interactionManagerSizer = (InteractionManagerSizer) this.h.findViewById(R.id.obfuscated_res_0x7f091166);
            this.p = interactionManagerSizer;
            interactionManagerSizer.setSizerCallback(this.t);
            if (PersonPostActivityConfig.CALL_FROM_CREATIVE_WORK.equals(str)) {
                this.p.setVisibility(0);
            } else {
                this.p.setVisibility(8);
            }
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.h.findViewById(R.id.obfuscated_res_0x7f091f0d);
            this.e = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.i);
            this.f = (BdTypeRecyclerView) this.h.findViewById(R.id.obfuscated_res_0x7f091f1a);
            bq8 bq8Var = new bq8(this.a.getPageContext(), this.f);
            this.d = bq8Var;
            bq8Var.h(new n(this));
            ((DefaultItemAnimator) this.f.getItemAnimator()).setSupportsChangeAnimations(false);
            this.f.setLayoutManager(new o(this, this.mContext.getContext()));
            this.f.setFadingEdgeLength(0);
            this.f.setOverScrollMode(2);
            this.f.setRecyclerListener(new p(this));
            this.f.setOnSrollToBottomListener(new q(this));
            this.f.setOnScrollListener(this.G);
            this.f.addOnScrollListener(this.s);
            a0();
            ReplyMeModel replyMeModel = new ReplyMeModel(this.a.getPageContext());
            this.v = replyMeModel;
            replyMeModel.R(this.F);
            Z();
            Y(false);
            return this.h;
        }
        return (View) invokeLL.objValue;
    }

    public void j0(boolean z, ArrayList<yh> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048593, this, z, arrayList) != null) || this.f == null) {
            return;
        }
        this.e.setVisibility(0);
        n0(false);
        if (z) {
            this.b.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.b.g();
            this.b.G(this.q);
        } else {
            this.b.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.b.g();
            this.b.H(this.mContext.getResources().getString(R.string.list_no_more));
            this.b.G(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.c == null) {
                this.c = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070275)), NoDataViewFactory.e.d(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                this.c.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            }
            if (this.c.getParent() == null && !this.k) {
                this.k = true;
                this.f.addHeaderView(this.c);
                this.c.setVisibility(0);
                this.c.f(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f.setNextPage(null);
            if (arrayList != null) {
                this.d.f(arrayList);
            }
            this.n = R.color.CAM_X0205;
        } else {
            this.f.removeHeaderView(this.c);
            this.k = false;
            bq8 bq8Var = this.d;
            if (bq8Var != null) {
                bq8Var.f(arrayList);
                this.d.c();
            }
            this.f.setNextPage(this.b);
            this.n = R.color.CAM_X0204;
        }
        S();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        k0(this.f, this.a.l2());
    }

    public final void o0() {
        vp8 vp8Var;
        vp8 vp8Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            vp8 vp8Var3 = this.x;
            if (vp8Var3 != null && vp8Var3.getBaijiahaoData() != null && this.x.isBjh()) {
                kf5 kf5Var = this.w;
                if (kf5Var == null || !kf5Var.s) {
                    Y(true);
                }
                if (this.w != null && (vp8Var2 = this.x) != null) {
                    if (vp8Var2.A() && this.x.r() != null) {
                        this.w.o0(this.x.r().getName_show(), this.x.r().getPortrait());
                        return;
                    } else {
                        this.w.o0(null, null);
                        return;
                    }
                }
                return;
            }
            kf5 kf5Var2 = this.w;
            if (kf5Var2 == null || kf5Var2.s) {
                Y(false);
            }
            if (this.w != null && (vp8Var = this.x) != null) {
                if (vp8Var.A() && this.x.r() != null) {
                    this.w.o0(this.x.r().getName_show(), this.x.r().getPortrait());
                } else {
                    this.w.o0(null, null);
                }
            }
        }
    }
}
