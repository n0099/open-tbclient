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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.p.aw;
import com.baidu.tieba.e;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.recapp.c.a;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.report.b;
import com.baidu.tieba.recapp.report.c;
import com.baidu.tieba.recapp.report.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    public static String URL = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public static int gCi;
    private final int gCj;
    private final int gCk;
    private final int gCl;
    private final int gCm;
    private final int gCn;
    private int gCo;
    private int gCp;
    private int gCq;
    private a gCr;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.gCj = 446;
        this.gCk = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.gCl = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.gCm = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.gCn = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.gCo = 1;
        this.type = 0;
        this.gCp = e.f.selector_comment_and_prise_item_text_color;
        this.gCq = this.gCp;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gCj = 446;
        this.gCk = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.gCl = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.gCm = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.gCn = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.gCo = 1;
        this.type = 0;
        this.gCp = e.f.selector_comment_and_prise_item_text_color;
        this.gCq = this.gCp;
        initSetting();
    }

    private void initSetting() {
        gCi = l.h(this.mContext, e.C0141e.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bb bbVar) {
        super.updatePraiseNum(bbVar);
        if (this.type == 1 && this.awd != null && this.aAu) {
            if (this.awd.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awd.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.awd.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.awd.getImageView();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.azX;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void h(bb bbVar) {
        super.h(bbVar);
        if (this.type == 1 && this.aAA && this.aAg.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aAg.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.azX;
            layoutParams.weight = 0.0f;
            this.aAg.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void g(bb bbVar) {
        super.g(bbVar);
        if (this.type == 1 && this.aAd != null && this.aAy) {
            this.aAd.setVisibility(0);
            if (this.aAd.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aAd.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.azX;
                layoutParams.weight = 0.0f;
                this.aAd.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void d(bb bbVar) {
        super.d(bbVar);
        if (this.gCo == 1) {
            this.azY.setText(ao.d(bbVar.ws(), 12, ""));
        }
    }

    public void disableClick() {
        this.awd.setClickable(false);
        this.aAg.setClickable(false);
        this.aAd.setClickable(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void P(View view) {
        int i = 0;
        if (ba.bA(this.mContext) && this.awf != null) {
            if (this.awf.xA() != 0) {
                a(this.gCr.getThreadData(), "nozan", 0);
                a(this.gCr.getThreadData(), "1", "2");
                this.awf.t(this.awf.xy() - 1);
                this.awf.ck(0);
                this.awd.awu = e.d.cp_cont_f;
                this.awd.awv = e.d.cp_cont_f;
                i = 1;
            } else {
                a(this.gCr.getThreadData(), FeedData.TYPE_ZAN, 0);
                a(this.gCr.getThreadData(), "1", "1");
                this.awf.ck(1);
                this.awf.t(this.awf.xy() + 1);
                this.awd.awu = e.d.cp_cont_h;
                this.awd.awv = e.d.cp_cont_h;
            }
            if (this.gCr instanceof AdCard) {
                ((AdCard) this.gCr).agree_num = this.awf.xy();
            }
            updatePraiseNum(this.awf);
            this.awd.dn(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void O(View view) {
        if (this.awf != null && this.mContext != null && this.gCr != null) {
            a(this.gCr.getThreadData(), "share", 0);
            a(this.gCr.getThreadData(), "2", "1");
            if (aw.jw() || ba.bA(this.mContext)) {
                final d dVar = new d();
                dVar.title = this.gCr.getTitle();
                dVar.content = this.gCr.getAbstract();
                dVar.aJs = this.gCr.getTitle();
                dVar.linkUrl = this.gCr.getShareLink();
                dVar.aJv = 3;
                dVar.aJk = true;
                String imageUrl = this.gCr.getImageUrl();
                Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
                if (parse != null) {
                    dVar.imageUri = parse;
                }
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        dVar.linkUrl = com.baidu.tbadk.coreExtra.c.e.as(dVar.linkUrl, dVar.tid);
                        com.baidu.adp.lib.util.a.bh(dVar.linkUrl);
                        l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(e.j.copy_pb_url_success));
                    }
                });
                shareDialogConfig.setHideMode(tO(dVar.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.gCo = i;
    }

    public void setShareData(a aVar) {
        this.gCr = aVar;
        setData(this.gCr.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        b c = f.c(advertAppInfo, 8, i);
        c.tN(str);
        c.bqQ().a(c);
    }

    private void a(AdvertAppInfo advertAppInfo, final String str, final String str2) {
        if (advertAppInfo != null) {
            String str3 = advertAppInfo.extensionInfo;
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length > 0) {
                        x xVar = new x(strArr[0]);
                        xVar.u("cpid", strArr[1]);
                        xVar.u("idea_id", strArr[2]);
                        xVar.u("type", str);
                        xVar.u(IntentConfig.CMD, str2);
                        xVar.zt();
                        return null;
                    }
                    return null;
                }
            }.execute(URL, cm(str3, "cpid"), cm(str3, "idea_id"));
        }
    }

    private String cm(String str, String str2) {
        try {
            return new JSONObject(new String(com.baidu.adp.lib.util.c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.aAd;
    }

    private int tO(String str) {
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
        al.h(this.aAb, this.gCp);
        al.h(this.aAe, this.gCq);
    }

    public void setDisPraiseViewVisibility(boolean z) {
        if (this.awe != null) {
            this.awe.setVisibility(z ? 0 : 8);
        }
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.gCp = e.d.cp_cont_e;
            this.aAF = e.f.icon_home_card_comment_s;
            return;
        }
        this.gCp = e.f.selector_comment_and_prise_item_text_color;
        this.aAF = e.f.icon_home_card_comment;
    }

    private boolean Bo() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.CX();
    }

    public void setPraiseContainerBgGray(boolean z) {
        if (com.baidu.tbadk.util.a.Mu().CM()) {
            if (z) {
                this.awd.aws = e.f.icon_card_like_d;
                this.awd.awt = e.f.icon_card_like_d;
                this.awd.awu = e.d.cp_cont_e;
                this.awd.awv = e.d.cp_cont_e;
                return;
            }
            this.awd.aws = e.f.icon_card_like_n;
            this.awd.awt = e.f.icon_card_like_s;
            if (this.awf != null && this.awf.xA() == 1) {
                this.awd.awu = e.f.selector_comment_and_prise_item_text_color;
                this.awd.awv = e.d.cp_cont_h;
                return;
            }
            this.awd.awu = e.f.selector_comment_and_prise_item_text_color;
            this.awd.awv = e.f.selector_comment_and_prise_item_text_color;
        } else if (z) {
            this.awd.aws = e.f.icon_home_card_like_d;
            this.awd.awt = e.f.icon_home_card_like_d;
            this.awd.awu = e.d.cp_cont_e;
            this.awd.awv = e.d.cp_cont_e;
        } else {
            this.awd.aws = Bo() ? e.f.icon_home_card_like_n_xmas : e.f.icon_home_card_like_n;
            this.awd.awt = Bo() ? e.f.icon_home_card_like_s_xmas : e.f.icon_home_card_like_s;
            if (this.awf != null && this.awf.xA() == 1) {
                this.awd.awu = e.f.selector_comment_and_prise_item_text_color;
                this.awd.awv = e.d.cp_cont_h;
                return;
            }
            this.awd.awu = e.f.selector_comment_and_prise_item_text_color;
            this.awd.awv = e.f.selector_comment_and_prise_item_text_color;
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.aAG = e.f.icon_card_share_s;
            this.gCq = e.d.cp_cont_e;
            return;
        }
        this.aAG = e.f.icon_home_card_share;
        this.gCq = e.f.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void BX() {
        super.BX();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(gCi, 0, gCi, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(0, 0, 0, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(gCi, 0, gCi, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(0, 0, 0, 0);
        }
    }
}
