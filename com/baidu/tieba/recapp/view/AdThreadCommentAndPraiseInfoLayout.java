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
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.coreExtra.c.f;
import com.baidu.tbadk.t.bf;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.recapp.c.a;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.report.b;
import com.baidu.tieba.recapp.report.c;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdThreadCommentAndPraiseInfoLayout extends NewThreadCommentAndPraiseInfoLayout {
    public static String URL = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public static int iMn;
    private final int iMo;
    private final int iMp;
    private final int iMq;
    private final int iMr;
    private final int iMs;
    private int iMt;
    private int iMu;
    private int iMv;
    private a iMw;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.iMo = 446;
        this.iMp = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iMq = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iMr = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iMs = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iMt = 1;
        this.type = 0;
        this.iMu = R.drawable.selector_comment_and_prise_item_text_color;
        this.iMv = this.iMu;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iMo = 446;
        this.iMp = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iMq = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iMr = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iMs = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iMt = 1;
        this.type = 0;
        this.iMu = R.drawable.selector_comment_and_prise_item_text_color;
        this.iMv = this.iMu;
        initSetting();
    }

    private void initSetting() {
        iMn = l.g(this.mContext, R.dimen.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(9);
        this.cbz = false;
        ciI();
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bg bgVar) {
        AgreeData agn;
        if (bgVar != null && (agn = bgVar.agn()) != null && agn.agreeNum == 0 && agn.diffAgreeNum == 0) {
            agn.agreeNum = bgVar.afQ();
            agn.hasAgree = bgVar.afS() == 1;
            agn.agreeType = bgVar.afT();
            agn.diffAgreeNum = bgVar.afQ() - bgVar.afR();
        }
        super.updatePraiseNum(bgVar);
        if (this.cbb != null) {
            this.cbb.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type == 1 && this.bWi != null && this.cbv) {
            if (this.bWi.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWi.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.bWi.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.bWi.getImageView();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.caX;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void o(bg bgVar) {
        super.o(bgVar);
        if (this.type == 1 && this.cbB && this.cbh.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbh.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.caX;
            layoutParams.weight = 0.0f;
            this.cbh.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void p(bg bgVar) {
        super.p(bgVar);
        if (this.type == 1 && this.cbe != null && this.cbz) {
            this.cbe.setVisibility(0);
            if (this.cbe.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbe.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.caX;
                layoutParams.weight = 0.0f;
                this.cbe.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void t(bg bgVar) {
        super.t(bgVar);
        if (this.iMt == 1) {
            this.caY.setText(aq.j(bgVar.aeC(), 12, ""));
        }
    }

    public void disableClick() {
        this.bWi.setClickable(false);
        this.cbh.setClickable(false);
        this.cbe.setClickable(false);
    }

    private void ciI() {
        if (this.cbb != null) {
            this.cbb.getImgAgree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.cbb.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 2) {
                            data.agreeType = 2;
                            data.hasAgree = false;
                            data.diffAgreeNum--;
                            data.agreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.cbb.JS();
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum += 2;
                            data.agreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.cbb.eh(true);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum++;
                        data.agreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.cbb.eh(true);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.zM(i);
                }
            });
            this.cbb.getImgDisagree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.cbb.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 5) {
                            data.agreeType = 5;
                            data.hasAgree = false;
                            data.diffAgreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.cbb.JS();
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum -= 2;
                            data.agreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.cbb.eh(false);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum--;
                        data.disAgreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.cbb.eh(false);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.zM(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zM(int i) {
        if (i == 1) {
            a(this.iMw.getThreadData(), "nozan", 0);
            a(this.iMw.getThreadData(), "1", "2");
            return;
        }
        a(this.iMw.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.iMw.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aU(View view) {
        int i = 0;
        if (bd.cF(this.mContext) && this.We != null) {
            if (this.We.afS() != 0) {
                a(this.iMw.getThreadData(), "nozan", 0);
                a(this.iMw.getThreadData(), "1", "2");
                this.We.as(this.We.afQ() - 1);
                this.We.hp(0);
                this.bWi.bXb = R.color.cp_cont_f;
                this.bWi.bXc = R.color.cp_cont_f;
                i = 1;
            } else {
                a(this.iMw.getThreadData(), FeedData.TYPE_ZAN, 0);
                a(this.iMw.getThreadData(), "1", "1");
                this.We.hp(1);
                this.We.as(this.We.afQ() + 1);
                this.bWi.bXb = R.color.cp_cont_h;
                this.bWi.bXc = R.color.cp_cont_h;
            }
            if (this.iMw instanceof AdCard) {
                ((AdCard) this.iMw).agree_num = this.We.afQ();
            }
            updatePraiseNum(this.We);
            this.bWi.ix(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aR(View view) {
        if (this.We != null && this.mContext != null && this.iMw != null) {
            a(this.iMw.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.iMw.getThreadData(), "2", "1");
            if (bf.iN() || bd.cF(this.mContext)) {
                final e eVar = new e();
                eVar.title = this.iMw.getTitle();
                eVar.content = this.iMw.getAbstract();
                eVar.ckI = this.iMw.getTitle();
                eVar.linkUrl = this.iMw.getShareLink();
                eVar.ckL = 3;
                eVar.ckv = true;
                String imageUrl = this.iMw.getImageUrl();
                Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
                if (parse != null) {
                    eVar.imageUri = parse;
                }
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, eVar, true, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        eVar.linkUrl = f.cb(eVar.linkUrl, eVar.tid);
                        com.baidu.adp.lib.util.a.aS(eVar.linkUrl);
                        l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(R.string.copy_pb_url_success));
                    }
                });
                shareDialogConfig.setHideMode(Ed(eVar.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.iMt = i;
    }

    public void setShareData(a aVar) {
        this.iMw = aVar;
        setData(this.iMw.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 8, i);
        c.Ec(str);
        c.ciy().a(c);
    }

    private void a(AdvertAppInfo advertAppInfo, final String str, final String str2) {
        if (advertAppInfo != null) {
            String str3 = advertAppInfo.extensionInfo;
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr != null && strArr.length > 0) {
                        x xVar = new x(strArr[0]);
                        xVar.o("cpid", strArr[1]);
                        xVar.o("idea_id", strArr[2]);
                        xVar.o("type", str);
                        xVar.o(IntentConfig.CMD, str2);
                        xVar.aig();
                        return null;
                    }
                    return null;
                }
            }.execute(URL, ec(str3, "cpid"), ec(str3, "idea_id"));
        }
    }

    private String ec(String str, String str2) {
        try {
            return new JSONObject(new String(com.baidu.adp.lib.util.c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.cbe;
    }

    private int Ed(String str) {
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
        am.j(this.cbc, this.iMu);
        am.j(this.cbf, this.iMv);
    }

    public void setDisPraiseViewVisibility(boolean z) {
        if (this.bWj != null) {
            this.bWj.setVisibility(z ? 0 : 8);
        }
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.iMu = R.color.cp_cont_e;
            this.cbI = R.drawable.icon_home_card_comment_s;
            return;
        }
        this.iMu = R.drawable.selector_comment_and_prise_item_text_color;
        this.cbI = R.drawable.icon_home_card_comment;
    }

    private boolean akd() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.alY();
    }

    public void setPraiseContainerBgGray(boolean z) {
        if (this.bWi != null) {
            if (com.baidu.tbadk.util.a.avW().alO()) {
                if (z) {
                    this.bWi.bWZ = R.drawable.icon_card_like_d;
                    this.bWi.bXa = R.drawable.icon_card_like_d;
                    this.bWi.bXb = R.color.cp_cont_e;
                    this.bWi.bXc = R.color.cp_cont_e;
                    return;
                }
                this.bWi.bWZ = R.drawable.icon_card_like_n;
                this.bWi.bXa = R.drawable.icon_card_like_s;
                if (this.We != null && this.We.afS() == 1) {
                    this.bWi.bXb = R.drawable.selector_comment_and_prise_item_text_color;
                    this.bWi.bXc = R.color.cp_cont_h;
                    return;
                }
                this.bWi.bXb = R.drawable.selector_comment_and_prise_item_text_color;
                this.bWi.bXc = R.drawable.selector_comment_and_prise_item_text_color;
            } else if (z) {
                this.bWi.bWZ = R.drawable.icon_home_card_like_d;
                this.bWi.bXa = R.drawable.icon_home_card_like_d;
                this.bWi.bXb = R.color.cp_cont_e;
                this.bWi.bXc = R.color.cp_cont_e;
            } else {
                this.bWi.bWZ = akd() ? R.drawable.icon_home_card_like_n_xmas : R.drawable.icon_home_card_like_n;
                this.bWi.bXa = akd() ? R.drawable.icon_home_card_like_s_xmas : R.drawable.icon_home_card_like_s;
                if (this.We != null && this.We.afS() == 1) {
                    this.bWi.bXb = R.drawable.selector_comment_and_prise_item_text_color;
                    this.bWi.bXc = R.color.cp_cont_h;
                    return;
                }
                this.bWi.bXb = R.drawable.selector_comment_and_prise_item_text_color;
                this.bWi.bXc = R.drawable.selector_comment_and_prise_item_text_color;
            }
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.cbJ = R.drawable.icon_card_share_s;
            this.iMv = R.color.cp_cont_e;
            return;
        }
        this.cbJ = R.drawable.icon_home_card_share;
        this.iMv = R.drawable.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void akZ() {
        super.akZ();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(iMn, 0, iMn, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(iMn, 0, iMn, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(iMn, 0, iMn, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(iMn, 0, iMn, 0);
        }
    }
}
