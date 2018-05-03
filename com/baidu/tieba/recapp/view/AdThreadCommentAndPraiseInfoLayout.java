package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.o.ap;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.recapp.c.a;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.report.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    public static String URL = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public static int gdg;
    private final int gdh;
    private final int gdi;
    private final int gdj;
    private final int gdk;
    private final int gdl;
    private int gdm;
    private int gdn;
    private int gdo;
    private int gdp;
    private int gdq;
    private a gdr;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.gdh = 446;
        this.gdi = 5120;
        this.gdj = 5120;
        this.gdk = 5120;
        this.gdl = 5120;
        this.gdm = 1;
        this.type = 0;
        this.gdn = d.f.selector_comment_and_prise_item_text_color;
        this.gdo = this.aoZ;
        this.gdp = this.gdn;
        this.gdq = this.gdn;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gdh = 446;
        this.gdi = 5120;
        this.gdj = 5120;
        this.gdk = 5120;
        this.gdl = 5120;
        this.gdm = 1;
        this.type = 0;
        this.gdn = d.f.selector_comment_and_prise_item_text_color;
        this.gdo = this.aoZ;
        this.gdp = this.gdn;
        this.gdq = this.gdn;
        initSetting();
    }

    private void initSetting() {
        gdg = l.e(this.mContext, d.e.tbds44);
        setManageVisible(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bd bdVar) {
        super.updatePraiseNum(bdVar);
        if (this.type == 1 && this.aov != null && this.aoL) {
            if (this.aov.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aov.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.aov.setLayoutParams(layoutParams);
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aou.getLayoutParams();
            layoutParams2.leftMargin = this.aoq;
            this.aou.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void f(bd bdVar) {
        super.f(bdVar);
        if (this.type == 1 && this.aoT && this.aoB.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aoB.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.aoq;
            layoutParams.weight = 0.0f;
            this.aoB.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void e(bd bdVar) {
        super.e(bdVar);
        if (this.type == 1 && this.aoy != null && this.aoR) {
            this.aoy.setVisibility(0);
            if (this.aoy.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aoy.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.aoq;
                layoutParams.weight = 0.0f;
                this.aoy.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void c(bd bdVar) {
        super.c(bdVar);
        if (this.gdm == 1) {
            this.aor.setText(an.e(bdVar.rV(), 12, ""));
        }
    }

    public void disableClick() {
        this.aov.setClickable(false);
        this.aoB.setClickable(false);
        this.aoy.setClickable(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void E(View view2) {
        boolean z = false;
        if (az.aK(this.mContext) && this.alf != null) {
            if (this.alf.ta() != 0) {
                a(this.gdr.getThreadData(), "nozan", 0);
                a(this.gdr.getThreadData(), "1", "2");
                this.alf.bW(this.alf.sZ() - 1);
                this.alf.bV(0);
                if (this.aot != null) {
                    ak.h(this.aot, d.C0126d.cp_cont_f);
                    z = true;
                } else {
                    z = true;
                }
            } else {
                a(this.gdr.getThreadData(), FeedData.TYPE_ZAN, 0);
                a(this.gdr.getThreadData(), "1", "1");
                this.alf.bV(1);
                this.alf.bW(this.alf.sZ() + 1);
                if (this.aot != null) {
                    ak.h(this.aot, d.C0126d.cp_cont_h);
                }
            }
            if (this.gdr instanceof AdCard) {
                ((AdCard) this.gdr).agree_num = this.alf.sZ();
            }
            updatePraiseNum(this.alf);
            if (this.aou != null && !z) {
                this.aou.startAnimation(getScaleAnimation());
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void F(View view2) {
        a(this.gdr.getThreadData(), "share", 0);
        a(this.gdr.getThreadData(), "2", "1");
        if ((ap.fz() || az.aK(this.mContext)) && this.alf != null && this.mContext != null && this.gdr != null) {
            final com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = this.gdr.getTitle();
            dVar.content = this.gdr.getAbstract();
            dVar.awY = this.gdr.getTitle();
            dVar.linkUrl = this.gdr.getShareLink();
            dVar.axb = 3;
            dVar.awQ = true;
            String imageUrl = this.gdr.getImageUrl();
            Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
            if (parse != null) {
                dVar.awV = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    dVar.linkUrl = e.aj(dVar.linkUrl, dVar.tid);
                    com.baidu.adp.lib.util.a.aB(dVar.linkUrl);
                    l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view3.getResources().getString(d.k.copy_pb_url_success));
                }
            });
            shareDialogConfig.setHideMode(sm(dVar.linkUrl));
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void setStyle(int i) {
        this.gdm = i;
    }

    public void setShareData(a aVar) {
        this.gdr = aVar;
        setData(this.gdr.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 8, i);
        c.sl(str);
        b.bke().a(c);
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
                        xVar.n("cpid", strArr[1]);
                        xVar.n("idea_id", strArr[2]);
                        xVar.n("type", str);
                        xVar.n(IntentConfig.CMD, str2);
                        xVar.uL();
                        return null;
                    }
                    return null;
                }
            }.execute(URL, bT(str3, "cpid"), bT(str3, "idea_id"));
        }
    }

    private String bT(String str, String str2) {
        try {
            return new JSONObject(new String(c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.aoy;
    }

    private int sm(String str) {
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
        ak.h(this.aow, this.gdn);
        if (this.aot != null && this.gdo > 0) {
            this.aou.setImageDrawable(ak.getDrawable(this.gdo));
        }
        ak.h(this.aot, this.gdp);
        ak.h(this.aoz, this.gdq);
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.gdn = d.C0126d.cp_cont_e;
            this.apa = d.f.icon_home_card_comment_s;
            return;
        }
        this.gdn = d.f.selector_comment_and_prise_item_text_color;
        this.apa = d.f.icon_home_card_comment;
    }

    public void setPraiseContainerBgGray(boolean z) {
        if (z) {
            this.gdo = d.f.icon_home_card_like_d;
            this.gdp = d.C0126d.cp_cont_e;
            return;
        }
        this.gdo = this.aoZ;
        if (this.alf != null && this.alf.ta() == 1 && this.aot != null) {
            this.gdp = d.C0126d.cp_cont_h;
        } else {
            this.gdp = d.f.selector_comment_and_prise_item_text_color;
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.apb = d.f.icon_card_share_s;
            this.gdq = d.C0126d.cp_cont_e;
            return;
        }
        this.apb = d.f.icon_home_card_share;
        this.gdq = d.f.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void xe() {
        super.xe();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(gdg, 0, gdg, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(0, 0, 0, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(gdg, 0, gdg, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(0, 0, 0, 0);
        }
    }
}
