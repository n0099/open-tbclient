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
    private static final Pattern gPf = Pattern.compile("(/p/){1}(\\d+)");
    private v aTH;
    private BannerView ecg = null;
    private boolean ech = false;
    BannerView.a eck = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void KE() {
            c.this.aGS();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void KF() {
            c.this.aGU();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c gPd;
    private a.InterfaceC0181a gPe;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.gPd = cVar;
        if (this.gPd != null && (this.gPd.Ul() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.gPd.Ul();
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
            this.aTH = (v) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0181a interfaceC0181a) {
        this.gPe = interfaceC0181a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void Ug() {
        if (this.mPageContext != null && this.gPe != null) {
            if (this.aTH == null) {
                aGU();
            } else if (!this.aTH.isValid()) {
                aGU();
            } else {
                if (!this.ech) {
                    if (this.ecg == null) {
                        this.ecg = new BannerView(this.mPageContext.getPageActivity());
                        this.ecg.setVisibility(8);
                        this.ecg.setBannerViewClickListener(this.eck);
                        this.ecg.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void s(String str, boolean z) {
                                if (z) {
                                    if (c.this.aTH != null && c.this.aTH.arN) {
                                        String yx = c.this.aTH.yx();
                                        if (!StringUtils.isNULL(yx)) {
                                            c.this.uP(yx);
                                        }
                                        c.this.aTH.arN = false;
                                    }
                                    if (c.this.ecg != null && c.this.ecg.KC() && !c.this.ech) {
                                        c.this.ech = true;
                                        c.this.gPe.a(c.this.gPd, c.this.ecg);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.aTH.getValue().startsWith("game:detail:")) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.gPe.a(this.gPd, this.ecg);
                }
                this.ecg.setBannerData(this.aTH);
                this.ecg.reset();
                if (this.aTH.getType() == 1 && !TextUtils.isEmpty(this.aTH.yH())) {
                    this.ecg.setData(this.mPageContext, this.aTH.yH());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGU() {
        if (this.ecg != null && this.gPe != null) {
            this.ech = false;
            this.gPe.b(this.gPd, this.ecg);
            this.ecg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGS() {
        if (this.aTH != null) {
            String value = this.aTH.getValue();
            String yx = this.aTH.yx();
            if (this.aTH.yG() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                cy(yx, value);
            } else if (this.aTH.yG() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = gPf.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                            cy(yx, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aTH.yG() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.aDJ != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.aDJ) {
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
                    r.bvT().bvQ().d(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", AiAppsUBCStatistic.TYPE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                cy(yx, value);
            } else if (this.aTH.yG() == 4) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                cy(yx, value);
            }
        }
    }

    private void cy(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0316a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.cO("obj_url", str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uP(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0316a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.cO("obj_url", this.aTH.yH());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.ecg;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.ecg != null) {
            this.ecg.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.ecg != null) {
            this.ecg.KD();
        }
    }
}
