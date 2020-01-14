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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.e;
import java.util.List;
/* loaded from: classes.dex */
public class AppDownloadView extends LinearLayout {
    private CustomMessageListener downloadListener;
    private CustomMessageListener jHo;
    private ProgressBar jLY;
    private ImageView jLZ;
    private TextView jMa;
    private DownloadData jMb;
    private TextView mTitleView;

    public AppDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.jHo = null;
        init(context);
    }

    public AppDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.jHo = null;
        init(context);
    }

    public AppDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.jHo = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(16);
        View inflate = LayoutInflater.from(context).inflate(R.layout.app_download_layout, (ViewGroup) this, true);
        this.mTitleView = (TextView) inflate.findViewById(R.id.app_push_title);
        this.jLY = (ProgressBar) inflate.findViewById(R.id.frs_app_push_progress);
        this.jLZ = (ImageView) inflate.findViewById(R.id.frs_app_push_control);
        this.jMa = (TextView) inflate.findViewById(R.id.frs_app_push_percent);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.jMb = (DownloadData) downloadData.clone();
            if (this.jMb != null) {
                setTag(this.jMb);
                p(downloadData);
            }
        }
    }

    public void refreshControlIcon(int i) {
        if (i == 1) {
            am.setImageResource(this.jLZ, R.drawable.icon_download_pause);
        } else {
            am.setImageResource(this.jLZ, R.drawable.icon_download_play);
        }
    }

    private void p(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    setVisibility(0);
                    am.setImageResource(this.jLZ, R.drawable.icon_download_pause);
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
                    am.setImageResource(this.jLZ, R.drawable.icon_download_play);
                    break;
            }
            int cx = e.cBd().cx(downloadData.getId(), downloadData.getName());
            if (cx >= 0) {
                AY(cx);
            } else {
                AY(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AY(int i) {
        int max = Math.max(0, i);
        this.jLY.setProgress(max);
        this.jMa.setText(max + "%");
    }

    public static int getStatus(DownloadData downloadData) {
        return e.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aVO();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aVN();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            aVN();
        } else {
            aVO();
        }
    }

    public void showTitleView(int i) {
        this.mTitleView.setVisibility(i);
    }

    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.mTitleView, R.color.cp_cont_c, 1, i);
        this.jLY.setProgressDrawable(am.getDrawable(i, (int) R.drawable.progress_download_app_layerlist));
        am.setImageResource(this.jLZ, R.drawable.icon_download_play, i);
        am.setViewTextColor(this.jMa, R.color.cp_cont_d, 1, i);
    }

    private void aVN() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.jHo != null) {
            MessageManager.getInstance().registerListener(this.jHo);
        }
    }

    private void aVO() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.jHo != null) {
            MessageManager.getInstance().unRegisterListener(this.jHo);
        }
    }

    public void enableDownloadListener() {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.jMc.jMb.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && AppDownloadView.this.jMb != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(AppDownloadView.this.jMb.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            AppDownloadView.this.AY(e.cBd().cx(downloadData.getId(), downloadData.getName()));
                            AppDownloadView.this.postInvalidate();
                        }
                    }
                }
            };
        }
        if (this.jHo == null) {
            this.jHo = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && AppDownloadView.this.jMb != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (AppDownloadView.this.jMb.getId() != null && downloadData != null && AppDownloadView.this.jMb.getId().equals(downloadData.getId())) {
                            int status = e.getStatus(downloadData);
                            if (status == 7) {
                                am.setImageResource(AppDownloadView.this.jLZ, R.drawable.icon_download_pause);
                            } else if (status == 1) {
                                am.setImageResource(AppDownloadView.this.jLZ, R.drawable.icon_download_play);
                            }
                        }
                    }
                }
            };
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AppDownloadListener implements View.OnClickListener {
        protected AppDownloadView jMd;

        public void setAppDownloadView(AppDownloadView appDownloadView) {
            this.jMd = appDownloadView;
        }
    }
}
