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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.p.at;
import com.baidu.tieba.d;
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
    public static int guL;
    private final int guM;
    private final int guN;
    private final int guO;
    private final int guP;
    private final int guQ;
    private int guR;
    private int guS;
    private int guT;
    private int guU;
    private int guV;
    private a guW;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.guM = 446;
        this.guN = 5120;
        this.guO = 5120;
        this.guP = 5120;
        this.guQ = 5120;
        this.guR = 1;
        this.type = 0;
        this.guS = d.f.selector_comment_and_prise_item_text_color;
        this.guT = this.axA;
        this.guU = this.guS;
        this.guV = this.guS;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.guM = 446;
        this.guN = 5120;
        this.guO = 5120;
        this.guP = 5120;
        this.guQ = 5120;
        this.guR = 1;
        this.type = 0;
        this.guS = d.f.selector_comment_and_prise_item_text_color;
        this.guT = this.axA;
        this.guU = this.guS;
        this.guV = this.guS;
        initSetting();
    }

    private void initSetting() {
        guL = l.f(this.mContext, d.e.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bb bbVar) {
        super.updatePraiseNum(bbVar);
        if (this.type == 1 && this.awS != null && this.axl) {
            if (this.awS.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awS.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.awS.setLayoutParams(layoutParams);
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.awR.getLayoutParams();
            layoutParams2.leftMargin = this.awN;
            this.awR.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void g(bb bbVar) {
        super.g(bbVar);
        if (this.type == 1 && this.axt && this.awY.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awY.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.awN;
            layoutParams.weight = 0.0f;
            this.awY.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void f(bb bbVar) {
        super.f(bbVar);
        if (this.type == 1 && this.awV != null && this.axr) {
            this.awV.setVisibility(0);
            if (this.awV.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awV.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.awN;
                layoutParams.weight = 0.0f;
                this.awV.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void c(bb bbVar) {
        super.c(bbVar);
        if (this.guR == 1) {
            this.awO.setText(ap.e(bbVar.vq(), 12, ""));
        }
    }

    public void disableClick() {
        this.awS.setClickable(false);
        this.awY.setClickable(false);
        this.awV.setClickable(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void F(View view) {
        boolean z = false;
        if (ba.aV(this.mContext) && this.atD != null) {
            if (this.atD.wv() != 0) {
                a(this.guW.getThreadData(), "nozan", 0);
                a(this.guW.getThreadData(), "1", "2");
                this.atD.cc(this.atD.wu() - 1);
                this.atD.cb(0);
                if (this.awQ != null) {
                    am.h(this.awQ, d.C0140d.cp_cont_f);
                    z = true;
                } else {
                    z = true;
                }
            } else {
                a(this.guW.getThreadData(), FeedData.TYPE_ZAN, 0);
                a(this.guW.getThreadData(), "1", "1");
                this.atD.cb(1);
                this.atD.cc(this.atD.wu() + 1);
                if (this.awQ != null) {
                    am.h(this.awQ, d.C0140d.cp_cont_h);
                }
            }
            if (this.guW instanceof AdCard) {
                ((AdCard) this.guW).agree_num = this.atD.wu();
            }
            updatePraiseNum(this.atD);
            if (this.awR != null && !z) {
                this.awR.startAnimation(getScaleAnimation());
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void G(View view) {
        a(this.guW.getThreadData(), "share", 0);
        a(this.guW.getThreadData(), "2", "1");
        if ((at.iq() || ba.aV(this.mContext)) && this.atD != null && this.mContext != null && this.guW != null) {
            final com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = this.guW.getTitle();
            dVar.content = this.guW.getAbstract();
            dVar.aGf = this.guW.getTitle();
            dVar.linkUrl = this.guW.getShareLink();
            dVar.aGi = 3;
            dVar.aFX = true;
            String imageUrl = this.guW.getImageUrl();
            Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    dVar.linkUrl = e.al(dVar.linkUrl, dVar.tid);
                    com.baidu.adp.lib.util.a.aQ(dVar.linkUrl);
                    l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(d.j.copy_pb_url_success));
                }
            });
            shareDialogConfig.setHideMode(td(dVar.linkUrl));
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void setStyle(int i) {
        this.guR = i;
    }

    public void setShareData(a aVar) {
        this.guW = aVar;
        setData(this.guW.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        b c = f.c(advertAppInfo, 8, i);
        c.tc(str);
        c.boi().a(c);
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
                        yVar.yq();
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
        return this.awV;
    }

    private int td(String str) {
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
        am.h(this.awT, this.guS);
        if (this.awQ != null && this.guT > 0) {
            this.awR.setImageDrawable(am.getDrawable(this.guT));
        }
        am.h(this.awQ, this.guU);
        am.h(this.awW, this.guV);
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.guS = d.C0140d.cp_cont_e;
            this.axB = d.f.icon_home_card_comment_s;
            return;
        }
        this.guS = d.f.selector_comment_and_prise_item_text_color;
        this.axB = d.f.icon_home_card_comment;
    }

    public void setPraiseContainerBgGray(boolean z) {
        if (z) {
            this.guT = d.f.icon_home_card_like_d;
            this.guU = d.C0140d.cp_cont_e;
            return;
        }
        this.guT = this.axA;
        if (this.atD != null && this.atD.wv() == 1 && this.awQ != null) {
            this.guU = d.C0140d.cp_cont_h;
        } else {
            this.guU = d.f.selector_comment_and_prise_item_text_color;
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.axC = d.f.icon_card_share_s;
            this.guV = d.C0140d.cp_cont_e;
            return;
        }
        this.axC = d.f.icon_home_card_share;
        this.guV = d.f.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void AN() {
        super.AN();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(guL, 0, guL, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(0, 0, 0, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(guL, 0, guL, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(0, 0, 0, 0);
        }
    }
}
