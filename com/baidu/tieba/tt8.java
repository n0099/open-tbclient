package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
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
import com.baidu.tieba.eu8;
import com.baidu.tieba.immessagecenter.mention.MessageCenterActivity;
import com.baidu.tieba.immessagecenter.mention.ReplyMeModel;
import com.baidu.tieba.immessagecenter.mention.ReplyMessageFragment;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.z95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class tt8 extends BdBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataModel<MessageCenterActivity> A;
    public NewWriteModel.d B;
    public Runnable C;
    public final ReplyMeModel.b D;
    public final RecyclerView.OnScrollListener E;
    public final ReplyMessageFragment a;
    public PbListView b;
    public NoDataView c;
    public du8 d;
    public BdSwipeRefreshLayout e;
    public BdTypeRecyclerView f;
    public NavigationBarShadowView g;
    public ViewGroup h;
    public aa5 i;
    public eu8 j;
    public boolean k;
    public ReplyPrivacyCheckController l;
    public AttentionHostData m;
    public int n;
    public boolean o;
    public View.OnClickListener p;
    public final z95.g q;
    public RecyclerView.OnScrollListener r;
    public eu8.b s;
    public ReplyMeModel t;
    public al5 u;
    public xt8 v;
    public String w;
    public String x;
    public long y;
    public long z;

    public void f(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, errorData) == null) {
        }
    }

    public void j0(NewsNotifyMessage newsNotifyMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, newsNotifyMessage) != null) || newsNotifyMessage == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class m extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final LinearSmoothScroller a;
        public final /* synthetic */ tt8 b;

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
            public a(m mVar, Context context) {
                super(context);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, context};
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
        public m(tt8 tt8Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tt8Var, context};
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
            this.b = tt8Var;
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
    public class a extends DataModel<MessageCenterActivity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tt8 a;

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String Q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String R() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String S() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean V() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean W() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean X() {
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
        public a(tt8 tt8Var, BdPageContext bdPageContext) {
            super(bdPageContext);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tt8Var, bdPageContext};
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
            this.a = tt8Var;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String O() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.v != null) {
                    return this.a.v.o();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String P() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.v != null) {
                    return this.a.v.v();
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
            return this.a.w;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public WriteData T(String str) {
            InterceptResult invokeL;
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                WriteData writeData = new WriteData();
                writeData.setForumId(this.a.w);
                writeData.setForumName(this.a.x);
                writeData.setThreadId(this.a.v.v());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (this.a.v.B()) {
                    if (this.a.y > 0) {
                        str3 = String.valueOf(this.a.y);
                    } else {
                        str3 = this.a.v.l().n;
                    }
                    writeData.setFloor(str3);
                } else {
                    writeData.setFloor(this.a.v.o());
                }
                if (this.a.z > 0) {
                    writeData.setRepostId(String.valueOf(this.a.z));
                    if (this.a.v.B()) {
                        str2 = String.valueOf(this.a.z);
                    } else {
                        str2 = null;
                    }
                    writeData.setReSubPostId(str2);
                }
                if (this.a.v != null) {
                    writeData.setBaijiahaoData(this.a.v.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }
            return (WriteData) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tt8 a;

        public b(tt8 tt8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tt8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tt8Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ae5 ae5Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ae5Var, writeData, antiData}) != null) || this.a.a.getBaseFragmentActivity() == null) {
                return;
            }
            this.a.a.getBaseFragmentActivity().hideProgressBar();
            this.a.u.a().q();
            if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                this.a.l.setLikeUserData(this.a.m);
                this.a.l.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                return;
            }
            if (postWriteCallBackData != null && ae5Var == null && !AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                this.a.a.showToast(postWriteCallBackData.getErrorString());
            }
            if (z && postWriteCallBackData != null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
                statisticItem.param("tid", postWriteCallBackData.getPostId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", 8);
                ms5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this.a.mContext.getPageActivity());
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
    public class c implements uk5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tt8 a;

        public c(tt8 tt8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tt8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tt8Var;
        }

        @Override // com.baidu.tieba.uk5
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.getBaseFragmentActivity() != null) {
                this.a.a.getBaseFragmentActivity().showProgressBar();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tt8 a;

        public d(tt8 tt8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tt8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tt8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.u != null) {
                this.a.u.A();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tt8 a;

        public e(tt8 tt8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tt8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tt8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.u != null && this.a.u.u() != null) {
                BdUtilHelper.showSoftKeyPad(this.a.getPageContext().getPageActivity(), this.a.u.u().i());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements ReplyMeModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tt8 a;

        public f(tt8 tt8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tt8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tt8Var;
        }

        @Override // com.baidu.tieba.immessagecenter.mention.ReplyMeModel.b
        public void a(long j, long j2, long j3, String str, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str, Long.valueOf(j4)}) == null) {
                this.a.w = String.valueOf(j);
                this.a.x = str;
                this.a.y = j2;
                this.a.z = j3;
                this.a.q0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tt8 a;

        public g(tt8 tt8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tt8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tt8Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (i != 0 && this.a.u != null) {
                    this.a.u.A();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tt8 a;

        public h(tt8 tt8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tt8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tt8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null && this.a.a != null) {
                this.a.b.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.a.b.G(null);
                this.a.b.U();
                this.a.a.p2();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements z95.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tt8 a;

        public i(tt8 tt8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tt8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tt8Var;
        }

        @Override // com.baidu.tieba.z95.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    if (this.a.a != null) {
                        this.a.a.r2();
                    }
                } else if (this.a.e != null) {
                    this.a.e.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tt8 a;

        public j(tt8 tt8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tt8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tt8Var;
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
    public class k implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tt8 a;

        public k(tt8 tt8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tt8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tt8Var;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z && this.a.u != null) {
                this.a.u.I();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l extends mp6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tt8 b;

        public l(tt8 tt8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tt8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tt8Var;
        }

        @Override // com.baidu.tieba.mp6
        public void a(View view2, BaseCardInfo baseCardInfo) {
            long j;
            BaijiahaoData baijiahaoData;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, baseCardInfo) == null) && view2 != null && (baseCardInfo instanceof xt8)) {
                xt8 xt8Var = (xt8) baseCardInfo;
                if (xt8Var.y() && view2.getId() != R.id.obfuscated_res_0x7f091ca3 && view2.getId() != R.id.user_name) {
                    xt8Var.E(false);
                    this.b.f0();
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f091767) {
                    this.b.v = xt8Var;
                    if (xt8Var.B()) {
                        j = JavaTypesHelper.toLong(xt8Var.p(), 0L);
                    } else {
                        j = JavaTypesHelper.toLong(xt8Var.o(), 0L);
                    }
                    long j2 = j;
                    if (this.b.u != null) {
                        this.b.u.W(this.b.v.o());
                        al5 al5Var = this.b.u;
                        if (xt8Var.B()) {
                            str = this.b.v.o();
                        } else {
                            str = null;
                        }
                        al5Var.e0(str);
                    }
                    if (this.b.m == null) {
                        this.b.m = new AttentionHostData();
                    }
                    if (this.b.v != null) {
                        this.b.m.parserWithMetaData(this.b.v.u());
                    }
                    if (this.b.v != null) {
                        baijiahaoData = this.b.v.getBaijiahaoData();
                    } else {
                        baijiahaoData = null;
                    }
                    this.b.t.P(j2, 2, xt8Var.d(), xt8Var.v(), baijiahaoData);
                    StatisticItem statisticItem = new StatisticItem("c13784");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(statisticItem);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090611) {
                    Object tag = view2.getTag(R.id.item_data);
                    if (StringUtils.isNotNull(xt8Var.getTargetScheme())) {
                        UrlManager.getInstance().dealOneLink(xt8Var.getTargetScheme());
                    } else if (tag instanceof Boolean) {
                        String p = xt8Var.p();
                        if (((Boolean) tag).booleanValue()) {
                            this.b.a.k2(xt8Var, p);
                        } else if (xt8Var.getThreadType() == 40) {
                            this.b.a.o2(xt8Var, true, p);
                        } else {
                            this.b.a.m2(xt8Var, p);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public n(tt8 tt8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tt8Var};
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
    public class o implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tt8 a;

        public o(tt8 tt8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tt8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tt8Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                this.a.b.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.a.b.G(null);
                this.a.b.R();
                this.a.a.p2();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements eu8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tt8 a;

        public p(tt8 tt8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tt8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tt8Var;
        }

        @Override // com.baidu.tieba.eu8.b
        public void onClose() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.j != null) {
                this.a.f.removeHeaderView(this.a.j.f());
                this.a.o = false;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tt8(ReplyMessageFragment replyMessageFragment) {
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
        this.p = new h(this);
        this.q = new i(this);
        this.r = new j(this);
        this.s = new p(this);
        this.t = null;
        this.C = new e(this);
        this.D = new f(this);
        this.E = new g(this);
        this.a = replyMessageFragment;
        ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(replyMessageFragment.getPageContext());
        this.l = replyPrivacyCheckController;
        replyPrivacyCheckController.setAttentionCallback(new k(this));
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            al5 al5Var = this.u;
            if (al5Var != null && al5Var.a() != null) {
                this.u.a().z(i2);
            }
            PbListView pbListView = this.b;
            if (pbListView != null) {
                pbListView.J(SkinManager.getColor(R.color.CAM_X0109));
                this.b.e(i2);
            }
            aa5 aa5Var = this.i;
            if (aa5Var != null) {
                aa5Var.C(i2);
            }
            NoDataView noDataView = this.c;
            if (noDataView != null) {
                noDataView.f(this.mContext, i2);
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            }
            f0();
            SkinManager.setBackgroundColor(this.f, this.n);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0205);
            eu8 eu8Var = this.j;
            if (eu8Var != null) {
                eu8Var.g(i2, false);
            }
        }
    }

    public final void m0(BdTypeRecyclerView bdTypeRecyclerView, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, bdTypeRecyclerView, str) == null) && bdTypeRecyclerView != null && str != null) {
            int Z = Z(bdTypeRecyclerView, str);
            if ((bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) && Z >= 0) {
                bdTypeRecyclerView.smoothScrollToPosition(Z);
            }
        }
    }

    public void Y(int i2) {
        du8 du8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && (du8Var = this.d) != null) {
            du8Var.a(i2);
        }
    }

    public void n0(nn nnVar) {
        du8 du8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, nnVar) == null) && (du8Var = this.d) != null) {
            du8Var.g(nnVar);
        }
    }

    public void o0(mn mnVar) {
        du8 du8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, mnVar) == null) && (du8Var = this.d) != null) {
            du8Var.e(mnVar);
        }
    }

    public void p0(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && this.e != null) {
            if (z && (bdTypeRecyclerView = this.f) != null && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
                this.f.setSelection(0);
            }
            this.e.setRefreshing(z);
        }
    }

    public final void X() {
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
            eu8 eu8Var = this.j;
            if (eu8Var != null) {
                this.f.removeHeaderView(eu8Var.f());
                this.o = false;
                return;
            }
            return;
        }
        long j2 = SharedPrefHelper.getInstance().getLong("key_im_open_notification_close_time", 0L);
        if (!this.o) {
            if (j2 == 0 || System.currentTimeMillis() - j2 > 604800000) {
                if (this.j == null) {
                    eu8 eu8Var2 = new eu8(this.a.getPageContext(), false);
                    this.j = eu8Var2;
                    eu8Var2.h(this.s);
                }
                this.f.addHeaderView(this.j.f(), 0);
                this.o = true;
            }
        }
    }

    public final int Z(BdTypeRecyclerView bdTypeRecyclerView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bdTypeRecyclerView, str)) == null) {
            if (bdTypeRecyclerView != null && !TextUtils.isEmpty(str)) {
                List<cn> data = bdTypeRecyclerView.getData();
                int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
                if (data != null && data.size() > 0) {
                    int size = data.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        cn cnVar = data.get(i2);
                        if ((cnVar instanceof xt8) && str.equals(((xt8) cnVar).o())) {
                            return i2 + headerViewsCount;
                        }
                    }
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public BdSwipeRefreshLayout a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (BdSwipeRefreshLayout) invokeV.objValue;
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.A = new a(this, m9.a(this.a.getPageContext().getContext()));
            this.B = new b(this);
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            X();
        }
    }

    public void f0() {
        du8 du8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (du8Var = this.d) != null) {
            du8Var.c();
        }
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            al5 al5Var = this.u;
            if (al5Var != null && al5Var.a() != null && this.u.a().getVisibility() == 0) {
                this.u.A();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            X();
        }
    }

    public final void b0(int i2, Intent intent) {
        fj5 fj5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, intent) == null) {
            this.u.a().t();
            this.u.A();
            this.u.a().B();
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
            this.u.D(writeData);
            this.u.g0(pbEditorData.getVoiceModel());
            ej5 p2 = this.u.a().p(6);
            if (p2 != null && (fj5Var = p2.m) != null) {
                fj5Var.G(new si5(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.u.I();
            }
        }
    }

    public final void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            al5 al5Var = this.u;
            if (al5Var != null && al5Var.a() != null && this.u.a().getParent() != null) {
                ((ViewGroup) this.u.a().getParent()).removeView(this.u.a());
            }
            al5 al5Var2 = (al5) new bl5(z).a(this.a.getPageContext().getPageActivity());
            this.u = al5Var2;
            al5Var2.Q(this.a.getPageContext());
            this.u.d0(this.A);
            this.u.R(3);
            this.u.B(this.a.getPageContext());
            this.u.a().F(true);
            this.u.a().z(TbadkCoreApplication.getInst().getSkinType());
            if (this.u.a() != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                this.h.addView(this.u.a(), layoutParams);
                this.u.a().q();
            }
            this.u.X(new c(this));
            this.u.T(this.B);
            if (this.u.a() != null) {
                this.u.a().setOnCancelClickListener(new d(this));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.C);
            al5 al5Var = this.u;
            if (al5Var != null) {
                al5Var.F();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.l;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            ReplyMeModel replyMeModel = this.t;
            if (replyMeModel != null) {
                replyMeModel.Q(null);
                this.t.onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController2 = this.l;
            if (replyPrivacyCheckController2 != null) {
                replyPrivacyCheckController2.setAttentionCallback(null);
            }
        }
    }

    public boolean g0(int i2, int i3, Intent intent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048587, this, i2, i3, intent)) == null) {
            al5 al5Var = this.u;
            if (al5Var != null) {
                if (i2 == 12005) {
                    al5Var.m0();
                    SafeHandler.getInst().postDelayed(this.C, 300L);
                }
                this.u.E(i2, i3, intent);
            }
            if (i2 == 25035) {
                b0(i3, intent);
                return false;
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    public View i0(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, viewGroup)) == null) {
            if (viewGroup == null) {
                return null;
            }
            this.h = viewGroup;
            this.g = (NavigationBarShadowView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0918ff);
            if (this.i == null) {
                aa5 aa5Var = new aa5(this.a.getPageContext());
                this.i = aa5Var;
                aa5Var.a(this.q);
            }
            this.i.V(this.a.getUniqueId());
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
            this.b.G(this.p);
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.h.findViewById(R.id.obfuscated_res_0x7f091f23);
            this.e = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.i);
            this.f = (BdTypeRecyclerView) this.h.findViewById(R.id.obfuscated_res_0x7f091f31);
            du8 du8Var = new du8(this.a.getPageContext(), this.f);
            this.d = du8Var;
            du8Var.h(new l(this));
            ((DefaultItemAnimator) this.f.getItemAnimator()).setSupportsChangeAnimations(false);
            this.f.setLayoutManager(new m(this, this.mContext.getContext()));
            this.f.setFadingEdgeLength(0);
            this.f.setOverScrollMode(2);
            this.f.setRecyclerListener(new n(this));
            this.f.setOnSrollToBottomListener(new o(this));
            this.f.setOnScrollListener(this.E);
            this.f.addOnScrollListener(this.r);
            e0();
            ReplyMeModel replyMeModel = new ReplyMeModel(this.a.getPageContext());
            this.t = replyMeModel;
            replyMeModel.Q(this.D);
            d0();
            c0(false);
            return this.h;
        }
        return (View) invokeL.objValue;
    }

    public void l0(boolean z, ArrayList<cn> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048592, this, z, arrayList) != null) || this.f == null) {
            return;
        }
        this.e.setVisibility(0);
        p0(false);
        if (z) {
            this.b.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.b.g();
            this.b.G(this.p);
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
            du8 du8Var = this.d;
            if (du8Var != null) {
                du8Var.f(arrayList);
                this.d.c();
            }
            this.f.setNextPage(this.b);
            this.n = R.color.CAM_X0204;
        }
        X();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        m0(this.f, this.a.f2());
    }

    public final void q0() {
        xt8 xt8Var;
        xt8 xt8Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            xt8 xt8Var3 = this.v;
            if (xt8Var3 != null && xt8Var3.getBaijiahaoData() != null && this.v.isBjh()) {
                al5 al5Var = this.u;
                if (al5Var == null || !al5Var.s) {
                    c0(true);
                }
                if (this.u != null && (xt8Var2 = this.v) != null) {
                    if (xt8Var2.B() && this.v.s() != null) {
                        this.u.n0(this.v.s().getName_show(), this.v.s().getPortrait());
                        return;
                    } else {
                        this.u.n0(null, null);
                        return;
                    }
                }
                return;
            }
            al5 al5Var2 = this.u;
            if (al5Var2 == null || al5Var2.s) {
                c0(false);
            }
            if (this.u != null && (xt8Var = this.v) != null) {
                if (xt8Var.B() && this.v.s() != null) {
                    this.u.n0(this.v.s().getName_show(), this.v.s().getPortrait());
                } else {
                    this.u.n0(null, null);
                }
            }
        }
    }
}
