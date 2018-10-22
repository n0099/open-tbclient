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
    private LinearLayout eYh;
    private com.baidu.c.a.d.a gFU;
    private ViewGroup gFV;
    private HeadImageView gFW;
    private ApkDownloadView gFX;
    private AdCloseView gFY;
    private JumpButton gFZ;
    protected String gFf;
    private AdThreadCommentAndPraiseInfoLayout gGa;
    private CriusAdCard gGb;
    private boolean gGc;
    protected CustomMessageListener gGd;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gGc = true;
        this.gGd = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.gFf) && CriusAdCardView.this.gFf.equals(downloadData.getId()) && CriusAdCardView.this.gFX != null) {
                    CriusAdCardView.this.gFX.s(downloadData);
                }
            }
        };
        this.gFU = new com.baidu.c.a.d.a();
        this.gFU.a(new a.InterfaceC0070a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.c.a.d.a.InterfaceC0070a
            public void d(String str, Map<String, String> map) {
                String str2;
                String str3;
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (e == 1 || e == 2) {
                    if (CriusAdCardView.this.ffx != null) {
                        CriusAdCardView.this.ffx.b(e, null);
                    }
                } else if (CriusAdCardView.this.ffx != null) {
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
                    CriusAdCardView.this.ffx.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aWW() {
        this.eYh = new LinearLayout(this.mContext.getPageActivity());
        this.eYh.setOrientation(1);
        return this.eYh;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        al.i(this.gFV, e.f.addresslist_item_bg);
        this.gFU.j(this.mContext.getPageActivity(), i == 1);
        if (this.gFX != null) {
            this.gFX.onChangeSkinType(i);
        }
        if (this.gFY != null) {
            this.gFY.onChangeSkinType();
        }
        if (this.gGa != null) {
            this.gGa.onChangeSkinType();
        }
        al.i(this.gFZ, e.f.btn_focus_border_bg);
        al.c(this.gFZ, e.d.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.gGb = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            btF();
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.gFW != null) {
            this.gFW.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
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
            this.gGd.setTag(this.mContext.getUniqueId());
            MessageManager.getInstance().registerListener(this.gGd);
            this.gFf = advertAppInfo.alg;
            DownloadData c = c(advertAppInfo, b.l(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gFX.setData(c);
            this.gFX.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.gFY != null && advertAppInfo != null && advertAppInfo.aln != null && advertAppInfo.aln.adCloseInfo != null && advertAppInfo.aln.adCloseInfo.support_close.intValue() > 0) {
            this.gFY.setPage(getBusinessType());
            this.gFY.setData(advertAppInfo);
            this.gFY.onChangeSkinType();
            l.a(this.mContext.getPageActivity(), this.gFY, 40, 40, 40, 120);
        }
    }

    private void btD() {
        if (this.gFZ != null) {
            this.gFZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.c.a.c.a cZ;
                    if (CriusAdCardView.this.criusData != null && (cZ = CriusAdCardView.this.criusData.cZ("viewbtn")) != null) {
                        if (!q.uR(cZ.abg) && CriusAdCardView.this.ffx != null) {
                            CriusAdCardView.this.ffx.b(cZ.abh, cZ.abi, null);
                        }
                        if (TextUtils.isEmpty(cZ.abj)) {
                            int e = s.e(CriusAdCardView.this.mContext, cZ.abg);
                            if ((e == 1 || e == 2) && CriusAdCardView.this.ffx != null) {
                                CriusAdCardView.this.ffx.b(e, null);
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
                                if ((e2 == 1 || e2 == 2) && CriusAdCardView.this.ffx != null) {
                                    CriusAdCardView.this.ffx.b(e2, null);
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
        if (this.gGa != null && (cZ = this.criusData.cZ("bottombar")) != null) {
            a(this.gGb.getAdvertAppInfo(), cZ);
            this.gGa.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.gGa.setBarNameClickEnabled(false);
            this.gGa.setReplyTimeVisible(false);
            if (cZ.abk != Integer.MIN_VALUE) {
                this.gGa.setShareClickable(true);
                this.gGa.setShareContainerBgGray(false);
            } else {
                this.gGa.setShareClickable(false);
                this.gGa.setShareContainerBgGray(true);
            }
            this.gGa.getCommentContainer().setOnClickListener(aVar);
            this.gGa.setNeedAddReplyIcon(true);
            this.gGa.setCommentNumEnable(true);
            this.gGa.setCommentClickable(true);
            this.gGa.setReplayContainerBgGray(true);
            this.gGa.setOnClickListener(aVar);
            this.gGa.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
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
                    return CriusAdCardView.this.gGb.getAdvertAppInfo();
                }
            });
            if (cZ.abm != Integer.MIN_VALUE) {
                this.gGa.setAgreeClickable(true);
                this.gGa.setPraiseContainerBgGray(false);
            } else {
                this.gGa.setAgreeClickable(false);
                this.gGa.setPraiseContainerBgGray(true);
            }
            this.gGa.onChangeSkinType();
        }
    }

    public void a(bb bbVar, com.baidu.c.a.c.a aVar) {
        if (bbVar != null && aVar != null) {
            if (this.gGc || (bbVar.zH() <= 0 && bbVar.zL() <= 0)) {
                if (this.gGc) {
                    this.gGc = false;
                }
                bbVar.cn(aVar.abl);
                bbVar.cv(aVar.abm);
                bbVar.x(aVar.abk);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.gGb != null) {
            distributeVideoView.setPageContext(this.mContext);
            distributeVideoView.setVideoTailFrameData(this.gGb.tailFrame);
            distributeVideoView.setChargeInfo(this.gGb.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void btE() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.gGb.getAdvertAppInfo();
        a aVar = new a(this.gGb);
        this.gFV.setOnClickListener(aVar);
        View dc = this.gFU.dc("head");
        if (dc != null && (dc instanceof HeadImageView)) {
            this.gFW = (HeadImageView) dc;
            setHeadLongClick(advertAppInfo);
        }
        View dc2 = this.gFU.dc(OpenAppAction.PARAMS_DOWNLOAD_KEY);
        if (dc2 != null && (dc2 instanceof ApkDownloadView)) {
            this.gFX = (ApkDownloadView) dc2;
            this.gFX.p(this.mContext.getUniqueId());
            this.gFX.setOnClickListener(aVar);
            j(advertAppInfo);
        }
        View dc3 = this.gFU.dc("closead");
        if (dc3 != null && (dc3 instanceof AdCloseView)) {
            this.gFY = (AdCloseView) dc3;
            k(advertAppInfo);
        }
        View dc4 = this.gFU.dc("viewbtn");
        if (dc4 != null && (dc4 instanceof JumpButton)) {
            this.gFZ = (JumpButton) dc4;
            btD();
        }
        View dc5 = this.gFU.dc("bottombar");
        if (dc5 != null && (dc5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) dc5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.gGa = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View dd = this.gFU.dd("video");
        if (dd != null && (distributeVideoView = (DistributeVideoView) dd.findViewById(e.g.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View dd = this.gFU.dd("video");
        if (dd == null || (distributeVideoView = (DistributeVideoView) dd.findViewById(e.g.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View dd = this.gFU.dd("video");
        if (dd != null && (distributeVideoView = (DistributeVideoView) dd.findViewById(e.g.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard gGh;

        public a(CriusAdCard criusAdCard) {
            this.gGh = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                CriusAdCardView.this.mContext.showToast(e.j.neterror);
            } else if (this.gGh != null) {
                AdvertAppInfo advertAppInfo = this.gGh.getAdvertAppInfo();
                boolean z = view == CriusAdCardView.this.gFX;
                if (advertAppInfo != null && advertAppInfo.wR()) {
                    int l = b.l(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, l));
                    if ((6 != status && 7 != status) || !j.kX() || j.kY()) {
                        CriusAdCardView.this.a(advertAppInfo, l, CriusAdCardView.this.gFX, z);
                        if (CriusAdCardView.this.ffx != null) {
                            CriusAdCardView.this.ffx.b(3, null);
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
                if (CriusAdCardView.this.ffx != null) {
                    CriusAdCardView.this.ffx.b(e, null);
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
                        if (CriusAdCardView.this.gFX != null) {
                            CriusAdCardView.this.gFX.p(CriusAdCardView.this.c(advertAppInfo, i));
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
            if (!this.mPermissionJudgePolicy.z(this.mContext.getPageActivity()) && this.ffy != null) {
                this.ffy.b(advertAppInfo, i);
                if (this.gFX != null) {
                    this.gFX.p(c(advertAppInfo, i));
                }
            }
        }
    }

    private void btF() {
        if (this.eYh != null && this.gFU != null) {
            this.eYh.removeAllViews();
            this.gFV = this.gFU.a(this.mContext.getPageActivity(), this.criusData, TbadkCoreApplication.getInst().getSkinType() == 1);
            this.eYh.addView(this.gFV);
            al.i(this.gFV, e.f.addresslist_item_bg);
            btE();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aXe() {
        if (this.gFU != null && ((TextView) this.gFU.dd("title")) != null) {
            this.criusData.d("title", TbConfig.getContentSize() / l.aR(this.mContext.getPageActivity()));
            btF();
        }
    }
}
