package com.baidu.tieba.recapp.lego.view;

import android.app.Activity;
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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.data.d;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.download.h;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.k;
import com.baidu.tieba.recapp.lego.model.CriusAdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class CriusAdCardView extends BaseLegoCardView<CriusAdCard> implements k {
    private com.baidu.c.a.c.a criusData;
    private LinearLayout gZU;
    private com.baidu.c.a.d.a iLY;
    private ViewGroup iLZ;
    protected String iLj;
    private HeadImageView iMa;
    private ApkDownloadView iMb;
    private AdCloseView iMc;
    private JumpButton iMd;
    private AdThreadCommentAndPraiseInfoLayout iMe;
    private CriusAdCard iMf;
    private boolean iMg;
    protected CustomMessageListener iMh;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iMg = true;
        this.iMh = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.iLj) && CriusAdCardView.this.iLj.equals(downloadData.getId()) && CriusAdCardView.this.iMb != null) {
                    CriusAdCardView.this.iMb.s(downloadData);
                }
            }
        };
        this.iLY = new com.baidu.c.a.d.a();
        this.iLY.a(new a.InterfaceC0037a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.c.a.d.a.InterfaceC0037a
            public void b(String str, Map<String, String> map) {
                String str2;
                String str3;
                int a2 = s.a(CriusAdCardView.this.mContext, str, (CriusAdCardView.this.iMf == null || CriusAdCardView.this.iMf.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.iMf.getAdvertAppInfo().bFs);
                if (a2 == 1 || a2 == 2) {
                    if (CriusAdCardView.this.hhI != null) {
                        CriusAdCardView.this.hhI.b(a2, null);
                    }
                } else if (CriusAdCardView.this.hhI != null) {
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
                    CriusAdCardView.this.hhI.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bLw() {
        this.gZU = new LinearLayout(this.mContext.getPageActivity());
        this.gZU.setOrientation(1);
        return this.gZU;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        am.k(this.iLZ, R.drawable.addresslist_item_bg);
        this.iLY.g(this.mContext.getPageActivity(), i == 1 || i == 4);
        if (this.iMb != null) {
            this.iMb.onChangeSkinType(i);
        }
        if (this.iMc != null) {
            this.iMc.onChangeSkinType();
        }
        if (this.iMe != null) {
            this.iMe.onChangeSkinType();
        }
        am.k(this.iMd, R.drawable.btn_focus_border_bg);
        am.f(this.iMd, R.color.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.iMf = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            cje();
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.iMa != null) {
            this.iMa.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.amt() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.aS(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void j(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.acM()) {
            this.iMh.setTag(this.mContext.getUniqueId());
            MessageManager.getInstance().registerListener(this.iMh);
            this.iLj = advertAppInfo.bFw;
            DownloadData c = c(advertAppInfo, b.f(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            this.iMb.setData(c);
            this.iMb.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.iMc != null && advertAppInfo != null && advertAppInfo.bFC != null && advertAppInfo.bFC.adCloseInfo != null && advertAppInfo.bFC.adCloseInfo.support_close.intValue() > 0) {
            this.iMc.setPage(getBusinessType());
            this.iMc.setData(advertAppInfo);
            this.iMc.onChangeSkinType();
            l.b(this.mContext.getPageActivity(), this.iMc, 40, 40, 40, 120);
        }
    }

    private void cjc() {
        if (this.iMd != null) {
            this.iMd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.c.a.c.a cz;
                    if (CriusAdCardView.this.criusData != null && (cz = CriusAdCardView.this.criusData.cz("viewbtn")) != null) {
                        if (!com.baidu.tieba.tbadkCore.s.Fc(cz.abH) && CriusAdCardView.this.hhI != null) {
                            CriusAdCardView.this.hhI.b(cz.abI, cz.abJ, null);
                        }
                        if (TextUtils.isEmpty(cz.abK)) {
                            int a2 = s.a(CriusAdCardView.this.mContext, cz.abH, (CriusAdCardView.this.iMf == null || CriusAdCardView.this.iMf.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.iMf.getAdvertAppInfo().bFs);
                            if ((a2 == 1 || a2 == 2) && CriusAdCardView.this.hhI != null) {
                                CriusAdCardView.this.hhI.b(a2, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.mContext.getPageActivity());
                        aVar.mQ(cz.abK);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int a3 = s.a(CriusAdCardView.this.mContext, cz.abH, (CriusAdCardView.this.iMf == null || CriusAdCardView.this.iMf.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.iMf.getAdvertAppInfo().bFs);
                                if ((a3 == 1 || a3 == 2) && CriusAdCardView.this.hhI != null) {
                                    CriusAdCardView.this.hhI.b(a3, null);
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
                        aVar.b(CriusAdCardView.this.mContext).agO();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        final com.baidu.c.a.c.a cz;
        if (this.iMe != null && (cz = this.criusData.cz("bottombar")) != null) {
            a(this.iMf.getAdvertAppInfo(), cz);
            this.iMe.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.iMe.setBarNameClickEnabled(false);
            this.iMe.setReplyTimeVisible(false);
            if (cz.abL != Integer.MIN_VALUE) {
                this.iMe.setShareClickable(true);
                this.iMe.setShareContainerBgGray(false);
            } else {
                this.iMe.setShareClickable(false);
                this.iMe.setShareContainerBgGray(true);
            }
            this.iMe.getCommentContainer().setOnClickListener(aVar);
            this.iMe.setNeedAddReplyIcon(true);
            this.iMe.setCommentNumEnable(true);
            this.iMe.setCommentClickable(true);
            this.iMe.setReplayContainerBgGray(true);
            this.iMe.setOnClickListener(aVar);
            this.iMe.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // com.baidu.tieba.recapp.c.a
                public String getTitle() {
                    return cz.shareTitle;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getAbstract() {
                    return cz.shareContent;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getImageUrl() {
                    return cz.abO;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getShareLink() {
                    return cz.abP;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public AdvertAppInfo getThreadData() {
                    return CriusAdCardView.this.iMf.getAdvertAppInfo();
                }
            });
            if (cz.abN != Integer.MIN_VALUE) {
                this.iMe.setAgreeClickable(true);
                this.iMe.setPraiseContainerBgGray(false);
            } else {
                this.iMe.setAgreeClickable(false);
                this.iMe.setPraiseContainerBgGray(true);
            }
            this.iMe.onChangeSkinType();
        }
    }

    public void a(bh bhVar, com.baidu.c.a.c.a aVar) {
        if (bhVar != null && aVar != null) {
            if (this.iMg || (bhVar.afV() <= 0 && bhVar.afZ() <= 0)) {
                if (this.iMg) {
                    this.iMg = false;
                }
                bhVar.hj(aVar.abM);
                bhVar.hr(aVar.abN);
                bhVar.au(aVar.abL);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.iMf != null) {
            distributeVideoView.setPageContext(this.mContext);
            distributeVideoView.setVideoTailFrameData(this.iMf.tailFrame);
            distributeVideoView.setChargeInfo(this.iMf.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void cjd() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.iMf.getAdvertAppInfo();
        a aVar = new a(this.iMf);
        this.iLZ.setOnClickListener(aVar);
        View cC = this.iLY.cC("head");
        if (cC != null && (cC instanceof HeadImageView)) {
            this.iMa = (HeadImageView) cC;
            setHeadLongClick(advertAppInfo);
        }
        View cC2 = this.iLY.cC("download");
        if (cC2 != null && (cC2 instanceof ApkDownloadView)) {
            this.iMb = (ApkDownloadView) cC2;
            this.iMb.s(this.mContext.getUniqueId());
            this.iMb.setOnClickListener(aVar);
            j(advertAppInfo);
        }
        View cC3 = this.iLY.cC("closead");
        if (cC3 != null && (cC3 instanceof AdCloseView)) {
            this.iMc = (AdCloseView) cC3;
            k(advertAppInfo);
        }
        View cC4 = this.iLY.cC("viewbtn");
        if (cC4 != null && (cC4 instanceof JumpButton)) {
            this.iMd = (JumpButton) cC4;
            cjc();
        }
        View cC5 = this.iLY.cC("bottombar");
        if (cC5 != null && (cC5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) cC5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.iMe = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View cD = this.iLY.cD("video");
        if (cD != null && (distributeVideoView = (DistributeVideoView) cD.findViewById(R.id.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View cD = this.iLY.cD("video");
        if (cD == null || (distributeVideoView = (DistributeVideoView) cD.findViewById(R.id.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View cD = this.iLY.cD("video");
        if (cD != null && (distributeVideoView = (DistributeVideoView) cD.findViewById(R.id.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard iMl;

        public a(CriusAdCard criusAdCard) {
            this.iMl = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if (!j.jQ()) {
                CriusAdCardView.this.mContext.showToast(R.string.neterror);
            } else if (this.iMl != null) {
                AdvertAppInfo advertAppInfo = this.iMl.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.acM()) {
                    int f = b.f(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, f));
                    if ((6 == status || 7 == status) && j.kc() && !j.kd()) {
                        CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, f, true, "");
                        return;
                    }
                    if (!TextUtils.equals(advertAppInfo.page, "PB_BANNER") && view != CriusAdCardView.this.iMb) {
                        z = false;
                    }
                    CriusAdCardView.this.a(advertAppInfo, f, CriusAdCardView.this.iMb, z);
                    if (CriusAdCardView.this.hhI != null) {
                        CriusAdCardView.this.hhI.b(3, null);
                        return;
                    }
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.abH;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.bFu;
                }
                int a = s.a(CriusAdCardView.this.mContext, str, (CriusAdCardView.this.iMf == null || CriusAdCardView.this.iMf.getAdvertAppInfo() == null) ? null : CriusAdCardView.this.iMf.getAdvertAppInfo().bFs);
                if (CriusAdCardView.this.hhI != null) {
                    CriusAdCardView.this.hhI.b(a, null);
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
                        h.f(advertAppInfo);
                        apkDownloadView.q(c);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    h.aN(this.mContext.getPageActivity(), advertAppInfo.bFw);
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
        DownloadData downloadData = new DownloadData(advertAppInfo.bFw);
        downloadData.setUrl(advertAppInfo.bFv);
        downloadData.setName(advertAppInfo.bFt);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.f(advertAppInfo.bFs, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.jQ()) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.acM()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.mQ(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.iMb != null) {
                            CriusAdCardView.this.iMb.p(CriusAdCardView.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).agO();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.acL() != 0) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.c.a();
            }
            this.mPermissionJudgePolicy.ake();
            this.mPermissionJudgePolicy.e(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.ad(this.mContext.getPageActivity()) && this.hhJ != null) {
                this.hhJ.b(advertAppInfo, i);
                if (this.iMb != null) {
                    this.iMb.p(c(advertAppInfo, i));
                }
            }
        }
    }

    private void cje() {
        boolean z = true;
        if (this.gZU != null && this.iLY != null) {
            this.gZU.removeAllViews();
            com.baidu.c.a.d.a aVar = this.iLY;
            Activity pageActivity = this.mContext.getPageActivity();
            com.baidu.c.a.c.a aVar2 = this.criusData;
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                z = false;
            }
            this.iLZ = aVar.a(pageActivity, aVar2, z);
            this.gZU.addView(this.iLZ);
            am.k(this.iLZ, R.drawable.addresslist_item_bg);
            cjd();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void bLD() {
        if (this.iLY != null && ((TextView) this.iLY.cD("title")) != null) {
            this.criusData.d("title", TbConfig.getContentSize() / l.ai(this.mContext.getPageActivity()));
            cje();
        }
    }
}
