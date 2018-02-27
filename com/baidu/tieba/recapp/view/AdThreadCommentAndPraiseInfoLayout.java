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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
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
    public static int gHT;
    private final int gHU;
    private final int gHV;
    private final int gHW;
    private final int gHX;
    private final int gHY;
    private int gHZ;
    private int gIa;
    private int gIb;
    private int gIc;
    private int gId;
    private a gIe;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.gHU = 446;
        this.gHV = 5120;
        this.gHW = 5120;
        this.gHX = 5120;
        this.gHY = 5120;
        this.gHZ = 1;
        this.type = 0;
        this.gIa = d.f.selector_comment_and_prise_item_text_color;
        this.gIb = this.bdF;
        this.gIc = this.gIa;
        this.gId = this.gIa;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gHU = 446;
        this.gHV = 5120;
        this.gHW = 5120;
        this.gHX = 5120;
        this.gHY = 5120;
        this.gHZ = 1;
        this.type = 0;
        this.gIa = d.f.selector_comment_and_prise_item_text_color;
        this.gIb = this.bdF;
        this.gIc = this.gIa;
        this.gId = this.gIa;
        initSetting();
    }

    private void initSetting() {
        gHT = l.t(this.mContext, d.e.tbds44);
        setManageVisible(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bd bdVar) {
        super.updatePraiseNum(bdVar);
        if (this.type == 1 && this.bdb != null && this.bdr) {
            if (this.bdb.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdb.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.bdb.setLayoutParams(layoutParams);
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bda.getLayoutParams();
            layoutParams2.leftMargin = this.bcW;
            this.bda.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void f(bd bdVar) {
        super.f(bdVar);
        if (this.type == 1 && this.bdz && this.bdh.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdh.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.bcW;
            layoutParams.weight = 0.0f;
            this.bdh.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void e(bd bdVar) {
        super.e(bdVar);
        if (this.type == 1 && this.bde != null && this.bdx) {
            this.bde.setVisibility(0);
            if (this.bde.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bde.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.bcW;
                layoutParams.weight = 0.0f;
                this.bde.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void c(bd bdVar) {
        super.c(bdVar);
        if (this.gHZ == 1) {
            this.bcX.setText(am.e(bdVar.zt(), 12, ""));
        }
    }

    public void disableClick() {
        this.bdb.setClickable(false);
        this.bdh.setClickable(false);
        this.bde.setClickable(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aW(View view) {
        boolean z = false;
        if (ay.ba(this.mContext) && this.aZA != null) {
            if (this.aZA.Ay() != 0) {
                a(this.gIe.getThreadData(), "nozan", 0);
                a(this.gIe.getThreadData(), "1", "2");
                this.aZA.eY(this.aZA.Ax() - 1);
                this.aZA.eX(0);
                if (this.bcZ != null) {
                    aj.r(this.bcZ, d.C0141d.cp_cont_f);
                    z = true;
                } else {
                    z = true;
                }
            } else {
                a(this.gIe.getThreadData(), FeedData.TYPE_ZAN, 0);
                a(this.gIe.getThreadData(), "1", "1");
                this.aZA.eX(1);
                this.aZA.eY(this.aZA.Ax() + 1);
                if (this.bcZ != null) {
                    aj.r(this.bcZ, d.C0141d.cp_cont_h);
                }
            }
            if (this.gIe instanceof AdCard) {
                ((AdCard) this.gIe).agree_num = this.aZA.Ax();
            }
            updatePraiseNum(this.aZA);
            if (this.bda != null && !z) {
                this.bda.startAnimation(getScaleAnimation());
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aX(View view) {
        a(this.gIe.getThreadData(), "share", 0);
        a(this.gIe.getThreadData(), "2", "1");
        if ((ap.nv() || ay.ba(this.mContext)) && this.aZA != null && this.mContext != null && this.gIe != null) {
            final com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = this.gIe.getTitle();
            dVar.content = this.gIe.getAbstract();
            dVar.blr = this.gIe.getTitle();
            dVar.linkUrl = this.gIe.getShareLink();
            dVar.blu = 3;
            dVar.blj = true;
            String imageUrl = this.gIe.getImageUrl();
            Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
            if (parse != null) {
                dVar.blo = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    dVar.linkUrl = e.ai(dVar.linkUrl, dVar.tid);
                    com.baidu.adp.lib.util.a.aE(dVar.linkUrl);
                    l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(d.j.copy_pb_url_success));
                }
            });
            shareDialogConfig.setHideMode(sf(dVar.linkUrl));
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void setStyle(int i) {
        this.gHZ = i;
    }

    public void setShareData(a aVar) {
        this.gIe = aVar;
        setData(this.gIe.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 8, i);
        c.se(str);
        b.boW().a(c);
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
                        xVar.Ca();
                        return null;
                    }
                    return null;
                }
            }.execute(URL, bU(str3, "cpid"), bU(str3, "idea_id"));
        }
    }

    private String bU(String str, String str2) {
        try {
            return new JSONObject(new String(c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.bde;
    }

    private int sf(String str) {
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
        aj.r(this.bdc, this.gIa);
        if (this.bcZ != null && this.gIb > 0) {
            this.bda.setImageDrawable(aj.getDrawable(this.gIb));
        }
        aj.r(this.bcZ, this.gIc);
        aj.r(this.bdf, this.gId);
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.gIa = d.C0141d.cp_cont_e;
            this.bdG = d.f.icon_home_card_comment_s;
            return;
        }
        this.gIa = d.f.selector_comment_and_prise_item_text_color;
        this.bdG = d.f.icon_home_card_comment;
    }

    public void setPraiseContainerBgGray(boolean z) {
        if (z) {
            this.gIb = d.f.icon_home_card_like_d;
            this.gIc = d.C0141d.cp_cont_e;
            return;
        }
        this.gIb = this.bdF;
        if (this.aZA != null && this.aZA.Ay() == 1 && this.bcZ != null) {
            this.gIc = d.C0141d.cp_cont_h;
        } else {
            this.gIc = d.f.selector_comment_and_prise_item_text_color;
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.bdH = d.f.icon_card_share_s;
            this.gId = d.C0141d.cp_cont_e;
            return;
        }
        this.bdH = d.f.icon_home_card_share;
        this.gId = d.f.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void Es() {
        super.Es();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(gHT, 0, gHT, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(0, 0, 0, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(gHT, 0, gHT, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(0, 0, 0, 0);
        }
    }
}
