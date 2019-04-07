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
import com.baidu.c.a.d.a;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.c;
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
    private com.baidu.c.a.c.a criusData;
    private LinearLayout gzG;
    protected String iiB;
    private com.baidu.c.a.d.a ijq;
    private ViewGroup ijr;
    private HeadImageView ijs;
    private ApkDownloadView ijt;
    private AdCloseView iju;
    private JumpButton ijv;
    private AdThreadCommentAndPraiseInfoLayout ijw;
    private CriusAdCard ijx;
    private boolean ijy;
    protected CustomMessageListener ijz;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ijy = true;
        this.ijz = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.iiB) && CriusAdCardView.this.iiB.equals(downloadData.getId()) && CriusAdCardView.this.ijt != null) {
                    CriusAdCardView.this.ijt.s(downloadData);
                }
            }
        };
        this.ijq = new com.baidu.c.a.d.a();
        this.ijq.a(new a.InterfaceC0038a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.c.a.d.a.InterfaceC0038a
            public void c(String str, Map<String, String> map) {
                String str2;
                String str3;
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (e == 1 || e == 2) {
                    if (CriusAdCardView.this.gHl != null) {
                        CriusAdCardView.this.gHl.b(e, null);
                    }
                } else if (CriusAdCardView.this.gHl != null) {
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
                    CriusAdCardView.this.gHl.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAa() {
        this.gzG = new LinearLayout(this.mContext.getPageActivity());
        this.gzG.setOrientation(1);
        return this.gzG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        al.k(this.ijr, d.f.addresslist_item_bg);
        this.ijq.i(this.mContext.getPageActivity(), i == 1);
        if (this.ijt != null) {
            this.ijt.onChangeSkinType(i);
        }
        if (this.iju != null) {
            this.iju.onChangeSkinType();
        }
        if (this.ijw != null) {
            this.ijw.onChangeSkinType();
        }
        al.k(this.ijv, d.f.btn_focus_border_bg);
        al.d(this.ijv, d.C0277d.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.ijx = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            bXa();
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.ijs != null) {
            this.ijs.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.agb() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.bh(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void j(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.WY()) {
            this.ijz.setTag(this.mContext.getUniqueId());
            MessageManager.getInstance().registerListener(this.ijz);
            this.iiB = advertAppInfo.bwK;
            DownloadData c = c(advertAppInfo, b.l(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            this.ijt.setData(c);
            this.ijt.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.iju != null && advertAppInfo != null && advertAppInfo.bwQ != null && advertAppInfo.bwQ.adCloseInfo != null && advertAppInfo.bwQ.adCloseInfo.support_close.intValue() > 0) {
            this.iju.setPage(getBusinessType());
            this.iju.setData(advertAppInfo);
            this.iju.onChangeSkinType();
            l.b(this.mContext.getPageActivity(), this.iju, 40, 40, 40, 120);
        }
    }

    private void bWY() {
        if (this.ijv != null) {
            this.ijv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.c.a.c.a cN;
                    if (CriusAdCardView.this.criusData != null && (cN = CriusAdCardView.this.criusData.cN("viewbtn")) != null) {
                        if (!q.Cq(cN.adv) && CriusAdCardView.this.gHl != null) {
                            CriusAdCardView.this.gHl.b(cN.adw, cN.adx, null);
                        }
                        if (TextUtils.isEmpty(cN.ady)) {
                            int e = s.e(CriusAdCardView.this.mContext, cN.adv);
                            if ((e == 1 || e == 2) && CriusAdCardView.this.gHl != null) {
                                CriusAdCardView.this.gHl.b(e, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.mContext.getPageActivity());
                        aVar.lz(cN.ady);
                        aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int e2 = s.e(CriusAdCardView.this.mContext, cN.adv);
                                if ((e2 == 1 || e2 == 2) && CriusAdCardView.this.gHl != null) {
                                    CriusAdCardView.this.gHl.b(e2, null);
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
                        aVar.b(CriusAdCardView.this.mContext).aaW();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        final com.baidu.c.a.c.a cN;
        if (this.ijw != null && (cN = this.criusData.cN("bottombar")) != null) {
            a(this.ijx.getAdvertAppInfo(), cN);
            this.ijw.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.ijw.setBarNameClickEnabled(false);
            this.ijw.setReplyTimeVisible(false);
            if (cN.adz != Integer.MIN_VALUE) {
                this.ijw.setShareClickable(true);
                this.ijw.setShareContainerBgGray(false);
            } else {
                this.ijw.setShareClickable(false);
                this.ijw.setShareContainerBgGray(true);
            }
            this.ijw.getCommentContainer().setOnClickListener(aVar);
            this.ijw.setNeedAddReplyIcon(true);
            this.ijw.setCommentNumEnable(true);
            this.ijw.setCommentClickable(true);
            this.ijw.setReplayContainerBgGray(true);
            this.ijw.setOnClickListener(aVar);
            this.ijw.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // com.baidu.tieba.recapp.c.a
                public String getTitle() {
                    return cN.shareTitle;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getAbstract() {
                    return cN.shareContent;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getImageUrl() {
                    return cN.adC;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getShareLink() {
                    return cN.adD;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public AdvertAppInfo getThreadData() {
                    return CriusAdCardView.this.ijx.getAdvertAppInfo();
                }
            });
            if (cN.adB != Integer.MIN_VALUE) {
                this.ijw.setAgreeClickable(true);
                this.ijw.setPraiseContainerBgGray(false);
            } else {
                this.ijw.setAgreeClickable(false);
                this.ijw.setPraiseContainerBgGray(true);
            }
            this.ijw.onChangeSkinType();
        }
    }

    public void a(bg bgVar, com.baidu.c.a.c.a aVar) {
        if (bgVar != null && aVar != null) {
            if (this.ijy || (bgVar.aah() <= 0 && bgVar.aal() <= 0)) {
                if (this.ijy) {
                    this.ijy = false;
                }
                bgVar.gq(aVar.adA);
                bgVar.gy(aVar.adB);
                bgVar.ah(aVar.adz);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.ijx != null) {
            distributeVideoView.setPageContext(this.mContext);
            distributeVideoView.setVideoTailFrameData(this.ijx.tailFrame);
            distributeVideoView.setChargeInfo(this.ijx.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void bWZ() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.ijx.getAdvertAppInfo();
        a aVar = new a(this.ijx);
        this.ijr.setOnClickListener(aVar);
        View cQ = this.ijq.cQ("head");
        if (cQ != null && (cQ instanceof HeadImageView)) {
            this.ijs = (HeadImageView) cQ;
            setHeadLongClick(advertAppInfo);
        }
        View cQ2 = this.ijq.cQ("download");
        if (cQ2 != null && (cQ2 instanceof ApkDownloadView)) {
            this.ijt = (ApkDownloadView) cQ2;
            this.ijt.q(this.mContext.getUniqueId());
            this.ijt.setOnClickListener(aVar);
            j(advertAppInfo);
        }
        View cQ3 = this.ijq.cQ("closead");
        if (cQ3 != null && (cQ3 instanceof AdCloseView)) {
            this.iju = (AdCloseView) cQ3;
            k(advertAppInfo);
        }
        View cQ4 = this.ijq.cQ("viewbtn");
        if (cQ4 != null && (cQ4 instanceof JumpButton)) {
            this.ijv = (JumpButton) cQ4;
            bWY();
        }
        View cQ5 = this.ijq.cQ("bottombar");
        if (cQ5 != null && (cQ5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) cQ5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.ijw = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View cR = this.ijq.cR("video");
        if (cR != null && (distributeVideoView = (DistributeVideoView) cR.findViewById(d.g.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View cR = this.ijq.cR("video");
        if (cR == null || (distributeVideoView = (DistributeVideoView) cR.findViewById(d.g.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View cR = this.ijq.cR("video");
        if (cR != null && (distributeVideoView = (DistributeVideoView) cR.findViewById(d.g.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard ijD;

        public a(CriusAdCard criusAdCard) {
            this.ijD = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                CriusAdCardView.this.mContext.showToast(d.j.neterror);
            } else if (this.ijD != null) {
                AdvertAppInfo advertAppInfo = this.ijD.getAdvertAppInfo();
                boolean z = view == CriusAdCardView.this.ijt;
                if (advertAppInfo != null && advertAppInfo.WY()) {
                    int l = b.l(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, l));
                    if ((6 != status && 7 != status) || !j.kY() || j.kZ()) {
                        CriusAdCardView.this.a(advertAppInfo, l, CriusAdCardView.this.ijt, z);
                        if (CriusAdCardView.this.gHl != null) {
                            CriusAdCardView.this.gHl.b(3, null);
                            return;
                        }
                        return;
                    }
                    CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, l, true, "");
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.adv;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.bwI;
                }
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (CriusAdCardView.this.gHl != null) {
                    CriusAdCardView.this.gHl.b(e, null);
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
                    g.aR(this.mContext.getPageActivity(), advertAppInfo.bwK);
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
        DownloadData downloadData = new DownloadData(advertAppInfo.bwK);
        downloadData.setUrl(advertAppInfo.bwJ);
        downloadData.setName(advertAppInfo.bwH);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.l(advertAppInfo.bwG, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.kM()) {
                l.showToast(this.mContext.getPageActivity(), d.j.neterror);
            } else if (advertAppInfo.WY()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.lz(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.ijt != null) {
                            CriusAdCardView.this.ijt.p(CriusAdCardView.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).aaW();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.WX() != 0) {
                l.showToast(this.mContext.getPageActivity(), d.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.adN();
            this.mPermissionJudgePolicy.e(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.Y(this.mContext.getPageActivity()) && this.gHm != null) {
                this.gHm.b(advertAppInfo, i);
                if (this.ijt != null) {
                    this.ijt.p(c(advertAppInfo, i));
                }
            }
        }
    }

    private void bXa() {
        if (this.gzG != null && this.ijq != null) {
            this.gzG.removeAllViews();
            this.ijr = this.ijq.a(this.mContext.getPageActivity(), this.criusData, TbadkCoreApplication.getInst().getSkinType() == 1);
            this.gzG.addView(this.ijr);
            al.k(this.ijr, d.f.addresslist_item_bg);
            bWZ();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void bAh() {
        if (this.ijq != null && ((TextView) this.ijq.cR("title")) != null) {
            this.criusData.d("title", TbConfig.getContentSize() / l.aR(this.mContext.getPageActivity()));
            bXa();
        }
    }
}
