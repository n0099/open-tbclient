package com.baidu.tieba.pb.pb.main.controller;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.widget.TbLabelWidget;
import com.baidu.tieba.pb.pb.main.controller.PbContentCollectionController;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u0017\u001a\u00020\u0014J\u0010\u0010\u0018\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u001a\u001a\u00020\u0014J\u0006\u0010\u001b\u001a\u00020\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/baidu/tieba/pb/pb/main/controller/PbContentCollectionController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "hasLoggedWhenScroll", "", "getHasLoggedWhenScroll", "()Z", "setHasLoggedWhenScroll", "(Z)V", "labelWidget", "Lcom/baidu/tbadk/widget/TbLabelWidget;", "getLabelWidget", "()Lcom/baidu/tbadk/widget/TbLabelWidget;", "labelWidget$delegate", "Lkotlin/Lazy;", "threadData", "Lcom/baidu/tbadk/core/data/ThreadData;", "addContentCollection", "", "listView", "Lcom/baidu/adp/widget/ListView/BdTypeListView;", "onChangeSkin", "removeContentCollection", "setContentCollectionData", "showStatistic", "showStatisticOnScroll", "Companion", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class PbContentCollectionController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public boolean b;
    public ThreadData c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(255207557, "Lcom/baidu/tieba/pb/pb/main/controller/PbContentCollectionController;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(255207557, "Lcom/baidu/tieba/pb/pb/main/controller/PbContentCollectionController;");
        }
    }

    public PbContentCollectionController(final Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<TbLabelWidget>(context) { // from class: com.baidu.tieba.pb.pb.main.controller.PbContentCollectionController$labelWidget$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ Context $context;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {context};
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
                this.$context = context;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TbLabelWidget invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new TbLabelWidget(this.$context);
                }
                return (TbLabelWidget) invokeV.objValue;
            }
        });
        b().setVisibility(8);
    }

    public static final void f(ThreadData threadData, View view2, int i, TbLabelWidget.c cVar) {
        ThreadRecommendInfoData threadRecommendInfoData;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65538, null, threadData, view2, i, cVar) == null) {
            Intrinsics.checkNotNullParameter(threadData, "$threadData");
            int i3 = 1;
            if (i != 0) {
                if (1 == i) {
                    i3 = 2;
                } else {
                    i3 = -1;
                }
            }
            StatisticItem addParam = new StatisticItem(CommonStatisticKey.KEY_PB_CONTENT_COLLECTION_VIEW_CLICK).addParam("tid", threadData.getTid()).addParam("obj_locate", i3).addParam("obj_param1", cVar.j);
            List<ThreadRecommendInfoData> threadRecommendInfoDataList = threadData.getThreadRecommendInfoDataList();
            if (threadRecommendInfoDataList != null && (threadRecommendInfoData = threadRecommendInfoDataList.get(0)) != null && (i2 = threadRecommendInfoData.albumType) != -1) {
                addParam.addParam("obj_type", i2);
            }
            addParam.eventStat();
        }
    }

    public final void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) && bdTypeListView != null) {
            if (b().getParent() != null) {
                bdTypeListView.removeHeaderView(b());
            }
            bdTypeListView.addHeaderView(b());
        }
    }

    public final void d(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) && bdTypeListView != null) {
            bdTypeListView.removeHeaderView(b());
        }
    }

    public final void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.b = z;
        }
    }

    public final TbLabelWidget b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (TbLabelWidget) this.a.getValue();
        }
        return (TbLabelWidget) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && b().getVisibility() == 0) {
            b().k();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && !this.b) {
            h();
        }
    }

    public final void e(final ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            Intrinsics.checkNotNullParameter(threadData, "threadData");
            this.c = threadData;
            b().setVisibility(0);
            b().setStyleForPb();
            b().setData(threadData);
            b().setEventCallback(new TbLabelWidget.b() { // from class: com.baidu.tieba.k2a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tbadk.widget.TbLabelWidget.b
                public final void a(View view2, int i, TbLabelWidget.c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, view2, i, cVar) == null) {
                        PbContentCollectionController.f(ThreadData.this, view2, i, cVar);
                    }
                }
            });
        }
    }

    public final void h() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (threadData = this.c) != null && threadData.getThreadRecommendInfoDataList() != null && threadData.getThreadRecommendInfoDataList().get(0) != null) {
            ThreadRecommendInfoData threadRecommendInfoData = threadData.getThreadRecommendInfoDataList().get(0);
            Intrinsics.checkNotNullExpressionValue(threadRecommendInfoData, "it.threadRecommendInfoDataList[0]");
            ThreadRecommendInfoData threadRecommendInfoData2 = threadRecommendInfoData;
            StatisticItem addParam = new StatisticItem(CommonStatisticKey.KEY_PB_CONTENT_COLLECTION_VIEW_SHOW).addParam("tid", threadData.getTid()).addParam("obj_param1", threadRecommendInfoData2.businessId);
            int i = threadRecommendInfoData2.albumType;
            if (i != -1) {
                addParam.addParam("obj_type", i);
            }
            addParam.eventStat();
        }
    }
}
