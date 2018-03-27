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
    private CustomMessageListener gEh;
    private DownloadData gIB;
    private FeedAdProgressButton gJo;

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.gEh = null;
        init(context);
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.gEh = null;
        init(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.gEh = null;
        init(context);
    }

    private void init(Context context) {
        this.gJo = (FeedAdProgressButton) LayoutInflater.from(context).inflate(d.h.apk_download_view_layout, (ViewGroup) this, true).findViewById(d.g.feed_ad_operate_progress_button);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.gIB = (DownloadData) downloadData.clone();
            if (this.gIB != null) {
                setTag(this.gIB);
                s(downloadData);
            }
        }
    }

    public void s(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    uz(v(downloadData));
                    return;
                case 2:
                case 7:
                    this.gJo.aE(getResources().getString(d.j.go_on), v(downloadData));
                    return;
                case 3:
                    this.gJo.setText(getResources().getString(d.j.install));
                    return;
                case 4:
                default:
                    return;
                case 5:
                    uz(v(downloadData));
                    return;
                case 6:
                    this.gJo.setText(getResources().getString(d.j.install_app));
                    return;
            }
        }
    }

    public void t(DownloadData downloadData) {
        this.gJo.aE(getResources().getString(d.j.go_on), v(downloadData));
    }

    public void h(DownloadData downloadData) {
        uz(v(downloadData));
    }

    public void u(DownloadData downloadData) {
        this.gJo.setText(getResources().getString(d.j.install_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uz(int i) {
        this.gJo.setProgress(Math.max(0, i));
    }

    public static int v(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = h.bor().al(downloadData.getId(), downloadData.getName());
        }
        return Math.max(process, 0);
    }

    public static int getStatus(DownloadData downloadData) {
        c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return (adAdSense == null || adAdSense.FB()) ? h.getStatus(downloadData) : com.baidu.tieba.recapp.download.d.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bph();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bpg();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            bpg();
        } else {
            bph();
        }
    }

    public void onChangeSkinType(int i) {
        this.gJo.onChangeSkinType();
    }

    private void bpg() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.gEh != null) {
            MessageManager.getInstance().registerListener(this.gEh);
        }
    }

    private void bph() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.gEh != null) {
            MessageManager.getInstance().unRegisterListener(this.gEh);
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.gJp.gIB.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.gIB != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(ApkDownloadView.this.gIB.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            int w = ApkDownloadView.this.w(downloadData);
                            if (h.getStatus(downloadData) == 1) {
                                ApkDownloadView.this.uz(w);
                            } else if (h.getStatus(downloadData) == 3) {
                                ApkDownloadView.this.gJo.setText(ApkDownloadView.this.getResources().getString(d.j.install));
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
        if (this.gEh == null) {
            this.gEh = new CustomMessageListener(2016484) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && ApkDownloadView.this.gIB != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (ApkDownloadView.this.gIB.getId() != null && downloadData != null && ApkDownloadView.this.gIB.getId().equals(downloadData.getId())) {
                            ApkDownloadView.this.s(downloadData);
                        }
                    }
                }
            };
            this.gEh.setTag(bdUniqueId);
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
