package com.bytedance.sdk.openadsdk.activity.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.n;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class TTMiddlePageActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f4132a;
    private TTNativeExpressAd b;
    private l c;
    private AdSlot d;
    private b e;
    private boolean f = false;

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        x jsObject;
        super.onCreate(bundle);
        setContentView(ac.f(this, "tt_activity_middle_page"));
        Intent intent = getIntent();
        if (intent != null) {
            try {
                this.c = c.a(new JSONObject(intent.getStringExtra("middle_page_material_meta")));
                this.d = b(this.c);
                this.b = new n(this, this.c, this.d);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.b == null) {
            finish();
            return;
        }
        View expressAdView = this.b.getExpressAdView();
        if (expressAdView == null) {
            finish();
            return;
        }
        this.f4132a = (LinearLayout) findViewById(ac.e(this, "tt_middle_page_layout"));
        if (expressAdView instanceof NativeExpressVideoView) {
            this.e = ((NativeExpressVideoView) expressAdView).getClickListener();
        } else if (expressAdView instanceof NativeExpressView) {
            this.e = ((NativeExpressView) expressAdView).getClickListener();
        }
        if (this.c != null && this.c.az() == 2 && (expressAdView instanceof NativeExpressView) && (jsObject = ((NativeExpressView) expressAdView).getJsObject()) != null) {
            jsObject.a(this.d);
        }
        this.b.setCanInterruptVideoPlay(true);
        this.f4132a.removeAllViews();
        this.f4132a.addView(expressAdView);
        this.b.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTMiddlePageActivity.1
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i) {
                if (!TTMiddlePageActivity.this.f) {
                    if (TTMiddlePageActivity.this.c != null && TTMiddlePageActivity.this.c.az() == 1 && TTMiddlePageActivity.this.e != null) {
                        TTMiddlePageActivity.this.f = true;
                        TTMiddlePageActivity.this.e.e();
                    }
                    TTMiddlePageActivity.this.finish();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f, float f2) {
                d.b(p.a(), TTMiddlePageActivity.this.c, "feed_video_middle_page", "middle_page_show");
            }
        });
        this.b.render();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.b != null) {
            this.b = null;
        }
        if (this.c != null) {
            this.c = null;
        }
    }

    private AdSlot b(l lVar) {
        if (lVar == null || lVar.aj() == null) {
            return null;
        }
        String str = aj.d(lVar.aj()) + "";
        float b = ak.b(this, ak.c(this));
        float f = 0.0f;
        try {
            f = ak.i(getApplicationContext());
        } catch (Throwable th) {
        }
        return new AdSlot.Builder().setCodeId(str).setExpressViewAcceptedSize(b, ak.b(this, ak.d(this) - f)).build();
    }

    public static boolean a(Context context, l lVar) {
        if (lVar == null || context == null) {
            return false;
        }
        boolean z = lVar.az() == 1;
        l.a N = lVar.N();
        if (!z || N == null) {
            return false;
        }
        String jSONObject = lVar.aE().toString();
        Intent intent = new Intent(context, TTMiddlePageActivity.class);
        intent.putExtra("middle_page_material_meta", jSONObject);
        com.bytedance.sdk.openadsdk.utils.b.a(context, intent, null);
        return true;
    }

    public static boolean b(Context context, l lVar) {
        if (context != null && a(lVar)) {
            String jSONObject = lVar.aE().toString();
            Intent intent = new Intent(context, TTMiddlePageActivity.class);
            intent.putExtra("middle_page_material_meta", jSONObject);
            com.bytedance.sdk.openadsdk.utils.b.a(context, intent, null);
            return true;
        }
        return false;
    }

    public static boolean a(l lVar) {
        if (lVar == null) {
            return false;
        }
        return (lVar.az() == 2) && lVar.N() != null;
    }
}
