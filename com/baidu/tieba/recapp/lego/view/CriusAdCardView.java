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
    private LinearLayout eYg;
    private com.baidu.c.a.d.a gFT;
    private ViewGroup gFU;
    private HeadImageView gFV;
    private ApkDownloadView gFW;
    private AdCloseView gFX;
    private JumpButton gFY;
    private AdThreadCommentAndPraiseInfoLayout gFZ;
    protected String gFe;
    private CriusAdCard gGa;
    private boolean gGb;
    protected CustomMessageListener gGc;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gGb = true;
        this.gGc = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.gFe) && CriusAdCardView.this.gFe.equals(downloadData.getId()) && CriusAdCardView.this.gFW != null) {
                    CriusAdCardView.this.gFW.s(downloadData);
                }
            }
        };
        this.gFT = new com.baidu.c.a.d.a();
        this.gFT.a(new a.InterfaceC0070a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.c.a.d.a.InterfaceC0070a
            public void d(String str, Map<String, String> map) {
                String str2;
                String str3;
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (e == 1 || e == 2) {
                    if (CriusAdCardView.this.ffw != null) {
                        CriusAdCardView.this.ffw.b(e, null);
                    }
                } else if (CriusAdCardView.this.ffw != null) {
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
                    CriusAdCardView.this.ffw.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aWW() {
        this.eYg = new LinearLayout(this.mContext.getPageActivity());
        this.eYg.setOrientation(1);
        return this.eYg;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        al.i(this.gFU, e.f.addresslist_item_bg);
        this.gFT.j(this.mContext.getPageActivity(), i == 1);
        if (this.gFW != null) {
            this.gFW.onChangeSkinType(i);
        }
        if (this.gFX != null) {
            this.gFX.onChangeSkinType();
        }
        if (this.gFZ != null) {
            this.gFZ.onChangeSkinType();
        }
        al.i(this.gFY, e.f.btn_focus_border_bg);
        al.c(this.gFY, e.d.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.gGa = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            btF();
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.gFV != null) {
            this.gFV.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.Fi() || advertAppInfo == null) {
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
        if (advertAppInfo != null && advertAppInfo.wR()) {
            this.gGc.setTag(this.mContext.getUniqueId());
            MessageManager.getInstance().registerListener(this.gGc);
            this.gFe = advertAppInfo.alg;
            DownloadData c = c(advertAppInfo, b.l(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gFW.setData(c);
            this.gFW.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.gFX != null && advertAppInfo != null && advertAppInfo.aln != null && advertAppInfo.aln.adCloseInfo != null && advertAppInfo.aln.adCloseInfo.support_close.intValue() > 0) {
            this.gFX.setPage(getBusinessType());
            this.gFX.setData(advertAppInfo);
            this.gFX.onChangeSkinType();
            l.a(this.mContext.getPageActivity(), this.gFX, 40, 40, 40, 120);
        }
    }

    private void btD() {
        if (this.gFY != null) {
            this.gFY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.c.a.c.a cZ;
                    if (CriusAdCardView.this.criusData != null && (cZ = CriusAdCardView.this.criusData.cZ("viewbtn")) != null) {
                        if (!q.uR(cZ.abg) && CriusAdCardView.this.ffw != null) {
                            CriusAdCardView.this.ffw.b(cZ.abh, cZ.abi, null);
                        }
                        if (TextUtils.isEmpty(cZ.abj)) {
                            int e = s.e(CriusAdCardView.this.mContext, cZ.abg);
                            if ((e == 1 || e == 2) && CriusAdCardView.this.ffw != null) {
                                CriusAdCardView.this.ffw.b(e, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.mContext.getPageActivity());
                        aVar.ej(cZ.abj);
                        aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int e2 = s.e(CriusAdCardView.this.mContext, cZ.abg);
                                if ((e2 == 1 || e2 == 2) && CriusAdCardView.this.ffw != null) {
                                    CriusAdCardView.this.ffw.b(e2, null);
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
                        aVar.b(CriusAdCardView.this.mContext).Au();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        final com.baidu.c.a.c.a cZ;
        if (this.gFZ != null && (cZ = this.criusData.cZ("bottombar")) != null) {
            a(this.gGa.getAdvertAppInfo(), cZ);
            this.gFZ.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.gFZ.setBarNameClickEnabled(false);
            this.gFZ.setReplyTimeVisible(false);
            if (cZ.abk != Integer.MIN_VALUE) {
                this.gFZ.setShareClickable(true);
                this.gFZ.setShareContainerBgGray(false);
            } else {
                this.gFZ.setShareClickable(false);
                this.gFZ.setShareContainerBgGray(true);
            }
            this.gFZ.getCommentContainer().setOnClickListener(aVar);
            this.gFZ.setNeedAddReplyIcon(true);
            this.gFZ.setCommentNumEnable(true);
            this.gFZ.setCommentClickable(true);
            this.gFZ.setReplayContainerBgGray(true);
            this.gFZ.setOnClickListener(aVar);
            this.gFZ.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // com.baidu.tieba.recapp.c.a
                public String getTitle() {
                    return cZ.shareTitle;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getAbstract() {
                    return cZ.shareContent;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getImageUrl() {
                    return cZ.abn;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getShareLink() {
                    return cZ.abo;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public AdvertAppInfo getThreadData() {
                    return CriusAdCardView.this.gGa.getAdvertAppInfo();
                }
            });
            if (cZ.abm != Integer.MIN_VALUE) {
                this.gFZ.setAgreeClickable(true);
                this.gFZ.setPraiseContainerBgGray(false);
            } else {
                this.gFZ.setAgreeClickable(false);
                this.gFZ.setPraiseContainerBgGray(true);
            }
            this.gFZ.onChangeSkinType();
        }
    }

    public void a(bb bbVar, com.baidu.c.a.c.a aVar) {
        if (bbVar != null && aVar != null) {
            if (this.gGb || (bbVar.zH() <= 0 && bbVar.zL() <= 0)) {
                if (this.gGb) {
                    this.gGb = false;
                }
                bbVar.cn(aVar.abl);
                bbVar.cv(aVar.abm);
                bbVar.x(aVar.abk);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.gGa != null) {
            distributeVideoView.setPageContext(this.mContext);
            distributeVideoView.setVideoTailFrameData(this.gGa.tailFrame);
            distributeVideoView.setChargeInfo(this.gGa.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void btE() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.gGa.getAdvertAppInfo();
        a aVar = new a(this.gGa);
        this.gFU.setOnClickListener(aVar);
        View dc = this.gFT.dc("head");
        if (dc != null && (dc instanceof HeadImageView)) {
            this.gFV = (HeadImageView) dc;
            setHeadLongClick(advertAppInfo);
        }
        View dc2 = this.gFT.dc(OpenAppAction.PARAMS_DOWNLOAD_KEY);
        if (dc2 != null && (dc2 instanceof ApkDownloadView)) {
            this.gFW = (ApkDownloadView) dc2;
            this.gFW.p(this.mContext.getUniqueId());
            this.gFW.setOnClickListener(aVar);
            j(advertAppInfo);
        }
        View dc3 = this.gFT.dc("closead");
        if (dc3 != null && (dc3 instanceof AdCloseView)) {
            this.gFX = (AdCloseView) dc3;
            k(advertAppInfo);
        }
        View dc4 = this.gFT.dc("viewbtn");
        if (dc4 != null && (dc4 instanceof JumpButton)) {
            this.gFY = (JumpButton) dc4;
            btD();
        }
        View dc5 = this.gFT.dc("bottombar");
        if (dc5 != null && (dc5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) dc5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.gFZ = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View dd = this.gFT.dd("video");
        if (dd != null && (distributeVideoView = (DistributeVideoView) dd.findViewById(e.g.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View dd = this.gFT.dd("video");
        if (dd == null || (distributeVideoView = (DistributeVideoView) dd.findViewById(e.g.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View dd = this.gFT.dd("video");
        if (dd != null && (distributeVideoView = (DistributeVideoView) dd.findViewById(e.g.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard gGg;

        public a(CriusAdCard criusAdCard) {
            this.gGg = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                CriusAdCardView.this.mContext.showToast(e.j.neterror);
            } else if (this.gGg != null) {
                AdvertAppInfo advertAppInfo = this.gGg.getAdvertAppInfo();
                boolean z = view == CriusAdCardView.this.gFW;
                if (advertAppInfo != null && advertAppInfo.wR()) {
                    int l = b.l(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, l));
                    if ((6 != status && 7 != status) || !j.kX() || j.kY()) {
                        CriusAdCardView.this.a(advertAppInfo, l, CriusAdCardView.this.gFW, z);
                        if (CriusAdCardView.this.ffw != null) {
                            CriusAdCardView.this.ffw.b(3, null);
                            return;
                        }
                        return;
                    }
                    CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, l, true, "");
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.abg;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.ale;
                }
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (CriusAdCardView.this.ffw != null) {
                    CriusAdCardView.this.ffw.b(e, null);
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
                    g.aF(this.mContext.getPageActivity(), advertAppInfo.alg);
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
        DownloadData downloadData = new DownloadData(advertAppInfo.alg);
        downloadData.setUrl(advertAppInfo.alf);
        downloadData.setName(advertAppInfo.alc);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.l(advertAppInfo.alb, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.kM()) {
                l.showToast(this.mContext.getPageActivity(), e.j.neterror);
            } else if (advertAppInfo.wR()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(e.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.ej(str);
                aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.gFW != null) {
                            CriusAdCardView.this.gFW.p(CriusAdCardView.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).Au();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.wQ() != 0) {
                l.showToast(this.mContext.getPageActivity(), e.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.Di();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.z(this.mContext.getPageActivity()) && this.ffx != null) {
                this.ffx.b(advertAppInfo, i);
                if (this.gFW != null) {
                    this.gFW.p(c(advertAppInfo, i));
                }
            }
        }
    }

    private void btF() {
        if (this.eYg != null && this.gFT != null) {
            this.eYg.removeAllViews();
            this.gFU = this.gFT.a(this.mContext.getPageActivity(), this.criusData, TbadkCoreApplication.getInst().getSkinType() == 1);
            this.eYg.addView(this.gFU);
            al.i(this.gFU, e.f.addresslist_item_bg);
            btE();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aXe() {
        if (this.gFT != null && ((TextView) this.gFT.dd("title")) != null) {
            this.criusData.d("title", TbConfig.getContentSize() / l.aR(this.mContext.getPageActivity()));
            btF();
        }
    }
}
