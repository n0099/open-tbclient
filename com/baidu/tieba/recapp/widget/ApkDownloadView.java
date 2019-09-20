package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.d;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.e;
import com.baidu.tieba.recapp.download.i;
import java.util.List;
/* loaded from: classes3.dex */
public class ApkDownloadView extends FrameLayout {
    private CustomMessageListener downloadListener;
    private CustomMessageListener iLq;
    private a iQQ;
    private FeedAdProgressButton iQR;
    private FeedAdProgressText iQS;
    private DownloadData iQc;

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.iLq = null;
        init(context);
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.iLq = null;
        init(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.iLq = null;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.apk_download_view_layout, (ViewGroup) this, true);
        this.iQR = (FeedAdProgressButton) inflate.findViewById(R.id.feed_ad_operate_progress_button);
        this.iQS = (FeedAdProgressText) inflate.findViewById(R.id.feed_ad_operate_progress_text);
        this.iQQ = this.iQR;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.iQc = (DownloadData) downloadData.clone();
            if (this.iQc != null) {
                setTag(this.iQc);
                p(downloadData);
            }
        }
    }

    public void setIsPbDownload(boolean z) {
        if (z) {
            this.iQR.setVisibility(8);
            this.iQS.setVisibility(0);
            this.iQQ = this.iQS;
            return;
        }
        this.iQS.setVisibility(8);
        this.iQR.setVisibility(0);
        this.iQQ = this.iQR;
    }

    public void setDefaultText(String str) {
        if (!TextUtils.isEmpty(str) && this.iQQ != null) {
            this.iQQ.setButtonText(str);
        }
    }

    public void setTextSize(int i) {
        this.iQQ.setButtonTextSize(i);
    }

    public void setTextColor(int i) {
        this.iQQ.setButtonTextColor(i);
    }

    public void setTextNightColor(int i) {
        this.iQQ.setButtonTextNightColor(i);
    }

    public void p(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    zS(t(downloadData));
                    return;
                case 2:
                case 7:
                    this.iQQ.setButtonText(getResources().getString(R.string.go_on_download), t(downloadData));
                    return;
                case 3:
                    this.iQQ.setButtonText(getResources().getString(R.string.immediately_install));
                    return;
                case 4:
                default:
                    return;
                case 5:
                    zS(t(downloadData));
                    return;
                case 6:
                    this.iQQ.setButtonText(getResources().getString(R.string.install_app));
                    return;
            }
        }
    }

    public void q(DownloadData downloadData) {
        this.iQQ.setButtonText(getResources().getString(R.string.go_on_download), t(downloadData));
    }

    public void r(DownloadData downloadData) {
        zS(t(downloadData));
    }

    public void s(DownloadData downloadData) {
        this.iQQ.setButtonText(getResources().getString(R.string.install_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zS(int i) {
        this.iQQ.setProgress(Math.max(0, i));
    }

    public static int t(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = i.ciW().cd(downloadData.getId(), downloadData.getName());
        }
        return Math.max(process, 0);
    }

    public static int getStatus(DownloadData downloadData) {
        d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return (adAdSense == null || adAdSense.amw()) ? i.getStatus(downloadData) : e.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aDu();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aDt();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            aDt();
        } else {
            aDu();
        }
    }

    public void onChangeSkinType(int i) {
        this.iQQ.onChangeSkinType();
    }

    public void bql() {
        this.iQQ.bql();
    }

    private void aDt() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.iLq != null) {
            MessageManager.getInstance().registerListener(this.iLq);
        }
    }

    private void aDu() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.iLq != null) {
            MessageManager.getInstance().unRegisterListener(this.iLq);
        }
    }

    public void s(BdUniqueId bdUniqueId) {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.iQT.iQc.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.iQc != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(ApkDownloadView.this.iQc.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            int u = ApkDownloadView.this.u(downloadData);
                            if (i.getStatus(downloadData) == 1) {
                                ApkDownloadView.this.zS(u);
                            } else if (i.getStatus(downloadData) == 3) {
                                ApkDownloadView.this.iQQ.setButtonText(ApkDownloadView.this.getResources().getString(R.string.immediately_install));
                            } else {
                                ApkDownloadView.this.q(downloadData);
                            }
                            ApkDownloadView.this.postInvalidate();
                        }
                    }
                }
            };
            this.downloadListener.setTag(bdUniqueId);
        }
        if (this.iLq == null) {
            this.iLq = new CustomMessageListener(2016484) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && ApkDownloadView.this.iQc != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (ApkDownloadView.this.iQc.getId() != null && downloadData != null && ApkDownloadView.this.iQc.getId().equals(downloadData.getId())) {
                            ApkDownloadView.this.p(downloadData);
                        }
                    }
                }
            };
            this.iLq.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int u(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        return (int) ((downloadData.getLength() * 100) / downloadData.getSize());
    }
}
