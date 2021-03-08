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
/* loaded from: classes7.dex */
public class AdThreadCommentAndPraiseInfoLayout extends ThreadCardBottomOpSegmentWeightLayout {
    public static String URL = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public static int fYf;
    private final int nbi;
    private final int nbj;
    private final int nbk;
    private final int nbl;
    private final int nbm;
    private int nbn;
    private int nbo;
    private a nbp;
    private int style;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.nbi = 446;
        this.nbj = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.nbk = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.nbl = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.nbm = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.style = 1;
        this.type = 0;
        this.nbn = R.drawable.selector_comment_and_prise_item_text_color;
        this.nbo = this.nbn;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nbi = 446;
        this.nbj = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.nbk = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.nbl = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.nbm = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.style = 1;
        this.type = 0;
        this.nbn = R.drawable.selector_comment_and_prise_item_text_color;
        this.nbo = this.nbn;
        initSetting();
    }

    private void initSetting() {
        fYf = l.getDimens(this.mContext, R.dimen.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(11);
        dEQ();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(cb cbVar) {
        if (cbVar != null) {
            this.flv.setAgreeAlone(true);
            if (this.flv.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) this.flv.getLayoutParams()).weight = 1.0f;
            }
            AgreeData bpL = cbVar.bpL();
            if (bpL != null && bpL.agreeNum == 0 && bpL.diffAgreeNum == 0) {
                bpL.agreeNum = cbVar.bps();
                bpL.hasAgree = cbVar.bpu() == 1;
                bpL.agreeType = cbVar.bpv();
                bpL.diffAgreeNum = cbVar.bps() - cbVar.bpt();
            }
        }
        super.updatePraiseNum(cbVar);
        if (this.flv != null) {
            this.flv.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type != 1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void D(cb cbVar) {
        super.D(cbVar);
        if (this.style == 1) {
            this.akL.setText(au.cutChineseAndEnglishWithSuffix(cbVar.bnW(), 12, ""));
        }
    }

    public void disableClick() {
        this.flB.setClickable(false);
        this.fly.setClickable(false);
    }

    private void dEQ() {
        if (this.flv != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.flv.getData();
                    if (data != null) {
                        AdThreadCommentAndPraiseInfoLayout.this.flv.getImgAgree().cancelAnimation();
                        if (data.hasAgree) {
                            if (data.agreeType == 2) {
                                data.agreeType = 2;
                                data.hasAgree = false;
                                data.diffAgreeNum--;
                                data.agreeNum--;
                                AdThreadCommentAndPraiseInfoLayout.this.flv.updateUI();
                            } else {
                                data.agreeType = 2;
                                data.hasAgree = true;
                                data.diffAgreeNum += 2;
                                data.agreeNum++;
                                data.disAgreeNum--;
                                AdThreadCommentAndPraiseInfoLayout.this.flv.jU(true);
                                i = 0;
                            }
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum++;
                            data.agreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.flv.jU(true);
                            i = 0;
                        }
                        AdThreadCommentAndPraiseInfoLayout.this.Ii(i);
                    }
                }
            };
            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.flv.getData();
                    if (data != null) {
                        AdThreadCommentAndPraiseInfoLayout.this.flv.getImgDisagree().cancelAnimation();
                        if (data.hasAgree) {
                            if (data.agreeType == 5) {
                                data.agreeType = 5;
                                data.hasAgree = false;
                                data.diffAgreeNum++;
                                data.disAgreeNum--;
                                AdThreadCommentAndPraiseInfoLayout.this.flv.updateUI();
                            } else {
                                data.agreeType = 5;
                                data.hasAgree = true;
                                data.diffAgreeNum -= 2;
                                data.agreeNum--;
                                data.disAgreeNum++;
                                AdThreadCommentAndPraiseInfoLayout.this.flv.jU(false);
                                i = 0;
                            }
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.flv.jU(false);
                            i = 0;
                        }
                        AdThreadCommentAndPraiseInfoLayout.this.Ii(i);
                    }
                }
            };
            this.flv.getImgAgree().setOnClickListener(onClickListener);
            this.flv.getAgreeNumView().setOnClickListener(onClickListener);
            this.flv.getImgDisagree().setOnClickListener(onClickListener2);
            this.flv.getDisagreeNumView().setOnClickListener(onClickListener2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ii(int i) {
        if (i == 1) {
            a(this.nbp.getThreadData(), "nozan", 0);
            a(this.nbp.getThreadData(), "1", "2");
            return;
        }
        a(this.nbp.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.nbp.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void bz(View view) {
        if (this.aiB != null && this.mContext != null && this.nbp != null) {
            a(this.nbp.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.nbp.getThreadData(), "2", "1");
            if (ShareSwitch.isOn() || bh.checkUpIsLogin(this.mContext)) {
                final ShareItem shareItem = new ShareItem();
                shareItem.title = this.nbp.getTitle();
                shareItem.content = this.nbp.getAbstract();
                shareItem.fwu = this.nbp.getTitle();
                shareItem.linkUrl = this.nbp.getShareLink();
                shareItem.fwx = 3;
                shareItem.fwj = true;
                String imageUrl = this.nbp.getImageUrl();
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
                shareDialogConfig.setHideMode(Sl(shareItem.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.style = i;
    }

    public void setShareData(a aVar) {
        this.nbp = aVar;
        setData(this.nbp.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        c b = h.b(advertAppInfo, 8, i);
        b.Sj(str);
        e.dEC().a(b);
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
        return this.fly;
    }

    private int Sl(String str) {
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
        this.flx.setClickable(false);
        this.flx.setEnabled(false);
        ap.setViewTextColor(this.flw, this.nbn);
        ap.setViewTextColor(this.flz, this.nbo);
    }

    public void setDisPraiseViewVisibility(boolean z) {
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.nbn = R.color.CAM_X0110;
        } else {
            this.nbn = R.drawable.selector_comment_and_prise_item_text_color;
        }
    }

    public void setPraiseContainerBgGray(boolean z) {
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.nbo = R.color.CAM_X0110;
        } else {
            this.nbo = R.drawable.selector_comment_and_prise_item_text_color;
        }
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void ain() {
        super.ain();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(fYf, 0, fYf, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(0, 0, 0, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(fYf, 0, fYf, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(0, 0, 0, 0);
        }
    }

    public void addAdMoreView(View view) {
        if (view != null) {
            this.flC.setVisibility(0);
            this.flC.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 21));
            this.flC.addView(view);
        }
    }
}
