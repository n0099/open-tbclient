package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.download.h;
import java.util.List;
/* loaded from: classes3.dex */
public class ApkDownloadView extends FrameLayout {
    private CustomMessageListener downloadListener;
    private CustomMessageListener iiW;
    private DownloadData inM;
    private FeedAdProgressButton iow;

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.iiW = null;
        init(context);
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.iiW = null;
        init(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.iiW = null;
        init(context);
    }

    private void init(Context context) {
        this.iow = (FeedAdProgressButton) LayoutInflater.from(context).inflate(d.h.apk_download_view_layout, (ViewGroup) this, true).findViewById(d.g.feed_ad_operate_progress_button);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.inM = (DownloadData) downloadData.clone();
            if (this.inM != null) {
                setTag(this.inM);
                p(downloadData);
            }
        }
    }

    public void setDefaultText(String str) {
        if (!TextUtils.isEmpty(str) && this.iow != null) {
            this.iow.setText(str);
        }
    }

    public void p(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    yf(t(downloadData));
                    return;
                case 2:
                case 7:
                    this.iow.setText(getResources().getString(d.j.go_on_download), t(downloadData));
                    return;
                case 3:
                    this.iow.setText(getResources().getString(d.j.immediately_install));
                    return;
                case 4:
                default:
                    return;
                case 5:
                    yf(t(downloadData));
                    return;
                case 6:
                    this.iow.setText(getResources().getString(d.j.install_app));
                    return;
            }
        }
    }

    public void q(DownloadData downloadData) {
        this.iow.setText(getResources().getString(d.j.go_on_download), t(downloadData));
    }

    public void r(DownloadData downloadData) {
        yf(t(downloadData));
    }

    public void s(DownloadData downloadData) {
        this.iow.setText(getResources().getString(d.j.install_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yf(int i) {
        this.iow.setProgress(Math.max(0, i));
    }

    public static int t(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = h.bWW().bS(downloadData.getId(), downloadData.getName());
        }
        return Math.max(process, 0);
    }

    public static int getStatus(DownloadData downloadData) {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return (adAdSense == null || adAdSense.agh()) ? h.getStatus(downloadData) : com.baidu.tieba.recapp.download.d.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bXQ();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bXP();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            bXP();
        } else {
            bXQ();
        }
    }

    public void onChangeSkinType(int i) {
        this.iow.onChangeSkinType();
    }

    public void bxV() {
        this.iow.bxV();
    }

    private void bXP() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.iiW != null) {
            MessageManager.getInstance().registerListener(this.iiW);
        }
    }

    private void bXQ() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.iiW != null) {
            MessageManager.getInstance().unRegisterListener(this.iiW);
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.iox.inM.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.inM != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(ApkDownloadView.this.inM.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            int u = ApkDownloadView.this.u(downloadData);
                            if (h.getStatus(downloadData) == 1) {
                                ApkDownloadView.this.yf(u);
                            } else if (h.getStatus(downloadData) == 3) {
                                ApkDownloadView.this.iow.setText(ApkDownloadView.this.getResources().getString(d.j.immediately_install));
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
        if (this.iiW == null) {
            this.iiW = new CustomMessageListener(2016484) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && ApkDownloadView.this.inM != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (ApkDownloadView.this.inM.getId() != null && downloadData != null && ApkDownloadView.this.inM.getId().equals(downloadData.getId())) {
                            ApkDownloadView.this.p(downloadData);
                        }
                    }
                }
            };
            this.iiW.setTag(bdUniqueId);
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
