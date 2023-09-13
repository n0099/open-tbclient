package com.baidu.tieba.immessagecenter.msgtab.ui.model;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.cbc;
import com.baidu.tieba.cl8;
import com.baidu.tieba.immessagecenter.msgtab.data.ForumListData;
import com.baidu.tieba.immessagecenter.msgtab.data.MsgTabForumData;
import com.baidu.tieba.immessagecenter.msgtab.obs.ForumChannelDataObs;
import com.baidu.tieba.immessagecenter.msgtab.repository.MsgCenterRepository;
import com.baidu.tieba.ofc;
import com.baidu.tieba.qu8;
import com.baidu.tieba.sac;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u001a\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J(\u0010\u0015\u001a\u00020\u000f2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00072\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002J\u001c\u0010\u0019\u001a\u00020\u000f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/model/MsgCenterContainerModel;", "", "()V", "mRepository", "Lcom/baidu/tieba/immessagecenter/msgtab/repository/MsgCenterRepository;", "mUiDataBs", "Lrx/subjects/BehaviorSubject;", "", "Lcom/baidu/tieba/immessagecenter/msgtab/data/NavigationData;", "uiDataSubject", "Lrx/Observable;", "getUiDataSubject", "()Lrx/Observable;", "cacheData", "createAndEmitData", "", "result", "Lcom/baidu/tieba/immessagecenter/msgtab/data/ForumListData;", "dispatchData", "forceRefresh", "", "mergeAndEmitData", "data", "Lcom/baidu/tieba/immessagecenter/msgtab/data/MsgTabForumData;", "oldData", "requestChannelData", "context", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgCenterContainerModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MsgCenterRepository a;
    public final ofc<List<qu8>> b;

    public MsgCenterContainerModel() {
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
        this.a = new MsgCenterRepository();
        ofc<List<qu8>> Q = ofc.Q();
        Intrinsics.checkNotNullExpressionValue(Q, "create()");
        this.b = Q;
        this.a.k(new Function1<ForumListData, Unit>(this) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.model.MsgCenterContainerModel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MsgCenterContainerModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ForumListData forumListData) {
                invoke2(forumListData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ForumListData forumListData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumListData) == null) {
                    this.this$0.d(true, forumListData);
                }
            }
        });
    }

    public final List<qu8> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b.T();
        }
        return (List) invokeV.objValue;
    }

    public final sac<List<qu8>> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            sac<List<qu8>> s = this.b.a().x().s(cbc.b());
            Intrinsics.checkNotNullExpressionValue(s, "mUiDataBs\n              …dSchedulers.mainThread())");
            return s;
        }
        return (sac) invokeV.objValue;
    }

    public final void c(ForumListData forumListData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumListData) == null) && forumListData != null) {
            ArrayList arrayList = new ArrayList();
            List<MsgTabForumData> forumData = forumListData.getForumData();
            if (forumData != null) {
                for (MsgTabForumData msgTabForumData : forumData) {
                    ForumChannelDataObs.b.a().g(msgTabForumData.getForumId(), msgTabForumData);
                    arrayList.add(new qu8(msgTabForumData.getForumId(), 3, false, 4, null));
                }
                ForumChannelDataObs.b.a().f();
            }
            if (cl8.a.b(arrayList, b())) {
                this.b.onNext(arrayList);
            }
        }
    }

    public final void d(boolean z, ForumListData forumListData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, forumListData) == null) {
            if (z) {
                c(forumListData);
            } else {
                f(forumListData);
            }
        }
    }

    public final void h(TbPageContext<BaseFragmentActivity> context, final boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, context, z) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.a.j(context, new Function1<ForumListData, Unit>(this, z) { // from class: com.baidu.tieba.immessagecenter.msgtab.ui.model.MsgCenterContainerModel$requestChannelData$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean $forceRefresh;
                public final /* synthetic */ MsgCenterContainerModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$forceRefresh = z;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ForumListData forumListData) {
                    invoke2(forumListData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(ForumListData forumListData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumListData) == null) {
                        this.this$0.d(this.$forceRefresh, forumListData);
                    }
                }
            });
        }
    }

    public final void f(ForumListData forumListData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, forumListData) == null) {
            try {
                List<qu8> b = b();
                if (forumListData != null) {
                    z = true;
                } else {
                    z = false;
                }
                List<MsgTabForumData> list = null;
                if (!z) {
                    b = null;
                }
                if (b != null) {
                    if (forumListData != null) {
                        list = forumListData.getForumData();
                    }
                    g(list, b);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public final void g(List<MsgTabForumData> list, List<qu8> list2) {
        qu8 qu8Var;
        Object obj;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, list, list2) == null) {
            ArrayList arrayList = new ArrayList();
            if (list2 != null) {
                int i = 0;
                for (Object obj2 : list2) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    qu8 qu8Var2 = (qu8) obj2;
                    if (qu8Var2.getType() != 3) {
                        arrayList.add(qu8Var2);
                    }
                    i = i2;
                }
            }
            if (list != null) {
                for (MsgTabForumData msgTabForumData : list) {
                    ForumChannelDataObs.b.a().g(msgTabForumData.getForumId(), msgTabForumData);
                    if (list2 != null) {
                        Iterator<T> it = list2.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                obj = it.next();
                                if (msgTabForumData.getForumId() == ((qu8) obj).a()) {
                                    z = true;
                                    continue;
                                } else {
                                    z = false;
                                    continue;
                                }
                                if (z) {
                                    break;
                                }
                            } else {
                                obj = null;
                                break;
                            }
                        }
                        qu8Var = (qu8) obj;
                        if (qu8Var != null) {
                            arrayList.add(qu8Var);
                        }
                    }
                    qu8Var = new qu8(msgTabForumData.getForumId(), 3, false, 4, null);
                    arrayList.add(qu8Var);
                }
                ForumChannelDataObs.b.a().f();
            }
            if (cl8.a.b(arrayList, b())) {
                this.b.onNext(arrayList);
            }
        }
    }
}
