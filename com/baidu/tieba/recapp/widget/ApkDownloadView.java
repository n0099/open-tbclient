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
    private CustomMessageListener mPh;
    private DownloadData mTV;
    private a mUM;
    private FeedAdProgressButton mUN;
    private FeedAdProgressText mUO;
    private b.a mUP;
    private DownloadStatus mUQ;

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.mPh = null;
        init(context);
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.mPh = null;
        init(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.mPh = null;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.apk_download_view_layout, (ViewGroup) this, true);
        this.mUN = (FeedAdProgressButton) inflate.findViewById(R.id.feed_ad_operate_progress_button);
        this.mUO = (FeedAdProgressText) inflate.findViewById(R.id.feed_ad_operate_progress_text);
        this.mUM = this.mUN;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.mTV = (DownloadData) downloadData.clone();
            if (this.mTV != null) {
                setTag(this.mTV);
                q(downloadData);
            }
        }
    }

    public void setIsPbDownload(boolean z) {
        if (z) {
            this.mUN.setVisibility(8);
            this.mUO.setVisibility(0);
            this.mUM = this.mUO;
            return;
        }
        this.mUO.setVisibility(8);
        this.mUN.setVisibility(0);
        this.mUM = this.mUN;
    }

    public void setDefaultText(String str) {
        if (!TextUtils.isEmpty(str) && this.mUM != null) {
            this.mUM.setButtonText(str);
        }
    }

    public void setTextSize(int i) {
        this.mUM.setButtonTextSize(i);
    }

    public void setTextColorInitSkin(@ColorRes int i) {
        if (this.mUM instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.mUM).setTextColorInitSkin(i);
        }
    }

    public void setBackgroundSkin(@DrawableRes int i) {
        if (this.mUM instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.mUM).setBackgroundSkin(i);
        }
    }

    public void setForegroundSkin(@DrawableRes int i) {
        if (this.mUM instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.mUM).setForeground(i);
        }
    }

    public void setTextColor(int i) {
        this.mUM.setButtonTextColor(i);
    }

    public void setTextNightColor(int i) {
        this.mUM.setButtonTextNightColor(i);
    }

    public void q(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    Jt(u(downloadData));
                    return;
                case 2:
                case 7:
                    this.mUM.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
                    return;
                case 3:
                    this.mUM.setButtonText(getResources().getString(R.string.immediately_install), 0);
                    return;
                case 4:
                default:
                    return;
                case 5:
                    Jt(u(downloadData));
                    return;
                case 6:
                    this.mUM.setButtonText(getResources().getString(R.string.install_app));
                    return;
                case 8:
                    this.mUM.setButtonText(getResources().getString(R.string.immediately_open), 0);
                    return;
            }
        }
    }

    public void r(DownloadData downloadData) {
        this.mUM.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
    }

    public void s(DownloadData downloadData) {
        Jt(u(downloadData));
    }

    public void t(DownloadData downloadData) {
        this.mUM.setButtonText(getResources().getString(R.string.install_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jt(int i) {
        this.mUM.setProgress(Math.max(0, i));
    }

    public static int u(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = i.dFi().ed(downloadData.getId(), downloadData.getName());
        }
        return Math.max(process, 0);
    }

    public static int getStatus(DownloadData downloadData) {
        d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return (adAdSense == null || adAdSense.bzF()) ? i.getStatus(downloadData) : e.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bOK();
        dGr();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bOJ();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            bOJ();
        } else {
            bOK();
        }
    }

    public void onChangeSkinType(int i) {
        this.mUM.onChangeSkinType();
    }

    public void bxO() {
        this.mUM.bxO();
    }

    private void bOJ() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.mPh != null) {
            MessageManager.getInstance().registerListener(this.mPh);
        }
    }

    private void bOK() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.mPh != null) {
            MessageManager.getInstance().unRegisterListener(this.mPh);
        }
    }

    private void dGr() {
        setOnClickInterceptListener(null);
    }

    public void x(BdUniqueId bdUniqueId) {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.mUR.mTV.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.mTV != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(ApkDownloadView.this.mTV.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            int v = ApkDownloadView.this.v(downloadData);
                            if (i.getStatus(downloadData) == 1) {
                                ApkDownloadView.this.Jt(v);
                            } else if (i.getStatus(downloadData) == 3) {
                                ApkDownloadView.this.mUM.setButtonText(ApkDownloadView.this.getResources().getString(R.string.immediately_install));
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
        if (this.mPh == null) {
            this.mPh = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && ApkDownloadView.this.mTV != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (ApkDownloadView.this.mTV.getId() != null && downloadData != null && ApkDownloadView.this.mTV.getId().equals(downloadData.getId())) {
                            ApkDownloadView.this.q(downloadData);
                        }
                    }
                }
            };
            this.mPh.setTag(bdUniqueId);
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
        this.mUQ = downloadStatus;
        if (this.mTV != null) {
            this.mTV.setStatus(getDownloadStatus());
            q(this.mTV);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void fu(int i) {
        if (this.mUQ == DownloadStatus.STATUS_DOWNLOADING) {
            Jt(i);
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
    public boolean ci(View view) {
        if (this.mUP != null) {
            return this.mUP.ci(view);
        }
        return false;
    }

    public void setOnClickInterceptListener(b.a aVar) {
        this.mUP = aVar;
    }

    public int getDownloadStatus() {
        if (this.mUQ == null || this.mUQ == DownloadStatus.STATUS_NONE) {
            return 6;
        }
        if (this.mUQ == DownloadStatus.STATUS_DOWNLOADING) {
            return 1;
        }
        if (this.mUQ == DownloadStatus.STATUS_PAUSED) {
            return 7;
        }
        if (this.mUQ == DownloadStatus.STATUS_SUCCESS) {
            return 3;
        }
        return this.mUQ == DownloadStatus.STATUS_INSTALL_SUCCESS ? 8 : 6;
    }
}
