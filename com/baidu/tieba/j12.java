package com.baidu.tieba;

import android.animation.Animator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tieba.xb3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class j12 extends d12<LottieAnimationView, k12> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public String i;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.d12
    /* renamed from: a0 */
    public void T(@NonNull LottieAnimationView lottieAnimationView, @NonNull k12 k12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, lottieAnimationView, k12Var) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k12 a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ LottieAnimationView c;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public a(j12 j12Var, k12 k12Var, JSONObject jSONObject, LottieAnimationView lottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j12Var, k12Var, jSONObject, lottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k12Var;
            this.b = jSONObject;
            this.c = lottieAnimationView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                k12 k12Var = this.a;
                wk3.d(k12Var.c, k12Var.b, "animateview", "ended", this.b);
                p22.i("Component-AnimationView", "progress: " + this.c.getProgress());
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                p22.i("Component-AnimationView", "onAnimationRepeat ");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j12(@Nullable Context context, @NonNull k12 k12Var, @NonNull String str) {
        super(context, k12Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, k12Var, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (e12) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = str;
    }

    public static void b0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("json", str);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str2);
            } catch (Exception e) {
                if (f12.h) {
                    e.printStackTrace();
                }
            }
            String jSONObject2 = jSONObject.toString();
            if (f12.h && TextUtils.isEmpty(jSONObject2)) {
                Log.d("Component-AnimationView", "reportLottieAnimationCrash: empty");
                return;
            }
            if (f12.h) {
                Log.d("Component-AnimationView", "reportLottieAnimationCrash: " + jSONObject2);
            }
            xb3.b bVar = new xb3.b(10009);
            bVar.i(jSONObject2);
            bVar.h(p53.h0());
            bVar.m();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.f12
    @NonNull
    /* renamed from: V */
    public LottieAnimationView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            return new LottieAnimationView(context);
        }
        return (LottieAnimationView) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.d12
    /* renamed from: X */
    public void Q(@NonNull LottieAnimationView lottieAnimationView, @NonNull k12 k12Var, @NonNull h22 h22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lottieAnimationView, k12Var, h22Var) == null) {
            super.D(lottieAnimationView, k12Var, h22Var);
            Y(lottieAnimationView, k12Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.d12
    /* renamed from: Z */
    public void S(@NonNull LottieAnimationView lottieAnimationView, @NonNull k12 k12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, lottieAnimationView, k12Var) == null) {
            if (f12.h) {
                Log.d("Component-AnimationView", "renderBackground");
            }
            lottieAnimationView.setColorFilter(new PorterDuffColorFilter(k12Var.k, PorterDuff.Mode.ADD));
        }
    }

    public final void U(@NonNull LottieAnimationView lottieAnimationView, @NonNull k12 k12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, lottieAnimationView, k12Var) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, k12Var.c);
                jSONObject.put("vtype", "ended");
                jSONObject2.putOpt("animationViewId", k12Var.b);
                jSONObject.put("data", jSONObject2.toString());
            } catch (JSONException e) {
                if (f12.h) {
                    e.printStackTrace();
                }
            }
            lottieAnimationView.addAnimatorListener(new a(this, k12Var, jSONObject, lottieAnimationView));
        }
    }

    public final void Y(@NonNull LottieAnimationView lottieAnimationView, @NonNull k12 k12Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, lottieAnimationView, k12Var) != null) || !t()) {
            return;
        }
        if (f12.h) {
            Log.d("Component-AnimationView", "renderAction");
        }
        String str = k12Var.w;
        if (TextUtils.equals(str, "play")) {
            lottieAnimationView.resumeAnimation();
        } else if (TextUtils.equals(str, DownloadStatisticConstants.UBC_TYPE_PAUSE)) {
            lottieAnimationView.pauseAnimation();
        } else if (TextUtils.equals(str, "stop")) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setProgress(0.0f);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.f12
    /* renamed from: W */
    public void B(@NonNull LottieAnimationView lottieAnimationView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, lottieAnimationView) == null) {
            super.B(lottieAnimationView);
            try {
                k12 k12Var = (k12) n();
                lottieAnimationView.loop(k12Var.u);
                lottieAnimationView.enableMergePathsForKitKatAndAbove(true);
                lottieAnimationView.setImageAssetDelegate(new i12(k12Var.t));
                lottieAnimationView.setAnimationFromJson(this.i, k12Var.b);
                if (k12Var.v) {
                    lottieAnimationView.playAnimation();
                }
                if (!k12Var.u) {
                    U(lottieAnimationView, k12Var);
                }
            } catch (Exception unused) {
                b0(this.i, p53.h0());
            }
        }
    }
}
