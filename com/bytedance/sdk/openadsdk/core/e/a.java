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
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;
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
import com.bytedance.sdk.openadsdk.h.a.c;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a implements TTNativeAd {

    /* renamed from: a  reason: collision with root package name */
    public int f28117a;

    /* renamed from: b  reason: collision with root package name */
    public TTNativeExpressAd f28118b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f28119c;

    /* renamed from: d  reason: collision with root package name */
    public View f28120d;

    /* renamed from: e  reason: collision with root package name */
    public float f28121e;

    /* renamed from: f  reason: collision with root package name */
    public float f28122f;

    /* renamed from: g  reason: collision with root package name */
    public final o f28123g;

    /* renamed from: h  reason: collision with root package name */
    public final l f28124h;

    /* renamed from: i  reason: collision with root package name */
    public final Context f28125i;
    public TTAdDislike j;
    public DownloadStatusController k;
    public int l;
    public AdSlot m;
    public AtomicBoolean n = new AtomicBoolean(false);
    public AtomicBoolean o = new AtomicBoolean(false);
    public TTNativeAd.ExpressRenderListener p;
    public TTNativeAd.AdInteractionListener q;

    public a(@NonNull Context context, @NonNull l lVar, int i2, AdSlot adSlot) {
        z.a(lVar, "materialMeta不能为null");
        this.f28124h = lVar;
        this.f28125i = context;
        this.l = i2;
        this.m = adSlot;
        this.f28123g = new o(context, this, lVar, a(i2));
        this.f28118b = a(this.f28124h);
        b();
    }

    private String a(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 5 ? i2 != 6 ? i2 != 9 ? "embeded_ad" : "draw_ad" : "stream" : "embeded_ad" : "interaction" : "banner_ad";
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void destroy() {
        TTNativeExpressAd tTNativeExpressAd = this.f28118b;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Bitmap getAdLogo() {
        return BitmapFactory.decodeResource(this.f28125i.getResources(), ad.d(p.a(), "tt_ad_logo_small_rectangle"));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppCommentNum() {
        if (this.f28124h.an() != null) {
            return this.f28124h.an().f();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppScore() {
        if (this.f28124h.an() != null) {
            return this.f28124h.an().e();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppSize() {
        if (this.f28124h.an() != null) {
            return this.f28124h.an().g();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getButtonText() {
        return this.f28124h.al();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getDescription() {
        if (!TextUtils.isEmpty(this.f28124h.aj())) {
            return this.f28124h.aj();
        }
        return this.f28124h.ak();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        if (this.f28118b != null && this.o.get()) {
            return this.f28118b.getDislikeDialog(activity);
        }
        if (this.j == null) {
            a(activity);
        }
        return this.j;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public DownloadStatusController getDownloadStatusController() {
        o oVar;
        final com.bytedance.sdk.openadsdk.downloadnew.core.a a2;
        if (this.f28118b == null || !this.n.get()) {
            if (this.k == null && (oVar = this.f28123g) != null && (a2 = oVar.a()) != null) {
                this.k = new DownloadStatusController() { // from class: com.bytedance.sdk.openadsdk.core.e.a.2
                    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
                    public void cancelDownload() {
                        a2.f();
                    }

                    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
                    public void changeDownloadStatus() {
                        a2.e();
                    }
                };
            }
            return this.k;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public List<FilterWord> getFilterWords() {
        l lVar = this.f28124h;
        if (lVar == null) {
            return null;
        }
        return lVar.ar();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getIcon() {
        if (this.f28124h.aa() == null) {
            return null;
        }
        return k.a(this.f28124h.aa());
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public List<TTImage> getImageList() {
        ArrayList arrayList = new ArrayList();
        if (this.f28124h.af() != null && !this.f28124h.af().isEmpty()) {
            for (k kVar : this.f28124h.af()) {
                arrayList.add(k.a(kVar));
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getImageMode() {
        l lVar = this.f28124h;
        if (lVar == null) {
            return -1;
        }
        return lVar.aq();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getInteractionType() {
        l lVar = this.f28124h;
        if (lVar == null) {
            return -1;
        }
        return lVar.Z();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Map<String, Object> getMediaExtraInfo() {
        l lVar = this.f28124h;
        if (lVar != null) {
            return lVar.ay();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public PersonalizationPrompt getPersonalizationPrompt() {
        l lVar = this.f28124h;
        if (lVar == null) {
            return null;
        }
        return lVar.as();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getSource() {
        return this.f28124h.Y();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getTitle() {
        if (this.f28124h.an() != null && !TextUtils.isEmpty(this.f28124h.an().c())) {
            return this.f28124h.an().c();
        }
        if (!TextUtils.isEmpty(getSource())) {
            return getSource();
        }
        return this.f28124h.aj();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getVideoCoverImage() {
        l lVar = this.f28124h;
        if (lVar == null || lVar.X() == null) {
            return null;
        }
        return new TTImage(this.f28124h.X().b(), this.f28124h.X().c(), this.f28124h.X().h(), 0.0d);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        boolean z = false;
        z.a(viewGroup != null || this.o.get(), "container不能为null");
        z.a((view != null || this.o.get()) ? true : true, "clickView不能为null");
        this.f28119c = viewGroup;
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(view);
        registerViewForInteraction(viewGroup, arrayList, null, adInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void render() {
        b();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setActivityForDownloadApp(@NonNull Activity activity) {
        if (activity != null) {
            this.f28123g.a(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        TTNativeExpressAd tTNativeExpressAd;
        if (dislikeInteractionCallback == null || activity == null || (tTNativeExpressAd = this.f28118b) == null) {
            return;
        }
        tTNativeExpressAd.setDislikeCallback(activity, dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        TTNativeExpressAd tTNativeExpressAd = this.f28118b;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setDislikeDialog(tTDislikeDialogAbstract);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        z.a(tTAppDownloadListener, "downloadListener不能为null");
        this.f28123g.a(tTAppDownloadListener);
        TTNativeExpressAd tTNativeExpressAd = this.f28118b;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setDownloadListener(tTAppDownloadListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setExpressRenderListener(TTNativeAd.ExpressRenderListener expressRenderListener) {
        this.p = expressRenderListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void showInteractionExpressAd(Activity activity) {
        TTNativeExpressAd tTNativeExpressAd = this.f28118b;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.showInteractionExpressAd(activity);
        }
    }

    private void c() {
        ViewGroup viewGroup = this.f28119c;
        if (viewGroup == null || this.f28118b == null || this.f28120d == null) {
            return;
        }
        viewGroup.removeAllViews();
        if (this.f28120d.getParent() != null) {
            ((ViewGroup) this.f28120d.getParent()).removeAllViews();
        }
        this.f28119c.addView(this.f28120d);
    }

    private void b() {
        TTNativeAd.ExpressRenderListener expressRenderListener;
        if (this.f28118b == null) {
            TTNativeAd.ExpressRenderListener expressRenderListener2 = this.p;
            if (expressRenderListener2 != null) {
                expressRenderListener2.onRenderSuccess(this.f28119c, this.m.getExpressViewAcceptedWidth(), this.m.getExpressViewAcceptedHeight(), false);
            }
        } else if (this.n.get() && (expressRenderListener = this.p) != null) {
            expressRenderListener.onRenderSuccess(this.f28120d, this.f28121e, this.f28122f, this.o.get());
        } else {
            this.f28118b.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.core.e.a.3
                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdClicked(View view, int i2) {
                    if (a.this.q != null) {
                        a.this.q.onAdClicked(view, a.this);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdShow(View view, int i2) {
                    if (a.this.q != null) {
                        a.this.q.onAdShow(a.this);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderFail(View view, String str, int i2) {
                    a.this.n.set(true);
                    a aVar = a.this;
                    aVar.f28120d = aVar.f28119c;
                    a aVar2 = a.this;
                    aVar2.f28121e = aVar2.m.getExpressViewAcceptedWidth();
                    a aVar3 = a.this;
                    aVar3.f28122f = aVar3.m.getExpressViewAcceptedHeight();
                    if (a.this.p != null) {
                        a.this.p.onRenderSuccess(a.this.f28119c, a.this.m.getExpressViewAcceptedWidth(), a.this.m.getExpressViewAcceptedHeight(), false);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderSuccess(View view, float f2, float f3) {
                    a.this.n.set(true);
                    a.this.o.set(true);
                    a.this.f28120d = view;
                    a.this.f28121e = f2;
                    a.this.f28122f = f3;
                    if (a.this.p != null) {
                        a.this.p.onRenderSuccess(view, f2, f3, true);
                    }
                }
            });
            this.f28118b.render();
        }
    }

    private List<View> a(List<View> list, List<View> list2) {
        LinkedList linkedList = new LinkedList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                linkedList.add(list.get(i2));
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            int size2 = list2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                linkedList.add(list2.get(i3));
            }
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(final TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.setMaterialMeta(this.f28124h);
            return new TTAdDislike() { // from class: com.bytedance.sdk.openadsdk.core.e.a.1
                @Override // com.bytedance.sdk.openadsdk.TTAdDislike
                public void sendDislikeSource(String str) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike
                public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike
                public void setIsInteractionAd() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike
                public void showDislikeDialog() {
                    if ((tTDislikeDialogAbstract.getContext() instanceof Activity) && !((Activity) tTDislikeDialogAbstract.getContext()).isFinishing()) {
                        tTDislikeDialogAbstract.show();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike
                public void showDislikeDialog(int i2) {
                }
            };
        }
        throw new IllegalArgumentException("dialog is null, please check");
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, TTNativeAd.AdInteractionListener adInteractionListener) {
        z.a(viewGroup != null || this.o.get(), "container不能为null");
        z.a(list != null || this.o.get(), "clickView不能为null");
        z.a(list.size() > 0, "clickViews数量必须大于等于1");
        this.f28119c = viewGroup;
        registerViewForInteraction(viewGroup, list, list2, null, adInteractionListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context] */
    private void a(Activity activity) {
        Context context = this.f28125i;
        Activity activity2 = activity;
        if (context instanceof Activity) {
            activity2 = activity;
            if (!((Activity) context).isFinishing()) {
                activity2 = this.f28125i;
            }
        }
        this.j = new b(activity2, this.f28124h, a(this.l));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @Nullable View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        z.a(viewGroup != null || this.o.get(), "container不能为null");
        z.a(list != null || this.o.get(), "clickView不能为null");
        z.a(list.size() > 0, "clickViews数量必须大于等于1");
        this.f28119c = viewGroup;
        registerViewForInteraction(viewGroup, null, list, list2, view, adInteractionListener);
    }

    private void a(boolean z) {
        c c2 = c.b().a(this.l).c(String.valueOf(ak.d(this.f28124h.ap())));
        if (z) {
            com.bytedance.sdk.openadsdk.h.a.a().i(c2);
        } else {
            com.bytedance.sdk.openadsdk.h.a.a().j(c2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @NonNull List<View> list2, @Nullable List<View> list3, @Nullable View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        int i2;
        boolean z = false;
        z.a(viewGroup != null || this.o.get(), "container不能为null");
        z.a(list2 != null || this.o.get(), "clickView不能为null");
        z.a(list2.size() > 0, "clickViews数量必须大于等于1");
        this.f28119c = viewGroup;
        this.q = adInteractionListener;
        if (list3 != null && list3.size() > 0) {
            z = true;
        }
        a(z);
        if (a()) {
            list3 = a(list2, list3);
        }
        List<View> list4 = list3;
        if (this.o.get() && ((i2 = this.l) == 5 || i2 == 1)) {
            c();
        }
        if (this.o.get()) {
            return;
        }
        this.f28123g.a(viewGroup, list, list2, list4, view, adInteractionListener);
    }

    private boolean a() {
        l lVar = this.f28124h;
        if (lVar == null || lVar.Z() == 5) {
            return false;
        }
        if (this.f28117a == 0) {
            this.f28117a = ak.d(this.f28124h.ap());
        }
        return p.h().d(this.f28117a) == 1;
    }

    private TTNativeExpressAd a(l lVar) {
        l lVar2 = this.f28124h;
        if (lVar2 == null || lVar2.d() != 2) {
            return null;
        }
        int i2 = this.l;
        if (i2 == 1) {
            if (lVar.X() != null) {
                return new com.bytedance.sdk.openadsdk.core.bannerexpress.c(this.f28125i, lVar, this.m);
            }
            return new com.bytedance.sdk.openadsdk.core.bannerexpress.b(this.f28125i, lVar, this.m);
        } else if (i2 == 2) {
            if (lVar.X() != null) {
                return new com.bytedance.sdk.openadsdk.core.c.c(this.f28125i, lVar, this.m);
            }
            return new com.bytedance.sdk.openadsdk.core.c.b(this.f28125i, lVar, this.m);
        } else if (i2 != 5) {
            if (i2 != 9) {
                return null;
            }
            return new m(this.f28125i, lVar, this.m);
        } else if (lVar.X() != null) {
            return new com.bytedance.sdk.openadsdk.core.nativeexpress.o(this.f28125i, lVar, this.m);
        } else {
            return new com.bytedance.sdk.openadsdk.core.nativeexpress.k(this.f28125i, lVar, this.m);
        }
    }
}
