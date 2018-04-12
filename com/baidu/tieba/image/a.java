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
    private static int epr = 7;
    private TbPageContext<?> adf;
    private boolean ayh;
    private AdvertAppInfo ept;
    private boolean epu;
    private b epv;
    private c epw;
    private int eps = 0;
    private boolean epx = false;
    private final View.OnClickListener epy = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (a.this.ept != null) {
                if (a.this.epv == null || !a.this.epv.epG || a.this.epv.aJa() != view2) {
                    if (u.E((Activity) view2.getContext())) {
                        a.this.epw.aJg();
                        int i = a.this.ept.VO;
                        if (i == 0 || i == 3) {
                            if (!j.gP() || j.gQ()) {
                                String str = a.this.ept.VQ;
                                if (StringUtils.isNull(str)) {
                                    str = a.this.adf.getString(d.k.app_name);
                                }
                                a.this.epw.aJi();
                                if (s.a(a.this.adf.getPageActivity(), a.this.ept, 0, str)) {
                                    a.this.epw.oh(a.this.ept.VU);
                                    return;
                                }
                                return;
                            }
                            a.this.c(a.this.ept);
                            return;
                        } else if (i == 1) {
                            s.e(a.this.ept);
                            a.this.ept.VO = 3;
                            a.this.aIV();
                            return;
                        } else if (i == 2) {
                            if (com.baidu.tieba.recapp.download.d.bjr().fV(a.this.ept.VU)) {
                                u.aj(a.this.adf.getPageActivity(), a.this.ept.VU);
                                return;
                            }
                            a.this.ept.VO = 0;
                            a.this.aIV();
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
    private final View.OnClickListener epz = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (a.this.ept != null) {
                if (a.this.epv == null || !a.this.epv.epG || a.this.epv.aJa() != view2) {
                    a.this.epw.aJg();
                    r.bjl().bji().a(a.this.adf.getPageActivity(), new String[]{a.this.ept.VS}, true);
                }
            }
        }
    };
    private final CustomMessageListener epA = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.ayh = false;
        this.epu = false;
        this.ayh = z;
        this.epu = z2;
        this.adf = tbPageContext;
        this.adf.registerListener(2001118, this.epA);
        this.epw = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.ept = advertAppInfo;
        this.eps = i;
        this.epw.d(this.ept);
    }

    public boolean aIU() {
        if (!this.epu || this.ept == null) {
            return false;
        }
        return (this.ept.qu() || this.ept.qt()) && !u.isInstalledPackage(this.adf.getPageActivity(), this.ept.VU);
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View g(ViewGroup viewGroup, int i) {
        if (om(i)) {
            this.epv = new b(viewGroup);
            aIV();
            viewGroup.addView(this.epv.getView());
            return this.epv.getView();
        }
        return null;
    }

    private boolean om(int i) {
        return aIU() && this.eps != 0 && i == this.eps;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIV() {
        if (this.ept != null && this.ept.Wb != null) {
            aIW();
            if (this.ept.qu()) {
                this.epv.aJb().setVisibility(8);
                this.epv.p(this.epz);
            } else if (this.ept.qt()) {
                this.epv.aJb().setVisibility(0);
                this.epv.p(this.epy);
                aIX();
            }
            s.a(this.ept.Wb.Wt, this.epv.epD, this.ept.Wb.tagRatio, l.e(this.adf.getPageActivity(), d.e.ds26));
            if (!TextUtils.isEmpty(this.ept.Wb.adSource)) {
                this.epv.epF.setText(this.ept.Wb.adSource);
                this.epv.epE.setVisibility(0);
                return;
            }
            this.epv.epE.setVisibility(8);
        }
    }

    private void aIW() {
        this.epv.aJa().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z) {
                    a.this.epv.aJe();
                }
                a.this.epv.aJf();
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                a.this.epv.aJf();
            }
        });
        this.epv.aJa().startLoad(this.ept.Wb.Wl, this.ayh ? 30 : 31, 720, 720, false);
    }

    private void aIX() {
        if (this.ept != null) {
            String str = this.ept.VQ;
            if (StringUtils.isNull(str)) {
                str = this.adf.getString(d.k.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.bjr().fV(this.ept.VU)) {
                this.ept.VO = 2;
            } else if (com.baidu.tieba.recapp.download.d.bjr().an(this.ept.VU, str)) {
                if (com.baidu.tieba.recapp.download.d.bjr().fT(this.ept.VU)) {
                    this.ept.VO = 1;
                } else {
                    this.ept.VO = 3;
                }
            }
            switch (this.ept.VO) {
                case 0:
                    String string = this.adf.getString(d.k.install_app);
                    if (this.ept.Wb != null && !StringUtils.isNull(this.ept.Wb.buttonText)) {
                        string = this.ept.Wb.buttonText;
                    }
                    if (string.length() > epr) {
                        string = string.substring(0, epr);
                    }
                    this.epv.og(string);
                    return;
                case 1:
                    this.epv.aJc();
                    return;
                case 2:
                    this.epv.aJd();
                    return;
                case 3:
                    this.epv.og(this.adf.getString(d.k.pb_download_pause));
                    return;
                default:
                    this.epv.aJb().setVisibility(8);
                    this.epv.p(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.adf.getPageActivity());
            if (j.gR()) {
                string = this.adf.getString(d.k.frs_network_tips);
            } else {
                string = this.adf.getString(d.k.confirm_download_app);
            }
            aVar.dc(string);
            aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.ept.VQ;
                    if (StringUtils.isNull(str)) {
                        str = a.this.adf.getString(d.k.app_name);
                    }
                    a.this.epw.aJi();
                    if (s.a(a.this.adf.getPageActivity(), a.this.ept, 0, str)) {
                        a.this.epw.oh(a.this.ept.VU);
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
            aVar.b(this.adf).tD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.ept != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.ept.VU, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.ept.VO = 2;
                    } else if (status == 2 || status == 4) {
                        if (!an.isEmpty(downloadData.getStatusMsg())) {
                            this.adf.showToast(downloadData.getStatusMsg());
                        }
                        this.ept.VO = 0;
                    } else if (status == 1) {
                        this.ept.VO = 1;
                    }
                    aIV();
                }
            }
        }
    }

    public void aIY() {
        if (!this.epx) {
            this.epx = true;
            this.epw.aJh();
        }
    }
}
