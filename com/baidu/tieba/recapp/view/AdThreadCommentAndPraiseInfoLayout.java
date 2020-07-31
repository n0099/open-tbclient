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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.z;
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
/* loaded from: classes20.dex */
public class AdThreadCommentAndPraiseInfoLayout extends ThreadCardBottomOpSegmentWeightLayout {
    public static String URL = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public static int eUa;
    private final int lsn;
    private final int lso;
    private final int lsp;
    private final int lsq;
    private final int lsr;
    private int lss;
    private int lst;
    private a lsu;
    private int style;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.lsn = 446;
        this.lso = 5120;
        this.lsp = 5120;
        this.lsq = 5120;
        this.lsr = 5120;
        this.style = 1;
        this.type = 0;
        this.lss = R.drawable.selector_comment_and_prise_item_text_color;
        this.lst = this.lss;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lsn = 446;
        this.lso = 5120;
        this.lsp = 5120;
        this.lsq = 5120;
        this.lsr = 5120;
        this.style = 1;
        this.type = 0;
        this.lss = R.drawable.selector_comment_and_prise_item_text_color;
        this.lst = this.lss;
        initSetting();
    }

    private void initSetting() {
        eUa = l.getDimens(this.mContext, R.dimen.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(11);
        ddl();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bv bvVar) {
        if (bvVar != null) {
            if (bvVar.dUJ || (bvVar.aTV() && bvVar.sortType == 3)) {
                this.ejB.setAgreeAlone(true);
            } else if (this.ejB.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) this.ejB.getLayoutParams()).weight = 2.0f;
            }
            AgreeData aYc = bvVar.aYc();
            if (aYc != null && aYc.agreeNum == 0 && aYc.diffAgreeNum == 0) {
                aYc.agreeNum = bvVar.aXJ();
                aYc.hasAgree = bvVar.aXL() == 1;
                aYc.agreeType = bvVar.aXM();
                aYc.diffAgreeNum = bvVar.aXJ() - bvVar.aXK();
            }
        }
        super.updatePraiseNum(bvVar);
        if (this.ejB != null) {
            this.ejB.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type != 1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void A(bv bvVar) {
        super.A(bvVar);
        if (this.style == 1) {
            this.agQ.setText(as.cutChineseAndEnglishWithSuffix(bvVar.aWp(), 12, ""));
        }
    }

    public void disableClick() {
        this.ejG.setClickable(false);
        this.ejD.setClickable(false);
    }

    private void ddl() {
        if (this.ejB != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.ejB.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 2) {
                            data.agreeType = 2;
                            data.hasAgree = false;
                            data.diffAgreeNum--;
                            data.agreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.ejB.updateUI();
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum += 2;
                            data.agreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.ejB.hU(true);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum++;
                        data.agreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.ejB.hU(true);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.DY(i);
                }
            };
            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.ejB.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 5) {
                            data.agreeType = 5;
                            data.hasAgree = false;
                            data.diffAgreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.ejB.updateUI();
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum -= 2;
                            data.agreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.ejB.hU(false);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum--;
                        data.disAgreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.ejB.hU(false);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.DY(i);
                }
            };
            this.ejB.getImgAgree().setOnClickListener(onClickListener);
            this.ejB.getAgreeNumView().setOnClickListener(onClickListener);
            this.ejB.getImgDisagree().setOnClickListener(onClickListener2);
            this.ejB.getDisagreeNumView().setOnClickListener(onClickListener2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DY(int i) {
        if (i == 1) {
            a(this.lsu.getThreadData(), "nozan", 0);
            a(this.lsu.getThreadData(), "1", "2");
            return;
        }
        a(this.lsu.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.lsu.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void bb(View view) {
        if (this.aeA != null && this.mContext != null && this.lsu != null) {
            a(this.lsu.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.lsu.getThreadData(), "2", "1");
            if (ShareSwitch.isOn() || bf.checkUpIsLogin(this.mContext)) {
                final ShareItem shareItem = new ShareItem();
                shareItem.title = this.lsu.getTitle();
                shareItem.content = this.lsu.getAbstract();
                shareItem.etQ = this.lsu.getTitle();
                shareItem.linkUrl = this.lsu.getShareLink();
                shareItem.etT = 3;
                shareItem.etH = true;
                String imageUrl = this.lsu.getImageUrl();
                Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        shareItem.linkUrl = g.dr(shareItem.linkUrl, shareItem.tid);
                        com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                        l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(R.string.copy_pb_url_success));
                    }
                });
                shareDialogConfig.setHideMode(MO(shareItem.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.style = i;
    }

    public void setShareData(a aVar) {
        this.lsu = aVar;
        setData(this.lsu.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        c c = com.baidu.tieba.recapp.report.g.c(advertAppInfo, 8, i);
        c.MN(str);
        d.dcY().a(c);
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
                        z zVar = new z(strArr[0]);
                        zVar.addPostData("cpid", strArr[1]);
                        zVar.addPostData("idea_id", strArr[2]);
                        zVar.addPostData("type", str);
                        zVar.addPostData("cmd", str2);
                        zVar.postNetData();
                        return null;
                    }
                    return null;
                }
            }.execute(URL, fq(str3, "cpid"), fq(str3, "idea_id"));
        }
    }

    private String fq(String str, String str2) {
        try {
            return new JSONObject(new String(com.baidu.adp.lib.util.c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.ejD;
    }

    private int MO(String str) {
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
        SvgManager.baR().a(this.ejC, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_e, (SvgManager.SvgResourceStateType) null);
        ao.setViewTextColor(this.dKx, this.lss);
        ao.setViewTextColor(this.ejE, this.lst);
    }

    public void setDisPraiseViewVisibility(boolean z) {
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.lss = R.color.cp_cont_e;
            this.ekf = R.drawable.icon_home_card_comment_s;
            return;
        }
        this.lss = R.drawable.selector_comment_and_prise_item_text_color;
        this.ekf = R.drawable.icon_home_card_comment;
    }

    public void setPraiseContainerBgGray(boolean z) {
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.ekg = R.drawable.icon_card_share_s;
            this.lst = R.color.cp_cont_e;
            return;
        }
        this.ekg = R.drawable.icon_home_card_share;
        this.lst = R.drawable.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void Tk() {
        super.Tk();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(eUa, 0, eUa, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(eUa, 0, eUa, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(eUa, 0, eUa, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(eUa, 0, eUa, 0);
        }
    }

    public void addAdMoreView(View view) {
        if (view != null) {
            this.ejH.setVisibility(0);
            this.ejH.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 21));
            this.ejH.addView(view);
        }
    }
}
