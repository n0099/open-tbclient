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
import com.baidu.searchbox.ng.ai.apps.scheme.actions.OpenAppAction;
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
    private com.baidu.c.a.c.a criusData;
    private LinearLayout fjh;
    protected String gQo;
    private com.baidu.c.a.d.a gRd;
    private ViewGroup gRe;
    private HeadImageView gRf;
    private ApkDownloadView gRg;
    private AdCloseView gRh;
    private JumpButton gRi;
    private AdThreadCommentAndPraiseInfoLayout gRj;
    private CriusAdCard gRk;
    private boolean gRl;
    protected CustomMessageListener gRm;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gRl = true;
        this.gRm = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.gQo) && CriusAdCardView.this.gQo.equals(downloadData.getId()) && CriusAdCardView.this.gRg != null) {
                    CriusAdCardView.this.gRg.s(downloadData);
                }
            }
        };
        this.gRd = new com.baidu.c.a.d.a();
        this.gRd.a(new a.InterfaceC0070a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.c.a.d.a.InterfaceC0070a
            public void d(String str, Map<String, String> map) {
                String str2;
                String str3;
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (e == 1 || e == 2) {
                    if (CriusAdCardView.this.fqA != null) {
                        CriusAdCardView.this.fqA.b(e, null);
                    }
                } else if (CriusAdCardView.this.fqA != null) {
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
                    CriusAdCardView.this.fqA.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aYY() {
        this.fjh = new LinearLayout(this.mContext.getPageActivity());
        this.fjh.setOrientation(1);
        return this.fjh;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        al.i(this.gRe, e.f.addresslist_item_bg);
        this.gRd.j(this.mContext.getPageActivity(), i == 1);
        if (this.gRg != null) {
            this.gRg.onChangeSkinType(i);
        }
        if (this.gRh != null) {
            this.gRh.onChangeSkinType();
        }
        if (this.gRj != null) {
            this.gRj.onChangeSkinType();
        }
        al.i(this.gRi, e.f.btn_focus_border_bg);
        al.c(this.gRi, e.d.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.gRk = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            bvF();
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.gRf != null) {
            this.gRf.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.Gy() || advertAppInfo == null) {
                        return false;
                    }
                    com.baidu.adp.lib.util.a.bg(advertAppInfo.adCollect());
                    ((Vibrator) CriusAdCardView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                    return true;
                }
            });
        }
    }

    private void j(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.yd()) {
            this.gRm.setTag(this.mContext.getUniqueId());
            MessageManager.getInstance().registerListener(this.gRm);
            this.gQo = advertAppInfo.apv;
            DownloadData c = c(advertAppInfo, b.l(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gRg.setData(c);
            this.gRg.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.gRh != null && advertAppInfo != null && advertAppInfo.apB != null && advertAppInfo.apB.adCloseInfo != null && advertAppInfo.apB.adCloseInfo.support_close.intValue() > 0) {
            this.gRh.setPage(getBusinessType());
            this.gRh.setData(advertAppInfo);
            this.gRh.onChangeSkinType();
            l.b(this.mContext.getPageActivity(), this.gRh, 40, 40, 40, 120);
        }
    }

    private void bvD() {
        if (this.gRi != null) {
            this.gRi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.c.a.c.a cX;
                    if (CriusAdCardView.this.criusData != null && (cX = CriusAdCardView.this.criusData.cX("viewbtn")) != null) {
                        if (!q.vA(cX.abe) && CriusAdCardView.this.fqA != null) {
                            CriusAdCardView.this.fqA.b(cX.abf, cX.abg, null);
                        }
                        if (TextUtils.isEmpty(cX.abh)) {
                            int e = s.e(CriusAdCardView.this.mContext, cX.abe);
                            if ((e == 1 || e == 2) && CriusAdCardView.this.fqA != null) {
                                CriusAdCardView.this.fqA.b(e, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.mContext.getPageActivity());
                        aVar.eB(cX.abh);
                        aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int e2 = s.e(CriusAdCardView.this.mContext, cX.abe);
                                if ((e2 == 1 || e2 == 2) && CriusAdCardView.this.fqA != null) {
                                    CriusAdCardView.this.fqA.b(e2, null);
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
                        aVar.b(CriusAdCardView.this.mContext).BF();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        final com.baidu.c.a.c.a cX;
        if (this.gRj != null && (cX = this.criusData.cX("bottombar")) != null) {
            a(this.gRk.getAdvertAppInfo(), cX);
            this.gRj.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.gRj.setBarNameClickEnabled(false);
            this.gRj.setReplyTimeVisible(false);
            if (cX.abi != Integer.MIN_VALUE) {
                this.gRj.setShareClickable(true);
                this.gRj.setShareContainerBgGray(false);
            } else {
                this.gRj.setShareClickable(false);
                this.gRj.setShareContainerBgGray(true);
            }
            this.gRj.getCommentContainer().setOnClickListener(aVar);
            this.gRj.setNeedAddReplyIcon(true);
            this.gRj.setCommentNumEnable(true);
            this.gRj.setCommentClickable(true);
            this.gRj.setReplayContainerBgGray(true);
            this.gRj.setOnClickListener(aVar);
            this.gRj.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // com.baidu.tieba.recapp.c.a
                public String getTitle() {
                    return cX.shareTitle;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getAbstract() {
                    return cX.shareContent;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getImageUrl() {
                    return cX.abl;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getShareLink() {
                    return cX.abm;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public AdvertAppInfo getThreadData() {
                    return CriusAdCardView.this.gRk.getAdvertAppInfo();
                }
            });
            if (cX.abk != Integer.MIN_VALUE) {
                this.gRj.setAgreeClickable(true);
                this.gRj.setPraiseContainerBgGray(false);
            } else {
                this.gRj.setAgreeClickable(false);
                this.gRj.setPraiseContainerBgGray(true);
            }
            this.gRj.onChangeSkinType();
        }
    }

    public void a(bb bbVar, com.baidu.c.a.c.a aVar) {
        if (bbVar != null && aVar != null) {
            if (this.gRl || (bbVar.AS() <= 0 && bbVar.AW() <= 0)) {
                if (this.gRl) {
                    this.gRl = false;
                }
                bbVar.cP(aVar.abj);
                bbVar.cX(aVar.abk);
                bbVar.E(aVar.abi);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.gRk != null) {
            distributeVideoView.setPageContext(this.mContext);
            distributeVideoView.setVideoTailFrameData(this.gRk.tailFrame);
            distributeVideoView.setChargeInfo(this.gRk.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void bvE() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.gRk.getAdvertAppInfo();
        a aVar = new a(this.gRk);
        this.gRe.setOnClickListener(aVar);
        View da = this.gRd.da("head");
        if (da != null && (da instanceof HeadImageView)) {
            this.gRf = (HeadImageView) da;
            setHeadLongClick(advertAppInfo);
        }
        View da2 = this.gRd.da(OpenAppAction.PARAMS_DOWNLOAD_KEY);
        if (da2 != null && (da2 instanceof ApkDownloadView)) {
            this.gRg = (ApkDownloadView) da2;
            this.gRg.p(this.mContext.getUniqueId());
            this.gRg.setOnClickListener(aVar);
            j(advertAppInfo);
        }
        View da3 = this.gRd.da("closead");
        if (da3 != null && (da3 instanceof AdCloseView)) {
            this.gRh = (AdCloseView) da3;
            k(advertAppInfo);
        }
        View da4 = this.gRd.da("viewbtn");
        if (da4 != null && (da4 instanceof JumpButton)) {
            this.gRi = (JumpButton) da4;
            bvD();
        }
        View da5 = this.gRd.da("bottombar");
        if (da5 != null && (da5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) da5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.gRj = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View db = this.gRd.db("video");
        if (db != null && (distributeVideoView = (DistributeVideoView) db.findViewById(e.g.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View db = this.gRd.db("video");
        if (db == null || (distributeVideoView = (DistributeVideoView) db.findViewById(e.g.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View db = this.gRd.db("video");
        if (db != null && (distributeVideoView = (DistributeVideoView) db.findViewById(e.g.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard gRq;

        public a(CriusAdCard criusAdCard) {
            this.gRq = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kK()) {
                CriusAdCardView.this.mContext.showToast(e.j.neterror);
            } else if (this.gRq != null) {
                AdvertAppInfo advertAppInfo = this.gRq.getAdvertAppInfo();
                boolean z = view == CriusAdCardView.this.gRg;
                if (advertAppInfo != null && advertAppInfo.yd()) {
                    int l = b.l(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, l));
                    if ((6 != status && 7 != status) || !j.kV() || j.kW()) {
                        CriusAdCardView.this.a(advertAppInfo, l, CriusAdCardView.this.gRg, z);
                        if (CriusAdCardView.this.fqA != null) {
                            CriusAdCardView.this.fqA.b(3, null);
                            return;
                        }
                        return;
                    }
                    CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, l, true, "");
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.abe;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.apt;
                }
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (CriusAdCardView.this.fqA != null) {
                    CriusAdCardView.this.fqA.b(e, null);
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
                    g.aG(this.mContext.getPageActivity(), advertAppInfo.apv);
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
        DownloadData downloadData = new DownloadData(advertAppInfo.apv);
        downloadData.setUrl(advertAppInfo.apu);
        downloadData.setName(advertAppInfo.apr);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.l(advertAppInfo.apq, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.kK()) {
                l.showToast(this.mContext.getPageActivity(), e.j.neterror);
            } else if (advertAppInfo.yd()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(e.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.eB(str);
                aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.gRg != null) {
                            CriusAdCardView.this.gRg.p(CriusAdCardView.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).BF();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.yc() != 0) {
                l.showToast(this.mContext.getPageActivity(), e.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.Et();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.A(this.mContext.getPageActivity()) && this.fqB != null) {
                this.fqB.b(advertAppInfo, i);
                if (this.gRg != null) {
                    this.gRg.p(c(advertAppInfo, i));
                }
            }
        }
    }

    private void bvF() {
        if (this.fjh != null && this.gRd != null) {
            this.fjh.removeAllViews();
            this.gRe = this.gRd.a(this.mContext.getPageActivity(), this.criusData, TbadkCoreApplication.getInst().getSkinType() == 1);
            this.fjh.addView(this.gRe);
            al.i(this.gRe, e.f.addresslist_item_bg);
            bvE();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aZg() {
        if (this.gRd != null && ((TextView) this.gRd.db("title")) != null) {
            this.criusData.d("title", TbConfig.getContentSize() / l.aR(this.mContext.getPageActivity()));
            bvF();
        }
    }
}
