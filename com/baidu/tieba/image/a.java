package com.baidu.tieba.image;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.view.j;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ag;
import java.util.List;
/* loaded from: classes.dex */
public class a implements j.a {
    private static int bPb = 7;
    private boolean aki;
    private com.baidu.tbadk.core.data.b bPd;
    private boolean bPe;
    private h bPf;
    private i bPg;
    private TbPageContext<?> mContext;
    private int bPc = 0;
    private boolean bPh = false;
    private final View.OnClickListener aUI = new b(this);
    private final View.OnClickListener aUH = new c(this);
    private final CustomMessageListener bPi = new d(this, 0);

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.aki = false;
        this.bPe = false;
        this.aki = z;
        this.bPe = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.bPi);
        this.bPg = new i(tbPageContext.getPageActivity(), str, str2);
    }

    public void d(com.baidu.tbadk.core.data.b bVar, int i) {
        this.bPd = bVar;
        this.bPc = i;
        this.bPg.c(this.bPd);
    }

    public boolean aad() {
        return this.bPe && this.bPd != null && this.bPd.rn() && !ag.isInstalledPackage(this.mContext.getPageActivity(), this.bPd.Ub);
    }

    @Override // com.baidu.tbadk.coreExtra.view.j.a
    public View f(ViewGroup viewGroup, int i) {
        if (ie(i)) {
            this.bPf = new h(viewGroup);
            aae();
            viewGroup.addView(this.bPf.getView());
            return this.bPf.getView();
        }
        return null;
    }

    private boolean ie(int i) {
        return aad() && this.bPc != 0 && i == this.bPc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aae() {
        if (this.bPd != null && this.bPd.Uk != null) {
            aaf();
            if (this.bPd.rp()) {
                this.bPf.aak().setVisibility(8);
                this.bPf.q(this.aUH);
            } else if (this.bPd.ro()) {
                aag();
            }
        }
    }

    private void aaf() {
        this.bPf.aaj().setEvent(new e(this));
        this.bPf.aaj().d(this.bPd.Uk.Up, this.aki ? 30 : 31, false);
    }

    private void aag() {
        if (this.bPd != null) {
            this.bPf.aak().setVisibility(0);
            if (com.baidu.tbadk.download.b.Ap().eI(this.bPd.Ub)) {
                this.bPd.TV = 2;
            }
            switch (this.bPd.TV) {
                case 0:
                    String string = this.mContext.getString(i.h.pb_app_download);
                    if (this.bPd.Uk != null && !StringUtils.isNull(this.bPd.Uk.Uu)) {
                        string = this.bPd.Uk.Uu;
                    }
                    if (string.length() > bPb) {
                        string = string.substring(0, bPb);
                    }
                    this.bPf.iP(string);
                    this.bPf.q(this.aUI);
                    return;
                case 1:
                    this.bPf.aal();
                    this.bPf.q(null);
                    return;
                case 2:
                    this.bPf.aan();
                    this.bPf.q(this.aUI);
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
            if (com.baidu.adp.lib.util.i.iP()) {
                string = this.mContext.getString(i.h.frs_network_tips);
            } else {
                string = this.mContext.getString(i.h.confirm_download_app);
            }
            aVar.cu(string);
            aVar.a(i.h.alert_yes_button, new f(this));
            aVar.b(i.h.alert_no_button, new g(this));
            aVar.b(this.mContext).sR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.bPd != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.bPd.Ub, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.bPd.TV = 2;
                    } else if (status == 2 || status == 4) {
                        if (!as.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.bPd.TV = 0;
                    } else if (status == 1) {
                        this.bPd.TV = 1;
                    }
                    aae();
                }
            }
        }
    }

    public void aah() {
        if (!this.bPh) {
            this.bPh = true;
            this.bPg.aar();
        }
    }
}
