package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.data.HotEventData;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.n55;
import com.baidu.tieba.statemachine.animationtip.SpriteAnimationTipManager;
import com.baidu.tieba.yt6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class p55 extends n55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HotEventData c;
    public yf5 d;
    public SpriteAnimationTipManager e;

    /* loaded from: classes7.dex */
    public class a implements yt6.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p55 a;

        public a(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p55Var;
        }

        @Override // com.baidu.tieba.yt6.e
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements yt6.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p55 a;

        public b(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p55Var;
        }

        @Override // com.baidu.tieba.yt6.e
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p55(Activity activity, HotEventData hotEventData) {
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

    @Override // com.baidu.tieba.n55
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            yf5 yf5Var = this.d;
            if (yf5Var != null) {
                yf5Var.n();
            }
            SpriteAnimationTipManager spriteAnimationTipManager = this.e;
            if (spriteAnimationTipManager != null) {
                spriteAnimationTipManager.p();
            }
            eg5.s(false);
            hu6.b().b(new hfa(null, 1));
        }
    }

    @Override // com.baidu.tieba.n55
    public void d(@NonNull n55.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (YunDialogManager.isShowingDialog()) {
                aVar.callback(false);
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.e("HotEventTip", "S级事件弹窗无法展示，云弹窗正在展示：" + YunDialogManager.getShowingDialog());
            } else if (2 == fna.a().b().a().c && 1 == fna.a().b().b().c && 6 == fna.a().b().c().c) {
                DefaultLog.getInstance().e("HotEventTip", "直播tab不展示S级事件");
                aVar.callback(false);
            } else {
                aVar.callback(true);
            }
        }
    }

    @Override // com.baidu.tieba.n55
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (ep5.a().a()) {
                DefaultLog.getInstance().e("HotEventTip", "展示精灵动画提示控件形式的S级事件弹窗");
                this.e = eg5.t(this.c, new a(this));
                return;
            }
            DefaultLog.getInstance().e("HotEventTip", "展示页面顶部提示控件形式的S级事件弹窗");
            this.d = eg5.p(this.c, new b(this));
        }
    }
}
