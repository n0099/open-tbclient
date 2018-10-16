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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.u;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements ImagePagerAdapter.a {
    private static int eYp = 7;
    private boolean aPk;
    private AdvertAppInfo eYr;
    private boolean eYs;
    private b eYt;
    private c eYu;
    private TbPageContext<?> mContext;
    private int eYq = 0;
    private boolean eYv = false;
    private final View.OnClickListener eYw = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eYr != null) {
                if (a.this.eYt == null || !a.this.eYt.eYE || a.this.eYt.aUY() != view) {
                    if (u.L((Activity) view.getContext())) {
                        a.this.eYu.aVe();
                        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.eYr));
                        int i = a.this.eYr.ala;
                        if (i == 0 || i == 3) {
                            if (!j.kX() || j.kY()) {
                                String str = a.this.eYr.alc;
                                if (StringUtils.isNull(str)) {
                                    str = a.this.mContext.getString(e.j.app_name);
                                }
                                a.this.eYu.aVg();
                                if (s.a(a.this.mContext.getPageActivity(), a.this.eYr, 0, str)) {
                                    a.this.eYu.qj(a.this.eYr.alg);
                                    return;
                                }
                                return;
                            }
                            a.this.c(a.this.eYr);
                            return;
                        } else if (i == 1) {
                            s.f(a.this.eYr);
                            a.this.eYr.ala = 3;
                            a.this.aUT();
                            return;
                        } else if (i == 2) {
                            if (com.baidu.tieba.recapp.download.d.btr().hg(a.this.eYr.alg)) {
                                u.aF(a.this.mContext.getPageActivity(), a.this.eYr.alg);
                                return;
                            }
                            a.this.eYr.ala = 0;
                            a.this.aUT();
                            return;
                        } else {
                            return;
                        }
                    }
                    l.showToast((Activity) view.getContext(), e.j.write_external_storage_permission_denied_fun_disable);
                }
            }
        }
    };
    private final View.OnClickListener eYx = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eYr != null) {
                if (a.this.eYt == null || !a.this.eYt.eYE || a.this.eYt.aUY() != view) {
                    a.this.eYu.aVe();
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.eYr));
                    r.btk().bth().a(a.this.mContext.getPageActivity(), new String[]{a.this.eYr.ale}, true);
                }
            }
        }
    };
    private final CustomMessageListener eYy = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.aPk = false;
        this.eYs = false;
        this.aPk = z;
        this.eYs = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(2001118, this.eYy);
        this.eYu = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.eYr = advertAppInfo;
        this.eYq = i;
        this.eYu.d(this.eYr);
    }

    public boolean aUS() {
        if (!this.eYs || this.eYr == null) {
            return false;
        }
        return (this.eYr.wS() || this.eYr.wR()) && !u.isInstalledPackage(this.mContext.getPageActivity(), this.eYr.alg);
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View f(ViewGroup viewGroup, int i) {
        if (pU(i)) {
            this.eYt = new b(viewGroup);
            aUT();
            viewGroup.addView(this.eYt.getView());
            return this.eYt.getView();
        }
        return null;
    }

    private boolean pU(int i) {
        return aUS() && this.eYq != 0 && i == this.eYq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUT() {
        if (this.eYr != null && this.eYr.aln != null) {
            aUU();
            if (this.eYr.wS()) {
                this.eYt.aUZ().setVisibility(8);
                this.eYt.t(this.eYx);
            } else if (this.eYr.wR()) {
                this.eYt.aUZ().setVisibility(0);
                this.eYt.t(this.eYw);
                aUV();
            }
            s.a(this.eYr.aln.alG, this.eYt.eYB, this.eYr.aln.tagRatio, l.h(this.mContext.getPageActivity(), e.C0175e.ds26));
            if (!TextUtils.isEmpty(this.eYr.aln.adSource)) {
                this.eYt.eYD.setText(this.eYr.aln.adSource);
                this.eYt.eYC.setVisibility(0);
                return;
            }
            this.eYt.eYC.setVisibility(8);
        }
    }

    private void aUU() {
        this.eYt.aUY().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z) {
                    a.this.eYt.aVc();
                }
                a.this.eYt.aVd();
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                a.this.eYt.aVd();
            }
        });
        this.eYt.aUY().startLoad(this.eYr.aln.aly, this.aPk ? 30 : 31, 720, 720, false);
    }

    private void aUV() {
        if (this.eYr != null) {
            String str = this.eYr.alc;
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(e.j.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.btr().hg(this.eYr.alg)) {
                this.eYr.ala = 2;
            } else if (com.baidu.tieba.recapp.download.d.btr().ct(this.eYr.alg, str)) {
                if (com.baidu.tieba.recapp.download.d.btr().he(this.eYr.alg)) {
                    this.eYr.ala = 1;
                } else {
                    this.eYr.ala = 3;
                }
            }
            switch (this.eYr.ala) {
                case 0:
                    String string = this.mContext.getString(e.j.install_app);
                    if (this.eYr.aln != null && !StringUtils.isNull(this.eYr.aln.buttonText)) {
                        string = this.eYr.aln.buttonText;
                    }
                    if (string.length() > eYp) {
                        string = string.substring(0, eYp);
                    }
                    this.eYt.qi(string);
                    return;
                case 1:
                    this.eYt.aVa();
                    return;
                case 2:
                    this.eYt.aVb();
                    return;
                case 3:
                    this.eYt.qi(this.mContext.getString(e.j.pb_download_pause));
                    return;
                default:
                    this.eYt.aUZ().setVisibility(8);
                    this.eYt.t(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            if (j.kZ()) {
                string = this.mContext.getString(e.j.frs_network_tips);
            } else {
                string = this.mContext.getString(e.j.confirm_download_app);
            }
            aVar.ej(string);
            aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.eYr.alc;
                    if (StringUtils.isNull(str)) {
                        str = a.this.mContext.getString(e.j.app_name);
                    }
                    a.this.eYu.aVg();
                    if (s.a(a.this.mContext.getPageActivity(), a.this.eYr, 0, str)) {
                        a.this.eYu.qj(a.this.eYr.alg);
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.image.a.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mContext).Au();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.eYr != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.eYr.alg, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.eYr.ala = 2;
                    } else if (status == 2 || status == 4) {
                        if (!ao.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.eYr.ala = 0;
                    } else if (status == 1) {
                        this.eYr.ala = 1;
                    }
                    aUT();
                }
            }
        }
    }

    public void aUW() {
        if (!this.eYv) {
            this.eYv = true;
            this.eYu.aVf();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.eYr));
        }
    }
}
