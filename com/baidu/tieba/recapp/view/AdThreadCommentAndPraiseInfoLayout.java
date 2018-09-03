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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.p.at;
import com.baidu.tieba.f;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.recapp.c.a;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.report.b;
import com.baidu.tieba.recapp.report.c;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    public static String URL = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public static int guO;
    private final int guP;
    private final int guQ;
    private final int guR;
    private final int guS;
    private final int guT;
    private int guU;
    private int guV;
    private int guW;
    private int guX;
    private int guY;
    private a guZ;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.guP = 446;
        this.guQ = 5120;
        this.guR = 5120;
        this.guS = 5120;
        this.guT = 5120;
        this.guU = 1;
        this.type = 0;
        this.guV = f.C0146f.selector_comment_and_prise_item_text_color;
        this.guW = this.axx;
        this.guX = this.guV;
        this.guY = this.guV;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.guP = 446;
        this.guQ = 5120;
        this.guR = 5120;
        this.guS = 5120;
        this.guT = 5120;
        this.guU = 1;
        this.type = 0;
        this.guV = f.C0146f.selector_comment_and_prise_item_text_color;
        this.guW = this.axx;
        this.guX = this.guV;
        this.guY = this.guV;
        initSetting();
    }

    private void initSetting() {
        guO = l.f(this.mContext, f.e.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bb bbVar) {
        super.updatePraiseNum(bbVar);
        if (this.type == 1 && this.awP != null && this.axi) {
            if (this.awP.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awP.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.awP.setLayoutParams(layoutParams);
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.awO.getLayoutParams();
            layoutParams2.leftMargin = this.awK;
            this.awO.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void g(bb bbVar) {
        super.g(bbVar);
        if (this.type == 1 && this.axq && this.awV.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awV.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.awK;
            layoutParams.weight = 0.0f;
            this.awV.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void f(bb bbVar) {
        super.f(bbVar);
        if (this.type == 1 && this.awS != null && this.axo) {
            this.awS.setVisibility(0);
            if (this.awS.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awS.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.awK;
                layoutParams.weight = 0.0f;
                this.awS.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void c(bb bbVar) {
        super.c(bbVar);
        if (this.guU == 1) {
            this.awL.setText(ap.d(bbVar.vp(), 12, ""));
        }
    }

    public void disableClick() {
        this.awP.setClickable(false);
        this.awV.setClickable(false);
        this.awS.setClickable(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void F(View view) {
        boolean z = false;
        if (com.baidu.tbadk.core.util.bb.aU(this.mContext) && this.atE != null) {
            if (this.atE.wu() != 0) {
                a(this.guZ.getThreadData(), "nozan", 0);
                a(this.guZ.getThreadData(), "1", "2");
                this.atE.cc(this.atE.wt() - 1);
                this.atE.cb(0);
                if (this.awN != null) {
                    am.h(this.awN, f.d.cp_cont_f);
                    z = true;
                } else {
                    z = true;
                }
            } else {
                a(this.guZ.getThreadData(), FeedData.TYPE_ZAN, 0);
                a(this.guZ.getThreadData(), "1", "1");
                this.atE.cb(1);
                this.atE.cc(this.atE.wt() + 1);
                if (this.awN != null) {
                    am.h(this.awN, f.d.cp_cont_h);
                }
            }
            if (this.guZ instanceof AdCard) {
                ((AdCard) this.guZ).agree_num = this.atE.wt();
            }
            updatePraiseNum(this.atE);
            if (this.awO != null && !z) {
                this.awO.startAnimation(getScaleAnimation());
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void G(View view) {
        a(this.guZ.getThreadData(), "share", 0);
        a(this.guZ.getThreadData(), "2", "1");
        if ((at.iq() || com.baidu.tbadk.core.util.bb.aU(this.mContext)) && this.atE != null && this.mContext != null && this.guZ != null) {
            final d dVar = new d();
            dVar.title = this.guZ.getTitle();
            dVar.content = this.guZ.getAbstract();
            dVar.aGe = this.guZ.getTitle();
            dVar.linkUrl = this.guZ.getShareLink();
            dVar.aGh = 3;
            dVar.aFW = true;
            String imageUrl = this.guZ.getImageUrl();
            Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    dVar.linkUrl = e.ak(dVar.linkUrl, dVar.tid);
                    com.baidu.adp.lib.util.a.aQ(dVar.linkUrl);
                    l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(f.j.copy_pb_url_success));
                }
            });
            shareDialogConfig.setHideMode(th(dVar.linkUrl));
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void setStyle(int i) {
        this.guU = i;
    }

    public void setShareData(a aVar) {
        this.guZ = aVar;
        setData(this.guZ.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 8, i);
        c.tg(str);
        c.boj().a(c);
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
                        yVar.yo();
                        return null;
                    }
                    return null;
                }
            }.execute(URL, cc(str3, "cpid"), cc(str3, "idea_id"));
        }
    }

    private String cc(String str, String str2) {
        try {
            return new JSONObject(new String(com.baidu.adp.lib.util.c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.awS;
    }

    private int th(String str) {
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
        am.h(this.awQ, this.guV);
        if (this.awN != null && this.guW > 0) {
            this.awO.setImageDrawable(am.getDrawable(this.guW));
        }
        am.h(this.awN, this.guX);
        am.h(this.awT, this.guY);
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.guV = f.d.cp_cont_e;
            this.axy = f.C0146f.icon_home_card_comment_s;
            return;
        }
        this.guV = f.C0146f.selector_comment_and_prise_item_text_color;
        this.axy = f.C0146f.icon_home_card_comment;
    }

    public void setPraiseContainerBgGray(boolean z) {
        if (z) {
            this.guW = f.C0146f.icon_home_card_like_d;
            this.guX = f.d.cp_cont_e;
            return;
        }
        this.guW = this.axx;
        if (this.atE != null && this.atE.wu() == 1 && this.awN != null) {
            this.guX = f.d.cp_cont_h;
        } else {
            this.guX = f.C0146f.selector_comment_and_prise_item_text_color;
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.axz = f.C0146f.icon_card_share_s;
            this.guY = f.d.cp_cont_e;
            return;
        }
        this.axz = f.C0146f.icon_home_card_share;
        this.guY = f.C0146f.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void AK() {
        super.AK();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(guO, 0, guO, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(0, 0, 0, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(guO, 0, guO, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(0, 0, 0, 0);
        }
    }
}
