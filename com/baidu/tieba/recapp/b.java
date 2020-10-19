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
    private static final Pattern mav = Pattern.compile("(/p/){1}(\\d+)");
    private ad eTS;
    private BannerView iJr = null;
    private boolean iJt = false;
    BannerView.a iJw = new BannerView.a() { // from class: com.baidu.tieba.recapp.b.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void btn() {
            b.this.cxY();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void bto() {
            b.this.cya();
        }
    };
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private com.baidu.tieba.InjectPlugin.a.c mat;
    private a.InterfaceC0580a mau;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.mat = cVar;
        if (this.mat != null && (this.mat.bDo() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.mat.bDo();
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
            this.eTS = (ad) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0580a interfaceC0580a) {
        this.mau = interfaceC0580a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void bDj() {
        if (this.mPageContext != null && this.mau != null) {
            if (this.eTS == null) {
                cya();
            } else if (!this.eTS.isValid()) {
                cya();
            } else {
                if (!this.iJt) {
                    if (this.iJr == null) {
                        this.iJr = new BannerView(this.mPageContext.getPageActivity());
                        this.iJr.setVisibility(8);
                        this.iJr.setBannerViewClickListener(this.iJw);
                        this.iJr.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.b.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onComplete(String str, boolean z) {
                                if (z) {
                                    if (b.this.eTS != null && b.this.eTS.emH) {
                                        String bgm = b.this.eTS.bgm();
                                        if (!StringUtils.isNULL(bgm)) {
                                            b.this.Qz(bgm);
                                        }
                                        b.this.eTS.emH = false;
                                    }
                                    if (b.this.iJr != null && b.this.iJr.btl() && !b.this.iJt) {
                                        b.this.iJt = true;
                                        b.this.mau.a(b.this.mat, b.this.iJr);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.eTS.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.mau.a(this.mat, this.iJr);
                }
                this.iJr.setBannerData(this.eTS);
                this.iJr.reset();
                if (this.eTS.getType() == 1 && !TextUtils.isEmpty(this.eTS.bgu())) {
                    this.iJr.setData(this.mPageContext, this.eTS.bgu());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cya() {
        if (this.iJr != null && this.mau != null) {
            this.iJt = false;
            this.mau.b(this.mat, this.iJr);
            this.iJr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxY() {
        if (this.eTS != null) {
            String value = this.eTS.getValue();
            String bgm = this.eTS.bgm();
            if (this.eTS.bgt() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                fW(bgm, value);
            } else if (this.eTS.bgt() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = mav.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            fW(bgm, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.eTS.bgt() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.ezT != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.ezT) {
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
                    r.duF().duC().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                    }
                }
                fW(bgm, value);
            } else if (this.eTS.bgt() == 4) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                fW(bgm, value);
            }
        }
    }

    private void fW(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0823a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.gm(TiebaInitialize.Params.OBJ_URL, str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qz(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0823a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.gm(TiebaInitialize.Params.OBJ_URL, this.eTS.bgu());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.iJr;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.iJr != null) {
            this.iJr.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.iJr != null) {
            this.iJr.btm();
        }
    }
}
