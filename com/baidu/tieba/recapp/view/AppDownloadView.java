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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.c.a;
import java.util.List;
/* loaded from: classes.dex */
public class AppDownloadView extends LinearLayout {
    private TextView abZ;
    private CustomMessageListener downloadListener;
    private CustomMessageListener fHM;
    private ProgressBar fLa;
    private ImageView fLb;
    private TextView fLc;
    private DownloadData fLd;

    public AppDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.fHM = null;
        init(context);
    }

    public AppDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.fHM = null;
        init(context);
    }

    public AppDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.fHM = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(16);
        View inflate = LayoutInflater.from(context).inflate(d.j.app_download_layout, (ViewGroup) this, true);
        this.abZ = (TextView) inflate.findViewById(d.h.app_push_title);
        this.fLa = (ProgressBar) inflate.findViewById(d.h.frs_app_push_progress);
        this.fLb = (ImageView) inflate.findViewById(d.h.frs_app_push_control);
        this.fLc = (TextView) inflate.findViewById(d.h.frs_app_push_percent);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.fLd = (DownloadData) downloadData.clone();
            if (this.fLd != null) {
                setTag(this.fLd);
                u(downloadData);
            }
        }
    }

    public void refreshControlIcon(int i) {
        if (i == 1) {
            ai.c(this.fLb, d.g.icon_download_pause);
        } else {
            ai.c(this.fLb, d.g.icon_download_play);
        }
    }

    private void u(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    setVisibility(0);
                    ai.c(this.fLb, d.g.icon_download_pause);
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
                    ai.c(this.fLb, d.g.icon_download_play);
                    break;
            }
            int aj = a.bij().aj(downloadData.getId(), downloadData.getName());
            if (aj >= 0) {
                si(aj);
            } else {
                si(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void si(int i) {
        int max = Math.max(0, i);
        this.fLa.setProgress(max);
        this.fLc.setText(max + "%");
    }

    public static int getStatus(DownloadData downloadData) {
        return a.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        biV();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        biU();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            biU();
        } else {
            biV();
        }
    }

    public void showTitleView(int i) {
        this.abZ.setVisibility(i);
    }

    public void onChangeSkinType(int i) {
        ai.b(this.abZ, d.e.cp_cont_c, 1, i);
        this.fLa.setProgressDrawable(ai.v(i, d.g.progress_download_app_layerlist));
        ai.c(this.fLb, d.g.icon_download_play, i);
        ai.b(this.fLc, d.e.cp_cont_d, 1, i);
    }

    private void biU() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.fHM != null) {
            MessageManager.getInstance().registerListener(this.fHM);
        }
    }

    private void biV() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.fHM != null) {
            MessageManager.getInstance().unRegisterListener(this.fHM);
        }
    }

    public void enableDownloadListener() {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.fLe.fLd.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && AppDownloadView.this.fLd != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(AppDownloadView.this.fLd.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            AppDownloadView.this.si(a.bij().aj(downloadData.getId(), downloadData.getName()));
                            AppDownloadView.this.postInvalidate();
                        }
                    }
                }
            };
        }
        if (this.fHM == null) {
            this.fHM = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && AppDownloadView.this.fLd != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (AppDownloadView.this.fLd.getId() != null && downloadData != null && AppDownloadView.this.fLd.getId().equals(downloadData.getId())) {
                            int status = a.getStatus(downloadData);
                            if (status == 7) {
                                ai.c(AppDownloadView.this.fLb, d.g.icon_download_pause);
                            } else if (status == 1) {
                                ai.c(AppDownloadView.this.fLb, d.g.icon_download_play);
                            }
                        }
                    }
                }
            };
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AppDownloadListener implements View.OnClickListener {
        protected AppDownloadView fLf;

        public void setAppDownloadView(AppDownloadView appDownloadView) {
            this.fLf = appDownloadView;
        }
    }
}
