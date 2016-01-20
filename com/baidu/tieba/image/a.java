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
    private static int cjs = 7;
    private boolean amZ;
    private com.baidu.tbadk.core.data.b cju;
    private boolean cjv;
    private h cjw;
    private i cjx;
    private TbPageContext<?> mContext;
    private int cjt = 0;
    private boolean cjy = false;
    private final View.OnClickListener bdT = new b(this);
    private final View.OnClickListener bdS = new c(this);
    private final CustomMessageListener cjz = new d(this, 0);

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.amZ = false;
        this.cjv = false;
        this.amZ = z;
        this.cjv = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.cjz);
        this.cjx = new i(tbPageContext.getPageActivity(), str, str2);
    }

    public void c(com.baidu.tbadk.core.data.b bVar, int i) {
        this.cju = bVar;
        this.cjt = i;
        this.cjx.d(this.cju);
    }

    public boolean aeS() {
        return this.cjv && this.cju != null && this.cju.rk() && !ah.isInstalledPackage(this.mContext.getPageActivity(), this.cju.US);
    }

    @Override // com.baidu.tbadk.coreExtra.view.j.a
    public View f(ViewGroup viewGroup, int i) {
        if (jy(i)) {
            this.cjw = new h(viewGroup);
            aeT();
            viewGroup.addView(this.cjw.getView());
            return this.cjw.getView();
        }
        return null;
    }

    private boolean jy(int i) {
        return aeS() && this.cjt != 0 && i == this.cjt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeT() {
        if (this.cju != null && this.cju.Vb != null) {
            aeU();
            if (this.cju.rm()) {
                this.cjw.aeZ().setVisibility(8);
                this.cjw.q(this.bdS);
            } else if (this.cju.rl()) {
                aeV();
            }
        }
    }

    private void aeU() {
        this.cjw.aeY().setEvent(new e(this));
        this.cjw.aeY().d(this.cju.Vb.Vg, this.amZ ? 30 : 31, false);
    }

    private void aeV() {
        if (this.cju != null) {
            this.cjw.aeZ().setVisibility(0);
            if (com.baidu.tbadk.download.b.Bb().fa(this.cju.US)) {
                this.cju.UL = 2;
            }
            switch (this.cju.UL) {
                case 0:
                    String string = this.mContext.getString(n.j.pb_app_download);
                    if (this.cju.Vb != null && !StringUtils.isNull(this.cju.Vb.Vl)) {
                        string = this.cju.Vb.Vl;
                    }
                    if (string.length() > cjs) {
                        string = string.substring(0, cjs);
                    }
                    this.cjw.jx(string);
                    this.cjw.q(this.bdT);
                    return;
                case 1:
                    this.cjw.afa();
                    this.cjw.q(null);
                    return;
                case 2:
                    this.cjw.afc();
                    this.cjw.q(this.bdT);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.b bVar) {
        String string;
        if (bVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            if (com.baidu.adp.lib.util.i.iS()) {
                string = this.mContext.getString(n.j.frs_network_tips);
            } else {
                string = this.mContext.getString(n.j.confirm_download_app);
            }
            aVar.cF(string);
            aVar.a(n.j.alert_yes_button, new f(this));
            aVar.b(n.j.alert_no_button, new g(this));
            aVar.b(this.mContext).tf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.cju != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.cju.US, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.cju.UL = 2;
                    } else if (status == 2 || status == 4) {
                        if (!ax.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.cju.UL = 0;
                    } else if (status == 1) {
                        this.cju.UL = 1;
                    }
                    aeT();
                }
            }
        }
    }

    public void aeW() {
        if (!this.cjy) {
            this.cjy = true;
            this.cjx.aff();
        }
    }
}
