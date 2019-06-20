package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.l;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.coreExtra.c.f;
import com.baidu.tbadk.t.bf;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.recapp.c.a;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.report.b;
import com.baidu.tieba.recapp.report.c;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdThreadCommentAndPraiseInfoLayout extends NewThreadCommentAndPraiseInfoLayout {
    public static String URL = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public static int iFV;
    private final int iFW;
    private final int iFX;
    private final int iFY;
    private final int iFZ;
    private final int iGa;
    private int iGb;
    private int iGc;
    private int iGd;
    private a iGe;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.iFW = 446;
        this.iFX = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iFY = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iFZ = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iGa = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iGb = 1;
        this.type = 0;
        this.iGc = R.drawable.selector_comment_and_prise_item_text_color;
        this.iGd = this.iGc;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iFW = 446;
        this.iFX = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iFY = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iFZ = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iGa = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iGb = 1;
        this.type = 0;
        this.iGc = R.drawable.selector_comment_and_prise_item_text_color;
        this.iGd = this.iGc;
        initSetting();
    }

    private void initSetting() {
        iFV = l.g(this.mContext, R.dimen.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(9);
        this.cax = false;
        cfR();
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bg bgVar) {
        AgreeData afl;
        if (bgVar != null && (afl = bgVar.afl()) != null && afl.agreeNum == 0 && afl.diffAgreeNum == 0) {
            afl.agreeNum = bgVar.aeO();
            afl.hasAgree = bgVar.aeQ() == 1;
            afl.agreeType = bgVar.aeR();
            afl.diffAgreeNum = bgVar.aeO() - bgVar.aeP();
        }
        super.updatePraiseNum(bgVar);
        if (this.bZZ != null) {
            this.bZZ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type == 1 && this.bVh != null && this.cat) {
            if (this.bVh.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVh.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.bVh.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.bVh.getImageView();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.bZV;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void o(bg bgVar) {
        super.o(bgVar);
        if (this.type == 1 && this.caz && this.caf.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caf.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.bZV;
            layoutParams.weight = 0.0f;
            this.caf.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void p(bg bgVar) {
        super.p(bgVar);
        if (this.type == 1 && this.cac != null && this.cax) {
            this.cac.setVisibility(0);
            if (this.cac.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cac.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.bZV;
                layoutParams.weight = 0.0f;
                this.cac.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void t(bg bgVar) {
        super.t(bgVar);
        if (this.iGb == 1) {
            this.bZW.setText(ap.j(bgVar.adA(), 12, ""));
        }
    }

    public void disableClick() {
        this.bVh.setClickable(false);
        this.caf.setClickable(false);
        this.cac.setClickable(false);
    }

    private void cfR() {
        if (this.bZZ != null) {
            this.bZZ.getImgAgree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.bZZ.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 2) {
                            data.agreeType = 2;
                            data.hasAgree = false;
                            data.diffAgreeNum--;
                            data.agreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.bZZ.Jf();
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum += 2;
                            data.agreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.bZZ.ed(true);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum++;
                        data.agreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.bZZ.ed(true);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.zh(i);
                }
            });
            this.bZZ.getImgDisagree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.bZZ.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 5) {
                            data.agreeType = 5;
                            data.hasAgree = false;
                            data.diffAgreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.bZZ.Jf();
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum -= 2;
                            data.agreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.bZZ.ed(false);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum--;
                        data.disAgreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.bZZ.ed(false);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.zh(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh(int i) {
        if (i == 1) {
            a(this.iGe.getThreadData(), "nozan", 0);
            a(this.iGe.getThreadData(), "1", "2");
            return;
        }
        a(this.iGe.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.iGe.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aS(View view) {
        int i = 0;
        if (bc.cE(this.mContext) && this.VJ != null) {
            if (this.VJ.aeQ() != 0) {
                a(this.iGe.getThreadData(), "nozan", 0);
                a(this.iGe.getThreadData(), "1", "2");
                this.VJ.ar(this.VJ.aeO() - 1);
                this.VJ.hj(0);
                this.bVh.bVZ = R.color.cp_cont_f;
                this.bVh.bWa = R.color.cp_cont_f;
                i = 1;
            } else {
                a(this.iGe.getThreadData(), FeedData.TYPE_ZAN, 0);
                a(this.iGe.getThreadData(), "1", "1");
                this.VJ.hj(1);
                this.VJ.ar(this.VJ.aeO() + 1);
                this.bVh.bVZ = R.color.cp_cont_h;
                this.bVh.bWa = R.color.cp_cont_h;
            }
            if (this.iGe instanceof AdCard) {
                ((AdCard) this.iGe).agree_num = this.VJ.aeO();
            }
            updatePraiseNum(this.VJ);
            this.bVh.ir(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aP(View view) {
        if (this.VJ != null && this.mContext != null && this.iGe != null) {
            a(this.iGe.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.iGe.getThreadData(), "2", "1");
            if (bf.iE() || bc.cE(this.mContext)) {
                final e eVar = new e();
                eVar.title = this.iGe.getTitle();
                eVar.content = this.iGe.getAbstract();
                eVar.cjD = this.iGe.getTitle();
                eVar.linkUrl = this.iGe.getShareLink();
                eVar.cjG = 3;
                eVar.cjq = true;
                String imageUrl = this.iGe.getImageUrl();
                Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
                if (parse != null) {
                    eVar.imageUri = parse;
                }
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, eVar, true, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        eVar.linkUrl = f.ca(eVar.linkUrl, eVar.tid);
                        com.baidu.adp.lib.util.a.aR(eVar.linkUrl);
                        l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(R.string.copy_pb_url_success));
                    }
                });
                shareDialogConfig.setHideMode(Dq(eVar.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.iGb = i;
    }

    public void setShareData(a aVar) {
        this.iGe = aVar;
        setData(this.iGe.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 8, i);
        c.Dp(str);
        c.cfH().a(c);
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
                        xVar.o("cpid", strArr[1]);
                        xVar.o("idea_id", strArr[2]);
                        xVar.o("type", str);
                        xVar.o(IntentConfig.CMD, str2);
                        xVar.ahe();
                        return null;
                    }
                    return null;
                }
            }.execute(URL, eb(str3, "cpid"), eb(str3, "idea_id"));
        }
    }

    private String eb(String str, String str2) {
        try {
            return new JSONObject(new String(com.baidu.adp.lib.util.c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.cac;
    }

    private int Dq(String str) {
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
        al.j(this.caa, this.iGc);
        al.j(this.cad, this.iGd);
    }

    public void setDisPraiseViewVisibility(boolean z) {
        if (this.bVi != null) {
            this.bVi.setVisibility(z ? 0 : 8);
        }
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.iGc = R.color.cp_cont_e;
            this.caG = R.drawable.icon_home_card_comment_s;
            return;
        }
        this.iGc = R.drawable.selector_comment_and_prise_item_text_color;
        this.caG = R.drawable.icon_home_card_comment;
    }

    private boolean aiZ() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.akT();
    }

    public void setPraiseContainerBgGray(boolean z) {
        if (this.bVh != null) {
            if (com.baidu.tbadk.util.a.auN().akJ()) {
                if (z) {
                    this.bVh.bVX = R.drawable.icon_card_like_d;
                    this.bVh.bVY = R.drawable.icon_card_like_d;
                    this.bVh.bVZ = R.color.cp_cont_e;
                    this.bVh.bWa = R.color.cp_cont_e;
                    return;
                }
                this.bVh.bVX = R.drawable.icon_card_like_n;
                this.bVh.bVY = R.drawable.icon_card_like_s;
                if (this.VJ != null && this.VJ.aeQ() == 1) {
                    this.bVh.bVZ = R.drawable.selector_comment_and_prise_item_text_color;
                    this.bVh.bWa = R.color.cp_cont_h;
                    return;
                }
                this.bVh.bVZ = R.drawable.selector_comment_and_prise_item_text_color;
                this.bVh.bWa = R.drawable.selector_comment_and_prise_item_text_color;
            } else if (z) {
                this.bVh.bVX = R.drawable.icon_home_card_like_d;
                this.bVh.bVY = R.drawable.icon_home_card_like_d;
                this.bVh.bVZ = R.color.cp_cont_e;
                this.bVh.bWa = R.color.cp_cont_e;
            } else {
                this.bVh.bVX = aiZ() ? R.drawable.icon_home_card_like_n_xmas : R.drawable.icon_home_card_like_n;
                this.bVh.bVY = aiZ() ? R.drawable.icon_home_card_like_s_xmas : R.drawable.icon_home_card_like_s;
                if (this.VJ != null && this.VJ.aeQ() == 1) {
                    this.bVh.bVZ = R.drawable.selector_comment_and_prise_item_text_color;
                    this.bVh.bWa = R.color.cp_cont_h;
                    return;
                }
                this.bVh.bVZ = R.drawable.selector_comment_and_prise_item_text_color;
                this.bVh.bWa = R.drawable.selector_comment_and_prise_item_text_color;
            }
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.caH = R.drawable.icon_card_share_s;
            this.iGd = R.color.cp_cont_e;
            return;
        }
        this.caH = R.drawable.icon_home_card_share;
        this.iGd = R.drawable.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void ajU() {
        super.ajU();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(iFV, 0, iFV, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(iFV, 0, iFV, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(iFV, 0, iFV, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(iFV, 0, iFV, 0);
        }
    }
}
