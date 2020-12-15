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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
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
    public static int fPv;
    private final int mOA;
    private final int mOB;
    private int mOC;
    private int mOD;
    private a mOE;
    private final int mOx;
    private final int mOy;
    private final int mOz;
    private int style;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.mOx = 446;
        this.mOy = 5120;
        this.mOz = 5120;
        this.mOA = 5120;
        this.mOB = 5120;
        this.style = 1;
        this.type = 0;
        this.mOC = R.drawable.selector_comment_and_prise_item_text_color;
        this.mOD = this.mOC;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOx = 446;
        this.mOy = 5120;
        this.mOz = 5120;
        this.mOA = 5120;
        this.mOB = 5120;
        this.style = 1;
        this.type = 0;
        this.mOC = R.drawable.selector_comment_and_prise_item_text_color;
        this.mOD = this.mOC;
        initSetting();
    }

    private void initSetting() {
        fPv = l.getDimens(this.mContext, R.dimen.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(11);
        dGt();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(by byVar) {
        if (byVar != null) {
            this.fcF.setAgreeAlone(true);
            if (this.fcF.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) this.fcF.getLayoutParams()).weight = 1.0f;
            }
            AgreeData bqI = byVar.bqI();
            if (bqI != null && bqI.agreeNum == 0 && bqI.diffAgreeNum == 0) {
                bqI.agreeNum = byVar.bqp();
                bqI.hasAgree = byVar.bqr() == 1;
                bqI.agreeType = byVar.bqs();
                bqI.diffAgreeNum = byVar.bqp() - byVar.bqq();
            }
        }
        super.updatePraiseNum(byVar);
        if (this.fcF != null) {
            this.fcF.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type != 1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void D(by byVar) {
        super.D(byVar);
        if (this.style == 1) {
            this.ajT.setText(au.cutChineseAndEnglishWithSuffix(byVar.boT(), 12, ""));
        }
    }

    public void disableClick() {
        this.fcL.setClickable(false);
        this.fcI.setClickable(false);
    }

    private void dGt() {
        if (this.fcF != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.fcF.getData();
                    AdThreadCommentAndPraiseInfoLayout.this.fcF.getImgAgree().cancelAnimation();
                    if (data.hasAgree) {
                        if (data.agreeType == 2) {
                            data.agreeType = 2;
                            data.hasAgree = false;
                            data.diffAgreeNum--;
                            data.agreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.fcF.updateUI();
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum += 2;
                            data.agreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.fcF.jz(true);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum++;
                        data.agreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.fcF.jz(true);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.Jy(i);
                }
            };
            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.fcF.getData();
                    AdThreadCommentAndPraiseInfoLayout.this.fcF.getImgDisagree().cancelAnimation();
                    if (data.hasAgree) {
                        if (data.agreeType == 5) {
                            data.agreeType = 5;
                            data.hasAgree = false;
                            data.diffAgreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.fcF.updateUI();
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum -= 2;
                            data.agreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.fcF.jz(false);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum--;
                        data.disAgreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.fcF.jz(false);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.Jy(i);
                }
            };
            this.fcF.getImgAgree().setOnClickListener(onClickListener);
            this.fcF.getAgreeNumView().setOnClickListener(onClickListener);
            this.fcF.getImgDisagree().setOnClickListener(onClickListener2);
            this.fcF.getDisagreeNumView().setOnClickListener(onClickListener2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jy(int i) {
        if (i == 1) {
            a(this.mOE.getThreadData(), "nozan", 0);
            a(this.mOE.getThreadData(), "1", "2");
            return;
        }
        a(this.mOE.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.mOE.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void bu(View view) {
        if (this.ahA != null && this.mContext != null && this.mOE != null) {
            a(this.mOE.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.mOE.getThreadData(), "2", "1");
            if (ShareSwitch.isOn() || bh.checkUpIsLogin(this.mContext)) {
                final ShareItem shareItem = new ShareItem();
                shareItem.title = this.mOE.getTitle();
                shareItem.content = this.mOE.getAbstract();
                shareItem.fnC = this.mOE.getTitle();
                shareItem.linkUrl = this.mOE.getShareLink();
                shareItem.fnF = 3;
                shareItem.fnr = true;
                String imageUrl = this.mOE.getImageUrl();
                Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        shareItem.linkUrl = g.ec(shareItem.linkUrl, shareItem.tid);
                        com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                        l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(R.string.copy_pb_url_success));
                    }
                });
                shareDialogConfig.setHideMode(Sy(shareItem.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.style = i;
    }

    public void setShareData(a aVar) {
        this.mOE = aVar;
        setData(this.mOE.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        c c = com.baidu.tieba.recapp.report.g.c(advertAppInfo, 8, i);
        c.Sx(str);
        d.dGg().a(c);
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
            }.execute(URL, gl(str3, "cpid"), gl(str3, "idea_id"));
        }
    }

    private String gl(String str, String str2) {
        try {
            return new JSONObject(new String(com.baidu.adp.lib.util.c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.fcI;
    }

    private int Sy(String str) {
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
        this.fcH.setClickable(false);
        this.fcH.setEnabled(false);
        ap.setViewTextColor(this.fcG, this.mOC);
        ap.setViewTextColor(this.fcJ, this.mOD);
    }

    public void setDisPraiseViewVisibility(boolean z) {
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.mOC = R.color.CAM_X0110;
        } else {
            this.mOC = R.drawable.selector_comment_and_prise_item_text_color;
        }
    }

    public void setPraiseContainerBgGray(boolean z) {
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.mOD = R.color.CAM_X0110;
        } else {
            this.mOD = R.drawable.selector_comment_and_prise_item_text_color;
        }
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void akv() {
        super.akv();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(fPv, 0, fPv, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(0, 0, 0, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(fPv, 0, fPv, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(0, 0, 0, 0);
        }
    }

    public void addAdMoreView(View view) {
        if (view != null) {
            this.fcM.setVisibility(0);
            this.fcM.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 21));
            this.fcM.addView(view);
        }
    }
}
