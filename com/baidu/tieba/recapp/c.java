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
    private static final Pattern iIU = Pattern.compile("(/p/){1}(\\d+)");
    private x cmV;
    private com.baidu.tieba.InjectPlugin.a.c iIS;
    private a.InterfaceC0275a iIT;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private BannerView fNu = null;
    private boolean fNw = false;
    BannerView.a fNA = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aqt() {
            c.this.brC();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aqu() {
            c.this.brE();
        }
    };

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.iIS = cVar;
        if (this.iIS != null && (this.iIS.aAR() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.iIS.aAR();
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
            this.cmV = (x) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0275a interfaceC0275a) {
        this.iIT = interfaceC0275a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void aAM() {
        if (this.mPageContext != null && this.iIT != null) {
            if (this.cmV == null) {
                brE();
            } else if (!this.cmV.isValid()) {
                brE();
            } else {
                if (!this.fNw) {
                    if (this.fNu == null) {
                        this.fNu = new BannerView(this.mPageContext.getPageActivity());
                        this.fNu.setVisibility(8);
                        this.fNu.setBannerViewClickListener(this.fNA);
                        this.fNu.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void P(String str, boolean z) {
                                if (z) {
                                    if (c.this.cmV != null && c.this.cmV.bHt) {
                                        String acR = c.this.cmV.acR();
                                        if (!StringUtils.isNULL(acR)) {
                                            c.this.Ed(acR);
                                        }
                                        c.this.cmV.bHt = false;
                                    }
                                    if (c.this.fNu != null && c.this.fNu.aqr() && !c.this.fNw) {
                                        c.this.fNw = true;
                                        c.this.iIT.a(c.this.iIS, c.this.fNu);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.cmV.getValue().startsWith("game:detail:")) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.iIT.a(this.iIS, this.fNu);
                }
                this.fNu.setBannerData(this.cmV);
                this.fNu.reset();
                if (this.cmV.getType() == 1 && !TextUtils.isEmpty(this.cmV.adb())) {
                    this.fNu.setData(this.mPageContext, this.cmV.adb());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brE() {
        if (this.fNu != null && this.iIT != null) {
            this.fNw = false;
            this.iIT.b(this.iIS, this.fNu);
            this.fNu = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brC() {
        if (this.cmV != null) {
            String value = this.cmV.getValue();
            String acR = this.cmV.acR();
            if (this.cmV.ada() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                dY(acR, value);
            } else if (this.cmV.ada() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = iIU.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                            dY(acR, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.cmV.ada() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.bVe != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.bVe) {
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
                    r.ciJ().ciG().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                dY(acR, value);
            } else if (this.cmV.ada() == 4) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                dY(acR, value);
            }
        }
    }

    private void dY(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0425a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.eo("obj_url", str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ed(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0425a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.eo("obj_url", this.cmV.adb());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.fNu;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.fNu != null) {
            this.fNu.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.fNu != null) {
            this.fNu.aqs();
        }
    }
}
