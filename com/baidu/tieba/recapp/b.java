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
/* loaded from: classes25.dex */
public class b implements com.baidu.tieba.InjectPlugin.FrsBannerAd.a {
    private static final Pattern mtk = Pattern.compile("(/p/){1}(\\d+)");
    private ae fhn;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private com.baidu.tieba.InjectPlugin.a.c mti;
    private a.InterfaceC0605a mtj;
    private BannerView jcw = null;
    private boolean jcy = false;
    BannerView.a jcC = new BannerView.a() { // from class: com.baidu.tieba.recapp.b.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bwV() {
            b.this.cDk();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bwW() {
            b.this.cDm();
        }
    };

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.mti = cVar;
        if (this.mti != null && (this.mti.bGZ() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.mti.bGZ();
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
            this.fhn = (ae) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0605a interfaceC0605a) {
        this.mtj = interfaceC0605a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void bGU() {
        if (this.mPageContext != null && this.mtj != null) {
            if (this.fhn == null) {
                cDm();
            } else if (!this.fhn.isValid()) {
                cDm();
            } else {
                if (!this.jcy) {
                    if (this.jcw == null) {
                        this.jcw = new BannerView(this.mPageContext.getPageActivity());
                        this.jcw.setVisibility(8);
                        this.jcw.setBannerViewClickListener(this.jcC);
                        this.jcw.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.b.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onComplete(String str, boolean z) {
                                if (z) {
                                    if (b.this.fhn != null && b.this.fhn.ezr) {
                                        String bjH = b.this.fhn.bjH();
                                        if (!StringUtils.isNULL(bjH)) {
                                            b.this.QJ(bjH);
                                        }
                                        b.this.fhn.ezr = false;
                                    }
                                    if (b.this.jcw != null && b.this.jcw.bwT() && !b.this.jcy) {
                                        b.this.jcy = true;
                                        b.this.mtj.a(b.this.mti, b.this.jcw);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.fhn.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.mtj.a(this.mti, this.jcw);
                }
                this.jcw.setBannerData(this.fhn);
                this.jcw.reset();
                if (this.fhn.getType() == 1 && !TextUtils.isEmpty(this.fhn.bjP())) {
                    this.jcw.setData(this.mPageContext, this.fhn.bjP());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDm() {
        if (this.jcw != null && this.mtj != null) {
            this.jcy = false;
            this.mtj.b(this.mti, this.jcw);
            this.jcw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDk() {
        if (this.fhn != null) {
            String value = this.fhn.getValue();
            String bjH = this.fhn.bjH();
            if (this.fhn.bjO() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                gb(bjH, value);
            } else if (this.fhn.bjO() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = mtk.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            gb(bjH, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.fhn.bjO() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.eNi != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.eNi) {
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
                    q.dzO().dzL().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                    }
                }
                gb(bjH, value);
            } else if (this.fhn.bjO() == 4) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                gb(bjH, value);
            }
        }
    }

    private void gb(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0855a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.gr(TiebaInitialize.Params.OBJ_URL, str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QJ(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0855a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.gr(TiebaInitialize.Params.OBJ_URL, this.fhn.bjP());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.jcw;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.jcw != null) {
            this.jcw.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.jcw != null) {
            this.jcw.bwU();
        }
    }
}
