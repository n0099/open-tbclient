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
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.recapp.c.a;
import com.baidu.tieba.recapp.report.b;
import com.baidu.tieba.recapp.report.c;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class AdThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    public static String URL = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public static int dOf;
    private final int jMM;
    private final int jMN;
    private final int jMO;
    private final int jMP;
    private final int jMQ;
    private int jMR;
    private int jMS;
    private a jMT;
    private int style;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.jMM = 446;
        this.jMN = 5120;
        this.jMO = 5120;
        this.jMP = 5120;
        this.jMQ = 5120;
        this.style = 1;
        this.type = 0;
        this.jMR = R.drawable.selector_comment_and_prise_item_text_color;
        this.jMS = this.jMR;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jMM = 446;
        this.jMN = 5120;
        this.jMO = 5120;
        this.jMP = 5120;
        this.jMQ = 5120;
        this.style = 1;
        this.type = 0;
        this.jMR = R.drawable.selector_comment_and_prise_item_text_color;
        this.jMS = this.jMR;
        initSetting();
    }

    private void initSetting() {
        dOf = l.getDimens(this.mContext, R.dimen.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(9);
        this.dhA = false;
        cDC();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.cUr || (bjVar.aEc() && bjVar.sortType == 3)) {
                this.dhg.setAgreeAlone(true);
            }
            AgreeData aEa = bjVar.aEa();
            if (aEa != null && aEa.agreeNum == 0 && aEa.diffAgreeNum == 0) {
                aEa.agreeNum = bjVar.aDH();
                aEa.hasAgree = bjVar.aDJ() == 1;
                aEa.agreeType = bjVar.aDK();
                aEa.diffAgreeNum = bjVar.aDH() - bjVar.aDI();
            }
        }
        super.updatePraiseNum(bjVar);
        if (this.dhg != null) {
            this.dhg.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type != 1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void v(bj bjVar) {
        super.v(bjVar);
        if (this.type == 1 && this.dhC && this.dhm.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dhm.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.dhd;
            layoutParams.weight = 0.0f;
            this.dhm.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void w(bj bjVar) {
        super.w(bjVar);
        if (this.type == 1 && this.dhj != null && this.dhA) {
            this.dhj.setVisibility(0);
            if (this.dhj.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dhj.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.dhd;
                layoutParams.weight = 0.0f;
                this.dhj.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void A(bj bjVar) {
        super.A(bjVar);
        if (this.style == 1) {
            this.dhe.setText(aq.cutChineseAndEnglishWithSuffix(bjVar.aCt(), 12, ""));
        }
    }

    public void disableClick() {
        this.dhm.setClickable(false);
        this.dhj.setClickable(false);
    }

    private void cDC() {
        if (this.dhg != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.dhg.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 2) {
                            data.agreeType = 2;
                            data.hasAgree = false;
                            data.diffAgreeNum--;
                            data.agreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.dhg.updateUI();
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum += 2;
                            data.agreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.dhg.fN(true);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum++;
                        data.agreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.dhg.fN(true);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.Bg(i);
                }
            };
            this.dhg.getImgAgree().setOnClickListener(onClickListener);
            this.dhg.getAgreeNumView().setOnClickListener(onClickListener);
            this.dhg.getImgDisagree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.dhg.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 5) {
                            data.agreeType = 5;
                            data.hasAgree = false;
                            data.diffAgreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.dhg.updateUI();
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum -= 2;
                            data.agreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.dhg.fN(false);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum--;
                        data.disAgreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.dhg.fN(false);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.Bg(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bg(int i) {
        if (i == 1) {
            a(this.jMT.getThreadData(), "nozan", 0);
            a(this.jMT.getThreadData(), "1", "2");
            return;
        }
        a(this.jMT.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.jMT.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aT(View view) {
        if (this.KJ != null && this.mContext != null && this.jMT != null) {
            a(this.jMT.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.jMT.getThreadData(), "2", "1");
            if (ShareSwitch.isOn() || bc.checkUpIsLogin(this.mContext)) {
                final ShareItem shareItem = new ShareItem();
                shareItem.title = this.jMT.getTitle();
                shareItem.content = this.jMT.getAbstract();
                shareItem.dqc = this.jMT.getTitle();
                shareItem.linkUrl = this.jMT.getShareLink();
                shareItem.dqf = 3;
                shareItem.dpS = true;
                String imageUrl = this.jMT.getImageUrl();
                Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        shareItem.linkUrl = f.cE(shareItem.linkUrl, shareItem.tid);
                        com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                        l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(R.string.copy_pb_url_success));
                    }
                });
                shareDialogConfig.setHideMode(Ik(shareItem.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.style = i;
    }

    public void setShareData(a aVar) {
        this.jMT = aVar;
        setData(this.jMT.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 8, i);
        c.Ij(str);
        c.cDp().a(c);
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
            }.execute(URL, et(str3, "cpid"), et(str3, "idea_id"));
        }
    }

    private String et(String str, String str2) {
        try {
            return new JSONObject(new String(com.baidu.adp.lib.util.c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.dhj;
    }

    private int Ik(String str) {
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
        am.setViewTextColor(this.dhh, this.jMR);
        am.setViewTextColor(this.dhk, this.jMS);
    }

    public void setDisPraiseViewVisibility(boolean z) {
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.jMR = R.color.cp_cont_e;
            this.dhK = R.drawable.icon_home_card_comment_s;
            return;
        }
        this.jMR = R.drawable.selector_comment_and_prise_item_text_color;
        this.dhK = R.drawable.icon_home_card_comment;
    }

    public void setPraiseContainerBgGray(boolean z) {
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.dhL = R.drawable.icon_card_share_s;
            this.jMS = R.color.cp_cont_e;
            return;
        }
        this.dhL = R.drawable.icon_home_card_share;
        this.jMS = R.drawable.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void aId() {
        super.aId();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(dOf, 0, dOf, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(dOf, 0, dOf, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(dOf, 0, dOf, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(dOf, 0, dOf, 0);
        }
    }

    public void addAdMoreView(View view) {
        if (view != null) {
            this.dhn.setVisibility(0);
            this.dhn.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 21));
            this.dhn.addView(view);
        }
    }
}
