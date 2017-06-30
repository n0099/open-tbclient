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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.recapp.c.a;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class AppDownloadView extends LinearLayout {
    private TextView aab;
    private CustomMessageListener downloadListener;
    private CustomMessageListener frM;
    private ProgressBar fuI;
    private ImageView fuJ;
    private TextView fuK;
    private DownloadData fuL;

    public AppDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.frM = null;
        init(context);
    }

    public AppDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.frM = null;
        init(context);
    }

    public AppDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.frM = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(16);
        View inflate = LayoutInflater.from(context).inflate(w.j.app_download_layout, (ViewGroup) this, true);
        this.aab = (TextView) inflate.findViewById(w.h.app_push_title);
        this.fuI = (ProgressBar) inflate.findViewById(w.h.frs_app_push_progress);
        this.fuJ = (ImageView) inflate.findViewById(w.h.frs_app_push_control);
        this.fuK = (TextView) inflate.findViewById(w.h.frs_app_push_percent);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.fuL = (DownloadData) downloadData.clone();
            if (this.fuL != null) {
                setTag(this.fuL);
                r(downloadData);
            }
        }
    }

    public void refreshControlIcon(int i) {
        if (i == 1) {
            as.c(this.fuJ, w.g.icon_download_pause);
        } else {
            as.c(this.fuJ, w.g.icon_download_play);
        }
    }

    private void r(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    setVisibility(0);
                    as.c(this.fuJ, w.g.icon_download_pause);
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
                    as.c(this.fuJ, w.g.icon_download_play);
                    break;
            }
            int aj = a.bdX().aj(downloadData.getId(), downloadData.getName());
            if (aj >= 0) {
                rH(aj);
            } else {
                rH(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rH(int i) {
        int max = Math.max(0, i);
        this.fuI.setProgress(max);
        this.fuK.setText(String.valueOf(max) + "%");
    }

    public static int getStatus(DownloadData downloadData) {
        return a.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        beJ();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        beI();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            beI();
        } else {
            beJ();
        }
    }

    public void showTitleView(int i) {
        this.aab.setVisibility(i);
    }

    public void onChangeSkinType(int i) {
        as.b(this.aab, w.e.cp_cont_c, 1, i);
        this.fuI.setProgressDrawable(as.u(i, w.g.progress_download_app_layerlist));
        as.c(this.fuJ, w.g.icon_download_play, i);
        as.b(this.fuK, w.e.cp_cont_d, 1, i);
    }

    private void beI() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.frM != null) {
            MessageManager.getInstance().registerListener(this.frM);
        }
    }

    private void beJ() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.frM != null) {
            MessageManager.getInstance().unRegisterListener(this.frM);
        }
    }

    public void enableDownloadListener() {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:16:0x0064, code lost:
                    if (r5.fuM.fuL.getId().equals(r1.getId()) != false) goto L17;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && AppDownloadView.this.fuL != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(AppDownloadView.this.fuL.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            AppDownloadView.this.rH(a.bdX().aj(downloadData.getId(), downloadData.getName()));
                            AppDownloadView.this.postInvalidate();
                        }
                    }
                }
            };
        }
        if (this.frM == null) {
            this.frM = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && AppDownloadView.this.fuL != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (AppDownloadView.this.fuL.getId() != null && downloadData != null && AppDownloadView.this.fuL.getId().equals(downloadData.getId())) {
                            int status = a.getStatus(downloadData);
                            if (status == 7) {
                                as.c(AppDownloadView.this.fuJ, w.g.icon_download_pause);
                            } else if (status == 1) {
                                as.c(AppDownloadView.this.fuJ, w.g.icon_download_play);
                            }
                        }
                    }
                }
            };
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AppDownloadListener implements View.OnClickListener {
        protected AppDownloadView fuN;

        public void setAppDownloadView(AppDownloadView appDownloadView) {
            this.fuN = appDownloadView;
        }
    }
}
