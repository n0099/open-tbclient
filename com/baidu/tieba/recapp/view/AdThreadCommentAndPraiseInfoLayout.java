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
    public static int gUT;
    private final int gUU;
    private final int gUV;
    private final int gUW;
    private final int gUX;
    private final int gUY;
    private int gUZ;
    private int gVa;
    private int gVb;
    private a gVc;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.gUU = 446;
        this.gUV = 5120;
        this.gUW = 5120;
        this.gUX = 5120;
        this.gUY = 5120;
        this.gUZ = 1;
        this.type = 0;
        this.gVa = e.f.selector_comment_and_prise_item_text_color;
        this.gVb = this.gVa;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gUU = 446;
        this.gUV = 5120;
        this.gUW = 5120;
        this.gUX = 5120;
        this.gUY = 5120;
        this.gUZ = 1;
        this.type = 0;
        this.gVa = e.f.selector_comment_and_prise_item_text_color;
        this.gVb = this.gVa;
        initSetting();
    }

    private void initSetting() {
        gUT = l.h(this.mContext, e.C0210e.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bb bbVar) {
        super.updatePraiseNum(bbVar);
        if (this.type == 1 && this.aFe != null && this.aJt) {
            if (this.aFe.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aFe.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.aFe.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.aFe.getImageView();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.aIW;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void h(bb bbVar) {
        super.h(bbVar);
        if (this.type == 1 && this.aJz && this.aJf.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJf.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.aIW;
            layoutParams.weight = 0.0f;
            this.aJf.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void g(bb bbVar) {
        super.g(bbVar);
        if (this.type == 1 && this.aJc != null && this.aJx) {
            this.aJc.setVisibility(0);
            if (this.aJc.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJc.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.aIW;
                layoutParams.weight = 0.0f;
                this.aJc.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void d(bb bbVar) {
        super.d(bbVar);
        if (this.gUZ == 1) {
            this.aIX.setText(ao.d(bbVar.zM(), 12, ""));
        }
    }

    public void disableClick() {
        this.aFe.setClickable(false);
        this.aJf.setClickable(false);
        this.aJc.setClickable(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void P(View view) {
        int i = 1;
        if (ba.bJ(this.mContext) && this.aFg != null) {
            String str = null;
            if (this.aFg instanceof AdvertAppInfo) {
                str = ((AdvertAppInfo) this.aFg).apq;
            }
            if (this.aFg.AU() != 0) {
                a(this.gVc.getThreadData(), "nozan", 0);
                addPraiseStats(true, 1, str);
                a(this.gVc.getThreadData(), "1", "2");
                this.aFg.C(this.aFg.AS() - 1);
                this.aFg.cW(0);
                this.aFe.aFv = e.d.cp_cont_f;
                this.aFe.aFw = e.d.cp_cont_f;
            } else {
                a(this.gVc.getThreadData(), FeedData.TYPE_ZAN, 0);
                addPraiseStats(true, 0, str);
                a(this.gVc.getThreadData(), "1", "1");
                this.aFg.cW(1);
                this.aFg.C(this.aFg.AS() + 1);
                this.aFe.aFv = e.d.cp_cont_h;
                this.aFe.aFw = e.d.cp_cont_h;
                i = 0;
            }
            if (this.gVc instanceof AdCard) {
                ((AdCard) this.gVc).agree_num = this.aFg.AS();
            }
            updatePraiseNum(this.aFg);
            this.aFe.dZ(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void O(View view) {
        if (this.aFg != null && this.mContext != null && this.gVc != null) {
            a(this.gVc.getThreadData(), "share", 0);
            d(true, this.aFg instanceof AdvertAppInfo ? ((AdvertAppInfo) this.aFg).apq : null);
            a(this.gVc.getThreadData(), "2", "1");
            if (ax.jJ() || ba.bJ(this.mContext)) {
                final d dVar = new d();
                dVar.title = this.gVc.getTitle();
                dVar.content = this.gVc.getAbstract();
                dVar.aSl = this.gVc.getTitle();
                dVar.linkUrl = this.gVc.getShareLink();
                dVar.aSo = 3;
                dVar.aSd = true;
                String imageUrl = this.gVc.getImageUrl();
                Uri parse = imageUrl != null ? Uri.parse(imageUrl) : null;
                if (parse != null) {
                    dVar.imageUri = parse;
                }
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        dVar.linkUrl = com.baidu.tbadk.coreExtra.c.e.aG(dVar.linkUrl, dVar.tid);
                        com.baidu.adp.lib.util.a.bg(dVar.linkUrl);
                        l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(e.j.copy_pb_url_success));
                    }
                });
                shareDialogConfig.setHideMode(uY(dVar.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.gUZ = i;
    }

    public void setShareData(a aVar) {
        this.gVc = aVar;
        setData(this.gVc.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        b c = f.c(advertAppInfo, 8, i);
        c.uX(str);
        c.bwf().a(c);
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
                        xVar.CL();
                        return null;
                    }
                    return null;
                }
            }.execute(URL, cC(str3, "cpid"), cC(str3, "idea_id"));
        }
    }

    private String cC(String str, String str2) {
        try {
            return new JSONObject(new String(com.baidu.adp.lib.util.c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.aJc;
    }

    private int uY(String str) {
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
        al.h(this.aJa, this.gVa);
        al.h(this.aJd, this.gVb);
    }

    public void setDisPraiseViewVisibility(boolean z) {
        if (this.aFf != null) {
            this.aFf.setVisibility(z ? 0 : 8);
        }
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.gVa = e.d.cp_cont_e;
            this.aJF = e.f.icon_home_card_comment_s;
            return;
        }
        this.gVa = e.f.selector_comment_and_prise_item_text_color;
        this.aJF = e.f.icon_home_card_comment;
    }

    private boolean EG() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.Gr();
    }

    public void setPraiseContainerBgGray(boolean z) {
        if (com.baidu.tbadk.util.a.PJ().Gg()) {
            if (z) {
                this.aFe.aFt = e.f.icon_card_like_d;
                this.aFe.aFu = e.f.icon_card_like_d;
                this.aFe.aFv = e.d.cp_cont_e;
                this.aFe.aFw = e.d.cp_cont_e;
                return;
            }
            this.aFe.aFt = e.f.icon_card_like_n;
            this.aFe.aFu = e.f.icon_card_like_s;
            if (this.aFg != null && this.aFg.AU() == 1) {
                this.aFe.aFv = e.f.selector_comment_and_prise_item_text_color;
                this.aFe.aFw = e.d.cp_cont_h;
                return;
            }
            this.aFe.aFv = e.f.selector_comment_and_prise_item_text_color;
            this.aFe.aFw = e.f.selector_comment_and_prise_item_text_color;
        } else if (z) {
            this.aFe.aFt = e.f.icon_home_card_like_d;
            this.aFe.aFu = e.f.icon_home_card_like_d;
            this.aFe.aFv = e.d.cp_cont_e;
            this.aFe.aFw = e.d.cp_cont_e;
        } else {
            this.aFe.aFt = EG() ? e.f.icon_home_card_like_n_xmas : e.f.icon_home_card_like_n;
            this.aFe.aFu = EG() ? e.f.icon_home_card_like_s_xmas : e.f.icon_home_card_like_s;
            if (this.aFg != null && this.aFg.AU() == 1) {
                this.aFe.aFv = e.f.selector_comment_and_prise_item_text_color;
                this.aFe.aFw = e.d.cp_cont_h;
                return;
            }
            this.aFe.aFv = e.f.selector_comment_and_prise_item_text_color;
            this.aFe.aFw = e.f.selector_comment_and_prise_item_text_color;
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.aJG = e.f.icon_card_share_s;
            this.gVb = e.d.cp_cont_e;
            return;
        }
        this.aJG = e.f.icon_home_card_share;
        this.gVb = e.f.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void Fr() {
        super.Fr();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(gUT, 0, gUT, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(0, 0, 0, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(gUT, 0, gUT, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(0, 0, 0, 0);
        }
    }
}
