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
    private CustomMessageListener kMQ;
    private DownloadData kRn;
    private a kSa;
    private FeedAdProgressButton kSb;
    private FeedAdProgressText kSc;
    private b.a kSd;
    private DownloadStatus kSe;

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.kMQ = null;
        init(context);
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.kMQ = null;
        init(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.kMQ = null;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.apk_download_view_layout, (ViewGroup) this, true);
        this.kSb = (FeedAdProgressButton) inflate.findViewById(R.id.feed_ad_operate_progress_button);
        this.kSc = (FeedAdProgressText) inflate.findViewById(R.id.feed_ad_operate_progress_text);
        this.kSa = this.kSb;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.kRn = (DownloadData) downloadData.clone();
            if (this.kRn != null) {
                setTag(this.kRn);
                q(downloadData);
            }
        }
    }

    public void setIsPbDownload(boolean z) {
        if (z) {
            this.kSb.setVisibility(8);
            this.kSc.setVisibility(0);
            this.kSa = this.kSc;
            return;
        }
        this.kSc.setVisibility(8);
        this.kSb.setVisibility(0);
        this.kSa = this.kSb;
    }

    public void setDefaultText(String str) {
        if (!TextUtils.isEmpty(str) && this.kSa != null) {
            this.kSa.setButtonText(str);
        }
    }

    public void setTextSize(int i) {
        this.kSa.setButtonTextSize(i);
    }

    public void setTextColorInitSkin(@ColorRes int i) {
        if (this.kSa instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.kSa).setTextColorInitSkin(i);
        }
    }

    public void setBackgroundSkin(@DrawableRes int i) {
        if (this.kSa instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.kSa).setBackgroundSkin(i);
        }
    }

    public void setTextColor(int i) {
        this.kSa.setButtonTextColor(i);
    }

    public void setTextNightColor(int i) {
        this.kSa.setButtonTextNightColor(i);
    }

    public void q(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    CB(u(downloadData));
                    return;
                case 2:
                case 7:
                    this.kSa.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
                    return;
                case 3:
                    this.kSa.setButtonText(getResources().getString(R.string.immediately_install), 0);
                    return;
                case 4:
                default:
                    return;
                case 5:
                    CB(u(downloadData));
                    return;
                case 6:
                    this.kSa.setButtonText(getResources().getString(R.string.install_app));
                    return;
                case 8:
                    this.kSa.setButtonText(getResources().getString(R.string.immediately_open), 0);
                    return;
            }
        }
    }

    public void r(DownloadData downloadData) {
        this.kSa.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
    }

    public void s(DownloadData downloadData) {
        CB(u(downloadData));
    }

    public void t(DownloadData downloadData) {
        this.kSa.setButtonText(getResources().getString(R.string.install_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CB(int i) {
        this.kSa.setProgress(Math.max(0, i));
    }

    public static int u(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = i.cUO().dp(downloadData.getId(), downloadData.getName());
        }
        return Math.max(process, 0);
    }

    public static int getStatus(DownloadData downloadData) {
        d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return (adAdSense == null || adAdSense.aXR()) ? i.getStatus(downloadData) : e.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bmA();
        cVU();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bmz();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            bmz();
        } else {
            bmA();
        }
    }

    public void onChangeSkinType(int i) {
        this.kSa.onChangeSkinType();
    }

    public void crv() {
        this.kSa.crv();
    }

    private void bmz() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.kMQ != null) {
            MessageManager.getInstance().registerListener(this.kMQ);
        }
    }

    private void bmA() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.kMQ != null) {
            MessageManager.getInstance().unRegisterListener(this.kMQ);
        }
    }

    private void cVU() {
        setOnClickInterceptListener(null);
    }

    public void x(BdUniqueId bdUniqueId) {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.kSf.kRn.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.kRn != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(ApkDownloadView.this.kRn.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            int v = ApkDownloadView.this.v(downloadData);
                            if (i.getStatus(downloadData) == 1) {
                                ApkDownloadView.this.CB(v);
                            } else if (i.getStatus(downloadData) == 3) {
                                ApkDownloadView.this.kSa.setButtonText(ApkDownloadView.this.getResources().getString(R.string.immediately_install));
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
        if (this.kMQ == null) {
            this.kMQ = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && ApkDownloadView.this.kRn != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (ApkDownloadView.this.kRn.getId() != null && downloadData != null && ApkDownloadView.this.kRn.getId().equals(downloadData.getId())) {
                            ApkDownloadView.this.q(downloadData);
                        }
                    }
                }
            };
            this.kMQ.setTag(bdUniqueId);
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
        this.kSe = downloadStatus;
        if (this.kRn != null) {
            this.kRn.setStatus(getDownloadStatus());
            q(this.kRn);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void dt(int i) {
        if (this.kSe == DownloadStatus.STATUS_DOWNLOADING) {
            CB(i);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void a(DownloadStatus downloadStatus, int i) {
        a(downloadStatus);
        dt(i);
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
    public void br(View view) {
        if (this.kSd != null) {
            this.kSd.br(view);
        }
    }

    public void setOnClickInterceptListener(b.a aVar) {
        this.kSd = aVar;
    }

    public int getDownloadStatus() {
        if (this.kSe == null || this.kSe == DownloadStatus.STATUS_NONE) {
            return 6;
        }
        if (this.kSe == DownloadStatus.STATUS_DOWNLOADING) {
            return 1;
        }
        if (this.kSe == DownloadStatus.STATUS_PAUSED) {
            return 7;
        }
        if (this.kSe == DownloadStatus.STATUS_SUCCESS) {
            return 3;
        }
        return this.kSe == DownloadStatus.STATUS_INSTALL_SUCCESS ? 8 : 6;
    }
}
