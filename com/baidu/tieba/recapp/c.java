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
    private static final Pattern jFX = Pattern.compile("(/p/){1}(\\d+)");
    private y dru;
    private BannerView gFI = null;
    private boolean gFK = false;
    BannerView.a gFM = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aMD() {
            c.this.bIH();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aME() {
            c.this.bIJ();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c jFV;
    private a.InterfaceC0401a jFW;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.jFV = cVar;
        if (this.jFV != null && (this.jFV.aVB() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.jFV.aVB();
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
            this.dru = (y) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0401a interfaceC0401a) {
        this.jFW = interfaceC0401a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void aVw() {
        if (this.mPageContext != null && this.jFW != null) {
            if (this.dru == null) {
                bIJ();
            } else if (!this.dru.isValid()) {
                bIJ();
            } else {
                if (!this.gFK) {
                    if (this.gFI == null) {
                        this.gFI = new BannerView(this.mPageContext.getPageActivity());
                        this.gFI.setVisibility(8);
                        this.gFI.setBannerViewClickListener(this.gFM);
                        this.gFI.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onComplete(String str, boolean z) {
                                if (z) {
                                    if (c.this.dru != null && c.this.dru.cOV) {
                                        String aAy = c.this.dru.aAy();
                                        if (!StringUtils.isNULL(aAy)) {
                                            c.this.HK(aAy);
                                        }
                                        c.this.dru.cOV = false;
                                    }
                                    if (c.this.gFI != null && c.this.gFI.aMB() && !c.this.gFK) {
                                        c.this.gFK = true;
                                        c.this.jFW.a(c.this.jFV, c.this.gFI);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.dru.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.jFW.a(this.jFV, this.gFI);
                }
                this.gFI.setBannerData(this.dru);
                this.gFI.reset();
                if (this.dru.getType() == 1 && !TextUtils.isEmpty(this.dru.aAI())) {
                    this.gFI.setData(this.mPageContext, this.dru.aAI());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIJ() {
        if (this.gFI != null && this.jFW != null) {
            this.gFK = false;
            this.jFW.b(this.jFV, this.gFI);
            this.gFI = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIH() {
        if (this.dru != null) {
            String value = this.dru.getValue();
            String aAy = this.dru.aAy();
            if (this.dru.aAH() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                eo(aAy, value);
            } else if (this.dru.aAH() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = jFX.matcher(value);
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
            } else if (this.dru.aAH() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.daI != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.daI) {
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
                    r.cCw().cCt().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                    }
                }
                eo(aAy, value);
            } else if (this.dru.aAH() == 4) {
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
    public void HK(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0612a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.eE(TiebaInitialize.Params.OBJ_URL, this.dru.aAI());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.gFI;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.gFI != null) {
            this.gFI.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.gFI != null) {
            this.gFI.aMC();
        }
    }
}
