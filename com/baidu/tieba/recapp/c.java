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
    private static final Pattern izh = Pattern.compile("(/p/){1}(\\d+)");
    private x ckG;
    private BannerView fFT = null;
    private boolean fFV = false;
    BannerView.a fFZ = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aoZ() {
            c.this.boD();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void apa() {
            c.this.boF();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c izf;
    private a.InterfaceC0264a izg;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.izf = cVar;
        if (this.izf != null && (this.izf.azn() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.izf.azn();
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
            this.ckG = (x) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0264a interfaceC0264a) {
        this.izg = interfaceC0264a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void azi() {
        if (this.mPageContext != null && this.izg != null) {
            if (this.ckG == null) {
                boF();
            } else if (!this.ckG.isValid()) {
                boF();
            } else {
                if (!this.fFV) {
                    if (this.fFT == null) {
                        this.fFT = new BannerView(this.mPageContext.getPageActivity());
                        this.fFT.setVisibility(8);
                        this.fFT.setBannerViewClickListener(this.fFZ);
                        this.fFT.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void O(String str, boolean z) {
                                if (z) {
                                    if (c.this.ckG != null && c.this.ckG.bFT) {
                                        String abK = c.this.ckG.abK();
                                        if (!StringUtils.isNULL(abK)) {
                                            c.this.CQ(abK);
                                        }
                                        c.this.ckG.bFT = false;
                                    }
                                    if (c.this.fFT != null && c.this.fFT.aoX() && !c.this.fFV) {
                                        c.this.fFV = true;
                                        c.this.izg.a(c.this.izf, c.this.fFT);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.ckG.getValue().startsWith("game:detail:")) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.izg.a(this.izf, this.fFT);
                }
                this.fFT.setBannerData(this.ckG);
                this.fFT.reset();
                if (this.ckG.getType() == 1 && !TextUtils.isEmpty(this.ckG.abU())) {
                    this.fFT.setData(this.mPageContext, this.ckG.abU());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boF() {
        if (this.fFT != null && this.izg != null) {
            this.fFV = false;
            this.izg.b(this.izf, this.fFT);
            this.fFT = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boD() {
        if (this.ckG != null) {
            String value = this.ckG.getValue();
            String abK = this.ckG.abK();
            if (this.ckG.abT() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                dW(abK, value);
            } else if (this.ckG.abT() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = izh.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                            dW(abK, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.ckG.abT() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.bTu != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.bTu) {
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
                    r.ceM().ceJ().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                dW(abK, value);
            } else if (this.ckG.abT() == 4) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                dW(abK, value);
            }
        }
    }

    private void dW(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0409a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.em("obj_url", str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CQ(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0409a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.em("obj_url", this.ckG.abU());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.fFT;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.fFT != null) {
            this.fFT.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.fFT != null) {
            this.fFT.aoY();
        }
    }
}
