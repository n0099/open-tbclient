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
    private CustomMessageListener iKh;
    private DownloadData iOY;
    private a iPM;
    private FeedAdProgressButton iPN;
    private FeedAdProgressText iPO;
    private b.a iPP;
    private DownloadStatus iPQ;

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.iKh = null;
        init(context);
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.iKh = null;
        init(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.iKh = null;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.apk_download_view_layout, (ViewGroup) this, true);
        this.iPN = (FeedAdProgressButton) inflate.findViewById(R.id.feed_ad_operate_progress_button);
        this.iPO = (FeedAdProgressText) inflate.findViewById(R.id.feed_ad_operate_progress_text);
        this.iPM = this.iPN;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.iOY = (DownloadData) downloadData.clone();
            if (this.iOY != null) {
                setTag(this.iOY);
                q(downloadData);
            }
        }
    }

    public void setIsPbDownload(boolean z) {
        if (z) {
            this.iPN.setVisibility(8);
            this.iPO.setVisibility(0);
            this.iPM = this.iPO;
            return;
        }
        this.iPO.setVisibility(8);
        this.iPN.setVisibility(0);
        this.iPM = this.iPN;
    }

    public void setDefaultText(String str) {
        if (!TextUtils.isEmpty(str) && this.iPM != null) {
            this.iPM.setButtonText(str);
        }
    }

    public void setTextSize(int i) {
        this.iPM.setButtonTextSize(i);
    }

    public void setTextColor(int i) {
        this.iPM.setButtonTextColor(i);
    }

    public void setTextNightColor(int i) {
        this.iPM.setButtonTextNightColor(i);
    }

    public void q(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    yy(u(downloadData));
                    return;
                case 2:
                case 7:
                    this.iPM.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
                    return;
                case 3:
                    this.iPM.setButtonText(getResources().getString(R.string.immediately_install));
                    return;
                case 4:
                default:
                    return;
                case 5:
                    yy(u(downloadData));
                    return;
                case 6:
                    this.iPM.setButtonText(getResources().getString(R.string.install_app));
                    return;
                case 8:
                    this.iPM.setButtonText(getResources().getString(R.string.immediately_open));
                    return;
            }
        }
    }

    public void r(DownloadData downloadData) {
        this.iPM.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
    }

    public void s(DownloadData downloadData) {
        yy(u(downloadData));
    }

    public void t(DownloadData downloadData) {
        this.iPM.setButtonText(getResources().getString(R.string.install_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yy(int i) {
        this.iPM.setProgress(Math.max(0, i));
    }

    public static int u(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = i.cfY().ca(downloadData.getId(), downloadData.getName());
        }
        return Math.max(process, 0);
    }

    public static int getStatus(DownloadData downloadData) {
        d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return (adAdSense == null || adAdSense.apb()) ? i.getStatus(downloadData) : e.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aDD();
        chb();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aDC();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            aDC();
        } else {
            aDD();
        }
    }

    public void onChangeSkinType(int i) {
        this.iPM.onChangeSkinType();
    }

    public void bnq() {
        this.iPM.bnq();
    }

    private void aDC() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.iKh != null) {
            MessageManager.getInstance().registerListener(this.iKh);
        }
    }

    private void aDD() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.iKh != null) {
            MessageManager.getInstance().unRegisterListener(this.iKh);
        }
    }

    private void chb() {
        setOnClickInterceptListener(null);
    }

    public void t(BdUniqueId bdUniqueId) {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.iPR.iOY.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.iOY != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(ApkDownloadView.this.iOY.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            int v = ApkDownloadView.this.v(downloadData);
                            if (i.getStatus(downloadData) == 1) {
                                ApkDownloadView.this.yy(v);
                            } else if (i.getStatus(downloadData) == 3) {
                                ApkDownloadView.this.iPM.setButtonText(ApkDownloadView.this.getResources().getString(R.string.immediately_install));
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
        if (this.iKh == null) {
            this.iKh = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && ApkDownloadView.this.iOY != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (ApkDownloadView.this.iOY.getId() != null && downloadData != null && ApkDownloadView.this.iOY.getId().equals(downloadData.getId())) {
                            ApkDownloadView.this.q(downloadData);
                        }
                    }
                }
            };
            this.iKh.setTag(bdUniqueId);
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
        this.iPQ = downloadStatus;
        if (this.iOY != null) {
            this.iOY.setStatus(getDownloadStatus());
            q(this.iOY);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void cr(int i) {
        if (this.iPQ == DownloadStatus.STATUS_DOWNLOADING) {
            yy(i);
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
        if (this.iPP != null) {
            this.iPP.bo(view);
        }
    }

    public void setOnClickInterceptListener(b.a aVar) {
        this.iPP = aVar;
    }

    public int getDownloadStatus() {
        if (this.iPQ == null || this.iPQ == DownloadStatus.STATUS_NONE) {
            return 6;
        }
        if (this.iPQ == DownloadStatus.STATUS_DOWNLOADING) {
            return 1;
        }
        if (this.iPQ == DownloadStatus.STATUS_PAUSED) {
            return 7;
        }
        if (this.iPQ == DownloadStatus.STATUS_SUCCESS) {
            return 3;
        }
        return this.iPQ == DownloadStatus.STATUS_INSTALL_SUCCESS ? 8 : 6;
    }
}
