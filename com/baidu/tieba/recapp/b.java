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
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.InjectPlugin.FrsBannerAd.a;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes20.dex */
public class b implements com.baidu.tieba.InjectPlugin.FrsBannerAd.a {
    private static final Pattern lCl = Pattern.compile("(/p/){1}(\\d+)");
    private ad eFE;
    private BannerView inh = null;
    private boolean inj = false;
    BannerView.a inm = new BannerView.a() { // from class: com.baidu.tieba.recapp.b.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bpJ() {
            b.this.crm();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bpK() {
            b.this.cro();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c lCj;
    private a.InterfaceC0567a lCk;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.lCj = cVar;
        if (this.lCj != null && (this.lCj.bzt() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.lCj.bzt();
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
        if (obj instanceof ad) {
            this.eFE = (ad) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0567a interfaceC0567a) {
        this.lCk = interfaceC0567a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void bzo() {
        if (this.mPageContext != null && this.lCk != null) {
            if (this.eFE == null) {
                cro();
            } else if (!this.eFE.isValid()) {
                cro();
            } else {
                if (!this.inj) {
                    if (this.inh == null) {
                        this.inh = new BannerView(this.mPageContext.getPageActivity());
                        this.inh.setVisibility(8);
                        this.inh.setBannerViewClickListener(this.inm);
                        this.inh.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.b.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onComplete(String str, boolean z) {
                                if (z) {
                                    if (b.this.eFE != null && b.this.eFE.dYv) {
                                        String bcJ = b.this.eFE.bcJ();
                                        if (!StringUtils.isNULL(bcJ)) {
                                            b.this.Pk(bcJ);
                                        }
                                        b.this.eFE.dYv = false;
                                    }
                                    if (b.this.inh != null && b.this.inh.bpH() && !b.this.inj) {
                                        b.this.inj = true;
                                        b.this.lCk.a(b.this.lCj, b.this.inh);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.eFE.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.lCk.a(this.lCj, this.inh);
                }
                this.inh.setBannerData(this.eFE);
                this.inh.reset();
                if (this.eFE.getType() == 1 && !TextUtils.isEmpty(this.eFE.bcR())) {
                    this.inh.setData(this.mPageContext, this.eFE.bcR());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cro() {
        if (this.inh != null && this.lCk != null) {
            this.inj = false;
            this.lCk.b(this.lCj, this.inh);
            this.inh = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crm() {
        if (this.eFE != null) {
            String value = this.eFE.getValue();
            String bcJ = this.eFE.bcJ();
            if (this.eFE.bcQ() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                fD(bcJ, value);
            } else if (this.eFE.bcQ() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = lCl.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            fD(bcJ, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.eFE.bcQ() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.elt != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.elt) {
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
                    r.dnk().dnh().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                    }
                }
                fD(bcJ, value);
            } else if (this.eFE.bcQ() == 4) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                fD(bcJ, value);
            }
        }
    }

    private void fD(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0808a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.fT(TiebaInitialize.Params.OBJ_URL, str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pk(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0808a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.fT(TiebaInitialize.Params.OBJ_URL, this.eFE.bcR());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.inh;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.inh != null) {
            this.inh.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.inh != null) {
            this.inh.bpI();
        }
    }
}
