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
    private static final Pattern fXB = Pattern.compile("(/p/){1}(\\d+)");
    private w axF;
    private BannerView dna = null;
    private boolean dnb = false;
    BannerView.a dne = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void BQ() {
            c.this.atD();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void BR() {
            c.this.atF();
        }
    };
    private a.InterfaceC0108a fXA;
    private com.baidu.tieba.InjectPlugin.a.c fXz;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void G(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.fXz = cVar;
        if (this.fXz != null && (this.fXz.KN() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.fXz.KN();
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
            this.axF = (w) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0108a interfaceC0108a) {
        this.fXA = interfaceC0108a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void KI() {
        if (this.mPageContext != null && this.fXA != null) {
            if (this.axF == null) {
                atF();
            } else if (!this.axF.isValid()) {
                atF();
            } else {
                if (!this.dnb) {
                    if (this.dna == null) {
                        this.dna = new BannerView(this.mPageContext.getPageActivity());
                        this.dna.setVisibility(8);
                        this.dna.setBannerViewClickListener(this.dne);
                        this.dna.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void n(String str, boolean z) {
                                if (z) {
                                    if (c.this.axF != null && c.this.axF.XQ) {
                                        String qI = c.this.axF.qI();
                                        if (!StringUtils.isNULL(qI)) {
                                            c.this.rS(qI);
                                        }
                                        c.this.axF.XQ = false;
                                    }
                                    if (c.this.dna != null && c.this.dna.BO() && !c.this.dnb) {
                                        c.this.dnb = true;
                                        c.this.fXA.a(c.this.fXz, c.this.dna);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.axF.getValue().startsWith("game:detail:")) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.fXA.a(this.fXz, this.dna);
                }
                this.dna.setBannerData(this.axF);
                this.dna.reset();
                if (this.axF.getType() == 1 && !TextUtils.isEmpty(this.axF.qH())) {
                    this.dna.setData(this.mPageContext, this.axF.qH());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atF() {
        if (this.dna != null && this.fXA != null) {
            this.dnb = false;
            this.fXA.b(this.fXz, this.dna);
            this.dna = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atD() {
        if (this.axF != null) {
            String value = this.axF.getValue();
            String qI = this.axF.qI();
            if (this.axF.qG() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                bP(qI, value);
            } else if (this.axF.qG() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = fXB.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                            bP(qI, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.axF.qG() == 3) {
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
                    r.bjk().bjh().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                bP(qI, value);
            } else if (this.axF.qG() == 4) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                bP(qI, value);
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
    public void rS(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0217a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.cd("obj_url", this.axF.qH());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.dna;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.dna != null) {
            this.dna.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.dna != null) {
            this.dna.BP();
        }
    }
}
