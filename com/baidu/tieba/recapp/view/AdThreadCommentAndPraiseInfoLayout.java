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
    public static int iNr;
    private a iNA;
    private final int iNs;
    private final int iNt;
    private final int iNu;
    private final int iNv;
    private final int iNw;
    private int iNx;
    private int iNy;
    private int iNz;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.iNs = 446;
        this.iNt = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iNu = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iNv = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iNw = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iNx = 1;
        this.type = 0;
        this.iNy = R.drawable.selector_comment_and_prise_item_text_color;
        this.iNz = this.iNy;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iNs = 446;
        this.iNt = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iNu = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iNv = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iNw = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iNx = 1;
        this.type = 0;
        this.iNy = R.drawable.selector_comment_and_prise_item_text_color;
        this.iNz = this.iNy;
        initSetting();
    }

    private void initSetting() {
        iNr = l.g(this.mContext, R.dimen.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(9);
        this.cbG = false;
        cja();
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bh bhVar) {
        AgreeData ago;
        if (bhVar != null && (ago = bhVar.ago()) != null && ago.agreeNum == 0 && ago.diffAgreeNum == 0) {
            ago.agreeNum = bhVar.afR();
            ago.hasAgree = bhVar.afT() == 1;
            ago.agreeType = bhVar.afU();
            ago.diffAgreeNum = bhVar.afR() - bhVar.afS();
        }
        super.updatePraiseNum(bhVar);
        if (this.cbi != null) {
            this.cbi.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type == 1 && this.bWo != null && this.cbC) {
            if (this.bWo.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWo.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.bWo.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.bWo.getImageView();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.cbe;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void p(bh bhVar) {
        super.p(bhVar);
        if (this.type == 1 && this.cbI && this.cbo.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbo.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.cbe;
            layoutParams.weight = 0.0f;
            this.cbo.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void q(bh bhVar) {
        super.q(bhVar);
        if (this.type == 1 && this.cbl != null && this.cbG) {
            this.cbl.setVisibility(0);
            if (this.cbl.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbl.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.cbe;
                layoutParams.weight = 0.0f;
                this.cbl.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void u(bh bhVar) {
        super.u(bhVar);
        if (this.iNx == 1) {
            this.cbf.setText(aq.j(bhVar.aeD(), 12, ""));
        }
    }

    public void disableClick() {
        this.bWo.setClickable(false);
        this.cbo.setClickable(false);
        this.cbl.setClickable(false);
    }

    private void cja() {
        if (this.cbi != null) {
            this.cbi.getImgAgree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.cbi.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 2) {
                            data.agreeType = 2;
                            data.hasAgree = false;
                            data.diffAgreeNum--;
                            data.agreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.cbi.JS();
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum += 2;
                            data.agreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.cbi.eh(true);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum++;
                        data.agreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.cbi.eh(true);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.zO(i);
                }
            });
            this.cbi.getImgDisagree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.cbi.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 5) {
                            data.agreeType = 5;
                            data.hasAgree = false;
                            data.diffAgreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.cbi.JS();
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum -= 2;
                            data.agreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.cbi.eh(false);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum--;
                        data.disAgreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.cbi.eh(false);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.zO(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zO(int i) {
        if (i == 1) {
            a(this.iNA.getThreadData(), "nozan", 0);
            a(this.iNA.getThreadData(), "1", "2");
            return;
        }
        a(this.iNA.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.iNA.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aU(View view) {
        int i = 0;
        if (bd.cF(this.mContext) && this.We != null) {
            if (this.We.afT() != 0) {
                a(this.iNA.getThreadData(), "nozan", 0);
                a(this.iNA.getThreadData(), "1", "2");
                this.We.as(this.We.afR() - 1);
                this.We.hp(0);
                this.bWo.bXh = R.color.cp_cont_f;
                this.bWo.bXi = R.color.cp_cont_f;
                i = 1;
            } else {
                a(this.iNA.getThreadData(), FeedData.TYPE_ZAN, 0);
                a(this.iNA.getThreadData(), "1", "1");
                this.We.hp(1);
                this.We.as(this.We.afR() + 1);
                this.bWo.bXh = R.color.cp_cont_h;
                this.bWo.bXi = R.color.cp_cont_h;
            }
            if (this.iNA instanceof AdCard) {
                ((AdCard) this.iNA).agree_num = this.We.afR();
            }
            updatePraiseNum(this.We);
            this.bWo.ix(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aR(View view) {
        if (this.We != null && this.mContext != null && this.iNA != null) {
            a(this.iNA.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.iNA.getThreadData(), "2", "1");
            if (bf.iN() || bd.cF(this.mContext)) {
                final e eVar = new e();
                eVar.title = this.iNA.getTitle();
                eVar.content = this.iNA.getAbstract();
                eVar.ckP = this.iNA.getTitle();
                eVar.linkUrl = this.iNA.getShareLink();
                eVar.ckS = 3;
                eVar.ckC = true;
                String imageUrl = this.iNA.getImageUrl();
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
                shareDialogConfig.setHideMode(Ee(eVar.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.iNx = i;
    }

    public void setShareData(a aVar) {
        this.iNA = aVar;
        setData(this.iNA.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 8, i);
        c.Ed(str);
        c.ciQ().a(c);
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
                        xVar.aii();
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
        return this.cbl;
    }

    private int Ee(String str) {
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
        am.j(this.cbj, this.iNy);
        am.j(this.cbm, this.iNz);
    }

    public void setDisPraiseViewVisibility(boolean z) {
        if (this.bWp != null) {
            this.bWp.setVisibility(z ? 0 : 8);
        }
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.iNy = R.color.cp_cont_e;
            this.cbP = R.drawable.icon_home_card_comment_s;
            return;
        }
        this.iNy = R.drawable.selector_comment_and_prise_item_text_color;
        this.cbP = R.drawable.icon_home_card_comment;
    }

    private boolean akf() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.ama();
    }

    public void setPraiseContainerBgGray(boolean z) {
        if (this.bWo != null) {
            if (com.baidu.tbadk.util.a.avY().alQ()) {
                if (z) {
                    this.bWo.bXf = R.drawable.icon_card_like_d;
                    this.bWo.bXg = R.drawable.icon_card_like_d;
                    this.bWo.bXh = R.color.cp_cont_e;
                    this.bWo.bXi = R.color.cp_cont_e;
                    return;
                }
                this.bWo.bXf = R.drawable.icon_card_like_n;
                this.bWo.bXg = R.drawable.icon_card_like_s;
                if (this.We != null && this.We.afT() == 1) {
                    this.bWo.bXh = R.drawable.selector_comment_and_prise_item_text_color;
                    this.bWo.bXi = R.color.cp_cont_h;
                    return;
                }
                this.bWo.bXh = R.drawable.selector_comment_and_prise_item_text_color;
                this.bWo.bXi = R.drawable.selector_comment_and_prise_item_text_color;
            } else if (z) {
                this.bWo.bXf = R.drawable.icon_home_card_like_d;
                this.bWo.bXg = R.drawable.icon_home_card_like_d;
                this.bWo.bXh = R.color.cp_cont_e;
                this.bWo.bXi = R.color.cp_cont_e;
            } else {
                this.bWo.bXf = akf() ? R.drawable.icon_home_card_like_n_xmas : R.drawable.icon_home_card_like_n;
                this.bWo.bXg = akf() ? R.drawable.icon_home_card_like_s_xmas : R.drawable.icon_home_card_like_s;
                if (this.We != null && this.We.afT() == 1) {
                    this.bWo.bXh = R.drawable.selector_comment_and_prise_item_text_color;
                    this.bWo.bXi = R.color.cp_cont_h;
                    return;
                }
                this.bWo.bXh = R.drawable.selector_comment_and_prise_item_text_color;
                this.bWo.bXi = R.drawable.selector_comment_and_prise_item_text_color;
            }
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.cbQ = R.drawable.icon_card_share_s;
            this.iNz = R.color.cp_cont_e;
            return;
        }
        this.cbQ = R.drawable.icon_home_card_share;
        this.iNz = R.drawable.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void alb() {
        super.alb();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(iNr, 0, iNr, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(iNr, 0, iNr, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(iNr, 0, iNr, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(iNr, 0, iNr, 0);
        }
    }
}
