package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class qr0 extends vr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948101306, "Lcom/baidu/tieba/qr0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948101306, "Lcom/baidu/tieba/qr0;");
        }
    }

    /* loaded from: classes7.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qr0 a;

        public a(qr0 qr0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qr0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qr0Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A();
            }
        }
    }

    public qr0() {
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

    @Override // com.baidu.tieba.vr0
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c.bottomMargin = k31.b(45.0f);
            this.c.leftMargin = k31.b(15.0f);
            TextView mNextTips = this.b;
            Intrinsics.checkNotNullExpressionValue(mNextTips, "mNextTips");
            mNextTips.setLayoutParams(this.c);
        }
    }

    @Override // com.baidu.tieba.vr0
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b.postDelayed(new a(this), 5000L);
        }
    }

    @Override // com.baidu.tieba.vr0
    public void H() {
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.bottomMargin = k31.b(10.0f);
            FrameLayout.LayoutParams layoutParams = this.c;
            if (s().T()) {
                b = k31.b(45.0f);
            } else {
                b = k31.b(15.0f);
            }
            layoutParams.leftMargin = b;
            TextView mNextTips = this.b;
            Intrinsics.checkNotNullExpressionValue(mNextTips, "mNextTips");
            mNextTips.setLayoutParams(this.c);
        }
    }

    @Override // com.baidu.tieba.vr0, com.baidu.tieba.hr0
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TextView textView = new TextView(f());
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            textView.setTextSize(0, context.getResources().getDimension(R.dimen.nad_videoplayer_immersive_video_next_text_size));
            textView.setTextColor(-1);
            textView.setBackground(ContextCompat.getDrawable(textView.getContext(), R.drawable.nad_videoplayer_next_play_tips_background));
            textView.setGravity(16);
            textView.setAlpha(0.0f);
            textView.setMaxEms(18);
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setIncludeFontPadding(false);
            textView.setPadding(k31.b(13.0f), 0, k31.b(13.0f), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, k31.b(24.0f));
            this.c = layoutParams;
            layoutParams.gravity = BadgeDrawable.BOTTOM_START;
            layoutParams.leftMargin = k31.b(15.0f);
            textView.setLayoutParams(this.c);
            Unit unit = Unit.INSTANCE;
            this.b = textView;
            B();
        }
    }

    @Override // com.baidu.tieba.vr0, com.baidu.tieba.hr0
    public void l(ms0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            String c = event.c();
            switch (c.hashCode()) {
                case -1327414233:
                    if (c.equals(LayerEvent.ACTION_OPTIMIZE_CONTINUE_TIPS_SHOW)) {
                        if (s().n1()) {
                            return;
                        }
                        Object f = event.f(24);
                        if (!(f instanceof String)) {
                            f = null;
                        }
                        String str = (String) f;
                        if (str == null) {
                            str = "";
                        }
                        TextView mNextTips = this.b;
                        Intrinsics.checkNotNullExpressionValue(mNextTips, "mNextTips");
                        mNextTips.setText(str);
                        if (this.d) {
                            I();
                        } else {
                            H();
                        }
                        if (!C()) {
                            J();
                            return;
                        }
                        return;
                    }
                    break;
                case -552621273:
                    if (c.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        A();
                        return;
                    }
                    break;
                case -552580917:
                    if (c.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        E(false);
                        return;
                    }
                    break;
                case 1933234291:
                    if (c.equals(ControlEvent.ACTION_CONTINUE_TIPS_SHOW)) {
                        return;
                    }
                    break;
            }
            super.l(event);
        }
    }
}
