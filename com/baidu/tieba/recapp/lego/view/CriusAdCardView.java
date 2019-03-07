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
    private LinearLayout gzT;
    protected String iiV;
    private com.baidu.c.a.d.a ijK;
    private ViewGroup ijL;
    private HeadImageView ijM;
    private ApkDownloadView ijN;
    private AdCloseView ijO;
    private JumpButton ijP;
    private AdThreadCommentAndPraiseInfoLayout ijQ;
    private CriusAdCard ijR;
    private boolean ijS;
    protected CustomMessageListener ijT;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ijS = true;
        this.ijT = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.iiV) && CriusAdCardView.this.iiV.equals(downloadData.getId()) && CriusAdCardView.this.ijN != null) {
                    CriusAdCardView.this.ijN.s(downloadData);
                }
            }
        };
        this.ijK = new com.baidu.c.a.d.a();
        this.ijK.a(new a.InterfaceC0036a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.c.a.d.a.InterfaceC0036a
            public void c(String str, Map<String, String> map) {
                String str2;
                String str3;
                int f = s.f(CriusAdCardView.this.mContext, str);
                if (f == 1 || f == 2) {
                    if (CriusAdCardView.this.gHy != null) {
                        CriusAdCardView.this.gHy.b(f, null);
                    }
                } else if (CriusAdCardView.this.gHy != null) {
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
                    CriusAdCardView.this.gHy.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAd() {
        this.gzT = new LinearLayout(this.mContext.getPageActivity());
        this.gzT.setOrientation(1);
        return this.gzT;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        al.k(this.ijL, d.f.addresslist_item_bg);
        this.ijK.i(this.mContext.getPageActivity(), i == 1);
        if (this.ijN != null) {
            this.ijN.onChangeSkinType(i);
        }
        if (this.ijO != null) {
            this.ijO.onChangeSkinType();
        }
        if (this.ijQ != null) {
            this.ijQ.onChangeSkinType();
        }
        al.k(this.ijP, d.f.btn_focus_border_bg);
        al.d(this.ijP, d.C0236d.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.ijR = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            bXb();
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.ijM != null) {
            this.ijM.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.age() || advertAppInfo == null) {
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
        if (advertAppInfo != null && advertAppInfo.Xb()) {
            this.ijT.setTag(this.mContext.getUniqueId());
            MessageManager.getInstance().registerListener(this.ijT);
            this.iiV = advertAppInfo.bwF;
            DownloadData c = c(advertAppInfo, b.l(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            this.ijN.setData(c);
            this.ijN.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.ijO != null && advertAppInfo != null && advertAppInfo.bwL != null && advertAppInfo.bwL.adCloseInfo != null && advertAppInfo.bwL.adCloseInfo.support_close.intValue() > 0) {
            this.ijO.setPage(getBusinessType());
            this.ijO.setData(advertAppInfo);
            this.ijO.onChangeSkinType();
            l.b(this.mContext.getPageActivity(), this.ijO, 40, 40, 40, 120);
        }
    }

    private void bWZ() {
        if (this.ijP != null) {
            this.ijP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.c.a.c.a cL;
                    if (CriusAdCardView.this.criusData != null && (cL = CriusAdCardView.this.criusData.cL("viewbtn")) != null) {
                        if (!q.Cs(cL.adp) && CriusAdCardView.this.gHy != null) {
                            CriusAdCardView.this.gHy.b(cL.adq, cL.adr, null);
                        }
                        if (TextUtils.isEmpty(cL.ads)) {
                            int f = s.f(CriusAdCardView.this.mContext, cL.adp);
                            if ((f == 1 || f == 2) && CriusAdCardView.this.gHy != null) {
                                CriusAdCardView.this.gHy.b(f, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.mContext.getPageActivity());
                        aVar.ly(cL.ads);
                        aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int f2 = s.f(CriusAdCardView.this.mContext, cL.adp);
                                if ((f2 == 1 || f2 == 2) && CriusAdCardView.this.gHy != null) {
                                    CriusAdCardView.this.gHy.b(f2, null);
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
                        aVar.b(CriusAdCardView.this.mContext).aaZ();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        final com.baidu.c.a.c.a cL;
        if (this.ijQ != null && (cL = this.criusData.cL("bottombar")) != null) {
            a(this.ijR.getAdvertAppInfo(), cL);
            this.ijQ.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.ijQ.setBarNameClickEnabled(false);
            this.ijQ.setReplyTimeVisible(false);
            if (cL.adt != Integer.MIN_VALUE) {
                this.ijQ.setShareClickable(true);
                this.ijQ.setShareContainerBgGray(false);
            } else {
                this.ijQ.setShareClickable(false);
                this.ijQ.setShareContainerBgGray(true);
            }
            this.ijQ.getCommentContainer().setOnClickListener(aVar);
            this.ijQ.setNeedAddReplyIcon(true);
            this.ijQ.setCommentNumEnable(true);
            this.ijQ.setCommentClickable(true);
            this.ijQ.setReplayContainerBgGray(true);
            this.ijQ.setOnClickListener(aVar);
            this.ijQ.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // com.baidu.tieba.recapp.c.a
                public String getTitle() {
                    return cL.shareTitle;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getAbstract() {
                    return cL.shareContent;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getImageUrl() {
                    return cL.adw;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getShareLink() {
                    return cL.adx;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public AdvertAppInfo getThreadData() {
                    return CriusAdCardView.this.ijR.getAdvertAppInfo();
                }
            });
            if (cL.adv != Integer.MIN_VALUE) {
                this.ijQ.setAgreeClickable(true);
                this.ijQ.setPraiseContainerBgGray(false);
            } else {
                this.ijQ.setAgreeClickable(false);
                this.ijQ.setPraiseContainerBgGray(true);
            }
            this.ijQ.onChangeSkinType();
        }
    }

    public void a(bg bgVar, com.baidu.c.a.c.a aVar) {
        if (bgVar != null && aVar != null) {
            if (this.ijS || (bgVar.aak() <= 0 && bgVar.aao() <= 0)) {
                if (this.ijS) {
                    this.ijS = false;
                }
                bgVar.gr(aVar.adu);
                bgVar.gz(aVar.adv);
                bgVar.ah(aVar.adt);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.ijR != null) {
            distributeVideoView.setPageContext(this.mContext);
            distributeVideoView.setVideoTailFrameData(this.ijR.tailFrame);
            distributeVideoView.setChargeInfo(this.ijR.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void bXa() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.ijR.getAdvertAppInfo();
        a aVar = new a(this.ijR);
        this.ijL.setOnClickListener(aVar);
        View cO = this.ijK.cO("head");
        if (cO != null && (cO instanceof HeadImageView)) {
            this.ijM = (HeadImageView) cO;
            setHeadLongClick(advertAppInfo);
        }
        View cO2 = this.ijK.cO("download");
        if (cO2 != null && (cO2 instanceof ApkDownloadView)) {
            this.ijN = (ApkDownloadView) cO2;
            this.ijN.q(this.mContext.getUniqueId());
            this.ijN.setOnClickListener(aVar);
            j(advertAppInfo);
        }
        View cO3 = this.ijK.cO("closead");
        if (cO3 != null && (cO3 instanceof AdCloseView)) {
            this.ijO = (AdCloseView) cO3;
            k(advertAppInfo);
        }
        View cO4 = this.ijK.cO("viewbtn");
        if (cO4 != null && (cO4 instanceof JumpButton)) {
            this.ijP = (JumpButton) cO4;
            bWZ();
        }
        View cO5 = this.ijK.cO("bottombar");
        if (cO5 != null && (cO5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) cO5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.ijQ = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View cP = this.ijK.cP("video");
        if (cP != null && (distributeVideoView = (DistributeVideoView) cP.findViewById(d.g.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View cP = this.ijK.cP("video");
        if (cP == null || (distributeVideoView = (DistributeVideoView) cP.findViewById(d.g.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View cP = this.ijK.cP("video");
        if (cP != null && (distributeVideoView = (DistributeVideoView) cP.findViewById(d.g.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard ijX;

        public a(CriusAdCard criusAdCard) {
            this.ijX = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                CriusAdCardView.this.mContext.showToast(d.j.neterror);
            } else if (this.ijX != null) {
                AdvertAppInfo advertAppInfo = this.ijX.getAdvertAppInfo();
                boolean z = view == CriusAdCardView.this.ijN;
                if (advertAppInfo != null && advertAppInfo.Xb()) {
                    int l = b.l(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, l));
                    if ((6 != status && 7 != status) || !j.kY() || j.kZ()) {
                        CriusAdCardView.this.a(advertAppInfo, l, CriusAdCardView.this.ijN, z);
                        if (CriusAdCardView.this.gHy != null) {
                            CriusAdCardView.this.gHy.b(3, null);
                            return;
                        }
                        return;
                    }
                    CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, l, true, "");
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.adp;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.bwD;
                }
                int f = s.f(CriusAdCardView.this.mContext, str);
                if (CriusAdCardView.this.gHy != null) {
                    CriusAdCardView.this.gHy.b(f, null);
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
                    g.aS(this.mContext.getPageActivity(), advertAppInfo.bwF);
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
        DownloadData downloadData = new DownloadData(advertAppInfo.bwF);
        downloadData.setUrl(advertAppInfo.bwE);
        downloadData.setName(advertAppInfo.bwC);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.l(advertAppInfo.bwB, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.kM()) {
                l.showToast(this.mContext.getPageActivity(), d.j.neterror);
            } else if (advertAppInfo.Xb()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.ly(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.ijN != null) {
                            CriusAdCardView.this.ijN.p(CriusAdCardView.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).aaZ();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.Xa() != 0) {
                l.showToast(this.mContext.getPageActivity(), d.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.adQ();
            this.mPermissionJudgePolicy.e(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.Y(this.mContext.getPageActivity()) && this.gHz != null) {
                this.gHz.b(advertAppInfo, i);
                if (this.ijN != null) {
                    this.ijN.p(c(advertAppInfo, i));
                }
            }
        }
    }

    private void bXb() {
        if (this.gzT != null && this.ijK != null) {
            this.gzT.removeAllViews();
            this.ijL = this.ijK.a(this.mContext.getPageActivity(), this.criusData, TbadkCoreApplication.getInst().getSkinType() == 1);
            this.gzT.addView(this.ijL);
            al.k(this.ijL, d.f.addresslist_item_bg);
            bXa();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void bAk() {
        if (this.ijK != null && ((TextView) this.ijK.cP("title")) != null) {
            this.criusData.d("title", TbConfig.getContentSize() / l.aR(this.mContext.getPageActivity()));
            bXb();
        }
    }
}
