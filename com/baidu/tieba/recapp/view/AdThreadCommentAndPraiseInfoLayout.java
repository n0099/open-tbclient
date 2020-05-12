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
    public static int eoI;
    private final int kxY;
    private final int kxZ;
    private final int kya;
    private final int kyb;
    private final int kyc;
    private int kyd;
    private int kye;
    private a kyf;
    private int style;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.kxY = 446;
        this.kxZ = 5120;
        this.kya = 5120;
        this.kyb = 5120;
        this.kyc = 5120;
        this.style = 1;
        this.type = 0;
        this.kyd = R.drawable.selector_comment_and_prise_item_text_color;
        this.kye = this.kyd;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kxY = 446;
        this.kxZ = 5120;
        this.kya = 5120;
        this.kyb = 5120;
        this.kyc = 5120;
        this.style = 1;
        this.type = 0;
        this.kyd = R.drawable.selector_comment_and_prise_item_text_color;
        this.kye = this.kyd;
        initSetting();
    }

    private void initSetting() {
        eoI = l.getDimens(this.mContext, R.dimen.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(9);
        this.dIa = false;
        cOw();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.dtU || (bjVar.aMs() && bjVar.sortType == 3)) {
                this.dHF.setAgreeAlone(true);
            }
            AgreeData aMq = bjVar.aMq();
            if (aMq != null && aMq.agreeNum == 0 && aMq.diffAgreeNum == 0) {
                aMq.agreeNum = bjVar.aLX();
                aMq.hasAgree = bjVar.aLZ() == 1;
                aMq.agreeType = bjVar.aMa();
                aMq.diffAgreeNum = bjVar.aLX() - bjVar.aLY();
            }
        }
        super.updatePraiseNum(bjVar);
        if (this.dHF != null) {
            this.dHF.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type != 1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void w(bj bjVar) {
        super.w(bjVar);
        if (this.type == 1 && this.dIc && this.dHL.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dHL.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.dHC;
            layoutParams.weight = 0.0f;
            this.dHL.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void x(bj bjVar) {
        super.x(bjVar);
        if (this.type == 1 && this.dHI != null && this.dIa) {
            this.dHI.setVisibility(0);
            if (this.dHI.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dHI.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.dHC;
                layoutParams.weight = 0.0f;
                this.dHI.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void B(bj bjVar) {
        super.B(bjVar);
        if (this.style == 1) {
            this.dHD.setText(aq.cutChineseAndEnglishWithSuffix(bjVar.aKH(), 12, ""));
        }
    }

    public void disableClick() {
        this.dHL.setClickable(false);
        this.dHI.setClickable(false);
    }

    private void cOw() {
        if (this.dHF != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.dHF.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 2) {
                            data.agreeType = 2;
                            data.hasAgree = false;
                            data.diffAgreeNum--;
                            data.agreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.dHF.updateUI();
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum += 2;
                            data.agreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.dHF.gM(true);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum++;
                        data.agreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.dHF.gM(true);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.BO(i);
                }
            };
            this.dHF.getImgAgree().setOnClickListener(onClickListener);
            this.dHF.getAgreeNumView().setOnClickListener(onClickListener);
            this.dHF.getImgDisagree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.dHF.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 5) {
                            data.agreeType = 5;
                            data.hasAgree = false;
                            data.diffAgreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.dHF.updateUI();
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum -= 2;
                            data.agreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.dHF.gM(false);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum--;
                        data.disAgreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.dHF.gM(false);
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
            a(this.kyf.getThreadData(), "nozan", 0);
            a(this.kyf.getThreadData(), "1", "2");
            return;
        }
        a(this.kyf.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.kyf.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aU(View view) {
        if (this.adJ != null && this.mContext != null && this.kyf != null) {
            a(this.kyf.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.kyf.getThreadData(), "2", "1");
            if (ShareSwitch.isOn() || bc.checkUpIsLogin(this.mContext)) {
                final ShareItem shareItem = new ShareItem();
                shareItem.title = this.kyf.getTitle();
                shareItem.content = this.kyf.getAbstract();
                shareItem.dQA = this.kyf.getTitle();
                shareItem.linkUrl = this.kyf.getShareLink();
                shareItem.dQD = 3;
                shareItem.dQq = true;
                String imageUrl = this.kyf.getImageUrl();
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
                shareDialogConfig.setHideMode(JS(shareItem.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.style = i;
    }

    public void setShareData(a aVar) {
        this.kyf = aVar;
        setData(this.kyf.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        c c = g.c(advertAppInfo, 8, i);
        c.JR(str);
        d.cOj().a(c);
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
        return this.dHI;
    }

    private int JS(String str) {
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
        am.setViewTextColor(this.dHG, this.kyd);
        am.setViewTextColor(this.dHJ, this.kye);
    }

    public void setDisPraiseViewVisibility(boolean z) {
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.kyd = R.color.cp_cont_e;
            this.dIk = R.drawable.icon_home_card_comment_s;
            return;
        }
        this.kyd = R.drawable.selector_comment_and_prise_item_text_color;
        this.dIk = R.drawable.icon_home_card_comment;
    }

    public void setPraiseContainerBgGray(boolean z) {
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.dIl = R.drawable.icon_card_share_s;
            this.kye = R.color.cp_cont_e;
            return;
        }
        this.dIl = R.drawable.icon_home_card_share;
        this.kye = R.drawable.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void aQB() {
        super.aQB();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(eoI, 0, eoI, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(eoI, 0, eoI, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(eoI, 0, eoI, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(eoI, 0, eoI, 0);
        }
    }

    public void addAdMoreView(View view) {
        if (view != null) {
            this.dHM.setVisibility(0);
            this.dHM.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 21));
            this.dHM.addView(view);
        }
    }
}
