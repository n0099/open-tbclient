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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.c.a;
import java.util.List;
/* loaded from: classes.dex */
public class AppDownloadView extends LinearLayout {
    private TextView aaS;
    private CustomMessageListener downloadListener;
    private CustomMessageListener fCZ;
    private ProgressBar fGq;
    private ImageView fGr;
    private TextView fGs;
    private DownloadData fGt;

    public AppDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.fCZ = null;
        init(context);
    }

    public AppDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.fCZ = null;
        init(context);
    }

    public AppDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.fCZ = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(16);
        View inflate = LayoutInflater.from(context).inflate(d.j.app_download_layout, (ViewGroup) this, true);
        this.aaS = (TextView) inflate.findViewById(d.h.app_push_title);
        this.fGq = (ProgressBar) inflate.findViewById(d.h.frs_app_push_progress);
        this.fGr = (ImageView) inflate.findViewById(d.h.frs_app_push_control);
        this.fGs = (TextView) inflate.findViewById(d.h.frs_app_push_percent);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.fGt = (DownloadData) downloadData.clone();
            if (this.fGt != null) {
                setTag(this.fGt);
                r(downloadData);
            }
        }
    }

    public void refreshControlIcon(int i) {
        if (i == 1) {
            aj.c(this.fGr, d.g.icon_download_pause);
        } else {
            aj.c(this.fGr, d.g.icon_download_play);
        }
    }

    private void r(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    setVisibility(0);
                    aj.c(this.fGr, d.g.icon_download_pause);
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
                    aj.c(this.fGr, d.g.icon_download_play);
                    break;
            }
            int am = a.bfT().am(downloadData.getId(), downloadData.getName());
            if (am >= 0) {
                si(am);
            } else {
                si(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void si(int i) {
        int max = Math.max(0, i);
        this.fGq.setProgress(max);
        this.fGs.setText(max + "%");
    }

    public static int getStatus(DownloadData downloadData) {
        return a.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bgF();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bgE();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            bgE();
        } else {
            bgF();
        }
    }

    public void showTitleView(int i) {
        this.aaS.setVisibility(i);
    }

    public void onChangeSkinType(int i) {
        aj.b(this.aaS, d.e.cp_cont_c, 1, i);
        this.fGq.setProgressDrawable(aj.u(i, d.g.progress_download_app_layerlist));
        aj.b(this.fGr, d.g.icon_download_play, i);
        aj.b(this.fGs, d.e.cp_cont_d, 1, i);
    }

    private void bgE() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.fCZ != null) {
            MessageManager.getInstance().registerListener(this.fCZ);
        }
    }

    private void bgF() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.fCZ != null) {
            MessageManager.getInstance().unRegisterListener(this.fCZ);
        }
    }

    public void enableDownloadListener() {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.fGu.fGt.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && AppDownloadView.this.fGt != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(AppDownloadView.this.fGt.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            AppDownloadView.this.si(a.bfT().am(downloadData.getId(), downloadData.getName()));
                            AppDownloadView.this.postInvalidate();
                        }
                    }
                }
            };
        }
        if (this.fCZ == null) {
            this.fCZ = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && AppDownloadView.this.fGt != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (AppDownloadView.this.fGt.getId() != null && downloadData != null && AppDownloadView.this.fGt.getId().equals(downloadData.getId())) {
                            int status = a.getStatus(downloadData);
                            if (status == 7) {
                                aj.c(AppDownloadView.this.fGr, d.g.icon_download_pause);
                            } else if (status == 1) {
                                aj.c(AppDownloadView.this.fGr, d.g.icon_download_play);
                            }
                        }
                    }
                }
            };
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AppDownloadListener implements View.OnClickListener {
        protected AppDownloadView fGv;

        public void setAppDownloadView(AppDownloadView appDownloadView) {
            this.fGv = appDownloadView;
        }
    }
}
