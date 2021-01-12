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
/* loaded from: classes7.dex */
public class c implements com.baidu.tieba.InjectPlugin.FrsBannerAd.a {
    private static final Pattern mHZ = Pattern.compile("(/p/){1}(\\d+)");
    private ae ftO;
    private BannerView jxS = null;
    private boolean jxU = false;
    BannerView.a jxY = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void byW() {
            c.this.cHH();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void byX() {
            c.this.cHJ();
        }
    };
    private String mForumId;
    private String mForumName;
    private com.baidu.tieba.InjectPlugin.a.c mHX;
    private a.InterfaceC0592a mHY;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.mHX = cVar;
        if (this.mHX != null && (this.mHX.bJa() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.mHX.bJa();
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
            this.ftO = (ae) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0592a interfaceC0592a) {
        this.mHY = interfaceC0592a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void bIV() {
        if (this.mPageContext != null && this.mHY != null) {
            if (this.ftO == null) {
                cHJ();
            } else if (!this.ftO.isValid()) {
                cHJ();
            } else {
                if (!this.jxU) {
                    if (this.jxS == null) {
                        this.jxS = new BannerView(this.mPageContext.getPageActivity());
                        this.jxS.setVisibility(8);
                        this.jxS.setBannerViewClickListener(this.jxY);
                        this.jxS.setBannerViewEvent(new TbImageView.b() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.b
                            public void onComplete(String str, boolean z) {
                                if (z) {
                                    if (c.this.ftO != null && c.this.ftO.eLv) {
                                        String blA = c.this.ftO.blA();
                                        if (!StringUtils.isNULL(blA)) {
                                            c.this.Qp(blA);
                                        }
                                        c.this.ftO.eLv = false;
                                    }
                                    if (c.this.jxS != null && c.this.jxS.byU() && !c.this.jxU) {
                                        c.this.jxU = true;
                                        c.this.mHY.a(c.this.mHX, c.this.jxS);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.b
                            public void onCancel() {
                            }
                        });
                        if (this.ftO.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.mHY.a(this.mHX, this.jxS);
                }
                this.jxS.setBannerData(this.ftO);
                this.jxS.reset();
                if (this.ftO.getType() == 1 && !TextUtils.isEmpty(this.ftO.blI())) {
                    this.jxS.setData(this.mPageContext, this.ftO.blI());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHJ() {
        if (this.jxS != null && this.mHY != null) {
            this.jxU = false;
            this.mHY.b(this.mHX, this.jxS);
            this.jxS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHH() {
        if (this.ftO != null) {
            String value = this.ftO.getValue();
            String blA = this.ftO.blA();
            if (this.ftO.blH() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                gc(blA, value);
            } else if (this.ftO.blH() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = mHZ.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            gc(blA, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.ftO.blH() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.eZi != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.eZi) {
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
                    r.dBe().dBb().a(this.mPageContext.getPageActivity(), new String[]{value}, null);
                    if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                    }
                }
                gc(blA, value);
            } else if (this.ftO.blH() == 4) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                gc(blA, value);
            }
        }
    }

    private void gc(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0869a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b2.gs(TiebaInitialize.Params.OBJ_URL, str2);
            b2.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qp(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0869a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b2.gs(TiebaInitialize.Params.OBJ_URL, this.ftO.blI());
            b2.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.jxS;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.jxS != null) {
            this.jxS.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.jxS != null) {
            this.jxS.byV();
        }
    }
}
