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
import com.baidu.tbadk.coreExtra.data.d;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
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
    private LinearLayout gQY;
    protected String iBr;
    private com.baidu.c.a.d.a iCg;
    private ViewGroup iCh;
    private HeadImageView iCi;
    private ApkDownloadView iCj;
    private AdCloseView iCk;
    private JumpButton iCl;
    private AdThreadCommentAndPraiseInfoLayout iCm;
    private CriusAdCard iCn;
    private boolean iCo;
    protected CustomMessageListener iCp;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iCo = true;
        this.iCp = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.iBr) && CriusAdCardView.this.iBr.equals(downloadData.getId()) && CriusAdCardView.this.iCj != null) {
                    CriusAdCardView.this.iCj.s(downloadData);
                }
            }
        };
        this.iCg = new com.baidu.c.a.d.a();
        this.iCg.a(new a.InterfaceC0037a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.c.a.d.a.InterfaceC0037a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (e == 1 || e == 2) {
                    if (CriusAdCardView.this.gYK != null) {
                        CriusAdCardView.this.gYK.b(e, null);
                    }
                } else if (CriusAdCardView.this.gYK != null) {
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
                    CriusAdCardView.this.gYK.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bHO() {
        this.gQY = new LinearLayout(this.mContext.getPageActivity());
        this.gQY.setOrientation(1);
        return this.gQY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        al.k(this.iCh, R.drawable.addresslist_item_bg);
        this.iCg.g(this.mContext.getPageActivity(), i == 1);
        if (this.iCj != null) {
            this.iCj.onChangeSkinType(i);
        }
        if (this.iCk != null) {
            this.iCk.onChangeSkinType();
        }
        if (this.iCm != null) {
            this.iCm.onChangeSkinType();
        }
        al.k(this.iCl, R.drawable.btn_focus_border_bg);
        al.f(this.iCl, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.iCn = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            cfh();
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.iCi != null) {
            this.iCi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.ala() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.aR(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void j(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.abF()) {
            this.iCp.setTag(this.mContext.getUniqueId());
            MessageManager.getInstance().registerListener(this.iCp);
            this.iBr = advertAppInfo.bDX;
            DownloadData c = c(advertAppInfo, b.f(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            this.iCj.setData(c);
            this.iCj.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.iCk != null && advertAppInfo != null && advertAppInfo.bEd != null && advertAppInfo.bEd.adCloseInfo != null && advertAppInfo.bEd.adCloseInfo.support_close.intValue() > 0) {
            this.iCk.setPage(getBusinessType());
            this.iCk.setData(advertAppInfo);
            this.iCk.onChangeSkinType();
            l.b(this.mContext.getPageActivity(), this.iCk, 40, 40, 40, 120);
        }
    }

    private void cff() {
        if (this.iCl != null) {
            this.iCl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.c.a.c.a cw;
                    if (CriusAdCardView.this.criusData != null && (cw = CriusAdCardView.this.criusData.cw("viewbtn")) != null) {
                        if (!q.DO(cw.abj) && CriusAdCardView.this.gYK != null) {
                            CriusAdCardView.this.gYK.b(cw.abk, cw.abl, null);
                        }
                        if (TextUtils.isEmpty(cw.abm)) {
                            int e = s.e(CriusAdCardView.this.mContext, cw.abj);
                            if ((e == 1 || e == 2) && CriusAdCardView.this.gYK != null) {
                                CriusAdCardView.this.gYK.b(e, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.mContext.getPageActivity());
                        aVar.mD(cw.abm);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int e2 = s.e(CriusAdCardView.this.mContext, cw.abj);
                                if ((e2 == 1 || e2 == 2) && CriusAdCardView.this.gYK != null) {
                                    CriusAdCardView.this.gYK.b(e2, null);
                                }
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(CriusAdCardView.this.mContext).afG();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        final com.baidu.c.a.c.a cw;
        if (this.iCm != null && (cw = this.criusData.cw("bottombar")) != null) {
            a(this.iCn.getAdvertAppInfo(), cw);
            this.iCm.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.iCm.setBarNameClickEnabled(false);
            this.iCm.setReplyTimeVisible(false);
            if (cw.abn != Integer.MIN_VALUE) {
                this.iCm.setShareClickable(true);
                this.iCm.setShareContainerBgGray(false);
            } else {
                this.iCm.setShareClickable(false);
                this.iCm.setShareContainerBgGray(true);
            }
            this.iCm.getCommentContainer().setOnClickListener(aVar);
            this.iCm.setNeedAddReplyIcon(true);
            this.iCm.setCommentNumEnable(true);
            this.iCm.setCommentClickable(true);
            this.iCm.setReplayContainerBgGray(true);
            this.iCm.setOnClickListener(aVar);
            this.iCm.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // com.baidu.tieba.recapp.c.a
                public String getTitle() {
                    return cw.shareTitle;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getAbstract() {
                    return cw.shareContent;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getImageUrl() {
                    return cw.abq;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getShareLink() {
                    return cw.abr;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public AdvertAppInfo getThreadData() {
                    return CriusAdCardView.this.iCn.getAdvertAppInfo();
                }
            });
            if (cw.abp != Integer.MIN_VALUE) {
                this.iCm.setAgreeClickable(true);
                this.iCm.setPraiseContainerBgGray(false);
            } else {
                this.iCm.setAgreeClickable(false);
                this.iCm.setPraiseContainerBgGray(true);
            }
            this.iCm.onChangeSkinType();
        }
    }

    public void a(bg bgVar, com.baidu.c.a.c.a aVar) {
        if (bgVar != null && aVar != null) {
            if (this.iCo || (bgVar.aeO() <= 0 && bgVar.aeS() <= 0)) {
                if (this.iCo) {
                    this.iCo = false;
                }
                bgVar.hc(aVar.abo);
                bgVar.hk(aVar.abp);
                bgVar.at(aVar.abn);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.iCn != null) {
            distributeVideoView.setPageContext(this.mContext);
            distributeVideoView.setVideoTailFrameData(this.iCn.tailFrame);
            distributeVideoView.setChargeInfo(this.iCn.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void cfg() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.iCn.getAdvertAppInfo();
        a aVar = new a(this.iCn);
        this.iCh.setOnClickListener(aVar);
        View cz = this.iCg.cz("head");
        if (cz != null && (cz instanceof HeadImageView)) {
            this.iCi = (HeadImageView) cz;
            setHeadLongClick(advertAppInfo);
        }
        View cz2 = this.iCg.cz("download");
        if (cz2 != null && (cz2 instanceof ApkDownloadView)) {
            this.iCj = (ApkDownloadView) cz2;
            this.iCj.s(this.mContext.getUniqueId());
            this.iCj.setOnClickListener(aVar);
            j(advertAppInfo);
        }
        View cz3 = this.iCg.cz("closead");
        if (cz3 != null && (cz3 instanceof AdCloseView)) {
            this.iCk = (AdCloseView) cz3;
            k(advertAppInfo);
        }
        View cz4 = this.iCg.cz("viewbtn");
        if (cz4 != null && (cz4 instanceof JumpButton)) {
            this.iCl = (JumpButton) cz4;
            cff();
        }
        View cz5 = this.iCg.cz("bottombar");
        if (cz5 != null && (cz5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) cz5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.iCm = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View cA = this.iCg.cA("video");
        if (cA != null && (distributeVideoView = (DistributeVideoView) cA.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View cA = this.iCg.cA("video");
        if (cA == null || (distributeVideoView = (DistributeVideoView) cA.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View cA = this.iCg.cA("video");
        if (cA != null && (distributeVideoView = (DistributeVideoView) cA.findViewById(R.id.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard iCt;

        public a(CriusAdCard criusAdCard) {
            this.iCt = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if (!j.jG()) {
                CriusAdCardView.this.mContext.showToast(R.string.neterror);
            } else if (this.iCt != null) {
                AdvertAppInfo advertAppInfo = this.iCt.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.abF()) {
                    int f = b.f(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, f));
                    if ((6 == status || 7 == status) && j.jS() && !j.jT()) {
                        CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, f, true, "");
                        return;
                    }
                    if (!TextUtils.equals(advertAppInfo.page, "PB_BANNER") && view != CriusAdCardView.this.iCj) {
                        z = false;
                    }
                    CriusAdCardView.this.a(advertAppInfo, f, CriusAdCardView.this.iCj, z);
                    if (CriusAdCardView.this.gYK != null) {
                        CriusAdCardView.this.gYK.b(3, null);
                        return;
                    }
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.abj;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.bDV;
                }
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (CriusAdCardView.this.gYK != null) {
                    CriusAdCardView.this.gYK.b(e, null);
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
                    g.aF(this.mContext.getPageActivity(), advertAppInfo.bDX);
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
        DownloadData downloadData = new DownloadData(advertAppInfo.bDX);
        downloadData.setUrl(advertAppInfo.bDW);
        downloadData.setName(advertAppInfo.bDU);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.f(advertAppInfo.bDT, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.jG()) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.abF()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.mD(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.iCj != null) {
                            CriusAdCardView.this.iCj.p(CriusAdCardView.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).afG();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.abE() != 0) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.aiM();
            this.mPermissionJudgePolicy.e(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.aa(this.mContext.getPageActivity()) && this.gYL != null) {
                this.gYL.b(advertAppInfo, i);
                if (this.iCj != null) {
                    this.iCj.p(c(advertAppInfo, i));
                }
            }
        }
    }

    private void cfh() {
        if (this.gQY != null && this.iCg != null) {
            this.gQY.removeAllViews();
            this.iCh = this.iCg.a(this.mContext.getPageActivity(), this.criusData, TbadkCoreApplication.getInst().getSkinType() == 1);
            this.gQY.addView(this.iCh);
            al.k(this.iCh, R.drawable.addresslist_item_bg);
            cfg();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void bHV() {
        if (this.iCg != null && ((TextView) this.iCg.cA("title")) != null) {
            this.criusData.d("title", TbConfig.getContentSize() / l.ai(this.mContext.getPageActivity()));
            cfh();
        }
    }
}
