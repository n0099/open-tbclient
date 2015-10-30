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
    private static int bOG = 7;
    private boolean akd;
    private com.baidu.tbadk.core.data.b bOI;
    private boolean bOJ;
    private h bOK;
    private i bOL;
    private TbPageContext<?> mContext;
    private int bOH = 0;
    private boolean bOM = false;
    private final View.OnClickListener aUA = new b(this);
    private final View.OnClickListener aUz = new c(this);
    private final CustomMessageListener bON = new d(this, 0);

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.akd = false;
        this.bOJ = false;
        this.akd = z;
        this.bOJ = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.bON);
        this.bOL = new i(tbPageContext.getPageActivity(), str, str2);
    }

    public void d(com.baidu.tbadk.core.data.b bVar, int i) {
        this.bOI = bVar;
        this.bOH = i;
        this.bOL.c(this.bOI);
    }

    public boolean ZI() {
        return this.bOJ && this.bOI != null && this.bOI.rm() && !ag.isInstalledPackage(this.mContext.getPageActivity(), this.bOI.Ua);
    }

    @Override // com.baidu.tbadk.coreExtra.view.j.a
    public View f(ViewGroup viewGroup, int i) {
        if (hR(i)) {
            this.bOK = new h(viewGroup);
            ZJ();
            viewGroup.addView(this.bOK.getView());
            return this.bOK.getView();
        }
        return null;
    }

    private boolean hR(int i) {
        return ZI() && this.bOH != 0 && i == this.bOH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZJ() {
        if (this.bOI != null && this.bOI.Uj != null) {
            ZK();
            if (this.bOI.ro()) {
                this.bOK.ZP().setVisibility(8);
                this.bOK.q(this.aUz);
            } else if (this.bOI.rn()) {
                ZL();
            }
        }
    }

    private void ZK() {
        this.bOK.ZO().setEvent(new e(this));
        this.bOK.ZO().d(this.bOI.Uj.Uo, this.akd ? 30 : 31, false);
    }

    private void ZL() {
        if (this.bOI != null) {
            this.bOK.ZP().setVisibility(0);
            if (com.baidu.tbadk.download.b.Ak().eI(this.bOI.Ua)) {
                this.bOI.TU = 2;
            }
            switch (this.bOI.TU) {
                case 0:
                    String string = this.mContext.getString(i.h.pb_app_download);
                    if (this.bOI.Uj != null && !StringUtils.isNull(this.bOI.Uj.Ut)) {
                        string = this.bOI.Uj.Ut;
                    }
                    if (string.length() > bOG) {
                        string = string.substring(0, bOG);
                    }
                    this.bOK.iN(string);
                    this.bOK.q(this.aUA);
                    return;
                case 1:
                    this.bOK.ZQ();
                    this.bOK.q(null);
                    return;
                case 2:
                    this.bOK.ZS();
                    this.bOK.q(this.aUA);
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
            if (com.baidu.adp.lib.util.i.iO()) {
                string = this.mContext.getString(i.h.frs_network_tips);
            } else {
                string = this.mContext.getString(i.h.confirm_download_app);
            }
            aVar.cu(string);
            aVar.a(i.h.alert_yes_button, new f(this));
            aVar.b(i.h.alert_no_button, new g(this));
            aVar.b(this.mContext).sO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.bOI != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.bOI.Ua, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.bOI.TU = 2;
                    } else if (status == 2 || status == 4) {
                        if (!as.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.bOI.TU = 0;
                    } else if (status == 1) {
                        this.bOI.TU = 1;
                    }
                    ZJ();
                }
            }
        }
    }

    public void ZM() {
        if (!this.bOM) {
            this.bOM = true;
            this.bOL.ZW();
        }
    }
}
