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
    public static int iNS;
    private final int iNT;
    private final int iNU;
    private final int iNV;
    private final int iNW;
    private final int iNX;
    private int iNY;
    private int iNZ;
    private int iOa;
    private a iOb;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.iNT = 446;
        this.iNU = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iNV = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iNW = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iNX = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iNY = 1;
        this.type = 0;
        this.iNZ = R.drawable.selector_comment_and_prise_item_text_color;
        this.iOa = this.iNZ;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iNT = 446;
        this.iNU = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iNV = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iNW = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iNX = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iNY = 1;
        this.type = 0;
        this.iNZ = R.drawable.selector_comment_and_prise_item_text_color;
        this.iOa = this.iNZ;
        initSetting();
    }

    private void initSetting() {
        iNS = l.getDimens(this.mContext, R.dimen.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(9);
        this.cpW = false;
        cgT();
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bh bhVar) {
        AgreeData akt;
        if (bhVar != null && (akt = bhVar.akt()) != null && akt.agreeNum == 0 && akt.diffAgreeNum == 0) {
            akt.agreeNum = bhVar.ajW();
            akt.hasAgree = bhVar.ajY() == 1;
            akt.agreeType = bhVar.ajZ();
            akt.diffAgreeNum = bhVar.ajW() - bhVar.ajX();
        }
        super.updatePraiseNum(bhVar);
        if (this.cpy != null) {
            this.cpy.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type == 1 && this.clu != null && this.cpS) {
            if (this.clu.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.clu.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.clu.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.clu.getImageView();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.cpt;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void q(bh bhVar) {
        super.q(bhVar);
        if (this.type == 1 && this.cpY && this.cpE.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cpE.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.cpt;
            layoutParams.weight = 0.0f;
            this.cpE.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void r(bh bhVar) {
        super.r(bhVar);
        if (this.type == 1 && this.cpB != null && this.cpW) {
            this.cpB.setVisibility(0);
            if (this.cpB.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cpB.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.cpt;
                layoutParams.weight = 0.0f;
                this.cpB.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void v(bh bhVar) {
        super.v(bhVar);
        if (this.iNY == 1) {
            this.cpv.setText(aq.cutChineseAndEnglishWithSuffix(bhVar.aiJ(), 12, ""));
        }
    }

    public void disableClick() {
        this.clu.setClickable(false);
        this.cpE.setClickable(false);
        this.cpB.setClickable(false);
    }

    private void cgT() {
        if (this.cpy != null) {
            this.cpy.getImgAgree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.cpy.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 2) {
                            data.agreeType = 2;
                            data.hasAgree = false;
                            data.diffAgreeNum--;
                            data.agreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.cpy.updateUI();
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum += 2;
                            data.agreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.cpy.ep(true);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum++;
                        data.agreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.cpy.ep(true);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.yw(i);
                }
            });
            this.cpy.getImgDisagree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.cpy.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 5) {
                            data.agreeType = 5;
                            data.hasAgree = false;
                            data.diffAgreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.cpy.updateUI();
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum -= 2;
                            data.agreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.cpy.ep(false);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum--;
                        data.disAgreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.cpy.ep(false);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.yw(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yw(int i) {
        if (i == 1) {
            a(this.iOb.getThreadData(), "nozan", 0);
            a(this.iOb.getThreadData(), "1", "2");
            return;
        }
        a(this.iOb.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.iOb.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aU(View view) {
        int i = 0;
        if (bc.checkUpIsLogin(this.mContext) && this.Fs != null) {
            if (this.Fs.ajY() != 0) {
                a(this.iOb.getThreadData(), "nozan", 0);
                a(this.iOb.getThreadData(), "1", "2");
                this.Fs.aK(this.Fs.ajW() - 1);
                this.Fs.hO(0);
                this.clu.cmm = R.color.cp_cont_f;
                this.clu.cmn = R.color.cp_cont_f;
                i = 1;
            } else {
                a(this.iOb.getThreadData(), FeedData.TYPE_ZAN, 0);
                a(this.iOb.getThreadData(), "1", "1");
                this.Fs.hO(1);
                this.Fs.aK(this.Fs.ajW() + 1);
                this.clu.cmm = R.color.cp_cont_h;
                this.clu.cmn = R.color.cp_cont_h;
            }
            if (this.iOb instanceof AdCard) {
                ((AdCard) this.iOb).agree_num = this.Fs.ajW();
            }
            updatePraiseNum(this.Fs);
            this.clu.iy(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aR(View view) {
        if (this.Fs != null && this.mContext != null && this.iOb != null) {
            a(this.iOb.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.iOb.getThreadData(), "2", "1");
            if (bf.isOn() || bc.checkUpIsLogin(this.mContext)) {
                final e eVar = new e();
                eVar.title = this.iOb.getTitle();
                eVar.content = this.iOb.getAbstract();
                eVar.cxT = this.iOb.getTitle();
                eVar.linkUrl = this.iOb.getShareLink();
                eVar.cxW = 3;
                eVar.cxG = true;
                String imageUrl = this.iOb.getImageUrl();
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
        this.iNY = i;
    }

    public void setShareData(a aVar) {
        this.iOb = aVar;
        setData(this.iOb.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 8, i);
        c.CY(str);
        c.cgG().a(c);
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
        return this.cpB;
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
        am.setViewTextColor(this.cpz, this.iNZ);
        am.setViewTextColor(this.cpC, this.iOa);
    }

    public void setDisPraiseViewVisibility(boolean z) {
        if (this.clv != null) {
            this.clv.setVisibility(z ? 0 : 8);
        }
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.iNZ = R.color.cp_cont_e;
            this.cqf = R.drawable.icon_home_card_comment_s;
            return;
        }
        this.iNZ = R.drawable.selector_comment_and_prise_item_text_color;
        this.cqf = R.drawable.icon_home_card_comment;
    }

    private boolean anr() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.aoP();
    }

    public void setPraiseContainerBgGray(boolean z) {
        if (this.clu != null) {
            if (com.baidu.tbadk.util.a.axn().aoN()) {
                if (z) {
                    this.clu.drawableResId = R.drawable.icon_card_like_d;
                    this.clu.cml = R.drawable.icon_card_like_d;
                    this.clu.cmm = R.color.cp_cont_e;
                    this.clu.cmn = R.color.cp_cont_e;
                    return;
                }
                this.clu.drawableResId = R.drawable.icon_card_like_n;
                this.clu.cml = R.drawable.icon_card_like_s;
                if (this.Fs != null && this.Fs.ajY() == 1) {
                    this.clu.cmm = R.drawable.selector_comment_and_prise_item_text_color;
                    this.clu.cmn = R.color.cp_cont_h;
                    return;
                }
                this.clu.cmm = R.drawable.selector_comment_and_prise_item_text_color;
                this.clu.cmn = R.drawable.selector_comment_and_prise_item_text_color;
            } else if (z) {
                this.clu.drawableResId = R.drawable.icon_home_card_like_d;
                this.clu.cml = R.drawable.icon_home_card_like_d;
                this.clu.cmm = R.color.cp_cont_e;
                this.clu.cmn = R.color.cp_cont_e;
            } else {
                this.clu.drawableResId = anr() ? R.drawable.icon_home_card_like_n_xmas : R.drawable.icon_home_card_like_n;
                this.clu.cml = anr() ? R.drawable.icon_home_card_like_s_xmas : R.drawable.icon_home_card_like_s;
                if (this.Fs != null && this.Fs.ajY() == 1) {
                    this.clu.cmm = R.drawable.selector_comment_and_prise_item_text_color;
                    this.clu.cmn = R.color.cp_cont_h;
                    return;
                }
                this.clu.cmm = R.drawable.selector_comment_and_prise_item_text_color;
                this.clu.cmn = R.drawable.selector_comment_and_prise_item_text_color;
            }
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.cqg = R.drawable.icon_card_share_s;
            this.iOa = R.color.cp_cont_e;
            return;
        }
        this.cqg = R.drawable.icon_home_card_share;
        this.iOa = R.drawable.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void anZ() {
        super.anZ();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(iNS, 0, iNS, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(iNS, 0, iNS, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(iNS, 0, iNS, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(iNS, 0, iNS, 0);
        }
    }
}
