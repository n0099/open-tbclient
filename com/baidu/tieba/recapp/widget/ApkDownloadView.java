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
import com.baidu.tieba.recapp.download.h;
import java.util.List;
/* loaded from: classes3.dex */
public class ApkDownloadView extends FrameLayout {
    private CustomMessageListener downloadListener;
    private CustomMessageListener iHQ;
    private DownloadData iMC;
    private a iNq;
    private FeedAdProgressButton iNr;
    private FeedAdProgressText iNs;

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.iHQ = null;
        init(context);
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.iHQ = null;
        init(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.iHQ = null;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.apk_download_view_layout, (ViewGroup) this, true);
        this.iNr = (FeedAdProgressButton) inflate.findViewById(R.id.feed_ad_operate_progress_button);
        this.iNs = (FeedAdProgressText) inflate.findViewById(R.id.feed_ad_operate_progress_text);
        this.iNq = this.iNr;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.iMC = (DownloadData) downloadData.clone();
            if (this.iMC != null) {
                setTag(this.iMC);
                p(downloadData);
            }
        }
    }

    public void setIsPbDownload(boolean z) {
        if (z) {
            this.iNr.setVisibility(8);
            this.iNs.setVisibility(0);
            this.iNq = this.iNs;
            return;
        }
        this.iNs.setVisibility(8);
        this.iNr.setVisibility(0);
        this.iNq = this.iNr;
    }

    public void setDefaultText(String str) {
        if (!TextUtils.isEmpty(str) && this.iNq != null) {
            this.iNq.setButtonText(str);
        }
    }

    public void setTextSize(int i) {
        this.iNq.setButtonTextSize(i);
    }

    public void setTextColor(int i) {
        this.iNq.setButtonTextColor(i);
    }

    public void setTextNightColor(int i) {
        this.iNq.setButtonTextNightColor(i);
    }

    public void p(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    zN(t(downloadData));
                    return;
                case 2:
                case 7:
                    this.iNq.setButtonText(getResources().getString(R.string.go_on_download), t(downloadData));
                    return;
                case 3:
                    this.iNq.setButtonText(getResources().getString(R.string.immediately_install));
                    return;
                case 4:
                default:
                    return;
                case 5:
                    zN(t(downloadData));
                    return;
                case 6:
                    this.iNq.setButtonText(getResources().getString(R.string.install_app));
                    return;
            }
        }
    }

    public void q(DownloadData downloadData) {
        this.iNq.setButtonText(getResources().getString(R.string.go_on_download), t(downloadData));
    }

    public void r(DownloadData downloadData) {
        zN(t(downloadData));
    }

    public void s(DownloadData downloadData) {
        this.iNq.setButtonText(getResources().getString(R.string.install_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zN(int i) {
        this.iNq.setProgress(Math.max(0, i));
    }

    public static int t(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = h.chQ().cd(downloadData.getId(), downloadData.getName());
        }
        return Math.max(process, 0);
    }

    public static int getStatus(DownloadData downloadData) {
        d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return (adAdSense == null || adAdSense.ami()) ? h.getStatus(downloadData) : com.baidu.tieba.recapp.download.d.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ciK();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ciJ();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            ciJ();
        } else {
            ciK();
        }
    }

    public void onChangeSkinType(int i) {
        this.iNq.onChangeSkinType();
    }

    public void bIl() {
        this.iNq.bIl();
    }

    private void ciJ() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.iHQ != null) {
            MessageManager.getInstance().registerListener(this.iHQ);
        }
    }

    private void ciK() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.iHQ != null) {
            MessageManager.getInstance().unRegisterListener(this.iHQ);
        }
    }

    public void s(BdUniqueId bdUniqueId) {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.iNt.iMC.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.iMC != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(ApkDownloadView.this.iMC.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            int u = ApkDownloadView.this.u(downloadData);
                            if (h.getStatus(downloadData) == 1) {
                                ApkDownloadView.this.zN(u);
                            } else if (h.getStatus(downloadData) == 3) {
                                ApkDownloadView.this.iNq.setButtonText(ApkDownloadView.this.getResources().getString(R.string.immediately_install));
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
        if (this.iHQ == null) {
            this.iHQ = new CustomMessageListener(2016484) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && ApkDownloadView.this.iMC != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (ApkDownloadView.this.iMC.getId() != null && downloadData != null && ApkDownloadView.this.iMC.getId().equals(downloadData.getId())) {
                            ApkDownloadView.this.p(downloadData);
                        }
                    }
                }
            };
            this.iHQ.setTag(bdUniqueId);
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
