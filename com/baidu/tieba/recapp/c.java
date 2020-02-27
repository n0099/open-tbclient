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
    private static final Pattern jFJ = Pattern.compile("(/p/){1}(\\d+)");
    private y drf;
    private BannerView gFu = null;
    private boolean gFw = false;
    BannerView.a gFy = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aMA() {
            c.this.bIE();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aMB() {
            c.this.bIG();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c jFH;
    private a.InterfaceC0401a jFI;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.jFH = cVar;
        if (this.jFH != null && (this.jFH.aVy() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.jFH.aVy();
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
            this.drf = (y) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0401a interfaceC0401a) {
        this.jFI = interfaceC0401a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void aVt() {
        if (this.mPageContext != null && this.jFI != null) {
            if (this.drf == null) {
                bIG();
            } else if (!this.drf.isValid()) {
                bIG();
            } else {
                if (!this.gFw) {
                    if (this.gFu == null) {
                        this.gFu = new BannerView(this.mPageContext.getPageActivity());
                        this.gFu.setVisibility(8);
                        this.gFu.setBannerViewClickListener(this.gFy);
                        this.gFu.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onComplete(String str, boolean z) {
                                if (z) {
                                    if (c.this.drf != null && c.this.drf.cOT) {
                                        String aAw = c.this.drf.aAw();
                                        if (!StringUtils.isNULL(aAw)) {
                                            c.this.HJ(aAw);
                                        }
                                        c.this.drf.cOT = false;
                                    }
                                    if (c.this.gFu != null && c.this.gFu.aMy() && !c.this.gFw) {
                                        c.this.gFw = true;
                                        c.this.jFI.a(c.this.jFH, c.this.gFu);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.drf.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.jFI.a(this.jFH, this.gFu);
                }
                this.gFu.setBannerData(this.drf);
                this.gFu.reset();
                if (this.drf.getType() == 1 && !TextUtils.isEmpty(this.drf.aAG())) {
                    this.gFu.setData(this.mPageContext, this.drf.aAG());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIG() {
        if (this.gFu != null && this.jFI != null) {
            this.gFw = false;
            this.jFI.b(this.jFH, this.gFu);
            this.gFu = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIE() {
        if (this.drf != null) {
            String value = this.drf.getValue();
            String aAw = this.drf.aAw();
            if (this.drf.aAF() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                eo(aAw, value);
            } else if (this.drf.aAF() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = jFJ.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            eo(aAw, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.drf.aAF() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.daG != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.daG) {
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
                    r.cCt().cCq().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                    }
                }
                eo(aAw, value);
            } else if (this.drf.aAF() == 4) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                eo(aAw, value);
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
            b.eE(TiebaInitialize.Params.OBJ_URL, this.drf.aAG());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.gFu;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.gFu != null) {
            this.gFu.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.gFu != null) {
            this.gFu.aMz();
        }
    }
}
