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
import com.baidu.tbadk.plugins.c;
import com.baidu.tbadk.s.az;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.recapp.c.a;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.report.b;
import com.baidu.tieba.recapp.report.f;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdThreadCommentAndPraiseInfoLayout extends NewThreadCommentAndPraiseInfoLayout {
    public static String URL = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public static int inB;
    private final int inC;
    private final int inD;
    private final int inE;
    private final int inF;
    private final int inG;
    private int inH;
    private int inI;
    private int inJ;
    private a inK;
    private int type;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.inC = 446;
        this.inD = 5120;
        this.inE = 5120;
        this.inF = 5120;
        this.inG = 5120;
        this.inH = 1;
        this.type = 0;
        this.inI = d.f.selector_comment_and_prise_item_text_color;
        this.inJ = this.inI;
        initSetting();
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.inC = 446;
        this.inD = 5120;
        this.inE = 5120;
        this.inF = 5120;
        this.inG = 5120;
        this.inH = 1;
        this.type = 0;
        this.inI = d.f.selector_comment_and_prise_item_text_color;
        this.inJ = this.inI;
        initSetting();
    }

    private void initSetting() {
        inB = l.h(this.mContext, d.e.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(9);
        this.bSA = false;
        bXL();
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bg bgVar) {
        AgreeData aaH;
        if (bgVar != null && (aaH = bgVar.aaH()) != null && aaH.agreeNum == 0 && aaH.diffAgreeNum == 0) {
            aaH.agreeNum = bgVar.aak();
            aaH.hasAgree = bgVar.aam() == 1;
            aaH.agreeType = bgVar.aan();
            aaH.diffAgreeNum = bgVar.aak() - bgVar.aal();
        }
        super.updatePraiseNum(bgVar);
        if (this.bSc != null) {
            this.bSc.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.type == 1 && this.bNr != null && this.bSw) {
            if (this.bNr.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bNr.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.bNr.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.bNr.getImageView();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.bRY;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void o(bg bgVar) {
        super.o(bgVar);
        if (this.type == 1 && this.bSC && this.bSi.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSi.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.bRY;
            layoutParams.weight = 0.0f;
            this.bSi.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.core.view.NewThreadCommentAndPraiseInfoLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void p(bg bgVar) {
        super.p(bgVar);
        if (this.type == 1 && this.bSf != null && this.bSA) {
            this.bSf.setVisibility(0);
            if (this.bSf.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSf.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.bRY;
                layoutParams.weight = 0.0f;
                this.bSf.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void t(bg bgVar) {
        super.t(bgVar);
        if (this.inH == 1) {
            this.bRZ.setText(ap.g(bgVar.YW(), 12, ""));
        }
    }

    public void disableClick() {
        this.bNr.setClickable(false);
        this.bSi.setClickable(false);
        this.bSf.setClickable(false);
    }

    private void bXL() {
        if (this.bSc != null) {
            this.bSc.getImgAgree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.bSc.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 2) {
                            data.agreeType = 2;
                            data.hasAgree = false;
                            data.diffAgreeNum--;
                            data.agreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.bSc.GR();
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum += 2;
                            data.agreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.bSc.dH(true);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum++;
                        data.agreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.bSc.dH(true);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.ye(i);
                }
            });
            this.bSc.getImgDisagree().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = 1;
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.bSc.getData();
                    if (data.hasAgree) {
                        if (data.agreeType == 5) {
                            data.agreeType = 5;
                            data.hasAgree = false;
                            data.diffAgreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.bSc.GR();
                        } else {
                            data.agreeType = 5;
                            data.hasAgree = true;
                            data.diffAgreeNum -= 2;
                            data.agreeNum--;
                            data.disAgreeNum++;
                            AdThreadCommentAndPraiseInfoLayout.this.bSc.dH(false);
                            i = 0;
                        }
                    } else {
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum--;
                        data.disAgreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.bSc.dH(false);
                        i = 0;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.ye(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ye(int i) {
        if (i == 1) {
            a(this.inK.getThreadData(), "nozan", 0);
            a(this.inK.getThreadData(), "1", "2");
            return;
        }
        a(this.inK.getThreadData(), FeedData.TYPE_ZAN, 0);
        a(this.inK.getThreadData(), "1", "1");
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aM(View view) {
        int i = 0;
        if (bc.cZ(this.mContext) && this.XR != null) {
            if (this.XR.aam() != 0) {
                a(this.inK.getThreadData(), "nozan", 0);
                a(this.inK.getThreadData(), "1", "2");
                this.XR.af(this.XR.aak() - 1);
                this.XR.gy(0);
                this.bNr.bOg = d.C0236d.cp_cont_f;
                this.bNr.bOh = d.C0236d.cp_cont_f;
                i = 1;
            } else {
                a(this.inK.getThreadData(), FeedData.TYPE_ZAN, 0);
                a(this.inK.getThreadData(), "1", "1");
                this.XR.gy(1);
                this.XR.af(this.XR.aak() + 1);
                this.bNr.bOg = d.C0236d.cp_cont_h;
                this.bNr.bOh = d.C0236d.cp_cont_h;
            }
            if (this.inK instanceof AdCard) {
                ((AdCard) this.inK).agree_num = this.XR.aak();
            }
            updatePraiseNum(this.XR);
            this.bNr.hE(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aJ(View view) {
        if (this.XR != null && this.mContext != null && this.inK != null) {
            a(this.inK.getThreadData(), TbConfig.TMP_SHARE_DIR_NAME, 0);
            a(this.inK.getThreadData(), "2", "1");
            if ((az.jK() || bc.cZ(this.mContext)) && c.b(this.mPageContext, "com.baidu.tieba.pluginCore")) {
                final com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                dVar.title = this.inK.getTitle();
                dVar.content = this.inK.getAbstract();
                dVar.cby = this.inK.getTitle();
                dVar.linkUrl = this.inK.getShareLink();
                dVar.cbB = 3;
                dVar.cbm = true;
                String imageUrl = this.inK.getImageUrl();
                Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
                if (parse != null) {
                    dVar.imageUri = parse;
                }
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        dVar.linkUrl = e.bQ(dVar.linkUrl, dVar.tid);
                        com.baidu.adp.lib.util.a.bh(dVar.linkUrl);
                        l.showToast(AdThreadCommentAndPraiseInfoLayout.this.mContext, view2.getResources().getString(d.j.copy_pb_url_success));
                    }
                });
                shareDialogConfig.setHideMode(BU(dVar.linkUrl));
                MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
            }
        }
    }

    public void setStyle(int i) {
        this.inH = i;
    }

    public void setShareData(a aVar) {
        this.inK = aVar;
        setData(this.inK.getThreadData());
    }

    private void a(AdvertAppInfo advertAppInfo, String str, int i) {
        b c = f.c(advertAppInfo, 8, i);
        c.BT(str);
        com.baidu.tieba.recapp.report.c.bXB().a(c);
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
                        xVar.x("cpid", strArr[1]);
                        xVar.x("idea_id", strArr[2]);
                        xVar.x("type", str);
                        xVar.x(IntentConfig.CMD, str2);
                        xVar.acj();
                        return null;
                    }
                    return null;
                }
            }.execute(URL, dN(str3, "cpid"), dN(str3, "idea_id"));
        }
    }

    private String dN(String str, String str2) {
        try {
            return new JSONObject(new String(com.baidu.adp.lib.util.c.decode(str))).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.bSf;
    }

    private int BU(String str) {
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
        al.j(this.bSd, this.inI);
        al.j(this.bSg, this.inJ);
    }

    public void setDisPraiseViewVisibility(boolean z) {
        if (this.bNs != null) {
            this.bNs.setVisibility(z ? 0 : 8);
        }
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.inI = d.C0236d.cp_cont_e;
            this.bSJ = d.f.icon_home_card_comment_s;
            return;
        }
        this.inI = d.f.selector_comment_and_prise_item_text_color;
        this.bSJ = d.f.icon_home_card_comment;
    }

    private boolean aed() {
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.afX();
    }

    public void setPraiseContainerBgGray(boolean z) {
        if (this.bNr != null) {
            if (com.baidu.tbadk.util.a.apM().afN()) {
                if (z) {
                    this.bNr.bOe = d.f.icon_card_like_d;
                    this.bNr.bOf = d.f.icon_card_like_d;
                    this.bNr.bOg = d.C0236d.cp_cont_e;
                    this.bNr.bOh = d.C0236d.cp_cont_e;
                    return;
                }
                this.bNr.bOe = d.f.icon_card_like_n;
                this.bNr.bOf = d.f.icon_card_like_s;
                if (this.XR != null && this.XR.aam() == 1) {
                    this.bNr.bOg = d.f.selector_comment_and_prise_item_text_color;
                    this.bNr.bOh = d.C0236d.cp_cont_h;
                    return;
                }
                this.bNr.bOg = d.f.selector_comment_and_prise_item_text_color;
                this.bNr.bOh = d.f.selector_comment_and_prise_item_text_color;
            } else if (z) {
                this.bNr.bOe = d.f.icon_home_card_like_d;
                this.bNr.bOf = d.f.icon_home_card_like_d;
                this.bNr.bOg = d.C0236d.cp_cont_e;
                this.bNr.bOh = d.C0236d.cp_cont_e;
            } else {
                this.bNr.bOe = aed() ? d.f.icon_home_card_like_n_xmas : d.f.icon_home_card_like_n;
                this.bNr.bOf = aed() ? d.f.icon_home_card_like_s_xmas : d.f.icon_home_card_like_s;
                if (this.XR != null && this.XR.aam() == 1) {
                    this.bNr.bOg = d.f.selector_comment_and_prise_item_text_color;
                    this.bNr.bOh = d.C0236d.cp_cont_h;
                    return;
                }
                this.bNr.bOg = d.f.selector_comment_and_prise_item_text_color;
                this.bNr.bOh = d.f.selector_comment_and_prise_item_text_color;
            }
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.bSK = d.f.icon_card_share_s;
            this.inJ = d.C0236d.cp_cont_e;
            return;
        }
        this.bSK = d.f.icon_home_card_share;
        this.inJ = d.f.selector_comment_and_prise_item_text_color;
    }

    public void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void aeY() {
        super.aeY();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                layoutParams2.setMargins(inB, 0, inB, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(inB, 0, inB, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.type == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                layoutParams3.setMargins(inB, 0, inB, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(inB, 0, inB, 0);
        }
    }
}
