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
/* loaded from: classes11.dex */
public class ApkDownloadView extends FrameLayout implements com.baidu.tieba.ad.download.mvp.b {
    private CustomMessageListener downloadListener;
    private CustomMessageListener jHo;
    private a jMQ;
    private FeedAdProgressButton jMR;
    private FeedAdProgressText jMS;
    private b.a jMT;
    private DownloadStatus jMU;
    private DownloadData jMb;

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.jHo = null;
        init(context);
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.jHo = null;
        init(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.jHo = null;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.apk_download_view_layout, (ViewGroup) this, true);
        this.jMR = (FeedAdProgressButton) inflate.findViewById(R.id.feed_ad_operate_progress_button);
        this.jMS = (FeedAdProgressText) inflate.findViewById(R.id.feed_ad_operate_progress_text);
        this.jMQ = this.jMR;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.jMb = (DownloadData) downloadData.clone();
            if (this.jMb != null) {
                setTag(this.jMb);
                q(downloadData);
            }
        }
    }

    public void setIsPbDownload(boolean z) {
        if (z) {
            this.jMR.setVisibility(8);
            this.jMS.setVisibility(0);
            this.jMQ = this.jMS;
            return;
        }
        this.jMS.setVisibility(8);
        this.jMR.setVisibility(0);
        this.jMQ = this.jMR;
    }

    public void setDefaultText(String str) {
        if (!TextUtils.isEmpty(str) && this.jMQ != null) {
            this.jMQ.setButtonText(str);
        }
    }

    public void setTextSize(int i) {
        this.jMQ.setButtonTextSize(i);
    }

    public void setTextColorInitSkin(@ColorRes int i) {
        if (this.jMQ instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.jMQ).setTextColorInitSkin(i);
        }
    }

    public void setBackgroundSkin(@DrawableRes int i) {
        if (this.jMQ instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.jMQ).setBackgroundSkin(i);
        }
    }

    public void setTextColor(int i) {
        this.jMQ.setButtonTextColor(i);
    }

    public void setTextNightColor(int i) {
        this.jMQ.setButtonTextNightColor(i);
    }

    public void q(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    AY(u(downloadData));
                    return;
                case 2:
                case 7:
                    this.jMQ.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
                    return;
                case 3:
                    this.jMQ.setButtonText(getResources().getString(R.string.immediately_install), 0);
                    return;
                case 4:
                default:
                    return;
                case 5:
                    AY(u(downloadData));
                    return;
                case 6:
                    this.jMQ.setButtonText(getResources().getString(R.string.install_app));
                    return;
                case 8:
                    this.jMQ.setButtonText(getResources().getString(R.string.immediately_open), 0);
                    return;
            }
        }
    }

    public void r(DownloadData downloadData) {
        this.jMQ.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
    }

    public void s(DownloadData downloadData) {
        AY(u(downloadData));
    }

    public void t(DownloadData downloadData) {
        this.jMQ.setButtonText(getResources().getString(R.string.install_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AY(int i) {
        this.jMQ.setProgress(Math.max(0, i));
    }

    public static int u(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = i.cBj().cx(downloadData.getId(), downloadData.getName());
        }
        return Math.max(process, 0);
    }

    public static int getStatus(DownloadData downloadData) {
        d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return (adAdSense == null || adAdSense.aGU()) ? i.getStatus(downloadData) : e.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aVO();
        cCk();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aVN();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            aVN();
        } else {
            aVO();
        }
    }

    public void onChangeSkinType(int i) {
        this.jMQ.onChangeSkinType();
    }

    public void bFO() {
        this.jMQ.bFO();
    }

    private void aVN() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.jHo != null) {
            MessageManager.getInstance().registerListener(this.jHo);
        }
    }

    private void aVO() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.jHo != null) {
            MessageManager.getInstance().unRegisterListener(this.jHo);
        }
    }

    private void cCk() {
        setOnClickInterceptListener(null);
    }

    public void u(BdUniqueId bdUniqueId) {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.jMV.jMb.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.jMb != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(ApkDownloadView.this.jMb.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            int v = ApkDownloadView.this.v(downloadData);
                            if (i.getStatus(downloadData) == 1) {
                                ApkDownloadView.this.AY(v);
                            } else if (i.getStatus(downloadData) == 3) {
                                ApkDownloadView.this.jMQ.setButtonText(ApkDownloadView.this.getResources().getString(R.string.immediately_install));
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
        if (this.jHo == null) {
            this.jHo = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && ApkDownloadView.this.jMb != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (ApkDownloadView.this.jMb.getId() != null && downloadData != null && ApkDownloadView.this.jMb.getId().equals(downloadData.getId())) {
                            ApkDownloadView.this.q(downloadData);
                        }
                    }
                }
            };
            this.jHo.setTag(bdUniqueId);
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
        this.jMU = downloadStatus;
        if (this.jMb != null) {
            this.jMb.setStatus(getDownloadStatus());
            q(this.jMb);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void cH(int i) {
        if (this.jMU == DownloadStatus.STATUS_DOWNLOADING) {
            AY(i);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void a(DownloadStatus downloadStatus, int i) {
        a(downloadStatus);
        cH(i);
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
    public void bp(View view) {
        if (this.jMT != null) {
            this.jMT.bp(view);
        }
    }

    public void setOnClickInterceptListener(b.a aVar) {
        this.jMT = aVar;
    }

    public int getDownloadStatus() {
        if (this.jMU == null || this.jMU == DownloadStatus.STATUS_NONE) {
            return 6;
        }
        if (this.jMU == DownloadStatus.STATUS_DOWNLOADING) {
            return 1;
        }
        if (this.jMU == DownloadStatus.STATUS_PAUSED) {
            return 7;
        }
        if (this.jMU == DownloadStatus.STATUS_SUCCESS) {
            return 3;
        }
        return this.jMU == DownloadStatus.STATUS_INSTALL_SUCCESS ? 8 : 6;
    }
}
