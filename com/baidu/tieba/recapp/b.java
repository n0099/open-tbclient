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
/* loaded from: classes26.dex */
public class b implements com.baidu.tieba.InjectPlugin.FrsBannerAd.a {
    private static final Pattern msS = Pattern.compile("(/p/){1}(\\d+)");
    private ad fig;
    private BannerView jbK = null;
    private boolean jbM = false;
    BannerView.a jbP = new BannerView.a() { // from class: com.baidu.tieba.recapp.b.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bxF() {
            b.this.cDG();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bxG() {
            b.this.cDI();
        }
    };
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private com.baidu.tieba.InjectPlugin.a.c msQ;
    private a.InterfaceC0606a msR;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.msQ = cVar;
        if (this.msQ != null && (this.msQ.bHG() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.msQ.bHG();
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
            this.fig = (ad) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0606a interfaceC0606a) {
        this.msR = interfaceC0606a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void bHB() {
        if (this.mPageContext != null && this.msR != null) {
            if (this.fig == null) {
                cDI();
            } else if (!this.fig.isValid()) {
                cDI();
            } else {
                if (!this.jbM) {
                    if (this.jbK == null) {
                        this.jbK = new BannerView(this.mPageContext.getPageActivity());
                        this.jbK.setVisibility(8);
                        this.jbK.setBannerViewClickListener(this.jbP);
                        this.jbK.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.b.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onComplete(String str, boolean z) {
                                if (z) {
                                    if (b.this.fig != null && b.this.fig.eBa) {
                                        String bkF = b.this.fig.bkF();
                                        if (!StringUtils.isNULL(bkF)) {
                                            b.this.Ro(bkF);
                                        }
                                        b.this.fig.eBa = false;
                                    }
                                    if (b.this.jbK != null && b.this.jbK.bxD() && !b.this.jbM) {
                                        b.this.jbM = true;
                                        b.this.msR.a(b.this.msQ, b.this.jbK);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.fig.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.msR.a(this.msQ, this.jbK);
                }
                this.jbK.setBannerData(this.fig);
                this.jbK.reset();
                if (this.fig.getType() == 1 && !TextUtils.isEmpty(this.fig.bkN())) {
                    this.jbK.setData(this.mPageContext, this.fig.bkN());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDI() {
        if (this.jbK != null && this.msR != null) {
            this.jbM = false;
            this.msR.b(this.msQ, this.jbK);
            this.jbK = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDG() {
        if (this.fig != null) {
            String value = this.fig.getValue();
            String bkF = this.fig.bkF();
            if (this.fig.bkM() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                gb(bkF, value);
            } else if (this.fig.bkM() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = msS.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            gb(bkF, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.fig.bkM() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.eOe != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.eOe) {
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
                    r.dAo().dAl().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                    }
                }
                gb(bkF, value);
            } else if (this.fig.bkM() == 4) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                gb(bkF, value);
            }
        }
    }

    private void gb(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0853a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.gr(TiebaInitialize.Params.OBJ_URL, str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ro(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0853a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.gr(TiebaInitialize.Params.OBJ_URL, this.fig.bkN());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.jbK;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.jbK != null) {
            this.jbK.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.jbK != null) {
            this.jbK.bxE();
        }
    }
}
