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
    private CustomMessageListener glp;
    private DownloadData gpY;
    private FeedAdProgressButton gqJ;

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.glp = null;
        init(context);
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.glp = null;
        init(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.glp = null;
        init(context);
    }

    private void init(Context context) {
        this.gqJ = (FeedAdProgressButton) LayoutInflater.from(context).inflate(d.i.apk_download_view_layout, (ViewGroup) this, true).findViewById(d.g.feed_ad_operate_progress_button);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.gpY = (DownloadData) downloadData.clone();
            if (this.gpY != null) {
                setTag(this.gpY);
                s(downloadData);
            }
        }
    }

    public void setDefaultText(String str) {
        if (!TextUtils.isEmpty(str) && this.gqJ != null) {
            this.gqJ.setText(str);
        }
    }

    public void s(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    sk(v(downloadData));
                    return;
                case 2:
                case 7:
                    this.gqJ.setText(getResources().getString(d.k.go_on), v(downloadData));
                    return;
                case 3:
                    this.gqJ.setText(getResources().getString(d.k.install));
                    return;
                case 4:
                default:
                    return;
                case 5:
                    sk(v(downloadData));
                    return;
                case 6:
                    this.gqJ.setText(getResources().getString(d.k.install_app));
                    return;
            }
        }
    }

    public void t(DownloadData downloadData) {
        this.gqJ.setText(getResources().getString(d.k.go_on), v(downloadData));
    }

    public void h(DownloadData downloadData) {
        sk(v(downloadData));
    }

    public void u(DownloadData downloadData) {
        this.gqJ.setText(getResources().getString(d.k.install_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sk(int i) {
        this.gqJ.setProgress(Math.max(0, i));
    }

    public static int v(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = h.bov().aq(downloadData.getId(), downloadData.getName());
        }
        return Math.max(process, 0);
    }

    public static int getStatus(DownloadData downloadData) {
        c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return (adAdSense == null || adAdSense.BN()) ? h.getStatus(downloadData) : com.baidu.tieba.recapp.download.d.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bpl();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bpk();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            bpk();
        } else {
            bpl();
        }
    }

    public void onChangeSkinType(int i) {
        this.gqJ.onChangeSkinType();
    }

    private void bpk() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.glp != null) {
            MessageManager.getInstance().registerListener(this.glp);
        }
    }

    private void bpl() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.glp != null) {
            MessageManager.getInstance().unRegisterListener(this.glp);
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.gqK.gpY.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.gpY != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(ApkDownloadView.this.gpY.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            int w = ApkDownloadView.this.w(downloadData);
                            if (h.getStatus(downloadData) == 1) {
                                ApkDownloadView.this.sk(w);
                            } else if (h.getStatus(downloadData) == 3) {
                                ApkDownloadView.this.gqJ.setText(ApkDownloadView.this.getResources().getString(d.k.install));
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
        if (this.glp == null) {
            this.glp = new CustomMessageListener(2016484) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && ApkDownloadView.this.gpY != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (ApkDownloadView.this.gpY.getId() != null && downloadData != null && ApkDownloadView.this.gpY.getId().equals(downloadData.getId())) {
                            ApkDownloadView.this.s(downloadData);
                        }
                    }
                }
            };
            this.glp.setTag(bdUniqueId);
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
