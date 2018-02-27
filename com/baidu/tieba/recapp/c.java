package com.baidu.tieba.recapp;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
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
    private static final Pattern gBv = Pattern.compile("(/p/){1}(\\d+)");
    private v blO;
    private BannerView dRJ = null;
    private boolean dRK = false;
    BannerView.a dRN = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Jb() {
            c.this.ayN();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Jc() {
            c.this.ayP();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c gBt;
    private a.InterfaceC0120a gBu;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void aL(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.gBt = cVar;
        if (this.gBt != null && (this.gBt.Sq() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.gBt.Sq();
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
            this.blO = (v) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0120a interfaceC0120a) {
        this.gBu = interfaceC0120a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void Sl() {
        if (this.mPageContext != null && this.gBu != null) {
            if (this.blO == null) {
                ayP();
            } else if (!this.blO.isValid()) {
                ayP();
            } else {
                if (!this.dRK) {
                    if (this.dRJ == null) {
                        this.dRJ = new BannerView(this.mPageContext.getPageActivity());
                        this.dRJ.setVisibility(8);
                        this.dRJ.setBannerViewClickListener(this.dRN);
                        this.dRJ.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void p(String str, boolean z) {
                                if (z) {
                                    if (c.this.blO != null && c.this.blO.aMt) {
                                        String yd = c.this.blO.yd();
                                        if (!StringUtils.isNULL(yd)) {
                                            c.this.rJ(yd);
                                        }
                                        c.this.blO.aMt = false;
                                    }
                                    if (c.this.dRJ != null && c.this.dRJ.IZ() && !c.this.dRK) {
                                        c.this.dRK = true;
                                        c.this.gBu.a(c.this.gBt, c.this.dRJ);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.blO.getValue().startsWith("game:detail:")) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.gBu.a(this.gBt, this.dRJ);
                }
                this.dRJ.setBannerData(this.blO);
                this.dRJ.reset();
                if (this.blO.getType() == 1 && !TextUtils.isEmpty(this.blO.yc())) {
                    this.dRJ.b(this.mPageContext, this.blO.yc());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayP() {
        if (this.dRJ != null && this.gBu != null) {
            this.dRK = false;
            this.gBu.b(this.gBt, this.dRJ);
            this.dRJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayN() {
        if (this.blO != null) {
            String value = this.blO.getValue();
            String yd = this.blO.yd();
            if (this.blO.yb() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                bQ(yd, value);
            } else if (this.blO.yb() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = gBv.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                            bQ(yd, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.blO.yb() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.aXM != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.aXM) {
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
                    r.boe().bob().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                bQ(yd, value);
            } else if (this.blO.yb() == 4) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                bQ(yd, value);
            }
        }
    }

    private void bQ(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.ce("obj_url", str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rJ(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.ce("obj_url", this.blO.yc());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.dRJ;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.dRJ != null) {
            this.dRJ.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.dRJ != null) {
            this.dRJ.Ja();
        }
    }
}
