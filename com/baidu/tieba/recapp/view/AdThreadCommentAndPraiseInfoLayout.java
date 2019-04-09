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
    public static int inh;
    private final int ini;
    private final int inj;
    private final int ink;
    private final int inl;
    private final int inm;
    private int inn;
    private int ino;
    private int inp;
    private a inq;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.ini = 446;
        this.inj = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.ink = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.inl = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.inm = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.inn = 1;
        this.type = 0;
        this.ino = d.f.selector_comment_and_prise_item_text_color;
        this.inp = this.ino;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ini = 446;
        this.inj = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.ink = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.inl = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.inm = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.inn = 1;
        this.type = 0;
        this.ino = d.f.selector_comment_and_prise_item_text_color;
        this.inp = this.ino;
        initSetting();
    }

    private void initSetting() {
        inh = l.h(this.mContext, d.e.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(9);
        this.bSE = false;
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
        if (this.bSg != null) {
            this.bSg.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type == 1 && this.bNv != null && this.bSA) {
            if (this.bNv.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bNv.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.bNv.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.bNv.getImageView();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.bSc;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void o(bg bgVar) {
        super.o(bgVar);
        if (this.type == 1 && this.bSG && this.bSm.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSm.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.bSc;
            layoutParams.weight = 0.0f;
            this.bSm.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void p(bg bgVar) {
        super.p(bgVar);
        if (this.type == 1 && this.bSj != null && this.bSE) {
            this.bSj.setVisibility(0);
            if (this.bSj.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSj.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.bSc;
                layoutParams.weight = 0.0f;
                this.bSj.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void t(bg bgVar) {
        super.t(bgVar);
        if (this.inn == 1) {
            this.bSd.setText(ap.g(bgVar.YT(), 12, ""));
        }
    }

    public void disableClick() {
        this.bNv.setClickable(false);
        this.bSm.setClickable(false);
        this.bSj.setClickable(false);
    }

    private void bXK() {
        if (this.bSg != null) {
            this.bSg.getImgAgree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.bSg.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 2) {
                            data.agreeType = 2;
                            data.hasAgree = false;
                            data.diffAgreeNum--;
                            data.agreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.bSg.GP();
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum += 2;
                            data.agreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.bSg.dH(true);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum++;
                        data.agreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.bSg.dH(true);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.ya(i);
                }
            });
            this.bSg.getImgDisagree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.bSg.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 5) {
                            data.agreeType = 5;
                            data.hasAgree = false;
                            data.diffAgreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.bSg.GP();
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum -= 2;
                            data.agreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.bSg.dH(false);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum--;
                        data.disAgreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.bSg.dH(false);
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
            a(this.inq.getThreadData(), "nozan", 0);
            a(this.inq.getThreadData(), "1", "2");
            return;
        }
        a(this.inq.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.inq.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aM(View view) {
        int i = 0;
        if (bc.cZ(this.mContext) && this.XT != null) {
            if (this.XT.aaj() != 0) {
                a(this.inq.getThreadData(), "nozan", 0);
                a(this.inq.getThreadData(), "1", "2");
                this.XT.af(this.XT.aah() - 1);
                this.XT.gx(0);
                this.bNv.bOk = d.C0277d.cp_cont_f;
                this.bNv.bOl = d.C0277d.cp_cont_f;
                i = 1;
            } else {
                a(this.inq.getThreadData(), FeedData.TYPE_ZAN, 0);
                a(this.inq.getThreadData(), "1", "1");
                this.XT.gx(1);
                this.XT.af(this.XT.aah() + 1);
                this.bNv.bOk = d.C0277d.cp_cont_h;
                this.bNv.bOl = d.C0277d.cp_cont_h;
            }
            if (this.inq instanceof AdCard) {
                ((AdCard) this.inq).agree_num = this.XT.aah();
            }
            updatePraiseNum(this.XT);
            this.bNv.hD(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aJ(View view) {
        if (this.XT != null && this.mContext != null && this.inq != null) {
            a(this.inq.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.inq.getThreadData(), "2", "1");
            if (az.jK() || bc.cZ(this.mContext)) {
                final com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                dVar.title = this.inq.getTitle();
                dVar.content = this.inq.getAbstract();
                dVar.cbB = this.inq.getTitle();
                dVar.linkUrl = this.inq.getShareLink();
                dVar.cbE = 3;
                dVar.cbp = true;
                String imageUrl = this.inq.getImageUrl();
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
        this.inn = i;
    }

    public void setShareData(a aVar) {
        this.inq = aVar;
        setData(this.inq.getThreadData());
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
        return this.bSj;
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
        al.j(this.bSh, this.ino);
        al.j(this.bSk, this.inp);
    }

    public void setDisPraiseViewVisibility(boolean z) {
        if (this.bNw != null) {
            this.bNw.setVisibility(z ? 0 : 8);
        }
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.ino = d.C0277d.cp_cont_e;
            this.bSN = d.f.icon_home_card_comment_s;
            return;
        }
        this.ino = d.f.selector_comment_and_prise_item_text_color;
        this.bSN = d.f.icon_home_card_comment;
    }

    private boolean aea() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.afU();
    }

    public void setPraiseContainerBgGray(boolean z) {
        if (this.bNv != null) {
            if (com.baidu.tbadk.util.a.apJ().afK()) {
                if (z) {
                    this.bNv.bOi = d.f.icon_card_like_d;
                    this.bNv.bOj = d.f.icon_card_like_d;
                    this.bNv.bOk = d.C0277d.cp_cont_e;
                    this.bNv.bOl = d.C0277d.cp_cont_e;
                    return;
                }
                this.bNv.bOi = d.f.icon_card_like_n;
                this.bNv.bOj = d.f.icon_card_like_s;
                if (this.XT != null && this.XT.aaj() == 1) {
                    this.bNv.bOk = d.f.selector_comment_and_prise_item_text_color;
                    this.bNv.bOl = d.C0277d.cp_cont_h;
                    return;
                }
                this.bNv.bOk = d.f.selector_comment_and_prise_item_text_color;
                this.bNv.bOl = d.f.selector_comment_and_prise_item_text_color;
            } else if (z) {
                this.bNv.bOi = d.f.icon_home_card_like_d;
                this.bNv.bOj = d.f.icon_home_card_like_d;
                this.bNv.bOk = d.C0277d.cp_cont_e;
                this.bNv.bOl = d.C0277d.cp_cont_e;
            } else {
                this.bNv.bOi = aea() ? d.f.icon_home_card_like_n_xmas : d.f.icon_home_card_like_n;
                this.bNv.bOj = aea() ? d.f.icon_home_card_like_s_xmas : d.f.icon_home_card_like_s;
                if (this.XT != null && this.XT.aaj() == 1) {
                    this.bNv.bOk = d.f.selector_comment_and_prise_item_text_color;
                    this.bNv.bOl = d.C0277d.cp_cont_h;
                    return;
                }
                this.bNv.bOk = d.f.selector_comment_and_prise_item_text_color;
                this.bNv.bOl = d.f.selector_comment_and_prise_item_text_color;
            }
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.bSO = d.f.icon_card_share_s;
            this.inp = d.C0277d.cp_cont_e;
            return;
        }
        this.bSO = d.f.icon_home_card_share;
        this.inp = d.f.selector_comment_and_prise_item_text_color;
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
                layoutParams2.setMargins(inh, 0, inh, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(inh, 0, inh, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(inh, 0, inh, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(inh, 0, inh, 0);
        }
    }
}
