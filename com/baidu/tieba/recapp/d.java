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
import com.baidu.tbadk.core.data.af;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.InjectPlugin.FrsBannerAd.a;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class d implements com.baidu.tieba.InjectPlugin.FrsBannerAd.a {
    private static final Pattern mRA = Pattern.compile("(/p/){1}(\\d+)");
    private af fwe;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private com.baidu.tieba.InjectPlugin.a.c mRy;
    private a.InterfaceC0589a mRz;
    private BannerView jDM = null;
    private boolean isAddBanner = false;
    BannerView.a jDR = new BannerView.a() { // from class: com.baidu.tieba.recapp.d.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bzo() {
            d.this.cJb();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bzp() {
            d.this.cJd();
        }
    };

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.mRy = cVar;
        if (this.mRy != null && (this.mRy.bJz() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.mRy.bJz();
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
        if (obj instanceof af) {
            this.fwe = (af) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0589a interfaceC0589a) {
        this.mRz = interfaceC0589a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void bJu() {
        if (this.mPageContext != null && this.mRz != null) {
            if (this.fwe == null) {
                cJd();
            } else if (!this.fwe.isValid()) {
                cJd();
            } else {
                if (!this.isAddBanner) {
                    if (this.jDM == null) {
                        this.jDM = new BannerView(this.mPageContext.getPageActivity());
                        this.jDM.setVisibility(8);
                        this.jDM.setBannerViewClickListener(this.jDR);
                        this.jDM.setBannerViewEvent(new TbImageView.b() { // from class: com.baidu.tieba.recapp.d.1
                            @Override // com.baidu.tbadk.widget.TbImageView.b
                            public void onComplete(String str, boolean z) {
                                if (z) {
                                    if (d.this.fwe != null && d.this.fwe.eNH) {
                                        String blS = d.this.fwe.blS();
                                        if (!StringUtils.isNULL(blS)) {
                                            d.this.Rs(blS);
                                        }
                                        d.this.fwe.eNH = false;
                                    }
                                    if (d.this.jDM != null && d.this.jDM.bzm() && !d.this.isAddBanner) {
                                        d.this.isAddBanner = true;
                                        d.this.mRz.a(d.this.mRy, d.this.jDM);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.b
                            public void onCancel() {
                            }
                        });
                        if (this.fwe.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.mRz.a(this.mRy, this.jDM);
                }
                this.jDM.setBannerData(this.fwe);
                this.jDM.reset();
                if (this.fwe.getType() == 1 && !TextUtils.isEmpty(this.fwe.bma())) {
                    this.jDM.setData(this.mPageContext, this.fwe.bma());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJd() {
        if (this.jDM != null && this.mRz != null) {
            this.isAddBanner = false;
            this.mRz.b(this.mRy, this.jDM);
            this.jDM = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJb() {
        if (this.fwe != null) {
            String value = this.fwe.getValue();
            String blS = this.fwe.blS();
            if (this.fwe.blZ() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                gj(blS, value);
            } else if (this.fwe.blZ() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = mRA.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            gj(blS, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.fwe.blZ() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.fbx != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.fbx) {
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
                    s.dDt().dDq().a(this.mPageContext.getPageActivity(), new String[]{value}, null);
                    if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                    }
                }
                gj(blS, value);
            } else if (this.fwe.blZ() == 4) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                gj(blS, value);
            }
        }
    }

    private void gj(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0874a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b2.gA(TiebaInitialize.Params.OBJ_URL, str2);
            b2.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rs(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0874a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b2.gA(TiebaInitialize.Params.OBJ_URL, this.fwe.bma());
            b2.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.jDM;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.jDM != null) {
            this.jDM.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.jDM != null) {
            this.jDM.bzn();
        }
    }
}
