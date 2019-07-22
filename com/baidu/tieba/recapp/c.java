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
    private static final Pattern iFz = Pattern.compile("(/p/){1}(\\d+)");
    private x clS;
    private BannerView fKR = null;
    private boolean fKT = false;
    BannerView.a fKX = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aqf() {
            c.this.bqE();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aqg() {
            c.this.bqG();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c iFx;
    private a.InterfaceC0261a iFy;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.iFx = cVar;
        if (this.iFx != null && (this.iFx.aAB() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.iFx.aAB();
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
            this.clS = (x) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0261a interfaceC0261a) {
        this.iFy = interfaceC0261a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void aAw() {
        if (this.mPageContext != null && this.iFy != null) {
            if (this.clS == null) {
                bqG();
            } else if (!this.clS.isValid()) {
                bqG();
            } else {
                if (!this.fKT) {
                    if (this.fKR == null) {
                        this.fKR = new BannerView(this.mPageContext.getPageActivity());
                        this.fKR.setVisibility(8);
                        this.fKR.setBannerViewClickListener(this.fKX);
                        this.fKR.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void P(String str, boolean z) {
                                if (z) {
                                    if (c.this.clS != null && c.this.clS.bGU) {
                                        String acM = c.this.clS.acM();
                                        if (!StringUtils.isNULL(acM)) {
                                            c.this.DD(acM);
                                        }
                                        c.this.clS.bGU = false;
                                    }
                                    if (c.this.fKR != null && c.this.fKR.aqd() && !c.this.fKT) {
                                        c.this.fKT = true;
                                        c.this.iFy.a(c.this.iFx, c.this.fKR);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.clS.getValue().startsWith("game:detail:")) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.iFy.a(this.iFx, this.fKR);
                }
                this.fKR.setBannerData(this.clS);
                this.fKR.reset();
                if (this.clS.getType() == 1 && !TextUtils.isEmpty(this.clS.acW())) {
                    this.fKR.setData(this.mPageContext, this.clS.acW());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqG() {
        if (this.fKR != null && this.iFy != null) {
            this.fKT = false;
            this.iFy.b(this.iFx, this.fKR);
            this.fKR = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqE() {
        if (this.clS != null) {
            String value = this.clS.getValue();
            String acM = this.clS.acM();
            if (this.clS.acV() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                dX(acM, value);
            } else if (this.clS.acV() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = iFz.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                            dX(acM, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.clS.acV() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.bUv != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.bUv) {
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
                    r.chD().chA().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                dX(acM, value);
            } else if (this.clS.acV() == 4) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                dX(acM, value);
            }
        }
    }

    private void dX(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0408a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.en("obj_url", str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DD(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0408a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.en("obj_url", this.clS.acW());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.fKR;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.fKR != null) {
            this.fKR.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.fKR != null) {
            this.fKR.aqe();
        }
    }
}
