package com.baidu.tieba.recapp;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
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
    private static final Pattern gOa = Pattern.compile("(/p/){1}(\\d+)");
    private v aSY;
    private com.baidu.tieba.InjectPlugin.a.c gNY;
    private a.InterfaceC0181a gNZ;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private BannerView ebz = null;
    private boolean ebA = false;
    BannerView.a ebD = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Kp() {
            c.this.aGv();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void Kq() {
            c.this.aGx();
        }
    };

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.gNY = cVar;
        if (this.gNY != null && (this.gNY.TP() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.gNY.TP();
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
            this.aSY = (v) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0181a interfaceC0181a) {
        this.gNZ = interfaceC0181a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void TK() {
        if (this.mPageContext != null && this.gNZ != null) {
            if (this.aSY == null) {
                aGx();
            } else if (!this.aSY.isValid()) {
                aGx();
            } else {
                if (!this.ebA) {
                    if (this.ebz == null) {
                        this.ebz = new BannerView(this.mPageContext.getPageActivity());
                        this.ebz.setVisibility(8);
                        this.ebz.setBannerViewClickListener(this.ebD);
                        this.ebz.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void s(String str, boolean z) {
                                if (z) {
                                    if (c.this.aSY != null && c.this.aSY.ark) {
                                        String yk = c.this.aSY.yk();
                                        if (!StringUtils.isNULL(yk)) {
                                            c.this.uz(yk);
                                        }
                                        c.this.aSY.ark = false;
                                    }
                                    if (c.this.ebz != null && c.this.ebz.Kn() && !c.this.ebA) {
                                        c.this.ebA = true;
                                        c.this.gNZ.a(c.this.gNY, c.this.ebz);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.aSY.getValue().startsWith("game:detail:")) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.gNZ.a(this.gNY, this.ebz);
                }
                this.ebz.setBannerData(this.aSY);
                this.ebz.reset();
                if (this.aSY.getType() == 1 && !TextUtils.isEmpty(this.aSY.yu())) {
                    this.ebz.setData(this.mPageContext, this.aSY.yu());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGx() {
        if (this.ebz != null && this.gNZ != null) {
            this.ebA = false;
            this.gNZ.b(this.gNY, this.ebz);
            this.ebz = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGv() {
        if (this.aSY != null) {
            String value = this.aSY.getValue();
            String yk = this.aSY.yk();
            if (this.aSY.yt() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                cx(yk, value);
            } else if (this.aSY.yt() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = gOa.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                            cx(yk, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aSY.yt() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.aDg != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.aDg) {
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
                    r.bvk().bvh().d(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", AiAppsUBCStatistic.TYPE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                cx(yk, value);
            } else if (this.aSY.yt() == 4) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                cx(yk, value);
            }
        }
    }

    private void cx(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0316a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.cM("obj_url", str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uz(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0316a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.cM("obj_url", this.aSY.yu());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.ebz;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.ebz != null) {
            this.ebz.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.ebz != null) {
            this.ebz.Ko();
        }
    }
}
