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
import com.baidu.tieba.d;
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
    private LinearLayout eJo;
    private com.baidu.b.a.d.a gqY;
    private ViewGroup gqZ;
    protected String gqj;
    private HeadImageView gra;
    private ApkDownloadView grb;
    private AdCloseView grc;
    private JumpButton grd;
    private AdThreadCommentAndPraiseInfoLayout gre;
    private CriusAdCard grf;
    private boolean grg;
    protected CustomMessageListener grh;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.grg = true;
        this.grh = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.gqj) && CriusAdCardView.this.gqj.equals(downloadData.getId()) && CriusAdCardView.this.grb != null) {
                    CriusAdCardView.this.grb.s(downloadData);
                }
            }
        };
        this.gqY = new com.baidu.b.a.d.a();
        this.gqY.a(new a.InterfaceC0054a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.b.a.d.a.InterfaceC0054a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (e == 1 || e == 2) {
                    if (CriusAdCardView.this.eQz != null) {
                        CriusAdCardView.this.eQz.b(e, null);
                    }
                } else if (CriusAdCardView.this.eQz != null) {
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
                    CriusAdCardView.this.eQz.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aRx() {
        this.eJo = new LinearLayout(this.mContext.getPageActivity());
        this.eJo.setOrientation(1);
        return this.eJo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        am.i(this.gqZ, d.f.addresslist_item_bg);
        this.gqY.s(this.mContext.getPageActivity(), i == 1);
        if (this.grb != null) {
            this.grb.onChangeSkinType(i);
        }
        if (this.grc != null) {
            this.grc.onChangeSkinType();
        }
        if (this.gre != null) {
            this.gre.onChangeSkinType();
        }
        am.i(this.grd, d.f.btn_focus_border_bg);
        am.c(this.grd, d.C0140d.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.grf = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            bnI();
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.gra != null) {
            this.gra.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.BT() || advertAppInfo == null) {
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
        if (advertAppInfo != null && advertAppInfo.tG()) {
            this.grh.setTag(this.mContext.getUniqueId());
            MessageManager.getInstance().registerListener(this.grh);
            this.gqj = advertAppInfo.adJ;
            DownloadData c = c(advertAppInfo, b.g(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            this.grb.setData(c);
            this.grb.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.grc != null && advertAppInfo != null && advertAppInfo.adQ != null && advertAppInfo.adQ.adCloseInfo != null && advertAppInfo.adQ.adCloseInfo.support_close.intValue() > 0) {
            this.grc.setPage(getBusinessType());
            this.grc.setData(advertAppInfo);
            this.grc.onChangeSkinType();
            l.a(this.mContext.getPageActivity(), this.grc, 40, 40, 40, 120);
        }
    }

    private void bnG() {
        if (this.grd != null) {
            this.grd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.b.a.c.a cu;
                    if (CriusAdCardView.this.criusData != null && (cu = CriusAdCardView.this.criusData.cu("viewbtn")) != null) {
                        if (!q.tE(cu.TZ) && CriusAdCardView.this.eQz != null) {
                            CriusAdCardView.this.eQz.b(cu.Ua, cu.Ub, null);
                        }
                        if (TextUtils.isEmpty(cu.Uc)) {
                            int e = s.e(CriusAdCardView.this.mContext, cu.TZ);
                            if ((e == 1 || e == 2) && CriusAdCardView.this.eQz != null) {
                                CriusAdCardView.this.eQz.b(e, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.mContext.getPageActivity());
                        aVar.dB(cu.Uc);
                        aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int e2 = s.e(CriusAdCardView.this.mContext, cu.TZ);
                                if ((e2 == 1 || e2 == 2) && CriusAdCardView.this.eQz != null) {
                                    CriusAdCardView.this.eQz.b(e2, null);
                                }
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(CriusAdCardView.this.mContext).xf();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        final com.baidu.b.a.c.a cu;
        if (this.gre != null && (cu = this.criusData.cu("bottombar")) != null) {
            a(this.grf.getAdvertAppInfo(), cu);
            this.gre.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.gre.setBarNameClickEnabled(false);
            this.gre.setReplyTimeVisible(false);
            if (cu.Ud != Integer.MIN_VALUE) {
                this.gre.setShareClickable(true);
                this.gre.setShareContainerBgGray(false);
            } else {
                this.gre.setShareClickable(false);
                this.gre.setShareContainerBgGray(true);
            }
            this.gre.getCommentContainer().setOnClickListener(aVar);
            this.gre.setNeedAddReplyIcon(true);
            this.gre.setCommentNumEnable(true);
            this.gre.setCommentClickable(true);
            this.gre.setReplayContainerBgGray(true);
            this.gre.setOnClickListener(aVar);
            this.gre.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
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
                    return CriusAdCardView.this.grf.getAdvertAppInfo();
                }
            });
            if (cu.Uf != Integer.MIN_VALUE) {
                this.gre.setAgreeClickable(true);
                this.gre.setPraiseContainerBgGray(false);
            } else {
                this.gre.setAgreeClickable(false);
                this.gre.setPraiseContainerBgGray(true);
            }
            this.gre.onChangeSkinType();
        }
    }

    public void a(bb bbVar, com.baidu.b.a.c.a aVar) {
        if (bbVar != null && aVar != null) {
            if (this.grg || (bbVar.wu() <= 0 && bbVar.ww() <= 0)) {
                if (this.grg) {
                    this.grg = false;
                }
                bbVar.bT(aVar.Ue);
                bbVar.cc(aVar.Uf);
                bbVar.r(aVar.Ud);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.grf != null) {
            distributeVideoView.setPageContext(this.mContext);
            distributeVideoView.setVideoTailFrameData(this.grf.tailFrame);
            distributeVideoView.setChargeInfo(this.grf.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.adi);
            }
        }
    }

    private void bnH() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.grf.getAdvertAppInfo();
        a aVar = new a(this.grf);
        this.gqZ.setOnClickListener(aVar);
        View cx = this.gqY.cx("head");
        if (cx != null && (cx instanceof HeadImageView)) {
            this.gra = (HeadImageView) cx;
            setHeadLongClick(advertAppInfo);
        }
        View cx2 = this.gqY.cx("download");
        if (cx2 != null && (cx2 instanceof ApkDownloadView)) {
            this.grb = (ApkDownloadView) cx2;
            this.grb.q(this.mContext.getUniqueId());
            this.grb.setOnClickListener(aVar);
            j(advertAppInfo);
        }
        View cx3 = this.gqY.cx("closead");
        if (cx3 != null && (cx3 instanceof AdCloseView)) {
            this.grc = (AdCloseView) cx3;
            k(advertAppInfo);
        }
        View cx4 = this.gqY.cx("viewbtn");
        if (cx4 != null && (cx4 instanceof JumpButton)) {
            this.grd = (JumpButton) cx4;
            bnG();
        }
        View cx5 = this.gqY.cx("bottombar");
        if (cx5 != null && (cx5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) cx5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.gre = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View cy = this.gqY.cy("video");
        if (cy != null && (distributeVideoView = (DistributeVideoView) cy.findViewById(d.g.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View cy = this.gqY.cy("video");
        if (cy == null || (distributeVideoView = (DistributeVideoView) cy.findViewById(d.g.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View cy = this.gqY.cy("video");
        if (cy != null && (distributeVideoView = (DistributeVideoView) cy.findViewById(d.g.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard grl;

        public a(CriusAdCard criusAdCard) {
            this.grl = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.js()) {
                CriusAdCardView.this.mContext.showToast(d.j.neterror);
            } else if (this.grl != null) {
                AdvertAppInfo advertAppInfo = this.grl.getAdvertAppInfo();
                boolean z = view == CriusAdCardView.this.grb;
                if (advertAppInfo != null && advertAppInfo.tG()) {
                    int g = b.g(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, g));
                    if ((6 != status && 7 != status) || !j.jE() || j.jF()) {
                        CriusAdCardView.this.a(advertAppInfo, g, CriusAdCardView.this.grb, z);
                        if (CriusAdCardView.this.eQz != null) {
                            CriusAdCardView.this.eQz.b(3, null);
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
                if (CriusAdCardView.this.eQz != null) {
                    CriusAdCardView.this.eQz.b(e, null);
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
                l.showToast(this.mContext.getPageActivity(), d.j.neterror);
            } else if (advertAppInfo.tG()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dB(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.grb != null) {
                            CriusAdCardView.this.grb.p(CriusAdCardView.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).xf();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.tF() != 0) {
                l.showToast(this.mContext.getPageActivity(), d.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.zY();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.u(this.mContext.getPageActivity()) && this.eQA != null) {
                this.eQA.b(advertAppInfo, i);
                if (this.grb != null) {
                    this.grb.p(c(advertAppInfo, i));
                }
            }
        }
    }

    private void bnI() {
        if (this.eJo != null && this.gqY != null) {
            this.eJo.removeAllViews();
            this.gqZ = this.gqY.a(this.mContext.getPageActivity(), this.criusData, TbadkCoreApplication.getInst().getSkinType() == 1);
            this.eJo.addView(this.gqZ);
            am.i(this.gqZ, d.f.addresslist_item_bg);
            bnH();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aRG() {
        if (this.gqY != null && ((TextView) this.gqY.cy("title")) != null) {
            this.criusData.d("title", TbConfig.getContentSize() / l.ak(this.mContext.getPageActivity()));
            bnI();
        }
    }
}
