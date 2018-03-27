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
    private static final Pattern gBL = Pattern.compile("(/p/){1}(\\d+)");
    private v blR;
    private BannerView dRO = null;
    private boolean dRP = false;
    BannerView.a dRS = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Jc() {
            c.this.ayP();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Jd() {
            c.this.ayR();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c gBJ;
    private a.InterfaceC0120a gBK;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void aL(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.gBJ = cVar;
        if (this.gBJ != null && (this.gBJ.Sr() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.gBJ.Sr();
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
            this.blR = (v) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0120a interfaceC0120a) {
        this.gBK = interfaceC0120a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void Sm() {
        if (this.mPageContext != null && this.gBK != null) {
            if (this.blR == null) {
                ayR();
            } else if (!this.blR.isValid()) {
                ayR();
            } else {
                if (!this.dRP) {
                    if (this.dRO == null) {
                        this.dRO = new BannerView(this.mPageContext.getPageActivity());
                        this.dRO.setVisibility(8);
                        this.dRO.setBannerViewClickListener(this.dRS);
                        this.dRO.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void p(String str, boolean z) {
                                if (z) {
                                    if (c.this.blR != null && c.this.blR.aMu) {
                                        String yd = c.this.blR.yd();
                                        if (!StringUtils.isNULL(yd)) {
                                            c.this.rJ(yd);
                                        }
                                        c.this.blR.aMu = false;
                                    }
                                    if (c.this.dRO != null && c.this.dRO.Ja() && !c.this.dRP) {
                                        c.this.dRP = true;
                                        c.this.gBK.a(c.this.gBJ, c.this.dRO);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.blR.getValue().startsWith("game:detail:")) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.gBK.a(this.gBJ, this.dRO);
                }
                this.dRO.setBannerData(this.blR);
                this.dRO.reset();
                if (this.blR.getType() == 1 && !TextUtils.isEmpty(this.blR.yc())) {
                    this.dRO.b(this.mPageContext, this.blR.yc());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayR() {
        if (this.dRO != null && this.gBK != null) {
            this.dRP = false;
            this.gBK.b(this.gBJ, this.dRO);
            this.dRO = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayP() {
        if (this.blR != null) {
            String value = this.blR.getValue();
            String yd = this.blR.yd();
            if (this.blR.yb() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                bQ(yd, value);
            } else if (this.blR.yb() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = gBL.matcher(value);
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
            } else if (this.blR.yb() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.aXO != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.aXO) {
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
            } else if (this.blR.yb() == 4) {
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
            b.ce("obj_url", this.blR.yc());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.dRO;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.dRO != null) {
            this.dRO.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.dRO != null) {
            this.dRO.Jb();
        }
    }
}
