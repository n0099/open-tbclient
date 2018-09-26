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
    private static final Pattern gvq = Pattern.compile("(/p/){1}(\\d+)");
    private v aKf;
    private BannerView dJd = null;
    private boolean dJe = false;
    BannerView.a dJh = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void GX() {
            c.this.aBg();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void GY() {
            c.this.aBi();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c gvo;
    private a.InterfaceC0123a gvp;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void M(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.gvo = cVar;
        if (this.gvo != null && (this.gvo.QE() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.gvo.QE();
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
            this.aKf = (v) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0123a interfaceC0123a) {
        this.gvp = interfaceC0123a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void Qz() {
        if (this.mPageContext != null && this.gvp != null) {
            if (this.aKf == null) {
                aBi();
            } else if (!this.aKf.isValid()) {
                aBi();
            } else {
                if (!this.dJe) {
                    if (this.dJd == null) {
                        this.dJd = new BannerView(this.mPageContext.getPageActivity());
                        this.dJd.setVisibility(8);
                        this.dJd.setBannerViewClickListener(this.dJh);
                        this.dJd.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void k(String str, boolean z) {
                                if (z) {
                                    if (c.this.aKf != null && c.this.aKf.aib) {
                                        String uZ = c.this.aKf.uZ();
                                        if (!StringUtils.isNULL(uZ)) {
                                            c.this.tp(uZ);
                                        }
                                        c.this.aKf.aib = false;
                                    }
                                    if (c.this.dJd != null && c.this.dJd.GV() && !c.this.dJe) {
                                        c.this.dJe = true;
                                        c.this.gvp.a(c.this.gvo, c.this.dJd);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.aKf.getValue().startsWith("game:detail:")) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.gvp.a(this.gvo, this.dJd);
                }
                this.dJd.setBannerData(this.aKf);
                this.dJd.reset();
                if (this.aKf.getType() == 1 && !TextUtils.isEmpty(this.aKf.uY())) {
                    this.dJd.setData(this.mPageContext, this.aKf.uY());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBi() {
        if (this.dJd != null && this.gvp != null) {
            this.dJe = false;
            this.gvp.b(this.gvo, this.dJd);
            this.dJd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBg() {
        if (this.aKf != null) {
            String value = this.aKf.getValue();
            String uZ = this.aKf.uZ();
            if (this.aKf.uX() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                ch(uZ, value);
            } else if (this.aKf.uX() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = gvq.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                            ch(uZ, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aKf.uX() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.auf != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.auf) {
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
                    r.bpV().bpS().d(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                ch(uZ, value);
            } else if (this.aKf.uX() == 4) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                ch(uZ, value);
            }
        }
    }

    private void ch(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0242a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.cw("obj_url", str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tp(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0242a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.cw("obj_url", this.aKf.uY());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.dJd;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.dJd != null) {
            this.dJd.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.dJd != null) {
            this.dJd.GW();
        }
    }
}
