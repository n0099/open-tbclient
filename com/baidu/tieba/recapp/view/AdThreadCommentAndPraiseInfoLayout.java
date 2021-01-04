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
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.recapp.b.a;
import com.baidu.tieba.recapp.report.c;
import com.baidu.tieba.recapp.report.e;
import com.baidu.tieba.recapp.report.h;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class AdThreadCommentAndPraiseInfoLayout extends ThreadCardBottomOpSegmentWeightLayout {
    public static String URL = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public static int fYY;
    private final int mTJ;
    private final int mTK;
    private final int mTL;
    private final int mTM;
    private final int mTN;
    private int mTO;
    private int mTP;
    private a mTQ;
    private int style;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.mTJ = 446;
        this.mTK = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.mTL = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.mTM = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.mTN = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.style = 1;
        this.type = 0;
        this.mTO = R.drawable.selector_comment_and_prise_item_text_color;
        this.mTP = this.mTO;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTJ = 446;
        this.mTK = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.mTL = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.mTM = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.mTN = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.style = 1;
        this.type = 0;
        this.mTO = R.drawable.selector_comment_and_prise_item_text_color;
        this.mTP = this.mTO;
        initSetting();
    }

    private void initSetting() {
        fYY = l.getDimens(this.mContext, R.dimen.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(11);
        dGi();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bz bzVar) {
        if (bzVar != null) {
            this.fmo.setAgreeAlone(true);
            if (this.fmo.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) this.fmo.getLayoutParams()).weight = 1.0f;
            }
            AgreeData btk = bzVar.btk();
            if (btk != null && btk.agreeNum == 0 && btk.diffAgreeNum == 0) {
                btk.agreeNum = bzVar.bsR();
                btk.hasAgree = bzVar.bsT() == 1;
                btk.agreeType = bzVar.bsU();
                btk.diffAgreeNum = bzVar.bsR() - bzVar.bsS();
            }
        }
        super.updatePraiseNum(bzVar);
        if (this.fmo != null) {
            this.fmo.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type != 1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void D(bz bzVar) {
        super.D(bzVar);
        if (this.style == 1) {
            this.akv.setText(at.cutChineseAndEnglishWithSuffix(bzVar.bru(), 12, ""));
        }
    }

    public void disableClick() {
        this.fmv.setClickable(false);
        this.fms.setClickable(false);
    }

    private void dGi() {
        if (this.fmo != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.fmo.getData();
                    if (data != null) {
                        AdThreadCommentAndPraiseInfoLayout.this.fmo.getImgAgree().cancelAnimation();
                        if (data.hasAgree) {
                            if (data.agreeType == 2) {
                                data.agreeType = 2;
                                data.hasAgree = false;
                                data.diffAgreeNum--;
                                data.agreeNum--;
                                AdThreadCommentAndPraiseInfoLayout.this.fmo.updateUI();
                            } else {
                                data.agreeType = 2;
                                data.hasAgree = true;
                                data.diffAgreeNum += 2;
                                data.agreeNum++;
                                data.disAgreeNum--;
                                AdThreadCommentAndPraiseInfoLayout.this.fmo.jV(true);
                                i = 0;
                            }
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum++;
                            data.agreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.fmo.jV(true);
                            i = 0;
                        }
                        AdThreadCommentAndPraiseInfoLayout.this.Js(i);
                    }
                }
            };
            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.fmo.getData();
                    if (data != null) {
                        AdThreadCommentAndPraiseInfoLayout.this.fmo.getImgDisagree().cancelAnimation();
                        if (data.hasAgree) {
                            if (data.agreeType == 5) {
                                data.agreeType = 5;
                                data.hasAgree = false;
                                data.diffAgreeNum++;
                                data.disAgreeNum--;
                                AdThreadCommentAndPraiseInfoLayout.this.fmo.updateUI();
                            } else {
                                data.agreeType = 5;
                                data.hasAgree = true;
                                data.diffAgreeNum -= 2;
                                data.agreeNum--;
                                data.disAgreeNum++;
                                AdThreadCommentAndPraiseInfoLayout.this.fmo.jV(false);
                                i = 0;
                            }
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.fmo.jV(false);
                            i = 0;
                        }
                        AdThreadCommentAndPraiseInfoLayout.this.Js(i);
                    }
                }
            };
            this.fmo.getImgAgree().setOnClickListener(onClickListener);
            this.fmo.getAgreeNumView().setOnClickListener(onClickListener);
            this.fmo.getImgDisagree().setOnClickListener(onClickListener2);
            this.fmo.getDisagreeNumView().setOnClickListener(onClickListener2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Js(int i) {
        if (i == 1) {
            a(this.mTQ.getThreadData(), "nozan", 0);
            a(this.mTQ.getThreadData(), "1", "2");
            return;
        }
        a(this.mTQ.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.mTQ.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void bD(View view) {
        if (this.aim != null && this.mContext != null && this.mTQ != null) {
            a(this.mTQ.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.mTQ.getThreadData(), "2", "1");
            if (ShareSwitch.isOn() || bg.checkUpIsLogin(this.mContext)) {
                final ShareItem shareItem = new ShareItem();
                shareItem.title = this.mTQ.getTitle();
                shareItem.content = this.mTQ.getAbstract();
                shareItem.fxm = this.mTQ.getTitle();
                shareItem.linkUrl = this.mTQ.getShareLink();
                shareItem.fxp = 3;
                shareItem.fxb = true;
                String imageUrl = this.mTQ.getImageUrl();
                Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        shareItem.linkUrl = g.eb(shareItem.linkUrl, shareItem.tid);
                        com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                        l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(R.string.copy_pb_url_success));
                    }
                });
                shareDialogConfig.setHideMode(Sg(shareItem.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.style = i;
    }

    public void setShareData(a aVar) {
        this.mTQ = aVar;
        setData(this.mTQ.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        c b2 = h.b(advertAppInfo, 8, i);
        b2.Sf(str);
        e.dFV().a(b2);
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
            }.execute(URL, gi(str3, "cpid"), gi(str3, "idea_id"));
        }
    }

    private String gi(String str, String str2) {
        try {
            return new JSONObject(new String(com.baidu.adp.lib.util.c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.fms;
    }

    private int Sg(String str) {
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
        this.fmr.setClickable(false);
        this.fmr.setEnabled(false);
        ao.setViewTextColor(this.fmq, this.mTO);
        ao.setViewTextColor(this.fmt, this.mTP);
    }

    public void setDisPraiseViewVisibility(boolean z) {
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.mTO = R.color.CAM_X0110;
        } else {
            this.mTO = R.drawable.selector_comment_and_prise_item_text_color;
        }
    }

    public void setPraiseContainerBgGray(boolean z) {
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.mTP = R.color.CAM_X0110;
        } else {
            this.mTP = R.drawable.selector_comment_and_prise_item_text_color;
        }
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void alF() {
        super.alF();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(fYY, 0, fYY, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(0, 0, 0, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(fYY, 0, fYY, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(0, 0, 0, 0);
        }
    }

    public void addAdMoreView(View view) {
        if (view != null) {
            this.fmw.setVisibility(0);
            this.fmw.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 21));
            this.fmw.addView(view);
        }
    }
}
