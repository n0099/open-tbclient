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
    private static final Pattern gnV = Pattern.compile("(/p/){1}(\\d+)");
    private v aGS;
    private BannerView dCq = null;
    private boolean dCr = false;
    BannerView.a dCu = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void FH() {
            c.this.aza();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void FI() {
            c.this.azc();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c gnT;
    private a.InterfaceC0123a gnU;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void J(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.gnT = cVar;
        if (this.gnT != null && (this.gnT.OL() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.gnT.OL();
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
            this.aGS = (v) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0123a interfaceC0123a) {
        this.gnU = interfaceC0123a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void OG() {
        if (this.mPageContext != null && this.gnU != null) {
            if (this.aGS == null) {
                azc();
            } else if (!this.aGS.isValid()) {
                azc();
            } else {
                if (!this.dCr) {
                    if (this.dCq == null) {
                        this.dCq = new BannerView(this.mPageContext.getPageActivity());
                        this.dCq.setVisibility(8);
                        this.dCq.setBannerViewClickListener(this.dCu);
                        this.dCq.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void m(String str, boolean z) {
                                if (z) {
                                    if (c.this.aGS != null && c.this.aGS.afA) {
                                        String tX = c.this.aGS.tX();
                                        if (!StringUtils.isNULL(tX)) {
                                            c.this.sE(tX);
                                        }
                                        c.this.aGS.afA = false;
                                    }
                                    if (c.this.dCq != null && c.this.dCq.FF() && !c.this.dCr) {
                                        c.this.dCr = true;
                                        c.this.gnU.a(c.this.gnT, c.this.dCq);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.aGS.getValue().startsWith("game:detail:")) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.gnU.a(this.gnT, this.dCq);
                }
                this.dCq.setBannerData(this.aGS);
                this.dCq.reset();
                if (this.aGS.getType() == 1 && !TextUtils.isEmpty(this.aGS.tW())) {
                    this.dCq.setData(this.mPageContext, this.aGS.tW());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azc() {
        if (this.dCq != null && this.gnU != null) {
            this.dCr = false;
            this.gnU.b(this.gnT, this.dCq);
            this.dCq = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aza() {
        if (this.aGS != null) {
            String value = this.aGS.getValue();
            String tX = this.aGS.tX();
            if (this.aGS.tV() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                bX(tX, value);
            } else if (this.aGS.tV() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = gnV.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                            bX(tX, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aGS.tV() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.arG != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.arG) {
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
                    r.bnn().bnk().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                bX(tX, value);
            } else if (this.aGS.tV() == 4) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                bX(tX, value);
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
    public void sE(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.cm("obj_url", this.aGS.tW());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.dCq;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.dCq != null) {
            this.dCq.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.dCq != null) {
            this.dCq.FG();
        }
    }
}
