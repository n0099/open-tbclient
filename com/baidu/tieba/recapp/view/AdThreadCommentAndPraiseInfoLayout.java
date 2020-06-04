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
import com.baidu.tbadk.core.data.bk;
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
import com.baidu.tieba.recapp.report.c;
import com.baidu.tieba.recapp.report.d;
import com.baidu.tieba.recapp.report.g;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class AdThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    public static String URL = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public static int eDv;
    private final int kRa;
    private final int kRb;
    private final int kRc;
    private final int kRd;
    private final int kRe;
    private int kRf;
    private int kRg;
    private a kRh;
    private int style;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.kRa = 446;
        this.kRb = 5120;
        this.kRc = 5120;
        this.kRd = 5120;
        this.kRe = 5120;
        this.style = 1;
        this.type = 0;
        this.kRf = R.drawable.selector_comment_and_prise_item_text_color;
        this.kRg = this.kRf;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kRa = 446;
        this.kRb = 5120;
        this.kRc = 5120;
        this.kRd = 5120;
        this.kRe = 5120;
        this.style = 1;
        this.type = 0;
        this.kRf = R.drawable.selector_comment_and_prise_item_text_color;
        this.kRg = this.kRf;
        initSetting();
    }

    private void initSetting() {
        eDv = l.getDimens(this.mContext, R.dimen.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(9);
        this.dWp = false;
        cVN();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bk bkVar) {
        if (bkVar != null) {
            if (bkVar.dHM || (bkVar.aSr() && bkVar.sortType == 3)) {
                this.dVU.setAgreeAlone(true);
            }
            AgreeData aSp = bkVar.aSp();
            if (aSp != null && aSp.agreeNum == 0 && aSp.diffAgreeNum == 0) {
                aSp.agreeNum = bkVar.aRW();
                aSp.hasAgree = bkVar.aRY() == 1;
                aSp.agreeType = bkVar.aRZ();
                aSp.diffAgreeNum = bkVar.aRW() - bkVar.aRX();
            }
        }
        super.updatePraiseNum(bkVar);
        if (this.dVU != null) {
            this.dVU.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type != 1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void x(bk bkVar) {
        super.x(bkVar);
        if (this.type == 1 && this.dWr && this.dWa.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dWa.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.dVR;
            layoutParams.weight = 0.0f;
            this.dWa.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void y(bk bkVar) {
        super.y(bkVar);
        if (this.type == 1 && this.dVX != null && this.dWp) {
            this.dVX.setVisibility(0);
            if (this.dVX.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dVX.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.dVR;
                layoutParams.weight = 0.0f;
                this.dVX.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void C(bk bkVar) {
        super.C(bkVar);
        if (this.style == 1) {
            this.dVS.setText(aq.cutChineseAndEnglishWithSuffix(bkVar.aQC(), 12, ""));
        }
    }

    public void disableClick() {
        this.dWa.setClickable(false);
        this.dVX.setClickable(false);
    }

    private void cVN() {
        if (this.dVU != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.dVU.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 2) {
                            data.agreeType = 2;
                            data.hasAgree = false;
                            data.diffAgreeNum--;
                            data.agreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.dVU.updateUI();
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum += 2;
                            data.agreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.dVU.hg(true);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum++;
                        data.agreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.dVU.hg(true);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.CA(i);
                }
            };
            this.dVU.getImgAgree().setOnClickListener(onClickListener);
            this.dVU.getAgreeNumView().setOnClickListener(onClickListener);
            this.dVU.getImgDisagree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.dVU.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 5) {
                            data.agreeType = 5;
                            data.hasAgree = false;
                            data.diffAgreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.dVU.updateUI();
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum -= 2;
                            data.agreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.dVU.hg(false);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum--;
                        data.disAgreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.dVU.hg(false);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.CA(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CA(int i) {
        if (i == 1) {
            a(this.kRh.getThreadData(), "nozan", 0);
            a(this.kRh.getThreadData(), "1", "2");
            return;
        }
        a(this.kRh.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.kRh.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aV(View view) {
        if (this.aee != null && this.mContext != null && this.kRh != null) {
            a(this.kRh.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.kRh.getThreadData(), "2", "1");
            if (ShareSwitch.isOn() || bc.checkUpIsLogin(this.mContext)) {
                final ShareItem shareItem = new ShareItem();
                shareItem.title = this.kRh.getTitle();
                shareItem.content = this.kRh.getAbstract();
                shareItem.eeT = this.kRh.getTitle();
                shareItem.linkUrl = this.kRh.getShareLink();
                shareItem.eeW = 3;
                shareItem.eeK = true;
                String imageUrl = this.kRh.getImageUrl();
                Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        shareItem.linkUrl = f.dn(shareItem.linkUrl, shareItem.tid);
                        com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                        l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(R.string.copy_pb_url_success));
                    }
                });
                shareDialogConfig.setHideMode(LF(shareItem.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.style = i;
    }

    public void setShareData(a aVar) {
        this.kRh = aVar;
        setData(this.kRh.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        c c = g.c(advertAppInfo, 8, i);
        c.LE(str);
        d.cVA().a(c);
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
            }.execute(URL, fh(str3, "cpid"), fh(str3, "idea_id"));
        }
    }

    private String fh(String str, String str2) {
        try {
            return new JSONObject(new String(com.baidu.adp.lib.util.c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.dVX;
    }

    private int LF(String str) {
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
        am.setViewTextColor(this.dVV, this.kRf);
        am.setViewTextColor(this.dVY, this.kRg);
    }

    public void setDisPraiseViewVisibility(boolean z) {
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.kRf = R.color.cp_cont_e;
            this.dWz = R.drawable.icon_home_card_comment_s;
            return;
        }
        this.kRf = R.drawable.selector_comment_and_prise_item_text_color;
        this.dWz = R.drawable.icon_home_card_comment;
    }

    public void setPraiseContainerBgGray(boolean z) {
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.dWA = R.drawable.icon_card_share_s;
            this.kRg = R.color.cp_cont_e;
            return;
        }
        this.dWA = R.drawable.icon_home_card_share;
        this.kRg = R.drawable.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void aWC() {
        super.aWC();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(eDv, 0, eDv, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(eDv, 0, eDv, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(eDv, 0, eDv, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(eDv, 0, eDv, 0);
        }
    }

    public void addAdMoreView(View view) {
        if (view != null) {
            this.dWb.setVisibility(0);
            this.dWb.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 21));
            this.dWb.addView(view);
        }
    }
}
