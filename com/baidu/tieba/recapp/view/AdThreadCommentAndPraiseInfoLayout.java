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
    public static int ing;
    private final int inh;
    private final int ini;
    private final int inj;
    private final int ink;
    private final int inl;
    private int inm;
    private int inn;
    private int ino;
    private a inp;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.inh = 446;
        this.ini = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.inj = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.ink = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.inl = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.inm = 1;
        this.type = 0;
        this.inn = d.f.selector_comment_and_prise_item_text_color;
        this.ino = this.inn;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.inh = 446;
        this.ini = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.inj = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.ink = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.inl = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.inm = 1;
        this.type = 0;
        this.inn = d.f.selector_comment_and_prise_item_text_color;
        this.ino = this.inn;
        initSetting();
    }

    private void initSetting() {
        ing = l.h(this.mContext, d.e.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(9);
        this.bSD = false;
        bXK();
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bg bgVar) {
        AgreeData aaE;
        if (bgVar != null && (aaE = bgVar.aaE()) != null && aaE.agreeNum == 0 && aaE.diffAgreeNum == 0) {
            aaE.agreeNum = bgVar.aah();
            aaE.hasAgree = bgVar.aaj() == 1;
            aaE.agreeType = bgVar.aak();
            aaE.diffAgreeNum = bgVar.aah() - bgVar.aai();
        }
        super.updatePraiseNum(bgVar);
        if (this.bSf != null) {
            this.bSf.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type == 1 && this.bNu != null && this.bSz) {
            if (this.bNu.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bNu.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.bNu.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.bNu.getImageView();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.bSb;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void o(bg bgVar) {
        super.o(bgVar);
        if (this.type == 1 && this.bSF && this.bSl.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSl.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.bSb;
            layoutParams.weight = 0.0f;
            this.bSl.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void p(bg bgVar) {
        super.p(bgVar);
        if (this.type == 1 && this.bSi != null && this.bSD) {
            this.bSi.setVisibility(0);
            if (this.bSi.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSi.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.bSb;
                layoutParams.weight = 0.0f;
                this.bSi.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void t(bg bgVar) {
        super.t(bgVar);
        if (this.inm == 1) {
            this.bSc.setText(ap.g(bgVar.YT(), 12, ""));
        }
    }

    public void disableClick() {
        this.bNu.setClickable(false);
        this.bSl.setClickable(false);
        this.bSi.setClickable(false);
    }

    private void bXK() {
        if (this.bSf != null) {
            this.bSf.getImgAgree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.bSf.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 2) {
                            data.agreeType = 2;
                            data.hasAgree = false;
                            data.diffAgreeNum--;
                            data.agreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.bSf.GP();
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum += 2;
                            data.agreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.bSf.dH(true);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum++;
                        data.agreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.bSf.dH(true);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.ya(i);
                }
            });
            this.bSf.getImgDisagree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.bSf.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 5) {
                            data.agreeType = 5;
                            data.hasAgree = false;
                            data.diffAgreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.bSf.GP();
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum -= 2;
                            data.agreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.bSf.dH(false);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum--;
                        data.disAgreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.bSf.dH(false);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.ya(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ya(int i) {
        if (i == 1) {
            a(this.inp.getThreadData(), "nozan", 0);
            a(this.inp.getThreadData(), "1", "2");
            return;
        }
        a(this.inp.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.inp.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aM(View view) {
        int i = 0;
        if (bc.cZ(this.mContext) && this.XS != null) {
            if (this.XS.aaj() != 0) {
                a(this.inp.getThreadData(), "nozan", 0);
                a(this.inp.getThreadData(), "1", "2");
                this.XS.af(this.XS.aah() - 1);
                this.XS.gx(0);
                this.bNu.bOj = d.C0277d.cp_cont_f;
                this.bNu.bOk = d.C0277d.cp_cont_f;
                i = 1;
            } else {
                a(this.inp.getThreadData(), FeedData.TYPE_ZAN, 0);
                a(this.inp.getThreadData(), "1", "1");
                this.XS.gx(1);
                this.XS.af(this.XS.aah() + 1);
                this.bNu.bOj = d.C0277d.cp_cont_h;
                this.bNu.bOk = d.C0277d.cp_cont_h;
            }
            if (this.inp instanceof AdCard) {
                ((AdCard) this.inp).agree_num = this.XS.aah();
            }
            updatePraiseNum(this.XS);
            this.bNu.hD(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aJ(View view) {
        if (this.XS != null && this.mContext != null && this.inp != null) {
            a(this.inp.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.inp.getThreadData(), "2", "1");
            if (az.jK() || bc.cZ(this.mContext)) {
                final com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                dVar.title = this.inp.getTitle();
                dVar.content = this.inp.getAbstract();
                dVar.cbA = this.inp.getTitle();
                dVar.linkUrl = this.inp.getShareLink();
                dVar.cbD = 3;
                dVar.cbo = true;
                String imageUrl = this.inp.getImageUrl();
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
                shareDialogConfig.setHideMode(BS(dVar.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.inm = i;
    }

    public void setShareData(a aVar) {
        this.inp = aVar;
        setData(this.inp.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        b c = f.c(advertAppInfo, 8, i);
        c.BR(str);
        c.bXA().a(c);
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
                        xVar.acg();
                        return null;
                    }
                    return null;
                }
            }.execute(URL, dN(str3, "cpid"), dN(str3, "idea_id"));
        }
    }

    private String dN(String str, String str2) {
        try {
            return new JSONObject(new String(com.baidu.adp.lib.util.c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.bSi;
    }

    private int BS(String str) {
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
        al.j(this.bSg, this.inn);
        al.j(this.bSj, this.ino);
    }

    public void setDisPraiseViewVisibility(boolean z) {
        if (this.bNv != null) {
            this.bNv.setVisibility(z ? 0 : 8);
        }
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.inn = d.C0277d.cp_cont_e;
            this.bSM = d.f.icon_home_card_comment_s;
            return;
        }
        this.inn = d.f.selector_comment_and_prise_item_text_color;
        this.bSM = d.f.icon_home_card_comment;
    }

    private boolean aea() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.afU();
    }

    public void setPraiseContainerBgGray(boolean z) {
        if (this.bNu != null) {
            if (com.baidu.tbadk.util.a.apJ().afK()) {
                if (z) {
                    this.bNu.bOh = d.f.icon_card_like_d;
                    this.bNu.bOi = d.f.icon_card_like_d;
                    this.bNu.bOj = d.C0277d.cp_cont_e;
                    this.bNu.bOk = d.C0277d.cp_cont_e;
                    return;
                }
                this.bNu.bOh = d.f.icon_card_like_n;
                this.bNu.bOi = d.f.icon_card_like_s;
                if (this.XS != null && this.XS.aaj() == 1) {
                    this.bNu.bOj = d.f.selector_comment_and_prise_item_text_color;
                    this.bNu.bOk = d.C0277d.cp_cont_h;
                    return;
                }
                this.bNu.bOj = d.f.selector_comment_and_prise_item_text_color;
                this.bNu.bOk = d.f.selector_comment_and_prise_item_text_color;
            } else if (z) {
                this.bNu.bOh = d.f.icon_home_card_like_d;
                this.bNu.bOi = d.f.icon_home_card_like_d;
                this.bNu.bOj = d.C0277d.cp_cont_e;
                this.bNu.bOk = d.C0277d.cp_cont_e;
            } else {
                this.bNu.bOh = aea() ? d.f.icon_home_card_like_n_xmas : d.f.icon_home_card_like_n;
                this.bNu.bOi = aea() ? d.f.icon_home_card_like_s_xmas : d.f.icon_home_card_like_s;
                if (this.XS != null && this.XS.aaj() == 1) {
                    this.bNu.bOj = d.f.selector_comment_and_prise_item_text_color;
                    this.bNu.bOk = d.C0277d.cp_cont_h;
                    return;
                }
                this.bNu.bOj = d.f.selector_comment_and_prise_item_text_color;
                this.bNu.bOk = d.f.selector_comment_and_prise_item_text_color;
            }
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.bSN = d.f.icon_card_share_s;
            this.ino = d.C0277d.cp_cont_e;
            return;
        }
        this.bSN = d.f.icon_home_card_share;
        this.ino = d.f.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void aeV() {
        super.aeV();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(ing, 0, ing, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(ing, 0, ing, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(ing, 0, ing, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(ing, 0, ing, 0);
        }
    }
}
