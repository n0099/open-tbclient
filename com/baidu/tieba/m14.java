package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.game.guide.dialog.GamenowRecommendPopView;
import com.baidu.swan.game.guide.view.GameGuideViewContainer;
import com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
@Singleton
@Service
/* loaded from: classes7.dex */
public class m14 implements r84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements GamenowRecommendPopView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameCloseGuidePopView.e a;

        public a(m14 m14Var, GameCloseGuidePopView.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m14Var, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // com.baidu.swan.game.guide.dialog.GamenowRecommendPopView.e
        public void a() {
            GameCloseGuidePopView.e eVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (eVar = this.a) == null) {
                return;
            }
            eVar.a();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947919801, "Lcom/baidu/tieba/m14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947919801, "Lcom/baidu/tieba/m14;");
                return;
            }
        }
        boolean z = rr1.a;
    }

    public m14() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.r84
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            r14.n().t();
        }
    }

    @Override // com.baidu.tieba.r84
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            r14.n().u();
        }
    }

    @Override // com.baidu.tieba.r84
    public View a(Context context, GameCloseGuidePopView.e eVar) {
        InterceptResult invokeLL;
        g14 g14Var;
        GameGuideConfigInfo z;
        GameGuideConfigInfo.CloseInfo closeInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, eVar)) == null) {
            if (context == null || (g14Var = g14.o) == null) {
                return null;
            }
            String I = g14Var.I();
            if ((!TextUtils.equals(I, l14.a) && bp3.F(context, I)) || (z = g14.o.z()) == null || (closeInfo = z.closeInfo) == null) {
                return null;
            }
            int i = closeInfo.type;
            ArrayList<GameGuideConfigInfo.RecommendGameInfo> arrayList = closeInfo.gameList;
            if ((i != 0 || arrayList == null || arrayList.size() < 3) && ((i != 1 || arrayList == null || arrayList.size() < 6) && i != 2)) {
                return null;
            }
            if (i != 0 && i != 1) {
                if (i == 2) {
                    d24.n().c("gbADialogShow");
                }
            } else {
                d24.n().c("gbBDialogShow");
            }
            GamenowRecommendPopView gamenowRecommendPopView = new GamenowRecommendPopView(context, closeInfo);
            gamenowRecommendPopView.setOnClickListener(new a(this, eVar));
            return gamenowRecommendPopView;
        }
        return (View) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.r84
    public void b(int i) {
        g14 g14Var;
        GameGuideViewContainer B;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (g14Var = g14.o) != null && (B = g14Var.B()) != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) B.getLayoutParams();
            layoutParams.rightMargin = i;
            B.setLayoutParams(layoutParams);
        }
    }
}
