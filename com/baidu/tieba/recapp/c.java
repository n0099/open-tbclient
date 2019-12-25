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
/* loaded from: classes10.dex */
public class c implements com.baidu.tieba.InjectPlugin.FrsBannerAd.a {
    private static final Pattern jBl = Pattern.compile("(/p/){1}(\\d+)");
    private y dmI;
    private BannerView gAl = null;
    private boolean gAn = false;
    BannerView.a gAp = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aJK() {
            c.this.bGb();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aJL() {
            c.this.bGd();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c jBj;
    private a.InterfaceC0388a jBk;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.jBj = cVar;
        if (this.jBj != null && (this.jBj.aSN() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.jBj.aSN();
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
            this.dmI = (y) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0388a interfaceC0388a) {
        this.jBk = interfaceC0388a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void aSI() {
        if (this.mPageContext != null && this.jBk != null) {
            if (this.dmI == null) {
                bGd();
            } else if (!this.dmI.isValid()) {
                bGd();
            } else {
                if (!this.gAn) {
                    if (this.gAl == null) {
                        this.gAl = new BannerView(this.mPageContext.getPageActivity());
                        this.gAl.setVisibility(8);
                        this.gAl.setBannerViewClickListener(this.gAp);
                        this.gAl.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onComplete(String str, boolean z) {
                                if (z) {
                                    if (c.this.dmI != null && c.this.dmI.cKF) {
                                        String axP = c.this.dmI.axP();
                                        if (!StringUtils.isNULL(axP)) {
                                            c.this.Hl(axP);
                                        }
                                        c.this.dmI.cKF = false;
                                    }
                                    if (c.this.gAl != null && c.this.gAl.aJI() && !c.this.gAn) {
                                        c.this.gAn = true;
                                        c.this.jBk.a(c.this.jBj, c.this.gAl);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.dmI.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.jBk.a(this.jBj, this.gAl);
                }
                this.gAl.setBannerData(this.dmI);
                this.gAl.reset();
                if (this.dmI.getType() == 1 && !TextUtils.isEmpty(this.dmI.axZ())) {
                    this.gAl.setData(this.mPageContext, this.dmI.axZ());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGd() {
        if (this.gAl != null && this.jBk != null) {
            this.gAn = false;
            this.jBk.b(this.jBj, this.gAl);
            this.gAl = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGb() {
        if (this.dmI != null) {
            String value = this.dmI.getValue();
            String axP = this.dmI.axP();
            if (this.dmI.axY() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                ed(axP, value);
            } else if (this.dmI.axY() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = jBl.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            ed(axP, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.dmI.axY() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.cWt != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.cWt) {
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
                    r.czO().czL().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                    }
                }
                ed(axP, value);
            } else if (this.dmI.axY() == 4) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                ed(axP, value);
            }
        }
    }

    private void ed(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0599a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.et(TiebaInitialize.Params.OBJ_URL, str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hl(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0599a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.et(TiebaInitialize.Params.OBJ_URL, this.dmI.axZ());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.gAl;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.gAl != null) {
            this.gAl.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.gAl != null) {
            this.gAl.aJJ();
        }
    }
}
