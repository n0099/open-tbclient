package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.data.HotEventData;
import com.baidu.tieba.or6;
import com.baidu.tieba.s55;
import com.baidu.tieba.statemachine.animationtip.SpriteAnimationTipManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class u55 extends s55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HotEventData c;
    public he5 d;
    public SpriteAnimationTipManager e;

    /* loaded from: classes8.dex */
    public class a implements or6.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u55 a;

        public a(u55 u55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u55Var;
        }

        @Override // com.baidu.tieba.or6.e
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements or6.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u55 a;

        public b(u55 u55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u55Var;
        }

        @Override // com.baidu.tieba.or6.e
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u55(Activity activity, HotEventData hotEventData) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, hotEventData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = hotEventData;
    }

    @Override // com.baidu.tieba.s55
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            he5 he5Var = this.d;
            if (he5Var != null) {
                he5Var.m();
            }
            SpriteAnimationTipManager spriteAnimationTipManager = this.e;
            if (spriteAnimationTipManager != null) {
                spriteAnimationTipManager.p();
            }
            qf5.s(false);
            wr6.b().b(new zv9(null, 1));
        }
    }

    @Override // com.baidu.tieba.s55
    public void d(@NonNull s55.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (z55.j()) {
                aVar.callback(false);
                zq8 defaultLog = DefaultLog.getInstance();
                defaultLog.b("HotEventTip", "S级事件弹窗无法展示，云弹窗正在展示：" + z55.i());
            } else if (2 == w3a.a().b().a().c && 1 == w3a.a().b().b().c && 6 == w3a.a().b().c().c) {
                DefaultLog.getInstance().b("HotEventTip", "直播tab不展示S级事件");
                aVar.callback(false);
            } else {
                aVar.callback(true);
            }
        }
    }

    @Override // com.baidu.tieba.s55
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (fn5.d()) {
                DefaultLog.getInstance().b("HotEventTip", "展示精灵动画提示控件形式的S级事件弹窗");
                this.e = qf5.t(this.c, new a(this));
                return;
            }
            DefaultLog.getInstance().b("HotEventTip", "展示页面顶部提示控件形式的S级事件弹窗");
            this.d = qf5.p(this.c, new b(this));
        }
    }
}
