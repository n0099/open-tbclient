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
    private CustomMessageListener gqq;
    private FeedAdProgressButton gvO;
    private DownloadData gvd;

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.gqq = null;
        init(context);
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.gqq = null;
        init(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.gqq = null;
        init(context);
    }

    private void init(Context context) {
        this.gvO = (FeedAdProgressButton) LayoutInflater.from(context).inflate(d.h.apk_download_view_layout, (ViewGroup) this, true).findViewById(d.g.feed_ad_operate_progress_button);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.gvd = (DownloadData) downloadData.clone();
            if (this.gvd != null) {
                setTag(this.gvd);
                p(downloadData);
            }
        }
    }

    public void setDefaultText(String str) {
        if (!TextUtils.isEmpty(str) && this.gvO != null) {
            this.gvO.setText(str);
        }
    }

    public void p(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    ss(t(downloadData));
                    return;
                case 2:
                case 7:
                    this.gvO.setText(getResources().getString(d.j.go_on), t(downloadData));
                    return;
                case 3:
                    this.gvO.setText(getResources().getString(d.j.install));
                    return;
                case 4:
                default:
                    return;
                case 5:
                    ss(t(downloadData));
                    return;
                case 6:
                    this.gvO.setText(getResources().getString(d.j.install_app));
                    return;
            }
        }
    }

    public void q(DownloadData downloadData) {
        this.gvO.setText(getResources().getString(d.j.go_on), t(downloadData));
    }

    public void r(DownloadData downloadData) {
        ss(t(downloadData));
    }

    public void s(DownloadData downloadData) {
        this.gvO.setText(getResources().getString(d.j.install_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ss(int i) {
        this.gvO.setProgress(Math.max(0, i));
    }

    public static int t(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = h.bnA().ao(downloadData.getId(), downloadData.getName());
        }
        return Math.max(process, 0);
    }

    public static int getStatus(DownloadData downloadData) {
        c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return (adAdSense == null || adAdSense.BW()) ? h.getStatus(downloadData) : com.baidu.tieba.recapp.download.d.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bor();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        boq();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            boq();
        } else {
            bor();
        }
    }

    public void onChangeSkinType(int i) {
        this.gvO.onChangeSkinType();
    }

    private void boq() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.gqq != null) {
            MessageManager.getInstance().registerListener(this.gqq);
        }
    }

    private void bor() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.gqq != null) {
            MessageManager.getInstance().unRegisterListener(this.gqq);
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.gvP.gvd.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.gvd != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(ApkDownloadView.this.gvd.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            int u = ApkDownloadView.this.u(downloadData);
                            if (h.getStatus(downloadData) == 1) {
                                ApkDownloadView.this.ss(u);
                            } else if (h.getStatus(downloadData) == 3) {
                                ApkDownloadView.this.gvO.setText(ApkDownloadView.this.getResources().getString(d.j.install));
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
        if (this.gqq == null) {
            this.gqq = new CustomMessageListener(2016484) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && ApkDownloadView.this.gvd != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (ApkDownloadView.this.gvd.getId() != null && downloadData != null && ApkDownloadView.this.gvd.getId().equals(downloadData.getId())) {
                            ApkDownloadView.this.p(downloadData);
                        }
                    }
                }
            };
            this.gqq.setTag(bdUniqueId);
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
