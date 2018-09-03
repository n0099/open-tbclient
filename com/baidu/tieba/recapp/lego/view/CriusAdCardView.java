package com.baidu.tieba.recapp.lego.view;

import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.b.a.d.a;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.data.c;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.f;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.k;
import com.baidu.tieba.recapp.lego.model.CriusAdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.tbadkCore.q;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class CriusAdCardView extends BaseLegoCardView<CriusAdCard> implements k {
    private com.baidu.b.a.c.a criusData;
    private LinearLayout eJj;
    protected String gqm;
    private com.baidu.b.a.d.a grb;
    private ViewGroup grc;
    private HeadImageView grd;
    private ApkDownloadView gre;
    private AdCloseView grf;
    private JumpButton grg;
    private AdThreadCommentAndPraiseInfoLayout grh;
    private CriusAdCard gri;
    private boolean grj;
    protected CustomMessageListener grk;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.grj = true;
        this.grk = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.gqm) && CriusAdCardView.this.gqm.equals(downloadData.getId()) && CriusAdCardView.this.gre != null) {
                    CriusAdCardView.this.gre.s(downloadData);
                }
            }
        };
        this.grb = new com.baidu.b.a.d.a();
        this.grb.a(new a.InterfaceC0054a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.b.a.d.a.InterfaceC0054a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (e == 1 || e == 2) {
                    if (CriusAdCardView.this.eQu != null) {
                        CriusAdCardView.this.eQu.b(e, null);
                    }
                } else if (CriusAdCardView.this.eQu != null) {
                    if (map == null) {
                        str2 = "";
                        str3 = "";
                    } else {
                        if (!map.containsKey("data-als-stat")) {
                            str2 = "";
                        } else {
                            str2 = map.get("data-als-stat");
                        }
                        str3 = map.containsKey("data-url-stat") ? map.get("data-url-stat") : "";
                    }
                    CriusAdCardView.this.eQu.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aRu() {
        this.eJj = new LinearLayout(this.mContext.getPageActivity());
        this.eJj.setOrientation(1);
        return this.eJj;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        am.i(this.grc, f.C0146f.addresslist_item_bg);
        this.grb.g(this.mContext.getPageActivity(), i == 1);
        if (this.gre != null) {
            this.gre.onChangeSkinType(i);
        }
        if (this.grf != null) {
            this.grf.onChangeSkinType();
        }
        if (this.grh != null) {
            this.grh.onChangeSkinType();
        }
        am.i(this.grg, f.C0146f.btn_focus_border_bg);
        am.c(this.grg, f.d.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.gri = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            bnJ();
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.grd != null) {
            this.grd.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.BQ() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.aQ(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void j(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.tF()) {
            this.grk.setTag(this.mContext.getUniqueId());
            MessageManager.getInstance().registerListener(this.grk);
            this.gqm = advertAppInfo.adJ;
            DownloadData c = c(advertAppInfo, b.g(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gre.setData(c);
            this.gre.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.grf != null && advertAppInfo != null && advertAppInfo.adQ != null && advertAppInfo.adQ.adCloseInfo != null && advertAppInfo.adQ.adCloseInfo.support_close.intValue() > 0) {
            this.grf.setPage(getBusinessType());
            this.grf.setData(advertAppInfo);
            this.grf.onChangeSkinType();
            l.a(this.mContext.getPageActivity(), this.grf, 40, 40, 40, 120);
        }
    }

    private void bnH() {
        if (this.grg != null) {
            this.grg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.b.a.c.a cu;
                    if (CriusAdCardView.this.criusData != null && (cu = CriusAdCardView.this.criusData.cu("viewbtn")) != null) {
                        if (!q.tI(cu.TZ) && CriusAdCardView.this.eQu != null) {
                            CriusAdCardView.this.eQu.b(cu.Ua, cu.Ub, null);
                        }
                        if (TextUtils.isEmpty(cu.Uc)) {
                            int e = s.e(CriusAdCardView.this.mContext, cu.TZ);
                            if ((e == 1 || e == 2) && CriusAdCardView.this.eQu != null) {
                                CriusAdCardView.this.eQu.b(e, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.mContext.getPageActivity());
                        aVar.dB(cu.Uc);
                        aVar.a(f.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int e2 = s.e(CriusAdCardView.this.mContext, cu.TZ);
                                if ((e2 == 1 || e2 == 2) && CriusAdCardView.this.eQu != null) {
                                    CriusAdCardView.this.eQu.b(e2, null);
                                }
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(CriusAdCardView.this.mContext).xe();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        final com.baidu.b.a.c.a cu;
        if (this.grh != null && (cu = this.criusData.cu("bottombar")) != null) {
            a(this.gri.getAdvertAppInfo(), cu);
            this.grh.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.grh.setBarNameClickEnabled(false);
            this.grh.setReplyTimeVisible(false);
            if (cu.Ud != Integer.MIN_VALUE) {
                this.grh.setShareClickable(true);
                this.grh.setShareContainerBgGray(false);
            } else {
                this.grh.setShareClickable(false);
                this.grh.setShareContainerBgGray(true);
            }
            this.grh.getCommentContainer().setOnClickListener(aVar);
            this.grh.setNeedAddReplyIcon(true);
            this.grh.setCommentNumEnable(true);
            this.grh.setCommentClickable(true);
            this.grh.setReplayContainerBgGray(true);
            this.grh.setOnClickListener(aVar);
            this.grh.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // com.baidu.tieba.recapp.c.a
                public String getTitle() {
                    return cu.shareTitle;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getAbstract() {
                    return cu.shareContent;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getImageUrl() {
                    return cu.Ug;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getShareLink() {
                    return cu.Uh;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public AdvertAppInfo getThreadData() {
                    return CriusAdCardView.this.gri.getAdvertAppInfo();
                }
            });
            if (cu.Uf != Integer.MIN_VALUE) {
                this.grh.setAgreeClickable(true);
                this.grh.setPraiseContainerBgGray(false);
            } else {
                this.grh.setAgreeClickable(false);
                this.grh.setPraiseContainerBgGray(true);
            }
            this.grh.onChangeSkinType();
        }
    }

    public void a(bb bbVar, com.baidu.b.a.c.a aVar) {
        if (bbVar != null && aVar != null) {
            if (this.grj || (bbVar.wt() <= 0 && bbVar.wv() <= 0)) {
                if (this.grj) {
                    this.grj = false;
                }
                bbVar.bT(aVar.Ue);
                bbVar.cc(aVar.Uf);
                bbVar.r(aVar.Ud);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.gri != null) {
            distributeVideoView.setPageContext(this.mContext);
            distributeVideoView.setVideoTailFrameData(this.gri.tailFrame);
            distributeVideoView.setChargeInfo(this.gri.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void bnI() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.gri.getAdvertAppInfo();
        a aVar = new a(this.gri);
        this.grc.setOnClickListener(aVar);
        View cx = this.grb.cx("head");
        if (cx != null && (cx instanceof HeadImageView)) {
            this.grd = (HeadImageView) cx;
            setHeadLongClick(advertAppInfo);
        }
        View cx2 = this.grb.cx("download");
        if (cx2 != null && (cx2 instanceof ApkDownloadView)) {
            this.gre = (ApkDownloadView) cx2;
            this.gre.q(this.mContext.getUniqueId());
            this.gre.setOnClickListener(aVar);
            j(advertAppInfo);
        }
        View cx3 = this.grb.cx("closead");
        if (cx3 != null && (cx3 instanceof AdCloseView)) {
            this.grf = (AdCloseView) cx3;
            k(advertAppInfo);
        }
        View cx4 = this.grb.cx("viewbtn");
        if (cx4 != null && (cx4 instanceof JumpButton)) {
            this.grg = (JumpButton) cx4;
            bnH();
        }
        View cx5 = this.grb.cx("bottombar");
        if (cx5 != null && (cx5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) cx5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.grh = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View cy = this.grb.cy("video");
        if (cy != null && (distributeVideoView = (DistributeVideoView) cy.findViewById(f.g.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View cy = this.grb.cy("video");
        if (cy == null || (distributeVideoView = (DistributeVideoView) cy.findViewById(f.g.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View cy = this.grb.cy("video");
        if (cy != null && (distributeVideoView = (DistributeVideoView) cy.findViewById(f.g.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard gro;

        public a(CriusAdCard criusAdCard) {
            this.gro = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.js()) {
                CriusAdCardView.this.mContext.showToast(f.j.neterror);
            } else if (this.gro != null) {
                AdvertAppInfo advertAppInfo = this.gro.getAdvertAppInfo();
                boolean z = view == CriusAdCardView.this.gre;
                if (advertAppInfo != null && advertAppInfo.tF()) {
                    int g = b.g(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, g));
                    if ((6 != status && 7 != status) || !j.jE() || j.jF()) {
                        CriusAdCardView.this.a(advertAppInfo, g, CriusAdCardView.this.gre, z);
                        if (CriusAdCardView.this.eQu != null) {
                            CriusAdCardView.this.eQu.b(3, null);
                            return;
                        }
                        return;
                    }
                    CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, g, true, "");
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.TZ;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.adH;
                }
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (CriusAdCardView.this.eQu != null) {
                    CriusAdCardView.this.eQu.b(e, null);
                }
            }
        }
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo != null && apkDownloadView != null) {
            DownloadData c = c(advertAppInfo, i);
            switch (ApkDownloadView.getStatus(c)) {
                case 1:
                case 5:
                    if (z) {
                        g.f(advertAppInfo);
                        apkDownloadView.q(c);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    g.an(this.mContext.getPageActivity(), advertAppInfo.adJ);
                    return;
                case 6:
                case 7:
                    d(advertAppInfo, i);
                    apkDownloadView.r(c);
                    return;
            }
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.adJ);
        downloadData.setUrl(advertAppInfo.adI);
        downloadData.setName(advertAppInfo.adF);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.g(advertAppInfo.adE, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.js()) {
                l.showToast(this.mContext.getPageActivity(), f.j.neterror);
            } else if (advertAppInfo.tF()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(f.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dB(str);
                aVar.a(f.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.gre != null) {
                            CriusAdCardView.this.gre.p(CriusAdCardView.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).xe();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.tE() != 0) {
                l.showToast(this.mContext.getPageActivity(), f.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.zW();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.u(this.mContext.getPageActivity()) && this.eQv != null) {
                this.eQv.b(advertAppInfo, i);
                if (this.gre != null) {
                    this.gre.p(c(advertAppInfo, i));
                }
            }
        }
    }

    private void bnJ() {
        if (this.eJj != null && this.grb != null) {
            this.eJj.removeAllViews();
            this.grc = this.grb.a(this.mContext.getPageActivity(), this.criusData, TbadkCoreApplication.getInst().getSkinType() == 1);
            this.eJj.addView(this.grc);
            am.i(this.grc, f.C0146f.addresslist_item_bg);
            bnI();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aRD() {
        if (this.grb != null && ((TextView) this.grb.cy("title")) != null) {
            this.criusData.d("title", TbConfig.getContentSize() / l.ak(this.mContext.getPageActivity()));
            bnJ();
        }
    }
}
