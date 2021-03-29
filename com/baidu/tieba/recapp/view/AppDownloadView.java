package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import d.b.i0.r2.x.e;
import java.util.List;
/* loaded from: classes5.dex */
public class AppDownloadView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f20859e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f20860f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f20861g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20862h;
    public DownloadData i;
    public CustomMessageListener j;
    public CustomMessageListener k;

    /* loaded from: classes5.dex */
    public static abstract class AppDownloadListener implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public AppDownloadView f20865e;

        public void setAppDownloadView(AppDownloadView appDownloadView) {
            this.f20865e = appDownloadView;
        }
    }

    public AppDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.j = null;
        this.k = null;
        d(context);
    }

    public static int getStatus(DownloadData downloadData) {
        return e.p(downloadData);
    }

    public final void d(Context context) {
        setOrientation(0);
        setGravity(16);
        View inflate = LayoutInflater.from(context).inflate(R.layout.app_download_layout, (ViewGroup) this, true);
        this.f20859e = (TextView) inflate.findViewById(R.id.app_push_title);
        this.f20860f = (ProgressBar) inflate.findViewById(R.id.frs_app_push_progress);
        this.f20861g = (ImageView) inflate.findViewById(R.id.frs_app_push_control);
        this.f20862h = (TextView) inflate.findViewById(R.id.frs_app_push_percent);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void e(DownloadData downloadData) {
        if (downloadData == null) {
            return;
        }
        int status = downloadData.getStatus();
        if (status == 1) {
            setVisibility(0);
            SkinManager.setImageResource(this.f20861g, R.drawable.icon_download_pause);
        } else if (status == 3) {
            setVisibility(8);
        } else if (status == 5) {
            setVisibility(0);
        } else if (status == 6) {
            setVisibility(8);
        } else if (status == 7) {
            setVisibility(0);
            SkinManager.setImageResource(this.f20861g, R.drawable.icon_download_play);
        }
        int j = e.n().j(downloadData.getId(), downloadData.getName());
        if (j >= 0) {
            h(j);
        } else {
            h(0);
        }
    }

    public void enableDownloadListener() {
        if (this.j == null) {
            this.j = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if ((customResponsedMessage instanceof DownloadMessage) && AppDownloadView.this.i != null) {
                        DownloadData downloadData = null;
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            if (i >= data.size()) {
                                break;
                            }
                            DownloadData downloadData2 = data.get(i);
                            if (TextUtils.isEmpty(AppDownloadView.this.i.getId())) {
                                i++;
                            } else if (AppDownloadView.this.i.getId().equals(downloadData2.getId())) {
                                downloadData = downloadData2;
                            }
                        }
                        if (downloadData != null) {
                            AppDownloadView.this.h(e.n().j(downloadData.getId(), downloadData.getName()));
                            AppDownloadView.this.postInvalidate();
                        }
                    }
                }
            };
        }
        if (this.k == null) {
            this.k = new CustomMessageListener(2016484) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage == null || AppDownloadView.this.i == null) {
                        return;
                    }
                    DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                    if (AppDownloadView.this.i.getId() == null || downloadData == null || !AppDownloadView.this.i.getId().equals(downloadData.getId())) {
                        return;
                    }
                    int p = e.p(downloadData);
                    if (p == 7) {
                        SkinManager.setImageResource(AppDownloadView.this.f20861g, R.drawable.icon_download_pause);
                    } else if (p == 1) {
                        SkinManager.setImageResource(AppDownloadView.this.f20861g, R.drawable.icon_download_play);
                    }
                }
            };
        }
    }

    public final void f() {
        if (this.j != null) {
            MessageManager.getInstance().registerListener(this.j);
        }
        if (this.k != null) {
            MessageManager.getInstance().registerListener(this.k);
        }
    }

    public final void g() {
        if (this.j != null) {
            MessageManager.getInstance().unRegisterListener(this.j);
        }
        if (this.k != null) {
            MessageManager.getInstance().unRegisterListener(this.k);
        }
    }

    public final void h(int i) {
        int max = Math.max(0, i);
        this.f20860f.setProgress(max);
        TextView textView = this.f20862h;
        textView.setText(max + "%");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f();
    }

    public void onChangeSkinType(int i) {
        SkinManager.setViewTextColor(this.f20859e, R.color.CAM_X0108, 1, i);
        this.f20860f.setProgressDrawable(SkinManager.getDrawable(i, R.drawable.progress_download_app_layerlist));
        SkinManager.setImageResource(this.f20861g, R.drawable.icon_download_play, i);
        SkinManager.setViewTextColor(this.f20862h, R.color.CAM_X0109, 1, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
    }

    public void refreshControlIcon(int i) {
        if (i == 1) {
            SkinManager.setImageResource(this.f20861g, R.drawable.icon_download_pause);
        } else {
            SkinManager.setImageResource(this.f20861g, R.drawable.icon_download_play);
        }
    }

    public void setData(DownloadData downloadData) {
        if (downloadData == null) {
            return;
        }
        DownloadData downloadData2 = (DownloadData) downloadData.clone();
        this.i = downloadData2;
        if (downloadData2 == null) {
            return;
        }
        setTag(downloadData2);
        e(downloadData);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            f();
        } else {
            g();
        }
    }

    public void showTitleView(int i) {
        this.f20859e.setVisibility(i);
    }

    public AppDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = null;
        this.k = null;
        d(context);
    }

    public AppDownloadView(Context context) {
        super(context);
        this.j = null;
        this.k = null;
        d(context);
    }
}
