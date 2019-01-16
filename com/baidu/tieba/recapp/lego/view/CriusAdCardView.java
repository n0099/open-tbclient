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
    private LinearLayout fjW;
    protected String gRr;
    private com.baidu.c.a.d.a gSg;
    private ViewGroup gSh;
    private HeadImageView gSi;
    private ApkDownloadView gSj;
    private AdCloseView gSk;
    private JumpButton gSl;
    private AdThreadCommentAndPraiseInfoLayout gSm;
    private CriusAdCard gSn;
    private boolean gSo;
    protected CustomMessageListener gSp;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public CriusAdCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gSo = true;
        this.gSp = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(CriusAdCardView.this.gRr) && CriusAdCardView.this.gRr.equals(downloadData.getId()) && CriusAdCardView.this.gSj != null) {
                    CriusAdCardView.this.gSj.s(downloadData);
                }
            }
        };
        this.gSg = new com.baidu.c.a.d.a();
        this.gSg.a(new a.InterfaceC0070a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.1
            @Override // com.baidu.c.a.d.a.InterfaceC0070a
            public void d(String str, Map<String, String> map) {
                String str2;
                String str3;
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (e == 1 || e == 2) {
                    if (CriusAdCardView.this.frv != null) {
                        CriusAdCardView.this.frv.b(e, null);
                    }
                } else if (CriusAdCardView.this.frv != null) {
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
                    CriusAdCardView.this.frv.b(str2, str3, null);
                }
            }
        });
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aZy() {
        this.fjW = new LinearLayout(this.mContext.getPageActivity());
        this.fjW.setOrientation(1);
        return this.fjW;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(CriusAdCard criusAdCard, int i) {
        al.i(this.gSh, e.f.addresslist_item_bg);
        this.gSg.j(this.mContext.getPageActivity(), i == 1);
        if (this.gSj != null) {
            this.gSj.onChangeSkinType(i);
        }
        if (this.gSk != null) {
            this.gSk.onChangeSkinType();
        }
        if (this.gSm != null) {
            this.gSm.onChangeSkinType();
        }
        al.i(this.gSl, e.f.btn_focus_border_bg);
        al.c(this.gSl, e.d.btn_forum_focus_color, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(CriusAdCard criusAdCard) {
        this.gSn = criusAdCard;
        this.criusData = criusAdCard.getCriusData();
        if (this.criusData != null) {
            bwo();
        }
    }

    private void setHeadLongClick(final AdvertAppInfo advertAppInfo) {
        if (this.gSi != null) {
            this.gSi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                    if (adAdSense == null || !adAdSense.GL() || advertAppInfo == null) {
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
        if (advertAppInfo != null && advertAppInfo.yq()) {
            this.gSp.setTag(this.mContext.getUniqueId());
            MessageManager.getInstance().registerListener(this.gSp);
            this.gRr = advertAppInfo.apX;
            DownloadData c = c(advertAppInfo, b.l(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            this.gSj.setData(c);
            this.gSj.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (this.gSk != null && advertAppInfo != null && advertAppInfo.aqd != null && advertAppInfo.aqd.adCloseInfo != null && advertAppInfo.aqd.adCloseInfo.support_close.intValue() > 0) {
            this.gSk.setPage(getBusinessType());
            this.gSk.setData(advertAppInfo);
            this.gSk.onChangeSkinType();
            l.b(this.mContext.getPageActivity(), this.gSk, 40, 40, 40, 120);
        }
    }

    private void bwm() {
        if (this.gSl != null) {
            this.gSl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final com.baidu.c.a.c.a cY;
                    if (CriusAdCardView.this.criusData != null && (cY = CriusAdCardView.this.criusData.cY("viewbtn")) != null) {
                        if (!q.vQ(cY.abn) && CriusAdCardView.this.frv != null) {
                            CriusAdCardView.this.frv.b(cY.abo, cY.abp, null);
                        }
                        if (TextUtils.isEmpty(cY.abq)) {
                            int e = s.e(CriusAdCardView.this.mContext, cY.abn);
                            if ((e == 1 || e == 2) && CriusAdCardView.this.frv != null) {
                                CriusAdCardView.this.frv.b(e, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(CriusAdCardView.this.mContext.getPageActivity());
                        aVar.eK(cY.abq);
                        aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int e2 = s.e(CriusAdCardView.this.mContext, cY.abn);
                                if ((e2 == 1 || e2 == 2) && CriusAdCardView.this.frv != null) {
                                    CriusAdCardView.this.frv.b(e2, null);
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
                        aVar.b(CriusAdCardView.this.mContext).BS();
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        final com.baidu.c.a.c.a cY;
        if (this.gSm != null && (cY = this.criusData.cY("bottombar")) != null) {
            a(this.gSn.getAdvertAppInfo(), cY);
            this.gSm.setType(TbadkCoreApplication.getInst().getCardShowType());
            this.gSm.setBarNameClickEnabled(false);
            this.gSm.setReplyTimeVisible(false);
            if (cY.abr != Integer.MIN_VALUE) {
                this.gSm.setShareClickable(true);
                this.gSm.setShareContainerBgGray(false);
            } else {
                this.gSm.setShareClickable(false);
                this.gSm.setShareContainerBgGray(true);
            }
            this.gSm.getCommentContainer().setOnClickListener(aVar);
            this.gSm.setNeedAddReplyIcon(true);
            this.gSm.setCommentNumEnable(true);
            this.gSm.setCommentClickable(true);
            this.gSm.setReplayContainerBgGray(true);
            this.gSm.setOnClickListener(aVar);
            this.gSm.setShareData(new com.baidu.tieba.recapp.c.a() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.4
                @Override // com.baidu.tieba.recapp.c.a
                public String getTitle() {
                    return cY.shareTitle;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getAbstract() {
                    return cY.shareContent;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getImageUrl() {
                    return cY.abv;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public String getShareLink() {
                    return cY.abw;
                }

                @Override // com.baidu.tieba.recapp.c.a
                public AdvertAppInfo getThreadData() {
                    return CriusAdCardView.this.gSn.getAdvertAppInfo();
                }
            });
            if (cY.abu != Integer.MIN_VALUE) {
                this.gSm.setAgreeClickable(true);
                this.gSm.setPraiseContainerBgGray(false);
            } else {
                this.gSm.setAgreeClickable(false);
                this.gSm.setPraiseContainerBgGray(true);
            }
            this.gSm.onChangeSkinType();
        }
    }

    public void a(bb bbVar, com.baidu.c.a.c.a aVar) {
        if (bbVar != null && aVar != null) {
            if (this.gSo || (bbVar.Bf() <= 0 && bbVar.Bj() <= 0)) {
                if (this.gSo) {
                    this.gSo = false;
                }
                bbVar.cP(aVar.abt);
                bbVar.cX(aVar.abu);
                bbVar.E(aVar.abr);
            }
        }
    }

    private void a(DistributeVideoView distributeVideoView, AdvertAppInfo advertAppInfo) {
        if (distributeVideoView != null && advertAppInfo != null && this.gSn != null) {
            distributeVideoView.setPageContext(this.mContext);
            distributeVideoView.setVideoTailFrameData(this.gSn.tailFrame);
            distributeVideoView.setChargeInfo(this.gSn.chargeInfo);
            distributeVideoView.updateTailFrameView(advertAppInfo);
            if (advertAppInfo != null && advertAppInfo.advertAppContext != null) {
                distributeVideoView.setStatisticInfo(advertAppInfo, advertAppInfo.advertAppContext.pn, advertAppInfo.advertAppContext.page);
            }
        }
    }

    private void bwn() {
        DistributeVideoView distributeVideoView;
        AdvertAppInfo advertAppInfo = this.gSn.getAdvertAppInfo();
        a aVar = new a(this.gSn);
        this.gSh.setOnClickListener(aVar);
        View db = this.gSg.db("head");
        if (db != null && (db instanceof HeadImageView)) {
            this.gSi = (HeadImageView) db;
            setHeadLongClick(advertAppInfo);
        }
        View db2 = this.gSg.db(OpenAppAction.PARAMS_DOWNLOAD_KEY);
        if (db2 != null && (db2 instanceof ApkDownloadView)) {
            this.gSj = (ApkDownloadView) db2;
            this.gSj.p(this.mContext.getUniqueId());
            this.gSj.setOnClickListener(aVar);
            j(advertAppInfo);
        }
        View db3 = this.gSg.db("closead");
        if (db3 != null && (db3 instanceof AdCloseView)) {
            this.gSk = (AdCloseView) db3;
            k(advertAppInfo);
        }
        View db4 = this.gSg.db("viewbtn");
        if (db4 != null && (db4 instanceof JumpButton)) {
            this.gSl = (JumpButton) db4;
            bwm();
        }
        View db5 = this.gSg.db("bottombar");
        if (db5 != null && (db5 instanceof LinearLayout)) {
            View childAt = ((LinearLayout) db5).getChildAt(0);
            if (childAt instanceof AdThreadCommentAndPraiseInfoLayout) {
                this.gSm = (AdThreadCommentAndPraiseInfoLayout) childAt;
                a(aVar);
            }
        }
        View dc = this.gSg.dc("video");
        if (dc != null && (distributeVideoView = (DistributeVideoView) dc.findViewById(e.g.advert_video)) != null) {
            a(distributeVideoView, advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public i getVideoOrVrView() {
        DistributeVideoView distributeVideoView;
        View dc = this.gSg.dc("video");
        if (dc == null || (distributeVideoView = (DistributeVideoView) dc.findViewById(e.g.advert_video)) == null) {
            return null;
        }
        return distributeVideoView;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        DistributeVideoView distributeVideoView;
        super.setDownloadAppCallback(cVar);
        View dc = this.gSg.dc("video");
        if (dc != null && (distributeVideoView = (DistributeVideoView) dc.findViewById(e.g.advert_video)) != null) {
            distributeVideoView.setDownloadCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private CriusAdCard gSt;

        public a(CriusAdCard criusAdCard) {
            this.gSt = criusAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kK()) {
                CriusAdCardView.this.mContext.showToast(e.j.neterror);
            } else if (this.gSt != null) {
                AdvertAppInfo advertAppInfo = this.gSt.getAdvertAppInfo();
                boolean z = view == CriusAdCardView.this.gSj;
                if (advertAppInfo != null && advertAppInfo.yq()) {
                    int l = b.l(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(CriusAdCardView.this.c(advertAppInfo, l));
                    if ((6 != status && 7 != status) || !j.kV() || j.kW()) {
                        CriusAdCardView.this.a(advertAppInfo, l, CriusAdCardView.this.gSj, z);
                        if (CriusAdCardView.this.frv != null) {
                            CriusAdCardView.this.frv.b(3, null);
                            return;
                        }
                        return;
                    }
                    CriusAdCardView.this.showDownloadAppDialog(advertAppInfo, l, true, "");
                    return;
                }
                String str = "";
                if (CriusAdCardView.this.criusData != null) {
                    str = CriusAdCardView.this.criusData.abn;
                }
                if (com.baidu.adp.lib.util.k.isEmpty(str) && advertAppInfo != null) {
                    str = advertAppInfo.apV;
                }
                int e = s.e(CriusAdCardView.this.mContext, str);
                if (CriusAdCardView.this.frv != null) {
                    CriusAdCardView.this.frv.b(e, null);
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
                    g.aE(this.mContext.getPageActivity(), advertAppInfo.apX);
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
        DownloadData downloadData = new DownloadData(advertAppInfo.apX);
        downloadData.setUrl(advertAppInfo.apW);
        downloadData.setName(advertAppInfo.apT);
        downloadData.setPosition(i);
        downloadData.setNotifyId(b.l(advertAppInfo.apS, 0));
        return downloadData;
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.kK()) {
                l.showToast(this.mContext.getPageActivity(), e.j.neterror);
            } else if (advertAppInfo.yq()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(e.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.eK(str);
                aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.CriusAdCardView.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        CriusAdCardView.this.d(advertAppInfo, i);
                        if (CriusAdCardView.this.gSj != null) {
                            CriusAdCardView.this.gSj.p(CriusAdCardView.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).BS();
            }
        }
    }

    protected void d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo != null) {
            if (advertAppInfo.yp() != 0) {
                l.showToast(this.mContext.getPageActivity(), e.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.EG();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.B(this.mContext.getPageActivity()) && this.frw != null) {
                this.frw.b(advertAppInfo, i);
                if (this.gSj != null) {
                    this.gSj.p(c(advertAppInfo, i));
                }
            }
        }
    }

    private void bwo() {
        if (this.fjW != null && this.gSg != null) {
            this.fjW.removeAllViews();
            this.gSh = this.gSg.a(this.mContext.getPageActivity(), this.criusData, TbadkCoreApplication.getInst().getSkinType() == 1);
            this.fjW.addView(this.gSh);
            al.i(this.gSh, e.f.addresslist_item_bg);
            bwn();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aZG() {
        if (this.gSg != null && ((TextView) this.gSg.dc("title")) != null) {
            this.criusData.d("title", TbConfig.getContentSize() / l.aR(this.mContext.getPageActivity()));
            bwo();
        }
    }
}
