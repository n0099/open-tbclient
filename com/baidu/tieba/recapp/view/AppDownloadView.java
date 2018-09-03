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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.download.d;
import java.util.List;
/* loaded from: classes.dex */
public class AppDownloadView extends LinearLayout {
    private CustomMessageListener downloadListener;
    private CustomMessageListener gqt;
    private ProgressBar gvd;
    private ImageView gve;
    private TextView gvf;
    private DownloadData gvg;
    private TextView mTitleView;

    public AppDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.gqt = null;
        init(context);
    }

    public AppDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.gqt = null;
        init(context);
    }

    public AppDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.gqt = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(16);
        View inflate = LayoutInflater.from(context).inflate(f.h.app_download_layout, (ViewGroup) this, true);
        this.mTitleView = (TextView) inflate.findViewById(f.g.app_push_title);
        this.gvd = (ProgressBar) inflate.findViewById(f.g.frs_app_push_progress);
        this.gve = (ImageView) inflate.findViewById(f.g.frs_app_push_control);
        this.gvf = (TextView) inflate.findViewById(f.g.frs_app_push_percent);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.gvg = (DownloadData) downloadData.clone();
            if (this.gvg != null) {
                setTag(this.gvg);
                o(downloadData);
            }
        }
    }

    public void refreshControlIcon(int i) {
        if (i == 1) {
            am.c(this.gve, f.C0146f.icon_download_pause);
        } else {
            am.c(this.gve, f.C0146f.icon_download_play);
        }
    }

    private void o(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    setVisibility(0);
                    am.c(this.gve, f.C0146f.icon_download_pause);
                    break;
                case 3:
                    setVisibility(8);
                    break;
                case 5:
                    setVisibility(0);
                    break;
                case 6:
                    setVisibility(8);
                    break;
                case 7:
                    setVisibility(0);
                    am.c(this.gve, f.C0146f.icon_download_play);
                    break;
            }
            int an = d.bnv().an(downloadData.getId(), downloadData.getName());
            if (an >= 0) {
                ss(an);
            } else {
                ss(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ss(int i) {
        int max = Math.max(0, i);
        this.gvd.setProgress(max);
        this.gvf.setText(max + "%");
    }

    public static int getStatus(DownloadData downloadData) {
        return d.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bos();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bor();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            bor();
        } else {
            bos();
        }
    }

    public void showTitleView(int i) {
        this.mTitleView.setVisibility(i);
    }

    public void onChangeSkinType(int i) {
        am.b(this.mTitleView, f.d.cp_cont_c, 1, i);
        this.gvd.setProgressDrawable(am.v(i, f.C0146f.progress_download_app_layerlist));
        am.b(this.gve, f.C0146f.icon_download_play, i);
        am.b(this.gvf, f.d.cp_cont_d, 1, i);
    }

    private void bor() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.gqt != null) {
            MessageManager.getInstance().registerListener(this.gqt);
        }
    }

    private void bos() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.gqt != null) {
            MessageManager.getInstance().unRegisterListener(this.gqt);
        }
    }

    public void enableDownloadListener() {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.gvh.gvg.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && AppDownloadView.this.gvg != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(AppDownloadView.this.gvg.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            AppDownloadView.this.ss(d.bnv().an(downloadData.getId(), downloadData.getName()));
                            AppDownloadView.this.postInvalidate();
                        }
                    }
                }
            };
        }
        if (this.gqt == null) {
            this.gqt = new CustomMessageListener(2016484) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && AppDownloadView.this.gvg != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (AppDownloadView.this.gvg.getId() != null && downloadData != null && AppDownloadView.this.gvg.getId().equals(downloadData.getId())) {
                            int status = d.getStatus(downloadData);
                            if (status == 7) {
                                am.c(AppDownloadView.this.gve, f.C0146f.icon_download_pause);
                            } else if (status == 1) {
                                am.c(AppDownloadView.this.gve, f.C0146f.icon_download_play);
                            }
                        }
                    }
                }
            };
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AppDownloadListener implements View.OnClickListener {
        protected AppDownloadView gvi;

        public void setAppDownloadView(AppDownloadView appDownloadView) {
            this.gvi = appDownloadView;
        }
    }
}
