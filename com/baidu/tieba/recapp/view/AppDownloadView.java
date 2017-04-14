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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.recapp.c.a;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class AppDownloadView extends LinearLayout {
    private TextView aaF;
    private CustomMessageListener downloadListener;
    private CustomMessageListener faM;
    private ProgressBar feb;
    private ImageView fec;
    private TextView fed;
    private DownloadData fee;

    public AppDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.faM = null;
        init(context);
    }

    public AppDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.faM = null;
        init(context);
    }

    public AppDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.faM = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(16);
        View inflate = LayoutInflater.from(context).inflate(w.j.app_download_layout, (ViewGroup) this, true);
        this.aaF = (TextView) inflate.findViewById(w.h.app_push_title);
        this.feb = (ProgressBar) inflate.findViewById(w.h.frs_app_push_progress);
        this.fec = (ImageView) inflate.findViewById(w.h.frs_app_push_control);
        this.fed = (TextView) inflate.findViewById(w.h.frs_app_push_percent);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.fee = (DownloadData) downloadData.clone();
            if (this.fee != null) {
                setTag(this.fee);
                r(downloadData);
            }
        }
    }

    public void refreshControlIcon(int i) {
        if (i == 1) {
            aq.c(this.fec, w.g.icon_download_pause);
        } else {
            aq.c(this.fec, w.g.icon_download_play);
        }
    }

    private void r(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    setVisibility(0);
                    aq.c(this.fec, w.g.icon_download_pause);
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
                    aq.c(this.fec, w.g.icon_download_play);
                    break;
            }
            int ak = a.aZT().ak(downloadData.getId(), downloadData.getName());
            if (ak >= 0) {
                qT(ak);
            } else {
                qT(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qT(int i) {
        int max = Math.max(0, i);
        this.feb.setProgress(max);
        this.fed.setText(String.valueOf(max) + "%");
    }

    public static int getStatus(DownloadData downloadData) {
        return a.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        baF();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        baE();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            baE();
        } else {
            baF();
        }
    }

    public void showTitleView(int i) {
        this.aaF.setVisibility(i);
    }

    public void onChangeSkinType(int i) {
        aq.b(this.aaF, w.e.cp_cont_c, 1, i);
        this.feb.setProgressDrawable(aq.x(i, w.g.progress_download_app_layerlist));
        aq.c(this.fec, w.g.icon_download_play, i);
        aq.b(this.fed, w.e.cp_cont_d, 1, i);
    }

    private void baE() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.faM != null) {
            MessageManager.getInstance().registerListener(this.faM);
        }
    }

    private void baF() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.faM != null) {
            MessageManager.getInstance().unRegisterListener(this.faM);
        }
    }

    public void enableDownloadListener() {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:16:0x0064, code lost:
                    if (r5.fef.fee.getId().equals(r1.getId()) != false) goto L17;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && AppDownloadView.this.fee != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(AppDownloadView.this.fee.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            AppDownloadView.this.qT(a.aZT().ak(downloadData.getId(), downloadData.getName()));
                            AppDownloadView.this.postInvalidate();
                        }
                    }
                }
            };
        }
        if (this.faM == null) {
            this.faM = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && AppDownloadView.this.fee != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (AppDownloadView.this.fee.getId() != null && downloadData != null && AppDownloadView.this.fee.getId().equals(downloadData.getId())) {
                            int status = a.getStatus(downloadData);
                            if (status == 7) {
                                aq.c(AppDownloadView.this.fec, w.g.icon_download_pause);
                            } else if (status == 1) {
                                aq.c(AppDownloadView.this.fec, w.g.icon_download_play);
                            }
                        }
                    }
                }
            };
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AppDownloadListener implements View.OnClickListener {
        protected AppDownloadView feg;

        public void setAppDownloadView(AppDownloadView appDownloadView) {
            this.feg = appDownloadView;
        }
    }
}
