package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.l;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.s.az;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.recapp.c.a;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.report.b;
import com.baidu.tieba.recapp.report.c;
import com.baidu.tieba.recapp.report.f;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdThreadCommentAndPraiseInfoLayout extends NewThreadCommentAndPraiseInfoLayout {
    public static String URL = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public static int inv;
    private final int inA;
    private int inB;
    private int inC;
    private int inD;
    private a inE;
    private final int inw;
    private final int inx;
    private final int iny;
    private final int inz;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.inw = 446;
        this.inx = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iny = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.inz = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.inA = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.inB = 1;
        this.type = 0;
        this.inC = d.f.selector_comment_and_prise_item_text_color;
        this.inD = this.inC;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.inw = 446;
        this.inx = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iny = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.inz = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.inA = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.inB = 1;
        this.type = 0;
        this.inC = d.f.selector_comment_and_prise_item_text_color;
        this.inD = this.inC;
        initSetting();
    }

    private void initSetting() {
        inv = l.h(this.mContext, d.e.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(9);
        this.bSB = false;
        bXO();
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bg bgVar) {
        AgreeData aaH;
        if (bgVar != null && (aaH = bgVar.aaH()) != null && aaH.agreeNum == 0 && aaH.diffAgreeNum == 0) {
            aaH.agreeNum = bgVar.aak();
            aaH.hasAgree = bgVar.aam() == 1;
            aaH.agreeType = bgVar.aan();
            aaH.diffAgreeNum = bgVar.aak() - bgVar.aal();
        }
        super.updatePraiseNum(bgVar);
        if (this.bSd != null) {
            this.bSd.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type == 1 && this.bNs != null && this.bSx) {
            if (this.bNs.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bNs.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.bNs.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.bNs.getImageView();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.bRZ;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void o(bg bgVar) {
        super.o(bgVar);
        if (this.type == 1 && this.bSD && this.bSj.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSj.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.bRZ;
            layoutParams.weight = 0.0f;
            this.bSj.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void p(bg bgVar) {
        super.p(bgVar);
        if (this.type == 1 && this.bSg != null && this.bSB) {
            this.bSg.setVisibility(0);
            if (this.bSg.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSg.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.bRZ;
                layoutParams.weight = 0.0f;
                this.bSg.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void t(bg bgVar) {
        super.t(bgVar);
        if (this.inB == 1) {
            this.bSa.setText(ap.g(bgVar.YW(), 12, ""));
        }
    }

    public void disableClick() {
        this.bNs.setClickable(false);
        this.bSj.setClickable(false);
        this.bSg.setClickable(false);
    }

    private void bXO() {
        if (this.bSd != null) {
            this.bSd.getImgAgree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.bSd.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 2) {
                            data.agreeType = 2;
                            data.hasAgree = false;
                            data.diffAgreeNum--;
                            data.agreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.bSd.GR();
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum += 2;
                            data.agreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.bSd.dH(true);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum++;
                        data.agreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.bSd.dH(true);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.ye(i);
                }
            });
            this.bSd.getImgDisagree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.bSd.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 5) {
                            data.agreeType = 5;
                            data.hasAgree = false;
                            data.diffAgreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.bSd.GR();
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum -= 2;
                            data.agreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.bSd.dH(false);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum--;
                        data.disAgreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.bSd.dH(false);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.ye(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ye(int i) {
        if (i == 1) {
            a(this.inE.getThreadData(), "nozan", 0);
            a(this.inE.getThreadData(), "1", "2");
            return;
        }
        a(this.inE.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.inE.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aM(View view) {
        int i = 0;
        if (bc.cZ(this.mContext) && this.XS != null) {
            if (this.XS.aam() != 0) {
                a(this.inE.getThreadData(), "nozan", 0);
                a(this.inE.getThreadData(), "1", "2");
                this.XS.af(this.XS.aak() - 1);
                this.XS.gy(0);
                this.bNs.bOh = d.C0277d.cp_cont_f;
                this.bNs.bOi = d.C0277d.cp_cont_f;
                i = 1;
            } else {
                a(this.inE.getThreadData(), FeedData.TYPE_ZAN, 0);
                a(this.inE.getThreadData(), "1", "1");
                this.XS.gy(1);
                this.XS.af(this.XS.aak() + 1);
                this.bNs.bOh = d.C0277d.cp_cont_h;
                this.bNs.bOi = d.C0277d.cp_cont_h;
            }
            if (this.inE instanceof AdCard) {
                ((AdCard) this.inE).agree_num = this.XS.aak();
            }
            updatePraiseNum(this.XS);
            this.bNs.hE(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aJ(View view) {
        if (this.XS != null && this.mContext != null && this.inE != null) {
            a(this.inE.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.inE.getThreadData(), "2", "1");
            if (az.jK() || bc.cZ(this.mContext)) {
                final com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                dVar.title = this.inE.getTitle();
                dVar.content = this.inE.getAbstract();
                dVar.cby = this.inE.getTitle();
                dVar.linkUrl = this.inE.getShareLink();
                dVar.cbB = 3;
                dVar.cbm = true;
                String imageUrl = this.inE.getImageUrl();
                Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
                if (parse != null) {
                    dVar.imageUri = parse;
                }
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        dVar.linkUrl = e.bQ(dVar.linkUrl, dVar.tid);
                        com.baidu.adp.lib.util.a.bh(dVar.linkUrl);
                        l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(d.j.copy_pb_url_success));
                    }
                });
                shareDialogConfig.setHideMode(BT(dVar.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.inB = i;
    }

    public void setShareData(a aVar) {
        this.inE = aVar;
        setData(this.inE.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        b c = f.c(advertAppInfo, 8, i);
        c.BS(str);
        c.bXE().a(c);
    }

    private void a(AdvertAppInfo advertAppInfo, final String str, final String str2) {
        if (advertAppInfo != null) {
            String str3 = advertAppInfo.extensionInfo;
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length > 0) {
                        x xVar = new x(strArr[0]);
                        xVar.x("cpid", strArr[1]);
                        xVar.x("idea_id", strArr[2]);
                        xVar.x("type", str);
                        xVar.x(IntentConfig.CMD, str2);
                        xVar.acj();
                        return null;
                    }
                    return null;
                }
            }.execute(URL, dM(str3, "cpid"), dM(str3, "idea_id"));
        }
    }

    private String dM(String str, String str2) {
        try {
            return new JSONObject(new String(com.baidu.adp.lib.util.c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.bSg;
    }

    private int BT(String str) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int length = str.length();
        if (length > 5120) {
            i = 1;
        }
        if (length > 5120) {
            i |= 2;
        }
        if (length > 5120) {
            i |= 4;
        }
        if (length > 5120) {
            i |= 8;
        }
        if (length > 446) {
            return i | 16;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.j(this.bSe, this.inC);
        al.j(this.bSh, this.inD);
    }

    public void setDisPraiseViewVisibility(boolean z) {
        if (this.bNt != null) {
            this.bNt.setVisibility(z ? 0 : 8);
        }
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.inC = d.C0277d.cp_cont_e;
            this.bSK = d.f.icon_home_card_comment_s;
            return;
        }
        this.inC = d.f.selector_comment_and_prise_item_text_color;
        this.bSK = d.f.icon_home_card_comment;
    }

    private boolean aed() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.afX();
    }

    public void setPraiseContainerBgGray(boolean z) {
        if (this.bNs != null) {
            if (com.baidu.tbadk.util.a.apM().afN()) {
                if (z) {
                    this.bNs.bOf = d.f.icon_card_like_d;
                    this.bNs.bOg = d.f.icon_card_like_d;
                    this.bNs.bOh = d.C0277d.cp_cont_e;
                    this.bNs.bOi = d.C0277d.cp_cont_e;
                    return;
                }
                this.bNs.bOf = d.f.icon_card_like_n;
                this.bNs.bOg = d.f.icon_card_like_s;
                if (this.XS != null && this.XS.aam() == 1) {
                    this.bNs.bOh = d.f.selector_comment_and_prise_item_text_color;
                    this.bNs.bOi = d.C0277d.cp_cont_h;
                    return;
                }
                this.bNs.bOh = d.f.selector_comment_and_prise_item_text_color;
                this.bNs.bOi = d.f.selector_comment_and_prise_item_text_color;
            } else if (z) {
                this.bNs.bOf = d.f.icon_home_card_like_d;
                this.bNs.bOg = d.f.icon_home_card_like_d;
                this.bNs.bOh = d.C0277d.cp_cont_e;
                this.bNs.bOi = d.C0277d.cp_cont_e;
            } else {
                this.bNs.bOf = aed() ? d.f.icon_home_card_like_n_xmas : d.f.icon_home_card_like_n;
                this.bNs.bOg = aed() ? d.f.icon_home_card_like_s_xmas : d.f.icon_home_card_like_s;
                if (this.XS != null && this.XS.aam() == 1) {
                    this.bNs.bOh = d.f.selector_comment_and_prise_item_text_color;
                    this.bNs.bOi = d.C0277d.cp_cont_h;
                    return;
                }
                this.bNs.bOh = d.f.selector_comment_and_prise_item_text_color;
                this.bNs.bOi = d.f.selector_comment_and_prise_item_text_color;
            }
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.bSL = d.f.icon_card_share_s;
            this.inD = d.C0277d.cp_cont_e;
            return;
        }
        this.bSL = d.f.icon_home_card_share;
        this.inD = d.f.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void aeY() {
        super.aeY();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(inv, 0, inv, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(inv, 0, inv, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(inv, 0, inv, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(inv, 0, inv, 0);
        }
    }
}
