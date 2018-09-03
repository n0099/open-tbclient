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
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.download.d;
import com.baidu.tieba.recapp.download.h;
import java.util.List;
/* loaded from: classes3.dex */
public class ApkDownloadView extends FrameLayout {
    private CustomMessageListener downloadListener;
    private CustomMessageListener gqt;
    private FeedAdProgressButton gvR;
    private DownloadData gvg;

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.gqt = null;
        init(context);
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.gqt = null;
        init(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.gqt = null;
        init(context);
    }

    private void init(Context context) {
        this.gvR = (FeedAdProgressButton) LayoutInflater.from(context).inflate(f.h.apk_download_view_layout, (ViewGroup) this, true).findViewById(f.g.feed_ad_operate_progress_button);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.gvg = (DownloadData) downloadData.clone();
            if (this.gvg != null) {
                setTag(this.gvg);
                p(downloadData);
            }
        }
    }

    public void setDefaultText(String str) {
        if (!TextUtils.isEmpty(str) && this.gvR != null) {
            this.gvR.setText(str);
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
                    this.gvR.setText(getResources().getString(f.j.go_on), t(downloadData));
                    return;
                case 3:
                    this.gvR.setText(getResources().getString(f.j.install));
                    return;
                case 4:
                default:
                    return;
                case 5:
                    ss(t(downloadData));
                    return;
                case 6:
                    this.gvR.setText(getResources().getString(f.j.install_app));
                    return;
            }
        }
    }

    public void q(DownloadData downloadData) {
        this.gvR.setText(getResources().getString(f.j.go_on), t(downloadData));
    }

    public void r(DownloadData downloadData) {
        ss(t(downloadData));
    }

    public void s(DownloadData downloadData) {
        this.gvR.setText(getResources().getString(f.j.install_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ss(int i) {
        this.gvR.setProgress(Math.max(0, i));
    }

    public static int t(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = h.bnB().an(downloadData.getId(), downloadData.getName());
        }
        return Math.max(process, 0);
    }

    public static int getStatus(DownloadData downloadData) {
        c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return (adAdSense == null || adAdSense.BT()) ? h.getStatus(downloadData) : d.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bos();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bor();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            bor();
        } else {
            bos();
        }
    }

    public void onChangeSkinType(int i) {
        this.gvR.onChangeSkinType();
    }

    private void bor() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.gqt != null) {
            MessageManager.getInstance().registerListener(this.gqt);
        }
    }

    private void bos() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.gqt != null) {
            MessageManager.getInstance().unRegisterListener(this.gqt);
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.gvS.gvg.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.gvg != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(ApkDownloadView.this.gvg.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            int u = ApkDownloadView.this.u(downloadData);
                            if (h.getStatus(downloadData) == 1) {
                                ApkDownloadView.this.ss(u);
                            } else if (h.getStatus(downloadData) == 3) {
                                ApkDownloadView.this.gvR.setText(ApkDownloadView.this.getResources().getString(f.j.install));
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
        if (this.gqt == null) {
            this.gqt = new CustomMessageListener(2016484) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && ApkDownloadView.this.gvg != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (ApkDownloadView.this.gvg.getId() != null && downloadData != null && ApkDownloadView.this.gvg.getId().equals(downloadData.getId())) {
                            ApkDownloadView.this.p(downloadData);
                        }
                    }
                }
            };
            this.gqt.setTag(bdUniqueId);
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
