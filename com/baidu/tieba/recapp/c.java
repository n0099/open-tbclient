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
    private static final Pattern giT = Pattern.compile("(/p/){1}(\\d+)");
    private w aGa;
    private BannerView dws = null;
    private boolean dwt = false;
    BannerView.a dww = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Ft() {
            c.this.axQ();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Fu() {
            c.this.axS();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c giR;
    private a.InterfaceC0124a giS;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void J(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.giR = cVar;
        if (this.giR != null && (this.giR.Om() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.giR.Om();
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
            this.aGa = (w) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0124a interfaceC0124a) {
        this.giS = interfaceC0124a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void Oh() {
        if (this.mPageContext != null && this.giS != null) {
            if (this.aGa == null) {
                axS();
            } else if (!this.aGa.isValid()) {
                axS();
            } else {
                if (!this.dwt) {
                    if (this.dws == null) {
                        this.dws = new BannerView(this.mPageContext.getPageActivity());
                        this.dws.setVisibility(8);
                        this.dws.setBannerViewClickListener(this.dww);
                        this.dws.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void n(String str, boolean z) {
                                if (z) {
                                    if (c.this.aGa != null && c.this.aGa.afR) {
                                        String ue = c.this.aGa.ue();
                                        if (!StringUtils.isNULL(ue)) {
                                            c.this.sK(ue);
                                        }
                                        c.this.aGa.afR = false;
                                    }
                                    if (c.this.dws != null && c.this.dws.Fr() && !c.this.dwt) {
                                        c.this.dwt = true;
                                        c.this.giS.a(c.this.giR, c.this.dws);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.aGa.getValue().startsWith("game:detail:")) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.giS.a(this.giR, this.dws);
                }
                this.dws.setBannerData(this.aGa);
                this.dws.reset();
                if (this.aGa.getType() == 1 && !TextUtils.isEmpty(this.aGa.ud())) {
                    this.dws.setData(this.mPageContext, this.aGa.ud());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axS() {
        if (this.dws != null && this.giS != null) {
            this.dwt = false;
            this.giS.b(this.giR, this.dws);
            this.dws = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axQ() {
        if (this.aGa != null) {
            String value = this.aGa.getValue();
            String ue = this.aGa.ue();
            if (this.aGa.uc() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                bX(ue, value);
            } else if (this.aGa.uc() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = giT.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                            bX(ue, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aGa.uc() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.arA != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.arA) {
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
                    r.boj().bog().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                bX(ue, value);
            } else if (this.aGa.uc() == 4) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                bX(ue, value);
            }
        }
    }

    private void bX(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0234a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.cl("obj_url", str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sK(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0234a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.cl("obj_url", this.aGa.ud());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.dws;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.dws != null) {
            this.dws.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.dws != null) {
            this.dws.Fs();
        }
    }
}
