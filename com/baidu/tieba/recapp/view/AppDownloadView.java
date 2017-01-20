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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.r;
import com.baidu.tieba.recapp.b.a;
import java.util.List;
/* loaded from: classes.dex */
public class AppDownloadView extends LinearLayout {
    private TextView Ve;
    private CustomMessageListener downloadListener;
    private CustomMessageListener dua;
    private ProgressBar eYt;
    private ImageView eYu;
    private TextView eYv;
    private DownloadData eYw;

    public AppDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.dua = null;
        init(context);
    }

    public AppDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.dua = null;
        init(context);
    }

    public AppDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.dua = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(16);
        View inflate = LayoutInflater.from(context).inflate(r.j.app_download_layout, (ViewGroup) this, true);
        this.Ve = (TextView) inflate.findViewById(r.h.app_push_title);
        this.eYt = (ProgressBar) inflate.findViewById(r.h.frs_app_push_progress);
        this.eYu = (ImageView) inflate.findViewById(r.h.frs_app_push_control);
        this.eYv = (TextView) inflate.findViewById(r.h.frs_app_push_percent);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.eYw = (DownloadData) downloadData.clone();
            if (this.eYw != null) {
                setTag(this.eYw);
                r(downloadData);
            }
        }
    }

    public void refreshControlIcon(int i) {
        if (i == 1) {
            ap.c(this.eYu, r.g.icon_download_pause);
        } else {
            ap.c(this.eYu, r.g.icon_download_play);
        }
    }

    private void r(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    setVisibility(0);
                    ap.c(this.eYu, r.g.icon_download_pause);
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
                    ap.c(this.eYu, r.g.icon_download_play);
                    break;
            }
            int al = a.aZX().al(downloadData.getId(), downloadData.getName());
            if (al >= 0) {
                qY(al);
            } else {
                qY(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qY(int i) {
        int max = Math.max(0, i);
        this.eYt.setProgress(max);
        this.eYv.setText(String.valueOf(max) + "%");
    }

    public static int getStatus(DownloadData downloadData) {
        return a.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bao();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ban();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            ban();
        } else {
            bao();
        }
    }

    public void showTitleView(int i) {
        this.Ve.setVisibility(i);
    }

    public void onChangeSkinType(int i) {
        ap.b(this.Ve, r.e.cp_cont_c, 1, i);
        this.eYt.setProgressDrawable(ap.r(i, r.g.progress_download_app_layerlist));
        ap.c(this.eYu, r.g.icon_download_play, i);
        ap.b(this.eYv, r.e.cp_cont_d, 1, i);
    }

    private void ban() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.dua != null) {
            MessageManager.getInstance().registerListener(this.dua);
        }
    }

    private void bao() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.dua != null) {
            MessageManager.getInstance().unRegisterListener(this.dua);
        }
    }

    public void enableDownloadListener() {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:16:0x0064, code lost:
                    if (r5.eYx.eYw.getId().equals(r1.getId()) != false) goto L17;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && AppDownloadView.this.eYw != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(AppDownloadView.this.eYw.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            AppDownloadView.this.qY(a.aZX().al(downloadData.getId(), downloadData.getName()));
                            AppDownloadView.this.postInvalidate();
                        }
                    }
                }
            };
        }
        if (this.dua == null) {
            this.dua = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && AppDownloadView.this.eYw != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (AppDownloadView.this.eYw.getId() != null && downloadData != null && AppDownloadView.this.eYw.getId().equals(downloadData.getId())) {
                            int status = a.getStatus(downloadData);
                            if (status == 7) {
                                ap.c(AppDownloadView.this.eYu, r.g.icon_download_pause);
                            } else if (status == 1) {
                                ap.c(AppDownloadView.this.eYu, r.g.icon_download_play);
                            }
                        }
                    }
                }
            };
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AppDownloadListener implements View.OnClickListener {
        protected AppDownloadView eYy;

        public void setAppDownloadView(AppDownloadView appDownloadView) {
            this.eYy = appDownloadView;
        }
    }
}
