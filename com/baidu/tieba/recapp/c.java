package com.baidu.tieba.recapp;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.InjectPlugin.FrsBannerAd.a;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class c implements com.baidu.tieba.InjectPlugin.FrsBannerAd.a {
    private static final Pattern fWv = Pattern.compile("(/p/){1}(\\d+)");
    private w axE;
    private BannerView dlT = null;
    private boolean dlU = false;
    BannerView.a dlX = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void BS() {
            c.this.atE();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void BT() {
            c.this.atG();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c fWt;
    private a.InterfaceC0108a fWu;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void G(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.fWt = cVar;
        if (this.fWt != null && (this.fWt.KP() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.fWt.KP();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.a
    public void setParams(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            this.mForumName = map.get("forum_name");
            this.mForumId = map.get("forum_id");
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setData(Object obj) {
        if (obj instanceof w) {
            this.axE = (w) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0108a interfaceC0108a) {
        this.fWu = interfaceC0108a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void KK() {
        if (this.mPageContext != null && this.fWu != null) {
            if (this.axE == null) {
                atG();
            } else if (!this.axE.isValid()) {
                atG();
            } else {
                if (!this.dlU) {
                    if (this.dlT == null) {
                        this.dlT = new BannerView(this.mPageContext.getPageActivity());
                        this.dlT.setVisibility(8);
                        this.dlT.setBannerViewClickListener(this.dlX);
                        this.dlT.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void n(String str, boolean z) {
                                if (z) {
                                    if (c.this.axE != null && c.this.axE.XP) {
                                        String qJ = c.this.axE.qJ();
                                        if (!StringUtils.isNULL(qJ)) {
                                            c.this.rP(qJ);
                                        }
                                        c.this.axE.XP = false;
                                    }
                                    if (c.this.dlT != null && c.this.dlT.BQ() && !c.this.dlU) {
                                        c.this.dlU = true;
                                        c.this.fWu.a(c.this.fWt, c.this.dlT);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.axE.getValue().startsWith("game:detail:")) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.fWu.a(this.fWt, this.dlT);
                }
                this.dlT.setBannerData(this.axE);
                this.dlT.reset();
                if (this.axE.getType() == 1 && !TextUtils.isEmpty(this.axE.qI())) {
                    this.dlT.setData(this.mPageContext, this.axE.qI());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atG() {
        if (this.dlT != null && this.fWu != null) {
            this.dlU = false;
            this.fWu.b(this.fWt, this.dlT);
            this.dlT = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atE() {
        if (this.axE != null) {
            String value = this.axE.getValue();
            String qJ = this.axE.qJ();
            if (this.axE.qH() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                bP(qJ, value);
            } else if (this.axE.qH() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = fWv.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                            bP(qJ, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.axE.qH() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.ajs != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.ajs) {
                        case FRS:
                            this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            break;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            break;
                    }
                } else {
                    r.bjl().bji().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                bP(qJ, value);
            } else if (this.axE.qH() == 4) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                bP(qJ, value);
            }
        }
    }

    private void bP(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0217a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.cd("obj_url", str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rP(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0217a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.cd("obj_url", this.axE.qI());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.dlT;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.dlT != null) {
            this.dlT.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.dlT != null) {
            this.dlT.BR();
        }
    }
}
