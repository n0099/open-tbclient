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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.recapp.c.a;
import com.baidu.tieba.recapp.report.c;
import com.baidu.tieba.recapp.report.d;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import org.json.JSONObject;
/* loaded from: classes26.dex */
public class AdThreadCommentAndPraiseInfoLayout extends ThreadCardBottomOpSegmentWeightLayout {
    public static String URL = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public static int ftT;
    private final int mhj;
    private final int mhk;
    private final int mhl;
    private final int mhm;
    private final int mhn;
    private int mho;
    private int mhp;
    private a mhq;
    private int style;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.mhj = 446;
        this.mhk = 5120;
        this.mhl = 5120;
        this.mhm = 5120;
        this.mhn = 5120;
        this.style = 1;
        this.type = 0;
        this.mho = R.drawable.selector_comment_and_prise_item_text_color;
        this.mhp = this.mho;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mhj = 446;
        this.mhk = 5120;
        this.mhl = 5120;
        this.mhm = 5120;
        this.mhn = 5120;
        this.style = 1;
        this.type = 0;
        this.mho = R.drawable.selector_comment_and_prise_item_text_color;
        this.mhp = this.mho;
        initSetting();
    }

    private void initSetting() {
        ftT = l.getDimens(this.mContext, R.dimen.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(11);
        dvT();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bw bwVar) {
        if (bwVar != null) {
            if (bwVar.esz || (bwVar.bfP() && bwVar.sortType == 3)) {
                this.eHO.setAgreeAlone(true);
            } else if (this.eHO.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) this.eHO.getLayoutParams()).weight = 2.0f;
            }
            AgreeData bjY = bwVar.bjY();
            if (bjY != null && bjY.agreeNum == 0 && bjY.diffAgreeNum == 0) {
                bjY.agreeNum = bwVar.bjF();
                bjY.hasAgree = bwVar.bjH() == 1;
                bjY.agreeType = bwVar.bjI();
                bjY.diffAgreeNum = bwVar.bjF() - bwVar.bjG();
            }
        }
        super.updatePraiseNum(bwVar);
        if (this.eHO != null) {
            this.eHO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type != 1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void B(bw bwVar) {
        super.B(bwVar);
        if (this.style == 1) {
            this.aiO.setText(at.cutChineseAndEnglishWithSuffix(bwVar.bil(), 12, ""));
        }
    }

    public void disableClick() {
        this.eHT.setClickable(false);
        this.eHQ.setClickable(false);
    }

    private void dvT() {
        if (this.eHO != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.eHO.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 2) {
                            data.agreeType = 2;
                            data.hasAgree = false;
                            data.diffAgreeNum--;
                            data.agreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.eHO.updateUI();
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum += 2;
                            data.agreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.eHO.iN(true);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum++;
                        data.agreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.eHO.iN(true);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.HA(i);
                }
            };
            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.eHO.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 5) {
                            data.agreeType = 5;
                            data.hasAgree = false;
                            data.diffAgreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.eHO.updateUI();
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum -= 2;
                            data.agreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.eHO.iN(false);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum--;
                        data.disAgreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.eHO.iN(false);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.HA(i);
                }
            };
            this.eHO.getImgAgree().setOnClickListener(onClickListener);
            this.eHO.getAgreeNumView().setOnClickListener(onClickListener);
            this.eHO.getImgDisagree().setOnClickListener(onClickListener2);
            this.eHO.getDisagreeNumView().setOnClickListener(onClickListener2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HA(int i) {
        if (i == 1) {
            a(this.mhq.getThreadData(), "nozan", 0);
            a(this.mhq.getThreadData(), "1", "2");
            return;
        }
        a(this.mhq.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.mhq.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void bj(View view) {
        if (this.agw != null && this.mContext != null && this.mhq != null) {
            a(this.mhq.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.mhq.getThreadData(), "2", "1");
            if (ShareSwitch.isOn() || bg.checkUpIsLogin(this.mContext)) {
                final ShareItem shareItem = new ShareItem();
                shareItem.title = this.mhq.getTitle();
                shareItem.content = this.mhq.getAbstract();
                shareItem.eSH = this.mhq.getTitle();
                shareItem.linkUrl = this.mhq.getShareLink();
                shareItem.eSK = 3;
                shareItem.eSw = true;
                String imageUrl = this.mhq.getImageUrl();
                Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        shareItem.linkUrl = g.dO(shareItem.linkUrl, shareItem.tid);
                        com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                        l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(R.string.copy_pb_url_success));
                    }
                });
                shareDialogConfig.setHideMode(QZ(shareItem.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.style = i;
    }

    public void setShareData(a aVar) {
        this.mhq = aVar;
        setData(this.mhq.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        c c = com.baidu.tieba.recapp.report.g.c(advertAppInfo, 8, i);
        c.QY(str);
        d.dvG().a(c);
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
                        aa aaVar = new aa(strArr[0]);
                        aaVar.addPostData("cpid", strArr[1]);
                        aaVar.addPostData("idea_id", strArr[2]);
                        aaVar.addPostData("type", str);
                        aaVar.addPostData("cmd", str2);
                        aaVar.postNetData();
                        return null;
                    }
                    return null;
                }
            }.execute(URL, gb(str3, "cpid"), gb(str3, "idea_id"));
        }
    }

    private String gb(String str, String str2) {
        try {
            return new JSONObject(new String(com.baidu.adp.lib.util.c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.eHQ;
    }

    private int QZ(String str) {
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
        SvgManager.bmU().a(this.eHP, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_e, (SvgManager.SvgResourceStateType) null);
        ap.setViewTextColor(this.ehV, this.mho);
        ap.setViewTextColor(this.eHR, this.mhp);
    }

    public void setDisPraiseViewVisibility(boolean z) {
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.mho = R.color.cp_cont_e;
            this.eIs = R.drawable.icon_home_card_comment_s;
            return;
        }
        this.mho = R.drawable.selector_comment_and_prise_item_text_color;
        this.eIs = R.drawable.icon_home_card_comment;
    }

    public void setPraiseContainerBgGray(boolean z) {
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.eIt = R.drawable.icon_card_share_s;
            this.mhp = R.color.cp_cont_e;
            return;
        }
        this.eIt = R.drawable.icon_home_card_share;
        this.mhp = R.drawable.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void adB() {
        super.adB();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(ftT, 0, ftT, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(ftT, 0, ftT, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(ftT, 0, ftT, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(ftT, 0, ftT, 0);
        }
    }

    public void addAdMoreView(View view) {
        if (view != null) {
            this.eHU.setVisibility(0);
            this.eHU.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 21));
            this.eHU.addView(view);
        }
    }
}
