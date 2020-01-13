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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.e;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.recapp.c.a;
import com.baidu.tieba.recapp.report.b;
import com.baidu.tieba.recapp.report.c;
import com.baidu.tieba.recapp.report.f;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AdThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    public static String URL = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public static int dJZ;
    private final int jLJ;
    private final int jLK;
    private final int jLL;
    private final int jLM;
    private final int jLN;
    private int jLO;
    private int jLP;
    private a jLQ;
    private int style;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.jLJ = 446;
        this.jLK = 5120;
        this.jLL = 5120;
        this.jLM = 5120;
        this.jLN = 5120;
        this.style = 1;
        this.type = 0;
        this.jLO = R.drawable.selector_comment_and_prise_item_text_color;
        this.jLP = this.jLO;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jLJ = 446;
        this.jLK = 5120;
        this.jLL = 5120;
        this.jLM = 5120;
        this.jLN = 5120;
        this.style = 1;
        this.type = 0;
        this.jLO = R.drawable.selector_comment_and_prise_item_text_color;
        this.jLP = this.jLO;
        initSetting();
    }

    private void initSetting() {
        dJZ = l.getDimens(this.mContext, R.dimen.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(9);
        this.ddv = false;
        cCc();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.cQo || (bjVar.aBO() && bjVar.sortType == 3)) {
                this.dda.setAgreeAlone(true);
            }
            AgreeData aBM = bjVar.aBM();
            if (aBM != null && aBM.agreeNum == 0 && aBM.diffAgreeNum == 0) {
                aBM.agreeNum = bjVar.aBs();
                aBM.hasAgree = bjVar.aBu() == 1;
                aBM.agreeType = bjVar.aBv();
                aBM.diffAgreeNum = bjVar.aBs() - bjVar.aBt();
            }
        }
        super.updatePraiseNum(bjVar);
        if (this.dda != null) {
            this.dda.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type != 1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void v(bj bjVar) {
        super.v(bjVar);
        if (this.type == 1 && this.ddx && this.ddg.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ddg.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.dcX;
            layoutParams.weight = 0.0f;
            this.ddg.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void w(bj bjVar) {
        super.w(bjVar);
        if (this.type == 1 && this.ddd != null && this.ddv) {
            this.ddd.setVisibility(0);
            if (this.ddd.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ddd.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.dcX;
                layoutParams.weight = 0.0f;
                this.ddd.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void z(bj bjVar) {
        super.z(bjVar);
        if (this.style == 1) {
            this.dcY.setText(aq.cutChineseAndEnglishWithSuffix(bjVar.aAc(), 12, ""));
        }
    }

    public void disableClick() {
        this.ddg.setClickable(false);
        this.ddd.setClickable(false);
    }

    private void cCc() {
        if (this.dda != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.dda.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 2) {
                            data.agreeType = 2;
                            data.hasAgree = false;
                            data.diffAgreeNum--;
                            data.agreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.dda.updateUI();
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum += 2;
                            data.agreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.dda.fG(true);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum++;
                        data.agreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.dda.fG(true);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.AX(i);
                }
            };
            this.dda.getImgAgree().setOnClickListener(onClickListener);
            this.dda.getAgreeNumView().setOnClickListener(onClickListener);
            this.dda.getImgDisagree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.dda.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 5) {
                            data.agreeType = 5;
                            data.hasAgree = false;
                            data.diffAgreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.dda.updateUI();
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum -= 2;
                            data.agreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.dda.fG(false);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum--;
                        data.disAgreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.dda.fG(false);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.AX(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AX(int i) {
        if (i == 1) {
            a(this.jLQ.getThreadData(), "nozan", 0);
            a(this.jLQ.getThreadData(), "1", "2");
            return;
        }
        a(this.jLQ.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.jLQ.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aT(View view) {
        if (this.Kn != null && this.mContext != null && this.jLQ != null) {
            a(this.jLQ.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.jLQ.getThreadData(), "2", "1");
            if (ShareSwitch.isOn() || bc.checkUpIsLogin(this.mContext)) {
                final ShareItem shareItem = new ShareItem();
                shareItem.title = this.jLQ.getTitle();
                shareItem.content = this.jLQ.getAbstract();
                shareItem.dlS = this.jLQ.getTitle();
                shareItem.linkUrl = this.jLQ.getShareLink();
                shareItem.dlV = 3;
                shareItem.dlJ = true;
                String imageUrl = this.jLQ.getImageUrl();
                Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        shareItem.linkUrl = e.cv(shareItem.linkUrl, shareItem.tid);
                        com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                        l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(R.string.copy_pb_url_success));
                    }
                });
                shareDialogConfig.setHideMode(HW(shareItem.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.style = i;
    }

    public void setShareData(a aVar) {
        this.jLQ = aVar;
        setData(this.jLQ.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        b c = f.c(advertAppInfo, 8, i);
        c.HV(str);
        c.cBP().a(c);
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
            }.execute(URL, ek(str3, "cpid"), ek(str3, "idea_id"));
        }
    }

    private String ek(String str, String str2) {
        try {
            return new JSONObject(new String(com.baidu.adp.lib.util.c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.ddd;
    }

    private int HW(String str) {
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
        am.setViewTextColor(this.ddb, this.jLO);
        am.setViewTextColor(this.dde, this.jLP);
    }

    public void setDisPraiseViewVisibility(boolean z) {
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.jLO = R.color.cp_cont_e;
            this.ddF = R.drawable.icon_home_card_comment_s;
            return;
        }
        this.jLO = R.drawable.selector_comment_and_prise_item_text_color;
        this.ddF = R.drawable.icon_home_card_comment;
    }

    public void setPraiseContainerBgGray(boolean z) {
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.ddG = R.drawable.icon_card_share_s;
            this.jLP = R.color.cp_cont_e;
            return;
        }
        this.ddG = R.drawable.icon_home_card_share;
        this.jLP = R.drawable.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void aFM() {
        super.aFM();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(dJZ, 0, dJZ, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(dJZ, 0, dJZ, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(dJZ, 0, dJZ, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(dJZ, 0, dJZ, 0);
        }
    }

    public void addAdMoreView(View view) {
        if (view != null) {
            this.ddh.setVisibility(0);
            this.ddh.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 21));
            this.ddh.addView(view);
        }
    }
}
