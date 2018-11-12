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
    private LinearLayout eZz;
    protected String gGG;
    private JumpButton gHA;
    private AdThreadCommentAndPraiseInfoLayout gHB;
    private CriusAdCard gHC;
    private boolean gHD;
    protected CustomMessageListener gHE;
    private com.baidu.c.a.d.a gHv;
    private ViewGroup gHw;
    private HeadImageView gHx;
    private ApkDownloadView gHy;
    private AdCloseView gHz;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gHD = true;
        this.gHE = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.gGG) && CriusAdCardView.this.gGG.equals(downloadData.getId()) && CriusAdCardView.this.gHy != null) {
                    CriusAdCardView.this.gHy.s(downloadData);
                }
            }
        };
        this.gHv = new com.baidu.c.a.d.a();
        this.gHv.a(new a.InterfaceC0070a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.c.a.d.a.InterfaceC0070a
            public void d(String str, Map<String, String> map) {
                String str2;
                String str3;
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (e == 1 || e == 2) {
                    if (CriusAdCardView.this.fgQ != null) {
                        CriusAdCardView.this.fgQ.b(e, null);
                    }
                } else if (CriusAdCardView.this.fgQ != null) {
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
                    CriusAdCardView.this.fgQ.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aWt() {
        this.eZz = new LinearLayout(this.mContext.getPageActivity());
        this.eZz.setOrientation(1);
        return this.eZz;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        al.i(this.gHw, e.f.addresslist_item_bg);
        this.gHv.j(this.mContext.getPageActivity(), i == 1);
        if (this.gHy != null) {
            this.gHy.onChangeSkinType(i);
        }
        if (this.gHz != null) {
            this.gHz.onChangeSkinType();
        }
        if (this.gHB != null) {
            this.gHB.onChangeSkinType();
        }
        al.i(this.gHA, e.f.btn_focus_border_bg);
        al.c(this.gHA, e.d.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.gHC = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            btb();
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.gHx != null) {
            this.gHx.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.Ft() || advertAppInfo == null) {
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
        if (advertAppInfo != null && advertAppInfo.wZ()) {
            this.gHE.setTag(this.mContext.getUniqueId());
            MessageManager.getInstance().registerListener(this.gHE);
            this.gGG = advertAppInfo.alU;
            DownloadData c = c(advertAppInfo, b.l(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gHy.setData(c);
            this.gHy.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.gHz != null && advertAppInfo != null && advertAppInfo.ama != null && advertAppInfo.ama.adCloseInfo != null && advertAppInfo.ama.adCloseInfo.support_close.intValue() > 0) {
            this.gHz.setPage(getBusinessType());
            this.gHz.setData(advertAppInfo);
            this.gHz.onChangeSkinType();
            l.b(this.mContext.getPageActivity(), this.gHz, 40, 40, 40, 120);
        }
    }

    private void bsZ() {
        if (this.gHA != null) {
            this.gHA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.c.a.c.a cX;
                    if (CriusAdCardView.this.criusData != null && (cX = CriusAdCardView.this.criusData.cX("viewbtn")) != null) {
                        if (!q.uW(cX.abe) && CriusAdCardView.this.fgQ != null) {
                            CriusAdCardView.this.fgQ.b(cX.abf, cX.abg, null);
                        }
                        if (TextUtils.isEmpty(cX.abh)) {
                            int e = s.e(CriusAdCardView.this.mContext, cX.abe);
                            if ((e == 1 || e == 2) && CriusAdCardView.this.fgQ != null) {
                                CriusAdCardView.this.fgQ.b(e, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.mContext.getPageActivity());
                        aVar.ej(cX.abh);
                        aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int e2 = s.e(CriusAdCardView.this.mContext, cX.abe);
                                if ((e2 == 1 || e2 == 2) && CriusAdCardView.this.fgQ != null) {
                                    CriusAdCardView.this.fgQ.b(e2, null);
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
                        aVar.b(CriusAdCardView.this.mContext).AB();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        final com.baidu.c.a.c.a cX;
        if (this.gHB != null && (cX = this.criusData.cX("bottombar")) != null) {
            a(this.gHC.getAdvertAppInfo(), cX);
            this.gHB.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.gHB.setBarNameClickEnabled(false);
            this.gHB.setReplyTimeVisible(false);
            if (cX.abi != Integer.MIN_VALUE) {
                this.gHB.setShareClickable(true);
                this.gHB.setShareContainerBgGray(false);
            } else {
                this.gHB.setShareClickable(false);
                this.gHB.setShareContainerBgGray(true);
            }
            this.gHB.getCommentContainer().setOnClickListener(aVar);
            this.gHB.setNeedAddReplyIcon(true);
            this.gHB.setCommentNumEnable(true);
            this.gHB.setCommentClickable(true);
            this.gHB.setReplayContainerBgGray(true);
            this.gHB.setOnClickListener(aVar);
            this.gHB.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
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
                    return CriusAdCardView.this.gHC.getAdvertAppInfo();
                }
            });
            if (cX.abk != Integer.MIN_VALUE) {
                this.gHB.setAgreeClickable(true);
                this.gHB.setPraiseContainerBgGray(false);
            } else {
                this.gHB.setAgreeClickable(false);
                this.gHB.setPraiseContainerBgGray(true);
            }
            this.gHB.onChangeSkinType();
        }
    }

    public void a(bb bbVar, com.baidu.c.a.c.a aVar) {
        if (bbVar != null && aVar != null) {
            if (this.gHD || (bbVar.zO() <= 0 && bbVar.zS() <= 0)) {
                if (this.gHD) {
                    this.gHD = false;
                }
                bbVar.cB(aVar.abj);
                bbVar.cJ(aVar.abk);
                bbVar.z(aVar.abi);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.gHC != null) {
            distributeVideoView.setPageContext(this.mContext);
            distributeVideoView.setVideoTailFrameData(this.gHC.tailFrame);
            distributeVideoView.setChargeInfo(this.gHC.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void bta() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.gHC.getAdvertAppInfo();
        a aVar = new a(this.gHC);
        this.gHw.setOnClickListener(aVar);
        View da = this.gHv.da("head");
        if (da != null && (da instanceof HeadImageView)) {
            this.gHx = (HeadImageView) da;
            setHeadLongClick(advertAppInfo);
        }
        View da2 = this.gHv.da(OpenAppAction.PARAMS_DOWNLOAD_KEY);
        if (da2 != null && (da2 instanceof ApkDownloadView)) {
            this.gHy = (ApkDownloadView) da2;
            this.gHy.p(this.mContext.getUniqueId());
            this.gHy.setOnClickListener(aVar);
            j(advertAppInfo);
        }
        View da3 = this.gHv.da("closead");
        if (da3 != null && (da3 instanceof AdCloseView)) {
            this.gHz = (AdCloseView) da3;
            k(advertAppInfo);
        }
        View da4 = this.gHv.da("viewbtn");
        if (da4 != null && (da4 instanceof JumpButton)) {
            this.gHA = (JumpButton) da4;
            bsZ();
        }
        View da5 = this.gHv.da("bottombar");
        if (da5 != null && (da5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) da5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.gHB = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View db = this.gHv.db("video");
        if (db != null && (distributeVideoView = (DistributeVideoView) db.findViewById(e.g.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View db = this.gHv.db("video");
        if (db == null || (distributeVideoView = (DistributeVideoView) db.findViewById(e.g.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View db = this.gHv.db("video");
        if (db != null && (distributeVideoView = (DistributeVideoView) db.findViewById(e.g.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard gHI;

        public a(CriusAdCard criusAdCard) {
            this.gHI = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kK()) {
                CriusAdCardView.this.mContext.showToast(e.j.neterror);
            } else if (this.gHI != null) {
                AdvertAppInfo advertAppInfo = this.gHI.getAdvertAppInfo();
                boolean z = view == CriusAdCardView.this.gHy;
                if (advertAppInfo != null && advertAppInfo.wZ()) {
                    int l = b.l(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, l));
                    if ((6 != status && 7 != status) || !j.kV() || j.kW()) {
                        CriusAdCardView.this.a(advertAppInfo, l, CriusAdCardView.this.gHy, z);
                        if (CriusAdCardView.this.fgQ != null) {
                            CriusAdCardView.this.fgQ.b(3, null);
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
                    str = advertAppInfo.alS;
                }
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (CriusAdCardView.this.fgQ != null) {
                    CriusAdCardView.this.fgQ.b(e, null);
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
                    g.aD(this.mContext.getPageActivity(), advertAppInfo.alU);
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
        DownloadData downloadData = new DownloadData(advertAppInfo.alU);
        downloadData.setUrl(advertAppInfo.alT);
        downloadData.setName(advertAppInfo.alQ);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.l(advertAppInfo.alP, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.kK()) {
                l.showToast(this.mContext.getPageActivity(), e.j.neterror);
            } else if (advertAppInfo.wZ()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(e.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.ej(str);
                aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.gHy != null) {
                            CriusAdCardView.this.gHy.p(CriusAdCardView.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).AB();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.wY() != 0) {
                l.showToast(this.mContext.getPageActivity(), e.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.Dp();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.A(this.mContext.getPageActivity()) && this.fgR != null) {
                this.fgR.b(advertAppInfo, i);
                if (this.gHy != null) {
                    this.gHy.p(c(advertAppInfo, i));
                }
            }
        }
    }

    private void btb() {
        if (this.eZz != null && this.gHv != null) {
            this.eZz.removeAllViews();
            this.gHw = this.gHv.a(this.mContext.getPageActivity(), this.criusData, TbadkCoreApplication.getInst().getSkinType() == 1);
            this.eZz.addView(this.gHw);
            al.i(this.gHw, e.f.addresslist_item_bg);
            bta();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aWB() {
        if (this.gHv != null && ((TextView) this.gHv.db("title")) != null) {
            this.criusData.d("title", TbConfig.getContentSize() / l.aR(this.mContext.getPageActivity()));
            btb();
        }
    }
}
