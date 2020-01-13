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
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.InjectPlugin.FrsBannerAd.a;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes11.dex */
public class c implements com.baidu.tieba.InjectPlugin.FrsBannerAd.a {
    private static final Pattern jEN = Pattern.compile("(/p/){1}(\\d+)");
    private y dmW;
    private BannerView gDv = null;
    private boolean gDx = false;
    BannerView.a gDz = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aKe() {
            c.this.bHd();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aKf() {
            c.this.bHf();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c jEL;
    private a.InterfaceC0390a jEM;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.jEL = cVar;
        if (this.jEL != null && (this.jEL.aTh() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.jEL.aTh();
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
        if (obj instanceof y) {
            this.dmW = (y) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0390a interfaceC0390a) {
        this.jEM = interfaceC0390a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void aTc() {
        if (this.mPageContext != null && this.jEM != null) {
            if (this.dmW == null) {
                bHf();
            } else if (!this.dmW.isValid()) {
                bHf();
            } else {
                if (!this.gDx) {
                    if (this.gDv == null) {
                        this.gDv = new BannerView(this.mPageContext.getPageActivity());
                        this.gDv.setVisibility(8);
                        this.gDv.setBannerViewClickListener(this.gDz);
                        this.gDv.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onComplete(String str, boolean z) {
                                if (z) {
                                    if (c.this.dmW != null && c.this.dmW.cKQ) {
                                        String ayi = c.this.dmW.ayi();
                                        if (!StringUtils.isNULL(ayi)) {
                                            c.this.Hv(ayi);
                                        }
                                        c.this.dmW.cKQ = false;
                                    }
                                    if (c.this.gDv != null && c.this.gDv.aKc() && !c.this.gDx) {
                                        c.this.gDx = true;
                                        c.this.jEM.a(c.this.jEL, c.this.gDv);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.dmW.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.jEM.a(this.jEL, this.gDv);
                }
                this.gDv.setBannerData(this.dmW);
                this.gDv.reset();
                if (this.dmW.getType() == 1 && !TextUtils.isEmpty(this.dmW.ays())) {
                    this.gDv.setData(this.mPageContext, this.dmW.ays());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHf() {
        if (this.gDv != null && this.jEM != null) {
            this.gDx = false;
            this.jEM.b(this.jEL, this.gDv);
            this.gDv = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHd() {
        if (this.dmW != null) {
            String value = this.dmW.getValue();
            String ayi = this.dmW.ayi();
            if (this.dmW.ayr() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                ef(ayi, value);
            } else if (this.dmW.ayr() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = jEN.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            ef(ayi, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.dmW.ayr() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.cWD != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.cWD) {
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
                    r.cAV().cAS().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                    }
                }
                ef(ayi, value);
            } else if (this.dmW.ayr() == 4) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                ef(ayi, value);
            }
        }
    }

    private void ef(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0604a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.ev(TiebaInitialize.Params.OBJ_URL, str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hv(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0604a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.ev(TiebaInitialize.Params.OBJ_URL, this.dmW.ays());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.gDv;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.gDv != null) {
            this.gDv.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.gDv != null) {
            this.gDv.aKd();
        }
    }
}
