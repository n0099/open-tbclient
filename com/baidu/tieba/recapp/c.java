package com.baidu.tieba.recapp;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.InjectPlugin.FrsBannerAd.a;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class c implements com.baidu.tieba.InjectPlugin.FrsBannerAd.a {
    private static final Pattern gEt = Pattern.compile("(/p/){1}(\\d+)");
    private v aPx;
    private BannerView dSg = null;
    private boolean dSh = false;
    BannerView.a dSk = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Jk() {
            c.this.aDU();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Jl() {
            c.this.aDW();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c gEr;
    private a.InterfaceC0171a gEs;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.gEr = cVar;
        if (this.gEr != null && (this.gEr.SH() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.gEr.SH();
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
        if (obj instanceof v) {
            this.aPx = (v) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0171a interfaceC0171a) {
        this.gEs = interfaceC0171a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void SC() {
        if (this.mPageContext != null && this.gEs != null) {
            if (this.aPx == null) {
                aDW();
            } else if (!this.aPx.isValid()) {
                aDW();
            } else {
                if (!this.dSh) {
                    if (this.dSg == null) {
                        this.dSg = new BannerView(this.mPageContext.getPageActivity());
                        this.dSg.setVisibility(8);
                        this.dSg.setBannerViewClickListener(this.dSk);
                        this.dSg.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void r(String str, boolean z) {
                                if (z) {
                                    if (c.this.aPx != null && c.this.aPx.anJ) {
                                        String xq = c.this.aPx.xq();
                                        if (!StringUtils.isNULL(xq)) {
                                            c.this.tV(xq);
                                        }
                                        c.this.aPx.anJ = false;
                                    }
                                    if (c.this.dSg != null && c.this.dSg.Ji() && !c.this.dSh) {
                                        c.this.dSh = true;
                                        c.this.gEs.a(c.this.gEr, c.this.dSg);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.aPx.getValue().startsWith("game:detail:")) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.gEs.a(this.gEr, this.dSg);
                }
                this.dSg.setBannerData(this.aPx);
                this.dSg.reset();
                if (this.aPx.getType() == 1 && !TextUtils.isEmpty(this.aPx.xp())) {
                    this.dSg.setData(this.mPageContext, this.aPx.xp());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDW() {
        if (this.dSg != null && this.gEs != null) {
            this.dSh = false;
            this.gEs.b(this.gEr, this.dSg);
            this.dSg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDU() {
        if (this.aPx != null) {
            String value = this.aPx.getValue();
            String xq = this.aPx.xq();
            if (this.aPx.xo() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                cs(xq, value);
            } else if (this.aPx.xo() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = gEt.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                            cs(xq, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aPx.xo() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.azF != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.azF) {
                        case FRS:
                            this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            break;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            break;
                    }
                } else {
                    r.bsG().bsD().d(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", AiAppsUBCStatistic.TYPE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                cs(xq, value);
            } else if (this.aPx.xo() == 4) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                cs(xq, value);
            }
        }
    }

    private void cs(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0305a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.cH("obj_url", str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tV(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0305a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.cH("obj_url", this.aPx.xp());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.dSg;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.dSg != null) {
            this.dSg.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.dSg != null) {
            this.dSg.Jj();
        }
    }
}
