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
    public static int iFS;
    private final int iFT;
    private final int iFU;
    private final int iFV;
    private final int iFW;
    private final int iFX;
    private int iFY;
    private int iFZ;
    private int iGa;
    private a iGb;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.iFT = 446;
        this.iFU = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iFV = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iFW = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iFX = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iFY = 1;
        this.type = 0;
        this.iFZ = R.drawable.selector_comment_and_prise_item_text_color;
        this.iGa = this.iFZ;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iFT = 446;
        this.iFU = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iFV = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iFW = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iFX = Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
        this.iFY = 1;
        this.type = 0;
        this.iFZ = R.drawable.selector_comment_and_prise_item_text_color;
        this.iGa = this.iFZ;
        initSetting();
    }

    private void initSetting() {
        iFS = l.g(this.mContext, R.dimen.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(9);
        this.caw = false;
        cfO();
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
        if (this.bZY != null) {
            this.bZY.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type == 1 && this.bVg != null && this.cas) {
            if (this.bVg.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVg.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.bVg.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.bVg.getImageView();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.bZU;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void o(bg bgVar) {
        super.o(bgVar);
        if (this.type == 1 && this.cay && this.cae.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cae.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.bZU;
            layoutParams.weight = 0.0f;
            this.cae.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void p(bg bgVar) {
        super.p(bgVar);
        if (this.type == 1 && this.cab != null && this.caw) {
            this.cab.setVisibility(0);
            if (this.cab.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cab.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.bZU;
                layoutParams.weight = 0.0f;
                this.cab.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void t(bg bgVar) {
        super.t(bgVar);
        if (this.iFY == 1) {
            this.bZV.setText(ap.j(bgVar.adA(), 12, ""));
        }
    }

    public void disableClick() {
        this.bVg.setClickable(false);
        this.cae.setClickable(false);
        this.cab.setClickable(false);
    }

    private void cfO() {
        if (this.bZY != null) {
            this.bZY.getImgAgree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.bZY.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 2) {
                            data.agreeType = 2;
                            data.hasAgree = false;
                            data.diffAgreeNum--;
                            data.agreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.bZY.Jf();
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum += 2;
                            data.agreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.bZY.ed(true);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum++;
                        data.agreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.bZY.ed(true);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.zh(i);
                }
            });
            this.bZY.getImgDisagree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.bZY.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 5) {
                            data.agreeType = 5;
                            data.hasAgree = false;
                            data.diffAgreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.bZY.Jf();
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum -= 2;
                            data.agreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.bZY.ed(false);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum--;
                        data.disAgreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.bZY.ed(false);
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
            a(this.iGb.getThreadData(), "nozan", 0);
            a(this.iGb.getThreadData(), "1", "2");
            return;
        }
        a(this.iGb.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.iGb.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aS(View view) {
        int i = 0;
        if (bc.cE(this.mContext) && this.VK != null) {
            if (this.VK.aeQ() != 0) {
                a(this.iGb.getThreadData(), "nozan", 0);
                a(this.iGb.getThreadData(), "1", "2");
                this.VK.ar(this.VK.aeO() - 1);
                this.VK.hj(0);
                this.bVg.bVY = R.color.cp_cont_f;
                this.bVg.bVZ = R.color.cp_cont_f;
                i = 1;
            } else {
                a(this.iGb.getThreadData(), FeedData.TYPE_ZAN, 0);
                a(this.iGb.getThreadData(), "1", "1");
                this.VK.hj(1);
                this.VK.ar(this.VK.aeO() + 1);
                this.bVg.bVY = R.color.cp_cont_h;
                this.bVg.bVZ = R.color.cp_cont_h;
            }
            if (this.iGb instanceof AdCard) {
                ((AdCard) this.iGb).agree_num = this.VK.aeO();
            }
            updatePraiseNum(this.VK);
            this.bVg.ir(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aP(View view) {
        if (this.VK != null && this.mContext != null && this.iGb != null) {
            a(this.iGb.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.iGb.getThreadData(), "2", "1");
            if (bf.iE() || bc.cE(this.mContext)) {
                final e eVar = new e();
                eVar.title = this.iGb.getTitle();
                eVar.content = this.iGb.getAbstract();
                eVar.cjC = this.iGb.getTitle();
                eVar.linkUrl = this.iGb.getShareLink();
                eVar.cjF = 3;
                eVar.cjp = true;
                String imageUrl = this.iGb.getImageUrl();
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
                shareDialogConfig.setHideMode(Do(eVar.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.iFY = i;
    }

    public void setShareData(a aVar) {
        this.iGb = aVar;
        setData(this.iGb.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        b c = com.baidu.tieba.recapp.report.f.c(advertAppInfo, 8, i);
        c.Dn(str);
        c.cfE().a(c);
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
        return this.cab;
    }

    private int Do(String str) {
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
        al.j(this.bZZ, this.iFZ);
        al.j(this.cac, this.iGa);
    }

    public void setDisPraiseViewVisibility(boolean z) {
        if (this.bVh != null) {
            this.bVh.setVisibility(z ? 0 : 8);
        }
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.iFZ = R.color.cp_cont_e;
            this.caF = R.drawable.icon_home_card_comment_s;
            return;
        }
        this.iFZ = R.drawable.selector_comment_and_prise_item_text_color;
        this.caF = R.drawable.icon_home_card_comment;
    }

    private boolean aiZ() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.akT();
    }

    public void setPraiseContainerBgGray(boolean z) {
        if (this.bVg != null) {
            if (com.baidu.tbadk.util.a.auN().akJ()) {
                if (z) {
                    this.bVg.bVW = R.drawable.icon_card_like_d;
                    this.bVg.bVX = R.drawable.icon_card_like_d;
                    this.bVg.bVY = R.color.cp_cont_e;
                    this.bVg.bVZ = R.color.cp_cont_e;
                    return;
                }
                this.bVg.bVW = R.drawable.icon_card_like_n;
                this.bVg.bVX = R.drawable.icon_card_like_s;
                if (this.VK != null && this.VK.aeQ() == 1) {
                    this.bVg.bVY = R.drawable.selector_comment_and_prise_item_text_color;
                    this.bVg.bVZ = R.color.cp_cont_h;
                    return;
                }
                this.bVg.bVY = R.drawable.selector_comment_and_prise_item_text_color;
                this.bVg.bVZ = R.drawable.selector_comment_and_prise_item_text_color;
            } else if (z) {
                this.bVg.bVW = R.drawable.icon_home_card_like_d;
                this.bVg.bVX = R.drawable.icon_home_card_like_d;
                this.bVg.bVY = R.color.cp_cont_e;
                this.bVg.bVZ = R.color.cp_cont_e;
            } else {
                this.bVg.bVW = aiZ() ? R.drawable.icon_home_card_like_n_xmas : R.drawable.icon_home_card_like_n;
                this.bVg.bVX = aiZ() ? R.drawable.icon_home_card_like_s_xmas : R.drawable.icon_home_card_like_s;
                if (this.VK != null && this.VK.aeQ() == 1) {
                    this.bVg.bVY = R.drawable.selector_comment_and_prise_item_text_color;
                    this.bVg.bVZ = R.color.cp_cont_h;
                    return;
                }
                this.bVg.bVY = R.drawable.selector_comment_and_prise_item_text_color;
                this.bVg.bVZ = R.drawable.selector_comment_and_prise_item_text_color;
            }
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.caG = R.drawable.icon_card_share_s;
            this.iGa = R.color.cp_cont_e;
            return;
        }
        this.caG = R.drawable.icon_home_card_share;
        this.iGa = R.drawable.selector_comment_and_prise_item_text_color;
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
                layoutParams2.setMargins(iFS, 0, iFS, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(iFS, 0, iFS, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(iFS, 0, iFS, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(iFS, 0, iFS, 0);
        }
    }
}
