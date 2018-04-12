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
import com.baidu.tbadk.coreExtra.data.c;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.download.h;
import java.util.List;
/* loaded from: classes3.dex */
public class ApkDownloadView extends FrameLayout {
    private CustomMessageListener downloadListener;
    private CustomMessageListener fYU;
    private DownloadData gdB;
    private FeedAdProgressButton gel;

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.fYU = null;
        init(context);
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.fYU = null;
        init(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.fYU = null;
        init(context);
    }

    private void init(Context context) {
        this.gel = (FeedAdProgressButton) LayoutInflater.from(context).inflate(d.i.apk_download_view_layout, (ViewGroup) this, true).findViewById(d.g.feed_ad_operate_progress_button);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.gdB = (DownloadData) downloadData.clone();
            if (this.gdB != null) {
                setTag(this.gdB);
                s(downloadData);
            }
        }
    }

    public void setDefaultText(String str) {
        if (!TextUtils.isEmpty(str) && this.gel != null) {
            this.gel.setText(str);
        }
    }

    public void s(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    sa(v(downloadData));
                    return;
                case 2:
                case 7:
                    this.gel.setText(getResources().getString(d.k.go_on), v(downloadData));
                    return;
                case 3:
                    this.gel.setText(getResources().getString(d.k.install));
                    return;
                case 4:
                default:
                    return;
                case 5:
                    sa(v(downloadData));
                    return;
                case 6:
                    this.gel.setText(getResources().getString(d.k.install_app));
                    return;
            }
        }
    }

    public void t(DownloadData downloadData) {
        this.gel.setText(getResources().getString(d.k.go_on), v(downloadData));
    }

    public void h(DownloadData downloadData) {
        sa(v(downloadData));
    }

    public void u(DownloadData downloadData) {
        this.gel.setText(getResources().getString(d.k.install_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sa(int i) {
        this.gel.setProgress(Math.max(0, i));
    }

    public static int v(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = h.bjx().al(downloadData.getId(), downloadData.getName());
        }
        return Math.max(process, 0);
    }

    public static int getStatus(DownloadData downloadData) {
        c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return (adAdSense == null || adAdSense.yo()) ? h.getStatus(downloadData) : com.baidu.tieba.recapp.download.d.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bko();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bkn();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            bkn();
        } else {
            bko();
        }
    }

    public void onChangeSkinType(int i) {
        this.gel.onChangeSkinType();
    }

    private void bkn() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.fYU != null) {
            MessageManager.getInstance().registerListener(this.fYU);
        }
    }

    private void bko() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.fYU != null) {
            MessageManager.getInstance().unRegisterListener(this.fYU);
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.gem.gdB.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.gdB != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(ApkDownloadView.this.gdB.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            int w = ApkDownloadView.this.w(downloadData);
                            if (h.getStatus(downloadData) == 1) {
                                ApkDownloadView.this.sa(w);
                            } else if (h.getStatus(downloadData) == 3) {
                                ApkDownloadView.this.gel.setText(ApkDownloadView.this.getResources().getString(d.k.install));
                            } else {
                                ApkDownloadView.this.t(downloadData);
                            }
                            ApkDownloadView.this.postInvalidate();
                        }
                    }
                }
            };
            this.downloadListener.setTag(bdUniqueId);
        }
        if (this.fYU == null) {
            this.fYU = new CustomMessageListener(2016484) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && ApkDownloadView.this.gdB != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (ApkDownloadView.this.gdB.getId() != null && downloadData != null && ApkDownloadView.this.gdB.getId().equals(downloadData.getId())) {
                            ApkDownloadView.this.s(downloadData);
                        }
                    }
                }
            };
            this.fYU.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int w(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        return (int) ((downloadData.getLength() * 100) / downloadData.getSize());
    }
}
