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
import com.baidu.tbadk.core.data.ac;
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
    private static final Pattern llz = Pattern.compile("(/p/){1}(\\d+)");
    private ac evc;
    private BannerView hYT = null;
    private boolean hYV = false;
    BannerView.a hYY = new BannerView.a() { // from class: com.baidu.tieba.recapp.b.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bgW() {
            b.this.cgG();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bgX() {
            b.this.cgI();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c llx;
    private a.InterfaceC0521a lly;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.llx = cVar;
        if (this.llx != null && (this.llx.bqu() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.llx.bqu();
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
        if (obj instanceof ac) {
            this.evc = (ac) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0521a interfaceC0521a) {
        this.lly = interfaceC0521a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void bqp() {
        if (this.mPageContext != null && this.lly != null) {
            if (this.evc == null) {
                cgI();
            } else if (!this.evc.isValid()) {
                cgI();
            } else {
                if (!this.hYV) {
                    if (this.hYT == null) {
                        this.hYT = new BannerView(this.mPageContext.getPageActivity());
                        this.hYT.setVisibility(8);
                        this.hYT.setBannerViewClickListener(this.hYY);
                        this.hYT.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.b.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onComplete(String str, boolean z) {
                                if (z) {
                                    if (b.this.evc != null && b.this.evc.dOY) {
                                        String aUq = b.this.evc.aUq();
                                        if (!StringUtils.isNULL(aUq)) {
                                            b.this.Mn(aUq);
                                        }
                                        b.this.evc.dOY = false;
                                    }
                                    if (b.this.hYT != null && b.this.hYT.bgU() && !b.this.hYV) {
                                        b.this.hYV = true;
                                        b.this.lly.a(b.this.llx, b.this.hYT);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.evc.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.lly.a(this.llx, this.hYT);
                }
                this.hYT.setBannerData(this.evc);
                this.hYT.reset();
                if (this.evc.getType() == 1 && !TextUtils.isEmpty(this.evc.aUy())) {
                    this.hYT.setData(this.mPageContext, this.evc.aUy());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgI() {
        if (this.hYT != null && this.lly != null) {
            this.hYV = false;
            this.lly.b(this.llx, this.hYT);
            this.hYT = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgG() {
        if (this.evc != null) {
            String value = this.evc.getValue();
            String aUq = this.evc.aUq();
            if (this.evc.aUx() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                fl(aUq, value);
            } else if (this.evc.aUx() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = llz.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            fl(aUq, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.evc.aUx() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.ebG != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.ebG) {
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
                    r.dca().dbX().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                    }
                }
                fl(aUq, value);
            } else if (this.evc.aUx() == 4) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                fl(aUq, value);
            }
        }
    }

    private void fl(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0755a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.fB(TiebaInitialize.Params.OBJ_URL, str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mn(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0755a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.fB(TiebaInitialize.Params.OBJ_URL, this.evc.aUy());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.hYT;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.hYT != null) {
            this.hYT.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.hYT != null) {
            this.hYT.bgV();
        }
    }
}
