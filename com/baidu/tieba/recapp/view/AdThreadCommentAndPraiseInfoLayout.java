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
    public static int gJG;
    private final int gJH;
    private final int gJI;
    private final int gJJ;
    private final int gJK;
    private final int gJL;
    private int gJM;
    private int gJN;
    private int gJO;
    private a gJP;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.gJH = 446;
        this.gJI = 5120;
        this.gJJ = 5120;
        this.gJK = 5120;
        this.gJL = 5120;
        this.gJM = 1;
        this.type = 0;
        this.gJN = e.f.selector_comment_and_prise_item_text_color;
        this.gJO = this.gJN;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gJH = 446;
        this.gJI = 5120;
        this.gJJ = 5120;
        this.gJK = 5120;
        this.gJL = 5120;
        this.gJM = 1;
        this.type = 0;
        this.gJN = e.f.selector_comment_and_prise_item_text_color;
        this.gJO = this.gJN;
        initSetting();
    }

    private void initSetting() {
        gJG = l.h(this.mContext, e.C0175e.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bb bbVar) {
        super.updatePraiseNum(bbVar);
        if (this.type == 1 && this.aAO != null && this.aFc) {
            if (this.aAO.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aAO.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.aAO.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.aAO.getImageView();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.aEF;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void h(bb bbVar) {
        super.h(bbVar);
        if (this.type == 1 && this.aFi && this.aEO.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aEO.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.aEF;
            layoutParams.weight = 0.0f;
            this.aEO.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void g(bb bbVar) {
        super.g(bbVar);
        if (this.type == 1 && this.aEL != null && this.aFg) {
            this.aEL.setVisibility(0);
            if (this.aEL.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aEL.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.aEF;
                layoutParams.weight = 0.0f;
                this.aEL.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void d(bb bbVar) {
        super.d(bbVar);
        if (this.gJM == 1) {
            this.aEG.setText(ao.d(bbVar.yB(), 12, ""));
        }
    }

    public void disableClick() {
        this.aAO.setClickable(false);
        this.aEO.setClickable(false);
        this.aEL.setClickable(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void P(View view) {
        int i = 0;
        if (ba.bI(this.mContext) && this.aAQ != null) {
            if (this.aAQ.zJ() != 0) {
                a(this.gJP.getThreadData(), "nozan", 0);
                a(this.gJP.getThreadData(), "1", "2");
                this.aAQ.v(this.aAQ.zH() - 1);
                this.aAQ.cu(0);
                this.aAO.aBf = e.d.cp_cont_f;
                this.aAO.aBg = e.d.cp_cont_f;
                i = 1;
            } else {
                a(this.gJP.getThreadData(), FeedData.TYPE_ZAN, 0);
                a(this.gJP.getThreadData(), "1", "1");
                this.aAQ.cu(1);
                this.aAQ.v(this.aAQ.zH() + 1);
                this.aAO.aBf = e.d.cp_cont_h;
                this.aAO.aBg = e.d.cp_cont_h;
            }
            if (this.gJP instanceof AdCard) {
                ((AdCard) this.gJP).agree_num = this.aAQ.zH();
            }
            updatePraiseNum(this.aAQ);
            this.aAO.dx(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void O(View view) {
        if (this.aAQ != null && this.mContext != null && this.gJP != null) {
            a(this.gJP.getThreadData(), "share", 0);
            a(this.gJP.getThreadData(), "2", "1");
            if (aw.jL() || ba.bI(this.mContext)) {
                final d dVar = new d();
                dVar.title = this.gJP.getTitle();
                dVar.content = this.gJP.getAbstract();
                dVar.aNU = this.gJP.getTitle();
                dVar.linkUrl = this.gJP.getShareLink();
                dVar.aNX = 3;
                dVar.aNM = true;
                String imageUrl = this.gJP.getImageUrl();
                Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
                if (parse != null) {
                    dVar.imageUri = parse;
                }
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        dVar.linkUrl = com.baidu.tbadk.coreExtra.c.e.aD(dVar.linkUrl, dVar.tid);
                        com.baidu.adp.lib.util.a.bg(dVar.linkUrl);
                        l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(e.j.copy_pb_url_success));
                    }
                });
                shareDialogConfig.setHideMode(uq(dVar.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.gJM = i;
    }

    public void setShareData(a aVar) {
        this.gJP = aVar;
        setData(this.gJP.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        b c = f.c(advertAppInfo, 8, i);
        c.up(str);
        c.buf().a(c);
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
                        xVar.x("cpid", strArr[1]);
                        xVar.x("idea_id", strArr[2]);
                        xVar.x("type", str);
                        xVar.x(IntentConfig.CMD, str2);
                        xVar.BA();
                        return null;
                    }
                    return null;
                }
            }.execute(URL, cx(str3, "cpid"), cx(str3, "idea_id"));
        }
    }

    private String cx(String str, String str2) {
        try {
            return new JSONObject(new String(com.baidu.adp.lib.util.c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.aEL;
    }

    private int uq(String str) {
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
        al.h(this.aEJ, this.gJN);
        al.h(this.aEM, this.gJO);
    }

    public void setDisPraiseViewVisibility(boolean z) {
        if (this.aAP != null) {
            this.aAP.setVisibility(z ? 0 : 8);
        }
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.gJN = e.d.cp_cont_e;
            this.aFn = e.f.icon_home_card_comment_s;
            return;
        }
        this.gJN = e.f.selector_comment_and_prise_item_text_color;
        this.aFn = e.f.icon_home_card_comment;
    }

    private boolean Dv() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.Fb();
    }

    public void setPraiseContainerBgGray(boolean z) {
        if (com.baidu.tbadk.util.a.Os().EQ()) {
            if (z) {
                this.aAO.aBd = e.f.icon_card_like_d;
                this.aAO.aBe = e.f.icon_card_like_d;
                this.aAO.aBf = e.d.cp_cont_e;
                this.aAO.aBg = e.d.cp_cont_e;
                return;
            }
            this.aAO.aBd = e.f.icon_card_like_n;
            this.aAO.aBe = e.f.icon_card_like_s;
            if (this.aAQ != null && this.aAQ.zJ() == 1) {
                this.aAO.aBf = e.f.selector_comment_and_prise_item_text_color;
                this.aAO.aBg = e.d.cp_cont_h;
                return;
            }
            this.aAO.aBf = e.f.selector_comment_and_prise_item_text_color;
            this.aAO.aBg = e.f.selector_comment_and_prise_item_text_color;
        } else if (z) {
            this.aAO.aBd = e.f.icon_home_card_like_d;
            this.aAO.aBe = e.f.icon_home_card_like_d;
            this.aAO.aBf = e.d.cp_cont_e;
            this.aAO.aBg = e.d.cp_cont_e;
        } else {
            this.aAO.aBd = Dv() ? e.f.icon_home_card_like_n_xmas : e.f.icon_home_card_like_n;
            this.aAO.aBe = Dv() ? e.f.icon_home_card_like_s_xmas : e.f.icon_home_card_like_s;
            if (this.aAQ != null && this.aAQ.zJ() == 1) {
                this.aAO.aBf = e.f.selector_comment_and_prise_item_text_color;
                this.aAO.aBg = e.d.cp_cont_h;
                return;
            }
            this.aAO.aBf = e.f.selector_comment_and_prise_item_text_color;
            this.aAO.aBg = e.f.selector_comment_and_prise_item_text_color;
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.aFo = e.f.icon_card_share_s;
            this.gJO = e.d.cp_cont_e;
            return;
        }
        this.aFo = e.f.icon_home_card_share;
        this.gJO = e.f.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void Ec() {
        super.Ec();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(gJG, 0, gJG, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(0, 0, 0, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(gJG, 0, gJG, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(0, 0, 0, 0);
        }
    }
}
