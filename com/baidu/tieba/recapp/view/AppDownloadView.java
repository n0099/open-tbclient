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
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.d;
import java.util.List;
/* loaded from: classes.dex */
public class AppDownloadView extends LinearLayout {
    private CustomMessageListener downloadListener;
    private CustomMessageListener iBy;
    private ProgressBar iGh;
    private ImageView iGi;
    private TextView iGj;
    private DownloadData iGk;
    private TextView mTitleView;

    public AppDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.iBy = null;
        init(context);
    }

    public AppDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.iBy = null;
        init(context);
    }

    public AppDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.iBy = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(16);
        View inflate = LayoutInflater.from(context).inflate(R.layout.app_download_layout, (ViewGroup) this, true);
        this.mTitleView = (TextView) inflate.findViewById(R.id.app_push_title);
        this.iGh = (ProgressBar) inflate.findViewById(R.id.frs_app_push_progress);
        this.iGi = (ImageView) inflate.findViewById(R.id.frs_app_push_control);
        this.iGj = (TextView) inflate.findViewById(R.id.frs_app_push_percent);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.iGk = (DownloadData) downloadData.clone();
            if (this.iGk != null) {
                setTag(this.iGk);
                o(downloadData);
            }
        }
    }

    public void refreshControlIcon(int i) {
        if (i == 1) {
            al.c(this.iGi, (int) R.drawable.icon_download_pause);
        } else {
            al.c(this.iGi, (int) R.drawable.icon_download_play);
        }
    }

    private void o(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    setVisibility(0);
                    al.c(this.iGi, (int) R.drawable.icon_download_pause);
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
                    al.c(this.iGi, (int) R.drawable.icon_download_play);
                    break;
            }
            int cc = d.ceT().cc(downloadData.getId(), downloadData.getName());
            if (cc >= 0) {
                zi(cc);
            } else {
                zi(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zi(int i) {
        int max = Math.max(0, i);
        this.iGh.setProgress(max);
        this.iGj.setText(max + "%");
    }

    public static int getStatus(DownloadData downloadData) {
        return d.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cfT();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cfS();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            cfS();
        } else {
            cfT();
        }
    }

    public void showTitleView(int i) {
        this.mTitleView.setVisibility(i);
    }

    public void onChangeSkinType(int i) {
        al.c(this.mTitleView, R.color.cp_cont_c, 1, i);
        this.iGh.setProgressDrawable(al.S(i, R.drawable.progress_download_app_layerlist));
        al.b(this.iGi, (int) R.drawable.icon_download_play, i);
        al.c(this.iGj, R.color.cp_cont_d, 1, i);
    }

    private void cfS() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.iBy != null) {
            MessageManager.getInstance().registerListener(this.iBy);
        }
    }

    private void cfT() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.iBy != null) {
            MessageManager.getInstance().unRegisterListener(this.iBy);
        }
    }

    public void enableDownloadListener() {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.iGl.iGk.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && AppDownloadView.this.iGk != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(AppDownloadView.this.iGk.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            AppDownloadView.this.zi(d.ceT().cc(downloadData.getId(), downloadData.getName()));
                            AppDownloadView.this.postInvalidate();
                        }
                    }
                }
            };
        }
        if (this.iBy == null) {
            this.iBy = new CustomMessageListener(2016484) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && AppDownloadView.this.iGk != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (AppDownloadView.this.iGk.getId() != null && downloadData != null && AppDownloadView.this.iGk.getId().equals(downloadData.getId())) {
                            int status = d.getStatus(downloadData);
                            if (status == 7) {
                                al.c(AppDownloadView.this.iGi, (int) R.drawable.icon_download_pause);
                            } else if (status == 1) {
                                al.c(AppDownloadView.this.iGi, (int) R.drawable.icon_download_play);
                            }
                        }
                    }
                }
            };
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AppDownloadListener implements View.OnClickListener {
        protected AppDownloadView iGm;

        public void setAppDownloadView(AppDownloadView appDownloadView) {
            this.iGm = appDownloadView;
        }
    }
}
