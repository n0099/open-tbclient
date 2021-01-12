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
import com.bytedance.sdk.openadsdk.DownloadStatusController;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.dislike.b;
import com.bytedance.sdk.openadsdk.h.a.d;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class a implements TTNativeAd {

    /* renamed from: a  reason: collision with root package name */
    private int f6531a;
    protected final o g;
    protected final l h;
    protected final Context i;
    protected TTAdDislike j;
    protected DownloadStatusController k;
    protected int l;

    public a(@NonNull Context context, @NonNull l lVar, int i) {
        z.a(lVar, "materialMeta不能为null");
        this.h = lVar;
        this.i = context;
        this.l = i;
        this.g = new o(this.i, this, lVar, a(i));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        z.a(viewGroup, "container不能为null");
        z.a(view, "clickView不能为null");
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(view);
        registerViewForInteraction(viewGroup, arrayList, null, adInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, TTNativeAd.AdInteractionListener adInteractionListener) {
        z.a(viewGroup, "container不能为null");
        z.a(list, "clickView不能为null");
        z.a(list.size() > 0, "clickViews数量必须大于等于1");
        registerViewForInteraction(viewGroup, list, list2, null, adInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @Nullable View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        z.a(viewGroup, "container不能为null");
        z.a(list, "clickView不能为null");
        z.a(list.size() > 0, "clickViews数量必须大于等于1");
        registerViewForInteraction(viewGroup, null, list, list2, view, adInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @NonNull List<View> list2, @Nullable List<View> list3, @Nullable View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        boolean z = true;
        z.a(viewGroup, "container不能为null");
        z.a(list2, "clickView不能为null");
        z.a(list2.size() > 0, "clickViews数量必须大于等于1");
        if (list3 == null || list3.size() <= 0) {
            z = false;
        }
        a(z);
        this.g.a(viewGroup, list, list2, a() ? a(list2, list3) : list3, view, adInteractionListener);
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
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getVideoCoverImage() {
        if (this.h == null || this.h.F() == null) {
            return null;
        }
        return new TTImage(this.h.F().b(), this.h.F().c(), this.h.F().g());
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Bitmap getAdLogo() {
        return BitmapFactory.decodeResource(this.i.getResources(), ac.d(p.a(), "tt_ad_logo_small"));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getTitle() {
        if (this.h.U() != null && !TextUtils.isEmpty(this.h.U().c())) {
            return this.h.U().c();
        }
        if (!TextUtils.isEmpty(getSource())) {
            return getSource();
        }
        return this.h.Q();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getDescription() {
        return !TextUtils.isEmpty(this.h.Q()) ? this.h.Q() : this.h.R();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getButtonText() {
        return this.h.S();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppScore() {
        if (this.h.U() != null) {
            return this.h.U().e();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppCommentNum() {
        if (this.h.U() != null) {
            return this.h.U().f();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppSize() {
        if (this.h.U() != null) {
            return this.h.U().g();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getSource() {
        return this.h.G();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getIcon() {
        if (this.h.I() == null) {
            return null;
        }
        return k.a(this.h.I());
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public List<TTImage> getImageList() {
        ArrayList arrayList = new ArrayList();
        if (this.h.M() != null && !this.h.M().isEmpty()) {
            for (k kVar : this.h.M()) {
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
        return this.h.H();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getImageMode() {
        if (this.h == null) {
            return -1;
        }
        return this.h.X();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public List<FilterWord> getFilterWords() {
        if (this.h == null) {
            return null;
        }
        return this.h.Y();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(Activity activity) {
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
            return this.h.ae();
        }
        return null;
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
            case 6:
            case 7:
            case 8:
            default:
                return "embeded_ad";
            case 5:
                return "embeded_ad";
            case 9:
                return "draw_ad";
        }
    }

    private void a(boolean z) {
        d c = d.b().a(this.l).c(String.valueOf(aj.d(this.h.W())));
        if (z) {
            com.bytedance.sdk.openadsdk.h.a.a().i(c);
        } else {
            com.bytedance.sdk.openadsdk.h.a.a().j(c);
        }
    }

    private boolean a() {
        if (this.h == null || this.h.H() == 5) {
            return false;
        }
        if (this.f6531a == 0) {
            this.f6531a = aj.d(this.h.W());
        }
        return p.h().d(this.f6531a) == 1;
    }
}
