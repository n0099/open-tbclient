package com.baidu.tieba.recapp.lego.view;

import android.content.res.Resources;
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
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.download.DownloadData;
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
import d.a.c.e.p.l;
import d.a.n0.r.s.a;
import d.a.o0.q.d.g.b;
import d.a.o0.t2.y;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import tbclient.AdCloseInfo;
import tbclient.App;
/* loaded from: classes5.dex */
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
    public AdCard R;
    public AdThreadCommentAndPraiseInfoLayout S;
    public AdThreadUserInfoLayout T;
    public View U;
    public View V;
    public PermissionJudgePolicy W;
    public DownloadCacheKey a0;
    public d.a.o0.q.d.h.d b0;
    public FrameLayout c0;
    public View i0;
    public View j0;
    public AdAppInfoView k0;
    public CustomMessageListener l0;
    public CustomMessageListener m0;
    public View r;
    public ViewStub s;
    public View t;
    public View u;
    public final int v;
    public final int w;
    public final int x;
    public final int y;
    public final int z;

    /* loaded from: classes5.dex */
    public class a implements AdThreadUserInfoLayout.AfterAdjustChildWidthListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdCard f20317a;

        public a(AdCard adCard) {
            this.f20317a = adCard;
        }

        @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
        public void afterChildWidth() {
            ((TextView) AdCardBaseView.this.T.getUserName()).setText(this.f20317a.userName);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnLongClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f20319e;

        public b(AdvertAppInfo advertAppInfo) {
            this.f20319e = advertAppInfo;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            AdvertAppInfo advertAppInfo;
            d.a.n0.s.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense == null || !adAdSense.f() || (advertAppInfo = this.f20319e) == null) {
                return false;
            }
            d.a.c.e.p.a.a(advertAppInfo.D4());
            ((Vibrator) AdCardBaseView.this.m.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20321e;

        public c(String str) {
            this.f20321e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            if (AdCardBaseView.this.R != null) {
                str = AdCardBaseView.this.R.getDownloadId();
                str2 = AdCardBaseView.this.R.getExtInfo();
            } else {
                str = null;
                str2 = null;
            }
            int e2 = y.e(AdCardBaseView.this.m, this.f20321e, str, str2);
            if (AdCardBaseView.this.o != null) {
                AdCardBaseView.this.o.a(e2, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdCardBaseView.this.K.performClick();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements b.a {
        public e() {
        }

        @Override // d.a.o0.q.d.g.b.a
        public boolean b(View view) {
            AdCardBaseView.this.Z();
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f20325e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f20326f;

        public f(AdvertAppInfo advertAppInfo, int i2) {
            this.f20325e = advertAppInfo;
            this.f20326f = i2;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            AdCardBaseView adCardBaseView = AdCardBaseView.this;
            adCardBaseView.c0(this.f20325e, this.f20326f, adCardBaseView.M);
            AdCardBaseView adCardBaseView2 = AdCardBaseView.this;
            ApkDownloadView apkDownloadView = adCardBaseView2.M;
            if (apkDownloadView != null) {
                apkDownloadView.v(adCardBaseView2.H0(this.f20325e, this.f20326f));
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements a.e {
        public g() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public static class h extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<AdCardBaseView> f20329a;

        public h(int i2, AdCardBaseView adCardBaseView) {
            super(i2);
            this.f20329a = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.f20329a.get();
            if (adCardBaseView == null || customResponsedMessage == null || (downloadData = (DownloadData) customResponsedMessage.getData()) == null || TextUtils.isEmpty(adCardBaseView.Q) || !adCardBaseView.Q.equals(downloadData.getId())) {
                return;
            }
            int p = d.a.o0.t2.c0.e.p(downloadData);
            if (p == 7) {
                adCardBaseView.I.setText(R.string.pause_load);
            } else if (p == 1 || p == 2) {
                adCardBaseView.I.setText(R.string.pb_download_pause);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public AdCard f20330e;

        public i(AdCard adCard) {
            this.f20330e = adCard;
        }

        public final void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (!this.f20330e.isDirectDownload() && !z) {
                d(advertAppInfo);
            } else {
                b(advertAppInfo, z);
            }
        }

        public final void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i2 = advertAppInfo.position;
            int m = ApkDownloadView.m(AdCardBaseView.this.H0(advertAppInfo, i2));
            if ((6 == m || 7 == m) && d.a.c.e.p.j.z() && !d.a.c.e.p.j.H()) {
                AdCardBaseView.this.G0(advertAppInfo, i2, true, "");
                return;
            }
            AdCardBaseView adCardBaseView = AdCardBaseView.this;
            adCardBaseView.g0(advertAppInfo, i2, adCardBaseView.M, z);
            AdCardBaseView.this.Z();
        }

        public final void c(AdvertAppInfo advertAppInfo) {
            String extInfo = AdCardBaseView.this.R.getExtInfo();
            int e2 = y.e(AdCardBaseView.this.m, AdCardBaseView.this.R.scheme, AdCardBaseView.this.R.getDownloadId(), extInfo);
            if (AdCardBaseView.this.o != null) {
                AdCardBaseView.this.o.a(e2, null);
            }
        }

        public final void d(AdvertAppInfo advertAppInfo) {
            String str = AdCardBaseView.this.R.scheme;
            int e2 = !y.B(advertAppInfo, str) ? y.e(AdCardBaseView.this.m, str, AdCardBaseView.this.R.getDownloadId(), AdCardBaseView.this.R.getExtInfo()) : 3;
            if (AdCardBaseView.this.o != null) {
                AdCardBaseView.this.o.a(e2, null);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!d.a.c.e.p.j.A()) {
                AdCardBaseView.this.m.showToast(R.string.neterror);
            } else if (this.f20330e == null || view == null || view.getId() == R.id.thread_info_commont_container) {
            } else {
                AdvertAppInfo advertAppInfo = this.f20330e.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.M;
                if (advertAppInfo != null && advertAppInfo.F4()) {
                    a(advertAppInfo, z);
                } else {
                    c(advertAppInfo);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class j extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<AdCardBaseView> f20332a;

        public j(int i2, AdCardBaseView adCardBaseView) {
            super(i2);
            this.f20332a = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.f20332a.get();
            if (adCardBaseView == null || customResponsedMessage == null || (downloadData = (DownloadData) customResponsedMessage.getData()) == null || TextUtils.isEmpty(adCardBaseView.Q) || !adCardBaseView.Q.equals(downloadData.getId())) {
                return;
            }
            adCardBaseView.M.r(downloadData);
        }
    }

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.b0 = null;
        this.l0 = new h(2016484, this);
        this.m0 = new j(2016483, this);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: A0 */
    public void w(AdCard adCard, int i2) {
        this.K.onChangeSkinType();
        this.T.onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
        this.S.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(this.r);
            d2.m(R.string.J_X06);
            d2.h(R.color.CAM_X0205, R.color.cp_bg_line_e_alpha50);
        }
        d.a.n0.b.g.b.e((TextView) this.T.getUserName());
        SkinManager.setViewTextColor(this.H, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.N, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.J, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.I, R.color.CAM_X0304, 1);
        SkinManager.setBackgroundResource(this.I, R.drawable.ad_download_progress_button_bg);
        SkinManager.setBackgroundColor(this.j0, R.color.CAM_X0203);
        SkinManager.setBackgroundColor(this.i0, R.color.CAM_X0204);
        this.M.o(i2);
        d.a.n0.r.u.c d3 = d.a.n0.r.u.c.d(this.k0);
        d3.m(R.string.J_X05);
        d3.f(R.color.CAM_X0206);
        this.k0.onChangeSkinType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: B0 */
    public void x(AdCard adCard) {
        this.R = adCard;
        if (adCard == null) {
            return;
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        i iVar = new i(adCard);
        Y(adCard);
        s0(adCard, advertAppInfo, iVar);
        j0(adCard);
        q0(adCard, advertAppInfo, iVar);
        i0(adCard);
        h0(advertAppInfo, adCard);
        t0(adCard, iVar);
        this.r.setOnClickListener(iVar);
        d0(adCard);
        w(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void C0() {
        if (this.a0 == null || this.b0 == null) {
            return;
        }
        d.a.o0.q.d.e.c().i(this.a0, this.b0);
    }

    public final void D0(AdCard adCard, DownloadData downloadData) {
        if (adCard.isDirectDownload()) {
            downloadData.setStatus(ApkDownloadView.m(downloadData));
        } else {
            downloadData.setStatus(this.M.getDownloadStatus());
        }
    }

    public final void E0(AdCard adCard, i iVar) {
        if (adCard.isDirectDownload()) {
            this.M.setOnClickListener(iVar);
        } else {
            this.M.setOnClickInterceptListener(new e());
        }
    }

    public void F0(View view, i iVar) {
        if (view == null) {
            return;
        }
        view.setClickable(true);
        view.setOnClickListener(iVar);
    }

    public void G0(AdvertAppInfo advertAppInfo, int i2, boolean z, String str) {
        if (advertAppInfo == null) {
            return;
        }
        if (!d.a.c.e.p.j.A()) {
            l.L(this.m.getPageActivity(), R.string.neterror);
        } else if (advertAppInfo.F4()) {
            if (TextUtils.isEmpty(str)) {
                str = this.m.getString(R.string.frs_network_tips);
            }
            d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(this.m.getPageActivity());
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.alert_yes_button, new f(advertAppInfo, i2));
            aVar.setNegativeButton(R.string.cancel, new g());
            aVar.create(this.m).show();
        }
    }

    public DownloadData H0(AdvertAppInfo advertAppInfo, int i2) {
        DownloadData downloadData = new DownloadData(advertAppInfo.getDownloadId());
        downloadData.setUrl(advertAppInfo.a4);
        downloadData.setName(advertAppInfo.W3);
        downloadData.setPosition(i2);
        downloadData.setNotifyId(d.a.c.e.m.b.d(advertAppInfo.J3, 0));
        return downloadData;
    }

    public final void I0() {
        if (this.a0 == null || this.b0 == null) {
            return;
        }
        d.a.o0.q.d.e.c().q(this.a0, this.b0);
    }

    public final void J0(AdCard adCard) {
        d.a.n0.r.q.c appInfoModel = adCard.getAppInfoModel();
        RelativeLayout downloadButtonContainer = this.k0.getDownloadButtonContainer();
        if (d.a.n0.r.q.c.a(appInfoModel)) {
            this.k0.setVisibility(0);
            this.k0.setAppInfo(appInfoModel);
            this.k0.setAd(adCard.getAdvertAppInfo());
            if (y0(this.M, downloadButtonContainer)) {
                return;
            }
            z0(this.M, downloadButtonContainer);
            return;
        }
        this.k0.setVisibility(8);
        if (y0(this.M, this.O)) {
            return;
        }
        z0(this.M, this.O);
    }

    public final void V(View view) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.c0.setVisibility(0);
        if (y0(view, this.c0)) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.c0.removeAllViews();
        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.c0.addView(view);
    }

    public final void X(View view) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.c0.setVisibility(8);
        if (y0(view, this.T)) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.T.addAdTagView(this.L);
    }

    public final void Y(AdCard adCard) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.P.getLayoutParams();
        layoutParams.topMargin = this.m.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.P.setPadding(0, 0, 0, 0);
        this.c0.setVisibility(8);
        this.i0.setVisibility(8);
        if (x0()) {
            View view = this.r;
            int i2 = this.y;
            view.setPadding(i2, this.z, i2, 0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.P.getLayoutParams();
            int k = (l.k(getContext()) - (this.B * 2)) - (this.y * 2);
            int i3 = this.v;
            int i4 = this.w;
            this.G = (k - i3) - i4;
            layoutParams2.leftMargin = i3 + i4;
            this.j0.setVisibility(0);
            X(this.L);
            if (w0(adCard)) {
                this.j0.setVisibility(8);
                this.r.setPadding(0, 0, 0, 0);
                View view2 = this.P;
                int i5 = this.y;
                view2.setPadding(i5, 0, i5, 0);
                layoutParams2.leftMargin = 0;
                this.G = (l.k(getContext()) - (this.y * 2)) - (this.B * 2);
                layoutParams.topMargin = this.m.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
                this.i0.setVisibility(0);
                SkinManager.setBackgroundColor(this.i0, R.color.CAM_X0204);
                V(this.L);
                return;
            }
            return;
        }
        View view3 = this.r;
        int i6 = this.x;
        view3.setPadding(i6, this.z, i6, 0);
        this.G = (l.k(getContext()) - (this.x * 2)) - (this.A * 2);
        if ((d.a.o0.r0.b.e().g() || d.a.o0.r0.a.h().j()) && v0()) {
            this.u.setVisibility(0);
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0201);
        } else {
            this.u.setVisibility(8);
        }
        this.j0.setVisibility(8);
    }

    public void Z() {
        d.a.o0.k1.o.a aVar = this.o;
        if (aVar != null) {
            aVar.a(3, null);
        }
    }

    public void a0(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey == null) {
            return;
        }
        this.a0 = downloadCacheKey;
        I0();
        this.b0 = null;
        AdDownloadData b2 = d.a.o0.q.d.e.c().b(downloadCacheKey);
        if (y.q(b2.getPkgName())) {
            b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        }
        AdCard adCard = this.R;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.R.getAdvertAppInfo().T3;
            b2.setExtInfo(this.R.getExtInfo());
            b2.setDownloadKey(this.R.getDownloadKey());
            b2.setAppJson(App.toJson(this.R.getAdvertAppInfo().V3).toString());
            b2.setPage(str);
            b2.setDeeplinkUrl(this.R.scheme);
        }
        d.a.o0.q.c.b.d.a aVar = new d.a.o0.q.c.b.d.a(this.M, b2);
        this.b0 = new d.a.o0.q.d.h.b(aVar);
        if (b2.extra().getPercent() > 0) {
            aVar.e(b2);
        }
        C0();
        this.M.c(b2.getCurrentState());
    }

    public final void b0(AdCard adCard, i iVar) {
        if (adCard.getAgreeNum() == -1 && adCard.getShareNum() == -1 && adCard.getReplyNum() == -1) {
            this.V.setVisibility(0);
            this.S.setVisibility(8);
            return;
        }
        this.V.setVisibility(8);
        this.S.setVisibility(0);
        this.S.setBarNameClickEnabled(false);
        this.S.setReplyTimeVisible(false);
        this.S.setData(adCard.getThreadData());
        if (adCard.getAgreeNum() != -1) {
            this.S.setAgreeClickable(true);
            this.S.setPraiseContainerBgGray(false);
        } else {
            this.S.setAgreeClickable(false);
            this.S.setPraiseContainerBgGray(true);
        }
        if (adCard.getShareNum() != -1) {
            this.S.setShareClickable(true);
            this.S.setShareContainerBgGray(false);
        } else {
            this.S.setShareClickable(false);
            this.S.setShareContainerBgGray(true);
        }
        if (this.S.getCommentContainer() != null) {
            this.S.getCommentContainer().setOnClickListener(iVar);
        }
        this.S.setNeedAddReplyIcon(true);
        this.S.setCommentNumEnable(false);
        this.S.setCommentClickable(true);
        this.S.setReplayContainerBgGray(true);
        this.S.setOnClickListener(iVar);
        this.S.setShareData(adCard);
        this.S.setDisPraiseViewVisibility(false);
    }

    public void c0(AdvertAppInfo advertAppInfo, int i2, ApkDownloadView apkDownloadView) {
        d.a.o0.k1.o.c cVar;
        if (advertAppInfo == null) {
            return;
        }
        if (advertAppInfo.I4() != 0) {
            l.L(this.m.getPageActivity(), R.string.download_error);
            return;
        }
        if (this.W == null) {
            this.W = new PermissionJudgePolicy();
        }
        this.W.clearRequestPermissionList();
        this.W.appendRequestPermission(this.m.getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        if (this.W.startRequestPermission(this.m.getPageActivity()) || (cVar = this.q) == null) {
            return;
        }
        cVar.a(advertAppInfo, i2);
        if (apkDownloadView != null) {
            apkDownloadView.v(H0(advertAppInfo, i2));
        }
    }

    public abstract void d0(AdCard adCard);

    public float e0(@StringRes int i2) {
        try {
            return Float.parseFloat(TbadkCoreApplication.getInst().getContext().getResources().getString(i2).split(",")[0]);
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public void g0(AdvertAppInfo advertAppInfo, int i2, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo == null) {
            return;
        }
        DownloadData H0 = H0(advertAppInfo, i2);
        int m = ApkDownloadView.m(H0);
        if (m != 1) {
            if (m == 3) {
                d.a.o0.t2.c0.h.d(this.m.getPageActivity(), advertAppInfo.b4);
                return;
            } else if (m != 5) {
                if (m == 6 || m == 7) {
                    c0(advertAppInfo, i2, this.M);
                    apkDownloadView.s(H0);
                    return;
                } else if (m != 8) {
                    return;
                } else {
                    d.a.o0.q.d.e.c().o(this.m.getPageActivity(), advertAppInfo.b4);
                    return;
                }
            }
        }
        if (z) {
            d.a.o0.t2.c0.h.a(advertAppInfo);
            apkDownloadView.p(H0);
        }
    }

    public abstract int getCustomLayout();

    public abstract int getLayout();

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, d.a.o0.k1.o.l.e
    public void h() {
        if (x0()) {
            this.H.setTextSize(0, TbConfig.getContentSize());
        }
    }

    public final void h0(AdvertAppInfo advertAppInfo, AdCard adCard) {
        AdCloseInfo adCloseInfo;
        if (adCard != null && (adCloseInfo = adCard.closeInfo) != null && adCloseInfo.support_close.intValue() > 0) {
            this.K.setVisibility(0);
            this.K.setPage(getBusinessType());
            this.K.setData(advertAppInfo, adCard.closeInfo);
            l.c(this.m.getPageActivity(), this.L, 40, 40, 40, 120);
            this.L.setOnClickListener(new d());
            return;
        }
        this.K.setVisibility(8);
        this.J.setOnClickListener(null);
    }

    public final void i0(AdCard adCard) {
        int i2 = (this.G - this.C) - this.F;
        if (x0()) {
            i2 -= this.D + this.E;
        }
        String str = adCard.recommendReason;
        if (TextUtils.isEmpty(str)) {
            str = adCard.userName;
        }
        TextView textView = this.N;
        textView.setText(d.a.o0.t2.f0.c.a.d(str, "广告", i2, textView.getPaint()));
    }

    public final void j0(AdCard adCard) {
        String str = adCard.threadTitle;
        if (TextUtils.isEmpty(str)) {
            this.H.setVisibility(8);
            return;
        }
        int i2 = adCard.maxTitleLine;
        if (i2 <= 0) {
            i2 = 4;
        }
        this.H.setMaxLines(i2);
        this.H.setText(str);
        this.H.setVisibility(0);
    }

    public abstract void k0(View view);

    public final void l0(AdvertAppInfo advertAppInfo, @NonNull AdCard adCard, i iVar) {
        J0(adCard);
        this.I.setVisibility(8);
        this.M.setVisibility(0);
        this.M.setClickable(true);
        this.M.setInitText(adCard.getButtonText());
        this.Q = advertAppInfo.b4;
        DownloadData H0 = H0(advertAppInfo, advertAppInfo.position);
        if (y.q(this.Q)) {
            H0.setStatus(8);
        } else {
            D0(adCard, H0);
        }
        this.M.setData(H0);
        E0(adCard, iVar);
    }

    public final void m0(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey h2;
        if (adCard.isDirectDownload()) {
            return;
        }
        String scheme = adCard.getScheme();
        String downloadId = adCard.getDownloadId();
        if (!TextUtils.isEmpty(downloadId)) {
            h2 = d.a.o0.q.d.e.c().g(downloadId);
        } else {
            h2 = d.a.o0.q.d.e.c().h(scheme);
        }
        if (h2 == null) {
            h2 = DownloadCacheKey.create(downloadId, advertAppInfo.a4, advertAppInfo.b4);
            d.a.o0.q.d.e.c().i(h2, null);
        }
        a0(h2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        I0();
    }

    public final void p0(@NonNull AdCard adCard, i iVar) {
        this.M.setVisibility(8);
        this.k0.setVisibility(8);
        this.I.setVisibility(0);
        this.I.setClickable(true);
        SkinManager.setViewTextColor(this.I, R.color.CAM_X0304, 1);
        SkinManager.setBackgroundResource(this.I, R.drawable.ad_download_progress_button_bg);
        this.I.setText(adCard.getButtonText());
        this.I.setOnClickListener(new c(adCard.getButtonScheme()));
    }

    public final void q0(AdCard adCard, AdvertAppInfo advertAppInfo, i iVar) {
        if (adCard != null && advertAppInfo != null) {
            this.O.setVisibility(0);
            if (advertAppInfo.F4()) {
                l0(advertAppInfo, adCard, iVar);
                m0(adCard, advertAppInfo);
                return;
            } else if (advertAppInfo.H4()) {
                p0(adCard, iVar);
                return;
            } else {
                return;
            }
        }
        this.O.setVisibility(8);
    }

    public final void s0(AdCard adCard, AdvertAppInfo advertAppInfo, i iVar) {
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 != null) {
            advertAppInfo2.o4(StringHelper.getFormatTimeForJustNow(adCard.getTime()));
        }
        this.T.setShowFlag(1413);
        this.T.setData(advertAppInfo2);
        ((TextView) this.T.getUserName()).setText(adCard.userName);
        d.a.n0.b.g.b.d((TextView) this.T.getUserName());
        this.T.getUserName().setOnClickListener(iVar);
        this.T.setAfterAdjustChildWidthListener(new a(adCard));
        this.T.getHeaderImg().setOnLongClickListener(new b(advertAppInfo));
        F0(this.T.getHeaderImg(), iVar);
        if (w0(adCard)) {
            this.T.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View t() {
        MessageManager.getInstance().registerListener(this.l0);
        MessageManager.getInstance().registerListener(this.m0);
        View inflate = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.r = inflate;
        this.i0 = inflate.findViewById(R.id.banner_top_divider);
        View findViewById = this.r.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.u = findViewById;
        findViewById.setClickable(true);
        this.H = (TextView) this.r.findViewById(R.id.ad_title);
        this.I = (TextView) this.r.findViewById(R.id.transform_btn);
        this.M = (ApkDownloadView) this.r.findViewById(R.id.advert_app_download_view);
        this.N = (TextView) this.r.findViewById(R.id.advert_app_name);
        this.O = (RelativeLayout) this.r.findViewById(R.id.bottom_transformation_area);
        this.M.j(this.m.getUniqueId());
        this.l0.setTag(this.m.getUniqueId());
        this.P = this.r.findViewById(R.id.card_ad_middle_container);
        this.m0.setTag(this.m.getUniqueId());
        AdThreadCommentAndPraiseInfoLayout adThreadCommentAndPraiseInfoLayout = (AdThreadCommentAndPraiseInfoLayout) this.r.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.S = adThreadCommentAndPraiseInfoLayout;
        adThreadCommentAndPraiseInfoLayout.setStyle(1);
        this.T = (AdThreadUserInfoLayout) this.r.findViewById(R.id.card_ad_user_info_layout);
        this.c0 = (FrameLayout) this.r.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.L = linearLayout;
        AdCloseView adCloseView = (AdCloseView) linearLayout.findViewById(R.id.ad_close_view);
        this.K = adCloseView;
        ViewGroup.LayoutParams layoutParams = adCloseView.o.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.K.o.getLayoutParams();
        int g2 = l.g(getContext(), R.dimen.tbds62);
        layoutParams2.width = g2;
        layoutParams.height = g2;
        TextView textView = (TextView) this.L.findViewById(R.id.feed_tag);
        this.J = textView;
        textView.setVisibility(8);
        this.T.addAdTagView(this.L);
        ViewStub viewStub = (ViewStub) this.r.findViewById(R.id.ad_custom_view_stub);
        this.s = viewStub;
        viewStub.setLayoutResource(getCustomLayout());
        this.t = this.s.inflate();
        this.U = this.r.findViewById(R.id.pb_bottom_view);
        this.V = this.r.findViewById(R.id.frs_bottom_view);
        this.j0 = this.r.findViewById(R.id.pb_ad_bottom_divider);
        AdAppInfoView adAppInfoView = (AdAppInfoView) this.r.findViewById(R.id.app_info_view);
        this.k0 = adAppInfoView;
        d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(adAppInfoView);
        d2.m(R.string.J_X05);
        d2.f(R.color.CAM_X0206);
        k0(this.t);
        return this.r;
    }

    public final void t0(AdCard adCard, i iVar) {
        this.S.setType(TbadkCoreApplication.getInst().getCardShowType());
        if (x0()) {
            this.S.setVisibility(8);
            this.S.setBarNameClickEnabled(false);
            this.S.setShareVisible(false);
            this.S.setShowPraiseNum(false);
            this.S.setCommentNumEnable(false);
            this.S.setReplyTimeVisible(false);
            this.U.setVisibility(0);
            this.V.setVisibility(8);
            return;
        }
        b0(adCard, iVar);
    }

    public final boolean v0() {
        return this.f18065f == 1;
    }

    public boolean w0(AdCard adCard) {
        return x0() && adCard.isPBBanner;
    }

    public boolean x0() {
        return getBusinessType() == 4;
    }

    public final boolean y0(View view, ViewGroup viewGroup) {
        return (view == null || view.getParent() == null || view.getParent() != viewGroup) ? false : true;
    }

    public final void z0(View view, ViewGroup viewGroup) {
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
            viewGroup.addView(view);
        }
    }
}
