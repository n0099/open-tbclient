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
/* loaded from: classes20.dex */
public class ApkDownloadView extends FrameLayout implements com.baidu.tieba.ad.download.mvp.b {
    private CustomMessageListener downloadListener;
    private CustomMessageListener lEz;
    private DownloadData lIX;
    private a lJL;
    private FeedAdProgressButton lJM;
    private FeedAdProgressText lJN;
    private b.a lJO;
    private DownloadStatus lJP;

    public ApkDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.lEz = null;
        init(context);
    }

    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        this.lEz = null;
        init(context);
    }

    public ApkDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        this.lEz = null;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.apk_download_view_layout, (ViewGroup) this, true);
        this.lJM = (FeedAdProgressButton) inflate.findViewById(R.id.feed_ad_operate_progress_button);
        this.lJN = (FeedAdProgressText) inflate.findViewById(R.id.feed_ad_operate_progress_text);
        this.lJL = this.lJM;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(DownloadData downloadData) {
        if (downloadData != null) {
            this.lIX = (DownloadData) downloadData.clone();
            if (this.lIX != null) {
                setTag(this.lIX);
                q(downloadData);
            }
        }
    }

    public void setIsPbDownload(boolean z) {
        if (z) {
            this.lJM.setVisibility(8);
            this.lJN.setVisibility(0);
            this.lJL = this.lJN;
            return;
        }
        this.lJN.setVisibility(8);
        this.lJM.setVisibility(0);
        this.lJL = this.lJM;
    }

    public void setDefaultText(String str) {
        if (!TextUtils.isEmpty(str) && this.lJL != null) {
            this.lJL.setButtonText(str);
        }
    }

    public void setTextSize(int i) {
        this.lJL.setButtonTextSize(i);
    }

    public void setTextColorInitSkin(@ColorRes int i) {
        if (this.lJL instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.lJL).setTextColorInitSkin(i);
        }
    }

    public void setBackgroundSkin(@DrawableRes int i) {
        if (this.lJL instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.lJL).setBackgroundSkin(i);
        }
    }

    public void setForegroundSkin(@DrawableRes int i) {
        if (this.lJL instanceof FeedAdProgressButton) {
            ((FeedAdProgressButton) this.lJL).setForeground(i);
        }
    }

    public void setTextColor(int i) {
        this.lJL.setButtonTextColor(i);
    }

    public void setTextNightColor(int i) {
        this.lJL.setButtonTextNightColor(i);
    }

    public void q(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    Gu(u(downloadData));
                    return;
                case 2:
                case 7:
                    this.lJL.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
                    return;
                case 3:
                    this.lJL.setButtonText(getResources().getString(R.string.immediately_install), 0);
                    return;
                case 4:
                default:
                    return;
                case 5:
                    Gu(u(downloadData));
                    return;
                case 6:
                    this.lJL.setButtonText(getResources().getString(R.string.install_app));
                    return;
                case 8:
                    this.lJL.setButtonText(getResources().getString(R.string.immediately_open), 0);
                    return;
            }
        }
    }

    public void r(DownloadData downloadData) {
        this.lJL.setButtonText(getResources().getString(R.string.go_on_download), u(downloadData));
    }

    public void s(DownloadData downloadData) {
        Gu(u(downloadData));
    }

    public void t(DownloadData downloadData) {
        this.lJL.setButtonText(getResources().getString(R.string.install_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gu(int i) {
        this.lJL.setProgress(Math.max(0, i));
    }

    public static int u(DownloadData downloadData) {
        if (downloadData == null) {
            return 0;
        }
        int process = downloadData.getProcess();
        if (process <= 0) {
            process = i.dnu().dJ(downloadData.getId(), downloadData.getName());
        }
        return Math.max(process, 0);
    }

    public static int getStatus(DownloadData downloadData) {
        d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return (adAdSense == null || adAdSense.bmz()) ? i.getStatus(downloadData) : e.getStatus(downloadData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bAZ();
        doD();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bAY();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            bAY();
        } else {
            bAZ();
        }
    }

    public void onChangeSkinType(int i) {
        this.lJL.onChangeSkinType();
    }

    public void changeSkin() {
        this.lJL.changeSkin();
    }

    private void bAY() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
        if (this.lEz != null) {
            MessageManager.getInstance().registerListener(this.lEz);
        }
    }

    private void bAZ() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
        if (this.lEz != null) {
            MessageManager.getInstance().unRegisterListener(this.lEz);
        }
    }

    private void doD() {
        setOnClickInterceptListener(null);
    }

    public void y(BdUniqueId bdUniqueId) {
        if (this.downloadListener == null) {
            this.downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
                    if (r5.lJQ.lIX.getId().equals(r1.getId()) != false) goto L16;
                 */
                @Override // com.baidu.adp.framework.listener.MessageListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    DownloadData downloadData;
                    if ((customResponsedMessage instanceof DownloadMessage) && ApkDownloadView.this.lIX != null) {
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= data.size()) {
                                break;
                            }
                            downloadData = data.get(i2);
                            if (TextUtils.isEmpty(ApkDownloadView.this.lIX.getId())) {
                                i = i2 + 1;
                            }
                        }
                        downloadData = null;
                        if (downloadData != null) {
                            int v = ApkDownloadView.this.v(downloadData);
                            if (i.getStatus(downloadData) == 1) {
                                ApkDownloadView.this.Gu(v);
                            } else if (i.getStatus(downloadData) == 3) {
                                ApkDownloadView.this.lJL.setButtonText(ApkDownloadView.this.getResources().getString(R.string.immediately_install));
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
        if (this.lEz == null) {
            this.lEz = new CustomMessageListener(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG) { // from class: com.baidu.tieba.recapp.widget.ApkDownloadView.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && ApkDownloadView.this.lIX != null) {
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (ApkDownloadView.this.lIX.getId() != null && downloadData != null && ApkDownloadView.this.lIX.getId().equals(downloadData.getId())) {
                            ApkDownloadView.this.q(downloadData);
                        }
                    }
                }
            };
            this.lEz.setTag(bdUniqueId);
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
        this.lJP = downloadStatus;
        if (this.lIX != null) {
            this.lIX.setStatus(getDownloadStatus());
            q(this.lIX);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void fy(int i) {
        if (this.lJP == DownloadStatus.STATUS_DOWNLOADING) {
            Gu(i);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void a(DownloadStatus downloadStatus, int i) {
        a(downloadStatus);
        fy(i);
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
    public boolean bC(View view) {
        if (this.lJO != null) {
            return this.lJO.bC(view);
        }
        return false;
    }

    public void setOnClickInterceptListener(b.a aVar) {
        this.lJO = aVar;
    }

    public int getDownloadStatus() {
        if (this.lJP == null || this.lJP == DownloadStatus.STATUS_NONE) {
            return 6;
        }
        if (this.lJP == DownloadStatus.STATUS_DOWNLOADING) {
            return 1;
        }
        if (this.lJP == DownloadStatus.STATUS_PAUSED) {
            return 7;
        }
        if (this.lJP == DownloadStatus.STATUS_SUCCESS) {
            return 3;
        }
        return this.lJP == DownloadStatus.STATUS_INSTALL_SUCCESS ? 8 : 6;
    }
}
