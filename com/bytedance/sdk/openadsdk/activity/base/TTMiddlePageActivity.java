package com.bytedance.sdk.openadsdk.activity.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.b.b;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.e.d;
import com.bytedance.sdk.openadsdk.q.q;
import com.bytedance.sdk.openadsdk.q.s;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class TTMiddlePageActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f65131a;

    /* renamed from: b  reason: collision with root package name */
    public TTNativeExpressAd f65132b;

    /* renamed from: c  reason: collision with root package name */
    public m f65133c;

    /* renamed from: d  reason: collision with root package name */
    public AdSlot f65134d;

    /* renamed from: e  reason: collision with root package name */
    public b f65135e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f65136f;

    public TTMiddlePageActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65136f = false;
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        w jsObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(t.f(this, "tt_activity_middle_page"));
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    m a2 = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(intent.getStringExtra("middle_page_material_meta")));
                    this.f65133c = a2;
                    AdSlot b2 = b(a2);
                    this.f65134d = b2;
                    this.f65132b = new com.bytedance.sdk.openadsdk.core.nativeexpress.t(this, this.f65133c, b2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            TTNativeExpressAd tTNativeExpressAd = this.f65132b;
            if (tTNativeExpressAd == null) {
                finish();
                return;
            }
            View expressAdView = tTNativeExpressAd.getExpressAdView();
            if (expressAdView == null) {
                finish();
                return;
            }
            this.f65131a = (LinearLayout) findViewById(t.e(this, "tt_middle_page_layout"));
            if (expressAdView instanceof NativeExpressVideoView) {
                this.f65135e = ((NativeExpressVideoView) expressAdView).getClickListener();
            } else if (expressAdView instanceof NativeExpressView) {
                this.f65135e = ((NativeExpressView) expressAdView).getClickListener();
            }
            m mVar = this.f65133c;
            if (mVar != null && mVar.aD() == 2 && (expressAdView instanceof NativeExpressView) && (jsObject = ((NativeExpressView) expressAdView).getJsObject()) != null) {
                jsObject.a(this.f65134d);
            }
            this.f65132b.setCanInterruptVideoPlay(true);
            this.f65131a.removeAllViews();
            this.f65131a.addView(expressAdView);
            this.f65132b.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTMiddlePageActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTMiddlePageActivity f65137a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65137a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdClicked(View view, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, view, i2) == null) {
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdShow(View view, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderFail(View view, String str, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view, str, i2) == null) || this.f65137a.f65136f) {
                        return;
                    }
                    if (this.f65137a.f65133c != null && this.f65137a.f65133c.aD() == 1 && this.f65137a.f65135e != null) {
                        this.f65137a.f65136f = true;
                        this.f65137a.f65135e.e();
                    }
                    this.f65137a.finish();
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderSuccess(View view, float f2, float f3) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) || this.f65137a.isFinishing() || this.f65137a.f65133c == null) {
                        return;
                    }
                    d.b(o.a(), this.f65137a.f65133c, "feed_video_middle_page", "middle_page_show");
                }
            });
            this.f65132b.render();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDestroy();
            if (this.f65132b != null) {
                this.f65132b = null;
            }
            if (this.f65133c != null) {
                this.f65133c = null;
            }
        }
    }

    private AdSlot b(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, mVar)) == null) {
            if (mVar == null || mVar.ao() == null) {
                return null;
            }
            String str = q.d(mVar.ao()) + "";
            float c2 = s.c(this, s.c((Context) this));
            float f2 = 0.0f;
            try {
                f2 = s.i(getApplicationContext());
            } catch (Throwable unused) {
            }
            return new AdSlot.Builder().setCodeId(str).setExpressViewAcceptedSize(c2, s.c(this, s.d((Context) this) - f2)).build();
        }
        return (AdSlot) invokeL.objValue;
    }

    public static boolean a(Context context, m mVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, mVar)) == null) {
            if (mVar != null && context != null) {
                boolean z = mVar.aD() == 1;
                m.a Q = mVar.Q();
                if (z && Q != null) {
                    String jSONObject = mVar.aP().toString();
                    Intent intent = new Intent(context, TTMiddlePageActivity.class);
                    intent.putExtra("middle_page_material_meta", jSONObject);
                    com.bytedance.sdk.component.utils.b.a(context, intent, null);
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, mVar)) == null) {
            if (mVar == null) {
                return false;
            }
            return (mVar.aD() == 2) && mVar.Q() != null;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(Context context, m mVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, mVar)) == null) {
            if (context != null && a(mVar)) {
                String jSONObject = mVar.aP().toString();
                Intent intent = new Intent(context, TTMiddlePageActivity.class);
                intent.putExtra("middle_page_material_meta", jSONObject);
                com.bytedance.sdk.component.utils.b.a(context, intent, null);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
