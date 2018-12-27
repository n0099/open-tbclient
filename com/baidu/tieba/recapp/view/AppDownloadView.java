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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.download.d;
import java.util.List;
/* loaded from: classes.dex */
public class AppDownloadView extends LinearLayout {
    private CustomMessageListener downloadListener;
    private CustomMessageListener gQv;
    private ProgressBar gVe;
    private ImageView gVf;
    private TextView gVg;
    private DownloadData gVh;
    private TextView mTitleView;

    public AppDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.gQv = null;
        init(context);
    }

    public AppDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.gQv = null;
        init(context);
    }

    public AppDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.gQv = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(16);
        View inflate = LayoutInflater.from(context).inflate(e.h.app_download_layout, (ViewGroup) this, true);
        this.mTitleView = (TextView) inflate.findViewById(e.g.app_push_title);
        this.gVe = (ProgressBar) inflate.findViewById(e.g.frs_app_push_progress);
        this.gVf = (ImageView) inflate.findViewById(e.g.frs_app_push_control);
        this.gVg = (TextView) inflate.findViewById(e.g.frs_app_push_percent);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.gVh = (DownloadData) downloadData.clone();
            if (this.gVh != null) {
                setTag(this.gVh);
                o(downloadData);
            }
        }
    }

    public void refreshControlIcon(int i) {
        if (i == 1) {
            al.c(this.gVf, e.f.icon_download_pause);
        } else {
            al.c(this.gVf, e.f.icon_download_play);
        }
    }

    private void o(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    setVisibility(0);
                    al.c(this.gVf, e.f.icon_download_pause);
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
                    al.c(this.gVf, e.f.icon_download_play);
                    break;
            }
            int aJ = d.bvr().aJ(downloadData.getId(), downloadData.getName());
            if (aJ >= 0) {
                un(aJ);
            } else {
                un(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void un(int i) {
        int max = Math.max(0, i);
        this.gVe.setProgress(max);
        this.gVg.setText(max + "%");
    }

    public static int getStatus(DownloadData downloadData) {
        return d.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bwq();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bwp();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            bwp();
        } else {
            bwq();
        }
    }

    public void showTitleView(int i) {
        this.mTitleView.setVisibility(i);
    }

    public void onChangeSkinType(int i) {
        al.b(this.mTitleView, e.d.cp_cont_c, 1, i);
        this.gVe.setProgressDrawable(al.y(i, e.f.progress_download_app_layerlist));
        al.b(this.gVf, e.f.icon_download_play, i);
        al.b(this.gVg, e.d.cp_cont_d, 1, i);
    }

    private void bwp() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.gQv != null) {
            MessageManager.getInstance().registerListener(this.gQv);
        }
    }

    private void bwq() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.gQv != null) {
            MessageManager.getInstance().unRegisterListener(this.gQv);
        }
    }

    public void enableDownloadListener() {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.gVi.gVh.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && AppDownloadView.this.gVh != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(AppDownloadView.this.gVh.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            AppDownloadView.this.un(d.bvr().aJ(downloadData.getId(), downloadData.getName()));
                            AppDownloadView.this.postInvalidate();
                        }
                    }
                }
            };
        }
        if (this.gQv == null) {
            this.gQv = new CustomMessageListener(2016484) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && AppDownloadView.this.gVh != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (AppDownloadView.this.gVh.getId() != null && downloadData != null && AppDownloadView.this.gVh.getId().equals(downloadData.getId())) {
                            int status = d.getStatus(downloadData);
                            if (status == 7) {
                                al.c(AppDownloadView.this.gVf, e.f.icon_download_pause);
                            } else if (status == 1) {
                                al.c(AppDownloadView.this.gVf, e.f.icon_download_play);
                            }
                        }
                    }
                }
            };
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AppDownloadListener implements View.OnClickListener {
        protected AppDownloadView gVj;

        public void setAppDownloadView(AppDownloadView appDownloadView) {
            this.gVj = appDownloadView;
        }
    }
}
