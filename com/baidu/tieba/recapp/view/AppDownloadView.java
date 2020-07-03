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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.e;
import java.util.List;
/* loaded from: classes.dex */
public class AppDownloadView extends LinearLayout {
    private CustomMessageListener downloadListener;
    private CustomMessageListener lgJ;
    private ProgressBar lld;
    private ImageView lle;
    private TextView llf;
    private DownloadData llg;
    private TextView mTitleView;

    public AppDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.lgJ = null;
        init(context);
    }

    public AppDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.lgJ = null;
        init(context);
    }

    public AppDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.lgJ = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(16);
        View inflate = LayoutInflater.from(context).inflate(R.layout.app_download_layout, (ViewGroup) this, true);
        this.mTitleView = (TextView) inflate.findViewById(R.id.app_push_title);
        this.lld = (ProgressBar) inflate.findViewById(R.id.frs_app_push_progress);
        this.lle = (ImageView) inflate.findViewById(R.id.frs_app_push_control);
        this.llf = (TextView) inflate.findViewById(R.id.frs_app_push_percent);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.llg = (DownloadData) downloadData.clone();
            if (this.llg != null) {
                setTag(this.llg);
                p(downloadData);
            }
        }
    }

    public void refreshControlIcon(int i) {
        if (i == 1) {
            an.setImageResource(this.lle, R.drawable.icon_download_pause);
        } else {
            an.setImageResource(this.lle, R.drawable.icon_download_play);
        }
    }

    private void p(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    setVisibility(0);
                    an.setImageResource(this.lle, R.drawable.icon_download_pause);
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
                    an.setImageResource(this.lle, R.drawable.icon_download_play);
                    break;
            }
            int ds = e.cYY().ds(downloadData.getId(), downloadData.getName());
            if (ds >= 0) {
                DD(ds);
            } else {
                DD(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DD(int i) {
        int max = Math.max(0, i);
        this.lld.setProgress(max);
        this.llf.setText(max + "%");
    }

    public static int getStatus(DownloadData downloadData) {
        return e.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        boZ();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        boY();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            boY();
        } else {
            boZ();
        }
    }

    public void showTitleView(int i) {
        this.mTitleView.setVisibility(i);
    }

    public void onChangeSkinType(int i) {
        an.setViewTextColor(this.mTitleView, R.color.cp_cont_c, 1, i);
        this.lld.setProgressDrawable(an.getDrawable(i, (int) R.drawable.progress_download_app_layerlist));
        an.setImageResource(this.lle, R.drawable.icon_download_play, i);
        an.setViewTextColor(this.llf, R.color.cp_cont_d, 1, i);
    }

    private void boY() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.lgJ != null) {
            MessageManager.getInstance().registerListener(this.lgJ);
        }
    }

    private void boZ() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.lgJ != null) {
            MessageManager.getInstance().unRegisterListener(this.lgJ);
        }
    }

    public void enableDownloadListener() {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.llh.llg.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && AppDownloadView.this.llg != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(AppDownloadView.this.llg.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            AppDownloadView.this.DD(e.cYY().ds(downloadData.getId(), downloadData.getName()));
                            AppDownloadView.this.postInvalidate();
                        }
                    }
                }
            };
        }
        if (this.lgJ == null) {
            this.lgJ = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && AppDownloadView.this.llg != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (AppDownloadView.this.llg.getId() != null && downloadData != null && AppDownloadView.this.llg.getId().equals(downloadData.getId())) {
                            int status = e.getStatus(downloadData);
                            if (status == 7) {
                                an.setImageResource(AppDownloadView.this.lle, R.drawable.icon_download_pause);
                            } else if (status == 1) {
                                an.setImageResource(AppDownloadView.this.lle, R.drawable.icon_download_play);
                            }
                        }
                    }
                }
            };
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AppDownloadListener implements View.OnClickListener {
        protected AppDownloadView lli;

        public void setAppDownloadView(AppDownloadView appDownloadView) {
            this.lli = appDownloadView;
        }
    }
}
