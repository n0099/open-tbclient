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
    private CustomMessageListener ktO;
    private a kyY;
    private FeedAdProgressButton kyZ;
    private DownloadData kyl;
    private FeedAdProgressText kza;
    private b.a kzb;
    private DownloadStatus kzc;

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.ktO = null;
        init(context);
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.ktO = null;
        init(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.ktO = null;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.apk_download_view_layout, (ViewGroup) this, true);
        this.kyZ = (FeedAdProgressButton) inflate.findViewById(R.id.feed_ad_operate_progress_button);
        this.kza = (FeedAdProgressText) inflate.findViewById(R.id.feed_ad_operate_progress_text);
        this.kyY = this.kyZ;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.kyl = (DownloadData) downloadData.clone();
            if (this.kyl != null) {
                setTag(this.kyl);
                q(downloadData);
            }
        }
    }

    public void setIsPbDownload(boolean z) {
        if (z) {
            this.kyZ.setVisibility(8);
            this.kza.setVisibility(0);
            this.kyY = this.kza;
            return;
        }
        this.kza.setVisibility(8);
        this.kyZ.setVisibility(0);
        this.kyY = this.kyZ;
    }

    public void setDefaultText(String str) {
        if (!TextUtils.isEmpty(str) && this.kyY != null) {
            this.kyY.setButtonText(str);
        }
    }

    public void setTextSize(int i) {
        this.kyY.setButtonTextSize(i);
    }

    public void setTextColorInitSkin(@ColorRes int i) {
        if (this.kyY instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.kyY).setTextColorInitSkin(i);
        }
    }

    public void setBackgroundSkin(@DrawableRes int i) {
        if (this.kyY instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.kyY).setBackgroundSkin(i);
        }
    }

    public void setTextColor(int i) {
        this.kyY.setButtonTextColor(i);
    }

    public void setTextNightColor(int i) {
        this.kyY.setButtonTextNightColor(i);
    }

    public void q(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    BP(u(downloadData));
                    return;
                case 2:
                case 7:
                    this.kyY.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
                    return;
                case 3:
                    this.kyY.setButtonText(getResources().getString(R.string.immediately_install), 0);
                    return;
                case 4:
                default:
                    return;
                case 5:
                    BP(u(downloadData));
                    return;
                case 6:
                    this.kyY.setButtonText(getResources().getString(R.string.install_app));
                    return;
                case 8:
                    this.kyY.setButtonText(getResources().getString(R.string.immediately_open), 0);
                    return;
            }
        }
    }

    public void r(DownloadData downloadData) {
        this.kyY.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
    }

    public void s(DownloadData downloadData) {
        BP(u(downloadData));
    }

    public void t(DownloadData downloadData) {
        this.kyY.setButtonText(getResources().getString(R.string.install_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BP(int i) {
        this.kyY.setProgress(Math.max(0, i));
    }

    public static int u(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = i.cNx().cQ(downloadData.getId(), downloadData.getName());
        }
        return Math.max(process, 0);
    }

    public static int getStatus(DownloadData downloadData) {
        d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return (adAdSense == null || adAdSense.aRJ()) ? i.getStatus(downloadData) : e.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bgn();
        cOC();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bgm();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            bgm();
        } else {
            bgn();
        }
    }

    public void onChangeSkinType(int i) {
        this.kyY.onChangeSkinType();
    }

    public void ckM() {
        this.kyY.ckM();
    }

    private void bgm() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.ktO != null) {
            MessageManager.getInstance().registerListener(this.ktO);
        }
    }

    private void bgn() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.ktO != null) {
            MessageManager.getInstance().unRegisterListener(this.ktO);
        }
    }

    private void cOC() {
        setOnClickInterceptListener(null);
    }

    public void u(BdUniqueId bdUniqueId) {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.kzd.kyl.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.kyl != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(ApkDownloadView.this.kyl.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            int v = ApkDownloadView.this.v(downloadData);
                            if (i.getStatus(downloadData) == 1) {
                                ApkDownloadView.this.BP(v);
                            } else if (i.getStatus(downloadData) == 3) {
                                ApkDownloadView.this.kyY.setButtonText(ApkDownloadView.this.getResources().getString(R.string.immediately_install));
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
        if (this.ktO == null) {
            this.ktO = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && ApkDownloadView.this.kyl != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (ApkDownloadView.this.kyl.getId() != null && downloadData != null && ApkDownloadView.this.kyl.getId().equals(downloadData.getId())) {
                            ApkDownloadView.this.q(downloadData);
                        }
                    }
                }
            };
            this.ktO.setTag(bdUniqueId);
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
        this.kzc = downloadStatus;
        if (this.kyl != null) {
            this.kyl.setStatus(getDownloadStatus());
            q(this.kyl);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void dm(int i) {
        if (this.kzc == DownloadStatus.STATUS_DOWNLOADING) {
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
        if (this.kzb != null) {
            this.kzb.bq(view);
        }
    }

    public void setOnClickInterceptListener(b.a aVar) {
        this.kzb = aVar;
    }

    public int getDownloadStatus() {
        if (this.kzc == null || this.kzc == DownloadStatus.STATUS_NONE) {
            return 6;
        }
        if (this.kzc == DownloadStatus.STATUS_DOWNLOADING) {
            return 1;
        }
        if (this.kzc == DownloadStatus.STATUS_PAUSED) {
            return 7;
        }
        if (this.kzc == DownloadStatus.STATUS_SUCCESS) {
            return 3;
        }
        return this.kzc == DownloadStatus.STATUS_INSTALL_SUCCESS ? 8 : 6;
    }
}
