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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bh;
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
    public static int iOJ;
    private final int iOK;
    private final int iOL;
    private final int iOM;
    private final int iON;
    private final int iOO;
    private int iOP;
    private int iOQ;
    private int iOR;
    private a iOS;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.iOK = 446;
        this.iOL = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iOM = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iON = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iOO = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iOP = 1;
        this.type = 0;
        this.iOQ = R.drawable.selector_comment_and_prise_item_text_color;
        this.iOR = this.iOQ;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iOK = 446;
        this.iOL = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iOM = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iON = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iOO = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iOP = 1;
        this.type = 0;
        this.iOQ = R.drawable.selector_comment_and_prise_item_text_color;
        this.iOR = this.iOQ;
        initSetting();
    }

    private void initSetting() {
        iOJ = l.getDimens(this.mContext, R.dimen.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(9);
        this.cqN = false;
        cgV();
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bh bhVar) {
        AgreeData akv;
        if (bhVar != null && (akv = bhVar.akv()) != null && akv.agreeNum == 0 && akv.diffAgreeNum == 0) {
            akv.agreeNum = bhVar.ajY();
            akv.hasAgree = bhVar.aka() == 1;
            akv.agreeType = bhVar.akb();
            akv.diffAgreeNum = bhVar.ajY() - bhVar.ajZ();
        }
        super.updatePraiseNum(bhVar);
        if (this.cqp != null) {
            this.cqp.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type == 1 && this.cmm != null && this.cqJ) {
            if (this.cmm.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmm.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.cmm.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.cmm.getImageView();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.cql;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void q(bh bhVar) {
        super.q(bhVar);
        if (this.type == 1 && this.cqP && this.cqv.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqv.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.cql;
            layoutParams.weight = 0.0f;
            this.cqv.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void r(bh bhVar) {
        super.r(bhVar);
        if (this.type == 1 && this.cqs != null && this.cqN) {
            this.cqs.setVisibility(0);
            if (this.cqs.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqs.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.cql;
                layoutParams.weight = 0.0f;
                this.cqs.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void v(bh bhVar) {
        super.v(bhVar);
        if (this.iOP == 1) {
            this.cqm.setText(aq.cutChineseAndEnglishWithSuffix(bhVar.aiL(), 12, ""));
        }
    }

    public void disableClick() {
        this.cmm.setClickable(false);
        this.cqv.setClickable(false);
        this.cqs.setClickable(false);
    }

    private void cgV() {
        if (this.cqp != null) {
            this.cqp.getImgAgree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.cqp.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 2) {
                            data.agreeType = 2;
                            data.hasAgree = false;
                            data.diffAgreeNum--;
                            data.agreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.cqp.updateUI();
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum += 2;
                            data.agreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.cqp.ep(true);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum++;
                        data.agreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.cqp.ep(true);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.yx(i);
                }
            });
            this.cqp.getImgDisagree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.cqp.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 5) {
                            data.agreeType = 5;
                            data.hasAgree = false;
                            data.diffAgreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.cqp.updateUI();
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum -= 2;
                            data.agreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.cqp.ep(false);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum--;
                        data.disAgreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.cqp.ep(false);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.yx(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yx(int i) {
        if (i == 1) {
            a(this.iOS.getThreadData(), "nozan", 0);
            a(this.iOS.getThreadData(), "1", "2");
            return;
        }
        a(this.iOS.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.iOS.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aU(View view) {
        int i = 0;
        if (bc.checkUpIsLogin(this.mContext) && this.FT != null) {
            if (this.FT.aka() != 0) {
                a(this.iOS.getThreadData(), "nozan", 0);
                a(this.iOS.getThreadData(), "1", "2");
                this.FT.aL(this.FT.ajY() - 1);
                this.FT.hP(0);
                this.cmm.cnd = R.color.cp_cont_f;
                this.cmm.cne = R.color.cp_cont_f;
                i = 1;
            } else {
                a(this.iOS.getThreadData(), FeedData.TYPE_ZAN, 0);
                a(this.iOS.getThreadData(), "1", "1");
                this.FT.hP(1);
                this.FT.aL(this.FT.ajY() + 1);
                this.cmm.cnd = R.color.cp_cont_h;
                this.cmm.cne = R.color.cp_cont_h;
            }
            if (this.iOS instanceof AdCard) {
                ((AdCard) this.iOS).agree_num = this.FT.ajY();
            }
            updatePraiseNum(this.FT);
            this.cmm.iz(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aR(View view) {
        if (this.FT != null && this.mContext != null && this.iOS != null) {
            a(this.iOS.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.iOS.getThreadData(), "2", "1");
            if (bf.isOn() || bc.checkUpIsLogin(this.mContext)) {
                final e eVar = new e();
                eVar.title = this.iOS.getTitle();
                eVar.content = this.iOS.getAbstract();
                eVar.cyK = this.iOS.getTitle();
                eVar.linkUrl = this.iOS.getShareLink();
                eVar.cyN = 3;
                eVar.cyx = true;
                String imageUrl = this.iOS.getImageUrl();
                Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
                if (parse != null) {
                    eVar.imageUri = parse;
                }
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, eVar, true, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        eVar.linkUrl = f.bY(eVar.linkUrl, eVar.tid);
                        com.baidu.adp.lib.util.a.copyToClipboard(eVar.linkUrl);
                        l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(R.string.copy_pb_url_success));
                    }
                });
                shareDialogConfig.setHideMode(CZ(eVar.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.iOP = i;
    }

    public void setShareData(a aVar) {
        this.iOS = aVar;
        setData(this.iOS.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 8, i);
        c.CY(str);
        c.cgI().a(c);
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
                        xVar.addPostData("cpid", strArr[1]);
                        xVar.addPostData("idea_id", strArr[2]);
                        xVar.addPostData("type", str);
                        xVar.addPostData("cmd", str2);
                        xVar.postNetData();
                        return null;
                    }
                    return null;
                }
            }.execute(URL, dP(str3, "cpid"), dP(str3, "idea_id"));
        }
    }

    private String dP(String str, String str2) {
        try {
            return new JSONObject(new String(com.baidu.adp.lib.util.c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.cqs;
    }

    private int CZ(String str) {
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
        am.setViewTextColor(this.cqq, this.iOQ);
        am.setViewTextColor(this.cqt, this.iOR);
    }

    public void setDisPraiseViewVisibility(boolean z) {
        if (this.cmn != null) {
            this.cmn.setVisibility(z ? 0 : 8);
        }
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.iOQ = R.color.cp_cont_e;
            this.cqW = R.drawable.icon_home_card_comment_s;
            return;
        }
        this.iOQ = R.drawable.selector_comment_and_prise_item_text_color;
        this.cqW = R.drawable.icon_home_card_comment;
    }

    private boolean ant() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.aoR();
    }

    public void setPraiseContainerBgGray(boolean z) {
        if (this.cmm != null) {
            if (com.baidu.tbadk.util.a.axp().aoP()) {
                if (z) {
                    this.cmm.drawableResId = R.drawable.icon_card_like_d;
                    this.cmm.cnc = R.drawable.icon_card_like_d;
                    this.cmm.cnd = R.color.cp_cont_e;
                    this.cmm.cne = R.color.cp_cont_e;
                    return;
                }
                this.cmm.drawableResId = R.drawable.icon_card_like_n;
                this.cmm.cnc = R.drawable.icon_card_like_s;
                if (this.FT != null && this.FT.aka() == 1) {
                    this.cmm.cnd = R.drawable.selector_comment_and_prise_item_text_color;
                    this.cmm.cne = R.color.cp_cont_h;
                    return;
                }
                this.cmm.cnd = R.drawable.selector_comment_and_prise_item_text_color;
                this.cmm.cne = R.drawable.selector_comment_and_prise_item_text_color;
            } else if (z) {
                this.cmm.drawableResId = R.drawable.icon_home_card_like_d;
                this.cmm.cnc = R.drawable.icon_home_card_like_d;
                this.cmm.cnd = R.color.cp_cont_e;
                this.cmm.cne = R.color.cp_cont_e;
            } else {
                this.cmm.drawableResId = ant() ? R.drawable.icon_home_card_like_n_xmas : R.drawable.icon_home_card_like_n;
                this.cmm.cnc = ant() ? R.drawable.icon_home_card_like_s_xmas : R.drawable.icon_home_card_like_s;
                if (this.FT != null && this.FT.aka() == 1) {
                    this.cmm.cnd = R.drawable.selector_comment_and_prise_item_text_color;
                    this.cmm.cne = R.color.cp_cont_h;
                    return;
                }
                this.cmm.cnd = R.drawable.selector_comment_and_prise_item_text_color;
                this.cmm.cne = R.drawable.selector_comment_and_prise_item_text_color;
            }
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.cqX = R.drawable.icon_card_share_s;
            this.iOR = R.color.cp_cont_e;
            return;
        }
        this.cqX = R.drawable.icon_home_card_share;
        this.iOR = R.drawable.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void aob() {
        super.aob();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(iOJ, 0, iOJ, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(iOJ, 0, iOJ, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(iOJ, 0, iOJ, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(iOJ, 0, iOJ, 0);
        }
    }
}
