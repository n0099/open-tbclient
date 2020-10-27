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
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.InjectPlugin.FrsBannerAd.a;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes26.dex */
public class b implements com.baidu.tieba.InjectPlugin.FrsBannerAd.a {
    private static final Pattern mmU = Pattern.compile("(/p/){1}(\\d+)");
    private ad fco;
    private BannerView iVN = null;
    private boolean iVP = false;
    BannerView.a iVS = new BannerView.a() { // from class: com.baidu.tieba.recapp.b.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bvg() {
            b.this.cBf();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bvh() {
            b.this.cBh();
        }
    };
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private com.baidu.tieba.InjectPlugin.a.c mmS;
    private a.InterfaceC0594a mmT;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.mmS = cVar;
        if (this.mmS != null && (this.mmS.bFh() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.mmS.bFh();
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
        if (obj instanceof ad) {
            this.fco = (ad) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0594a interfaceC0594a) {
        this.mmT = interfaceC0594a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void bFc() {
        if (this.mPageContext != null && this.mmT != null) {
            if (this.fco == null) {
                cBh();
            } else if (!this.fco.isValid()) {
                cBh();
            } else {
                if (!this.iVP) {
                    if (this.iVN == null) {
                        this.iVN = new BannerView(this.mPageContext.getPageActivity());
                        this.iVN.setVisibility(8);
                        this.iVN.setBannerViewClickListener(this.iVS);
                        this.iVN.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.b.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onComplete(String str, boolean z) {
                                if (z) {
                                    if (b.this.fco != null && b.this.fco.evh) {
                                        String bif = b.this.fco.bif();
                                        if (!StringUtils.isNULL(bif)) {
                                            b.this.QX(bif);
                                        }
                                        b.this.fco.evh = false;
                                    }
                                    if (b.this.iVN != null && b.this.iVN.bve() && !b.this.iVP) {
                                        b.this.iVP = true;
                                        b.this.mmT.a(b.this.mmS, b.this.iVN);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.fco.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.mmT.a(this.mmS, this.iVN);
                }
                this.iVN.setBannerData(this.fco);
                this.iVN.reset();
                if (this.fco.getType() == 1 && !TextUtils.isEmpty(this.fco.bin())) {
                    this.iVN.setData(this.mPageContext, this.fco.bin());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBh() {
        if (this.iVN != null && this.mmT != null) {
            this.iVP = false;
            this.mmT.b(this.mmS, this.iVN);
            this.iVN = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBf() {
        if (this.fco != null) {
            String value = this.fco.getValue();
            String bif = this.fco.bif();
            if (this.fco.bim() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                gb(bif, value);
            } else if (this.fco.bim() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = mmU.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            gb(bif, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.fco.bim() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.eIp != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.eIp) {
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
                    r.dxM().dxJ().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                    }
                }
                gb(bif, value);
            } else if (this.fco.bim() == 4) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                gb(bif, value);
            }
        }
    }

    private void gb(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0838a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.gr(TiebaInitialize.Params.OBJ_URL, str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QX(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0838a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.gr(TiebaInitialize.Params.OBJ_URL, this.fco.bin());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.iVN;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.iVN != null) {
            this.iVN.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.iVN != null) {
            this.iVN.bvf();
        }
    }
}
