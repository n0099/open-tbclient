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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.r;
import com.baidu.tieba.recapp.b.a;
import java.util.List;
/* loaded from: classes.dex */
public class AppDownloadView extends LinearLayout {
    private TextView VO;
    private CustomMessageListener aRI;
    private CustomMessageListener downloadListener;
    private ProgressBar eOR;
    private ImageView eOS;
    private TextView eOT;
    private DownloadData eOU;

    public AppDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.aRI = null;
        init(context);
    }

    public AppDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.aRI = null;
        init(context);
    }

    public AppDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.aRI = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(16);
        View inflate = LayoutInflater.from(context).inflate(r.h.app_download_layout, (ViewGroup) this, true);
        this.VO = (TextView) inflate.findViewById(r.g.app_push_title);
        this.eOR = (ProgressBar) inflate.findViewById(r.g.frs_app_push_progress);
        this.eOS = (ImageView) inflate.findViewById(r.g.frs_app_push_control);
        this.eOT = (TextView) inflate.findViewById(r.g.frs_app_push_percent);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.eOU = (DownloadData) downloadData.clone();
            if (this.eOU != null) {
                setTag(this.eOU);
                v(downloadData);
            }
        }
    }

    public void refreshControlIcon(int i) {
        if (i == 1) {
            ar.c(this.eOS, r.f.icon_download_pause);
        } else {
            ar.c(this.eOS, r.f.icon_download_play);
        }
    }

    private void v(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    setVisibility(0);
                    ar.c(this.eOS, r.f.icon_download_pause);
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
                    ar.c(this.eOS, r.f.icon_download_play);
                    break;
            }
            int al = a.aYh().al(downloadData.getId(), downloadData.getName());
            if (al >= 0) {
                qo(al);
            } else {
                qo(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qo(int i) {
        int max = Math.max(0, i);
        this.eOR.setProgress(max);
        this.eOT.setText(String.valueOf(max) + "%");
    }

    public static int getStatus(DownloadData downloadData) {
        return a.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aYy();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aYx();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            aYx();
        } else {
            aYy();
        }
    }

    public void showTitleView(int i) {
        this.VO.setVisibility(i);
    }

    public void onChangeSkinType(int i) {
        ar.b(this.VO, r.d.cp_cont_c, 1, i);
        this.eOR.setProgressDrawable(ar.q(i, r.f.progress_download_app_layerlist));
        ar.c(this.eOS, r.f.icon_download_play, i);
        ar.b(this.eOT, r.d.cp_cont_d, 1, i);
    }

    private void aYx() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.aRI != null) {
            MessageManager.getInstance().registerListener(this.aRI);
        }
    }

    private void aYy() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.aRI != null) {
            MessageManager.getInstance().unRegisterListener(this.aRI);
        }
    }

    public void enableDownloadListener() {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:16:0x0064, code lost:
                    if (r5.eOV.eOU.getId().equals(r1.getId()) != false) goto L17;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && AppDownloadView.this.eOU != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(AppDownloadView.this.eOU.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            AppDownloadView.this.qo(a.aYh().al(downloadData.getId(), downloadData.getName()));
                            AppDownloadView.this.postInvalidate();
                        }
                    }
                }
            };
        }
        if (this.aRI == null) {
            this.aRI = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && AppDownloadView.this.eOU != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (AppDownloadView.this.eOU.getId() != null && downloadData != null && AppDownloadView.this.eOU.getId().equals(downloadData.getId())) {
                            int status = a.getStatus(downloadData);
                            if (status == 7) {
                                ar.c(AppDownloadView.this.eOS, r.f.icon_download_pause);
                            } else if (status == 1) {
                                ar.c(AppDownloadView.this.eOS, r.f.icon_download_play);
                            }
                        }
                    }
                }
            };
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AppDownloadListener implements View.OnClickListener {
        protected AppDownloadView aQR;

        public void setAppDownloadView(AppDownloadView appDownloadView) {
            this.aQR = appDownloadView;
        }
    }
}
