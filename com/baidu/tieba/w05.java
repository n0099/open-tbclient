package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.data.HotEventData;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.sq6;
import com.baidu.tieba.statemachine.animationtip.SpriteAnimationTipManager;
import com.baidu.tieba.u05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class w05 extends u05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HotEventData c;
    public mb5 d;
    public SpriteAnimationTipManager e;

    /* loaded from: classes8.dex */
    public class a implements sq6.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w05 a;

        public a(w05 w05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w05Var;
        }

        @Override // com.baidu.tieba.sq6.e
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements sq6.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w05 a;

        public b(w05 w05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w05Var;
        }

        @Override // com.baidu.tieba.sq6.e
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w05(Activity activity, HotEventData hotEventData) {
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

    @Override // com.baidu.tieba.u05
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            mb5 mb5Var = this.d;
            if (mb5Var != null) {
                mb5Var.n();
            }
            SpriteAnimationTipManager spriteAnimationTipManager = this.e;
            if (spriteAnimationTipManager != null) {
                spriteAnimationTipManager.q();
            }
            sb5.s(false);
            br6.b().c(new bua(null, 1));
        }
    }

    @Override // com.baidu.tieba.u05
    public void d(@NonNull u05.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (YunDialogManager.isShowingDialog()) {
                aVar.callback(false);
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.e("HotEventTip", "S级事件弹窗无法展示，云弹窗正在展示：" + YunDialogManager.getShowingDialog());
            } else if (2 == z1b.b().c().a().c && 1 == z1b.b().c().b().c && 6 == z1b.b().c().c().c) {
                DefaultLog.getInstance().e("HotEventTip", "直播tab不展示S级事件");
                aVar.callback(false);
            } else {
                aVar.callback(true);
            }
        }
    }

    @Override // com.baidu.tieba.u05
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (ql5.a().a()) {
                DefaultLog.getInstance().e("HotEventTip", "展示精灵动画提示控件形式的S级事件弹窗");
                this.e = sb5.t(this.c, new a(this));
                return;
            }
            DefaultLog.getInstance().e("HotEventTip", "展示页面顶部提示控件形式的S级事件弹窗");
            this.d = sb5.p(this.c, new b(this));
        }
    }
}
