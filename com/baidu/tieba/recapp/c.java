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
import com.baidu.tbadk.core.data.w;
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
    private static final Pattern gmL = Pattern.compile("(/p/){1}(\\d+)");
    private w aGS;
    private BannerView dzE = null;
    private boolean dzF = false;
    BannerView.a dzI = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void FL() {
            c.this.ayv();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void FM() {
            c.this.ayx();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c gmJ;
    private a.InterfaceC0125a gmK;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void J(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.gmJ = cVar;
        if (this.gmJ != null && (this.gmJ.OF() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.gmJ.OF();
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
        if (obj instanceof w) {
            this.aGS = (w) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0125a interfaceC0125a) {
        this.gmK = interfaceC0125a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void OA() {
        if (this.mPageContext != null && this.gmK != null) {
            if (this.aGS == null) {
                ayx();
            } else if (!this.aGS.isValid()) {
                ayx();
            } else {
                if (!this.dzF) {
                    if (this.dzE == null) {
                        this.dzE = new BannerView(this.mPageContext.getPageActivity());
                        this.dzE.setVisibility(8);
                        this.dzE.setBannerViewClickListener(this.dzI);
                        this.dzE.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void n(String str, boolean z) {
                                if (z) {
                                    if (c.this.aGS != null && c.this.aGS.agh) {
                                        String uk = c.this.aGS.uk();
                                        if (!StringUtils.isNULL(uk)) {
                                            c.this.sJ(uk);
                                        }
                                        c.this.aGS.agh = false;
                                    }
                                    if (c.this.dzE != null && c.this.dzE.FJ() && !c.this.dzF) {
                                        c.this.dzF = true;
                                        c.this.gmK.a(c.this.gmJ, c.this.dzE);
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
                    this.gmK.a(this.gmJ, this.dzE);
                }
                this.dzE.setBannerData(this.aGS);
                this.dzE.reset();
                if (this.aGS.getType() == 1 && !TextUtils.isEmpty(this.aGS.uj())) {
                    this.dzE.setData(this.mPageContext, this.aGS.uj());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayx() {
        if (this.dzE != null && this.gmK != null) {
            this.dzF = false;
            this.gmK.b(this.gmJ, this.dzE);
            this.dzE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayv() {
        if (this.aGS != null) {
            String value = this.aGS.getValue();
            String uk = this.aGS.uk();
            if (this.aGS.ui() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                cb(uk, value);
            } else if (this.aGS.ui() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = gmL.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                            cb(uk, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aGS.ui() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.asd != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.asd) {
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
                    r.boJ().boG().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                cb(uk, value);
            } else if (this.aGS.ui() == 4) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                cb(uk, value);
            }
        }
    }

    private void cb(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.cp("obj_url", str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sJ(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.cp("obj_url", this.aGS.uj());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.dzE;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.dzE != null) {
            this.dzE.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.dzE != null) {
            this.dzE.FK();
        }
    }
}
