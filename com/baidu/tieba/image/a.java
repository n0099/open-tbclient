package com.baidu.tieba.image;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.view.j;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.ah;
import java.util.List;
/* loaded from: classes.dex */
public class a implements j.a {
    private static int cfo = 7;
    private boolean alT;
    private com.baidu.tbadk.core.data.b cfq;
    private boolean cfr;
    private h cfs;
    private i cft;
    private TbPageContext<?> mContext;
    private int cfp = 0;
    private boolean cfu = false;
    private final View.OnClickListener aZW = new b(this);
    private final View.OnClickListener aZV = new c(this);
    private final CustomMessageListener cfv = new d(this, 0);

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.alT = false;
        this.cfr = false;
        this.alT = z;
        this.cfr = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.cfv);
        this.cft = new i(tbPageContext.getPageActivity(), str, str2);
    }

    public void d(com.baidu.tbadk.core.data.b bVar, int i) {
        this.cfq = bVar;
        this.cfp = i;
        this.cft.c(this.cfq);
    }

    public boolean adJ() {
        return this.cfr && this.cfq != null && this.cfq.rB() && !ah.isInstalledPackage(this.mContext.getPageActivity(), this.cfq.Ur);
    }

    @Override // com.baidu.tbadk.coreExtra.view.j.a
    public View f(ViewGroup viewGroup, int i) {
        if (iZ(i)) {
            this.cfs = new h(viewGroup);
            adK();
            viewGroup.addView(this.cfs.getView());
            return this.cfs.getView();
        }
        return null;
    }

    private boolean iZ(int i) {
        return adJ() && this.cfp != 0 && i == this.cfp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adK() {
        if (this.cfq != null && this.cfq.UA != null) {
            adL();
            if (this.cfq.rD()) {
                this.cfs.adQ().setVisibility(8);
                this.cfs.q(this.aZV);
            } else if (this.cfq.rC()) {
                adM();
            }
        }
    }

    private void adL() {
        this.cfs.adP().setEvent(new e(this));
        this.cfs.adP().d(this.cfq.UA.UF, this.alT ? 30 : 31, false);
    }

    private void adM() {
        if (this.cfq != null) {
            this.cfs.adQ().setVisibility(0);
            if (com.baidu.tbadk.download.b.Bm().eW(this.cfq.Ur)) {
                this.cfq.Ul = 2;
            }
            switch (this.cfq.Ul) {
                case 0:
                    String string = this.mContext.getString(n.i.pb_app_download);
                    if (this.cfq.UA != null && !StringUtils.isNull(this.cfq.UA.UK)) {
                        string = this.cfq.UA.UK;
                    }
                    if (string.length() > cfo) {
                        string = string.substring(0, cfo);
                    }
                    this.cfs.jj(string);
                    this.cfs.q(this.aZW);
                    return;
                case 1:
                    this.cfs.adR();
                    this.cfs.q(null);
                    return;
                case 2:
                    this.cfs.adT();
                    this.cfs.q(this.aZW);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.b bVar) {
        String string;
        if (bVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            if (com.baidu.adp.lib.util.i.iR()) {
                string = this.mContext.getString(n.i.frs_network_tips);
            } else {
                string = this.mContext.getString(n.i.confirm_download_app);
            }
            aVar.cC(string);
            aVar.a(n.i.alert_yes_button, new f(this));
            aVar.b(n.i.alert_no_button, new g(this));
            aVar.b(this.mContext).tv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.cfq != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.cfq.Ur, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.cfq.Ul = 2;
                    } else if (status == 2 || status == 4) {
                        if (!ax.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.cfq.Ul = 0;
                    } else if (status == 1) {
                        this.cfq.Ul = 1;
                    }
                    adK();
                }
            }
        }
    }

    public void adN() {
        if (!this.cfu) {
            this.cfu = true;
            this.cft.adX();
        }
    }
}
