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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.o.ar;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.recapp.c.a;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.report.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    public static String URL = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public static int gpG;
    private final int gpH;
    private final int gpI;
    private final int gpJ;
    private final int gpK;
    private final int gpL;
    private int gpM;
    private int gpN;
    private int gpO;
    private int gpP;
    private int gpQ;
    private a gpR;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.gpH = 446;
        this.gpI = 5120;
        this.gpJ = 5120;
        this.gpK = 5120;
        this.gpL = 5120;
        this.gpM = 1;
        this.type = 0;
        this.gpN = d.f.selector_comment_and_prise_item_text_color;
        this.gpO = this.axh;
        this.gpP = this.gpN;
        this.gpQ = this.gpN;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gpH = 446;
        this.gpI = 5120;
        this.gpJ = 5120;
        this.gpK = 5120;
        this.gpL = 5120;
        this.gpM = 1;
        this.type = 0;
        this.gpN = d.f.selector_comment_and_prise_item_text_color;
        this.gpO = this.axh;
        this.gpP = this.gpN;
        this.gpQ = this.gpN;
        initSetting();
    }

    private void initSetting() {
        gpG = l.e(this.mContext, d.e.tbds44);
        setManageVisible(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bd bdVar) {
        super.updatePraiseNum(bdVar);
        if (this.type == 1 && this.awD != null && this.awT) {
            if (this.awD.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awD.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.awD.setLayoutParams(layoutParams);
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.awC.getLayoutParams();
            layoutParams2.leftMargin = this.awy;
            this.awC.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void f(bd bdVar) {
        super.f(bdVar);
        if (this.type == 1 && this.axb && this.awJ.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awJ.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.awy;
            layoutParams.weight = 0.0f;
            this.awJ.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void e(bd bdVar) {
        super.e(bdVar);
        if (this.type == 1 && this.awG != null && this.awZ) {
            this.awG.setVisibility(0);
            if (this.awG.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awG.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.awy;
                layoutParams.weight = 0.0f;
                this.awG.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void c(bd bdVar) {
        super.c(bdVar);
        if (this.gpM == 1) {
            this.awz.setText(ao.e(bdVar.vr(), 12, ""));
        }
    }

    public void disableClick() {
        this.awD.setClickable(false);
        this.awJ.setClickable(false);
        this.awG.setClickable(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void E(View view) {
        boolean z = false;
        if (ba.aU(this.mContext) && this.atn != null) {
            if (this.atn.ww() != 0) {
                a(this.gpR.getThreadData(), "nozan", 0);
                a(this.gpR.getThreadData(), "1", "2");
                this.atn.bZ(this.atn.wv() - 1);
                this.atn.bY(0);
                if (this.awB != null) {
                    al.h(this.awB, d.C0141d.cp_cont_f);
                    z = true;
                } else {
                    z = true;
                }
            } else {
                a(this.gpR.getThreadData(), FeedData.TYPE_ZAN, 0);
                a(this.gpR.getThreadData(), "1", "1");
                this.atn.bY(1);
                this.atn.bZ(this.atn.wv() + 1);
                if (this.awB != null) {
                    al.h(this.awB, d.C0141d.cp_cont_h);
                }
            }
            if (this.gpR instanceof AdCard) {
                ((AdCard) this.gpR).agree_num = this.atn.wv();
            }
            updatePraiseNum(this.atn);
            if (this.awC != null && !z) {
                this.awC.startAnimation(getScaleAnimation());
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void F(View view) {
        a(this.gpR.getThreadData(), "share", 0);
        a(this.gpR.getThreadData(), "2", "1");
        if ((ar.ip() || ba.aU(this.mContext)) && this.atn != null && this.mContext != null && this.gpR != null) {
            final com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = this.gpR.getTitle();
            dVar.content = this.gpR.getAbstract();
            dVar.aFm = this.gpR.getTitle();
            dVar.linkUrl = this.gpR.getShareLink();
            dVar.aFp = 3;
            dVar.aFd = true;
            String imageUrl = this.gpR.getImageUrl();
            Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
            if (parse != null) {
                dVar.aFj = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    dVar.linkUrl = e.an(dVar.linkUrl, dVar.tid);
                    com.baidu.adp.lib.util.a.aN(dVar.linkUrl);
                    l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(d.k.copy_pb_url_success));
                }
            });
            shareDialogConfig.setHideMode(th(dVar.linkUrl));
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void setStyle(int i) {
        this.gpM = i;
    }

    public void setShareData(a aVar) {
        this.gpR = aVar;
        setData(this.gpR.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(advertAppInfo, 8, i);
        c.tg(str);
        b.bpc().a(c);
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
                        yVar.yl();
                        return null;
                    }
                    return null;
                }
            }.execute(URL, cb(str3, "cpid"), cb(str3, "idea_id"));
        }
    }

    private String cb(String str, String str2) {
        try {
            return new JSONObject(new String(c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.awG;
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
        al.h(this.awE, this.gpN);
        if (this.awB != null && this.gpO > 0) {
            this.awC.setImageDrawable(al.getDrawable(this.gpO));
        }
        al.h(this.awB, this.gpP);
        al.h(this.awH, this.gpQ);
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.gpN = d.C0141d.cp_cont_e;
            this.axi = d.f.icon_home_card_comment_s;
            return;
        }
        this.gpN = d.f.selector_comment_and_prise_item_text_color;
        this.axi = d.f.icon_home_card_comment;
    }

    public void setPraiseContainerBgGray(boolean z) {
        if (z) {
            this.gpO = d.f.icon_home_card_like_d;
            this.gpP = d.C0141d.cp_cont_e;
            return;
        }
        this.gpO = this.axh;
        if (this.atn != null && this.atn.ww() == 1 && this.awB != null) {
            this.gpP = d.C0141d.cp_cont_h;
        } else {
            this.gpP = d.f.selector_comment_and_prise_item_text_color;
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.axj = d.f.icon_card_share_s;
            this.gpQ = d.C0141d.cp_cont_e;
            return;
        }
        this.axj = d.f.icon_home_card_share;
        this.gpQ = d.f.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void AE() {
        super.AE();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(gpG, 0, gpG, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(0, 0, 0, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(gpG, 0, gpG, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(0, 0, 0, 0);
        }
    }
}
