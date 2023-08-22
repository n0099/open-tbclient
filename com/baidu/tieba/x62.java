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
import com.baidu.tieba.lh3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class x62 extends q62<LottieAnimationView, y62> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public String i;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.q62
    /* renamed from: Y */
    public void R(@NonNull LottieAnimationView lottieAnimationView, @NonNull y62 y62Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, lottieAnimationView, y62Var) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y62 a;
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

        public a(x62 x62Var, y62 y62Var, JSONObject jSONObject, LottieAnimationView lottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x62Var, y62Var, jSONObject, lottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y62Var;
            this.b = jSONObject;
            this.c = lottieAnimationView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                y62 y62Var = this.a;
                kq3.d(y62Var.c, y62Var.b, "animateview", "ended", this.b);
                d82.i("Component-AnimationView", "progress: " + this.c.getProgress());
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                d82.i("Component-AnimationView", "onAnimationRepeat ");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x62(@Nullable Context context, @NonNull y62 y62Var, @NonNull String str) {
        super(context, y62Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, y62Var, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (r62) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = str;
    }

    public static void Z(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("json", str);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str2);
            } catch (Exception e) {
                if (s62.h) {
                    e.printStackTrace();
                }
            }
            String jSONObject2 = jSONObject.toString();
            if (s62.h && TextUtils.isEmpty(jSONObject2)) {
                Log.d("Component-AnimationView", "reportLottieAnimationCrash: empty");
                return;
            }
            if (s62.h) {
                Log.d("Component-AnimationView", "reportLottieAnimationCrash: " + jSONObject2);
            }
            lh3.b bVar = new lh3.b(10009);
            bVar.i(jSONObject2);
            bVar.h(db3.g0());
            bVar.m();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.s62
    @NonNull
    /* renamed from: T */
    public LottieAnimationView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            return new LottieAnimationView(context);
        }
        return (LottieAnimationView) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.q62
    /* renamed from: V */
    public void O(@NonNull LottieAnimationView lottieAnimationView, @NonNull y62 y62Var, @NonNull v72 v72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lottieAnimationView, y62Var, v72Var) == null) {
            super.C(lottieAnimationView, y62Var, v72Var);
            W(lottieAnimationView, y62Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.q62
    /* renamed from: X */
    public void Q(@NonNull LottieAnimationView lottieAnimationView, @NonNull y62 y62Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, lottieAnimationView, y62Var) == null) {
            if (s62.h) {
                Log.d("Component-AnimationView", "renderBackground");
            }
            lottieAnimationView.setColorFilter(new PorterDuffColorFilter(y62Var.k, PorterDuff.Mode.ADD));
        }
    }

    public final void S(@NonNull LottieAnimationView lottieAnimationView, @NonNull y62 y62Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, lottieAnimationView, y62Var) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, y62Var.c);
                jSONObject.put("vtype", "ended");
                jSONObject2.putOpt("animationViewId", y62Var.b);
                jSONObject.put("data", jSONObject2.toString());
            } catch (JSONException e) {
                if (s62.h) {
                    e.printStackTrace();
                }
            }
            lottieAnimationView.addAnimatorListener(new a(this, y62Var, jSONObject, lottieAnimationView));
        }
    }

    public final void W(@NonNull LottieAnimationView lottieAnimationView, @NonNull y62 y62Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, lottieAnimationView, y62Var) != null) || !t()) {
            return;
        }
        if (s62.h) {
            Log.d("Component-AnimationView", "renderAction");
        }
        String str = y62Var.w;
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
    @Override // com.baidu.tieba.s62
    /* renamed from: U */
    public void A(@NonNull LottieAnimationView lottieAnimationView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, lottieAnimationView) == null) {
            super.A(lottieAnimationView);
            try {
                y62 y62Var = (y62) n();
                lottieAnimationView.loop(y62Var.u);
                lottieAnimationView.enableMergePathsForKitKatAndAbove(true);
                lottieAnimationView.setImageAssetDelegate(new w62(y62Var.t));
                lottieAnimationView.setAnimationFromJson(this.i, y62Var.b);
                if (y62Var.v) {
                    lottieAnimationView.playAnimation();
                }
                if (!y62Var.u) {
                    S(lottieAnimationView, y62Var);
                }
            } catch (Exception unused) {
                Z(this.i, db3.g0());
            }
        }
    }
}
