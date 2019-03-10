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
    private static final Pattern igL = Pattern.compile("(/p/){1}(\\d+)");
    private x ccy;
    private BannerView fpL = null;
    private boolean fpN = false;
    BannerView.a fpR = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void akc() {
            c.this.bhj();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void akd() {
            c.this.bhl();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c igJ;
    private a.InterfaceC0215a igK;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.igJ = cVar;
        if (this.igJ != null && (this.igJ.aul() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.igJ.aul();
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
            this.ccy = (x) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0215a interfaceC0215a) {
        this.igK = interfaceC0215a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void aug() {
        if (this.mPageContext != null && this.igK != null) {
            if (this.ccy == null) {
                bhl();
            } else if (!this.ccy.isValid()) {
                bhl();
            } else {
                if (!this.fpN) {
                    if (this.fpL == null) {
                        this.fpL = new BannerView(this.mPageContext.getPageActivity());
                        this.fpL.setVisibility(8);
                        this.fpL.setBannerViewClickListener(this.fpR);
                        this.fpL.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void L(String str, boolean z) {
                                if (z) {
                                    if (c.this.ccy != null && c.this.ccy.byB) {
                                        String Xq = c.this.ccy.Xq();
                                        if (!StringUtils.isNULL(Xq)) {
                                            c.this.Bv(Xq);
                                        }
                                        c.this.ccy.byB = false;
                                    }
                                    if (c.this.fpL != null && c.this.fpL.aka() && !c.this.fpN) {
                                        c.this.fpN = true;
                                        c.this.igK.a(c.this.igJ, c.this.fpL);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.ccy.getValue().startsWith("game:detail:")) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.igK.a(this.igJ, this.fpL);
                }
                this.fpL.setBannerData(this.ccy);
                this.fpL.reset();
                if (this.ccy.getType() == 1 && !TextUtils.isEmpty(this.ccy.Xp())) {
                    this.fpL.setData(this.mPageContext, this.ccy.Xp());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhl() {
        if (this.fpL != null && this.igK != null) {
            this.fpN = false;
            this.igK.b(this.igJ, this.fpL);
            this.fpL = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhj() {
        if (this.ccy != null) {
            String value = this.ccy.getValue();
            String Xq = this.ccy.Xq();
            if (this.ccy.Xo() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                dI(Xq, value);
            } else if (this.ccy.Xo() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = igL.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                            dI(Xq, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.ccy.Xo() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.bLE != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.bLE) {
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
                    r.bWH().bWE().d(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                dI(Xq, value);
            } else if (this.ccy.Xo() == 4) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                dI(Xq, value);
            }
        }
    }

    private void dI(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0309a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.dY("obj_url", str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bv(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0309a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.dY("obj_url", this.ccy.Xp());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.fpL;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.fpL != null) {
            this.fpL.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.fpL != null) {
            this.fpL.akb();
        }
    }
}
