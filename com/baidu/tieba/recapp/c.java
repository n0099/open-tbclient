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
/* loaded from: classes13.dex */
public class c implements com.baidu.tieba.InjectPlugin.FrsBannerAd.a {
    private static final Pattern jFL = Pattern.compile("(/p/){1}(\\d+)");
    private y drg;
    private com.baidu.tieba.InjectPlugin.a.c jFJ;
    private a.InterfaceC0401a jFK;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private BannerView gFw = null;
    private boolean gFy = false;
    BannerView.a gFA = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aMC() {
            c.this.bIG();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aMD() {
            c.this.bII();
        }
    };

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.jFJ = cVar;
        if (this.jFJ != null && (this.jFJ.aVA() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.jFJ.aVA();
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
            this.drg = (y) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0401a interfaceC0401a) {
        this.jFK = interfaceC0401a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void aVv() {
        if (this.mPageContext != null && this.jFK != null) {
            if (this.drg == null) {
                bII();
            } else if (!this.drg.isValid()) {
                bII();
            } else {
                if (!this.gFy) {
                    if (this.gFw == null) {
                        this.gFw = new BannerView(this.mPageContext.getPageActivity());
                        this.gFw.setVisibility(8);
                        this.gFw.setBannerViewClickListener(this.gFA);
                        this.gFw.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onComplete(String str, boolean z) {
                                if (z) {
                                    if (c.this.drg != null && c.this.drg.cOU) {
                                        String aAy = c.this.drg.aAy();
                                        if (!StringUtils.isNULL(aAy)) {
                                            c.this.HJ(aAy);
                                        }
                                        c.this.drg.cOU = false;
                                    }
                                    if (c.this.gFw != null && c.this.gFw.aMA() && !c.this.gFy) {
                                        c.this.gFy = true;
                                        c.this.jFK.a(c.this.jFJ, c.this.gFw);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.drg.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.jFK.a(this.jFJ, this.gFw);
                }
                this.gFw.setBannerData(this.drg);
                this.gFw.reset();
                if (this.drg.getType() == 1 && !TextUtils.isEmpty(this.drg.aAI())) {
                    this.gFw.setData(this.mPageContext, this.drg.aAI());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bII() {
        if (this.gFw != null && this.jFK != null) {
            this.gFy = false;
            this.jFK.b(this.jFJ, this.gFw);
            this.gFw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIG() {
        if (this.drg != null) {
            String value = this.drg.getValue();
            String aAy = this.drg.aAy();
            if (this.drg.aAH() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                eo(aAy, value);
            } else if (this.drg.aAH() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = jFL.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            eo(aAy, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.drg.aAH() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.daH != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.daH) {
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
                    r.cCv().cCs().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                    }
                }
                eo(aAy, value);
            } else if (this.drg.aAH() == 4) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                eo(aAy, value);
            }
        }
    }

    private void eo(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0612a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.eE(TiebaInitialize.Params.OBJ_URL, str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HJ(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0612a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.eE(TiebaInitialize.Params.OBJ_URL, this.drg.aAI());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.gFw;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.gFw != null) {
            this.gFw.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.gFw != null) {
            this.gFw.aMB();
        }
    }
}
