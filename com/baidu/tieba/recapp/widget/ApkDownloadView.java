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
    private CustomMessageListener ktK;
    private a kyU;
    private FeedAdProgressButton kyV;
    private FeedAdProgressText kyW;
    private b.a kyX;
    private DownloadStatus kyY;
    private DownloadData kyh;

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.ktK = null;
        init(context);
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.ktK = null;
        init(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.ktK = null;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.apk_download_view_layout, (ViewGroup) this, true);
        this.kyV = (FeedAdProgressButton) inflate.findViewById(R.id.feed_ad_operate_progress_button);
        this.kyW = (FeedAdProgressText) inflate.findViewById(R.id.feed_ad_operate_progress_text);
        this.kyU = this.kyV;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.kyh = (DownloadData) downloadData.clone();
            if (this.kyh != null) {
                setTag(this.kyh);
                q(downloadData);
            }
        }
    }

    public void setIsPbDownload(boolean z) {
        if (z) {
            this.kyV.setVisibility(8);
            this.kyW.setVisibility(0);
            this.kyU = this.kyW;
            return;
        }
        this.kyW.setVisibility(8);
        this.kyV.setVisibility(0);
        this.kyU = this.kyV;
    }

    public void setDefaultText(String str) {
        if (!TextUtils.isEmpty(str) && this.kyU != null) {
            this.kyU.setButtonText(str);
        }
    }

    public void setTextSize(int i) {
        this.kyU.setButtonTextSize(i);
    }

    public void setTextColorInitSkin(@ColorRes int i) {
        if (this.kyU instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.kyU).setTextColorInitSkin(i);
        }
    }

    public void setBackgroundSkin(@DrawableRes int i) {
        if (this.kyU instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.kyU).setBackgroundSkin(i);
        }
    }

    public void setTextColor(int i) {
        this.kyU.setButtonTextColor(i);
    }

    public void setTextNightColor(int i) {
        this.kyU.setButtonTextNightColor(i);
    }

    public void q(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    BP(u(downloadData));
                    return;
                case 2:
                case 7:
                    this.kyU.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
                    return;
                case 3:
                    this.kyU.setButtonText(getResources().getString(R.string.immediately_install), 0);
                    return;
                case 4:
                default:
                    return;
                case 5:
                    BP(u(downloadData));
                    return;
                case 6:
                    this.kyU.setButtonText(getResources().getString(R.string.install_app));
                    return;
                case 8:
                    this.kyU.setButtonText(getResources().getString(R.string.immediately_open), 0);
                    return;
            }
        }
    }

    public void r(DownloadData downloadData) {
        this.kyU.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
    }

    public void s(DownloadData downloadData) {
        BP(u(downloadData));
    }

    public void t(DownloadData downloadData) {
        this.kyU.setButtonText(getResources().getString(R.string.install_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BP(int i) {
        this.kyU.setProgress(Math.max(0, i));
    }

    public static int u(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = i.cNA().cQ(downloadData.getId(), downloadData.getName());
        }
        return Math.max(process, 0);
    }

    public static int getStatus(DownloadData downloadData) {
        d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return (adAdSense == null || adAdSense.aRM()) ? i.getStatus(downloadData) : e.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bgp();
        cOF();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bgo();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            bgo();
        } else {
            bgp();
        }
    }

    public void onChangeSkinType(int i) {
        this.kyU.onChangeSkinType();
    }

    public void ckO() {
        this.kyU.ckO();
    }

    private void bgo() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.ktK != null) {
            MessageManager.getInstance().registerListener(this.ktK);
        }
    }

    private void bgp() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.ktK != null) {
            MessageManager.getInstance().unRegisterListener(this.ktK);
        }
    }

    private void cOF() {
        setOnClickInterceptListener(null);
    }

    public void u(BdUniqueId bdUniqueId) {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.kyZ.kyh.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.kyh != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(ApkDownloadView.this.kyh.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            int v = ApkDownloadView.this.v(downloadData);
                            if (i.getStatus(downloadData) == 1) {
                                ApkDownloadView.this.BP(v);
                            } else if (i.getStatus(downloadData) == 3) {
                                ApkDownloadView.this.kyU.setButtonText(ApkDownloadView.this.getResources().getString(R.string.immediately_install));
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
        if (this.ktK == null) {
            this.ktK = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && ApkDownloadView.this.kyh != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (ApkDownloadView.this.kyh.getId() != null && downloadData != null && ApkDownloadView.this.kyh.getId().equals(downloadData.getId())) {
                            ApkDownloadView.this.q(downloadData);
                        }
                    }
                }
            };
            this.ktK.setTag(bdUniqueId);
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
        this.kyY = downloadStatus;
        if (this.kyh != null) {
            this.kyh.setStatus(getDownloadStatus());
            q(this.kyh);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void dm(int i) {
        if (this.kyY == DownloadStatus.STATUS_DOWNLOADING) {
            BP(i);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void a(DownloadStatus downloadStatus, int i) {
        a(downloadStatus);
        dm(i);
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
    public void bq(View view) {
        if (this.kyX != null) {
            this.kyX.bq(view);
        }
    }

    public void setOnClickInterceptListener(b.a aVar) {
        this.kyX = aVar;
    }

    public int getDownloadStatus() {
        if (this.kyY == null || this.kyY == DownloadStatus.STATUS_NONE) {
            return 6;
        }
        if (this.kyY == DownloadStatus.STATUS_DOWNLOADING) {
            return 1;
        }
        if (this.kyY == DownloadStatus.STATUS_PAUSED) {
            return 7;
        }
        if (this.kyY == DownloadStatus.STATUS_SUCCESS) {
            return 3;
        }
        return this.kyY == DownloadStatus.STATUS_INSTALL_SUCCESS ? 8 : 6;
    }
}
