package com.baidu.tieba.recapp;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.InjectPlugin.FrsBannerAd.a;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class c implements com.baidu.tieba.InjectPlugin.FrsBannerAd.a {
    private static final Pattern mMJ = Pattern.compile("(/p/){1}(\\d+)");
    private ae fyw;
    private String mForumId;
    private String mForumName;
    private com.baidu.tieba.InjectPlugin.a.c mMH;
    private a.InterfaceC0609a mMI;
    private TbPageContext mPageContext;
    private BannerView jCy = null;
    private boolean jCA = false;
    BannerView.a jCE = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bCP() {
            c.this.cLy();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bCQ() {
            c.this.cLA();
        }
    };

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.mMH = cVar;
        if (this.mMH != null && (this.mMH.bMR() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.mMH.bMR();
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
        if (obj instanceof ae) {
            this.fyw = (ae) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0609a interfaceC0609a) {
        this.mMI = interfaceC0609a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void bMM() {
        if (this.mPageContext != null && this.mMI != null) {
            if (this.fyw == null) {
                cLA();
            } else if (!this.fyw.isValid()) {
                cLA();
            } else {
                if (!this.jCA) {
                    if (this.jCy == null) {
                        this.jCy = new BannerView(this.mPageContext.getPageActivity());
                        this.jCy.setVisibility(8);
                        this.jCy.setBannerViewClickListener(this.jCE);
                        this.jCy.setBannerViewEvent(new TbImageView.b() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.b
                            public void onComplete(String str, boolean z) {
                                if (z) {
                                    if (c.this.fyw != null && c.this.fyw.eQg) {
                                        String bpt = c.this.fyw.bpt();
                                        if (!StringUtils.isNULL(bpt)) {
                                            c.this.Ry(bpt);
                                        }
                                        c.this.fyw.eQg = false;
                                    }
                                    if (c.this.jCy != null && c.this.jCy.bCN() && !c.this.jCA) {
                                        c.this.jCA = true;
                                        c.this.mMI.a(c.this.mMH, c.this.jCy);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.b
                            public void onCancel() {
                            }
                        });
                        if (this.fyw.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.mMI.a(this.mMH, this.jCy);
                }
                this.jCy.setBannerData(this.fyw);
                this.jCy.reset();
                if (this.fyw.getType() == 1 && !TextUtils.isEmpty(this.fyw.bpB())) {
                    this.jCy.setData(this.mPageContext, this.fyw.bpB());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLA() {
        if (this.jCy != null && this.mMI != null) {
            this.jCA = false;
            this.mMI.b(this.mMH, this.jCy);
            this.jCy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLy() {
        if (this.fyw != null) {
            String value = this.fyw.getValue();
            String bpt = this.fyw.bpt();
            if (this.fyw.bpA() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                gd(bpt, value);
            } else if (this.fyw.bpA() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = mMJ.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            gd(bpt, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.fyw.bpA() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.fdR != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.fdR) {
                        case FRS:
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            break;
                        case PB:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            break;
                    }
                } else {
                    r.dEV().dES().a(this.mPageContext.getPageActivity(), new String[]{value}, null);
                    if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                    }
                }
                gd(bpt, value);
            } else if (this.fyw.bpA() == 4) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                gd(bpt, value);
            }
        }
    }

    private void gd(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0853a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b2.gt(TiebaInitialize.Params.OBJ_URL, str2);
            b2.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ry(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0853a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b2.gt(TiebaInitialize.Params.OBJ_URL, this.fyw.bpB());
            b2.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.jCy;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.jCy != null) {
            this.jCy.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.jCy != null) {
            this.jCy.bCO();
        }
    }
}
