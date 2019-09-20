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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
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
    public static int iPN;
    private final int iPO;
    private final int iPP;
    private final int iPQ;
    private final int iPR;
    private final int iPS;
    private int iPT;
    private int iPU;
    private int iPV;
    private a iPW;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.iPO = 446;
        this.iPP = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iPQ = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iPR = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iPS = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iPT = 1;
        this.type = 0;
        this.iPU = R.drawable.selector_comment_and_prise_item_text_color;
        this.iPV = this.iPU;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iPO = 446;
        this.iPP = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iPQ = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iPR = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iPS = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iPT = 1;
        this.type = 0;
        this.iPU = R.drawable.selector_comment_and_prise_item_text_color;
        this.iPV = this.iPU;
        initSetting();
    }

    private void initSetting() {
        iPN = l.g(this.mContext, R.dimen.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(9);
        this.ccA = false;
        cjO();
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bh bhVar) {
        AgreeData ags;
        if (bhVar != null && (ags = bhVar.ags()) != null && ags.agreeNum == 0 && ags.diffAgreeNum == 0) {
            ags.agreeNum = bhVar.afV();
            ags.hasAgree = bhVar.afX() == 1;
            ags.agreeType = bhVar.afY();
            ags.diffAgreeNum = bhVar.afV() - bhVar.afW();
        }
        super.updatePraiseNum(bhVar);
        if (this.ccb != null) {
            this.ccb.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type == 1 && this.bXh != null && this.ccw) {
            if (this.bXh.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bXh.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.bXh.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.bXh.getImageView();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.cbX;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void q(bh bhVar) {
        super.q(bhVar);
        if (this.type == 1 && this.ccC && this.cch.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cch.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.cbX;
            layoutParams.weight = 0.0f;
            this.cch.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void r(bh bhVar) {
        super.r(bhVar);
        if (this.type == 1 && this.cce != null && this.ccA) {
            this.cce.setVisibility(0);
            if (this.cce.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cce.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.cbX;
                layoutParams.weight = 0.0f;
                this.cce.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void v(bh bhVar) {
        super.v(bhVar);
        if (this.iPT == 1) {
            this.cbY.setText(aq.j(bhVar.aeH(), 12, ""));
        }
    }

    public void disableClick() {
        this.bXh.setClickable(false);
        this.cch.setClickable(false);
        this.cce.setClickable(false);
    }

    private void cjO() {
        if (this.ccb != null) {
            this.ccb.getImgAgree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.ccb.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 2) {
                            data.agreeType = 2;
                            data.hasAgree = false;
                            data.diffAgreeNum--;
                            data.agreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.ccb.JW();
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum += 2;
                            data.agreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.ccb.ek(true);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum++;
                        data.agreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.ccb.ek(true);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.zR(i);
                }
            });
            this.ccb.getImgDisagree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.ccb.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 5) {
                            data.agreeType = 5;
                            data.hasAgree = false;
                            data.diffAgreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.ccb.JW();
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum -= 2;
                            data.agreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.ccb.ek(false);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum--;
                        data.disAgreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.ccb.ek(false);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.zR(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zR(int i) {
        if (i == 1) {
            a(this.iPW.getThreadData(), "nozan", 0);
            a(this.iPW.getThreadData(), "1", "2");
            return;
        }
        a(this.iPW.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.iPW.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aU(View view) {
        int i = 0;
        if (bc.cF(this.mContext) && this.Wd != null) {
            if (this.Wd.afX() != 0) {
                a(this.iPW.getThreadData(), "nozan", 0);
                a(this.iPW.getThreadData(), "1", "2");
                this.Wd.as(this.Wd.afV() - 1);
                this.Wd.hq(0);
                this.bXh.bYa = R.color.cp_cont_f;
                this.bXh.bYb = R.color.cp_cont_f;
                i = 1;
            } else {
                a(this.iPW.getThreadData(), FeedData.TYPE_ZAN, 0);
                a(this.iPW.getThreadData(), "1", "1");
                this.Wd.hq(1);
                this.Wd.as(this.Wd.afV() + 1);
                this.bXh.bYa = R.color.cp_cont_h;
                this.bXh.bYb = R.color.cp_cont_h;
            }
            if (this.iPW instanceof AdCard) {
                ((AdCard) this.iPW).agree_num = this.Wd.afV();
            }
            updatePraiseNum(this.Wd);
            this.bXh.iA(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aR(View view) {
        if (this.Wd != null && this.mContext != null && this.iPW != null) {
            a(this.iPW.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.iPW.getThreadData(), "2", "1");
            if (bf.iN() || bc.cF(this.mContext)) {
                final e eVar = new e();
                eVar.title = this.iPW.getTitle();
                eVar.content = this.iPW.getAbstract();
                eVar.clK = this.iPW.getTitle();
                eVar.linkUrl = this.iPW.getShareLink();
                eVar.clN = 3;
                eVar.clx = true;
                String imageUrl = this.iPW.getImageUrl();
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
                shareDialogConfig.setHideMode(EE(eVar.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.iPT = i;
    }

    public void setShareData(a aVar) {
        this.iPW = aVar;
        setData(this.iPW.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 8, i);
        c.ED(str);
        c.cjE().a(c);
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
                        xVar.aim();
                        return null;
                    }
                    return null;
                }
            }.execute(URL, ed(str3, "cpid"), ed(str3, "idea_id"));
        }
    }

    private String ed(String str, String str2) {
        try {
            return new JSONObject(new String(com.baidu.adp.lib.util.c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.cce;
    }

    private int EE(String str) {
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
        am.j(this.ccc, this.iPU);
        am.j(this.ccf, this.iPV);
    }

    public void setDisPraiseViewVisibility(boolean z) {
        if (this.bXi != null) {
            this.bXi.setVisibility(z ? 0 : 8);
        }
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.iPU = R.color.cp_cont_e;
            this.ccJ = R.drawable.icon_home_card_comment_s;
            return;
        }
        this.iPU = R.drawable.selector_comment_and_prise_item_text_color;
        this.ccJ = R.drawable.icon_home_card_comment;
    }

    private boolean akr() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.amm();
    }

    public void setPraiseContainerBgGray(boolean z) {
        if (this.bXh != null) {
            if (com.baidu.tbadk.util.a.awk().amc()) {
                if (z) {
                    this.bXh.bXY = R.drawable.icon_card_like_d;
                    this.bXh.bXZ = R.drawable.icon_card_like_d;
                    this.bXh.bYa = R.color.cp_cont_e;
                    this.bXh.bYb = R.color.cp_cont_e;
                    return;
                }
                this.bXh.bXY = R.drawable.icon_card_like_n;
                this.bXh.bXZ = R.drawable.icon_card_like_s;
                if (this.Wd != null && this.Wd.afX() == 1) {
                    this.bXh.bYa = R.drawable.selector_comment_and_prise_item_text_color;
                    this.bXh.bYb = R.color.cp_cont_h;
                    return;
                }
                this.bXh.bYa = R.drawable.selector_comment_and_prise_item_text_color;
                this.bXh.bYb = R.drawable.selector_comment_and_prise_item_text_color;
            } else if (z) {
                this.bXh.bXY = R.drawable.icon_home_card_like_d;
                this.bXh.bXZ = R.drawable.icon_home_card_like_d;
                this.bXh.bYa = R.color.cp_cont_e;
                this.bXh.bYb = R.color.cp_cont_e;
            } else {
                this.bXh.bXY = akr() ? R.drawable.icon_home_card_like_n_xmas : R.drawable.icon_home_card_like_n;
                this.bXh.bXZ = akr() ? R.drawable.icon_home_card_like_s_xmas : R.drawable.icon_home_card_like_s;
                if (this.Wd != null && this.Wd.afX() == 1) {
                    this.bXh.bYa = R.drawable.selector_comment_and_prise_item_text_color;
                    this.bXh.bYb = R.color.cp_cont_h;
                    return;
                }
                this.bXh.bYa = R.drawable.selector_comment_and_prise_item_text_color;
                this.bXh.bYb = R.drawable.selector_comment_and_prise_item_text_color;
            }
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.ccK = R.drawable.icon_card_share_s;
            this.iPV = R.color.cp_cont_e;
            return;
        }
        this.ccK = R.drawable.icon_home_card_share;
        this.iPV = R.drawable.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void aln() {
        super.aln();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(iPN, 0, iPN, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(iPN, 0, iPN, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(iPN, 0, iPN, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(iPN, 0, iPN, 0);
        }
    }
}
