package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.AdAppInfoView;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.recapp.view.AdThreadUserInfoLayout;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.tencent.open.SocialConstants;
import d.b.h0.r.s.a;
import d.b.i0.d3.v;
import d.b.i0.o.d.f.b;
import d.b.i0.s2.w;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.AdCloseInfo;
import tbclient.App;
/* loaded from: classes4.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> {
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public int G;
    public TextView H;
    public TextView I;
    public TextView J;
    public AdCloseView K;
    public LinearLayout L;
    public ApkDownloadView M;
    public TextView N;
    public RelativeLayout O;
    public View P;
    public String Q;
    public d.b.i0.j1.o.h.a R;
    public AdCard S;
    public final int T;
    public AdThreadCommentAndPraiseInfoLayout U;
    public AdThreadUserInfoLayout V;
    public View W;
    public View a0;
    public AdCard.b b0;
    public PermissionJudgePolicy c0;
    public DownloadCacheKey d0;
    public d.b.i0.o.d.g.d e0;
    public FrameLayout f0;
    public View g0;
    public View h0;
    public AdAppInfoView i0;
    public CustomMessageListener j0;
    public CustomMessageListener k0;
    public CustomMessageListener l0;
    public View r;
    public ViewStub s;
    public View t;
    public View u;
    public final int v;
    public final int w;
    public final int x;
    public final int y;
    public final int z;

    /* loaded from: classes4.dex */
    public class a implements AdThreadUserInfoLayout.AfterAdjustChildWidthListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdCard f20426a;

        public a(AdCard adCard) {
            this.f20426a = adCard;
        }

        @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
        public void afterChildWidth() {
            ((TextView) AdCardBaseView.this.V.getUserName()).setText(this.f20426a.userName);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnLongClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f20428e;

        public b(AdvertAppInfo advertAppInfo) {
            this.f20428e = advertAppInfo;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            AdvertAppInfo advertAppInfo;
            d.b.h0.s.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense == null || !adAdSense.f() || (advertAppInfo = this.f20428e) == null) {
                return false;
            }
            d.b.c.e.p.a.a(advertAppInfo.z4());
            ((Vibrator) AdCardBaseView.this.m.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdCard f20430e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f20431f;

        /* loaded from: classes4.dex */
        public class a implements a.e {
            public a() {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                String str;
                String str2;
                if (AdCardBaseView.this.S == null || AdCardBaseView.this.S.getAdvertAppInfo() == null) {
                    str = null;
                    str2 = null;
                } else {
                    AdCardBaseView adCardBaseView = AdCardBaseView.this;
                    str = adCardBaseView.p(adCardBaseView.S.getAdvertAppInfo());
                    str2 = AdCardBaseView.this.S.getAdvertAppInfo().T3;
                }
                int e2 = w.e(AdCardBaseView.this.m, c.this.f20431f, str, str2);
                if (w.p(e2) && AdCardBaseView.this.o != null) {
                    AdCardBaseView.this.o.a(e2, null);
                }
                aVar.dismiss();
            }
        }

        /* loaded from: classes4.dex */
        public class b implements a.e {
            public b(c cVar) {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        public c(AdCard adCard, String str) {
            this.f20430e = adCard;
            this.f20431f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            if (AdCardBaseView.this.o != null && this.f20430e.buttonClick != null && !w.o(this.f20431f)) {
                d.b.i0.j1.o.a aVar = AdCardBaseView.this.o;
                AdCard.b bVar = this.f20430e.buttonClick;
                aVar.b(bVar.f20392b, bVar.f20393c, null);
            }
            if (AdCardBaseView.this.u0(this.f20430e.buttonClick)) {
                return;
            }
            if (TextUtils.isEmpty(this.f20430e.popWindowText)) {
                if (AdCardBaseView.this.S == null || AdCardBaseView.this.S.getAdvertAppInfo() == null) {
                    str = null;
                    str2 = null;
                } else {
                    AdCardBaseView adCardBaseView = AdCardBaseView.this;
                    str = adCardBaseView.p(adCardBaseView.S.getAdvertAppInfo());
                    str2 = AdCardBaseView.this.S.getAdvertAppInfo().T3;
                }
                int e2 = w.e(AdCardBaseView.this.m, this.f20431f, str, str2);
                if (!w.p(e2) || AdCardBaseView.this.o == null) {
                    return;
                }
                AdCardBaseView.this.o.a(e2, null);
                return;
            }
            d.b.h0.r.s.a aVar2 = new d.b.h0.r.s.a(AdCardBaseView.this.m.getPageActivity());
            aVar2.setMessage(this.f20430e.popWindowText);
            aVar2.setPositiveButton(R.string.alert_yes_button, new a());
            aVar2.setNegativeButton(R.string.cancel, new b(this));
            aVar2.create(AdCardBaseView.this.m).show();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdCardBaseView.this.K.performClick();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements b.a {
        public e() {
        }

        @Override // d.b.i0.o.d.f.b.a
        public boolean b(View view) {
            AdCardBaseView.this.s0();
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbImageView f20436e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdCard.b f20437f;

        public f(TbImageView tbImageView, AdCard.b bVar) {
            this.f20436e = tbImageView;
            this.f20437f = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AdCardBaseView.this.S.hasAnimation()) {
                AdCardBaseView.this.v0(this.f20436e);
            }
            AdCardBaseView.this.w0(this.f20437f);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdCard.b f20439e;

        public g(AdCard.b bVar) {
            this.f20439e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdCardBaseView.this.w0(this.f20439e);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f20441e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f20442f;

        public h(AdvertAppInfo advertAppInfo, int i) {
            this.f20441e = advertAppInfo;
            this.f20442f = i;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            AdCardBaseView adCardBaseView = AdCardBaseView.this;
            adCardBaseView.z0(this.f20441e, this.f20442f, adCardBaseView.M);
            AdCardBaseView adCardBaseView2 = AdCardBaseView.this;
            ApkDownloadView apkDownloadView = adCardBaseView2.M;
            if (apkDownloadView != null) {
                apkDownloadView.v(adCardBaseView2.a1(this.f20441e, this.f20442f));
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a.e {
        public i() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public static class j extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<AdCardBaseView> f20445a;

        public j(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.f20445a = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.f20445a.get();
            if (adCardBaseView == null || customResponsedMessage == null || (downloadData = (DownloadData) customResponsedMessage.getData()) == null || TextUtils.isEmpty(adCardBaseView.Q) || !adCardBaseView.Q.equals(downloadData.getId())) {
                return;
            }
            int p = d.b.i0.s2.a0.e.p(downloadData);
            if (p == 7) {
                adCardBaseView.I.setText(R.string.pause_load);
            } else if (p == 1 || p == 2) {
                adCardBaseView.I.setText(R.string.pb_download_pause);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public AdCard f20446e;

        public k(AdCard adCard) {
            this.f20446e = adCard;
        }

        public final void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (!this.f20446e.directDownload && !z) {
                d(advertAppInfo);
            } else {
                b(advertAppInfo, z);
            }
        }

        public final void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = advertAppInfo.position;
            int m = ApkDownloadView.m(AdCardBaseView.this.a1(advertAppInfo, i));
            if ((6 == m || 7 == m) && d.b.c.e.p.j.z() && !d.b.c.e.p.j.H()) {
                AdCardBaseView.this.Z0(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView adCardBaseView = AdCardBaseView.this;
            adCardBaseView.C0(advertAppInfo, i, adCardBaseView.M, z);
            AdCardBaseView.this.s0();
        }

        public final void c(AdvertAppInfo advertAppInfo) {
            String str;
            String scheme = this.f20446e.getScheme();
            if (d.b.c.e.p.k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.H3;
            }
            this.f20446e.hasAnimation();
            String str2 = "";
            if (advertAppInfo != null) {
                str2 = AdCardBaseView.this.p(advertAppInfo);
                str = advertAppInfo.T3;
            } else {
                str = "";
            }
            int e2 = w.e(AdCardBaseView.this.m, scheme, str2, str);
            if (AdCardBaseView.this.o != null) {
                AdCardBaseView.this.o.a(e2, null);
            }
        }

        public final void d(AdvertAppInfo advertAppInfo) {
            String str;
            String scheme = this.f20446e.getScheme();
            if (d.b.c.e.p.k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.H3;
            }
            String str2 = "";
            if (advertAppInfo != null) {
                str2 = AdCardBaseView.this.p(advertAppInfo);
                str = advertAppInfo.T3;
            } else {
                str = "";
            }
            int e2 = w.B(advertAppInfo, scheme) ? 3 : w.e(AdCardBaseView.this.m, scheme, str2, str);
            if (AdCardBaseView.this.o != null) {
                AdCardBaseView.this.o.a(e2, null);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!d.b.c.e.p.j.A()) {
                AdCardBaseView.this.m.showToast(R.string.neterror);
            } else if (this.f20446e == null || view == null || view.getId() == R.id.thread_info_commont_container) {
            } else {
                AdvertAppInfo advertAppInfo = this.f20446e.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.M;
                if (advertAppInfo != null && advertAppInfo.B4()) {
                    a(advertAppInfo, z);
                } else {
                    c(advertAppInfo);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class l extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<AdCardBaseView> f20448a;

        public l(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.f20448a = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            AdCardBaseView adCardBaseView = this.f20448a.get();
            if (adCardBaseView == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || !AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                return;
            }
            String str2 = null;
            if (adCardBaseView.S == null || adCardBaseView.S.getAdvertAppInfo() == null) {
                str = null;
            } else {
                str2 = TextUtils.isEmpty(adCardBaseView.S.getAdvertAppInfo().J3) ? adCardBaseView.S.getAdvertAppInfo().E3 : adCardBaseView.S.getAdvertAppInfo().J3;
                str = adCardBaseView.S.getAdvertAppInfo().T3;
            }
            w.e(adCardBaseView.m, adCardBaseView.b0.f20391a, str2, str);
        }
    }

    /* loaded from: classes4.dex */
    public static class m extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<AdCardBaseView> f20449a;

        public m(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.f20449a = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.f20449a.get();
            if (adCardBaseView == null || customResponsedMessage == null || (downloadData = (DownloadData) customResponsedMessage.getData()) == null || TextUtils.isEmpty(adCardBaseView.Q) || !adCardBaseView.Q.equals(downloadData.getId())) {
                return;
            }
            adCardBaseView.M.r(downloadData);
        }
    }

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.T = d.b.c.e.p.l.k(getContext());
        this.e0 = null;
        this.j0 = new j(2016484, this);
        this.k0 = new m(2016483, this);
        this.l0 = new l(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.v = (int) resources.getDimension(R.dimen.tbds92);
        resources.getDimension(R.dimen.tbds92);
        this.w = (int) resources.getDimension(R.dimen.M_W_X004);
        resources.getDimension(R.dimen.tbds90);
        resources.getDimension(R.dimen.tbds90);
        resources.getDimension(R.dimen.tbds22);
        this.x = (int) resources.getDimension(R.dimen.M_W_X005);
        this.A = (int) resources.getDimension(R.dimen.M_W_X004);
        this.B = 0;
        this.y = (int) resources.getDimension(R.dimen.M_W_X007);
        this.z = (int) resources.getDimension(R.dimen.M_H_X005);
        this.C = (int) resources.getDimension(R.dimen.tbds208);
        this.D = (int) resources.getDimension(R.dimen.tbds33);
        this.E = (int) resources.getDimension(R.dimen.tbds72);
        this.F = (int) resources.getDimension(R.dimen.tbds48);
    }

    public abstract void A0(AdCard adCard);

    public float B0(@StringRes int i2) {
        try {
            return Float.parseFloat(TbadkCoreApplication.getInst().getContext().getResources().getString(i2).split(",")[0]);
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public void C0(AdvertAppInfo advertAppInfo, int i2, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo == null) {
            return;
        }
        DownloadData a1 = a1(advertAppInfo, i2);
        int m2 = ApkDownloadView.m(a1);
        if (m2 != 1) {
            if (m2 == 3) {
                d.b.i0.s2.a0.h.d(this.m.getPageActivity(), advertAppInfo.J3);
                return;
            } else if (m2 != 5) {
                if (m2 == 6 || m2 == 7) {
                    z0(advertAppInfo, i2, this.M);
                    apkDownloadView.s(a1);
                    return;
                } else if (m2 != 8) {
                    return;
                } else {
                    d.b.i0.o.d.d.c().o(this.m.getPageActivity(), advertAppInfo.J3);
                    return;
                }
            }
        }
        if (z) {
            d.b.i0.s2.a0.h.a(advertAppInfo);
            apkDownloadView.p(a1);
        }
    }

    public final void D0(AdvertAppInfo advertAppInfo) {
        AdvertAppInfo.a aVar;
        AdCloseInfo adCloseInfo;
        if (advertAppInfo != null && (aVar = advertAppInfo.U3) != null && (adCloseInfo = aVar.r) != null && adCloseInfo.support_close.intValue() > 0) {
            this.K.setVisibility(0);
            this.K.setPage(getBusinessType());
            this.K.setData(advertAppInfo);
            d.b.c.e.p.l.c(this.m.getPageActivity(), this.L, 40, 40, 40, 120);
            this.L.setOnClickListener(new d());
            return;
        }
        this.K.setVisibility(8);
        this.J.setOnClickListener(null);
    }

    public final void E0(AdCard adCard) {
        int i2 = (this.G - this.C) - this.F;
        if (P0()) {
            i2 -= this.D + this.E;
        }
        String str = adCard.recommendReason;
        if (TextUtils.isEmpty(str)) {
            str = adCard.userName;
        }
        TextView textView = this.N;
        textView.setText(d.b.i0.s2.c0.c.a.d(str, "广告", i2, textView.getPaint()));
    }

    public final void F0(AdCard adCard) {
        String str = adCard.threadTitle;
        if (TextUtils.isEmpty(str)) {
            this.H.setVisibility(8);
            return;
        }
        int i2 = adCard.titleLines;
        if (i2 <= 0) {
            i2 = 4;
        }
        this.H.setMaxLines(i2);
        this.H.setText(str);
        this.H.setVisibility(0);
    }

    public abstract void G0(View view);

    public final void H0(AdvertAppInfo advertAppInfo, AdCard adCard, k kVar) {
        c1(adCard);
        this.I.setVisibility(8);
        this.M.setVisibility(0);
        this.M.setClickable(true);
        this.Q = advertAppInfo.J3;
        DownloadData a1 = a1(advertAppInfo, advertAppInfo.position);
        if (w.q(this.Q)) {
            a1.setStatus(8);
        } else {
            V0(adCard, a1);
        }
        this.M.setData(a1);
        W0(adCard, kVar);
    }

    public final void I0(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey h2;
        if (adCard.directDownload) {
            return;
        }
        String scheme = adCard.getScheme();
        String p = p(advertAppInfo);
        if (!TextUtils.isEmpty(p)) {
            h2 = d.b.i0.o.d.d.c().g(p);
        } else {
            h2 = d.b.i0.o.d.d.c().h(scheme);
        }
        if (h2 == null) {
            h2 = DownloadCacheKey.create(p, advertAppInfo.I3, advertAppInfo.J3);
            d.b.i0.o.d.d.c().i(h2, null);
        }
        t0(h2);
    }

    public final void J0(AdCard adCard, k kVar) {
        this.M.setVisibility(8);
        this.i0.setVisibility(8);
        String str = adCard.buttonText;
        AdCard.b bVar = adCard.buttonClick;
        String str2 = bVar == null ? "" : bVar.f20391a;
        if (!d.b.c.e.p.k.isEmpty(str) && (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus)) {
            this.I.setVisibility(0);
            this.I.setClickable(true);
            this.I.setText(str);
            SkinManager.setViewTextColor(this.I, R.color.CAM_X0304, 1);
            SkinManager.setBackgroundResource(this.I, R.drawable.ad_download_progress_button_bg);
            if (d.b.c.e.p.k.isEmpty(str2)) {
                this.I.setClickable(false);
                return;
            } else {
                this.I.setOnClickListener(new c(adCard, str2));
                return;
            }
        }
        this.I.setVisibility(8);
        this.I.setClickable(false);
    }

    public final void K0(AdCard adCard, AdvertAppInfo advertAppInfo, k kVar) {
        if (adCard != null && advertAppInfo != null) {
            this.O.setVisibility(0);
            if (advertAppInfo.B4()) {
                H0(advertAppInfo, adCard, kVar);
                I0(adCard, advertAppInfo);
                return;
            } else if (advertAppInfo.D4()) {
                J0(adCard, kVar);
                return;
            } else {
                return;
            }
        }
        this.O.setVisibility(8);
    }

    public final void L0(AdCard adCard, AdvertAppInfo advertAppInfo, k kVar) {
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 != null) {
            advertAppInfo2.k4(StringHelper.getFormatTimeForJustNow(adCard.time));
        }
        this.V.setShowFlag(1413);
        this.V.setData(advertAppInfo2);
        ((TextView) this.V.getUserName()).setText(adCard.userName);
        d.b.h0.b.g.b.d((TextView) this.V.getUserName());
        this.V.getUserName().setOnClickListener(kVar);
        this.V.setAfterAdjustChildWidthListener(new a(adCard));
        this.V.getHeaderImg().setOnLongClickListener(new b(advertAppInfo));
        X0(this.V.getHeaderImg(), adCard.portraitClick, kVar);
        if (O0(adCard)) {
            this.V.setVisibility(8);
        }
    }

    public final void M0(AdCard adCard, k kVar) {
        this.U.setType(TbadkCoreApplication.getInst().getCardShowType());
        if (P0()) {
            this.U.setVisibility(8);
            this.U.setBarNameClickEnabled(false);
            this.U.setShareVisible(false);
            this.U.setShowPraiseNum(false);
            this.U.setCommentNumEnable(false);
            this.U.setReplyTimeVisible(false);
            this.W.setVisibility(0);
            this.a0.setVisibility(8);
            return;
        }
        x0(adCard, kVar);
    }

    public final boolean N0() {
        return this.f18315f == 1;
    }

    public boolean O0(AdCard adCard) {
        return P0() && adCard.isPBBanner;
    }

    public boolean P0() {
        return getBusinessType() == 4;
    }

    public final boolean Q0(View view, ViewGroup viewGroup) {
        return (view == null || view.getParent() == null || view.getParent() != viewGroup) ? false : true;
    }

    public final void R0(View view, ViewGroup viewGroup) {
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
            viewGroup.addView(view);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: S0 */
    public void y(AdCard adCard, int i2) {
        this.K.onChangeSkinType();
        this.V.onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
        this.U.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            d.b.h0.r.u.c d2 = d.b.h0.r.u.c.d(this.r);
            d2.k(R.string.J_X06);
            d2.g(R.color.CAM_X0205, R.color.cp_bg_line_e_alpha50);
        }
        d.b.h0.b.g.b.e((TextView) this.V.getUserName());
        SkinManager.setViewTextColor(this.H, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.N, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.J, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.I, R.color.CAM_X0304, 1);
        SkinManager.setBackgroundResource(this.I, R.drawable.ad_download_progress_button_bg);
        SkinManager.setBackgroundColor(this.h0, R.color.CAM_X0203);
        SkinManager.setBackgroundColor(this.g0, R.color.CAM_X0204);
        this.M.o(i2);
        d.b.h0.r.u.c d3 = d.b.h0.r.u.c.d(this.i0);
        d3.k(R.string.J_X05);
        d3.f(R.color.CAM_X0206);
        this.i0.onChangeSkinType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: T0 */
    public void z(AdCard adCard) {
        this.S = adCard;
        if (adCard == null) {
            return;
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        k kVar = new k(adCard);
        r0(adCard);
        L0(adCard, advertAppInfo, kVar);
        F0(adCard);
        K0(adCard, advertAppInfo, kVar);
        E0(adCard);
        D0(advertAppInfo);
        M0(adCard, kVar);
        this.r.setOnClickListener(kVar);
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            y0(adCard.getPreLoadData());
        }
        A0(adCard);
        y(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void U0() {
        if (this.d0 == null || this.e0 == null) {
            return;
        }
        d.b.i0.o.d.d.c().i(this.d0, this.e0);
    }

    public final void V0(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.m(downloadData));
        } else {
            downloadData.setStatus(this.M.getDownloadStatus());
        }
    }

    public final void W0(AdCard adCard, k kVar) {
        if (adCard.directDownload) {
            this.M.setOnClickListener(kVar);
        } else {
            this.M.setOnClickInterceptListener(new e());
        }
    }

    public void X0(View view, AdCard.b bVar, k kVar) {
        if (view == null) {
            return;
        }
        if (bVar != null && !d.b.c.e.p.k.isEmpty(bVar.f20391a)) {
            view.setClickable(true);
            view.setOnClickListener(new g(bVar));
            return;
        }
        view.setClickable(true);
        view.setOnClickListener(kVar);
    }

    public void Y0(TbImageView tbImageView, AdCard.b bVar) {
        if (tbImageView == null) {
            return;
        }
        if (bVar != null && !d.b.c.e.p.k.isEmpty(bVar.f20391a)) {
            tbImageView.setClickable(true);
            tbImageView.setOnClickListener(new f(tbImageView, bVar));
            return;
        }
        tbImageView.setClickable(false);
    }

    public void Z0(AdvertAppInfo advertAppInfo, int i2, boolean z, String str) {
        if (advertAppInfo == null) {
            return;
        }
        if (!d.b.c.e.p.j.A()) {
            d.b.c.e.p.l.K(this.m.getPageActivity(), R.string.neterror);
        } else if (advertAppInfo.B4()) {
            if (TextUtils.isEmpty(str)) {
                str = this.m.getString(R.string.frs_network_tips);
            }
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.m.getPageActivity());
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.alert_yes_button, new h(advertAppInfo, i2));
            aVar.setNegativeButton(R.string.cancel, new i());
            aVar.create(this.m).show();
        }
    }

    public DownloadData a1(AdvertAppInfo advertAppInfo, int i2) {
        DownloadData downloadData = new DownloadData(p(advertAppInfo));
        downloadData.setUrl(advertAppInfo.I3);
        downloadData.setName(advertAppInfo.F3);
        downloadData.setPosition(i2);
        downloadData.setNotifyId(d.b.c.e.m.b.d(advertAppInfo.E3, 0));
        return downloadData;
    }

    public final void b1() {
        if (this.d0 == null || this.e0 == null) {
            return;
        }
        d.b.i0.o.d.d.c().q(this.d0, this.e0);
    }

    public final void c1(AdCard adCard) {
        d.b.h0.r.q.c appInfoModel = adCard.getAppInfoModel();
        RelativeLayout downloadButtonContainer = this.i0.getDownloadButtonContainer();
        if (d.b.h0.r.q.c.a(appInfoModel)) {
            this.i0.setVisibility(0);
            this.i0.setAppInfo(appInfoModel);
            this.i0.setAd(adCard.getAdvertAppInfo());
            if (Q0(this.M, downloadButtonContainer)) {
                return;
            }
            R0(this.M, downloadButtonContainer);
            return;
        }
        this.i0.setVisibility(8);
        if (Q0(this.M, this.O)) {
            return;
        }
        R0(this.M, this.O);
    }

    public d.b.i0.j1.o.h.a getAnimationInfo() {
        return this.R;
    }

    public abstract int getCustomLayout();

    public abstract int getLayout();

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, d.b.i0.j1.o.l.e
    public void k() {
        if (P0()) {
            this.H.setTextSize(0, TbConfig.getContentSize());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        U0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b1();
    }

    public final void p0(View view) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.f0.setVisibility(0);
        if (Q0(view, this.f0)) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.f0.removeAllViews();
        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f0.addView(view);
    }

    public final void q0(View view) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.f0.setVisibility(8);
        if (Q0(view, this.V)) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.V.addAdTagView(this.L);
    }

    public final void r0(AdCard adCard) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.P.getLayoutParams();
        layoutParams.topMargin = this.m.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.P.setPadding(0, 0, 0, 0);
        this.f0.setVisibility(8);
        this.g0.setVisibility(8);
        if (P0()) {
            View view = this.r;
            int i2 = this.y;
            view.setPadding(i2, this.z, i2, 0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.P.getLayoutParams();
            int k2 = (d.b.c.e.p.l.k(getContext()) - (this.B * 2)) - (this.y * 2);
            int i3 = this.v;
            int i4 = this.w;
            this.G = (k2 - i3) - i4;
            layoutParams2.leftMargin = i3 + i4;
            this.h0.setVisibility(0);
            q0(this.L);
            if (O0(adCard)) {
                this.h0.setVisibility(8);
                this.r.setPadding(0, 0, 0, 0);
                View view2 = this.P;
                int i5 = this.y;
                view2.setPadding(i5, 0, i5, 0);
                layoutParams2.leftMargin = 0;
                this.G = (d.b.c.e.p.l.k(getContext()) - (this.y * 2)) - (this.B * 2);
                layoutParams.topMargin = this.m.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
                this.g0.setVisibility(0);
                SkinManager.setBackgroundColor(this.g0, R.color.CAM_X0204);
                p0(this.L);
                return;
            }
            return;
        }
        View view3 = this.r;
        int i6 = this.x;
        view3.setPadding(i6, this.z, i6, 0);
        this.G = (d.b.c.e.p.l.k(getContext()) - (this.x * 2)) - (this.A * 2);
        if ((d.b.i0.q0.b.e().g() || d.b.i0.q0.a.h().j()) && N0()) {
            this.u.setVisibility(0);
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0201);
        } else {
            this.u.setVisibility(8);
        }
        this.h0.setVisibility(8);
    }

    public void s0() {
        d.b.i0.j1.o.a aVar = this.o;
        if (aVar != null) {
            aVar.a(3, null);
        }
    }

    public void t0(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey == null) {
            return;
        }
        this.d0 = downloadCacheKey;
        b1();
        this.e0 = null;
        AdDownloadData b2 = d.b.i0.o.d.d.c().b(downloadCacheKey);
        if (w.q(b2.getPkgName())) {
            b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        }
        AdCard adCard = this.S;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.S.getAdvertAppInfo().c4;
            b2.setExtInfo(this.S.getAdvertAppInfo().T3);
            b2.setDownloadKey(this.S.getDownloadKey());
            b2.setAppJson(App.toJson(this.S.getAdvertAppInfo().d4).toString());
            b2.setPage(str);
            b2.setDeeplinkUrl(this.S.scheme);
        }
        d.b.i0.o.c.b.d.a aVar = new d.b.i0.o.c.b.d.a(this.M, b2);
        this.e0 = new d.b.i0.o.d.g.b(aVar);
        if (b2.extra().getPercent() > 0) {
            aVar.d(b2);
        }
        U0();
        this.M.c(b2.getCurrentState());
    }

    public boolean u0(AdCard.b bVar) {
        String currentAccount;
        if (bVar == null || bVar.f20394d != 1 || ((currentAccount = TbadkCoreApplication.getCurrentAccount()) != null && currentAccount.length() > 0)) {
            return false;
        }
        this.b0 = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.m.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.m, new CustomMessage<>(2002001, loginActivityConfig));
        return true;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View v() {
        MessageManager.getInstance().registerListener(this.j0);
        MessageManager.getInstance().registerListener(this.k0);
        MessageManager.getInstance().registerListener(this.l0);
        View inflate = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.r = inflate;
        this.g0 = inflate.findViewById(R.id.banner_top_divider);
        View findViewById = this.r.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.u = findViewById;
        findViewById.setClickable(true);
        this.H = (TextView) this.r.findViewById(R.id.ad_title);
        this.I = (TextView) this.r.findViewById(R.id.transform_btn);
        this.M = (ApkDownloadView) this.r.findViewById(R.id.advert_app_download_view);
        this.N = (TextView) this.r.findViewById(R.id.advert_app_name);
        this.O = (RelativeLayout) this.r.findViewById(R.id.bottom_transformation_area);
        this.M.j(this.m.getUniqueId());
        this.j0.setTag(this.m.getUniqueId());
        this.P = this.r.findViewById(R.id.card_ad_middle_container);
        this.k0.setTag(this.m.getUniqueId());
        this.l0.setTag(this.m.getUniqueId());
        AdThreadCommentAndPraiseInfoLayout adThreadCommentAndPraiseInfoLayout = (AdThreadCommentAndPraiseInfoLayout) this.r.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.U = adThreadCommentAndPraiseInfoLayout;
        adThreadCommentAndPraiseInfoLayout.setStyle(1);
        this.V = (AdThreadUserInfoLayout) this.r.findViewById(R.id.card_ad_user_info_layout);
        this.f0 = (FrameLayout) this.r.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.L = linearLayout;
        AdCloseView adCloseView = (AdCloseView) linearLayout.findViewById(R.id.ad_close_view);
        this.K = adCloseView;
        ViewGroup.LayoutParams layoutParams = adCloseView.o.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.K.o.getLayoutParams();
        int g2 = d.b.c.e.p.l.g(getContext(), R.dimen.tbds62);
        layoutParams2.width = g2;
        layoutParams.height = g2;
        TextView textView = (TextView) this.L.findViewById(R.id.feed_tag);
        this.J = textView;
        textView.setVisibility(8);
        this.V.addAdTagView(this.L);
        ViewStub viewStub = (ViewStub) this.r.findViewById(R.id.ad_custom_view_stub);
        this.s = viewStub;
        viewStub.setLayoutResource(getCustomLayout());
        this.t = this.s.inflate();
        this.W = this.r.findViewById(R.id.pb_bottom_view);
        this.a0 = this.r.findViewById(R.id.frs_bottom_view);
        this.h0 = this.r.findViewById(R.id.pb_ad_bottom_divider);
        AdAppInfoView adAppInfoView = (AdAppInfoView) this.r.findViewById(R.id.app_info_view);
        this.i0 = adAppInfoView;
        d.b.h0.r.u.c d2 = d.b.h0.r.u.c.d(adAppInfoView);
        d2.k(R.string.J_X05);
        d2.f(R.color.CAM_X0206);
        G0(this.t);
        return this.r;
    }

    public final void v0(TbImageView tbImageView) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        tbImageView.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        rect.left = i2;
        rect.top = iArr[1];
        rect.right = i2 + tbImageView.getWidth();
        rect.bottom = rect.top + tbImageView.getHeight();
        d.b.i0.j1.o.h.a aVar = new d.b.i0.j1.o.h.a();
        this.R = aVar;
        aVar.f57367a = tbImageView.getUrl();
        this.R.f57368b = rect;
    }

    public void w0(AdCard.b bVar) {
        d.b.i0.j1.o.a aVar;
        if (bVar == null) {
            return;
        }
        if (u0(bVar) && !v.h(bVar.f20391a)) {
            d.b.i0.j1.o.a aVar2 = this.o;
            if (aVar2 != null) {
                aVar2.b(bVar.f20392b, bVar.f20393c, null);
                return;
            }
            return;
        }
        AdCard adCard = this.S;
        if (adCard == null || adCard.getAdvertAppInfo() == null) {
            return;
        }
        String str = bVar.f20391a;
        String p = p(this.S.getAdvertAppInfo());
        String str2 = this.S.getAdvertAppInfo().T3;
        int i2 = 3;
        AdCard adCard2 = this.S;
        if (!adCard2.directDownload && adCard2.getAdvertAppInfo().B4()) {
            if (!w.B(this.S.getAdvertAppInfo(), str)) {
                i2 = w.e(this.m, str, p, str2);
            }
        } else {
            i2 = w.e(this.m, str, p, str2);
        }
        if (w.p(i2) && (aVar = this.o) != null) {
            aVar.a(i2, null);
            return;
        }
        d.b.i0.j1.o.a aVar3 = this.o;
        if (aVar3 != null) {
            aVar3.b(bVar.f20392b, bVar.f20393c, null);
        }
    }

    public final void x0(AdCard adCard, k kVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.a0.setVisibility(0);
            this.U.setVisibility(8);
            return;
        }
        this.a0.setVisibility(8);
        this.U.setVisibility(0);
        this.U.setBarNameClickEnabled(false);
        this.U.setReplyTimeVisible(false);
        this.U.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.U.setAgreeClickable(true);
            this.U.setPraiseContainerBgGray(false);
        } else {
            this.U.setAgreeClickable(false);
            this.U.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.U.setShareClickable(true);
            this.U.setShareContainerBgGray(false);
        } else {
            this.U.setShareClickable(false);
            this.U.setShareContainerBgGray(true);
        }
        if (this.U.getCommentContainer() != null) {
            this.U.getCommentContainer().setOnClickListener(kVar);
        }
        this.U.setNeedAddReplyIcon(true);
        this.U.setCommentNumEnable(false);
        this.U.setCommentClickable(true);
        this.U.setReplayContainerBgGray(true);
        this.U.setOnClickListener(kVar);
        this.U.setShareData(adCard);
        this.U.setDisPraiseViewVisibility(false);
    }

    public final void y0(String str) {
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray(SocialConstants.PARAM_IMAGE);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i2);
                    String optString = jSONObject.optString("pic_url");
                    int optInt = jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH);
                    d.b.c.e.l.d.h().k(optString, 17, null, this.T, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / optInt) * this.T), this.m.getUniqueId(), new Object[0]);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void z0(AdvertAppInfo advertAppInfo, int i2, ApkDownloadView apkDownloadView) {
        d.b.i0.j1.o.c cVar;
        if (advertAppInfo == null) {
            return;
        }
        if (advertAppInfo.E4() != 0) {
            d.b.c.e.p.l.K(this.m.getPageActivity(), R.string.download_error);
            return;
        }
        if (this.c0 == null) {
            this.c0 = new PermissionJudgePolicy();
        }
        this.c0.clearRequestPermissionList();
        this.c0.appendRequestPermission(this.m.getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        if (this.c0.startRequestPermission(this.m.getPageActivity()) || (cVar = this.q) == null) {
            return;
        }
        cVar.a(advertAppInfo, i2);
        if (apkDownloadView != null) {
            apkDownloadView.v(a1(advertAppInfo, i2));
        }
    }
}
