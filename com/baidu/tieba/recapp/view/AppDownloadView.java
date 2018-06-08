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
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class AppDownloadView extends LinearLayout {
    private CustomMessageListener downloadListener;
    private CustomMessageListener glp;
    private ProgressBar gpV;
    private ImageView gpW;
    private TextView gpX;
    private DownloadData gpY;
    private TextView mTitleView;

    public AppDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.glp = null;
        init(context);
    }

    public AppDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.glp = null;
        init(context);
    }

    public AppDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.glp = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(16);
        View inflate = LayoutInflater.from(context).inflate(d.i.app_download_layout, (ViewGroup) this, true);
        this.mTitleView = (TextView) inflate.findViewById(d.g.app_push_title);
        this.gpV = (ProgressBar) inflate.findViewById(d.g.frs_app_push_progress);
        this.gpW = (ImageView) inflate.findViewById(d.g.frs_app_push_control);
        this.gpX = (TextView) inflate.findViewById(d.g.frs_app_push_percent);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.gpY = (DownloadData) downloadData.clone();
            if (this.gpY != null) {
                setTag(this.gpY);
                r(downloadData);
            }
        }
    }

    public void refreshControlIcon(int i) {
        if (i == 1) {
            al.c(this.gpW, d.f.icon_download_pause);
        } else {
            al.c(this.gpW, d.f.icon_download_play);
        }
    }

    private void r(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    setVisibility(0);
                    al.c(this.gpW, d.f.icon_download_pause);
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
                    al.c(this.gpW, d.f.icon_download_play);
                    break;
            }
            int aq = com.baidu.tieba.recapp.download.d.bop().aq(downloadData.getId(), downloadData.getName());
            if (aq >= 0) {
                sk(aq);
            } else {
                sk(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sk(int i) {
        int max = Math.max(0, i);
        this.gpV.setProgress(max);
        this.gpX.setText(max + "%");
    }

    public static int getStatus(DownloadData downloadData) {
        return com.baidu.tieba.recapp.download.d.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bpl();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bpk();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            bpk();
        } else {
            bpl();
        }
    }

    public void showTitleView(int i) {
        this.mTitleView.setVisibility(i);
    }

    public void onChangeSkinType(int i) {
        al.b(this.mTitleView, d.C0141d.cp_cont_c, 1, i);
        this.gpV.setProgressDrawable(al.v(i, d.f.progress_download_app_layerlist));
        al.b(this.gpW, d.f.icon_download_play, i);
        al.b(this.gpX, d.C0141d.cp_cont_d, 1, i);
    }

    private void bpk() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.glp != null) {
            MessageManager.getInstance().registerListener(this.glp);
        }
    }

    private void bpl() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.glp != null) {
            MessageManager.getInstance().unRegisterListener(this.glp);
        }
    }

    public void enableDownloadListener() {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.gpZ.gpY.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && AppDownloadView.this.gpY != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(AppDownloadView.this.gpY.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            AppDownloadView.this.sk(com.baidu.tieba.recapp.download.d.bop().aq(downloadData.getId(), downloadData.getName()));
                            AppDownloadView.this.postInvalidate();
                        }
                    }
                }
            };
        }
        if (this.glp == null) {
            this.glp = new CustomMessageListener(2016484) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && AppDownloadView.this.gpY != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (AppDownloadView.this.gpY.getId() != null && downloadData != null && AppDownloadView.this.gpY.getId().equals(downloadData.getId())) {
                            int status = com.baidu.tieba.recapp.download.d.getStatus(downloadData);
                            if (status == 7) {
                                al.c(AppDownloadView.this.gpW, d.f.icon_download_pause);
                            } else if (status == 1) {
                                al.c(AppDownloadView.this.gpW, d.f.icon_download_play);
                            }
                        }
                    }
                }
            };
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AppDownloadListener implements View.OnClickListener {
        protected AppDownloadView gqa;

        public void setAppDownloadView(AppDownloadView appDownloadView) {
            this.gqa = appDownloadView;
        }
    }
}
