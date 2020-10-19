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
    private CustomMessageListener mcV;
    private DownloadData mhw;
    private a mim;
    private FeedAdProgressButton mio;
    private FeedAdProgressText mip;
    private b.a miq;
    private DownloadStatus mir;

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.mcV = null;
        init(context);
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.mcV = null;
        init(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.mcV = null;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.apk_download_view_layout, (ViewGroup) this, true);
        this.mio = (FeedAdProgressButton) inflate.findViewById(R.id.feed_ad_operate_progress_button);
        this.mip = (FeedAdProgressText) inflate.findViewById(R.id.feed_ad_operate_progress_text);
        this.mim = this.mio;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.mhw = (DownloadData) downloadData.clone();
            if (this.mhw != null) {
                setTag(this.mhw);
                q(downloadData);
            }
        }
    }

    public void setIsPbDownload(boolean z) {
        if (z) {
            this.mio.setVisibility(8);
            this.mip.setVisibility(0);
            this.mim = this.mip;
            return;
        }
        this.mip.setVisibility(8);
        this.mio.setVisibility(0);
        this.mim = this.mio;
    }

    public void setDefaultText(String str) {
        if (!TextUtils.isEmpty(str) && this.mim != null) {
            this.mim.setButtonText(str);
        }
    }

    public void setTextSize(int i) {
        this.mim.setButtonTextSize(i);
    }

    public void setTextColorInitSkin(@ColorRes int i) {
        if (this.mim instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.mim).setTextColorInitSkin(i);
        }
    }

    public void setBackgroundSkin(@DrawableRes int i) {
        if (this.mim instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.mim).setBackgroundSkin(i);
        }
    }

    public void setForegroundSkin(@DrawableRes int i) {
        if (this.mim instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.mim).setForeground(i);
        }
    }

    public void setTextColor(int i) {
        this.mim.setButtonTextColor(i);
    }

    public void setTextNightColor(int i) {
        this.mim.setButtonTextNightColor(i);
    }

    public void q(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    HB(u(downloadData));
                    return;
                case 2:
                case 7:
                    this.mim.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
                    return;
                case 3:
                    this.mim.setButtonText(getResources().getString(R.string.immediately_install), 0);
                    return;
                case 4:
                default:
                    return;
                case 5:
                    HB(u(downloadData));
                    return;
                case 6:
                    this.mim.setButtonText(getResources().getString(R.string.install_app));
                    return;
                case 8:
                    this.mim.setButtonText(getResources().getString(R.string.immediately_open), 0);
                    return;
            }
        }
    }

    public void r(DownloadData downloadData) {
        this.mim.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
    }

    public void s(DownloadData downloadData) {
        HB(u(downloadData));
    }

    public void t(DownloadData downloadData) {
        this.mim.setButtonText(getResources().getString(R.string.install_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HB(int i) {
        this.mim.setProgress(Math.max(0, i));
    }

    public static int u(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = i.duR().dQ(downloadData.getId(), downloadData.getName());
        }
        return Math.max(process, 0);
    }

    public static int getStatus(DownloadData downloadData) {
        d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return (adAdSense == null || adAdSense.bqd()) ? i.getStatus(downloadData) : e.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bEY();
        dwb();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bEX();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            bEX();
        } else {
            bEY();
        }
    }

    public void onChangeSkinType(int i) {
        this.mim.onChangeSkinType();
    }

    public void changeSkin() {
        this.mim.changeSkin();
    }

    private void bEX() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.mcV != null) {
            MessageManager.getInstance().registerListener(this.mcV);
        }
    }

    private void bEY() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.mcV != null) {
            MessageManager.getInstance().unRegisterListener(this.mcV);
        }
    }

    private void dwb() {
        setOnClickInterceptListener(null);
    }

    public void x(BdUniqueId bdUniqueId) {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.mis.mhw.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.mhw != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(ApkDownloadView.this.mhw.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            int v = ApkDownloadView.this.v(downloadData);
                            if (i.getStatus(downloadData) == 1) {
                                ApkDownloadView.this.HB(v);
                            } else if (i.getStatus(downloadData) == 3) {
                                ApkDownloadView.this.mim.setButtonText(ApkDownloadView.this.getResources().getString(R.string.immediately_install));
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
        if (this.mcV == null) {
            this.mcV = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && ApkDownloadView.this.mhw != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (ApkDownloadView.this.mhw.getId() != null && downloadData != null && ApkDownloadView.this.mhw.getId().equals(downloadData.getId())) {
                            ApkDownloadView.this.q(downloadData);
                        }
                    }
                }
            };
            this.mcV.setTag(bdUniqueId);
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
        this.mir = downloadStatus;
        if (this.mhw != null) {
            this.mhw.setStatus(getDownloadStatus());
            q(this.mhw);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void eX(int i) {
        if (this.mir == DownloadStatus.STATUS_DOWNLOADING) {
            HB(i);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void a(DownloadStatus downloadStatus, int i) {
        a(downloadStatus);
        eX(i);
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
    public boolean bK(View view) {
        if (this.miq != null) {
            return this.miq.bK(view);
        }
        return false;
    }

    public void setOnClickInterceptListener(b.a aVar) {
        this.miq = aVar;
    }

    public int getDownloadStatus() {
        if (this.mir == null || this.mir == DownloadStatus.STATUS_NONE) {
            return 6;
        }
        if (this.mir == DownloadStatus.STATUS_DOWNLOADING) {
            return 1;
        }
        if (this.mir == DownloadStatus.STATUS_PAUSED) {
            return 7;
        }
        if (this.mir == DownloadStatus.STATUS_SUCCESS) {
            return 3;
        }
        return this.mir == DownloadStatus.STATUS_INSTALL_SUCCESS ? 8 : 6;
    }
}
