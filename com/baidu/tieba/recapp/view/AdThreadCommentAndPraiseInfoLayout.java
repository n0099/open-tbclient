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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.recapp.c.a;
import com.baidu.tieba.recapp.report.c;
import com.baidu.tieba.recapp.report.d;
import com.baidu.tieba.recapp.report.g;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class AdThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    public static String URL = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public static int eNF;
    private final int lkT;
    private final int lkU;
    private final int lkV;
    private final int lkW;
    private final int lkX;
    private int lkY;
    private int lkZ;
    private a lla;
    private int style;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.lkT = 446;
        this.lkU = 5120;
        this.lkV = 5120;
        this.lkW = 5120;
        this.lkX = 5120;
        this.style = 1;
        this.type = 0;
        this.lkY = R.drawable.selector_comment_and_prise_item_text_color;
        this.lkZ = this.lkY;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lkT = 446;
        this.lkU = 5120;
        this.lkV = 5120;
        this.lkW = 5120;
        this.lkX = 5120;
        this.style = 1;
        this.type = 0;
        this.lkY = R.drawable.selector_comment_and_prise_item_text_color;
        this.lkZ = this.lkY;
        initSetting();
    }

    private void initSetting() {
        eNF = l.getDimens(this.mContext, R.dimen.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(9);
        this.edL = false;
        dae();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bu buVar) {
        if (buVar != null) {
            if (buVar.dOy || (buVar.aUi() && buVar.sortType == 3)) {
                this.edr.setAgreeAlone(true);
            }
            AgreeData aUg = buVar.aUg();
            if (aUg != null && aUg.agreeNum == 0 && aUg.diffAgreeNum == 0) {
                aUg.agreeNum = buVar.aTN();
                aUg.hasAgree = buVar.aTP() == 1;
                aUg.agreeType = buVar.aTQ();
                aUg.diffAgreeNum = buVar.aTN() - buVar.aTO();
            }
        }
        super.updatePraiseNum(buVar);
        if (this.edr != null) {
            this.edr.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type != 1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void x(bu buVar) {
        super.x(buVar);
        if (this.type == 1 && this.edN && this.edw.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.edw.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.edp;
            layoutParams.weight = 0.0f;
            this.edw.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void y(bu buVar) {
        super.y(buVar);
        if (this.type == 1 && this.edt != null && this.edL) {
            this.edt.setVisibility(0);
            if (this.edt.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.edt.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.edp;
                layoutParams.weight = 0.0f;
                this.edt.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void C(bu buVar) {
        super.C(buVar);
        if (this.style == 1) {
            this.agZ.setText(ar.cutChineseAndEnglishWithSuffix(buVar.aSt(), 12, ""));
        }
    }

    public void disableClick() {
        this.edw.setClickable(false);
        this.edt.setClickable(false);
    }

    private void dae() {
        if (this.edr != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.edr.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 2) {
                            data.agreeType = 2;
                            data.hasAgree = false;
                            data.diffAgreeNum--;
                            data.agreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.edr.updateUI();
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum += 2;
                            data.agreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.edr.hp(true);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum++;
                        data.agreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.edr.hp(true);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.DC(i);
                }
            };
            this.edr.getImgAgree().setOnClickListener(onClickListener);
            this.edr.getAgreeNumView().setOnClickListener(onClickListener);
            this.edr.getImgDisagree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.edr.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 5) {
                            data.agreeType = 5;
                            data.hasAgree = false;
                            data.diffAgreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.edr.updateUI();
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum -= 2;
                            data.agreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.edr.hp(false);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum--;
                        data.disAgreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.edr.hp(false);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.DC(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DC(int i) {
        if (i == 1) {
            a(this.lla.getThreadData(), "nozan", 0);
            a(this.lla.getThreadData(), "1", "2");
            return;
        }
        a(this.lla.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.lla.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aV(View view) {
        if (this.aeK != null && this.mContext != null && this.lla != null) {
            a(this.lla.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.lla.getThreadData(), "2", "1");
            if (ShareSwitch.isOn() || be.checkUpIsLogin(this.mContext)) {
                final ShareItem shareItem = new ShareItem();
                shareItem.title = this.lla.getTitle();
                shareItem.content = this.lla.getAbstract();
                shareItem.enE = this.lla.getTitle();
                shareItem.linkUrl = this.lla.getShareLink();
                shareItem.enH = 3;
                shareItem.enu = true;
                String imageUrl = this.lla.getImageUrl();
                Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        shareItem.linkUrl = f.dq(shareItem.linkUrl, shareItem.tid);
                        com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                        l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(R.string.copy_pb_url_success));
                    }
                });
                shareDialogConfig.setHideMode(Mg(shareItem.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.style = i;
    }

    public void setShareData(a aVar) {
        this.lla = aVar;
        setData(this.lla.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        c c = g.c(advertAppInfo, 8, i);
        c.Mf(str);
        d.cZR().a(c);
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
                        y yVar = new y(strArr[0]);
                        yVar.addPostData("cpid", strArr[1]);
                        yVar.addPostData("idea_id", strArr[2]);
                        yVar.addPostData("type", str);
                        yVar.addPostData("cmd", str2);
                        yVar.postNetData();
                        return null;
                    }
                    return null;
                }
            }.execute(URL, fo(str3, "cpid"), fo(str3, "idea_id"));
        }
    }

    private String fo(String str, String str2) {
        try {
            return new JSONObject(new String(com.baidu.adp.lib.util.c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.edt;
    }

    private int Mg(String str) {
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
        an.setViewTextColor(this.dEA, this.lkY);
        an.setViewTextColor(this.edu, this.lkZ);
    }

    public void setDisPraiseViewVisibility(boolean z) {
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.lkY = R.color.cp_cont_e;
            this.edV = R.drawable.icon_home_card_comment_s;
            return;
        }
        this.lkY = R.drawable.selector_comment_and_prise_item_text_color;
        this.edV = R.drawable.icon_home_card_comment;
    }

    public void setPraiseContainerBgGray(boolean z) {
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.edW = R.drawable.icon_card_share_s;
            this.lkZ = R.color.cp_cont_e;
            return;
        }
        this.edW = R.drawable.icon_home_card_share;
        this.lkZ = R.drawable.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void aYu() {
        super.aYu();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(eNF, 0, eNF, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(eNF, 0, eNF, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(eNF, 0, eNF, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(eNF, 0, eNF, 0);
        }
    }

    public void addAdMoreView(View view) {
        if (view != null) {
            this.edx.setVisibility(0);
            this.edx.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 21));
            this.edx.addView(view);
        }
    }
}
