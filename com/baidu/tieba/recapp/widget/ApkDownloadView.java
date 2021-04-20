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
import d.b.h0.s.c.d;
import d.b.i0.o.d.f.b;
import d.b.i0.s2.a0.e;
import d.b.i0.s2.a0.i;
import java.util.List;
/* loaded from: classes4.dex */
public class ApkDownloadView extends FrameLayout implements d.b.i0.o.d.f.b {

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.s2.i0.a f20577e;

    /* renamed from: f  reason: collision with root package name */
    public FeedAdProgressButton f20578f;

    /* renamed from: g  reason: collision with root package name */
    public FeedAdProgressText f20579g;

    /* renamed from: h  reason: collision with root package name */
    public DownloadData f20580h;
    public b.a i;
    public DownloadStatus j;
    public CustomMessageListener k;
    public CustomMessageListener l;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.f20580h != null) {
                DownloadData downloadData = null;
                List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                int i = 0;
                while (true) {
                    if (i >= data.size()) {
                        break;
                    }
                    DownloadData downloadData2 = data.get(i);
                    if (TextUtils.isEmpty(ApkDownloadView.this.f20580h.getId())) {
                        i++;
                    } else if (ApkDownloadView.this.f20580h.getId().equals(downloadData2.getId())) {
                        downloadData = downloadData2;
                    }
                }
                if (downloadData != null) {
                    int k = ApkDownloadView.this.k(downloadData);
                    if (i.n(downloadData) == 1) {
                        ApkDownloadView.this.w(k);
                    } else if (i.n(downloadData) == 3) {
                        ApkDownloadView.this.f20577e.setButtonText(ApkDownloadView.this.getResources().getString(R.string.immediately_install));
                    } else {
                        ApkDownloadView.this.p(downloadData);
                    }
                    ApkDownloadView.this.postInvalidate();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || ApkDownloadView.this.f20580h == null) {
                return;
            }
            DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
            if (ApkDownloadView.this.f20580h.getId() == null || downloadData == null || !ApkDownloadView.this.f20580h.getId().equals(downloadData.getId())) {
                return;
            }
            ApkDownloadView.this.v(downloadData);
        }
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
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

    @Override // d.b.i0.o.d.f.b
    public void a(int i) {
        if (this.j == DownloadStatus.STATUS_DOWNLOADING) {
            w(i);
        }
    }

    @Override // d.b.i0.o.d.f.b
    public boolean b(View view) {
        b.a aVar = this.i;
        if (aVar != null) {
            return aVar.b(view);
        }
        return false;
    }

    @Override // d.b.i0.o.d.f.b
    public void c(@NonNull DownloadStatus downloadStatus) {
        this.j = downloadStatus;
        DownloadData downloadData = this.f20580h;
        if (downloadData != null) {
            downloadData.setStatus(getDownloadStatus());
            v(this.f20580h);
        }
    }

    @Override // d.b.i0.o.d.f.b
    public void d(DownloadStatus downloadStatus, int i) {
        c(downloadStatus);
        a(i);
    }

    @Override // d.b.i0.o.d.f.b
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

    @Override // d.b.i0.o.d.f.b
    @NonNull
    public View getRealView() {
        return this;
    }

    public void i() {
        this.f20577e.d();
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
        this.f20578f = (FeedAdProgressButton) inflate.findViewById(R.id.feed_ad_operate_progress_button);
        this.f20579g = (FeedAdProgressText) inflate.findViewById(R.id.feed_ad_operate_progress_text);
        this.f20577e = this.f20578f;
        o(TbadkCoreApplication.getInst().getSkinType());
    }

    public void o(int i) {
        this.f20577e.a();
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
        this.f20577e.setButtonText(getResources().getString(R.string.go_on_download), l(downloadData));
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
        this.f20577e.setButtonText(getResources().getString(R.string.install_app));
    }

    public void s(DownloadData downloadData) {
        w(l(downloadData));
    }

    public void setBackgroundSkin(@DrawableRes int i) {
        d.b.i0.s2.i0.a aVar = this.f20577e;
        if (aVar instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) aVar).setBackgroundSkin(i);
        }
    }

    public void setData(DownloadData downloadData) {
        if (downloadData == null) {
            return;
        }
        DownloadData downloadData2 = (DownloadData) downloadData.clone();
        this.f20580h = downloadData2;
        if (downloadData2 == null) {
            return;
        }
        setTag(downloadData2);
        v(downloadData);
    }

    public void setDefaultText(String str) {
        d.b.i0.s2.i0.a aVar;
        if (TextUtils.isEmpty(str) || (aVar = this.f20577e) == null) {
            return;
        }
        aVar.setButtonText(str);
    }

    public void setForegroundSkin(@DrawableRes int i) {
        d.b.i0.s2.i0.a aVar = this.f20577e;
        if (aVar instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) aVar).setForeground(i);
        }
    }

    public void setIsPbDownload(boolean z) {
        if (z) {
            this.f20578f.setVisibility(8);
            this.f20579g.setVisibility(0);
            this.f20577e = this.f20579g;
            return;
        }
        this.f20579g.setVisibility(8);
        this.f20578f.setVisibility(0);
        this.f20577e = this.f20578f;
    }

    public void setOnClickInterceptListener(b.a aVar) {
        this.i = aVar;
    }

    public void setStrokeWidth(@DimenRes int i) {
        d.b.i0.s2.i0.a aVar = this.f20577e;
        if (aVar instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) aVar).setStrokeWidth(i);
        }
    }

    public void setTextColor(int i) {
        this.f20577e.setButtonTextColor(i);
    }

    public void setTextColorInitSkin(@ColorRes int i) {
        d.b.i0.s2.i0.a aVar = this.f20577e;
        if (aVar instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) aVar).setTextColorInitSkin(i);
        }
    }

    public void setTextColorSkin(@ColorRes int i) {
        d.b.i0.s2.i0.a aVar = this.f20577e;
        if (aVar instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) aVar).setTextColorSkin(i);
        }
    }

    public void setTextNightColor(int i) {
        this.f20577e.setButtonTextNightColor(i);
    }

    public void setTextSize(int i) {
        this.f20577e.setButtonTextSize(i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
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
                this.f20577e.setButtonText(getResources().getString(R.string.go_on_download), l(downloadData));
                return;
            case 3:
                this.f20577e.setButtonText(getResources().getString(R.string.immediately_install), 0);
                return;
            case 4:
            default:
                return;
            case 5:
                w(l(downloadData));
                return;
            case 6:
                this.f20577e.setButtonText(getResources().getString(R.string.install_app));
                return;
            case 8:
                this.f20577e.setButtonText(getResources().getString(R.string.immediately_open), 0);
                return;
        }
    }

    public final void w(int i) {
        this.f20577e.setProgress(Math.max(0, i));
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
