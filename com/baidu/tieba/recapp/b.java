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
    private static final Pattern krn = Pattern.compile("(/p/){1}(\\d+)");
    private y dRI;
    private BannerView hqe = null;
    private boolean hqg = false;
    BannerView.a hqj = new BannerView.a() { // from class: com.baidu.tieba.recapp.b.2
        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aVc() {
            b.this.bTp();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
        public void aVd() {
            b.this.bTr();
        }
    };
    private com.baidu.tieba.InjectPlugin.a.c krl;
    private a.InterfaceC0454a krm;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.InjectPlugin.a.a
    /* renamed from: b */
    public void init(com.baidu.tieba.InjectPlugin.a.c cVar) {
        this.krl = cVar;
        if (this.krl != null && (this.krl.bdN() instanceof TbPageContext)) {
            this.mPageContext = (TbPageContext) this.krl.bdN();
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
            this.dRI = (y) obj;
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void a(a.InterfaceC0454a interfaceC0454a) {
        this.krm = interfaceC0454a;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void bdI() {
        if (this.mPageContext != null && this.krm != null) {
            if (this.dRI == null) {
                bTr();
            } else if (!this.dRI.isValid()) {
                bTr();
            } else {
                if (!this.hqg) {
                    if (this.hqe == null) {
                        this.hqe = new BannerView(this.mPageContext.getPageActivity());
                        this.hqe.setVisibility(8);
                        this.hqe.setBannerViewClickListener(this.hqj);
                        this.hqe.setBannerViewEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.b.1
                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onComplete(String str, boolean z) {
                                if (z) {
                                    if (b.this.dRI != null && b.this.dRI.dos) {
                                        String aIM = b.this.dRI.aIM();
                                        if (!StringUtils.isNULL(aIM)) {
                                            b.this.Jr(aIM);
                                        }
                                        b.this.dRI.dos = false;
                                    }
                                    if (b.this.hqe != null && b.this.hqe.aVa() && !b.this.hqg) {
                                        b.this.hqg = true;
                                        b.this.krm.a(b.this.krl, b.this.hqe);
                                    }
                                }
                            }

                            @Override // com.baidu.tbadk.widget.TbImageView.a
                            public void onCancel() {
                            }
                        });
                        if (this.dRI.getValue().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                            TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "game_show", "show", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                        }
                    } else {
                        return;
                    }
                } else {
                    this.krm.a(this.krl, this.hqe);
                }
                this.hqe.setBannerData(this.dRI);
                this.hqe.reset();
                if (this.dRI.getType() == 1 && !TextUtils.isEmpty(this.dRI.aIW())) {
                    this.hqe.setData(this.mPageContext, this.dRI.aIW());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTr() {
        if (this.hqe != null && this.krm != null) {
            this.hqg = false;
            this.krm.b(this.krl, this.hqe);
            this.hqe = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTp() {
        if (this.dRI != null) {
            String value = this.dRI.getValue();
            String aIM = this.dRI.aIM();
            if (this.dRI.aIV() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.mPageContext.getPageActivity(), value, false, "frs_banner")));
                eB(aIM, value);
            } else if (this.dRI.aIV() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = krn.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            eB(aIM, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.dRI.aIV() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.dAn != UtilHelper.NativePageType.NONE) {
                    switch (isNativeAddress.dAn) {
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
                    q.cNm().cNj().c(this.mPageContext.getPageActivity(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                        TiebaStatic.eventStat(this.mPageContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", CommonStatisticKey.REF_TYPE_FRS_AD, "ref_type", "603");
                    }
                }
                eB(aIM, value);
            } else if (this.dRI.aIV() == 4) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(value, "frs_banner")));
                eB(aIM, value);
            }
        }
    }

    private void eB(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0675a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.mForumId, this.mForumName, null);
            b.eR(TiebaInitialize.Params.OBJ_URL, str2);
            b.save();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jr(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0675a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.mForumId, this.mForumName, null);
            b.eR(TiebaInitialize.Params.OBJ_URL, this.dRI.aIW());
            b.save();
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public View getView() {
        return this.hqe;
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void setBannerMaskColor(int i) {
        if (this.hqe != null) {
            this.hqe.setBannerMaskColor(i);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a
    public void changeSkinType(int i) {
        if (this.hqe != null) {
            this.hqe.aVb();
        }
    }
}
