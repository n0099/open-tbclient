package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.d;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.recapp.download.e;
import com.baidu.tieba.recapp.download.i;
import java.util.List;
/* loaded from: classes13.dex */
public class ApkDownloadView extends FrameLayout implements com.baidu.tieba.ad.download.mvp.b {
    private CustomMessageListener downloadListener;
    private CustomMessageListener jIk;
    private DownloadData jMX;
    private a jNQ;
    private FeedAdProgressButton jNR;
    private FeedAdProgressText jNS;
    private b.a jNT;
    private DownloadStatus jNU;

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.jIk = null;
        init(context);
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.jIk = null;
        init(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.jIk = null;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.apk_download_view_layout, (ViewGroup) this, true);
        this.jNR = (FeedAdProgressButton) inflate.findViewById(R.id.feed_ad_operate_progress_button);
        this.jNS = (FeedAdProgressText) inflate.findViewById(R.id.feed_ad_operate_progress_text);
        this.jNQ = this.jNR;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.jMX = (DownloadData) downloadData.clone();
            if (this.jMX != null) {
                setTag(this.jMX);
                q(downloadData);
            }
        }
    }

    public void setIsPbDownload(boolean z) {
        if (z) {
            this.jNR.setVisibility(8);
            this.jNS.setVisibility(0);
            this.jNQ = this.jNS;
            return;
        }
        this.jNS.setVisibility(8);
        this.jNR.setVisibility(0);
        this.jNQ = this.jNR;
    }

    public void setDefaultText(String str) {
        if (!TextUtils.isEmpty(str) && this.jNQ != null) {
            this.jNQ.setButtonText(str);
        }
    }

    public void setTextSize(int i) {
        this.jNQ.setButtonTextSize(i);
    }

    public void setTextColorInitSkin(@ColorRes int i) {
        if (this.jNQ instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.jNQ).setTextColorInitSkin(i);
        }
    }

    public void setBackgroundSkin(@DrawableRes int i) {
        if (this.jNQ instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.jNQ).setBackgroundSkin(i);
        }
    }

    public void setTextColor(int i) {
        this.jNQ.setButtonTextColor(i);
    }

    public void setTextNightColor(int i) {
        this.jNQ.setButtonTextNightColor(i);
    }

    public void q(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    Bh(u(downloadData));
                    return;
                case 2:
                case 7:
                    this.jNQ.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
                    return;
                case 3:
                    this.jNQ.setButtonText(getResources().getString(R.string.immediately_install), 0);
                    return;
                case 4:
                default:
                    return;
                case 5:
                    Bh(u(downloadData));
                    return;
                case 6:
                    this.jNQ.setButtonText(getResources().getString(R.string.install_app));
                    return;
                case 8:
                    this.jNQ.setButtonText(getResources().getString(R.string.immediately_open), 0);
                    return;
            }
        }
    }

    public void r(DownloadData downloadData) {
        this.jNQ.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
    }

    public void s(DownloadData downloadData) {
        Bh(u(downloadData));
    }

    public void t(DownloadData downloadData) {
        this.jNQ.setButtonText(getResources().getString(R.string.install_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bh(int i) {
        this.jNQ.setProgress(Math.max(0, i));
    }

    public static int u(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = i.cCF().cG(downloadData.getId(), downloadData.getName());
        }
        return Math.max(process, 0);
    }

    public static int getStatus(DownloadData downloadData) {
        d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return (adAdSense == null || adAdSense.aJi()) ? i.getStatus(downloadData) : e.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aYd();
        cDH();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aYc();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            aYc();
        } else {
            aYd();
        }
    }

    public void onChangeSkinType(int i) {
        this.jNQ.onChangeSkinType();
    }

    public void bHq() {
        this.jNQ.bHq();
    }

    private void aYc() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.jIk != null) {
            MessageManager.getInstance().registerListener(this.jIk);
        }
    }

    private void aYd() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.jIk != null) {
            MessageManager.getInstance().unRegisterListener(this.jIk);
        }
    }

    private void cDH() {
        setOnClickInterceptListener(null);
    }

    public void u(BdUniqueId bdUniqueId) {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.jNV.jMX.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.jMX != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(ApkDownloadView.this.jMX.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            int v = ApkDownloadView.this.v(downloadData);
                            if (i.getStatus(downloadData) == 1) {
                                ApkDownloadView.this.Bh(v);
                            } else if (i.getStatus(downloadData) == 3) {
                                ApkDownloadView.this.jNQ.setButtonText(ApkDownloadView.this.getResources().getString(R.string.immediately_install));
                            } else {
                                ApkDownloadView.this.r(downloadData);
                            }
                            ApkDownloadView.this.postInvalidate();
                        }
                    }
                }
            };
            this.downloadListener.setTag(bdUniqueId);
        }
        if (this.jIk == null) {
            this.jIk = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && ApkDownloadView.this.jMX != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (ApkDownloadView.this.jMX.getId() != null && downloadData != null && ApkDownloadView.this.jMX.getId().equals(downloadData.getId())) {
                            ApkDownloadView.this.q(downloadData);
                        }
                    }
                }
            };
            this.jIk.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int v(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        return (int) ((downloadData.getLength() * 100) / downloadData.getSize());
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void a(@NonNull DownloadStatus downloadStatus) {
        this.jNU = downloadStatus;
        if (this.jMX != null) {
            this.jMX.setStatus(getDownloadStatus());
            q(this.jMX);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void cX(int i) {
        if (this.jNU == DownloadStatus.STATUS_DOWNLOADING) {
            Bh(i);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void a(DownloadStatus downloadStatus, int i) {
        a(downloadStatus);
        cX(i);
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    @NonNull
    public View getRealView() {
        return this;
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public View getActionBar() {
        return this;
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void bp(View view) {
        if (this.jNT != null) {
            this.jNT.bp(view);
        }
    }

    public void setOnClickInterceptListener(b.a aVar) {
        this.jNT = aVar;
    }

    public int getDownloadStatus() {
        if (this.jNU == null || this.jNU == DownloadStatus.STATUS_NONE) {
            return 6;
        }
        if (this.jNU == DownloadStatus.STATUS_DOWNLOADING) {
            return 1;
        }
        if (this.jNU == DownloadStatus.STATUS_PAUSED) {
            return 7;
        }
        if (this.jNU == DownloadStatus.STATUS_SUCCESS) {
            return 3;
        }
        return this.jNU == DownloadStatus.STATUS_INSTALL_SUCCESS ? 8 : 6;
    }
}
