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
/* loaded from: classes13.dex */
public class b implements com.baidu.tieba.InjectPlugin.FrsBannerAd.a {
    private static final Pattern kJh = Pattern.compile("(/p/){1}(\\d+)");
    private x egc;
    private BannerView hES = null;
    private boolean hEU = false;
    BannerView.a hEX = new BannerView.a() { // from class: com.baidu.tieba.recapp.b.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bbm() {
            b.this.bZK();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bbn() {
            b.this.bZM();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c kJf;
    private a.InterfaceC0501a kJg;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.kJf = cVar;
        if (this.kJf != null && (this.kJf.bjY() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.kJf.bjY();
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
            this.egc = (x) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0501a interfaceC0501a) {
        this.kJg = interfaceC0501a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void bjT() {
        if (this.mPageContext != null && this.kJg != null) {
            if (this.egc == null) {
                bZM();
            } else if (!this.egc.isValid()) {
                bZM();
            } else {
                if (!this.hEU) {
                    if (this.hES == null) {
                        this.hES = new BannerView(this.mPageContext.getPageActivity());
                        this.hES.setVisibility(8);
                        this.hES.setBannerViewClickListener(this.hEX);
                        this.hES.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.b.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onComplete(String str, boolean z) {
                                if (z) {
                                    if (b.this.egc != null && b.this.egc.dCs) {
                                        String aOH = b.this.egc.aOH();
                                        if (!StringUtils.isNULL(aOH)) {
                                            b.this.Ld(aOH);
                                        }
                                        b.this.egc.dCs = false;
                                    }
                                    if (b.this.hES != null && b.this.hES.bbk() && !b.this.hEU) {
                                        b.this.hEU = true;
                                        b.this.kJg.a(b.this.kJf, b.this.hES);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.egc.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.kJg.a(this.kJf, this.hES);
                }
                this.hES.setBannerData(this.egc);
                this.hES.reset();
                if (this.egc.getType() == 1 && !TextUtils.isEmpty(this.egc.aOR())) {
                    this.hES.setData(this.mPageContext, this.egc.aOR());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZM() {
        if (this.hES != null && this.kJg != null) {
            this.hEU = false;
            this.kJg.b(this.kJf, this.hES);
            this.hES = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZK() {
        if (this.egc != null) {
            String value = this.egc.getValue();
            String aOH = this.egc.aOH();
            if (this.egc.aOQ() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                fc(aOH, value);
            } else if (this.egc.aOQ() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = kJh.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            fc(aOH, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.egc.aOQ() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.dOt != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.dOt) {
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
                    q.cUm().cUj().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                    }
                }
                fc(aOH, value);
            } else if (this.egc.aOQ() == 4) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                fc(aOH, value);
            }
        }
    }

    private void fc(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0728a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.fs(TiebaInitialize.Params.OBJ_URL, str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ld(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0728a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.fs(TiebaInitialize.Params.OBJ_URL, this.egc.aOR());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.hES;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.hES != null) {
            this.hES.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.hES != null) {
            this.hES.bbl();
        }
    }
}
