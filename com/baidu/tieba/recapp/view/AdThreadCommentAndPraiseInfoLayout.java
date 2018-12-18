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
    public static int gRX;
    private final int gRY;
    private final int gRZ;
    private final int gSa;
    private final int gSb;
    private final int gSc;
    private int gSd;
    private int gSe;
    private int gSf;
    private a gSg;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.gRY = 446;
        this.gRZ = 5120;
        this.gSa = 5120;
        this.gSb = 5120;
        this.gSc = 5120;
        this.gSd = 1;
        this.type = 0;
        this.gSe = e.f.selector_comment_and_prise_item_text_color;
        this.gSf = this.gSe;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gRY = 446;
        this.gRZ = 5120;
        this.gSa = 5120;
        this.gSb = 5120;
        this.gSc = 5120;
        this.gSd = 1;
        this.type = 0;
        this.gSe = e.f.selector_comment_and_prise_item_text_color;
        this.gSf = this.gSe;
        initSetting();
    }

    private void initSetting() {
        gRX = l.h(this.mContext, e.C0210e.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bb bbVar) {
        super.updatePraiseNum(bbVar);
        if (this.type == 1 && this.aFd != null && this.aJs) {
            if (this.aFd.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aFd.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.aFd.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.aFd.getImageView();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.aIV;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void h(bb bbVar) {
        super.h(bbVar);
        if (this.type == 1 && this.aJy && this.aJe.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJe.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.aIV;
            layoutParams.weight = 0.0f;
            this.aJe.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void g(bb bbVar) {
        super.g(bbVar);
        if (this.type == 1 && this.aJb != null && this.aJw) {
            this.aJb.setVisibility(0);
            if (this.aJb.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJb.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.aIV;
                layoutParams.weight = 0.0f;
                this.aJb.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void d(bb bbVar) {
        super.d(bbVar);
        if (this.gSd == 1) {
            this.aIW.setText(ao.d(bbVar.zM(), 12, ""));
        }
    }

    public void disableClick() {
        this.aFd.setClickable(false);
        this.aJe.setClickable(false);
        this.aJb.setClickable(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void P(View view) {
        int i = 0;
        if (ba.bJ(this.mContext) && this.aFf != null) {
            if (this.aFf.AU() != 0) {
                a(this.gSg.getThreadData(), "nozan", 0);
                a(this.gSg.getThreadData(), "1", "2");
                this.aFf.C(this.aFf.AS() - 1);
                this.aFf.cW(0);
                this.aFd.aFu = e.d.cp_cont_f;
                this.aFd.aFv = e.d.cp_cont_f;
                i = 1;
            } else {
                a(this.gSg.getThreadData(), FeedData.TYPE_ZAN, 0);
                a(this.gSg.getThreadData(), "1", "1");
                this.aFf.cW(1);
                this.aFf.C(this.aFf.AS() + 1);
                this.aFd.aFu = e.d.cp_cont_h;
                this.aFd.aFv = e.d.cp_cont_h;
            }
            if (this.gSg instanceof AdCard) {
                ((AdCard) this.gSg).agree_num = this.aFf.AS();
            }
            updatePraiseNum(this.aFf);
            this.aFd.dZ(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void O(View view) {
        if (this.aFf != null && this.mContext != null && this.gSg != null) {
            a(this.gSg.getThreadData(), "share", 0);
            a(this.gSg.getThreadData(), "2", "1");
            if (ax.jJ() || ba.bJ(this.mContext)) {
                final d dVar = new d();
                dVar.title = this.gSg.getTitle();
                dVar.content = this.gSg.getAbstract();
                dVar.aSj = this.gSg.getTitle();
                dVar.linkUrl = this.gSg.getShareLink();
                dVar.aSm = 3;
                dVar.aSb = true;
                String imageUrl = this.gSg.getImageUrl();
                Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
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
                shareDialogConfig.setHideMode(uV(dVar.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.gSd = i;
    }

    public void setShareData(a aVar) {
        this.gSg = aVar;
        setData(this.gSg.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        b c = f.c(advertAppInfo, 8, i);
        c.uU(str);
        c.bvt().a(c);
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
        return this.aJb;
    }

    private int uV(String str) {
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
        al.h(this.aIZ, this.gSe);
        al.h(this.aJc, this.gSf);
    }

    public void setDisPraiseViewVisibility(boolean z) {
        if (this.aFe != null) {
            this.aFe.setVisibility(z ? 0 : 8);
        }
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.gSe = e.d.cp_cont_e;
            this.aJD = e.f.icon_home_card_comment_s;
            return;
        }
        this.gSe = e.f.selector_comment_and_prise_item_text_color;
        this.aJD = e.f.icon_home_card_comment;
    }

    private boolean EG() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.Gq();
    }

    public void setPraiseContainerBgGray(boolean z) {
        if (com.baidu.tbadk.util.a.PH().Gf()) {
            if (z) {
                this.aFd.aFs = e.f.icon_card_like_d;
                this.aFd.aFt = e.f.icon_card_like_d;
                this.aFd.aFu = e.d.cp_cont_e;
                this.aFd.aFv = e.d.cp_cont_e;
                return;
            }
            this.aFd.aFs = e.f.icon_card_like_n;
            this.aFd.aFt = e.f.icon_card_like_s;
            if (this.aFf != null && this.aFf.AU() == 1) {
                this.aFd.aFu = e.f.selector_comment_and_prise_item_text_color;
                this.aFd.aFv = e.d.cp_cont_h;
                return;
            }
            this.aFd.aFu = e.f.selector_comment_and_prise_item_text_color;
            this.aFd.aFv = e.f.selector_comment_and_prise_item_text_color;
        } else if (z) {
            this.aFd.aFs = e.f.icon_home_card_like_d;
            this.aFd.aFt = e.f.icon_home_card_like_d;
            this.aFd.aFu = e.d.cp_cont_e;
            this.aFd.aFv = e.d.cp_cont_e;
        } else {
            this.aFd.aFs = EG() ? e.f.icon_home_card_like_n_xmas : e.f.icon_home_card_like_n;
            this.aFd.aFt = EG() ? e.f.icon_home_card_like_s_xmas : e.f.icon_home_card_like_s;
            if (this.aFf != null && this.aFf.AU() == 1) {
                this.aFd.aFu = e.f.selector_comment_and_prise_item_text_color;
                this.aFd.aFv = e.d.cp_cont_h;
                return;
            }
            this.aFd.aFu = e.f.selector_comment_and_prise_item_text_color;
            this.aFd.aFv = e.f.selector_comment_and_prise_item_text_color;
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.aJE = e.f.icon_card_share_s;
            this.gSf = e.d.cp_cont_e;
            return;
        }
        this.aJE = e.f.icon_home_card_share;
        this.gSf = e.f.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void Fq() {
        super.Fq();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(gRX, 0, gRX, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(0, 0, 0, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(gRX, 0, gRX, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(0, 0, 0, 0);
        }
    }
}
