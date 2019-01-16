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
    public static int gVY;
    private final int gVZ;
    private final int gWa;
    private final int gWb;
    private final int gWc;
    private final int gWd;
    private int gWe;
    private int gWf;
    private int gWg;
    private a gWh;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.gVZ = 446;
        this.gWa = 5120;
        this.gWb = 5120;
        this.gWc = 5120;
        this.gWd = 5120;
        this.gWe = 1;
        this.type = 0;
        this.gWf = e.f.selector_comment_and_prise_item_text_color;
        this.gWg = this.gWf;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gVZ = 446;
        this.gWa = 5120;
        this.gWb = 5120;
        this.gWc = 5120;
        this.gWd = 5120;
        this.gWe = 1;
        this.type = 0;
        this.gWf = e.f.selector_comment_and_prise_item_text_color;
        this.gWg = this.gWf;
        initSetting();
    }

    private void initSetting() {
        gVY = l.h(this.mContext, e.C0210e.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bb bbVar) {
        super.updatePraiseNum(bbVar);
        if (this.type == 1 && this.aFG != null && this.aJV) {
            if (this.aFG.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aFG.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.aFG.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.aFG.getImageView();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.aJy;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void h(bb bbVar) {
        super.h(bbVar);
        if (this.type == 1 && this.aKb && this.aJH.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJH.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.aJy;
            layoutParams.weight = 0.0f;
            this.aJH.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void g(bb bbVar) {
        super.g(bbVar);
        if (this.type == 1 && this.aJE != null && this.aJZ) {
            this.aJE.setVisibility(0);
            if (this.aJE.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJE.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.aJy;
                layoutParams.weight = 0.0f;
                this.aJE.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void d(bb bbVar) {
        super.d(bbVar);
        if (this.gWe == 1) {
            this.aJz.setText(ao.d(bbVar.zZ(), 12, ""));
        }
    }

    public void disableClick() {
        this.aFG.setClickable(false);
        this.aJH.setClickable(false);
        this.aJE.setClickable(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void P(View view) {
        int i = 0;
        if (ba.bJ(this.mContext) && this.aFI != null) {
            if (this.aFI.Bh() != 0) {
                a(this.gWh.getThreadData(), "nozan", 0);
                a(this.gWh.getThreadData(), "1", "2");
                this.aFI.C(this.aFI.Bf() - 1);
                this.aFI.cW(0);
                this.aFG.aFX = e.d.cp_cont_f;
                this.aFG.aFY = e.d.cp_cont_f;
                i = 1;
            } else {
                a(this.gWh.getThreadData(), FeedData.TYPE_ZAN, 0);
                a(this.gWh.getThreadData(), "1", "1");
                this.aFI.cW(1);
                this.aFI.C(this.aFI.Bf() + 1);
                this.aFG.aFX = e.d.cp_cont_h;
                this.aFG.aFY = e.d.cp_cont_h;
            }
            if (this.gWh instanceof AdCard) {
                ((AdCard) this.gWh).agree_num = this.aFI.Bf();
            }
            updatePraiseNum(this.aFI);
            this.aFG.dZ(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void O(View view) {
        if (this.aFI != null && this.mContext != null && this.gWh != null) {
            a(this.gWh.getThreadData(), "share", 0);
            a(this.gWh.getThreadData(), "2", "1");
            if (ax.jJ() || ba.bJ(this.mContext)) {
                final d dVar = new d();
                dVar.title = this.gWh.getTitle();
                dVar.content = this.gWh.getAbstract();
                dVar.aSQ = this.gWh.getTitle();
                dVar.linkUrl = this.gWh.getShareLink();
                dVar.aST = 3;
                dVar.aSH = true;
                String imageUrl = this.gWh.getImageUrl();
                Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
                if (parse != null) {
                    dVar.imageUri = parse;
                }
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        dVar.linkUrl = com.baidu.tbadk.coreExtra.c.e.aH(dVar.linkUrl, dVar.tid);
                        com.baidu.adp.lib.util.a.bg(dVar.linkUrl);
                        l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(e.j.copy_pb_url_success));
                    }
                });
                shareDialogConfig.setHideMode(vo(dVar.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.gWe = i;
    }

    public void setShareData(a aVar) {
        this.gWh = aVar;
        setData(this.gWh.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        b c = f.c(advertAppInfo, 8, i);
        c.vn(str);
        c.bwO().a(c);
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
                        xVar.CY();
                        return null;
                    }
                    return null;
                }
            }.execute(URL, cD(str3, "cpid"), cD(str3, "idea_id"));
        }
    }

    private String cD(String str, String str2) {
        try {
            return new JSONObject(new String(com.baidu.adp.lib.util.c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.aJE;
    }

    private int vo(String str) {
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
        al.h(this.aJC, this.gWf);
        al.h(this.aJF, this.gWg);
    }

    public void setDisPraiseViewVisibility(boolean z) {
        if (this.aFH != null) {
            this.aFH.setVisibility(z ? 0 : 8);
        }
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.gWf = e.d.cp_cont_e;
            this.aKh = e.f.icon_home_card_comment_s;
            return;
        }
        this.gWf = e.f.selector_comment_and_prise_item_text_color;
        this.aKh = e.f.icon_home_card_comment;
    }

    private boolean ET() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.GE();
    }

    public void setPraiseContainerBgGray(boolean z) {
        if (com.baidu.tbadk.util.a.Qb().Gt()) {
            if (z) {
                this.aFG.aFV = e.f.icon_card_like_d;
                this.aFG.aFW = e.f.icon_card_like_d;
                this.aFG.aFX = e.d.cp_cont_e;
                this.aFG.aFY = e.d.cp_cont_e;
                return;
            }
            this.aFG.aFV = e.f.icon_card_like_n;
            this.aFG.aFW = e.f.icon_card_like_s;
            if (this.aFI != null && this.aFI.Bh() == 1) {
                this.aFG.aFX = e.f.selector_comment_and_prise_item_text_color;
                this.aFG.aFY = e.d.cp_cont_h;
                return;
            }
            this.aFG.aFX = e.f.selector_comment_and_prise_item_text_color;
            this.aFG.aFY = e.f.selector_comment_and_prise_item_text_color;
        } else if (z) {
            this.aFG.aFV = e.f.icon_home_card_like_d;
            this.aFG.aFW = e.f.icon_home_card_like_d;
            this.aFG.aFX = e.d.cp_cont_e;
            this.aFG.aFY = e.d.cp_cont_e;
        } else {
            this.aFG.aFV = ET() ? e.f.icon_home_card_like_n_xmas : e.f.icon_home_card_like_n;
            this.aFG.aFW = ET() ? e.f.icon_home_card_like_s_xmas : e.f.icon_home_card_like_s;
            if (this.aFI != null && this.aFI.Bh() == 1) {
                this.aFG.aFX = e.f.selector_comment_and_prise_item_text_color;
                this.aFG.aFY = e.d.cp_cont_h;
                return;
            }
            this.aFG.aFX = e.f.selector_comment_and_prise_item_text_color;
            this.aFG.aFY = e.f.selector_comment_and_prise_item_text_color;
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.aKi = e.f.icon_card_share_s;
            this.gWg = e.d.cp_cont_e;
            return;
        }
        this.aKi = e.f.icon_home_card_share;
        this.gWg = e.f.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void FE() {
        super.FE();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(gVY, 0, gVY, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(0, 0, 0, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(gVY, 0, gVY, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(0, 0, 0, 0);
        }
    }
}
