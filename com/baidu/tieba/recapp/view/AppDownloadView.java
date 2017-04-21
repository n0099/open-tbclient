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
    private TextView aaG;
    private CustomMessageListener downloadListener;
    private CustomMessageListener fdd;
    private ProgressBar fgs;
    private ImageView fgt;
    private TextView fgu;
    private DownloadData fgv;

    public AppDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.fdd = null;
        init(context);
    }

    public AppDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.fdd = null;
        init(context);
    }

    public AppDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.fdd = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(16);
        View inflate = LayoutInflater.from(context).inflate(w.j.app_download_layout, (ViewGroup) this, true);
        this.aaG = (TextView) inflate.findViewById(w.h.app_push_title);
        this.fgs = (ProgressBar) inflate.findViewById(w.h.frs_app_push_progress);
        this.fgt = (ImageView) inflate.findViewById(w.h.frs_app_push_control);
        this.fgu = (TextView) inflate.findViewById(w.h.frs_app_push_percent);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.fgv = (DownloadData) downloadData.clone();
            if (this.fgv != null) {
                setTag(this.fgv);
                r(downloadData);
            }
        }
    }

    public void refreshControlIcon(int i) {
        if (i == 1) {
            aq.c(this.fgt, w.g.icon_download_pause);
        } else {
            aq.c(this.fgt, w.g.icon_download_play);
        }
    }

    private void r(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    setVisibility(0);
                    aq.c(this.fgt, w.g.icon_download_pause);
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
                    aq.c(this.fgt, w.g.icon_download_play);
                    break;
            }
            int ak = a.baU().ak(downloadData.getId(), downloadData.getName());
            if (ak >= 0) {
                qZ(ak);
            } else {
                qZ(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qZ(int i) {
        int max = Math.max(0, i);
        this.fgs.setProgress(max);
        this.fgu.setText(String.valueOf(max) + "%");
    }

    public static int getStatus(DownloadData downloadData) {
        return a.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bbG();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bbF();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            bbF();
        } else {
            bbG();
        }
    }

    public void showTitleView(int i) {
        this.aaG.setVisibility(i);
    }

    public void onChangeSkinType(int i) {
        aq.b(this.aaG, w.e.cp_cont_c, 1, i);
        this.fgs.setProgressDrawable(aq.x(i, w.g.progress_download_app_layerlist));
        aq.c(this.fgt, w.g.icon_download_play, i);
        aq.b(this.fgu, w.e.cp_cont_d, 1, i);
    }

    private void bbF() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.fdd != null) {
            MessageManager.getInstance().registerListener(this.fdd);
        }
    }

    private void bbG() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.fdd != null) {
            MessageManager.getInstance().unRegisterListener(this.fdd);
        }
    }

    public void enableDownloadListener() {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:16:0x0064, code lost:
                    if (r5.fgw.fgv.getId().equals(r1.getId()) != false) goto L17;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && AppDownloadView.this.fgv != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(AppDownloadView.this.fgv.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            AppDownloadView.this.qZ(a.baU().ak(downloadData.getId(), downloadData.getName()));
                            AppDownloadView.this.postInvalidate();
                        }
                    }
                }
            };
        }
        if (this.fdd == null) {
            this.fdd = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && AppDownloadView.this.fgv != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (AppDownloadView.this.fgv.getId() != null && downloadData != null && AppDownloadView.this.fgv.getId().equals(downloadData.getId())) {
                            int status = a.getStatus(downloadData);
                            if (status == 7) {
                                aq.c(AppDownloadView.this.fgt, w.g.icon_download_pause);
                            } else if (status == 1) {
                                aq.c(AppDownloadView.this.fgt, w.g.icon_download_play);
                            }
                        }
                    }
                }
            };
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AppDownloadListener implements View.OnClickListener {
        protected AppDownloadView fgx;

        public void setAppDownloadView(AppDownloadView appDownloadView) {
            this.fgx = appDownloadView;
        }
    }
}
