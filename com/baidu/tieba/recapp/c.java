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
    private static final Pattern igs = Pattern.compile("(/p/){1}(\\d+)");
    private x ccB;
    private com.baidu.tieba.InjectPlugin.a.c igq;
    private a.InterfaceC0249a igr;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private BannerView fpw = null;
    private boolean fpy = false;
    BannerView.a fpC = new BannerView.a() { // from class: com.baidu.tieba.recapp.c.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void ajY() {
            c.this.bhg();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void ajZ() {
            c.this.bhi();
        }
    };

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.igq = cVar;
        if (this.igq != null && (this.igq.auh() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.igq.auh();
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
            this.ccB = (x) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0249a interfaceC0249a) {
        this.igr = interfaceC0249a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void auc() {
        if (this.mPageContext != null && this.igr != null) {
            if (this.ccB == null) {
                bhi();
            } else if (!this.ccB.isValid()) {
                bhi();
            } else {
                if (!this.fpy) {
                    if (this.fpw == null) {
                        this.fpw = new BannerView(this.mPageContext.getPageActivity());
                        this.fpw.setVisibility(8);
                        this.fpw.setBannerViewClickListener(this.fpC);
                        this.fpw.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.c.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void L(String str, boolean z) {
                                if (z) {
                                    if (c.this.ccB != null && c.this.ccB.byH) {
                                        String Xn = c.this.ccB.Xn();
                                        if (!StringUtils.isNULL(Xn)) {
                                            c.this.Bs(Xn);
                                        }
                                        c.this.ccB.byH = false;
                                    }
                                    if (c.this.fpw != null && c.this.fpw.ajW() && !c.this.fpy) {
                                        c.this.fpy = true;
                                        c.this.igr.a(c.this.igq, c.this.fpw);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.ccB.getValue().startsWith("game:detail:")) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "ref_id", "4000601", "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.igr.a(this.igq, this.fpw);
                }
                this.fpw.setBannerData(this.ccB);
                this.fpw.reset();
                if (this.ccB.getType() == 1 && !TextUtils.isEmpty(this.ccB.Xm())) {
                    this.fpw.setData(this.mPageContext, this.ccB.Xm());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhi() {
        if (this.fpw != null && this.igr != null) {
            this.fpy = false;
            this.igr.b(this.igq, this.fpw);
            this.fpw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhg() {
        if (this.ccB != null) {
            String value = this.ccB.getValue();
            String Xn = this.ccB.Xn();
            if (this.ccB.Xl() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                dI(Xn, value);
            } else if (this.ccB.Xl() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = igs.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                            dI(Xn, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.ccB.Xl() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.bLI != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.bLI) {
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
                    r.bWF().bWC().d(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                dI(Xn, value);
            } else if (this.ccB.Xl() == 4) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                dI(Xn, value);
            }
        }
    }

    private void dI(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0390a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.dY("obj_url", str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bs(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0390a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.dY("obj_url", this.ccB.Xm());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.fpw;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.fpw != null) {
            this.fpw.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.fpw != null) {
            this.fpw.ajX();
        }
    }
}
