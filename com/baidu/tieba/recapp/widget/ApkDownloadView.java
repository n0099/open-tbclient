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
public class ApkDownloadView extends FrameLayout implements b {
    private CustomMessageListener downloadListener;
    private CustomMessageListener mKb;
    private DownloadData mOK;
    private FeedAdProgressButton mPA;
    private FeedAdProgressText mPB;
    private b.a mPC;
    private DownloadStatus mPD;
    private a mPz;

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.mKb = null;
        init(context);
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.mKb = null;
        init(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.mKb = null;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.apk_download_view_layout, (ViewGroup) this, true);
        this.mPA = (FeedAdProgressButton) inflate.findViewById(R.id.feed_ad_operate_progress_button);
        this.mPB = (FeedAdProgressText) inflate.findViewById(R.id.feed_ad_operate_progress_text);
        this.mPz = this.mPA;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.mOK = (DownloadData) downloadData.clone();
            if (this.mOK != null) {
                setTag(this.mOK);
                q(downloadData);
            }
        }
    }

    public void setIsPbDownload(boolean z) {
        if (z) {
            this.mPA.setVisibility(8);
            this.mPB.setVisibility(0);
            this.mPz = this.mPB;
            return;
        }
        this.mPB.setVisibility(8);
        this.mPA.setVisibility(0);
        this.mPz = this.mPA;
    }

    public void setDefaultText(String str) {
        if (!TextUtils.isEmpty(str) && this.mPz != null) {
            this.mPz.setButtonText(str);
        }
    }

    public void setTextSize(int i) {
        this.mPz.setButtonTextSize(i);
    }

    public void setTextColorInitSkin(@ColorRes int i) {
        if (this.mPz instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.mPz).setTextColorInitSkin(i);
        }
    }

    public void setBackgroundSkin(@DrawableRes int i) {
        if (this.mPz instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.mPz).setBackgroundSkin(i);
        }
    }

    public void setForegroundSkin(@DrawableRes int i) {
        if (this.mPz instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.mPz).setForeground(i);
        }
    }

    public void setTextColor(int i) {
        this.mPz.setButtonTextColor(i);
    }

    public void setTextNightColor(int i) {
        this.mPz.setButtonTextNightColor(i);
    }

    public void q(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    Jz(u(downloadData));
                    return;
                case 2:
                case 7:
                    this.mPz.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
                    return;
                case 3:
                    this.mPz.setButtonText(getResources().getString(R.string.immediately_install), 0);
                    return;
                case 4:
                default:
                    return;
                case 5:
                    Jz(u(downloadData));
                    return;
                case 6:
                    this.mPz.setButtonText(getResources().getString(R.string.install_app));
                    return;
                case 8:
                    this.mPz.setButtonText(getResources().getString(R.string.immediately_open), 0);
                    return;
            }
        }
    }

    public void r(DownloadData downloadData) {
        this.mPz.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
    }

    public void s(DownloadData downloadData) {
        Jz(u(downloadData));
    }

    public void t(DownloadData downloadData) {
        this.mPz.setButtonText(getResources().getString(R.string.install_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jz(int i) {
        this.mPz.setProgress(Math.max(0, i));
    }

    public static int u(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = i.dFs().ee(downloadData.getId(), downloadData.getName());
        }
        return Math.max(process, 0);
    }

    public static int getStatus(DownloadData downloadData) {
        d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return (adAdSense == null || adAdSense.bxm()) ? i.getStatus(downloadData) : e.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bMs();
        dGB();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bMr();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            bMr();
        } else {
            bMs();
        }
    }

    public void onChangeSkinType(int i) {
        this.mPz.onChangeSkinType();
    }

    public void bvs() {
        this.mPz.bvs();
    }

    private void bMr() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.mKb != null) {
            MessageManager.getInstance().registerListener(this.mKb);
        }
    }

    private void bMs() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.mKb != null) {
            MessageManager.getInstance().unRegisterListener(this.mKb);
        }
    }

    private void dGB() {
        setOnClickInterceptListener(null);
    }

    public void x(BdUniqueId bdUniqueId) {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.mPE.mOK.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.mOK != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(ApkDownloadView.this.mOK.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            int v = ApkDownloadView.this.v(downloadData);
                            if (i.getStatus(downloadData) == 1) {
                                ApkDownloadView.this.Jz(v);
                            } else if (i.getStatus(downloadData) == 3) {
                                ApkDownloadView.this.mPz.setButtonText(ApkDownloadView.this.getResources().getString(R.string.immediately_install));
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
        if (this.mKb == null) {
            this.mKb = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && ApkDownloadView.this.mOK != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (ApkDownloadView.this.mOK.getId() != null && downloadData != null && ApkDownloadView.this.mOK.getId().equals(downloadData.getId())) {
                            ApkDownloadView.this.q(downloadData);
                        }
                    }
                }
            };
            this.mKb.setTag(bdUniqueId);
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
        this.mPD = downloadStatus;
        if (this.mOK != null) {
            this.mOK.setStatus(getDownloadStatus());
            q(this.mOK);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void fu(int i) {
        if (this.mPD == DownloadStatus.STATUS_DOWNLOADING) {
            Jz(i);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void a(DownloadStatus downloadStatus, int i) {
        a(downloadStatus);
        fu(i);
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
    public boolean bZ(View view) {
        if (this.mPC != null) {
            return this.mPC.bZ(view);
        }
        return false;
    }

    public void setOnClickInterceptListener(b.a aVar) {
        this.mPC = aVar;
    }

    public int getDownloadStatus() {
        if (this.mPD == null || this.mPD == DownloadStatus.STATUS_NONE) {
            return 6;
        }
        if (this.mPD == DownloadStatus.STATUS_DOWNLOADING) {
            return 1;
        }
        if (this.mPD == DownloadStatus.STATUS_PAUSED) {
            return 7;
        }
        if (this.mPD == DownloadStatus.STATUS_SUCCESS) {
            return 3;
        }
        return this.mPD == DownloadStatus.STATUS_INSTALL_SUCCESS ? 8 : 6;
    }
}
