package com.baidu.tieba;

import com.baidu.tieba.immessagecenter.mention.base.NotificationView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class ps8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NotificationView a;
    public boolean b;
    public final a c;

    /* loaded from: classes7.dex */
    public static final class a implements NotificationView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ps8 a;

        public a(ps8 ps8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ps8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ps8Var;
        }

        @Override // com.baidu.tieba.immessagecenter.mention.base.NotificationView.b
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NotificationView notificationView = this.a.a;
                if (notificationView != null) {
                    notificationView.setVisibility(8);
                }
                this.a.b = false;
            }
        }
    }

    public ps8(NotificationView notificationView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {notificationView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = notificationView;
        a aVar = new a(this);
        this.c = aVar;
        NotificationView notificationView2 = this.a;
        if (notificationView2 != null) {
            notificationView2.setOnCloseListener(aVar);
        }
    }
}
