package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdNetTypeUtil;
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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
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
import com.baidu.tieba.immessagecenter.mention.AtMessageFragment;
import com.baidu.tieba.immessagecenter.mention.MessageCenterActivity;
import com.baidu.tieba.immessagecenter.mention.ReplyMeModel;
import com.baidu.tieba.immessagecenter.mention.base.DeviderLineDecoration;
import com.baidu.tieba.ir8;
import com.baidu.tieba.sa5;
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
/* loaded from: classes7.dex */
public class mq8 extends j9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataModel<MessageCenterActivity> A;
    public NewWriteModel.d B;
    public ReplyMeModel C;
    public Runnable D;
    public final ReplyMeModel.b E;
    public AtMessageFragment a;
    public PbListView b;
    public NoDataView c;
    public ar8 d;
    public BdSwipeRefreshLayout e;
    public BdTypeRecyclerView f;
    public NavigationBarShadowView g;
    public ViewGroup h;
    public ta5 i;
    public ir8 j;
    public boolean k;
    public ReplyPrivacyCheckController l;
    public AttentionHostData m;
    public int n;
    public boolean o;
    public View.OnClickListener p;
    public final sa5.g q;
    public RecyclerView.OnScrollListener r;
    public ir8.b s;
    public final RecyclerView.OnScrollListener t;
    public hl5 u;
    public br8 v;
    public String w;
    public String x;
    public long y;
    public long z;

    public void f(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, errorData) == null) {
        }
    }

    public void o0(NewsNotifyMessage newsNotifyMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, newsNotifyMessage) != null) || newsNotifyMessage == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class k extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final LinearSmoothScroller a;
        public final /* synthetic */ mq8 b;

        /* loaded from: classes7.dex */
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
            public a(k kVar, Context context) {
                super(context);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, context};
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
        public k(mq8 mq8Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mq8Var, context};
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
            this.b = mq8Var;
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

    /* loaded from: classes7.dex */
    public class a extends DataModel<MessageCenterActivity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq8 a;

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String Z() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String a0() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String b0() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.adp.base.BdBaseModel
        public boolean cancelLoadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean e0() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean f0() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean g0() {
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
        public a(mq8 mq8Var, l9 l9Var) {
            super(l9Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mq8Var, l9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((l9) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mq8Var;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String X() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.v != null) {
                    return this.a.v.n();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String Y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.v != null) {
                    return this.a.v.x();
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
        public WriteData c0(String str) {
            InterceptResult invokeL;
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                WriteData writeData = new WriteData();
                writeData.setForumId(this.a.w);
                writeData.setForumName(this.a.x);
                writeData.setThreadId(this.a.v.x());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (this.a.v.B()) {
                    if (this.a.y > 0) {
                        str3 = String.valueOf(this.a.y);
                    } else {
                        str3 = this.a.v.k().n;
                    }
                    writeData.setFloor(str3);
                } else {
                    writeData.setFloor(this.a.v.n());
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

    /* loaded from: classes7.dex */
    public class b implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq8 a;

        public b(mq8 mq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mq8Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ve5 ve5Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ve5Var, writeData, antiData}) != null) || this.a.a.getBaseFragmentActivity() == null) {
                return;
            }
            this.a.a.getBaseFragmentActivity().hideProgressBar();
            this.a.u.b().q();
            if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                this.a.l.setLikeUserData(this.a.m);
                this.a.l.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                return;
            }
            if (postWriteCallBackData != null && ve5Var == null && !AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                this.a.a.showToast(postWriteCallBackData.getErrorString());
            }
            if (z && postWriteCallBackData != null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
                statisticItem.param("tid", postWriteCallBackData.getPostId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", 8);
                at5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this.a.mContext.getPageActivity());
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

    /* loaded from: classes7.dex */
    public class c implements bl5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq8 a;

        public c(mq8 mq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mq8Var;
        }

        @Override // com.baidu.tieba.bl5
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.getBaseFragmentActivity() != null) {
                this.a.a.getBaseFragmentActivity().showProgressBar();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq8 a;

        public d(mq8 mq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mq8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.u != null) {
                this.a.u.A();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq8 a;

        public e(mq8 mq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mq8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.u != null && this.a.u.u() != null) {
                yi.P(this.a.getPageContext().getPageActivity(), this.a.u.u().i());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ReplyMeModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq8 a;

        public f(mq8 mq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mq8Var;
        }

        @Override // com.baidu.tieba.immessagecenter.mention.ReplyMeModel.b
        public void a(long j, long j2, long j3, String str, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str, Long.valueOf(j4)}) == null) {
                this.a.w = String.valueOf(j);
                this.a.x = str;
                this.a.y = j2;
                this.a.z = j3;
                this.a.v0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq8 a;

        public g(mq8 mq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mq8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null && this.a.a != null) {
                this.a.b.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.a.b.G(null);
                this.a.b.U();
                this.a.a.b2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements sa5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq8 a;

        public h(mq8 mq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mq8Var;
        }

        @Override // com.baidu.tieba.sa5.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    if (this.a.a != null) {
                        this.a.a.d2();
                    }
                } else if (this.a.e != null) {
                    this.a.e.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq8 a;

        public i(mq8 mq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mq8Var;
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

    /* loaded from: classes7.dex */
    public class j extends up6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq8 b;

        public j(mq8 mq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mq8Var;
        }

        @Override // com.baidu.tieba.up6
        public void a(View view2, BaseCardInfo baseCardInfo) {
            long g;
            int i;
            BaijiahaoData baijiahaoData;
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, baseCardInfo) == null) && view2 != null && (baseCardInfo instanceof br8)) {
                br8 br8Var = (br8) baseCardInfo;
                if (br8Var.z() && view2.getId() != R.id.obfuscated_res_0x7f091c4b && view2.getId() != R.id.user_name) {
                    br8Var.E(false);
                    this.b.k0();
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f091733) {
                    this.b.v = br8Var;
                    if (br8Var.B()) {
                        g = wg.g(br8Var.o(), 0L);
                    } else {
                        g = wg.g(br8Var.n(), 0L);
                    }
                    long j = g;
                    int i2 = 2;
                    if (this.b.u != null && this.b.mContext != null) {
                        if (br8Var.i() != null && br8Var.p() != null) {
                            String userName = UtilHelper.getUserName(br8Var.r());
                            if (br8Var.i().size() <= 2) {
                                if (br8Var.i().size() > 1 && br8Var.i().get(1) != null) {
                                    str2 = e36.H(br8Var.i().get(1).content).toString();
                                } else {
                                    str2 = this.b.mContext.getString(R.string.obfuscated_res_0x7f0f1621);
                                    i2 = 1;
                                }
                            } else if (br8Var.i().get(2) != null) {
                                str2 = e36.H(br8Var.i().get(2).content).toString();
                            } else {
                                str2 = null;
                            }
                            this.b.u.q(this.b.mContext.getString(R.string.obfuscated_res_0x7f0f1225) + userName + this.b.mContext.getString(R.string.obfuscated_res_0x7f0f161f) + str2);
                        }
                        this.b.u.W(this.b.v.n());
                        hl5 hl5Var = this.b.u;
                        if (br8Var.B()) {
                            str = this.b.v.n();
                        } else {
                            str = null;
                        }
                        hl5Var.e0(str);
                        i = i2;
                    } else {
                        i = 2;
                    }
                    if (this.b.m == null) {
                        this.b.m = new AttentionHostData();
                    }
                    if (this.b.v != null) {
                        this.b.m.parserWithMetaData(this.b.v.v());
                    }
                    if (this.b.v != null) {
                        baijiahaoData = this.b.v.getBaijiahaoData();
                    } else {
                        baijiahaoData = null;
                    }
                    this.b.C.Y(j, i, br8Var.d(), br8Var.x(), baijiahaoData);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f0905fc) {
                    Object tag = view2.getTag(R.id.item_data);
                    if (tag instanceof Boolean) {
                        String o = br8Var.o();
                        if (((Boolean) tag).booleanValue()) {
                            this.b.a.W1(br8Var, o);
                        } else if (br8Var.getThreadType() == 40) {
                            this.b.a.a2(br8Var, true, o);
                        } else {
                            this.b.a.Y1(br8Var, o);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l(mq8 mq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mq8Var};
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

    /* loaded from: classes7.dex */
    public class m implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq8 a;

        public m(mq8 mq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mq8Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                this.a.b.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.a.b.G(null);
                this.a.b.R();
                this.a.a.b2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements ir8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq8 a;

        public n(mq8 mq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mq8Var;
        }

        @Override // com.baidu.tieba.ir8.b
        public void onClose() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.j != null) {
                this.a.f.removeHeaderView(this.a.j.f());
                this.a.o = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq8 a;

        public o(mq8 mq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mq8Var;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mq8(AtMessageFragment atMessageFragment) {
        super(atMessageFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atMessageFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((l9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = R.color.CAM_X0204;
        this.o = false;
        this.p = new g(this);
        this.q = new h(this);
        this.r = new i(this);
        this.s = new n(this);
        this.t = new o(this);
        this.C = null;
        this.D = new e(this);
        this.E = new f(this);
        this.a = atMessageFragment;
        this.l = new ReplyPrivacyCheckController(atMessageFragment.getPageContext());
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            hl5 hl5Var = this.u;
            if (hl5Var != null && hl5Var.b() != null) {
                this.u.b().z(i2);
            }
            PbListView pbListView = this.b;
            if (pbListView != null) {
                pbListView.J(SkinManager.getColor(R.color.CAM_X0109));
                this.b.e(i2);
            }
            ta5 ta5Var = this.i;
            if (ta5Var != null) {
                ta5Var.H(i2);
            }
            NoDataView noDataView = this.c;
            if (noDataView != null) {
                noDataView.f(this.mContext, i2);
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            }
            k0();
            SkinManager.setBackgroundColor(this.f, this.n);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0205);
            ir8 ir8Var = this.j;
            if (ir8Var != null) {
                ir8Var.g(i2, false);
            }
        }
    }

    public void d0(int i2) {
        ar8 ar8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && (ar8Var = this.d) != null) {
            ar8Var.a(i2);
        }
    }

    public void r0(jo joVar) {
        ar8 ar8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, joVar) == null) && (ar8Var = this.d) != null) {
            ar8Var.f(joVar);
        }
    }

    public void s0(io ioVar) {
        ar8 ar8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, ioVar) == null) && (ar8Var = this.d) != null) {
            ar8Var.d(ioVar);
        }
    }

    public void u0(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048594, this, z) == null) && this.e != null) {
            if (z && (bdTypeRecyclerView = this.f) != null && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
                this.f.setSelection(0);
            }
            this.e.setRefreshing(z);
        }
    }

    public final void c0() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.f == null) {
            return;
        }
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.a.getContext()).areNotificationsEnabled();
        StatisticItem statisticItem = new StatisticItem("c13616");
        if (areNotificationsEnabled) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        statisticItem.param("obj_type", i2);
        TiebaStatic.log(statisticItem);
        if (areNotificationsEnabled) {
            ir8 ir8Var = this.j;
            if (ir8Var != null) {
                this.f.removeHeaderView(ir8Var.f());
                this.o = false;
                return;
            }
            return;
        }
        long r = da5.p().r("key_im_open_notification_close_time", 0L);
        if (!this.o) {
            if (r == 0 || System.currentTimeMillis() - r > 604800000) {
                if (this.j == null) {
                    ir8 ir8Var2 = new ir8(this.a.getPageContext(), false);
                    this.j = ir8Var2;
                    ir8Var2.h(this.s);
                }
                this.f.addHeaderView(this.j.f(), 0);
                this.o = true;
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            zg.a().removeCallbacks(this.D);
            hl5 hl5Var = this.u;
            if (hl5Var != null) {
                hl5Var.F();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.l;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController2 = this.l;
            if (replyPrivacyCheckController2 != null) {
                replyPrivacyCheckController2.setAttentionCallback(null);
            }
            ReplyMeModel replyMeModel = this.C;
            if (replyMeModel != null) {
                replyMeModel.Z(null);
                this.C.onDestroy();
            }
        }
    }

    public BdSwipeRefreshLayout f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (BdSwipeRefreshLayout) invokeV.objValue;
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.A = new a(this, r9.a(this.a.getPageContext().getContext()));
            this.B = new b(this);
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c0();
        }
    }

    public void k0() {
        ar8 ar8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (ar8Var = this.d) != null) {
            ar8Var.c();
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            c0();
        }
    }

    public final void g0(int i2, Intent intent) {
        mj5 mj5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, intent) == null) {
            this.u.b().t();
            this.u.A();
            this.u.b().B();
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
            lj5 p = this.u.b().p(6);
            if (p != null && (mj5Var = p.m) != null) {
                mj5Var.B(new zi5(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.u.I();
            }
        }
    }

    public final void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            hl5 hl5Var = this.u;
            if (hl5Var != null && hl5Var.b() != null && this.u.b().getParent() != null) {
                ((ViewGroup) this.u.b().getParent()).removeView(this.u.b());
            }
            hl5 hl5Var2 = (hl5) new il5(z).a(this.a.getPageContext().getPageActivity());
            this.u = hl5Var2;
            hl5Var2.Q(this.a.getPageContext());
            this.u.d0(this.A);
            this.u.R(3);
            this.u.B(this.a.getPageContext());
            this.u.b().F(true);
            this.u.b().z(TbadkCoreApplication.getInst().getSkinType());
            if (this.u.b() != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                this.h.addView(this.u.b(), layoutParams);
                this.u.b().q();
            }
            this.u.X(new c(this));
            this.u.T(this.B);
            if (this.u.b() != null) {
                this.u.b().setOnCancelClickListener(new d(this));
            }
        }
    }

    public boolean m0(int i2, int i3, Intent intent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i2, i3, intent)) == null) {
            hl5 hl5Var = this.u;
            if (hl5Var != null) {
                if (i2 == 12005) {
                    hl5Var.m0();
                    zg.a().postDelayed(this.D, 300L);
                }
                this.u.E(i2, i3, intent);
            }
            if (i2 == 25035) {
                g0(i3, intent);
                return false;
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    public View n0(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, viewGroup)) == null) {
            if (viewGroup == null) {
                return null;
            }
            this.h = viewGroup;
            this.g = (NavigationBarShadowView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0918a6);
            if (this.i == null) {
                ta5 ta5Var = new ta5(this.a.getPageContext());
                this.i = ta5Var;
                ta5Var.f(this.q);
            }
            this.i.a0(this.a.getUniqueId());
            if (this.b == null) {
                PbListView pbListView = new PbListView(this.a.getContext());
                this.b = pbListView;
                pbListView.c();
            }
            this.b.s(R.color.CAM_X0205);
            this.b.v();
            this.b.w(yi.g(this.a.getContext(), R.dimen.tbds182));
            this.b.B();
            this.b.L(R.dimen.tbfontsize33);
            this.b.J(SkinManager.getColor(R.color.CAM_X0109));
            this.b.F(R.color.CAM_X0110);
            this.b.G(this.p);
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.h.findViewById(R.id.obfuscated_res_0x7f0902de);
            this.e = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.i);
            this.f = (BdTypeRecyclerView) this.h.findViewById(R.id.obfuscated_res_0x7f0902e2);
            ar8 ar8Var = new ar8(this.a.getPageContext(), this.f);
            this.d = ar8Var;
            ar8Var.g(new j(this));
            ((DefaultItemAnimator) this.f.getItemAnimator()).setSupportsChangeAnimations(false);
            this.f.setLayoutManager(new k(this, this.mContext.getContext()));
            this.f.setFadingEdgeLength(0);
            this.f.setOverScrollMode(2);
            this.f.addItemDecoration(new DeviderLineDecoration());
            this.f.setRecyclerListener(new l(this));
            this.f.setOnSrollToBottomListener(new m(this));
            this.f.setOnScrollListener(this.t);
            this.f.addOnScrollListener(this.r);
            j0();
            ReplyMeModel replyMeModel = new ReplyMeModel(this.a.getPageContext());
            this.C = replyMeModel;
            replyMeModel.Z(this.E);
            i0();
            h0(false);
            return this.h;
        }
        return (View) invokeL.objValue;
    }

    public void q0(boolean z, ArrayList<yn> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048591, this, z, arrayList) != null) || this.f == null) {
            return;
        }
        this.e.setVisibility(0);
        u0(false);
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
                this.c = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070275)), NoDataViewFactory.e.d(null, this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0c72)), null);
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
                this.d.e(arrayList);
            }
            this.n = R.color.CAM_X0205;
            this.e.setEnabled(false);
        } else {
            this.f.removeHeaderView(this.c);
            this.k = false;
            ar8 ar8Var = this.d;
            if (ar8Var != null) {
                ar8Var.e(arrayList);
                this.d.c();
            }
            this.f.setNextPage(this.b);
            this.n = R.color.CAM_X0204;
        }
        c0();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void v0() {
        br8 br8Var;
        br8 br8Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            br8 br8Var3 = this.v;
            if (br8Var3 != null && br8Var3.getBaijiahaoData() != null && this.v.isBjh()) {
                hl5 hl5Var = this.u;
                if (hl5Var == null || !hl5Var.s) {
                    h0(true);
                }
                if (this.u != null && (br8Var2 = this.v) != null) {
                    if (br8Var2.B() && this.v.r() != null) {
                        this.u.n0(this.v.r().getName_show(), this.v.r().getPortrait());
                        return;
                    } else {
                        this.u.n0(null, null);
                        return;
                    }
                }
                return;
            }
            hl5 hl5Var2 = this.u;
            if (hl5Var2 == null || hl5Var2.s) {
                h0(false);
            }
            if (this.u != null && (br8Var = this.v) != null) {
                if (br8Var.B() && this.v.r() != null) {
                    this.u.n0(this.v.r().getName_show(), this.v.r().getPortrait());
                } else {
                    this.u.n0(null, null);
                }
            }
        }
    }
}
