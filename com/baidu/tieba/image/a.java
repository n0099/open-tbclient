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
    private static int eYq = 7;
    private boolean aPk;
    private AdvertAppInfo eYs;
    private boolean eYt;
    private b eYu;
    private c eYv;
    private TbPageContext<?> mContext;
    private int eYr = 0;
    private boolean eYw = false;
    private final View.OnClickListener eYx = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eYs != null) {
                if (a.this.eYu == null || !a.this.eYu.eYF || a.this.eYu.aUY() != view) {
                    if (u.L((Activity) view.getContext())) {
                        a.this.eYv.aVe();
                        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.eYs));
                        int i = a.this.eYs.ala;
                        if (i == 0 || i == 3) {
                            if (!j.kX() || j.kY()) {
                                String str = a.this.eYs.alc;
                                if (StringUtils.isNull(str)) {
                                    str = a.this.mContext.getString(e.j.app_name);
                                }
                                a.this.eYv.aVg();
                                if (s.a(a.this.mContext.getPageActivity(), a.this.eYs, 0, str)) {
                                    a.this.eYv.qj(a.this.eYs.alg);
                                    return;
                                }
                                return;
                            }
                            a.this.c(a.this.eYs);
                            return;
                        } else if (i == 1) {
                            s.f(a.this.eYs);
                            a.this.eYs.ala = 3;
                            a.this.aUT();
                            return;
                        } else if (i == 2) {
                            if (com.baidu.tieba.recapp.download.d.btr().hg(a.this.eYs.alg)) {
                                u.aF(a.this.mContext.getPageActivity(), a.this.eYs.alg);
                                return;
                            }
                            a.this.eYs.ala = 0;
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
    private final View.OnClickListener eYy = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eYs != null) {
                if (a.this.eYu == null || !a.this.eYu.eYF || a.this.eYu.aUY() != view) {
                    a.this.eYv.aVe();
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.eYs));
                    r.btk().bth().a(a.this.mContext.getPageActivity(), new String[]{a.this.eYs.ale}, true);
                }
            }
        }
    };
    private final CustomMessageListener eYz = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.eYt = false;
        this.aPk = z;
        this.eYt = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(2001118, this.eYz);
        this.eYv = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.eYs = advertAppInfo;
        this.eYr = i;
        this.eYv.d(this.eYs);
    }

    public boolean aUS() {
        if (!this.eYt || this.eYs == null) {
            return false;
        }
        return (this.eYs.wS() || this.eYs.wR()) && !u.isInstalledPackage(this.mContext.getPageActivity(), this.eYs.alg);
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View f(ViewGroup viewGroup, int i) {
        if (pU(i)) {
            this.eYu = new b(viewGroup);
            aUT();
            viewGroup.addView(this.eYu.getView());
            return this.eYu.getView();
        }
        return null;
    }

    private boolean pU(int i) {
        return aUS() && this.eYr != 0 && i == this.eYr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUT() {
        if (this.eYs != null && this.eYs.aln != null) {
            aUU();
            if (this.eYs.wS()) {
                this.eYu.aUZ().setVisibility(8);
                this.eYu.t(this.eYy);
            } else if (this.eYs.wR()) {
                this.eYu.aUZ().setVisibility(0);
                this.eYu.t(this.eYx);
                aUV();
            }
            s.a(this.eYs.aln.alG, this.eYu.eYC, this.eYs.aln.tagRatio, l.h(this.mContext.getPageActivity(), e.C0175e.ds26));
            if (!TextUtils.isEmpty(this.eYs.aln.adSource)) {
                this.eYu.eYE.setText(this.eYs.aln.adSource);
                this.eYu.eYD.setVisibility(0);
                return;
            }
            this.eYu.eYD.setVisibility(8);
        }
    }

    private void aUU() {
        this.eYu.aUY().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z) {
                    a.this.eYu.aVc();
                }
                a.this.eYu.aVd();
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                a.this.eYu.aVd();
            }
        });
        this.eYu.aUY().startLoad(this.eYs.aln.aly, this.aPk ? 30 : 31, 720, 720, false);
    }

    private void aUV() {
        if (this.eYs != null) {
            String str = this.eYs.alc;
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(e.j.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.btr().hg(this.eYs.alg)) {
                this.eYs.ala = 2;
            } else if (com.baidu.tieba.recapp.download.d.btr().ct(this.eYs.alg, str)) {
                if (com.baidu.tieba.recapp.download.d.btr().he(this.eYs.alg)) {
                    this.eYs.ala = 1;
                } else {
                    this.eYs.ala = 3;
                }
            }
            switch (this.eYs.ala) {
                case 0:
                    String string = this.mContext.getString(e.j.install_app);
                    if (this.eYs.aln != null && !StringUtils.isNull(this.eYs.aln.buttonText)) {
                        string = this.eYs.aln.buttonText;
                    }
                    if (string.length() > eYq) {
                        string = string.substring(0, eYq);
                    }
                    this.eYu.qi(string);
                    return;
                case 1:
                    this.eYu.aVa();
                    return;
                case 2:
                    this.eYu.aVb();
                    return;
                case 3:
                    this.eYu.qi(this.mContext.getString(e.j.pb_download_pause));
                    return;
                default:
                    this.eYu.aUZ().setVisibility(8);
                    this.eYu.t(null);
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
                    String str = a.this.eYs.alc;
                    if (StringUtils.isNull(str)) {
                        str = a.this.mContext.getString(e.j.app_name);
                    }
                    a.this.eYv.aVg();
                    if (s.a(a.this.mContext.getPageActivity(), a.this.eYs, 0, str)) {
                        a.this.eYv.qj(a.this.eYs.alg);
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
        if ((responsedMessage instanceof DownloadMessage) && this.eYs != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.eYs.alg, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.eYs.ala = 2;
                    } else if (status == 2 || status == 4) {
                        if (!ao.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.eYs.ala = 0;
                    } else if (status == 1) {
                        this.eYs.ala = 1;
                    }
                    aUT();
                }
            }
        }
    }

    public void aUW() {
        if (!this.eYw) {
            this.eYw = true;
            this.eYv.aVf();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.eYs));
        }
    }
}
