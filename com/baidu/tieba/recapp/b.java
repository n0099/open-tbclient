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
/* loaded from: classes25.dex */
public class b implements com.baidu.tieba.InjectPlugin.FrsBannerAd.a {
    private static final Pattern lLf = Pattern.compile("(/p/){1}(\\d+)");
    private ad eHL;
    private com.baidu.tieba.InjectPlugin.a.c lLd;
    private a.InterfaceC0563a lLe;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private BannerView iuy = null;
    private boolean iuA = false;
    BannerView.a iuD = new BannerView.a() { // from class: com.baidu.tieba.recapp.b.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bqD() {
            b.this.cuB();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bqE() {
            b.this.cuD();
        }
    };

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.lLd = cVar;
        if (this.lLd != null && (this.lLd.bAC() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.lLd.bAC();
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
            this.eHL = (ad) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0563a interfaceC0563a) {
        this.lLe = interfaceC0563a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void bAx() {
        if (this.mPageContext != null && this.lLe != null) {
            if (this.eHL == null) {
                cuD();
            } else if (!this.eHL.isValid()) {
                cuD();
            } else {
                if (!this.iuA) {
                    if (this.iuy == null) {
                        this.iuy = new BannerView(this.mPageContext.getPageActivity());
                        this.iuy.setVisibility(8);
                        this.iuy.setBannerViewClickListener(this.iuD);
                        this.iuy.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.b.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onComplete(String str, boolean z) {
                                if (z) {
                                    if (b.this.eHL != null && b.this.eHL.eaF) {
                                        String bdD = b.this.eHL.bdD();
                                        if (!StringUtils.isNULL(bdD)) {
                                            b.this.PK(bdD);
                                        }
                                        b.this.eHL.eaF = false;
                                    }
                                    if (b.this.iuy != null && b.this.iuy.bqB() && !b.this.iuA) {
                                        b.this.iuA = true;
                                        b.this.lLe.a(b.this.lLd, b.this.iuy);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.eHL.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.lLe.a(this.lLd, this.iuy);
                }
                this.iuy.setBannerData(this.eHL);
                this.iuy.reset();
                if (this.eHL.getType() == 1 && !TextUtils.isEmpty(this.eHL.bdL())) {
                    this.iuy.setData(this.mPageContext, this.eHL.bdL());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuD() {
        if (this.iuy != null && this.lLe != null) {
            this.iuA = false;
            this.lLe.b(this.lLd, this.iuy);
            this.iuy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuB() {
        if (this.eHL != null) {
            String value = this.eHL.getValue();
            String bdD = this.eHL.bdD();
            if (this.eHL.bdK() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                fP(bdD, value);
            } else if (this.eHL.bdK() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = lLf.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            fP(bdD, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.eHL.bdK() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.enL != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.enL) {
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
                    r.dqU().dqR().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                    }
                }
                fP(bdD, value);
            } else if (this.eHL.bdK() == 4) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                fP(bdD, value);
            }
        }
    }

    private void fP(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0805a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.gf(TiebaInitialize.Params.OBJ_URL, str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PK(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0805a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.gf(TiebaInitialize.Params.OBJ_URL, this.eHL.bdL());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.iuy;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.iuy != null) {
            this.iuy.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.iuy != null) {
            this.iuy.bqC();
        }
    }
}
