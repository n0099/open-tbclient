package com.baidu.tieba.image;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.u;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements ImagePagerAdapter.a {
    private static int eqw = 7;
    private boolean ayi;
    private b eqA;
    private c eqB;
    private AdvertAppInfo eqy;
    private boolean eqz;
    private TbPageContext<?> mContext;
    private int eqx = 0;
    private boolean eqC = false;
    private final View.OnClickListener eqD = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (a.this.eqy != null) {
                if (a.this.eqA == null || !a.this.eqA.eqL || a.this.eqA.aIZ() != view2) {
                    if (u.E((Activity) view2.getContext())) {
                        a.this.eqB.aJf();
                        int i = a.this.eqy.VK;
                        if (i == 0 || i == 3) {
                            if (!j.gP() || j.gQ()) {
                                String str = a.this.eqy.VM;
                                if (StringUtils.isNull(str)) {
                                    str = a.this.mContext.getString(d.k.app_name);
                                }
                                a.this.eqB.aJh();
                                if (s.a(a.this.mContext.getPageActivity(), a.this.eqy, 0, str)) {
                                    a.this.eqB.ok(a.this.eqy.VQ);
                                    return;
                                }
                                return;
                            }
                            a.this.c(a.this.eqy);
                            return;
                        } else if (i == 1) {
                            s.e(a.this.eqy);
                            a.this.eqy.VK = 3;
                            a.this.aIU();
                            return;
                        } else if (i == 2) {
                            if (com.baidu.tieba.recapp.download.d.bjq().fV(a.this.eqy.VQ)) {
                                u.aj(a.this.mContext.getPageActivity(), a.this.eqy.VQ);
                                return;
                            }
                            a.this.eqy.VK = 0;
                            a.this.aIU();
                            return;
                        } else {
                            return;
                        }
                    }
                    l.showToast((Activity) view2.getContext(), d.k.write_external_storage_permission_denied_fun_disable);
                }
            }
        }
    };
    private final View.OnClickListener eqE = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (a.this.eqy != null) {
                if (a.this.eqA == null || !a.this.eqA.eqL || a.this.eqA.aIZ() != view2) {
                    a.this.eqB.aJf();
                    r.bjk().bjh().a(a.this.mContext.getPageActivity(), new String[]{a.this.eqy.VO}, true);
                }
            }
        }
    };
    private final CustomMessageListener eqF = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && !customResponsedMessage.hasError()) {
                a.this.e(customResponsedMessage);
            }
        }
    };

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.ayi = false;
        this.eqz = false;
        this.ayi = z;
        this.eqz = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(2001118, this.eqF);
        this.eqB = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.eqy = advertAppInfo;
        this.eqx = i;
        this.eqB.d(this.eqy);
    }

    public boolean aIT() {
        if (!this.eqz || this.eqy == null) {
            return false;
        }
        return (this.eqy.qt() || this.eqy.qs()) && !u.isInstalledPackage(this.mContext.getPageActivity(), this.eqy.VQ);
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View g(ViewGroup viewGroup, int i) {
        if (ok(i)) {
            this.eqA = new b(viewGroup);
            aIU();
            viewGroup.addView(this.eqA.getView());
            return this.eqA.getView();
        }
        return null;
    }

    private boolean ok(int i) {
        return aIT() && this.eqx != 0 && i == this.eqx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIU() {
        if (this.eqy != null && this.eqy.VX != null) {
            aIV();
            if (this.eqy.qt()) {
                this.eqA.aJa().setVisibility(8);
                this.eqA.p(this.eqE);
            } else if (this.eqy.qs()) {
                this.eqA.aJa().setVisibility(0);
                this.eqA.p(this.eqD);
                aIW();
            }
            s.a(this.eqy.VX.Wp, this.eqA.eqI, this.eqy.VX.tagRatio, l.e(this.mContext.getPageActivity(), d.e.ds26));
            if (!TextUtils.isEmpty(this.eqy.VX.adSource)) {
                this.eqA.eqK.setText(this.eqy.VX.adSource);
                this.eqA.eqJ.setVisibility(0);
                return;
            }
            this.eqA.eqJ.setVisibility(8);
        }
    }

    private void aIV() {
        this.eqA.aIZ().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z) {
                    a.this.eqA.aJd();
                }
                a.this.eqA.aJe();
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                a.this.eqA.aJe();
            }
        });
        this.eqA.aIZ().startLoad(this.eqy.VX.Wh, this.ayi ? 30 : 31, 720, 720, false);
    }

    private void aIW() {
        if (this.eqy != null) {
            String str = this.eqy.VM;
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(d.k.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.bjq().fV(this.eqy.VQ)) {
                this.eqy.VK = 2;
            } else if (com.baidu.tieba.recapp.download.d.bjq().an(this.eqy.VQ, str)) {
                if (com.baidu.tieba.recapp.download.d.bjq().fT(this.eqy.VQ)) {
                    this.eqy.VK = 1;
                } else {
                    this.eqy.VK = 3;
                }
            }
            switch (this.eqy.VK) {
                case 0:
                    String string = this.mContext.getString(d.k.install_app);
                    if (this.eqy.VX != null && !StringUtils.isNull(this.eqy.VX.buttonText)) {
                        string = this.eqy.VX.buttonText;
                    }
                    if (string.length() > eqw) {
                        string = string.substring(0, eqw);
                    }
                    this.eqA.oj(string);
                    return;
                case 1:
                    this.eqA.aJb();
                    return;
                case 2:
                    this.eqA.aJc();
                    return;
                case 3:
                    this.eqA.oj(this.mContext.getString(d.k.pb_download_pause));
                    return;
                default:
                    this.eqA.aJa().setVisibility(8);
                    this.eqA.p(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            if (j.gR()) {
                string = this.mContext.getString(d.k.frs_network_tips);
            } else {
                string = this.mContext.getString(d.k.confirm_download_app);
            }
            aVar.dc(string);
            aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.eqy.VM;
                    if (StringUtils.isNull(str)) {
                        str = a.this.mContext.getString(d.k.app_name);
                    }
                    a.this.eqB.aJh();
                    if (s.a(a.this.mContext.getPageActivity(), a.this.eqy, 0, str)) {
                        a.this.eqB.ok(a.this.eqy.VQ);
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.image.a.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mContext).tC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.eqy != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.eqy.VQ, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.eqy.VK = 2;
                    } else if (status == 2 || status == 4) {
                        if (!an.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.eqy.VK = 0;
                    } else if (status == 1) {
                        this.eqy.VK = 1;
                    }
                    aIU();
                }
            }
        }
    }

    public void aIX() {
        if (!this.eqC) {
            this.eqC = true;
            this.eqB.aJg();
        }
    }
}
