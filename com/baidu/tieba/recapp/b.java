package com.baidu.tieba.recapp;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.InjectPlugin.FrsBannerAd.a;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes20.dex */
public class b implements com.baidu.tieba.InjectPlugin.FrsBannerAd.a {
    private static final Pattern lCa = Pattern.compile("(/p/){1}(\\d+)");
    private ad eFA;
    private BannerView inb = null;
    private boolean ind = false;
    BannerView.a ing = new BannerView.a() { // from class: com.baidu.tieba.recapp.b.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bpI() {
            b.this.crl();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bpJ() {
            b.this.crn();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c lBY;
    private a.InterfaceC0567a lBZ;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.lBY = cVar;
        if (this.lBY != null && (this.lBY.bzs() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.lBY.bzs();
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
        if (obj instanceof ad) {
            this.eFA = (ad) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0567a interfaceC0567a) {
        this.lBZ = interfaceC0567a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void bzn() {
        if (this.mPageContext != null && this.lBZ != null) {
            if (this.eFA == null) {
                crn();
            } else if (!this.eFA.isValid()) {
                crn();
            } else {
                if (!this.ind) {
                    if (this.inb == null) {
                        this.inb = new BannerView(this.mPageContext.getPageActivity());
                        this.inb.setVisibility(8);
                        this.inb.setBannerViewClickListener(this.ing);
                        this.inb.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.b.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onComplete(String str, boolean z) {
                                if (z) {
                                    if (b.this.eFA != null && b.this.eFA.dYr) {
                                        String bcJ = b.this.eFA.bcJ();
                                        if (!StringUtils.isNULL(bcJ)) {
                                            b.this.Pj(bcJ);
                                        }
                                        b.this.eFA.dYr = false;
                                    }
                                    if (b.this.inb != null && b.this.inb.bpG() && !b.this.ind) {
                                        b.this.ind = true;
                                        b.this.lBZ.a(b.this.lBY, b.this.inb);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.eFA.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.lBZ.a(this.lBY, this.inb);
                }
                this.inb.setBannerData(this.eFA);
                this.inb.reset();
                if (this.eFA.getType() == 1 && !TextUtils.isEmpty(this.eFA.bcR())) {
                    this.inb.setData(this.mPageContext, this.eFA.bcR());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crn() {
        if (this.inb != null && this.lBZ != null) {
            this.ind = false;
            this.lBZ.b(this.lBY, this.inb);
            this.inb = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crl() {
        if (this.eFA != null) {
            String value = this.eFA.getValue();
            String bcJ = this.eFA.bcJ();
            if (this.eFA.bcQ() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                fC(bcJ, value);
            } else if (this.eFA.bcQ() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = lCa.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            fC(bcJ, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.eFA.bcQ() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.elp != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.elp) {
                        case FRS:
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            break;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            break;
                    }
                } else {
                    r.dnh().dne().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                    }
                }
                fC(bcJ, value);
            } else if (this.eFA.bcQ() == 4) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                fC(bcJ, value);
            }
        }
    }

    private void fC(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0808a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.fS(TiebaInitialize.Params.OBJ_URL, str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pj(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0808a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.fS(TiebaInitialize.Params.OBJ_URL, this.eFA.bcR());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.inb;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.inb != null) {
            this.inb.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.inb != null) {
            this.inb.bpH();
        }
    }
}
