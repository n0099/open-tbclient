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
/* loaded from: classes7.dex */
public class d implements com.baidu.tieba.InjectPlugin.FrsBannerAd.a {
    private static final Pattern mTG = Pattern.compile("(/p/){1}(\\d+)");
    private af fxD;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private com.baidu.tieba.InjectPlugin.a.c mTE;
    private a.InterfaceC0595a mTF;
    private BannerView jFv = null;
    private boolean isAddBanner = false;
    BannerView.a jFA = new BannerView.a() { // from class: com.baidu.tieba.recapp.d.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bzr() {
            d.this.cJh();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bzs() {
            d.this.cJj();
        }
    };

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.mTE = cVar;
        if (this.mTE != null && (this.mTE.bJD() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.mTE.bJD();
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
            this.fxD = (af) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0595a interfaceC0595a) {
        this.mTF = interfaceC0595a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void bJy() {
        if (this.mPageContext != null && this.mTF != null) {
            if (this.fxD == null) {
                cJj();
            } else if (!this.fxD.isValid()) {
                cJj();
            } else {
                if (!this.isAddBanner) {
                    if (this.jFv == null) {
                        this.jFv = new BannerView(this.mPageContext.getPageActivity());
                        this.jFv.setVisibility(8);
                        this.jFv.setBannerViewClickListener(this.jFA);
                        this.jFv.setBannerViewEvent(new TbImageView.b() { // from class: com.baidu.tieba.recapp.d.1
                            @Override // com.baidu.tbadk.widget.TbImageView.b
                            public void onComplete(String str, boolean z) {
                                if (z) {
                                    if (d.this.fxD != null && d.this.fxD.ePi) {
                                        String blU = d.this.fxD.blU();
                                        if (!StringUtils.isNULL(blU)) {
                                            d.this.Ry(blU);
                                        }
                                        d.this.fxD.ePi = false;
                                    }
                                    if (d.this.jFv != null && d.this.jFv.bzp() && !d.this.isAddBanner) {
                                        d.this.isAddBanner = true;
                                        d.this.mTF.a(d.this.mTE, d.this.jFv);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.b
                            public void onCancel() {
                            }
                        });
                        if (this.fxD.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.mTF.a(this.mTE, this.jFv);
                }
                this.jFv.setBannerData(this.fxD);
                this.jFv.reset();
                if (this.fxD.getType() == 1 && !TextUtils.isEmpty(this.fxD.bmc())) {
                    this.jFv.setData(this.mPageContext, this.fxD.bmc());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJj() {
        if (this.jFv != null && this.mTF != null) {
            this.isAddBanner = false;
            this.mTF.b(this.mTE, this.jFv);
            this.jFv = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJh() {
        if (this.fxD != null) {
            String value = this.fxD.getValue();
            String blU = this.fxD.blU();
            if (this.fxD.bmb() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                gj(blU, value);
            } else if (this.fxD.bmb() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = mTG.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            gj(blU, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.fxD.bmb() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.fcX != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.fcX) {
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
                    s.dDB().dDy().a(this.mPageContext.getPageActivity(), new String[]{value}, null);
                    if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                    }
                }
                gj(blU, value);
            } else if (this.fxD.bmb() == 4) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                gj(blU, value);
            }
        }
    }

    private void gj(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0880a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.gA(TiebaInitialize.Params.OBJ_URL, str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ry(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0880a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.gA(TiebaInitialize.Params.OBJ_URL, this.fxD.bmc());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.jFv;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.jFv != null) {
            this.jFv.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.jFv != null) {
            this.jFv.bzq();
        }
    }
}
