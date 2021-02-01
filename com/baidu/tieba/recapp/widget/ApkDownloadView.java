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
    private CustomMessageListener mTP;
    private DownloadData mYK;
    private FeedAdProgressText mZA;
    private b.a mZB;
    private DownloadStatus mZC;
    private a mZy;
    private FeedAdProgressButton mZz;

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.mTP = null;
        init(context);
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.mTP = null;
        init(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.mTP = null;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.apk_download_view_layout, (ViewGroup) this, true);
        this.mZz = (FeedAdProgressButton) inflate.findViewById(R.id.feed_ad_operate_progress_button);
        this.mZA = (FeedAdProgressText) inflate.findViewById(R.id.feed_ad_operate_progress_text);
        this.mZy = this.mZz;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.mYK = (DownloadData) downloadData.clone();
            if (this.mYK != null) {
                setTag(this.mYK);
                q(downloadData);
            }
        }
    }

    public void setIsPbDownload(boolean z) {
        if (z) {
            this.mZz.setVisibility(8);
            this.mZA.setVisibility(0);
            this.mZy = this.mZA;
            return;
        }
        this.mZA.setVisibility(8);
        this.mZz.setVisibility(0);
        this.mZy = this.mZz;
    }

    public void setDefaultText(String str) {
        if (!TextUtils.isEmpty(str) && this.mZy != null) {
            this.mZy.setButtonText(str);
        }
    }

    public void setTextSize(int i) {
        this.mZy.setButtonTextSize(i);
    }

    public void setTextColorInitSkin(@ColorRes int i) {
        if (this.mZy instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.mZy).setTextColorInitSkin(i);
        }
    }

    public void setBackgroundSkin(@DrawableRes int i) {
        if (this.mZy instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.mZy).setBackgroundSkin(i);
        }
    }

    public void setForegroundSkin(@DrawableRes int i) {
        if (this.mZy instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.mZy).setForeground(i);
        }
    }

    public void setTextColor(int i) {
        this.mZy.setButtonTextColor(i);
    }

    public void setTextNightColor(int i) {
        this.mZy.setButtonTextNightColor(i);
    }

    public void q(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    If(u(downloadData));
                    return;
                case 2:
                case 7:
                    this.mZy.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
                    return;
                case 3:
                    this.mZy.setButtonText(getResources().getString(R.string.immediately_install), 0);
                    return;
                case 4:
                default:
                    return;
                case 5:
                    If(u(downloadData));
                    return;
                case 6:
                    this.mZy.setButtonText(getResources().getString(R.string.install_app));
                    return;
                case 8:
                    this.mZy.setButtonText(getResources().getString(R.string.immediately_open), 0);
                    return;
            }
        }
    }

    public void r(DownloadData downloadData) {
        this.mZy.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
    }

    public void s(DownloadData downloadData) {
        If(u(downloadData));
    }

    public void t(DownloadData downloadData) {
        this.mZy.setButtonText(getResources().getString(R.string.install_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void If(int i) {
        this.mZy.setProgress(Math.max(0, i));
    }

    public static int u(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = i.dDz().dX(downloadData.getId(), downloadData.getName());
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
        bLm();
        dEJ();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bLl();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            bLl();
        } else {
            bLm();
        }
    }

    public void onChangeSkinType(int i) {
        this.mZy.onChangeSkinType();
    }

    public void buo() {
        this.mZy.buo();
    }

    private void bLl() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.mTP != null) {
            MessageManager.getInstance().registerListener(this.mTP);
        }
    }

    private void bLm() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.mTP != null) {
            MessageManager.getInstance().unRegisterListener(this.mTP);
        }
    }

    private void dEJ() {
        setOnClickInterceptListener(null);
    }

    public void y(BdUniqueId bdUniqueId) {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.mZD.mYK.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.mYK != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(ApkDownloadView.this.mYK.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            int v = ApkDownloadView.this.v(downloadData);
                            if (i.getStatus(downloadData) == 1) {
                                ApkDownloadView.this.If(v);
                            } else if (i.getStatus(downloadData) == 3) {
                                ApkDownloadView.this.mZy.setButtonText(ApkDownloadView.this.getResources().getString(R.string.immediately_install));
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
        if (this.mTP == null) {
            this.mTP = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && ApkDownloadView.this.mYK != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (ApkDownloadView.this.mYK.getId() != null && downloadData != null && ApkDownloadView.this.mYK.getId().equals(downloadData.getId())) {
                            ApkDownloadView.this.q(downloadData);
                        }
                    }
                }
            };
            this.mTP.setTag(bdUniqueId);
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
        this.mZC = downloadStatus;
        if (this.mYK != null) {
            this.mYK.setStatus(getDownloadStatus());
            q(this.mYK);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void fn(int i) {
        if (this.mZC == DownloadStatus.STATUS_DOWNLOADING) {
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
        if (this.mZB != null) {
            return this.mZB.ce(view);
        }
        return false;
    }

    public void setOnClickInterceptListener(b.a aVar) {
        this.mZB = aVar;
    }

    public int getDownloadStatus() {
        if (this.mZC == null || this.mZC == DownloadStatus.STATUS_NONE) {
            return 6;
        }
        if (this.mZC == DownloadStatus.STATUS_DOWNLOADING) {
            return 1;
        }
        if (this.mZC == DownloadStatus.STATUS_PAUSED) {
            return 7;
        }
        if (this.mZC == DownloadStatus.STATUS_SUCCESS) {
            return 3;
        }
        return this.mZC == DownloadStatus.STATUS_INSTALL_SUCCESS ? 8 : 6;
    }
}
