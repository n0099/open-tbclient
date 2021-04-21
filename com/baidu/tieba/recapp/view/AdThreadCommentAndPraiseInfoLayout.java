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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import d.b.c.e.p.c;
import d.b.c.e.p.l;
import d.b.i0.r.q.a2;
import d.b.i0.s.g.g;
import d.b.j0.s2.b0.a;
import d.b.j0.s2.f0.e;
import d.b.j0.s2.f0.h;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AdThreadCommentAndPraiseInfoLayout extends ThreadCardBottomOpSegmentWeightLayout {
    public static int q0 = 0;
    public static String r0 = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public int l0;
    public int m0;
    public int n0;
    public int o0;
    public a p0;

    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.l0 = 1;
        this.m0 = 0;
        int i = R.drawable.selector_comment_and_prise_item_text_color;
        this.n0 = i;
        this.o0 = i;
        m0();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void B(View view) {
        a aVar;
        if (this.E == null || this.F == null || (aVar = this.p0) == null) {
            return;
        }
        p0(aVar.getThreadData(), "share", 0);
        q0(this.p0.getThreadData(), "2", "1");
        if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.F)) {
            final ShareItem shareItem = new ShareItem();
            shareItem.r = this.p0.getTitle();
            shareItem.s = this.p0.getAbstract();
            shareItem.C = this.p0.getTitle();
            shareItem.t = this.p0.getShareLink();
            shareItem.E = 3;
            shareItem.f13386f = true;
            String imageUrl = this.p0.getImageUrl();
            Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
            if (parse != null) {
                shareItem.v = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.F, shareItem, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    ShareItem shareItem2 = shareItem;
                    shareItem2.t = g.o(shareItem2.t, shareItem2.J);
                    d.b.c.e.p.a.a(shareItem.t);
                    l.L(AdThreadCommentAndPraiseInfoLayout.this.F, view2.getResources().getString(R.string.copy_pb_url_success));
                }
            });
            shareDialogConfig.setHideMode(j0(shareItem.t));
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void G(a2 a2Var) {
        super.G(a2Var);
        if (this.l0 == 1) {
            this.f13160f.setText(StringHelper.cutChineseAndEnglishWithSuffix(a2Var.i0(), 12, ""));
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void J() {
        super.J();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.m0 == 1) {
                layoutParams2.width = -2;
                layoutParams2.addRule(11);
                int i = q0;
                layoutParams2.setMargins(i, 0, i, 0);
                return;
            }
            layoutParams2.width = -1;
            layoutParams2.setMargins(0, 0, 0, 0);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            if (this.m0 == 1) {
                layoutParams3.width = -2;
                layoutParams3.gravity = 5;
                int i2 = q0;
                layoutParams3.setMargins(i2, 0, i2, 0);
                return;
            }
            layoutParams3.width = -1;
            layoutParams3.setMargins(0, 0, 0, 0);
        }
    }

    public void addAdMoreView(View view) {
        if (view == null) {
            return;
        }
        this.p.setVisibility(0);
        this.p.removeAllViews();
        view.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 21));
        this.p.addView(view);
    }

    public void disableClick() {
        this.o.setClickable(false);
        this.l.setClickable(false);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        return this.l;
    }

    public final int j0(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int length = str.length();
        int i = length > 5120 ? 1 : 0;
        if (length > 5120) {
            i |= 2;
        }
        if (length > 5120) {
            i |= 4;
        }
        if (length > 5120) {
            i |= 8;
        }
        return length > 446 ? i | 16 : i;
    }

    public final String l0(String str, String str2) {
        try {
            return new JSONObject(new String(c.d(str))).getString(str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final void m0() {
        q0 = l.g(this.F, R.dimen.tbds44);
        setManageVisible(false);
        setSelectVisible(false);
        setShowFlag(11);
        o0();
    }

    public final void n0(int i) {
        if (i == 1) {
            p0(this.p0.getThreadData(), "nozan", 0);
            q0(this.p0.getThreadData(), "1", "2");
            return;
        }
        p0(this.p0.getThreadData(), FeedData.TYPE_ZAN, 0);
        q0(this.p0.getThreadData(), "1", "1");
    }

    public final void o0() {
        if (this.f13162h != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.f13162h.getData();
                    if (data == null) {
                        return;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.f13162h.getImgAgree().cancelAnimation();
                    int i = 0;
                    if (data.hasAgree) {
                        if (data.agreeType == 2) {
                            data.agreeType = 2;
                            data.hasAgree = false;
                            data.diffAgreeNum--;
                            data.agreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.f13162h.y();
                            i = 1;
                        } else {
                            data.agreeType = 2;
                            data.hasAgree = true;
                            data.diffAgreeNum += 2;
                            data.agreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.f13162h.z(true);
                        }
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum++;
                        data.agreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.f13162h.z(true);
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.n0(i);
                }
            };
            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AgreeData data = AdThreadCommentAndPraiseInfoLayout.this.f13162h.getData();
                    if (data == null) {
                        return;
                    }
                    AdThreadCommentAndPraiseInfoLayout.this.f13162h.getImgDisagree().cancelAnimation();
                    int i = 1;
                    if (data.hasAgree) {
                        if (data.agreeType == 5) {
                            data.agreeType = 5;
                            data.hasAgree = false;
                            data.diffAgreeNum++;
                            data.disAgreeNum--;
                            AdThreadCommentAndPraiseInfoLayout.this.f13162h.y();
                            AdThreadCommentAndPraiseInfoLayout.this.n0(i);
                        }
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum -= 2;
                        data.agreeNum--;
                        data.disAgreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.f13162h.z(false);
                    } else {
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum--;
                        data.disAgreeNum++;
                        AdThreadCommentAndPraiseInfoLayout.this.f13162h.z(false);
                    }
                    i = 0;
                    AdThreadCommentAndPraiseInfoLayout.this.n0(i);
                }
            };
            this.f13162h.getImgAgree().setOnClickListener(onClickListener);
            this.f13162h.getAgreeNumView().setOnClickListener(onClickListener);
            this.f13162h.getImgDisagree().setOnClickListener(onClickListener2);
            this.f13162h.getDisagreeNumView().setOnClickListener(onClickListener2);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onChangeSkinType() {
        super.onChangeSkinType();
        this.j.setClickable(false);
        this.j.setEnabled(false);
        SkinManager.setViewTextColor(this.i, this.n0);
        SkinManager.setViewTextColor(this.m, this.o0);
    }

    public final void p0(AdvertAppInfo advertAppInfo, String str, int i) {
        d.b.j0.s2.f0.c b2 = h.b(advertAppInfo, 8, i);
        b2.c(str);
        e.b().d(b2);
    }

    public final void q0(AdvertAppInfo advertAppInfo, final String str, final String str2) {
        if (advertAppInfo != null) {
            String str3 = advertAppInfo.T3;
            new BdAsyncTask<String, Void, Void>() { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    if (strArr == null || strArr.length <= 0) {
                        return null;
                    }
                    NetWork netWork = new NetWork(strArr[0]);
                    netWork.addPostData("cpid", strArr[1]);
                    netWork.addPostData("idea_id", strArr[2]);
                    netWork.addPostData("type", str);
                    netWork.addPostData("cmd", str2);
                    netWork.postNetData();
                    return null;
                }
            }.execute(r0, l0(str3, "cpid"), l0(str3, "idea_id"));
        }
    }

    public void setDisPraiseViewVisibility(boolean z) {
    }

    public void setPraiseContainerBgGray(boolean z) {
    }

    public void setReplayContainerBgGray(boolean z) {
        if (z) {
            this.n0 = R.color.CAM_X0110;
        } else {
            this.n0 = R.drawable.selector_comment_and_prise_item_text_color;
        }
    }

    public void setShareContainerBgGray(boolean z) {
        if (z) {
            this.o0 = R.color.CAM_X0110;
        } else {
            this.o0 = R.drawable.selector_comment_and_prise_item_text_color;
        }
    }

    public void setShareData(a aVar) {
        this.p0 = aVar;
        setData(aVar.getThreadData());
    }

    public void setStyle(int i) {
        this.l0 = i;
    }

    public void setType(int i) {
        this.m0 = i;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(a2 a2Var) {
        if (a2Var != null) {
            this.f13162h.setAgreeAlone(true);
            if (this.f13162h.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) this.f13162h.getLayoutParams()).weight = 1.0f;
            }
            AgreeData L = a2Var.L();
            if (L != null && L.agreeNum == 0 && L.diffAgreeNum == 0) {
                L.agreeNum = a2Var.M();
                L.hasAgree = a2Var.m0() == 1;
                L.agreeType = a2Var.N();
                L.diffAgreeNum = a2Var.M() - a2Var.a0();
            }
        }
        super.updatePraiseNum(a2Var);
        AgreeView agreeView = this.f13162h;
        if (agreeView != null) {
            agreeView.t(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.m0 != 1) {
        }
    }

    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l0 = 1;
        this.m0 = 0;
        int i = R.drawable.selector_comment_and_prise_item_text_color;
        this.n0 = i;
        this.o0 = i;
        m0();
    }
}
