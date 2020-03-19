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
    private static final Pattern jHw = Pattern.compile("(/p/){1}(\\d+)");
    private y drH;
    private BannerView gGG = null;
    private boolean gGI = false;
    BannerView.a gGK = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aMH() {
            c.this.bIT();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aMI() {
            c.this.bIV();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c jHu;
    private a.InterfaceC0401a jHv;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.jHu = cVar;
        if (this.jHu != null && (this.jHu.aVF() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.jHu.aVF();
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
            this.drH = (y) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0401a interfaceC0401a) {
        this.jHv = interfaceC0401a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void aVA() {
        if (this.mPageContext != null && this.jHv != null) {
            if (this.drH == null) {
                bIV();
            } else if (!this.drH.isValid()) {
                bIV();
            } else {
                if (!this.gGI) {
                    if (this.gGG == null) {
                        this.gGG = new BannerView(this.mPageContext.getPageActivity());
                        this.gGG.setVisibility(8);
                        this.gGG.setBannerViewClickListener(this.gGK);
                        this.gGG.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onComplete(String str, boolean z) {
                                if (z) {
                                    if (c.this.drH != null && c.this.drH.cPi) {
                                        String aAB = c.this.drH.aAB();
                                        if (!StringUtils.isNULL(aAB)) {
                                            c.this.HK(aAB);
                                        }
                                        c.this.drH.cPi = false;
                                    }
                                    if (c.this.gGG != null && c.this.gGG.aMF() && !c.this.gGI) {
                                        c.this.gGI = true;
                                        c.this.jHv.a(c.this.jHu, c.this.gGG);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.drH.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.jHv.a(this.jHu, this.gGG);
                }
                this.gGG.setBannerData(this.drH);
                this.gGG.reset();
                if (this.drH.getType() == 1 && !TextUtils.isEmpty(this.drH.aAL())) {
                    this.gGG.setData(this.mPageContext, this.drH.aAL());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIV() {
        if (this.gGG != null && this.jHv != null) {
            this.gGI = false;
            this.jHv.b(this.jHu, this.gGG);
            this.gGG = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIT() {
        if (this.drH != null) {
            String value = this.drH.getValue();
            String aAB = this.drH.aAB();
            if (this.drH.aAK() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                em(aAB, value);
            } else if (this.drH.aAK() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = jHw.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            em(aAB, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.drH.aAK() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.daV != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.daV) {
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
                    r.cCQ().cCN().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                    }
                }
                em(aAB, value);
            } else if (this.drH.aAK() == 4) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                em(aAB, value);
            }
        }
    }

    private void em(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0613a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.eC(TiebaInitialize.Params.OBJ_URL, str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HK(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0613a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.eC(TiebaInitialize.Params.OBJ_URL, this.drH.aAL());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.gGG;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.gGG != null) {
            this.gGG.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.gGG != null) {
            this.gGG.aMG();
        }
    }
}
