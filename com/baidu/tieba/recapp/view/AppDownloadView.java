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
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class AppDownloadView extends LinearLayout {
    private CustomMessageListener downloadListener;
    private CustomMessageListener gqq;
    private ProgressBar gva;
    private ImageView gvb;
    private TextView gvc;
    private DownloadData gvd;
    private TextView mTitleView;

    public AppDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.gqq = null;
        init(context);
    }

    public AppDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.gqq = null;
        init(context);
    }

    public AppDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.gqq = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(16);
        View inflate = LayoutInflater.from(context).inflate(d.h.app_download_layout, (ViewGroup) this, true);
        this.mTitleView = (TextView) inflate.findViewById(d.g.app_push_title);
        this.gva = (ProgressBar) inflate.findViewById(d.g.frs_app_push_progress);
        this.gvb = (ImageView) inflate.findViewById(d.g.frs_app_push_control);
        this.gvc = (TextView) inflate.findViewById(d.g.frs_app_push_percent);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.gvd = (DownloadData) downloadData.clone();
            if (this.gvd != null) {
                setTag(this.gvd);
                o(downloadData);
            }
        }
    }

    public void refreshControlIcon(int i) {
        if (i == 1) {
            am.c(this.gvb, d.f.icon_download_pause);
        } else {
            am.c(this.gvb, d.f.icon_download_play);
        }
    }

    private void o(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    setVisibility(0);
                    am.c(this.gvb, d.f.icon_download_pause);
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
                    am.c(this.gvb, d.f.icon_download_play);
                    break;
            }
            int ao = com.baidu.tieba.recapp.download.d.bnu().ao(downloadData.getId(), downloadData.getName());
            if (ao >= 0) {
                ss(ao);
            } else {
                ss(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ss(int i) {
        int max = Math.max(0, i);
        this.gva.setProgress(max);
        this.gvc.setText(max + "%");
    }

    public static int getStatus(DownloadData downloadData) {
        return com.baidu.tieba.recapp.download.d.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bor();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        boq();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            boq();
        } else {
            bor();
        }
    }

    public void showTitleView(int i) {
        this.mTitleView.setVisibility(i);
    }

    public void onChangeSkinType(int i) {
        am.b(this.mTitleView, d.C0140d.cp_cont_c, 1, i);
        this.gva.setProgressDrawable(am.v(i, d.f.progress_download_app_layerlist));
        am.b(this.gvb, d.f.icon_download_play, i);
        am.b(this.gvc, d.C0140d.cp_cont_d, 1, i);
    }

    private void boq() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.gqq != null) {
            MessageManager.getInstance().registerListener(this.gqq);
        }
    }

    private void bor() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.gqq != null) {
            MessageManager.getInstance().unRegisterListener(this.gqq);
        }
    }

    public void enableDownloadListener() {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.gve.gvd.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && AppDownloadView.this.gvd != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(AppDownloadView.this.gvd.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            AppDownloadView.this.ss(com.baidu.tieba.recapp.download.d.bnu().ao(downloadData.getId(), downloadData.getName()));
                            AppDownloadView.this.postInvalidate();
                        }
                    }
                }
            };
        }
        if (this.gqq == null) {
            this.gqq = new CustomMessageListener(2016484) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && AppDownloadView.this.gvd != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (AppDownloadView.this.gvd.getId() != null && downloadData != null && AppDownloadView.this.gvd.getId().equals(downloadData.getId())) {
                            int status = com.baidu.tieba.recapp.download.d.getStatus(downloadData);
                            if (status == 7) {
                                am.c(AppDownloadView.this.gvb, d.f.icon_download_pause);
                            } else if (status == 1) {
                                am.c(AppDownloadView.this.gvb, d.f.icon_download_play);
                            }
                        }
                    }
                }
            };
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AppDownloadListener implements View.OnClickListener {
        protected AppDownloadView gvf;

        public void setAppDownloadView(AppDownloadView appDownloadView) {
            this.gvf = appDownloadView;
        }
    }
}
