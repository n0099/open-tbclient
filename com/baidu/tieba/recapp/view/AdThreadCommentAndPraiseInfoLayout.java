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
/* loaded from: classes20.dex */
public class AdThreadCommentAndPraiseInfoLayout extends ThreadCardBottomOpSegmentWeightLayout {
    public static String URL = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public static int feH;
    private final int lIK;
    private final int lIL;
    private final int lIM;
    private final int lIN;
    private final int lIO;
    private int lIP;
    private int lIQ;
    private a lIR;
    private int style;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.lIK = 446;
        this.lIL = 5120;
        this.lIM = 5120;
        this.lIN = 5120;
        this.lIO = 5120;
        this.style = 1;
        this.type = 0;
        this.lIP = R.drawable.selector_comment_and_prise_item_text_color;
        this.lIQ = this.lIP;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lIK = 446;
        this.lIL = 5120;
        this.lIM = 5120;
        this.lIN = 5120;
        this.lIO = 5120;
        this.style = 1;
        this.type = 0;
        this.lIP = R.drawable.selector_comment_and_prise_item_text_color;
        this.lIQ = this.lIP;
        initSetting();
    }

    private void initSetting() {
        feH = l.getDimens(this.mContext, R.dimen.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(11);
        dov();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bw bwVar) {
        if (bwVar != null) {
            if (bwVar.eef || (bwVar.bcm() && bwVar.sortType == 3)) {
                this.etw.setAgreeAlone(true);
            } else if (this.etw.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) this.etw.getLayoutParams()).weight = 2.0f;
            }
            AgreeData bgv = bwVar.bgv();
            if (bgv != null && bgv.agreeNum == 0 && bgv.diffAgreeNum == 0) {
                bgv.agreeNum = bwVar.bgc();
                bgv.hasAgree = bwVar.bge() == 1;
                bgv.agreeType = bwVar.bgf();
                bgv.diffAgreeNum = bwVar.bgc() - bwVar.bgd();
            }
        }
        super.updatePraiseNum(bwVar);
        if (this.etw != null) {
            this.etw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type != 1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void A(bw bwVar) {
        super.A(bwVar);
        if (this.style == 1) {
            this.ahZ.setText(at.cutChineseAndEnglishWithSuffix(bwVar.beI(), 12, ""));
        }
    }

    public void disableClick() {
        this.etB.setClickable(false);
        this.ety.setClickable(false);
    }

    private void dov() {
        if (this.etw != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.etw.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 2) {
                            data.agreeType = 2;
                            data.hasAgree = false;
                            data.diffAgreeNum--;
                            data.agreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.etw.updateUI();
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum += 2;
                            data.agreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.etw.ir(true);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum++;
                        data.agreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.etw.ir(true);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.Gt(i);
                }
            };
            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.etw.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 5) {
                            data.agreeType = 5;
                            data.hasAgree = false;
                            data.diffAgreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.etw.updateUI();
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum -= 2;
                            data.agreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.etw.ir(false);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum--;
                        data.disAgreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.etw.ir(false);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.Gt(i);
                }
            };
            this.etw.getImgAgree().setOnClickListener(onClickListener);
            this.etw.getAgreeNumView().setOnClickListener(onClickListener);
            this.etw.getImgDisagree().setOnClickListener(onClickListener2);
            this.etw.getDisagreeNumView().setOnClickListener(onClickListener2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gt(int i) {
        if (i == 1) {
            a(this.lIR.getThreadData(), "nozan", 0);
            a(this.lIR.getThreadData(), "1", "2");
            return;
        }
        a(this.lIR.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.lIR.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void bd(View view) {
        if (this.afJ != null && this.mContext != null && this.lIR != null) {
            a(this.lIR.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.lIR.getThreadData(), "2", "1");
            if (ShareSwitch.isOn() || bg.checkUpIsLogin(this.mContext)) {
                final ShareItem shareItem = new ShareItem();
                shareItem.title = this.lIR.getTitle();
                shareItem.content = this.lIR.getAbstract();
                shareItem.eEq = this.lIR.getTitle();
                shareItem.linkUrl = this.lIR.getShareLink();
                shareItem.eEt = 3;
                shareItem.eEf = true;
                String imageUrl = this.lIR.getImageUrl();
                Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        shareItem.linkUrl = g.dH(shareItem.linkUrl, shareItem.tid);
                        com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                        l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(R.string.copy_pb_url_success));
                    }
                });
                shareDialogConfig.setHideMode(PL(shareItem.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.style = i;
    }

    public void setShareData(a aVar) {
        this.lIR = aVar;
        setData(this.lIR.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        c c = com.baidu.tieba.recapp.report.g.c(advertAppInfo, 8, i);
        c.PK(str);
        d.doi().a(c);
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
            }.execute(URL, fH(str3, "cpid"), fH(str3, "idea_id"));
        }
    }

    private String fH(String str, String str2) {
        try {
            return new JSONObject(new String(com.baidu.adp.lib.util.c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.ety;
    }

    private int PL(String str) {
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
        SvgManager.bjq().a(this.etx, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_e, (SvgManager.SvgResourceStateType) null);
        ap.setViewTextColor(this.dTF, this.lIP);
        ap.setViewTextColor(this.etz, this.lIQ);
    }

    public void setDisPraiseViewVisibility(boolean z) {
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.lIP = R.color.cp_cont_e;
            this.eua = R.drawable.icon_home_card_comment_s;
            return;
        }
        this.lIP = R.drawable.selector_comment_and_prise_item_text_color;
        this.eua = R.drawable.icon_home_card_comment;
    }

    public void setPraiseContainerBgGray(boolean z) {
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.eub = R.drawable.icon_card_share_s;
            this.lIQ = R.color.cp_cont_e;
            return;
        }
        this.eub = R.drawable.icon_home_card_share;
        this.lIQ = R.drawable.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void aag() {
        super.aag();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(feH, 0, feH, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(feH, 0, feH, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(feH, 0, feH, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(feH, 0, feH, 0);
        }
    }

    public void addAdMoreView(View view) {
        if (view != null) {
            this.etC.setVisibility(0);
            this.etC.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 21));
            this.etC.addView(view);
        }
    }
}
