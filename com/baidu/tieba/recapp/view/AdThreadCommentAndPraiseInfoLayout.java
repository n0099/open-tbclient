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
import com.baidu.tieba.recapp.report.c;
import com.baidu.tieba.recapp.report.d;
import com.baidu.tieba.recapp.report.g;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class AdThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    public static String URL = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public static int eoD;
    private final int kxU;
    private final int kxV;
    private final int kxW;
    private final int kxX;
    private final int kxY;
    private int kxZ;
    private int kya;
    private a kyb;
    private int style;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.kxU = 446;
        this.kxV = 5120;
        this.kxW = 5120;
        this.kxX = 5120;
        this.kxY = 5120;
        this.style = 1;
        this.type = 0;
        this.kxZ = R.drawable.selector_comment_and_prise_item_text_color;
        this.kya = this.kxZ;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kxU = 446;
        this.kxV = 5120;
        this.kxW = 5120;
        this.kxX = 5120;
        this.kxY = 5120;
        this.style = 1;
        this.type = 0;
        this.kxZ = R.drawable.selector_comment_and_prise_item_text_color;
        this.kya = this.kxZ;
        initSetting();
    }

    private void initSetting() {
        eoD = l.getDimens(this.mContext, R.dimen.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(9);
        this.dHW = false;
        cOy();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.dtQ || (bjVar.aMu() && bjVar.sortType == 3)) {
                this.dHB.setAgreeAlone(true);
            }
            AgreeData aMs = bjVar.aMs();
            if (aMs != null && aMs.agreeNum == 0 && aMs.diffAgreeNum == 0) {
                aMs.agreeNum = bjVar.aLZ();
                aMs.hasAgree = bjVar.aMb() == 1;
                aMs.agreeType = bjVar.aMc();
                aMs.diffAgreeNum = bjVar.aLZ() - bjVar.aMa();
            }
        }
        super.updatePraiseNum(bjVar);
        if (this.dHB != null) {
            this.dHB.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type != 1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void w(bj bjVar) {
        super.w(bjVar);
        if (this.type == 1 && this.dHY && this.dHH.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dHH.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.dHy;
            layoutParams.weight = 0.0f;
            this.dHH.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void x(bj bjVar) {
        super.x(bjVar);
        if (this.type == 1 && this.dHE != null && this.dHW) {
            this.dHE.setVisibility(0);
            if (this.dHE.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dHE.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.dHy;
                layoutParams.weight = 0.0f;
                this.dHE.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void B(bj bjVar) {
        super.B(bjVar);
        if (this.style == 1) {
            this.dHz.setText(aq.cutChineseAndEnglishWithSuffix(bjVar.aKJ(), 12, ""));
        }
    }

    public void disableClick() {
        this.dHH.setClickable(false);
        this.dHE.setClickable(false);
    }

    private void cOy() {
        if (this.dHB != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.dHB.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 2) {
                            data.agreeType = 2;
                            data.hasAgree = false;
                            data.diffAgreeNum--;
                            data.agreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.dHB.updateUI();
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum += 2;
                            data.agreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.dHB.gM(true);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum++;
                        data.agreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.dHB.gM(true);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.BO(i);
                }
            };
            this.dHB.getImgAgree().setOnClickListener(onClickListener);
            this.dHB.getAgreeNumView().setOnClickListener(onClickListener);
            this.dHB.getImgDisagree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.dHB.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 5) {
                            data.agreeType = 5;
                            data.hasAgree = false;
                            data.diffAgreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.dHB.updateUI();
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum -= 2;
                            data.agreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.dHB.gM(false);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum--;
                        data.disAgreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.dHB.gM(false);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.BO(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BO(int i) {
        if (i == 1) {
            a(this.kyb.getThreadData(), "nozan", 0);
            a(this.kyb.getThreadData(), "1", "2");
            return;
        }
        a(this.kyb.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.kyb.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aU(View view) {
        if (this.adG != null && this.mContext != null && this.kyb != null) {
            a(this.kyb.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.kyb.getThreadData(), "2", "1");
            if (ShareSwitch.isOn() || bc.checkUpIsLogin(this.mContext)) {
                final ShareItem shareItem = new ShareItem();
                shareItem.title = this.kyb.getTitle();
                shareItem.content = this.kyb.getAbstract();
                shareItem.dQv = this.kyb.getTitle();
                shareItem.linkUrl = this.kyb.getShareLink();
                shareItem.dQy = 3;
                shareItem.dQl = true;
                String imageUrl = this.kyb.getImageUrl();
                Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        shareItem.linkUrl = f.cO(shareItem.linkUrl, shareItem.tid);
                        com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                        l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(R.string.copy_pb_url_success));
                    }
                });
                shareDialogConfig.setHideMode(JP(shareItem.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.style = i;
    }

    public void setShareData(a aVar) {
        this.kyb = aVar;
        setData(this.kyb.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        c c = g.c(advertAppInfo, 8, i);
        c.JO(str);
        d.cOl().a(c);
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
            }.execute(URL, eG(str3, "cpid"), eG(str3, "idea_id"));
        }
    }

    private String eG(String str, String str2) {
        try {
            return new JSONObject(new String(com.baidu.adp.lib.util.c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.dHE;
    }

    private int JP(String str) {
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
        am.setViewTextColor(this.dHC, this.kxZ);
        am.setViewTextColor(this.dHF, this.kya);
    }

    public void setDisPraiseViewVisibility(boolean z) {
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.kxZ = R.color.cp_cont_e;
            this.dIg = R.drawable.icon_home_card_comment_s;
            return;
        }
        this.kxZ = R.drawable.selector_comment_and_prise_item_text_color;
        this.dIg = R.drawable.icon_home_card_comment;
    }

    public void setPraiseContainerBgGray(boolean z) {
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.dIh = R.drawable.icon_card_share_s;
            this.kya = R.color.cp_cont_e;
            return;
        }
        this.dIh = R.drawable.icon_home_card_share;
        this.kya = R.drawable.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void aQE() {
        super.aQE();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(eoD, 0, eoD, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(eoD, 0, eoD, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(eoD, 0, eoD, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(eoD, 0, eoD, 0);
        }
    }

    public void addAdMoreView(View view) {
        if (view != null) {
            this.dHI.setVisibility(0);
            this.dHI.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 21));
            this.dHI.addView(view);
        }
    }
}
