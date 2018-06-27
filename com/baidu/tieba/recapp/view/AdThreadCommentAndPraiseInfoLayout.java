package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.o.as;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.recapp.c.a;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.report.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    public static String URL = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public static int gty;
    private final int gtA;
    private final int gtB;
    private final int gtC;
    private final int gtD;
    private int gtE;
    private int gtF;
    private int gtG;
    private int gtH;
    private int gtI;
    private a gtJ;
    private final int gtz;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.gtz = 446;
        this.gtA = 5120;
        this.gtB = 5120;
        this.gtC = 5120;
        this.gtD = 5120;
        this.gtE = 1;
        this.type = 0;
        this.gtF = d.f.selector_comment_and_prise_item_text_color;
        this.gtG = this.axU;
        this.gtH = this.gtF;
        this.gtI = this.gtF;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gtz = 446;
        this.gtA = 5120;
        this.gtB = 5120;
        this.gtC = 5120;
        this.gtD = 5120;
        this.gtE = 1;
        this.type = 0;
        this.gtF = d.f.selector_comment_and_prise_item_text_color;
        this.gtG = this.axU;
        this.gtH = this.gtF;
        this.gtI = this.gtF;
        initSetting();
    }

    private void initSetting() {
        gty = l.e(this.mContext, d.e.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bc bcVar) {
        super.updatePraiseNum(bcVar);
        if (this.type == 1 && this.axm != null && this.axF) {
            if (this.axm.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axm.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.axm.setLayoutParams(layoutParams);
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.axl.getLayoutParams();
            layoutParams2.leftMargin = this.axh;
            this.axl.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void g(bc bcVar) {
        super.g(bcVar);
        if (this.type == 1 && this.axN && this.axs.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axs.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.axh;
            layoutParams.weight = 0.0f;
            this.axs.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void f(bc bcVar) {
        super.f(bcVar);
        if (this.type == 1 && this.axp != null && this.axL) {
            this.axp.setVisibility(0);
            if (this.axp.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axp.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.axh;
                layoutParams.weight = 0.0f;
                this.axp.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void c(bc bcVar) {
        super.c(bcVar);
        if (this.gtE == 1) {
            this.axi.setText(ap.e(bcVar.vB(), 12, ""));
        }
    }

    public void disableClick() {
        this.axm.setClickable(false);
        this.axs.setClickable(false);
        this.axp.setClickable(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void F(View view) {
        boolean z = false;
        if (bb.aU(this.mContext) && this.atZ != null) {
            if (this.atZ.wG() != 0) {
                a(this.gtJ.getThreadData(), "nozan", 0);
                a(this.gtJ.getThreadData(), "1", "2");
                this.atZ.ca(this.atZ.wF() - 1);
                this.atZ.bZ(0);
                if (this.axk != null) {
                    am.h(this.axk, d.C0142d.cp_cont_f);
                    z = true;
                } else {
                    z = true;
                }
            } else {
                a(this.gtJ.getThreadData(), FeedData.TYPE_ZAN, 0);
                a(this.gtJ.getThreadData(), "1", "1");
                this.atZ.bZ(1);
                this.atZ.ca(this.atZ.wF() + 1);
                if (this.axk != null) {
                    am.h(this.axk, d.C0142d.cp_cont_h);
                }
            }
            if (this.gtJ instanceof AdCard) {
                ((AdCard) this.gtJ).agree_num = this.atZ.wF();
            }
            updatePraiseNum(this.atZ);
            if (this.axl != null && !z) {
                this.axl.startAnimation(getScaleAnimation());
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void G(View view) {
        a(this.gtJ.getThreadData(), "share", 0);
        a(this.gtJ.getThreadData(), "2", "1");
        if ((as.ip() || bb.aU(this.mContext)) && this.atZ != null && this.mContext != null && this.gtJ != null) {
            final com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = this.gtJ.getTitle();
            dVar.content = this.gtJ.getAbstract();
            dVar.aGf = this.gtJ.getTitle();
            dVar.linkUrl = this.gtJ.getShareLink();
            dVar.aGi = 3;
            dVar.aFX = true;
            String imageUrl = this.gtJ.getImageUrl();
            Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    dVar.linkUrl = e.an(dVar.linkUrl, dVar.tid);
                    com.baidu.adp.lib.util.a.aP(dVar.linkUrl);
                    l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(d.k.copy_pb_url_success));
                }
            });
            shareDialogConfig.setHideMode(tg(dVar.linkUrl));
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void setStyle(int i) {
        this.gtE = i;
    }

    public void setShareData(a aVar) {
        this.gtJ = aVar;
        setData(this.gtJ.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 8, i);
        c.tf(str);
        b.bpD().a(c);
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
                        y yVar = new y(strArr[0]);
                        yVar.o("cpid", strArr[1]);
                        yVar.o("idea_id", strArr[2]);
                        yVar.o("type", str);
                        yVar.o(IntentConfig.CMD, str2);
                        yVar.yz();
                        return null;
                    }
                    return null;
                }
            }.execute(URL, cf(str3, "cpid"), cf(str3, "idea_id"));
        }
    }

    private String cf(String str, String str2) {
        try {
            return new JSONObject(new String(c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.axp;
    }

    private int tg(String str) {
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
        am.h(this.axn, this.gtF);
        if (this.axk != null && this.gtG > 0) {
            this.axl.setImageDrawable(am.getDrawable(this.gtG));
        }
        am.h(this.axk, this.gtH);
        am.h(this.axq, this.gtI);
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.gtF = d.C0142d.cp_cont_e;
            this.axV = d.f.icon_home_card_comment_s;
            return;
        }
        this.gtF = d.f.selector_comment_and_prise_item_text_color;
        this.axV = d.f.icon_home_card_comment;
    }

    public void setPraiseContainerBgGray(boolean z) {
        if (z) {
            this.gtG = d.f.icon_home_card_like_d;
            this.gtH = d.C0142d.cp_cont_e;
            return;
        }
        this.gtG = this.axU;
        if (this.atZ != null && this.atZ.wG() == 1 && this.axk != null) {
            this.gtH = d.C0142d.cp_cont_h;
        } else {
            this.gtH = d.f.selector_comment_and_prise_item_text_color;
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.axW = d.f.icon_card_share_s;
            this.gtI = d.C0142d.cp_cont_e;
            return;
        }
        this.axW = d.f.icon_home_card_share;
        this.gtI = d.f.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void AW() {
        super.AW();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(gty, 0, gty, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(0, 0, 0, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(gty, 0, gty, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(0, 0, 0, 0);
        }
    }
}
