package com.baidu.tieba.recapp.widget;

import android.content.Context;
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
/* loaded from: classes3.dex */
public class ApkDownloadView extends FrameLayout implements com.baidu.tieba.ad.download.mvp.b {
    private CustomMessageListener downloadListener;
    private CustomMessageListener iJq;
    private a iOV;
    private FeedAdProgressButton iOW;
    private FeedAdProgressText iOX;
    private b.a iOY;
    private DownloadStatus iOZ;
    private DownloadData iOh;

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.iJq = null;
        init(context);
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.iJq = null;
        init(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.iJq = null;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.apk_download_view_layout, (ViewGroup) this, true);
        this.iOW = (FeedAdProgressButton) inflate.findViewById(R.id.feed_ad_operate_progress_button);
        this.iOX = (FeedAdProgressText) inflate.findViewById(R.id.feed_ad_operate_progress_text);
        this.iOV = this.iOW;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.iOh = (DownloadData) downloadData.clone();
            if (this.iOh != null) {
                setTag(this.iOh);
                q(downloadData);
            }
        }
    }

    public void setIsPbDownload(boolean z) {
        if (z) {
            this.iOW.setVisibility(8);
            this.iOX.setVisibility(0);
            this.iOV = this.iOX;
            return;
        }
        this.iOX.setVisibility(8);
        this.iOW.setVisibility(0);
        this.iOV = this.iOW;
    }

    public void setDefaultText(String str) {
        if (!TextUtils.isEmpty(str) && this.iOV != null) {
            this.iOV.setButtonText(str);
        }
    }

    public void setTextSize(int i) {
        this.iOV.setButtonTextSize(i);
    }

    public void setTextColor(int i) {
        this.iOV.setButtonTextColor(i);
    }

    public void setTextNightColor(int i) {
        this.iOV.setButtonTextNightColor(i);
    }

    public void q(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    yx(u(downloadData));
                    return;
                case 2:
                case 7:
                    this.iOV.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
                    return;
                case 3:
                    this.iOV.setButtonText(getResources().getString(R.string.immediately_install));
                    return;
                case 4:
                default:
                    return;
                case 5:
                    yx(u(downloadData));
                    return;
                case 6:
                    this.iOV.setButtonText(getResources().getString(R.string.install_app));
                    return;
                case 8:
                    this.iOV.setButtonText(getResources().getString(R.string.immediately_open));
                    return;
            }
        }
    }

    public void r(DownloadData downloadData) {
        this.iOV.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
    }

    public void s(DownloadData downloadData) {
        yx(u(downloadData));
    }

    public void t(DownloadData downloadData) {
        this.iOV.setButtonText(getResources().getString(R.string.install_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yx(int i) {
        this.iOV.setProgress(Math.max(0, i));
    }

    public static int u(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = i.cfW().ca(downloadData.getId(), downloadData.getName());
        }
        return Math.max(process, 0);
    }

    public static int getStatus(DownloadData downloadData) {
        d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return (adAdSense == null || adAdSense.aoZ()) ? i.getStatus(downloadData) : e.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aDB();
        cgZ();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aDA();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            aDA();
        } else {
            aDB();
        }
    }

    public void onChangeSkinType(int i) {
        this.iOV.onChangeSkinType();
    }

    public void bno() {
        this.iOV.bno();
    }

    private void aDA() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.iJq != null) {
            MessageManager.getInstance().registerListener(this.iJq);
        }
    }

    private void aDB() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.iJq != null) {
            MessageManager.getInstance().unRegisterListener(this.iJq);
        }
    }

    private void cgZ() {
        setOnClickInterceptListener(null);
    }

    public void t(BdUniqueId bdUniqueId) {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.iPa.iOh.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.iOh != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(ApkDownloadView.this.iOh.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            int v = ApkDownloadView.this.v(downloadData);
                            if (i.getStatus(downloadData) == 1) {
                                ApkDownloadView.this.yx(v);
                            } else if (i.getStatus(downloadData) == 3) {
                                ApkDownloadView.this.iOV.setButtonText(ApkDownloadView.this.getResources().getString(R.string.immediately_install));
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
        if (this.iJq == null) {
            this.iJq = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && ApkDownloadView.this.iOh != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (ApkDownloadView.this.iOh.getId() != null && downloadData != null && ApkDownloadView.this.iOh.getId().equals(downloadData.getId())) {
                            ApkDownloadView.this.q(downloadData);
                        }
                    }
                }
            };
            this.iJq.setTag(bdUniqueId);
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
        this.iOZ = downloadStatus;
        if (this.iOh != null) {
            this.iOh.setStatus(getDownloadStatus());
            q(this.iOh);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void cr(int i) {
        if (this.iOZ == DownloadStatus.STATUS_DOWNLOADING) {
            yx(i);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void a(DownloadStatus downloadStatus, int i) {
        a(downloadStatus);
        cr(i);
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
    public void bo(View view) {
        if (this.iOY != null) {
            this.iOY.bo(view);
        }
    }

    public void setOnClickInterceptListener(b.a aVar) {
        this.iOY = aVar;
    }

    public int getDownloadStatus() {
        if (this.iOZ == null || this.iOZ == DownloadStatus.STATUS_NONE) {
            return 6;
        }
        if (this.iOZ == DownloadStatus.STATUS_DOWNLOADING) {
            return 1;
        }
        if (this.iOZ == DownloadStatus.STATUS_PAUSED) {
            return 7;
        }
        if (this.iOZ == DownloadStatus.STATUS_SUCCESS) {
            return 3;
        }
        return this.iOZ == DownloadStatus.STATUS_INSTALL_SUCCESS ? 8 : 6;
    }
}
