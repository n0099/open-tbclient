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
    private static final Pattern iGT = Pattern.compile("(/p/){1}(\\d+)");
    private x czc;
    private BannerView fLW = null;
    private boolean fLY = false;
    BannerView.a fMc = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void asl() {
            c.this.boE();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void asm() {
            c.this.boG();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c iGR;
    private a.InterfaceC0307a iGS;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.iGR = cVar;
        if (this.iGR != null && (this.iGR.aAZ() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.iGR.aAZ();
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
            this.czc = (x) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0307a interfaceC0307a) {
        this.iGS = interfaceC0307a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void aAU() {
        if (this.mPageContext != null && this.iGS != null) {
            if (this.czc == null) {
                boG();
            } else if (!this.czc.isValid()) {
                boG();
            } else {
                if (!this.fLY) {
                    if (this.fLW == null) {
                        this.fLW = new BannerView(this.mPageContext.getPageActivity());
                        this.fLW.setVisibility(8);
                        this.fLW.setBannerViewClickListener(this.fMc);
                        this.fLW.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onComplete(String str, boolean z) {
                                if (z) {
                                    if (c.this.czc != null && c.this.czc.bYn) {
                                        String agV = c.this.czc.agV();
                                        if (!StringUtils.isNULL(agV)) {
                                            c.this.Cx(agV);
                                        }
                                        c.this.czc.bYn = false;
                                    }
                                    if (c.this.fLW != null && c.this.fLW.asj() && !c.this.fLY) {
                                        c.this.fLY = true;
                                        c.this.iGS.a(c.this.iGR, c.this.fLW);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.czc.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.iGS.a(this.iGR, this.fLW);
                }
                this.fLW.setBannerData(this.czc);
                this.fLW.reset();
                if (this.czc.getType() == 1 && !TextUtils.isEmpty(this.czc.ahf())) {
                    this.fLW.setData(this.mPageContext, this.czc.ahf());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boG() {
        if (this.fLW != null && this.iGS != null) {
            this.fLY = false;
            this.iGS.b(this.iGR, this.fLW);
            this.fLW = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boE() {
        if (this.czc != null) {
            String value = this.czc.getValue();
            String agV = this.czc.agV();
            if (this.czc.ahe() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                dK(agV, value);
            } else if (this.czc.ahe() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = iGT.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            dK(agV, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.czc.ahe() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.cjI != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.cjI) {
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
                    r.cfJ().cfG().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                    }
                }
                dK(agV, value);
            } else if (this.czc.ahe() == 4) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                dK(agV, value);
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
            b.ea(TiebaInitialize.Params.OBJ_URL, this.czc.ahf());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.fLW;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.fLW != null) {
            this.fLW.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.fLW != null) {
            this.fLW.ask();
        }
    }
}
