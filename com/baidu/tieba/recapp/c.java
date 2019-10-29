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
import com.baidu.tbadk.core.data.x;
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
    private static final Pattern iHK = Pattern.compile("(/p/){1}(\\d+)");
    private x czT;
    private BannerView fMN = null;
    private boolean fMP = false;
    BannerView.a fMT = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void asn() {
            c.this.boG();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aso() {
            c.this.boI();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c iHI;
    private a.InterfaceC0307a iHJ;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.iHI = cVar;
        if (this.iHI != null && (this.iHI.aBb() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.iHI.aBb();
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
        if (obj instanceof x) {
            this.czT = (x) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0307a interfaceC0307a) {
        this.iHJ = interfaceC0307a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void aAW() {
        if (this.mPageContext != null && this.iHJ != null) {
            if (this.czT == null) {
                boI();
            } else if (!this.czT.isValid()) {
                boI();
            } else {
                if (!this.fMP) {
                    if (this.fMN == null) {
                        this.fMN = new BannerView(this.mPageContext.getPageActivity());
                        this.fMN.setVisibility(8);
                        this.fMN.setBannerViewClickListener(this.fMT);
                        this.fMN.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onComplete(String str, boolean z) {
                                if (z) {
                                    if (c.this.czT != null && c.this.czT.bZe) {
                                        String agX = c.this.czT.agX();
                                        if (!StringUtils.isNULL(agX)) {
                                            c.this.Cx(agX);
                                        }
                                        c.this.czT.bZe = false;
                                    }
                                    if (c.this.fMN != null && c.this.fMN.asl() && !c.this.fMP) {
                                        c.this.fMP = true;
                                        c.this.iHJ.a(c.this.iHI, c.this.fMN);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.czT.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.iHJ.a(this.iHI, this.fMN);
                }
                this.fMN.setBannerData(this.czT);
                this.fMN.reset();
                if (this.czT.getType() == 1 && !TextUtils.isEmpty(this.czT.ahh())) {
                    this.fMN.setData(this.mPageContext, this.czT.ahh());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boI() {
        if (this.fMN != null && this.iHJ != null) {
            this.fMP = false;
            this.iHJ.b(this.iHI, this.fMN);
            this.fMN = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boG() {
        if (this.czT != null) {
            String value = this.czT.getValue();
            String agX = this.czT.agX();
            if (this.czT.ahg() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                dK(agX, value);
            } else if (this.czT.ahg() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = iHK.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            dK(agX, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.czT.ahg() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.ckz != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.ckz) {
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
                    r.cfL().cfI().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                    }
                }
                dK(agX, value);
            } else if (this.czT.ahg() == 4) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                dK(agX, value);
            }
        }
    }

    private void dK(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0520a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.ea(TiebaInitialize.Params.OBJ_URL, str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cx(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0520a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.ea(TiebaInitialize.Params.OBJ_URL, this.czT.ahh());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.fMN;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.fMN != null) {
            this.fMN.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.fMN != null) {
            this.fMN.asm();
        }
    }
}
