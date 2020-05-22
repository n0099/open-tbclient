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
    private CustomMessageListener kLH;
    private a kQR;
    private FeedAdProgressButton kQS;
    private FeedAdProgressText kQT;
    private b.a kQU;
    private DownloadStatus kQV;
    private DownloadData kQe;

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.kLH = null;
        init(context);
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.kLH = null;
        init(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.kLH = null;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.apk_download_view_layout, (ViewGroup) this, true);
        this.kQS = (FeedAdProgressButton) inflate.findViewById(R.id.feed_ad_operate_progress_button);
        this.kQT = (FeedAdProgressText) inflate.findViewById(R.id.feed_ad_operate_progress_text);
        this.kQR = this.kQS;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.kQe = (DownloadData) downloadData.clone();
            if (this.kQe != null) {
                setTag(this.kQe);
                q(downloadData);
            }
        }
    }

    public void setIsPbDownload(boolean z) {
        if (z) {
            this.kQS.setVisibility(8);
            this.kQT.setVisibility(0);
            this.kQR = this.kQT;
            return;
        }
        this.kQT.setVisibility(8);
        this.kQS.setVisibility(0);
        this.kQR = this.kQS;
    }

    public void setDefaultText(String str) {
        if (!TextUtils.isEmpty(str) && this.kQR != null) {
            this.kQR.setButtonText(str);
        }
    }

    public void setTextSize(int i) {
        this.kQR.setButtonTextSize(i);
    }

    public void setTextColorInitSkin(@ColorRes int i) {
        if (this.kQR instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.kQR).setTextColorInitSkin(i);
        }
    }

    public void setBackgroundSkin(@DrawableRes int i) {
        if (this.kQR instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.kQR).setBackgroundSkin(i);
        }
    }

    public void setTextColor(int i) {
        this.kQR.setButtonTextColor(i);
    }

    public void setTextNightColor(int i) {
        this.kQR.setButtonTextNightColor(i);
    }

    public void q(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    Cz(u(downloadData));
                    return;
                case 2:
                case 7:
                    this.kQR.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
                    return;
                case 3:
                    this.kQR.setButtonText(getResources().getString(R.string.immediately_install), 0);
                    return;
                case 4:
                default:
                    return;
                case 5:
                    Cz(u(downloadData));
                    return;
                case 6:
                    this.kQR.setButtonText(getResources().getString(R.string.install_app));
                    return;
                case 8:
                    this.kQR.setButtonText(getResources().getString(R.string.immediately_open), 0);
                    return;
            }
        }
    }

    public void r(DownloadData downloadData) {
        this.kQR.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
    }

    public void s(DownloadData downloadData) {
        Cz(u(downloadData));
    }

    public void t(DownloadData downloadData) {
        this.kQR.setButtonText(getResources().getString(R.string.install_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cz(int i) {
        this.kQR.setProgress(Math.max(0, i));
    }

    public static int u(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = i.cUy().dp(downloadData.getId(), downloadData.getName());
        }
        return Math.max(process, 0);
    }

    public static int getStatus(DownloadData downloadData) {
        d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return (adAdSense == null || adAdSense.aXQ()) ? i.getStatus(downloadData) : e.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bmy();
        cVE();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bmx();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            bmx();
        } else {
            bmy();
        }
    }

    public void onChangeSkinType(int i) {
        this.kQR.onChangeSkinType();
    }

    public void crm() {
        this.kQR.crm();
    }

    private void bmx() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.kLH != null) {
            MessageManager.getInstance().registerListener(this.kLH);
        }
    }

    private void bmy() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.kLH != null) {
            MessageManager.getInstance().unRegisterListener(this.kLH);
        }
    }

    private void cVE() {
        setOnClickInterceptListener(null);
    }

    public void x(BdUniqueId bdUniqueId) {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.kQW.kQe.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.kQe != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(ApkDownloadView.this.kQe.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            int v = ApkDownloadView.this.v(downloadData);
                            if (i.getStatus(downloadData) == 1) {
                                ApkDownloadView.this.Cz(v);
                            } else if (i.getStatus(downloadData) == 3) {
                                ApkDownloadView.this.kQR.setButtonText(ApkDownloadView.this.getResources().getString(R.string.immediately_install));
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
        if (this.kLH == null) {
            this.kLH = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && ApkDownloadView.this.kQe != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (ApkDownloadView.this.kQe.getId() != null && downloadData != null && ApkDownloadView.this.kQe.getId().equals(downloadData.getId())) {
                            ApkDownloadView.this.q(downloadData);
                        }
                    }
                }
            };
            this.kLH.setTag(bdUniqueId);
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
        this.kQV = downloadStatus;
        if (this.kQe != null) {
            this.kQe.setStatus(getDownloadStatus());
            q(this.kQe);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void dr(int i) {
        if (this.kQV == DownloadStatus.STATUS_DOWNLOADING) {
            Cz(i);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void a(DownloadStatus downloadStatus, int i) {
        a(downloadStatus);
        dr(i);
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
        if (this.kQU != null) {
            this.kQU.br(view);
        }
    }

    public void setOnClickInterceptListener(b.a aVar) {
        this.kQU = aVar;
    }

    public int getDownloadStatus() {
        if (this.kQV == null || this.kQV == DownloadStatus.STATUS_NONE) {
            return 6;
        }
        if (this.kQV == DownloadStatus.STATUS_DOWNLOADING) {
            return 1;
        }
        if (this.kQV == DownloadStatus.STATUS_PAUSED) {
            return 7;
        }
        if (this.kQV == DownloadStatus.STATUS_SUCCESS) {
            return 3;
        }
        return this.kQV == DownloadStatus.STATUS_INSTALL_SUCCESS ? 8 : 6;
    }
}
