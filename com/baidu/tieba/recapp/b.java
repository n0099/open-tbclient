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
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.InjectPlugin.FrsBannerAd.a;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes13.dex */
public class b implements com.baidu.tieba.InjectPlugin.FrsBannerAd.a {
    private static final Pattern krj = Pattern.compile("(/p/){1}(\\d+)");
    private y dRD;
    private BannerView hpY = null;
    private boolean hqa = false;
    BannerView.a hqd = new BannerView.a() { // from class: com.baidu.tieba.recapp.b.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aVe() {
            b.this.bTq();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aVf() {
            b.this.bTs();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c krh;
    private a.InterfaceC0433a kri;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.krh = cVar;
        if (this.krh != null && (this.krh.bdP() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.krh.bdP();
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
        if (obj instanceof y) {
            this.dRD = (y) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0433a interfaceC0433a) {
        this.kri = interfaceC0433a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void bdK() {
        if (this.mPageContext != null && this.kri != null) {
            if (this.dRD == null) {
                bTs();
            } else if (!this.dRD.isValid()) {
                bTs();
            } else {
                if (!this.hqa) {
                    if (this.hpY == null) {
                        this.hpY = new BannerView(this.mPageContext.getPageActivity());
                        this.hpY.setVisibility(8);
                        this.hpY.setBannerViewClickListener(this.hqd);
                        this.hpY.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.b.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onComplete(String str, boolean z) {
                                if (z) {
                                    if (b.this.dRD != null && b.this.dRD.doo) {
                                        String aIO = b.this.dRD.aIO();
                                        if (!StringUtils.isNULL(aIO)) {
                                            b.this.Jo(aIO);
                                        }
                                        b.this.dRD.doo = false;
                                    }
                                    if (b.this.hpY != null && b.this.hpY.aVc() && !b.this.hqa) {
                                        b.this.hqa = true;
                                        b.this.kri.a(b.this.krh, b.this.hpY);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.dRD.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.kri.a(this.krh, this.hpY);
                }
                this.hpY.setBannerData(this.dRD);
                this.hpY.reset();
                if (this.dRD.getType() == 1 && !TextUtils.isEmpty(this.dRD.aIY())) {
                    this.hpY.setData(this.mPageContext, this.dRD.aIY());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTs() {
        if (this.hpY != null && this.kri != null) {
            this.hqa = false;
            this.kri.b(this.krh, this.hpY);
            this.hpY = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTq() {
        if (this.dRD != null) {
            String value = this.dRD.getValue();
            String aIO = this.dRD.aIO();
            if (this.dRD.aIX() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                eB(aIO, value);
            } else if (this.dRD.aIX() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = krj.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            eB(aIO, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.dRD.aIX() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.dAj != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.dAj) {
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
                    q.cNo().cNl().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                    }
                }
                eB(aIO, value);
            } else if (this.dRD.aIX() == 4) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                eB(aIO, value);
            }
        }
    }

    private void eB(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0654a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.eR(TiebaInitialize.Params.OBJ_URL, str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jo(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0654a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.eR(TiebaInitialize.Params.OBJ_URL, this.dRD.aIY());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.hpY;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.hpY != null) {
            this.hpY.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.hpY != null) {
            this.hpY.aVd();
        }
    }
}
