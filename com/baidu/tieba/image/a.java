package com.baidu.tieba.image;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.view.j;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ag;
import java.util.List;
/* loaded from: classes.dex */
public class a implements j.a {
    private static int bOv = 7;
    private boolean akc;
    private i bOA;
    private com.baidu.tbadk.core.data.b bOx;
    private boolean bOy;
    private h bOz;
    private TbPageContext<?> mContext;
    private int bOw = 0;
    private boolean bOB = false;
    private final View.OnClickListener aUp = new b(this);
    private final View.OnClickListener aUo = new c(this);
    private final CustomMessageListener bOC = new d(this, 0);

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.akc = false;
        this.bOy = false;
        this.akc = z;
        this.bOy = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.bOC);
        this.bOA = new i(tbPageContext.getPageActivity(), str, str2);
    }

    public void d(com.baidu.tbadk.core.data.b bVar, int i) {
        this.bOx = bVar;
        this.bOw = i;
        this.bOA.c(this.bOx);
    }

    public boolean ZM() {
        return this.bOy && this.bOx != null && this.bOx.rp() && !ag.isInstalledPackage(this.mContext.getPageActivity(), this.bOx.TZ);
    }

    @Override // com.baidu.tbadk.coreExtra.view.j.a
    public View f(ViewGroup viewGroup, int i) {
        if (hR(i)) {
            this.bOz = new h(viewGroup);
            ZN();
            viewGroup.addView(this.bOz.getView());
            return this.bOz.getView();
        }
        return null;
    }

    private boolean hR(int i) {
        return ZM() && this.bOw != 0 && i == this.bOw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZN() {
        if (this.bOx != null && this.bOx.Ui != null) {
            ZO();
            if (this.bOx.rr()) {
                this.bOz.ZT().setVisibility(8);
                this.bOz.q(this.aUo);
            } else if (this.bOx.rq()) {
                ZP();
            }
        }
    }

    private void ZO() {
        this.bOz.ZS().setEvent(new e(this));
        this.bOz.ZS().d(this.bOx.Ui.Un, this.akc ? 30 : 31, false);
    }

    private void ZP() {
        if (this.bOx != null) {
            this.bOz.ZT().setVisibility(0);
            if (com.baidu.tbadk.download.b.An().eI(this.bOx.TZ)) {
                this.bOx.TT = 2;
            }
            switch (this.bOx.TT) {
                case 0:
                    String string = this.mContext.getString(i.h.pb_app_download);
                    if (this.bOx.Ui != null && !StringUtils.isNull(this.bOx.Ui.Us)) {
                        string = this.bOx.Ui.Us;
                    }
                    if (string.length() > bOv) {
                        string = string.substring(0, bOv);
                    }
                    this.bOz.iN(string);
                    this.bOz.q(this.aUp);
                    return;
                case 1:
                    this.bOz.ZU();
                    this.bOz.q(null);
                    return;
                case 2:
                    this.bOz.ZW();
                    this.bOz.q(this.aUp);
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
            aVar.ct(string);
            aVar.a(i.h.alert_yes_button, new f(this));
            aVar.b(i.h.alert_no_button, new g(this));
            aVar.b(this.mContext).sR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.bOx != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.bOx.TZ, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.bOx.TT = 2;
                    } else if (status == 2 || status == 4) {
                        if (!ar.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.bOx.TT = 0;
                    } else if (status == 1) {
                        this.bOx.TT = 1;
                    }
                    ZN();
                }
            }
        }
    }

    public void ZQ() {
        if (!this.bOB) {
            this.bOB = true;
            this.bOA.aaa();
        }
    }
}
