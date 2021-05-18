package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import d.a.j0.s.c.d;
import d.a.k0.o.d.f.b;
import d.a.k0.s2.c0.e;
import d.a.k0.s2.c0.i;
import java.util.List;
/* loaded from: classes5.dex */
public class ApkDownloadView extends FrameLayout implements d.a.k0.o.d.f.b {

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.s2.k0.a f20379e;

    /* renamed from: f  reason: collision with root package name */
    public FeedAdProgressButton f20380f;

    /* renamed from: g  reason: collision with root package name */
    public FeedAdProgressText f20381g;

    /* renamed from: h  reason: collision with root package name */
    public DownloadData f20382h;

    /* renamed from: i  reason: collision with root package name */
    public b.a f20383i;
    public DownloadStatus j;
    public CustomMessageListener k;
    public CustomMessageListener l;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.f20382h != null) {
                DownloadData downloadData = null;
                List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                int i2 = 0;
                while (true) {
                    if (i2 >= data.size()) {
                        break;
                    }
                    DownloadData downloadData2 = data.get(i2);
                    if (TextUtils.isEmpty(ApkDownloadView.this.f20382h.getId())) {
                        i2++;
                    } else if (ApkDownloadView.this.f20382h.getId().equals(downloadData2.getId())) {
                        downloadData = downloadData2;
                    }
                }
                if (downloadData != null) {
                    int k = ApkDownloadView.this.k(downloadData);
                    if (i.n(downloadData) == 1) {
                        ApkDownloadView.this.w(k);
                    } else if (i.n(downloadData) == 3) {
                        ApkDownloadView.this.f20379e.setButtonText(ApkDownloadView.this.getResources().getString(R.string.immediately_install));
                    } else {
                        ApkDownloadView.this.p(downloadData);
                    }
                    ApkDownloadView.this.postInvalidate();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || ApkDownloadView.this.f20382h == null) {
                return;
            }
            DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
            if (ApkDownloadView.this.f20382h.getId() == null || downloadData == null || !ApkDownloadView.this.f20382h.getId().equals(downloadData.getId())) {
                return;
            }
            ApkDownloadView.this.v(downloadData);
        }
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.k = null;
        this.l = null;
        n(context);
    }

    public static int l(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = i.l().j(downloadData.getId(), downloadData.getName());
        }
        return Math.max(process, 0);
    }

    public static int m(DownloadData downloadData) {
        d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.g()) {
            return e.p(downloadData);
        }
        return i.n(downloadData);
    }

    @Override // d.a.k0.o.d.f.b
    public void a(int i2) {
        if (this.j == DownloadStatus.STATUS_DOWNLOADING) {
            w(i2);
        }
    }

    @Override // d.a.k0.o.d.f.b
    public boolean b(View view) {
        b.a aVar = this.f20383i;
        if (aVar != null) {
            return aVar.b(view);
        }
        return false;
    }

    @Override // d.a.k0.o.d.f.b
    public void c(@NonNull DownloadStatus downloadStatus) {
        this.j = downloadStatus;
        DownloadData downloadData = this.f20382h;
        if (downloadData != null) {
            downloadData.setStatus(getDownloadStatus());
            v(this.f20382h);
        }
    }

    @Override // d.a.k0.o.d.f.b
    public void d(DownloadStatus downloadStatus, int i2) {
        c(downloadStatus);
        a(i2);
    }

    @Override // d.a.k0.o.d.f.b
    public View getActionBar() {
        return this;
    }

    public int getDownloadStatus() {
        DownloadStatus downloadStatus = this.j;
        if (downloadStatus == null || downloadStatus == DownloadStatus.STATUS_NONE) {
            return 6;
        }
        if (downloadStatus == DownloadStatus.STATUS_DOWNLOADING) {
            return 1;
        }
        if (downloadStatus == DownloadStatus.STATUS_PAUSED) {
            return 7;
        }
        if (downloadStatus == DownloadStatus.STATUS_SUCCESS) {
            return 3;
        }
        return downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS ? 8 : 6;
    }

    @Override // d.a.k0.o.d.f.b
    @NonNull
    public View getRealView() {
        return this;
    }

    public void i() {
        this.f20379e.d();
    }

    public void j(BdUniqueId bdUniqueId) {
        if (this.k == null) {
            a aVar = new a(2001118);
            this.k = aVar;
            aVar.setTag(bdUniqueId);
        }
        if (this.l == null) {
            b bVar = new b(2016484);
            this.l = bVar;
            bVar.setTag(bdUniqueId);
        }
    }

    public final int k(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        return (int) ((downloadData.getLength() * 100) / downloadData.getSize());
    }

    public final void n(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.apk_download_view_layout, (ViewGroup) this, true);
        this.f20380f = (FeedAdProgressButton) inflate.findViewById(R.id.feed_ad_operate_progress_button);
        this.f20381g = (FeedAdProgressText) inflate.findViewById(R.id.feed_ad_operate_progress_text);
        this.f20379e = this.f20380f;
        o(TbadkCoreApplication.getInst().getSkinType());
    }

    public void o(int i2) {
        this.f20379e.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        q();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
        t();
    }

    public void p(DownloadData downloadData) {
        this.f20379e.setButtonText(getResources().getString(R.string.go_on_download), l(downloadData));
    }

    public final void q() {
        if (this.k != null) {
            MessageManager.getInstance().registerListener(this.k);
        }
        if (this.l != null) {
            MessageManager.getInstance().registerListener(this.l);
        }
    }

    public void r(DownloadData downloadData) {
        this.f20379e.setButtonText(getResources().getString(R.string.install_app));
    }

    public void s(DownloadData downloadData) {
        w(l(downloadData));
    }

    public void setBackgroundSkin(@DrawableRes int i2) {
        d.a.k0.s2.k0.a aVar = this.f20379e;
        if (aVar instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) aVar).setBackgroundSkin(i2);
        }
    }

    public void setData(DownloadData downloadData) {
        if (downloadData == null) {
            return;
        }
        DownloadData downloadData2 = (DownloadData) downloadData.clone();
        this.f20382h = downloadData2;
        if (downloadData2 == null) {
            return;
        }
        setTag(downloadData2);
        v(downloadData);
    }

    public void setDefaultText(String str) {
        d.a.k0.s2.k0.a aVar;
        if (TextUtils.isEmpty(str) || (aVar = this.f20379e) == null) {
            return;
        }
        aVar.setButtonText(str);
    }

    public void setForegroundSkin(@DrawableRes int i2) {
        d.a.k0.s2.k0.a aVar = this.f20379e;
        if (aVar instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) aVar).setForeground(i2);
        }
    }

    public void setIsPbDownload(boolean z) {
        if (z) {
            this.f20380f.setVisibility(8);
            this.f20381g.setVisibility(0);
            this.f20379e = this.f20381g;
            return;
        }
        this.f20381g.setVisibility(8);
        this.f20380f.setVisibility(0);
        this.f20379e = this.f20380f;
    }

    public void setOnClickInterceptListener(b.a aVar) {
        this.f20383i = aVar;
    }

    public void setStrokeWidth(@DimenRes int i2) {
        d.a.k0.s2.k0.a aVar = this.f20379e;
        if (aVar instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) aVar).setStrokeWidth(i2);
        }
    }

    public void setTextColor(int i2) {
        this.f20379e.setButtonTextColor(i2);
    }

    public void setTextColorInitSkin(@ColorRes int i2) {
        d.a.k0.s2.k0.a aVar = this.f20379e;
        if (aVar instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) aVar).setTextColorInitSkin(i2);
        }
    }

    public void setTextColorSkin(@ColorRes int i2) {
        d.a.k0.s2.k0.a aVar = this.f20379e;
        if (aVar instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) aVar).setTextColorSkin(i2);
        }
    }

    public void setTextNightColor(int i2) {
        this.f20379e.setButtonTextNightColor(i2);
    }

    public void setTextSize(int i2) {
        this.f20379e.setButtonTextSize(i2);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 == 0) {
            q();
        } else {
            u();
        }
    }

    public final void t() {
        setOnClickInterceptListener(null);
    }

    public final void u() {
        if (this.k != null) {
            MessageManager.getInstance().unRegisterListener(this.k);
        }
        if (this.l != null) {
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public void v(DownloadData downloadData) {
        if (downloadData == null) {
            return;
        }
        switch (downloadData.getStatus()) {
            case 1:
                w(l(downloadData));
                return;
            case 2:
            case 7:
                this.f20379e.setButtonText(getResources().getString(R.string.go_on_download), l(downloadData));
                return;
            case 3:
                this.f20379e.setButtonText(getResources().getString(R.string.immediately_install), 0);
                return;
            case 4:
            default:
                return;
            case 5:
                w(l(downloadData));
                return;
            case 6:
                this.f20379e.setButtonText(getResources().getString(R.string.install_app));
                return;
            case 8:
                this.f20379e.setButtonText(getResources().getString(R.string.immediately_open), 0);
                return;
        }
    }

    public final void w(int i2) {
        this.f20379e.setProgress(Math.max(0, i2));
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = null;
        this.l = null;
        n(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.k = null;
        this.l = null;
        n(context);
    }
}
