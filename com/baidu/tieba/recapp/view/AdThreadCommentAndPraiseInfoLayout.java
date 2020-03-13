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
    public static int dOs;
    private final int jMY;
    private final int jMZ;
    private final int jNa;
    private final int jNb;
    private final int jNc;
    private int jNd;
    private int jNe;
    private a jNf;
    private int style;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.jMY = 446;
        this.jMZ = 5120;
        this.jNa = 5120;
        this.jNb = 5120;
        this.jNc = 5120;
        this.style = 1;
        this.type = 0;
        this.jNd = R.drawable.selector_comment_and_prise_item_text_color;
        this.jNe = this.jNd;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jMY = 446;
        this.jMZ = 5120;
        this.jNa = 5120;
        this.jNb = 5120;
        this.jNc = 5120;
        this.style = 1;
        this.type = 0;
        this.jNd = R.drawable.selector_comment_and_prise_item_text_color;
        this.jNe = this.jNd;
        initSetting();
    }

    private void initSetting() {
        dOs = l.getDimens(this.mContext, R.dimen.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(9);
        this.dhN = false;
        cDD();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.cUs || (bjVar.aEc() && bjVar.sortType == 3)) {
                this.dht.setAgreeAlone(true);
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
        if (this.dht != null) {
            this.dht.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type != 1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void v(bj bjVar) {
        super.v(bjVar);
        if (this.type == 1 && this.dhP && this.dhz.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dhz.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.dhq;
            layoutParams.weight = 0.0f;
            this.dhz.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void w(bj bjVar) {
        super.w(bjVar);
        if (this.type == 1 && this.dhw != null && this.dhN) {
            this.dhw.setVisibility(0);
            if (this.dhw.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dhw.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.dhq;
                layoutParams.weight = 0.0f;
                this.dhw.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void A(bj bjVar) {
        super.A(bjVar);
        if (this.style == 1) {
            this.dhr.setText(aq.cutChineseAndEnglishWithSuffix(bjVar.aCt(), 12, ""));
        }
    }

    public void disableClick() {
        this.dhz.setClickable(false);
        this.dhw.setClickable(false);
    }

    private void cDD() {
        if (this.dht != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.dht.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 2) {
                            data.agreeType = 2;
                            data.hasAgree = false;
                            data.diffAgreeNum--;
                            data.agreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.dht.updateUI();
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum += 2;
                            data.agreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.dht.fN(true);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum++;
                        data.agreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.dht.fN(true);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.Bg(i);
                }
            };
            this.dht.getImgAgree().setOnClickListener(onClickListener);
            this.dht.getAgreeNumView().setOnClickListener(onClickListener);
            this.dht.getImgDisagree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.dht.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 5) {
                            data.agreeType = 5;
                            data.hasAgree = false;
                            data.diffAgreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.dht.updateUI();
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum -= 2;
                            data.agreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.dht.fN(false);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum--;
                        data.disAgreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.dht.fN(false);
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
            a(this.jNf.getThreadData(), "nozan", 0);
            a(this.jNf.getThreadData(), "1", "2");
            return;
        }
        a(this.jNf.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.jNf.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aT(View view) {
        if (this.KJ != null && this.mContext != null && this.jNf != null) {
            a(this.jNf.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.jNf.getThreadData(), "2", "1");
            if (ShareSwitch.isOn() || bc.checkUpIsLogin(this.mContext)) {
                final ShareItem shareItem = new ShareItem();
                shareItem.title = this.jNf.getTitle();
                shareItem.content = this.jNf.getAbstract();
                shareItem.dqp = this.jNf.getTitle();
                shareItem.linkUrl = this.jNf.getShareLink();
                shareItem.dqs = 3;
                shareItem.dqf = true;
                String imageUrl = this.jNf.getImageUrl();
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
                shareDialogConfig.setHideMode(Il(shareItem.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.style = i;
    }

    public void setShareData(a aVar) {
        this.jNf = aVar;
        setData(this.jNf.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 8, i);
        c.Ik(str);
        c.cDq().a(c);
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
        return this.dhw;
    }

    private int Il(String str) {
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
        am.setViewTextColor(this.dhu, this.jNd);
        am.setViewTextColor(this.dhx, this.jNe);
    }

    public void setDisPraiseViewVisibility(boolean z) {
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.jNd = R.color.cp_cont_e;
            this.dhX = R.drawable.icon_home_card_comment_s;
            return;
        }
        this.jNd = R.drawable.selector_comment_and_prise_item_text_color;
        this.dhX = R.drawable.icon_home_card_comment;
    }

    public void setPraiseContainerBgGray(boolean z) {
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.dhY = R.drawable.icon_card_share_s;
            this.jNe = R.color.cp_cont_e;
            return;
        }
        this.dhY = R.drawable.icon_home_card_share;
        this.jNe = R.drawable.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void aIe() {
        super.aIe();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(dOs, 0, dOs, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(dOs, 0, dOs, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(dOs, 0, dOs, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(dOs, 0, dOs, 0);
        }
    }

    public void addAdMoreView(View view) {
        if (view != null) {
            this.dhA.setVisibility(0);
            this.dhA.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 21));
            this.dhA.addView(view);
        }
    }
}
