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
    private LinearLayout gQW;
    protected String iBq;
    private com.baidu.c.a.d.a iCf;
    private ViewGroup iCg;
    private HeadImageView iCh;
    private ApkDownloadView iCi;
    private AdCloseView iCj;
    private JumpButton iCk;
    private AdThreadCommentAndPraiseInfoLayout iCl;
    private CriusAdCard iCm;
    private boolean iCn;
    protected CustomMessageListener iCo;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iCn = true;
        this.iCo = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.iBq) && CriusAdCardView.this.iBq.equals(downloadData.getId()) && CriusAdCardView.this.iCi != null) {
                    CriusAdCardView.this.iCi.s(downloadData);
                }
            }
        };
        this.iCf = new com.baidu.c.a.d.a();
        this.iCf.a(new a.InterfaceC0037a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.c.a.d.a.InterfaceC0037a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (e == 1 || e == 2) {
                    if (CriusAdCardView.this.gYJ != null) {
                        CriusAdCardView.this.gYJ.b(e, null);
                    }
                } else if (CriusAdCardView.this.gYJ != null) {
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
                    CriusAdCardView.this.gYJ.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bHN() {
        this.gQW = new LinearLayout(this.mContext.getPageActivity());
        this.gQW.setOrientation(1);
        return this.gQW;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        al.k(this.iCg, R.drawable.addresslist_item_bg);
        this.iCf.g(this.mContext.getPageActivity(), i == 1);
        if (this.iCi != null) {
            this.iCi.onChangeSkinType(i);
        }
        if (this.iCj != null) {
            this.iCj.onChangeSkinType();
        }
        if (this.iCl != null) {
            this.iCl.onChangeSkinType();
        }
        al.k(this.iCk, R.drawable.btn_focus_border_bg);
        al.f(this.iCk, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.iCm = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            cfg();
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.iCh != null) {
            this.iCh.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
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
            this.iCo.setTag(this.mContext.getUniqueId());
            MessageManager.getInstance().registerListener(this.iCo);
            this.iBq = advertAppInfo.bDW;
            DownloadData c = c(advertAppInfo, b.f(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            this.iCi.setData(c);
            this.iCi.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.iCj != null && advertAppInfo != null && advertAppInfo.bEc != null && advertAppInfo.bEc.adCloseInfo != null && advertAppInfo.bEc.adCloseInfo.support_close.intValue() > 0) {
            this.iCj.setPage(getBusinessType());
            this.iCj.setData(advertAppInfo);
            this.iCj.onChangeSkinType();
            l.b(this.mContext.getPageActivity(), this.iCj, 40, 40, 40, 120);
        }
    }

    private void cfe() {
        if (this.iCk != null) {
            this.iCk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.c.a.c.a cx;
                    if (CriusAdCardView.this.criusData != null && (cx = CriusAdCardView.this.criusData.cx("viewbtn")) != null) {
                        if (!q.DM(cx.abj) && CriusAdCardView.this.gYJ != null) {
                            CriusAdCardView.this.gYJ.b(cx.abk, cx.abl, null);
                        }
                        if (TextUtils.isEmpty(cx.abm)) {
                            int e = s.e(CriusAdCardView.this.mContext, cx.abj);
                            if ((e == 1 || e == 2) && CriusAdCardView.this.gYJ != null) {
                                CriusAdCardView.this.gYJ.b(e, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.mContext.getPageActivity());
                        aVar.mE(cx.abm);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int e2 = s.e(CriusAdCardView.this.mContext, cx.abj);
                                if ((e2 == 1 || e2 == 2) && CriusAdCardView.this.gYJ != null) {
                                    CriusAdCardView.this.gYJ.b(e2, null);
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
        final com.baidu.c.a.c.a cx;
        if (this.iCl != null && (cx = this.criusData.cx("bottombar")) != null) {
            a(this.iCm.getAdvertAppInfo(), cx);
            this.iCl.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.iCl.setBarNameClickEnabled(false);
            this.iCl.setReplyTimeVisible(false);
            if (cx.abn != Integer.MIN_VALUE) {
                this.iCl.setShareClickable(true);
                this.iCl.setShareContainerBgGray(false);
            } else {
                this.iCl.setShareClickable(false);
                this.iCl.setShareContainerBgGray(true);
            }
            this.iCl.getCommentContainer().setOnClickListener(aVar);
            this.iCl.setNeedAddReplyIcon(true);
            this.iCl.setCommentNumEnable(true);
            this.iCl.setCommentClickable(true);
            this.iCl.setReplayContainerBgGray(true);
            this.iCl.setOnClickListener(aVar);
            this.iCl.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // com.baidu.tieba.recapp.c.a
                public String getTitle() {
                    return cx.shareTitle;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getAbstract() {
                    return cx.shareContent;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getImageUrl() {
                    return cx.abq;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getShareLink() {
                    return cx.abr;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public AdvertAppInfo getThreadData() {
                    return CriusAdCardView.this.iCm.getAdvertAppInfo();
                }
            });
            if (cx.abp != Integer.MIN_VALUE) {
                this.iCl.setAgreeClickable(true);
                this.iCl.setPraiseContainerBgGray(false);
            } else {
                this.iCl.setAgreeClickable(false);
                this.iCl.setPraiseContainerBgGray(true);
            }
            this.iCl.onChangeSkinType();
        }
    }

    public void a(bg bgVar, com.baidu.c.a.c.a aVar) {
        if (bgVar != null && aVar != null) {
            if (this.iCn || (bgVar.aeO() <= 0 && bgVar.aeS() <= 0)) {
                if (this.iCn) {
                    this.iCn = false;
                }
                bgVar.hc(aVar.abo);
                bgVar.hk(aVar.abp);
                bgVar.at(aVar.abn);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.iCm != null) {
            distributeVideoView.setPageContext(this.mContext);
            distributeVideoView.setVideoTailFrameData(this.iCm.tailFrame);
            distributeVideoView.setChargeInfo(this.iCm.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void cff() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.iCm.getAdvertAppInfo();
        a aVar = new a(this.iCm);
        this.iCg.setOnClickListener(aVar);
        View cA = this.iCf.cA("head");
        if (cA != null && (cA instanceof HeadImageView)) {
            this.iCh = (HeadImageView) cA;
            setHeadLongClick(advertAppInfo);
        }
        View cA2 = this.iCf.cA("download");
        if (cA2 != null && (cA2 instanceof ApkDownloadView)) {
            this.iCi = (ApkDownloadView) cA2;
            this.iCi.s(this.mContext.getUniqueId());
            this.iCi.setOnClickListener(aVar);
            j(advertAppInfo);
        }
        View cA3 = this.iCf.cA("closead");
        if (cA3 != null && (cA3 instanceof AdCloseView)) {
            this.iCj = (AdCloseView) cA3;
            k(advertAppInfo);
        }
        View cA4 = this.iCf.cA("viewbtn");
        if (cA4 != null && (cA4 instanceof JumpButton)) {
            this.iCk = (JumpButton) cA4;
            cfe();
        }
        View cA5 = this.iCf.cA("bottombar");
        if (cA5 != null && (cA5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) cA5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.iCl = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View cB = this.iCf.cB("video");
        if (cB != null && (distributeVideoView = (DistributeVideoView) cB.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View cB = this.iCf.cB("video");
        if (cB == null || (distributeVideoView = (DistributeVideoView) cB.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View cB = this.iCf.cB("video");
        if (cB != null && (distributeVideoView = (DistributeVideoView) cB.findViewById(R.id.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard iCs;

        public a(CriusAdCard criusAdCard) {
            this.iCs = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jG()) {
                CriusAdCardView.this.mContext.showToast(R.string.neterror);
            } else if (this.iCs != null) {
                AdvertAppInfo advertAppInfo = this.iCs.getAdvertAppInfo();
                boolean z = view == CriusAdCardView.this.iCi;
                if (advertAppInfo != null && advertAppInfo.abF()) {
                    int f = b.f(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, f));
                    if ((6 != status && 7 != status) || !j.jS() || j.jT()) {
                        CriusAdCardView.this.a(advertAppInfo, f, CriusAdCardView.this.iCi, z);
                        if (CriusAdCardView.this.gYJ != null) {
                            CriusAdCardView.this.gYJ.b(3, null);
                            return;
                        }
                        return;
                    }
                    CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, f, true, "");
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.abj;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.bDU;
                }
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (CriusAdCardView.this.gYJ != null) {
                    CriusAdCardView.this.gYJ.b(e, null);
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
                    g.aF(this.mContext.getPageActivity(), advertAppInfo.bDW);
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
        DownloadData downloadData = new DownloadData(advertAppInfo.bDW);
        downloadData.setUrl(advertAppInfo.bDV);
        downloadData.setName(advertAppInfo.bDT);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.f(advertAppInfo.bDS, 0));
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
                aVar.mE(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.iCi != null) {
                            CriusAdCardView.this.iCi.p(CriusAdCardView.this.c(advertAppInfo, i));
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
            if (!this.mPermissionJudgePolicy.aa(this.mContext.getPageActivity()) && this.gYK != null) {
                this.gYK.b(advertAppInfo, i);
                if (this.iCi != null) {
                    this.iCi.p(c(advertAppInfo, i));
                }
            }
        }
    }

    private void cfg() {
        if (this.gQW != null && this.iCf != null) {
            this.gQW.removeAllViews();
            this.iCg = this.iCf.a(this.mContext.getPageActivity(), this.criusData, TbadkCoreApplication.getInst().getSkinType() == 1);
            this.gQW.addView(this.iCg);
            al.k(this.iCg, R.drawable.addresslist_item_bg);
            cff();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void bHU() {
        if (this.iCf != null && ((TextView) this.iCf.cB("title")) != null) {
            this.criusData.d("title", TbConfig.getContentSize() / l.ai(this.mContext.getPageActivity()));
            cfg();
        }
    }
}
