package com.baidu.tieba.recapp;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.views.SmsLoginView;
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
    private static final Pattern gnY = Pattern.compile("(/p/){1}(\\d+)");
    private v aGR;
    private BannerView dCn = null;
    private boolean dCo = false;
    BannerView.a dCr = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void FH() {
            c.this.ayY();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void FI() {
            c.this.aza();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c gnW;
    private a.InterfaceC0123a gnX;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void J(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.gnW = cVar;
        if (this.gnW != null && (this.gnW.OK() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.gnW.OK();
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
            this.aGR = (v) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0123a interfaceC0123a) {
        this.gnX = interfaceC0123a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void OF() {
        if (this.mPageContext != null && this.gnX != null) {
            if (this.aGR == null) {
                aza();
            } else if (!this.aGR.isValid()) {
                aza();
            } else {
                if (!this.dCo) {
                    if (this.dCn == null) {
                        this.dCn = new BannerView(this.mPageContext.getPageActivity());
                        this.dCn.setVisibility(8);
                        this.dCn.setBannerViewClickListener(this.dCr);
                        this.dCn.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void m(String str, boolean z) {
                                if (z) {
                                    if (c.this.aGR != null && c.this.aGR.afA) {
                                        String tW = c.this.aGR.tW();
                                        if (!StringUtils.isNULL(tW)) {
                                            c.this.sI(tW);
                                        }
                                        c.this.aGR.afA = false;
                                    }
                                    if (c.this.dCn != null && c.this.dCn.FF() && !c.this.dCo) {
                                        c.this.dCo = true;
                                        c.this.gnX.a(c.this.gnW, c.this.dCn);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.aGR.getValue().startsWith("game:detail:")) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.gnX.a(this.gnW, this.dCn);
                }
                this.dCn.setBannerData(this.aGR);
                this.dCn.reset();
                if (this.aGR.getType() == 1 && !TextUtils.isEmpty(this.aGR.tV())) {
                    this.dCn.setData(this.mPageContext, this.aGR.tV());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aza() {
        if (this.dCn != null && this.gnX != null) {
            this.dCo = false;
            this.gnX.b(this.gnW, this.dCn);
            this.dCn = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayY() {
        if (this.aGR != null) {
            String value = this.aGR.getValue();
            String tW = this.aGR.tW();
            if (this.aGR.tU() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                bX(tW, value);
            } else if (this.aGR.tU() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = gnY.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                            bX(tW, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aGR.tU() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.arH != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.arH) {
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
                    r.bno().bnl().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                bX(tW, value);
            } else if (this.aGR.tU() == 4) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                bX(tW, value);
            }
        }
    }

    private void bX(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.cm("obj_url", str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sI(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.cm("obj_url", this.aGR.tV());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.dCn;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.dCn != null) {
            this.dCn.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.dCn != null) {
            this.dCn.FG();
        }
    }
}
