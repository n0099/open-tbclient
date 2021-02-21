package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
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
/* loaded from: classes8.dex */
public class ApkDownloadView extends FrameLayout implements b {
    private CustomMessageListener downloadListener;
    private CustomMessageListener mUr;
    private a mZY;
    private FeedAdProgressButton mZZ;
    private DownloadData mZk;
    private FeedAdProgressText naa;
    private b.a nab;
    private DownloadStatus nac;

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.mUr = null;
        init(context);
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.mUr = null;
        init(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.mUr = null;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.apk_download_view_layout, (ViewGroup) this, true);
        this.mZZ = (FeedAdProgressButton) inflate.findViewById(R.id.feed_ad_operate_progress_button);
        this.naa = (FeedAdProgressText) inflate.findViewById(R.id.feed_ad_operate_progress_text);
        this.mZY = this.mZZ;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.mZk = (DownloadData) downloadData.clone();
            if (this.mZk != null) {
                setTag(this.mZk);
                p(downloadData);
            }
        }
    }

    public void setIsPbDownload(boolean z) {
        if (z) {
            this.mZZ.setVisibility(8);
            this.naa.setVisibility(0);
            this.mZY = this.naa;
            return;
        }
        this.naa.setVisibility(8);
        this.mZZ.setVisibility(0);
        this.mZY = this.mZZ;
    }

    public void setDefaultText(String str) {
        if (!TextUtils.isEmpty(str) && this.mZY != null) {
            this.mZY.setButtonText(str);
        }
    }

    public void setTextSize(int i) {
        this.mZY.setButtonTextSize(i);
    }

    public void setTextColorInitSkin(@ColorRes int i) {
        if (this.mZY instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.mZY).setTextColorInitSkin(i);
        }
    }

    public void setBackgroundSkin(@DrawableRes int i) {
        if (this.mZY instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.mZY).setBackgroundSkin(i);
        }
    }

    public void setForegroundSkin(@DrawableRes int i) {
        if (this.mZY instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.mZY).setForeground(i);
        }
    }

    public void setTextColor(int i) {
        this.mZY.setButtonTextColor(i);
    }

    public void setTextNightColor(int i) {
        this.mZY.setButtonTextNightColor(i);
    }

    public void p(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    If(t(downloadData));
                    return;
                case 2:
                case 7:
                    this.mZY.setButtonText(getResources().getString(R.string.go_on_download), t(downloadData));
                    return;
                case 3:
                    this.mZY.setButtonText(getResources().getString(R.string.immediately_install), 0);
                    return;
                case 4:
                default:
                    return;
                case 5:
                    If(t(downloadData));
                    return;
                case 6:
                    this.mZY.setButtonText(getResources().getString(R.string.install_app));
                    return;
                case 8:
                    this.mZY.setButtonText(getResources().getString(R.string.immediately_open), 0);
                    return;
            }
        }
    }

    public void q(DownloadData downloadData) {
        this.mZY.setButtonText(getResources().getString(R.string.go_on_download), t(downloadData));
    }

    public void r(DownloadData downloadData) {
        If(t(downloadData));
    }

    public void s(DownloadData downloadData) {
        this.mZY.setButtonText(getResources().getString(R.string.install_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void If(int i) {
        this.mZY.setProgress(Math.max(0, i));
    }

    public static int t(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = i.dDF().dX(downloadData.getId(), downloadData.getName());
        }
        return Math.max(process, 0);
    }

    public static int getStatus(DownloadData downloadData) {
        d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return (adAdSense == null || adAdSense.bwe()) ? i.getStatus(downloadData) : e.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bLr();
        dER();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bLq();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            bLq();
        } else {
            bLr();
        }
    }

    public void onChangeSkinType(int i) {
        this.mZY.onChangeSkinType();
    }

    public void buo() {
        this.mZY.buo();
    }

    private void bLq() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.mUr != null) {
            MessageManager.getInstance().registerListener(this.mUr);
        }
    }

    private void bLr() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.mUr != null) {
            MessageManager.getInstance().unRegisterListener(this.mUr);
        }
    }

    private void dER() {
        setOnClickInterceptListener(null);
    }

    public void y(BdUniqueId bdUniqueId) {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.nad.mZk.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.mZk != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(ApkDownloadView.this.mZk.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            int u = ApkDownloadView.this.u(downloadData);
                            if (i.getStatus(downloadData) == 1) {
                                ApkDownloadView.this.If(u);
                            } else if (i.getStatus(downloadData) == 3) {
                                ApkDownloadView.this.mZY.setButtonText(ApkDownloadView.this.getResources().getString(R.string.immediately_install));
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
        if (this.mUr == null) {
            this.mUr = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && ApkDownloadView.this.mZk != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (ApkDownloadView.this.mZk.getId() != null && downloadData != null && ApkDownloadView.this.mZk.getId().equals(downloadData.getId())) {
                            ApkDownloadView.this.p(downloadData);
                        }
                    }
                }
            };
            this.mUr.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int u(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        return (int) ((downloadData.getLength() * 100) / downloadData.getSize());
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void a(@NonNull DownloadStatus downloadStatus) {
        this.nac = downloadStatus;
        if (this.mZk != null) {
            this.mZk.setStatus(getDownloadStatus());
            p(this.mZk);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void fn(int i) {
        if (this.nac == DownloadStatus.STATUS_DOWNLOADING) {
            If(i);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void a(DownloadStatus downloadStatus, int i) {
        a(downloadStatus);
        fn(i);
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
    public boolean ce(View view) {
        if (this.nab != null) {
            return this.nab.ce(view);
        }
        return false;
    }

    public void setOnClickInterceptListener(b.a aVar) {
        this.nab = aVar;
    }

    public int getDownloadStatus() {
        if (this.nac == null || this.nac == DownloadStatus.STATUS_NONE) {
            return 6;
        }
        if (this.nac == DownloadStatus.STATUS_DOWNLOADING) {
            return 1;
        }
        if (this.nac == DownloadStatus.STATUS_PAUSED) {
            return 7;
        }
        if (this.nac == DownloadStatus.STATUS_SUCCESS) {
            return 3;
        }
        return this.nac == DownloadStatus.STATUS_INSTALL_SUCCESS ? 8 : 6;
    }
}
