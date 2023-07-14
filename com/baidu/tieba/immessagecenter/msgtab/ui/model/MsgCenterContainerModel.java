package com.baidu.tieba.immessagecenter.msgtab.ui.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tieba.e2c;
import com.baidu.tieba.immessagecenter.msgtab.data.ForumListData;
import com.baidu.tieba.immessagecenter.msgtab.data.MsgTabForumData;
import com.baidu.tieba.immessagecenter.msgtab.data.MsgTabFunctionData;
import com.baidu.tieba.immessagecenter.msgtab.obs.ForumChannelDataObs;
import com.baidu.tieba.immessagecenter.msgtab.obs.NewsRemindMsgMonitor;
import com.baidu.tieba.immessagecenter.msgtab.repository.MsgCenterRepository;
import com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgTabGuide;
import com.baidu.tieba.p6c;
import com.baidu.tieba.tr8;
import com.baidu.tieba.u1c;
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
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u001a\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\u0012\u0010\u001a\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J(\u0010\u001a\u001a\u00020\u00122\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00052\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002J\u001c\u0010\u001e\u001a\u00020\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\"\u001a\u00020\u0012R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/model/MsgCenterContainerModel;", "", "()V", "bodyUiDataSubject", "Lrx/Observable;", "", "Lcom/baidu/tieba/immessagecenter/msgtab/data/NavigationData;", "getBodyUiDataSubject", "()Lrx/Observable;", "headerUiDataSubject", "getHeaderUiDataSubject", "mBodyDataBs", "Lrx/subjects/BehaviorSubject;", "mHeaderDataBs", "mRepository", "Lcom/baidu/tieba/immessagecenter/msgtab/repository/MsgCenterRepository;", "cacheData", "createAndEmitData", "", "result", "Lcom/baidu/tieba/immessagecenter/msgtab/data/ForumListData;", "defaultHeaderData", "dispatchData", "forceRefresh", "", "haveNotifyUnreadMsg", "mergeAndEmitData", "data", "Lcom/baidu/tieba/immessagecenter/msgtab/data/MsgTabForumData;", "oldData", "requestChannelData", "context", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "resetSelectedItem", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgCenterContainerModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MsgCenterRepository a;
    public final p6c<List<tr8>> b;
    public final p6c<List<tr8>> c;

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
        p6c<List<tr8>> Q = p6c.Q();
        Intrinsics.checkNotNullExpressionValue(Q, "create()");
        this.b = Q;
        p6c<List<tr8>> Q2 = p6c.Q();
        Intrinsics.checkNotNullExpressionValue(Q2, "create()");
        this.c = Q2;
        this.b.onNext(d());
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
                    this.this$0.e(true, forumListData);
                }
            }
        });
    }

    public final List<tr8> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.T();
        }
        return (List) invokeV.objValue;
    }

    public final u1c<List<tr8>> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            u1c<List<tr8>> s = this.c.a().x().s(e2c.b());
            Intrinsics.checkNotNullExpressionValue(s, "mBodyDataBs\n            …dSchedulers.mainThread())");
            return s;
        }
        return (u1c) invokeV.objValue;
    }

    public final u1c<List<tr8>> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            u1c<List<tr8>> s = this.b.a().x().s(e2c.b());
            Intrinsics.checkNotNullExpressionValue(s, "mHeaderDataBs\n          …dSchedulers.mainThread())");
            return s;
        }
        return (u1c) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.onNext(d());
        }
    }

    public final void c(ForumListData forumListData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumListData) == null) && forumListData != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new tr8(-1L, 5, false, 4, null));
            List<MsgTabForumData> forumData = forumListData.getForumData();
            if (forumData != null) {
                for (MsgTabForumData msgTabForumData : forumData) {
                    ForumChannelDataObs.c.a().i(msgTabForumData.getForumId(), msgTabForumData);
                    arrayList.add(new tr8(msgTabForumData.getForumId(), 3, false, 4, null));
                }
            }
            long j = 0;
            List<MsgTabFunctionData> extFunctionData = forumListData.getExtFunctionData();
            if (extFunctionData != null) {
                for (MsgTabFunctionData msgTabFunctionData : extFunctionData) {
                    j++;
                    ForumChannelDataObs.c.a().j(j, msgTabFunctionData);
                    arrayList.add(new tr8(j, 4, false, 4, null));
                }
            }
            this.c.onNext(arrayList);
        }
    }

    public final List<tr8> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            boolean h = h();
            arrayList.add(new tr8(-1L, 1, h));
            arrayList.add(new tr8(-2L, 2, !h));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            NewsRemindMessage m = NewsRemindMsgMonitor.f.a().m();
            if (m.getNotificationCount() + m.getMsgCount() <= 0 && !MsgTabGuide.j.b()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void e(boolean z, ForumListData forumListData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048579, this, z, forumListData) == null) {
            if (z) {
                c(forumListData);
            } else {
                i(forumListData);
            }
        }
    }

    public final void k(TbPageContext<BaseFragmentActivity> context, final boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, context, z) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (z) {
                this.b.onNext(d());
            }
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
                        this.this$0.e(this.$forceRefresh, forumListData);
                    }
                }
            });
        }
    }

    public final void i(ForumListData forumListData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, forumListData) == null) {
            try {
                List<tr8> b = b();
                if (b != null) {
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
                        j(list, b);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public final void j(List<MsgTabForumData> list, List<tr8> list2) {
        int i;
        tr8 tr8Var;
        Object obj;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, list2) == null) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            if (list2 != null) {
                int i3 = 0;
                i = 0;
                for (Object obj2 : list2) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    tr8 tr8Var2 = (tr8) obj2;
                    if (tr8Var2.getType() != 3) {
                        arrayList.add(tr8Var2);
                    }
                    if (tr8Var2.getType() == 5) {
                        i = i3;
                    }
                    i3 = i4;
                }
            } else {
                i = 0;
            }
            if (list != null) {
                for (MsgTabForumData msgTabForumData : list) {
                    ForumChannelDataObs.c.a().i(msgTabForumData.getForumId(), msgTabForumData);
                    if (list2 != null) {
                        Iterator<T> it = list2.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                obj = it.next();
                                if (msgTabForumData.getForumId() == ((tr8) obj).c()) {
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
                        tr8Var = (tr8) obj;
                        if (tr8Var != null) {
                            i++;
                            arrayList.add(i, tr8Var);
                        }
                    }
                    tr8Var = new tr8(msgTabForumData.getForumId(), 3, false, 4, null);
                    i++;
                    arrayList.add(i, tr8Var);
                }
            }
            this.c.onNext(arrayList);
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (((tr8) it2.next()).d()) {
                        break;
                    }
                    i2++;
                } else {
                    i2 = -1;
                    break;
                }
            }
            if (i2 < 0) {
                this.b.onNext(d());
            }
        }
    }
}
