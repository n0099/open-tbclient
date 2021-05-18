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
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class TTMiddlePageActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f27184a;

    /* renamed from: b  reason: collision with root package name */
    public TTNativeExpressAd f27185b;

    /* renamed from: c  reason: collision with root package name */
    public l f27186c;

    /* renamed from: d  reason: collision with root package name */
    public AdSlot f27187d;

    /* renamed from: e  reason: collision with root package name */
    public b f27188e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f27189f = false;

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        x jsObject;
        super.onCreate(bundle);
        setContentView(ad.f(this, "tt_activity_middle_page"));
        Intent intent = getIntent();
        if (intent != null) {
            try {
                l a2 = c.a(new JSONObject(intent.getStringExtra("middle_page_material_meta")));
                this.f27186c = a2;
                AdSlot b2 = b(a2);
                this.f27187d = b2;
                this.f27185b = new n(this, this.f27186c, b2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        TTNativeExpressAd tTNativeExpressAd = this.f27185b;
        if (tTNativeExpressAd == null) {
            finish();
            return;
        }
        View expressAdView = tTNativeExpressAd.getExpressAdView();
        if (expressAdView == null) {
            finish();
            return;
        }
        this.f27184a = (LinearLayout) findViewById(ad.e(this, "tt_middle_page_layout"));
        if (expressAdView instanceof NativeExpressVideoView) {
            this.f27188e = ((NativeExpressVideoView) expressAdView).getClickListener();
        } else if (expressAdView instanceof NativeExpressView) {
            this.f27188e = ((NativeExpressView) expressAdView).getClickListener();
        }
        l lVar = this.f27186c;
        if (lVar != null && lVar.aG() == 2 && (expressAdView instanceof NativeExpressView) && (jsObject = ((NativeExpressView) expressAdView).getJsObject()) != null) {
            jsObject.a(this.f27187d);
        }
        this.f27185b.setCanInterruptVideoPlay(true);
        this.f27184a.removeAllViews();
        this.f27184a.addView(expressAdView);
        this.f27185b.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTMiddlePageActivity.1
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i2) {
                if (TTMiddlePageActivity.this.f27189f) {
                    return;
                }
                if (TTMiddlePageActivity.this.f27186c != null && TTMiddlePageActivity.this.f27186c.aG() == 1 && TTMiddlePageActivity.this.f27188e != null) {
                    TTMiddlePageActivity.this.f27189f = true;
                    TTMiddlePageActivity.this.f27188e.e();
                }
                TTMiddlePageActivity.this.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f2, float f3) {
                if (TTMiddlePageActivity.this.isFinishing() || TTMiddlePageActivity.this.f27186c == null) {
                    return;
                }
                d.b(p.a(), TTMiddlePageActivity.this.f27186c, "feed_video_middle_page", "middle_page_show");
            }
        });
        this.f27185b.render();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f27185b != null) {
            this.f27185b = null;
        }
        if (this.f27186c != null) {
            this.f27186c = null;
        }
    }

    private AdSlot b(l lVar) {
        if (lVar == null || lVar.ap() == null) {
            return null;
        }
        String str = ak.d(lVar.ap()) + "";
        float b2 = al.b(this, al.c(this));
        float f2 = 0.0f;
        try {
            f2 = al.i(getApplicationContext());
        } catch (Throwable unused) {
        }
        return new AdSlot.Builder().setCodeId(str).setExpressViewAcceptedSize(b2, al.b(this, al.d(this) - f2)).build();
    }

    public static boolean a(Context context, l lVar) {
        if (lVar != null && context != null) {
            boolean z = lVar.aG() == 1;
            l.a T = lVar.T();
            if (z && T != null) {
                String jSONObject = lVar.aL().toString();
                Intent intent = new Intent(context, TTMiddlePageActivity.class);
                intent.putExtra("middle_page_material_meta", jSONObject);
                com.bytedance.sdk.openadsdk.utils.b.a(context, intent, null);
                return true;
            }
        }
        return false;
    }

    public static boolean a(l lVar) {
        if (lVar == null) {
            return false;
        }
        return (lVar.aG() == 2) && lVar.T() != null;
    }

    public static boolean b(Context context, l lVar) {
        if (context != null && a(lVar)) {
            String jSONObject = lVar.aL().toString();
            Intent intent = new Intent(context, TTMiddlePageActivity.class);
            intent.putExtra("middle_page_material_meta", jSONObject);
            com.bytedance.sdk.openadsdk.utils.b.a(context, intent, null);
            return true;
        }
        return false;
    }
}
