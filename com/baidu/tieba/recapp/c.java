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
    private static final Pattern gLj = Pattern.compile("(/p/){1}(\\d+)");
    private v aSW;
    private BannerView dYI = null;
    private boolean dYJ = false;
    BannerView.a dYM = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Ko() {
            c.this.aFG();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Kp() {
            c.this.aFI();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c gLh;
    private a.InterfaceC0181a gLi;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.gLh = cVar;
        if (this.gLh != null && (this.gLh.TN() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.gLh.TN();
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
            this.aSW = (v) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0181a interfaceC0181a) {
        this.gLi = interfaceC0181a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void TI() {
        if (this.mPageContext != null && this.gLi != null) {
            if (this.aSW == null) {
                aFI();
            } else if (!this.aSW.isValid()) {
                aFI();
            } else {
                if (!this.dYJ) {
                    if (this.dYI == null) {
                        this.dYI = new BannerView(this.mPageContext.getPageActivity());
                        this.dYI.setVisibility(8);
                        this.dYI.setBannerViewClickListener(this.dYM);
                        this.dYI.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void s(String str, boolean z) {
                                if (z) {
                                    if (c.this.aSW != null && c.this.aSW.ark) {
                                        String yk = c.this.aSW.yk();
                                        if (!StringUtils.isNULL(yk)) {
                                            c.this.uw(yk);
                                        }
                                        c.this.aSW.ark = false;
                                    }
                                    if (c.this.dYI != null && c.this.dYI.Km() && !c.this.dYJ) {
                                        c.this.dYJ = true;
                                        c.this.gLi.a(c.this.gLh, c.this.dYI);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.aSW.getValue().startsWith("game:detail:")) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.gLi.a(this.gLh, this.dYI);
                }
                this.dYI.setBannerData(this.aSW);
                this.dYI.reset();
                if (this.aSW.getType() == 1 && !TextUtils.isEmpty(this.aSW.yu())) {
                    this.dYI.setData(this.mPageContext, this.aSW.yu());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFI() {
        if (this.dYI != null && this.gLi != null) {
            this.dYJ = false;
            this.gLi.b(this.gLh, this.dYI);
            this.dYI = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFG() {
        if (this.aSW != null) {
            String value = this.aSW.getValue();
            String yk = this.aSW.yk();
            if (this.aSW.yt() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                cx(yk, value);
            } else if (this.aSW.yt() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = gLj.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                            cx(yk, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aSW.yt() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.aDf != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.aDf) {
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
                    r.buz().buw().d(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", AiAppsUBCStatistic.TYPE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                cx(yk, value);
            } else if (this.aSW.yt() == 4) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                cx(yk, value);
            }
        }
    }

    private void cx(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0316a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.cM("obj_url", str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uw(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0316a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.cM("obj_url", this.aSW.yu());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.dYI;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.dYI != null) {
            this.dYI.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.dYI != null) {
            this.dYI.Kn();
        }
    }
}
