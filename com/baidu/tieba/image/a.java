package com.baidu.tieba.image;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.view.i;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ag;
import java.util.List;
/* loaded from: classes.dex */
public class a implements i.a {
    private static int cnS = 7;
    private TbPageContext<?> MR;
    private boolean anS;
    private com.baidu.tbadk.core.data.c cnU;
    private boolean cnV;
    private h cnW;
    private i cnX;
    private int cnT = 0;
    private boolean cnY = false;
    private final View.OnClickListener bgn = new b(this);
    private final View.OnClickListener bgm = new c(this);
    private final CustomMessageListener cnZ = new d(this, 0);

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.anS = false;
        this.cnV = false;
        this.anS = z;
        this.cnV = z2;
        this.MR = tbPageContext;
        this.MR.registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.cnZ);
        this.cnX = new i(tbPageContext.getPageActivity(), str, str2);
    }

    public void e(com.baidu.tbadk.core.data.c cVar, int i) {
        this.cnU = cVar;
        this.cnT = i;
        this.cnX.d(this.cnU);
    }

    public boolean aib() {
        return this.cnV && this.cnU != null && this.cnU.rM() && !ag.isInstalledPackage(this.MR.getPageActivity(), this.cnU.Uy);
    }

    @Override // com.baidu.tbadk.coreExtra.view.i.a
    public View f(ViewGroup viewGroup, int i) {
        if (jV(i)) {
            this.cnW = new h(viewGroup);
            aic();
            viewGroup.addView(this.cnW.getView());
            return this.cnW.getView();
        }
        return null;
    }

    private boolean jV(int i) {
        return aib() && this.cnT != 0 && i == this.cnT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aic() {
        if (this.cnU != null && this.cnU.UI != null) {
            aid();
            if (this.cnU.rO()) {
                this.cnW.aii().setVisibility(8);
                this.cnW.v(this.bgm);
            } else if (this.cnU.rN()) {
                this.cnW.aii().setVisibility(0);
                this.cnW.v(this.bgn);
                aie();
            }
        }
    }

    private void aid() {
        this.cnW.aih().setEvent(new e(this));
        this.cnW.aih().d(this.cnU.UI.US, this.anS ? 30 : 31, false);
    }

    private void aie() {
        if (this.cnU != null) {
            String str = this.cnU.Uu;
            if (StringUtils.isNull(str)) {
                str = this.MR.getString(t.j.app_name);
            }
            if (com.baidu.tbadk.download.b.Cr().eZ(this.cnU.Uy)) {
                this.cnU.Us = 2;
            } else if (com.baidu.tbadk.download.b.Cr().aj(this.cnU.Uy, str)) {
                if (com.baidu.tbadk.download.b.Cr().eW(this.cnU.Uy)) {
                    this.cnU.Us = 1;
                } else {
                    this.cnU.Us = 3;
                }
            }
            switch (this.cnU.Us) {
                case 0:
                    String string = this.MR.getString(t.j.pb_app_download);
                    if (this.cnU.UI != null && !StringUtils.isNull(this.cnU.UI.OC)) {
                        string = this.cnU.UI.OC;
                    }
                    if (string.length() > cnS) {
                        string = string.substring(0, cnS);
                    }
                    this.cnW.jB(string);
                    return;
                case 1:
                    this.cnW.aij();
                    return;
                case 2:
                    this.cnW.aik();
                    return;
                case 3:
                    this.cnW.jB(this.MR.getString(t.j.pb_download_pause));
                    return;
                default:
                    this.cnW.aii().setVisibility(8);
                    this.cnW.v(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.c cVar) {
        String string;
        if (cVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.MR.getPageActivity());
            if (com.baidu.adp.lib.util.i.jb()) {
                string = this.MR.getString(t.j.frs_network_tips);
            } else {
                string = this.MR.getString(t.j.confirm_download_app);
            }
            aVar.cE(string);
            aVar.a(t.j.alert_yes_button, new f(this));
            aVar.b(t.j.alert_no_button, new g(this));
            aVar.b(this.MR).uj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.cnU != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.cnU.Uy, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.cnU.Us = 2;
                    } else if (status == 2 || status == 4) {
                        if (!aw.isEmpty(downloadData.getStatusMsg())) {
                            this.MR.showToast(downloadData.getStatusMsg());
                        }
                        this.cnU.Us = 0;
                    } else if (status == 1) {
                        this.cnU.Us = 1;
                    }
                    aic();
                }
            }
        }
    }

    public void aif() {
        if (!this.cnY) {
            this.cnY = true;
            this.cnX.aio();
        }
    }
}
