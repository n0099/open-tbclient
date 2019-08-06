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
/* loaded from: classes3.dex */
public class c implements com.baidu.tieba.InjectPlugin.FrsBannerAd.a {
    private static final Pattern iGD = Pattern.compile("(/p/){1}(\\d+)");
    private x clZ;
    private BannerView fLF = null;
    private boolean fLH = false;
    BannerView.a fLL = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aqh() {
            c.this.bqR();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aqi() {
            c.this.bqT();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c iGB;
    private a.InterfaceC0266a iGC;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.iGB = cVar;
        if (this.iGB != null && (this.iGB.aAD() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.iGB.aAD();
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
            this.clZ = (x) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0266a interfaceC0266a) {
        this.iGC = interfaceC0266a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void aAy() {
        if (this.mPageContext != null && this.iGC != null) {
            if (this.clZ == null) {
                bqT();
            } else if (!this.clZ.isValid()) {
                bqT();
            } else {
                if (!this.fLH) {
                    if (this.fLF == null) {
                        this.fLF = new BannerView(this.mPageContext.getPageActivity());
                        this.fLF.setVisibility(8);
                        this.fLF.setBannerViewClickListener(this.fLL);
                        this.fLF.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void P(String str, boolean z) {
                                if (z) {
                                    if (c.this.clZ != null && c.this.clZ.bGV) {
                                        String acN = c.this.clZ.acN();
                                        if (!StringUtils.isNULL(acN)) {
                                            c.this.DE(acN);
                                        }
                                        c.this.clZ.bGV = false;
                                    }
                                    if (c.this.fLF != null && c.this.fLF.aqf() && !c.this.fLH) {
                                        c.this.fLH = true;
                                        c.this.iGC.a(c.this.iGB, c.this.fLF);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.clZ.getValue().startsWith("game:detail:")) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.iGC.a(this.iGB, this.fLF);
                }
                this.fLF.setBannerData(this.clZ);
                this.fLF.reset();
                if (this.clZ.getType() == 1 && !TextUtils.isEmpty(this.clZ.acX())) {
                    this.fLF.setData(this.mPageContext, this.clZ.acX());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqT() {
        if (this.fLF != null && this.iGC != null) {
            this.fLH = false;
            this.iGC.b(this.iGB, this.fLF);
            this.fLF = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqR() {
        if (this.clZ != null) {
            String value = this.clZ.getValue();
            String acN = this.clZ.acN();
            if (this.clZ.acW() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                dX(acN, value);
            } else if (this.clZ.acW() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = iGD.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                            dX(acN, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.clZ.acW() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.bUB != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.bUB) {
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
                    r.chV().chS().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                dX(acN, value);
            } else if (this.clZ.acW() == 4) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                dX(acN, value);
            }
        }
    }

    private void dX(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0414a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.en("obj_url", str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DE(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0414a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.en("obj_url", this.clZ.acX());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.fLF;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.fLF != null) {
            this.fLF.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.fLF != null) {
            this.fLF.aqg();
        }
    }
}
