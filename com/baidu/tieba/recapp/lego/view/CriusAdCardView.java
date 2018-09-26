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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.data.d;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.e;
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
    private com.baidu.b.a.c.a criusData;
    private LinearLayout eQz;
    protected String gxE;
    private CriusAdCard gyA;
    private boolean gyB;
    protected CustomMessageListener gyC;
    private com.baidu.b.a.d.a gyt;
    private ViewGroup gyu;
    private HeadImageView gyv;
    private ApkDownloadView gyw;
    private AdCloseView gyx;
    private JumpButton gyy;
    private AdThreadCommentAndPraiseInfoLayout gyz;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gyB = true;
        this.gyC = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.gxE) && CriusAdCardView.this.gxE.equals(downloadData.getId()) && CriusAdCardView.this.gyw != null) {
                    CriusAdCardView.this.gyw.s(downloadData);
                }
            }
        };
        this.gyt = new com.baidu.b.a.d.a();
        this.gyt.a(new a.InterfaceC0054a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.b.a.d.a.InterfaceC0054a
            public void c(String str, Map<String, String> map) {
                String str2;
                String str3;
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (e == 1 || e == 2) {
                    if (CriusAdCardView.this.eXP != null) {
                        CriusAdCardView.this.eXP.b(e, null);
                    }
                } else if (CriusAdCardView.this.eXP != null) {
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
                    CriusAdCardView.this.eXP.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aTI() {
        this.eQz = new LinearLayout(this.mContext.getPageActivity());
        this.eQz.setOrientation(1);
        return this.eQz;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        al.i(this.gyu, e.f.addresslist_item_bg);
        this.gyt.i(this.mContext.getPageActivity(), i == 1);
        if (this.gyw != null) {
            this.gyw.onChangeSkinType(i);
        }
        if (this.gyx != null) {
            this.gyx.onChangeSkinType();
        }
        if (this.gyz != null) {
            this.gyz.onChangeSkinType();
        }
        al.i(this.gyy, e.f.btn_focus_border_bg);
        al.c(this.gyy, e.d.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.gyA = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            bqq();
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.gyv != null) {
            this.gyv.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.De() || advertAppInfo == null) {
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
        if (advertAppInfo != null && advertAppInfo.uI()) {
            this.gyC.setTag(this.mContext.getUniqueId());
            MessageManager.getInstance().registerListener(this.gyC);
            this.gxE = advertAppInfo.agk;
            DownloadData c = c(advertAppInfo, b.l(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gyw.setData(c);
            this.gyw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.gyx != null && advertAppInfo != null && advertAppInfo.agr != null && advertAppInfo.agr.adCloseInfo != null && advertAppInfo.agr.adCloseInfo.support_close.intValue() > 0) {
            this.gyx.setPage(getBusinessType());
            this.gyx.setData(advertAppInfo);
            this.gyx.onChangeSkinType();
            l.a(this.mContext.getPageActivity(), this.gyx, 40, 40, 40, 120);
        }
    }

    private void bqo() {
        if (this.gyy != null) {
            this.gyy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.b.a.c.a cK;
                    if (CriusAdCardView.this.criusData != null && (cK = CriusAdCardView.this.criusData.cK("viewbtn")) != null) {
                        if (!q.up(cK.WB) && CriusAdCardView.this.eXP != null) {
                            CriusAdCardView.this.eXP.b(cK.WC, cK.WD, null);
                        }
                        if (TextUtils.isEmpty(cK.WE)) {
                            int e = s.e(CriusAdCardView.this.mContext, cK.WB);
                            if ((e == 1 || e == 2) && CriusAdCardView.this.eXP != null) {
                                CriusAdCardView.this.eXP.b(e, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.mContext.getPageActivity());
                        aVar.dT(cK.WE);
                        aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int e2 = s.e(CriusAdCardView.this.mContext, cK.WB);
                                if ((e2 == 1 || e2 == 2) && CriusAdCardView.this.eXP != null) {
                                    CriusAdCardView.this.eXP.b(e2, null);
                                }
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(CriusAdCardView.this.mContext).yl();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        final com.baidu.b.a.c.a cK;
        if (this.gyz != null && (cK = this.criusData.cK("bottombar")) != null) {
            a(this.gyA.getAdvertAppInfo(), cK);
            this.gyz.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.gyz.setBarNameClickEnabled(false);
            this.gyz.setReplyTimeVisible(false);
            if (cK.WF != Integer.MIN_VALUE) {
                this.gyz.setShareClickable(true);
                this.gyz.setShareContainerBgGray(false);
            } else {
                this.gyz.setShareClickable(false);
                this.gyz.setShareContainerBgGray(true);
            }
            this.gyz.getCommentContainer().setOnClickListener(aVar);
            this.gyz.setNeedAddReplyIcon(true);
            this.gyz.setCommentNumEnable(true);
            this.gyz.setCommentClickable(true);
            this.gyz.setReplayContainerBgGray(true);
            this.gyz.setOnClickListener(aVar);
            this.gyz.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // com.baidu.tieba.recapp.c.a
                public String getTitle() {
                    return cK.shareTitle;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getAbstract() {
                    return cK.shareContent;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getImageUrl() {
                    return cK.WI;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getShareLink() {
                    return cK.WJ;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public AdvertAppInfo getThreadData() {
                    return CriusAdCardView.this.gyA.getAdvertAppInfo();
                }
            });
            if (cK.WH != Integer.MIN_VALUE) {
                this.gyz.setAgreeClickable(true);
                this.gyz.setPraiseContainerBgGray(false);
            } else {
                this.gyz.setAgreeClickable(false);
                this.gyz.setPraiseContainerBgGray(true);
            }
            this.gyz.onChangeSkinType();
        }
    }

    public void a(bb bbVar, com.baidu.b.a.c.a aVar) {
        if (bbVar != null && aVar != null) {
            if (this.gyB || (bbVar.xy() <= 0 && bbVar.xC() <= 0)) {
                if (this.gyB) {
                    this.gyB = false;
                }
                bbVar.cc(aVar.WG);
                bbVar.cl(aVar.WH);
                bbVar.v(aVar.WF);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.gyA != null) {
            distributeVideoView.setPageContext(this.mContext);
            distributeVideoView.setVideoTailFrameData(this.gyA.tailFrame);
            distributeVideoView.setChargeInfo(this.gyA.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void bqp() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.gyA.getAdvertAppInfo();
        a aVar = new a(this.gyA);
        this.gyu.setOnClickListener(aVar);
        View cN = this.gyt.cN("head");
        if (cN != null && (cN instanceof HeadImageView)) {
            this.gyv = (HeadImageView) cN;
            setHeadLongClick(advertAppInfo);
        }
        View cN2 = this.gyt.cN("download");
        if (cN2 != null && (cN2 instanceof ApkDownloadView)) {
            this.gyw = (ApkDownloadView) cN2;
            this.gyw.p(this.mContext.getUniqueId());
            this.gyw.setOnClickListener(aVar);
            j(advertAppInfo);
        }
        View cN3 = this.gyt.cN("closead");
        if (cN3 != null && (cN3 instanceof AdCloseView)) {
            this.gyx = (AdCloseView) cN3;
            k(advertAppInfo);
        }
        View cN4 = this.gyt.cN("viewbtn");
        if (cN4 != null && (cN4 instanceof JumpButton)) {
            this.gyy = (JumpButton) cN4;
            bqo();
        }
        View cN5 = this.gyt.cN("bottombar");
        if (cN5 != null && (cN5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) cN5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.gyz = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View cO = this.gyt.cO("video");
        if (cO != null && (distributeVideoView = (DistributeVideoView) cO.findViewById(e.g.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View cO = this.gyt.cO("video");
        if (cO == null || (distributeVideoView = (DistributeVideoView) cO.findViewById(e.g.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View cO = this.gyt.cO("video");
        if (cO != null && (distributeVideoView = (DistributeVideoView) cO.findViewById(e.g.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard gyG;

        public a(CriusAdCard criusAdCard) {
            this.gyG = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.ky()) {
                CriusAdCardView.this.mContext.showToast(e.j.neterror);
            } else if (this.gyG != null) {
                AdvertAppInfo advertAppInfo = this.gyG.getAdvertAppInfo();
                boolean z = view == CriusAdCardView.this.gyw;
                if (advertAppInfo != null && advertAppInfo.uI()) {
                    int l = b.l(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, l));
                    if ((6 != status && 7 != status) || !j.kK() || j.kL()) {
                        CriusAdCardView.this.a(advertAppInfo, l, CriusAdCardView.this.gyw, z);
                        if (CriusAdCardView.this.eXP != null) {
                            CriusAdCardView.this.eXP.b(3, null);
                            return;
                        }
                        return;
                    }
                    CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, l, true, "");
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.WB;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.agi;
                }
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (CriusAdCardView.this.eXP != null) {
                    CriusAdCardView.this.eXP.b(e, null);
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
                    g.aD(this.mContext.getPageActivity(), advertAppInfo.agk);
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
        DownloadData downloadData = new DownloadData(advertAppInfo.agk);
        downloadData.setUrl(advertAppInfo.agj);
        downloadData.setName(advertAppInfo.agg);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.l(advertAppInfo.agf, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.ky()) {
                l.showToast(this.mContext.getPageActivity(), e.j.neterror);
            } else if (advertAppInfo.uI()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(e.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dT(str);
                aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.gyw != null) {
                            CriusAdCardView.this.gyw.p(CriusAdCardView.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).yl();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.uH() != 0) {
                l.showToast(this.mContext.getPageActivity(), e.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.Bb();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.x(this.mContext.getPageActivity()) && this.eXQ != null) {
                this.eXQ.b(advertAppInfo, i);
                if (this.gyw != null) {
                    this.gyw.p(c(advertAppInfo, i));
                }
            }
        }
    }

    private void bqq() {
        if (this.eQz != null && this.gyt != null) {
            this.eQz.removeAllViews();
            this.gyu = this.gyt.a(this.mContext.getPageActivity(), this.criusData, TbadkCoreApplication.getInst().getSkinType() == 1);
            this.eQz.addView(this.gyu);
            al.i(this.gyu, e.f.addresslist_item_bg);
            bqp();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aTR() {
        if (this.gyt != null && ((TextView) this.gyt.cO("title")) != null) {
            this.criusData.d("title", TbConfig.getContentSize() / l.aR(this.mContext.getPageActivity()));
            bqq();
        }
    }
}
