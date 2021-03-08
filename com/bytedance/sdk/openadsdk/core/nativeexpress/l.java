package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.d.a;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class l implements TTNativeExpressAd {
    public AtomicBoolean m = new AtomicBoolean(false);
    protected a n;

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public List<FilterWord> getFilterWords() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void showInteractionExpressAd(Activity activity) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setSlideIntervalTime(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setCanInterruptVideoPlay(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public com.bytedance.sdk.openadsdk.multipro.b.a getVideoModel() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public Map<String, Object> getMediaExtraInfo() {
        return null;
    }

    /* loaded from: classes6.dex */
    protected static class a implements TTAppDownloadListener {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<TTAppDownloadListener> f4498a;
        private String b;

        public a(TTAppDownloadListener tTAppDownloadListener, String str) {
            this.b = "";
            this.f4498a = new WeakReference<>(tTAppDownloadListener);
            this.b = str;
        }

        public void a(TTAppDownloadListener tTAppDownloadListener) {
            this.f4498a = new WeakReference<>(tTAppDownloadListener);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
            if (this.f4498a != null && this.f4498a.get() != null) {
                this.f4498a.get().onIdle();
            }
            a.C1028a.a(this.b, 1, 0);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long j, long j2, String str, String str2) {
            if (this.f4498a != null && this.f4498a.get() != null) {
                this.f4498a.get().onDownloadActive(j, j2, str, str2);
            }
            if (j > 0) {
                a.C1028a.a(this.b, 3, (int) ((100 * j2) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long j, long j2, String str, String str2) {
            if (this.f4498a != null && this.f4498a.get() != null) {
                this.f4498a.get().onDownloadPaused(j, j2, str, str2);
            }
            if (j > 0) {
                a.C1028a.a(this.b, 2, (int) ((100 * j2) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long j, long j2, String str, String str2) {
            if (this.f4498a != null && this.f4498a.get() != null) {
                this.f4498a.get().onDownloadFailed(j, j2, str, str2);
            }
            if (j > 0) {
                a.C1028a.a(this.b, 4, (int) ((100 * j2) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long j, String str, String str2) {
            if (this.f4498a != null && this.f4498a.get() != null) {
                this.f4498a.get().onDownloadFinished(j, str, str2);
            }
            a.C1028a.a(this.b, 5, 100);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String str, String str2) {
            if (this.f4498a != null && this.f4498a.get() != null) {
                this.f4498a.get().onInstalled(str, str2);
            }
            a.C1028a.a(this.b, 6, 100);
        }
    }
}
