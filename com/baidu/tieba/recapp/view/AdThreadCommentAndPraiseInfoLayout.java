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
import com.baidu.tbadk.p.ax;
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
    public static int gLh;
    private final int gLi;
    private final int gLj;
    private final int gLk;
    private final int gLl;
    private final int gLm;
    private int gLn;
    private int gLo;
    private int gLp;
    private a gLq;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.gLi = 446;
        this.gLj = 5120;
        this.gLk = 5120;
        this.gLl = 5120;
        this.gLm = 5120;
        this.gLn = 1;
        this.type = 0;
        this.gLo = e.f.selector_comment_and_prise_item_text_color;
        this.gLp = this.gLo;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gLi = 446;
        this.gLj = 5120;
        this.gLk = 5120;
        this.gLl = 5120;
        this.gLm = 5120;
        this.gLn = 1;
        this.type = 0;
        this.gLo = e.f.selector_comment_and_prise_item_text_color;
        this.gLp = this.gLo;
        initSetting();
    }

    private void initSetting() {
        gLh = l.h(this.mContext, e.C0200e.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bb bbVar) {
        super.updatePraiseNum(bbVar);
        if (this.type == 1 && this.aBD != null && this.aFS) {
            if (this.aBD.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aBD.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.aBD.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.aBD.getImageView();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.aFv;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void h(bb bbVar) {
        super.h(bbVar);
        if (this.type == 1 && this.aFY && this.aFE.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aFE.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.aFv;
            layoutParams.weight = 0.0f;
            this.aFE.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void g(bb bbVar) {
        super.g(bbVar);
        if (this.type == 1 && this.aFB != null && this.aFW) {
            this.aFB.setVisibility(0);
            if (this.aFB.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aFB.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.aFv;
                layoutParams.weight = 0.0f;
                this.aFB.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void d(bb bbVar) {
        super.d(bbVar);
        if (this.gLn == 1) {
            this.aFw.setText(ao.d(bbVar.yI(), 12, ""));
        }
    }

    public void disableClick() {
        this.aBD.setClickable(false);
        this.aFE.setClickable(false);
        this.aFB.setClickable(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void P(View view) {
        int i = 0;
        if (ba.bG(this.mContext) && this.aBF != null) {
            if (this.aBF.zQ() != 0) {
                a(this.gLq.getThreadData(), "nozan", 0);
                a(this.gLq.getThreadData(), "1", "2");
                this.aBF.x(this.aBF.zO() - 1);
                this.aBF.cI(0);
                this.aBD.aBU = e.d.cp_cont_f;
                this.aBD.aBV = e.d.cp_cont_f;
                i = 1;
            } else {
                a(this.gLq.getThreadData(), FeedData.TYPE_ZAN, 0);
                a(this.gLq.getThreadData(), "1", "1");
                this.aBF.cI(1);
                this.aBF.x(this.aBF.zO() + 1);
                this.aBD.aBU = e.d.cp_cont_h;
                this.aBD.aBV = e.d.cp_cont_h;
            }
            if (this.gLq instanceof AdCard) {
                ((AdCard) this.gLq).agree_num = this.aBF.zO();
            }
            updatePraiseNum(this.aBF);
            this.aBD.dL(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void O(View view) {
        if (this.aBF != null && this.mContext != null && this.gLq != null) {
            a(this.gLq.getThreadData(), "share", 0);
            a(this.gLq.getThreadData(), "2", "1");
            if (ax.jJ() || ba.bG(this.mContext)) {
                final d dVar = new d();
                dVar.title = this.gLq.getTitle();
                dVar.content = this.gLq.getAbstract();
                dVar.aOK = this.gLq.getTitle();
                dVar.linkUrl = this.gLq.getShareLink();
                dVar.aON = 3;
                dVar.aOC = true;
                String imageUrl = this.gLq.getImageUrl();
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
                shareDialogConfig.setHideMode(uu(dVar.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.gLn = i;
    }

    public void setShareData(a aVar) {
        this.gLq = aVar;
        setData(this.gLq.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        b c = f.c(advertAppInfo, 8, i);
        c.ut(str);
        c.btB().a(c);
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
                        xVar.BH();
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
        return this.aFB;
    }

    private int uu(String str) {
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
        al.h(this.aFz, this.gLo);
        al.h(this.aFC, this.gLp);
    }

    public void setDisPraiseViewVisibility(boolean z) {
        if (this.aBE != null) {
            this.aBE.setVisibility(z ? 0 : 8);
        }
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.gLo = e.d.cp_cont_e;
            this.aGd = e.f.icon_home_card_comment_s;
            return;
        }
        this.gLo = e.f.selector_comment_and_prise_item_text_color;
        this.aGd = e.f.icon_home_card_comment;
    }

    private boolean DC() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.Fm();
    }

    public void setPraiseContainerBgGray(boolean z) {
        if (com.baidu.tbadk.util.a.OB().Fb()) {
            if (z) {
                this.aBD.aBS = e.f.icon_card_like_d;
                this.aBD.aBT = e.f.icon_card_like_d;
                this.aBD.aBU = e.d.cp_cont_e;
                this.aBD.aBV = e.d.cp_cont_e;
                return;
            }
            this.aBD.aBS = e.f.icon_card_like_n;
            this.aBD.aBT = e.f.icon_card_like_s;
            if (this.aBF != null && this.aBF.zQ() == 1) {
                this.aBD.aBU = e.f.selector_comment_and_prise_item_text_color;
                this.aBD.aBV = e.d.cp_cont_h;
                return;
            }
            this.aBD.aBU = e.f.selector_comment_and_prise_item_text_color;
            this.aBD.aBV = e.f.selector_comment_and_prise_item_text_color;
        } else if (z) {
            this.aBD.aBS = e.f.icon_home_card_like_d;
            this.aBD.aBT = e.f.icon_home_card_like_d;
            this.aBD.aBU = e.d.cp_cont_e;
            this.aBD.aBV = e.d.cp_cont_e;
        } else {
            this.aBD.aBS = DC() ? e.f.icon_home_card_like_n_xmas : e.f.icon_home_card_like_n;
            this.aBD.aBT = DC() ? e.f.icon_home_card_like_s_xmas : e.f.icon_home_card_like_s;
            if (this.aBF != null && this.aBF.zQ() == 1) {
                this.aBD.aBU = e.f.selector_comment_and_prise_item_text_color;
                this.aBD.aBV = e.d.cp_cont_h;
                return;
            }
            this.aBD.aBU = e.f.selector_comment_and_prise_item_text_color;
            this.aBD.aBV = e.f.selector_comment_and_prise_item_text_color;
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.aGe = e.f.icon_card_share_s;
            this.gLp = e.d.cp_cont_e;
            return;
        }
        this.aGe = e.f.icon_home_card_share;
        this.gLp = e.f.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void Em() {
        super.Em();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(gLh, 0, gLh, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(0, 0, 0, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(gLh, 0, gLh, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(0, 0, 0, 0);
        }
    }
}
