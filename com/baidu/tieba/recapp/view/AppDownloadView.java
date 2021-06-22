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
import d.a.o0.t2.c0.e;
import java.util.List;
/* loaded from: classes5.dex */
public class AppDownloadView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f20424e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f20425f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f20426g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20427h;

    /* renamed from: i  reason: collision with root package name */
    public DownloadData f20428i;
    public CustomMessageListener j;
    public CustomMessageListener k;

    /* loaded from: classes5.dex */
    public static abstract class AppDownloadListener implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public AppDownloadView f20431e;

        public void setAppDownloadView(AppDownloadView appDownloadView) {
            this.f20431e = appDownloadView;
        }
    }

    public AppDownloadView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f20424e = (TextView) inflate.findViewById(R.id.app_push_title);
        this.f20425f = (ProgressBar) inflate.findViewById(R.id.frs_app_push_progress);
        this.f20426g = (ImageView) inflate.findViewById(R.id.frs_app_push_control);
        this.f20427h = (TextView) inflate.findViewById(R.id.frs_app_push_percent);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void e(DownloadData downloadData) {
        if (downloadData == null) {
            return;
        }
        int status = downloadData.getStatus();
        if (status == 1) {
            setVisibility(0);
            SkinManager.setImageResource(this.f20426g, R.drawable.icon_download_pause);
        } else if (status == 3) {
            setVisibility(8);
        } else if (status == 5) {
            setVisibility(0);
        } else if (status == 6) {
            setVisibility(8);
        } else if (status == 7) {
            setVisibility(0);
            SkinManager.setImageResource(this.f20426g, R.drawable.icon_download_play);
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
                    if ((customResponsedMessage instanceof DownloadMessage) && AppDownloadView.this.f20428i != null) {
                        DownloadData downloadData = null;
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= data.size()) {
                                break;
                            }
                            DownloadData downloadData2 = data.get(i2);
                            if (TextUtils.isEmpty(AppDownloadView.this.f20428i.getId())) {
                                i2++;
                            } else if (AppDownloadView.this.f20428i.getId().equals(downloadData2.getId())) {
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
                    if (customResponsedMessage == null || AppDownloadView.this.f20428i == null) {
                        return;
                    }
                    DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                    if (AppDownloadView.this.f20428i.getId() == null || downloadData == null || !AppDownloadView.this.f20428i.getId().equals(downloadData.getId())) {
                        return;
                    }
                    int p = e.p(downloadData);
                    if (p == 7) {
                        SkinManager.setImageResource(AppDownloadView.this.f20426g, R.drawable.icon_download_pause);
                    } else if (p == 1) {
                        SkinManager.setImageResource(AppDownloadView.this.f20426g, R.drawable.icon_download_play);
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

    public final void h(int i2) {
        int max = Math.max(0, i2);
        this.f20425f.setProgress(max);
        TextView textView = this.f20427h;
        textView.setText(max + "%");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f();
    }

    public void onChangeSkinType(int i2) {
        SkinManager.setViewTextColor(this.f20424e, R.color.CAM_X0108, 1, i2);
        this.f20425f.setProgressDrawable(SkinManager.getDrawable(i2, R.drawable.progress_download_app_layerlist));
        SkinManager.setImageResource(this.f20426g, R.drawable.icon_download_play, i2);
        SkinManager.setViewTextColor(this.f20427h, R.color.CAM_X0109, 1, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
    }

    public void refreshControlIcon(int i2) {
        if (i2 == 1) {
            SkinManager.setImageResource(this.f20426g, R.drawable.icon_download_pause);
        } else {
            SkinManager.setImageResource(this.f20426g, R.drawable.icon_download_play);
        }
    }

    public void setData(DownloadData downloadData) {
        if (downloadData == null) {
            return;
        }
        DownloadData downloadData2 = (DownloadData) downloadData.clone();
        this.f20428i = downloadData2;
        if (downloadData2 == null) {
            return;
        }
        setTag(downloadData2);
        e(downloadData);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 == 0) {
            f();
        } else {
            g();
        }
    }

    public void showTitleView(int i2) {
        this.f20424e.setVisibility(i2);
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
