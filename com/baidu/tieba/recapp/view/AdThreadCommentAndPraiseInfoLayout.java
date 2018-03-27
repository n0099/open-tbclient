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
    public static int gIj;
    private final int gIk;
    private final int gIl;
    private final int gIm;
    private final int gIn;
    private final int gIo;
    private int gIp;
    private int gIq;
    private int gIr;
    private int gIs;
    private int gIt;
    private a gIu;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.gIk = 446;
        this.gIl = 5120;
        this.gIm = 5120;
        this.gIn = 5120;
        this.gIo = 5120;
        this.gIp = 1;
        this.type = 0;
        this.gIq = d.f.selector_comment_and_prise_item_text_color;
        this.gIr = this.bdH;
        this.gIs = this.gIq;
        this.gIt = this.gIq;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gIk = 446;
        this.gIl = 5120;
        this.gIm = 5120;
        this.gIn = 5120;
        this.gIo = 5120;
        this.gIp = 1;
        this.type = 0;
        this.gIq = d.f.selector_comment_and_prise_item_text_color;
        this.gIr = this.bdH;
        this.gIs = this.gIq;
        this.gIt = this.gIq;
        initSetting();
    }

    private void initSetting() {
        gIj = l.t(this.mContext, d.e.tbds44);
        setManageVisible(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bd bdVar) {
        super.updatePraiseNum(bdVar);
        if (this.type == 1 && this.bdd != null && this.bdt) {
            if (this.bdd.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdd.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.bdd.setLayoutParams(layoutParams);
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bdc.getLayoutParams();
            layoutParams2.leftMargin = this.bcY;
            this.bdc.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void f(bd bdVar) {
        super.f(bdVar);
        if (this.type == 1 && this.bdB && this.bdj.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdj.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.bcY;
            layoutParams.weight = 0.0f;
            this.bdj.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void e(bd bdVar) {
        super.e(bdVar);
        if (this.type == 1 && this.bdg != null && this.bdz) {
            this.bdg.setVisibility(0);
            if (this.bdg.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdg.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.bcY;
                layoutParams.weight = 0.0f;
                this.bdg.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void c(bd bdVar) {
        super.c(bdVar);
        if (this.gIp == 1) {
            this.bcZ.setText(am.e(bdVar.zt(), 12, ""));
        }
    }

    public void disableClick() {
        this.bdd.setClickable(false);
        this.bdj.setClickable(false);
        this.bdg.setClickable(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aW(View view) {
        boolean z = false;
        if (ay.ba(this.mContext) && this.aZC != null) {
            if (this.aZC.Ay() != 0) {
                a(this.gIu.getThreadData(), "nozan", 0);
                a(this.gIu.getThreadData(), "1", "2");
                this.aZC.eY(this.aZC.Ax() - 1);
                this.aZC.eX(0);
                if (this.bdb != null) {
                    aj.r(this.bdb, d.C0141d.cp_cont_f);
                    z = true;
                } else {
                    z = true;
                }
            } else {
                a(this.gIu.getThreadData(), FeedData.TYPE_ZAN, 0);
                a(this.gIu.getThreadData(), "1", "1");
                this.aZC.eX(1);
                this.aZC.eY(this.aZC.Ax() + 1);
                if (this.bdb != null) {
                    aj.r(this.bdb, d.C0141d.cp_cont_h);
                }
            }
            if (this.gIu instanceof AdCard) {
                ((AdCard) this.gIu).agree_num = this.aZC.Ax();
            }
            updatePraiseNum(this.aZC);
            if (this.bdc != null && !z) {
                this.bdc.startAnimation(getScaleAnimation());
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aX(View view) {
        a(this.gIu.getThreadData(), "share", 0);
        a(this.gIu.getThreadData(), "2", "1");
        if ((ap.nv() || ay.ba(this.mContext)) && this.aZC != null && this.mContext != null && this.gIu != null) {
            final com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = this.gIu.getTitle();
            dVar.content = this.gIu.getAbstract();
            dVar.blu = this.gIu.getTitle();
            dVar.linkUrl = this.gIu.getShareLink();
            dVar.blx = 3;
            dVar.blm = true;
            String imageUrl = this.gIu.getImageUrl();
            Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
            if (parse != null) {
                dVar.blr = parse;
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
        this.gIp = i;
    }

    public void setShareData(a aVar) {
        this.gIu = aVar;
        setData(this.gIu.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 8, i);
        c.se(str);
        b.boX().a(c);
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
                        xVar.Cb();
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
        return this.bdg;
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
        aj.r(this.bde, this.gIq);
        if (this.bdb != null && this.gIr > 0) {
            this.bdc.setImageDrawable(aj.getDrawable(this.gIr));
        }
        aj.r(this.bdb, this.gIs);
        aj.r(this.bdh, this.gIt);
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.gIq = d.C0141d.cp_cont_e;
            this.bdI = d.f.icon_home_card_comment_s;
            return;
        }
        this.gIq = d.f.selector_comment_and_prise_item_text_color;
        this.bdI = d.f.icon_home_card_comment;
    }

    public void setPraiseContainerBgGray(boolean z) {
        if (z) {
            this.gIr = d.f.icon_home_card_like_d;
            this.gIs = d.C0141d.cp_cont_e;
            return;
        }
        this.gIr = this.bdH;
        if (this.aZC != null && this.aZC.Ay() == 1 && this.bdb != null) {
            this.gIs = d.C0141d.cp_cont_h;
        } else {
            this.gIs = d.f.selector_comment_and_prise_item_text_color;
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.bdJ = d.f.icon_card_share_s;
            this.gIt = d.C0141d.cp_cont_e;
            return;
        }
        this.bdJ = d.f.icon_home_card_share;
        this.gIt = d.f.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void Et() {
        super.Et();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(gIj, 0, gIj, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(0, 0, 0, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(gIj, 0, gIj, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(0, 0, 0, 0);
        }
    }
}
