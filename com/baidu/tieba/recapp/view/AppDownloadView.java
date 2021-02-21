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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.e;
import java.util.List;
/* loaded from: classes.dex */
public class AppDownloadView extends LinearLayout {
    private CustomMessageListener downloadListener;
    private TextView mTitleView;
    private CustomMessageListener mUr;
    private ProgressBar mZh;
    private ImageView mZi;
    private TextView mZj;
    private DownloadData mZk;

    public AppDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.mUr = null;
        init(context);
    }

    public AppDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.mUr = null;
        init(context);
    }

    public AppDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.mUr = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(16);
        View inflate = LayoutInflater.from(context).inflate(R.layout.app_download_layout, (ViewGroup) this, true);
        this.mTitleView = (TextView) inflate.findViewById(R.id.app_push_title);
        this.mZh = (ProgressBar) inflate.findViewById(R.id.frs_app_push_progress);
        this.mZi = (ImageView) inflate.findViewById(R.id.frs_app_push_control);
        this.mZj = (TextView) inflate.findViewById(R.id.frs_app_push_percent);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.mZk = (DownloadData) downloadData.clone();
            if (this.mZk != null) {
                setTag(this.mZk);
                o(downloadData);
            }
        }
    }

    public void refreshControlIcon(int i) {
        if (i == 1) {
            ap.setImageResource(this.mZi, R.drawable.icon_download_pause);
        } else {
            ap.setImageResource(this.mZi, R.drawable.icon_download_play);
        }
    }

    private void o(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    setVisibility(0);
                    ap.setImageResource(this.mZi, R.drawable.icon_download_pause);
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
                    ap.setImageResource(this.mZi, R.drawable.icon_download_play);
                    break;
            }
            int dX = e.dDA().dX(downloadData.getId(), downloadData.getName());
            if (dX >= 0) {
                If(dX);
            } else {
                If(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void If(int i) {
        int max = Math.max(0, i);
        this.mZh.setProgress(max);
        this.mZj.setText(max + "%");
    }

    public static int getStatus(DownloadData downloadData) {
        return e.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bLr();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bLq();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            bLq();
        } else {
            bLr();
        }
    }

    public void showTitleView(int i) {
        this.mTitleView.setVisibility(i);
    }

    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0108, 1, i);
        this.mZh.setProgressDrawable(ap.getDrawable(i, R.drawable.progress_download_app_layerlist));
        ap.setImageResource(this.mZi, R.drawable.icon_download_play, i);
        ap.setViewTextColor(this.mZj, R.color.CAM_X0109, 1, i);
    }

    private void bLq() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.mUr != null) {
            MessageManager.getInstance().registerListener(this.mUr);
        }
    }

    private void bLr() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.mUr != null) {
            MessageManager.getInstance().unRegisterListener(this.mUr);
        }
    }

    public void enableDownloadListener() {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.mZl.mZk.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && AppDownloadView.this.mZk != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(AppDownloadView.this.mZk.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            AppDownloadView.this.If(e.dDA().dX(downloadData.getId(), downloadData.getName()));
                            AppDownloadView.this.postInvalidate();
                        }
                    }
                }
            };
        }
        if (this.mUr == null) {
            this.mUr = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && AppDownloadView.this.mZk != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (AppDownloadView.this.mZk.getId() != null && downloadData != null && AppDownloadView.this.mZk.getId().equals(downloadData.getId())) {
                            int status = e.getStatus(downloadData);
                            if (status == 7) {
                                ap.setImageResource(AppDownloadView.this.mZi, R.drawable.icon_download_pause);
                            } else if (status == 1) {
                                ap.setImageResource(AppDownloadView.this.mZi, R.drawable.icon_download_play);
                            }
                        }
                    }
                }
            };
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AppDownloadListener implements View.OnClickListener {
        protected AppDownloadView mZm;

        public void setAppDownloadView(AppDownloadView appDownloadView) {
            this.mZm = appDownloadView;
        }
    }
}
