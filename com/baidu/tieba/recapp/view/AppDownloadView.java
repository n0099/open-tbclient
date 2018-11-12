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
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.download.d;
import java.util.List;
/* loaded from: classes.dex */
public class AppDownloadView extends LinearLayout {
    private CustomMessageListener downloadListener;
    private CustomMessageListener gGN;
    private ProgressBar gLt;
    private ImageView gLu;
    private TextView gLv;
    private DownloadData gLw;
    private TextView mTitleView;

    public AppDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.gGN = null;
        init(context);
    }

    public AppDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.gGN = null;
        init(context);
    }

    public AppDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.gGN = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(16);
        View inflate = LayoutInflater.from(context).inflate(e.h.app_download_layout, (ViewGroup) this, true);
        this.mTitleView = (TextView) inflate.findViewById(e.g.app_push_title);
        this.gLt = (ProgressBar) inflate.findViewById(e.g.frs_app_push_progress);
        this.gLu = (ImageView) inflate.findViewById(e.g.frs_app_push_control);
        this.gLv = (TextView) inflate.findViewById(e.g.frs_app_push_percent);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.gLw = (DownloadData) downloadData.clone();
            if (this.gLw != null) {
                setTag(this.gLw);
                o(downloadData);
            }
        }
    }

    public void refreshControlIcon(int i) {
        if (i == 1) {
            al.c(this.gLu, e.f.icon_download_pause);
        } else {
            al.c(this.gLu, e.f.icon_download_play);
        }
    }

    private void o(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    setVisibility(0);
                    al.c(this.gLu, e.f.icon_download_pause);
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
                    al.c(this.gLu, e.f.icon_download_play);
                    break;
            }
            int aG = d.bsN().aG(downloadData.getId(), downloadData.getName());
            if (aG >= 0) {
                tG(aG);
            } else {
                tG(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tG(int i) {
        int max = Math.max(0, i);
        this.gLt.setProgress(max);
        this.gLv.setText(max + "%");
    }

    public static int getStatus(DownloadData downloadData) {
        return d.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        btK();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        btJ();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            btJ();
        } else {
            btK();
        }
    }

    public void showTitleView(int i) {
        this.mTitleView.setVisibility(i);
    }

    public void onChangeSkinType(int i) {
        al.b(this.mTitleView, e.d.cp_cont_c, 1, i);
        this.gLt.setProgressDrawable(al.x(i, e.f.progress_download_app_layerlist));
        al.b(this.gLu, e.f.icon_download_play, i);
        al.b(this.gLv, e.d.cp_cont_d, 1, i);
    }

    private void btJ() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.gGN != null) {
            MessageManager.getInstance().registerListener(this.gGN);
        }
    }

    private void btK() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.gGN != null) {
            MessageManager.getInstance().unRegisterListener(this.gGN);
        }
    }

    public void enableDownloadListener() {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.gLx.gLw.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && AppDownloadView.this.gLw != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(AppDownloadView.this.gLw.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            AppDownloadView.this.tG(d.bsN().aG(downloadData.getId(), downloadData.getName()));
                            AppDownloadView.this.postInvalidate();
                        }
                    }
                }
            };
        }
        if (this.gGN == null) {
            this.gGN = new CustomMessageListener(2016484) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && AppDownloadView.this.gLw != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (AppDownloadView.this.gLw.getId() != null && downloadData != null && AppDownloadView.this.gLw.getId().equals(downloadData.getId())) {
                            int status = d.getStatus(downloadData);
                            if (status == 7) {
                                al.c(AppDownloadView.this.gLu, e.f.icon_download_pause);
                            } else if (status == 1) {
                                al.c(AppDownloadView.this.gLu, e.f.icon_download_play);
                            }
                        }
                    }
                }
            };
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AppDownloadListener implements View.OnClickListener {
        protected AppDownloadView gLy;

        public void setAppDownloadView(AppDownloadView appDownloadView) {
            this.gLy = appDownloadView;
        }
    }
}
