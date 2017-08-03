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
    private TextView aaA;
    private CustomMessageListener downloadListener;
    private CustomMessageListener fEF;
    private ProgressBar fHS;
    private ImageView fHT;
    private TextView fHU;
    private DownloadData fHV;

    public AppDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.fEF = null;
        init(context);
    }

    public AppDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.fEF = null;
        init(context);
    }

    public AppDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.fEF = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(16);
        View inflate = LayoutInflater.from(context).inflate(d.j.app_download_layout, (ViewGroup) this, true);
        this.aaA = (TextView) inflate.findViewById(d.h.app_push_title);
        this.fHS = (ProgressBar) inflate.findViewById(d.h.frs_app_push_progress);
        this.fHT = (ImageView) inflate.findViewById(d.h.frs_app_push_control);
        this.fHU = (TextView) inflate.findViewById(d.h.frs_app_push_percent);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.fHV = (DownloadData) downloadData.clone();
            if (this.fHV != null) {
                setTag(this.fHV);
                r(downloadData);
            }
        }
    }

    public void refreshControlIcon(int i) {
        if (i == 1) {
            ai.c(this.fHT, d.g.icon_download_pause);
        } else {
            ai.c(this.fHT, d.g.icon_download_play);
        }
    }

    private void r(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    setVisibility(0);
                    ai.c(this.fHT, d.g.icon_download_pause);
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
                    ai.c(this.fHT, d.g.icon_download_play);
                    break;
            }
            int aj = a.bhy().aj(downloadData.getId(), downloadData.getName());
            if (aj >= 0) {
                rY(aj);
            } else {
                rY(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rY(int i) {
        int max = Math.max(0, i);
        this.fHS.setProgress(max);
        this.fHU.setText(max + "%");
    }

    public static int getStatus(DownloadData downloadData) {
        return a.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bik();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bij();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            bij();
        } else {
            bik();
        }
    }

    public void showTitleView(int i) {
        this.aaA.setVisibility(i);
    }

    public void onChangeSkinType(int i) {
        ai.b(this.aaA, d.e.cp_cont_c, 1, i);
        this.fHS.setProgressDrawable(ai.u(i, d.g.progress_download_app_layerlist));
        ai.c(this.fHT, d.g.icon_download_play, i);
        ai.b(this.fHU, d.e.cp_cont_d, 1, i);
    }

    private void bij() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.fEF != null) {
            MessageManager.getInstance().registerListener(this.fEF);
        }
    }

    private void bik() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.fEF != null) {
            MessageManager.getInstance().unRegisterListener(this.fEF);
        }
    }

    public void enableDownloadListener() {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.fHW.fHV.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && AppDownloadView.this.fHV != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(AppDownloadView.this.fHV.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            AppDownloadView.this.rY(a.bhy().aj(downloadData.getId(), downloadData.getName()));
                            AppDownloadView.this.postInvalidate();
                        }
                    }
                }
            };
        }
        if (this.fEF == null) {
            this.fEF = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && AppDownloadView.this.fHV != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (AppDownloadView.this.fHV.getId() != null && downloadData != null && AppDownloadView.this.fHV.getId().equals(downloadData.getId())) {
                            int status = a.getStatus(downloadData);
                            if (status == 7) {
                                ai.c(AppDownloadView.this.fHT, d.g.icon_download_pause);
                            } else if (status == 1) {
                                ai.c(AppDownloadView.this.fHT, d.g.icon_download_play);
                            }
                        }
                    }
                }
            };
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AppDownloadListener implements View.OnClickListener {
        protected AppDownloadView fHX;

        public void setAppDownloadView(AppDownloadView appDownloadView) {
            this.fHX = appDownloadView;
        }
    }
}
