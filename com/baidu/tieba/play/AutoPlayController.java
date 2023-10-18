package com.baidu.tieba.play;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.play.AutoPlayController;
import com.baidu.tieba.qv9;
import com.baidu.tieba.ut6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u001d\u0018\u00002\u00020\u0001:\u0001/B\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010#\u001a\u0004\u0018\u00010$J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\fJ\u0006\u0010(\u001a\u00020&J\u000e\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\fJ\u000e\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020&R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/baidu/tieba/play/AutoPlayController;", "", "context", "Lcom/baidu/adp/base/BdPageContext;", "recyclerView", "Lcom/baidu/adp/widget/ListView/BdRecyclerView;", "(Lcom/baidu/adp/base/BdPageContext;Lcom/baidu/adp/widget/ListView/BdRecyclerView;)V", "dragActionManager", "Lcom/baidu/tieba/dragAction/DragActionManager;", "firstVisibleItem", "", "isBackground", "", "()Z", "setBackground", "(Z)V", "isPlaySwitchEnabled", "setPlaySwitchEnabled", "isPullDown", "lastVisibleItem", "onCurrentCardBackgroundListener", "Lcom/baidu/tieba/play/AutoPlayController$OnCurrentCardBackgroundListener;", "getOnCurrentCardBackgroundListener", "()Lcom/baidu/tieba/play/AutoPlayController$OnCurrentCardBackgroundListener;", "setOnCurrentCardBackgroundListener", "(Lcom/baidu/tieba/play/AutoPlayController$OnCurrentCardBackgroundListener;)V", "onDragListener", "Lcom/baidu/tieba/dragAction/DragActionManager$onDragListener;", "onScrollListener", "com/baidu/tieba/play/AutoPlayController$onScrollListener$1", "Lcom/baidu/tieba/play/AutoPlayController$onScrollListener$1;", "onTouchListener", "Landroid/view/View$OnTouchListener;", "playSwitchController", "Lcom/baidu/tieba/play/PlaySwitchController;", "getCurrentPlayCard", "Landroid/view/View;", "notifyBackground", "", NotificationCompat.WearableExtender.KEY_BACKGROUND, MissionEvent.MESSAGE_DESTROY, "setIsHaveBottomTab", "haveBottomTab", "setUniqueId", "id", "Lcom/baidu/adp/BdUniqueId;", "startAutoPlay", "OnCurrentCardBackgroundListener", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AutoPlayController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final qv9 a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;
    public final ut6 g;
    public a h;
    public final AutoPlayController$onScrollListener$1 i;
    public final ut6.b j;
    public final View.OnTouchListener k;

    /* loaded from: classes7.dex */
    public interface a {
        void onBackground(boolean z);
    }

    /* loaded from: classes7.dex */
    public static final class b implements ut6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AutoPlayController a;

        @Override // com.baidu.tieba.ut6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.ut6.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }

        public b(AutoPlayController autoPlayController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {autoPlayController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = autoPlayController;
        }

        @Override // com.baidu.tieba.ut6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeII(1048576, this, i, i2) != null) {
                return;
            }
            this.a.f = false;
        }

        @Override // com.baidu.tieba.ut6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) != null) {
                return;
            }
            this.a.f = true;
        }
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [com.baidu.tieba.play.AutoPlayController$onScrollListener$1] */
    public AutoPlayController(BdPageContext<?> context, BdRecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, recyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.a = new qv9(context, recyclerView);
        this.e = true;
        this.g = new ut6();
        this.i = new RecyclerView.OnScrollListener(this) { // from class: com.baidu.tieba.play.AutoPlayController$onScrollListener$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AutoPlayController a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView2, int i3) {
                qv9 qv9Var;
                qv9 qv9Var2;
                int i4;
                int i5;
                boolean z;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, recyclerView2, i3) == null) {
                    Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                    if (i3 == 0) {
                        qv9Var = this.a.a;
                        if (qv9Var != null && this.a.j() && !this.a.i()) {
                            qv9Var2 = this.a.a;
                            i4 = this.a.b;
                            i5 = this.a.c;
                            z = this.a.f;
                            qv9Var2.m(i4, i5, z, 1);
                        }
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView2, i3, i4) == null) {
                    Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                    if (recyclerView2 instanceof BdRecyclerView) {
                        BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView2;
                        this.a.b = bdRecyclerView.getFirstVisiblePosition();
                        this.a.c = bdRecyclerView.getLastVisiblePosition();
                    }
                }
            }
        };
        this.j = new b(this);
        this.k = new View.OnTouchListener() { // from class: com.baidu.tieba.ev9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) ? AutoPlayController.m(AutoPlayController.this, view2, motionEvent) : invokeLL.booleanValue;
            }
        };
        this.a.p(2);
        recyclerView.addOnScrollListener(this.i);
        recyclerView.setOnTouchListener(this.k);
        this.g.d(this.j);
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.d = z;
        }
    }

    public final void o(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.h = aVar;
        }
    }

    public final void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.e = z;
        }
    }

    public final void q(BdUniqueId id) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, id) == null) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.a.u(id);
        }
    }

    public static final boolean m(AutoPlayController this$0, View view2, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, this$0, view2, motionEvent)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.g.c(motionEvent);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a.j();
        }
        return (View) invokeV.objValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.h();
        }
    }

    public final void r() {
        qv9 qv9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (qv9Var = this.a) != null && !this.d && this.e) {
            qv9Var.n(this.b, this.c, this.f, true);
        }
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.d = z;
            this.a.r(!z);
            a aVar = this.h;
            if (aVar != null) {
                aVar.onBackground(z);
            }
            if (this.d) {
                this.a.y();
            } else if (this.e) {
                this.a.n(this.b, this.c, this.f, true);
            }
        }
    }
}
