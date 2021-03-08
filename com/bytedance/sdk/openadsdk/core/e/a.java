package com.bytedance.sdk.openadsdk.core.e;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.DownloadStatusController;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.dislike.b;
import com.bytedance.sdk.openadsdk.g.a.c;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a implements TTNativeAd {

    /* renamed from: a  reason: collision with root package name */
    private int f4424a;
    private TTNativeExpressAd b;
    private ViewGroup c;
    private View d;
    private float e;
    private float f;
    protected final o g;
    protected final l h;
    protected final Context i;
    protected TTAdDislike j;
    protected DownloadStatusController k;
    protected int l;
    protected AdSlot m;
    private AtomicBoolean n = new AtomicBoolean(false);
    private AtomicBoolean o = new AtomicBoolean(false);
    private TTNativeAd.ExpressRenderListener p;
    private TTNativeAd.AdInteractionListener q;

    public a(@NonNull Context context, @NonNull l lVar, int i, AdSlot adSlot) {
        z.a(lVar, "materialMeta不能为null");
        this.h = lVar;
        this.i = context;
        this.l = i;
        this.m = adSlot;
        this.g = new o(this.i, this, lVar, a(i));
        this.b = a(this.h);
        b();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        boolean z = false;
        z.a(viewGroup != null || this.o.get(), "container不能为null");
        if (view != null || this.o.get()) {
            z = true;
        }
        z.a(z, "clickView不能为null");
        this.c = viewGroup;
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(view);
        registerViewForInteraction(viewGroup, arrayList, null, adInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, TTNativeAd.AdInteractionListener adInteractionListener) {
        z.a(viewGroup != null || this.o.get(), "container不能为null");
        z.a(list != null || this.o.get(), "clickView不能为null");
        z.a(list.size() > 0, "clickViews数量必须大于等于1");
        this.c = viewGroup;
        registerViewForInteraction(viewGroup, list, list2, null, adInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @Nullable View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        z.a(viewGroup != null || this.o.get(), "container不能为null");
        z.a(list != null || this.o.get(), "clickView不能为null");
        z.a(list.size() > 0, "clickViews数量必须大于等于1");
        this.c = viewGroup;
        registerViewForInteraction(viewGroup, null, list, list2, view, adInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @NonNull List<View> list2, @Nullable List<View> list3, @Nullable View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        boolean z = false;
        z.a(viewGroup != null || this.o.get(), "container不能为null");
        z.a(list2 != null || this.o.get(), "clickView不能为null");
        z.a(list2.size() > 0, "clickViews数量必须大于等于1");
        this.c = viewGroup;
        this.q = adInteractionListener;
        if (list3 != null && list3.size() > 0) {
            z = true;
        }
        a(z);
        List<View> a2 = a() ? a(list2, list3) : list3;
        if (this.o.get() && (this.l == 5 || this.l == 1)) {
            c();
        }
        if (!this.o.get()) {
            this.g.a(viewGroup, list, list2, a2, view, adInteractionListener);
        }
    }

    private List<View> a(List<View> list, List<View> list2) {
        LinkedList linkedList = new LinkedList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                linkedList.add(list.get(i));
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                linkedList.add(list2.get(i2));
            }
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        z.a(tTAppDownloadListener, "downloadListener不能为null");
        this.g.a(tTAppDownloadListener);
        if (this.b != null) {
            this.b.setDownloadListener(tTAppDownloadListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getVideoCoverImage() {
        if (this.h == null || this.h.R() == null) {
            return null;
        }
        return new TTImage(this.h.R().b(), this.h.R().c(), this.h.R().h(), 0.0d);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Bitmap getAdLogo() {
        return BitmapFactory.decodeResource(this.i.getResources(), ac.d(p.a(), "tt_ad_logo_small_rectangle"));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getTitle() {
        if (this.h.ah() != null && !TextUtils.isEmpty(this.h.ah().c())) {
            return this.h.ah().c();
        }
        if (!TextUtils.isEmpty(getSource())) {
            return getSource();
        }
        return this.h.ad();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getDescription() {
        return !TextUtils.isEmpty(this.h.ad()) ? this.h.ad() : this.h.ae();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getButtonText() {
        return this.h.af();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppScore() {
        if (this.h.ah() != null) {
            return this.h.ah().e();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppCommentNum() {
        if (this.h.ah() != null) {
            return this.h.ah().f();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppSize() {
        if (this.h.ah() != null) {
            return this.h.ah().g();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getSource() {
        return this.h.S();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getIcon() {
        if (this.h.U() == null) {
            return null;
        }
        return k.a(this.h.U());
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public List<TTImage> getImageList() {
        ArrayList arrayList = new ArrayList();
        if (this.h.Z() != null && !this.h.Z().isEmpty()) {
            for (k kVar : this.h.Z()) {
                arrayList.add(k.a(kVar));
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getInteractionType() {
        if (this.h == null) {
            return -1;
        }
        return this.h.T();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getImageMode() {
        if (this.h == null) {
            return -1;
        }
        return this.h.ak();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public List<FilterWord> getFilterWords() {
        if (this.h == null) {
            return null;
        }
        return this.h.al();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        if (this.b != null && this.o.get()) {
            return this.b.getDislikeDialog(activity);
        }
        if (this.j == null) {
            a(activity);
        }
        return this.j;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(final TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract == null) {
            throw new IllegalArgumentException("dialog is null, please check");
        }
        tTDislikeDialogAbstract.setMaterialMeta(this.h);
        return new TTAdDislike() { // from class: com.bytedance.sdk.openadsdk.core.e.a.1
            @Override // com.bytedance.sdk.openadsdk.TTAdDislike
            public void sendDislikeSource(String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike
            public void showDislikeDialog() {
                if ((tTDislikeDialogAbstract.getContext() instanceof Activity) && !((Activity) tTDislikeDialogAbstract.getContext()).isFinishing()) {
                    tTDislikeDialogAbstract.show();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike
            public void showDislikeDialog(int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike
            public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike
            public void setIsInteractionAd() {
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public DownloadStatusController getDownloadStatusController() {
        final com.bytedance.sdk.openadsdk.downloadnew.core.a a2;
        if (this.b != null && this.n.get()) {
            return null;
        }
        if (this.k == null && this.g != null && (a2 = this.g.a()) != null) {
            this.k = new DownloadStatusController() { // from class: com.bytedance.sdk.openadsdk.core.e.a.2
                @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
                public void changeDownloadStatus() {
                    a2.e();
                }

                @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
                public void cancelDownload() {
                    a2.f();
                }
            };
        }
        return this.k;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setActivityForDownloadApp(@NonNull Activity activity) {
        if (activity != null) {
            this.g.a(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Map<String, Object> getMediaExtraInfo() {
        if (this.h != null) {
            return this.h.ar();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void render() {
        b();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void destroy() {
        if (this.b != null) {
            this.b.destroy();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setExpressRenderListener(TTNativeAd.ExpressRenderListener expressRenderListener) {
        this.p = expressRenderListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback != null && activity != null && this.b != null) {
            this.b.setDislikeCallback(activity, dislikeInteractionCallback);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (this.b != null) {
            this.b.setDislikeDialog(tTDislikeDialogAbstract);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void showInteractionExpressAd(Activity activity) {
        if (this.b != null) {
            this.b.showInteractionExpressAd(activity);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.content.Context] */
    private void a(Activity activity) {
        Activity activity2 = activity;
        if (this.i instanceof Activity) {
            activity2 = activity;
            if (!((Activity) this.i).isFinishing()) {
                activity2 = this.i;
            }
        }
        this.j = new b(activity2, this.h);
    }

    private String a(int i) {
        switch (i) {
            case 1:
                return "banner_ad";
            case 2:
                return "interaction";
            case 3:
            case 4:
            case 7:
            case 8:
            default:
                return "embeded_ad";
            case 5:
                return "embeded_ad";
            case 6:
                return "stream";
            case 9:
                return "draw_ad";
        }
    }

    private void a(boolean z) {
        c c = c.b().a(this.l).c(String.valueOf(aj.d(this.h.aj())));
        if (z) {
            com.bytedance.sdk.openadsdk.g.a.a().i(c);
        } else {
            com.bytedance.sdk.openadsdk.g.a.a().j(c);
        }
    }

    private boolean a() {
        if (this.h == null || this.h.T() == 5) {
            return false;
        }
        if (this.f4424a == 0) {
            this.f4424a = aj.d(this.h.aj());
        }
        return p.h().d(this.f4424a) == 1;
    }

    private TTNativeExpressAd a(l lVar) {
        if (this.h == null || this.h.d() != 2) {
            return null;
        }
        switch (this.l) {
            case 1:
                if (lVar.R() != null) {
                    return new com.bytedance.sdk.openadsdk.core.bannerexpress.c(this.i, lVar, this.m);
                }
                return new com.bytedance.sdk.openadsdk.core.bannerexpress.b(this.i, lVar, this.m);
            case 2:
                if (lVar.R() != null) {
                    return new com.bytedance.sdk.openadsdk.core.c.c(this.i, lVar, this.m);
                }
                return new com.bytedance.sdk.openadsdk.core.c.b(this.i, lVar, this.m);
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
            default:
                return null;
            case 5:
                if (lVar.R() != null) {
                    return new com.bytedance.sdk.openadsdk.core.nativeexpress.o(this.i, lVar, this.m);
                }
                return new com.bytedance.sdk.openadsdk.core.nativeexpress.k(this.i, lVar, this.m);
            case 9:
                return new m(this.i, lVar, this.m);
        }
    }

    private void b() {
        if (this.b == null) {
            if (this.p != null) {
                this.p.onRenderSuccess(this.c, this.m.getExpressViewAcceptedWidth(), this.m.getExpressViewAcceptedHeight(), false);
            }
        } else if (this.n.get() && this.p != null) {
            this.p.onRenderSuccess(this.d, this.e, this.f, this.o.get());
        } else {
            this.b.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.core.e.a.3
                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdClicked(View view, int i) {
                    if (a.this.q != null) {
                        a.this.q.onAdClicked(view, a.this);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdShow(View view, int i) {
                    if (a.this.q != null) {
                        a.this.q.onAdShow(a.this);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderFail(View view, String str, int i) {
                    a.this.n.set(true);
                    a.this.d = a.this.c;
                    a.this.e = a.this.m.getExpressViewAcceptedWidth();
                    a.this.f = a.this.m.getExpressViewAcceptedHeight();
                    if (a.this.p != null) {
                        a.this.p.onRenderSuccess(a.this.c, a.this.m.getExpressViewAcceptedWidth(), a.this.m.getExpressViewAcceptedHeight(), false);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderSuccess(View view, float f, float f2) {
                    a.this.n.set(true);
                    a.this.o.set(true);
                    a.this.d = view;
                    a.this.e = f;
                    a.this.f = f2;
                    if (a.this.p != null) {
                        a.this.p.onRenderSuccess(view, f, f2, true);
                    }
                }
            });
            this.b.render();
        }
    }

    private void c() {
        if (this.c != null && this.b != null && this.d != null) {
            this.c.removeAllViews();
            if (this.d.getParent() != null) {
                ((ViewGroup) this.d.getParent()).removeAllViews();
            }
            this.c.addView(this.d);
        }
    }
}
