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
/* loaded from: classes26.dex */
public class ApkDownloadView extends FrameLayout implements com.baidu.tieba.ad.download.mvp.b {
    private CustomMessageListener downloadListener;
    private CustomMessageListener mpu;
    private DownloadData mtV;
    private a muK;
    private FeedAdProgressButton muL;
    private FeedAdProgressText muM;
    private b.a muN;
    private DownloadStatus muO;

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.mpu = null;
        init(context);
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.mpu = null;
        init(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.mpu = null;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.apk_download_view_layout, (ViewGroup) this, true);
        this.muL = (FeedAdProgressButton) inflate.findViewById(R.id.feed_ad_operate_progress_button);
        this.muM = (FeedAdProgressText) inflate.findViewById(R.id.feed_ad_operate_progress_text);
        this.muK = this.muL;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.mtV = (DownloadData) downloadData.clone();
            if (this.mtV != null) {
                setTag(this.mtV);
                q(downloadData);
            }
        }
    }

    public void setIsPbDownload(boolean z) {
        if (z) {
            this.muL.setVisibility(8);
            this.muM.setVisibility(0);
            this.muK = this.muM;
            return;
        }
        this.muM.setVisibility(8);
        this.muL.setVisibility(0);
        this.muK = this.muL;
    }

    public void setDefaultText(String str) {
        if (!TextUtils.isEmpty(str) && this.muK != null) {
            this.muK.setButtonText(str);
        }
    }

    public void setTextSize(int i) {
        this.muK.setButtonTextSize(i);
    }

    public void setTextColorInitSkin(@ColorRes int i) {
        if (this.muK instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.muK).setTextColorInitSkin(i);
        }
    }

    public void setBackgroundSkin(@DrawableRes int i) {
        if (this.muK instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.muK).setBackgroundSkin(i);
        }
    }

    public void setForegroundSkin(@DrawableRes int i) {
        if (this.muK instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.muK).setForeground(i);
        }
    }

    public void setTextColor(int i) {
        this.muK.setButtonTextColor(i);
    }

    public void setTextNightColor(int i) {
        this.muK.setButtonTextNightColor(i);
    }

    public void q(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    HU(u(downloadData));
                    return;
                case 2:
                case 7:
                    this.muK.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
                    return;
                case 3:
                    this.muK.setButtonText(getResources().getString(R.string.immediately_install), 0);
                    return;
                case 4:
                default:
                    return;
                case 5:
                    HU(u(downloadData));
                    return;
                case 6:
                    this.muK.setButtonText(getResources().getString(R.string.install_app));
                    return;
                case 8:
                    this.muK.setButtonText(getResources().getString(R.string.immediately_open), 0);
                    return;
            }
        }
    }

    public void r(DownloadData downloadData) {
        this.muK.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
    }

    public void s(DownloadData downloadData) {
        HU(u(downloadData));
    }

    public void t(DownloadData downloadData) {
        this.muK.setButtonText(getResources().getString(R.string.install_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HU(int i) {
        this.muK.setProgress(Math.max(0, i));
    }

    public static int u(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = i.dxY().dX(downloadData.getId(), downloadData.getName());
        }
        return Math.max(process, 0);
    }

    public static int getStatus(DownloadData downloadData) {
        d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return (adAdSense == null || adAdSense.brW()) ? i.getStatus(downloadData) : e.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bGR();
        dzi();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bGQ();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            bGQ();
        } else {
            bGR();
        }
    }

    public void onChangeSkinType(int i) {
        this.muK.onChangeSkinType();
    }

    public void changeSkin() {
        this.muK.changeSkin();
    }

    private void bGQ() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.mpu != null) {
            MessageManager.getInstance().registerListener(this.mpu);
        }
    }

    private void bGR() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.mpu != null) {
            MessageManager.getInstance().unRegisterListener(this.mpu);
        }
    }

    private void dzi() {
        setOnClickInterceptListener(null);
    }

    public void x(BdUniqueId bdUniqueId) {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.muP.mtV.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.mtV != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(ApkDownloadView.this.mtV.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            int v = ApkDownloadView.this.v(downloadData);
                            if (i.getStatus(downloadData) == 1) {
                                ApkDownloadView.this.HU(v);
                            } else if (i.getStatus(downloadData) == 3) {
                                ApkDownloadView.this.muK.setButtonText(ApkDownloadView.this.getResources().getString(R.string.immediately_install));
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
        if (this.mpu == null) {
            this.mpu = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && ApkDownloadView.this.mtV != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (ApkDownloadView.this.mtV.getId() != null && downloadData != null && ApkDownloadView.this.mtV.getId().equals(downloadData.getId())) {
                            ApkDownloadView.this.q(downloadData);
                        }
                    }
                }
            };
            this.mpu.setTag(bdUniqueId);
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
        this.muO = downloadStatus;
        if (this.mtV != null) {
            this.mtV.setStatus(getDownloadStatus());
            q(this.mtV);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void fa(int i) {
        if (this.muO == DownloadStatus.STATUS_DOWNLOADING) {
            HU(i);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void a(DownloadStatus downloadStatus, int i) {
        a(downloadStatus);
        fa(i);
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
    public boolean bL(View view) {
        if (this.muN != null) {
            return this.muN.bL(view);
        }
        return false;
    }

    public void setOnClickInterceptListener(b.a aVar) {
        this.muN = aVar;
    }

    public int getDownloadStatus() {
        if (this.muO == null || this.muO == DownloadStatus.STATUS_NONE) {
            return 6;
        }
        if (this.muO == DownloadStatus.STATUS_DOWNLOADING) {
            return 1;
        }
        if (this.muO == DownloadStatus.STATUS_PAUSED) {
            return 7;
        }
        if (this.muO == DownloadStatus.STATUS_SUCCESS) {
            return 3;
        }
        return this.muO == DownloadStatus.STATUS_INSTALL_SUCCESS ? 8 : 6;
    }
}
