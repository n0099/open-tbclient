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
    private static final Pattern gBK = Pattern.compile("(/p/){1}(\\d+)");
    private v bmb;
    private BannerView dRV = null;
    private boolean dRW = false;
    BannerView.a dRZ = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Jc() {
            c.this.ayO();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Jd() {
            c.this.ayQ();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c gBI;
    private a.InterfaceC0119a gBJ;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void aL(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.gBI = cVar;
        if (this.gBI != null && (this.gBI.Sr() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.gBI.Sr();
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
            this.bmb = (v) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0119a interfaceC0119a) {
        this.gBJ = interfaceC0119a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void Sm() {
        if (this.mPageContext != null && this.gBJ != null) {
            if (this.bmb == null) {
                ayQ();
            } else if (!this.bmb.isValid()) {
                ayQ();
            } else {
                if (!this.dRW) {
                    if (this.dRV == null) {
                        this.dRV = new BannerView(this.mPageContext.getPageActivity());
                        this.dRV.setVisibility(8);
                        this.dRV.setBannerViewClickListener(this.dRZ);
                        this.dRV.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void q(String str, boolean z) {
                                if (z) {
                                    if (c.this.bmb != null && c.this.bmb.aME) {
                                        String yd = c.this.bmb.yd();
                                        if (!StringUtils.isNULL(yd)) {
                                            c.this.rJ(yd);
                                        }
                                        c.this.bmb.aME = false;
                                    }
                                    if (c.this.dRV != null && c.this.dRV.Ja() && !c.this.dRW) {
                                        c.this.dRW = true;
                                        c.this.gBJ.a(c.this.gBI, c.this.dRV);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.bmb.getValue().startsWith("game:detail:")) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.gBJ.a(this.gBI, this.dRV);
                }
                this.dRV.setBannerData(this.bmb);
                this.dRV.reset();
                if (this.bmb.getType() == 1 && !TextUtils.isEmpty(this.bmb.yc())) {
                    this.dRV.b(this.mPageContext, this.bmb.yc());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayQ() {
        if (this.dRV != null && this.gBJ != null) {
            this.dRW = false;
            this.gBJ.b(this.gBI, this.dRV);
            this.dRV = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayO() {
        if (this.bmb != null) {
            String value = this.bmb.getValue();
            String yd = this.bmb.yd();
            if (this.bmb.yb() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                bQ(yd, value);
            } else if (this.bmb.yb() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = gBK.matcher(value);
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
            } else if (this.bmb.yb() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.aXY != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.aXY) {
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
                    r.bof().boc().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                bQ(yd, value);
            } else if (this.bmb.yb() == 4) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                bQ(yd, value);
            }
        }
    }

    private void bQ(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0235a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.ce("obj_url", str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rJ(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0235a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.ce("obj_url", this.bmb.yc());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.dRV;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.dRV != null) {
            this.dRV.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.dRV != null) {
            this.dRV.Jb();
        }
    }
}
