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
import com.baidu.tbadk.core.data.cb;
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
import com.baidu.tieba.recapp.b.a;
import com.baidu.tieba.recapp.report.c;
import com.baidu.tieba.recapp.report.e;
import com.baidu.tieba.recapp.report.h;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class AdThreadCommentAndPraiseInfoLayout extends ThreadCardBottomOpSegmentWeightLayout {
    public static String URL = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public static int fWF;
    private final int mYX;
    private final int mYY;
    private final int mYZ;
    private final int mZa;
    private final int mZb;
    private int mZc;
    private int mZd;
    private a mZe;
    private int style;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.mYX = 446;
        this.mYY = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.mYZ = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.mZa = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.mZb = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.style = 1;
        this.type = 0;
        this.mZc = R.drawable.selector_comment_and_prise_item_text_color;
        this.mZd = this.mZc;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mYX = 446;
        this.mYY = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.mYZ = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.mZa = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.mZb = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.style = 1;
        this.type = 0;
        this.mZc = R.drawable.selector_comment_and_prise_item_text_color;
        this.mZd = this.mZc;
        initSetting();
    }

    private void initSetting() {
        fWF = l.getDimens(this.mContext, R.dimen.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(11);
        dEI();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(cb cbVar) {
        if (cbVar != null) {
            this.fjW.setAgreeAlone(true);
            if (this.fjW.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) this.fjW.getLayoutParams()).weight = 1.0f;
            }
            AgreeData bpJ = cbVar.bpJ();
            if (bpJ != null && bpJ.agreeNum == 0 && bpJ.diffAgreeNum == 0) {
                bpJ.agreeNum = cbVar.bpq();
                bpJ.hasAgree = cbVar.bps() == 1;
                bpJ.agreeType = cbVar.bpt();
                bpJ.diffAgreeNum = cbVar.bpq() - cbVar.bpr();
            }
        }
        super.updatePraiseNum(cbVar);
        if (this.fjW != null) {
            this.fjW.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type != 1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void D(cb cbVar) {
        super.D(cbVar);
        if (this.style == 1) {
            this.ajt.setText(au.cutChineseAndEnglishWithSuffix(cbVar.bnU(), 12, ""));
        }
    }

    public void disableClick() {
        this.fkc.setClickable(false);
        this.fjZ.setClickable(false);
    }

    private void dEI() {
        if (this.fjW != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.fjW.getData();
                    if (data != null) {
                        AdThreadCommentAndPraiseInfoLayout.this.fjW.getImgAgree().cancelAnimation();
                        if (data.hasAgree) {
                            if (data.agreeType == 2) {
                                data.agreeType = 2;
                                data.hasAgree = false;
                                data.diffAgreeNum--;
                                data.agreeNum--;
                                AdThreadCommentAndPraiseInfoLayout.this.fjW.updateUI();
                            } else {
                                data.agreeType = 2;
                                data.hasAgree = true;
                                data.diffAgreeNum += 2;
                                data.agreeNum++;
                                data.disAgreeNum--;
                                AdThreadCommentAndPraiseInfoLayout.this.fjW.jU(true);
                                i = 0;
                            }
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum++;
                            data.agreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.fjW.jU(true);
                            i = 0;
                        }
                        AdThreadCommentAndPraiseInfoLayout.this.Ie(i);
                    }
                }
            };
            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.fjW.getData();
                    if (data != null) {
                        AdThreadCommentAndPraiseInfoLayout.this.fjW.getImgDisagree().cancelAnimation();
                        if (data.hasAgree) {
                            if (data.agreeType == 5) {
                                data.agreeType = 5;
                                data.hasAgree = false;
                                data.diffAgreeNum++;
                                data.disAgreeNum--;
                                AdThreadCommentAndPraiseInfoLayout.this.fjW.updateUI();
                            } else {
                                data.agreeType = 5;
                                data.hasAgree = true;
                                data.diffAgreeNum -= 2;
                                data.agreeNum--;
                                data.disAgreeNum++;
                                AdThreadCommentAndPraiseInfoLayout.this.fjW.jU(false);
                                i = 0;
                            }
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.fjW.jU(false);
                            i = 0;
                        }
                        AdThreadCommentAndPraiseInfoLayout.this.Ie(i);
                    }
                }
            };
            this.fjW.getImgAgree().setOnClickListener(onClickListener);
            this.fjW.getAgreeNumView().setOnClickListener(onClickListener);
            this.fjW.getImgDisagree().setOnClickListener(onClickListener2);
            this.fjW.getDisagreeNumView().setOnClickListener(onClickListener2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ie(int i) {
        if (i == 1) {
            a(this.mZe.getThreadData(), "nozan", 0);
            a(this.mZe.getThreadData(), "1", "2");
            return;
        }
        a(this.mZe.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.mZe.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void bz(View view) {
        if (this.ahi != null && this.mContext != null && this.mZe != null) {
            a(this.mZe.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.mZe.getThreadData(), "2", "1");
            if (ShareSwitch.isOn() || bh.checkUpIsLogin(this.mContext)) {
                final ShareItem shareItem = new ShareItem();
                shareItem.title = this.mZe.getTitle();
                shareItem.content = this.mZe.getAbstract();
                shareItem.fuV = this.mZe.getTitle();
                shareItem.linkUrl = this.mZe.getShareLink();
                shareItem.fuY = 3;
                shareItem.fuK = true;
                String imageUrl = this.mZe.getImageUrl();
                Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        shareItem.linkUrl = g.dV(shareItem.linkUrl, shareItem.tid);
                        com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                        l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(R.string.copy_pb_url_success));
                    }
                });
                shareDialogConfig.setHideMode(Sf(shareItem.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.style = i;
    }

    public void setShareData(a aVar) {
        this.mZe = aVar;
        setData(this.mZe.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        c b2 = h.b(advertAppInfo, 8, i);
        b2.Sd(str);
        e.dEu().a(b2);
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
            }.execute(URL, go(str3, "cpid"), go(str3, "idea_id"));
        }
    }

    private String go(String str, String str2) {
        try {
            return new JSONObject(new String(com.baidu.adp.lib.util.c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.fjZ;
    }

    private int Sf(String str) {
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
        this.fjY.setClickable(false);
        this.fjY.setEnabled(false);
        ap.setViewTextColor(this.fjX, this.mZc);
        ap.setViewTextColor(this.fka, this.mZd);
    }

    public void setDisPraiseViewVisibility(boolean z) {
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.mZc = R.color.CAM_X0110;
        } else {
            this.mZc = R.drawable.selector_comment_and_prise_item_text_color;
        }
    }

    public void setPraiseContainerBgGray(boolean z) {
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.mZd = R.color.CAM_X0110;
        } else {
            this.mZd = R.drawable.selector_comment_and_prise_item_text_color;
        }
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void aik() {
        super.aik();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(fWF, 0, fWF, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(0, 0, 0, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(fWF, 0, fWF, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(0, 0, 0, 0);
        }
    }

    public void addAdMoreView(View view) {
        if (view != null) {
            this.fkd.setVisibility(0);
            this.fkd.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 21));
            this.fkd.addView(view);
        }
    }
}
