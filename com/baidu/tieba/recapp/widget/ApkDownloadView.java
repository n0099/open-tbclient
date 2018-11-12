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
import com.baidu.tbadk.coreExtra.data.d;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.download.h;
import java.util.List;
/* loaded from: classes3.dex */
public class ApkDownloadView extends FrameLayout {
    private CustomMessageListener downloadListener;
    private CustomMessageListener gGN;
    private DownloadData gLw;
    private FeedAdProgressButton gMg;

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.gGN = null;
        init(context);
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.gGN = null;
        init(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.gGN = null;
        init(context);
    }

    private void init(Context context) {
        this.gMg = (FeedAdProgressButton) LayoutInflater.from(context).inflate(e.h.apk_download_view_layout, (ViewGroup) this, true).findViewById(e.g.feed_ad_operate_progress_button);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.gLw = (DownloadData) downloadData.clone();
            if (this.gLw != null) {
                setTag(this.gLw);
                p(downloadData);
            }
        }
    }

    public void setDefaultText(String str) {
        if (!TextUtils.isEmpty(str) && this.gMg != null) {
            this.gMg.setText(str);
        }
    }

    public void p(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    tG(t(downloadData));
                    return;
                case 2:
                case 7:
                    this.gMg.setText(getResources().getString(e.j.go_on), t(downloadData));
                    return;
                case 3:
                    this.gMg.setText(getResources().getString(e.j.install));
                    return;
                case 4:
                default:
                    return;
                case 5:
                    tG(t(downloadData));
                    return;
                case 6:
                    this.gMg.setText(getResources().getString(e.j.install_app));
                    return;
            }
        }
    }

    public void q(DownloadData downloadData) {
        this.gMg.setText(getResources().getString(e.j.go_on), t(downloadData));
    }

    public void r(DownloadData downloadData) {
        tG(t(downloadData));
    }

    public void s(DownloadData downloadData) {
        this.gMg.setText(getResources().getString(e.j.install_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tG(int i) {
        this.gMg.setProgress(Math.max(0, i));
    }

    public static int t(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = h.bsT().aG(downloadData.getId(), downloadData.getName());
        }
        return Math.max(process, 0);
    }

    public static int getStatus(DownloadData downloadData) {
        d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return (adAdSense == null || adAdSense.Fw()) ? h.getStatus(downloadData) : com.baidu.tieba.recapp.download.d.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        btK();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        btJ();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            btJ();
        } else {
            btK();
        }
    }

    public void onChangeSkinType(int i) {
        this.gMg.onChangeSkinType();
    }

    private void btJ() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.gGN != null) {
            MessageManager.getInstance().registerListener(this.gGN);
        }
    }

    private void btK() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.gGN != null) {
            MessageManager.getInstance().unRegisterListener(this.gGN);
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.gMh.gLw.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.gLw != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(ApkDownloadView.this.gLw.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            int u = ApkDownloadView.this.u(downloadData);
                            if (h.getStatus(downloadData) == 1) {
                                ApkDownloadView.this.tG(u);
                            } else if (h.getStatus(downloadData) == 3) {
                                ApkDownloadView.this.gMg.setText(ApkDownloadView.this.getResources().getString(e.j.install));
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
        if (this.gGN == null) {
            this.gGN = new CustomMessageListener(2016484) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && ApkDownloadView.this.gLw != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (ApkDownloadView.this.gLw.getId() != null && downloadData != null && ApkDownloadView.this.gLw.getId().equals(downloadData.getId())) {
                            ApkDownloadView.this.p(downloadData);
                        }
                    }
                }
            };
            this.gGN.setTag(bdUniqueId);
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
